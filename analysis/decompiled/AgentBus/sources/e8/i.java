package e8;

import d7.r;
import i8.a0;
import java.io.IOException;
import q7.w;
import q7.x;
import w7.t;

/* loaded from: classes.dex */
public final class i extends c8.h {

    /* renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ t[] f3149h;

    /* renamed from: f, reason: collision with root package name */
    public c8.k f3150f;

    /* renamed from: g, reason: collision with root package name */
    public final u9.i f3151g;

    static {
        x xVar = w.f8821a;
        f3149h = new t[]{xVar.f(new q7.p(xVar.b(i.class), "customizer", "getCustomizer()Lorg/jetbrains/kotlin/builtins/jvm/JvmBuiltInsCustomizer;"))};
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(u9.k kVar) throws IOException {
        super(kVar);
        m.x.t(1, "kind");
        this.f3151g = new u9.i(kVar, new a8.e(3, this, kVar));
        int iD = n.f.d(1);
        if (iD == 1) {
            c();
        } else {
            if (iD != 2) {
                return;
            }
            c();
        }
    }

    public final o J() {
        return (o) n7.b.q(this.f3151g, f3149h[0]);
    }

    @Override // c8.h
    public final h8.b d() {
        return J();
    }

    @Override // c8.h
    public final Iterable l() {
        Iterable iterableL = super.l();
        a0 a0VarK = k();
        q7.k.d(a0VarK, "builtInsModule");
        return r.b1(iterableL, new g(this.f2003d, a0VarK));
    }

    @Override // c8.h
    public final h8.d p() {
        return J();
    }
}
