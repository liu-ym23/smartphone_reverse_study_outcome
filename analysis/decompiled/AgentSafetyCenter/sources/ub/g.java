package ub;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class g {

    /* renamed from: c, reason: collision with root package name */
    public static final g f14298c;

    /* renamed from: f, reason: collision with root package name */
    public static final g f14299f;

    /* renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ g[] f14300g;

    static {
        g gVar = new g("TOP_DOWN", 0);
        f14298c = gVar;
        g gVar2 = new g("BOTTOM_UP", 1);
        f14299f = gVar2;
        g[] gVarArr = {gVar, gVar2};
        f14300g = gVarArr;
        a.a.p(gVarArr);
    }

    public static g valueOf(String str) {
        return (g) Enum.valueOf(g.class, str);
    }

    public static g[] values() {
        return (g[]) f14300g.clone();
    }
}
