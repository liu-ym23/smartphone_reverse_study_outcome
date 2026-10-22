package stepai.aios.guiexecutor.handler;

import N9.j;
import S7.k;
import android.graphics.Point;
import android.graphics.Rect;
import j9.m;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import stepai.aios.guiexecutor.api.GuiActionExecutor;
import stepai.aios.guiexecutor.api.GuiCommand;
import stepai.aios.guiexecutor.api.GuiCommandHandler;
import stepai.aios.guiexecutor.api.GuiCommandType;
import stepai.aios.guiexecutor.api.GuiParameters;
import stepai.aios.guiexecutor.api.GuiTarget;
import stepai.aios.guiexecutor.api.ValidationResult;

/* loaded from: classes4.dex */
public final class c implements GuiCommandHandler {

    /* renamed from: a, reason: collision with root package name */
    public final GuiActionExecutor f6192a;
    public final k b;
    public final k c;
    public final long d;
    public final GuiCommandType e;

    public c(GuiActionExecutor guiActionExecutor, k kVar, k kVar2, long j5) {
        kotlin.jvm.internal.k.f(guiActionExecutor, "guiActionExecutor");
        this.f6192a = guiActionExecutor;
        this.b = kVar;
        this.c = kVar2;
        this.d = j5;
        this.e = GuiCommandType.CLICK;
    }

    public static Point d(GuiTarget guiTarget) {
        int i = Ha.b.b[guiTarget.getType().ordinal()];
        if (i == 1) {
            return guiTarget.getCoordinate();
        }
        if (i == 2) {
            kotlin.jvm.internal.k.c(guiTarget.getSelector());
            j.J("Element target resolution not implemented yet", "ClickCommandHandler");
            return null;
        }
        if (i != 3) {
            return null;
        }
        Rect bounds = guiTarget.getBounds();
        kotlin.jvm.internal.k.c(bounds);
        Point point = new Point(bounds.centerX(), bounds.centerY());
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        return point;
    }

