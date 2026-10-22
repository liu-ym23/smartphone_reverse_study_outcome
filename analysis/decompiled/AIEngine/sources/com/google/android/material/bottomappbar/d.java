package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import androidx.appcompat.widget.ActionMenuView;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class d extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    public boolean f4664a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ActionMenuView f4665b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f4666c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ boolean f4667d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ BottomAppBar f4668e;

    public d(BottomAppBar bottomAppBar, ActionMenuView actionMenuView, int i10, boolean z) {
        this.f4668e = bottomAppBar;
        this.f4665b = actionMenuView;
        this.f4666c = i10;
        this.f4667d = z;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        this.f4664a = true;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        if (this.f4664a) {
            return;
        }
        this.f4668e.D(this.f4665b, this.f4666c, this.f4667d, false);
    }
}
