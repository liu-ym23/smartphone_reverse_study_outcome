package t;

import Z8.C1173v;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import androidx.camera.camera2.pipe.f;
import androidx.camera.core.impl.SessionConfig;
import com.autonavi.aps.amapapi.config.Const;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002\n\u000eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0012\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u0011R\u0011\u0010\u0015\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0014¨\u0006\u0016"}, d2 = {"Lt/s;", "", "<init>", "()V", "Landroidx/camera/core/impl/SessionConfig;", "sessionConfig", "LY8/t;", "c", "(Landroidx/camera/core/impl/SessionConfig;)V", "Lt/s$a;", Const.INTENT_KEY_APIKEY, "Lt/s$a;", "_deviceStateCallback", "Lt/s$b;", Const.INTENT_KEY_PKGNAME, "Lt/s$b;", "_sessionStateCallback", "()Lt/s$a;", "deviceStateCallback", "Landroidx/camera/camera2/pipe/f$b;", "()Landroidx/camera/camera2/pipe/f$b;", "sessionStateCallback", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: t.s, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C5491s {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final a _deviceStateCallback = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final b _sessionStateCallback = new b();

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\r\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000e\u0010\fJ\u001f\u0010\u0011\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\"\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00140\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u0015¨\u0006\u0017"}, d2 = {"Lt/s$a;", "Landroid/hardware/camera2/CameraDevice$StateCallback;", "<init>", "()V", "Landroidx/camera/core/impl/SessionConfig;", "sessionConfig", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroidx/camera/core/impl/SessionConfig;)V", "Landroid/hardware/camera2/CameraDevice;", "cameraDevice", "onOpened", "(Landroid/hardware/camera2/CameraDevice;)V", "onClosed", "onDisconnected", "", "errorCode", "onError", "(Landroid/hardware/camera2/CameraDevice;I)V", "LOa/e;", "", "LOa/e;", "callbacks", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: t.s$a */
    public static final class a extends CameraDevice.StateCallback {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public Oa.e<List<CameraDevice.StateCallback>> callbacks = Oa.b.g(C1173v.m());

        public final void a(SessionConfig sessionConfig) {
            kotlin.jvm.internal.p.i(sessionConfig, "sessionConfig");
            Oa.e<List<CameraDevice.StateCallback>> eVar = this.callbacks;
            List<CameraDevice.StateCallback> listC = sessionConfig.c();
            kotlin.jvm.internal.p.h(listC, "getDeviceStateCallbacks(...)");
            eVar.d(Z8.F.m1(listC));
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onClosed(CameraDevice cameraDevice) {
            kotlin.jvm.internal.p.i(cameraDevice, "cameraDevice");
            Iterator<CameraDevice.StateCallback> it = this.callbacks.c().iterator();
            while (it.hasNext()) {
                it.next().onClosed(cameraDevice);
            }
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onDisconnected(CameraDevice cameraDevice) {
            kotlin.jvm.internal.p.i(cameraDevice, "cameraDevice");
            Iterator<CameraDevice.StateCallback> it = this.callbacks.c().iterator();
            while (it.hasNext()) {
                it.next().onDisconnected(cameraDevice);
            }
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onError(CameraDevice cameraDevice, int errorCode) {
            kotlin.jvm.internal.p.i(cameraDevice, "cameraDevice");
            Iterator<CameraDevice.StateCallback> it = this.callbacks.c().iterator();
            while (it.hasNext()) {
                it.next().onError(cameraDevice, errorCode);
            }
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onOpened(CameraDevice cameraDevice) {
            kotlin.jvm.internal.p.i(cameraDevice, "cameraDevice");
            Iterator<CameraDevice.StateCallback> it = this.callbacks.c().iterator();
            while (it.hasNext()) {
                it.next().onOpened(cameraDevice);
            }
        }
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u000f\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000f\u0010\u000eJ\u001f\u0010\u0010\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0010\u0010\u000eJ\u001f\u0010\u0011\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0011\u0010\u000eJ\u001f\u0010\u0012\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0012\u0010\u000eJ\u001f\u0010\u0013\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0013\u0010\u000eR\u0014\u0010\u0016\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0015R\"\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00180\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u001a¨\u0006\u001c"}, d2 = {"Lt/s$b;", "Landroidx/camera/camera2/pipe/f$b;", "<init>", "()V", "Landroidx/camera/core/impl/SessionConfig;", "sessionConfig", "LY8/t;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Landroidx/camera/core/impl/SessionConfig;)V", "Lw/n;", "cameraId", "Landroidx/camera/camera2/pipe/f$a;", "captureSessionId", "f", "(Ljava/lang/String;I)V", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_UMID, Const.INTENT_KEY_APIKEY, "c", "e", "Lt/a0;", "Lt/a0;", "placeholderSession", "LOa/e;", "", "Landroid/hardware/camera2/CameraCaptureSession$StateCallback;", "LOa/e;", "callbacks", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: t.s$b */
    public static final class b implements f.b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final C5472a0 placeholderSession = new C5472a0();

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public Oa.e<List<CameraCaptureSession.StateCallback>> callbacks = Oa.b.g(C1173v.m());

        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J+\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006H\u0007¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lt/s$b$a;", "", "<init>", "()V", "Landroid/hardware/camera2/CameraCaptureSession;", "session", "LOa/e;", "", "Landroid/hardware/camera2/CameraCaptureSession$StateCallback;", "callbacks", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroid/hardware/camera2/CameraCaptureSession;LOa/e;)V", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* renamed from: t.s$b$a */
        public static final class a {

            /* renamed from: a, reason: collision with root package name */
            public static final a f41949a = new a();

            public static final void a(CameraCaptureSession session, Oa.e<List<CameraCaptureSession.StateCallback>> callbacks) {
                kotlin.jvm.internal.p.i(session, "session");
                kotlin.jvm.internal.p.i(callbacks, "callbacks");
                Iterator<CameraCaptureSession.StateCallback> it = callbacks.c().iterator();
                while (it.hasNext()) {
                    it.next().onCaptureQueueEmpty(session);
                }
            }
        }

        @Override // androidx.camera.camera2.pipe.f.b
        public void a(String cameraId, int captureSessionId) {
            kotlin.jvm.internal.p.i(cameraId, "cameraId");
            Iterator<CameraCaptureSession.StateCallback> it = this.callbacks.c().iterator();
            while (it.hasNext()) {
                it.next().onActive(this.placeholderSession);
            }
        }

        @Override // androidx.camera.camera2.pipe.f.b
        public void b(String cameraId, int captureSessionId) {
            kotlin.jvm.internal.p.i(cameraId, "cameraId");
            Iterator<CameraCaptureSession.StateCallback> it = this.callbacks.c().iterator();
            while (it.hasNext()) {
                it.next().onConfigureFailed(this.placeholderSession);
            }
        }

        @Override // androidx.camera.camera2.pipe.f.b
        public void c(String cameraId, int captureSessionId) {
            kotlin.jvm.internal.p.i(cameraId, "cameraId");
            a.a(this.placeholderSession, this.callbacks);
        }

        @Override // androidx.camera.camera2.pipe.f.b
        public void d(String cameraId, int captureSessionId) {
            kotlin.jvm.internal.p.i(cameraId, "cameraId");
            Iterator<CameraCaptureSession.StateCallback> it = this.callbacks.c().iterator();
            while (it.hasNext()) {
                it.next().onReady(this.placeholderSession);
            }
        }

        @Override // androidx.camera.camera2.pipe.f.b
        public void e(String cameraId, int captureSessionId) {
            kotlin.jvm.internal.p.i(cameraId, "cameraId");
            Iterator<CameraCaptureSession.StateCallback> it = this.callbacks.c().iterator();
            while (it.hasNext()) {
                it.next().onClosed(this.placeholderSession);
            }
        }

        @Override // androidx.camera.camera2.pipe.f.b
        public void f(String cameraId, int captureSessionId) {
            kotlin.jvm.internal.p.i(cameraId, "cameraId");
            Iterator<CameraCaptureSession.StateCallback> it = this.callbacks.c().iterator();
            while (it.hasNext()) {
                it.next().onConfigured(this.placeholderSession);
            }
        }

        public final void g(SessionConfig sessionConfig) {
            kotlin.jvm.internal.p.i(sessionConfig, "sessionConfig");
            Oa.e<List<CameraCaptureSession.StateCallback>> eVar = this.callbacks;
            List<CameraCaptureSession.StateCallback> listM = sessionConfig.m();
            kotlin.jvm.internal.p.h(listM, "getSessionStateCallbacks(...)");
            eVar.d(Z8.F.m1(listM));
        }
    }

    /* renamed from: a, reason: from getter */
    public final a get_deviceStateCallback() {
        return this._deviceStateCallback;
    }

    public final f.b b() {
        return this._sessionStateCallback;
    }

    public final void c(SessionConfig sessionConfig) {
        kotlin.jvm.internal.p.i(sessionConfig, "sessionConfig");
        this._deviceStateCallback.a(sessionConfig);
        this._sessionStateCallback.g(sessionConfig);
    }
}
