package n6;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class y {

    /* renamed from: b, reason: collision with root package name */
    public static final b f4166b;

    /* renamed from: c, reason: collision with root package name */
    public static final y f4167c;
    public static final y d;

    /* renamed from: e, reason: collision with root package name */
    public static final y f4168e;

    /* renamed from: f, reason: collision with root package name */
    public static final y f4169f;

    /* renamed from: g, reason: collision with root package name */
    public static final y f4170g;

    /* renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ y[] f4171h;

    /* renamed from: a, reason: collision with root package name */
    public final String f4172a;

    static {
        y yVar = new y("TLS_1_3", 0, "TLSv1.3");
        f4167c = yVar;
        y yVar2 = new y("TLS_1_2", 1, "TLSv1.2");
        d = yVar2;
        y yVar3 = new y("TLS_1_1", 2, "TLSv1.1");
        f4168e = yVar3;
        y yVar4 = new y("TLS_1_0", 3, "TLSv1");
        f4169f = yVar4;
        y yVar5 = new y("SSL_3_0", 4, "SSLv3");
        f4170g = yVar5;
        y[] yVarArr = {yVar, yVar2, yVar3, yVar4, yVar5};
        f4171h = yVarArr;
        a.a.F(yVarArr);
        f4166b = new b();
    }

    public y(String str, int i8, String str2) {
        this.f4172a = str2;
    }

    public static y valueOf(String str) {
        return (y) Enum.valueOf(y.class, str);
    }

    public static y[] values() {
        return (y[]) f4171h.clone();
    }
}
