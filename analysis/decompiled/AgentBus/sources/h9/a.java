package h9;

import f8.q0;
import v9.m0;

/* loaded from: classes.dex */
public final class a implements w9.d {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f4228a;

    /* renamed from: b, reason: collision with root package name */
    public final f8.b f4229b;

    /* renamed from: c, reason: collision with root package name */
    public final f8.b f4230c;

    public a(f8.b bVar, f8.b bVar2, boolean z4) {
        this.f4228a = z4;
        this.f4229b = bVar;
        this.f4230c = bVar2;
    }

    @Override // w9.d
    public final boolean a(m0 m0Var, m0 m0Var2) {
        f8.b bVar = this.f4229b;
        q7.k.e(bVar, "$a");
        f8.b bVar2 = this.f4230c;
        q7.k.e(bVar2, "$b");
        q7.k.e(m0Var, "c1");
        q7.k.e(m0Var2, "c2");
        if (m0Var.equals(m0Var2)) {
            return true;
        }
        f8.g gVarC = m0Var.c();
        f8.g gVarC2 = m0Var2.c();
        if (!(gVarC instanceof q0) || !(gVarC2 instanceof q0)) {
            return false;
        }
        b bVar3 = new b(0, bVar, bVar2);
        return d.f4235a.d((q0) gVarC, (q0) gVarC2, this.f4228a, bVar3);
    }
}
