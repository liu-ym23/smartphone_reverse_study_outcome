package io.ktor.server.application;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import io.ktor.util.pipeline.PipelineContext;
import io.ktor.utils.io.KtorDsl;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.p;

@KtorDsl
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B%\b\u0000\u0012\u0006\u0010\u0004\u001a\u00028\u0000\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\b\u0010\tJ:\u0010\u0010\u001a\u00020\u000f2(\u0010\u000e\u001a$\b\u0001\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\r\u0012\u0006\u0012\u0004\u0018\u00010\u00010\nH\u0086@¢\u0006\u0004\b\u0010\u0010\u0011R&\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00060\u00058\u0014X\u0094\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lio/ktor/server/application/OnCallReceiveContext;", "", "PluginConfig", "Lio/ktor/server/application/CallContext;", "pluginConfig", "Lio/ktor/util/pipeline/PipelineContext;", "Lio/ktor/server/application/PipelineCall;", "context", "<init>", "(Ljava/lang/Object;Lio/ktor/util/pipeline/PipelineContext;)V", "Lkotlin/Function3;", "Lio/ktor/server/application/TransformBodyContext;", "Lio/ktor/utils/io/ByteReadChannel;", "Le9/c;", "transform", "LY8/t;", "transformBody", "(Lp9/q;Le9/c;)Ljava/lang/Object;", "Lio/ktor/util/pipeline/PipelineContext;", "getContext", "()Lio/ktor/util/pipeline/PipelineContext;", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class OnCallReceiveContext<PluginConfig> extends CallContext<PluginConfig> {
    private final PipelineContext<Object, PipelineCall> context;

    @InterfaceC4112d(c = "io.ktor.server.application.OnCallReceiveContext", f = "KtorCallContexts.kt", l = {76}, m = "transformBody")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: io.ktor.server.application.OnCallReceiveContext$transformBody$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ OnCallReceiveContext<PluginConfig> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(OnCallReceiveContext<PluginConfig> onCallReceiveContext, InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(interfaceC4014c);
            this.this$0 = onCallReceiveContext;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.transformBody(null, this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OnCallReceiveContext(PluginConfig pluginConfig, PipelineContext<Object, PipelineCall> context) {
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
    public final java.lang.Object transformBody(p9.q<? super io.ktor.server.application.TransformBodyContext, ? super io.ktor.utils.io.ByteReadChannel, ? super e9.InterfaceC4014c<java.lang.Object>, ? extends java.lang.Object> r6, e9.InterfaceC4014c<? super Y8.t> r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof io.ktor.server.application.OnCallReceiveContext.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r7
            io.ktor.server.application.OnCallReceiveContext$transformBody$1 r0 = (io.ktor.server.application.OnCallReceiveContext.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.server.application.OnCallReceiveContext$transformBody$1 r0 = new io.ktor.server.application.OnCallReceiveContext$transformBody$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r5 = r0.L$0
            io.ktor.util.pipeline.PipelineContext r5 = (io.ktor.util.pipeline.PipelineContext) r5
            kotlin.C4849c.b(r7)
            goto L6f
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L35:
            kotlin.C4849c.b(r7)
            io.ktor.util.pipeline.PipelineContext r7 = r5.getContext()
            java.lang.Object r7 = r7.getSubject()
            boolean r2 = r7 instanceof io.ktor.utils.io.ByteReadChannel
            if (r2 == 0) goto L47
            io.ktor.utils.io.ByteReadChannel r7 = (io.ktor.utils.io.ByteReadChannel) r7
            goto L48
        L47:
            r7 = 0
        L48:
            if (r7 != 0) goto L4d
            Y8.t r5 = Y8.t.f7040a
            return r5
        L4d:
            io.ktor.util.pipeline.PipelineContext r2 = r5.getContext()
            java.lang.Object r2 = r2.getContext()
            io.ktor.server.application.PipelineCall r2 = (io.ktor.server.application.PipelineCall) r2
            io.ktor.util.reflect.TypeInfo r2 = io.ktor.server.application.PipelineCallKt.getReceiveType(r2)
            io.ktor.server.application.TransformBodyContext r4 = new io.ktor.server.application.TransformBodyContext
            r4.<init>(r2)
            io.ktor.util.pipeline.PipelineContext r5 = r5.getContext()
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r7 = r6.invoke(r4, r7, r0)
            if (r7 != r1) goto L6f
            return r1
        L6f:
            r5.setSubject(r7)
            Y8.t r5 = Y8.t.f7040a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.server.application.OnCallReceiveContext.transformBody(p9.q, e9.c):java.lang.Object");
    }
}
