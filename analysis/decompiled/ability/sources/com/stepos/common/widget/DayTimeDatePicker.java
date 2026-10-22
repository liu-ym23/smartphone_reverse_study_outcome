package com.stepos.common.widget;

import a5.AbstractC0303c;
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
import com.stepos.ability.R;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

/* loaded from: classes3.dex */
public class DayTimeDatePicker extends FrameLayout {

    /* renamed from: P, reason: collision with root package name */
    public static final /* synthetic */ int f3685P = 0;

    /* renamed from: A, reason: collision with root package name */
    public final Paint f3686A;

    /* renamed from: B, reason: collision with root package name */
    public boolean f3687B;

    /* renamed from: C, reason: collision with root package name */
    public final boolean f3688C;

    /* renamed from: D, reason: collision with root package name */
    public final String[] f3689D;
    public final String[] E;

    /* renamed from: F, reason: collision with root package name */
    public final String f3690F;

    /* renamed from: G, reason: collision with root package name */
    public final Typeface f3691G;

    /* renamed from: L, reason: collision with root package name */
    public final Typeface f3692L;

    /* renamed from: M, reason: collision with root package name */
    public final String[] f3693M;

    /* renamed from: N, reason: collision with root package name */
    public final String f3694N;

    /* renamed from: O, reason: collision with root package name */
    public final String f3695O;

    /* renamed from: a, reason: collision with root package name */
    public final TextView f3696a;
    public final TextView b;
    public final TextView c;
    public final ScrollTextView d;
    public final ScrollTextView e;
    public final ScrollTextView f;
    public boolean g;
    public int h;
    public int i;

    /* renamed from: j, reason: collision with root package name */
    public int f3697j;
    public int k;
    public int l;
    public final int m;
    public final int n;
    public final Calendar o;
    public final Calendar p;

    /* renamed from: q, reason: collision with root package name */
    public final String[] f3698q;

    /* renamed from: r, reason: collision with root package name */
    public final String[] f3699r;

    /* renamed from: s, reason: collision with root package name */
    public final int f3700s;

    /* renamed from: t, reason: collision with root package name */
    public int f3701t;
    public final int u;

    /* renamed from: v, reason: collision with root package name */
    public final ArrayList f3702v;

    /* renamed from: w, reason: collision with root package name */
    public final int f3703w;

    /* renamed from: x, reason: collision with root package name */
    public final ArrayList f3704x;
    public final LinearLayout y;

    /* renamed from: z, reason: collision with root package name */
    public final int f3705z;

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new C1113s();
        private final int mDay;
        private final int mMonth;
        private final int mYear;

