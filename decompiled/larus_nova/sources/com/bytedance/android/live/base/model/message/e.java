package com.bytedance.android.live.base.model.message;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/live/base/model/message/e;", "", "", "comboSeq", "Ljava/lang/Long;", "b", "()Ljava/lang/Long;", "setComboSeq", "(Ljava/lang/Long;)V", "comboOrder", "J", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()J", "setComboOrder", "(J)V", "<init>", "()V", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class e implements vh7.h {

    @SerializedName("combo_order")
    protected long comboOrder;

    @SerializedName("combo_seq")
    protected Long comboSeq;

    public e() {
    }

    public final long a() {
        return this.comboOrder;
    }

    public final Long b() {
        return this.comboSeq;
    }

    public e(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        if (r102 != 1) goto L8;
        this.comboSeq = Long.valueOf(r100.j());
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.comboOrder = r100.j();
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r101);
    }
}
