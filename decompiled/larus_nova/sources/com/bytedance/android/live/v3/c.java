package com.bytedance.android.live.v3;

import androidx.lifecycle.LiveData;
import com.bytedance.android.live.strategy.api.CombineInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class c extends BaseFactorProcessorV3 {
    @Override // com.bytedance.android.live.v3.BaseFactorProcessorV3
    public final LiveData f(CombineInfo r100, LiveData r101) {
        Intrinsics.checkNotNullParameter(r100, "info");
        Intrinsics.checkNotNullParameter(r101, "data");
        return r101;
    }

    public c() {
    }
}
