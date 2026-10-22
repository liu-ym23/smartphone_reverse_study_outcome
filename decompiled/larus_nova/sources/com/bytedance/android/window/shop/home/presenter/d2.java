package com.bytedance.android.window.shop.home.presenter;

import android.view.View;
import android.widget.ImageView;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class d2 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECWindowTopInfoBarEnhancedPresenter.d f188512a;

    public d2(ECWindowTopInfoBarEnhancedPresenter.d r100) {
        this.f188512a = r100;
    }

    public final void a() {
        ECWindowTopInfoBarEnhancedPresenter r100 = this.f188512a.f188477a;
        ImageView r101 = r100.f188465q;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("backBtn");
    L5:
        r100.f188472x = ECWindowTopInfoBarEnhancedPresenter.a0(r101);
        ECWindowTopInfoBarEnhancedPresenter r102 = this.f188512a.f188477a;
        r102.f188474z = ECWindowTopInfoBarEnhancedPresenter.a0(r102.b0());
        ECWindowTopInfoBarEnhancedPresenter r103 = this.f188512a.f188477a;
        View r104 = r103.f188464p;
        if (r104 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("windowInfoContainer");
    L8:
        r103.f188473y = ECWindowTopInfoBarEnhancedPresenter.a0(r104);
        this.f188512a.f188477a.c0();
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
