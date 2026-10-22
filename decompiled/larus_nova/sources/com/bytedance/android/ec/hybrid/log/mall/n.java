package com.bytedance.android.ec.hybrid.log.mall;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u000eR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/ec/hybrid/log/mall/n;", "", "", "autoplayEnable", "Z", "getAutoplayEnable", "()Z", "", "mallLogBatchSize", "I", "getMallLogBatchSize", "()I", "mallLogTimeWindowMs", "getMallLogTimeWindowMs", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-hybrid_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class n {

    @SerializedName("enable_log_opt")
    private final boolean autoplayEnable;

    @SerializedName("mall_log_batch_size")
    private final int mallLogBatchSize;

    @SerializedName("mall_log_time_window_ms")
    private final int mallLogTimeWindowMs;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof n) == false) goto L12;
        n r101 = (n) r100;
        if (this.autoplayEnable == r101.autoplayEnable) goto L8;
        return false;
    L8:
        if (this.mallLogBatchSize == r101.mallLogBatchSize) goto L10;
        return false;
    L10:
        if (this.mallLogTimeWindowMs == r101.mallLogTimeWindowMs) goto L19;
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
        boolean r100 = this.autoplayEnable;
        ?? r101 = r100;
        if (r100 == false) goto L6;
        r101 = 1;
    L6:
        return (((r101 * 31) + this.mallLogBatchSize) * 31) + this.mallLogTimeWindowMs;
    }

    public final String toString() {
        return "LegouMallLogOptConfig(autoplayEnable=" + this.autoplayEnable + ", mallLogBatchSize=" + this.mallLogBatchSize + ", mallLogTimeWindowMs=" + this.mallLogTimeWindowMs + ")";
    }

    public n() {
        this.autoplayEnable = false;
        this.mallLogBatchSize = 50;
        this.mallLogTimeWindowMs = 50;
    }
}
