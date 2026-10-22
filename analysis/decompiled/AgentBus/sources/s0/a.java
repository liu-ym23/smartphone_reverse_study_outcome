package s0;

import w7.e0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: f, reason: collision with root package name */
    public static final a f9162f;

    /* renamed from: g, reason: collision with root package name */
    public static final a f9163g;

    /* renamed from: h, reason: collision with root package name */
    public static final a f9164h;

    /* renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ a[] f9165i;

    static {
        a aVar = new a("None", 0);
        f9162f = aVar;
        a aVar2 = new a("Cancelled", 1);
        f9163g = aVar2;
        a aVar3 = new a("Redirected", 2);
        f9164h = aVar3;
        a[] aVarArr = {aVar, aVar2, aVar3, new a("RedirectCancelled", 3)};
        f9165i = aVarArr;
        e0.s(aVarArr);
    }

    public static a valueOf(String str) {
        return (a) Enum.valueOf(a.class, str);
    }

    public static a[] values() {
        return (a[]) f9165i.clone();
    }
}
