package io.ktor.http.content;

import La.D;
import Ua.C1056g;
import Ua.M;
import Y8.t;
import androidx.exifinterface.media.ExifInterface;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import io.ktor.http.ContentType;
import io.ktor.http.Headers;
import io.ktor.http.HttpHeaders;
import io.ktor.http.HttpStatusCode;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.AttributeKey;
import io.ktor.util.ContentEncoder;
import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.utils.io.ByteWriteChannelKt;
import io.ktor.utils.io.ByteWriteChannelOperationsKt;
import kotlin.C4848b;
import kotlin.C4849c;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5063a;
import p9.p;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ)\u0010\r\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\n*\u00020\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ1\u0010\u0011\u001a\u00020\u0010\"\b\b\u0000\u0010\n*\u00020\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0013H\u0096@¢\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0002\u001a\u00020\u00018\u0006¢\u0006\f\n\u0004\b\u0002\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001b\u0010%\u001a\u00020 8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u0016\u0010)\u001a\u0004\u0018\u00010&8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0016\u0010-\u001a\u0004\u0018\u00010*8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,R\u0016\u00101\u001a\u0004\u0018\u00010.8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b/\u00100¨\u00062"}, d2 = {"Lio/ktor/http/content/CompressedWriteChannelResponse;", "Lio/ktor/http/content/OutgoingContent$WriteChannelContent;", "original", "Lio/ktor/util/ContentEncoder;", "encoder", "Lkotlin/coroutines/d;", "coroutineContext", "<init>", "(Lio/ktor/http/content/OutgoingContent$WriteChannelContent;Lio/ktor/util/ContentEncoder;Lkotlin/coroutines/d;)V", "", ExifInterface.GPS_DIRECTION_TRUE, "Lio/ktor/util/AttributeKey;", "key", "getProperty", "(Lio/ktor/util/AttributeKey;)Ljava/lang/Object;", UxipConstants.f30680s, "LY8/t;", "setProperty", "(Lio/ktor/util/AttributeKey;Ljava/lang/Object;)V", "Lio/ktor/utils/io/ByteWriteChannel;", "channel", "writeTo", "(Lio/ktor/utils/io/ByteWriteChannel;Le9/c;)Ljava/lang/Object;", "Lio/ktor/http/content/OutgoingContent$WriteChannelContent;", "getOriginal", "()Lio/ktor/http/content/OutgoingContent$WriteChannelContent;", "Lio/ktor/util/ContentEncoder;", "getEncoder", "()Lio/ktor/util/ContentEncoder;", "Lkotlin/coroutines/d;", "getCoroutineContext", "()Lkotlin/coroutines/d;", "Lio/ktor/http/Headers;", "headers$delegate", "LY8/h;", "getHeaders", "()Lio/ktor/http/Headers;", "headers", "Lio/ktor/http/ContentType;", "getContentType", "()Lio/ktor/http/ContentType;", "contentType", "Lio/ktor/http/HttpStatusCode;", "getStatus", "()Lio/ktor/http/HttpStatusCode;", "status", "", "getContentLength", "()Ljava/lang/Long;", "contentLength", "ktor-http"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
final class CompressedWriteChannelResponse extends OutgoingContent.WriteChannelContent {
    private final kotlin.coroutines.d coroutineContext;
    private final ContentEncoder encoder;

    /* renamed from: headers$delegate, reason: from kotlin metadata */
    private final Y8.h headers;
    private final OutgoingContent.WriteChannelContent original;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "io.ktor.http.content.CompressedWriteChannelResponse$writeTo$2", f = "CompressedContent.kt", l = {94}, m = "invokeSuspend")
    /* renamed from: io.ktor.http.content.CompressedWriteChannelResponse$writeTo$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {
        final /* synthetic */ ByteWriteChannel $channel;
        int I$0;
        int I$1;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(ByteWriteChannel byteWriteChannel, InterfaceC4014c<? super AnonymousClass2> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$channel = byteWriteChannel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            AnonymousClass2 anonymousClass2 = CompressedWriteChannelResponse.this.new AnonymousClass2(this.$channel, interfaceC4014c);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // p9.p
        public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
            return ((AnonymousClass2) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Throwable th;
            ByteWriteChannel byteWriteChannel;
            M m10 = (M) this.L$0;
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                byteWriteChannel = (ByteWriteChannel) this.L$1;
                try {
                    C4849c.b(obj);
                    ByteWriteChannelKt.close(byteWriteChannel);
                    return t.f7040a;
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        ByteWriteChannelOperationsKt.close(byteWriteChannel, th);
                        throw th;
                    } catch (Throwable th3) {
                        ByteWriteChannelKt.close(byteWriteChannel);
                        throw th3;
                    }
                }
            }
            C4849c.b(obj);
            ByteWriteChannel byteWriteChannelEncode = CompressedWriteChannelResponse.this.getEncoder().encode(this.$channel, m10.getCoroutineContext());
            try {
                OutgoingContent.WriteChannelContent original = CompressedWriteChannelResponse.this.getOriginal();
                this.L$0 = g9.h.a(m10);
                this.L$1 = byteWriteChannelEncode;
                this.L$2 = g9.h.a(byteWriteChannelEncode);
                this.I$0 = 0;
                this.I$1 = 0;
                this.label = 1;
                if (original.writeTo(byteWriteChannelEncode, this) == objG) {
                    return objG;
                }
                byteWriteChannel = byteWriteChannelEncode;
                ByteWriteChannelKt.close(byteWriteChannel);
                return t.f7040a;
            } catch (Throwable th4) {
                th = th4;
                byteWriteChannel = byteWriteChannelEncode;
                ByteWriteChannelOperationsKt.close(byteWriteChannel, th);
                throw th;
            }
        }
    }

    public CompressedWriteChannelResponse(OutgoingContent.WriteChannelContent original, ContentEncoder encoder, kotlin.coroutines.d coroutineContext) {
        kotlin.jvm.internal.p.i(original, "original");
        kotlin.jvm.internal.p.i(encoder, "encoder");
        kotlin.jvm.internal.p.i(coroutineContext, "coroutineContext");
        this.original = original;
        this.encoder = encoder;
        this.coroutineContext = coroutineContext;
        this.headers = C4848b.a(LazyThreadSafetyMode.NONE, new InterfaceC5063a() { // from class: io.ktor.http.content.g
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return CompressedWriteChannelResponse.headers_delegate$lambda$2(this.f33304a);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0058  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final io.ktor.http.Headers headers_delegate$lambda$2(io.ktor.http.content.CompressedWriteChannelResponse r7) {
        /*
            io.ktor.http.Headers$Companion r0 = io.ktor.http.Headers.INSTANCE
            io.ktor.http.HeadersBuilder r1 = new io.ktor.http.HeadersBuilder
            r0 = 1
            r2 = 0
            r3 = 0
            r1.<init>(r3, r0, r2)
            io.ktor.http.content.OutgoingContent$WriteChannelContent r0 = r7.original
            io.ktor.http.Headers r2 = r0.getHeaders()
            io.ktor.http.content.f r4 = new io.ktor.http.content.f
            r4.<init>()
            r5 = 2
            r6 = 0
            io.ktor.util.StringValuesKt.appendFiltered$default(r1, r2, r3, r4, r5, r6)
            io.ktor.http.HttpHeaders r0 = io.ktor.http.HttpHeaders.INSTANCE
            java.lang.String r2 = r0.getContentEncoding()
            io.ktor.util.ContentEncoder r3 = r7.encoder
            java.lang.String r3 = r3.getName()
            r1.append(r2, r3)
            java.lang.String r2 = r0.getVary()
            io.ktor.http.content.OutgoingContent$WriteChannelContent r7 = r7.original
            io.ktor.http.Headers r7 = r7.getHeaders()
            java.lang.String r3 = r0.getVary()
            java.lang.String r7 = r7.get(r3)
            if (r7 == 0) goto L58
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r7)
            java.lang.String r7 = ", "
            r3.append(r7)
            java.lang.String r7 = r0.getAcceptEncoding()
            r3.append(r7)
            java.lang.String r7 = r3.toString()
            if (r7 == 0) goto L58
            goto L5c
        L58:
            java.lang.String r7 = r0.getAcceptEncoding()
        L5c:
            r1.append(r2, r7)
            io.ktor.http.Headers r7 = r1.build()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.content.CompressedWriteChannelResponse.headers_delegate$lambda$2(io.ktor.http.content.CompressedWriteChannelResponse):io.ktor.http.Headers");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean headers_delegate$lambda$2$lambda$1$lambda$0(String name, String str) {
        kotlin.jvm.internal.p.i(name, "name");
        kotlin.jvm.internal.p.i(str, "<unused var>");
        return !D.L(name, HttpHeaders.INSTANCE.getContentLength(), true);
    }

    @Override // io.ktor.http.content.OutgoingContent
    public Long getContentLength() {
        Long contentLength = this.original.getContentLength();
        if (contentLength != null) {
            Long lPredictCompressedLength = this.encoder.predictCompressedLength(contentLength.longValue());
            if (lPredictCompressedLength != null && lPredictCompressedLength.longValue() >= 0) {
                return lPredictCompressedLength;
            }
        }
        return null;
    }

    @Override // io.ktor.http.content.OutgoingContent
    public ContentType getContentType() {
        return this.original.getContentType();
    }

    public final kotlin.coroutines.d getCoroutineContext() {
        return this.coroutineContext;
    }

    public final ContentEncoder getEncoder() {
        return this.encoder;
    }

    @Override // io.ktor.http.content.OutgoingContent
    public Headers getHeaders() {
        return (Headers) this.headers.getValue();
    }

    public final OutgoingContent.WriteChannelContent getOriginal() {
        return this.original;
    }

    @Override // io.ktor.http.content.OutgoingContent
    public <T> T getProperty(AttributeKey<T> key) {
        kotlin.jvm.internal.p.i(key, "key");
        return (T) this.original.getProperty(key);
    }

    @Override // io.ktor.http.content.OutgoingContent
    public HttpStatusCode getStatus() {
        return this.original.getStatus();
    }

    @Override // io.ktor.http.content.OutgoingContent
    public <T> void setProperty(AttributeKey<T> key, T value) {
        kotlin.jvm.internal.p.i(key, "key");
        this.original.setProperty(key, value);
    }

    @Override // io.ktor.http.content.OutgoingContent.WriteChannelContent
    public Object writeTo(ByteWriteChannel byteWriteChannel, InterfaceC4014c<? super t> interfaceC4014c) {
        Object objJ = C1056g.j(this.coroutineContext, new AnonymousClass2(byteWriteChannel, null), interfaceC4014c);
        return objJ == C4063a.g() ? objJ : t.f7040a;
    }
}
