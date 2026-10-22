package com.bytedance.android.livesdk.gift.fastgift.di;

import android.content.Context;
import android.util.AttributeSet;
import com.bytedance.android.livesdk.gift.fastgift.FastGiftViewV3;
import com.ss.android.lark.utils.statistics.PerfLog;
import h12.h;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class d implements h {
    public d() {
    }

    @Override // h12.h
    public final FastGiftViewV3 a(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return new FastGiftViewV3(r100, r101, 4, 0);
    }
}
