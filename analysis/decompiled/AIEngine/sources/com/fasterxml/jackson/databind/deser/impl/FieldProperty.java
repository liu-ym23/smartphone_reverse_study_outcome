package com.fasterxml.jackson.databind.deser.impl;

import b3.c;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.introspect.AnnotatedField;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import e3.i;
import i3.e;
import java.lang.reflect.Field;
import k3.b;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class FieldProperty extends SettableBeanProperty {

    /* renamed from: p, reason: collision with root package name */
    public final AnnotatedField f3911p;

    /* renamed from: q, reason: collision with root package name */
    public final transient Field f3912q;
    public final boolean r;

    public FieldProperty(e eVar, JavaType javaType, b bVar, q3.a aVar, AnnotatedField annotatedField) {
        super(eVar, javaType, bVar, aVar);
        this.f3911p = annotatedField;
        this.f3912q = annotatedField.f4118c;
        this.r = NullsConstantProvider.b(this.f3894j);
    }

    @Override // com.fasterxml.jackson.databind.deser.SettableBeanProperty
    public final Object A(Object obj, Object obj2) throws IllegalAccessException, JsonMappingException, IllegalArgumentException {
        try {
            this.f3912q.set(obj, obj2);
            return obj;
        } catch (Exception e10) {
            f(null, e10, obj2);
            throw null;
        }
    }

    @Override // com.fasterxml.jackson.databind.deser.SettableBeanProperty
    public final SettableBeanProperty B(PropertyName propertyName) {
        return new FieldProperty(this, propertyName);
    }

    @Override // com.fasterxml.jackson.databind.deser.SettableBeanProperty
    public final SettableBeanProperty C(i iVar) {
        return new FieldProperty(this, this.f3893e, iVar);
    }

    @Override // com.fasterxml.jackson.databind.deser.SettableBeanProperty
    public final SettableBeanProperty D(c<?> cVar) {
        c<?> cVar2 = this.f3893e;
        if (cVar2 == cVar) {
            return this;
        }
        i iVar = this.f3894j;
        if (cVar2 == iVar) {
            iVar = cVar;
        }
        return new FieldProperty(this, cVar, iVar);
    }

    @Override // com.fasterxml.jackson.databind.deser.SettableBeanProperty, com.fasterxml.jackson.databind.BeanProperty
    public final AnnotatedMember d() {
        return this.f3911p;
    }

    @Override // com.fasterxml.jackson.databind.deser.SettableBeanProperty
    public final void i(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj) throws IllegalAccessException, JsonMappingException, IllegalArgumentException {
        Object objF;
        boolean zI1 = jsonParser.i1(JsonToken.VALUE_NULL);
        i iVar = this.f3894j;
        boolean z = this.r;
        if (!zI1) {
            c<Object> cVar = this.f3893e;
            b bVar = this.h;
            if (bVar == null) {
                Object objD = cVar.d(jsonParser, deserializationContext);
                if (objD != null) {
                    objF = objD;
                } else if (z) {
                    return;
                } else {
                    objF = iVar.a(deserializationContext);
                }
            } else {
                objF = cVar.f(jsonParser, deserializationContext, bVar);
            }
        } else if (z) {
            return;
        } else {
            objF = iVar.a(deserializationContext);
        }
        try {
            this.f3912q.set(obj, objF);
        } catch (Exception e10) {
            f(jsonParser, e10, objF);
            throw null;
        }
    }

    @Override // com.fasterxml.jackson.databind.deser.SettableBeanProperty
    public final Object j(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj) throws IllegalAccessException, JsonMappingException, IllegalArgumentException {
        Object objF;
        boolean zI1 = jsonParser.i1(JsonToken.VALUE_NULL);
        i iVar = this.f3894j;
        boolean z = this.r;
        if (zI1) {
            if (!z) {
                objF = iVar.a(deserializationContext);
                try {
                    this.f3912q.set(obj, objF);
                    return obj;
                } catch (Exception e10) {
                    f(jsonParser, e10, objF);
                    throw null;
                }
            }
            return obj;
        }
        c<Object> cVar = this.f3893e;
        b bVar = this.h;
        if (bVar == null) {
            Object objD = cVar.d(jsonParser, deserializationContext);
            if (objD == null) {
                if (!z) {
                    objF = iVar.a(deserializationContext);
                }
                return obj;
            }
            objF = objD;
        } else {
            objF = cVar.f(jsonParser, deserializationContext, bVar);
        }
        this.f3912q.set(obj, objF);
        return obj;
    }

    @Override // com.fasterxml.jackson.databind.deser.SettableBeanProperty
    public final void l(DeserializationConfig deserializationConfig) {
        com.fasterxml.jackson.databind.util.a.e(this.f3912q, deserializationConfig.k(MapperFeature.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
    }

    public Object readResolve() {
        return new FieldProperty(this);
    }

    @Override // com.fasterxml.jackson.databind.deser.SettableBeanProperty
    public final void z(Object obj, Object obj2) throws IllegalAccessException, JsonMappingException, IllegalArgumentException {
        try {
            this.f3912q.set(obj, obj2);
        } catch (Exception e10) {
            f(null, e10, obj2);
            throw null;
        }
    }

    public FieldProperty(FieldProperty fieldProperty, c<?> cVar, i iVar) {
        super(fieldProperty, cVar, iVar);
        this.f3911p = fieldProperty.f3911p;
        this.f3912q = fieldProperty.f3912q;
        this.r = NullsConstantProvider.b(iVar);
    }

    public FieldProperty(FieldProperty fieldProperty, PropertyName propertyName) {
        super(fieldProperty, propertyName);
        this.f3911p = fieldProperty.f3911p;
        this.f3912q = fieldProperty.f3912q;
        this.r = fieldProperty.r;
    }

    public FieldProperty(FieldProperty fieldProperty) {
        super(fieldProperty);
        AnnotatedField annotatedField = fieldProperty.f3911p;
        this.f3911p = annotatedField;
        Field field = annotatedField.f4118c;
        if (field != null) {
            this.f3912q = field;
            this.r = fieldProperty.r;
            return;
        }
        throw new IllegalArgumentException("Missing field (broken JDK (de)serialization?)");
    }
}
