package com.bytedance.android.livesdk.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0019\u0010\u001aR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR6\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/livesdk/model/i;", "", "", "enableRetry", "Z", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Z", "setEnableRetry", "(Z)V", "Ljava/util/ArrayList;", "Lcom/bytedance/android/livesdk/model/s0;", "Lkotlin/collections/ArrayList;", "urls", "Ljava/util/ArrayList;", "c", "()Ljava/util/ArrayList;", "setUrls", "(Ljava/util/ArrayList;)V", "Lcom/bytedance/android/livesdk/model/q;", "feedRetryConfig", "Lcom/bytedance/android/livesdk/model/q;", "b", "()Lcom/bytedance/android/livesdk/model/q;", "setFeedRetryConfig", "(Lcom/bytedance/android/livesdk/model/q;)V", "<init>", "()V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class i {

    @SerializedName("enable_retry")
    private boolean enableRetry;

    @SerializedName("feed_retry_config")
    private q feedRetryConfig;

    @SerializedName("urls")
    private ArrayList<s0> urls;

    public i() {
    }

    public final boolean a() {
        return this.enableRetry;
    }

    public final q b() {
        return this.feedRetryConfig;
    }

    public final ArrayList<s0> c() {
        return this.urls;
    }
}
