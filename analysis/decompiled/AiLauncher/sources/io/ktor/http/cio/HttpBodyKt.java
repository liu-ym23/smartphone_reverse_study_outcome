package io.ktor.http.cio;

import La.H;
import Y8.t;
import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import f9.C4063a;
import io.ktor.http.HttpMethod;
import io.ktor.http.HttpProtocolVersion;
import io.ktor.http.cio.internals.CharsKt;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteReadChannelOperationsKt;
import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.utils.io.ByteWriteChannelOperationsKt;
import java.util.Iterator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a)\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\b\u001a\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0007\u0010\u000b\u001a;\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u0015\u0010\u0010\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0010\u0010\u000b\u001aF\u0010\u0019\u001a\u00020\u00182\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0086@¢\u0006\u0004\b\u0019\u0010\u001a\u001a<\u0010\u0019\u001a\u00020\u00182\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0087@¢\u0006\u0004\b\u0019\u0010\u001b\u001a(\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0086@¢\u0006\u0004\b\u0019\u0010\u001e\u001a\u0017\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Lio/ktor/http/HttpMethod;", "method", "", "upgrade", "Lio/ktor/http/cio/ConnectionOptions;", "connectionOptions", "", "expectHttpUpgrade", "(Lio/ktor/http/HttpMethod;Ljava/lang/CharSequence;Lio/ktor/http/cio/ConnectionOptions;)Z", "Lio/ktor/http/cio/Request;", "request", "(Lio/ktor/http/cio/Request;)Z", "", "contentLength", "transferEncoding", "contentType", "expectHttpBody", "(Lio/ktor/http/HttpMethod;JLjava/lang/CharSequence;Lio/ktor/http/cio/ConnectionOptions;Ljava/lang/CharSequence;)Z", "Lio/ktor/http/HttpProtocolVersion;", "version", "Lio/ktor/utils/io/ByteReadChannel;", "input", "Lio/ktor/utils/io/ByteWriteChannel;", "out", "LY8/t;", "parseHttpBody", "(Lio/ktor/http/HttpProtocolVersion;JLjava/lang/CharSequence;Lio/ktor/http/cio/ConnectionOptions;Lio/ktor/utils/io/ByteReadChannel;Lio/ktor/utils/io/ByteWriteChannel;Le9/c;)Ljava/lang/Object;", "(JLjava/lang/CharSequence;Lio/ktor/http/cio/ConnectionOptions;Lio/ktor/utils/io/ByteReadChannel;Lio/ktor/utils/io/ByteWriteChannel;Le9/c;)Ljava/lang/Object;", "Lio/ktor/http/cio/HttpHeadersMap;", "headers", "(Lio/ktor/http/cio/HttpHeadersMap;Lio/ktor/utils/io/ByteReadChannel;Lio/ktor/utils/io/ByteWriteChannel;Le9/c;)Ljava/lang/Object;", "isTransferEncodingChunked", "(Ljava/lang/CharSequence;)Z", "ktor-http-cio"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class HttpBodyKt {
    public static final boolean expectHttpBody(HttpMethod method, long j10, CharSequence charSequence, ConnectionOptions connectionOptions, CharSequence charSequence2) {
        p.i(method, "method");
        if (charSequence != null) {
            isTransferEncodingChunked(charSequence);
            return true;
        }
        if (j10 != -1) {
            return j10 > 0;
        }
        HttpMethod.Companion companion = HttpMethod.INSTANCE;
        return (p.d(method, companion.getGet()) || p.d(method, companion.getHead()) || p.d(method, companion.getOptions()) || connectionOptions == null || !connectionOptions.getClose()) ? false : true;
    }

    public static final boolean expectHttpUpgrade(HttpMethod method, CharSequence charSequence, ConnectionOptions connectionOptions) {
        p.i(method, "method");
        return p.d(method, HttpMethod.INSTANCE.getGet()) && charSequence != null && connectionOptions != null && connectionOptions.getUpgrade();
    }

    private static final boolean isTransferEncodingChunked(CharSequence charSequence) {
        if (CharsKt.equalsLowerCase$default(charSequence, 0, 0, com.stepos.statsapp.v3.lib.plugin.net.multipart.e.f30859r, 3, null)) {
            return true;
        }
        boolean z10 = false;
        if (CharsKt.equalsLowerCase$default(charSequence, 0, 0, com.stepos.statsapp.v3.lib.plugin.net.multipart.e.f30860s, 3, null)) {
            return false;
        }
        Iterator it = H.b1(charSequence, new String[]{Const.STR_MART_COMMA}, false, 0, 6, null).iterator();
        while (it.hasNext()) {
            String lowerCase = H.D1((String) it.next()).toString().toLowerCase(Locale.ROOT);
            p.h(lowerCase, "toLowerCase(...)");
            if (p.d(lowerCase, com.stepos.statsapp.v3.lib.plugin.net.multipart.e.f30859r)) {
                if (z10) {
                    throw new IllegalArgumentException("Double-chunked TE is not supported: " + ((Object) charSequence));
                }
                z10 = true;
            } else if (!p.d(lowerCase, com.stepos.statsapp.v3.lib.plugin.net.multipart.e.f30860s)) {
                throw new IllegalArgumentException("Unsupported transfer encoding " + lowerCase);
            }
        }
        return z10;
    }

    public static final Object parseHttpBody(HttpProtocolVersion httpProtocolVersion, long j10, CharSequence charSequence, ConnectionOptions connectionOptions, ByteReadChannel byteReadChannel, ByteWriteChannel byteWriteChannel, InterfaceC4014c<? super t> interfaceC4014c) throws Throwable {
        if (charSequence != null && isTransferEncodingChunked(charSequence)) {
            Object objDecodeChunked = ChunkedTransferEncodingKt.decodeChunked(byteReadChannel, byteWriteChannel, interfaceC4014c);
            return objDecodeChunked == C4063a.g() ? objDecodeChunked : t.f7040a;
        }
        if (j10 != -1) {
            Object objCopyTo = ByteReadChannelOperationsKt.copyTo(byteReadChannel, byteWriteChannel, j10, interfaceC4014c);
            return objCopyTo == C4063a.g() ? objCopyTo : t.f7040a;
        }
        if ((connectionOptions == null || !connectionOptions.getClose()) && !(connectionOptions == null && p.d(httpProtocolVersion, HttpProtocolVersion.INSTANCE.getHTTP_1_0()))) {
            ByteWriteChannelOperationsKt.close(byteWriteChannel, new IllegalStateException("Failed to parse request body: request body length should be specified,\nchunked transfer encoding should be used or\nkeep-alive should be disabled (connection: close)"));
            return t.f7040a;
        }
        Object objCopyTo2 = ByteReadChannelOperationsKt.copyTo(byteReadChannel, byteWriteChannel, Long.MAX_VALUE, interfaceC4014c);
        return objCopyTo2 == C4063a.g() ? objCopyTo2 : t.f7040a;
    }

    public static final boolean expectHttpUpgrade(Request request) {
        p.i(request, "request");
        return expectHttpUpgrade(request.getMethod(), request.getHeaders().get("Upgrade"), ConnectionOptions.INSTANCE.parse(request.getHeaders().get(com.stepos.statsapp.v3.lib.plugin.net.multipart.e.f30851j)));
    }

    public static final boolean expectHttpBody(Request request) {
        p.i(request, "request");
        HttpMethod method = request.getMethod();
        CharSequence charSequence = request.getHeaders().get("Content-Length");
        return expectHttpBody(method, charSequence != null ? CharsKt.parseDecLong(charSequence) : -1L, request.getHeaders().get(com.stepos.statsapp.v3.lib.plugin.net.multipart.e.f30846e), ConnectionOptions.INSTANCE.parse(request.getHeaders().get(com.stepos.statsapp.v3.lib.plugin.net.multipart.e.f30851j)), request.getHeaders().get("Content-Type"));
    }

    public static final Object parseHttpBody(long j10, CharSequence charSequence, ConnectionOptions connectionOptions, ByteReadChannel byteReadChannel, ByteWriteChannel byteWriteChannel, InterfaceC4014c<? super t> interfaceC4014c) throws Throwable {
        Object httpBody = parseHttpBody(null, j10, charSequence, connectionOptions, byteReadChannel, byteWriteChannel, interfaceC4014c);
        return httpBody == C4063a.g() ? httpBody : t.f7040a;
    }

    public static final Object parseHttpBody(HttpHeadersMap httpHeadersMap, ByteReadChannel byteReadChannel, ByteWriteChannel byteWriteChannel, InterfaceC4014c<? super t> interfaceC4014c) throws Throwable {
        CharSequence charSequence = httpHeadersMap.get("Content-Length");
        Object httpBody = parseHttpBody(null, charSequence != null ? CharsKt.parseDecLong(charSequence) : -1L, httpHeadersMap.get(com.stepos.statsapp.v3.lib.plugin.net.multipart.e.f30846e), ConnectionOptions.INSTANCE.parse(httpHeadersMap.get(com.stepos.statsapp.v3.lib.plugin.net.multipart.e.f30851j)), byteReadChannel, byteWriteChannel, interfaceC4014c);
        return httpBody == C4063a.g() ? httpBody : t.f7040a;
    }
}
