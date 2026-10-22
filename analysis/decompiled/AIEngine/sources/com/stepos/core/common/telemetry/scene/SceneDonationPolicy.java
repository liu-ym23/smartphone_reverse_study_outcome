package com.stepos.core.common.telemetry.scene;

import java.util.Locale;
import java.util.Set;
import kotlin.jvm.internal.g;
import mb.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class SceneDonationPolicy {
    public static final SceneDonationPolicy INSTANCE = new SceneDonationPolicy();
    private static final Set<String> DONATABLE_BACKENDS = l.s0(new String[]{"QNN_LLM", "QNN_VLM", "QNN_AUDIO", "QNN_TTS", "QNN_PERCEPTION"});

    private SceneDonationPolicy() {
    }

    public final boolean isDonatable(String backendKey) {
        g.f(backendKey, "backendKey");
        Set<String> set = DONATABLE_BACKENDS;
        String upperCase = backendKey.toUpperCase(Locale.ROOT);
        g.e(upperCase, "toUpperCase(...)");
        return set.contains(upperCase);
    }
}
