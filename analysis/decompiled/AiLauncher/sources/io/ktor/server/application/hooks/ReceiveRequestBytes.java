package io.ktor.server.application.hooks;

import W4.b;
import Y8.t;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import io.ktor.server.application.ApplicationCall;
import io.ktor.server.application.ApplicationCallPipeline;
import io.ktor.server.application.Hook;
import io.ktor.server.application.PipelineCall;
import io.ktor.server.request.ApplicationReceivePipeline;
import io.ktor.util.pipeline.PipelineContext;
import io.ktor.utils.io.ByteReadChannel;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;
import p9.q;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J1\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00072\u0018\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lio/ktor/server/application/hooks/ReceiveRequestBytes;", "Lio/ktor/server/application/Hook;", "Lkotlin/Function2;", "Lio/ktor/server/application/ApplicationCall;", "Lio/ktor/utils/io/ByteReadChannel;", "<init>", "()V", "Lio/ktor/server/application/ApplicationCallPipeline;", "pipeline", "handler", "LY8/t;", b.STEP_INSTALL, "(Lio/ktor/server/application/ApplicationCallPipeline;Lp9/p;)V", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ReceiveRequestBytes implements Hook<p<? super ApplicationCall, ? super ByteReadChannel, ? extends ByteReadChannel>> {
    public static final ReceiveRequestBytes INSTANCE = new ReceiveRequestBytes();

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lio/ktor/util/pipeline/PipelineContext;", "", "Lio/ktor/server/application/PipelineCall;", "body", "LY8/t;", "<anonymous>", "(Lio/ktor/util/pipeline/PipelineContext;Ljava/lang/Object;)V"}, k = 3, mv = {2, 1, 0})
    @InterfaceC4112d(c = "io.ktor.server.application.hooks.ReceiveRequestBytes$install$1", f = "CommonHooks.kt", l = {147}, m = "invokeSuspend")
    /* renamed from: io.ktor.server.application.hooks.ReceiveRequestBytes$install$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements q<PipelineContext<Object, PipelineCall>, Object, InterfaceC4014c<? super t>, Object> {
        final /* synthetic */ p<ApplicationCall, ByteReadChannel, ByteReadChannel> $handler;
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(p<? super ApplicationCall, ? super ByteReadChannel, ? extends ByteReadChannel> pVar, InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(3, interfaceC4014c);
            this.$handler = pVar;
        }

        @Override // p9.q
        public final Object invoke(PipelineContext<Object, PipelineCall> pipelineContext, Object obj, InterfaceC4014c<? super t> interfaceC4014c) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$handler, interfaceC4014c);
            anonymousClass1.L$0 = pipelineContext;
            anonymousClass1.L$1 = obj;
            return anonymousClass1.invokeSuspend(t.f7040a);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 == 0) {
                C4849c.b(obj);
                PipelineContext pipelineContext = (PipelineContext) this.L$0;
                Object obj2 = this.L$1;
                if (!(obj2 instanceof ByteReadChannel)) {
                    return t.f7040a;
                }
                ByteReadChannel byteReadChannel = (ByteReadChannel) this.$handler.invoke((PipelineCall) pipelineContext.getContext(), obj2);
                this.L$0 = null;
                this.label = 1;
                if (pipelineContext.proceedWith(byteReadChannel, this) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
            }
            return t.f7040a;
        }
    }

    private ReceiveRequestBytes() {
    }

    @Override // io.ktor.server.application.Hook
    public void install(ApplicationCallPipeline pipeline, p<? super ApplicationCall, ? super ByteReadChannel, ? extends ByteReadChannel> handler) {
        kotlin.jvm.internal.p.i(pipeline, "pipeline");
        kotlin.jvm.internal.p.i(handler, "handler");
        pipeline.getReceivePipeline().intercept(ApplicationReceivePipeline.INSTANCE.getBefore(), new AnonymousClass1(handler, null));
    }
}
