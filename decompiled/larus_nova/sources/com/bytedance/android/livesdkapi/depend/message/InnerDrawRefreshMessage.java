package com.bytedance.android.livesdkapi.depend.message;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.im.InnerDrawRefreshMessage")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0012\u0010\u0006\"\u0004\b\u0013\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/message/InnerDrawRefreshMessage;", "", "()V", "delayTime", "", "getDelayTime", "()Ljava/lang/Long;", "setDelayTime", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "notifyType", "", "getNotifyType", "()Ljava/lang/Integer;", "setNotifyType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "roomId", "getRoomId", "setRoomId", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class InnerDrawRefreshMessage implements h {

    @SerializedName("delay_time")
    protected Long delayTime;

    @SerializedName("notify_type")
    protected Integer notifyType;

    @SerializedName("room_id")
    protected Long roomId;

    public InnerDrawRefreshMessage() {
    }

    public final Long getDelayTime() {
        return this.delayTime;
    }

    public final Integer getNotifyType() {
        return this.notifyType;
    }

    public final Long getRoomId() {
        return this.roomId;
    }

    public InnerDrawRefreshMessage(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        if (r102 != 1) goto L8;
        this.roomId = Long.valueOf(r100.j());
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.notifyType = Integer.valueOf(r100.i());
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this.delayTime = Long.valueOf(r100.j());
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
    }

    public final void setDelayTime(Long r100) {
        this.delayTime = r100;
    }

    public final void setNotifyType(Integer r100) {
        this.notifyType = r100;
    }

    public final void setRoomId(Long r100) {
        this.roomId = r100;
    }
}
