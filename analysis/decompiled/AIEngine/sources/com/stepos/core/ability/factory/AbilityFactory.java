package com.stepos.core.ability.factory;

import android.content.Context;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import h0.e;
import java.util.Iterator;
import java.util.ServiceLoader;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.g;
import p6.a;
import p6.d;
import p6.f;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AbilityFactory {
    private static final String TAG = "AbilityFactory";
    public static final AbilityFactory INSTANCE = new AbilityFactory();
    private static final ConcurrentHashMap<String, f> providerRegistry = new ConcurrentHashMap<>();

    private AbilityFactory() {
    }

    public final d<?, ?> createAbility(a abilityConfig) {
        g.f(abilityConfig, "abilityConfig");
        String str = abilityConfig.f11417b.f11434a;
        AIEngineLogger.d(LogModule.ABILITY, TAG, e.c("createAbility: ", abilityConfig.f11416a, " (type=", str, ")"));
        f fVar = providerRegistry.get(str);
        if (fVar != null) {
            return fVar.create(abilityConfig);
        }
        throw new IllegalArgumentException(a0.a.k("Unknown ability type: '", str, "'. Create an IAbilityProvider and register in META-INF/services."));
    }

    public final void discoverProviders(Context context) {
        g.f(context, "context");
        Iterator it = ServiceLoader.load(f.class, context.getClassLoader()).iterator();
        g.e(it, "iterator(...)");
        while (it.hasNext()) {
            f fVar = (f) it.next();
            for (String str : fVar.getSupportedTypes()) {
                providerRegistry.put(str, fVar);
                AIEngineLogger.d(LogModule.ABILITY, TAG, ai.onnxruntime.a.l("Discovered: ", str, " -> ", fVar.getClass().getSimpleName()));
            }
        }
        AIEngineLogger.i(LogModule.ABILITY, TAG, "Provider discovery complete: " + providerRegistry.size() + " types registered");
    }
}
