package com.bytedance.android.ec.adapter.api.state;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/ec/adapter/api/state/d;", "", "", "floatWindowType", "I", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()I", "ec-adapter-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class d {

    @SerializedName("float_window_type")
    private final int floatWindowType;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == true) goto L6;
        return false;
    L6:
        if (this.floatWindowType == ((d) r100).floatWindowType) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        return this.floatWindowType;
    }

    public final String toString() {
        return "EcomData(floatWindowType=" + this.floatWindowType + ")";
    }

    public d() {
        this.floatWindowType = 0;
    }

    public final int a() {
        return this.floatWindowType;
    }
}
