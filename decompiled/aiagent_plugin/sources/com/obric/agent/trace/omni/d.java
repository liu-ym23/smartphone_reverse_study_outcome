package com.obric.agent.trace.omni;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: PrivacyGrantAuditLogger.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ConcurrentHashMap.KeySetView<String, Boolean> f15627a;

    public d() {
        this.f15627a = ConcurrentHashMap.newKeySet();
    }

    public final boolean a(String r2) {
        d.h.b.o.e(r2, "messageId");
        return this.f15627a.add(r2);
    }
}