        public /* synthetic */ SavedState(Parcel parcel, C1112q c1112q) {
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
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.mYear);
            parcel.writeInt(this.mMonth);
            parcel.writeInt(this.mDay);
        }

        public /* synthetic */ SavedState(Parcelable parcelable, int i, int i6, int i10, C1112q c1112q) {
            this(parcelable, i, i6, i10);
        }

        private SavedState(Parcelable parcelable, int i, int i6, int i10) {
            super(parcelable);
            this.mYear = i;
            this.mMonth = i6;
            this.mDay = i10;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.mYear = parcel.readInt();
            this.mMonth = parcel.readInt();
            this.mDay = parcel.readInt();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DayTimeDatePicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.g = false;
        int i = 5;
        this.f3700s = 5;
        this.f3688C = false;
        this.f3691G = Typeface.create("sans-serif-medium", 0);
        this.f3692L = Typeface.create("DINPro-medium", 0);
        ArrayList arrayList = new ArrayList();
        this.f3702v = arrayList;
        arrayList.add(Float.valueOf(context.getResources().getDimension(R.dimen.mc_picker_normal_word_size_one)));
        arrayList.add(Float.valueOf(context.getResources().getDimension(R.dimen.mc_picker_normal_word_size_two)));
        this.u = context.getResources().getDimensionPixelOffset(R.dimen.mc_picker_selected_word_size);
        ArrayList arrayList2 = new ArrayList();
        this.f3704x = arrayList2;
        arrayList2.add(Float.valueOf(context.getResources().getDimension(R.dimen.mc_picker_normal_number_size_one)));
        arrayList2.add(Float.valueOf(context.getResources().getDimension(R.dimen.mc_picker_normal_number_size_two)));
        this.f3703w = Math.min(getContext().getResources().getDimensionPixelOffset(R.dimen.mc_picker_selected_number_max_size), getContext().getResources().getDimensionPixelOffset(R.dimen.mc_picker_selected_number_size));
        this.m = 1900;
        this.n = 2099;
        this.f3698q = new String[100];
        for (int i6 = 0; i6 < 100; i6++) {
            this.f3698q[i6] = String.valueOf(i6);
            if (i6 <= 9) {
                this.f3698q[i6] = "0" + this.f3698q[i6];
            }
        }
        this.f3690F = getResources().getString(R.string.mc_time_picker_leap);
        this.f3694N = getResources().getString(R.string.mc_date_time_month);
        this.f3695O = getResources().getString(R.string.mc_date_time_day);
        this.f3699r = new String[100];
        for (int i10 = 0; i10 < 100; i10++) {
            this.f3699r[i10] = String.valueOf(i10);
            if (i10 <= 9) {
                this.f3699r[i10] = "0" + this.f3699r[i10];
            }
        }
        View.inflate(getContext(), R.layout.mc_date_picker_day_time_layout, this);
        TextView textView = (TextView) findViewById(R.id.mc_scroll_month_leap);
        this.c = textView;
        if (textView != null) {
            textView.setText(this.f3690F);
            textView.setVisibility(8);
        }
        TextView textView2 = (TextView) findViewById(R.id.mc_scroll_hour_text);
        this.b = textView2;
        if (textView2 != null) {
            textView2.setText(R.string.mc_date_time_hour);
        }
        TextView textView3 = (TextView) findViewById(R.id.mc_scroll_min_text);
        this.f3696a = textView3;
        if (textView3 != null) {
            textView3.setText(R.string.mc_date_time_min);
        }
        Calendar calendar = Calendar.getInstance();
        this.f3697j = calendar.get(1);
        this.i = calendar.get(2);
        this.h = calendar.get(5);
        this.y = (LinearLayout) findViewById(R.id.mc_column_parent);
        ScrollTextView scrollTextView = (ScrollTextView) findViewById(R.id.mc_scroll_day);
        this.f = scrollTextView;
        scrollTextView.setTypeface(this.f3691G);
        g();
        ScrollTextView scrollTextView2 = (ScrollTextView) findViewById(R.id.mc_scroll_hour);
        this.d = scrollTextView2;
        scrollTextView2.setTypeface(this.f3692L);
        scrollTextView2.i(new B1.b(this, 4, 8), this.k, 24, this.f3700s, 23, true);
        ScrollTextView scrollTextView3 = (ScrollTextView) findViewById(R.id.mc_scroll_min);
        this.e = scrollTextView3;
        scrollTextView3.i(new B1.b(this, i, 8), this.l, 60, this.f3700s, 59, true);
        f();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Calendar calendar2 = Calendar.getInstance();
            this.o = calendar2;
            calendar2.setTime(simpleDateFormat.parse(this.m + "-01-01"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            Calendar calendar3 = Calendar.getInstance();
            this.p = calendar3;
            calendar3.setTime(simpleDateFormat.parse(this.n + "-12-31"));
        } catch (ParseException e6) {
            e6.printStackTrace();
        }
        TextView textView4 = (TextView) findViewById(R.id.mc_scroll_hour_text);
        this.b = textView4;
        if (textView4 != null) {
            textView4.setText(R.string.mc_date_time_hour);
        }
        TextView textView5 = (TextView) findViewById(R.id.mc_scroll_min_text);
        this.f3696a = textView5;
        if (textView5 != null) {
            textView5.setText(R.string.mc_date_time_min);
        }
        int paddingTop = this.b.getPaddingTop();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        displayMetrics.setToDefaults();
        float f = displayMetrics.scaledDensity;
        float f7 = getResources().getDisplayMetrics().scaledDensity;
        float textSize = ((f7 - f) * (this.b.getTextSize() / f7)) / 1.3f;
        TextView textView6 = this.b;
        int i11 = (int) (paddingTop - textSize);
        textView6.setPadding(textView6.getPaddingLeft(), i11, this.b.getPaddingRight(), this.b.getPaddingBottom());
        TextView textView7 = this.f3696a;
        textView7.setPadding(textView7.getPaddingLeft(), i11, this.f3696a.getPaddingRight(), this.f3696a.getPaddingBottom());
        if (!isEnabled()) {
            setEnabled(false);
        }
        this.f3705z = context.getResources().getDimensionPixelSize(R.dimen.mc_custom_time_picker_line_width_padding);
        Paint paint = new Paint();
        this.f3686A = paint;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(V4.s.f1375s);
        int i12 = typedArrayObtainStyledAttributes.getInt(11, context.getResources().getColor(R.color.mc_custom_date_picker_selected_gregorian_color));
        typedArrayObtainStyledAttributes.recycle();
        paint.setColor(i12);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(context.getResources().getDimensionPixelSize(R.dimen.mc_custom_time_picker_line_stroke_width));
        this.f3687B = false;
        setWillNotDraw(false);
        this.f3689D = getResources().getStringArray(R.array.mc_custom_time_picker_lunar_month);
        this.E = getResources().getStringArray(R.array.mc_custom_time_picker_lunar_day);
        this.f3693M = new String[100];
        for (int i13 = 0; i13 < 100; i13++) {
            this.f3693M[i13] = String.valueOf(i13);
            if (e()) {
                this.f3693M[i13] = String.valueOf(i13);
            }
            if (i13 <= 9) {
                this.f3693M[i13] = "0" + this.f3693M[i13];
            }
        }
        if (Build.DEVICE.equals("mx4pro")) {
            this.e.d(new C1112q());
            int i14 = 1;
            this.d.d(new C1109n(i14));
            this.f.d(new C1110o(this, i14));
        }
        AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
        if (accessibilityManager != null) {
            this.f3688C = accessibilityManager.isEnabled();
        }
    }

    public static int a(DayTimeDatePicker dayTimeDatePicker, int i) {
        int twoMonthBeforeMonthDays = dayTimeDatePicker.getTwoMonthBeforeMonthDays();
        int oneMonthBeforeMonthDays = dayTimeDatePicker.getOneMonthBeforeMonthDays() + twoMonthBeforeMonthDays;
        int iC = dayTimeDatePicker.c(dayTimeDatePicker.f3697j, dayTimeDatePicker.i) + oneMonthBeforeMonthDays;
        int oneMonthAfterMonthDays = dayTimeDatePicker.getOneMonthAfterMonthDays() + iC;
        int twoMonthAfterMonthDays = dayTimeDatePicker.getTwoMonthAfterMonthDays() + oneMonthAfterMonthDays;
        if (i < twoMonthBeforeMonthDays) {
            return dayTimeDatePicker.i - 2;
        }
        if (i >= twoMonthBeforeMonthDays && i < oneMonthBeforeMonthDays) {
            return dayTimeDatePicker.i - 1;
        }
        if (i >= oneMonthBeforeMonthDays && i < iC) {
            return dayTimeDatePicker.i;
        }
        if (i >= iC && i < oneMonthAfterMonthDays) {
            return dayTimeDatePicker.i + 1;
        }
        if (i < oneMonthAfterMonthDays || i >= twoMonthAfterMonthDays) {
            return 0;
        }
        return dayTimeDatePicker.i + 2;
    }

    public static int b(DayTimeDatePicker dayTimeDatePicker, int i) {
        int i6;
        int twoMonthBeforeMonthDays = dayTimeDatePicker.getTwoMonthBeforeMonthDays();
        int oneMonthBeforeMonthDays = dayTimeDatePicker.getOneMonthBeforeMonthDays() + twoMonthBeforeMonthDays;
        int iC = dayTimeDatePicker.c(dayTimeDatePicker.f3697j, dayTimeDatePicker.i) + oneMonthBeforeMonthDays;
        int oneMonthAfterMonthDays = dayTimeDatePicker.getOneMonthAfterMonthDays() + iC;
        int twoMonthAfterMonthDays = dayTimeDatePicker.getTwoMonthAfterMonthDays() + oneMonthAfterMonthDays;
        if (i < twoMonthBeforeMonthDays) {
            return i + 1;
        }
        if (i >= twoMonthBeforeMonthDays && i < oneMonthBeforeMonthDays) {
            i6 = i - twoMonthBeforeMonthDays;
        } else if (i >= oneMonthBeforeMonthDays && i < iC) {
            i6 = i - oneMonthBeforeMonthDays;
        } else if (i >= iC && i < oneMonthAfterMonthDays) {
            i6 = i - iC;
        } else {
            if (i < oneMonthAfterMonthDays || i >= twoMonthAfterMonthDays) {
                return 1;
            }
            i6 = i - oneMonthAfterMonthDays;
        }
        return i6 + 1;
    }

    private Calendar getCurrentCalendar() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(5, 1);
        calendar.set(1, this.f3697j);
        calendar.set(2, this.i);
        return calendar;
    }

    private int getDaysPosition() {
        return getTwoMonthBeforeMonthDays() + getOneMonthBeforeMonthDays() + this.h;
    }

    private int getMonthDays() {
        if (!this.g) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(5, 1);
            calendar.set(1, this.f3697j);
            calendar.set(2, this.i);
            return calendar.getActualMaximum(5);
        }
        int i = this.i;
        int iC = AbstractC0303c.c(this.f3697j);
        boolean z10 = false;
        if (iC != 0) {
            z10 = iC == i;
        }
        if (iC == 0 || (iC != 0 && this.i < iC)) {
            i++;
        }
        return AbstractC0303c.b(this.f3697j, i, z10);
    }

    private int getMonthDaysCount() {
        return c(this.f3697j, this.i) + getTwoMonthBeforeMonthDays() + getOneMonthBeforeMonthDays() + getOneMonthAfterMonthDays() + getTwoMonthAfterMonthDays();
    }

    private int getOneMonthAfterMonthDays() {
        if (this.i <= d(this.f3697j) - 2) {
            return c(this.f3697j, this.i + 1);
        }
        int i = this.f3697j;
        return c(i + 1, (this.i + 1) - d(i));
    }

    private int getOneMonthBeforeMonthDays() {
        int i = this.i;
        if (i >= 1) {
            return c(this.f3697j, i - 1);
        }
        int i6 = this.f3697j;
        return c(i6 - 1, d(i6 - 1) + (i - 1));
    }

    private int getTwoMonthAfterMonthDays() {
        if (this.i <= d(this.f3697j) - 3) {
            return c(this.f3697j, this.i + 2);
        }
        int i = this.f3697j;
        return c(i + 1, (this.i + 2) - d(i));
    }

    private int getTwoMonthBeforeMonthDays() {
        int i = this.i;
        if (i >= 2) {
            return c(this.f3697j, i - 2);
        }
        int i6 = this.f3697j;
        return c(i6 - 1, d(i6 - 1) + (i - 2));
    }

    private void setDayRange(int i) {
    }

    private void setLeapUnitVisibility(int i) {
        int iC;
        boolean z10 = this.g;
        TextView textView = this.c;
        if (!z10 || !e() || ((iC = AbstractC0303c.c(this.f3697j)) != 0 ? i >= 13 : i >= 12) || iC == 0 || i <= iC - 1 || i != iC) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
    }

    private void setMonthRange(int i) {
    }

    public final int c(int i, int i6) {
        boolean z10 = false;
        Calendar calendar = this.p;
        Calendar calendar2 = this.o;
        if (calendar2 != null && calendar != null && ((calendar2.get(1) == i && calendar2.get(2) > i6) || calendar2.get(1) > i || ((calendar.get(1) == i && calendar.get(2) < i6) || calendar.get(1) < i))) {
            return 0;
        }
        if (calendar2 != null && calendar2.get(1) == i && calendar2.get(2) == i6) {
            return calendar2.getActualMaximum(5) - calendar2.get(5);
        }
        if (calendar != null && calendar.get(1) == i && calendar.get(2) == i6) {
            if (!this.g || calendar.get(5) <= 30) {
                return calendar.get(5);
            }
            return 30;
        }
        if (!this.g) {
            Calendar calendar3 = Calendar.getInstance();
            calendar3.set(5, 1);
            calendar3.set(1, i);
            calendar3.set(2, i6);
            return calendar3.getActualMaximum(5);
        }
        int iC = AbstractC0303c.c(i);
        if (iC != 0 && iC == i6) {
            z10 = true;
        }
        if (iC == 0 || (iC != 0 && i6 < iC)) {
            i6++;
        }
        return AbstractC0303c.b(i, i6, z10);
    }

    public final int d(int i) {
        return (!this.g || AbstractC0303c.c(i) == 0) ? 12 : 13;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchRestoreInstanceState(SparseArray sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    public final boolean e() {
        return getResources().getConfiguration().locale.getLanguage().endsWith("zh");
    }

    public final void f() {
        boolean z10 = this.g;
        Typeface typeface = this.f3692L;
        ArrayList arrayList = this.f3704x;
        int i = this.f3703w;
        ScrollTextView scrollTextView = this.f;
        if (z10 && e()) {
            scrollTextView.n(this.u, this.f3702v);
            scrollTextView.setTypeface(this.f3691G);
        } else {
            scrollTextView.n(i, arrayList);
            scrollTextView.setTypeface(typeface);
        }
        float f = i;
        ScrollTextView scrollTextView2 = this.d;
        scrollTextView2.n(f, arrayList);
        scrollTextView2.setTypeface(typeface);
        ScrollTextView scrollTextView3 = this.e;
        scrollTextView3.n(f, arrayList);
        scrollTextView3.setTypeface(typeface);
    }

    public final void g() {
        int monthDaysCount = getMonthDaysCount();
        this.f.i(new B1.b(this, 6, 8), getDaysPosition() - 1, monthDaysCount, this.f3700s, monthDaysCount - 1, false);
    }

    public int getCurrentHour() {
        return this.k;
    }

    public Integer getCurrentMinute() {
        return Integer.valueOf(this.l);
    }

    public int getDayOfMonth() {
        return this.h;
    }

    public TextView getMinUnit() {
        return this.f3696a;
    }

    public int getMonth() {
        return this.i;
    }

    public int getYear() {
        return this.f3697j;
    }

    public final void h(int i, int i6, boolean z10, int i10, int i11, int i12) {
        int i13 = this.m;
        if (i >= i13) {
            i13 = i;
        }
        this.f3697j = i13;
        int i14 = this.n;
        if (i > i14) {
            i = i14;
        }
        this.f3697j = i;
        if (i6 > 11) {
            i6 = 11;
        }
        this.i = i6;
        this.h = i10;
        this.k = i11;
        this.l = i12;
        this.d.h(i11, z10);
        this.e.h(this.l, z10);
        int i15 = this.f3701t;
        int monthDaysCount = getMonthDaysCount();
        ScrollTextView scrollTextView = this.f;
        if (i15 != monthDaysCount) {
            int monthDaysCount2 = getMonthDaysCount();
            this.f3701t = monthDaysCount2;
            scrollTextView.f(monthDaysCount2);
        }
        scrollTextView.h(getDaysPosition() - 1, z10);
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f3687B) {
            int width = getWidth();
            int width2 = this.y.getWidth() - (this.f3705z * 2);
            int i = (width - width2) / 2;
            float f = i;
            float f7 = 0;
            float f9 = i + width2;
            Paint paint = this.f3686A;
            canvas.drawLine(f, f7, f9, f7, paint);
            canvas.drawLine(f, f7, f9, f7, paint);
        }
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(DatePicker.class.getName());
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f3697j = savedState.getYear();
        this.i = savedState.getMonth();
        this.h = savedState.getDay();
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.f3697j, this.i, this.h, null);
    }

    public void setCurrentHour(Integer num) {
        if (num == null || num.intValue() == getCurrentHour()) {
            return;
        }
        h(this.f3697j, this.i, false, this.h, num.intValue(), this.l);
    }

    public void setCurrentMinute(Integer num) {
        h(this.f3697j, this.i, false, this.h, getCurrentHour(), num.intValue());
    }

    @Override // android.view.View
    public void setEnabled(boolean z10) {
        super.setEnabled(z10);
        this.f.setEnabled(z10);
        this.d.setEnabled(z10);
        this.e.setEnabled(z10);
    }

    public void setIsDrawFading(boolean z10) {
        this.e.setIsDrawFading(z10);
        this.d.setIsDrawFading(z10);
        this.f.setIsDrawFading(z10);
    }

    public void setIsDrawLine(boolean z10) {
        this.f3687B = z10;
    }

    public void setLunar(boolean z10) {
        int i;
        boolean z11;
        int[] iArrD;
        int i6;
        this.g = z10;
        int[] iArr = {this.f3697j, this.i + 1, this.h, 0};
        int i10 = iArr[0];
        int iC = AbstractC0303c.c(i10);
        int iC2 = AbstractC0303c.c(iArr[0] - 1);
        if (this.g) {
            iArrD = AbstractC0303c.e(iArr[0], iArr[1], iArr[2]);
            int i11 = iArrD[0];
            if ((i10 != i11 && iC2 != 0 && (iArrD[3] == 1 || iArrD[1] > iC2)) || (i10 == i11 && iC != 0 && (iArrD[3] == 1 || iArrD[1] > iC))) {
                iArrD[1] = iArrD[1] + 1;
            }
        } else {
            if (iC == 0 || iC >= (i6 = iArr[1])) {
                i = iArr[1];
            } else {
                int i12 = iC + 1;
                if (i12 == i6) {
                    i = i6 - 1;
                    z11 = true;
                } else if (i12 < i6) {
                    i = i6 - 1;
                } else {
                    i = 0;
                    z11 = false;
                }
                iArrD = AbstractC0303c.d(iArr[0], i, iArr[2], z11);
            }
            z11 = false;
            iArrD = AbstractC0303c.d(iArr[0], i, iArr[2], z11);
        }
        f();
        int i13 = iArrD[0];
        int i14 = iArrD[1] - 1;
        if (i14 < 0) {
            i14 = 12;
        }
        h(i13, i14, true, iArrD[2], this.k, this.l);
        setLeapUnitVisibility(this.i);
    }

    public void setOnTimeChangedListener(r rVar) {
    }
}
