package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.databind.cfg.BaseSettings;
import com.fasterxml.jackson.databind.cfg.CoercionConfigs;
import com.fasterxml.jackson.databind.cfg.ConfigOverrides;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.cfg.MapperConfigBase;
import com.fasterxml.jackson.databind.introspect.BasicClassIntrospector;
import com.fasterxml.jackson.databind.introspect.SimpleMixInResolver;
import com.fasterxml.jackson.databind.jsontype.impl.StdSubtypeResolver;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.util.RootNameLookup;
import i3.d;
import java.io.Serializable;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class DeserializationConfig extends MapperConfigBase<DeserializationFeature, DeserializationConfig> implements Serializable {

    /* renamed from: q, reason: collision with root package name */
    public static final int f3657q = MapperConfig.b(DeserializationFeature.class);

    /* renamed from: n, reason: collision with root package name */
    public final JsonNodeFactory f3658n;

    /* renamed from: o, reason: collision with root package name */
    public final CoercionConfigs f3659o;

    /* renamed from: p, reason: collision with root package name */
    public final int f3660p;

    public DeserializationConfig(BaseSettings baseSettings, StdSubtypeResolver stdSubtypeResolver, SimpleMixInResolver simpleMixInResolver, RootNameLookup rootNameLookup, ConfigOverrides configOverrides, CoercionConfigs coercionConfigs) {
        super(baseSettings, stdSubtypeResolver, simpleMixInResolver, rootNameLookup, configOverrides);
        this.f3660p = f3657q;
        this.f3658n = JsonNodeFactory.f4269a;
        this.f3659o = coercionConfigs;
    }

    @Override // com.fasterxml.jackson.databind.cfg.MapperConfigBase
    public final MapperConfigBase l(int i10) {
        return new DeserializationConfig(this, i10, this.f3660p);
    }

    public final d o(JavaType javaType) {
        ((BasicClassIntrospector) this.f3828b.f3790b).getClass();
        d dVarB = BasicClassIntrospector.b(this, javaType);
        return (dVarB == null && (dVarB = BasicClassIntrospector.a(this, javaType)) == null) ? new d(BasicClassIntrospector.d(this, javaType, this, false)) : dVarB;
    }

    public final boolean p(DeserializationFeature deserializationFeature) {
        return (this.f3660p & deserializationFeature.f3689b) != 0;
    }

    public DeserializationConfig(DeserializationConfig deserializationConfig, int i10, int i11) {
        super(deserializationConfig, i10);
        this.f3660p = i11;
        this.f3658n = deserializationConfig.f3658n;
        this.f3659o = deserializationConfig.f3659o;
    }
}
