package com.bytedance.android.livesdkapi.depend.model.live.pay;

import am3.g;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.android.livehostapi.business.depend.share.ShareConstants;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ForMain
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0015\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0018\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/pay/BindSubProductData;", "", "()V", "deliveryStatus", "", "detail", "", "disableReason", "endTime", "", "isReplay", "", "liveEndTime", "liveStartTime", "liveStatus", "liveTime", "parentProductId", "productId", "replayId", "replayIdStr", "roomId", "ticketStatus", "title", "vid", "viewRight", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BindSubProductData implements h {

    @SerializedName(a.KEY_DELIVERY_STATUS)
    public int deliveryStatus;

    @SerializedName("detail")
    public String detail;

    @SerializedName("disable_reason")
    public int disableReason;

    @SerializedName("end_time")
    public long endTime;

    @SerializedName(a.KEY_IS_REPLAY)
    public boolean isReplay;

    @SerializedName("live_end_time")
    public long liveEndTime;

    @SerializedName("live_start_time")
    public long liveStartTime;

    @SerializedName("live_status")
    public int liveStatus;

    @SerializedName("live_time")
    public long liveTime;

    @SerializedName("parent_product_id")
    public String parentProductId;

    @SerializedName("product_id")
    public String productId;

    @SerializedName(ShareConstants.REPLAY_ID)
    public long replayId;

    @SerializedName("replay_id_str")
    public String replayIdStr;

    @SerializedName("room_id")
    public String roomId;

    @SerializedName("ticket_status")
    public int ticketStatus;

    @SerializedName("title")
    public String title;

    @SerializedName("vid")
    public String vid;

    @SerializedName("view_right")
    public long viewRight;

    public BindSubProductData() {
    }

    public BindSubProductData(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L25;
        switch(r102) {
            case 1: goto L24;
            case 2: goto L23;
            case 3: goto L22;
            case 4: goto L21;
            case 5: goto L20;
            case 6: goto L19;
            case 7: goto L18;
            case 8: goto L17;
            case 9: goto L16;
            case 10: goto L15;
            case 11: goto L14;
            case 12: goto L13;
            case 13: goto L12;
            case 14: goto L11;
            case 15: goto L10;
            case 16: goto L9;
            case 17: goto L8;
            case 18: goto L7;
            default: goto L6;
        };
    L7:
        this.disableReason = r100.i();
        goto L3
    L8:
        this.replayIdStr = am3.h.c(r100);
        goto L3
    L9:
        this.replayId = r100.j();
        goto L3
    L10:
        this.isReplay = am3.h.a(r100);
        goto L3
    L11:
        this.viewRight = r100.j();
        goto L3
    L12:
        this.liveEndTime = r100.j();
        goto L3
    L13:
        this.liveStartTime = r100.j();
        goto L3
    L14:
        this.endTime = r100.j();
        goto L3
    L15:
        this.liveTime = r100.j();
        goto L3
    L16:
        this.deliveryStatus = r100.i();
        goto L3
    L17:
        this.roomId = am3.h.c(r100);
        goto L3
    L18:
        this.vid = am3.h.c(r100);
        goto L3
    L19:
        this.detail = am3.h.c(r100);
        goto L3
    L20:
        this.ticketStatus = r100.i();
        goto L3
    L21:
        this.liveStatus = r100.i();
        goto L3
    L22:
        this.title = am3.h.c(r100);
        goto L3
    L23:
        this.parentProductId = am3.h.c(r100);
        goto L3
    L24:
        this.productId = am3.h.c(r100);
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L25:
        r100.d(r101);
    }
}
