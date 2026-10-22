package com.bytedance.android.window.shop.widget;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes14.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECWindowTabLayout f190013a;

    public e(ECWindowTabLayout r100) {
        this.f190013a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ECWindowTabLayout r100 = this.f190013a;     // Catch: Throwable -> L4
        ListProtector.add(r100.f189847a, 0, r100.f189850d);     // Catch: Throwable -> L4
        ECWindowTabLayout r101 = this.f190013a;     // Catch: Throwable -> L4
        ECWindowTabLayout.a(r101, r101.f189849c);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
