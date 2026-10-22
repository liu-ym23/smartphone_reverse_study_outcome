package androidx.lifecycle;

import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b1 {

    /* renamed from: b, reason: collision with root package name */
    public static final f7.f f1361b = new f7.f(16);

    /* renamed from: a, reason: collision with root package name */
    public Object f1362a;

    public b1(c1 c1Var, a1 a1Var, h4.b bVar) {
        c1Var.getClass();
        bVar.getClass();
        p5.i iVar = new p5.i();
        iVar.f9730c = c1Var;
        iVar.f9731f = a1Var;
        iVar.f9732g = bVar;
        iVar.f9733h = new j4.b();
        VarHandle.storeStoreFence();
        this.f1362a = iVar;
    }

    public y0 a(yb.e eVar) {
        p5.i iVar = (p5.i) this.f1362a;
        String strB = eVar.b();
        if (strB != null) {
            return iVar.y(eVar, "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(strB));
        }
        g5.f.s("Local and anonymous classes can not be ViewModels");
        return null;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b1(c1 c1Var, a1 a1Var) {
        this(c1Var, a1Var, h4.a.f5289b);
        c1Var.getClass();
    }
}
