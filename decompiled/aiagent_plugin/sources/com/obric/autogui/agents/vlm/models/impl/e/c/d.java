package com.obric.autogui.agents.vlm.models.impl.e.c;

import d.h.b.o;

/* JADX INFO: compiled from: SecurityPolicy.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d extends Exception {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f27842a;

    public d(String r2) {
        o.e(r2, "logMessage");
        super(r2);
        this.f27842a = r2;
    }

    public final String a() {
        return this.f27842a;
    }
}
