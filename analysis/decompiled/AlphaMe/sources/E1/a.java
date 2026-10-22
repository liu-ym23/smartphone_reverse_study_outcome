package E1;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f404a;

    /* renamed from: b, reason: collision with root package name */
    public static final a f405b;

    /* renamed from: c, reason: collision with root package name */
    public static final a f406c;

    /* renamed from: d, reason: collision with root package name */
    public static final a f407d;

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ a[] f408e;

    static {
        a aVar = new a("PUBLIC", 0);
        f404a = aVar;
        a aVar2 = new a("PROTECTED", 1);
        a aVar3 = new a("PRIVATE", 2);
        f405b = aVar3;
        a aVar4 = new a("ABSTRACT", 3);
        a aVar5 = new a("DEFAULT", 4);
        a aVar6 = new a("STATIC", 5);
        f406c = aVar6;
        a aVar7 = new a("FINAL", 6);
        f407d = aVar7;
        f408e = new a[]{aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7, new a("TRANSIENT", 7), new a("VOLATILE", 8), new a("SYNCHRONIZED", 9), new a("NATIVE", 10), new a("STRICTFP", 11)};
    }

    public static a valueOf(String str) {
        return (a) Enum.valueOf(a.class, str);
    }

    public static a[] values() {
        return (a[]) f408e.clone();
    }
}
