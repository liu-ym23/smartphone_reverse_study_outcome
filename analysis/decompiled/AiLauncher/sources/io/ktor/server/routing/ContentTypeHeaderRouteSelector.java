package io.ktor.server.routing;

import com.stepos.ailauncher.chat.trace.ChatTracker;
import e9.InterfaceC4014c;
import io.ktor.http.ContentType;
import io.ktor.http.HeaderValue;
import io.ktor.http.HttpHeaderValueParserKt;
import io.ktor.http.HttpHeaders;
import io.ktor.http.HttpStatusCode;
import io.ktor.server.request.ApplicationRequestPropertiesKt;
import io.ktor.server.routing.RouteSelectorEvaluation;
import java.util.Iterator;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0080\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0096@¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001b\u001a\u0004\b\u001c\u0010\u0011R\u0014\u0010\u001e\u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lio/ktor/server/routing/ContentTypeHeaderRouteSelector;", "Lio/ktor/server/routing/RouteSelector;", "Lio/ktor/http/ContentType;", "contentType", "<init>", "(Lio/ktor/http/ContentType;)V", "Lio/ktor/server/routing/RoutingResolveContext;", "context", "", "segmentIndex", "Lio/ktor/server/routing/RouteSelectorEvaluation;", "evaluate", "(Lio/ktor/server/routing/RoutingResolveContext;ILe9/c;)Ljava/lang/Object;", "", "toString", "()Ljava/lang/String;", "component1", "()Lio/ktor/http/ContentType;", ChatTracker.CLICK_COPY, "(Lio/ktor/http/ContentType;)Lio/ktor/server/routing/ContentTypeHeaderRouteSelector;", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lio/ktor/http/ContentType;", "getContentType", "Lio/ktor/server/routing/RouteSelectorEvaluation$Failure;", "failedEvaluation", "Lio/ktor/server/routing/RouteSelectorEvaluation$Failure;", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class ContentTypeHeaderRouteSelector extends RouteSelector {
    private final ContentType contentType;
    private final RouteSelectorEvaluation.Failure failedEvaluation;

    public ContentTypeHeaderRouteSelector(ContentType contentType) {
        kotlin.jvm.internal.p.i(contentType, "contentType");
        this.contentType = contentType;
        this.failedEvaluation = new RouteSelectorEvaluation.Failure(0.01d, HttpStatusCode.INSTANCE.getUnsupportedMediaType());
    }

    public static /* synthetic */ ContentTypeHeaderRouteSelector copy$default(ContentTypeHeaderRouteSelector contentTypeHeaderRouteSelector, ContentType contentType, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            contentType = contentTypeHeaderRouteSelector.contentType;
        }
        return contentTypeHeaderRouteSelector.copy(contentType);
    }

    /* renamed from: component1, reason: from getter */
    public final ContentType getContentType() {
        return this.contentType;
    }

    public final ContentTypeHeaderRouteSelector copy(ContentType contentType) {
        kotlin.jvm.internal.p.i(contentType, "contentType");
        return new ContentTypeHeaderRouteSelector(contentType);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ContentTypeHeaderRouteSelector) && kotlin.jvm.internal.p.d(this.contentType, ((ContentTypeHeaderRouteSelector) other).contentType);
    }

    @Override // io.ktor.server.routing.RouteSelector
    public Object evaluate(RoutingResolveContext routingResolveContext, int i10, InterfaceC4014c<? super RouteSelectorEvaluation> interfaceC4014c) {
        Object next;
        Iterator<T> it = HttpHeaderValueParserKt.parseAndSortContentTypeHeader(ApplicationRequestPropertiesKt.header(routingResolveContext.getCall().getRequest(), HttpHeaders.INSTANCE.getContentType())).iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (ContentType.INSTANCE.parse(((HeaderValue) next).getValue()).match(this.contentType)) {
                break;
            }
        }
        HeaderValue headerValue = (HeaderValue) next;
        return headerValue == null ? this.failedEvaluation : new RouteSelectorEvaluation.Success(headerValue.getQuality(), null, 0, 6, null);
    }

    public final ContentType getContentType() {
        return this.contentType;
    }

    public int hashCode() {
        return this.contentType.hashCode();
    }

    public String toString() {
        return "(contentType = " + this.contentType + ')';
    }
}
