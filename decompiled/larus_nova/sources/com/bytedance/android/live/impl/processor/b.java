package com.bytedance.android.live.impl.processor;

import androidx.lifecycle.LiveData;
import com.bytedance.android.live.strategy.api.CombineInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class b extends BaseFactorProcessor {
    @Override // com.bytedance.android.live.impl.processor.BaseFactorProcessor
    public final LiveData f(CombineInfo r100, LiveData r101) {
        Intrinsics.checkNotNullParameter(r100, "info");
        Intrinsics.checkNotNullParameter(r101, "data");
        return r101;
    }

    public b() {
    }
}
