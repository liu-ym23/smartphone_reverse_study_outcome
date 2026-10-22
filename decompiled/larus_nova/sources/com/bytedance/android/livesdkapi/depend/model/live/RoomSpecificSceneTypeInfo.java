package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.data.RoomSpecificSceneTypeInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\f\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0006\u0010\u0014\u001a\u00020\u0005J\u0006\u0010\u0015\u001a\u00020\u0005R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0083\u000e¢\u0006\u0004\n\u0002\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001e\u0010\u0012\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0006\"\u0004\b\u0013\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/RoomSpecificSceneTypeInfo;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomSpecificSceneTypeInfo;", "()V", "isCommentaryRoom", "", "()Z", "setCommentaryRoom", "(Z)V", "isLandscapeVerticalRoom", "", "()I", "setLandscapeVerticalRoom", "(I)V", "isLastedGoodsRoom", "Ljava/lang/Integer;", "isLife", "setLife", "isUnionLiveRoom", "setUnionLiveRoom", "getIsLastedGoodsRoom", "isLandscapeVertical", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RoomSpecificSceneTypeInfo extends FlexModelBase<IRoomSpecificSceneTypeInfo> implements IRoomSpecificSceneTypeInfo, h {

    @SerializedName("commentary_type")
    protected boolean isCommentaryRoom;

    @SerializedName("is_sub_orientation_vertical_room")
    protected int isLandscapeVerticalRoom;

    @SerializedName("is_lasted_goods_room")
    protected Integer isLastedGoodsRoom;

    @SerializedName("is_life")
    protected boolean isLife;

    @SerializedName("is_union_live_room")
    protected boolean isUnionLiveRoom;

    public RoomSpecificSceneTypeInfo() {
        super(IRoomSpecificSceneTypeInfo.class);
        this.isLastedGoodsRoom = 0;
    }

    public final boolean getIsLastedGoodsRoom() {
        Integer r100 = this.isLastedGoodsRoom;
        if (r100 == null) goto L11;
        r100.intValue();
        Integer r101 = this.isLastedGoodsRoom;
        if (r101 != null) goto L8;
        return false;
    L8:
        if (r101.intValue() != 1) goto L12;
        return true;
    L12:
        return false;
    L11:
        return false;
    }

    public final boolean isLandscapeVertical() {
        if (isLandscapeVerticalRoom() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final boolean isCommentaryRoom() {
        return this.isCommentaryRoom;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomSpecificSceneTypeInfo
    public int isLandscapeVerticalRoom() {
        return this.isLandscapeVerticalRoom;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomSpecificSceneTypeInfo
    public boolean isLife() {
        return this.isLife;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IRoomSpecificSceneTypeInfo
    public boolean isUnionLiveRoom() {
        return this.isUnionLiveRoom;
    }

    public RoomSpecificSceneTypeInfo(g r100) {
        super(IRoomSpecificSceneTypeInfo.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L21;
        g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this.isUnionLiveRoom = am3.h.a(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.isLife = am3.h.a(r100);
        goto L3
    L10:
        if (r102 != 4) goto L12;
        this.isLastedGoodsRoom = Integer.valueOf(r100.i());
        goto L3
    L12:
        if (r102 != 6) goto L14;
        this.isCommentaryRoom = am3.h.a(r100);
        goto L3
    L14:
        if (r102 != 7) goto L15;
        this.isLandscapeVerticalRoom = r100.i();
        goto L3
    L15:
        am3.h.d(r103, r100);
        goto L3
    L21:
        r100.d(r101);
        setThreadSafe(true);
        if (this.isLastedGoodsRoom != null) goto L43;
        this.isLastedGoodsRoom = 0;
        return;
    }

    public final void setCommentaryRoom(boolean r100) {
        this.isCommentaryRoom = r100;
    }

    public void setLandscapeVerticalRoom(int r100) {
        this.isLandscapeVerticalRoom = r100;
    }

    public void setLife(boolean r100) {
        this.isLife = r100;
    }

    public void setUnionLiveRoom(boolean r100) {
        this.isUnionLiveRoom = r100;
    }
}
