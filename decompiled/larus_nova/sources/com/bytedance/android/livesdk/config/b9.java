package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/config/b9;", "", "", "enableMock", "Z", "b", "()Z", "setEnableMock", "(Z)V", "", "delayTime", "J", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()J", "setDelayTime", "(J)V", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class b9 {

    @SerializedName("delay_time")
    private long delayTime;

    @SerializedName("enable_mock")
    private boolean enableMock;

    public b9() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b9) == false) goto L10;
        b9 r101 = (b9) r100;
        if (this.enableMock == r101.enableMock) goto L8;
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
        boolean r100 = this.enableMock;
        ?? r101 = r100;
        if (r100 == false) goto L5;
        r101 = 1;
    L5:
        long r102 = this.delayTime;
        return (r101 * 31) + ((int) (r102 ^ (r102 >>> 32)));
    }

    public final String toString() {
        return "KtvOtherResourceDelayDownloadConfig(enableMock=" + this.enableMock + ", delayTime=" + this.delayTime + ")";
    }

    public final long a() {
        return this.delayTime;
    }

    public final boolean b() {
        return this.enableMock;
    }

    public b9(int r100) {
        this.enableMock = false;
        this.delayTime = 10000;
    }
}
