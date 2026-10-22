package stepai.aios.guiagent.takeover;

import N9.j;
import com.stepos.statsrpk.service.c;
import com.stepos.taskrobot.llmapi.stepfun.InjectExperienceResult;
import j9.m;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.TimeoutCancellationException;

/* loaded from: classes4.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final Object f6171a;
    public final Object b;

    public a() {
        this.f6171a = new ConcurrentHashMap();
        this.b = new kotlinx.coroutines.sync.a();
    }

    public static TakeoverErrorType a(Throwable th) {
        String message;
        if (th instanceof TimeoutCancellationException) {
            return TakeoverErrorType.f;
        }
        if (th instanceof TakeoverException) {
            return ((TakeoverException) th).f6158a;
        }
        for (Throwable cause = th.getCause(); cause != null; cause = cause.getCause()) {
            if (cause instanceof TakeoverException) {
                return ((TakeoverException) cause).f6158a;
            }
        }
        String message2 = th.getMessage();
        if (message2 != null && m.h0(message2, "Session not found", false)) {
            return TakeoverErrorType.f6156a;
        }
        String message3 = th.getMessage();
        if ((message3 != null && m.h0(message3, "Invalid state", false)) || ((message = th.getMessage()) != null && m.h0(message, "not in takeover state", false))) {
            return TakeoverErrorType.b;
        }
        String message4 = th.getMessage();
        if (message4 != null && m.h0(message4, "Interruption failed", false)) {
            return TakeoverErrorType.c;
        }
        String message5 = th.getMessage();
        if (message5 != null && m.h0(message5, "Context save failed", false)) {
            return TakeoverErrorType.d;
        }
        String message6 = th.getMessage();
        if (message6 != null && m.h0(message6, "Context restore failed", false)) {
            return TakeoverErrorType.e;
        }
        String message7 = th.getMessage();
        if (message7 != null && m.h0(message7, InjectExperienceResult.REASON_TIMEOUT, true)) {
            return TakeoverErrorType.f;
        }
        String message8 = th.getMessage();
        if (message8 != null && m.h0(message8, "Concurrent", false)) {
            return TakeoverErrorType.g;
        }
        String message9 = th.getMessage();
        if (message9 != null && m.h0(message9, "Service unavailable", false)) {
            return TakeoverErrorType.h;
        }
        String message10 = th.getMessage();
        return (message10 == null || !m.h0(message10, "Permission", false)) ? TakeoverErrorType.f6157j : TakeoverErrorType.i;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object b(java.lang.String r7, kotlin.coroutines.jvm.internal.ContinuationImpl r8) {
        /*
            r6 = this;
            java.lang.String r0 = "Cleared stored context for session: "
            boolean r1 = r8 instanceof stepai.aios.guiagent.takeover.TakeoverStateManager$clearContext$1
            if (r1 == 0) goto L15
            r1 = r8
            stepai.aios.guiagent.takeover.TakeoverStateManager$clearContext$1 r1 = (stepai.aios.guiagent.takeover.TakeoverStateManager$clearContext$1) r1
            int r2 = r1.e
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L15
            int r2 = r2 - r3
            r1.e = r2
            goto L1a
        L15:
            stepai.aios.guiagent.takeover.TakeoverStateManager$clearContext$1 r1 = new stepai.aios.guiagent.takeover.TakeoverStateManager$clearContext$1
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
            java.lang.String r1 = r1.f6167a
            kotlin.b.b(r8)
            r8 = r7
            r7 = r1
            goto L4c
        L30:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L38:
            kotlin.b.b(r8)
            java.lang.Object r8 = r6.b
            kotlinx.coroutines.sync.a r8 = (kotlinx.coroutines.sync.a) r8
            r1.f6167a = r7
            r1.b = r8
            r1.e = r4
            java.lang.Object r1 = r8.lock(r5, r1)
            if (r1 != r2) goto L4c
            return r2
        L4c:
            java.lang.Object r6 = r6.f6171a     // Catch: java.lang.Throwable -> L6a
            java.util.concurrent.ConcurrentHashMap r6 = (java.util.concurrent.ConcurrentHashMap) r6     // Catch: java.lang.Throwable -> L6a
            java.lang.Object r6 = r6.remove(r7)     // Catch: java.lang.Throwable -> L6a
            Ea.a r6 = (Ea.a) r6     // Catch: java.lang.Throwable -> L6a
            if (r6 == 0) goto L6c
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L6a
            r6.<init>(r0)     // Catch: java.lang.Throwable -> L6a
            r6.append(r7)     // Catch: java.lang.Throwable -> L6a
            java.lang.String r6 = r6.toString()     // Catch: java.lang.Throwable -> L6a
            java.lang.String r7 = "TakeoverStateManager"
            N9.j.H(r6, r7)     // Catch: java.lang.Throwable -> L6a
            goto L6c
        L6a:
            r6 = move-exception
            goto L72
        L6c:
            r8.unlock(r5)
            C7.r r6 = C7.r.f317a
            return r6
        L72:
            r8.unlock(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiagent.takeover.a.b(java.lang.String, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:63:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0214  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x00c3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:58:0x016b -> B:59:0x016f). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:60:0x017e -> B:79:0x0201). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object c(java.lang.String r24, int r25, long r26, S7.k r28, kotlin.coroutines.jvm.internal.ContinuationImpl r29) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 580
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiagent.takeover.a.c(java.lang.String, int, long, S7.k, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x001d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object d(java.lang.String r12, kotlin.coroutines.jvm.internal.ContinuationImpl r13) {
        /*
            r11 = this;
            java.lang.Object r0 = r11.f6171a
            java.util.concurrent.ConcurrentHashMap r0 = (java.util.concurrent.ConcurrentHashMap) r0
            java.lang.String r1 = "Retrieved stored context for session: "
            java.lang.String r2 = "Stored context expired for session: "
            java.lang.String r3 = "No stored context found for session: "
            boolean r4 = r13 instanceof stepai.aios.guiagent.takeover.TakeoverStateManager$getStoredContext$1
            if (r4 == 0) goto L1d
            r4 = r13
            stepai.aios.guiagent.takeover.TakeoverStateManager$getStoredContext$1 r4 = (stepai.aios.guiagent.takeover.TakeoverStateManager$getStoredContext$1) r4
            int r5 = r4.e
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            r7 = r5 & r6
            if (r7 == 0) goto L1d
            int r5 = r5 - r6
            r4.e = r5
            goto L22
        L1d:
            stepai.aios.guiagent.takeover.TakeoverStateManager$getStoredContext$1 r4 = new stepai.aios.guiagent.takeover.TakeoverStateManager$getStoredContext$1
            r4.<init>(r11, r13)
        L22:
            java.lang.Object r13 = r4.c
            kotlin.coroutines.intrinsics.CoroutineSingletons r5 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r6 = r4.e
            r7 = 1
            r8 = 0
            if (r6 == 0) goto L3e
            if (r6 != r7) goto L36
            kotlinx.coroutines.sync.a r11 = r4.b
            java.lang.String r12 = r4.f6168a
            kotlin.b.b(r13)
            goto L52
        L36:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L3e:
            kotlin.b.b(r13)
            java.lang.Object r11 = r11.b
            kotlinx.coroutines.sync.a r11 = (kotlinx.coroutines.sync.a) r11
            r4.f6168a = r12
            r4.b = r11
            r4.e = r7
            java.lang.Object r13 = r11.lock(r8, r4)
            if (r13 != r5) goto L52
            return r5
        L52:
            java.lang.Object r13 = r0.get(r12)     // Catch: java.lang.Throwable -> L6d
            Ea.a r13 = (Ea.a) r13     // Catch: java.lang.Throwable -> L6d
            java.lang.String r4 = "TakeoverStateManager"
            if (r13 != 0) goto L6f
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L6d
            r13.<init>(r3)     // Catch: java.lang.Throwable -> L6d
            r13.append(r12)     // Catch: java.lang.Throwable -> L6d
            java.lang.String r12 = r13.toString()     // Catch: java.lang.Throwable -> L6d
            N9.j.J(r12, r4)     // Catch: java.lang.Throwable -> L6d
        L6b:
            r13 = r8
            goto La9
        L6d:
            r12 = move-exception
            goto Lad
        L6f:
            long r5 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L6d
            long r9 = r13.g     // Catch: java.lang.Throwable -> L6d
            long r5 = r5 - r9
            r9 = 1800000(0x1b7740, double:8.89318E-318)
            int r3 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r3 <= 0) goto L90
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L6d
            r13.<init>(r2)     // Catch: java.lang.Throwable -> L6d
            r13.append(r12)     // Catch: java.lang.Throwable -> L6d
            java.lang.String r13 = r13.toString()     // Catch: java.lang.Throwable -> L6d
            N9.j.J(r13, r4)     // Catch: java.lang.Throwable -> L6d
            r0.remove(r12)     // Catch: java.lang.Throwable -> L6d
            goto L6b
        L90:
            int r0 = r13.b     // Catch: java.lang.Throwable -> L6d
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L6d
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L6d
            r2.append(r12)     // Catch: java.lang.Throwable -> L6d
            java.lang.String r12 = ", completedSteps: "
            r2.append(r12)     // Catch: java.lang.Throwable -> L6d
            r2.append(r0)     // Catch: java.lang.Throwable -> L6d
            java.lang.String r12 = r2.toString()     // Catch: java.lang.Throwable -> L6d
            N9.j.H(r12, r4)     // Catch: java.lang.Throwable -> L6d
        La9:
            r11.unlock(r8)
            return r13
        Lad:
            r11.unlock(r8)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiagent.takeover.a.d(java.lang.String, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object e(java.lang.String r5, kotlin.coroutines.jvm.internal.ContinuationImpl r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof stepai.aios.guiagent.takeover.TakeoverErrorHandler$handleConcurrentOperationError$1
            if (r0 == 0) goto L13
            r0 = r6
            stepai.aios.guiagent.takeover.TakeoverErrorHandler$handleConcurrentOperationError$1 r0 = (stepai.aios.guiagent.takeover.TakeoverErrorHandler$handleConcurrentOperationError$1) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            stepai.aios.guiagent.takeover.TakeoverErrorHandler$handleConcurrentOperationError$1 r0 = new stepai.aios.guiagent.takeover.TakeoverErrorHandler$handleConcurrentOperationError$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r4 = r0.f6153a
            kotlin.coroutines.intrinsics.CoroutineSingletons r6 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r1 = r0.c
            r2 = 1
            if (r1 == 0) goto L2f
            if (r1 != r2) goto L27
            kotlin.b.b(r4)
            goto L50
        L27:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L2f:
            kotlin.b.b(r4)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r1 = "Concurrent operation detected for session: "
            r4.<init>(r1)
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            java.lang.String r5 = "TakeoverErrorHandler"
            N9.j.J(r4, r5)
            r0.c = r2
            r4 = 1000(0x3e8, double:4.94E-321)
            java.lang.Object r4 = kotlinx.coroutines.a.f(r4, r0)
            if (r4 != r6) goto L50
            return r6
        L50:
            stepai.aios.guiagent.takeover.TakeoverErrorType r4 = stepai.aios.guiagent.takeover.TakeoverErrorType.g
            Ea.b r5 = new Ea.b
            java.lang.String r6 = "检测到并发操作，请稍后重试"
            r5.<init>(r4, r6, r2)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiagent.takeover.a.e(java.lang.String, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object f(java.lang.String r5, kotlin.coroutines.jvm.internal.ContinuationImpl r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof stepai.aios.guiagent.takeover.TakeoverErrorHandler$handleInterruptionFailedError$1
            if (r0 == 0) goto L13
            r0 = r6
            stepai.aios.guiagent.takeover.TakeoverErrorHandler$handleInterruptionFailedError$1 r0 = (stepai.aios.guiagent.takeover.TakeoverErrorHandler$handleInterruptionFailedError$1) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            stepai.aios.guiagent.takeover.TakeoverErrorHandler$handleInterruptionFailedError$1 r0 = new stepai.aios.guiagent.takeover.TakeoverErrorHandler$handleInterruptionFailedError$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r4 = r0.f6154a
            kotlin.coroutines.intrinsics.CoroutineSingletons r6 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r1 = r0.c
            java.lang.String r2 = "TakeoverErrorHandler"
            r3 = 1
            if (r1 == 0) goto L33
            if (r1 != r3) goto L2b
            kotlin.b.b(r4)     // Catch: java.lang.Exception -> L29
            goto L52
        L29:
            r4 = move-exception
            goto L5a
        L2b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L33:
            kotlin.b.b(r4)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r1 = "Action interruption failed for session: "
            r4.<init>(r1)
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            N9.j.G(r4, r2)
            r0.c = r3     // Catch: java.lang.Exception -> L29
            r4 = 500(0x1f4, double:2.47E-321)
            java.lang.Object r4 = kotlinx.coroutines.a.f(r4, r0)     // Catch: java.lang.Exception -> L29
            if (r4 != r6) goto L52
            return r6
        L52:
            java.lang.String r4 = "动作中断失败，但已等待完成"
            Ea.c r5 = new Ea.c     // Catch: java.lang.Exception -> L29
            r5.<init>(r4)     // Catch: java.lang.Exception -> L29
            return r5
        L5a:
            java.lang.String r4 = r4.getMessage()
            java.lang.String r5 = "Failed to recover from interruption failure: "
            com.stepos.statsrpk.service.c.n(r5, r4, r2)
            stepai.aios.guiagent.takeover.TakeoverErrorType r4 = stepai.aios.guiagent.takeover.TakeoverErrorType.c
            Ea.b r5 = new Ea.b
            java.lang.String r6 = "无法中断当前动作，请稍后重试"
            r5.<init>(r4, r6, r3)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiagent.takeover.a.f(java.lang.String, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0080, code lost:
    
        if (r7.a(r8, "Invalid state recovery", r1) == r2) goto L31;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object g(java.lang.String r8, kotlin.coroutines.jvm.internal.ContinuationImpl r9) {
        /*
            r7 = this;
            java.lang.String r0 = "Invalid state transition for session "
            boolean r1 = r9 instanceof stepai.aios.guiagent.takeover.TakeoverErrorHandler$handleInvalidStateError$1
            if (r1 == 0) goto L15
            r1 = r9
            stepai.aios.guiagent.takeover.TakeoverErrorHandler$handleInvalidStateError$1 r1 = (stepai.aios.guiagent.takeover.TakeoverErrorHandler$handleInvalidStateError$1) r1
            int r2 = r1.d
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L15
            int r2 = r2 - r3
            r1.d = r2
            goto L1a
        L15:
            stepai.aios.guiagent.takeover.TakeoverErrorHandler$handleInvalidStateError$1 r1 = new stepai.aios.guiagent.takeover.TakeoverErrorHandler$handleInvalidStateError$1
            r1.<init>(r7, r9)
        L1a:
            java.lang.Object r9 = r1.b
            kotlin.coroutines.intrinsics.CoroutineSingletons r2 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r3 = r1.d
            java.lang.String r4 = "TakeoverErrorHandler"
            r5 = 2
            r6 = 1
            if (r3 == 0) goto L3e
            if (r3 == r6) goto L38
            if (r3 != r5) goto L30
            kotlin.b.b(r9)     // Catch: java.lang.Exception -> L2e
            goto L83
        L2e:
            r7 = move-exception
            goto L8b
        L30:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L38:
            java.lang.String r8 = r1.f6155a
            kotlin.b.b(r9)     // Catch: java.lang.Exception -> L2e
            goto L50
        L3e:
            kotlin.b.b(r9)
            java.lang.Object r9 = r7.f6171a     // Catch: java.lang.Exception -> L2e
            stepai.aios.guiagent.session.a r9 = (stepai.aios.guiagent.session.a) r9     // Catch: java.lang.Exception -> L2e
            r1.f6155a = r8     // Catch: java.lang.Exception -> L2e
            r1.d = r6     // Catch: java.lang.Exception -> L2e
            java.lang.Object r9 = r9.j(r8, r1)     // Catch: java.lang.Exception -> L2e
            if (r9 != r2) goto L50
            goto L82
        L50:
            za.e r9 = (za.e) r9     // Catch: java.lang.Exception -> L2e
            if (r9 == 0) goto L94
            stepai.aios.guiagent.model.SessionState r3 = r9.e     // Catch: java.lang.Exception -> L2e
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L2e
            r6.<init>(r0)     // Catch: java.lang.Exception -> L2e
            r6.append(r8)     // Catch: java.lang.Exception -> L2e
            java.lang.String r0 = ", current state: "
            r6.append(r0)     // Catch: java.lang.Exception -> L2e
            r6.append(r3)     // Catch: java.lang.Exception -> L2e
            java.lang.String r0 = r6.toString()     // Catch: java.lang.Exception -> L2e
            N9.j.G(r0, r4)     // Catch: java.lang.Exception -> L2e
            boolean r9 = r9.f7008s     // Catch: java.lang.Exception -> L2e
            if (r9 == 0) goto L94
            java.lang.Object r7 = r7.b     // Catch: java.lang.Exception -> L2e
            stepai.aios.guiagent.pipeline.a r7 = (stepai.aios.guiagent.pipeline.a) r7     // Catch: java.lang.Exception -> L2e
            java.lang.String r9 = "Invalid state recovery"
            r0 = 0
            r1.f6155a = r0     // Catch: java.lang.Exception -> L2e
            r1.d = r5     // Catch: java.lang.Exception -> L2e
            java.lang.Object r7 = r7.a(r8, r9, r1)     // Catch: java.lang.Exception -> L2e
            if (r7 != r2) goto L83
        L82:
            return r2
        L83:
            java.lang.String r7 = "状态已重置到接管状态"
            Ea.c r8 = new Ea.c     // Catch: java.lang.Exception -> L2e
            r8.<init>(r7)     // Catch: java.lang.Exception -> L2e
            return r8
        L8b:
            java.lang.String r7 = r7.getMessage()
            java.lang.String r8 = "Failed to handle invalid state error: "
            com.stepos.statsrpk.service.c.n(r8, r7, r4)
        L94:
            stepai.aios.guiagent.takeover.TakeoverErrorType r7 = stepai.aios.guiagent.takeover.TakeoverErrorType.b
            Ea.b r8 = new Ea.b
            java.lang.String r9 = "会话状态不正确，无法执行操作"
            r0 = 0
            r8.<init>(r7, r9, r0)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiagent.takeover.a.g(java.lang.String, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    public Object h(String str, Exception exc, String str2, ContinuationImpl continuationImpl) {
        TakeoverErrorType takeoverErrorTypeA = a(exc);
        j.G("Handling takeover error: " + str2 + ", type: " + takeoverErrorTypeA + ", message: " + exc.getMessage(), "TakeoverErrorHandler");
        int iOrdinal = takeoverErrorTypeA.ordinal();
        if (iOrdinal == 0) {
            c.n("Session not found: ", str, "TakeoverErrorHandler");
            return new Ea.b(TakeoverErrorType.f6156a, "会话不存在或已被删除", false);
        }
        if (iOrdinal == 1) {
            return g(str, continuationImpl);
        }
        if (iOrdinal == 2) {
            return f(str, continuationImpl);
        }
        if (iOrdinal == 5) {
            c.o("Operation timeout: ", str2, " for session: ", str, "TakeoverErrorHandler");
            return new Ea.b(TakeoverErrorType.f, "操作超时，请检查系统状态后重试", true);
        }
        if (iOrdinal == 6) {
            return e(str, continuationImpl);
        }
        if (iOrdinal == 7) {
            c.n("Service unavailable for session: ", str, "TakeoverErrorHandler");
            return new Ea.b(TakeoverErrorType.h, "系统服务暂时不可用，请稍后重试", true);
        }
        String message = exc.getMessage();
        StringBuilder sbW = B7.a.w("Generic error in ", str2, " for session ", str, ": ");
        sbW.append(message);
        j.G(sbW.toString(), "TakeoverErrorHandler");
        return new Ea.b(TakeoverErrorType.f6157j, androidx.constraintlayout.core.dsl.a.h("操作失败：", exc.getMessage(), "message"), true);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object i(java.lang.String r9, int r10, java.lang.String r11, java.util.List r12, java.lang.String r13, java.lang.String r14, kotlin.coroutines.jvm.internal.ContinuationImpl r15) {
        /*
            r8 = this;
            java.lang.String r1 = "Execution context saved for session: "
            boolean r2 = r15 instanceof stepai.aios.guiagent.takeover.TakeoverStateManager$saveExecutionContext$1
            if (r2 == 0) goto L15
            r2 = r15
            stepai.aios.guiagent.takeover.TakeoverStateManager$saveExecutionContext$1 r2 = (stepai.aios.guiagent.takeover.TakeoverStateManager$saveExecutionContext$1) r2
            int r3 = r2.f6170j
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L15
            int r3 = r3 - r4
            r2.f6170j = r3
            goto L1a
        L15:
            stepai.aios.guiagent.takeover.TakeoverStateManager$saveExecutionContext$1 r2 = new stepai.aios.guiagent.takeover.TakeoverStateManager$saveExecutionContext$1
            r2.<init>(r8, r15)
        L1a:
            java.lang.Object r0 = r2.h
            kotlin.coroutines.intrinsics.CoroutineSingletons r3 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r4 = r2.f6170j
            r5 = 1
            r6 = 0
            if (r4 == 0) goto L46
            if (r4 != r5) goto L3e
            int r10 = r2.g
            kotlinx.coroutines.sync.a r9 = r2.f
            java.lang.String r11 = r2.e
            java.lang.String r3 = r2.d
            java.util.List r4 = r2.c
            java.util.List r4 = (java.util.List) r4
            java.lang.String r5 = r2.b
            java.lang.String r2 = r2.f6169a
            kotlin.b.b(r0)
            r7 = r11
            r11 = r10
            r10 = r2
            r2 = r9
            goto L6e
        L3e:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L46:
            kotlin.b.b(r0)
            java.lang.Object r0 = r8.b
            kotlinx.coroutines.sync.a r0 = (kotlinx.coroutines.sync.a) r0
            r2.f6169a = r9
            r2.b = r11
            r4 = r12
            java.util.List r4 = (java.util.List) r4
            r2.c = r4
            r2.d = r13
            r2.e = r14
            r2.f = r0
            r2.g = r10
            r2.f6170j = r5
            java.lang.Object r2 = r0.lock(r6, r2)
            if (r2 != r3) goto L67
            return r3
        L67:
            r5 = r11
            r4 = r12
            r3 = r13
            r7 = r14
            r2 = r0
            r11 = r10
            r10 = r9
        L6e:
            Ea.a r9 = new Ea.a     // Catch: java.lang.Throwable -> La3
            java.lang.Iterable r4 = (java.lang.Iterable) r4     // Catch: java.lang.Throwable -> La3
            java.util.List r0 = D7.v.f1(r4)     // Catch: java.lang.Throwable -> La3
            r13 = r0
            r14 = r3
            r12 = r5
            r15 = r7
            r9.<init>(r10, r11, r12, r13, r14, r15)     // Catch: java.lang.Throwable -> La3
            java.lang.Object r8 = r8.f6171a     // Catch: java.lang.Throwable -> La3
            java.util.concurrent.ConcurrentHashMap r8 = (java.util.concurrent.ConcurrentHashMap) r8     // Catch: java.lang.Throwable -> La3
            r8.put(r10, r9)     // Catch: java.lang.Throwable -> La3
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> La3
            r8.<init>(r1)     // Catch: java.lang.Throwable -> La3
            r8.append(r10)     // Catch: java.lang.Throwable -> La3
            java.lang.String r9 = ", completedSteps: "
            r8.append(r9)     // Catch: java.lang.Throwable -> La3
            r8.append(r11)     // Catch: java.lang.Throwable -> La3
            java.lang.String r8 = r8.toString()     // Catch: java.lang.Throwable -> La3
            java.lang.String r9 = "TakeoverStateManager"
            N9.j.H(r8, r9)     // Catch: java.lang.Throwable -> La3
            r2.unlock(r6)
            C7.r r8 = C7.r.f317a
            return r8
        La3:
            r0 = move-exception
            r8 = r0
            r2.unlock(r6)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiagent.takeover.a.i(java.lang.String, int, java.lang.String, java.util.List, java.lang.String, java.lang.String, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    public a(stepai.aios.guiagent.session.a aVar, stepai.aios.guiagent.pipeline.a aVar2) {
        this.f6171a = aVar;
        this.b = aVar2;
    }
}
