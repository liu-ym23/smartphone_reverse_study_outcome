package stepai.aios.guiexecutor.core;

import kotlin.Metadata;
import stepai.aios.guiexecutor.api.GuiCommand;
import stepai.aios.guiexecutor.api.ValidationResult;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lstepai/aios/guiexecutor/core/CommandValidator;", "", "validate", "Lstepai/aios/guiexecutor/api/ValidationResult;", "command", "Lstepai/aios/guiexecutor/api/GuiCommand;", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface CommandValidator {
    ValidationResult validate(GuiCommand command);
}
