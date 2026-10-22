package com.bytedance.android.livesdkapi.depend.model.live.episode;

import am3.g;
import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.android.livesdkapi.depend.model.live.pay.TicketData;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ForMain
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001:\u0002!\"B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u001b\u001a\u00020\u001cJ\u0006\u0010\u001d\u001a\u00020\u001cJ\u0006\u0010\u001e\u001a\u00020\u001cJ\u0006\u0010\u001f\u001a\u00020\u001cJ\u0006\u0010 \u001a\u00020\u001cR\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR \u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\b¨\u0006#"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/episode/ReplayPaidInfo;", "", "()V", "delivery", "", "getDelivery", "()I", "setDelivery", "(I)V", "freeDuration", "", "getFreeDuration", "()J", "setFreeDuration", "(J)V", "paidType", "getPaidType", "setPaidType", "ticketData", "Lcom/bytedance/android/livesdkapi/depend/model/live/pay/TicketData;", "getTicketData", "()Lcom/bytedance/android/livesdkapi/depend/model/live/pay/TicketData;", "setTicketData", "(Lcom/bytedance/android/livesdkapi/depend/model/live/pay/TicketData;)V", "viewRight", "getViewRight", "setViewRight", "hasViewRight", "", "isDelivery", "isPaidCamera", "isPaidEpisode", "needDelivery", "PaidType", "ViewRight", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ReplayPaidInfo implements h {

    @SerializedName("delivery")
    protected int delivery;

    @SerializedName("duration")
    protected long freeDuration;

    @SerializedName("paid_type")
    protected int paidType;

    @SerializedName("ticket_session")
    protected TicketData ticketData;

    @SerializedName("view_right")
    protected int viewRight;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/episode/ReplayPaidInfo$PaidType;", "", "()V", "PAID_EPISODE", "", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class PaidType {
        public static final PaidType INSTANCE = null;
        public static final int PAID_EPISODE = 1;

        private PaidType() {
        }

        static {
            INSTANCE = new PaidType();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/episode/ReplayPaidInfo$ViewRight;", "", "()V", "NO_RIGHT", "", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ViewRight {
        public static final ViewRight INSTANCE = null;
        public static final int NO_RIGHT = 0;

        private ViewRight() {
        }

        static {
            INSTANCE = new ViewRight();
        }
    }

    public ReplayPaidInfo() {
    }

    public final boolean hasViewRight() {
        if (this.viewRight == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isDelivery() {
        if (this.delivery == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final boolean isPaidCamera() {
        if (this.paidType != 3) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isPaidEpisode() {
        int r100 = this.paidType;
        if (r100 != 1) goto L5;
        return true;
    L5:
        if (r100 == 3) goto L10;
        return false;
    L10:
        return true;
    }

    public final boolean needDelivery() {
        if (this.viewRight == 1) goto L5;
    L7:
        return false;
    L5:
        if (this.delivery != 0) goto L7;
        return true;
    }

    public final int getDelivery() {
        return this.delivery;
    }

    public final long getFreeDuration() {
        return this.freeDuration;
    }

    public final int getPaidType() {
        return this.paidType;
    }

    public final TicketData getTicketData() {
        return this.ticketData;
    }

    public final int getViewRight() {
        return this.viewRight;
    }

    public ReplayPaidInfo(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L21;
        if (r102 != 1) goto L8;
        this.paidType = r100.i();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.viewRight = r100.i();
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.freeDuration = r100.j();
        goto L3
    L12:
        if (r102 != 4) goto L14;
        this.ticketData = new TicketData(r100);
        goto L3
    L14:
        if (r102 != 5) goto L15;
        this.delivery = r100.i();
        goto L3
    L15:
        am3.h.e(r100);
        goto L3
    L21:
        r100.d(r101);
    }

    public final void setDelivery(int r100) {
        this.delivery = r100;
    }

    public final void setFreeDuration(long r100) {
        this.freeDuration = r100;
    }

    public final void setPaidType(int r100) {
        this.paidType = r100;
    }

    public final void setTicketData(TicketData r100) {
        this.ticketData = r100;
    }

    public final void setViewRight(int r100) {
        this.viewRight = r100;
    }
}
