package A2;

import android.content.Context;
import c2.C1489a;
import h3.C4142r;
import n3.InterfaceC4938b;

/* loaded from: classes2.dex */
public final class y5 implements l5 {

    /* renamed from: a, reason: collision with root package name */
    public InterfaceC4938b f1110a;

    /* renamed from: b, reason: collision with root package name */
    public final InterfaceC4938b f1111b;

    /* renamed from: c, reason: collision with root package name */
    public final n5 f1112c;

    public y5(Context context, n5 n5Var) {
        this.f1112c = n5Var;
        C1489a c1489a = C1489a.f15422g;
        e2.r.f(context);
        final b2.f fVarG = e2.r.c().g(c1489a);
        if (c1489a.a().contains(b2.b.b("json"))) {
            this.f1110a = new C4142r(new InterfaceC4938b() { // from class: A2.v5
                @Override // n3.InterfaceC4938b
                public final Object get() {
                    return fVarG.a("FIREBASE_ML_SDK", byte[].class, b2.b.b("json"), new b2.d() { // from class: A2.x5
                        @Override // b2.d
                        public final Object apply(Object obj) {
                            return (byte[]) obj;
                        }
                    });
                }
            });
        }
        this.f1111b = new C4142r(new InterfaceC4938b() { // from class: A2.w5
            @Override // n3.InterfaceC4938b
            public final Object get() {
                return fVarG.a("FIREBASE_ML_SDK", byte[].class, b2.b.b("proto"), new b2.d() { // from class: A2.u5
                    @Override // b2.d
                    public final Object apply(Object obj) {
                        return (byte[]) obj;
                    }
                });
            }
        });
    }

    public static b2.c b(n5 n5Var, k5 k5Var) {
        return b2.c.e(k5Var.c(n5Var.a(), false));
    }

    @Override // A2.l5
    public final void a(k5 k5Var) {
        if (this.f1112c.a() != 0) {
            ((b2.e) this.f1111b.get()).a(b(this.f1112c, k5Var));
            return;
        }
        InterfaceC4938b interfaceC4938b = this.f1110a;
        if (interfaceC4938b != null) {
            ((b2.e) interfaceC4938b.get()).a(b(this.f1112c, k5Var));
        }
    }
}
