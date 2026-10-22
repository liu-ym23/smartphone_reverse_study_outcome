package com.obric.aiagent.executionengine.scheduler.impl.execution.a;

import com.obric.capabilitykit.common.execution.IntentCalling;
import d.h.b.o;

/* JADX INFO: compiled from: SysOptExecutionController.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f18397a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final a[] f18398b = null;

    private b() {
    }

    static {
        f18397a = new b();
        f18398b = new a[]{new a()};
    }

    public final void a(String r4, IntentCalling r5) {
        o.e(r4, "targetPackage");
        o.e(r5, "intentCalling");
        a[] r3 = f18398b;
        int r0 = r3.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r3[r1].a(r4, r5);
        r1 = r1 + 1;
        goto L3
    }

    public final void b(String r4, IntentCalling r5) {
        o.e(r4, "targetPackage");
        o.e(r5, "intentCalling");
        a[] r3 = f18398b;
        int r0 = r3.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r3[r1].b(r4, r5);
        r1 = r1 + 1;
        goto L3
    }
}
