package com.bytedance.android.ec.window.base.shop;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/ec/window/base/shop/q;", "", "", "level", "Ljava/lang/Integer;", "b", "()Ljava/lang/Integer;", "", "joinStatus", "Z", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Z", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class q {

    @SerializedName("join_status")
    private final boolean joinStatus;

    @SerializedName("level")
    private final Integer level;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof q) == false) goto L10;
        q r101 = (q) r100;
        if (Intrinsics.areEqual(this.level, r101.level) == true) goto L8;
        return false;
    L8:
        if (this.joinStatus == r101.joinStatus) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    public final int hashCode() {
        Integer r100 = this.level;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L6:
        int r102 = r101 * 31;
        boolean r103 = this.joinStatus;
        ?? r104 = r103;
        if (r103 == false) goto L10;
        r104 = 1;
    L10:
        return r102 + r104;
    L5:
        r101 = 0;
        goto L6
    }

    public final String toString() {
        return "WindowUserData(level=" + this.level + ", joinStatus=" + this.joinStatus + ")";
    }

    public q() {
        this.level = null;
        this.joinStatus = false;
    }

    public final boolean a() {
        return this.joinStatus;
    }

    public final Integer b() {
        return this.level;
    }
}
