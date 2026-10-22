package com.stepos.ailauncher.foundation.appui.card.provider.travel;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0013\u001a\u0004\b\u0016\u0010\u0015R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0017\u001a\u0004\b\u0018\u0010\fR\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/travel/u;", "", "Lcom/stepos/ailauncher/foundation/appui/card/provider/travel/r;", "departure", "arrival", "", "durationText", "", "durationMinutes", "<init>", "(Lcom/stepos/ailauncher/foundation/appui/card/provider/travel/r;Lcom/stepos/ailauncher/foundation/appui/card/provider/travel/r;Ljava/lang/String;Ljava/lang/Integer;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/stepos/ailauncher/foundation/appui/card/provider/travel/r;", Const.INTENT_KEY_PKGNAME, "()Lcom/stepos/ailauncher/foundation/appui/card/provider/travel/r;", Const.INTENT_KEY_APIKEY, "Ljava/lang/String;", "c", "Ljava/lang/Integer;", "getDurationMinutes", "()Ljava/lang/Integer;", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.foundation.appui.card.provider.travel.u, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class TransportSchedule {
    private final TransportEndpoint arrival;
    private final TransportEndpoint departure;
    private final Integer durationMinutes;
    private final String durationText;

    public TransportSchedule() {
        this(null, null, null, null, 15, null);
    }

    /* renamed from: a, reason: from getter */
    public final TransportEndpoint getArrival() {
        return this.arrival;
    }

    /* renamed from: b, reason: from getter */
    public final TransportEndpoint getDeparture() {
        return this.departure;
    }

    /* renamed from: c, reason: from getter */
    public final String getDurationText() {
        return this.durationText;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TransportSchedule)) {
            return false;
        }
        TransportSchedule transportSchedule = (TransportSchedule) other;
        return kotlin.jvm.internal.p.d(this.departure, transportSchedule.departure) && kotlin.jvm.internal.p.d(this.arrival, transportSchedule.arrival) && kotlin.jvm.internal.p.d(this.durationText, transportSchedule.durationText) && kotlin.jvm.internal.p.d(this.durationMinutes, transportSchedule.durationMinutes);
    }

    public int hashCode() {
        TransportEndpoint transportEndpoint = this.departure;
        int iHashCode = (transportEndpoint == null ? 0 : transportEndpoint.hashCode()) * 31;
        TransportEndpoint transportEndpoint2 = this.arrival;
        int iHashCode2 = (iHashCode + (transportEndpoint2 == null ? 0 : transportEndpoint2.hashCode())) * 31;
        String str = this.durationText;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        Integer num = this.durationMinutes;
        return iHashCode3 + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        return "TransportSchedule(departure=" + this.departure + ", arrival=" + this.arrival + ", durationText=" + this.durationText + ", durationMinutes=" + this.durationMinutes + ")";
    }

    public TransportSchedule(TransportEndpoint transportEndpoint, TransportEndpoint transportEndpoint2, String str, Integer num) {
        this.departure = transportEndpoint;
        this.arrival = transportEndpoint2;
        this.durationText = str;
        this.durationMinutes = num;
    }

    public /* synthetic */ TransportSchedule(TransportEndpoint transportEndpoint, TransportEndpoint transportEndpoint2, String str, Integer num, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? null : transportEndpoint, (i10 & 2) != 0 ? null : transportEndpoint2, (i10 & 4) != 0 ? null : str, (i10 & 8) != 0 ? null : num);
    }
}
