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
import com.GlobalProxyLancet;
import com.google.android.material.timepicker.TimeModel;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Locale;
import obric.InvokeApi;
import obric.util.Utils;

/* JADX INFO: loaded from: classes5.dex */
public class DatePickerEx extends FrameLayout {
    private static final String DATE_FORMAT = "MM/dd/yyyy";
    public static final int DEFAULT_BIRTHDAY_START_YEAR = 1800;
    private static final boolean DEFAULT_ENABLED_STATE = true;
    private static final int DEFAULT_EVENT_END_YEAR = 2037;
    private static final int DEFAULT_EVENT_START_YEAR = 1970;
    private static final boolean DEFAULT_SPINNERS_SHOWN = true;
    private static final String LOG_TAG = "BytedanceDatePickerEx";
    private Calendar mCurrentDate;
    private Locale mCurrentLocale;
    private final DateFormat mDateFormat;
    private final NumberPickerEx mDaySpinner;
    private boolean mIsEnabled;
    private Calendar mMaxDate;
    private Calendar mMinDate;
    private final NumberPickerEx mMonthSpinner;
    private int mNumberOfMonths;
    private OnDateChangedListener mOnDateChangedListener;
    private DatePickerType mPickerType;
    private String[] mShortMonths;
    private final LinearLayout mSpinners;
    private Calendar mTempDate;
    private final NumberPickerEx mYearSpinner;

    /* JADX INFO: renamed from: obric.widget.DatePickerEx$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$obric$widget$DatePickerEx$DatePickerType = null;

        static {
            int[] r0 = new int[DatePickerType.values().length];
            $SwitchMap$obric$widget$DatePickerEx$DatePickerType = r0;
            r0[DatePickerType.BIRTHDAY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$obric$widget$DatePickerEx$DatePickerType[DatePickerType.EVENT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public static final enum DatePickerType extends Enum<DatePickerType> {
        private static final /* synthetic */ DatePickerType[] $VALUES = null;
        public static final DatePickerType BIRTHDAY = null;
        public static final DatePickerType BIRTHDAY_LUNAR = null;
        public static final DatePickerType EVENT = null;

        private DatePickerType(String $enum$name, int $enum$ordinal) {
            super($enum$name, $enum$ordinal);
        }

        public static DatePickerType valueOf(String name) {
            return (DatePickerType) Enum.valueOf(DatePickerType.class, name);
        }

        public static DatePickerType[] values() {
            return (DatePickerType[]) $VALUES.clone();
        }

