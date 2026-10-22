package com.bytedance.android.live.broadcast.api.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@ProtoMessage("webcast.api.room.RoomEndingCounteractInfoResponse.LiveDurationMissionInfoMessage")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\b¨\u0006\r"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/model/LiveDurationMissionInfoMessage;", "Ljava/io/Serializable;", "()V", "liveDurationMissionDiamond", "", "getLiveDurationMissionDiamond", "()Ljava/lang/Integer;", "setLiveDurationMissionDiamond", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "liveDurationMissionValue", "getLiveDurationMissionValue", "setLiveDurationMissionValue", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveDurationMissionInfoMessage implements Serializable, vh7.h {

    @SerializedName("live_duration_mission_diamond")
    protected Integer liveDurationMissionDiamond;

    @SerializedName("live_duration_mission_value")
    protected Integer liveDurationMissionValue;

    public LiveDurationMissionInfoMessage() {
    }

    public final Integer getLiveDurationMissionDiamond() {
        return this.liveDurationMissionDiamond;
    }

    public final Integer getLiveDurationMissionValue() {
        return this.liveDurationMissionValue;
    }

    public LiveDurationMissionInfoMessage(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        if (r102 != 1) goto L8;
        this.liveDurationMissionValue = Integer.valueOf(r100.i());
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.liveDurationMissionDiamond = Integer.valueOf(r100.i());
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r101);
    }

    public final void setLiveDurationMissionDiamond(Integer r100) {
        this.liveDurationMissionDiamond = r100;
    }

    public final void setLiveDurationMissionValue(Integer r100) {
        this.liveDurationMissionValue = r100;
    }
}
