package kotlin.reflect.jvm.internal.impl.load.java;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes4.dex */
public final class AnnotationQualifierApplicabilityType {
    public static final AnnotationQualifierApplicabilityType b;
    public static final AnnotationQualifierApplicabilityType c;
    public static final AnnotationQualifierApplicabilityType d;
    public static final AnnotationQualifierApplicabilityType e;
    public static final AnnotationQualifierApplicabilityType f;
    public static final /* synthetic */ AnnotationQualifierApplicabilityType[] g;

    /* renamed from: a, reason: collision with root package name */
    public final String f4987a;

    static {
        AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType = new AnnotationQualifierApplicabilityType("METHOD_RETURN_TYPE", 0, "METHOD");
        b = annotationQualifierApplicabilityType;
        AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType2 = new AnnotationQualifierApplicabilityType("VALUE_PARAMETER", 1, "PARAMETER");
        c = annotationQualifierApplicabilityType2;
        AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType3 = new AnnotationQualifierApplicabilityType("FIELD", 2, "FIELD");
        d = annotationQualifierApplicabilityType3;
        AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType4 = new AnnotationQualifierApplicabilityType("TYPE_USE", 3, "TYPE_USE");
        e = annotationQualifierApplicabilityType4;
        AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType5 = new AnnotationQualifierApplicabilityType("TYPE_PARAMETER_BOUNDS", 4, "TYPE_USE");
        f = annotationQualifierApplicabilityType5;
        AnnotationQualifierApplicabilityType[] annotationQualifierApplicabilityTypeArr = {annotationQualifierApplicabilityType, annotationQualifierApplicabilityType2, annotationQualifierApplicabilityType3, annotationQualifierApplicabilityType4, annotationQualifierApplicabilityType5, new AnnotationQualifierApplicabilityType("TYPE_PARAMETER", 5, "TYPE_PARAMETER")};
        g = annotationQualifierApplicabilityTypeArr;
        kotlin.enums.a.a(annotationQualifierApplicabilityTypeArr);
    }

    public AnnotationQualifierApplicabilityType(String str, int i, String str2) {
        this.f4987a = str2;
    }

    public static AnnotationQualifierApplicabilityType valueOf(String str) {
        return (AnnotationQualifierApplicabilityType) Enum.valueOf(AnnotationQualifierApplicabilityType.class, str);
    }

    public static AnnotationQualifierApplicabilityType[] values() {
        return (AnnotationQualifierApplicabilityType[]) g.clone();
    }
}
