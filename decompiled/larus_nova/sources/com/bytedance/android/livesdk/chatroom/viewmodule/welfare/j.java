package com.bytedance.android.livesdk.chatroom.viewmodule.welfare;

import com.bytedance.android.live.core.utils.f2;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes8.dex */
public final class j implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f117627a = null;

    static {
        f117627a = new j();
    }

    public j() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        f2.b(R.string.ttlive_select_welfare_project_success_tips_in_living, 0);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L9;
        return;
    L9:
        throw th;
    }
}
