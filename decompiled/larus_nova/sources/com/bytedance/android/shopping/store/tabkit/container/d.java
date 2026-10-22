package com.bytedance.android.shopping.store.tabkit.container;

import android.content.Context;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class d {
    static {
    }

    public static void a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r101 = com.bytedance.android.ec.store.utils.h.f48668a;
        if (hk3.e.a() == 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L9;
        ShoppingAsyncInflater.a r103 = ShoppingAsyncInflater.f45268e;
        Context r104 = th.a.e(r100, true);
        r103.getClass();
        com.bytedance.android.ec.opt.asyncInflate.d r105 = ShoppingAsyncInflater.a.a(r104).a();
        r105.c(R.layout.ec_tabkit_tab_item_view, 7, "ec_tabkit_tab_layout_item");
        r105.c(R.layout.ec_tabkit_fragment_h5, 1, "ec_tabkit_fragment_h5");
        r105.commit();
        return;
    L9:
        return;
    L5:
        r102 = false;
        goto L6
    }
}
