package com.fasterxml.jackson.databind.ser.std;

import b3.f;
import b3.h;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators$PropertyGenerator;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.type.WritableTypeId;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.databind.ser.impl.MapEntrySerializer;
import com.fasterxml.jackson.databind.ser.impl.PropertyBasedObjectIdGenerator;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.EnumValues;
import com.fasterxml.jackson.databind.util.IgnorePropertiesUtil;
import com.fasterxml.jackson.databind.util.NameTransformer;
import com.stepos.statsrpk.g;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import n3.c;
import n3.e;
import o3.a;
import o3.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class BeanSerializerBase extends StdSerializer<Object> implements c, e {

    /* renamed from: n, reason: collision with root package name */
    public static final BeanPropertyWriter[] f4350n;

    /* renamed from: c, reason: collision with root package name */
    public final JavaType f4351c;

    /* renamed from: d, reason: collision with root package name */
    public final BeanPropertyWriter[] f4352d;

    /* renamed from: e, reason: collision with root package name */
    public final BeanPropertyWriter[] f4353e;
    public final g h;

    /* renamed from: j, reason: collision with root package name */
    public final Object f4354j;

    /* renamed from: k, reason: collision with root package name */
    public final AnnotatedMember f4355k;

    /* renamed from: l, reason: collision with root package name */
    public final a f4356l;

    /* renamed from: m, reason: collision with root package name */
    public final JsonFormat.Shape f4357m;

    static {
        new PropertyName("#object-ref", null);
        f4350n = new BeanPropertyWriter[0];
    }

    public BeanSerializerBase(JavaType javaType, n3.a aVar, BeanPropertyWriter[] beanPropertyWriterArr, BeanPropertyWriter[] beanPropertyWriterArr2) {
        super(javaType);
        this.f4351c = javaType;
        this.f4352d = beanPropertyWriterArr;
        this.f4353e = beanPropertyWriterArr2;
        this.f4355k = aVar.f10613g;
        this.h = aVar.f10611e;
        this.f4354j = aVar.f10612f;
        this.f4356l = aVar.h;
        this.f4357m = aVar.f10607a.a().f3451b;
    }

    public static final BeanPropertyWriter[] s(BeanPropertyWriter[] beanPropertyWriterArr, NameTransformer nameTransformer) {
        if (beanPropertyWriterArr == null || beanPropertyWriterArr.length == 0 || nameTransformer == null || nameTransformer == NameTransformer.f4511a) {
            return beanPropertyWriterArr;
        }
        int length = beanPropertyWriterArr.length;
        BeanPropertyWriter[] beanPropertyWriterArr2 = new BeanPropertyWriter[length];
        for (int i10 = 0; i10 < length; i10++) {
            BeanPropertyWriter beanPropertyWriter = beanPropertyWriterArr[i10];
            if (beanPropertyWriter != null) {
                beanPropertyWriterArr2[i10] = beanPropertyWriter.j(nameTransformer);
            }
        }
        return beanPropertyWriterArr2;
    }

    @Override // n3.c
    public final f<?> a(h hVar, BeanProperty beanProperty) throws InvalidDefinitionException {
        JsonFormat.Shape shape;
        Object obj;
        JsonFormat.Shape shape2;
        int i10;
        a aVarA;
        int i11;
        Set<String> set;
        Set<String> set2;
        BeanPropertyWriter[] beanPropertyWriterArr;
        Class cls;
        JavaType javaTypeJ;
        Object obj2;
        i3.h hVarZ;
        JsonFormat.Shape shape3;
        BeanSerializerBase beanSerializerBaseW = this;
        SerializationConfig serializationConfig = hVar.f3044a;
        AnnotationIntrospector annotationIntrospectorD = serializationConfig.d();
        Object objM = null;
        AnnotatedMember annotatedMemberD = (beanProperty == null || annotationIntrospectorD == null) ? null : beanProperty.d();
        Class cls2 = beanSerializerBaseW.f4417a;
        JsonFormat.Value valueK = StdSerializer.k(hVar, beanProperty, cls2);
        JsonFormat.Shape shape4 = beanSerializerBaseW.f4357m;
        if (valueK == null || (shape = valueK.f3451b) == (shape3 = JsonFormat.Shape.f3439a)) {
            shape = null;
        } else if (shape != shape3 && shape != shape4) {
            JavaType javaType = beanSerializerBaseW.f4351c;
            if (javaType.z()) {
                int iOrdinal = shape.ordinal();
                if (iOrdinal == 5 || iOrdinal == 7 || iOrdinal == 8) {
                    serializationConfig.i(javaType);
                    Class<?> cls3 = javaType.f3690a;
                    return hVar.A(new EnumSerializer(EnumValues.a(serializationConfig, cls3), EnumSerializer.o(cls3, valueK, true, null)), beanProperty);
                }
            } else if (shape == JsonFormat.Shape.f3440b && ((!javaType.B() || !Map.class.isAssignableFrom(cls2)) && Map.Entry.class.isAssignableFrom(cls2))) {
                JavaType javaTypeI = javaType.i(Map.Entry.class);
                return hVar.A(new MapEntrySerializer(beanSerializerBaseW.f4351c, javaTypeI.h(0), javaTypeI.h(1), false, null, beanProperty), beanProperty);
            }
        }
        BeanPropertyWriter[] beanPropertyWriterArr2 = beanSerializerBaseW.f4352d;
        a aVar = beanSerializerBaseW.f4356l;
        if (annotatedMemberD != null) {
            JsonIgnoreProperties.Value valueH = annotationIntrospectorD.H(annotatedMemberD);
            set = valueH.f3461c ? Collections.EMPTY_SET : valueH.f3459a;
            set2 = annotationIntrospectorD.K(annotatedMemberD).f3475a;
            i3.h hVarY = annotationIntrospectorD.y(annotatedMemberD);
            if (hVarY == null) {
                if (aVar == null || (hVarZ = annotationIntrospectorD.z(annotatedMemberD, null)) == null) {
                    i10 = 0;
                    aVarA = aVar;
                } else {
                    boolean z = hVarZ.f9515e;
                    if (z == aVar.f10741e) {
                        aVarA = aVar;
                        i10 = 0;
                    } else {
                        i10 = 0;
                        aVarA = new a(aVar.f10737a, aVar.f10738b, aVar.f10739c, aVar.f10740d, z);
                    }
                }
                shape2 = shape4;
                i11 = i10;
                obj = null;
            } else {
                i10 = 0;
                i3.h hVarZ2 = annotationIntrospectorD.z(annotatedMemberD, hVarY);
                Class<? extends ObjectIdGenerator<?>> cls4 = hVarZ2.f9512b;
                boolean z3 = hVarZ2.f9515e;
                PropertyName propertyName = hVarZ2.f9511a;
                if (cls4 == null) {
                    cls = cls2;
                    javaTypeJ = null;
                } else {
                    cls = cls2;
                    javaTypeJ = hVar.e().j(cls4);
                }
                hVar.e().getClass();
                shape2 = shape4;
                JavaType javaType2 = TypeFactory.l(javaTypeJ, ObjectIdGenerator.class)[0];
                if (cls4 == ObjectIdGenerators$PropertyGenerator.class) {
                    String str = propertyName.f3755a;
                    int length = beanPropertyWriterArr2.length;
                    i11 = 0;
                    while (i11 != length) {
                        BeanPropertyWriter beanPropertyWriter = beanPropertyWriterArr2[i11];
                        int i12 = length;
                        if (str.equals(beanPropertyWriter.f4290c.f3610a)) {
                            aVarA = a.a(beanPropertyWriter.f4292e, null, new PropertyBasedObjectIdGenerator(beanPropertyWriter, hVarZ2.f9514d), z3);
                            obj = null;
                        } else {
                            i11++;
                            length = i12;
                        }
                    }
                    hVar.j("Invalid Object Id definition for " + com.fasterxml.jackson.databind.util.a.y(cls) + ": cannot find property with name " + com.fasterxml.jackson.databind.util.a.x(str));
                    throw null;
                }
                obj = null;
                aVarA = a.a(javaType2, propertyName, hVar.g(hVarZ2), z3);
                i11 = 0;
            }
            objM = annotationIntrospectorD.m(annotatedMemberD);
            if (objM == null || ((obj2 = beanSerializerBaseW.f4354j) != null && objM.equals(obj2))) {
                objM = obj;
            }
        } else {
            obj = null;
            shape2 = shape4;
            i10 = 0;
            aVarA = aVar;
            i11 = 0;
            set = null;
            set2 = null;
        }
        if (i11 > 0) {
            BeanPropertyWriter[] beanPropertyWriterArr3 = (BeanPropertyWriter[]) Arrays.copyOf(beanPropertyWriterArr2, beanPropertyWriterArr2.length);
            BeanPropertyWriter beanPropertyWriter2 = beanPropertyWriterArr3[i11];
            int i13 = i10;
            System.arraycopy(beanPropertyWriterArr3, i13, beanPropertyWriterArr3, 1, i11);
            beanPropertyWriterArr3[i13] = beanPropertyWriter2;
            BeanPropertyWriter[] beanPropertyWriterArr4 = beanSerializerBaseW.f4353e;
            if (beanPropertyWriterArr4 == null) {
                beanPropertyWriterArr = obj;
            } else {
                beanPropertyWriterArr = (BeanPropertyWriter[]) Arrays.copyOf(beanPropertyWriterArr4, beanPropertyWriterArr4.length);
                BeanPropertyWriter beanPropertyWriter3 = beanPropertyWriterArr[i11];
                System.arraycopy(beanPropertyWriterArr, i13, beanPropertyWriterArr, 1, i11);
                beanPropertyWriterArr[i13] = beanPropertyWriter3;
            }
            beanSerializerBaseW = beanSerializerBaseW.y(beanPropertyWriterArr3, beanPropertyWriterArr);
        }
        if (aVarA != null) {
            a aVar2 = new a(aVarA.f10737a, aVarA.f10738b, aVarA.f10739c, hVar.x(aVarA.f10737a, beanProperty), aVarA.f10741e);
            if (aVar2 != aVar) {
                beanSerializerBaseW = beanSerializerBaseW.x(aVar2);
            }
        }
        if ((set != null && !set.isEmpty()) || set2 != null) {
            beanSerializerBaseW = beanSerializerBaseW.v(set, set2);
        }
        if (objM != null) {
            beanSerializerBaseW = beanSerializerBaseW.w(objM);
        }
        return (shape == null ? shape2 : shape) == JsonFormat.Shape.f3442d ? beanSerializerBaseW.r() : beanSerializerBaseW;
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x00a8  */
    @Override // n3.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(b3.h r11) throws com.fasterxml.jackson.databind.JsonMappingException {
        /*
            r10 = this;
            r0 = 0
            com.fasterxml.jackson.databind.ser.BeanPropertyWriter[] r1 = r10.f4353e
            if (r1 != 0) goto L7
            r2 = r0
            goto L8
        L7:
            int r2 = r1.length
        L8:
            com.fasterxml.jackson.databind.ser.BeanPropertyWriter[] r3 = r10.f4352d
            int r4 = r3.length
        Lb:
            if (r0 >= r4) goto Laf
            r5 = r3[r0]
            boolean r6 = r5.r
            com.fasterxml.jackson.databind.introspect.AnnotatedMember r7 = r5.f4294k
            if (r6 != 0) goto L2a
            b3.f<java.lang.Object> r6 = r5.f4298o
            if (r6 == 0) goto L1a
            goto L2a
        L1a:
            b3.f<java.lang.Object> r6 = r11.h
            if (r6 == 0) goto L2a
            r5.h(r6)
            if (r0 >= r2) goto L2a
            r8 = r1[r0]
            if (r8 == 0) goto L2a
            r8.h(r6)
        L2a:
            b3.f<java.lang.Object> r6 = r5.f4297n
            if (r6 == 0) goto L30
            goto Lab
        L30:
            com.fasterxml.jackson.databind.SerializationConfig r6 = r11.f3044a
            com.fasterxml.jackson.databind.AnnotationIntrospector r6 = r6.d()
            r8 = 0
            if (r6 == 0) goto L5d
            if (r7 == 0) goto L5d
            java.lang.Object r6 = r6.Q(r7)
            if (r6 == 0) goto L5d
            q3.g r6 = r11.c(r6)
            r11.e()
            com.fasterxml.jackson.databind.JavaType r7 = r6.b()
            boolean r9 = r7.A()
            if (r9 == 0) goto L53
            goto L57
        L53:
            b3.f r8 = r11.x(r7, r5)
        L57:
            com.fasterxml.jackson.databind.ser.std.StdDelegatingSerializer r9 = new com.fasterxml.jackson.databind.ser.std.StdDelegatingSerializer
            r9.<init>(r6, r7, r8)
            r8 = r9
        L5d:
            if (r8 != 0) goto L9e
            com.fasterxml.jackson.databind.JavaType r6 = r5.h
            if (r6 != 0) goto L80
            com.fasterxml.jackson.databind.JavaType r6 = r5.f4292e
            java.lang.Class<?> r7 = r6.f3690a
            int r7 = r7.getModifiers()
            boolean r7 = java.lang.reflect.Modifier.isFinal(r7)
            if (r7 != 0) goto L80
            boolean r7 = r6.y()
            if (r7 != 0) goto L7d
            int r7 = r6.g()
            if (r7 <= 0) goto Lab
        L7d:
            r5.f4293j = r6
            goto Lab
        L80:
            b3.f r8 = r11.x(r6, r5)
            boolean r7 = r6.y()
            if (r7 == 0) goto L9e
            com.fasterxml.jackson.databind.JavaType r6 = r6.k()
            java.lang.Object r6 = r6.f3693d
            k3.e r6 = (k3.e) r6
            if (r6 == 0) goto L9e
            boolean r7 = r8 instanceof com.fasterxml.jackson.databind.ser.ContainerSerializer
            if (r7 == 0) goto L9e
            com.fasterxml.jackson.databind.ser.ContainerSerializer r8 = (com.fasterxml.jackson.databind.ser.ContainerSerializer) r8
            com.fasterxml.jackson.databind.ser.ContainerSerializer r8 = r8.o(r6)
        L9e:
            if (r0 >= r2) goto La8
            r6 = r1[r0]
            if (r6 == 0) goto La8
            r6.i(r8)
            goto Lab
        La8:
            r5.i(r8)
        Lab:
            int r0 = r0 + 1
            goto Lb
        Laf:
            com.stepos.statsrpk.g r10 = r10.h
            if (r10 == 0) goto Lcd
            java.lang.Object r0 = r10.f8089c
            b3.f r0 = (b3.f) r0
            boolean r1 = r0 instanceof n3.c
            if (r1 == 0) goto Lcd
            java.lang.Object r1 = r10.f8087a
            com.fasterxml.jackson.databind.BeanProperty$Std r1 = (com.fasterxml.jackson.databind.BeanProperty.Std) r1
            b3.f r11 = r11.A(r0, r1)
            r10.f8089c = r11
            boolean r0 = r11 instanceof com.fasterxml.jackson.databind.ser.std.MapSerializer
            if (r0 == 0) goto Lcd
            com.fasterxml.jackson.databind.ser.std.MapSerializer r11 = (com.fasterxml.jackson.databind.ser.std.MapSerializer) r11
            r10.f8090d = r11
        Lcd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ser.std.BeanSerializerBase.b(b3.h):void");
    }

    @Override // b3.f
    public void g(Object obj, JsonGenerator jsonGenerator, h hVar, k3.e eVar) {
        if (this.f4356l != null) {
            jsonGenerator.Q(obj);
            o(obj, jsonGenerator, hVar, eVar);
            return;
        }
        jsonGenerator.Q(obj);
        WritableTypeId writableTypeIdQ = q(eVar, obj, JsonToken.START_OBJECT);
        eVar.e(jsonGenerator, writableTypeIdQ);
        if (this.f4354j != null) {
            u(hVar);
            throw null;
        }
        t(obj, jsonGenerator, hVar);
        eVar.f(jsonGenerator, writableTypeIdQ);
    }

    @Override // b3.f
    public final boolean i() {
        return this.f4356l != null;
    }

    public final void o(Object obj, JsonGenerator jsonGenerator, h hVar, k3.e eVar) {
        a aVar = this.f4356l;
        d dVarT = hVar.t(obj, aVar.f10739c);
        if (dVarT.b(jsonGenerator, hVar, aVar)) {
            return;
        }
        if (dVarT.f10752b == null) {
            dVarT.f10752b = dVarT.f10751a.c(obj);
        }
        Object obj2 = dVarT.f10752b;
        if (aVar.f10741e) {
            aVar.f10740d.f(obj2, jsonGenerator, hVar);
            return;
        }
        WritableTypeId writableTypeIdQ = q(eVar, obj, JsonToken.START_OBJECT);
        eVar.e(jsonGenerator, writableTypeIdQ);
        dVarT.a(jsonGenerator, hVar, aVar);
        if (this.f4354j != null) {
            u(hVar);
            throw null;
        }
        t(obj, jsonGenerator, hVar);
        eVar.f(jsonGenerator, writableTypeIdQ);
    }

    public final void p(Object obj, JsonGenerator jsonGenerator, h hVar, boolean z) {
        a aVar = this.f4356l;
        d dVarT = hVar.t(obj, aVar.f10739c);
        if (dVarT.b(jsonGenerator, hVar, aVar)) {
            return;
        }
        if (dVarT.f10752b == null) {
            dVarT.f10752b = dVarT.f10751a.c(obj);
        }
        Object obj2 = dVarT.f10752b;
        if (aVar.f10741e) {
            aVar.f10740d.f(obj2, jsonGenerator, hVar);
            return;
        }
        if (z) {
            jsonGenerator.d1(obj);
        }
        dVarT.a(jsonGenerator, hVar, aVar);
        if (this.f4354j != null) {
            u(hVar);
            throw null;
        }
        t(obj, jsonGenerator, hVar);
        if (z) {
            jsonGenerator.G0();
        }
    }

    public final WritableTypeId q(k3.e eVar, Object obj, JsonToken jsonToken) {
        AnnotatedMember annotatedMember = this.f4355k;
        if (annotatedMember == null) {
            return eVar.d(jsonToken, obj);
        }
        Object objK = annotatedMember.k(obj);
        if (objK == null) {
            objK = "";
        }
        WritableTypeId writableTypeIdD = eVar.d(jsonToken, obj);
        writableTypeIdD.f3621c = objK;
        return writableTypeIdD;
    }

    public abstract BeanSerializerBase r();

    public final void t(Object obj, JsonGenerator jsonGenerator, h hVar) {
        if (this.f4353e != null) {
            hVar.getClass();
        }
        BeanPropertyWriter[] beanPropertyWriterArr = this.f4352d;
        int i10 = 0;
        try {
            int length = beanPropertyWriterArr.length;
            while (i10 < length) {
                BeanPropertyWriter beanPropertyWriter = beanPropertyWriterArr[i10];
                if (beanPropertyWriter != null) {
                    beanPropertyWriter.l(obj, jsonGenerator, hVar);
                }
                i10++;
            }
            g gVar = this.h;
            if (gVar != null) {
                gVar.w(obj, jsonGenerator, hVar);
            }
        } catch (Exception e10) {
            StdSerializer.n(hVar, e10, obj, i10 != beanPropertyWriterArr.length ? beanPropertyWriterArr[i10].f4290c.f3610a : "[anySetter]");
            throw null;
        } catch (StackOverflowError e11) {
            JsonMappingException jsonMappingException = new JsonMappingException(jsonGenerator, "Infinite recursion (StackOverflowError)", e11);
            jsonMappingException.f(new JsonMappingException.Reference(obj, i10 != beanPropertyWriterArr.length ? beanPropertyWriterArr[i10].f4290c.f3610a : "[anySetter]"));
            throw jsonMappingException;
        }
    }

    public final void u(h hVar) {
        if (this.f4353e != null) {
            hVar.getClass();
        }
        l(hVar, this.f4354j);
        throw null;
    }

    public abstract BeanSerializerBase v(Set<String> set, Set<String> set2);

    public abstract BeanSerializerBase w(Object obj);

    public abstract BeanSerializerBase x(a aVar);

    public abstract BeanSerializerBase y(BeanPropertyWriter[] beanPropertyWriterArr, BeanPropertyWriter[] beanPropertyWriterArr2);

    public BeanSerializerBase(BeanSerializerBase beanSerializerBase, BeanPropertyWriter[] beanPropertyWriterArr, BeanPropertyWriter[] beanPropertyWriterArr2) {
        super(beanSerializerBase.f4417a);
        this.f4351c = beanSerializerBase.f4351c;
        this.f4352d = beanPropertyWriterArr;
        this.f4353e = beanPropertyWriterArr2;
        this.f4355k = beanSerializerBase.f4355k;
        this.h = beanSerializerBase.h;
        this.f4356l = beanSerializerBase.f4356l;
        this.f4354j = beanSerializerBase.f4354j;
        this.f4357m = beanSerializerBase.f4357m;
    }

    public BeanSerializerBase(BeanSerializerBase beanSerializerBase, a aVar, Object obj) {
        super(beanSerializerBase.f4417a);
        this.f4351c = beanSerializerBase.f4351c;
        this.f4352d = beanSerializerBase.f4352d;
        this.f4353e = beanSerializerBase.f4353e;
        this.f4355k = beanSerializerBase.f4355k;
        this.h = beanSerializerBase.h;
        this.f4356l = aVar;
        this.f4354j = obj;
        this.f4357m = beanSerializerBase.f4357m;
    }

    public BeanSerializerBase(BeanSerializerBase beanSerializerBase, Set<String> set, Set<String> set2) {
        super(beanSerializerBase.f4417a);
        this.f4351c = beanSerializerBase.f4351c;
        BeanPropertyWriter[] beanPropertyWriterArr = beanSerializerBase.f4352d;
        BeanPropertyWriter[] beanPropertyWriterArr2 = beanSerializerBase.f4353e;
        int length = beanPropertyWriterArr.length;
        ArrayList arrayList = new ArrayList(length);
        ArrayList arrayList2 = beanPropertyWriterArr2 == null ? null : new ArrayList(length);
        for (int i10 = 0; i10 < length; i10++) {
            BeanPropertyWriter beanPropertyWriter = beanPropertyWriterArr[i10];
            if (!IgnorePropertiesUtil.b(beanPropertyWriter.f4290c.f3610a, set, set2)) {
                arrayList.add(beanPropertyWriter);
                if (beanPropertyWriterArr2 != null) {
                    arrayList2.add(beanPropertyWriterArr2[i10]);
                }
            }
        }
        this.f4352d = (BeanPropertyWriter[]) arrayList.toArray(new BeanPropertyWriter[arrayList.size()]);
        this.f4353e = arrayList2 != null ? (BeanPropertyWriter[]) arrayList2.toArray(new BeanPropertyWriter[arrayList2.size()]) : null;
        this.f4355k = beanSerializerBase.f4355k;
        this.h = beanSerializerBase.h;
        this.f4356l = beanSerializerBase.f4356l;
        this.f4354j = beanSerializerBase.f4354j;
        this.f4357m = beanSerializerBase.f4357m;
    }
}
