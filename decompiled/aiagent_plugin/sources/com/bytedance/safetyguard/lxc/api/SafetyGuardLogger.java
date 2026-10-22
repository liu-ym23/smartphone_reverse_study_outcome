package com.bytedance.safetyguard.lxc.api;

/* JADX INFO: compiled from: SafetyGuardLogging.kt */
/* JADX INFO: loaded from: classes.dex */
public interface SafetyGuardLogger {
    boolean isEnabled(SafetyGuardLogLevel r1, String r2);

    void log(SafetyGuardLogLevel r1, String r2, String r3);
}
