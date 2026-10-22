package com.bytedance.android.live.profile.usecase;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
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
public final class d extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ NewProfileEnterExitUseCase f86992a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function0 f86993b;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        super.onAnimationEnd(r100);
        ProfileMonitor r101 = this.f86992a.f();
        if (r101 == null) goto L5;
        r101.i(TimeType.ExitAnimEnd);
    L5:
        this.f86992a.f86973i.a(new com.bytedance.android.live.profile.model.a(EnterExitStateType.EXIT_END));
        ALogger.i(NewProfileInfoViewModel.TAG, "EnterExitUseCase: EXIT_END");
        Function0 r102 = this.f86993b;
        if (r102 == null) goto L8;
        Unit r103 = (Unit) r102.invoke();
    L8:
        this.f86992a.f86973i.a(new com.bytedance.android.live.profile.model.a(EnterExitStateType.COMPLETE));
        ALogger.i(NewProfileInfoViewModel.TAG, "EnterExitUseCase: COMPLETE");
        this.f86992a.f86973i.onComplete();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        super.onAnimationStart(r100);
        ProfileMonitor r101 = this.f86992a.f();
        if (r101 == null) goto L5;
        r101.i(TimeType.ExitAnimStart);
    L5:
        this.f86992a.f86973i.a(new com.bytedance.android.live.profile.model.a(EnterExitStateType.EXIT_START));
        ALogger.i(NewProfileInfoViewModel.TAG, "EnterExitUseCase: EXIT_START");
    }

    public d(NewProfileEnterExitUseCase r100, Function0 r101) {
        this.f86992a = r100;
        this.f86993b = r101;
    }
}
