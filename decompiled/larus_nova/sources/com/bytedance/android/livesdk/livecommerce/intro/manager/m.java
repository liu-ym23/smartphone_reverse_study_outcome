package com.bytedance.android.livesdk.livecommerce.intro.manager;

import com.bytedance.android.livesdk.livecommerce.intro.model.req.IntroCardScene;
import com.bytedance.android.livesdk.livecommerce.opt.ECLivePerformanceMonitor;
import com.bytedance.android.livesdk.livecommerce.room.store.ECContext;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Pair;

/* JADX INFO: loaded from: classes10.dex */
public final class m implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.livesdk.livecommerce.intro.controller.b f148415a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Pair f148416b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ uh2.a f148417c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ boolean f148418d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ p f148419e;

    public m(com.bytedance.android.livesdk.livecommerce.intro.controller.b r100, Pair r101, uh2.a r102, boolean r103, p r104) {
        this.f148415a = r100;
        this.f148416b = r101;
        this.f148417c = r102;
        this.f148418d = r103;
        this.f148419e = r104;
    }

    public final void a() {
        Pair r100 = this.f148416b;
        if (r100 == null) goto L16;
        IntroCardScene r101 = (IntroCardScene) r100.getSecond();
        if (r101 == null) goto L16;
        if (sh2.f.b(r101) != true) goto L16;
        ECContext r102 = this.f148419e.f148426a.f148407l.r();
        if (r102 == null) goto L13;
        com.bytedance.live.datacontext.i<ECLivePerformanceMonitor> r103 = r102.getEcLivePerformanceMonitor();
        if (r103 == null) goto L13;
        ECLivePerformanceMonitor r104 = r103.getValue();
    L14:
        if (r104 == null) goto L16;
        ECLivePerformanceMonitor.y(r104, Boolean.TRUE, new gf.a(0));
    L13:
        r104 = null;
    L16:
        this.f148415a.m(this.f148417c, false, this.f148418d);
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