    public static String e(GuiCommand guiCommand, String str) {
        Object obj = guiCommand.getMetadata().get("sessionId");
        String str2 = obj instanceof String ? (String) obj : null;
        return (str2 == null || m.s0(str2)) ? str : B7.a.n("sessionId=", str2, ";", str);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x008f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(android.graphics.Point r7, int r8, stepai.aios.guiagent.config.Action r9, kotlin.coroutines.jvm.internal.ContinuationImpl r10) {
        /*
            r6 = this;
            boolean r0 = r10 instanceof stepai.aios.guiexecutor.handler.ClickCommandHandler$performDoubleTap$1
            if (r0 == 0) goto L13
            r0 = r10
            stepai.aios.guiexecutor.handler.ClickCommandHandler$performDoubleTap$1 r0 = (stepai.aios.guiexecutor.handler.ClickCommandHandler$performDoubleTap$1) r0
            int r1 = r0.g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.g = r1
            goto L18
        L13:
            stepai.aios.guiexecutor.handler.ClickCommandHandler$performDoubleTap$1 r0 = new stepai.aios.guiexecutor.handler.ClickCommandHandler$performDoubleTap$1
            r0.<init>(r6, r10)
        L18:
            java.lang.Object r10 = r0.e
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.g
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L4b
            if (r2 == r5) goto L41
            if (r2 == r4) goto L35
            if (r2 != r3) goto L2d
            kotlin.b.b(r10)
            return r10
        L2d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L35:
            boolean r7 = r0.d
            int r8 = r0.c
            stepai.aios.guiagent.config.Action r9 = r0.b
            android.graphics.Point r2 = r0.f6182a
            kotlin.b.b(r10)
            goto L7d
        L41:
            int r8 = r0.c
            stepai.aios.guiagent.config.Action r9 = r0.b
            android.graphics.Point r7 = r0.f6182a
            kotlin.b.b(r10)
            goto L5d
        L4b:
            kotlin.b.b(r10)
            r0.f6182a = r7
            r0.b = r9
            r0.c = r8
            r0.g = r5
            java.lang.Object r10 = r6.c(r7, r8, r9, r0)
            if (r10 != r1) goto L5d
            goto L8e
        L5d:
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 != 0) goto L68
            java.lang.Boolean r6 = java.lang.Boolean.FALSE
            return r6
        L68:
            r0.f6182a = r7
            r0.b = r9
            r0.c = r8
            r0.d = r10
            r0.g = r4
            r4 = 300(0x12c, double:1.48E-321)
            java.lang.Object r2 = kotlinx.coroutines.a.f(r4, r0)
            if (r2 != r1) goto L7b
            goto L8e
        L7b:
            r2 = r7
            r7 = r10
        L7d:
            r10 = 0
            r0.f6182a = r10
            r0.b = r10
            r0.c = r8
            r0.d = r7
            r0.g = r3
            java.lang.Object r6 = r6.c(r2, r8, r9, r0)
            if (r6 != r1) goto L8f
        L8e:
            return r1
        L8f:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiexecutor.handler.c.a(android.graphics.Point, int, stepai.aios.guiagent.config.Action, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0069, code lost:
    
        if (kotlinx.coroutines.a.f(500, r7) == r0) goto L23;
     */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(android.graphics.Point r10, int r11, stepai.aios.guiagent.config.Action r12, kotlin.coroutines.jvm.internal.ContinuationImpl r13) {
        /*
            r9 = this;
            boolean r0 = r13 instanceof stepai.aios.guiexecutor.handler.ClickCommandHandler$performLongPress$1
            if (r0 == 0) goto L14
            r0 = r13
            stepai.aios.guiexecutor.handler.ClickCommandHandler$performLongPress$1 r0 = (stepai.aios.guiexecutor.handler.ClickCommandHandler$performLongPress$1) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.e = r1
        L12:
            r7 = r0
            goto L1a
        L14:
            stepai.aios.guiexecutor.handler.ClickCommandHandler$performLongPress$1 r0 = new stepai.aios.guiexecutor.handler.ClickCommandHandler$performLongPress$1
            r0.<init>(r9, r13)
            goto L12
        L1a:
            java.lang.Object r13 = r7.c
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r1 = r7.e
            r8 = 2
            r2 = 1
            if (r1 == 0) goto L3c
            if (r1 == r2) goto L36
            if (r1 != r8) goto L2e
            boolean r9 = r7.b
            kotlin.b.b(r13)
            goto L6c
        L2e:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L36:
            int r11 = r7.f6183a
            kotlin.b.b(r13)
            goto L57
        L3c:
            kotlin.b.b(r13)
            int r13 = r10.x
            float r13 = (float) r13
            int r10 = r10.y
            float r3 = (float) r10
            r7.f6183a = r11
            r7.e = r2
            stepai.aios.guiexecutor.api.GuiActionExecutor r1 = r9.f6192a
            r4 = 1
            r5 = r11
            r6 = r12
            r2 = r13
            java.lang.Object r13 = r1.click(r2, r3, r4, r5, r6, r7)
            if (r13 != r0) goto L56
            goto L6b
        L56:
            r11 = r5
        L57:
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r9 = r13.booleanValue()
            r7.f6183a = r11
            r7.b = r9
            r7.e = r8
            r10 = 500(0x1f4, double:2.47E-321)
            java.lang.Object r10 = kotlinx.coroutines.a.f(r10, r7)
            if (r10 != r0) goto L6c
        L6b:
            return r0
        L6c:
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r9)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiexecutor.handler.c.b(android.graphics.Point, int, stepai.aios.guiagent.config.Action, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0069, code lost:
    
        if (kotlinx.coroutines.a.f(100, r7) == r0) goto L23;
     */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(android.graphics.Point r10, int r11, stepai.aios.guiagent.config.Action r12, kotlin.coroutines.jvm.internal.ContinuationImpl r13) {
        /*
            r9 = this;
            boolean r0 = r13 instanceof stepai.aios.guiexecutor.handler.ClickCommandHandler$performTap$1
            if (r0 == 0) goto L14
            r0 = r13
            stepai.aios.guiexecutor.handler.ClickCommandHandler$performTap$1 r0 = (stepai.aios.guiexecutor.handler.ClickCommandHandler$performTap$1) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.e = r1
        L12:
            r7 = r0
            goto L1a
        L14:
            stepai.aios.guiexecutor.handler.ClickCommandHandler$performTap$1 r0 = new stepai.aios.guiexecutor.handler.ClickCommandHandler$performTap$1
            r0.<init>(r9, r13)
            goto L12
        L1a:
            java.lang.Object r13 = r7.c
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r1 = r7.e
            r8 = 2
            r2 = 1
            if (r1 == 0) goto L3c
            if (r1 == r2) goto L36
            if (r1 != r8) goto L2e
            boolean r9 = r7.b
            kotlin.b.b(r13)
            goto L6c
        L2e:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L36:
            int r11 = r7.f6184a
            kotlin.b.b(r13)
            goto L57
        L3c:
            kotlin.b.b(r13)
            int r13 = r10.x
            float r13 = (float) r13
            int r10 = r10.y
            float r3 = (float) r10
            r7.f6184a = r11
            r7.e = r2
            stepai.aios.guiexecutor.api.GuiActionExecutor r1 = r9.f6192a
            r4 = 0
            r5 = r11
            r6 = r12
            r2 = r13
            java.lang.Object r13 = r1.click(r2, r3, r4, r5, r6, r7)
            if (r13 != r0) goto L56
            goto L6b
        L56:
            r11 = r5
        L57:
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r9 = r13.booleanValue()
            r7.f6184a = r11
            r7.b = r9
            r7.e = r8
            r10 = 100
            java.lang.Object r10 = kotlinx.coroutines.a.f(r10, r7)
            if (r10 != r0) goto L6c
        L6b:
            return r0
        L6c:
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r9)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiexecutor.handler.c.c(android.graphics.Point, int, stepai.aios.guiagent.config.Action, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    @Override // stepai.aios.guiexecutor.api.GuiCommandHandler
    public final GuiCommandType getSupportedType() {
        return this.e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001d  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01ae A[Catch: Exception -> 0x0181, TRY_ENTER, TRY_LEAVE, TryCatch #6 {Exception -> 0x0181, blocks: (B:60:0x0146, B:64:0x0159, B:74:0x0186, B:75:0x018b, B:76:0x018c, B:82:0x01ae, B:57:0x0130), top: B:107:0x0130 }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01e1 A[Catch: Exception -> 0x017b, TryCatch #0 {Exception -> 0x017b, blocks: (B:68:0x0174, B:87:0x01ce, B:89:0x01e1, B:91:0x020c, B:80:0x01a7, B:86:0x01c8), top: B:99:0x002f }] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x020c A[Catch: Exception -> 0x017b, TRY_LEAVE, TryCatch #0 {Exception -> 0x017b, blocks: (B:68:0x0174, B:87:0x01ce, B:89:0x01e1, B:91:0x020c, B:80:0x01a7, B:86:0x01c8), top: B:99:0x002f }] */
    /* JADX WARN: Type inference failed for: r14v15 */
    /* JADX WARN: Type inference failed for: r14v28 */
    /* JADX WARN: Type inference failed for: r14v3 */
    /* JADX WARN: Type inference failed for: r26v0, types: [stepai.aios.guiexecutor.handler.c] */
    /* JADX WARN: Type inference failed for: r5v1, types: [stepai.aios.guiexecutor.handler.ClickCommandHandler$handle$1] */
    /* JADX WARN: Type inference failed for: r5v14, types: [stepai.aios.guiexecutor.handler.ClickCommandHandler$handle$1] */
    /* JADX WARN: Type inference failed for: r5v2, types: [H7.c, kotlin.coroutines.jvm.internal.ContinuationImpl, stepai.aios.guiexecutor.handler.ClickCommandHandler$handle$1] */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v6 */
    @Override // stepai.aios.guiexecutor.api.GuiCommandHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object handle(stepai.aios.guiexecutor.api.GuiCommand r27, H7.c r28) {
        /*
            Method dump skipped, instructions count: 618
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiexecutor.handler.c.handle(stepai.aios.guiexecutor.api.GuiCommand, H7.c):java.lang.Object");
    }

    @Override // stepai.aios.guiexecutor.api.GuiCommandHandler
    public final ValidationResult validate(GuiCommand command) {
        kotlin.jvm.internal.k.f(command, "command");
        if (!(command.getParameters() instanceof GuiParameters.TouchParams)) {
            return ValidationResult.INSTANCE.failure("Invalid touch parameters type");
        }
        GuiParameters parameters = command.getParameters();
        GuiTarget target = command.getTarget();
        GuiParameters.TouchParams touchParams = (GuiParameters.TouchParams) parameters;
        if (touchParams.getTapCount() <= 0) {
            return ValidationResult.INSTANCE.failure("Invalid tap count: " + touchParams.getTapCount());
        }
        int i = Ha.b.b[target.getType().ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    return ValidationResult.INSTANCE.failure("Unsupported target type for touch: " + target.getType());
                }
                if (target.getBounds() == null) {
                    return ValidationResult.INSTANCE.failure("Bounds target requires bounds");
                }
            } else if (target.getSelector() == null) {
                return ValidationResult.INSTANCE.failure("Element target requires selector");
            }
        } else if (target.getCoordinate() == null) {
            return ValidationResult.INSTANCE.failure("Coordinate target requires coordinate");
        }
        return ValidationResult.INSTANCE.success();
    }
}
