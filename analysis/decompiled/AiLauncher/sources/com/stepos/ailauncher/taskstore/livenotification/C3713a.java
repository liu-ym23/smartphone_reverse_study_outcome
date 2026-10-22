package com.stepos.ailauncher.taskstore.livenotification;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.taskstore.entity.TaskInfoStatus;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/stepos/ailauncher/taskstore/entity/TaskInfoStatus;", "", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/ailauncher/taskstore/entity/TaskInfoStatus;)Z", "taskstore_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.taskstore.livenotification.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3713a {
    public static final boolean a(TaskInfoStatus taskInfoStatus) {
        kotlin.jvm.internal.p.i(taskInfoStatus, "<this>");
        return taskInfoStatus == TaskInfoStatus.COMPLETED || taskInfoStatus == TaskInfoStatus.FAILED;
    }
}
