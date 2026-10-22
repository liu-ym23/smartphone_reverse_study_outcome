package com.fasterxml.jackson.databind.cfg;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.cfg.ContextAttributes;
import com.fasterxml.jackson.databind.cfg.MapperConfigBase;
import com.fasterxml.jackson.databind.introspect.SimpleMixInResolver;
import com.fasterxml.jackson.databind.jsontype.impl.StdSubtypeResolver;
import com.fasterxml.jackson.databind.util.RootNameLookup;
import d3.a;
import d3.b;
import java.io.Serializable;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class MapperConfigBase<CFG extends a, T extends MapperConfigBase<CFG, T>> extends MapperConfig<T> implements Serializable {

    /* renamed from: k, reason: collision with root package name */
    public static final b.a f3829k = b.a.f8346a;

    /* renamed from: l, reason: collision with root package name */
    public static final int f3830l = MapperConfig.b(MapperFeature.class);

    /* renamed from: m, reason: collision with root package name */
    public static final int f3831m = (((MapperFeature.AUTO_DETECT_FIELDS.f3721b | MapperFeature.AUTO_DETECT_GETTERS.f3721b) | MapperFeature.AUTO_DETECT_IS_GETTERS.f3721b) | MapperFeature.AUTO_DETECT_SETTERS.f3721b) | MapperFeature.AUTO_DETECT_CREATORS.f3721b;

    /* renamed from: c, reason: collision with root package name */
    public final SimpleMixInResolver f3832c;

    /* renamed from: d, reason: collision with root package name */
    public final StdSubtypeResolver f3833d;

    /* renamed from: e, reason: collision with root package name */
    public final ContextAttributes f3834e;
    public final RootNameLookup h;

    /* renamed from: j, reason: collision with root package name */
    public final ConfigOverrides f3835j;

    public MapperConfigBase(BaseSettings baseSettings, StdSubtypeResolver stdSubtypeResolver, SimpleMixInResolver simpleMixInResolver, RootNameLookup rootNameLookup, ConfigOverrides configOverrides) {
        super(baseSettings, f3830l);
        this.f3832c = simpleMixInResolver;
        this.f3833d = stdSubtypeResolver;
        this.h = rootNameLookup;
        this.f3834e = ContextAttributes.Impl.f3814c;
        this.f3835j = configOverrides;
    }

    @Override // com.fasterxml.jackson.databind.introspect.f.a
    public final Class<?> a(Class<?> cls) {
        this.f3832c.getClass();
        return null;
    }

    @Override // com.fasterxml.jackson.databind.cfg.MapperConfig
    public final b e(Class<?> cls) {
        this.f3835j.getClass();
        return f3829k;
    }

    @Override // com.fasterxml.jackson.databind.cfg.MapperConfig
    public final JsonFormat.Value f(Class<?> cls) {
        this.f3835j.getClass();
        return JsonFormat.Value.f3449k;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0031  */
    @Override // com.fasterxml.jackson.databind.cfg.MapperConfig
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.fasterxml.jackson.databind.introspect.VisibilityChecker<?> g(java.lang.Class<?> r8, com.fasterxml.jackson.databind.introspect.a r9) {
        /*
            r7 = this;
            com.fasterxml.jackson.databind.cfg.ConfigOverrides r8 = r7.f3835j
            com.fasterxml.jackson.databind.introspect.VisibilityChecker$Std r8 = r8.f3812c
            int r0 = r7.f3827a
            int r1 = com.fasterxml.jackson.databind.cfg.MapperConfigBase.f3831m
            r0 = r0 & r1
            if (r0 == r1) goto Lb3
            com.fasterxml.jackson.databind.MapperFeature r0 = com.fasterxml.jackson.databind.MapperFeature.AUTO_DETECT_FIELDS
            boolean r0 = r7.k(r0)
            com.fasterxml.jackson.annotation.JsonAutoDetect$Visibility r2 = com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.f3426c
            if (r0 != 0) goto L31
            r8.getClass()
            com.fasterxml.jackson.annotation.JsonAutoDetect$Visibility r0 = r8.f4173e
            if (r0 != r2) goto L1d
            goto L31
        L1d:
            com.fasterxml.jackson.databind.introspect.VisibilityChecker$Std r1 = new com.fasterxml.jackson.databind.introspect.VisibilityChecker$Std
            r3 = r2
            com.fasterxml.jackson.annotation.JsonAutoDetect$Visibility r2 = r8.f4169a
            r4 = r3
            com.fasterxml.jackson.annotation.JsonAutoDetect$Visibility r3 = r8.f4170b
            r5 = r4
            com.fasterxml.jackson.annotation.JsonAutoDetect$Visibility r4 = r8.f4171c
            r6 = r5
            com.fasterxml.jackson.annotation.JsonAutoDetect$Visibility r5 = r8.f4172d
            r1.<init>(r2, r3, r4, r5, r6)
            r3 = r6
            r8 = r1
            goto L32
        L31:
            r3 = r2
        L32:
            com.fasterxml.jackson.databind.MapperFeature r0 = com.fasterxml.jackson.databind.MapperFeature.AUTO_DETECT_GETTERS
            boolean r0 = r7.k(r0)
            if (r0 != 0) goto L55
            r8.getClass()
            com.fasterxml.jackson.annotation.JsonAutoDetect$Visibility r0 = r8.f4169a
            if (r0 != r3) goto L42
            goto L55
        L42:
            com.fasterxml.jackson.databind.introspect.VisibilityChecker$Std r1 = new com.fasterxml.jackson.databind.introspect.VisibilityChecker$Std
            r4 = r3
            com.fasterxml.jackson.annotation.JsonAutoDetect$Visibility r3 = r8.f4170b
            r5 = r4
            com.fasterxml.jackson.annotation.JsonAutoDetect$Visibility r4 = r8.f4171c
            r6 = r5
            com.fasterxml.jackson.annotation.JsonAutoDetect$Visibility r5 = r8.f4172d
            r2 = r6
            com.fasterxml.jackson.annotation.JsonAutoDetect$Visibility r6 = r8.f4173e
            r1.<init>(r2, r3, r4, r5, r6)
            r3 = r2
            r8 = r1
        L55:
            com.fasterxml.jackson.databind.MapperFeature r0 = com.fasterxml.jackson.databind.MapperFeature.AUTO_DETECT_IS_GETTERS
            boolean r0 = r7.k(r0)
            if (r0 != 0) goto L73
            r8.getClass()
            com.fasterxml.jackson.annotation.JsonAutoDetect$Visibility r0 = r8.f4170b
            if (r0 != r3) goto L65
            goto L73
        L65:
            com.fasterxml.jackson.databind.introspect.VisibilityChecker$Std r1 = new com.fasterxml.jackson.databind.introspect.VisibilityChecker$Std
            com.fasterxml.jackson.annotation.JsonAutoDetect$Visibility r2 = r8.f4169a
            com.fasterxml.jackson.annotation.JsonAutoDetect$Visibility r4 = r8.f4171c
            com.fasterxml.jackson.annotation.JsonAutoDetect$Visibility r5 = r8.f4172d
            com.fasterxml.jackson.annotation.JsonAutoDetect$Visibility r6 = r8.f4173e
            r1.<init>(r2, r3, r4, r5, r6)
            r8 = r1
        L73:
            com.fasterxml.jackson.databind.MapperFeature r0 = com.fasterxml.jackson.databind.MapperFeature.AUTO_DETECT_SETTERS
            boolean r0 = r7.k(r0)
            if (r0 != 0) goto L93
            r8.getClass()
            com.fasterxml.jackson.annotation.JsonAutoDetect$Visibility r0 = r8.f4171c
            if (r0 != r3) goto L83
            goto L93
        L83:
            com.fasterxml.jackson.databind.introspect.VisibilityChecker$Std r1 = new com.fasterxml.jackson.databind.introspect.VisibilityChecker$Std
            com.fasterxml.jackson.annotation.JsonAutoDetect$Visibility r2 = r8.f4169a
            r4 = r3
            com.fasterxml.jackson.annotation.JsonAutoDetect$Visibility r3 = r8.f4170b
            com.fasterxml.jackson.annotation.JsonAutoDetect$Visibility r5 = r8.f4172d
            com.fasterxml.jackson.annotation.JsonAutoDetect$Visibility r6 = r8.f4173e
            r1.<init>(r2, r3, r4, r5, r6)
            r3 = r4
            r8 = r1
        L93:
            com.fasterxml.jackson.databind.MapperFeature r0 = com.fasterxml.jackson.databind.MapperFeature.AUTO_DETECT_CREATORS
            boolean r0 = r7.k(r0)
            if (r0 != 0) goto Lb3
            r8.getClass()
            com.fasterxml.jackson.annotation.JsonAutoDetect$Visibility r0 = r8.f4172d
            if (r0 != r3) goto La3
            goto Lb3
        La3:
            com.fasterxml.jackson.databind.introspect.VisibilityChecker$Std r1 = new com.fasterxml.jackson.databind.introspect.VisibilityChecker$Std
            com.fasterxml.jackson.annotation.JsonAutoDetect$Visibility r2 = r8.f4169a
            r4 = r3
            com.fasterxml.jackson.annotation.JsonAutoDetect$Visibility r3 = r8.f4170b
            r5 = r4
            com.fasterxml.jackson.annotation.JsonAutoDetect$Visibility r4 = r8.f4171c
            com.fasterxml.jackson.annotation.JsonAutoDetect$Visibility r6 = r8.f4173e
            r1.<init>(r2, r3, r4, r5, r6)
            r8 = r1
        Lb3:
            com.fasterxml.jackson.databind.AnnotationIntrospector r7 = r7.d()
            if (r7 == 0) goto Lbd
            com.fasterxml.jackson.databind.introspect.VisibilityChecker r8 = r7.b(r9, r8)
        Lbd:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.cfg.MapperConfigBase.g(java.lang.Class, com.fasterxml.jackson.databind.introspect.a):com.fasterxml.jackson.databind.introspect.VisibilityChecker");
    }

    public abstract T l(int i10);

    public final JsonIgnoreProperties.Value m(Class<?> cls, com.fasterxml.jackson.databind.introspect.a aVar) {
        AnnotationIntrospector annotationIntrospectorD = d();
        JsonIgnoreProperties.Value valueH = annotationIntrospectorD == null ? null : annotationIntrospectorD.H(aVar);
        this.f3835j.getClass();
        JsonIgnoreProperties.Value value = JsonIgnoreProperties.Value.h;
        if (valueH == null) {
            return null;
        }
        return valueH;
    }

    public final T n(MapperFeature... mapperFeatureArr) {
        int i10 = this.f3827a;
        int i11 = i10;
        for (MapperFeature mapperFeature : mapperFeatureArr) {
            i11 &= ~mapperFeature.f3721b;
        }
        return i11 == i10 ? this : (T) l(i11);
    }

    public MapperConfigBase(MapperConfigBase<CFG, T> mapperConfigBase, int i10) {
        super(mapperConfigBase, i10);
        this.f3832c = mapperConfigBase.f3832c;
        this.f3833d = mapperConfigBase.f3833d;
        this.h = mapperConfigBase.h;
        this.f3834e = mapperConfigBase.f3834e;
        this.f3835j = mapperConfigBase.f3835j;
    }
}
