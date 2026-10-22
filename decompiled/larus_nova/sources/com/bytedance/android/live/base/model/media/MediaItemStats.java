package com.bytedance.android.live.base.model.media;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes45.dex */
public class MediaItemStats {

    @SerializedName("comment_count")
    private int commentCount;

    @SerializedName("digg_count")
    private int diggCount;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private long f58844id;

    @SerializedName("play_count")
    private int playCount;

    @SerializedName("share_count")
    private int shareCount;

    public MediaItemStats() {
    }

    public int getCommentCount() {
        return this.commentCount;
    }

    public int getDiggCount() {
        return this.diggCount;
    }

    public long getId() {
        return this.f58844id;
    }

    public int getPlayCount() {
        return this.playCount;
    }

    public int getShareCount() {
        return this.shareCount;
    }

    public void setCommentCount(int r100) {
        this.commentCount = r100;
    }

    public void setDiggCount(int r100) {
        this.diggCount = r100;
    }

    public void setId(long r100) {
        this.f58844id = r100;
    }

    public void setPlayCount(int r100) {
        this.playCount = r100;
    }

    public void setShareCount(int r100) {
        this.shareCount = r100;
    }
}
