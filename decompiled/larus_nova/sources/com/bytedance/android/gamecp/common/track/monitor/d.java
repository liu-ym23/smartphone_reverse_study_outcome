package com.bytedance.android.gamecp.common.track.monitor;

import android.view.View;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes44.dex */
public final class d implements ViewTreeObserver.OnDrawListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f56837a;

    public d(a r100) {
        this.f56837a = r100;
    }

    @Override // android.view.ViewTreeObserver.OnDrawListener
    public final void onDraw() {
        WeakReference<View> r100 = this.f56837a.f56812b;
        View r101 = null;
        if (r100 == null) goto L5;
        View r102 = r100.get();
    L6:
        if (r102 != null) goto L9;
        return;
    L9:
        if (this.f56837a.f56815e == true) goto L11;
        return;
    L11:
        long r103 = System.currentTimeMillis();
        a r104 = this.f56837a;
        if ((r103 - r104.f56817g) >= 800) goto L14;
        return;
    L14:
        r104.f56817g = r103;
        WeakReference<View> r105 = r104.f56812b;
        if (r105 == null) goto L17;
        r101 = r105.get();
    L17:
        if (r101 == null) goto L22;
        boolean r106 = r101.isShown();
        a r107 = this.f56837a;
        if (r106 == r107.f56819i) goto L23;
        r107.c();
        this.f56837a.f56819i = r106;
        return;
    L23:
        return;
    L22:
        return;
    L5:
        r102 = null;
        goto L6
    }
}
