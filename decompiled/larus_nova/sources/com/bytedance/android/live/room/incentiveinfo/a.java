package com.bytedance.android.live.room.incentiveinfo;

import android.view.View;
import android.view.animation.Animation;

/* JADX INFO: loaded from: classes47.dex */
public final class a implements Animation.AnimationListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f99618a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ u81.e.a f99619b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ View f99620c;

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation r100) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation r100) {
        if (this.f99618a == false) goto L7;
        u81.e.a r101 = this.f99619b;
        if (r101 == null) goto L11;
        r101.a();
        return;
    L11:
        return;
    L7:
        u81.e.a r102 = this.f99619b;
        if (r102 == null) goto L13;
        r102.c();
        return;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation r100) {
        if (this.f99618a == false) goto L7;
        u81.e.a r101 = this.f99619b;
        if (r101 == null) goto L11;
        r101.d();
        return;
    L11:
        return;
    L7:
        u81.e.a r102 = this.f99619b;
        if (r102 == null) goto L13;
        r102.b();
        return;
    }

    public a(boolean r100, b r101, View r102) {
        this.f99618a = r100;
        this.f99619b = r101;
        this.f99620c = r102;
    }
}
