package com.stepos.backend.mnn;

import android.content.Context;
import b7.k;
import com.stepos.core.model.factory.AIModelFactory;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class MnnModelInitializer implements b7.d {
    /* JADX INFO: Access modifiers changed from: private */
    public static final b7.a initialize$lambda$0(k it) {
        kotlin.jvm.internal.g.f(it, "it");
        return new MnnLLMModel(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b7.a initialize$lambda$1(k it) {
        kotlin.jvm.internal.g.f(it, "it");
        return new MnnEmbeddingModel(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b7.a initialize$lambda$10(k it) {
        kotlin.jvm.internal.g.f(it, "it");
        return new MnnSuperResolutionModel(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b7.a initialize$lambda$2(k it) {
        kotlin.jvm.internal.g.f(it, "it");
        return new MnnChineseClipModel(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b7.a initialize$lambda$3(k it) {
        kotlin.jvm.internal.g.f(it, "it");
        return new MnnFaceDetectModel(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b7.a initialize$lambda$4(k it) {
        kotlin.jvm.internal.g.f(it, "it");
        return new MnnFaceEmbedModel(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b7.a initialize$lambda$5(k it) {
        kotlin.jvm.internal.g.f(it, "it");
        return new MnnFaceQualityModel(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b7.a initialize$lambda$6(k it) {
        kotlin.jvm.internal.g.f(it, "it");
        return new MnnInteractiveSegmentModel(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b7.a initialize$lambda$7(k it) {
        kotlin.jvm.internal.g.f(it, "it");
        return new MnnImageInpaintModel(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b7.a initialize$lambda$8(k it) {
        kotlin.jvm.internal.g.f(it, "it");
        return new MnnImageExtendModel(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b7.a initialize$lambda$9(k it) {
        kotlin.jvm.internal.g.f(it, "it");
        return new MnnFaceRestorationModel(it);
    }

    @Override // b7.d
    public void initialize(Context context) {
        kotlin.jvm.internal.g.f(context, "context");
        AIModelFactory.Companion companion = AIModelFactory.Companion;
        companion.registerModelFactory("MNN_LLM", new b6.i(10));
        companion.registerModelFactory(MnnBackendKeys.MNN_EMBEDDING, new b6.e(11));
        companion.registerModelFactory(MnnBackendKeys.MNN_CLIP, new b6.i(12));
        companion.registerModelFactory(MnnBackendKeys.MNN_FACE_DETECT, new b6.e(12));
        companion.registerModelFactory(MnnBackendKeys.MNN_FACE_EMBED, new b6.i(13));
        companion.registerModelFactory(MnnBackendKeys.MNN_FACE_QUALITY, new b6.e(13));
        companion.registerModelFactory(MnnBackendKeys.MNN_SEGMENT, new b6.i(14));
        companion.registerModelFactory(MnnBackendKeys.MNN_INPAINT, new b6.e(14));
        companion.registerModelFactory(MnnBackendKeys.MNN_EXTEND, new b6.i(15));
        companion.registerModelFactory(MnnBackendKeys.MNN_FACE, new b6.e(10));
        companion.registerModelFactory(MnnBackendKeys.MNN_SUPER_RES, new b6.i(11));
    }
}
