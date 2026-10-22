package com.stepos.backend.mnn;

import b7.k;
import com.stepos.base.model.InferenceConfig;
import java.util.Set;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class MnnModelFactory {
    public static final MnnModelFactory INSTANCE = new MnnModelFactory();
    private static final Set<String> ALL_MNN_BACKEND_KEYS = MnnBackendKeys.INSTANCE.getALL_KEYS();

    private MnnModelFactory() {
    }

    public final b7.a create(k config) {
        kotlin.jvm.internal.g.f(config, "config");
        InferenceConfig inferenceConfig = config.f3096g;
        String str = inferenceConfig.f6263a;
        if (kotlin.jvm.internal.g.b(str, "MNN")) {
            return new MnnLLMModel(config);
        }
        if (kotlin.jvm.internal.g.b(str, MnnBackendKeys.MNN_EMBEDDING)) {
            return new MnnEmbeddingModel(config);
        }
        if (kotlin.jvm.internal.g.b(str, MnnBackendKeys.MNN_CLIP)) {
            return new MnnChineseClipModel(config);
        }
        if (kotlin.jvm.internal.g.b(str, MnnBackendKeys.MNN_SEGMENT)) {
            return new MnnInteractiveSegmentModel(config);
        }
        if (kotlin.jvm.internal.g.b(str, MnnBackendKeys.MNN_INPAINT)) {
            return new MnnImageInpaintModel(config);
        }
        if (kotlin.jvm.internal.g.b(str, MnnBackendKeys.MNN_EXTEND)) {
            return new MnnImageExtendModel(config);
        }
        if (kotlin.jvm.internal.g.b(str, MnnBackendKeys.MNN_SUPER_RES)) {
            return new MnnSuperResolutionModel(config);
        }
        if (kotlin.jvm.internal.g.b(str, MnnBackendKeys.MNN_FACE)) {
            return new MnnFaceRestorationModel(config);
        }
        if (kotlin.jvm.internal.g.b(str, MnnBackendKeys.MNN_FACE_DETECT)) {
            return new MnnFaceDetectModel(config);
        }
        if (kotlin.jvm.internal.g.b(str, MnnBackendKeys.MNN_FACE_EMBED)) {
            return new MnnFaceEmbedModel(config);
        }
        if (kotlin.jvm.internal.g.b(str, MnnBackendKeys.MNN_FACE_QUALITY)) {
            return new MnnFaceQualityModel(config);
        }
        throw new IllegalArgumentException(ai.onnxruntime.a.k("Unknown MNN backend: ", inferenceConfig.f6263a));
    }

    public final Set<String> getALL_MNN_BACKEND_KEYS() {
        return ALL_MNN_BACKEND_KEYS;
    }
}
