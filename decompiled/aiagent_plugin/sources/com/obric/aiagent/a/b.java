package com.obric.aiagent.a;

import com.obric.aiagent.platform.depend.ILogDepend;

/* JADX INFO: compiled from: AiAgentNetSpyTracker.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b {
    private static final String TAG = "AiAgentNetSpyTracker";

    public static boolean a(String r0, String r1) {
        if (a.a(r0, r1) == a.EnumC0324a.f16097a) goto L5;
        return true;
    L5:
        return false;
    }

    public static a.EnumC0324a b(String r0, String r1) {
        return a.a(r0, r1);
    }

    public static void a(a.EnumC0324a r1, String r2, String r3) {
        if (r1 != null) goto L5;
        return;
    L5:
        if (r1 != a.EnumC0324a.f16097a) goto L12;
        return;
    L12:
        a.a(r1, r2, r3);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        ILogDepend.Companion.w(TAG, "report failed: " + th.getMessage());
    }
}
