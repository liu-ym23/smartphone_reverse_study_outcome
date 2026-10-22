package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R \u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR \u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/config/j6;", "", "", "enable", "Z", "b", "()Z", "", "Lcom/bytedance/android/livesdk/config/n4;", "backendConfigs", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "feedConfigs", "c", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class j6 {

    @SerializedName("backend_configs")
    private final List<n4> backendConfigs;

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("feed_configs")
    private final List<n4> feedConfigs;

    public j6() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof j6) == false) goto L12;
        j6 r101 = (j6) r100;
        if (this.enable == r101.enable) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.backendConfigs, r101.backendConfigs) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.feedConfigs, r101.feedConfigs) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public final int hashCode() {
        boolean r100 = this.enable;
        ?? r101 = r100;
        if (r100 == false) goto L5;
        r101 = 1;
    L5:
        int r102 = r101 * 31;
        List<n4> r103 = this.backendConfigs;
        int r104 = 0;
        if (r103 == null) goto L8;
        int r105 = r103.hashCode();
    L9:
        int r106 = (r102 + r105) * 31;
        List<n4> r107 = this.feedConfigs;
        if (r107 == null) goto L13;
        r104 = r107.hashCode();
    L13:
        return r106 + r104;
    L8:
        r105 = 0;
        goto L9
    }

    public final String toString() {
        return "GameLiveEnterOptimizeConfig(enable=" + this.enable + ", backendConfigs=" + this.backendConfigs + ", feedConfigs=" + this.feedConfigs + ")";
    }

    public final List<n4> a() {
        return this.backendConfigs;
    }

    public final boolean b() {
        return this.enable;
    }

    public final List<n4> c() {
        return this.feedConfigs;
    }

    public j6(Object r100) {
        List<n4> r101 = CollectionsKt.emptyList();
        List<n4> r102 = CollectionsKt.emptyList();
        Intrinsics.checkNotNullParameter(r101, "backendConfigs");
        Intrinsics.checkNotNullParameter(r102, "feedConfigs");
        this.enable = false;
        this.backendConfigs = r101;
        this.feedConfigs = r102;
    }
}
