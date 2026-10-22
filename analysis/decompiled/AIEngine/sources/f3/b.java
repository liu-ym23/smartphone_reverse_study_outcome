package f3;

import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.deser.std.StdValueInstantiator;
import com.fasterxml.jackson.databind.introspect.AnnotatedParameter;
import com.fasterxml.jackson.databind.introspect.AnnotatedWithParams;
import java.util.HashMap;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: j, reason: collision with root package name */
    public static final String[] f8687j = {"default", "from-String", "from-int", "from-long", "from-big-integer", "from-double", "from-big-decimal", "from-boolean", "delegate", "property-based", "array-delegate"};

    /* renamed from: a, reason: collision with root package name */
    public final b3.a f8688a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f8689b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f8690c;

    /* renamed from: d, reason: collision with root package name */
    public final AnnotatedWithParams[] f8691d = new AnnotatedWithParams[11];

    /* renamed from: e, reason: collision with root package name */
    public int f8692e = 0;

    /* renamed from: f, reason: collision with root package name */
    public boolean f8693f = false;

    /* renamed from: g, reason: collision with root package name */
    public SettableBeanProperty[] f8694g;
    public SettableBeanProperty[] h;

    /* renamed from: i, reason: collision with root package name */
    public SettableBeanProperty[] f8695i;

    public b(b3.a aVar, MapperConfig<?> mapperConfig) {
        this.f8688a = aVar;
        mapperConfig.getClass();
        this.f8689b = mapperConfig.k(MapperFeature.CAN_OVERRIDE_ACCESS_MODIFIERS);
        this.f8690c = mapperConfig.k(MapperFeature.OVERRIDE_PUBLIC_ACCESS_MODIFIERS);
    }

    public final JavaType a(DeserializationContext deserializationContext, AnnotatedWithParams annotatedWithParams, SettableBeanProperty[] settableBeanPropertyArr) {
        if (!this.f8693f || annotatedWithParams == null) {
            return null;
        }
        int i10 = 0;
        if (settableBeanPropertyArr != null) {
            int length = settableBeanPropertyArr.length;
            int i11 = 0;
            while (true) {
                if (i11 >= length) {
                    break;
                }
                if (settableBeanPropertyArr[i11] == null) {
                    i10 = i11;
                    break;
                }
                i11++;
            }
        }
        MapperConfig<?> mapperConfig = deserializationContext.f3663c;
        JavaType javaTypeT = annotatedWithParams.t(i10);
        AnnotationIntrospector annotationIntrospectorD = mapperConfig.d();
        if (annotationIntrospectorD == null) {
            return javaTypeT;
        }
        AnnotatedParameter annotatedParameterR = annotatedWithParams.r(i10);
        Object objJ = annotationIntrospectorD.j(annotatedParameterR);
        return objJ != null ? javaTypeT.M(deserializationContext.l(objJ)) : annotationIntrospectorD.o0(mapperConfig, annotatedParameterR, javaTypeT);
    }

    public final void b(AnnotatedWithParams annotatedWithParams, boolean z, SettableBeanProperty[] settableBeanPropertyArr, int i10) {
        if (annotatedWithParams.t(i10).w()) {
            if (e(annotatedWithParams, 10, z)) {
                this.h = settableBeanPropertyArr;
            }
        } else if (e(annotatedWithParams, 8, z)) {
            this.f8694g = settableBeanPropertyArr;
        }
    }

    public final void c(AnnotatedWithParams annotatedWithParams, boolean z, SettableBeanProperty[] settableBeanPropertyArr) {
        Integer num;
        if (e(annotatedWithParams, 9, z)) {
            if (settableBeanPropertyArr.length > 1) {
                HashMap map = new HashMap();
                int length = settableBeanPropertyArr.length;
                for (int i10 = 0; i10 < length; i10++) {
                    String str = settableBeanPropertyArr[i10].f3891c.f3755a;
                    if ((!str.isEmpty() || settableBeanPropertyArr[i10].o() == null) && (num = (Integer) map.put(str, Integer.valueOf(i10))) != null) {
                        throw new IllegalArgumentException(String.format("Duplicate creator property \"%s\" (index %s vs %d) for type %s ", str, num, Integer.valueOf(i10), com.fasterxml.jackson.databind.util.a.y(this.f8688a.f3041a.f3690a)));
                    }
                }
            }
            this.f8695i = settableBeanPropertyArr;
        }
    }

    public final StdValueInstantiator d(DeserializationContext deserializationContext) {
        AnnotatedWithParams[] annotatedWithParamsArr = this.f8691d;
        JavaType javaTypeA = a(deserializationContext, annotatedWithParamsArr[8], this.f8694g);
        JavaType javaTypeA2 = a(deserializationContext, annotatedWithParamsArr[10], this.h);
        StdValueInstantiator stdValueInstantiator = new StdValueInstantiator(this.f8688a.f3041a);
        AnnotatedWithParams annotatedWithParams = annotatedWithParamsArr[0];
        AnnotatedWithParams annotatedWithParams2 = annotatedWithParamsArr[8];
        SettableBeanProperty[] settableBeanPropertyArr = this.f8694g;
        AnnotatedWithParams annotatedWithParams3 = annotatedWithParamsArr[9];
        SettableBeanProperty[] settableBeanPropertyArr2 = this.f8695i;
        stdValueInstantiator.f4070c = annotatedWithParams;
        stdValueInstantiator.f4073j = annotatedWithParams2;
        stdValueInstantiator.h = javaTypeA;
        stdValueInstantiator.f4074k = settableBeanPropertyArr;
        stdValueInstantiator.f4071d = annotatedWithParams3;
        stdValueInstantiator.f4072e = settableBeanPropertyArr2;
        AnnotatedWithParams annotatedWithParams4 = annotatedWithParamsArr[10];
        SettableBeanProperty[] settableBeanPropertyArr3 = this.h;
        stdValueInstantiator.f4076m = annotatedWithParams4;
        stdValueInstantiator.f4075l = javaTypeA2;
        stdValueInstantiator.f4077n = settableBeanPropertyArr3;
        stdValueInstantiator.f4078o = annotatedWithParamsArr[1];
        stdValueInstantiator.f4079p = annotatedWithParamsArr[2];
        stdValueInstantiator.f4080q = annotatedWithParamsArr[3];
        stdValueInstantiator.r = annotatedWithParamsArr[4];
        stdValueInstantiator.f4081s = annotatedWithParamsArr[5];
        stdValueInstantiator.f4082t = annotatedWithParamsArr[6];
        stdValueInstantiator.f4083u = annotatedWithParamsArr[7];
        return stdValueInstantiator;
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x009e, code lost:
    
        if (r4.isPrimitive() != false) goto L45;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean e(com.fasterxml.jackson.databind.introspect.AnnotatedWithParams r13, int r14, boolean r15) {
        /*
            r12 = this;
            r0 = 1
            int r1 = r0 << r14
            r12.f8693f = r0
            com.fasterxml.jackson.databind.introspect.AnnotatedWithParams[] r2 = r12.f8691d
            r3 = r2[r14]
            if (r3 == 0) goto Lb4
            int r4 = r12.f8692e
            r4 = r4 & r1
            r5 = 0
            if (r4 == 0) goto L17
            if (r15 != 0) goto L15
            goto La0
        L15:
            r4 = r0
            goto L19
        L17:
            r4 = r15 ^ 1
        L19:
            if (r4 == 0) goto Lb4
            java.lang.Class r4 = r3.getClass()
            java.lang.Class r6 = r13.getClass()
            if (r4 != r6) goto Lb4
            java.lang.Class r4 = r3.u(r5)
            java.lang.Class r6 = r13.u(r5)
            java.lang.String r7 = "implicitly discovered"
            java.lang.String r8 = "explicitly marked"
            java.lang.String[] r9 = f3.b.f8687j
            java.lang.String r10 = "Conflicting %s creators: already had %s creator %s, encountered another: %s"
            if (r4 != r6) goto L82
            java.lang.Class r4 = r13.h()
            java.lang.annotation.Annotation[] r6 = com.fasterxml.jackson.databind.util.a.f4529a
            java.lang.Class<java.lang.Enum> r6 = java.lang.Enum.class
            boolean r4 = r6.isAssignableFrom(r4)
            java.lang.String r11 = "valueOf"
            if (r4 == 0) goto L53
            java.lang.String r4 = r13.d()
            boolean r4 = r11.equals(r4)
            if (r4 == 0) goto L53
            r4 = r0
            goto L54
        L53:
            r4 = r5
        L54:
            if (r4 == 0) goto L57
            goto La0
        L57:
            java.lang.Class r4 = r3.h()
            boolean r4 = r6.isAssignableFrom(r4)
            if (r4 == 0) goto L6c
            java.lang.String r4 = r3.d()
            boolean r4 = r11.equals(r4)
            if (r4 == 0) goto L6c
            r5 = r0
        L6c:
            if (r5 == 0) goto L6f
            goto Lb4
        L6f:
            java.lang.IllegalArgumentException r12 = new java.lang.IllegalArgumentException
            r14 = r9[r14]
            if (r15 == 0) goto L76
            r7 = r8
        L76:
            java.lang.Object[] r13 = new java.lang.Object[]{r14, r7, r3, r13}
            java.lang.String r13 = java.lang.String.format(r10, r13)
            r12.<init>(r13)
            throw r12
        L82:
            boolean r11 = r6.isAssignableFrom(r4)
            if (r11 == 0) goto L89
            goto La0
        L89:
            boolean r11 = r4.isAssignableFrom(r6)
            if (r11 == 0) goto L90
            goto Lb4
        L90:
            boolean r11 = r4.isPrimitive()
            boolean r6 = r6.isPrimitive()
            if (r11 == r6) goto La1
            boolean r3 = r4.isPrimitive()
            if (r3 == 0) goto Lb4
        La0:
            return r5
        La1:
            java.lang.IllegalArgumentException r12 = new java.lang.IllegalArgumentException
            r14 = r9[r14]
            if (r15 == 0) goto La8
            r7 = r8
        La8:
            java.lang.Object[] r13 = new java.lang.Object[]{r14, r7, r3, r13}
            java.lang.String r13 = java.lang.String.format(r10, r13)
            r12.<init>(r13)
            throw r12
        Lb4:
            if (r15 == 0) goto Lbb
            int r15 = r12.f8692e
            r15 = r15 | r1
            r12.f8692e = r15
        Lbb:
            if (r13 == 0) goto Lcc
            boolean r15 = r12.f8689b
            if (r15 == 0) goto Lcc
            java.lang.reflect.AnnotatedElement r15 = r13.b()
            java.lang.reflect.Member r15 = (java.lang.reflect.Member) r15
            boolean r12 = r12.f8690c
            com.fasterxml.jackson.databind.util.a.e(r15, r12)
        Lcc:
            r2[r14] = r13
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: f3.b.e(com.fasterxml.jackson.databind.introspect.AnnotatedWithParams, int, boolean):boolean");
    }
}
