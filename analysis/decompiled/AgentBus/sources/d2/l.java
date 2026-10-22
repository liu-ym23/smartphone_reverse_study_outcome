package d2;

import w7.e0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class l {

    /* renamed from: f, reason: collision with root package name */
    public static final l f2793f;

    /* renamed from: g, reason: collision with root package name */
    public static final l f2794g;

    /* renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ l[] f2795h;

    static {
        l lVar = new l("Ltr", 0);
        f2793f = lVar;
        l lVar2 = new l("Rtl", 1);
        f2794g = lVar2;
        l[] lVarArr = {lVar, lVar2};
        f2795h = lVarArr;
        e0.s(lVarArr);
    }

    public static l valueOf(String str) {
        return (l) Enum.valueOf(l.class, str);
    }

    public static l[] values() {
        return (l[]) f2795h.clone();
    }
}
