package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.RoomVerifyMessage")
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0018\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b \u0010!R\"\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0011\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0005\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\tR$\u0010\u0014\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\f\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R\"\u0010\u0017\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0005\u001a\u0004\b\u0018\u0010\u0007\"\u0004\b\u0019\u0010\tR$\u0010\u001a\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\f\u001a\u0004\b\u001b\u0010\u000e\"\u0004\b\u001c\u0010\u0010R$\u0010\u001d\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\f\u001a\u0004\b\u001e\u0010\u000e\"\u0004\b\u001f\u0010\u0010¨\u0006\""}, d2 = {"Lcom/bytedance/android/livesdk/message/model/tk;", "Lcom/bytedance/android/livesdk/message/model/o0;", "Lcom/bytedance/android/live/base/model/message/f4;", "", "_verifyAction", "I", "get_verifyAction", "()I", "set_verifyAction", "(I)V", "", "_content", "Ljava/lang/String;", "get_content", "()Ljava/lang/String;", "set_content", "(Ljava/lang/String;)V", "_unableStyle", "get_unableStyle", "set_unableStyle", "_tipContent", "get_tipContent", "set_tipContent", "_anchorSwitch", "get_anchorSwitch", "set_anchorSwitch", "_switchStatusTipMsg", "get_switchStatusTipMsg", "set_switchStatusTipMsg", "_switchStatusAnchorTipMsg", "get_switchStatusAnchorTipMsg", "set_switchStatusAnchorTipMsg", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class tk extends o0 implements com.bytedance.android.live.base.model.message.f4, vh7.h {

    @SerializedName("anchor_switch")
    protected int _anchorSwitch;

    @SerializedName("content")
    protected String _content;

    @SerializedName("switch_status_anchor_tip_msg")
    protected String _switchStatusAnchorTipMsg;

    @SerializedName("switch_status_tip_msg")
    protected String _switchStatusTipMsg;

    @SerializedName("tip_content")
    protected String _tipContent;

    @SerializedName("unable_style")
    protected int _unableStyle;

    @SerializedName("action")
    protected int _verifyAction;

    @Override // com.bytedance.android.live.base.model.message.f4
    public final void B() {
    }

    @Override // com.bytedance.android.live.base.model.message.f4
    public final void y() {
    }

    public tk() {
        setType(MessageType.ROOM_VERIFY);
    }

    @Override // com.bytedance.android.live.base.model.message.f4
    public final int C() {
        return this._verifyAction;
    }

    @Override // com.bytedance.android.live.base.model.message.f4
    public final int getAnchorSwitch() {
        return this._anchorSwitch;
    }

    @Override // com.bytedance.android.live.base.model.message.f4
    public final String getContent() {
        return this._content;
    }

    @Override // com.bytedance.android.live.base.model.message.f4
    public final String getSwitchStatusAnchorTipMsg() {
        return this._switchStatusAnchorTipMsg;
    }

    @Override // com.bytedance.android.live.base.model.message.f4
    public final String getSwitchStatusTipMsg() {
        return this._switchStatusTipMsg;
    }

    @Override // com.bytedance.android.live.base.model.message.f4
    public final int getUnableStyle() {
        return this._unableStyle;
    }

    @Override // com.bytedance.android.live.base.model.message.f4
    public final String p() {
        return this._tipContent;
    }

    public tk(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        switch(r102) {
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L12;
            case 4: goto L6;
            case 5: goto L6;
            case 6: goto L11;
            case 7: goto L10;
            case 8: goto L9;
            case 9: goto L8;
            case 10: goto L7;
            default: goto L6;
        };
    L7:
        this._switchStatusAnchorTipMsg = am3.h.c(r100);
        goto L3
    L8:
        this._switchStatusTipMsg = am3.h.c(r100);
        goto L3
    L9:
        this._anchorSwitch = r100.i();
        goto L3
    L10:
        this._tipContent = am3.h.c(r100);
        goto L3
    L11:
        this._unableStyle = r100.i();
        goto L3
    L12:
        this._content = am3.h.c(r100);
        goto L3
    L13:
        this._verifyAction = r100.i();
        goto L3
    L14:
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r100);
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
        setType(MessageType.ROOM_VERIFY);
    }
}
