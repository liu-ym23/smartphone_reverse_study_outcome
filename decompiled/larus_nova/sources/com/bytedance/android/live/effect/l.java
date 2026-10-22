package com.bytedance.android.live.effect;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.List;

/* JADX INFO: loaded from: classes45.dex */
public final class l implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ List f68050a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LiveSmallItemBeautyHelper.c f68051b;

    public l(List r100, com.bytedance.android.live.effect.beauty.smallitem.g r101) {
        this.f68050a = r100;
        this.f68051b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f68051b.onSuccess(this.f68050a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
