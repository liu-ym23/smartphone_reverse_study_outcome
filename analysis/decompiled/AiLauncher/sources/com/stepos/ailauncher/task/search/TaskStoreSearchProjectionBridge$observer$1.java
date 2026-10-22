package com.stepos.ailauncher.task.search;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.taskstore.i;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001e\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0096@¢\u0006\u0004\b\u0006\u0010\u0007J\u001e\u0010\n\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0002H\u0096@¢\u0006\u0004\b\n\u0010\u0007¨\u0006\u000b"}, d2 = {"com/stepos/ailauncher/task/search/TaskStoreSearchProjectionBridge$observer$1", "Lcom/stepos/ailauncher/taskstore/i;", "", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;", "cards", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Ljava/util/List;Le9/c;)Ljava/lang/Object;", "", "taskIds", Const.INTENT_KEY_UMID, "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TaskStoreSearchProjectionBridge$observer$1 implements i {
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0091, code lost:
    
        if (r0.b(r1) == r2) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0112, code lost:
    
        if (r5 == r2) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x016d, code lost:
    
        if (r0.d(r5, r1) == r2) goto L43;
     */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x0112 -> B:31:0x0115). Please report as a decompilation issue!!! */
    @Override // com.stepos.ailauncher.taskstore.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object b(java.util.List<com.stepos.ailauncher.taskstore.entity.TaskInfoCard> r19, e9.InterfaceC4014c<? super Y8.t> r20) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 371
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.task.search.TaskStoreSearchProjectionBridge$observer$1.b(java.util.List, e9.c):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x005e, code lost:
    
        if (r4.a(r5, r0) == r6) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.stepos.ailauncher.taskstore.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object d(java.util.List<java.lang.String> r5, e9.InterfaceC4014c<? super Y8.t> r6) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.stepos.ailauncher.task.search.TaskStoreSearchProjectionBridge$observer$1$onTaskIdsDeleted$1
            if (r0 == 0) goto L13
            r0 = r6
            com.stepos.ailauncher.task.search.TaskStoreSearchProjectionBridge$observer$1$onTaskIdsDeleted$1 r0 = (com.stepos.ailauncher.task.search.TaskStoreSearchProjectionBridge$observer$1$onTaskIdsDeleted$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.ailauncher.task.search.TaskStoreSearchProjectionBridge$observer$1$onTaskIdsDeleted$1 r0 = new com.stepos.ailauncher.task.search.TaskStoreSearchProjectionBridge$observer$1$onTaskIdsDeleted$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r4 = r0.result
            java.lang.Object r6 = f9.C4063a.g()
            int r1 = r0.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L40
            if (r1 == r3) goto L38
            if (r1 != r2) goto L30
            java.lang.Object r5 = r0.L$0
            java.util.List r5 = (java.util.List) r5
            kotlin.C4849c.b(r4)
            goto L61
        L30:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L38:
            java.lang.Object r5 = r0.L$0
            java.util.List r5 = (java.util.List) r5
            kotlin.C4849c.b(r4)
            goto L50
        L40:
            kotlin.C4849c.b(r4)
            com.stepos.ailauncher.task.search.TaskStoreSearchProjectionBridge r4 = com.stepos.ailauncher.task.search.TaskStoreSearchProjectionBridge.INSTANCE
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r4 = r4.b(r0)
            if (r4 != r6) goto L50
            goto L60
        L50:
            com.stepos.agentframework.chatcore.search.TaskSearchSnapshotStore r4 = com.stepos.agentframework.chatcore.search.TaskSearchSnapshotStore.INSTANCE
            java.lang.Object r1 = g9.h.a(r5)
            r0.L$0 = r1
            r0.label = r2
            java.lang.Object r4 = r4.a(r5, r0)
            if (r4 != r6) goto L61
        L60:
            return r6
        L61:
            Y8.t r4 = Y8.t.f7040a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.task.search.TaskStoreSearchProjectionBridge$observer$1.d(java.util.List, e9.c):java.lang.Object");
    }
}
