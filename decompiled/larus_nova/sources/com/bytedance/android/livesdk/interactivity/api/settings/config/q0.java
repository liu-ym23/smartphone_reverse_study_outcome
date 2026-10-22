package com.bytedance.android.livesdk.interactivity.api.settings.config;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b$\u0010%R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0011\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006\"\u0004\b\u0013\u0010\bR*\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\f\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R\"\u0010\u0018\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\u001e\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0019\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001dR\"\u0010!\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\u0019\u001a\u0004\b\"\u0010\u001b\"\u0004\b#\u0010\u001d¨\u0006&"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/settings/config/q0;", "", "", "enableAudience", "Z", "f", "()Z", "setEnableAudience", "(Z)V", "", "", "audienceSupportTypeList", "Ljava/util/List;", "b", "()Ljava/util/List;", "setAudienceSupportTypeList", "(Ljava/util/List;)V", "enableAnchor", "e", "setEnableAnchor", "anchorSupportTypeList", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setAnchorSupportTypeList", "", "cacheCnt", "I", "c", "()I", "setCacheCnt", "(I)V", "cacheTime", "d", "setCacheTime", "squareCacheTime", ce.f26391f, "setSquareCacheTime", "<init>", "()V", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class q0 {

    @SerializedName("anchor_support_type_list")
    private List<String> anchorSupportTypeList;

    @SerializedName("audience_support_type_list")
    private List<String> audienceSupportTypeList;

    @SerializedName("cache_cnt")
    private int cacheCnt;

    @SerializedName("cache_time")
    private int cacheTime;

    @SerializedName("enable_anchor")
    private boolean enableAnchor;

    @SerializedName("enable_audience")
    private boolean enableAudience;

    @SerializedName("square_cache_time")
    private int squareCacheTime;

    public q0() {
        this.audienceSupportTypeList = new ArrayList();
        this.anchorSupportTypeList = new ArrayList();
        this.cacheCnt = 50;
        this.cacheTime = 300;
        this.squareCacheTime = 60;
    }

    public final List<String> a() {
        return this.anchorSupportTypeList;
    }

    public final List<String> b() {
        return this.audienceSupportTypeList;
    }

    public final int c() {
        return this.cacheCnt;
    }

    public final int d() {
        return this.cacheTime;
    }

    public final boolean e() {
        return this.enableAnchor;
    }

    public final boolean f() {
        return this.enableAudience;
    }

    public final int g() {
        return this.squareCacheTime;
    }
}
