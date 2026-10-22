package g9;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class o {

    /* renamed from: f, reason: collision with root package name */
    public static final o f3992f;

    /* renamed from: g, reason: collision with root package name */
    public static final o f3993g;

    /* renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ o[] f3994h;

    static {
        o oVar = new o("RENDER_OVERRIDE", 0);
        f3992f = oVar;
        o oVar2 = new o("RENDER_OPEN", 1);
        f3993g = oVar2;
        f3994h = new o[]{oVar, oVar2, new o("RENDER_OPEN_OVERRIDE", 2)};
    }

    public static o valueOf(String str) {
        return (o) Enum.valueOf(o.class, str);
    }

    public static o[] values() {
        return (o[]) f3994h.clone();
    }
}
