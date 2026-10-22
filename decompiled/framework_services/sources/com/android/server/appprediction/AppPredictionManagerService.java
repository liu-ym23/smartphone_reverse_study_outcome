package com.android.server.appprediction;

import android.R;
import android.app.ActivityManagerInternal;
import android.app.prediction.AppPredictionContext;
import android.app.prediction.AppPredictionSessionId;
import android.app.prediction.AppTargetEvent;
import android.app.prediction.IPredictionCallback;
import android.app.prediction.IPredictionManager;
import android.content.Context;
import android.content.pm.ParceledListSlice;
import android.os.Binder;
import android.os.IBinder;
import android.os.IRemoteCallback;
import android.os.ResultReceiver;
import android.os.ShellCallback;
import android.util.Slog;
import com.android.server.LocalServices;
import com.android.server.infra.AbstractMasterSystemService;
import com.android.server.infra.AbstractPerUserSystemService;
import com.android.server.infra.FrameworkResourcesServiceNameResolver;
import com.android.server.infra.ServiceNameResolver;
import com.android.server.wm.ActivityTaskManagerInternal;
import java.io.FileDescriptor;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes.dex */
public class AppPredictionManagerService extends AbstractMasterSystemService<AppPredictionManagerService, AppPredictionPerUserService> {
    private static final int MAX_TEMP_SERVICE_DURATION_MS = 120000;
    private static final String TAG = null;
    private ActivityTaskManagerInternal mActivityTaskManagerInternal;

    private class PredictionManagerServiceStub extends IPredictionManager.Stub {
        final /* synthetic */ AppPredictionManagerService this$0;

        public static /* synthetic */ void $r8$lambda$4cBHfYYCJAMOW3ZlV3dH85TfbWE(AppPredictionSessionId r0, AppPredictionPerUserService r1) {
            lambda$requestPredictionUpdate$6(r0, r1);
        }

        /* JADX INFO: renamed from: $r8$lambda$8vNuJQ0NgsvxVPY92M0uP-2fXy4, reason: not valid java name */
        public static /* synthetic */ void m1837$r8$lambda$8vNuJQ0NgsvxVPY92M0uP2fXy4(AppPredictionSessionId r0, IRemoteCallback r1, AppPredictionPerUserService r2) {
            lambda$requestServiceFeatures$8(r0, r1, r2);
        }

        public static /* synthetic */ void $r8$lambda$HeO0uOlrZTJWV7MQsmQSiEGetsM(AppPredictionSessionId r0, IPredictionCallback r1, AppPredictionPerUserService r2) {
            lambda$registerPredictionUpdates$4(r0, r1, r2);
        }

        /* JADX INFO: renamed from: $r8$lambda$SZ-L5L7M2RKpfvkuTZCYCs9yqAo, reason: not valid java name */
        public static /* synthetic */ void m1838$r8$lambda$SZL5L7M2RKpfvkuTZCYCs9yqAo(AppPredictionSessionId r0, AppPredictionPerUserService r1) {
            lambda$onDestroyPredictionSession$7(r0, r1);
        }

        public static /* synthetic */ void $r8$lambda$V11U6dI366RmLxUT8eJGgV_2pTM(AppPredictionContext r0, AppPredictionSessionId r1, IBinder r2, AppPredictionPerUserService r3) {
            lambda$createPredictionSession$0(r0, r1, r2, r3);
        }

        /* JADX INFO: renamed from: $r8$lambda$WwdMmBcW-FJgyAOWw38ckbi0M10, reason: not valid java name */
        public static /* synthetic */ void m1839$r8$lambda$WwdMmBcWFJgyAOWw38ckbi0M10(AppPredictionSessionId r0, IPredictionCallback r1, AppPredictionPerUserService r2) {
            lambda$unregisterPredictionUpdates$5(r0, r1, r2);
        }

        /* JADX INFO: renamed from: $r8$lambda$XbQLdS6JZpdSvLj2vMz-4NTdzZw, reason: not valid java name */
        public static /* synthetic */ void m1840$r8$lambda$XbQLdS6JZpdSvLj2vMz4NTdzZw(AppPredictionSessionId r0, ParceledListSlice r1, IPredictionCallback r2, AppPredictionPerUserService r3) {
            lambda$sortAppTargets$3(r0, r1, r2, r3);
        }

        public static /* synthetic */ void $r8$lambda$auirkUz3wjBoC1mB8XUSpYb6VCQ(AppPredictionSessionId r0, AppTargetEvent r1, AppPredictionPerUserService r2) {
            lambda$notifyAppTargetEvent$1(r0, r1, r2);
        }

        public static /* synthetic */ void $r8$lambda$lGwDFNjz1uttEfy1APXgTbhUw3E(AppPredictionSessionId r0, String r1, ParceledListSlice r2, AppPredictionPerUserService r3) {
            lambda$notifyLaunchLocationShown$2(r0, r1, r2, r3);
        }

        /* synthetic */ PredictionManagerServiceStub(AppPredictionManagerService r1, AppPredictionManagerServiceIA r2) {
            this(r1);
        }

