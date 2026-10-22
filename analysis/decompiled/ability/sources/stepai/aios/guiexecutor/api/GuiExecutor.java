package stepai.aios.guiexecutor.api;

import H7.c;
import java.util.List;
import kotlin.Metadata;
import stepai.aios.guiexecutor.core.AppInfo;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H¦@¢\u0006\u0004\b\u0005\u0010\u0006J$\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H¦@¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0013H&¢\u0006\u0004\b\u0015\u0010\u0016J\u0011\u0010\u0018\u001a\u0004\u0018\u00010\u0017H&¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006\u001aÀ\u0006\u0003"}, d2 = {"Lstepai/aios/guiexecutor/api/GuiExecutor;", "", "Lstepai/aios/guiexecutor/api/GuiCommand;", "command", "Lstepai/aios/guiexecutor/api/GuiResult;", "execute", "(Lstepai/aios/guiexecutor/api/GuiCommand;LH7/c;)Ljava/lang/Object;", "", "commands", "executeBatch", "(Ljava/util/List;LH7/c;)Ljava/lang/Object;", "Lstepai/aios/guiexecutor/api/GuiCommandType;", "commandType", "", "isSupported", "(Lstepai/aios/guiexecutor/api/GuiCommandType;)Z", "Lstepai/aios/guiexecutor/api/GuiExecutorStatus;", "getStatus", "()Lstepai/aios/guiexecutor/api/GuiExecutorStatus;", "", "commandId", "cancelCommand", "(Ljava/lang/String;)Z", "Lstepai/aios/guiexecutor/core/AppInfo;", "getLastAwokenApp", "()Lstepai/aios/guiexecutor/core/AppInfo;", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface GuiExecutor {
    boolean cancelCommand(String commandId);

    Object execute(GuiCommand guiCommand, c<? super GuiResult> cVar);

    Object executeBatch(List<GuiCommand> list, c<? super List<GuiResult>> cVar);

    AppInfo getLastAwokenApp();

    GuiExecutorStatus getStatus();

    boolean isSupported(GuiCommandType commandType);
}
