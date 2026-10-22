package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.TaskCenterEntranceMessage")
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/rl;", "Lcom/bytedance/android/livesdk/message/model/o0;", "", "extra", "Ljava/lang/String;", "Lcom/bytedance/android/livesdk/message/model/lm;", "detail", "Lcom/bytedance/android/livesdk/message/model/lm;", "Lcom/bytedance/android/livesdk/message/model/im;", "meta", "Lcom/bytedance/android/livesdk/message/model/im;", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class rl extends o0 implements vh7.h {

    @SerializedName("detail")
    public lm detail;

    @SerializedName("extra")
    public String extra;

    @SerializedName("meta")
    public im meta;

    public rl() {
        this.extra = "";
        this.type = MessageType.TASK_CENTER_ENTRANCE_MESSAGE;
    }

    public rl(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        if (r102 != 1) goto L8;
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.meta = new im(r100);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.detail = new lm(r100);
        goto L3
    L12:
        if (r102 != 4) goto L13;
        this.extra = am3.h.c(r100);
        goto L3
    L13:
        am3.h.e(r100);
        goto L3
    L18:
        r100.d(r101);
        if (this.extra != null) goto L21;
        this.extra = "";
    L21:
        this.type = MessageType.TASK_CENTER_ENTRANCE_MESSAGE;
    }
}
