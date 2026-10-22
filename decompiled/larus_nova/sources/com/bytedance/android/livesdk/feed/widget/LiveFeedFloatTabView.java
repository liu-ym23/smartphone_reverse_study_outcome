package com.bytedance.android.livesdk.feed.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.android.livesdk.feed.feed.e;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public class LiveFeedFloatTabView extends LiveTabIndicator {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f124580h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Animator f124581i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Animator f124582j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f124583k;

    public class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveFeedFloatTabView f124584a;

        public a(LiveFeedFloatTabView r100) {
            this.f124584a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            this.f124584a.f124583k = true;
        }
    }

    public class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveFeedFloatTabView f124585a;

        public b(LiveFeedFloatTabView r100) {
            this.f124585a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            this.f124585a.f124583k = false;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        this.f124580h = false;
        Animator r100 = this.f124581i;
        if (r100 != null) goto L5;
    L7:
        Animator r101 = this.f124582j;
        if (r101 != null) goto L10;
    L12:
        super.onDetachedFromWindow();
        return;
    L10:
        if (r101.isRunning() == false) goto L12;
        this.f124582j.cancel();
        goto L12
    L5:
        if (r100.isRunning() == false) goto L7;
        this.f124581i.cancel();
        goto L7
    }

    public final void d() {
        if (this.f124580h == true) goto L5;
        return;
    L5:
        if (this.f124583k == false) goto L15;
        Animator r100 = this.f124581i;
        if (r100 != null) goto L10;
    L12:
        ObjectAnimator r101 = ObjectAnimator.ofFloat(this, LiveDegradeFpsAnimator.TRANSLATION_Y, new float[]{getTranslationY(), -getHeight()});
        this.f124582j = r101;
        r101.addListener(new b(this));
        this.f124582j.start();
        return;
    L10:
        if (r100.isRunning() == false) goto L12;
        this.f124581i.cancel();
        goto L12
    }

    public final void e() {
        if (this.f124580h == true) goto L5;
        return;
    L5:
        Animator r100 = this.f124581i;
        if (r100 != null) goto L8;
    L10:
        setTranslationY(-getHeight());
        this.f124583k = false;
        return;
    L8:
        if (r100.isRunning() == false) goto L10;
        this.f124581i.cancel();
        goto L10
    }

    public final void f() {
        if (this.f124580h == true) goto L5;
        return;
    L5:
        if (this.f124583k == true) goto L15;
        Animator r100 = this.f124582j;
        if (r100 != null) goto L10;
    L12:
        ObjectAnimator r101 = ObjectAnimator.ofFloat(this, LiveDegradeFpsAnimator.TRANSLATION_Y, new float[]{getTranslationY(), 0.0f});
        this.f124581i = r101;
        r101.addListener(new a(this));
        this.f124581i.start();
        return;
    L10:
        if (r100.isRunning() == false) goto L12;
        this.f124582j.cancel();
        goto L12
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f124580h = true;
    }

    public LiveFeedFloatTabView(Context r100) {
        this(r100, null);
    }

    public void setTabList(List<e> r100) {
        setTitles(r100);
    }

    public LiveFeedFloatTabView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public LiveFeedFloatTabView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }
}
