package com.stepos.ailauncher.taskstore.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¨\u0006\u0004"}, d2 = {"sameDisplayContentAs", "", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCardEntity;", "other", "taskstore_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TaskInfoCardEntityKt {
    public static final boolean sameDisplayContentAs(TaskInfoCardEntity taskInfoCardEntity, TaskInfoCardEntity other) {
        p.i(taskInfoCardEntity, "<this>");
        p.i(other, "other");
        return p.d(TaskInfoCardEntity.copy$default(taskInfoCardEntity, null, null, other.getEventType(), other.getSeq(), other.getTs(), null, null, null, null, null, null, 0, 0, false, null, null, null, null, null, null, null, null, null, 0L, null, null, other.getUpdatedAt(), null, null, null, null, false, null, null, null, null, -67108893, 15, null), other);
    }
}
