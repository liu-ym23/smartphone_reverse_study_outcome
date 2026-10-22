package com.bytedance.android.live.recharge.panel;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/recharge/panel/RechargeBizScene;", "", "", "scene", "I", "getScene", "()I", "SCENE_NORMAL", "SCENE_PK_NOPASSWORD", "SCENE_FANS_NOPASSWORD", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum RechargeBizScene extends Enum<RechargeBizScene> {
    public static final RechargeBizScene SCENE_FANS_NOPASSWORD = null;
    public static final RechargeBizScene SCENE_NORMAL = null;
    public static final RechargeBizScene SCENE_PK_NOPASSWORD = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RechargeBizScene[] f90148a = null;
    private final int scene;

    static {
        RechargeBizScene r100 = new RechargeBizScene("SCENE_NORMAL", 0, 0);
        SCENE_NORMAL = r100;
        RechargeBizScene r101 = new RechargeBizScene("SCENE_PK_NOPASSWORD", 1, 1);
        SCENE_PK_NOPASSWORD = r101;
        RechargeBizScene r102 = new RechargeBizScene("SCENE_FANS_NOPASSWORD", 2, 2);
        SCENE_FANS_NOPASSWORD = r102;
        f90148a = new RechargeBizScene[]{r100, r101, r102};
    }

    public static RechargeBizScene valueOf(String r100) {
        return (RechargeBizScene) r27.a.a(RechargeBizScene.class, r100);
    }

    public static RechargeBizScene[] values() {
        return (RechargeBizScene[]) f90148a.clone();
    }

    public final int getScene() {
        return this.scene;
    }

    public RechargeBizScene(String r100, int r101, int r102) {
        super(r100, r101);
        this.scene = r102;
    }
}
