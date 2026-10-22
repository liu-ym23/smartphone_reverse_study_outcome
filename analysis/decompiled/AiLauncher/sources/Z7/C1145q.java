package Z7;

/* renamed from: Z7.q, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1145q implements Comparable<C1145q> {

    /* renamed from: a, reason: collision with root package name */
    public long f7574a = -1;

    /* renamed from: b, reason: collision with root package name */
    public long f7575b = -1;

    /* renamed from: c, reason: collision with root package name */
    public String f7576c = null;

    /* renamed from: d, reason: collision with root package name */
    public boolean f7577d = false;

    /* renamed from: e, reason: collision with root package name */
    public boolean f7578e = false;

    /* renamed from: f, reason: collision with root package name */
    public int f7579f = 0;

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(C1145q c1145q) {
        C1145q c1145q2 = c1145q;
        if (c1145q2 == null) {
            return 1;
        }
        long j10 = this.f7575b - c1145q2.f7575b;
        if (j10 <= 0) {
            return j10 < 0 ? -1 : 0;
        }
        return 1;
    }
}
