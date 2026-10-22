package androidx.camera.camera2.pipe.compat;

import androidx.camera.camera2.pipe.compat.q;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\bH\u0016¢\u0006\u0004\b\r\u0010\fJ\u0017\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000e\u0010\nJ\u0017\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000f\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u0010¨\u0006\u0011"}, d2 = {"Landroidx/camera/camera2/pipe/compat/u;", "Landroidx/camera/camera2/pipe/compat/q$a;", "Landroidx/camera/camera2/pipe/compat/CaptureSessionState;", "captureSessionState", "<init>", "(Landroidx/camera/camera2/pipe/compat/CaptureSessionState;)V", "Landroidx/camera/camera2/pipe/compat/q;", "session", "LY8/t;", "f", "(Landroidx/camera/camera2/pipe/compat/q;)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "()V", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_BACKGROUND_COMMAND, "Landroidx/camera/camera2/pipe/compat/CaptureSessionState;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class u implements q.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final CaptureSessionState captureSessionState;

    public u(CaptureSessionState captureSessionState) {
        kotlin.jvm.internal.p.i(captureSessionState, "captureSessionState");
        this.captureSessionState = captureSessionState;
    }

    @Override // x.I0
    public void a() {
        this.captureSessionState.a();
    }

    @Override // androidx.camera.camera2.pipe.compat.q.a
    public void b(q session) {
        kotlin.jvm.internal.p.i(session, "session");
        this.captureSessionState.d(session);
    }

    @Override // androidx.camera.camera2.pipe.compat.q.a
    public void f(q session) {
        kotlin.jvm.internal.p.i(session, "session");
        this.captureSessionState.e(session);
    }

    @Override // androidx.camera.camera2.pipe.compat.q.a
    public void g(q session) {
        kotlin.jvm.internal.p.i(session, "session");
        this.captureSessionState.k(session);
    }

    @Override // x.I0
    public void h() {
        this.captureSessionState.h();
    }
}
