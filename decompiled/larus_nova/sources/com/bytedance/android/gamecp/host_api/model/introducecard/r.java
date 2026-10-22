package com.bytedance.android.gamecp.host_api.model.introducecard;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@ProtoMessage("webcast.im.ReserveItem")
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/gamecp/host_api/model/introducecard/r;", "", "", "reserveTodayNum", "Ljava/lang/String;", "getReserveTodayNum", "()Ljava/lang/String;", "setReserveTodayNum", "(Ljava/lang/String;)V", "reserveTotalNum", "getReserveTotalNum", "setReserveTotalNum", "", "reserveStatus", "Ljava/lang/Integer;", "getReserveStatus", "()Ljava/lang/Integer;", "setReserveStatus", "(Ljava/lang/Integer;)V", "<init>", "()V", "gamecp-host-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class r implements vh7.h {

    @SerializedName("reserve_status")
    protected Integer reserveStatus;

    @SerializedName("reserve_today_num")
    protected String reserveTodayNum;

    @SerializedName("reserve_total_num")
    protected String reserveTotalNum;

    public r() {
        this.reserveStatus = 0;
    }

    public r(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        if (r102 != 1) goto L8;
        this.reserveTodayNum = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.reserveTotalNum = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this.reserveStatus = Integer.valueOf(r100.i());
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
        if (this.reserveStatus != null) goto L31;
        this.reserveStatus = 0;
        return;
    }
}
