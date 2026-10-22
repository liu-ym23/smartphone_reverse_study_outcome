package com.stepos.taskrobot.llmapi.stepfun;

import com.mdisdk.observer.DisplayObserver;
import com.mdisdk.observer.ForegroundAppInfo;

/* loaded from: classes3.dex */
public final /* synthetic */ class c implements DisplayObserver.OnForegroundAppChangedListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4031a;
    public final /* synthetic */ Object b;

    public /* synthetic */ c(Object obj, int i) {
        this.f4031a = i;
        this.b = obj;
    }

    @Override // com.mdisdk.observer.DisplayObserver.OnForegroundAppChangedListener
    public final void onForegroundAppChanged(ForegroundAppInfo foregroundAppInfo) {
        int i = this.f4031a;
        Object obj = this.b;
        switch (i) {
            case 0:
                FullScreenActivity.startLauncherWatcher$lambda$0$1((FullScreenActivity) obj, foregroundAppInfo);
                break;
            case 1:
                MainDisplayWatcher.onTaskReleased$lambda$1$0$1((MainDisplayWatcher) obj, foregroundAppInfo);
                break;
            default:
                ZyqlGuiAgentTask.registerForegroundAppObserver$lambda$1((ZyqlGuiAgentTask) obj, foregroundAppInfo);
                break;
        }
    }
}
