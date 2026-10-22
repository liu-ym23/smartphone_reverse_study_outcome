package com.stepos.agentbus.generated;

import androidx.core.app.NotificationCompat;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u0017\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005HÆ\u0003J+\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001f\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/stepos/agentbus/generated/CustomEvent;", "", NotificationCompat.CATEGORY_EVENT, "", "payload", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/util/Map;)V", "getEvent", "()Ljava/lang/String;", "getPayload", "()Ljava/util/Map;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "agentbus-client_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class CustomEvent {
    private final String event;
    private final Map<String, Object> payload;

    public CustomEvent(String event, Map<String, ? extends Object> payload) {
        k.f(event, "event");
        k.f(payload, "payload");
        this.event = event;
        this.payload = payload;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CustomEvent copy$default(CustomEvent customEvent, String str, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            str = customEvent.event;
        }
        if ((i & 2) != 0) {
            map = customEvent.payload;
        }
        return customEvent.copy(str, map);
    }

    /* renamed from: component1, reason: from getter */
    public final String getEvent() {
        return this.event;
    }

    public final Map<String, Object> component2() {
        return this.payload;
    }

    public final CustomEvent copy(String event, Map<String, ? extends Object> payload) {
        k.f(event, "event");
        k.f(payload, "payload");
        return new CustomEvent(event, payload);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CustomEvent)) {
            return false;
        }
        CustomEvent customEvent = (CustomEvent) other;
        return k.b(this.event, customEvent.event) && k.b(this.payload, customEvent.payload);
    }

    public final String getEvent() {
        return this.event;
    }

    public final Map<String, Object> getPayload() {
        return this.payload;
    }

    public int hashCode() {
        return this.payload.hashCode() + (this.event.hashCode() * 31);
    }

    public String toString() {
        return "CustomEvent(event=" + this.event + ", payload=" + this.payload + ")";
    }
}
