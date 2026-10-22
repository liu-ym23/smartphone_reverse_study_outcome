package com.bytedance.android.live.base.model.user;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@ProtoMessage("webcast.data.User.AuthorStats")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u001e\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\b\u0010\b\u001a\u00020\u0002H\u0016R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\n\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\n\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR\"\u0010\u0018\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\n\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000eR\"\u0010\u001b\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\n\u001a\u0004\b\u001c\u0010\f\"\u0004\b\u001d\u0010\u000e¨\u0006 "}, d2 = {"Lcom/bytedance/android/live/base/model/user/Author;", "", "", "getVideoTotalCount", "getVideoTotalPlayCount", "getVideoShareCount", "getVideoTotalSeriesCount", "getVarietyShowPlayCount", "getVideoTotalFavoriteCount", "_videoTotalCount", "J", "get_videoTotalCount", "()J", "set_videoTotalCount", "(J)V", "_videoTotalPlayCount", "get_videoTotalPlayCount", "set_videoTotalPlayCount", "_videoShareCount", "get_videoShareCount", "set_videoShareCount", "_videoTotalSeriesCount", "get_videoTotalSeriesCount", "set_videoTotalSeriesCount", "_varietyShowPlayCount", "get_varietyShowPlayCount", "set_varietyShowPlayCount", "_videoTotalFavoriteCount", "get_videoTotalFavoriteCount", "set_videoTotalFavoriteCount", "<init>", "()V", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class Author implements vh7.h {

    @SerializedName("variety_show_play_count")
    protected long _varietyShowPlayCount;

    @SerializedName("video_total_share_count")
    protected long _videoShareCount;

    @SerializedName("video_total_count")
    protected long _videoTotalCount;

    @SerializedName("video_total_favorite_count")
    protected long _videoTotalFavoriteCount;

    @SerializedName("video_total_play_count")
    protected long _videoTotalPlayCount;

    @SerializedName("video_total_series_count")
    protected long _videoTotalSeriesCount;

    public Author() {
    }

    public long getVarietyShowPlayCount() {
        return this._varietyShowPlayCount;
    }

    public long getVideoShareCount() {
        return this._videoShareCount;
    }

    public long getVideoTotalCount() {
        return this._videoTotalCount;
    }

    public long getVideoTotalFavoriteCount() {
        return this._videoTotalFavoriteCount;
    }

    public long getVideoTotalPlayCount() {
        return this._videoTotalPlayCount;
    }

    public long getVideoTotalSeriesCount() {
        return this._videoTotalSeriesCount;
    }

    public final long get_varietyShowPlayCount() {
        return this._varietyShowPlayCount;
    }

    public final long get_videoShareCount() {
        return this._videoShareCount;
    }

    public final long get_videoTotalCount() {
        return this._videoTotalCount;
    }

    public final long get_videoTotalFavoriteCount() {
        return this._videoTotalFavoriteCount;
    }

    public final long get_videoTotalPlayCount() {
        return this._videoTotalPlayCount;
    }

    public final long get_videoTotalSeriesCount() {
        return this._videoTotalSeriesCount;
    }

    public Author(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L13;
        switch(r102) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            default: goto L6;
        };
    L7:
        this._videoTotalFavoriteCount = r100.j();
        goto L3
    L8:
        this._varietyShowPlayCount = r100.j();
        goto L3
    L9:
        this._videoTotalSeriesCount = r100.j();
        goto L3
    L10:
        this._videoShareCount = r100.j();
        goto L3
    L11:
        this._videoTotalPlayCount = r100.j();
        goto L3
    L12:
        this._videoTotalCount = r100.j();
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L13:
        r100.d(r101);
    }

    public final void set_varietyShowPlayCount(long r100) {
        this._varietyShowPlayCount = r100;
    }

    public final void set_videoShareCount(long r100) {
        this._videoShareCount = r100;
    }

    public final void set_videoTotalCount(long r100) {
        this._videoTotalCount = r100;
    }

    public final void set_videoTotalFavoriteCount(long r100) {
        this._videoTotalFavoriteCount = r100;
    }

    public final void set_videoTotalPlayCount(long r100) {
        this._videoTotalPlayCount = r100;
    }

    public final void set_videoTotalSeriesCount(long r100) {
        this._videoTotalSeriesCount = r100;
    }
}
