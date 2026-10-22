package com.bytedance.android.live.messagewindow.framework.process.card;

import com.bytedance.android.live.room.api.messagewindow.monitor.CardAlogParamsBuilder;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.disposables.Disposable;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;

/* JADX INFO: loaded from: classes46.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PkPs f83188a;

    public g(PkPs r100) {
        this.f83188a = r100;
    }

    public final void a() {
        h71.f.a<com.bytedance.android.live.messagewindow.framework.process.a> r100 = this.f83188a.f83169a;
        if (r100 == null) goto L19;
        com.bytedance.android.live.messagewindow.framework.process.a r101 = r100.d();
        if (r101 == null) goto L19;
        y61.b r102 = r101.f83133b;
        if (r102 == null) goto L19;
        com.bytedance.android.live.room.api.messagewindow.monitor.i r103 = r102.monitor();
        if (r103 == null) goto L19;
        CardAlogParamsBuilder r104 = new CardAlogParamsBuilder();
        r104.c("PkPs runnable run");
        int r105 = 0;
        Pair[] r106 = {TuplesKt.to("task", String.valueOf(this.f83188a.f83161g)), TuplesKt.to("skipProcessNext", Boolean.valueOf(this.f83188a.f83162h))};
    L11:
        if (r105 >= 2) goto L18;
        Pair r107 = r106[r105];
        if (r107 == null) goto L17;
        Object r108 = r107.getSecond();
        if (r108 == null) goto L17;
        r104.a((String) r107.getFirst(), r108);
    L17:
        r105 = r105 + 1;
        goto L11
    L18:
        Unit r109 = Unit.INSTANCE;
        r103.d(r104.b());
    L19:
        PkPs r110 = this.f83188a;
        if (r110.f83162h == true) goto L29;
        r110.e();
        PkPs r111 = this.f83188a;
        r111.f83162h = true;
        r111.f83161g = null;
        Disposable r112 = r111.f83160f;
        if (r112 == null) goto L30;
        r112.dispose();
        return;
    L30:
        return;
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
