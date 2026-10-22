package com.stepos.ailauncher.taskstore.read;

import La.H;
import Ua.C1056g;
import Ua.C1060i;
import Ua.L0;
import Ua.M;
import Ua.Y;
import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import g9.C4109a;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlinx.coroutines.d;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tJ \u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0086@¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/stepos/ailauncher/taskstore/read/TaskReadStateManager;", "", "<init>", "()V", "", "taskId", "reason", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Ljava/lang/String;)V", "sessionId", "", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "LUa/M;", "scope", "LUa/M;", "TAG", "Ljava/lang/String;", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TaskReadStateManager {
    private static final String TAG = "TaskReadState";
    public static final TaskReadStateManager INSTANCE = new TaskReadStateManager();
    private static final M scope = d.a(L0.b(null, 1, null).plus(Y.b()));

    public final void a(String taskId, String reason) {
        p.i(taskId, "taskId");
        p.i(reason, "reason");
        if (H.x0(taskId)) {
            return;
        }
        C1060i.d(scope, null, null, new TaskReadStateManager$markRead$1(taskId, reason, null), 3, null);
    }

    public final Object b(String str, String str2, InterfaceC4014c<? super Integer> interfaceC4014c) {
        String string = H.D1(str).toString();
        return string.length() == 0 ? C4109a.f(0) : C1056g.j(Y.b(), new TaskReadStateManager$markSessionCompletedTasksRead$2(string, str2, null), interfaceC4014c);
    }
}
