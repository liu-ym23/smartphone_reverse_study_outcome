package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.PropertyMetadata;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.cfg.MapperConfigBase;
import java.io.Serializable;
import java.util.List;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class ConcreteBeanPropertyBase implements BeanProperty, Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final PropertyMetadata f4149a;

    /* renamed from: b, reason: collision with root package name */
    public transient List<PropertyName> f4150b;

    public ConcreteBeanPropertyBase(PropertyMetadata propertyMetadata) {
        this.f4149a = propertyMetadata == null ? PropertyMetadata.f3744m : propertyMetadata;
    }

    @Override // com.fasterxml.jackson.databind.BeanProperty
    public final JsonFormat.Value a(MapperConfig<?> mapperConfig, Class<?> cls) {
        AnnotatedMember annotatedMemberD;
        JsonFormat.Value valueF = mapperConfig.f(cls);
        AnnotationIntrospector annotationIntrospectorD = mapperConfig.d();
        JsonFormat.Value valueN = (annotationIntrospectorD == null || (annotatedMemberD = d()) == null) ? null : annotationIntrospectorD.n(annotatedMemberD);
        return valueF == null ? valueN == null ? BeanProperty.f3652f : valueN : valueN == null ? valueF : valueF.e(valueN);
    }

    @Override // com.fasterxml.jackson.databind.BeanProperty
    public PropertyMetadata c() {
        return this.f4149a;
    }

    @Override // com.fasterxml.jackson.databind.BeanProperty
    public final JsonInclude.Value e(MapperConfig<?> mapperConfig, Class<?> cls) {
        AnnotationIntrospector annotationIntrospectorD = mapperConfig.d();
        AnnotatedMember annotatedMemberD = d();
        if (annotatedMemberD == null) {
            MapperConfigBase mapperConfigBase = (MapperConfigBase) mapperConfig;
            mapperConfigBase.e(cls).getClass();
            JsonInclude.Value value = mapperConfigBase.f3835j.f3810a;
            if (value == null) {
                return null;
            }
            return value;
        }
        MapperConfigBase mapperConfigBase2 = (MapperConfigBase) mapperConfig;
        mapperConfigBase2.e(annotatedMemberD.e()).getClass();
        mapperConfigBase2.e(cls).getClass();
        JsonInclude.Value value2 = mapperConfigBase2.f3835j.f3810a;
        if (value2 == null) {
            value2 = null;
        }
        JsonInclude.Value value3 = value2 != null ? value2 : null;
        if (annotationIntrospectorD == null) {
            return value3;
        }
        JsonInclude.Value valueJ = annotationIntrospectorD.J(annotatedMemberD);
        return value3 == null ? valueJ : value3.a(valueJ);
    }

    public ConcreteBeanPropertyBase(ConcreteBeanPropertyBase concreteBeanPropertyBase) {
        this.f4149a = concreteBeanPropertyBase.f4149a;
    }
}
