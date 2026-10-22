package com.bytedance.android.shopping.anchorv4.voavhs.head.view;

import android.view.View;
import android.view.ViewGroup;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;

/* JADX INFO: loaded from: classes13.dex */
public final class k implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AnchorV4SizeView f168946a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f168947b;

    public k(AnchorV4SizeView r100, int r101) {
        this.f168946a = r100;
        this.f168947b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        View r100 = this.f168946a.f168896b;     // Catch: Throwable -> L4
        ViewGroup.LayoutParams r101 = r100.getLayoutParams();     // Catch: Throwable -> L4
        r101.height = (int) (((double) this.f168947b) * 0.2d);     // Catch: Throwable -> L4
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L4
        r100.setLayoutParams(r101);     // Catch: Throwable -> L4
        this.f168946a.f168896b.setVisibility(0);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
