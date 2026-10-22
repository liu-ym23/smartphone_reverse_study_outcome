package com.apm.insight.o;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
final class n$a {

    /* renamed from: a, reason: collision with root package name */
    public static final n$a f2195a;
    public static final n$a b;
    public static final n$a c;
    public static final n$a d;
    public static final n$a e;
    public static final n$a f;
    public static final /* synthetic */ n$a[] g;

    static {
        n$a n_a = new n$a("EMPTY_ARRAY", 0);
        f2195a = n_a;
        n$a n_a2 = new n$a("NONEMPTY_ARRAY", 1);
        b = n_a2;
        n$a n_a3 = new n$a("EMPTY_OBJECT", 2);
        c = n_a3;
        n$a n_a4 = new n$a("DANGLING_KEY", 3);
        d = n_a4;
        n$a n_a5 = new n$a("NONEMPTY_OBJECT", 4);
        e = n_a5;
        n$a n_a6 = new n$a("NULL", 5);
        f = n_a6;
        g = new n$a[]{n_a, n_a2, n_a3, n_a4, n_a5, n_a6};
    }

    public static n$a valueOf(String str) {
        return (n$a) Enum.valueOf(n$a.class, str);
    }

    public static n$a[] values() {
        return (n$a[]) g.clone();
    }
}
