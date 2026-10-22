package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

/* JADX INFO: compiled from: typeQualifiers.kt */
/* JADX INFO: loaded from: classes4.dex */
public final enum MutabilityQualifier extends Enum<MutabilityQualifier> {
    private static final /* synthetic */ MutabilityQualifier[] $VALUES = null;
    public static final MutabilityQualifier MUTABLE = null;
    public static final MutabilityQualifier READ_ONLY = null;

    private static final /* synthetic */ MutabilityQualifier[] $values() {
        return new MutabilityQualifier[]{READ_ONLY, MUTABLE};
    }

    public static MutabilityQualifier valueOf(String r1) {
        return (MutabilityQualifier) Enum.valueOf(MutabilityQualifier.class, r1);
    }

    public static MutabilityQualifier[] values() {
        return (MutabilityQualifier[]) $VALUES.clone();
    }

    private MutabilityQualifier(String r1, int r2) {
        super(r1, r2);
    }

    static {
        READ_ONLY = new MutabilityQualifier("READ_ONLY", 0);
        MUTABLE = new MutabilityQualifier("MUTABLE", 1);
        $VALUES = $values();
    }
}
