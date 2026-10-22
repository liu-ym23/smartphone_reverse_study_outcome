package g8;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class o {

    /* renamed from: f, reason: collision with root package name */
    public static final o f3898f;

    /* renamed from: g, reason: collision with root package name */
    public static final o f3899g;

    /* renamed from: h, reason: collision with root package name */
    public static final o f3900h;

    /* renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ o[] f3901i;

    static {
        o oVar = new o("RUNTIME", 0);
        f3898f = oVar;
        o oVar2 = new o("BINARY", 1);
        f3899g = oVar2;
        o oVar3 = new o("SOURCE", 2);
        f3900h = oVar3;
        f3901i = new o[]{oVar, oVar2, oVar3};
    }

    public static o valueOf(String str) {
        return (o) Enum.valueOf(o.class, str);
    }

    public static o[] values() {
        return (o[]) f3901i.clone();
    }
}
