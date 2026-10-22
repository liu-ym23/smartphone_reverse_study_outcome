package com.bytedance.android.marketing.sdk.impl.data;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR,\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u000e0\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/marketing/sdk/impl/data/f;", "", "", "ecMarketingWindowEnable", "Z", "b", "()Z", "", "ecMarketingWindowListenTimeout", "I", "c", "()I", "", "", "", "ecMarketingAddWindow", "Ljava/util/Map;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/Map;", "ec-biz-marketing-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class f {

    @SerializedName("ec_marketing_add_window")
    private final Map<String, List<String>> ecMarketingAddWindow;

    @SerializedName("ec_marketing_window_enable")
    private final boolean ecMarketingWindowEnable;

    @SerializedName("ec_marketing_window_listen_timeout")
    private final int ecMarketingWindowListenTimeout;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof f) == false) goto L12;
        f r101 = (f) r100;
        if (this.ecMarketingWindowEnable == r101.ecMarketingWindowEnable) goto L8;
        return false;
    L8:
        if (this.ecMarketingWindowListenTimeout == r101.ecMarketingWindowListenTimeout) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.ecMarketingAddWindow, r101.ecMarketingAddWindow) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public final int hashCode() {
        boolean r100 = this.ecMarketingWindowEnable;
        ?? r101 = r100;
        if (r100 == false) goto L5;
        r101 = 1;
    L5:
        int r102 = ((r101 * 31) + this.ecMarketingWindowListenTimeout) * 31;
        Map<String, List<String>> r103 = this.ecMarketingAddWindow;
        if (r103 == null) goto L8;
        int r104 = r103.hashCode();
    L10:
        return r102 + r104;
    L8:
        r104 = 0;
        goto L10
    }

    public final String toString() {
        return "ECMarketingWindowData(ecMarketingWindowEnable=" + this.ecMarketingWindowEnable + ", ecMarketingWindowListenTimeout=" + this.ecMarketingWindowListenTimeout + ", ecMarketingAddWindow=" + this.ecMarketingAddWindow + ")";
    }

    public final Map<String, List<String>> a() {
        return this.ecMarketingAddWindow;
    }

    public final boolean b() {
        return this.ecMarketingWindowEnable;
    }

    public final int c() {
        return this.ecMarketingWindowListenTimeout;
    }
}
