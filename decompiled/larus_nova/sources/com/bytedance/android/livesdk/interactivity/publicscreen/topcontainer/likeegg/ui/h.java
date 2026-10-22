package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.ui;

import android.view.animation.Animation;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes9.dex */
public final class h implements Animation.AnimationListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Animation f140014a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function0 f140015b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function0 f140016c;

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation r100) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation r100) {
        Function0 r101 = this.f140015b;
        if (r101 == null) goto L5;
        Unit r102 = (Unit) r101.invoke();
    L5:
        this.f140014a.setAnimationListener(null);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation r100) {
        Function0 r101 = this.f140016c;
        if (r101 == null) goto L6;
        Unit r102 = (Unit) r101.invoke();
        return;
    }

    public h(Animation r100, Function0 r101, Function0 r102) {
        this.f140014a = r100;
        this.f140015b = r101;
        this.f140016c = r102;
    }
}
