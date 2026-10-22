package com.bytedance.android.livesdk.preview;

import android.animation.ValueAnimator;
import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: classes11.dex */
public final class l implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FeedLivePreviewFragment f156574a;

    public l(FeedLivePreviewFragment r100) {
        this.f156574a = r100;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r100, MotionEvent r101) {
        if (this.f156574a.f156332s.getVisibility() == 0) goto L5;
        return false;
    L5:
        if (r101.getAction() != 1) goto L16;
        final FeedLivePreviewFragment r102 = this.f156574a;
        if (r102.isViewValid() == false) goto L16;
        if (r102.f156335v != 0) goto L12;
        r102.f156335v = r102.f156332s.getMeasuredHeight();
    L12:
        ValueAnimator r103 = r102.f156337x;
        if (r103 == null) goto L15;
        r103.removeAllListeners();
        r102.f156337x.removeAllUpdateListeners();
        r102.f156337x.cancel();
        r102.f156337x = null;
    L15:
        ValueAnimator r104 = ValueAnimator.ofInt(new int[]{r102.f156335v, 0}).setDuration(300);
        r102.f156337x = r104;
        r104.addUpdateListener(new k(r102));
        r102.f156337x.start();
        r102.f156333t.setVisibility(0);
        r102.f156333t.animate().alpha(1.0f).scaleY(1.0f).scaleX(1.0f).setDuration(300).setListener(new n(r102)).start();
    L16:
        return true;
    }
}
