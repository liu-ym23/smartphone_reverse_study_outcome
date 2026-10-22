package xa;

import w7.e0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: f, reason: collision with root package name */
    public static final a f11329f;

    /* renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ a[] f11330g;

    static {
        a aVar = new a("NONE", 0);
        a aVar2 = new a("ALL_JSON_OBJECTS", 1);
        a aVar3 = new a("POLYMORPHIC", 2);
        f11329f = aVar3;
        a[] aVarArr = {aVar, aVar2, aVar3};
        f11330g = aVarArr;
        e0.s(aVarArr);
    }

    public static a valueOf(String str) {
        return (a) Enum.valueOf(a.class, str);
    }

    public static a[] values() {
        return (a[]) f11330g.clone();
    }
}
