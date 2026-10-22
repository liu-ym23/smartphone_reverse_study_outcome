package com.bytedance.agentrobots.audit;

/* JADX INFO: loaded from: classes43.dex */
final enum AgentSecurityLogger$PayloadMode extends Enum<AgentSecurityLogger$PayloadMode> {
    public static final AgentSecurityLogger$PayloadMode DISABLED = null;
    public static final AgentSecurityLogger$PayloadMode ENCRYPTED_ONLY = null;
    public static final AgentSecurityLogger$PayloadMode RAW_AND_ENCRYPTED = null;
    public static final AgentSecurityLogger$PayloadMode RAW_ONLY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AgentSecurityLogger$PayloadMode[] f33910a = null;

    static {
        AgentSecurityLogger$PayloadMode r100 = new AgentSecurityLogger$PayloadMode("RAW_AND_ENCRYPTED", 0);
        RAW_AND_ENCRYPTED = r100;
        AgentSecurityLogger$PayloadMode r101 = new AgentSecurityLogger$PayloadMode("RAW_ONLY", 1);
        RAW_ONLY = r101;
        AgentSecurityLogger$PayloadMode r102 = new AgentSecurityLogger$PayloadMode("ENCRYPTED_ONLY", 2);
        ENCRYPTED_ONLY = r102;
        AgentSecurityLogger$PayloadMode r103 = new AgentSecurityLogger$PayloadMode("DISABLED", 3);
        DISABLED = r103;
        f33910a = new AgentSecurityLogger$PayloadMode[]{r100, r101, r102, r103};
    }

    public static AgentSecurityLogger$PayloadMode[] values() {
        return (AgentSecurityLogger$PayloadMode[]) f33910a.clone();
    }

    public static AgentSecurityLogger$PayloadMode valueOf(String r100) {
        return (AgentSecurityLogger$PayloadMode) r27.a.a(AgentSecurityLogger$PayloadMode.class, r100);
    }

    public AgentSecurityLogger$PayloadMode(String r100, int r101) {
        super(r100, r101);
    }
}
