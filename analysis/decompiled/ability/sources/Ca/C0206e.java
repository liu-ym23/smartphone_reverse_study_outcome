package Ca;

import m9.C1724q;
import s2.C1912a;
import stepai.aios.guiagent.model.SessionState;
import xa.InterfaceC2124a;

/* renamed from: Ca.e, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0206e implements InterfaceC2124a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f348a;
    public final /* synthetic */ stepai.aios.guiagent.runtime.a b;
    public final /* synthetic */ kotlinx.coroutines.flow.i c;
    public final /* synthetic */ kotlinx.coroutines.flow.h d;
    public final /* synthetic */ C1724q e;

    public C0206e(String str, kotlinx.coroutines.flow.h hVar, kotlinx.coroutines.flow.i iVar, C1724q c1724q, stepai.aios.guiagent.runtime.a aVar) {
        this.f348a = str;
        this.b = aVar;
        this.c = iVar;
        this.d = hVar;
        this.e = c1724q;
    }

    @Override // xa.InterfaceC2124a
    public final void onStepCancelled(za.i taskInfo, za.g gVar) {
        kotlin.jvm.internal.k.f(taskInfo, "taskInfo");
        if (kotlin.jvm.internal.k.b(taskInfo.f7018a, this.f348a)) {
            this.b.k(this.d, new l(taskInfo, gVar));
        }
    }

    @Override // xa.InterfaceC2124a
    public final void onStepCompleted(za.i taskInfo, za.g gVar) {
        kotlin.jvm.internal.k.f(taskInfo, "taskInfo");
        if (kotlin.jvm.internal.k.b(taskInfo.f7018a, this.f348a)) {
            this.b.k(this.d, new m(taskInfo, gVar));
        }
    }

    @Override // xa.InterfaceC2124a
    public final void onStepExecuting(za.i taskInfo, za.g gVar) {
        kotlin.jvm.internal.k.f(taskInfo, "taskInfo");
        if (kotlin.jvm.internal.k.b(taskInfo.f7018a, this.f348a)) {
            this.b.k(this.d, new n(taskInfo, gVar));
        }
    }

    @Override // xa.InterfaceC2124a
    public final void onStepFailed(za.i taskInfo, za.g gVar, Throwable th) {
        kotlin.jvm.internal.k.f(taskInfo, "taskInfo");
        if (kotlin.jvm.internal.k.b(taskInfo.f7018a, this.f348a)) {
            this.b.k(this.d, new o(taskInfo, gVar, th));
        }
    }

    @Override // xa.InterfaceC2124a
    public final void onStepRetrying(za.i taskInfo, za.g gVar, int i) {
        kotlin.jvm.internal.k.f(taskInfo, "taskInfo");
        if (kotlin.jvm.internal.k.b(taskInfo.f7018a, this.f348a)) {
            this.b.k(this.d, new p(taskInfo, gVar));
        }
    }

    @Override // xa.InterfaceC2124a
    public final void onStepStarted(za.i taskInfo, za.g gVar) {
        kotlin.jvm.internal.k.f(taskInfo, "taskInfo");
        if (kotlin.jvm.internal.k.b(taskInfo.f7018a, this.f348a)) {
            this.b.k(this.d, new q(taskInfo, gVar));
        }
    }

    @Override // xa.InterfaceC2124a
    public final void onTaskCancelled(za.i iVar, String reason) {
        kotlin.jvm.internal.k.f(reason, "reason");
        String str = iVar.f7018a;
        String str2 = this.f348a;
        if (kotlin.jvm.internal.k.b(str, str2)) {
            kotlinx.coroutines.flow.i iVar2 = this.c;
            SessionState sessionState = iVar.c;
            stepai.aios.guiagent.runtime.a aVar = this.b;
            if (stepai.aios.guiagent.runtime.a.e(aVar, str2, iVar2, sessionState)) {
                stepai.aios.guiagent.runtime.a.i(za.d.a(C1912a.j(reason), str), this.e);
                aVar.k(this.d, new r(iVar, reason));
                aVar.l(str2, null, "task cancelled");
            }
        }
    }

    @Override // xa.InterfaceC2124a
    public final void onTaskCompleted(za.i iVar, za.d dVar) {
        String str = iVar.f7018a;
        String str2 = this.f348a;
        if (kotlin.jvm.internal.k.b(str, str2)) {
            kotlinx.coroutines.flow.i iVar2 = this.c;
            SessionState sessionState = iVar.c;
            stepai.aios.guiagent.runtime.a aVar = this.b;
            if (stepai.aios.guiagent.runtime.a.e(aVar, str2, iVar2, sessionState)) {
                stepai.aios.guiagent.runtime.a.i(dVar, this.e);
                aVar.k(this.d, new s(iVar, dVar));
                aVar.l(str2, null, "task completed");
            }
        }
    }

    @Override // xa.InterfaceC2124a
    public final void onTaskCreated(za.i taskInfo) {
        kotlin.jvm.internal.k.f(taskInfo, "taskInfo");
        String str = taskInfo.f7018a;
        String str2 = this.f348a;
        if (kotlin.jvm.internal.k.b(str, str2)) {
            kotlinx.coroutines.flow.i iVar = this.c;
            SessionState sessionState = taskInfo.c;
            stepai.aios.guiagent.runtime.a aVar = this.b;
            if (stepai.aios.guiagent.runtime.a.e(aVar, str2, iVar, sessionState)) {
                aVar.k(this.d, new t(taskInfo));
            }
        }
    }

    @Override // xa.InterfaceC2124a
    public final void onTaskFailed(za.i iVar, Throwable th) {
        String str = iVar.f7018a;
        String str2 = this.f348a;
        if (kotlin.jvm.internal.k.b(str, str2)) {
            kotlinx.coroutines.flow.i iVar2 = this.c;
            SessionState sessionState = iVar.c;
            stepai.aios.guiagent.runtime.a aVar = this.b;
            if (stepai.aios.guiagent.runtime.a.e(aVar, str2, iVar2, sessionState)) {
                String message = th.getMessage();
                if (message == null) {
                    message = "Task failed";
                }
                stepai.aios.guiagent.runtime.a.i(za.d.a(C1912a.j(message), str), this.e);
                aVar.k(this.d, new u(iVar, th));
                aVar.l(str2, null, "task failed");
            }
        }
    }

    @Override // xa.InterfaceC2124a
    public final void onTaskPaused(za.i taskInfo) {
        kotlin.jvm.internal.k.f(taskInfo, "taskInfo");
        String str = taskInfo.f7018a;
        String str2 = this.f348a;
        if (kotlin.jvm.internal.k.b(str, str2)) {
            kotlinx.coroutines.flow.i iVar = this.c;
            SessionState sessionState = taskInfo.c;
            stepai.aios.guiagent.runtime.a aVar = this.b;
            if (stepai.aios.guiagent.runtime.a.e(aVar, str2, iVar, sessionState)) {
                aVar.k(this.d, new v(taskInfo));
            }
        }
    }

    @Override // xa.InterfaceC2124a
    public final void onTaskRecoveredFromTakeover(za.i taskInfo) {
        kotlin.jvm.internal.k.f(taskInfo, "taskInfo");
        String str = taskInfo.f7018a;
        String str2 = this.f348a;
        if (kotlin.jvm.internal.k.b(str, str2)) {
            kotlinx.coroutines.flow.i iVar = this.c;
            SessionState sessionState = taskInfo.c;
            stepai.aios.guiagent.runtime.a aVar = this.b;
            if (stepai.aios.guiagent.runtime.a.e(aVar, str2, iVar, sessionState)) {
                aVar.k(this.d, new w(taskInfo));
            }
        }
    }

    @Override // xa.InterfaceC2124a
    public final void onTaskRecoveryStarted(za.i taskInfo) {
        kotlin.jvm.internal.k.f(taskInfo, "taskInfo");
        String str = taskInfo.f7018a;
        String str2 = this.f348a;
        if (kotlin.jvm.internal.k.b(str, str2)) {
            kotlinx.coroutines.flow.i iVar = this.c;
            SessionState sessionState = taskInfo.c;
            stepai.aios.guiagent.runtime.a aVar = this.b;
            if (stepai.aios.guiagent.runtime.a.e(aVar, str2, iVar, sessionState)) {
                aVar.k(this.d, new x(taskInfo));
            }
        }
    }

    @Override // xa.InterfaceC2124a
    public final void onTaskResumed(za.i taskInfo) {
        kotlin.jvm.internal.k.f(taskInfo, "taskInfo");
        String str = taskInfo.f7018a;
        String str2 = this.f348a;
        if (kotlin.jvm.internal.k.b(str, str2)) {
            kotlinx.coroutines.flow.i iVar = this.c;
            SessionState sessionState = taskInfo.c;
            stepai.aios.guiagent.runtime.a aVar = this.b;
            if (stepai.aios.guiagent.runtime.a.e(aVar, str2, iVar, sessionState)) {
                aVar.k(this.d, new y(taskInfo));
            }
        }
    }

    @Override // xa.InterfaceC2124a
    public final void onTaskRunning(za.i taskInfo, za.c progress) {
        kotlin.jvm.internal.k.f(taskInfo, "taskInfo");
        kotlin.jvm.internal.k.f(progress, "progress");
        String str = taskInfo.f7018a;
        String str2 = this.f348a;
        if (kotlin.jvm.internal.k.b(str, str2)) {
            kotlinx.coroutines.flow.i iVar = this.c;
            SessionState sessionState = taskInfo.c;
            stepai.aios.guiagent.runtime.a aVar = this.b;
            if (stepai.aios.guiagent.runtime.a.e(aVar, str2, iVar, sessionState)) {
                aVar.k(this.d, new z(taskInfo, progress));
            }
        }
    }

    @Override // xa.InterfaceC2124a
    public final void onTaskStarted(za.i taskInfo) {
        kotlin.jvm.internal.k.f(taskInfo, "taskInfo");
        String str = taskInfo.f7018a;
        String str2 = this.f348a;
        if (kotlin.jvm.internal.k.b(str, str2)) {
            kotlinx.coroutines.flow.i iVar = this.c;
            SessionState sessionState = taskInfo.c;
            stepai.aios.guiagent.runtime.a aVar = this.b;
            if (stepai.aios.guiagent.runtime.a.e(aVar, str2, iVar, sessionState)) {
                aVar.k(this.d, new A(taskInfo));
            }
        }
    }

    @Override // xa.InterfaceC2124a
    public final void onTaskTakenOver(za.i iVar, String reason) {
        kotlin.jvm.internal.k.f(reason, "reason");
        String str = iVar.f7018a;
        String str2 = this.f348a;
        if (kotlin.jvm.internal.k.b(str, str2)) {
            kotlinx.coroutines.flow.i iVar2 = this.c;
            SessionState sessionState = iVar.c;
            stepai.aios.guiagent.runtime.a aVar = this.b;
            if (stepai.aios.guiagent.runtime.a.e(aVar, str2, iVar2, sessionState)) {
                stepai.aios.guiagent.runtime.a.i(C1912a.m(str, reason), this.e);
                C0205d c0205d = (C0205d) aVar.h.get(str2);
                if (c0205d != null) {
                    aVar.n(c0205d);
                }
                aVar.k(this.d, new B(iVar, reason));
            }
        }
    }
}
