package stepai.aios.guiexecutor.api;

import H7.c;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H¦@¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\r\u001a\u00020\n8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u000eÀ\u0006\u0003"}, d2 = {"Lstepai/aios/guiexecutor/api/GuiCommandHandler;", "", "Lstepai/aios/guiexecutor/api/GuiCommand;", "command", "Lstepai/aios/guiexecutor/api/GuiResult;", "handle", "(Lstepai/aios/guiexecutor/api/GuiCommand;LH7/c;)Ljava/lang/Object;", "Lstepai/aios/guiexecutor/api/ValidationResult;", "validate", "(Lstepai/aios/guiexecutor/api/GuiCommand;)Lstepai/aios/guiexecutor/api/ValidationResult;", "Lstepai/aios/guiexecutor/api/GuiCommandType;", "getSupportedType", "()Lstepai/aios/guiexecutor/api/GuiCommandType;", "supportedType", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface GuiCommandHandler {
    GuiCommandType getSupportedType();

    Object handle(GuiCommand guiCommand, c<? super GuiResult> cVar);

    ValidationResult validate(GuiCommand command);
}
