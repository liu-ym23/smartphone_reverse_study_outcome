package com.obric.autogui.agents.a.a;

import d.a.ax;
import d.h.b.o;
import java.util.Set;

/* JADX INFO: compiled from: ActionEffectAttempt.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Set<com.obric.autogui.agents.a.f.a> f26240a = null;

    static {
        f26240a = ax.a(new com.obric.autogui.agents.a.f.a[]{com.obric.autogui.agents.a.f.a.f26392a, com.obric.autogui.agents.a.f.a.f26393b, com.obric.autogui.agents.a.f.a.f26394c, com.obric.autogui.agents.a.f.a.f26396e, com.obric.autogui.agents.a.f.a.f});
    }

    public static final boolean a(com.obric.autogui.agents.a.f.j r2, com.obric.autogui.agents.a.l.c r3) {
        o.e(r2, "policy");
        o.e(r3, "baseline");
        if (f26240a.contains(r2.a()) == true) goto L5;
    L9:
        return false;
    L5:
        if (r2.b().contains(com.obric.autogui.agents.a.f.c.f26405d) == false) goto L9;
        if (com.obric.autogui.agents.a.n.a.f26730a.e(r3.b()) == false) goto L9;
        return true;
    }
}
