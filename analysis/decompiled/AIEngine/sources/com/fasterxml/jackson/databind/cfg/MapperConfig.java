package com.fasterxml.jackson.databind.cfg;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.introspect.BasicClassIntrospector;
import com.fasterxml.jackson.databind.introspect.NopAnnotationIntrospector;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.fasterxml.jackson.databind.introspect.f;
import d3.a;
import d3.b;
import i3.d;
import java.io.Serializable;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class MapperConfig<T extends MapperConfig<T>> implements f.a, Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final int f3827a;

    /* renamed from: b, reason: collision with root package name */
    public final BaseSettings f3828b;

    static {
        JsonInclude.Value value = JsonInclude.Value.f3469e;
        JsonFormat.Value value2 = JsonFormat.Value.f3449k;
    }

    public MapperConfig(BaseSettings baseSettings, int i10) {
        this.f3828b = baseSettings;
        this.f3827a = i10;
    }

    public static <F extends Enum<F> & a> int b(Class<F> cls) {
        int iB = 0;
        for (Object obj : (Enum[]) cls.getEnumConstants()) {
            a aVar = (a) obj;
            if (aVar.a()) {
                iB |= aVar.b();
            }
        }
        return iB;
    }

    public final JavaType c(Class<?> cls) {
        return this.f3828b.f3789a.j(cls);
    }

    public final AnnotationIntrospector d() {
        return k(MapperFeature.USE_ANNOTATIONS) ? this.f3828b.f3791c : NopAnnotationIntrospector.f4165a;
    }

    public abstract b e(Class<?> cls);

    public abstract JsonFormat.Value f(Class<?> cls);

    public abstract VisibilityChecker<?> g(Class<?> cls, com.fasterxml.jackson.databind.introspect.a aVar);

    public final void h() {
        this.f3828b.getClass();
    }

    public final d i(JavaType javaType) {
        ((BasicClassIntrospector) this.f3828b.f3790b).getClass();
        d dVarB = BasicClassIntrospector.b(this, javaType);
        return dVarB == null ? d.g(javaType, this, BasicClassIntrospector.c(this, javaType, this)) : dVarB;
    }

    public final d j(Class cls) {
        return i(c(cls));
    }

    public final boolean k(MapperFeature mapperFeature) {
        return (this.f3827a & mapperFeature.f3721b) != 0;
    }

    public MapperConfig(MapperConfigBase mapperConfigBase, int i10) {
        this.f3828b = mapperConfigBase.f3828b;
        this.f3827a = i10;
    }
}
