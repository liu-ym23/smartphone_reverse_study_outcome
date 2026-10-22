package com.obric.tracker.event;

import com.obric.tracker.intf.event.ISlardarEvent;
import com.obric.tracker.intf.event.ITeaEvent;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: ContactsAppLaunchEvent.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006J\t\u0010\f\u001a\u00020\u0004HÆ\u0003J\t\u0010\r\u001a\u00020\u0004HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\b\u0010\u0013\u001a\u00020\u0004H\u0016J\u0014\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00120\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0004H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0014\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00120\u0015H\u0016J\u0014\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001b0\u0015H\u0016J\b\u0010\u001c\u001a\u00020\u0004H\u0016J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0004HÖ\u0001R\u001a\u0010\u0005\u001a\u00020\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\b¨\u0006 "}, d2 = {"Lcom/obric/tracker/event/ContactsAppLaunchEvent;", "Lcom/obric/tracker/intf/event/ITeaEvent;", "Lcom/obric/tracker/intf/event/ISlardarEvent;", "tabName", "", "eventId", "(Ljava/lang/String;Ljava/lang/String;)V", "getEventId", "()Ljava/lang/String;", "setEventId", "(Ljava/lang/String;)V", "getTabName", "component1", "component2", "copy", "equals", "", "other", "", "getAction", "getCategoryParams", "", "getEventName", "getEventParams", "Lorg/json/JSONObject;", "getExtraParams", "getMetricsParams", "", "getScene", "hashCode", "", "toString", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ContactsAppLaunchEvent implements ITeaEvent, ISlardarEvent {
    private String eventId;
    private final String tabName;

    /* JADX WARN: Multi-variable type inference failed */
    public ContactsAppLaunchEvent() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ ContactsAppLaunchEvent copy$default(ContactsAppLaunchEvent r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.tabName;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.eventId;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.tabName;
    }

    public final String component2() {
        return this.eventId;
    }

    public final ContactsAppLaunchEvent copy(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "tabName");
        Intrinsics.checkNotNullParameter(r2, "eventId");
        return new ContactsAppLaunchEvent(r1, r2);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ContactsAppLaunchEvent) == true) goto L8;
        return false;
    L8:
        ContactsAppLaunchEvent r6 = (ContactsAppLaunchEvent) r5;
        if (Intrinsics.areEqual(this.tabName, r6.tabName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.eventId, r6.eventId) == true) goto L14;
        return false;
    L14:
        return true;
    }

    @Override // com.obric.tracker.intf.event.ISlardarEvent
    /* JADX INFO: renamed from: getAction */
    public String mo779getAction() {
        return EventNameConstantsKt.CONTACTS_APP_LAUNCH_EVENT;
    }

    @Override // com.obric.tracker.intf.event.ITeaEvent
    public String getEventName() {
        return EventNameConstantsKt.CONTACTS_APP_LAUNCH_EVENT;
    }

    @Override // com.obric.tracker.intf.event.ISlardarEvent
    public String getScene() {
        return "scene";
    }

    public int hashCode() {
        return (this.tabName.hashCode() * 31) + this.eventId.hashCode();
    }

    public String toString() {
        return "ContactsAppLaunchEvent(tabName=" + this.tabName + ", eventId=" + this.eventId + ')';
    }

    public ContactsAppLaunchEvent(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "tabName");
        Intrinsics.checkNotNullParameter(r3, "eventId");
        this.tabName = r2;
        this.eventId = r3;
    }

    public /* synthetic */ ContactsAppLaunchEvent(String r2, String r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = "";
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = "";
    L8:
        this(r2, r3);
    }

    public final String getTabName() {
        return this.tabName;
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
        if (this.tabName.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return new LinkedHashMap();
    L9:
        return MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("tab_name", this.tabName)});
    L5:
        r0 = false;
        goto L6
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
        JSONObject r0 = new JSONObject();
        if (this.tabName.length() <= 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L8;
        r0.put("tab_name", this.tabName);
    L8:
        return r0;
    L5:
        r1 = false;
        goto L6
    }
}
