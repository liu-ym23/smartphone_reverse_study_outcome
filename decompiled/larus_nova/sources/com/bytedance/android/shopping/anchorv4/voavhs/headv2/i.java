package com.bytedance.android.shopping.anchorv4.voavhs.headv2;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/i;", "", "", "scaling", "Ljava/lang/Float;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/Float;", "", "showNow", "Ljava/lang/Boolean;", "getShowNow", "()Ljava/lang/Boolean;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class i {

    @SerializedName("scaling")
    private final Float scaling;

    @SerializedName("show_now")
    private final Boolean showNow;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof i) == false) goto L10;
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.scaling, r101.scaling) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.showNow, r101.showNow) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        Float r100 = this.scaling;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Boolean r104 = this.showNow;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "HeaderContentStyle(scaling=" + this.scaling + ", showNow=" + this.showNow + ")";
    }

    public i() {
        this.scaling = null;
        this.showNow = null;
    }

    public final Float a() {
        return this.scaling;
    }
}
