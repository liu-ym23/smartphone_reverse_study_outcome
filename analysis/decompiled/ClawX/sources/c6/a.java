package c6;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f1102a;

    /* renamed from: b, reason: collision with root package name */
    public static final a f1103b;

    /* renamed from: c, reason: collision with root package name */
    public static final a f1104c;
    public static final /* synthetic */ a[] d;

    static {
        a aVar = new a("SUSPEND", 0);
        f1102a = aVar;
        a aVar2 = new a("DROP_OLDEST", 1);
        f1103b = aVar2;
        a aVar3 = new a("DROP_LATEST", 2);
        f1104c = aVar3;
        a[] aVarArr = {aVar, aVar2, aVar3};
        d = aVarArr;
        a.a.F(aVarArr);
    }

    public static a valueOf(String str) {
        return (a) Enum.valueOf(a.class, str);
    }

    public static a[] values() {
        return (a[]) d.clone();
    }
}
