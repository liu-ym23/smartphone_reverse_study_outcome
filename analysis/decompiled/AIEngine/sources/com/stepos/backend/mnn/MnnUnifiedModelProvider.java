package com.stepos.backend.mnn;

import b7.k;
import com.stepos.base.model.InferenceConfig;
import java.util.List;
import java.util.Locale;
import mb.m;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@f.a
/* loaded from: classes.dex */
public final class MnnUnifiedModelProvider {
    private final List<InferenceConfig.a> supportedBackends;

    public MnnUnifiedModelProvider() {
        InferenceConfig.a aVar = new InferenceConfig.a("MNN");
        Locale locale = Locale.ROOT;
        String upperCase = MnnBackendKeys.MNN_EMBEDDING.toUpperCase(locale);
        kotlin.jvm.internal.g.e(upperCase, "toUpperCase(...)");
        InferenceConfig.a aVar2 = new InferenceConfig.a(upperCase);
        String upperCase2 = MnnBackendKeys.MNN_CLIP.toUpperCase(locale);
        kotlin.jvm.internal.g.e(upperCase2, "toUpperCase(...)");
        InferenceConfig.a aVar3 = new InferenceConfig.a(upperCase2);
        String upperCase3 = MnnBackendKeys.MNN_SEGMENT.toUpperCase(locale);
        kotlin.jvm.internal.g.e(upperCase3, "toUpperCase(...)");
        InferenceConfig.a aVar4 = new InferenceConfig.a(upperCase3);
        String upperCase4 = MnnBackendKeys.MNN_INPAINT.toUpperCase(locale);
        kotlin.jvm.internal.g.e(upperCase4, "toUpperCase(...)");
        this.supportedBackends = m.b0(aVar, aVar2, aVar3, aVar4, new InferenceConfig.a(upperCase4));
    }

    public b7.a create(k config) {
        kotlin.jvm.internal.g.f(config, "config");
        return MnnModelFactory.INSTANCE.create(config);
    }

    public List<InferenceConfig.a> getSupportedBackends() {
        return this.supportedBackends;
    }
}
