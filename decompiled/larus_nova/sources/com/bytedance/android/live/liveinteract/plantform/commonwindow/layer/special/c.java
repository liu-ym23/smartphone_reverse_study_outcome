package com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.special;

import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.TextView;

/* JADX INFO: loaded from: classes46.dex */
public final class c implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f75749a;

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        View r100 = this.f75749a.f75743i;
        if (r100 == null) goto L7;
        ViewTreeObserver r101 = r100.getViewTreeObserver();
        if (r101 == null) goto L7;
        r101.removeOnGlobalLayoutListener(this);
    L7:
        View r102 = this.f75749a.f75743i;
        if (r102 == null) goto L15;
        int r103 = r102.getMeasuredWidth();
        com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.dynamicelement.b r104 = this.f75749a.f75745k;
        if (r104 == null) goto L16;
        TextView r105 = r104.f75678k;
        if (r105 == null) goto L17;
        r105.setTranslationY(r103 * (-0.1f));
        return;
    L17:
        return;
    L16:
        return;
    }

    public c(a r100) {
        this.f75749a = r100;
    }
}
