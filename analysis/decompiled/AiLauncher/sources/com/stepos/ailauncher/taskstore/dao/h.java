package com.stepos.ailauncher.taskstore.dao;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.taskstore.database.TaskInfoConverters;
import com.stepos.ailauncher.taskstore.entity.TaskInfoCardEntity;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a!\u0010\u0003\u001a\u00020\u00002\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001b\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0007\u0010\b\"\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCardEntity;", "existing", "incoming", Const.INTENT_KEY_PKGNAME, "(Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCardEntity;Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCardEntity;)Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCardEntity;", "other", "", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCardEntity;Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCardEntity;)Z", "", "TASK_INFO_CARD_DAO_TAG", "Ljava/lang/String;", "taskstore_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class h {
    private static final String TASK_INFO_CARD_DAO_TAG = "TaskInfoCardDao";

    public static final boolean a(TaskInfoCardEntity taskInfoCardEntity, TaskInfoCardEntity taskInfoCardEntity2) {
        return TaskInfoConverters.INSTANCE.b(taskInfoCardEntity.getVersionId(), taskInfoCardEntity.getVersion(), taskInfoCardEntity.getTaskVersion(), taskInfoCardEntity2.getVersionId(), taskInfoCardEntity2.getVersion(), taskInfoCardEntity2.getTaskVersion());
    }

    public static final TaskInfoCardEntity b(TaskInfoCardEntity taskInfoCardEntity, TaskInfoCardEntity incoming) {
        kotlin.jvm.internal.p.i(incoming, "incoming");
        if (taskInfoCardEntity == null) {
            return incoming;
        }
        boolean zA = a(taskInfoCardEntity, incoming);
        TaskInfoConverters taskInfoConverters = TaskInfoConverters.INSTANCE;
        if (!taskInfoConverters.c(taskInfoCardEntity.getStatus()) || taskInfoConverters.c(incoming.getStatus()) || !zA) {
            return (incoming.getResultJson() == null && taskInfoCardEntity.getResultJson() != null && zA) ? TaskInfoCardEntity.copy$default(incoming, null, null, null, null, null, null, null, null, null, null, null, 0, 0, false, null, null, null, null, null, null, null, null, null, 0L, null, null, 0L, taskInfoCardEntity.getResultJson(), null, null, null, false, null, null, null, null, -134217729, 15, null) : incoming;
        }
        String resultJson = incoming.getResultJson();
        if (resultJson == null) {
            resultJson = taskInfoCardEntity.getResultJson();
        }
        return TaskInfoCardEntity.copy$default(taskInfoCardEntity, null, null, null, null, null, null, null, null, null, null, null, 0, 0, false, null, null, null, null, null, null, null, null, null, 0L, null, null, 0L, resultJson, null, null, null, false, null, null, null, null, -134217729, 15, null);
    }
}
