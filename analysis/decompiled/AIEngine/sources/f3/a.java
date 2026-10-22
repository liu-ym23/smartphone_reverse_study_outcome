package f3;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.introspect.AnnotatedParameter;
import com.fasterxml.jackson.databind.introspect.AnnotatedWithParams;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final AnnotationIntrospector f8680a;

    /* renamed from: b, reason: collision with root package name */
    public final AnnotatedWithParams f8681b;

    /* renamed from: c, reason: collision with root package name */
    public final int f8682c;

    /* renamed from: d, reason: collision with root package name */
    public final C0079a[] f8683d;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    /* renamed from: f3.a$a, reason: collision with other inner class name */
    public static final class C0079a {

        /* renamed from: a, reason: collision with root package name */
        public final AnnotatedParameter f8684a;

        /* renamed from: b, reason: collision with root package name */
        public final i3.e f8685b;

        /* renamed from: c, reason: collision with root package name */
        public final JacksonInject.Value f8686c;

        public C0079a(AnnotatedParameter annotatedParameter, i3.e eVar, JacksonInject.Value value) {
            this.f8684a = annotatedParameter;
            this.f8685b = eVar;
            this.f8686c = value;
        }
    }

    public a(AnnotationIntrospector annotationIntrospector, AnnotatedWithParams annotatedWithParams, C0079a[] c0079aArr, int i10) {
        this.f8680a = annotationIntrospector;
        this.f8681b = annotatedWithParams;
        this.f8683d = c0079aArr;
        this.f8682c = i10;
    }

    public static a a(AnnotationIntrospector annotationIntrospector, AnnotatedWithParams annotatedWithParams, i3.e[] eVarArr) {
        int iS = annotatedWithParams.s();
        C0079a[] c0079aArr = new C0079a[iS];
        for (int i10 = 0; i10 < iS; i10++) {
            AnnotatedParameter annotatedParameterR = annotatedWithParams.r(i10);
            c0079aArr[i10] = new C0079a(annotatedParameterR, eVarArr == null ? null : eVarArr[i10], annotationIntrospector.p(annotatedParameterR));
        }
        return new a(annotationIntrospector, annotatedWithParams, c0079aArr, iS);
    }

    public final PropertyName b(int i10) {
        String strO = this.f8680a.o(this.f8683d[i10].f8684a);
        if (strO == null || strO.isEmpty()) {
            return null;
        }
        return PropertyName.a(strO);
    }

    public final PropertyName c(int i10) {
        i3.e eVar = this.f8683d[i10].f8685b;
        if (eVar != null) {
            return eVar.b();
        }
        return null;
    }

    public final i3.e d(int i10) {
        return this.f8683d[i10].f8685b;
    }

    public final String toString() {
        return this.f8681b.toString();
    }
}
