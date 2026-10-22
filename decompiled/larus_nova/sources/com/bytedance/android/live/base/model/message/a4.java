package com.bytedance.android.live.base.model.message;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/live/base/model/message/a4;", "Lcom/bytedance/android/livesdk/message/model/o0;", "", "bizType", "Ljava/lang/Long;", "G", "()Ljava/lang/Long;", "setBizType", "(Ljava/lang/Long;)V", "status", "getStatus", "setStatus", "Lmm2/b;", "bizInfo", "Lmm2/b;", ExifInterface.LONGITUDE_EAST, "()Lmm2/b;", "setBizInfo", "(Lmm2/b;)V", "<init>", "()V", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class a4 extends com.bytedance.android.livesdk.message.model.o0 implements vh7.h {

    @SerializedName("biz_info")
    protected mm2.b bizInfo;

    @SerializedName("biz_type")
    protected Long bizType;

    @SerializedName("status")
    protected Long status;

    public a4() {
        this.type = MessageType.ROOM_INDICATOR_MESSAGE;
    }

    public final mm2.b E() {
        return this.bizInfo;
    }

    public final Long G() {
        return this.bizType;
    }

    public final Long getStatus() {
        return this.status;
    }

    public a4(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        if (r102 != 1) goto L8;
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.bizType = Long.valueOf(r100.j());
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.status = Long.valueOf(r100.j());
        goto L3
    L12:
        if (r102 != 4) goto L13;
        this.bizInfo = new mm2.b(r100);
        goto L3
    L13:
        am3.h.e(r100);
        goto L3
    L18:
        r100.d(r101);
        this.type = MessageType.ROOM_INDICATOR_MESSAGE;
    }
}
