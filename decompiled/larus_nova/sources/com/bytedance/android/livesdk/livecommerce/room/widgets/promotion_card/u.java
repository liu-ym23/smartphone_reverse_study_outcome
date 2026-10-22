package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card;

import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes10.dex */
public final class u implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ t f152716a;

    @Override // java.lang.Runnable
    public final void run() {
        t r100 = this.f152716a;     // Catch: Throwable -> L6
        Function1<? super ECUIPromotion, Unit> r101 = r100.f152714d;     // Catch: Throwable -> L6
        if (r101 == null) goto L9;
        Unit r102 = r101.invoke(r100.f152711a);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }

    public u(t r100) {
        this.f152716a = r100;
    }
}
