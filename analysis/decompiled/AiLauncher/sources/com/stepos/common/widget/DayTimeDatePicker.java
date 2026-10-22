package com.stepos.common.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.stepos.common.R$array;
import com.stepos.common.R$color;
import com.stepos.common.R$dimen;
import com.stepos.common.R$id;
import com.stepos.common.R$layout;
import com.stepos.common.R$string;
import com.stepos.common.R$styleable;
import com.stepos.common.widget.ScrollTextView;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/* loaded from: classes3.dex */
public class DayTimeDatePicker extends FrameLayout {
    private static final int DEFAULT_END_YEAR = 2099;
    private static final int DEFAULT_START_YEAR = 1900;
    private boolean isLunar;
    private int mDay;
    private String mDayString;
    private Calendar mEndCal;
    private int mEndYear;
    String[] mGregorianDays;
    private int mHour;
    private ScrollTextView mHourPicker;
    String[] mHourTexts;
    private TextView mHourUnit;
    private boolean mIsAccessibilityEnable;
    private boolean mIsDrawLine;
    boolean mIsLayoutRtl;
    String mLeap;
    private TextView mLeapMonthUnit;
    private int mLineOneHeight;
    private Paint mLinePaint;
    private int mLineTwoHeight;
    String[] mLunarMouths;
    String[] mLunardays;
    private int mMin;
    private ScrollTextView mMinPicker;
    String[] mMinTexts;
    private TextView mMinUnit;
    private int mMonth;
    private ScrollTextView mMonthDayPicker;
    private int mMonthOfDays;
    private String mMonthString;
    private float mNormalItemHeight;
    private Typeface mNumTpyeface;
    private List<Float> mNumberNormalTextSizes;
    private int mNumberSelectTextSize;
    private int mOldMonth;
    private e mOnTimeChangedListener;
    private int mOneScreenCount;
    private LinearLayout mPickerHolder;
    private float mSelectItemHeight;
    private Calendar mStartCal;
    private int mStartYear;
    private int mWidthPadding;
    private List<Float> mWordNormalTextSizes;
    private int mWordSelectTextSize;
    private int mYear;
    private int mYearOfMonths;
    private Typeface mZhTypeface;

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
            DayTimeDatePicker.this.setIsDrawFading(true);
        }

        @Override // com.stepos.common.widget.ScrollTextView.h
        public void b(ScrollTextView scrollTextView) {
        }
    }

    public class d implements ScrollTextView.e {
        static final int SET_HOUR = 4;
        static final int SET_MIN = 5;
        static final int SET_MOUNT_DAY = 6;
        int mType;

        public d(int i10) {
            this.mType = i10;
        }

        @Override // com.stepos.common.widget.ScrollTextView.e
        public String a(int i10) {
            int i11 = this.mType;
            if (i11 == 4) {
                return DayTimeDatePicker.this.mHourTexts[i10];
            }
            if (i11 == 5) {
                return DayTimeDatePicker.this.mMinTexts[i10];
            }
            if (i11 != 6) {
                return null;
            }
            if (DayTimeDatePicker.this.isLunar) {
                int i12 = DayTimeDatePicker.this.mYear;
                int iB = DayTimeDatePicker.this.B(i10);
                if (iB > DayTimeDatePicker.this.D(i12) - 1) {
                    iB -= DayTimeDatePicker.this.D(i12);
                    i12++;
                } else if (iB < 0) {
                    iB += DayTimeDatePicker.this.D(i12 - 1);
                    i12--;
                }
                DayTimeDatePicker dayTimeDatePicker = DayTimeDatePicker.this;
                String strZ = dayTimeDatePicker.z(i12, iB + 1, dayTimeDatePicker.mLunarMouths);
                int iX = DayTimeDatePicker.this.x(i10);
                StringBuilder sb2 = new StringBuilder();
                sb2.append(strZ);
                sb2.append(DayTimeDatePicker.this.G() ? DayTimeDatePicker.this.mMonthString : " ");
                sb2.append(DayTimeDatePicker.this.y(iX - 1));
                return sb2.toString();
            }
            int iB2 = DayTimeDatePicker.this.B(i10);
            DayTimeDatePicker dayTimeDatePicker2 = DayTimeDatePicker.this;
            if (iB2 > dayTimeDatePicker2.D(dayTimeDatePicker2.mYear) - 1) {
                DayTimeDatePicker dayTimeDatePicker3 = DayTimeDatePicker.this;
                iB2 -= dayTimeDatePicker3.D(dayTimeDatePicker3.mYear);
            } else if (iB2 < 0) {
                DayTimeDatePicker dayTimeDatePicker4 = DayTimeDatePicker.this;
                iB2 += dayTimeDatePicker4.D(dayTimeDatePicker4.mYear);
            }
            if (!DayTimeDatePicker.this.G()) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(DayTimeDatePicker.this.mLunarMouths[iB2]);
                sb3.append(" ");
                DayTimeDatePicker dayTimeDatePicker5 = DayTimeDatePicker.this;
                sb3.append(dayTimeDatePicker5.mGregorianDays[dayTimeDatePicker5.x(i10)]);
                return sb3.toString();
            }
            int i13 = iB2 + 1;
            if (DayTimeDatePicker.this.mStartCal != null && DayTimeDatePicker.this.mStartCal.get(1) == DayTimeDatePicker.this.mYear && DayTimeDatePicker.this.mStartCal.get(2) == DayTimeDatePicker.this.mMonth) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append(i13);
                sb4.append(DayTimeDatePicker.this.mMonthString);
                DayTimeDatePicker dayTimeDatePicker6 = DayTimeDatePicker.this;
                sb4.append(dayTimeDatePicker6.mGregorianDays[(dayTimeDatePicker6.x(i10) - 1) + DayTimeDatePicker.this.mStartCal.get(5)]);
                sb4.append(DayTimeDatePicker.this.mDayString);
                return sb4.toString();
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append(i13);
            sb5.append(DayTimeDatePicker.this.mMonthString);
            DayTimeDatePicker dayTimeDatePicker7 = DayTimeDatePicker.this;
            sb5.append(dayTimeDatePicker7.mGregorianDays[dayTimeDatePicker7.x(i10)]);
            sb5.append(DayTimeDatePicker.this.mDayString);
            return sb5.toString();
        }

        @Override // com.stepos.common.widget.ScrollTextView.e
        public void b(View view, int i10, int i11) {
            int i12 = this.mType;
            if (i12 == 4) {
                DayTimeDatePicker.this.mHour = i11;
            } else if (i12 == 5) {
                DayTimeDatePicker.this.mMin = i11;
            } else {
                if (i12 != 6) {
                    return;
                }
                if (DayTimeDatePicker.this.mStartCal != null && DayTimeDatePicker.this.mStartCal.get(1) == DayTimeDatePicker.this.mYear && DayTimeDatePicker.this.mStartCal.get(2) == DayTimeDatePicker.this.mMonth) {
                    DayTimeDatePicker dayTimeDatePicker = DayTimeDatePicker.this;
                    dayTimeDatePicker.mDay = dayTimeDatePicker.mStartCal.get(5) + i11;
                }
                int iB = DayTimeDatePicker.this.B(i11);
                DayTimeDatePicker dayTimeDatePicker2 = DayTimeDatePicker.this;
                dayTimeDatePicker2.mDay = dayTimeDatePicker2.x(i11);
                DayTimeDatePicker.this.mMonth = iB;
                int i13 = DayTimeDatePicker.this.mMonth;
                DayTimeDatePicker dayTimeDatePicker3 = DayTimeDatePicker.this;
                if (i13 > dayTimeDatePicker3.D(dayTimeDatePicker3.mYear) - 1) {
                    DayTimeDatePicker dayTimeDatePicker4 = DayTimeDatePicker.this;
                    DayTimeDatePicker.v(dayTimeDatePicker4, dayTimeDatePicker4.D(dayTimeDatePicker4.mYear));
                    DayTimeDatePicker.e(DayTimeDatePicker.this, 1);
                } else if (DayTimeDatePicker.this.mMonth < 0) {
                    DayTimeDatePicker dayTimeDatePicker5 = DayTimeDatePicker.this;
                    DayTimeDatePicker.u(dayTimeDatePicker5, dayTimeDatePicker5.D(dayTimeDatePicker5.mYear - 1));
                    DayTimeDatePicker.f(DayTimeDatePicker.this, 1);
                }
                DayTimeDatePicker.this.I();
            }
            DayTimeDatePicker.j(DayTimeDatePicker.this);
            DayTimeDatePicker.this.J(this.mType);
        }
    }

    public interface e {
    }

    public DayTimeDatePicker(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public static /* synthetic */ int e(DayTimeDatePicker dayTimeDatePicker, int i10) {
        int i11 = dayTimeDatePicker.mYear + i10;
        dayTimeDatePicker.mYear = i11;
        return i11;
    }

    public static /* synthetic */ int f(DayTimeDatePicker dayTimeDatePicker, int i10) {
        int i11 = dayTimeDatePicker.mYear - i10;
        dayTimeDatePicker.mYear = i11;
        return i11;
    }

    private Calendar getCurrentCalendar() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(5, 1);
        calendar.set(1, this.mYear);
        calendar.set(2, this.mMonth);
        return calendar;
    }

    private int getDaysPosition() {
        return getTwoMonthBeforeMonthDays() + getOneMonthBeforeMonthDays() + this.mDay;
    }

    private int getMonthDays() {
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

    private int getMonthDaysCount() {
        return getTwoMonthBeforeMonthDays() + getOneMonthBeforeMonthDays() + A(this.mYear, this.mMonth) + getOneMonthAfterMonthDays() + getTwoMonthAfterMonthDays();
    }

    private int getOneMonthAfterMonthDays() {
        if (this.mMonth <= D(this.mYear) - 2) {
            return A(this.mYear, this.mMonth + 1);
        }
        int i10 = this.mYear;
        return A(i10 + 1, (this.mMonth + 1) - D(i10));
    }

    private int getOneMonthBeforeMonthDays() {
        int i10 = this.mMonth;
        if (i10 >= 1) {
            return A(this.mYear, i10 - 1);
        }
        int i11 = this.mYear;
        return A(i11 - 1, (i10 - 1) + D(i11 - 1));
    }

    private int getTwoMonthAfterMonthDays() {
        if (this.mMonth <= D(this.mYear) - 3) {
            return A(this.mYear, this.mMonth + 2);
        }
        int i10 = this.mYear;
        return A(i10 + 1, (this.mMonth + 2) - D(i10));
    }

    private int getTwoMonthBeforeMonthDays() {
        int i10 = this.mMonth;
        if (i10 >= 2) {
            return A(this.mYear, i10 - 2);
        }
        int i11 = this.mYear;
        return A(i11 - 1, (i10 - 2) + D(i11 - 1));
    }

    public static /* synthetic */ e j(DayTimeDatePicker dayTimeDatePicker) {
        dayTimeDatePicker.getClass();
        return null;
    }

    private void setDayRange(int i10) {
    }

    private void setLeapUnitVisibility(int i10) {
        if (F() && E(i10)) {
            this.mLeapMonthUnit.setVisibility(0);
        } else {
            this.mLeapMonthUnit.setVisibility(8);
        }
    }

    private void setMonthRange(int i10) {
    }

    public static /* synthetic */ int u(DayTimeDatePicker dayTimeDatePicker, int i10) {
        int i11 = dayTimeDatePicker.mMonth + i10;
        dayTimeDatePicker.mMonth = i11;
        return i11;
    }

    public static /* synthetic */ int v(DayTimeDatePicker dayTimeDatePicker, int i10) {
        int i11 = dayTimeDatePicker.mMonth - i10;
        dayTimeDatePicker.mMonth = i11;
        return i11;
    }

    public final int A(int i10, int i11) {
        Calendar calendar = this.mStartCal;
        boolean z10 = false;
        if (calendar != null && this.mEndCal != null && ((calendar.get(1) == i10 && this.mStartCal.get(2) > i11) || this.mStartCal.get(1) > i10 || ((this.mEndCal.get(1) == i10 && this.mEndCal.get(2) < i11) || this.mEndCal.get(1) < i10))) {
            return 0;
        }
        Calendar calendar2 = this.mStartCal;
        if (calendar2 != null && calendar2.get(1) == i10 && this.mStartCal.get(2) == i11) {
            return this.mStartCal.getActualMaximum(5) - this.mStartCal.get(5);
        }
        Calendar calendar3 = this.mEndCal;
        if (calendar3 != null && calendar3.get(1) == i10 && this.mEndCal.get(2) == i11) {
            if (!this.isLunar || this.mEndCal.get(5) <= 30) {
                return this.mEndCal.get(5);
            }
            return 30;
        }
        if (!this.isLunar) {
            Calendar calendar4 = Calendar.getInstance();
            calendar4.set(5, 1);
            calendar4.set(1, i10);
            calendar4.set(2, i11);
            return calendar4.getActualMaximum(5);
        }
        int iD = O6.l.d(i10);
        if (iD != 0 && iD == i11) {
            z10 = true;
        }
        if (iD == 0 || (iD != 0 && i11 < iD)) {
            i11++;
        }
        return O6.l.c(i10, i11, z10);
    }

    public final int B(int i10) {
        int twoMonthBeforeMonthDays = getTwoMonthBeforeMonthDays();
        int oneMonthBeforeMonthDays = getOneMonthBeforeMonthDays() + twoMonthBeforeMonthDays;
        int iA = A(this.mYear, this.mMonth) + oneMonthBeforeMonthDays;
        int oneMonthAfterMonthDays = getOneMonthAfterMonthDays() + iA;
        int twoMonthAfterMonthDays = getTwoMonthAfterMonthDays() + oneMonthAfterMonthDays;
        if (i10 < twoMonthBeforeMonthDays) {
            return this.mMonth - 2;
        }
        if (i10 >= twoMonthBeforeMonthDays && i10 < oneMonthBeforeMonthDays) {
            return this.mMonth - 1;
        }
        if (i10 >= oneMonthBeforeMonthDays && i10 < iA) {
            return this.mMonth;
        }
        if (i10 >= iA && i10 < oneMonthAfterMonthDays) {
            return this.mMonth + 1;
        }
        if (i10 < oneMonthAfterMonthDays || i10 >= twoMonthAfterMonthDays) {
            return 0;
        }
        return this.mMonth + 2;
    }

    public final String C(int i10) {
        return i10 != 4 ? i10 != 5 ? "" : String.valueOf(this.mMin) : String.valueOf(this.mHour);
    }

    public final int D(int i10) {
        return (!this.isLunar || O6.l.d(i10) == 0) ? 12 : 13;
    }

    public final boolean E(int i10) {
        if (!G()) {
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

    public boolean F() {
        return this.isLunar;
    }

    public final boolean G() {
        return getResources().getConfiguration().locale.getLanguage().endsWith("zh");
    }

    public final void H() {
        if (this.isLunar && G()) {
            this.mMonthDayPicker.g0(this.mWordSelectTextSize, this.mWordNormalTextSizes);
            this.mMonthDayPicker.setTypeface(this.mZhTypeface);
        } else {
            this.mMonthDayPicker.g0(this.mNumberSelectTextSize, this.mNumberNormalTextSizes);
            this.mMonthDayPicker.setTypeface(this.mNumTpyeface);
        }
        this.mHourPicker.g0(this.mNumberSelectTextSize, this.mNumberNormalTextSizes);
        this.mHourPicker.setTypeface(this.mNumTpyeface);
        this.mMinPicker.g0(this.mNumberSelectTextSize, this.mNumberNormalTextSizes);
        this.mMinPicker.setTypeface(this.mNumTpyeface);
    }

    public final void I() {
        int monthDaysCount = getMonthDaysCount();
        this.mMonthDayPicker.Z(new d(6), -1.0f, getDaysPosition() - 1, monthDaysCount, this.mOneScreenCount, 0, monthDaysCount - 1, false);
    }

    public final void J(int i10) {
        View viewFindViewById;
        if (this.mIsAccessibilityEnable) {
            K();
            if (i10 == 5) {
                View viewFindViewById2 = findViewById(R$id.mc_column_min_Layout);
                if (viewFindViewById2 != null) {
                    viewFindViewById2.sendAccessibilityEvent(4);
                    return;
                }
                return;
            }
            if (i10 == 4) {
                View viewFindViewById3 = findViewById(R$id.mc_column_hour_Layout);
                if (viewFindViewById3 != null) {
                    viewFindViewById3.sendAccessibilityEvent(4);
                    return;
                }
                return;
            }
            if (i10 != 6 || (viewFindViewById = findViewById(R$id.mc_column_day_Layout)) == null) {
                return;
            }
            viewFindViewById.sendAccessibilityEvent(4);
        }
    }

    public final void K() {
        if (this.mIsAccessibilityEnable) {
            View viewFindViewById = findViewById(R$id.mc_column_min_Layout);
            View viewFindViewById2 = findViewById(R$id.mc_column_day_Layout);
            View viewFindViewById3 = findViewById(R$id.mc_column_hour_Layout);
            String strReplace = (C(6) + C(4) + ((Object) this.mHourUnit.getText()) + C(5) + ((Object) this.mMinUnit.getText())).replace(" ", "").replace("廿十", "二十").replace("廿", "二十");
            if (viewFindViewById != null) {
                viewFindViewById.setFocusable(true);
                viewFindViewById.setContentDescription("上下滚动设置分，当前日期是" + strReplace);
            }
            if (viewFindViewById2 != null) {
                viewFindViewById2.setFocusable(true);
                viewFindViewById2.setContentDescription("上下滚动设置日，当前日期是" + strReplace);
            }
            if (viewFindViewById3 != null) {
                viewFindViewById3.setFocusable(true);
                viewFindViewById3.setContentDescription("上下滚动设置时，当前日期是" + strReplace);
            }
        }
    }

    public void L(boolean z10, boolean z11) {
        int i10;
        boolean z12;
        int[] iArrE;
        int i11;
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
                iArrE = O6.l.e(iArr[0], i10, iArr[2], z12);
            }
            z12 = false;
            iArrE = O6.l.e(iArr[0], i10, iArr[2], z12);
        }
        H();
        int i15 = iArrE[0];
        int i16 = iArrE[1];
        N(i15, i16 + (-1) < 0 ? 12 : i16 - 1, iArrE[2], this.mHour, this.mMin, z11);
        setLeapUnitVisibility(this.mMonth);
    }

    public void M(int i10, int i11, int i12, int i13, int i14) {
        N(i10, i11, i12, i13, i14, false);
    }

    public final void N(int i10, int i11, int i12, int i13, int i14, boolean z10) {
        int i15 = this.mStartYear;
        if (i10 >= i15) {
            i15 = i10;
        }
        this.mYear = i15;
        int i16 = this.mEndYear;
        if (i10 > i16) {
            i10 = i16;
        }
        this.mYear = i10;
        if (i11 > 11) {
            i11 = 11;
        }
        this.mMonth = i11;
        this.mDay = i12;
        this.mHour = i13;
        this.mMin = i14;
        this.mHourPicker.Y(i13, z10);
        this.mMinPicker.Y(this.mMin, z10);
        if (this.mMonthOfDays != getMonthDaysCount()) {
            int monthDaysCount = getMonthDaysCount();
            this.mMonthOfDays = monthDaysCount;
            this.mMonthDayPicker.T(monthDaysCount);
        }
        this.mMonthDayPicker.Y(getDaysPosition() - 1, z10);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    public int getCurrentHour() {
        return this.mHour;
    }

    public Integer getCurrentMinute() {
        return Integer.valueOf(this.mMin);
    }

    public int getDayOfMonth() {
        return this.mDay;
    }

    public TextView getMinUnit() {
        return this.mMinUnit;
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
    }

    public void setCurrentHour(Integer num) {
        if (num == null || num.intValue() == getCurrentHour()) {
            return;
        }
        M(this.mYear, this.mMonth, this.mDay, num.intValue(), this.mMin);
    }

    public void setCurrentMinute(Integer num) {
        M(this.mYear, this.mMonth, this.mDay, getCurrentHour(), num.intValue());
    }

    @Override // android.view.View
    public void setEnabled(boolean z10) {
        super.setEnabled(z10);
        this.mMonthDayPicker.setEnabled(z10);
        this.mHourPicker.setEnabled(z10);
        this.mMinPicker.setEnabled(z10);
    }

    public void setIsDrawFading(boolean z10) {
        this.mMinPicker.setIsDrawFading(z10);
        this.mHourPicker.setIsDrawFading(z10);
        this.mMonthDayPicker.setIsDrawFading(z10);
    }

    public void setIsDrawLine(boolean z10) {
        this.mIsDrawLine = z10;
    }

    public void setLunar(boolean z10) {
        L(z10, true);
    }

    public void setOnTimeChangedListener(e eVar) {
    }

    public final void w() {
        TextView textView = (TextView) findViewById(R$id.mc_scroll_hour_text);
        this.mHourUnit = textView;
        if (textView != null) {
            textView.setText(R$string.mc_date_time_hour);
        }
        TextView textView2 = (TextView) findViewById(R$id.mc_scroll_min_text);
        this.mMinUnit = textView2;
        if (textView2 != null) {
            textView2.setText(R$string.mc_date_time_min);
        }
    }

    public final int x(int i10) {
        int i11;
        int twoMonthBeforeMonthDays = getTwoMonthBeforeMonthDays();
        int oneMonthBeforeMonthDays = getOneMonthBeforeMonthDays() + twoMonthBeforeMonthDays;
        int iA = A(this.mYear, this.mMonth) + oneMonthBeforeMonthDays;
        int oneMonthAfterMonthDays = getOneMonthAfterMonthDays() + iA;
        int twoMonthAfterMonthDays = getTwoMonthAfterMonthDays() + oneMonthAfterMonthDays;
        if (i10 < twoMonthBeforeMonthDays) {
            return i10 + 1;
        }
        if (i10 >= twoMonthBeforeMonthDays && i10 < oneMonthBeforeMonthDays) {
            i11 = i10 - twoMonthBeforeMonthDays;
        } else if (i10 >= oneMonthBeforeMonthDays && i10 < iA) {
            i11 = i10 - oneMonthBeforeMonthDays;
        } else if (i10 >= iA && i10 < oneMonthAfterMonthDays) {
            i11 = i10 - iA;
        } else {
            if (i10 < oneMonthAfterMonthDays || i10 >= twoMonthAfterMonthDays) {
                return 1;
            }
            i11 = i10 - oneMonthAfterMonthDays;
        }
        return i11 + 1;
    }

    public String y(int i10) {
        String[] strArr = this.mLunardays;
        if (i10 > strArr.length - 1) {
            return null;
        }
        return strArr[i10];
    }

    public final String z(int i10, int i11, String[] strArr) {
        int iD = O6.l.d(i10);
        if (iD != 0 && i11 > iD) {
            return strArr[i11 - 2];
        }
        if (i11 - 1 >= strArr.length) {
            i11 = strArr.length - 1;
        }
        return strArr[i11 - 1];
    }

    public DayTimeDatePicker(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.isLunar = false;
        this.mOneScreenCount = 5;
        this.mIsAccessibilityEnable = false;
        this.mIsLayoutRtl = false;
        this.mZhTypeface = Typeface.create("sans-serif-medium", 0);
        this.mNumTpyeface = Typeface.create("DINPro-medium", 0);
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
        this.mStartYear = 1900;
        this.mEndYear = 2099;
        this.mHourTexts = new String[100];
        for (int i11 = 0; i11 < 100; i11++) {
            this.mHourTexts[i11] = String.valueOf(i11);
            if (i11 <= 9) {
                this.mHourTexts[i11] = "0" + this.mHourTexts[i11];
            }
        }
        this.mLeap = getResources().getString(R$string.mc_time_picker_leap);
        this.mMonthString = getResources().getString(R$string.mc_date_time_month);
        this.mDayString = getResources().getString(R$string.mc_date_time_day);
        this.mMinTexts = new String[100];
        for (int i12 = 0; i12 < 100; i12++) {
            this.mMinTexts[i12] = String.valueOf(i12);
            if (i12 <= 9) {
                this.mMinTexts[i12] = "0" + this.mMinTexts[i12];
            }
        }
        View.inflate(getContext(), R$layout.mc_date_picker_day_time_layout, this);
        TextView textView = (TextView) findViewById(R$id.mc_scroll_month_leap);
        this.mLeapMonthUnit = textView;
        if (textView != null) {
            textView.setText(this.mLeap);
            this.mLeapMonthUnit.setVisibility(8);
        }
        TextView textView2 = (TextView) findViewById(R$id.mc_scroll_hour_text);
        this.mHourUnit = textView2;
        if (textView2 != null) {
            textView2.setText(R$string.mc_date_time_hour);
        }
        TextView textView3 = (TextView) findViewById(R$id.mc_scroll_min_text);
        this.mMinUnit = textView3;
        if (textView3 != null) {
            textView3.setText(R$string.mc_date_time_min);
        }
        Calendar calendar = Calendar.getInstance();
        this.mYear = calendar.get(1);
        this.mMonth = calendar.get(2);
        this.mDay = calendar.get(5);
        this.mPickerHolder = (LinearLayout) findViewById(R$id.mc_column_parent);
        ScrollTextView scrollTextView = (ScrollTextView) findViewById(R$id.mc_scroll_day);
        this.mMonthDayPicker = scrollTextView;
        scrollTextView.setTypeface(this.mZhTypeface);
        if (this.mSelectItemHeight != 0.0f) {
            if (this.mNormalItemHeight != 0.0f) {
                this.mMonthDayPicker.a0((int) r5, (int) r10);
            }
        }
        I();
        ScrollTextView scrollTextView2 = (ScrollTextView) findViewById(R$id.mc_scroll_hour);
        this.mHourPicker = scrollTextView2;
        scrollTextView2.setTypeface(this.mNumTpyeface);
        if (this.mSelectItemHeight != 0.0f) {
            if (this.mNormalItemHeight != 0.0f) {
                this.mHourPicker.a0((int) r5, (int) r10);
            }
        }
        this.mHourPicker.Z(new d(4), -1.0f, this.mHour, 24, this.mOneScreenCount, 0, 23, true);
        ScrollTextView scrollTextView3 = (ScrollTextView) findViewById(R$id.mc_scroll_min);
        this.mMinPicker = scrollTextView3;
        if (this.mSelectItemHeight != 0.0f) {
            if (this.mNormalItemHeight != 0.0f) {
                scrollTextView3.a0((int) r10, (int) r11);
            }
        }
        this.mMinPicker.Z(new d(5), -1.0f, this.mMin, 60, this.mOneScreenCount, 0, 59, true);
        H();
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
        w();
        int paddingTop = this.mHourUnit.getPaddingTop();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        displayMetrics.setToDefaults();
        float f10 = displayMetrics.scaledDensity;
        float f11 = getResources().getDisplayMetrics().scaledDensity;
        float textSize = ((this.mHourUnit.getTextSize() / f11) * (f11 - f10)) / 1.3f;
        TextView textView4 = this.mHourUnit;
        int i13 = (int) (paddingTop - textSize);
        textView4.setPadding(textView4.getPaddingLeft(), i13, this.mHourUnit.getPaddingRight(), this.mHourUnit.getPaddingBottom());
        TextView textView5 = this.mMinUnit;
        textView5.setPadding(textView5.getPaddingLeft(), i13, this.mMinUnit.getPaddingRight(), this.mMinUnit.getPaddingBottom());
        if (!isEnabled()) {
            setEnabled(false);
        }
        this.mLineOneHeight = 0;
        this.mLineTwoHeight = 0;
        this.mWidthPadding = context.getResources().getDimensionPixelSize(R$dimen.mc_custom_time_picker_line_width_padding);
        this.mLinePaint = new Paint();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(R$styleable.StepOSTheme);
        int i14 = typedArrayObtainStyledAttributes.getInt(R$styleable.StepOSTheme_steposThemeColor, context.getResources().getColor(R$color.mc_custom_date_picker_selected_gregorian_color));
        typedArrayObtainStyledAttributes.recycle();
        this.mLinePaint.setColor(i14);
        this.mLinePaint.setAntiAlias(true);
        this.mLinePaint.setStrokeWidth(context.getResources().getDimensionPixelSize(R$dimen.mc_custom_time_picker_line_stroke_width));
        this.mIsDrawLine = false;
        setWillNotDraw(false);
        this.mLunarMouths = getResources().getStringArray(R$array.mc_custom_time_picker_lunar_month);
        this.mLunardays = getResources().getStringArray(R$array.mc_custom_time_picker_lunar_day);
        this.mGregorianDays = new String[100];
        for (int i15 = 0; i15 < 100; i15++) {
            this.mGregorianDays[i15] = String.valueOf(i15);
            if (G()) {
                this.mGregorianDays[i15] = String.valueOf(i15);
            }
            if (i15 <= 9) {
                this.mGregorianDays[i15] = "0" + this.mGregorianDays[i15];
            }
        }
        if (Build.DEVICE.equals("mx4pro")) {
            this.mMinPicker.v(new a());
            this.mHourPicker.v(new b());
            this.mMonthDayPicker.v(new c());
        }
        AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
        if (accessibilityManager != null) {
            this.mIsAccessibilityEnable = accessibilityManager.isEnabled();
        }
    }
}
