package com.stepos.mcp.sdk.base;

import io.modelcontextprotocol.server.McpAsyncServerExchange;
import io.modelcontextprotocol.spec.McpSchema;
import jb.v;
import kc.t;
import kc.u;
import kc.w;
import kc.z;
import nb.c;
import nb.h;
import ob.a;
import od.f;
import pb.e;
import pb.i;
import reactor.core.publisher.Mono;
import xb.p;
import xb.q;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
@e(c = "com.stepos.mcp.sdk.base.BaseMCPService$addTool$1$1", f = "BaseMCPService.kt", l = {103}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class BaseMCPService$addTool$1$1 extends i implements p {
    final /* synthetic */ q $handler;
    final /* synthetic */ McpAsyncServerExchange $t;
    final /* synthetic */ McpSchema.CallToolRequest $u;
    int label;
    final /* synthetic */ BaseMCPService this$0;

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    @e(c = "com.stepos.mcp.sdk.base.BaseMCPService$addTool$1$1$1", f = "BaseMCPService.kt", l = {101}, m = "invokeSuspend")
    /* renamed from: com.stepos.mcp.sdk.base.BaseMCPService$addTool$1$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends i implements p {
        final /* synthetic */ q $handler;
        final /* synthetic */ McpAsyncServerExchange $t;
        final /* synthetic */ McpSchema.CallToolRequest $u;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(q qVar, McpAsyncServerExchange mcpAsyncServerExchange, McpSchema.CallToolRequest callToolRequest, c cVar) {
            super(2, cVar);
            this.$handler = qVar;
            this.$t = mcpAsyncServerExchange;
            this.$u = callToolRequest;
        }

        @Override // pb.a
        public final c create(Object obj, c cVar) {
            return new AnonymousClass1(this.$handler, this.$t, this.$u, cVar);
        }

        @Override // xb.p
        public final Object invoke(t tVar, c cVar) {
            return ((AnonymousClass1) create(tVar, cVar)).invokeSuspend(v.f6774a);
        }

        @Override // pb.a
        public final Object invokeSuspend(Object obj) {
            a aVar = a.f9351c;
            int i = this.label;
            if (i == 0) {
                id.c.I(obj);
                q qVar = this.$handler;
                McpAsyncServerExchange mcpAsyncServerExchange = this.$t;
                mcpAsyncServerExchange.getClass();
                McpSchema.CallToolRequest callToolRequest = this.$u;
                callToolRequest.getClass();
                this.label = 1;
                obj = qVar.invoke(mcpAsyncServerExchange, callToolRequest, this);
                if (obj == aVar) {
                    return aVar;
                }
            } else {
                if (i != 1) {
                    f.e("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                id.c.I(obj);
            }
            return Mono.just(obj);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseMCPService$addTool$1$1(BaseMCPService baseMCPService, q qVar, McpAsyncServerExchange mcpAsyncServerExchange, McpSchema.CallToolRequest callToolRequest, c cVar) {
        super(2, cVar);
        this.this$0 = baseMCPService;
        this.$handler = qVar;
        this.$t = mcpAsyncServerExchange;
        this.$u = callToolRequest;
    }

    @Override // pb.a
    public final c create(Object obj, c cVar) {
        return new BaseMCPService$addTool$1$1(this.this$0, this.$handler, this.$t, this.$u, cVar);
    }

    @Override // xb.p
    public final Object invoke(t tVar, c cVar) {
        return ((BaseMCPService$addTool$1$1) create(tVar, cVar)).invokeSuspend(v.f6774a);
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        a aVar = a.f9351c;
        int i = this.label;
        boolean z10 = true;
        if (i == 0) {
            id.c.I(obj);
            t serviceScope = this.this$0.getServiceScope();
            if (serviceScope == null) {
                return null;
            }
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$handler, this.$t, this.$u, null);
            u uVar = u.f7481c;
            kc.a zVar = new z(w.v(serviceScope, h.f8811c), z10, 0);
            zVar.c0(uVar, zVar, anonymousClass1);
            this.label = 1;
            obj = zVar.s(this);
            if (obj == aVar) {
                return aVar;
            }
        } else {
            if (i != 1) {
                f.e("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            id.c.I(obj);
        }
        return (Mono) obj;
    }
}
