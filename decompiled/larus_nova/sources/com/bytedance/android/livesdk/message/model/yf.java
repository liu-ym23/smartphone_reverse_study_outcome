package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.livesdkapi.message.ExternalBaseMessage;
import com.bytedance.android.livesdkapi.message.ExternalMessageType;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.ClientFallbackDynamicMessage")
public final class yf extends ExternalBaseMessage implements vh7.h {
    public yf() {
    }

    public yf(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L9;
        if (r102 != 1) goto L7;
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r100);
        goto L3
    L7:
        am3.h.e(r100);
        goto L3
    L9:
        r100.d(r101);
    }

    @Override // com.bytedance.android.livesdkapi.message.ExternalBaseMessage, com.bytedance.android.livesdkapi.message.BaseMessage, com.bytedance.android.live.base.model.message.t
    public final boolean isTooMuchMsg() {
        return false;
    }

    @Override // com.bytedance.android.livesdkapi.message.ExternalBaseMessage, com.bytedance.android.livesdkapi.message.BaseMessage, com.bytedance.android.livesdk.message.model.o7
    public final void setLocalInsertMsg(boolean r100) {
    }

    @Override // com.bytedance.android.livesdkapi.message.ExternalBaseMessage, com.bytedance.android.livesdkapi.message.BaseMessage, com.bytedance.android.live.base.model.message.t
    public final void setTooMuchMsg(boolean r100) {
    }

    @Override // com.bytedance.android.livesdkapi.message.ExternalBaseMessage, com.bytedance.android.livesdkapi.message.BaseMessage, tlc.d, com.bytedance.android.livesdkapi.message.IExternalLiveMessage
    public final int getIntType() {
        return ExternalMessageType.LYNX_DYNAMIC_MESSAGE.getMin();
    }

    @Override // com.bytedance.android.livesdkapi.message.IExternalLiveMessage
    public final ExternalMessageType getExternalMessageType() {
        return ExternalMessageType.LYNX_DYNAMIC_MESSAGE;
    }
}
