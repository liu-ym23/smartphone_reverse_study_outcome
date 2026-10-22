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
import androidx.appcompat.app.C0186l;
import com.stepos.alphame.R;
import i2.AbstractC0620a;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

/* loaded from: classes.dex */
public class DayTimeDatePicker extends FrameLayout {

    /* renamed from: L, reason: collision with root package name */
    public static final /* synthetic */ int f11564L = 0;

    /* renamed from: A, reason: collision with root package name */
    public final Paint f11565A;

    /* renamed from: B, reason: collision with root package name */
    public boolean f11566B;

    /* renamed from: C, reason: collision with root package name */
    public final boolean f11567C;

    /* renamed from: D, reason: collision with root package name */
    public final String[] f11568D;

    /* renamed from: E, reason: collision with root package name */
    public final String[] f11569E;

    /* renamed from: F, reason: collision with root package name */
    public final String f11570F;

    /* renamed from: G, reason: collision with root package name */
    public final Typeface f11571G;

    /* renamed from: H, reason: collision with root package name */
    public final Typeface f11572H;

    /* renamed from: I, reason: collision with root package name */
    public final String[] f11573I;

    /* renamed from: J, reason: collision with root package name */
    public final String f11574J;

    /* renamed from: K, reason: collision with root package name */
    public final String f11575K;

    /* renamed from: a, reason: collision with root package name */
    public final TextView f11576a;

    /* renamed from: b, reason: collision with root package name */
    public final TextView f11577b;

    /* renamed from: c, reason: collision with root package name */
    public final TextView f11578c;

    /* renamed from: d, reason: collision with root package name */
    public final ScrollTextView f11579d;

    /* renamed from: e, reason: collision with root package name */
    public final ScrollTextView f11580e;

    /* renamed from: f, reason: collision with root package name */
    public final ScrollTextView f11581f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f11582g;

    /* renamed from: h, reason: collision with root package name */
    public int f11583h;

    /* renamed from: i, reason: collision with root package name */
    public int f11584i;

    /* renamed from: j, reason: collision with root package name */
    public int f11585j;

    /* renamed from: k, reason: collision with root package name */
    public int f11586k;

    /* renamed from: l, reason: collision with root package name */
    public int f11587l;

    /* renamed from: m, reason: collision with root package name */
    public final int f11588m;

    /* renamed from: n, reason: collision with root package name */
    public final int f11589n;

    /* renamed from: o, reason: collision with root package name */
    public final Calendar f11590o;

    /* renamed from: p, reason: collision with root package name */
    public final Calendar f11591p;

    /* renamed from: q, reason: collision with root package name */
    public final String[] f11592q;

    /* renamed from: r, reason: collision with root package name */
    public final String[] f11593r;

    /* renamed from: s, reason: collision with root package name */
    public final int f11594s;

    /* renamed from: t, reason: collision with root package name */
    public int f11595t;

    /* renamed from: u, reason: collision with root package name */
    public final int f11596u;

    /* renamed from: v, reason: collision with root package name */
    public final ArrayList f11597v;

    /* renamed from: w, reason: collision with root package name */
    public final int f11598w;

    /* renamed from: x, reason: collision with root package name */
    public final ArrayList f11599x;

    /* renamed from: y, reason: collision with root package name */
    public final LinearLayout f11600y;

