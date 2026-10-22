package com.bytedance.android.livesdk.widget.crop;

import com.bytedance.android.live.effect.event.ReleaseStatus;
import com.larus.apm.impl.protector.RunnableProtector;
import n90.e;

/* JADX INFO: loaded from: classes11.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f161679a = null;

    static {
        f161679a = new a();
    }

    public a() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        xs2.b.a().post(new e(ReleaseStatus.Start));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
