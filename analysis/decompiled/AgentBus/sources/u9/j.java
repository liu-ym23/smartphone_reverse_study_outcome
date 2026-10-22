package u9;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class j {

    /* renamed from: f, reason: collision with root package name */
    public static final j f10202f;

    /* renamed from: g, reason: collision with root package name */
    public static final j f10203g;

    /* renamed from: h, reason: collision with root package name */
    public static final j f10204h;

    /* renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ j[] f10205i;

    static {
        j jVar = new j("NOT_COMPUTED", 0);
        f10202f = jVar;
        j jVar2 = new j("COMPUTING", 1);
        f10203g = jVar2;
        j jVar3 = new j("RECURSION_WAS_DETECTED", 2);
        f10204h = jVar3;
        f10205i = new j[]{jVar, jVar2, jVar3};
    }

    public static j valueOf(String str) {
        return (j) Enum.valueOf(j.class, str);
    }

    public static j[] values() {
        return (j[]) f10205i.clone();
    }
}
