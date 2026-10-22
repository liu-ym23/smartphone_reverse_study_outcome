package kotlin.reflect.jvm.internal.impl.resolve;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes4.dex */
public final class OverridingUtil$OverrideCompatibilityInfo$Result {

    /* renamed from: a, reason: collision with root package name */
    public static final OverridingUtil$OverrideCompatibilityInfo$Result f5116a;
    public static final OverridingUtil$OverrideCompatibilityInfo$Result b;
    public static final OverridingUtil$OverrideCompatibilityInfo$Result c;
    public static final /* synthetic */ OverridingUtil$OverrideCompatibilityInfo$Result[] d;

    static {
        OverridingUtil$OverrideCompatibilityInfo$Result overridingUtil$OverrideCompatibilityInfo$Result = new OverridingUtil$OverrideCompatibilityInfo$Result("OVERRIDABLE", 0);
        f5116a = overridingUtil$OverrideCompatibilityInfo$Result;
        OverridingUtil$OverrideCompatibilityInfo$Result overridingUtil$OverrideCompatibilityInfo$Result2 = new OverridingUtil$OverrideCompatibilityInfo$Result("INCOMPATIBLE", 1);
        b = overridingUtil$OverrideCompatibilityInfo$Result2;
        OverridingUtil$OverrideCompatibilityInfo$Result overridingUtil$OverrideCompatibilityInfo$Result3 = new OverridingUtil$OverrideCompatibilityInfo$Result("CONFLICT", 2);
        c = overridingUtil$OverrideCompatibilityInfo$Result3;
        d = new OverridingUtil$OverrideCompatibilityInfo$Result[]{overridingUtil$OverrideCompatibilityInfo$Result, overridingUtil$OverrideCompatibilityInfo$Result2, overridingUtil$OverrideCompatibilityInfo$Result3};
    }

    public static OverridingUtil$OverrideCompatibilityInfo$Result valueOf(String str) {
        return (OverridingUtil$OverrideCompatibilityInfo$Result) Enum.valueOf(OverridingUtil$OverrideCompatibilityInfo$Result.class, str);
    }

    public static OverridingUtil$OverrideCompatibilityInfo$Result[] values() {
        return (OverridingUtil$OverrideCompatibilityInfo$Result[]) d.clone();
    }
}
