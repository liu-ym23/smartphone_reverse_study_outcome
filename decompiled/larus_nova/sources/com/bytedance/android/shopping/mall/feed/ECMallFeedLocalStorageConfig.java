package com.bytedance.android.shopping.mall.feed;

import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.dypay.api.DyPayConstant;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0002\b\fB\u0007¢\u0006\u0004\b\n\u0010\u000bR.\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/bytedance/android/shopping/mall/feed/ECMallFeedLocalStorageConfig;", "", "", "", "", "Lcom/bytedance/android/shopping/mall/feed/ECMallFeedLocalStorageConfig$b;", "forbiddenTimeRanges", "Ljava/util/Map;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/Map;", "<init>", "()V", "b", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECMallFeedLocalStorageConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f176831a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f176832b = null;

    @SerializedName("forbidden_time_ranges")
    private final Map<String, List<b>> forbiddenTimeRanges;

    public static final class a {
        public a() {
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/shopping/mall/feed/ECMallFeedLocalStorageConfig$b;", "", "", DyPayConstant.KEY_START_TIME, "J", "getStartTime", "()J", "endTime", "getEndTime", "<init>", "()V", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class b {

        @SerializedName("end_time")
        private final long endTime;

        @SerializedName(ILoadStallMonitor.START_TIME)
        private final long startTime;

        public b() {
            this.startTime = -1;
            this.endTime = -1;
        }

        public final boolean a(long r100) {
            long r101 = this.startTime;
            long r102 = this.endTime;
            if (r101 <= r100) goto L6;
        L8:
            return false;
        L6:
            if (r102 < r100) goto L8;
            return true;
        }
    }

    public ECMallFeedLocalStorageConfig() {
    }

    static {
        f176832b = new a();
        f176831a = LazyKt.lazy(ECMallFeedLocalStorageConfig$Companion$config$2.INSTANCE);
    }

    public final Map<String, List<b>> a() {
        return this.forbiddenTimeRanges;
    }
}
