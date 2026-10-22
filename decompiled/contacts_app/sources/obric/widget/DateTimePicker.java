package obric.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.format.DateUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.bytedance.common.utility.date.DateDef;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import obric.util.Utils;

/* JADX INFO: loaded from: classes5.dex */
public class DateTimePicker extends FrameLayout {
    private static final String DATE_FORMAT = "yyyy/MM/dd";
    private static final boolean DEFAULT_ENABLED_STATE = true;
    private long mBaseDateMills;
    private Calendar mCurrentDate;
    private Locale mCurrentLocale;
    private final DateFormat mDateFormat;
    private final NumberPickerEx mDateSpinner;
    private final NumberPickerEx mHourSpinner;
    private boolean mIsEnabled;
    private Calendar mMaxDate;
    private Calendar mMinDate;
    private final NumberPickerEx mMinuteSpinner;
    private OnDateChangedListener mOnDateChangedListener;
    private final LinearLayout mSpinners;
    private Calendar mTempDate;

    public interface OnDateChangedListener {
        void onDateChanged(long timeMills);
    }

    private static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        private long mCurrentMills;
        private long mMaxMills;
        private long mMinMills;

        /* synthetic */ SavedState(Parcel r1, AnonymousClass1 r2) {
            this(r1);
        }

        /* synthetic */ SavedState(Parcelable r1, long r2, long r4, long r6, AnonymousClass1 r8) {
            this(r1, r2, r4, r6);
        }

        static /* synthetic */ long access$500(SavedState r2) {
            return r2.mCurrentMills;
        }

        static /* synthetic */ long access$600(SavedState r2) {
            return r2.mMinMills;
        }

        static /* synthetic */ long access$700(SavedState r2) {
            return r2.mMaxMills;
        }

        private SavedState(Parcelable superState, long currentMills, long minMills, long maxMills) {
            super(superState);
            this.mCurrentMills = currentMills;
            this.mMinMills = minMills;
            this.mMaxMills = maxMills;
        }

        private SavedState(Parcel in) {
            super(in);
            this.mCurrentMills = 0;
            this.mMinMills = 0;
            this.mMaxMills = 0;
            this.mCurrentMills = in.readLong();
            this.mMinMills = in.readLong();
            this.mMaxMills = in.readLong();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel dest, int flags) {
            super.writeToParcel(dest, flags);
            dest.writeLong(this.mCurrentMills);
            dest.writeLong(this.mMinMills);
            dest.writeLong(this.mMaxMills);
        }

