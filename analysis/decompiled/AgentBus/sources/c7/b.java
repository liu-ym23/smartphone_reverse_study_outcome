package c7;

import w7.e0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: f, reason: collision with root package name */
    public static final b f1963f;

    /* renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ b[] f1964g;

    static {
        b bVar = new b("WARNING", 0);
        f1963f = bVar;
        b[] bVarArr = {bVar, new b("ERROR", 1), new b("HIDDEN", 2)};
        f1964g = bVarArr;
        e0.s(bVarArr);
    }

    public static b valueOf(String str) {
        return (b) Enum.valueOf(b.class, str);
    }

    public static b[] values() {
        return (b[]) f1964g.clone();
    }
}
