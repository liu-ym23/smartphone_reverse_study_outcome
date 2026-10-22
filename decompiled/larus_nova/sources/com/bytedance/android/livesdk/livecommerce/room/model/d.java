package com.bytedance.android.livesdk.livecommerce.room.model;

import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.utils.BtmUtilsKt;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R(\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/room/model/d;", "", "", "btm", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "", "bcm", "Ljava/util/Map;", "getBcm", "()Ljava/util/Map;", "containerId", "getContainerId", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class d {

    @SerializedName("bcm")
    private final Map<String, Object> bcm;

    @SerializedName("btm")
    private final String btm;

    @SerializedName("container_id")
    private final String containerId;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L12;
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.btm, r101.btm) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.bcm, r101.bcm) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.containerId, r101.containerId) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r100 = this.btm;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Map<String, Object> r104 = this.bcm;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.containerId;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "HybridBtmModel(btm=" + this.btm + ", bcm=" + this.bcm + ", containerId=" + this.containerId + ")";
    }

    public d() {
        this.btm = null;
        this.bcm = null;
        this.containerId = null;
    }

    public final String a() {
        return this.btm;
    }

    public final void b(PageFinder r100) {
        Intrinsics.checkNotNullParameter(r100, "defaultPageFinder");
        if (this.containerId == null) goto L6;
        com.bytedance.android.ec.sdk.helper.d.f48119b.getECLynxHostService();
        return;
    }

    public final com.bytedance.android.btm.api.model.d c(PageFinder r100) {
        Intrinsics.checkNotNullParameter(r100, "defaultPageFinder");
        String r101 = this.btm;
        BcmParams.a r102 = BcmParams.Companion;
        Map<String, Object> r103 = this.bcm;
        r102.getClass();
        BcmParams r104 = BcmParams.a.c(r103);
        b(r100);
        return BtmUtilsKt.d(r101, r104, r100);
    }
}
