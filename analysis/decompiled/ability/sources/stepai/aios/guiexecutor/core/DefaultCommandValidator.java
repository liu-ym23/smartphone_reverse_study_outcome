package stepai.aios.guiexecutor.core;

import N9.j;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import j9.m;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.k;
import stepai.aios.guiexecutor.api.GuiCommand;
import stepai.aios.guiexecutor.api.GuiCommandType;
import stepai.aios.guiexecutor.api.GuiOptions;
import stepai.aios.guiexecutor.api.GuiParameters;
import stepai.aios.guiexecutor.api.GuiTarget;
import stepai.aios.guiexecutor.api.TargetType;
import stepai.aios.guiexecutor.api.ValidationResult;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0018\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001dH\u0002¨\u0006\u001e"}, d2 = {"Lstepai/aios/guiexecutor/core/DefaultCommandValidator;", "Lstepai/aios/guiexecutor/core/CommandValidator;", AppAgent.CONSTRUCT, "()V", "validate", "Lstepai/aios/guiexecutor/api/ValidationResult;", "command", "Lstepai/aios/guiexecutor/api/GuiCommand;", "validateTarget", TypedValues.AttributesType.S_TARGET, "Lstepai/aios/guiexecutor/api/GuiTarget;", "commandType", "Lstepai/aios/guiexecutor/api/GuiCommandType;", "validateParameters", "parameters", "Lstepai/aios/guiexecutor/api/GuiParameters;", "validateTouchParameters", "validateInputParameters", "validateGestureParameters", "validateWaitParameters", "validateQueryParameters", "validateScrollParameters", "validateKeyParameters", "validateAwakeParameters", "validateTakeoverParameters", "validateTaskParameters", "validateSystemNavigationParameters", "validateOptions", "options", "Lstepai/aios/guiexecutor/api/GuiOptions;", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DefaultCommandValidator implements CommandValidator {

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[TargetType.values().length];
            try {
                iArr[TargetType.COORDINATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TargetType.ELEMENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[TargetType.BOUNDS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[GuiCommandType.values().length];
            try {
                iArr2[GuiCommandType.CLICK.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[GuiCommandType.INPUT.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[GuiCommandType.SWIPE.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[GuiCommandType.WAIT.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[GuiCommandType.ASK_FOR_INPUT.ordinal()] = 5;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[GuiCommandType.TAKEOVER.ordinal()] = 6;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr2[GuiCommandType.AWAKE_APP.ordinal()] = 7;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr2[GuiCommandType.TASK_COMPLETE.ordinal()] = 8;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr2[GuiCommandType.TASK_ABORT.ordinal()] = 9;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr2[GuiCommandType.SYSTEM_NAVIGATION.ordinal()] = 10;
            } catch (NoSuchFieldError unused13) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    private final ValidationResult validateAwakeParameters(GuiParameters parameters) {
        if (!(parameters instanceof GuiParameters.AwakeParams)) {
            return ValidationResult.INSTANCE.failure("Invalid awake parameters type");
        }
        GuiParameters.AwakeParams awakeParams = (GuiParameters.AwakeParams) parameters;
        if (m.s0(awakeParams.getPackageName())) {
            return ValidationResult.INSTANCE.failure("Package name cannot be blank");
        }
        if (awakeParams.getLaunchType() >= 0) {
            return ValidationResult.INSTANCE.success();
        }
        return ValidationResult.INSTANCE.failure("Invalid launch type: " + awakeParams.getLaunchType());
    }

    private final ValidationResult validateGestureParameters(GuiParameters parameters) {
        if (!(parameters instanceof GuiParameters.GestureParams)) {
            return ValidationResult.INSTANCE.failure("Invalid gesture parameters type");
        }
        GuiParameters.GestureParams gestureParams = (GuiParameters.GestureParams) parameters;
        if (gestureParams.getDuration() <= 0) {
            return ValidationResult.INSTANCE.failure("Invalid duration: " + gestureParams.getDuration());
        }
        if (gestureParams.getSteps() <= 0) {
            return ValidationResult.INSTANCE.failure("Invalid steps: " + gestureParams.getSteps());
        }
        if (gestureParams.getVelocity() > 0.0f) {
            return ValidationResult.INSTANCE.success();
        }
        return ValidationResult.INSTANCE.failure("Invalid velocity: " + gestureParams.getVelocity());
    }

    private final ValidationResult validateInputParameters(GuiParameters parameters) {
        if (!(parameters instanceof GuiParameters.InputParams)) {
            return ValidationResult.INSTANCE.failure("Invalid input parameters type");
        }
        GuiParameters.InputParams inputParams = (GuiParameters.InputParams) parameters;
        if (m.s0(inputParams.getText())) {
            return ValidationResult.INSTANCE.failure("Text cannot be blank");
        }
        if (inputParams.getText().length() <= 10000) {
            return ValidationResult.INSTANCE.success();
        }
        return ValidationResult.INSTANCE.failure("Text too long: " + inputParams.getText().length());
    }

    private final ValidationResult validateKeyParameters(GuiParameters parameters) {
        return !(parameters instanceof GuiParameters.KeyParams) ? ValidationResult.INSTANCE.failure("Invalid key parameters type") : ValidationResult.INSTANCE.success();
    }

    private final ValidationResult validateOptions(GuiOptions options) {
        if (options.getTimeout() <= 0) {
            return ValidationResult.INSTANCE.failure("Invalid timeout: " + options.getTimeout());
        }
        if (options.getRetryCount() < 0) {
            return ValidationResult.INSTANCE.failure("Invalid retry count: " + options.getRetryCount());
        }
        if (options.getRetryDelay() >= 0) {
            return ValidationResult.INSTANCE.success();
        }
        return ValidationResult.INSTANCE.failure("Invalid retry delay: " + options.getRetryDelay());
    }

    private final ValidationResult validateParameters(GuiParameters parameters, GuiCommandType commandType) {
        switch (WhenMappings.$EnumSwitchMapping$1[commandType.ordinal()]) {
            case 1:
                return validateTouchParameters(parameters);
            case 2:
                return validateInputParameters(parameters);
            case 3:
                return validateGestureParameters(parameters);
            case 4:
                return validateWaitParameters(parameters);
            case 5:
                return validateQueryParameters(parameters);
            case 6:
                return validateTakeoverParameters(parameters);
            case 7:
                return validateAwakeParameters(parameters);
            case 8:
                return validateTaskParameters(parameters);
            case 9:
                return validateTaskParameters(parameters);
            case 10:
                return validateSystemNavigationParameters(parameters);
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private final ValidationResult validateQueryParameters(GuiParameters parameters) {
        return !(parameters instanceof GuiParameters.QueryParams) ? ValidationResult.INSTANCE.failure("Invalid query parameters type") : ValidationResult.INSTANCE.success();
    }

    private final ValidationResult validateScrollParameters(GuiParameters parameters) {
        if (!(parameters instanceof GuiParameters.ScrollParams)) {
            return ValidationResult.INSTANCE.failure("Invalid scroll parameters type");
        }
        GuiParameters.ScrollParams scrollParams = (GuiParameters.ScrollParams) parameters;
        if (scrollParams.getDistance() <= 0) {
            return ValidationResult.INSTANCE.failure("Invalid distance: " + scrollParams.getDistance());
        }
        if (scrollParams.getDuration() > 0) {
            return ValidationResult.INSTANCE.success();
        }
        return ValidationResult.INSTANCE.failure("Invalid duration: " + scrollParams.getDuration());
    }

    private final ValidationResult validateSystemNavigationParameters(GuiParameters parameters) {
        return !(parameters instanceof GuiParameters.SystemNavigationParams) ? ValidationResult.INSTANCE.failure("Invalid system navigation parameters type") : ValidationResult.INSTANCE.success();
    }

    private final ValidationResult validateTakeoverParameters(GuiParameters parameters) {
        if (!(parameters instanceof GuiParameters.TakeoverParams)) {
            return ValidationResult.INSTANCE.failure("Invalid takeover parameters type");
        }
        if (!m.s0(((GuiParameters.TakeoverParams) parameters).getReason())) {
            return ValidationResult.INSTANCE.success();
        }
        j.J("Takeover reason is blank, continue execution", "CommandDispatcher");
        return ValidationResult.INSTANCE.success();
    }

    private final ValidationResult validateTarget(GuiTarget target, GuiCommandType commandType) {
        int i = WhenMappings.$EnumSwitchMapping$0[target.getType().ordinal()];
        if (i != 1) {
            if (i == 2) {
                return target.getSelector() == null ? ValidationResult.INSTANCE.failure("Element target requires selector") : ValidationResult.INSTANCE.success();
            }
            if (i == 3 && target.getBounds() == null) {
                return ValidationResult.INSTANCE.failure("Bounds target requires bounds");
            }
            return ValidationResult.INSTANCE.success();
        }
        if (target.getCoordinate() == null) {
            return ValidationResult.INSTANCE.failure("Coordinate target requires coordinate");
        }
        if (target.getCoordinate().x >= 0 && target.getCoordinate().y >= 0) {
            return ValidationResult.INSTANCE.success();
        }
        return ValidationResult.INSTANCE.failure("Invalid coordinate: " + target.getCoordinate());
    }

    private final ValidationResult validateTaskParameters(GuiParameters parameters) {
        return !(parameters instanceof GuiParameters.TaskParams) ? ValidationResult.INSTANCE.failure("Invalid task parameters type") : ValidationResult.INSTANCE.success();
    }

    private final ValidationResult validateTouchParameters(GuiParameters parameters) {
        if (!(parameters instanceof GuiParameters.TouchParams)) {
            return ValidationResult.INSTANCE.failure("Invalid touch parameters type");
        }
        GuiParameters.TouchParams touchParams = (GuiParameters.TouchParams) parameters;
        if (touchParams.getTapCount() > 0) {
            return ValidationResult.INSTANCE.success();
        }
        return ValidationResult.INSTANCE.failure("Invalid tap count: " + touchParams.getTapCount());
    }

    private final ValidationResult validateWaitParameters(GuiParameters parameters) {
        if (!(parameters instanceof GuiParameters.WaitParams)) {
            return ValidationResult.INSTANCE.failure("Invalid wait parameters type");
        }
        GuiParameters.WaitParams waitParams = (GuiParameters.WaitParams) parameters;
        if (waitParams.getDuration() > 0) {
            return ValidationResult.INSTANCE.success();
        }
        return ValidationResult.INSTANCE.failure("Invalid duration: " + waitParams.getDuration());
    }

    @Override // stepai.aios.guiexecutor.core.CommandValidator
    public ValidationResult validate(GuiCommand command) {
        k.f(command, "command");
        if (m.s0(command.getId())) {
            return ValidationResult.INSTANCE.failure("Command ID cannot be blank");
        }
        ValidationResult validationResultValidateTarget = validateTarget(command.getTarget(), command.getType());
        if (!validationResultValidateTarget.isValid()) {
            return validationResultValidateTarget;
        }
        ValidationResult validationResultValidateParameters = validateParameters(command.getParameters(), command.getType());
        if (!validationResultValidateParameters.isValid()) {
            return validationResultValidateParameters;
        }
        ValidationResult validationResultValidateOptions = validateOptions(command.getOptions());
        return !validationResultValidateOptions.isValid() ? validationResultValidateOptions : ValidationResult.INSTANCE.success();
    }
}
