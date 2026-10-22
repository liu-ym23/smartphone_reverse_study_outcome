package S9;

import java.util.EnumMap;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType;

/* loaded from: classes5.dex */
public final class B {

    /* renamed from: a, reason: collision with root package name */
    public final EnumMap<AnnotationQualifierApplicabilityType, t> f5671a;

    public B(EnumMap<AnnotationQualifierApplicabilityType, t> defaultQualifiers) {
        kotlin.jvm.internal.p.i(defaultQualifiers, "defaultQualifiers");
        this.f5671a = defaultQualifiers;
    }

    public final t a(AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType) {
        return this.f5671a.get(annotationQualifierApplicabilityType);
    }

    public final EnumMap<AnnotationQualifierApplicabilityType, t> b() {
        return this.f5671a;
    }
}
