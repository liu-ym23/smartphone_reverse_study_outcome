package com.bytedance.safetyguard.lxc.api;

import d.h.b.o;

/* JADX INFO: compiled from: ActionEgressModels.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ActionContextToken {
    private final long activationSequence;
    private final String sessionInstanceId;

    public ActionContextToken(String r2, long r3) {
        o.e(r2, "sessionInstanceId");
        this.sessionInstanceId = r2;
        this.activationSequence = r3;
    }

    public final String getSessionInstanceId$safetyguard_runtime_release() {
        return this.sessionInstanceId;
    }

    public final long getActivationSequence$safetyguard_runtime_release() {
        return this.activationSequence;
    }
}
