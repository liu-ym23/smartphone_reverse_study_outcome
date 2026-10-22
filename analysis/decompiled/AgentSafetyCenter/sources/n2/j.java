package n2;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class j {

    /* renamed from: c, reason: collision with root package name */
    public static final j f8659c;

    /* renamed from: f, reason: collision with root package name */
    public static final j f8660f;

    /* renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ j[] f8661g;

    static {
        j jVar = new j("Ltr", 0);
        f8659c = jVar;
        j jVar2 = new j("Rtl", 1);
        f8660f = jVar2;
        j[] jVarArr = {jVar, jVar2};
        f8661g = jVarArr;
        a.a.p(jVarArr);
    }

    public static j valueOf(String str) {
        return (j) Enum.valueOf(j.class, str);
    }

    public static j[] values() {
        return (j[]) f8661g.clone();
    }
}
