package io.ktor.server.cio;

import Ua.InterfaceC1083u;
import Ua.M;
import Ua.Y;
import Y8.t;
import Z8.C1173v;
import Z8.F;
import com.stepos.aiengine.args.SingleFileBundle;
import com.stepos.ame.sdk.SkillStoreKt;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import io.ktor.http.HeadersBuilder;
import io.ktor.http.HttpHeaders;
import io.ktor.http.HttpStatusCode;
import io.ktor.http.cio.ChunkedTransferEncodingKt;
import io.ktor.server.engine.BaseApplicationResponse;
import io.ktor.server.response.ResponseHeaders;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.utils.io.ReaderJob;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.g;
import p9.p;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b\u0012\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\fH\u0082@¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0004H\u0094@¢\u0006\u0004\b\u0016\u0010\u0017J\u0018\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u0018H\u0094@¢\u0006\u0004\b\u001a\u0010\u001bJ\u0018\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u001cH\u0094@¢\u0006\u0004\b\u001e\u0010\u001fJ\u0018\u0010\"\u001a\u00020\u00112\u0006\u0010!\u001a\u00020 H\u0094@¢\u0006\u0004\b\"\u0010#J\u0018\u0010%\u001a\u00020\u00112\u0006\u0010!\u001a\u00020$H\u0094@¢\u0006\u0004\b%\u0010&J\u0017\u0010)\u001a\u00020\u00112\u0006\u0010(\u001a\u00020'H\u0014¢\u0006\u0004\b)\u0010*R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010+R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010,R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010-R\u0014\u0010\n\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010-R\u001c\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010.R\u0016\u0010(\u001a\u00020'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010/R\u0014\u00101\u001a\u0002008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0018\u00103\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u0010+R\u0018\u00105\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u001a\u00108\u001a\u0002078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010;¨\u0006<"}, d2 = {"Lio/ktor/server/cio/CIOApplicationResponse;", "Lio/ktor/server/engine/BaseApplicationResponse;", "Lio/ktor/server/cio/CIOApplicationCall;", "call", "Lio/ktor/utils/io/ByteWriteChannel;", "output", "Lio/ktor/utils/io/ByteReadChannel;", "input", "Lkotlin/coroutines/d;", "engineDispatcher", "userDispatcher", "LUa/u;", "", "upgraded", "<init>", "(Lio/ktor/server/cio/CIOApplicationCall;Lio/ktor/utils/io/ByteWriteChannel;Lio/ktor/utils/io/ByteReadChannel;Lkotlin/coroutines/d;Lkotlin/coroutines/d;LUa/u;)V", "contentReady", "LY8/t;", "sendResponseMessage", "(ZLe9/c;)Ljava/lang/Object;", "preparedBodyChannel", "()Lio/ktor/utils/io/ByteWriteChannel;", "responseChannel", "(Le9/c;)Ljava/lang/Object;", "Lio/ktor/http/content/OutgoingContent$ProtocolUpgrade;", "upgrade", "respondUpgrade", "(Lio/ktor/http/content/OutgoingContent$ProtocolUpgrade;Le9/c;)Ljava/lang/Object;", "", SingleFileBundle.KEY_BYTES, "respondFromBytes", "([BLe9/c;)Ljava/lang/Object;", "Lio/ktor/http/content/OutgoingContent$NoContent;", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "respondNoContent", "(Lio/ktor/http/content/OutgoingContent$NoContent;Le9/c;)Ljava/lang/Object;", "Lio/ktor/http/content/OutgoingContent;", "respondOutgoingContent", "(Lio/ktor/http/content/OutgoingContent;Le9/c;)Ljava/lang/Object;", "Lio/ktor/http/HttpStatusCode;", "statusCode", "setStatus", "(Lio/ktor/http/HttpStatusCode;)V", "Lio/ktor/utils/io/ByteWriteChannel;", "Lio/ktor/utils/io/ByteReadChannel;", "Lkotlin/coroutines/d;", "LUa/u;", "Lio/ktor/http/HttpStatusCode;", "Lio/ktor/http/HeadersBuilder;", "headersBuilder", "Lio/ktor/http/HeadersBuilder;", "chunkedChannel", "Lkotlinx/coroutines/g;", "chunkedJob", "Lkotlinx/coroutines/g;", "Lio/ktor/server/response/ResponseHeaders;", "headers", "Lio/ktor/server/response/ResponseHeaders;", "getHeaders", "()Lio/ktor/server/response/ResponseHeaders;", "ktor-server-cio"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CIOApplicationResponse extends BaseApplicationResponse {
    private ByteWriteChannel chunkedChannel;
    private g chunkedJob;
    private final kotlin.coroutines.d engineDispatcher;
    private final ResponseHeaders headers;
    private final HeadersBuilder headersBuilder;
    private final ByteReadChannel input;
    private final ByteWriteChannel output;
    private HttpStatusCode statusCode;
    private final InterfaceC1083u<Boolean> upgraded;
    private final kotlin.coroutines.d userDispatcher;

    @InterfaceC4112d(c = "io.ktor.server.cio.CIOApplicationResponse", f = "CIOApplicationResponse.kt", l = {63, 65}, m = "respondFromBytes")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: io.ktor.server.cio.CIOApplicationResponse$respondFromBytes$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CIOApplicationResponse.this.respondFromBytes(null, this);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 1, 0})
    @InterfaceC4112d(c = "io.ktor.server.cio.CIOApplicationResponse$respondFromBytes$2", f = "CIOApplicationResponse.kt", l = {66, 67}, m = "invokeSuspend")
    /* renamed from: io.ktor.server.cio.CIOApplicationResponse$respondFromBytes$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {
        final /* synthetic */ byte[] $bytes;
        final /* synthetic */ ByteWriteChannel $channel;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(ByteWriteChannel byteWriteChannel, byte[] bArr, InterfaceC4014c<? super AnonymousClass2> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$channel = byteWriteChannel;
            this.$bytes = bArr;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new AnonymousClass2(this.$channel, this.$bytes, interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
            return ((AnonymousClass2) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x003d, code lost:
        
            if (r10.flushAndClose(r7) == r0) goto L15;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r11) throws java.lang.Throwable {
            /*
                r10 = this;
                java.lang.Object r0 = f9.C4063a.g()
                int r1 = r10.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L1f
                if (r1 == r3) goto L1a
                if (r1 != r2) goto L12
                kotlin.C4849c.b(r11)
                goto L40
            L12:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r11)
                throw r10
            L1a:
                kotlin.C4849c.b(r11)
                r7 = r10
                goto L35
            L1f:
                kotlin.C4849c.b(r11)
                r11 = r3
                io.ktor.utils.io.ByteWriteChannel r3 = r10.$channel
                byte[] r4 = r10.$bytes
                r10.label = r11
                r5 = 0
                r6 = 0
                r8 = 6
                r9 = 0
                r7 = r10
                java.lang.Object r10 = io.ktor.utils.io.ByteWriteChannelOperationsKt.writeFully$default(r3, r4, r5, r6, r7, r8, r9)
                if (r10 != r0) goto L35
                goto L3f
            L35:
                io.ktor.utils.io.ByteWriteChannel r10 = r7.$channel
                r7.label = r2
                java.lang.Object r10 = r10.flushAndClose(r7)
                if (r10 != r0) goto L40
            L3f:
                return r0
            L40:
                Y8.t r10 = Y8.t.f7040a
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.server.cio.CIOApplicationResponse.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @InterfaceC4112d(c = "io.ktor.server.cio.CIOApplicationResponse", f = "CIOApplicationResponse.kt", l = {72, 73}, m = "respondNoContent")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: io.ktor.server.cio.CIOApplicationResponse$respondNoContent$1, reason: invalid class name and case insensitive filesystem */
    public static final class C43331 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public C43331(InterfaceC4014c<? super C43331> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CIOApplicationResponse.this.respondNoContent(null, this);
        }
    }

    @InterfaceC4112d(c = "io.ktor.server.cio.CIOApplicationResponse", f = "CIOApplicationResponse.kt", l = {86, 87, 88}, m = "respondOutgoingContent")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: io.ktor.server.cio.CIOApplicationResponse$respondOutgoingContent$1, reason: invalid class name and case insensitive filesystem */
    public static final class C43341 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public C43341(InterfaceC4014c<? super C43341> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CIOApplicationResponse.this.respondOutgoingContent(null, this);
        }
    }

    @InterfaceC4112d(c = "io.ktor.server.cio.CIOApplicationResponse", f = "CIOApplicationResponse.kt", l = {51, 54, 55, 57, 57}, m = "respondUpgrade")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: io.ktor.server.cio.CIOApplicationResponse$respondUpgrade$1, reason: invalid class name and case insensitive filesystem */
    public static final class C43351 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C43351(InterfaceC4014c<? super C43351> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CIOApplicationResponse.this.respondUpgrade(null, this);
        }
    }

    @InterfaceC4112d(c = "io.ktor.server.cio.CIOApplicationResponse", f = "CIOApplicationResponse.kt", l = {46}, m = "responseChannel")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: io.ktor.server.cio.CIOApplicationResponse$responseChannel$1, reason: invalid class name and case insensitive filesystem */
    public static final class C43361 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public C43361(InterfaceC4014c<? super C43361> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CIOApplicationResponse.this.responseChannel(this);
        }
    }

    @InterfaceC4112d(c = "io.ktor.server.cio.CIOApplicationResponse", f = "CIOApplicationResponse.kt", l = {105, 108}, m = "sendResponseMessage")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: io.ktor.server.cio.CIOApplicationResponse$sendResponseMessage$1, reason: invalid class name and case insensitive filesystem */
    public static final class C43371 extends ContinuationImpl {
        Object L$0;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        public C43371(InterfaceC4014c<? super C43371> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CIOApplicationResponse.this.sendResponseMessage(false, this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CIOApplicationResponse(CIOApplicationCall call, ByteWriteChannel output, ByteReadChannel input, kotlin.coroutines.d engineDispatcher, kotlin.coroutines.d userDispatcher, InterfaceC1083u<Boolean> interfaceC1083u) {
        super(call);
        kotlin.jvm.internal.p.i(call, "call");
        kotlin.jvm.internal.p.i(output, "output");
        kotlin.jvm.internal.p.i(input, "input");
        kotlin.jvm.internal.p.i(engineDispatcher, "engineDispatcher");
        kotlin.jvm.internal.p.i(userDispatcher, "userDispatcher");
        this.output = output;
        this.input = input;
        this.engineDispatcher = engineDispatcher;
        this.userDispatcher = userDispatcher;
        this.upgraded = interfaceC1083u;
        this.statusCode = HttpStatusCode.INSTANCE.getOK();
        this.headersBuilder = new HeadersBuilder(0, 1, null);
        this.headers = new ResponseHeaders() { // from class: io.ktor.server.cio.CIOApplicationResponse$headers$1
            @Override // io.ktor.server.response.ResponseHeaders
            public void engineAppendHeader(String name, String value) {
                kotlin.jvm.internal.p.i(name, "name");
                kotlin.jvm.internal.p.i(value, "value");
                this.this$0.headersBuilder.append(name, value);
            }

            @Override // io.ktor.server.response.ResponseHeaders
            public List<String> getEngineHeaderNames() {
                return F.m1(this.this$0.headersBuilder.names());
            }

            @Override // io.ktor.server.response.ResponseHeaders
            public List<String> getEngineHeaderValues(String name) {
                kotlin.jvm.internal.p.i(name, "name");
                List<String> all = this.this$0.headersBuilder.getAll(name);
                return all == null ? C1173v.m() : all;
            }
        };
    }

    private final ByteWriteChannel preparedBodyChannel() {
        if (!kotlin.jvm.internal.p.d(getHeaders().get(HttpHeaders.INSTANCE.getTransferEncoding()), com.stepos.statsapp.v3.lib.plugin.net.multipart.e.f30859r)) {
            return this.output;
        }
        ReaderJob readerJobEncodeChunked = ChunkedTransferEncodingKt.encodeChunked(this.output, Y.d());
        ByteWriteChannel channel = readerJobEncodeChunked.getChannel();
        this.chunkedChannel = channel;
        this.chunkedJob = readerJobEncodeChunked.getJob();
        return channel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object sendResponseMessage(boolean r9, e9.InterfaceC4014c<? super Y8.t> r10) throws java.lang.Throwable {
        /*
            r8 = this;
            boolean r0 = r10 instanceof io.ktor.server.cio.CIOApplicationResponse.C43371
            if (r0 == 0) goto L13
            r0 = r10
            io.ktor.server.cio.CIOApplicationResponse$sendResponseMessage$1 r0 = (io.ktor.server.cio.CIOApplicationResponse.C43371) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.server.cio.CIOApplicationResponse$sendResponseMessage$1 r0 = new io.ktor.server.cio.CIOApplicationResponse$sendResponseMessage$1
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L4b
            if (r2 == r4) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r8 = r0.L$0
            io.ktor.http.cio.RequestResponseBuilder r8 = (io.ktor.http.cio.RequestResponseBuilder) r8
            kotlin.C4849c.b(r10)     // Catch: java.lang.Throwable -> L31
            goto Lc0
        L31:
            r9 = move-exception
            goto Lc7
        L34:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L3c:
            boolean r9 = r0.Z$0
            java.lang.Object r2 = r0.L$0
            io.ktor.http.cio.RequestResponseBuilder r2 = (io.ktor.http.cio.RequestResponseBuilder) r2
            kotlin.C4849c.b(r10)     // Catch: java.lang.Throwable -> L47
            r10 = r2
            goto Lb0
        L47:
            r9 = move-exception
            r8 = r2
            goto Lc7
        L4b:
            kotlin.C4849c.b(r10)
            io.ktor.http.cio.RequestResponseBuilder r10 = new io.ktor.http.cio.RequestResponseBuilder
            r10.<init>()
            java.lang.String r2 = "HTTP/1.1"
            io.ktor.http.HttpStatusCode r5 = r8.statusCode     // Catch: java.lang.Throwable -> L97
            int r5 = r5.getValue()     // Catch: java.lang.Throwable -> L97
            io.ktor.http.HttpStatusCode r6 = r8.statusCode     // Catch: java.lang.Throwable -> L97
            java.lang.String r6 = r6.getDescription()     // Catch: java.lang.Throwable -> L97
            r10.responseLine(r2, r5, r6)     // Catch: java.lang.Throwable -> L97
            io.ktor.http.HeadersBuilder r2 = r8.headersBuilder     // Catch: java.lang.Throwable -> L97
            java.util.Set r2 = r2.names()     // Catch: java.lang.Throwable -> L97
            java.util.Iterator r2 = r2.iterator()     // Catch: java.lang.Throwable -> L97
        L6e:
            boolean r5 = r2.hasNext()     // Catch: java.lang.Throwable -> L97
            if (r5 == 0) goto L9a
            java.lang.Object r5 = r2.next()     // Catch: java.lang.Throwable -> L97
            java.lang.String r5 = (java.lang.String) r5     // Catch: java.lang.Throwable -> L97
            io.ktor.http.HeadersBuilder r6 = r8.headersBuilder     // Catch: java.lang.Throwable -> L97
            java.util.List r6 = r6.getAll(r5)     // Catch: java.lang.Throwable -> L97
            kotlin.jvm.internal.p.f(r6)     // Catch: java.lang.Throwable -> L97
            java.util.Iterator r6 = r6.iterator()     // Catch: java.lang.Throwable -> L97
        L87:
            boolean r7 = r6.hasNext()     // Catch: java.lang.Throwable -> L97
            if (r7 == 0) goto L6e
            java.lang.Object r7 = r6.next()     // Catch: java.lang.Throwable -> L97
            java.lang.String r7 = (java.lang.String) r7     // Catch: java.lang.Throwable -> L97
            r10.headerLine(r5, r7)     // Catch: java.lang.Throwable -> L97
            goto L87
        L97:
            r9 = move-exception
            r8 = r10
            goto Lc7
        L9a:
            r10.emptyLine()     // Catch: java.lang.Throwable -> L97
            io.ktor.utils.io.ByteWriteChannel r2 = r8.output     // Catch: java.lang.Throwable -> L97
            fb.v r5 = r10.build()     // Catch: java.lang.Throwable -> L97
            r0.L$0 = r10     // Catch: java.lang.Throwable -> L97
            r0.Z$0 = r9     // Catch: java.lang.Throwable -> L97
            r0.label = r4     // Catch: java.lang.Throwable -> L97
            java.lang.Object r2 = io.ktor.utils.io.ByteWriteChannelOperationsKt.writePacket(r2, r5, r0)     // Catch: java.lang.Throwable -> L97
            if (r2 != r1) goto Lb0
            goto Lbe
        Lb0:
            if (r9 != 0) goto Lc1
            io.ktor.utils.io.ByteWriteChannel r8 = r8.output     // Catch: java.lang.Throwable -> L97
            r0.L$0 = r10     // Catch: java.lang.Throwable -> L97
            r0.label = r3     // Catch: java.lang.Throwable -> L97
            java.lang.Object r8 = r8.flush(r0)     // Catch: java.lang.Throwable -> L97
            if (r8 != r1) goto Lbf
        Lbe:
            return r1
        Lbf:
            r8 = r10
        Lc0:
            r10 = r8
        Lc1:
            r10.release()
            Y8.t r8 = Y8.t.f7040a
            return r8
        Lc7:
            r8.release()
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.server.cio.CIOApplicationResponse.sendResponseMessage(boolean, e9.c):java.lang.Object");
    }

    @Override // io.ktor.server.response.ApplicationResponse
    public ResponseHeaders getHeaders() {
        return this.headers;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0060, code lost:
    
        if (Ua.C1056g.j(r7, r2, r0) == r1) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // io.ktor.server.engine.BaseApplicationResponse
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object respondFromBytes(byte[] r6, e9.InterfaceC4014c<? super Y8.t> r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof io.ktor.server.cio.CIOApplicationResponse.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r7
            io.ktor.server.cio.CIOApplicationResponse$respondFromBytes$1 r0 = (io.ktor.server.cio.CIOApplicationResponse.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.server.cio.CIOApplicationResponse$respondFromBytes$1 r0 = new io.ktor.server.cio.CIOApplicationResponse$respondFromBytes$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3c
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.C4849c.b(r7)
            goto L63
        L2c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L34:
            java.lang.Object r6 = r0.L$0
            byte[] r6 = (byte[]) r6
            kotlin.C4849c.b(r7)
            goto L4a
        L3c:
            kotlin.C4849c.b(r7)
            r0.L$0 = r6
            r0.label = r4
            java.lang.Object r7 = r5.sendResponseMessage(r4, r0)
            if (r7 != r1) goto L4a
            goto L62
        L4a:
            io.ktor.utils.io.ByteWriteChannel r5 = r5.preparedBodyChannel()
            Ua.I r7 = Ua.Y.d()
            io.ktor.server.cio.CIOApplicationResponse$respondFromBytes$2 r2 = new io.ktor.server.cio.CIOApplicationResponse$respondFromBytes$2
            r4 = 0
            r2.<init>(r5, r6, r4)
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r5 = Ua.C1056g.j(r7, r2, r0)
            if (r5 != r1) goto L63
        L62:
            return r1
        L63:
            Y8.t r5 = Y8.t.f7040a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.server.cio.CIOApplicationResponse.respondFromBytes(byte[], e9.c):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x004c, code lost:
    
        if (r4.flushAndClose(r5) == r0) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // io.ktor.server.engine.BaseApplicationResponse
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object respondNoContent(io.ktor.http.content.OutgoingContent.NoContent r5, e9.InterfaceC4014c<? super Y8.t> r6) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r5 = r6 instanceof io.ktor.server.cio.CIOApplicationResponse.C43331
            if (r5 == 0) goto L13
            r5 = r6
            io.ktor.server.cio.CIOApplicationResponse$respondNoContent$1 r5 = (io.ktor.server.cio.CIOApplicationResponse.C43331) r5
            int r0 = r5.label
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r0 & r1
            if (r2 == 0) goto L13
            int r0 = r0 - r1
            r5.label = r0
            goto L18
        L13:
            io.ktor.server.cio.CIOApplicationResponse$respondNoContent$1 r5 = new io.ktor.server.cio.CIOApplicationResponse$respondNoContent$1
            r5.<init>(r6)
        L18:
            java.lang.Object r6 = r5.result
            java.lang.Object r0 = f9.C4063a.g()
            int r1 = r5.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L38
            if (r1 == r3) goto L34
            if (r1 != r2) goto L2c
            kotlin.C4849c.b(r6)
            goto L4f
        L2c:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L34:
            kotlin.C4849c.b(r6)
            goto L44
        L38:
            kotlin.C4849c.b(r6)
            r5.label = r3
            java.lang.Object r6 = r4.sendResponseMessage(r3, r5)
            if (r6 != r0) goto L44
            goto L4e
        L44:
            io.ktor.utils.io.ByteWriteChannel r4 = r4.output
            r5.label = r2
            java.lang.Object r4 = r4.flushAndClose(r5)
            if (r4 != r0) goto L4f
        L4e:
            return r0
        L4f:
            Y8.t r4 = Y8.t.f7040a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.server.cio.CIOApplicationResponse.respondNoContent(io.ktor.http.content.OutgoingContent$NoContent, e9.c):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x008e, code lost:
    
        if (r6.T0(r0) == r1) goto L40;
     */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // io.ktor.server.engine.BaseApplicationResponse
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object respondOutgoingContent(io.ktor.http.content.OutgoingContent r7, e9.InterfaceC4014c<? super Y8.t> r8) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r8 instanceof io.ktor.server.cio.CIOApplicationResponse.C43341
            if (r0 == 0) goto L13
            r0 = r8
            io.ktor.server.cio.CIOApplicationResponse$respondOutgoingContent$1 r0 = (io.ktor.server.cio.CIOApplicationResponse.C43341) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.server.cio.CIOApplicationResponse$respondOutgoingContent$1 r0 = new io.ktor.server.cio.CIOApplicationResponse$respondOutgoingContent$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L3f
            if (r2 == r5) goto L3b
            if (r2 == r4) goto L37
            if (r2 != r3) goto L2f
            kotlin.C4849c.b(r8)
            goto L91
        L2f:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L37:
            kotlin.C4849c.b(r8)
            goto L84
        L3b:
            kotlin.C4849c.b(r8)
            goto L77
        L3f:
            kotlin.C4849c.b(r8)
            boolean r8 = r7 instanceof io.ktor.http.content.OutgoingContent.ProtocolUpgrade
            if (r8 == 0) goto L5e
            Ua.u<java.lang.Boolean> r8 = r6.upgraded
            if (r8 == 0) goto L56
            java.lang.Boolean r2 = g9.C4109a.a(r5)
            boolean r8 = r8.complete(r2)
            g9.C4109a.a(r8)
            goto L6e
        L56:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "Unable to perform upgrade as it is not requested by the client: request should have Upgrade and Connection headers filled properly"
            r6.<init>(r7)
            throw r6
        L5e:
            Ua.u<java.lang.Boolean> r8 = r6.upgraded
            if (r8 == 0) goto L6e
            r2 = 0
            java.lang.Boolean r2 = g9.C4109a.a(r2)
            boolean r8 = r8.complete(r2)
            g9.C4109a.a(r8)
        L6e:
            r0.label = r5
            java.lang.Object r7 = super.respondOutgoingContent(r7, r0)
            if (r7 != r1) goto L77
            goto L90
        L77:
            io.ktor.utils.io.ByteWriteChannel r7 = r6.chunkedChannel
            if (r7 == 0) goto L84
            r0.label = r4
            java.lang.Object r7 = r7.flushAndClose(r0)
            if (r7 != r1) goto L84
            goto L90
        L84:
            kotlinx.coroutines.g r6 = r6.chunkedJob
            if (r6 == 0) goto L94
            r0.label = r3
            java.lang.Object r6 = r6.T0(r0)
            if (r6 != r1) goto L91
        L90:
            return r1
        L91:
            Y8.t r6 = Y8.t.f7040a
            return r6
        L94:
            Y8.t r6 = Y8.t.f7040a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.server.cio.CIOApplicationResponse.respondOutgoingContent(io.ktor.http.content.OutgoingContent, e9.c):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0092, code lost:
    
        if (r12.flushAndClose(r6) != r7) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00a7, code lost:
    
        if (r13.flushAndClose(r6) != r7) goto L43;
     */
    /* JADX WARN: Removed duplicated region for block: B:35:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    @Override // io.ktor.server.engine.BaseApplicationResponse
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object respondUpgrade(io.ktor.http.content.OutgoingContent.ProtocolUpgrade r12, e9.InterfaceC4014c<? super Y8.t> r13) throws java.lang.Throwable {
        /*
            r11 = this;
            boolean r0 = r13 instanceof io.ktor.server.cio.CIOApplicationResponse.C43351
            if (r0 == 0) goto L14
            r0 = r13
            io.ktor.server.cio.CIOApplicationResponse$respondUpgrade$1 r0 = (io.ktor.server.cio.CIOApplicationResponse.C43351) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.label = r1
        L12:
            r6 = r0
            goto L1a
        L14:
            io.ktor.server.cio.CIOApplicationResponse$respondUpgrade$1 r0 = new io.ktor.server.cio.CIOApplicationResponse$respondUpgrade$1
            r0.<init>(r13)
            goto L12
        L1a:
            java.lang.Object r13 = r6.result
            java.lang.Object r7 = f9.C4063a.g()
            int r0 = r6.label
            r8 = 5
            r9 = 4
            r10 = 3
            r1 = 2
            r2 = 1
            if (r0 == 0) goto L5b
            if (r0 == r2) goto L53
            if (r0 == r1) goto L4f
            if (r0 == r10) goto L48
            if (r0 == r9) goto L44
            if (r0 == r8) goto L3b
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L3b:
            java.lang.Object r12 = r6.L$0
            java.lang.Throwable r12 = (java.lang.Throwable) r12
            kotlin.C4849c.b(r13)
            goto Laa
        L44:
            kotlin.C4849c.b(r13)
            goto L95
        L48:
            kotlin.C4849c.b(r13)     // Catch: java.lang.Throwable -> L4c
            goto L8a
        L4c:
            r0 = move-exception
            r12 = r0
            goto L9d
        L4f:
            kotlin.C4849c.b(r13)     // Catch: java.lang.Throwable -> L4c
            goto L7f
        L53:
            java.lang.Object r12 = r6.L$0
            io.ktor.http.content.OutgoingContent$ProtocolUpgrade r12 = (io.ktor.http.content.OutgoingContent.ProtocolUpgrade) r12
            kotlin.C4849c.b(r13)
            goto L6a
        L5b:
            kotlin.C4849c.b(r13)
            r6.L$0 = r12
            r6.label = r2
            r13 = 0
            java.lang.Object r13 = r11.sendResponseMessage(r13, r6)
            if (r13 != r7) goto L6a
            goto La9
        L6a:
            io.ktor.utils.io.ByteReadChannel r2 = r11.input     // Catch: java.lang.Throwable -> L4c
            io.ktor.utils.io.ByteWriteChannel r3 = r11.output     // Catch: java.lang.Throwable -> L4c
            kotlin.coroutines.d r4 = r11.engineDispatcher     // Catch: java.lang.Throwable -> L4c
            kotlin.coroutines.d r5 = r11.userDispatcher     // Catch: java.lang.Throwable -> L4c
            r13 = 0
            r6.L$0 = r13     // Catch: java.lang.Throwable -> L4c
            r6.label = r1     // Catch: java.lang.Throwable -> L4c
            r1 = r12
            java.lang.Object r13 = r1.upgrade(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L4c
            if (r13 != r7) goto L7f
            goto La9
        L7f:
            kotlinx.coroutines.g r13 = (kotlinx.coroutines.g) r13     // Catch: java.lang.Throwable -> L4c
            r6.label = r10     // Catch: java.lang.Throwable -> L4c
            java.lang.Object r12 = r13.T0(r6)     // Catch: java.lang.Throwable -> L4c
            if (r12 != r7) goto L8a
            goto La9
        L8a:
            io.ktor.utils.io.ByteWriteChannel r12 = r11.output
            r6.label = r9
            java.lang.Object r12 = r12.flushAndClose(r6)
            if (r12 != r7) goto L95
            goto La9
        L95:
            io.ktor.utils.io.ByteReadChannel r11 = r11.input
            io.ktor.utils.io.ByteReadChannelKt.cancel(r11)
            Y8.t r11 = Y8.t.f7040a
            return r11
        L9d:
            io.ktor.utils.io.ByteWriteChannel r13 = r11.output
            r6.L$0 = r12
            r6.label = r8
            java.lang.Object r13 = r13.flushAndClose(r6)
            if (r13 != r7) goto Laa
        La9:
            return r7
        Laa:
            io.ktor.utils.io.ByteReadChannel r11 = r11.input
            io.ktor.utils.io.ByteReadChannelKt.cancel(r11)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.server.cio.CIOApplicationResponse.respondUpgrade(io.ktor.http.content.OutgoingContent$ProtocolUpgrade, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // io.ktor.server.engine.BaseApplicationResponse
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object responseChannel(e9.InterfaceC4014c<? super io.ktor.utils.io.ByteWriteChannel> r5) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r5 instanceof io.ktor.server.cio.CIOApplicationResponse.C43361
            if (r0 == 0) goto L13
            r0 = r5
            io.ktor.server.cio.CIOApplicationResponse$responseChannel$1 r0 = (io.ktor.server.cio.CIOApplicationResponse.C43361) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.server.cio.CIOApplicationResponse$responseChannel$1 r0 = new io.ktor.server.cio.CIOApplicationResponse$responseChannel$1
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.C4849c.b(r5)
            goto L3e
        L29:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L31:
            kotlin.C4849c.b(r5)
            r0.label = r3
            r5 = 0
            java.lang.Object r5 = r4.sendResponseMessage(r5, r0)
            if (r5 != r1) goto L3e
            return r1
        L3e:
            io.ktor.utils.io.ByteWriteChannel r4 = r4.preparedBodyChannel()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.server.cio.CIOApplicationResponse.responseChannel(e9.c):java.lang.Object");
    }

    @Override // io.ktor.server.engine.BaseApplicationResponse
    public void setStatus(HttpStatusCode statusCode) {
        kotlin.jvm.internal.p.i(statusCode, "statusCode");
        this.statusCode = statusCode;
    }
}
