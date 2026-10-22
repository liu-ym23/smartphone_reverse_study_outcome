package com.bytedance.android.livesdkapi.replay.paid;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Retention(RetentionPolicy.RUNTIME)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdkapi/replay/paid/PaidReplayScene;", "", "Companion", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public @interface PaidReplayScene {
    public static final Companion Companion = null;
    public static final String SCENE_LVIDEO_THEATER = "lvideo_theater";
    public static final String SCENE_LYNX_VIEW = "lynx_view";
    public static final String SCENE_ML_VIDEO = "ml_video";
    public static final String SCENE_SEARCH_CARD = "search_card";

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdkapi/replay/paid/PaidReplayScene$Companion;", "", "()V", "SCENE_LVIDEO_THEATER", "", "SCENE_LYNX_VIEW", "SCENE_ML_VIDEO", "SCENE_SEARCH_CARD", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        public static final String SCENE_LVIDEO_THEATER = "lvideo_theater";
        public static final String SCENE_LYNX_VIEW = "lynx_view";
        public static final String SCENE_ML_VIDEO = "ml_video";
        public static final String SCENE_SEARCH_CARD = "search_card";

        private Companion() {
        }

        static {
            $$INSTANCE = new Companion();
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }
}
