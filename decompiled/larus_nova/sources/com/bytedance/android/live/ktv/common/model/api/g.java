package com.bytedance.android.live.ktv.common.model.api;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/ktv/common/model/api/g;", "", "Lcom/bytedance/android/live/ktv/common/model/api/g0;", "config", "Lcom/bytedance/android/live/ktv/common/model/api/g0;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/live/ktv/common/model/api/g0;", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class g {

    @SerializedName("ktv_midi_config")
    private final g0 config;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof g) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.config, ((g) r100).config) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        g0 r100 = this.config;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "GetMidiConfigResponse(config=" + this.config + ")";
    }

    public g() {
        this.config = null;
    }

    public final g0 a() {
        return this.config;
    }
}
