package com.android.server.autofill;

import android.R;
import android.app.ActivityManagerInternal;
import android.app.ActivityThread;
import android.content.AutofillOptions;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.UserInfo;
import android.database.ContentObserver;
import android.graphics.Rect;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.os.RemoteCallback;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.os.ShellCallback;
import android.os.SystemClock;
import android.os.UserHandle;
import android.pico.utils.ExtImplFactory;
import android.provider.DeviceConfig;
import android.provider.Settings;
import android.service.autofill.FillEventHistory;
import android.service.autofill.UserData;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.LocalLog;
import android.util.Log;
import android.util.Slog;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.TimeUtils;
import android.view.autofill.AutofillFeatureFlags;
import android.view.autofill.AutofillId;
import android.view.autofill.AutofillManager;
import android.view.autofill.AutofillManagerInternal;
import android.view.autofill.AutofillValue;
import android.view.autofill.IAutoFillManager;
import android.view.autofill.IAutoFillManagerClient;
import android.view.autofill.IObricAutofillManagerClient;
import com.android.internal.infra.GlobalWhitelistState;
import com.android.internal.infra.WhitelistHelper;
import com.android.internal.os.IResultReceiver;
import com.android.internal.util.DumpUtils;
import com.android.internal.util.Preconditions;
import com.android.internal.util.SyncResultReceiver;
import com.android.server.FgThread;
import com.android.server.LocalServices;
import com.android.server.SystemService;
import com.android.server.autofill.ui.AutoFillUI;
import com.android.server.infra.AbstractMasterSystemService;
import com.android.server.infra.AbstractPerUserSystemService;
import com.android.server.infra.FrameworkResourcesServiceNameResolver;
import com.android.server.infra.SecureSettingsServiceNameResolver;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class AutofillManagerService extends AbstractMasterSystemService<AutofillManagerService, AutofillManagerServiceImpl> {
    private static final char COMPAT_PACKAGE_DELIMITER = ':';
    private static final char COMPAT_PACKAGE_URL_IDS_BLOCK_BEGIN = '[';
    private static final char COMPAT_PACKAGE_URL_IDS_BLOCK_END = ']';
    private static final char COMPAT_PACKAGE_URL_IDS_DELIMITER = ',';
    private static final int DEFAULT_AUGMENTED_AUTOFILL_REQUEST_TIMEOUT_MILLIS = 5000;
    private static final String DEFAULT_PCC_FEATURE_PROVIDER_HINTS = "";
    private static final boolean DEFAULT_PCC_USE_FALLBACK = true;
    private static final boolean DEFAULT_PREFER_PROVIDER_OVER_PCC = true;
    static final String RECEIVER_BUNDLE_EXTRA_SESSIONS = "sessions";
    private static final String TAG = "AutofillManagerService";
    private static final Object sLock = null;
    private static int sPartitionMaxCount;
    private static int sVisibleDatasetsMaxCount;
    private final ActivityManagerInternal mAm;
    final FrameworkResourcesServiceNameResolver mAugmentedAutofillResolver;
    final AugmentedAutofillState mAugmentedAutofillState;
    int mAugmentedServiceIdleUnbindTimeoutMs;
    int mAugmentedServiceRequestTimeoutMs;
    private final AutofillCompatState mAutofillCompatState;
    private boolean mAutofillCredmanIntegrationEnabled;
    private final BroadcastReceiver mBroadcastReceiver;
    final ComponentName mCredentialAutofillService;
    private final DisabledInfoCache mDisabledInfoCache;
    private final IExtAutofillManagerService mExt;
    final FrameworkResourcesServiceNameResolver mFieldClassificationResolver;
    private final Object mFlagLock;
    private boolean mIsFillFieldsFromCurrentSessionOnly;
    private final LocalService mLocalService;
    private int mMaxInputLengthForAutofill;
    private boolean mPccClassificationEnabled;
    private boolean mPccPreferProviderOverPcc;
    private String mPccProviderHints;
    private boolean mPccUseFallbackDetection;
    private final LocalLog mRequestsHistory;
    private int mSupportedSmartSuggestionModes;
    private final AutoFillUI mUi;
    private final LocalLog mUiLatencyHistory;
    private final LocalLog mWtfHistory;

    /* JADX INFO: renamed from: com.android.server.autofill.AutofillManagerService$1, reason: invalid class name */
    class AnonymousClass1 extends BroadcastReceiver {
        final /* synthetic */ AutofillManagerService this$0;

        /* JADX INFO: renamed from: $r8$lambda$OcFbEPQ-kllEIdqA8xbZA_P2xkU, reason: not valid java name */
        public static /* synthetic */ void m2268$r8$lambda$OcFbEPQkllEIdqA8xbZA_P2xkU(AutofillManagerServiceImpl r0) {
            lambda$onReceive$0(r0);
        }

        AnonymousClass1(AutofillManagerService this$0) {
            this.this$0 = this$0;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.CLOSE_SYSTEM_DIALOGS".equals(intent.getAction()) == true) goto L5;
            return;
        L5:
            if (Helper.sDebug == false) goto L7;
            Slog.d(AutofillManagerService.TAG, "Close system dialogs");
        L7:
            Object r0 = AutofillManagerService.access$000(this.this$0);
            monitor-enter(r0);
            AutofillManagerService.access$100(this.this$0, new AutofillManagerService$1$$ExternalSyntheticLambda0());     // Catch: Throwable -> L12
            monitor-exit(r0);     // Catch: Throwable -> L12
            AutofillManagerService.m2254$$Nest$fgetmUi(this.this$0).hideAll(null);
            return;
        L12:
            th = move-exception;
            throw th;
        }

        private static /* synthetic */ void lambda$onReceive$0(AutofillManagerServiceImpl s) {
            s.forceRemoveFinishedSessionsLocked();
        }
    }

    static final class AugmentedAutofillState extends GlobalWhitelistState {
        private final SparseArray<String> mServicePackages;
        private final SparseBooleanArray mTemporaryServices;

        /* JADX INFO: renamed from: -$$Nest$msetServiceInfo, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m2269$$Nest$msetServiceInfo(AugmentedAutofillState r0, int r1, String r2, boolean r3) {
            r0.setServiceInfo(r1, r2, r3);
        }

        AugmentedAutofillState() {
            this.mServicePackages = new SparseArray();
            this.mTemporaryServices = new SparseBooleanArray();
        }

        private void setServiceInfo(int userId, String serviceName, boolean isTemporary) {
            Object r0 = ((GlobalWhitelistState) this).mGlobalWhitelistStateLock;
            monitor-enter(r0);
            if (isTemporary == false) goto L8;
            this.mTemporaryServices.put(userId, true);     // Catch: Throwable -> L6
        L9:
            if (serviceName == null) goto L15;
            ComponentName componentName = ComponentName.unflattenFromString(serviceName);     // Catch: Throwable -> L6
            if (componentName != null) goto L13;
            Slog.w(AutofillManagerService.TAG, "setServiceInfo(): invalid name: " + serviceName);     // Catch: Throwable -> L6
            this.mServicePackages.remove(userId);     // Catch: Throwable -> L6
        L16:
            monitor-exit(r0);     // Catch: Throwable -> L6
            return;
        L13:
            this.mServicePackages.put(userId, componentName.getPackageName());     // Catch: Throwable -> L6
            goto L16
        L15:
            this.mServicePackages.remove(userId);     // Catch: Throwable -> L6
            goto L16
        L8:
            this.mTemporaryServices.delete(userId);     // Catch: Throwable -> L6
        L6:
            th = move-exception;
            throw th;
        }

        public void injectAugmentedAutofillInfo(AutofillOptions options, int userId, String packageName) {
            Object r0 = ((GlobalWhitelistState) this).mGlobalWhitelistStateLock;
            monitor-enter(r0);
        L8:
            th = move-exception;
            throw th;
        L5:
            if (((GlobalWhitelistState) this).mWhitelisterHelpers != null) goto L10;
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L10:
            WhitelistHelper helper = (WhitelistHelper) ((GlobalWhitelistState) this).mWhitelisterHelpers.get(userId);     // Catch: Throwable -> L8
            if (helper == null) goto L13;
            options.augmentedAutofillEnabled = helper.isWhitelisted(packageName);     // Catch: Throwable -> L8
            options.whitelistedActivitiesForAugmentedAutofill = helper.getWhitelistedComponents(packageName);     // Catch: Throwable -> L8
        L13:
            monitor-exit(r0);     // Catch: Throwable -> L8
        }

        public boolean isWhitelisted(int userId, ComponentName componentName) {
            Object r0 = ((GlobalWhitelistState) this).mGlobalWhitelistStateLock;
            monitor-enter(r0);
        L8:
            th = move-exception;
            throw th;
        L5:
            if (super.isWhitelisted(userId, componentName) == true) goto L11;
            monitor-exit(r0);     // Catch: Throwable -> L8
            return false;
        L11:
            if (Build.IS_USER == true) goto L13;
        L19:
            monitor-exit(r0);     // Catch: Throwable -> L8
            return true;
        L13:
            if (this.mTemporaryServices.get(userId) == false) goto L19;
            String packageName = componentName.getPackageName();     // Catch: Throwable -> L8
            if (packageName.equals(this.mServicePackages.get(userId)) == true) goto L19;
            Slog.w(AutofillManagerService.TAG, "Ignoring package " + packageName + " for augmented autofill while using temporary service " + this.mServicePackages.get(userId));     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            return false;
        }

        public void dump(String prefix, PrintWriter pw) {
            super.dump(prefix, pw);
            Object r0 = ((GlobalWhitelistState) this).mGlobalWhitelistStateLock;
            monitor-enter(r0);
        L7:
            th = move-exception;
            throw th;
        L5:
            if (this.mServicePackages.size() <= 0) goto L10;
            pw.print(prefix);     // Catch: Throwable -> L7
            pw.print("Service packages: ");     // Catch: Throwable -> L7
            pw.println(this.mServicePackages);     // Catch: Throwable -> L7
        L10:
            if (this.mTemporaryServices.size() <= 0) goto L12;
            pw.print(prefix);     // Catch: Throwable -> L7
            pw.print("Temp services: ");     // Catch: Throwable -> L7
            pw.println(this.mTemporaryServices);     // Catch: Throwable -> L7
        L12:
            monitor-exit(r0);     // Catch: Throwable -> L7
        }
    }

    final class AutoFillManagerServiceStub extends IAutoFillManager.Stub {
        final /* synthetic */ AutofillManagerService this$0;

        AutoFillManagerServiceStub(AutofillManagerService this$0) {
            this.this$0 = this$0;
        }

        public void addClient(IAutoFillManagerClient client, ComponentName componentName, int userId, IResultReceiver receiver, boolean credmanRequested) {
            int flags = 0;
            Object r1 = AutofillManagerService.access$500(this.this$0);     // Catch: Throwable -> L19 Exception -> L21
            monitor-enter(r1);     // Catch: Throwable -> L19 Exception -> L21
            int enabledFlags = AutofillManagerService.m2258$$Nest$mgetServiceForUserWithLocalBinderIdentityLocked(this.this$0, userId).addClientLocked(client, componentName, credmanRequested);     // Catch: Throwable -> L16
            if (enabledFlags == 0) goto L9;
            flags = 0 | enabledFlags;     // Catch: Throwable -> L16
        L9:
            if (Helper.sDebug == false) goto L12;
            flags = flags | 2;     // Catch: Throwable -> L16
        L12:
            if (Helper.sVerbose == false) goto L14;
            flags = flags | 4;     // Catch: Throwable -> L16
        L14:
            monitor-exit(r1);     // Catch: Throwable -> L16
        L15:
            AutofillManagerService.m2260$$Nest$msend(this.this$0, receiver, flags);
            return;
        L16:
            th = move-exception;
            throw th;     // Catch: Throwable -> L19 Exception -> L21
        L21:
            ex = move-exception;
            Log.wtf(AutofillManagerService.TAG, "addClient(): failed " + ex.toString(), ex);     // Catch: Throwable -> L19
        L19:
            th = move-exception;
            AutofillManagerService.m2260$$Nest$msend(this.this$0, receiver, flags);
            throw th;
        }

        public void removeClient(IAutoFillManagerClient client, int userId) {
            Object r0 = AutofillManagerService.access$600(this.this$0);
            monitor-enter(r0);
            AutofillManagerServiceImpl service = (AutofillManagerServiceImpl) AutofillManagerService.access$700(this.this$0, userId);     // Catch: Throwable -> L7
            if (service == null) goto L10;
            service.removeClientLocked(client);     // Catch: Throwable -> L7
        L12:
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L10:
            if (Helper.sVerbose == false) goto L12;
            Slog.v(AutofillManagerService.TAG, "removeClient(): no service for " + userId);     // Catch: Throwable -> L7
        L7:
            th = move-exception;
            throw th;
        }

        public void addSmsClient(IObricAutofillManagerClient client, IResultReceiver receiver, ComponentName componentName) {
        }

        public void removeSmsClient(int sessionId) {
        }

        public void notifyViewEnteredForSms(AutofillId id, int sessionId) {
        }

        public void notifyViewExitedForSms(AutofillId id, int sessionId, boolean pausing) {
        }

        public void setAuthenticationResult(Bundle data, int sessionId, int authenticationId, int userId) {
            Object r0 = AutofillManagerService.access$800(this.this$0);
            monitor-enter(r0);
            AutofillManagerServiceImpl service = AutofillManagerService.m2258$$Nest$mgetServiceForUserWithLocalBinderIdentityLocked(this.this$0, userId);     // Catch: Throwable -> L7
            service.setAuthenticationResultLocked(data, sessionId, authenticationId, IAutoFillManager.Stub.getCallingUid());     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public void setHasCallback(int sessionId, int userId, boolean hasIt) {
            Object r0 = AutofillManagerService.access$900(this.this$0);
            monitor-enter(r0);
            AutofillManagerServiceImpl service = AutofillManagerService.m2258$$Nest$mgetServiceForUserWithLocalBinderIdentityLocked(this.this$0, userId);     // Catch: Throwable -> L7
            service.setHasCallback(sessionId, IAutoFillManager.Stub.getCallingUid(), hasIt);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public void startSession(IBinder activityToken, IBinder clientCallback, AutofillId autofillId, Rect bounds, AutofillValue value, int userId, boolean hasCallback, int flags, ComponentName clientActivity, boolean compatMode, IResultReceiver receiver) {
            activityToken.getClass();
            clientCallback.getClass();
            autofillId.getClass();
            clientActivity.getClass();
            String packageName = clientActivity.getPackageName();
            packageName.getClass();
            if (userId != UserHandle.getUserId(IAutoFillManager.Stub.getCallingUid())) goto L5;
            boolean r0 = true;
        L6:
            Preconditions.checkArgument(r0, "userId");
            this.this$0.getContext().getPackageManager().getPackageInfoAsUser(packageName, 0, userId);     // Catch: PackageManager.NameNotFoundException -> L20
            int taskId = AutofillManagerService.m2243$$Nest$fgetmAm(this.this$0).getTaskIdForActivity(activityToken, false);
            Object r5 = AutofillManagerService.access$1000(this.this$0);
            monitor-enter(r5);
            AutofillManagerServiceImpl service = AutofillManagerService.m2258$$Nest$mgetServiceForUserWithLocalBinderIdentityLocked(this.this$0, userId);     // Catch: Throwable -> L17
            long result = service.startSessionLocked(activityToken, taskId, IAutoFillManager.Stub.getCallingUid(), clientCallback, autofillId, bounds, value, hasCallback, clientActivity, compatMode, AutofillManagerService.access$1100(this.this$0), flags);     // Catch: Throwable -> L17
            monitor-exit(r5);     // Catch: Throwable -> L17
            int sessionId = (int) result;
            int resultFlags = (int) (result >> 32);
            if (resultFlags == 0) goto L15;
            AutofillManagerService.m2261$$Nest$msend(this.this$0, receiver, sessionId, resultFlags);
            return;
        L15:
            AutofillManagerService.m2260$$Nest$msend(this.this$0, receiver, sessionId);
            return;
        L17:
            th = move-exception;
            throw th;
        L20:
            e = move-exception;
            throw new IllegalArgumentException(packageName + " is not a valid package", e);
        L5:
            r0 = false;
            goto L6
        }

        public void getFillEventHistory(IResultReceiver receiver) throws RemoteException {
            FillEventHistory fillEventHistory = null;
            int userId = UserHandle.getCallingUserId();
            Object r2 = AutofillManagerService.access$1200(this.this$0);     // Catch: Throwable -> L17 Exception -> L19
            monitor-enter(r2);     // Catch: Throwable -> L17 Exception -> L19
            AutofillManagerServiceImpl service = AutofillManagerService.m2259$$Nest$mpeekServiceForUserWithLocalBinderIdentityLocked(this.this$0, userId);     // Catch: Throwable -> L8
            if (service == null) goto L11;
            fillEventHistory = service.getFillEventHistory(IAutoFillManager.Stub.getCallingUid());     // Catch: Throwable -> L8
        L13:
            monitor-exit(r2);     // Catch: Throwable -> L8
        L14:
            AutofillManagerService.m2262$$Nest$msend(this.this$0, receiver, fillEventHistory);
            return;
        L11:
            if (Helper.sVerbose == false) goto L13;
            Slog.v(AutofillManagerService.TAG, "getFillEventHistory(): no service for " + userId);     // Catch: Throwable -> L8
        L8:
            th = move-exception;
            throw th;     // Catch: Throwable -> L17 Exception -> L19
        L17:
            th = move-exception;
            AutofillManagerService.m2262$$Nest$msend(this.this$0, receiver, fillEventHistory);
            throw th;
        L19:
            ex = move-exception;
            Log.wtf(AutofillManagerService.TAG, "getFillEventHistory(): failed " + ex.toString());     // Catch: Throwable -> L17
            goto L14
        }

        public void getUserData(IResultReceiver receiver) throws RemoteException {
            UserData userData = null;
            int userId = UserHandle.getCallingUserId();
            Object r2 = AutofillManagerService.access$1300(this.this$0);     // Catch: Throwable -> L17 Exception -> L19
            monitor-enter(r2);     // Catch: Throwable -> L17 Exception -> L19
            AutofillManagerServiceImpl service = AutofillManagerService.m2259$$Nest$mpeekServiceForUserWithLocalBinderIdentityLocked(this.this$0, userId);     // Catch: Throwable -> L8
            if (service == null) goto L11;
            userData = service.getUserData(IAutoFillManager.Stub.getCallingUid());     // Catch: Throwable -> L8
        L13:
            monitor-exit(r2);     // Catch: Throwable -> L8
        L14:
            AutofillManagerService.m2262$$Nest$msend(this.this$0, receiver, userData);
            return;
        L11:
            if (Helper.sVerbose == false) goto L13;
            Slog.v(AutofillManagerService.TAG, "getUserData(): no service for " + userId);     // Catch: Throwable -> L8
        L8:
            th = move-exception;
            throw th;     // Catch: Throwable -> L17 Exception -> L19
        L17:
            th = move-exception;
            AutofillManagerService.m2262$$Nest$msend(this.this$0, receiver, userData);
            throw th;
        L19:
            ex = move-exception;
            Log.wtf(AutofillManagerService.TAG, "getUserData(): failed " + ex.toString());     // Catch: Throwable -> L17
            goto L14
        }

        public void getUserDataId(IResultReceiver receiver) throws RemoteException {
            UserData userData = null;
            int userId = UserHandle.getCallingUserId();
            String userDataId = null;
            Object r3 = AutofillManagerService.access$1400(this.this$0);     // Catch: Throwable -> L20 Exception -> L22
            monitor-enter(r3);     // Catch: Throwable -> L20 Exception -> L22
            AutofillManagerServiceImpl service = AutofillManagerService.m2259$$Nest$mpeekServiceForUserWithLocalBinderIdentityLocked(this.this$0, userId);     // Catch: Throwable -> L8
            if (service == null) goto L11;
            userData = service.getUserData(IAutoFillManager.Stub.getCallingUid());     // Catch: Throwable -> L8
        L13:
            monitor-exit(r3);     // Catch: Throwable -> L8
            if (userData == null) goto L17;
        L16:
            userDataId = userData.getId();
        L17:
            AutofillManagerService.m2263$$Nest$msend(this.this$0, receiver, userDataId);
            return;
        L11:
            if (Helper.sVerbose == false) goto L13;
            Slog.v(AutofillManagerService.TAG, "getUserDataId(): no service for " + userId);     // Catch: Throwable -> L8
        L8:
            th = move-exception;
            throw th;     // Catch: Throwable -> L20 Exception -> L22
        L22:
            ex = move-exception;
            Log.wtf(AutofillManagerService.TAG, "getUserDataId(): failed " + ex.toString());     // Catch: Throwable -> L20
            if (userData != null) goto L16;
        L20:
            th = move-exception;
            if (userData == null) goto L30;
            userDataId = userData.getId();
        L30:
            AutofillManagerService.m2263$$Nest$msend(this.this$0, receiver, userDataId);
            throw th;
        }

        public void setUserData(UserData userData) throws RemoteException {
            int userId = UserHandle.getCallingUserId();
            Object r1 = AutofillManagerService.access$1500(this.this$0);
            monitor-enter(r1);
            AutofillManagerServiceImpl service = AutofillManagerService.m2259$$Nest$mpeekServiceForUserWithLocalBinderIdentityLocked(this.this$0, userId);     // Catch: Throwable -> L7
            if (service == null) goto L10;
            service.setUserData(IAutoFillManager.Stub.getCallingUid(), userData);     // Catch: Throwable -> L7
        L12:
            monitor-exit(r1);     // Catch: Throwable -> L7
            return;
        L10:
            if (Helper.sVerbose == false) goto L12;
            Slog.v(AutofillManagerService.TAG, "setUserData(): no service for " + userId);     // Catch: Throwable -> L7
        L7:
            th = move-exception;
            throw th;
        }

        public void isFieldClassificationEnabled(IResultReceiver receiver) throws RemoteException {
            boolean enabled = false;
            int userId = UserHandle.getCallingUserId();
            Object r2 = AutofillManagerService.access$1600(this.this$0);     // Catch: Throwable -> L17 Exception -> L19
            monitor-enter(r2);     // Catch: Throwable -> L17 Exception -> L19
            AutofillManagerServiceImpl service = AutofillManagerService.m2259$$Nest$mpeekServiceForUserWithLocalBinderIdentityLocked(this.this$0, userId);     // Catch: Throwable -> L8
            if (service == null) goto L11;
            enabled = service.isFieldClassificationEnabled(IAutoFillManager.Stub.getCallingUid());     // Catch: Throwable -> L8
        L13:
            monitor-exit(r2);     // Catch: Throwable -> L8
        L14:
            AutofillManagerService.m2264$$Nest$msend(this.this$0, receiver, enabled);
            return;
        L11:
            if (Helper.sVerbose == false) goto L13;
            Slog.v(AutofillManagerService.TAG, "isFieldClassificationEnabled(): no service for " + userId);     // Catch: Throwable -> L8
        L8:
            th = move-exception;
            throw th;     // Catch: Throwable -> L17 Exception -> L19
        L17:
            th = move-exception;
            AutofillManagerService.m2264$$Nest$msend(this.this$0, receiver, enabled);
            throw th;
        L19:
            ex = move-exception;
            Log.wtf(AutofillManagerService.TAG, "isFieldClassificationEnabled(): failed " + ex.toString());     // Catch: Throwable -> L17
            goto L14
        }

        public void getDefaultFieldClassificationAlgorithm(IResultReceiver receiver) throws RemoteException {
            String algorithm = null;
            int userId = UserHandle.getCallingUserId();
            Object r2 = AutofillManagerService.access$1700(this.this$0);     // Catch: Throwable -> L17 Exception -> L19
            monitor-enter(r2);     // Catch: Throwable -> L17 Exception -> L19
            AutofillManagerServiceImpl service = AutofillManagerService.m2259$$Nest$mpeekServiceForUserWithLocalBinderIdentityLocked(this.this$0, userId);     // Catch: Throwable -> L8
            if (service == null) goto L11;
            algorithm = service.getDefaultFieldClassificationAlgorithm(IAutoFillManager.Stub.getCallingUid());     // Catch: Throwable -> L8
        L13:
            monitor-exit(r2);     // Catch: Throwable -> L8
        L14:
            AutofillManagerService.m2263$$Nest$msend(this.this$0, receiver, algorithm);
            return;
        L11:
            if (Helper.sVerbose == false) goto L13;
            Slog.v(AutofillManagerService.TAG, "getDefaultFcAlgorithm(): no service for " + userId);     // Catch: Throwable -> L8
        L8:
            th = move-exception;
            throw th;     // Catch: Throwable -> L17 Exception -> L19
        L17:
            th = move-exception;
            AutofillManagerService.m2263$$Nest$msend(this.this$0, receiver, algorithm);
            throw th;
        L19:
            ex = move-exception;
            Log.wtf(AutofillManagerService.TAG, "getDefaultFieldClassificationAlgorithm(): failed " + ex.toString());     // Catch: Throwable -> L17
            goto L14
        }

        public void setAugmentedAutofillWhitelist(List<String> packages, List<ComponentName> activities, IResultReceiver receiver) throws RemoteException {
            boolean ok = false;
            int userId = UserHandle.getCallingUserId();
            int r2 = -1;
            Object r4 = AutofillManagerService.access$1800(this.this$0);     // Catch: Throwable -> L21 Exception -> L23
            monitor-enter(r4);     // Catch: Throwable -> L21 Exception -> L23
            AutofillManagerServiceImpl service = AutofillManagerService.m2259$$Nest$mpeekServiceForUserWithLocalBinderIdentityLocked(this.this$0, userId);     // Catch: Throwable -> L8
            if (service == null) goto L11;
            ok = service.setAugmentedAutofillWhitelistLocked(packages, activities, IAutoFillManager.Stub.getCallingUid());     // Catch: Throwable -> L8
        L13:
            monitor-exit(r4);     // Catch: Throwable -> L8
            AutofillManagerService r5 = this.this$0;
            if (ok == false) goto L18;
        L16:
            r2 = 0;
        L18:
            AutofillManagerService.m2260$$Nest$msend(r5, receiver, r2);
            return;
        L11:
            if (Helper.sVerbose == false) goto L13;
            Slog.v(AutofillManagerService.TAG, "setAugmentedAutofillWhitelist(): no service for " + userId);     // Catch: Throwable -> L8
        L8:
            th = move-exception;
            throw th;     // Catch: Throwable -> L21 Exception -> L23
        L23:
            ex = move-exception;
            Log.wtf(AutofillManagerService.TAG, "setAugmentedAutofillWhitelist(): failed " + ex.toString());     // Catch: Throwable -> L21
            r5 = this.this$0;
            if (ok == false) goto L18;
        L21:
            th = move-exception;
            AutofillManagerService r6 = this.this$0;
            if (ok == false) goto L33;
            r2 = 0;
        L33:
            AutofillManagerService.m2260$$Nest$msend(r6, receiver, r2);
            throw th;
        }

        public void getAvailableFieldClassificationAlgorithms(IResultReceiver receiver) throws RemoteException {
            String[] algorithms = null;
            int userId = UserHandle.getCallingUserId();
            Object r2 = AutofillManagerService.access$1900(this.this$0);     // Catch: Throwable -> L18 Exception -> L20
            monitor-enter(r2);     // Catch: Throwable -> L18 Exception -> L20
            AutofillManagerServiceImpl service = AutofillManagerService.m2259$$Nest$mpeekServiceForUserWithLocalBinderIdentityLocked(this.this$0, userId);     // Catch: Throwable -> L8
            if (service == null) goto L11;
            algorithms = service.getAvailableFieldClassificationAlgorithms(IAutoFillManager.Stub.getCallingUid());     // Catch: Throwable -> L8
        L13:
            monitor-exit(r2);     // Catch: Throwable -> L8
            AutofillManagerService.m2265$$Nest$msend(this.this$0, receiver, algorithms);
            return;
        L11:
            if (Helper.sVerbose == false) goto L13;
            Slog.v(AutofillManagerService.TAG, "getAvailableFcAlgorithms(): no service for " + userId);     // Catch: Throwable -> L8
        L8:
            th = move-exception;
            throw th;     // Catch: Throwable -> L18 Exception -> L20
        L18:
            th = move-exception;
            AutofillManagerService.m2265$$Nest$msend(this.this$0, receiver, algorithms);
            throw th;
        L20:
            ex = move-exception;
            Log.wtf(AutofillManagerService.TAG, "getAvailableFieldClassificationAlgorithms(): failed " + ex.toString());     // Catch: Throwable -> L18
            AutofillManagerService.m2265$$Nest$msend(this.this$0, receiver, algorithms);
        }

        public void getAutofillServiceComponentName(IResultReceiver receiver) throws RemoteException {
            ComponentName componentName = null;
            int userId = UserHandle.getCallingUserId();
            Object r2 = AutofillManagerService.access$2000(this.this$0);     // Catch: Throwable -> L17 Exception -> L19
            monitor-enter(r2);     // Catch: Throwable -> L17 Exception -> L19
            AutofillManagerServiceImpl service = AutofillManagerService.m2259$$Nest$mpeekServiceForUserWithLocalBinderIdentityLocked(this.this$0, userId);     // Catch: Throwable -> L8
            if (service == null) goto L11;
            componentName = service.getServiceComponentName();     // Catch: Throwable -> L8
        L13:
            monitor-exit(r2);     // Catch: Throwable -> L8
        L14:
            AutofillManagerService.m2262$$Nest$msend(this.this$0, receiver, componentName);
            return;
        L11:
            if (Helper.sVerbose == false) goto L13;
            Slog.v(AutofillManagerService.TAG, "getAutofillServiceComponentName(): no service for " + userId);     // Catch: Throwable -> L8
        L8:
            th = move-exception;
            throw th;     // Catch: Throwable -> L17 Exception -> L19
        L17:
            th = move-exception;
            AutofillManagerService.m2262$$Nest$msend(this.this$0, receiver, componentName);
            throw th;
        L19:
            ex = move-exception;
            Log.wtf(AutofillManagerService.TAG, "getAutofillServiceComponentName(): failed " + ex.toString());     // Catch: Throwable -> L17
            goto L14
        }

        public void restoreSession(int sessionId, IBinder activityToken, IBinder appCallback, IResultReceiver receiver) throws RemoteException {
            boolean restored = false;
            int userId = UserHandle.getCallingUserId();
            activityToken.getClass();     // Catch: Throwable -> L17 Exception -> L19
            appCallback.getClass();     // Catch: Throwable -> L17 Exception -> L19
            Object r2 = AutofillManagerService.access$2100(this.this$0);     // Catch: Throwable -> L17 Exception -> L19
            monitor-enter(r2);     // Catch: Throwable -> L17 Exception -> L19
            AutofillManagerServiceImpl service = AutofillManagerService.m2259$$Nest$mpeekServiceForUserWithLocalBinderIdentityLocked(this.this$0, userId);     // Catch: Throwable -> L8
            if (service == null) goto L11;
            restored = service.restoreSession(sessionId, IAutoFillManager.Stub.getCallingUid(), activityToken, appCallback);     // Catch: Throwable -> L8
        L13:
            monitor-exit(r2);     // Catch: Throwable -> L8
        L14:
            AutofillManagerService.m2264$$Nest$msend(this.this$0, receiver, restored);
            return;
        L11:
            if (Helper.sVerbose == false) goto L13;
            Slog.v(AutofillManagerService.TAG, "restoreSession(): no service for " + userId);     // Catch: Throwable -> L8
        L8:
            th = move-exception;
            throw th;     // Catch: Throwable -> L17 Exception -> L19
        L19:
            ex = move-exception;
            Log.wtf(AutofillManagerService.TAG, "restoreSession(): failed " + ex.toString());     // Catch: Throwable -> L17
        L17:
            th = move-exception;
            AutofillManagerService.m2264$$Nest$msend(this.this$0, receiver, restored);
            throw th;
        }

        public void updateSession(int sessionId, AutofillId autoFillId, Rect bounds, AutofillValue value, int action, int flags, int userId) {
            Object r2 = AutofillManagerService.access$2200(this.this$0);
            monitor-enter(r2);
            AutofillManagerServiceImpl service = AutofillManagerService.m2259$$Nest$mpeekServiceForUserWithLocalBinderIdentityLocked(this.this$0, userId);     // Catch: Throwable -> L7
            if (service == null) goto L10;
            service.updateSessionLocked(sessionId, IAutoFillManager.Stub.getCallingUid(), autoFillId, bounds, value, action, flags);     // Catch: Throwable -> L7
        L12:
            monitor-exit(r2);     // Catch: Throwable -> L7
            return;
        L10:
            if (Helper.sVerbose == false) goto L12;
            Slog.v(AutofillManagerService.TAG, "updateSession(): no service for " + userId);     // Catch: Throwable -> L7
        L7:
            th = move-exception;
            throw th;
        }

        public void setAutofillFailure(int sessionId, List<AutofillId> ids, boolean isRefill, int userId) {
            Object r0 = AutofillManagerService.access$2300(this.this$0);
            monitor-enter(r0);
            AutofillManagerServiceImpl service = AutofillManagerService.m2259$$Nest$mpeekServiceForUserWithLocalBinderIdentityLocked(this.this$0, userId);     // Catch: Throwable -> L7
            if (service == null) goto L10;
            service.setAutofillFailureLocked(sessionId, IAutoFillManager.Stub.getCallingUid(), ids, isRefill);     // Catch: Throwable -> L7
        L12:
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L10:
            if (Helper.sVerbose == false) goto L12;
            Slog.v(AutofillManagerService.TAG, "setAutofillFailure(): no service for " + userId);     // Catch: Throwable -> L7
        L7:
            th = move-exception;
            throw th;
        }

        public void setViewAutofilled(int sessionId, AutofillId id, int userId) {
            Object r0 = AutofillManagerService.access$2400(this.this$0);
            monitor-enter(r0);
            AutofillManagerServiceImpl service = AutofillManagerService.m2259$$Nest$mpeekServiceForUserWithLocalBinderIdentityLocked(this.this$0, userId);     // Catch: Throwable -> L7
            if (service == null) goto L10;
            service.setViewAutofilledLocked(sessionId, IAutoFillManager.Stub.getCallingUid(), id);     // Catch: Throwable -> L7
        L12:
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L10:
            if (Helper.sVerbose == false) goto L12;
            Slog.v(AutofillManagerService.TAG, "setAutofillFailure(): no service for " + userId);     // Catch: Throwable -> L7
        L7:
            th = move-exception;
            throw th;
        }

        public void notifyNotExpiringResponseDuringAuth(int sessionId, int userId) {
            Object r0 = AutofillManagerService.access$2500(this.this$0);
            monitor-enter(r0);
            AutofillManagerServiceImpl service = AutofillManagerService.m2259$$Nest$mpeekServiceForUserWithLocalBinderIdentityLocked(this.this$0, userId);     // Catch: Throwable -> L7
            if (service == null) goto L10;
            service.notifyNotExpiringResponseDuringAuth(sessionId, IAutoFillManager.Stub.getCallingUid());     // Catch: Throwable -> L7
        L12:
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L10:
            if (Helper.sVerbose == false) goto L12;
            Slog.v(AutofillManagerService.TAG, "notifyNotExpiringResponseDuringAuth(): no service for " + userId);     // Catch: Throwable -> L7
        L7:
            th = move-exception;
            throw th;
        }

        public void notifyViewEnteredIgnoredDuringAuthCount(int sessionId, int userId) {
            Object r0 = AutofillManagerService.access$2600(this.this$0);
            monitor-enter(r0);
            AutofillManagerServiceImpl service = AutofillManagerService.m2259$$Nest$mpeekServiceForUserWithLocalBinderIdentityLocked(this.this$0, userId);     // Catch: Throwable -> L7
            if (service == null) goto L10;
            service.notifyViewEnteredIgnoredDuringAuthCount(sessionId, IAutoFillManager.Stub.getCallingUid());     // Catch: Throwable -> L7
        L12:
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L10:
            if (Helper.sVerbose == false) goto L12;
            Slog.v(AutofillManagerService.TAG, "notifyNotExpiringResponseDuringAuth(): no service for " + userId);     // Catch: Throwable -> L7
        L7:
            th = move-exception;
            throw th;
        }

        public void setAutofillIdsAttemptedForRefill(int sessionId, List<AutofillId> ids, int userId) {
            Object r0 = AutofillManagerService.access$2700(this.this$0);
            monitor-enter(r0);
            AutofillManagerServiceImpl service = AutofillManagerService.m2259$$Nest$mpeekServiceForUserWithLocalBinderIdentityLocked(this.this$0, userId);     // Catch: Throwable -> L7
            if (service == null) goto L10;
            service.setAutofillIdsAttemptedForRefill(sessionId, ids, IAutoFillManager.Stub.getCallingUid());     // Catch: Throwable -> L7
        L12:
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L10:
            if (Helper.sVerbose == false) goto L12;
            Slog.v(AutofillManagerService.TAG, "setAutofillIdsAttemptedForRefill(): no service for " + userId);     // Catch: Throwable -> L7
        L7:
            th = move-exception;
            throw th;
        }

        public void finishSession(int sessionId, int userId, int commitReason) {
            Object r0 = AutofillManagerService.access$2800(this.this$0);
            monitor-enter(r0);
            AutofillManagerServiceImpl service = AutofillManagerService.m2259$$Nest$mpeekServiceForUserWithLocalBinderIdentityLocked(this.this$0, userId);     // Catch: Throwable -> L7
            if (service == null) goto L10;
            service.finishSessionLocked(sessionId, IAutoFillManager.Stub.getCallingUid(), commitReason);     // Catch: Throwable -> L7
        L12:
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L10:
            if (Helper.sVerbose == false) goto L12;
            Slog.v(AutofillManagerService.TAG, "finishSession(): no service for " + userId);     // Catch: Throwable -> L7
        L7:
            th = move-exception;
            throw th;
        }

        public void cancelSession(int sessionId, int userId) {
            Object r0 = AutofillManagerService.access$2900(this.this$0);
            monitor-enter(r0);
            AutofillManagerServiceImpl service = AutofillManagerService.m2259$$Nest$mpeekServiceForUserWithLocalBinderIdentityLocked(this.this$0, userId);     // Catch: Throwable -> L7
            if (service == null) goto L10;
            service.cancelSessionLocked(sessionId, IAutoFillManager.Stub.getCallingUid());     // Catch: Throwable -> L7
        L12:
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L10:
            if (Helper.sVerbose == false) goto L12;
            Slog.v(AutofillManagerService.TAG, "cancelSession(): no service for " + userId);     // Catch: Throwable -> L7
        L7:
            th = move-exception;
            throw th;
        }

        public void disableOwnedAutofillServices(int userId) {
            Object r0 = AutofillManagerService.access$3000(this.this$0);
            monitor-enter(r0);
            AutofillManagerServiceImpl service = AutofillManagerService.m2259$$Nest$mpeekServiceForUserWithLocalBinderIdentityLocked(this.this$0, userId);     // Catch: Throwable -> L7
            if (service == null) goto L10;
            service.disableOwnedAutofillServicesLocked(Binder.getCallingUid());     // Catch: Throwable -> L7
        L12:
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L10:
            if (Helper.sVerbose == false) goto L12;
            Slog.v(AutofillManagerService.TAG, "cancelSession(): no service for " + userId);     // Catch: Throwable -> L7
        L7:
            th = move-exception;
            throw th;
        }

        public void isServiceSupported(int userId, IResultReceiver receiver) {
            boolean supported = false;
            Object r1 = AutofillManagerService.access$3100(this.this$0);     // Catch: Throwable -> L15 Exception -> L17
            monitor-enter(r1);     // Catch: Throwable -> L15 Exception -> L17
        L12:
            th = move-exception;
            throw th;     // Catch: Throwable -> L15 Exception -> L17
        L6:
            if (AutofillManagerService.access$3200(this.this$0, userId) == true) goto L8;
            boolean r2 = true;
        L9:
            supported = r2;
            monitor-exit(r1);     // Catch: Throwable -> L12
        L11:
            AutofillManagerService.m2264$$Nest$msend(this.this$0, receiver, supported);
            return;
        L8:
            r2 = false;
        L17:
            ex = move-exception;
            Log.wtf(AutofillManagerService.TAG, "isServiceSupported(): failed " + ex.toString());     // Catch: Throwable -> L15
        L15:
            th = move-exception;
            AutofillManagerService.m2264$$Nest$msend(this.this$0, receiver, supported);
            throw th;
        }

        public void isServiceEnabled(int userId, String packageName, IResultReceiver receiver) {
            boolean enabled = false;
            Object r1 = AutofillManagerService.access$3300(this.this$0);     // Catch: Throwable -> L11 Exception -> L13
            monitor-enter(r1);     // Catch: Throwable -> L11 Exception -> L13
            AutofillManagerServiceImpl service = AutofillManagerService.m2259$$Nest$mpeekServiceForUserWithLocalBinderIdentityLocked(this.this$0, userId);     // Catch: Throwable -> L8
            enabled = Objects.equals(packageName, service.getServicePackageName());     // Catch: Throwable -> L8
            monitor-exit(r1);     // Catch: Throwable -> L8
        L7:
            AutofillManagerService.m2264$$Nest$msend(this.this$0, receiver, enabled);
            return;
        L8:
            th = move-exception;
            throw th;     // Catch: Throwable -> L11 Exception -> L13
        L11:
            th = move-exception;
            AutofillManagerService.m2264$$Nest$msend(this.this$0, receiver, enabled);
            throw th;
        L13:
            ex = move-exception;
            Log.wtf(AutofillManagerService.TAG, "isServiceEnabled(): failed " + ex.toString());     // Catch: Throwable -> L11
            goto L7
        }

        public void onPendingSaveUi(int operation, IBinder token) {
            token.getClass();
            boolean r0 = true;
            if (operation != 1) goto L5;
        L8:
            Preconditions.checkArgument(r0, "invalid operation: %d", new Object[]{Integer.valueOf(operation)});
            Object r1 = AutofillManagerService.access$3400(this.this$0);
            monitor-enter(r1);
            AutofillManagerServiceImpl service = AutofillManagerService.m2259$$Nest$mpeekServiceForUserWithLocalBinderIdentityLocked(this.this$0, UserHandle.getCallingUserId());     // Catch: Throwable -> L13
            if (service == null) goto L15;
            service.onPendingSaveUi(operation, token);     // Catch: Throwable -> L13
        L15:
            monitor-exit(r1);     // Catch: Throwable -> L13
            return;
        L13:
            th = move-exception;
            throw th;
        L5:
            if (operation == 2) goto L8;
            r0 = false;
            goto L8
        }

        public void notifyImeAnimationStart(int sessionId, long startTimeMs, int userId) {
            Object r0 = AutofillManagerService.access$3500(this.this$0);
            monitor-enter(r0);
            AutofillManagerServiceImpl service = AutofillManagerService.m2259$$Nest$mpeekServiceForUserWithLocalBinderIdentityLocked(this.this$0, userId);     // Catch: Throwable -> L7
            if (service == null) goto L10;
            service.notifyImeAnimationStart(sessionId, startTimeMs, IAutoFillManager.Stub.getCallingUid());     // Catch: Throwable -> L7
        L12:
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L10:
            if (Helper.sVerbose == false) goto L12;
            Slog.v(AutofillManagerService.TAG, "notifyImeAnimationStart(): no service for " + userId);     // Catch: Throwable -> L7
        L7:
            th = move-exception;
            throw th;
        }

        public void notifyImeAnimationEnd(int sessionId, long endTimeMs, int userId) {
            Object r0 = AutofillManagerService.access$3600(this.this$0);
            monitor-enter(r0);
            AutofillManagerServiceImpl service = AutofillManagerService.m2259$$Nest$mpeekServiceForUserWithLocalBinderIdentityLocked(this.this$0, userId);     // Catch: Throwable -> L7
            if (service == null) goto L10;
            service.notifyImeAnimationEnd(sessionId, endTimeMs, IAutoFillManager.Stub.getCallingUid());     // Catch: Throwable -> L7
        L12:
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L10:
            if (Helper.sVerbose == false) goto L12;
            Slog.v(AutofillManagerService.TAG, "notifyImeAnimationEnd(): no service for " + userId);     // Catch: Throwable -> L7
        L7:
            th = move-exception;
            throw th;
        }

        public void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
            if (DumpUtils.checkDumpPermission(this.this$0.getContext(), AutofillManagerService.TAG, pw) == true) goto L5;
            return;
        L5:
            boolean showHistory = true;
            boolean uiOnly = false;
            boolean verificationOnly = false;
            if (args == null) goto L34;
            int r4 = args.length;
            int r6 = 0;
        L9:
            if (r6 >= r4) goto L34;
            String arg = args[r6];
            switch(arg.hashCode()) {
                case 900765093: goto L23;
                case 1098711592: goto L20;
                case 1333069025: goto L17;
                case 1443426942: goto L14;
                default: goto L25;
            };
        L25:
            byte r8 = -1;
        L26:
            switch(r8) {
                case 0: goto L32;
                case 1: goto L31;
                case 2: goto L29;
                case 3: goto L28;
                default: goto L27;
            };
        L27:
            Slog.w(AutofillManagerService.TAG, "Ignoring invalid dump arg: " + arg);
        L33:
            r6 = r6 + 1;
            goto L9
        L28:
            verificationOnly = true;
            goto L33
        L31:
            uiOnly = true;
            goto L33
        L32:
            showHistory = false;
            goto L33
        L29:
            pw.println("Usage: dumpsys autofill [--ui-only|--no-history]");
            return;
        L14:
            if (arg.equals("--verification-only") == false) goto L25;
            r8 = 3;
            goto L26
        L17:
            if (arg.equals("--help") == false) goto L25;
            r8 = 2;
            goto L26
        L20:
            if (arg.equals("--no-history") == false) goto L25;
            r8 = 0;
            goto L26
        L23:
            if (arg.equals("--ui-only") == false) goto L25;
            r8 = 1;
        L34:
            if (verificationOnly == false) goto L37;
            this.this$0.getExt().dump(pw);
            return;
        L37:
            if (uiOnly == false) goto L40;
            AutofillManagerService.m2254$$Nest$fgetmUi(this.this$0).dump(pw);
            return;
        L40:
            boolean realDebug = Helper.sDebug;
            boolean realVerbose = Helper.sVerbose;
            Helper.sVerbose = true;     // Catch: Throwable -> L67
            Helper.sDebug = true;     // Catch: Throwable -> L67
            Object r3 = AutofillManagerService.access$3700(this.this$0);     // Catch: Throwable -> L67
            monitor-enter(r3);     // Catch: Throwable -> L67
            pw.print("sDebug: ");     // Catch: Throwable -> L50
            pw.print(realDebug);     // Catch: Throwable -> L50
            pw.print(" sVerbose: ");     // Catch: Throwable -> L50
            pw.println(realVerbose);     // Catch: Throwable -> L50
            pw.print("Flags: ");     // Catch: Throwable -> L50
            Object r7 = AutofillManagerService.m2247$$Nest$fgetmFlagLock(this.this$0);     // Catch: Throwable -> L50
            monitor-enter(r7);     // Catch: Throwable -> L50
            pw.print("mPccClassificationEnabled=");     // Catch: Throwable -> L62
            pw.print(AutofillManagerService.m2248$$Nest$fgetmPccClassificationEnabled(this.this$0));     // Catch: Throwable -> L62
            pw.print(";");     // Catch: Throwable -> L62
            pw.print("mPccPreferProviderOverPcc=");     // Catch: Throwable -> L62
            pw.print(AutofillManagerService.m2249$$Nest$fgetmPccPreferProviderOverPcc(this.this$0));     // Catch: Throwable -> L62
            pw.print(";");     // Catch: Throwable -> L62
            pw.print("mPccUseFallbackDetection=");     // Catch: Throwable -> L62
            pw.print(AutofillManagerService.m2251$$Nest$fgetmPccUseFallbackDetection(this.this$0));     // Catch: Throwable -> L62
            pw.print(";");     // Catch: Throwable -> L62
            pw.print("mPccProviderHints=");     // Catch: Throwable -> L62
            pw.println(AutofillManagerService.m2250$$Nest$fgetmPccProviderHints(this.this$0));     // Catch: Throwable -> L62
            pw.print(";");     // Catch: Throwable -> L62
            pw.print("mAutofillCredmanIntegrationEnabled=");     // Catch: Throwable -> L62
            pw.println(AutofillManagerService.m2245$$Nest$fgetmAutofillCredmanIntegrationEnabled(this.this$0));     // Catch: Throwable -> L62
            monitor-exit(r7);     // Catch: Throwable -> L62
            AutofillManagerService.access$3800(this.this$0, "", pw);     // Catch: Throwable -> L50
            this.this$0.mAugmentedAutofillResolver.dumpShort(pw);     // Catch: Throwable -> L50
            pw.println();     // Catch: Throwable -> L50
            pw.print("Max partitions per session: ");     // Catch: Throwable -> L50
            pw.println(AutofillManagerService.m2266$$Nest$sfgetsPartitionMaxCount());     // Catch: Throwable -> L50
            pw.print("Max visible datasets: ");     // Catch: Throwable -> L50
            pw.println(AutofillManagerService.m2267$$Nest$sfgetsVisibleDatasetsMaxCount());     // Catch: Throwable -> L50
            if (Helper.sFullScreenMode == null) goto L52;
            pw.print("Overridden full-screen mode: ");     // Catch: Throwable -> L50
            pw.println(Helper.sFullScreenMode);     // Catch: Throwable -> L50
        L52:
            pw.println("User data constraints: ");     // Catch: Throwable -> L50
            UserData.dumpConstraints("  ", pw);     // Catch: Throwable -> L50
            AutofillManagerService.m2254$$Nest$fgetmUi(this.this$0).dump(pw);     // Catch: Throwable -> L50
            pw.print("Autofill Compat State: ");     // Catch: Throwable -> L50
            AutofillCompatState.m2270$$Nest$mdump(AutofillManagerService.m2244$$Nest$fgetmAutofillCompatState(this.this$0), "  ", pw);     // Catch: Throwable -> L50
            pw.print("from device config: ");     // Catch: Throwable -> L50
            pw.println(AutofillManagerService.m2257$$Nest$mgetAllowedCompatModePackagesFromDeviceConfig(this.this$0));     // Catch: Throwable -> L50
            if (AutofillManagerService.m2253$$Nest$fgetmSupportedSmartSuggestionModes(this.this$0) == 0) goto L55;
            pw.print("Smart Suggestion modes: ");     // Catch: Throwable -> L50
            pw.println(AutofillManager.getSmartSuggestionModeToString(AutofillManagerService.m2253$$Nest$fgetmSupportedSmartSuggestionModes(this.this$0)));     // Catch: Throwable -> L50
        L55:
            pw.print("Augmented Service Idle Unbind Timeout: ");     // Catch: Throwable -> L50
            pw.println(this.this$0.mAugmentedServiceIdleUnbindTimeoutMs);     // Catch: Throwable -> L50
            pw.print("Augmented Service Request Timeout: ");     // Catch: Throwable -> L50
            pw.println(this.this$0.mAugmentedServiceRequestTimeoutMs);     // Catch: Throwable -> L50
            if (showHistory == false) goto L58;
            pw.println();     // Catch: Throwable -> L50
            pw.println("Requests history:");     // Catch: Throwable -> L50
            pw.println();     // Catch: Throwable -> L50
            AutofillManagerService.m2252$$Nest$fgetmRequestsHistory(this.this$0).reverseDump(fd, pw, args);     // Catch: Throwable -> L50
            pw.println();     // Catch: Throwable -> L50
            pw.println("UI latency history:");     // Catch: Throwable -> L50
            pw.println();     // Catch: Throwable -> L50
            AutofillManagerService.m2255$$Nest$fgetmUiLatencyHistory(this.this$0).reverseDump(fd, pw, args);     // Catch: Throwable -> L50
            pw.println();     // Catch: Throwable -> L50
            pw.println("WTF history:");     // Catch: Throwable -> L50
            pw.println();     // Catch: Throwable -> L50
            AutofillManagerService.m2256$$Nest$fgetmWtfHistory(this.this$0).reverseDump(fd, pw, args);     // Catch: Throwable -> L50
        L58:
            pw.println("Augmented Autofill State: ");     // Catch: Throwable -> L50
            this.this$0.mAugmentedAutofillState.dump("  ", pw);     // Catch: Throwable -> L50
            monitor-exit(r3);     // Catch: Throwable -> L50
            Helper.sDebug = realDebug;
            Helper.sVerbose = realVerbose;
            return;
        L62:
            th = move-exception;
            throw th;     // Catch: Throwable -> L50
        L50:
            th = move-exception;
            throw th;     // Catch: Throwable -> L67
        L67:
            th = move-exception;
            Helper.sDebug = realDebug;
            Helper.sVerbose = realVerbose;
            throw th;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void onShellCommand(FileDescriptor in, FileDescriptor out, FileDescriptor err, String[] args, ShellCallback callback, ResultReceiver resultReceiver) {
            new AutofillManagerServiceShellCommand(this.this$0).exec(this, in, out, err, args, callback, resultReceiver);
        }
    }

    static final class AutofillCompatState {
        private final Object mLock;
        private SparseArray<ArrayMap<String, PackageCompatState>> mUserSpecs;

        /* JADX INFO: renamed from: -$$Nest$mdump, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m2270$$Nest$mdump(AutofillCompatState r0, String r1, PrintWriter r2) {
            r0.dump(r1, r2);
        }

        AutofillCompatState() {
            this.mLock = new Object();
        }

        boolean isCompatibilityModeRequested(String packageName, long versionCode, int userId) {
            Object r0 = this.mLock;
            monitor-enter(r0);
            boolean r2 = false;
            if (this.mUserSpecs != null) goto L10;
            monitor-exit(r0);     // Catch: Throwable -> L8
            return false;
        L10:
            ArrayMap<String, PackageCompatState> userSpec = this.mUserSpecs.get(userId);     // Catch: Throwable -> L8
            if (userSpec != null) goto L14;
            monitor-exit(r0);     // Catch: Throwable -> L8
            return false;
        L14:
            PackageCompatState metadata = userSpec.get(packageName);     // Catch: Throwable -> L8
            if (metadata != null) goto L19;
            monitor-exit(r0);     // Catch: Throwable -> L8
            return false;
        L19:
            if (versionCode > PackageCompatState.m2271$$Nest$fgetmaxVersionCode(metadata)) goto L21;
            r2 = true;
        L21:
            monitor-exit(r0);     // Catch: Throwable -> L8
            return r2;
        L8:
            th = move-exception;
            throw th;
        }

        String[] getUrlBarResourceIds(String packageName, int userId) {
            Object r0 = this.mLock;
            monitor-enter(r0);
        L8:
            th = move-exception;
            throw th;
        L5:
            if (this.mUserSpecs != null) goto L10;
            monitor-exit(r0);     // Catch: Throwable -> L8
            return null;
        L10:
            ArrayMap<String, PackageCompatState> userSpec = this.mUserSpecs.get(userId);     // Catch: Throwable -> L8
            if (userSpec != null) goto L14;
            monitor-exit(r0);     // Catch: Throwable -> L8
            return null;
        L14:
            PackageCompatState metadata = userSpec.get(packageName);     // Catch: Throwable -> L8
            if (metadata != null) goto L18;
            monitor-exit(r0);     // Catch: Throwable -> L8
            return null;
        L18:
            String[] r2 = PackageCompatState.m2272$$Nest$fgeturlBarResourceIds(metadata);     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            return r2;
        }

        void addCompatibilityModeRequest(String packageName, long versionCode, String[] urlBarResourceIds, int userId) {
            Object r0 = this.mLock;
            monitor-enter(r0);
        L7:
            th = move-exception;
            throw th;
        L5:
            if (this.mUserSpecs != null) goto L9;
            this.mUserSpecs = new SparseArray();     // Catch: Throwable -> L7
        L9:
            ArrayMap<String, PackageCompatState> userSpec = this.mUserSpecs.get(userId);     // Catch: Throwable -> L7
            if (userSpec != null) goto L12;
            userSpec = new ArrayMap();     // Catch: Throwable -> L7
            this.mUserSpecs.put(userId, userSpec);     // Catch: Throwable -> L7
        L12:
            userSpec.put(packageName, new PackageCompatState(versionCode, urlBarResourceIds));     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
        }

        void removeCompatibilityModeRequests(int userId) {
            Object r0 = this.mLock;
            monitor-enter(r0);
        L9:
            th = move-exception;
            throw th;
        L5:
            if (this.mUserSpecs == null) goto L11;
            this.mUserSpecs.remove(userId);     // Catch: Throwable -> L9
            if (this.mUserSpecs.size() > 0) goto L11;
            this.mUserSpecs = null;     // Catch: Throwable -> L9
        L11:
            monitor-exit(r0);     // Catch: Throwable -> L9
        }

        void reset(int userId) {
            Object r0 = this.mLock;
            monitor-enter(r0);
        L11:
            th = move-exception;
            throw th;
        L5:
            if (this.mUserSpecs == null) goto L17;
            this.mUserSpecs.delete(userId);     // Catch: Throwable -> L11
            int newSize = this.mUserSpecs.size();     // Catch: Throwable -> L11
            if (newSize != 0) goto L15;
            if (Helper.sVerbose == false) goto L13;
            Slog.v(AutofillManagerService.TAG, "reseting mUserSpecs");     // Catch: Throwable -> L11
        L13:
            this.mUserSpecs = null;     // Catch: Throwable -> L11
            goto L17
        L15:
            if (Helper.sVerbose == false) goto L17;
            Slog.v(AutofillManagerService.TAG, "mUserSpecs down to " + newSize);     // Catch: Throwable -> L11
        L17:
            monitor-exit(r0);     // Catch: Throwable -> L11
        }

        private void dump(String prefix, PrintWriter pw) {
            Object r0 = this.mLock;
            monitor-enter(r0);
        L9:
            th = move-exception;
            throw th;
        L5:
            if (this.mUserSpecs != null) goto L11;
            pw.println("N/A");     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L11:
            pw.println();     // Catch: Throwable -> L9
            String prefix2 = prefix + "  ";     // Catch: Throwable -> L9
            int i = 0;
        L13:
            if (i >= this.mUserSpecs.size()) goto L20;
            int user = this.mUserSpecs.keyAt(i);     // Catch: Throwable -> L9
            pw.print(prefix);     // Catch: Throwable -> L9
            pw.print("User: ");     // Catch: Throwable -> L9
            pw.println(user);     // Catch: Throwable -> L9
            ArrayMap<String, PackageCompatState> perUser = this.mUserSpecs.valueAt(i);     // Catch: Throwable -> L9
            int j = 0;
        L16:
            if (j >= perUser.size()) goto L18;
            String packageName = perUser.keyAt(j);     // Catch: Throwable -> L9
            PackageCompatState state = perUser.valueAt(j);     // Catch: Throwable -> L9
            pw.print(prefix2);     // Catch: Throwable -> L9
            pw.print(packageName);     // Catch: Throwable -> L9
            pw.print(": ");     // Catch: Throwable -> L9
            pw.println(state);     // Catch: Throwable -> L9
            j = j + 1;     // Catch: Throwable -> L9
            goto L16
        L18:
            i = i + 1;     // Catch: Throwable -> L9
            goto L13
        L20:
            monitor-exit(r0);     // Catch: Throwable -> L9
        }
    }

    private static final class AutofillDisabledInfo {
        private ArrayMap<ComponentName, Long> mDisabledActivities;
        private ArrayMap<String, Long> mDisabledApps;

        /* synthetic */ AutofillDisabledInfo(AutofillManagerServiceIA r1) {
            this();
        }

        private AutofillDisabledInfo() {
        }

        void putDisableAppsLocked(String packageName, long expiration) {
            if (this.mDisabledApps != null) goto L5;
            this.mDisabledApps = new ArrayMap(1);
        L5:
            this.mDisabledApps.put(packageName, Long.valueOf(expiration));
        }

        void putDisableActivityLocked(ComponentName componentName, long expiration) {
            if (this.mDisabledActivities != null) goto L5;
            this.mDisabledActivities = new ArrayMap(1);
        L5:
            this.mDisabledActivities.put(componentName, Long.valueOf(expiration));
        }

        long getAppDisabledExpirationLocked(String packageName) {
            if (this.mDisabledApps != null) goto L5;
            return 0;
        L5:
            Long expiration = this.mDisabledApps.get(packageName);
            if (expiration != null) goto L8;
            return 0;
        L8:
            return expiration.longValue();
        }

        ArrayMap<String, Long> getAppDisabledActivitiesLocked(String packageName) {
            if (this.mDisabledActivities == null) goto L14;
            int size = this.mDisabledActivities.size();
            ArrayMap<String, Long> disabledList = null;
            int i = 0;
        L5:
            if (i >= size) goto L13;
            ComponentName component = this.mDisabledActivities.keyAt(i);
            if (packageName.equals(component.getPackageName()) == false) goto L11;
            if (disabledList != null) goto L10;
            disabledList = new ArrayMap();
        L10:
            long expiration = this.mDisabledActivities.valueAt(i).longValue();
            disabledList.put(component.flattenToShortString(), Long.valueOf(expiration));
        L11:
            i = i + 1;
            goto L5
        L13:
            return disabledList;
        L14:
            return null;
        }

        boolean isAutofillDisabledLocked(ComponentName componentName) {
            long elapsedTime = 0;
            if (this.mDisabledActivities == null) goto L13;
            elapsedTime = SystemClock.elapsedRealtime();
            Long expiration = this.mDisabledActivities.get(componentName);
            if (expiration == null) goto L13;
            if (expiration.longValue() < elapsedTime) goto L10;
            return true;
        L10:
            if (Helper.sVerbose == false) goto L12;
            Slog.v(AutofillManagerService.TAG, "Removing " + componentName.toShortString() + " from disabled list");
        L12:
            this.mDisabledActivities.remove(componentName);
        L13:
            String packageName = componentName.getPackageName();
            if (this.mDisabledApps != null) goto L16;
            return false;
        L16:
            Long expiration2 = this.mDisabledApps.get(packageName);
            if (expiration2 != null) goto L20;
            return false;
        L20:
            if (elapsedTime != 0) goto L23;
            elapsedTime = SystemClock.elapsedRealtime();
        L23:
            if (expiration2.longValue() < elapsedTime) goto L26;
            return true;
        L26:
            if (Helper.sVerbose == false) goto L28;
            Slog.v(AutofillManagerService.TAG, "Removing " + packageName + " from disabled list");
        L28:
            this.mDisabledApps.remove(packageName);
            return false;
        }

        void dumpLocked(String prefix, PrintWriter pw) {
            pw.print(prefix);
            pw.print("Disabled apps: ");
            String r5 = ": ";
            if (this.mDisabledApps != null) goto L5;
            pw.println("N/A");
            String r16 = ": ";
        L9:
            pw.print(prefix);
            pw.print("Disabled activities: ");
            if (this.mDisabledActivities != null) goto L12;
            pw.println("N/A");
            return;
        L12:
            int size = this.mDisabledActivities.size();
            pw.println(size);
            StringBuilder builder = new StringBuilder();
            long now = SystemClock.elapsedRealtime();
            int i = 0;
        L13:
            if (i >= size) goto L15;
            ComponentName component = this.mDisabledActivities.keyAt(i);
            long expiration = this.mDisabledActivities.valueAt(i).longValue();
            builder.append(prefix);
            builder.append(prefix);
            builder.append(i);
            builder.append(". ");
            builder.append(component);
            builder.append(r16);
            TimeUtils.formatDuration(expiration - now, builder);
            builder.append('\n');
            i = i + 1;
            goto L13
        L15:
            pw.println(builder);
            return;
        L5:
            int size2 = this.mDisabledApps.size();
            pw.println(size2);
            StringBuilder builder2 = new StringBuilder();
            long now2 = SystemClock.elapsedRealtime();
            int i2 = 0;
        L6:
            if (i2 >= size2) goto L8;
            String packageName = this.mDisabledApps.keyAt(i2);
            long expiration2 = this.mDisabledApps.valueAt(i2).longValue();
            builder2.append(prefix);
            builder2.append(prefix);
            builder2.append(i2);
            builder2.append(". ");
            builder2.append(packageName);
            builder2.append(r5);
            TimeUtils.formatDuration(expiration2 - now2, builder2);
            builder2.append('\n');
            i2 = i2 + 1;
            r5 = r5;
            goto L6
        L8:
            r16 = r5;
            pw.println(builder2);
            goto L9
        }
    }

    static final class DisabledInfoCache {
        private final SparseArray<AutofillDisabledInfo> mCache;
        private final Object mLock;

        DisabledInfoCache() {
            this.mLock = new Object();
            this.mCache = new SparseArray();
        }

        void remove(int userId) {
            Object r0 = this.mLock;
            monitor-enter(r0);
            this.mCache.remove(userId);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        void addDisabledAppLocked(int userId, String packageName, long expiration) {
            packageName.getClass();
            Object r0 = this.mLock;
            monitor-enter(r0);
            AutofillDisabledInfo info = getOrCreateAutofillDisabledInfoByUserIdLocked(userId);     // Catch: Throwable -> L7
            info.putDisableAppsLocked(packageName, expiration);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        void addDisabledActivityLocked(int userId, ComponentName componentName, long expiration) {
            componentName.getClass();
            Object r0 = this.mLock;
            monitor-enter(r0);
            AutofillDisabledInfo info = getOrCreateAutofillDisabledInfoByUserIdLocked(userId);     // Catch: Throwable -> L7
            info.putDisableActivityLocked(componentName, expiration);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        boolean isAutofillDisabledLocked(int userId, ComponentName componentName) {
            componentName.getClass();
            Object r0 = this.mLock;
            monitor-enter(r0);
            AutofillDisabledInfo info = this.mCache.get(userId);     // Catch: Throwable -> L7
            if (info == null) goto L9;
            boolean disabled = info.isAutofillDisabledLocked(componentName);     // Catch: Throwable -> L7
        L10:
            monitor-exit(r0);     // Catch: Throwable -> L7
            return disabled;
        L9:
            disabled = false;
        L7:
            th = move-exception;
            throw th;
        }

        long getAppDisabledExpiration(int userId, String packageName) {
            packageName.getClass();
            Object r0 = this.mLock;
            monitor-enter(r0);
            AutofillDisabledInfo info = this.mCache.get(userId);     // Catch: Throwable -> L7
            if (info == null) goto L9;
            long r2 = info.getAppDisabledExpirationLocked(packageName);     // Catch: Throwable -> L7
        L10:
            Long expiration = Long.valueOf(r2);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return expiration.longValue();
        L9:
            r2 = 0;
        L7:
            th = move-exception;
            throw th;
        }

        ArrayMap<String, Long> getAppDisabledActivities(int userId, String packageName) {
            packageName.getClass();
            Object r0 = this.mLock;
            monitor-enter(r0);
            AutofillDisabledInfo info = this.mCache.get(userId);     // Catch: Throwable -> L7
            if (info == null) goto L9;
            ArrayMap<String, Long> disabledList = info.getAppDisabledActivitiesLocked(packageName);     // Catch: Throwable -> L7
        L10:
            monitor-exit(r0);     // Catch: Throwable -> L7
            return disabledList;
        L9:
            disabledList = null;
        L7:
            th = move-exception;
            throw th;
        }

        void dump(int userId, String prefix, PrintWriter pw) {
            Object r0 = this.mLock;
            monitor-enter(r0);
            AutofillDisabledInfo info = this.mCache.get(userId);     // Catch: Throwable -> L7
            if (info == null) goto L9;
            info.dumpLocked(prefix, pw);     // Catch: Throwable -> L7
        L9:
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        private AutofillDisabledInfo getOrCreateAutofillDisabledInfoByUserIdLocked(int userId) {
            AutofillDisabledInfo info = this.mCache.get(userId);
            if (info != null) goto L6;
            AutofillDisabledInfo info2 = new AutofillDisabledInfo(null);
            this.mCache.put(userId, info2);
            return info2;
        L6:
            return info;
        }
    }

    private final class LocalService extends AutofillManagerInternal {
        final /* synthetic */ AutofillManagerService this$0;

        /* synthetic */ LocalService(AutofillManagerService r1, AutofillManagerServiceIA r2) {
            this(r1);
        }

        private LocalService(AutofillManagerService r1) {
            this.this$0 = r1;
        }

        public void onBackKeyPressed() {
            if (Helper.sDebug == false) goto L5;
            Slog.d(AutofillManagerService.TAG, "onBackKeyPressed()");
        L5:
            AutofillManagerService.m2254$$Nest$fgetmUi(this.this$0).hideAll(null);
            Object r0 = AutofillManagerService.access$200(this.this$0);
            monitor-enter(r0);
            AutofillManagerServiceImpl service = AutofillManagerService.m2258$$Nest$mgetServiceForUserWithLocalBinderIdentityLocked(this.this$0, UserHandle.getCallingUserId());     // Catch: Throwable -> L10
            service.onBackKeyPressed();     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            throw th;
        }

        public AutofillOptions getAutofillOptions(String packageName, long versionCode, int userId) {
            if (this.this$0.verbose == false) goto L6;
            int loggingLevel = 6;
        L9:
            boolean compatModeEnabled = AutofillManagerService.m2244$$Nest$fgetmAutofillCompatState(this.this$0).isCompatibilityModeRequested(packageName, versionCode, userId);
            AutofillOptions options = new AutofillOptions(loggingLevel, compatModeEnabled);
            this.this$0.mAugmentedAutofillState.injectAugmentedAutofillInfo(options, userId, packageName);
            injectDisableAppInfo(options, userId, packageName);
            return options;
        L6:
            if (this.this$0.debug == false) goto L8;
            loggingLevel = 2;
            goto L9
        L8:
            loggingLevel = 0;
            goto L9
        }

        public boolean isAugmentedAutofillServiceForUser(int callingUid, int userId) {
            Object r0 = AutofillManagerService.access$300(this.this$0);
            monitor-enter(r0);
            AutofillManagerServiceImpl service = (AutofillManagerServiceImpl) AutofillManagerService.access$400(this.this$0, userId);     // Catch: Throwable -> L9
            if (service == null) goto L12;
            boolean r2 = service.isAugmentedAutofillServiceForUserLocked(callingUid);     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return r2;
        L12:
            monitor-exit(r0);     // Catch: Throwable -> L9
            return false;
        L9:
            th = move-exception;
            throw th;
        }

        private void injectDisableAppInfo(AutofillOptions options, int userId, String packageName) {
            options.appDisabledExpiration = AutofillManagerService.m2246$$Nest$fgetmDisabledInfoCache(this.this$0).getAppDisabledExpiration(userId, packageName);
            options.disabledActivities = AutofillManagerService.m2246$$Nest$fgetmDisabledInfoCache(this.this$0).getAppDisabledActivities(userId, packageName);
        }
    }

    static final class PackageCompatState {
        private final long maxVersionCode;
        private final String[] urlBarResourceIds;

        /* JADX INFO: renamed from: -$$Nest$fgetmaxVersionCode, reason: not valid java name */
        static /* bridge */ /* synthetic */ long m2271$$Nest$fgetmaxVersionCode(PackageCompatState r2) {
            return r2.maxVersionCode;
        }

        /* JADX INFO: renamed from: -$$Nest$fgeturlBarResourceIds, reason: not valid java name */
        static /* bridge */ /* synthetic */ String[] m2272$$Nest$fgeturlBarResourceIds(PackageCompatState r0) {
            return r0.urlBarResourceIds;
        }

        PackageCompatState(long maxVersionCode, String[] urlBarResourceIds) {
            this.maxVersionCode = maxVersionCode;
            this.urlBarResourceIds = urlBarResourceIds;
        }

        public String toString() {
            return "maxVersionCode=" + this.maxVersionCode + ", urlBarResourceIds=" + Arrays.toString(this.urlBarResourceIds);
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$GqzpdBSA4iBQFOz-9nmz060a5-Y, reason: not valid java name */
    public static /* synthetic */ void m2241$r8$lambda$GqzpdBSA4iBQFOz9nmz060a5Y(AutofillManagerServiceImpl r0) {
        lambda$removeAllSessions$3(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$JOIwrgA-lj-jIHmZ5dj3Tk11yj0, reason: not valid java name */
    public static /* synthetic */ void m2242$r8$lambda$JOIwrgAljjIHmZ5dj3Tk11yj0(AutofillManagerService r0, int r1, String r2, boolean r3) {
        r0.lambda$new$2(r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$fbn76nMMXFcakQUQV4Vc0gwwwag(ArrayList r0, AutofillManagerServiceImpl r1) {
        lambda$listSessions$4(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$gAt9sWDHacLKFcBAD02aL1dFlo8(AutofillManagerService r0, int r1, String r2, boolean r3) {
        r0.lambda$new$1(r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$jLyc8L_KrD8Z5mt87R13S09aUIE(AutofillManagerService r0, DeviceConfig.Properties r1) {
        r0.lambda$new$0(r1);
    }

    public static /* synthetic */ void $r8$lambda$lpD_Vy7idcZEZ7GdCdnYd32DJ7U(AutofillManagerServiceImpl r0) {
        lambda$reset$5(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAm, reason: not valid java name */
    static /* bridge */ /* synthetic */ ActivityManagerInternal m2243$$Nest$fgetmAm(AutofillManagerService r0) {
        return r0.mAm;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAutofillCompatState, reason: not valid java name */
    static /* bridge */ /* synthetic */ AutofillCompatState m2244$$Nest$fgetmAutofillCompatState(AutofillManagerService r0) {
        return r0.mAutofillCompatState;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAutofillCredmanIntegrationEnabled, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m2245$$Nest$fgetmAutofillCredmanIntegrationEnabled(AutofillManagerService r0) {
        return r0.mAutofillCredmanIntegrationEnabled;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDisabledInfoCache, reason: not valid java name */
    static /* bridge */ /* synthetic */ DisabledInfoCache m2246$$Nest$fgetmDisabledInfoCache(AutofillManagerService r0) {
        return r0.mDisabledInfoCache;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmFlagLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m2247$$Nest$fgetmFlagLock(AutofillManagerService r0) {
        return r0.mFlagLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPccClassificationEnabled, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m2248$$Nest$fgetmPccClassificationEnabled(AutofillManagerService r0) {
        return r0.mPccClassificationEnabled;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPccPreferProviderOverPcc, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m2249$$Nest$fgetmPccPreferProviderOverPcc(AutofillManagerService r0) {
        return r0.mPccPreferProviderOverPcc;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPccProviderHints, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m2250$$Nest$fgetmPccProviderHints(AutofillManagerService r0) {
        return r0.mPccProviderHints;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPccUseFallbackDetection, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m2251$$Nest$fgetmPccUseFallbackDetection(AutofillManagerService r0) {
        return r0.mPccUseFallbackDetection;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmRequestsHistory, reason: not valid java name */
    static /* bridge */ /* synthetic */ LocalLog m2252$$Nest$fgetmRequestsHistory(AutofillManagerService r0) {
        return r0.mRequestsHistory;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSupportedSmartSuggestionModes, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m2253$$Nest$fgetmSupportedSmartSuggestionModes(AutofillManagerService r0) {
        return r0.mSupportedSmartSuggestionModes;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmUi, reason: not valid java name */
    static /* bridge */ /* synthetic */ AutoFillUI m2254$$Nest$fgetmUi(AutofillManagerService r0) {
        return r0.mUi;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmUiLatencyHistory, reason: not valid java name */
    static /* bridge */ /* synthetic */ LocalLog m2255$$Nest$fgetmUiLatencyHistory(AutofillManagerService r0) {
        return r0.mUiLatencyHistory;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmWtfHistory, reason: not valid java name */
    static /* bridge */ /* synthetic */ LocalLog m2256$$Nest$fgetmWtfHistory(AutofillManagerService r0) {
        return r0.mWtfHistory;
    }

    /* JADX INFO: renamed from: -$$Nest$mgetAllowedCompatModePackagesFromDeviceConfig, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m2257$$Nest$mgetAllowedCompatModePackagesFromDeviceConfig(AutofillManagerService r0) {
        return r0.getAllowedCompatModePackagesFromDeviceConfig();
    }

    /* JADX INFO: renamed from: -$$Nest$mgetServiceForUserWithLocalBinderIdentityLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ AutofillManagerServiceImpl m2258$$Nest$mgetServiceForUserWithLocalBinderIdentityLocked(AutofillManagerService r0, int r1) {
        return r0.getServiceForUserWithLocalBinderIdentityLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mpeekServiceForUserWithLocalBinderIdentityLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ AutofillManagerServiceImpl m2259$$Nest$mpeekServiceForUserWithLocalBinderIdentityLocked(AutofillManagerService r0, int r1) {
        return r0.peekServiceForUserWithLocalBinderIdentityLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$msend, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2260$$Nest$msend(AutofillManagerService r0, IResultReceiver r1, int r2) {
        r0.send(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$msend, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2261$$Nest$msend(AutofillManagerService r0, IResultReceiver r1, int r2, int r3) {
        r0.send(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$msend, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2262$$Nest$msend(AutofillManagerService r0, IResultReceiver r1, Parcelable r2) {
        r0.send(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$msend, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2263$$Nest$msend(AutofillManagerService r0, IResultReceiver r1, String r2) {
        r0.send(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$msend, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2264$$Nest$msend(AutofillManagerService r0, IResultReceiver r1, boolean r2) {
        r0.send(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$msend, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2265$$Nest$msend(AutofillManagerService r0, IResultReceiver r1, String[] r2) {
        r0.send(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetsPartitionMaxCount, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m2266$$Nest$sfgetsPartitionMaxCount() {
        return sPartitionMaxCount;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetsVisibleDatasetsMaxCount, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m2267$$Nest$sfgetsVisibleDatasetsMaxCount() {
        return sVisibleDatasetsMaxCount;
    }

    static /* synthetic */ Object access$000(AutofillManagerService x0) {
        return x0.mLock;
    }

    static /* synthetic */ void access$100(AutofillManagerService x0, AbstractMasterSystemService.Visitor x1) {
        x0.visitServicesLocked(x1);
    }

    static /* synthetic */ Object access$1000(AutofillManagerService x0) {
        return x0.mLock;
    }

    static /* synthetic */ boolean access$1100(AutofillManagerService x0) {
        return x0.mAllowInstantService;
    }

    static /* synthetic */ Object access$1200(AutofillManagerService x0) {
        return x0.mLock;
    }

    static /* synthetic */ Object access$1300(AutofillManagerService x0) {
        return x0.mLock;
    }

    static /* synthetic */ Object access$1400(AutofillManagerService x0) {
        return x0.mLock;
    }

    static /* synthetic */ Object access$1500(AutofillManagerService x0) {
        return x0.mLock;
    }

    static /* synthetic */ Object access$1600(AutofillManagerService x0) {
        return x0.mLock;
    }

    static /* synthetic */ Object access$1700(AutofillManagerService x0) {
        return x0.mLock;
    }

    static /* synthetic */ Object access$1800(AutofillManagerService x0) {
        return x0.mLock;
    }

    static /* synthetic */ Object access$1900(AutofillManagerService x0) {
        return x0.mLock;
    }

    static /* synthetic */ Object access$200(AutofillManagerService x0) {
        return x0.mLock;
    }

    static /* synthetic */ Object access$2000(AutofillManagerService x0) {
        return x0.mLock;
    }

    static /* synthetic */ Object access$2100(AutofillManagerService x0) {
        return x0.mLock;
    }

    static /* synthetic */ Object access$2200(AutofillManagerService x0) {
        return x0.mLock;
    }

    static /* synthetic */ Object access$2300(AutofillManagerService x0) {
        return x0.mLock;
    }

    static /* synthetic */ Object access$2400(AutofillManagerService x0) {
        return x0.mLock;
    }

    static /* synthetic */ Object access$2500(AutofillManagerService x0) {
        return x0.mLock;
    }

    static /* synthetic */ Object access$2600(AutofillManagerService x0) {
        return x0.mLock;
    }

    static /* synthetic */ Object access$2700(AutofillManagerService x0) {
        return x0.mLock;
    }

    static /* synthetic */ Object access$2800(AutofillManagerService x0) {
        return x0.mLock;
    }

    static /* synthetic */ Object access$2900(AutofillManagerService x0) {
        return x0.mLock;
    }

    static /* synthetic */ Object access$300(AutofillManagerService x0) {
        return x0.mLock;
    }

    static /* synthetic */ Object access$3000(AutofillManagerService x0) {
        return x0.mLock;
    }

    static /* synthetic */ Object access$3100(AutofillManagerService x0) {
        return x0.mLock;
    }

    static /* synthetic */ boolean access$3200(AutofillManagerService x0, int x1) {
        return x0.isDisabledLocked(x1);
    }

    static /* synthetic */ Object access$3300(AutofillManagerService x0) {
        return x0.mLock;
    }

    static /* synthetic */ Object access$3400(AutofillManagerService x0) {
        return x0.mLock;
    }

    static /* synthetic */ Object access$3500(AutofillManagerService x0) {
        return x0.mLock;
    }

    static /* synthetic */ Object access$3600(AutofillManagerService x0) {
        return x0.mLock;
    }

    static /* synthetic */ Object access$3700(AutofillManagerService x0) {
        return x0.mLock;
    }

    static /* synthetic */ void access$3800(AutofillManagerService x0, String x1, PrintWriter x2) {
        x0.dumpLocked(x1, x2);
    }

    static /* synthetic */ AbstractPerUserSystemService access$400(AutofillManagerService x0, int x1) {
        return x0.peekServiceForUserLocked(x1);
    }

    static /* synthetic */ Object access$500(AutofillManagerService x0) {
        return x0.mLock;
    }

    static /* synthetic */ Object access$600(AutofillManagerService x0) {
        return x0.mLock;
    }

    static /* synthetic */ AbstractPerUserSystemService access$700(AutofillManagerService x0, int x1) {
        return x0.peekServiceForUserLocked(x1);
    }

    static /* synthetic */ Object access$800(AutofillManagerService x0) {
        return x0.mLock;
    }

    static /* synthetic */ Object access$900(AutofillManagerService x0) {
        return x0.mLock;
    }

    @Override // com.android.server.infra.AbstractMasterSystemService
    protected /* bridge */ /* synthetic */ AbstractPerUserSystemService newServiceLocked(int r1, boolean r2) {
        return newServiceLocked(r1, r2);
    }

    @Override // com.android.server.infra.AbstractMasterSystemService
    protected /* bridge */ /* synthetic */ void onServiceEnabledLocked(AbstractPerUserSystemService r1, int r2) {
        onServiceEnabledLocked((AutofillManagerServiceImpl) r1, r2);
    }

    @Override // com.android.server.infra.AbstractMasterSystemService
    protected /* bridge */ /* synthetic */ void onServiceRemoved(AbstractPerUserSystemService r1, int r2) {
        onServiceRemoved((AutofillManagerServiceImpl) r1, r2);
    }

    static {
        sLock = AutofillManagerService.class;
        sPartitionMaxCount = 10;
        sVisibleDatasetsMaxCount = 0;
    }

    public AutofillManagerService(Context context) {
        super(context, new SecureSettingsServiceNameResolver(context, "autofill_service"), "no_autofill", 4);
        this.mRequestsHistory = new LocalLog(20);
        this.mUiLatencyHistory = new LocalLog(20);
        this.mWtfHistory = new LocalLog(50);
        this.mAutofillCompatState = new AutofillCompatState();
        this.mDisabledInfoCache = new DisabledInfoCache();
        this.mLocalService = new LocalService(this, null);
        this.mBroadcastReceiver = new AnonymousClass1(this);
        this.mAugmentedAutofillState = new AugmentedAutofillState();
        this.mFlagLock = new Object();
        this.mExt = (IExtAutofillManagerService) ExtImplFactory.getImpl(IExtAutofillManagerService.class, new Object[]{this});
        this.mUi = new AutoFillUI(ActivityThread.currentActivityThread().getSystemUiContext());
        this.mAm = (ActivityManagerInternal) LocalServices.getService(ActivityManagerInternal.class);
        DeviceConfig.addOnPropertiesChangedListener("autofill", ActivityThread.currentApplication().getMainExecutor(), new AutofillManagerService$$ExternalSyntheticLambda1(this));
        setLogLevelFromSettings();
        setMaxPartitionsFromSettings();
        setMaxVisibleDatasetsFromSettings();
        setDeviceConfigProperties();
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
        context.registerReceiver(this.mBroadcastReceiver, filter, null, FgThread.getHandler(), 2);
        this.mAugmentedAutofillResolver = new FrameworkResourcesServiceNameResolver(getContext(), R.string.config_deviceSpecificDevicePolicyManagerService);
        this.mAugmentedAutofillResolver.setOnTemporaryServiceNameChangedCallback(new AutofillManagerService$$ExternalSyntheticLambda2(this));
        this.mFieldClassificationResolver = new FrameworkResourcesServiceNameResolver(getContext(), R.string.config_ethernet_iface_regex);
        if (Helper.sVerbose == false) goto L5;
        Slog.v(TAG, "Resolving FieldClassificationService to serviceName: " + this.mFieldClassificationResolver.readServiceName(0));
    L5:
        this.mFieldClassificationResolver.setOnTemporaryServiceNameChangedCallback(new AutofillManagerService$$ExternalSyntheticLambda3(this));
        if (this.mSupportedSmartSuggestionModes == 0) goto L11;
        List<UserInfo> users = getSupportedUsers();
        int i = 0;
    L9:
        if (i >= users.size()) goto L11;
        int userId = users.get(i).id;
        getServiceForUserLocked(userId);
        AugmentedAutofillState.m2269$$Nest$msetServiceInfo(this.mAugmentedAutofillState, userId, this.mAugmentedAutofillResolver.getServiceName(userId), this.mAugmentedAutofillResolver.isTemporary(userId));
        i = i + 1;
    L11:
        String credentialManagerAutofillCompName = context.getResources().getString(R.string.config_dozeLongPressSensorType);
        if (credentialManagerAutofillCompName != null) goto L14;
    L16:
        this.mCredentialAutofillService = null;
        Slog.w(TAG, "Invalid CredentialAutofillService");
        return;
    L14:
        if (credentialManagerAutofillCompName.isEmpty() == true) goto L16;
        this.mCredentialAutofillService = ComponentName.unflattenFromString(credentialManagerAutofillCompName);
    }

    private /* synthetic */ void lambda$new$0(DeviceConfig.Properties properties) {
        onDeviceConfigChange(properties.getKeyset());
    }

    private /* synthetic */ void lambda$new$1(int u, String s, boolean t) {
        onAugmentedServiceNameChanged(u, s, t);
    }

    private /* synthetic */ void lambda$new$2(int u, String s, boolean t) {
        onFieldClassificationServiceNameChanged(u, s, t);
    }

    @Override // com.android.server.infra.AbstractMasterSystemService
    protected String getServiceSettingsProperty() {
        return "autofill_service";
    }

    @Override // com.android.server.infra.AbstractMasterSystemService
    protected void registerForExtraSettingsChanges(ContentResolver resolver, ContentObserver observer) {
        resolver.registerContentObserver(Settings.Global.getUriFor("autofill_logging_level"), false, observer, -1);
        resolver.registerContentObserver(Settings.Global.getUriFor("autofill_max_partitions_size"), false, observer, -1);
        resolver.registerContentObserver(Settings.Global.getUriFor("autofill_max_visible_datasets"), false, observer, -1);
        resolver.registerContentObserver(Settings.Secure.getUriFor("selected_input_method_subtype"), false, observer, -1);
    }

    @Override // com.android.server.infra.AbstractMasterSystemService
    protected void onSettingsChanged(int userId, String property) {
        switch(property.hashCode()) {
            case -1848997872: goto L15;
            case -1299292969: goto L12;
            case -1048937777: goto L9;
            case 1194058837: goto L6;
            default: goto L17;
        };
    L17:
        byte r0 = -1;
    L18:
        switch(r0) {
            case 0: goto L30;
            case 1: goto L29;
            case 2: goto L28;
            case 3: goto L27;
            default: goto L19;
        };
    L19:
        Slog.w(TAG, "Unexpected property (" + property + "); updating cache instead");
        Object r1 = this.mLock;
        monitor-enter(r1);
        updateCachedServiceLocked(userId);     // Catch: Throwable -> L24
        monitor-exit(r1);     // Catch: Throwable -> L24
        return;
    L24:
        th = move-exception;
        throw th;
    L27:
        handleInputMethodSwitch(userId);
        return;
    L28:
        setMaxVisibleDatasetsFromSettings();
        return;
    L29:
        setMaxPartitionsFromSettings();
        return;
    L30:
        setLogLevelFromSettings();
        return;
    L6:
        if (property.equals("selected_input_method_subtype") == false) goto L17;
        r0 = 3;
        goto L18
    L9:
        if (property.equals("autofill_max_partitions_size") == false) goto L17;
        r0 = 1;
        goto L18
    L12:
        if (property.equals("autofill_logging_level") == false) goto L17;
        r0 = 0;
        goto L18
    L15:
        if (property.equals("autofill_max_visible_datasets") == false) goto L17;
        r0 = 2;
        goto L18
    }

    private void handleInputMethodSwitch(int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        AutofillManagerServiceImpl service = peekServiceForUserWithLocalBinderIdentityLocked(userId);     // Catch: Throwable -> L7
        if (service == null) goto L9;
        service.onSwitchInputMethod();     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void onDeviceConfigChange(Set<String> keys) {
        Iterator<String> r0 = keys.iterator();
    L4:
        if (r0.hasNext() == false) goto L44;
        String key = r0.next();
        switch(key.hashCode()) {
            case -1681497033: goto L36;
            case -1644292860: goto L33;
            case -1546842390: goto L30;
            case -1020220570: goto L27;
            case -987506216: goto L24;
            case 139432258: goto L21;
            case 346686040: goto L18;
            case 1168452547: goto L15;
            case 1169876393: goto L12;
            case 1709136986: goto L9;
            default: goto L38;
        };
    L38:
        byte r2 = -1;
    L39:
        switch(r2) {
            case 0: goto L42;
            case 1: goto L42;
            case 2: goto L42;
            case 3: goto L42;
            case 4: goto L42;
            case 5: goto L42;
            case 6: goto L42;
            case 7: goto L42;
            case 8: goto L42;
            case 9: goto L41;
            default: goto L40;
        };
    L41:
        updateCachedServices();
        goto L4
    L42:
        setDeviceConfigProperties();
        goto L4
    L40:
        Slog.i(this.mTag, "Ignoring change on " + key);
        goto L4
    L9:
        if (key.equals("smart_suggestion_supported_modes") == false) goto L38;
        r2 = 0;
        goto L39
    L12:
        if (key.equals("pcc_use_fallback") == false) goto L38;
        r2 = 6;
        goto L39
    L15:
        if (key.equals("compat_mode_allowed_packages") == false) goto L38;
        r2 = 9;
        goto L39
    L18:
        if (key.equals("android.service.autofill.autofill_credman_integration") == false) goto L38;
        r2 = 8;
        goto L39
    L21:
        if (key.equals("pcc_classification_hints") == false) goto L38;
        r2 = 4;
        goto L39
    L24:
        if (key.equals("augmented_service_request_timeout") == false) goto L38;
        r2 = 2;
        goto L39
    L27:
        if (key.equals("fill_fields_from_current_session_only") == false) goto L38;
        r2 = 7;
        goto L39
    L30:
        if (key.equals("augmented_service_idle_unbind_timeout") == false) goto L38;
        r2 = 1;
        goto L39
    L33:
        if (key.equals("prefer_provider_over_pcc") == false) goto L38;
        r2 = 5;
        goto L39
    L36:
        if (key.equals("pcc_classification_enabled") == false) goto L38;
        r2 = 3;
        goto L39
    }

    private void onAugmentedServiceNameChanged(int userId, String serviceName, boolean isTemporary) {
        AugmentedAutofillState.m2269$$Nest$msetServiceInfo(this.mAugmentedAutofillState, userId, serviceName, isTemporary);
        Object r0 = this.mLock;
        monitor-enter(r0);
        AutofillManagerServiceImpl service = peekServiceForUserWithLocalBinderIdentityLocked(userId);     // Catch: Throwable -> L7
        if (service != null) goto L9;
        getServiceForUserWithLocalBinderIdentityLocked(userId);     // Catch: Throwable -> L7
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L9:
        service.updateRemoteAugmentedAutofillService();     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }

    private void onFieldClassificationServiceNameChanged(int userId, String serviceName, boolean isTemporary) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        AutofillManagerServiceImpl service = peekServiceForUserWithLocalBinderIdentityLocked(userId);     // Catch: Throwable -> L7
        if (service != null) goto L9;
        getServiceForUserWithLocalBinderIdentityLocked(userId);     // Catch: Throwable -> L7
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L9:
        service.updateRemoteFieldClassificationService();     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }

    private AutofillManagerServiceImpl getServiceForUserWithLocalBinderIdentityLocked(int userId) {
        long token = Binder.clearCallingIdentity();
        AutofillManagerServiceImpl r2 = getServiceForUserLocked(userId);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(token);
        return r2;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    private AutofillManagerServiceImpl peekServiceForUserWithLocalBinderIdentityLocked(int userId) {
        long token = Binder.clearCallingIdentity();
        AutofillManagerServiceImpl r2 = peekServiceForUserLocked(userId);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(token);
        return r2;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    @Override // com.android.server.infra.AbstractMasterSystemService
    protected AutofillManagerServiceImpl newServiceLocked(int resolvedUserId, boolean disabled) {
        return new AutofillManagerServiceImpl(this, this.mLock, this.mUiLatencyHistory, this.mWtfHistory, resolvedUserId, this.mUi, this.mAutofillCompatState, disabled, this.mDisabledInfoCache);
    }

    protected void onServiceRemoved(AutofillManagerServiceImpl service, int userId) {
        service.destroyLocked();
        this.mDisabledInfoCache.remove(userId);
        this.mAutofillCompatState.removeCompatibilityModeRequests(userId);
    }

    protected void onServiceEnabledLocked(AutofillManagerServiceImpl service, int userId) {
        addCompatibilityModeRequestsLocked(service, userId);
    }

    @Override // com.android.server.infra.AbstractMasterSystemService
    protected void enforceCallingPermissionForManagement() {
        getContext().enforceCallingPermission("android.permission.MANAGE_AUTO_FILL", TAG);
    }

    @Override // com.android.server.SystemService
    public void onStart() {
        publishBinderService("autofill", new AutoFillManagerServiceStub(this));
        publishLocalService(AutofillManagerInternal.class, this.mLocalService);
    }

    @Override // com.android.server.SystemService
    public boolean isUserSupported(SystemService.TargetUser user) {
        if (user.isFull() == false) goto L5;
    L8:
        return true;
    L5:
        if (user.isProfile() == true) goto L8;
        return false;
    }

    @Override // com.android.server.SystemService
    public void onUserSwitching(SystemService.TargetUser from, SystemService.TargetUser to) {
        if (Helper.sDebug == false) goto L5;
        Slog.d(TAG, "Hiding UI when user switched");
    L5:
        this.mUi.hideAll(null);
    }

    int getSupportedSmartSuggestionModesLocked() {
        return this.mSupportedSmartSuggestionModes;
    }

    void logRequestLocked(String historyItem) {
        this.mRequestsHistory.log(historyItem);
    }

    boolean isInstantServiceAllowed() {
        return this.mAllowInstantService;
    }

    void removeAllSessions(int userId, IResultReceiver receiver) {
        Slog.i(TAG, "removeAllSessions() for userId " + userId);
        enforceCallingPermissionForManagement();
        Object r0 = this.mLock;
        monitor-enter(r0);
        if (userId == (-1)) goto L12;
        AutofillManagerServiceImpl service = peekServiceForUserLocked(userId);     // Catch: Throwable -> L9
        if (service == null) goto L13;
        service.forceRemoveAllSessionsLocked();     // Catch: Throwable -> L9
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L9
        receiver.send(0, new Bundle());     // Catch: RemoteException -> L16
        return;
    L17:
        return;
    L12:
        visitServicesLocked(new AutofillManagerService$$ExternalSyntheticLambda4());     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ void lambda$removeAllSessions$3(AutofillManagerServiceImpl s) {
        s.forceRemoveAllSessionsLocked();
    }

    void listSessions(int userId, IResultReceiver receiver) {
        Slog.i(TAG, "listSessions() for userId " + userId);
        enforceCallingPermissionForManagement();
        Bundle resultData = new Bundle();
        final ArrayList<String> sessions = new ArrayList();
        Object r2 = this.mLock;
        monitor-enter(r2);
        if (userId == (-1)) goto L12;
        AutofillManagerServiceImpl service = peekServiceForUserLocked(userId);     // Catch: Throwable -> L9
        if (service == null) goto L13;
        service.listSessionsLocked(sessions);     // Catch: Throwable -> L9
    L13:
        monitor-exit(r2);     // Catch: Throwable -> L9
        resultData.putStringArrayList(RECEIVER_BUNDLE_EXTRA_SESSIONS, sessions);
        receiver.send(0, resultData);     // Catch: RemoteException -> L17
        return;
    L18:
        return;
    L12:
        visitServicesLocked(new AutofillManagerService$$ExternalSyntheticLambda0(sessions));     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ void lambda$listSessions$4(ArrayList sessions, AutofillManagerServiceImpl s) {
        s.listSessionsLocked(sessions);
    }

    void reset() {
        Slog.i(TAG, "reset()");
        enforceCallingPermissionForManagement();
        Object r0 = this.mLock;
        monitor-enter(r0);
        visitServicesLocked(new AutofillManagerService$$ExternalSyntheticLambda5());     // Catch: Throwable -> L7
        clearCacheLocked();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ void lambda$reset$5(AutofillManagerServiceImpl s) {
        s.destroyLocked();
    }

    void setLogLevel(int level) {
        Slog.i(TAG, "setLogLevel(): " + level);
        enforceCallingPermissionForManagement();
        long token = Binder.clearCallingIdentity();
        Settings.Global.putInt(getContext().getContentResolver(), "autofill_logging_level", level);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(token);
        return;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    private void setLogLevelFromSettings() {
        int level = Settings.Global.getInt(getContext().getContentResolver(), "autofill_logging_level", AutofillManager.DEFAULT_LOGGING_LEVEL);
        boolean debug = false;
        boolean verbose = false;
        if (level != 0) goto L5;
    L11:
        if (debug == false) goto L13;
    L14:
        Slog.d(TAG, "setLogLevelFromSettings(): level=" + level + ", debug=" + debug + ", verbose=" + verbose);
    L15:
        Object r3 = this.mLock;
        monitor-enter(r3);
        setLoggingLevelsLocked(debug, verbose);     // Catch: Throwable -> L20
        monitor-exit(r3);     // Catch: Throwable -> L20
        return;
    L20:
        th = move-exception;
        throw th;
    L13:
        if (Helper.sDebug == false) goto L15;
    L5:
        if (level != 4) goto L8;
        verbose = true;
        debug = true;
        goto L11
    L8:
        if (level != 2) goto L10;
        debug = true;
        goto L11
    L10:
        Slog.w(TAG, "setLogLevelFromSettings(): invalid level: " + level);
        goto L11
    }

    int getLogLevel() {
        enforceCallingPermissionForManagement();
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (Helper.sVerbose == false) goto L12;
        monitor-exit(r0);     // Catch: Throwable -> L9
        return 4;
    L12:
        if (Helper.sDebug == false) goto L16;
        monitor-exit(r0);     // Catch: Throwable -> L9
        return 2;
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return 0;
    }

    int getMaxPartitions() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int r1 = sPartitionMaxCount;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    void setMaxPartitions(int max) {
        Slog.i(TAG, "setMaxPartitions(): " + max);
        enforceCallingPermissionForManagement();
        long token = Binder.clearCallingIdentity();
        Settings.Global.putInt(getContext().getContentResolver(), "autofill_max_partitions_size", max);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(token);
        return;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    private void setMaxPartitionsFromSettings() {
        int max = Settings.Global.getInt(getContext().getContentResolver(), "autofill_max_partitions_size", 10);
        if (Helper.sDebug == false) goto L5;
        Slog.d(TAG, "setMaxPartitionsFromSettings(): " + max);
    L5:
        Object r1 = sLock;
        monitor-enter(r1);
        sPartitionMaxCount = max;     // Catch: Throwable -> L10
        monitor-exit(r1);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    int getMaxVisibleDatasets() {
        Object r0 = sLock;
        monitor-enter(r0);
        int r1 = sVisibleDatasetsMaxCount;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    void setMaxVisibleDatasets(int max) {
        Slog.i(TAG, "setMaxVisibleDatasets(): " + max);
        enforceCallingPermissionForManagement();
        long token = Binder.clearCallingIdentity();
        Settings.Global.putInt(getContext().getContentResolver(), "autofill_max_visible_datasets", max);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(token);
        return;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    private void setMaxVisibleDatasetsFromSettings() {
        int max = Settings.Global.getInt(getContext().getContentResolver(), "autofill_max_visible_datasets", 0);
        if (Helper.sDebug == false) goto L5;
        Slog.d(TAG, "setMaxVisibleDatasetsFromSettings(): " + max);
    L5:
        Object r1 = sLock;
        monitor-enter(r1);
        sVisibleDatasetsMaxCount = max;     // Catch: Throwable -> L10
        monitor-exit(r1);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private void setDeviceConfigProperties() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mAugmentedServiceIdleUnbindTimeoutMs = DeviceConfig.getInt("autofill", "augmented_service_idle_unbind_timeout", 0);     // Catch: Throwable -> L7
        this.mAugmentedServiceRequestTimeoutMs = DeviceConfig.getInt("autofill", "augmented_service_request_timeout", 5000);     // Catch: Throwable -> L7
        this.mSupportedSmartSuggestionModes = DeviceConfig.getInt("autofill", "smart_suggestion_supported_modes", 1);     // Catch: Throwable -> L7
        if (this.verbose == false) goto L9;
        Slog.v(this.mTag, "setDeviceConfigProperties() for AugmentedAutofill: augmentedIdleTimeout=" + this.mAugmentedServiceIdleUnbindTimeoutMs + ", augmentedRequestTimeout=" + this.mAugmentedServiceRequestTimeoutMs + ", smartSuggestionMode=" + AutofillManager.getSmartSuggestionModeToString(this.mSupportedSmartSuggestionModes));     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        Object r1 = this.mFlagLock;
        monitor-enter(r1);
        this.mPccClassificationEnabled = DeviceConfig.getBoolean("autofill", "pcc_classification_enabled", false);     // Catch: Throwable -> L15
        this.mPccPreferProviderOverPcc = DeviceConfig.getBoolean("autofill", "prefer_provider_over_pcc", true);     // Catch: Throwable -> L15
        this.mPccUseFallbackDetection = DeviceConfig.getBoolean("autofill", "pcc_use_fallback", true);     // Catch: Throwable -> L15
        this.mPccProviderHints = DeviceConfig.getString("autofill", "pcc_classification_hints", "");     // Catch: Throwable -> L15
        this.mMaxInputLengthForAutofill = DeviceConfig.getInt("autofill", "max_input_length_for_autofill", 30);     // Catch: Throwable -> L15
        this.mAutofillCredmanIntegrationEnabled = true;     // Catch: Throwable -> L15
        this.mIsFillFieldsFromCurrentSessionOnly = AutofillFeatureFlags.shouldFillFieldsFromCurrentSessionOnly();     // Catch: Throwable -> L15
        if (this.verbose == false) goto L17;
        Slog.v(this.mTag, "setDeviceConfigProperties() for PCC: mPccClassificationEnabled=" + this.mPccClassificationEnabled + ", mPccPreferProviderOverPcc=" + this.mPccPreferProviderOverPcc + ", mPccUseFallbackDetection=" + this.mPccUseFallbackDetection + ", mPccProviderHints=" + this.mPccProviderHints + ", mAutofillCredmanIntegrationEnabled=" + this.mAutofillCredmanIntegrationEnabled + ", mIsFillFieldsFromCurrentSessionOnly=" + this.mIsFillFieldsFromCurrentSessionOnly);     // Catch: Throwable -> L15
    L17:
        monitor-exit(r1);     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        throw th;
    L7:
        th = move-exception;
        throw th;
    }

    private void updateCachedServices() {
        List<UserInfo> supportedUsers = getSupportedUsers();
        Iterator<UserInfo> r1 = supportedUsers.iterator();
    L4:
        if (r1.hasNext() == false) goto L13;
        UserInfo userInfo = r1.next();
        Object r3 = this.mLock;
        monitor-enter(r3);
        updateCachedServiceLocked(userInfo.id);     // Catch: Throwable -> L10
        monitor-exit(r3);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    void calculateScore(String algorithmName, String value1, String value2, RemoteCallback callback) {
        enforceCallingPermissionForManagement();
        FieldClassificationStrategy strategy = new FieldClassificationStrategy(getContext(), -2);
        strategy.calculateScores(callback, Arrays.asList(new AutofillValue[]{AutofillValue.forText(value1)}), new String[]{value2}, new String[]{null}, algorithmName, null, null, null);
    }

    Boolean getFullScreenMode() {
        enforceCallingPermissionForManagement();
        return Helper.sFullScreenMode;
    }

    void setFullScreenMode(Boolean mode) {
        enforceCallingPermissionForManagement();
        Helper.sFullScreenMode = mode;
    }

    void setTemporaryAugmentedAutofillService(int userId, String serviceName, int durationMs) {
        Slog.i(this.mTag, "setTemporaryAugmentedAutofillService(" + userId + ") to " + serviceName + " for " + durationMs + "ms");
        enforceCallingPermissionForManagement();
        serviceName.getClass();
        if (durationMs > 120000) goto L7;
        this.mAugmentedAutofillResolver.setTemporaryService(userId, serviceName, durationMs);
        return;
    L7:
        throw new IllegalArgumentException("Max duration is 120000 (called with " + durationMs + ")");
    }

    void resetTemporaryAugmentedAutofillService(int userId) {
        enforceCallingPermissionForManagement();
        this.mAugmentedAutofillResolver.resetTemporaryService(userId);
    }

    boolean isDefaultAugmentedServiceEnabled(int userId) {
        enforceCallingPermissionForManagement();
        return this.mAugmentedAutofillResolver.isDefaultServiceEnabled(userId);
    }

    boolean setDefaultAugmentedServiceEnabled(int userId, boolean enabled) {
        Slog.i(this.mTag, "setDefaultAugmentedServiceEnabled() for userId " + userId + ": " + enabled);
        enforceCallingPermissionForManagement();
        Object r0 = this.mLock;
        monitor-enter(r0);
        AutofillManagerServiceImpl service = getServiceForUserLocked(userId);     // Catch: Throwable -> L12
        if (service == null) goto L17;
        boolean changed = this.mAugmentedAutofillResolver.setDefaultServiceEnabled(userId, enabled);     // Catch: Throwable -> L12
        if (changed == false) goto L15;
        service.updateRemoteAugmentedAutofillService();     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return true;
    L15:
        if (this.debug == false) goto L17;
        Slog.d(TAG, "setDefaultAugmentedServiceEnabled(): already " + enabled);     // Catch: Throwable -> L12
    L17:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return false;
    L12:
        th = move-exception;
        throw th;
    }

    boolean isFieldDetectionServiceEnabledForUser(int userId) {
        enforceCallingPermissionForManagement();
        Object r0 = this.mLock;
        monitor-enter(r0);
        AutofillManagerServiceImpl service = getServiceForUserLocked(userId);     // Catch: Throwable -> L9
        if (service == null) goto L12;
        boolean r2 = service.isPccClassificationEnabled();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return false;
    L9:
        th = move-exception;
        throw th;
    }

    String getFieldDetectionServiceName(int userId) {
        enforceCallingPermissionForManagement();
        return this.mFieldClassificationResolver.readServiceName(userId);
    }

    boolean setTemporaryDetectionService(int userId, String serviceName, int durationMs) {
        Slog.i(this.mTag, "setTemporaryDetectionService(" + userId + ") to " + serviceName + " for " + durationMs + "ms");
        enforceCallingPermissionForManagement();
        serviceName.getClass();
        this.mFieldClassificationResolver.setTemporaryService(userId, serviceName, durationMs);
        return false;
    }

    void resetTemporaryDetectionService(int userId) {
        enforceCallingPermissionForManagement();
        this.mFieldClassificationResolver.resetTemporaryService(userId);
    }

    boolean requestSavedPasswordCount(int userId, IResultReceiver receiver) {
        enforceCallingPermissionForManagement();
        Object r0 = this.mLock;
        monitor-enter(r0);
        AutofillManagerServiceImpl service = peekServiceForUserLocked(userId);     // Catch: Throwable -> L10
        if (service == null) goto L13;
        service.requestSavedPasswordCount(receiver);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return true;
    L13:
        if (Helper.sVerbose == false) goto L15;
        Slog.v(TAG, "requestSavedPasswordCount(): no service for " + userId);     // Catch: Throwable -> L10
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return false;
    L10:
        th = move-exception;
        throw th;
    }

    private void setLoggingLevelsLocked(boolean debug, boolean verbose) {
        Helper.sDebug = debug;
        android.view.autofill.Helper.sDebug = debug;
        this.debug = debug;
        Helper.sVerbose = verbose;
        android.view.autofill.Helper.sVerbose = verbose;
        this.verbose = verbose;
    }

    private void addCompatibilityModeRequestsLocked(AutofillManagerServiceImpl service, int userId) {
        this.mAutofillCompatState.reset(userId);
        ArrayMap<String, Long> compatPackages = service.getCompatibilityPackagesLocked();
        if (compatPackages == null) goto L24;
        if (compatPackages.isEmpty() == true) goto L29;
        Map<String, String[]> allowedPackages = getAllowedCompatModePackages();
        int compatPackageCount = compatPackages.size();
        int i = 0;
    L8:
        if (i >= compatPackageCount) goto L22;
        String packageName = compatPackages.keyAt(i);
        if (allowedPackages == null) goto L19;
        if (allowedPackages.containsKey(packageName) == false) goto L19;
        Long maxVersionCode = compatPackages.valueAt(i);
        if (maxVersionCode == null) goto L17;
        userId = userId;
        this.mAutofillCompatState.addCompatibilityModeRequest(packageName, maxVersionCode.longValue(), allowedPackages.get(packageName), userId);
    L20:
        i = i + 1;
        userId = userId;
        goto L8
    L17:
        userId = userId;
    L19:
        Slog.w(TAG, "Ignoring not allowed compat package " + packageName);
        goto L20
    L22:
        return;
    L29:
        return;
    }

    private String getAllowedCompatModePackagesFromDeviceConfig() {
        String config = DeviceConfig.getString("autofill", "compat_mode_allowed_packages", null);
        if (TextUtils.isEmpty(config) == true) goto L6;
        return config;
    L6:
        return getAllowedCompatModePackagesFromSettings();
    }

    private String getAllowedCompatModePackagesFromSettings() {
        return Settings.Global.getString(getContext().getContentResolver(), "autofill_compat_mode_allowed_packages");
    }

    private Map<String, String[]> getAllowedCompatModePackages() {
        return getAllowedCompatModePackages(getAllowedCompatModePackagesFromDeviceConfig());
    }

    private void send(IResultReceiver receiver, int value) {
        receiver.send(value, null);     // Catch: RemoteException -> L5
        return;
    L5:
        e = move-exception;
        Slog.w(TAG, "Error async reporting result to client: " + e);
    }

    private void send(IResultReceiver receiver, Bundle value) {
        receiver.send(0, value);     // Catch: RemoteException -> L5
        return;
    L5:
        e = move-exception;
        Slog.w(TAG, "Error async reporting result to client: " + e);
    }

    private void send(IResultReceiver receiver, String value) {
        send(receiver, SyncResultReceiver.bundleFor(value));
    }

    private void send(IResultReceiver receiver, String[] value) {
        send(receiver, SyncResultReceiver.bundleFor(value));
    }

    private void send(IResultReceiver receiver, Parcelable value) {
        send(receiver, SyncResultReceiver.bundleFor(value));
    }

    private void send(IResultReceiver r1, boolean r2) {
        send(r1, r2 ? 1 : 0);
    }

    private void send(IResultReceiver receiver, int value1, int value2) {
        receiver.send(value1, SyncResultReceiver.bundleFor(value2));     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        Slog.w(TAG, "Error async reporting result to client: " + e);
    }

    public boolean isPccClassificationFlagEnabled() {
        Object r0 = this.mFlagLock;
        monitor-enter(r0);
        boolean r1 = this.mPccClassificationEnabled;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean isAutofillCredmanIntegrationEnabled() {
        Object r0 = this.mFlagLock;
        monitor-enter(r0);
        boolean r1 = this.mAutofillCredmanIntegrationEnabled;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean preferProviderOverPcc() {
        Object r0 = this.mFlagLock;
        monitor-enter(r0);
        boolean r1 = this.mPccPreferProviderOverPcc;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean shouldUsePccFallback() {
        Object r0 = this.mFlagLock;
        monitor-enter(r0);
        boolean r1 = this.mPccUseFallbackDetection;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public String getPccProviderHints() {
        Object r0 = this.mFlagLock;
        monitor-enter(r0);
        String r1 = this.mPccProviderHints;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public int getMaxInputLengthForAutofill() {
        Object r0 = this.mFlagLock;
        monitor-enter(r0);
        int r1 = this.mMaxInputLengthForAutofill;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean getIsFillFieldsFromCurrentSessionOnly() {
        Object r0 = this.mFlagLock;
        monitor-enter(r0);
        boolean r1 = this.mIsFillFieldsFromCurrentSessionOnly;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    static Map<String, String[]> getAllowedCompatModePackages(String setting) {
        if (TextUtils.isEmpty(setting) == false) goto L5;
        return null;
    L5:
        ArrayMap<String, String[]> compatPackages = new ArrayMap();
        TextUtils.SimpleStringSplitter splitter = new TextUtils.SimpleStringSplitter(COMPAT_PACKAGE_DELIMITER);
        splitter.setString(setting);
    L7:
        if (splitter.hasNext() == false) goto L26;
        String packageBlock = splitter.next();
        int urlBlockIndex = packageBlock.indexOf(91);
        if (urlBlockIndex == (-1)) goto L10;
        if (packageBlock.charAt(packageBlock.length() - 1) == ']') goto L14;
        Slog.w(TAG, "Ignoring entry '" + packageBlock + "' on '" + setting + "'because it does not end on '" + COMPAT_PACKAGE_URL_IDS_BLOCK_END + "'");
        goto L7
    L14:
        String packageName = packageBlock.substring(0, urlBlockIndex);
        List<String> urlBarIds = new ArrayList();
        String urlBarIdsBlock = packageBlock.substring(urlBlockIndex + 1, packageBlock.length() - 1);
        if (Helper.sVerbose == false) goto L17;
        Slog.v(TAG, "pkg:" + packageName + ": block:" + packageBlock + ": urls:" + urlBarIds + ": block:" + urlBarIdsBlock + ":");
    L17:
        TextUtils.SimpleStringSplitter splitter2 = new TextUtils.SimpleStringSplitter(COMPAT_PACKAGE_URL_IDS_DELIMITER);
        splitter2.setString(urlBarIdsBlock);
    L19:
        if (splitter2.hasNext() == false) goto L21;
        String urlBarId = splitter2.next();
        urlBarIds.add(urlBarId);
        goto L19
    L21:
        List<String> urlBarIds2 = urlBarIds;
    L22:
        if (urlBarIds2 == null) goto L23;
        String[] urlBarIdsArray = new String[urlBarIds2.size()];
        urlBarIds2.toArray(urlBarIdsArray);
        compatPackages.put(packageName, urlBarIdsArray);
        goto L7
    L23:
        compatPackages.put(packageName, null);
        goto L7
    L10:
        packageName = packageBlock;
        urlBarIds2 = null;
        goto L22
    L26:
        return compatPackages;
    }

    public static int getPartitionMaxCount() {
        Object r0 = sLock;
        monitor-enter(r0);
        int r1 = sPartitionMaxCount;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public static int getVisibleDatasetsMaxCount() {
        Object r0 = sLock;
        monitor-enter(r0);
        int r1 = sVisibleDatasetsMaxCount;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public IExtAutofillManagerService getExt() {
        return this.mExt;
    }
}
