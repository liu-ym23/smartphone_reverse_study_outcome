package n6;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class r {

    /* renamed from: b, reason: collision with root package name */
    public static final b f4119b;

    /* renamed from: c, reason: collision with root package name */
    public static final r f4120c;
    public static final r d;

    /* renamed from: e, reason: collision with root package name */
    public static final r f4121e;

    /* renamed from: f, reason: collision with root package name */
    public static final r f4122f;

    /* renamed from: g, reason: collision with root package name */
    public static final r f4123g;

    /* renamed from: h, reason: collision with root package name */
    public static final r f4124h;

    /* renamed from: j, reason: collision with root package name */
    public static final r f4125j;

    /* renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ r[] f4126k;

    /* renamed from: a, reason: collision with root package name */
    public final String f4127a;

    static {
        r rVar = new r("HTTP_1_0", 0, "http/1.0");
        f4120c = rVar;
        r rVar2 = new r("HTTP_1_1", 1, "http/1.1");
        d = rVar2;
        r rVar3 = new r("SPDY_3", 2, "spdy/3.1");
        f4121e = rVar3;
        r rVar4 = new r("HTTP_2", 3, "h2");
        f4122f = rVar4;
        r rVar5 = new r("H2_PRIOR_KNOWLEDGE", 4, "h2_prior_knowledge");
        f4123g = rVar5;
        r rVar6 = new r("QUIC", 5, "quic");
        f4124h = rVar6;
        r rVar7 = new r("HTTP_3", 6, "h3");
        f4125j = rVar7;
        r[] rVarArr = {rVar, rVar2, rVar3, rVar4, rVar5, rVar6, rVar7};
        f4126k = rVarArr;
        a.a.F(rVarArr);
        f4119b = new b();
    }

    public r(String str, int i8, String str2) {
        this.f4127a = str2;
    }

    public static r valueOf(String str) {
        return (r) Enum.valueOf(r.class, str);
    }

    public static r[] values() {
        return (r[]) f4126k.clone();
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.f4127a;
    }
}
