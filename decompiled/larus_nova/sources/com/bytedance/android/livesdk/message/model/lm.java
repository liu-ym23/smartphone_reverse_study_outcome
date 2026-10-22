package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.data.TreasureDetail")
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0016\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\r\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/lm;", "", "", "key", "Ljava/lang/String;", "content", "", "countDown", "J", "countDownKey", "", "triggerTiming", "I", "contentType", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class lm implements vh7.h {

    @SerializedName("content")
    public String content;

    @SerializedName("content_type")
    public int contentType;

    @SerializedName("count_down")
    public long countDown;

    @SerializedName("count_down_key")
    public String countDownKey;

    @SerializedName("key")
    public String key;

    @SerializedName("trigger_timing")
    public int triggerTiming;

    public lm() {
        this.key = "";
        this.content = "";
        this.countDownKey = "";
    }

    public lm(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L13;
        switch(r102) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            default: goto L6;
        };
    L7:
        this.contentType = r100.i();
        goto L3
    L8:
        this.countDownKey = am3.h.c(r100);
        goto L3
    L9:
        this.triggerTiming = r100.i();
        goto L3
    L10:
        this.countDown = r100.j();
        goto L3
    L11:
        this.content = am3.h.c(r100);
        goto L3
    L12:
        this.key = am3.h.c(r100);
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L13:
        r100.d(r101);
        if (this.key != null) goto L17;
        this.key = "";
    L17:
        if (this.content != null) goto L20;
        this.content = "";
    L20:
        if (this.countDownKey != null) goto L39;
        this.countDownKey = "";
        return;
    }
}
