package com.bytedance.agentrobots.a.b;

import com.aiassistant.security.audit.SecurityAuditManager;

/* JADX INFO: compiled from: AssistantSecurityAuditManagerAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public class f implements com.bytedance.agentrobots.a.a.f {
    public f() {
    }

    @Override // com.bytedance.agentrobots.a.a.f
    public int a(String r1) {
        return SecurityAuditManager.recordAuditWithResult(r1);
    L4:
        return 8;
    }

    @Override // com.bytedance.agentrobots.a.a.f
    public void b(String r1) {
        SecurityAuditManager.setActiveSession(r1);     // Catch: Exception -> L4
        return;
    }

    @Override // com.bytedance.agentrobots.a.a.f
    public void a() {
        SecurityAuditManager.clearActiveSession();     // Catch: Exception -> L4
        return;
    }
}
