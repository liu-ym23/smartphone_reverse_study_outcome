package com.bytedance.android.livesdkapi.depend.message.wrds;

import am3.g;
import com.bytedance.android.livesdk.message.model.o0;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.im.PreviewCjRpMessage")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/message/wrds/WebcastPreviewCjRpMessage;", "Lcom/bytedance/android/livesdk/message/model/o0;", "Lcom/bytedance/android/livesdkapi/depend/message/wrds/FansRedPacket;", "fansRedPacket", "Lcom/bytedance/android/livesdkapi/depend/message/wrds/FansRedPacket;", "getFansRedPacket", "()Lcom/bytedance/android/livesdkapi/depend/message/wrds/FansRedPacket;", "setFansRedPacket", "(Lcom/bytedance/android/livesdkapi/depend/message/wrds/FansRedPacket;)V", "<init>", "()V", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WebcastPreviewCjRpMessage extends o0 implements h {

    @SerializedName("cjrp")
    protected FansRedPacket fansRedPacket;

    public WebcastPreviewCjRpMessage() {
        this.type = MessageType.PREVIEW_FANS_RED_PACKET_MESSAGE;
    }

    public final FansRedPacket getFansRedPacket() {
        return this.fansRedPacket;
    }

    public WebcastPreviewCjRpMessage(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        if (r102 != 1) goto L8;
        this.fansRedPacket = new FansRedPacket(r100);
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r100);
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r101);
        this.type = MessageType.PREVIEW_FANS_RED_PACKET_MESSAGE;
    }

    public final void setFansRedPacket(FansRedPacket r100) {
        this.fansRedPacket = r100;
    }
}
