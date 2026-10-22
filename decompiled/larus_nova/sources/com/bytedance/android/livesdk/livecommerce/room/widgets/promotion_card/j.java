package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes10.dex */
public final class j implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f152269a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function0 f152270b;

    public j(long r100, Function0 r101) {
        this.f152269a = r100;
        this.f152270b = r101;
    }

    public final void a() {
        dm.a.a("BottomRightCardManager").i("hide explain card after extend " + this.f152269a + "ms");
        this.f152270b.invoke();
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
