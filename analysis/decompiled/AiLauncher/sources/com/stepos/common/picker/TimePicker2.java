package com.stepos.common.picker;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.format.DateFormat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.material.timepicker.TimeModel;
import com.stepos.common.R$id;
import com.stepos.common.R$layout;
import com.stepos.common.R$string;
import com.stepos.common.picker.WheelPicker;
import java.text.DateFormatSymbols;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* loaded from: classes3.dex */
public class TimePicker2 extends FrameLayout {
    private static final int HOUR_OF_DAY = 24;
    private static final int HOUR_OF_DAY_HALF = 12;
    private static final int MINUTE_OF_HOUR = 60;
    private static final String TAG = "TimePicker2";
    private boolean m24HourFormat;
    private final WheelPicker mAmPmPicker;
    private final String[] mAmPmTexts;
    private String mAmText;
    private int mCurrHour;
    private int mCurrMinute;
    private final WheelPicker mHourPicker;
    private final String[] mHourTexts;
    private final String[] mHourTextsHalf;
    private boolean mIsAm;
    private final WheelPicker mMinPicker;
    private final String[] mMinTexts;
    private String mPmText;

    @Deprecated
    private c mTimeChangedListener;
    private List<b> mTimeChangedListeners;

    public static class SavedStated extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedStated> CREATOR = new a();
        private final int hour;
        private final int minute;

        public class a implements Parcelable.Creator<SavedStated> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedStated createFromParcel(Parcel parcel) {
                return new SavedStated(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedStated[] newArray(int i10) {
                return new SavedStated[i10];
            }
        }

        public /* synthetic */ SavedStated(Parcelable parcelable, int i10, int i11, a aVar) {
            this(parcelable, i10, i11);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.hour);
            parcel.writeInt(this.minute);
        }

        public SavedStated(Parcel parcel) {
            super(parcel);
            this.hour = parcel.readInt();
            this.minute = parcel.readInt();
        }

