package com.bytedance.android.shopping.feed.widget;

import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes13.dex */
public final class u implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ProductFeedDividerView f176075a;

    public u(ProductFeedDividerView r100) {
        this.f176075a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f176075a.a(R.id.switch_bubble_container).setVisibility(8);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
