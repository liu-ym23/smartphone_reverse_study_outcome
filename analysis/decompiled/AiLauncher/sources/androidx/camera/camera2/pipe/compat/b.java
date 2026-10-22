package androidx.camera.camera2.pipe.compat;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraConstrainedHighSpeedCaptureSession;
import android.os.Handler;
import androidx.camera.camera2.pipe.compat.o;
import androidx.camera.camera2.pipe.f;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import kotlin.Metadata;
import x.C5805b;
import x.C5807c;
import x.I0;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0015\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0016\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0017\u0010\u0014J\u0017\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0018\u0010\u0014J\u0017\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0019\u0010\u0014J\u001f\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001d\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0012H\u0002¢\u0006\u0004\b \u0010\u001fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\"R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010#R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010$R\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u001c\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u001c\u0010,\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010)¨\u0006-"}, d2 = {"Landroidx/camera/camera2/pipe/compat/b;", "Landroid/hardware/camera2/CameraCaptureSession$StateCallback;", "Landroidx/camera/camera2/pipe/compat/p;", Parameters.DEVICE, "Landroidx/camera/camera2/pipe/compat/o$a;", "stateCallback", "Lx/I0;", "lastStateCallback", "LB/c;", "cameraErrorListener", "Landroidx/camera/camera2/pipe/f$b;", "interopCaptureSessionListener", "Landroid/os/Handler;", "callbackHandler", "<init>", "(Landroidx/camera/camera2/pipe/compat/p;Landroidx/camera/camera2/pipe/compat/o$a;Lx/I0;LB/c;Landroidx/camera/camera2/pipe/f$b;Landroid/os/Handler;)V", "Landroid/hardware/camera2/CameraCaptureSession;", "session", "LY8/t;", "onConfigured", "(Landroid/hardware/camera2/CameraCaptureSession;)V", "onConfigureFailed", "onReady", "onActive", "onClosed", "onCaptureQueueEmpty", "Landroidx/camera/camera2/pipe/compat/o;", "c", "(Landroid/hardware/camera2/CameraCaptureSession;LB/c;)Landroidx/camera/camera2/pipe/compat/o;", Const.INTENT_KEY_UMID, Const.INTENT_KEY_PKGNAME, "()V", Const.INTENT_KEY_APIKEY, "Landroidx/camera/camera2/pipe/compat/p;", "Landroidx/camera/camera2/pipe/compat/o$a;", "LB/c;", "Landroidx/camera/camera2/pipe/f$b;", "e", "Landroid/os/Handler;", "LOa/e;", "f", "LOa/e;", "_lastStateCallback", Const.INTENT_KEY_BACKGROUND_COMMAND, "captureSession", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class b extends CameraCaptureSession.StateCallback {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final p device;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final o.a stateCallback;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final B.c cameraErrorListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final f.b interopCaptureSessionListener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final Handler callbackHandler;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final Oa.e<I0> _lastStateCallback;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public final Oa.e<o> captureSession;

    public b(p device, o.a stateCallback, I0 i02, B.c cameraErrorListener, f.b bVar, Handler callbackHandler) {
        kotlin.jvm.internal.p.i(device, "device");
        kotlin.jvm.internal.p.i(stateCallback, "stateCallback");
        kotlin.jvm.internal.p.i(cameraErrorListener, "cameraErrorListener");
        kotlin.jvm.internal.p.i(callbackHandler, "callbackHandler");
        this.device = device;
        this.stateCallback = stateCallback;
        this.cameraErrorListener = cameraErrorListener;
        this.interopCaptureSessionListener = bVar;
        this.callbackHandler = callbackHandler;
        this._lastStateCallback = Oa.b.g(i02);
        this.captureSession = Oa.b.g(null);
    }

    public final void a() {
        I0 i0B = this._lastStateCallback.b(null);
        if (i0B != null) {
            i0B.a();
        }
    }

    public final void b() {
        a();
        this.stateCallback.a();
    }

    public final o c(CameraCaptureSession session, B.c cameraErrorListener) {
        o oVarC = this.captureSession.c();
        if (oVarC != null) {
            return oVarC;
        }
        o oVarD = d(session, cameraErrorListener);
        if (this.captureSession.a(null, oVarD)) {
            return oVarD;
        }
        o oVarC2 = this.captureSession.c();
        kotlin.jvm.internal.p.f(oVarC2);
        return oVarC2;
    }

    public final o d(CameraCaptureSession session, B.c cameraErrorListener) {
        return session instanceof CameraConstrainedHighSpeedCaptureSession ? new C5807c(this.device, (CameraConstrainedHighSpeedCaptureSession) session, cameraErrorListener, this.callbackHandler) : new C5805b(this.device, session, cameraErrorListener, this.callbackHandler);
    }

    @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
    public void onActive(CameraCaptureSession session) {
        kotlin.jvm.internal.p.i(session, "session");
        o oVarC = c(session, this.cameraErrorListener);
        this.stateCallback.i(c(session, this.cameraErrorListener));
        f.b bVar = this.interopCaptureSessionListener;
        if (bVar != null) {
            bVar.a(this.device.g(), oVarC.getId());
        }
    }

    @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
    public void onCaptureQueueEmpty(CameraCaptureSession session) {
        kotlin.jvm.internal.p.i(session, "session");
        o oVarC = c(session, this.cameraErrorListener);
        this.stateCallback.j(c(session, this.cameraErrorListener));
        f.b bVar = this.interopCaptureSessionListener;
        if (bVar != null) {
            bVar.c(this.device.g(), oVarC.getId());
        }
    }

    @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
    public void onClosed(CameraCaptureSession session) {
        kotlin.jvm.internal.p.i(session, "session");
        o oVarC = c(session, this.cameraErrorListener);
        this.stateCallback.k(c(session, this.cameraErrorListener));
        b();
        f.b bVar = this.interopCaptureSessionListener;
        if (bVar != null) {
            bVar.e(this.device.g(), oVarC.getId());
        }
    }

    @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
    public void onConfigureFailed(CameraCaptureSession session) {
        kotlin.jvm.internal.p.i(session, "session");
        o oVarC = c(session, this.cameraErrorListener);
        this.stateCallback.d(oVarC);
        b();
        f.b bVar = this.interopCaptureSessionListener;
        if (bVar != null) {
            bVar.b(this.device.g(), oVarC.getId());
        }
    }

    @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
    public void onConfigured(CameraCaptureSession session) {
        kotlin.jvm.internal.p.i(session, "session");
        o oVarC = c(session, this.cameraErrorListener);
        this.stateCallback.e(oVarC);
        a();
        f.b bVar = this.interopCaptureSessionListener;
        if (bVar != null) {
            bVar.f(this.device.g(), oVarC.getId());
        }
    }

    @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
    public void onReady(CameraCaptureSession session) {
        kotlin.jvm.internal.p.i(session, "session");
        o oVarC = c(session, this.cameraErrorListener);
        this.stateCallback.c(c(session, this.cameraErrorListener));
        f.b bVar = this.interopCaptureSessionListener;
        if (bVar != null) {
            bVar.d(this.device.g(), oVarC.getId());
        }
    }
}
