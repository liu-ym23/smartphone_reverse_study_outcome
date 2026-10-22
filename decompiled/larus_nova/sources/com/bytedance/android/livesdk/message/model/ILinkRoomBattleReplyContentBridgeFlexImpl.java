package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.LinkmicRoomBattleReplyContent")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\n\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001c\u0010\u001dR\u001b\u0010\b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\u000b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007R\u001b\u0010\u0010\u001a\u00020\f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u0005\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0013\u001a\u00020\f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0005\u001a\u0004\b\u0012\u0010\u000fR\u001d\u0010\u0018\u001a\u0004\u0018\u00010\u00148VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0005\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u001b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0005\u001a\u0004\b\u001a\u0010\u0007¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/ILinkRoomBattleReplyContentBridgeFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/message/model/a9;", "", "replyType$delegate", "Ljava/lang/Object;", "getReplyType", "()I", "replyType", "startType$delegate", "getStartType", "startType", "", "inviteeRoomId$delegate", "getInviteeRoomId", "()J", "inviteeRoomId", "followStatus$delegate", "getFollowStatus", "followStatus", "", "replyToast$delegate", "getReplyToast", "()Ljava/lang/String;", "replyToast", "replyOperate$delegate", "getReplyOperate", "replyOperate", "<init>", "()V", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ILinkRoomBattleReplyContentBridgeFlexImpl extends FlexModelBase<a9> implements a9, vh7.h {

    @SerializedName("follow_status")
    protected long _$$followStatus;

    @SerializedName("invitee_room_id")
    protected long _$$inviteeRoomId;

    @SerializedName("reply_operate")
    protected int _$$replyOperate;

    @SerializedName("reply_toast")
    protected String _$$replyToast;

    @SerializedName("reply_type")
    protected int _$$replyType;

    @SerializedName("start_type")
    protected int _$$startType;

    public ILinkRoomBattleReplyContentBridgeFlexImpl() {
        super(a9.class);
    }

    @Override // com.bytedance.android.livesdk.message.model.a9
    public final long getFollowStatus() {
        return this._$$followStatus;
    }

    @Override // com.bytedance.android.livesdk.message.model.a9
    public final long getInviteeRoomId() {
        return this._$$inviteeRoomId;
    }

    @Override // com.bytedance.android.livesdk.message.model.a9
    public final int getReplyOperate() {
        return this._$$replyOperate;
    }

    @Override // com.bytedance.android.livesdk.message.model.a9
    public final String getReplyToast() {
        return this._$$replyToast;
    }

    @Override // com.bytedance.android.livesdk.message.model.a9
    public final int getReplyType() {
        return this._$$replyType;
    }

    @Override // com.bytedance.android.livesdk.message.model.a9
    public final int getStartType() {
        return this._$$startType;
    }

    public ILinkRoomBattleReplyContentBridgeFlexImpl(am3.g r100) {
        super(a9.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L24;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this._$$replyType = r100.i();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this._$$startType = r100.i();
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this._$$inviteeRoomId = r100.j();
        goto L3
    L12:
        if (r102 != 5) goto L14;
        this._$$followStatus = r100.j();
        goto L3
    L14:
        if (r102 != 7) goto L16;
        this._$$replyToast = am3.h.c(r100);
        goto L3
    L16:
        if (r102 != 8) goto L17;
        this._$$replyOperate = r100.i();
        goto L3
    L17:
        am3.h.d(r103, r100);
        goto L3
    L24:
        r100.d(r101);
        setThreadSafe(true);
    }
}
