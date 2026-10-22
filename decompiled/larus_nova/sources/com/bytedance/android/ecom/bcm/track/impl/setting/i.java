package com.bytedance.android.ecom.bcm.track.impl.setting;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R \u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR&\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R&\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011R\u001a\u0010\u0014\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/ecom/bcm/track/impl/setting/i;", "", "", "switch", "I", "e", "()I", "", "", "pathAllowlist", "Ljava/util/List;", "b", "()Ljava/util/List;", "", "prefetchUrlBtmConfig", "Ljava/util/Map;", "c", "()Ljava/util/Map;", "forcedUrlBtmConfig", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "reportNetworkPath", "d", "<init>", "()V", "bcm-track-impl_release"}, k = 1, mv = {1, 4, 0})
public final class i {

    @SerializedName("forced_url_btm_config")
    private final Map<String, String> forcedUrlBtmConfig;

    @SerializedName("path_allowlist")
    private final List<String> pathAllowlist;

    @SerializedName("prefetch_url_btm_config")
    private final Map<String, String> prefetchUrlBtmConfig;

    @SerializedName("report_network_path")
    private final int reportNetworkPath;

    /* JADX INFO: renamed from: switch, reason: not valid java name */
    @SerializedName("switch")
    private final int f69switch;

    public i() {
        this.f69switch = 1;
        this.pathAllowlist = CollectionsKt.listOf(new String[]{"/ecom", "/cart", "/aftersale", "/order", "/supermarket", "/aweme/v1/store", "/aweme/v2/sku", "/aweme/v2/search", "/aweme/v1/general/search", "/aweme/v2/shop", "/aweme/v3/shop", "/aweme/v2/commerce"});
        this.prefetchUrlBtmConfig = MapsKt.emptyMap();
        this.forcedUrlBtmConfig = MapsKt.emptyMap();
    }

    public final Map<String, String> a() {
        return this.forcedUrlBtmConfig;
    }

    public final List<String> b() {
        return this.pathAllowlist;
    }

    public final Map<String, String> c() {
        return this.prefetchUrlBtmConfig;
    }

    public final int d() {
        return this.reportNetworkPath;
    }

    public final int e() {
        return this.f69switch;
    }
}
