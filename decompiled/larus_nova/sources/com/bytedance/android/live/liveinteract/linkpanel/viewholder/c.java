package com.bytedance.android.live.liveinteract.linkpanel.viewholder;

import android.view.ViewTreeObserver;
import androidx.constraintlayout.widget.ConstraintSet;
import com.bytedance.android.live.core.utils.s1;

/* JADX INFO: loaded from: classes46.dex */
public final class c implements ViewTreeObserver.OnPreDrawListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SimpleGuestApplyViewHolder f75182a;

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        this.f75182a.f75152e.getViewTreeObserver().removeOnPreDrawListener(this);
        int r100 = s1.f(162.0f);
        if (this.f75182a.f75152e.getWidth() < r100) goto L10;
        SimpleGuestApplyViewHolder r101 = this.f75182a;
        int r102 = r100 - r101.f75150c.getWidth();
        r101.getClass();
        ConstraintSet r103 = new ConstraintSet();
        r103.clone(r101.f75152e);
        if (r101.f75153f.getWidth() <= r102) goto L7;
        r103.constrainWidth(r101.f75153f.getId(), r102);
    L7:
        r103.applyTo(r101.f75152e);
        this.f75182a.f75154g.setVisibility(0);
        return true;
    L10:
        return true;
    }

    public c(SimpleGuestApplyViewHolder r100) {
        this.f75182a = r100;
    }
}
