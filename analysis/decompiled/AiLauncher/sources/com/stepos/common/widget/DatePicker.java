package com.stepos.common.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.format.DateUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.material.timepicker.TimeModel;
import com.stepos.common.R$array;
import com.stepos.common.R$color;
import com.stepos.common.R$dimen;
import com.stepos.common.R$id;
import com.stepos.common.R$layout;
import com.stepos.common.R$string;
import com.stepos.common.R$styleable;
import com.stepos.common.widget.ScrollTextView;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

/* loaded from: classes3.dex */
public class DatePicker extends FrameLayout {
    private static final int DEFAULT_END_YEAR = 2099;
    private static final int DEFAULT_START_YEAR = 1900;
    private static final int NUMBER_OF_MONTHS = 12;
    private boolean isLunar;
    private boolean isRTL;
    private int mDay;
    private ScrollTextView mDayPicker;
    private TextView mDayUnit;
    private Calendar mEndCal;
    private int mEndYear;
    String[] mGregorianDays;
    private boolean mIsAccessibilityEnable;
    private boolean mIsDrawLine;
    boolean mIsLayoutRtl;
    private int mLayoutResId;
    String mLeap;
    private TextView mLeapUnit;
    private int mLineOneHeight;
    private Paint mLinePaint;
    private int mLineTwoHeight;
    String[] mLunarMouths;
    String[] mLunardays;
    private int mMonth;
    private volatile Locale mMonthLocale;
    private int mMonthOfDays;
    private ScrollTextView mMonthPicker;
    private TextView mMonthUnit;
    private Object mMonthUpdateLock;
    private String[] mMonths;
    private float mNormalItemHeight;
    private List<Float> mNumberNormalTextSizes;
    private int mNumberSelectTextSize;
    private int mOldMonth;
    private int mOldMonthIndex;
    private int mOldYear;
    private f mOnDateChangedListener;
    private int mOneScreenCount;
    String mOrder;
    private LinearLayout mPickerHolder;
    private float mSelectItemHeight;
    private String[] mShortMonths;
    private Calendar mStartCal;
    private int mStartYear;
    private int mWidthPadding;
    private List<Float> mWordNormalTextSizes;
    private int mWordSelectTextSize;
    private int mYear;
    private int mYearOfMonths;
    private ScrollTextView mYearPicker;
    private TextView mYearUnit;

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        private final int mDay;
        private final int mMonth;
        private final int mYear;

        public class a implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        public /* synthetic */ SavedState(Parcel parcel, a aVar) {
            this(parcel);
        }

        public int getDay() {
            return this.mDay;
        }

        public int getMonth() {
            return this.mMonth;
        }

