package com.stepos.backend.llama;

import android.content.Context;
import b6.e;
import b6.i;
import b7.d;
import b7.k;
import com.stepos.core.model.factory.AIModelFactory;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class LlamaModelInitializer implements d {
    /* JADX INFO: Access modifiers changed from: private */
    public static final b7.a initialize$lambda$0(k it) {
        g.f(it, "it");
        return new LLMModel(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b7.a initialize$lambda$1(k it) {
        g.f(it, "it");
        return new PrivacyClassifyModel(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b7.a initialize$lambda$2(k it) {
        g.f(it, "it");
        return new ScpRiskModel(it);
    }

    @Override // b7.d
    public void initialize(Context context) {
        g.f(context, "context");
        AIModelFactory.Companion companion = AIModelFactory.Companion;
        companion.m106registerModelFactoryxbr04nE("LLAMA_CPP", new e(8));
        companion.m106registerModelFactoryxbr04nE("LLAMA_PRIVACY_CLASSIFY", new i(9));
        companion.m106registerModelFactoryxbr04nE("LLAMA_RISK_CLASSIFY", new e(9));
    }
}
