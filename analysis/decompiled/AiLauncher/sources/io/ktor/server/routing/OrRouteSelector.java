package io.ktor.server.routing;

import com.autonavi.aps.amapapi.AMapLocationStaticsEntity;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0096@¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0001HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0001HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0011J$\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u0001HÆ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u0017\u0010\u0002\u001a\u00020\u00018\u0006¢\u0006\f\n\u0004\b\u0002\u0010\u001c\u001a\u0004\b\u001d\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00018\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001c\u001a\u0004\b\u001e\u0010\u0011¨\u0006\u001f"}, d2 = {"Lio/ktor/server/routing/OrRouteSelector;", "Lio/ktor/server/routing/RouteSelector;", AMapLocationStaticsEntity.FIRST_LOCATE, "second", "<init>", "(Lio/ktor/server/routing/RouteSelector;Lio/ktor/server/routing/RouteSelector;)V", "Lio/ktor/server/routing/RoutingResolveContext;", "context", "", "segmentIndex", "Lio/ktor/server/routing/RouteSelectorEvaluation;", "evaluate", "(Lio/ktor/server/routing/RoutingResolveContext;ILe9/c;)Ljava/lang/Object;", "", "toString", "()Ljava/lang/String;", "component1", "()Lio/ktor/server/routing/RouteSelector;", "component2", ChatTracker.CLICK_COPY, "(Lio/ktor/server/routing/RouteSelector;Lio/ktor/server/routing/RouteSelector;)Lio/ktor/server/routing/OrRouteSelector;", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lio/ktor/server/routing/RouteSelector;", "getFirst", "getSecond", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class OrRouteSelector extends RouteSelector {
    private final RouteSelector first;
    private final RouteSelector second;

    @InterfaceC4112d(c = "io.ktor.server.routing.OrRouteSelector", f = "RouteSelector.kt", l = {554, 558}, m = "evaluate")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: io.ktor.server.routing.OrRouteSelector$evaluate$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return OrRouteSelector.this.evaluate(null, 0, this);
        }
    }

    public OrRouteSelector(RouteSelector first, RouteSelector second) {
        kotlin.jvm.internal.p.i(first, "first");
        kotlin.jvm.internal.p.i(second, "second");
        this.first = first;
        this.second = second;
    }

    public static /* synthetic */ OrRouteSelector copy$default(OrRouteSelector orRouteSelector, RouteSelector routeSelector, RouteSelector routeSelector2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            routeSelector = orRouteSelector.first;
        }
        if ((i10 & 2) != 0) {
            routeSelector2 = orRouteSelector.second;
        }
        return orRouteSelector.copy(routeSelector, routeSelector2);
    }

    /* renamed from: component1, reason: from getter */
    public final RouteSelector getFirst() {
        return this.first;
    }

    /* renamed from: component2, reason: from getter */
    public final RouteSelector getSecond() {
        return this.second;
    }

    public final OrRouteSelector copy(RouteSelector first, RouteSelector second) {
        kotlin.jvm.internal.p.i(first, "first");
        kotlin.jvm.internal.p.i(second, "second");
        return new OrRouteSelector(first, second);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OrRouteSelector)) {
            return false;
        }
        OrRouteSelector orRouteSelector = (OrRouteSelector) other;
        return kotlin.jvm.internal.p.d(this.first, orRouteSelector.first) && kotlin.jvm.internal.p.d(this.second, orRouteSelector.second);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // io.ktor.server.routing.RouteSelector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object evaluate(io.ktor.server.routing.RoutingResolveContext r6, int r7, e9.InterfaceC4014c<? super io.ktor.server.routing.RouteSelectorEvaluation> r8) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r8 instanceof io.ktor.server.routing.OrRouteSelector.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r8
            io.ktor.server.routing.OrRouteSelector$evaluate$1 r0 = (io.ktor.server.routing.OrRouteSelector.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.server.routing.OrRouteSelector$evaluate$1 r0 = new io.ktor.server.routing.OrRouteSelector$evaluate$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3e
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.C4849c.b(r8)
            return r8
        L2c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L34:
            int r7 = r0.I$0
            java.lang.Object r6 = r0.L$0
            io.ktor.server.routing.RoutingResolveContext r6 = (io.ktor.server.routing.RoutingResolveContext) r6
            kotlin.C4849c.b(r8)
            goto L50
        L3e:
            kotlin.C4849c.b(r8)
            io.ktor.server.routing.RouteSelector r8 = r5.first
            r0.L$0 = r6
            r0.I$0 = r7
            r0.label = r4
            java.lang.Object r8 = r8.evaluate(r6, r7, r0)
            if (r8 != r1) goto L50
            goto L66
        L50:
            io.ktor.server.routing.RouteSelectorEvaluation r8 = (io.ktor.server.routing.RouteSelectorEvaluation) r8
            boolean r2 = r8.getSucceeded()
            if (r2 == 0) goto L59
            return r8
        L59:
            io.ktor.server.routing.RouteSelector r5 = r5.second
            r8 = 0
            r0.L$0 = r8
            r0.label = r3
            java.lang.Object r5 = r5.evaluate(r6, r7, r0)
            if (r5 != r1) goto L67
        L66:
            return r1
        L67:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.server.routing.OrRouteSelector.evaluate(io.ktor.server.routing.RoutingResolveContext, int, e9.c):java.lang.Object");
    }

    public final RouteSelector getFirst() {
        return this.first;
    }

    public final RouteSelector getSecond() {
        return this.second;
    }

    public int hashCode() {
        return (this.first.hashCode() * 31) + this.second.hashCode();
    }

    public String toString() {
        return '{' + this.first + " | " + this.second + '}';
    }
}
