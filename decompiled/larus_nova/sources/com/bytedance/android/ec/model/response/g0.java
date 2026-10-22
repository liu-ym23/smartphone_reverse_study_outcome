package com.bytedance.android.ec.model.response;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R(\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/ec/model/response/g0;", "", "", "useNewFeedPath", "Ljava/lang/Boolean;", "b", "()Ljava/lang/Boolean;", "", "", "extraReqParams", "Ljava/util/Map;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/Map;", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class g0 {

    @SerializedName("extra_req_params")
    private final Map<String, Object> extraReqParams;

    @SerializedName("use_new_feed_path")
    private final Boolean useNewFeedPath;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof g0) == false) goto L10;
        g0 r101 = (g0) r100;
        if (Intrinsics.areEqual(this.useNewFeedPath, r101.useNewFeedPath) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.extraReqParams, r101.extraReqParams) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        Boolean r100 = this.useNewFeedPath;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Map<String, Object> r104 = this.extraReqParams;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "InnerFeedInfo(useNewFeedPath=" + this.useNewFeedPath + ", extraReqParams=" + this.extraReqParams + ")";
    }

    public g0() {
        this.useNewFeedPath = null;
        this.extraReqParams = null;
    }

    public final Map<String, Object> a() {
        return this.extraReqParams;
    }

    public final Boolean b() {
        return this.useNewFeedPath;
    }
}
