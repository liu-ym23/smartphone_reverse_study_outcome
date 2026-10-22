package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.SunDailyRankMessage.RankInfo")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\f\u001a\u00020\u0004J\u0006\u0010\r\u001a\u00020\u0004J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/RankInfo;", "", "()V", "_rank", "", "get_rank", "()I", "set_rank", "(I)V", "_rankType", "get_rankType", "set_rankType", "getRank", "getRankType", "toString", "", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RankInfo implements vh7.h {

    @SerializedName("rank")
    protected int _rank;

    @SerializedName("rank_type")
    protected int _rankType;

    public RankInfo() {
    }

    public String toString() {
        return "RankInfo{rankType=" + this._rankType + ", rank=" + this._rank + '}';
    }

    public final int getRank() {
        return this._rank;
    }

    public final int getRankType() {
        return this._rankType;
    }

    public final int get_rank() {
        return this._rank;
    }

    public final int get_rankType() {
        return this._rankType;
    }

    public RankInfo(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        if (r102 != 1) goto L8;
        this._rankType = (int) r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this._rank = (int) r100.j();
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r101);
    }

    public final void set_rank(int r100) {
        this._rank = r100;
    }

    public final void set_rankType(int r100) {
        this._rankType = r100;
    }
}
