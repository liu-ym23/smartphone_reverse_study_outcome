package com.obric.aiagent.performance;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.obric.aiagent.platform.depend.ICloudConfig;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.n;
import d.o.o;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: ThresholdPssUploadFilesConfig.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ThresholdPssUploadFilesConfig {
    public static final a Companion = null;
    private static final String TAG = "ThresholdPssUploadFilesConfig";
    private static final String THRESHOLD_UPLOAD_CONFIG_KEY = "obric_performance_threshold_pss_upload_files_config";

    @SerializedName("check_interval_ms")
    private final long checkIntervalMs;

    @SerializedName("enable_meminfo")
    private final boolean enableMemInfo;

    @SerializedName("process_configs")
    private final Map<String, ThresholdItemConfig> processConfigs;

    /* JADX INFO: compiled from: ThresholdPssUploadFilesConfig.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }

        public final ThresholdPssUploadFilesConfig a() {
            Object r0 = "";
            n.a r3 = n.f38560a;     // Catch: Throwable -> L11
            a r4 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L11
            JSONObject r5 = ICloudConfig.Companion.getSettingsConfig(ThresholdPssUploadFilesConfig.THRESHOLD_UPLOAD_CONFIG_KEY);     // Catch: Throwable -> L11
            if (r5 == null) goto L6;
            String r6 = r5.toString();     // Catch: Throwable -> L11
        L7:
            if (r6 != null) goto L9;
            r6 = "";
        L9:
            Object r7 = n.f(r6);     // Catch: Throwable -> L11
        L13:
            Throwable r8 = n.c(r7);
            if (r8 != null) goto L16;
            r0 = r7;
        L17:
            String r1 = (String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.aiagent.plugin");
            if (o.d((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L20;
            n.a r9 = n.f38560a;     // Catch: Throwable -> L26
            a r13 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L26
            ThresholdPssUploadFilesConfig r14 = (ThresholdPssUploadFilesConfig) ZeusTransformUtils.preCheckCast(new Gson().fromJson(r1, ThresholdPssUploadFilesConfig.class), ThresholdPssUploadFilesConfig.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L26
            if (r14 != null) goto L24;
            r14 = new ThresholdPssUploadFilesConfig(false, 0, null, 7, null);     // Catch: Throwable -> L26
        L24:
            Object r15 = n.f(r14);     // Catch: Throwable -> L26
        L28:
            Throwable r2 = n.c(r15);
            if (r2 == null) goto L33;
            ILogDepend.Companion.e(ThresholdPssUploadFilesConfig.TAG, "readThresholdUploadConfig parse config error", r2);
            r15 = new ThresholdPssUploadFilesConfig(false, 0, null, 7, null);
        L33:
            return (ThresholdPssUploadFilesConfig) ZeusTransformUtils.preCheckCast(r15, ThresholdPssUploadFilesConfig.class, "com.obric.aiagent.plugin");
        L26:
            th = move-exception;
            n.a r10 = n.f38560a;
            r15 = n.f(d.o.a(th));
            goto L28
        L20:
            return new ThresholdPssUploadFilesConfig(false, 0, null, 7, null);
        L16:
            ILogDepend.Companion.e(ThresholdPssUploadFilesConfig.TAG, "readThresholdUploadConfig read raw config error", r8);
            goto L17
        L6:
            r6 = null;
        L11:
            th = move-exception;
            n.a r11 = n.f38560a;
            r7 = n.f(d.o.a(th));
            goto L13
        }
    }

    static {
        Companion = new a(null);
    }

    public ThresholdPssUploadFilesConfig() {
        this(false, 0, null, 7, null);
    }

    public static /* synthetic */ ThresholdPssUploadFilesConfig copy$default(ThresholdPssUploadFilesConfig r1, boolean r2, long r3, Map r5, int r6, Object r7) {
        Map<String, ThresholdItemConfig> r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        if ((r6 & 1) == 0) goto L6;
        r2 = r1.enableMemInfo;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = r1.checkIntervalMs;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r8 = r1.processConfigs;
    L12:
        return r1.copy(r2, r3, r8);
    }

    public final boolean component1() {
        return this.enableMemInfo;
    }

    public final long component2() {
        return this.checkIntervalMs;
    }

    public final Map<String, ThresholdItemConfig> component3() {
        return this.processConfigs;
    }

    public final ThresholdPssUploadFilesConfig copy(boolean r2, long r3, Map<String, ThresholdItemConfig> r5) {
        return new ThresholdPssUploadFilesConfig(r2, r3, (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin"));
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, ThresholdPssUploadFilesConfig.class) == true) goto L8;
        return false;
    L8:
        ThresholdPssUploadFilesConfig r10 = (ThresholdPssUploadFilesConfig) ZeusTransformUtils.preCheckCast(r9, ThresholdPssUploadFilesConfig.class, "com.obric.aiagent.plugin");
        if (this.enableMemInfo == r10.enableMemInfo) goto L12;
        return false;
    L12:
        if (this.checkIntervalMs == r10.checkIntervalMs) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.processConfigs, r10.processConfigs) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r0 = ((Boolean.hashCode(this.enableMemInfo) * 31) + Long.hashCode(this.checkIntervalMs)) * 31;
        Map<String, ThresholdItemConfig> r3 = this.processConfigs;
        if (r3 != null) goto L5;
        int r4 = 0;
    L7:
        return r0 + r4;
    L5:
        r4 = r3.hashCode();
        goto L7
    }

    public String toString() {
        return "ThresholdPssUploadFilesConfig(enableMemInfo=" + this.enableMemInfo + ", checkIntervalMs=" + this.checkIntervalMs + ", processConfigs=" + this.processConfigs + ')';
    }

    public ThresholdPssUploadFilesConfig(boolean r3, long r4, Map<String, ThresholdItemConfig> r6) {
        Map<String, ThresholdItemConfig> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.aiagent.plugin");
        this.enableMemInfo = r3;
        this.checkIntervalMs = r4;
        this.processConfigs = r7;
    }

    public final boolean getEnableMemInfo() {
        return this.enableMemInfo;
    }

    public final long getCheckIntervalMs() {
        return this.checkIntervalMs;
    }

    public final Map<String, ThresholdItemConfig> getProcessConfigs() {
        return this.processConfigs;
    }

    public /* synthetic */ ThresholdPssUploadFilesConfig(boolean r2, long r3, Map r5, int r6, h r7) {
        Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        if ((r6 & 1) == 0) goto L6;
        r2 = false;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = 5000;
    L9:
        if ((r6 & 4) == 0) goto L11;
        r8 = (Map) ZeusTransformUtils.preCheckCast(new HashMap(), Map.class, "com.obric.aiagent.plugin");
    L11:
        this(r2, r3, r8);
    }
}
