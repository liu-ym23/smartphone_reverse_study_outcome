package com.fasterxml.jackson.databind.ser.std;

import b3.f;
import b3.h;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.type.WritableTypeId;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ser.ContainerSerializer;
import com.fasterxml.jackson.databind.ser.impl.a;
import java.lang.reflect.Modifier;
import k3.e;
import n3.c;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class AsArraySerializerBase<T> extends ContainerSerializer<T> implements c {

    /* renamed from: c, reason: collision with root package name */
    public final JavaType f4344c;

    /* renamed from: d, reason: collision with root package name */
    public final BeanProperty f4345d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f4346e;
    public final Boolean h;

    /* renamed from: j, reason: collision with root package name */
    public final e f4347j;

    /* renamed from: k, reason: collision with root package name */
    public final f<Object> f4348k;

    /* renamed from: l, reason: collision with root package name */
    public a f4349l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AsArraySerializerBase(Class<?> cls, JavaType javaType, boolean z, e eVar, f<Object> fVar) {
        super(cls, 0);
        boolean z3 = false;
        this.f4344c = javaType;
        if (z || (javaType != null && Modifier.isFinal(javaType.f3690a.getModifiers()))) {
            z3 = true;
        }
        this.f4346e = z3;
        this.f4347j = eVar;
        this.f4345d = null;
        this.f4348k = fVar;
        this.f4349l = a.b.f4334a;
        this.h = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0024  */
    @Override // n3.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final b3.f<?> a(b3.h r8, com.fasterxml.jackson.databind.BeanProperty r9) {
        /*
            r7 = this;
            k3.e r0 = r7.f4347j
            if (r0 == 0) goto L9
            k3.e r1 = r0.a(r9)
            goto La
        L9:
            r1 = r0
        La:
            r2 = 0
            if (r9 == 0) goto L24
            com.fasterxml.jackson.databind.SerializationConfig r3 = r8.f3044a
            com.fasterxml.jackson.databind.AnnotationIntrospector r3 = r3.d()
            com.fasterxml.jackson.databind.introspect.AnnotatedMember r4 = r9.d()
            if (r4 == 0) goto L24
            java.lang.Object r3 = r3.d(r4)
            if (r3 == 0) goto L24
            b3.f r3 = r8.G(r4, r3)
            goto L25
        L24:
            r3 = r2
        L25:
            java.lang.Class<T> r4 = r7.f4417a
            com.fasterxml.jackson.annotation.JsonFormat$Value r4 = com.fasterxml.jackson.databind.ser.std.StdSerializer.k(r8, r9, r4)
            if (r4 == 0) goto L33
            com.fasterxml.jackson.annotation.JsonFormat$Feature r2 = com.fasterxml.jackson.annotation.JsonFormat.Feature.f3436c
            java.lang.Boolean r2 = r4.b(r2)
        L33:
            b3.f<java.lang.Object> r4 = r7.f4348k
            if (r3 != 0) goto L38
            r3 = r4
        L38:
            b3.f r3 = com.fasterxml.jackson.databind.ser.std.StdSerializer.j(r8, r9, r3)
            if (r3 != 0) goto L50
            com.fasterxml.jackson.databind.JavaType r5 = r7.f4344c
            if (r5 == 0) goto L50
            boolean r6 = r7.f4346e
            if (r6 == 0) goto L50
            boolean r6 = r5.A()
            if (r6 != 0) goto L50
            b3.f r3 = r8.q(r5, r9)
        L50:
            if (r3 != r4) goto L62
            com.fasterxml.jackson.databind.BeanProperty r8 = r7.f4345d
            if (r9 != r8) goto L62
            if (r0 != r1) goto L62
            java.lang.Boolean r8 = r7.h
            boolean r8 = java.util.Objects.equals(r8, r2)
            if (r8 != 0) goto L61
            goto L62
        L61:
            return r7
        L62:
            com.fasterxml.jackson.databind.ser.std.AsArraySerializerBase r7 = r7.r(r9, r1, r3, r2)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ser.std.AsArraySerializerBase.a(b3.h, com.fasterxml.jackson.databind.BeanProperty):b3.f");
    }

    @Override // b3.f
    public final void g(T t8, JsonGenerator jsonGenerator, h hVar, e eVar) {
        WritableTypeId writableTypeIdE = eVar.e(jsonGenerator, eVar.d(JsonToken.START_ARRAY, t8));
        jsonGenerator.Q(t8);
        q(t8, jsonGenerator, hVar);
        eVar.f(jsonGenerator, writableTypeIdE);
    }

    public final f<Object> p(a aVar, JavaType javaType, h hVar) {
        a.d dVarA = aVar.a(javaType, hVar, this.f4345d);
        a aVar2 = dVarA.f4337b;
        if (aVar != aVar2) {
            this.f4349l = aVar2;
        }
        return dVarA.f4336a;
    }

    public abstract void q(T t8, JsonGenerator jsonGenerator, h hVar);

    public abstract AsArraySerializerBase<T> r(BeanProperty beanProperty, e eVar, f<?> fVar, Boolean bool);

    public AsArraySerializerBase(AsArraySerializerBase<?> asArraySerializerBase, BeanProperty beanProperty, e eVar, f<?> fVar, Boolean bool) {
        super(asArraySerializerBase.f4417a, 0);
        this.f4344c = asArraySerializerBase.f4344c;
        this.f4346e = asArraySerializerBase.f4346e;
        this.f4347j = eVar;
        this.f4345d = beanProperty;
        this.f4348k = fVar;
        this.f4349l = a.b.f4334a;
        this.h = bool;
    }
}
