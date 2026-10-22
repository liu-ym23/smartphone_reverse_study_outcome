package Ha;

import android.content.Context;
import kotlin.jvm.internal.k;
import stepai.aios.guiexecutor.api.GuiCommand;
import stepai.aios.guiexecutor.api.GuiCommandHandler;
import stepai.aios.guiexecutor.api.GuiCommandType;
import stepai.aios.guiexecutor.api.GuiParameters;
import stepai.aios.guiexecutor.api.TaskAction;
import stepai.aios.guiexecutor.api.ValidationResult;

/* loaded from: classes4.dex */
public final class e implements GuiCommandHandler {

    /* renamed from: a, reason: collision with root package name */
    public final GuiCommandType f787a = GuiCommandType.TASK_ABORT;

    public e(Context context) {
    }

    @Override // stepai.aios.guiexecutor.api.GuiCommandHandler
    public final GuiCommandType getSupportedType() {
        return this.f787a;
    }

    @Override // stepai.aios.guiexecutor.api.GuiCommandHandler
    public final Object handle(GuiCommand guiCommand, H7.c cVar) {
        return new g().handle(guiCommand, cVar);
    }

    @Override // stepai.aios.guiexecutor.api.GuiCommandHandler
    public final ValidationResult validate(GuiCommand command) {
        k.f(command, "command");
        return !(command.getParameters() instanceof GuiParameters.TaskParams) ? ValidationResult.INSTANCE.failure("Invalid task parameters type") : ((GuiParameters.TaskParams) command.getParameters()).getAction() != TaskAction.ABORT ? ValidationResult.INSTANCE.failure("TaskAbortCommandHandler only supports ABORT action") : ValidationResult.INSTANCE.success();
    }
}
