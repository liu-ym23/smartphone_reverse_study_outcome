package com.bytedance.android.livesdk.log.filter;

import com.huawei.hms.framework.common.hianalytics.HianalyticsBaseData;

/* JADX INFO: loaded from: classes10.dex */
public final class k0 extends a<com.bytedance.android.livesdk.user.l> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.bytedance.android.livesdk.user.l f153301c;

    public k0() {
    }

    public final void J(com.bytedance.android.livesdk.user.l r100) {
        if (r100 == null) goto L4;
        String r101 = r100.f158679d;
    L5:
        if (r101 == null) goto L7;
    L11:
        c("source", r101);
        if ("silent_auth_guide".equals(r101) == false) goto L14;
    L19:
        c("is_skip_confirm", "1");
    L20:
        c("is_coupon", "0");
        c(HianalyticsBaseData.SDK_TYPE, "live");
        this.f153301c = r100;
        return;
    L14:
        if ("silent_auth_guide_agreement".equals(r101) == true) goto L19;
        if ("silent_lite_interaction".equals(r101) == true) goto L19;
        c("is_skip_confirm", "0");
        goto L20
    L7:
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L11;
        throw new IllegalArgumentException("login params source cant be null");
    L4:
        r101 = null;
        goto L5
    }

    @Override // com.bytedance.android.livesdk.log.filter.a, com.bytedance.android.livesdk.log.filter.o
    public final /* bridge */ /* synthetic */ void setData(Object r100) {
        J((com.bytedance.android.livesdk.user.l) r100);
    }
}
