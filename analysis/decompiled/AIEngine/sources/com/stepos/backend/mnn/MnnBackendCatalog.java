package com.stepos.backend.mnn;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class MnnBackendCatalog {
    public static final MnnBackendCatalog INSTANCE = new MnnBackendCatalog();

    private MnnBackendCatalog() {
    }

    public final String description(String backendKey) {
        kotlin.jvm.internal.g.f(backendKey, "backendKey");
        return backendKey.equals("MNN") ? "通用 MNN LLM（历史配置默认）" : backendKey.equals(MnnBackendKeys.MNN_EMBEDDING) ? "文本向量化" : backendKey.equals(MnnBackendKeys.MNN_CLIP) ? "图文检索 / 特征" : backendKey.equals(MnnBackendKeys.MNN_SEGMENT) ? "交互分割" : backendKey.equals(MnnBackendKeys.MNN_INPAINT) ? "图像修复（原图 + Mask）" : backendKey.equals(MnnBackendKeys.MNN_EXTEND) ? "图像外延扩展 / outpainting" : backendKey.equals(MnnBackendKeys.MNN_SUPER_RES) ? "图像超分辨率" : backendKey.equals(MnnBackendKeys.MNN_FACE) ? "人脸修复与增强" : backendKey.equals(MnnBackendKeys.MNN_FACE_DETECT) ? "人脸检测" : backendKey.equals(MnnBackendKeys.MNN_FACE_EMBED) ? "人脸特征" : backendKey.equals(MnnBackendKeys.MNN_FACE_QUALITY) ? "人脸质量" : "—";
    }
}
