package com.bytedance.android.gamecp.common.model.live;

import com.bytedance.android.gamecp.host_api.GameCpTargetUtils;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes44.dex */
public final enum LiveMode extends Enum<LiveMode> {
    public static final LiveMode ACQUAINTANCE = null;
    public static final LiveMode AUDIO = null;
    public static final LiveMode MEDIA = null;
    public static final LiveMode OFFICIAL_ACTIVITY = null;
    public static final String SCENE_AUDIO = "audio";
    public static final String SCENE_EXTERNAL = "external";
    public static final String SCENE_GAME = "game";
    public static final String SCENE_VIDEO = "video";
    public static final String SCHEME_SOURCE_PARAMS_CHAT_GUIDE = "enable_show_chat_tip";
    public static final String SCHEME_SOURCE_PARAMS_ENTER_FROM = "enter_from";
    public static final String SCHEME_SOURCE_PARAMS_LIVE_SCENE = "live_scene";
    public static final LiveMode SCREEN_RECORD = null;
    public static final String SHOW_CHAT_GUIDE = "1";
    public static final LiveMode THIRD_PARTY = null;
    public static final LiveMode UNDEFINED = null;
    public static final LiveMode VIDEO = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveMode[] f56535a = null;

    @SerializedName("isStreamingBackground")
    public final boolean isStreamingBackground;

    @SerializedName("isUsingCamera")
    public final boolean isUsingCamera;

    @SerializedName("logStreamingType")
    public final String logStreamingType;

    static {
        LiveMode r100 = new LiveMode("VIDEO", 0, "general", false, true);
        VIDEO = r100;
        LiveMode r101 = new LiveMode("AUDIO", 1, "general", false, false);
        AUDIO = r101;
        LiveMode r102 = new LiveMode("THIRD_PARTY", 2, "thirdparty", true, false);
        THIRD_PARTY = r102;
        LiveMode r103 = new LiveMode("SCREEN_RECORD", 3, "game", true, false);
        SCREEN_RECORD = r103;
        LiveMode r104 = new LiveMode("MEDIA", 4, "media", isStreamingBackgroundForMedia(), isUserCameraForMedia());
        MEDIA = r104;
        LiveMode r105 = new LiveMode("OFFICIAL_ACTIVITY", 5, "official_activity", false, false);
        OFFICIAL_ACTIVITY = r105;
        LiveMode r106 = new LiveMode("ACQUAINTANCE", 6, com.bytedance.android.livesdkapi.depend.model.live.LiveMode.SCENE_ACQUAINTANCE, false, false);
        ACQUAINTANCE = r106;
        LiveMode r110 = new LiveMode("UNDEFINED", 7, "undefined", false, false);
        UNDEFINED = r110;
        f56535a = new LiveMode[]{r100, r101, r102, r103, r104, r105, r106, r110};
    }

    public static LiveMode[] values() {
        return (LiveMode[]) f56535a.clone();
    }

    public static boolean isStreamingBackgroundForMedia() {
        if (GameCpTargetUtils.a() != 32) goto L5;
    L8:
        return true;
    L5:
        if (GameCpTargetUtils.a() == 13) goto L8;
        return false;
    }

    public static boolean isUserCameraForMedia() {
        if (GameCpTargetUtils.a() != 32) goto L5;
    L8:
        boolean r100 = true;
    L10:
        return !r100;
    L5:
        if (GameCpTargetUtils.a() == 13) goto L8;
        r100 = false;
        goto L10
    }

    public static LiveMode valueOf(String r100) {
        return (LiveMode) r27.a.a(LiveMode.class, r100);
    }

    public LiveMode(String r100, int r101, String r102, boolean r103, boolean r104) {
        super(r100, r101);
        this.logStreamingType = r102;
        this.isStreamingBackground = r103;
        this.isUsingCamera = r104;
    }
}
