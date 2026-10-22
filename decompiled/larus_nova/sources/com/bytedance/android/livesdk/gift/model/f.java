package com.bytedance.android.livesdk.gift.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R>\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/f;", "", "", "", "Lcom/bytedance/revenue/platform/api/core/KmpMap;", "extra", "Ljava/util/Map;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/Map;", "setExtra", "(Ljava/util/Map;)V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class f {

    @SerializedName("extra")
    private Map<String, String> extra;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof f) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.extra, ((f) r100).extra) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        Map<String, String> r100 = this.extra;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "BannerGiftInfoExtra(extra=" + this.extra + ")";
    }

    public final Map<String, String> a() {
        return this.extra;
    }
}
