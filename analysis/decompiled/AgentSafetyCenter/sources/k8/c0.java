package k8;

import s8.j3;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c0 implements d0 {

    /* renamed from: a, reason: collision with root package name */
    public final j3 f7287a;

    /* renamed from: b, reason: collision with root package name */
    public final String f7288b;

    /* renamed from: c, reason: collision with root package name */
    public final d0 f7289c;

    public c0(j3 j3Var, String str, d0 d0Var) {
        j3Var.getClass();
        this.f7287a = j3Var;
        this.f7288b = str;
        this.f7289c = d0Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c0)) {
            return false;
        }
        c0 c0Var = (c0) obj;
        return yb.k.a(this.f7287a, c0Var.f7287a) && yb.k.a(this.f7288b, c0Var.f7288b) && yb.k.a(this.f7289c, c0Var.f7289c);
    }

    public final int hashCode() {
        int iHashCode = this.f7287a.hashCode() * 31;
        String str = this.f7288b;
        return this.f7289c.hashCode() + ((iHashCode + (str == null ? 0 : str.hashCode())) * 31);
    }

    public final String toString() {
        return "TaskDetail(group=" + this.f7287a + ", interceptRowKey=" + this.f7288b + ", returnRoute=" + this.f7289c + ")";
    }

    public /* synthetic */ c0(j3 j3Var, String str, int i) {
        this(j3Var, (i & 2) != 0 ? null : str, x.f7359a);
    }
}
