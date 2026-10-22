package com.bytedance.android.livesdk.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b$\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b$\u0010%R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\"\u0010\u0018\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\"\u0010\u001b\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0004\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\"\u0010\u001e\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0004\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR\"\u0010!\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\u0004\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\b¨\u0006&"}, d2 = {"Lcom/bytedance/android/livesdk/model/g0;", "", "", "middleUrl", "Ljava/lang/String;", "getMiddleUrl", "()Ljava/lang/String;", "setMiddleUrl", "(Ljava/lang/String;)V", "weakToRightUrl", "getWeakToRightUrl", "setWeakToRightUrl", "strongToRightUrl", "getStrongToRightUrl", "setStrongToRightUrl", "bigWinEmojiUrl", "getBigWinEmojiUrl", "setBigWinEmojiUrl", "smallWinEmojiUrl", "getSmallWinEmojiUrl", "setSmallWinEmojiUrl", "bigLoseEmojiUrl", "getBigLoseEmojiUrl", "setBigLoseEmojiUrl", "smallLoseEmojiUrl", "getSmallLoseEmojiUrl", "setSmallLoseEmojiUrl", "leftStarAnim", "getLeftStarAnim", "setLeftStarAnim", "rightStarAnim", "getRightStarAnim", "setRightStarAnim", "multiAnchorPkStealTowerEmojiUrl", "getMultiAnchorPkStealTowerEmojiUrl", "setMultiAnchorPkStealTowerEmojiUrl", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class g0 {

    @SerializedName("big_lose_emoji_url")
    private String bigLoseEmojiUrl;

    @SerializedName("big_win_emoji_url")
    private String bigWinEmojiUrl;

    @SerializedName("left_star_anim")
    private String leftStarAnim;

    @SerializedName("middle_url")
    private String middleUrl;

    @SerializedName("multi_anchor_pk_steal_tower_emoji_url")
    private String multiAnchorPkStealTowerEmojiUrl;

    @SerializedName("right_star_anim")
    private String rightStarAnim;

    @SerializedName("small_lose_emoji_url")
    private String smallLoseEmojiUrl;

    @SerializedName("small_win_emoji_url")
    private String smallWinEmojiUrl;

    @SerializedName("strong_to_right_url")
    private String strongToRightUrl;

    @SerializedName("weak_to_right_url")
    private String weakToRightUrl;

    public g0() {
        this.middleUrl = "https://sf1-dycdn-tos.pstatp.com/obj/live-android/pk_progressbar_middle.webp";
        this.weakToRightUrl = "https://sf1-dycdn-tos.pstatp.com/obj/live-android/pk_progressbar_anim_weak_to_right.webp";
        this.strongToRightUrl = "https://sf1-dycdn-tos.pstatp.com/obj/live-android/pk_progressbar_anim_strong_to_right.webp";
        this.bigWinEmojiUrl = "https://sf1-dycdn-tos.pstatp.com/obj/live-android/pk_big_win_emoji.webp";
        this.smallWinEmojiUrl = "https://sf1-dycdn-tos.pstatp.com/obj/live-android/pk_small_win_emoji.webp";
        this.bigLoseEmojiUrl = "https://sf1-dycdn-tos.pstatp.com/obj/live-android/pk_big_lose_emoji.webp";
        this.smallLoseEmojiUrl = "https://sf1-dycdn-tos.pstatp.com/obj/live-android/pk_small_lose_emoji.webp";
        this.leftStarAnim = "https://sf1-dycdn-tos.pstatp.com/obj/live-android/pk_atmosphere_left_anim_douyin.webp";
        this.rightStarAnim = "https://sf1-dycdn-tos.pstatp.com/obj/live-android/pk_atmosphere_right_anim.webp";
        this.multiAnchorPkStealTowerEmojiUrl = "https://sf1-dycdn-tos.pstatp.com/obj/live-android/pk_atmosphere_steal_tower_rush_emoji.webp";
    }
}
