package io.ktor.server.application;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import io.ktor.util.pipeline.PipelineContext;
import io.ktor.utils.io.KtorDsl;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.p;

@KtorDsl
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B%\b\u0000\u0012\u0006\u0010\u0004\u001a\u00028\u0000\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\b\u0010\tJ:\u0010\u000f\u001a\u00020\u000e2(\u0010\r\u001a$\b\u0001\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\nH\u0086@¢\u0006\u0004\b\u000f\u0010\u0010R&\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00060\u00058\u0014X\u0094\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lio/ktor/server/application/OnCallRespondContext;", "", "PluginConfig", "Lio/ktor/server/application/CallContext;", "pluginConfig", "Lio/ktor/util/pipeline/PipelineContext;", "Lio/ktor/server/application/PipelineCall;", "context", "<init>", "(Ljava/lang/Object;Lio/ktor/util/pipeline/PipelineContext;)V", "Lkotlin/Function3;", "Lio/ktor/server/application/TransformBodyContext;", "Le9/c;", "transform", "LY8/t;", "transformBody", "(Lp9/q;Le9/c;)Ljava/lang/Object;", "Lio/ktor/util/pipeline/PipelineContext;", "getContext", "()Lio/ktor/util/pipeline/PipelineContext;", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class OnCallRespondContext<PluginConfig> extends CallContext<PluginConfig> {
    private final PipelineContext<Object, PipelineCall> context;

    @InterfaceC4112d(c = "io.ktor.server.application.OnCallRespondContext", f = "KtorCallContexts.kt", l = {102}, m = "transformBody")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: io.ktor.server.application.OnCallRespondContext$transformBody$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ OnCallRespondContext<PluginConfig> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(OnCallRespondContext<PluginConfig> onCallRespondContext, InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(interfaceC4014c);
            this.this$0 = onCallRespondContext;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.transformBody(null, this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OnCallRespondContext(PluginConfig pluginConfig, PipelineContext<Object, PipelineCall> context) {
        super(pluginConfig, context);
        p.i(pluginConfig, "pluginConfig");
        p.i(context, "context");
        this.context = context;
    }

    @Override // io.ktor.server.application.CallContext
    public PipelineContext<Object, PipelineCall> getContext() {
        return this.context;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object transformBody(p9.q<? super io.ktor.server.application.TransformBodyContext, java.lang.Object, ? super e9.InterfaceC4014c<java.lang.Object>, ? extends java.lang.Object> r5, e9.InterfaceC4014c<? super Y8.t> r6) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r6 instanceof io.ktor.server.application.OnCallRespondContext.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r6
            io.ktor.server.application.OnCallRespondContext$transformBody$1 r0 = (io.ktor.server.application.OnCallRespondContext.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.server.application.OnCallRespondContext$transformBody$1 r0 = new io.ktor.server.application.OnCallRespondContext$transformBody$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r4 = r0.L$0
            io.ktor.util.pipeline.PipelineContext r4 = (io.ktor.util.pipeline.PipelineContext) r4
            kotlin.C4849c.b(r6)
            goto L67
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L35:
            kotlin.C4849c.b(r6)
            io.ktor.server.application.TransformBodyContext r6 = new io.ktor.server.application.TransformBodyContext
            io.ktor.util.pipeline.PipelineContext r2 = r4.getContext()
            java.lang.Object r2 = r2.getContext()
            io.ktor.server.application.PipelineCall r2 = (io.ktor.server.application.PipelineCall) r2
            io.ktor.server.response.PipelineResponse r2 = r2.getResponse()
            io.ktor.util.reflect.TypeInfo r2 = io.ktor.server.response.ResponseTypeKt.getResponseType(r2)
            r6.<init>(r2)
            io.ktor.util.pipeline.PipelineContext r2 = r4.getContext()
            io.ktor.util.pipeline.PipelineContext r4 = r4.getContext()
            java.lang.Object r4 = r4.getSubject()
            r0.L$0 = r2
            r0.label = r3
            java.lang.Object r6 = r5.invoke(r6, r4, r0)
            if (r6 != r1) goto L66
            return r1
        L66:
            r4 = r2
        L67:
            r4.setSubject(r6)
            Y8.t r4 = Y8.t.f7040a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.server.application.OnCallRespondContext.transformBody(p9.q, e9.c):java.lang.Object");
    }
}
