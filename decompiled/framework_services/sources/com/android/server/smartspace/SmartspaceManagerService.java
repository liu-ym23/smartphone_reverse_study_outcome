package com.android.server.smartspace;

import android.R;
import android.app.ActivityManagerInternal;
import android.app.smartspace.ISmartspaceCallback;
import android.app.smartspace.ISmartspaceManager;
import android.app.smartspace.SmartspaceConfig;
import android.app.smartspace.SmartspaceSessionId;
import android.app.smartspace.SmartspaceTargetEvent;
import android.content.Context;
import android.os.Binder;
import android.os.IBinder;
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

/* JADX INFO: loaded from: classes3.dex */
public class SmartspaceManagerService extends AbstractMasterSystemService<SmartspaceManagerService, SmartspacePerUserService> {
    private static final boolean DEBUG = false;
    private static final int MAX_TEMP_SERVICE_DURATION_MS = 120000;
    private static final String TAG = null;
    private final ActivityTaskManagerInternal mActivityTaskManagerInternal;

    private class SmartspaceManagerStub extends ISmartspaceManager.Stub {
        final /* synthetic */ SmartspaceManagerService this$0;

        /* JADX INFO: renamed from: $r8$lambda$-u6Xviy51_bvQo3cmM29_JqNWds, reason: not valid java name */
        public static /* synthetic */ void m8171$r8$lambda$u6Xviy51_bvQo3cmM29_JqNWds(SmartspaceSessionId r0, ISmartspaceCallback r1, SmartspacePerUserService r2) {
            lambda$unregisterSmartspaceUpdates$4(r0, r1, r2);
        }

        /* JADX INFO: renamed from: $r8$lambda$0Nr9-OIacEZWZ2M4GOhvgYvoQsY, reason: not valid java name */
        public static /* synthetic */ void m8172$r8$lambda$0Nr9OIacEZWZ2M4GOhvgYvoQsY(SmartspaceSessionId r0, SmartspacePerUserService r1) {
            lambda$requestSmartspaceUpdate$2(r0, r1);
        }

        public static /* synthetic */ void $r8$lambda$2XubiOtdFOWS423rTV4XgoGm6B0(SmartspaceConfig r0, SmartspaceSessionId r1, IBinder r2, SmartspacePerUserService r3) {
            lambda$createSmartspaceSession$0(r0, r1, r2, r3);
        }

        /* JADX INFO: renamed from: $r8$lambda$3P1p-SPi4-sLfzZcdBGgwIVYlS4, reason: not valid java name */
        public static /* synthetic */ void m8173$r8$lambda$3P1pSPi4sLfzZcdBGgwIVYlS4(SmartspaceSessionId r0, SmartspacePerUserService r1) {
            lambda$destroySmartspaceSession$5(r0, r1);
        }

        public static /* synthetic */ void $r8$lambda$DVLukJKWpYQ06IA8KQDSBhbI95o(SmartspaceSessionId r0, SmartspaceTargetEvent r1, SmartspacePerUserService r2) {
            lambda$notifySmartspaceEvent$1(r0, r1, r2);
        }

        public static /* synthetic */ void $r8$lambda$qqwvjqMzNxNq9MbAKuNAZazeWfI(SmartspaceSessionId r0, ISmartspaceCallback r1, SmartspacePerUserService r2) {
            lambda$registerSmartspaceUpdates$3(r0, r1, r2);
        }

        /* synthetic */ SmartspaceManagerStub(SmartspaceManagerService r1, SmartspaceManagerServiceIA r2) {
            this(r1);
        }

        private SmartspaceManagerStub(SmartspaceManagerService r1) {
            this.this$0 = r1;
        }

        public void createSmartspaceSession(final SmartspaceConfig smartspaceConfig, final SmartspaceSessionId sessionId, final IBinder token) {
            runForUserLocked("createSmartspaceSession", sessionId, new SmartspaceManagerService$SmartspaceManagerStub$$ExternalSyntheticLambda1(smartspaceConfig, sessionId, token));
        }

