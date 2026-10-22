package com.obric.aiagent.skill.virt.impl.c;

import d.h.b.o;

/* JADX INFO: compiled from: ShellManager.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d extends IllegalStateException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f22166a;

    public d(String r3) {
        o.e(r3, "executionId");
        super("Virt execution id already in flight: " + r3);
        this.f22166a = r3;
    }
}
