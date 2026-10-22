package Ha;

import N9.j;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.jvm.internal.k;
import stepai.aios.guiexecutor.api.ErrorCode;
import stepai.aios.guiexecutor.api.GuiCommand;
import stepai.aios.guiexecutor.api.GuiCommandHandler;
import stepai.aios.guiexecutor.api.GuiCommandType;
import stepai.aios.guiexecutor.api.GuiParameters;
import stepai.aios.guiexecutor.api.GuiResult;
import stepai.aios.guiexecutor.api.ValidationResult;

/* loaded from: classes4.dex */
public final class g implements GuiCommandHandler {

    /* renamed from: a, reason: collision with root package name */
    public final GuiCommandType f789a = GuiCommandType.TASK_COMPLETE;

    public static boolean a(String str, String str2, Map map) {
        try {
            j.F("Aborting task: id=" + str, "TaskCommandHandler");
            if (str2 != null) {
                j.F("Task abort message: " + com.stepos.statsrpk.d.M(str2), "TaskCommandHandler");
            }
            if (map == null) {
                return true;
            }
            j.F("Task abort result: " + com.stepos.statsrpk.d.L(map), "TaskCommandHandler");
            return true;
        } catch (Exception e) {
            com.stepos.statsrpk.service.c.n("Abort task error: ", e.getMessage(), "TaskCommandHandler");
            return false;
        }
    }

    public static boolean b(String str, String str2, Map map) {
        try {
            j.F("Completing task: id=" + str, "TaskCommandHandler");
            if (str2 != null) {
                j.F("Task completion message: " + com.stepos.statsrpk.d.M(str2), "TaskCommandHandler");
            }
            if (map == null) {
                return true;
            }
            j.F("Task completion result: " + com.stepos.statsrpk.d.L(map), "TaskCommandHandler");
            return true;
        } catch (Exception e) {
            com.stepos.statsrpk.service.c.n("Complete task error: ", e.getMessage(), "TaskCommandHandler");
            return false;
        }
    }

    @Override // stepai.aios.guiexecutor.api.GuiCommandHandler
    public final GuiCommandType getSupportedType() {
        return this.f789a;
    }

    @Override // stepai.aios.guiexecutor.api.GuiCommandHandler
    public final Object handle(GuiCommand guiCommand, H7.c cVar) {
        boolean zB;
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            j.F("Handling task command: " + guiCommand.getId(), "TaskCommandHandler");
            GuiParameters parameters = guiCommand.getParameters();
            k.d(parameters, "null cannot be cast to non-null type stepai.aios.guiexecutor.api.GuiParameters.TaskParams");
            GuiParameters.TaskParams taskParams = (GuiParameters.TaskParams) parameters;
            int i = f.f788a[taskParams.getAction().ordinal()];
            if (i == 1) {
                zB = b(guiCommand.getId(), taskParams.getMessage(), taskParams.getResult());
            } else {
                if (i != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                zB = a(guiCommand.getId(), taskParams.getMessage(), taskParams.getResult());
            }
            long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
            if (zB) {
                GuiResult.Companion companion = GuiResult.INSTANCE;
                String id = guiCommand.getId();
                Pair pair = new Pair("taskAction", taskParams.getAction().name());
                String message = taskParams.getMessage();
                Object obj = "";
                if (message == null) {
                    message = "";
                }
                Pair pair2 = new Pair("message", message);
                Map<String, Object> result = taskParams.getResult();
                if (result != null) {
                    obj = result;
                }
                return companion.success(id, jCurrentTimeMillis2, null, kotlin.collections.a.R(pair, pair2, new Pair("result", obj)));
            }
            j.G("Task command failed: id=" + guiCommand.getId() + ", action=" + taskParams.getAction(), "TaskCommandHandler");
            return GuiResult.Companion.failure$default(GuiResult.INSTANCE, guiCommand.getId(), ErrorCode.OPERATION_FAILED, "Task operation failed: " + taskParams.getAction(), jCurrentTimeMillis2, null, 16, null);
        } catch (Exception e) {
            long jCurrentTimeMillis3 = System.currentTimeMillis() - jCurrentTimeMillis;
            com.stepos.statsrpk.service.c.o("Task command error: ", guiCommand.getId(), " - ", e.getMessage(), "TaskCommandHandler");
            return GuiResult.INSTANCE.failure(guiCommand.getId(), ErrorCode.SYSTEM_ERROR, B7.a.k("Task execution error: ", e.getMessage()), jCurrentTimeMillis3, e);
        }
    }

    @Override // stepai.aios.guiexecutor.api.GuiCommandHandler
    public final ValidationResult validate(GuiCommand command) {
        k.f(command, "command");
        return !(command.getParameters() instanceof GuiParameters.TaskParams) ? ValidationResult.INSTANCE.failure("Invalid task parameters type") : ValidationResult.INSTANCE.success();
    }
}
