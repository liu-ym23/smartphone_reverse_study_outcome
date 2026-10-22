package com.bytedance.android.live.openplatform.impl.miniappaudience.explaincard;

import com.bytedance.android.live.openplatform.impl.base.perf.PerformanceScene;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.HashMap;
import zo0.h;

/* JADX INFO: loaded from: classes46.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f84875a = null;

    static {
        f84875a = new b();
    }

    public b() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        HashMap<String, zo0.f> r100 = zo0.g.f573094a;     // Catch: Throwable -> L4
        zo0.f r101 = h.b(PerformanceScene.EXPLAIN_CARD);     // Catch: Throwable -> L4
        int r102 = zo0.f.f573090d;     // Catch: Throwable -> L4
        r101.l("card_show_finish", null);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
