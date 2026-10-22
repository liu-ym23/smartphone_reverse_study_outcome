package com.obric.aiagent.ipc.utils;

import android.os.Bundle;
import d.h.b.o;
import d.m;
import d.s;

/* JADX INFO: compiled from: IPCLog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f18677a = null;

    static {
        f18677a = new k();
    }

    private final void a(String r1, Bundle r2) {
    }

    private k() {
    }

    public final void a(String r4, String r5, long r6) {
        o.e(r4, "tag");
        o.e(r5, "detail");
        a("ipc_trace", androidx.core.os.e.a(new m[]{s.a("ipc_action_type", "call_result"), s.a("ipc_tag", r4), s.a("ipc_detail", r5), s.a("ipc_cost", Long.valueOf(r6))}));
    }

    public final void a(String r4, String r5, g r6, long r7) {
        o.e(r4, "tag");
        o.e(r5, "detail");
        o.e(r6, "e");
        a("ipc_trace", androidx.core.os.e.a(new m[]{s.a("ipc_action_type", "call_fail"), s.a("ipc_tag", r4), s.a("ipc_detail", r5), s.a("ipc_exception", r6.getMessage()), s.a("ipc_cost", Long.valueOf(r7))}));
    }

    public final void b(String r4, String r5, long r6) {
        o.e(r4, "tag");
        o.e(r5, "detail");
        a("ipc_trace", androidx.core.os.e.a(new m[]{s.a("ipc_action_type", "invoke_result"), s.a("ipc_tag", r4), s.a("ipc_detail", r5), s.a("ipc_cost", Long.valueOf(r6))}));
    }

    public final void b(String r4, String r5, g r6, long r7) {
        o.e(r4, "tag");
        o.e(r5, "detail");
        o.e(r6, "e");
        a("ipc_trace", androidx.core.os.e.a(new m[]{s.a("ipc_action_type", "invoke_fail"), s.a("ipc_tag", r4), s.a("ipc_detail", r5), s.a("ipc_exception", r6.getMessage()), s.a("ipc_cost", Long.valueOf(r7))}));
    }
}
