package com.bytedance.android.gamecp.live_impl.message;

import com.bytedance.android.livesdkapi.message.ExternalBaseMessage;
import com.bytedance.android.livesdkapi.message.ExternalMessageType;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@ProtoMessage("webcast.im.InteractionPlayRealNameAuthMessage")
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/gamecp/live_impl/message/i;", "Lcom/bytedance/android/livesdkapi/message/ExternalBaseMessage;", "", "interactionPlayAuthScene", "J", "", "clientKey", "Ljava/lang/String;", "Lcom/bytedance/android/gamecp/live_impl/message/s;", "twoElementAgreement", "Lcom/bytedance/android/gamecp/live_impl/message/s;", "Lcom/bytedance/android/gamecp/live_impl/message/f;", "event_param", "Lcom/bytedance/android/gamecp/live_impl/message/f;", "<init>", "()V", "gamecp-live-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class i extends ExternalBaseMessage implements vh7.h {

    @SerializedName("client_key")
    public String clientKey;

    @SerializedName("event_param")
    public f event_param;

    @SerializedName("scene")
    public long interactionPlayAuthScene;

    @SerializedName("two_element_agreement")
    public s twoElementAgreement;

    @Override // com.bytedance.android.livesdkapi.message.ExternalBaseMessage, com.bytedance.android.livesdkapi.message.BaseMessage, tlc.d, com.bytedance.android.livesdkapi.message.IExternalLiveMessage
    public final int getIntType() {
        return 6008;
    }

    public i() {
        this.clientKey = "";
        this.twoElementAgreement = new s(0);
        this.event_param = new f(0);
    }

    @Override // com.bytedance.android.livesdkapi.message.IExternalLiveMessage
    public final ExternalMessageType getExternalMessageType() {
        return ExternalMessageType.EXTERNAL_GAME_PROMOTE;
    }

    public i(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L21;
        if (r102 != 1) goto L8;
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.interactionPlayAuthScene = r100.i();
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.clientKey = am3.h.c(r100);
        goto L3
    L12:
        if (r102 != 4) goto L14;
        this.twoElementAgreement = new s(r100);
        goto L3
    L14:
        if (r102 != 5) goto L15;
        this.event_param = new f(r100);
        goto L3
    L15:
        am3.h.e(r100);
        goto L3
    L21:
        r100.d(r101);
        if (this.clientKey != null) goto L25;
        this.clientKey = "";
    L25:
        if (this.twoElementAgreement != null) goto L28;
        this.twoElementAgreement = new s(0);
    L28:
        if (this.event_param != null) goto L49;
        this.event_param = new f(0);
        return;
    }
}
