package com.stepos.ailauncher.taskstore.chat;

import android.content.Context;
import android.content.res.Resources;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.taskstore.widget.C3735a;
import com.stepos.ailauncher.taskstore.widget.TaskResultFileRowView;
import h8.C4148a;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00102\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000e\u0010\u0005R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/stepos/ailauncher/taskstore/chat/d;", "Lcom/stepos/agentframework/chatui/appui/a;", "Lcom/stepos/ailauncher/taskstore/widget/TaskResultFileRowView;", "Lcom/stepos/ailauncher/taskstore/chat/I;", "<init>", "()V", "data", "LY8/t;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Lcom/stepos/ailauncher/taskstore/chat/I;)V", "Landroid/content/Context;", "context", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Landroid/content/Context;)Lcom/stepos/ailauncher/taskstore/widget/TaskResultFileRowView;", Const.INTENT_KEY_BACKGROUND_COMMAND, "Lcom/stepos/ailauncher/taskstore/chat/I;", "Companion", Const.INTENT_KEY_APIKEY, "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.taskstore.chat.d, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3701d extends com.stepos.agentframework.chatui.appui.a<TaskResultFileRowView, TaskResultFilePayload> {
    public static final String APP_UI_NAME = "app_ui_name_task_result_file";
    private static final String TAG = "ChatTaskResultFileBridge";
    private TaskResultFilePayload data;

    @Override // com.stepos.agentframework.chatui.appui.a
    public void g() {
        Object objB;
        Y8.t tVar;
        try {
            Result.Companion companion = Result.INSTANCE;
            TaskResultFileRowView taskResultFileRowViewC = c();
            if (taskResultFileRowViewC != null) {
                taskResultFileRowViewC.W();
                tVar = Y8.t.f7040a;
            } else {
                tVar = null;
            }
            objB = Result.b(tVar);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.t(TAG, "recycle view failed", thE, false, 8, null);
        }
        this.data = null;
    }

    @Override // com.stepos.agentframework.chatui.appui.a
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public TaskResultFileRowView b(Context context) throws Resources.NotFoundException {
        kotlin.jvm.internal.p.i(context, "context");
        TaskResultFileRowView taskResultFileRowView = new TaskResultFileRowView(context, null, 2, null);
        taskResultFileRowView.A(this.data);
        C3735a.a(taskResultFileRowView);
        return taskResultFileRowView;
    }

    @Override // com.stepos.agentframework.chatui.appui.a
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public void f(TaskResultFilePayload data) throws Resources.NotFoundException {
        kotlin.jvm.internal.p.i(data, "data");
        this.data = data;
        C4148a.k(TAG, "onInitData artifacts=" + data.b().size() + " taskId=" + data.getTaskId(), false, 4, null);
        TaskResultFileRowView taskResultFileRowViewC = c();
        if (taskResultFileRowViewC != null) {
            taskResultFileRowViewC.A(data);
        }
    }
}
