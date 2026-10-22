package com.bytedance.android.gamecp.live_impl.message;

import com.bytedance.android.livesdkapi.message.ExternalBaseMessage;
import com.bytedance.android.livesdkapi.message.ExternalMessageType;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@ProtoMessage("webcast.im.InteractionPlayBanMessage")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004¨\u0006\t"}, d2 = {"Lcom/bytedance/android/gamecp/live_impl/message/g;", "Lcom/bytedance/android/livesdkapi/message/ExternalBaseMessage;", "", "title", "Ljava/lang/String;", "text", "detailUrl", "<init>", "()V", "gamecp-live-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class g extends ExternalBaseMessage implements vh7.h {

    @SerializedName("detail_url")
    public String detailUrl;

    @SerializedName("text")
    public String text;

    @SerializedName("title")
    public String title;

    @Override // com.bytedance.android.livesdkapi.message.ExternalBaseMessage, com.bytedance.android.livesdkapi.message.BaseMessage, tlc.d, com.bytedance.android.livesdkapi.message.IExternalLiveMessage
    public final int getIntType() {
        return 6011;
    }

    public g() {
        this.title = "";
        this.text = "";
        this.detailUrl = "";
    }

    @Override // com.bytedance.android.livesdkapi.message.IExternalLiveMessage
    public final ExternalMessageType getExternalMessageType() {
        return ExternalMessageType.EXTERNAL_GAME_PROMOTE;
    }

    public g(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        if (r102 != 1) goto L8;
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.title = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.text = am3.h.c(r100);
        goto L3
    L12:
        if (r102 != 4) goto L13;
        this.detailUrl = am3.h.c(r100);
        goto L3
    L13:
        am3.h.e(r100);
        goto L3
    L18:
        r100.d(r101);
        if (this.title != null) goto L22;
        this.title = "";
    L22:
        if (this.text != null) goto L25;
        this.text = "";
    L25:
        if (this.detailUrl != null) goto L43;
        this.detailUrl = "";
        return;
    }
}
