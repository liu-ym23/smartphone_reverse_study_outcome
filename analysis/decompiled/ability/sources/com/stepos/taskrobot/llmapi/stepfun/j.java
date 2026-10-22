package com.stepos.taskrobot.llmapi.stepfun;

import com.stepos.taskrobot.service.TaskRobotManagerImpl;

/* loaded from: classes3.dex */
public final /* synthetic */ class j implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4037a;
    public final /* synthetic */ String b;

    public /* synthetic */ j(String str, int i) {
        this.f4037a = i;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.f4037a;
        String str = this.b;
        switch (i) {
            case 0:
                SystemSdkBridge.cachePendingSurface$lambda$0(str);
                break;
            case 1:
                TaskRobotManagerImpl.resumeFullScreenOverlay$lambda$0(str);
                break;
            case 2:
                TaskRobotManagerImpl.dismissVoiceInput$lambda$0(str);
                break;
            case 3:
                TaskRobotManagerImpl.dismissFullScreenOverlay$lambda$0(str);
                break;
            case 4:
                TaskRobotManagerImpl.showFullScreenActivity$lambda$0(str);
                break;
            default:
                TaskRobotManagerImpl.hideFullScreenActivity$lambda$0(str);
                break;
        }
    }
}
