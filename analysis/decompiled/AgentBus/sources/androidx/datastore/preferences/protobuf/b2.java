package androidx.datastore.preferences.protobuf;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class b2 {

    /* renamed from: f, reason: collision with root package name */
    public static final b2 f824f;

    /* renamed from: g, reason: collision with root package name */
    public static final b2 f825g;

    /* renamed from: h, reason: collision with root package name */
    public static final b2 f826h;

    /* renamed from: i, reason: collision with root package name */
    public static final b2 f827i;

    /* renamed from: j, reason: collision with root package name */
    public static final b2 f828j;

    /* renamed from: k, reason: collision with root package name */
    public static final b2 f829k;

    /* renamed from: l, reason: collision with root package name */
    public static final b2 f830l;

    /* renamed from: m, reason: collision with root package name */
    public static final b2 f831m;

    /* renamed from: n, reason: collision with root package name */
    public static final b2 f832n;

    /* renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ b2[] f833o;

    static {
        b2 b2Var = new b2("INT", 0);
        f824f = b2Var;
        b2 b2Var2 = new b2("LONG", 1);
        f825g = b2Var2;
        b2 b2Var3 = new b2("FLOAT", 2);
        f826h = b2Var3;
        b2 b2Var4 = new b2("DOUBLE", 3);
        f827i = b2Var4;
        b2 b2Var5 = new b2("BOOLEAN", 4);
        f828j = b2Var5;
        b2 b2Var6 = new b2("STRING", 5);
        f829k = b2Var6;
        g gVar = g.f850h;
        b2 b2Var7 = new b2("BYTE_STRING", 6);
        f830l = b2Var7;
        b2 b2Var8 = new b2("ENUM", 7);
        f831m = b2Var8;
        b2 b2Var9 = new b2("MESSAGE", 8);
        f832n = b2Var9;
        f833o = new b2[]{b2Var, b2Var2, b2Var3, b2Var4, b2Var5, b2Var6, b2Var7, b2Var8, b2Var9};
    }

    public static b2 valueOf(String str) {
        return (b2) Enum.valueOf(b2.class, str);
    }

    public static b2[] values() {
        return (b2[]) f833o.clone();
    }
}
