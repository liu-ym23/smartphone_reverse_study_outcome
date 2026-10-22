package o8;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public class e0 {

    /* renamed from: g, reason: collision with root package name */
    public static final e0 f7807g;

    /* renamed from: h, reason: collision with root package name */
    public static final e0 f7808h;

    /* renamed from: i, reason: collision with root package name */
    public static final e0 f7809i;

    /* renamed from: j, reason: collision with root package name */
    public static final d0 f7810j;

    /* renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ e0[] f7811k;

    /* renamed from: f, reason: collision with root package name */
    public final Object f7812f;

    static {
        e0 e0Var = new e0(0, null, "NULL");
        f7807g = e0Var;
        e0 e0Var2 = new e0(1, -1, "INDEX");
        f7808h = e0Var2;
        e0 e0Var3 = new e0(2, Boolean.FALSE, "FALSE");
        f7809i = e0Var3;
        d0 d0Var = new d0(3, null, "MAP_GET_OR_DEFAULT");
        f7810j = d0Var;
        f7811k = new e0[]{e0Var, e0Var2, e0Var3, d0Var};
    }

    public e0(int i2, Object obj, String str) {
        this.f7812f = obj;
    }

    public static e0 valueOf(String str) {
        return (e0) Enum.valueOf(e0.class, str);
    }

    public static e0[] values() {
        return (e0[]) f7811k.clone();
    }
}
