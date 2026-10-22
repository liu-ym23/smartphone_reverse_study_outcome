package p0;

import w7.e0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: f, reason: collision with root package name */
    public static final e f8263f;

    /* renamed from: g, reason: collision with root package name */
    public static final e f8264g;

    /* renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ e[] f8265h;

    static {
        e eVar = new e("VIEW_APPEAR", 0);
        f8263f = eVar;
        e eVar2 = new e("VIEW_DISAPPEAR", 1);
        f8264g = eVar2;
        e[] eVarArr = {eVar, eVar2};
        f8265h = eVarArr;
        e0.s(eVarArr);
    }

    public static e valueOf(String str) {
        return (e) Enum.valueOf(e.class, str);
    }

    public static e[] values() {
        return (e[]) f8265h.clone();
    }
}
