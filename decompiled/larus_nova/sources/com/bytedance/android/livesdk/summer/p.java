package com.bytedance.android.livesdk.summer;

import com.bytedance.android.live.core.log.ALogger;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;

/* JADX INFO: loaded from: classes11.dex */
public final class p implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ r f158485a;

    @Override // java.lang.Runnable
    public final void run() {
        r r100 = this.f158485a;     // Catch: Throwable -> L7
        r100.getClass();     // Catch: Throwable -> L7
        ALogger.i("BDLog", "summer triggerNormalPriorityTasks");     // Catch: Throwable -> L7
        Iterator<Integer> r101 = r100.f158492d.iterator();     // Catch: Throwable -> L7
    L4:
        if (r101.hasNext() == false) goto L16;
        r100.a(r101.next().intValue());     // Catch: Throwable -> L7
        goto L4
    L16:
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }

    public p(r r100) {
        this.f158485a = r100;
    }
}
