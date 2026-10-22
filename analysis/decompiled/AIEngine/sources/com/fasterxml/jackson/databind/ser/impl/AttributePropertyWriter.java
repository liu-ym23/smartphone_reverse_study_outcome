package com.fasterxml.jackson.databind.ser.impl;

import b3.h;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.cfg.ContextAttributes;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.ser.VirtualBeanPropertyWriter;
import java.util.HashMap;
import q3.o;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class AttributePropertyWriter extends VirtualBeanPropertyWriter {

    /* renamed from: v, reason: collision with root package name */
    public final String f4307v;

    /* JADX WARN: Illegal instructions before constructor call */
    public AttributePropertyWriter(String str, o oVar, q3.a aVar, JavaType javaType) {
        JsonInclude.Include include;
        Object obj;
        JsonInclude.Value value = oVar.h;
        AnnotatedMember annotatedMember = oVar.f11576c;
        JsonInclude.Include include2 = JsonInclude.Include.f3468e;
        JsonInclude.Include include3 = JsonInclude.Include.f3464a;
        boolean z = false;
        if (value != null && (include = value.f3470a) != include3 && include != include2) {
            z = true;
        }
        boolean z3 = z;
        if (value == null) {
            obj = Boolean.FALSE;
        } else {
            JsonInclude.Include include4 = value.f3470a;
            obj = (include4 == include3 || include4 == JsonInclude.Include.f3465b || include4 == include2) ? null : JsonInclude.Include.f3466c;
        }
        super(oVar, annotatedMember, aVar, javaType, null, null, null, z3, obj, null);
        this.f4307v = str;
    }

    @Override // com.fasterxml.jackson.databind.ser.VirtualBeanPropertyWriter
    public final Object n(h hVar) {
        Object obj;
        ContextAttributes.Impl impl = (ContextAttributes.Impl) hVar.f3047d;
        HashMap map = impl.f3817b;
        String str = this.f4307v;
        if (map == null || (obj = map.get(str)) == null) {
            return impl.f3816a.get(str);
        }
        if (obj == ContextAttributes.Impl.f3815d) {
            return null;
        }
        return obj;
    }

    @Override // com.fasterxml.jackson.databind.ser.VirtualBeanPropertyWriter
    public final VirtualBeanPropertyWriter o() {
        throw new IllegalStateException("Should not be called on this type");
    }
}
