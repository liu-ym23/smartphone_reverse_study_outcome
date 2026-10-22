package com.stepos.ailauncher.task.search;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.search.TaskSearchRecord;
import com.stepos.ailauncher.taskstore.entity.TaskInfoCard;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a'\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00002\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0000H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003*\u00020\u0001H\u0000¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;", "cards", "Lcom/stepos/agentframework/chatcore/search/o;", Const.INTENT_KEY_APIKEY, "(Ljava/util/List;)Ljava/util/List;", Const.INTENT_KEY_PKGNAME, "(Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;)Lcom/stepos/agentframework/chatcore/search/o;", "task_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class b {
    public static final List<TaskSearchRecord> a(List<TaskInfoCard> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            TaskSearchRecord taskSearchRecordB = b((TaskInfoCard) it.next());
            if (taskSearchRecordB != null) {
                arrayList.add(taskSearchRecordB);
            }
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final com.stepos.agentframework.chatcore.search.TaskSearchRecord b(com.stepos.ailauncher.taskstore.entity.TaskInfoCard r12) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.p.i(r12, r0)
            java.lang.String r0 = r12.getRequestSessionKey()
            r1 = 0
            if (r0 == 0) goto L19
            boolean r2 = La.H.x0(r0)
            if (r2 != 0) goto L13
            goto L14
        L13:
            r0 = r1
        L14:
            if (r0 != 0) goto L17
            goto L19
        L17:
            r4 = r0
            goto L2a
        L19:
            java.lang.String r0 = r12.getSessionKey()
            if (r0 == 0) goto L26
            boolean r2 = La.H.x0(r0)
            if (r2 != 0) goto L26
            goto L27
        L26:
            r0 = r1
        L27:
            if (r0 != 0) goto L17
            return r1
        L2a:
            java.lang.String r3 = r12.getTaskId()
            java.lang.String r0 = r12.getTitle()
            if (r0 != 0) goto L36
            java.lang.String r0 = ""
        L36:
            boolean r2 = La.H.x0(r0)
            if (r2 == 0) goto L3f
            java.lang.String r0 = "未命名任务"
        L3f:
            r5 = r0
            com.stepos.ailauncher.task.space.TaskSearchTextExtractor r0 = com.stepos.ailauncher.task.space.TaskSearchTextExtractor.INSTANCE
            java.lang.String r6 = r0.p(r12)
            com.stepos.ailauncher.taskstore.entity.TaskInfoStatus r0 = r12.getStatus()
            java.lang.String r0 = r0.name()
            com.stepos.agentframework.adapter.netcore.BusTaskStatus r7 = com.stepos.agentframework.adapter.netcore.BusTaskStatus.valueOf(r0)
            long r8 = r12.getUpdatedAt()
            java.lang.Long r0 = java.lang.Long.valueOf(r8)
            long r8 = r0.longValue()
            r10 = 0
            int r2 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r2 <= 0) goto L65
            r1 = r0
        L65:
            if (r1 == 0) goto L6d
            long r0 = r1.longValue()
        L6b:
            r8 = r0
            goto L72
        L6d:
            long r0 = r12.getCreatedAt()
            goto L6b
        L72:
            java.lang.Long r10 = r12.getReadAt()
            com.stepos.agentframework.chatcore.search.o r2 = new com.stepos.agentframework.chatcore.search.o
            r2.<init>(r3, r4, r5, r6, r7, r8, r10)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.task.search.b.b(com.stepos.ailauncher.taskstore.entity.TaskInfoCard):com.stepos.agentframework.chatcore.search.o");
    }
}
