package com.bytedance.android.livesdkapi.depend.model.live;

import com.bytedance.android.livesdkapi.depend.model.live.utils.BuildDiff;
import com.bytedance.ies.sdk.widgets.priority.PriorityModule;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\u0001\u0018\u0000 \u001f2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\u001fB3\b\u0002\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\tJ\b\u0010\u0010\u001a\u00020\u0011H\u0016J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0004H\u0016J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0014\u001a\u00020\u0006H\u0016J\b\u0010\u0015\u001a\u00020\u0006H\u0016R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000ej\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001e¨\u0006 "}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/LiveMode;", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/ILiveMode;", "_logStreamingType", "", "_isStreamingBackground", "", "_isUsingCamera", "_sceneName", "(Ljava/lang/String;ILjava/lang/String;ZZLjava/lang/String;)V", "get_isStreamingBackground", "()Z", "get_isUsingCamera", "get_logStreamingType", "()Ljava/lang/String;", "get_sceneName", "getIndex", "", "getLogStreamingType", "getSceneName", "isStreamingBackground", "isUsingCamera", "VIDEO", "AUDIO", "THIRD_PARTY", "GAME_GUIDE", "SCREEN_RECORD", "MEDIA", "OFFICIAL_ACTIVITY", "ACQUAINTANCE", "UNDEFINED", "Companion", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum LiveMode extends Enum<LiveMode> implements ILiveMode {
    private static final /* synthetic */ LiveMode[] $VALUES = null;
    public static final LiveMode ACQUAINTANCE = null;
    public static final LiveMode AUDIO = null;
    public static final Companion Companion = null;
    public static final LiveMode GAME_GUIDE = null;
    public static final LiveMode MEDIA = null;
    public static final LiveMode OFFICIAL_ACTIVITY = null;
    public static final String SCENE_ACQUAINTANCE = "acquaintance";
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

    @SerializedName("isStreamingBackground")
    private final boolean _isStreamingBackground;

    @SerializedName("isUsingCamera")
    private final boolean _isUsingCamera;

    @SerializedName("logStreamingType")
    private final String _logStreamingType;

    @SerializedName("sceneName")
    private final String _sceneName;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J\u0010\u0010\u0011\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0010J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0018R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/LiveMode$Companion;", "", "()V", "SCENE_ACQUAINTANCE", "", "SCENE_AUDIO", "SCENE_EXTERNAL", "SCENE_GAME", "SCENE_VIDEO", "SCHEME_SOURCE_PARAMS_CHAT_GUIDE", "SCHEME_SOURCE_PARAMS_ENTER_FROM", "SCHEME_SOURCE_PARAMS_LIVE_SCENE", "SHOW_CHAT_GUIDE", "convertLiveModeToLong", "", "livemode", "Lcom/bytedance/android/livesdkapi/depend/model/live/LiveMode;", "convertLiveModeToString", "liveMode", "createBySchemeLiveScene", "modeStr", "createBySchemeStartSource", "valueOf", "index", "", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Companion {

        @Metadata(k = 3, mv = {1, 5, 1})
        public final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;
            public static final /* synthetic */ int[] $EnumSwitchMapping$1 = null;

            static {
                int[] r100 = new int[LiveMode.values().length];
                $EnumSwitchMapping$0 = r100;
                LiveMode r101 = LiveMode.VIDEO;
                r100[r101.ordinal()] = 1;
                LiveMode r102 = LiveMode.MEDIA;
                r100[r102.ordinal()] = 2;
                LiveMode r103 = LiveMode.AUDIO;
                r100[r103.ordinal()] = 3;
                LiveMode r104 = LiveMode.SCREEN_RECORD;
                r100[r104.ordinal()] = 4;
                LiveMode r105 = LiveMode.THIRD_PARTY;
                r100[r105.ordinal()] = 5;
                r100[LiveMode.OFFICIAL_ACTIVITY.ordinal()] = 6;
                r100[LiveMode.ACQUAINTANCE.ordinal()] = 7;
                int[] r106 = new int[LiveMode.values().length];
                $EnumSwitchMapping$1 = r106;
                r106[r101.ordinal()] = 1;
                r106[r105.ordinal()] = 2;
                r106[r102.ordinal()] = 3;
                r106[r103.ordinal()] = 4;
                r106[r104.ordinal()] = 5;
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final long convertLiveModeToLong(LiveMode r100) {
            if (r100 != null) goto L5;
            return 0;
        L5:
            int r101 = WhenMappings.$EnumSwitchMapping$1[r100.ordinal()];
            if (r101 != 2) goto L8;
            return 1;
        L8:
            if (r101 != 3) goto L10;
            return 2;
        L10:
            if (r101 != 4) goto L12;
            return 3;
        L12:
            if (r101 == 5) goto L14;
            return 0;
        L14:
            return 4;
        }

        public final String convertLiveModeToString(LiveMode r100) {
            if (r100 != null) goto L5;
            return "undefined";
        L5:
            switch(WhenMappings.$EnumSwitchMapping$0[r100.ordinal()]) {
                case 1: goto L19;
                case 2: goto L17;
                case 3: goto L15;
                case 4: goto L13;
                case 5: goto L11;
                case 6: goto L9;
                case 7: goto L7;
                default: goto L23;
            };
        L7:
            return LiveMode.SCENE_ACQUAINTANCE;
        L9:
            return "official_activity";
        L11:
            return PriorityModule.SCENE_THIRD_PARTY;
        L13:
            return "game";
        L15:
            return "voice_live";
        L17:
            return "media";
        L19:
            return "video_live";
        L23:
            return "undefined";
        }

        public final LiveMode createBySchemeLiveScene(String r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            if (r100.length() != 0) goto L7;
            boolean r101 = true;
        L8:
            if (r101 == false) goto L11;
            return null;
        L11:
            switch(r100.hashCode()) {
                case -1820761141: goto L26;
                case -411550205: goto L23;
                case 3165170: goto L20;
                case 93166550: goto L17;
                case 112202875: goto L14;
                default: goto L40;
            };
        L40:
            return null;
        L14:
            if (r100.equals("video") == true) goto L31;
            return null;
        L31:
            return LiveMode.VIDEO;
        L17:
            if (r100.equals("audio") == true) goto L33;
            return null;
        L33:
            return LiveMode.AUDIO;
        L20:
            if (r100.equals("game") == true) goto L35;
            return null;
        L35:
            return LiveMode.SCREEN_RECORD;
        L23:
            if (r100.equals(LiveMode.SCENE_ACQUAINTANCE) == true) goto L37;
            return null;
        L37:
            return LiveMode.ACQUAINTANCE;
        L26:
            if (r100.equals("external") == true) goto L28;
            return null;
        L28:
            return LiveMode.THIRD_PARTY;
        L7:
            r101 = false;
            goto L8
        }

        public final LiveMode createBySchemeStartSource(String r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            if (r100.length() != 0) goto L7;
            boolean r101 = true;
        L8:
            if (r101 == false) goto L11;
            return null;
        L11:
            if (Intrinsics.areEqual(r100, "1") == true) goto L13;
            return null;
        L13:
            return LiveMode.AUDIO;
        L7:
            r101 = false;
            goto L8
        }

        public final LiveMode valueOf(int r100) {
            if (r100 < 0) goto L8;
            if (r100 >= LiveMode.values().length) goto L8;
            return LiveMode.values()[r100];
        L8:
            return LiveMode.UNDEFINED;
        }
    }

    public static LiveMode valueOf(String r100) {
        return (LiveMode) a.a(LiveMode.class, r100);
    }

    public static LiveMode[] values() {
        return (LiveMode[]) $VALUES.clone();
    }

    static {
        LiveMode r100 = new LiveMode("VIDEO", 0, "general", false, true, "video");
        VIDEO = r100;
        LiveMode r101 = new LiveMode("AUDIO", 1, "general", false, false, "audio");
        AUDIO = r101;
        LiveMode r102 = new LiveMode("THIRD_PARTY", 2, "thirdparty", true, false, PriorityModule.SCENE_THIRD_PARTY);
        THIRD_PARTY = r102;
        LiveMode r103 = new LiveMode("GAME_GUIDE", 3, "game_guide", false, false, "game_guide");
        GAME_GUIDE = r103;
        LiveMode r104 = new LiveMode("SCREEN_RECORD", 4, "game", true, false, "game");
        SCREEN_RECORD = r104;
        BuildDiff r105 = BuildDiff.INSTANCE;
        LiveMode r106 = new LiveMode("MEDIA", 5, "media", r105.isSaas(), !r105.isSaas(), "media");
        MEDIA = r106;
        LiveMode r107 = new LiveMode("OFFICIAL_ACTIVITY", 6, "official_activity", false, false, "official_activity");
        OFFICIAL_ACTIVITY = r107;
        LiveMode r108 = new LiveMode("ACQUAINTANCE", 7, SCENE_ACQUAINTANCE, false, false, SCENE_ACQUAINTANCE);
        ACQUAINTANCE = r108;
        LiveMode r109 = new LiveMode("UNDEFINED", 8, "undefined", false, false, "undefined");
        UNDEFINED = r109;
        $VALUES = new LiveMode[]{r100, r101, r102, r103, r104, r106, r107, r108, r109};
        Companion = new Companion(null);
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.ILiveMode
    public int getIndex() {
        return ordinal();
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.ILiveMode
    public String getLogStreamingType() {
        return this._logStreamingType;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.ILiveMode
    public String getSceneName() {
        return this._sceneName;
    }

    public final boolean get_isStreamingBackground() {
        return this._isStreamingBackground;
    }

    public final boolean get_isUsingCamera() {
        return this._isUsingCamera;
    }

    public final String get_logStreamingType() {
        return this._logStreamingType;
    }

    public final String get_sceneName() {
        return this._sceneName;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.ILiveMode
    public boolean isStreamingBackground() {
        return this._isStreamingBackground;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.ILiveMode
    public boolean isUsingCamera() {
        return this._isUsingCamera;
    }

    private LiveMode(String r100, int r101, String r102, boolean r103, boolean r104, String r105) {
        super(r100, r101);
        this._logStreamingType = r102;
        this._isStreamingBackground = r103;
        this._isUsingCamera = r104;
        this._sceneName = r105;
    }

    public /* synthetic */ LiveMode(String r110, int r111, String r112, boolean r113, boolean r114, String r115, int r116, DefaultConstructorMarker r117) {
        if ((r116 & 1) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r116 & 2) == 0) goto L9;
        boolean r101 = false;
    L11:
        if ((r116 & 4) == 0) goto L13;
        boolean r102 = false;
    L15:
        if ((r116 & 8) == 0) goto L17;
        String r103 = null;
    L18:
        this(r110, r111, r100, r101, r102, r103);
        return;
    L17:
        r103 = r115;
        goto L18
    L13:
        r102 = r114;
        goto L15
    L9:
        r101 = r113;
        goto L11
    L5:
        r100 = r112;
        goto L7
    }
}
