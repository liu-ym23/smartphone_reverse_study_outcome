package com.bytedance.android.livesdk.message.model;

import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001a\u0010\u001bR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/sl;", "", "", "key", "Ljava/lang/String;", "getKey", "()Ljava/lang/String;", "setKey", "(Ljava/lang/String;)V", "", "value", "J", "getValue", "()J", "setValue", "(J)V", OnekeyLoginConstants.CU_KEY_OPERATOR, "getOperator", "setOperator", "Lcom/bytedance/android/livesdk/message/model/tl;", "extra", "Lcom/bytedance/android/livesdk/message/model/tl;", "getExtra", "()Lcom/bytedance/android/livesdk/message/model/tl;", "setExtra", "(Lcom/bytedance/android/livesdk/message/model/tl;)V", "<init>", "()V", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class sl implements vh7.h {

    @SerializedName("extra")
    protected tl extra;

    @SerializedName("key")
    protected String key;

    @SerializedName(OnekeyLoginConstants.CU_KEY_OPERATOR)
    protected String operator;

    @SerializedName("value")
    protected long value;

    public sl() {
    }

    public sl(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        if (r102 != 1) goto L8;
        this.key = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.value = r100.j();
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.operator = am3.h.c(r100);
        goto L3
    L12:
        if (r102 != 4) goto L13;
        this.extra = new tl(r100);
        goto L3
    L13:
        am3.h.e(r100);
        goto L3
    L18:
        r100.d(r101);
    }
}
