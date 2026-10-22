package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.google.gson.annotations.SerializedName;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ForMain
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u001a\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006R\u0018\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0018\u0010\u0014\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0018\u0010\u0016\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000fR\u0018\u0010\u0018\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/PayloadStartMicrogameStamp;", "", "()V", "bidPrice", "", "getBidPrice", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "bidRatio", "getBidRatio", "bidType", "getBidType", "entranceFrom", "", "getEntranceFrom", "()Ljava/lang/String;", "mpId", "getMpId", "status", "getStatus", DBDefinition.TASK_ID, "getTaskId", "taskSource", "getTaskSource", "type", "getType", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PayloadStartMicrogameStamp implements h {

    @SerializedName("bid_price")
    protected Integer bidPrice;

    @SerializedName("bid_ratio")
    protected Integer bidRatio;

    @SerializedName("bid_type")
    protected Integer bidType;

    @SerializedName("entrance_from")
    protected String entranceFrom;

    @SerializedName(BdpAppEventConstant.PARAMS_MP_ID)
    protected String mpId;

    @SerializedName("status")
    protected String status;

    @SerializedName("task_id")
    protected String taskId;

    @SerializedName("task_source")
    protected String taskSource;

    @SerializedName("type")
    protected String type;

    public PayloadStartMicrogameStamp() {
    }

    public final Integer getBidPrice() {
        return this.bidPrice;
    }

    public final Integer getBidRatio() {
        return this.bidRatio;
    }

    public final Integer getBidType() {
        return this.bidType;
    }

    public final String getEntranceFrom() {
        return this.entranceFrom;
    }

    public final String getMpId() {
        return this.mpId;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final String getTaskSource() {
        return this.taskSource;
    }

    public final String getType() {
        return this.type;
    }

    public PayloadStartMicrogameStamp(g r100) {
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
        this.bidRatio = Integer.valueOf(r100.i());
        goto L3
    L8:
        this.bidPrice = Integer.valueOf(r100.i());
        goto L3
    L9:
        this.bidType = Integer.valueOf(r100.i());
        goto L3
    L10:
        this.entranceFrom = am3.h.c(r100);
        goto L3
    L11:
        this.taskSource = am3.h.c(r100);
        goto L3
    L12:
        this.taskId = am3.h.c(r100);
        goto L3
    L13:
        this.status = am3.h.c(r100);
        goto L3
    L14:
        this.type = am3.h.c(r100);
        goto L3
    L15:
        this.mpId = am3.h.c(r100);
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L16:
        r100.d(r101);
    }
}
