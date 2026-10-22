package io.ktor.client.engine.cio;

import Ua.C1056g;
import Ua.C1060i;
import Ua.CoroutineName;
import Ua.M;
import Y8.t;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.wake.circle.F;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardView;
import com.stepos.deepbinder.core.constant.Constants;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import io.ktor.client.plugins.HttpTimeoutCapability;
import io.ktor.client.plugins.HttpTimeoutConfig;
import io.ktor.client.plugins.HttpTimeoutKt;
import io.ktor.client.request.HttpRequestData;
import io.ktor.client.request.HttpResponseData;
import io.ktor.client.request.UnixSocketSettings;
import io.ktor.client.utils.ExceptionUtilsJvmKt;
import io.ktor.network.sockets.Connection;
import io.ktor.network.sockets.InetSocketAddress;
import io.ktor.network.sockets.SocketAddress;
import io.ktor.network.tls.TLSConfigBuilder;
import io.ktor.network.tls.TLSConfigBuilderKt;
import io.ktor.util.date.DateJvmKt;
import io.ktor.util.date.GMTDate;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.utils.io.ByteWriteChannelOperationsKt;
import java.io.Closeable;
import java.net.Proxy;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5063a;
import p9.p;

@Metadata(d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 W2\u00020\u00012\u00060\u0002j\u0002`\u0003:\u0001WB_\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u000e\u0010\n\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\t\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0018\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001aH\u0082@¢\u0006\u0004\b\u001c\u0010\u001dJ \u0010\"\u001a\u00020!2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u0011H\u0082@¢\u0006\u0004\b\"\u0010#JH\u0010,\u001a\u00020!2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020$2\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020&2\u0006\u0010 \u001a\u00020\u00112\u0006\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020\u000bH\u0082@¢\u0006\u0004\b,\u0010-J\u0018\u0010.\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\u001eH\u0082@¢\u0006\u0004\b.\u0010/J$\u00104\u001a\u000e\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u000203012\u0006\u00100\u001a\u00020\u001eH\u0082@¢\u0006\u0004\b4\u0010/J+\u00109\u001a\u000607j\u0002`82\u0006\u00105\u001a\u00020\u00062\u0006\u00106\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u001eH\u0002¢\u0006\u0004\b9\u0010:J#\u0010<\u001a\u000e\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u00020;012\u0006\u00100\u001a\u00020\u001eH\u0002¢\u0006\u0004\b<\u0010=J\u0017\u0010?\u001a\u00020\u00142\u0006\u0010>\u001a\u000202H\u0002¢\u0006\u0004\b?\u0010@J \u0010A\u001a\u00020!2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u0011H\u0086@¢\u0006\u0004\bA\u0010#J\u000f\u0010B\u001a\u00020\u0014H\u0016¢\u0006\u0004\bB\u0010CR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010DR\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010ER\u001c\u0010\n\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010FR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010GR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010HR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010IR\u001a\u0010\u0012\u001a\u00020\u00118\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0012\u0010J\u001a\u0004\bK\u0010LR\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010MR\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010NR\u001a\u0010P\u001a\b\u0012\u0004\u0012\u00020\u001a0O8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bP\u0010QR\u0014\u0010R\u001a\u00020;8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bR\u0010SR\u0014\u0010U\u001a\u00020T8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bU\u0010V¨\u0006X"}, d2 = {"Lio/ktor/client/engine/cio/Endpoint;", "LUa/M;", "Ljava/io/Closeable;", "Lio/ktor/utils/io/core/Closeable;", "", "host", "", "port", "Ljava/net/Proxy;", "Lio/ktor/client/engine/ProxyConfig;", "proxy", "", "secure", "Lio/ktor/client/engine/cio/CIOEngineConfig;", "config", "Lio/ktor/client/engine/cio/ConnectionFactory;", "connectionFactory", "Lkotlin/coroutines/d;", "coroutineContext", "Lkotlin/Function0;", "LY8/t;", "onDone", "Lio/ktor/client/request/UnixSocketSettings;", "unixSocket", "<init>", "(Ljava/lang/String;ILjava/net/Proxy;ZLio/ktor/client/engine/cio/CIOEngineConfig;Lio/ktor/client/engine/cio/ConnectionFactory;Lkotlin/coroutines/d;Lp9/a;Lio/ktor/client/request/UnixSocketSettings;)V", "Lio/ktor/client/engine/cio/RequestTask;", "task", "makePipelineRequest", "(Lio/ktor/client/engine/cio/RequestTask;Le9/c;)Ljava/lang/Object;", "Lio/ktor/client/request/HttpRequestData;", "request", "callContext", "Lio/ktor/client/request/HttpResponseData;", "makeDedicatedRequest", "(Lio/ktor/client/request/HttpRequestData;Lkotlin/coroutines/d;Le9/c;)Ljava/lang/Object;", "Lio/ktor/utils/io/ByteReadChannel;", "input", "Lio/ktor/utils/io/ByteWriteChannel;", "output", "originOutput", "Lio/ktor/util/date/GMTDate;", "requestTime", "overProxy", "processExpectContinue", "(Lio/ktor/client/request/HttpRequestData;Lio/ktor/utils/io/ByteReadChannel;Lio/ktor/utils/io/ByteWriteChannel;Lio/ktor/utils/io/ByteWriteChannel;Lkotlin/coroutines/d;Lio/ktor/util/date/GMTDate;ZLe9/c;)Ljava/lang/Object;", "createPipeline", "(Lio/ktor/client/request/HttpRequestData;Le9/c;)Ljava/lang/Object;", "requestData", "Lkotlin/Pair;", "Lio/ktor/network/sockets/SocketAddress;", "Lio/ktor/network/sockets/Connection;", Constants.METHOD_CONNECT, "connectAttempts", "timeoutFails", "Ljava/lang/Exception;", "Lkotlin/Exception;", "getTimeoutException", "(IILio/ktor/client/request/HttpRequestData;)Ljava/lang/Exception;", "", "retrieveTimeouts", "(Lio/ktor/client/request/HttpRequestData;)Lkotlin/Pair;", Const.JSON_KEY_ADDRESS, "releaseConnection", "(Lio/ktor/network/sockets/SocketAddress;)V", "execute", "close", "()V", "Ljava/lang/String;", "I", "Ljava/net/Proxy;", "Z", "Lio/ktor/client/engine/cio/CIOEngineConfig;", "Lio/ktor/client/engine/cio/ConnectionFactory;", "Lkotlin/coroutines/d;", "getCoroutineContext", "()Lkotlin/coroutines/d;", "Lp9/a;", "Lio/ktor/client/request/UnixSocketSettings;", "LWa/g;", "deliveryPoint", "LWa/g;", "maxEndpointIdleTime", "J", "Lkotlinx/coroutines/g;", "timeout", "Lkotlinx/coroutines/g;", "Companion", "ktor-client-cio"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class Endpoint implements M, Closeable {
    public static final long CONTINUE_RESPONSE_TIMEOUT_MILLIS = 1000;
    private static final /* synthetic */ AtomicIntegerFieldUpdater connections$FU = AtomicIntegerFieldUpdater.newUpdater(Endpoint.class, "connections");
    private final CIOEngineConfig config;
    private final ConnectionFactory connectionFactory;
    private volatile /* synthetic */ int connections;
    private final kotlin.coroutines.d coroutineContext;
    private final Wa.g<RequestTask> deliveryPoint;
    private final String host;
    volatile /* synthetic */ long lastActivity;
    private final long maxEndpointIdleTime;
    private final InterfaceC5063a<t> onDone;
    private final int port;
    private final Proxy proxy;
    private final boolean secure;
    private final kotlinx.coroutines.g timeout;
    private final UnixSocketSettings unixSocket;

    @InterfaceC4112d(c = "io.ktor.client.engine.cio.Endpoint", f = "Endpoint.kt", l = {221, 223, 237, 251}, m = Constants.METHOD_CONNECT)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.client.engine.cio.Endpoint$connect$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        long J$0;
        long J$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Endpoint.this.connect(null, this);
        }
    }

    @InterfaceC4112d(c = "io.ktor.client.engine.cio.Endpoint", f = "Endpoint.kt", l = {184}, m = "createPipeline")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.client.engine.cio.Endpoint$createPipeline$1, reason: invalid class name and case insensitive filesystem */
    public static final class C42021 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C42021(InterfaceC4014c<? super C42021> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Endpoint.this.createPipeline(null, this);
        }
    }

    @InterfaceC4112d(c = "io.ktor.client.engine.cio.Endpoint", f = "Endpoint.kt", l = {67, 73, 74}, m = "execute")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.client.engine.cio.Endpoint$execute$1, reason: invalid class name and case insensitive filesystem */
    public static final class C42031 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public C42031(InterfaceC4014c<? super C42031> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Endpoint.this.execute(null, null, this);
        }
    }

    @InterfaceC4112d(c = "io.ktor.client.engine.cio.Endpoint", f = "Endpoint.kt", l = {102, 131, 133, 134}, m = "makeDedicatedRequest")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.client.engine.cio.Endpoint$makeDedicatedRequest$1, reason: invalid class name and case insensitive filesystem */
    public static final class C42041 extends ContinuationImpl {
        int I$0;
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        int label;
        /* synthetic */ Object result;

        public C42041(InterfaceC4014c<? super C42041> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Endpoint.this.makeDedicatedRequest(null, null, this);
        }
    }

    @InterfaceC4112d(c = "io.ktor.client.engine.cio.Endpoint", f = "Endpoint.kt", l = {87, 94}, m = "makePipelineRequest")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.client.engine.cio.Endpoint$makePipelineRequest$1, reason: invalid class name and case insensitive filesystem */
    public static final class C42051 extends ContinuationImpl {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C42051(InterfaceC4014c<? super C42051> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Endpoint.this.makePipelineRequest(null, this);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "Lio/ktor/client/request/HttpResponseData;", "<anonymous>", "(LUa/M;)Lio/ktor/client/request/HttpResponseData;"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "io.ktor.client.engine.cio.Endpoint$processExpectContinue$2", f = "Endpoint.kt", l = {F.GESTURE_HEIGHT_DP, 152, 157, 164, 168, DidiCardView.FINISHED_TITLE_TRAILING_WIDTH_DP, 177, 180}, m = "invokeSuspend")
    /* renamed from: io.ktor.client.engine.cio.Endpoint$processExpectContinue$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements p<M, InterfaceC4014c<? super HttpResponseData>, Object> {
        final /* synthetic */ kotlin.coroutines.d $callContext;
        final /* synthetic */ ByteReadChannel $input;
        final /* synthetic */ ByteWriteChannel $originOutput;
        final /* synthetic */ ByteWriteChannel $output;
        final /* synthetic */ boolean $overProxy;
        final /* synthetic */ HttpRequestData $request;
        final /* synthetic */ GMTDate $requestTime;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(HttpRequestData httpRequestData, ByteWriteChannel byteWriteChannel, boolean z10, GMTDate gMTDate, ByteReadChannel byteReadChannel, ByteWriteChannel byteWriteChannel2, kotlin.coroutines.d dVar, InterfaceC4014c<? super AnonymousClass2> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$request = httpRequestData;
            this.$output = byteWriteChannel;
            this.$overProxy = z10;
            this.$requestTime = gMTDate;
            this.$input = byteReadChannel;
            this.$originOutput = byteWriteChannel2;
            this.$callContext = dVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new AnonymousClass2(this.$request, this.$output, this.$overProxy, this.$requestTime, this.$input, this.$originOutput, this.$callContext, interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(M m10, InterfaceC4014c<? super HttpResponseData> interfaceC4014c) {
            return ((AnonymousClass2) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0078 A[PHI: r7 r12
          0x0078: PHI (r7v3 io.ktor.client.engine.cio.Endpoint$processExpectContinue$2) = 
          (r7v1 io.ktor.client.engine.cio.Endpoint$processExpectContinue$2)
          (r7v6 io.ktor.client.engine.cio.Endpoint$processExpectContinue$2)
         binds: [B:20:0x0074, B:14:0x0041] A[DONT_GENERATE, DONT_INLINE]
          0x0078: PHI (r12v5 java.lang.Object) = (r12v4 java.lang.Object), (r12v0 java.lang.Object) binds: [B:20:0x0074, B:14:0x0041] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:24:0x007d  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x00ac  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x00f0  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x012f  */
        /* JADX WARN: Removed duplicated region for block: B:44:0x0149 A[PHI: r1 r7
          0x0149: PHI (r1v8 java.lang.Boolean) = (r1v2 java.lang.Boolean), (r1v3 java.lang.Boolean), (r1v3 java.lang.Boolean), (r1v10 java.lang.Boolean) binds: [B:42:0x0146, B:35:0x0117, B:30:0x00ec, B:12:0x002e] A[DONT_GENERATE, DONT_INLINE]
          0x0149: PHI (r7v11 io.ktor.client.engine.cio.Endpoint$processExpectContinue$2) = 
          (r7v3 io.ktor.client.engine.cio.Endpoint$processExpectContinue$2)
          (r7v7 io.ktor.client.engine.cio.Endpoint$processExpectContinue$2)
          (r7v9 io.ktor.client.engine.cio.Endpoint$processExpectContinue$2)
          (r7v13 io.ktor.client.engine.cio.Endpoint$processExpectContinue$2)
         binds: [B:42:0x0146, B:35:0x0117, B:30:0x00ec, B:12:0x002e] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:46:0x0168 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:47:0x0169 A[RETURN] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r12) throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 384
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.engine.cio.Endpoint.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public Endpoint(String host, int i10, Proxy proxy, boolean z10, CIOEngineConfig config, ConnectionFactory connectionFactory, kotlin.coroutines.d coroutineContext, InterfaceC5063a<t> onDone, UnixSocketSettings unixSocketSettings) {
        kotlin.jvm.internal.p.i(host, "host");
        kotlin.jvm.internal.p.i(config, "config");
        kotlin.jvm.internal.p.i(connectionFactory, "connectionFactory");
        kotlin.jvm.internal.p.i(coroutineContext, "coroutineContext");
        kotlin.jvm.internal.p.i(onDone, "onDone");
        this.host = host;
        this.port = i10;
        this.proxy = proxy;
        this.secure = z10;
        this.config = config;
        this.connectionFactory = connectionFactory;
        this.coroutineContext = coroutineContext;
        this.onDone = onDone;
        this.unixSocket = unixSocketSettings;
        this.lastActivity = DateJvmKt.getTimeMillis();
        this.connections = 0;
        this.deliveryPoint = Wa.j.b(0, null, null, 7, null);
        this.maxEndpointIdleTime = 2 * config.getEndpoint().getConnectTimeout();
        this.timeout = C1060i.d(this, getCoroutineContext().plus(new CoroutineName("cio-endpoint-timeout")), null, new Endpoint$timeout$1(this, null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x02ce, code lost:
    
        if (r0 == r6) goto L93;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:103:0x02f3  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0127 A[Catch: all -> 0x00c0, TRY_ENTER, TryCatch #0 {all -> 0x00c0, blocks: (B:99:0x02e7, B:100:0x02ec, B:27:0x00ab, B:53:0x01bd, B:55:0x01c1, B:36:0x0127, B:38:0x012b, B:41:0x0142, B:43:0x0151, B:47:0x017f, B:49:0x018c, B:40:0x0138, B:32:0x00df), top: B:106:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01c1 A[Catch: all -> 0x00c0, TRY_LEAVE, TryCatch #0 {all -> 0x00c0, blocks: (B:99:0x02e7, B:100:0x02ec, B:27:0x00ab, B:53:0x01bd, B:55:0x01c1, B:36:0x0127, B:38:0x012b, B:41:0x0142, B:43:0x0151, B:47:0x017f, B:49:0x018c, B:40:0x0138, B:32:0x00df), top: B:106:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01e9 A[Catch: all -> 0x0054, TryCatch #1 {all -> 0x0054, blocks: (B:15:0x004f, B:94:0x02d1, B:78:0x0257, B:80:0x025b, B:82:0x025f, B:84:0x0263, B:91:0x0290, B:88:0x026f, B:89:0x0276, B:90:0x0277, B:96:0x02dc, B:97:0x02e3, B:58:0x01df, B:60:0x01e9, B:62:0x01ee, B:64:0x01f2, B:67:0x01fb), top: B:106:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01ee A[Catch: all -> 0x0054, TryCatch #1 {all -> 0x0054, blocks: (B:15:0x004f, B:94:0x02d1, B:78:0x0257, B:80:0x025b, B:82:0x025f, B:84:0x0263, B:91:0x0290, B:88:0x026f, B:89:0x0276, B:90:0x0277, B:96:0x02dc, B:97:0x02e3, B:58:0x01df, B:60:0x01e9, B:62:0x01ee, B:64:0x01f2, B:67:0x01fb), top: B:106:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x025b A[Catch: all -> 0x0054, TryCatch #1 {all -> 0x0054, blocks: (B:15:0x004f, B:94:0x02d1, B:78:0x0257, B:80:0x025b, B:82:0x025f, B:84:0x0263, B:91:0x0290, B:88:0x026f, B:89:0x0276, B:90:0x0277, B:96:0x02dc, B:97:0x02e3, B:58:0x01df, B:60:0x01e9, B:62:0x01ee, B:64:0x01f2, B:67:0x01fb), top: B:106:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x02dc A[Catch: all -> 0x0054, TryCatch #1 {all -> 0x0054, blocks: (B:15:0x004f, B:94:0x02d1, B:78:0x0257, B:80:0x025b, B:82:0x025f, B:84:0x0263, B:91:0x0290, B:88:0x026f, B:89:0x0276, B:90:0x0277, B:96:0x02dc, B:97:0x02e3, B:58:0x01df, B:60:0x01e9, B:62:0x01ee, B:64:0x01f2, B:67:0x01fb), top: B:106:0x0029 }] */
    /* JADX WARN: Type inference failed for: r2v4, types: [io.ktor.client.engine.cio.ConnectionFactory] */
    /* JADX WARN: Type inference failed for: r3v0, types: [int] */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v21 */
    /* JADX WARN: Type inference failed for: r3v7, types: [io.ktor.network.sockets.Socket, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v2, types: [io.ktor.network.sockets.SocketAddress] */
    /* JADX WARN: Type inference failed for: r4v21 */
    /* JADX WARN: Type inference failed for: r4v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:52:0x01af -> B:53:0x01bd). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object connect(io.ktor.client.request.HttpRequestData r24, e9.InterfaceC4014c<? super kotlin.Pair<? extends io.ktor.network.sockets.SocketAddress, io.ktor.network.sockets.Connection>> r25) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 767
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.engine.cio.Endpoint.connect(io.ktor.client.request.HttpRequestData, e9.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t connect$lambda$3$lambda$2(Endpoint endpoint, InetSocketAddress inetSocketAddress, TLSConfigBuilder tls) {
        kotlin.jvm.internal.p.i(tls, "$this$tls");
        TLSConfigBuilderKt.takeFrom(tls, endpoint.config.getHttps());
        String serverName = tls.getServerName();
        if (serverName == null) {
            serverName = inetSocketAddress.getHostname();
        }
        tls.setServerName(serverName);
        return t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object createPipeline(io.ktor.client.request.HttpRequestData r13, e9.InterfaceC4014c<? super Y8.t> r14) throws java.lang.Exception {
        /*
            r12 = this;
            boolean r0 = r14 instanceof io.ktor.client.engine.cio.Endpoint.C42021
            if (r0 == 0) goto L13
            r0 = r14
            io.ktor.client.engine.cio.Endpoint$createPipeline$1 r0 = (io.ktor.client.engine.cio.Endpoint.C42021) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.client.engine.cio.Endpoint$createPipeline$1 r0 = new io.ktor.client.engine.cio.Endpoint$createPipeline$1
            r0.<init>(r14)
        L18:
            java.lang.Object r14 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r13 = r0.L$0
            io.ktor.client.request.HttpRequestData r13 = (io.ktor.client.request.HttpRequestData) r13
            kotlin.C4849c.b(r14)
            goto L47
        L2d:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L35:
            kotlin.C4849c.b(r14)
            java.lang.Object r14 = g9.h.a(r13)
            r0.L$0 = r14
            r0.label = r3
            java.lang.Object r14 = r12.connect(r13, r0)
            if (r14 != r1) goto L47
            return r1
        L47:
            kotlin.Pair r14 = (kotlin.Pair) r14
            java.lang.Object r13 = r14.a()
            io.ktor.network.sockets.SocketAddress r13 = (io.ktor.network.sockets.SocketAddress) r13
            java.lang.Object r14 = r14.b()
            r8 = r14
            io.ktor.network.sockets.Connection r8 = (io.ktor.network.sockets.Connection) r8
            io.ktor.client.engine.cio.ConnectionPipeline r4 = new io.ktor.client.engine.cio.ConnectionPipeline
            io.ktor.client.engine.cio.CIOEngineConfig r14 = r12.config
            io.ktor.client.engine.cio.EndpointConfig r14 = r14.getEndpoint()
            long r5 = r14.getKeepAliveTime()
            io.ktor.client.engine.cio.CIOEngineConfig r14 = r12.config
            io.ktor.client.engine.cio.EndpointConfig r14 = r14.getEndpoint()
            int r7 = r14.getPipelineMaxSize()
            java.net.Proxy r14 = r12.proxy
            if (r14 == 0) goto L72
        L70:
            r9 = r3
            goto L74
        L72:
            r3 = 0
            goto L70
        L74:
            Wa.g<io.ktor.client.engine.cio.RequestTask> r10 = r12.deliveryPoint
            kotlin.coroutines.d r11 = r12.getCoroutineContext()
            r4.<init>(r5, r7, r8, r9, r10, r11)
            kotlinx.coroutines.g r14 = r4.getPipelineContext()
            io.ktor.client.engine.cio.g r0 = new io.ktor.client.engine.cio.g
            r0.<init>()
            r14.J(r0)
            Y8.t r12 = Y8.t.f7040a
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.engine.cio.Endpoint.createPipeline(io.ktor.client.request.HttpRequestData, e9.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t createPipeline$lambda$1(Endpoint endpoint, SocketAddress socketAddress, Throwable th) {
        endpoint.releaseConnection(socketAddress);
        return t.f7040a;
    }

    private final Exception getTimeoutException(int connectAttempts, int timeoutFails, HttpRequestData request) {
        return timeoutFails == connectAttempts ? HttpTimeoutKt.ConnectTimeoutException$default(request, null, 2, null) : new FailToConnectException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(14:0|2|(2:4|(1:6)(1:8))(0)|7|9|(1:85)|(3:(1:(1:(1:(4:15|16|65|66)(2:20|21))(8:22|86|23|24|75|61|(3:64|65|66)|63))(4:27|28|51|52))(4:30|81|31|32)|73|74)(4:35|36|(1:39)|63)|83|40|(1:42)(1:43)|44|(7:79|46|47|48|(1:50)|51|52)(5:55|56|77|57|(4:60|75|61|(0)))|63|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0236, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0237, code lost:
    
        r4 = r10;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:64:0x022d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object makeDedicatedRequest(io.ktor.client.request.HttpRequestData r20, kotlin.coroutines.d r21, e9.InterfaceC4014c<? super io.ktor.client.request.HttpResponseData> r22) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 573
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.engine.cio.Endpoint.makeDedicatedRequest(io.ktor.client.request.HttpRequestData, kotlin.coroutines.d, e9.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t makeDedicatedRequest$lambda$0(ByteReadChannel byteReadChannel, ByteWriteChannel byteWriteChannel, Connection connection, Endpoint endpoint, SocketAddress socketAddress, Throwable th) {
        Throwable thUnwrapCancellationException = th != null ? ExceptionUtilsJvmKt.unwrapCancellationException(th) : null;
        try {
            byteReadChannel.cancel(thUnwrapCancellationException);
            ByteWriteChannelOperationsKt.close(byteWriteChannel, thUnwrapCancellationException);
            connection.getSocket().close();
        } finally {
            try {
                return t.f7040a;
            } finally {
            }
        }
        return t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0091, code lost:
    
        if (r5.send(r6, r0) != r1) goto L35;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object makePipelineRequest(io.ktor.client.engine.cio.RequestTask r6, e9.InterfaceC4014c<? super Y8.t> r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof io.ktor.client.engine.cio.Endpoint.C42051
            if (r0 == 0) goto L13
            r0 = r7
            io.ktor.client.engine.cio.Endpoint$makePipelineRequest$1 r0 = (io.ktor.client.engine.cio.Endpoint.C42051) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.client.engine.cio.Endpoint$makePipelineRequest$1 r0 = new io.ktor.client.engine.cio.Endpoint$makePipelineRequest$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L47
            if (r2 == r4) goto L38
            if (r2 != r3) goto L30
            java.lang.Object r5 = r0.L$0
            io.ktor.client.engine.cio.RequestTask r5 = (io.ktor.client.engine.cio.RequestTask) r5
            kotlin.C4849c.b(r7)
            goto L94
        L30:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L38:
            int r6 = r0.I$0
            java.lang.Object r2 = r0.L$0
            io.ktor.client.engine.cio.RequestTask r2 = (io.ktor.client.engine.cio.RequestTask) r2
            kotlin.C4849c.b(r7)     // Catch: java.lang.Throwable -> L44
            r7 = r6
            r6 = r2
            goto L81
        L44:
            r5 = move-exception
            r6 = r2
            goto L79
        L47:
            kotlin.C4849c.b(r7)
            Wa.g<io.ktor.client.engine.cio.RequestTask> r7 = r5.deliveryPoint
            java.lang.Object r7 = r7.mo0trySendJP2dKIU(r6)
            boolean r7 = kotlinx.coroutines.channels.a.j(r7)
            if (r7 == 0) goto L59
            Y8.t r5 = Y8.t.f7040a
            return r5
        L59:
            int r7 = r5.connections
            io.ktor.client.engine.cio.CIOEngineConfig r2 = r5.config
            io.ktor.client.engine.cio.EndpointConfig r2 = r2.getEndpoint()
            int r2 = r2.getMaxConnectionsPerRoute()
            if (r7 >= r2) goto L81
            io.ktor.client.request.HttpRequestData r2 = r6.getRequest()     // Catch: java.lang.Throwable -> L78
            r0.L$0 = r6     // Catch: java.lang.Throwable -> L78
            r0.I$0 = r7     // Catch: java.lang.Throwable -> L78
            r0.label = r4     // Catch: java.lang.Throwable -> L78
            java.lang.Object r2 = r5.createPipeline(r2, r0)     // Catch: java.lang.Throwable -> L78
            if (r2 != r1) goto L81
            goto L93
        L78:
            r5 = move-exception
        L79:
            Ua.u r6 = r6.getResponse()
            r6.e(r5)
            throw r5
        L81:
            Wa.g<io.ktor.client.engine.cio.RequestTask> r5 = r5.deliveryPoint
            java.lang.Object r2 = g9.h.a(r6)
            r0.L$0 = r2
            r0.I$0 = r7
            r0.label = r3
            java.lang.Object r5 = r5.send(r6, r0)
            if (r5 != r1) goto L94
        L93:
            return r1
        L94:
            Y8.t r5 = Y8.t.f7040a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.engine.cio.Endpoint.makePipelineRequest(io.ktor.client.engine.cio.RequestTask, e9.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object processExpectContinue(HttpRequestData httpRequestData, ByteReadChannel byteReadChannel, ByteWriteChannel byteWriteChannel, ByteWriteChannel byteWriteChannel2, kotlin.coroutines.d dVar, GMTDate gMTDate, boolean z10, InterfaceC4014c<? super HttpResponseData> interfaceC4014c) {
        return C1056g.j(dVar, new AnonymousClass2(httpRequestData, byteWriteChannel, z10, gMTDate, byteReadChannel, byteWriteChannel2, dVar, null), interfaceC4014c);
    }

    private final void releaseConnection(SocketAddress address) {
        this.connectionFactory.release(address);
        connections$FU.decrementAndGet(this);
    }

    private final Pair<Long, Long> retrieveTimeouts(HttpRequestData requestData) {
        Pair<Long, Long> pairA = Y8.j.a(Long.valueOf(this.config.getEndpoint().getConnectTimeout()), Long.valueOf(this.config.getEndpoint().getSocketTimeout()));
        HttpTimeoutConfig httpTimeoutConfig = (HttpTimeoutConfig) requestData.getCapabilityOrNull(HttpTimeoutCapability.INSTANCE);
        if (httpTimeoutConfig == null) {
            return pairA;
        }
        Long l10 = httpTimeoutConfig.get_socketTimeoutMillis();
        long jLongValue = l10 != null ? l10.longValue() : this.config.getEndpoint().getSocketTimeout();
        Long l11 = httpTimeoutConfig.get_connectTimeoutMillis();
        return Y8.j.a(Long.valueOf(l11 != null ? l11.longValue() : this.config.getEndpoint().getConnectTimeout()), Long.valueOf(jLongValue));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        kotlinx.coroutines.g.Y0(this.timeout, null, 1, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r8v4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object execute(io.ktor.client.request.HttpRequestData r9, kotlin.coroutines.d r10, e9.InterfaceC4014c<? super io.ktor.client.request.HttpResponseData> r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 230
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.engine.cio.Endpoint.execute(io.ktor.client.request.HttpRequestData, kotlin.coroutines.d, e9.c):java.lang.Object");
    }

    @Override // Ua.M
    public kotlin.coroutines.d getCoroutineContext() {
        return this.coroutineContext;
    }
}
