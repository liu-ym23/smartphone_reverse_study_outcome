package com.obric.aiagent.ipc.a;

import d.h.b.o;

/* JADX INFO: compiled from: IPCPolicy.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a {
    private static final String TAG = "IPCPolicy";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f18605a = null;

    static {
        f18605a = new a();
    }

    public final boolean a(String r1, String r2, String r3) {
        o.e(r1, "subject");
        o.e(r2, "target");
        o.e(r3, "action");
        return true;
    }

    private a() {
    }
}
