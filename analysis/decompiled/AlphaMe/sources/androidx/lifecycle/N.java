package androidx.lifecycle;

/* loaded from: classes.dex */
public final class N extends O implements E {

    /* renamed from: e, reason: collision with root package name */
    public final G f3882e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ P f3883f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public N(P p4, G g4, V v4) {
        super(p4, v4);
        this.f3883f = p4;
        this.f3882e = g4;
    }

    @Override // androidx.lifecycle.E
    public final void a(G g4, EnumC0326x enumC0326x) {
        G g5 = this.f3882e;
        EnumC0327y enumC0327y = ((I) g5.getLifecycle()).f3871d;
        if (enumC0327y != EnumC0327y.f3983a) {
            EnumC0327y enumC0327y2 = null;
            while (enumC0327y2 != enumC0327y) {
                b(e());
                enumC0327y2 = enumC0327y;
                enumC0327y = ((I) g5.getLifecycle()).f3871d;
            }
            return;
        }
        P p4 = this.f3883f;
        p4.getClass();
        P.a("removeObserver");
        O o4 = (O) p4.f3890b.c(this.f3884a);
        if (o4 == null) {
            return;
        }
        o4.c();
        o4.b(false);
    }

    @Override // androidx.lifecycle.O
    public final void c() {
        this.f3882e.getLifecycle().b(this);
    }

    @Override // androidx.lifecycle.O
    public final boolean d(G g4) {
        return this.f3882e == g4;
    }

    @Override // androidx.lifecycle.O
    public final boolean e() {
        return ((I) this.f3882e.getLifecycle()).f3871d.a(EnumC0327y.f3986d);
    }
}
