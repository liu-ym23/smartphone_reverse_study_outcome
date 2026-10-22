package io.ktor.client.plugins.api;

import Y8.t;
import io.ktor.client.HttpClient;
import io.ktor.events.EventDefinition;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\u000e\b\u0001\u0010\u0004*\b\u0012\u0004\u0012\u00028\u00000\u00032\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u00060\u0005B\u000f\u0012\u0006\u0010\b\u001a\u00028\u0001¢\u0006\u0004\b\t\u0010\nJ+\u0010\u000e\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u0006H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\b\u001a\u00028\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0010¨\u0006\u0011"}, d2 = {"Lio/ktor/client/plugins/api/MonitoringEvent;", "", "Param", "Lio/ktor/events/EventDefinition;", "Event", "Lio/ktor/client/plugins/api/ClientHook;", "Lkotlin/Function1;", "LY8/t;", "event", "<init>", "(Lio/ktor/events/EventDefinition;)V", "Lio/ktor/client/HttpClient;", "client", "handler", W4.b.STEP_INSTALL, "(Lio/ktor/client/HttpClient;Lp9/l;)V", "Lio/ktor/events/EventDefinition;", "ktor-client-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class MonitoringEvent<Param, Event extends EventDefinition<Param>> implements ClientHook<InterfaceC5074l<? super Param, ? extends t>> {
    private final Event event;

    public MonitoringEvent(Event event) {
        p.i(event, "event");
        this.event = event;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t install$lambda$0(InterfaceC5074l interfaceC5074l, Object it) {
        p.i(it, "it");
        interfaceC5074l.invoke(it);
        return t.f7040a;
    }

    @Override // io.ktor.client.plugins.api.ClientHook
    public void install(HttpClient client, final InterfaceC5074l<? super Param, t> handler) {
        p.i(client, "client");
        p.i(handler, "handler");
        client.getMonitor().subscribe(this.event, new InterfaceC5074l() { // from class: io.ktor.client.plugins.api.d
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return MonitoringEvent.install$lambda$0(handler, obj);
            }
        });
    }
}
