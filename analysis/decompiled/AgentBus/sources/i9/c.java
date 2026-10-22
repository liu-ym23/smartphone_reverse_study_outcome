package i9;

import c8.h;
import d7.z;
import f8.g;
import java.util.Collection;
import java.util.List;
import q7.k;
import v9.p0;
import v9.v;
import w9.j;

/* loaded from: classes.dex */
public final class c implements b {

    /* renamed from: a, reason: collision with root package name */
    public final p0 f4911a;

    /* renamed from: b, reason: collision with root package name */
    public j f4912b;

    public c(p0 p0Var) {
        k.e(p0Var, "projection");
        this.f4911a = p0Var;
        p0Var.a();
    }

    @Override // v9.m0
    public final boolean a() {
        return false;
    }

    @Override // i9.b
    public final p0 b() {
        return this.f4911a;
    }

    @Override // v9.m0
    public final /* bridge */ /* synthetic */ g c() {
        return null;
    }

    @Override // v9.m0
    public final Collection d() {
        p0 p0Var = this.f4911a;
        v vVarB = p0Var.a() == 3 ? p0Var.b() : n().o();
        k.d(vVarB, "if (projection.projectio… builtIns.nullableAnyType");
        return a.a.S(vVarB);
    }

    @Override // v9.m0
    public final List getParameters() {
        return z.f2978f;
    }

    @Override // v9.m0
    public final h n() {
        h hVarN = this.f4911a.b().E0().n();
        k.d(hVarN, "projection.type.constructor.builtIns");
        return hVarN;
    }

    public final String toString() {
        return "CapturedTypeConstructor(" + this.f4911a + ')';
    }
}
