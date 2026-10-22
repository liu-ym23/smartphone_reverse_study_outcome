package com.google.android.material.timepicker;

import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.IntRange;
import com.bytedance.apm.constant.SlardarConfigConsts;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
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

    static {
        CREATOR = new AnonymousClass1();
    }

    public TimeModel() {
        this(0);
    }

    public static String formatText(Resources r10, CharSequence r11) {
        return formatText(r10, r11, ZERO_LEADING_NUMBER_FORMAT);
    }

    private static int getPeriod(int r10) {
        if (r10 < 12) goto L5;
        return 1;
    L5:
        return 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof TimeModel) == true) goto L8;
        return false;
    L8:
        TimeModel r11 = (TimeModel) r10;
        if (this.hour != r11.hour) goto L18;
        if (this.minute != r11.minute) goto L18;
        if (this.format != r11.format) goto L18;
        if (this.selection != r11.selection) goto L18;
        return true;
    L18:
        return false;
    }

    public int getHourForDisplay() {
        if (this.format == 1) goto L5;
        int r10 = this.hour;
        if ((r10 % 12) != 0) goto L10;
        return 12;
    L10:
        if (this.period == 1) goto L12;
        return r10;
    L12:
        return r10 - 12;
    L5:
        return this.hour % 24;
    }

    public MaxInputValidator getHourInputValidator() {
        return this.hourInputValidator;
    }

    public MaxInputValidator getMinuteInputValidator() {
        return this.minuteInputValidator;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.format), Integer.valueOf(this.hour), Integer.valueOf(this.minute), Integer.valueOf(this.selection)});
    }

    public void setHour(int r10) {
        if (this.format != 1) goto L6;
        this.hour = r10;
        return;
    L6:
        int r11 = 12;
        int r12 = r10 % 12;
        if (this.period == 1) goto L10;
        r11 = 0;
    L10:
        this.hour = r12 + r11;
    }

    public void setHourOfDay(int r10) {
        this.period = getPeriod(r10);
        this.hour = r10;
    }

    public void setMinute(@IntRange(from = 0, to = SlardarConfigConsts.CPU_COLLECT_INTERVAL) int r10) {
        this.minute = r10 % 60;
    }

    public void setPeriod(int r10) {
        if (r10 == this.period) goto L13;
        this.period = r10;
        int r11 = this.hour;
        if (r11 < 12) goto L7;
    L9:
        if (r11 < 12) goto L15;
        if (r10 != 0) goto L16;
        this.hour = r11 - 12;
        return;
    L16:
        return;
    L15:
        return;
    L7:
        if (r10 != 1) goto L9;
        this.hour = r11 + 12;
        return;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r10, int r11) {
        r10.writeInt(this.hour);
        r10.writeInt(this.minute);
        r10.writeInt(this.selection);
        r10.writeInt(this.format);
    }

    public TimeModel(int r10) {
        this(0, 0, 10, r10);
    }

    public static String formatText(Resources r10, CharSequence r11, String r12) {
        return String.format(r10.getConfiguration().locale, r12, new Object[]{Integer.valueOf(Integer.parseInt(String.valueOf(r11)))});
    }

    public TimeModel(int r10, int r11, int r12, int r13) {
        this.hour = r10;
        this.minute = r11;
        this.selection = r12;
        this.format = r13;
        this.period = getPeriod(r10);
        this.minuteInputValidator = new MaxInputValidator(59);
        if (r13 != 1) goto L5;
        int r14 = 24;
    L6:
        this.hourInputValidator = new MaxInputValidator(r14);
        return;
    L5:
        r14 = 12;
        goto L6
    }

    public TimeModel(Parcel r10) {
        this(r10.readInt(), r10.readInt(), r10.readInt(), r10.readInt());
    }
}
