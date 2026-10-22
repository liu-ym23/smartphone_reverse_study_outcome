package androidx.datastore.preferences.protobuf;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class t implements Cloneable {

    /* renamed from: c, reason: collision with root package name */
    public final v f1205c;

    /* renamed from: f, reason: collision with root package name */
    public v f1206f;

    public t(v vVar) {
        this.f1205c = vVar;
        if (vVar.g()) {
            g5.f.s("Default instance must be immutable.");
            throw null;
        }
        this.f1206f = vVar.j();
    }

    public final v a() {
        v vVarB = b();
        vVarB.getClass();
        if (v.f(vVarB, true)) {
            return vVarB;
        }
        throw new c1();
    }

    public final v b() {
        boolean zG = this.f1206f.g();
        v vVar = this.f1206f;
        if (!zG) {
            return vVar;
        }
        vVar.getClass();
        t0 t0Var = t0.f1207c;
        t0Var.getClass();
        t0Var.a(vVar.getClass()).makeImmutable(vVar);
        vVar.h();
        return this.f1206f;
    }

    public final void c() {
        if (this.f1206f.g()) {
            return;
        }
        v vVarJ = this.f1205c.j();
        v vVar = this.f1206f;
        t0 t0Var = t0.f1207c;
        t0Var.getClass();
        t0Var.a(vVarJ.getClass()).mergeFrom(vVarJ, vVar);
        this.f1206f = vVarJ;
    }

    public final Object clone() {
        t tVar = (t) this.f1205c.c(5);
        tVar.f1206f = b();
        return tVar;
    }
}
