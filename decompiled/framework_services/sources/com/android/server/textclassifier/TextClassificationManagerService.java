package com.android.server.textclassifier;

import android.app.RemoteAction;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.graphics.drawable.Icon;
import android.hardware.audio.common.V2_0.AudioFormat;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.os.RemoteException;
import android.os.UserHandle;
import android.provider.DeviceConfig;
import android.service.textclassifier.ITextClassifierCallback;
import android.service.textclassifier.ITextClassifierService;
import android.service.textclassifier.TextClassifierService;
import android.text.TextUtils;
import android.util.LruCache;
import android.util.Slog;
import android.util.SparseArray;
import android.view.textclassifier.ConversationAction;
import android.view.textclassifier.ConversationActions;
import android.view.textclassifier.SelectionEvent;
import android.view.textclassifier.SystemTextClassifierMetadata;
import android.view.textclassifier.TextClassification;
import android.view.textclassifier.TextClassificationConstants;
import android.view.textclassifier.TextClassificationContext;
import android.view.textclassifier.TextClassificationManager;
import android.view.textclassifier.TextClassificationSessionId;
import android.view.textclassifier.TextClassifierEvent;
import android.view.textclassifier.TextLanguage;
import android.view.textclassifier.TextLinks;
import android.view.textclassifier.TextSelection;
import com.android.internal.content.PackageMonitor;
import com.android.internal.util.DumpUtils;
import com.android.internal.util.FunctionalUtils;
import com.android.internal.util.IndentingPrintWriter;
import com.android.internal.util.Preconditions;
import com.android.server.SystemService;
import com.android.server.timezonedetector.ServiceConfigAccessor;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes3.dex */
public final class TextClassificationManagerService extends ITextClassifierService.Stub {
    private static final boolean DEBUG = false;
    private static final String LOG_TAG = "TextClassificationManagerService";
    private static final ITextClassifierCallback NO_OP_CALLBACK = null;
    private final Context mContext;
    private final String mDefaultTextClassifierPackage;
    private final Object mLock;
    private final MyPackageMonitor mPackageMonitor;
    private final SessionCache mSessionCache;
    private final TextClassificationConstants mSettings;
    private final TextClassifierSettingsListener mSettingsListener;
    private final String mSystemTextClassifierPackage;
    final SparseArray<UserState> mUserStates;

    private static final class CallbackWrapper extends ITextClassifierCallback.Stub {
        private final ITextClassifierCallback mWrapped;

        CallbackWrapper(ITextClassifierCallback wrapped) {
            wrapped.getClass();
            this.mWrapped = wrapped;
        }

        public void onSuccess(Bundle result) {
            Parcelable parcelled = TextClassifierService.getResponse(result);
            if ((parcelled instanceof TextClassification) == false) goto L6;
            rewriteTextClassificationIcons(result);
        L16:
            this.mWrapped.onSuccess(result);     // Catch: RemoteException -> L13
            return;
        L13:
            e = move-exception;
            Slog.e(TextClassificationManagerService.LOG_TAG, "Callback error", e);
            return;
        L6:
            if ((parcelled instanceof ConversationActions) == false) goto L9;
            rewriteConversationActionsIcons(result);
            goto L16
        L9:
            if ((parcelled instanceof TextSelection) == false) goto L16;
            rewriteTextSelectionIcons(result);
            goto L16
        }

        private static void rewriteTextSelectionIcons(Bundle result) {
            TextSelection textSelection = (TextSelection) TextClassifierService.getResponse(result);
            if (textSelection.getTextClassification() != null) goto L5;
            return;
        L5:
            TextClassification newTextClassification = rewriteTextClassificationIcons(textSelection.getTextClassification());
            if (newTextClassification != null) goto L8;
            return;
        L8:
            TextClassifierService.putResponse(result, textSelection.toBuilder().setTextClassification(newTextClassification).build());
        }

        private static TextClassification rewriteTextClassificationIcons(TextClassification textClassification) {
            boolean rewrite = false;
            List<RemoteAction> actions = textClassification.getActions();
            int size = actions.size();
            List<RemoteAction> validActions = new ArrayList(size);
            int i = 0;
        L3:
            if (i >= size) goto L10;
            RemoteAction action = actions.get(i);
            if (shouldRewriteIcon(action) == false) goto L7;
            rewrite = true;
            RemoteAction validAction = validAction(action);
        L8:
            validActions.add(validAction);
            i = i + 1;
            goto L3
        L7:
            validAction = action;
            goto L8
        L10:
            if (rewrite == true) goto L17;
            return null;
        L17:
            return textClassification.toBuilder().clearActions().addActions(validActions).build();
        }

        private static void rewriteTextClassificationIcons(Bundle result) {
            TextClassification classification = (TextClassification) TextClassifierService.getResponse(result);
            TextClassification newTextClassification = rewriteTextClassificationIcons(classification);
            if (newTextClassification == null) goto L6;
            TextClassifierService.putResponse(result, newTextClassification);
            return;
        }

        private static void rewriteConversationActionsIcons(Bundle result) {
            ConversationActions convActions = (ConversationActions) TextClassifierService.getResponse(result);
            boolean rewrite = false;
            List<ConversationAction> origConvActions = convActions.getConversationActions();
            int size = origConvActions.size();
            List<ConversationAction> validConvActions = new ArrayList(size);
            int i = 0;
        L3:
            if (i >= size) goto L10;
            ConversationAction convAction = origConvActions.get(i);
            if (shouldRewriteIcon(convAction.getAction()) == false) goto L7;
            rewrite = true;
            ConversationAction validConvAction = convAction.toBuilder().setAction(validAction(convAction.getAction())).build();
        L8:
            validConvActions.add(validConvAction);
            i = i + 1;
            goto L3
        L7:
            validConvAction = convAction;
            goto L8
        L10:
            if (rewrite == false) goto L16;
            TextClassifierService.putResponse(result, new ConversationActions(validConvActions, convActions.getId()));
            return;
        }

        private static RemoteAction validAction(RemoteAction action) {
            RemoteAction newAction = new RemoteAction(changeIcon(action.getIcon()), action.getTitle(), action.getContentDescription(), action.getActionIntent());
            newAction.setEnabled(action.isEnabled());
            newAction.setShouldShowIcon(action.shouldShowIcon());
            return newAction;
        }

        private static boolean shouldRewriteIcon(RemoteAction action) {
            if (action != null) goto L4;
        L6:
            return false;
        L4:
            if (action.getIcon().getType() != 2) goto L6;
            return true;
        }

        private static Icon changeIcon(Icon icon) {
            Uri uri = IconsUriHelper.getInstance().getContentUri(icon.getResPackage(), icon.getResId());
            return Icon.createWithContentUri(uri);
        }

        public void onFailure() {
            this.mWrapped.onFailure();     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            Slog.e(TextClassificationManagerService.LOG_TAG, "Callback error", e);
        }
    }

    public static final class Lifecycle extends SystemService {
        private final TextClassificationManagerService mManagerService;

        public Lifecycle(Context context) {
            super(context);
            this.mManagerService = new TextClassificationManagerService(context, null);
        }

        @Override // com.android.server.SystemService
        public void onStart() {
            publishBinderService("textclassification", this.mManagerService);     // Catch: Throwable -> L4
            TextClassificationManagerService.m8481$$Nest$mstartListenSettings(this.mManagerService);     // Catch: Throwable -> L4
            this.mManagerService.startTrackingPackageChanges();     // Catch: Throwable -> L4
            return;
        L4:
            t = move-exception;
            Slog.e(TextClassificationManagerService.LOG_TAG, "Could not start the TextClassificationManagerService.", t);
        }

        @Override // com.android.server.SystemService
        public void onUserStarting(SystemService.TargetUser user) {
            updatePackageStateForUser(user.getUserIdentifier());
            processAnyPendingWork(user.getUserIdentifier());
        }

