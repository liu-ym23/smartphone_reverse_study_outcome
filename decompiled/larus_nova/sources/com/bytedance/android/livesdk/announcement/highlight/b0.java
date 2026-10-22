package com.bytedance.android.livesdk.announcement.highlight;

import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes7.dex */
public final class b0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b0 f103467a = null;

    static {
        f103467a = new b0();
    }

    public b0() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        f2.c(s1.B(R.string.ttlive_announcement_highlight_subscribe_succeed_toast), 0);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L9;
        return;
    L9:
        throw th;
    }
}
