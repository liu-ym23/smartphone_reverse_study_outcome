package com.stepos.taskrobot.llmapi.stepfun;

import C7.r;
import android.content.Context;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import f6.AbstractC1436a;
import java.io.File;
import kotlin.Metadata;
import kotlin.Result;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/stepos/taskrobot/llmapi/stepfun/TaskEvidenceStore;", "", AppAgent.CONSTRUCT, "()V", "Landroid/content/Context;", "context", "", GuiTaskProgressKt.GuiTaskProgress_KEY_TASK_ID, "fileName", "content", "LC7/r;", "writeText", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "TAG", "Ljava/lang/String;", "stepfun_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TaskEvidenceStore {
    public static final TaskEvidenceStore INSTANCE = new TaskEvidenceStore();
    private static final String TAG = "TaskEvidenceStore";

    private TaskEvidenceStore() {
    }

    public final void writeText(Context context, String taskId, String fileName, String content) {
        Object objA;
        kotlin.jvm.internal.k.f(context, "context");
        kotlin.jvm.internal.k.f(taskId, "taskId");
        kotlin.jvm.internal.k.f(fileName, "fileName");
        kotlin.jvm.internal.k.f(content, "content");
        try {
            File file = new File(context.getFilesDir(), "tasks/".concat(taskId));
            if (!file.exists()) {
                file.mkdirs();
            }
            O7.i.Y(new File(file, fileName), content);
            AbstractC1436a.a(TAG, "writeText success path=" + file.getAbsolutePath() + "/" + fileName, true);
            objA = r.f317a;
        } catch (Throwable th) {
            objA = kotlin.b.a(th);
        }
        Throwable thA = Result.a(objA);
        if (thA != null) {
            AbstractC1436a.b(TAG, B7.a.n("writeText failed file=", fileName, " error=", thA.getMessage()), true);
        }
    }
}
