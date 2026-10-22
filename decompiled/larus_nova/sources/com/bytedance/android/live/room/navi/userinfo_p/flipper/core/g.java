package com.bytedance.android.live.room.navi.userinfo_p.flipper.core;

import android.view.View;
import android.view.animation.Animation;

/* JADX INFO: loaded from: classes47.dex */
public final class g implements Animation.AnimationListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f100049a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ w91.c.a f100050b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ View f100051c;

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation r100) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation r100) {
        if (this.f100049a == false) goto L7;
        w91.c.a r101 = this.f100050b;
        if (r101 == null) goto L11;
        r101.a();
        return;
    L11:
        return;
    L7:
        w91.c.a r102 = this.f100050b;
        if (r102 == null) goto L13;
        r102.c();
        return;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation r100) {
        if (this.f100049a == false) goto L7;
        w91.c.a r101 = this.f100050b;
        if (r101 == null) goto L11;
        r101.d();
        return;
    L11:
        return;
    L7:
        w91.c.a r102 = this.f100050b;
        if (r102 == null) goto L13;
        r102.b();
        return;
    }

    public g(boolean r100, f r101, View r102) {
        this.f100049a = r100;
        this.f100050b = r101;
        this.f100051c = r102;
    }
}
