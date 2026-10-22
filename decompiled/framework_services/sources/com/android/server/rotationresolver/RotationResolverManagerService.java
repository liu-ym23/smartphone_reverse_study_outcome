package com.android.server.rotationresolver;

import android.R;
import android.content.ComponentName;
import android.content.Context;
import android.hardware.SensorPrivacyManager;
import android.os.Binder;
import android.os.CancellationSignal;
import android.os.ResultReceiver;
import android.os.ShellCallback;
import android.provider.DeviceConfig;
import android.rotationresolver.RotationResolverInternal;
import android.service.rotationresolver.RotationResolutionRequest;
import android.text.TextUtils;
import android.util.Slog;
import com.android.internal.util.DumpUtils;
import com.android.internal.util.FrameworkStatsLog;
import com.android.server.infra.AbstractMasterSystemService;
import com.android.server.infra.AbstractPerUserSystemService;
import com.android.server.infra.FrameworkResourcesServiceNameResolver;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public class RotationResolverManagerService extends AbstractMasterSystemService<RotationResolverManagerService, RotationResolverManagerPerUserService> {
    private static final boolean DEFAULT_SERVICE_ENABLED = true;
    private static final String KEY_SERVICE_ENABLED = "service_enabled";
    static final int ORIENTATION_UNKNOWN = 0;
    static final int RESOLUTION_DISABLED = 6;
    static final int RESOLUTION_FAILURE = 8;
    static final int RESOLUTION_UNAVAILABLE = 7;
    private static final String TAG = null;
    private final Context mContext;
    boolean mIsServiceEnabled;
    private final SensorPrivacyManager mPrivacyManager;

    private final class BinderService extends Binder {
        final /* synthetic */ RotationResolverManagerService this$0;

        /* synthetic */ BinderService(RotationResolverManagerService r1, RotationResolverManagerServiceIA r2) {
            this(r1);
        }

        private BinderService(RotationResolverManagerService r1) {
            this.this$0 = r1;
        }

        @Override // android.os.Binder
        protected void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
            if (DumpUtils.checkDumpPermission(RotationResolverManagerService.m8006$$Nest$fgetmContext(this.this$0), RotationResolverManagerService.m8008$$Nest$sfgetTAG(), pw) == true) goto L5;
            return;
        L5:
            Object r0 = RotationResolverManagerService.access$300(this.this$0);
            monitor-enter(r0);
            RotationResolverManagerService.access$400(this.this$0, "", pw);     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            throw th;
        }

        public void onShellCommand(FileDescriptor in, FileDescriptor out, FileDescriptor err, String[] args, ShellCallback callback, ResultReceiver resultReceiver) {
            RotationResolverManagerService.m8006$$Nest$fgetmContext(this.this$0).enforceCallingOrSelfPermission("android.permission.MANAGE_ROTATION_RESOLVER", RotationResolverManagerService.m8008$$Nest$sfgetTAG());
            new RotationResolverShellCommand(this.this$0).exec(this, in, out, err, args, callback, resultReceiver);
        }
    }

    private final class LocalService extends RotationResolverInternal {
        final /* synthetic */ RotationResolverManagerService this$0;

        /* synthetic */ LocalService(RotationResolverManagerService r1, RotationResolverManagerServiceIA r2) {
            this(r1);
        }

        private LocalService(RotationResolverManagerService r1) {
            this.this$0 = r1;
        }

        public boolean isRotationResolverSupported() {
            Object r0 = RotationResolverManagerService.access$000(this.this$0);
            monitor-enter(r0);
            boolean r1 = this.this$0.mIsServiceEnabled;     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        public void resolveRotation(RotationResolverInternal.RotationResolverCallbackInternal callbackInternal, String packageName, int proposedRotation, int currentRotation, long timeout, CancellationSignal cancellationSignalInternal) {
            callbackInternal.getClass();
            cancellationSignalInternal.getClass();
            Object r3 = RotationResolverManagerService.access$100(this.this$0);
            monitor-enter(r3);
        L34:
            th = th;
        L35:
            monitor-exit(r3);     // Catch: Throwable -> L34
            throw th;
        L15:
            th = th;
            goto L35
        L5:
            if (RotationResolverManagerService.m8007$$Nest$fgetmPrivacyManager(this.this$0).isSensorPrivacyEnabled(2) == true) goto L7;
            boolean isCameraAvailable = true;
        L39:
            if (this.this$0.mIsServiceEnabled == false) goto L26;
            if (isCameraAvailable == false) goto L26;
            RotationResolverManagerPerUserService service = (RotationResolverManagerPerUserService) RotationResolverManagerService.access$200(this.this$0, -2);     // Catch: Throwable -> L23
            if (packageName != null) goto L17;
            RotationResolutionRequest request = new RotationResolutionRequest("", currentRotation, proposedRotation, true, timeout);     // Catch: Throwable -> L15
        L20:
            service.resolveRotationLocked(callbackInternal, request, cancellationSignalInternal);     // Catch: Throwable -> L21
        L32:
            monitor-exit(r3);     // Catch: Throwable -> L34
            return;
        L17:
            request = new RotationResolutionRequest(packageName, currentRotation, proposedRotation, true, timeout);     // Catch: Throwable -> L23
        L23:
            th = th;
        L26:
            if (isCameraAvailable == false) goto L28;
            Slog.w(RotationResolverManagerService.m8008$$Nest$sfgetTAG(), "Rotation Resolver service is disabled.");     // Catch: Throwable -> L21
        L29:
            callbackInternal.onFailure(0);     // Catch: Throwable -> L21
            RotationResolverManagerService.logRotationStats(proposedRotation, currentRotation, 6);     // Catch: Throwable -> L34
            goto L32
        L28:
            Slog.w(RotationResolverManagerService.m8008$$Nest$sfgetTAG(), "Camera is locked by a toggle.");     // Catch: Throwable -> L21
        L21:
            th = th;
            goto L35
        L7:
            isCameraAvailable = false;
            goto L39
        }
    }

    public static /* synthetic */ void $r8$lambda$oQhD4m_8GeIRFIisyffwYNknc2Q(RotationResolverManagerService r0, DeviceConfig.Properties r1) {
        r0.lambda$onBootPhase$0(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context m8006$$Nest$fgetmContext(RotationResolverManagerService r0) {
        return r0.mContext;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPrivacyManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ SensorPrivacyManager m8007$$Nest$fgetmPrivacyManager(RotationResolverManagerService r0) {
        return r0.mPrivacyManager;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetTAG, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m8008$$Nest$sfgetTAG() {
        return TAG;
    }

    static /* synthetic */ Object access$000(RotationResolverManagerService x0) {
        return x0.mLock;
    }

    static /* synthetic */ Object access$100(RotationResolverManagerService x0) {
        return x0.mLock;
    }

    static /* synthetic */ AbstractPerUserSystemService access$200(RotationResolverManagerService x0, int x1) {
        return x0.getServiceForUserLocked(x1);
    }

    static /* synthetic */ Object access$300(RotationResolverManagerService x0) {
        return x0.mLock;
    }

    static /* synthetic */ void access$400(RotationResolverManagerService x0, String x1, PrintWriter x2) {
        x0.dumpLocked(x1, x2);
    }

    @Override // com.android.server.infra.AbstractMasterSystemService
    public /* bridge */ /* synthetic */ AbstractPerUserSystemService newServiceLocked(int r1, boolean r2) {
        return newServiceLocked(r1, r2);
    }

    @Override // com.android.server.infra.AbstractMasterSystemService
    protected /* bridge */ /* synthetic */ void onServiceRemoved(AbstractPerUserSystemService r1, int r2) {
        onServiceRemoved((RotationResolverManagerPerUserService) r1, r2);
    }

    static {
        TAG = RotationResolverManagerService.class.getSimpleName();
    }

    public RotationResolverManagerService(Context context) {
        super(context, new FrameworkResourcesServiceNameResolver(context, R.string.config_hapticFeedbackCustomizationFile), null, 68);
        this.mContext = context;
        this.mPrivacyManager = SensorPrivacyManager.getInstance(context);
    }

    @Override // com.android.server.infra.AbstractMasterSystemService, com.android.server.SystemService
    public void onBootPhase(int phase) {
        if (phase != 500) goto L6;
        DeviceConfig.addOnPropertiesChangedListener("rotation_resolver", getContext().getMainExecutor(), new RotationResolverManagerService$$ExternalSyntheticLambda0(this));
        this.mIsServiceEnabled = DeviceConfig.getBoolean("rotation_resolver", KEY_SERVICE_ENABLED, true);
        return;
    }

    private /* synthetic */ void lambda$onBootPhase$0(DeviceConfig.Properties properties) {
        onDeviceConfigChange(properties.getKeyset());
    }

    private void onDeviceConfigChange(Set<String> keys) {
        if (keys.contains(KEY_SERVICE_ENABLED) == false) goto L6;
        this.mIsServiceEnabled = DeviceConfig.getBoolean("rotation_resolver", KEY_SERVICE_ENABLED, true);
        return;
    }

    @Override // com.android.server.SystemService
    public void onStart() {
        RotationResolverManagerServiceIA r1 = null;
        publishBinderService("resolver", new BinderService(this, r1));
        publishLocalService(RotationResolverInternal.class, new LocalService(this, r1));
    }

    @Override // com.android.server.infra.AbstractMasterSystemService
    public RotationResolverManagerPerUserService newServiceLocked(int resolvedUserId, boolean disabled) {
        return new RotationResolverManagerPerUserService(this, this.mLock, resolvedUserId);
    }

    protected void onServiceRemoved(RotationResolverManagerPerUserService service, int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        service.destroyLocked();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static boolean isServiceConfigured(Context context) {
        return !TextUtils.isEmpty(getServiceConfigPackage(context));
    }

    ComponentName getComponentNameShellCommand(int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        RotationResolverManagerPerUserService service = getServiceForUserLocked(userId);     // Catch: Throwable -> L9
        if (service == null) goto L12;
        ComponentName r2 = service.getComponentName();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return null;
    L9:
        th = move-exception;
        throw th;
    }

    void resolveRotationShellCommand(int userId, RotationResolverInternal.RotationResolverCallbackInternal callbackInternal, RotationResolutionRequest request) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        RotationResolverManagerPerUserService service = getServiceForUserLocked(userId);     // Catch: Throwable -> L7
        if (service == null) goto L9;
        service.resolveRotationLocked(callbackInternal, request, new CancellationSignal());     // Catch: Throwable -> L7
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L9:
        Slog.i(TAG, "service not available for user_id: " + userId);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }

    static String getServiceConfigPackage(Context context) {
        return context.getPackageManager().getRotationResolverPackageName();
    }

    static void logRotationStatsWithTimeToCalculate(int proposedRotation, int currentRotation, int result, long timeToCalculate) {
        FrameworkStatsLog.write(328, surfaceRotationToProto(currentRotation), surfaceRotationToProto(proposedRotation), result, timeToCalculate);
    }

    static void logRotationStats(int proposedRotation, int currentRotation, int result) {
        FrameworkStatsLog.write(328, surfaceRotationToProto(currentRotation), surfaceRotationToProto(proposedRotation), result);
    }

    static int errorCodeToProto(int error) {
        switch(error) {
            case 0: goto L7;
            case 1: goto L7;
            case 2: goto L7;
            case 3: goto L3;
            case 4: goto L5;
            default: goto L3;
        };
    L3:
        return 8;
    L5:
        return 7;
    L7:
        return 0;
    }

    static int surfaceRotationToProto(int rotationPoseResult) {
        switch(rotationPoseResult) {
            case 0: goto L11;
            case 1: goto L9;
            case 2: goto L7;
            case 3: goto L5;
            default: goto L3;
        };
    L3:
        return 8;
    L5:
        return 5;
    L7:
        return 4;
    L9:
        return 3;
    L11:
        return 2;
    }
}
