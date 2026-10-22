package com.stepos.common.picker;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.material.timepicker.TimeModel;
import com.stepos.common.R$id;
import com.stepos.common.R$layout;
import com.stepos.common.R$string;
import com.stepos.common.picker.WheelPicker;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* loaded from: classes3.dex */
public class DatePicker2 extends FrameLayout {
    private static final int MONTH_OF_YEAR = 12;
    public static final int PICKER_DAY = 2;
    public static final int PICKER_MONTH = 1;
    public static final int PICKER_YEAR = 0;
    private static final String TAG = "DatePicker2";
    private static final int YEAR_END_DEFAULT = 2099;
    private static final int YEAR_START_DEFAULT = 1900;
    private int mDay;
    private final WheelPicker mDayPicker;
    private String[] mDayTexts;
    private int mEndYear;
    private d mListener;
    private int mMonth;
    private final WheelPicker mMonthPicker;
    private final String[] mMonthTexts;
    private int mStartYear;
    private int mYear;
    private final WheelPicker mYearPicker;
    private String[] mYearTexts;

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        private final int day;
        private final int month;
        private final int year;

        public class a implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        public /* synthetic */ SavedState(Parcelable parcelable, int i10, int i11, int i12, a aVar) {
            this(parcelable, i10, i11, i12);
        }

        public int getDay() {
            return this.day;
        }

        public int getMonth() {
            return this.month;
        }

