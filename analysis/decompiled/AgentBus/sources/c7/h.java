package c7;

import w7.e0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class h {

    /* renamed from: f, reason: collision with root package name */
    public static final h f1970f;

    /* renamed from: g, reason: collision with root package name */
    public static final h f1971g;

    /* renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ h[] f1972h;

    static {
        h hVar = new h("SYNCHRONIZED", 0);
        h hVar2 = new h("PUBLICATION", 1);
        f1970f = hVar2;
        h hVar3 = new h("NONE", 2);
        f1971g = hVar3;
        h[] hVarArr = {hVar, hVar2, hVar3};
        f1972h = hVarArr;
        e0.s(hVarArr);
    }

    public static h valueOf(String str) {
        return (h) Enum.valueOf(h.class, str);
    }

    public static h[] values() {
        return (h[]) f1972h.clone();
    }
}
