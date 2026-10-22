package com.obric.autogui.agents.scripted.impl;

import com.bytedance.vmsdk.worker.JsWorker;

/* JADX INFO: compiled from: AOJSEnvExt.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f26972a = null;

    static {
        f26972a = new a();
    }

    /* JADX INFO: renamed from: lambda$vOqtO3i9m-nCozyn2uvq57SYA-k, reason: not valid java name */
    public static /* synthetic */ void m725lambda$vOqtO3i9mnCozyn2uvq57SYAk(String r0, JsWorker r1, String r2) {
        a(r0, r1, r2);
    }

    private a() {
    }

    public final boolean a() {
        if (JsWorker.isIsInitialised() == false) goto L7;
        return true;
    L7:
        return JsWorker.initialize();
    }

    public static /* synthetic */ void a(a r0, JsWorker r1, String r2, String r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L5;
        r3 = null;
    L5:
        r0.a(r1, r2, r3);
    }

    public final void a(final JsWorker r1, final String r2, final String r3) {
        d.h.b.o.e(r1, "<this>");
        r1.postOnJSRunner(new $$Lambda$a$vOqtO3i9mnCozyn2uvq57SYAk(r3, r1, r2));
    }

    private static final void a(String r0, JsWorker r1, String r2) {
        if (r0 == null) goto L4;
        r1.evaluateJavaScript(r2, r0);
        return;
    L4:
        r1.evaluateJavaScript(r2);
    }
}
