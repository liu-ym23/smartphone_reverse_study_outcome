package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.related;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes10.dex */
public final class t implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RelatedCardWidgetController f152615a;

    public t(RelatedCardWidgetController r100) {
        this.f152615a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        RelatedCardWidgetController.f(this.f152615a, false);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
