package com.obric.autogui.agents.scripted.c;

import com.obric.autogui.common.api.logging.Loog;
import d.h.b.o;

/* JADX INFO: compiled from: ScriptLog.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f26920a = null;

    static {
        f26920a = new c();
    }

    private c() {
    }

    public static final void a(String r1, String r2) {
        o.e(r1, "tag");
        o.e(r2, "msg");
        Loog.INSTANCE.e(r1, r2);
    }

    public static final void a(String r1, String r2, Throwable r3) {
        o.e(r1, "tag");
        o.e(r2, "msg");
        o.e(r3, "tr");
        Loog.INSTANCE.e(r1, r2, r3);
    }
}
