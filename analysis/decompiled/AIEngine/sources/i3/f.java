package i3;

import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.introspect.AnnotationCollector;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class f {

    /* renamed from: b, reason: collision with root package name */
    public static final c[] f9504b = new c[0];

    /* renamed from: c, reason: collision with root package name */
    public static final Annotation[] f9505c = new Annotation[0];

    /* renamed from: a, reason: collision with root package name */
    public final AnnotationIntrospector f9506a;

    public f(AnnotationIntrospector annotationIntrospector) {
        this.f9506a = annotationIntrospector;
    }

    public final AnnotationCollector a(AnnotationCollector annotationCollector, Annotation[] annotationArr) {
        for (Annotation annotation : annotationArr) {
            annotationCollector = annotationCollector.a(annotation);
            if (this.f9506a.l0(annotation)) {
                annotationCollector = d(annotationCollector, annotation);
            }
        }
        return annotationCollector;
    }

    public final AnnotationCollector b(Annotation[] annotationArr) {
        AnnotationCollector.NoAnnotations noAnnotations = AnnotationCollector.f4133a;
        AnnotationCollector annotationCollectorA = AnnotationCollector.a.f4140b;
        for (Annotation annotation : annotationArr) {
            annotationCollectorA = annotationCollectorA.a(annotation);
            if (this.f9506a.l0(annotation)) {
                annotationCollectorA = d(annotationCollectorA, annotation);
            }
        }
        return annotationCollectorA;
    }

    public final AnnotationCollector c(AnnotationCollector annotationCollector, Annotation[] annotationArr) {
        for (Annotation annotation : annotationArr) {
            if (!annotationCollector.d(annotation)) {
                annotationCollector = annotationCollector.a(annotation);
                AnnotationIntrospector annotationIntrospector = this.f9506a;
                if (annotationIntrospector.l0(annotation)) {
                    for (Annotation annotation2 : com.fasterxml.jackson.databind.util.a.j(annotation.annotationType())) {
                        if (!(annotation2 instanceof Target) && !(annotation2 instanceof Retention) && !annotationCollector.d(annotation2)) {
                            annotationCollector = annotationCollector.a(annotation2);
                            if (annotationIntrospector.l0(annotation2)) {
                                annotationCollector = d(annotationCollector, annotation2);
                            }
                        }
                    }
                }
            }
        }
        return annotationCollector;
    }

    public final AnnotationCollector d(AnnotationCollector annotationCollector, Annotation annotation) {
        for (Annotation annotation2 : com.fasterxml.jackson.databind.util.a.j(annotation.annotationType())) {
            if (!(annotation2 instanceof Target) && !(annotation2 instanceof Retention)) {
                if (!this.f9506a.l0(annotation2)) {
                    annotationCollector = annotationCollector.a(annotation2);
                } else if (!annotationCollector.d(annotation2)) {
                    annotationCollector = d(annotationCollector.a(annotation2), annotation2);
                }
            }
        }
        return annotationCollector;
    }
}
