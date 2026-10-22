package s1;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class g {

    /* renamed from: f, reason: collision with root package name */
    public static final g f9260f;

    /* renamed from: g, reason: collision with root package name */
    public static final g f9261g;

    /* renamed from: h, reason: collision with root package name */
    public static final g f9262h;

    /* renamed from: i, reason: collision with root package name */
    public static final g f9263i;

    /* renamed from: j, reason: collision with root package name */
    public static final g f9264j;

    /* renamed from: k, reason: collision with root package name */
    public static final g f9265k;

    /* renamed from: l, reason: collision with root package name */
    public static final g f9266l;

    /* renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ g[] f9267m;

    static {
        g gVar = new g("Paragraph", 0);
        f9260f = gVar;
        g gVar2 = new g("Span", 1);
        f9261g = gVar2;
        g gVar3 = new g("VerbatimTts", 2);
        f9262h = gVar3;
        g gVar4 = new g("Url", 3);
        f9263i = gVar4;
        g gVar5 = new g("Link", 4);
        f9264j = gVar5;
        g gVar6 = new g("Clickable", 5);
        f9265k = gVar6;
        g gVar7 = new g("String", 6);
        f9266l = gVar7;
        g[] gVarArr = {gVar, gVar2, gVar3, gVar4, gVar5, gVar6, gVar7};
        f9267m = gVarArr;
        w7.e0.s(gVarArr);
    }

    public static g valueOf(String str) {
        return (g) Enum.valueOf(g.class, str);
    }

    public static g[] values() {
        return (g[]) f9267m.clone();
    }
}
