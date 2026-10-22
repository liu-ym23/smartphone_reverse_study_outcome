package e8;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class j {

    /* renamed from: f, reason: collision with root package name */
    public static final j f3152f;

    /* renamed from: g, reason: collision with root package name */
    public static final j f3153g;

    /* renamed from: h, reason: collision with root package name */
    public static final j f3154h;

    /* renamed from: i, reason: collision with root package name */
    public static final j f3155i;

    /* renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ j[] f3156j;

    static {
        j jVar = new j("HIDDEN", 0);
        f3152f = jVar;
        j jVar2 = new j("VISIBLE", 1);
        f3153g = jVar2;
        j jVar3 = new j("NOT_CONSIDERED", 2);
        f3154h = jVar3;
        j jVar4 = new j("DROP", 3);
        f3155i = jVar4;
        f3156j = new j[]{jVar, jVar2, jVar3, jVar4};
    }

    public static j valueOf(String str) {
        return (j) Enum.valueOf(j.class, str);
    }

    public static j[] values() {
        return (j[]) f3156j.clone();
    }
}
