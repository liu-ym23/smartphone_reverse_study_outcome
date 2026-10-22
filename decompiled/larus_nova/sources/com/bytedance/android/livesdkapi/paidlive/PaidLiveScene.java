package com.bytedance.android.livesdkapi.paidlive;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdkapi/paidlive/PaidLiveScene;", "", "()V", "SCENE_FEED_PREVIEW", "", "SCENE_GENERAL_SEARCH_PREVIEW", "SCENE_IM_CARD", "SCENE_LVIDEO_THEATER", "SCENE_LYNX_VIEW", "SCENE_ML_VIDEO", "SCENE_PROFILE_CARD", "SCENE_SEARCH_LIVE_PREVIEW", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PaidLiveScene {
    public static final PaidLiveScene INSTANCE = null;
    public static final int SCENE_FEED_PREVIEW = 2;
    public static final int SCENE_GENERAL_SEARCH_PREVIEW = 0;
    public static final int SCENE_IM_CARD = 4;
    public static final int SCENE_LVIDEO_THEATER = 7;
    public static final int SCENE_LYNX_VIEW = 6;
    public static final int SCENE_ML_VIDEO = 5;
    public static final int SCENE_PROFILE_CARD = 3;
    public static final int SCENE_SEARCH_LIVE_PREVIEW = 1;

    private PaidLiveScene() {
    }

    static {
        INSTANCE = new PaidLiveScene();
    }
}