        private static /* synthetic */ void lambda$createSmartspaceSession$0(SmartspaceConfig smartspaceConfig, SmartspaceSessionId sessionId, IBinder token, SmartspacePerUserService service) {
            service.onCreateSmartspaceSessionLocked(smartspaceConfig, sessionId, token);
        }

        public void notifySmartspaceEvent(final SmartspaceSessionId sessionId, final SmartspaceTargetEvent event) {
            runForUserLocked("notifySmartspaceEvent", sessionId, new SmartspaceManagerService$SmartspaceManagerStub$$ExternalSyntheticLambda5(sessionId, event));
        }

        private static /* synthetic */ void lambda$notifySmartspaceEvent$1(SmartspaceSessionId sessionId, SmartspaceTargetEvent event, SmartspacePerUserService service) {
            service.notifySmartspaceEventLocked(sessionId, event);
        }

        public void requestSmartspaceUpdate(final SmartspaceSessionId sessionId) {
            runForUserLocked("requestSmartspaceUpdate", sessionId, new SmartspaceManagerService$SmartspaceManagerStub$$ExternalSyntheticLambda3(sessionId));
        }

        private static /* synthetic */ void lambda$requestSmartspaceUpdate$2(SmartspaceSessionId sessionId, SmartspacePerUserService service) {
            service.requestSmartspaceUpdateLocked(sessionId);
        }

        public void registerSmartspaceUpdates(final SmartspaceSessionId sessionId, final ISmartspaceCallback callback) {
            runForUserLocked("registerSmartspaceUpdates", sessionId, new SmartspaceManagerService$SmartspaceManagerStub$$ExternalSyntheticLambda4(sessionId, callback));
        }

        private static /* synthetic */ void lambda$registerSmartspaceUpdates$3(SmartspaceSessionId sessionId, ISmartspaceCallback callback, SmartspacePerUserService service) {
            service.registerSmartspaceUpdatesLocked(sessionId, callback);
        }

        public void unregisterSmartspaceUpdates(final SmartspaceSessionId sessionId, final ISmartspaceCallback callback) {
            runForUserLocked("unregisterSmartspaceUpdates", sessionId, new SmartspaceManagerService$SmartspaceManagerStub$$ExternalSyntheticLambda0(sessionId, callback));
        }

        private static /* synthetic */ void lambda$unregisterSmartspaceUpdates$4(SmartspaceSessionId sessionId, ISmartspaceCallback callback, SmartspacePerUserService service) {
            service.unregisterSmartspaceUpdatesLocked(sessionId, callback);
        }

        public void destroySmartspaceSession(final SmartspaceSessionId sessionId) {
            runForUserLocked("destroySmartspaceSession", sessionId, new SmartspaceManagerService$SmartspaceManagerStub$$ExternalSyntheticLambda2(sessionId));
        }

