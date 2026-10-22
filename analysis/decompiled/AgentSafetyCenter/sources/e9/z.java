package e9;

import java.util.List;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class z {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f3740a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f3741b;

    /* renamed from: c, reason: collision with root package name */
    public final List f3742c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f3743d;

    public /* synthetic */ z(int i) {
        this(kb.s.f7404c, false, false, (i & 8) == 0);
    }

    public static z a(z zVar, boolean z10, int i) {
        boolean z11 = zVar.f3740a;
        if ((i & 2) != 0) {
            z10 = zVar.f3741b;
        }
        List list = zVar.f3742c;
        boolean z12 = (i & 8) != 0 ? zVar.f3743d : true;
        zVar.getClass();
        list.getClass();
        return new z(list, z11, z10, z12);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof z)) {
            return false;
        }
        z zVar = (z) obj;
        return this.f3740a == zVar.f3740a && this.f3741b == zVar.f3741b && yb.k.a(this.f3742c, zVar.f3742c) && this.f3743d == zVar.f3743d;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.f3743d) + androidx.activity.b.e(this.f3742c, k0.a.h(Boolean.hashCode(this.f3740a) * 31, 31, this.f3741b), 31);
    }

    public final String toString() {
        return "OperatePhoneState(masterEnabled=" + this.f3740a + ", localRunEnabled=" + this.f3741b + ", apps=" + this.f3742c + ", isLoading=" + this.f3743d + ")";
    }

    public z(List list, boolean z10, boolean z11, boolean z12) {
        this.f3740a = z10;
        this.f3741b = z11;
        this.f3742c = list;
        this.f3743d = z12;
    }
}
