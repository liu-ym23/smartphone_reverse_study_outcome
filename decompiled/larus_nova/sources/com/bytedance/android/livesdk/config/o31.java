package com.bytedance.android.livesdk.config;

import com.bytedance.ee.bear.bitable.fieldedit.BitableFieldEditAnalytic;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\nR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/config/o31;", "", "", BitableFieldEditAnalytic.ProgressFieldEditScene.MAX, "J", "b", "()J", BitableFieldEditAnalytic.ProgressFieldEditScene.MIN, "c", "defaultValue", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class o31 {

    @SerializedName("default")
    private final long defaultValue;

    @SerializedName(BitableFieldEditAnalytic.ProgressFieldEditScene.MAX)
    private final long max;

    @SerializedName(BitableFieldEditAnalytic.ProgressFieldEditScene.MIN)
    private final long min;

    public static final class a {
    }

    static {
    }

    public o31() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof o31) == false) goto L12;
        o31 r101 = (o31) r100;
        if (this.max == r101.max) goto L8;
        return false;
    L8:
        if (this.min == r101.min) goto L10;
        return false;
    L10:
        if (this.defaultValue == r101.defaultValue) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        long r100 = this.max;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.min;
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        long r104 = this.defaultValue;
        return r103 + ((int) (r104 ^ (r104 >>> 32)));
    }

    public final String toString() {
        return "LiveGameImDelayConfig(max=" + this.max + ", min=" + this.min + ", defaultValue=" + this.defaultValue + ")";
    }

    public final long a() {
        return this.defaultValue;
    }

    public final long b() {
        return this.max;
    }

    public final long c() {
        return this.min;
    }

    public o31(int r100) {
        this.max = 10000;
        this.min = 1000;
        this.defaultValue = 7000;
    }
}
