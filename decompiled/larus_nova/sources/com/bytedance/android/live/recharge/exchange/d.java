package com.bytedance.android.live.recharge.exchange;

import android.content.DialogInterface;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.livesdk.utils.r3;
import com.larus.nova.R;
import jw0.h;

/* JADX INFO: loaded from: classes47.dex */
public final class d implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f89794a = null;

    static {
        f89794a = new d();
    }

    public d() {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        com.bytedance.android.live.recharge.util.d.c(true);
        h.b("1");
        int r102 = ToastUtil.f90810a;
        ToastUtil.b(s1.C(R.string.ttlive_cash_exchange_gift_auto_toast, new Object[]{r3.c()}), 0);
        r100.dismiss();
    }
}
