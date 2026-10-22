package com.bytedance.android.live.ktv.common.model.api;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0087\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/ktv/common/model/api/n;", "", "", "isFollow", "Z", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Z", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class n implements vh7.h {

    @SerializedName("is_followed")
    protected boolean isFollow;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof n) == true) goto L6;
        return false;
    L6:
        if (this.isFollow == ((n) r100).isFollow) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        boolean r100 = this.isFollow;
        if (r100 == false) goto L6;
        return 1;
    L6:
        return r100 ? 1 : 0;
    }

    public final String toString() {
        return "GetUserFollowRelationResponse(isFollow=" + this.isFollow + ")";
    }

    public n() {
        this.isFollow = false;
    }

    public final boolean a() {
        return this.isFollow;
    }

    public n(am3.g r100) {
        long r101 = r100.c();
        boolean r102 = false;
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L8;
        if (r103 != 1) goto L6;
        this.isFollow = am3.h.a(r100);
        r102 = r102 | true;
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L8:
        r100.d(r101);
        if ((r102 & true) == true) goto L18;
        this.isFollow = false;
        return;
    }
}
