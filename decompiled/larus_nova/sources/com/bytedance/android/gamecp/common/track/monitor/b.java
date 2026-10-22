package com.bytedance.android.gamecp.common.track.monitor;

import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;
import java.lang.ref.WeakReference;
import kotlin.Pair;

/* JADX INFO: loaded from: classes44.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f56835a;

    public b(a r100) {
        this.f56835a = r100;
    }

    public final void a() {
        Pair<Boolean, Float> r100 = this.f56835a.f();
        a r101 = this.f56835a;
        r101.f56814d = r100.getFirst().booleanValue();
        String r102 = this.f56835a.f56811a;
        StringBuilder r103 = new StringBuilder("delayTask execute ");
        r103.append(this.f56835a.f56814d);
        r103.append(", ");
        WeakReference<View> r104 = this.f56835a.f56812b;
        if (r104 == null) goto L5;
        View r105 = r104.get();
    L6:
        r103.append(r105);
        yr.c.e(r102, r103.toString());
        a r106 = this.f56835a;
        if (r106.f56814d == false) goto L10;
        boolean r107 = r100.getFirst().booleanValue();
        r100.getSecond().floatValue();
        r106.g(r107);
        return;
    L10:
        return;
    L5:
        r105 = null;
        goto L6
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
