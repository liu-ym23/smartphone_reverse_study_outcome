package stepai.aios.guiexecutor.handler;

import com.stepos.taskrobot.llmapi.stepfun.TaskTimeouts;
import kotlin.jvm.internal.k;
import stepai.aios.guiexecutor.api.GuiCommand;
import stepai.aios.guiexecutor.api.GuiCommandHandler;
import stepai.aios.guiexecutor.api.GuiCommandType;
import stepai.aios.guiexecutor.api.GuiParameters;
import stepai.aios.guiexecutor.api.ValidationResult;

/* loaded from: classes4.dex */
public final class g implements GuiCommandHandler {

    /* renamed from: a, reason: collision with root package name */
    public final GuiCommandType f6196a = GuiCommandType.WAIT;

    @Override // stepai.aios.guiexecutor.api.GuiCommandHandler
    public final GuiCommandType getSupportedType() {
        return this.f6196a;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    @Override // stepai.aios.guiexecutor.api.GuiCommandHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object handle(stepai.aios.guiexecutor.api.GuiCommand r16, H7.c r17) {
        /*
            Method dump skipped, instructions count: 241
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: stepai.aios.guiexecutor.handler.g.handle(stepai.aios.guiexecutor.api.GuiCommand, H7.c):java.lang.Object");
    }

    @Override // stepai.aios.guiexecutor.api.GuiCommandHandler
    public final ValidationResult validate(GuiCommand command) {
        k.f(command, "command");
        if (!(command.getParameters() instanceof GuiParameters.WaitParams)) {
            return ValidationResult.INSTANCE.failure("Invalid wait parameters type");
        }
        GuiParameters.WaitParams waitParams = (GuiParameters.WaitParams) command.getParameters();
        if (waitParams.getDuration() <= 0) {
            return ValidationResult.INSTANCE.failure("Invalid duration: " + waitParams.getDuration());
        }
        if (waitParams.getDuration() <= TaskTimeouts.TAKEOVER_IDLE_MS) {
            return ValidationResult.INSTANCE.success();
        }
        return ValidationResult.INSTANCE.failure("Duration too long: " + waitParams.getDuration());
    }
}
