package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/config/me1;", "", "", "enableLevel", "I", "getEnableLevel", "()I", "", "toast", "Ljava/lang/String;", "getToast", "()Ljava/lang/String;", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class me1 {

    @SerializedName("enable_level")
    private final int enableLevel;

    @SerializedName("toast")
    private final String toast;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof me1) == false) goto L10;
        me1 r101 = (me1) r100;
        if (this.enableLevel == r101.enableLevel) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.toast, r101.toast) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        int r100 = this.enableLevel * 31;
        String r101 = this.toast;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return r100 + r102;
    L5:
        r102 = 0;
        goto L7
    }

    public final String toString() {
        return "PrivilegeBarrageConfig(enableLevel=" + this.enableLevel + ", toast=" + this.toast + ")";
    }

    public me1() {
        Intrinsics.checkNotNullParameter("当前等级不够", "toast");
        this.enableLevel = 42;
        this.toast = "当前等级不够";
    }
}
