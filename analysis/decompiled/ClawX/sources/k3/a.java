package k3;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f3577a;

    /* renamed from: b, reason: collision with root package name */
    public static final a f3578b;

    /* renamed from: c, reason: collision with root package name */
    public static final a f3579c;
    public static final a d;

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ a[] f3580e;

    static {
        a aVar = new a("ULTRA_BIG", 0);
        f3577a = aVar;
        a aVar2 = new a("BIG", 1);
        f3578b = aVar2;
        a aVar3 = new a("MEDIUM", 2);
        f3579c = aVar3;
        a aVar4 = new a("SMALL", 3);
        d = aVar4;
        a[] aVarArr = {aVar, aVar2, aVar3, aVar4};
        f3580e = aVarArr;
        a.a.F(aVarArr);
    }

    public static a valueOf(String str) {
        return (a) Enum.valueOf(a.class, str);
    }

    public static a[] values() {
        return (a[]) f3580e.clone();
    }
}
