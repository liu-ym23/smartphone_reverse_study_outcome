package com.bytedance.android.livesdk.feed;

import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;

/* JADX INFO: loaded from: classes8.dex */
public class PerformanceMonitorScrollListener extends RecyclerView.OnScrollListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f123574a;

    public PerformanceMonitorScrollListener() {
        this.f123574a = IPerformanceManager.SCENE_FEED_DRAWER_SLIDE;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrollStateChanged(RecyclerView r100, int r101) {
        if (r101 != 0) goto L4;
        return;
    L4:
        if (jc1.k.f(IPerformanceManager.class) == null) goto L8;
        ((IPerformanceManager) jc1.k.f(IPerformanceManager.class)).monitorPerformance(this.f123574a);
        return;
    }
}
