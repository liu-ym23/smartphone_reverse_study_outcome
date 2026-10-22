package y0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: c, reason: collision with root package name */
    public static final b f15847c;

    /* renamed from: f, reason: collision with root package name */
    public static final b f15848f;

    /* renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ b[] f15849g;

    static {
        b bVar = new b("SHOW_ORIGINAL", 0);
        f15847c = bVar;
        b bVar2 = new b("SHOW_TRANSLATED", 1);
        f15848f = bVar2;
        b[] bVarArr = {bVar, bVar2};
        f15849g = bVarArr;
        a.a.p(bVarArr);
    }

    public static b valueOf(String str) {
        return (b) Enum.valueOf(b.class, str);
    }

    public static b[] values() {
        return (b[]) f15849g.clone();
    }
}
