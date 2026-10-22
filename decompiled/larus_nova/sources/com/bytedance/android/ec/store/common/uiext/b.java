package com.bytedance.android.ec.store.common.uiext;

import android.view.View;
import android.view.animation.Animation;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: classes44.dex */
public final class b implements Animation.AnimationListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f48235a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f48236b;

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation r100) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation r100) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation r100) {
        this.f48235a.setVisibility(this.f48236b);
    }

    public b(SimpleDraweeView r100, int r101) {
        this.f48235a = r100;
        this.f48236b = r101;
    }
}
