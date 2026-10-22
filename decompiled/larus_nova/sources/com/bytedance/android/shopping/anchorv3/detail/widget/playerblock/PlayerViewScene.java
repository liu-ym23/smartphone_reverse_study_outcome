package com.bytedance.android.shopping.anchorv3.detail.widget.playerblock;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/detail/widget/playerblock/PlayerViewScene;", "", "", "type", "I", "getType", "()I", "SCENE_PRODUCT_VIDEO", "SCENE_COMMENT_VIDEO", "SCENE_PLAY_BACK_VIDEO", "SCENE_FLOAT_WINDOW_VIDEO", "SCENE_HEAD_MORE_VIDEO", "SCENE_HEAD_GALLERY_VIDEO", "SCENE_OTHERS", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PlayerViewScene extends Enum<PlayerViewScene> {
    public static final PlayerViewScene SCENE_COMMENT_VIDEO = null;
    public static final PlayerViewScene SCENE_FLOAT_WINDOW_VIDEO = null;
    public static final PlayerViewScene SCENE_HEAD_GALLERY_VIDEO = null;
    public static final PlayerViewScene SCENE_HEAD_MORE_VIDEO = null;
    public static final PlayerViewScene SCENE_OTHERS = null;
    public static final PlayerViewScene SCENE_PLAY_BACK_VIDEO = null;
    public static final PlayerViewScene SCENE_PRODUCT_VIDEO = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PlayerViewScene[] f164967a = null;
    private final int type;

    static {
        PlayerViewScene r100 = new PlayerViewScene("SCENE_PRODUCT_VIDEO", 0, 0);
        SCENE_PRODUCT_VIDEO = r100;
        PlayerViewScene r101 = new PlayerViewScene("SCENE_COMMENT_VIDEO", 1, 1);
        SCENE_COMMENT_VIDEO = r101;
        PlayerViewScene r102 = new PlayerViewScene("SCENE_PLAY_BACK_VIDEO", 2, 2);
        SCENE_PLAY_BACK_VIDEO = r102;
        PlayerViewScene r103 = new PlayerViewScene("SCENE_FLOAT_WINDOW_VIDEO", 3, 3);
        SCENE_FLOAT_WINDOW_VIDEO = r103;
        PlayerViewScene r104 = new PlayerViewScene("SCENE_HEAD_MORE_VIDEO", 4, 4);
        SCENE_HEAD_MORE_VIDEO = r104;
        PlayerViewScene r105 = new PlayerViewScene("SCENE_HEAD_GALLERY_VIDEO", 5, 5);
        SCENE_HEAD_GALLERY_VIDEO = r105;
        PlayerViewScene r106 = new PlayerViewScene("SCENE_OTHERS", 6, 6);
        SCENE_OTHERS = r106;
        f164967a = new PlayerViewScene[]{r100, r101, r102, r103, r104, r105, r106};
    }

    public static PlayerViewScene valueOf(String r100) {
        return (PlayerViewScene) r27.a.a(PlayerViewScene.class, r100);
    }

    public static PlayerViewScene[] values() {
        return (PlayerViewScene[]) f164967a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public PlayerViewScene(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
