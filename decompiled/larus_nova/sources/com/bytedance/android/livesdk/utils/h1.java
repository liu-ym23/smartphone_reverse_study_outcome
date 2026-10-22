package com.bytedance.android.livesdk.utils;

import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes11.dex */
public final class h1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h1 f158968a = null;

    static {
        f158968a = new h1();
    }

    public h1() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.bytedance.android.live.core.utils.f2.b(R.string.ttlive_share_shop_id, 3000);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L9;
        return;
    L9:
        throw th;
    }
}
