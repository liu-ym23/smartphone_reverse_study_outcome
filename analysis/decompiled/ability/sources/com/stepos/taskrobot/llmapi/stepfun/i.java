package com.stepos.taskrobot.llmapi.stepfun;

/* loaded from: classes3.dex */
public final /* synthetic */ class i implements S7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4036a;

    public /* synthetic */ i(int i) {
        this.f4036a = i;
    }

    @Override // S7.a
    public final Object invoke() {
        switch (this.f4036a) {
            case 0:
                return SystemSdkBridge.notifier_delegate$lambda$0();
            case 1:
                return SystemSdkBridge.networkLostListener$lambda$0();
            default:
                return TrajectorySpeculationLabeler.labelHttpClient_delegate$lambda$0();
        }
    }
}
