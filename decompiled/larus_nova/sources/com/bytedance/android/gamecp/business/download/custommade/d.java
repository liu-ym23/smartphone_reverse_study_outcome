package com.bytedance.android.gamecp.business.download.custommade;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.SystemClock;
import android.view.View;
import android.widget.TextView;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import wu.q;

/* JADX INFO: loaded from: classes44.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f52644a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f52645b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f52646c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f52647d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public AnimatorSet f52648e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f52649f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f52650g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final TextView f52651h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final TextView f52652i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final View f52653j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final List<String> f52654k;

    public static final class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f52655a;

        public a(d r100) {
            this.f52655a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            this.f52655a.f52644a.setTranslationY(0.0f);
            d r101 = this.f52655a;
            r101.f52645b.setTranslationY(r101.f52647d);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            super.onAnimationEnd(r100);
            d r101 = this.f52655a;
            long r102 = r101.f52649f - ((long) 300);
            d.a(r101, r101.f52647d, r102);
        }
    }

    public final void b() {
        ObjectAnimator r100 = ObjectAnimator.ofFloat(this.f52645b, LiveDegradeFpsAnimator.TRANSLATION_Y, new float[]{0.0f, -this.f52647d});
        ObjectAnimator r101 = ObjectAnimator.ofFloat(this.f52644a, LiveDegradeFpsAnimator.TRANSLATION_Y, new float[]{this.f52647d, 0.0f});
        AnimatorSet r102 = new AnimatorSet();
        r102.setDuration(300);
        r102.play(r100).with(r101);
        r102.addListener(new a(this));
        r102.start();
        this.f52648e = r102;
    }

    public final void c() {
        if (this.f52650g == false) goto L5;
        return;
    L5:
        this.f52650g = true;
        if (this.f52654k.isEmpty() == false) goto L8;
        return;
    L8:
        this.f52644a.setText((CharSequence) ListProtector.get(this.f52654k, 0));
        this.f52644a.setVisibility(0);
        this.f52645b.setVisibility(8);
        if (this.f52654k.size() < 2) goto L13;
        long r100 = SystemClock.elapsedRealtime();
        this.f52653j.post(new e(this, r100));
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        b();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public static final void a(d r100, float r101, long r102) {
        r100.f52647d = r101;
        r100.f52646c = (r100.f52646c + 1) % r100.f52654k.size();
        if (Intrinsics.areEqual(r100.f52644a, r100.f52651h) == false) goto L5;
        r100.f52645b = r100.f52651h;
        r100.f52644a = r100.f52652i;
    L6:
        r100.f52645b.setTranslationY(0.0f);
        r100.f52644a.setTranslationY(r100.f52647d);
        r100.f52645b.setVisibility(0);
        r100.f52644a.setVisibility(0);
        r100.f52644a.setText((CharSequence) ListProtector.get(r100.f52654k, r100.f52646c));
        r100.f52653j.postDelayed(r100, r102);
        return;
    L5:
        r100.f52645b = r100.f52652i;
        r100.f52644a = r100.f52651h;
        goto L6
    }

    public d(TextView r100, TextView r101, View r102, List<String> r103) {
        Intrinsics.checkNotNullParameter(r100, "firstShowedView");
        Intrinsics.checkNotNullParameter(r101, "secondShowedView");
        Intrinsics.checkNotNullParameter(r102, "groupView");
        Intrinsics.checkNotNullParameter(r103, "tips");
        this.f52651h = r100;
        this.f52652i = r101;
        this.f52653j = r102;
        this.f52654k = r103;
        this.f52644a = r100;
        this.f52645b = r101;
        this.f52649f = q.f561371a.getValue().b();
    }
}
