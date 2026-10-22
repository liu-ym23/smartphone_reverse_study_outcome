package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.introspect.AnnotationCollector;
import com.fasterxml.jackson.databind.util.a;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class c extends i3.f {

    /* renamed from: d, reason: collision with root package name */
    public final a f4200d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f4201e;

    /* renamed from: f, reason: collision with root package name */
    public AnnotatedConstructor f4202f;

    public c(AnnotationIntrospector annotationIntrospector, a aVar, boolean z) {
        super(annotationIntrospector);
        this.f4200d = aVar;
        this.f4201e = z;
    }

    public final i3.c e(a.C0034a c0034a, a.C0034a c0034a2) {
        if (!this.f4201e) {
            return new i3.c(0);
        }
        Annotation[] declaredAnnotations = c0034a.f4533b;
        if (declaredAnnotations == null) {
            declaredAnnotations = c0034a.f4532a.getDeclaredAnnotations();
            c0034a.f4533b = declaredAnnotations;
        }
        AnnotationCollector annotationCollectorB = b(declaredAnnotations);
        if (c0034a2 != null) {
            Annotation[] declaredAnnotations2 = c0034a2.f4533b;
            if (declaredAnnotations2 == null) {
                declaredAnnotations2 = c0034a2.f4532a.getDeclaredAnnotations();
                c0034a2.f4533b = declaredAnnotations2;
            }
            annotationCollectorB = a(annotationCollectorB, declaredAnnotations2);
        }
        return annotationCollectorB.b();
    }

    public final i3.c[] f(Annotation[][] annotationArr, Annotation[][] annotationArr2) {
        if (!this.f4201e) {
            return i3.f.f9504b;
        }
        int length = annotationArr.length;
        i3.c[] cVarArr = new i3.c[length];
        for (int i10 = 0; i10 < length; i10++) {
            AnnotationCollector.NoAnnotations noAnnotations = AnnotationCollector.f4133a;
            AnnotationCollector annotationCollectorA = a(AnnotationCollector.a.f4140b, annotationArr[i10]);
            if (annotationArr2 != null) {
                annotationCollectorA = a(annotationCollectorA, annotationArr2[i10]);
            }
            cVarArr[i10] = annotationCollectorA.b();
        }
        return cVarArr;
    }

    public final AnnotatedMethod g(Method method, i iVar, Method method2) {
        int length = method.getParameterTypes().length;
        AnnotationIntrospector annotationIntrospector = this.f9506a;
        i3.c[] cVarArr = i3.f.f9504b;
        if (annotationIntrospector == null) {
            i3.c cVar = new i3.c(0);
            if (length != 0) {
                cVarArr = new i3.c[length];
                for (int i10 = 0; i10 < length; i10++) {
                    cVarArr[i10] = new i3.c(0);
                }
            }
            return new AnnotatedMethod(iVar, method, cVar, cVarArr);
        }
        if (length == 0) {
            AnnotationCollector annotationCollectorB = b(method.getDeclaredAnnotations());
            if (method2 != null) {
                annotationCollectorB = a(annotationCollectorB, method2.getDeclaredAnnotations());
            }
            return new AnnotatedMethod(iVar, method, annotationCollectorB.b(), cVarArr);
        }
        AnnotationCollector annotationCollectorB2 = b(method.getDeclaredAnnotations());
        if (method2 != null) {
            annotationCollectorB2 = a(annotationCollectorB2, method2.getDeclaredAnnotations());
        }
        return new AnnotatedMethod(iVar, method, annotationCollectorB2.b(), f(method.getParameterAnnotations(), method2 == null ? null : method2.getParameterAnnotations()));
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x008d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.fasterxml.jackson.databind.introspect.AnnotatedConstructor h(com.fasterxml.jackson.databind.util.a.C0034a r10, com.fasterxml.jackson.databind.util.a.C0034a r11) {
        /*
            r9 = this;
            int r0 = r10.f4535d
            java.lang.reflect.Constructor<?> r1 = r10.f4532a
            if (r0 >= 0) goto Ld
            java.lang.Class[] r0 = r1.getParameterTypes()
            int r0 = r0.length
            r10.f4535d = r0
        Ld:
            com.fasterxml.jackson.databind.AnnotationIntrospector r2 = r9.f9506a
            i3.c[] r3 = i3.f.f9504b
            r4 = 0
            com.fasterxml.jackson.databind.introspect.a r5 = r9.f4200d
            if (r2 != 0) goto L33
            com.fasterxml.jackson.databind.introspect.AnnotatedConstructor r9 = new com.fasterxml.jackson.databind.introspect.AnnotatedConstructor
            i3.c r10 = new i3.c
            r10.<init>(r4)
            if (r0 != 0) goto L20
            goto L2f
        L20:
            i3.c[] r3 = new i3.c[r0]
            r11 = r4
        L23:
            if (r11 >= r0) goto L2f
            i3.c r2 = new i3.c
            r2.<init>(r4)
            r3[r11] = r2
            int r11 = r11 + 1
            goto L23
        L2f:
            r9.<init>(r5, r1, r10, r3)
            return r9
        L33:
            if (r0 != 0) goto L3f
            com.fasterxml.jackson.databind.introspect.AnnotatedConstructor r0 = new com.fasterxml.jackson.databind.introspect.AnnotatedConstructor
            i3.c r9 = r9.e(r10, r11)
            r0.<init>(r5, r1, r9, r3)
            return r0
        L3f:
            java.lang.annotation.Annotation[][] r2 = r10.f4534c
            if (r2 != 0) goto L49
            java.lang.annotation.Annotation[][] r2 = r1.getParameterAnnotations()
            r10.f4534c = r2
        L49:
            int r3 = r2.length
            r6 = 0
            if (r0 == r3) goto Lae
            java.lang.Class r3 = r1.getDeclaringClass()
            java.lang.annotation.Annotation[] r7 = com.fasterxml.jackson.databind.util.a.f4529a
            java.lang.Class<java.lang.Enum> r7 = java.lang.Enum.class
            boolean r7 = r7.isAssignableFrom(r3)
            if (r7 == 0) goto L6e
            int r7 = r2.length
            r8 = 2
            int r7 = r7 + r8
            if (r0 != r7) goto L6e
            int r3 = r2.length
            int r3 = r3 + r8
            java.lang.annotation.Annotation[][] r3 = new java.lang.annotation.Annotation[r3][]
            int r7 = r2.length
            java.lang.System.arraycopy(r2, r4, r3, r8, r7)
            i3.c[] r6 = r9.f(r3, r6)
        L6c:
            r2 = r3
            goto L8a
        L6e:
            boolean r3 = r3.isMemberClass()
            if (r3 == 0) goto L8a
            int r3 = r2.length
            r7 = 1
            int r3 = r3 + r7
            if (r0 != r3) goto L8a
            int r3 = r2.length
            int r3 = r3 + r7
            java.lang.annotation.Annotation[][] r3 = new java.lang.annotation.Annotation[r3][]
            int r8 = r2.length
            java.lang.System.arraycopy(r2, r4, r3, r7, r8)
            java.lang.annotation.Annotation[] r2 = i3.f.f9505c
            r3[r4] = r2
            i3.c[] r6 = r9.f(r3, r6)
            goto L6c
        L8a:
            if (r6 == 0) goto L8d
            goto Lc2
        L8d:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.Class r10 = r1.getDeclaringClass()
            java.lang.String r10 = r10.getName()
            java.lang.Integer r11 = java.lang.Integer.valueOf(r0)
            int r0 = r2.length
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.Object[] r10 = new java.lang.Object[]{r10, r11, r0}
            java.lang.String r11 = "Internal error: constructor for %s has mismatch: %d parameters; %d sets of annotations"
            java.lang.String r10 = java.lang.String.format(r11, r10)
            r9.<init>(r10)
            throw r9
        Lae:
            if (r11 != 0) goto Lb1
            goto Lbe
        Lb1:
            java.lang.annotation.Annotation[][] r0 = r11.f4534c
            if (r0 != 0) goto Lbd
            java.lang.reflect.Constructor<?> r0 = r11.f4532a
            java.lang.annotation.Annotation[][] r0 = r0.getParameterAnnotations()
            r11.f4534c = r0
        Lbd:
            r6 = r0
        Lbe:
            i3.c[] r6 = r9.f(r2, r6)
        Lc2:
            com.fasterxml.jackson.databind.introspect.AnnotatedConstructor r0 = new com.fasterxml.jackson.databind.introspect.AnnotatedConstructor
            i3.c r9 = r9.e(r10, r11)
            r0.<init>(r5, r1, r9, r6)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.introspect.c.h(com.fasterxml.jackson.databind.util.a$a, com.fasterxml.jackson.databind.util.a$a):com.fasterxml.jackson.databind.introspect.AnnotatedConstructor");
    }
}
