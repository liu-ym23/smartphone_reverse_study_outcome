package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b!\u0010\"R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R(\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\f0\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006#"}, d2 = {"Lcom/bytedance/android/livesdk/config/e11;", "", "", "closeRetryEnable", "Z", "b", "()Z", "setCloseRetryEnable", "(Z)V", "pauseRetryEnable", "e", "setPauseRetryEnable", "", "closeRetryTimes", "I", "d", "()I", "setCloseRetryTimes", "(I)V", "", "closeRetryInterval", "J", "c", "()J", "setCloseRetryInterval", "(J)V", "", "closeErrorCode", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "setCloseErrorCode", "(Ljava/util/List;)V", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class e11 {

    @SerializedName("close_retry_code")
    private List<Integer> closeErrorCode;

    @SerializedName("close_retry_enable")
    private boolean closeRetryEnable;

    @SerializedName("close_retry_interval")
    private long closeRetryInterval;

    @SerializedName("close_retry_times")
    private int closeRetryTimes;

    @SerializedName("pause_retry_enable")
    private boolean pauseRetryEnable;

    public e11() {
        this.closeRetryTimes = 2;
        this.closeRetryInterval = 200;
        this.closeErrorCode = CollectionsKt.mutableListOf(new Integer[]{-106, 500, 501, 502, 503, -998, -997, -999});
    }

    public final List<Integer> a() {
        return this.closeErrorCode;
    }

    public final boolean b() {
        return this.closeRetryEnable;
    }

    public final long c() {
        return this.closeRetryInterval;
    }

    public final int d() {
        return this.closeRetryTimes;
    }

    public final boolean e() {
        return this.pauseRetryEnable;
    }
}
