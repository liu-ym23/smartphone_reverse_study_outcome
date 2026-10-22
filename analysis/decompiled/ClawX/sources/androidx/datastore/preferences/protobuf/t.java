package androidx.datastore.preferences.protobuf;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class t implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    public final v f566a;

    /* renamed from: b, reason: collision with root package name */
    public v f567b;

    public t(v vVar) {
        this.f566a = vVar;
        if (vVar.g()) {
            throw new IllegalArgumentException("Default instance must be immutable.");
        }
        this.f567b = vVar.i();
    }

    public final v a() {
        v vVarB = b();
        vVarB.getClass();
        if (v.f(vVarB, true)) {
            return vVarB;
        }
        throw new a1();
    }

    public final v b() {
        if (!this.f567b.g()) {
            return this.f567b;
        }
        v vVar = this.f567b;
        vVar.getClass();
        r0 r0Var = r0.f559c;
        r0Var.getClass();
        r0Var.a(vVar.getClass()).b(vVar);
        vVar.h();
        return this.f567b;
    }

    public final void c() {
        if (this.f567b.g()) {
            return;
        }
        v vVarI = this.f566a.i();
        v vVar = this.f567b;
        r0 r0Var = r0.f559c;
        r0Var.getClass();
        r0Var.a(vVarI.getClass()).a(vVarI, vVar);
        this.f567b = vVarI;
    }

    public final Object clone() {
        t tVar = (t) this.f566a.c(5);
        tVar.f567b = b();
        return tVar;
    }
}
