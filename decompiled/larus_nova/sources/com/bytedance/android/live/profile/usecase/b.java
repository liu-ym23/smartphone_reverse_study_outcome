package com.bytedance.android.live.profile.usecase;

import android.animation.Animator;
import android.animation.ValueAnimator;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes47.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ NewProfileEnterExitUseCase.b f86989a;

    public b(NewProfileEnterExitUseCase.b r100) {
        this.f86989a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        NewProfileEnterExitUseCase.b r100 = this.f86989a;     // Catch: Throwable -> L7
        NewProfileEnterExitUseCase r101 = r100.f86975a;     // Catch: Throwable -> L7
        Function0 r102 = r100.f86977c;     // Catch: Throwable -> L7
        Animator r103 = r101.f86969e;     // Catch: Throwable -> L7
        if (r103 == null) goto L5;
        r103.end();     // Catch: Throwable -> L7
    L5:
        ValueAnimator r104 = r101.c(r101.f86966b, true);     // Catch: Throwable -> L7
        r104.addListener(new c(r101, r102));     // Catch: Throwable -> L7
        r104.start();     // Catch: Throwable -> L7
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L7
        r101.f86969e = r104;     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }
}
