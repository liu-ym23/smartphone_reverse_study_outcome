package com.bytedance.android.livesdk.message.model;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.RoomAuthInterventionVerifyMessage")
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0012\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b!\u0010\"R$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0012\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u0018\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0005\u001a\u0004\b\u0019\u0010\u0007\"\u0004\b\u001a\u0010\tR$\u0010\u001b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0005\u001a\u0004\b\u001c\u0010\u0007\"\u0004\b\u001d\u0010\tR$\u0010\u001e\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0005\u001a\u0004\b\u001f\u0010\u0007\"\u0004\b \u0010\t¨\u0006#"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/sj;", "Lcom/bytedance/android/livesdk/message/model/o0;", "", "", "_name", "Ljava/lang/String;", ExifInterface.LONGITUDE_EAST, "()Ljava/lang/String;", "set_name", "(Ljava/lang/String;)V", "", "_status", "J", "G", "()J", "set_status", "(J)V", "", "_unableStyle", "I", "Q", "()I", "set_unableStyle", "(I)V", "_content", "get_content", "set_content", "_switchStatusTipMsg", "P", "set_switchStatusTipMsg", "_switchStatusAnchorTipMsg", FaceService.neutralLabel, "set_switchStatusAnchorTipMsg", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class sj extends o0 implements vh7.h {

    @SerializedName("content")
    protected String _content;

    @SerializedName("name")
    protected String _name;

    @SerializedName("status")
    protected long _status;

    @SerializedName("switch_status_anchor_tip_msg")
    protected String _switchStatusAnchorTipMsg;

    @SerializedName("switch_status_tip_msg")
    protected String _switchStatusTipMsg;

    @SerializedName("unableStyle")
    protected int _unableStyle;

    public sj() {
        this.type = MessageType.ROOM_AUTH_INTERVENTION_MESSAGE;
    }

    public final String E() {
        return this._name;
    }

    public final long G() {
        return this._status;
    }

    public final String H() {
        return this._switchStatusAnchorTipMsg;
    }

    public final String P() {
        return this._switchStatusTipMsg;
    }

    public final int Q() {
        return this._unableStyle;
    }

    public final String get_content() {
        return this._content;
    }

    public sj(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L14;
        switch(r102) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            case 7: goto L7;
            default: goto L6;
        };
    L7:
        this._switchStatusAnchorTipMsg = am3.h.c(r100);
        goto L3
    L8:
        this._switchStatusTipMsg = am3.h.c(r100);
        goto L3
    L9:
        this._content = am3.h.c(r100);
        goto L3
    L10:
        this._unableStyle = r100.i();
        goto L3
    L11:
        this._status = r100.j();
        goto L3
    L12:
        this._name = am3.h.c(r100);
        goto L3
    L13:
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r100);
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L14:
        r100.d(r101);
        this.type = MessageType.ROOM_AUTH_INTERVENTION_MESSAGE;
    }
}
