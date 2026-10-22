package h7;

import w7.e0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: f, reason: collision with root package name */
    public static final a f4212f;

    /* renamed from: g, reason: collision with root package name */
    public static final a f4213g;

    /* renamed from: h, reason: collision with root package name */
    public static final a f4214h;

    /* renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ a[] f4215i;

    static {
        a aVar = new a("COROUTINE_SUSPENDED", 0);
        f4212f = aVar;
        a aVar2 = new a("UNDECIDED", 1);
        f4213g = aVar2;
        a aVar3 = new a("RESUMED", 2);
        f4214h = aVar3;
        a[] aVarArr = {aVar, aVar2, aVar3};
        f4215i = aVarArr;
        e0.s(aVarArr);
    }

    public static a valueOf(String str) {
        return (a) Enum.valueOf(a.class, str);
    }

    public static a[] values() {
        return (a[]) f4215i.clone();
    }
}
