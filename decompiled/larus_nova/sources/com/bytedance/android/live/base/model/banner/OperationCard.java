package com.bytedance.android.live.base.model.banner;

import am3.g;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes45.dex */
@ProtoMessage("webcast.api.feed.OperationCard")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\rR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\r¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/live/base/model/banner/OperationCard;", "", "()V", "idStr", "", "operationActivityBanner", "Lcom/bytedance/android/live/base/model/banner/OperationActivityBanner;", "operationMultipleRoom", "Lcom/bytedance/android/live/base/model/banner/OperationMultipleRoom;", "operationSingleRoom", "Lcom/bytedance/android/live/base/model/banner/OperationSingleRoom;", ILiveRoomPlayFragmentConstant.EXTRA_ROOM_POSITION, "", "Ljava/lang/Integer;", "type", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OperationCard implements h {

    @SerializedName("id_str")
    public String idStr;

    @SerializedName("activity_banner")
    public OperationActivityBanner operationActivityBanner;

    @SerializedName("multiple_room")
    public OperationMultipleRoom operationMultipleRoom;

    @IgnoreProtoFieldCheck
    @SerializedName("single_room")
    public OperationSingleRoom operationSingleRoom;

    @SerializedName(ILiveRoomPlayFragmentConstant.EXTRA_ROOM_POSITION)
    public Integer pos;

    @SerializedName("type")
    public Integer type;

    public OperationCard() {
        this.type = 0;
        this.idStr = "";
        this.pos = 0;
    }

    public OperationCard(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L13;
        switch(r102) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            default: goto L6;
        };
    L7:
        this.pos = Integer.valueOf(r100.i());
        goto L3
    L8:
        this.operationMultipleRoom = new OperationMultipleRoom(r100);
        goto L3
    L9:
        this.operationSingleRoom = new OperationSingleRoom(r100);
        goto L3
    L10:
        this.operationActivityBanner = new OperationActivityBanner(r100);
        goto L3
    L11:
        this.idStr = am3.h.c(r100);
        goto L3
    L12:
        this.type = Integer.valueOf(r100.i());
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L13:
        r100.d(r101);
        if (this.type != null) goto L17;
        this.type = 0;
    L17:
        if (this.idStr != null) goto L20;
        this.idStr = "";
    L20:
        if (this.pos != null) goto L39;
        this.pos = 0;
        return;
    }
}
