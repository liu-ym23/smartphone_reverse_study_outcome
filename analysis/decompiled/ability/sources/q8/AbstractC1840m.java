package q8;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier;
import y8.C2143f;

/* renamed from: q8.m, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC1840m {

    /* renamed from: a, reason: collision with root package name */
    public static final List f5604a;
    public static final List b;
    public static final Object c;
    public static final Object d;
    public static final LinkedHashMap e;

    static {
        AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType = AnnotationQualifierApplicabilityType.d;
        AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType2 = AnnotationQualifierApplicabilityType.b;
        AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType3 = AnnotationQualifierApplicabilityType.c;
        List listN = H4.o.N(annotationQualifierApplicabilityType, annotationQualifierApplicabilityType2, annotationQualifierApplicabilityType3, AnnotationQualifierApplicabilityType.f, AnnotationQualifierApplicabilityType.e);
        f5604a = listN;
        List listM = H4.o.M(annotationQualifierApplicabilityType3);
        b = listM;
        G8.c cVar = v.f5614a;
        NullabilityQualifier nullabilityQualifier = NullabilityQualifier.c;
        List list = listN;
        Map mapR = kotlin.collections.a.R(new Pair(cVar, new C1839l(new C2143f(nullabilityQualifier), list, false)), new Pair(v.b, new C1839l(new C2143f(nullabilityQualifier), list, false)), new Pair(v.c, new C1839l(new C2143f(NullabilityQualifier.f5005a), list)));
        c = mapR;
        List list2 = listM;
        Map mapR2 = kotlin.collections.a.R(new Pair(v.h, new C1839l(new C2143f(nullabilityQualifier), list2)), new Pair(v.i, new C1839l(new C2143f(NullabilityQualifier.b), list2)));
        d = mapR2;
        e = kotlin.collections.a.T(mapR, mapR2);
    }
}
