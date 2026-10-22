package com.fasterxml.jackson.databind.ser.std;

import b3.f;
import b3.h;
import com.fasterxml.jackson.databind.BeanProperty;
import java.util.Collection;
import n3.c;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class StaticListSerializerBase<T extends Collection<?>> extends StdSerializer<T> implements c {

    /* renamed from: c, reason: collision with root package name */
    public final Boolean f4407c;

    public StaticListSerializerBase(Class<?> cls) {
        super(cls, 0);
        this.f4407c = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x001a  */
    @Override // n3.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final b3.f<?> a(b3.h r6, com.fasterxml.jackson.databind.BeanProperty r7) {
        /*
            r5 = this;
            r0 = 0
            if (r7 == 0) goto L1a
            com.fasterxml.jackson.databind.SerializationConfig r1 = r6.f3044a
            com.fasterxml.jackson.databind.AnnotationIntrospector r1 = r1.d()
            com.fasterxml.jackson.databind.introspect.AnnotatedMember r2 = r7.d()
            if (r2 == 0) goto L1a
            java.lang.Object r1 = r1.d(r2)
            if (r1 == 0) goto L1a
            b3.f r1 = r6.G(r2, r1)
            goto L1b
        L1a:
            r1 = r0
        L1b:
            java.lang.Class<T> r2 = r5.f4417a
            com.fasterxml.jackson.annotation.JsonFormat$Value r2 = com.fasterxml.jackson.databind.ser.std.StdSerializer.k(r6, r7, r2)
            if (r2 == 0) goto L2a
            com.fasterxml.jackson.annotation.JsonFormat$Feature r3 = com.fasterxml.jackson.annotation.JsonFormat.Feature.f3436c
            java.lang.Boolean r2 = r2.b(r3)
            goto L2b
        L2a:
            r2 = r0
        L2b:
            b3.f r1 = com.fasterxml.jackson.databind.ser.std.StdSerializer.j(r6, r7, r1)
            java.lang.Class<java.lang.String> r3 = java.lang.String.class
            if (r1 != 0) goto L37
            b3.f r1 = r6.r(r3, r7)
        L37:
            boolean r4 = com.fasterxml.jackson.databind.util.a.v(r1)
            if (r4 == 0) goto L4b
            java.lang.Boolean r6 = r5.f4407c
            boolean r6 = java.util.Objects.equals(r2, r6)
            if (r6 == 0) goto L46
            return r5
        L46:
            b3.f r5 = r5.o(r7, r2)
            return r5
        L4b:
            com.fasterxml.jackson.databind.ser.std.CollectionSerializer r5 = new com.fasterxml.jackson.databind.ser.std.CollectionSerializer
            com.fasterxml.jackson.databind.type.TypeFactory r6 = r6.e()
            com.fasterxml.jackson.databind.JavaType r6 = r6.j(r3)
            r7 = 1
            r5.<init>(r6, r7, r0, r1)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ser.std.StaticListSerializerBase.a(b3.h, com.fasterxml.jackson.databind.BeanProperty):b3.f");
    }

    @Override // b3.f
    public final boolean d(h hVar, Object obj) {
        return ((Collection) obj).size() == 0;
    }

    public abstract f<?> o(BeanProperty beanProperty, Boolean bool);

    public StaticListSerializerBase(StaticListSerializerBase<?> staticListSerializerBase, Boolean bool) {
        super(staticListSerializerBase);
        this.f4407c = bool;
    }
}
