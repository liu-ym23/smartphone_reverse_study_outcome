package com.obric.tracker.event;

import com.obric.tracker.intf.event.ISlardarEvent;
import com.obric.tracker.intf.event.ITeaEvent;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: CallScreenShowEvent.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0004HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\b\u0010\u000f\u001a\u00020\u0004H\u0016J\u0014\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000e0\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0004H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0014\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000e0\u0011H\u0016J\u0014\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00170\u0011H\u0016J\b\u0010\u0018\u001a\u00020\u0004H\u0016J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0004HÖ\u0001R\u001a\u0010\u0003\u001a\u00020\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u001c"}, d2 = {"Lcom/obric/tracker/event/CallScreenShowEvent;", "Lcom/obric/tracker/intf/event/ITeaEvent;", "Lcom/obric/tracker/intf/event/ISlardarEvent;", "eventId", "", "(Ljava/lang/String;)V", "getEventId", "()Ljava/lang/String;", "setEventId", "component1", "copy", "equals", "", "other", "", "getAction", "getCategoryParams", "", "getEventName", "getEventParams", "Lorg/json/JSONObject;", "getExtraParams", "getMetricsParams", "", "getScene", "hashCode", "", "toString", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CallScreenShowEvent implements ITeaEvent, ISlardarEvent {
    private String eventId;

    /* JADX WARN: Multi-variable type inference failed */
    public CallScreenShowEvent() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ CallScreenShowEvent copy$default(CallScreenShowEvent r0, String r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.eventId;
    L6:
        return r0.copy(r1);
    }

    public final String component1() {
        return this.eventId;
    }

    public final CallScreenShowEvent copy(String r1) {
        Intrinsics.checkNotNullParameter(r1, "eventId");
        return new CallScreenShowEvent(r1);
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof CallScreenShowEvent) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.eventId, ((CallScreenShowEvent) r4).eventId) == true) goto L11;
        return false;
    L11:
        return true;
    }

    @Override // com.obric.tracker.intf.event.ISlardarEvent
    /* JADX INFO: renamed from: getAction */
    public String mo779getAction() {
        return EventNameConstantsKt.CALL_SCREEN_SHOW_EVENT;
    }

    @Override // com.obric.tracker.intf.event.ITeaEvent
    public String getEventName() {
        return EventNameConstantsKt.CALL_SCREEN_SHOW_EVENT;
    }

    @Override // com.obric.tracker.intf.event.ISlardarEvent
    public String getScene() {
        return "scene";
    }

    public int hashCode() {
        return this.eventId.hashCode();
    }

    public String toString() {
        return "CallScreenShowEvent(eventId=" + this.eventId + ')';
    }

    public CallScreenShowEvent(String r2) {
        Intrinsics.checkNotNullParameter(r2, "eventId");
        this.eventId = r2;
    }

    public /* synthetic */ CallScreenShowEvent(String r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = "";
    L5:
        this(r1);
    }

    @Override // com.obric.tracker.intf.event.ISlardarEvent
    public String getEventId() {
        return this.eventId;
    }

    @Override // com.obric.tracker.intf.event.ISlardarEvent
    public void setEventId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.eventId = r2;
    }

    @Override // com.obric.tracker.intf.event.ISlardarEvent
    public Map<String, Object> getCategoryParams() {
        return new LinkedHashMap();
    }

    @Override // com.obric.tracker.intf.event.ISlardarEvent
    public Map<String, Long> getMetricsParams() {
        return new LinkedHashMap();
    }

    @Override // com.obric.tracker.intf.event.ISlardarEvent
    public Map<String, Object> getExtraParams() {
        return new LinkedHashMap();
    }

    @Override // com.obric.tracker.intf.event.ITeaEvent
    public JSONObject getEventParams() {
        return new JSONObject();
    }
}
