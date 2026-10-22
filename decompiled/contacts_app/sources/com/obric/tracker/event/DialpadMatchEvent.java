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

/* JADX INFO: compiled from: DialpadMatchEvent.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B/\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0002\u0010\u000bJ\t\u0010\u0016\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0019\u001a\u00020\tHÆ\u0003J\t\u0010\u001a\u001a\u00020\tHÆ\u0003J;\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\b\u0010 \u001a\u00020\tH\u0016J\u0014\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u001f0\"H\u0016J\b\u0010#\u001a\u00020\tH\u0016J\b\u0010$\u001a\u00020%H\u0016J\u0014\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u001f0\"H\u0016J\u0014\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00040\"H\u0016J\b\u0010(\u001a\u00020\tH\u0016J\t\u0010)\u001a\u00020\u0006HÖ\u0001J\t\u0010*\u001a\u00020\tHÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\n\u001a\u00020\tX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000f\"\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\r¨\u0006+"}, d2 = {"Lcom/obric/tracker/event/DialpadMatchEvent;", "Lcom/obric/tracker/intf/event/ITeaEvent;", "Lcom/obric/tracker/intf/event/ISlardarEvent;", "matchDurationMs", "", "digitsLength", "", "resultSize", "endReason", "", "eventId", "(JIILjava/lang/String;Ljava/lang/String;)V", "getDigitsLength", "()I", "getEndReason", "()Ljava/lang/String;", "getEventId", "setEventId", "(Ljava/lang/String;)V", "getMatchDurationMs", "()J", "getResultSize", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "getAction", "getCategoryParams", "", "getEventName", "getEventParams", "Lorg/json/JSONObject;", "getExtraParams", "getMetricsParams", "getScene", "hashCode", "toString", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DialpadMatchEvent implements ITeaEvent, ISlardarEvent {
    private final int digitsLength;
    private final String endReason;
    private String eventId;
    private final long matchDurationMs;
    private final int resultSize;

    public static /* synthetic */ DialpadMatchEvent copy$default(DialpadMatchEvent r7, long r8, int r10, int r11, String r12, String r13, int r14, Object r15) {
        if ((r14 & 1) == 0) goto L5;
        r8 = r7.matchDurationMs;
    L5:
        long r1 = r8;
        if ((r14 & 2) == 0) goto L8;
        r10 = r7.digitsLength;
    L8:
        int r3 = r10;
        if ((r14 & 4) == 0) goto L11;
        r11 = r7.resultSize;
    L11:
        int r4 = r11;
        if ((r14 & 8) == 0) goto L14;
        r12 = r7.endReason;
    L14:
        String r5 = r12;
        if ((r14 & 16) == 0) goto L18;
        r13 = r7.eventId;
    L18:
        return r7.copy(r1, r3, r4, r5, r13);
    }

    public final long component1() {
        return this.matchDurationMs;
    }

    public final int component2() {
        return this.digitsLength;
    }

    public final int component3() {
        return this.resultSize;
    }

    public final String component4() {
        return this.endReason;
    }

    public final String component5() {
        return this.eventId;
    }

    public final DialpadMatchEvent copy(long r8, int r10, int r11, String r12, String r13) {
        Intrinsics.checkNotNullParameter(r12, "endReason");
        Intrinsics.checkNotNullParameter(r13, "eventId");
        return new DialpadMatchEvent(r8, r10, r11, r12, r13);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof DialpadMatchEvent) == true) goto L8;
        return false;
    L8:
        DialpadMatchEvent r9 = (DialpadMatchEvent) r8;
        if (this.matchDurationMs == r9.matchDurationMs) goto L12;
        return false;
    L12:
        if (this.digitsLength == r9.digitsLength) goto L15;
        return false;
    L15:
        if (this.resultSize == r9.resultSize) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.endReason, r9.endReason) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.eventId, r9.eventId) == true) goto L23;
        return false;
    L23:
        return true;
    }

    @Override // com.obric.tracker.intf.event.ISlardarEvent
    /* JADX INFO: renamed from: getAction */
    public String mo779getAction() {
        return EventNameConstantsKt.DIALPAD_MATCH_EVENT;
    }

    @Override // com.obric.tracker.intf.event.ITeaEvent
    public String getEventName() {
        return EventNameConstantsKt.DIALPAD_MATCH_EVENT;
    }

    @Override // com.obric.tracker.intf.event.ISlardarEvent
    public String getScene() {
        return "scene";
    }

    public int hashCode() {
        return (((((((Long.hashCode(this.matchDurationMs) * 31) + Integer.hashCode(this.digitsLength)) * 31) + Integer.hashCode(this.resultSize)) * 31) + this.endReason.hashCode()) * 31) + this.eventId.hashCode();
    }

    public String toString() {
        return "DialpadMatchEvent(matchDurationMs=" + this.matchDurationMs + ", digitsLength=" + this.digitsLength + ", resultSize=" + this.resultSize + ", endReason=" + this.endReason + ", eventId=" + this.eventId + ')';
    }

    public DialpadMatchEvent(long r2, int r4, int r5, String r6, String r7) {
        Intrinsics.checkNotNullParameter(r6, "endReason");
        Intrinsics.checkNotNullParameter(r7, "eventId");
        this.matchDurationMs = r2;
        this.digitsLength = r4;
        this.resultSize = r5;
        this.endReason = r6;
        this.eventId = r7;
    }

    public /* synthetic */ DialpadMatchEvent(long r8, int r10, int r11, String r12, String r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 16) == 0) goto L5;
        r13 = "";
    L5:
        this(r8, r10, r11, r12, r13);
    }

    public final long getMatchDurationMs() {
        return this.matchDurationMs;
    }

    public final int getDigitsLength() {
        return this.digitsLength;
    }

    public final int getResultSize() {
        return this.resultSize;
    }

    public final String getEndReason() {
        return this.endReason;
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
        r0.put("match_time", this.matchDurationMs);
        r0.put("digits_length", this.digitsLength);
        r0.put("result_size", this.resultSize);
        r0.put("end_reason", this.endReason);
        return r0;
    }

    @Override // com.obric.tracker.intf.event.ISlardarEvent
    public Map<String, Object> getCategoryParams() {
        return MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("digits_length", Integer.valueOf(this.digitsLength)), TuplesKt.to("result_size", Integer.valueOf(this.resultSize)), TuplesKt.to("end_reason", this.endReason)});
    }

    @Override // com.obric.tracker.intf.event.ISlardarEvent
    public Map<String, Long> getMetricsParams() {
        return MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("match_time", Long.valueOf(this.matchDurationMs))});
    }

    @Override // com.obric.tracker.intf.event.ISlardarEvent
    public Map<String, Object> getExtraParams() {
        return new LinkedHashMap();
    }
}
