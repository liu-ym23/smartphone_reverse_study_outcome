package io.ktor.server.response;

import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import io.ktor.http.HeadersBuilder;
import io.ktor.http.HttpHeaders;
import io.ktor.server.http.HttpDateJvmKt;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.temporal.Temporal;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a!\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0019\u0010\n\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000b\u001a\u0019\u0010\u000e\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u0019\u0010\n\u001a\u00020\u0005*\u00020\u00102\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u0011\u001a\u0019\u0010\u000e\u001a\u00020\u0005*\u00020\u00102\u0006\u0010\u000e\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u0012¨\u0006\u0013"}, d2 = {"Lio/ktor/server/response/ApplicationResponse;", "", "name", "Ljava/time/temporal/Temporal;", "date", "LY8/t;", "header", "(Lio/ktor/server/response/ApplicationResponse;Ljava/lang/String;Ljava/time/temporal/Temporal;)V", "Ljava/time/ZonedDateTime;", "dateTime", "lastModified", "(Lio/ktor/server/response/ApplicationResponse;Ljava/time/ZonedDateTime;)V", "Ljava/time/LocalDateTime;", UxipConstants.f30680s, "expires", "(Lio/ktor/server/response/ApplicationResponse;Ljava/time/LocalDateTime;)V", "Lio/ktor/http/HeadersBuilder;", "(Lio/ktor/http/HeadersBuilder;Ljava/time/ZonedDateTime;)V", "(Lio/ktor/http/HeadersBuilder;Ljava/time/LocalDateTime;)V", "ktor-server-core"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ApplicationResponsePropertiesJvmKt {
    public static final void expires(ApplicationResponse applicationResponse, LocalDateTime value) {
        p.i(applicationResponse, "<this>");
        p.i(value, "value");
        header(applicationResponse, HttpHeaders.INSTANCE.getExpires(), value);
    }

    public static final void header(ApplicationResponse applicationResponse, String name, Temporal date) {
        p.i(applicationResponse, "<this>");
        p.i(name, "name");
        p.i(date, "date");
        ResponseHeaders.append$default(applicationResponse.getHeaders(), name, HttpDateJvmKt.toHttpDateString(date), false, 4, null);
    }

    public static final void lastModified(ApplicationResponse applicationResponse, ZonedDateTime dateTime) {
        p.i(applicationResponse, "<this>");
        p.i(dateTime, "dateTime");
        header(applicationResponse, HttpHeaders.INSTANCE.getLastModified(), dateTime);
    }

    public static final void expires(HeadersBuilder headersBuilder, LocalDateTime expires) {
        p.i(headersBuilder, "<this>");
        p.i(expires, "expires");
        headersBuilder.set(HttpHeaders.INSTANCE.getExpires(), HttpDateJvmKt.toHttpDateString(expires));
    }

    public static final void lastModified(HeadersBuilder headersBuilder, ZonedDateTime dateTime) {
        p.i(headersBuilder, "<this>");
        p.i(dateTime, "dateTime");
        headersBuilder.set(HttpHeaders.INSTANCE.getLastModified(), HttpDateJvmKt.toHttpDateString(dateTime));
    }
}
