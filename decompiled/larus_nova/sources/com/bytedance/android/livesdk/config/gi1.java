package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0004\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/config/gi1;", "", "", "messageType", "Ljava/lang/Number;", "b", "()Ljava/lang/Number;", "expire", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class gi1 {

    @SerializedName("expire")
    private final Number expire;

    @SerializedName("message_type")
    private final Number messageType;

    public gi1() {
        Intrinsics.checkNotNullParameter(-1, "messageType");
        Intrinsics.checkNotNullParameter(-1, "expire");
        this.messageType = -1;
        this.expire = -1;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof gi1) == false) goto L10;
        gi1 r101 = (gi1) r100;
        if (Intrinsics.areEqual(this.messageType, r101.messageType) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.expire, r101.expire) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        Number r100 = this.messageType;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Number r104 = this.expire;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ToolbarTipConfig(messageType=" + this.messageType + ", expire=" + this.expire + ")";
    }

    public final Number a() {
        return this.expire;
    }

    public final Number b() {
        return this.messageType;
    }
}
