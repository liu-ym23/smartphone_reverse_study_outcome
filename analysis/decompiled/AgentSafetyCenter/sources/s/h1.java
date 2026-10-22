package s;

import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class h1 implements u {

    /* renamed from: a, reason: collision with root package name */
    public final int f11017a;

    /* renamed from: b, reason: collision with root package name */
    public final int f11018b;

    /* renamed from: c, reason: collision with root package name */
    public final v f11019c;

    public h1(int i, int i3, v vVar) {
        this.f11017a = i;
        this.f11018b = i3;
        this.f11019c = vVar;
    }

    @Override // s.h
    public final /* bridge */ /* synthetic */ j1 a(n6.a aVar) {
        return f();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof h1)) {
            return false;
        }
        h1 h1Var = (h1) obj;
        return h1Var.f11017a == this.f11017a && h1Var.f11018b == this.f11018b && yb.k.a(h1Var.f11019c, this.f11019c);
    }

    public final b0.z f() {
        b0.z zVar = new b0.z();
        int i = this.f11017a;
        zVar.f1801c = i;
        int i3 = this.f11018b;
        zVar.f1802f = i3;
        a0 a0Var = new a0();
        a0Var.f10934a = i;
        a0Var.f10935b = i3;
        a0Var.f10936c = this.f11019c;
        a0Var.f10937d = i * 1000000;
        a0Var.f10938e = i3 * 1000000;
        VarHandle.storeStoreFence();
        zVar.f1803g = new p5.i(a0Var);
        VarHandle.storeStoreFence();
        return zVar;
    }

    public final int hashCode() {
        return ((this.f11019c.hashCode() + (this.f11017a * 31)) * 31) + this.f11018b;
    }

    @Override // s.u, s.h
    public final /* bridge */ /* synthetic */ k1 a(n6.a aVar) {
        return f();
    }
}
