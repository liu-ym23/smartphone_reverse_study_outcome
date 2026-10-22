package com.bytedance.android.livesdkapi.depend.message;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.im.FollowTopRefreshMessage")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\u0005R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\bR\u0016\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\u0005¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/message/FollowTopRefreshMessage;", "", "()V", "delayTime", "", "Ljava/lang/Long;", "notifyType", "", "Ljava/lang/Integer;", "roomId", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FollowTopRefreshMessage implements h {

    @SerializedName("delay_time")
    public Long delayTime;

    @SerializedName("notify_type")
    public Integer notifyType;

    @SerializedName("room_id")
    public Long roomId;

    public FollowTopRefreshMessage() {
    }

    public FollowTopRefreshMessage(g r100) {
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
}
