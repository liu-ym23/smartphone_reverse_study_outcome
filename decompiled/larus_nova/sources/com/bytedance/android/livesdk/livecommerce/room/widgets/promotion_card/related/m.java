package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.related;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes10.dex */
public final class m implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f152599a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ n f152600b;

    public m(Function1 r100, n r101) {
        this.f152599a = r100;
        this.f152600b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f152599a.invoke(this.f152600b.f152601a.f152546d);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
