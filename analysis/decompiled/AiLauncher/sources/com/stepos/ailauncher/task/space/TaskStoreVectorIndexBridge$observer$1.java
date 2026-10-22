package com.stepos.ailauncher.task.space;

import Z8.C1174w;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.taskstore.entity.TaskInfoCard;
import com.stepos.ailauncher.taskstore.vector.DataCenterVectorIndex;
import e9.InterfaceC4014c;
import f9.C4063a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001e\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0096@¢\u0006\u0004\b\u0006\u0010\u0007J\u001e\u0010\n\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0002H\u0096@¢\u0006\u0004\b\n\u0010\u0007¨\u0006\u000b"}, d2 = {"com/stepos/ailauncher/task/space/TaskStoreVectorIndexBridge$observer$1", "Lcom/stepos/ailauncher/taskstore/i;", "", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;", "cards", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Ljava/util/List;Le9/c;)Ljava/lang/Object;", "", "taskIds", Const.INTENT_KEY_UMID, "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TaskStoreVectorIndexBridge$observer$1 implements com.stepos.ailauncher.taskstore.i {
    @Override // com.stepos.ailauncher.taskstore.i
    public Object b(List<TaskInfoCard> list, InterfaceC4014c<? super Y8.t> interfaceC4014c) throws Throwable {
        DataCenterVectorIndex dataCenterVectorIndex = DataCenterVectorIndex.INSTANCE;
        List<TaskInfoCard> list2 = list;
        ArrayList arrayList = new ArrayList(C1174w.x(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(TaskStoreVectorIndexBridge.INSTANCE.c((TaskInfoCard) it.next()));
        }
        Object objA = dataCenterVectorIndex.A(arrayList, interfaceC4014c);
        return objA == C4063a.g() ? objA : Y8.t.f7040a;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.stepos.ailauncher.taskstore.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object d(java.util.List<java.lang.String> r10, e9.InterfaceC4014c<? super Y8.t> r11) throws java.lang.Throwable {
        /*
            r9 = this;
            boolean r0 = r11 instanceof com.stepos.ailauncher.task.space.TaskStoreVectorIndexBridge$observer$1$onTaskIdsDeleted$1
            if (r0 == 0) goto L13
            r0 = r11
            com.stepos.ailauncher.task.space.TaskStoreVectorIndexBridge$observer$1$onTaskIdsDeleted$1 r0 = (com.stepos.ailauncher.task.space.TaskStoreVectorIndexBridge$observer$1$onTaskIdsDeleted$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.ailauncher.task.space.TaskStoreVectorIndexBridge$observer$1$onTaskIdsDeleted$1 r0 = new com.stepos.ailauncher.task.space.TaskStoreVectorIndexBridge$observer$1$onTaskIdsDeleted$1
            r0.<init>(r9, r11)
        L18:
            java.lang.Object r9 = r0.result
            java.lang.Object r11 = f9.C4063a.g()
            int r1 = r0.label
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L46
            if (r1 != r3) goto L3e
            int r10 = r0.I$0
            java.lang.Object r1 = r0.L$4
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r1 = r0.L$2
            java.util.Iterator r1 = (java.util.Iterator) r1
            java.lang.Object r4 = r0.L$1
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            java.lang.Object r5 = r0.L$0
            java.util.List r5 = (java.util.List) r5
            kotlin.C4849c.b(r9)
            r9 = r10
            r10 = r5
            goto L52
        L3e:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L46:
            kotlin.C4849c.b(r9)
            r9 = r10
            java.lang.Iterable r9 = (java.lang.Iterable) r9
            java.util.Iterator r1 = r9.iterator()
            r4 = r9
            r9 = r2
        L52:
            boolean r5 = r1.hasNext()
            if (r5 == 0) goto L88
            java.lang.Object r5 = r1.next()
            r6 = r5
            java.lang.String r6 = (java.lang.String) r6
            com.stepos.ailauncher.taskstore.vector.DataCenterVectorIndex r7 = com.stepos.ailauncher.taskstore.vector.DataCenterVectorIndex.INSTANCE
            java.lang.Object r8 = g9.h.a(r10)
            r0.L$0 = r8
            java.lang.Object r8 = g9.h.a(r4)
            r0.L$1 = r8
            r0.L$2 = r1
            java.lang.Object r5 = g9.h.a(r5)
            r0.L$3 = r5
            java.lang.Object r5 = g9.h.a(r6)
            r0.L$4 = r5
            r0.I$0 = r9
            r0.I$1 = r2
            r0.label = r3
            java.lang.Object r5 = r7.t(r6, r0)
            if (r5 != r11) goto L52
            return r11
        L88:
            Y8.t r9 = Y8.t.f7040a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.task.space.TaskStoreVectorIndexBridge$observer$1.d(java.util.List, e9.c):java.lang.Object");
    }
}
