package o1;

import java.util.ArrayList;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class u {

    /* renamed from: a, reason: collision with root package name */
    public long f9088a;

    /* renamed from: b, reason: collision with root package name */
    public long f9089b;

    /* renamed from: c, reason: collision with root package name */
    public long f9090c;

    /* renamed from: d, reason: collision with root package name */
    public long f9091d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f9092e;

    /* renamed from: f, reason: collision with root package name */
    public float f9093f;

    /* renamed from: g, reason: collision with root package name */
    public int f9094g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f9095h;
    public ArrayList i;

    /* renamed from: j, reason: collision with root package name */
    public long f9096j;

    /* renamed from: k, reason: collision with root package name */
    public long f9097k;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof u)) {
            return false;
        }
        u uVar = (u) obj;
        return r.a(this.f9088a, uVar.f9088a) && this.f9089b == uVar.f9089b && c1.b.c(this.f9090c, uVar.f9090c) && c1.b.c(this.f9091d, uVar.f9091d) && this.f9092e == uVar.f9092e && Float.compare(this.f9093f, uVar.f9093f) == 0 && this.f9094g == uVar.f9094g && this.f9095h == uVar.f9095h && this.i.equals(uVar.i) && c1.b.c(this.f9096j, uVar.f9096j) && c1.b.c(this.f9097k, uVar.f9097k);
    }

    public final int hashCode() {
        return Long.hashCode(this.f9097k) + k0.a.i(this.f9096j, (this.i.hashCode() + k0.a.h(s.f.b(this.f9094g, k0.a.g(k0.a.h(k0.a.i(this.f9091d, k0.a.i(this.f9090c, k0.a.i(this.f9089b, Long.hashCode(this.f9088a) * 31, 31), 31), 31), 31, this.f9092e), this.f9093f, 31), 31), 31, this.f9095h)) * 31, 31);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("PointerInputEventData(id=");
        sb2.append((Object) r.b(this.f9088a));
        sb2.append(", uptime=");
        sb2.append(this.f9089b);
        sb2.append(", positionOnScreen=");
        sb2.append((Object) c1.b.j(this.f9090c));
        sb2.append(", position=");
        sb2.append((Object) c1.b.j(this.f9091d));
        sb2.append(", down=");
        sb2.append(this.f9092e);
        sb2.append(", pressure=");
        sb2.append(this.f9093f);
        sb2.append(", type=");
        int i = this.f9094g;
        sb2.append((Object) (i != 1 ? i != 2 ? i != 3 ? i != 4 ? "Unknown" : "Eraser" : "Stylus" : "Mouse" : "Touch"));
        sb2.append(", activeHover=");
        sb2.append(this.f9095h);
        sb2.append(", historical=");
        sb2.append(this.i);
        sb2.append(", scrollDelta=");
        sb2.append((Object) c1.b.j(this.f9096j));
        sb2.append(", originalEventPosition=");
        sb2.append((Object) c1.b.j(this.f9097k));
        sb2.append(')');
        return sb2.toString();
    }
}
