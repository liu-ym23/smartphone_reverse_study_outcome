package io.ktor.server.engine;

import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import io.ktor.http.HttpStatusCode;
import io.ktor.server.application.ApplicationCall;
import io.ktor.server.application.ApplicationEnvironment;
import io.ktor.server.application.PipelineCall;
import io.ktor.server.config.ApplicationConfig;
import io.ktor.server.engine.internal.ApplicationUtilsJvmKt;
import io.ktor.server.logging.LoggingKt;
import io.ktor.server.plugins.BadRequestException;
import io.ktor.server.plugins.NotFoundException;
import io.ktor.server.plugins.PayloadTooLargeException;
import io.ktor.server.plugins.UnsupportedMediaTypeException;
import io.ktor.util.cio.ChannelIOException;
import io.ktor.util.logging.LoggerKt;
import io.ktor.util.pipeline.PipelineContext;
import java.io.IOException;
import java.nio.channels.ClosedChannelException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeoutException;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.TimeoutCancellationException;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001d\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006\u001a \u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0086@¢\u0006\u0004\b\f\u0010\r\u001a \u0010\u000e\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0086@¢\u0006\u0004\b\u000e\u0010\r\u001a\u0017\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u000f\u001a\u00020\t¢\u0006\u0004\b\u0011\u0010\u0012\u001a \u0010\u0014\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0010H\u0082@¢\u0006\u0004\b\u0014\u0010\u0015\u001a#\u0010\u0017\u001a\u00020\u000b*\u00020\u00162\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lio/ktor/server/config/ApplicationConfig;", "config", "", "developmentMode", "Lio/ktor/server/engine/EnginePipeline;", "defaultEnginePipeline", "(Lio/ktor/server/config/ApplicationConfig;Z)Lio/ktor/server/engine/EnginePipeline;", "Lio/ktor/server/application/ApplicationCall;", "call", "", "error", "LY8/t;", "handleFailure", "(Lio/ktor/server/application/ApplicationCall;Ljava/lang/Throwable;Le9/c;)Ljava/lang/Object;", "logError", "cause", "Lio/ktor/http/HttpStatusCode;", "defaultExceptionStatusCode", "(Ljava/lang/Throwable;)Lio/ktor/http/HttpStatusCode;", "statusCode", "tryRespondError", "(Lio/ktor/server/application/ApplicationCall;Lio/ktor/http/HttpStatusCode;Le9/c;)Ljava/lang/Object;", "Lio/ktor/server/application/ApplicationEnvironment;", "logFailure", "(Lio/ktor/server/application/ApplicationEnvironment;Lio/ktor/server/application/ApplicationCall;Ljava/lang/Throwable;)V", "ktor-server-core"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DefaultEnginePipelineKt {

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lio/ktor/util/pipeline/PipelineContext;", "LY8/t;", "Lio/ktor/server/application/PipelineCall;", "it", "<anonymous>", "(Lio/ktor/util/pipeline/PipelineContext;V)V"}, k = 3, mv = {2, 1, 0})
    @InterfaceC4112d(c = "io.ktor.server.engine.DefaultEnginePipelineKt$defaultEnginePipeline$1", f = "DefaultEnginePipeline.kt", l = {134, 49, 37, 49, 43, 45, 49, 49}, m = "invokeSuspend")
    /* renamed from: io.ktor.server.engine.DefaultEnginePipelineKt$defaultEnginePipeline$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p9.q<PipelineContext<Y8.t, PipelineCall>, Y8.t, InterfaceC4014c<? super Y8.t>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"LY8/t;", "<anonymous>", "()V"}, k = 3, mv = {2, 1, 0})
        @InterfaceC4112d(c = "io.ktor.server.engine.DefaultEnginePipelineKt$defaultEnginePipeline$1$1", f = "DefaultEnginePipeline.kt", l = {}, m = "invokeSuspend")
        /* renamed from: io.ktor.server.engine.DefaultEnginePipelineKt$defaultEnginePipeline$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C04121 extends SuspendLambda implements InterfaceC5074l<InterfaceC4014c<? super Y8.t>, Object> {
            final /* synthetic */ PipelineContext<Y8.t, PipelineCall> $$this$intercept;
            final /* synthetic */ ChannelIOException $error;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C04121(PipelineContext<Y8.t, PipelineCall> pipelineContext, ChannelIOException channelIOException, InterfaceC4014c<? super C04121> interfaceC4014c) {
                super(1, interfaceC4014c);
                this.$$this$intercept = pipelineContext;
                this.$error = channelIOException;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final InterfaceC4014c<Y8.t> create(InterfaceC4014c<?> interfaceC4014c) {
                return new C04121(this.$$this$intercept, this.$error, interfaceC4014c);
            }

            @Override // p9.InterfaceC5074l
            public final Object invoke(InterfaceC4014c<? super Y8.t> interfaceC4014c) {
                return ((C04121) create(interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                C4063a.g();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
                DefaultEnginePipelineKt.logFailure(this.$$this$intercept.getContext().getApplication().getEnvironment(), this.$$this$intercept.getContext(), this.$error);
                return Y8.t.f7040a;
            }
        }

        public AnonymousClass1(InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(3, interfaceC4014c);
        }

        @Override // p9.q
        public final Object invoke(PipelineContext<Y8.t, PipelineCall> pipelineContext, Y8.t tVar, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(interfaceC4014c);
            anonymousClass1.L$0 = pipelineContext;
            return anonymousClass1.invokeSuspend(Y8.t.f7040a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:33:0x009b, code lost:
        
            if (io.ktor.utils.io.ByteReadChannelOperationsKt.discard$default(r3, 0, r9, 1, null) != r1) goto L66;
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x00fd, code lost:
        
            if (io.ktor.utils.io.ByteReadChannelOperationsKt.discard$default(r9, 0, r5, 1, null) == r1) goto L71;
         */
        /* JADX WARN: Code restructure failed: missing block: B:56:0x0141, code lost:
        
            if (io.ktor.utils.io.ByteReadChannelOperationsKt.discard$default(r9, 0, r5, 1, null) != r1) goto L66;
         */
        /* JADX WARN: Code restructure failed: missing block: B:61:0x0163, code lost:
        
            if (io.ktor.utils.io.ByteReadChannelOperationsKt.discard$default(r2, 0, r5, 1, null) == r1) goto L62;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:41:0x00bd A[Catch: all -> 0x00ca, TryCatch #4 {all -> 0x00ca, blocks: (B:39:0x00a7, B:41:0x00bd, B:46:0x00ce, B:52:0x0100), top: B:67:0x0007 }] */
        /* JADX WARN: Removed duplicated region for block: B:46:0x00ce A[Catch: all -> 0x00ca, TRY_LEAVE, TryCatch #4 {all -> 0x00ca, blocks: (B:39:0x00a7, B:41:0x00bd, B:46:0x00ce, B:52:0x0100), top: B:67:0x0007 }] */
        /* JADX WARN: Removed duplicated region for block: B:49:0x00e1 A[Catch: all -> 0x0144, PHI: r3 r5
          0x00e1: PHI (r3v18 io.ktor.util.pipeline.PipelineContext) = 
          (r3v25 io.ktor.util.pipeline.PipelineContext)
          (r3v26 io.ktor.util.pipeline.PipelineContext)
          (r3v27 io.ktor.util.pipeline.PipelineContext)
         binds: [B:47:0x00dd, B:42:0x00c6, B:17:0x0035] A[DONT_GENERATE, DONT_INLINE]
          0x00e1: PHI (r5v12 io.ktor.server.engine.DefaultEnginePipelineKt$defaultEnginePipeline$1) = 
          (r5v5 io.ktor.server.engine.DefaultEnginePipelineKt$defaultEnginePipeline$1)
          (r5v5 io.ktor.server.engine.DefaultEnginePipelineKt$defaultEnginePipeline$1)
          (r5v13 io.ktor.server.engine.DefaultEnginePipelineKt$defaultEnginePipeline$1)
         binds: [B:47:0x00dd, B:42:0x00c6, B:17:0x0035] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x0144, blocks: (B:9:0x001b, B:49:0x00e1, B:55:0x0125, B:32:0x007f), top: B:67:0x0007 }] */
        /* JADX WARN: Removed duplicated region for block: B:55:0x0125 A[Catch: all -> 0x0144, PHI: r3 r5
          0x0125: PHI (r3v11 io.ktor.util.pipeline.PipelineContext) = (r3v31 io.ktor.util.pipeline.PipelineContext), (r3v32 io.ktor.util.pipeline.PipelineContext) binds: [B:53:0x0122, B:20:0x0040] A[DONT_GENERATE, DONT_INLINE]
          0x0125: PHI (r5v9 io.ktor.server.engine.DefaultEnginePipelineKt$defaultEnginePipeline$1) = 
          (r5v6 io.ktor.server.engine.DefaultEnginePipelineKt$defaultEnginePipeline$1)
          (r5v10 io.ktor.server.engine.DefaultEnginePipelineKt$defaultEnginePipeline$1)
         binds: [B:53:0x0122, B:20:0x0040] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x0144, blocks: (B:9:0x001b, B:49:0x00e1, B:55:0x0125, B:32:0x007f), top: B:67:0x0007 }] */
        /* JADX WARN: Type inference failed for: r3v12 */
        /* JADX WARN: Type inference failed for: r3v17, types: [io.ktor.util.pipeline.PipelineContext] */
        /* JADX WARN: Type inference failed for: r3v19 */
        /* JADX WARN: Type inference failed for: r3v28 */
        /* JADX WARN: Type inference failed for: r3v29 */
        /* JADX WARN: Type inference failed for: r3v30 */
        /* JADX WARN: Type inference failed for: r9v0, types: [e9.c, io.ktor.server.engine.DefaultEnginePipelineKt$defaultEnginePipeline$1] */
        /* JADX WARN: Type inference failed for: r9v35 */
        /* JADX WARN: Type inference failed for: r9v36 */
        /* JADX WARN: Type inference failed for: r9v4, types: [java.lang.Throwable] */
        /* JADX WARN: Type inference failed for: r9v6, types: [java.lang.Throwable] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r10) throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 382
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.server.engine.DefaultEnginePipelineKt.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @InterfaceC4112d(c = "io.ktor.server.engine.DefaultEnginePipelineKt", f = "DefaultEnginePipeline.kt", l = {64, 65}, m = "handleFailure")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: io.ktor.server.engine.DefaultEnginePipelineKt$handleFailure$1, reason: invalid class name and case insensitive filesystem */
    public static final class C43441 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C43441(InterfaceC4014c<? super C43441> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DefaultEnginePipelineKt.handleFailure(null, null, this);
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"LY8/t;", "<anonymous>", "()V"}, k = 3, mv = {2, 1, 0})
    @InterfaceC4112d(c = "io.ktor.server.engine.DefaultEnginePipelineKt$logError$2", f = "DefaultEnginePipeline.kt", l = {}, m = "invokeSuspend")
    /* renamed from: io.ktor.server.engine.DefaultEnginePipelineKt$logError$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements InterfaceC5074l<InterfaceC4014c<? super Y8.t>, Object> {
        final /* synthetic */ ApplicationCall $call;
        final /* synthetic */ Throwable $error;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(ApplicationCall applicationCall, Throwable th, InterfaceC4014c<? super AnonymousClass2> interfaceC4014c) {
            super(1, interfaceC4014c);
            this.$call = applicationCall;
            this.$error = th;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(InterfaceC4014c<?> interfaceC4014c) {
            return new AnonymousClass2(this.$call, this.$error, interfaceC4014c);
        }

        @Override // p9.InterfaceC5074l
        public final Object invoke(InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return ((AnonymousClass2) create(interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            C4063a.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            DefaultEnginePipelineKt.logFailure(this.$call.getApplication().getEnvironment(), this.$call, this.$error);
            return Y8.t.f7040a;
        }
    }

    @InterfaceC4112d(c = "io.ktor.server.engine.DefaultEnginePipelineKt", f = "DefaultEnginePipeline.kt", l = {133}, m = "tryRespondError")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: io.ktor.server.engine.DefaultEnginePipelineKt$tryRespondError$1, reason: invalid class name and case insensitive filesystem */
    public static final class C43451 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public C43451(InterfaceC4014c<? super C43451> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DefaultEnginePipelineKt.tryRespondError(null, null, this);
        }
    }

    public static final EnginePipeline defaultEnginePipeline(ApplicationConfig config, boolean z10) {
        kotlin.jvm.internal.p.i(config, "config");
        EnginePipeline enginePipeline = new EnginePipeline(z10);
        ApplicationUtilsJvmKt.configureShutdownUrl(config, enginePipeline);
        enginePipeline.intercept(EnginePipeline.INSTANCE.getCall(), new AnonymousClass1(null));
        return enginePipeline;
    }

    public static final HttpStatusCode defaultExceptionStatusCode(Throwable cause) {
        kotlin.jvm.internal.p.i(cause, "cause");
        if (cause instanceof BadRequestException) {
            return HttpStatusCode.INSTANCE.getBadRequest();
        }
        if (cause instanceof NotFoundException) {
            return HttpStatusCode.INSTANCE.getNotFound();
        }
        if (cause instanceof UnsupportedMediaTypeException) {
            return HttpStatusCode.INSTANCE.getUnsupportedMediaType();
        }
        if (cause instanceof PayloadTooLargeException) {
            return HttpStatusCode.INSTANCE.getPayloadTooLarge();
        }
        if ((cause instanceof TimeoutException) || (cause instanceof TimeoutCancellationException)) {
            return HttpStatusCode.INSTANCE.getGatewayTimeout();
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0068, code lost:
    
        if (tryRespondError(r5, r6, r0) == r1) goto L24;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object handleFailure(io.ktor.server.application.ApplicationCall r5, java.lang.Throwable r6, e9.InterfaceC4014c<? super Y8.t> r7) throws java.lang.Throwable {
        /*
            boolean r0 = r7 instanceof io.ktor.server.engine.DefaultEnginePipelineKt.C43441
            if (r0 == 0) goto L13
            r0 = r7
            io.ktor.server.engine.DefaultEnginePipelineKt$handleFailure$1 r0 = (io.ktor.server.engine.DefaultEnginePipelineKt.C43441) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.server.engine.DefaultEnginePipelineKt$handleFailure$1 r0 = new io.ktor.server.engine.DefaultEnginePipelineKt$handleFailure$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L41
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.C4849c.b(r7)
            goto L6b
        L2c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L34:
            java.lang.Object r5 = r0.L$1
            r6 = r5
            java.lang.Throwable r6 = (java.lang.Throwable) r6
            java.lang.Object r5 = r0.L$0
            io.ktor.server.application.ApplicationCall r5 = (io.ktor.server.application.ApplicationCall) r5
            kotlin.C4849c.b(r7)
            goto L51
        L41:
            kotlin.C4849c.b(r7)
            r0.L$0 = r5
            r0.L$1 = r6
            r0.label = r4
            java.lang.Object r7 = logError(r5, r6, r0)
            if (r7 != r1) goto L51
            goto L6a
        L51:
            io.ktor.http.HttpStatusCode r6 = defaultExceptionStatusCode(r6)
            if (r6 != 0) goto L5d
            io.ktor.http.HttpStatusCode$Companion r6 = io.ktor.http.HttpStatusCode.INSTANCE
            io.ktor.http.HttpStatusCode r6 = r6.getInternalServerError()
        L5d:
            r7 = 0
            r0.L$0 = r7
            r0.L$1 = r7
            r0.label = r3
            java.lang.Object r5 = tryRespondError(r5, r6, r0)
            if (r5 != r1) goto L6b
        L6a:
            return r1
        L6b:
            Y8.t r5 = Y8.t.f7040a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.server.engine.DefaultEnginePipelineKt.handleFailure(io.ktor.server.application.ApplicationCall, java.lang.Throwable, e9.c):java.lang.Object");
    }

    public static final Object logError(ApplicationCall applicationCall, Throwable th, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        Object objWithMDCBlock = LoggingKt.getMdcProvider(applicationCall.getApplication()).withMDCBlock(applicationCall, new AnonymousClass2(applicationCall, th, null), interfaceC4014c);
        return objWithMDCBlock == C4063a.g() ? objWithMDCBlock : Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void logFailure(ApplicationEnvironment applicationEnvironment, ApplicationCall applicationCall, Throwable th) {
        String logString;
        try {
            Object status = applicationCall.getResponse().getStatus();
            if (status == null) {
                status = "Unhandled";
            }
            try {
                try {
                    logString = LoggingKt.toLogString(applicationCall.getRequest());
                } catch (OutOfMemoryError unused) {
                    ApplicationUtilsJvmKt.printError("OutOfMemoryError: ");
                    ApplicationUtilsJvmKt.printError(th.getMessage());
                    ApplicationUtilsJvmKt.printError("\n");
                    return;
                }
            } catch (Throwable th2) {
                logString = "(request error: " + th2 + ')';
            }
            String str = status + ": " + logString + ". Exception " + kotlin.jvm.internal.t.b(th.getClass()) + ": " + th.getMessage();
            if (!(th instanceof CancellationException) && !(th instanceof ClosedChannelException) && !(th instanceof ChannelIOException) && !(th instanceof IOException) && !(th instanceof BadRequestException) && !(th instanceof NotFoundException) && !(th instanceof PayloadTooLargeException) && !(th instanceof UnsupportedMediaTypeException)) {
                applicationEnvironment.getLog().error(status + ": " + logString, th);
                return;
            }
            applicationEnvironment.getLog().debug(str, th);
        } catch (OutOfMemoryError unused2) {
            LoggerKt.error(applicationEnvironment.getLog(), th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object tryRespondError(io.ktor.server.application.ApplicationCall r5, io.ktor.http.HttpStatusCode r6, e9.InterfaceC4014c<? super Y8.t> r7) throws java.lang.Throwable {
        /*
            java.lang.Class<io.ktor.http.HttpStatusCode> r0 = io.ktor.http.HttpStatusCode.class
            boolean r1 = r7 instanceof io.ktor.server.engine.DefaultEnginePipelineKt.C43451
            if (r1 == 0) goto L15
            r1 = r7
            io.ktor.server.engine.DefaultEnginePipelineKt$tryRespondError$1 r1 = (io.ktor.server.engine.DefaultEnginePipelineKt.C43451) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L15
            int r2 = r2 - r3
            r1.label = r2
            goto L1a
        L15:
            io.ktor.server.engine.DefaultEnginePipelineKt$tryRespondError$1 r1 = new io.ktor.server.engine.DefaultEnginePipelineKt$tryRespondError$1
            r1.<init>(r7)
        L1a:
            java.lang.Object r7 = r1.result
            java.lang.Object r2 = f9.C4063a.g()
            int r3 = r1.label
            r4 = 1
            if (r3 == 0) goto L33
            if (r3 != r4) goto L2b
            kotlin.C4849c.b(r7)     // Catch: io.ktor.server.engine.BaseApplicationResponse.ResponseAlreadySentException -> L4e
            goto L4e
        L2b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L33:
            kotlin.C4849c.b(r7)
            w9.d r7 = kotlin.jvm.internal.t.b(r0)     // Catch: io.ktor.server.engine.BaseApplicationResponse.ResponseAlreadySentException -> L4e
            w9.n r0 = kotlin.jvm.internal.t.m(r0)     // Catch: java.lang.Throwable -> L3f
            goto L40
        L3f:
            r0 = 0
        L40:
            io.ktor.util.reflect.TypeInfo r3 = new io.ktor.util.reflect.TypeInfo     // Catch: io.ktor.server.engine.BaseApplicationResponse.ResponseAlreadySentException -> L4e
            r3.<init>(r7, r0)     // Catch: io.ktor.server.engine.BaseApplicationResponse.ResponseAlreadySentException -> L4e
            r1.label = r4     // Catch: io.ktor.server.engine.BaseApplicationResponse.ResponseAlreadySentException -> L4e
            java.lang.Object r5 = r5.respond(r6, r3, r1)     // Catch: io.ktor.server.engine.BaseApplicationResponse.ResponseAlreadySentException -> L4e
            if (r5 != r2) goto L4e
            return r2
        L4e:
            Y8.t r5 = Y8.t.f7040a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.server.engine.DefaultEnginePipelineKt.tryRespondError(io.ktor.server.application.ApplicationCall, io.ktor.http.HttpStatusCode, e9.c):java.lang.Object");
    }
}
