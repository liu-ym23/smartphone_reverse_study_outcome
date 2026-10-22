package com.bytedance.android.ec.core.anchorv3;

import android.view.Choreographer;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes43.dex */
public final class l implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PdpMessageOptWorkerV2 f43816a;

    public l(PdpMessageOptWorkerV2 r100) {
        this.f43816a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Choreographer.getInstance().removeFrameCallback(this.f43816a.f43771r);     // Catch: Throwable -> L7
        Iterator r100 = ((ArrayList) this.f43816a.f43748e).iterator();     // Catch: Throwable -> L7
    L4:
        if (r100.hasNext() == false) goto L16;
        ((Function1) r100.next()).invoke(Boolean.FALSE);     // Catch: Throwable -> L7
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
}
