package com.google.android.material.timepicker;

import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.material.R;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
class TimeModel implements Parcelable {
    public static final Parcelable.Creator<TimeModel> CREATOR = null;
    public static final String NUMBER_FORMAT = "%d";
    public static final String ZERO_LEADING_NUMBER_FORMAT = "%02d";
    final int format;
    int hour;
    private final MaxInputValidator hourInputValidator;
    int minute;
    private final MaxInputValidator minuteInputValidator;
    int period;
    int selection;

    private static int getPeriod(int r1) {
        if (r1 < 12) goto L5;
        return 1;
    L5:
        return 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public TimeModel() {
        this(0);
    }

    public TimeModel(int r3) {
        this(0, 0, 10, r3);
    }

    public TimeModel(int r1, int r2, int r3, int r4) {
        this.hour = r1;
        this.minute = r2;
        this.selection = r3;
        this.format = r4;
        this.period = getPeriod(r1);
        this.minuteInputValidator = new MaxInputValidator(59);
        if (r4 != 1) goto L5;
        int r5 = 23;
    L6:
        this.hourInputValidator = new MaxInputValidator(r5);
        return;
    L5:
        r5 = 12;
        goto L6
    }

    protected TimeModel(Parcel r4) {
        this(r4.readInt(), r4.readInt(), r4.readInt(), r4.readInt());
    }

    public void setHourOfDay(int r2) {
        this.period = getPeriod(r2);
        this.hour = r2;
    }

    public void setHour(int r4) {
        if (this.format != 1) goto L6;
        this.hour = r4;
        return;
    L6:
        int r0 = 12;
        int r5 = r4 % 12;
        if (this.period == 1) goto L10;
        r0 = 0;
    L10:
        this.hour = r5 + r0;
    }

    public void setMinute(int r1) {
        this.minute = r1 % 60;
    }

    public int getHourForDisplay() {
        if (this.format == 1) goto L5;
        int r0 = this.hour;
        if ((r0 % 12) != 0) goto L10;
        return 12;
    L10:
        if (this.period == 1) goto L12;
        return r0;
    L12:
        return r0 - 12;
    L5:
        return this.hour % 24;
    }

    public int getHourContentDescriptionResId() {
        if (this.format != 1) goto L6;
        return R.string.material_hour_24h_suffix;
    L6:
        return R.string.material_hour_suffix;
    }

    public MaxInputValidator getMinuteInputValidator() {
        return this.minuteInputValidator;
    }

    public MaxInputValidator getHourInputValidator() {
        return this.hourInputValidator;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.format), Integer.valueOf(this.hour), Integer.valueOf(this.minute), Integer.valueOf(this.selection)});
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof TimeModel) == true) goto L8;
        return false;
    L8:
        TimeModel r6 = (TimeModel) r5;
        if (this.hour != r6.hour) goto L18;
        if (this.minute != r6.minute) goto L18;
        if (this.format != r6.format) goto L18;
        if (this.selection != r6.selection) goto L18;
        return true;
    L18:
        return false;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeInt(this.hour);
        r1.writeInt(this.minute);
        r1.writeInt(this.selection);
        r1.writeInt(this.format);
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public void setPeriod(int r4) {
        if (r4 == this.period) goto L13;
        this.period = r4;
        int r0 = this.hour;
        if (r0 < 12) goto L7;
    L9:
        if (r0 < 12) goto L15;
        if (r4 != 0) goto L16;
        this.hour = r0 - 12;
        return;
    L16:
        return;
    L15:
        return;
    L7:
        if (r4 != 1) goto L9;
        this.hour = r0 + 12;
        return;
    }

    public static String formatText(Resources r1, CharSequence r2) {
        return formatText(r1, r2, ZERO_LEADING_NUMBER_FORMAT);
    }

    public static String formatText(Resources r2, CharSequence r3, String r4) {
        return String.format(r2.getConfiguration().locale, r4, new Object[]{Integer.valueOf(Integer.parseInt(String.valueOf(r3)))});
    L4:
        return null;
    }
}
