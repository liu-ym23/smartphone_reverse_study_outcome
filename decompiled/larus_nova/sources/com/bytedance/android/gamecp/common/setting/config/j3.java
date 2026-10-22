package com.bytedance.android.gamecp.common.setting.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/gamecp/common/setting/config/j3;", "", "", "maxRetryCount", "I", "getMaxRetryCount", "()I", "maxCacheCount", "getMaxCacheCount", "<init>", "()V", "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class j3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public JSONObject f56752a;

    @SerializedName("max_cache_count")
    private final int maxCacheCount;

    @SerializedName("max_retry_count")
    private final int maxRetryCount;

    public final JSONObject a() {
        JSONObject r100 = this.f56752a;
        if (r100 == null) goto L11;
        Intrinsics.checkNotNull(r100);
        return r100;
    L11:
        JSONObject r101 = new JSONObject();     // Catch: Exception -> L8
        r101.putOpt("max_retry_count", Integer.valueOf(this.maxRetryCount));     // Catch: Exception -> L8
        r101.putOpt("max_cache_count", Integer.valueOf(this.maxCacheCount));     // Catch: Exception -> L8
        Unit r102 = Unit.INSTANCE;     // Catch: Exception -> L8
    L9:
        this.f56752a = r101;
        Intrinsics.checkNotNull(r101);
        return r101;
    L8:
        r101 = new JSONObject();
        goto L9
    }

    public j3() {
        this.maxRetryCount = 3;
        this.maxCacheCount = 10;
    }
}
