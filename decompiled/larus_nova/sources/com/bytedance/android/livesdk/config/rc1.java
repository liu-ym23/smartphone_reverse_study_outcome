package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/config/rc1;", "", "", "Lcom/bytedance/android/livesdk/config/qc1;", "conditions", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "Lcom/bytedance/android/livesdk/config/sc1;", "frequencyControl", "Lcom/bytedance/android/livesdk/config/sc1;", "b", "()Lcom/bytedance/android/livesdk/config/sc1;", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class rc1 {

    @SerializedName("conditions")
    private final List<qc1> conditions;

    @SerializedName("frequency_control")
    private final sc1 frequencyControl;

    public rc1() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof rc1) == false) goto L10;
        rc1 r101 = (rc1) r100;
        if (Intrinsics.areEqual(this.conditions, r101.conditions) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.frequencyControl, r101.frequencyControl) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        List<qc1> r100 = this.conditions;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        sc1 r104 = this.frequencyControl;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "OpenPlatformHighIntentionConfig(conditions=" + this.conditions + ", frequencyControl=" + this.frequencyControl + ")";
    }

    public final List<qc1> a() {
        return this.conditions;
    }

    public final sc1 b() {
        return this.frequencyControl;
    }

    public rc1(Object r100) {
        this.conditions = null;
        this.frequencyControl = null;
    }
}
