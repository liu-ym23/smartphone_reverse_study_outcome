package w7;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class l {

    /* renamed from: f, reason: collision with root package name */
    public static final l f10870f;

    /* renamed from: g, reason: collision with root package name */
    public static final l f10871g;

    /* renamed from: h, reason: collision with root package name */
    public static final l f10872h;

    /* renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ l[] f10873i;

    static {
        l lVar = new l("INSTANCE", 0);
        f10870f = lVar;
        l lVar2 = new l("EXTENSION_RECEIVER", 1);
        f10871g = lVar2;
        l lVar3 = new l("VALUE", 2);
        f10872h = lVar3;
        l[] lVarArr = {lVar, lVar2, lVar3};
        f10873i = lVarArr;
        e0.s(lVarArr);
    }

    public static l valueOf(String str) {
        return (l) Enum.valueOf(l.class, str);
    }

    public static l[] values() {
        return (l[]) f10873i.clone();
    }
}
