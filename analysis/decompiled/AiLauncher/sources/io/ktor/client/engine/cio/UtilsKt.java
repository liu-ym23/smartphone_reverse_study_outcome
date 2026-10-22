package io.ktor.client.engine.cio;

import Ua.C1056g;
import Ua.C1060i;
import Ua.C1073o0;
import Ua.C1086v0;
import Ua.CoroutineName;
import Ua.M;
import Y8.t;
import Z8.C1173v;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import io.ktor.client.call.UnsupportedContentTypeException;
import io.ktor.client.request.HttpRequestData;
import io.ktor.client.request.HttpRequestKt;
import io.ktor.client.request.HttpResponseData;
import io.ktor.client.request.ResponseAdapter;
import io.ktor.http.Headers;
import io.ktor.http.HeadersImpl;
import io.ktor.http.HttpHeaders;
import io.ktor.http.HttpMethod;
import io.ktor.http.HttpProtocolVersion;
import io.ktor.http.HttpStatusCode;
import io.ktor.http.cio.ChunkedTransferEncodingKt;
import io.ktor.http.cio.ConnectionOptions;
import io.ktor.http.cio.HttpHeadersMap;
import io.ktor.http.cio.HttpParserKt;
import io.ktor.http.cio.RequestResponseBuilder;
import io.ktor.http.cio.Response;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.date.GMTDate;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteReadChannelOperationsKt;
import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.utils.io.ByteWriteChannelKt;
import io.ktor.utils.io.ByteWriteChannelOperationsKt;
import io.ktor.utils.io.ClosedReadChannelException;
import io.ktor.utils.io.ReaderJob;
import io.ktor.utils.io.ReaderScope;
import io.ktor.websocket.RawWebSocketJvmKt;
import java.io.EOFException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5074l;
import p9.p;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\u001a:\u0010\n\u001a\u00020\t2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0006H\u0080@¢\u0006\u0004\b\n\u0010\u000b\u001a2\u0010\f\u001a\u00020\t2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0006H\u0080@¢\u0006\u0004\b\f\u0010\r\u001a2\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0006H\u0080@¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u0013\u0010\u0011\u001a\u00020\u0010*\u00020\u0010H\u0002¢\u0006\u0004\b\u0011\u0010\u0012\u001a(\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0002H\u0082@¢\u0006\u0004\b\u0015\u0010\u0016\u001a8\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0080@¢\u0006\u0004\b\u001c\u0010\u001d\u001a(\u0010\u001e\u001a\u00020\t2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0019H\u0080@¢\u0006\u0004\b\u001e\u0010\u001f\u001a%\u0010$\u001a\u0014\u0012\u0004\u0012\u00020\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0#0!*\u00020 H\u0000¢\u0006\u0004\b$\u0010%\u001a\u0013\u0010'\u001a\u00020\u0006*\u00020&H\u0000¢\u0006\u0004\b'\u0010(\u001a%\u0010+\u001a\u00020\u0002*\u00020\u00022\u0006\u0010)\u001a\u00020\u00042\b\b\u0002\u0010*\u001a\u00020\u0006H\u0000¢\u0006\u0004\b+\u0010,\u001a#\u0010.\u001a\u00020\u0002*\u00020\u00022\u0006\u0010)\u001a\u00020\u00042\u0006\u0010-\u001a\u00020\u0006H\u0000¢\u0006\u0004\b.\u0010,\u001a-\u00102\u001a\u00020\u00062\b\u0010/\u001a\u0004\u0018\u00010\"2\b\u00100\u001a\u0004\u0018\u00010\"2\b\u00101\u001a\u0004\u0018\u00010\"H\u0000¢\u0006\u0004\b2\u00103\u001a!\u00105\u001a\u00020\u00062\b\u00104\u001a\u0004\u0018\u00010\"2\u0006\u0010\u0013\u001a\u00020\u0010H\u0000¢\u0006\u0004\b5\u00106¨\u00067"}, d2 = {"Lio/ktor/client/request/HttpRequestData;", "request", "Lio/ktor/utils/io/ByteWriteChannel;", "output", "Lkotlin/coroutines/d;", "callContext", "", "overProxy", "closeChannel", "LY8/t;", "writeRequest", "(Lio/ktor/client/request/HttpRequestData;Lio/ktor/utils/io/ByteWriteChannel;Lkotlin/coroutines/d;ZZLe9/c;)Ljava/lang/Object;", "writeHeaders", "(Lio/ktor/client/request/HttpRequestData;Lio/ktor/utils/io/ByteWriteChannel;ZZLe9/c;)Ljava/lang/Object;", "writeBody", "(Lio/ktor/client/request/HttpRequestData;Lio/ktor/utils/io/ByteWriteChannel;Lkotlin/coroutines/d;ZLe9/c;)Ljava/lang/Object;", "Lio/ktor/http/content/OutgoingContent;", "getUnwrapped", "(Lio/ktor/http/content/OutgoingContent;)Lio/ktor/http/content/OutgoingContent;", "body", "channel", "processOutgoingContent", "(Lio/ktor/client/request/HttpRequestData;Lio/ktor/http/content/OutgoingContent;Lio/ktor/utils/io/ByteWriteChannel;Le9/c;)Ljava/lang/Object;", "Lio/ktor/util/date/GMTDate;", "requestTime", "Lio/ktor/utils/io/ByteReadChannel;", "input", "Lio/ktor/client/request/HttpResponseData;", "readResponse", "(Lio/ktor/util/date/GMTDate;Lio/ktor/client/request/HttpRequestData;Lio/ktor/utils/io/ByteReadChannel;Lio/ktor/utils/io/ByteWriteChannel;Lkotlin/coroutines/d;Le9/c;)Ljava/lang/Object;", "startTunnel", "(Lio/ktor/client/request/HttpRequestData;Lio/ktor/utils/io/ByteWriteChannel;Lio/ktor/utils/io/ByteReadChannel;Le9/c;)Ljava/lang/Object;", "Lio/ktor/http/cio/HttpHeadersMap;", "", "", "", "toMap", "(Lio/ktor/http/cio/HttpHeadersMap;)Ljava/util/Map;", "Lio/ktor/http/HttpStatusCode;", "isInformational", "(Lio/ktor/http/HttpStatusCode;)Z", "coroutineContext", "closeOnCoroutineCompletion", "withoutClosePropagation", "(Lio/ktor/utils/io/ByteWriteChannel;Lkotlin/coroutines/d;Z)Lio/ktor/utils/io/ByteWriteChannel;", "propagateClose", "handleHalfClosed", "contentLength", "responseEncoding", "contentEncoding", "isChunked", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z", "expectHeader", "expectContinue", "(Ljava/lang/String;Lio/ktor/http/content/OutgoingContent;)Z", "ktor-client-cio"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class UtilsKt {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "Lio/ktor/client/request/HttpResponseData;", "<anonymous>", "(LUa/M;)Lio/ktor/client/request/HttpResponseData;"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "io.ktor.client.engine.cio.UtilsKt$readResponse$2", f = "utils.kt", l = {173}, m = "invokeSuspend")
    /* renamed from: io.ktor.client.engine.cio.UtilsKt$readResponse$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements p<M, InterfaceC4014c<? super HttpResponseData>, Object> {
        final /* synthetic */ kotlin.coroutines.d $callContext;
        final /* synthetic */ ByteReadChannel $input;
        final /* synthetic */ ByteWriteChannel $output;
        final /* synthetic */ HttpRequestData $request;
        final /* synthetic */ GMTDate $requestTime;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(ByteReadChannel byteReadChannel, ByteWriteChannel byteWriteChannel, kotlin.coroutines.d dVar, GMTDate gMTDate, HttpRequestData httpRequestData, InterfaceC4014c<? super AnonymousClass2> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$input = byteReadChannel;
            this.$output = byteWriteChannel;
            this.$callContext = dVar;
            this.$requestTime = gMTDate;
            this.$request = httpRequestData;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new AnonymousClass2(this.$input, this.$output, this.$callContext, this.$requestTime, this.$request, interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(M m10, InterfaceC4014c<? super HttpResponseData> interfaceC4014c) {
            return ((AnonymousClass2) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object response;
            HttpStatusCode httpStatusCode;
            HeadersImpl headersImpl;
            Object obj2;
            String string;
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 == 0) {
                C4849c.b(obj);
                ByteReadChannel byteReadChannel = this.$input;
                this.label = 1;
                response = HttpParserKt.parseResponse(byteReadChannel, this);
                if (response == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
                response = obj;
            }
            Response response2 = (Response) response;
            if (response2 == null) {
                throw new ClosedReadChannelException(new EOFException("Failed to parse HTTP response: the server prematurely closed the connection"));
            }
            ByteReadChannel byteReadChannel2 = this.$input;
            ByteWriteChannel byteWriteChannel = this.$output;
            kotlin.coroutines.d dVar = this.$callContext;
            GMTDate gMTDate = this.$requestTime;
            HttpRequestData httpRequestData = this.$request;
            try {
                HttpStatusCode httpStatusCode2 = new HttpStatusCode(response2.getStatus(), response2.getStatusText().toString());
                HttpHeadersMap headers = response2.getHeaders();
                HttpHeaders httpHeaders = HttpHeaders.INSTANCE;
                CharSequence charSequence = headers.get(httpHeaders.getContentLength());
                long j10 = (charSequence == null || (string = charSequence.toString()) == null) ? -1L : Long.parseLong(string);
                CharSequence charSequence2 = response2.getHeaders().get(httpHeaders.getTransferEncoding());
                String string2 = charSequence2 != null ? charSequence2.toString() : null;
                ConnectionOptions connectionOptions = ConnectionOptions.INSTANCE.parse(response2.getHeaders().get(httpHeaders.getConnection()));
                HeadersImpl headersImpl2 = new HeadersImpl(UtilsKt.toMap(response2.getHeaders()));
                HttpProtocolVersion httpProtocolVersion = HttpProtocolVersion.INSTANCE.parse(response2.getVersion());
                HttpStatusCode.Companion companion = HttpStatusCode.INSTANCE;
                if (kotlin.jvm.internal.p.d(httpStatusCode2, companion.getSwitchingProtocols())) {
                    HttpResponseData httpResponseData = new HttpResponseData(httpStatusCode2, gMTDate, headersImpl2, httpProtocolVersion, RawWebSocketJvmKt.RawWebSocket$default(byteReadChannel2, byteWriteChannel, 0L, true, dVar, 4, null), dVar);
                    l9.b.a(response2, null);
                    return httpResponseData;
                }
                ByteReadChannel empty = (kotlin.jvm.internal.p.d(httpRequestData.getMethod(), HttpMethod.INSTANCE.getHead()) || C1173v.p(companion.getNotModified(), companion.getNoContent()).contains(httpStatusCode2) || UtilsKt.isInformational(httpStatusCode2)) ? ByteReadChannel.INSTANCE.getEmpty() : ByteWriteChannelOperationsKt.writer$default(kotlinx.coroutines.d.a(dVar.plus(new CoroutineName("cio-client-body-reader"))), (kotlin.coroutines.d) null, true, (p) new UtilsKt$readResponse$2$1$body$httpBodyParser$1(httpProtocolVersion, j10, string2, connectionOptions, byteReadChannel2, null), 1, (Object) null).getChannel();
                ResponseAdapter responseAdapter = (ResponseAdapter) httpRequestData.getAttributes().getOrNull(HttpRequestKt.getResponseAdapterAttributeKey());
                if (responseAdapter != null) {
                    headersImpl = headersImpl2;
                    Object objAdapt = responseAdapter.adapt(httpRequestData, httpStatusCode2, headersImpl, empty, httpRequestData.getBody(), dVar);
                    httpStatusCode = httpStatusCode2;
                    if (objAdapt != null) {
                        obj2 = objAdapt;
                    }
                    HttpResponseData httpResponseData2 = new HttpResponseData(httpStatusCode, gMTDate, headersImpl, httpProtocolVersion, obj2, dVar);
                    l9.b.a(response2, null);
                    return httpResponseData2;
                }
                httpStatusCode = httpStatusCode2;
                headersImpl = headersImpl2;
                obj2 = empty;
                HttpResponseData httpResponseData22 = new HttpResponseData(httpStatusCode, gMTDate, headersImpl, httpProtocolVersion, obj2, dVar);
                l9.b.a(response2, null);
                return httpResponseData22;
            } finally {
            }
        }
    }

    @InterfaceC4112d(c = "io.ktor.client.engine.cio.UtilsKt", f = "utils.kt", l = {240, 241, 243, 250}, m = "startTunnel")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.client.engine.cio.UtilsKt$startTunnel$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UtilsKt.startTunnel(null, null, null, this);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lio/ktor/utils/io/ReaderScope;", "LY8/t;", "<anonymous>", "(Lio/ktor/utils/io/ReaderScope;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "io.ktor.client.engine.cio.UtilsKt$withoutClosePropagation$2", f = "utils.kt", l = {292, 293}, m = "invokeSuspend")
    /* renamed from: io.ktor.client.engine.cio.UtilsKt$withoutClosePropagation$2, reason: invalid class name and case insensitive filesystem */
    public static final class C42062 extends SuspendLambda implements p<ReaderScope, InterfaceC4014c<? super t>, Object> {
        final /* synthetic */ ByteWriteChannel $this_withoutClosePropagation;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C42062(ByteWriteChannel byteWriteChannel, InterfaceC4014c<? super C42062> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$this_withoutClosePropagation = byteWriteChannel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            C42062 c42062 = new C42062(this.$this_withoutClosePropagation, interfaceC4014c);
            c42062.L$0 = obj;
            return c42062;
        }

        @Override // p9.p
        public final Object invoke(ReaderScope readerScope, InterfaceC4014c<? super t> interfaceC4014c) {
            return ((C42062) create(readerScope, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x004d, code lost:
        
            if (r7.flush(r6) == r1) goto L15;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) throws java.lang.Throwable {
            /*
                r6 = this;
                java.lang.Object r0 = r6.L$0
                io.ktor.utils.io.ReaderScope r0 = (io.ktor.utils.io.ReaderScope) r0
                java.lang.Object r1 = f9.C4063a.g()
                int r2 = r6.label
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L22
                if (r2 == r4) goto L1e
                if (r2 != r3) goto L16
                kotlin.C4849c.b(r7)
                goto L50
            L16:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L1e:
                kotlin.C4849c.b(r7)
                goto L3f
            L22:
                kotlin.C4849c.b(r7)
                io.ktor.utils.io.ByteReadChannel r7 = r0.getChannel()
                io.ktor.utils.io.ByteWriteChannel r2 = r6.$this_withoutClosePropagation
                java.lang.Object r5 = g9.h.a(r0)
                r6.L$0 = r5
                r6.label = r4
                r4 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                java.lang.Object r7 = io.ktor.utils.io.ByteReadChannelOperationsKt.copyTo(r7, r2, r4, r6)
                if (r7 != r1) goto L3f
                goto L4f
            L3f:
                io.ktor.utils.io.ByteWriteChannel r7 = r6.$this_withoutClosePropagation
                java.lang.Object r0 = g9.h.a(r0)
                r6.L$0 = r0
                r6.label = r3
                java.lang.Object r6 = r7.flush(r6)
                if (r6 != r1) goto L50
            L4f:
                return r1
            L50:
                Y8.t r6 = Y8.t.f7040a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.engine.cio.UtilsKt.C42062.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "io.ktor.client.engine.cio.UtilsKt$writeBody$2", f = "utils.kt", l = {130, 135, 137, 135, 137}, m = "invokeSuspend")
    /* renamed from: io.ktor.client.engine.cio.UtilsKt$writeBody$2, reason: invalid class name and case insensitive filesystem */
    public static final class C42072 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {
        final /* synthetic */ OutgoingContent $body;
        final /* synthetic */ ByteWriteChannel $channel;
        final /* synthetic */ ReaderJob $chunkedJob;
        final /* synthetic */ boolean $closeChannel;
        final /* synthetic */ ByteWriteChannel $output;
        final /* synthetic */ HttpRequestData $request;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C42072(HttpRequestData httpRequestData, OutgoingContent outgoingContent, ByteWriteChannel byteWriteChannel, ReaderJob readerJob, ByteWriteChannel byteWriteChannel2, boolean z10, InterfaceC4014c<? super C42072> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$request = httpRequestData;
            this.$body = outgoingContent;
            this.$channel = byteWriteChannel;
            this.$chunkedJob = readerJob;
            this.$output = byteWriteChannel2;
            this.$closeChannel = z10;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new C42072(this.$request, this.$body, this.$channel, this.$chunkedJob, this.$output, this.$closeChannel, interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
            return ((C42072) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:34:0x0077, code lost:
        
            if (io.ktor.utils.io.ByteWriteChannelOperationsKt.join(r10, r9) == r0) goto L66;
         */
        /* JADX WARN: Removed duplicated region for block: B:33:0x0071  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x0082  */
        /* JADX WARN: Removed duplicated region for block: B:42:0x008c  */
        /* JADX WARN: Removed duplicated region for block: B:45:0x0090  */
        /* JADX WARN: Removed duplicated region for block: B:48:0x0095  */
        /* JADX WARN: Removed duplicated region for block: B:75:0x00e1  */
        /* JADX WARN: Removed duplicated region for block: B:78:0x00e5  */
        /* JADX WARN: Removed duplicated region for block: B:81:0x00ea  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r10) throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 240
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.engine.cio.UtilsKt.C42072.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @InterfaceC4112d(c = "io.ktor.client.engine.cio.UtilsKt", f = "utils.kt", l = {91, 92, 95}, m = "writeHeaders")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.client.engine.cio.UtilsKt$writeHeaders$1, reason: invalid class name and case insensitive filesystem */
    public static final class C42081 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        boolean Z$0;
        boolean Z$1;
        boolean Z$2;
        int label;
        /* synthetic */ Object result;

        public C42081(InterfaceC4014c<? super C42081> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UtilsKt.writeHeaders(null, null, false, false, this);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "io.ktor.client.engine.cio.UtilsKt$writeRequest$2", f = "utils.kt", l = {30, 31}, m = "invokeSuspend")
    /* renamed from: io.ktor.client.engine.cio.UtilsKt$writeRequest$2, reason: invalid class name and case insensitive filesystem */
    public static final class C42092 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {
        final /* synthetic */ kotlin.coroutines.d $callContext;
        final /* synthetic */ boolean $closeChannel;
        final /* synthetic */ ByteWriteChannel $output;
        final /* synthetic */ boolean $overProxy;
        final /* synthetic */ HttpRequestData $request;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C42092(HttpRequestData httpRequestData, ByteWriteChannel byteWriteChannel, boolean z10, boolean z11, kotlin.coroutines.d dVar, InterfaceC4014c<? super C42092> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$request = httpRequestData;
            this.$output = byteWriteChannel;
            this.$overProxy = z10;
            this.$closeChannel = z11;
            this.$callContext = dVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new C42092(this.$request, this.$output, this.$overProxy, this.$closeChannel, this.$callContext, interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
            return ((C42092) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0043, code lost:
        
            if (io.ktor.client.engine.cio.UtilsKt.writeBody$default(r3, r4, r5, false, r10, 8, null) == r0) goto L15;
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
                if (r1 == 0) goto L1e
                if (r1 == r3) goto L1a
                if (r1 != r2) goto L12
                kotlin.C4849c.b(r11)
                goto L46
            L12:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r11)
                throw r10
            L1a:
                kotlin.C4849c.b(r11)
                goto L32
            L1e:
                kotlin.C4849c.b(r11)
                io.ktor.client.request.HttpRequestData r11 = r10.$request
                io.ktor.utils.io.ByteWriteChannel r1 = r10.$output
                boolean r4 = r10.$overProxy
                boolean r5 = r10.$closeChannel
                r10.label = r3
                java.lang.Object r11 = io.ktor.client.engine.cio.UtilsKt.writeHeaders(r11, r1, r4, r5, r10)
                if (r11 != r0) goto L32
                goto L45
            L32:
                io.ktor.client.request.HttpRequestData r3 = r10.$request
                io.ktor.utils.io.ByteWriteChannel r4 = r10.$output
                kotlin.coroutines.d r5 = r10.$callContext
                r10.label = r2
                r6 = 0
                r8 = 8
                r9 = 0
                r7 = r10
                java.lang.Object r10 = io.ktor.client.engine.cio.UtilsKt.writeBody$default(r3, r4, r5, r6, r7, r8, r9)
                if (r10 != r0) goto L46
            L45:
                return r0
            L46:
                Y8.t r10 = Y8.t.f7040a
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.engine.cio.UtilsKt.C42092.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public static final boolean expectContinue(String str, OutgoingContent body) {
        kotlin.jvm.internal.p.i(body, "body");
        return (str == null || (body instanceof OutgoingContent.NoContent)) ? false : true;
    }

    private static final OutgoingContent getUnwrapped(OutgoingContent outgoingContent) {
        return outgoingContent instanceof OutgoingContent.ContentWrapper ? getUnwrapped(((OutgoingContent.ContentWrapper) outgoingContent).getDelegate()) : outgoingContent;
    }

    public static final ByteWriteChannel handleHalfClosed(ByteWriteChannel byteWriteChannel, kotlin.coroutines.d coroutineContext, boolean z10) {
        kotlin.jvm.internal.p.i(byteWriteChannel, "<this>");
        kotlin.jvm.internal.p.i(coroutineContext, "coroutineContext");
        return z10 ? byteWriteChannel : withoutClosePropagation$default(byteWriteChannel, coroutineContext, false, 2, null);
    }

    public static final boolean isChunked(String str, String str2, String str3) {
        return str == null || kotlin.jvm.internal.p.d(str2, com.stepos.statsapp.v3.lib.plugin.net.multipart.e.f30859r) || kotlin.jvm.internal.p.d(str3, com.stepos.statsapp.v3.lib.plugin.net.multipart.e.f30859r);
    }

    public static final boolean isInformational(HttpStatusCode httpStatusCode) {
        kotlin.jvm.internal.p.i(httpStatusCode, "<this>");
        return httpStatusCode.getValue() / 100 == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object processOutgoingContent(HttpRequestData httpRequestData, OutgoingContent outgoingContent, ByteWriteChannel byteWriteChannel, InterfaceC4014c<? super t> interfaceC4014c) throws Throwable {
        if (outgoingContent instanceof OutgoingContent.ByteArrayContent) {
            Object objWriteFully$default = ByteWriteChannelOperationsKt.writeFully$default(byteWriteChannel, ((OutgoingContent.ByteArrayContent) outgoingContent).getBytes(), 0, 0, interfaceC4014c, 6, null);
            return objWriteFully$default == C4063a.g() ? objWriteFully$default : t.f7040a;
        }
        if (outgoingContent instanceof OutgoingContent.ReadChannelContent) {
            Object objCopyAndClose = ByteReadChannelOperationsKt.copyAndClose(((OutgoingContent.ReadChannelContent) outgoingContent).readFrom(), byteWriteChannel, interfaceC4014c);
            return objCopyAndClose == C4063a.g() ? objCopyAndClose : t.f7040a;
        }
        if (outgoingContent instanceof OutgoingContent.WriteChannelContent) {
            Object objWriteTo = ((OutgoingContent.WriteChannelContent) outgoingContent).writeTo(byteWriteChannel, interfaceC4014c);
            return objWriteTo == C4063a.g() ? objWriteTo : t.f7040a;
        }
        if (outgoingContent instanceof OutgoingContent.ContentWrapper) {
            Object objProcessOutgoingContent = processOutgoingContent(httpRequestData, ((OutgoingContent.ContentWrapper) outgoingContent).getDelegate(), byteWriteChannel, interfaceC4014c);
            return objProcessOutgoingContent == C4063a.g() ? objProcessOutgoingContent : t.f7040a;
        }
        if (outgoingContent instanceof OutgoingContent.ProtocolUpgrade) {
            throw new IllegalStateException("unreachable code");
        }
        if (outgoingContent instanceof OutgoingContent.NoContent) {
            throw new IllegalStateException("unreachable code");
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final Object readResponse(GMTDate gMTDate, HttpRequestData httpRequestData, ByteReadChannel byteReadChannel, ByteWriteChannel byteWriteChannel, kotlin.coroutines.d dVar, InterfaceC4014c<? super HttpResponseData> interfaceC4014c) {
        return C1056g.j(dVar, new AnonymousClass2(byteReadChannel, byteWriteChannel, dVar, gMTDate, httpRequestData, null), interfaceC4014c);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x021c A[Catch: all -> 0x007b, TryCatch #3 {all -> 0x007b, blocks: (B:70:0x0205, B:77:0x0218, B:78:0x021b, B:22:0x0076, B:55:0x0193, B:79:0x021c, B:80:0x0228, B:27:0x0092, B:51:0x0173, B:30:0x00ab, B:75:0x0216), top: B:88:0x0024, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0197 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r11v16 */
    /* JADX WARN: Type inference failed for: r11v18, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r11v19 */
    /* JADX WARN: Type inference failed for: r11v22 */
    /* JADX WARN: Type inference failed for: r11v36, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r11v37 */
    /* JADX WARN: Type inference failed for: r11v8 */
    /* JADX WARN: Type inference failed for: r12v0, types: [io.ktor.utils.io.ByteWriteChannel, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v11 */
    /* JADX WARN: Type inference failed for: r12v2, types: [io.ktor.http.cio.RequestResponseBuilder] */
    /* JADX WARN: Type inference failed for: r12v25, types: [io.ktor.http.cio.RequestResponseBuilder] */
    /* JADX WARN: Type inference failed for: r12v26 */
    /* JADX WARN: Type inference failed for: r12v27 */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r12v30 */
    /* JADX WARN: Type inference failed for: r12v31 */
    /* JADX WARN: Type inference failed for: r12v7, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v8 */
    /* JADX WARN: Type inference failed for: r12v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object startTunnel(io.ktor.client.request.HttpRequestData r11, io.ktor.utils.io.ByteWriteChannel r12, io.ktor.utils.io.ByteReadChannel r13, e9.InterfaceC4014c<? super Y8.t> r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 557
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.engine.cio.UtilsKt.startTunnel(io.ktor.client.request.HttpRequestData, io.ktor.utils.io.ByteWriteChannel, io.ktor.utils.io.ByteReadChannel, e9.c):java.lang.Object");
    }

    public static final Map<String, List<String>> toMap(HttpHeadersMap httpHeadersMap) {
        kotlin.jvm.internal.p.i(httpHeadersMap, "<this>");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<Integer> it = httpHeadersMap.offsets().iterator();
        while (it.hasNext()) {
            int iIntValue = it.next().intValue();
            String string = httpHeadersMap.nameAtOffset(iIntValue).toString();
            String string2 = httpHeadersMap.valueAtOffset(iIntValue).toString();
            List list = (List) linkedHashMap.get(string);
            if ((list != null ? Boolean.valueOf(list.add(string2)) : null) == null) {
                linkedHashMap.put(string, C1173v.s(string2));
            }
        }
        return linkedHashMap;
    }

    public static final ByteWriteChannel withoutClosePropagation(final ByteWriteChannel byteWriteChannel, kotlin.coroutines.d coroutineContext, boolean z10) {
        kotlin.jvm.internal.p.i(byteWriteChannel, "<this>");
        kotlin.jvm.internal.p.i(coroutineContext, "coroutineContext");
        if (z10) {
            C1086v0.o(coroutineContext).J(new InterfaceC5074l() { // from class: io.ktor.client.engine.cio.l
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return UtilsKt.withoutClosePropagation$lambda$7(byteWriteChannel, (Throwable) obj);
                }
            });
        }
        return ByteReadChannelOperationsKt.reader((M) C1073o0.f6391a, coroutineContext, true, (p<? super ReaderScope, ? super InterfaceC4014c<? super t>, ? extends Object>) new C42062(byteWriteChannel, null)).getChannel();
    }

    public static /* synthetic */ ByteWriteChannel withoutClosePropagation$default(ByteWriteChannel byteWriteChannel, kotlin.coroutines.d dVar, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = true;
        }
        return withoutClosePropagation(byteWriteChannel, dVar, z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t withoutClosePropagation$lambda$7(ByteWriteChannel byteWriteChannel, Throwable th) {
        ByteWriteChannelOperationsKt.close(byteWriteChannel, th);
        return t.f7040a;
    }

    public static final Object writeBody(HttpRequestData httpRequestData, ByteWriteChannel byteWriteChannel, kotlin.coroutines.d dVar, boolean z10, InterfaceC4014c<? super t> interfaceC4014c) {
        ByteWriteChannel channel;
        OutgoingContent unwrapped = getUnwrapped(httpRequestData.getBody());
        if (unwrapped instanceof OutgoingContent.NoContent) {
            if (z10) {
                ByteWriteChannelKt.close(byteWriteChannel);
            }
            return t.f7040a;
        }
        if (unwrapped instanceof OutgoingContent.ProtocolUpgrade) {
            throw new UnsupportedContentTypeException(unwrapped);
        }
        Headers headers = httpRequestData.getHeaders();
        HttpHeaders httpHeaders = HttpHeaders.INSTANCE;
        String string = headers.get(httpHeaders.getContentLength());
        if (string == null) {
            Long contentLength = unwrapped.getContentLength();
            string = contentLength != null ? contentLength.toString() : null;
        }
        ReaderJob readerJobEncodeChunked = isChunked(string, unwrapped.getHeaders().get(httpHeaders.getTransferEncoding()), httpRequestData.getHeaders().get(httpHeaders.getTransferEncoding())) ? ChunkedTransferEncodingKt.encodeChunked(byteWriteChannel, dVar) : null;
        C1060i.d(kotlinx.coroutines.d.a(dVar.plus(new CoroutineName("cio-client-body-writer"))), null, null, new C42072(httpRequestData, unwrapped, (readerJobEncodeChunked == null || (channel = readerJobEncodeChunked.getChannel()) == null) ? byteWriteChannel : channel, readerJobEncodeChunked, byteWriteChannel, z10, null), 3, null);
        return t.f7040a;
    }

    public static /* synthetic */ Object writeBody$default(HttpRequestData httpRequestData, ByteWriteChannel byteWriteChannel, kotlin.coroutines.d dVar, boolean z10, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            z10 = true;
        }
        return writeBody(httpRequestData, byteWriteChannel, dVar, z10, interfaceC4014c);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(25:30|(2:32|(1:34)(22:36|37|127|38|(2:121|40)(1:43)|(1:45)(1:47)|48|(7:117|50|51|111|52|(1:54)(1:57)|58)(1:62)|123|63|64|(1:69)|70|(1:78)(1:76)|79|(1:81)|82|83|113|84|(4:87|119|88|(0))|105))|35|37|127|38|(0)(0)|(0)(0)|48|(0)(0)|123|63|64|(2:66|69)|70|(0)|78|79|(0)|82|83|113|84|(0)|105) */
    /* JADX WARN: Code restructure failed: missing block: B:100:0x032e, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x032f, code lost:
    
        r9 = r25;
        r19 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0323, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0324, code lost:
    
        r20 = r22;
        r2 = r5;
        r5 = r24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x032a, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x032b, code lost:
    
        r9 = r25;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0336 A[Catch: all -> 0x006e, TRY_ENTER, TryCatch #9 {all -> 0x006e, blocks: (B:16:0x0069, B:108:0x038b, B:103:0x0336), top: B:129:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:117:0x01cc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0189 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:131:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01aa A[Catch: all -> 0x0199, TRY_LEAVE, TryCatch #5 {all -> 0x0199, blocks: (B:40:0x0189, B:45:0x01aa), top: B:121:0x0189 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01af A[Catch: all -> 0x032e, TRY_ENTER, TryCatch #8 {all -> 0x032e, blocks: (B:38:0x017f, B:48:0x01b3, B:47:0x01af), top: B:127:0x017f }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0238 A[Catch: all -> 0x01e1, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x01e1, blocks: (B:52:0x01d6, B:54:0x01dc, B:58:0x01ef, B:66:0x0203, B:69:0x020b, B:74:0x0220, B:76:0x0224, B:81:0x0238, B:57:0x01eb), top: B:111:0x01d6 }] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x02a4  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0310  */
    /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v33 */
    /* JADX WARN: Type inference failed for: r2v34 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object writeHeaders(io.ktor.client.request.HttpRequestData r22, io.ktor.utils.io.ByteWriteChannel r23, boolean r24, boolean r25, e9.InterfaceC4014c<? super Y8.t> r26) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 912
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.engine.cio.UtilsKt.writeHeaders(io.ktor.client.request.HttpRequestData, io.ktor.utils.io.ByteWriteChannel, boolean, boolean, e9.c):java.lang.Object");
    }

    public static /* synthetic */ Object writeHeaders$default(HttpRequestData httpRequestData, ByteWriteChannel byteWriteChannel, boolean z10, boolean z11, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            z11 = true;
        }
        return writeHeaders(httpRequestData, byteWriteChannel, z10, z11, interfaceC4014c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t writeHeaders$lambda$1(RequestResponseBuilder requestResponseBuilder, String key, String value) {
        kotlin.jvm.internal.p.i(key, "key");
        kotlin.jvm.internal.p.i(value, "value");
        HttpHeaders httpHeaders = HttpHeaders.INSTANCE;
        if (kotlin.jvm.internal.p.d(key, httpHeaders.getContentLength()) || kotlin.jvm.internal.p.d(key, httpHeaders.getExpect())) {
            return t.f7040a;
        }
        requestResponseBuilder.headerLine(key, value);
        return t.f7040a;
    }

    public static final Object writeRequest(HttpRequestData httpRequestData, ByteWriteChannel byteWriteChannel, kotlin.coroutines.d dVar, boolean z10, boolean z11, InterfaceC4014c<? super t> interfaceC4014c) {
        Object objJ = C1056g.j(dVar, new C42092(httpRequestData, byteWriteChannel, z10, z11, dVar, null), interfaceC4014c);
        return objJ == C4063a.g() ? objJ : t.f7040a;
    }

    public static /* synthetic */ Object writeRequest$default(HttpRequestData httpRequestData, ByteWriteChannel byteWriteChannel, kotlin.coroutines.d dVar, boolean z10, boolean z11, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 16) != 0) {
            z11 = true;
        }
        return writeRequest(httpRequestData, byteWriteChannel, dVar, z10, z11, interfaceC4014c);
    }
}
