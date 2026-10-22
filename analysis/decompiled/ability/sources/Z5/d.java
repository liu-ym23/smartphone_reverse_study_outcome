package Z5;

import S7.o;
import com.stepos.mcp.sdk.base.BaseMCPService;
import com.stepos.mcp.sdk.java.service.AbsMCPService;
import com.stepos.taskrobot.ability.TaskRobotMCPService;
import com.stepos.taskrobot.ability.TaskRobotMcpTool;
import io.modelcontextprotocol.server.McpAsyncServerExchange;
import io.modelcontextprotocol.spec.McpSchema;
import java.util.function.BiFunction;

/* loaded from: classes3.dex */
public final /* synthetic */ class d implements BiFunction {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1597a;
    public final /* synthetic */ AbsMCPService b;
    public final /* synthetic */ Object c;

    public /* synthetic */ d(AbsMCPService absMCPService, Object obj, int i) {
        this.f1597a = i;
        this.b = absMCPService;
        this.c = obj;
    }

    @Override // java.util.function.BiFunction
    public final Object apply(Object obj, Object obj2) {
        switch (this.f1597a) {
            case 0:
                return TaskRobotMCPService.initToolHandlers$lambda$0$0((TaskRobotMCPService) this.b, (TaskRobotMcpTool) this.c, (McpAsyncServerExchange) obj, (McpSchema.CallToolRequest) obj2);
            default:
                return BaseMCPService.addTool$lambda$0((BaseMCPService) this.b, (o) this.c, (McpAsyncServerExchange) obj, (McpSchema.CallToolRequest) obj2);
        }
    }
}
