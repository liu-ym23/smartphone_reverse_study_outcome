package com.stepos.base.model;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ModelReleaseReason {

    /* renamed from: a, reason: collision with root package name */
    public static final ModelReleaseReason f6320a;

    /* renamed from: b, reason: collision with root package name */
    public static final ModelReleaseReason f6321b;

    /* renamed from: c, reason: collision with root package name */
    public static final ModelReleaseReason f6322c;

    /* renamed from: d, reason: collision with root package name */
    public static final ModelReleaseReason f6323d;

    /* renamed from: e, reason: collision with root package name */
    public static final ModelReleaseReason f6324e;
    public static final ModelReleaseReason h;

    /* renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ ModelReleaseReason[] f6325j;

    static {
        ModelReleaseReason modelReleaseReason = new ModelReleaseReason("SOFT_IDLE", 0);
        f6320a = modelReleaseReason;
        ModelReleaseReason modelReleaseReason2 = new ModelReleaseReason("HARD_EXPLICIT", 1);
        f6321b = modelReleaseReason2;
        ModelReleaseReason modelReleaseReason3 = new ModelReleaseReason("CLIENT_DEATH", 2);
        f6322c = modelReleaseReason3;
        ModelReleaseReason modelReleaseReason4 = new ModelReleaseReason("FRAMEWORK_RECYCLE", 3);
        f6323d = modelReleaseReason4;
        ModelReleaseReason modelReleaseReason5 = new ModelReleaseReason("LOAD_FAIL_ROLLBACK", 4);
        f6324e = modelReleaseReason5;
        ModelReleaseReason modelReleaseReason6 = new ModelReleaseReason("VERSION_SWAP", 5);
        h = modelReleaseReason6;
        ModelReleaseReason[] modelReleaseReasonArr = {modelReleaseReason, modelReleaseReason2, modelReleaseReason3, modelReleaseReason4, modelReleaseReason5, modelReleaseReason6, new ModelReleaseReason("LEAK_MONITOR", 6)};
        f6325j = modelReleaseReasonArr;
        kotlin.enums.a.a(modelReleaseReasonArr);
    }

    public ModelReleaseReason() {
        throw null;
    }

    public static ModelReleaseReason valueOf(String str) {
        return (ModelReleaseReason) Enum.valueOf(ModelReleaseReason.class, str);
    }

    public static ModelReleaseReason[] values() {
        return (ModelReleaseReason[]) f6325j.clone();
    }
}