        private SavedStated(Parcelable parcelable, int i10, int i11) {
            super(parcelable);
            this.hour = i10;
            this.minute = i11;
        }
    }

    public class a implements WheelPicker.e {
        public a() {
        }

        @Override // com.stepos.common.picker.WheelPicker.e
        public void a(int i10, View view, String str) {
            TimePicker2 timePicker2 = TimePicker2.this;
            timePicker2.mIsAm = timePicker2.mAmText.equals(str);
            TimePicker2 timePicker22 = TimePicker2.this;
            timePicker22.h(timePicker22, timePicker22.mCurrHour, TimePicker2.this.mCurrMinute);
        }
    }

    public interface b {
        void a(TimePicker2 timePicker2, boolean z10, int i10, int i11);
    }

    @Deprecated
    public interface c {
    }

    public TimePicker2(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public static /* synthetic */ void a(TimePicker2 timePicker2, int i10, View view, String str) {
        timePicker2.getClass();
        try {
            timePicker2.mCurrHour = Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            Log.w(TAG, "NumberFormat parse hour has an error, text:" + str);
        }
        timePicker2.h(timePicker2, timePicker2.mCurrHour, timePicker2.mCurrMinute);
    }

    public static /* synthetic */ void b(TimePicker2 timePicker2, int i10, View view, String str) {
        timePicker2.getClass();
        try {
            timePicker2.mCurrMinute = Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            Log.w(TAG, "NumberFormat parse minute has an error, text:" + str);
        }
        timePicker2.h(timePicker2, timePicker2.mCurrHour, timePicker2.mCurrMinute);
    }

    public WheelPicker getAmPmPicker() {
        return this.mAmPmPicker;
    }

    public int getHour() {
        if (!this.m24HourFormat && !this.mIsAm) {
            return this.mCurrHour + 12;
        }
        return this.mCurrHour;
    }

    public WheelPicker getHourPicker() {
        return this.mHourPicker;
    }

    public int getMinute() {
        return this.mCurrMinute;
    }

    public WheelPicker getMinutePicker() {
        return this.mMinPicker;
    }

    public final void h(TimePicker2 timePicker2, int i10, int i11) {
        List<b> list = this.mTimeChangedListeners;
        if (list != null) {
            Iterator<b> it = list.iterator();
            while (it.hasNext()) {
                it.next().a(timePicker2, this.mIsAm, i10, i11);
            }
        }
    }

    public final void i() {
        String str = String.format(Locale.getDefault(), TimeModel.NUMBER_FORMAT, 0);
        for (int i10 = 0; i10 < 24; i10++) {
            this.mHourTexts[i10] = String.format(Locale.getDefault(), TimeModel.NUMBER_FORMAT, Integer.valueOf(i10));
            if (i10 <= 9) {
                this.mHourTexts[i10] = str + this.mHourTexts[i10];
            }
        }
        for (int i11 = 1; i11 <= 12; i11++) {
            int i12 = i11 - 1;
            this.mHourTextsHalf[i12] = String.format(Locale.getDefault(), TimeModel.NUMBER_FORMAT, Integer.valueOf(i11));
            if (i11 < 10) {
                this.mHourTextsHalf[i12] = str + this.mHourTextsHalf[i12];
            }
        }
        this.mHourPicker.setDrawFlagEnable(true);
        this.mHourPicker.setFlagText(getContext().getString(R$string.mc_date_time_hour));
        if (this.m24HourFormat) {
            this.mHourPicker.B(Arrays.asList(this.mHourTexts), this.mCurrHour, true);
            this.mAmPmPicker.setVisibility(8);
        } else {
            this.mHourPicker.B(Arrays.asList(this.mHourTextsHalf), this.mCurrHour - 1, true);
            this.mAmPmPicker.B(Arrays.asList(this.mAmPmTexts), 0, false);
        }
        this.mHourPicker.n(new WheelPicker.e() { // from class: com.stepos.common.picker.e
            @Override // com.stepos.common.picker.WheelPicker.e
            public final void a(int i13, View view, String str2) {
                TimePicker2.a(this.f29511a, i13, view, str2);
            }
        });
    }

    public final void j() {
        String str = String.format(Locale.getDefault(), TimeModel.NUMBER_FORMAT, 0);
        for (int i10 = 0; i10 < 60; i10++) {
            this.mMinTexts[i10] = String.format(Locale.getDefault(), TimeModel.NUMBER_FORMAT, Integer.valueOf(i10));
            if (i10 <= 9) {
                this.mMinTexts[i10] = str + this.mMinTexts[i10];
            }
        }
        this.mMinPicker.setDrawFlagEnable(true);
        this.mMinPicker.setFlagText(getContext().getString(R$string.mc_date_time_min));
        this.mMinPicker.B(Arrays.asList(this.mMinTexts), this.mCurrMinute, true);
        this.mMinPicker.n(new WheelPicker.e() { // from class: com.stepos.common.picker.d
            @Override // com.stepos.common.picker.WheelPicker.e
            public final void a(int i11, View view, String str2) {
                TimePicker2.b(this.f29510a, i11, view, str2);
            }
        });
    }

    public final void k() {
        String[] amPmStrings = new DateFormatSymbols().getAmPmStrings();
        this.mAmPmPicker.setItemCount(3);
        String[] strArr = this.mAmPmTexts;
        strArr[3] = "";
        strArr[0] = "";
        String str = amPmStrings[0];
        strArr[1] = str;
        String str2 = amPmStrings[1];
        strArr[2] = str2;
        this.mAmText = str;
        this.mPmText = str2;
        this.mAmPmPicker.n(new a());
    }

    public void l(int i10, int i11, boolean z10) {
        boolean z11;
        boolean z12;
        int i12;
        boolean z13 = this.m24HourFormat != z10;
        if (this.mCurrHour != i10) {
            this.mCurrHour = i10;
            z11 = true;
        } else {
            z11 = false;
        }
        this.mIsAm = true;
        if (!z10 && (i12 = this.mCurrHour) > 12) {
            this.mCurrHour = i12 - 12;
            this.mIsAm = false;
            z11 = true;
        }
        if (this.mCurrMinute != i11) {
            this.mCurrMinute = i11;
            z12 = true;
        } else {
            z12 = false;
        }
        if (z13) {
            WheelPicker wheelPicker = this.mHourPicker;
            List<String> listAsList = Arrays.asList(z10 ? this.mHourTexts : this.mHourTextsHalf);
            int i13 = this.mCurrHour;
            if (!z10) {
                i13--;
            }
            wheelPicker.B(listAsList, i13, true);
        }
        if (z11) {
            WheelPicker wheelPicker2 = this.mHourPicker;
            int i14 = this.mCurrHour;
            if (!z10) {
                i14--;
            }
            wheelPicker2.setCurrentItem(i14);
        }
        if (z12) {
            this.mMinPicker.setCurrentItem(this.mCurrMinute);
        }
        this.m24HourFormat = z10;
        if (z10) {
            this.mAmPmPicker.setVisibility(8);
            return;
        }
        this.mAmPmPicker.B(Arrays.asList(this.mAmPmTexts), 0, false);
        this.mAmPmPicker.setVisibility(0);
        this.mAmPmPicker.setCurrentItem(this.mIsAm ? 1 : 2);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedStated savedStated = (SavedStated) parcelable;
        super.onRestoreInstanceState(savedStated.getSuperState());
        l(savedStated.hour, savedStated.minute, this.m24HourFormat);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        return new SavedStated(super.onSaveInstanceState(), this.mCurrHour, this.mCurrMinute, null);
    }

    public void set24HourFormat(boolean z10) {
        l(this.mCurrHour, this.mCurrMinute, z10);
    }

    @Override // android.view.View
    public void setEnabled(boolean z10) {
        super.setEnabled(z10);
        this.mAmPmPicker.setEnabled(z10);
        this.mHourPicker.setEnabled(z10);
        this.mMinPicker.setEnabled(z10);
    }

    public void setHour(int i10) {
        if (i10 == getHour()) {
            return;
        }
        l(i10, this.mCurrMinute, this.m24HourFormat);
    }

    public void setMinute(int i10) {
        if (i10 == getMinute()) {
            return;
        }
        l(this.mCurrHour, i10, this.m24HourFormat);
    }

    @Deprecated
    public void setOnTimeChangedListener(c cVar) {
    }

    @Override // android.view.View
    public void setVisibility(int i10) {
        super.setVisibility(i10);
        WheelPicker wheelPicker = this.mAmPmPicker;
        if (wheelPicker != null) {
            wheelPicker.setVisibility(i10);
        }
        WheelPicker wheelPicker2 = this.mHourPicker;
        if (wheelPicker2 != null) {
            wheelPicker2.setVisibility(i10);
        }
        WheelPicker wheelPicker3 = this.mMinPicker;
        if (wheelPicker3 != null) {
            wheelPicker3.setVisibility(i10);
        }
    }

    public TimePicker2(Context context, AttributeSet attributeSet, int i10) {
        int i11;
        super(context, attributeSet, i10);
        this.mIsAm = true;
        this.mHourTexts = new String[24];
        this.mHourTextsHalf = new String[12];
        this.mMinTexts = new String[60];
        this.mAmPmTexts = new String[4];
        Calendar calendar = Calendar.getInstance();
        this.mCurrHour = calendar.get(11);
        this.mCurrMinute = calendar.get(12);
        boolean zIs24HourFormat = DateFormat.is24HourFormat(context);
        this.m24HourFormat = zIs24HourFormat;
        if (!zIs24HourFormat && (i11 = this.mCurrHour) >= 12) {
            this.mCurrHour = i11 - 12;
            this.mIsAm = false;
        }
        View.inflate(getContext(), R$layout.stepos_time_picker2_column, this);
        this.mAmPmPicker = (WheelPicker) findViewById(R$id.am_pm_picker);
        this.mHourPicker = (WheelPicker) findViewById(R$id.hour_picker);
        this.mMinPicker = (WheelPicker) findViewById(R$id.minute_picker);
        k();
        i();
        j();
    }
}
