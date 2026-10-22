package a4;

import com.autonavi.aps.amapapi.config.Const;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\tR%\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u0015¨\u0006\u0016"}, d2 = {"La4/r;", "", "", "event", "", "payload", "<init>", "(Ljava/lang/String;Ljava/util/Map;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "Ljava/util/Map;", "()Ljava/util/Map;", "protocol_agentbus_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: a4.r, reason: from toString */
/* loaded from: classes2.dex */
public final /* data */ class CustomEvent {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final String event;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final Map<String, Object> payload;

    public CustomEvent(String event, Map<String, ? extends Object> payload) {
        kotlin.jvm.internal.p.i(event, "event");
        kotlin.jvm.internal.p.i(payload, "payload");
        this.event = event;
        this.payload = payload;
    }

    /* renamed from: a, reason: from getter */
    public final String getEvent() {
        return this.event;
    }

    public final Map<String, Object> b() {
        return this.payload;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CustomEvent)) {
            return false;
        }
        CustomEvent customEvent = (CustomEvent) other;
        return kotlin.jvm.internal.p.d(this.event, customEvent.event) && kotlin.jvm.internal.p.d(this.payload, customEvent.payload);
    }

    public int hashCode() {
        return (this.event.hashCode() * 31) + this.payload.hashCode();
    }

    public String toString() {
        return "CustomEvent(event=" + this.event + ", payload=" + this.payload + ")";
    }
}
