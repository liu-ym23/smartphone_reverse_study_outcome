package v5;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class l {

    /* renamed from: c, reason: collision with root package name */
    public static final l f14795c;

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ l[] f14796f;

    static {
        l lVar = new l("IGNORE", 0);
        l lVar2 = new l("RESPECT_PERFORMANCE", 1);
        f14795c = lVar2;
        l[] lVarArr = {lVar, lVar2, new l("RESPECT_ALL", 2)};
        f14796f = lVarArr;
        a.a.p(lVarArr);
    }

    public static l valueOf(String str) {
        return (l) Enum.valueOf(l.class, str);
    }

    public static l[] values() {
        return (l[]) f14796f.clone();
    }
}
