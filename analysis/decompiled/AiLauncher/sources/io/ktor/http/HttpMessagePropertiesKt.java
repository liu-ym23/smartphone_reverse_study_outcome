package io.ktor.http;

import Z8.C1172u;
import Z8.C1173v;
import Z8.C1174w;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ame.sdk.SkillStoreKt;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import io.ktor.http.auth.HttpAuthHeader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0019\u0010\b\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t\u001a\u0019\u0010\f\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\r\u001a\u0019\u0010\u000f\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u000e\u001a\u00020\n¢\u0006\u0004\b\u000f\u0010\r\u001a\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0001*\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0010\u001a\u0019\u0010\u0013\u001a\n\u0018\u00010\u0011j\u0004\u0018\u0001`\u0012*\u00020\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u0013\u0010\u0015\u001a\u0004\u0018\u00010\n*\u00020\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u0019\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017*\u00020\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u001a*\u00020\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0001*\u00020\u001d¢\u0006\u0004\b\u0004\u0010\u001e\u001a\u0019\u0010\u0013\u001a\n\u0018\u00010\u0011j\u0004\u0018\u0001`\u0012*\u00020\u001d¢\u0006\u0004\b\u0013\u0010\u001f\u001a\u0013\u0010\u0015\u001a\u0004\u0018\u00010\n*\u00020\u001d¢\u0006\u0004\b\u0015\u0010 \u001a\u0019\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017*\u00020\u001d¢\u0006\u0004\b\u0018\u0010!\u001a\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u001a*\u00020\u001d¢\u0006\u0004\b\u001b\u0010\"\u001a\u0017\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\u0017*\u00020\u001d¢\u0006\u0004\b$\u0010!\u001a\u0017\u0010%\u001a\b\u0012\u0004\u0012\u00020#0\u0017*\u00020\u0000¢\u0006\u0004\b%\u0010\u0019\u001a\u0017\u0010'\u001a\b\u0012\u0004\u0012\u00020&0\u0017*\u00020\u001d¢\u0006\u0004\b'\u0010!\u001a\u0019\u0010(\u001a\b\u0012\u0004\u0012\u00020\n0\u0017*\u00020\nH\u0000¢\u0006\u0004\b(\u0010)¨\u0006*"}, d2 = {"Lio/ktor/http/HttpMessageBuilder;", "Lio/ktor/http/ContentType;", "type", "LY8/t;", "contentType", "(Lio/ktor/http/HttpMessageBuilder;Lio/ktor/http/ContentType;)V", "", "seconds", "maxAge", "(Lio/ktor/http/HttpMessageBuilder;I)V", "", UxipConstants.f30680s, "ifNoneMatch", "(Lio/ktor/http/HttpMessageBuilder;Ljava/lang/String;)V", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "userAgent", "(Lio/ktor/http/HttpMessageBuilder;)Lio/ktor/http/ContentType;", "Ljava/nio/charset/Charset;", "Lio/ktor/utils/io/charsets/Charset;", HttpAuthHeader.Parameters.Charset, "(Lio/ktor/http/HttpMessageBuilder;)Ljava/nio/charset/Charset;", "etag", "(Lio/ktor/http/HttpMessageBuilder;)Ljava/lang/String;", "", "vary", "(Lio/ktor/http/HttpMessageBuilder;)Ljava/util/List;", "", "contentLength", "(Lio/ktor/http/HttpMessageBuilder;)Ljava/lang/Long;", "Lio/ktor/http/HttpMessage;", "(Lio/ktor/http/HttpMessage;)Lio/ktor/http/ContentType;", "(Lio/ktor/http/HttpMessage;)Ljava/nio/charset/Charset;", "(Lio/ktor/http/HttpMessage;)Ljava/lang/String;", "(Lio/ktor/http/HttpMessage;)Ljava/util/List;", "(Lio/ktor/http/HttpMessage;)Ljava/lang/Long;", "Lio/ktor/http/Cookie;", "setCookie", "cookies", "Lio/ktor/http/HeaderValue;", "cacheControl", "splitSetCookieHeader", "(Ljava/lang/String;)Ljava/util/List;", "ktor-http"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class HttpMessagePropertiesKt {
    public static final List<HeaderValue> cacheControl(HttpMessage httpMessage) {
        List<HeaderValue> headerValue;
        kotlin.jvm.internal.p.i(httpMessage, "<this>");
        String str = httpMessage.getHeaders().get(HttpHeaders.INSTANCE.getCacheControl());
        return (str == null || (headerValue = HttpHeaderValueParserKt.parseHeaderValue(str)) == null) ? C1173v.m() : headerValue;
    }

    public static final Charset charset(HttpMessageBuilder httpMessageBuilder) {
        kotlin.jvm.internal.p.i(httpMessageBuilder, "<this>");
        ContentType contentType = contentType(httpMessageBuilder);
        if (contentType != null) {
            return ContentTypesKt.charset(contentType);
        }
        return null;
    }

    public static final Long contentLength(HttpMessageBuilder httpMessageBuilder) {
        kotlin.jvm.internal.p.i(httpMessageBuilder, "<this>");
        String str = httpMessageBuilder.getHeaders().get(HttpHeaders.INSTANCE.getContentLength());
        if (str != null) {
            return Long.valueOf(Long.parseLong(str));
        }
        return null;
    }

    public static final void contentType(HttpMessageBuilder httpMessageBuilder, ContentType type) {
        kotlin.jvm.internal.p.i(httpMessageBuilder, "<this>");
        kotlin.jvm.internal.p.i(type, "type");
        httpMessageBuilder.getHeaders().set(HttpHeaders.INSTANCE.getContentType(), type.toString());
    }

    public static final List<Cookie> cookies(HttpMessageBuilder httpMessageBuilder) {
        kotlin.jvm.internal.p.i(httpMessageBuilder, "<this>");
        List<String> all = httpMessageBuilder.getHeaders().getAll(HttpHeaders.INSTANCE.getSetCookie());
        if (all == null) {
            return C1173v.m();
        }
        List<String> list = all;
        ArrayList arrayList = new ArrayList(C1174w.x(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(CookieKt.parseServerSetCookieHeader((String) it.next()));
        }
        return arrayList;
    }

    public static final String etag(HttpMessageBuilder httpMessageBuilder) {
        kotlin.jvm.internal.p.i(httpMessageBuilder, "<this>");
        return httpMessageBuilder.getHeaders().get(HttpHeaders.INSTANCE.getETag());
    }

    public static final void ifNoneMatch(HttpMessageBuilder httpMessageBuilder, String value) {
        kotlin.jvm.internal.p.i(httpMessageBuilder, "<this>");
        kotlin.jvm.internal.p.i(value, "value");
        httpMessageBuilder.getHeaders().set(HttpHeaders.INSTANCE.getIfNoneMatch(), value);
    }

    public static final void maxAge(HttpMessageBuilder httpMessageBuilder, int i10) {
        kotlin.jvm.internal.p.i(httpMessageBuilder, "<this>");
        httpMessageBuilder.getHeaders().append(HttpHeaders.INSTANCE.getCacheControl(), "max-age=" + i10);
    }

    public static final List<Cookie> setCookie(HttpMessage httpMessage) {
        kotlin.jvm.internal.p.i(httpMessage, "<this>");
        List<String> all = httpMessage.getHeaders().getAll(HttpHeaders.INSTANCE.getSetCookie());
        if (all == null) {
            return C1173v.m();
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = all.iterator();
        while (it.hasNext()) {
            Z8.A.E(arrayList, splitSetCookieHeader((String) it.next()));
        }
        ArrayList arrayList2 = new ArrayList(C1174w.x(arrayList, 10));
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            arrayList2.add(CookieKt.parseServerSetCookieHeader((String) it2.next()));
        }
        return arrayList2;
    }

    public static final List<String> splitSetCookieHeader(String str) {
        int i10;
        String str2;
        int i11;
        int i12;
        kotlin.jvm.internal.p.i(str, "<this>");
        int iT0 = La.H.t0(str, ',', 0, false, 6, null);
        if (iT0 == -1) {
            return C1172u.e(str);
        }
        ArrayList arrayList = new ArrayList();
        String str3 = str;
        int iT02 = La.H.t0(str3, '=', iT0, false, 4, null);
        int iT03 = La.H.t0(str3, ';', iT0, false, 4, null);
        int i13 = 0;
        int i14 = iT0;
        int iT04 = iT03;
        while (i13 < str3.length() && i14 > 0) {
            if (iT02 < i14) {
                String str4 = str3;
                int iT05 = La.H.t0(str4, '=', i14, false, 4, null);
                i10 = i14;
                str2 = str4;
                i11 = iT05;
            } else {
                String str5 = str3;
                i10 = i14;
                str2 = str5;
                i11 = iT02;
            }
            String str6 = str2;
            int iT06 = La.H.t0(str6, ',', i10 + 1, false, 4, null);
            while (true) {
                i12 = i10;
                i10 = iT06;
                if (i10 < 0 || i10 >= i11) {
                    break;
                }
                iT06 = La.H.t0(str6, ',', i10 + 1, false, 4, null);
            }
            if (iT04 < i12) {
                iT04 = La.H.t0(str6, ';', i12, false, 4, null);
            }
            if (i11 < 0) {
                String strSubstring = str6.substring(i13);
                kotlin.jvm.internal.p.h(strSubstring, "substring(...)");
                arrayList.add(strSubstring);
                return arrayList;
            }
            if (iT04 == -1 || iT04 > i11) {
                String strSubstring2 = str6.substring(i13, i12);
                kotlin.jvm.internal.p.h(strSubstring2, "substring(...)");
                arrayList.add(strSubstring2);
                i13 = i12 + 1;
            }
            i14 = i10;
            str3 = str6;
            iT02 = i11;
        }
        String str7 = str3;
        if (i13 < str7.length()) {
            String strSubstring3 = str7.substring(i13);
            kotlin.jvm.internal.p.h(strSubstring3, "substring(...)");
            arrayList.add(strSubstring3);
        }
        return arrayList;
    }

    public static final void userAgent(HttpMessageBuilder httpMessageBuilder, String content) {
        kotlin.jvm.internal.p.i(httpMessageBuilder, "<this>");
        kotlin.jvm.internal.p.i(content, "content");
        httpMessageBuilder.getHeaders().set(HttpHeaders.INSTANCE.getUserAgent(), content);
    }

    public static final List<String> vary(HttpMessageBuilder httpMessageBuilder) {
        kotlin.jvm.internal.p.i(httpMessageBuilder, "<this>");
        List<String> all = httpMessageBuilder.getHeaders().getAll(HttpHeaders.INSTANCE.getVary());
        if (all == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = all.iterator();
        while (it.hasNext()) {
            List listB1 = La.H.b1((String) it.next(), new String[]{Const.STR_MART_COMMA}, false, 0, 6, null);
            ArrayList arrayList2 = new ArrayList(C1174w.x(listB1, 10));
            Iterator it2 = listB1.iterator();
            while (it2.hasNext()) {
                arrayList2.add(La.H.D1((String) it2.next()).toString());
            }
            Z8.A.E(arrayList, arrayList2);
        }
        return arrayList;
    }

    public static final Charset charset(HttpMessage httpMessage) {
        kotlin.jvm.internal.p.i(httpMessage, "<this>");
        ContentType contentType = contentType(httpMessage);
        if (contentType != null) {
            return ContentTypesKt.charset(contentType);
        }
        return null;
    }

    public static final Long contentLength(HttpMessage httpMessage) {
        kotlin.jvm.internal.p.i(httpMessage, "<this>");
        String str = httpMessage.getHeaders().get(HttpHeaders.INSTANCE.getContentLength());
        if (str != null) {
            return Long.valueOf(Long.parseLong(str));
        }
        return null;
    }

    public static final ContentType contentType(HttpMessageBuilder httpMessageBuilder) {
        kotlin.jvm.internal.p.i(httpMessageBuilder, "<this>");
        String str = httpMessageBuilder.getHeaders().get(HttpHeaders.INSTANCE.getContentType());
        if (str != null) {
            return ContentType.INSTANCE.parse(str);
        }
        return null;
    }

    public static final String etag(HttpMessage httpMessage) {
        kotlin.jvm.internal.p.i(httpMessage, "<this>");
        return httpMessage.getHeaders().get(HttpHeaders.INSTANCE.getETag());
    }

    public static final ContentType contentType(HttpMessage httpMessage) {
        kotlin.jvm.internal.p.i(httpMessage, "<this>");
        String str = httpMessage.getHeaders().get(HttpHeaders.INSTANCE.getContentType());
        if (str != null) {
            return ContentType.INSTANCE.parse(str);
        }
        return null;
    }

    public static final List<String> vary(HttpMessage httpMessage) {
        kotlin.jvm.internal.p.i(httpMessage, "<this>");
        List<String> all = httpMessage.getHeaders().getAll(HttpHeaders.INSTANCE.getVary());
        if (all == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = all.iterator();
        while (it.hasNext()) {
            List listB1 = La.H.b1((String) it.next(), new String[]{Const.STR_MART_COMMA}, false, 0, 6, null);
            ArrayList arrayList2 = new ArrayList(C1174w.x(listB1, 10));
            Iterator it2 = listB1.iterator();
            while (it2.hasNext()) {
                arrayList2.add(La.H.D1((String) it2.next()).toString());
            }
            Z8.A.E(arrayList, arrayList2);
        }
        return arrayList;
    }
}
