package com.bytedance.android.monitorV2.settings;

import androidx.camera.core.RetryPolicy;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u00002\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b%\u0010&R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R(\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010\u001f\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u000b\u001a\u0004\b \u0010\r\"\u0004\b!\u0010\u000fR(\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u001a\u001a\u0004\b#\u0010\u001c\"\u0004\b$\u0010\u001e¨\u0006'"}, d2 = {"Lcom/bytedance/android/monitorV2/settings/j;", "", "", "useMonitorDetect", "Z", "d", "()Z", "setUseMonitorDetect", "(Z)V", "", "monitorDetectTime", "J", "getMonitorDetectTime", "()J", "setMonitorDetectTime", "(J)V", "", "monitorDetectType", "I", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()I", "setMonitorDetectType", "(I)V", "", "", "urlBlockList", "[Ljava/lang/String;", "c", "()[Ljava/lang/String;", "setUrlBlockList", "([Ljava/lang/String;)V", "stayDuration", "b", "setStayDuration", "urlAppInfoList", "getUrlAppInfoList", "setUrlAppInfoList", "<init>", "()V", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f163227a = null;

    @SerializedName("monitor_detect_time")
    private long monitorDetectTime;

    @SerializedName("detect_type")
    private int monitorDetectType;

    @SerializedName("stay_duration")
    private long stayDuration;

    @SerializedName("url_appinfo_list")
    private String[] urlAppInfoList;

    @SerializedName("url_blocklist")
    private String[] urlBlockList;

    @SerializedName("use_monitor_detect")
    private boolean useMonitorDetect;

    public static final class a {
    }

    static {
        f163227a = new j();
    }

    public j() {
        this.useMonitorDetect = true;
        this.monitorDetectTime = RetryPolicy.DEFAULT_RETRY_TIMEOUT_IN_MILLIS;
        this.urlBlockList = new String[0];
        this.stayDuration = 4000;
        this.urlAppInfoList = new String[0];
    }

    public final int a() {
        return this.monitorDetectType;
    }

    public final long b() {
        return this.stayDuration;
    }

    public final String[] c() {
        return this.urlBlockList;
    }

    public final boolean d() {
        return this.useMonitorDetect;
    }
}
