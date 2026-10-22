package com.bytedance.android.ec.window.base.shop;

import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes44.dex */
public final class m implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f49651a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ WindowTabKitBottomSheetBehavior f49652b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f49653c;

    public m(View r100, WindowTabKitBottomSheetBehavior r101) {
        this.f49651a = r100;
        this.f49652b = r101;
        this.f49653c = 4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        WindowTabKitBottomSheetBehavior r100 = this.f49652b;     // Catch: Throwable -> L4
        View r101 = this.f49651a;     // Catch: Throwable -> L4
        int r102 = this.f49653c;     // Catch: Throwable -> L4
        int r103 = WindowTabKitBottomSheetBehavior.D;     // Catch: Throwable -> L4
        r100.startSettlingAnimation(r101, r102);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
