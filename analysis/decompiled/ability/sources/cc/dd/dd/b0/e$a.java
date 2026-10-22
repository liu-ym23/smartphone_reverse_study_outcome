package cc.dd.dd.b0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public final class e$a {

    /* renamed from: a, reason: collision with root package name */
    public static final e$a f2131a;
    public static final e$a b;
    public static final e$a c;
    public static final e$a d;
    public static final e$a e;
    public static final e$a f;
    public static final /* synthetic */ e$a[] g;

    static {
        e$a e_a = new e$a("EMPTY_ARRAY", 0);
        f2131a = e_a;
        e$a e_a2 = new e$a("NONEMPTY_ARRAY", 1);
        b = e_a2;
        e$a e_a3 = new e$a("EMPTY_OBJECT", 2);
        c = e_a3;
        e$a e_a4 = new e$a("DANGLING_KEY", 3);
        d = e_a4;
        e$a e_a5 = new e$a("NONEMPTY_OBJECT", 4);
        e = e_a5;
        e$a e_a6 = new e$a("NULL", 5);
        f = e_a6;
        g = new e$a[]{e_a, e_a2, e_a3, e_a4, e_a5, e_a6};
    }

    public static e$a valueOf(String str) {
        return (e$a) Enum.valueOf(e$a.class, str);
    }

    public static e$a[] values() {
        return (e$a[]) g.clone();
    }
}