        static {
            CREATOR = new AnonymousClass1();
        }
    }

    static /* synthetic */ Calendar access$000(DateTimePicker r0) {
        return r0.mCurrentDate;
    }

    static /* synthetic */ void access$100(DateTimePicker r0) {
        r0.notifyDateChanged();
    }

    static /* synthetic */ long access$200(DateTimePicker r0, int r1) {
        return r0.getTimMillsForDayValue(r1);
    }

    static /* synthetic */ DateFormat access$300(DateTimePicker r0) {
        return r0.mDateFormat;
    }

    public DateTimePicker(Context context) {
        this(context, null);
    }

    public DateTimePicker(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DateTimePicker(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mDateFormat = new SimpleDateFormat(DATE_FORMAT);
        this.mIsEnabled = true;
        setCurrentLocale(Locale.getDefault());
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.date_time_picker_ex, this, true);
        Resources r12 = getResources();
        int r0 = r12.getColor(R.color.date_pick_ex_normal_day_color);
        int r13 = r12.getColor(R.color.date_pick_ex_select_day_color);
        this.mSpinners = (LinearLayout) findViewById(R.id.pickers);
        NumberPickerEx r1 = (NumberPickerEx) findViewById(R.id.minute);
        this.mMinuteSpinner = r1;
        r1.setMinValue(0);
        r1.setMaxValue(59);
        r1.setFormatter(NumberPickerEx.getTwoDigitFormatter());
        r1.setTextColor(r0, r13);
        r1.setTextSize(Utils.dipToPx(getContext(), 16.0d), Utils.dipToPx(getContext(), 18.0d));
        r1.setOnValueChangedListener(new AnonymousClass1(this));
        NumberPickerEx r3 = (NumberPickerEx) findViewById(R.id.hour);
        this.mHourSpinner = r3;
        r3.setMinValue(0);
        r3.setMaxValue(23);
        r3.setTextSize(Utils.dipToPx(getContext(), 16.0d), Utils.dipToPx(getContext(), 18.0d));
        r3.setTextColor(r0, r13);
        r3.setOnValueChangedListener(new AnonymousClass2(this));
        NumberPickerEx r4 = (NumberPickerEx) findViewById(R.id.date);
        this.mDateSpinner = r4;
        r4.setTextSize(Utils.dipToPx(getContext(), 15.0d), Utils.dipToPx(getContext(), 17.0d));
        r4.setTextColor(r0, r13);
        r4.setMinValue(0);
        r4.setFormatter(new AnonymousClass3(this));
        r4.setOnValueChangedListener(new AnonymousClass4(this));
        if ("zh".equals(Locale.getDefault().getLanguage()) == false) goto L5;
        r3.setHightlightSuffix(context.getResources().getString(R.string.date_time_picker_hour));
        r1.setHightlightSuffix(context.getResources().getString(R.string.date_time_picker_minute));
    L5:
        setSpinnersShown(true);
        if (getImportantForAccessibility() != 0) goto L8;
        setImportantForAccessibility(1);
    L8:
        setBackgroundResource(R.drawable.time_picker_widget_bg_ex_new);
    }

    private long getTimMillsForDayValue(int value) {
        return ((this.mBaseDateMills + (((long) value) * 86400000)) + (((long) this.mHourSpinner.getValue()) * DateDef.HOUR)) + (((long) this.mMinuteSpinner.getValue()) * 60000);
    }

    private int getDayValueForTimeMills(long timeMills) {
        return Long.valueOf((timeMills - this.mBaseDateMills) / 86400000).intValue();
    }

    public long getCurrentMills() {
        return this.mCurrentDate.getTimeInMillis();
    }

    public void setMinDate(long minTimeMills) {
        if (this.mMinDate.getTimeInMillis() != minTimeMills) goto L5;
        return;
    L5:
        changeMinDate(minTimeMills);
        if (this.mCurrentDate.before(this.mMinDate) == false) goto L8;
        this.mCurrentDate.setTimeInMillis(this.mMinDate.getTimeInMillis());
    L8:
        updateSpinners();
    }

    public void setCurrentDate(long currentDateMills) {
        if (this.mCurrentDate.getTimeInMillis() != currentDateMills) goto L5;
        return;
    L5:
        this.mTempDate.setTimeInMillis(currentDateMills);
        if (this.mTempDate.before(this.mMinDate) == false) goto L8;
        return;
    L8:
        if (this.mTempDate.after(this.mMaxDate) == true) goto L13;
        this.mCurrentDate.setTimeInMillis(currentDateMills);
        updateSpinners();
        return;
    }

    private void changeMinDate(long minDate) {
        this.mMinDate.setTimeInMillis(minDate);
        this.mTempDate.set(this.mMinDate.get(1), this.mMinDate.get(2), this.mMinDate.get(5), 0, 0, 0);
        this.mBaseDateMills = this.mTempDate.getTimeInMillis();
    }

    public void setMaxDate(long maxTimeMIlls) {
        if (maxTimeMIlls != this.mMaxDate.getTimeInMillis()) goto L5;
        return;
    L5:
        this.mMaxDate.setTimeInMillis(maxTimeMIlls);
        if (this.mCurrentDate.after(this.mMaxDate) == false) goto L8;
        this.mCurrentDate.setTimeInMillis(this.mMaxDate.getTimeInMillis());
    L8:
        this.mDateSpinner.setMaxValue(getDayValueForTimeMills(maxTimeMIlls));
        this.mDateSpinner.setWrapSelectorWheel(false);
        updateSpinners();
    }

    @Override // android.view.View
    public void setEnabled(boolean enabled) {
        if (this.mIsEnabled != enabled) goto L5;
        return;
    L5:
        super.setEnabled(enabled);
        this.mMinuteSpinner.setEnabled(enabled);
        this.mHourSpinner.setEnabled(enabled);
        this.mDateSpinner.setEnabled(enabled);
        this.mIsEnabled = enabled;
    }

    @Override // android.view.View
    public boolean isEnabled() {
        return this.mIsEnabled;
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
        onPopulateAccessibilityEvent(event);
        return true;
    }

    @Override // android.view.View
    public void onPopulateAccessibilityEvent(AccessibilityEvent event) {
        super.onPopulateAccessibilityEvent(event);
        String r3 = DateUtils.formatDateTime(getContext(), this.mCurrentDate.getTimeInMillis(), 20);
        event.getText().add(r3);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent event) {
        super.onInitializeAccessibilityEvent(event);
        event.setClassName(DateTimePicker.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        super.onInitializeAccessibilityNodeInfo(info);
        info.setClassName(DateTimePicker.class.getName());
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        setCurrentLocale(newConfig.locale);
    }

    public boolean getSpinnersShown() {
        return this.mSpinners.isShown();
    }

    public void setSpinnersShown(boolean shown) {
        LinearLayout r0 = this.mSpinners;
        if (shown == false) goto L5;
        int r1 = 0;
    L6:
        r0.setVisibility(r1);
        return;
    L5:
        r1 = 8;
        goto L6
    }

    private void setCurrentLocale(Locale locale) {
        if (locale.equals(this.mCurrentLocale) == false) goto L5;
        return;
    L5:
        this.mCurrentLocale = locale;
        this.mTempDate = getCalendarForLocale(this.mTempDate, locale);
        this.mCurrentDate = getCalendarForLocale(this.mCurrentDate, locale);
        this.mMinDate = getCalendarForLocale(this.mMinDate, locale);
        this.mMaxDate = getCalendarForLocale(this.mMaxDate, locale);
    }

    private Calendar getCalendarForLocale(Calendar oldCalendar, Locale locale) {
        if (oldCalendar == null) goto L4;
        long r0 = oldCalendar.getTimeInMillis();
        Calendar r2 = Calendar.getInstance(locale);
        r2.setTimeInMillis(r0);
        return r2;
    L4:
        return Calendar.getInstance(locale);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> container) {
        dispatchThawSelfOnly(container);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.mCurrentDate.getTimeInMillis(), this.mMinDate.getTimeInMillis(), this.mMaxDate.getTimeInMillis(), null);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable state) {
        if (state != null) goto L4;
        return;
    L4:
        if ((state instanceof SavedState) == false) goto L9;
        SavedState r10 = (SavedState) state;
        super.onRestoreInstanceState(r10.getSuperState());
        init(SavedState.access$500(r10), SavedState.access$600(r10), SavedState.access$700(r10), null);
        setCurrentDate(SavedState.access$500(r10));
        updateSpinners();
        return;
    }

    public void init(long initTimeMills, long miniTimeMills, long maxTimeMills, OnDateChangedListener onDateChangedListener) {
        this.mCurrentDate.setTimeInMillis(initTimeMills);
        setMinDate(miniTimeMills);
        setMaxDate(maxTimeMills);
        setSpinnersInitialValues();
        setOnDateChangedListener(onDateChangedListener);
    }

    public void setOnDateChangedListener(OnDateChangedListener listener) {
        this.mOnDateChangedListener = listener;
    }

    private void setSpinnersInitialValues() {
        this.mDateSpinner.setInitialValue(getDayValueForTimeMills(this.mCurrentDate.getTimeInMillis()));
        this.mHourSpinner.setInitialValue(this.mCurrentDate.get(11));
        this.mMinuteSpinner.setInitialValue(this.mCurrentDate.get(12));
    }

    private void updateSpinners() {
        this.mDateSpinner.setValue(getDayValueForTimeMills(this.mCurrentDate.getTimeInMillis()));
        this.mHourSpinner.setValue(this.mCurrentDate.get(11));
        this.mMinuteSpinner.setValue(this.mCurrentDate.get(12));
    }

    private void notifyDateChanged() {
        sendAccessibilityEvent(4);
        OnDateChangedListener r0 = this.mOnDateChangedListener;
        if (r0 == null) goto L6;
        r0.onDateChanged(this.mCurrentDate.getTimeInMillis());
        return;
    }
}
