package com.stepos.aiengine.adapter;

import android.os.Bundle;
import com.stepos.core.data.ContentParams;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/stepos/aiengine/adapter/TaskPriorityArg;", "", "<init>", "()V", "KEY", "", "applyTo", "", "builder", "Lcom/stepos/core/data/ContentParams$Builder;", "args", "Landroid/os/Bundle;", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class TaskPriorityArg {
    public static final TaskPriorityArg INSTANCE = new TaskPriorityArg();
    public static final String KEY = "task_priority";

    public final boolean applyTo(ContentParams.Builder builder, Bundle args) {
        p.i(builder, "builder");
        if (args == null || !args.containsKey("task_priority")) {
            return false;
        }
        builder.putInt("task_priority", args.getInt("task_priority"));
        return true;
    }
}
