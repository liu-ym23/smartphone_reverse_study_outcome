package com.fasterxml.jackson.databind.ser.std;

import b3.f;
import b3.h;
import c3.a;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.type.WritableTypeId;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ser.ContainerSerializer;
import com.fasterxml.jackson.databind.ser.impl.a;
import com.fasterxml.jackson.databind.type.SimpleType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.IgnorePropertiesUtil;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import k3.e;
import n3.c;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@a
/* loaded from: classes.dex */
public class MapSerializer extends ContainerSerializer<Map<?, ?>> implements c {

    /* renamed from: u, reason: collision with root package name */
    public static final SimpleType f4374u = TypeFactory.n();

    /* renamed from: v, reason: collision with root package name */
    public static final JsonInclude.Include f4375v = JsonInclude.Include.f3466c;

    /* renamed from: c, reason: collision with root package name */
    public final BeanProperty f4376c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f4377d;

    /* renamed from: e, reason: collision with root package name */
    public final JavaType f4378e;
    public final JavaType h;

    /* renamed from: j, reason: collision with root package name */
    public final f<Object> f4379j;

    /* renamed from: k, reason: collision with root package name */
    public final f<Object> f4380k;

    /* renamed from: l, reason: collision with root package name */
    public final e f4381l;

    /* renamed from: m, reason: collision with root package name */
    public com.fasterxml.jackson.databind.ser.impl.a f4382m;

    /* renamed from: n, reason: collision with root package name */
    public final Set<String> f4383n;

    /* renamed from: o, reason: collision with root package name */
    public final Set<String> f4384o;

    /* renamed from: p, reason: collision with root package name */
    public final Object f4385p;

    /* renamed from: q, reason: collision with root package name */
    public final Object f4386q;
    public final boolean r;

    /* renamed from: s, reason: collision with root package name */
    public final IgnorePropertiesUtil.Checker f4387s;

    /* renamed from: t, reason: collision with root package name */
    public final boolean f4388t;

