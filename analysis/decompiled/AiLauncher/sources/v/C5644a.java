package v;

import androidx.camera.camera2.adapter.CoroutineAdaptersKt;
import androidx.camera.camera2.impl.UseCaseCameraRequestControl;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import g3.InterfaceFutureC4095a;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import p.InterfaceC5024f;
import t.N;
import t.j0;
import t.y0;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 %2\u00020\u0001:\u0001\u0011B!\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0017¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000f2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0013\u001a\u00020\r¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000f¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000f2\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u0019\u0010\u001aR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u001bR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001a\u0010\u0007\u001a\u00020\u00068\u0001X\u0080\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0018\u0010#\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\"R(\u0010(\u001a\u0004\u0018\u00010!2\b\u0010$\u001a\u0004\u0018\u00010!8W@WX\u0096\u000e¢\u0006\f\u001a\u0004\b%\u0010&\"\u0004\b\u001c\u0010'¨\u0006)"}, d2 = {"Lv/a;", "Lt/j0;", "Lp/f;", "compat", "Lt/y0;", "threads", "Lt/N;", "requestListener", "<init>", "(Lp/f;Lt/y0;Lt/N;)V", "LY8/t;", "reset", "()V", "Lv/f;", "bundle", "Lg3/a;", "Ljava/lang/Void;", Const.INTENT_KEY_APIKEY, "(Lv/f;)Lg3/a;", Const.INTENT_KEY_UMID, "()Lv/f;", "c", "()Lg3/a;", "", "tag", "f", "(Ljava/lang/String;)Lg3/a;", "Lp/f;", Const.INTENT_KEY_PKGNAME, "Lt/y0;", "Lt/N;", "getRequestListener$camera_camera2", "()Lt/N;", "Landroidx/camera/camera2/impl/UseCaseCameraRequestControl;", "Landroidx/camera/camera2/impl/UseCaseCameraRequestControl;", "_useCaseCameraRequestControl", UxipConstants.f30680s, "e", "()Landroidx/camera/camera2/impl/UseCaseCameraRequestControl;", "(Landroidx/camera/camera2/impl/UseCaseCameraRequestControl;)V", "requestControl", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: v.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C5644a implements j0 {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC5024f compat;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final y0 threads;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final N requestListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public UseCaseCameraRequestControl _useCaseCameraRequestControl;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lv/a$a;", "", "<init>", "()V", "Lp/f;", "compat", "Lt/y0;", "threads", "Lt/N;", "requestListener", "Lv/a;", Const.INTENT_KEY_APIKEY, "(Lp/f;Lt/y0;Lt/N;)Lv/a;", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: v.a$a, reason: collision with other inner class name and from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final C5644a a(InterfaceC5024f compat, y0 threads, N requestListener) {
            p.i(compat, "compat");
            p.i(threads, "threads");
            p.i(requestListener, "requestListener");
            return new C5644a(compat, threads, requestListener, null);
        }

        public Companion() {
        }
    }

    public /* synthetic */ C5644a(InterfaceC5024f interfaceC5024f, y0 y0Var, N n10, i iVar) {
        this(interfaceC5024f, y0Var, n10);
    }

    public final InterfaceFutureC4095a<Void> a(C5649f bundle) {
        p.i(bundle, "bundle");
        this.compat.b(bundle);
        return f("addCaptureRequestOptions");
    }

    @Override // t.j0
    public void b(UseCaseCameraRequestControl useCaseCameraRequestControl) {
        this._useCaseCameraRequestControl = useCaseCameraRequestControl;
        if (useCaseCameraRequestControl != null) {
            this.requestListener.F(this.compat);
            this.requestListener.s(this.compat, this.threads.getSequentialExecutor());
            this.compat.J(useCaseCameraRequestControl, false);
        }
    }

    public final InterfaceFutureC4095a<Void> c() {
        this.compat.n();
        return f("clearCaptureRequestOptions");
    }

    public final C5649f d() {
        return this.compat.U();
    }

    /* renamed from: e, reason: from getter */
    public UseCaseCameraRequestControl get_useCaseCameraRequestControl() {
        return this._useCaseCameraRequestControl;
    }

    public final InterfaceFutureC4095a<Void> f(String tag) {
        InterfaceFutureC4095a<Void> interfaceFutureC4095aI = O.f.i(CoroutineAdaptersKt.g(InterfaceC5024f.e0(this.compat, get_useCaseCameraRequestControl(), false, 2, null), tag));
        p.h(interfaceFutureC4095aI, "nonCancellationPropagating(...)");
        return interfaceFutureC4095aI;
    }

    @Override // t.j0
    public void reset() {
        this.compat.l();
        this.requestListener.F(this.compat);
    }

    public C5644a(InterfaceC5024f interfaceC5024f, y0 y0Var, N n10) {
        this.compat = interfaceC5024f;
        this.threads = y0Var;
        this.requestListener = n10;
    }
}
