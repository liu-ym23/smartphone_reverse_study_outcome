package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.business.element;

import android.view.View;
import com.bytedance.android.live.core.utils.a1;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes8.dex */
public final class l implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AudienceShareIMElement f116568a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f116569b;

    public l(AudienceShareIMElement r100, int r101) {
        this.f116568a = r100;
        this.f116569b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        View r100 = this.f116568a.f116535i;     // Catch: Throwable -> L9
        if (r100 == null) goto L5;
        r100.setTranslationY(0.0f);     // Catch: Throwable -> L9
    L5:
        View r101 = this.f116568a.f116535i;     // Catch: Throwable -> L9
        if (r101 == null) goto L12;
        a1.k(r101, r101.getHeight() - this.f116569b);     // Catch: Throwable -> L9
        return;
    L12:
        return;
    L9:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L16;
        throw th;
    }
}
