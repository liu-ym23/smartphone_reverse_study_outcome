package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b,\u0010-R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u000b\u001a\u0004\b\u0018\u0010\r\"\u0004\b\u0019\u0010\u000fR(\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R(\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u001d\u001a\u0004\b#\u0010\u001f\"\u0004\b$\u0010!R\"\u0010&\u001a\u00020%8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+¨\u0006."}, d2 = {"Lcom/bytedance/android/livesdk/config/de1;", "", "", "maxCpuRate", "D", "d", "()D", "setMaxCpuRate", "(D)V", "", "minFPS", FaceService.girlLabel, com.amap.api.col.s.ce.f26391f, "()F", "setMinFPS", "(F)V", "", "maxMemory", "J", "f", "()J", "setMaxMemory", "(J)V", "maxGPUUsage", "e", "setMaxGPUUsage", "", "", "anchorList", "Ljava/util/Set;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/Set;", "setAnchorList", "(Ljava/util/Set;)V", "audienceUIDList", "c", "setAudienceUIDList", "", "atLeastSecond", "I", "b", "()I", "setAtLeastSecond", "(I)V", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class de1 {

    @SerializedName("anchor_uid_list")
    private Set<String> anchorList;

    @SerializedName("at_least_time")
    private int atLeastSecond;

    @SerializedName("audience_uid_list")
    private Set<String> audienceUIDList;

    @SerializedName("cpu_rate")
    private double maxCpuRate;

    @SerializedName(IPerformanceManager.GPU.gpu_usage)
    private float maxGPUUsage;

    @SerializedName("pss_app_usage")
    private long maxMemory;

    @SerializedName("avg_fps")
    private float minFPS;

    public de1() {
        this.anchorList = SetsKt.emptySet();
        this.audienceUIDList = SetsKt.emptySet();
    }

    public final Set<String> a() {
        return this.anchorList;
    }

    public final int b() {
        return this.atLeastSecond;
    }

    public final Set<String> c() {
        return this.audienceUIDList;
    }

    public final double d() {
        return this.maxCpuRate;
    }

    public final float e() {
        return this.maxGPUUsage;
    }

    public final long f() {
        return this.maxMemory;
    }

    public final float g() {
        return this.minFPS;
    }
}
