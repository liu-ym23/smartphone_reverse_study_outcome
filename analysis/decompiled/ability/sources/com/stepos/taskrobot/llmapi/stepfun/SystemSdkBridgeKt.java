package com.stepos.taskrobot.llmapi.stepfun;

import C7.r;
import com.mdisdk.Task;
import com.mdisdk.TaskManager;
import f6.AbstractC1436a;
import kotlin.Metadata;
import kotlin.Result;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001b\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0004\u0010\u0005*\f\b\u0000\u0010\u0007\"\u00020\u00062\u00020\u0006¨\u0006\b"}, d2 = {"Lcom/mdisdk/Task;", "", "ignoreActions", "LC7/r;", "finishWithRedirectCleanup", "(Lcom/mdisdk/Task;Z)V", "Lcom/stepos/taskrobot/llmapi/stepfun/FullScreenHelper$FullScreenTaskUiState;", "FullScreenTaskUiState", "stepfun_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SystemSdkBridgeKt {
    public static final void finishWithRedirectCleanup(Task task, boolean z10) {
        Object objA;
        kotlin.jvm.internal.k.f(task, "<this>");
        try {
            TaskManager.setRedirectActivity(null);
            objA = r.f317a;
        } catch (Throwable th) {
            objA = kotlin.b.a(th);
        }
        Throwable thA = Result.a(objA);
        if (thA != null) {
            AbstractC1436a.b("SystemSdkBridge", "clear redirect failed: " + thA.getMessage(), true);
        }
        task.finish(z10);
    }
}
