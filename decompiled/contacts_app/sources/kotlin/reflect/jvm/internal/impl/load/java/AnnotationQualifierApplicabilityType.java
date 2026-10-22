package kotlin.reflect.jvm.internal.impl.load.java;

/* JADX INFO: compiled from: AnnotationQualifierApplicabilityType.kt */
/* JADX INFO: loaded from: classes4.dex */
public final enum AnnotationQualifierApplicabilityType extends Enum<AnnotationQualifierApplicabilityType> {
    private static final /* synthetic */ AnnotationQualifierApplicabilityType[] $VALUES = null;
    public static final AnnotationQualifierApplicabilityType FIELD = null;
    public static final AnnotationQualifierApplicabilityType METHOD_RETURN_TYPE = null;
    public static final AnnotationQualifierApplicabilityType TYPE_PARAMETER = null;
    public static final AnnotationQualifierApplicabilityType TYPE_PARAMETER_BOUNDS = null;
    public static final AnnotationQualifierApplicabilityType TYPE_USE = null;
    public static final AnnotationQualifierApplicabilityType VALUE_PARAMETER = null;
    private final String javaTarget;

    private static final /* synthetic */ AnnotationQualifierApplicabilityType[] $values() {
        return new AnnotationQualifierApplicabilityType[]{METHOD_RETURN_TYPE, VALUE_PARAMETER, FIELD, TYPE_USE, TYPE_PARAMETER_BOUNDS, TYPE_PARAMETER};
    }

    public static AnnotationQualifierApplicabilityType valueOf(String r1) {
        return (AnnotationQualifierApplicabilityType) Enum.valueOf(AnnotationQualifierApplicabilityType.class, r1);
    }

    public static AnnotationQualifierApplicabilityType[] values() {
        return (AnnotationQualifierApplicabilityType[]) $VALUES.clone();
    }

    private AnnotationQualifierApplicabilityType(String r1, int r2, String r3) {
        super(r1, r2);
        this.javaTarget = r3;
    }

    public final String getJavaTarget() {
        return this.javaTarget;
    }

    static {
        METHOD_RETURN_TYPE = new AnnotationQualifierApplicabilityType("METHOD_RETURN_TYPE", 0, "METHOD");
        VALUE_PARAMETER = new AnnotationQualifierApplicabilityType("VALUE_PARAMETER", 1, "PARAMETER");
        FIELD = new AnnotationQualifierApplicabilityType("FIELD", 2, "FIELD");
        TYPE_USE = new AnnotationQualifierApplicabilityType("TYPE_USE", 3, "TYPE_USE");
        TYPE_PARAMETER_BOUNDS = new AnnotationQualifierApplicabilityType("TYPE_PARAMETER_BOUNDS", 4, "TYPE_USE");
        TYPE_PARAMETER = new AnnotationQualifierApplicabilityType("TYPE_PARAMETER", 5, "TYPE_PARAMETER");
        $VALUES = $values();
    }
}
