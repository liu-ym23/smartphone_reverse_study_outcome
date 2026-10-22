package b;

import w7.e0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: f, reason: collision with root package name */
    public static final a f1049f;

    /* renamed from: g, reason: collision with root package name */
    public static final a f1050g;

    /* renamed from: h, reason: collision with root package name */
    public static final a f1051h;

    /* renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ a[] f1052i;

    static {
        a aVar = new a("NOT_INITIALIZED", 0);
        f1049f = aVar;
        a aVar2 = new a("INITIALIZING", 1);
        f1050g = aVar2;
        a aVar3 = new a("READY", 2);
        f1051h = aVar3;
        a[] aVarArr = {aVar, aVar2, aVar3};
        f1052i = aVarArr;
        e0.s(aVarArr);
    }

    public static a valueOf(String str) {
        return (a) Enum.valueOf(a.class, str);
    }

    public static a[] values() {
        return (a[]) f1052i.clone();
    }
}
