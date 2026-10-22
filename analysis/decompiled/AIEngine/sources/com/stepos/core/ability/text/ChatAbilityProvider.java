package com.stepos.core.ability.text;

import com.stepos.core.model.manager.ModelCacheImpl;
import java.util.List;
import kotlin.jvm.internal.g;
import mb.m;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@f.a
/* loaded from: classes.dex */
public final class ChatAbilityProvider implements p6.f {
    private final List<String> supportedTypes = m.b0("chat", ModelCacheImpl.MODEL_TYPE_LLM);

    @Override // p6.f
    public List<String> getSupportedTypes() {
        return this.supportedTypes;
    }

    @Override // p6.f
    public ChatAbility create(p6.a config) {
        g.f(config, "config");
        return new ChatAbility(config);
    }
}
