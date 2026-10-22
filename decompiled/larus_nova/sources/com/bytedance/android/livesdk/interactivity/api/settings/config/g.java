package com.bytedance.android.livesdk.interactivity.api.settings.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/settings/config/g;", "", "", "enableRenderOpt", "Z", "b", "()Z", "", "delayTime", "J", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()J", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class g {

    @SerializedName("delay_time")
    private final long delayTime;

    @SerializedName("enable_render_opt")
    private final boolean enableRenderOpt;

    public g() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof g) == false) goto L10;
        g r101 = (g) r100;
        if (this.enableRenderOpt == r101.enableRenderOpt) goto L8;
        return false;
    L8:
        if (this.delayTime == r101.delayTime) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public final int hashCode() {
        boolean r100 = this.enableRenderOpt;
        ?? r101 = r100;
        if (r100 == false) goto L5;
        r101 = 1;
    L5:
        long r102 = this.delayTime;
        return (r101 * 31) + ((int) (r102 ^ (r102 >>> 32)));
    }

    public final String toString() {
        return "DanmukuRenderOptConfig(enableRenderOpt=" + this.enableRenderOpt + ", delayTime=" + this.delayTime + ")";
    }

    public final long a() {
        return this.delayTime;
    }

    public final boolean b() {
        return this.enableRenderOpt;
    }

    public g(int r100) {
        this.enableRenderOpt = false;
        this.delayTime = 60000;
    }
}
