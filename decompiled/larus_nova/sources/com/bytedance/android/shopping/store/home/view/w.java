package com.bytedance.android.shopping.store.home.view;

import com.bytedance.android.shopping.store.keva.ECStoreDefaultKevaRepo;
import com.bytedance.keva.Keva;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class w implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MovableFrameLayout f184753a;

    public w(MovableFrameLayout r100) {
        this.f184753a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Lazy r100 = ECStoreDefaultKevaRepo.f185423a;     // Catch: Throwable -> L13
        Intrinsics.checkNotNullParameter("live_icon_translation_x", "key");     // Catch: Throwable -> L13
        Lazy r101 = ECStoreDefaultKevaRepo.f185423a;     // Catch: Throwable -> L13
        float r102 = ((Keva) r101.getValue()).getFloat("live_icon_translation_x", Float.MIN_VALUE);     // Catch: Throwable -> L13
        if (r102 == Float.MIN_VALUE) goto L6;
        this.f184753a.setTranslationX(r102);     // Catch: Throwable -> L13
    L6:
        Intrinsics.checkNotNullParameter("live_icon_translation_y", "key");     // Catch: Throwable -> L13
        float r103 = ((Keva) r101.getValue()).getFloat("live_icon_translation_y", Float.MIN_VALUE);     // Catch: Throwable -> L13
        if (r103 == Float.MIN_VALUE) goto L10;
        this.f184753a.setTranslationY(r103);     // Catch: Throwable -> L13
    L10:
        if (this.f184753a.getNeedAdsorptionEdge() == false) goto L16;
        this.f184753a.b(false);     // Catch: Throwable -> L13
        return;
    L16:
        return;
    L13:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L20;
        throw th;
    }
}
