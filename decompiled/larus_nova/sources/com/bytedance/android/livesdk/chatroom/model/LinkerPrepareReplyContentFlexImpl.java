package com.bytedance.android.livesdk.chatroom.model;

import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@ProtoMessage("webcast.im.LinkerPrepareReplyContent")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0019\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b*\u0010+R+\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR+\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u0006\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R/\u0010\u0019\u001a\u0004\u0018\u00010\u00132\b\u0010\u0004\u001a\u0004\u0018\u00010\u00138V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0014\u0010\u0006\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R+\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u001a\u0010\u0006\u001a\u0004\b\u001b\u0010\b\"\u0004\b\u001c\u0010\nR+\u0010!\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u001e\u0010\u0006\u001a\u0004\b\u001f\u0010\b\"\u0004\b \u0010\nR+\u0010%\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u00138V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\"\u0010\u0006\u001a\u0004\b#\u0010\u0016\"\u0004\b$\u0010\u0018R+\u0010)\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u00138V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b&\u0010\u0006\u001a\u0004\b'\u0010\u0016\"\u0004\b(\u0010\u0018¨\u0006,"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/LinkerPrepareReplyContentFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/chatroom/model/LinkerPrepareReplyContent;", "", "<set-?>", "fromRoomId$delegate", "Ljava/lang/Object;", "getFromRoomId", "()J", "setFromRoomId", "(J)V", "fromRoomId", "", "replyType$delegate", "getReplyType", "()I", "setReplyType", "(I)V", "replyType", "", "toast$delegate", "getToast", "()Ljava/lang/String;", "setToast", "(Ljava/lang/String;)V", "toast", "_fromUserId$delegate", "get_fromUserId", "set_fromUserId", "_fromUserId", "_toUserId$delegate", "get_toUserId", "set_toUserId", "_toUserId", "_fromOpenId$delegate", "get_fromOpenId", "set_fromOpenId", "_fromOpenId", "_toOpenId$delegate", "get_toOpenId", "set_toOpenId", "_toOpenId", "<init>", "()V", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LinkerPrepareReplyContentFlexImpl extends FlexModelBase<LinkerPrepareReplyContent> implements LinkerPrepareReplyContent, vh7.h {

    @SerializedName("from_open_id")
    protected String _$$_fromOpenId;

    @SerializedName("from_user_id")
    protected long _$$_fromUserId;

    @SerializedName("to_open_id")
    protected String _$$_toOpenId;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_TO_USER_ID)
    protected long _$$_toUserId;

    @SerializedName(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ROOM_ID)
    protected long _$$fromRoomId;

    @SerializedName("reply_type")
    protected int _$$replyType;

    @SerializedName("toast")
    protected String _$$toast;

    public LinkerPrepareReplyContentFlexImpl() {
        super(LinkerPrepareReplyContent.class);
        this._$$_fromOpenId = "";
        this._$$_toOpenId = "";
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.LinkerPrepareReplyContent
    public final long getFromRoomId() {
        return this._$$fromRoomId;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.LinkerPrepareReplyContent
    public final int getReplyType() {
        return this._$$replyType;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.LinkerPrepareReplyContent
    public final String getToast() {
        return this._$$toast;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.LinkerPrepareReplyContent
    public final String get_fromOpenId() {
        return this._$$_fromOpenId;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.LinkerPrepareReplyContent
    public final long get_fromUserId() {
        return this._$$_fromUserId;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.LinkerPrepareReplyContent
    public final String get_toOpenId() {
        return this._$$_toOpenId;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.LinkerPrepareReplyContent
    public final long get_toUserId() {
        return this._$$_toUserId;
    }

    public LinkerPrepareReplyContentFlexImpl(am3.g r100) {
        super(LinkerPrepareReplyContent.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L27;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this._$$_fromUserId = r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this._$$fromRoomId = r100.j();
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this._$$_toUserId = r100.j();
        goto L3
    L12:
        if (r102 != 4) goto L14;
        this._$$replyType = r100.i();
        goto L3
    L14:
        if (r102 != 5) goto L16;
        this._$$toast = am3.h.c(r100);
        goto L3
    L16:
        if (r102 != 5000) goto L18;
        this._$$_fromOpenId = am3.h.c(r100);
        goto L3
    L18:
        if (r102 != 5001) goto L19;
        this._$$_toOpenId = am3.h.c(r100);
        goto L3
    L19:
        am3.h.d(r103, r100);
        goto L3
    L27:
        r100.d(r101);
        setThreadSafe(true);
        if (this._$$_fromOpenId != null) goto L31;
        this._$$_fromOpenId = "";
    L31:
        if (this._$$_toOpenId != null) goto L58;
        this._$$_toOpenId = "";
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.LinkerPrepareReplyContent
    public final void setFromRoomId(long r100) {
        this._$$fromRoomId = r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.LinkerPrepareReplyContent
    public final void setReplyType(int r100) {
        this._$$replyType = r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.LinkerPrepareReplyContent
    public final void setToast(String r100) {
        this._$$toast = r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.LinkerPrepareReplyContent
    public final void set_fromOpenId(String r100) {
        this._$$_fromOpenId = r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.LinkerPrepareReplyContent
    public final void set_fromUserId(long r100) {
        this._$$_fromUserId = r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.LinkerPrepareReplyContent
    public final void set_toOpenId(String r100) {
        this._$$_toOpenId = r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.LinkerPrepareReplyContent
    public final void set_toUserId(long r100) {
        this._$$_toUserId = r100;
    }
}
