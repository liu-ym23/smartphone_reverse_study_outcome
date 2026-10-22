package com.fasterxml.jackson.databind.ser.impl;

import b3.f;
import b3.h;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.databind.util.NameTransformer;
import java.io.Serializable;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class FilteredBeanPropertyWriter {

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class MultiView extends BeanPropertyWriter implements Serializable {

        /* renamed from: v, reason: collision with root package name */
        public final BeanPropertyWriter f4310v;

        /* renamed from: w, reason: collision with root package name */
        public final Class<?>[] f4311w;

        public MultiView(BeanPropertyWriter beanPropertyWriter, Class<?>[] clsArr) {
            super(beanPropertyWriter);
            this.f4310v = beanPropertyWriter;
            this.f4311w = clsArr;
        }

        @Override // com.fasterxml.jackson.databind.ser.BeanPropertyWriter
        public final void h(f<Object> fVar) {
            this.f4310v.h(fVar);
        }

        @Override // com.fasterxml.jackson.databind.ser.BeanPropertyWriter
        public final void i(f<Object> fVar) {
            this.f4310v.i(fVar);
        }

        @Override // com.fasterxml.jackson.databind.ser.BeanPropertyWriter
        public final BeanPropertyWriter j(NameTransformer nameTransformer) {
            return new MultiView(this.f4310v.j(nameTransformer), this.f4311w);
        }

        @Override // com.fasterxml.jackson.databind.ser.BeanPropertyWriter
        public final void k(Object obj, JsonGenerator jsonGenerator, h hVar) {
            hVar.getClass();
            this.f4310v.k(obj, jsonGenerator, hVar);
        }

        @Override // com.fasterxml.jackson.databind.ser.BeanPropertyWriter
        public final void l(Object obj, JsonGenerator jsonGenerator, h hVar) {
            hVar.getClass();
            this.f4310v.l(obj, jsonGenerator, hVar);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class SingleView extends BeanPropertyWriter implements Serializable {

        /* renamed from: v, reason: collision with root package name */
        public final BeanPropertyWriter f4312v;

        /* renamed from: w, reason: collision with root package name */
        public final Class<?> f4313w;

        public SingleView(BeanPropertyWriter beanPropertyWriter, Class<?> cls) {
            super(beanPropertyWriter);
            this.f4312v = beanPropertyWriter;
            this.f4313w = cls;
        }

        @Override // com.fasterxml.jackson.databind.ser.BeanPropertyWriter
        public final void h(f<Object> fVar) {
            this.f4312v.h(fVar);
        }

        @Override // com.fasterxml.jackson.databind.ser.BeanPropertyWriter
        public final void i(f<Object> fVar) {
            this.f4312v.i(fVar);
        }

        @Override // com.fasterxml.jackson.databind.ser.BeanPropertyWriter
        public final BeanPropertyWriter j(NameTransformer nameTransformer) {
            return new SingleView(this.f4312v.j(nameTransformer), this.f4313w);
        }

        @Override // com.fasterxml.jackson.databind.ser.BeanPropertyWriter
        public final void k(Object obj, JsonGenerator jsonGenerator, h hVar) {
            hVar.getClass();
            this.f4312v.k(obj, jsonGenerator, hVar);
        }

        @Override // com.fasterxml.jackson.databind.ser.BeanPropertyWriter
        public final void l(Object obj, JsonGenerator jsonGenerator, h hVar) {
            hVar.getClass();
            this.f4312v.l(obj, jsonGenerator, hVar);
        }
    }

    public static BeanPropertyWriter a(BeanPropertyWriter beanPropertyWriter, Class<?>[] clsArr) {
        return clsArr.length == 1 ? new SingleView(beanPropertyWriter, clsArr[0]) : new MultiView(beanPropertyWriter, clsArr);
    }
}
