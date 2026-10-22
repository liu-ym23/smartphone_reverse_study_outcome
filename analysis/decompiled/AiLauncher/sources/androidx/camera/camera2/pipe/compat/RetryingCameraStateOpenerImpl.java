package androidx.camera.camera2.pipe.compat;

import Ua.C1056g;
import android.util.Log;
import androidx.camera.camera2.pipe.core.Threads;
import androidx.camera.camera2.pipe.h;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import w.C5706l;
import w.C5708n;
import x.AwaitOpenCameraResult;
import x.G0;
import x.H0;
import x.W;
import x.s0;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0001\u0018\u0000 12\u00020\u0001:\u0001$BK\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J4\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00162\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a0\u0018H\u0096@¢\u0006\u0004\b\u001d\u0010\u001eJ\u001f\u0010 \u001a\u00020\u001f2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\"\u0010#R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010(R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010+R\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010,R\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100¨\u00062"}, d2 = {"Landroidx/camera/camera2/pipe/compat/RetryingCameraStateOpenerImpl;", "Lx/G0;", "Landroidx/camera/camera2/pipe/compat/CameraStateOpener;", "cameraStateOpener", "LB/c;", "cameraErrorListener", "Landroidx/camera/camera2/pipe/compat/n;", "cameraAvailabilityMonitor", "Lz/w;", "timeSource", "Lx/s0;", "devicePolicyManager", "Landroidx/camera/camera2/pipe/compat/j;", "audioRestrictionController", "Landroidx/camera/camera2/pipe/h$b;", "cameraInteropConfig", "Landroidx/camera/camera2/pipe/core/Threads;", "threads", "<init>", "(Landroidx/camera/camera2/pipe/compat/CameraStateOpener;LB/c;Landroidx/camera/camera2/pipe/compat/n;Lz/w;Lx/s0;Landroidx/camera/camera2/pipe/compat/j;Landroidx/camera/camera2/pipe/h$b;Landroidx/camera/camera2/pipe/core/Threads;)V", "Lw/n;", "cameraId", "Lx/W;", "camera2DeviceCloser", "Lkotlin/Function1;", "LY8/t;", "", "isForegroundObserver", "Lx/v0;", "f", "(Ljava/lang/String;Lx/W;Lp9/l;Le9/c;)Ljava/lang/Object;", "Lx/x;", "e", "(Ljava/lang/String;Lx/W;)Lx/x;", "c", "()V", Const.INTENT_KEY_APIKEY, "Landroidx/camera/camera2/pipe/compat/CameraStateOpener;", Const.INTENT_KEY_PKGNAME, "LB/c;", "Landroidx/camera/camera2/pipe/compat/n;", Const.INTENT_KEY_UMID, "Lz/w;", "Lx/s0;", "Landroidx/camera/camera2/pipe/compat/j;", Const.INTENT_KEY_BACKGROUND_COMMAND, "Landroidx/camera/camera2/pipe/h$b;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "Landroidx/camera/camera2/pipe/core/Threads;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class RetryingCameraStateOpenerImpl implements G0 {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final CameraStateOpener cameraStateOpener;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final B.c cameraErrorListener;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final n cameraAvailabilityMonitor;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final z.w timeSource;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final s0 devicePolicyManager;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final j audioRestrictionController;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public final h.CameraInteropConfig cameraInteropConfig;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public final Threads threads;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JE\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\bH\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0010\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0010\u0010\u0011J#\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\bH\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0016\u001a\u00020\u00152\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\nH\u0000¢\u0006\u0004\b\u0016\u0010\u0017J!\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Landroidx/camera/camera2/pipe/compat/RetryingCameraStateOpenerImpl$a;", "", "<init>", "()V", "Lw/l;", "errorCode", "", "attempts", "Lz/i;", "elapsedNs", "", "camerasDisabledByDevicePolicy", "isForeground", "cameraOpenRetryMaxTimeoutNs", "e", "(IIJZZLz/i;)Z", Const.INTENT_KEY_UMID, "(ZI)Z", "activeResumeActivated", Const.INTENT_KEY_PKGNAME, "(ZLz/i;)J", "", Const.INTENT_KEY_APIKEY, "(JZ)J", "d1", "d2", "c", "(JLz/i;)J", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: androidx.camera.camera2.pipe.compat.RetryingCameraStateOpenerImpl$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final long a(long elapsedNs, boolean activeResumeActivated) {
            if (activeResumeActivated && z.i.b(elapsedNs, H0.f43311c[0].getValue()) >= 0) {
                return z.i.b(elapsedNs, H0.f43311c[1].getValue()) < 0 ? 2000L : 4000L;
            }
            return 500L;
        }

        public final long b(boolean activeResumeActivated, z.i cameraOpenRetryMaxTimeoutNs) {
            return !activeResumeActivated ? c(H0.f43309a, cameraOpenRetryMaxTimeoutNs) : c(H0.f43310b, cameraOpenRetryMaxTimeoutNs);
        }

        public final long c(long d12, z.i d22) {
            return (d22 == null || z.i.b(d12, d22.getValue()) == -1) ? d12 : d22.getValue();
        }

        public final boolean d(boolean isForeground, int errorCode) {
            return false;
        }

        public final boolean e(int errorCode, int attempts, long elapsedNs, boolean camerasDisabledByDevicePolicy, boolean isForeground, z.i cameraOpenRetryMaxTimeoutNs) {
            boolean zD = d(isForeground, errorCode);
            if (zD && z.k.f44508a.a()) {
                Log.d("CXCP", "shouldRetry: Active resume mode is activated");
            }
            if (z.i.b(elapsedNs, b(zD, cameraOpenRetryMaxTimeoutNs)) > 0) {
                return false;
            }
            C5706l.Companion companion = C5706l.INSTANCE;
            if (C5706l.r(errorCode, companion.p())) {
                return attempts <= 1;
            }
            if (C5706l.r(errorCode, companion.g()) || C5706l.r(errorCode, companion.h())) {
                return true;
            }
            if (C5706l.r(errorCode, companion.e())) {
                return !camerasDisabledByDevicePolicy || attempts <= 1;
            }
            if (C5706l.r(errorCode, companion.d()) || C5706l.r(errorCode, companion.k()) || C5706l.r(errorCode, companion.f()) || C5706l.r(errorCode, companion.n())) {
                return true;
            }
            if (C5706l.r(errorCode, companion.o())) {
                return attempts <= 1;
            }
            if (C5706l.r(errorCode, companion.l())) {
                return false;
            }
            if (C5706l.r(errorCode, companion.q())) {
                return attempts <= 1;
            }
            if (z.k.f44508a.b()) {
                Log.e("CXCP", "Unexpected CameraError: " + RetryingCameraStateOpenerImpl.INSTANCE);
            }
            return false;
        }

        public Companion() {
        }
    }

    public RetryingCameraStateOpenerImpl(CameraStateOpener cameraStateOpener, B.c cameraErrorListener, n cameraAvailabilityMonitor, z.w timeSource, s0 devicePolicyManager, j audioRestrictionController, h.CameraInteropConfig cameraInteropConfig, Threads threads) {
        kotlin.jvm.internal.p.i(cameraStateOpener, "cameraStateOpener");
        kotlin.jvm.internal.p.i(cameraErrorListener, "cameraErrorListener");
        kotlin.jvm.internal.p.i(cameraAvailabilityMonitor, "cameraAvailabilityMonitor");
        kotlin.jvm.internal.p.i(timeSource, "timeSource");
        kotlin.jvm.internal.p.i(devicePolicyManager, "devicePolicyManager");
        kotlin.jvm.internal.p.i(audioRestrictionController, "audioRestrictionController");
        kotlin.jvm.internal.p.i(threads, "threads");
        this.cameraStateOpener = cameraStateOpener;
        this.cameraErrorListener = cameraErrorListener;
        this.cameraAvailabilityMonitor = cameraAvailabilityMonitor;
        this.timeSource = timeSource;
        this.devicePolicyManager = devicePolicyManager;
        this.audioRestrictionController = audioRestrictionController;
        this.cameraInteropConfig = cameraInteropConfig;
        this.threads = threads;
    }

    @Override // x.G0
    public void c() {
        this.cameraStateOpener.c();
    }

    @Override // x.G0
    public AwaitOpenCameraResult e(String cameraId, W camera2DeviceCloser) {
        kotlin.jvm.internal.p.i(cameraId, "cameraId");
        kotlin.jvm.internal.p.i(camera2DeviceCloser, "camera2DeviceCloser");
        if (z.k.f44508a.a()) {
            Log.d("CXCP", this + "#openAndAwaitCameraWithRetry(" + ((Object) C5708n.f(cameraId)) + ')');
        }
        return (AwaitOpenCameraResult) C1056g.e(this.threads.getBlockingDispatcher(), new RetryingCameraStateOpenerImpl$openAndAwaitCameraWithRetry$2(this, cameraId, camera2DeviceCloser, null));
    }

    /* JADX WARN: Code restructure failed: missing block: B:67:0x024e, code lost:
    
        if (r6 == r4) goto L68;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0127 A[Catch: all -> 0x005d, TRY_ENTER, TryCatch #2 {all -> 0x005d, blocks: (B:14:0x004d, B:69:0x0251, B:71:0x0259, B:73:0x0261, B:35:0x010d, B:40:0x0127, B:42:0x012d, B:44:0x0135, B:47:0x013e, B:49:0x0160, B:52:0x016c, B:54:0x0178, B:58:0x0182, B:60:0x0191, B:62:0x0199, B:66:0x0224, B:22:0x0083), top: B:85:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0191 A[Catch: all -> 0x005d, TryCatch #2 {all -> 0x005d, blocks: (B:14:0x004d, B:69:0x0251, B:71:0x0259, B:73:0x0261, B:35:0x010d, B:40:0x0127, B:42:0x012d, B:44:0x0135, B:47:0x013e, B:49:0x0160, B:52:0x016c, B:54:0x0178, B:58:0x0182, B:60:0x0191, B:62:0x0199, B:66:0x0224, B:22:0x0083), top: B:85:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.AutoCloseable] */
    /* JADX WARN: Type inference failed for: r5v18 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:67:0x024e -> B:16:0x0053). Please report as a decompilation issue!!! */
    @Override // x.G0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object f(java.lang.String r32, x.W r33, p9.InterfaceC5074l<? super Y8.t, java.lang.Boolean> r34, e9.InterfaceC4014c<? super x.OpenCameraResult> r35) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 653
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.pipe.compat.RetryingCameraStateOpenerImpl.f(java.lang.String, x.W, p9.l, e9.c):java.lang.Object");
    }
}
