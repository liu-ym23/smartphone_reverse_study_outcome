package stepai.aios.guiexecutor.handler;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.k;
import stepai.aios.guiexecutor.api.GuiActionExecutor;
import stepai.aios.guiexecutor.api.GuiCommand;
import stepai.aios.guiexecutor.api.GuiCommandHandler;
import stepai.aios.guiexecutor.api.GuiCommandType;
import stepai.aios.guiexecutor.api.GuiParameters;
import stepai.aios.guiexecutor.api.ValidationResult;

/* loaded from: classes4.dex */
public final class f implements GuiCommandHandler {

    /* renamed from: a, reason: collision with root package name */
    public final GuiActionExecutor f6195a;
    public final GuiCommandType b = GuiCommandType.SYSTEM_NAVIGATION;

    public f(GuiActionExecutor guiActionExecutor) {
        this.f6195a = guiActionExecutor;
    }

    @Override // stepai.aios.guiexecutor.api.GuiCommandHandler
    public final GuiCommandType getSupportedType() {
        return this.b;
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x00e0 A[Catch: Exception -> 0x0113, TryCatch #4 {Exception -> 0x0113, blocks: (B:43:0x00d8, B:45:0x00e0, B:49:0x0116), top: B:63:0x00d8 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0116 A[Catch: Exception -> 0x0113, TRY_LEAVE, TryCatch #4 {Exception -> 0x0113, blocks: (B:43:0x00d8, B:45:0x00e0, B:49:0x0116), top: B:63:0x00d8 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001d  */
    @Override // stepai.aios.guiexecutor.api.GuiCommandHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object handle(stepai.aios.guiexecutor.api.GuiCommand r26, H7.c r27) {
        /*
            Method dump skipped, instructions count: 381
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiexecutor.handler.f.handle(stepai.aios.guiexecutor.api.GuiCommand, H7.c):java.lang.Object");
    }

    @Override // stepai.aios.guiexecutor.api.GuiCommandHandler
    public final ValidationResult validate(GuiCommand command) {
        k.f(command, "command");
        if (!(command.getParameters() instanceof GuiParameters.SystemNavigationParams)) {
            return ValidationResult.INSTANCE.failure("Invalid system navigation parameters type");
        }
        int i = Ha.c.f785a[((GuiParameters.SystemNavigationParams) command.getParameters()).getAction().ordinal()];
        if (i == 1 || i == 2 || i == 3 || i == 4) {
            return ValidationResult.INSTANCE.success();
        }
        throw new NoWhenBranchMatchedException();
    }
}
