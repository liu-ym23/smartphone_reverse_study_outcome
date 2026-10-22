package com.bytedance.android.live.profile.usecase;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.profile.NewProfileInfoViewModel;
import com.bytedance.android.live.profile.model.EnterExitStateType;
import com.bytedance.android.live.profile.monitor.ProfileMonitor;
import com.bytedance.android.live.profile.monitor.TimeType;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class c extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ NewProfileEnterExitUseCase f86990a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function0 f86991b;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        super.onAnimationEnd(r100);
        Function0 r101 = this.f86991b;
        if (r101 == null) goto L5;
        Unit r102 = (Unit) r101.invoke();
    L5:
        ProfileMonitor r103 = this.f86990a.f();
        if (r103 == null) goto L8;
        r103.i(TimeType.EnterAnimEnd);
    L8:
        this.f86990a.f86973i.a(new com.bytedance.android.live.profile.model.a(EnterExitStateType.ENTER_END));
        ALogger.i(NewProfileInfoViewModel.TAG, "EnterExitUseCase: ENTER_END");
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        super.onAnimationStart(r100);
        View r101 = this.f86990a.f86965a;
        if (r101 == null) goto L5;
        r101.setVisibility(0);
    L5:
        ProfileMonitor r102 = this.f86990a.f();
        if (r102 == null) goto L8;
        r102.i(TimeType.EnterAnimStart);
    L8:
        this.f86990a.f86973i.a(new com.bytedance.android.live.profile.model.a(EnterExitStateType.ENTER_START));
        ALogger.i(NewProfileInfoViewModel.TAG, "EnterExitUseCase: ENTER_START");
    }

    public c(NewProfileEnterExitUseCase r100, Function0 r101) {
        this.f86990a = r100;
        this.f86991b = r101;
    }
}
