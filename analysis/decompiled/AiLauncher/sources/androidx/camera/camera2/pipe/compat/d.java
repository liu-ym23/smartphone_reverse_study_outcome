package androidx.camera.camera2.pipe.compat;

import android.hardware.camera2.CameraExtensionSession;
import androidx.camera.camera2.pipe.compat.q;
import androidx.camera.camera2.pipe.f;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import x.C5809d;
import x.I0;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0001\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0015\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0016\u0010\u0014J\u001f\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001a\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u001d\u0010\u001cR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001fR\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010 R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010!R\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u001c\u0010'\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u001c\u0010)\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010&¨\u0006*"}, d2 = {"Landroidx/camera/camera2/pipe/compat/d;", "Landroid/hardware/camera2/CameraExtensionSession$StateCallback;", "Landroidx/camera/camera2/pipe/compat/p;", Parameters.DEVICE, "Landroidx/camera/camera2/pipe/compat/q$a;", "stateCallback", "Lx/I0;", "lastStateCallback", "LB/c;", "cameraErrorListener", "Landroidx/camera/camera2/pipe/f$b;", "interopCaptureSessionListener", "Ljava/util/concurrent/Executor;", "callbackExecutor", "<init>", "(Landroidx/camera/camera2/pipe/compat/p;Landroidx/camera/camera2/pipe/compat/q$a;Lx/I0;LB/c;Landroidx/camera/camera2/pipe/f$b;Ljava/util/concurrent/Executor;)V", "Landroid/hardware/camera2/CameraExtensionSession;", "session", "LY8/t;", "onConfigured", "(Landroid/hardware/camera2/CameraExtensionSession;)V", "onConfigureFailed", "onClosed", "Landroidx/camera/camera2/pipe/compat/q;", "c", "(Landroid/hardware/camera2/CameraExtensionSession;LB/c;)Landroidx/camera/camera2/pipe/compat/q;", Const.INTENT_KEY_UMID, Const.INTENT_KEY_PKGNAME, "()V", Const.INTENT_KEY_APIKEY, "Landroidx/camera/camera2/pipe/compat/p;", "Landroidx/camera/camera2/pipe/compat/q$a;", "LB/c;", "Landroidx/camera/camera2/pipe/f$b;", "e", "Ljava/util/concurrent/Executor;", "LOa/e;", "f", "LOa/e;", "_lastStateCallback", Const.INTENT_KEY_BACKGROUND_COMMAND, "extensionSession", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class d extends CameraExtensionSession.StateCallback {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final p device;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final q.a stateCallback;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final B.c cameraErrorListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final f.b interopCaptureSessionListener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final Executor callbackExecutor;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final Oa.e<I0> _lastStateCallback;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public final Oa.e<q> extensionSession;

    public d(p device, q.a stateCallback, I0 i02, B.c cameraErrorListener, f.b bVar, Executor callbackExecutor) {
        kotlin.jvm.internal.p.i(device, "device");
        kotlin.jvm.internal.p.i(stateCallback, "stateCallback");
        kotlin.jvm.internal.p.i(cameraErrorListener, "cameraErrorListener");
        kotlin.jvm.internal.p.i(callbackExecutor, "callbackExecutor");
        this.device = device;
        this.stateCallback = stateCallback;
        this.cameraErrorListener = cameraErrorListener;
        this.interopCaptureSessionListener = bVar;
        this.callbackExecutor = callbackExecutor;
        this._lastStateCallback = Oa.b.g(i02);
        this.extensionSession = Oa.b.g(null);
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

    public final q c(CameraExtensionSession session, B.c cameraErrorListener) {
        q qVarC = this.extensionSession.c();
        if (qVarC != null) {
            return qVarC;
        }
        q qVarD = d(session, cameraErrorListener);
        if (this.extensionSession.a(null, qVarD)) {
            return qVarD;
        }
        q qVarC2 = this.extensionSession.c();
        kotlin.jvm.internal.p.f(qVarC2);
        return qVarC2;
    }

    public final q d(CameraExtensionSession session, B.c cameraErrorListener) {
        return new C5809d(this.device, session, cameraErrorListener, this.callbackExecutor);
    }

    @Override // android.hardware.camera2.CameraExtensionSession.StateCallback
    public void onClosed(CameraExtensionSession session) {
        kotlin.jvm.internal.p.i(session, "session");
        q qVarC = c(session, this.cameraErrorListener);
        this.stateCallback.g(c(session, this.cameraErrorListener));
        b();
        f.b bVar = this.interopCaptureSessionListener;
        if (bVar != null) {
            bVar.e(this.device.g(), qVarC.getId());
        }
    }

    @Override // android.hardware.camera2.CameraExtensionSession.StateCallback
    public void onConfigureFailed(CameraExtensionSession session) {
        kotlin.jvm.internal.p.i(session, "session");
        q qVarC = c(session, this.cameraErrorListener);
        this.stateCallback.b(qVarC);
        b();
        f.b bVar = this.interopCaptureSessionListener;
        if (bVar != null) {
            bVar.b(this.device.g(), qVarC.getId());
        }
    }

    @Override // android.hardware.camera2.CameraExtensionSession.StateCallback
    public void onConfigured(CameraExtensionSession session) {
        kotlin.jvm.internal.p.i(session, "session");
        q qVarC = c(session, this.cameraErrorListener);
        this.stateCallback.f(qVarC);
        a();
        f.b bVar = this.interopCaptureSessionListener;
        if (bVar != null) {
            bVar.f(this.device.g(), qVarC.getId());
        }
    }
}
