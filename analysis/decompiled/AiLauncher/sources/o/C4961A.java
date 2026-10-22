package o;

import androidx.camera.camera2.pipe.CameraGraph;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import w.AbstractC5689A;
import w.InterfaceC5690B;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\n\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\n\u0010\bJ\u000f\u0010\u000b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\bJ\u0017\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0010R\"\u0010\u0017\u001a\u00020\u00118\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u0007\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"Lo/A;", "Lw/B;", "Lo/m;", "cameraStateAdapter", "<init>", "(Lo/m;)V", "LY8/t;", Const.INTENT_KEY_PKGNAME, "()V", "e", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_UMID, "Lw/A$a;", "graphStateError", "c", "(Lw/A$a;)V", "Lo/m;", "Landroidx/camera/camera2/pipe/CameraGraph;", "Landroidx/camera/camera2/pipe/CameraGraph;", "f", "()Landroidx/camera/camera2/pipe/CameraGraph;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Landroidx/camera/camera2/pipe/CameraGraph;)V", "cameraGraph", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: o.A, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C4961A implements InterfaceC5690B {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final C4981m cameraStateAdapter;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public CameraGraph cameraGraph;

    public C4961A(C4981m cameraStateAdapter) {
        kotlin.jvm.internal.p.i(cameraStateAdapter, "cameraStateAdapter");
        this.cameraStateAdapter = cameraStateAdapter;
    }

    @Override // w.InterfaceC5690B
    public void a() {
        this.cameraStateAdapter.g(f(), AbstractC5689A.e.f42889b);
    }

    @Override // w.InterfaceC5690B
    public void b() {
        this.cameraStateAdapter.g(f(), AbstractC5689A.c.f42887b);
    }

    @Override // w.InterfaceC5690B
    public void c(AbstractC5689A.a graphStateError) {
        kotlin.jvm.internal.p.i(graphStateError, "graphStateError");
        this.cameraStateAdapter.g(f(), graphStateError);
    }

    @Override // w.InterfaceC5690B
    public void d() {
        this.cameraStateAdapter.g(f(), AbstractC5689A.d.f42888b);
    }

    @Override // w.InterfaceC5690B
    public void e() {
        this.cameraStateAdapter.g(f(), AbstractC5689A.b.f42886b);
    }

    public final CameraGraph f() {
        CameraGraph cameraGraph = this.cameraGraph;
        if (cameraGraph != null) {
            return cameraGraph;
        }
        kotlin.jvm.internal.p.A("cameraGraph");
        return null;
    }

    public final void g(CameraGraph cameraGraph) {
        kotlin.jvm.internal.p.i(cameraGraph, "<set-?>");
        this.cameraGraph = cameraGraph;
    }
}
