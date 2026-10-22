package com.stepos.taskrobot.llmapi.stepfun;

import android.graphics.Bitmap;
import com.mdisdk.observer.ForegroundAppFilter;
import com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask;

/* loaded from: classes3.dex */
public final /* synthetic */ class n implements S7.k {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4040a;

    public /* synthetic */ n(int i) {
        this.f4040a = i;
    }

    @Override // S7.k
    public final Object invoke(Object obj) {
        switch (this.f4040a) {
            case 0:
                return ZyqlGuiAgentTask.C11791.invokeSuspend$lambda$2((String) obj);
            case 1:
                return ZyqlGuiAgentTask.C11791.invokeSuspend$lambda$5((String) obj);
            case 2:
                return DebugInfoDialogListener.runOnMain$lambda$0((Runnable) obj);
            case 3:
                return DebugInfoDialogListener.resetForTest$lambda$0((Runnable) obj);
            case 4:
                return Boolean.valueOf(FullScreenHelper.llmTakeoverPendingProvider$lambda$0((String) obj));
            case 5:
                return GuiAgentInitializer.createConfig$lambda$1((Bitmap) obj);
            case 6:
                return MainDisplayWatcher.onTaskReleased$lambda$1$0$0((ForegroundAppFilter.Builder) obj);
            case 7:
                return Boolean.valueOf(SystemSdkBridge.init$lambda$0$1((String) obj));
            case 8:
                return SystemSdkBridge.onTaskCompleted$lambda$2((String) obj);
            case 9:
                return SystemSdkBridge.updateFullScreenTaskState$lambda$0((String) obj);
            case 10:
                return SystemSdkBridge.onFullScreenActivityBackground$lambda$0((String) obj);
            case 11:
                return SystemSdkBridge.recoverFromTakeover$lambda$0((String) obj);
            case 12:
                return SystemSdkBridge.onFullScreenActivityCreated$lambda$0((String) obj);
            case 13:
                return SystemSdkBridge.onFullScreenActivityDestroyed$lambda$0((String) obj);
            case 14:
                return SystemSdkBridge.showFullScreenActivity$lambda$0((String) obj);
            case 15:
                return SystemSdkBridge.showFullScreenForPackage$lambda$2((String) obj);
            case 16:
                return SystemSdkBridge.onFullScreenActivityForeground$lambda$0((String) obj);
            case 17:
                return SystemSdkBridge.onLlmRequestTakeover$lambda$0((String) obj);
            default:
                return SystemSdkBridge.init$lambda$0$0((String) obj);
        }
    }
}
