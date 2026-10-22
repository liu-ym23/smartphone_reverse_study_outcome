package com.bytedance.android.livesdk.message.model;

import com.android.ttcjpaysdk.verify.constants.DyVerifyEventConstants;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.message.CommonMessageData;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoDecode;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.NotifyMessage")
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b'\u0010(R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0004R$\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010 \u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0018\u0010&\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b&\u0010\u0004¨\u0006)"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/ik;", "Lcom/bytedance/android/livesdk/message/model/o0;", "", "_content", "Ljava/lang/String;", "get_content", "()Ljava/lang/String;", "set_content", "(Ljava/lang/String;)V", "", "_notifyType", "J", "get_notifyType", "()J", "set_notifyType", "(J)V", "", "_notifyClass", "I", "get_notifyClass", "()I", "set_notifyClass", "(I)V", "_schema", "Lcom/bytedance/android/livesdk/message/model/RoomNotifyMessageExtra;", "_extra", "Lcom/bytedance/android/livesdk/message/model/RoomNotifyMessageExtra;", "get_extra", "()Lcom/bytedance/android/livesdk/message/model/RoomNotifyMessageExtra;", "Q", "(Lcom/bytedance/android/livesdk/message/model/RoomNotifyMessageExtra;)V", "Lcom/bytedance/android/live/base/model/user/User;", "_user", "Lcom/bytedance/android/live/base/model/user/User;", "get_user", "()Lcom/bytedance/android/live/base/model/user/User;", "set_user", "(Lcom/bytedance/android/live/base/model/user/User;)V", "_scene", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ik extends o0 implements vh7.h {

    @SerializedName("content")
    protected String _content;

    @SerializedName("extra")
    protected RoomNotifyMessageExtra _extra;

    @SerializedName("notify_class")
    protected int _notifyClass;

    @SerializedName("notify_type")
    protected long _notifyType;

    @SerializedName(DyVerifyEventConstants.EventParam.BIZ_SCENE)
    protected String _scene;

    @SerializedName("schema")
    protected String _schema;

    @SerializedName("user")
    protected User _user;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @IgnoreProtoDecode
    public int f153656a;

    public final String getScene() {
        String r100 = this._scene;
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public final String getSchema() {
        String r100 = this._schema;
        if (r100 == null) goto L5;
        Intrinsics.checkNotNull(r100);
        return r100;
    L5:
        return "";
    }

    public ik() {
        this.type = MessageType.ROOM_NOTIFY;
    }

    @Override // com.bytedance.android.livesdk.message.model.o0, com.bytedance.android.livesdkapi.message.BaseMessage, com.bytedance.android.live.base.model.message.t
    public final boolean supportDisplayText() {
        CommonMessageData r100 = getBaseMessage();
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.supportDisplayText() != true) goto L7;
        return true;
    }

    public final RoomNotifyMessageExtra E() {
        return this._extra;
    }

    public final int G() {
        return this._notifyClass;
    }

    public final long H() {
        return this._notifyType;
    }

    public final User getUser() {
        return this._user;
    }

    public ik(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L17;
        if (r102 != 100) goto L7;
        this._scene = am3.h.c(r100);
        goto L3
    L7:
        switch(r102) {
            case 1: goto L15;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L9;
            default: goto L8;
        };
    L9:
        this._notifyClass = (int) r100.j();
        goto L3
    L10:
        this._extra = ro.a(r100);
        goto L3
    L11:
        this._user = new User(r100);
        goto L3
    L12:
        this._content = am3.h.c(r100);
        goto L3
    L13:
        this._notifyType = r100.j();
        goto L3
    L14:
        this._schema = am3.h.c(r100);
        goto L3
    L15:
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r100);
        goto L3
    L8:
        am3.h.e(r100);
        goto L3
    L17:
        r100.d(r101);
        this.type = MessageType.ROOM_NOTIFY;
    }

    public final void P(RoomNotifyMessageExtra r100) {
        this._extra = r100;
    }

    public final void Q(RoomNotifyMessageExtra r100) {
        this._extra = r100;
    }

    public final void setSchema(String r100) {
        this._schema = "";
    }
}
