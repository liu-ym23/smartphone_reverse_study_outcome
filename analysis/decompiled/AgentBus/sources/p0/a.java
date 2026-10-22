package p0;

import w7.e0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: f, reason: collision with root package name */
    public static final a f8237f;

    /* renamed from: g, reason: collision with root package name */
    public static final a f8238g;

    /* renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ a[] f8239h;

    static {
        a aVar = new a("SHOW_ORIGINAL", 0);
        f8237f = aVar;
        a aVar2 = new a("SHOW_TRANSLATED", 1);
        f8238g = aVar2;
        a[] aVarArr = {aVar, aVar2};
        f8239h = aVarArr;
        e0.s(aVarArr);
    }

    public static a valueOf(String str) {
        return (a) Enum.valueOf(a.class, str);
    }

    public static a[] values() {
        return (a[]) f8239h.clone();
    }
}
