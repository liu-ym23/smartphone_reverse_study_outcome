package kotlin.reflect.jvm.internal.impl.resolve;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes4.dex */
public final class ExternalOverridabilityCondition$Result {

    /* renamed from: a, reason: collision with root package name */
    public static final ExternalOverridabilityCondition$Result f5115a;
    public static final ExternalOverridabilityCondition$Result b;
    public static final ExternalOverridabilityCondition$Result c;
    public static final /* synthetic */ ExternalOverridabilityCondition$Result[] d;

    static {
        ExternalOverridabilityCondition$Result externalOverridabilityCondition$Result = new ExternalOverridabilityCondition$Result("OVERRIDABLE", 0);
        f5115a = externalOverridabilityCondition$Result;
        ExternalOverridabilityCondition$Result externalOverridabilityCondition$Result2 = new ExternalOverridabilityCondition$Result("INCOMPATIBLE", 1);
        b = externalOverridabilityCondition$Result2;
        ExternalOverridabilityCondition$Result externalOverridabilityCondition$Result3 = new ExternalOverridabilityCondition$Result("UNKNOWN", 2);
        c = externalOverridabilityCondition$Result3;
        d = new ExternalOverridabilityCondition$Result[]{externalOverridabilityCondition$Result, externalOverridabilityCondition$Result2, externalOverridabilityCondition$Result3};
    }

    public static ExternalOverridabilityCondition$Result valueOf(String str) {
        return (ExternalOverridabilityCondition$Result) Enum.valueOf(ExternalOverridabilityCondition$Result.class, str);
    }

    public static ExternalOverridabilityCondition$Result[] values() {
        return (ExternalOverridabilityCondition$Result[]) d.clone();
    }
}
