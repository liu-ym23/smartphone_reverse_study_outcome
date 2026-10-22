package com.bytedance.android.gamecp.common.track.monitor;

import android.view.View;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes44.dex */
public final class g implements ViewTreeObserver.OnScrollChangedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f56840a;

    public g(a r100) {
        this.f56840a = r100;
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final void onScrollChanged() {
        WeakReference<View> r100 = this.f56840a.f56812b;
        if (r100 == null) goto L5;
        View r101 = r100.get();
    L6:
        if (r101 != null) goto L8;
        return;
    L8:
        a r102 = this.f56840a;
        if (r102.f56815e == true) goto L11;
        return;
    L11:
        WeakReference<View> r103 = r102.f56812b;
        if (r103 == null) goto L20;
        View r104 = r103.get();
        if (r104 != null) goto L16;
        return;
    L16:
        if (r104.isAttachedToWindow() != true) goto L22;
        this.f56840a.c();
        return;
    L22:
        return;
    L20:
        return;
    L5:
        r101 = null;
        goto L6
    }
}
