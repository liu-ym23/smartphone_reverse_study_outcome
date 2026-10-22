package com.stepos.backend.qnn;

import android.content.Context;
import com.stepos.core.model.factory.AIModelFactory;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class QnnModelInitializer implements b7.d {
    /* JADX INFO: Access modifiers changed from: private */
    public static final b7.a initialize$lambda$0(b7.k it) {
        kotlin.jvm.internal.g.f(it, "it");
        return new QnnLLMModel(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b7.a initialize$lambda$1(b7.k it) {
        kotlin.jvm.internal.g.f(it, "it");
        return new QnnVLMModel(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b7.a initialize$lambda$2(b7.k it) {
        kotlin.jvm.internal.g.f(it, "it");
        return new QnnTTSModel(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b7.a initialize$lambda$3(b7.k it) {
        kotlin.jvm.internal.g.f(it, "it");
        return new QnnImageMattingModel(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b7.a initialize$lambda$4(b7.k it) {
        kotlin.jvm.internal.g.f(it, "it");
        return new QnnRerankingModel(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b7.a initialize$lambda$5(b7.k it) {
        kotlin.jvm.internal.g.f(it, "it");
        return new QnnImageExtendModel(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b7.a initialize$lambda$6(b7.k it) {
        kotlin.jvm.internal.g.f(it, "it");
        return new QnnImageInpaintAigcModel(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b7.a initialize$lambda$7(b7.k it) {
        kotlin.jvm.internal.g.f(it, "it");
        return new QnnSmsParseModel(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b7.a initialize$lambda$8(b7.k it) {
        kotlin.jvm.internal.g.f(it, "it");
        return new QnnASRModel(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b7.a initialize$lambda$9(b7.k it) {
        kotlin.jvm.internal.g.f(it, "it");
        return new QnnPerceptionModel(it);
    }

    @Override // b7.d
    public void initialize(Context context) {
        kotlin.jvm.internal.g.f(context, "context");
        AIModelFactory.Companion companion = AIModelFactory.Companion;
        companion.m106registerModelFactoryxbr04nE("QNN_LLM", new b6.i(18));
        companion.m106registerModelFactoryxbr04nE("QNN_VLM", new b6.e(17));
        companion.m106registerModelFactoryxbr04nE("QNN_TTS", new b6.i(19));
        companion.m106registerModelFactoryxbr04nE("QNN_MATTING", new b6.e(18));
        companion.m106registerModelFactoryxbr04nE("QNN_RERANKING", new b6.i(20));
        companion.m106registerModelFactoryxbr04nE("QNN_IMAGE_EXTEND", new b6.e(19));
        companion.m106registerModelFactoryxbr04nE("QNN_INPAINT_AIGC", new b6.i(21));
        companion.m106registerModelFactoryxbr04nE("QNN_SMSPARSE", new b6.e(20));
        companion.m106registerModelFactoryxbr04nE("QNN_AUDIO", new b6.i(22));
        companion.m106registerModelFactoryxbr04nE("QNN_PERCEPTION", new b6.e(21));
    }
}
