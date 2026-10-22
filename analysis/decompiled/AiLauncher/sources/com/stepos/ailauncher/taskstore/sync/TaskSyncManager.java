package com.stepos.ailauncher.taskstore.sync;

import La.H;
import Xa.d;
import Xa.j;
import Xa.o;
import Xa.p;
import Y8.t;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.SessionHandler;
import com.stepos.ailauncher.agent.receiver.SystemDeleteBroadcastReceiver;
import com.stepos.ailauncher.chat.manager.AgentConfig;
import com.stepos.ailauncher.common.utils.C3197a;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import com.stepos.ailauncher.taskstore.TaskStoreModule;
import com.stepos.ailauncher.taskstore.entity.TaskInfoCard;
import com.stepos.ailauncher.taskstore.entity.TaskInfoStatus;
import com.stepos.ailauncher.taskstore.livenotification.A;
import e9.InterfaceC4014c;
import f9.C4063a;
import h8.C4148a;
import io.ktor.sse.ServerSentEventKt;
import java.util.Map;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J<\u0010\f\u001a\u00020\n2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0082@¢\u0006\u0004\b\f\u0010\rJF\u0010\u0014\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000f2\u001c\u0010\u0013\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0011H\u0082@¢\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0016H\u0082@¢\u0006\u0004\b\u0019\u0010\u001aJ\u001e\u0010\u001c\u001a\u00020\u00182\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00160\u0004H\u0082@¢\u0006\u0004\b\u001c\u0010\u001dJ4\u0010!\u001a\u00020\u00182\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\n2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001fH\u0082@¢\u0006\u0004\b!\u0010\"J\u0018\u0010%\u001a\u00020\u00182\u0006\u0010$\u001a\u00020#H\u0082@¢\u0006\u0004\b%\u0010&J\u000f\u0010(\u001a\u00020'H\u0002¢\u0006\u0004\b(\u0010)J\u000f\u0010+\u001a\u00020*H\u0002¢\u0006\u0004\b+\u0010,J\u0017\u0010-\u001a\u00020\u00182\u0006\u0010\u000e\u001a\u00020\u0005H\u0002¢\u0006\u0004\b-\u0010.J\u0019\u00100\u001a\u00020\u00182\b\u0010/\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b0\u0010.J,\u00102\u001a\u00020\n2\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u00160\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0086@¢\u0006\u0004\b2\u00103J\u001e\u00104\u001a\u00020\u00182\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0086@¢\u0006\u0004\b4\u0010\u001dJ\u0018\u00105\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u0005H\u0086@¢\u0006\u0004\b5\u00106JB\u0010;\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u00052\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001072\b\b\u0002\u00109\u001a\u00020\n2\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u0005H\u0086@¢\u0006\u0004\b;\u0010<J\u001a\u0010?\u001a\u00020\n2\b\u0010>\u001a\u0004\u0018\u00010=H\u0086@¢\u0006\u0004\b?\u0010@R\u0014\u0010A\u001a\u00020\u00058\u0002X\u0082T¢\u0006\u0006\n\u0004\bA\u0010BR\u001a\u0010D\u001a\b\u0012\u0004\u0012\u00020#0C8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bD\u0010ER\u001d\u0010G\u001a\b\u0012\u0004\u0012\u00020#0F8\u0006¢\u0006\f\n\u0004\bG\u0010H\u001a\u0004\bI\u0010J¨\u0006K"}, d2 = {"Lcom/stepos/ailauncher/taskstore/sync/TaskSyncManager;", "", "<init>", "()V", "", "", "taskIds", "sessionKeys", "Lcom/stepos/ailauncher/taskstore/sync/TaskSyncOp;", "op", "", "deleteConversations", "n", "(Ljava/util/List;Ljava/util/List;Lcom/stepos/ailauncher/taskstore/sync/TaskSyncOp;ZLe9/c;)Ljava/lang/Object;", "taskId", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoStatus;", "nextStatus", "Lkotlin/Function1;", "Le9/c;", "remote", "B", "(Ljava/lang/String;Lcom/stepos/ailauncher/taskstore/sync/TaskSyncOp;Lcom/stepos/ailauncher/taskstore/entity/TaskInfoStatus;Lp9/l;Le9/c;)Ljava/lang/Object;", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;", "updated", "LY8/t;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;Le9/c;)Ljava/lang/Object;", "snapshots", "y", "(Ljava/util/List;Le9/c;)Ljava/lang/Object;", "reverted", "", "cause", "r", "(Ljava/lang/String;Lcom/stepos/ailauncher/taskstore/sync/TaskSyncOp;ZLjava/lang/Throwable;Le9/c;)Ljava/lang/Object;", "Lcom/stepos/ailauncher/taskstore/sync/a;", "event", "q", "(Lcom/stepos/ailauncher/taskstore/sync/a;Le9/c;)Ljava/lang/Object;", "Lcom/stepos/ailauncher/taskstore/repository/a;", "x", "()Lcom/stepos/ailauncher/taskstore/repository/a;", "Lcom/stepos/agentframework/chatcore/SessionHandler;", "z", "()Lcom/stepos/agentframework/chatcore/SessionHandler;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Ljava/lang/String;)V", SystemDeleteBroadcastReceiver.EXTRA_SESSION_KEY, "l", DidiCardProvider.KEY_ITEMS, "o", "(Ljava/util/List;Ljava/util/List;Le9/c;)Ljava/lang/Object;", "t", "k", "(Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "", "answers", "cancel", "freeText", "v", "(Ljava/lang/String;Ljava/util/Map;ZLjava/lang/String;Le9/c;)Ljava/lang/Object;", "", "lastUpdateTs", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Ljava/lang/Long;Le9/c;)Ljava/lang/Object;", "TAG", "Ljava/lang/String;", "LXa/j;", "_events", "LXa/j;", "LXa/o;", "events", "LXa/o;", "u", "()LXa/o;", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TaskSyncManager {
    public static final TaskSyncManager INSTANCE = new TaskSyncManager();
    private static final String TAG = "TaskSyncManager";
    private static final j<a> _events;
    private static final o<a> events;

    static {
        j<a> jVarB = p.b(0, 16, null, 5, null);
        _events = jVarB;
        events = d.b(jVarB);
    }

    public static final t m(String str, boolean z10) {
        C4148a.k(TAG, "deleteConversation result key=" + str + " ok=" + z10, false, 4, null);
        return t.f7040a;
    }

    public static final CharSequence p(TaskInfoCard it) {
        kotlin.jvm.internal.p.i(it, "it");
        return it.getTaskId() + ServerSentEventKt.COLON + it.getStatus();
    }

    public static /* synthetic */ Object s(TaskSyncManager taskSyncManager, String str, TaskSyncOp taskSyncOp, boolean z10, Throwable th, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            th = null;
        }
        return taskSyncManager.r(str, taskSyncOp, z10, th, interfaceC4014c);
    }

    public static /* synthetic */ Object w(TaskSyncManager taskSyncManager, String str, Map map, boolean z10, String str2, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        boolean z11 = z10;
        if ((i10 & 8) != 0) {
            str2 = null;
        }
        return taskSyncManager.v(str, map, z11, str2, interfaceC4014c);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object A(java.lang.Long r12, e9.InterfaceC4014c<? super java.lang.Boolean> r13) {
        /*
            r11 = this;
            boolean r0 = r13 instanceof com.stepos.ailauncher.taskstore.sync.TaskSyncManager$syncTaskWithRemote$1
            if (r0 == 0) goto L13
            r0 = r13
            com.stepos.ailauncher.taskstore.sync.TaskSyncManager$syncTaskWithRemote$1 r0 = (com.stepos.ailauncher.taskstore.sync.TaskSyncManager$syncTaskWithRemote$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.ailauncher.taskstore.sync.TaskSyncManager$syncTaskWithRemote$1 r0 = new com.stepos.ailauncher.taskstore.sync.TaskSyncManager$syncTaskWithRemote$1
            r0.<init>(r11, r13)
        L18:
            java.lang.Object r13 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L45
            if (r2 != r3) goto L3d
            java.lang.Object r11 = r0.L$3
            e9.c r11 = (e9.InterfaceC4014c) r11
            java.lang.Object r11 = r0.L$2
            com.stepos.ailauncher.taskstore.sync.TaskSyncManager r11 = (com.stepos.ailauncher.taskstore.sync.TaskSyncManager) r11
            java.lang.Object r11 = r0.L$1
            com.stepos.ailauncher.taskstore.sync.TaskSyncManager r11 = (com.stepos.ailauncher.taskstore.sync.TaskSyncManager) r11
            java.lang.Object r11 = r0.L$0
            java.lang.Long r11 = (java.lang.Long) r11
            kotlin.C4849c.b(r13)     // Catch: java.lang.Throwable -> L3a
            goto L88
        L3a:
            r0 = move-exception
            r11 = r0
            goto L97
        L3d:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L45:
            kotlin.C4849c.b(r13)
            kotlin.Result$a r13 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L3a
            com.stepos.ailauncher.taskstore.sync.TaskSyncManager r13 = com.stepos.ailauncher.taskstore.sync.TaskSyncManager.INSTANCE     // Catch: java.lang.Throwable -> L3a
            com.stepos.agentframework.chatcore.SessionHandler r13 = g(r13)     // Catch: java.lang.Throwable -> L3a
            K6.I r2 = new K6.I     // Catch: java.lang.Throwable -> L3a
            if (r12 == 0) goto L5d
            long r5 = r12.longValue()     // Catch: java.lang.Throwable -> L3a
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch: java.lang.Throwable -> L3a
            goto L5e
        L5d:
            r5 = 0
        L5e:
            r2.<init>(r5)     // Catch: java.lang.Throwable -> L3a
            java.lang.Object r12 = g9.h.a(r12)     // Catch: java.lang.Throwable -> L3a
            r0.L$0 = r12     // Catch: java.lang.Throwable -> L3a
            java.lang.Object r12 = g9.h.a(r11)     // Catch: java.lang.Throwable -> L3a
            r0.L$1 = r12     // Catch: java.lang.Throwable -> L3a
            java.lang.Object r11 = g9.h.a(r11)     // Catch: java.lang.Throwable -> L3a
            r0.L$2 = r11     // Catch: java.lang.Throwable -> L3a
            java.lang.Object r11 = g9.h.a(r0)     // Catch: java.lang.Throwable -> L3a
            r0.L$3 = r11     // Catch: java.lang.Throwable -> L3a
            r0.I$0 = r4     // Catch: java.lang.Throwable -> L3a
            r0.I$1 = r4     // Catch: java.lang.Throwable -> L3a
            r0.I$2 = r4     // Catch: java.lang.Throwable -> L3a
            r0.label = r3     // Catch: java.lang.Throwable -> L3a
            java.lang.Object r13 = r13.f4(r2, r0)     // Catch: java.lang.Throwable -> L3a
            if (r13 != r1) goto L88
            return r1
        L88:
            java.lang.Boolean r13 = (java.lang.Boolean) r13     // Catch: java.lang.Throwable -> L3a
            boolean r11 = r13.booleanValue()     // Catch: java.lang.Throwable -> L3a
            java.lang.Boolean r11 = g9.C4109a.a(r11)     // Catch: java.lang.Throwable -> L3a
            java.lang.Object r11 = kotlin.Result.b(r11)     // Catch: java.lang.Throwable -> L3a
            goto La1
        L97:
            kotlin.Result$a r12 = kotlin.Result.INSTANCE
            java.lang.Object r11 = kotlin.C4849c.a(r11)
            java.lang.Object r11 = kotlin.Result.b(r11)
        La1:
            java.lang.Throwable r7 = kotlin.Result.e(r11)
            if (r7 == 0) goto Lb3
            r9 = 8
            r10 = 0
            java.lang.String r5 = "TaskSyncManager"
            java.lang.String r6 = "remote sync error"
            r8 = 0
            h8.C4148a.g(r5, r6, r7, r8, r9, r10)
        Lb3:
            java.lang.Boolean r12 = g9.C4109a.a(r4)
            boolean r13 = kotlin.Result.g(r11)
            if (r13 == 0) goto Lbe
            r11 = r12
        Lbe:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.taskstore.sync.TaskSyncManager.A(java.lang.Long, e9.c):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x027e, code lost:
    
        if (q(r4, r6) == r9) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x02f1, code lost:
    
        if (s(r52, r13, r12, r4, null, r6, 8, null) != r9) goto L64;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0205  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0226  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x023e  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0247  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0285  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x02b4 A[PHI: r0 r3 r7 r8 r11 r12 r13
      0x02b4: PHI (r0v11 boolean) = (r0v7 boolean), (r0v7 boolean), (r0v63 boolean) binds: [B:54:0x0285, B:56:0x02b1, B:14:0x0052] A[DONT_GENERATE, DONT_INLINE]
      0x02b4: PHI (r3v7 com.stepos.ailauncher.taskstore.entity.TaskInfoCard) = 
      (r3v29 com.stepos.ailauncher.taskstore.entity.TaskInfoCard)
      (r3v30 com.stepos.ailauncher.taskstore.entity.TaskInfoCard)
      (r3v31 com.stepos.ailauncher.taskstore.entity.TaskInfoCard)
     binds: [B:54:0x0285, B:56:0x02b1, B:14:0x0052] A[DONT_GENERATE, DONT_INLINE]
      0x02b4: PHI (r7v2 com.stepos.ailauncher.taskstore.repository.a) = 
      (r7v18 com.stepos.ailauncher.taskstore.repository.a)
      (r7v18 com.stepos.ailauncher.taskstore.repository.a)
      (r7v22 com.stepos.ailauncher.taskstore.repository.a)
     binds: [B:54:0x0285, B:56:0x02b1, B:14:0x0052] A[DONT_GENERATE, DONT_INLINE]
      0x02b4: PHI (r8v2 p9.l<? super e9.c<? super java.lang.Boolean>, ? extends java.lang.Object>) = 
      (r8v15 p9.l<? super e9.c<? super java.lang.Boolean>, ? extends java.lang.Object>)
      (r8v15 p9.l<? super e9.c<? super java.lang.Boolean>, ? extends java.lang.Object>)
      (r8v19 p9.l<? super e9.c<? super java.lang.Boolean>, ? extends java.lang.Object>)
     binds: [B:54:0x0285, B:56:0x02b1, B:14:0x0052] A[DONT_GENERATE, DONT_INLINE]
      0x02b4: PHI (r11v2 com.stepos.ailauncher.taskstore.entity.TaskInfoStatus) = 
      (r11v16 com.stepos.ailauncher.taskstore.entity.TaskInfoStatus)
      (r11v16 com.stepos.ailauncher.taskstore.entity.TaskInfoStatus)
      (r11v20 com.stepos.ailauncher.taskstore.entity.TaskInfoStatus)
     binds: [B:54:0x0285, B:56:0x02b1, B:14:0x0052] A[DONT_GENERATE, DONT_INLINE]
      0x02b4: PHI (r12v2 com.stepos.ailauncher.taskstore.sync.TaskSyncOp) = 
      (r12v12 com.stepos.ailauncher.taskstore.sync.TaskSyncOp)
      (r12v12 com.stepos.ailauncher.taskstore.sync.TaskSyncOp)
      (r12v16 com.stepos.ailauncher.taskstore.sync.TaskSyncOp)
     binds: [B:54:0x0285, B:56:0x02b1, B:14:0x0052] A[DONT_GENERATE, DONT_INLINE]
      0x02b4: PHI (r13v2 java.lang.String) = (r13v9 java.lang.String), (r13v9 java.lang.String), (r13v13 java.lang.String) binds: [B:54:0x0285, B:56:0x02b1, B:14:0x0052] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x02b6  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x02b8  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001a  */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v17, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v19 */
    /* JADX WARN: Type inference failed for: r3v24, types: [com.stepos.ailauncher.taskstore.entity.TaskInfoCard] */
    /* JADX WARN: Type inference failed for: r3v34 */
    /* JADX WARN: Type inference failed for: r3v35 */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r52v0, types: [com.stepos.ailauncher.taskstore.sync.TaskSyncManager, java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object B(java.lang.String r53, com.stepos.ailauncher.taskstore.sync.TaskSyncOp r54, com.stepos.ailauncher.taskstore.entity.TaskInfoStatus r55, p9.InterfaceC5074l<? super e9.InterfaceC4014c<? super java.lang.Boolean>, ? extends java.lang.Object> r56, e9.InterfaceC4014c<? super java.lang.Boolean> r57) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 780
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.taskstore.sync.TaskSyncManager.B(java.lang.String, com.stepos.ailauncher.taskstore.sync.TaskSyncOp, com.stepos.ailauncher.taskstore.entity.TaskInfoStatus, p9.l, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object i(com.stepos.ailauncher.taskstore.entity.TaskInfoCard r7, e9.InterfaceC4014c<? super Y8.t> r8) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.stepos.ailauncher.taskstore.sync.TaskSyncManager$applyOptimistic$1
            if (r0 == 0) goto L13
            r0 = r8
            com.stepos.ailauncher.taskstore.sync.TaskSyncManager$applyOptimistic$1 r0 = (com.stepos.ailauncher.taskstore.sync.TaskSyncManager$applyOptimistic$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.ailauncher.taskstore.sync.TaskSyncManager$applyOptimistic$1 r0 = new com.stepos.ailauncher.taskstore.sync.TaskSyncManager$applyOptimistic$1
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3d
            if (r2 != r3) goto L35
            java.lang.Object r6 = r0.L$1
            com.stepos.ailauncher.taskstore.sync.TaskSyncManager r6 = (com.stepos.ailauncher.taskstore.sync.TaskSyncManager) r6
            java.lang.Object r6 = r0.L$0
            r7 = r6
            com.stepos.ailauncher.taskstore.entity.TaskInfoCard r7 = (com.stepos.ailauncher.taskstore.entity.TaskInfoCard) r7
            kotlin.C4849c.b(r8)     // Catch: java.lang.Throwable -> L32
            goto L5a
        L32:
            r0 = move-exception
            r6 = r0
            goto L64
        L35:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3d:
            kotlin.C4849c.b(r8)
            kotlin.Result$a r8 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L32
            com.stepos.ailauncher.taskstore.repository.a r8 = r6.x()     // Catch: java.lang.Throwable -> L32
            r0.L$0 = r7     // Catch: java.lang.Throwable -> L32
            java.lang.Object r6 = g9.h.a(r6)     // Catch: java.lang.Throwable -> L32
            r0.L$1 = r6     // Catch: java.lang.Throwable -> L32
            r6 = 0
            r0.I$0 = r6     // Catch: java.lang.Throwable -> L32
            r0.label = r3     // Catch: java.lang.Throwable -> L32
            java.lang.Object r6 = r8.f(r7, r0)     // Catch: java.lang.Throwable -> L32
            if (r6 != r1) goto L5a
            return r1
        L5a:
            x6.b.a(r7)     // Catch: java.lang.Throwable -> L32
            Y8.t r6 = Y8.t.f7040a     // Catch: java.lang.Throwable -> L32
            java.lang.Object r6 = kotlin.Result.b(r6)     // Catch: java.lang.Throwable -> L32
            goto L6e
        L64:
            kotlin.Result$a r8 = kotlin.Result.INSTANCE
            java.lang.Object r6 = kotlin.C4849c.a(r6)
            java.lang.Object r6 = kotlin.Result.b(r6)
        L6e:
            java.lang.Throwable r2 = kotlin.Result.e(r6)
            if (r2 == 0) goto L92
            java.lang.String r6 = r7.getTaskId()
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "applyOptimistic failed: "
            r7.append(r8)
            r7.append(r6)
            java.lang.String r1 = r7.toString()
            r4 = 8
            r5 = 0
            java.lang.String r0 = "TaskSyncManager"
            r3 = 0
            h8.C4148a.g(r0, r1, r2, r3, r4, r5)
        L92:
            Y8.t r6 = Y8.t.f7040a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.taskstore.sync.TaskSyncManager.i(com.stepos.ailauncher.taskstore.entity.TaskInfoCard, e9.c):java.lang.Object");
    }

    public final void j(String taskId) {
        Object objB;
        try {
            Result.Companion companion = Result.INSTANCE;
            A.INSTANCE.a(C3197a.INSTANCE.a(), taskId);
            objB = Result.b(t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.t(TAG, "cancelLiveNotification failed: " + taskId, thE, false, 8, null);
        }
    }

    public final Object k(String str, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return B(str, TaskSyncOp.CANCEL, TaskInfoStatus.CANCELLED, new TaskSyncManager$cancelTask$2(str, null), interfaceC4014c);
    }

    public final void l(final String sessionKey) {
        Object objB;
        if (sessionKey != null) {
            if (H.x0(sessionKey)) {
                sessionKey = null;
            }
            if (sessionKey == null) {
                return;
            }
            try {
                Result.Companion companion = Result.INSTANCE;
                z().g1(sessionKey, new InterfaceC5074l() { // from class: com.stepos.ailauncher.taskstore.sync.b
                    @Override // p9.InterfaceC5074l
                    public final Object invoke(Object obj) {
                        return TaskSyncManager.m(sessionKey, ((Boolean) obj).booleanValue());
                    }
                });
                objB = Result.b(t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            Throwable thE = Result.e(objB);
            if (thE != null) {
                C4148a.t(TAG, "deleteConversation failed: " + sessionKey, thE, false, 8, null);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:75:0x0253, code lost:
    
        if (r7.q(r9, r3) == r4) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x02f3, code lost:
    
        if (r2 == r4) goto L84;
     */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x025c  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0264  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x029e  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x02f8  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:75:0x0253 -> B:77:0x0257). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:83:0x02f3 -> B:14:0x005e). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object n(java.util.List<java.lang.String> r18, java.util.List<java.lang.String> r19, com.stepos.ailauncher.taskstore.sync.TaskSyncOp r20, boolean r21, e9.InterfaceC4014c<? super java.lang.Boolean> r22) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 766
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.taskstore.sync.TaskSyncManager.n(java.util.List, java.util.List, com.stepos.ailauncher.taskstore.sync.TaskSyncOp, boolean, e9.c):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:81:0x03ba, code lost:
    
        if (r0 == r1) goto L108;
     */
    /* JADX WARN: Removed duplicated region for block: B:105:0x04d0 A[LOOP:1: B:103:0x04ca->B:105:0x04d0, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:109:0x051a  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0524  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x03e4  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x03fe  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0407  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0448  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object o(java.util.List<com.stepos.ailauncher.taskstore.entity.TaskInfoCard> r31, java.util.List<java.lang.String> r32, e9.InterfaceC4014c<? super java.lang.Boolean> r33) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1363
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.taskstore.sync.TaskSyncManager.o(java.util.List, java.util.List, e9.c):java.lang.Object");
    }

    public final Object q(a aVar, InterfaceC4014c<? super t> interfaceC4014c) {
        Object objEmit = _events.emit(aVar, interfaceC4014c);
        return objEmit == C4063a.g() ? objEmit : t.f7040a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0092, code lost:
    
        if (q(r10, r0) == r1) goto L22;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object r(java.lang.String r6, com.stepos.ailauncher.taskstore.sync.TaskSyncOp r7, boolean r8, java.lang.Throwable r9, e9.InterfaceC4014c<? super Y8.t> r10) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r10 instanceof com.stepos.ailauncher.taskstore.sync.TaskSyncManager$emitFailure$1
            if (r0 == 0) goto L13
            r0 = r10
            com.stepos.ailauncher.taskstore.sync.TaskSyncManager$emitFailure$1 r0 = (com.stepos.ailauncher.taskstore.sync.TaskSyncManager$emitFailure$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.ailauncher.taskstore.sync.TaskSyncManager$emitFailure$1 r0 = new com.stepos.ailauncher.taskstore.sync.TaskSyncManager$emitFailure$1
            r0.<init>(r5, r10)
        L18:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L54
            if (r2 == r4) goto L40
            if (r2 != r3) goto L38
            java.lang.Object r5 = r0.L$2
            java.lang.Throwable r5 = (java.lang.Throwable) r5
            java.lang.Object r5 = r0.L$1
            com.stepos.ailauncher.taskstore.sync.TaskSyncOp r5 = (com.stepos.ailauncher.taskstore.sync.TaskSyncOp) r5
            java.lang.Object r5 = r0.L$0
            java.lang.String r5 = (java.lang.String) r5
            kotlin.C4849c.b(r10)
            goto L95
        L38:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L40:
            boolean r8 = r0.Z$0
            java.lang.Object r6 = r0.L$2
            r9 = r6
            java.lang.Throwable r9 = (java.lang.Throwable) r9
            java.lang.Object r6 = r0.L$1
            r7 = r6
            com.stepos.ailauncher.taskstore.sync.TaskSyncOp r7 = (com.stepos.ailauncher.taskstore.sync.TaskSyncOp) r7
            java.lang.Object r6 = r0.L$0
            java.lang.String r6 = (java.lang.String) r6
            kotlin.C4849c.b(r10)
            goto L71
        L54:
            kotlin.C4849c.b(r10)
            com.stepos.ailauncher.taskstore.sync.a$a r10 = new com.stepos.ailauncher.taskstore.sync.a$a
            r10.<init>(r6, r7, r9)
            r0.L$0 = r6
            r0.L$1 = r7
            java.lang.Object r2 = g9.h.a(r9)
            r0.L$2 = r2
            r0.Z$0 = r8
            r0.label = r4
            java.lang.Object r10 = r5.q(r10, r0)
            if (r10 != r1) goto L71
            goto L94
        L71:
            if (r8 == 0) goto L98
            com.stepos.ailauncher.taskstore.sync.a$b r10 = new com.stepos.ailauncher.taskstore.sync.a$b
            r10.<init>(r6, r7)
            java.lang.Object r6 = g9.h.a(r6)
            r0.L$0 = r6
            java.lang.Object r6 = g9.h.a(r7)
            r0.L$1 = r6
            java.lang.Object r6 = g9.h.a(r9)
            r0.L$2 = r6
            r0.Z$0 = r8
            r0.label = r3
            java.lang.Object r5 = r5.q(r10, r0)
            if (r5 != r1) goto L95
        L94:
            return r1
        L95:
            Y8.t r5 = Y8.t.f7040a
            return r5
        L98:
            Y8.t r5 = Y8.t.f7040a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.taskstore.sync.TaskSyncManager.r(java.lang.String, com.stepos.ailauncher.taskstore.sync.TaskSyncOp, boolean, java.lang.Throwable, e9.c):java.lang.Object");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(13:0|2|(2:4|(1:6)(1:8))(0)|7|9|(1:(1:(1:(3:14|87|88)(2:15|16))(13:17|89|18|57|62|(1:64)|65|(1:67)|68|(4:71|(2:73|96)(1:97)|74|69)|95|75|(2:77|78)(6:79|(2:82|80)|98|83|(3:86|87|88)|85)))(1:22))(8:23|(2:26|24)|99|27|(4:30|(3:101|32|104)(1:103)|102|28)|100|33|(2:35|36)(3:37|(1:40)|85))|41|93|42|46|(1:48)|49|(2:51|52)(4:91|53|(11:56|57|62|(0)|65|(0)|68|(1:69)|95|75|(0)(0))|85)) */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0157, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0158, code lost:
    
        r14 = kotlin.Result.INSTANCE;
        r0 = kotlin.Result.b(kotlin.C4849c.a(r0));
     */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01f9  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0218  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0247  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object t(java.util.List<java.lang.String> r28, e9.InterfaceC4014c<? super Y8.t> r29) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 704
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.taskstore.sync.TaskSyncManager.t(java.util.List, e9.c):java.lang.Object");
    }

    public final o<a> u() {
        return events;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(20:0|2|(2:4|(1:6)(1:8))(0)|7|9|(1:(1:(1:(3:18|87|88)(2:16|17))(12:19|93|20|65|72|(1:74)|75|(1:77)|78|(1:80)(1:84)|87|88))(4:24|103|25|26))(2:30|(9:58|57|89|59|60|95|61|(10:64|65|72|(0)|75|(0)|78|(0)(0)|87|88)|86)(10:91|34|35|101|36|37|99|38|(1:41)|86))|97|42|53|(1:55)|56|57|89|59|60|95|61|(0)|86|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00db, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x018a, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x018b, code lost:
    
        r8 = r10;
        r4 = r22;
        r3 = r24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0191, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0192, code lost:
    
        r10 = r21;
        r2 = r23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x01f1, code lost:
    
        if (q(r5, r6) == r9) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x01f4, code lost:
    
        r1 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0221, code lost:
    
        if (s(r30, r8, r3, false, null, r6, 8, null) == r9) goto L86;
     */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01f6  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object v(java.lang.String r31, java.util.Map<java.lang.String, ? extends java.lang.Object> r32, boolean r33, java.lang.String r34, e9.InterfaceC4014c<? super java.lang.Boolean> r35) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 553
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.taskstore.sync.TaskSyncManager.v(java.lang.String, java.util.Map, boolean, java.lang.String, e9.c):java.lang.Object");
    }

    public final com.stepos.ailauncher.taskstore.repository.a x() {
        return TaskStoreModule.INSTANCE.n();
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x014c -> B:26:0x0151). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object y(java.util.List<com.stepos.ailauncher.taskstore.entity.TaskInfoCard> r56, e9.InterfaceC4014c<? super Y8.t> r57) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 409
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.taskstore.sync.TaskSyncManager.y(java.util.List, e9.c):java.lang.Object");
    }

    public final SessionHandler z() {
        return AgentConfig.INSTANCE.a().n();
    }
}
