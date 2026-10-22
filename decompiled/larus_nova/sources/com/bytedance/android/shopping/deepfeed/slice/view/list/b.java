package com.bytedance.android.shopping.deepfeed.slice.view.list;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Map;

/* JADX INFO: loaded from: classes13.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DeepFeedSlcList f173588a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Map f173589b;

    public b(DeepFeedSlcList r100, Map r101) {
        this.f173588a = r100;
        this.f173589b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        DeepFeedSlcList r100 = this.f173588a;     // Catch: Throwable -> L6
        int r101 = DeepFeedSlcList.f173558p;     // Catch: Throwable -> L6
        com.bytedance.android.shopping.deepfeed.slice.service.b r102 = r100.w();     // Catch: Throwable -> L6
        if (r102 == null) goto L9;
        r102.M(this.f173589b);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
