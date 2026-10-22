package com.bytedance.android.livesdk.floatview;

import android.animation.ValueAnimator;
import com.bytedance.android.live.core.utils.a1;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class c implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f125126a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ double f125127b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f125128c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f125129d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ double f125130e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ double f125131f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f125132g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Function0 f125133h;

    public c(b r100, double r101, int r102, int r103, double r104, double r105, int r110, Function0 r111) {
        this.f125126a = r100;
        this.f125127b = r101;
        this.f125128c = r102;
        this.f125129d = r103;
        this.f125130e = r104;
        this.f125131f = r105;
        this.f125132g = r110;
        this.f125133h = r111;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        Object r101 = r100.getAnimatedValue();
        if ((r101 instanceof Integer) == true) goto L5;
        r101 = null;
    L5:
        Integer r102 = (Integer) r101;
        if (r102 == null) goto L13;
        int r103 = r102.intValue();
        int r104 = (int) (((double) r103) * this.f125127b);
        a1.p(this.f125126a.f125123e, r104);
        a1.k(this.f125126a.f125123e, r103);
        int r105 = this.f125128c;
        if ((r105 - r104) < 0) goto L10;
        int r106 = r105 - r104;
    L11:
        int r107 = this.f125129d - r103;
        int r108 = (int) (((double) r106) * this.f125130e);
        int r109 = r106 - r108;
        int r110 = (int) (((double) r107) * this.f125131f);
        int r111 = (r107 - r110) + this.f125132g;
        a1.m(this.f125126a.f125123e, r108);
        a1.o(this.f125126a.f125123e, r111);
        a1.n(this.f125126a.f125123e, r109);
        a1.l(this.f125126a.f125123e, r110);
        return;
    L10:
        r106 = 0;
        goto L11
    }
}
