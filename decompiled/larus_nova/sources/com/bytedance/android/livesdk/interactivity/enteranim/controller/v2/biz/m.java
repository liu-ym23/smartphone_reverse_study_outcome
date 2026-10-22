package com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0019\u0010\u001aR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\"\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\t\u001a\u0004\b\u0013\u0010\u000bR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/enteranim/controller/v2/biz/m;", "", "", "key", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "", "maxWaitingTime", "Ljava/lang/Long;", "d", "()Ljava/lang/Long;", "", "Lcom/bytedance/android/livesdk/interactivity/enteranim/controller/v2/biz/n;", "subScenes", "Ljava/util/List;", "e", "()Ljava/util/List;", "maxShowTimes", "c", "Lcom/bytedance/android/livesdk/interactivity/enteranim/controller/v2/biz/o;", "frequencyConfig", "Lcom/bytedance/android/livesdk/interactivity/enteranim/controller/v2/biz/o;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/livesdk/interactivity/enteranim/controller/v2/biz/o;", "<init>", "()V", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class m {

    @SerializedName("frequencyConfig")
    private final o frequencyConfig;

    @SerializedName("key")
    private final String key;

    @SerializedName("maxShowTimes")
    private final Long maxShowTimes;

    @SerializedName("maxWaitingTime")
    private final Long maxWaitingTime;

    @SerializedName("subScenes")
    private final List<n> subScenes;

    public m() {
    }

    public final o a() {
        return this.frequencyConfig;
    }

    public final String b() {
        return this.key;
    }

    public final Long c() {
        return this.maxShowTimes;
    }

    public final Long d() {
        return this.maxWaitingTime;
    }

    public final List<n> e() {
        return this.subScenes;
    }
}
