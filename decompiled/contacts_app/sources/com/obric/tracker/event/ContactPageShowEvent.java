package com.obric.tracker.event;

import com.bytedance.apm.constant.TraceStatsConsts;
import com.obric.tracker.intf.event.ISlardarEvent;
import com.obric.tracker.intf.event.ITeaEvent;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: ContactPageShowEvent.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B-\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004¢\u0006\u0002\u0010\bJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0004HÆ\u0003J5\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\b\u0010\u0019\u001a\u00020\u0004H\u0016J\u0014\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00180\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u0004H\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\u0014\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00180\u001bH\u0016J\u0014\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020!0\u001bH\u0016J\b\u0010\"\u001a\u00020\u0004H\u0016J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020\u0004HÖ\u0001R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0007\u001a\u00020\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\n\"\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\n¨\u0006&"}, d2 = {"Lcom/obric/tracker/event/ContactPageShowEvent;", "Lcom/obric/tracker/intf/event/ITeaEvent;", "Lcom/obric/tracker/intf/event/ISlardarEvent;", "enter_from", "", TraceStatsConsts.PAGE_STATS_KEY_PAGE_NAME, "open_reason", "eventId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getEnter_from", "()Ljava/lang/String;", "getEventId", "setEventId", "(Ljava/lang/String;)V", "getOpen_reason", "getPage_name", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "getAction", "getCategoryParams", "", "getEventName", "getEventParams", "Lorg/json/JSONObject;", "getExtraParams", "getMetricsParams", "", "getScene", "hashCode", "", "toString", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ContactPageShowEvent implements ITeaEvent, ISlardarEvent {
    private final String enter_from;
    private String eventId;
    private final String open_reason;
    private final String page_name;

    public static /* synthetic */ ContactPageShowEvent copy$default(ContactPageShowEvent r0, String r1, String r2, String r3, String r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.enter_from;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.page_name;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.open_reason;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.eventId;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final String component1() {
        return this.enter_from;
    }

    public final String component2() {
        return this.page_name;
    }

    public final String component3() {
        return this.open_reason;
    }

    public final String component4() {
        return this.eventId;
    }

    public final ContactPageShowEvent copy(String r1, String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "open_reason");
        Intrinsics.checkNotNullParameter(r4, "eventId");
        return new ContactPageShowEvent(r1, r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ContactPageShowEvent) == true) goto L8;
        return false;
    L8:
        ContactPageShowEvent r6 = (ContactPageShowEvent) r5;
        if (Intrinsics.areEqual(this.enter_from, r6.enter_from) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.page_name, r6.page_name) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.open_reason, r6.open_reason) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.eventId, r6.eventId) == true) goto L20;
        return false;
    L20:
        return true;
    }

    @Override // com.obric.tracker.intf.event.ISlardarEvent
    /* JADX INFO: renamed from: getAction */
    public String mo779getAction() {
        return EventNameConstantsKt.CONTACT_PAGESHOW_EVENT_NAME;
    }

    @Override // com.obric.tracker.intf.event.ITeaEvent
    public String getEventName() {
        return EventNameConstantsKt.CONTACT_PAGESHOW_EVENT_NAME;
    }

    @Override // com.obric.tracker.intf.event.ISlardarEvent
    public String getScene() {
        return "scene";
    }

    public int hashCode() {
        String r0 = this.enter_from;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.page_name;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return ((((r3 + r1) * 31) + this.open_reason.hashCode()) * 31) + this.eventId.hashCode();
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "ContactPageShowEvent(enter_from=" + this.enter_from + ", page_name=" + this.page_name + ", open_reason=" + this.open_reason + ", eventId=" + this.eventId + ')';
    }

    public ContactPageShowEvent(String r2, String r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "open_reason");
        Intrinsics.checkNotNullParameter(r5, "eventId");
        this.enter_from = r2;
        this.page_name = r3;
        this.open_reason = r4;
        this.eventId = r5;
    }

    public /* synthetic */ ContactPageShowEvent(String r2, String r3, String r4, String r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 4) == 0) goto L6;
        r4 = "";
    L6:
        if ((r6 & 8) == 0) goto L8;
        r5 = "";
    L8:
        this(r2, r3, r4, r5);
    }

    public final String getEnter_from() {
        return this.enter_from;
    }

    public final String getPage_name() {
        return this.page_name;
    }

    public final String getOpen_reason() {
        return this.open_reason;
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

    @Override // com.obric.tracker.intf.event.ITeaEvent
    public JSONObject getEventParams() {
        JSONObject r0 = new JSONObject();
        r0.put(TraceStatsConsts.PAGE_STATS_KEY_PAGE_NAME, this.page_name);
        r0.put("enter_from", this.enter_from);
        return r0;
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
}
