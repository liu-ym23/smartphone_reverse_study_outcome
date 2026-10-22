package com.bytedance.android.ec.window.base.common.uiext;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;

/* JADX INFO: loaded from: classes44.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Integer[] f49223a = null;

    public static final class a implements Animation.AnimationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f49224a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f49225b;

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationRepeat(Animation r100) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationStart(Animation r100) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationEnd(Animation r100) {
            this.f49224a.setVisibility(this.f49225b);
        }

        public a(View r100, int r101) {
            this.f49224a = r100;
            this.f49225b = r101;
        }
    }

    static {
        f49223a = new Integer[]{1, 2, 4};
    }

    public static final Animation b(boolean r100, boolean r110) {
        if (r110 == false) goto L4;
        float r101 = 0.8f;
    L5:
        if (r100 == false) goto L8;
        return new ScaleAnimation(r101, 1.0f, r101, 1.0f, 1, 0.5f, 1, 0.5f);
    L8:
        return new ScaleAnimation(1.0f, r101, 1.0f, r101, 1, 0.5f, 1, 0.5f);
    L4:
        r101 = 1.2f;
        goto L5
    }

    public static final void a(View r100, @WindowAnimationFlag int r101, long r102, boolean r103) {
        if ((r101 & 7) != 0) goto L5;
        return;
    L5:
        r100.clearAnimation();
        AnimationSet r104 = new AnimationSet(true);
        r104.setDuration(r102);
        Integer[] r105 = f49223a;
        int r106 = 0;
    L7:
        if (r106 >= 3) goto L19;
        int r107 = r105[r106].intValue();
        if ((r101 & r107) != r107) goto L11;
        boolean r108 = true;
    L12:
        if (r108 == false) goto L18;
        Map<Integer, KFunction<Animation>> r109 = WindowAnimationProvider.f49217a;
        Intrinsics.checkNotNullParameter(r104, "animationSet");
        KFunction<Animation> r110 = WindowAnimationProvider.f49217a.get(Integer.valueOf(r107));
        if (r110 == null) goto L16;
        Animation r111 = (Animation) ((Function1) r110).invoke(Boolean.valueOf(r103));
    L17:
        r104.addAnimation(r111);
        goto L18
    L16:
        r111 = null;
    L18:
        r106 = r106 + 1;
        goto L7
    L11:
        r108 = false;
        goto L12
    L19:
        if (r103 == false) goto L21;
        int r112 = 0;
    L22:
        r100.setVisibility(0);
        r100.startAnimation(r104);
        r104.setAnimationListener(new a(r100, r112));
        return;
    L21:
        r112 = 8;
        goto L22
    }
}
