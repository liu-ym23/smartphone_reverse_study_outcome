package s0;

import j1.y;
import k.b0;
import k.h0;
import k.z;
import m4.u0;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final u0 f9168a;

    /* renamed from: b, reason: collision with root package name */
    public final y f9169b;

    /* renamed from: c, reason: collision with root package name */
    public final b0 f9170c;

    /* renamed from: d, reason: collision with root package name */
    public final b0 f9171d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f9172e;

    public f(u0 u0Var, y yVar) {
        this.f9168a = u0Var;
        this.f9169b = yVar;
        int i2 = h0.f5493a;
        this.f9170c = new b0();
        this.f9171d = new b0();
    }

    public final void a() {
        if (this.f9172e) {
            return;
        }
        j1.s sVar = new j1.s(0, this, f.class, "invalidateNodes", "invalidateNodes()V", 0, 2);
        z zVar = this.f9169b.f5391x0;
        if (zVar.f(sVar) < 0) {
            zVar.a(sVar);
        }
        this.f9172e = true;
    }
}