        @Override // com.android.server.SystemService
        public void onUserUnlocking(SystemService.TargetUser user) {
            updatePackageStateForUser(user.getUserIdentifier());
            processAnyPendingWork(user.getUserIdentifier());
        }

        private void processAnyPendingWork(int userId) {
            Object r0 = TextClassificationManagerService.m8475$$Nest$fgetmLock(this.mManagerService);
            monitor-enter(r0);
            TextClassificationManagerService.m8478$$Nest$mgetUserStateLocked(this.mManagerService, userId).bindIfHasPendingRequestsLocked();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        private void updatePackageStateForUser(int userId) {
            Object r0 = TextClassificationManagerService.m8475$$Nest$fgetmLock(this.mManagerService);
            monitor-enter(r0);
            UserState.m8499$$Nest$mupdatePackageStateLocked(TextClassificationManagerService.m8478$$Nest$mgetUserStateLocked(this.mManagerService, userId));     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.SystemService
        public void onUserStopping(SystemService.TargetUser user) {
            int userId = user.getUserIdentifier();
            Object r1 = TextClassificationManagerService.m8475$$Nest$fgetmLock(this.mManagerService);
            monitor-enter(r1);
            UserState userState = this.mManagerService.peekUserStateLocked(userId);     // Catch: Throwable -> L7
            if (userState == null) goto L9;
            userState.cleanupServiceLocked();     // Catch: Throwable -> L7
            this.mManagerService.mUserStates.remove(userId);     // Catch: Throwable -> L7
        L9:
            monitor-exit(r1);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }
    }

    private class MyPackageMonitor extends PackageMonitor {
        final /* synthetic */ TextClassificationManagerService this$0;

        /* synthetic */ MyPackageMonitor(TextClassificationManagerService r1, TextClassificationManagerServiceIA r2) {
            this(r1);
        }

        private MyPackageMonitor(TextClassificationManagerService r1) {
            this.this$0 = r1;
        }

        public void onPackageAdded(String packageName, int uid) {
            notifyPackageInstallStatusChange(packageName, true);
        }

        public void onPackageRemoved(String packageName, int uid) {
            notifyPackageInstallStatusChange(packageName, false);
        }

        public void onPackageModified(String packageName) {
            int userId = getChangingUserId();
            Object r1 = TextClassificationManagerService.m8475$$Nest$fgetmLock(this.this$0);
            monitor-enter(r1);
            UserState userState = TextClassificationManagerService.m8478$$Nest$mgetUserStateLocked(this.this$0, userId);     // Catch: Throwable -> L7
            ServiceState serviceState = UserState.m8498$$Nest$mgetServiceStateLocked(userState, packageName);     // Catch: Throwable -> L7
            if (serviceState == null) goto L9;
            ServiceState.m8494$$Nest$monPackageModifiedLocked(serviceState);     // Catch: Throwable -> L7
        L9:
            monitor-exit(r1);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        private void notifyPackageInstallStatusChange(String packageName, boolean installed) {
            int userId = getChangingUserId();
            Object r1 = TextClassificationManagerService.m8475$$Nest$fgetmLock(this.this$0);
            monitor-enter(r1);
            UserState userState = TextClassificationManagerService.m8478$$Nest$mgetUserStateLocked(this.this$0, userId);     // Catch: Throwable -> L7
            ServiceState serviceState = UserState.m8498$$Nest$mgetServiceStateLocked(userState, packageName);     // Catch: Throwable -> L7
            if (serviceState == null) goto L9;
            ServiceState.m8493$$Nest$monPackageInstallStatusChangeLocked(serviceState, installed);     // Catch: Throwable -> L7
        L9:
            monitor-exit(r1);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }
    }

    private static final class PendingRequest implements IBinder.DeathRecipient {
        private final IBinder mBinder;
        private final String mName;
        private final Runnable mOnServiceFailure;
        private final Runnable mRequest;
        private final TextClassificationManagerService mService;
        private final ServiceState mServiceState;
        private final int mUid;

        /* JADX INFO: renamed from: -$$Nest$fgetmBinder, reason: not valid java name */
        static /* bridge */ /* synthetic */ IBinder m8483$$Nest$fgetmBinder(PendingRequest r0) {
            return r0.mBinder;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmName, reason: not valid java name */
        static /* bridge */ /* synthetic */ String m8484$$Nest$fgetmName(PendingRequest r0) {
            return r0.mName;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmOnServiceFailure, reason: not valid java name */
        static /* bridge */ /* synthetic */ Runnable m8485$$Nest$fgetmOnServiceFailure(PendingRequest r0) {
            return r0.mOnServiceFailure;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmRequest, reason: not valid java name */
        static /* bridge */ /* synthetic */ Runnable m8486$$Nest$fgetmRequest(PendingRequest r0) {
            return r0.mRequest;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmUid, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m8487$$Nest$fgetmUid(PendingRequest r0) {
            return r0.mUid;
        }

        PendingRequest(String name, FunctionalUtils.ThrowingRunnable request, FunctionalUtils.ThrowingRunnable onServiceFailure, IBinder binder, TextClassificationManagerService service, ServiceState serviceState, int uid) {
            this.mName = name;
            request.getClass();
            this.mRequest = TextClassificationManagerService.m8482$$Nest$smlogOnFailure(request, "handling pending request");
            onServiceFailure.getClass();
            this.mOnServiceFailure = TextClassificationManagerService.m8482$$Nest$smlogOnFailure(onServiceFailure, "notifying callback of service failure");
            this.mBinder = binder;
            this.mService = service;
            serviceState.getClass();
            this.mServiceState = serviceState;
            if (this.mBinder != null) goto L10;
        L8:
            this.mUid = uid;
            return;
        L10:
            this.mBinder.linkToDeath(this, 0);     // Catch: RemoteException -> L6
        L6:
            e = move-exception;
            e.printStackTrace();
            goto L8
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            Object r0 = TextClassificationManagerService.m8475$$Nest$fgetmLock(this.mService);
            monitor-enter(r0);
            removeLocked();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        private void removeLocked() {
            this.mServiceState.mPendingRequests.remove(this);
            if (this.mBinder == null) goto L6;
            this.mBinder.unlinkToDeath(this, 0);
            return;
        }
    }

    private final class ServiceState {
        private static final int MAX_PENDING_REQUESTS = 20;
        final int mBindServiceFlags;
        boolean mBinding;
        ComponentName mBoundComponentName;
        int mBoundServiceUid;
        final TextClassifierServiceConnection mConnection;
        boolean mEnabled;
        boolean mInstalled;
        final boolean mIsTrusted;
        final String mPackageName;
        final FixedSizeQueue<PendingRequest> mPendingRequests;
        ITextClassifierService mService;
        final int mUserId;
        final /* synthetic */ TextClassificationManagerService this$0;

        private final class TextClassifierServiceConnection implements ServiceConnection {
            private final int mUserId;
            final /* synthetic */ ServiceState this$1;

            TextClassifierServiceConnection(ServiceState r1, int userId) {
                this.this$1 = r1;
                this.mUserId = userId;
            }

            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName name, IBinder service) {
                ITextClassifierService tcService = ITextClassifierService.Stub.asInterface(service);
                tcService.onConnectedStateChanged(0);     // Catch: RemoteException -> L5
            L7:
                init(tcService, name);
                return;
            L6:
                Slog.e(TextClassificationManagerService.LOG_TAG, "error in onConnectedStateChanged");
                goto L7
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName name) {
                Slog.i(TextClassificationManagerService.LOG_TAG, "onServiceDisconnected called with " + name);
                cleanupService();
            }

            @Override // android.content.ServiceConnection
            public void onBindingDied(ComponentName name) {
                Slog.i(TextClassificationManagerService.LOG_TAG, "onBindingDied called with " + name);
                cleanupService();
            }

            @Override // android.content.ServiceConnection
            public void onNullBinding(ComponentName name) {
                Slog.i(TextClassificationManagerService.LOG_TAG, "onNullBinding called with " + name);
                cleanupService();
            }

            void cleanupService() {
                init(null, null);
            }

            private void init(ITextClassifierService service, ComponentName name) {
                Object r0 = TextClassificationManagerService.m8475$$Nest$fgetmLock(this.this$1.this$0);
                monitor-enter(r0);
                this.this$1.mService = service;     // Catch: Throwable -> L7
                this.this$1.mBinding = false;     // Catch: Throwable -> L7
                ServiceState.m8496$$Nest$mupdateServiceInfoLocked(this.this$1, this.mUserId, name);     // Catch: Throwable -> L7
                ServiceState.m8492$$Nest$mhandlePendingRequestsLocked(this.this$1);     // Catch: Throwable -> L7
                monitor-exit(r0);     // Catch: Throwable -> L7
                return;
            L7:
                th = move-exception;
                throw th;
            }
        }

        public static /* synthetic */ void $r8$lambda$lFi143DqZSbhhmVtEuC32EM_pP8(PendingRequest r0) {
            lambda$new$0(r0);
        }

        /* JADX INFO: renamed from: -$$Nest$mbindIfHasPendingRequestsLocked, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m8488$$Nest$mbindIfHasPendingRequestsLocked(ServiceState r0) {
            return r0.bindIfHasPendingRequestsLocked();
        }

        /* JADX INFO: renamed from: -$$Nest$mbindLocked, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m8489$$Nest$mbindLocked(ServiceState r0) {
            return r0.bindLocked();
        }

        /* JADX INFO: renamed from: -$$Nest$mcheckRequestAcceptedLocked, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m8490$$Nest$mcheckRequestAcceptedLocked(ServiceState r0, int r1, String r2) {
            return r0.checkRequestAcceptedLocked(r1, r2);
        }

        /* JADX INFO: renamed from: -$$Nest$mdump, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m8491$$Nest$mdump(ServiceState r0, IndentingPrintWriter r1) {
            r0.dump(r1);
        }

        /* JADX INFO: renamed from: -$$Nest$mhandlePendingRequestsLocked, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m8492$$Nest$mhandlePendingRequestsLocked(ServiceState r0) {
            r0.handlePendingRequestsLocked();
        }

        /* JADX INFO: renamed from: -$$Nest$monPackageInstallStatusChangeLocked, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m8493$$Nest$monPackageInstallStatusChangeLocked(ServiceState r0, boolean r1) {
            r0.onPackageInstallStatusChangeLocked(r1);
        }

        /* JADX INFO: renamed from: -$$Nest$monPackageModifiedLocked, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m8494$$Nest$monPackageModifiedLocked(ServiceState r0) {
            r0.onPackageModifiedLocked();
        }

        /* JADX INFO: renamed from: -$$Nest$mupdatePackageStateLocked, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m8495$$Nest$mupdatePackageStateLocked(ServiceState r0) {
            r0.updatePackageStateLocked();
        }

        /* JADX INFO: renamed from: -$$Nest$mupdateServiceInfoLocked, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m8496$$Nest$mupdateServiceInfoLocked(ServiceState r0, int r1, ComponentName r2) {
            r0.updateServiceInfoLocked(r1, r2);
        }

        /* synthetic */ ServiceState(TextClassificationManagerService r1, int r2, String r3, boolean r4, TextClassificationManagerServiceIA r5) {
            this(r1, r2, r3, r4);
        }

        private static /* synthetic */ void lambda$new$0(PendingRequest request) {
            Slog.w(TextClassificationManagerService.LOG_TAG, String.format("Pending request[%s] is dropped", new Object[]{PendingRequest.m8484$$Nest$fgetmName(request)}));
            PendingRequest.m8485$$Nest$fgetmOnServiceFailure(request).run();
        }

        private ServiceState(TextClassificationManagerService r3, int userId, String packageName, boolean isTrusted) {
            this.this$0 = r3;
            this.mPendingRequests = new FixedSizeQueue(20, new TextClassificationManagerService$ServiceState$$ExternalSyntheticLambda0());
            this.mBoundComponentName = null;
            this.mBoundServiceUid = -1;
            this.mUserId = userId;
            this.mPackageName = packageName;
            this.mConnection = new TextClassifierServiceConnection(this, this.mUserId);
            this.mIsTrusted = isTrusted;
            this.mBindServiceFlags = createBindServiceFlags(packageName);
            this.mInstalled = isPackageInstalledForUser();
            this.mEnabled = isServiceEnabledForUser();
        }

        private int createBindServiceFlags(String packageName) {
            if (packageName.equals(TextClassificationManagerService.m8474$$Nest$fgetmDefaultTextClassifierPackage(this.this$0)) == true) goto L6;
            int flags = 67108865 | 2097152;
            return flags;
        L6:
            return AudioFormat.AAC_MAIN;
        }

        private boolean isPackageInstalledForUser() {
            PackageManager packageManager = TextClassificationManagerService.m8473$$Nest$fgetmContext(this.this$0).getPackageManager();     // Catch: PackageManager.NameNotFoundException -> L7
            if (packageManager.getPackageInfoAsUser(this.mPackageName, 0, this.mUserId) == null) goto L11;
            return true;
        L11:
            return false;
        L8:
            return false;
        }

        private boolean isServiceEnabledForUser() {
            PackageManager packageManager = TextClassificationManagerService.m8473$$Nest$fgetmContext(this.this$0).getPackageManager();
            Intent intent = new Intent("android.service.textclassifier.TextClassifierService");
            intent.setPackage(this.mPackageName);
            ResolveInfo resolveInfo = packageManager.resolveServiceAsUser(intent, 4, this.mUserId);
            if (resolveInfo != null) goto L5;
            ServiceInfo serviceInfo = null;
        L6:
            if (serviceInfo == null) goto L8;
            return true;
        L8:
            return false;
        L5:
            serviceInfo = resolveInfo.serviceInfo;
            goto L6
        }

        private void onPackageInstallStatusChangeLocked(boolean installed) {
            this.mInstalled = installed;
        }

        private void onPackageModifiedLocked() {
            this.mEnabled = isServiceEnabledForUser();
        }

        private void updatePackageStateLocked() {
            this.mInstalled = isPackageInstalledForUser();
            this.mEnabled = isServiceEnabledForUser();
        }

        boolean isInstalledLocked() {
            return this.mInstalled;
        }

        boolean isEnabledLocked() {
            return this.mEnabled;
        }

        boolean isBoundLocked() {
            if (this.mService == null) goto L5;
            return true;
        L5:
            return false;
        }

        private void handlePendingRequestsLocked() {
        L2:
            PendingRequest request = this.mPendingRequests.poll();
            if (request == null) goto L14;
            if (isBoundLocked() == true) goto L7;
            Slog.d(TextClassificationManagerService.LOG_TAG, "Unable to bind TextClassifierService for PendingRequest " + PendingRequest.m8484$$Nest$fgetmName(request));
            PendingRequest.m8485$$Nest$fgetmOnServiceFailure(request).run();
        L12:
            if (PendingRequest.m8483$$Nest$fgetmBinder(request) == null) goto L2;
            PendingRequest.m8483$$Nest$fgetmBinder(request).unlinkToDeath(request, 0);
            goto L2
        L7:
            if (checkRequestAcceptedLocked(PendingRequest.m8487$$Nest$fgetmUid(request), PendingRequest.m8484$$Nest$fgetmName(request)) == true) goto L9;
            Slog.w(TextClassificationManagerService.LOG_TAG, String.format("UID %d is not allowed to see the %s request", new Object[]{Integer.valueOf(PendingRequest.m8487$$Nest$fgetmUid(request)), PendingRequest.m8484$$Nest$fgetmName(request)}));
            PendingRequest.m8485$$Nest$fgetmOnServiceFailure(request).run();
            goto L12
        L9:
            PendingRequest.m8486$$Nest$fgetmRequest(request).run();
            goto L12
        }

        private boolean bindIfHasPendingRequestsLocked() {
            if (this.mPendingRequests.isEmpty() == false) goto L5;
        L7:
            return false;
        L5:
            if (bindLocked() == false) goto L7;
            return true;
        }

        void unbindIfBoundLocked() {
            if (isBoundLocked() == false) goto L6;
            Slog.v(TextClassificationManagerService.LOG_TAG, "Unbinding " + this.mBoundComponentName + " for " + this.mUserId);
            TextClassificationManagerService.m8473$$Nest$fgetmContext(this.this$0).unbindService(this.mConnection);
            this.mConnection.cleanupService();
            return;
        }

        private boolean bindLocked() {
            if (isBoundLocked() == false) goto L5;
            return true;
        L5:
            if (this.mBinding == true) goto L26;
            long identity = Binder.clearCallingIdentity();
            ComponentName componentName = getTextClassifierServiceComponent();     // Catch: Throwable -> L15
            if (componentName != null) goto L12;
            Binder.restoreCallingIdentity(identity);
            return false;
        L12:
            Intent serviceIntent = new Intent("android.service.textclassifier.TextClassifierService").setComponent(componentName);     // Catch: Throwable -> L15
            Slog.d(TextClassificationManagerService.LOG_TAG, "Binding to " + serviceIntent.getComponent());     // Catch: Throwable -> L15
            boolean willBind = TextClassificationManagerService.m8473$$Nest$fgetmContext(this.this$0).bindServiceAsUser(serviceIntent, this.mConnection, this.mBindServiceFlags, UserHandle.of(this.mUserId));     // Catch: Throwable -> L15
            if (willBind == true) goto L17;
            Slog.e(TextClassificationManagerService.LOG_TAG, "Could not bind to " + componentName);     // Catch: Throwable -> L15
        L17:
            this.mBinding = willBind;     // Catch: Throwable -> L15
            Binder.restoreCallingIdentity(identity);
            return willBind;
        L15:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        L26:
            return true;
        }

        private ComponentName getTextClassifierServiceComponent() {
            Context r0 = TextClassificationManagerService.m8473$$Nest$fgetmContext(this.this$0);
            String r1 = this.mPackageName;
            if (this.mIsTrusted == false) goto L5;
            int r2 = 1048576;
        L7:
            return TextClassifierService.getServiceComponentName(r0, r1, r2);
        L5:
            r2 = 0;
            goto L7
        }

        private void dump(IndentingPrintWriter pw) {
            pw.printPair("context", TextClassificationManagerService.m8473$$Nest$fgetmContext(this.this$0));
            pw.printPair("userId", Integer.valueOf(this.mUserId));
            Object r0 = TextClassificationManagerService.m8475$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            pw.printPair("packageName", this.mPackageName);     // Catch: Throwable -> L7
            pw.printPair("installed", Boolean.valueOf(this.mInstalled));     // Catch: Throwable -> L7
            pw.printPair(ServiceConfigAccessor.PROVIDER_MODE_ENABLED, Boolean.valueOf(this.mEnabled));     // Catch: Throwable -> L7
            pw.printPair("boundComponentName", this.mBoundComponentName);     // Catch: Throwable -> L7
            pw.printPair("isTrusted", Boolean.valueOf(this.mIsTrusted));     // Catch: Throwable -> L7
            pw.printPair("bindServiceFlags", Integer.valueOf(this.mBindServiceFlags));     // Catch: Throwable -> L7
            pw.printPair("boundServiceUid", Integer.valueOf(this.mBoundServiceUid));     // Catch: Throwable -> L7
            pw.printPair("binding", Boolean.valueOf(this.mBinding));     // Catch: Throwable -> L7
            pw.printPair("numOfPendingRequests", Integer.valueOf(this.mPendingRequests.size()));     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        private boolean checkRequestAcceptedLocked(int requestUid, String methodName) {
            if (this.mIsTrusted == false) goto L5;
            return true;
        L5:
            if (requestUid == this.mBoundServiceUid) goto L11;
            Slog.w(TextClassificationManagerService.LOG_TAG, String.format("[%s] Non-default TextClassifierServices may only see text from the same uid.", new Object[]{methodName}));
            return false;
        L11:
            return true;
        }

        private void updateServiceInfoLocked(int userId, ComponentName componentName) {
            this.mBoundComponentName = componentName;
            if (this.mBoundComponentName != null) goto L5;
            int r0 = -1;
        L6:
            this.mBoundServiceUid = r0;
            return;
        L5:
            r0 = TextClassificationManagerService.m8480$$Nest$mresolvePackageToUid(this.this$0, this.mBoundComponentName.getPackageName(), userId);
            goto L6
        }
    }

    static final class SessionCache {
        private static final int MAX_CACHE_SIZE = 100;
        private final LruCache<IBinder, StrippedTextClassificationContext> mCache;
        private final IBinder.DeathRecipient mDeathRecipient;
        private final Object mLock;

        /* JADX INFO: renamed from: -$$Nest$fgetmDeathRecipient, reason: not valid java name */
        static /* bridge */ /* synthetic */ IBinder.DeathRecipient m8497$$Nest$fgetmDeathRecipient(SessionCache r0) {
            return r0.mDeathRecipient;
        }

        SessionCache(Object lock) {
            this.mDeathRecipient = new AnonymousClass1(this);
            final int r1 = 100;
            this.mCache = new AnonymousClass2(this, r1);
            lock.getClass();
            this.mLock = lock;
        }

        void put(TextClassificationSessionId sessionId, TextClassificationContext textClassificationContext) {
            Object r0 = this.mLock;
            monitor-enter(r0);
            this.mCache.put(sessionId.getToken(), new StrippedTextClassificationContext(textClassificationContext));     // Catch: Throwable -> L7
            sessionId.getToken().linkToDeath(this.mDeathRecipient, 0);     // Catch: Throwable -> L7 RemoteException -> L9
        L11:
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L9:
            e = move-exception;
            Slog.w(TextClassificationManagerService.LOG_TAG, "SessionCache: Failed to link to death", e);     // Catch: Throwable -> L7
        L7:
            th = move-exception;
            throw th;
        }

        StrippedTextClassificationContext get(IBinder token) {
            token.getClass();
            Object r0 = this.mLock;
            monitor-enter(r0);
            StrippedTextClassificationContext r1 = this.mCache.get(token);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        void remove(IBinder token) {
            token.getClass();
            Object r0 = this.mLock;
            monitor-enter(r0);
            token.unlinkToDeath(this.mDeathRecipient, 0);     // Catch: Throwable -> L6 NoSuchElementException -> L8
        L6:
            th = move-exception;
            throw th;
        L9:
            this.mCache.remove(token);     // Catch: Throwable -> L6
            monitor-exit(r0);     // Catch: Throwable -> L6
        }

        int size() {
            Object r0 = this.mLock;
            monitor-enter(r0);
            int r1 = this.mCache.size();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }
    }

    static class StrippedTextClassificationContext {
        public final boolean useDefaultTextClassifier;
        public final int userId;

        StrippedTextClassificationContext(TextClassificationContext textClassificationContext) {
            SystemTextClassifierMetadata sysTcMetadata = textClassificationContext.getSystemTextClassifierMetadata();
            this.userId = sysTcMetadata.getUserId();
            this.useDefaultTextClassifier = sysTcMetadata.useDefaultTextClassifier();
        }
    }

    private final class TextClassifierSettingsListener implements DeviceConfig.OnPropertiesChangedListener {
        private final Context mContext;
        private String mServicePackageOverride;
        final /* synthetic */ TextClassificationManagerService this$0;

        TextClassifierSettingsListener(TextClassificationManagerService r1, Context context) {
            this.this$0 = r1;
            this.mContext = context;
            this.mServicePackageOverride = TextClassificationManagerService.m8476$$Nest$fgetmSettings(r1).getTextClassifierServicePackageOverride();
        }

        void registerObserver() {
            DeviceConfig.addOnPropertiesChangedListener("textclassifier", this.mContext.getMainExecutor(), this);
        }

        public void onPropertiesChanged(DeviceConfig.Properties properties) {
            String currentServicePackageOverride = TextClassificationManagerService.m8476$$Nest$fgetmSettings(this.this$0).getTextClassifierServicePackageOverride();
            if (TextUtils.equals(currentServicePackageOverride, this.mServicePackageOverride) == false) goto L5;
            return;
        L5:
            this.mServicePackageOverride = currentServicePackageOverride;
            TextClassificationManagerService.m8479$$Nest$monTextClassifierServicePackageOverrideChanged(this.this$0, currentServicePackageOverride);
        }
    }

    private final class UserState {
        private final ServiceState mDefaultServiceState;
        private final ServiceState mSystemServiceState;
        private ServiceState mUntrustedServiceState;
        final int mUserId;
        final /* synthetic */ TextClassificationManagerService this$0;

        /* JADX INFO: renamed from: -$$Nest$mgetServiceStateLocked, reason: not valid java name */
        static /* bridge */ /* synthetic */ ServiceState m8498$$Nest$mgetServiceStateLocked(UserState r0, String r1) {
            return r0.getServiceStateLocked(r1);
        }

        /* JADX INFO: renamed from: -$$Nest$mupdatePackageStateLocked, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m8499$$Nest$mupdatePackageStateLocked(UserState r0) {
            r0.updatePackageStateLocked();
        }

        /* synthetic */ UserState(TextClassificationManagerService r1, int r2, TextClassificationManagerServiceIA r3) {
            this(r1, r2);
        }

        private UserState(TextClassificationManagerService r10, int userId) {
            this.this$0 = r10;
            this.mUserId = userId;
            ServiceState r1 = null;
            if (TextUtils.isEmpty(TextClassificationManagerService.m8474$$Nest$fgetmDefaultTextClassifierPackage(r10)) == false) goto L5;
            TextClassificationManagerService r3 = r10;
            int userId2 = userId;
            ServiceState r2 = null;
        L6:
            this.mDefaultServiceState = r2;
            if (TextUtils.isEmpty(TextClassificationManagerService.m8477$$Nest$fgetmSystemTextClassifierPackage(r3)) == true) goto L10;
            int userId3 = userId2;
            TextClassificationManagerService r4 = r3;
            r1 = new ServiceState(r4, userId3, TextClassificationManagerService.m8477$$Nest$fgetmSystemTextClassifierPackage(r4), true, null);
        L10:
            this.mSystemServiceState = r1;
            return;
        L5:
            r3 = r10;
            userId2 = userId;
            r2 = new ServiceState(r3, userId2, TextClassificationManagerService.m8474$$Nest$fgetmDefaultTextClassifierPackage(r10), true, null);
            goto L6
        }

        ServiceState getServiceStateLocked(boolean useDefaultTextClassifier) {
            if (useDefaultTextClassifier == true) goto L4;
            final TextClassificationConstants r0 = TextClassificationManagerService.m8476$$Nest$fgetmSettings(this.this$0);
            r0.getClass();
            String textClassifierServicePackageOverride = (String) Binder.withCleanCallingIdentity(new TextClassificationManagerService$UserState$$ExternalSyntheticLambda0(r0));
            if (TextUtils.isEmpty(textClassifierServicePackageOverride) == true) goto L23;
            if (textClassifierServicePackageOverride.equals(TextClassificationManagerService.m8474$$Nest$fgetmDefaultTextClassifierPackage(this.this$0)) == false) goto L12;
            return this.mDefaultServiceState;
        L12:
            if (textClassifierServicePackageOverride.equals(TextClassificationManagerService.m8477$$Nest$fgetmSystemTextClassifierPackage(this.this$0)) == false) goto L18;
            if (this.mSystemServiceState == null) goto L18;
            return this.mSystemServiceState;
        L18:
            if (this.mUntrustedServiceState != null) goto L21;
            this.mUntrustedServiceState = new ServiceState(this.this$0, this.mUserId, textClassifierServicePackageOverride, false, null);
        L21:
            return this.mUntrustedServiceState;
        L23:
            if (this.mSystemServiceState == null) goto L26;
            return this.mSystemServiceState;
        L26:
            return this.mDefaultServiceState;
        L4:
            return this.mDefaultServiceState;
        }

        void onTextClassifierServicePackageOverrideChangedLocked(String overriddenPackageName) {
            Iterator<ServiceState> r0 = getAllServiceStatesLocked().iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            ServiceState serviceState = r0.next();
            serviceState.unbindIfBoundLocked();
            goto L4
        L6:
            this.mUntrustedServiceState = null;
        }

        void bindIfHasPendingRequestsLocked() {
            Iterator<ServiceState> r0 = getAllServiceStatesLocked().iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            ServiceState serviceState = r0.next();
            ServiceState.m8488$$Nest$mbindIfHasPendingRequestsLocked(serviceState);
            goto L4
        }

        void cleanupServiceLocked() {
            Iterator<ServiceState> r0 = getAllServiceStatesLocked().iterator();
        L4:
            if (r0.hasNext() == false) goto L9;
            ServiceState serviceState = r0.next();
            if (serviceState.mConnection == null) goto L4;
            serviceState.mConnection.cleanupService();
            goto L4
        }

        private List<ServiceState> getAllServiceStatesLocked() {
            List<ServiceState> serviceStates = new ArrayList();
            if (this.mDefaultServiceState == null) goto L6;
            serviceStates.add(this.mDefaultServiceState);
        L6:
            if (this.mSystemServiceState == null) goto L9;
            serviceStates.add(this.mSystemServiceState);
        L9:
            if (this.mUntrustedServiceState == null) goto L11;
            serviceStates.add(this.mUntrustedServiceState);
        L11:
            return serviceStates;
        }

        private ServiceState getServiceStateLocked(String packageName) {
            Iterator<ServiceState> r0 = getAllServiceStatesLocked().iterator();
        L4:
            if (r0.hasNext() == false) goto L9;
            ServiceState serviceState = r0.next();
            if (serviceState.mPackageName.equals(packageName) == false) goto L4;
            return serviceState;
        L9:
            return null;
        }

        private void updatePackageStateLocked() {
            Iterator<ServiceState> r0 = getAllServiceStatesLocked().iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            ServiceState serviceState = r0.next();
            ServiceState.m8495$$Nest$mupdatePackageStateLocked(serviceState);
            goto L4
        }

        void dump(IndentingPrintWriter pw) {
            Object r0 = TextClassificationManagerService.m8475$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            pw.increaseIndent();     // Catch: Throwable -> L7
            dump(pw, this.mDefaultServiceState, "Default");     // Catch: Throwable -> L7
            dump(pw, this.mSystemServiceState, "System");     // Catch: Throwable -> L7
            dump(pw, this.mUntrustedServiceState, "Untrusted");     // Catch: Throwable -> L7
            pw.decreaseIndent();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        private void dump(IndentingPrintWriter pw, ServiceState serviceState, String name) {
            Object r0 = TextClassificationManagerService.m8475$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            if (serviceState != null) goto L12;
        L8:
            monitor-exit(r0);     // Catch: Throwable -> L6
            return;
        L6:
            th = move-exception;
            throw th;
        L12:
            pw.print(name + ": ");     // Catch: Throwable -> L6
            ServiceState.m8491$$Nest$mdump(serviceState, pw);     // Catch: Throwable -> L6
            pw.println();     // Catch: Throwable -> L6
            goto L8
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$4jgZHwccyWJB1Mvl-QW-DjiPjvs, reason: not valid java name */
    public static /* synthetic */ void m8468$r8$lambda$4jgZHwccyWJB1MvlQWDjiPjvs(TextClassificationManagerService r0, IndentingPrintWriter r1) {
        r0.lambda$dump$9(r1);
    }

    public static /* synthetic */ void $r8$lambda$8XOpjEHm6XpB0fxdzASwFBAUGVg(TextClassificationSessionId r0, TextSelection.Request r1, ITextClassifierCallback r2, ITextClassifierService r3) {
        lambda$onSuggestSelection$0(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$AGq2zY-QMF8y9YE36qQwq4UAI5w, reason: not valid java name */
    public static /* synthetic */ void m8469$r8$lambda$AGq2zYQMF8y9YE36qQwq4UAI5w(TextClassificationSessionId r0, TextClassifierEvent r1, ITextClassifierService r2) {
        lambda$onTextClassifierEvent$4(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$CPHS8wb1SNmVfEE2kRmqa7arnKQ(TextClassificationContext r0, TextClassificationSessionId r1, ITextClassifierService r2) {
        lambda$onCreateTextClassificationSession$7(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$IpXAAP2GskLpHU54BP9tfr1ViL0(String r0, Throwable r1) {
        lambda$logOnFailure$11(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$JosjrP0FF04rzL3NHGSxa9uC2rI(TextClassificationSessionId r0, TextLinks.Request r1, ITextClassifierCallback r2, ITextClassifierService r3) {
        lambda$onGenerateLinks$2(r0, r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$PSlwuEivyvjL4cp2YRFHfRmwsuA(TextClassificationSessionId r0, ConversationActions.Request r1, ITextClassifierCallback r2, ITextClassifierService r3) {
        lambda$onSuggestConversationActions$6(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$Pgi5DATv2-tQK7rlD_sB9JOL1z0, reason: not valid java name */
    public static /* synthetic */ void m8470$r8$lambda$Pgi5DATv2tQK7rlD_sB9JOL1z0(TextClassificationManagerService r0, TextClassificationSessionId r1, ITextClassifierService r2) {
        r0.lambda$onDestroyTextClassificationSession$8(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$c_WNXkMR6Pi9FFFNPA5qBuBp0H4(TextClassificationSessionId r0, TextClassification.Request r1, ITextClassifierCallback r2, ITextClassifierService r3) {
        lambda$onClassifyText$1(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$ihDO-qLYGDEkA1iEl_lHw0KExLA, reason: not valid java name */
    public static /* synthetic */ void m8471$r8$lambda$ihDOqLYGDEkA1iEl_lHw0KExLA(TextClassificationSessionId r0, TextLanguage.Request r1, ITextClassifierCallback r2, ITextClassifierService r3) {
        lambda$onDetectLanguage$5(r0, r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$tV4MjUjpMSi8sq1CTmbGi16xvA8(TextClassificationSessionId r0, SelectionEvent r1, ITextClassifierService r2) {
        lambda$onSelectionEvent$3(r0, r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$vscVL2FLViez9ThII7mrkboiw-o, reason: not valid java name */
    public static /* synthetic */ void m8472$r8$lambda$vscVL2FLViez9ThII7mrkboiwo(FunctionalUtils.ThrowingConsumer r0, ServiceState r1) {
        lambda$handleRequest$10(r0, r1);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context m8473$$Nest$fgetmContext(TextClassificationManagerService r0) {
        return r0.mContext;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDefaultTextClassifierPackage, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m8474$$Nest$fgetmDefaultTextClassifierPackage(TextClassificationManagerService r0) {
        return r0.mDefaultTextClassifierPackage;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m8475$$Nest$fgetmLock(TextClassificationManagerService r0) {
        return r0.mLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSettings, reason: not valid java name */
    static /* bridge */ /* synthetic */ TextClassificationConstants m8476$$Nest$fgetmSettings(TextClassificationManagerService r0) {
        return r0.mSettings;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSystemTextClassifierPackage, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m8477$$Nest$fgetmSystemTextClassifierPackage(TextClassificationManagerService r0) {
        return r0.mSystemTextClassifierPackage;
    }

    /* JADX INFO: renamed from: -$$Nest$mgetUserStateLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ UserState m8478$$Nest$mgetUserStateLocked(TextClassificationManagerService r0, int r1) {
        return r0.getUserStateLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$monTextClassifierServicePackageOverrideChanged, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8479$$Nest$monTextClassifierServicePackageOverrideChanged(TextClassificationManagerService r0, String r1) {
        r0.onTextClassifierServicePackageOverrideChanged(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mresolvePackageToUid, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m8480$$Nest$mresolvePackageToUid(TextClassificationManagerService r0, String r1, int r2) {
        return r0.resolvePackageToUid(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mstartListenSettings, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8481$$Nest$mstartListenSettings(TextClassificationManagerService r0) {
        r0.startListenSettings();
    }

    /* JADX INFO: renamed from: -$$Nest$smlogOnFailure, reason: not valid java name */
    static /* bridge */ /* synthetic */ Runnable m8482$$Nest$smlogOnFailure(FunctionalUtils.ThrowingRunnable r0, String r1) {
        return logOnFailure(r0, r1);
    }

    /* synthetic */ TextClassificationManagerService(Context r1, TextClassificationManagerServiceIA r2) {
        this(r1);
    }

    static {
        NO_OP_CALLBACK = new AnonymousClass1();
    }

    private TextClassificationManagerService(Context context) {
        this.mUserStates = new SparseArray();
        context.getClass();
        this.mContext = context;
        this.mLock = new Object();
        this.mSettings = new TextClassificationConstants();
        this.mSettingsListener = new TextClassifierSettingsListener(this, this.mContext);
        PackageManager packageManager = this.mContext.getPackageManager();
        this.mDefaultTextClassifierPackage = packageManager.getDefaultTextClassifierPackageName();
        this.mSystemTextClassifierPackage = packageManager.getSystemTextClassifierPackageName();
        this.mSessionCache = new SessionCache(this.mLock);
        this.mPackageMonitor = new MyPackageMonitor(this, null);
    }

    private void startListenSettings() {
        this.mSettingsListener.registerObserver();
    }

    void startTrackingPackageChanges() {
        this.mPackageMonitor.register(this.mContext, null, UserHandle.ALL, true);
    }

    public void onConnectedStateChanged(int connected) {
    }

    public void onSuggestSelection(final TextClassificationSessionId sessionId, final TextSelection.Request request, final ITextClassifierCallback callback) throws RemoteException {
        request.getClass();
        request.getSystemTextClassifierMetadata().getClass();
        handleRequest(request.getSystemTextClassifierMetadata(), true, true, new TextClassificationManagerService$$ExternalSyntheticLambda0(sessionId, request, callback), "onSuggestSelection", callback);
    }

    private static /* synthetic */ void lambda$onSuggestSelection$0(TextClassificationSessionId sessionId, TextSelection.Request request, ITextClassifierCallback callback, ITextClassifierService service) throws Exception {
        service.onSuggestSelection(sessionId, request, wrap(callback));
    }

    public void onClassifyText(final TextClassificationSessionId sessionId, final TextClassification.Request request, final ITextClassifierCallback callback) throws RemoteException {
        request.getClass();
        request.getSystemTextClassifierMetadata().getClass();
        handleRequest(request.getSystemTextClassifierMetadata(), true, true, new TextClassificationManagerService$$ExternalSyntheticLambda7(sessionId, request, callback), "onClassifyText", callback);
    }

    private static /* synthetic */ void lambda$onClassifyText$1(TextClassificationSessionId sessionId, TextClassification.Request request, ITextClassifierCallback callback, ITextClassifierService service) throws Exception {
        service.onClassifyText(sessionId, request, wrap(callback));
    }

    public void onGenerateLinks(final TextClassificationSessionId sessionId, final TextLinks.Request request, final ITextClassifierCallback callback) throws RemoteException {
        request.getClass();
        request.getSystemTextClassifierMetadata().getClass();
        handleRequest(request.getSystemTextClassifierMetadata(), true, true, new TextClassificationManagerService$$ExternalSyntheticLambda3(sessionId, request, callback), "onGenerateLinks", callback);
    }

    private static /* synthetic */ void lambda$onGenerateLinks$2(TextClassificationSessionId sessionId, TextLinks.Request request, ITextClassifierCallback callback, ITextClassifierService service) throws Exception {
        service.onGenerateLinks(sessionId, request, callback);
    }

    public void onSelectionEvent(final TextClassificationSessionId sessionId, final SelectionEvent event) throws RemoteException {
        event.getClass();
        event.getSystemTextClassifierMetadata().getClass();
        handleRequest(event.getSystemTextClassifierMetadata(), true, true, new TextClassificationManagerService$$ExternalSyntheticLambda5(sessionId, event), "onSelectionEvent", NO_OP_CALLBACK);
    }

    private static /* synthetic */ void lambda$onSelectionEvent$3(TextClassificationSessionId sessionId, SelectionEvent event, ITextClassifierService service) throws Exception {
        service.onSelectionEvent(sessionId, event);
    }

    public void onTextClassifierEvent(final TextClassificationSessionId sessionId, final TextClassifierEvent event) throws RemoteException {
        event.getClass();
        TextClassificationContext eventContext = event.getEventContext();
        if (eventContext == null) goto L5;
        SystemTextClassifierMetadata r1 = eventContext.getSystemTextClassifierMetadata();
    L6:
        SystemTextClassifierMetadata systemTcMetadata = r1;
        handleRequest(systemTcMetadata, true, true, new TextClassificationManagerService$$ExternalSyntheticLambda2(sessionId, event), "onTextClassifierEvent", NO_OP_CALLBACK);
        return;
    L5:
        r1 = null;
        goto L6
    }

    private static /* synthetic */ void lambda$onTextClassifierEvent$4(TextClassificationSessionId sessionId, TextClassifierEvent event, ITextClassifierService service) throws Exception {
        service.onTextClassifierEvent(sessionId, event);
    }

    public void onDetectLanguage(final TextClassificationSessionId sessionId, final TextLanguage.Request request, final ITextClassifierCallback callback) throws RemoteException {
        request.getClass();
        request.getSystemTextClassifierMetadata().getClass();
        handleRequest(request.getSystemTextClassifierMetadata(), true, true, new TextClassificationManagerService$$ExternalSyntheticLambda10(sessionId, request, callback), "onDetectLanguage", callback);
    }

    private static /* synthetic */ void lambda$onDetectLanguage$5(TextClassificationSessionId sessionId, TextLanguage.Request request, ITextClassifierCallback callback, ITextClassifierService service) throws Exception {
        service.onDetectLanguage(sessionId, request, callback);
    }

    public void onSuggestConversationActions(final TextClassificationSessionId sessionId, final ConversationActions.Request request, final ITextClassifierCallback callback) throws RemoteException {
        request.getClass();
        request.getSystemTextClassifierMetadata().getClass();
        handleRequest(request.getSystemTextClassifierMetadata(), true, true, new TextClassificationManagerService$$ExternalSyntheticLambda11(sessionId, request, callback), "onSuggestConversationActions", callback);
    }

    private static /* synthetic */ void lambda$onSuggestConversationActions$6(TextClassificationSessionId sessionId, ConversationActions.Request request, ITextClassifierCallback callback, ITextClassifierService service) throws Exception {
        service.onSuggestConversationActions(sessionId, request, wrap(callback));
    }

    public void onCreateTextClassificationSession(final TextClassificationContext classificationContext, final TextClassificationSessionId sessionId) throws RemoteException {
        sessionId.getClass();
        classificationContext.getClass();
        classificationContext.getSystemTextClassifierMetadata().getClass();
        Object r1 = this.mLock;
        monitor-enter(r1);
        this.mSessionCache.put(sessionId, classificationContext);     // Catch: Throwable -> L8
        monitor-exit(r1);     // Catch: Throwable -> L8
        handleRequest(classificationContext.getSystemTextClassifierMetadata(), true, false, new TextClassificationManagerService$$ExternalSyntheticLambda4(classificationContext, sessionId), "onCreateTextClassificationSession", NO_OP_CALLBACK);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ void lambda$onCreateTextClassificationSession$7(TextClassificationContext classificationContext, TextClassificationSessionId sessionId, ITextClassifierService service) throws Exception {
        service.onCreateTextClassificationSession(classificationContext, sessionId);
    }

    public void onDestroyTextClassificationSession(final TextClassificationSessionId sessionId) throws RemoteException {
        sessionId.getClass();
        Object r1 = this.mLock;
        monitor-enter(r1);
        StrippedTextClassificationContext textClassificationContext = this.mSessionCache.get(sessionId.getToken());     // Catch: Throwable -> L7
        if (textClassificationContext == null) goto L9;
        int userId = textClassificationContext.userId;     // Catch: Throwable -> L7
    L11:
        if (textClassificationContext == null) goto L16;
        if (textClassificationContext.useDefaultTextClassifier == true) goto L16;
        boolean useDefaultTextClassifier = false;
    L17:
        SystemTextClassifierMetadata sysTcMetadata = new SystemTextClassifierMetadata("", userId, useDefaultTextClassifier);     // Catch: Throwable -> L7
        handleRequest(sysTcMetadata, false, false, new TextClassificationManagerService$$ExternalSyntheticLambda6(this, sessionId), "onDestroyTextClassificationSession", NO_OP_CALLBACK);     // Catch: Throwable -> L7
        monitor-exit(r1);     // Catch: Throwable -> L7
        return;
    L16:
        useDefaultTextClassifier = true;
        goto L17
    L9:
        userId = UserHandle.getCallingUserId();     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$onDestroyTextClassificationSession$8(TextClassificationSessionId sessionId, ITextClassifierService service) throws Exception {
        service.onDestroyTextClassificationSession(sessionId);
        this.mSessionCache.remove(sessionId.getToken());
    }

    private UserState getUserStateLocked(int userId) {
        UserState result = this.mUserStates.get(userId);
        if (result != null) goto L6;
        UserState result2 = new UserState(this, userId, null);
        this.mUserStates.put(userId, result2);
        return result2;
    L6:
        return result;
    }

    UserState peekUserStateLocked(int userId) {
        return this.mUserStates.get(userId);
    }

    private int resolvePackageToUid(String packageName, int userId) {
        if (packageName != null) goto L5;
        return -1;
    L5:
        PackageManager pm = this.mContext.getPackageManager();
        return pm.getPackageUidAsUser(packageName, userId);
    L9:
        Slog.e(LOG_TAG, "Could not get the UID for " + packageName);
        return -1;
    }

    protected void dump(FileDescriptor fd, PrintWriter fout, String[] args) {
        if (DumpUtils.checkDumpPermission(this.mContext, LOG_TAG, fout) == true) goto L5;
        return;
    L5:
        final IndentingPrintWriter pw = new IndentingPrintWriter(fout, "  ");
        Binder.withCleanCallingIdentity(new TextClassificationManagerService$$ExternalSyntheticLambda1(this, pw));
        pw.printPair("context", this.mContext);
        pw.println();
        pw.printPair("defaultTextClassifierPackage", this.mDefaultTextClassifierPackage);
        pw.println();
        pw.printPair("systemTextClassifierPackage", this.mSystemTextClassifierPackage);
        pw.println();
        Object r1 = this.mLock;
        monitor-enter(r1);
        int size = this.mUserStates.size();     // Catch: Throwable -> L12
        pw.print("Number user states: ");     // Catch: Throwable -> L12
        pw.println(size);     // Catch: Throwable -> L12
        if (size <= 0) goto L14;
        int i = 0;
    L10:
        if (i >= size) goto L14;
        pw.increaseIndent();     // Catch: Throwable -> L12
        UserState userState = this.mUserStates.valueAt(i);     // Catch: Throwable -> L12
        pw.printPair("User", Integer.valueOf(this.mUserStates.keyAt(i)));     // Catch: Throwable -> L12
        pw.println();     // Catch: Throwable -> L12
        userState.dump(pw);     // Catch: Throwable -> L12
        pw.decreaseIndent();     // Catch: Throwable -> L12
        i = i + 1;     // Catch: Throwable -> L12
    L14:
        pw.println("Number of active sessions: " + this.mSessionCache.size());     // Catch: Throwable -> L12
        monitor-exit(r1);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$dump$9(IndentingPrintWriter pw) throws Exception {
        ((TextClassificationManager) this.mContext.getSystemService(TextClassificationManager.class)).dump(pw);
    }

    private void handleRequest(SystemTextClassifierMetadata sysTcMetadata, boolean verifyCallingPackage, boolean attemptToBind, final FunctionalUtils.ThrowingConsumer<ITextClassifierService> textClassifierServiceConsumer, String methodName, final ITextClassifierCallback callback) throws RemoteException {
        textClassifierServiceConsumer.getClass();
        methodName.getClass();
        callback.getClass();
        if (sysTcMetadata != null) goto L5;
        int r0 = UserHandle.getCallingUserId();
    L6:
        int userId = r0;
        if (sysTcMetadata != null) goto L9;
        String r1 = null;
    L10:
        String callingPackageName = r1;
        if (sysTcMetadata != null) goto L13;
        boolean r2 = true;
    L14:
        boolean useDefaultTextClassifier = r2;
        if (verifyCallingPackage == true) goto L58;
    L19:
        validateUser(userId);     // Catch: Exception -> L17
        Object r12 = this.mLock;
        monitor-enter(r12);
        UserState userState = getUserStateLocked(userId);     // Catch: Throwable -> L25
        final ServiceState serviceState = userState.getServiceStateLocked(useDefaultTextClassifier);     // Catch: Throwable -> L25
        if (serviceState != null) goto L28;
        Slog.d(LOG_TAG, "No configured system TextClassifierService");     // Catch: Throwable -> L25
        callback.onFailure();     // Catch: Throwable -> L25
    L51:
        monitor-exit(r12);     // Catch: Throwable -> L47
        return;
    L28:
        if (serviceState.isInstalledLocked() == false) goto L50;
        if (serviceState.isEnabledLocked() == false) goto L50;
        if (attemptToBind == false) goto L37;
        if (ServiceState.m8489$$Nest$mbindLocked(serviceState) == true) goto L37;
        Slog.d(LOG_TAG, "Unable to bind TextClassifierService at " + methodName);     // Catch: Throwable -> L25
        callback.onFailure();     // Catch: Throwable -> L25
    L37:
        if (serviceState.isBoundLocked() == true) goto L39;
        FixedSizeQueue<PendingRequest> r14 = serviceState.mPendingRequests;     // Catch: Throwable -> L25
        FunctionalUtils.ThrowingRunnable r3 = new TextClassificationManagerService$$ExternalSyntheticLambda8(textClassifierServiceConsumer, serviceState);     // Catch: Throwable -> L25
        callback.getClass();     // Catch: Throwable -> L25
        r14.add(new PendingRequest(methodName, r3, new TextClassificationManagerService$$ExternalSyntheticLambda9(callback), callback.asBinder(), this, serviceState, Binder.getCallingUid()));     // Catch: Throwable -> L47
        goto L51
    L39:
        if (ServiceState.m8490$$Nest$mcheckRequestAcceptedLocked(serviceState, Binder.getCallingUid(), methodName) == true) goto L43;
        Slog.w(LOG_TAG, String.format("UID %d is not allowed to see the %s request", new Object[]{Integer.valueOf(Binder.getCallingUid()), methodName}));     // Catch: Throwable -> L25
        callback.onFailure();     // Catch: Throwable -> L25
        monitor-exit(r12);     // Catch: Throwable -> L25
        return;
    L43:
        consumeServiceNoExceptLocked(textClassifierServiceConsumer, serviceState.mService);     // Catch: Throwable -> L25
    L50:
        callback.onFailure();     // Catch: Throwable -> L47
    L47:
        th = th;
    L53:
        monitor-exit(r12);     // Catch: Throwable -> L47
        throw th;
    L25:
        th = th;
    L17:
        e = move-exception;
        throw new RemoteException("Invalid request: " + e.getMessage(), e, true, true);
    L58:
        validateCallingPackage(callingPackageName);     // Catch: Exception -> L17
        goto L19
    L13:
        r2 = sysTcMetadata.useDefaultTextClassifier();
        goto L14
    L9:
        r1 = sysTcMetadata.getCallingPackageName();
        goto L10
    L5:
        r0 = sysTcMetadata.getUserId();
        goto L6
    }

    private static /* synthetic */ void lambda$handleRequest$10(FunctionalUtils.ThrowingConsumer textClassifierServiceConsumer, ServiceState serviceState) throws Exception {
        consumeServiceNoExceptLocked(textClassifierServiceConsumer, serviceState.mService);
    }

    private static void consumeServiceNoExceptLocked(FunctionalUtils.ThrowingConsumer<ITextClassifierService> textClassifierServiceConsumer, ITextClassifierService service) {
        textClassifierServiceConsumer.accept(service);     // Catch: Throwable -> L4
        return;
    L4:
        e = move-exception;
        Slog.e(LOG_TAG, "Exception when consume textClassifierService: " + e);
    }

    private static ITextClassifierCallback wrap(ITextClassifierCallback orig) {
        return new CallbackWrapper(orig);
    }

    private void onTextClassifierServicePackageOverrideChanged(String overriddenPackage) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int size = this.mUserStates.size();     // Catch: Throwable -> L7
        int i = 0;
    L5:
        if (i >= size) goto L10;
        UserState userState = this.mUserStates.valueAt(i);     // Catch: Throwable -> L7
        userState.onTextClassifierServicePackageOverrideChangedLocked(overriddenPackage);     // Catch: Throwable -> L7
        i = i + 1;     // Catch: Throwable -> L7
        goto L5
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static Runnable logOnFailure(FunctionalUtils.ThrowingRunnable r, final String opDesc) {
        if (r != null) goto L6;
        return null;
    L6:
        return FunctionalUtils.handleExceptions(r, new TextClassificationManagerService$$ExternalSyntheticLambda12(opDesc));
    }

    private static /* synthetic */ void lambda$logOnFailure$11(String opDesc, Throwable e) {
        Slog.d(LOG_TAG, "Error " + opDesc + ": " + e.getMessage());
    }

    private void validateCallingPackage(String callingPackage) throws PackageManager.NameNotFoundException {
        if (callingPackage == null) goto L12;
        int packageUid = this.mContext.getPackageManager().getPackageUidAsUser(callingPackage, UserHandle.getCallingUserId());
        int callingUid = Binder.getCallingUid();
        if (callingUid != packageUid) goto L6;
    L9:
        boolean r2 = true;
    L10:
        Preconditions.checkArgument(r2, "Invalid package name. callingPackage=" + callingPackage + ", callingUid=" + callingUid);
        return;
    L6:
        if (callingUid == 1000) goto L9;
        r2 = false;
        goto L10
    }

    private void validateUser(int userId) {
        if (userId == (-10000)) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkArgument(r0, "Null userId");
        int callingUserId = UserHandle.getCallingUserId();
        if (callingUserId == userId) goto L10;
        this.mContext.enforceCallingOrSelfPermission("android.permission.INTERACT_ACROSS_USERS_FULL", "Invalid userId. UserId=" + userId + ", CallingUserId=" + callingUserId);
        return;
    L10:
        return;
    L5:
        r0 = false;
        goto L6
    }
}
