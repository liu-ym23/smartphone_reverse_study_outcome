package h0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name */
    public float f5226a;

    /* renamed from: b, reason: collision with root package name */
    public float f5227b;

    /* renamed from: c, reason: collision with root package name */
    public float f5228c;

    /* renamed from: d, reason: collision with root package name */
    public float f5229d;

    /* renamed from: e, reason: collision with root package name */
    public float f5230e;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof w)) {
            return false;
        }
        w wVar = (w) obj;
        return o2.f.b(this.f5226a, wVar.f5226a) && o2.f.b(this.f5227b, wVar.f5227b) && o2.f.b(this.f5228c, wVar.f5228c) && o2.f.b(this.f5229d, wVar.f5229d) && o2.f.b(this.f5230e, wVar.f5230e);
    }

    public final int hashCode() {
        return Float.hashCode(this.f5230e) + k0.a.g(k0.a.g(k0.a.g(Float.hashCode(this.f5226a) * 31, this.f5227b, 31), this.f5228c, 31), this.f5229d, 31);
    }
}
