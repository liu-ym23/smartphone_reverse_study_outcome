package b1;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class p {

    /* renamed from: c, reason: collision with root package name */
    public static final p f1844c;

    /* renamed from: f, reason: collision with root package name */
    public static final p f1845f;

    /* renamed from: g, reason: collision with root package name */
    public static final p f1846g;

    /* renamed from: h, reason: collision with root package name */
    public static final p f1847h;
    public static final /* synthetic */ p[] i;

    static {
        p pVar = new p("Active", 0);
        f1844c = pVar;
        p pVar2 = new p("ActiveParent", 1);
        f1845f = pVar2;
        p pVar3 = new p("Captured", 2);
        f1846g = pVar3;
        p pVar4 = new p("Inactive", 3);
        f1847h = pVar4;
        p[] pVarArr = {pVar, pVar2, pVar3, pVar4};
        i = pVarArr;
        a.a.p(pVarArr);
    }

    public static p valueOf(String str) {
        return (p) Enum.valueOf(p.class, str);
    }

    public static p[] values() {
        return (p[]) i.clone();
    }

    public final boolean a() {
        int iOrdinal = ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal == 1) {
                return false;
            }
            if (iOrdinal != 2) {
                if (iOrdinal == 3) {
                    return false;
                }
                g5.f.a();
                return false;
            }
        }
        return true;
    }
}
