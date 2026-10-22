package com.bytedance.android.livesdk.rank;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.api.ranklist.RankListHourEnterResponse.ResponseData")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0004R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/rank/RankEntranceResponse;", "", "()V", "_entranceData", "Lcom/bytedance/android/livesdk/rank/RankEntranceInfo;", "get_entranceData", "()Lcom/bytedance/android/livesdk/rank/RankEntranceInfo;", "set_entranceData", "(Lcom/bytedance/android/livesdk/rank/RankEntranceInfo;)V", "getEntranceData", "setEntranceData", "", "entranceData", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RankEntranceResponse implements vh7.h {

    @SerializedName("hour_enter_info")
    protected RankEntranceInfo _entranceData;

    public RankEntranceResponse() {
    }

    public RankEntranceResponse(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L9;
        if (r102 != 1) goto L7;
        this._entranceData = new RankEntranceInfo(r100);
        goto L3
    L7:
        am3.h.e(r100);
        goto L3
    L9:
        r100.d(r101);
    }

    public final RankEntranceInfo getEntranceData() {
        return this._entranceData;
    }

    public final RankEntranceInfo get_entranceData() {
        return this._entranceData;
    }

    public final void setEntranceData(RankEntranceInfo r100) {
        this._entranceData = r100;
    }

    public final void set_entranceData(RankEntranceInfo r100) {
        this._entranceData = r100;
    }
}
