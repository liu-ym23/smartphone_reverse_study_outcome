package com.bytedance.android.livesdk.config;

import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u00020\u00058\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0016\u0010\t\u001a\u00020\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0016\u0010\n\u001a\u00020\u00058\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\u00058\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/config/MultiTabConfig;", "", "", "preLoadEnableSetting", "Z", "", "preLoadMinScore", FaceService.girlLabel, "preLoadMaxScore", "annieCacheEnableSetting", "annieCacheMinScore", "annieCacheMaxScore", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "vs-base_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MultiTabConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f119743a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f119744b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f119745c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f119746d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f119747e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Lazy f119748f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Lazy f119749g = null;

    @SerializedName("annie_cache_enable")
    private boolean annieCacheEnableSetting;

    @SerializedName("annie_cache_max_score")
    private float annieCacheMaxScore;

    @SerializedName("annie_cache_min_score")
    private float annieCacheMinScore;

    @SerializedName("pre_load_enable")
    private boolean preLoadEnableSetting;

    @SerializedName("pre_load_max_score")
    private float preLoadMaxScore;

    @SerializedName("pre_load_min_score")
    private float preLoadMinScore;

    public static final class a {
        public static final float a() {
            Lazy r100 = MultiTabConfig.f119743a;
            return ((Number) MultiTabConfig.f119744b.getValue()).floatValue();
        }

        public static final MultiTabConfig b() {
            Lazy r100 = MultiTabConfig.f119743a;
            return (MultiTabConfig) MultiTabConfig.f119743a.getValue();
        }

        public static boolean c() {
            return ((Boolean) MultiTabConfig.f119747e.getValue()).booleanValue();
        }

        public static boolean d() {
            return ((Boolean) MultiTabConfig.f119749g.getValue()).booleanValue();
        }

        public a() {
        }
    }

    static {
        new a();
        f119743a = LazyKt.lazy(MultiTabConfig$Companion$multiTabPerformanceScoreConfig$2.INSTANCE);
        f119744b = LazyKt.lazy(MultiTabConfig$Companion$deviceScore$2.INSTANCE);
        f119745c = LazyKt.lazy(MultiTabConfig$Companion$deviceValidPreLoadScore$2.INSTANCE);
        f119746d = LazyKt.lazy(MultiTabConfig$Companion$deviceValidAnnieCacheScore$2.INSTANCE);
        f119747e = LazyKt.lazy(MultiTabConfig$Companion$preLoadEnable$2.INSTANCE);
        f119748f = LazyKt.lazy(MultiTabConfig$Companion$annieCacheEnable$2.INSTANCE);
        f119749g = LazyKt.lazy(MultiTabConfig$Companion$isLowMemoryPerformanceEnable$2.INSTANCE);
    }

    public MultiTabConfig() {
        this.preLoadEnableSetting = true;
        this.preLoadMinScore = 6.0f;
        this.preLoadMaxScore = 100.0f;
        this.annieCacheEnableSetting = true;
        this.annieCacheMaxScore = 100.0f;
    }

    public static final /* synthetic */ boolean a(MultiTabConfig r100) {
        return r100.annieCacheEnableSetting;
    }

    public static final /* synthetic */ float b(MultiTabConfig r100) {
        return r100.annieCacheMaxScore;
    }

    public static final /* synthetic */ float c(MultiTabConfig r100) {
        return r100.annieCacheMinScore;
    }

    public static final /* synthetic */ boolean d(MultiTabConfig r100) {
        return r100.preLoadEnableSetting;
    }

    public static final /* synthetic */ float e(MultiTabConfig r100) {
        return r100.preLoadMaxScore;
    }

    public static final /* synthetic */ float f(MultiTabConfig r100) {
        return r100.preLoadMinScore;
    }
}
