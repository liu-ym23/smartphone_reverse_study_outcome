package t8;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class g {

    /* renamed from: c, reason: collision with root package name */
    public static final g f13240c;

    /* renamed from: f, reason: collision with root package name */
    public static final g f13241f;

    /* renamed from: g, reason: collision with root package name */
    public static final g f13242g;

    /* renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ g[] f13243h;

    static {
        g gVar = new g("HIGH", 0);
        f13240c = gVar;
        g gVar2 = new g("MEDIUM", 1);
        f13241f = gVar2;
        g gVar3 = new g("LOW", 2);
        f13242g = gVar3;
        g[] gVarArr = {gVar, gVar2, gVar3};
        f13243h = gVarArr;
        a.a.p(gVarArr);
    }

    public static g valueOf(String str) {
        return (g) Enum.valueOf(g.class, str);
    }

    public static g[] values() {
        return (g[]) f13243h.clone();
    }
}
