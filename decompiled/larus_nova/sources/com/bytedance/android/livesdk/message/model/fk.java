package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.livesdkapi.message.IRoomMessageExtra;
import com.bytedance.android.livesdkapi.message.IRoomMessageGiftExtra;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\bR\"\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/fk;", "Lcom/bytedance/android/livesdkapi/message/IRoomMessageExtra;", "Lcom/bytedance/android/livesdk/message/model/gk;", "giftMessageExtra", "Lcom/bytedance/android/livesdk/message/model/gk;", "getGiftMessageExtra", "()Lcom/bytedance/android/livesdk/message/model/gk;", "getGiftMessageExtra$annotations", "()V", "<init>", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class fk implements IRoomMessageExtra, vh7.h {

    @SerializedName("gift_extra")
    protected gk giftMessageExtra;

    public fk() {
    }

    public fk(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L9;
        if (r102 != 1) goto L7;
        this.giftMessageExtra = new gk(r100);
        goto L3
    L7:
        am3.h.e(r100);
        goto L3
    L9:
        r100.d(r101);
    }

    @Override // com.bytedance.android.livesdkapi.message.IRoomMessageExtra
    public final IRoomMessageGiftExtra getGiftExtra() {
        return this.giftMessageExtra;
    }
}
