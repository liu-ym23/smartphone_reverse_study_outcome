package io.ktor.server.routing;

import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ$\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0015\u0010\tR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\tR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0018\u001a\u0004\b\u0019\u0010\u000b¨\u0006\u001a"}, d2 = {"Lio/ktor/server/routing/RoutingPathSegment;", "", "", UxipConstants.f30680s, "Lio/ktor/server/routing/RoutingPathSegmentKind;", "kind", "<init>", "(Ljava/lang/String;Lio/ktor/server/routing/RoutingPathSegmentKind;)V", "component1", "()Ljava/lang/String;", "component2", "()Lio/ktor/server/routing/RoutingPathSegmentKind;", ChatTracker.CLICK_COPY, "(Ljava/lang/String;Lio/ktor/server/routing/RoutingPathSegmentKind;)Lio/ktor/server/routing/RoutingPathSegment;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getValue", "Lio/ktor/server/routing/RoutingPathSegmentKind;", "getKind", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class RoutingPathSegment {
    private final RoutingPathSegmentKind kind;
    private final String value;

    public RoutingPathSegment(String value, RoutingPathSegmentKind kind) {
        kotlin.jvm.internal.p.i(value, "value");
        kotlin.jvm.internal.p.i(kind, "kind");
        this.value = value;
        this.kind = kind;
    }

    public static /* synthetic */ RoutingPathSegment copy$default(RoutingPathSegment routingPathSegment, String str, RoutingPathSegmentKind routingPathSegmentKind, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = routingPathSegment.value;
        }
        if ((i10 & 2) != 0) {
            routingPathSegmentKind = routingPathSegment.kind;
        }
        return routingPathSegment.copy(str, routingPathSegmentKind);
    }

    /* renamed from: component1, reason: from getter */
    public final String getValue() {
        return this.value;
    }

    /* renamed from: component2, reason: from getter */
    public final RoutingPathSegmentKind getKind() {
        return this.kind;
    }

    public final RoutingPathSegment copy(String value, RoutingPathSegmentKind kind) {
        kotlin.jvm.internal.p.i(value, "value");
        kotlin.jvm.internal.p.i(kind, "kind");
        return new RoutingPathSegment(value, kind);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RoutingPathSegment)) {
            return false;
        }
        RoutingPathSegment routingPathSegment = (RoutingPathSegment) other;
        return kotlin.jvm.internal.p.d(this.value, routingPathSegment.value) && this.kind == routingPathSegment.kind;
    }

    public final RoutingPathSegmentKind getKind() {
        return this.kind;
    }

    public final String getValue() {
        return this.value;
    }

    public int hashCode() {
        return (this.value.hashCode() * 31) + this.kind.hashCode();
    }

    public String toString() {
        return "RoutingPathSegment(value=" + this.value + ", kind=" + this.kind + ')';
    }
}
