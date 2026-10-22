package com.bytedance.android.shopping.store.home.view;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes14.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECShopMarqueeTextView f184698a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function0 f184699b;

    public b(ECShopMarqueeTextView r100, Function0 r101) {
        this.f184698a = r100;
        this.f184699b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ECShopMarqueeTextView r100 = this.f184698a;     // Catch: Throwable -> L8
        r100.f184538t = null;     // Catch: Throwable -> L8
        if (r100.f184535q == false) goto L5;
        return;
    L5:
        if (r100.f184533o == true) goto L15;
        this.f184699b.invoke();     // Catch: Throwable -> L8
        return;
    L15:
        return;
    L8:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L16;
        throw th;
    }
}
