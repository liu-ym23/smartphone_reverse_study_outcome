package com.bytedance.android.window.shop.home.presenter;

import com.bytedance.android.btm.api.model.PageFinder;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.TimerTask;

/* JADX INFO: loaded from: classes14.dex */
public final class r0 extends TimerTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f188623a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ s0 f188624b;

    public static final class a {
        public a() {
        }
    }

    public final void a() {
        int r100 = zq3.f.f573300a;
        String r101 = this.f188623a;
        t0 r102 = this.f188624b.f188627a;
        int r103 = t0.f188632o;
        String r104 = zq3.f.c(r101, "a1.b7635.c366460.d75972", PageFinder.via(r102.y()), null);
        com.bytedance.android.ec.sdk.helper.p.f48130a.f(this.f188624b.f188627a.u().c(), r104, new a());
    }

    @Override // java.util.TimerTask, java.lang.Runnable
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

    public r0(String r100, s0 r101) {
        this.f188623a = r100;
        this.f188624b = r101;
    }
}
