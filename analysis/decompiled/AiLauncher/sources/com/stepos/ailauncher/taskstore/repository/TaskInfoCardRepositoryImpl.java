package com.stepos.ailauncher.taskstore.repository;

import Ua.C1056g;
import Ua.Y;
import Xa.c;
import Y8.t;
import Z8.C1174w;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.taskstore.TaskStoreModule;
import com.stepos.ailauncher.taskstore.dao.TaskInfoCardDao;
import com.stepos.ailauncher.taskstore.database.d;
import com.stepos.ailauncher.taskstore.database.o;
import com.stepos.ailauncher.taskstore.entity.TaskInfoCard;
import com.stepos.ailauncher.taskstore.entity.TaskInfoPart;
import com.stepos.ailauncher.taskstore.entity.TaskInfoStatus;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import h9.InterfaceC4149a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import z6.C6363a;

@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0000\u0018\u0000 T2\u00020\u0001:\u00015B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ&\u0010\u0012\u001a\u00020\u00112\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0082@¢\u0006\u0004\b\u0012\u0010\u0013J\u0014\u0010\u0015\u001a\u00020\u0014*\u00020\u0014H\u0082@¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0017\u001a\u00020\rH\u0082@¢\u0006\u0004\b\u0019\u0010\u001aJ\u0018\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u0014H\u0096@¢\u0006\u0004\b\u001d\u0010\u0016J\u001e\u0010\u001f\u001a\u00020\u00112\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00140\fH\u0096@¢\u0006\u0004\b\u001f\u0010 J\u001a\u0010!\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0017\u001a\u00020\rH\u0096@¢\u0006\u0004\b!\u0010\u001aJ\u001f\u0010#\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\"2\u0006\u0010\u0017\u001a\u00020\rH\u0016¢\u0006\u0004\b#\u0010$J\u0016\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00140\fH\u0096@¢\u0006\u0004\b%\u0010&J\u001b\u0010'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\f0\"H\u0016¢\u0006\u0004\b'\u0010(J \u0010*\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\r2\u0006\u0010)\u001a\u00020\u000fH\u0096@¢\u0006\u0004\b*\u0010+J\"\u0010-\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\r2\b\u0010,\u001a\u0004\u0018\u00010\rH\u0096@¢\u0006\u0004\b-\u0010.J&\u00101\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\r2\f\u00100\u001a\b\u0012\u0004\u0012\u00020\r0/H\u0096@¢\u0006\u0004\b1\u00102J \u00105\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\r2\u0006\u00104\u001a\u000203H\u0096@¢\u0006\u0004\b5\u00106J$\u00108\u001a\b\u0012\u0004\u0012\u00020\u00140\f2\f\u00107\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0096@¢\u0006\u0004\b8\u0010 J \u0010;\u001a\u00020\u00112\u0006\u00109\u001a\u00020\r2\u0006\u0010:\u001a\u00020\rH\u0096@¢\u0006\u0004\b;\u0010.J$\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00140\f2\f\u0010>\u001a\b\u0012\u0004\u0012\u00020=0<H\u0096@¢\u0006\u0004\b?\u0010@J\u0012\u0010A\u001a\u0004\u0018\u000103H\u0096@¢\u0006\u0004\bA\u0010&J\u0018\u0010C\u001a\u00020\u00112\u0006\u0010B\u001a\u00020\rH\u0096@¢\u0006\u0004\bC\u0010\u001aJ\u001e\u0010D\u001a\u00020\u00112\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0096@¢\u0006\u0004\bD\u0010 J\u0010\u0010F\u001a\u00020EH\u0096@¢\u0006\u0004\bF\u0010&J0\u0010J\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\r2\b\u0010G\u001a\u0004\u0018\u00010\u00112\f\u0010I\u001a\b\u0012\u0004\u0012\u00020H0\fH\u0096@¢\u0006\u0004\bJ\u0010KJ.\u0010N\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\r2\u0006\u0010L\u001a\u00020\u00112\f\u0010M\u001a\b\u0012\u0004\u0012\u00020\u00140\fH\u0096@¢\u0006\u0004\bN\u0010OR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010PR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010QR\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010RR\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010S¨\u0006U"}, d2 = {"Lcom/stepos/ailauncher/taskstore/repository/TaskInfoCardRepositoryImpl;", "Lcom/stepos/ailauncher/taskstore/repository/a;", "Lcom/stepos/ailauncher/taskstore/dao/TaskInfoCardDao;", "dao", "Lcom/stepos/ailauncher/taskstore/database/d;", "snapshotDao", "Lcom/stepos/ailauncher/taskstore/database/o;", "subTaskSnapshotDao", "Lcom/stepos/ailauncher/taskstore/database/a;", "downloadedDao", "<init>", "(Lcom/stepos/ailauncher/taskstore/dao/TaskInfoCardDao;Lcom/stepos/ailauncher/taskstore/database/d;Lcom/stepos/ailauncher/taskstore/database/o;Lcom/stepos/ailauncher/taskstore/database/a;)V", "", "", "taskIds", "", "includeChildren", "", "B", "(Ljava/util/List;ZLe9/c;)Ljava/lang/Object;", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;", "D", "(Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;Le9/c;)Ljava/lang/Object;", "taskId", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCardEntity;", "C", "(Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "card", "Lcom/stepos/ailauncher/taskstore/repository/b;", "f", "cards", "p", "(Ljava/util/List;Le9/c;)Ljava/lang/Object;", "q", "LXa/b;", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;)LXa/b;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Le9/c;)Ljava/lang/Object;", "t", "()LXa/b;", "hidden", "o", "(Ljava/lang/String;ZLe9/c;)Ljava/lang/Object;", "status", "k", "(Ljava/lang/String;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "", "questionTexts", "s", "(Ljava/lang/String;Ljava/util/Collection;Le9/c;)Ljava/lang/Object;", "", "readAt", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;JLe9/c;)Ljava/lang/Object;", "sessionKeys", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "oldKey", "newKey", "m", "", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoStatus;", "excludedStatuses", "n", "(Ljava/util/Set;Le9/c;)Ljava/lang/Object;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "uid", "c", "e", "LY8/t;", Const.INTENT_KEY_UMID, "version", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoPart;", "parts", "r", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;Le9/c;)Ljava/lang/Object;", "taskVersion", "subTasks", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Ljava/lang/String;ILjava/util/List;Le9/c;)Ljava/lang/Object;", "Lcom/stepos/ailauncher/taskstore/dao/TaskInfoCardDao;", "Lcom/stepos/ailauncher/taskstore/database/d;", "Lcom/stepos/ailauncher/taskstore/database/o;", "Lcom/stepos/ailauncher/taskstore/database/a;", "Companion", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TaskInfoCardRepositoryImpl implements com.stepos.ailauncher.taskstore.repository.a {
    private static final a Companion = new a(null);

    @Deprecated
    public static final int NOTIFIABLE_TERMINAL_LIMIT = 200;
    private static final List<String> TERMINAL_STATUS_NAMES;
    private final TaskInfoCardDao dao;
    private final com.stepos.ailauncher.taskstore.database.a downloadedDao;
    private final d snapshotDao;
    private final o subTaskSnapshotDao;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/ailauncher/taskstore/repository/TaskInfoCardRepositoryImpl$a;", "", "<init>", "()V", "", "NOTIFIABLE_TERMINAL_LIMIT", "I", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a {
        public /* synthetic */ a(i iVar) {
            this();
        }

        public a() {
        }
    }

    static {
        InterfaceC4149a<TaskInfoStatus> entries = TaskInfoStatus.getEntries();
        ArrayList arrayList = new ArrayList();
        for (TaskInfoStatus taskInfoStatus : entries) {
            if (taskInfoStatus.isTerminal()) {
                arrayList.add(taskInfoStatus);
            }
        }
        ArrayList arrayList2 = new ArrayList(C1174w.x(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((TaskInfoStatus) it.next()).name());
        }
        TERMINAL_STATUS_NAMES = arrayList2;
    }

    public TaskInfoCardRepositoryImpl(TaskInfoCardDao dao, d snapshotDao, o subTaskSnapshotDao, com.stepos.ailauncher.taskstore.database.a downloadedDao) {
        p.i(dao, "dao");
        p.i(snapshotDao, "snapshotDao");
        p.i(subTaskSnapshotDao, "subTaskSnapshotDao");
        p.i(downloadedDao, "downloadedDao");
        this.dao = dao;
        this.snapshotDao = snapshotDao;
        this.subTaskSnapshotDao = subTaskSnapshotDao;
        this.downloadedDao = downloadedDao;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0178 A[LOOP:0: B:45:0x0172->B:47:0x0178, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0216  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x015e -> B:44:0x0161). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object B(java.util.List<java.lang.String> r18, boolean r19, e9.InterfaceC4014c<? super java.lang.Integer> r20) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 550
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.taskstore.repository.TaskInfoCardRepositoryImpl.B(java.util.List, boolean, e9.c):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x00ae, code lost:
    
        if (r11 == r1) goto L31;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object C(java.lang.String r10, e9.InterfaceC4014c<? super com.stepos.ailauncher.taskstore.entity.TaskInfoCardEntity> r11) throws java.lang.Throwable {
        /*
            r9 = this;
            boolean r0 = r11 instanceof com.stepos.ailauncher.taskstore.repository.TaskInfoCardRepositoryImpl$queryByTaskIdOrAlias$1
            if (r0 == 0) goto L13
            r0 = r11
            com.stepos.ailauncher.taskstore.repository.TaskInfoCardRepositoryImpl$queryByTaskIdOrAlias$1 r0 = (com.stepos.ailauncher.taskstore.repository.TaskInfoCardRepositoryImpl$queryByTaskIdOrAlias$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.ailauncher.taskstore.repository.TaskInfoCardRepositoryImpl$queryByTaskIdOrAlias$1 r0 = new com.stepos.ailauncher.taskstore.repository.TaskInfoCardRepositoryImpl$queryByTaskIdOrAlias$1
            r0.<init>(r9, r11)
        L18:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 0
            r4 = 2
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L56
            if (r2 == r5) goto L43
            if (r2 != r4) goto L3b
            java.lang.Object r9 = r0.L$2
            java.lang.String r9 = (java.lang.String) r9
            java.lang.Object r9 = r0.L$1
            java.lang.String r9 = (java.lang.String) r9
            java.lang.Object r9 = r0.L$0
            java.lang.String r9 = (java.lang.String) r9
            kotlin.C4849c.b(r11)
            goto Lb1
        L3b:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L43:
            int r10 = r0.I$0
            java.lang.Object r2 = r0.L$1
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r5 = r0.L$0
            java.lang.String r5 = (java.lang.String) r5
            kotlin.C4849c.b(r11)
            r8 = r11
            r11 = r10
            r10 = r5
            r5 = r2
            r2 = r8
            goto L84
        L56:
            kotlin.C4849c.b(r11)
            java.lang.CharSequence r11 = La.H.D1(r10)
            java.lang.String r11 = r11.toString()
            int r2 = r11.length()
            if (r2 <= 0) goto L69
            r2 = r11
            goto L6a
        L69:
            r2 = r6
        L6a:
            if (r2 == 0) goto Lb6
            com.stepos.ailauncher.taskstore.dao.TaskInfoCardDao r11 = r9.dao
            java.lang.Object r7 = g9.h.a(r10)
            r0.L$0 = r7
            r0.L$1 = r2
            r0.I$0 = r3
            r0.label = r5
            java.lang.Object r11 = r11.l(r2, r0)
            if (r11 != r1) goto L81
            goto Lb0
        L81:
            r5 = r2
            r2 = r11
            r11 = r3
        L84:
            com.stepos.ailauncher.taskstore.entity.TaskInfoCardEntity r2 = (com.stepos.ailauncher.taskstore.entity.TaskInfoCardEntity) r2
            if (r2 != 0) goto Lb5
            com.stepos.ailauncher.taskstore.a r2 = com.stepos.ailauncher.taskstore.a.INSTANCE
            java.lang.String r2 = r2.a(r5)
            if (r2 == 0) goto Lb4
            com.stepos.ailauncher.taskstore.dao.TaskInfoCardDao r9 = r9.dao
            java.lang.Object r10 = g9.h.a(r10)
            r0.L$0 = r10
            java.lang.Object r10 = g9.h.a(r5)
            r0.L$1 = r10
            java.lang.Object r10 = g9.h.a(r2)
            r0.L$2 = r10
            r0.I$0 = r11
            r0.I$1 = r3
            r0.label = r4
            java.lang.Object r11 = r9.l(r2, r0)
            if (r11 != r1) goto Lb1
        Lb0:
            return r1
        Lb1:
            com.stepos.ailauncher.taskstore.entity.TaskInfoCardEntity r11 = (com.stepos.ailauncher.taskstore.entity.TaskInfoCardEntity) r11
            return r11
        Lb4:
            return r6
        Lb5:
            return r2
        Lb6:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.taskstore.repository.TaskInfoCardRepositoryImpl.C(java.lang.String, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00fb A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object D(com.stepos.ailauncher.taskstore.entity.TaskInfoCard r49, e9.InterfaceC4014c<? super com.stepos.ailauncher.taskstore.entity.TaskInfoCard> r50) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 328
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.taskstore.repository.TaskInfoCardRepositoryImpl.D(com.stepos.ailauncher.taskstore.entity.TaskInfoCard, e9.c):java.lang.Object");
    }

    @Override // com.stepos.ailauncher.taskstore.repository.a
    public Object a(String str, long j10, InterfaceC4014c<? super Integer> interfaceC4014c) {
        return C1056g.j(Y.b(), new TaskInfoCardRepositoryImpl$markReadAtIfAbsent$2(this, str, j10, null), interfaceC4014c);
    }

    @Override // com.stepos.ailauncher.taskstore.repository.a
    public Xa.b<TaskInfoCard> b(String taskId) {
        p.i(taskId, "taskId");
        final Xa.b bVarQ = Xa.d.q(this.dao.b(taskId));
        return Xa.d.E(new Xa.b<TaskInfoCard>() { // from class: com.stepos.ailauncher.taskstore.repository.TaskInfoCardRepositoryImpl$observeByTaskId$$inlined$map$1

            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            /* renamed from: com.stepos.ailauncher.taskstore.repository.TaskInfoCardRepositoryImpl$observeByTaskId$$inlined$map$1$2, reason: invalid class name */
            public static final class AnonymousClass2<T> implements c {
                final /* synthetic */ c $this_unsafeFlow;

                @InterfaceC4112d(c = "com.stepos.ailauncher.taskstore.repository.TaskInfoCardRepositoryImpl$observeByTaskId$$inlined$map$1$2", f = "TaskInfoCardRepositoryImpl.kt", l = {217}, m = "emit", v = 1)
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                /* renamed from: com.stepos.ailauncher.taskstore.repository.TaskInfoCardRepositoryImpl$observeByTaskId$$inlined$map$1$2$1, reason: invalid class name */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    int I$0;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    Object L$4;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(InterfaceC4014c interfaceC4014c) {
                        super(interfaceC4014c);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(c cVar) {
                    this.$this_unsafeFlow = cVar;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // Xa.c
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object emit(java.lang.Object r5, e9.InterfaceC4014c r6) throws java.lang.Throwable {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof com.stepos.ailauncher.taskstore.repository.TaskInfoCardRepositoryImpl$observeByTaskId$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r6
                        com.stepos.ailauncher.taskstore.repository.TaskInfoCardRepositoryImpl$observeByTaskId$$inlined$map$1$2$1 r0 = (com.stepos.ailauncher.taskstore.repository.TaskInfoCardRepositoryImpl$observeByTaskId$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.stepos.ailauncher.taskstore.repository.TaskInfoCardRepositoryImpl$observeByTaskId$$inlined$map$1$2$1 r0 = new com.stepos.ailauncher.taskstore.repository.TaskInfoCardRepositoryImpl$observeByTaskId$$inlined$map$1$2$1
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.result
                        java.lang.Object r1 = f9.C4063a.g()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L39
                        if (r2 != r3) goto L31
                        java.lang.Object r4 = r0.L$3
                        Xa.c r4 = (Xa.c) r4
                        java.lang.Object r4 = r0.L$1
                        com.stepos.ailauncher.taskstore.repository.TaskInfoCardRepositoryImpl$observeByTaskId$$inlined$map$1$2$1 r4 = (com.stepos.ailauncher.taskstore.repository.TaskInfoCardRepositoryImpl$observeByTaskId$$inlined$map$1.AnonymousClass2.AnonymousClass1) r4
                        kotlin.C4849c.b(r6)
                        goto L6f
                    L31:
                        java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                        java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                        r4.<init>(r5)
                        throw r4
                    L39:
                        kotlin.C4849c.b(r6)
                        Xa.c r4 = r4.$this_unsafeFlow
                        r6 = r5
                        com.stepos.ailauncher.taskstore.entity.TaskInfoCardEntity r6 = (com.stepos.ailauncher.taskstore.entity.TaskInfoCardEntity) r6
                        if (r6 == 0) goto L4a
                        z6.a r2 = z6.C6363a.INSTANCE
                        com.stepos.ailauncher.taskstore.entity.TaskInfoCard r6 = r2.a(r6)
                        goto L4b
                    L4a:
                        r6 = 0
                    L4b:
                        java.lang.Object r2 = g9.h.a(r5)
                        r0.L$0 = r2
                        java.lang.Object r2 = g9.h.a(r0)
                        r0.L$1 = r2
                        java.lang.Object r5 = g9.h.a(r5)
                        r0.L$2 = r5
                        java.lang.Object r5 = g9.h.a(r4)
                        r0.L$3 = r5
                        r5 = 0
                        r0.I$0 = r5
                        r0.label = r3
                        java.lang.Object r4 = r4.emit(r6, r0)
                        if (r4 != r1) goto L6f
                        return r1
                    L6f:
                        Y8.t r4 = Y8.t.f7040a
                        return r4
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.taskstore.repository.TaskInfoCardRepositoryImpl$observeByTaskId$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, e9.c):java.lang.Object");
                }
            }

            @Override // Xa.b
            public Object collect(c<? super TaskInfoCard> cVar, InterfaceC4014c interfaceC4014c) {
                Object objCollect = bVarQ.collect(new AnonymousClass2(cVar), interfaceC4014c);
                return objCollect == C4063a.g() ? objCollect : t.f7040a;
            }
        }, Y.b());
    }

    @Override // com.stepos.ailauncher.taskstore.repository.a
    public Object c(String str, InterfaceC4014c<? super Integer> interfaceC4014c) {
        return C1056g.j(Y.b(), new TaskInfoCardRepositoryImpl$claimOrphans$2(this, str, null), interfaceC4014c);
    }

    @Override // com.stepos.ailauncher.taskstore.repository.a
    public Object d(InterfaceC4014c<? super t> interfaceC4014c) {
        Object objJ = C1056g.j(Y.b(), new TaskInfoCardRepositoryImpl$clear$2(this, null), interfaceC4014c);
        return objJ == C4063a.g() ? objJ : t.f7040a;
    }

    @Override // com.stepos.ailauncher.taskstore.repository.a
    public Object e(List<String> list, InterfaceC4014c<? super Integer> interfaceC4014c) {
        return C1056g.j(Y.b(), new TaskInfoCardRepositoryImpl$deleteTaskData$2(this, list, null), interfaceC4014c);
    }

    @Override // com.stepos.ailauncher.taskstore.repository.a
    public Object f(TaskInfoCard taskInfoCard, InterfaceC4014c<? super TaskInfoCardSaveResult> interfaceC4014c) {
        return C1056g.j(Y.b(), new TaskInfoCardRepositoryImpl$saveOrUpdate$2(taskInfoCard, this, null), interfaceC4014c);
    }

    @Override // com.stepos.ailauncher.taskstore.repository.a
    public Object g(InterfaceC4014c<? super List<TaskInfoCard>> interfaceC4014c) {
        return C1056g.j(Y.b(), new TaskInfoCardRepositoryImpl$getAll$2(this, null), interfaceC4014c);
    }

    @Override // com.stepos.ailauncher.taskstore.repository.a
    public Object h(InterfaceC4014c<? super Long> interfaceC4014c) {
        return C1056g.j(Y.b(), new TaskInfoCardRepositoryImpl$getMaxUpdatedAt$2(this, null), interfaceC4014c);
    }

    @Override // com.stepos.ailauncher.taskstore.repository.a
    public Object i(List<String> list, InterfaceC4014c<? super List<TaskInfoCard>> interfaceC4014c) {
        return C1056g.j(Y.b(), new TaskInfoCardRepositoryImpl$getBySessionKeys$2(this, list, null), interfaceC4014c);
    }

    @Override // com.stepos.ailauncher.taskstore.repository.a
    public Object j(String str, int i10, List<TaskInfoCard> list, InterfaceC4014c<? super Integer> interfaceC4014c) {
        return C1056g.j(Y.b(), new TaskInfoCardRepositoryImpl$saveSubTaskSnapshot$2(this, str, i10, list, null), interfaceC4014c);
    }

    @Override // com.stepos.ailauncher.taskstore.repository.a
    public Object k(String str, String str2, InterfaceC4014c<? super Integer> interfaceC4014c) {
        return C1056g.j(Y.b(), new TaskInfoCardRepositoryImpl$setNotificationDismissed$2(this, str, str2, null), interfaceC4014c);
    }

    @Override // com.stepos.ailauncher.taskstore.repository.a
    public Object m(String str, String str2, InterfaceC4014c<? super Integer> interfaceC4014c) {
        return C1056g.j(Y.b(), new TaskInfoCardRepositoryImpl$rebindSessionKeys$2(str, str2, this, null), interfaceC4014c);
    }

    @Override // com.stepos.ailauncher.taskstore.repository.a
    public Object n(Set<? extends TaskInfoStatus> set, InterfaceC4014c<? super List<TaskInfoCard>> interfaceC4014c) {
        return C1056g.j(Y.b(), new TaskInfoCardRepositoryImpl$getActiveCards$2(this, set, null), interfaceC4014c);
    }

    @Override // com.stepos.ailauncher.taskstore.repository.a
    public Object o(String str, boolean z10, InterfaceC4014c<? super Integer> interfaceC4014c) {
        return C1056g.j(Y.b(), new TaskInfoCardRepositoryImpl$setCardHidden$2(this, str, z10, null), interfaceC4014c);
    }

    @Override // com.stepos.ailauncher.taskstore.repository.a
    public Object p(List<TaskInfoCard> list, InterfaceC4014c<? super Integer> interfaceC4014c) {
        return C1056g.j(Y.b(), new TaskInfoCardRepositoryImpl$saveAll$2(list, this, null), interfaceC4014c);
    }

    @Override // com.stepos.ailauncher.taskstore.repository.a
    public Object q(String str, InterfaceC4014c<? super TaskInfoCard> interfaceC4014c) {
        return C1056g.j(Y.b(), new TaskInfoCardRepositoryImpl$getByTaskId$2(this, str, null), interfaceC4014c);
    }

    @Override // com.stepos.ailauncher.taskstore.repository.a
    public Object r(String str, Integer num, List<TaskInfoPart> list, InterfaceC4014c<? super Integer> interfaceC4014c) {
        return C1056g.j(Y.b(), new TaskInfoCardRepositoryImpl$saveResultSnapshot$2(num, this, str, list, null), interfaceC4014c);
    }

    @Override // com.stepos.ailauncher.taskstore.repository.a
    public Object s(String str, Collection<String> collection, InterfaceC4014c<? super Integer> interfaceC4014c) {
        return C1056g.j(Y.b(), new TaskInfoCardRepositoryImpl$appendAnsweredQuestions$2(collection, this, str, null), interfaceC4014c);
    }

    @Override // com.stepos.ailauncher.taskstore.repository.a
    public Xa.b<List<TaskInfoCard>> t() {
        final Xa.b bVarQ = Xa.d.q(Xa.d.N(TaskStoreModule.INSTANCE.m(), new TaskInfoCardRepositoryImpl$observeNotifiableRootCards$$inlined$flatMapLatest$1(null, this)));
        final C6363a c6363a = C6363a.INSTANCE;
        return Xa.d.E(new Xa.b<List<? extends TaskInfoCard>>() { // from class: com.stepos.ailauncher.taskstore.repository.TaskInfoCardRepositoryImpl$observeNotifiableRootCards$$inlined$map$1

            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            /* renamed from: com.stepos.ailauncher.taskstore.repository.TaskInfoCardRepositoryImpl$observeNotifiableRootCards$$inlined$map$1$2, reason: invalid class name */
            public static final class AnonymousClass2<T> implements c {
                final /* synthetic */ c $this_unsafeFlow;
                final /* synthetic */ C6363a receiver$inlined;

                @InterfaceC4112d(c = "com.stepos.ailauncher.taskstore.repository.TaskInfoCardRepositoryImpl$observeNotifiableRootCards$$inlined$map$1$2", f = "TaskInfoCardRepositoryImpl.kt", l = {217}, m = "emit", v = 1)
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                /* renamed from: com.stepos.ailauncher.taskstore.repository.TaskInfoCardRepositoryImpl$observeNotifiableRootCards$$inlined$map$1$2$1, reason: invalid class name */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    int I$0;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    Object L$4;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(InterfaceC4014c interfaceC4014c) {
                        super(interfaceC4014c);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(c cVar, C6363a c6363a) {
                    this.$this_unsafeFlow = cVar;
                    this.receiver$inlined = c6363a;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // Xa.c
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object emit(java.lang.Object r5, e9.InterfaceC4014c r6) throws java.lang.Throwable {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof com.stepos.ailauncher.taskstore.repository.TaskInfoCardRepositoryImpl$observeNotifiableRootCards$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r6
                        com.stepos.ailauncher.taskstore.repository.TaskInfoCardRepositoryImpl$observeNotifiableRootCards$$inlined$map$1$2$1 r0 = (com.stepos.ailauncher.taskstore.repository.TaskInfoCardRepositoryImpl$observeNotifiableRootCards$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.stepos.ailauncher.taskstore.repository.TaskInfoCardRepositoryImpl$observeNotifiableRootCards$$inlined$map$1$2$1 r0 = new com.stepos.ailauncher.taskstore.repository.TaskInfoCardRepositoryImpl$observeNotifiableRootCards$$inlined$map$1$2$1
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.result
                        java.lang.Object r1 = f9.C4063a.g()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L39
                        if (r2 != r3) goto L31
                        java.lang.Object r4 = r0.L$3
                        Xa.c r4 = (Xa.c) r4
                        java.lang.Object r4 = r0.L$1
                        com.stepos.ailauncher.taskstore.repository.TaskInfoCardRepositoryImpl$observeNotifiableRootCards$$inlined$map$1$2$1 r4 = (com.stepos.ailauncher.taskstore.repository.TaskInfoCardRepositoryImpl$observeNotifiableRootCards$$inlined$map$1.AnonymousClass2.AnonymousClass1) r4
                        kotlin.C4849c.b(r6)
                        goto L6b
                    L31:
                        java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                        java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                        r4.<init>(r5)
                        throw r4
                    L39:
                        kotlin.C4849c.b(r6)
                        Xa.c r6 = r4.$this_unsafeFlow
                        r2 = r5
                        java.util.List r2 = (java.util.List) r2
                        z6.a r4 = r4.receiver$inlined
                        java.util.List r4 = r4.b(r2)
                        java.lang.Object r2 = g9.h.a(r5)
                        r0.L$0 = r2
                        java.lang.Object r2 = g9.h.a(r0)
                        r0.L$1 = r2
                        java.lang.Object r5 = g9.h.a(r5)
                        r0.L$2 = r5
                        java.lang.Object r5 = g9.h.a(r6)
                        r0.L$3 = r5
                        r5 = 0
                        r0.I$0 = r5
                        r0.label = r3
                        java.lang.Object r4 = r6.emit(r4, r0)
                        if (r4 != r1) goto L6b
                        return r1
                    L6b:
                        Y8.t r4 = Y8.t.f7040a
                        return r4
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.taskstore.repository.TaskInfoCardRepositoryImpl$observeNotifiableRootCards$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, e9.c):java.lang.Object");
                }
            }

            @Override // Xa.b
            public Object collect(c<? super List<? extends TaskInfoCard>> cVar, InterfaceC4014c interfaceC4014c) {
                Object objCollect = bVarQ.collect(new AnonymousClass2(cVar, c6363a), interfaceC4014c);
                return objCollect == C4063a.g() ? objCollect : t.f7040a;
            }
        }, Y.b());
    }
}
