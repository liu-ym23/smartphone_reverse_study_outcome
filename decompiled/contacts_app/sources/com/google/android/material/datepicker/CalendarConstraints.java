package com.google.android.material.datepicker;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.util.ObjectsCompat;
import com.obric.oui.calendar.ODatePickerView;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class CalendarConstraints implements Parcelable {
    public static final Parcelable.Creator<CalendarConstraints> CREATOR = null;
    private final Month end;
    private final int firstDayOfWeek;
    private final int monthSpan;
    private Month openAt;
    private final Month start;
    private final DateValidator validator;
    private final int yearSpan;

    public static final class Builder {
        private static final String DEEP_COPY_VALIDATOR_KEY = "DEEP_COPY_VALIDATOR_KEY";
        static final long DEFAULT_END = 0;
        static final long DEFAULT_START = 0;
        private long end;
        private int firstDayOfWeek;
        private Long openAt;
        private long start;
        private DateValidator validator;

        static {
            DEFAULT_START = UtcDates.canonicalYearMonthDay(Month.create(1900, 0).timeInMillis);
            DEFAULT_END = UtcDates.canonicalYearMonthDay(Month.create(ODatePickerView.YEAR_TO, 11).timeInMillis);
        }

        public Builder() {
            this.start = DEFAULT_START;
            this.end = DEFAULT_END;
            this.validator = DateValidatorPointForward.from(Long.MIN_VALUE);
        }

        Builder(CalendarConstraints r3) {
            this.start = DEFAULT_START;
            this.end = DEFAULT_END;
            this.validator = DateValidatorPointForward.from(Long.MIN_VALUE);
            this.start = CalendarConstraints.access$100(r3).timeInMillis;
            this.end = CalendarConstraints.access$200(r3).timeInMillis;
            this.openAt = Long.valueOf(CalendarConstraints.access$300(r3).timeInMillis);
            this.firstDayOfWeek = CalendarConstraints.access$400(r3);
            this.validator = CalendarConstraints.access$500(r3);
        }

        public Builder setStart(long r1) {
            this.start = r1;
            return this;
        }

        public Builder setEnd(long r1) {
            this.end = r1;
            return this;
        }

        public Builder setOpenAt(long r1) {
            this.openAt = Long.valueOf(r1);
            return this;
        }

        public Builder setFirstDayOfWeek(int r1) {
            this.firstDayOfWeek = r1;
            return this;
        }

        public Builder setValidator(DateValidator r2) {
            Objects.requireNonNull(r2, "validator cannot be null");
            this.validator = r2;
            return this;
        }

        public CalendarConstraints build() {
            Bundle r0 = new Bundle();
            r0.putParcelable(DEEP_COPY_VALIDATOR_KEY, this.validator);
            Month r4 = Month.create(this.start);
            Month r5 = Month.create(this.end);
            DateValidator r6 = (DateValidator) r0.getParcelable(DEEP_COPY_VALIDATOR_KEY);
            Long r1 = this.openAt;
            if (r1 != null) goto L5;
            Month r2 = null;
        L7:
            return new CalendarConstraints(r4, r5, r6, r2, this.firstDayOfWeek, null);
        L5:
            r2 = Month.create(r1.longValue());
            goto L7
        }
    }

    public interface DateValidator extends Parcelable {
        boolean isValid(long r1);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* synthetic */ CalendarConstraints(Month r1, Month r2, DateValidator r3, Month r4, int r5, AnonymousClass1 r6) {
        this(r1, r2, r3, r4, r5);
    }

    static /* synthetic */ Month access$100(CalendarConstraints r0) {
        return r0.start;
    }

    static /* synthetic */ Month access$200(CalendarConstraints r0) {
        return r0.end;
    }

    static /* synthetic */ Month access$300(CalendarConstraints r0) {
        return r0.openAt;
    }

    static /* synthetic */ int access$400(CalendarConstraints r0) {
        return r0.firstDayOfWeek;
    }

    static /* synthetic */ DateValidator access$500(CalendarConstraints r0) {
        return r0.validator;
    }

    private CalendarConstraints(Month r2, Month r3, DateValidator r4, Month r5, int r6) {
        Objects.requireNonNull(r2, "start cannot be null");
        Objects.requireNonNull(r3, "end cannot be null");
        Objects.requireNonNull(r4, "validator cannot be null");
        this.start = r2;
        this.end = r3;
        this.openAt = r5;
        this.firstDayOfWeek = r6;
        this.validator = r4;
        if (r5 != null) goto L5;
    L9:
        if (r5 != null) goto L11;
    L15:
        if (r6 < 0) goto L21;
        if (r6 > UtcDates.getUtcCalendar().getMaximum(7)) goto L21;
        this.monthSpan = r2.monthsUntil(r3) + 1;
        this.yearSpan = (r3.year - r2.year) + 1;
        return;
    L21:
        throw new IllegalArgumentException("firstDayOfWeek is not valid");
    L11:
        if (r5.compareTo2(r3) <= 0) goto L15;
        throw new IllegalArgumentException("current Month cannot be after end Month");
    L5:
        if (r2.compareTo2(r5) <= 0) goto L9;
        throw new IllegalArgumentException("start Month cannot be after current Month");
    }

    boolean isWithinBounds(long r5) {
        if (this.start.getDay(1) > r5) goto L7;
        Month r4 = this.end;
        if (r5 > r4.getDay(r4.daysInMonth)) goto L7;
        return true;
    L7:
        return false;
    }

    public DateValidator getDateValidator() {
        return this.validator;
    }

    Month getStart() {
        return this.start;
    }

    Month getEnd() {
        return this.end;
    }

    Month getOpenAt() {
        return this.openAt;
    }

    void setOpenAt(Month r1) {
        this.openAt = r1;
    }

    int getFirstDayOfWeek() {
        return this.firstDayOfWeek;
    }

    int getMonthSpan() {
        return this.monthSpan;
    }

    int getYearSpan() {
        return this.yearSpan;
    }

    public long getStartMs() {
        return this.start.timeInMillis;
    }

    public long getEndMs() {
        return this.end.timeInMillis;
    }

    public Long getOpenAtMs() {
        Month r2 = this.openAt;
        if (r2 != null) goto L6;
        return null;
    L6:
        return Long.valueOf(r2.timeInMillis);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof CalendarConstraints) == true) goto L8;
        return false;
    L8:
        CalendarConstraints r6 = (CalendarConstraints) r5;
        if (this.start.equals(r6.start) == false) goto L20;
        if (this.end.equals(r6.end) == false) goto L20;
        if (ObjectsCompat.equals(this.openAt, r6.openAt) == false) goto L20;
        if (this.firstDayOfWeek != r6.firstDayOfWeek) goto L20;
        if (this.validator.equals(r6.validator) == false) goto L20;
        return true;
    L20:
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.start, this.end, this.openAt, Integer.valueOf(this.firstDayOfWeek), this.validator});
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r2, int r3) {
        r2.writeParcelable(this.start, 0);
        r2.writeParcelable(this.end, 0);
        r2.writeParcelable(this.openAt, 0);
        r2.writeParcelable(this.validator, 0);
        r2.writeInt(this.firstDayOfWeek);
    }

    Month clamp(Month r2) {
        if (r2.compareTo2(this.start) >= 0) goto L7;
        return this.start;
    L7:
        if (r2.compareTo2(this.end) > 0) goto L9;
        return r2;
    L9:
        return this.end;
    }
}
