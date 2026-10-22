package cc.dd.dd.cc.dd.ff;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public final class a$a {

    /* renamed from: a, reason: collision with root package name */
    public static final a$a f2134a;
    public static final a$a b;
    public static final a$a c;
    public static final /* synthetic */ a$a[] d;

    static {
        a$a a_a = new a$a("READY", 0);
        f2134a = a_a;
        a$a a_a2 = new a$a("SENT", 1);
        b = a_a2;
        a$a a_a3 = new a$a("COMPLETE", 2);
        c = a_a3;
        d = new a$a[]{a_a, a_a2, a_a3};
    }

    public static a$a valueOf(String str) {
        return (a$a) Enum.valueOf(a$a.class, str);
    }

    public static a$a[] values() {
        return (a$a[]) d.clone();
    }
}
