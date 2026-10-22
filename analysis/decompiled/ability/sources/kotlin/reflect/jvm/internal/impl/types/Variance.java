package kotlin.reflect.jvm.internal.impl.types;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes4.dex */
public final class Variance {
    public static final Variance c;
    public static final Variance d;
    public static final Variance e;
    public static final /* synthetic */ Variance[] f;

    /* renamed from: a, reason: collision with root package name */
    public final String f5143a;
    public final boolean b;

    static {
        Variance variance = new Variance("INVARIANT", 0, "", true);
        c = variance;
        Variance variance2 = new Variance("IN_VARIANCE", 1, "in", false);
        d = variance2;
        Variance variance3 = new Variance("OUT_VARIANCE", 2, "out", true);
        e = variance3;
        Variance[] varianceArr = {variance, variance2, variance3};
        f = varianceArr;
        kotlin.enums.a.a(varianceArr);
    }

    public Variance(String str, int i, String str2, boolean z10) {
        this.f5143a = str2;
        this.b = z10;
    }

    public static Variance valueOf(String str) {
        return (Variance) Enum.valueOf(Variance.class, str);
    }

    public static Variance[] values() {
        return (Variance[]) f.clone();
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.f5143a;
    }
}
