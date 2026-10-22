package com.bytedance.android.ec.store.repository.vo;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/ec/store/repository/vo/a;", "", "", "cartAddibleStatus", "Ljava/lang/Boolean;", "b", "()Ljava/lang/Boolean;", "Lsj3/n;", "addCartButton", "Lsj3/n;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lsj3/n;", "", "extraParam", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("add_cart_button")
    private final sj3.n addCartButton;

    @SerializedName("cart_addible_status")
    private final Boolean cartAddibleStatus;

    @SerializedName("extra_param")
    private final String extraParam;

    public a() {
        this.cartAddibleStatus = Boolean.TRUE;
    }

    public final sj3.n a() {
        return this.addCartButton;
    }

    public final Boolean b() {
        return this.cartAddibleStatus;
    }

    public final String c() {
        return this.extraParam;
    }
}