        public int getYear() {
            return this.year;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.year);
            parcel.writeInt(this.month);
            parcel.writeInt(this.day);
        }

        private SavedState(Parcelable parcelable, int i10, int i11, int i12) {
            super(parcelable);
            this.year = i10;
            this.month = i11;
            this.day = i12;
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.year = parcel.readInt();
            this.month = parcel.readInt();
            this.day = parcel.readInt();
        }
    }

    public class a implements WheelPicker.e {
        public a() {
        }

        @Override // com.stepos.common.picker.WheelPicker.e
        public void a(int i10, View view, String str) {
            DatePicker2 datePicker2 = DatePicker2.this;
            datePicker2.mYear = datePicker2.n(str, datePicker2.mYear);
            DatePicker2.this.m();
            DatePicker2 datePicker22 = DatePicker2.this;
            datePicker22.j(datePicker22.mYear, DatePicker2.this.mMonth - 1, DatePicker2.this.mDay);
        }
    }

    public class b implements WheelPicker.e {
        public b() {
        }

        @Override // com.stepos.common.picker.WheelPicker.e
        public void a(int i10, View view, String str) {
            DatePicker2 datePicker2 = DatePicker2.this;
            datePicker2.mMonth = datePicker2.n(str, datePicker2.mMonth);
            DatePicker2.this.m();
            DatePicker2 datePicker22 = DatePicker2.this;
            datePicker22.j(datePicker22.mYear, DatePicker2.this.mMonth - 1, DatePicker2.this.mDay);
        }
    }

    public class c implements WheelPicker.e {
        public c() {
        }

        @Override // com.stepos.common.picker.WheelPicker.e
        public void a(int i10, View view, String str) {
            DatePicker2 datePicker2 = DatePicker2.this;
            datePicker2.mDay = datePicker2.n(str, datePicker2.mDay);
            DatePicker2 datePicker22 = DatePicker2.this;
            datePicker22.j(datePicker22.mYear, DatePicker2.this.mMonth - 1, DatePicker2.this.mDay);
        }
    }

    public interface d {
    }

    public DatePicker2(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public Date getDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1, this.mYear);
        calendar.set(2, this.mMonth - 1);
        calendar.set(5, this.mDay);
        return calendar.getTime();
    }

    public int getDay() {
        return this.mDay;
    }

    public WheelPicker getDayPicker() {
        return this.mDayPicker;
    }

    public int getMonth() {
        return this.mMonth;
    }

    public WheelPicker getMonthPicker() {
        return this.mMonthPicker;
    }

    public int getYear() {
        return this.mYear;
    }

    public WheelPicker getYearPicker() {
        return this.mYearPicker;
    }

    public final void j(int i10, int i11, int i12) {
    }

    public final void k(Calendar calendar) {
        int actualMaximum = calendar.getActualMaximum(5);
        this.mDayTexts = new String[actualMaximum];
        String str = String.format(Locale.getDefault(), TimeModel.NUMBER_FORMAT, 0);
        for (int i10 = 1; i10 <= actualMaximum; i10++) {
            this.mDayTexts[i10 - 1] = String.valueOf(i10 < 10 ? str + i10 : Integer.valueOf(i10));
        }
    }

    public final void l(int i10, int i11) {
        if (i10 > i11) {
            return;
        }
        this.mYearTexts = new String[(i11 - i10) + 1];
        for (int i12 = i10; i12 <= i11; i12++) {
            this.mYearTexts[i12 - i10] = String.valueOf(i12);
        }
    }

    public final void m() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1, this.mYear);
        calendar.set(2, this.mMonth - 1);
        k(calendar);
        int actualMaximum = calendar.getActualMaximum(5);
        if (this.mDay > actualMaximum) {
            this.mDay = actualMaximum;
        }
        this.mDayPicker.B(Arrays.asList(this.mDayTexts), this.mDay - 1, true);
    }

    public final int n(String str, int i10) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            Log.w(TAG, "parseInt has an error, text:" + str);
            return i10;
        }
    }

    public void o(int i10, int i11, int i12) {
        u(this.mStartYear, this.mEndYear, i10);
        t(i11);
        s(i10, i11 - 1, i12);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(parcelable);
        this.mYear = savedState.getYear();
        this.mMonth = savedState.getMonth();
        this.mDay = savedState.getDay();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.mYear, this.mMonth, this.mDay, null);
    }

    public final void p() {
        this.mDayPicker.setDrawFlagEnable(true);
        this.mDayPicker.setFlagText(getContext().getString(R$string.mc_date_time_day));
        s(this.mYear, this.mMonth - 1, -1);
        this.mDayPicker.n(new c());
    }

    public final void q() {
        String str = String.format(Locale.getDefault(), TimeModel.NUMBER_FORMAT, 0);
        for (int i10 = 1; i10 <= 12; i10++) {
            this.mMonthTexts[i10 - 1] = String.valueOf(i10 < 10 ? str + i10 : Integer.valueOf(i10));
        }
        this.mMonthPicker.setDrawFlagEnable(true);
        this.mMonthPicker.setFlagText(getContext().getString(R$string.mc_date_time_month));
        t(Calendar.getInstance().get(2) + 1);
        this.mMonthPicker.n(new b());
    }

    public final void r() {
        l(1900, 2099);
        this.mYearPicker.setItemCount(5);
        this.mYearPicker.setDrawFlagEnable(true);
        this.mYearPicker.setFlagText(getContext().getString(R$string.mc_date_time_year));
        u(1900, 2099, Calendar.getInstance().get(1));
        this.mYearPicker.n(new a());
    }

    public final void s(int i10, int i11, int i12) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1, i10);
        calendar.set(2, i11);
        if (i12 == -1) {
            this.mDay = calendar.get(5);
        } else {
            this.mDay = i12;
        }
        k(calendar);
        this.mDayPicker.B(Arrays.asList(this.mDayTexts), this.mDay - 1, true);
    }

    public void setDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        o(calendar.get(1), calendar.get(2) + 1, calendar.get(5));
    }

    public void setOnDateChangedListener(d dVar) {
    }

    public final void t(int i10) {
        this.mMonth = i10;
        this.mMonthPicker.B(Arrays.asList(this.mMonthTexts), i10 - 1, true);
    }

    public final void u(int i10, int i11, int i12) {
        if (i10 == this.mStartYear && i11 == this.mEndYear && i12 == this.mYear) {
            return;
        }
        l(i10, i11);
        this.mStartYear = i10;
        this.mEndYear = i11;
        this.mYear = i12;
        if (i12 < i10 || i12 > i11) {
            this.mYearPicker.B(Arrays.asList(this.mYearTexts), 0, true);
        } else {
            this.mYearPicker.B(Arrays.asList(this.mYearTexts), this.mYear - this.mStartYear, true);
        }
    }

    public DatePicker2(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mMonthTexts = new String[12];
        View.inflate(context, R$layout.stepos_date_picker2_column, this);
        this.mYearPicker = (WheelPicker) findViewById(R$id.year_picker);
        this.mMonthPicker = (WheelPicker) findViewById(R$id.month_picker);
        this.mDayPicker = (WheelPicker) findViewById(R$id.day_picker);
        r();
        q();
        p();
    }
}
