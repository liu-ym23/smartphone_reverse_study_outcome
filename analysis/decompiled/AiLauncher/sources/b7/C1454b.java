package b7;

import com.stepos.datacenter.fts.MatchMode;

/* renamed from: b7.b, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1454b {

    /* renamed from: a, reason: collision with root package name */
    public final String f15259a;

    /* renamed from: b, reason: collision with root package name */
    public final String f15260b;

    /* renamed from: c, reason: collision with root package name */
    public final int f15261c;

    /* renamed from: d, reason: collision with root package name */
    public final int f15262d;

    /* renamed from: e, reason: collision with root package name */
    public final MatchMode f15263e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f15264f;

    /* renamed from: g, reason: collision with root package name */
    public final String f15265g;

    /* renamed from: h, reason: collision with root package name */
    public final String f15266h;

    /* renamed from: i, reason: collision with root package name */
    public final double f15267i;

    /* renamed from: b7.b$a */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final String f15268a;

        /* renamed from: b, reason: collision with root package name */
        public String f15269b = null;

        /* renamed from: c, reason: collision with root package name */
        public int f15270c = 10;

        /* renamed from: d, reason: collision with root package name */
        public int f15271d = 0;

        /* renamed from: e, reason: collision with root package name */
        public MatchMode f15272e = MatchMode.ANY;

        /* renamed from: f, reason: collision with root package name */
        public boolean f15273f = true;

        /* renamed from: g, reason: collision with root package name */
        public String f15274g = "<b>";

        /* renamed from: h, reason: collision with root package name */
        public String f15275h = "</b>";

        /* renamed from: i, reason: collision with root package name */
        public double f15276i = 0.0d;

        public a(String str) {
            if (str == null || str.trim().isEmpty()) {
                throw new IllegalArgumentException("Query cannot be null or empty");
            }
            this.f15268a = str;
        }

        public C1454b j() {
            return new C1454b(this);
        }

        public a k(int i10) {
            if (i10 <= 0) {
                throw new IllegalArgumentException("Limit must be positive");
            }
            this.f15270c = i10;
            return this;
        }

        public a l(String str) {
            this.f15269b = str;
            return this;
        }
    }

    public String a() {
        return this.f15265g;
    }

    public String b() {
        return this.f15266h;
    }

    public int c() {
        return this.f15261c;
    }

    public double d() {
        return this.f15267i;
    }

    public int e() {
        return this.f15262d;
    }

    public String f() {
        return this.f15259a;
    }

    public String g() {
        return this.f15260b;
    }

    public boolean h() {
        return this.f15264f;
    }

    public String toString() {
        return "FullTextSearchRequest{query='" + this.f15259a + "', tableName='" + this.f15260b + "', limit=" + this.f15261c + ", offset=" + this.f15262d + ", matchMode=" + this.f15263e + ", enableHighlight=" + this.f15264f + ", minScore=" + this.f15267i + '}';
    }

    public C1454b(a aVar) {
        this.f15259a = aVar.f15268a;
        this.f15260b = aVar.f15269b;
        this.f15261c = aVar.f15270c;
        this.f15262d = aVar.f15271d;
        this.f15263e = aVar.f15272e;
        this.f15264f = aVar.f15273f;
        this.f15265g = aVar.f15274g;
        this.f15266h = aVar.f15275h;
        this.f15267i = aVar.f15276i;
    }
}
