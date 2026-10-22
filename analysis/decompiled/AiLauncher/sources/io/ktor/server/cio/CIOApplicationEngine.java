package io.ktor.server.cio;

import Ua.C1056g;
import Ua.C1060i;
import Ua.C1087w;
import Ua.I;
import Ua.InterfaceC1083u;
import Ua.InterfaceC1089x;
import Ua.M;
import Ua.Y;
import Y8.t;
import com.stepos.ailauncher.chat.trace.g;
import com.stepos.ailauncher.chat.wake.circle.F;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import io.ktor.events.Events;
import io.ktor.http.Headers;
import io.ktor.http.HttpHeaders;
import io.ktor.http.cio.Request;
import io.ktor.server.application.Application;
import io.ktor.server.application.ApplicationEnvironment;
import io.ktor.server.application.DefaultApplicationEventsKt;
import io.ktor.server.application.PipelineCall;
import io.ktor.server.cio.backend.HttpServerKt;
import io.ktor.server.cio.backend.ServerRequestScope;
import io.ktor.server.cio.backend.UnixSocketServerKt;
import io.ktor.server.cio.internal.CoroutineUtilsJvmKt;
import io.ktor.server.engine.ApplicationEngine;
import io.ktor.server.engine.BaseApplicationEngine;
import io.ktor.server.engine.EngineConnectorConfig;
import io.ktor.server.request.ApplicationReceivePipeline;
import io.ktor.util.pipeline.InvalidPhaseException;
import io.ktor.util.pipeline.Phase;
import io.ktor.util.pipeline.PipelineContext;
import io.ktor.utils.io.ByteWriteChannel;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.JobKt__JobKt;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import p9.p;
import p9.q;

