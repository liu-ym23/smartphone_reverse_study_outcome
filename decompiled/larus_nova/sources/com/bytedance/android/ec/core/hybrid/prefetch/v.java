package com.bytedance.android.ec.core.hybrid.prefetch;

import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.google.gson.annotations.SerializedName;
import com.optimize.statistics.FrescoMonitorConst;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.dypay.api.DyPayConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\"\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/ec/core/hybrid/prefetch/v;", "", "", DyPayConstant.KEY_START_TIME, "Ljava/lang/Long;", "e", "()Ljava/lang/Long;", "endTime", "b", "", "", "preloadImgs", "Ljava/util/List;", "c", "()Ljava/util/List;", "bizTag", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "sceneTag", "d", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class v {

    @SerializedName("biz_tag")
    private final String bizTag;

    @SerializedName("end_time")
    private final Long endTime;

    @SerializedName("preload_imgs")
    private final List<String> preloadImgs;

    @SerializedName(FrescoMonitorConst.SCENE_TAG)
    private final String sceneTag;

    @SerializedName(ILoadStallMonitor.START_TIME)
    private final Long startTime;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof v) == false) goto L16;
        v r101 = (v) r100;
        if (Intrinsics.areEqual(this.startTime, r101.startTime) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.endTime, r101.endTime) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.preloadImgs, r101.preloadImgs) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.bizTag, r101.bizTag) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.sceneTag, r101.sceneTag) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        Long r100 = this.startTime;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Long r104 = this.endTime;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        List<String> r107 = this.preloadImgs;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.bizTag;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.sceneTag;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        return r112 + r101;
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "StaticPreloadConfig(startTime=" + this.startTime + ", endTime=" + this.endTime + ", preloadImgs=" + this.preloadImgs + ", bizTag=" + this.bizTag + ", sceneTag=" + this.sceneTag + ")";
    }

    public v() {
        this.startTime = null;
        this.endTime = null;
        this.preloadImgs = null;
        this.bizTag = null;
        this.sceneTag = null;
    }

    public final String a() {
        return this.bizTag;
    }

    public final Long b() {
        return this.endTime;
    }

    public final List<String> c() {
        return this.preloadImgs;
    }

    public final String d() {
        return this.sceneTag;
    }

    public final Long e() {
        return this.startTime;
    }
}
