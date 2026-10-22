package com.bytedance.android.live.liveinteract.animator;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.Interpolator;
import fd0.a;
import fd0.b;
import fd0.f;
import fd0.g;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes46.dex */
public final class LiveAnimator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<f> f71417a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f71418b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f71419c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Interpolator f71420d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f71421e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f71422f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public AnimatorSet f71423g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public a f71424h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public b f71425i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public LiveAnimator f71426j;

    @Retention(RetentionPolicy.SOURCE)
    public @interface RepeatMode {
    }

    public final void b() {
        AnimatorSet r100 = this.f71423g;
        if (r100 == null) goto L6;
        r100.cancel();
        return;
    }

    public final void c() {
        LiveAnimator r100 = this.f71426j;
        if (r100 == null) goto L5;
        r100.c();
        return;
    L5:
        ArrayList r101 = new ArrayList();
        Iterator r102 = ((ArrayList) this.f71417a).iterator();
    L7:
        if (r102.hasNext() == false) goto L9;
        r101.addAll(((f) r102.next()).f476455c);
        goto L7
    L9:
        Iterator r103 = ((ArrayList) this.f71417a).iterator();
    L11:
        if (r103.hasNext() == false) goto L13;
        ((f) r103.next()).getClass();
        goto L11
    L13:
        Iterator r104 = r101.iterator();
    L15:
        if (r104.hasNext() == false) goto L19;
        Animator r105 = (Animator) r104.next();
        if ((r105 instanceof ValueAnimator) == false) goto L15;
        ValueAnimator r106 = (ValueAnimator) r105;
        r106.setRepeatCount(this.f71421e);
        r106.setRepeatMode(this.f71422f);
        goto L15
    L19:
        AnimatorSet r107 = new AnimatorSet();
        r107.playTogether(r101);
        r107.setDuration(this.f71418b);
        r107.setStartDelay(this.f71419c);
        Interpolator r108 = this.f71420d;
        if (r108 == null) goto L22;
        r107.setInterpolator(r108);
    L22:
        r107.addListener(new g(this));
        this.f71423g = r107;
        r107.start();
    }

    public LiveAnimator() {
        this.f71417a = new ArrayList();
        this.f71418b = 3000;
        this.f71419c = 0;
        this.f71420d = null;
        this.f71421e = 0;
        this.f71422f = 1;
        this.f71426j = null;
    }

    public static f a(View... r100) {
        LiveAnimator r101 = new LiveAnimator();
        f r102 = new f(r101, r100);
        ((ArrayList) r101.f71417a).add(r102);
        return r102;
    }
}
