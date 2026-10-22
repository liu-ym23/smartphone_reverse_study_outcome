package androidx.compose.material3.internal;

import com.byted.mgl.merge.service.api.ui.BdpGameHostBaseUIService;
import com.ss.ttvideoengine.model.SubInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0081\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0011\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0000H\u0096\u0002J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0013J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J1\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u0011\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\t\u0010 \u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006!"}, d2 = {"Landroidx/compose/material3/internal/CalendarDate;", "", BdpGameHostBaseUIService.DATE_PICKER_TYPE_YEAR, "", BdpGameHostBaseUIService.DATE_PICKER_TYPE_MONTH, "dayOfMonth", "utcTimeMillis", "", "<init>", "(IIIJ)V", "getYear", "()I", "getMonth", "getDayOfMonth", "getUtcTimeMillis", "()J", "compareTo", "other", SubInfo.KEY_FORMAT, "", "calendarModel", "Landroidx/compose/material3/internal/CalendarModel;", "skeleton", "component1", "component2", "component3", "component4", "copy", "equals", "", "", "hashCode", "toString", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CalendarDate implements Comparable<CalendarDate> {
    public static final int $stable = 0;
    private final int dayOfMonth;
    private final int month;
    private final long utcTimeMillis;
    private final int year;

    public static /* synthetic */ CalendarDate copy$default(CalendarDate r100, int r101, int r102, int r103, long r104, int r105, Object r110) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.year;
    L6:
        if ((r105 & 2) == 0) goto L8;
        r102 = r100.month;
    L8:
        int r111 = r102;
        if ((r105 & 4) == 0) goto L11;
        r103 = r100.dayOfMonth;
    L11:
        int r106 = r103;
        if ((r105 & 8) == 0) goto L14;
        r104 = r100.utcTimeMillis;
    L14:
        int r107 = r101;
        return r100.copy(r107, r111, r106, r104);
    }

    public final int component1() {
        return this.year;
    }

    public final int component2() {
        return this.month;
    }

    public final int component3() {
        return this.dayOfMonth;
    }

    public final long component4() {
        return this.utcTimeMillis;
    }

    public final CalendarDate copy(int r100, int r101, int r110, long r111) {
        return new CalendarDate(r100, r101, r110, r111);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CalendarDate) == true) goto L8;
        return false;
    L8:
        CalendarDate r101 = (CalendarDate) r100;
        if (this.year == r101.year) goto L12;
        return false;
    L12:
        if (this.month == r101.month) goto L15;
        return false;
    L15:
        if (this.dayOfMonth == r101.dayOfMonth) goto L18;
        return false;
    L18:
        if (this.utcTimeMillis == r101.utcTimeMillis) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r100 = ((((this.year * 31) + this.month) * 31) + this.dayOfMonth) * 31;
        long r101 = this.utcTimeMillis;
        return r100 + ((int) (r101 ^ (r101 >>> 32)));
    }

    public String toString() {
        return "CalendarDate(year=" + this.year + ", month=" + this.month + ", dayOfMonth=" + this.dayOfMonth + ", utcTimeMillis=" + this.utcTimeMillis + ')';
    }

    public final int getDayOfMonth() {
        return this.dayOfMonth;
    }

    public final int getMonth() {
        return this.month;
    }

    public final long getUtcTimeMillis() {
        return this.utcTimeMillis;
    }

    public final int getYear() {
        return this.year;
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(CalendarDate r100) {
        return Intrinsics.compare(this.utcTimeMillis, r100.utcTimeMillis);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(CalendarDate r100) {
        return compareTo2(r100);
    }

    public final String format(CalendarModel r100, String r101) {
        return r100.formatWithSkeleton(this, r101, r100.getLocale());
    }

    public CalendarDate(int r100, int r101, int r102, long r103) {
        this.year = r100;
        this.month = r101;
        this.dayOfMonth = r102;
        this.utcTimeMillis = r103;
    }
}
