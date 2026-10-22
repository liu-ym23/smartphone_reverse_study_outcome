package com.bytedance.android.livesdk.model;

import com.amap.api.col.s.ce;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b8\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b8\u00109R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\"\u0010\u0018\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\"\u0010\u001b\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0004\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\"\u0010\u001e\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0004\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR\"\u0010!\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\u0004\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR\"\u0010$\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010\u0004\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\bR\u001a\u0010'\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b'\u0010\u0004\u001a\u0004\b(\u0010\u0006R\"\u0010)\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b)\u0010\u0004\u001a\u0004\b*\u0010\u0006\"\u0004\b+\u0010\bR\"\u0010,\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b,\u0010\u0004\u001a\u0004\b-\u0010\u0006\"\u0004\b.\u0010\bR\"\u0010/\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b/\u0010\u0004\u001a\u0004\b0\u0010\u0006\"\u0004\b1\u0010\bR\"\u00102\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b2\u0010\u0004\u001a\u0004\b3\u0010\u0006\"\u0004\b4\u0010\bR\"\u00105\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b5\u0010\u0004\u001a\u0004\b6\u0010\u0006\"\u0004\b7\u0010\b¨\u0006:"}, d2 = {"Lcom/bytedance/android/livesdk/model/h0;", "", "", "middleUrl", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setMiddleUrl", "(Ljava/lang/String;)V", "pkInProgressUrl", "getPkInProgressUrl", "setPkInProgressUrl", "pkInProgressAdditionalUrl", "getPkInProgressAdditionalUrl", "setPkInProgressAdditionalUrl", "livePkScoreAnimationUrl", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setLivePkScoreAnimationUrl", "pkInProgressAdditionalTailUrl", "d", "setPkInProgressAdditionalTailUrl", "winEmojiUrl", ce.f26391f, "setWinEmojiUrl", "loseEmojiUrl", "b", "setLoseEmojiUrl", "tieEmojiUrl", "f", "setTieEmojiUrl", "leftStarAnim", "getLeftStarAnim", "setLeftStarAnim", "rightStarAnim", "getRightStarAnim", "setRightStarAnim", "pkSeasonLeftPng", "getPkSeasonLeftPng", "setPkSeasonLeftPng", "pkSeasonRightPng", "getPkSeasonRightPng", "teamTaskOpt", "e", "setTeamTaskOpt", "giftSendAnim", "getGiftSendAnim", "setGiftSendAnim", "pkRoomOptStealTower", "getPkRoomOptStealTower", "setPkRoomOptStealTower", "pkRoomOptBarBg", "getPkRoomOptBarBg", "setPkRoomOptBarBg", "pkRoomOptTeamTaskGiftSendAnim", "getPkRoomOptTeamTaskGiftSendAnim", "setPkRoomOptTeamTaskGiftSendAnim", "<init>", "()V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class h0 {

    @SerializedName("team_task_opt_gift_send")
    private String giftSendAnim;

    @SerializedName("left_star_anim")
    private String leftStarAnim;

    @SerializedName("live_pk_score_animation_url")
    private String livePkScoreAnimationUrl;

    @SerializedName("lose_emoji_url")
    private String loseEmojiUrl;

    @SerializedName("middle_url")
    private String middleUrl;

    @SerializedName("pk_in_progress_in_additional_tail_url")
    private String pkInProgressAdditionalTailUrl;

    @SerializedName("pk_in_progress_in_additional_url")
    private String pkInProgressAdditionalUrl;

    @SerializedName("pk_in_progress_url")
    private String pkInProgressUrl;

    @SerializedName("pk_room_opt_bar_up_bg")
    private String pkRoomOptBarBg;

    @SerializedName("pk_room_opt_steal_tower_tail")
    private String pkRoomOptStealTower;

    @SerializedName("pk_room_opt_team_task_gift_send_anim")
    private String pkRoomOptTeamTaskGiftSendAnim;

    @SerializedName("pk_season_left_anim")
    private String pkSeasonLeftPng;

    @SerializedName("pk_seaon_right_anim")
    private final String pkSeasonRightPng;

    @SerializedName("right_star_anim")
    private String rightStarAnim;

    @SerializedName("team_task_opt")
    private String teamTaskOpt;

    @SerializedName("tie_emoji_url")
    private String tieEmojiUrl;

    @SerializedName("win_emoji_url")
    private String winEmojiUrl;

    public h0() {
        StringBuilder r100 = new StringBuilder("https://");
        LiveCommonConstants r101 = LiveCommonConstants.INSTANCE;
        r100.append(r101.getObjectTosPath());
        r100.append("/obj/live-android/simple_pk_progressbar_middle_anim.webp");
        this.middleUrl = r100.toString();
        this.pkInProgressUrl = "https://" + r101.getObjectTosPath() + "/obj/live-android/simple_pk_progressbar_normal_anim.webp";
        this.pkInProgressAdditionalUrl = "https://" + r101.getObjectTosPath() + "/obj/live-android/simple_pk_progressbar_anim_additional.webp";
        this.livePkScoreAnimationUrl = "https://" + r101.getObjectTosPath() + "/obj/live-android/live_pk_score_animation.webp";
        this.pkInProgressAdditionalTailUrl = "https://" + r101.getObjectTosPath() + "/obj/live-android/simple_pk_progressbar_anim_additional_tail2.webp";
        this.winEmojiUrl = "https://" + r101.getObjectTosPath() + "/obj/live-android/simple_pk_win_emoji.webp";
        this.loseEmojiUrl = "https://" + r101.getObjectTosPath() + "/obj/live-android/simple_pk_lose_emoji.webp";
        this.tieEmojiUrl = "https://" + r101.getObjectTosPath() + "/obj/live-android/simple_pk_tie_emoji.webp";
        this.leftStarAnim = "https://" + r101.getObjectTosPath() + "/obj/live-android/pk_atmosphere_left_anim_douyin.webp";
        this.rightStarAnim = "https://" + r101.getObjectTosPath() + "/obj/live-android/pk_atmosphere_right_anim.webp";
        this.pkSeasonLeftPng = "https://" + r101.getObjectTosPath() + "/obj/live-android/ttlive_pk_season_bg_left.png";
        this.pkSeasonRightPng = "https://" + r101.getObjectTosPath() + "/obj/live-android/ttlive_pk_season_bg_right.png";
        this.teamTaskOpt = "https://" + r101.getObjectTosPath() + "/obj/live-android/ttlive_team_task_opt_progress.webp";
        this.giftSendAnim = "https://" + r101.getObjectTosPath() + "/obj/live-android/ttlive_team_task_opt_gift_send_anim.webp";
        this.pkRoomOptStealTower = "https://" + r101.getObjectTosPath() + "/obj/live-android/ttlive_pk_room_opt_steal_tower.webp";
        this.pkRoomOptBarBg = "https://" + r101.getObjectTosPath() + "/obj/live-android/ttlive_pk_room_opt_bar_bg.png";
        this.pkRoomOptTeamTaskGiftSendAnim = "https://" + r101.getObjectTosPath() + "/obj/live-android/ttlive_pk_room_opt_team_task_gift_send_anim.webp";
    }

    public final String a() {
        return this.livePkScoreAnimationUrl;
    }

    public final String b() {
        return this.loseEmojiUrl;
    }

    public final String c() {
        return this.middleUrl;
    }

    public final String d() {
        return this.pkInProgressAdditionalTailUrl;
    }

    public final String e() {
        return this.teamTaskOpt;
    }

    public final String f() {
        return this.tieEmojiUrl;
    }

    public final String g() {
        return this.winEmojiUrl;
    }
}
