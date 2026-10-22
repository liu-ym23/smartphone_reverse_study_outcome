package com.obric.agent.trace;

/* JADX INFO: compiled from: IntentMetricNoReplyPolicy.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f15525a = null;

    static {
        f15525a = new l();
    }

    private l() {
    }

    public final String a(String r1, boolean r2) {
        d.h.b.o.e(r1, "intentName");
        if (r2 == false) goto L6;
        return "local_action";
    L6:
        if (d.h.b.o.a(r1, "PC_ProactiveEvents") == false) goto L9;
        return "proactive_event";
    L9:
        if (d.h.b.o.a(r1, "System_DataSyncTrigger") == false) goto L11;
        return "system_sync";
    L11:
        return "server_action";
    }

    public final boolean b(String r2, boolean r3) {
        d.h.b.o.e(r2, "intentName");
        if (r3 == false) goto L5;
    L8:
        return true;
    L5:
        if (a(r2) != null) goto L8;
        return false;
    }

    public final String a(String r1) {
        d.h.b.o.e(r1, "intentName");
        if (d.h.b.o.a(r1, "PC_ProactiveEvents") == false) goto L6;
        return "proactive_no_query";
    L6:
        if (d.h.b.o.a(r1, "System_DataSyncTrigger") == false) goto L8;
        return "data_sync_no_reply";
    L8:
        return null;
    }
}
