package com.stepos.taskrobot.llmapi.stepfun;

/* loaded from: classes3.dex */
public final /* synthetic */ class m implements S7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4039a;
    public final /* synthetic */ ZyqlGuiAgentTask b;

    public /* synthetic */ m(ZyqlGuiAgentTask zyqlGuiAgentTask, int i) {
        this.f4039a = i;
        this.b = zyqlGuiAgentTask;
    }

    @Override // S7.a
    public final Object invoke() {
        int i = this.f4039a;
        ZyqlGuiAgentTask zyqlGuiAgentTask = this.b;
        switch (i) {
            case 0:
                return zyqlGuiAgentTask.task;
            case 1:
                return zyqlGuiAgentTask.task;
            case 2:
                return zyqlGuiAgentTask.task;
            case 3:
                return ZyqlGuiAgentTask.executor_delegate$lambda$0(zyqlGuiAgentTask);
            case 4:
                return ZyqlGuiAgentTask.abilityProvider_delegate$lambda$0(zyqlGuiAgentTask);
            default:
                return ZyqlGuiAgentTask.appLauncher_delegate$lambda$0(zyqlGuiAgentTask);
        }
    }
}
