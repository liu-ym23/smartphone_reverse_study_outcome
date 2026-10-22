package com.google.android.material.datepicker;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.obric.oui.calendar.ODatePickerView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class CalendarConstraints implements Parcelable {
    public static final Parcelable.Creator<CalendarConstraints> CREATOR = null;
    private final Month end;
    private final int monthSpan;
    private Month openAt;
    private final Month start;
    private final DateValidator validator;
    private final int yearSpan;

    public interface DateValidator extends Parcelable {
        boolean isValid(long r1);
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final long f13317a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final long f13318b = 0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private long f13319c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private long f13320d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private Long f13321e;
        private DateValidator f;

        static {
            f13317a = i.a(Month.create(ODatePickerView.YEAR_FROM, 0).timeInMillis);
            f13318b = i.a(Month.create(ODatePickerView.YEAR_TO, 11).timeInMillis);
        }

        public a() {
            this.f13319c = f13317a;
            this.f13320d = f13318b;
            this.f = DateValidatorPointForward.from(Long.MIN_VALUE);
        }

        a(CalendarConstraints r3) {
            this.f13319c = f13317a;
            this.f13320d = f13318b;
            this.f = DateValidatorPointForward.from(Long.MIN_VALUE);
            this.f13319c = CalendarConstraints.access$100(r3).timeInMillis;
            this.f13320d = CalendarConstraints.access$200(r3).timeInMillis;
            this.f13321e = Long.valueOf(CalendarConstraints.access$300(r3).timeInMillis);
            this.f = CalendarConstraints.access$400(r3);
        }

        public a a(long r1) {
            this.f13321e = Long.valueOf(r1);
            return this;
        }

        public CalendarConstraints a() {
            Bundle r0 = new Bundle();
            r0.putParcelable("DEEP_COPY_VALIDATOR_KEY", this.f);
            Month r4 = Month.create(this.f13319c);
            Month r5 = Month.create(this.f13320d);
            DateValidator r6 = (DateValidator) ZeusTransformUtils.preCheckCast(r0.getParcelable("DEEP_COPY_VALIDATOR_KEY"), DateValidator.class, "com.obric.aiagent.plugin");
            Long r9 = this.f13321e;
            if (r9 != null) goto L5;
            Month r10 = null;
        L7:
            return new CalendarConstraints(r4, r5, r6, r10, null);
        L5:
            r10 = Month.create(r9.longValue());
            goto L7
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* synthetic */ CalendarConstraints(Month r2, Month r3, DateValidator r4, Month r5, AnonymousClass1 r6) {
        this(r2, r3, (DateValidator) ZeusTransformUtils.wrapperContextForParams(r4, DateValidator.class, "com.obric.aiagent.plugin"), r5);
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

    static /* synthetic */ DateValidator access$400(CalendarConstraints r0) {
        return r0.validator;
    }

    private CalendarConstraints(Month r3, Month r4, DateValidator r5, Month r6) {
        DateValidator r7 = (DateValidator) ZeusTransformUtils.wrapperContextForParams(r5, DateValidator.class, "com.obric.aiagent.plugin");
        this.start = r3;
        this.end = r4;
        this.openAt = r6;
        this.validator = r7;
        if (r6 != null) goto L5;
    L9:
        if (r6 != null) goto L11;
    L15:
        this.monthSpan = r3.monthsUntil(r4) + 1;
        this.yearSpan = (r4.year - r3.year) + 1;
        return;
    L11:
        if (r6.compareTo2(r4) <= 0) goto L15;
        throw new IllegalArgumentException("current Month cannot be after end Month");
    L5:
        if (r3.compareTo2(r6) <= 0) goto L9;
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

    int getMonthSpan() {
        return this.monthSpan;
    }

    int getYearSpan() {
        return this.yearSpan;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, CalendarConstraints.class) == true) goto L8;
        return false;
    L8:
        CalendarConstraints r6 = (CalendarConstraints) ZeusTransformUtils.preCheckCast(r5, CalendarConstraints.class, "com.obric.aiagent.plugin");
        if (this.start.equals(r6.start) == false) goto L18;
        if (this.end.equals(r6.end) == false) goto L18;
        if (androidx.core.util.d.a(this.openAt, r6.openAt) == false) goto L18;
        if (this.validator.equals(r6.validator) == false) goto L18;
        return true;
    L18:
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.start, this.end, this.openAt, this.validator});
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
