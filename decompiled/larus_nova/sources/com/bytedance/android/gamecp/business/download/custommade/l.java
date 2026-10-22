package com.bytedance.android.gamecp.business.download.custommade;

import android.animation.ValueAnimator;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

/* JADX INFO: loaded from: classes44.dex */
public final class l implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ NewSessionInstaller f52689a;

    public l(NewSessionInstaller r100) {
        this.f52689a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L8
        ValueAnimator r101 = this.f52689a.f52624d;     // Catch: Throwable -> L8
        if (r101 == null) goto L5;
        r101.cancel();     // Catch: Throwable -> L8
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L8
    L6:
        Result.m9449constructorimpl(r102);     // Catch: Throwable -> L8
        return;
    L5:
        r102 = null;
    L8:
        th = move-exception;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L11
        Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L15;
        return;
    L15:
        throw th;
    }
}
