package stepai.aios.guiexecutor.core;

import H7.c;
import java.util.Set;
import kotlin.Metadata;
import stepai.aios.guiexecutor.api.GuiCommand;
import stepai.aios.guiexecutor.api.GuiCommandHandler;
import stepai.aios.guiexecutor.api.GuiCommandType;
import stepai.aios.guiexecutor.api.GuiResult;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H¦@¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\f0\u0013H&¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016À\u0006\u0003"}, d2 = {"Lstepai/aios/guiexecutor/core/CommandDispatcher;", "", "Lstepai/aios/guiexecutor/api/GuiCommand;", "command", "Lstepai/aios/guiexecutor/api/GuiResult;", "dispatch", "(Lstepai/aios/guiexecutor/api/GuiCommand;LH7/c;)Ljava/lang/Object;", "Lstepai/aios/guiexecutor/api/GuiCommandHandler;", "handler", "LC7/r;", "registerHandler", "(Lstepai/aios/guiexecutor/api/GuiCommandHandler;)V", "Lstepai/aios/guiexecutor/api/GuiCommandType;", "commandType", "unregisterHandler", "(Lstepai/aios/guiexecutor/api/GuiCommandType;)V", "", "isSupported", "(Lstepai/aios/guiexecutor/api/GuiCommandType;)Z", "", "getSupportedTypes", "()Ljava/util/Set;", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface CommandDispatcher {
    Object dispatch(GuiCommand guiCommand, c<? super GuiResult> cVar);

    Set<GuiCommandType> getSupportedTypes();

    boolean isSupported(GuiCommandType commandType);

    void registerHandler(GuiCommandHandler handler);

    void unregisterHandler(GuiCommandType commandType);
}
