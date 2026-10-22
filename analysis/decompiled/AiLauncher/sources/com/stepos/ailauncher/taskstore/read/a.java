package com.stepos.ailauncher.taskstore.read;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.taskstore.entity.TaskInfoCard;
import com.stepos.ailauncher.taskstore.entity.TaskInfoStatus;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;", Const.INTENT_KEY_APIKEY, "(Ljava/util/List;)Ljava/util/List;", "taskstore_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class a {
    public static final List<TaskInfoCard> a(List<TaskInfoCard> list) {
        p.i(list, "<this>");
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            TaskInfoCard taskInfoCard = (TaskInfoCard) obj;
            if (taskInfoCard.getReadAt() == null && (taskInfoCard.getStatus() == TaskInfoStatus.COMPLETED || taskInfoCard.getStatus() == TaskInfoStatus.FAILED)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }
}
