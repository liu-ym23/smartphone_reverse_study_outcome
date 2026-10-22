package s4;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class d implements Comparable {

    /* renamed from: c, reason: collision with root package name */
    public int f11383c;

    /* renamed from: f, reason: collision with root package name */
    public int f11384f;

    /* renamed from: g, reason: collision with root package name */
    public String f11385g;

    /* renamed from: h, reason: collision with root package name */
    public String f11386h;

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        d dVar = (d) obj;
        dVar.getClass();
        int i = this.f11383c - dVar.f11383c;
        return i == 0 ? this.f11384f - dVar.f11384f : i;
    }
}
