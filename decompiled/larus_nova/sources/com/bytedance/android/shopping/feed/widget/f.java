package com.bytedance.android.shopping.feed.widget;

import android.app.Activity;
import android.view.View;
import com.bytedance.android.ec.opt.asyncInflate.ICachedAsyncInflater;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class f implements ICachedAsyncInflater.b {
    public f() {
    }

    @Override // com.bytedance.android.ec.opt.asyncInflate.ICachedAsyncInflater.b
    public final View a(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        return new GuessULikeProductCardDetailView(r100, null, 6, 0);
    }
}
