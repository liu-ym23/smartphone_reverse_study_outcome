package com.bytedance.android.livesdk.interactivity.api.chatchannel.utils;

import com.bytedance.android.livesdkapi.message.BaseMessage;
import com.bytedance.android.livesdkapi.message.CommonMessageData;

/* JADX INFO: loaded from: classes9.dex */
public final class o {
    public static final long a(BaseMessage r100) {
        if (r100 == null) goto L6;
        CommonMessageData r101 = r100.baseMessage;
        if (r101 == null) goto L6;
        return r101.channelId;
    L6:
        return 0;
    }

    public static final long b(tlc.d r100) {
        if ((r100 instanceof BaseMessage) == true) goto L5;
        r100 = null;
    L5:
        BaseMessage r101 = (BaseMessage) r100;
        if (r101 == null) goto L10;
        CommonMessageData r102 = r101.baseMessage;
        if (r102 == null) goto L10;
        return r102.channelId;
    L10:
        return 0;
    }
}
