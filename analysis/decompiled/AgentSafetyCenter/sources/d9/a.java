package d9;

import a8.c;
import android.util.Log;
import b8.g0;
import com.stepos.agentsafetycenter.mcp.service.AbilityService;
import d2.y;
import io.modelcontextprotocol.server.McpAsyncServerExchange;
import io.modelcontextprotocol.spec.McpSchema;
import java.lang.invoke.VarHandle;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import kb.l;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements BiFunction {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ AbilityService f3292c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ String f3293f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ a9.b f3294g;

    @Override // java.util.function.BiFunction
    public final Object apply(Object obj, Object obj2) {
        Mono monoSubscribeOn;
        AbilityService abilityService = this.f3292c;
        String str = this.f3293f;
        a9.b bVar = this.f3294g;
        McpAsyncServerExchange mcpAsyncServerExchange = (McpAsyncServerExchange) obj;
        McpSchema.CallToolRequest callToolRequest = (McpSchema.CallToolRequest) obj2;
        int i = AbilityService.f2507g;
        mcpAsyncServerExchange.getClass();
        callToolRequest.getClass();
        String strName = callToolRequest.name();
        Map<String, Object> mapArguments = callToolRequest.arguments();
        mapArguments.getClass();
        Map<String, Object> mapMeta = callToolRequest.meta();
        b9.a aVar = new b9.a();
        aVar.f2042a = strName;
        aVar.f2043b = mapArguments;
        aVar.f2044c = mapMeta;
        aVar.f2045d = mcpAsyncServerExchange;
        VarHandle.storeStoreFence();
        String str2 = abilityService.f2508c;
        Set<String> setKeySet = mapArguments.keySet();
        Log.i(str2, "handle tool=" + str + " argKeys=" + (setKeySet != null ? l.H0(setKeySet) : null));
        int i3 = 0;
        int i10 = 1;
        switch (bVar.f244a) {
            case 0:
                a9.a aVar2 = new a9.a(i3);
                aVar2.f243g = bVar;
                aVar2.f242f = aVar;
                VarHandle.storeStoreFence();
                monoSubscribeOn = Mono.fromCallable(aVar2).subscribeOn(Schedulers.boundedElastic());
                monoSubscribeOn.getClass();
                break;
            default:
                a9.a aVar3 = new a9.a(i10);
                aVar3.f243g = bVar;
                aVar3.f242f = aVar;
                VarHandle.storeStoreFence();
                monoSubscribeOn = Mono.fromCallable(aVar3).subscribeOn(Schedulers.boundedElastic());
                monoSubscribeOn.getClass();
                break;
        }
        b bVar2 = new b(i3);
        bVar2.f3296f = abilityService;
        bVar2.f3297g = str;
        VarHandle.storeStoreFence();
        g0 g0Var = new g0(3);
        g0Var.f1963f = bVar2;
        VarHandle.storeStoreFence();
        Mono monoDoOnSuccess = monoSubscribeOn.doOnSuccess(g0Var);
        b bVar3 = new b(i10);
        bVar3.f3296f = abilityService;
        bVar3.f3297g = str;
        VarHandle.storeStoreFence();
        g0 g0Var2 = new g0(4);
        g0Var2.f1963f = bVar3;
        VarHandle.storeStoreFence();
        Mono monoDoOnError = monoDoOnSuccess.doOnError(g0Var2);
        y yVar = new y(11);
        c cVar = new c(i10);
        cVar.f234b = yVar;
        VarHandle.storeStoreFence();
        return monoDoOnError.map(cVar);
    }
}
