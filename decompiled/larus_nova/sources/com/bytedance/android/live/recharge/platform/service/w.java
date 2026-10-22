package com.bytedance.android.live.recharge.platform.service;

/* JADX INFO: loaded from: classes47.dex */
public final class w implements com.bytedance.android.live.wallet.e.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PayService f90333a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PayService.a f90334b;

    @Override // com.bytedance.android.live.wallet.e.b
    public final void a(com.bytedance.android.live.wallet.e.c r100) {
        PayService.a r101 = this.f90334b;
        this.f90333a.getClass();
        String r102 = r100.f102671b;
        if (r102 != null) goto L5;
        r102 = "";
    L5:
        Integer r103 = Integer.valueOf(r100.f102670a);
        PayService.b.a r104 = null;
        if (r103 == null) goto L15;
        if (r103.intValue() != 1) goto L15;
        com.bytedance.android.live.wallet.e.a r105 = r100.f102674e;
        if (r105 == null) goto L13;
        r104 = PayService.c(r105);
    L13:
        PayService.b r106 = new PayService.b(1, r102, r104, r100.f102673d);
    L40:
        r101.a(r106);
        return;
    L15:
        if (r103 != null) goto L18;
    L23:
        if (r103 != null) goto L26;
    L31:
        if (r103 != null) goto L34;
    L39:
        r106 = new PayService.b(-1, "", null, false);
        goto L40
    L34:
        if (r103.intValue() != 6) goto L39;
        com.bytedance.android.live.wallet.e.a r107 = r100.f102674e;
        if (r107 == null) goto L38;
        r104 = PayService.c(r107);
    L38:
        r106 = new PayService.b(6, r102, r104, false);
        goto L40
    L26:
        if (r103.intValue() != 3) goto L31;
        com.bytedance.android.live.wallet.e.a r108 = r100.f102674e;
        if (r108 == null) goto L30;
        r104 = PayService.c(r108);
    L30:
        r106 = new PayService.b(3, r102, r104, false);
        goto L40
    L18:
        if (r103.intValue() != 2) goto L23;
        com.bytedance.android.live.wallet.e.a r109 = r100.f102674e;
        if (r109 == null) goto L22;
        r104 = PayService.c(r109);
    L22:
        r106 = new PayService.b(2, r102, r104, false);
        goto L40
    }

    @Override // com.bytedance.android.live.wallet.e.b
    public final void b(int r100) {
        PayService.a r101 = this.f90334b;
        this.f90333a.getClass();
        if (r100 != 1) goto L5;
        PayService.PayProgress r102 = PayService.PayProgress.QUERY_ORDER;
    L9:
        r101.b(r102);
        return;
    L5:
        if (r100 == 2) goto L7;
        r102 = PayService.PayProgress.UNKNOWN;
        goto L9
    L7:
        r102 = PayService.PayProgress.SHOW_CASHIER;
        goto L9
    }

    public w(PayService r100, com.bytedance.android.live.recharge.utils.h r101) {
        this.f90333a = r100;
        this.f90334b = r101;
    }
}
