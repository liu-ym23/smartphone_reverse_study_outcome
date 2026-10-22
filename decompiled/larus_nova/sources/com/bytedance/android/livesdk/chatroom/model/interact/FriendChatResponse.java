package com.bytedance.android.livesdk.chatroom.model.interact;

import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.livesdkapi.message.Text;
import com.bytedance.android.livesdkapi.message._Text_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@ProtoMessage("webcast.api.room.FriendChatResponse.ResponseData")
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u001e\u001a\u0004\u0018\u00010\u0004J\b\u0010\u001f\u001a\u0004\u0018\u00010\nJ\u0006\u0010 \u001a\u00020\u0010J\u0006\u0010!\u001a\u00020\u0010J\b\u0010\"\u001a\u0004\u0018\u00010\u0019J\u0010\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0004J\u0010\u0010&\u001a\u00020$2\b\u0010'\u001a\u0004\u0018\u00010\nJ\u000e\u0010(\u001a\u00020$2\u0006\u0010)\u001a\u00020\u0010J\u000e\u0010*\u001a\u00020$2\u0006\u0010+\u001a\u00020\u0010J\u0010\u0010,\u001a\u00020$2\b\u0010-\u001a\u0004\u0018\u00010\u0019R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R \u0010\u0018\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006."}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/interact/FriendChatResponse;", "", "()V", "_content", "", "get_content", "()Ljava/lang/String;", "set_content", "(Ljava/lang/String;)V", "_displayText", "Lcom/bytedance/android/livesdkapi/message/Text;", "get_displayText", "()Lcom/bytedance/android/livesdkapi/message/Text;", "set_displayText", "(Lcom/bytedance/android/livesdkapi/message/Text;)V", DBDefinition.ID, "", "get_id", "()J", "set_id", "(J)V", "_msgId", "get_msgId", "set_msgId", "_user", "Lcom/bytedance/android/live/base/model/user/User;", "get_user", "()Lcom/bytedance/android/live/base/model/user/User;", "set_user", "(Lcom/bytedance/android/live/base/model/user/User;)V", "getContent", "getDisplayText", "getId", "getMsgId", "getUser", "setContent", "", "content", "setDisplayText", "displayText", "setId", "id", "setMsgId", RemoteMessageConst.MSGID, "setUser", "user", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FriendChatResponse implements vh7.h {

    @SerializedName("content")
    protected String _content;

    @SerializedName("display_text")
    protected Text _displayText;

    @SerializedName("id")
    protected long _id;

    @SerializedName("msg_id")
    protected long _msgId;

    @SerializedName("user")
    protected User _user;

    public FriendChatResponse() {
    }

    public final String getContent() {
        return this._content;
    }

    public final Text getDisplayText() {
        return this._displayText;
    }

    public final long getId() {
        return this._id;
    }

    public final long getMsgId() {
        return this._msgId;
    }

    public final User getUser() {
        return this._user;
    }

    public final String get_content() {
        return this._content;
    }

    public final Text get_displayText() {
        return this._displayText;
    }

    public final long get_id() {
        return this._id;
    }

    public final long get_msgId() {
        return this._msgId;
    }

    public final User get_user() {
        return this._user;
    }

    public FriendChatResponse(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L21;
        if (r102 != 1) goto L8;
        this._id = r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this._msgId = r100.j();
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this._content = am3.h.c(r100);
        goto L3
    L12:
        if (r102 != 4) goto L14;
        this._displayText = _Text_ProtoDecoder.decodeStatic(r100);
        goto L3
    L14:
        if (r102 != 5) goto L15;
        this._user = new User(r100);
        goto L3
    L15:
        am3.h.e(r100);
        goto L3
    L21:
        r100.d(r101);
    }

    public final void setContent(String r100) {
        this._content = r100;
    }

    public final void setDisplayText(Text r100) {
        this._displayText = r100;
    }

    public final void setId(long r100) {
        this._id = r100;
    }

    public final void setMsgId(long r100) {
        this._msgId = r100;
    }

    public final void setUser(User r100) {
        this._user = r100;
    }

    public final void set_content(String r100) {
        this._content = r100;
    }

    public final void set_displayText(Text r100) {
        this._displayText = r100;
    }

    public final void set_id(long r100) {
        this._id = r100;
    }

    public final void set_msgId(long r100) {
        this._msgId = r100;
    }

    public final void set_user(User r100) {
        this._user = r100;
    }
}
