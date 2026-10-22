package com.bytedance.android.live.effect.beauty.body;

import com.bytedance.android.live.effect.LiveSmallItemBeautyHelper;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes45.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveSmallItemBeautyHelper.c f67196a;

    public h(LiveSmallItemBeautyHelper.c r100) {
        this.f67196a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        LiveSmallItemBeautyHelper.c r100 = this.f67196a;     // Catch: Throwable -> L6
        if (r100 == null) goto L9;
        r100.onError();     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
