package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@ProtoMessage("webcast.data.ClientAttachedInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u001f\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b \u0010!R+\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR/\u0010\u000f\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\f\u0010\u0006\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\nR/\u0010\u0013\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0010\u0010\u0006\u001a\u0004\b\u0011\u0010\b\"\u0004\b\u0012\u0010\nR/\u0010\u0017\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0014\u0010\u0006\u001a\u0004\b\u0015\u0010\b\"\u0004\b\u0016\u0010\nR/\u0010\u001b\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0018\u0010\u0006\u001a\u0004\b\u0019\u0010\b\"\u0004\b\u001a\u0010\nR/\u0010\u001f\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u001c\u0010\u0006\u001a\u0004\b\u001d\u0010\b\"\u0004\b\u001e\u0010\n¨\u0006\""}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IClientAttachedInfoFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/v3;", "", "<set-?>", "pointTag$delegate", "Ljava/lang/Object;", "getPointTag", "()Ljava/lang/String;", "setPointTag", "(Ljava/lang/String;)V", "pointTag", "imprId$delegate", "getImprId", "setImprId", "imprId", "inviteMode$delegate", "getInviteMode", "setInviteMode", "inviteMode", "listNum$delegate", "getListNum", "setListNum", "listNum", "inviterRoomStatus$delegate", "getInviterRoomStatus", "setInviterRoomStatus", "inviterRoomStatus", "inviterConnectCnt$delegate", "getInviterConnectCnt", "setInviterConnectCnt", "inviterConnectCnt", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IClientAttachedInfoFlexImpl extends FlexModelBase<v3> implements v3, vh7.h {

    @SerializedName("impr_id")
    protected String _$$imprId;

    @SerializedName("invite_mode")
    protected String _$$inviteMode;

    @SerializedName("inviter_connect_cnt")
    protected String _$$inviterConnectCnt;

    @SerializedName("inviter_room_status")
    protected String _$$inviterRoomStatus;

    @SerializedName("list_num")
    protected String _$$listNum;

    @SerializedName("point_tag")
    protected String _$$pointTag;

    public IClientAttachedInfoFlexImpl() {
        super(v3.class);
        this._$$pointTag = "";
    }

    public IClientAttachedInfoFlexImpl(am3.g r100) {
        super(v3.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L14;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        switch(r102) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            default: goto L7;
        };
    L8:
        this._$$inviterConnectCnt = am3.h.c(r100);
        goto L3
    L9:
        this._$$inviterRoomStatus = am3.h.c(r100);
        goto L3
    L10:
        this._$$listNum = am3.h.c(r100);
        goto L3
    L11:
        this._$$inviteMode = am3.h.c(r100);
        goto L3
    L12:
        this._$$imprId = am3.h.c(r100);
        goto L3
    L13:
        this._$$pointTag = am3.h.c(r100);
        goto L3
    L7:
        am3.h.d(r103, r100);
        goto L3
    L14:
        r100.d(r101);
        setThreadSafe(true);
        if (this._$$pointTag != null) goto L34;
        this._$$pointTag = "";
        return;
    }

    @Override // com.bytedance.android.livesdk.link.model.v3
    public final String getImprId() {
        return this._$$imprId;
    }

    @Override // com.bytedance.android.livesdk.link.model.v3
    public final String getInviteMode() {
        return this._$$inviteMode;
    }

    @Override // com.bytedance.android.livesdk.link.model.v3
    public final String getInviterConnectCnt() {
        return this._$$inviterConnectCnt;
    }

    @Override // com.bytedance.android.livesdk.link.model.v3
    public final String getInviterRoomStatus() {
        return this._$$inviterRoomStatus;
    }

    @Override // com.bytedance.android.livesdk.link.model.v3
    public final String getListNum() {
        return this._$$listNum;
    }

    @Override // com.bytedance.android.livesdk.link.model.v3
    public final String getPointTag() {
        return this._$$pointTag;
    }

    @Override // com.bytedance.android.livesdk.link.model.v3
    public final void setImprId(String r100) {
        this._$$imprId = r100;
    }

    @Override // com.bytedance.android.livesdk.link.model.v3
    public final void setInviteMode(String r100) {
        this._$$inviteMode = r100;
    }

    @Override // com.bytedance.android.livesdk.link.model.v3
    public final void setInviterConnectCnt(String r100) {
        this._$$inviterConnectCnt = r100;
    }

    @Override // com.bytedance.android.livesdk.link.model.v3
    public final void setInviterRoomStatus(String r100) {
        this._$$inviterRoomStatus = r100;
    }

    @Override // com.bytedance.android.livesdk.link.model.v3
    public final void setListNum(String r100) {
        this._$$listNum = r100;
    }

    @Override // com.bytedance.android.livesdk.link.model.v3
    public final void setPointTag(String r100) {
        this._$$pointTag = r100;
    }
}
