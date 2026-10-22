package com.bytedance.android.live.broadcast.api.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@ProtoMessage("webcast.api.room.PaidLiveInfo")
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0015\u0010\u0006R\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u0012\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\r\u0010\fR\u0016\u0010\u000e\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\fR\u0016\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0004R\u0016\u0010\u0013\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\fR\u0016\u0010\u0014\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/model/v0;", "", "", "paidLiveCreateRight", "I", "getPaidLiveCreateRight$annotations", "()V", "", "paidLiveCreateRights", "Ljava/util/List;", "", "replayRight", "Z", "hasSign", "needRecall", "", "recallText", "Ljava/lang/String;", "recallType", "skipTicketList", "hasUpComingTicket", "<init>", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class v0 implements vh7.h {

    @SerializedName("has_sign")
    public boolean hasSign;

    @SerializedName("has_upcoming_ticket")
    public boolean hasUpComingTicket;

    @SerializedName("need_recall")
    public boolean needRecall;

    @SerializedName("paid_live_create_right")
    public int paidLiveCreateRight;

    @SerializedName("paid_live_create_rights")
    public List<Integer> paidLiveCreateRights;

    @SerializedName("recall_text")
    public String recallText;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_RECALL_TYPE)
    public int recallType;

    @SerializedName("replay_right")
    public boolean replayRight;

    @SerializedName("skip_ticket_list")
    public boolean skipTicketList;

    public v0() {
        this.paidLiveCreateRights = new ArrayList();
        this.recallText = "";
    }

    public v0(am3.g r100) {
        this.paidLiveCreateRights = new ArrayList();
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
        this.hasUpComingTicket = am3.h.a(r100);
        goto L3
    L8:
        this.skipTicketList = am3.h.a(r100);
        goto L3
    L9:
        this.recallType = (int) r100.j();
        goto L3
    L10:
        this.recallText = am3.h.c(r100);
        goto L3
    L11:
        this.needRecall = am3.h.a(r100);
        goto L3
    L12:
        this.paidLiveCreateRights.add(Integer.valueOf(r100.i()));
        goto L3
    L13:
        this.hasSign = am3.h.a(r100);
        goto L3
    L14:
        this.replayRight = am3.h.a(r100);
        goto L3
    L15:
        this.paidLiveCreateRight = r100.i();
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L16:
        r100.d(r101);
        if (this.paidLiveCreateRights.isEmpty() == false) goto L20;
        this.paidLiveCreateRights = new ArrayList();
    L20:
        if (this.recallText != null) goto L45;
        this.recallText = "";
        return;
    }
}
