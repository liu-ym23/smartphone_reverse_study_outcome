package g2;

import java.util.List;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class k implements Comparable {

    /* renamed from: f, reason: collision with root package name */
    public static final k f4251f;

    /* renamed from: g, reason: collision with root package name */
    public static final k f4252g;

    /* renamed from: h, reason: collision with root package name */
    public static final k f4253h;
    public static final k i;

    /* renamed from: j, reason: collision with root package name */
    public static final k f4254j;

    /* renamed from: k, reason: collision with root package name */
    public static final List f4255k;

    /* renamed from: c, reason: collision with root package name */
    public final int f4256c;

    static {
        k kVar = new k(100);
        k kVar2 = new k(200);
        k kVar3 = new k(300);
        k kVar4 = new k(400);
        k kVar5 = new k(500);
        k kVar6 = new k(600);
        f4251f = kVar6;
        k kVar7 = new k(700);
        k kVar8 = new k(800);
        k kVar9 = new k(900);
        f4252g = kVar4;
        f4253h = kVar5;
        i = kVar6;
        f4254j = kVar7;
        f4255k = ac.a.F(kVar, kVar2, kVar3, kVar4, kVar5, kVar6, kVar7, kVar8, kVar9);
    }

    public k(int i3) {
        this.f4256c = i3;
        boolean z10 = false;
        if (1 <= i3 && i3 < 1001) {
            z10 = true;
        }
        if (z10) {
            return;
        }
        i2.a.a("Font weight can be in range [1, 1000]. Current value: " + i3);
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return yb.k.b(this.f4256c, ((k) obj).f4256c);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof k) {
            return this.f4256c == ((k) obj).f4256c;
        }
        return false;
    }

    public final int hashCode() {
        return this.f4256c;
    }

    public final String toString() {
        return androidx.activity.b.l(new StringBuilder("FontWeight(weight="), this.f4256c, ')');
    }
}
