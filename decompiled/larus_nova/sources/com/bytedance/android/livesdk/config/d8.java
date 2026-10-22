package com.bytedance.android.livesdk.config;

import com.facebook.imagepipeline.producers.DecodeProducer;
import com.google.gson.annotations.SerializedName;
import com.optimize.statistics.FrescoMonitorConst;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b-\u0010.R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0012\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u0018\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\u001f\u001a\u00020\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R0\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020&\u0018\u00010%8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,¨\u0006/"}, d2 = {"Lcom/bytedance/android/livesdk/config/d8;", "", "", "enable", "Z", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Z", "setEnable", "(Z)V", "", "", "sceneBlockList", "Ljava/util/List;", "f", "()Ljava/util/List;", "setSceneBlockList", "(Ljava/util/List;)V", "", "fallbackSchema", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setFallbackSchema", "(Ljava/lang/String;)V", DecodeProducer.EXTRA_IMAGE_QUALITY, "I", "c", "()I", "setImageQuality", "(I)V", "", "minRecogTime", "J", "d", "()J", "setMinRecogTime", "(J)V", "", "Lcom/bytedance/android/livesdk/config/e8;", "scaleConfigMap", "Ljava/util/Map;", "e", "()Ljava/util/Map;", "setScaleConfigMap", "(Ljava/util/Map;)V", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class d8 {

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("fallback_schema")
    private String fallbackSchema;

    @SerializedName(FrescoMonitorConst.IMAGE_QUALITY)
    private int imageQuality;

    @SerializedName("ming_recog_time")
    private long minRecogTime;

    @SerializedName("scale_config_map")
    private Map<Integer, e8> scaleConfigMap;

    @SerializedName("scene_block_list")
    private List<Integer> sceneBlockList;

    public d8() {
        this.sceneBlockList = CollectionsKt.emptyList();
        this.fallbackSchema = "sslocal://webcast_redirect?entry=recognize_fallback";
        this.imageQuality = 30;
        this.minRecogTime = 1000;
        this.scaleConfigMap = new LinkedHashMap();
    }

    public final boolean a() {
        return this.enable;
    }

    public final String b() {
        return this.fallbackSchema;
    }

    public final int c() {
        return this.imageQuality;
    }

    public final long d() {
        return this.minRecogTime;
    }

    public final Map<Integer, e8> e() {
        return this.scaleConfigMap;
    }

    public final List<Integer> f() {
        return this.sceneBlockList;
    }
}
