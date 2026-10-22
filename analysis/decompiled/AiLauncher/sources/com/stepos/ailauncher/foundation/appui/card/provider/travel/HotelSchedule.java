package com.stepos.ailauncher.foundation.appui.card.provider.travel;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\nR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0011\u001a\u0004\b\u0013\u0010\nR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/travel/j;", "", "", "checkIn", "checkOut", "", "nights", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, "Ljava/lang/Integer;", "c", "()Ljava/lang/Integer;", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.foundation.appui.card.provider.travel.j, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class HotelSchedule {
    private final String checkIn;
    private final String checkOut;
    private final Integer nights;

    public HotelSchedule() {
        this(null, null, null, 7, null);
    }

    /* renamed from: a, reason: from getter */
    public final String getCheckIn() {
        return this.checkIn;
    }

    /* renamed from: b, reason: from getter */
    public final String getCheckOut() {
        return this.checkOut;
    }

    /* renamed from: c, reason: from getter */
    public final Integer getNights() {
        return this.nights;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HotelSchedule)) {
            return false;
        }
        HotelSchedule hotelSchedule = (HotelSchedule) other;
        return kotlin.jvm.internal.p.d(this.checkIn, hotelSchedule.checkIn) && kotlin.jvm.internal.p.d(this.checkOut, hotelSchedule.checkOut) && kotlin.jvm.internal.p.d(this.nights, hotelSchedule.nights);
    }

    public int hashCode() {
        String str = this.checkIn;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.checkOut;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.nights;
        return iHashCode2 + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        return "HotelSchedule(checkIn=" + this.checkIn + ", checkOut=" + this.checkOut + ", nights=" + this.nights + ")";
    }

    public HotelSchedule(String str, String str2, Integer num) {
        this.checkIn = str;
        this.checkOut = str2;
        this.nights = num;
    }

    public /* synthetic */ HotelSchedule(String str, String str2, Integer num, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : num);
    }
}
