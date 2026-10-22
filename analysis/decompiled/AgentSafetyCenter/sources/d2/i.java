package d2;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class i {

    /* renamed from: c, reason: collision with root package name */
    public static final i f3115c;

    /* renamed from: f, reason: collision with root package name */
    public static final i f3116f;

    /* renamed from: g, reason: collision with root package name */
    public static final i f3117g;

    /* renamed from: h, reason: collision with root package name */
    public static final i f3118h;
    public static final i i;

    /* renamed from: j, reason: collision with root package name */
    public static final i f3119j;

    /* renamed from: k, reason: collision with root package name */
    public static final i f3120k;

    /* renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ i[] f3121l;

    static {
        i iVar = new i("Paragraph", 0);
        f3115c = iVar;
        i iVar2 = new i("Span", 1);
        f3116f = iVar2;
        i iVar3 = new i("VerbatimTts", 2);
        f3117g = iVar3;
        i iVar4 = new i("Url", 3);
        f3118h = iVar4;
        i iVar5 = new i("Link", 4);
        i = iVar5;
        i iVar6 = new i("Clickable", 5);
        f3119j = iVar6;
        i iVar7 = new i("String", 6);
        f3120k = iVar7;
        i[] iVarArr = {iVar, iVar2, iVar3, iVar4, iVar5, iVar6, iVar7};
        f3121l = iVarArr;
        a.a.p(iVarArr);
    }

    public static i valueOf(String str) {
        return (i) Enum.valueOf(i.class, str);
    }

    public static i[] values() {
        return (i[]) f3121l.clone();
    }
}
