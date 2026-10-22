package c2;

import w7.e0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class j {

    /* renamed from: f, reason: collision with root package name */
    public static final j f1871f;

    /* renamed from: g, reason: collision with root package name */
    public static final j f1872g;

    /* renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ j[] f1873h;

    static {
        j jVar = new j("Ltr", 0);
        f1871f = jVar;
        j jVar2 = new j("Rtl", 1);
        f1872g = jVar2;
        j[] jVarArr = {jVar, jVar2};
        f1873h = jVarArr;
        e0.s(jVarArr);
    }

    public static j valueOf(String str) {
        return (j) Enum.valueOf(j.class, str);
    }

    public static j[] values() {
        return (j[]) f1873h.clone();
    }
}
