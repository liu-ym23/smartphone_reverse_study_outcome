package com.bytedance.android.live.effect.beauty.body;

import com.bytedance.android.live.effect.LiveSmallItemBeautyHelper;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.List;

/* JADX INFO: loaded from: classes45.dex */
public final class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ List f67197a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LiveSmallItemBeautyHelper.c f67198b;

    public i(List r100, LiveSmallItemBeautyHelper.c r101) {
        this.f67197a = r100;
        this.f67198b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        LiveSmallItemBeautyHelper.c r100 = this.f67198b;     // Catch: Throwable -> L6
        if (r100 == null) goto L9;
        r100.onSuccess(this.f67197a);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
