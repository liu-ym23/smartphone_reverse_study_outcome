package androidx.datastore.preferences.protobuf;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class q1 {

    /* renamed from: a, reason: collision with root package name */
    public static final q1 f546a;

    /* renamed from: b, reason: collision with root package name */
    public static final q1 f547b;

    /* renamed from: c, reason: collision with root package name */
    public static final q1 f548c;
    public static final q1 d;

    /* renamed from: e, reason: collision with root package name */
    public static final q1 f549e;

    /* renamed from: f, reason: collision with root package name */
    public static final q1 f550f;

    /* renamed from: g, reason: collision with root package name */
    public static final q1 f551g;

    /* renamed from: h, reason: collision with root package name */
    public static final q1 f552h;

    /* renamed from: j, reason: collision with root package name */
    public static final q1 f553j;

    /* renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ q1[] f554k;

    static {
        q1 q1Var = new q1("INT", 0);
        f546a = q1Var;
        q1 q1Var2 = new q1("LONG", 1);
        f547b = q1Var2;
        q1 q1Var3 = new q1("FLOAT", 2);
        f548c = q1Var3;
        q1 q1Var4 = new q1("DOUBLE", 3);
        d = q1Var4;
        q1 q1Var5 = new q1("BOOLEAN", 4);
        f549e = q1Var5;
        q1 q1Var6 = new q1("STRING", 5);
        f550f = q1Var6;
        g gVar = g.f473c;
        q1 q1Var7 = new q1("BYTE_STRING", 6);
        f551g = q1Var7;
        q1 q1Var8 = new q1("ENUM", 7);
        f552h = q1Var8;
        q1 q1Var9 = new q1("MESSAGE", 8);
        f553j = q1Var9;
        f554k = new q1[]{q1Var, q1Var2, q1Var3, q1Var4, q1Var5, q1Var6, q1Var7, q1Var8, q1Var9};
    }

    public static q1 valueOf(String str) {
        return (q1) Enum.valueOf(q1.class, str);
    }

    public static q1[] values() {
        return (q1[]) f554k.clone();
    }
}
