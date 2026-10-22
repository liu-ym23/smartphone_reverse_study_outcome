package io.ktor.server.response;

import Z8.C1174w;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import io.ktor.http.Cookie;
import io.ktor.http.CookieEncoding;
import io.ktor.http.CookieKt;
import io.ktor.util.date.GMTDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import v9.C5685n;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0086\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\r\u0010\u000eJ\u0083\u0001\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u00102\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010\u001a\u001a\u00020\u00182\u0016\b\u0002\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u001b¢\u0006\u0004\b\r\u0010\u001dJ/\u0010\u001e\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0004\b\u001e\u0010\u001fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010 ¨\u0006!"}, d2 = {"Lio/ktor/server/response/ResponseCookies;", "", "Lio/ktor/server/response/PipelineResponse;", UxipConstants.f30685x, "<init>", "(Lio/ktor/server/response/PipelineResponse;)V", "", "name", "Lio/ktor/http/Cookie;", "get", "(Ljava/lang/String;)Lio/ktor/http/Cookie;", "item", "LY8/t;", "append", "(Lio/ktor/http/Cookie;)V", UxipConstants.f30680s, "Lio/ktor/http/CookieEncoding;", "encoding", "", "maxAge", "Lio/ktor/util/date/GMTDate;", "expires", "domain", "path", "", "secure", "httpOnly", "", "extensions", "(Ljava/lang/String;Ljava/lang/String;Lio/ktor/http/CookieEncoding;Ljava/lang/Long;Lio/ktor/util/date/GMTDate;Ljava/lang/String;Ljava/lang/String;ZZLjava/util/Map;)V", "appendExpired", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Lio/ktor/server/response/PipelineResponse;", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ResponseCookies {
    private final PipelineResponse response;

    public ResponseCookies(PipelineResponse response) {
        p.i(response, "response");
        this.response = response;
    }

    public static /* synthetic */ void append$default(ResponseCookies responseCookies, String str, String str2, CookieEncoding cookieEncoding, Long l10, GMTDate gMTDate, String str3, String str4, boolean z10, boolean z11, Map map, int i10, Object obj) {
        responseCookies.append(str, str2, (i10 & 4) != 0 ? CookieEncoding.URI_ENCODING : cookieEncoding, (i10 & 8) != 0 ? null : l10, (i10 & 16) != 0 ? null : gMTDate, (i10 & 32) != 0 ? null : str3, (i10 & 64) != 0 ? null : str4, (i10 & 128) != 0 ? false : z10, (i10 & 256) != 0 ? false : z11, (i10 & 512) != 0 ? kotlin.collections.a.i() : map);
    }

    public static /* synthetic */ void appendExpired$default(ResponseCookies responseCookies, String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = null;
        }
        if ((i10 & 4) != 0) {
            str3 = null;
        }
        responseCookies.appendExpired(str, str2, str3);
    }

    public final void append(Cookie item) {
        p.i(item, "item");
        ResponseHeaders.append$default(this.response.getHeaders(), "Set-Cookie", CookieKt.renderSetCookieHeader(item), false, 4, null);
    }

    public final void appendExpired(String name, String domain, String path) {
        p.i(name, "name");
        append$default(this, name, "", null, null, GMTDate.INSTANCE.getSTART(), domain, path, false, false, null, 908, null);
    }

    public final Cookie get(String name) {
        Object next;
        p.i(name, "name");
        List<String> listValues = this.response.getHeaders().values("Set-Cookie");
        ArrayList arrayList = new ArrayList(C1174w.x(listValues, 10));
        Iterator<T> it = listValues.iterator();
        while (it.hasNext()) {
            arrayList.add(CookieKt.parseServerSetCookieHeader((String) it.next()));
        }
        Iterator it2 = arrayList.iterator();
        while (true) {
            if (!it2.hasNext()) {
                next = null;
                break;
            }
            next = it2.next();
            if (p.d(((Cookie) next).getName(), name)) {
                break;
            }
        }
        return (Cookie) next;
    }

    public final void append(String name, String value, CookieEncoding encoding, Long maxAge, GMTDate expires, String domain, String path, boolean secure, boolean httpOnly, Map<String, String> extensions) {
        p.i(name, "name");
        p.i(value, "value");
        p.i(encoding, "encoding");
        p.i(extensions, "extensions");
        append(new Cookie(name, value, encoding, maxAge != null ? Integer.valueOf((int) C5685n.k(maxAge.longValue(), 2147483647L)) : null, expires, domain, path, secure, httpOnly, extensions));
    }
}
