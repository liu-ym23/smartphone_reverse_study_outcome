package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.livesdkapi.minigame.SeiMessageConst;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.CloudGamingPodMessage")
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/c3;", "Lcom/bytedance/android/livesdk/message/model/o0;", "", "msgType", "I", "", "text", "Ljava/lang/String;", "", "remainSeconds", "J", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c3 extends o0 implements vh7.h {

    @SerializedName(SeiMessageConst.MSG_TYPE)
    public int msgType;

    @SerializedName("remain_seconds")
    public long remainSeconds;

    @SerializedName("text")
    public String text;

    public c3() {
        this.text = "";
        this.type = MessageType.OPEN_GAME_CLOUD_GAMING_POD_MESSAGE;
    }

    public c3(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        if (r102 != 1) goto L8;
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.msgType = r100.i();
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.text = am3.h.c(r100);
        goto L3
    L12:
        if (r102 != 4) goto L13;
        this.remainSeconds = r100.j();
        goto L3
    L13:
        am3.h.e(r100);
        goto L3
    L18:
        r100.d(r101);
        if (this.text != null) goto L21;
        this.text = "";
    L21:
        this.type = MessageType.OPEN_GAME_CLOUD_GAMING_POD_MESSAGE;
    }
}
