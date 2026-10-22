package com.bytedance.android.livesdk.ktvimpl.mv;

import android.animation.ValueAnimator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes10.dex */
public final class a implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f146040a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.IntRef f146041b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f146042c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ boolean f146043d;

    public a(b r100, Ref.IntRef r101, boolean r102, boolean r103) {
        this.f146040a = r100;
        this.f146041b = r101;
        this.f146042c = r102;
        this.f146043d = r103;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        Object r101 = r100.getAnimatedValue();
        if (r101 == null) goto L17;
        int r102 = ((Integer) r101).intValue();
        if (this.f146041b.element != r102) goto L7;
        return;
    L7:
        if (this.f146042c == false) goto L11;
        this.f146040a.f146050g.b(Integer.valueOf(r102));
        Function1<? super Integer, Unit> r103 = this.f146040a.f146048e;
        if (r103 == null) goto L12;
        Unit r104 = r103.invoke(Integer.valueOf(r102));
    L12:
        this.f146041b.element = r102;
        if (this.f146043d == false) goto L19;
        b r105 = this.f146040a;
        r105.getClass();
        r105.f146050g.invalidateSelf();
        return;
    L19:
        return;
    L11:
        this.f146040a.f146050g.d(Integer.valueOf(r102));
        goto L12
    L17:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }
}