        private PredictionManagerServiceStub(AppPredictionManagerService r1) {
            this.this$0 = r1;
        }

        public void createPredictionSession(final AppPredictionContext context, final AppPredictionSessionId sessionId, final IBinder token) {
            runForUserLocked("createPredictionSession", sessionId, new AppPredictionManagerService$PredictionManagerServiceStub$$ExternalSyntheticLambda4(context, sessionId, token));
        }

        private static /* synthetic */ void lambda$createPredictionSession$0(AppPredictionContext context, AppPredictionSessionId sessionId, IBinder token, AppPredictionPerUserService service) {
            service.onCreatePredictionSessionLocked(context, sessionId, token);
        }

        public void notifyAppTargetEvent(final AppPredictionSessionId sessionId, final AppTargetEvent event) {
            runForUserLocked("notifyAppTargetEvent", sessionId, new AppPredictionManagerService$PredictionManagerServiceStub$$ExternalSyntheticLambda3(sessionId, event));
        }

        private static /* synthetic */ void lambda$notifyAppTargetEvent$1(AppPredictionSessionId sessionId, AppTargetEvent event, AppPredictionPerUserService service) {
            service.notifyAppTargetEventLocked(sessionId, event);
        }

        public void notifyLaunchLocationShown(final AppPredictionSessionId sessionId, final String launchLocation, final ParceledListSlice targetIds) {
            runForUserLocked("notifyLaunchLocationShown", sessionId, new AppPredictionManagerService$PredictionManagerServiceStub$$ExternalSyntheticLambda6(sessionId, launchLocation, targetIds));
        }

        private static /* synthetic */ void lambda$notifyLaunchLocationShown$2(AppPredictionSessionId sessionId, String launchLocation, ParceledListSlice targetIds, AppPredictionPerUserService service) {
            service.notifyLaunchLocationShownLocked(sessionId, launchLocation, targetIds);
        }

        public void sortAppTargets(final AppPredictionSessionId sessionId, final ParceledListSlice targets, final IPredictionCallback callback) {
            runForUserLocked("sortAppTargets", sessionId, new AppPredictionManagerService$PredictionManagerServiceStub$$ExternalSyntheticLambda5(sessionId, targets, callback));
        }

        private static /* synthetic */ void lambda$sortAppTargets$3(AppPredictionSessionId sessionId, ParceledListSlice targets, IPredictionCallback callback, AppPredictionPerUserService service) {
            service.sortAppTargetsLocked(sessionId, targets, callback);
        }

        public void registerPredictionUpdates(final AppPredictionSessionId sessionId, final IPredictionCallback callback) {
            runForUserLocked("registerPredictionUpdates", sessionId, new AppPredictionManagerService$PredictionManagerServiceStub$$ExternalSyntheticLambda8(sessionId, callback));
        }

        private static /* synthetic */ void lambda$registerPredictionUpdates$4(AppPredictionSessionId sessionId, IPredictionCallback callback, AppPredictionPerUserService service) {
            service.registerPredictionUpdatesLocked(sessionId, callback);
        }

        public void unregisterPredictionUpdates(final AppPredictionSessionId sessionId, final IPredictionCallback callback) {
            runForUserLocked("unregisterPredictionUpdates", sessionId, new AppPredictionManagerService$PredictionManagerServiceStub$$ExternalSyntheticLambda2(sessionId, callback));
        }

        private static /* synthetic */ void lambda$unregisterPredictionUpdates$5(AppPredictionSessionId sessionId, IPredictionCallback callback, AppPredictionPerUserService service) {
            service.unregisterPredictionUpdatesLocked(sessionId, callback);
        }

        public void requestPredictionUpdate(final AppPredictionSessionId sessionId) {
            runForUserLocked("requestPredictionUpdate", sessionId, new AppPredictionManagerService$PredictionManagerServiceStub$$ExternalSyntheticLambda7(sessionId));
        }

        private static /* synthetic */ void lambda$requestPredictionUpdate$6(AppPredictionSessionId sessionId, AppPredictionPerUserService service) {
            service.requestPredictionUpdateLocked(sessionId);
        }

        public void onDestroyPredictionSession(final AppPredictionSessionId sessionId) {
            runForUserLocked("onDestroyPredictionSession", sessionId, new AppPredictionManagerService$PredictionManagerServiceStub$$ExternalSyntheticLambda1(sessionId));
        }

        private static /* synthetic */ void lambda$onDestroyPredictionSession$7(AppPredictionSessionId sessionId, AppPredictionPerUserService service) {
            service.onDestroyPredictionSessionLocked(sessionId);
        }

        public void requestServiceFeatures(final AppPredictionSessionId sessionId, final IRemoteCallback callback) {
            runForUserLocked("requestServiceFeatures", sessionId, new AppPredictionManagerService$PredictionManagerServiceStub$$ExternalSyntheticLambda0(sessionId, callback));
        }

