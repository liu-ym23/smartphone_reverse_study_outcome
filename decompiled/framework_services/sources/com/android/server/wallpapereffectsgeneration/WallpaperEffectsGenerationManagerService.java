package com.android.server.wallpapereffectsgeneration;

import android.R;
import android.app.ActivityManagerInternal;
import android.app.wallpapereffectsgeneration.CinematicEffectRequest;
import android.app.wallpapereffectsgeneration.CinematicEffectResponse;
import android.app.wallpapereffectsgeneration.ICinematicEffectListener;
import android.app.wallpapereffectsgeneration.IWallpaperEffectsGenerationManager;
import android.content.Context;
import android.os.Binder;
import android.os.RemoteException;
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
public class WallpaperEffectsGenerationManagerService extends AbstractMasterSystemService<WallpaperEffectsGenerationManagerService, WallpaperEffectsGenerationPerUserService> {
    private static final boolean DEBUG = false;
    private static final int MAX_TEMP_SERVICE_DURATION_MS = 120000;
    private static final String TAG = null;
    private final ActivityTaskManagerInternal mActivityTaskManagerInternal;

    private class WallpaperEffectsGenerationManagerStub extends IWallpaperEffectsGenerationManager.Stub {
        final /* synthetic */ WallpaperEffectsGenerationManagerService this$0;

        public static /* synthetic */ void $r8$lambda$pMzVYgboKqQ1jfHZmVrtpczZLa0(CinematicEffectResponse r0, WallpaperEffectsGenerationPerUserService r1) {
            lambda$returnCinematicEffectResponse$1(r0, r1);
        }

        /* JADX INFO: renamed from: $r8$lambda$uUhaGX3AcrpT-pzS5rgwrr1BfKE, reason: not valid java name */
        public static /* synthetic */ void m9549$r8$lambda$uUhaGX3AcrpTpzS5rgwrr1BfKE(CinematicEffectRequest r0, ICinematicEffectListener r1, WallpaperEffectsGenerationPerUserService r2) {
            lambda$generateCinematicEffect$0(r0, r1, r2);
        }

        /* synthetic */ WallpaperEffectsGenerationManagerStub(WallpaperEffectsGenerationManagerService r1, WallpaperEffectsGenerationManagerServiceIA r2) {
            this(r1);
        }

        private WallpaperEffectsGenerationManagerStub(WallpaperEffectsGenerationManagerService r1) {
            this.this$0 = r1;
        }

        public void generateCinematicEffect(final CinematicEffectRequest request, final ICinematicEffectListener listener) {
            if (runForUser("generateCinematicEffect", true, new WallpaperEffectsGenerationManagerService$WallpaperEffectsGenerationManagerStub$$ExternalSyntheticLambda1(request, listener)) == true) goto L10;
            listener.onCinematicEffectGenerated(new CinematicEffectResponse.Builder(0, request.getTaskId()).build());     // Catch: RemoteException -> L6
            return;
        L7:
            return;
        }

        private static /* synthetic */ void lambda$generateCinematicEffect$0(CinematicEffectRequest request, ICinematicEffectListener listener, WallpaperEffectsGenerationPerUserService service) {
            service.onGenerateCinematicEffectLocked(request, listener);
        }

        public void returnCinematicEffectResponse(final CinematicEffectResponse response) {
            runForUser("returnCinematicResponse", false, new WallpaperEffectsGenerationManagerService$WallpaperEffectsGenerationManagerStub$$ExternalSyntheticLambda0(response));
        }

