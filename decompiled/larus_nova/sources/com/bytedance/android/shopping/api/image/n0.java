package com.bytedance.android.shopping.api.image;

import com.google.gson.annotations.SerializedName;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R.\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/shopping/api/image/n0;", "", "", "Lcom/bytedance/android/shopping/api/image/m0;", "srConfigs", "Ljava/util/List;", "getSrConfigs", "()Ljava/util/List;", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "weakNetEnvLevels", "Ljava/util/HashSet;", "getWeakNetEnvLevels", "()Ljava/util/HashSet;", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class n0 {

    @SerializedName("sr_configs")
    private final List<m0> srConfigs;

    @SerializedName("weak_net_env_levels")
    private final HashSet<Integer> weakNetEnvLevels;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof n0) == false) goto L10;
        n0 r101 = (n0) r100;
        if (Intrinsics.areEqual(this.srConfigs, r101.srConfigs) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.weakNetEnvLevels, r101.weakNetEnvLevels) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        List<m0> r100 = this.srConfigs;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        HashSet<Integer> r104 = this.weakNetEnvLevels;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "SRModel(srConfigs=" + this.srConfigs + ", weakNetEnvLevels=" + this.weakNetEnvLevels + ")";
    }

    public n0() {
        this.srConfigs = null;
        this.weakNetEnvLevels = null;
    }
}
