package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes10.dex */
public final class z implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f152737a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a0 f152738b;

    public z(Function1 r100, a0 r101) {
        this.f152737a = r100;
        this.f152738b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f152737a.invoke(this.f152738b.f152251a.f152731d);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
