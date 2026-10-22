package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.cfg.MapperConfigBase;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import java.io.Serializable;
import q3.k;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public interface BeanProperty extends k {

    /* renamed from: f, reason: collision with root package name */
    public static final JsonFormat.Value f3652f = new JsonFormat.Value();

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class Std implements BeanProperty, Serializable {

        /* renamed from: a, reason: collision with root package name */
        public final PropertyName f3653a;

        /* renamed from: b, reason: collision with root package name */
        public final JavaType f3654b;

        /* renamed from: c, reason: collision with root package name */
        public final PropertyMetadata f3655c;

        /* renamed from: d, reason: collision with root package name */
        public final AnnotatedMember f3656d;

        public Std(PropertyName propertyName, JavaType javaType, PropertyName propertyName2, AnnotatedMember annotatedMember, PropertyMetadata propertyMetadata) {
            this.f3653a = propertyName;
            this.f3654b = javaType;
            this.f3655c = propertyMetadata;
            this.f3656d = annotatedMember;
        }

        @Override // com.fasterxml.jackson.databind.BeanProperty
        public final JsonFormat.Value a(MapperConfig<?> mapperConfig, Class<?> cls) {
            AnnotatedMember annotatedMember;
            JsonFormat.Value valueN;
            JsonFormat.Value valueF = mapperConfig.f(cls);
            AnnotationIntrospector annotationIntrospectorD = mapperConfig.d();
            return (annotationIntrospectorD == null || (annotatedMember = this.f3656d) == null || (valueN = annotationIntrospectorD.n(annotatedMember)) == null) ? valueF : valueF.e(valueN);
        }

        @Override // com.fasterxml.jackson.databind.BeanProperty
        public final PropertyName b() {
            return this.f3653a;
        }

        @Override // com.fasterxml.jackson.databind.BeanProperty
        public final PropertyMetadata c() {
            return this.f3655c;
        }

        @Override // com.fasterxml.jackson.databind.BeanProperty
        public final AnnotatedMember d() {
            return this.f3656d;
        }

        @Override // com.fasterxml.jackson.databind.BeanProperty
        public final JsonInclude.Value e(MapperConfig<?> mapperConfig, Class<?> cls) {
            AnnotatedMember annotatedMember;
            MapperConfigBase mapperConfigBase = (MapperConfigBase) mapperConfig;
            mapperConfigBase.e(this.f3654b.f3690a).getClass();
            mapperConfigBase.e(cls).getClass();
            JsonInclude.Value value = mapperConfigBase.f3835j.f3810a;
            if (value == null) {
                value = null;
            }
            JsonInclude.Value value2 = value != null ? value : null;
            AnnotationIntrospector annotationIntrospectorD = mapperConfig.d();
            return (annotationIntrospectorD == null || (annotatedMember = this.f3656d) == null) ? value2 : value2.a(annotationIntrospectorD.J(annotatedMember));
        }

        @Override // q3.k
        public final String getName() {
            return this.f3653a.f3755a;
        }

        @Override // com.fasterxml.jackson.databind.BeanProperty
        public final JavaType getType() {
            return this.f3654b;
        }
    }

    static {
        JsonInclude.Value value = JsonInclude.Value.f3469e;
    }

    JsonFormat.Value a(MapperConfig<?> mapperConfig, Class<?> cls);

    PropertyName b();

    PropertyMetadata c();

    AnnotatedMember d();

    JsonInclude.Value e(MapperConfig<?> mapperConfig, Class<?> cls);

    JavaType getType();
}
