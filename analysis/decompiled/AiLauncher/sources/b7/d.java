package b7;

/* loaded from: classes3.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public final long f15277a;

    /* renamed from: b, reason: collision with root package name */
    public final String f15278b;

    /* renamed from: c, reason: collision with root package name */
    public final String f15279c;

    /* renamed from: d, reason: collision with root package name */
    public final String f15280d;

    /* renamed from: e, reason: collision with root package name */
    public final double f15281e;

    /* renamed from: f, reason: collision with root package name */
    public final int f15282f;

    /* renamed from: g, reason: collision with root package name */
    public final long f15283g;

    /* renamed from: h, reason: collision with root package name */
    public final long f15284h;

    public d(long j10, String str, String str2, String str3, double d10, int i10, long j11, long j12) {
        this.f15277a = j10;
        this.f15278b = str;
        this.f15279c = str2;
        this.f15280d = str3;
        this.f15281e = d10;
        this.f15282f = i10;
        this.f15283g = j11;
        this.f15284h = j12;
    }

    public String a() {
        String str = this.f15280d;
        return str != null ? str : this.f15279c;
    }

    public long b() {
        return this.f15277a;
    }

    public double c() {
        return this.f15281e;
    }

    public String d() {
        return e(100);
    }

    public String e(int i10) {
        String strA = a();
        if (strA.length() <= i10) {
            return strA;
        }
        return strA.substring(0, i10) + "...";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            d dVar = (d) obj;
            if (this.f15277a == dVar.f15277a && this.f15278b.equals(dVar.f15278b)) {
                return true;
            }
        }
        return false;
    }

    public String f() {
        return this.f15278b;
    }

    public int hashCode() {
        long j10 = this.f15277a;
        return (((int) (j10 ^ (j10 >>> 32))) * 31) + this.f15278b.hashCode();
    }

    public String toString() {
        return "FullTextSearchResult{docId=" + this.f15277a + ", tableName='" + this.f15278b + "', score=" + this.f15281e + ", matchedTermCount=" + this.f15282f + ", content='" + e(50) + "'}";
    }
}
