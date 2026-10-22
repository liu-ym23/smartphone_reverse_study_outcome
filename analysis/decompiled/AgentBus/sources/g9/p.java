package g9;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class p {

    /* renamed from: f, reason: collision with root package name */
    public static final p f3995f;

    /* renamed from: g, reason: collision with root package name */
    public static final p f3996g;

    /* renamed from: h, reason: collision with root package name */
    public static final p f3997h;

    /* renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ p[] f3998i;

    static {
        p pVar = new p("ALL", 0);
        f3995f = pVar;
        p pVar2 = new p("ONLY_NON_SYNTHESIZED", 1);
        f3996g = pVar2;
        p pVar3 = new p("NONE", 2);
        f3997h = pVar3;
        f3998i = new p[]{pVar, pVar2, pVar3};
    }

    public static p valueOf(String str) {
        return (p) Enum.valueOf(p.class, str);
    }

    public static p[] values() {
        return (p[]) f3998i.clone();
    }
}
