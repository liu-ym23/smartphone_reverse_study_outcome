package io.ktor.server.response;

import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import io.ktor.http.CacheControl;
import io.ktor.http.ContentRangeKt;
import io.ktor.http.HeadersBuilder;
import io.ktor.http.HttpHeaders;
import io.ktor.http.RangeUnits;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import v9.C5683l;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a!\u0010\u0005\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001¢\u0006\u0004\b\u0005\u0010\u0006\u001a!\u0010\u0005\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0007¢\u0006\u0004\b\u0005\u0010\b\u001a!\u0010\u0005\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\t¢\u0006\u0004\b\u0005\u0010\n\u001a\u0019\u0010\u000b\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0001¢\u0006\u0004\b\u000b\u0010\f\u001a\u0019\u0010\u000e\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\u0003\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u0019\u0010\u000e\u001a\u00020\u0004*\u00020\u00102\u0006\u0010\u0003\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u0011\u001a1\u0010\u0016\u001a\u00020\u0004*\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u0015\u001a\u00020\u0001¢\u0006\u0004\b\u0016\u0010\u0017\u001a/\u0010\u0016\u001a\u00020\u0004*\u00020\u00002\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0015\u001a\u00020\u0018¢\u0006\u0004\b\u0016\u0010\u0019\u001a1\u0010\u0016\u001a\u00020\u0004*\u00020\u00002\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u0015\u001a\u00020\u0001¢\u0006\u0004\b\u0016\u0010\u001a¨\u0006\u001b"}, d2 = {"Lio/ktor/server/response/ApplicationResponse;", "", "name", UxipConstants.f30680s, "LY8/t;", "header", "(Lio/ktor/server/response/ApplicationResponse;Ljava/lang/String;Ljava/lang/String;)V", "", "(Lio/ktor/server/response/ApplicationResponse;Ljava/lang/String;I)V", "", "(Lio/ktor/server/response/ApplicationResponse;Ljava/lang/String;J)V", "etag", "(Lio/ktor/server/response/ApplicationResponse;Ljava/lang/String;)V", "Lio/ktor/http/CacheControl;", "cacheControl", "(Lio/ktor/server/response/ApplicationResponse;Lio/ktor/http/CacheControl;)V", "Lio/ktor/http/HeadersBuilder;", "(Lio/ktor/http/HeadersBuilder;Lio/ktor/http/CacheControl;)V", "Lv9/l;", "range", "fullLength", "unit", "contentRange", "(Lio/ktor/http/HeadersBuilder;Lv9/l;Ljava/lang/Long;Ljava/lang/String;)V", "Lio/ktor/http/RangeUnits;", "(Lio/ktor/server/response/ApplicationResponse;Lv9/l;Ljava/lang/Long;Lio/ktor/http/RangeUnits;)V", "(Lio/ktor/server/response/ApplicationResponse;Lv9/l;Ljava/lang/Long;Ljava/lang/String;)V", "ktor-server-core"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ApplicationResponsePropertiesKt {
    public static final void cacheControl(ApplicationResponse applicationResponse, CacheControl value) {
        p.i(applicationResponse, "<this>");
        p.i(value, "value");
        header(applicationResponse, HttpHeaders.INSTANCE.getCacheControl(), value.toString());
    }

    public static final void contentRange(HeadersBuilder headersBuilder, C5683l c5683l, Long l10, String unit) {
        p.i(headersBuilder, "<this>");
        p.i(unit, "unit");
        headersBuilder.append(HttpHeaders.INSTANCE.getContentRange(), ContentRangeKt.contentRangeHeaderValue(c5683l, l10, unit));
    }

    public static /* synthetic */ void contentRange$default(HeadersBuilder headersBuilder, C5683l c5683l, Long l10, String str, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            l10 = null;
        }
        if ((i10 & 4) != 0) {
            str = RangeUnits.Bytes.getUnitToken();
        }
        contentRange(headersBuilder, c5683l, l10, str);
    }

    public static final void etag(ApplicationResponse applicationResponse, String value) {
        p.i(applicationResponse, "<this>");
        p.i(value, "value");
        header(applicationResponse, HttpHeaders.INSTANCE.getETag(), value);
    }

    public static final void header(ApplicationResponse applicationResponse, String name, String value) {
        p.i(applicationResponse, "<this>");
        p.i(name, "name");
        p.i(value, "value");
        ResponseHeaders.append$default(applicationResponse.getHeaders(), name, value, false, 4, null);
    }

    public static final void cacheControl(HeadersBuilder headersBuilder, CacheControl value) {
        p.i(headersBuilder, "<this>");
        p.i(value, "value");
        headersBuilder.set(HttpHeaders.INSTANCE.getCacheControl(), value.toString());
    }

    public static final void contentRange(ApplicationResponse applicationResponse, C5683l c5683l, Long l10, RangeUnits unit) {
        p.i(applicationResponse, "<this>");
        p.i(unit, "unit");
        contentRange(applicationResponse, c5683l, l10, unit.getUnitToken());
    }

    public static final void header(ApplicationResponse applicationResponse, String name, int i10) {
        p.i(applicationResponse, "<this>");
        p.i(name, "name");
        ResponseHeaders.append$default(applicationResponse.getHeaders(), name, String.valueOf(i10), false, 4, null);
    }

    public static final void contentRange(ApplicationResponse applicationResponse, C5683l c5683l, Long l10, String unit) {
        p.i(applicationResponse, "<this>");
        p.i(unit, "unit");
        header(applicationResponse, HttpHeaders.INSTANCE.getContentRange(), ContentRangeKt.contentRangeHeaderValue(c5683l, l10, unit));
    }

    public static /* synthetic */ void contentRange$default(ApplicationResponse applicationResponse, C5683l c5683l, Long l10, RangeUnits rangeUnits, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            l10 = null;
        }
        contentRange(applicationResponse, c5683l, l10, rangeUnits);
    }

    public static final void header(ApplicationResponse applicationResponse, String name, long j10) {
        p.i(applicationResponse, "<this>");
        p.i(name, "name");
        ResponseHeaders.append$default(applicationResponse.getHeaders(), name, String.valueOf(j10), false, 4, null);
    }

    public static /* synthetic */ void contentRange$default(ApplicationResponse applicationResponse, C5683l c5683l, Long l10, String str, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            l10 = null;
        }
        if ((i10 & 4) != 0) {
            str = RangeUnits.Bytes.getUnitToken();
        }
        contentRange(applicationResponse, c5683l, l10, str);
    }
}
