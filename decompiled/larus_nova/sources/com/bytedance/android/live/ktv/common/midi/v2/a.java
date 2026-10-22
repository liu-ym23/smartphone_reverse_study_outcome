package com.bytedance.android.live.ktv.common.midi.v2;

import android.animation.Animator;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class a {

    /* JADX INFO: renamed from: com.bytedance.android.live.ktv.common.midi.v2.a$a, reason: collision with other inner class name */
    public static final class C1136a implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f69960a;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        }

        public C1136a(Function1 r100) {
            this.f69960a = r100;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            this.f69960a.invoke(r100);
        }
    }

    public static final void a(Animator r100, Function1<? super Animator, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$addAimatorEndListener");
        Intrinsics.checkNotNullParameter(r101, "onAnimationEnd");
        r100.addListener(new C1136a(r101));
    }
}
