package com.obric.aiagent.product.feature.api;

import com.obric.aiagent.product.feature.impl.a;
import java.util.List;

/* JADX INFO: compiled from: IFeatureService.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface IFeatureService {
    public static final Companion Companion = null;

    /* JADX INFO: compiled from: IFeatureService.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;

        static {
            $$INSTANCE = new Companion();
        }

        private Companion() {
        }

        public final IFeatureService get() {
            return a.f18789a.a();
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    String appVariant();

    void destroy();

    String getFeatureState(String r1);

    List<String> getFeatureStateList(String r1);

    String getObricProductName();

    void init();

    boolean isEmulatorOs();

    boolean isFeatureEnable(String r1);

    boolean isGlobalEffectStopLayerEffective();

    boolean isObricFeatureEnable();

    boolean isObricOs();
}
