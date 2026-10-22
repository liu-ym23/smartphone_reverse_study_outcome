package com.bytedance.android.livesdk.chatroom.ui.framework.widget;

import android.view.ViewGroup;
import com.bytedance.android.livesdk.chatroom.widget.TapGuideView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes8.dex */
public final class m implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GestureGuideCompositeWidget f113424a;

    public m(GestureGuideCompositeWidget r100) {
        this.f113424a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
    L15:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L23;
        throw th;
    L23:
        return;
    L3:
        if (this.f113424a.isViewValid() == false) goto L18;
        GestureGuideCompositeWidget r100 = this.f113424a;     // Catch: Throwable -> L15
        if (r100.f113116e == null) goto L22;
        ViewGroup r101 = r100.xq();     // Catch: Throwable -> L15
        if (r101 == null) goto L10;
        r101.removeView(this.f113424a.f113116e);     // Catch: Throwable -> L15
    L10:
        TapGuideView r102 = this.f113424a.f113116e;     // Catch: Throwable -> L15
        if (r102 == null) goto L13;
        r102.b();     // Catch: Throwable -> L15
    L13:
        this.f113424a.f113116e = null;     // Catch: Throwable -> L15
        return;
    L22:
        return;
    }
}
