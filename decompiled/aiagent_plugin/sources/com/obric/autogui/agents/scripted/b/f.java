package com.obric.autogui.agents.scripted.b;

import d.h.b.o;

/* JADX INFO: compiled from: ScriptTelemetryLogger.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f26914a = null;

    static {
        f26914a = new f();
    }

    private f() {
    }

    public final void a(String r1, String r2, Throwable r3) {
        o.e(r1, "tag");
        o.e(r2, "message");
        if (r3 != null) goto L5;
        com.obric.autogui.agents.scripted.c.c.a(r1, r2);     // Catch: Exception -> L7
    L8:
        return;
    L5:
        com.obric.autogui.agents.scripted.c.c.a(r1, r2, r3);     // Catch: Exception -> L7
    }
}