        static {
            DatePickerType r0 = new DatePickerType("EVENT", 0);
            EVENT = r0;
            DatePickerType r1 = new DatePickerType("BIRTHDAY", 1);
            BIRTHDAY = r1;
            DatePickerType r3 = new DatePickerType("BIRTHDAY_LUNAR", 2);
            BIRTHDAY_LUNAR = r3;
            $VALUES = new DatePickerType[]{r0, r1, r3};
        }
    }

    public interface OnDateChangedListener {
        void onDateChanged(DatePickerEx view, int year, int monthOfYear, int dayOfMonth, DatePickerType type);
    }

    private static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        private final int mDay;
        private final int mMonth;
        private final int mYear;

        /* synthetic */ SavedState(Parcel r1, AnonymousClass1 r2) {
            this(r1);
        }

        /* synthetic */ SavedState(Parcelable r1, int r2, int r3, int r4, AnonymousClass1 r5) {
            this(r1, r2, r3, r4);
        }

        static /* synthetic */ int access$1000(SavedState r0) {
            return r0.mMonth;
        }

        static /* synthetic */ int access$1100(SavedState r0) {
            return r0.mDay;
        }

        static /* synthetic */ int access$900(SavedState r0) {
            return r0.mYear;
        }

        private SavedState(Parcelable superState, int year, int month, int day) {
            super(superState);
            this.mYear = year;
            this.mMonth = month;
            this.mDay = day;
        }

        private SavedState(Parcel in) {
            super(in);
            this.mYear = in.readInt();
            this.mMonth = in.readInt();
            this.mDay = in.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel dest, int flags) {
            super.writeToParcel(dest, flags);
            dest.writeInt(this.mYear);
            dest.writeInt(this.mMonth);
            dest.writeInt(this.mDay);
        }

        static {
            CREATOR = new AnonymousClass1();
        }
    }

    static /* synthetic */ Calendar access$000(DatePickerEx r0) {
        return r0.mCurrentDate;
    }

    static /* synthetic */ Calendar access$100(DatePickerEx r0) {
        return r0.mTempDate;
    }

    static /* synthetic */ NumberPickerEx access$200(DatePickerEx r0) {
        return r0.mDaySpinner;
    }

    static /* synthetic */ NumberPickerEx access$300(DatePickerEx r0) {
        return r0.mMonthSpinner;
    }

    static /* synthetic */ NumberPickerEx access$400(DatePickerEx r0) {
        return r0.mYearSpinner;
    }

    static /* synthetic */ void access$500(DatePickerEx r0, int r1, int r2, int r3) {
        r0.setDate(r1, r2, r3);
    }

    static /* synthetic */ void access$600(DatePickerEx r0) {
        r0.updateSpinners();
    }

    static /* synthetic */ void access$700(DatePickerEx r0) {
        r0.notifyDateChanged();
    }

    public DatePickerEx(Context context) {
        this(context, null);
    }

    public DatePickerEx(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DatePickerEx(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mDateFormat = new SimpleDateFormat(DATE_FORMAT);
        this.mIsEnabled = true;
        setCurrentLocale(Locale.getDefault());
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.date_picker_ex, this, true);
        Resources r13 = getResources();
        int r0 = r13.getColor(R.color.date_pick_ex_normal_day_color);
        int r14 = r13.getColor(R.color.date_pick_ex_select_day_color);
        NumberPickerEx.OnValueChangeListener r1 = new AnonymousClass1(this);
        this.mSpinners = (LinearLayout) findViewById(R.id.pickers);
        NumberPickerEx r2 = (NumberPickerEx) findViewById(R.id.day);
        this.mDaySpinner = r2;
        r2.setFormatter(NumberPickerEx.getTwoDigitFormatter());
        r2.setOnValueChangedListener(r1);
        r2.setTextSize(Utils.dipToPx(getContext(), 15.0d), Utils.dipToPx(getContext(), 20.0d));
        r2.setTextColor(r0, r14);
        NumberPickerEx r3 = (NumberPickerEx) findViewById(R.id.month);
        this.mMonthSpinner = r3;
        r3.setMinValue(0);
        r3.setMaxValue(this.mNumberOfMonths - 1);
        r3.setDisplayedValues(this.mShortMonths);
        r3.setOnValueChangedListener(r1);
        r3.setTextSize(Utils.dipToPx(getContext(), 15.0d), Utils.dipToPx(getContext(), 20.0d));
        r3.setTextColor(r0, r14);
        NumberPickerEx r6 = (NumberPickerEx) findViewById(R.id.year);
        this.mYearSpinner = r6;
        r6.setOnValueChangedListener(r1);
        r6.setTextSize(Utils.dipToPx(getContext(), 15.0d), Utils.dipToPx(getContext(), 20.0d));
        r6.setTextColor(r0, r14);
        if ("zh".equals(Locale.getDefault().getLanguage()) == false) goto L5;
        r2.setHightlightSuffix(context.getResources().getString(R.string.date_picker_day));
        r3.setHightlightSuffix(context.getResources().getString(R.string.date_picker_month));
        r6.setHightlightSuffix(context.getResources().getString(R.string.date_picker_year));
    L5:
        setSpinnersShown(true);
        if (getImportantForAccessibility() != 0) goto L8;
        setImportantForAccessibility(1);
    L8:
        setBackgroundResource(R.drawable.time_picker_widget_bg_ex_new);
    }

    public void setMinDate(long minDate) {
        this.mTempDate.setTimeInMillis(minDate);
        if (this.mTempDate.get(1) == this.mMinDate.get(1)) goto L5;
    L7:
        this.mMinDate.setTimeInMillis(minDate);
        if (this.mCurrentDate.before(this.mMinDate) == false) goto L11;
        this.mCurrentDate.setTimeInMillis(this.mMinDate.getTimeInMillis());
        return;
    L11:
        return;
    L5:
        if (this.mTempDate.get(6) == this.mMinDate.get(6)) goto L7;
    }

    public void setMaxDate(long maxDate) {
        this.mTempDate.setTimeInMillis(maxDate);
        if (this.mTempDate.get(1) == this.mMaxDate.get(1)) goto L5;
    L7:
        this.mMaxDate.setTimeInMillis(maxDate);
        if (this.mCurrentDate.after(this.mMaxDate) == false) goto L11;
        this.mCurrentDate.setTimeInMillis(this.mMaxDate.getTimeInMillis());
        return;
    L11:
        return;
    L5:
        if (this.mTempDate.get(6) == this.mMaxDate.get(6)) goto L7;
    }

    @Override // android.view.View
    public void setEnabled(boolean enabled) {
        if (this.mIsEnabled != enabled) goto L5;
        return;
    L5:
        super.setEnabled(enabled);
        this.mDaySpinner.setEnabled(enabled);
        this.mMonthSpinner.setEnabled(enabled);
        this.mYearSpinner.setEnabled(enabled);
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
        event.setClassName(DatePickerEx.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        super.onInitializeAccessibilityNodeInfo(info);
        info.setClassName(DatePickerEx.class.getName());
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
        this.mMinDate = getCalendarForLocale(this.mMinDate, locale);
        this.mMaxDate = getCalendarForLocale(this.mMaxDate, locale);
        this.mCurrentDate = getCalendarForLocale(this.mCurrentDate, locale);
        this.mNumberOfMonths = this.mTempDate.getActualMaximum(2) + 1;
        this.mShortMonths = new DateFormatSymbols().getShortMonths();
        if (usingNumericMonths() == false) goto L11;
        this.mShortMonths = new String[this.mNumberOfMonths];
        int r1 = 0;
    L9:
        if (r1 >= this.mNumberOfMonths) goto L13;
        int r4 = r1 + 1;
        this.mShortMonths[r1] = String.format(TimeModel.NUMBER_FORMAT, new Object[]{Integer.valueOf(r4)});
        r1 = r4;
        goto L9
    L13:
        return;
    }

    private boolean usingNumericMonths() {
        return Character.isDigit(this.mShortMonths[0].charAt(0));
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

    private void reorderSpinners() {
        this.mSpinners.removeAllViews();
        char[] r0 = InvokeApi.xICU.getDateFormatOrder(DatePicker.getBestDateTimePattern("yyyyMMMdd", Locale.getDefault()));
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L16;
        char r3 = r0[r2];
        if (r3 != 'M') goto L7;
        this.mSpinners.addView(this.mMonthSpinner);
    L15:
        r2 = r2 + 1;
        goto L3
    L7:
        if (r3 != 'd') goto L9;
        this.mSpinners.addView(this.mDaySpinner);
        goto L15
    L9:
        if (r3 != 'y') goto L12;
        this.mSpinners.addView(this.mYearSpinner);
        goto L15
    L12:
        throw new IllegalArgumentException(Arrays.toString(r0));
    }

    public void updateDate(int year, int month, int dayOfMonth) {
        if (isNewDate(year, month, dayOfMonth) == true) goto L5;
        return;
    L5:
        setDate(year, month, dayOfMonth);
        updateSpinners();
        notifyDateChanged();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> container) {
        dispatchThawSelfOnly(container);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), getYear(), getMonth(), getDayOfMonth(), null);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable state) {
        SavedState r3 = (SavedState) state;
        super.onRestoreInstanceState(r3.getSuperState());
        setDate(SavedState.access$900(r3), SavedState.access$1000(r3), SavedState.access$1100(r3));
        updateSpinners();
    }

    public void init(DatePickerType type, int year, int monthOfYear, int dayOfMonth, OnDateChangedListener onDateChangedListener) {
        this.mPickerType = type;
        if (type != DatePickerType.EVENT) goto L5;
        this.mTempDate.clear();
        this.mTempDate.set(1970, 0, 1);
        this.mMinDate.setTimeInMillis(this.mTempDate.getTimeInMillis());
        setMinDate(this.mTempDate.getTimeInMillis());
        this.mTempDate.clear();
        this.mTempDate.set(2037, 11, 31);
        this.mMaxDate.setTimeInMillis(this.mTempDate.getTimeInMillis());
        setMaxDate(this.mTempDate.getTimeInMillis());
        this.mCurrentDate.setTimeInMillis(System.currentTimeMillis());
        setDate(year, monthOfYear, dayOfMonth);
    L9:
        updateSpinners();
        setSpinnersInitialValues();
        this.mOnDateChangedListener = onDateChangedListener;
        return;
    L5:
        this.mTempDate.clear();
        this.mTempDate.set(1800, 0, 1);
        this.mMinDate.setTimeInMillis(this.mTempDate.getTimeInMillis());
        setMinDate(this.mTempDate.getTimeInMillis());
        long r5 = System.currentTimeMillis();
        this.mTempDate.clear();
        this.mTempDate.setTimeInMillis(r5);
        this.mMaxDate.set(this.mTempDate.get(1), 11, 31);
        setMaxDate(this.mMaxDate.getTimeInMillis());
        this.mCurrentDate.setTimeInMillis(r5);
        if (seemsUnsetYear(year, type) == false) goto L8;
        setDate(4, monthOfYear, dayOfMonth);
        goto L9
    L8:
        setDate(year, monthOfYear, dayOfMonth);
        goto L9
    }

    private boolean parseDate(String date, Calendar outDate) {
        outDate.setTime(this.mDateFormat.parse(date));     // Catch: ParseException -> L5
        return true;
    L5:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(LOG_TAG, "Date: " + date + " not in format: MM/dd/yyyy");
        return false;
    }

    private boolean isNewDate(int year, int month, int dayOfMonth) {
        if (this.mCurrentDate.get(1) == year) goto L5;
        return true;
    L5:
        if (this.mCurrentDate.get(2) == dayOfMonth) goto L7;
        return true;
    L7:
        if (this.mCurrentDate.get(5) != month) goto L13;
        return false;
    L13:
        return true;
    }

    private void setDate(int year, int month, int dayOfMonth) {
        this.mCurrentDate.set(year, month, dayOfMonth);
        if (year != 4) goto L6;
        return;
    L6:
        if (this.mCurrentDate.before(this.mMinDate) == false) goto L9;
        this.mCurrentDate.setTimeInMillis(this.mMinDate.getTimeInMillis());
        return;
    L9:
        if (this.mCurrentDate.after(this.mMaxDate) == false) goto L13;
        this.mCurrentDate.setTimeInMillis(this.mMaxDate.getTimeInMillis());
        return;
    }

    private void setSpinnersInitialValues() {
        this.mYearSpinner.setInitialValue(this.mCurrentDate.get(1));
        this.mMonthSpinner.setInitialValue(this.mCurrentDate.get(2));
        this.mDaySpinner.setInitialValue(this.mCurrentDate.get(5));
    }

    private void updateSpinners() {
        if (this.mCurrentDate.equals(this.mMinDate) == false) goto L6;
        this.mDaySpinner.setMinValue(this.mCurrentDate.get(5));
        this.mDaySpinner.setMaxValue(this.mCurrentDate.getActualMaximum(5));
        this.mMonthSpinner.setDisplayedValues(null);
        this.mMonthSpinner.setMinValue(this.mCurrentDate.get(2));
        this.mMonthSpinner.setMaxValue(this.mCurrentDate.getActualMaximum(2));
    L9:
        String[] r0 = (String[]) Arrays.copyOfRange(this.mShortMonths, this.mMonthSpinner.getMinValue(), this.mMonthSpinner.getMaxValue() + 1);
        this.mMonthSpinner.setDisplayedValues(r0);
        this.mYearSpinner.setMinValue(this.mMinDate.get(1));
        if (AnonymousClass2.$SwitchMap$obric$widget$DatePickerEx$DatePickerType[this.mPickerType.ordinal()] == 1) goto L12;
        this.mYearSpinner.setMaxValue(this.mMaxDate.get(1));
    L13:
        this.mYearSpinner.setValue(this.mCurrentDate.get(1));
        this.mMonthSpinner.setValue(this.mCurrentDate.get(2));
        this.mDaySpinner.setValue(this.mCurrentDate.get(5));
        return;
    L12:
        this.mYearSpinner.setMaxValue(this.mMaxDate.get(1), true);
        goto L13
    L6:
        if (this.mCurrentDate.equals(this.mMaxDate) == false) goto L8;
        this.mDaySpinner.setMinValue(this.mCurrentDate.getActualMinimum(5));
        this.mDaySpinner.setMaxValue(this.mCurrentDate.get(5));
        this.mMonthSpinner.setDisplayedValues(null);
        this.mMonthSpinner.setMinValue(this.mCurrentDate.getActualMinimum(2));
        this.mMonthSpinner.setMaxValue(this.mCurrentDate.get(2));
        goto L9
    L8:
        this.mDaySpinner.setMinValue(1);
        this.mDaySpinner.setMaxValue(this.mCurrentDate.getActualMaximum(5));
        this.mMonthSpinner.setDisplayedValues(null);
        this.mMonthSpinner.setMinValue(0);
        this.mMonthSpinner.setMaxValue(11);
        goto L9
    }

    public int getYear() {
        return this.mCurrentDate.get(1);
    }

    public int getMonth() {
        return this.mCurrentDate.get(2);
    }

    public int getDayOfMonth() {
        return this.mCurrentDate.get(5);
    }

    private void notifyDateChanged() {
        sendAccessibilityEvent(4);
        OnDateChangedListener r1 = this.mOnDateChangedListener;
        if (r1 == null) goto L6;
        r1.onDateChanged(this, getYear(), getMonth(), getDayOfMonth(), this.mPickerType);
        return;
    }

    private void trySetContentDescription(View root, int viewId, int contDescResId) {
        View r1 = root.findViewById(viewId);
        if (r1 == null) goto L6;
        r1.setContentDescription(getContext().getString(contDescResId));
        return;
    }

    public static boolean seemsUnsetYear(int year, DatePickerType type) {
        if (type == DatePickerType.BIRTHDAY) goto L5;
        return false;
    L5:
        if (year >= 1800) goto L7;
        return true;
    L7:
        Calendar r4 = Calendar.getInstance(Locale.getDefault());
        r4.clear();
        r4.setTimeInMillis(System.currentTimeMillis());
        if (year <= r4.get(1)) goto L12;
        return true;
    L12:
        return false;
    }
}
