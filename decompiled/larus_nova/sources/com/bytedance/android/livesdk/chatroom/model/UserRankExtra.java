package com.bytedance.android.livesdk.chatroom.model;

import com.bytedance.android.live.base.model.Extra;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes7.dex */
public class UserRankExtra extends Extra {

    @SerializedName("gap_score")
    private int gapScore;

    @SerializedName("history_rank")
    private int historyRank;

    @SerializedName("notice_text")
    private String noticeText;

    @SerializedName("self_rank")
    private String selfRank;

    @SerializedName("self_score")
    private long selfScore;

    @SerializedName("top_fans")
    private boolean topFans;

    @SerializedName("total")
    public int total;

    public String getSelfRank() {
        String r100 = this.selfRank;
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public UserRankExtra() {
    }

    public int getGapScore() {
        return this.gapScore;
    }

    public int getHistoryRank() {
        return this.historyRank;
    }

    public String getNoticeText() {
        return this.noticeText;
    }

    public long getNow() {
        return this.now;
    }

    public long getSelfScore() {
        return this.selfScore;
    }

    public int getTotal() {
        return this.total;
    }

    public boolean isHasMore() {
        return this.hasMore;
    }

    public boolean isTopFans() {
        return this.topFans;
    }

    public void setGapScore(int r100) {
        this.gapScore = r100;
    }

    public void setHasMore(boolean r100) {
        this.hasMore = r100;
    }

    public void setHistoryRank(int r100) {
        this.historyRank = r100;
    }

    public void setNoticeText(String r100) {
        this.noticeText = r100;
    }

    public void setNow(long r100) {
        this.now = r100;
    }

    public void setSelfRank(String r100) {
        this.selfRank = r100;
    }

    public void setSelfScore(long r100) {
        this.selfScore = r100;
    }

    public void setTopFans(boolean r100) {
        this.topFans = r100;
    }

    public void setTotal(int r100) {
        this.total = r100;
    }
}
