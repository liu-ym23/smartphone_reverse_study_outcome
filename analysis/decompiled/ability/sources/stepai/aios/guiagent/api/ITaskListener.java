package stepai.aios.guiagent.api;

import kotlin.Metadata;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\f\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0002H&¢\u0006\u0004\b\u0013\u0010\u0007J\u001f\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0002H&¢\u0006\u0004\b\u0015\u0010\u0007J'\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0002H&¢\u0006\u0004\b\u0018\u0010\u0019J/\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u0002H&¢\u0006\u0004\b\u001d\u0010\u001eJ\u001f\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0002H&¢\u0006\u0004\b\u001f\u0010\u0007J\u001f\u0010 \u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0002H&¢\u0006\u0004\b \u0010\u0007¨\u0006!À\u0006\u0003"}, d2 = {"Lstepai/aios/guiagent/api/ITaskListener;", "", "", "sessionId", "description", "LC7/r;", "onTaskCreated", "(Ljava/lang/String;Ljava/lang/String;)V", "onTaskStarted", "(Ljava/lang/String;)V", "Lstepai/aios/guiagent/api/TaskProgress;", "progress", "onTaskProgress", "(Ljava/lang/String;Lstepai/aios/guiagent/api/TaskProgress;)V", "Lstepai/aios/guiagent/api/TaskResult;", "result", "onTaskCompleted", "(Ljava/lang/String;Lstepai/aios/guiagent/api/TaskResult;)V", "reason", "onTaskCancelled", "errorMessage", "onTaskFailed", "stepId", "actionType", "onStepStarted", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "", "success", "message", "onStepCompleted", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "onBeforeScreenshot", "onAfterScreenshot", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface ITaskListener {
    void onAfterScreenshot(String sessionId, String stepId);

    void onBeforeScreenshot(String sessionId, String stepId);

    void onStepCompleted(String sessionId, String stepId, boolean success, String message);

    void onStepStarted(String sessionId, String stepId, String actionType);

    void onTaskCancelled(String sessionId, String reason);

    void onTaskCompleted(String sessionId, TaskResult result);

    void onTaskCreated(String sessionId, String description);

    void onTaskFailed(String sessionId, String errorMessage);

    void onTaskProgress(String sessionId, TaskProgress progress);

    void onTaskStarted(String sessionId);
}
