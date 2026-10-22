package com.obric.aiagent.ipc.utils;

import com.obric.aiagent.platform.depend.ILogDepend;
import d.h.b.o;

/* JADX INFO: compiled from: IPCLog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f18670a = null;

    static {
        f18670a = new h();
    }

    private h() {
    }

    public final void a(String r3, String r4) {
        o.e(r3, "tag");
        o.e(r4, "event");
        ILogDepend.Companion.i("IPC-BASE", "--- [" + r3 + "] " + r4);
    }

    public static /* synthetic */ void a(h r0, String r1, String r2, Throwable r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = null;
    L5:
        r0.a(r1, r2, r3);
    }

    public final void a(String r5, String r6, Throwable r7) {
        o.e(r5, "tag");
        o.e(r6, "event");
        if (r7 != null) goto L5;
        ILogDepend.Companion.w("IPC-BASE", "*** [" + r5 + "] " + r6);
        return;
    L5:
        ILogDepend.Companion.w("IPC-BASE", "*** [" + r5 + "] " + r6, r7);
    }
}
