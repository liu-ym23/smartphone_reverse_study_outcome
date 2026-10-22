package com.stepos.ability.runtime;

import C7.r;
import android.content.Context;
import android.util.Log;
import com.stepos.ability.api.ability.calltool.ICallTool;
import com.stepos.ability.api.ability.monitor.IMonitor;
import com.stepos.ability.api.ability.runtime.IRuntimeManager;
import com.stepos.ability.beaninternal.ability.AbilityTask;
import com.stepos.ability.database.dao.AbilityTaskDao;
import com.stepos.ability.runtime.model.CoroutinePriorityTask;
import com.stepos.taskrobot.llmapi.stepfun.g;
import java.util.Collection;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.k;
import m9.AbstractC1683A;
import m9.AbstractC1691I;
import m9.c0;
import m9.q0;
import s9.C1923c;
import u9.c;
import u9.d;

/* loaded from: classes3.dex */
public final class b implements IRuntimeManager {

    /* renamed from: a, reason: collision with root package name */
    public AbilityTaskDao f3228a;
    public ICallTool b;
    public IMonitor c;
    public volatile boolean d;
    public final ConcurrentHashMap e = new ConcurrentHashMap();
    public final PriorityQueue f = new PriorityQueue();
    public C1923c g;
    public kotlinx.coroutines.channels.a h;
    public q0 i;

    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(com.stepos.ability.runtime.b r23, com.stepos.ability.database.dao.AbilityTaskDao r24, kotlin.coroutines.jvm.internal.ContinuationImpl r25) {
        /*
            r1 = r23
            r0 = r25
            boolean r2 = r0 instanceof com.stepos.ability.runtime.RuntimeManager$recoverTask$1
            if (r2 == 0) goto L17
            r2 = r0
            com.stepos.ability.runtime.RuntimeManager$recoverTask$1 r2 = (com.stepos.ability.runtime.RuntimeManager$recoverTask$1) r2
            int r3 = r2.c
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L17
            int r3 = r3 - r4
            r2.c = r3
            goto L1c
        L17:
            com.stepos.ability.runtime.RuntimeManager$recoverTask$1 r2 = new com.stepos.ability.runtime.RuntimeManager$recoverTask$1
            r2.<init>(r1, r0)
        L1c:
            java.lang.Object r0 = r2.f3222a
            kotlin.coroutines.intrinsics.CoroutineSingletons r3 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r4 = r2.c
            java.lang.String r5 = "RuntimeManager"
            r6 = 1
            if (r4 == 0) goto L37
            if (r4 != r6) goto L2f
            kotlin.b.b(r0)     // Catch: java.lang.Exception -> L2d
            goto L45
        L2d:
            r0 = move-exception
            goto L48
        L2f:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L37:
            kotlin.b.b(r0)
            r2.c = r6     // Catch: java.lang.Exception -> L2d
            r0 = r24
            java.lang.Object r0 = r0.loadUnfinishedTasks(r2)     // Catch: java.lang.Exception -> L2d
            if (r0 != r3) goto L45
            return r3
        L45:
            java.util.List r0 = (java.util.List) r0     // Catch: java.lang.Exception -> L2d
            goto L53
        L48:
            java.lang.String r0 = r0.getMessage()
            java.lang.String r2 = "recoverTask load failed: "
            androidx.constraintlayout.core.dsl.a.w(r2, r0, r5)
            kotlin.collections.EmptyList r0 = kotlin.collections.EmptyList.f4893a
        L53:
            r2 = r0
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.Iterator r2 = r2.iterator()
        L5a:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L9a
            java.lang.Object r3 = r2.next()
            com.stepos.ability.database.entity.AbilityTaskEntity r3 = (com.stepos.ability.database.entity.AbilityTaskEntity) r3
            java.lang.String r4 = "entity"
            kotlin.jvm.internal.k.f(r3, r4)
            java.lang.String r7 = r3.b
            java.lang.Long r8 = r3.c
            java.lang.String r11 = r3.d
            java.lang.String r12 = r3.e
            java.lang.String r9 = r3.f
            java.lang.String r10 = r3.g
            int r13 = r3.f3083j
            boolean r4 = r3.l
            java.lang.String r6 = r3.m
            java.lang.String r14 = r3.n
            int r3 = r3.o
            r18 = r6
            com.stepos.ability.beaninternal.ability.AbilityTask r6 = new com.stepos.ability.beaninternal.ability.AbilityTask
            r21 = 384(0x180, float:5.38E-43)
            r22 = 0
            r19 = r14
            r14 = 0
            r15 = 0
            r16 = 0
            r20 = r3
            r17 = r4
            r6.<init>(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            r1.submit(r6)
            goto L5a
        L9a:
            int r0 = r0.size()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Recovering "
            r1.<init>(r2)
            r1.append(r0)
            java.lang.String r0 = " tasks."
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            android.util.Log.i(r5, r0)
            C7.r r0 = C7.r.f317a
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ability.runtime.b.a(com.stepos.ability.runtime.b, com.stepos.ability.database.dao.AbilityTaskDao, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    @Override // com.stepos.ability.api.ability.runtime.IRuntimeManager
    public final void cancel(AbilityTask task) {
        k.f(task, "task");
        c0 c0Var = (c0) this.e.get(task.getTaskCode());
        if (c0Var != null) {
            c0Var.cancel(null);
        }
        this.e.remove(task.getTaskCode());
        synchronized (this.f) {
            this.f.removeIf(new androidx.window.embedding.b(new g(task, 13), 12));
        }
        kotlinx.coroutines.channels.a aVar = this.h;
        if (aVar != null) {
            aVar.a(r.f317a);
        }
        C1923c c1923c = this.g;
        if (c1923c != null) {
            AbstractC1683A.n(c1923c, null, new RuntimeManager$cancel$2(this, task, null), 3);
        }
        Log.i("RuntimeManager", "Task cancelled: " + task.getTaskCode());
    }

    @Override // com.stepos.ability.api.ability.runtime.IRuntimeManager
    public final void cleanUp() {
        Collection<c0> collectionValues = this.e.values();
        k.e(collectionValues, "<get-values>(...)");
        for (c0 c0Var : collectionValues) {
            k.c(c0Var);
            c0Var.cancel(null);
        }
        this.e.clear();
        synchronized (this.f) {
            this.f.clear();
        }
        Log.i("RuntimeManager", "All tasks cleaned up");
    }

    @Override // com.stepos.ability.commoninternal.ability.IComponent
    public final void destroy() {
        q0 q0Var = this.i;
        if (q0Var != null) {
            q0Var.cancel(null);
        }
        this.i = null;
        C1923c c1923c = this.g;
        if (c1923c != null) {
            AbstractC1683A.e(c1923c, null);
        }
        this.g = null;
        try {
            kotlinx.coroutines.channels.a aVar = this.h;
            if (aVar != null) {
                aVar.s(null);
            }
        } catch (Exception unused) {
        }
        this.h = null;
        this.e.clear();
        synchronized (this.f) {
            this.f.clear();
        }
        Log.i("RuntimeManager", "destroy end.");
    }

    @Override // com.stepos.ability.api.ability.runtime.IRuntimeManager
    public final void pause() {
        this.d = true;
        Log.i("RuntimeManager", "pause task.");
    }

    @Override // com.stepos.ability.api.ability.runtime.IRuntimeManager
    public final void resume() {
        this.d = false;
        kotlinx.coroutines.channels.a aVar = this.h;
        if (aVar != null) {
            aVar.a(r.f317a);
        }
    }

    @Override // com.stepos.ability.api.ability.runtime.IRuntimeManager
    public final void saveRuntimeState() throws Throwable {
        AbstractC1683A.r(EmptyCoroutineContext.f4908a, new RuntimeManager$saveRuntimeState$1(2, null));
    }

    @Override // com.stepos.ability.commoninternal.ability.IComponent
    public final void setup(Context context) {
        k.f(context, "context");
        k.e(context.getApplicationContext(), "getApplicationContext(...)");
        AbilityTaskDao abilityTaskDao = S3.a.c;
        if (abilityTaskDao == null) {
            k.n("abilityTaskDao");
            throw null;
        }
        this.f3228a = abilityTaskDao;
        d dVar = AbstractC1691I.f5315a;
        C1923c c1923cB = AbstractC1683A.b(c.f6743a.plus(AbstractC1683A.c()));
        this.g = c1923cB;
        this.h = Z6.k.b(Integer.MAX_VALUE, 6, null);
        this.i = AbstractC1683A.n(c1923cB, null, new RuntimeManager$setup$1(this, null), 3);
        AbstractC1683A.n(c1923cB, null, new RuntimeManager$setup$2(this, null), 3);
        Log.i("RuntimeManager", "set up end.");
    }

    @Override // com.stepos.ability.api.ability.runtime.IRuntimeManager
    public final void submit(final AbilityTask task) {
        k.f(task, "task");
        kotlinx.coroutines.channels.a aVar = this.h;
        C1923c c1923c = this.g;
        if (aVar == null || c1923c == null) {
            androidx.constraintlayout.core.dsl.a.w("submit() called while RuntimeManager is not set up. task=", task.getTaskCode(), "RuntimeManager");
            return;
        }
        if (this.e.containsKey(task.getTaskCode())) {
            synchronized (this.f) {
                try {
                    PriorityQueue priorityQueue = this.f;
                    if (priorityQueue == null || !priorityQueue.isEmpty()) {
                        Iterator it = priorityQueue.iterator();
                        while (it.hasNext() && !k.b(((CoroutinePriorityTask) it.next()).getBaseTask().getTaskCode(), task.getTaskCode())) {
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            androidx.constraintlayout.core.dsl.a.w("Duplicate task ignored: ", task.getTaskCode(), "RuntimeManager");
            return;
        }
        ICallTool iCallTool = this.b;
        if (iCallTool == null) {
            k.n("callTool");
            throw null;
        }
        IMonitor iMonitor = this.c;
        if (iMonitor == null) {
            k.n("monitor");
            throw null;
        }
        CoroutinePriorityTask coroutinePriorityTask = new CoroutinePriorityTask(iCallTool, iMonitor, task, task.getPriority(), 0, System.currentTimeMillis(), task.getTimeout() * 1000, new S7.a() { // from class: com.stepos.ability.runtime.a
            @Override // S7.a
            public final Object invoke() {
                AbilityTask abilityTask = task;
                Log.i("RuntimeManager", "Task: " + abilityTask.getTaskCode() + " finished.");
                b bVar = this.f3227a;
                bVar.e.remove(abilityTask.getTaskCode());
                C1923c c1923c2 = bVar.g;
                if (c1923c2 != null) {
                    AbstractC1683A.n(c1923c2, null, new RuntimeManager$onTaskFinished$1(bVar, abilityTask, null), 3);
                }
                return r.f317a;
            }
        });
        synchronized (this.f) {
            this.f.add(coroutinePriorityTask);
        }
        AbstractC1683A.n(c1923c, null, new RuntimeManager$submit$3(this, task, null), 3);
        aVar.a(r.f317a);
        Log.i("RuntimeManager", "Task: " + task.getTaskCode() + " submitted.");
    }
}
