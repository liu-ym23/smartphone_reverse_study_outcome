package com.bytedance.android.livesdkapi.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\n\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\bR\u001e\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001dR\u001e\u0010!\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\"\u0010\u0010\"\u0004\b#\u0010\u0012R\u001c\u0010$\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001b\"\u0004\b&\u0010\u001d¨\u0006'"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/CheckLiveParams;", "", "()V", "adType", "", "getAdType", "()Ljava/lang/Integer;", "setAdType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "distributionScene", "getDistributionScene", "setDistributionScene", "feedTimeMs", "", "getFeedTimeMs", "()Ljava/lang/Long;", "setFeedTimeMs", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "isLiving", "setLiving", "isWhiteAd", "setWhiteAd", "itemId", "", "getItemId", "()Ljava/lang/String;", "setItemId", "(Ljava/lang/String;)V", "relativeLogIds", "getRelativeLogIds", "setRelativeLogIds", "roomId", "getRoomId", "setRoomId", "userId", "getUserId", "setUserId", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CheckLiveParams {
    private Integer adType;
    private Integer distributionScene;
    private Long feedTimeMs;
    private Integer isLiving;
    private Integer isWhiteAd;
    private String itemId;
    private String relativeLogIds;
    private Long roomId;
    private String userId;

    public CheckLiveParams() {
    }

    public final Integer getAdType() {
        return this.adType;
    }

    public final Integer getDistributionScene() {
        return this.distributionScene;
    }

    public final Long getFeedTimeMs() {
        return this.feedTimeMs;
    }

    public final String getItemId() {
        return this.itemId;
    }

    public final String getRelativeLogIds() {
        return this.relativeLogIds;
    }

    public final Long getRoomId() {
        return this.roomId;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final Integer isLiving() {
        return this.isLiving;
    }

    public final Integer isWhiteAd() {
        return this.isWhiteAd;
    }

    public final void setAdType(Integer r100) {
        this.adType = r100;
    }

    public final void setDistributionScene(Integer r100) {
        this.distributionScene = r100;
    }

    public final void setFeedTimeMs(Long r100) {
        this.feedTimeMs = r100;
    }

    public final void setItemId(String r100) {
        this.itemId = r100;
    }

    public final void setLiving(Integer r100) {
        this.isLiving = r100;
    }

    public final void setRelativeLogIds(String r100) {
        this.relativeLogIds = r100;
    }

    public final void setRoomId(Long r100) {
        this.roomId = r100;
    }

    public final void setUserId(String r100) {
        this.userId = r100;
    }

    public final void setWhiteAd(Integer r100) {
        this.isWhiteAd = r100;
    }
}
