package com.stepos.ailauncher.task.space;

import Ua.C1060i;
import android.content.Context;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.taskstore.TaskStoreModule;
import com.stepos.ailauncher.taskstore.vector.DataCenterVectorIndex;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000M\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\u0016\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0013\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\u000b\u001a\u00020\n*\u00020\tH\u0000¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001a\u001a\u00020\u00198\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/stepos/ailauncher/task/space/TaskStoreVectorIndexBridge;", "", "<init>", "()V", "Landroid/content/Context;", "context", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Landroid/content/Context;)V", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;", "Lcom/stepos/ailauncher/taskstore/vector/DataCenterVectorIndex$a;", "c", "(Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;)Lcom/stepos/ailauncher/taskstore/vector/DataCenterVectorIndex$a;", "LUa/M;", "scope", "LUa/M;", "", "installed", "Z", "com/stepos/ailauncher/task/space/TaskStoreVectorIndexBridge$observer$1", "observer", "Lcom/stepos/ailauncher/task/space/TaskStoreVectorIndexBridge$observer$1;", "", "STARTUP_SYNC_RETRY_DELAYS_MS", "[J", "", "TAG", "Ljava/lang/String;", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TaskStoreVectorIndexBridge {
    private static final String TAG = "TaskStoreVectorBridge";
    private static volatile boolean installed;
    public static final TaskStoreVectorIndexBridge INSTANCE = new TaskStoreVectorIndexBridge();
    private static final Ua.M scope = kotlinx.coroutines.d.a(Ua.L0.b(null, 1, null).plus(Ua.Y.b()));
    private static final TaskStoreVectorIndexBridge$observer$1 observer = new TaskStoreVectorIndexBridge$observer$1();
    private static final long[] STARTUP_SYNC_RETRY_DELAYS_MS = {0, 10000, 60000, 180000};

    public final void b(Context context) {
        kotlin.jvm.internal.p.i(context, "context");
        if (installed) {
            return;
        }
        synchronized (this) {
            if (installed) {
                return;
            }
            DataCenterVectorIndex.INSTANCE.C(context);
            TaskStoreModule.INSTANCE.K(observer);
            installed = true;
            Y8.t tVar = Y8.t.f7040a;
            C1060i.d(scope, null, null, new TaskStoreVectorIndexBridge$install$2(null), 3, null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x006e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.stepos.ailauncher.taskstore.vector.DataCenterVectorIndex.TaskVectorRecord c(com.stepos.ailauncher.taskstore.entity.TaskInfoCard r22) {
        /*
            r21 = this;
            r0 = r22
            java.lang.String r1 = "<this>"
            kotlin.jvm.internal.p.i(r0, r1)
            java.lang.String r3 = r0.getTaskId()
            java.lang.String r4 = r0.getParentTaskId()
            java.util.List r5 = r0.getSubTaskIds()
            com.stepos.ailauncher.taskstore.entity.TaskInfoEventType r1 = r0.getEventType()
            java.lang.String r6 = r1.name()
            java.lang.String r7 = r0.getType()
            java.lang.Integer r8 = r0.getVersion()
            java.lang.String r1 = r0.getTitle()
            java.lang.String r2 = ""
            if (r1 != 0) goto L2d
            r9 = r2
            goto L2e
        L2d:
            r9 = r1
        L2e:
            java.lang.String r1 = r0.getSubTitle()
            if (r1 != 0) goto L36
            r10 = r2
            goto L37
        L36:
            r10 = r1
        L37:
            java.lang.String r1 = r0.getSummary()
            if (r1 != 0) goto L3f
            r11 = r2
            goto L40
        L3f:
            r11 = r1
        L40:
            java.lang.String r1 = r0.getIntention()
            if (r1 != 0) goto L48
            r12 = r2
            goto L49
        L48:
            r12 = r1
        L49:
            com.stepos.ailauncher.taskstore.entity.TaskInfoStatus r1 = r0.getStatus()
            java.lang.String r13 = r1.name()
            com.stepos.ailauncher.task.space.TaskSearchTextExtractor r1 = com.stepos.ailauncher.task.space.TaskSearchTextExtractor.INSTANCE
            com.stepos.ailauncher.taskstore.entity.TaskInfoStatus r2 = r0.getStatus()
            java.lang.String r14 = r1.v(r2)
            java.lang.String r2 = r0.getRequestSessionKey()
            if (r2 == 0) goto L6e
            boolean r15 = La.H.x0(r2)
            if (r15 != 0) goto L68
            goto L69
        L68:
            r2 = 0
        L69:
            if (r2 != 0) goto L6c
            goto L6e
        L6c:
            r15 = r2
            goto L73
        L6e:
            java.lang.String r2 = r0.getSessionKey()
            goto L6c
        L73:
            long r16 = r0.getCreatedAt()
            long r18 = r0.getUpdatedAt()
            java.lang.String r20 = r1.q(r0)
            com.stepos.ailauncher.taskstore.vector.DataCenterVectorIndex$a r2 = new com.stepos.ailauncher.taskstore.vector.DataCenterVectorIndex$a
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r18, r20)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.task.space.TaskStoreVectorIndexBridge.c(com.stepos.ailauncher.taskstore.entity.TaskInfoCard):com.stepos.ailauncher.taskstore.vector.DataCenterVectorIndex$a");
    }
}
