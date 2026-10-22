package com.obric.aiagent.skill.credentials.impl;

import com.obric.aiagent.skill.credentials.api.ISkillCredentialService;
import com.obric.aiagent.skill.credentials.impl.c.b;
import com.obric.aiagent.skill.credentials.impl.d.a;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SafetyGuardSkillCredentialService.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SafetyGuardSkillCredentialService implements ISkillCredentialService {
    private final ISkillCredentialService.a account;
    private final ISkillCredentialService.b apps;
    private final a sessionCapability;
    private final ISkillCredentialService.d sessions;
    private final b sidecarProvider;
    private final ISkillCredentialService.e taskSessions;

    public SafetyGuardSkillCredentialService() {
        b r0 = new b();
        this.sidecarProvider = r0;
        a r1 = new a(r0);
        this.sessionCapability = r1;
        this.apps = (ISkillCredentialService.b) ZeusTransformUtils.preCheckCast(new com.obric.aiagent.skill.credentials.impl.b.a(r0), ISkillCredentialService.b.class, "com.obric.aiagent.plugin");
        this.account = (ISkillCredentialService.a) ZeusTransformUtils.preCheckCast(new com.obric.aiagent.skill.credentials.impl.a.a(r0), ISkillCredentialService.a.class, "com.obric.aiagent.plugin");
        this.sessions = (ISkillCredentialService.d) ZeusTransformUtils.preCheckCast(r1, ISkillCredentialService.d.class, "com.obric.aiagent.plugin");
        this.taskSessions = (ISkillCredentialService.e) ZeusTransformUtils.preCheckCast(new com.obric.aiagent.skill.credentials.impl.d.b((ISkillCredentialService.d) ZeusTransformUtils.preCheckCast(r1, ISkillCredentialService.d.class, "com.obric.aiagent.plugin")), ISkillCredentialService.e.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.aiagent.skill.credentials.api.ISkillCredentialService
    public ISkillCredentialService.b getApps() {
        return this.apps;
    }

    @Override // com.obric.aiagent.skill.credentials.api.ISkillCredentialService
    public ISkillCredentialService.a getAccount() {
        return this.account;
    }

    @Override // com.obric.aiagent.skill.credentials.api.ISkillCredentialService
    public ISkillCredentialService.d getSessions() {
        return this.sessions;
    }

    @Override // com.obric.aiagent.skill.credentials.api.ISkillCredentialService
    public ISkillCredentialService.e getTaskSessions() {
        return this.taskSessions;
    }
}