        public int getYear() {
            return this.mYear;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.mYear);
            parcel.writeInt(this.mMonth);
            parcel.writeInt(this.mDay);
        }

        public /* synthetic */ SavedState(Parcelable parcelable, int i10, int i11, int i12, a aVar) {
            this(parcelable, i10, i11, i12);
        }

        private SavedState(Parcelable parcelable, int i10, int i11, int i12) {
            super(parcelable);
            this.mYear = i10;
            this.mMonth = i11;
            this.mDay = i12;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.mYear = parcel.readInt();
            this.mMonth = parcel.readInt();
            this.mDay = parcel.readInt();
        }
    }

    public class a implements ScrollTextView.h {
        public a() {
        }

        @Override // com.stepos.common.widget.ScrollTextView.h
        public void a(ScrollTextView scrollTextView) {
            scrollTextView.setIsDrawFading(true);
        }

        @Override // com.stepos.common.widget.ScrollTextView.h
        public void b(ScrollTextView scrollTextView) {
        }
    }

    public class b implements ScrollTextView.h {
        public b() {
        }

        @Override // com.stepos.common.widget.ScrollTextView.h
        public void a(ScrollTextView scrollTextView) {
            scrollTextView.setIsDrawFading(true);
        }

        @Override // com.stepos.common.widget.ScrollTextView.h
        public void b(ScrollTextView scrollTextView) {
        }
    }

    public class c implements ScrollTextView.h {
        public c() {
        }

        @Override // com.stepos.common.widget.ScrollTextView.h
        public void a(ScrollTextView scrollTextView) {
            DatePicker.this.setIsDrawFading(true);
        }

        @Override // com.stepos.common.widget.ScrollTextView.h
        public void b(ScrollTextView scrollTextView) {
        }
    }

    public class d implements Runnable {
        public d() {
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() {
            /*
                r2 = this;
                com.stepos.common.widget.DatePicker r0 = com.stepos.common.widget.DatePicker.this
                com.stepos.common.widget.ScrollTextView r1 = com.stepos.common.widget.DatePicker.q(r0)
                if (r1 == 0) goto L16
                com.stepos.common.widget.DatePicker r2 = com.stepos.common.widget.DatePicker.this
                com.stepos.common.widget.ScrollTextView r2 = com.stepos.common.widget.DatePicker.q(r2)
                int r2 = r2.getLayoutDirection()
                r1 = 1
                if (r2 != r1) goto L16
                goto L17
            L16:
                r1 = 0
            L17:
                r0.mIsLayoutRtl = r1
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.common.widget.DatePicker.d.run():void");
        }
    }

    public class e implements ScrollTextView.e {
        static final int SET_DAY = 3;
        static final int SET_MONTH = 2;
        static final int SET_YEAR = 1;
        int mType;

        public e(int i10) {
            this.mType = i10;
        }

        @Override // com.stepos.common.widget.ScrollTextView.e
        public String a(int i10) {
            int i11 = this.mType;
            if (i11 == 1) {
                return String.format(Locale.getDefault(), TimeModel.NUMBER_FORMAT, Integer.valueOf(i10 + DatePicker.this.mStartYear));
            }
            if (i11 == 2) {
                if (DatePicker.this.isLunar) {
                    return DatePicker.this.D(i10);
                }
                if (DatePicker.this.mStartCal != null && DatePicker.this.mStartCal.get(1) == DatePicker.this.mYear) {
                    i10 += DatePicker.this.mStartCal.get(2);
                }
                if (i10 < DatePicker.this.mMonths.length) {
                    return DatePicker.this.mMonths[i10];
                }
                return null;
            }
            if (i11 != 3) {
                return null;
            }
            if (DatePicker.this.isLunar) {
                return DatePicker.this.C(i10);
            }
            if (DatePicker.this.mStartCal == null || DatePicker.this.mStartCal.get(1) != DatePicker.this.mYear || DatePicker.this.mStartCal.get(2) != DatePicker.this.mMonth) {
                return DatePicker.this.mGregorianDays[i10 + 1];
            }
            DatePicker datePicker = DatePicker.this;
            return datePicker.mGregorianDays[i10 + datePicker.mStartCal.get(5)];
        }

        @Override // com.stepos.common.widget.ScrollTextView.e
        public void b(View view, int i10, int i11) {
            int monthDays = DatePicker.this.getMonthDays();
            DatePicker.this.getYearMonths();
            int i12 = this.mType;
            if (i12 == 1) {
                int i13 = DatePicker.this.mYear;
                DatePicker datePicker = DatePicker.this;
                datePicker.mYear = i11 + datePicker.mStartYear;
                if (DatePicker.this.mStartCal != null && DatePicker.this.mStartCal.get(1) == DatePicker.this.mYear && DatePicker.this.mMonth < DatePicker.this.mStartCal.get(2)) {
                    DatePicker datePicker2 = DatePicker.this;
                    datePicker2.mMonth = datePicker2.mStartCal.get(2);
                }
                if (DatePicker.this.mMonthPicker != null) {
                    int yearMonths = DatePicker.this.getYearMonths();
                    if (DatePicker.this.isLunar) {
                        int iD = O6.l.d(i13);
                        int iD2 = O6.l.d(DatePicker.this.mYear);
                        DatePicker datePicker3 = DatePicker.this;
                        int iE = datePicker3.E(iD, iD2, datePicker3.mOldMonthIndex);
                        DatePicker.this.mYearOfMonths = yearMonths;
                        DatePicker.this.mMonthPicker.U(yearMonths, iE);
                        DatePicker datePicker4 = DatePicker.this;
                        datePicker4.mMonth = datePicker4.mMonthPicker.getCurrentItem();
                    } else {
                        DatePicker.this.mYearOfMonths = yearMonths;
                        DatePicker.this.mMonthPicker.T(yearMonths);
                    }
                    int i14 = yearMonths - 1;
                    if (i14 < DatePicker.this.mMonth) {
                        DatePicker.this.mDay = monthDays;
                        DatePicker.this.mMonth = i14;
                        DatePicker.this.mMonthPicker.Y(DatePicker.this.mMonth, true);
                    }
                }
                if (monthDays != DatePicker.this.getMonthDays() && DatePicker.this.mDayPicker != null) {
                    int monthDays2 = DatePicker.this.getMonthDays();
                    DatePicker.this.mMonthOfDays = monthDays2;
                    DatePicker.this.mDayPicker.T(monthDays2);
                    if (monthDays2 < DatePicker.this.mDay) {
                        DatePicker.this.mDay = monthDays2;
                        DatePicker.this.mDayPicker.Y(DatePicker.this.mDay - 1, true);
                    }
                }
            } else if (i12 == 2) {
                DatePicker.this.mMonth = i11;
                if (DatePicker.this.mStartCal != null && DatePicker.this.mStartCal.get(1) == DatePicker.this.mYear) {
                    DatePicker datePicker5 = DatePicker.this;
                    DatePicker.x(datePicker5, datePicker5.mStartCal.get(2));
                }
                if (monthDays != DatePicker.this.getMonthDays() && DatePicker.this.mDayPicker != null) {
                    int monthDays3 = DatePicker.this.getMonthDays();
                    DatePicker.this.mMonthOfDays = monthDays3;
                    DatePicker.this.mDayPicker.T(monthDays3);
                    if (monthDays3 < DatePicker.this.mDay) {
                        DatePicker.this.mDay = monthDays3;
                        DatePicker.this.mDayPicker.Y(DatePicker.this.mDay - 1, true);
                    }
                }
            } else {
                if (i12 != 3) {
                    return;
                }
                if (DatePicker.this.mDayPicker.getVisibility() != 8) {
                    DatePicker.this.mDay = i11 + 1;
                    if (DatePicker.this.mStartCal != null && DatePicker.this.mStartCal.get(1) == DatePicker.this.mYear && DatePicker.this.mStartCal.get(2) == DatePicker.this.mMonth) {
                        DatePicker datePicker6 = DatePicker.this;
                        datePicker6.mDay = i11 + datePicker6.mStartCal.get(5);
                    }
                }
            }
            DatePicker datePicker7 = DatePicker.this;
            datePicker7.setDayRange(datePicker7.mMonth);
            DatePicker datePicker8 = DatePicker.this;
            datePicker8.setMonthRange(datePicker8.mYear);
            DatePicker.m(DatePicker.this);
            int i15 = this.mType;
            if (i15 == 1 || i15 == 2) {
                DatePicker datePicker9 = DatePicker.this;
                datePicker9.setLeapUnitVisibility(datePicker9.mMonth);
            }
            if (DatePicker.this.mMonthPicker != null) {
                DatePicker datePicker10 = DatePicker.this;
                datePicker10.mOldMonthIndex = datePicker10.mMonthPicker.getCurrentItem();
            }
            DatePicker.this.M(this.mType);
        }
    }

    public interface f {
    }

    public DatePicker(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private Calendar getCurrentCalendar() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(5, 1);
        calendar.set(1, this.mYear);
        calendar.set(2, this.mMonth);
        return calendar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getMonthDays() {
        if (!this.isLunar) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(5, 1);
            calendar.set(1, this.mYear);
            calendar.set(2, this.mMonth);
            return calendar.getActualMaximum(5);
        }
        int i10 = this.mMonth;
        int iD = O6.l.d(this.mYear);
        boolean z10 = false;
        if (iD != 0) {
            z10 = iD == i10;
        }
        if (iD == 0 || (iD != 0 && this.mMonth < iD)) {
            i10++;
        }
        return O6.l.c(this.mYear, i10, z10);
    }

    private String[] getShortMonths() {
        Locale locale = Locale.getDefault();
        int i10 = 0;
        if (!locale.equals(this.mMonthLocale) || this.mShortMonths == null) {
            synchronized (this.mMonthUpdateLock) {
                try {
                    if (!locale.equals(this.mMonthLocale)) {
                        this.mShortMonths = new String[12];
                        for (int i11 = 0; i11 < 12; i11++) {
                            this.mShortMonths[i11] = DateUtils.getMonthString(i11, 20);
                        }
                        if (this.mShortMonths[0].startsWith("1")) {
                            int i12 = 0;
                            while (true) {
                                String[] strArr = this.mShortMonths;
                                if (i12 >= strArr.length) {
                                    break;
                                }
                                int i13 = i12 + 1;
                                strArr[i12] = String.valueOf(i13);
                                if (i12 < 9) {
                                    this.mShortMonths[i12] = "0" + this.mShortMonths[i12];
                                }
                                i12 = i13;
                            }
                        }
                        this.mMonthLocale = locale;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        ScrollTextView scrollTextView = this.mMonthPicker;
        if (scrollTextView != null && scrollTextView.getWidth() > 0 && this.mShortMonths != null) {
            while (true) {
                String[] strArr2 = this.mShortMonths;
                if (i10 >= strArr2.length) {
                    break;
                }
                if (this.mMonthPicker.M(strArr2[i10]) > this.mMonthPicker.getWidth()) {
                    this.mShortMonths = new String[]{"01", "02", UxipConstants.EVENT_UPLOAD_MAJOR_VERSION, "04", "05", "06", "07", "08", "09", "10", "11", "12"};
                    break;
                }
                i10++;
            }
        }
        return this.mShortMonths;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getYearMonths() {
        return (!this.isLunar || O6.l.d(this.mYear) == 0) ? 12 : 13;
    }

    public static /* synthetic */ f m(DatePicker datePicker) {
        datePicker.getClass();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0072 A[PHI: r1 r2
      0x0072: PHI (r1v11 int) = (r1v3 int), (r1v4 int), (r1v12 int) binds: [B:66:0x014f, B:57:0x011a, B:23:0x0070] A[DONT_GENERATE, DONT_INLINE]
      0x0072: PHI (r2v19 int) = (r2v6 int), (r2v10 int), (r2v22 int) binds: [B:66:0x014f, B:57:0x011a, B:23:0x0070] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0074 A[PHI: r1 r2
      0x0074: PHI (r1v8 int) = (r1v3 int), (r1v4 int), (r1v12 int) binds: [B:66:0x014f, B:57:0x011a, B:23:0x0070] A[DONT_GENERATE, DONT_INLINE]
      0x0074: PHI (r2v16 int) = (r2v6 int), (r2v10 int), (r2v22 int) binds: [B:66:0x014f, B:57:0x011a, B:23:0x0070] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00ba A[PHI: r0 r1 r2
      0x00ba: PHI (r0v10 int) = (r0v5 int), (r0v11 int) binds: [B:74:0x017d, B:37:0x00b6] A[DONT_GENERATE, DONT_INLINE]
      0x00ba: PHI (r1v5 int) = (r1v2 int), (r1v6 int) binds: [B:74:0x017d, B:37:0x00b6] A[DONT_GENERATE, DONT_INLINE]
      0x00ba: PHI (r2v12 int) = (r2v2 int), (r2v13 int) binds: [B:74:0x017d, B:37:0x00b6] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void setDayRange(int r10) {
        /*
            Method dump skipped, instructions count: 407
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.common.widget.DatePicker.setDayRange(int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLeapUnitVisibility(int i10) {
        if (H() && G(i10)) {
            this.mLeapUnit.setVisibility(0);
        } else {
            this.mLeapUnit.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00d3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void setMonthRange(int r9) {
        /*
            Method dump skipped, instructions count: 254
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.common.widget.DatePicker.setMonthRange(int):void");
    }

    public static /* synthetic */ int x(DatePicker datePicker, int i10) {
        int i11 = datePicker.mMonth + i10;
        datePicker.mMonth = i11;
        return i11;
    }

    public final void B() {
        TextView textView = (TextView) findViewById(R$id.mc_scroll1_text);
        this.mMonthUnit = textView;
        if (textView != null) {
            textView.setText(R$string.mc_date_time_month);
        }
        TextView textView2 = (TextView) findViewById(R$id.mc_scroll2_text);
        this.mDayUnit = textView2;
        if (textView2 != null) {
            textView2.setText(R$string.mc_date_time_day);
        }
        TextView textView3 = (TextView) findViewById(R$id.mc_scroll3_text);
        this.mYearUnit = textView3;
        if (textView3 != null) {
            textView3.setText(R$string.mc_date_time_year);
        }
    }

    public String C(int i10) {
        String[] strArr = this.mLunardays;
        if (i10 > strArr.length - 1) {
            return null;
        }
        return strArr[i10];
    }

    public final String D(int i10) {
        int iD = O6.l.d(this.mYear);
        if (iD == 0) {
            if (i10 >= 12) {
                return null;
            }
        } else if (i10 >= 13) {
            return null;
        }
        return (iD == 0 || i10 <= iD + (-1)) ? this.mLunarMouths[i10] : i10 == iD ? this.mLunarMouths[i10 - 1] : this.mLunarMouths[i10 - 1];
    }

    public final int E(int i10, int i11, int i12) {
        if (i10 > i11 && i11 == 0 && i12 >= i10) {
            return -1;
        }
        if (i10 < i11 && i10 == 0 && i12 >= i11) {
            return 1;
        }
        if (i10 >= i11 || i10 == 0 || i10 > i12 || i11 <= i12) {
            return (i10 <= i11 || i11 == 0 || i10 <= i12 || i11 > i12) ? 0 : 1;
        }
        return -1;
    }

    public final String F(int i10) {
        if (i10 == 1) {
            return String.valueOf(this.mYear);
        }
        if (i10 != 2) {
            if (i10 != 3) {
                return "";
            }
            int i11 = this.mDay;
            return this.isLunar ? C(i11 - 1) : String.valueOf(i11);
        }
        int i12 = this.mMonth;
        if (this.isLunar) {
            return D(i12);
        }
        if (this.mMonths == null) {
            this.mMonths = getShortMonths();
        }
        String[] strArr = this.mMonths;
        return i12 < strArr.length ? strArr[i12] : "";
    }

    public final boolean G(int i10) {
        if (!I()) {
            return false;
        }
        int iD = O6.l.d(this.mYear);
        if (iD == 0) {
            if (i10 >= 12) {
                return false;
            }
        } else if (i10 >= 13) {
            return false;
        }
        return iD != 0 && i10 > iD + (-1) && i10 == iD;
    }

    public boolean H() {
        return this.isLunar;
    }

    public final boolean I() {
        return getResources().getConfiguration().locale.getLanguage().endsWith("zh");
    }

    public void J() {
        Q();
        this.mOldYear = -1;
        setMonthRange(this.mYear);
        this.mOldMonth = -1;
        setDayRange(this.mMonth);
    }

    public final void K() {
        if (this.isLunar && I()) {
            this.mMonthPicker.g0(this.mWordSelectTextSize, this.mWordNormalTextSizes);
            this.mDayPicker.g0(this.mWordSelectTextSize, this.mWordNormalTextSizes);
        } else {
            this.mMonthPicker.g0(this.mNumberSelectTextSize, this.mNumberNormalTextSizes);
            this.mDayPicker.g0(this.mNumberSelectTextSize, this.mNumberNormalTextSizes);
        }
        this.mYearPicker.g0(this.mNumberSelectTextSize, this.mNumberNormalTextSizes);
    }

    public final void L(String[] strArr) {
        int i10;
        boolean z10;
        DateFormat dateFormat = strArr[0].startsWith("1") ? android.text.format.DateFormat.getDateFormat(getContext()) : android.text.format.DateFormat.getMediumDateFormat(getContext());
        if (dateFormat instanceof SimpleDateFormat) {
            this.mOrder = ((SimpleDateFormat) dateFormat).toPattern();
        } else {
            this.mOrder = new String(android.text.format.DateFormat.getDateFormatOrder(getContext()));
        }
        FrameLayout frameLayout = (FrameLayout) findViewById(R$id.mc_column1Layout);
        FrameLayout frameLayout2 = (FrameLayout) findViewById(R$id.mc_column2Layout);
        FrameLayout frameLayout3 = (FrameLayout) findViewById(R$id.mc_column3Layout);
        ImageView imageView = (ImageView) findViewById(R$id.mc_divider_bar1);
        ImageView imageView2 = (ImageView) findViewById(R$id.mc_divider_bar2);
        LinearLayout linearLayout = (LinearLayout) findViewById(R$id.mc_column_parent);
        linearLayout.removeAllViews();
        if (this.mOrder.contentEquals("dd\u200f/MM\u200f/y") || this.mOrder.contentEquals("d בMMM y")) {
            this.mOrder = "yy/M/d";
        }
        if (this.isRTL) {
            this.mOrder = "d/M/yy";
        }
        int i11 = 0;
        boolean z11 = false;
        boolean z12 = false;
        boolean z13 = false;
        boolean z14 = false;
        boolean z15 = false;
        boolean z16 = false;
        while (i11 < this.mOrder.length()) {
            char cCharAt = this.mOrder.charAt(i11);
            if (cCharAt == '\'') {
                z13 = !z13;
            }
            if (z13) {
                i10 = i11;
            } else {
                i10 = i11;
                if (cCharAt == 'd' && !z12) {
                    linearLayout.addView(frameLayout2);
                    z10 = true;
                    z12 = true;
                } else if ((cCharAt == 'M' || cCharAt == 'L') && !z11) {
                    linearLayout.addView(frameLayout);
                    z10 = true;
                    z11 = true;
                } else if (cCharAt != 'y' || z14) {
                    z10 = false;
                } else {
                    linearLayout.addView(frameLayout3);
                    z10 = true;
                    z14 = true;
                }
                if (true == z10) {
                    if (!z15) {
                        linearLayout.addView(imageView);
                        z15 = true;
                    } else if (!z16) {
                        linearLayout.addView(imageView2);
                        z16 = true;
                    }
                }
            }
            i11 = i10 + 1;
        }
        if (!z11) {
            linearLayout.addView(frameLayout);
        }
        if (!z12) {
            linearLayout.addView(frameLayout2);
        }
        if (!z14) {
            linearLayout.addView(frameLayout3);
        }
        if (!I()) {
            FrameLayout frameLayout4 = (FrameLayout) findViewById(R$id.mc_column2Layout);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) frameLayout4.getLayoutParams();
            layoutParams.setMarginEnd(0);
            frameLayout4.setLayoutParams(layoutParams);
        }
        this.mYearPicker.post(new d());
    }

    public final void M(int i10) {
        View viewFindViewById;
        if (this.mIsAccessibilityEnable) {
            N();
            if (i10 == 1) {
                View viewFindViewById2 = findViewById(R$id.mc_column3Layout);
                if (viewFindViewById2 != null) {
                    viewFindViewById2.sendAccessibilityEvent(4);
                    return;
                }
                return;
            }
            if (i10 == 2) {
                View viewFindViewById3 = findViewById(R$id.mc_column1Layout);
                if (viewFindViewById3 != null) {
                    viewFindViewById3.sendAccessibilityEvent(4);
                    return;
                }
                return;
            }
            if (i10 != 3 || (viewFindViewById = findViewById(R$id.mc_column2Layout)) == null) {
                return;
            }
            viewFindViewById.sendAccessibilityEvent(4);
        }
    }

    public final void N() {
        String strReplace;
        if (this.mIsAccessibilityEnable) {
            View viewFindViewById = findViewById(R$id.mc_column3Layout);
            View viewFindViewById2 = findViewById(R$id.mc_column1Layout);
            View viewFindViewById3 = findViewById(R$id.mc_column2Layout);
            if (viewFindViewById3 == null || viewFindViewById3.getVisibility() != 8) {
                strReplace = (F(1) + ((Object) this.mYearUnit.getText()) + F(2) + ((Object) this.mMonthUnit.getText()) + F(3) + ((Object) this.mDayUnit.getText())).replace(" ", "").replace("廿十", "二十").replace("廿", "二十");
            } else {
                strReplace = (F(1) + ((Object) this.mYearUnit.getText()) + F(2) + ((Object) this.mMonthUnit.getText())).replace(" ", "").replace("廿十", "二十").replace("廿", "二十");
            }
            if (viewFindViewById != null) {
                viewFindViewById.setFocusable(true);
                viewFindViewById.setContentDescription("上下滚动设置年，当前日期是" + strReplace);
            }
            if (viewFindViewById2 != null) {
                viewFindViewById2.setFocusable(true);
                viewFindViewById2.setContentDescription("上下滚动设置月，当前日期是" + strReplace);
            }
            if (viewFindViewById3 != null) {
                viewFindViewById3.setFocusable(true);
                viewFindViewById3.setContentDescription("上下滚动设置日，当前日期是" + strReplace);
            }
        }
    }

    public void O(boolean z10, boolean z11) {
        int i10;
        boolean z12;
        int[] iArrE;
        int i11;
        if (this.isLunar == z10) {
            return;
        }
        this.isLunar = z10;
        int[] iArr = {this.mYear, this.mMonth + 1, this.mDay, 0};
        int i12 = iArr[0];
        int iD = O6.l.d(i12);
        int iD2 = O6.l.d(iArr[0] - 1);
        if (this.isLunar) {
            iArrE = O6.l.f(iArr[0], iArr[1], iArr[2]);
            int i13 = iArrE[0];
            if ((i12 != i13 && iD2 != 0 && (iArrE[3] == 1 || iArrE[1] > iD2)) || (i12 == i13 && iD != 0 && (iArrE[3] == 1 || iArrE[1] > iD))) {
                iArrE[1] = iArrE[1] + 1;
            }
            this.mDayUnit.setAlpha(0.0f);
        } else {
            if (iD == 0 || iD >= (i11 = iArr[1])) {
                i10 = iArr[1];
            } else {
                int i14 = iD + 1;
                if (i14 == i11) {
                    i10 = i11 - 1;
                    z12 = true;
                } else if (i14 < i11) {
                    i10 = i11 - 1;
                } else {
                    i10 = 0;
                    z12 = false;
                }
                this.mDayUnit.setAlpha(1.0f);
                iArrE = O6.l.e(iArr[0], i10, iArr[2], z12);
            }
            z12 = false;
            this.mDayUnit.setAlpha(1.0f);
            iArrE = O6.l.e(iArr[0], i10, iArr[2], z12);
        }
        K();
        int i15 = iArrE[0];
        int i16 = iArrE[1];
        P(i15, i16 + (-1) < 0 ? 12 : i16 - 1, iArrE[2], z11, false);
        setLeapUnitVisibility(this.mMonth);
    }

    public final void P(int i10, int i11, int i12, boolean z10, boolean z11) {
        int i13 = this.mStartYear;
        if (i10 >= i13) {
            i13 = i10;
        }
        this.mYear = i13;
        int i14 = this.mEndYear;
        if (i10 > i14) {
            i10 = i14;
        }
        this.mYear = i10;
        this.mMonth = i11;
        this.mDay = i12;
        this.mMonths = null;
        this.mMonths = getShortMonths();
        this.mYearPicker.h0();
        this.mMonthPicker.h0();
        this.mDayPicker.h0();
        if (this.mYearOfMonths != getYearMonths()) {
            int yearMonths = getYearMonths();
            this.mYearOfMonths = yearMonths;
            this.mMonthPicker.T(yearMonths);
        }
        if (this.mMonthOfDays != getMonthDays()) {
            this.mMonthOfDays = getMonthDays();
            this.mDayPicker.T(getMonthDays());
        }
        if (z10) {
            this.mYearPicker.Y(this.mYear - this.mStartYear, true);
            this.mMonth = i11;
            this.mMonthPicker.Y(i11, true);
            this.mDayPicker.Y(this.mDay - 1, true);
        } else {
            this.mYearPicker.V(this.mYear - this.mStartYear);
            this.mMonth = i11;
            this.mMonthPicker.V(i11);
            this.mDayPicker.V(this.mDay - 1);
        }
        if (z11) {
            L(this.mMonths);
        }
    }

    public final void Q() {
        ScrollTextView scrollTextView = this.mYearPicker;
        e eVar = new e(1);
        int i10 = this.mYear;
        int i11 = this.mStartYear;
        int i12 = this.mEndYear;
        scrollTextView.Z(eVar, -1.0f, i10 - i11, (i12 - i11) + 1, this.mOneScreenCount, 0, i12 - i11, false);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    public int getDayOfMonth() {
        return this.mDay;
    }

    public TextView getDayUnit() {
        return this.mDayUnit;
    }

    public int getMonth() {
        return this.mMonth;
    }

    public int getYear() {
        return this.mYear;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mIsDrawLine) {
            int width = getWidth();
            int width2 = this.mPickerHolder.getWidth() - (this.mWidthPadding * 2);
            int i10 = (width - width2) / 2;
            float f10 = i10;
            int i11 = this.mLineOneHeight;
            float f11 = i10 + width2;
            canvas.drawLine(f10, i11, f11, i11, this.mLinePaint);
            int i12 = this.mLineTwoHeight;
            canvas.drawLine(f10, i12, f11, i12, this.mLinePaint);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(DatePicker.class.getName());
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mYear = savedState.getYear();
        this.mMonth = savedState.getMonth();
        this.mDay = savedState.getDay();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.mYear, this.mMonth, this.mDay, null);
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z10) {
        super.onWindowFocusChanged(z10);
        if (z10) {
            String[] shortMonths = getShortMonths();
            DateFormat dateFormat = shortMonths[0].startsWith("1") ? android.text.format.DateFormat.getDateFormat(getContext()) : android.text.format.DateFormat.getMediumDateFormat(getContext());
            String pattern = dateFormat instanceof SimpleDateFormat ? ((SimpleDateFormat) dateFormat).toPattern() : new String(android.text.format.DateFormat.getDateFormatOrder(getContext()));
            this.mMonths = shortMonths;
            if (this.mOrder.equals(pattern)) {
                return;
            }
            L(this.mMonths);
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z10) {
        super.setEnabled(z10);
        this.mDayPicker.setEnabled(z10);
        this.mMonthPicker.setEnabled(z10);
        this.mYearPicker.setEnabled(z10);
    }

    public void setIsDrawFading(boolean z10) {
        this.mYearPicker.setIsDrawFading(z10);
        this.mMonthPicker.setIsDrawFading(z10);
        this.mDayPicker.setIsDrawFading(z10);
    }

    public void setIsDrawLine(boolean z10) {
        this.mIsDrawLine = z10;
    }

    public void setLunar(boolean z10) {
        O(z10, true);
    }

    public void setMaxDate(long j10) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j10);
        this.mEndCal = calendar;
        this.mEndYear = calendar.get(1);
        J();
    }

    public void setMinDate(long j10) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j10);
        this.mStartCal = calendar;
        this.mStartYear = calendar.get(1);
        J();
    }

    public void setShowDayColumn(boolean z10) {
        FrameLayout frameLayout = (FrameLayout) findViewById(R$id.mc_column2Layout);
        if (frameLayout != null) {
            frameLayout.setVisibility(z10 ? 0 : 8);
            N();
            this.mDayPicker.setVisibility(z10 ? 0 : 8);
        }
    }

    public DatePicker(Context context, AttributeSet attributeSet, int i10) throws Resources.NotFoundException {
        super(context, attributeSet, i10);
        this.isLunar = false;
        this.mMonthUpdateLock = new Object();
        this.mOneScreenCount = 5;
        this.mLayoutResId = R$layout.mc_date_picker;
        this.mIsAccessibilityEnable = false;
        this.mIsLayoutRtl = false;
        this.isRTL = false;
        this.mOldMonthIndex = 0;
        this.isRTL = context.getResources().getConfiguration().getLayoutDirection() == 1;
        ArrayList arrayList = new ArrayList();
        this.mWordNormalTextSizes = arrayList;
        arrayList.add(Float.valueOf(context.getResources().getDimension(R$dimen.mc_picker_normal_word_size_one)));
        this.mWordNormalTextSizes.add(Float.valueOf(context.getResources().getDimension(R$dimen.mc_picker_normal_word_size_two)));
        this.mWordSelectTextSize = context.getResources().getDimensionPixelOffset(R$dimen.mc_picker_selected_word_size);
        ArrayList arrayList2 = new ArrayList();
        this.mNumberNormalTextSizes = arrayList2;
        arrayList2.add(Float.valueOf(context.getResources().getDimension(R$dimen.mc_picker_normal_number_size_one)));
        this.mNumberNormalTextSizes.add(Float.valueOf(context.getResources().getDimension(R$dimen.mc_picker_normal_number_size_two)));
        this.mNumberSelectTextSize = Math.min(getContext().getResources().getDimensionPixelOffset(R$dimen.mc_picker_selected_number_max_size), getContext().getResources().getDimensionPixelOffset(R$dimen.mc_picker_selected_number_size));
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.DatePicker);
        this.mStartYear = typedArrayObtainStyledAttributes.getInt(R$styleable.DatePicker_mcStartYear, 1900);
        this.mEndYear = typedArrayObtainStyledAttributes.getInt(R$styleable.DatePicker_mcEndYear, 2099);
        this.mLayoutResId = typedArrayObtainStyledAttributes.getResourceId(R$styleable.DatePicker_mcInternalLayout, this.mLayoutResId);
        this.mOneScreenCount = typedArrayObtainStyledAttributes.getInt(R$styleable.DatePicker_mcVisibleRow, this.mOneScreenCount);
        this.mSelectItemHeight = typedArrayObtainStyledAttributes.getDimension(R$styleable.DatePicker_mcSelectItemHeight, this.mSelectItemHeight);
        this.mNormalItemHeight = typedArrayObtainStyledAttributes.getDimension(R$styleable.DatePicker_mcNormalItemHeight, this.mNormalItemHeight);
        typedArrayObtainStyledAttributes.recycle();
        View.inflate(getContext(), this.mLayoutResId, this);
        this.mLeapUnit = (TextView) findViewById(R$id.mc_leap);
        TextView textView = (TextView) findViewById(R$id.mc_scroll1_text);
        this.mMonthUnit = textView;
        if (textView != null) {
            textView.setText(R$string.mc_date_time_month);
        }
        TextView textView2 = (TextView) findViewById(R$id.mc_scroll2_text);
        this.mDayUnit = textView2;
        if (textView2 != null) {
            textView2.setText(R$string.mc_date_time_day);
        }
        TextView textView3 = (TextView) findViewById(R$id.mc_scroll3_text);
        this.mYearUnit = textView3;
        if (textView3 != null) {
            textView3.setText(R$string.mc_date_time_year);
        }
        Calendar calendar = Calendar.getInstance();
        this.mYear = calendar.get(1);
        this.mMonth = calendar.get(2);
        this.mDay = calendar.get(5);
        int actualMaximum = calendar.getActualMaximum(5);
        this.mPickerHolder = (LinearLayout) findViewById(R$id.mc_column_parent);
        ScrollTextView scrollTextView = (ScrollTextView) findViewById(R$id.mc_scroll2);
        this.mDayPicker = scrollTextView;
        if (this.mSelectItemHeight != 0.0f) {
            if (this.mNormalItemHeight != 0.0f) {
                scrollTextView.a0((int) r4, (int) r8);
            }
        }
        this.mDayPicker.Z(new e(3), -1.0f, this.mDay - 1, actualMaximum, this.mOneScreenCount, 0, actualMaximum - 1, true);
        ScrollTextView scrollTextView2 = (ScrollTextView) findViewById(R$id.mc_scroll1);
        this.mMonthPicker = scrollTextView2;
        if (this.mSelectItemHeight != 0.0f) {
            if (this.mNormalItemHeight != 0.0f) {
                scrollTextView2.a0((int) r4, (int) r8);
            }
        }
        this.mMonths = getShortMonths();
        this.mMonthPicker.Z(new e(2), -1.0f, this.mMonth, 12, this.mOneScreenCount, 0, 11, true);
        ScrollTextView scrollTextView3 = (ScrollTextView) findViewById(R$id.mc_scroll3);
        this.mYearPicker = scrollTextView3;
        if (this.mSelectItemHeight != 0.0f) {
            if (this.mNormalItemHeight != 0.0f) {
                scrollTextView3.a0((int) r4, (int) r6);
            }
        }
        K();
        Q();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Calendar calendar2 = Calendar.getInstance();
            this.mStartCal = calendar2;
            calendar2.setTime(simpleDateFormat.parse(this.mStartYear + "-01-01"));
        } catch (ParseException e10) {
            e10.printStackTrace();
        }
        try {
            Calendar calendar3 = Calendar.getInstance();
            this.mEndCal = calendar3;
            calendar3.setTime(simpleDateFormat.parse(this.mEndYear + "-12-31"));
        } catch (ParseException e11) {
            e11.printStackTrace();
        }
        L(this.mMonths);
        boolean zI = I();
        this.mDayUnit.setVisibility(zI ? 0 : 8);
        this.mMonthUnit.setVisibility(zI ? 0 : 8);
        this.mYearUnit.setVisibility(zI ? 0 : 8);
        B();
        if (!isEnabled()) {
            setEnabled(false);
        }
        this.mLineOneHeight = 0;
        this.mLineTwoHeight = 0;
        this.mWidthPadding = context.getResources().getDimensionPixelSize(R$dimen.mc_custom_time_picker_line_width_padding);
        this.mLinePaint = new Paint();
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(R$styleable.StepOSTheme);
        int i11 = typedArrayObtainStyledAttributes2.getInt(R$styleable.StepOSTheme_steposThemeColor, context.getResources().getColor(R$color.mc_custom_date_picker_selected_gregorian_color));
        typedArrayObtainStyledAttributes2.recycle();
        this.mLinePaint.setColor(i11);
        this.mLinePaint.setAntiAlias(true);
        this.mLinePaint.setStrokeWidth(context.getResources().getDimensionPixelSize(R$dimen.mc_custom_time_picker_line_stroke_width));
        this.mIsDrawLine = false;
        setWillNotDraw(false);
        this.mLunarMouths = getResources().getStringArray(R$array.mc_custom_time_picker_lunar_month);
        this.mLunardays = getResources().getStringArray(R$array.mc_custom_time_picker_lunar_day);
        String str = String.format(Locale.getDefault(), TimeModel.NUMBER_FORMAT, 0);
        this.mGregorianDays = new String[100];
        for (int i12 = 0; i12 < 100; i12++) {
            this.mGregorianDays[i12] = String.format(Locale.getDefault(), TimeModel.NUMBER_FORMAT, Integer.valueOf(i12));
            if (i12 <= 9) {
                this.mGregorianDays[i12] = str + this.mGregorianDays[i12];
            }
        }
        String string = getResources().getString(R$string.mc_time_picker_leap);
        this.mLeap = string;
        this.mLeapUnit.setText(string);
        this.mLeapUnit.setVisibility(8);
        if (Build.DEVICE.equals("mx4pro")) {
            this.mYearPicker.v(new a());
            this.mMonthPicker.v(new b());
            this.mDayPicker.v(new c());
        }
        AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
        if (accessibilityManager != null) {
            this.mIsAccessibilityEnable = accessibilityManager.isEnabled();
        }
    }
}
