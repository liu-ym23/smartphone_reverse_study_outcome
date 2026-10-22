package com.bytedance.android.shopping.anchorv4.voavhs.head.view;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;

/* JADX INFO: loaded from: classes13.dex */
public final class l implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AnchorV4SizeView f168948a;

    public l(AnchorV4SizeView r100) {
        this.f168948a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SimpleDraweeView r100 = this.f168948a.f168895a;     // Catch: Throwable -> L7
        ViewGroup.LayoutParams r101 = r100.getLayoutParams();     // Catch: Throwable -> L7
        if (r101 == null) goto L6;
        FrameLayout.LayoutParams r102 = (FrameLayout.LayoutParams) r101;     // Catch: Throwable -> L7
        r102.gravity = 16;     // Catch: Throwable -> L7
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L7
        r100.setLayoutParams(r102);     // Catch: Throwable -> L7
        return;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
