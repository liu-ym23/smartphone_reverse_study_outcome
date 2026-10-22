package com.bytedance.android.livesdk.focus;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class FocusAndExposureManager$getAlphaDisappearAnimation$1 extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f125299a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f125300b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function0 f125301c;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        UtilityKotlinExtentionsKt.s(0, false, false, new FocusAndExposureManager$getAlphaDisappearAnimation$1$onAnimationEnd$1(this), 7);
    }

    public FocusAndExposureManager$getAlphaDisappearAnimation$1(b r100, View r101, Function0 r102) {
        this.f125299a = r100;
        this.f125300b = r101;
        this.f125301c = r102;
    }
}
