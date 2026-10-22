package com.stepos.ability.api.task.registry;

import com.stepos.ability.bean.InternalTask;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000f\u0010\u000eJ\u001f\u0010\u0011\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0004H&¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015À\u0006\u0003"}, d2 = {"Lcom/stepos/ability/api/task/registry/ITaskRegistry;", "", "Lcom/stepos/ability/bean/InternalTask;", "internalTask", "", "callingUid", "LC7/r;", "register", "(Lcom/stepos/ability/bean/InternalTask;I)V", "", GuiTaskProgressKt.GuiTaskProgress_KEY_TASK_ID, "get", "(Ljava/lang/String;)Lcom/stepos/ability/bean/InternalTask;", "getCallingUid", "(Ljava/lang/String;)Ljava/lang/Integer;", "getStatus", "status", "updateStatus", "(Ljava/lang/String;I)V", "unregister", "(Ljava/lang/String;)V", "api_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface ITaskRegistry {
    InternalTask get(String taskId);

    Integer getCallingUid(String taskId);

    Integer getStatus(String taskId);

    void register(InternalTask internalTask, int callingUid);

    void unregister(String taskId);

    void updateStatus(String taskId, int status);
}
