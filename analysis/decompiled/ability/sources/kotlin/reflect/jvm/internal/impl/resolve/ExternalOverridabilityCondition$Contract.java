package kotlin.reflect.jvm.internal.impl.resolve;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes4.dex */
public final class ExternalOverridabilityCondition$Contract {

    /* renamed from: a, reason: collision with root package name */
    public static final ExternalOverridabilityCondition$Contract f5114a;
    public static final ExternalOverridabilityCondition$Contract b;
    public static final ExternalOverridabilityCondition$Contract c;
    public static final /* synthetic */ ExternalOverridabilityCondition$Contract[] d;

    static {
        ExternalOverridabilityCondition$Contract externalOverridabilityCondition$Contract = new ExternalOverridabilityCondition$Contract("CONFLICTS_ONLY", 0);
        f5114a = externalOverridabilityCondition$Contract;
        ExternalOverridabilityCondition$Contract externalOverridabilityCondition$Contract2 = new ExternalOverridabilityCondition$Contract("SUCCESS_ONLY", 1);
        b = externalOverridabilityCondition$Contract2;
        ExternalOverridabilityCondition$Contract externalOverridabilityCondition$Contract3 = new ExternalOverridabilityCondition$Contract("BOTH", 2);
        c = externalOverridabilityCondition$Contract3;
        d = new ExternalOverridabilityCondition$Contract[]{externalOverridabilityCondition$Contract, externalOverridabilityCondition$Contract2, externalOverridabilityCondition$Contract3};
    }

    public static ExternalOverridabilityCondition$Contract valueOf(String str) {
        return (ExternalOverridabilityCondition$Contract) Enum.valueOf(ExternalOverridabilityCondition$Contract.class, str);
    }

    public static ExternalOverridabilityCondition$Contract[] values() {
        return (ExternalOverridabilityCondition$Contract[]) d.clone();
    }
}
