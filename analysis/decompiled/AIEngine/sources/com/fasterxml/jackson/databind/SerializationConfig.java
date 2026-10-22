package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.cfg.BaseSettings;
import com.fasterxml.jackson.databind.cfg.ConfigOverrides;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.cfg.MapperConfigBase;
import com.fasterxml.jackson.databind.introspect.BasicClassIntrospector;
import com.fasterxml.jackson.databind.introspect.SimpleMixInResolver;
import com.fasterxml.jackson.databind.jsontype.impl.StdSubtypeResolver;
import com.fasterxml.jackson.databind.util.RootNameLookup;
import java.io.Serializable;
import v2.d;
import w2.a;
import y2.b;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class SerializationConfig extends MapperConfigBase<SerializationFeature, SerializationConfig> implements Serializable {

    /* renamed from: p, reason: collision with root package name */
    public static final DefaultPrettyPrinter f3758p = new DefaultPrettyPrinter();

    /* renamed from: q, reason: collision with root package name */
    public static final int f3759q = MapperConfig.b(SerializationFeature.class);

    /* renamed from: n, reason: collision with root package name */
    public final d f3760n;

    /* renamed from: o, reason: collision with root package name */
    public final int f3761o;

    public SerializationConfig(BaseSettings baseSettings, StdSubtypeResolver stdSubtypeResolver, SimpleMixInResolver simpleMixInResolver, RootNameLookup rootNameLookup, ConfigOverrides configOverrides) {
        super(baseSettings, stdSubtypeResolver, simpleMixInResolver, rootNameLookup, configOverrides);
        this.f3761o = f3759q;
        this.f3760n = f3758p;
    }

    @Override // com.fasterxml.jackson.databind.cfg.MapperConfigBase
    public final MapperConfigBase l(int i10) {
        return new SerializationConfig(this, i10, this.f3761o);
    }

    public final void o(b bVar) {
        int i10 = SerializationFeature.INDENT_OUTPUT.f3781b;
        int i11 = this.f3761o;
        if ((i10 & i11) != 0 && bVar.f3540a == null) {
            d dVarK = this.f3760n;
            if (dVarK instanceof a3.d) {
                dVarK = ((a3.d) dVarK).k();
            }
            if (dVarK != null) {
                bVar.f3540a = dVarK;
            }
        }
        boolean z = (SerializationFeature.WRITE_BIGDECIMAL_AS_PLAIN.f3781b & i11) != 0;
        if (z) {
            int i12 = z ? JsonGenerator.Feature.WRITE_BIGDECIMAL_AS_PLAIN.f3551b : 0;
            int i13 = i12;
            int i14 = bVar.f13556c;
            int i15 = (i13 & i12) | ((~i13) & i14);
            int i16 = i14 ^ i15;
            if (i16 != 0) {
                bVar.f13556c = i15;
                bVar.getClass();
                if ((a.h & i16) != 0) {
                    bVar.f13557d = JsonGenerator.Feature.WRITE_NUMBERS_AS_STRINGS.a(i15);
                    JsonGenerator.Feature feature = JsonGenerator.Feature.ESCAPE_NON_ASCII;
                    if (feature.a(i16)) {
                        if (feature.a(i15)) {
                            bVar.o1(127);
                        } else {
                            bVar.o1(0);
                        }
                    }
                    JsonGenerator.Feature feature2 = JsonGenerator.Feature.STRICT_DUPLICATE_DETECTION;
                    if (feature2.a(i16)) {
                        if (feature2.a(i15)) {
                            y2.d dVar = bVar.f13558e;
                            if (dVar.f13986d == null) {
                                dVar.f13986d = new androidx.coordinatorlayout.widget.a(bVar);
                                bVar.f13558e = dVar;
                            }
                        } else {
                            y2.d dVar2 = bVar.f13558e;
                            dVar2.f13986d = null;
                            bVar.f13558e = dVar2;
                        }
                    }
                }
                bVar.f13978n = !JsonGenerator.Feature.QUOTE_FIELD_NAMES.a(i15);
            }
        }
    }

    public final i3.d p(JavaType javaType) {
        ((BasicClassIntrospector) this.f3828b.f3790b).getClass();
        i3.d dVarB = BasicClassIntrospector.b(this, javaType);
        return (dVarB == null && (dVarB = BasicClassIntrospector.a(this, javaType)) == null) ? new i3.d(BasicClassIntrospector.d(this, javaType, this, true)) : dVarB;
    }

    public final boolean q(SerializationFeature serializationFeature) {
        return (this.f3761o & serializationFeature.f3781b) != 0;
    }

    public SerializationConfig(SerializationConfig serializationConfig, int i10, int i11) {
        super(serializationConfig, i10);
        this.f3761o = i11;
        this.f3760n = serializationConfig.f3760n;
    }
}
