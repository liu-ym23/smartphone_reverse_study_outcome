package com.bytedance.android.shopping.mall.feed.output;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/bytedance/android/shopping/mall/feed/output/ECMallGulListView$registerLifeCycle$1", "Landroidx/lifecycle/LifecycleEventObserver;", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECMallGulListView$registerLifeCycle$1 implements LifecycleEventObserver {
    @Override // androidx.lifecycle.LifecycleEventObserver
    public final void onStateChanged(LifecycleOwner r100, Lifecycle.Event r101) {
        Intrinsics.checkNotNullParameter(r100, "source");
        Intrinsics.checkNotNullParameter(r101, "event");
        int r102 = a.f177188a[r101.ordinal()];
        if (r102 != 1) goto L5;
        int r103 = ECMallGulListView.f177186b;
        throw null;
    L5:
        if (r102 != 2) goto L7;
        int r104 = ECMallGulListView.f177186b;
        throw null;
    L7:
        if (r102 == 3) goto L9;
        return;
    L9:
        throw null;
    }
}
