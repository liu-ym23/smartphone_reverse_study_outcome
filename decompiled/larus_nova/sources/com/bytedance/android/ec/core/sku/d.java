package com.bytedance.android.ec.core.sku;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R$\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/ec/core/sku/d;", "", "", "", "bizIdentifierState", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class d {

    @SerializedName("biz_identifier_state")
    private final List<String> bizIdentifierState;

    public d() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.bizIdentifierState, ((d) r100).bizIdentifierState) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        List<String> r100 = this.bizIdentifierState;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "SkuYataForceSwitchBizConfig(bizIdentifierState=" + this.bizIdentifierState + ")";
    }

    public final List<String> a() {
        return this.bizIdentifierState;
    }

    public d(Object r100) {
        this.bizIdentifierState = null;
    }
}
