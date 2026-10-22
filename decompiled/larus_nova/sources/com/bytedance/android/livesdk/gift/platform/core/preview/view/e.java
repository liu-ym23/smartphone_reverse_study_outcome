package com.bytedance.android.livesdk.gift.platform.core.preview.view;

import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes9.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f131089a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ UgcGiftPoolDialog f131090b;

    public e(View r100, UgcGiftPoolDialog r101) {
        this.f131089a = r100;
        this.f131090b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        View r100 = this.f131090b.f131011k;     // Catch: Throwable -> L6
        if (r100 == null) goto L9;
        r100.setVisibility(0);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
