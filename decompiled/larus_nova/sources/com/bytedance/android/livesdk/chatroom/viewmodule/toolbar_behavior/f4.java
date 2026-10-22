package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import android.graphics.drawable.Animatable;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.fresco.animation.drawable.BaseAnimationListener;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class f4 extends BaseAnimationListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f117188a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function0 f117189b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function0 f117190c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Animatable f117191d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Function2 f117192e;

    @Override // com.facebook.fresco.animation.drawable.BaseAnimationListener, com.facebook.fresco.animation.drawable.AnimationListener
    public final void onAnimationStart(AnimatedDrawable2 r100) {
        Intrinsics.checkNotNullParameter(r100, "drawable2");
        Function0 r101 = this.f117189b;
        if (r101 == null) goto L6;
        Unit r102 = (Unit) r101.invoke();
        return;
    }

    @Override // com.facebook.fresco.animation.drawable.BaseAnimationListener, com.facebook.fresco.animation.drawable.AnimationListener
    public final void onAnimationStop(AnimatedDrawable2 r100) {
        Intrinsics.checkNotNullParameter(r100, "drawable2");
        Function0 r101 = this.f117190c;
        if (r101 == null) goto L6;
        Unit r102 = (Unit) r101.invoke();
        return;
    }

    @Override // com.facebook.fresco.animation.drawable.BaseAnimationListener, com.facebook.fresco.animation.drawable.AnimationListener
    public final void onAnimationFrame(AnimatedDrawable2 r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "drawable2");
        if (r101 >= this.f117188a) goto L5;
        this.f117191d.stop();
    L5:
        Function2 r102 = this.f117192e;
        if (r102 == null) goto L8;
        Unit r103 = (Unit) r102.invoke(Integer.valueOf(r101), Integer.valueOf(r100.getFrameCount()));
    L8:
        this.f117188a = r101;
    }

    public f4(Function0 r100, Function0 r101, Animatable r102, Function2 r103) {
        this.f117189b = r100;
        this.f117190c = r101;
        this.f117191d = r102;
        this.f117192e = r103;
        this.f117188a = -1;
    }
}
