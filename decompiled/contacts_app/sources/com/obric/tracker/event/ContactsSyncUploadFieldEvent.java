package com.obric.tracker.event;

import android.content.ContentValues;
import com.android.contacts.common.SimContactsConstants;
import com.android.contacts.obricsync.SyncContractKt;
import com.bytedance.retrofit2.HttpMethodContrants;
import com.bytedance.tracing.internal.TracingConstants;
import com.obric.contactsdk.loader.CallFeatureEntityUtilKt;
import com.obric.tracker.intf.event.ISlardarEvent;
import com.obric.tracker.intf.event.ITeaEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.json.JSONObject;

/* JADX INFO: compiled from: ContactsSyncUploadFieldEvent.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\b\u0018\u0000 *2\u00020\u00012\u00020\u0002:\u0002)*B'\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006¢\u0006\u0002\u0010\nJ\t\u0010\u0014\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\bHÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J1\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\b\u0010\u000b\u001a\u00020\u0006H\u0016J\u0014\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001c0\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u0006H\u0016J\b\u0010 \u001a\u00020!H\u0016J\u0014\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001c0\u001eH\u0016J\u0014\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020$0\u001eH\u0016J\b\u0010%\u001a\u00020\u0006H\u0016J\t\u0010&\u001a\u00020'HÖ\u0001J\t\u0010(\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\t\u001a\u00020\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010¨\u0006+"}, d2 = {"Lcom/obric/tracker/event/ContactsSyncUploadFieldEvent;", "Lcom/obric/tracker/intf/event/ITeaEvent;", "Lcom/obric/tracker/intf/event/ISlardarEvent;", CallFeatureEntityUtilKt.PARAM_KEY_ACTION, "Lcom/obric/tracker/event/ContactsSyncUploadFieldEvent$Action;", "syncId", "", "data", "Landroid/content/ContentValues;", "eventId", "(Lcom/obric/tracker/event/ContactsSyncUploadFieldEvent$Action;Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;)V", "getAction", "()Lcom/obric/tracker/event/ContactsSyncUploadFieldEvent$Action;", "getData", "()Landroid/content/ContentValues;", "getEventId", "()Ljava/lang/String;", "setEventId", "(Ljava/lang/String;)V", "getSyncId", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "getCategoryParams", "", "getEventName", "getEventParams", "Lorg/json/JSONObject;", "getExtraParams", "getMetricsParams", "", "getScene", "hashCode", "", "toString", "Action", "Companion", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ContactsSyncUploadFieldEvent implements ITeaEvent, ISlardarEvent {
    public static final Companion Companion = null;
    private final Action action;
    private final ContentValues data;
    private String eventId;
    private final String syncId;

    /* JADX INFO: compiled from: ContactsSyncUploadFieldEvent.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/tracker/event/ContactsSyncUploadFieldEvent$Action;", "", "(Ljava/lang/String;I)V", "INSERT", "UPDATE", HttpMethodContrants.DELETE, "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final enum Action extends Enum<Action> {
        private static final /* synthetic */ Action[] $VALUES = null;
        public static final Action DELETE = null;
        public static final Action INSERT = null;
        public static final Action UPDATE = null;

        private static final /* synthetic */ Action[] $values() {
            return new Action[]{INSERT, UPDATE, DELETE};
        }

        public static Action valueOf(String r1) {
            return (Action) Enum.valueOf(Action.class, r1);
        }

        public static Action[] values() {
            return (Action[]) $VALUES.clone();
        }

        static {
            INSERT = new Action("INSERT", 0);
            UPDATE = new Action("UPDATE", 1);
            DELETE = new Action(HttpMethodContrants.DELETE, 2);
            $VALUES = $values();
        }

        private Action(String r1, int r2) {
            super(r1, r2);
        }
    }

    /* JADX INFO: compiled from: ContactsSyncUploadFieldEvent.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\"\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J<\u0010\u0003\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00050\u00042\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bJ\u0019\u0010\f\u001a\u0004\u0018\u00010\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/obric/tracker/event/ContactsSyncUploadFieldEvent$Companion;", "", "()V", "computeSnapshot", "", "Lkotlin/Pair;", "", "", "values", "", "businessColumns", "", "lengthOf", "value", "(Ljava/lang/Object;)Ljava/lang/Integer;", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        private final Integer lengthOf(Object r4) {
            if (r4 == null) goto L35;
            boolean r1 = true;
            if ((r4 instanceof String) == false) goto L14;
            Integer r5 = Integer.valueOf(((String) r4).length());
            if (r5.intValue() > 0) goto L11;
            r1 = false;
        L11:
            if (r1 == true) goto L31;
            return null;
        L31:
            return r5;
        L14:
            if ((r4 instanceof byte[]) == false) goto L22;
            r5 = Integer.valueOf(((byte[]) r4).length);
            if (r5.intValue() > 0) goto L19;
            r1 = false;
        L19:
            if (r1 == true) goto L31;
            return null;
        L22:
            if ((r4 instanceof Number) == true) goto L33;
            r5 = Integer.valueOf(r4.toString().length());
            if (r5.intValue() > 0) goto L28;
            r1 = false;
        L28:
            if (r1 == true) goto L31;
            return null;
        L33:
            return Integer.valueOf(((Number) r4).toString().length());
        L35:
            return null;
        }

        public final List<Pair<String, Integer>> computeSnapshot(Map<String, ? extends Object> r3, Set<String> r4) {
            Intrinsics.checkNotNullParameter(r3, "values");
            Intrinsics.checkNotNullParameter(r4, "businessColumns");
            LinkedHashMap r2 = new LinkedHashMap();
            Iterator<Map.Entry<String, ? extends Object>> r5 = r3.entrySet().iterator();
        L4:
            if (r5.hasNext() == false) goto L8;
            Map.Entry<String, ? extends Object> r0 = r5.next();
            if (r4.contains(r0.getKey()) == false) goto L4;
            r2.put(r0.getKey(), r0.getValue());
            goto L4
        L8:
            ArrayList r6 = new ArrayList();
            Iterator r7 = r2.entrySet().iterator();
        L10:
            if (r7.hasNext() == false) goto L18;
            Map.Entry r8 = (Map.Entry) r7.next();
            String r1 = (String) r8.getKey();
            Object r9 = r8.getValue();
            Integer r10 = ContactsSyncUploadFieldEvent.Companion.lengthOf(r9);
            if (r10 == null) goto L14;
            Pair r11 = TuplesKt.to(r1, Integer.valueOf(r10.intValue()));
        L15:
            if (r11 == null) goto L10;
            r6.add(r11);
            goto L10
        L14:
            r11 = null;
            goto L15
        L18:
            return r6;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public static /* synthetic */ ContactsSyncUploadFieldEvent copy$default(ContactsSyncUploadFieldEvent r0, Action r1, String r2, ContentValues r3, String r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.action;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.syncId;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.data;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.eventId;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final Action component1() {
        return this.action;
    }

    public final String component2() {
        return this.syncId;
    }

    public final ContentValues component3() {
        return this.data;
    }

    public final String component4() {
        return this.eventId;
    }

    public final ContactsSyncUploadFieldEvent copy(Action r1, String r2, ContentValues r3, String r4) {
        Intrinsics.checkNotNullParameter(r1, CallFeatureEntityUtilKt.PARAM_KEY_ACTION);
        Intrinsics.checkNotNullParameter(r2, "syncId");
        Intrinsics.checkNotNullParameter(r3, "data");
        Intrinsics.checkNotNullParameter(r4, "eventId");
        return new ContactsSyncUploadFieldEvent(r1, r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ContactsSyncUploadFieldEvent) == true) goto L8;
        return false;
    L8:
        ContactsSyncUploadFieldEvent r6 = (ContactsSyncUploadFieldEvent) r5;
        if (this.action == r6.action) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.syncId, r6.syncId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.data, r6.data) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.eventId, r6.eventId) == true) goto L20;
        return false;
    L20:
        return true;
    }

    @Override // com.obric.tracker.intf.event.ISlardarEvent
    /* JADX INFO: renamed from: getAction, reason: collision with other method in class */
    public String mo779getAction() {
        return EventNameConstantsKt.CONTACTS_SYNC_UPLOAD_FIELD_EVENT;
    }

    @Override // com.obric.tracker.intf.event.ITeaEvent
    public String getEventName() {
        return EventNameConstantsKt.CONTACTS_SYNC_UPLOAD_FIELD_EVENT;
    }

    @Override // com.obric.tracker.intf.event.ISlardarEvent
    public String getScene() {
        return "scene";
    }

    public int hashCode() {
        return (((((this.action.hashCode() * 31) + this.syncId.hashCode()) * 31) + this.data.hashCode()) * 31) + this.eventId.hashCode();
    }

    public String toString() {
        return "ContactsSyncUploadFieldEvent(action=" + this.action + ", syncId=" + this.syncId + ", data=" + this.data + ", eventId=" + this.eventId + ')';
    }

    public ContactsSyncUploadFieldEvent(Action r2, String r3, ContentValues r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, CallFeatureEntityUtilKt.PARAM_KEY_ACTION);
        Intrinsics.checkNotNullParameter(r3, "syncId");
        Intrinsics.checkNotNullParameter(r4, "data");
        Intrinsics.checkNotNullParameter(r5, "eventId");
        this.action = r2;
        this.syncId = r3;
        this.data = r4;
        this.eventId = r5;
    }

    public /* synthetic */ ContactsSyncUploadFieldEvent(Action r1, String r2, ContentValues r3, String r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 8) == 0) goto L5;
        r4 = "";
    L5:
        this(r1, r2, r3, r4);
    }

    public final Action getAction() {
        return this.action;
    }

    public final String getSyncId() {
        return this.syncId;
    }

    public final ContentValues getData() {
        return this.data;
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
        Set<String> r0 = this.data.keySet();
        Intrinsics.checkNotNullExpressionValue(r0, "data.keySet()");
        Set<String> r1 = r0;
        LinkedHashMap r2 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r1, 10)), 16));
        Iterator<T> r3 = r1.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        Object r4 = r3.next();
        ContentValues r5 = this.data;
        r2.put(r4, r5.get((String) r4));
        goto L4
    L6:
        Companion r6 = Companion;
        List<Pair<String, Integer>> r7 = r6.computeSnapshot(r2, SyncContractKt.getSYNC_BUSINESS_COLUMNS());
        JSONObject r8 = new JSONObject();
        r8.put("sync_id", this.syncId);
        r8.put(CallFeatureEntityUtilKt.PARAM_KEY_ACTION, this.action.name());
        r8.put(TracingConstants.KEY_FIELDS, CollectionsKt.joinToString$default(r7, SimContactsConstants.EMAIL_SEP, null, null, 0, null, ContactsSyncUploadFieldEvent$getEventParams$1$1.INSTANCE, 30, null));
        return r8;
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
