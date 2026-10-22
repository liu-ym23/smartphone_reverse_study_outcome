package com.fasterxml.jackson.databind.ser.impl;

import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators$PropertyGenerator;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import java.lang.reflect.Method;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class PropertyBasedObjectIdGenerator extends ObjectIdGenerators$PropertyGenerator {

    /* renamed from: b, reason: collision with root package name */
    public final BeanPropertyWriter f4324b;

    public PropertyBasedObjectIdGenerator(BeanPropertyWriter beanPropertyWriter, Class cls) {
        super(cls);
        this.f4324b = beanPropertyWriter;
    }

    @Override // com.fasterxml.jackson.annotation.ObjectIdGenerators$PropertyGenerator, com.fasterxml.jackson.annotation.ObjectIdGenerator
    public final boolean a(ObjectIdGenerator<?> objectIdGenerator) {
        if (objectIdGenerator.getClass() == getClass()) {
            PropertyBasedObjectIdGenerator propertyBasedObjectIdGenerator = (PropertyBasedObjectIdGenerator) objectIdGenerator;
            if (propertyBasedObjectIdGenerator.d() == this.f3500a && propertyBasedObjectIdGenerator.f4324b == this.f4324b) {
                return true;
            }
        }
        return false;
    }

    @Override // com.fasterxml.jackson.annotation.ObjectIdGenerator
    public final ObjectIdGenerator<Object> b(Class<?> cls) {
        return cls == this.f3500a ? this : new PropertyBasedObjectIdGenerator(this.f4324b, cls);
    }

    @Override // com.fasterxml.jackson.annotation.ObjectIdGenerator
    public final Object c(Object obj) {
        BeanPropertyWriter beanPropertyWriter = this.f4324b;
        try {
            Method method = beanPropertyWriter.f4295l;
            return method == null ? beanPropertyWriter.f4296m.get(obj) : method.invoke(obj, null);
        } catch (RuntimeException e10) {
            throw e10;
        } catch (Exception e11) {
            throw new IllegalStateException("Problem accessing property '" + beanPropertyWriter.f4290c.f3610a + "': " + e11.getMessage(), e11);
        }
    }

    @Override // com.fasterxml.jackson.annotation.ObjectIdGenerator
    public final ObjectIdGenerator.IdKey e(Object obj) {
        if (obj == null) {
            return null;
        }
        return new ObjectIdGenerator.IdKey(getClass(), this.f3500a, obj);
    }

    @Override // com.fasterxml.jackson.annotation.ObjectIdGenerator
    public final ObjectIdGenerator f() {
        return this;
    }
}
