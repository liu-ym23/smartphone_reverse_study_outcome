package com.bytedance.android.livesdk.interactivity.api.chatchannel.message;

import com.bytedance.android.livesdk.interactivity.api.message.InteractivityMessageType;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;

/* JADX INFO: loaded from: classes9.dex */
@ProtoMessage("webcast.im.RoomChannelSystemMessage")
public final class p extends y32.a implements vh7.h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f132926b;

    public p() {
    }

    public p(am3.g r100) {
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

    @Override // y32.a
    public final InteractivityMessageType E() {
        return InteractivityMessageType.RoomChannelSystem;
    }
}
