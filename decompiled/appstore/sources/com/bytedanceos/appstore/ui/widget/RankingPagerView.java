package com.bytedanceos.appstore.ui.widget;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import com.bytedanceos.common.ui.widget.RankingHeaderView;
import com.bytedanceos.common.ui.widget.RefreshLoadListView;

/* JADX INFO: loaded from: classes2.dex */
public class RankingPagerView extends RelativeLayout implements Animation.AnimationListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RefreshLoadListView f9529a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ViewGroup f9530b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RankingHeaderView f9531c;

    public RefreshLoadListView getListView() {
        return this.f9529a;
    }

    public ViewGroup getStateView() {
        return this.f9530b;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation r10) {
        RankingHeaderView r11 = this.f9531c;
        if (r11 == null) goto L6;
        r11.onAnimationEnd();
        return;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation r10) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation r10) {
        RankingHeaderView r11 = this.f9531c;
        if (r11 == null) goto L6;
        r11.onAnimationStart();
        return;
    }

    @Override // android.view.View
    public void setOnScrollChangeListener(View.OnScrollChangeListener r10) {
        this.f9529a.setOnScrollChangeListener(r10);
    }
}
