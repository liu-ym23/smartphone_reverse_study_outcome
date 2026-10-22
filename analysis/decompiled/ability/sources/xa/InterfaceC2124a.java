package xa;

import za.c;
import za.d;
import za.g;
import za.i;

/* renamed from: xa.a, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public interface InterfaceC2124a {
    void onStepCancelled(i iVar, g gVar);

    void onStepCompleted(i iVar, g gVar);

    void onStepExecuting(i iVar, g gVar);

    void onStepFailed(i iVar, g gVar, Throwable th);

    void onStepRetrying(i iVar, g gVar, int i);

    void onStepStarted(i iVar, g gVar);

    void onTaskCancelled(i iVar, String str);

    void onTaskCompleted(i iVar, d dVar);

    void onTaskCreated(i iVar);

    void onTaskFailed(i iVar, Throwable th);

    void onTaskPaused(i iVar);

    void onTaskRecoveredFromTakeover(i iVar);

    void onTaskRecoveryStarted(i iVar);

    void onTaskResumed(i iVar);

    void onTaskRunning(i iVar, c cVar);

    void onTaskStarted(i iVar);

    void onTaskTakenOver(i iVar, String str);
}
