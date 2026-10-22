package s0;

import a4.u;
import w7.e0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class p {

    /* renamed from: f, reason: collision with root package name */
    public static final p f9193f;

    /* renamed from: g, reason: collision with root package name */
    public static final p f9194g;

    /* renamed from: h, reason: collision with root package name */
    public static final p f9195h;

    /* renamed from: i, reason: collision with root package name */
    public static final p f9196i;

    /* renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ p[] f9197j;

    static {
        p pVar = new p("Active", 0);
        f9193f = pVar;
        p pVar2 = new p("ActiveParent", 1);
        f9194g = pVar2;
        p pVar3 = new p("Captured", 2);
        f9195h = pVar3;
        p pVar4 = new p("Inactive", 3);
        f9196i = pVar4;
        p[] pVarArr = {pVar, pVar2, pVar3, pVar4};
        f9197j = pVarArr;
        e0.s(pVarArr);
    }

    public static p valueOf(String str) {
        return (p) Enum.valueOf(p.class, str);
    }

    public static p[] values() {
        return (p[]) f9197j.clone();
    }

    public final boolean a() {
        int i2 = o.$EnumSwitchMapping$0[ordinal()];
        if (i2 == 1 || i2 == 2) {
            return true;
        }
        if (i2 == 3 || i2 == 4) {
            return false;
        }
        throw new u();
    }
}
