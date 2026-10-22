package io.ktor.server.engine;

import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import io.ktor.http.HttpStatusCode;
import io.ktor.http.content.OutgoingContent;
import io.ktor.server.application.Application;
import io.ktor.server.application.ApplicationCallPipeline;
import io.ktor.server.application.PipelineCall;
import io.ktor.server.application.PipelineCallKt;
import io.ktor.server.http.content.HttpStatusCodeContent;
import io.ktor.server.response.ApplicationSendPipeline;
import io.ktor.server.routing.RoutingRootKt;
import io.ktor.util.pipeline.InvalidPhaseException;
import io.ktor.util.pipeline.Phase;
import io.ktor.util.pipeline.PipelineContext;
import io.ktor.util.reflect.TypeInfo;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import w9.InterfaceC5745d;
import w9.InterfaceC5755n;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a \u0010\u0003\u001a\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000H\u0082@¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0013\u0010\u0006\u001a\u00020\u0001*\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0013\u0010\b\u001a\u00020\u0001*\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\u0007¨\u0006\t"}, d2 = {"Lio/ktor/util/pipeline/PipelineContext;", "LY8/t;", "Lio/ktor/server/application/PipelineCall;", "verifyHostHeader", "(Lio/ktor/util/pipeline/PipelineContext;Le9/c;)Ljava/lang/Object;", "Lio/ktor/server/application/Application;", "installDefaultInterceptors", "(Lio/ktor/server/application/Application;)V", "installDefaultTransformationChecker", "ktor-server-core"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class BaseApplicationEngineKt {

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lio/ktor/util/pipeline/PipelineContext;", "LY8/t;", "Lio/ktor/server/application/PipelineCall;", "it", "<anonymous>", "(Lio/ktor/util/pipeline/PipelineContext;V)V"}, k = 3, mv = {2, 1, 0})
    @InterfaceC4112d(c = "io.ktor.server.engine.BaseApplicationEngineKt$installDefaultInterceptors$1", f = "BaseApplicationEngine.kt", l = {138}, m = "invokeSuspend")
    /* renamed from: io.ktor.server.engine.BaseApplicationEngineKt$installDefaultInterceptors$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p9.q<PipelineContext<Y8.t, PipelineCall>, Y8.t, InterfaceC4014c<? super Y8.t>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        public AnonymousClass1(InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(3, interfaceC4014c);
        }

        @Override // p9.q
        public final Object invoke(PipelineContext<Y8.t, PipelineCall> pipelineContext, Y8.t tVar, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(interfaceC4014c);
            anonymousClass1.L$0 = pipelineContext;
            return anonymousClass1.invokeSuspend(Y8.t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            InterfaceC5755n interfaceC5755nM;
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 == 0) {
                C4849c.b(obj);
                PipelineContext pipelineContext = (PipelineContext) this.L$0;
                if (PipelineCallKt.isHandled((PipelineCall) pipelineContext.getContext())) {
                    return Y8.t.f7040a;
                }
                HttpStatusCode httpStatusCodeStatus = ((PipelineCall) pipelineContext.getContext()).getResponse().getStatus();
                if (httpStatusCodeStatus == null && (httpStatusCodeStatus = (HttpStatusCode) ((PipelineCall) pipelineContext.getContext()).getAttributes().getOrNull(RoutingRootKt.getRoutingFailureStatusCode())) == null) {
                    httpStatusCodeStatus = HttpStatusCode.INSTANCE.getNotFound();
                }
                PipelineCall pipelineCall = (PipelineCall) pipelineContext.getContext();
                InterfaceC5745d interfaceC5745dB = kotlin.jvm.internal.t.b(HttpStatusCode.class);
                try {
                    interfaceC5755nM = kotlin.jvm.internal.t.m(HttpStatusCode.class);
                } catch (Throwable unused) {
                    interfaceC5755nM = null;
                }
                TypeInfo typeInfo = new TypeInfo(interfaceC5745dB, interfaceC5755nM);
                this.label = 1;
                if (pipelineCall.respond(httpStatusCodeStatus, typeInfo, this) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
            }
            return Y8.t.f7040a;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lio/ktor/util/pipeline/PipelineContext;", "LY8/t;", "Lio/ktor/server/application/PipelineCall;", "it", "<anonymous>", "(Lio/ktor/util/pipeline/PipelineContext;V)V"}, k = 3, mv = {2, 1, 0})
    @InterfaceC4112d(c = "io.ktor.server.engine.BaseApplicationEngineKt$installDefaultInterceptors$2", f = "BaseApplicationEngine.kt", l = {111}, m = "invokeSuspend")
    /* renamed from: io.ktor.server.engine.BaseApplicationEngineKt$installDefaultInterceptors$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements p9.q<PipelineContext<Y8.t, PipelineCall>, Y8.t, InterfaceC4014c<? super Y8.t>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        public AnonymousClass2(InterfaceC4014c<? super AnonymousClass2> interfaceC4014c) {
            super(3, interfaceC4014c);
        }

        @Override // p9.q
        public final Object invoke(PipelineContext<Y8.t, PipelineCall> pipelineContext, Y8.t tVar, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(interfaceC4014c);
            anonymousClass2.L$0 = pipelineContext;
            return anonymousClass2.invokeSuspend(Y8.t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 == 0) {
                C4849c.b(obj);
                PipelineContext pipelineContext = (PipelineContext) this.L$0;
                this.label = 1;
                if (BaseApplicationEngineKt.verifyHostHeader(pipelineContext, this) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
            }
            return Y8.t.f7040a;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lio/ktor/util/pipeline/PipelineContext;", "LY8/t;", "Lio/ktor/server/application/PipelineCall;", "it", "<anonymous>", "(Lio/ktor/util/pipeline/PipelineContext;V)V"}, k = 3, mv = {2, 1, 0})
    @InterfaceC4112d(c = "io.ktor.server.engine.BaseApplicationEngineKt$installDefaultTransformationChecker$1", f = "BaseApplicationEngine.kt", l = {119, 135}, m = "invokeSuspend")
    /* renamed from: io.ktor.server.engine.BaseApplicationEngineKt$installDefaultTransformationChecker$1, reason: invalid class name and case insensitive filesystem */
    public static final class C43391 extends SuspendLambda implements p9.q<PipelineContext<Y8.t, PipelineCall>, Y8.t, InterfaceC4014c<? super Y8.t>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        public C43391(InterfaceC4014c<? super C43391> interfaceC4014c) {
            super(3, interfaceC4014c);
        }

        @Override // p9.q
        public final Object invoke(PipelineContext<Y8.t, PipelineCall> pipelineContext, Y8.t tVar, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            C43391 c43391 = new C43391(interfaceC4014c);
            c43391.L$0 = pipelineContext;
            return c43391.invokeSuspend(Y8.t.f7040a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0032, code lost:
        
            if (r7 == r0) goto L22;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x005b, code lost:
        
            if (r8.respond(r1, r6, r7) != r0) goto L23;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x005d, code lost:
        
            return r0;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v0, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1, types: [io.ktor.util.pipeline.PipelineContext] */
        /* JADX WARN: Type inference failed for: r1v10 */
        /* JADX WARN: Type inference failed for: r1v6 */
        /* JADX WARN: Type inference failed for: r1v9 */
        /* JADX WARN: Type inference failed for: r7v0, types: [e9.c, io.ktor.server.engine.BaseApplicationEngineKt$installDefaultTransformationChecker$1] */
        /* JADX WARN: Type inference failed for: r7v1, types: [e9.c, io.ktor.server.engine.BaseApplicationEngineKt$installDefaultTransformationChecker$1] */
        /* JADX WARN: Type inference failed for: r7v5 */
        /* JADX WARN: Type inference failed for: r7v7 */
        /* JADX WARN: Type inference failed for: r7v8 */
        /* JADX WARN: Type inference failed for: r8v2, types: [io.ktor.server.application.ApplicationCall, io.ktor.server.application.PipelineCall] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) throws java.lang.Throwable {
            /*
                r7 = this;
                java.lang.Object r0 = f9.C4063a.g()
                int r1 = r7.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L22
                if (r1 == r3) goto L1a
                if (r1 != r2) goto L12
                kotlin.C4849c.b(r8)
                goto L5e
            L12:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r8)
                throw r7
            L1a:
                java.lang.Object r1 = r7.L$0
                io.ktor.util.pipeline.PipelineContext r1 = (io.ktor.util.pipeline.PipelineContext) r1
                kotlin.C4849c.b(r8)     // Catch: io.ktor.server.plugins.CannotTransformContentToTypeException -> L35
                goto L5e
            L22:
                kotlin.C4849c.b(r8)
                java.lang.Object r8 = r7.L$0
                r1 = r8
                io.ktor.util.pipeline.PipelineContext r1 = (io.ktor.util.pipeline.PipelineContext) r1
                r7.L$0 = r1     // Catch: io.ktor.server.plugins.CannotTransformContentToTypeException -> L35
                r7.label = r3     // Catch: io.ktor.server.plugins.CannotTransformContentToTypeException -> L35
                java.lang.Object r7 = r1.proceed(r7)     // Catch: io.ktor.server.plugins.CannotTransformContentToTypeException -> L35
                if (r7 != r0) goto L5e
                goto L5d
            L35:
                java.lang.Object r8 = r1.getContext()
                io.ktor.server.application.PipelineCall r8 = (io.ktor.server.application.PipelineCall) r8
                io.ktor.http.HttpStatusCode$Companion r1 = io.ktor.http.HttpStatusCode.INSTANCE
                io.ktor.http.HttpStatusCode r1 = r1.getUnsupportedMediaType()
                java.lang.Class<io.ktor.http.HttpStatusCode> r3 = io.ktor.http.HttpStatusCode.class
                w9.d r4 = kotlin.jvm.internal.t.b(r3)
                r5 = 0
                w9.n r3 = kotlin.jvm.internal.t.m(r3)     // Catch: java.lang.Throwable -> L4d
                goto L4e
            L4d:
                r3 = r5
            L4e:
                io.ktor.util.reflect.TypeInfo r6 = new io.ktor.util.reflect.TypeInfo
                r6.<init>(r4, r3)
                r7.L$0 = r5
                r7.label = r2
                java.lang.Object r7 = r8.respond(r1, r6, r7)
                if (r7 != r0) goto L5e
            L5d:
                return r0
            L5e:
                Y8.t r7 = Y8.t.f7040a
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.server.engine.BaseApplicationEngineKt.C43391.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lio/ktor/util/pipeline/PipelineContext;", "", "Lio/ktor/server/application/PipelineCall;", "subject", "LY8/t;", "<anonymous>", "(Lio/ktor/util/pipeline/PipelineContext;Ljava/lang/Object;)V"}, k = 3, mv = {2, 1, 0})
    @InterfaceC4112d(c = "io.ktor.server.engine.BaseApplicationEngineKt$installDefaultTransformationChecker$2", f = "BaseApplicationEngine.kt", l = {129}, m = "invokeSuspend")
    /* renamed from: io.ktor.server.engine.BaseApplicationEngineKt$installDefaultTransformationChecker$2, reason: invalid class name and case insensitive filesystem */
    public static final class C43402 extends SuspendLambda implements p9.q<PipelineContext<Object, PipelineCall>, Object, InterfaceC4014c<? super Y8.t>, Object> {
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        public C43402(InterfaceC4014c<? super C43402> interfaceC4014c) {
            super(3, interfaceC4014c);
        }

        @Override // p9.q
        public final Object invoke(PipelineContext<Object, PipelineCall> pipelineContext, Object obj, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            C43402 c43402 = new C43402(interfaceC4014c);
            c43402.L$0 = pipelineContext;
            c43402.L$1 = obj;
            return c43402.invokeSuspend(Y8.t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 == 0) {
                C4849c.b(obj);
                PipelineContext pipelineContext = (PipelineContext) this.L$0;
                if (!(this.L$1 instanceof OutgoingContent)) {
                    HttpStatusCodeContent httpStatusCodeContent = new HttpStatusCodeContent(HttpStatusCode.INSTANCE.getNotAcceptable());
                    this.L$0 = null;
                    this.label = 1;
                    if (pipelineContext.proceedWith(httpStatusCodeContent, this) == objG) {
                        return objG;
                    }
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
            }
            return Y8.t.f7040a;
        }
    }

    @InterfaceC4112d(c = "io.ktor.server.engine.BaseApplicationEngineKt", f = "BaseApplicationEngine.kt", l = {136}, m = "verifyHostHeader")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: io.ktor.server.engine.BaseApplicationEngineKt$verifyHostHeader$1, reason: invalid class name and case insensitive filesystem */
    public static final class C43411 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C43411(InterfaceC4014c<? super C43411> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return BaseApplicationEngineKt.verifyHostHeader(null, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void installDefaultInterceptors(Application application) {
        ApplicationCallPipeline.Companion companion = ApplicationCallPipeline.INSTANCE;
        application.intercept(companion.getFallback(), new AnonymousClass1(null));
        application.intercept(companion.getCall(), new AnonymousClass2(null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void installDefaultTransformationChecker(Application application) throws InvalidPhaseException {
        application.intercept(ApplicationCallPipeline.INSTANCE.getPlugins(), new C43391(null));
        Phase phase = new Phase("BodyTransformationCheckPostRender");
        application.getSendPipeline().insertPhaseAfter(ApplicationSendPipeline.INSTANCE.getRender(), phase);
        application.getSendPipeline().intercept(phase, new C43402(null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object verifyHostHeader(io.ktor.util.pipeline.PipelineContext<Y8.t, io.ktor.server.application.PipelineCall> r7, e9.InterfaceC4014c<? super Y8.t> r8) throws java.lang.Throwable {
        /*
            boolean r0 = r8 instanceof io.ktor.server.engine.BaseApplicationEngineKt.C43411
            if (r0 == 0) goto L13
            r0 = r8
            io.ktor.server.engine.BaseApplicationEngineKt$verifyHostHeader$1 r0 = (io.ktor.server.engine.BaseApplicationEngineKt.C43411) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.server.engine.BaseApplicationEngineKt$verifyHostHeader$1 r0 = new io.ktor.server.engine.BaseApplicationEngineKt$verifyHostHeader$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r7 = r0.L$0
            io.ktor.util.pipeline.PipelineContext r7 = (io.ktor.util.pipeline.PipelineContext) r7
            kotlin.C4849c.b(r8)
            goto L83
        L2d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L35:
            kotlin.C4849c.b(r8)
            java.lang.Object r8 = r7.getContext()
            io.ktor.server.application.PipelineCall r8 = (io.ktor.server.application.PipelineCall) r8
            io.ktor.server.request.PipelineRequest r8 = r8.getRequest()
            io.ktor.http.Headers r8 = r8.getHeaders()
            io.ktor.http.HttpHeaders r2 = io.ktor.http.HttpHeaders.INSTANCE
            java.lang.String r2 = r2.getHost()
            java.util.List r8 = r8.getAll(r2)
            if (r8 != 0) goto L55
            Y8.t r7 = Y8.t.f7040a
            return r7
        L55:
            int r8 = r8.size()
            if (r8 <= r3) goto L86
            java.lang.Object r8 = r7.getContext()
            io.ktor.server.application.PipelineCall r8 = (io.ktor.server.application.PipelineCall) r8
            io.ktor.http.HttpStatusCode$Companion r2 = io.ktor.http.HttpStatusCode.INSTANCE
            io.ktor.http.HttpStatusCode r2 = r2.getBadRequest()
            java.lang.Class<io.ktor.http.HttpStatusCode> r4 = io.ktor.http.HttpStatusCode.class
            w9.d r5 = kotlin.jvm.internal.t.b(r4)
            w9.n r4 = kotlin.jvm.internal.t.m(r4)     // Catch: java.lang.Throwable -> L72
            goto L73
        L72:
            r4 = 0
        L73:
            io.ktor.util.reflect.TypeInfo r6 = new io.ktor.util.reflect.TypeInfo
            r6.<init>(r5, r4)
            r0.L$0 = r7
            r0.label = r3
            java.lang.Object r8 = r8.respond(r2, r6, r0)
            if (r8 != r1) goto L83
            return r1
        L83:
            r7.finish()
        L86:
            Y8.t r7 = Y8.t.f7040a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.server.engine.BaseApplicationEngineKt.verifyHostHeader(io.ktor.util.pipeline.PipelineContext, e9.c):java.lang.Object");
    }
}
