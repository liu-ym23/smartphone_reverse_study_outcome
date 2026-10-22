package com.stepos.base.model.data;

import com.stepos.core.ability.speech.VadSessionManager;
import com.stepos.core.common.util.TraceIdKeys;
import kotlin.enums.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ModelType {

    /* renamed from: c, reason: collision with root package name */
    public static final ModelType f6364c;

    /* renamed from: d, reason: collision with root package name */
    public static final ModelType f6365d;

    /* renamed from: e, reason: collision with root package name */
    public static final ModelType f6366e;
    public static final ModelType h;

    /* renamed from: j, reason: collision with root package name */
    public static final ModelType f6367j;

    /* renamed from: k, reason: collision with root package name */
    public static final ModelType f6368k;

    /* renamed from: l, reason: collision with root package name */
    public static final ModelType f6369l;

    /* renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ ModelType[] f6370m;

    /* renamed from: a, reason: collision with root package name */
    public final int f6371a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f6372b;

    static {
        ModelType modelType = new ModelType("LLM", 0, 2048, true);
        f6364c = modelType;
        ModelType modelType2 = new ModelType("VLM", 1, 3072, true);
        f6365d = modelType2;
        ModelType modelType3 = new ModelType("ASR", 2, VadSessionManager.FRAME_BYTES, false);
        f6366e = modelType3;
        ModelType modelType4 = new ModelType("TTS", 3, 256, true);
        h = modelType4;
        ModelType modelType5 = new ModelType("IMAGE_CLASSIFICATION", 4, TraceIdKeys.MAX_LENGTH, false);
        f6367j = modelType5;
        ModelType modelType6 = new ModelType("OBJECT_DETECTION", 5, 256, false);
        ModelType modelType7 = new ModelType("IMAGE_SEGMENTATION", 6, VadSessionManager.FRAME_BYTES, false);
        ModelType modelType8 = new ModelType("FACE_RECOGNITION", 7, TraceIdKeys.MAX_LENGTH, false);
        f6368k = modelType8;
        ModelType modelType9 = new ModelType("GESTURE_RECOGNITION", 8, 64, false);
        ModelType modelType10 = new ModelType("GENERAL", 9, 256, false);
        f6369l = modelType10;
        ModelType[] modelTypeArr = {modelType, modelType2, modelType3, modelType4, modelType5, modelType6, modelType7, modelType8, modelType9, modelType10};
        f6370m = modelTypeArr;
        a.a(modelTypeArr);
    }

    public ModelType(String str, int i10, int i11, boolean z) {
        this.f6371a = i11;
        this.f6372b = z;
    }

    public static ModelType valueOf(String str) {
        return (ModelType) Enum.valueOf(ModelType.class, str);
    }

    public static ModelType[] values() {
        return (ModelType[]) f6370m.clone();
    }
}
