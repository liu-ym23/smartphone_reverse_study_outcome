package com.bytedance.android.live.revlink.impl.settings.config;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import r41.c;
import r41.i;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b&\u0018\u00002\u00020\u0001:\u0001'B\u0007¢\u0006\u0004\b%\u0010&R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001a\u0010\u000f\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006R\u001a\u0010\u0011\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006R\u001a\u0010\u0013\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006R\u001a\u0010\u0015\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006R\u001a\u0010\u0017\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006R\u001a\u0010\u0019\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006R\u001a\u0010\u001b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u0004\u001a\u0004\b\u001c\u0010\u0006R\u001a\u0010\u001d\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u0004\u001a\u0004\b\u001e\u0010\u0006R\u001a\u0010\u001f\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010\u0004\u001a\u0004\b \u0010\u0006R\u001a\u0010!\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010\u0004\u001a\u0004\b\"\u0010\u0006R\u001a\u0010#\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b#\u0010\u0004\u001a\u0004\b$\u0010\u0006¨\u0006("}, d2 = {"Lcom/bytedance/android/live/revlink/impl/settings/config/PKSimpleAtmosphereAnimationUrlSerializableObjectImpl;", "Lr41/i;", "", "middleUrl", "Ljava/lang/String;", "getMiddleUrl", "()Ljava/lang/String;", "pkInProgressUrl", "getPkInProgressUrl", "pkInProgressAdditionalUrl", "getPkInProgressAdditionalUrl", "pkInProgressAdditionalTailUrl", "getPkInProgressAdditionalTailUrl", "winEmojiUrl", "getWinEmojiUrl", "loseEmojiUrl", "getLoseEmojiUrl", "tieEmojiUrl", "getTieEmojiUrl", "leftStarAnim", "getLeftStarAnim", "rightStarAnim", "getRightStarAnim", "pkSeasonLeftPng", "getPkSeasonLeftPng", "pkSeasonRightPng", "getPkSeasonRightPng", "teamTaskOpt", "getTeamTaskOpt", "giftSendAnim", "getGiftSendAnim", "pkRoomOptStealTower", "getPkRoomOptStealTower", "pkRoomOptBarBg", "getPkRoomOptBarBg", "pkRoomOptTeamTaskGiftSendAnim", "getPkRoomOptTeamTaskGiftSendAnim", "<init>", "()V", "Adapter", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PKSimpleAtmosphereAnimationUrlSerializableObjectImpl implements i {

    @SerializedName("team_task_opt_gift_send")
    private final String giftSendAnim;

    @SerializedName("left_star_anim")
    private final String leftStarAnim;

    @SerializedName("lose_emoji_url")
    private final String loseEmojiUrl;

    @SerializedName("middle_url")
    private final String middleUrl;

    @SerializedName("pk_in_progress_in_additional_tail_url")
    private final String pkInProgressAdditionalTailUrl;

    @SerializedName("pk_in_progress_in_additional_url")
    private final String pkInProgressAdditionalUrl;

    @SerializedName("pk_in_progress_url")
    private final String pkInProgressUrl;

    @SerializedName("pk_room_opt_bar_up_bg")
    private final String pkRoomOptBarBg;

    @SerializedName("pk_room_opt_steal_tower_tail")
    private final String pkRoomOptStealTower;

    @SerializedName("pk_room_opt_team_task_gift_send_anim")
    private final String pkRoomOptTeamTaskGiftSendAnim;

    @SerializedName("pk_season_left_anim")
    private final String pkSeasonLeftPng;

    @SerializedName("pk_seaon_right_anim")
    private final String pkSeasonRightPng;

    @SerializedName("right_star_anim")
    private final String rightStarAnim;

    @SerializedName("team_task_opt")
    private final String teamTaskOpt;

    @SerializedName("tie_emoji_url")
    private final String tieEmojiUrl;

    @SerializedName("win_emoji_url")
    private final String winEmojiUrl;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/settings/config/PKSimpleAtmosphereAnimationUrlSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(PKSimpleAtmosphereAnimationUrlSerializableObjectImpl.class);
        }
    }

    public PKSimpleAtmosphereAnimationUrlSerializableObjectImpl() {
        int r100 = c.f536017a;
        this.middleUrl = "https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/simple_pk_progressbar_middle_anim.webp";
        this.pkInProgressUrl = "https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/simple_pk_progressbar_normal_anim.webp";
        this.pkInProgressAdditionalUrl = "https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/simple_pk_progressbar_anim_additional.webp";
        this.pkInProgressAdditionalTailUrl = "https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/simple_pk_progressbar_anim_additional_tail2.webp";
        this.winEmojiUrl = "https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/simple_pk_win_emoji.webp";
        this.loseEmojiUrl = "https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/simple_pk_lose_emoji.webp";
        this.tieEmojiUrl = "https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/simple_pk_tie_emoji.webp";
        this.leftStarAnim = "https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/pk_atmosphere_left_anim_douyin.webp";
        this.rightStarAnim = "https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/pk_atmosphere_right_anim.webp";
        this.pkSeasonLeftPng = "https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/ttlive_pk_season_bg_left.png";
        this.pkSeasonRightPng = "https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/ttlive_pk_season_bg_right.png";
        this.teamTaskOpt = "https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/ttlive_team_task_opt_progress.webp";
        this.giftSendAnim = "https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/ttlive_team_task_opt_gift_send_anim.webp";
        this.pkRoomOptStealTower = "https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/ttlive_pk_room_opt_steal_tower.webp";
        this.pkRoomOptBarBg = "https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/ttlive_pk_room_opt_bar_bg.png";
        this.pkRoomOptTeamTaskGiftSendAnim = "https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/ttlive_pk_room_opt_team_task_gift_send_anim.webp";
    }
}
