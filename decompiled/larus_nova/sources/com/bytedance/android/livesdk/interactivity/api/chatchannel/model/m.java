package com.bytedance.android.livesdk.interactivity.api.chatchannel.model;

import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.android.live.base.model.message.a5;
import com.google.gson.annotations.SerializedName;
import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@ForMain
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001e\u0010\u0011R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR*\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b\n\u0010\u000b\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR*\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b\u0013\u0010\u0014\u0012\u0004\b\u0019\u0010\u0011\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R*\u0010\u001a\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b\u001a\u0010\u000b\u0012\u0004\b\u001d\u0010\u0011\u001a\u0004\b\u001b\u0010\r\"\u0004\b\u001c\u0010\u000f¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/chatchannel/model/m;", "", "", RemoteMessageConst.MSGID, "J", "getMsgId", "()J", "setMsgId", "(J)V", "", "content", "Ljava/lang/String;", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "getContent$annotations", "()V", "Lcom/bytedance/android/live/base/model/message/a5;", "displayText", "Lcom/bytedance/android/live/base/model/message/a5;", "getDisplayText", "()Lcom/bytedance/android/live/base/model/message/a5;", "setDisplayText", "(Lcom/bytedance/android/live/base/model/message/a5;)V", "getDisplayText$annotations", "msgIdStr", "getMsgIdStr", "setMsgIdStr", "getMsgIdStr$annotations", "<init>", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class m implements vh7.h {

    @SerializedName("content")
    protected String content;

    @SerializedName("display_text")
    protected a5 displayText;

    @SerializedName("msg_id")
    protected long msgId;

    @SerializedName("msg_id_str")
    protected String msgIdStr;

    public m() {
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [com.bytedance.android.live.base.model.message.a5, java.lang.Object] */
    public m(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        if (r102 != 1) goto L8;
        this.msgId = r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.content = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.displayText = vh7.f.a(r100, a5.class);
        goto L3
    L12:
        if (r102 != 4) goto L13;
        this.msgIdStr = am3.h.c(r100);
        goto L3
    L13:
        am3.h.e(r100);
        goto L3
    L18:
        r100.d(r101);
    }
}
