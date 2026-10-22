package d1;

import w7.e0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: f, reason: collision with root package name */
    public static final c f2769f;

    /* renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ c[] f2770g;

    static {
        c cVar = new c("Lsq2", 0);
        f2769f = cVar;
        c[] cVarArr = {cVar, new c("Impulse", 1)};
        f2770g = cVarArr;
        e0.s(cVarArr);
    }

    public static c valueOf(String str) {
        return (c) Enum.valueOf(c.class, str);
    }

    public static c[] values() {
        return (c[]) f2770g.clone();
    }
}
