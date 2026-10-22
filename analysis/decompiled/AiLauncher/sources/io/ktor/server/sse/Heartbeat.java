package io.ktor.server.sse;

import io.ktor.sse.ServerSentEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.time.DurationUnit;
import kotlin.time.a;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lio/ktor/server/sse/Heartbeat;", "", "<init>", "()V", "Lkotlin/time/a;", "period", "J", "getPeriod-UwyO8pc", "()J", "setPeriod-LRDsOJo", "(J)V", "Lio/ktor/sse/ServerSentEvent;", "event", "Lio/ktor/sse/ServerSentEvent;", "getEvent", "()Lio/ktor/sse/ServerSentEvent;", "setEvent", "(Lio/ktor/sse/ServerSentEvent;)V", "ktor-server-sse"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class Heartbeat {
    private ServerSentEvent event;
    private long period;

    public Heartbeat() {
        a.Companion companion = kotlin.time.a.INSTANCE;
        this.period = kotlin.time.b.s(30, DurationUnit.SECONDS);
        this.event = new ServerSentEvent(null, null, null, null, "heartbeat", 15, null);
    }

    public final ServerSentEvent getEvent() {
        return this.event;
    }

    /* renamed from: getPeriod-UwyO8pc, reason: not valid java name and from getter */
    public final long getPeriod() {
        return this.period;
    }

    public final void setEvent(ServerSentEvent serverSentEvent) {
        p.i(serverSentEvent, "<set-?>");
        this.event = serverSentEvent;
    }

    /* renamed from: setPeriod-LRDsOJo, reason: not valid java name */
    public final void m179setPeriodLRDsOJo(long j10) {
        this.period = j10;
    }
}
