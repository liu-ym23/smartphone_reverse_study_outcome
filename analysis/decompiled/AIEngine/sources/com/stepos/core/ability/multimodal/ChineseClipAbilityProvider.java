package com.stepos.core.ability.multimodal;

import f.a;
import java.util.List;
import kotlin.jvm.internal.g;
import mb.m;
import p6.f;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@a
/* loaded from: classes.dex */
public final class ChineseClipAbilityProvider implements f {
    private final List<String> supportedTypes = m.b0("clip", "chinese_clip");

    @Override // p6.f
    public List<String> getSupportedTypes() {
        return this.supportedTypes;
    }

    @Override // p6.f
    public ChineseClipAbility create(p6.a config) {
        g.f(config, "config");
        return new ChineseClipAbility(config);
    }
}
