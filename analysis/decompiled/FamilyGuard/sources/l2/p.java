package l2;

import com.stepos.digitalwellbeing.server.data.UsingTimeStats;

/* loaded from: classes.dex */
public class p {

    /* renamed from: a, reason: collision with root package name */
    private long f18272a;

    /* renamed from: b, reason: collision with root package name */
    private int f18273b;

    /* renamed from: c, reason: collision with root package name */
    private long f18274c;

    /* renamed from: d, reason: collision with root package name */
    private long f18275d;

    /* renamed from: e, reason: collision with root package name */
    private long f18276e;

    /* renamed from: f, reason: collision with root package name */
    private long f18277f;

    public p(int i5, long j5, long j6, long j7, long j8) {
        this.f18273b = i5;
        this.f18274c = j5;
        this.f18275d = j6;
        this.f18276e = j7;
        this.f18277f = j8;
    }

    public long a() {
        return this.f18272a;
    }

    public int b() {
        return this.f18273b;
    }

    public long c() {
        return this.f18277f;
    }

    public long d() {
        return this.f18274c;
    }

    public long e() {
        return this.f18275d;
    }

    public long f() {
        return this.f18276e;
    }

    public void g(long j5) {
        this.f18272a = j5;
    }

    public UsingTimeStats h() {
        return new UsingTimeStats(b(), d(), e(), f());
    }
}