        private static /* synthetic */ void lambda$returnCinematicEffectResponse$1(CinematicEffectResponse response, WallpaperEffectsGenerationPerUserService service) {
            service.onReturnCinematicEffectResponseLocked(response);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void onShellCommand(FileDescriptor in, FileDescriptor out, FileDescriptor err, String[] args, ShellCallback callback, ResultReceiver resultReceiver) {
            new WallpaperEffectsGenerationManagerServiceShellCommand(this.this$0).exec(this, in, out, err, args, callback, resultReceiver);
        }

        private boolean runForUser(String func, boolean checkManageWallpaperEffectsPermission, Consumer<WallpaperEffectsGenerationPerUserService> c) {
            ActivityManagerInternal am = (ActivityManagerInternal) LocalServices.getService(ActivityManagerInternal.class);
            int userId = am.handleIncomingUser(Binder.getCallingPid(), Binder.getCallingUid(), Binder.getCallingUserHandle().getIdentifier(), false, 0, null, null);
            if (checkManageWallpaperEffectsPermission == false) goto L13;
            Context ctx = this.this$0.getContext();
            if (ctx.checkCallingPermission("android.permission.MANAGE_WALLPAPER_EFFECTS_GENERATION") == 0) goto L13;
            if (WallpaperEffectsGenerationManagerService.access$000(this.this$0).isTemporary(userId) == true) goto L13;
            if (WallpaperEffectsGenerationManagerService.m9547$$Nest$fgetmActivityTaskManagerInternal(this.this$0).isCallerRecents(Binder.getCallingUid()) == true) goto L13;
            String msg = "Permission Denial: Cannot call " + func + " from pid=" + Binder.getCallingPid() + ", uid=" + Binder.getCallingUid();
            Slog.w(WallpaperEffectsGenerationManagerService.m9548$$Nest$sfgetTAG(), msg);
            throw new SecurityException(msg);
        L13:
            int origCallingUid = Binder.getCallingUid();
            long origId = Binder.clearCallingIdentity();
            boolean accepted = false;
            Object r7 = WallpaperEffectsGenerationManagerService.access$100(this.this$0);     // Catch: Throwable -> L32
            monitor-enter(r7);     // Catch: Throwable -> L32
            WallpaperEffectsGenerationPerUserService service = (WallpaperEffectsGenerationPerUserService) WallpaperEffectsGenerationManagerService.access$200(this.this$0, userId);     // Catch: Throwable -> L24
            if (service == null) goto L27;
            if (checkManageWallpaperEffectsPermission == false) goto L20;
        L26:
            accepted = true;
            c.accept(service);     // Catch: Throwable -> L24
            goto L27
        L20:
            if (service.isCallingUidAllowed(origCallingUid) == true) goto L26;
            String msg2 = "Permission Denial: cannot call " + func + ", uid[" + origCallingUid + "] doesn't match service implementation";     // Catch: Throwable -> L24
            Slog.w(WallpaperEffectsGenerationManagerService.m9548$$Nest$sfgetTAG(), msg2);     // Catch: Throwable -> L24
            throw new SecurityException(msg2);     // Catch: Throwable -> L24
        L27:
            monitor-exit(r7);     // Catch: Throwable -> L24
            Binder.restoreCallingIdentity(origId);
            return accepted;
        L24:
            th = move-exception;
            throw th;     // Catch: Throwable -> L32
        L32:
            th = move-exception;
            Binder.restoreCallingIdentity(origId);
            throw th;
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmActivityTaskManagerInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ ActivityTaskManagerInternal m9547$$Nest$fgetmActivityTaskManagerInternal(WallpaperEffectsGenerationManagerService r0) {
        return r0.mActivityTaskManagerInternal;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetTAG, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m9548$$Nest$sfgetTAG() {
        return TAG;
    }

    static /* synthetic */ ServiceNameResolver access$000(WallpaperEffectsGenerationManagerService x0) {
        return x0.mServiceNameResolver;
    }

    static /* synthetic */ Object access$100(WallpaperEffectsGenerationManagerService x0) {
        return x0.mLock;
    }

    static /* synthetic */ AbstractPerUserSystemService access$200(WallpaperEffectsGenerationManagerService x0, int x1) {
        return x0.getServiceForUserLocked(x1);
    }

    @Override // com.android.server.infra.AbstractMasterSystemService
    protected /* bridge */ /* synthetic */ AbstractPerUserSystemService newServiceLocked(int r1, boolean r2) {
        return newServiceLocked(r1, r2);
    }

    static {
        TAG = WallpaperEffectsGenerationManagerService.class.getSimpleName();
    }

    public WallpaperEffectsGenerationManagerService(Context context) {
        super(context, new FrameworkResourcesServiceNameResolver(context, R.string.config_incidentReportApproverPackage), null, 17);
        this.mActivityTaskManagerInternal = (ActivityTaskManagerInternal) LocalServices.getService(ActivityTaskManagerInternal.class);
    }

    @Override // com.android.server.infra.AbstractMasterSystemService
    protected WallpaperEffectsGenerationPerUserService newServiceLocked(int resolvedUserId, boolean disabled) {
        return new WallpaperEffectsGenerationPerUserService(this, this.mLock, resolvedUserId);
    }

    @Override // com.android.server.SystemService
    public void onStart() {
        publishBinderService("wallpaper_effects_generation", new WallpaperEffectsGenerationManagerStub(this, null));
    }

    @Override // com.android.server.infra.AbstractMasterSystemService
    protected void enforceCallingPermissionForManagement() {
        getContext().enforceCallingPermission("android.permission.MANAGE_WALLPAPER_EFFECTS_GENERATION", TAG);
    }

    @Override // com.android.server.infra.AbstractMasterSystemService
    protected void onServicePackageUpdatedLocked(int userId) {
        WallpaperEffectsGenerationPerUserService service = peekServiceForUserLocked(userId);
        if (service == null) goto L6;
        service.onPackageUpdatedLocked();
        return;
    }

    @Override // com.android.server.infra.AbstractMasterSystemService
    protected void onServicePackageRestartedLocked(int userId) {
        WallpaperEffectsGenerationPerUserService service = peekServiceForUserLocked(userId);
        if (service == null) goto L6;
        service.onPackageRestartedLocked();
        return;
    }

    @Override // com.android.server.infra.AbstractMasterSystemService
    protected int getMaximumTemporaryServiceDurationMs() {
        return MAX_TEMP_SERVICE_DURATION_MS;
    }
}
