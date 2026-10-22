package com.stepos.ailauncher.foundation.task;

import La.H;
import Y8.t;
import android.annotation.SuppressLint;
import android.content.Context;
import b6.InterfaceC1452a;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.contract.api.taskstore.ITaskStoreService;
import e9.InterfaceC4014c;
import f9.C4063a;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u001c\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0086@¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0086@¢\u0006\u0004\b\n\u0010\u000bJ,\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u000e2\u000e\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\fH\u0086@¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0016\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0013H\u0086@¢\u0006\u0004\b\u0017\u0010\u0007J\u0018\u0010\u0019\u001a\u00020\u00182\u0006\u0010\t\u001a\u00020\bH\u0086@¢\u0006\u0004\b\u0019\u0010\u000bJ\u0018\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\bH\u0086@¢\u0006\u0004\b\u001b\u0010\u000bJ$\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00042\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\b0\u0004H\u0086@¢\u0006\u0004\b\u001e\u0010\u001fJ*\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020!0\u000e2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\b0\u0004H\u0086@¢\u0006\u0004\b\"\u0010\u001fR\u0018\u0010$\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010'\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b'\u0010(¨\u0006)"}, d2 = {"Lcom/stepos/ailauncher/foundation/task/TaskModule;", "", "<init>", "()V", "", "Lcom/stepos/ailauncher/foundation/task/entity/UiTask;", "f", "(Le9/c;)Ljava/lang/Object;", "", "taskId", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "", "taskIds", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Ljava/lang/Iterable;Le9/c;)Ljava/lang/Object;", "Lb6/a;", "callback", "LY8/t;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Lb6/a;)V", "l", Const.INTENT_KEY_UMID, "", Const.INTENT_KEY_PKGNAME, "sessionId", "c", "sessionKeys", "Lcom/stepos/ailauncher/contract/model/SessionArtifact;", "e", "(Ljava/util/List;Le9/c;)Ljava/lang/Object;", "fileIds", "Lcom/stepos/ailauncher/contract/model/ArtifactAvailability;", Const.INTENT_KEY_BACKGROUND_COMMAND, "Landroid/content/Context;", "appContext", "Landroid/content/Context;", "Lcom/stepos/ailauncher/foundation/task/b;", "dbHelper", "Lcom/stepos/ailauncher/foundation/task/b;", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TaskModule {
    public static final TaskModule INSTANCE = new TaskModule();
    private static Context appContext;

    @SuppressLint({"StaticFieldLeak"})
    private static b dbHelper;

    public static final boolean k(String it) {
        p.i(it, "it");
        return !H.x0(it);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(java.lang.String r5, e9.InterfaceC4014c<? super java.lang.Boolean> r6) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.stepos.ailauncher.foundation.task.TaskModule$cancelTask$1
            if (r0 == 0) goto L13
            r0 = r6
            com.stepos.ailauncher.foundation.task.TaskModule$cancelTask$1 r0 = (com.stepos.ailauncher.foundation.task.TaskModule$cancelTask$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.ailauncher.foundation.task.TaskModule$cancelTask$1 r0 = new com.stepos.ailauncher.foundation.task.TaskModule$cancelTask$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r4 = r0.result
            java.lang.Object r6 = f9.C4063a.g()
            int r1 = r0.label
            r2 = 1
            if (r1 == 0) goto L35
            if (r1 != r2) goto L2d
            java.lang.Object r5 = r0.L$0
            java.lang.String r5 = (java.lang.String) r5
            kotlin.C4849c.b(r4)
            goto L53
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L35:
            kotlin.C4849c.b(r4)
            D5.a r4 = D5.a.INSTANCE
            java.lang.Class<com.stepos.ailauncher.contract.api.taskstore.ITaskStoreService> r1 = com.stepos.ailauncher.contract.api.taskstore.ITaskStoreService.class
            java.lang.Object r4 = r4.a(r1)
            com.stepos.ailauncher.contract.api.taskstore.ITaskStoreService r4 = (com.stepos.ailauncher.contract.api.taskstore.ITaskStoreService) r4
            if (r4 == 0) goto L5a
            java.lang.Object r1 = g9.h.a(r5)
            r0.L$0 = r1
            r0.label = r2
            java.lang.Object r4 = r4.cancelTask(r5, r0)
            if (r4 != r6) goto L53
            return r6
        L53:
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            goto L5b
        L5a:
            r4 = 0
        L5b:
            java.lang.Boolean r4 = g9.C4109a.a(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.foundation.task.TaskModule.b(java.lang.String, e9.c):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0072, code lost:
    
        if (r13 == r1) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0116, code lost:
    
        if (r13 == r1) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0118, code lost:
    
        return r1;
     */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x0116 -> B:48:0x0119). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(java.lang.String r12, e9.InterfaceC4014c<? super java.lang.Boolean> r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 310
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.foundation.task.TaskModule.c(java.lang.String, e9.c):java.lang.Object");
    }

    public final Object d(InterfaceC4014c<? super t> interfaceC4014c) {
        Object objCleanAll;
        ITaskStoreService iTaskStoreService = (ITaskStoreService) D5.a.INSTANCE.a(ITaskStoreService.class);
        return (iTaskStoreService == null || (objCleanAll = iTaskStoreService.cleanAll(interfaceC4014c)) != C4063a.g()) ? t.f7040a : objCleanAll;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object e(java.util.List<java.lang.String> r5, e9.InterfaceC4014c<? super java.util.List<com.stepos.ailauncher.contract.model.SessionArtifact>> r6) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.stepos.ailauncher.foundation.task.TaskModule$getSessionArtifacts$1
            if (r0 == 0) goto L13
            r0 = r6
            com.stepos.ailauncher.foundation.task.TaskModule$getSessionArtifacts$1 r0 = (com.stepos.ailauncher.foundation.task.TaskModule$getSessionArtifacts$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.ailauncher.foundation.task.TaskModule$getSessionArtifacts$1 r0 = new com.stepos.ailauncher.foundation.task.TaskModule$getSessionArtifacts$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r4 = r0.result
            java.lang.Object r6 = f9.C4063a.g()
            int r1 = r0.label
            r2 = 1
            if (r1 == 0) goto L35
            if (r1 != r2) goto L2d
            java.lang.Object r5 = r0.L$0
            java.util.List r5 = (java.util.List) r5
            kotlin.C4849c.b(r4)
            goto L53
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L35:
            kotlin.C4849c.b(r4)
            D5.a r4 = D5.a.INSTANCE
            java.lang.Class<com.stepos.ailauncher.contract.api.taskstore.ITaskStoreService> r1 = com.stepos.ailauncher.contract.api.taskstore.ITaskStoreService.class
            java.lang.Object r4 = r4.a(r1)
            com.stepos.ailauncher.contract.api.taskstore.ITaskStoreService r4 = (com.stepos.ailauncher.contract.api.taskstore.ITaskStoreService) r4
            if (r4 == 0) goto L59
            java.lang.Object r1 = g9.h.a(r5)
            r0.L$0 = r1
            r0.label = r2
            java.lang.Object r4 = r4.getSessionArtifacts(r5, r0)
            if (r4 != r6) goto L53
            return r6
        L53:
            java.util.List r4 = (java.util.List) r4
            if (r4 != 0) goto L58
            goto L59
        L58:
            return r4
        L59:
            java.util.List r4 = Z8.C1173v.m()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.foundation.task.TaskModule.e(java.util.List, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object f(e9.InterfaceC4014c<? super java.util.List<com.stepos.ailauncher.foundation.task.entity.UiTask>> r23) {
        /*
            r22 = this;
            r0 = r23
            boolean r1 = r0 instanceof com.stepos.ailauncher.foundation.task.TaskModule$getUnfinishedTaskList$1
            if (r1 == 0) goto L15
            r1 = r0
            com.stepos.ailauncher.foundation.task.TaskModule$getUnfinishedTaskList$1 r1 = (com.stepos.ailauncher.foundation.task.TaskModule$getUnfinishedTaskList$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L15
            int r2 = r2 - r3
            r1.label = r2
            goto L1c
        L15:
            com.stepos.ailauncher.foundation.task.TaskModule$getUnfinishedTaskList$1 r1 = new com.stepos.ailauncher.foundation.task.TaskModule$getUnfinishedTaskList$1
            r2 = r22
            r1.<init>(r2, r0)
        L1c:
            java.lang.Object r0 = r1.result
            java.lang.Object r2 = f9.C4063a.g()
            int r3 = r1.label
            r4 = 1
            if (r3 == 0) goto L35
            if (r3 != r4) goto L2d
            kotlin.C4849c.b(r0)
            goto L4d
        L2d:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L35:
            kotlin.C4849c.b(r0)
            D5.a r0 = D5.a.INSTANCE
            java.lang.Class<com.stepos.ailauncher.contract.api.taskstore.ITaskStoreService> r3 = com.stepos.ailauncher.contract.api.taskstore.ITaskStoreService.class
            java.lang.Object r0 = r0.a(r3)
            com.stepos.ailauncher.contract.api.taskstore.ITaskStoreService r0 = (com.stepos.ailauncher.contract.api.taskstore.ITaskStoreService) r0
            if (r0 == 0) goto L99
            r1.label = r4
            java.lang.Object r0 = r0.getUnfinishedTasks(r1)
            if (r0 != r2) goto L4d
            return r2
        L4d:
            java.util.List r0 = (java.util.List) r0
            if (r0 == 0) goto L99
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.ArrayList r1 = new java.util.ArrayList
            r2 = 10
            int r2 = Z8.C1174w.x(r0, r2)
            r1.<init>(r2)
            java.util.Iterator r0 = r0.iterator()
        L62:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L98
            java.lang.Object r2 = r0.next()
            com.stepos.ailauncher.contract.model.UnfinishedTaskInfo r2 = (com.stepos.ailauncher.contract.model.UnfinishedTaskInfo) r2
            java.lang.String r4 = r2.getTaskId()
            int r11 = r2.getStatus()
            java.lang.String r7 = r2.getRequestedSessionKey()
            com.stepos.ailauncher.foundation.task.entity.UiTask r3 = new com.stepos.ailauncher.foundation.task.entity.UiTask
            r20 = 16246(0x3f76, float:2.2765E-41)
            r21 = 0
            r5 = 0
            r6 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r12 = 0
            r14 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r14, r16, r17, r18, r19, r20, r21)
            r1.add(r3)
            goto L62
        L98:
            return r1
        L99:
            java.util.List r0 = Z8.C1173v.m()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.foundation.task.TaskModule.f(e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00b6 A[LOOP:0: B:35:0x00b0->B:37:0x00b6, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object g(java.util.List<java.lang.String> r7, e9.InterfaceC4014c<? super java.util.Map<java.lang.String, ? extends com.stepos.ailauncher.contract.model.ArtifactAvailability>> r8) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.stepos.ailauncher.foundation.task.TaskModule$queryArtifactAvailability$1
            if (r0 == 0) goto L13
            r0 = r8
            com.stepos.ailauncher.foundation.task.TaskModule$queryArtifactAvailability$1 r0 = (com.stepos.ailauncher.foundation.task.TaskModule$queryArtifactAvailability$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.ailauncher.foundation.task.TaskModule$queryArtifactAvailability$1 r0 = new com.stepos.ailauncher.foundation.task.TaskModule$queryArtifactAvailability$1
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r8 = f9.C4063a.g()
            int r1 = r0.label
            r2 = 1
            if (r1 == 0) goto L39
            if (r1 != r2) goto L31
            java.lang.Object r7 = r0.L$1
            java.util.List r7 = (java.util.List) r7
            java.lang.Object r8 = r0.L$0
            java.util.List r8 = (java.util.List) r8
            kotlin.C4849c.b(r6)
            goto L8e
        L31:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L39:
            kotlin.C4849c.b(r6)
            r6 = r7
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Iterator r6 = r6.iterator()
        L48:
            boolean r3 = r6.hasNext()
            if (r3 == 0) goto L5f
            java.lang.Object r3 = r6.next()
            r4 = r3
            java.lang.String r4 = (java.lang.String) r4
            boolean r4 = La.H.x0(r4)
            if (r4 != 0) goto L48
            r1.add(r3)
            goto L48
        L5f:
            java.util.List r6 = Z8.F.g0(r1)
            boolean r1 = r6.isEmpty()
            if (r1 == 0) goto L6e
            java.util.Map r6 = kotlin.collections.a.i()
            return r6
        L6e:
            D5.a r1 = D5.a.INSTANCE
            java.lang.Class<com.stepos.ailauncher.contract.api.taskstore.ITaskStoreService> r3 = com.stepos.ailauncher.contract.api.taskstore.ITaskStoreService.class
            java.lang.Object r1 = r1.a(r3)
            com.stepos.ailauncher.contract.api.taskstore.ITaskStoreService r1 = (com.stepos.ailauncher.contract.api.taskstore.ITaskStoreService) r1
            if (r1 == 0) goto L95
            java.lang.Object r7 = g9.h.a(r7)
            r0.L$0 = r7
            r0.L$1 = r6
            r0.label = r2
            java.lang.Object r7 = r1.queryArtifactAvailability(r6, r0)
            if (r7 != r8) goto L8b
            return r8
        L8b:
            r5 = r7
            r7 = r6
            r6 = r5
        L8e:
            java.util.Map r6 = (java.util.Map) r6
            if (r6 != 0) goto L94
            r6 = r7
            goto L95
        L94:
            return r6
        L95:
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.LinkedHashMap r7 = new java.util.LinkedHashMap
            r8 = 10
            int r8 = Z8.C1174w.x(r6, r8)
            int r8 = Z8.Q.e(r8)
            r0 = 16
            int r8 = v9.C5685n.f(r8, r0)
            r7.<init>(r8)
            java.util.Iterator r6 = r6.iterator()
        Lb0:
            boolean r8 = r6.hasNext()
            if (r8 == 0) goto Lc3
            java.lang.Object r8 = r6.next()
            r0 = r8
            java.lang.String r0 = (java.lang.String) r0
            com.stepos.ailauncher.contract.model.ArtifactAvailability r0 = com.stepos.ailauncher.contract.model.ArtifactAvailability.UNKNOWN
            r7.put(r8, r0)
            goto Lb0
        Lc3:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.foundation.task.TaskModule.g(java.util.List, e9.c):java.lang.Object");
    }

    public final void h(InterfaceC1452a callback) {
        p.i(callback, "callback");
        b6.b.INSTANCE.a(callback);
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:47:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object i(java.lang.String r7, e9.InterfaceC4014c<? super java.lang.String> r8) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.stepos.ailauncher.foundation.task.TaskModule$trackTaskStatus$1
            if (r0 == 0) goto L13
            r0 = r8
            com.stepos.ailauncher.foundation.task.TaskModule$trackTaskStatus$1 r0 = (com.stepos.ailauncher.foundation.task.TaskModule$trackTaskStatus$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.ailauncher.foundation.task.TaskModule$trackTaskStatus$1 r0 = new com.stepos.ailauncher.foundation.task.TaskModule$trackTaskStatus$1
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 0
            java.lang.String r4 = "completed"
            r5 = 1
            if (r2 == 0) goto L3e
            if (r2 != r5) goto L36
            java.lang.Object r6 = r0.L$1
            com.stepos.ailauncher.foundation.task.TaskModule r6 = (com.stepos.ailauncher.foundation.task.TaskModule) r6
            java.lang.Object r6 = r0.L$0
            java.lang.String r6 = (java.lang.String) r6
            kotlin.C4849c.b(r8)     // Catch: java.lang.Throwable -> L34
            goto L70
        L34:
            r6 = move-exception
            goto L79
        L36:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3e:
            kotlin.C4849c.b(r8)
            if (r7 == 0) goto L9d
            boolean r8 = La.H.x0(r7)
            if (r8 == 0) goto L4a
            goto L9d
        L4a:
            kotlin.Result$a r8 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L34
            D5.a r8 = D5.a.INSTANCE     // Catch: java.lang.Throwable -> L34
            java.lang.Class<com.stepos.ailauncher.contract.api.taskstore.ITaskStoreService> r2 = com.stepos.ailauncher.contract.api.taskstore.ITaskStoreService.class
            java.lang.Object r8 = r8.a(r2)     // Catch: java.lang.Throwable -> L34
            com.stepos.ailauncher.contract.api.taskstore.ITaskStoreService r8 = (com.stepos.ailauncher.contract.api.taskstore.ITaskStoreService) r8     // Catch: java.lang.Throwable -> L34
            if (r8 == 0) goto L73
            java.lang.Object r2 = g9.h.a(r7)     // Catch: java.lang.Throwable -> L34
            r0.L$0 = r2     // Catch: java.lang.Throwable -> L34
            java.lang.Object r6 = g9.h.a(r6)     // Catch: java.lang.Throwable -> L34
            r0.L$1 = r6     // Catch: java.lang.Throwable -> L34
            r6 = 0
            r0.I$0 = r6     // Catch: java.lang.Throwable -> L34
            r0.label = r5     // Catch: java.lang.Throwable -> L34
            java.lang.Object r8 = r8.getTaskStatus(r7, r0)     // Catch: java.lang.Throwable -> L34
            if (r8 != r1) goto L70
            return r1
        L70:
            java.lang.Integer r8 = (java.lang.Integer) r8     // Catch: java.lang.Throwable -> L34
            goto L74
        L73:
            r8 = r3
        L74:
            java.lang.Object r6 = kotlin.Result.b(r8)     // Catch: java.lang.Throwable -> L34
            goto L83
        L79:
            kotlin.Result$a r7 = kotlin.Result.INSTANCE
            java.lang.Object r6 = kotlin.C4849c.a(r6)
            java.lang.Object r6 = kotlin.Result.b(r6)
        L83:
            boolean r7 = kotlin.Result.g(r6)
            if (r7 == 0) goto L8a
            goto L8b
        L8a:
            r3 = r6
        L8b:
            java.lang.Integer r3 = (java.lang.Integer) r3
            if (r3 == 0) goto L9d
            int r6 = r3.intValue()
            M5.c r7 = M5.c.INSTANCE
            java.lang.String r6 = r7.v(r6)
            if (r6 != 0) goto L9c
            goto L9d
        L9c:
            r4 = r6
        L9d:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.foundation.task.TaskModule.i(java.lang.String, e9.c):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00d8 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r5v5, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v6, types: [java.util.Map] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x00cb -> B:21:0x00cf). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object j(java.lang.Iterable<java.lang.String> r14, e9.InterfaceC4014c<? super java.util.Map<java.lang.String, java.lang.String>> r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 217
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.foundation.task.TaskModule.j(java.lang.Iterable, e9.c):java.lang.Object");
    }

    public final void l(InterfaceC1452a callback) {
        p.i(callback, "callback");
        b6.b.INSTANCE.c(callback);
    }
}
