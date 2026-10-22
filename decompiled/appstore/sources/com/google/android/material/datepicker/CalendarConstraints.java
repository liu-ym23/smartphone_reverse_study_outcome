package com.google.android.material.datepicker;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.b;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class CalendarConstraints implements Parcelable {
    public static final Parcelable.Creator<CalendarConstraints> CREATOR = null;

    @NonNull
    private final Month end;
    private final int monthSpan;

    @Nullable
    private Month openAt;

    @NonNull
    private final Month start;

    @NonNull
    private final DateValidator validator;
    private final int yearSpan;

    public static final class Builder {
        private static final String DEEP_COPY_VALIDATOR_KEY = "DEEP_COPY_VALIDATOR_KEY";
        static final long DEFAULT_END = 0;
        static final long DEFAULT_START = 0;
        private long end;
        private Long openAt;
        private long start;
        private DateValidator validator;

        static {
            DEFAULT_START = UtcDates.canonicalYearMonthDay(Month.create(1900, 0).timeInMillis);
            DEFAULT_END = UtcDates.canonicalYearMonthDay(Month.create(2100, 11).timeInMillis);
        }

        public Builder() {
            this.start = DEFAULT_START;
            this.end = DEFAULT_END;
            this.validator = DateValidatorPointForward.from(Long.MIN_VALUE);
        }

        @NonNull
        public CalendarConstraints build() {
            Bundle r10 = new Bundle();
            r10.putParcelable(DEEP_COPY_VALIDATOR_KEY, this.validator);
            Month r11 = Month.create(this.start);
            Month r12 = Month.create(this.end);
            DateValidator r13 = (DateValidator) r10.getParcelable(DEEP_COPY_VALIDATOR_KEY);
            Long r14 = this.openAt;
            if (r14 != null) goto L6;
            Month r15 = null;
        L8:
            return new CalendarConstraints(r11, r12, r13, r15, null);
        L6:
            r15 = Month.create(r14.longValue());
            goto L8
        }

        @NonNull
        public Builder setEnd(long r10) {
            this.end = r10;
            return this;
        }

        @NonNull
        public Builder setOpenAt(long r10) {
            this.openAt = Long.valueOf(r10);
            return this;
        }

        @NonNull
        public Builder setStart(long r10) {
            this.start = r10;
            return this;
        }

        @NonNull
        public Builder setValidator(@NonNull DateValidator r10) {
            this.validator = r10;
            return this;
        }

        public Builder(@NonNull CalendarConstraints r10) {
            this.start = DEFAULT_START;
            this.end = DEFAULT_END;
            this.validator = DateValidatorPointForward.from(Long.MIN_VALUE);
            this.start = CalendarConstraints.access$100(r10).timeInMillis;
            this.end = CalendarConstraints.access$200(r10).timeInMillis;
            this.openAt = Long.valueOf(CalendarConstraints.access$300(r10).timeInMillis);
            this.validator = CalendarConstraints.access$400(r10);
        }
    }

    public interface DateValidator extends Parcelable {
        boolean isValid(long r10);
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public /* synthetic */ CalendarConstraints(Month r10, Month r11, DateValidator r12, Month r13, AnonymousClass1 r14) {
        this(r10, r11, r12, r13);
    }

    public static /* synthetic */ Month access$100(CalendarConstraints r10) {
        return r10.start;
    }

    public static /* synthetic */ Month access$200(CalendarConstraints r10) {
        return r10.end;
    }

    public static /* synthetic */ Month access$300(CalendarConstraints r10) {
        return r10.openAt;
    }

    public static /* synthetic */ DateValidator access$400(CalendarConstraints r10) {
        return r10.validator;
    }

    public Month clamp(Month r10) {
        if (r10.compareTo2(this.start) >= 0) goto L7;
        return this.start;
    L7:
        if (r10.compareTo2(this.end) > 0) goto L9;
        return r10;
    L9:
        return this.end;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof CalendarConstraints) == true) goto L8;
        return false;
    L8:
        CalendarConstraints r11 = (CalendarConstraints) r10;
        if (this.start.equals(r11.start) == false) goto L18;
        if (this.end.equals(r11.end) == false) goto L18;
        if (b.a(this.openAt, r11.openAt) == false) goto L18;
        if (this.validator.equals(r11.validator) == false) goto L18;
        return true;
    L18:
        return false;
    }

    public DateValidator getDateValidator() {
        return this.validator;
    }

    @NonNull
    public Month getEnd() {
        return this.end;
    }

    public int getMonthSpan() {
        return this.monthSpan;
    }

    @Nullable
    public Month getOpenAt() {
        return this.openAt;
    }

    @NonNull
    public Month getStart() {
        return this.start;
    }

    public int getYearSpan() {
        return this.yearSpan;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.start, this.end, this.openAt, this.validator});
    }

    public boolean isWithinBounds(long r10) {
        if (this.start.getDay(1) > r10) goto L7;
        Month r11 = this.end;
        if (r10 > r11.getDay(r11.daysInMonth)) goto L7;
        return true;
    L7:
        return false;
    }

    public void setOpenAt(@Nullable Month r10) {
        this.openAt = r10;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r10, int r11) {
        r10.writeParcelable(this.start, 0);
        r10.writeParcelable(this.end, 0);
        r10.writeParcelable(this.openAt, 0);
        r10.writeParcelable(this.validator, 0);
    }

    private CalendarConstraints(@NonNull Month r10, @NonNull Month r11, @NonNull DateValidator r12, @Nullable Month r13) {
        this.start = r10;
        this.end = r11;
        this.openAt = r13;
        this.validator = r12;
        if (r13 != null) goto L5;
    L9:
        if (r13 != null) goto L11;
    L15:
        this.monthSpan = r10.monthsUntil(r11) + 1;
        this.yearSpan = (r11.year - r10.year) + 1;
        return;
    L11:
        if (r13.compareTo2(r11) <= 0) goto L15;
        throw new IllegalArgumentException("current Month cannot be after end Month");
    L5:
        if (r10.compareTo2(r13) <= 0) goto L9;
        throw new IllegalArgumentException("start Month cannot be after current Month");
    }
}
