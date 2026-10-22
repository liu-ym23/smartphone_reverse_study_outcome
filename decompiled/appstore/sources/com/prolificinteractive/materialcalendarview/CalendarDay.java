package com.prolificinteractive.materialcalendarview;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.keva.KevaImpl;
import org.threeten.bp.LocalDate;

/* JADX INFO: loaded from: classes4.dex */
public final class CalendarDay implements Parcelable {
    public static final Parcelable.Creator<CalendarDay> CREATOR = null;

    @NonNull
    private final LocalDate date;

    public static class a implements Parcelable.Creator {
        public a() {
        }

        public CalendarDay a(Parcel r10) {
            return new CalendarDay(r10);
        }

        public CalendarDay[] b(int r10) {
            return new CalendarDay[r10];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ Object createFromParcel(Parcel r10) {
            return a(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ Object[] newArray(int r10) {
            return b(r10);
        }
    }

    static {
        CREATOR = new a();
    }

    private CalendarDay(int r10, int r11, int r12) {
        this.date = LocalDate.of(r10, r11, r12);
    }

    @NonNull
    public static CalendarDay from(int r10, int r11, int r12) {
        return new CalendarDay(r10, r11, r12);
    }

    private static int hashCode(int r10, int r11, int r12) {
        return ((r10 * KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD) + (r11 * 100)) + r12;
    }

    @NonNull
    public static CalendarDay today() {
        return from(LocalDate.now());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r10) {
        if ((r10 instanceof CalendarDay) == true) goto L5;
    L7:
        return false;
    L5:
        if (this.date.equals(((CalendarDay) r10).getDate()) == false) goto L7;
        return true;
    }

    @NonNull
    public LocalDate getDate() {
        return this.date;
    }

    public int getDay() {
        return this.date.getDayOfMonth();
    }

    public int getMonth() {
        return this.date.getMonthValue();
    }

    public int getYear() {
        return this.date.getYear();
    }

    public boolean isAfter(@NonNull CalendarDay r10) {
        return this.date.isAfter(r10.getDate());
    }

    public boolean isBefore(@NonNull CalendarDay r10) {
        return this.date.isBefore(r10.getDate());
    }

    public boolean isInRange(@Nullable CalendarDay r10, @Nullable CalendarDay r11) {
        if (r10 != null) goto L4;
    L5:
        if (r11 != null) goto L7;
    L10:
        return true;
    L7:
        if (r11.isBefore(this) == false) goto L10;
    L9:
        return false;
    L4:
        if (r10.isAfter(this) == true) goto L9;
        goto L5
    }

    public String toString() {
        return "CalendarDay{" + this.date.getYear() + "-" + this.date.getMonthValue() + "-" + this.date.getDayOfMonth() + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r10, int r11) {
        r10.writeInt(this.date.getYear());
        r10.writeInt(this.date.getMonthValue());
        r10.writeInt(this.date.getDayOfMonth());
    }

    public static CalendarDay from(@Nullable LocalDate r10) {
        if (r10 != null) goto L6;
        return null;
    L6:
        return new CalendarDay(r10);
    }

    public int hashCode() {
        return hashCode(this.date.getYear(), this.date.getMonthValue(), this.date.getDayOfMonth());
    }

    private CalendarDay(@NonNull LocalDate r10) {
        this.date = r10;
    }

    public CalendarDay(Parcel r10) {
        this(r10.readInt(), r10.readInt(), r10.readInt());
    }
}
