package com.bytedance.android.ec.hybrid.data;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u0012\u0010\nR\u0016\u0010\u0013\u001a\u00020\b8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/ec/hybrid/data/ECHybridRequestSchedulerTransformConfig;", "Ljava/io/Serializable;", "()V", "prepareEnable", "", "getPrepareEnable", "()Z", "singleThreadPriority", "", "getSingleThreadPriority", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "singleThreadUrls", "", "", "getSingleThreadUrls", "()Ljava/util/List;", "threadPoolPriority", "getThreadPoolPriority", "threadPoolSize", "getThreadPoolSize", "()I", "threadPoolUrls", "getThreadPoolUrls", "ec-hybrid_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECHybridRequestSchedulerTransformConfig implements Serializable {

    @SerializedName("prepare_enable")
    private final boolean prepareEnable;

    @SerializedName("single_thread_priority")
    private final Integer singleThreadPriority;

    @SerializedName("single_thread_urls")
    private final List<String> singleThreadUrls;

    @SerializedName("thread_pool_priority")
    private final Integer threadPoolPriority;

    @SerializedName("thread_pool_size")
    private final int threadPoolSize;

    @SerializedName("thread_pool_urls")
    private final List<String> threadPoolUrls;

    public ECHybridRequestSchedulerTransformConfig() {
        this.prepareEnable = true;
        this.threadPoolSize = 4;
    }

    public final boolean getPrepareEnable() {
        return this.prepareEnable;
    }

    public final Integer getSingleThreadPriority() {
        return this.singleThreadPriority;
    }

    public final List<String> getSingleThreadUrls() {
        return this.singleThreadUrls;
    }

    public final Integer getThreadPoolPriority() {
        return this.threadPoolPriority;
    }

    public final int getThreadPoolSize() {
        return this.threadPoolSize;
    }

    public final List<String> getThreadPoolUrls() {
        return this.threadPoolUrls;
    }
}
