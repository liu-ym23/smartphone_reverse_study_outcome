package com.bytedance.android.livesdk.microom.enhance;

import android.view.View;
import com.bytedance.android.live.core.utils.a1;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes11.dex */
public final class x implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ NormalRoomMicListWidget f153892a;

    public x(NormalRoomMicListWidget r100) {
        this.f153892a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        View r100 = this.f153892a.f153824c;     // Catch: Throwable -> L9
        if (r100 == null) goto L5;
        a1.p(r100, 0);     // Catch: Throwable -> L9
    L5:
        View r101 = this.f153892a.f153825d;     // Catch: Throwable -> L9
        if (r101 == null) goto L12;
        r101.setBackgroundDrawable(null);     // Catch: Throwable -> L9
        return;
    L12:
        return;
    L9:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L16;
        throw th;
    }
}
