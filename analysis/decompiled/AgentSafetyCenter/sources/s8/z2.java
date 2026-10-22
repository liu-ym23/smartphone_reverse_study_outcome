package s8;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class z2 {

    /* renamed from: c, reason: collision with root package name */
    public static final z2 f12165c;

    /* renamed from: f, reason: collision with root package name */
    public static final z2 f12166f;

    /* renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ z2[] f12167g;

    static {
        z2 z2Var = new z2("Single", 0);
        f12165c = z2Var;
        z2 z2Var2 = new z2("Batch", 1);
        f12166f = z2Var2;
        z2[] z2VarArr = {z2Var, z2Var2};
        f12167g = z2VarArr;
        a.a.p(z2VarArr);
    }

    public static z2 valueOf(String str) {
        return (z2) Enum.valueOf(z2.class, str);
    }

    public static z2[] values() {
        return (z2[]) f12167g.clone();
    }
}
