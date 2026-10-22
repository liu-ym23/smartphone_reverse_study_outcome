package com.bytedance.android.anniex.scene.core;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/anniex/scene/core/SceneOrigin;", "", "HYBRID", "NA_PAGE", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum SceneOrigin extends Enum<SceneOrigin> {
    public static final SceneOrigin HYBRID = null;
    public static final SceneOrigin NA_PAGE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SceneOrigin[] f41106a = null;

    public static SceneOrigin valueOf(String r100) {
        return (SceneOrigin) r27.a.a(SceneOrigin.class, r100);
    }

    public static SceneOrigin[] values() {
        return (SceneOrigin[]) f41106a.clone();
    }

    static {
        SceneOrigin r100 = new SceneOrigin("HYBRID", 0);
        HYBRID = r100;
        SceneOrigin r101 = new SceneOrigin("NA_PAGE", 1);
        NA_PAGE = r101;
        f41106a = new SceneOrigin[]{r100, r101};
    }

    public SceneOrigin(String r100, int r101) {
        super(r100, r101);
    }
}
