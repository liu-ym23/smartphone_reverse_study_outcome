package com.obric.autogui.evaluation.a;

import d.h.b.o;

/* JADX INFO: compiled from: KnowledgeDebugBindingSignedCallingExecutor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f29070a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile String f29071b;

    static {
        f29070a = new b();
    }

    private b() {
    }

    public final void update(String r1) {
        o.e(r1, "value");
        f29071b = r1;
    }

    public final String a() {
        return f29071b;
    }
}
