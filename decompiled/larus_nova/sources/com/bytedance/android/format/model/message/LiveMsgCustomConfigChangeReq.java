package com.bytedance.android.format.model.message;

import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u0007\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001)B\u0007¢\u0006\u0004\b'\u0010(R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0017\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R$\u0010\u001a\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0012\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016R$\u0010\u001d\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0012\u001a\u0004\b\u001e\u0010\u0014\"\u0004\b\u001f\u0010\u0016R\"\u0010!\u001a\u00020 8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u0006*"}, d2 = {"Lcom/bytedance/android/format/model/message/LiveMsgCustomConfigChangeReq;", "", "", "customConfigType", "I", "getCustomConfigType", "()I", "setCustomConfigType", "(I)V", "", "enable", "Z", "getEnable", "()Z", "setEnable", "(Z)V", "", "aiMotionAppId", "Ljava/lang/String;", "getAiMotionAppId", "()Ljava/lang/String;", "setAiMotionAppId", "(Ljava/lang/String;)V", "actionId", "getActionId", "setActionId", "musicUri", "getMusicUri", "setMusicUri", "sceneAssetId", "getSceneAssetId", "setSceneAssetId", "", "bgmVolume", FaceService.girlLabel, "getBgmVolume", "()F", "setBgmVolume", "(F)V", "<init>", "()V", "CustomConfigType", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveMsgCustomConfigChangeReq {

    @SerializedName("action_id")
    private String actionId;

    @SerializedName("aimotion_app_id")
    private String aiMotionAppId;

    @SerializedName("bgm_volume")
    private float bgmVolume;

    @SerializedName("custom_config_type")
    private int customConfigType;

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("music_uri")
    private String musicUri;

    @SerializedName("scene_asset_id")
    private String sceneAssetId;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/format/model/message/LiveMsgCustomConfigChangeReq$CustomConfigType;", "", "", "type", "I", "getType", "()I", "CustomConfigType_Unknown", "CustomConfigType_BGM", "CustomConfigType_BgScene", "CustomConfigType_BgMusic", "CustomConfigType_AimotionStyle", "CustomConfigType_TriggerAction", "CustomConfigType_BgMusicVolume", "CustomConfig_PlayIdle", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum CustomConfigType extends Enum<CustomConfigType> {
        public static final CustomConfigType CustomConfigType_AimotionStyle = null;
        public static final CustomConfigType CustomConfigType_BGM = null;
        public static final CustomConfigType CustomConfigType_BgMusic = null;
        public static final CustomConfigType CustomConfigType_BgMusicVolume = null;
        public static final CustomConfigType CustomConfigType_BgScene = null;
        public static final CustomConfigType CustomConfigType_TriggerAction = null;
        public static final CustomConfigType CustomConfigType_Unknown = null;
        public static final CustomConfigType CustomConfig_PlayIdle = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ CustomConfigType[] f51353a = null;
        private final int type;

        public static CustomConfigType valueOf(String r100) {
            return (CustomConfigType) a.a(CustomConfigType.class, r100);
        }

        public static CustomConfigType[] values() {
            return (CustomConfigType[]) f51353a.clone();
        }

        static {
            CustomConfigType r100 = new CustomConfigType("CustomConfigType_Unknown", 0, 0);
            CustomConfigType_Unknown = r100;
            CustomConfigType r101 = new CustomConfigType("CustomConfigType_BGM", 1, 1);
            CustomConfigType_BGM = r101;
            CustomConfigType r102 = new CustomConfigType("CustomConfigType_BgScene", 2, 2);
            CustomConfigType_BgScene = r102;
            CustomConfigType r103 = new CustomConfigType("CustomConfigType_BgMusic", 3, 3);
            CustomConfigType_BgMusic = r103;
            CustomConfigType r104 = new CustomConfigType("CustomConfigType_AimotionStyle", 4, 4);
            CustomConfigType_AimotionStyle = r104;
            CustomConfigType r105 = new CustomConfigType("CustomConfigType_TriggerAction", 5, 5);
            CustomConfigType_TriggerAction = r105;
            CustomConfigType r106 = new CustomConfigType("CustomConfigType_BgMusicVolume", 6, 6);
            CustomConfigType_BgMusicVolume = r106;
            CustomConfigType r107 = new CustomConfigType("CustomConfig_PlayIdle", 7, 7);
            CustomConfig_PlayIdle = r107;
            f51353a = new CustomConfigType[]{r100, r101, r102, r103, r104, r105, r106, r107};
        }

        public final int getType() {
            return this.type;
        }

        public CustomConfigType(String r100, int r101, int r102) {
            super(r100, r101);
            this.type = r102;
        }
    }

    public LiveMsgCustomConfigChangeReq() {
        this.customConfigType = CustomConfigType.CustomConfigType_Unknown.getType();
        this.bgmVolume = 0.5f;
    }
}
