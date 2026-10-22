package com.stepos.common.widget;

import android.content.Context;
import android.content.res.Resources;
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
import com.stepos.aiengine.R;
import com.stepos.common.widget.ScrollTextView;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class DayTimeDatePicker extends FrameLayout {
    public static final /* synthetic */ int O = 0;
    public final ArrayList A;
    public final LinearLayout B;
    public final int C;
    public final Paint D;
    public boolean E;
    public final boolean F;
    public final String[] G;
    public final String[] H;
    public final String I;
    public final Typeface J;
    public final Typeface K;
    public final String[] L;
    public final String M;
    public final String N;

    /* renamed from: a, reason: collision with root package name */
    public final TextView f6856a;

    /* renamed from: b, reason: collision with root package name */
    public final TextView f6857b;

    /* renamed from: c, reason: collision with root package name */
    public final TextView f6858c;

    /* renamed from: d, reason: collision with root package name */
    public final ScrollTextView f6859d;

    /* renamed from: e, reason: collision with root package name */
    public final ScrollTextView f6860e;
    public final ScrollTextView h;

    /* renamed from: j, reason: collision with root package name */
    public boolean f6861j;

    /* renamed from: k, reason: collision with root package name */
    public int f6862k;

    /* renamed from: l, reason: collision with root package name */
    public int f6863l;

    /* renamed from: m, reason: collision with root package name */
    public int f6864m;

    /* renamed from: n, reason: collision with root package name */
    public int f6865n;

    /* renamed from: o, reason: collision with root package name */
    public int f6866o;

    /* renamed from: p, reason: collision with root package name */
    public final int f6867p;

    /* renamed from: q, reason: collision with root package name */
    public final int f6868q;
    public final Calendar r;

    /* renamed from: s, reason: collision with root package name */
    public final Calendar f6869s;

    /* renamed from: t, reason: collision with root package name */
    public final String[] f6870t;

    /* renamed from: u, reason: collision with root package name */
    public final String[] f6871u;

    /* renamed from: v, reason: collision with root package name */
    public final int f6872v;

    /* renamed from: w, reason: collision with root package name */
    public int f6873w;

    /* renamed from: x, reason: collision with root package name */
    public final int f6874x;

    /* renamed from: y, reason: collision with root package name */
    public final ArrayList f6875y;
    public final int z;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        private final int mDay;
        private final int mMonth;
        private final int mYear;

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public class a implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            public final SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            public final SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        public /* synthetic */ SavedState(Parcel parcel, l lVar) {
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

        public /* synthetic */ SavedState(Parcelable parcelable, int i10, int i11, int i12, l lVar) {
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

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a implements ScrollTextView.e {

        /* renamed from: a, reason: collision with root package name */
        public final int f6876a;

        public a(int i10) {
            this.f6876a = i10;
        }

        @Override // com.stepos.common.widget.ScrollTextView.e
        public final String a(int i10) {
            String str;
            DayTimeDatePicker dayTimeDatePicker = DayTimeDatePicker.this;
            String str2 = dayTimeDatePicker.N;
            String[] strArr = dayTimeDatePicker.G;
            String[] strArr2 = dayTimeDatePicker.L;
            Calendar calendar = dayTimeDatePicker.r;
            String str3 = dayTimeDatePicker.M;
            int i11 = this.f6876a;
            if (i11 == 4) {
                return dayTimeDatePicker.f6870t[i10];
            }
            if (i11 == 5) {
                return dayTimeDatePicker.f6871u[i10];
            }
            if (i11 != 6) {
                return null;
            }
            if (!dayTimeDatePicker.f6861j) {
                int iA = DayTimeDatePicker.a(dayTimeDatePicker, i10);
                if (iA > dayTimeDatePicker.d(dayTimeDatePicker.f6864m) - 1) {
                    iA -= dayTimeDatePicker.d(dayTimeDatePicker.f6864m);
                } else if (iA < 0) {
                    iA += dayTimeDatePicker.d(dayTimeDatePicker.f6864m);
                }
                if (!dayTimeDatePicker.e()) {
                    return strArr[iA] + " " + strArr2[DayTimeDatePicker.b(dayTimeDatePicker, i10)];
                }
                int i12 = iA + 1;
                if (calendar != null && calendar.get(1) == dayTimeDatePicker.f6864m && calendar.get(2) == dayTimeDatePicker.f6863l) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(i12);
                    sb2.append(str3);
                    return ai.onnxruntime.a.o(sb2, strArr2[calendar.get(5) + (DayTimeDatePicker.b(dayTimeDatePicker, i10) - 1)], str2);
                }
                StringBuilder sb3 = new StringBuilder();
                sb3.append(i12);
                sb3.append(str3);
                return ai.onnxruntime.a.o(sb3, strArr2[DayTimeDatePicker.b(dayTimeDatePicker, i10)], str2);
            }
            int i13 = dayTimeDatePicker.f6864m;
            int iA2 = DayTimeDatePicker.a(dayTimeDatePicker, i10);
            if (iA2 > dayTimeDatePicker.d(i13) - 1) {
                iA2 -= dayTimeDatePicker.d(i13);
                i13++;
            } else if (iA2 < 0) {
                iA2 += dayTimeDatePicker.d(i13 - 1);
                i13--;
            }
            int length = iA2 + 1;
            int iC = l8.c.c(i13);
            if (iC == 0 || length <= iC) {
                if (iA2 >= strArr.length) {
                    length = strArr.length - 1;
                }
                str = strArr[length - 1];
            } else {
                str = strArr[iA2 - 1];
            }
            int iB = DayTimeDatePicker.b(dayTimeDatePicker, i10);
            StringBuilder sbB = v1.d.b(str);
            if (!dayTimeDatePicker.e()) {
                str3 = " ";
            }
            sbB.append(str3);
            int i14 = iB - 1;
            String[] strArr3 = dayTimeDatePicker.H;
            sbB.append(i14 <= strArr3.length - 1 ? strArr3[i14] : null);
            return sbB.toString();
        }

        @Override // com.stepos.common.widget.ScrollTextView.e
        public final void b(int i10) throws Resources.NotFoundException {
            View viewFindViewById;
            DayTimeDatePicker dayTimeDatePicker = DayTimeDatePicker.this;
            Calendar calendar = dayTimeDatePicker.r;
            int i11 = this.f6876a;
            if (i11 == 4) {
                dayTimeDatePicker.f6865n = i10;
            } else if (i11 == 5) {
                dayTimeDatePicker.f6866o = i10;
            } else {
                if (i11 != 6) {
                    return;
                }
                if (calendar != null && calendar.get(1) == dayTimeDatePicker.f6864m && calendar.get(2) == dayTimeDatePicker.f6863l) {
                    dayTimeDatePicker.f6862k = calendar.get(5) + i10;
                }
                int iA = DayTimeDatePicker.a(dayTimeDatePicker, i10);
                dayTimeDatePicker.f6862k = DayTimeDatePicker.b(dayTimeDatePicker, i10);
                dayTimeDatePicker.f6863l = iA;
                if (iA > dayTimeDatePicker.d(dayTimeDatePicker.f6864m) - 1) {
                    dayTimeDatePicker.f6863l -= dayTimeDatePicker.d(dayTimeDatePicker.f6864m);
                    dayTimeDatePicker.f6864m++;
                } else if (dayTimeDatePicker.f6863l < 0) {
                    dayTimeDatePicker.f6863l += dayTimeDatePicker.d(dayTimeDatePicker.f6864m - 1);
                    dayTimeDatePicker.f6864m--;
                }
                dayTimeDatePicker.g();
            }
            int i12 = DayTimeDatePicker.O;
            boolean z = dayTimeDatePicker.F;
            if (z) {
                if (z) {
                    View viewFindViewById2 = dayTimeDatePicker.findViewById(R.id.mc_column_min_Layout);
                    View viewFindViewById3 = dayTimeDatePicker.findViewById(R.id.mc_column_day_Layout);
                    View viewFindViewById4 = dayTimeDatePicker.findViewById(R.id.mc_column_hour_Layout);
                    String strReplace = ("" + String.valueOf(dayTimeDatePicker.f6865n) + ((Object) dayTimeDatePicker.f6857b.getText()) + String.valueOf(dayTimeDatePicker.f6866o) + ((Object) dayTimeDatePicker.f6856a.getText())).replace(" ", "").replace("廿十", "二十").replace("廿", "二十");
                    if (viewFindViewById2 != null) {
                        viewFindViewById2.setFocusable(true);
                        viewFindViewById2.setContentDescription("上下滚动设置分，当前日期是" + strReplace);
                    }
                    if (viewFindViewById3 != null) {
                        viewFindViewById3.setFocusable(true);
                        viewFindViewById3.setContentDescription("上下滚动设置日，当前日期是" + strReplace);
                    }
                    if (viewFindViewById4 != null) {
                        viewFindViewById4.setFocusable(true);
                        viewFindViewById4.setContentDescription("上下滚动设置时，当前日期是" + strReplace);
                    }
                }
                if (i11 == 5) {
                    View viewFindViewById5 = dayTimeDatePicker.findViewById(R.id.mc_column_min_Layout);
                    if (viewFindViewById5 != null) {
                        viewFindViewById5.sendAccessibilityEvent(4);
                        return;
                    }
                    return;
                }
                if (i11 == 4) {
                    View viewFindViewById6 = dayTimeDatePicker.findViewById(R.id.mc_column_hour_Layout);
                    if (viewFindViewById6 != null) {
                        viewFindViewById6.sendAccessibilityEvent(4);
                        return;
                    }
                    return;
                }
                if (i11 != 6 || (viewFindViewById = dayTimeDatePicker.findViewById(R.id.mc_column_day_Layout)) == null) {
                    return;
                }
                viewFindViewById.sendAccessibilityEvent(4);
            }
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface b {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DayTimeDatePicker(Context context, AttributeSet attributeSet) throws Resources.NotFoundException {
        super(context, attributeSet, 0);
        this.f6861j = false;
        this.f6872v = 5;
        this.F = false;
        this.J = Typeface.create("sans-serif-medium", 0);
        this.K = Typeface.create("DINPro-medium", 0);
        ArrayList arrayList = new ArrayList();
        this.f6875y = arrayList;
        arrayList.add(Float.valueOf(context.getResources().getDimension(R.dimen.mc_picker_normal_word_size_one)));
        arrayList.add(Float.valueOf(context.getResources().getDimension(R.dimen.mc_picker_normal_word_size_two)));
        this.f6874x = context.getResources().getDimensionPixelOffset(R.dimen.mc_picker_selected_word_size);
        ArrayList arrayList2 = new ArrayList();
        this.A = arrayList2;
        arrayList2.add(Float.valueOf(context.getResources().getDimension(R.dimen.mc_picker_normal_number_size_one)));
        arrayList2.add(Float.valueOf(context.getResources().getDimension(R.dimen.mc_picker_normal_number_size_two)));
        this.z = Math.min(getContext().getResources().getDimensionPixelOffset(R.dimen.mc_picker_selected_number_max_size), getContext().getResources().getDimensionPixelOffset(R.dimen.mc_picker_selected_number_size));
        this.f6867p = 1900;
        this.f6868q = 2099;
        this.f6870t = new String[100];
        for (int i10 = 0; i10 < 100; i10++) {
            this.f6870t[i10] = String.valueOf(i10);
            if (i10 <= 9) {
                this.f6870t[i10] = "0" + this.f6870t[i10];
            }
        }
        this.I = getResources().getString(R.string.mc_time_picker_leap);
        this.M = getResources().getString(R.string.mc_date_time_month);
        this.N = getResources().getString(R.string.mc_date_time_day);
        this.f6871u = new String[100];
        for (int i11 = 0; i11 < 100; i11++) {
            this.f6871u[i11] = String.valueOf(i11);
            if (i11 <= 9) {
                this.f6871u[i11] = "0" + this.f6871u[i11];
            }
        }
        FrameLayout.inflate(getContext(), R.layout.mc_date_picker_day_time_layout, this);
        TextView textView = (TextView) findViewById(R.id.mc_scroll_month_leap);
        this.f6858c = textView;
        if (textView != null) {
            textView.setText(this.I);
            textView.setVisibility(8);
        }
        TextView textView2 = (TextView) findViewById(R.id.mc_scroll_hour_text);
        this.f6857b = textView2;
        if (textView2 != null) {
            textView2.setText(R.string.mc_date_time_hour);
        }
        TextView textView3 = (TextView) findViewById(R.id.mc_scroll_min_text);
        this.f6856a = textView3;
        if (textView3 != null) {
            textView3.setText(R.string.mc_date_time_min);
        }
        Calendar calendar = Calendar.getInstance();
        this.f6864m = calendar.get(1);
        this.f6863l = calendar.get(2);
        this.f6862k = calendar.get(5);
        this.B = (LinearLayout) findViewById(R.id.mc_column_parent);
        ScrollTextView scrollTextView = (ScrollTextView) findViewById(R.id.mc_scroll_day);
        this.h = scrollTextView;
        scrollTextView.setTypeface(this.J);
        g();
        ScrollTextView scrollTextView2 = (ScrollTextView) findViewById(R.id.mc_scroll_hour);
        this.f6859d = scrollTextView2;
        scrollTextView2.setTypeface(this.K);
        scrollTextView2.i(new a(4), this.f6865n, 24, this.f6872v, 23, true);
        ScrollTextView scrollTextView3 = (ScrollTextView) findViewById(R.id.mc_scroll_min);
        this.f6860e = scrollTextView3;
        scrollTextView3.i(new a(5), this.f6866o, 60, this.f6872v, 59, true);
        f();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Calendar calendar2 = Calendar.getInstance();
            this.r = calendar2;
            calendar2.setTime(simpleDateFormat.parse(this.f6867p + "-01-01"));
        } catch (ParseException e10) {
            e10.printStackTrace();
        }
        try {
            Calendar calendar3 = Calendar.getInstance();
            this.f6869s = calendar3;
            calendar3.setTime(simpleDateFormat.parse(this.f6868q + "-12-31"));
        } catch (ParseException e11) {
            e11.printStackTrace();
        }
        TextView textView4 = (TextView) findViewById(R.id.mc_scroll_hour_text);
        this.f6857b = textView4;
        if (textView4 != null) {
            textView4.setText(R.string.mc_date_time_hour);
        }
        TextView textView5 = (TextView) findViewById(R.id.mc_scroll_min_text);
        this.f6856a = textView5;
        if (textView5 != null) {
            textView5.setText(R.string.mc_date_time_min);
        }
        int paddingTop = this.f6857b.getPaddingTop();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        displayMetrics.setToDefaults();
        float f8 = displayMetrics.scaledDensity;
        float f9 = getResources().getDisplayMetrics().scaledDensity;
        float textSize = ((f9 - f8) * (this.f6857b.getTextSize() / f9)) / 1.3f;
        TextView textView6 = this.f6857b;
        int i12 = (int) (paddingTop - textSize);
        textView6.setPadding(textView6.getPaddingLeft(), i12, this.f6857b.getPaddingRight(), this.f6857b.getPaddingBottom());
        TextView textView7 = this.f6856a;
        textView7.setPadding(textView7.getPaddingLeft(), i12, this.f6856a.getPaddingRight(), this.f6856a.getPaddingBottom());
        if (!isEnabled()) {
            setEnabled(false);
        }
        this.C = context.getResources().getDimensionPixelSize(R.dimen.mc_custom_time_picker_line_width_padding);
        Paint paint = new Paint();
        this.D = paint;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(g8.a.f9091s);
        int i13 = typedArrayObtainStyledAttributes.getInt(11, context.getResources().getColor(R.color.mc_custom_date_picker_selected_gregorian_color));
        typedArrayObtainStyledAttributes.recycle();
        paint.setColor(i13);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(context.getResources().getDimensionPixelSize(R.dimen.mc_custom_time_picker_line_stroke_width));
        this.E = false;
        setWillNotDraw(false);
        this.G = getResources().getStringArray(R.array.mc_custom_time_picker_lunar_month);
        this.H = getResources().getStringArray(R.array.mc_custom_time_picker_lunar_day);
        this.L = new String[100];
        for (int i14 = 0; i14 < 100; i14++) {
            this.L[i14] = String.valueOf(i14);
            if (e()) {
                this.L[i14] = String.valueOf(i14);
            }
            if (i14 <= 9) {
                this.L[i14] = "0" + this.L[i14];
            }
        }
        if (Build.DEVICE.equals("mx4pro")) {
            this.f6860e.d(new l());
            this.f6859d.d(new m());
            this.h.d(new n(this));
        }
        AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
        if (accessibilityManager != null) {
            this.F = accessibilityManager.isEnabled();
        }
    }

    public static int a(DayTimeDatePicker dayTimeDatePicker, int i10) {
        int twoMonthBeforeMonthDays = dayTimeDatePicker.getTwoMonthBeforeMonthDays();
        int oneMonthBeforeMonthDays = dayTimeDatePicker.getOneMonthBeforeMonthDays() + twoMonthBeforeMonthDays;
        int iC = dayTimeDatePicker.c(dayTimeDatePicker.f6864m, dayTimeDatePicker.f6863l) + oneMonthBeforeMonthDays;
        int oneMonthAfterMonthDays = dayTimeDatePicker.getOneMonthAfterMonthDays() + iC;
        int twoMonthAfterMonthDays = dayTimeDatePicker.getTwoMonthAfterMonthDays() + oneMonthAfterMonthDays;
        if (i10 < twoMonthBeforeMonthDays) {
            return dayTimeDatePicker.f6863l - 2;
        }
        if (i10 >= twoMonthBeforeMonthDays && i10 < oneMonthBeforeMonthDays) {
            return dayTimeDatePicker.f6863l - 1;
        }
        if (i10 >= oneMonthBeforeMonthDays && i10 < iC) {
            return dayTimeDatePicker.f6863l;
        }
        if (i10 >= iC && i10 < oneMonthAfterMonthDays) {
            return dayTimeDatePicker.f6863l + 1;
        }
        if (i10 < oneMonthAfterMonthDays || i10 >= twoMonthAfterMonthDays) {
            return 0;
        }
        return dayTimeDatePicker.f6863l + 2;
    }

    public static int b(DayTimeDatePicker dayTimeDatePicker, int i10) {
        int i11;
        int twoMonthBeforeMonthDays = dayTimeDatePicker.getTwoMonthBeforeMonthDays();
        int oneMonthBeforeMonthDays = dayTimeDatePicker.getOneMonthBeforeMonthDays() + twoMonthBeforeMonthDays;
        int iC = dayTimeDatePicker.c(dayTimeDatePicker.f6864m, dayTimeDatePicker.f6863l) + oneMonthBeforeMonthDays;
        int oneMonthAfterMonthDays = dayTimeDatePicker.getOneMonthAfterMonthDays() + iC;
        int twoMonthAfterMonthDays = dayTimeDatePicker.getTwoMonthAfterMonthDays() + oneMonthAfterMonthDays;
        if (i10 < twoMonthBeforeMonthDays) {
            return i10 + 1;
        }
        if (i10 >= twoMonthBeforeMonthDays && i10 < oneMonthBeforeMonthDays) {
            i11 = i10 - twoMonthBeforeMonthDays;
        } else if (i10 >= oneMonthBeforeMonthDays && i10 < iC) {
            i11 = i10 - oneMonthBeforeMonthDays;
        } else if (i10 >= iC && i10 < oneMonthAfterMonthDays) {
            i11 = i10 - iC;
        } else {
            if (i10 < oneMonthAfterMonthDays || i10 >= twoMonthAfterMonthDays) {
                return 1;
            }
            i11 = i10 - oneMonthAfterMonthDays;
        }
        return i11 + 1;
    }

    private Calendar getCurrentCalendar() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(5, 1);
        calendar.set(1, this.f6864m);
        calendar.set(2, this.f6863l);
        return calendar;
    }

    private int getDaysPosition() {
        return getTwoMonthBeforeMonthDays() + getOneMonthBeforeMonthDays() + this.f6862k;
    }

    private int getMonthDays() {
        if (!this.f6861j) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(5, 1);
            calendar.set(1, this.f6864m);
            calendar.set(2, this.f6863l);
            return calendar.getActualMaximum(5);
        }
        int i10 = this.f6863l;
        int iC = l8.c.c(this.f6864m);
        boolean z = false;
        if (iC != 0) {
            z = iC == i10;
        }
        if (iC == 0 || (iC != 0 && this.f6863l < iC)) {
            i10++;
        }
        return l8.c.b(this.f6864m, i10, z);
    }

    private int getMonthDaysCount() {
        return c(this.f6864m, this.f6863l) + getTwoMonthBeforeMonthDays() + getOneMonthBeforeMonthDays() + getOneMonthAfterMonthDays() + getTwoMonthAfterMonthDays();
    }

    private int getOneMonthAfterMonthDays() {
        if (this.f6863l <= d(this.f6864m) - 2) {
            return c(this.f6864m, this.f6863l + 1);
        }
        int i10 = this.f6864m;
        return c(i10 + 1, (this.f6863l + 1) - d(i10));
    }

    private int getOneMonthBeforeMonthDays() {
        int i10 = this.f6863l;
        if (i10 >= 1) {
            return c(this.f6864m, i10 - 1);
        }
        int i11 = this.f6864m;
        return c(i11 - 1, d(i11 - 1) + (i10 - 1));
    }

    private int getTwoMonthAfterMonthDays() {
        if (this.f6863l <= d(this.f6864m) - 3) {
            return c(this.f6864m, this.f6863l + 2);
        }
        int i10 = this.f6864m;
        return c(i10 + 1, (this.f6863l + 2) - d(i10));
    }

    private int getTwoMonthBeforeMonthDays() {
        int i10 = this.f6863l;
        if (i10 >= 2) {
            return c(this.f6864m, i10 - 2);
        }
        int i11 = this.f6864m;
        return c(i11 - 1, d(i11 - 1) + (i10 - 2));
    }

    private void setLeapUnitVisibility(int i10) {
        int iC;
        boolean z = this.f6861j;
        TextView textView = this.f6858c;
        if (!z || !e() || ((iC = l8.c.c(this.f6864m)) != 0 ? i10 >= 13 : i10 >= 12) || iC == 0 || i10 <= iC - 1 || i10 != iC) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
    }

    public final int c(int i10, int i11) {
        boolean z = false;
        Calendar calendar = this.f6869s;
        Calendar calendar2 = this.r;
        if (calendar2 != null && calendar != null && ((calendar2.get(1) == i10 && calendar2.get(2) > i11) || calendar2.get(1) > i10 || ((calendar.get(1) == i10 && calendar.get(2) < i11) || calendar.get(1) < i10))) {
            return 0;
        }
        if (calendar2 != null && calendar2.get(1) == i10 && calendar2.get(2) == i11) {
            return calendar2.getActualMaximum(5) - calendar2.get(5);
        }
        if (calendar != null && calendar.get(1) == i10 && calendar.get(2) == i11) {
            if (!this.f6861j) {
                return calendar.get(5);
            }
            if (calendar.get(5) > 30) {
                return 30;
            }
            return calendar.get(5);
        }
        if (!this.f6861j) {
            Calendar calendar3 = Calendar.getInstance();
            calendar3.set(5, 1);
            calendar3.set(1, i10);
            calendar3.set(2, i11);
            return calendar3.getActualMaximum(5);
        }
        int iC = l8.c.c(i10);
        if (iC != 0 && iC == i11) {
            z = true;
        }
        if (iC == 0 || (iC != 0 && i11 < iC)) {
            i11++;
        }
        return l8.c.b(i10, i11, z);
    }

    public final int d(int i10) {
        return (!this.f6861j || l8.c.c(i10) == 0) ? 12 : 13;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    public final boolean e() {
        return getResources().getConfiguration().locale.getLanguage().endsWith("zh");
    }

    public final void f() {
        boolean z = this.f6861j;
        Typeface typeface = this.K;
        ArrayList arrayList = this.A;
        int i10 = this.z;
        ScrollTextView scrollTextView = this.h;
        if (z && e()) {
            scrollTextView.n(this.f6874x, this.f6875y);
            scrollTextView.setTypeface(this.J);
        } else {
            scrollTextView.n(i10, arrayList);
            scrollTextView.setTypeface(typeface);
        }
        float f8 = i10;
        ScrollTextView scrollTextView2 = this.f6859d;
        scrollTextView2.n(f8, arrayList);
        scrollTextView2.setTypeface(typeface);
        ScrollTextView scrollTextView3 = this.f6860e;
        scrollTextView3.n(f8, arrayList);
        scrollTextView3.setTypeface(typeface);
    }

    public final void g() throws Resources.NotFoundException {
        int monthDaysCount = getMonthDaysCount();
        this.h.i(new a(6), getDaysPosition() - 1, monthDaysCount, this.f6872v, monthDaysCount - 1, false);
    }

    public int getCurrentHour() {
        return this.f6865n;
    }

    public Integer getCurrentMinute() {
        return Integer.valueOf(this.f6866o);
    }

    public int getDayOfMonth() {
        return this.f6862k;
    }

    public TextView getMinUnit() {
        return this.f6856a;
    }

    public int getMonth() {
        return this.f6863l;
    }

    public int getYear() {
        return this.f6864m;
    }

    public final void h(int i10, int i11, int i12, int i13, int i14, boolean z) {
        int i15 = this.f6867p;
        if (i10 >= i15) {
            i15 = i10;
        }
        this.f6864m = i15;
        int i16 = this.f6868q;
        if (i10 > i16) {
            i10 = i16;
        }
        this.f6864m = i10;
        if (i11 > 11) {
            i11 = 11;
        }
        this.f6863l = i11;
        this.f6862k = i12;
        this.f6865n = i13;
        this.f6866o = i14;
        this.f6859d.h(i13, z);
        this.f6860e.h(this.f6866o, z);
        int i17 = this.f6873w;
        int monthDaysCount = getMonthDaysCount();
        ScrollTextView scrollTextView = this.h;
        if (i17 != monthDaysCount) {
            int monthDaysCount2 = getMonthDaysCount();
            this.f6873w = monthDaysCount2;
            scrollTextView.f(monthDaysCount2);
        }
        scrollTextView.h(getDaysPosition() - 1, z);
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.E) {
            int width = getWidth();
            int width2 = this.B.getWidth() - (this.C * 2);
            int i10 = (width - width2) / 2;
            float f8 = i10;
            float f9 = 0;
            float f10 = i10 + width2;
            Paint paint = this.D;
            canvas.drawLine(f8, f9, f10, f9, paint);
            canvas.drawLine(f8, f9, f10, f9, paint);
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
        this.f6864m = savedState.getYear();
        this.f6863l = savedState.getMonth();
        this.f6862k = savedState.getDay();
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.f6864m, this.f6863l, this.f6862k, null);
    }

    public void setCurrentHour(Integer num) {
        if (num == null || num.intValue() == getCurrentHour()) {
            return;
        }
        h(this.f6864m, this.f6863l, this.f6862k, num.intValue(), this.f6866o, false);
    }

    public void setCurrentMinute(Integer num) {
        h(this.f6864m, this.f6863l, this.f6862k, getCurrentHour(), num.intValue(), false);
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.h.setEnabled(z);
        this.f6859d.setEnabled(z);
        this.f6860e.setEnabled(z);
    }

    public void setIsDrawFading(boolean z) {
        this.f6860e.setIsDrawFading(z);
        this.f6859d.setIsDrawFading(z);
        this.h.setIsDrawFading(z);
    }

    public void setIsDrawLine(boolean z) {
        this.E = z;
    }

    public void setLunar(boolean z) {
        int i10;
        boolean z3;
        int[] iArrD;
        int i11;
        this.f6861j = z;
        int[] iArr = {this.f6864m, this.f6863l + 1, this.f6862k, 0};
        int i12 = iArr[0];
        int iC = l8.c.c(i12);
        int iC2 = l8.c.c(iArr[0] - 1);
        if (this.f6861j) {
            iArrD = l8.c.e(iArr[0], iArr[1], iArr[2]);
            int i13 = iArrD[0];
            if ((i12 != i13 && iC2 != 0 && (iArrD[3] == 1 || iArrD[1] > iC2)) || (i12 == i13 && iC != 0 && (iArrD[3] == 1 || iArrD[1] > iC))) {
                iArrD[1] = iArrD[1] + 1;
            }
        } else {
            if (iC == 0 || iC >= (i11 = iArr[1])) {
                i10 = iArr[1];
            } else {
                int i14 = iC + 1;
                if (i14 == i11) {
                    i10 = i11 - 1;
                    z3 = true;
                } else if (i14 < i11) {
                    i10 = i11 - 1;
                } else {
                    i10 = 0;
                    z3 = false;
                }
                iArrD = l8.c.d(iArr[0], i10, iArr[2], z3);
            }
            z3 = false;
            iArrD = l8.c.d(iArr[0], i10, iArr[2], z3);
        }
        f();
        int i15 = iArrD[0];
        int i16 = iArrD[1] - 1;
        if (i16 < 0) {
            i16 = 12;
        }
        h(i15, i16, iArrD[2], this.f6865n, this.f6866o, true);
        setLeapUnitVisibility(this.f6863l);
    }

    private void setDayRange(int i10) {
    }

    private void setMonthRange(int i10) {
    }

    public void setOnTimeChangedListener(b bVar) {
    }
}
