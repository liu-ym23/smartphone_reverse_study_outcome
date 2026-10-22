package io.ktor.server.request;

import La.C;
import La.D;
import La.H;
import com.fasterxml.jackson.core.JsonPointer;
import com.stepos.statsapp.v3.lib.plugin.net.multipart.e;
import io.ktor.http.ContentType;
import io.ktor.http.ContentTypesKt;
import io.ktor.http.HeaderValue;
import io.ktor.http.HttpHeaderValueParserKt;
import io.ktor.http.HttpHeaders;
import io.ktor.http.HttpMethod;
import io.ktor.http.RangesKt;
import io.ktor.http.RangesSpecifier;
import io.ktor.server.plugins.OriginConnectionPointKt;
import java.nio.charset.Charset;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u001b\u0010\u0003\u001a\u0004\u0018\u00010\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0011\u0010\u0005\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0011\u0010\b\u001a\u00020\u0007*\u00020\u0000¢\u0006\u0004\b\b\u0010\t\u001a\u0013\u0010\u000b\u001a\u0004\u0018\u00010\n*\u00020\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a\u0019\u0010\u000f\u001a\n\u0018\u00010\rj\u0004\u0018\u0001`\u000e*\u00020\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u0011\u0010\u0011\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0011\u0010\u0006\u001a\u0011\u0010\u0012\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0012\u0010\u0006\u001a\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0001*\u00020\u0000¢\u0006\u0004\b\u0013\u0010\u0006\u001a\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0001*\u00020\u0000¢\u0006\u0004\b\u0014\u0010\u0006\u001a\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0001*\u00020\u0000¢\u0006\u0004\b\u0015\u0010\u0006\u001a\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016*\u00020\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u0001*\u00020\u0000¢\u0006\u0004\b\u001a\u0010\u0006\u001a\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016*\u00020\u0000¢\u0006\u0004\b\u001b\u0010\u0019\u001a\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u0001*\u00020\u0000¢\u0006\u0004\b\u001c\u0010\u0006\u001a\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016*\u00020\u0000¢\u0006\u0004\b\u001d\u0010\u0019\u001a\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u0001*\u00020\u0000¢\u0006\u0004\b\u001e\u0010\u0006\u001a\u0017\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016*\u00020\u0000¢\u0006\u0004\b\u001f\u0010\u0019\u001a\u0011\u0010!\u001a\u00020 *\u00020\u0000¢\u0006\u0004\b!\u0010\"\u001a\u0011\u0010#\u001a\u00020 *\u00020\u0000¢\u0006\u0004\b#\u0010\"\u001a\u0013\u0010$\u001a\u0004\u0018\u00010\u0001*\u00020\u0000¢\u0006\u0004\b$\u0010\u0006\u001a\u0013\u0010%\u001a\u0004\u0018\u00010\u0001*\u00020\u0000¢\u0006\u0004\b%\u0010\u0006\u001a\u0011\u0010&\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b&\u0010\u0006\u001a\u0011\u0010(\u001a\u00020'*\u00020\u0000¢\u0006\u0004\b(\u0010)\u001a\u0013\u0010+\u001a\u0004\u0018\u00010**\u00020\u0000¢\u0006\u0004\b+\u0010,\"\u0015\u0010.\u001a\u00020\u0001*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b-\u0010\u0006\"\u0015\u00102\u001a\u00020/*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b0\u00101\"\u0015\u00104\u001a\u00020\u0001*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b3\u0010\u0006¨\u00065"}, d2 = {"Lio/ktor/server/request/ApplicationRequest;", "", "name", "header", "(Lio/ktor/server/request/ApplicationRequest;Ljava/lang/String;)Ljava/lang/String;", "queryString", "(Lio/ktor/server/request/ApplicationRequest;)Ljava/lang/String;", "Lio/ktor/http/ContentType;", "contentType", "(Lio/ktor/server/request/ApplicationRequest;)Lio/ktor/http/ContentType;", "", "contentLength", "(Lio/ktor/server/request/ApplicationRequest;)Ljava/lang/Long;", "Ljava/nio/charset/Charset;", "Lio/ktor/utils/io/charsets/Charset;", "contentCharset", "(Lio/ktor/server/request/ApplicationRequest;)Ljava/nio/charset/Charset;", "document", "path", "authorization", "location", "accept", "", "Lio/ktor/http/HeaderValue;", "acceptItems", "(Lio/ktor/server/request/ApplicationRequest;)Ljava/util/List;", "acceptEncoding", "acceptEncodingItems", "acceptLanguage", "acceptLanguageItems", "acceptCharset", "acceptCharsetItems", "", "isChunked", "(Lio/ktor/server/request/ApplicationRequest;)Z", "isMultipart", "userAgent", "cacheControl", "host", "", "port", "(Lio/ktor/server/request/ApplicationRequest;)I", "Lio/ktor/http/RangesSpecifier;", "ranges", "(Lio/ktor/server/request/ApplicationRequest;)Lio/ktor/http/RangesSpecifier;", "getUri", "uri", "Lio/ktor/http/HttpMethod;", "getHttpMethod", "(Lio/ktor/server/request/ApplicationRequest;)Lio/ktor/http/HttpMethod;", "httpMethod", "getHttpVersion", "httpVersion", "ktor-server-core"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ApplicationRequestPropertiesKt {
    public static final String accept(ApplicationRequest applicationRequest) {
        p.i(applicationRequest, "<this>");
        return header(applicationRequest, HttpHeaders.INSTANCE.getAccept());
    }

    public static final String acceptCharset(ApplicationRequest applicationRequest) {
        p.i(applicationRequest, "<this>");
        return header(applicationRequest, HttpHeaders.INSTANCE.getAcceptCharset());
    }

    public static final List<HeaderValue> acceptCharsetItems(ApplicationRequest applicationRequest) {
        p.i(applicationRequest, "<this>");
        return HttpHeaderValueParserKt.parseAndSortHeader(header(applicationRequest, HttpHeaders.INSTANCE.getAcceptCharset()));
    }

    public static final String acceptEncoding(ApplicationRequest applicationRequest) {
        p.i(applicationRequest, "<this>");
        return header(applicationRequest, HttpHeaders.INSTANCE.getAcceptEncoding());
    }

    public static final List<HeaderValue> acceptEncodingItems(ApplicationRequest applicationRequest) {
        p.i(applicationRequest, "<this>");
        return HttpHeaderValueParserKt.parseAndSortHeader(header(applicationRequest, HttpHeaders.INSTANCE.getAcceptEncoding()));
    }

    public static final List<HeaderValue> acceptItems(ApplicationRequest applicationRequest) {
        p.i(applicationRequest, "<this>");
        return HttpHeaderValueParserKt.parseAndSortContentTypeHeader(header(applicationRequest, HttpHeaders.INSTANCE.getAccept()));
    }

    public static final String acceptLanguage(ApplicationRequest applicationRequest) {
        p.i(applicationRequest, "<this>");
        return header(applicationRequest, HttpHeaders.INSTANCE.getAcceptLanguage());
    }

    public static final List<HeaderValue> acceptLanguageItems(ApplicationRequest applicationRequest) {
        p.i(applicationRequest, "<this>");
        return HttpHeaderValueParserKt.parseAndSortHeader(header(applicationRequest, HttpHeaders.INSTANCE.getAcceptLanguage()));
    }

    public static final String authorization(ApplicationRequest applicationRequest) {
        p.i(applicationRequest, "<this>");
        return header(applicationRequest, HttpHeaders.INSTANCE.getAuthorization());
    }

    public static final String cacheControl(ApplicationRequest applicationRequest) {
        p.i(applicationRequest, "<this>");
        return header(applicationRequest, HttpHeaders.INSTANCE.getCacheControl());
    }

    public static final Charset contentCharset(ApplicationRequest applicationRequest) {
        p.i(applicationRequest, "<this>");
        return ContentTypesKt.charset(contentType(applicationRequest));
    }

    public static final Long contentLength(ApplicationRequest applicationRequest) {
        p.i(applicationRequest, "<this>");
        String strHeader = header(applicationRequest, HttpHeaders.INSTANCE.getContentLength());
        if (strHeader != null) {
            return C.y(strHeader);
        }
        return null;
    }

    public static final ContentType contentType(ApplicationRequest applicationRequest) {
        ContentType contentType;
        p.i(applicationRequest, "<this>");
        String strHeader = header(applicationRequest, HttpHeaders.INSTANCE.getContentType());
        return (strHeader == null || (contentType = ContentType.INSTANCE.parse(strHeader)) == null) ? ContentType.INSTANCE.getAny() : contentType;
    }

    public static final String document(ApplicationRequest applicationRequest) {
        p.i(applicationRequest, "<this>");
        return H.s1(path(applicationRequest), JsonPointer.SEPARATOR, null, 2, null);
    }

    public static final HttpMethod getHttpMethod(ApplicationRequest applicationRequest) {
        p.i(applicationRequest, "<this>");
        return OriginConnectionPointKt.getOrigin(applicationRequest).getMethod();
    }

    public static final String getHttpVersion(ApplicationRequest applicationRequest) {
        p.i(applicationRequest, "<this>");
        return OriginConnectionPointKt.getOrigin(applicationRequest).getVersion();
    }

    public static final String getUri(ApplicationRequest applicationRequest) {
        p.i(applicationRequest, "<this>");
        return OriginConnectionPointKt.getOrigin(applicationRequest).getUri();
    }

    public static final String header(ApplicationRequest applicationRequest, String name) {
        p.i(applicationRequest, "<this>");
        p.i(name, "name");
        return applicationRequest.getHeaders().get(name);
    }

    public static final String host(ApplicationRequest applicationRequest) {
        p.i(applicationRequest, "<this>");
        return OriginConnectionPointKt.getOrigin(applicationRequest).getServerHost();
    }

    public static final boolean isChunked(ApplicationRequest applicationRequest) {
        p.i(applicationRequest, "<this>");
        String strHeader = header(applicationRequest, HttpHeaders.INSTANCE.getTransferEncoding());
        return strHeader != null && D.A(strHeader, e.f30859r, true) == 0;
    }

    public static final boolean isMultipart(ApplicationRequest applicationRequest) {
        p.i(applicationRequest, "<this>");
        return ContentType.MultiPart.INSTANCE.contains(contentType(applicationRequest));
    }

    public static final String location(ApplicationRequest applicationRequest) {
        p.i(applicationRequest, "<this>");
        return header(applicationRequest, HttpHeaders.INSTANCE.getLocation());
    }

    public static final String path(ApplicationRequest applicationRequest) {
        p.i(applicationRequest, "<this>");
        return H.w1(OriginConnectionPointKt.getOrigin(applicationRequest).getUri(), '?', null, 2, null);
    }

    public static final int port(ApplicationRequest applicationRequest) {
        p.i(applicationRequest, "<this>");
        return OriginConnectionPointKt.getOrigin(applicationRequest).getServerPort();
    }

    public static final String queryString(ApplicationRequest applicationRequest) {
        p.i(applicationRequest, "<this>");
        return H.m1(OriginConnectionPointKt.getOrigin(applicationRequest).getUri(), '?', "");
    }

    public static final RangesSpecifier ranges(ApplicationRequest applicationRequest) {
        p.i(applicationRequest, "<this>");
        String strHeader = header(applicationRequest, HttpHeaders.INSTANCE.getRange());
        if (strHeader != null) {
            return RangesKt.parseRangesSpecifier(strHeader);
        }
        return null;
    }

    public static final String userAgent(ApplicationRequest applicationRequest) {
        p.i(applicationRequest, "<this>");
        return header(applicationRequest, HttpHeaders.INSTANCE.getUserAgent());
    }
}
