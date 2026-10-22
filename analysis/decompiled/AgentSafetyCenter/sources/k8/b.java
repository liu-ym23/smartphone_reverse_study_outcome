package k8;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: c, reason: collision with root package name */
    public static final b f7279c;

    /* renamed from: f, reason: collision with root package name */
    public static final b f7280f;

    /* renamed from: g, reason: collision with root package name */
    public static final b f7281g;

    /* renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ b[] f7282h;
    public static final /* synthetic */ qb.b i;

    static {
        b bVar = new b("All", 0);
        f7279c = bVar;
        b bVar2 = new b("Intercepted", 1);
        f7280f = bVar2;
        b bVar3 = new b("Undoable", 2);
        f7281g = bVar3;
        b[] bVarArr = {bVar, bVar2, bVar3};
        f7282h = bVarArr;
        i = a.a.p(bVarArr);
    }

    public static b valueOf(String str) {
        return (b) Enum.valueOf(b.class, str);
    }

    public static b[] values() {
        return (b[]) f7282h.clone();
    }
}
