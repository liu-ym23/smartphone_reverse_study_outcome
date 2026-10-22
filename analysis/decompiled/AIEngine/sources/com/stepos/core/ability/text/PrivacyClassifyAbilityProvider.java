package com.stepos.core.ability.text;

import androidx.datastore.preferences.protobuf.b1;
import java.util.List;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@f.a
/* loaded from: classes.dex */
public final class PrivacyClassifyAbilityProvider implements p6.f {
    private final List<String> supportedTypes = b1.P("privacy_classify");

    @Override // p6.f
    public List<String> getSupportedTypes() {
        return this.supportedTypes;
    }

    @Override // p6.f
    public PrivacyClassifyAbility create(p6.a config) {
        g.f(config, "config");
        return new PrivacyClassifyAbility(config);
    }
}
