package a6;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class b0 extends f5.a implements f5.e {

    /* renamed from: b, reason: collision with root package name */
    public static final a0 f136b = new a0(f5.d.f2625a, new z(0));

    public b0() {
        super(f5.d.f2625a);
    }

    public abstract void C(f5.h hVar, Runnable runnable);

    public void E(f5.h hVar, Runnable runnable) {
        f6.a.i(this, hVar, runnable);
    }

    public boolean F(f5.h hVar) {
        return !(this instanceof d2);
    }

    public b0 G(int i8) {
        f6.a.a(i8);
        return new f6.f(this, i8);
    }

    @Override // f5.a, f5.h
    public final f5.f o(f5.g key) {
        f5.f fVar;
        kotlin.jvm.internal.p.e(key, "key");
        if (key instanceof a0) {
            a0 a0Var = (a0) key;
            f5.g gVar = this.f2622a;
            if ((gVar == a0Var || a0Var.f130b == gVar) && (fVar = (f5.f) a0Var.f129a.invoke(this)) != null) {
                return fVar;
            }
        } else if (f5.d.f2625a == key) {
            return this;
        }
        return null;
    }

    @Override // f5.a, f5.h
    public final f5.h s(f5.g key) {
        kotlin.jvm.internal.p.e(key, "key");
        if (key instanceof a0) {
            a0 a0Var = (a0) key;
            f5.g gVar = this.f2622a;
            if ((gVar != a0Var && a0Var.f130b != gVar) || ((f5.f) a0Var.f129a.invoke(this)) == null) {
                return this;
            }
        } else if (f5.d.f2625a != key) {
            return this;
        }
        return f5.i.f2626a;
    }

    public String toString() {
        return getClass().getSimpleName() + '@' + i0.k(this);
    }
}
