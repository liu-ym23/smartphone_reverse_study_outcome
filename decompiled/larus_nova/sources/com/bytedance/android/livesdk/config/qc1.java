package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\nR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/config/qc1;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "", "value", "J", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()J", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class qc1 {

    @SerializedName("type")
    private final String type;

    @SerializedName("value")
    private final long value;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof qc1) == false) goto L10;
        qc1 r101 = (qc1) r100;
        if (Intrinsics.areEqual(this.type, r101.type) == true) goto L8;
        return false;
    L8:
        if (this.value == r101.value) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r100 = this.type;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L6:
        long r102 = this.value;
        return (r101 * 31) + ((int) (r102 ^ (r102 >>> 32)));
    L5:
        r101 = 0;
        goto L6
    }

    public final String toString() {
        return "OpenPlatformHighIntentionCondition(type=" + this.type + ", value=" + this.value + ")";
    }

    public qc1() {
        Intrinsics.checkNotNullParameter("", "type");
        this.type = "";
        this.value = 0;
    }

    public final long a() {
        return this.value;
    }

    public final String getType() {
        return this.type;
    }
}
