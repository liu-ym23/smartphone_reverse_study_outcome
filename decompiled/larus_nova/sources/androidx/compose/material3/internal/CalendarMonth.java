package androidx.compose.material3.internal;

import com.byted.mgl.merge.service.api.ui.BdpGameHostBaseUIService;
import com.ss.ttvideoengine.model.SubInfo;
import kotlin.Metadata;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0081\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0016J\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0018J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\bHÆ\u0003J;\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\u0003HÖ\u0001J\t\u0010&\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011¨\u0006'"}, d2 = {"Landroidx/compose/material3/internal/CalendarMonth;", "", BdpGameHostBaseUIService.DATE_PICKER_TYPE_YEAR, "", BdpGameHostBaseUIService.DATE_PICKER_TYPE_MONTH, "numberOfDays", "daysFromStartOfWeekToFirstOfMonth", "startUtcTimeMillis", "", "<init>", "(IIIIJ)V", "getYear", "()I", "getMonth", "getNumberOfDays", "getDaysFromStartOfWeekToFirstOfMonth", "getStartUtcTimeMillis", "()J", "endUtcTimeMillis", "getEndUtcTimeMillis", "indexIn", "years", "Lkotlin/ranges/IntRange;", SubInfo.KEY_FORMAT, "", "calendarModel", "Landroidx/compose/material3/internal/CalendarModel;", "skeleton", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CalendarMonth {
    public static final int $stable = 0;
    private final int daysFromStartOfWeekToFirstOfMonth;
    private final long endUtcTimeMillis;
    private final int month;
    private final int numberOfDays;
    private final long startUtcTimeMillis;
    private final int year;

    public static /* synthetic */ CalendarMonth copy$default(CalendarMonth r100, int r101, int r102, int r103, int r104, long r105, int r110, Object r111) {
        if ((r110 & 1) == 0) goto L6;
        r101 = r100.year;
    L6:
        if ((r110 & 2) == 0) goto L8;
        r102 = r100.month;
    L8:
        int r112 = r102;
        if ((r110 & 4) == 0) goto L11;
        r103 = r100.numberOfDays;
    L11:
        int r106 = r103;
        if ((r110 & 8) == 0) goto L14;
        r104 = r100.daysFromStartOfWeekToFirstOfMonth;
    L14:
        int r107 = r104;
        if ((r110 & 16) == 0) goto L17;
        r105 = r100.startUtcTimeMillis;
    L17:
        int r108 = r101;
        return r100.copy(r108, r112, r106, r107, r105);
    }

    public final int component1() {
        return this.year;
    }

    public final int component2() {
        return this.month;
    }

    public final int component3() {
        return this.numberOfDays;
    }

    public final int component4() {
        return this.daysFromStartOfWeekToFirstOfMonth;
    }

    public final long component5() {
        return this.startUtcTimeMillis;
    }

    public final CalendarMonth copy(int r100, int r110, int r111, int r112, long r113) {
        return new CalendarMonth(r100, r110, r111, r112, r113);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CalendarMonth) == true) goto L8;
        return false;
    L8:
        CalendarMonth r101 = (CalendarMonth) r100;
        if (this.year == r101.year) goto L12;
        return false;
    L12:
        if (this.month == r101.month) goto L15;
        return false;
    L15:
        if (this.numberOfDays == r101.numberOfDays) goto L18;
        return false;
    L18:
        if (this.daysFromStartOfWeekToFirstOfMonth == r101.daysFromStartOfWeekToFirstOfMonth) goto L21;
        return false;
    L21:
        if (this.startUtcTimeMillis == r101.startUtcTimeMillis) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r100 = ((((((this.year * 31) + this.month) * 31) + this.numberOfDays) * 31) + this.daysFromStartOfWeekToFirstOfMonth) * 31;
        long r101 = this.startUtcTimeMillis;
        return r100 + ((int) (r101 ^ (r101 >>> 32)));
    }

    public String toString() {
        return "CalendarMonth(year=" + this.year + ", month=" + this.month + ", numberOfDays=" + this.numberOfDays + ", daysFromStartOfWeekToFirstOfMonth=" + this.daysFromStartOfWeekToFirstOfMonth + ", startUtcTimeMillis=" + this.startUtcTimeMillis + ')';
    }

    public final int getDaysFromStartOfWeekToFirstOfMonth() {
        return this.daysFromStartOfWeekToFirstOfMonth;
    }

    public final long getEndUtcTimeMillis() {
        return this.endUtcTimeMillis;
    }

    public final int getMonth() {
        return this.month;
    }

    public final int getNumberOfDays() {
        return this.numberOfDays;
    }

    public final long getStartUtcTimeMillis() {
        return this.startUtcTimeMillis;
    }

    public final int getYear() {
        return this.year;
    }

    public final int indexIn(IntRange r100) {
        return (((this.year - r100.getFirst()) * 12) + this.month) - 1;
    }

    public final String format(CalendarModel r100, String r101) {
        return r100.formatWithSkeleton(this, r101, r100.getLocale());
    }

    public CalendarMonth(int r100, int r101, int r102, int r103, long r104) {
        this.year = r100;
        this.month = r101;
        this.numberOfDays = r102;
        this.daysFromStartOfWeekToFirstOfMonth = r103;
        this.startUtcTimeMillis = r104;
        this.endUtcTimeMillis = (r104 + (((long) r102) * 86400000)) - 1;
    }
}
