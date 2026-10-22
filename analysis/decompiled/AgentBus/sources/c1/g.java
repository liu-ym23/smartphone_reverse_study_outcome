package c1;

import w7.e0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class g {

    /* renamed from: f, reason: collision with root package name */
    public static final g f1797f;

    /* renamed from: g, reason: collision with root package name */
    public static final g f1798g;

    /* renamed from: h, reason: collision with root package name */
    public static final g f1799h;

    /* renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ g[] f1800i;

    static {
        g gVar = new g("Initial", 0);
        f1797f = gVar;
        g gVar2 = new g("Main", 1);
        f1798g = gVar2;
        g gVar3 = new g("Final", 2);
        f1799h = gVar3;
        g[] gVarArr = {gVar, gVar2, gVar3};
        f1800i = gVarArr;
        e0.s(gVarArr);
    }

    public static g valueOf(String str) {
        return (g) Enum.valueOf(g.class, str);
    }

    public static g[] values() {
        return (g[]) f1800i.clone();
    }
}
