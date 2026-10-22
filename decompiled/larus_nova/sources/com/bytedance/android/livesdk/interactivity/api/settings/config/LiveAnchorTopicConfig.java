package com.bytedance.android.livesdk.interactivity.api.settings.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\f\u0010\rR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/settings/config/LiveAnchorTopicConfig;", "", "", "enable", "Z", "getEnable", "()Z", "", "showTimes", "I", "getShowTimes", "()I", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveAnchorTopicConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f133755a = null;

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("showTimes")
    private final int showTimes;

    public static final class a {
    }

    static {
        f133755a = LazyKt.lazy(LiveAnchorTopicConfig$Companion$setting$2.INSTANCE);
    }

    public LiveAnchorTopicConfig() {
        this.showTimes = 5;
    }
}
