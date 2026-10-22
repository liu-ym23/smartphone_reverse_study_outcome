package com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001e\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001e\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001e\u0010\u0015\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001e\u0010\u0018\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\b¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/LiveThemedCompetitionResourceUrlConfig;", "", "()V", "endAnimation", "", "getEndAnimation", "()Ljava/lang/String;", "setEndAnimation", "(Ljava/lang/String;)V", "lokiEffectName", "getLokiEffectName", "setLokiEffectName", "setPerformerIcon", "getSetPerformerIcon", "setSetPerformerIcon", "startAnimation", "getStartAnimation", "setStartAnimation", "winnerScoreIcon", "getWinnerScoreIcon", "setWinnerScoreIcon", "winnerSeatAnimation", "getWinnerSeatAnimation", "setWinnerSeatAnimation", "winnerSeatIcon", "getWinnerSeatIcon", "setWinnerSeatIcon", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LiveThemedCompetitionResourceUrlConfig {

    @SerializedName("end_animation")
    private String endAnimation;

    @SerializedName("loki_effect_name")
    private String lokiEffectName;

    @SerializedName("set_performer_icon")
    private String setPerformerIcon;

    @SerializedName("start_animation")
    private String startAnimation;

    @SerializedName("winner_score_icon")
    private String winnerScoreIcon;

    @SerializedName("winner_seat_animation")
    private String winnerSeatAnimation;

    @SerializedName("winner_seat_icon")
    private String winnerSeatIcon;

    public LiveThemedCompetitionResourceUrlConfig() {
        this.winnerScoreIcon = "ttlive_interaction_competition_game_winner_icon.png";
        this.startAnimation = "ttlive_interaction_competition_game_start_animation.webp";
        this.endAnimation = "ttlive_interaction_competition_game_end_animation.webp";
        this.winnerSeatAnimation = "ttlive_interaction_competition_game_winner_seat_animation.webp";
        this.winnerSeatIcon = "ttlive_interaction_competition_game_seat_winner_icon.png";
        this.setPerformerIcon = "ttlive_interaction_competition_game_set_performer_icon.png";
        this.lokiEffectName = "奖牌new";
    }

    public final String getEndAnimation() {
        return this.endAnimation;
    }

    public final String getLokiEffectName() {
        return this.lokiEffectName;
    }

    public final String getSetPerformerIcon() {
        return this.setPerformerIcon;
    }

    public final String getStartAnimation() {
        return this.startAnimation;
    }

    public final String getWinnerScoreIcon() {
        return this.winnerScoreIcon;
    }

    public final String getWinnerSeatAnimation() {
        return this.winnerSeatAnimation;
    }

    public final String getWinnerSeatIcon() {
        return this.winnerSeatIcon;
    }

    public final void setEndAnimation(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.endAnimation = r100;
    }

    public final void setLokiEffectName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.lokiEffectName = r100;
    }

    public final void setSetPerformerIcon(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.setPerformerIcon = r100;
    }

    public final void setStartAnimation(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.startAnimation = r100;
    }

    public final void setWinnerScoreIcon(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.winnerScoreIcon = r100;
    }

    public final void setWinnerSeatAnimation(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.winnerSeatAnimation = r100;
    }

    public final void setWinnerSeatIcon(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.winnerSeatIcon = r100;
    }
}
