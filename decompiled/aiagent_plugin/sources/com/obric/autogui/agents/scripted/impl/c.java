package com.obric.autogui.agents.scripted.impl;

/* JADX INFO: compiled from: JSScriptServiceImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c {
    public static final boolean a(String r1) {
        d.h.b.o.e(r1, "packageName");
        if (d.h.b.o.a(r1, "com.obric.ability.script") == false) goto L5;
    L8:
        return true;
    L5:
        if (d.h.b.o.a(r1, "com.obric.script_engine") == true) goto L8;
        return false;
    }
}
