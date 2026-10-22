package com.bytedance.android.livesdk.interactivity.api.settings.config;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001a\u0010\u000e\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000bR\u001a\u0010\u0010\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b\u0010\u0010\t\u001a\u0004\b\u0011\u0010\u000bR\u001a\u0010\u0012\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b\u0012\u0010\t\u001a\u0004\b\u0013\u0010\u000bR\u001a\u0010\u0014\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/settings/config/y0;", "", "", "enable", "Z", "c", "()Z", "", "requestInterval", "I", "f", "()I", "bufferSize", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "invalidTime", "d", "tik", ce.f26391f, "numPerTik", "e", "componentRoomEnable", "b", "<init>", "()V", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class y0 {

    @SerializedName("message_buffer_size")
    private final int bufferSize;

    @SerializedName("component_room_enable")
    private final boolean componentRoomEnable;

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("message_valid_duration")
    private final int invalidTime;

    @SerializedName("message_refresh_max_count")
    private final int numPerTik;

    @SerializedName("request_message_time_interval")
    private final int requestInterval;

    @SerializedName("message_refresh_duration")
    private final int tik;

    public y0() {
        this.enable = true;
        this.requestInterval = 5;
        this.bufferSize = 100;
        this.invalidTime = 900;
        this.tik = 1;
        this.numPerTik = 1;
    }

    public final int a() {
        return this.bufferSize;
    }

    public final boolean b() {
        return this.componentRoomEnable;
    }

    public final boolean c() {
        return this.enable;
    }

    public final int d() {
        return this.invalidTime;
    }

    public final int e() {
        return this.numPerTik;
    }

    public final int f() {
        return this.requestInterval;
    }

    public final int g() {
        return this.tik;
    }
}
