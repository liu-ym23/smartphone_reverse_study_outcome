package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.RanklistHourEntranceMessage")
public final class d6 extends o0 implements vh7.h {
    public d6() {
        this.type = MessageType.HOUR_RANK_ENTRANCE_MESSAGE;
    }

    public d6(am3.g r100) {
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
        this.type = MessageType.HOUR_RANK_ENTRANCE_MESSAGE;
    }
}
