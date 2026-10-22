package com.bytedance.android.ec.hybrid.data.entity;

import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010%\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001e\u0010A\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0004\u0018\u00010<2\b\u0010B\u001a\u0004\u0018\u00010\u0010R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\u0015\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR \u0010\u0018\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR \u0010\u001e\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0012\"\u0004\b \u0010\u0014R&\u0010!\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\"8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R&\u0010(\u001a\n\u0012\u0004\u0012\u00020)\u0018\u00010\"8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010%\"\u0004\b+\u0010'R!\u0010,\u001a\b\u0012\u0004\u0012\u00020.0-8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b/\u0010%R \u00102\u001a\u0004\u0018\u0001038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R&\u00108\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010\"8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010%\"\u0004\b:\u0010'R(\u0010;\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0004\u0018\u00010<X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@¨\u0006C"}, d2 = {"Lcom/bytedance/android/ec/hybrid/data/entity/ECHybridConfigDTO;", "Ljava/io/Serializable;", "()V", "OS_ANDROID", "", "getOS_ANDROID", "()I", "OS_IOS", "getOS_IOS", "apiConfig", "Lcom/bytedance/android/ec/hybrid/data/entity/ECHybridApiConfigDTO;", "getApiConfig", "()Lcom/bytedance/android/ec/hybrid/data/entity/ECHybridApiConfigDTO;", "setApiConfig", "(Lcom/bytedance/android/ec/hybrid/data/entity/ECHybridApiConfigDTO;)V", "bundleVersion", "", "getBundleVersion", "()Ljava/lang/String;", "setBundleVersion", "(Ljava/lang/String;)V", "categoryApiConfig", "getCategoryApiConfig", "setCategoryApiConfig", "experimentConfig", "Lcom/bytedance/android/ec/hybrid/data/entity/ECExperimentConfigDTO;", "getExperimentConfig", "()Lcom/bytedance/android/ec/hybrid/data/entity/ECExperimentConfigDTO;", "setExperimentConfig", "(Lcom/bytedance/android/ec/hybrid/data/entity/ECExperimentConfigDTO;)V", "minSupportAppVersion", "getMinSupportAppVersion", "setMinSupportAppVersion", "nativeTemplates", "", "Lcom/bytedance/android/ec/hybrid/data/entity/NativeTemplateItem;", "getNativeTemplates", "()Ljava/util/List;", "setNativeTemplates", "(Ljava/util/List;)V", "prefetchImages", "Lcom/bytedance/android/ec/hybrid/data/entity/ECImageDTO;", "getPrefetchImages", "setPrefetchImages", "preloadExtraList", "", "Lcom/bytedance/android/ec/hybrid/data/entity/ECPreloadConfigItemV3;", "getPreloadExtraList", "preloadExtraList$delegate", "Lkotlin/Lazy;", "preloadTemplateConfig", "Lcom/bytedance/android/ec/hybrid/data/entity/ECPreloadConfigDTO;", "getPreloadTemplateConfig", "()Lcom/bytedance/android/ec/hybrid/data/entity/ECPreloadConfigDTO;", "setPreloadTemplateConfig", "(Lcom/bytedance/android/ec/hybrid/data/entity/ECPreloadConfigDTO;)V", "preloadTemplateConfigV3", "getPreloadTemplateConfigV3", "setPreloadTemplateConfigV3", "schemaMap", "", "getSchemaMap", "()Ljava/util/Map;", "setSchemaMap", "(Ljava/util/Map;)V", "getPreloadSchemaMap", "deviceScore", "ec-hybrid_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECHybridConfigDTO implements Serializable {
    private final int OS_ANDROID;
    private final int OS_IOS;

    @SerializedName("api_config")
    private ECHybridApiConfigDTO apiConfig;

    @SerializedName("bundle_version")
    private String bundleVersion;

    @SerializedName("category_api_config")
    private ECHybridApiConfigDTO categoryApiConfig;

    @SerializedName("experiment_config")
    private ECExperimentConfigDTO experimentConfig;

    @SerializedName("min_support_app_version")
    private String minSupportAppVersion;

    @SerializedName("native_templates")
    private List<NativeTemplateItem> nativeTemplates;

    @SerializedName("prefetch_images")
    private List<ECImageDTO> prefetchImages;
    private final Lazy preloadExtraList$delegate;

    @SerializedName("preload_tmp_config_v2")
    private ECPreloadConfigDTO preloadTemplateConfig;

    @SerializedName("preload_tmp_config_v3")
    private List<ECPreloadConfigItemV3> preloadTemplateConfigV3;
    private Map<String, Integer> schemaMap;

    public final List<ECPreloadConfigItemV3> getPreloadExtraList() {
        return (List) this.preloadExtraList$delegate.getValue();
    }

    public ECHybridConfigDTO() {
        this.preloadExtraList$delegate = LazyKt.lazy(ECHybridConfigDTO$preloadExtraList$2.INSTANCE);
        this.OS_ANDROID = 1;
        this.OS_IOS = 2;
    }

    public final ECHybridApiConfigDTO getApiConfig() {
        return this.apiConfig;
    }

    public final String getBundleVersion() {
        return this.bundleVersion;
    }

    public final ECHybridApiConfigDTO getCategoryApiConfig() {
        return this.categoryApiConfig;
    }

    public final ECExperimentConfigDTO getExperimentConfig() {
        return this.experimentConfig;
    }

    public final String getMinSupportAppVersion() {
        return this.minSupportAppVersion;
    }

    public final List<NativeTemplateItem> getNativeTemplates() {
        return this.nativeTemplates;
    }

    public final int getOS_ANDROID() {
        return this.OS_ANDROID;
    }

    public final int getOS_IOS() {
        return this.OS_IOS;
    }

    public final List<ECImageDTO> getPrefetchImages() {
        return this.prefetchImages;
    }

    public final ECPreloadConfigDTO getPreloadTemplateConfig() {
        return this.preloadTemplateConfig;
    }

    public final List<ECPreloadConfigItemV3> getPreloadTemplateConfigV3() {
        return this.preloadTemplateConfigV3;
    }

    public final Map<String, Integer> getSchemaMap() {
        return this.schemaMap;
    }

    public final Map<String, Integer> getPreloadSchemaMap(String r100) {
        Map<String, Integer> r101 = this.schemaMap;
        if (r101 == null) goto L6;
        return r101;
    L6:
        if (r100 == null) goto L16;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L9
        Object r103 = Result.m9449constructorimpl(Double.valueOf(CastDoubleProtector.parseDouble(r100)));     // Catch: Throwable -> L9
    L12:
        if (Result.m9455isFailureimpl(r103) == false) goto L14;
        r103 = null;
    L14:
        Double r104 = (Double) r103;
    L9:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L16:
        if (this.preloadTemplateConfigV3 == null) goto L23;
        this.schemaMap = new LinkedHashMap();
        List<ECPreloadConfigItemV3> r106 = this.preloadTemplateConfigV3;
        Intrinsics.checkNotNull(r106);
        Iterator<T> r107 = r106.iterator();
    L19:
        if (r107.hasNext() == false) goto L22;
        ECPreloadConfigItemV3 r108 = (ECPreloadConfigItemV3) r107.next();
        Map<String, Integer> r109 = this.schemaMap;
        Intrinsics.checkNotNull(r109);
        String r110 = r108.getSchema();
        Intrinsics.checkNotNull(r110);
        Integer r111 = r108.getPreloadNum();
        Intrinsics.checkNotNull(r111);
        r109.put(r110, r111);
        getPreloadExtraList().add(r108);
        goto L19
    L22:
        return this.schemaMap;
    L23:
        ECPreloadConfigDTO r112 = this.preloadTemplateConfig;
        if (r112 == null) goto L29;
        Map<String, Integer> r113 = r112.getAndroidPreloadMap();
        if (r113 == null) goto L29;
        Map<String, Integer> r114 = MapsKt.toMutableMap(r113);
        this.schemaMap = r114;
        return r114;
    L29:
        return null;
    }

    public final void setApiConfig(ECHybridApiConfigDTO r100) {
        this.apiConfig = r100;
    }

    public final void setBundleVersion(String r100) {
        this.bundleVersion = r100;
    }

    public final void setCategoryApiConfig(ECHybridApiConfigDTO r100) {
        this.categoryApiConfig = r100;
    }

    public final void setExperimentConfig(ECExperimentConfigDTO r100) {
        this.experimentConfig = r100;
    }

    public final void setMinSupportAppVersion(String r100) {
        this.minSupportAppVersion = r100;
    }

    public final void setNativeTemplates(List<NativeTemplateItem> r100) {
        this.nativeTemplates = r100;
    }

    public final void setPrefetchImages(List<ECImageDTO> r100) {
        this.prefetchImages = r100;
    }

    public final void setPreloadTemplateConfig(ECPreloadConfigDTO r100) {
        this.preloadTemplateConfig = r100;
    }

    public final void setPreloadTemplateConfigV3(List<ECPreloadConfigItemV3> r100) {
        this.preloadTemplateConfigV3 = r100;
    }

    public final void setSchemaMap(Map<String, Integer> r100) {
        this.schemaMap = r100;
    }
}
