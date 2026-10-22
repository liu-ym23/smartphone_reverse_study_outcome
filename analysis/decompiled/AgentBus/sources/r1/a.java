package r1;

import w7.e0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: f, reason: collision with root package name */
    public static final a f8966f;

    /* renamed from: g, reason: collision with root package name */
    public static final a f8967g;

    /* renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ a[] f8968h;

    static {
        a aVar = new a("On", 0);
        f8966f = aVar;
        a aVar2 = new a("Off", 1);
        f8967g = aVar2;
        a[] aVarArr = {aVar, aVar2, new a("Indeterminate", 2)};
        f8968h = aVarArr;
        e0.s(aVarArr);
    }

    public static a valueOf(String str) {
        return (a) Enum.valueOf(a.class, str);
    }

    public static a[] values() {
        return (a[]) f8968h.clone();
    }
}
