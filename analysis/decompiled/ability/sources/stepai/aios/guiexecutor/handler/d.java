package stepai.aios.guiexecutor.handler;

import S7.k;
import j9.m;
import stepai.aios.guiexecutor.api.GuiActionExecutor;
import stepai.aios.guiexecutor.api.GuiCommand;
import stepai.aios.guiexecutor.api.GuiCommandHandler;
import stepai.aios.guiexecutor.api.GuiCommandType;
import stepai.aios.guiexecutor.api.GuiParameters;
import stepai.aios.guiexecutor.api.ValidationResult;

/* loaded from: classes4.dex */
public final class d implements GuiCommandHandler {

    /* renamed from: a, reason: collision with root package name */
    public final GuiActionExecutor f6193a;
    public final GuiCommandType b = GuiCommandType.INPUT;

    public d(GuiActionExecutor guiActionExecutor, k kVar, k kVar2) {
        this.f6193a = guiActionExecutor;
    }

    @Override // stepai.aios.guiexecutor.api.GuiCommandHandler
    public final GuiCommandType getSupportedType() {
        return this.b;
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00c8 A[Catch: Exception -> 0x0100, TryCatch #0 {Exception -> 0x0100, blocks: (B:39:0x00ba, B:41:0x00c8, B:45:0x0103, B:35:0x00a5), top: B:49:0x00a5 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0103 A[Catch: Exception -> 0x0100, TRY_LEAVE, TryCatch #0 {Exception -> 0x0100, blocks: (B:39:0x00ba, B:41:0x00c8, B:45:0x0103, B:35:0x00a5), top: B:49:0x00a5 }] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001c  */
    @Override // stepai.aios.guiexecutor.api.GuiCommandHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object handle(stepai.aios.guiexecutor.api.GuiCommand r25, H7.c r26) {
        /*
            Method dump skipped, instructions count: 345
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiexecutor.handler.d.handle(stepai.aios.guiexecutor.api.GuiCommand, H7.c):java.lang.Object");
    }

    @Override // stepai.aios.guiexecutor.api.GuiCommandHandler
    public final ValidationResult validate(GuiCommand command) {
        kotlin.jvm.internal.k.f(command, "command");
        if (!(command.getParameters() instanceof GuiParameters.InputParams)) {
            return ValidationResult.INSTANCE.failure("Invalid input parameters type");
        }
        GuiParameters.InputParams inputParams = (GuiParameters.InputParams) command.getParameters();
        if (m.s0(inputParams.getText())) {
            return ValidationResult.INSTANCE.failure("Text cannot be blank");
        }
        if (inputParams.getText().length() <= 10000) {
            return ValidationResult.INSTANCE.success();
        }
        return ValidationResult.INSTANCE.failure("Text too long: " + inputParams.getText().length());
    }
}
