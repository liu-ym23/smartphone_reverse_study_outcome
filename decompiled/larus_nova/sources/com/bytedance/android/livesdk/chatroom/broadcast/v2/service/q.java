package com.bytedance.android.livesdk.chatroom.broadcast.v2.service;

import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes7.dex */
public final class q implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q f105528a = null;

    static {
        f105528a = new q();
    }

    public q() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        f2.c(s1.B(R.string.ttlive_anchor_unsupport_real_time_playback_func_with_link), 0);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L9;
        return;
    L9:
        throw th;
    }
}
