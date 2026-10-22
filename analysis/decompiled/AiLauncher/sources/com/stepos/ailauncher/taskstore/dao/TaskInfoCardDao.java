package com.stepos.ailauncher.taskstore.dao;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.taskstore.entity.TaskInfoCardEntity;
import e9.InterfaceC4014c;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H§@¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0097@¢\u0006\u0004\b\b\u0010\u0006J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0097@¢\u0006\u0004\b\n\u0010\u0006J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0097@¢\u0006\u0004\b\f\u0010\u0006J\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000e\u001a\u00020\rH§@¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00112\u0006\u0010\u000e\u001a\u00020\rH'¢\u0006\u0004\b\u0012\u0010\u0013J\u001e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u00152\u0006\u0010\u0014\u001a\u00020\rH§@¢\u0006\u0004\b\u0016\u0010\u0010JG\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00150\u00112\u0006\u0010\u0014\u001a\u00020\r2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\r0\u00152\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\r0\u00152\u0006\u0010\u001a\u001a\u00020\u0019H'¢\u0006\u0004\b\u001b\u0010\u001cJ&\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00020\u00152\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\rH§@¢\u0006\u0004\b\u001e\u0010\u001fJ(\u0010\"\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010 \u001a\u00020\r2\u0006\u0010!\u001a\u00020\rH§@¢\u0006\u0004\b\"\u0010#J,\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00020\u00152\u0006\u0010\u0014\u001a\u00020\r2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\r0\u0015H§@¢\u0006\u0004\b%\u0010&J,\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00020\u00152\u0006\u0010\u0014\u001a\u00020\r2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\r0\u0015H§@¢\u0006\u0004\b(\u0010&J\u001a\u0010)\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0014\u001a\u00020\rH§@¢\u0006\u0004\b)\u0010\u0010J \u0010+\u001a\u00020\u00192\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010*\u001a\u00020\u0007H§@¢\u0006\u0004\b+\u0010,J\"\u0010.\u001a\u00020\u00192\u0006\u0010\u000e\u001a\u00020\r2\b\u0010-\u001a\u0004\u0018\u00010\rH§@¢\u0006\u0004\b.\u0010\u001fJ\"\u00100\u001a\u00020\u00192\u0006\u0010\u000e\u001a\u00020\r2\b\u0010/\u001a\u0004\u0018\u00010\rH§@¢\u0006\u0004\b0\u0010\u001fJ \u00102\u001a\u00020\u00192\u0006\u0010\u000e\u001a\u00020\r2\u0006\u00101\u001a\u00020\u0004H§@¢\u0006\u0004\b2\u00103J\u0018\u00104\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\rH§@¢\u0006\u0004\b4\u0010\u0010J\u001e\u00106\u001a\u00020\u00192\f\u00105\u001a\b\u0012\u0004\u0012\u00020\r0\u0015H§@¢\u0006\u0004\b6\u00107J\u001e\u00108\u001a\u00020\u00192\f\u00105\u001a\b\u0012\u0004\u0012\u00020\r0\u0015H§@¢\u0006\u0004\b8\u00107J\u001e\u00109\u001a\u00020\u00192\f\u00105\u001a\b\u0012\u0004\u0012\u00020\r0\u0015H§@¢\u0006\u0004\b9\u00107J\u001e\u0010:\u001a\u00020\u00192\f\u00105\u001a\b\u0012\u0004\u0012\u00020\r0\u0015H§@¢\u0006\u0004\b:\u00107J\u001e\u0010;\u001a\u00020\u00192\f\u00105\u001a\b\u0012\u0004\u0012\u00020\r0\u0015H\u0097@¢\u0006\u0004\b;\u00107J\u0010\u0010=\u001a\u00020<H§@¢\u0006\u0004\b=\u0010>¨\u0006?À\u0006\u0003"}, d2 = {"Lcom/stepos/ailauncher/taskstore/dao/TaskInfoCardDao;", "", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCardEntity;", "card", "", "n", "(Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCardEntity;Le9/c;)Ljava/lang/Object;", "", "y", "Lcom/stepos/ailauncher/taskstore/dao/TaskInfoCardUpsertOutcome;", "r", "Lcom/stepos/ailauncher/taskstore/dao/C;", "k", "", "taskId", "l", "(Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "LXa/b;", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;)LXa/b;", "uid", "", "z", "activeExcludedStatuses", "terminalStatuses", "", "terminalLimit", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;I)LXa/b;", "parentTaskId", "t", "(Ljava/lang/String;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "oldKey", "newKey", "x", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "sessionKeys", "w", "(Ljava/lang/String;Ljava/util/List;Le9/c;)Ljava/lang/Object;", "excludedStatuses", "o", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "hidden", "s", "(Ljava/lang/String;ZLe9/c;)Ljava/lang/Object;", "status", "u", "json", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "readAt", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;JLe9/c;)Ljava/lang/Object;", "c", "taskIds", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ljava/util/List;Le9/c;)Ljava/lang/Object;", "q", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "m", "e", "LY8/t;", Const.INTENT_KEY_UMID, "(Le9/c;)Ljava/lang/Object;", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface TaskInfoCardDao {
    /* JADX WARN: Removed duplicated region for block: B:31:0x0094 A[PHI: r8 r9
      0x0094: PHI (r8v4 java.util.List<java.lang.String>) = (r8v3 java.util.List<java.lang.String>), (r8v12 java.util.List<java.lang.String>) binds: [B:29:0x0091, B:18:0x0042] A[DONT_GENERATE, DONT_INLINE]
      0x0094: PHI (r9v4 com.stepos.ailauncher.taskstore.dao.TaskInfoCardDao) = (r9v3 com.stepos.ailauncher.taskstore.dao.TaskInfoCardDao), (r9v10 com.stepos.ailauncher.taskstore.dao.TaskInfoCardDao) binds: [B:29:0x0091, B:18:0x0042] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a9 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static /* synthetic */ java.lang.Object B(com.stepos.ailauncher.taskstore.dao.TaskInfoCardDao r8, java.util.List<java.lang.String> r9, e9.InterfaceC4014c<? super java.lang.Integer> r10) throws java.lang.Throwable {
        /*
            boolean r0 = r10 instanceof com.stepos.ailauncher.taskstore.dao.TaskInfoCardDao$deleteTaskData$1
            if (r0 == 0) goto L13
            r0 = r10
            com.stepos.ailauncher.taskstore.dao.TaskInfoCardDao$deleteTaskData$1 r0 = (com.stepos.ailauncher.taskstore.dao.TaskInfoCardDao$deleteTaskData$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.ailauncher.taskstore.dao.TaskInfoCardDao$deleteTaskData$1 r0 = new com.stepos.ailauncher.taskstore.dao.TaskInfoCardDao$deleteTaskData$1
            r0.<init>(r8, r10)
        L18:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            if (r2 == 0) goto L67
            if (r2 == r6) goto L5a
            if (r2 == r5) goto L4e
            if (r2 == r4) goto L42
            if (r2 != r3) goto L3a
            java.lang.Object r8 = r0.L$1
            java.util.List r8 = (java.util.List) r8
            java.lang.Object r8 = r0.L$0
            com.stepos.ailauncher.taskstore.dao.TaskInfoCardDao r8 = (com.stepos.ailauncher.taskstore.dao.TaskInfoCardDao) r8
            kotlin.C4849c.b(r10)
            return r10
        L3a:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L42:
            java.lang.Object r8 = r0.L$1
            java.util.List r8 = (java.util.List) r8
            java.lang.Object r9 = r0.L$0
            com.stepos.ailauncher.taskstore.dao.TaskInfoCardDao r9 = (com.stepos.ailauncher.taskstore.dao.TaskInfoCardDao) r9
            kotlin.C4849c.b(r10)
            goto L94
        L4e:
            java.lang.Object r8 = r0.L$1
            java.util.List r8 = (java.util.List) r8
            java.lang.Object r9 = r0.L$0
            com.stepos.ailauncher.taskstore.dao.TaskInfoCardDao r9 = (com.stepos.ailauncher.taskstore.dao.TaskInfoCardDao) r9
            kotlin.C4849c.b(r10)
            goto L87
        L5a:
            java.lang.Object r8 = r0.L$1
            r9 = r8
            java.util.List r9 = (java.util.List) r9
            java.lang.Object r8 = r0.L$0
            com.stepos.ailauncher.taskstore.dao.TaskInfoCardDao r8 = (com.stepos.ailauncher.taskstore.dao.TaskInfoCardDao) r8
            kotlin.C4849c.b(r10)
            goto L77
        L67:
            kotlin.C4849c.b(r10)
            r0.L$0 = r8
            r0.L$1 = r9
            r0.label = r6
            java.lang.Object r10 = r8.q(r9, r0)
            if (r10 != r1) goto L77
            goto La8
        L77:
            r0.L$0 = r8
            r0.L$1 = r9
            r0.label = r5
            java.lang.Object r10 = r8.A(r9, r0)
            if (r10 != r1) goto L84
            goto La8
        L84:
            r7 = r9
            r9 = r8
            r8 = r7
        L87:
            r0.L$0 = r9
            r0.L$1 = r8
            r0.label = r4
            java.lang.Object r10 = r9.m(r8, r0)
            if (r10 != r1) goto L94
            goto La8
        L94:
            java.lang.Object r10 = g9.h.a(r9)
            r0.L$0 = r10
            java.lang.Object r10 = g9.h.a(r8)
            r0.L$1 = r10
            r0.label = r3
            java.lang.Object r8 = r9.h(r8, r0)
            if (r8 != r1) goto La9
        La8:
            return r1
        La9:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.taskstore.dao.TaskInfoCardDao.B(com.stepos.ailauncher.taskstore.dao.TaskInfoCardDao, java.util.List, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x024b  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x024e  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0256  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0259  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x02d7  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x02df  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static /* synthetic */ java.lang.Object f(com.stepos.ailauncher.taskstore.dao.TaskInfoCardDao r53, com.stepos.ailauncher.taskstore.entity.TaskInfoCardEntity r54, e9.InterfaceC4014c<? super com.stepos.ailauncher.taskstore.dao.TaskInfoCardUpsertResult> r55) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 828
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.taskstore.dao.TaskInfoCardDao.f(com.stepos.ailauncher.taskstore.dao.TaskInfoCardDao, com.stepos.ailauncher.taskstore.entity.TaskInfoCardEntity, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static /* synthetic */ java.lang.Object p(com.stepos.ailauncher.taskstore.dao.TaskInfoCardDao r4, com.stepos.ailauncher.taskstore.entity.TaskInfoCardEntity r5, e9.InterfaceC4014c<? super com.stepos.ailauncher.taskstore.dao.TaskInfoCardUpsertOutcome> r6) throws java.lang.Throwable {
        /*
            boolean r0 = r6 instanceof com.stepos.ailauncher.taskstore.dao.TaskInfoCardDao$upsertWithOutcome$1
            if (r0 == 0) goto L13
            r0 = r6
            com.stepos.ailauncher.taskstore.dao.TaskInfoCardDao$upsertWithOutcome$1 r0 = (com.stepos.ailauncher.taskstore.dao.TaskInfoCardDao$upsertWithOutcome$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.ailauncher.taskstore.dao.TaskInfoCardDao$upsertWithOutcome$1 r0 = new com.stepos.ailauncher.taskstore.dao.TaskInfoCardDao$upsertWithOutcome$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r4 = r0.L$1
            com.stepos.ailauncher.taskstore.entity.TaskInfoCardEntity r4 = (com.stepos.ailauncher.taskstore.entity.TaskInfoCardEntity) r4
            java.lang.Object r4 = r0.L$0
            com.stepos.ailauncher.taskstore.dao.TaskInfoCardDao r4 = (com.stepos.ailauncher.taskstore.dao.TaskInfoCardDao) r4
            kotlin.C4849c.b(r6)
            goto L51
        L31:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L39:
            kotlin.C4849c.b(r6)
            java.lang.Object r6 = g9.h.a(r4)
            r0.L$0 = r6
            java.lang.Object r6 = g9.h.a(r5)
            r0.L$1 = r6
            r0.label = r3
            java.lang.Object r6 = r4.k(r5, r0)
            if (r6 != r1) goto L51
            return r1
        L51:
            com.stepos.ailauncher.taskstore.dao.C r6 = (com.stepos.ailauncher.taskstore.dao.TaskInfoCardUpsertResult) r6
            com.stepos.ailauncher.taskstore.dao.TaskInfoCardUpsertOutcome r4 = r6.getOutcome()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.taskstore.dao.TaskInfoCardDao.p(com.stepos.ailauncher.taskstore.dao.TaskInfoCardDao, com.stepos.ailauncher.taskstore.entity.TaskInfoCardEntity, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static /* synthetic */ java.lang.Object v(com.stepos.ailauncher.taskstore.dao.TaskInfoCardDao r4, com.stepos.ailauncher.taskstore.entity.TaskInfoCardEntity r5, e9.InterfaceC4014c<? super java.lang.Boolean> r6) throws java.lang.Throwable {
        /*
            boolean r0 = r6 instanceof com.stepos.ailauncher.taskstore.dao.TaskInfoCardDao$upsert$1
            if (r0 == 0) goto L13
            r0 = r6
            com.stepos.ailauncher.taskstore.dao.TaskInfoCardDao$upsert$1 r0 = (com.stepos.ailauncher.taskstore.dao.TaskInfoCardDao$upsert$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.ailauncher.taskstore.dao.TaskInfoCardDao$upsert$1 r0 = new com.stepos.ailauncher.taskstore.dao.TaskInfoCardDao$upsert$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r4 = r0.L$1
            com.stepos.ailauncher.taskstore.entity.TaskInfoCardEntity r4 = (com.stepos.ailauncher.taskstore.entity.TaskInfoCardEntity) r4
            java.lang.Object r4 = r0.L$0
            com.stepos.ailauncher.taskstore.dao.TaskInfoCardDao r4 = (com.stepos.ailauncher.taskstore.dao.TaskInfoCardDao) r4
            kotlin.C4849c.b(r6)
            goto L51
        L31:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L39:
            kotlin.C4849c.b(r6)
            java.lang.Object r6 = g9.h.a(r4)
            r0.L$0 = r6
            java.lang.Object r6 = g9.h.a(r5)
            r0.L$1 = r6
            r0.label = r3
            java.lang.Object r6 = r4.r(r5, r0)
            if (r6 != r1) goto L51
            return r1
        L51:
            com.stepos.ailauncher.taskstore.dao.TaskInfoCardUpsertOutcome r4 = com.stepos.ailauncher.taskstore.dao.TaskInfoCardUpsertOutcome.WRITTEN
            if (r6 != r4) goto L56
            goto L57
        L56:
            r3 = 0
        L57:
            java.lang.Boolean r4 = g9.C4109a.a(r3)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.taskstore.dao.TaskInfoCardDao.v(com.stepos.ailauncher.taskstore.dao.TaskInfoCardDao, com.stepos.ailauncher.taskstore.entity.TaskInfoCardEntity, e9.c):java.lang.Object");
    }

    Object A(List<String> list, InterfaceC4014c<? super Integer> interfaceC4014c);

    Object a(String str, long j10, InterfaceC4014c<? super Integer> interfaceC4014c);

    Xa.b<TaskInfoCardEntity> b(String taskId);

    Object c(String str, InterfaceC4014c<? super Integer> interfaceC4014c);

    Object d(InterfaceC4014c<? super Y8.t> interfaceC4014c);

    default Object e(List<String> list, InterfaceC4014c<? super Integer> interfaceC4014c) {
        return B(this, list, interfaceC4014c);
    }

    Xa.b<List<TaskInfoCardEntity>> g(String uid, List<String> activeExcludedStatuses, List<String> terminalStatuses, int terminalLimit);

    Object h(List<String> list, InterfaceC4014c<? super Integer> interfaceC4014c);

    Object i(String str, InterfaceC4014c<? super Long> interfaceC4014c);

    Object j(String str, String str2, InterfaceC4014c<? super Integer> interfaceC4014c);

    default Object k(TaskInfoCardEntity taskInfoCardEntity, InterfaceC4014c<? super TaskInfoCardUpsertResult> interfaceC4014c) {
        return f(this, taskInfoCardEntity, interfaceC4014c);
    }

    Object l(String str, InterfaceC4014c<? super TaskInfoCardEntity> interfaceC4014c);

    Object m(List<String> list, InterfaceC4014c<? super Integer> interfaceC4014c);

    Object n(TaskInfoCardEntity taskInfoCardEntity, InterfaceC4014c<? super Long> interfaceC4014c);

    Object o(String str, List<String> list, InterfaceC4014c<? super List<TaskInfoCardEntity>> interfaceC4014c);

    Object q(List<String> list, InterfaceC4014c<? super Integer> interfaceC4014c);

    default Object r(TaskInfoCardEntity taskInfoCardEntity, InterfaceC4014c<? super TaskInfoCardUpsertOutcome> interfaceC4014c) {
        return p(this, taskInfoCardEntity, interfaceC4014c);
    }

    Object s(String str, boolean z10, InterfaceC4014c<? super Integer> interfaceC4014c);

    Object t(String str, String str2, InterfaceC4014c<? super List<TaskInfoCardEntity>> interfaceC4014c);

    Object u(String str, String str2, InterfaceC4014c<? super Integer> interfaceC4014c);

    Object w(String str, List<String> list, InterfaceC4014c<? super List<TaskInfoCardEntity>> interfaceC4014c);

    Object x(String str, String str2, String str3, InterfaceC4014c<? super Integer> interfaceC4014c);

    default Object y(TaskInfoCardEntity taskInfoCardEntity, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return v(this, taskInfoCardEntity, interfaceC4014c);
    }

    Object z(String str, InterfaceC4014c<? super List<TaskInfoCardEntity>> interfaceC4014c);
}
