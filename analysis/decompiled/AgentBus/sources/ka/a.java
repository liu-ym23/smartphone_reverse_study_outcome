package ka;

import w7.e0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: f, reason: collision with root package name */
    public static final a f5661f;

    /* renamed from: g, reason: collision with root package name */
    public static final a f5662g;

    /* renamed from: h, reason: collision with root package name */
    public static final a f5663h;

    /* renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ a[] f5664i;

    static {
        a aVar = new a("SUSPEND", 0);
        f5661f = aVar;
        a aVar2 = new a("DROP_OLDEST", 1);
        f5662g = aVar2;
        a aVar3 = new a("DROP_LATEST", 2);
        f5663h = aVar3;
        a[] aVarArr = {aVar, aVar2, aVar3};
        f5664i = aVarArr;
        e0.s(aVarArr);
    }

    public static a valueOf(String str) {
        return (a) Enum.valueOf(a.class, str);
    }

    public static a[] values() {
        return (a[]) f5664i.clone();
    }
}