        private static /* synthetic */ void lambda$requestServiceFeatures$8(AppPredictionSessionId sessionId, IRemoteCallback callback, AppPredictionPerUserService service) {
            service.requestServiceFeaturesLocked(sessionId, callback);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void onShellCommand(FileDescriptor in, FileDescriptor out, FileDescriptor err, String[] args, ShellCallback callback, ResultReceiver resultReceiver) {
            new AppPredictionManagerServiceShellCommand(this.this$0).exec(this, in, out, err, args, callback, resultReceiver);
        }

        private void runForUserLocked(String func, AppPredictionSessionId sessionId, Consumer<AppPredictionPerUserService> c) {
            ActivityManagerInternal am = (ActivityManagerInternal) LocalServices.getService(ActivityManagerInternal.class);
            int userId = am.handleIncomingUser(Binder.getCallingPid(), Binder.getCallingUid(), sessionId.getUserId(), false, 0, null, null);
            Context ctx = this.this$0.getContext();
            if (ctx.checkCallingPermission("android.permission.PACKAGE_USAGE_STATS") != 0) goto L5;
        L13:
            long origId = Binder.clearCallingIdentity();
            Object r6 = AppPredictionManagerService.access$100(this.this$0);     // Catch: Throwable -> L23
            monitor-enter(r6);     // Catch: Throwable -> L23
            AppPredictionPerUserService service = (AppPredictionPerUserService) AppPredictionManagerService.access$200(this.this$0, userId);     // Catch: Throwable -> L20
            c.accept(service);     // Catch: Throwable -> L20
            monitor-exit(r6);     // Catch: Throwable -> L20
            Binder.restoreCallingIdentity(origId);
            return;
        L20:
            th = move-exception;
            throw th;     // Catch: Throwable -> L23
        L23:
            th = move-exception;
            Binder.restoreCallingIdentity(origId);
            throw th;
        L5:
            if (AppPredictionManagerService.access$000(this.this$0).isTemporary(userId) == true) goto L13;
            if (AppPredictionManagerService.m1835$$Nest$fgetmActivityTaskManagerInternal(this.this$0).isCallerRecents(Binder.getCallingUid()) == true) goto L13;
            if (Binder.getCallingUid() == 1000) goto L13;
            String msg = "Permission Denial: " + func + " from pid=" + Binder.getCallingPid() + ", uid=" + Binder.getCallingUid() + " expected caller to hold PACKAGE_USAGE_STATS permission";
            Slog.w(AppPredictionManagerService.m1836$$Nest$sfgetTAG(), msg);
            throw new SecurityException(msg);
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmActivityTaskManagerInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ ActivityTaskManagerInternal m1835$$Nest$fgetmActivityTaskManagerInternal(AppPredictionManagerService r0) {
        return r0.mActivityTaskManagerInternal;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetTAG, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m1836$$Nest$sfgetTAG() {
        return TAG;
    }

    static /* synthetic */ ServiceNameResolver access$000(AppPredictionManagerService x0) {
        return x0.mServiceNameResolver;
    }

    static /* synthetic */ Object access$100(AppPredictionManagerService x0) {
        return x0.mLock;
    }

    static /* synthetic */ AbstractPerUserSystemService access$200(AppPredictionManagerService x0, int x1) {
        return x0.getServiceForUserLocked(x1);
    }

    @Override // com.android.server.infra.AbstractMasterSystemService
    protected /* bridge */ /* synthetic */ AbstractPerUserSystemService newServiceLocked(int r1, boolean r2) {
        return newServiceLocked(r1, r2);
    }

    static {
        TAG = AppPredictionManagerService.class.getSimpleName();
    }

    public AppPredictionManagerService(Context context) {
        super(context, new FrameworkResourcesServiceNameResolver(context, R.string.config_devicePolicyManagementUpdater), null, 17);
        this.mActivityTaskManagerInternal = (ActivityTaskManagerInternal) LocalServices.getService(ActivityTaskManagerInternal.class);
    }

    @Override // com.android.server.infra.AbstractMasterSystemService
    protected AppPredictionPerUserService newServiceLocked(int resolvedUserId, boolean disabled) {
        return new AppPredictionPerUserService(this, this.mLock, resolvedUserId);
    }

    @Override // com.android.server.SystemService
    public void onStart() {
        publishBinderService("app_prediction", new PredictionManagerServiceStub(this, null));
    }

    @Override // com.android.server.infra.AbstractMasterSystemService
    protected void enforceCallingPermissionForManagement() {
        getContext().enforceCallingPermission("android.permission.MANAGE_APP_PREDICTIONS", TAG);
    }

    @Override // com.android.server.infra.AbstractMasterSystemService
    protected void onServicePackageUpdatedLocked(int userId) {
        AppPredictionPerUserService service = peekServiceForUserLocked(userId);
        if (service == null) goto L6;
        service.onPackageUpdatedLocked();
        return;
    }

    @Override // com.android.server.infra.AbstractMasterSystemService
    protected void onServicePackageRestartedLocked(int userId) {
        AppPredictionPerUserService service = peekServiceForUserLocked(userId);
        if (service == null) goto L6;
        service.onPackageRestartedLocked();
        return;
    }

    @Override // com.android.server.infra.AbstractMasterSystemService
    protected int getMaximumTemporaryServiceDurationMs() {
        return MAX_TEMP_SERVICE_DURATION_MS;
    }
}