    public MapSerializer(Set<String> set, Set<String> set2, JavaType javaType, JavaType javaType2, boolean z, e eVar, f<?> fVar, f<?> fVar2) {
        super(Map.class, 0);
        set = (set == null || set.isEmpty()) ? null : set;
        this.f4383n = set;
        this.f4384o = set2;
        this.f4378e = javaType;
        this.h = javaType2;
        this.f4377d = z;
        this.f4381l = eVar;
        this.f4379j = fVar;
        this.f4380k = fVar2;
        this.f4382m = a.b.f4334a;
        this.f4376c = null;
        this.f4385p = null;
        this.f4388t = false;
        this.f4386q = null;
        this.r = false;
        this.f4387s = IgnorePropertiesUtil.a(set, set2);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0059 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.fasterxml.jackson.databind.ser.std.MapSerializer q(java.util.Set<java.lang.String> r11, java.util.Set<java.lang.String> r12, com.fasterxml.jackson.databind.JavaType r13, boolean r14, k3.e r15, b3.f<java.lang.Object> r16, b3.f<java.lang.Object> r17, java.lang.Object r18) {
        /*
            r0 = r18
            if (r13 != 0) goto L9
            com.fasterxml.jackson.databind.type.SimpleType r13 = com.fasterxml.jackson.databind.ser.std.MapSerializer.f4374u
            r5 = r13
            r6 = r5
            goto L21
        L9:
            com.fasterxml.jackson.databind.JavaType r1 = r13.o()
            java.lang.Class<java.util.Properties> r2 = java.util.Properties.class
            boolean r2 = r13.u(r2)
            if (r2 == 0) goto L1c
            com.fasterxml.jackson.databind.type.SimpleType r13 = com.fasterxml.jackson.databind.type.TypeFactory.n()
        L19:
            r6 = r13
            r5 = r1
            goto L21
        L1c:
            com.fasterxml.jackson.databind.JavaType r13 = r13.k()
            goto L19
        L21:
            r13 = 0
            if (r14 != 0) goto L37
            if (r6 == 0) goto L34
            java.lang.Class<?> r14 = r6.f3690a
            int r14 = r14.getModifiers()
            boolean r14 = java.lang.reflect.Modifier.isFinal(r14)
            if (r14 == 0) goto L34
            r14 = 1
            goto L35
        L34:
            r14 = r13
        L35:
            r7 = r14
            goto L3e
        L37:
            java.lang.Class<?> r1 = r6.f3690a
            java.lang.Class<java.lang.Object> r2 = java.lang.Object.class
            if (r1 != r2) goto L35
            r7 = r13
        L3e:
            com.fasterxml.jackson.databind.ser.std.MapSerializer r2 = new com.fasterxml.jackson.databind.ser.std.MapSerializer
            r3 = r11
            r4 = r12
            r8 = r15
            r9 = r16
            r10 = r17
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10)
            if (r0 == 0) goto L59
            java.lang.String r11 = "withFilterId"
            java.lang.Class<com.fasterxml.jackson.databind.ser.std.MapSerializer> r12 = com.fasterxml.jackson.databind.ser.std.MapSerializer.class
            com.fasterxml.jackson.databind.util.a.E(r12, r2, r11)
            com.fasterxml.jackson.databind.ser.std.MapSerializer r11 = new com.fasterxml.jackson.databind.ser.std.MapSerializer
            r11.<init>(r2, r0, r13)
            return r11
        L59:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ser.std.MapSerializer.q(java.util.Set, java.util.Set, com.fasterxml.jackson.databind.JavaType, boolean, k3.e, b3.f, b3.f, java.lang.Object):com.fasterxml.jackson.databind.ser.std.MapSerializer");
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x012e  */
    @Override // n3.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final b3.f<?> a(b3.h r18, com.fasterxml.jackson.databind.BeanProperty r19) {
        /*
            Method dump skipped, instructions count: 403
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ser.std.MapSerializer.a(b3.h, com.fasterxml.jackson.databind.BeanProperty):b3.f");
    }

    @Override // b3.f
    public final boolean d(h hVar, Object obj) {
        Map map = (Map) obj;
        if (!map.isEmpty()) {
            boolean z = this.r;
            Object obj2 = this.f4386q;
            if (obj2 != null || z) {
                boolean z3 = f4375v == obj2;
                f<Object> fVar = this.f4380k;
                if (fVar != null) {
                    for (Object obj3 : map.values()) {
                        if (obj3 == null) {
                            if (z) {
                            }
                        } else if (z3) {
                            if (!fVar.d(hVar, obj3)) {
                            }
                        } else if (obj2 == null || !obj2.equals(map)) {
                        }
                    }
                } else {
                    for (Object obj4 : map.values()) {
                        if (obj4 != null) {
                            try {
                                f<Object> fVarP = p(hVar, obj4);
                                if (z3) {
                                    if (!fVarP.d(hVar, obj4)) {
                                    }
                                } else if (obj2 == null || !obj2.equals(map)) {
                                }
                            } catch (JsonMappingException unused) {
                            }
                        } else if (z) {
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    @Override // b3.f
    public final void f(Object obj, JsonGenerator jsonGenerator, h hVar) {
        Map<?, ?> map = (Map) obj;
        jsonGenerator.d1(map);
        s(map, jsonGenerator, hVar);
        jsonGenerator.G0();
    }

    @Override // b3.f
    public final void g(Object obj, JsonGenerator jsonGenerator, h hVar, e eVar) {
        Map<?, ?> map = (Map) obj;
        jsonGenerator.Q(map);
        WritableTypeId writableTypeIdE = eVar.e(jsonGenerator, eVar.d(JsonToken.START_OBJECT, map));
        s(map, jsonGenerator, hVar);
        eVar.f(jsonGenerator, writableTypeIdE);
    }

    @Override // com.fasterxml.jackson.databind.ser.ContainerSerializer
    public final ContainerSerializer o(e eVar) {
        if (this.f4381l == eVar) {
            return this;
        }
        com.fasterxml.jackson.databind.util.a.E(MapSerializer.class, this, "_withValueTypeSerializer");
        return new MapSerializer(this, eVar, this.f4386q, this.r);
    }

    public final f<Object> p(h hVar, Object obj) {
        Class<?> cls = obj.getClass();
        f<Object> fVarC = this.f4382m.c(cls);
        if (fVarC != null) {
            return fVarC;
        }
        JavaType javaType = this.h;
        boolean zS = javaType.s();
        BeanProperty beanProperty = this.f4376c;
        if (zS) {
            com.fasterxml.jackson.databind.ser.impl.a aVar = this.f4382m;
            a.d dVarA = aVar.a(hVar.o(javaType, cls), hVar, beanProperty);
            com.fasterxml.jackson.databind.ser.impl.a aVar2 = dVarA.f4337b;
            if (aVar != aVar2) {
                this.f4382m = aVar2;
            }
            return dVarA.f4336a;
        }
        com.fasterxml.jackson.databind.ser.impl.a aVar3 = this.f4382m;
        aVar3.getClass();
        f<Object> fVarR = hVar.r(cls, beanProperty);
        com.fasterxml.jackson.databind.ser.impl.a aVarB = aVar3.b(cls, fVarR);
        if (aVar3 != aVarB) {
            this.f4382m = aVarB;
        }
        return fVarR;
    }

    public final void r(Map<?, ?> map, JsonGenerator jsonGenerator, h hVar, Object obj) throws IOException {
        f<Object> fVar;
        f<Object> fVarP;
        boolean z = f4375v == obj;
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            Object key = entry.getKey();
            if (key == null) {
                fVar = hVar.f3049j;
            } else {
                IgnorePropertiesUtil.Checker checker = this.f4387s;
                if (checker == null || !checker.a(key)) {
                    fVar = this.f4379j;
                }
            }
            Object value = entry.getValue();
            if (value != null) {
                fVarP = this.f4380k;
                if (fVarP == null) {
                    fVarP = p(hVar, value);
                }
                if (z) {
                    if (fVarP.d(hVar, value)) {
                        continue;
                    } else {
                        fVar.f(key, jsonGenerator, hVar);
                        fVarP.g(value, jsonGenerator, hVar, this.f4381l);
                    }
                } else if (obj == null || !obj.equals(value)) {
                    fVar.f(key, jsonGenerator, hVar);
                    fVarP.g(value, jsonGenerator, hVar, this.f4381l);
                }
            } else if (this.r) {
                continue;
            } else {
                fVarP = hVar.h;
                fVar.f(key, jsonGenerator, hVar);
                try {
                    fVarP.g(value, jsonGenerator, hVar, this.f4381l);
                } catch (Exception e10) {
                    StdSerializer.n(hVar, e10, map, String.valueOf(key));
                    throw null;
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01a2 A[EXC_TOP_SPLITTER, PHI: r15
      0x01a2: PHI (r15v1 b3.f<java.lang.Object>) = 
      (r15v0 b3.f<java.lang.Object>)
      (r15v3 b3.f<java.lang.Object>)
      (r15v3 b3.f<java.lang.Object>)
      (r15v3 b3.f<java.lang.Object>)
     binds: [B:122:0x0185, B:128:0x0196, B:130:0x0199, B:132:0x019f] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:150:0x007d A[EXC_TOP_SPLITTER, PHI: r12
      0x007d: PHI (r12v1 b3.f<java.lang.Object>) = 
      (r12v0 b3.f<java.lang.Object>)
      (r12v3 b3.f<java.lang.Object>)
      (r12v3 b3.f<java.lang.Object>)
      (r12v3 b3.f<java.lang.Object>)
     binds: [B:24:0x0060, B:30:0x0071, B:32:0x0074, B:34:0x007a] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.util.TreeMap] */
    /* JADX WARN: Type inference failed for: r4v6, types: [java.util.TreeMap] */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void s(java.util.Map<?, ?> r18, com.fasterxml.jackson.core.JsonGenerator r19, b3.h r20) {
        /*
            Method dump skipped, instructions count: 439
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ser.std.MapSerializer.s(java.util.Map, com.fasterxml.jackson.core.JsonGenerator, b3.h):void");
    }

    public final MapSerializer t(Object obj, boolean z) {
        if (obj == this.f4386q && z == this.r) {
            return this;
        }
        com.fasterxml.jackson.databind.util.a.E(MapSerializer.class, this, "withContentInclusion");
        return new MapSerializer(this, this.f4381l, obj, z);
    }

    public MapSerializer(MapSerializer mapSerializer, BeanProperty beanProperty, f<?> fVar, f<?> fVar2, Set<String> set, Set<String> set2) {
        super(Map.class, 0);
        set = (set == null || set.isEmpty()) ? null : set;
        this.f4383n = set;
        this.f4384o = set2;
        this.f4378e = mapSerializer.f4378e;
        this.h = mapSerializer.h;
        this.f4377d = mapSerializer.f4377d;
        this.f4381l = mapSerializer.f4381l;
        this.f4379j = fVar;
        this.f4380k = fVar2;
        this.f4382m = a.b.f4334a;
        this.f4376c = beanProperty;
        this.f4385p = mapSerializer.f4385p;
        this.f4388t = mapSerializer.f4388t;
        this.f4386q = mapSerializer.f4386q;
        this.r = mapSerializer.r;
        this.f4387s = IgnorePropertiesUtil.a(set, set2);
    }

    public MapSerializer(MapSerializer mapSerializer, e eVar, Object obj, boolean z) {
        super(Map.class, 0);
        this.f4383n = mapSerializer.f4383n;
        this.f4384o = mapSerializer.f4384o;
        this.f4378e = mapSerializer.f4378e;
        this.h = mapSerializer.h;
        this.f4377d = mapSerializer.f4377d;
        this.f4381l = eVar;
        this.f4379j = mapSerializer.f4379j;
        this.f4380k = mapSerializer.f4380k;
        this.f4382m = mapSerializer.f4382m;
        this.f4376c = mapSerializer.f4376c;
        this.f4385p = mapSerializer.f4385p;
        this.f4388t = mapSerializer.f4388t;
        this.f4386q = obj;
        this.r = z;
        this.f4387s = mapSerializer.f4387s;
    }

    public MapSerializer(MapSerializer mapSerializer, Object obj, boolean z) {
        super(Map.class, 0);
        this.f4383n = mapSerializer.f4383n;
        this.f4384o = mapSerializer.f4384o;
        this.f4378e = mapSerializer.f4378e;
        this.h = mapSerializer.h;
        this.f4377d = mapSerializer.f4377d;
        this.f4381l = mapSerializer.f4381l;
        this.f4379j = mapSerializer.f4379j;
        this.f4380k = mapSerializer.f4380k;
        this.f4382m = a.b.f4334a;
        this.f4376c = mapSerializer.f4376c;
        this.f4385p = obj;
        this.f4388t = z;
        this.f4386q = mapSerializer.f4386q;
        this.r = mapSerializer.r;
        this.f4387s = mapSerializer.f4387s;
    }
}
