package n7;

import w7.e0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class k {

    /* renamed from: f, reason: collision with root package name */
    public static final k f6870f;

    /* renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ k[] f6871g;

    static {
        k kVar = new k("TOP_DOWN", 0);
        k kVar2 = new k("BOTTOM_UP", 1);
        f6870f = kVar2;
        k[] kVarArr = {kVar, kVar2};
        f6871g = kVarArr;
        e0.s(kVarArr);
    }

    public static k valueOf(String str) {
        return (k) Enum.valueOf(k.class, str);
    }

    public static k[] values() {
        return (k[]) f6871g.clone();
    }
}
