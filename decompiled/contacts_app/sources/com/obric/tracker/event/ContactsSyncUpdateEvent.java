package com.obric.tracker.event;

import com.obric.matrix.platform.sdk.ones.dataanalysis.MatrixTeaManager;
import com.obric.tracker.intf.event.ISlardarEvent;
import com.obric.tracker.intf.event.ITeaEvent;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: ContactsSyncUpdateEvent.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006J\t\u0010\f\u001a\u00020\u0004HÆ\u0003J\t\u0010\r\u001a\u00020\u0004HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\b\u0010\u0013\u001a\u00020\u0004H\u0016J\u0014\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00120\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0004H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0014\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00120\u0015H\u0016J\u0014\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001b0\u0015H\u0016J\b\u0010\u001c\u001a\u00020\u0004H\u0016J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0004HÖ\u0001R\u001a\u0010\u0005\u001a\u00020\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\b¨\u0006 "}, d2 = {"Lcom/obric/tracker/event/ContactsSyncUpdateEvent;", "Lcom/obric/tracker/intf/event/ITeaEvent;", "Lcom/obric/tracker/intf/event/ISlardarEvent;", "resultText", "", "eventId", "(Ljava/lang/String;Ljava/lang/String;)V", "getEventId", "()Ljava/lang/String;", "setEventId", "(Ljava/lang/String;)V", "getResultText", "component1", "component2", "copy", "equals", "", "other", "", "getAction", "getCategoryParams", "", "getEventName", "getEventParams", "Lorg/json/JSONObject;", "getExtraParams", "getMetricsParams", "", "getScene", "hashCode", "", "toString", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ContactsSyncUpdateEvent implements ITeaEvent, ISlardarEvent {
    private String eventId;
    private final String resultText;

    public static /* synthetic */ ContactsSyncUpdateEvent copy$default(ContactsSyncUpdateEvent r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.resultText;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.eventId;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.resultText;
    }

    public final String component2() {
        return this.eventId;
    }

    public final ContactsSyncUpdateEvent copy(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "resultText");
        Intrinsics.checkNotNullParameter(r2, "eventId");
        return new ContactsSyncUpdateEvent(r1, r2);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ContactsSyncUpdateEvent) == true) goto L8;
        return false;
    L8:
        ContactsSyncUpdateEvent r6 = (ContactsSyncUpdateEvent) r5;
        if (Intrinsics.areEqual(this.resultText, r6.resultText) == true) goto L12;
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
        return EventNameConstantsKt.CONTACTS_SYNC_UPDATE_EVENT;
    }

    @Override // com.obric.tracker.intf.event.ITeaEvent
    public String getEventName() {
        return EventNameConstantsKt.CONTACTS_SYNC_UPDATE_EVENT;
    }

    @Override // com.obric.tracker.intf.event.ISlardarEvent
    public String getScene() {
        return "scene";
    }

    public int hashCode() {
        return (this.resultText.hashCode() * 31) + this.eventId.hashCode();
    }

    public String toString() {
        return "ContactsSyncUpdateEvent(resultText=" + this.resultText + ", eventId=" + this.eventId + ')';
    }

    public ContactsSyncUpdateEvent(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "resultText");
        Intrinsics.checkNotNullParameter(r3, "eventId");
        this.resultText = r2;
        this.eventId = r3;
    }

    public /* synthetic */ ContactsSyncUpdateEvent(String r1, String r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = "";
    L5:
        this(r1, r2);
    }

    public final String getResultText() {
        return this.resultText;
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
        r0.put("did", MatrixTeaManager.Companion.getInstance().getDeviceId());
        r0.put("package_name", "com.android.contacts");
        r0.put("result_text", this.resultText);
        return r0;
    }

    @Override // com.obric.tracker.intf.event.ISlardarEvent
    public Map<String, Object> getCategoryParams() {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("package_name", "com.android.contacts");
        r0.put("result_text", this.resultText);
        return r0;
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
