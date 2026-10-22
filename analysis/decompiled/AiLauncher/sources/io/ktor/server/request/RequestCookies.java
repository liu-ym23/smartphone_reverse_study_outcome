package io.ktor.server.request;

import Y8.h;
import Y8.j;
import com.stepos.ailauncher.chat.voice.support.C3081a;
import io.ktor.http.CookieEncoding;
import io.ktor.http.CookieKt;
import io.ktor.util.collections.ConcurrentMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.C4848b;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.p;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J$\u0010\n\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\bH\u0086\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\fH\u0014¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0003\u001a\u00020\u00028\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R,\u0010\u0014\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00060\u0013\u0012\u0004\u0012\u00020\u00060\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R'\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u000e¨\u0006\u001a"}, d2 = {"Lio/ktor/server/request/RequestCookies;", "", "Lio/ktor/server/request/ApplicationRequest;", "request", "<init>", "(Lio/ktor/server/request/ApplicationRequest;)V", "", "name", "Lio/ktor/http/CookieEncoding;", "encoding", "get", "(Ljava/lang/String;Lio/ktor/http/CookieEncoding;)Ljava/lang/String;", "", "fetchCookies", "()Ljava/util/Map;", "Lio/ktor/server/request/ApplicationRequest;", "getRequest", "()Lio/ktor/server/request/ApplicationRequest;", "Lio/ktor/util/collections/ConcurrentMap;", "Lkotlin/Pair;", C3081a.FOCUS_MAP_NAME, "Lio/ktor/util/collections/ConcurrentMap;", "rawCookies$delegate", "LY8/h;", "getRawCookies", "rawCookies", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public class RequestCookies {
    private final ConcurrentMap<Pair<CookieEncoding, String>, String> map;

    /* renamed from: rawCookies$delegate, reason: from kotlin metadata */
    private final h rawCookies;
    private final ApplicationRequest request;

    public RequestCookies(ApplicationRequest request) {
        p.i(request, "request");
        this.request = request;
        this.map = new ConcurrentMap<>(0, 1, null);
        this.rawCookies = C4848b.b(new InterfaceC5063a() { // from class: io.ktor.server.request.a
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return this.f33442a.fetchCookies();
            }
        });
    }

    public static /* synthetic */ String get$default(RequestCookies requestCookies, String str, CookieEncoding cookieEncoding, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: get");
        }
        if ((i10 & 2) != 0) {
            cookieEncoding = CookieEncoding.URI_ENCODING;
        }
        return requestCookies.get(str, cookieEncoding);
    }

    public Map<String, String> fetchCookies() {
        List<String> all = this.request.getHeaders().getAll("Cookie");
        if (all == null) {
            return kotlin.collections.a.i();
        }
        HashMap map = new HashMap(all.size());
        Iterator<String> it = all.iterator();
        while (it.hasNext()) {
            map.putAll(CookieKt.parseClientCookiesHeader$default(it.next(), false, 2, null));
        }
        return map;
    }

    public final String get(String name, final CookieEncoding encoding) {
        p.i(name, "name");
        p.i(encoding, "encoding");
        final String str = getRawCookies().get(name);
        if (str == null) {
            return null;
        }
        return this.map.computeIfAbsent((ConcurrentMap<Pair<CookieEncoding, String>, String>) j.a(encoding, name), new InterfaceC5063a() { // from class: io.ktor.server.request.b
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return CookieKt.decodeCookieValue(str, encoding);
            }
        });
    }

    public final Map<String, String> getRawCookies() {
        return (Map) this.rawCookies.getValue();
    }

    public final ApplicationRequest getRequest() {
        return this.request;
    }
}
