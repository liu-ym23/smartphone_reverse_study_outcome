package com.bytedance.android.live.base.model.feedback;

import am3.g;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes45.dex */
@ProtoMessage("webcast.data.FeedbackCard.RoomCardStruct")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/bytedance/android/live/base/model/feedback/RoomCardStruct;", "", "()V", "isLike", "", "()Z", "setLike", "(Z)V", "room", "Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "subTitle", "", "title", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RoomCardStruct implements h {
    private boolean isLike;

    @SerializedName("data")
    public Room room;

    @SerializedName(BdpAppEventConstant.PARAMS_SUB_TITLE)
    public String subTitle;

    @SerializedName("title")
    public String title;

    public RoomCardStruct() {
    }

    public RoomCardStruct(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        if (r102 != 1) goto L8;
        this.room = new Room(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.title = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this.subTitle = am3.h.c(r100);
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
    }

    public final boolean isLike() {
        return this.isLike;
    }

    public final void setLike(boolean r100) {
        this.isLike = r100;
    }
}
