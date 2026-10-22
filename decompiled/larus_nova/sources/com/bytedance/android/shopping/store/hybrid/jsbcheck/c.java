package com.bytedance.android.shopping.store.hybrid.jsbcheck;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R(\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/shopping/store/hybrid/jsbcheck/c;", "", "", "verifyMode", "I", "getVerifyMode", "()I", "", "", "paramLimitPolicy", "Ljava/util/Map;", "getParamLimitPolicy", "()Ljava/util/Map;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c {

    @SerializedName("param_limit_policy")
    private final Map<String, String> paramLimitPolicy;

    @SerializedName("verify_mode")
    private final int verifyMode;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L10;
        c r101 = (c) r100;
        if (this.verifyMode == r101.verifyMode) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.paramLimitPolicy, r101.paramLimitPolicy) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        int r100 = this.verifyMode * 31;
        Map<String, String> r101 = this.paramLimitPolicy;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return r100 + r102;
    L5:
        r102 = 0;
        goto L7
    }

    public final String toString() {
        return "ECStoreJsbPolicyUnit(verifyMode=" + this.verifyMode + ", paramLimitPolicy=" + this.paramLimitPolicy + ")";
    }

    public c() {
        this.verifyMode = 0;
        this.paramLimitPolicy = null;
    }
}
