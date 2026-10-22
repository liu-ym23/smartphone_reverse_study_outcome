package com.obric.tracker.event;

import com.obric.tracker.intf.event.ITeaEvent;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: compiled from: CallLogDonationEvent.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u001c"}, d2 = {"Lcom/obric/tracker/event/CallLogDonationEvent;", "Lcom/obric/tracker/intf/event/ITeaEvent;", "originalEntitySize", "", "finalEntitySize", "expiredSize", "truncatedSize", "(IIII)V", "getExpiredSize", "()I", "getFinalEntitySize", "getOriginalEntitySize", "getTruncatedSize", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "getEventName", "", "getEventParams", "Lorg/json/JSONObject;", "hashCode", "toString", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CallLogDonationEvent implements ITeaEvent {
    private final int expiredSize;
    private final int finalEntitySize;
    private final int originalEntitySize;
    private final int truncatedSize;

    public static /* synthetic */ CallLogDonationEvent copy$default(CallLogDonationEvent r0, int r1, int r2, int r3, int r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.originalEntitySize;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.finalEntitySize;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.expiredSize;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.truncatedSize;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final int component1() {
        return this.originalEntitySize;
    }

    public final int component2() {
        return this.finalEntitySize;
    }

    public final int component3() {
        return this.expiredSize;
    }

    public final int component4() {
        return this.truncatedSize;
    }

    public final CallLogDonationEvent copy(int r1, int r2, int r3, int r4) {
        return new CallLogDonationEvent(r1, r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof CallLogDonationEvent) == true) goto L8;
        return false;
    L8:
        CallLogDonationEvent r6 = (CallLogDonationEvent) r5;
        if (this.originalEntitySize == r6.originalEntitySize) goto L12;
        return false;
    L12:
        if (this.finalEntitySize == r6.finalEntitySize) goto L15;
        return false;
    L15:
        if (this.expiredSize == r6.expiredSize) goto L18;
        return false;
    L18:
        if (this.truncatedSize == r6.truncatedSize) goto L20;
        return false;
    L20:
        return true;
    }

    @Override // com.obric.tracker.intf.event.ITeaEvent
    public String getEventName() {
        return EventNameConstantsKt.CONTACTS_DONATION_CALLLOG_EVENT;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.originalEntitySize) * 31) + Integer.hashCode(this.finalEntitySize)) * 31) + Integer.hashCode(this.expiredSize)) * 31) + Integer.hashCode(this.truncatedSize);
    }

    public String toString() {
        return "CallLogDonationEvent(originalEntitySize=" + this.originalEntitySize + ", finalEntitySize=" + this.finalEntitySize + ", expiredSize=" + this.expiredSize + ", truncatedSize=" + this.truncatedSize + ')';
    }

    public CallLogDonationEvent(int r1, int r2, int r3, int r4) {
        this.originalEntitySize = r1;
        this.finalEntitySize = r2;
        this.expiredSize = r3;
        this.truncatedSize = r4;
    }

    public final int getOriginalEntitySize() {
        return this.originalEntitySize;
    }

    public final int getFinalEntitySize() {
        return this.finalEntitySize;
    }

    public final int getExpiredSize() {
        return this.expiredSize;
    }

    public final int getTruncatedSize() {
        return this.truncatedSize;
    }

    @Override // com.obric.tracker.intf.event.ITeaEvent
    public JSONObject getEventParams() {
        JSONObject r0 = new JSONObject();
        r0.put("orinal_entity_size", this.originalEntitySize);
        r0.put("final_entity_size", this.finalEntitySize);
        r0.put("expired_size", this.expiredSize);
        r0.put("truncated_size", this.truncatedSize);
        return r0;
    }
}
