package com.bytedance.android.shopping.anchorv3.detail.widget.playerblock;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/detail/widget/playerblock/PlayAbilityCacheScene;", "", "", "scenePrefix", "Ljava/lang/String;", "getScenePrefix", "()Ljava/lang/String;", "SCENE_BASE_PD_VIDEO_VIEW", "SCENE_HEADER", "SCENE_GALLERY_VIDEO", "SCENE_MORE_VIDEO", "SCENE_FLOAT_VIDEO", "SCENE_PLAYER_BLOCK", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PlayAbilityCacheScene extends Enum<PlayAbilityCacheScene> {
    public static final PlayAbilityCacheScene SCENE_BASE_PD_VIDEO_VIEW = null;
    public static final PlayAbilityCacheScene SCENE_FLOAT_VIDEO = null;
    public static final PlayAbilityCacheScene SCENE_GALLERY_VIDEO = null;
    public static final PlayAbilityCacheScene SCENE_HEADER = null;
    public static final PlayAbilityCacheScene SCENE_MORE_VIDEO = null;
    public static final PlayAbilityCacheScene SCENE_PLAYER_BLOCK = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PlayAbilityCacheScene[] f164932a = null;
    private final String scenePrefix;

    static {
        PlayAbilityCacheScene r100 = new PlayAbilityCacheScene("SCENE_BASE_PD_VIDEO_VIEW", 0, "base_pd_video_view");
        SCENE_BASE_PD_VIDEO_VIEW = r100;
        PlayAbilityCacheScene r101 = new PlayAbilityCacheScene("SCENE_HEADER", 1, "header");
        SCENE_HEADER = r101;
        PlayAbilityCacheScene r102 = new PlayAbilityCacheScene("SCENE_GALLERY_VIDEO", 2, "gallery_video");
        SCENE_GALLERY_VIDEO = r102;
        PlayAbilityCacheScene r103 = new PlayAbilityCacheScene("SCENE_MORE_VIDEO", 3, "more_video");
        SCENE_MORE_VIDEO = r103;
        PlayAbilityCacheScene r104 = new PlayAbilityCacheScene("SCENE_FLOAT_VIDEO", 4, "float_video");
        SCENE_FLOAT_VIDEO = r104;
        PlayAbilityCacheScene r105 = new PlayAbilityCacheScene("SCENE_PLAYER_BLOCK", 5, "player_block");
        SCENE_PLAYER_BLOCK = r105;
        f164932a = new PlayAbilityCacheScene[]{r100, r101, r102, r103, r104, r105};
    }

    public static PlayAbilityCacheScene valueOf(String r100) {
        return (PlayAbilityCacheScene) r27.a.a(PlayAbilityCacheScene.class, r100);
    }

    public static PlayAbilityCacheScene[] values() {
        return (PlayAbilityCacheScene[]) f164932a.clone();
    }

    public final String getScenePrefix() {
        return this.scenePrefix;
    }

    public PlayAbilityCacheScene(String r100, int r101, String r102) {
        super(r100, r101);
        this.scenePrefix = r102;
    }
}
