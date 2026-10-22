package com.stepos.ability.bean;

import android.os.Bundle;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¨\u0006\u0004"}, d2 = {"deepCopy", "Lcom/stepos/ability/bean/Task;", "newTaskId", "", "bean_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TaskKt {
    public static final Task deepCopy(Task task, String str) {
        k.f(task, "<this>");
        String taskId = str == null ? task.getTaskId() : str;
        AppUI appUI = task.getAppUI();
        AppUI appUICopy = appUI != null ? appUI.copy((16383 & 1) != 0 ? appUI.id : null, (16383 & 2) != 0 ? appUI.uiType : 0, (16383 & 4) != 0 ? appUI.title : null, (16383 & 8) != 0 ? appUI.isFixed : false, (16383 & 16) != 0 ? appUI.appUIName : null, (16383 & 32) != 0 ? appUI.description : null, (16383 & 64) != 0 ? appUI.content : null, (16383 & 128) != 0 ? appUI.structuredContent : null, (16383 & 256) != 0 ? appUI.resultType : null, (16383 & 512) != 0 ? appUI.resultSrc : null, (16383 & 1024) != 0 ? appUI.resultContent : null, (16383 & 2048) != 0 ? appUI.packageName : null, (16383 & 4096) != 0 ? appUI.widgetCls : null, (16383 & 8192) != 0 ? appUI.widgetAction : null) : null;
        TaskError error = task.getError();
        TaskError taskErrorCopy$default = error != null ? TaskError.copy$default(error, 0, null, null, false, 15, null) : null;
        Bundle bundle = task.getBundle();
        return Task.copy$default(task, taskId, null, null, null, null, null, 0, 0, 0, 0, null, 0L, 0L, 0L, appUICopy, taskErrorCopy$default, null, bundle != null ? new Bundle(bundle) : null, 0, 344062, null);
    }

    public static /* synthetic */ Task deepCopy$default(Task task, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        return deepCopy(task, str);
    }
}
