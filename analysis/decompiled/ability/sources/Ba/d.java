package Ba;

import N9.j;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.k;
import stepai.aios.guiagent.config.Action;
import stepai.aios.guiagent.config.ActionState;
import stepai.aios.guiexecutor.api.ErrorCode;
import stepai.aios.guiexecutor.api.GuiError;
import stepai.aios.guiexecutor.api.GuiResult;

/* loaded from: classes4.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f268a = new d();
    public static volatile e b;

    public static za.a a(GuiResult guiResult, Action originalAction) {
        k.f(guiResult, "guiResult");
        k.f(originalAction, "originalAction");
        try {
            return guiResult.getSuccess() ? c(guiResult, originalAction) : b(guiResult, originalAction);
        } catch (Exception e) {
            j.J("Failed to translate GUI result: " + e.getMessage(), "GuiResultToActionResultTranslator");
            String errorMessage = B7.a.k("Result translation failed: ", e.getMessage());
            long executionTime = guiResult.getExecutionTime();
            k.f(errorMessage, "errorMessage");
            return new za.a(false, Action.copy$default(originalAction, null, null, null, ActionState.FAILED, 0L, errorMessage, 23, null), errorMessage, executionTime, 48);
        }
    }

    public static za.a b(GuiResult guiResult, Action action) {
        GuiError error = guiResult.getError();
        ErrorCode code = error != null ? error.getCode() : null;
        GuiError error2 = guiResult.getError();
        String message = error2 != null ? error2.getMessage() : null;
        if (message == null) {
            message = "Unknown error";
        }
        switch (code == null ? -1 : i.f273a[code.ordinal()]) {
            case -1:
                break;
            case 0:
            default:
                throw new NoWhenBranchMatchedException();
            case 1:
                message = "Target not found: ".concat(message);
                break;
            case 2:
                message = "Target not clickable: ".concat(message);
                break;
            case 3:
                message = "Target not visible: ".concat(message);
                break;
            case 4:
                message = "Target out of bounds: ".concat(message);
                break;
            case 5:
                message = "Accessibility disabled: ".concat(message);
                break;
            case 6:
                message = "Permission denied: ".concat(message);
                break;
            case 7:
                message = "Service unavailable: ".concat(message);
                break;
            case 8:
                message = "System error: ".concat(message);
                break;
            case 9:
                message = "Operation timeout: ".concat(message);
                break;
            case 10:
                message = "Invalid parameter: ".concat(message);
                break;
            case 11:
                message = "Operation failed: ".concat(message);
                break;
            case 12:
                message = "Operation cancelled: ".concat(message);
                break;
            case 13:
                message = "Unsupported operation: ".concat(message);
                break;
            case 14:
                message = "Input method error: ".concat(message);
                break;
            case 15:
                message = "Text too long: ".concat(message);
                break;
            case 16:
                message = "Invalid text: ".concat(message);
                break;
            case 17:
                message = "Gesture failed: ".concat(message);
                break;
            case 18:
                message = "Invalid gesture: ".concat(message);
                break;
            case 19:
                message = "Gesture interrupted: ".concat(message);
                break;
            case 20:
                message = "Network error: ".concat(message);
                break;
            case 21:
                message = "Connection timeout: ".concat(message);
                break;
            case 22:
                message = "Takeover request failed: ".concat(message);
                break;
            case 23:
                message = "Takeover invalid parameter: ".concat(message);
                break;
            case 24:
                message = "Unknown error: ".concat(message);
                break;
            case 25:
                message = "Internal error: ".concat(message);
                break;
            case 26:
                message = "Configuration error: ".concat(message);
                break;
        }
        String errorMessage = message;
        j.J("Translated GUI failure for action " + action.getId() + ": " + errorMessage, "GuiResultToActionResultTranslator");
        ActionState actionState = ActionState.FAILED;
        Action action2 = Action.copy$default(action, null, null, null, actionState, 0L, errorMessage, 23, null);
        long executionTime = guiResult.getExecutionTime();
        k.f(action2, "action");
        k.f(errorMessage, "errorMessage");
        return new za.a(false, Action.copy$default(action2, null, null, null, actionState, 0L, errorMessage, 23, null), errorMessage, executionTime, 48);
    }

    public static za.a c(GuiResult guiResult, Action action) {
        j.H("Successfully translated GUI result for action " + action.getId(), "GuiResultToActionResultTranslator");
        ActionState actionState = ActionState.SUCCESS;
        Action action2 = Action.copy$default(action, null, null, null, actionState, 0L, null, 55, null);
        long executionTime = guiResult.getExecutionTime();
        k.f(action2, "action");
        return new za.a(true, Action.copy$default(action2, null, null, null, actionState, 0L, null, 55, null), "GUI command executed successfully", executionTime, 48);
    }
}
