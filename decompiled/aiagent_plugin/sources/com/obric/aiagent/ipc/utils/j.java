package com.obric.aiagent.ipc.utils;

import com.obric.aiagent.platform.depend.ISecureLogDepend;
import d.h.b.o;

/* JADX INFO: compiled from: IPCLog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f18676a = null;

    static {
        f18676a = new j();
    }

    private j() {
    }

    public final void a(String r3, String r4) {
        o.e(r3, "tag");
        o.e(r4, "event");
        ISecureLogDepend.Companion.i("IPC-BASE", "--> [" + r3 + "] " + r4);
    }

    public final void b(String r3, String r4) {
        o.e(r3, "tag");
        o.e(r4, "event");
        ISecureLogDepend.Companion.i("IPC-BASE", "<-- [" + r3 + "] " + r4);
    }

    public final void c(String r3, String r4) {
        o.e(r3, "tag");
        o.e(r4, "event");
        ISecureLogDepend.Companion.i("IPC-BASE", "=== [" + r3 + "] " + r4);
    }

    public final void a(String r5, String r6, Throwable r7) {
        o.e(r5, "tag");
        o.e(r6, "event");
        if (r7 != null) goto L5;
        ISecureLogDepend.Companion.w("IPC-BASE", "*** [" + r5 + "] " + r6);
        return;
    L5:
        ISecureLogDepend.Companion.w("IPC-BASE", "*** [" + r5 + "] " + r6, r7);
    }
}
