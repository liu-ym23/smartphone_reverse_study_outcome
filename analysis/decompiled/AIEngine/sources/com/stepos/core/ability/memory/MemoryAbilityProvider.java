package com.stepos.core.ability.memory;

import androidx.datastore.preferences.protobuf.b1;
import f.a;
import java.util.List;
import kotlin.jvm.internal.g;
import p6.f;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@a
/* loaded from: classes.dex */
public final class MemoryAbilityProvider implements f {
    private final List<String> supportedTypes = b1.P("memory");

    @Override // p6.f
    public List<String> getSupportedTypes() {
        return this.supportedTypes;
    }

    @Override // p6.f
    public MemoryAbility create(p6.a config) {
        g.f(config, "config");
        return new MemoryAbility(config);
    }
}
