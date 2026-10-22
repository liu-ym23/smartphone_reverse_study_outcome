package com.bytedance.android.ec.core.utils.rotation;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public abstract class a<T> extends e<T> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f45700j;

    /* JADX INFO: renamed from: com.bytedance.android.ec.core.utils.rotation.a$a, reason: collision with other inner class name */
    public static final class C0811a {
    }

    public static final class b implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f45701a;

        public b(View r100) {
            this.f45701a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Object r101 = r100.getAnimatedValue();
            if (r101 == null) goto L7;
            float r102 = ((Float) r101).floatValue();
            this.f45701a.setAlpha(r102);
            return;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
    }

    public static final class c implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f45702a;

        public c(View r100) {
            this.f45702a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Object r101 = r100.getAnimatedValue();
            if (r101 == null) goto L7;
            float r102 = ((Float) r101).floatValue();
            this.f45702a.setAlpha(r102);
            return;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
    }

    static {
    }

    @Override // com.bytedance.android.ec.core.utils.rotation.e
    public Animator b(View r100) {
        Intrinsics.checkNotNullParameter(r100, "layout");
        ValueAnimator r101 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r101.setDuration(300);
        if (this.f45700j == true) goto L5;
        long r102 = 80;
    L6:
        r101.setStartDelay(r102);
        if (this.f45700j == true) goto L9;
        r101.addUpdateListener(new b(r100));
    L9:
        return r101;
    L5:
        r102 = 120;
        goto L6
    }

    @Override // com.bytedance.android.ec.core.utils.rotation.e
    public Animator c(View r100) {
        Intrinsics.checkNotNullParameter(r100, "layout");
        ValueAnimator r101 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        r101.setDuration(120);
        if (this.f45700j == true) goto L5;
        r101.addUpdateListener(new c(r100));
    L5:
        return r101;
    }

    public a(List r100, long r101, long r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "rotationData");
        Intrinsics.checkNotNullParameter(r100, "rotationData");
        this.f45708a = r100;
        this.f45709b = r101;
        this.f45710c = r102;
        this.f45711d = true;
        this.f45700j = r103;
    }
}
