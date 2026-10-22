package io.ktor.server.engine;

import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import io.ktor.http.BadContentTypeFormatException;
import io.ktor.http.HttpHeaders;
import io.ktor.http.auth.HttpAuthHeader;
import io.ktor.http.content.OutgoingContent;
import io.ktor.server.application.PipelineCall;
import io.ktor.server.plugins.BadRequestException;
import io.ktor.server.request.ApplicationReceivePipeline;
import io.ktor.server.response.ApplicationSendPipeline;
import io.ktor.util.logging.KtorSimpleLoggerJvmKt;
import io.ktor.util.pipeline.InvalidPhaseException;
import io.ktor.util.pipeline.Phase;
import io.ktor.util.pipeline.PipelineContext;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0004¢\u0006\u0004\b\u0002\u0010\u0005\u001a/\u0010\u000b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00062\u0006\u0010\b\u001a\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0080\bø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a \u0010\u0012\u001a\u00020\u0011*\u00020\r2\n\u0010\u0010\u001a\u00060\u000ej\u0002`\u000fH\u0080@¢\u0006\u0004\b\u0012\u0010\u0013\"\u001e\u0010\u0016\u001a\u00060\u0014j\u0002`\u00158\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001a"}, d2 = {"Lio/ktor/server/response/ApplicationSendPipeline;", "LY8/t;", "installDefaultTransformations", "(Lio/ktor/server/response/ApplicationSendPipeline;)V", "Lio/ktor/server/request/ApplicationReceivePipeline;", "(Lio/ktor/server/request/ApplicationReceivePipeline;)V", "R", "Lio/ktor/server/application/PipelineCall;", "call", "Lkotlin/Function0;", "block", "withContentType", "(Lio/ktor/server/application/PipelineCall;Lp9/a;)Ljava/lang/Object;", "Lio/ktor/utils/io/ByteReadChannel;", "Ljava/nio/charset/Charset;", "Lio/ktor/utils/io/charsets/Charset;", HttpAuthHeader.Parameters.Charset, "", "readText", "(Lio/ktor/utils/io/ByteReadChannel;Ljava/nio/charset/Charset;Le9/c;)Ljava/lang/Object;", "Lvc/c;", "Lio/ktor/util/logging/Logger;", "LOGGER", "Lvc/c;", "getLOGGER", "()Lvc/c;", "ktor-server-core"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DefaultTransformKt {
    private static final vc.c LOGGER = KtorSimpleLoggerJvmKt.KtorSimpleLogger("io.ktor.server.engine.DefaultTransform");

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lio/ktor/util/pipeline/PipelineContext;", "", "Lio/ktor/server/application/PipelineCall;", UxipConstants.f30680s, "LY8/t;", "<anonymous>", "(Lio/ktor/util/pipeline/PipelineContext;Ljava/lang/Object;)V"}, k = 3, mv = {2, 1, 0})
    @InterfaceC4112d(c = "io.ktor.server.engine.DefaultTransformKt$installDefaultTransformations$1", f = "DefaultTransform.kt", l = {31}, m = "invokeSuspend")
    /* renamed from: io.ktor.server.engine.DefaultTransformKt$installDefaultTransformations$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p9.q<PipelineContext<Object, PipelineCall>, Object, InterfaceC4014c<? super Y8.t>, Object> {
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        public AnonymousClass1(InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(3, interfaceC4014c);
        }

        @Override // p9.q
        public final Object invoke(PipelineContext<Object, PipelineCall> pipelineContext, Object obj, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(interfaceC4014c);
            anonymousClass1.L$0 = pipelineContext;
            anonymousClass1.L$1 = obj;
            return anonymousClass1.invokeSuspend(Y8.t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 == 0) {
                C4849c.b(obj);
                PipelineContext pipelineContext = (PipelineContext) this.L$0;
                OutgoingContent outgoingContentTransformDefaultContent = io.ktor.server.http.content.DefaultTransformKt.transformDefaultContent((PipelineCall) pipelineContext.getContext(), this.L$1);
                if (outgoingContentTransformDefaultContent != null) {
                    this.L$0 = null;
                    this.label = 1;
                    if (pipelineContext.proceedWith(outgoingContentTransformDefaultContent, this) == objG) {
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

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lio/ktor/util/pipeline/PipelineContext;", "", "Lio/ktor/server/application/PipelineCall;", "body", "LY8/t;", "<anonymous>", "(Lio/ktor/util/pipeline/PipelineContext;Ljava/lang/Object;)V"}, k = 3, mv = {2, 1, 0})
    @InterfaceC4112d(c = "io.ktor.server.engine.DefaultTransformKt$installDefaultTransformations$2", f = "DefaultTransform.kt", l = {46, 51, 57, 73, 77}, m = "invokeSuspend")
    /* renamed from: io.ktor.server.engine.DefaultTransformKt$installDefaultTransformations$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements p9.q<PipelineContext<Object, PipelineCall>, Object, InterfaceC4014c<? super Y8.t>, Object> {
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        Object L$2;
        int label;

        public AnonymousClass2(InterfaceC4014c<? super AnonymousClass2> interfaceC4014c) {
            super(3, interfaceC4014c);
        }

        @Override // p9.q
        public final Object invoke(PipelineContext<Object, PipelineCall> pipelineContext, Object obj, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(interfaceC4014c);
            anonymousClass2.L$0 = pipelineContext;
            anonymousClass2.L$1 = obj;
            return anonymousClass2.invokeSuspend(Y8.t.f7040a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:29:0x009e, code lost:
        
            if (r4 == r1) goto L62;
         */
        /* JADX WARN: Code restructure failed: missing block: B:56:0x016a, code lost:
        
            if (r4 == r1) goto L62;
         */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x016d, code lost:
        
            r5 = r2;
         */
        /* JADX WARN: Code restructure failed: missing block: B:61:0x01c4, code lost:
        
            if (r5.proceedWith(r4, r16) == r1) goto L62;
         */
        /* JADX WARN: Removed duplicated region for block: B:60:0x0172  */
        /* JADX WARN: Removed duplicated region for block: B:63:0x01c7  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r17) throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 532
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.server.engine.DefaultTransformKt.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lio/ktor/util/pipeline/PipelineContext;", "", "Lio/ktor/server/application/PipelineCall;", "body", "LY8/t;", "<anonymous>", "(Lio/ktor/util/pipeline/PipelineContext;Ljava/lang/Object;)V"}, k = 3, mv = {2, 1, 0})
    @InterfaceC4112d(c = "io.ktor.server.engine.DefaultTransformKt$installDefaultTransformations$3", f = "DefaultTransform.kt", l = {91, 92}, m = "invokeSuspend")
    /* renamed from: io.ktor.server.engine.DefaultTransformKt$installDefaultTransformations$3, reason: invalid class name */
    public static final class AnonymousClass3 extends SuspendLambda implements p9.q<PipelineContext<Object, PipelineCall>, Object, InterfaceC4014c<? super Y8.t>, Object> {
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        public AnonymousClass3(InterfaceC4014c<? super AnonymousClass3> interfaceC4014c) {
            super(3, interfaceC4014c);
        }

        @Override // p9.q
        public final Object invoke(PipelineContext<Object, PipelineCall> pipelineContext, Object obj, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(interfaceC4014c);
            anonymousClass3.L$0 = pipelineContext;
            anonymousClass3.L$1 = obj;
            return anonymousClass3.invokeSuspend(Y8.t.f7040a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:29:0x0085, code lost:
        
            if (r1.proceedWith((java.lang.String) r8, r7) == r0) goto L30;
         */
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
                r2 = 0
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L24
                if (r1 == r4) goto L1c
                if (r1 != r3) goto L14
                kotlin.C4849c.b(r8)
                goto L88
            L14:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r8)
                throw r7
            L1c:
                java.lang.Object r1 = r7.L$0
                io.ktor.util.pipeline.PipelineContext r1 = (io.ktor.util.pipeline.PipelineContext) r1
                kotlin.C4849c.b(r8)
                goto L7b
            L24:
                kotlin.C4849c.b(r8)
                java.lang.Object r8 = r7.L$0
                r1 = r8
                io.ktor.util.pipeline.PipelineContext r1 = (io.ktor.util.pipeline.PipelineContext) r1
                java.lang.Object r8 = r7.L$1
                boolean r5 = r8 instanceof io.ktor.utils.io.ByteReadChannel
                if (r5 == 0) goto L35
                io.ktor.utils.io.ByteReadChannel r8 = (io.ktor.utils.io.ByteReadChannel) r8
                goto L36
            L35:
                r8 = r2
            L36:
                if (r8 != 0) goto L3b
                Y8.t r7 = Y8.t.f7040a
                return r7
            L3b:
                java.lang.Object r5 = r1.getContext()
                io.ktor.server.application.PipelineCall r5 = (io.ktor.server.application.PipelineCall) r5
                io.ktor.util.reflect.TypeInfo r5 = io.ktor.server.application.PipelineCallKt.getReceiveType(r5)
                w9.d r5 = r5.getType()
                java.lang.Class<java.lang.String> r6 = java.lang.String.class
                w9.d r6 = kotlin.jvm.internal.t.b(r6)
                boolean r5 = kotlin.jvm.internal.p.d(r5, r6)
                if (r5 != 0) goto L58
                Y8.t r7 = Y8.t.f7040a
                return r7
            L58:
                java.lang.Object r5 = r1.getContext()
                io.ktor.server.application.PipelineCall r5 = (io.ktor.server.application.PipelineCall) r5
                java.lang.Object r6 = r1.getContext()     // Catch: io.ktor.http.BadContentTypeFormatException -> L8b
                io.ktor.server.application.PipelineCall r6 = (io.ktor.server.application.PipelineCall) r6     // Catch: io.ktor.http.BadContentTypeFormatException -> L8b
                io.ktor.server.request.PipelineRequest r6 = r6.getRequest()     // Catch: io.ktor.http.BadContentTypeFormatException -> L8b
                java.nio.charset.Charset r5 = io.ktor.server.request.ApplicationRequestPropertiesKt.contentCharset(r6)     // Catch: io.ktor.http.BadContentTypeFormatException -> L8b
                if (r5 != 0) goto L70
                java.nio.charset.Charset r5 = La.C0953c.UTF_8
            L70:
                r7.L$0 = r1
                r7.label = r4
                java.lang.Object r8 = io.ktor.server.engine.DefaultTransformKt.readText(r8, r5, r7)
                if (r8 != r0) goto L7b
                goto L87
            L7b:
                java.lang.String r8 = (java.lang.String) r8
                r7.L$0 = r2
                r7.label = r3
                java.lang.Object r7 = r1.proceedWith(r8, r7)
                if (r7 != r0) goto L88
            L87:
                return r0
            L88:
                Y8.t r7 = Y8.t.f7040a
                return r7
            L8b:
                r7 = move-exception
                io.ktor.server.plugins.BadRequestException r8 = new io.ktor.server.plugins.BadRequestException
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "Illegal Content-Type header format: "
                r0.append(r1)
                io.ktor.server.request.PipelineRequest r1 = r5.getRequest()
                io.ktor.http.Headers r1 = r1.getHeaders()
                io.ktor.http.HttpHeaders r2 = io.ktor.http.HttpHeaders.INSTANCE
                java.lang.String r2 = r2.getContentType()
                java.lang.String r1 = r1.get(r2)
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                r8.<init>(r0, r7)
                throw r8
            */
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.server.engine.DefaultTransformKt.AnonymousClass3.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @InterfaceC4112d(c = "io.ktor.server.engine.DefaultTransformKt", f = "DefaultTransform.kt", l = {114}, m = "readText")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: io.ktor.server.engine.DefaultTransformKt$readText$1, reason: invalid class name and case insensitive filesystem */
    public static final class C43461 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C43461(InterfaceC4014c<? super C43461> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DefaultTransformKt.readText(null, null, this);
        }
    }

    public static final vc.c getLOGGER() {
        return LOGGER;
    }

    public static final void installDefaultTransformations(ApplicationSendPipeline applicationSendPipeline) {
        kotlin.jvm.internal.p.i(applicationSendPipeline, "<this>");
        applicationSendPipeline.intercept(ApplicationSendPipeline.INSTANCE.getRender(), new AnonymousClass1(null));
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object readText(io.ktor.utils.io.ByteReadChannel r4, java.nio.charset.Charset r5, e9.InterfaceC4014c<? super java.lang.String> r6) throws java.lang.Throwable {
        /*
            boolean r0 = r6 instanceof io.ktor.server.engine.DefaultTransformKt.C43461
            if (r0 == 0) goto L13
            r0 = r6
            io.ktor.server.engine.DefaultTransformKt$readText$1 r0 = (io.ktor.server.engine.DefaultTransformKt.C43461) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.server.engine.DefaultTransformKt$readText$1 r0 = new io.ktor.server.engine.DefaultTransformKt$readText$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r4 = r0.L$0
            r5 = r4
            java.nio.charset.Charset r5 = (java.nio.charset.Charset) r5
            kotlin.C4849c.b(r6)
            goto L49
        L2e:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L36:
            kotlin.C4849c.b(r6)
            r0.L$0 = r5
            r0.label = r3
            r2 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            java.lang.Object r6 = io.ktor.utils.io.ByteReadChannelOperationsKt.readRemaining(r4, r2, r0)
            if (r6 != r1) goto L49
            return r1
        L49:
            fb.v r6 = (fb.v) r6
            boolean r4 = r6.k()
            if (r4 == 0) goto L54
            java.lang.String r4 = ""
            return r4
        L54:
            java.nio.charset.Charset r4 = La.C0953c.UTF_8     // Catch: java.lang.Throwable -> L6a
            boolean r4 = kotlin.jvm.internal.p.d(r5, r4)     // Catch: java.lang.Throwable -> L6a
            if (r4 != 0) goto L6c
            java.nio.charset.Charset r4 = La.C0953c.ISO_8859_1     // Catch: java.lang.Throwable -> L6a
            boolean r4 = kotlin.jvm.internal.p.d(r5, r4)     // Catch: java.lang.Throwable -> L6a
            if (r4 == 0) goto L65
            goto L6c
        L65:
            java.lang.String r4 = io.ktor.server.engine.DefaultTransformJvmKt.readTextWithCustomCharset(r6, r5)     // Catch: java.lang.Throwable -> L6a
            goto L70
        L6a:
            r4 = move-exception
            goto L74
        L6c:
            java.lang.String r4 = io.ktor.utils.io.DeprecationKt.readText(r6)     // Catch: java.lang.Throwable -> L6a
        L70:
            r6.close()
            return r4
        L74:
            r6.close()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.server.engine.DefaultTransformKt.readText(io.ktor.utils.io.ByteReadChannel, java.nio.charset.Charset, e9.c):java.lang.Object");
    }

    public static final <R> R withContentType(PipelineCall call, InterfaceC5063a<? extends R> block) throws BadRequestException {
        kotlin.jvm.internal.p.i(call, "call");
        kotlin.jvm.internal.p.i(block, "block");
        try {
            return block.invoke();
        } catch (BadContentTypeFormatException e10) {
            throw new BadRequestException("Illegal Content-Type header format: " + call.getRequest().getHeaders().get(HttpHeaders.INSTANCE.getContentType()), e10);
        }
    }

    public static final void installDefaultTransformations(ApplicationReceivePipeline applicationReceivePipeline) throws InvalidPhaseException {
        kotlin.jvm.internal.p.i(applicationReceivePipeline, "<this>");
        ApplicationReceivePipeline.Companion companion = ApplicationReceivePipeline.INSTANCE;
        applicationReceivePipeline.intercept(companion.getTransform(), new AnonymousClass2(null));
        Phase phase = new Phase("AfterTransform");
        applicationReceivePipeline.insertPhaseAfter(companion.getTransform(), phase);
        applicationReceivePipeline.intercept(phase, new AnonymousClass3(null));
    }
}
