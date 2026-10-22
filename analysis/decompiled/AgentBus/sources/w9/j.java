package w9;

import d7.z;
import f8.q0;
import java.util.Collection;
import java.util.List;
import v9.p0;
import v9.v;

/* loaded from: classes.dex */
public final class j implements i9.b {

    /* renamed from: a, reason: collision with root package name */
    public final p0 f10941a;

    /* renamed from: b, reason: collision with root package name */
    public p7.a f10942b;

    /* renamed from: c, reason: collision with root package name */
    public final j f10943c;

    /* renamed from: d, reason: collision with root package name */
    public final q0 f10944d;

    /* renamed from: e, reason: collision with root package name */
    public final Object f10945e;

    public j(p0 p0Var, p7.a aVar, j jVar, q0 q0Var) {
        q7.k.e(p0Var, "projection");
        this.f10941a = p0Var;
        this.f10942b = aVar;
        this.f10943c = jVar;
        this.f10944d = q0Var;
        this.f10945e = s7.a.G(c7.h.f1970f, new t9.h(11, this));
    }

    @Override // v9.m0
    public final boolean a() {
        return false;
    }

    @Override // i9.b
    public final p0 b() {
        return this.f10941a;
    }

    @Override // v9.m0
    public final f8.g c() {
        return null;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [c7.f, java.lang.Object] */
    @Override // v9.m0
    public final Collection d() {
        List list = (List) this.f10945e.getValue();
        return list == null ? z.f2978f : list;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!j.class.equals(obj != null ? obj.getClass() : null)) {
            return false;
        }
        q7.k.c(obj, "null cannot be cast to non-null type org.jetbrains.kotlin.types.checker.NewCapturedTypeConstructor");
        j jVar = (j) obj;
        j jVar2 = this.f10943c;
        if (jVar2 != null) {
            this = jVar2;
        }
        j jVar3 = jVar.f10943c;
        if (jVar3 != null) {
            jVar = jVar3;
        }
        return this == jVar;
    }

    @Override // v9.m0
    public final List getParameters() {
        return z.f2978f;
    }

    public final int hashCode() {
        j jVar = this.f10943c;
        return jVar != null ? jVar.hashCode() : super.hashCode();
    }

    @Override // v9.m0
    public final c8.h n() {
        v vVarB = this.f10941a.b();
        q7.k.d(vVarB, "projection.type");
        return n7.m.r(vVarB);
    }

    public final String toString() {
        return "CapturedType(" + this.f10941a + ')';
    }

    public /* synthetic */ j(p0 p0Var, t9.d dVar, q0 q0Var, int i2) {
        this(p0Var, (i2 & 2) != 0 ? null : dVar, (j) null, (i2 & 8) != 0 ? null : q0Var);
    }
}
