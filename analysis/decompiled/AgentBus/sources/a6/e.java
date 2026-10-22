package a6;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final long f305a;

    /* renamed from: b, reason: collision with root package name */
    public final String f306b;

    /* renamed from: c, reason: collision with root package name */
    public final f f307c;

    /* renamed from: d, reason: collision with root package name */
    public final String f308d;

    /* renamed from: e, reason: collision with root package name */
    public final String f309e;

    /* renamed from: f, reason: collision with root package name */
    public final Long f310f;

    /* renamed from: g, reason: collision with root package name */
    public final Long f311g;

    /* renamed from: h, reason: collision with root package name */
    public final Long f312h;

    /* renamed from: i, reason: collision with root package name */
    public final String f313i;

    public e(long j2, String str, f fVar, String str2, String str3, Long l6, Long l10, Long l11, String str4) {
        this.f305a = j2;
        this.f306b = str;
        this.f307c = fVar;
        this.f308d = str2;
        this.f309e = str3;
        this.f310f = l6;
        this.f311g = l10;
        this.f312h = l11;
        this.f313i = str4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return this.f305a == eVar.f305a && q7.k.a(this.f306b, eVar.f306b) && this.f307c == eVar.f307c && q7.k.a(this.f308d, eVar.f308d) && q7.k.a(this.f309e, eVar.f309e) && q7.k.a(this.f310f, eVar.f310f) && q7.k.a(this.f311g, eVar.f311g) && q7.k.a(this.f312h, eVar.f312h) && q7.k.a(this.f313i, eVar.f313i);
    }

    public final int hashCode() {
        int iG = m.x.g(this.f306b, Long.hashCode(this.f305a) * 31, 31);
        f fVar = this.f307c;
        int iHashCode = (iG + (fVar == null ? 0 : fVar.hashCode())) * 31;
        String str = this.f308d;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f309e;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Long l6 = this.f310f;
        int iHashCode4 = (iHashCode3 + (l6 == null ? 0 : l6.hashCode())) * 31;
        Long l10 = this.f311g;
        int iHashCode5 = (iHashCode4 + (l10 == null ? 0 : l10.hashCode())) * 31;
        Long l11 = this.f312h;
        int iHashCode6 = (iHashCode5 + (l11 == null ? 0 : l11.hashCode())) * 31;
        String str3 = this.f313i;
        return iHashCode6 + (str3 != null ? str3.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("CronRunLogSpec(tsMs=");
        sb2.append(this.f305a);
        sb2.append(", jobId=");
        sb2.append(this.f306b);
        sb2.append(", status=");
        sb2.append(this.f307c);
        sb2.append(", summary=");
        sb2.append(this.f308d);
        sb2.append(", error=");
        sb2.append(this.f309e);
        sb2.append(", nextRunAtMs=");
        sb2.append(this.f310f);
        sb2.append(", durationMs=");
        sb2.append(this.f311g);
        sb2.append(", runAtMs=");
        sb2.append(this.f312h);
        return m.x.n(sb2, ", sessionKey=", this.f313i, ")");
    }
}
