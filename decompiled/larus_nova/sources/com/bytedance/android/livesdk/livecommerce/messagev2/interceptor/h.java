package com.bytedance.android.livesdk.livecommerce.messagev2.interceptor;

import com.bytedance.android.livesdk.livecommerce.model.ECV2CouponInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class h extends a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public com.bytedance.android.livesdk.livecommerce.room.api.c f149432e;

    public h() {
        super(false);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.messagev2.interceptor.a
    public final boolean c(sg2.a r110) {
        Intrinsics.checkNotNullParameter(r110, "message");
        if ((r110 instanceof si2.z) == true) goto L5;
        return false;
    L5:
        si2.z r111 = (si2.z) r110;
        int r100 = r111.msgType;
        if (r100 != 2) goto L8;
    L11:
        ECV2CouponInfo r112 = r111.couponInfo;
        com.bytedance.android.livesdk.livecommerce.room.api.c r101 = this.f149432e;
        if (r101 == null) goto L26;
        long r102 = 0;
        if (r112 == null) goto L16;
        long r103 = r112.serverTime;
    L17:
        if (r112 == null) goto L19;
        String r104 = r112.activity;
    L20:
        if (r112 == null) goto L22;
        int r105 = r112.couponType;
    L23:
        if (r112 == null) goto L25;
        r102 = r112.metaId;
    L25:
        r101.onCouponMessage(r100, r103, r104, r105, r102);
        goto L26
    L22:
        r105 = 0;
        goto L23
    L19:
        r104 = null;
        goto L20
    L16:
        r103 = 0;
    L26:
        return false;
    L8:
        if (r100 == 1) goto L11;
        if (r100 != 3) goto L26;
        goto L11
    }

    @Override // com.bytedance.android.livesdk.livecommerce.messagev2.interceptor.a
    public final void e(String r100, boolean r101) {
        this.f149432e = (com.bytedance.android.livesdk.livecommerce.room.api.c) b(com.bytedance.android.livesdk.livecommerce.room.api.c.class, null);
    }
}
