package com.bytedance.android.livesdkapi.distribution;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdkapi/distribution/LiveExternalScene;", "", "scene", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getScene", "()Ljava/lang/String;", "SCENE_ECOM_SHOP_MULTI", "SCENE_PREVIEW_DETAIL", "SCENE_INNER_PREVIEW", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveExternalScene extends Enum<LiveExternalScene> {
    private static final /* synthetic */ LiveExternalScene[] $VALUES = null;
    public static final LiveExternalScene SCENE_ECOM_SHOP_MULTI = null;
    public static final LiveExternalScene SCENE_INNER_PREVIEW = null;
    public static final LiveExternalScene SCENE_PREVIEW_DETAIL = null;
    private final String scene;

    static {
        LiveExternalScene r100 = new LiveExternalScene("SCENE_ECOM_SHOP_MULTI", 0, "SCENE_ECOM_SHOP_MULTI");
        SCENE_ECOM_SHOP_MULTI = r100;
        LiveExternalScene r101 = new LiveExternalScene("SCENE_PREVIEW_DETAIL", 1, "SCENE_PREVIEW_DETAIL");
        SCENE_PREVIEW_DETAIL = r101;
        LiveExternalScene r102 = new LiveExternalScene("SCENE_INNER_PREVIEW", 2, "SCENE_INNER_PREVIEW");
        SCENE_INNER_PREVIEW = r102;
        $VALUES = new LiveExternalScene[]{r100, r101, r102};
    }

    public static LiveExternalScene valueOf(String r100) {
        return (LiveExternalScene) a.a(LiveExternalScene.class, r100);
    }

    public static LiveExternalScene[] values() {
        return (LiveExternalScene[]) $VALUES.clone();
    }

    public final String getScene() {
        return this.scene;
    }

    private LiveExternalScene(String r100, int r101, String r102) {
        super(r100, r101);
        this.scene = r102;
    }
}
