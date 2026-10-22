package m5;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public static final n f3929a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ n[] f3930b;

    static {
        n nVar = new n("SKIP", 0);
        n nVar2 = new n("TERMINATE", 1);
        f3929a = nVar2;
        n[] nVarArr = {nVar, nVar2};
        f3930b = nVarArr;
        a.a.F(nVarArr);
    }

    public static n valueOf(String str) {
        return (n) Enum.valueOf(n.class, str);
    }

    public static n[] values() {
        return (n[]) f3930b.clone();
    }
}
