package com.bytedance.android.live.recharge.platform.model;

import com.bytedance.tools.kcp.aio.runtime.RpcMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0087\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/recharge/platform/model/e;", "", "", "payChannel", "I", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()I", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
@RpcMessage(messageName = "webcast.revenue.biz.recharge.nopassword.SignData")
public final class e {

    @SerializedName("pay_show_channel")
    private final int payChannel;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == true) goto L6;
        return false;
    L6:
        if (this.payChannel == ((e) r100).payChannel) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        return this.payChannel;
    }

    public final String toString() {
        return "NoPasswordSignData(payChannel=" + this.payChannel + ")";
    }

    public final int a() {
        return this.payChannel;
    }

    public e(int r100) {
        this.payChannel = r100;
    }
}
