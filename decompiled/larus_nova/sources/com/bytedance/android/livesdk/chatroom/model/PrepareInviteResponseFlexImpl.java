package com.bytedance.android.livesdk.chatroom.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@ProtoMessage("webcast.api.linkmic_audience.PrepareInviteResponse.Data")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R+\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR/\u0010\u0012\u001a\u0004\u0018\u00010\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u0006\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/PrepareInviteResponseFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/chatroom/model/PrepareInviteResponse;", "", "<set-?>", "userInRoom$delegate", "Ljava/lang/Object;", "getUserInRoom", "()Z", "setUserInRoom", "(Z)V", "userInRoom", "Lcom/bytedance/android/livesdk/chatroom/model/NoticeInfo;", "noticeInfo$delegate", "getNoticeInfo", "()Lcom/bytedance/android/livesdk/chatroom/model/NoticeInfo;", "setNoticeInfo", "(Lcom/bytedance/android/livesdk/chatroom/model/NoticeInfo;)V", "noticeInfo", "<init>", "()V", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PrepareInviteResponseFlexImpl extends FlexModelBase<PrepareInviteResponse> implements PrepareInviteResponse, vh7.h {

    @SerializedName("notice_info")
    protected NoticeInfo _$$noticeInfo;

    @SerializedName("user_in_room")
    protected boolean _$$userInRoom;

    public PrepareInviteResponseFlexImpl() {
        super(PrepareInviteResponse.class);
        this._$$userInRoom = false;
    }

    /* JADX WARN: Type inference failed for: r4v2, types: [com.bytedance.android.livesdk.chatroom.model.NoticeInfo, java.lang.Object] */
    public PrepareInviteResponseFlexImpl(am3.g r100) {
        super(PrepareInviteResponse.class);
        setThreadSafe(false);
        long r101 = r100.c();
        boolean r102 = false;
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L12;
        am3.g.a r104 = decodeExtensionFields(r103, r100);
        if (r103 != 1) goto L8;
        this._$$userInRoom = am3.h.a(r100);
        r102 = r102 | true;
        goto L3
    L8:
        if (r103 != 2) goto L9;
        this._$$noticeInfo = vh7.f.a(r100, NoticeInfo.class);
        goto L3
    L9:
        am3.h.d(r104, r100);
        goto L3
    L12:
        r100.d(r101);
        setThreadSafe(true);
        if ((r102 & true) == true) goto L25;
        this._$$userInRoom = false;
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.PrepareInviteResponse
    public final NoticeInfo getNoticeInfo() {
        return this._$$noticeInfo;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.PrepareInviteResponse
    public final boolean getUserInRoom() {
        return this._$$userInRoom;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.PrepareInviteResponse
    public final void setNoticeInfo(NoticeInfo r100) {
        this._$$noticeInfo = r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.PrepareInviteResponse
    public final void setUserInRoom(boolean r100) {
        this._$$userInRoom = r100;
    }
}
