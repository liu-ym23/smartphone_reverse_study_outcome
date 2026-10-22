package com.bytedance.android.shopping.store.search.router;

import android.content.Context;
import android.net.Uri;
import bf.c;
import com.bytedance.android.ec.core.utils.n;
import com.bytedance.android.shopping.store.router.hybridpage.setting.HybridPageConfigSetting;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import vj3.b;

/* JADX INFO: loaded from: classes14.dex */
public final class ECShopSearchRouter implements c {
    public ECShopSearchRouter() {
    }

    @Override // bf.c
    public final void a() {
    }

    @Override // bf.c
    public final String b() {
        return "goods/store/search";
    }

    @Override // bf.c
    public final boolean c(final Context r100, final Uri r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "uri");
        if (HybridPageConfigSetting.f185952d == false) goto L5;
        ak3.a.f3998b.b(r100, (b) HybridPageConfigSetting.f185949a.getValue());
    L5:
        n.b(r100, r102, null, new ECShopSearchRouter$open$1(r101, r100), ECShopSearchRouter$open$2.INSTANCE);
        return true;
    }
}
