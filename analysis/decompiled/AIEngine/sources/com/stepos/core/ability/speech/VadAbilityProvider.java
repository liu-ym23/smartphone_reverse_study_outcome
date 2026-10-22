package com.stepos.core.ability.speech;

import androidx.datastore.preferences.protobuf.b1;
import java.util.List;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class VadAbilityProvider implements p6.f {
    private final List<String> supportedTypes = b1.P("vad");

    @Override // p6.f
    public List<String> getSupportedTypes() {
        return this.supportedTypes;
    }

    @Override // p6.f
    public VadAbility create(p6.a config) {
        kotlin.jvm.internal.g.f(config, "config");
        return new VadAbility(config);
    }
}
