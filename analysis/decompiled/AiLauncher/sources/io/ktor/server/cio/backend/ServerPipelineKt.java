package io.ktor.server.cio.backend;

import Ua.C1060i;
import Ua.M;
import Y8.t;
import e9.InterfaceC4014c;
import fb.v;
import g9.InterfaceC4112d;
import io.ktor.http.HttpProtocolVersion;
import io.ktor.http.HttpStatusCode;
import io.ktor.http.cio.ConnectionOptions;
import io.ktor.http.cio.Request;
import io.ktor.http.cio.RequestResponseBuilder;
import io.ktor.server.cio.PipelineKt;
import io.ktor.util.logging.KtorSimpleLoggerJvmKt;
import io.ktor.utils.io.InternalAPI;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.p;
import p9.q;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aQ\u0010\u0010\u001a\u00020\r*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032,\u0010\f\u001a(\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0005j\u0002`\u000bH\u0007¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u001e\u0010\u0014\u001a\u00020\t2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0082@¢\u0006\u0004\b\u0014\u0010\u0015\u001a.\u0010\u001a\u001a\u00020\t2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00120\u00162\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0082@¢\u0006\u0004\b\u0018\u0010\u0019\u001a!\u0010 \u001a\u00020\u001f2\u0006\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0000¢\u0006\u0004\b \u0010!\"\u0018\u0010$\u001a\u00060\"j\u0002`#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%\"\u0014\u0010'\u001a\u00020&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(¨\u0006)"}, d2 = {"LUa/M;", "Lio/ktor/server/cio/backend/ServerIncomingConnection;", "connection", "Lkotlin/time/a;", "timeout", "Lkotlin/Function3;", "Lio/ktor/server/cio/backend/ServerRequestScope;", "Lio/ktor/http/cio/Request;", "Le9/c;", "LY8/t;", "", "Lio/ktor/server/cio/HttpRequestHandler;", "handler", "Lkotlinx/coroutines/g;", "startServerConnectionPipeline-exY8QGI", "(LUa/M;Lio/ktor/server/cio/backend/ServerIncomingConnection;JLp9/q;)Lkotlinx/coroutines/g;", "startServerConnectionPipeline", "LWa/g;", "Lio/ktor/utils/io/ByteReadChannel;", "actorChannel", "respondBadRequest", "(LWa/g;Le9/c;)Ljava/lang/Object;", "LWa/r;", "channel", "pipelineWriterLoop-dWUq8MI", "(LWa/r;JLio/ktor/server/cio/backend/ServerIncomingConnection;Le9/c;)Ljava/lang/Object;", "pipelineWriterLoop", "Lio/ktor/http/HttpProtocolVersion;", "version", "Lio/ktor/http/cio/ConnectionOptions;", "connectionOptions", "", "isLastHttpRequest", "(Lio/ktor/http/HttpProtocolVersion;Lio/ktor/http/cio/ConnectionOptions;)Z", "Lvc/c;", "Lio/ktor/util/logging/Logger;", "LOGGER", "Lvc/c;", "Lfb/v;", "BadRequestPacket", "Lfb/v;", "ktor-server-cio"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ServerPipelineKt {
    private static final v BadRequestPacket;
    private static final vc.c LOGGER = KtorSimpleLoggerJvmKt.KtorSimpleLogger("io.ktor.server.cio.backend.ServerPipeline");

    @InterfaceC4112d(c = "io.ktor.server.cio.backend.ServerPipelineKt", f = "ServerPipeline.kt", l = {195}, m = "respondBadRequest")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: io.ktor.server.cio.backend.ServerPipelineKt$respondBadRequest$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ServerPipelineKt.respondBadRequest(null, this);
        }
    }

    static {
        RequestResponseBuilder requestResponseBuilder = new RequestResponseBuilder();
        requestResponseBuilder.responseLine("HTTP/1.0", HttpStatusCode.INSTANCE.getBadRequest().getValue(), "Bad Request");
        requestResponseBuilder.headerLine(com.stepos.statsapp.v3.lib.plugin.net.multipart.e.f30851j, "close");
        requestResponseBuilder.emptyLine();
        BadRequestPacket = requestResponseBuilder.build();
    }

    public static final boolean isLastHttpRequest(HttpProtocolVersion version, ConnectionOptions connectionOptions) {
        p.i(version, "version");
        if (connectionOptions == null && p.d(version, HttpProtocolVersion.INSTANCE.getHTTP_1_0())) {
            return true;
        }
        return connectionOptions == null ? !p.d(version, HttpProtocolVersion.INSTANCE.getHTTP_1_1()) : !connectionOptions.getKeepAlive() && connectionOptions.getClose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00be, code lost:
    
        if (r12.flush(r0) != r1) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0076, code lost:
    
        r11 = r7;
        r0 = r2;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:28:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0097 A[Catch: all -> 0x003f, TRY_ENTER, TryCatch #0 {all -> 0x003f, blocks: (B:14:0x0039, B:33:0x0097, B:36:0x00ac, B:21:0x005f), top: B:43:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r8v0, types: [Wa.r<? extends io.ktor.utils.io.ByteReadChannel>] */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v16 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v4, types: [long] */
    /* JADX WARN: Type inference failed for: r8v6, types: [Wa.r, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r8v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x00be -> B:15:0x003c). Please report as a decompilation issue!!! */
    /* renamed from: pipelineWriterLoop-dWUq8MI, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object m170pipelineWriterLoopdWUq8MI(Wa.r<? extends io.ktor.utils.io.ByteReadChannel> r8, long r9, io.ktor.server.cio.backend.ServerIncomingConnection r11, e9.InterfaceC4014c<? super Y8.t> r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 205
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.server.cio.backend.ServerPipelineKt.m170pipelineWriterLoopdWUq8MI(Wa.r, long, io.ktor.server.cio.backend.ServerIncomingConnection, e9.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object respondBadRequest(Wa.g<io.ktor.utils.io.ByteReadChannel> r5, e9.InterfaceC4014c<? super Y8.t> r6) throws java.lang.Throwable {
        /*
            boolean r0 = r6 instanceof io.ktor.server.cio.backend.ServerPipelineKt.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r6
            io.ktor.server.cio.backend.ServerPipelineKt$respondBadRequest$1 r0 = (io.ktor.server.cio.backend.ServerPipelineKt.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.server.cio.backend.ServerPipelineKt$respondBadRequest$1 r0 = new io.ktor.server.cio.backend.ServerPipelineKt$respondBadRequest$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L3a
            if (r2 != r4) goto L32
            java.lang.Object r5 = r0.L$1
            io.ktor.utils.io.ByteChannel r5 = (io.ktor.utils.io.ByteChannel) r5
            java.lang.Object r0 = r0.L$0
            Wa.g r0 = (Wa.g) r0
            kotlin.C4849c.b(r6)
            goto L62
        L32:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3a:
            kotlin.C4849c.b(r6)
            io.ktor.utils.io.ByteChannel r6 = new io.ktor.utils.io.ByteChannel
            r2 = 0
            r6.<init>(r2, r4, r3)
            java.lang.Object r2 = r5.mo0trySendJP2dKIU(r6)
            boolean r2 = kotlinx.coroutines.channels.a.j(r2)
            if (r2 == 0) goto L66
            fb.v r2 = io.ktor.server.cio.backend.ServerPipelineKt.BadRequestPacket
            fb.v r2 = io.ktor.utils.io.core.ByteReadPacketKt.copy(r2)
            r0.L$0 = r5
            r0.L$1 = r6
            r0.label = r4
            java.lang.Object r0 = io.ktor.utils.io.ByteWriteChannelOperationsKt.writePacket(r6, r2, r0)
            if (r0 != r1) goto L60
            return r1
        L60:
            r0 = r5
            r5 = r6
        L62:
            r5.close()
            r5 = r0
        L66:
            Wa.s.a.a(r5, r3, r4, r3)
            Y8.t r5 = Y8.t.f7040a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.server.cio.backend.ServerPipelineKt.respondBadRequest(Wa.g, e9.c):java.lang.Object");
    }

    @InternalAPI
    /* renamed from: startServerConnectionPipeline-exY8QGI, reason: not valid java name */
    public static final kotlinx.coroutines.g m171startServerConnectionPipelineexY8QGI(M startServerConnectionPipeline, ServerIncomingConnection connection, long j10, q<? super ServerRequestScope, ? super Request, ? super InterfaceC4014c<? super t>, ? extends Object> handler) {
        p.i(startServerConnectionPipeline, "$this$startServerConnectionPipeline");
        p.i(connection, "connection");
        p.i(handler, "handler");
        return C1060i.d(startServerConnectionPipeline, PipelineKt.getHttpPipelineCoroutine(), null, new ServerPipelineKt$startServerConnectionPipeline$1(connection, j10, handler, null), 2, null);
    }
}