    /* renamed from: z, reason: collision with root package name */
    public final int f11601z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DayTimeDatePicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        int i4 = 0;
        this.f11582g = false;
        int i5 = 5;
        this.f11594s = 5;
        this.f11567C = false;
        this.f11571G = Typeface.create("sans-serif-medium", 0);
        this.f11572H = Typeface.create("DINPro-medium", 0);
        ArrayList arrayList = new ArrayList();
        this.f11597v = arrayList;
        arrayList.add(Float.valueOf(context.getResources().getDimension(R.dimen.mc_picker_normal_word_size_one)));
        arrayList.add(Float.valueOf(context.getResources().getDimension(R.dimen.mc_picker_normal_word_size_two)));
        this.f11596u = context.getResources().getDimensionPixelOffset(R.dimen.mc_picker_selected_word_size);
        ArrayList arrayList2 = new ArrayList();
        this.f11599x = arrayList2;
        arrayList2.add(Float.valueOf(context.getResources().getDimension(R.dimen.mc_picker_normal_number_size_one)));
        arrayList2.add(Float.valueOf(context.getResources().getDimension(R.dimen.mc_picker_normal_number_size_two)));
        this.f11598w = Math.min(getContext().getResources().getDimensionPixelOffset(R.dimen.mc_picker_selected_number_max_size), getContext().getResources().getDimensionPixelOffset(R.dimen.mc_picker_selected_number_size));
        this.f11588m = 1900;
        this.f11589n = 2099;
        this.f11592q = new String[100];
        for (int i6 = 0; i6 < 100; i6++) {
            this.f11592q[i6] = String.valueOf(i6);
            if (i6 <= 9) {
                this.f11592q[i6] = "0" + this.f11592q[i6];
            }
        }
        this.f11570F = getResources().getString(R.string.mc_time_picker_leap);
        this.f11574J = getResources().getString(R.string.mc_date_time_month);
        this.f11575K = getResources().getString(R.string.mc_date_time_day);
        this.f11593r = new String[100];
        for (int i7 = 0; i7 < 100; i7++) {
            this.f11593r[i7] = String.valueOf(i7);
            if (i7 <= 9) {
                this.f11593r[i7] = "0" + this.f11593r[i7];
            }
        }
        View.inflate(getContext(), R.layout.mc_date_picker_day_time_layout, this);
        TextView textView = (TextView) findViewById(R.id.mc_scroll_month_leap);
        this.f11578c = textView;
        if (textView != null) {
            textView.setText(this.f11570F);
            textView.setVisibility(8);
        }
        TextView textView2 = (TextView) findViewById(R.id.mc_scroll_hour_text);
        this.f11577b = textView2;
        if (textView2 != null) {
            textView2.setText(R.string.mc_date_time_hour);
        }
        TextView textView3 = (TextView) findViewById(R.id.mc_scroll_min_text);
        this.f11576a = textView3;
        if (textView3 != null) {
            textView3.setText(R.string.mc_date_time_min);
        }
        Calendar calendar = Calendar.getInstance();
        int i8 = 1;
        this.f11585j = calendar.get(1);
        this.f11584i = calendar.get(2);
        this.f11583h = calendar.get(5);
        this.f11600y = (LinearLayout) findViewById(R.id.mc_column_parent);
        ScrollTextView scrollTextView = (ScrollTextView) findViewById(R.id.mc_scroll_day);
        this.f11581f = scrollTextView;
        scrollTextView.setTypeface(this.f11571G);
        h();
        ScrollTextView scrollTextView2 = (ScrollTextView) findViewById(R.id.mc_scroll_hour);
        this.f11579d = scrollTextView2;
        scrollTextView2.setTypeface(this.f11572H);
        int i9 = 4;
        scrollTextView2.i(new C0186l(i9, i9, this), this.f11586k, 24, this.f11594s, 23, true);
        ScrollTextView scrollTextView3 = (ScrollTextView) findViewById(R.id.mc_scroll_min);
        this.f11580e = scrollTextView3;
        scrollTextView3.i(new C0186l(i5, i9, this), this.f11587l, 60, this.f11594s, 59, true);
        g();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Calendar calendar2 = Calendar.getInstance();
            this.f11590o = calendar2;
            calendar2.setTime(simpleDateFormat.parse(this.f11588m + "-01-01"));
        } catch (ParseException e4) {
            e4.printStackTrace();
        }
        try {
            Calendar calendar3 = Calendar.getInstance();
            this.f11591p = calendar3;
            calendar3.setTime(simpleDateFormat.parse(this.f11589n + "-12-31"));
        } catch (ParseException e5) {
            e5.printStackTrace();
        }
        TextView textView4 = (TextView) findViewById(R.id.mc_scroll_hour_text);
        this.f11577b = textView4;
        if (textView4 != null) {
            textView4.setText(R.string.mc_date_time_hour);
        }
        TextView textView5 = (TextView) findViewById(R.id.mc_scroll_min_text);
        this.f11576a = textView5;
        if (textView5 != null) {
            textView5.setText(R.string.mc_date_time_min);
        }
        int paddingTop = this.f11577b.getPaddingTop();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        displayMetrics.setToDefaults();
        float f4 = displayMetrics.scaledDensity;
        float f5 = getResources().getDisplayMetrics().scaledDensity;
        float textSize = ((f5 - f4) * (this.f11577b.getTextSize() / f5)) / 1.3f;
        TextView textView6 = this.f11577b;
        int i10 = (int) (paddingTop - textSize);
        textView6.setPadding(textView6.getPaddingLeft(), i10, this.f11577b.getPaddingRight(), this.f11577b.getPaddingBottom());
        TextView textView7 = this.f11576a;
        textView7.setPadding(textView7.getPaddingLeft(), i10, this.f11576a.getPaddingRight(), this.f11576a.getPaddingBottom());
        if (!isEnabled()) {
            setEnabled(false);
        }
        this.f11601z = context.getResources().getDimensionPixelSize(R.dimen.mc_custom_time_picker_line_width_padding);
        Paint paint = new Paint();
        this.f11565A = paint;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(AbstractC0620a.f13037s);
        int i11 = typedArrayObtainStyledAttributes.getInt(11, context.getResources().getColor(R.color.mc_custom_date_picker_selected_gregorian_color));
        typedArrayObtainStyledAttributes.recycle();
        paint.setColor(i11);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(context.getResources().getDimensionPixelSize(R.dimen.mc_custom_time_picker_line_stroke_width));
        this.f11566B = false;
        setWillNotDraw(false);
        this.f11568D = getResources().getStringArray(R.array.mc_custom_time_picker_lunar_month);
        this.f11569E = getResources().getStringArray(R.array.mc_custom_time_picker_lunar_day);
        this.f11573I = new String[100];
        for (int i12 = 0; i12 < 100; i12++) {
            this.f11573I[i12] = String.valueOf(i12);
            if (f()) {
                this.f11573I[i12] = String.valueOf(i12);
            }
            if (i12 <= 9) {
                this.f11573I[i12] = "0" + this.f11573I[i12];
            }
        }
        if (Build.DEVICE.equals("mx4pro")) {
            this.f11580e.d(new C0497m(this, i4));
            this.f11579d.d(new C0497m(this, i8));
            this.f11581f.d(new C0497m(this, 2));
        }
        AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
        if (accessibilityManager != null) {
            this.f11567C = accessibilityManager.isEnabled();
        }
    }

    public static int a(DayTimeDatePicker dayTimeDatePicker, int i4) {
        int twoMonthBeforeMonthDays = dayTimeDatePicker.getTwoMonthBeforeMonthDays();
        int oneMonthBeforeMonthDays = dayTimeDatePicker.getOneMonthBeforeMonthDays() + twoMonthBeforeMonthDays;
        int iC = dayTimeDatePicker.c(dayTimeDatePicker.f11585j, dayTimeDatePicker.f11584i) + oneMonthBeforeMonthDays;
        int oneMonthAfterMonthDays = dayTimeDatePicker.getOneMonthAfterMonthDays() + iC;
        int twoMonthAfterMonthDays = dayTimeDatePicker.getTwoMonthAfterMonthDays() + oneMonthAfterMonthDays;
        if (i4 < twoMonthBeforeMonthDays) {
            return dayTimeDatePicker.f11584i - 2;
        }
        if (i4 >= twoMonthBeforeMonthDays && i4 < oneMonthBeforeMonthDays) {
            return dayTimeDatePicker.f11584i - 1;
        }
        if (i4 >= oneMonthBeforeMonthDays && i4 < iC) {
            return dayTimeDatePicker.f11584i;
        }
        if (i4 >= iC && i4 < oneMonthAfterMonthDays) {
            return dayTimeDatePicker.f11584i + 1;
        }
        if (i4 < oneMonthAfterMonthDays || i4 >= twoMonthAfterMonthDays) {
            return 0;
        }
        return dayTimeDatePicker.f11584i + 2;
    }

    public static int b(DayTimeDatePicker dayTimeDatePicker, int i4) {
        int twoMonthBeforeMonthDays = dayTimeDatePicker.getTwoMonthBeforeMonthDays();
        int oneMonthBeforeMonthDays = dayTimeDatePicker.getOneMonthBeforeMonthDays() + twoMonthBeforeMonthDays;
        int iC = dayTimeDatePicker.c(dayTimeDatePicker.f11585j, dayTimeDatePicker.f11584i) + oneMonthBeforeMonthDays;
        int oneMonthAfterMonthDays = dayTimeDatePicker.getOneMonthAfterMonthDays() + iC;
        int twoMonthAfterMonthDays = dayTimeDatePicker.getTwoMonthAfterMonthDays() + oneMonthAfterMonthDays;
        if (i4 >= twoMonthBeforeMonthDays) {
            if (i4 >= twoMonthBeforeMonthDays && i4 < oneMonthBeforeMonthDays) {
                i4 -= twoMonthBeforeMonthDays;
            } else if (i4 >= oneMonthBeforeMonthDays && i4 < iC) {
                i4 -= oneMonthBeforeMonthDays;
            } else if (i4 >= iC && i4 < oneMonthAfterMonthDays) {
                i4 -= iC;
            } else {
                if (i4 < oneMonthAfterMonthDays || i4 >= twoMonthAfterMonthDays) {
                    return 1;
                }
                i4 -= oneMonthAfterMonthDays;
            }
        }
        return 1 + i4;
    }

    private Calendar getCurrentCalendar() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(5, 1);
        calendar.set(1, this.f11585j);
        calendar.set(2, this.f11584i);
        return calendar;
    }

    private int getDaysPosition() {
        return getTwoMonthBeforeMonthDays() + getOneMonthBeforeMonthDays() + this.f11583h;
    }

    private int getMonthDays() {
        if (!this.f11582g) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(5, 1);
            calendar.set(1, this.f11585j);
            calendar.set(2, this.f11584i);
            return calendar.getActualMaximum(5);
        }
        int i4 = this.f11584i;
        int iC = m2.d.c(this.f11585j);
        boolean z4 = false;
        if (iC != 0) {
            z4 = iC == i4;
        }
        if (iC == 0 || (iC != 0 && this.f11584i < iC)) {
            i4++;
        }
        return m2.d.b(this.f11585j, i4, z4);
    }

    private int getMonthDaysCount() {
        return c(this.f11585j, this.f11584i) + getTwoMonthBeforeMonthDays() + getOneMonthBeforeMonthDays() + getOneMonthAfterMonthDays() + getTwoMonthAfterMonthDays();
    }

    private int getOneMonthAfterMonthDays() {
        if (this.f11584i <= e(this.f11585j) - 2) {
            return c(this.f11585j, this.f11584i + 1);
        }
        int i4 = this.f11585j;
        return c(i4 + 1, (this.f11584i + 1) - e(i4));
    }

    private int getOneMonthBeforeMonthDays() {
        int i4 = this.f11584i;
        if (i4 >= 1) {
            return c(this.f11585j, i4 - 1);
        }
        int i5 = this.f11585j;
        return c(i5 - 1, e(i5 - 1) + (i4 - 1));
    }

    private int getTwoMonthAfterMonthDays() {
        if (this.f11584i <= e(this.f11585j) - 3) {
            return c(this.f11585j, this.f11584i + 2);
        }
        int i4 = this.f11585j;
        return c(i4 + 1, (this.f11584i + 2) - e(i4));
    }

    private int getTwoMonthBeforeMonthDays() {
        int i4 = this.f11584i;
        if (i4 >= 2) {
            return c(this.f11585j, i4 - 2);
        }
        int i5 = this.f11585j;
        return c(i5 - 1, e(i5 - 1) + (i4 - 2));
    }

    private void setDayRange(int i4) {
    }

    private void setLeapUnitVisibility(int i4) {
        int iC;
        boolean z4 = this.f11582g;
        TextView textView = this.f11578c;
        if (!z4 || !f() || ((iC = m2.d.c(this.f11585j)) != 0 ? i4 >= 13 : i4 >= 12) || iC == 0 || i4 <= iC - 1 || i4 != iC) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
    }

    private void setMonthRange(int i4) {
    }

    public final int c(int i4, int i5) {
        boolean z4 = false;
        Calendar calendar = this.f11591p;
        Calendar calendar2 = this.f11590o;
        if (calendar2 != null && calendar != null && ((calendar2.get(1) == i4 && calendar2.get(2) > i5) || calendar2.get(1) > i4 || ((calendar.get(1) == i4 && calendar.get(2) < i5) || calendar.get(1) < i4))) {
            return 0;
        }
        if (calendar2 != null && calendar2.get(1) == i4 && calendar2.get(2) == i5) {
            return calendar2.getActualMaximum(5) - calendar2.get(5);
        }
        if (calendar != null && calendar.get(1) == i4 && calendar.get(2) == i5) {
            if (!this.f11582g || calendar.get(5) <= 30) {
                return calendar.get(5);
            }
            return 30;
        }
        if (!this.f11582g) {
            Calendar calendar3 = Calendar.getInstance();
            calendar3.set(5, 1);
            calendar3.set(1, i4);
            calendar3.set(2, i5);
            return calendar3.getActualMaximum(5);
        }
        int iC = m2.d.c(i4);
        if (iC != 0 && iC == i5) {
            z4 = true;
        }
        if (iC == 0 || (iC != 0 && i5 < iC)) {
            i5++;
        }
        return m2.d.b(i4, i5, z4);
    }

    public final String d(int i4) {
        return i4 != 4 ? i4 != 5 ? "" : String.valueOf(this.f11587l) : String.valueOf(this.f11586k);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchRestoreInstanceState(SparseArray sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    public final int e(int i4) {
        return (!this.f11582g || m2.d.c(i4) == 0) ? 12 : 13;
    }

    public final boolean f() {
        return getResources().getConfiguration().locale.getLanguage().endsWith("zh");
    }

    public final void g() {
        boolean z4 = this.f11582g;
        Typeface typeface = this.f11572H;
        ArrayList arrayList = this.f11599x;
        int i4 = this.f11598w;
        ScrollTextView scrollTextView = this.f11581f;
        if (z4 && f()) {
            scrollTextView.n(this.f11596u, this.f11597v);
            scrollTextView.setTypeface(this.f11571G);
        } else {
            scrollTextView.n(i4, arrayList);
            scrollTextView.setTypeface(typeface);
        }
        float f4 = i4;
        ScrollTextView scrollTextView2 = this.f11579d;
        scrollTextView2.n(f4, arrayList);
        scrollTextView2.setTypeface(typeface);
        ScrollTextView scrollTextView3 = this.f11580e;
        scrollTextView3.n(f4, arrayList);
        scrollTextView3.setTypeface(typeface);
    }

    public int getCurrentHour() {
        return this.f11586k;
    }

    public Integer getCurrentMinute() {
        return Integer.valueOf(this.f11587l);
    }

    public int getDayOfMonth() {
        return this.f11583h;
    }

    public TextView getMinUnit() {
        return this.f11576a;
    }

    public int getMonth() {
        return this.f11584i;
    }

    public int getYear() {
        return this.f11585j;
    }

    public final void h() {
        int monthDaysCount = getMonthDaysCount();
        this.f11581f.i(new C0186l(6, 4, this), getDaysPosition() - 1, monthDaysCount, this.f11594s, monthDaysCount - 1, false);
    }

    public final void i(int i4, int i5, int i6, int i7, int i8, boolean z4) {
        int i9 = this.f11588m;
        if (i4 >= i9) {
            i9 = i4;
        }
        this.f11585j = i9;
        int i10 = this.f11589n;
        if (i4 > i10) {
            i4 = i10;
        }
        this.f11585j = i4;
        if (i5 > 11) {
            i5 = 11;
        }
        this.f11584i = i5;
        this.f11583h = i6;
        this.f11586k = i7;
        this.f11587l = i8;
        this.f11579d.h(i7, z4);
        this.f11580e.h(this.f11587l, z4);
        int i11 = this.f11595t;
        int monthDaysCount = getMonthDaysCount();
        ScrollTextView scrollTextView = this.f11581f;
        if (i11 != monthDaysCount) {
            int monthDaysCount2 = getMonthDaysCount();
            this.f11595t = monthDaysCount2;
            scrollTextView.f(monthDaysCount2);
        }
        scrollTextView.h(getDaysPosition() - 1, z4);
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f11566B) {
            int width = getWidth();
            int width2 = this.f11600y.getWidth() - (this.f11601z * 2);
            int i4 = (width - width2) / 2;
            float f4 = i4;
            float f5 = 0;
            float f6 = i4 + width2;
            Paint paint = this.f11565A;
            canvas.drawLine(f4, f5, f6, f5, paint);
            canvas.drawLine(f4, f5, f6, f5, paint);
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
        this.f11585j = savedState.f11602a;
        this.f11584i = savedState.f11603b;
        this.f11583h = savedState.f11604c;
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.f11585j, this.f11584i, this.f11583h);
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z4) {
        super.onWindowFocusChanged(z4);
    }

    public void setCurrentHour(Integer num) {
        if (num == null || num.intValue() == getCurrentHour()) {
            return;
        }
        i(this.f11585j, this.f11584i, this.f11583h, num.intValue(), this.f11587l, false);
    }

    public void setCurrentMinute(Integer num) {
        i(this.f11585j, this.f11584i, this.f11583h, getCurrentHour(), num.intValue(), false);
    }

    @Override // android.view.View
    public void setEnabled(boolean z4) {
        super.setEnabled(z4);
        this.f11581f.setEnabled(z4);
        this.f11579d.setEnabled(z4);
        this.f11580e.setEnabled(z4);
    }

    public void setIsDrawFading(boolean z4) {
        this.f11580e.setIsDrawFading(z4);
        this.f11579d.setIsDrawFading(z4);
        this.f11581f.setIsDrawFading(z4);
    }

    public void setIsDrawLine(boolean z4) {
        this.f11566B = z4;
    }

    public void setLunar(boolean z4) {
        int i4;
        boolean z5;
        int[] iArrD;
        int i5;
        this.f11582g = z4;
        int[] iArr = {this.f11585j, this.f11584i + 1, this.f11583h, 0};
        int i6 = iArr[0];
        int iC = m2.d.c(i6);
        int iC2 = m2.d.c(iArr[0] - 1);
        if (this.f11582g) {
            iArrD = m2.d.e(iArr[0], iArr[1], iArr[2]);
            int i7 = iArrD[0];
            if ((i6 != i7 && iC2 != 0 && (iArrD[3] == 1 || iArrD[1] > iC2)) || (i6 == i7 && iC != 0 && (iArrD[3] == 1 || iArrD[1] > iC))) {
                iArrD[1] = iArrD[1] + 1;
            }
        } else {
            if (iC == 0 || iC >= (i5 = iArr[1])) {
                i4 = iArr[1];
            } else {
                int i8 = iC + 1;
                if (i8 == i5) {
                    i4 = i5 - 1;
                    z5 = true;
                } else if (i8 < i5) {
                    i4 = i5 - 1;
                } else {
                    i4 = 0;
                    z5 = false;
                }
                iArrD = m2.d.d(iArr[0], i4, iArr[2], z5);
            }
            z5 = false;
            iArrD = m2.d.d(iArr[0], i4, iArr[2], z5);
        }
        g();
        int i9 = iArrD[0];
        int i10 = iArrD[1] - 1;
        if (i10 < 0) {
            i10 = 12;
        }
        i(i9, i10, iArrD[2], this.f11586k, this.f11587l, true);
        setLeapUnitVisibility(this.f11584i);
    }

    public void setOnTimeChangedListener(InterfaceC0498n interfaceC0498n) {
    }

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new o();

        /* renamed from: a, reason: collision with root package name */
        public final int f11602a;

        /* renamed from: b, reason: collision with root package name */
        public final int f11603b;

        /* renamed from: c, reason: collision with root package name */
        public final int f11604c;

        public SavedState(Parcelable parcelable, int i4, int i5, int i6) {
            super(parcelable);
            this.f11602a = i4;
            this.f11603b = i5;
            this.f11604c = i6;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i4) {
            super.writeToParcel(parcel, i4);
            parcel.writeInt(this.f11602a);
            parcel.writeInt(this.f11603b);
            parcel.writeInt(this.f11604c);
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f11602a = parcel.readInt();
            this.f11603b = parcel.readInt();
            this.f11604c = parcel.readInt();
        }
    }
}
