package com.bytedance.android.shopping.prepurchase.business.pdp.components;

import android.view.View;
import com.bytedance.android.shopping.prepurchase.business.pdp.repository.PdpDataStore;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BottomSheetBehavior<View> f181094a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f181095b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f181096c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f181097d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.bytedance.android.shopping.prepurchase.arch.container.c<com.bytedance.android.shopping.prepurchase.business.pdp.e, PdpDataStore> f181098e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final vg3.u f181099f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.e f181100g;

    public e(com.bytedance.android.shopping.prepurchase.arch.container.c<com.bytedance.android.shopping.prepurchase.business.pdp.e, PdpDataStore> r100, vg3.u r101, com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.e r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "containerAbility");
        Intrinsics.checkNotNullParameter(r102, "lifecycleOwner");
        this.f181098e = r100;
        this.f181099f = r101;
        this.f181100g = r102;
        this.f181097d = -1;
    }
}
