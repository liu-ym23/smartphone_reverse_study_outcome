package com.bytedance.android.live.broadcast.api.model.component;

import am3.g;
import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.dypay.api.DyPayConstant;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes45.dex */
@ProtoMessage("webcast.api.room.TopAreaComponent.AudienceLimitSubComponent")
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\u0007R\u0016\u0010\b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\nR\u0014\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\u0007R\u0014\u0010\u000e\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\nR\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\u0012R\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/model/component/AudienceLimitSubComponent;", "", "()V", "base", "Lcom/bytedance/android/live/broadcast/api/model/component/BaseComponentModel;", "durationDays", "", "Ljava/lang/Integer;", "endTime", "", "Ljava/lang/Long;", "endTimeText", "", "maxAudienceCnt", "maxAudienceCntText", DyPayConstant.KEY_START_TIME, "success", "", "Ljava/lang/Boolean;", "switchOn", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AudienceLimitSubComponent implements h {

    @SerializedName("base")
    public BaseComponentModel base;

    @SerializedName("duration_days")
    public Integer durationDays;

    @SerializedName("end_time")
    public Long endTime;

    @SerializedName("end_time_text")
    public String endTimeText;

    @SerializedName("max_audience_cnt")
    public Integer maxAudienceCnt;

    @SerializedName("max_audience_cnt_text")
    public String maxAudienceCntText;

    @SerializedName(ILoadStallMonitor.START_TIME)
    public Long startTime;

    @SerializedName("success")
    public Boolean success;

    @SerializedName("switch_on")
    public Boolean switchOn;

    public AudienceLimitSubComponent() {
    }

    public AudienceLimitSubComponent(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L16;
        switch(r102) {
            case 1: goto L15;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L9;
            case 8: goto L8;
            case 9: goto L7;
            default: goto L6;
        };
    L7:
        this.success = Boolean.valueOf(am3.h.a(r100));
        goto L3
    L8:
        this.endTimeText = am3.h.c(r100);
        goto L3
    L9:
        this.switchOn = Boolean.valueOf(am3.h.a(r100));
        goto L3
    L10:
        this.durationDays = Integer.valueOf(r100.i());
        goto L3
    L11:
        this.endTime = Long.valueOf(r100.j());
        goto L3
    L12:
        this.startTime = Long.valueOf(r100.j());
        goto L3
    L13:
        this.maxAudienceCntText = am3.h.c(r100);
        goto L3
    L14:
        this.maxAudienceCnt = Integer.valueOf(r100.i());
        goto L3
    L15:
        this.base = new BaseComponentModel(r100);
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L16:
        r100.d(r101);
    }
}
