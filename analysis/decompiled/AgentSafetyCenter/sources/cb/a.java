package cb;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ a[] f2239c;

    static {
        a[] aVarArr = {new a("NONE", 0), new a("SINGLE", 1), new a("FIRST", 2), new a("MIDDLE", 3), new a("LAST", 4)};
        f2239c = aVarArr;
        a.a.p(aVarArr);
    }

    public static a valueOf(String str) {
        return (a) Enum.valueOf(a.class, str);
    }

    public static a[] values() {
        return (a[]) f2239c.clone();
    }
}
