package com.stepos.common.widget;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class g {

    /* renamed from: c, reason: collision with root package name */
    public static final g f2689c = new g(0, 0);

    /* renamed from: a, reason: collision with root package name */
    public final int f2690a;

    /* renamed from: b, reason: collision with root package name */
    public final int f2691b;

    public g(int i, int i3) {
        this.f2690a = i;
        this.f2691b = i3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || g.class != obj.getClass()) {
            return false;
        }
        g gVar = (g) obj;
        return this.f2690a == gVar.f2690a && this.f2691b == gVar.f2691b;
    }

    public final int hashCode() {
        return ((this.f2690a * 961) + this.f2691b) * 31;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("Insets{left=");
        sb2.append(this.f2690a);
        sb2.append(", top=0, right=");
        return k0.a.r(sb2, this.f2691b, ", bottom=0}");
    }
}
