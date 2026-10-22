package l2;

import com.stepos.digitalwellbeing.server.data.CategoryUsingTimeStats;

/* renamed from: l2.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0834c {

    /* renamed from: a, reason: collision with root package name */
    private long f18171a;

    /* renamed from: b, reason: collision with root package name */
    private int f18172b;

    /* renamed from: c, reason: collision with root package name */
    private long f18173c;

    /* renamed from: d, reason: collision with root package name */
    private long f18174d;

    /* renamed from: e, reason: collision with root package name */
    private long f18175e;

    /* renamed from: f, reason: collision with root package name */
    private long f18176f;

    /* renamed from: g, reason: collision with root package name */
    private int f18177g;

    public C0834c(int i5, long j5, long j6, long j7, int i6, long j8) {
        this.f18172b = i5;
        this.f18173c = j5;
        this.f18174d = j6;
        this.f18175e = j7;
        this.f18176f = j8;
        this.f18177g = i6;
    }

    public int a() {
        return this.f18177g;
    }

    public long b() {
        return this.f18171a;
    }

    public int c() {
        return this.f18172b;
    }

    public long d() {
        return this.f18176f;
    }

    public long e() {
        return this.f18173c;
    }

    public long f() {
        return this.f18174d;
    }

    public long g() {
        return this.f18175e;
    }

    public void h(long j5) {
        this.f18171a = j5;
    }

    public CategoryUsingTimeStats i() {
        return new CategoryUsingTimeStats(c(), e(), f(), g(), a());
    }

    public String toString() {
        return "CategoryUsingTimeStatsCache{id=" + this.f18171a + ", interval=" + this.f18172b + ", startTime=" + this.f18173c + ", updateTime=" + this.f18174d + ", usingTime=" + this.f18175e + ", relationId=" + this.f18176f + ", categoryId=" + this.f18177g + '}';
    }
}
