package com.bytedance.android.live.wallet.model.queryorder;

import am3.g;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/live/wallet/model/queryorder/a;", "", "", "status", "I", "b", "()I", "setStatus", "(I)V", "", "money", "J", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()J", "setMoney", "(J)V", "<init>", "()V", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class a implements h {

    @SerializedName("money")
    protected long money;

    @SerializedName("status")
    protected int status;

    public a() {
    }

    public final String toString() {
        return "CheckOrderData{status=" + this.status + ", money=" + this.money + '}';
    }

    public final long a() {
        return this.money;
    }

    public final int b() {
        return this.status;
    }

    public a(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        if (r102 != 1) goto L8;
        this.status = r100.i();
        goto L3
    L8:
        if (r102 != 3) goto L9;
        this.money = r100.j();
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r101);
    }
}
