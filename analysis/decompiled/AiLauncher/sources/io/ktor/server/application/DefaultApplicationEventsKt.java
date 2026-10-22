package io.ktor.server.application;

import io.ktor.events.EventDefinition;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\"\u001d\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00008\u0006¢\u0006\f\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\"\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00008\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\u0005\"\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\u00008\u0006¢\u0006\f\n\u0004\b\b\u0010\u0003\u001a\u0004\b\t\u0010\u0005\"\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u00008\u0006¢\u0006\f\n\u0004\b\n\u0010\u0003\u001a\u0004\b\u000b\u0010\u0005\"\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u00008\u0006¢\u0006\f\n\u0004\b\r\u0010\u0003\u001a\u0004\b\u000e\u0010\u0005\"\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u00008\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0003\u001a\u0004\b\u0010\u0010\u0005\"\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00010\u00008\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0003\u001a\u0004\b\u0012\u0010\u0005\"\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00010\u00008\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0003\u001a\u0004\b\u0014\u0010\u0005¨\u0006\u0015"}, d2 = {"Lio/ktor/events/EventDefinition;", "Lio/ktor/server/application/Application;", "ApplicationStarting", "Lio/ktor/events/EventDefinition;", "getApplicationStarting", "()Lio/ktor/events/EventDefinition;", "ApplicationModulesLoading", "getApplicationModulesLoading", "ApplicationModulesLoaded", "getApplicationModulesLoaded", "ApplicationStarted", "getApplicationStarted", "Lio/ktor/server/application/ApplicationEnvironment;", "ServerReady", "getServerReady", "ApplicationStopPreparing", "getApplicationStopPreparing", "ApplicationStopping", "getApplicationStopping", "ApplicationStopped", "getApplicationStopped", "ktor-server-core"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DefaultApplicationEventsKt {
    private static final EventDefinition<Application> ApplicationStarting = new EventDefinition<>();
    private static final EventDefinition<Application> ApplicationModulesLoading = new EventDefinition<>();
    private static final EventDefinition<Application> ApplicationModulesLoaded = new EventDefinition<>();
    private static final EventDefinition<Application> ApplicationStarted = new EventDefinition<>();
    private static final EventDefinition<ApplicationEnvironment> ServerReady = new EventDefinition<>();
    private static final EventDefinition<ApplicationEnvironment> ApplicationStopPreparing = new EventDefinition<>();
    private static final EventDefinition<Application> ApplicationStopping = new EventDefinition<>();
    private static final EventDefinition<Application> ApplicationStopped = new EventDefinition<>();

    public static final EventDefinition<Application> getApplicationModulesLoaded() {
        return ApplicationModulesLoaded;
    }

    public static final EventDefinition<Application> getApplicationModulesLoading() {
        return ApplicationModulesLoading;
    }

    public static final EventDefinition<Application> getApplicationStarted() {
        return ApplicationStarted;
    }

    public static final EventDefinition<Application> getApplicationStarting() {
        return ApplicationStarting;
    }

    public static final EventDefinition<ApplicationEnvironment> getApplicationStopPreparing() {
        return ApplicationStopPreparing;
    }

    public static final EventDefinition<Application> getApplicationStopped() {
        return ApplicationStopped;
    }

    public static final EventDefinition<Application> getApplicationStopping() {
        return ApplicationStopping;
    }

    public static final EventDefinition<ApplicationEnvironment> getServerReady() {
        return ServerReady;
    }
}
