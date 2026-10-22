package com.stepos.core.model.factory;

import android.util.Log;
import b7.a;
import b7.c;
import b7.k;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;
import zb.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AIModelFactory implements c {
    public static final Companion Companion = new Companion(null);
    private static final ConcurrentHashMap<String, l<k, a>> modelFactoryRegistry = new ConcurrentHashMap<>();
    private final String TAG = "AIModelFactory";

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public final void registerModelFactory(String backendKey, l<? super k, ? extends a> factory) {
            g.f(backendKey, "backendKey");
            g.f(factory, "factory");
            AIModelFactory.modelFactoryRegistry.put(backendKey, factory);
        }

        /* renamed from: registerModelFactory-xbr04nE, reason: not valid java name */
        public final void m106registerModelFactoryxbr04nE(String backend, l<? super k, ? extends a> factory) {
            g.f(backend, "backend");
            g.f(factory, "factory");
            AIModelFactory.modelFactoryRegistry.put(backend, factory);
            Log.d("AIModelFactory", "Registered model factory for backend: ".concat(backend));
        }

        private Companion() {
        }
    }

    public a createModel(k config) {
        g.f(config, "config");
        String str = config.f3096g.f6263a;
        l<k, a> lVar = modelFactoryRegistry.get(str);
        if (lVar != null) {
            return lVar.invoke(config);
        }
        a0.a.A("No factory registered for backend: ", str, this.TAG);
        return null;
    }
}
