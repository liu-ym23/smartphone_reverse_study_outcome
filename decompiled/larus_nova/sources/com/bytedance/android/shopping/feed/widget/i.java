package com.bytedance.android.shopping.feed.widget;

import android.app.Activity;
import android.view.View;
import com.bytedance.android.ec.opt.asyncInflate.ICachedAsyncInflater;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class i implements ICachedAsyncInflater.b {
    public i() {
    }

    @Override // com.bytedance.android.ec.opt.asyncInflate.ICachedAsyncInflater.b
    public final View a(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        return new InFlowPriceViewV0(r100, null, 6, 0);
    }
}
