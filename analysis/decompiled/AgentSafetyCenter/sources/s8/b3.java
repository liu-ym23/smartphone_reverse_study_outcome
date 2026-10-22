package s8;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b3 {

    /* renamed from: c, reason: collision with root package name */
    public static final b3 f11464c;

    /* renamed from: f, reason: collision with root package name */
    public static final b3 f11465f;

    /* renamed from: g, reason: collision with root package name */
    public static final b3 f11466g;

    /* renamed from: h, reason: collision with root package name */
    public static final b3 f11467h;
    public static final /* synthetic */ b3[] i;

    static {
        b3 b3Var = new b3("Image", 0);
        f11464c = b3Var;
        b3 b3Var2 = new b3("Video", 1);
        f11465f = b3Var2;
        b3 b3Var3 = new b3("Audio", 2);
        f11466g = b3Var3;
        b3 b3Var4 = new b3("Other", 3);
        f11467h = b3Var4;
        b3[] b3VarArr = {b3Var, b3Var2, b3Var3, b3Var4};
        i = b3VarArr;
        a.a.p(b3VarArr);
    }

    public static b3 valueOf(String str) {
        return (b3) Enum.valueOf(b3.class, str);
    }

    public static b3[] values() {
        return (b3[]) i.clone();
    }
}
