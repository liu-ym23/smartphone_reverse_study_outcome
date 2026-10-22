package v5;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public static final l f5989a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ l[] f5990b;

    static {
        l lVar = new l("INVARIANT", 0);
        f5989a = lVar;
        l[] lVarArr = {lVar, new l("IN", 1), new l("OUT", 2)};
        f5990b = lVarArr;
        a.a.F(lVarArr);
    }

    public static l valueOf(String str) {
        return (l) Enum.valueOf(l.class, str);
    }

    public static l[] values() {
        return (l[]) f5990b.clone();
    }
}
