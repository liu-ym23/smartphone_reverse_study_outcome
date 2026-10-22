package io.ktor.server.routing;

import com.stepos.ailauncher.chat.trace.ChatTracker;
import e9.InterfaceC4014c;
import io.ktor.http.BadContentTypeFormatException;
import io.ktor.http.ContentType;
import io.ktor.http.HeaderValue;
import io.ktor.http.HttpHeaderValueParserKt;
import io.ktor.http.HttpHeaders;
import io.ktor.server.plugins.BadRequestException;
import io.ktor.server.routing.RouteSelectorEvaluation;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J \u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0096@¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J \u0010\u0013\u001a\u00020\u00002\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001c\u001a\u0004\b\u001d\u0010\u0012¨\u0006\u001e"}, d2 = {"Lio/ktor/server/routing/HttpMultiAcceptRouteSelector;", "Lio/ktor/server/routing/RouteSelector;", "", "Lio/ktor/http/ContentType;", "contentTypes", "<init>", "(Ljava/util/List;)V", "Lio/ktor/server/routing/RoutingResolveContext;", "context", "", "segmentIndex", "Lio/ktor/server/routing/RouteSelectorEvaluation;", "evaluate", "(Lio/ktor/server/routing/RoutingResolveContext;ILe9/c;)Ljava/lang/Object;", "", "toString", "()Ljava/lang/String;", "component1", "()Ljava/util/List;", ChatTracker.CLICK_COPY, "(Ljava/util/List;)Lio/ktor/server/routing/HttpMultiAcceptRouteSelector;", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getContentTypes", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class HttpMultiAcceptRouteSelector extends RouteSelector {
    private final List<ContentType> contentTypes;

    public HttpMultiAcceptRouteSelector(List<ContentType> contentTypes) {
        kotlin.jvm.internal.p.i(contentTypes, "contentTypes");
        this.contentTypes = contentTypes;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HttpMultiAcceptRouteSelector copy$default(HttpMultiAcceptRouteSelector httpMultiAcceptRouteSelector, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = httpMultiAcceptRouteSelector.contentTypes;
        }
        return httpMultiAcceptRouteSelector.copy(list);
    }

    public final List<ContentType> component1() {
        return this.contentTypes;
    }

    public final HttpMultiAcceptRouteSelector copy(List<ContentType> contentTypes) {
        kotlin.jvm.internal.p.i(contentTypes, "contentTypes");
        return new HttpMultiAcceptRouteSelector(contentTypes);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof HttpMultiAcceptRouteSelector) && kotlin.jvm.internal.p.d(this.contentTypes, ((HttpMultiAcceptRouteSelector) other).contentTypes);
    }

    @Override // io.ktor.server.routing.RouteSelector
    public Object evaluate(RoutingResolveContext routingResolveContext, int i10, InterfaceC4014c<? super RouteSelectorEvaluation> interfaceC4014c) throws BadRequestException {
        Object next;
        String str = routingResolveContext.getCall().getRequest().getHeaders().get(HttpHeaders.INSTANCE.getAccept());
        try {
            List<HeaderValue> andSortContentTypeHeader = HttpHeaderValueParserKt.parseAndSortContentTypeHeader(str);
            if (andSortContentTypeHeader.isEmpty()) {
                return RouteSelectorEvaluation.INSTANCE.getMissing();
            }
            Iterator<T> it = andSortContentTypeHeader.iterator();
            loop0: while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                HeaderValue headerValue = (HeaderValue) next;
                List<ContentType> list = this.contentTypes;
                if (!(list instanceof Collection) || !list.isEmpty()) {
                    Iterator<T> it2 = list.iterator();
                    while (it2.hasNext()) {
                        if (RouteSelectorKt.isCompatibleWith((ContentType) it2.next(), ContentType.INSTANCE.parse(headerValue.getValue()))) {
                            break loop0;
                        }
                    }
                }
            }
            HeaderValue headerValue2 = (HeaderValue) next;
            return headerValue2 != null ? new RouteSelectorEvaluation.Success(headerValue2.getQuality(), null, 0, 6, null) : RouteSelectorEvaluation.INSTANCE.getFailedAcceptHeader();
        } catch (BadContentTypeFormatException e10) {
            throw new BadRequestException("Illegal Accept header format: " + str, e10);
        }
    }

    public final List<ContentType> getContentTypes() {
        return this.contentTypes;
    }

    public int hashCode() {
        return this.contentTypes.hashCode();
    }

    public String toString() {
        return "(contentTypes:" + this.contentTypes + ')';
    }
}
