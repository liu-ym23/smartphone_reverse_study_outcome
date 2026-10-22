package com.bytedance.android.livesdk.interactivity.api.chatchannel.message;

import com.bytedance.android.livesdk.interactivity.api.message.InteractivityMessageType;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@ProtoMessage("webcast.im.RoomChannelCipherMessage")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/chatchannel/message/e;", "Ly32/a;", "Lcom/bytedance/android/livesdk/interactivity/api/chatchannel/message/d;", "innerMessage", "Lcom/bytedance/android/livesdk/interactivity/api/chatchannel/message/d;", "G", "()Lcom/bytedance/android/livesdk/interactivity/api/chatchannel/message/d;", "setInnerMessage", "(Lcom/bytedance/android/livesdk/interactivity/api/chatchannel/message/d;)V", "<init>", "()V", "interactivity-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class e extends y32.a implements vh7.h {

    @SerializedName("chatMessage")
    protected d innerMessage;

    public e() {
    }

    public e(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        if (r102 != 1) goto L8;
        this.innerMessage = new d(r100);
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
    }

    @Override // y32.a
    public final InteractivityMessageType E() {
        return InteractivityMessageType.RoomChannelEncrypt;
    }

    public final d G() {
        return this.innerMessage;
    }
}
