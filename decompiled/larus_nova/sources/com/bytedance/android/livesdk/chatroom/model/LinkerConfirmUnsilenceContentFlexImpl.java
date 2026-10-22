package com.bytedance.android.livesdk.chatroom.model;

import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@ProtoMessage("webcast.im.LinkerConfirmUnsilenceContent")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001b\u0010\u001cR+\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR/\u0010\u0012\u001a\u0004\u0018\u00010\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u0006\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R+\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0013\u0010\u0006\u001a\u0004\b\u0014\u0010\b\"\u0004\b\u0015\u0010\nR+\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0017\u0010\u0006\u001a\u0004\b\u0018\u0010\u000f\"\u0004\b\u0019\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/LinkerConfirmUnsilenceContentFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/chatroom/model/LinkerConfirmUnsilenceContent;", "", "<set-?>", "fromRoomId$delegate", "Ljava/lang/Object;", "getFromRoomId", "()J", "setFromRoomId", "(J)V", "fromRoomId", "", "toast$delegate", "getToast", "()Ljava/lang/String;", "setToast", "(Ljava/lang/String;)V", "toast", "_fromUserId$delegate", "get_fromUserId", "set_fromUserId", "_fromUserId", "_fromOpenId$delegate", "get_fromOpenId", "set_fromOpenId", "_fromOpenId", "<init>", "()V", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LinkerConfirmUnsilenceContentFlexImpl extends FlexModelBase<LinkerConfirmUnsilenceContent> implements LinkerConfirmUnsilenceContent, vh7.h {

    @SerializedName("from_open_id")
    protected String _$$_fromOpenId;

    @SerializedName("from_user_id")
    protected long _$$_fromUserId;

    @SerializedName(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ROOM_ID)
    protected long _$$fromRoomId;

    @SerializedName("toast")
    protected String _$$toast;

    public LinkerConfirmUnsilenceContentFlexImpl() {
        super(LinkerConfirmUnsilenceContent.class);
        this._$$_fromOpenId = "";
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.LinkerConfirmUnsilenceContent
    public final long getFromRoomId() {
        return this._$$fromRoomId;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.LinkerConfirmUnsilenceContent
    public final String getToast() {
        return this._$$toast;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.LinkerConfirmUnsilenceContent
    public final String get_fromOpenId() {
        return this._$$_fromOpenId;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.LinkerConfirmUnsilenceContent
    public final long get_fromUserId() {
        return this._$$_fromUserId;
    }

    public LinkerConfirmUnsilenceContentFlexImpl(am3.g r100) {
        super(LinkerConfirmUnsilenceContent.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
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
        this._$$toast = am3.h.c(r100);
        goto L3
    L12:
        if (r102 != 5000) goto L13;
        this._$$_fromOpenId = am3.h.c(r100);
        goto L3
    L13:
        am3.h.d(r103, r100);
        goto L3
    L18:
        r100.d(r101);
        setThreadSafe(true);
        if (this._$$_fromOpenId != null) goto L37;
        this._$$_fromOpenId = "";
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.LinkerConfirmUnsilenceContent
    public final void setFromRoomId(long r100) {
        this._$$fromRoomId = r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.LinkerConfirmUnsilenceContent
    public final void setToast(String r100) {
        this._$$toast = r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.LinkerConfirmUnsilenceContent
    public final void set_fromOpenId(String r100) {
        this._$$_fromOpenId = r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.LinkerConfirmUnsilenceContent
    public final void set_fromUserId(long r100) {
        this._$$_fromUserId = r100;
    }
}
