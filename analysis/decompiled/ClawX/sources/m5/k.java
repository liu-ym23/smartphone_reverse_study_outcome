package m5;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public static final k f3923a;

    /* renamed from: b, reason: collision with root package name */
    public static final k f3924b;

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ k[] f3925c;

    static {
        k kVar = new k("TOP_DOWN", 0);
        f3923a = kVar;
        k kVar2 = new k("BOTTOM_UP", 1);
        f3924b = kVar2;
        k[] kVarArr = {kVar, kVar2};
        f3925c = kVarArr;
        a.a.F(kVarArr);
    }

    public static k valueOf(String str) {
        return (k) Enum.valueOf(k.class, str);
    }

    public static k[] values() {
        return (k[]) f3925c.clone();
    }
}