        private static /* synthetic */ void lambda$destroySmartspaceSession$5(SmartspaceSessionId sessionId, SmartspacePerUserService service) {
            service.onDestroyLocked(sessionId);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void onShellCommand(FileDescriptor in, FileDescriptor out, FileDescriptor err, String[] args, ShellCallback callback, ResultReceiver resultReceiver) {
            new SmartspaceManagerServiceShellCommand(this.this$0).exec(this, in, out, err, args, callback, resultReceiver);
        }

        private void runForUserLocked(String func, SmartspaceSessionId sessionId, Consumer<SmartspacePerUserService> c) {
            ActivityManagerInternal am = (ActivityManagerInternal) LocalServices.getService(ActivityManagerInternal.class);
            int userId = am.handleIncomingUser(Binder.getCallingPid(), Binder.getCallingUid(), sessionId.getUserHandle().getIdentifier(), false, 0, null, null);
            Context ctx = this.this$0.getContext();
            if (ctx.checkCallingPermission("android.permission.MANAGE_SMARTSPACE") != 0) goto L5;
        L13:
            long origId = Binder.clearCallingIdentity();
            Object r6 = SmartspaceManagerService.access$100(this.this$0);     // Catch: Throwable -> L23
            monitor-enter(r6);     // Catch: Throwable -> L23
            SmartspacePerUserService service = (SmartspacePerUserService) SmartspaceManagerService.access$200(this.this$0, userId);     // Catch: Throwable -> L20
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
            if (ctx.checkCallingPermission("android.permission.ACCESS_SMARTSPACE") == 0) goto L13;
            if (SmartspaceManagerService.access$000(this.this$0).isTemporary(userId) == true) goto L13;
            if (SmartspaceManagerService.m8169$$Nest$fgetmActivityTaskManagerInternal(this.this$0).isCallerRecents(Binder.getCallingUid()) == true) goto L13;
            String msg = "Permission Denial: Cannot call " + func + " from pid=" + Binder.getCallingPid() + ", uid=" + Binder.getCallingUid();
            Slog.w(SmartspaceManagerService.m8170$$Nest$sfgetTAG(), msg);
            throw new SecurityException(msg);
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmActivityTaskManagerInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ ActivityTaskManagerInternal m8169$$Nest$fgetmActivityTaskManagerInternal(SmartspaceManagerService r0) {
        return r0.mActivityTaskManagerInternal;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetTAG, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m8170$$Nest$sfgetTAG() {
        return TAG;
    }

    static /* synthetic */ ServiceNameResolver access$000(SmartspaceManagerService x0) {
        return x0.mServiceNameResolver;
    }

    static /* synthetic */ Object access$100(SmartspaceManagerService x0) {
        return x0.mLock;
    }

    static /* synthetic */ AbstractPerUserSystemService access$200(SmartspaceManagerService x0, int x1) {
        return x0.getServiceForUserLocked(x1);
    }

    @Override // com.android.server.infra.AbstractMasterSystemService
    protected /* bridge */ /* synthetic */ AbstractPerUserSystemService newServiceLocked(int r1, boolean r2) {
        return newServiceLocked(r1, r2);
    }

    static {
        TAG = SmartspaceManagerService.class.getSimpleName();
    }

    public SmartspaceManagerService(Context context) {
        super(context, new FrameworkResourcesServiceNameResolver(context, R.string.config_headlineFontFeatureSettings), null, 17);
        this.mActivityTaskManagerInternal = (ActivityTaskManagerInternal) LocalServices.getService(ActivityTaskManagerInternal.class);
    }

    @Override // com.android.server.infra.AbstractMasterSystemService
    protected SmartspacePerUserService newServiceLocked(int resolvedUserId, boolean disabled) {
        return new SmartspacePerUserService(this, this.mLock, resolvedUserId);
    }

    @Override // com.android.server.SystemService
    public void onStart() {
        publishBinderService("smartspace", new SmartspaceManagerStub(this, null));
    }

    @Override // com.android.server.infra.AbstractMasterSystemService
    protected void enforceCallingPermissionForManagement() {
        getContext().enforceCallingPermission("android.permission.MANAGE_SMARTSPACE", TAG);
    }

    @Override // com.android.server.infra.AbstractMasterSystemService
    protected void onServicePackageUpdatedLocked(int userId) {
        SmartspacePerUserService service = peekServiceForUserLocked(userId);
        if (service == null) goto L6;
        service.onPackageUpdatedLocked();
        return;
    }

    @Override // com.android.server.infra.AbstractMasterSystemService
    protected void onServicePackageRestartedLocked(int userId) {
        SmartspacePerUserService service = peekServiceForUserLocked(userId);
        if (service == null) goto L6;
        service.onPackageRestartedLocked();
        return;
    }

    @Override // com.android.server.infra.AbstractMasterSystemService
    protected int getMaximumTemporaryServiceDurationMs() {
        return MAX_TEMP_SERVICE_DURATION_MS;
    }
}
