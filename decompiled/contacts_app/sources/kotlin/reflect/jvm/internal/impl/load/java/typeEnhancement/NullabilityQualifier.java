package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

/* JADX INFO: compiled from: typeQualifiers.kt */
/* JADX INFO: loaded from: classes4.dex */
public final enum NullabilityQualifier extends Enum<NullabilityQualifier> {
    private static final /* synthetic */ NullabilityQualifier[] $VALUES = null;
    public static final NullabilityQualifier FORCE_FLEXIBILITY = null;
    public static final NullabilityQualifier NOT_NULL = null;
    public static final NullabilityQualifier NULLABLE = null;

    private static final /* synthetic */ NullabilityQualifier[] $values() {
        return new NullabilityQualifier[]{FORCE_FLEXIBILITY, NULLABLE, NOT_NULL};
    }

    public static NullabilityQualifier valueOf(String r1) {
        return (NullabilityQualifier) Enum.valueOf(NullabilityQualifier.class, r1);
    }

    public static NullabilityQualifier[] values() {
        return (NullabilityQualifier[]) $VALUES.clone();
    }

    private NullabilityQualifier(String r1, int r2) {
        super(r1, r2);
    }

    static {
        FORCE_FLEXIBILITY = new NullabilityQualifier("FORCE_FLEXIBILITY", 0);
        NULLABLE = new NullabilityQualifier("NULLABLE", 1);
        NOT_NULL = new NullabilityQualifier("NOT_NULL", 2);
        $VALUES = $values();
    }
}
