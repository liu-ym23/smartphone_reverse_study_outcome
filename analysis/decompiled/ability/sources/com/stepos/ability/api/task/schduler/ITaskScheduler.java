package com.stepos.ability.api.task.schduler;

import C7.r;
import H7.c;
import com.stepos.ability.bean.InternalTask;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J*\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004H¦@¢\u0006\u0004\b\b\u0010\t¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lcom/stepos/ability/api/task/schduler/ITaskScheduler;", "", "Lcom/stepos/ability/bean/InternalTask;", "task", "", "callingUid", "callingPid", "LC7/r;", "schedule", "(Lcom/stepos/ability/bean/InternalTask;IILH7/c;)Ljava/lang/Object;", "api_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface ITaskScheduler {
    static /* synthetic */ Object schedule$default(ITaskScheduler iTaskScheduler, InternalTask internalTask, int i, int i6, c cVar, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: schedule");
        }
        if ((i10 & 4) != 0) {
            i6 = 0;
        }
        return iTaskScheduler.schedule(internalTask, i, i6, cVar);
    }

    Object schedule(InternalTask internalTask, int i, int i6, c<? super r> cVar);
}
