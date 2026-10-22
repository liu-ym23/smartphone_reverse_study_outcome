package a6;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final String f295a;

    /* renamed from: b, reason: collision with root package name */
    public final String f296b;

    /* renamed from: c, reason: collision with root package name */
    public final String f297c;

    /* renamed from: d, reason: collision with root package name */
    public final String f298d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f299e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f300f;

    /* renamed from: g, reason: collision with root package name */
    public final Long f301g;

    /* renamed from: h, reason: collision with root package name */
    public final String f302h;

    public d(String str, String str2, String str3, String str4, boolean z4, boolean z10, Long l6, String str5) {
        q7.k.e(str3, "schedule");
        this.f295a = str;
        this.f296b = str2;
        this.f297c = str3;
        this.f298d = str4;
        this.f299e = z4;
        this.f300f = z10;
        this.f301g = l6;
        this.f302h = str5;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return q7.k.a(this.f295a, dVar.f295a) && q7.k.a(this.f296b, dVar.f296b) && q7.k.a(this.f297c, dVar.f297c) && q7.k.a(this.f298d, dVar.f298d) && this.f299e == dVar.f299e && this.f300f == dVar.f300f && q7.k.a(this.f301g, dVar.f301g) && q7.k.a(this.f302h, dVar.f302h);
    }

    public final int hashCode() {
        int iE = m.x.e(m.x.e(m.x.g(this.f298d, m.x.g(this.f297c, m.x.g(this.f296b, this.f295a.hashCode() * 31, 31), 31), 31), 31, this.f299e), 31, this.f300f);
        Long l6 = this.f301g;
        int iHashCode = (iE + (l6 == null ? 0 : l6.hashCode())) * 31;
        String str = this.f302h;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sbP = a1.a.p("CronJobSpec(jobId=", this.f295a, ", name=", this.f296b, ", schedule=");
        m.x.w(sbP, this.f297c, ", actionTarget=", this.f298d, ", isEnabled=");
        sbP.append(this.f299e);
        sbP.append(", deleteAfterRun=");
        sbP.append(this.f300f);
        sbP.append(", nextRunAtMs=");
        sbP.append(this.f301g);
        sbP.append(", payloadText=");
        sbP.append(this.f302h);
        sbP.append(")");
        return sbP.toString();
    }
}
