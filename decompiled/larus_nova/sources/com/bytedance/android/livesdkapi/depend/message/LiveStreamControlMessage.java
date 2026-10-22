package com.bytedance.android.livesdkapi.depend.message;

import am3.g;
import com.bytedance.android.livesdk.message.model.o0;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.im.LiveStreamControlMessage")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R$\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/message/LiveStreamControlMessage;", "Lcom/bytedance/android/livesdk/message/model/o0;", "", "getControlParams", "_controlParams", "Ljava/lang/String;", "get_controlParams", "()Ljava/lang/String;", "set_controlParams", "(Ljava/lang/String;)V", "<init>", "()V", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveStreamControlMessage extends o0 implements h {

    @SerializedName("control_params")
    protected String _controlParams;

    public LiveStreamControlMessage() {
        this.type = MessageType.STREAM_CONTROL_MESSAGE;
    }

    public final String getControlParams() {
        return this._controlParams;
    }

    public final String get_controlParams() {
        return this._controlParams;
    }

    public LiveStreamControlMessage(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        if (r102 != 1) goto L8;
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r100);
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this._controlParams = am3.h.c(r100);
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r101);
        this.type = MessageType.STREAM_CONTROL_MESSAGE;
    }

    public final void set_controlParams(String r100) {
        this._controlParams = r100;
    }
}
