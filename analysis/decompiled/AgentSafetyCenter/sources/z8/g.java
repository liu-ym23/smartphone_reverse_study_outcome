package z8;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class g {

    /* renamed from: c, reason: collision with root package name */
    public static final z4.b f16509c;

    /* renamed from: f, reason: collision with root package name */
    public static final g f16510f;

    /* renamed from: g, reason: collision with root package name */
    public static final g f16511g;

    /* renamed from: h, reason: collision with root package name */
    public static final g f16512h;
    public static final g i;

    /* renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ g[] f16513j;

    static {
        g gVar = new g("None", 0);
        f16510f = gVar;
        g gVar2 = new g("Eligible", 1);
        f16511g = gVar2;
        g gVar3 = new g("Expired", 2);
        f16512h = gVar3;
        g gVar4 = new g("Revoked", 3);
        i = gVar4;
        g[] gVarArr = {gVar, gVar2, gVar3, gVar4};
        f16513j = gVarArr;
        a.a.p(gVarArr);
        f16509c = new z4.b();
    }

    public static g valueOf(String str) {
        return (g) Enum.valueOf(g.class, str);
    }

    public static g[] values() {
        return (g[]) f16513j.clone();
    }
}
