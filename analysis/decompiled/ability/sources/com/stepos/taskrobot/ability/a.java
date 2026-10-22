package com.stepos.taskrobot.ability;

import android.content.Context;
import com.mdisdk.Task;
import com.mdisdk.TaskManager;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import f6.AbstractC1436a;
import j9.m;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.k;

/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final Context f4022a;
    public volatile boolean b;
    public final ConcurrentHashMap c = new ConcurrentHashMap();
    public final ConcurrentHashMap.KeySetView d = ConcurrentHashMap.newKeySet();
    public volatile String e;

    public a(Context context) {
        this.f4022a = context;
    }

    public static void d(a aVar, String taskName) {
        k.f(taskName, "taskName");
        Z5.a aVar2 = (Z5.a) aVar.c.remove(taskName);
        if (aVar2 == null) {
            B7.a.z("finishTaskByName: task not found in pool, nothing to release (taskName=", taskName, ")", "ability", true);
            return;
        }
        if (k.b(aVar.e, taskName)) {
            aVar.e = null;
        }
        try {
            aVar2.f1594a.finish(true);
            AbstractC1436a.d("ability", "finishTaskByName success: taskName=" + taskName + " ignoreActions=true", true);
        } catch (Throwable th) {
            AbstractC1436a.c("ability", "finishTaskByName failed: taskName=".concat(taskName), th);
        }
    }

    public final void a() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        ConcurrentHashMap concurrentHashMap = this.c;
        for (Map.Entry entry : concurrentHashMap.entrySet()) {
            String str = (String) entry.getKey();
            Z5.a aVar = (Z5.a) entry.getValue();
            if (!this.d.contains(str) && jCurrentTimeMillis - aVar.b > 600000) {
                AbstractC1436a.d("ability", "Cleaning up stale task: " + str, true);
                try {
                    aVar.f1594a.finish(true);
                } catch (Throwable unused) {
                }
                concurrentHashMap.remove(str);
            }
        }
    }

    public final void b() {
        if (this.b) {
            return;
        }
        try {
            TaskManager.initialize$default(this.f4022a, false, 2, null);
            this.b = true;
            AbstractC1436a.d("ability", "TaskManager initialized", true);
        } catch (Throwable th) {
            AbstractC1436a.c("ability", "TaskManager.initialize failed", th);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(com.mdisdk.Task r12, com.mdisdk.action.Action r13, H7.c r14) {
        /*
            r11 = this;
            java.lang.String r0 = "executeSingleAction failed: action="
            java.lang.String r1 = "executeSingleAction success: action="
            boolean r2 = r14 instanceof com.stepos.taskrobot.ability.MdiAbility$executeSingleAction$1
            if (r2 == 0) goto L17
            r2 = r14
            com.stepos.taskrobot.ability.MdiAbility$executeSingleAction$1 r2 = (com.stepos.taskrobot.ability.MdiAbility$executeSingleAction$1) r2
            int r3 = r2.d
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L17
            int r3 = r3 - r4
            r2.d = r3
            goto L1c
        L17:
            com.stepos.taskrobot.ability.MdiAbility$executeSingleAction$1 r2 = new com.stepos.taskrobot.ability.MdiAbility$executeSingleAction$1
            r2.<init>(r11, r14)
        L1c:
            java.lang.Object r11 = r2.b
            kotlin.coroutines.intrinsics.CoroutineSingletons r14 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r3 = r2.d
            r4 = 20103(0x4e87, float:2.817E-41)
            r5 = 1
            java.lang.String r6 = "ability"
            r7 = 0
            java.lang.String r8 = "action failed: "
            if (r3 == 0) goto L3f
            if (r3 != r5) goto L37
            com.mdisdk.action.Action r13 = r2.f3987a
            kotlin.b.b(r11)     // Catch: java.lang.Throwable -> L34
            goto L65
        L34:
            r11 = move-exception
            goto Lc6
        L37:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L3f:
            kotlin.b.b(r11)
            java.lang.Class r11 = r13.getClass()
            java.lang.String r11 = r11.getSimpleName()
            java.lang.String r3 = "executeSingleAction start: action="
            java.lang.String r11 = r3.concat(r11)
            f6.AbstractC1436a.d(r6, r11, r5)
            com.stepos.taskrobot.ability.MdiAbility$executeSingleAction$result$1 r11 = new com.stepos.taskrobot.ability.MdiAbility$executeSingleAction$result$1     // Catch: java.lang.Throwable -> L34
            r11.<init>(r12, r13, r7)     // Catch: java.lang.Throwable -> L34
            r2.f3987a = r13     // Catch: java.lang.Throwable -> L34
            r2.d = r5     // Catch: java.lang.Throwable -> L34
            r9 = 30000(0x7530, double:1.4822E-319)
            java.lang.Object r11 = kotlinx.coroutines.a.o(r9, r11, r2)     // Catch: java.lang.Throwable -> L34
            if (r11 != r14) goto L65
            return r14
        L65:
            com.mdisdk.action.ActionResult r11 = (com.mdisdk.action.ActionResult) r11     // Catch: java.lang.Throwable -> L34
            boolean r12 = r11 instanceof com.mdisdk.action.ActionResult.Success     // Catch: java.lang.Throwable -> L34
            if (r12 == 0) goto L7f
            java.lang.Class r11 = r13.getClass()     // Catch: java.lang.Throwable -> L34
            java.lang.String r11 = r11.getSimpleName()     // Catch: java.lang.Throwable -> L34
            java.lang.String r11 = r1.concat(r11)     // Catch: java.lang.Throwable -> L34
            f6.AbstractC1436a.d(r6, r11, r5)     // Catch: java.lang.Throwable -> L34
            io.modelcontextprotocol.spec.McpSchema$CallToolResult r11 = a6.AbstractC0304a.b(r7)     // Catch: java.lang.Throwable -> L34
            return r11
        L7f:
            boolean r12 = r11 instanceof com.mdisdk.action.ActionResult.Failure     // Catch: java.lang.Throwable -> L34
            if (r12 == 0) goto Lc0
            java.lang.Class r12 = r13.getClass()     // Catch: java.lang.Throwable -> L34
            java.lang.String r12 = r12.getSimpleName()     // Catch: java.lang.Throwable -> L34
            r14 = r11
            com.mdisdk.action.ActionResult$Failure r14 = (com.mdisdk.action.ActionResult.Failure) r14     // Catch: java.lang.Throwable -> L34
            java.lang.String r14 = r14.getReason()     // Catch: java.lang.Throwable -> L34
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L34
            r1.<init>(r0)     // Catch: java.lang.Throwable -> L34
            r1.append(r12)     // Catch: java.lang.Throwable -> L34
            java.lang.String r12 = ", reason="
            r1.append(r12)     // Catch: java.lang.Throwable -> L34
            r1.append(r14)     // Catch: java.lang.Throwable -> L34
            java.lang.String r12 = r1.toString()     // Catch: java.lang.Throwable -> L34
            f6.AbstractC1436a.b(r6, r12, r5)     // Catch: java.lang.Throwable -> L34
            com.mdisdk.action.ActionResult$Failure r11 = (com.mdisdk.action.ActionResult.Failure) r11     // Catch: java.lang.Throwable -> L34
            java.lang.String r11 = r11.getReason()     // Catch: java.lang.Throwable -> L34
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L34
            r12.<init>(r8)     // Catch: java.lang.Throwable -> L34
            r12.append(r11)     // Catch: java.lang.Throwable -> L34
            java.lang.String r11 = r12.toString()     // Catch: java.lang.Throwable -> L34
            io.modelcontextprotocol.spec.McpSchema$CallToolResult r11 = a6.AbstractC0304a.a(r4, r11)     // Catch: java.lang.Throwable -> L34
            return r11
        Lc0:
            kotlin.NoWhenBranchMatchedException r11 = new kotlin.NoWhenBranchMatchedException     // Catch: java.lang.Throwable -> L34
            r11.<init>()     // Catch: java.lang.Throwable -> L34
            throw r11     // Catch: java.lang.Throwable -> L34
        Lc6:
            java.lang.Class r12 = r13.getClass()
            java.lang.String r12 = r12.getSimpleName()
            java.lang.String r13 = "MDI action failed: action="
            java.lang.String r12 = r13.concat(r12)
            f6.AbstractC1436a.c(r6, r12, r11)
            java.lang.String r11 = r11.getMessage()
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>(r8)
            r12.append(r11)
            java.lang.String r11 = r12.toString()
            io.modelcontextprotocol.spec.McpSchema$CallToolResult r11 = a6.AbstractC0304a.a(r4, r11)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.taskrobot.ability.a.c(com.mdisdk.Task, com.mdisdk.action.Action, H7.c):java.lang.Object");
    }

    public final Task e(String name, boolean z10) {
        k.f(name, "name");
        b();
        if (this.b) {
            Z5.a aVar = (Z5.a) this.c.get(name);
            if (aVar != null) {
                if (z10) {
                    aVar.b = System.currentTimeMillis();
                    if (!aVar.f1594a.getIsFinishing()) {
                        return aVar.f1594a;
                    }
                }
                try {
                    aVar.f1594a.finish(true);
                } catch (Throwable unused) {
                }
                this.c.remove(name);
            }
            Task taskCreate = TaskManager.create(name, null, z10);
            if (taskCreate != null) {
                this.c.put(name, new Z5.a(taskCreate));
                return taskCreate;
            }
        }
        return null;
    }

    public final Task f(String str) {
        ConcurrentHashMap concurrentHashMap = this.c;
        Z5.a aVar = (Z5.a) concurrentHashMap.get(str);
        if (aVar == null) {
            return null;
        }
        Task task = aVar.f1594a;
        if (task.getIsFinishing()) {
            concurrentHashMap.remove(str);
            return null;
        }
        aVar.b = System.currentTimeMillis();
        return task;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00c7 A[Catch: all -> 0x00d4, TryCatch #0 {all -> 0x00d4, blocks: (B:30:0x00c1, B:32:0x00c7, B:34:0x00d1, B:39:0x00da, B:43:0x00e3, B:45:0x00f4, B:46:0x0123, B:47:0x0138, B:49:0x013c, B:50:0x0155, B:51:0x015a), top: B:59:0x00c1 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0138 A[Catch: all -> 0x00d4, TryCatch #0 {all -> 0x00d4, blocks: (B:30:0x00c1, B:32:0x00c7, B:34:0x00d1, B:39:0x00da, B:43:0x00e3, B:45:0x00f4, B:46:0x0123, B:47:0x0138, B:49:0x013c, B:50:0x0155, B:51:0x015a), top: B:59:0x00c1 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object g(java.util.Map r16, kotlin.coroutines.jvm.internal.ContinuationImpl r17) {
        /*
            Method dump skipped, instructions count: 385
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.taskrobot.ability.a.g(java.util.Map, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x00be, code lost:
    
        if (r2 == r4) goto L43;
     */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0117 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object h(java.util.Map r18, kotlin.coroutines.jvm.internal.ContinuationImpl r19) {
        /*
            Method dump skipped, instructions count: 314
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.taskrobot.ability.a.h(java.util.Map, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object i(java.util.Map r25, kotlin.coroutines.jvm.internal.ContinuationImpl r26) {
        /*
            Method dump skipped, instructions count: 570
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.taskrobot.ability.a.i(java.util.Map, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00f8 A[Catch: all -> 0x010c, TryCatch #1 {all -> 0x010c, blocks: (B:37:0x00f1, B:40:0x00f8, B:42:0x00fc, B:48:0x010e, B:49:0x0113, B:34:0x00db), top: B:65:0x00db }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x014c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object j(java.lang.String r11, java.lang.String r12, boolean r13, kotlin.coroutines.jvm.internal.ContinuationImpl r14) {
        /*
            Method dump skipped, instructions count: 406
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.taskrobot.ability.a.j(java.lang.String, java.lang.String, boolean, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.io.Serializable k(com.mdisdk.Task r15, java.lang.String r16, java.lang.String r17, kotlin.coroutines.jvm.internal.ContinuationImpl r18) {
        /*
            r14 = this;
            r1 = r18
            boolean r2 = r1 instanceof com.stepos.taskrobot.ability.MdiAbility$resolveElementCoords$1
            if (r2 == 0) goto L15
            r2 = r1
            com.stepos.taskrobot.ability.MdiAbility$resolveElementCoords$1 r2 = (com.stepos.taskrobot.ability.MdiAbility$resolveElementCoords$1) r2
            int r3 = r2.e
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L15
            int r3 = r3 - r4
            r2.e = r3
            goto L1a
        L15:
            com.stepos.taskrobot.ability.MdiAbility$resolveElementCoords$1 r2 = new com.stepos.taskrobot.ability.MdiAbility$resolveElementCoords$1
            r2.<init>(r14, r1)
        L1a:
            java.lang.Object r14 = r2.c
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r3 = r2.e
            r4 = 1
            r5 = 0
            if (r3 == 0) goto L3b
            if (r3 != r4) goto L33
            java.lang.String r0 = r2.b
            java.lang.String r1 = r2.f3996a
            kotlin.b.b(r14)     // Catch: java.lang.Throwable -> L30
            r3 = r0
            r0 = r1
            goto L6c
        L30:
            r0 = move-exception
            r14 = r0
            goto L89
        L33:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r0)
            throw r14
        L3b:
            kotlin.b.b(r14)
            java.lang.String r7 = r15.getTopApp(r5)     // Catch: java.lang.Throwable -> L30
            com.mdisdk.action.UiSnapshotAction r6 = new com.mdisdk.action.UiSnapshotAction     // Catch: java.lang.Throwable -> L30
            java.lang.Long r11 = new java.lang.Long     // Catch: java.lang.Throwable -> L30
            r8 = 5000(0x1388, double:2.4703E-320)
            r11.<init>(r8)     // Catch: java.lang.Throwable -> L30
            java.lang.String r13 = ""
            r8 = 0
            r9 = 0
            r10 = 0
            r12 = 0
            r6.<init>(r7, r8, r9, r10, r11, r12, r13)     // Catch: java.lang.Throwable -> L30
            com.stepos.taskrobot.ability.MdiAbility$resolveElementCoords$result$1 r14 = new com.stepos.taskrobot.ability.MdiAbility$resolveElementCoords$result$1     // Catch: java.lang.Throwable -> L30
            r14.<init>(r15, r6, r5)     // Catch: java.lang.Throwable -> L30
            r0 = r16
            r2.f3996a = r0     // Catch: java.lang.Throwable -> L30
            r3 = r17
            r2.b = r3     // Catch: java.lang.Throwable -> L30
            r2.e = r4     // Catch: java.lang.Throwable -> L30
            r6 = 30000(0x7530, double:1.4822E-319)
            java.lang.Object r14 = kotlinx.coroutines.a.o(r6, r14, r2)     // Catch: java.lang.Throwable -> L30
            if (r14 != r1) goto L6c
            return r1
        L6c:
            com.mdisdk.action.ActionResult r14 = (com.mdisdk.action.ActionResult) r14     // Catch: java.lang.Throwable -> L30
            boolean r1 = r14 instanceof com.mdisdk.action.ActionResult.Success     // Catch: java.lang.Throwable -> L30
            if (r1 == 0) goto L88
            com.mdisdk.action.ActionResult$Success r14 = (com.mdisdk.action.ActionResult.Success) r14     // Catch: java.lang.Throwable -> L30
            java.lang.Object r14 = r14.getData()     // Catch: java.lang.Throwable -> L30
            boolean r1 = r14 instanceof com.mdisdk.capability.request.UiSnapshot     // Catch: java.lang.Throwable -> L30
            if (r1 == 0) goto L7f
            com.mdisdk.capability.request.UiSnapshot r14 = (com.mdisdk.capability.request.UiSnapshot) r14     // Catch: java.lang.Throwable -> L30
            goto L80
        L7f:
            r14 = r5
        L80:
            if (r14 != 0) goto L83
            goto L88
        L83:
            kotlin.Pair r14 = S0.b.W0(r14, r0, r3)     // Catch: java.lang.Throwable -> L30
            return r14
        L88:
            return r5
        L89:
            java.lang.String r0 = "ability"
            java.lang.String r1 = "resolveElementCoords failed"
            f6.AbstractC1436a.c(r0, r1, r14)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.taskrobot.ability.a.k(com.mdisdk.Task, java.lang.String, java.lang.String, kotlin.coroutines.jvm.internal.ContinuationImpl):java.io.Serializable");
    }

    public final String l(Map args) {
        k.f(args, "args");
        Object obj = args.get(GuiTaskProgressKt.GuiTaskProgress_KEY_TASK_NAME);
        String str = null;
        String str2 = obj instanceof String ? (String) obj : null;
        if (str2 != null && !m.s0(str2)) {
            str = str2;
        }
        if (str != null) {
            return str;
        }
        String str3 = this.e;
        if (str3 == null) {
            str3 = "default";
        }
        if (this.e != null) {
            AbstractC1436a.a("ability", "taskName: no explicit taskName in args, using lastActiveTask=".concat(str3), true);
        }
        return str3;
    }

    public final void m(String taskName) {
        k.f(taskName, "taskName");
        ConcurrentHashMap.KeySetView keySetView = this.d;
        keySetView.remove(taskName);
        AbstractC1436a.a("ability", androidx.constraintlayout.core.dsl.a.d(keySetView.size(), "unprotectTask: ", taskName, " (protected=", ")"), true);
    }
}
