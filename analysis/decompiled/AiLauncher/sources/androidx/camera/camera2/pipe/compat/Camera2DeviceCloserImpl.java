package androidx.camera.camera2.pipe.compat;

import Z8.C1172u;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraDevice;
import android.os.Trace;
import android.util.Log;
import android.view.Surface;
import androidx.camera.camera2.pipe.compat.o;
import androidx.camera.camera2.pipe.core.Threads;
import com.autonavi.aps.amapapi.config.Const;
import java.util.concurrent.CountDownLatch;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Ref$BooleanRef;
import s.C5423E;
import w.C5708n;
import x.AwaitOpenCameraResult;
import x.C5810d0;
import x.G0;
import x.W;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0001\u0018\u0000 &2\u00020\u0001:\u0001\u0016B!\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJC\u0010\u0016\u001a\u00020\u00152\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0016\u0010\u0017JE\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00182\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\u001b\u001a\u00020\u00152\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001d\u0010\u001eR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u001f\u001a\u0004\b \u0010!R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%¨\u0006'"}, d2 = {"Landroidx/camera/camera2/pipe/compat/Camera2DeviceCloserImpl;", "Lx/W;", "Landroidx/camera/camera2/pipe/core/Threads;", "threads", "Lx/d0;", "camera2Quirks", "Lx/G0;", "retryingCameraStateOpener", "<init>", "(Landroidx/camera/camera2/pipe/core/Threads;Lx/d0;Lx/G0;)V", "Landroidx/camera/camera2/pipe/compat/p;", "cameraDeviceWrapper", "Landroid/hardware/camera2/CameraDevice;", "cameraDevice", "Landroidx/camera/camera2/pipe/compat/AndroidCameraState;", "androidCameraState", "Landroidx/camera/camera2/pipe/compat/j;", "audioRestrictionController", "", "shouldReopenCamera", "shouldCreateEmptyCaptureSession", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroidx/camera/camera2/pipe/compat/p;Landroid/hardware/camera2/CameraDevice;Landroidx/camera/camera2/pipe/compat/AndroidCameraState;Landroidx/camera/camera2/pipe/compat/j;ZZ)V", "Lkotlin/Pair;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Landroidx/camera/camera2/pipe/compat/p;Landroid/hardware/camera2/CameraDevice;Landroidx/camera/camera2/pipe/compat/AndroidCameraState;ZZ)Lkotlin/Pair;", "f", "(Landroid/hardware/camera2/CameraDevice;Landroidx/camera/camera2/pipe/compat/AndroidCameraState;)V", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Landroidx/camera/camera2/pipe/compat/p;)V", "Landroidx/camera/camera2/pipe/core/Threads;", "getThreads", "()Landroidx/camera/camera2/pipe/core/Threads;", Const.INTENT_KEY_PKGNAME, "Lx/d0;", "c", "Lx/G0;", Const.INTENT_KEY_UMID, "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class Camera2DeviceCloserImpl implements W {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Threads threads;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final C5810d0 camera2Quirks;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final G0 retryingCameraStateOpener;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0006J\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u0006J\u000f\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u0006¨\u0006\u000f"}, d2 = {"androidx/camera/camera2/pipe/compat/Camera2DeviceCloserImpl$b", "Landroidx/camera/camera2/pipe/compat/o$a;", "Landroidx/camera/camera2/pipe/compat/o;", "session", "LY8/t;", "e", "(Landroidx/camera/camera2/pipe/compat/o;)V", "k", Const.INTENT_KEY_UMID, "c", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "()V", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class b implements o.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CountDownLatch f10391a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Oa.a f10392b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Surface f10393c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ SurfaceTexture f10394d;

        public b(CountDownLatch countDownLatch, Oa.a aVar, Surface surface, SurfaceTexture surfaceTexture) {
            this.f10391a = countDownLatch;
            this.f10392b = aVar;
            this.f10393c = surface;
            this.f10394d = surfaceTexture;
        }

        @Override // x.I0
        public void a() {
        }

        @Override // androidx.camera.camera2.pipe.compat.o.a
        public void c(o session) {
            kotlin.jvm.internal.p.i(session, "session");
        }

        @Override // androidx.camera.camera2.pipe.compat.o.a
        public void d(o session) {
            kotlin.jvm.internal.p.i(session, "session");
            if (z.k.f44508a.a()) {
                Log.d("CXCP", "Empty capture session configure failed");
            }
            if (this.f10392b.a(false, true)) {
                this.f10393c.release();
                this.f10394d.release();
            }
            this.f10391a.countDown();
        }

        @Override // androidx.camera.camera2.pipe.compat.o.a
        public void e(o session) throws Exception {
            kotlin.jvm.internal.p.i(session, "session");
            if (z.k.f44508a.a()) {
                Log.d("CXCP", "Empty capture session configured. Closing it");
            }
            C5423E.a(session);
            this.f10391a.countDown();
        }

        @Override // x.I0
        public void h() {
        }

        @Override // androidx.camera.camera2.pipe.compat.o.a
        public void i(o session) {
            kotlin.jvm.internal.p.i(session, "session");
        }

        @Override // androidx.camera.camera2.pipe.compat.o.a
        public void j(o session) {
            kotlin.jvm.internal.p.i(session, "session");
        }

        @Override // androidx.camera.camera2.pipe.compat.o.a
        public void k(o session) {
            kotlin.jvm.internal.p.i(session, "session");
            if (z.k.f44508a.a()) {
                Log.d("CXCP", "Empty capture session closed");
            }
            if (this.f10392b.a(false, true)) {
                this.f10393c.release();
                this.f10394d.release();
            }
        }
    }

    public Camera2DeviceCloserImpl(Threads threads, C5810d0 camera2Quirks, G0 retryingCameraStateOpener) {
        kotlin.jvm.internal.p.i(threads, "threads");
        kotlin.jvm.internal.p.i(camera2Quirks, "camera2Quirks");
        kotlin.jvm.internal.p.i(retryingCameraStateOpener, "retryingCameraStateOpener");
        this.threads = threads;
        this.camera2Quirks = camera2Quirks;
        this.retryingCameraStateOpener = retryingCameraStateOpener;
    }

    @Override // x.W
    public void a(p cameraDeviceWrapper, CameraDevice cameraDevice, AndroidCameraState androidCameraState, j audioRestrictionController, boolean shouldReopenCamera, boolean shouldCreateEmptyCaptureSession) {
        kotlin.jvm.internal.p.i(androidCameraState, "androidCameraState");
        kotlin.jvm.internal.p.i(audioRestrictionController, "audioRestrictionController");
        CameraDevice cameraDevice2 = cameraDeviceWrapper != null ? (CameraDevice) cameraDeviceWrapper.R0(kotlin.jvm.internal.t.b(CameraDevice.class)) : null;
        if (cameraDevice2 == null) {
            if (cameraDevice != null) {
                f(cameraDevice, androidCameraState);
                return;
            }
            return;
        }
        C5708n.Companion companion = C5708n.INSTANCE;
        String id = cameraDevice2.getId();
        kotlin.jvm.internal.p.h(id, "getId(...)");
        String strB = C5708n.b(id);
        if (cameraDevice != null && !kotlin.jvm.internal.p.d(strB, cameraDevice.getId())) {
            throw new IllegalStateException(("Unwrapped camera device has camera ID " + strB + ", but the wrapped camera device has camera ID " + cameraDevice.getId() + '!').toString());
        }
        audioRestrictionController.c(cameraDeviceWrapper);
        CameraDevice cameraDevice3 = cameraDevice2;
        Pair<p, AndroidCameraState> pairH = h(cameraDeviceWrapper, cameraDevice3, androidCameraState, shouldReopenCamera, shouldCreateEmptyCaptureSession);
        if (pairH == null) {
            if (z.k.f44508a.b()) {
                Log.e("CXCP", "Failed to handle quirks before closing the camera device!");
            }
            cameraDeviceWrapper.G();
            cameraDeviceWrapper.k1();
            androidCameraState.m(cameraDevice3);
            return;
        }
        p pVarA = pairH.a();
        AndroidCameraState androidCameraStateB = pairH.b();
        Object objR0 = pVarA.R0(kotlin.jvm.internal.t.b(CameraDevice.class));
        if (objR0 == null) {
            throw new IllegalStateException("Required value was null.");
        }
        cameraDeviceWrapper.G();
        f((CameraDevice) objR0, androidCameraStateB);
        cameraDeviceWrapper.k1();
        if (shouldReopenCamera) {
            androidCameraState.m(cameraDevice3);
        }
    }

    public final void f(CameraDevice cameraDevice, AndroidCameraState androidCameraState) {
        String id = cameraDevice.getId();
        kotlin.jvm.internal.p.h(id, "getId(...)");
        z.k kVar = z.k.f44508a;
        if (kVar.a()) {
            Log.d("CXCP", "closeCameraDevice(" + id + ')');
        }
        Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
        if (((Y8.t) this.threads.n(7000L, new Camera2DeviceCloserImpl$closeCameraDevice$2(cameraDevice, ref$BooleanRef, null))) == null && kVar.b()) {
            Log.e("CXCP", "Failed to close CameraDevice(" + id + ") after 7000ms. The camera is likely in a bad state.");
        }
        C5708n.Companion companion = C5708n.INSTANCE;
        String id2 = cameraDevice.getId();
        kotlin.jvm.internal.p.h(id2, "getId(...)");
        String strB = C5708n.b(id2);
        if (this.camera2Quirks.e(strB) && ref$BooleanRef.f34815a) {
            if (kVar.a()) {
                Log.d("CXCP", "Waiting for OnClosed from " + ((Object) C5708n.f(strB)));
            }
            if (androidCameraState.d(2000L)) {
                if (kVar.a()) {
                    Log.d("CXCP", "Received OnClosed for " + ((Object) C5708n.f(strB)));
                    return;
                }
                return;
            }
            if (kVar.d()) {
                Log.w("CXCP", "Failed to close " + ((Object) C5708n.f(strB)) + " after 2000ms!");
            }
        }
    }

    public final void g(p cameraDeviceWrapper) throws InterruptedException {
        SurfaceTexture surfaceTexture = new SurfaceTexture(0);
        surfaceTexture.setDefaultBufferSize(640, 480);
        Surface surface = new Surface(surfaceTexture);
        Oa.a aVarA = Oa.b.a(false);
        CountDownLatch countDownLatch = new CountDownLatch(1);
        if (cameraDeviceWrapper.N0(C1172u.e(surface), new b(countDownLatch, aVarA, surface, surfaceTexture))) {
            countDownLatch.await();
            return;
        }
        if (z.k.f44508a.b()) {
            Log.e("CXCP", "Failed to create a blank capture session! Surfaces may not be disconnected properly.");
        }
        if (aVarA.a(false, true)) {
            surface.release();
            surfaceTexture.release();
        }
    }

    public final Pair<p, AndroidCameraState> h(p cameraDeviceWrapper, CameraDevice cameraDevice, AndroidCameraState androidCameraState, boolean shouldReopenCamera, boolean shouldCreateEmptyCaptureSession) {
        AwaitOpenCameraResult awaitOpenCameraResult;
        z.k kVar = z.k.f44508a;
        if (kVar.a()) {
            Log.d("CXCP", "handleQuirksBeforeClosing(" + cameraDevice + ')');
        }
        String cameraId = cameraDeviceWrapper.getCameraId();
        if (shouldReopenCamera) {
            z.h hVar = z.h.f44503a;
            try {
                Trace.beginSection("Camera2DeviceCloserImpl#reopenCameraDevice");
                if (kVar.a()) {
                    Log.d("CXCP", "Reopening camera device");
                }
                f(cameraDevice, androidCameraState);
                awaitOpenCameraResult = this.retryingCameraStateOpener.e(cameraId, this);
            } finally {
            }
        } else {
            awaitOpenCameraResult = new AwaitOpenCameraResult(cameraDeviceWrapper, androidCameraState);
        }
        if (awaitOpenCameraResult.getCameraDeviceWrapper() == null || awaitOpenCameraResult.getAndroidCameraState() == null) {
            if (!kVar.b()) {
                return null;
            }
            Log.e("CXCP", "Failed to retain an opened camera device!");
            return null;
        }
        if (shouldCreateEmptyCaptureSession) {
            z.h hVar2 = z.h.f44503a;
            try {
                Trace.beginSection("Camera2DeviceCloserImpl#createCaptureSession");
                if (kVar.a()) {
                    Log.d("CXCP", "Creating an empty capture session before closing " + ((Object) C5708n.f(cameraId)));
                }
                g(awaitOpenCameraResult.getCameraDeviceWrapper());
                if (kVar.a()) {
                    Log.d("CXCP", "Created an empty capture session.");
                }
                Y8.t tVar = Y8.t.f7040a;
            } finally {
            }
        }
        return new Pair<>(awaitOpenCameraResult.getCameraDeviceWrapper(), awaitOpenCameraResult.getAndroidCameraState());
    }
}
