package com.bytedance.android.btm.impl.setting;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.lazydata.LazyData;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R&\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006R\u001a\u0010\u0013\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/btm/impl/setting/j;", "", "", "switch", "I", "e", "()I", "", "Lcom/bytedance/android/btm/impl/setting/i;", "standard", "Ljava/util/Map;", "d", "()Ljava/util/Map;", "default", "Lcom/bytedance/android/btm/impl/setting/i;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/btm/impl/setting/i;", "enableMinorCodeReportToAppMonitor", "c", "enableAlogUpload", "b", "<init>", "()V", "btm-impl_cnRelease"}, k = 1, mv = {1, 4, 0})
@LazyData
public final class j {

    /* JADX INFO: renamed from: default, reason: not valid java name */
    @SerializedName("default_standard")
    private final i f61default;

    @SerializedName("enable_alog_upload")
    private final int enableAlogUpload;

    @SerializedName("enable_minor_code_report_to_app_monitor")
    private final int enableMinorCodeReportToAppMonitor;

    @SerializedName("config_detail_dict")
    private final Map<Integer, i> standard;

    /* JADX INFO: renamed from: switch, reason: not valid java name */
    @SerializedName("switch")
    private final int f62switch;

    public j() {
        this.standard = MapsKt.emptyMap();
        this.f61default = new i();
        this.enableMinorCodeReportToAppMonitor = 1;
    }

    public final i a() {
        return this.f61default;
    }

    public final int b() {
        return this.enableAlogUpload;
    }

    public final int c() {
        return this.enableMinorCodeReportToAppMonitor;
    }

    public final Map<Integer, i> d() {
        return this.standard;
    }

    public final int e() {
        return this.f62switch;
    }
}
