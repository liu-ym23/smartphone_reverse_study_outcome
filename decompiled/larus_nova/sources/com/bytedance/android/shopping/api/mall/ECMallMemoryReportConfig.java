package com.bytedance.android.shopping.api.mall;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0010$\n\u0002\b\u0011\u0018\u0000 '2\u00020\u0001:\u0001(B\u0007¢\u0006\u0004\b%\u0010&J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002R$\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R*\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R0\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR0\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u001a\u001a\u0004\b \u0010\u001c\"\u0004\b!\u0010\u001eR6\u0010\"\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\t\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u001a\u001a\u0004\b#\u0010\u001c\"\u0004\b$\u0010\u001e¨\u0006)"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/ECMallMemoryReportConfig;", "Ljava/io/Serializable;", "", "scene", "", "isEnabled", "", "reportIntervalOf", "reportStrategyOf", "", "blockTimingListOf", "", "sampleRatio", "Ljava/lang/Float;", "getSampleRatio", "()Ljava/lang/Float;", "setSampleRatio", "(Ljava/lang/Float;)V", "enabledScenes", "Ljava/util/List;", "getEnabledScenes", "()Ljava/util/List;", "setEnabledScenes", "(Ljava/util/List;)V", "", "intervalMap", "Ljava/util/Map;", "getIntervalMap", "()Ljava/util/Map;", "setIntervalMap", "(Ljava/util/Map;)V", "strategyMap", "getStrategyMap", "setStrategyMap", "blockTimingListMap", "getBlockTimingListMap", "setBlockTimingListMap", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECMallMemoryReportConfig implements Serializable {
    public static final a Companion = null;
    public static final int REPORT_STRATEGY_ALL_ASYNC = 2;
    public static final int REPORT_STRATEGY_PART_ASYNC = 1;
    public static final int REPORT_STRATEGY_SYNC = 3;

    @SerializedName("block_timing_list_map")
    private Map<String, ? extends List<String>> blockTimingListMap;

    @SerializedName("enabled_scenes")
    private List<String> enabledScenes;

    @SerializedName("interval_map")
    private Map<String, Integer> intervalMap;

    @SerializedName("sample_ratio")
    private Float sampleRatio;

    @SerializedName("strategy_map")
    private Map<String, Integer> strategyMap;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public ECMallMemoryReportConfig() {
        this.sampleRatio = Float.valueOf(0.0f);
    }

    public final Map<String, List<String>> getBlockTimingListMap() {
        return this.blockTimingListMap;
    }

    public final List<String> getEnabledScenes() {
        return this.enabledScenes;
    }

    public final Map<String, Integer> getIntervalMap() {
        return this.intervalMap;
    }

    public final Float getSampleRatio() {
        return this.sampleRatio;
    }

    public final Map<String, Integer> getStrategyMap() {
        return this.strategyMap;
    }

    public final List<String> blockTimingListOf(String r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Map<String, ? extends List<String>> r101 = this.blockTimingListMap;
        if (r101 == null) goto L7;
        List<String> r102 = r101.get(r100);
        if (r102 == null) goto L7;
        return r102;
    L7:
        return CollectionsKt.emptyList();
    }

    public final boolean isEnabled(String r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        List<String> r101 = this.enabledScenes;
        if (r101 != null) goto L5;
    L7:
        return false;
    L5:
        if (r101.contains(r100) != true) goto L7;
        return true;
    }

    public final int reportIntervalOf(String r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Map<String, Integer> r101 = this.intervalMap;
        if (r101 == null) goto L7;
        Integer r102 = r101.get(r100);
        if (r102 == null) goto L7;
        return r102.intValue();
    L7:
        return 0;
    }

    public final int reportStrategyOf(String r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Map<String, Integer> r101 = this.strategyMap;
        if (r101 == null) goto L7;
        Integer r102 = r101.get(r100);
        if (r102 == null) goto L7;
        return r102.intValue();
    L7:
        return 1;
    }

    public final void setBlockTimingListMap(Map<String, ? extends List<String>> r100) {
        this.blockTimingListMap = r100;
    }

    public final void setEnabledScenes(List<String> r100) {
        this.enabledScenes = r100;
    }

    public final void setIntervalMap(Map<String, Integer> r100) {
        this.intervalMap = r100;
    }

    public final void setSampleRatio(Float r100) {
        this.sampleRatio = r100;
    }

    public final void setStrategyMap(Map<String, Integer> r100) {
        this.strategyMap = r100;
    }
}
