package com.stepos.mcp.sdk.base;

import C7.r;
import J7.c;
import S7.n;
import io.modelcontextprotocol.server.McpAsyncServerExchange;
import io.modelcontextprotocol.spec.McpSchema;
import kotlin.Metadata;
import kotlin.b;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.k;
import m9.AbstractC1683A;
import m9.C1687E;
import m9.InterfaceC1733z;
import reactor.core.publisher.Mono;
import v7.o;

@c(c = "com.stepos.mcp.sdk.base.BaseMCPService$addTool$1$1", f = "BaseMCPService.kt", l = {o.META_DATA_FIELD_NUMBER}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lm9/z;", "Lreactor/core/publisher/Mono;", "Lio/modelcontextprotocol/spec/McpSchema$CallToolResult;", "kotlin.jvm.PlatformType", "<anonymous>", "(Lm9/z;)Lreactor/core/publisher/Mono;"}, k = 3, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public final class BaseMCPService$addTool$1$1 extends SuspendLambda implements n {
    final /* synthetic */ S7.o $handler;
    final /* synthetic */ McpAsyncServerExchange $t;
    final /* synthetic */ McpSchema.CallToolRequest $u;
    int label;
    final /* synthetic */ BaseMCPService this$0;

    @c(c = "com.stepos.mcp.sdk.base.BaseMCPService$addTool$1$1$1", f = "BaseMCPService.kt", l = {101}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a&\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lm9/z;", "Lreactor/core/publisher/Mono;", "Lio/modelcontextprotocol/spec/McpSchema$CallToolResult;", "kotlin.jvm.PlatformType", "<anonymous>", "(Lm9/z;)Lreactor/core/publisher/Mono;"}, k = 3, mv = {1, 9, 0})
    /* renamed from: com.stepos.mcp.sdk.base.BaseMCPService$addTool$1$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements n {
        final /* synthetic */ S7.o $handler;
        final /* synthetic */ McpAsyncServerExchange $t;
        final /* synthetic */ McpSchema.CallToolRequest $u;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(S7.o oVar, McpAsyncServerExchange mcpAsyncServerExchange, McpSchema.CallToolRequest callToolRequest, H7.c<? super AnonymousClass1> cVar) {
            super(2, cVar);
            this.$handler = oVar;
            this.$t = mcpAsyncServerExchange;
            this.$u = callToolRequest;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new AnonymousClass1(this.$handler, this.$t, this.$u, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i == 0) {
                b.b(obj);
                S7.o oVar = this.$handler;
                McpAsyncServerExchange t9 = this.$t;
                k.e(t9, "$t");
                McpSchema.CallToolRequest u = this.$u;
                k.e(u, "$u");
                this.label = 1;
                obj = oVar.invoke(t9, u, this);
                if (obj == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                b.b(obj);
            }
            return Mono.just(obj);
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super Mono<McpSchema.CallToolResult>> cVar) {
            return ((AnonymousClass1) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseMCPService$addTool$1$1(BaseMCPService baseMCPService, S7.o oVar, McpAsyncServerExchange mcpAsyncServerExchange, McpSchema.CallToolRequest callToolRequest, H7.c<? super BaseMCPService$addTool$1$1> cVar) {
        super(2, cVar);
        this.this$0 = baseMCPService;
        this.$handler = oVar;
        this.$t = mcpAsyncServerExchange;
        this.$u = callToolRequest;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c<r> create(Object obj, H7.c<?> cVar) {
        return new BaseMCPService$addTool$1$1(this.this$0, this.$handler, this.$t, this.$u, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        int i = this.label;
        if (i == 0) {
            b.b(obj);
            InterfaceC1733z serviceScope = this.this$0.getServiceScope();
            if (serviceScope == null) {
                return null;
            }
            C1687E c1687eD = AbstractC1683A.d(serviceScope, null, new AnonymousClass1(this.$handler, this.$t, this.$u, null), 3);
            this.label = 1;
            obj = c1687eD.z(this);
            if (obj == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            b.b(obj);
        }
        return (Mono) obj;
    }

    @Override // S7.n
    public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super Mono<McpSchema.CallToolResult>> cVar) {
        return ((BaseMCPService$addTool$1$1) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
    }
}
