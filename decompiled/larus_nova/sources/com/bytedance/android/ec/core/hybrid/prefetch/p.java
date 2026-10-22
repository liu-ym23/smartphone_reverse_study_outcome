package com.bytedance.android.ec.core.hybrid.prefetch;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/ec/core/hybrid/prefetch/p;", "", "", "safeMode", "Ljava/lang/Integer;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/Integer;", "", "", "whiteList", "Ljava/util/List;", "b", "()Ljava/util/List;", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class p {

    @SerializedName("safe_mode")
    private final Integer safeMode;

    @SerializedName("white_list")
    private final List<String> whiteList;

    public p() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof p) == false) goto L10;
        p r101 = (p) r100;
        if (Intrinsics.areEqual(this.safeMode, r101.safeMode) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.whiteList, r101.whiteList) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        Integer r100 = this.safeMode;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<String> r104 = this.whiteList;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "NativePrefetchSafeSetting(safeMode=" + this.safeMode + ", whiteList=" + this.whiteList + ")";
    }

    public final Integer a() {
        return this.safeMode;
    }

    public final List<String> b() {
        return this.whiteList;
    }

    public p(Object r100) {
        this.safeMode = 1;
        this.whiteList = null;
    }
}
