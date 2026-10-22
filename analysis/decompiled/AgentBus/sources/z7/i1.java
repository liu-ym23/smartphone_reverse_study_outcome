package z7;

/* loaded from: classes.dex */
public abstract class i1 extends e1 implements w7.h {

    /* renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ w7.t[] f11882l;

    /* renamed from: j, reason: collision with root package name */
    public final q1 f11883j = s1.l(null, new h1(this, 1));

    /* renamed from: k, reason: collision with root package name */
    public final Object f11884k = s7.a.G(c7.h.f1970f, new h1(this, 0));

    static {
        q7.x xVar = q7.w.f8821a;
        f11882l = new w7.t[]{xVar.f(new q7.p(xVar.b(i1.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/PropertySetterDescriptor;"))};
    }

    @Override // z7.s
    public final f8.c B() {
        w7.t tVar = f11882l[0];
        Object objC = this.f11883j.c();
        q7.k.d(objC, "<get-descriptor>(...)");
        return (i8.k0) objC;
    }

    @Override // z7.e1
    public final f8.k0 E() {
        w7.t tVar = f11882l[0];
        Object objC = this.f11883j.c();
        q7.k.d(objC, "<get-descriptor>(...)");
        return (i8.k0) objC;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof i1) && q7.k.a(F(), ((i1) obj).F());
    }

    @Override // w7.c
    public final String getName() {
        return a1.a.l(new StringBuilder("<set-"), F().f11895k, '>');
    }

    public final int hashCode() {
        return F().hashCode();
    }

    public final String toString() {
        return "setter of " + F();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [c7.f, java.lang.Object] */
    @Override // z7.s
    public final a8.h y() {
        return (a8.h) this.f11884k.getValue();
    }
}
