package io.ktor.server.engine;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import io.ktor.server.application.PipelineCall;
import io.ktor.util.pipeline.PipelineContext;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lio/ktor/util/pipeline/PipelineContext;", "LY8/t;", "Lio/ktor/server/application/PipelineCall;", "it", "<anonymous>", "(Lio/ktor/util/pipeline/PipelineContext;V)V"}, k = 3, mv = {2, 1, 0})
@InterfaceC4112d(c = "io.ktor.server.engine.BaseApplicationResponse$Companion$setupFallbackResponse$1", f = "BaseApplicationResponse.kt", l = {349, 366}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class BaseApplicationResponse$Companion$setupFallbackResponse$1 extends SuspendLambda implements p9.q<PipelineContext<Y8.t, PipelineCall>, Y8.t, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ boolean $inDevMode;
    final /* synthetic */ vc.c $logger;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseApplicationResponse$Companion$setupFallbackResponse$1(vc.c cVar, boolean z10, InterfaceC4014c<? super BaseApplicationResponse$Companion$setupFallbackResponse$1> interfaceC4014c) {
        super(3, interfaceC4014c);
        this.$logger = cVar;
        this.$inDevMode = z10;
    }

    @Override // p9.q
    public final Object invoke(PipelineContext<Y8.t, PipelineCall> pipelineContext, Y8.t tVar, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        BaseApplicationResponse$Companion$setupFallbackResponse$1 baseApplicationResponse$Companion$setupFallbackResponse$1 = new BaseApplicationResponse$Companion$setupFallbackResponse$1(this.$logger, this.$inDevMode, interfaceC4014c);
        baseApplicationResponse$Companion$setupFallbackResponse$1.L$0 = pipelineContext;
        return baseApplicationResponse$Companion$setupFallbackResponse$1.invokeSuspend(Y8.t.f7040a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0036, code lost:
    
        if (r6 == r0) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00b0, code lost:
    
        if (r3.respondOutgoingContent(r4, r6) == r0) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00b2, code lost:
    
        return r0;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [io.ktor.util.pipeline.PipelineContext] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r3v10, types: [io.ktor.server.engine.BaseApplicationResponse] */
    /* JADX WARN: Type inference failed for: r3v15, types: [io.ktor.server.engine.BaseApplicationResponse] */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Type inference failed for: r6v0, types: [e9.c, io.ktor.server.engine.BaseApplicationResponse$Companion$setupFallbackResponse$1] */
    /* JADX WARN: Type inference failed for: r6v1, types: [e9.c, io.ktor.server.engine.BaseApplicationResponse$Companion$setupFallbackResponse$1] */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r6v9 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) throws java.lang.Throwable {
        /*
            r6 = this;
            java.lang.Object r0 = f9.C4063a.g()
            int r1 = r6.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L26
            if (r1 == r3) goto L1b
            if (r1 != r2) goto L13
            kotlin.C4849c.b(r7)
            goto Lb3
        L13:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L1b:
            java.lang.Object r1 = r6.L$0
            io.ktor.util.pipeline.PipelineContext r1 = (io.ktor.util.pipeline.PipelineContext) r1
            kotlin.C4849c.b(r7)     // Catch: java.lang.Throwable -> L24
            goto Lb3
        L24:
            r7 = move-exception
            goto L3a
        L26:
            kotlin.C4849c.b(r7)
            java.lang.Object r7 = r6.L$0
            r1 = r7
            io.ktor.util.pipeline.PipelineContext r1 = (io.ktor.util.pipeline.PipelineContext) r1
            r6.L$0 = r1     // Catch: java.lang.Throwable -> L24
            r6.label = r3     // Catch: java.lang.Throwable -> L24
            java.lang.Object r6 = r1.proceed(r6)     // Catch: java.lang.Throwable -> L24
            if (r6 != r0) goto Lb3
            goto Lb2
        L3a:
            java.lang.Object r3 = r1.getContext()
            io.ktor.server.application.PipelineCall r3 = (io.ktor.server.application.PipelineCall) r3
            boolean r3 = io.ktor.server.application.PipelineCallKt.isHandled(r3)
            if (r3 == 0) goto L49
            Y8.t r6 = Y8.t.f7040a
            return r6
        L49:
            vc.c r3 = r6.$logger
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Unhandled server error: \""
            r4.append(r5)
            java.lang.String r5 = r7.getMessage()
            r4.append(r5)
            r5 = 34
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            r3.error(r4, r7)
            java.lang.Object r3 = r1.getContext()
            io.ktor.server.application.PipelineCall r3 = (io.ktor.server.application.PipelineCall) r3
            io.ktor.server.response.PipelineResponse r3 = r3.getResponse()
            boolean r4 = r3 instanceof io.ktor.server.engine.BaseApplicationResponse
            r5 = 0
            if (r4 == 0) goto L7a
            io.ktor.server.engine.BaseApplicationResponse r3 = (io.ktor.server.engine.BaseApplicationResponse) r3
            goto L7b
        L7a:
            r3 = r5
        L7b:
            if (r3 != 0) goto L93
            java.lang.Object r3 = r1.getContext()
            io.ktor.server.application.PipelineCall r3 = (io.ktor.server.application.PipelineCall) r3
            io.ktor.util.Attributes r3 = r3.getAttributes()
            io.ktor.server.engine.BaseApplicationResponse$Companion r4 = io.ktor.server.engine.BaseApplicationResponse.INSTANCE
            io.ktor.util.AttributeKey r4 = r4.getEngineResponseAttributeKey()
            java.lang.Object r3 = r3.get(r4)
            io.ktor.server.engine.BaseApplicationResponse r3 = (io.ktor.server.engine.BaseApplicationResponse) r3
        L93:
            boolean r4 = r6.$inDevMode
            if (r4 == 0) goto La3
            io.ktor.server.engine.internal.ExceptionPageContent r4 = new io.ktor.server.engine.internal.ExceptionPageContent
            java.lang.Object r1 = r1.getContext()
            io.ktor.server.application.PipelineCall r1 = (io.ktor.server.application.PipelineCall) r1
            r4.<init>(r1, r7)
            goto La8
        La3:
            io.ktor.server.engine.BaseApplicationResponse$Companion$setupFallbackResponse$1$content$1 r4 = new io.ktor.server.engine.BaseApplicationResponse$Companion$setupFallbackResponse$1$content$1
            r4.<init>()
        La8:
            r6.L$0 = r5
            r6.label = r2
            java.lang.Object r6 = r3.respondOutgoingContent(r4, r6)
            if (r6 != r0) goto Lb3
        Lb2:
            return r0
        Lb3:
            Y8.t r6 = Y8.t.f7040a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.server.engine.BaseApplicationResponse$Companion$setupFallbackResponse$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