@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001DB5\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\r\u0010\u000eJ\u001b\u0010\u0013\u001a\u00020\u0012*\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001cH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u001c\u0010\"\u001a\u00020\u0019*\u00020 2\u0006\u0010\u001d\u001a\u00020!H\u0082@¢\u0006\u0004\b\"\u0010#J\u000f\u0010%\u001a\u00020$H\u0002¢\u0006\u0004\b%\u0010&J\u0018\u0010)\u001a\u00020(2\u0006\u0010'\u001a\u00020\u0006H\u0096@¢\u0006\u0004\b)\u0010*J\u0017\u0010+\u001a\u00020(2\u0006\u0010'\u001a\u00020\u0006H\u0016¢\u0006\u0004\b+\u0010,J \u00100\u001a\u00020\u00192\u0006\u0010.\u001a\u00020-2\u0006\u0010/\u001a\u00020-H\u0096@¢\u0006\u0004\b0\u00101J\u001f\u00102\u001a\u00020\u00192\u0006\u0010.\u001a\u00020-2\u0006\u0010/\u001a\u00020-H\u0016¢\u0006\u0004\b2\u00103R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u00104\u001a\u0004\b5\u00106R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u00107R\u0014\u00109\u001a\u0002088\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u0014\u0010;\u001a\u0002088\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010:R\u001a\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00190<8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\u0014\u0010@\u001a\u00020?8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010B\u001a\u00020$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010C¨\u0006E"}, d2 = {"Lio/ktor/server/cio/CIOApplicationEngine;", "Lio/ktor/server/engine/BaseApplicationEngine;", "Lio/ktor/server/application/ApplicationEnvironment;", "environment", "Lio/ktor/events/Events;", "monitor", "", "developmentMode", "Lio/ktor/server/cio/CIOApplicationEngine$Configuration;", "configuration", "Lkotlin/Function0;", "Lio/ktor/server/application/Application;", "applicationProvider", "<init>", "(Lio/ktor/server/application/ApplicationEnvironment;Lio/ktor/events/Events;ZLio/ktor/server/cio/CIOApplicationEngine$Configuration;Lp9/a;)V", "LUa/M;", "Lio/ktor/server/engine/EngineConnectorConfig;", "connectorSpec", "Lio/ktor/server/cio/HttpServer;", "startConnector", "(LUa/M;Lio/ktor/server/engine/EngineConnectorConfig;)Lio/ktor/server/cio/HttpServer;", "Lio/ktor/utils/io/ByteWriteChannel;", "output", "Lio/ktor/server/cio/CIOApplicationCall;", "call", "LY8/t;", "addHandlerForExpectedHeader", "(Lio/ktor/utils/io/ByteWriteChannel;Lio/ktor/server/cio/CIOApplicationCall;)V", "Lio/ktor/server/cio/CIOApplicationRequest;", "request", "hasBody", "(Lio/ktor/server/cio/CIOApplicationRequest;)Z", "Lio/ktor/server/cio/backend/ServerRequestScope;", "Lio/ktor/http/cio/Request;", "handleRequest", "(Lio/ktor/server/cio/backend/ServerRequestScope;Lio/ktor/http/cio/Request;Le9/c;)Ljava/lang/Object;", "Lkotlinx/coroutines/g;", "initServerJob", "()Lkotlinx/coroutines/g;", "wait", "Lio/ktor/server/engine/ApplicationEngine;", "startSuspend", "(ZLe9/c;)Ljava/lang/Object;", "start", "(Z)Lio/ktor/server/engine/ApplicationEngine;", "", "gracePeriodMillis", "timeoutMillis", "stopSuspend", "(JJLe9/c;)Ljava/lang/Object;", g.ACTION_STOP, "(JJ)V", "Lio/ktor/server/cio/CIOApplicationEngine$Configuration;", "getConfiguration", "()Lio/ktor/server/cio/CIOApplicationEngine$Configuration;", "Lp9/a;", "LUa/I;", "engineDispatcher", "LUa/I;", "userDispatcher", "LUa/u;", "startupJob", "LUa/u;", "LUa/x;", "stopRequest", "LUa/x;", "serverJob", "Lkotlinx/coroutines/g;", "Configuration", "ktor-server-cio"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CIOApplicationEngine extends BaseApplicationEngine {
    private final InterfaceC5063a<Application> applicationProvider;
    private final Configuration configuration;
    private final I engineDispatcher;
    private volatile kotlinx.coroutines.g serverJob;
    private final InterfaceC1083u<t> startupJob;
    private final InterfaceC1089x stopRequest;
    private final I userDispatcher;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lio/ktor/server/cio/CIOApplicationEngine$Configuration;", "Lio/ktor/server/engine/BaseApplicationEngine$Configuration;", "<init>", "()V", "", "connectionIdleTimeoutSeconds", "I", "getConnectionIdleTimeoutSeconds", "()I", "setConnectionIdleTimeoutSeconds", "(I)V", "", "reuseAddress", "Z", "getReuseAddress", "()Z", "setReuseAddress", "(Z)V", "ktor-server-cio"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Configuration extends BaseApplicationEngine.Configuration {
        private int connectionIdleTimeoutSeconds = 45;
        private boolean reuseAddress;

        public final int getConnectionIdleTimeoutSeconds() {
            return this.connectionIdleTimeoutSeconds;
        }

        public final boolean getReuseAddress() {
            return this.reuseAddress;
        }

        public final void setConnectionIdleTimeoutSeconds(int i10) {
            this.connectionIdleTimeoutSeconds = i10;
        }

        public final void setReuseAddress(boolean z10) {
            this.reuseAddress = z10;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lio/ktor/util/pipeline/PipelineContext;", "", "Lio/ktor/server/application/PipelineCall;", "it", "LY8/t;", "<anonymous>", "(Lio/ktor/util/pipeline/PipelineContext;Ljava/lang/Object;)V"}, k = 3, mv = {2, 1, 0})
    @InterfaceC4112d(c = "io.ktor.server.cio.CIOApplicationEngine$addHandlerForExpectedHeader$1", f = "CIOApplicationEngine.kt", l = {253, 158, 159}, m = "invokeSuspend")
    /* renamed from: io.ktor.server.cio.CIOApplicationEngine$addHandlerForExpectedHeader$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements q<PipelineContext<Object, PipelineCall>, Object, InterfaceC4014c<? super t>, Object> {
        final /* synthetic */ CIOApplicationCall $call;
        final /* synthetic */ String $continueResponse;
        final /* synthetic */ String $expectHeaderValue;
        final /* synthetic */ ByteWriteChannel $output;
        Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ CIOApplicationEngine this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(CIOApplicationCall cIOApplicationCall, CIOApplicationEngine cIOApplicationEngine, String str, ByteWriteChannel byteWriteChannel, String str2, InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(3, interfaceC4014c);
            this.$call = cIOApplicationCall;
            this.this$0 = cIOApplicationEngine;
            this.$expectHeaderValue = str;
            this.$output = byteWriteChannel;
            this.$continueResponse = str2;
        }

        @Override // p9.q
        public final Object invoke(PipelineContext<Object, PipelineCall> pipelineContext, Object obj, InterfaceC4014c<? super t> interfaceC4014c) {
            return new AnonymousClass1(this.$call, this.this$0, this.$expectHeaderValue, this.$output, this.$continueResponse, interfaceC4014c).invokeSuspend(t.f7040a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:27:0x00a1, code lost:
        
            if (r10.respond(r1, r2, r9) == r0) goto L35;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x00c0, code lost:
        
            if (r1.flush(r9) != r0) goto L36;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r10) throws java.lang.Throwable {
            /*
                r9 = this;
                java.lang.Object r0 = f9.C4063a.g()
                int r1 = r9.label
                r2 = 3
                r3 = 2
                r4 = 1
                r5 = 0
                if (r1 == 0) goto L31
                if (r1 == r4) goto L2c
                if (r1 == r3) goto L1f
                if (r1 != r2) goto L17
                java.lang.Object r9 = r9.L$0
                io.ktor.utils.io.ByteWriteChannel r9 = (io.ktor.utils.io.ByteWriteChannel) r9
                goto L2c
            L17:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r10)
                throw r9
            L1f:
                java.lang.Object r1 = r9.L$1
                io.ktor.utils.io.ByteWriteChannel r1 = (io.ktor.utils.io.ByteWriteChannel) r1
                java.lang.Object r3 = r9.L$0
                io.ktor.utils.io.ByteWriteChannel r3 = (io.ktor.utils.io.ByteWriteChannel) r3
                kotlin.C4849c.b(r10)
                goto Lb6
            L2c:
                kotlin.C4849c.b(r10)
                goto Lc3
            L31:
                kotlin.C4849c.b(r10)
                io.ktor.server.cio.CIOApplicationCall r10 = r9.$call
                io.ktor.server.cio.CIOApplicationRequest r10 = r10.getRequest()
                io.ktor.http.HttpProtocolVersion$Companion r1 = io.ktor.http.HttpProtocolVersion.INSTANCE
                java.lang.String r6 = io.ktor.server.request.ApplicationRequestPropertiesKt.getHttpVersion(r10)
                io.ktor.http.HttpProtocolVersion r6 = r1.parse(r6)
                io.ktor.server.cio.CIOApplicationCall r7 = r9.$call
                io.ktor.server.cio.CIOApplicationRequest r7 = r7.getRequest()
                io.ktor.http.Headers r7 = r7.getHeaders()
                io.ktor.http.HttpHeaders r8 = io.ktor.http.HttpHeaders.INSTANCE
                java.lang.String r8 = r8.getExpect()
                java.lang.String r7 = r7.get(r8)
                if (r7 == 0) goto L66
                java.util.Locale r8 = java.util.Locale.ROOT
                java.lang.String r7 = r7.toLowerCase(r8)
                java.lang.String r8 = "toLowerCase(...)"
                kotlin.jvm.internal.p.h(r7, r8)
                goto L67
            L66:
                r7 = r5
            L67:
                io.ktor.server.cio.CIOApplicationEngine r8 = r9.this$0
                boolean r10 = io.ktor.server.cio.CIOApplicationEngine.access$hasBody(r8, r10)
                if (r7 == 0) goto Lc6
                io.ktor.http.HttpProtocolVersion r1 = r1.getHTTP_1_0()
                boolean r1 = kotlin.jvm.internal.p.d(r6, r1)
                if (r1 != 0) goto Lc6
                if (r10 != 0) goto L7c
                goto Lc6
            L7c:
                java.lang.String r10 = r9.$expectHeaderValue
                boolean r10 = kotlin.jvm.internal.p.d(r7, r10)
                if (r10 != 0) goto La4
                io.ktor.server.cio.CIOApplicationCall r10 = r9.$call
                io.ktor.http.HttpStatusCode$Companion r1 = io.ktor.http.HttpStatusCode.INSTANCE
                io.ktor.http.HttpStatusCode r1 = r1.getExpectationFailed()
                java.lang.Class<io.ktor.http.HttpStatusCode> r2 = io.ktor.http.HttpStatusCode.class
                w9.d r3 = kotlin.jvm.internal.t.b(r2)
                w9.n r5 = kotlin.jvm.internal.t.m(r2)     // Catch: java.lang.Throwable -> L96
            L96:
                io.ktor.util.reflect.TypeInfo r2 = new io.ktor.util.reflect.TypeInfo
                r2.<init>(r3, r5)
                r9.label = r4
                java.lang.Object r9 = r10.respond(r1, r2, r9)
                if (r9 != r0) goto Lc3
                goto Lc2
            La4:
                io.ktor.utils.io.ByteWriteChannel r1 = r9.$output
                java.lang.String r10 = r9.$continueResponse
                r9.L$0 = r1
                r9.L$1 = r1
                r9.label = r3
                java.lang.Object r10 = io.ktor.utils.io.ByteWriteChannelOperationsKt.writeStringUtf8(r1, r10, r9)
                if (r10 != r0) goto Lb5
                goto Lc2
            Lb5:
                r3 = r1
            Lb6:
                r9.L$0 = r3
                r9.L$1 = r5
                r9.label = r2
                java.lang.Object r9 = r1.flush(r9)
                if (r9 != r0) goto Lc3
            Lc2:
                return r0
            Lc3:
                Y8.t r9 = Y8.t.f7040a
                return r9
            Lc6:
                Y8.t r9 = Y8.t.f7040a
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.server.cio.CIOApplicationEngine.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 1, 0})
    @InterfaceC4112d(c = "io.ktor.server.cio.CIOApplicationEngine$handleRequest$2", f = "CIOApplicationEngine.kt", l = {253, F.GESTURE_WIDTH_DP}, m = "invokeSuspend")
    /* renamed from: io.ktor.server.cio.CIOApplicationEngine$handleRequest$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {
        final /* synthetic */ Request $request;
        final /* synthetic */ ServerRequestScope $this_handleRequest;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Request request, ServerRequestScope serverRequestScope, InterfaceC4014c<? super AnonymousClass2> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$request = request;
            this.$this_handleRequest = serverRequestScope;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            AnonymousClass2 anonymousClass2 = CIOApplicationEngine.this.new AnonymousClass2(this.$request, this.$this_handleRequest, interfaceC4014c);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // p9.p
        public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
            return ((AnonymousClass2) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        /* JADX WARN: Removed duplicated region for block: B:28:0x00ac  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r17) throws java.lang.Throwable {
            /*
                r16 = this;
                r1 = r16
                java.lang.Object r2 = f9.C4063a.g()
                int r0 = r1.label
                r3 = 2
                r4 = 1
                if (r0 == 0) goto L31
                if (r0 == r4) goto L25
                if (r0 != r3) goto L1d
                java.lang.Object r0 = r1.L$0
                r1 = r0
                io.ktor.server.cio.CIOApplicationCall r1 = (io.ktor.server.cio.CIOApplicationCall) r1
                kotlin.C4849c.b(r17)     // Catch: java.lang.Throwable -> L1a
                goto Lad
            L1a:
                r0 = move-exception
                goto Lb5
            L1d:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
                r0.<init>(r1)
                throw r0
            L25:
                java.lang.Object r0 = r1.L$0
                r4 = r0
                io.ktor.server.cio.CIOApplicationCall r4 = (io.ktor.server.cio.CIOApplicationCall) r4
                kotlin.C4849c.b(r17)     // Catch: java.lang.Throwable -> L2e
                goto L9c
            L2e:
                r0 = move-exception
                r5 = r4
                goto La1
            L31:
                kotlin.C4849c.b(r17)
                java.lang.Object r0 = r1.L$0
                Ua.M r0 = (Ua.M) r0
                io.ktor.server.cio.CIOApplicationCall r5 = new io.ktor.server.cio.CIOApplicationCall
                io.ktor.server.cio.CIOApplicationEngine r6 = io.ktor.server.cio.CIOApplicationEngine.this
                p9.a r6 = io.ktor.server.cio.CIOApplicationEngine.access$getApplicationProvider$p(r6)
                java.lang.Object r6 = r6.invoke()
                io.ktor.server.application.Application r6 = (io.ktor.server.application.Application) r6
                io.ktor.http.cio.Request r7 = r1.$request
                io.ktor.server.cio.backend.ServerRequestScope r8 = r1.$this_handleRequest
                io.ktor.utils.io.ByteReadChannel r8 = r8.getInput()
                io.ktor.server.cio.backend.ServerRequestScope r9 = r1.$this_handleRequest
                io.ktor.utils.io.ByteWriteChannel r9 = r9.getOutput()
                io.ktor.server.cio.CIOApplicationEngine r10 = io.ktor.server.cio.CIOApplicationEngine.this
                Ua.I r10 = io.ktor.server.cio.CIOApplicationEngine.access$getEngineDispatcher$p(r10)
                io.ktor.server.cio.CIOApplicationEngine r11 = io.ktor.server.cio.CIOApplicationEngine.this
                Ua.I r11 = io.ktor.server.cio.CIOApplicationEngine.access$getUserDispatcher$p(r11)
                io.ktor.server.cio.backend.ServerRequestScope r12 = r1.$this_handleRequest
                Ua.u r12 = r12.getUpgraded()
                io.ktor.server.cio.backend.ServerRequestScope r13 = r1.$this_handleRequest
                java.net.SocketAddress r13 = r13.getRemoteAddress()
                io.ktor.server.cio.backend.ServerRequestScope r14 = r1.$this_handleRequest
                java.net.SocketAddress r14 = r14.getLocalAddress()
                kotlin.coroutines.d r15 = r0.getCoroutineContext()
                r5.<init>(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
                io.ktor.server.cio.CIOApplicationEngine r0 = io.ktor.server.cio.CIOApplicationEngine.this     // Catch: java.lang.Throwable -> La0
                io.ktor.server.cio.backend.ServerRequestScope r6 = r1.$this_handleRequest     // Catch: java.lang.Throwable -> La0
                io.ktor.utils.io.ByteWriteChannel r6 = r6.getOutput()     // Catch: java.lang.Throwable -> La0
                io.ktor.server.cio.CIOApplicationEngine.access$addHandlerForExpectedHeader(r0, r6, r5)     // Catch: java.lang.Throwable -> La0
                io.ktor.server.cio.CIOApplicationEngine r0 = io.ktor.server.cio.CIOApplicationEngine.this     // Catch: java.lang.Throwable -> La0
                io.ktor.server.engine.EnginePipeline r0 = r0.getPipeline()     // Catch: java.lang.Throwable -> La0
                io.ktor.server.cio.CIOApplicationEngine$handleRequest$2$invokeSuspend$$inlined$execute$1 r6 = new io.ktor.server.cio.CIOApplicationEngine$handleRequest$2$invokeSuspend$$inlined$execute$1     // Catch: java.lang.Throwable -> La0
                r7 = 0
                r6.<init>(r0, r5, r7)     // Catch: java.lang.Throwable -> La0
                r1.L$0 = r5     // Catch: java.lang.Throwable -> La0
                r1.label = r4     // Catch: java.lang.Throwable -> La0
                java.lang.Object r0 = io.ktor.util.debug.ContextUtilsKt.initContextInDebugMode(r6, r1)     // Catch: java.lang.Throwable -> La0
                if (r0 != r2) goto L9b
                goto Lab
            L9b:
                r4 = r5
            L9c:
                r4.release$ktor_server_cio()
                goto Lb0
            La0:
                r0 = move-exception
            La1:
                r1.L$0 = r5     // Catch: java.lang.Throwable -> Lb3
                r1.label = r3     // Catch: java.lang.Throwable -> Lb3
                java.lang.Object r0 = io.ktor.server.engine.DefaultEnginePipelineKt.handleFailure(r5, r0, r1)     // Catch: java.lang.Throwable -> Lb3
                if (r0 != r2) goto Lac
            Lab:
                return r2
            Lac:
                r1 = r5
            Lad:
                r1.release$ktor_server_cio()
            Lb0:
                Y8.t r0 = Y8.t.f7040a
                return r0
            Lb3:
                r0 = move-exception
                r1 = r5
            Lb5:
                r1.release$ktor_server_cio()
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.server.cio.CIOApplicationEngine.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 1, 0})
    @InterfaceC4112d(c = "io.ktor.server.cio.CIOApplicationEngine$initServerJob$1", f = "CIOApplicationEngine.kt", l = {225, 238, 245, 248}, m = "invokeSuspend")
    /* renamed from: io.ktor.server.cio.CIOApplicationEngine$initServerJob$1, reason: invalid class name and case insensitive filesystem */
    public static final class C43251 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {
        final /* synthetic */ InterfaceC1083u<List<EngineConnectorConfig>> $cioConnectors;
        final /* synthetic */ ApplicationEnvironment $environment;
        final /* synthetic */ InterfaceC1083u<t> $startupJob;
        final /* synthetic */ InterfaceC1089x $stopRequest;
        final /* synthetic */ I $userDispatcher;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 1, 0})
        @InterfaceC4112d(c = "io.ktor.server.cio.CIOApplicationEngine$initServerJob$1$5", f = "CIOApplicationEngine.kt", l = {}, m = "invokeSuspend")
        /* renamed from: io.ktor.server.cio.CIOApplicationEngine$initServerJob$1$5, reason: invalid class name */
        public static final class AnonymousClass5 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {
            final /* synthetic */ ApplicationEnvironment $environment;
            int label;
            final /* synthetic */ CIOApplicationEngine this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass5(CIOApplicationEngine cIOApplicationEngine, ApplicationEnvironment applicationEnvironment, InterfaceC4014c<? super AnonymousClass5> interfaceC4014c) {
                super(2, interfaceC4014c);
                this.this$0 = cIOApplicationEngine;
                this.$environment = applicationEnvironment;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
                return new AnonymousClass5(this.this$0, this.$environment, interfaceC4014c);
            }

            @Override // p9.p
            public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
                return ((AnonymousClass5) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                C4063a.g();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
                this.this$0.getMonitor().raise(DefaultApplicationEventsKt.getApplicationStopPreparing(), this.$environment);
                return t.f7040a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C43251(InterfaceC1083u<List<EngineConnectorConfig>> interfaceC1083u, InterfaceC1089x interfaceC1089x, InterfaceC1083u<t> interfaceC1083u2, I i10, ApplicationEnvironment applicationEnvironment, InterfaceC4014c<? super C43251> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$cioConnectors = interfaceC1083u;
            this.$stopRequest = interfaceC1089x;
            this.$startupJob = interfaceC1083u2;
            this.$userDispatcher = i10;
            this.$environment = applicationEnvironment;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            C43251 c43251 = CIOApplicationEngine.this.new C43251(this.$cioConnectors, this.$stopRequest, this.$startupJob, this.$userDispatcher, this.$environment, interfaceC4014c);
            c43251.L$0 = obj;
            return c43251;
        }

        @Override // p9.p
        public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
            return ((C43251) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:70:0x01ff, code lost:
        
            if (kotlinx.coroutines.AwaitKt.b(r14, r13) != r0) goto L72;
         */
        /* JADX WARN: Not initialized variable reg: 11, insn: 0x0205: INVOKE (r0 I:java.util.Iterator) = (r11 I:java.lang.Iterable) INTERFACE call: java.lang.Iterable.iterator():java.util.Iterator A[MD:():java.util.Iterator<T> (c)], block:B:74:0x0205 */
        /* JADX WARN: Removed duplicated region for block: B:38:0x010f A[Catch: all -> 0x004f, TryCatch #0 {all -> 0x004f, blocks: (B:14:0x004a, B:42:0x013a, B:36:0x0109, B:38:0x010f, B:43:0x0143, B:44:0x0154, B:46:0x015a, B:48:0x0176, B:52:0x0182, B:53:0x0186, B:19:0x006c, B:20:0x007c, B:22:0x0082, B:25:0x0099, B:26:0x00a0, B:27:0x00a1, B:28:0x00bc, B:30:0x00c2, B:31:0x00d4, B:32:0x00e1, B:34:0x00e7, B:35:0x00f7), top: B:80:0x000d }] */
        /* JADX WARN: Removed duplicated region for block: B:43:0x0143 A[Catch: all -> 0x004f, TryCatch #0 {all -> 0x004f, blocks: (B:14:0x004a, B:42:0x013a, B:36:0x0109, B:38:0x010f, B:43:0x0143, B:44:0x0154, B:46:0x015a, B:48:0x0176, B:52:0x0182, B:53:0x0186, B:19:0x006c, B:20:0x007c, B:22:0x0082, B:25:0x0099, B:26:0x00a0, B:27:0x00a1, B:28:0x00bc, B:30:0x00c2, B:31:0x00d4, B:32:0x00e1, B:34:0x00e7, B:35:0x00f7), top: B:80:0x000d }] */
        /* JADX WARN: Removed duplicated region for block: B:61:0x01b2 A[LOOP:1: B:59:0x01ac->B:61:0x01b2, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:65:0x01d6 A[PHI: r1
          0x01d6: PHI (r1v34 java.util.ArrayList) = (r1v33 java.util.ArrayList), (r1v41 java.util.ArrayList) binds: [B:63:0x01d3, B:11:0x0024] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:68:0x01e9 A[LOOP:0: B:66:0x01e3->B:68:0x01e9, LOOP_END] */
        /* JADX WARN: Type inference failed for: r11v0, types: [java.lang.Iterable] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x0139 -> B:42:0x013a). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r14) throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 552
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.server.cio.CIOApplicationEngine.C43251.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "Lio/ktor/server/engine/ApplicationEngine;", "<anonymous>", "(LUa/M;)Lio/ktor/server/engine/ApplicationEngine;"}, k = 3, mv = {2, 1, 0})
    @InterfaceC4112d(c = "io.ktor.server.cio.CIOApplicationEngine$start$1", f = "CIOApplicationEngine.kt", l = {87}, m = "invokeSuspend")
    /* renamed from: io.ktor.server.cio.CIOApplicationEngine$start$1, reason: invalid class name and case insensitive filesystem */
    public static final class C43261 extends SuspendLambda implements p<M, InterfaceC4014c<? super ApplicationEngine>, Object> {
        final /* synthetic */ boolean $wait;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C43261(boolean z10, InterfaceC4014c<? super C43261> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$wait = z10;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return CIOApplicationEngine.this.new C43261(this.$wait, interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(M m10, InterfaceC4014c<? super ApplicationEngine> interfaceC4014c) {
            return ((C43261) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
                return obj;
            }
            C4849c.b(obj);
            CIOApplicationEngine cIOApplicationEngine = CIOApplicationEngine.this;
            boolean z10 = this.$wait;
            this.label = 1;
            Object objStartSuspend = cIOApplicationEngine.startSuspend(z10, this);
            return objStartSuspend == objG ? objG : objStartSuspend;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lio/ktor/server/cio/backend/ServerRequestScope;", "Lio/ktor/http/cio/Request;", "request", "LY8/t;", "<anonymous>", "(Lio/ktor/server/cio/backend/ServerRequestScope;Lio/ktor/http/cio/Request;)V"}, k = 3, mv = {2, 1, 0})
    @InterfaceC4112d(c = "io.ktor.server.cio.CIOApplicationEngine$startConnector$1", f = "CIOApplicationEngine.kt", l = {120}, m = "invokeSuspend")
    /* renamed from: io.ktor.server.cio.CIOApplicationEngine$startConnector$1, reason: invalid class name and case insensitive filesystem */
    public static final class C43271 extends SuspendLambda implements q<ServerRequestScope, Request, InterfaceC4014c<? super t>, Object> {
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        public C43271(InterfaceC4014c<? super C43271> interfaceC4014c) {
            super(3, interfaceC4014c);
        }

        @Override // p9.q
        public final Object invoke(ServerRequestScope serverRequestScope, Request request, InterfaceC4014c<? super t> interfaceC4014c) {
            C43271 c43271 = CIOApplicationEngine.this.new C43271(interfaceC4014c);
            c43271.L$0 = serverRequestScope;
            c43271.L$1 = request;
            return c43271.invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 == 0) {
                C4849c.b(obj);
                ServerRequestScope serverRequestScope = (ServerRequestScope) this.L$0;
                Request request = (Request) this.L$1;
                CIOApplicationEngine cIOApplicationEngine = CIOApplicationEngine.this;
                this.L$0 = null;
                this.label = 1;
                if (cIOApplicationEngine.handleRequest(serverRequestScope, request, this) == objG) {
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

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lio/ktor/server/cio/backend/ServerRequestScope;", "Lio/ktor/http/cio/Request;", "request", "LY8/t;", "<anonymous>", "(Lio/ktor/server/cio/backend/ServerRequestScope;Lio/ktor/http/cio/Request;)V"}, k = 3, mv = {2, 1, 0})
    @InterfaceC4112d(c = "io.ktor.server.cio.CIOApplicationEngine$startConnector$2", f = "CIOApplicationEngine.kt", l = {132}, m = "invokeSuspend")
    /* renamed from: io.ktor.server.cio.CIOApplicationEngine$startConnector$2, reason: invalid class name and case insensitive filesystem */
    public static final class C43282 extends SuspendLambda implements q<ServerRequestScope, Request, InterfaceC4014c<? super t>, Object> {
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        public C43282(InterfaceC4014c<? super C43282> interfaceC4014c) {
            super(3, interfaceC4014c);
        }

        @Override // p9.q
        public final Object invoke(ServerRequestScope serverRequestScope, Request request, InterfaceC4014c<? super t> interfaceC4014c) {
            C43282 c43282 = CIOApplicationEngine.this.new C43282(interfaceC4014c);
            c43282.L$0 = serverRequestScope;
            c43282.L$1 = request;
            return c43282.invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 == 0) {
                C4849c.b(obj);
                ServerRequestScope serverRequestScope = (ServerRequestScope) this.L$0;
                Request request = (Request) this.L$1;
                CIOApplicationEngine cIOApplicationEngine = CIOApplicationEngine.this;
                this.L$0 = null;
                this.label = 1;
                if (cIOApplicationEngine.handleRequest(serverRequestScope, request, this) == objG) {
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

    @InterfaceC4112d(c = "io.ktor.server.cio.CIOApplicationEngine", f = "CIOApplicationEngine.kt", l = {77, 81}, m = "startSuspend")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: io.ktor.server.cio.CIOApplicationEngine$startSuspend$1, reason: invalid class name and case insensitive filesystem */
    public static final class C43291 extends ContinuationImpl {
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        public C43291(InterfaceC4014c<? super C43291> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CIOApplicationEngine.this.startSuspend(false, this);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 1, 0})
    @InterfaceC4112d(c = "io.ktor.server.cio.CIOApplicationEngine$stop$1", f = "CIOApplicationEngine.kt", l = {108}, m = "invokeSuspend")
    /* renamed from: io.ktor.server.cio.CIOApplicationEngine$stop$1, reason: invalid class name and case insensitive filesystem */
    public static final class C43301 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {
        final /* synthetic */ long $gracePeriodMillis;
        final /* synthetic */ long $timeoutMillis;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C43301(long j10, long j11, InterfaceC4014c<? super C43301> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$gracePeriodMillis = j10;
            this.$timeoutMillis = j11;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return CIOApplicationEngine.this.new C43301(this.$gracePeriodMillis, this.$timeoutMillis, interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
            return ((C43301) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 == 0) {
                C4849c.b(obj);
                CIOApplicationEngine cIOApplicationEngine = CIOApplicationEngine.this;
                long j10 = this.$gracePeriodMillis;
                long j11 = this.$timeoutMillis;
                this.label = 1;
                if (cIOApplicationEngine.stopSuspend(j10, j11, this) == objG) {
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

    @InterfaceC4112d(c = "io.ktor.server.cio.CIOApplicationEngine", f = "CIOApplicationEngine.kt", l = {92, 101}, m = "stopSuspend")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: io.ktor.server.cio.CIOApplicationEngine$stopSuspend$1, reason: invalid class name and case insensitive filesystem */
    public static final class C43311 extends ContinuationImpl {
        long J$0;
        long J$1;
        int label;
        /* synthetic */ Object result;

        public C43311(InterfaceC4014c<? super C43311> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CIOApplicationEngine.this.stopSuspend(0L, 0L, this);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 1, 0})
    @InterfaceC4112d(c = "io.ktor.server.cio.CIOApplicationEngine$stopSuspend$2", f = "CIOApplicationEngine.kt", l = {102}, m = "invokeSuspend")
    /* renamed from: io.ktor.server.cio.CIOApplicationEngine$stopSuspend$2, reason: invalid class name and case insensitive filesystem */
    public static final class C43322 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {
        int label;

        public C43322(InterfaceC4014c<? super C43322> interfaceC4014c) {
            super(2, interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return CIOApplicationEngine.this.new C43322(interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
            return ((C43322) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 == 0) {
                C4849c.b(obj);
                kotlinx.coroutines.g gVar = CIOApplicationEngine.this.serverJob;
                this.label = 1;
                if (gVar.T0(this) == objG) {
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CIOApplicationEngine(ApplicationEnvironment environment, Events monitor, boolean z10, Configuration configuration, InterfaceC5063a<Application> applicationProvider) {
        super(environment, monitor, z10, null, 8, null);
        kotlin.jvm.internal.p.i(environment, "environment");
        kotlin.jvm.internal.p.i(monitor, "monitor");
        kotlin.jvm.internal.p.i(configuration, "configuration");
        kotlin.jvm.internal.p.i(applicationProvider, "applicationProvider");
        this.configuration = configuration;
        this.applicationProvider = applicationProvider;
        Y y10 = Y.f6353a;
        this.engineDispatcher = CoroutineUtilsJvmKt.getIOBridge(y10);
        this.userDispatcher = CoroutineUtilsJvmKt.getIOBridge(y10);
        this.startupJob = C1087w.c(null, 1, null);
        this.stopRequest = JobKt__JobKt.b(null, 1, null);
        this.serverJob = JobKt__JobKt.b(null, 1, null);
        this.serverJob = initServerJob();
        this.serverJob.J(new InterfaceC5074l() { // from class: io.ktor.server.cio.a
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return CIOApplicationEngine._init_$lambda$2(this.f33347a, (Throwable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t _init_$lambda$2(CIOApplicationEngine cIOApplicationEngine, Throwable th) {
        if (th != null) {
            cIOApplicationEngine.stopRequest.e(th);
        }
        if (th != null) {
            cIOApplicationEngine.startupJob.e(th);
        }
        return t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void addHandlerForExpectedHeader(ByteWriteChannel output, CIOApplicationCall call) throws InvalidPhaseException {
        Phase phase = new Phase("ExpectedHeaderPhase");
        call.getRequest().getPipeline().insertPhaseBefore(ApplicationReceivePipeline.INSTANCE.getBefore(), phase);
        call.getRequest().getPipeline().intercept(phase, new AnonymousClass1(call, this, com.stepos.statsapp.v3.lib.plugin.net.multipart.e.f30856o, output, "HTTP/1.1 100 Continue\r\n", null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object handleRequest(ServerRequestScope serverRequestScope, Request request, InterfaceC4014c<? super t> interfaceC4014c) {
        Object objJ = C1056g.j(this.userDispatcher, new AnonymousClass2(request, serverRequestScope, null), interfaceC4014c);
        return objJ == C4063a.g() ? objJ : t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean hasBody(CIOApplicationRequest request) {
        Headers headers = request.getHeaders();
        HttpHeaders httpHeaders = HttpHeaders.INSTANCE;
        String str = headers.get(httpHeaders.getContentLength());
        Long lValueOf = str != null ? Long.valueOf(Long.parseLong(str)) : null;
        if (request.getHeaders().get(httpHeaders.getTransferEncoding()) == null) {
            return lValueOf != null && lValueOf.longValue() > 0;
        }
        return true;
    }

    private final kotlinx.coroutines.g initServerJob() {
        ApplicationEnvironment environment = getEnvironment();
        I i10 = this.userDispatcher;
        InterfaceC1089x interfaceC1089x = this.stopRequest;
        InterfaceC1083u<t> interfaceC1083u = this.startupJob;
        return C1060i.d(kotlinx.coroutines.d.a(this.applicationProvider.invoke().getParentCoroutineContext().plus(this.engineDispatcher)), null, CoroutineStart.LAZY, new C43251(getResolvedConnectorsDeferred(), interfaceC1089x, interfaceC1083u, i10, environment, null), 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HttpServer startConnector(M m10, EngineConnectorConfig engineConnectorConfig) {
        return engineConnectorConfig instanceof UnixSocketConnectorConfig ? UnixSocketServerKt.unixSocketServer(m10, new UnixSocketServerSettings(((UnixSocketConnectorConfig) engineConnectorConfig).getSocketPath(), this.configuration.getConnectionIdleTimeoutSeconds()), new C43271(null)) : HttpServerKt.httpServer(m10, new HttpServerSettings(engineConnectorConfig.getHost(), engineConnectorConfig.getPort(), this.configuration.getConnectionIdleTimeoutSeconds(), this.configuration.getReuseAddress()), new C43282(null));
    }

    public final Configuration getConfiguration() {
        return this.configuration;
    }

    @Override // io.ktor.server.engine.ApplicationEngine
    public ApplicationEngine start(boolean wait) {
        return (ApplicationEngine) CoroutineUtilsJvmKt.runBlockingBridge(new C43261(wait, null));
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // io.ktor.server.engine.BaseApplicationEngine, io.ktor.server.engine.ApplicationEngine
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object startSuspend(boolean r7, e9.InterfaceC4014c<? super io.ktor.server.engine.ApplicationEngine> r8) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r8 instanceof io.ktor.server.cio.CIOApplicationEngine.C43291
            if (r0 == 0) goto L13
            r0 = r8
            io.ktor.server.cio.CIOApplicationEngine$startSuspend$1 r0 = (io.ktor.server.cio.CIOApplicationEngine.C43291) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.server.cio.CIOApplicationEngine$startSuspend$1 r0 = new io.ktor.server.cio.CIOApplicationEngine$startSuspend$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3a
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.C4849c.b(r8)
            return r6
        L2c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L34:
            boolean r7 = r0.Z$0
            kotlin.C4849c.b(r8)
            goto L4f
        L3a:
            kotlin.C4849c.b(r8)
            kotlinx.coroutines.g r8 = r6.serverJob
            r8.start()
            Ua.u<Y8.t> r8 = r6.startupJob
            r0.Z$0 = r7
            r0.label = r4
            java.lang.Object r8 = r8.a1(r0)
            if (r8 != r1) goto L4f
            goto L72
        L4f:
            io.ktor.events.Events r8 = r6.getMonitor()
            io.ktor.events.EventDefinition r2 = io.ktor.server.application.DefaultApplicationEventsKt.getServerReady()
            io.ktor.server.application.ApplicationEnvironment r4 = r6.getEnvironment()
            io.ktor.server.application.ApplicationEnvironment r5 = r6.getEnvironment()
            vc.c r5 = r5.getLog()
            io.ktor.events.EventsKt.raiseCatching(r8, r2, r4, r5)
            if (r7 == 0) goto L73
            kotlinx.coroutines.g r7 = r6.serverJob
            r0.label = r3
            java.lang.Object r7 = r7.T0(r0)
            if (r7 != r1) goto L73
        L72:
            return r1
        L73:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.server.cio.CIOApplicationEngine.startSuspend(boolean, e9.c):java.lang.Object");
    }

    @Override // io.ktor.server.engine.ApplicationEngine
    public void stop(long gracePeriodMillis, long timeoutMillis) {
        CoroutineUtilsJvmKt.runBlockingBridge(new C43301(gracePeriodMillis, timeoutMillis, null));
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // io.ktor.server.engine.BaseApplicationEngine, io.ktor.server.engine.ApplicationEngine
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object stopSuspend(long r7, long r9, e9.InterfaceC4014c<? super Y8.t> r11) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r11 instanceof io.ktor.server.cio.CIOApplicationEngine.C43311
            if (r0 == 0) goto L13
            r0 = r11
            io.ktor.server.cio.CIOApplicationEngine$stopSuspend$1 r0 = (io.ktor.server.cio.CIOApplicationEngine.C43311) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.server.cio.CIOApplicationEngine$stopSuspend$1 r0 = new io.ktor.server.cio.CIOApplicationEngine$stopSuspend$1
            r0.<init>(r11)
        L18:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L3d
            if (r2 == r4) goto L35
            if (r2 != r3) goto L2d
            kotlin.C4849c.b(r11)
            return r11
        L2d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L35:
            long r9 = r0.J$1
            long r7 = r0.J$0
            kotlin.C4849c.b(r11)
            goto L57
        L3d:
            kotlin.C4849c.b(r11)
            Ua.x r11 = r6.stopRequest
            r11.complete()
            io.ktor.server.cio.CIOApplicationEngine$stopSuspend$result$1 r11 = new io.ktor.server.cio.CIOApplicationEngine$stopSuspend$result$1
            r11.<init>(r6, r5)
            r0.J$0 = r7
            r0.J$1 = r9
            r0.label = r4
            java.lang.Object r11 = kotlinx.coroutines.TimeoutKt.e(r7, r11, r0)
            if (r11 != r1) goto L57
            goto L6e
        L57:
            java.lang.Boolean r11 = (java.lang.Boolean) r11
            if (r11 != 0) goto L70
            kotlinx.coroutines.g r11 = r6.serverJob
            kotlinx.coroutines.g.a.a(r11, r5, r4, r5)
            long r9 = r9 - r7
            io.ktor.server.cio.CIOApplicationEngine$stopSuspend$2 r7 = new io.ktor.server.cio.CIOApplicationEngine$stopSuspend$2
            r7.<init>(r5)
            r0.label = r3
            java.lang.Object r6 = kotlinx.coroutines.TimeoutKt.e(r9, r7, r0)
            if (r6 != r1) goto L6f
        L6e:
            return r1
        L6f:
            return r6
        L70:
            Y8.t r6 = Y8.t.f7040a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.server.cio.CIOApplicationEngine.stopSuspend(long, long, e9.c):java.lang.Object");
    }
}
