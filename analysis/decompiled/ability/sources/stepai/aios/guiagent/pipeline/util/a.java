package stepai.aios.guiagent.pipeline.util;

import java.util.concurrent.ConcurrentHashMap;
import stepai.aios.guiexecutor.core.DefaultGuiExecutor;

/* loaded from: classes4.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final DefaultGuiExecutor f6116a;
    public final kotlinx.coroutines.sync.a b = new kotlinx.coroutines.sync.a();
    public final ConcurrentHashMap c = new ConcurrentHashMap();
    public final ConcurrentHashMap d = new ConcurrentHashMap();

    public a(DefaultGuiExecutor defaultGuiExecutor) {
        this.f6116a = defaultGuiExecutor;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(java.lang.String r7, kotlin.coroutines.jvm.internal.ContinuationImpl r8) {
        /*
            r6 = this;
            java.lang.String r0 = "Cleaned up GUI session: "
            boolean r1 = r8 instanceof stepai.aios.guiagent.pipeline.util.GuiActionInterruptionAdapter$cleanupSession$1
            if (r1 == 0) goto L15
            r1 = r8
            stepai.aios.guiagent.pipeline.util.GuiActionInterruptionAdapter$cleanupSession$1 r1 = (stepai.aios.guiagent.pipeline.util.GuiActionInterruptionAdapter$cleanupSession$1) r1
            int r2 = r1.e
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L15
            int r2 = r2 - r3
            r1.e = r2
            goto L1a
        L15:
            stepai.aios.guiagent.pipeline.util.GuiActionInterruptionAdapter$cleanupSession$1 r1 = new stepai.aios.guiagent.pipeline.util.GuiActionInterruptionAdapter$cleanupSession$1
            r1.<init>(r6, r8)
        L1a:
            java.lang.Object r8 = r1.c
            kotlin.coroutines.intrinsics.CoroutineSingletons r2 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r3 = r1.e
            r4 = 1
            r5 = 0
            if (r3 == 0) goto L38
            if (r3 != r4) goto L30
            kotlinx.coroutines.sync.a r7 = r1.b
            java.lang.String r1 = r1.f6112a
            kotlin.b.b(r8)
            r8 = r7
            r7 = r1
            goto L4a
        L30:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L38:
            kotlin.b.b(r8)
            r1.f6112a = r7
            kotlinx.coroutines.sync.a r8 = r6.b
            r1.b = r8
            r1.e = r4
            java.lang.Object r1 = r8.lock(r5, r1)
            if (r1 != r2) goto L4a
            return r2
        L4a:
            java.util.concurrent.ConcurrentHashMap r1 = r6.c     // Catch: java.lang.Throwable -> L62
            java.lang.Object r1 = r1.remove(r7)     // Catch: java.lang.Throwable -> L62
            Ba.h r1 = (Ba.h) r1     // Catch: java.lang.Throwable -> L62
            if (r1 == 0) goto L6b
            java.util.concurrent.atomic.AtomicBoolean r2 = r1.e     // Catch: java.lang.Throwable -> L62
            r3 = 0
            r2.set(r3)     // Catch: java.lang.Throwable -> L62
            m9.c0 r2 = r1.h     // Catch: java.lang.Throwable -> L62
            if (r2 == 0) goto L64
            r2.cancel(r5)     // Catch: java.lang.Throwable -> L62
            goto L64
        L62:
            r6 = move-exception
            goto L87
        L64:
            stepai.aios.guiexecutor.core.DefaultGuiExecutor r2 = r6.f6116a     // Catch: java.lang.Throwable -> L62
            java.lang.String r1 = r1.c     // Catch: java.lang.Throwable -> L62
            r2.cancelCommand(r1)     // Catch: java.lang.Throwable -> L62
        L6b:
            java.util.concurrent.ConcurrentHashMap r6 = r6.d     // Catch: java.lang.Throwable -> L62
            r6.remove(r7)     // Catch: java.lang.Throwable -> L62
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L62
            r6.<init>(r0)     // Catch: java.lang.Throwable -> L62
            r6.append(r7)     // Catch: java.lang.Throwable -> L62
            java.lang.String r6 = r6.toString()     // Catch: java.lang.Throwable -> L62
            java.lang.String r7 = "GuiActionInterruptionAdapter"
            N9.j.H(r6, r7)     // Catch: java.lang.Throwable -> L62
            r8.unlock(r5)
            C7.r r6 = C7.r.f317a
            return r6
        L87:
            r8.unlock(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiagent.pipeline.util.a.a(java.lang.String, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(java.lang.String r17, kotlin.coroutines.jvm.internal.ContinuationImpl r18) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 340
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiagent.pipeline.util.a.b(java.lang.String, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(java.lang.String r17, stepai.aios.guiagent.config.Action r18, java.lang.String r19, kotlin.coroutines.jvm.internal.ContinuationImpl r20) {
        /*
            r16 = this;
            r0 = r16
            r1 = r20
            java.util.concurrent.ConcurrentHashMap r2 = r0.c
            java.lang.String r3 = "Started tracking GUI action: "
            boolean r4 = r1 instanceof stepai.aios.guiagent.pipeline.util.GuiActionInterruptionAdapter$startTrackingAction$1
            if (r4 == 0) goto L1b
            r4 = r1
            stepai.aios.guiagent.pipeline.util.GuiActionInterruptionAdapter$startTrackingAction$1 r4 = (stepai.aios.guiagent.pipeline.util.GuiActionInterruptionAdapter$startTrackingAction$1) r4
            int r5 = r4.g
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            r7 = r5 & r6
            if (r7 == 0) goto L1b
            int r5 = r5 - r6
            r4.g = r5
            goto L20
        L1b:
            stepai.aios.guiagent.pipeline.util.GuiActionInterruptionAdapter$startTrackingAction$1 r4 = new stepai.aios.guiagent.pipeline.util.GuiActionInterruptionAdapter$startTrackingAction$1
            r4.<init>(r0, r1)
        L20:
            java.lang.Object r1 = r4.e
            kotlin.coroutines.intrinsics.CoroutineSingletons r5 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r6 = r4.g
            r7 = 1
            r8 = 0
            if (r6 == 0) goto L43
            if (r6 != r7) goto L3b
            kotlinx.coroutines.sync.a r0 = r4.d
            java.lang.String r5 = r4.c
            stepai.aios.guiagent.config.Action r6 = r4.b
            java.lang.String r4 = r4.f6114a
            kotlin.b.b(r1)
            r11 = r4
            r12 = r5
        L39:
            r1 = r0
            goto L62
        L3b:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L43:
            kotlin.b.b(r1)
            r1 = r17
            r4.f6114a = r1
            r6 = r18
            r4.b = r6
            r9 = r19
            r4.c = r9
            kotlinx.coroutines.sync.a r0 = r0.b
            r4.d = r0
            r4.g = r7
            java.lang.Object r4 = r0.lock(r8, r4)
            if (r4 != r5) goto L5f
            return r5
        L5f:
            r11 = r1
            r12 = r9
            goto L39
        L62:
            java.lang.Object r0 = r2.get(r11)     // Catch: java.lang.Throwable -> Lb5
            Ba.h r0 = (Ba.h) r0     // Catch: java.lang.Throwable -> Lb5
            if (r0 == 0) goto L70
            java.util.concurrent.atomic.AtomicBoolean r0 = r0.e     // Catch: java.lang.Throwable -> Lb5
            r4 = 0
            r0.set(r4)     // Catch: java.lang.Throwable -> Lb5
        L70:
            Ba.h r9 = new Ba.h     // Catch: java.lang.Throwable -> Lb5
            java.lang.String r10 = r6.getId()     // Catch: java.lang.Throwable -> Lb5
            stepai.aios.guiagent.config.ActionType r0 = r6.getType()     // Catch: java.lang.Throwable -> Lb5
            java.lang.String r13 = r0.name()     // Catch: java.lang.Throwable -> Lb5
            java.util.concurrent.atomic.AtomicBoolean r14 = new java.util.concurrent.atomic.AtomicBoolean     // Catch: java.lang.Throwable -> Lb5
            r14.<init>(r7)     // Catch: java.lang.Throwable -> Lb5
            r15 = 0
            r9.<init>(r10, r11, r12, r13, r14, r15)     // Catch: java.lang.Throwable -> Lb5
            r2.put(r11, r9)     // Catch: java.lang.Throwable -> Lb5
            java.lang.String r0 = r6.getId()     // Catch: java.lang.Throwable -> Lb5
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lb5
            r2.<init>(r3)     // Catch: java.lang.Throwable -> Lb5
            r2.append(r0)     // Catch: java.lang.Throwable -> Lb5
            java.lang.String r0 = " (command: "
            r2.append(r0)     // Catch: java.lang.Throwable -> Lb5
            r2.append(r12)     // Catch: java.lang.Throwable -> Lb5
            java.lang.String r0 = ") for session: "
            r2.append(r0)     // Catch: java.lang.Throwable -> Lb5
            r2.append(r11)     // Catch: java.lang.Throwable -> Lb5
            java.lang.String r0 = r2.toString()     // Catch: java.lang.Throwable -> Lb5
            java.lang.String r2 = "GuiActionInterruptionAdapter"
            N9.j.I(r0, r2)     // Catch: java.lang.Throwable -> Lb5
            r1.unlock(r8)
            C7.r r0 = C7.r.f317a
            return r0
        Lb5:
            r0 = move-exception
            r1.unlock(r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiagent.pipeline.util.a.c(java.lang.String, stepai.aios.guiagent.config.Action, java.lang.String, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d(java.lang.String r9, java.lang.String r10, kotlin.coroutines.jvm.internal.ContinuationImpl r11) {
        /*
            r8 = this;
            java.util.concurrent.ConcurrentHashMap r0 = r8.c
            java.lang.String r1 = "GUI action "
            java.lang.String r2 = "Stopped tracking GUI action: "
            boolean r3 = r11 instanceof stepai.aios.guiagent.pipeline.util.GuiActionInterruptionAdapter$stopTrackingAction$1
            if (r3 == 0) goto L19
            r3 = r11
            stepai.aios.guiagent.pipeline.util.GuiActionInterruptionAdapter$stopTrackingAction$1 r3 = (stepai.aios.guiagent.pipeline.util.GuiActionInterruptionAdapter$stopTrackingAction$1) r3
            int r4 = r3.f
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = r4 & r5
            if (r6 == 0) goto L19
            int r4 = r4 - r5
            r3.f = r4
            goto L1e
        L19:
            stepai.aios.guiagent.pipeline.util.GuiActionInterruptionAdapter$stopTrackingAction$1 r3 = new stepai.aios.guiagent.pipeline.util.GuiActionInterruptionAdapter$stopTrackingAction$1
            r3.<init>(r8, r11)
        L1e:
            java.lang.Object r11 = r3.d
            kotlin.coroutines.intrinsics.CoroutineSingletons r4 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r5 = r3.f
            r6 = 1
            r7 = 0
            if (r5 == 0) goto L3c
            if (r5 != r6) goto L34
            kotlinx.coroutines.sync.a r8 = r3.c
            java.lang.String r10 = r3.b
            java.lang.String r9 = r3.f6115a
            kotlin.b.b(r11)
            goto L50
        L34:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L3c:
            kotlin.b.b(r11)
            r3.f6115a = r9
            r3.b = r10
            kotlinx.coroutines.sync.a r8 = r8.b
            r3.c = r8
            r3.f = r6
            java.lang.Object r11 = r8.lock(r7, r3)
            if (r11 != r4) goto L50
            return r4
        L50:
            java.lang.Object r11 = r0.get(r9)     // Catch: java.lang.Throwable -> L73
            Ba.h r11 = (Ba.h) r11     // Catch: java.lang.Throwable -> L73
            java.lang.String r3 = "GuiActionInterruptionAdapter"
            if (r11 == 0) goto L8d
            java.lang.String r4 = r11.f272a     // Catch: java.lang.Throwable -> L73
            boolean r4 = kotlin.jvm.internal.k.b(r4, r10)     // Catch: java.lang.Throwable -> L73
            if (r4 == 0) goto L8d
            java.util.concurrent.atomic.AtomicBoolean r1 = r11.e     // Catch: java.lang.Throwable -> L73
            r4 = 0
            r1.set(r4)     // Catch: java.lang.Throwable -> L73
            r0.remove(r9)     // Catch: java.lang.Throwable -> L73
            m9.c0 r11 = r11.h     // Catch: java.lang.Throwable -> L73
            if (r11 == 0) goto L75
            r11.cancel(r7)     // Catch: java.lang.Throwable -> L73
            goto L75
        L73:
            r9 = move-exception
            goto Laa
        L75:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L73
            r11.<init>(r2)     // Catch: java.lang.Throwable -> L73
            r11.append(r10)     // Catch: java.lang.Throwable -> L73
            java.lang.String r10 = " for session: "
            r11.append(r10)     // Catch: java.lang.Throwable -> L73
            r11.append(r9)     // Catch: java.lang.Throwable -> L73
            java.lang.String r9 = r11.toString()     // Catch: java.lang.Throwable -> L73
            N9.j.H(r9, r3)     // Catch: java.lang.Throwable -> L73
            goto La4
        L8d:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L73
            r11.<init>(r1)     // Catch: java.lang.Throwable -> L73
            r11.append(r10)     // Catch: java.lang.Throwable -> L73
            java.lang.String r10 = " not found or mismatch for session: "
            r11.append(r10)     // Catch: java.lang.Throwable -> L73
            r11.append(r9)     // Catch: java.lang.Throwable -> L73
            java.lang.String r9 = r11.toString()     // Catch: java.lang.Throwable -> L73
            N9.j.J(r9, r3)     // Catch: java.lang.Throwable -> L73
        La4:
            r8.unlock(r7)
            C7.r r8 = C7.r.f317a
            return r8
        Laa:
            r8.unlock(r7)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiagent.pipeline.util.a.d(java.lang.String, java.lang.String, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }
}
