package com.bytedance.android.livesdk.gift.configmodel;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R(\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\b8\u0006X\u0087D¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0012\u001a\u00020\u00118\u0006X\u0087D¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u00118\u0006X\u0087D¢\u0006\f\n\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0017\u0010\u0015¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdk/gift/configmodel/p2;", "", "", "enable", "Z", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Z", "", "", "fuzzyMatch", "Ljava/util/Map;", "c", "()Ljava/util/Map;", "scene", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "", "recommendContinueTime", "J", "d", "()J", "endIntervalTime", "b", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class p2 {

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("end_interval_time")
    private final long endIntervalTime;

    @SerializedName("fuzzy_match")
    private final Map<String, String> fuzzyMatch;

    @SerializedName("recommend_continue_time")
    private final long recommendContinueTime;

    @SerializedName("scene")
    private final String scene;

    public p2() {
        this.fuzzyMatch = new LinkedHashMap();
        this.scene = "";
        this.recommendContinueTime = 86400;
        this.endIntervalTime = 5;
    }

    public final boolean a() {
        return this.enable;
    }

    public final long b() {
        return this.endIntervalTime;
    }

    public final Map<String, String> c() {
        return this.fuzzyMatch;
    }

    public final long d() {
        return this.recommendContinueTime;
    }

    public final String e() {
        return this.scene;
    }
}
