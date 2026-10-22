package com.bytedance.android.ec.core.anchorv3;

import com.bytedance.android.ec.sdk.ECSdk;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

/* JADX INFO: loaded from: classes43.dex */
public final class e implements Runnable {
    public e() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L8
        int r101 = ECSdk.f48106a;     // Catch: Throwable -> L8
        ba3.a r102 = (ba3.a) ECSdk.a(ba3.a.class);     // Catch: Throwable -> L8
        if (r102 == null) goto L5;
        r102.a();     // Catch: Throwable -> L8
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L8
    L6:
        Result.m9449constructorimpl(r103);     // Catch: Throwable -> L8
        return;
    L5:
        r103 = null;
    L8:
        th = move-exception;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L11
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
