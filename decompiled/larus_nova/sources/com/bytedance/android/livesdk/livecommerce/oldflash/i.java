package com.bytedance.android.livesdk.livecommerce.oldflash;

import android.content.Context;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class i extends k {
    public i(String r100) {
        Intrinsics.checkNotNullParameter(r100, "label");
        Intrinsics.checkNotNullParameter("0", "hint");
        super(r100, "0", true);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.oldflash.k
    public final String c(Context r100) {
        if (r100 == null) goto L4;
        String r101 = th.a.h(r100, R.string.ec_live_flash_stock_num_input_hint, new Object[]{Integer.valueOf(this.f149615i)});
    L5:
        if (r101 != null) goto L8;
        return "";
    L8:
        return r101;
    L4:
        r101 = null;
        goto L5
    }
}
