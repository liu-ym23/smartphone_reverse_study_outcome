package l2;

import com.stepos.digitalwellbeing.server.data.PackageUsingTimeStats;

/* renamed from: l2.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0838g {

    /* renamed from: a, reason: collision with root package name */
    private long f18189a;

    /* renamed from: b, reason: collision with root package name */
    private int f18190b;

    /* renamed from: c, reason: collision with root package name */
    private long f18191c;

    /* renamed from: d, reason: collision with root package name */
    private long f18192d;

    /* renamed from: e, reason: collision with root package name */
    private long f18193e;

    /* renamed from: f, reason: collision with root package name */
    private String f18194f;

    /* renamed from: g, reason: collision with root package name */
    private long f18195g;

    public C0838g(int i5, long j5, long j6, long j7, String str, long j8) {
        this.f18190b = i5;
        this.f18191c = j5;
        this.f18192d = j6;
        this.f18193e = j7;
        this.f18194f = str;
        this.f18195g = j8;
    }

    public long a() {
        return this.f18189a;
    }

    public int b() {
        return this.f18190b;
    }

    public String c() {
        return this.f18194f;
    }

    public long d() {
        return this.f18195g;
    }

    public long e() {
        return this.f18191c;
    }

    public long f() {
        return this.f18192d;
    }

    public long g() {
        return this.f18193e;
    }

    public void h(long j5) {
        this.f18189a = j5;
    }

    public PackageUsingTimeStats i() {
        return new PackageUsingTimeStats(b(), e(), f(), g(), c());
    }

    public String toString() {
        return "PackageUsingTimeStatsCache{id=" + this.f18189a + ", interval=" + this.f18190b + ", startTime=" + this.f18191c + ", updateTime=" + this.f18192d + ", usingTime=" + this.f18193e + ", relationId=" + this.f18195g + ", packageName='" + this.f18194f + "'}";
    }
}
