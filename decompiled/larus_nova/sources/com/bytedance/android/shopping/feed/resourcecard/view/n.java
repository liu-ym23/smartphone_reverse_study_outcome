package com.bytedance.android.shopping.feed.resourcecard.view;

import android.app.Activity;
import android.view.View;
import com.bytedance.android.ec.opt.asyncInflate.ICachedAsyncInflater;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class n implements ICachedAsyncInflater.b {
    public n() {
    }

    @Override // com.bytedance.android.ec.opt.asyncInflate.ICachedAsyncInflater.b
    public final View a(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        return new WindowNodeView(r100, null, 6, 0);
    }
}
