package com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.slice;

import androidx.fragment.app.FragmentManager;
import com.bytedance.android.shopping.slice.SlcScaleProvider;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public abstract class b implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.shopping.prepurchase.arch.container.c<?, ?> f180954a;

    @Override // com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.slice.k
    public final a f8() {
        return new a(this);
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.slice.k
    public final FragmentManager getFragmentManager() {
        return this.f180954a.getContainerAbility().g7();
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.slice.k
    public final SlcScaleProvider l8() {
        return new SlcScaleProvider();
    }

    public b(com.bytedance.android.shopping.prepurchase.arch.container.c<?, ?> r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f180954a = r100;
    }
}
