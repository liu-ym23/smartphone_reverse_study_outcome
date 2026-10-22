package com.bytedance.android.ecom.bcm.track.impl.setting;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R&\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00020\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R&\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00020\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010R\u001a\u0010\u0013\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/ecom/bcm/track/impl/setting/n;", "", "", "monitorSizeSwitch", "I", "d", "()I", "removeKeysSwitch", "f", "entranceInfoMaxSize", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "", "", "keysMonitorConfig", "Ljava/util/Map;", "c", "()Ljava/util/Map;", "removeKeysConfig", "e", "keyDefaultMaxSize", "b", "<init>", "()V", "bcm-track-impl_release"}, k = 1, mv = {1, 4, 0})
public final class n {

    @SerializedName("entrance_info_size")
    private final int entranceInfoMaxSize;

    @SerializedName("key_default_max_size")
    private final int keyDefaultMaxSize;

    @SerializedName("tracking_entrance_info_keys")
    private final Map<String, Integer> keysMonitorConfig;

    @SerializedName("monitor_size_switch")
    private final int monitorSizeSwitch;

    @SerializedName("remove_entrance_info_keys")
    private final Map<String, Integer> removeKeysConfig;

    @SerializedName("remove_keys_switch")
    private final int removeKeysSwitch;

    public n() {
        this.keysMonitorConfig = MapsKt.emptyMap();
        this.removeKeysConfig = MapsKt.emptyMap();
    }

    public final int a() {
        return this.entranceInfoMaxSize;
    }

    public final int b() {
        return this.keyDefaultMaxSize;
    }

    public final Map<String, Integer> c() {
        return this.keysMonitorConfig;
    }

    public final int d() {
        return this.monitorSizeSwitch;
    }

    public final Map<String, Integer> e() {
        return this.removeKeysConfig;
    }

    public final int f() {
        return this.removeKeysSwitch;
    }
}
