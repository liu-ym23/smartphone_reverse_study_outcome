package com.bytedance.android.livesdk.ktvimpl.mv;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.view.animation.LinearInterpolator;
import com.bytedance.android.live.ktv.common.util.KtvUtilsKt;
import com.bytedance.android.livesdk.message.model.ed;
import com.bytedance.android.livesdk.message.model.en;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes10.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f146044a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f146045b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ValueAnimator f146046c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ValueAnimator f146047d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Function1<? super Integer, Unit> f146048e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f146049f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public lb0.a f146050g;

    public b(lb0.a r100) {
        Intrinsics.checkNotNullParameter(r100, "drawable");
        this.f146050g = r100;
        this.f146049f = 1500;
    }

    public final void b(ed r100) {
        Intrinsics.checkNotNullParameter(r100, "colorData");
        float r101 = this.f146050g.c();
        en r102 = r100.a();
        Integer r103 = null;
        if (r102 == null) goto L5;
        Integer r104 = Integer.valueOf(KtvUtilsKt.J(r102, r101));
    L6:
        en r105 = r100.b();
        if (r105 == null) goto L9;
        r103 = Integer.valueOf(KtvUtilsKt.J(r105, r101));
    L9:
        int r106 = this.f146044a;
        if (r104 != null) goto L13;
    L14:
        int r107 = this.f146045b;
        if (r103 == null) goto L20;
        if (r107 != r103.intValue()) goto L20;
        return;
    L20:
        if (r104 != null) goto L22;
    L26:
        if (r103 != null) goto L28;
        return;
    L28:
        if (this.f146045b == r103.intValue()) goto L36;
        this.f146045b = r103.intValue();
        Integer r108 = this.f146050g.a();
        if (r108 == null) goto L37;
        ValueAnimator r109 = a(this.f146047d, r108.intValue(), r103.intValue());
        Intrinsics.checkNotNullParameter(r109, "$this$addUpdateListener");
        Ref.IntRef r110 = new Ref.IntRef();
        r110.element = 0;
        r109.addUpdateListener(new a(this, r110, false, true));
        this.f146047d = r109;
        return;
    L37:
        return;
    L36:
        return;
    L22:
        if (this.f146044a == r104.intValue()) goto L26;
        this.f146044a = r104.intValue();
        Integer r111 = this.f146050g.e();
        if (r111 == null) goto L26;
        ValueAnimator r112 = a(this.f146046c, r111.intValue(), r104.intValue());
        Intrinsics.checkNotNullParameter(r112, "$this$addUpdateListener");
        Ref.IntRef r113 = new Ref.IntRef();
        r113.element = 0;
        r112.addUpdateListener(new a(this, r113, true, true));
        this.f146046c = r112;
        goto L26
    L13:
        if (r106 != r104.intValue()) goto L14;
        return;
    L5:
        r104 = null;
        goto L6
    }

    public final ValueAnimator a(ValueAnimator r100, int r101, int r102) {
        if (r100 != null) goto L5;
    L7:
        ValueAnimator r103 = ValueAnimator.ofObject(new ArgbEvaluator(), new Object[]{Integer.valueOf(r101), Integer.valueOf(r102)});
        r103.setInterpolator(new LinearInterpolator());
        r103.setDuration(this.f146049f);
        r103.start();
        return r103;
    L5:
        if (r100.isRunning() != true) goto L7;
        r100.cancel();
        goto L7
    }
}
