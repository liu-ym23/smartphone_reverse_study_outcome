package com.bytedance.android.livesdk.message.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/o2;", "", "", "hasSentOrderGift", "Ljava/lang/Boolean;", "b", "()Ljava/lang/Boolean;", "setHasSentOrderGift", "(Ljava/lang/Boolean;)V", "hasSentJoinGift", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setHasSentJoinGift", "<init>", "()V", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class o2 implements vh7.h {

    @SerializedName("has_sent_join_gift")
    protected Boolean hasSentJoinGift;

    @SerializedName("has_sent_order_gift")
    protected Boolean hasSentOrderGift;

    public o2() {
        Boolean r100 = Boolean.FALSE;
        this.hasSentOrderGift = r100;
        this.hasSentJoinGift = r100;
    }

    public final Boolean a() {
        return this.hasSentJoinGift;
    }

    public final Boolean b() {
        return this.hasSentOrderGift;
    }

    public o2(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        if (r102 != 1) goto L8;
        this.hasSentOrderGift = Boolean.valueOf(am3.h.a(r100));
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.hasSentJoinGift = Boolean.valueOf(am3.h.a(r100));
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r101);
        if (this.hasSentOrderGift != null) goto L16;
        this.hasSentOrderGift = Boolean.FALSE;
    L16:
        if (this.hasSentJoinGift != null) goto L28;
        this.hasSentJoinGift = Boolean.FALSE;
        return;
    }
}
