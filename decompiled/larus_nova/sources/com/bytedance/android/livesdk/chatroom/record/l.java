package com.bytedance.android.livesdk.chatroom.record;

import com.bytedance.android.live.core.utils.f2;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes7.dex */
public final class l implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f108067a = null;

    static {
        f108067a = new l();
    }

    public l() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        f2.b(R.string.ttlive_record_save_and_template, 0);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L9;
        return;
    L9:
        throw th;
    }
}
