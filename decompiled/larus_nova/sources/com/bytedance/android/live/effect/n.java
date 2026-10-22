package com.bytedance.android.live.effect;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.List;

/* JADX INFO: loaded from: classes45.dex */
public final class n implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ List f68056a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LiveSmallItemBeautyHelper.c f68057b;

    public n(List r100, LiveSmallItemBeautyHelper.c r101) {
        this.f68056a = r100;
        this.f68057b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        List r100 = this.f68056a;     // Catch: Throwable -> L13
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L11;
        this.f68057b.onError();     // Catch: Throwable -> L13
        return;
    L11:
        this.f68057b.onSuccess(this.f68056a);     // Catch: Throwable -> L13
        return;
    L5:
        if (r100.isEmpty() == true) goto L8;
        r101 = false;
    L13:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L19;
        throw th;
    }
}
