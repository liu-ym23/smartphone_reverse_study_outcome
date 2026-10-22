package com.stepos.ailauncher.taskstore.service;

import La.H;
import Y8.t;
import Z8.C1173v;
import Z8.F;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.contract.api.taskstore.ITaskStoreService;
import com.stepos.ailauncher.contract.model.ArtifactAvailability;
import com.stepos.ailauncher.contract.model.SessionArtifact;
import com.stepos.ailauncher.taskstore.TaskStoreModule;
import com.stepos.ailauncher.taskstore.sync.TaskSyncManager;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0005\u001a\u00020\u0004H\u0096@¢\u0006\u0004\b\u0005\u0010\u0006J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0096@¢\u0006\u0004\b\t\u0010\u0006J\u001a\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000b\u001a\u00020\nH\u0096@¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\nH\u0096@¢\u0006\u0004\b\u0010\u0010\u000eJ\u001e\u0010\u0012\u001a\u00020\u000f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\u0007H\u0096@¢\u0006\u0004\b\u0012\u0010\u0013J\u001e\u0010\u0014\u001a\u00020\u00042\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\u0007H\u0096@¢\u0006\u0004\b\u0014\u0010\u0013J\u001d\u0010\u0015\u001a\u00020\u00042\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\u0007H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J$\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00072\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\u0007H\u0096@¢\u0006\u0004\b\u0018\u0010\u0013J*\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u001b0\u001a2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\n0\u0007H\u0096@¢\u0006\u0004\b\u001c\u0010\u0013¨\u0006\u001f"}, d2 = {"Lcom/stepos/ailauncher/taskstore/service/TaskStoreServiceImpl;", "Lcom/stepos/ailauncher/contract/api/taskstore/ITaskStoreService;", "<init>", "()V", "LY8/t;", "cleanAll", "(Le9/c;)Ljava/lang/Object;", "", "Lcom/stepos/ailauncher/contract/model/UnfinishedTaskInfo;", "getUnfinishedTasks", "", "taskId", "", "getTaskStatus", "(Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "", "cancelTask", "sessionKeys", "deleteSessionTasks", "(Ljava/util/List;Le9/c;)Ljava/lang/Object;", "forgetLocalSession", "releaseSessionDeletionGuard", "(Ljava/util/List;)V", "Lcom/stepos/ailauncher/contract/model/SessionArtifact;", "getSessionArtifacts", "fileIds", "", "Lcom/stepos/ailauncher/contract/model/ArtifactAvailability;", "queryArtifactAvailability", "Companion", Const.INTENT_KEY_APIKEY, "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TaskStoreServiceImpl implements ITaskStoreService {
    private static final a Companion = new a(null);
    private static final String TAG = "TaskStoreServiceImpl";

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/ailauncher/taskstore/service/TaskStoreServiceImpl$a;", "", "<init>", "()V", "", "TAG", "Ljava/lang/String;", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a {
        public /* synthetic */ a(i iVar) {
            this();
        }

        public a() {
        }
    }

    @InterfaceC4112d(c = "com.stepos.ailauncher.taskstore.service.TaskStoreServiceImpl", f = "TaskStoreServiceImpl.kt", l = {52, 53}, m = "deleteSessionTasks", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.taskstore.service.TaskStoreServiceImpl$deleteSessionTasks$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TaskStoreServiceImpl.this.deleteSessionTasks(null, this);
        }
    }

    @InterfaceC4112d(c = "com.stepos.ailauncher.taskstore.service.TaskStoreServiceImpl", f = "TaskStoreServiceImpl.kt", l = {37}, m = "getTaskStatus", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.taskstore.service.TaskStoreServiceImpl$getTaskStatus$1, reason: invalid class name and case insensitive filesystem */
    public static final class C37331 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C37331(InterfaceC4014c<? super C37331> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TaskStoreServiceImpl.this.getTaskStatus(null, this);
        }
    }

    @InterfaceC4112d(c = "com.stepos.ailauncher.taskstore.service.TaskStoreServiceImpl", f = "TaskStoreServiceImpl.kt", l = {28}, m = "getUnfinishedTasks", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.taskstore.service.TaskStoreServiceImpl$getUnfinishedTasks$1, reason: invalid class name and case insensitive filesystem */
    public static final class C37341 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C37341(InterfaceC4014c<? super C37341> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TaskStoreServiceImpl.this.getUnfinishedTasks(this);
        }
    }

    @Override // com.stepos.ailauncher.contract.api.taskstore.ITaskStoreService
    public Object cancelTask(String str, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return TaskSyncManager.INSTANCE.k(str, interfaceC4014c);
    }

    @Override // com.stepos.ailauncher.contract.api.taskstore.ITaskStoreService
    public Object cleanAll(InterfaceC4014c<? super t> interfaceC4014c) {
        Object objD;
        com.stepos.ailauncher.taskstore.repository.a aVarO = TaskStoreModule.INSTANCE.o();
        return (aVarO == null || (objD = aVarO.d(interfaceC4014c)) != C4063a.g()) ? t.f7040a : objD;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.stepos.ailauncher.contract.api.taskstore.ITaskStoreService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object deleteSessionTasks(java.util.List<java.lang.String> r8, e9.InterfaceC4014c<? super java.lang.Boolean> r9) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 264
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.taskstore.service.TaskStoreServiceImpl.deleteSessionTasks(java.util.List, e9.c):java.lang.Object");
    }

    @Override // com.stepos.ailauncher.contract.api.taskstore.ITaskStoreService
    public Object forgetLocalSession(List<String> list, InterfaceC4014c<? super t> interfaceC4014c) throws Throwable {
        Object objT = TaskSyncManager.INSTANCE.t(list, interfaceC4014c);
        return objT == C4063a.g() ? objT : t.f7040a;
    }

    @Override // com.stepos.ailauncher.contract.api.taskstore.ITaskStoreService
    public Object getSessionArtifacts(List<String> list, InterfaceC4014c<? super List<SessionArtifact>> interfaceC4014c) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (!H.x0((String) obj)) {
                arrayList.add(obj);
            }
        }
        List<String> listG0 = F.g0(arrayList);
        return listG0.isEmpty() ? C1173v.m() : SessionArtifactResolver.INSTANCE.b(listG0, interfaceC4014c);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.stepos.ailauncher.contract.api.taskstore.ITaskStoreService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object getTaskStatus(java.lang.String r5, e9.InterfaceC4014c<? super java.lang.Integer> r6) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.stepos.ailauncher.taskstore.service.TaskStoreServiceImpl.C37331
            if (r0 == 0) goto L13
            r0 = r6
            com.stepos.ailauncher.taskstore.service.TaskStoreServiceImpl$getTaskStatus$1 r0 = (com.stepos.ailauncher.taskstore.service.TaskStoreServiceImpl.C37331) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.ailauncher.taskstore.service.TaskStoreServiceImpl$getTaskStatus$1 r0 = new com.stepos.ailauncher.taskstore.service.TaskStoreServiceImpl$getTaskStatus$1
            r0.<init>(r6)
        L18:
            java.lang.Object r4 = r0.result
            java.lang.Object r6 = f9.C4063a.g()
            int r1 = r0.label
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L36
            if (r1 != r3) goto L2e
            java.lang.Object r5 = r0.L$0
            java.lang.String r5 = (java.lang.String) r5
            kotlin.C4849c.b(r4)
            goto L57
        L2e:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L36:
            kotlin.C4849c.b(r4)
            boolean r4 = La.H.x0(r5)
            if (r4 == 0) goto L40
            return r2
        L40:
            com.stepos.ailauncher.taskstore.TaskStoreModule r4 = com.stepos.ailauncher.taskstore.TaskStoreModule.INSTANCE
            com.stepos.ailauncher.taskstore.repository.a r4 = r4.o()
            if (r4 == 0) goto L6a
            java.lang.Object r1 = g9.h.a(r5)
            r0.L$0 = r1
            r0.label = r3
            java.lang.Object r4 = r4.q(r5, r0)
            if (r4 != r6) goto L57
            return r6
        L57:
            com.stepos.ailauncher.taskstore.entity.TaskInfoCard r4 = (com.stepos.ailauncher.taskstore.entity.TaskInfoCard) r4
            if (r4 == 0) goto L6a
            com.stepos.ailauncher.taskstore.entity.TaskInfoStatus r4 = r4.getStatus()
            if (r4 == 0) goto L6a
            int r4 = z6.C6364b.b(r4)
            java.lang.Integer r4 = g9.C4109a.f(r4)
            return r4
        L6a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.taskstore.service.TaskStoreServiceImpl.getTaskStatus(java.lang.String, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.stepos.ailauncher.contract.api.taskstore.ITaskStoreService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object getUnfinishedTasks(e9.InterfaceC4014c<? super java.util.List<com.stepos.ailauncher.contract.model.UnfinishedTaskInfo>> r7) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r7 instanceof com.stepos.ailauncher.taskstore.service.TaskStoreServiceImpl.C37341
            if (r0 == 0) goto L13
            r0 = r7
            com.stepos.ailauncher.taskstore.service.TaskStoreServiceImpl$getUnfinishedTasks$1 r0 = (com.stepos.ailauncher.taskstore.service.TaskStoreServiceImpl.C37341) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.ailauncher.taskstore.service.TaskStoreServiceImpl$getUnfinishedTasks$1 r0 = new com.stepos.ailauncher.taskstore.service.TaskStoreServiceImpl$getUnfinishedTasks$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r6 = r0.L$1
            com.stepos.ailauncher.taskstore.service.TaskStoreServiceImpl r6 = (com.stepos.ailauncher.taskstore.service.TaskStoreServiceImpl) r6
            java.lang.Object r6 = r0.L$0
            com.stepos.ailauncher.taskstore.repository.a r6 = (com.stepos.ailauncher.taskstore.repository.a) r6
            kotlin.C4849c.b(r7)     // Catch: java.lang.Throwable -> L99
            goto L6f
        L31:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L39:
            kotlin.C4849c.b(r7)
            com.stepos.ailauncher.taskstore.TaskStoreModule r7 = com.stepos.ailauncher.taskstore.TaskStoreModule.INSTANCE
            com.stepos.ailauncher.taskstore.repository.a r2 = r7.o()
            if (r2 != 0) goto L51
            java.lang.String r6 = "getUnfinishedTasks"
            java.lang.String r0 = "returning empty"
            r7.A(r6, r0)
            java.util.List r6 = Z8.C1173v.m()
            return r6
        L51:
            kotlin.Result$a r7 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L99
            java.util.Set r7 = z6.C6364b.a()     // Catch: java.lang.Throwable -> L99
            java.lang.Object r4 = g9.h.a(r2)     // Catch: java.lang.Throwable -> L99
            r0.L$0 = r4     // Catch: java.lang.Throwable -> L99
            java.lang.Object r6 = g9.h.a(r6)     // Catch: java.lang.Throwable -> L99
            r0.L$1 = r6     // Catch: java.lang.Throwable -> L99
            r6 = 0
            r0.I$0 = r6     // Catch: java.lang.Throwable -> L99
            r0.label = r3     // Catch: java.lang.Throwable -> L99
            java.lang.Object r7 = r2.n(r7, r0)     // Catch: java.lang.Throwable -> L99
            if (r7 != r1) goto L6f
            return r1
        L6f:
            java.lang.Iterable r7 = (java.lang.Iterable) r7     // Catch: java.lang.Throwable -> L99
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L99
            r0 = 10
            int r0 = Z8.C1174w.x(r7, r0)     // Catch: java.lang.Throwable -> L99
            r6.<init>(r0)     // Catch: java.lang.Throwable -> L99
            java.util.Iterator r7 = r7.iterator()     // Catch: java.lang.Throwable -> L99
        L80:
            boolean r0 = r7.hasNext()     // Catch: java.lang.Throwable -> L99
            if (r0 == 0) goto L94
            java.lang.Object r0 = r7.next()     // Catch: java.lang.Throwable -> L99
            com.stepos.ailauncher.taskstore.entity.TaskInfoCard r0 = (com.stepos.ailauncher.taskstore.entity.TaskInfoCard) r0     // Catch: java.lang.Throwable -> L99
            com.stepos.ailauncher.contract.model.UnfinishedTaskInfo r0 = z6.C6364b.d(r0)     // Catch: java.lang.Throwable -> L99
            r6.add(r0)     // Catch: java.lang.Throwable -> L99
            goto L80
        L94:
            java.lang.Object r6 = kotlin.Result.b(r6)     // Catch: java.lang.Throwable -> L99
            goto La5
        L99:
            r0 = move-exception
            r6 = r0
            kotlin.Result$a r7 = kotlin.Result.INSTANCE
            java.lang.Object r6 = kotlin.C4849c.a(r6)
            java.lang.Object r6 = kotlin.Result.b(r6)
        La5:
            java.lang.Throwable r2 = kotlin.Result.e(r6)
            if (r2 == 0) goto Lb6
            r4 = 8
            r5 = 0
            java.lang.String r0 = "TaskStoreServiceImpl"
            java.lang.String r1 = "getUnfinishedTasks failed, returning empty"
            r3 = 0
            h8.C4148a.g(r0, r1, r2, r3, r4, r5)
        Lb6:
            java.util.List r7 = Z8.C1173v.m()
            boolean r0 = kotlin.Result.g(r6)
            if (r0 == 0) goto Lc1
            r6 = r7
        Lc1:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.taskstore.service.TaskStoreServiceImpl.getUnfinishedTasks(e9.c):java.lang.Object");
    }

    @Override // com.stepos.ailauncher.contract.api.taskstore.ITaskStoreService
    public Object queryArtifactAvailability(List<String> list, InterfaceC4014c<? super Map<String, ? extends ArtifactAvailability>> interfaceC4014c) {
        return com.stepos.ailauncher.taskstore.artifact.a.INSTANCE.e(list, interfaceC4014c);
    }

    @Override // com.stepos.ailauncher.contract.api.taskstore.ITaskStoreService
    public void releaseSessionDeletionGuard(List<String> sessionKeys) {
        p.i(sessionKeys, "sessionKeys");
        TaskStoreModule.INSTANCE.P(sessionKeys);
    }
}
