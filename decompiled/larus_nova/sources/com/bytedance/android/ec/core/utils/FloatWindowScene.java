package com.bytedance.android.ec.core.utils;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/ec/core/utils/FloatWindowScene;", "", "DEFAULT", "SCENE_3D", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum FloatWindowScene extends Enum<FloatWindowScene> {
    public static final FloatWindowScene DEFAULT = null;
    public static final FloatWindowScene SCENE_3D = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FloatWindowScene[] f45529a = null;

    static {
        FloatWindowScene r100 = new FloatWindowScene("DEFAULT", 0);
        DEFAULT = r100;
        FloatWindowScene r101 = new FloatWindowScene("SCENE_3D", 1);
        SCENE_3D = r101;
        f45529a = new FloatWindowScene[]{r100, r101};
    }

    public static FloatWindowScene valueOf(String r100) {
        return (FloatWindowScene) r27.a.a(FloatWindowScene.class, r100);
    }

    public static FloatWindowScene[] values() {
        return (FloatWindowScene[]) f45529a.clone();
    }

    public FloatWindowScene(String r100, int r101) {
        super(r100, r101);
    }
}
