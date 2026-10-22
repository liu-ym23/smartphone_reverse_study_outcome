package com.android.server.contentcapture;

import android.R;
import android.app.ActivityManagerInternal;
import android.app.ActivityThread;
import android.app.admin.DevicePolicyCache;
import android.app.assist.ActivityId;
import android.app.assist.AssistContent;
import android.content.ComponentName;
import android.content.ContentCaptureOptions;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityPresentationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ParceledListSlice;
import android.content.pm.UserInfo;
import android.database.ContentObserver;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.os.ShellCallback;
import android.os.UserHandle;
import android.provider.DeviceConfig;
import android.provider.Settings;
import android.service.contentcapture.ContentCaptureService;
import android.service.contentcapture.ContentCaptureServiceInfo;
import android.service.contentcapture.IDataShareCallback;
import android.service.contentcapture.IDataShareReadAdapter;
import android.service.voice.VoiceInteractionManagerInternal;
import android.util.ArraySet;
import android.util.LocalLog;
import android.util.Pair;
import android.util.Slog;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.view.contentcapture.ContentCaptureCondition;
import android.view.contentcapture.ContentCaptureEvent;
import android.view.contentcapture.ContentCaptureHelper;
import android.view.contentcapture.ContentCaptureManager;
import android.view.contentcapture.DataRemovalRequest;
import android.view.contentcapture.DataShareRequest;
import android.view.contentcapture.IContentCaptureManager;
import android.view.contentcapture.IContentCaptureOptionsCallback;
import android.view.contentcapture.IDataShareWriteAdapter;
import com.android.internal.infra.GlobalWhitelistState;
import com.android.internal.os.BackgroundThread;
import com.android.internal.os.IResultReceiver;
import com.android.internal.util.DumpUtils;
import com.android.internal.util.SyncResultReceiver;
import com.android.server.LocalServices;
import com.android.server.SystemService;
import com.android.server.backup.BackupAgentTimeoutParameters;
import com.android.server.contentprotection.ContentProtectionAllowlistManager;
import com.android.server.contentprotection.ContentProtectionConsentManager;
import com.android.server.contentprotection.RemoteContentProtectionService;
import com.android.server.infra.AbstractMasterSystemService;
import com.android.server.infra.AbstractPerUserSystemService;
import com.android.server.infra.FrameworkResourcesServiceNameResolver;
import com.android.server.infra.ServiceNameResolver;
import com.android.server.wm.ActivityTaskManagerInternal;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class ContentCaptureManagerService extends AbstractMasterSystemService<ContentCaptureManagerService, ContentCapturePerUserService> {
    private static final String CONTENT_PROTECTION_GROUP_CONFIG_SEPARATOR_GROUP = ";";
    private static final String CONTENT_PROTECTION_GROUP_CONFIG_SEPARATOR_VALUE = ",";
    private static final int DATA_SHARE_BYTE_BUFFER_LENGTH = 1024;
    private static final int EVENT__DATA_SHARE_ERROR_CONCURRENT_REQUEST = 14;
    private static final int EVENT__DATA_SHARE_ERROR_TIMEOUT_INTERRUPTED = 15;
    private static final int EVENT__DATA_SHARE_WRITE_FINISHED = 9;
    private static final int MAX_CONCURRENT_FILE_SHARING_REQUESTS = 10;
    private static final int MAX_DATA_SHARE_FILE_DESCRIPTORS_TTL_MS = 300000;
    private static final int MAX_TEMP_SERVICE_DURATION_MS = 120000;
    static final String RECEIVER_BUNDLE_EXTRA_SESSIONS = "sessions";
    private static final String TAG = null;
    private boolean activityStartAssistDataEnabled;
    private ActivityManagerInternal mAm;
    private final RemoteCallbackList<IContentCaptureOptionsCallback> mCallbacks;
    private final ContentCaptureManagerServiceStub mContentCaptureManagerServiceStub;
    private ContentProtectionAllowlistManager mContentProtectionAllowlistManager;
    private ContentProtectionConsentManager mContentProtectionConsentManager;
    private ComponentName mContentProtectionServiceComponentName;
    private final Executor mDataShareExecutor;
    long mDevCfgContentProtectionAllowlistDelayMs;
    long mDevCfgContentProtectionAllowlistTimeoutMs;
    long mDevCfgContentProtectionAutoDisconnectTimeoutMs;
    int mDevCfgContentProtectionBufferSize;
    List<List<String>> mDevCfgContentProtectionOptionalGroups;
    int mDevCfgContentProtectionOptionalGroupsThreshold;
    List<List<String>> mDevCfgContentProtectionRequiredGroups;
    boolean mDevCfgDisableFlushForViewTreeAppearing;
    boolean mDevCfgEnableContentProtectionReceiver;
    int mDevCfgIdleFlushingFrequencyMs;
    int mDevCfgIdleUnbindTimeoutMs;
    int mDevCfgLogHistorySize;
    int mDevCfgLoggingLevel;
    int mDevCfgMaxBufferSize;
    int mDevCfgTextChangeFlushingFrequencyMs;
    private boolean mDisabledByDeviceConfig;
    private SparseBooleanArray mDisabledBySettings;
    final GlobalContentCaptureOptions mGlobalContentCaptureOptions;
    private final Handler mHandler;
    private final LocalService mLocalService;
    private final Set<String> mPackagesWithShareRequests;
    final LocalLog mRequestsHistory;

    final class ContentCaptureManagerServiceStub extends IContentCaptureManager.Stub {
        final /* synthetic */ ContentCaptureManagerService this$0;

        public static /* synthetic */ void $r8$lambda$BXYH1H82UEMcKsGb5SHmtOukFeo(ContentCaptureManagerServiceStub r0) {
            r0.lambda$isContentCaptureFeatureEnabled$0();
        }

        /* JADX INFO: renamed from: $r8$lambda$DXWmFu04RayCsyhZ-XQ8oMsVUME, reason: not valid java name */
        public static /* synthetic */ void m3220$r8$lambda$DXWmFu04RayCsyhZXQ8oMsVUME(ContentCaptureManagerServiceStub r0, ParceledListSlice r1) {
            r0.lambda$onLoginDetected$3(r1);
        }

        public static /* synthetic */ void $r8$lambda$i412hwiOX33HCzmNv6uZlXA7CVU(ContentCaptureManagerServiceStub r0) {
            r0.lambda$getServiceSettingsActivity$1();
        }

        public static /* synthetic */ void $r8$lambda$yJjaDLoeJrg1lAGCwxWryxbVBls(ContentCaptureManagerServiceStub r0, String r1) {
            r0.lambda$getContentCaptureConditions$2(r1);
        }

        ContentCaptureManagerServiceStub(ContentCaptureManagerService this$0) {
            this.this$0 = this$0;
        }

        public void startSession(IBinder activityToken, IBinder shareableActivityToken, ComponentName componentName, int sessionId, int flags, IResultReceiver result) {
            activityToken.getClass();
            shareableActivityToken.getClass();
            int userId = UserHandle.getCallingUserId();
            ActivityPresentationInfo activityPresentationInfo = ContentCaptureManagerService.m3213$$Nest$mgetAmInternal(this.this$0).getActivityPresentationInfo(activityToken);
            Object r10 = ContentCaptureManagerService.access$000(this.this$0);
            monitor-enter(r10);
            ContentCapturePerUserService service = (ContentCapturePerUserService) ContentCaptureManagerService.access$100(this.this$0, userId);     // Catch: Throwable -> L12
            if (ContentCaptureManagerService.m3216$$Nest$misDefaultServiceLocked(this.this$0, userId) == true) goto L17;
            if (ContentCaptureManagerService.m3214$$Nest$misCalledByServiceLocked(this.this$0, "startSession()") == true) goto L17;
            ContentCaptureService.setClientState(result, 4, null);     // Catch: Throwable -> L12
            monitor-exit(r10);     // Catch: Throwable -> L12
            return;
        L15:
            th = th;
        L20:
            monitor-exit(r10);     // Catch: Throwable -> L12
            throw th;
        L17:
            service.startSessionLocked(activityToken, shareableActivityToken, activityPresentationInfo, sessionId, Binder.getCallingUid(), flags, result);     // Catch: Throwable -> L12
            monitor-exit(r10);     // Catch: Throwable -> L12
            return;
        L12:
            th = th;
            goto L20
        }

        public void finishSession(int sessionId) {
            int userId = UserHandle.getCallingUserId();
            Object r1 = ContentCaptureManagerService.access$200(this.this$0);
            monitor-enter(r1);
            ContentCapturePerUserService service = (ContentCapturePerUserService) ContentCaptureManagerService.access$300(this.this$0, userId);     // Catch: Throwable -> L7
            service.finishSessionLocked(sessionId);     // Catch: Throwable -> L7
            monitor-exit(r1);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public void getServiceComponentName(IResultReceiver result) {
            int userId = UserHandle.getCallingUserId();
            Object r1 = ContentCaptureManagerService.access$400(this.this$0);
            monitor-enter(r1);
            ContentCapturePerUserService service = (ContentCapturePerUserService) ContentCaptureManagerService.access$500(this.this$0, userId);     // Catch: Throwable -> L11
            ComponentName connectedServiceComponentName = service.getServiceComponentName();     // Catch: Throwable -> L11
            monitor-exit(r1);     // Catch: Throwable -> L11
            result.send(0, SyncResultReceiver.bundleFor(connectedServiceComponentName));     // Catch: RemoteException -> L8
            return;
        L8:
            e = move-exception;
            Slog.w(ContentCaptureManagerService.m3219$$Nest$sfgetTAG(), "Unable to send service component name: " + e);
            return;
        L11:
            th = move-exception;
            throw th;
        }

        public void removeData(DataRemovalRequest request) {
            request.getClass();
            this.this$0.assertCalledByPackageOwner(request.getPackageName());
            int userId = UserHandle.getCallingUserId();
            Object r1 = ContentCaptureManagerService.access$600(this.this$0);
            monitor-enter(r1);
            ContentCapturePerUserService service = (ContentCapturePerUserService) ContentCaptureManagerService.access$700(this.this$0, userId);     // Catch: Throwable -> L7
            service.removeDataLocked(request);     // Catch: Throwable -> L7
            monitor-exit(r1);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public void shareData(DataShareRequest request, IDataShareWriteAdapter clientAdapter) {
            request.getClass();
            clientAdapter.getClass();
            this.this$0.assertCalledByPackageOwner(request.getPackageName());
            int userId = UserHandle.getCallingUserId();
            Object r1 = ContentCaptureManagerService.access$800(this.this$0);
            monitor-enter(r1);
            ContentCapturePerUserService service = (ContentCapturePerUserService) ContentCaptureManagerService.access$900(this.this$0, userId);     // Catch: Throwable -> L12
            if (ContentCaptureManagerService.m3211$$Nest$fgetmPackagesWithShareRequests(this.this$0).size() < 10) goto L7;
        L22:
            String serviceName = ContentCaptureManagerService.access$1000(this.this$0).getServiceName(userId);     // Catch: Throwable -> L12 RemoteException -> L16
            ContentCaptureMetricsLogger.writeServiceEvent(14, serviceName);     // Catch: Throwable -> L12 RemoteException -> L16
            clientAdapter.error(2);     // Catch: Throwable -> L12 RemoteException -> L16
        L18:
            monitor-exit(r1);     // Catch: Throwable -> L12
            return;
        L17:
            Slog.e(ContentCaptureManagerService.m3219$$Nest$sfgetTAG(), "Failed to send error message to client");     // Catch: Throwable -> L12
            goto L18
        L7:
            if (ContentCaptureManagerService.m3211$$Nest$fgetmPackagesWithShareRequests(this.this$0).contains(request.getPackageName()) == true) goto L22;
            service.onDataSharedLocked(request, new DataShareCallbackDelegate(request, clientAdapter, this.this$0));     // Catch: Throwable -> L12
            monitor-exit(r1);     // Catch: Throwable -> L12
            return;
        L12:
            th = move-exception;
            throw th;
        }

        public void isContentCaptureFeatureEnabled(IResultReceiver result) {
            Object r0 = ContentCaptureManagerService.access$1100(this.this$0);
            monitor-enter(r0);
        L8:
            th = move-exception;
            throw th;
        L5:
            if (ContentCaptureManagerService.m3218$$Nest$mthrowsSecurityException(this.this$0, result, new ContentCaptureManagerService$ContentCaptureManagerServiceStub$$ExternalSyntheticLambda3(this)) == false) goto L10;
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L10:
            int userId = UserHandle.getCallingUserId();     // Catch: Throwable -> L8
            int r3 = 1;
            if (ContentCaptureManagerService.m3209$$Nest$fgetmDisabledByDeviceConfig(this.this$0) == false) goto L13;
        L15:
            boolean enabled = false;
        L17:
            monitor-exit(r0);     // Catch: Throwable -> L8
            if (enabled == true) goto L30;
            r3 = 2;
        L30:
            result.send(r3, null);     // Catch: RemoteException -> L24
            return;
        L24:
            e = move-exception;
            Slog.w(ContentCaptureManagerService.m3219$$Nest$sfgetTAG(), "Unable to send isContentCaptureFeatureEnabled(): " + e);
            return;
        L13:
            if (ContentCaptureManagerService.m3217$$Nest$misDisabledBySettingsLocked(this.this$0, userId) == true) goto L15;
            enabled = true;
            goto L17
        }

        private /* synthetic */ void lambda$isContentCaptureFeatureEnabled$0() {
            ContentCaptureManagerService.m3212$$Nest$massertCalledByServiceLocked(this.this$0, "isContentCaptureFeatureEnabled()");
        }

        private /* synthetic */ void lambda$getServiceSettingsActivity$1() {
            this.this$0.enforceCallingPermissionForManagement();
        }

        public void getServiceSettingsActivity(IResultReceiver result) {
            if (ContentCaptureManagerService.m3218$$Nest$mthrowsSecurityException(this.this$0, result, new ContentCaptureManagerService$ContentCaptureManagerServiceStub$$ExternalSyntheticLambda1(this)) == false) goto L5;
            return;
        L5:
            int userId = UserHandle.getCallingUserId();
            Object r1 = ContentCaptureManagerService.access$1200(this.this$0);
            monitor-enter(r1);
            ContentCapturePerUserService service = (ContentCapturePerUserService) ContentCaptureManagerService.access$1300(this.this$0, userId);     // Catch: Throwable -> L11
            if (service != null) goto L13;
            monitor-exit(r1);     // Catch: Throwable -> L11
            return;
        L13:
            ComponentName componentName = service.getServiceSettingsActivityLocked();     // Catch: Throwable -> L11
            monitor-exit(r1);     // Catch: Throwable -> L11
            result.send(0, SyncResultReceiver.bundleFor(componentName));     // Catch: RemoteException -> L17
            return;
        L17:
            e = move-exception;
            Slog.w(ContentCaptureManagerService.m3219$$Nest$sfgetTAG(), "Unable to send getServiceSettingsIntent(): " + e);
            return;
        L11:
            th = move-exception;
            throw th;
        }

        private /* synthetic */ void lambda$getContentCaptureConditions$2(String packageName) {
            this.this$0.assertCalledByPackageOwner(packageName);
        }

        public void getContentCaptureConditions(final String packageName, IResultReceiver result) {
            if (ContentCaptureManagerService.m3218$$Nest$mthrowsSecurityException(this.this$0, result, new ContentCaptureManagerService$ContentCaptureManagerServiceStub$$ExternalSyntheticLambda2(this, packageName)) == false) goto L5;
            return;
        L5:
            int userId = UserHandle.getCallingUserId();
            Object r1 = ContentCaptureManagerService.access$1400(this.this$0);
            monitor-enter(r1);
            ContentCapturePerUserService service = (ContentCapturePerUserService) ContentCaptureManagerService.access$1500(this.this$0, userId);     // Catch: Throwable -> L18
            if (service != null) goto L10;
            ArrayList<ContentCaptureCondition> conditions = null;
        L12:
            monitor-exit(r1);     // Catch: Throwable -> L18
            result.send(0, SyncResultReceiver.bundleFor(conditions));     // Catch: RemoteException -> L15
            return;
        L15:
            e = move-exception;
            Slog.w(ContentCaptureManagerService.m3219$$Nest$sfgetTAG(), "Unable to send getServiceComponentName(): " + e);
            return;
        L10:
            conditions = ContentCaptureHelper.toList(service.getContentCaptureConditionsLocked(packageName));     // Catch: Throwable -> L18
        L18:
            th = move-exception;
            throw th;
        }

        public void registerContentCaptureOptionsCallback(String packageName, IContentCaptureOptionsCallback callback) {
            this.this$0.assertCalledByPackageOwner(packageName);
            ContentCaptureManagerService.m3205$$Nest$fgetmCallbacks(this.this$0).register(callback, packageName);
            int userId = UserHandle.getCallingUserId();
            ContentCaptureOptions options = this.this$0.mGlobalContentCaptureOptions.getOptions(userId, packageName);
            if (options == null) goto L11;
            callback.setContentCaptureOptions(options);     // Catch: RemoteException -> L6
            return;
        L6:
            e = move-exception;
            Slog.w(ContentCaptureManagerService.m3219$$Nest$sfgetTAG(), "Unable to send setContentCaptureOptions(): " + e);
            return;
        }

        public void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
            if (DumpUtils.checkDumpPermission(this.this$0.getContext(), ContentCaptureManagerService.m3219$$Nest$sfgetTAG(), pw) == true) goto L5;
            return;
        L5:
            boolean showHistory = true;
            if (args == null) goto L26;
            int r1 = args.length;
            int r3 = 0;
        L9:
            if (r3 >= r1) goto L26;
            String arg = args[r3];
            switch(arg.hashCode()) {
                case 1098711592: goto L17;
                case 1333069025: goto L14;
                default: goto L19;
            };
        L19:
            byte r5 = -1;
        L20:
            switch(r5) {
                case 0: goto L24;
                case 1: goto L22;
                default: goto L21;
            };
        L21:
            Slog.w(ContentCaptureManagerService.m3219$$Nest$sfgetTAG(), "Ignoring invalid dump arg: " + arg);
        L25:
            r3 = r3 + 1;
            goto L9
        L24:
            showHistory = false;
            goto L25
        L22:
            pw.println("Usage: dumpsys content_capture [--no-history]");
            return;
        L14:
            if (arg.equals("--help") == false) goto L19;
            r5 = 1;
            goto L20
        L17:
            if (arg.equals("--no-history") == false) goto L19;
            r5 = 0;
        L26:
            Object r2 = ContentCaptureManagerService.access$1600(this.this$0);
            monitor-enter(r2);
            this.this$0.dumpLocked("", pw);     // Catch: Throwable -> L37
            monitor-exit(r2);     // Catch: Throwable -> L37
            pw.print("Requests history: ");
            if (this.this$0.mRequestsHistory != null) goto L33;
            pw.println("disabled by device config");
            return;
        L33:
            if (showHistory == false) goto L35;
            pw.println();
            this.this$0.mRequestsHistory.reverseDump(fd, pw, args);
            pw.println();
            return;
        L35:
            pw.println();
            return;
        L37:
            th = move-exception;
            throw th;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void onShellCommand(FileDescriptor in, FileDescriptor out, FileDescriptor err, String[] args, ShellCallback callback, ResultReceiver resultReceiver) throws RemoteException {
            new ContentCaptureManagerServiceShellCommand(this.this$0).exec(this, in, out, err, args, callback, resultReceiver);
        }

        public void resetTemporaryService(int userId) {
            this.this$0.resetTemporaryService(userId);
        }

        public void setTemporaryService(int userId, String serviceName, int duration) {
            this.this$0.setTemporaryService(userId, serviceName, duration);
        }

        public void setDefaultServiceEnabled(int userId, boolean enabled) {
            this.this$0.setDefaultServiceEnabled(userId, enabled);
        }

        public void onLoginDetected(final ParceledListSlice<ContentCaptureEvent> events) {
            Binder.withCleanCallingIdentity(new ContentCaptureManagerService$ContentCaptureManagerServiceStub$$ExternalSyntheticLambda0(this, events));
        }

        private /* synthetic */ void lambda$onLoginDetected$3(ParceledListSlice events) throws Exception {
            RemoteContentProtectionService service = this.this$0.createRemoteContentProtectionService();
            if (service != null) goto L10;
            return;
        L10:
            service.onLoginDetected(events);     // Catch: Exception -> L7
            return;
        L7:
            ex = move-exception;
            Slog.e(ContentCaptureManagerService.m3219$$Nest$sfgetTAG(), "Failed to call remote service", ex);
        }
    }

    private static class DataShareCallbackDelegate extends IDataShareCallback.Stub {
        private final IDataShareWriteAdapter mClientAdapter;
        private final DataShareRequest mDataShareRequest;
        private final AtomicBoolean mLoggedWriteFinish;
        private final ContentCaptureManagerService mParentService;

        public static /* synthetic */ void $r8$lambda$DD_FRqaxEoWTCOKS9hzOmbL1Zkc(DataShareCallbackDelegate r0, ParcelFileDescriptor r1, ParcelFileDescriptor r2, ParcelFileDescriptor r3, ParcelFileDescriptor r4, IDataShareReadAdapter r5) {
            r0.lambda$accept$1(r1, r2, r3, r4, r5);
        }

        /* JADX INFO: renamed from: $r8$lambda$bUkmSdVDf7snBFG-L5jf7UpcaUc, reason: not valid java name */
        public static /* synthetic */ void m3221$r8$lambda$bUkmSdVDf7snBFGL5jf7UpcaUc(DataShareCallbackDelegate r0, ParcelFileDescriptor r1, ParcelFileDescriptor r2, IDataShareReadAdapter r3) {
            r0.lambda$accept$0(r1, r2, r3);
        }

        DataShareCallbackDelegate(DataShareRequest dataShareRequest, IDataShareWriteAdapter clientAdapter, ContentCaptureManagerService parentService) {
            this.mLoggedWriteFinish = new AtomicBoolean(false);
            this.mDataShareRequest = dataShareRequest;
            this.mClientAdapter = clientAdapter;
            this.mParentService = parentService;
        }

        public void accept(final IDataShareReadAdapter serviceAdapter) {
            Slog.i(ContentCaptureManagerService.m3219$$Nest$sfgetTAG(), "Data share request accepted by Content Capture service");
            logServiceEvent(7);
            Pair<ParcelFileDescriptor, ParcelFileDescriptor> clientPipe = createPipe();
            if (clientPipe != null) goto L6;
            logServiceEvent(12);
            sendErrorSignal(this.mClientAdapter, serviceAdapter, 1);
            return;
        L6:
            final ParcelFileDescriptor sourceIn = (ParcelFileDescriptor) clientPipe.second;
            final ParcelFileDescriptor sinkIn = (ParcelFileDescriptor) clientPipe.first;
            Pair<ParcelFileDescriptor, ParcelFileDescriptor> servicePipe = createPipe();
            if (servicePipe != null) goto L10;
            logServiceEvent(13);
            bestEffortCloseFileDescriptors(new ParcelFileDescriptor[]{sourceIn, sinkIn});
            sendErrorSignal(this.mClientAdapter, serviceAdapter, 1);
            return;
        L10:
            final ParcelFileDescriptor sourceOut = (ParcelFileDescriptor) servicePipe.second;
            final ParcelFileDescriptor sinkOut = (ParcelFileDescriptor) servicePipe.first;
            Object r9 = ContentCaptureManagerService.access$2800(this.mParentService);
            monitor-enter(r9);
            ContentCaptureManagerService.m3211$$Nest$fgetmPackagesWithShareRequests(this.mParentService).add(this.mDataShareRequest.getPackageName());     // Catch: Throwable -> L26
            monitor-exit(r9);     // Catch: Throwable -> L26
            if (setUpSharingPipeline(this.mClientAdapter, serviceAdapter, sourceIn, sinkOut) == true) goto L24;
            sendErrorSignal(this.mClientAdapter, serviceAdapter, 1);
            bestEffortCloseFileDescriptors(new ParcelFileDescriptor[]{sourceIn, sinkIn, sourceOut, sinkOut});
            Object r10 = ContentCaptureManagerService.access$2900(this.mParentService);
            monitor-enter(r10);
            ContentCaptureManagerService.m3211$$Nest$fgetmPackagesWithShareRequests(this.mParentService).remove(this.mDataShareRequest.getPackageName());     // Catch: Throwable -> L21
            monitor-exit(r10);     // Catch: Throwable -> L21
            return;
        L21:
            th = move-exception;
            throw th;
        L24:
            bestEffortCloseFileDescriptors(new ParcelFileDescriptor[]{sourceIn, sinkOut});
            ContentCaptureManagerService.m3208$$Nest$fgetmDataShareExecutor(this.mParentService).execute(new ContentCaptureManagerService$DataShareCallbackDelegate$$ExternalSyntheticLambda0(this, sinkIn, sourceOut, serviceAdapter));
            ContentCaptureManagerService.m3210$$Nest$fgetmHandler(this.mParentService).postDelayed(new ContentCaptureManagerService$DataShareCallbackDelegate$$ExternalSyntheticLambda1(this, sourceIn, sinkIn, sourceOut, sinkOut, serviceAdapter), 300000);
            return;
        L26:
            th = move-exception;
            throw th;
        }

        private /* synthetic */ void lambda$accept$0(ParcelFileDescriptor sinkIn, ParcelFileDescriptor sourceOut, IDataShareReadAdapter serviceAdapter) {
            boolean receivedData = false;
            InputStream fis = new ParcelFileDescriptor.AutoCloseInputStream(sinkIn);     // Catch: Throwable -> L32 IOException -> L34
            OutputStream fos = new ParcelFileDescriptor.AutoCloseOutputStream(sourceOut);     // Catch: Throwable -> L36
            byte[] byteBuffer = new byte[1024];     // Catch: Throwable -> L41
        L7:
            int readBytes = fis.read(byteBuffer);     // Catch: Throwable -> L41
            if (readBytes == (-1)) goto L10;
            fos.write(byteBuffer, 0, readBytes);     // Catch: Throwable -> L41
            receivedData = true;
            goto L7
        L10:
            fos.close();     // Catch: Throwable -> L36
            fis.close();     // Catch: Throwable -> L32 IOException -> L34
            Object r4 = ContentCaptureManagerService.access$3200(this.mParentService);
            monitor-enter(r4);
            ContentCaptureManagerService.m3211$$Nest$fgetmPackagesWithShareRequests(this.mParentService).remove(this.mDataShareRequest.getPackageName());     // Catch: Throwable -> L29
            monitor-exit(r4);     // Catch: Throwable -> L29
            if (receivedData == true) goto L18;
        L28:
            logServiceEvent(11);
            sendErrorSignal(this.mClientAdapter, serviceAdapter, 1);
            return;
        L18:
            if (this.mLoggedWriteFinish.get() == true) goto L104;
            logServiceEvent(9);
            this.mLoggedWriteFinish.set(true);
        L104:
            this.mClientAdapter.finish();     // Catch: RemoteException -> L22
        L24:
            serviceAdapter.finish();     // Catch: RemoteException -> L26
            return;
        L22:
            e = move-exception;
            Slog.e(ContentCaptureManagerService.m3219$$Nest$sfgetTAG(), "Failed to call finish() the client operation", e);
        L29:
            th = move-exception;
            throw th;
        L41:
            th = move-exception;
            fos.close();     // Catch: Throwable -> L44
        L46:
            throw th;     // Catch: Throwable -> L36
        L44:
            th = move-exception;
            th.addSuppressed(th);     // Catch: Throwable -> L36
        L36:
            th = move-exception;
            fis.close();     // Catch: Throwable -> L49
        L51:
            throw th;     // Catch: Throwable -> L32 IOException -> L34
        L49:
            th = move-exception;
            th.addSuppressed(th);     // Catch: Throwable -> L32 IOException -> L34
        L26:
            e = move-exception;
            Slog.e(ContentCaptureManagerService.m3219$$Nest$sfgetTAG(), "Failed to call finish() the service operation", e);
            return;
        L34:
            e = move-exception;
            Slog.e(ContentCaptureManagerService.m3219$$Nest$sfgetTAG(), "Failed to pipe client and service streams", e);     // Catch: Throwable -> L32
            logServiceEvent(10);     // Catch: Throwable -> L32
            sendErrorSignal(this.mClientAdapter, serviceAdapter, 1);     // Catch: Throwable -> L32
            monitor-enter(ContentCaptureManagerService.access$3200(this.mParentService));
            ContentCaptureManagerService.m3211$$Nest$fgetmPackagesWithShareRequests(this.mParentService).remove(this.mDataShareRequest.getPackageName());     // Catch: Throwable -> L69
            if (0 == 0) goto L28;
            if (this.mLoggedWriteFinish.get() == true) goto L111;
            logServiceEvent(9);
            this.mLoggedWriteFinish.set(true);
        L111:
            this.mClientAdapter.finish();     // Catch: RemoteException -> L64
        L66:
            serviceAdapter.finish();     // Catch: RemoteException -> L26
            return;
        L64:
            e = move-exception;
            Slog.e(ContentCaptureManagerService.m3219$$Nest$sfgetTAG(), "Failed to call finish() the client operation", e);
        L69:
            th = move-exception;
            throw th;
        L32:
            th = move-exception;
            monitor-enter(ContentCaptureManagerService.access$3200(this.mParentService));
            ContentCaptureManagerService.m3211$$Nest$fgetmPackagesWithShareRequests(this.mParentService).remove(this.mDataShareRequest.getPackageName());     // Catch: Throwable -> L90
            if (0 != 0) goto L78;
            logServiceEvent(11);
            sendErrorSignal(this.mClientAdapter, serviceAdapter, 1);
        L89:
            throw th;
        L78:
            if (this.mLoggedWriteFinish.get() == true) goto L94;
            logServiceEvent(9);
            this.mLoggedWriteFinish.set(true);
        L94:
            this.mClientAdapter.finish();     // Catch: RemoteException -> L82
        L98:
            serviceAdapter.finish();     // Catch: RemoteException -> L86
        L86:
            e = move-exception;
            Slog.e(ContentCaptureManagerService.m3219$$Nest$sfgetTAG(), "Failed to call finish() the service operation", e);
        L82:
            e = move-exception;
            Slog.e(ContentCaptureManagerService.m3219$$Nest$sfgetTAG(), "Failed to call finish() the client operation", e);
        L90:
            th = move-exception;
            throw th;
        }

        private /* synthetic */ void lambda$accept$1(ParcelFileDescriptor sourceIn, ParcelFileDescriptor sinkIn, ParcelFileDescriptor sourceOut, ParcelFileDescriptor sinkOut, IDataShareReadAdapter serviceAdapter) {
            enforceDataSharingTtl(sourceIn, sinkIn, sourceOut, sinkOut, serviceAdapter);
        }

        public void reject() {
            Slog.i(ContentCaptureManagerService.m3219$$Nest$sfgetTAG(), "Data share request rejected by Content Capture service");
            logServiceEvent(8);
            this.mClientAdapter.rejected();     // Catch: RemoteException -> L5
            return;
        L5:
            e = move-exception;
            Slog.w(ContentCaptureManagerService.m3219$$Nest$sfgetTAG(), "Failed to call rejected() the client operation", e);
            this.mClientAdapter.error(1);     // Catch: RemoteException -> L9
            return;
        L9:
            e2 = move-exception;
            Slog.w(ContentCaptureManagerService.m3219$$Nest$sfgetTAG(), "Failed to call error() the client operation", e2);
        }

        private boolean setUpSharingPipeline(IDataShareWriteAdapter clientAdapter, IDataShareReadAdapter serviceAdapter, ParcelFileDescriptor sourceIn, ParcelFileDescriptor sinkOut) {
            clientAdapter.write(sourceIn);     // Catch: RemoteException -> L10
            serviceAdapter.start(sinkOut);     // Catch: RemoteException -> L7
            return true;
        L7:
            e = move-exception;
            Slog.e(ContentCaptureManagerService.m3219$$Nest$sfgetTAG(), "Failed to call start() the service operation", e);
            logServiceEvent(13);
            return false;
        L10:
            e = move-exception;
            Slog.e(ContentCaptureManagerService.m3219$$Nest$sfgetTAG(), "Failed to call write() the client operation", e);
            logServiceEvent(12);
            return false;
        }

        private void enforceDataSharingTtl(ParcelFileDescriptor sourceIn, ParcelFileDescriptor sinkIn, ParcelFileDescriptor sourceOut, ParcelFileDescriptor sinkOut, IDataShareReadAdapter serviceAdapter) {
            Object r0 = ContentCaptureManagerService.access$3000(this.mParentService);
            monitor-enter(r0);
            ContentCaptureManagerService.m3211$$Nest$fgetmPackagesWithShareRequests(this.mParentService).remove(this.mDataShareRequest.getPackageName());     // Catch: Throwable -> L9
            if (sinkIn.getFileDescriptor().valid() == false) goto L7;
        L11:
            boolean finishedSuccessfully = false;
        L13:
            if (finishedSuccessfully == true) goto L15;
            logServiceEvent(15);     // Catch: Throwable -> L9
            Slog.i(ContentCaptureManagerService.m3219$$Nest$sfgetTAG(), "Reached the timeout of Content Capture data sharing session for package '" + this.mDataShareRequest.getPackageName() + "', terminating the pipe.");     // Catch: Throwable -> L9
        L19:
            bestEffortCloseFileDescriptors(new ParcelFileDescriptor[]{sourceIn, sinkIn, sourceOut, sinkOut});     // Catch: Throwable -> L9
            if (finishedSuccessfully == true) goto L22;
            sendErrorSignal(this.mClientAdapter, serviceAdapter, 3);     // Catch: Throwable -> L9
        L22:
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L15:
            if (this.mLoggedWriteFinish.get() == true) goto L17;
            logServiceEvent(9);     // Catch: Throwable -> L9
            this.mLoggedWriteFinish.set(true);     // Catch: Throwable -> L9
        L17:
            Slog.i(ContentCaptureManagerService.m3219$$Nest$sfgetTAG(), "Content capture data sharing session terminated successfully for package '" + this.mDataShareRequest.getPackageName() + "'");     // Catch: Throwable -> L9
            goto L19
        L7:
            if (sourceOut.getFileDescriptor().valid() == true) goto L11;
            finishedSuccessfully = true;
        L9:
            th = move-exception;
            throw th;
        }

        private Pair<ParcelFileDescriptor, ParcelFileDescriptor> createPipe() {
            ParcelFileDescriptor[] fileDescriptors = ParcelFileDescriptor.createPipe();     // Catch: IOException -> L17
            if (fileDescriptors.length == 2) goto L9;
            Slog.e(ContentCaptureManagerService.m3219$$Nest$sfgetTAG(), "Failed to create a content capture data-sharing pipe, unexpected number of file descriptors");
            return null;
        L9:
            if (fileDescriptors[0].getFileDescriptor().valid() == true) goto L11;
        L15:
            Slog.e(ContentCaptureManagerService.m3219$$Nest$sfgetTAG(), "Failed to create a content capture data-sharing pipe, didn't receive a pair of valid file descriptors.");
            return null;
        L11:
            if (fileDescriptors[1].getFileDescriptor().valid() == false) goto L15;
            return Pair.create(fileDescriptors[0], fileDescriptors[1]);
        L17:
            e = move-exception;
            Slog.e(ContentCaptureManagerService.m3219$$Nest$sfgetTAG(), "Failed to create a content capture data-sharing pipe", e);
            return null;
        }

        private void bestEffortCloseFileDescriptor(ParcelFileDescriptor fd) {
            fd.close();     // Catch: IOException -> L4
            return;
        L4:
            e = move-exception;
            Slog.e(ContentCaptureManagerService.m3219$$Nest$sfgetTAG(), "Failed to close a file descriptor", e);
        }

        private void bestEffortCloseFileDescriptors(ParcelFileDescriptor... fds) {
            int r0 = fds.length;
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L5;
            ParcelFileDescriptor fd = fds[r1];
            bestEffortCloseFileDescriptor(fd);
            r1 = r1 + 1;
            goto L3
        }

        private static void sendErrorSignal(IDataShareWriteAdapter clientAdapter, IDataShareReadAdapter serviceAdapter, int errorCode) {
            clientAdapter.error(errorCode);     // Catch: RemoteException -> L4
        L11:
            serviceAdapter.error(errorCode);     // Catch: RemoteException -> L8
            return;
        L8:
            e = move-exception;
            Slog.e(ContentCaptureManagerService.m3219$$Nest$sfgetTAG(), "Failed to call error() the service operation", e);
            return;
        L4:
            e = move-exception;
            Slog.e(ContentCaptureManagerService.m3219$$Nest$sfgetTAG(), "Failed to call error() the client operation", e);
            goto L11
        }

        private void logServiceEvent(int eventType) {
            int userId = UserHandle.getCallingUserId();
            String serviceName = ContentCaptureManagerService.access$3100(this.mParentService).getServiceName(userId);
            ContentCaptureMetricsLogger.writeServiceEvent(eventType, serviceName);
        }
    }

    final class GlobalContentCaptureOptions extends GlobalWhitelistState {
        private final SparseArray<String> mServicePackages;
        private final SparseBooleanArray mTemporaryServices;
        final /* synthetic */ ContentCaptureManagerService this$0;

        /* JADX INFO: renamed from: -$$Nest$msetServiceInfo, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m3222$$Nest$msetServiceInfo(GlobalContentCaptureOptions r0, int r1, String r2, boolean r3) {
            r0.setServiceInfo(r1, r2, r3);
        }

        GlobalContentCaptureOptions(ContentCaptureManagerService this$0) {
            this.this$0 = this$0;
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
            Slog.w(ContentCaptureManagerService.m3219$$Nest$sfgetTAG(), "setServiceInfo(): invalid name: " + serviceName);     // Catch: Throwable -> L6
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

        public ContentCaptureOptions getOptions(int userId, String packageName) {
            boolean isContentProtectionReceiverEnabled = isContentProtectionReceiverEnabled(userId, packageName);
            Object r6 = ((GlobalWhitelistState) this).mGlobalWhitelistStateLock;
            monitor-enter(r6);
            boolean isContentCaptureReceiverEnabled = isContentCaptureReceiverEnabled(userId, packageName);     // Catch: Throwable -> L14
            if (isContentCaptureReceiverEnabled == true) goto L20;
            ArraySet<ComponentName> whitelistedComponents = getWhitelistedComponents(userId, packageName);     // Catch: Throwable -> L14
            if (isContentProtectionReceiverEnabled == true) goto L19;
            if (whitelistedComponents != null) goto L19;
            if (packageName.equals(this.mServicePackages.get(userId)) == false) goto L19;
            if (this.this$0.verbose == false) goto L16;
            Slog.v(ContentCaptureManagerService.m3219$$Nest$sfgetTAG(), "getOptionsForPackage() lite for " + packageName);     // Catch: Throwable -> L14
        L16:
            ContentCaptureOptions r0 = new ContentCaptureOptions(this.this$0.mDevCfgLoggingLevel);     // Catch: Throwable -> L14
            monitor-exit(r6);     // Catch: Throwable -> L14
            return r0;
        L19:
            ArraySet<ComponentName> whitelistedComponents2 = whitelistedComponents;
        L61:
            monitor-exit(r6);     // Catch: Throwable -> L55
            if (Build.IS_USER == true) goto L25;
        L30:
            if (isContentCaptureReceiverEnabled == true) goto L37;
            if (isContentProtectionReceiverEnabled == true) goto L37;
            if (whitelistedComponents2 != null) goto L37;
            if (this.this$0.verbose == false) goto L36;
            Slog.v(ContentCaptureManagerService.m3219$$Nest$sfgetTAG(), "getOptionsForPackage(" + packageName + "): not whitelisted");
        L36:
            return null;
        L37:
            Object r21 = ContentCaptureManagerService.access$2600(this.this$0);
            monitor-enter(r21);
            int r12 = this.this$0.mDevCfgLoggingLevel;     // Catch: Throwable -> L49
            int r13 = this.this$0.mDevCfgMaxBufferSize;     // Catch: Throwable -> L49
            int r14 = this.this$0.mDevCfgIdleFlushingFrequencyMs;     // Catch: Throwable -> L49
            int r15 = this.this$0.mDevCfgTextChangeFlushingFrequencyMs;     // Catch: Throwable -> L49
            int r1 = this.this$0.mDevCfgLogHistorySize;     // Catch: Throwable -> L49
            boolean r4 = this.this$0.mDevCfgDisableFlushForViewTreeAppearing;     // Catch: Throwable -> L49
            if (isContentCaptureReceiverEnabled == true) goto L45;
            if (whitelistedComponents2 != null) goto L45;
            boolean r7 = false;
        L46:
            ContentCaptureOptions options = new ContentCaptureOptions(r12, r13, r14, r15, r1, r4, r7, new ContentCaptureOptions.ContentProtectionOptions(isContentProtectionReceiverEnabled, this.this$0.mDevCfgContentProtectionBufferSize, this.this$0.mDevCfgContentProtectionRequiredGroups, this.this$0.mDevCfgContentProtectionOptionalGroups, this.this$0.mDevCfgContentProtectionOptionalGroupsThreshold), whitelistedComponents2);     // Catch: Throwable -> L49
            if (this.this$0.verbose == false) goto L51;
            Slog.v(ContentCaptureManagerService.m3219$$Nest$sfgetTAG(), "getOptionsForPackage(" + packageName + "): " + options);     // Catch: Throwable -> L49
        L51:
            monitor-exit(r21);     // Catch: Throwable -> L49
            return options;
        L45:
            r7 = true;
        L49:
            th = move-exception;
            throw th;
        L25:
            if (ContentCaptureManagerService.access$2500(this.this$0).isTemporary(userId) == false) goto L30;
            if (packageName.equals(this.mServicePackages.get(userId)) == true) goto L30;
            Slog.w(ContentCaptureManagerService.m3219$$Nest$sfgetTAG(), "Ignoring package " + packageName + " while using temporary service " + this.mServicePackages.get(userId));
            return null;
        L55:
            th = th;
        L57:
            monitor-exit(r6);     // Catch: Throwable -> L14
            throw th;
        L20:
            whitelistedComponents2 = null;
        L14:
            th = th;
            goto L57
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

        public boolean isWhitelisted(int userId, String packageName) {
            if (isContentCaptureReceiverEnabled(userId, packageName) == false) goto L5;
        L8:
            return true;
        L5:
            if (isContentProtectionReceiverEnabled(userId, packageName) == true) goto L8;
            return false;
        }

        public boolean isWhitelisted(int userId, ComponentName componentName) {
            if (super.isWhitelisted(userId, componentName) == false) goto L5;
        L8:
            return true;
        L5:
            if (isContentProtectionReceiverEnabled(userId, componentName.getPackageName()) == true) goto L8;
            return false;
        }

        private boolean isContentCaptureReceiverEnabled(int userId, String packageName) {
            return super.isWhitelisted(userId, packageName);
        }

        private boolean isContentProtectionReceiverEnabled(int userId, String packageName) {
            Object r0 = ContentCaptureManagerService.access$2700(this.this$0);
            monitor-enter(r0);
        L8:
            th = move-exception;
            throw th;
        L5:
            if (ContentCaptureManagerService.m3215$$Nest$misContentProtectionEnabledLocked(this.this$0) == true) goto L10;
            monitor-exit(r0);     // Catch: Throwable -> L8
            return false;
        L10:
            ContentProtectionConsentManager consentManager = ContentCaptureManagerService.m3207$$Nest$fgetmContentProtectionConsentManager(this.this$0);     // Catch: Throwable -> L8
            ContentProtectionAllowlistManager allowlistManager = ContentCaptureManagerService.m3206$$Nest$fgetmContentProtectionAllowlistManager(this.this$0);     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            if (consentManager.isConsentGranted(userId) == true) goto L15;
            return false;
        L15:
            if (allowlistManager.isAllowed(packageName) == false) goto L23;
            return true;
        L23:
            return false;
        }
    }

    private final class LocalService extends ContentCaptureManagerInternal {
        final /* synthetic */ ContentCaptureManagerService this$0;

        /* synthetic */ LocalService(ContentCaptureManagerService r1, ContentCaptureManagerServiceIA r2) {
            this(r1);
        }

        private LocalService(ContentCaptureManagerService r1) {
            this.this$0 = r1;
        }

        @Override // com.android.server.contentcapture.ContentCaptureManagerInternal
        public boolean isContentCaptureServiceForUser(int uid, int userId) {
            Object r0 = ContentCaptureManagerService.access$1700(this.this$0);
            monitor-enter(r0);
            ContentCapturePerUserService service = (ContentCapturePerUserService) ContentCaptureManagerService.access$1800(this.this$0, userId);     // Catch: Throwable -> L9
            if (service == null) goto L12;
            boolean r2 = service.isContentCaptureServiceForUserLocked(uid);     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return r2;
        L12:
            monitor-exit(r0);     // Catch: Throwable -> L9
            return false;
        L9:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.contentcapture.ContentCaptureManagerInternal
        public boolean sendActivityStartAssistData(int userId, IBinder activityToken, Intent intentData) {
            Object r0 = ContentCaptureManagerService.access$1900(this.this$0);
            monitor-enter(r0);
        L8:
            th = move-exception;
            throw th;
        L5:
            if (ContentCaptureManagerService.m3204$$Nest$fgetactivityStartAssistDataEnabled(this.this$0) == true) goto L10;
            monitor-exit(r0);     // Catch: Throwable -> L8
            return false;
        L10:
            Intent intent = new Intent(intentData);     // Catch: Throwable -> L8
            intent.setFlags(intent.getFlags() & (-67));     // Catch: Throwable -> L8
            Bundle assistContentExtras = new Bundle();     // Catch: Throwable -> L8
            assistContentExtras.putBoolean("activity_start_assist_content", true);     // Catch: Throwable -> L8
            AssistContent assistContent = new AssistContent(assistContentExtras);     // Catch: Throwable -> L8
            assistContent.setDefaultIntent(intent);     // Catch: Throwable -> L8
            Bundle activityAssistData = new Bundle();     // Catch: Throwable -> L8
            activityAssistData.putParcelable(ActivityTaskManagerInternal.ASSIST_KEY_CONTENT, assistContent);     // Catch: Throwable -> L8
            ContentCapturePerUserService service = (ContentCapturePerUserService) ContentCaptureManagerService.access$2000(this.this$0, userId);     // Catch: Throwable -> L8
            if (service == null) goto L16;
            boolean r2 = service.sendActivityAssistDataLocked(activityToken, activityAssistData);     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            return r2;
        L16:
            monitor-exit(r0);     // Catch: Throwable -> L8
            return false;
        }

        @Override // com.android.server.contentcapture.ContentCaptureManagerInternal
        public boolean sendActivityAssistData(int userId, IBinder activityToken, Bundle data) {
            Object r0 = ContentCaptureManagerService.access$2100(this.this$0);
            monitor-enter(r0);
            ContentCapturePerUserService service = (ContentCapturePerUserService) ContentCaptureManagerService.access$2200(this.this$0, userId);     // Catch: Throwable -> L9
            if (service == null) goto L12;
            boolean r2 = service.sendActivityAssistDataLocked(activityToken, data);     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return r2;
        L12:
            monitor-exit(r0);     // Catch: Throwable -> L9
            return false;
        L9:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.contentcapture.ContentCaptureManagerInternal
        public ContentCaptureOptions getOptionsForPackage(int userId, String packageName) {
            return this.this$0.mGlobalContentCaptureOptions.getOptions(userId, packageName);
        }

        @Override // com.android.server.contentcapture.ContentCaptureManagerInternal
        public void notifyActivityEvent(int userId, ComponentName activityComponent, int eventType, ActivityId activityId) {
            Object r0 = ContentCaptureManagerService.access$2300(this.this$0);
            monitor-enter(r0);
            ContentCapturePerUserService service = (ContentCapturePerUserService) ContentCaptureManagerService.access$2400(this.this$0, userId);     // Catch: Throwable -> L7
            if (service == null) goto L9;
            service.onActivityEventLocked(activityId, activityComponent, eventType);     // Catch: Throwable -> L7
        L9:
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }
    }

    public static /* synthetic */ List $r8$lambda$64vO7SjbMFAC1o2JWK6_TrAf9MU(ContentCaptureManagerService r0, String r1) {
        return r0.parseContentProtectionGroupConfigValues(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$DUcqVvNSkDxh98oyE27pL-C7ZwM, reason: not valid java name */
    public static /* synthetic */ void m3201$r8$lambda$DUcqVvNSkDxh98oyE27pLC7ZwM(String r0, ContentCaptureOptions r1, IContentCaptureOptionsCallback r2, Object r3) {
        lambda$updateOptions$3(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$N-o61MHO5SRJYm6nAONoea1TnNY, reason: not valid java name */
    public static /* synthetic */ boolean m3202$r8$lambda$No61MHO5SRJYm6nAONoea1TnNY(String r0) {
        return lambda$parseContentProtectionGroupConfigValues$5(r0);
    }

    public static /* synthetic */ boolean $r8$lambda$gBmB5yhH0937OWzkjUTYcTnVEHc(List r0) {
        return lambda$parseContentProtectionGroupsConfig$4(r0);
    }

    public static /* synthetic */ void $r8$lambda$r9orUFbJiiEfcNWnEHkrV1ycFD4(ContentCapturePerUserService r0) {
        lambda$destroySessions$1(r0);
    }

    public static /* synthetic */ void $r8$lambda$rv9iiMrq0VpYg3zSxy5dLgDWLoE(ArrayList r0, ContentCapturePerUserService r1) {
        lambda$listSessions$2(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$ug3PluyhK-JKu-VvACrdq4IzHDY, reason: not valid java name */
    public static /* synthetic */ void m3203$r8$lambda$ug3PluyhKJKuVvACrdq4IzHDY(ContentCaptureManagerService r0, DeviceConfig.Properties r1) {
        r0.lambda$new$0(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetactivityStartAssistDataEnabled, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m3204$$Nest$fgetactivityStartAssistDataEnabled(ContentCaptureManagerService r0) {
        return r0.activityStartAssistDataEnabled;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCallbacks, reason: not valid java name */
    static /* bridge */ /* synthetic */ RemoteCallbackList m3205$$Nest$fgetmCallbacks(ContentCaptureManagerService r0) {
        return r0.mCallbacks;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContentProtectionAllowlistManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ ContentProtectionAllowlistManager m3206$$Nest$fgetmContentProtectionAllowlistManager(ContentCaptureManagerService r0) {
        return r0.mContentProtectionAllowlistManager;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContentProtectionConsentManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ ContentProtectionConsentManager m3207$$Nest$fgetmContentProtectionConsentManager(ContentCaptureManagerService r0) {
        return r0.mContentProtectionConsentManager;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDataShareExecutor, reason: not valid java name */
    static /* bridge */ /* synthetic */ Executor m3208$$Nest$fgetmDataShareExecutor(ContentCaptureManagerService r0) {
        return r0.mDataShareExecutor;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDisabledByDeviceConfig, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m3209$$Nest$fgetmDisabledByDeviceConfig(ContentCaptureManagerService r0) {
        return r0.mDisabledByDeviceConfig;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ Handler m3210$$Nest$fgetmHandler(ContentCaptureManagerService r0) {
        return r0.mHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPackagesWithShareRequests, reason: not valid java name */
    static /* bridge */ /* synthetic */ Set m3211$$Nest$fgetmPackagesWithShareRequests(ContentCaptureManagerService r0) {
        return r0.mPackagesWithShareRequests;
    }

    /* JADX INFO: renamed from: -$$Nest$massertCalledByServiceLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3212$$Nest$massertCalledByServiceLocked(ContentCaptureManagerService r0, String r1) {
        r0.assertCalledByServiceLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetAmInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ ActivityManagerInternal m3213$$Nest$mgetAmInternal(ContentCaptureManagerService r0) {
        return r0.getAmInternal();
    }

    /* JADX INFO: renamed from: -$$Nest$misCalledByServiceLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m3214$$Nest$misCalledByServiceLocked(ContentCaptureManagerService r0, String r1) {
        return r0.isCalledByServiceLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$misContentProtectionEnabledLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m3215$$Nest$misContentProtectionEnabledLocked(ContentCaptureManagerService r0) {
        return r0.isContentProtectionEnabledLocked();
    }

    /* JADX INFO: renamed from: -$$Nest$misDefaultServiceLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m3216$$Nest$misDefaultServiceLocked(ContentCaptureManagerService r0, int r1) {
        return r0.isDefaultServiceLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$misDisabledBySettingsLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m3217$$Nest$misDisabledBySettingsLocked(ContentCaptureManagerService r0, int r1) {
        return r0.isDisabledBySettingsLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mthrowsSecurityException, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m3218$$Nest$mthrowsSecurityException(ContentCaptureManagerService r0, IResultReceiver r1, Runnable r2) {
        return r0.throwsSecurityException(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetTAG, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m3219$$Nest$sfgetTAG() {
        return TAG;
    }

    static /* synthetic */ Object access$000(ContentCaptureManagerService x0) {
        return x0.mLock;
    }

    static /* synthetic */ AbstractPerUserSystemService access$100(ContentCaptureManagerService x0, int x1) {
        return x0.getServiceForUserLocked(x1);
    }

    static /* synthetic */ ServiceNameResolver access$1000(ContentCaptureManagerService x0) {
        return x0.mServiceNameResolver;
    }

    static /* synthetic */ Object access$1100(ContentCaptureManagerService x0) {
        return x0.mLock;
    }

    static /* synthetic */ Object access$1200(ContentCaptureManagerService x0) {
        return x0.mLock;
    }

    static /* synthetic */ AbstractPerUserSystemService access$1300(ContentCaptureManagerService x0, int x1) {
        return x0.getServiceForUserLocked(x1);
    }

    static /* synthetic */ Object access$1400(ContentCaptureManagerService x0) {
        return x0.mLock;
    }

    static /* synthetic */ AbstractPerUserSystemService access$1500(ContentCaptureManagerService x0, int x1) {
        return x0.getServiceForUserLocked(x1);
    }

    static /* synthetic */ Object access$1600(ContentCaptureManagerService x0) {
        return x0.mLock;
    }

    static /* synthetic */ Object access$1700(ContentCaptureManagerService x0) {
        return x0.mLock;
    }

    static /* synthetic */ AbstractPerUserSystemService access$1800(ContentCaptureManagerService x0, int x1) {
        return x0.peekServiceForUserLocked(x1);
    }

    static /* synthetic */ Object access$1900(ContentCaptureManagerService x0) {
        return x0.mLock;
    }

    static /* synthetic */ Object access$200(ContentCaptureManagerService x0) {
        return x0.mLock;
    }

    static /* synthetic */ AbstractPerUserSystemService access$2000(ContentCaptureManagerService x0, int x1) {
        return x0.peekServiceForUserLocked(x1);
    }

    static /* synthetic */ Object access$2100(ContentCaptureManagerService x0) {
        return x0.mLock;
    }

    static /* synthetic */ AbstractPerUserSystemService access$2200(ContentCaptureManagerService x0, int x1) {
        return x0.peekServiceForUserLocked(x1);
    }

    static /* synthetic */ Object access$2300(ContentCaptureManagerService x0) {
        return x0.mLock;
    }

    static /* synthetic */ AbstractPerUserSystemService access$2400(ContentCaptureManagerService x0, int x1) {
        return x0.peekServiceForUserLocked(x1);
    }

    static /* synthetic */ ServiceNameResolver access$2500(ContentCaptureManagerService x0) {
        return x0.mServiceNameResolver;
    }

    static /* synthetic */ Object access$2600(ContentCaptureManagerService x0) {
        return x0.mLock;
    }

    static /* synthetic */ Object access$2700(ContentCaptureManagerService x0) {
        return x0.mLock;
    }

    static /* synthetic */ Object access$2800(ContentCaptureManagerService x0) {
        return x0.mLock;
    }

    static /* synthetic */ Object access$2900(ContentCaptureManagerService x0) {
        return x0.mLock;
    }

    static /* synthetic */ AbstractPerUserSystemService access$300(ContentCaptureManagerService x0, int x1) {
        return x0.getServiceForUserLocked(x1);
    }

    static /* synthetic */ Object access$3000(ContentCaptureManagerService x0) {
        return x0.mLock;
    }

    static /* synthetic */ ServiceNameResolver access$3100(ContentCaptureManagerService x0) {
        return x0.mServiceNameResolver;
    }

    static /* synthetic */ Object access$3200(ContentCaptureManagerService x0) {
        return x0.mLock;
    }

    static /* synthetic */ Object access$400(ContentCaptureManagerService x0) {
        return x0.mLock;
    }

    static /* synthetic */ AbstractPerUserSystemService access$500(ContentCaptureManagerService x0, int x1) {
        return x0.getServiceForUserLocked(x1);
    }

    static /* synthetic */ Object access$600(ContentCaptureManagerService x0) {
        return x0.mLock;
    }

    static /* synthetic */ AbstractPerUserSystemService access$700(ContentCaptureManagerService x0, int x1) {
        return x0.getServiceForUserLocked(x1);
    }

    static /* synthetic */ Object access$800(ContentCaptureManagerService x0) {
        return x0.mLock;
    }

    static /* synthetic */ AbstractPerUserSystemService access$900(ContentCaptureManagerService x0, int x1) {
        return x0.getServiceForUserLocked(x1);
    }

    @Override // com.android.server.infra.AbstractMasterSystemService
    protected /* bridge */ /* synthetic */ AbstractPerUserSystemService newServiceLocked(int r1, boolean r2) {
        return newServiceLocked(r1, r2);
    }

    @Override // com.android.server.infra.AbstractMasterSystemService
    protected /* bridge */ /* synthetic */ void onServiceRemoved(AbstractPerUserSystemService r1, int r2) {
        onServiceRemoved((ContentCapturePerUserService) r1, r2);
    }

    static {
        TAG = ContentCaptureManagerService.class.getSimpleName();
    }

    public ContentCaptureManagerService(Context context) {
        super(context, new FrameworkResourcesServiceNameResolver(context, R.string.config_displayLightSensorType), "no_content_capture", 1);
        this.mLocalService = new LocalService(this, null);
        this.mContentCaptureManagerServiceStub = new ContentCaptureManagerServiceStub(this);
        this.mDataShareExecutor = Executors.newCachedThreadPool();
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mPackagesWithShareRequests = new HashSet();
        this.mCallbacks = new RemoteCallbackList();
        this.mGlobalContentCaptureOptions = new GlobalContentCaptureOptions(this);
        this.mDevCfgContentProtectionRequiredGroups = ContentCaptureManager.DEFAULT_CONTENT_PROTECTION_REQUIRED_GROUPS;
        this.mDevCfgContentProtectionOptionalGroups = ContentCaptureManager.DEFAULT_CONTENT_PROTECTION_OPTIONAL_GROUPS;
        DeviceConfig.addOnPropertiesChangedListener("content_capture", ActivityThread.currentApplication().getMainExecutor(), new ContentCaptureManagerService$$ExternalSyntheticLambda1(this));
        setDeviceConfigProperties();
        if (this.mDevCfgLogHistorySize <= 0) goto L9;
        if (this.debug == false) goto L7;
        Slog.d(TAG, "log history size: " + this.mDevCfgLogHistorySize);
    L7:
        this.mRequestsHistory = new LocalLog(this.mDevCfgLogHistorySize);
    L12:
        List<UserInfo> users = getSupportedUsers();
        int i = 0;
    L14:
        if (i >= users.size()) goto L23;
        int userId = users.get(i).id;
        boolean disabled = !isEnabledBySettings(userId);
        if (disabled == false) goto L21;
        Slog.i(TAG, "user " + userId + " disabled by settings");
        if (this.mDisabledBySettings != null) goto L20;
        this.mDisabledBySettings = new SparseBooleanArray(1);
    L20:
        this.mDisabledBySettings.put(userId, true);
    L21:
        GlobalContentCaptureOptions.m3222$$Nest$msetServiceInfo(this.mGlobalContentCaptureOptions, userId, this.mServiceNameResolver.getServiceName(userId), this.mServiceNameResolver.isTemporary(userId));
        i = i + 1;
        goto L14
    L23:
        return;
    L9:
        if (this.debug == false) goto L11;
        Slog.d(TAG, "disabled log history because size is " + this.mDevCfgLogHistorySize);
    L11:
        this.mRequestsHistory = null;
        goto L12
    }

    private /* synthetic */ void lambda$new$0(DeviceConfig.Properties properties) {
        onDeviceConfigChange(properties);
    }

    @Override // com.android.server.infra.AbstractMasterSystemService
    protected ContentCapturePerUserService newServiceLocked(int resolvedUserId, boolean disabled) {
        return new ContentCapturePerUserService(this, this.mLock, disabled, resolvedUserId);
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
    public void onStart() {
        publishBinderService("content_capture", this.mContentCaptureManagerServiceStub);
        publishLocalService(ContentCaptureManagerInternal.class, this.mLocalService);
    }

    protected void onServiceRemoved(ContentCapturePerUserService service, int userId) {
        service.destroyLocked();
    }

    @Override // com.android.server.infra.AbstractMasterSystemService
    protected void onServicePackageUpdatingLocked(int userId) {
        ContentCapturePerUserService service = getServiceForUserLocked(userId);
        if (service == null) goto L6;
        service.onPackageUpdatingLocked();
        return;
    }

    @Override // com.android.server.infra.AbstractMasterSystemService
    protected void onServicePackageUpdatedLocked(int userId) {
        ContentCapturePerUserService service = getServiceForUserLocked(userId);
        if (service == null) goto L6;
        service.onPackageUpdatedLocked();
        return;
    }

    @Override // com.android.server.infra.AbstractMasterSystemService
    protected void onServiceNameChanged(int userId, String serviceName, boolean isTemporary) {
        GlobalContentCaptureOptions.m3222$$Nest$msetServiceInfo(this.mGlobalContentCaptureOptions, userId, serviceName, isTemporary);
        super.onServiceNameChanged(userId, serviceName, isTemporary);
    }

    @Override // com.android.server.infra.AbstractMasterSystemService
    protected void enforceCallingPermissionForManagement() {
        getContext().enforceCallingPermission("android.permission.MANAGE_CONTENT_CAPTURE", TAG);
    }

    @Override // com.android.server.infra.AbstractMasterSystemService
    protected int getMaximumTemporaryServiceDurationMs() {
        return MAX_TEMP_SERVICE_DURATION_MS;
    }

    @Override // com.android.server.infra.AbstractMasterSystemService
    protected void registerForExtraSettingsChanges(ContentResolver resolver, ContentObserver observer) {
        resolver.registerContentObserver(Settings.Secure.getUriFor("content_capture_enabled"), false, observer, -1);
    }

    @Override // com.android.server.infra.AbstractMasterSystemService
    protected void onSettingsChanged(int userId, String property) {
        switch(property.hashCode()) {
            case -322385022: goto L6;
            default: goto L8;
        };
    L8:
        byte r0 = -1;
    L9:
        switch(r0) {
            case 0: goto L12;
            default: goto L10;
        };
    L10:
        Slog.w(TAG, "Unexpected property (" + property + "); updating cache instead");
        return;
    L12:
        setContentCaptureFeatureEnabledBySettingsForUser(userId, isEnabledBySettings(userId));
        return;
    L6:
        if (property.equals("content_capture_enabled") == false) goto L8;
        r0 = 0;
        goto L9
    }

    @Override // com.android.server.infra.AbstractMasterSystemService
    protected boolean isDisabledLocked(int userId) {
        if (this.mDisabledByDeviceConfig == false) goto L5;
    L10:
        return true;
    L5:
        if (isDisabledBySettingsLocked(userId) == true) goto L10;
        if (super.isDisabledLocked(userId) == true) goto L10;
        return false;
    }

    @Override // com.android.server.infra.AbstractMasterSystemService
    protected void assertCalledByPackageOwner(String packageName) {
        super.assertCalledByPackageOwner(packageName);     // Catch: SecurityException -> L4
        return;
    L4:
        e = move-exception;
        int callingUid = Binder.getCallingUid();
        VoiceInteractionManagerInternal.HotwordDetectionServiceIdentity hotwordDetectionServiceIdentity = ((VoiceInteractionManagerInternal) LocalServices.getService(VoiceInteractionManagerInternal.class)).getHotwordDetectionServiceIdentity();
        if (callingUid == hotwordDetectionServiceIdentity.getIsolatedUid()) goto L9;
        super.assertCalledByPackageOwner(packageName);
        return;
    L9:
        String[] packages = getContext().getPackageManager().getPackagesForUid(hotwordDetectionServiceIdentity.getOwnerUid());
        if (packages == null) goto L18;
        int r4 = packages.length;
        int r5 = 0;
    L13:
        if (r5 >= r4) goto L18;
        String candidate = packages[r5];
        if (packageName.equals(candidate) == true) goto L16;
        r5 = r5 + 1;
        goto L13
    L16:
        return;
    L18:
        throw e;
    }

    private boolean isDisabledBySettingsLocked(int userId) {
        if (this.mDisabledBySettings != null) goto L5;
    L7:
        return false;
    L5:
        if (this.mDisabledBySettings.get(userId) == false) goto L7;
        return true;
    }

    private boolean isEnabledBySettings(int userId) {
        if (Settings.Secure.getIntForUser(getContext().getContentResolver(), "content_capture_enabled", 1, userId) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    private void onDeviceConfigChange(DeviceConfig.Properties properties) {
        Iterator r0 = properties.getKeyset().iterator();
    L4:
        if (r0.hasNext() == false) goto L70;
        String key = (String) r0.next();
        switch(key.hashCode()) {
            case -2119665698: goto L57;
            case -2017771757: goto L54;
            case -1970239836: goto L51;
            case -1455054002: goto L48;
            case -1293819494: goto L45;
            case -801940800: goto L42;
            case -302650995: goto L39;
            case -148969820: goto L36;
            case -33314483: goto L33;
            case 227845607: goto L30;
            case 745178004: goto L27;
            case 850213087: goto L24;
            case 1119140421: goto L21;
            case 1127959292: goto L18;
            case 1559908375: goto L15;
            case 1568835651: goto L12;
            case 2068460406: goto L9;
            default: goto L59;
        };
    L59:
        byte r2 = -1;
    L60:
        switch(r2) {
            case 0: goto L68;
            case 1: goto L66;
            case 2: goto L64;
            case 3: goto L64;
            case 4: goto L64;
            case 5: goto L64;
            case 6: goto L64;
            case 7: goto L64;
            case 8: goto L64;
            case 9: goto L64;
            case 10: goto L64;
            case 11: goto L64;
            case 12: goto L64;
            case 13: goto L64;
            case 14: goto L64;
            case 15: goto L64;
            case 16: goto L62;
            default: goto L63;
        };
    L62:
        setActivityStartAssistDataEnabled();
        goto L63
    L64:
        setFineTuneParamsFromDeviceConfig();
        return;
    L66:
        setLoggingLevelFromDeviceConfig();
        return;
    L68:
        setDisabledByDeviceConfig(properties.getString(key, null));
        return;
    L63:
        Slog.i(TAG, "Ignoring change on " + key);
        goto L4
    L9:
        if (key.equals("idle_flush_frequency") == false) goto L59;
        r2 = 3;
        goto L60
    L12:
        if (key.equals("idle_unbind_timeout") == false) goto L59;
        r2 = 6;
        goto L60
    L15:
        if (key.equals("content_protection_auto_disconnect_timeout_ms") == false) goto L59;
        r2 = 15;
        goto L60
    L18:
        if (key.equals("content_protection_allowlist_timeout_ms") == false) goto L59;
        r2 = 14;
        goto L60
    L21:
        if (key.equals("max_buffer_size") == false) goto L59;
        r2 = 2;
        goto L60
    L24:
        if (key.equals("content_protection_optional_groups_threshold") == false) goto L59;
        r2 = 12;
        goto L60
    L27:
        if (key.equals("enable_activity_start_assist_content") == false) goto L59;
        r2 = 16;
        goto L60
    L30:
        if (key.equals("log_history_size") == false) goto L59;
        r2 = 4;
        goto L60
    L33:
        if (key.equals("content_protection_required_groups_config") == false) goto L59;
        r2 = 10;
        goto L60
    L36:
        if (key.equals("text_change_flush_frequency") == false) goto L59;
        r2 = 5;
        goto L60
    L39:
        if (key.equals("service_explicitly_enabled") == false) goto L59;
        r2 = 0;
        goto L60
    L42:
        if (key.equals("content_protection_buffer_size") == false) goto L59;
        r2 = 9;
        goto L60
    L45:
        if (key.equals("content_protection_allowlist_delay_ms") == false) goto L59;
        r2 = 13;
        goto L60
    L48:
        if (key.equals("content_protection_optional_groups_config") == false) goto L59;
        r2 = 11;
        goto L60
    L51:
        if (key.equals("logging_level") == false) goto L59;
        r2 = 1;
        goto L60
    L54:
        if (key.equals("enable_content_protection_receiver") == false) goto L59;
        r2 = 8;
        goto L60
    L57:
        if (key.equals("disable_flush_for_view_tree_appearing") == false) goto L59;
        r2 = 7;
        goto L60
    }

    protected void setFineTuneParamsFromDeviceConfig() {
        Object r2 = this.mLock;
        monitor-enter(r2);
        this.mDevCfgMaxBufferSize = DeviceConfig.getInt("content_capture", "max_buffer_size", 500);     // Catch: Throwable -> L7
        this.mDevCfgIdleFlushingFrequencyMs = DeviceConfig.getInt("content_capture", "idle_flush_frequency", 5000);     // Catch: Throwable -> L7
        this.mDevCfgTextChangeFlushingFrequencyMs = DeviceConfig.getInt("content_capture", "text_change_flush_frequency", 1000);     // Catch: Throwable -> L7
        this.mDevCfgLogHistorySize = DeviceConfig.getInt("content_capture", "log_history_size", 20);     // Catch: Throwable -> L7
        this.mDevCfgIdleUnbindTimeoutMs = DeviceConfig.getInt("content_capture", "idle_unbind_timeout", 0);     // Catch: Throwable -> L7
        this.mDevCfgDisableFlushForViewTreeAppearing = DeviceConfig.getBoolean("content_capture", "disable_flush_for_view_tree_appearing", false);     // Catch: Throwable -> L7
        boolean enableContentProtectionReceiverOld = this.mDevCfgEnableContentProtectionReceiver;     // Catch: Throwable -> L7
        boolean enableContentProtectionReceiverNew = getDeviceConfigEnableContentProtectionReceiver();     // Catch: Throwable -> L7
        this.mDevCfgContentProtectionBufferSize = DeviceConfig.getInt("content_capture", "content_protection_buffer_size", 150);     // Catch: Throwable -> L7
        String contentProtectionRequiredGroupsConfig = DeviceConfig.getString("content_capture", "content_protection_required_groups_config", "");     // Catch: Throwable -> L7
        String contentProtectionOptionalGroupsConfig = DeviceConfig.getString("content_capture", "content_protection_optional_groups_config", "");     // Catch: Throwable -> L7
        int contentProtectionOptionalGroupsThreshold = DeviceConfig.getInt("content_capture", "content_protection_optional_groups_threshold", 0);     // Catch: Throwable -> L7
        long contentProtectionAllowlistDelayMs = DeviceConfig.getLong("content_capture", "content_protection_allowlist_delay_ms", 30000);     // Catch: Throwable -> L7
        long contentProtectionAllowlistTimeoutMs = DeviceConfig.getLong("content_capture", "content_protection_allowlist_timeout_ms", 250);     // Catch: Throwable -> L7
        this.mDevCfgContentProtectionAutoDisconnectTimeoutMs = DeviceConfig.getLong("content_capture", "content_protection_auto_disconnect_timeout_ms", BackupAgentTimeoutParameters.DEFAULT_QUOTA_EXCEEDED_TIMEOUT_MILLIS);     // Catch: Throwable -> L7
        ContentProtectionAllowlistManager contentProtectionAllowlistManagerOld = this.mContentProtectionAllowlistManager;     // Catch: Throwable -> L7
        if (this.verbose == false) goto L9;
        Slog.v(TAG, "setFineTuneParamsFromDeviceConfig(): bufferSize=" + this.mDevCfgMaxBufferSize + ", idleFlush=" + this.mDevCfgIdleFlushingFrequencyMs + ", textFlush=" + this.mDevCfgTextChangeFlushingFrequencyMs + ", logHistory=" + this.mDevCfgLogHistorySize + ", idleUnbindTimeoutMs=" + this.mDevCfgIdleUnbindTimeoutMs + ", disableFlushForViewTreeAppearing=" + this.mDevCfgDisableFlushForViewTreeAppearing + ", enableContentProtectionReceiver=" + enableContentProtectionReceiverNew + ", contentProtectionBufferSize=" + this.mDevCfgContentProtectionBufferSize + ", contentProtectionRequiredGroupsConfig=" + contentProtectionRequiredGroupsConfig + ", contentProtectionOptionalGroupsConfig=" + contentProtectionOptionalGroupsConfig + ", contentProtectionOptionalGroupsThreshold=" + contentProtectionOptionalGroupsThreshold + ", contentProtectionAllowlistDelayMs=" + contentProtectionAllowlistDelayMs + ", contentProtectionAllowlistTimeoutMs=" + contentProtectionAllowlistTimeoutMs + ", contentProtectionAutoDisconnectTimeoutMs=" + this.mDevCfgContentProtectionAutoDisconnectTimeoutMs);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r2);     // Catch: Throwable -> L7
        List<List<String>> contentProtectionRequiredGroups = parseContentProtectionGroupsConfig(contentProtectionRequiredGroupsConfig);
        List<List<String>> contentProtectionOptionalGroups = parseContentProtectionGroupsConfig(contentProtectionOptionalGroupsConfig);
        ContentProtectionAllowlistManager contentProtectionAllowlistManagerNew = null;
        if (contentProtectionAllowlistManagerOld == null) goto L14;
        if (enableContentProtectionReceiverNew == true) goto L14;
        contentProtectionAllowlistManagerOld.stop();
    L14:
        if (enableContentProtectionReceiverOld == true) goto L20;
        if (enableContentProtectionReceiverNew == false) goto L20;
        ComponentName contentProtectionServiceComponentNameNew = getContentProtectionServiceComponentName();
        if (contentProtectionServiceComponentNameNew == null) goto L19;
        contentProtectionAllowlistManagerNew = createContentProtectionAllowlistManager(contentProtectionAllowlistTimeoutMs);
        contentProtectionAllowlistManagerNew.start(contentProtectionAllowlistDelayMs);
        ContentProtectionConsentManager contentProtectionConsentManagerNew = createContentProtectionConsentManager();
        ContentProtectionConsentManager contentProtectionConsentManagerNew2 = contentProtectionConsentManagerNew;
        ComponentName contentProtectionServiceComponentNameNew2 = contentProtectionServiceComponentNameNew;
    L21:
        Object r6 = this.mLock;
        monitor-enter(r6);
        this.mDevCfgEnableContentProtectionReceiver = enableContentProtectionReceiverNew;     // Catch: Throwable -> L26
        this.mDevCfgContentProtectionRequiredGroups = contentProtectionRequiredGroups;     // Catch: Throwable -> L26
        this.mDevCfgContentProtectionOptionalGroups = contentProtectionOptionalGroups;     // Catch: Throwable -> L26
        this.mDevCfgContentProtectionOptionalGroupsThreshold = contentProtectionOptionalGroupsThreshold;     // Catch: Throwable -> L26
        this.mDevCfgContentProtectionAllowlistDelayMs = contentProtectionAllowlistDelayMs;     // Catch: Throwable -> L26
        if ((enableContentProtectionReceiverOld ^ enableContentProtectionReceiverNew) == false) goto L28;
        this.mContentProtectionServiceComponentName = contentProtectionServiceComponentNameNew2;     // Catch: Throwable -> L26
        this.mContentProtectionAllowlistManager = contentProtectionAllowlistManagerNew;     // Catch: Throwable -> L26
        this.mContentProtectionConsentManager = contentProtectionConsentManagerNew2;     // Catch: Throwable -> L26
    L28:
        monitor-exit(r6);     // Catch: Throwable -> L26
        return;
    L26:
        th = move-exception;
        throw th;
    L19:
        contentProtectionConsentManagerNew2 = null;
        contentProtectionServiceComponentNameNew2 = contentProtectionServiceComponentNameNew;
    L20:
        contentProtectionConsentManagerNew2 = null;
        contentProtectionServiceComponentNameNew2 = null;
    L7:
        th = move-exception;
        throw th;
    }

    private void setLoggingLevelFromDeviceConfig() {
        this.mDevCfgLoggingLevel = DeviceConfig.getInt("content_capture", "logging_level", ContentCaptureHelper.getDefaultLoggingLevel());
        ContentCaptureHelper.setLoggingLevel(this.mDevCfgLoggingLevel);
        this.verbose = ContentCaptureHelper.sVerbose;
        this.debug = ContentCaptureHelper.sDebug;
        if (this.verbose == false) goto L6;
        Slog.v(TAG, "setLoggingLevelFromDeviceConfig(): level=" + this.mDevCfgLoggingLevel + ", debug=" + this.debug + ", verbose=" + this.verbose);
        return;
    }

    private void setDeviceConfigProperties() {
        setLoggingLevelFromDeviceConfig();
        setFineTuneParamsFromDeviceConfig();
        String enabled = DeviceConfig.getProperty("content_capture", "service_explicitly_enabled");
        setDisabledByDeviceConfig(enabled);
        setActivityStartAssistDataEnabled();
    }

    private void setActivityStartAssistDataEnabled() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.activityStartAssistDataEnabled = DeviceConfig.getBoolean("content_capture", "enable_activity_start_assist_content", false);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void setDisabledByDeviceConfig(String explicitlyEnabled) {
        if (this.verbose == false) goto L5;
        Slog.v(TAG, "setDisabledByDeviceConfig(): explicitlyEnabled=" + explicitlyEnabled);
    L5:
        List<UserInfo> users = getSupportedUsers();
        if (explicitlyEnabled != null) goto L8;
    L10:
        boolean newDisabledValue = false;
    L11:
        Object r2 = this.mLock;
        monitor-enter(r2);
    L18:
        th = move-exception;
        throw th;
    L14:
        if (this.mDisabledByDeviceConfig == newDisabledValue) goto L16;
        this.mDisabledByDeviceConfig = newDisabledValue;     // Catch: Throwable -> L18
        Slog.i(TAG, "setDisabledByDeviceConfig(): set to " + this.mDisabledByDeviceConfig);     // Catch: Throwable -> L18
        int i = 0;
    L24:
        if (i >= users.size()) goto L38;
        int userId = users.get(i).id;     // Catch: Throwable -> L18
        if (this.mDisabledByDeviceConfig == true) goto L31;
        if (isDisabledBySettingsLocked(userId) == true) goto L31;
        boolean disabled = false;
    L32:
        String r6 = TAG;     // Catch: Throwable -> L18
        StringBuilder r7 = new StringBuilder();     // Catch: Throwable -> L18
        r7.append("setDisabledByDeviceConfig(): updating service for user ");     // Catch: Throwable -> L18
        r7.append(userId);     // Catch: Throwable -> L18
        r7.append(" to ");     // Catch: Throwable -> L18
        if (disabled == false) goto L35;
        String r8 = "'disabled'";
    L36:
        r7.append(r8);     // Catch: Throwable -> L18
        Slog.i(r6, r7.toString());     // Catch: Throwable -> L18
        updateCachedServiceLocked(userId, disabled);     // Catch: Throwable -> L18
        i = i + 1;     // Catch: Throwable -> L18
        goto L24
    L35:
        r8 = "'enabled'";
    L31:
        disabled = true;
        goto L32
    L38:
        monitor-exit(r2);     // Catch: Throwable -> L18
        return;
    L16:
        if (this.verbose == false) goto L20;
        Slog.v(TAG, "setDisabledByDeviceConfig(): already " + newDisabledValue);     // Catch: Throwable -> L18
    L20:
        monitor-exit(r2);     // Catch: Throwable -> L18
        return;
    L8:
        if (explicitlyEnabled.equalsIgnoreCase("false") == false) goto L10;
        newDisabledValue = true;
        goto L11
    }

    private void setContentCaptureFeatureEnabledBySettingsForUser(int userId, boolean enabled) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mDisabledBySettings != null) goto L9;
        this.mDisabledBySettings = new SparseBooleanArray();     // Catch: Throwable -> L7
    L9:
        boolean disabled = true;
        boolean alreadyEnabled = !this.mDisabledBySettings.get(userId);     // Catch: Throwable -> L7
        if ((enabled ^ alreadyEnabled) == false) goto L12;
        if (enabled == false) goto L18;
        Slog.i(TAG, "setContentCaptureFeatureEnabled(): enabling service for user " + userId);     // Catch: Throwable -> L7
        this.mDisabledBySettings.delete(userId);     // Catch: Throwable -> L7
    L19:
        if (enabled == false) goto L24;
        if (this.mDisabledByDeviceConfig == true) goto L24;
        disabled = false;
    L24:
        updateCachedServiceLocked(userId, disabled);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L18:
        Slog.i(TAG, "setContentCaptureFeatureEnabled(): disabling service for user " + userId);     // Catch: Throwable -> L7
        this.mDisabledBySettings.put(userId, true);     // Catch: Throwable -> L7
        goto L19
    L12:
        if (this.debug == false) goto L14;
        Slog.d(TAG, "setContentCaptureFeatureEnabledForUser(): already " + enabled);     // Catch: Throwable -> L7
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L7
    }

    void destroySessions(int userId, IResultReceiver receiver) {
        Slog.i(TAG, "destroySessions() for userId " + userId);
        enforceCallingPermissionForManagement();
        Object r0 = this.mLock;
        monitor-enter(r0);
        if (userId == (-1)) goto L12;
        ContentCapturePerUserService service = peekServiceForUserLocked(userId);     // Catch: Throwable -> L9
        if (service == null) goto L13;
        service.destroySessionsLocked();     // Catch: Throwable -> L9
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L9
        receiver.send(0, new Bundle());     // Catch: RemoteException -> L16
        return;
    L17:
        return;
    L12:
        visitServicesLocked(new ContentCaptureManagerService$$ExternalSyntheticLambda2());     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ void lambda$destroySessions$1(ContentCapturePerUserService s) {
        s.destroySessionsLocked();
    }

    void listSessions(int userId, IResultReceiver receiver) {
        Slog.i(TAG, "listSessions() for userId " + userId);
        enforceCallingPermissionForManagement();
        Bundle resultData = new Bundle();
        final ArrayList<String> sessions = new ArrayList();
        Object r2 = this.mLock;
        monitor-enter(r2);
        if (userId == (-1)) goto L12;
        ContentCapturePerUserService service = peekServiceForUserLocked(userId);     // Catch: Throwable -> L9
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
        visitServicesLocked(new ContentCaptureManagerService$$ExternalSyntheticLambda0(sessions));     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ void lambda$listSessions$2(ArrayList sessions, ContentCapturePerUserService s) {
        s.listSessionsLocked(sessions);
    }

    void updateOptions(final String packageName, final ContentCaptureOptions options) {
        this.mCallbacks.broadcast(new ContentCaptureManagerService$$ExternalSyntheticLambda3(packageName, options));
    }

    private static /* synthetic */ void lambda$updateOptions$3(String packageName, ContentCaptureOptions options, IContentCaptureOptionsCallback callback, Object pkg) {
        if (pkg.equals(packageName) == false) goto L11;
        callback.setContentCaptureOptions(options);     // Catch: RemoteException -> L6
        return;
    L6:
        e = move-exception;
        Slog.w(TAG, "Unable to send setContentCaptureOptions(): " + e);
        return;
    }

    private ActivityManagerInternal getAmInternal() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mAm != null) goto L9;
        this.mAm = (ActivityManagerInternal) LocalServices.getService(ActivityManagerInternal.class);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return this.mAm;
    }

    private void assertCalledByServiceLocked(String methodName) {
        if (isCalledByServiceLocked(methodName) == false) goto L6;
        return;
    L6:
        throw new SecurityException("caller is not user's ContentCapture service");
    }

    private boolean isCalledByServiceLocked(String methodName) {
        int userId = UserHandle.getCallingUserId();
        int callingUid = Binder.getCallingUid();
        String serviceName = this.mServiceNameResolver.getServiceName(userId);
        if (serviceName != null) goto L6;
        Slog.e(TAG, methodName + ": called by UID " + callingUid + ", but there's no service set for user " + userId);
        return false;
    L6:
        ComponentName serviceComponent = ComponentName.unflattenFromString(serviceName);
        if (serviceComponent != null) goto L10;
        Slog.w(TAG, methodName + ": invalid service name: " + serviceName);
        return false;
    L10:
        String servicePackageName = serviceComponent.getPackageName();
        PackageManager pm = getContext().getPackageManager();
        int serviceUid = pm.getPackageUidAsUser(servicePackageName, UserHandle.getCallingUserId());     // Catch: PackageManager.NameNotFoundException -> L17
        if (callingUid == serviceUid) goto L15;
        Slog.e(TAG, methodName + ": called by UID " + callingUid + ", but service UID is " + serviceUid);
        return false;
    L15:
        return true;
    L18:
        Slog.w(TAG, methodName + ": could not verify UID for " + serviceName);
        return false;
    }

    private boolean throwsSecurityException(IResultReceiver result, Runnable runable) {
        runable.run();     // Catch: SecurityException -> L5
        return false;
    L5:
        e = move-exception;
        result.send(-1, SyncResultReceiver.bundleFor(e.getMessage()));     // Catch: RemoteException -> L8
        return true;
    L8:
        e2 = move-exception;
        Slog.w(TAG, "Unable to send security exception (" + e + "): ", e2);
        return true;
    }

    private boolean isDefaultServiceLocked(int userId) {
        String defaultServiceName = this.mServiceNameResolver.getDefaultServiceName(userId);
        if (defaultServiceName != null) goto L6;
        return false;
    L6:
        String currentServiceName = this.mServiceNameResolver.getServiceName(userId);
        return defaultServiceName.equals(currentServiceName);
    }

    @Override // com.android.server.infra.AbstractMasterSystemService
    protected void dumpLocked(String prefix, PrintWriter pw) {
        super.dumpLocked(prefix, pw);
        String prefix2 = prefix + "  ";
        pw.print(prefix);
        pw.print("Users disabled by Settings: ");
        pw.println(this.mDisabledBySettings);
        pw.print(prefix);
        pw.println("DeviceConfig Settings: ");
        pw.print(prefix2);
        pw.print("disabled: ");
        pw.println(this.mDisabledByDeviceConfig);
        pw.print(prefix2);
        pw.print("loggingLevel: ");
        pw.println(this.mDevCfgLoggingLevel);
        pw.print(prefix2);
        pw.print("maxBufferSize: ");
        pw.println(this.mDevCfgMaxBufferSize);
        pw.print(prefix2);
        pw.print("idleFlushingFrequencyMs: ");
        pw.println(this.mDevCfgIdleFlushingFrequencyMs);
        pw.print(prefix2);
        pw.print("textChangeFlushingFrequencyMs: ");
        pw.println(this.mDevCfgTextChangeFlushingFrequencyMs);
        pw.print(prefix2);
        pw.print("logHistorySize: ");
        pw.println(this.mDevCfgLogHistorySize);
        pw.print(prefix2);
        pw.print("idleUnbindTimeoutMs: ");
        pw.println(this.mDevCfgIdleUnbindTimeoutMs);
        pw.print(prefix2);
        pw.print("disableFlushForViewTreeAppearing: ");
        pw.println(this.mDevCfgDisableFlushForViewTreeAppearing);
        pw.print(prefix2);
        pw.print("enableContentProtectionReceiver: ");
        pw.println(this.mDevCfgEnableContentProtectionReceiver);
        pw.print(prefix2);
        pw.print("contentProtectionBufferSize: ");
        pw.println(this.mDevCfgContentProtectionBufferSize);
        pw.print(prefix2);
        pw.print("contentProtectionRequiredGroupsSize: ");
        pw.println(this.mDevCfgContentProtectionRequiredGroups.size());
        pw.print(prefix2);
        pw.print("contentProtectionOptionalGroupsSize: ");
        pw.println(this.mDevCfgContentProtectionOptionalGroups.size());
        pw.print(prefix2);
        pw.print("contentProtectionOptionalGroupsThreshold: ");
        pw.println(this.mDevCfgContentProtectionOptionalGroupsThreshold);
        pw.print(prefix2);
        pw.print("contentProtectionAllowlistDelayMs: ");
        pw.println(this.mDevCfgContentProtectionAllowlistDelayMs);
        pw.print(prefix2);
        pw.print("contentProtectionAllowlistTimeoutMs: ");
        pw.println(this.mDevCfgContentProtectionAllowlistTimeoutMs);
        pw.print(prefix2);
        pw.print("contentProtectionAutoDisconnectTimeoutMs: ");
        pw.println(this.mDevCfgContentProtectionAutoDisconnectTimeoutMs);
        pw.print(prefix2);
        pw.print("activityStartAssistDataEnabled: ");
        pw.println(this.activityStartAssistDataEnabled);
        pw.print(prefix);
        pw.println("Global Options:");
        this.mGlobalContentCaptureOptions.dump(prefix2, pw);
    }

    protected boolean getDeviceConfigEnableContentProtectionReceiver() {
        return DeviceConfig.getBoolean("content_capture", "enable_content_protection_receiver", false);
    }

    protected ContentProtectionAllowlistManager createContentProtectionAllowlistManager(long timeoutMs) {
        return new ContentProtectionAllowlistManager(this, BackgroundThread.getHandler(), timeoutMs);
    }

    protected ContentProtectionConsentManager createContentProtectionConsentManager() {
        return new ContentProtectionConsentManager(BackgroundThread.getHandler(), getContext().getContentResolver(), DevicePolicyCache.getInstance());
    }

    private ComponentName getContentProtectionServiceComponentName() {
        String flatComponentName = getContentProtectionServiceFlatComponentName();
        if (flatComponentName != null) goto L7;
        return null;
    L7:
        return ComponentName.unflattenFromString(flatComponentName);
    }

    protected String getContentProtectionServiceFlatComponentName() {
        return getContext().getString(R.string.config_displayWhiteBalanceColorTemperatureSensorName);
    }

    protected ContentCaptureServiceInfo createContentProtectionServiceInfo(ComponentName componentName) throws PackageManager.NameNotFoundException {
        return new ContentCaptureServiceInfo(getContext(), componentName, false, UserHandle.getCallingUserId());
    }

    public RemoteContentProtectionService createRemoteContentProtectionService() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (this.mDevCfgEnableContentProtectionReceiver == false) goto L18;
        if (this.mContentProtectionServiceComponentName == null) goto L18;
        ComponentName componentName = this.mContentProtectionServiceComponentName;     // Catch: Throwable -> L16
        long autoDisconnectTimeoutMs = this.mDevCfgContentProtectionAutoDisconnectTimeoutMs;     // Catch: Throwable -> L16
        monitor-exit(r0);     // Catch: Throwable -> L16
        createContentProtectionServiceInfo(componentName);     // Catch: Exception -> L14
        return createRemoteContentProtectionService(componentName, autoDisconnectTimeoutMs);
    L15:
        return null;
    L18:
        monitor-exit(r0);     // Catch: Throwable -> L16
        return null;
    }

    protected RemoteContentProtectionService createRemoteContentProtectionService(ComponentName componentName, long autoDisconnectTimeoutMs) {
        return new RemoteContentProtectionService(getContext(), componentName, UserHandle.getCallingUserId(), isBindInstantServiceAllowed(), autoDisconnectTimeoutMs);
    }

    protected ContentCaptureManagerServiceStub getContentCaptureManagerServiceStub() {
        return this.mContentCaptureManagerServiceStub;
    }

    protected List<List<String>> parseContentProtectionGroupsConfig(String config) {
        if (this.verbose == false) goto L5;
        Slog.v(TAG, "parseContentProtectionGroupsConfig: " + config);
    L5:
        if (config != null) goto L9;
        return Collections.emptyList();
    L9:
        return Arrays.stream(config.split(CONTENT_PROTECTION_GROUP_CONFIG_SEPARATOR_GROUP)).map(new ContentCaptureManagerService$$ExternalSyntheticLambda4(this)).filter(new ContentCaptureManagerService$$ExternalSyntheticLambda5()).toList();
    }

    private static /* synthetic */ boolean lambda$parseContentProtectionGroupsConfig$4(List group) {
        return !group.isEmpty();
    }

    private List<String> parseContentProtectionGroupConfigValues(String group) {
        return Arrays.stream(group.split(CONTENT_PROTECTION_GROUP_CONFIG_SEPARATOR_VALUE)).filter(new ContentCaptureManagerService$$ExternalSyntheticLambda6()).toList();
    }

    private static /* synthetic */ boolean lambda$parseContentProtectionGroupConfigValues$5(String value) {
        return !value.isEmpty();
    }

    private boolean isContentProtectionEnabledLocked() {
        if (this.mDevCfgEnableContentProtectionReceiver == true) goto L5;
    L15:
        return false;
    L5:
        if (this.mContentProtectionServiceComponentName == null) goto L15;
        if (this.mContentProtectionAllowlistManager == null) goto L15;
        if (this.mContentProtectionConsentManager == null) goto L15;
        if (this.mDevCfgContentProtectionRequiredGroups.isEmpty() == true) goto L13;
    L14:
        return true;
    L13:
        if (this.mDevCfgContentProtectionOptionalGroups.isEmpty() == true) goto L15;
        goto L14
    }
}
