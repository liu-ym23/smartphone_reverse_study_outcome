package w8;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class h {

    /* renamed from: f, reason: collision with root package name */
    public static final h f10898f;

    /* renamed from: g, reason: collision with root package name */
    public static final h f10899g;

    /* renamed from: h, reason: collision with root package name */
    public static final h f10900h;

    /* renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ h[] f10901i;

    static {
        h hVar = new h("FORCE_FLEXIBILITY", 0);
        f10898f = hVar;
        h hVar2 = new h("NULLABLE", 1);
        f10899g = hVar2;
        h hVar3 = new h("NOT_NULL", 2);
        f10900h = hVar3;
        f10901i = new h[]{hVar, hVar2, hVar3};
    }

    public static h valueOf(String str) {
        return (h) Enum.valueOf(h.class, str);
    }

    public static h[] values() {
        return (h[]) f10901i.clone();
    }
}
