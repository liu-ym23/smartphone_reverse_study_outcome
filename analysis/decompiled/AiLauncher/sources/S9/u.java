package S9;

import Z8.C1172u;
import Z8.C1173v;
import aa.C1263k;
import java.util.List;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier;

/* loaded from: classes5.dex */
public final class u {

    /* renamed from: a, reason: collision with root package name */
    public static final List<AnnotationQualifierApplicabilityType> f5771a;

    /* renamed from: b, reason: collision with root package name */
    public static final List<AnnotationQualifierApplicabilityType> f5772b;

    /* renamed from: c, reason: collision with root package name */
    public static final Map<ga.c, t> f5773c;

    /* renamed from: d, reason: collision with root package name */
    public static final Map<ga.c, t> f5774d;

    /* renamed from: e, reason: collision with root package name */
    public static final Map<ga.c, t> f5775e;

    static {
        AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType = AnnotationQualifierApplicabilityType.FIELD;
        AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType2 = AnnotationQualifierApplicabilityType.METHOD_RETURN_TYPE;
        AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType3 = AnnotationQualifierApplicabilityType.VALUE_PARAMETER;
        List<AnnotationQualifierApplicabilityType> listP = C1173v.p(annotationQualifierApplicabilityType, annotationQualifierApplicabilityType2, annotationQualifierApplicabilityType3, AnnotationQualifierApplicabilityType.TYPE_PARAMETER_BOUNDS, AnnotationQualifierApplicabilityType.TYPE_USE);
        f5771a = listP;
        List<AnnotationQualifierApplicabilityType> listE = C1172u.e(annotationQualifierApplicabilityType3);
        f5772b = listE;
        ga.c cVarK = G.k();
        NullabilityQualifier nullabilityQualifier = NullabilityQualifier.NOT_NULL;
        Map<ga.c, t> mapM = kotlin.collections.a.m(Y8.j.a(cVarK, new t(new C1263k(nullabilityQualifier, false, 2, null), listP, false, true)), Y8.j.a(G.i(), new t(new C1263k(nullabilityQualifier, false, 2, null), listP, false, true)), Y8.j.a(G.j(), new t(new C1263k(NullabilityQualifier.FORCE_FLEXIBILITY, false, 2, null), listP, false, true, 4, null)));
        f5773c = mapM;
        Map<ga.c, t> mapM2 = kotlin.collections.a.m(Y8.j.a(G.d(), new t(new C1263k(nullabilityQualifier, false, 2, null), listE, false, false, 12, null)), Y8.j.a(G.e(), new t(new C1263k(NullabilityQualifier.NULLABLE, false, 2, null), listE, false, false, 12, null)));
        f5774d = mapM2;
        f5775e = kotlin.collections.a.r(mapM, mapM2);
    }

    public static final Map<ga.c, t> a() {
        return f5775e;
    }

    public static final Map<ga.c, t> b() {
        return f5773c;
    }
}
