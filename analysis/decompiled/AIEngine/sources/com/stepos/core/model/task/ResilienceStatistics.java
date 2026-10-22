package com.stepos.core.model.task;

import com.stepos.core.model.resilience.CircuitBreakerStatistics;
import com.stepos.core.model.resilience.FlowStatistics;
import com.stepos.core.model.resilience.WatchdogStatistics;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ResilienceStatistics {
    private final CircuitBreakerStatistics circuitBreaker;
    private final FlowStatistics flowController;
    private final WatchdogStatistics watchdog;

    public ResilienceStatistics(FlowStatistics flowController, CircuitBreakerStatistics circuitBreaker, WatchdogStatistics watchdogStatistics) {
        g.f(flowController, "flowController");
        g.f(circuitBreaker, "circuitBreaker");
        this.flowController = flowController;
        this.circuitBreaker = circuitBreaker;
        this.watchdog = watchdogStatistics;
    }

    public static /* synthetic */ ResilienceStatistics copy$default(ResilienceStatistics resilienceStatistics, FlowStatistics flowStatistics, CircuitBreakerStatistics circuitBreakerStatistics, WatchdogStatistics watchdogStatistics, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            flowStatistics = resilienceStatistics.flowController;
        }
        if ((i10 & 2) != 0) {
            circuitBreakerStatistics = resilienceStatistics.circuitBreaker;
        }
        if ((i10 & 4) != 0) {
            watchdogStatistics = resilienceStatistics.watchdog;
        }
        return resilienceStatistics.copy(flowStatistics, circuitBreakerStatistics, watchdogStatistics);
    }

    public final FlowStatistics component1() {
        return this.flowController;
    }

    public final CircuitBreakerStatistics component2() {
        return this.circuitBreaker;
    }

    public final WatchdogStatistics component3() {
        return this.watchdog;
    }

    public final ResilienceStatistics copy(FlowStatistics flowController, CircuitBreakerStatistics circuitBreaker, WatchdogStatistics watchdogStatistics) {
        g.f(flowController, "flowController");
        g.f(circuitBreaker, "circuitBreaker");
        return new ResilienceStatistics(flowController, circuitBreaker, watchdogStatistics);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ResilienceStatistics)) {
            return false;
        }
        ResilienceStatistics resilienceStatistics = (ResilienceStatistics) obj;
        return g.b(this.flowController, resilienceStatistics.flowController) && g.b(this.circuitBreaker, resilienceStatistics.circuitBreaker) && g.b(this.watchdog, resilienceStatistics.watchdog);
    }

    public final CircuitBreakerStatistics getCircuitBreaker() {
        return this.circuitBreaker;
    }

    public final FlowStatistics getFlowController() {
        return this.flowController;
    }

    public final WatchdogStatistics getWatchdog() {
        return this.watchdog;
    }

    public int hashCode() {
        int iHashCode = (this.circuitBreaker.hashCode() + (this.flowController.hashCode() * 31)) * 31;
        WatchdogStatistics watchdogStatistics = this.watchdog;
        return iHashCode + (watchdogStatistics == null ? 0 : watchdogStatistics.hashCode());
    }

    public String toString() {
        return "ResilienceStatistics(flowController=" + this.flowController + ", circuitBreaker=" + this.circuitBreaker + ", watchdog=" + this.watchdog + ")";
    }
}
