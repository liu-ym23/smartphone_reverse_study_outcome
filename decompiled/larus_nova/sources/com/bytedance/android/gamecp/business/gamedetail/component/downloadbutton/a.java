package com.bytedance.android.gamecp.business.gamedetail.component.downloadbutton;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes44.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Function0<Unit>> f54278a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<ObjectAnimator> f54279b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<AnimatorSet> f54280c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<ValueAnimator> f54281d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function0<Unit> f54282e;

    public final void a() {
        yr.b.b(3, "DownloadButtonAnimation", "AnimationHandler clear");
        Iterator<T> r100 = this.f54279b.iterator();
    L4:
        if (r100.hasNext() == false) goto L10;
        ObjectAnimator r101 = (ObjectAnimator) r100.next();
        if (r101 == null) goto L4;
        if (r101.isRunning() != true) goto L4;
        r101.cancel();
        goto L4
    L10:
        Iterator<T> r102 = this.f54280c.iterator();
    L12:
        if (r102.hasNext() == false) goto L18;
        AnimatorSet r103 = (AnimatorSet) r102.next();
        if (r103 == null) goto L12;
        if (r103.isRunning() != true) goto L12;
        r103.cancel();
        goto L12
    L18:
        Iterator<T> r104 = this.f54281d.iterator();
    L20:
        if (r104.hasNext() == false) goto L26;
        ValueAnimator r105 = (ValueAnimator) r104.next();
        if (r105 == null) goto L20;
        if (r105.isRunning() != true) goto L20;
        r105.cancel();
        goto L20
    L26:
        this.f54279b.clear();
        this.f54280c.clear();
        this.f54279b.clear();
        ((ArrayList) this.f54281d).clear();
    }

    public final void c() {
        Iterator<T> r100 = this.f54278a.iterator();
    L4:
        if (r100.hasNext() == false) goto L8;
        Function0 r101 = (Function0) r100.next();
        if (r101 == null) goto L4;
        Unit r102 = (Unit) r101.invoke();
        goto L4
    }

    public a(int r100) {
        this.f54282e = null;
        this.f54278a = CollectionsKt.mutableListOf(new Function0[]{null});
        this.f54279b = CollectionsKt.mutableListOf(new ObjectAnimator[]{null});
        this.f54280c = CollectionsKt.mutableListOf(new AnimatorSet[]{null});
        this.f54281d = new ArrayList();
    }

    public static void b(a r100, ObjectAnimator r101, AnimatorSet r102, Function0 r103) {
        r100.f54279b.add(r101);
        r100.f54280c.add(r102);
        ((ArrayList) r100.f54281d).add(null);
        r100.f54278a.add(r103);
    }
}
