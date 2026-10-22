package com.bytedance.android.livesdkapi.depend.message;

import am3.g;
import com.bytedance.android.livesdk.message.model.o0;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.im.PreviewBlockMessage")
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/message/PreviewUserBlockMessage;", "Lcom/bytedance/android/livesdk/message/model/o0;", "<init>", "()V", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PreviewUserBlockMessage extends o0 implements h {
    public PreviewUserBlockMessage() {
        this.type = MessageType.PREVIEW_USER_BLOCK_MESSAGE;
    }

    public PreviewUserBlockMessage(g r100) {
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
        this.type = MessageType.PREVIEW_USER_BLOCK_MESSAGE;
    }
}
