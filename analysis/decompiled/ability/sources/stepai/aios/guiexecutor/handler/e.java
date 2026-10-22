package stepai.aios.guiexecutor.handler;

import S7.k;
import android.graphics.Point;
import stepai.aios.guiexecutor.api.GestureType;
import stepai.aios.guiexecutor.api.GuiActionExecutor;
import stepai.aios.guiexecutor.api.GuiCommand;
import stepai.aios.guiexecutor.api.GuiCommandHandler;
import stepai.aios.guiexecutor.api.GuiCommandType;
import stepai.aios.guiexecutor.api.GuiParameters;
import stepai.aios.guiexecutor.api.ValidationResult;

/* loaded from: classes4.dex */
public final class e implements GuiCommandHandler {

    /* renamed from: a, reason: collision with root package name */
    public final GuiActionExecutor f6194a;
    public final k b;
    public final k c;
    public final GuiCommandType d = GuiCommandType.SWIPE;

    public e(GuiActionExecutor guiActionExecutor, k kVar, k kVar2) {
        this.f6194a = guiActionExecutor;
        this.b = kVar;
        this.c = kVar2;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x001e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(stepai.aios.guiexecutor.api.GuiCommand r17, stepai.aios.guiexecutor.api.GuiParameters.GestureParams r18, kotlin.coroutines.jvm.internal.ContinuationImpl r19) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r2 = r19
            java.lang.String r3 = "Swipe execution "
            java.lang.String r4 = "Executing swipe: ("
            boolean r5 = r2 instanceof stepai.aios.guiexecutor.handler.SwipeCommandHandler$performSwipe$1
            if (r5 == 0) goto L1e
            r5 = r2
            stepai.aios.guiexecutor.handler.SwipeCommandHandler$performSwipe$1 r5 = (stepai.aios.guiexecutor.handler.SwipeCommandHandler$performSwipe$1) r5
            int r6 = r5.d
            r7 = -2147483648(0xffffffff80000000, float:-0.0)
            r8 = r6 & r7
            if (r8 == 0) goto L1e
            int r6 = r6 - r7
            r5.d = r6
        L1c:
            r13 = r5
            goto L24
        L1e:
            stepai.aios.guiexecutor.handler.SwipeCommandHandler$performSwipe$1 r5 = new stepai.aios.guiexecutor.handler.SwipeCommandHandler$performSwipe$1
            r5.<init>(r0, r2)
            goto L1c
        L24:
            java.lang.Object r2 = r13.b
            kotlin.coroutines.intrinsics.CoroutineSingletons r5 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r6 = r13.d
            r14 = 0
            r7 = 1
            java.lang.String r15 = "SwipeCommandHandler"
            if (r6 == 0) goto L43
            if (r6 != r7) goto L3b
            stepai.aios.guiexecutor.api.GuiCommand r1 = r13.f6187a
            kotlin.b.b(r2)     // Catch: java.lang.Exception -> L38
            goto La5
        L38:
            r0 = move-exception
            goto Lc6
        L3b:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L43:
            kotlin.b.b(r2)
            stepai.aios.guiexecutor.api.GuiOptions r2 = r1.getOptions()     // Catch: java.lang.Exception -> L38
            java.lang.Integer r2 = r2.getDisplayId()     // Catch: java.lang.Exception -> L38
            if (r2 == 0) goto L56
            int r2 = r2.intValue()     // Catch: java.lang.Exception -> L38
            r11 = r2
            goto L57
        L56:
            r11 = r14
        L57:
            android.graphics.Point r2 = r18.getStartPoint()     // Catch: java.lang.Exception -> L38
            android.graphics.Point r6 = r18.getEndPoint()     // Catch: java.lang.Exception -> L38
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L38
            r8.<init>(r4)     // Catch: java.lang.Exception -> L38
            r8.append(r2)     // Catch: java.lang.Exception -> L38
            java.lang.String r4 = ") -> ("
            r8.append(r4)     // Catch: java.lang.Exception -> L38
            r8.append(r6)     // Catch: java.lang.Exception -> L38
            java.lang.String r4 = ")"
            r8.append(r4)     // Catch: java.lang.Exception -> L38
            java.lang.String r4 = r8.toString()     // Catch: java.lang.Exception -> L38
            N9.j.F(r4, r15)     // Catch: java.lang.Exception -> L38
            S7.k r4 = r0.b     // Catch: java.lang.Exception -> L38
            java.lang.String r8 = "[SwipeCommandHandler] before swipe"
            java.lang.String r8 = H4.o.V(r1, r8)     // Catch: java.lang.Exception -> L38
            r4.invoke(r8)     // Catch: java.lang.Exception -> L38
            r4 = r6
            stepai.aios.guiexecutor.api.GuiActionExecutor r6 = r0.f6194a     // Catch: java.lang.Exception -> L38
            kotlin.Pair r2 = H4.o.a0(r2)     // Catch: java.lang.Exception -> L38
            kotlin.Pair r8 = H4.o.a0(r4)     // Catch: java.lang.Exception -> L38
            long r9 = r18.getDuration()     // Catch: java.lang.Exception -> L38
            stepai.aios.guiagent.config.Action r12 = r1.getAction()     // Catch: java.lang.Exception -> L38
            r13.f6187a = r1     // Catch: java.lang.Exception -> L38
            r13.d = r7     // Catch: java.lang.Exception -> L38
            r7 = r2
            java.lang.Object r2 = r6.swipe(r7, r8, r9, r11, r12, r13)     // Catch: java.lang.Exception -> L38
            if (r2 != r5) goto La5
            return r5
        La5:
            java.lang.Boolean r2 = (java.lang.Boolean) r2     // Catch: java.lang.Exception -> L38
            boolean r2 = r2.booleanValue()     // Catch: java.lang.Exception -> L38
            S7.k r0 = r0.c     // Catch: java.lang.Exception -> L38
            java.lang.String r4 = "[SwipeCommandHandler] after swipe"
            java.lang.String r1 = H4.o.V(r1, r4)     // Catch: java.lang.Exception -> L38
            r0.invoke(r1)     // Catch: java.lang.Exception -> L38
            if (r2 == 0) goto Lbb
            java.lang.String r0 = "success"
            goto Lbd
        Lbb:
            java.lang.String r0 = "failed"
        Lbd:
            java.lang.String r0 = r3.concat(r0)     // Catch: java.lang.Exception -> L38
            N9.j.F(r0, r15)     // Catch: java.lang.Exception -> L38
            r14 = r2
            goto Lcf
        Lc6:
            java.lang.String r0 = r0.getMessage()
            java.lang.String r1 = "Swipe execution exception: "
            com.stepos.statsrpk.service.c.n(r1, r0, r15)
        Lcf:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r14)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiexecutor.handler.e.a(stepai.aios.guiexecutor.api.GuiCommand, stepai.aios.guiexecutor.api.GuiParameters$GestureParams, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    @Override // stepai.aios.guiexecutor.api.GuiCommandHandler
    public final GuiCommandType getSupportedType() {
        return this.d;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00d1 A[Catch: Exception -> 0x003c, TryCatch #0 {Exception -> 0x003c, blocks: (B:12:0x0037, B:29:0x00c3, B:31:0x00d1, B:33:0x010b), top: B:37:0x0037 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x010b A[Catch: Exception -> 0x003c, TRY_LEAVE, TryCatch #0 {Exception -> 0x003c, blocks: (B:12:0x0037, B:29:0x00c3, B:31:0x00d1, B:33:0x010b), top: B:37:0x0037 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001f  */
    @Override // stepai.aios.guiexecutor.api.GuiCommandHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object handle(stepai.aios.guiexecutor.api.GuiCommand r23, H7.c r24) {
        /*
            Method dump skipped, instructions count: 352
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiexecutor.handler.e.handle(stepai.aios.guiexecutor.api.GuiCommand, H7.c):java.lang.Object");
    }

    @Override // stepai.aios.guiexecutor.api.GuiCommandHandler
    public final ValidationResult validate(GuiCommand command) {
        kotlin.jvm.internal.k.f(command, "command");
        if (!(command.getParameters() instanceof GuiParameters.GestureParams)) {
            return ValidationResult.INSTANCE.failure("Invalid gesture parameters type");
        }
        GuiParameters.GestureParams gestureParams = (GuiParameters.GestureParams) command.getParameters();
        if (gestureParams.getGestureType() != GestureType.SWIPE) {
            return ValidationResult.INSTANCE.failure("SwipeCommandHandler only supports SWIPE gesture");
        }
        Point startPoint = gestureParams.getStartPoint();
        Point endPoint = gestureParams.getEndPoint();
        if (startPoint.x < 0 || startPoint.y < 0) {
            return ValidationResult.INSTANCE.failure("Invalid start point: " + startPoint);
        }
        if (endPoint.x < 0 || endPoint.y < 0) {
            return ValidationResult.INSTANCE.failure("Invalid end point: " + endPoint);
        }
        if (gestureParams.getDuration() <= 0) {
            return ValidationResult.INSTANCE.failure("Invalid duration: " + gestureParams.getDuration());
        }
        if (gestureParams.getSteps() > 0) {
            return ValidationResult.INSTANCE.success();
        }
        return ValidationResult.INSTANCE.failure("Invalid steps: " + gestureParams.getSteps());
    }
}
