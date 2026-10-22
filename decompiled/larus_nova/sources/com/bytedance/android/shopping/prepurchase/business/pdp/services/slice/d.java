package com.bytedance.android.shopping.prepurchase.business.pdp.services.slice;

import android.content.Context;
import android.view.View;
import com.bytedance.android.shopping.anchorv4.helper.PdpIndexActionHelper;
import com.bytedance.android.shopping.anchorv4.helper.PdpSliceLocalCacheHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import vg3.x;

/* JADX INFO: loaded from: classes13.dex */
public final class d implements j73.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PdpDynamicFeatureService f182172a;

    @Override // j73.f
    public final PdpSliceLocalCacheHelper M() {
        x r100 = (x) this.f182172a.N1(x.class);
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.M();
    }

    public d(PdpDynamicFeatureService r100) {
        this.f182172a = r100;
    }

    @Override // j73.f
    public final void R(List<String> r100, Context r101) {
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        ((p73.e) this.f182172a.f182148t.getValue()).b(r100, r101);
    }

    @Override // j73.f
    public final boolean t0(String r100, String r101, View r102, com.bytedance.android.ecom.arch.slice.g r103) {
        Intrinsics.checkNotNullParameter(r100, "indexName");
        Intrinsics.checkNotNullParameter(r101, "indexType");
        return ((PdpIndexActionHelper) this.f182172a.f182149u.getValue()).a(r100, r101, r102, r103);
    }
}
