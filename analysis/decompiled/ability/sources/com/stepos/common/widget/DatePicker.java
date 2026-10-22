package com.stepos.common.widget;

import a5.AbstractC0303c;
import android.content.Context;
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
import com.stepos.ability.R;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

/* loaded from: classes3.dex */
public class DatePicker extends FrameLayout {

    /* renamed from: A, reason: collision with root package name */
    public final float f3661A;

    /* renamed from: B, reason: collision with root package name */
    public final int f3662B;

    /* renamed from: C, reason: collision with root package name */
    public final ArrayList f3663C;

    /* renamed from: D, reason: collision with root package name */
    public final int f3664D;
    public final ArrayList E;

    /* renamed from: F, reason: collision with root package name */
    public final LinearLayout f3665F;

    /* renamed from: G, reason: collision with root package name */
    public final int f3666G;

    /* renamed from: L, reason: collision with root package name */
    public final Paint f3667L;

    /* renamed from: M, reason: collision with root package name */
    public boolean f3668M;

    /* renamed from: N, reason: collision with root package name */
    public final boolean f3669N;

    /* renamed from: O, reason: collision with root package name */
    public final String[] f3670O;

    /* renamed from: P, reason: collision with root package name */
    public final String[] f3671P;

    /* renamed from: Q, reason: collision with root package name */
    public final String[] f3672Q;

    /* renamed from: R, reason: collision with root package name */
    public final boolean f3673R;

    /* renamed from: S, reason: collision with root package name */
    public int f3674S;

    /* renamed from: a, reason: collision with root package name */
    public final TextView f3675a;
    public final TextView b;
    public final TextView c;
    public final TextView d;
    public final ScrollTextView e;
    public final ScrollTextView f;
    public final ScrollTextView g;
    public boolean h;
    public int i;

    /* renamed from: j, reason: collision with root package name */
    public int f3676j;
    public int k;
    public int l;
    public int m;
    public Calendar n;
    public Calendar o;
    public int p;

    /* renamed from: q, reason: collision with root package name */
    public int f3677q;

    /* renamed from: r, reason: collision with root package name */
    public String[] f3678r;

    /* renamed from: s, reason: collision with root package name */
    public String f3679s;

    /* renamed from: t, reason: collision with root package name */
    public final Object f3680t;
    public volatile Locale u;

    /* renamed from: v, reason: collision with root package name */
    public String[] f3681v;

    /* renamed from: w, reason: collision with root package name */
    public final int f3682w;

    /* renamed from: x, reason: collision with root package name */
    public int f3683x;
    public int y;

    /* renamed from: z, reason: collision with root package name */
    public final float f3684z;

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new C1111p();
        private final int mDay;
        private final int mMonth;
        private final int mYear;

        public /* synthetic */ SavedState(Parcel parcel, C1108m c1108m) {
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

        public /* synthetic */ SavedState(Parcelable parcelable, int i, int i6, int i10, C1108m c1108m) {
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

    public DatePicker(Context context, AttributeSet attributeSet) {
        boolean z10;
        super(context, attributeSet, 0);
        this.h = false;
        this.f3680t = new Object();
        this.f3682w = 5;
        this.f3669N = false;
        this.f3673R = false;
        this.f3674S = 0;
        this.f3673R = context.getResources().getConfiguration().getLayoutDirection() == 1;
        ArrayList arrayList = new ArrayList();
        this.f3663C = arrayList;
        arrayList.add(Float.valueOf(context.getResources().getDimension(R.dimen.mc_picker_normal_word_size_one)));
        arrayList.add(Float.valueOf(context.getResources().getDimension(R.dimen.mc_picker_normal_word_size_two)));
        this.f3662B = context.getResources().getDimensionPixelOffset(R.dimen.mc_picker_selected_word_size);
        ArrayList arrayList2 = new ArrayList();
        this.E = arrayList2;
        arrayList2.add(Float.valueOf(context.getResources().getDimension(R.dimen.mc_picker_normal_number_size_one)));
        arrayList2.add(Float.valueOf(context.getResources().getDimension(R.dimen.mc_picker_normal_number_size_two)));
        this.f3664D = Math.min(getContext().getResources().getDimensionPixelOffset(R.dimen.mc_picker_selected_number_max_size), getContext().getResources().getDimensionPixelOffset(R.dimen.mc_picker_selected_number_size));
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, V4.s.b);
        this.l = typedArrayObtainStyledAttributes.getInt(8, 1900);
        this.m = typedArrayObtainStyledAttributes.getInt(1, 2099);
        int i = 2;
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(2, R.layout.mc_date_picker);
        int i6 = typedArrayObtainStyledAttributes.getInt(9, 5);
        this.f3682w = i6;
        float dimension = typedArrayObtainStyledAttributes.getDimension(6, this.f3661A);
        this.f3661A = dimension;
        float dimension2 = typedArrayObtainStyledAttributes.getDimension(5, this.f3684z);
        this.f3684z = dimension2;
        typedArrayObtainStyledAttributes.recycle();
        View.inflate(getContext(), resourceId, this);
        this.d = (TextView) findViewById(R.id.mc_leap);
        TextView textView = (TextView) findViewById(R.id.mc_scroll1_text);
        this.b = textView;
        if (textView != null) {
            textView.setText(R.string.mc_date_time_month);
        }
        TextView textView2 = (TextView) findViewById(R.id.mc_scroll2_text);
        this.f3675a = textView2;
        if (textView2 != null) {
            textView2.setText(R.string.mc_date_time_day);
        }
        TextView textView3 = (TextView) findViewById(R.id.mc_scroll3_text);
        this.c = textView3;
        if (textView3 != null) {
            textView3.setText(R.string.mc_date_time_year);
        }
        Calendar calendar = Calendar.getInstance();
        this.k = calendar.get(1);
        this.f3676j = calendar.get(2);
        this.i = calendar.get(5);
        int actualMaximum = calendar.getActualMaximum(5);
        this.f3665F = (LinearLayout) findViewById(R.id.mc_column_parent);
        ScrollTextView scrollTextView = (ScrollTextView) findViewById(R.id.mc_scroll2);
        this.e = scrollTextView;
        if (dimension == 0.0f || dimension2 == 0.0f) {
            z10 = true;
        } else {
            z10 = true;
            scrollTextView.l(scrollTextView.i, scrollTextView.h, (int) dimension, (int) dimension2);
        }
        scrollTextView.i(new B1.b(this, 3, 7), this.i - 1, actualMaximum, i6, actualMaximum - 1, true);
        ScrollTextView scrollTextView2 = (ScrollTextView) findViewById(R.id.mc_scroll1);
        this.f = scrollTextView2;
        if (dimension != 0.0f && dimension2 != 0.0f) {
            scrollTextView2.l(scrollTextView2.i, scrollTextView2.h, (int) dimension, (int) dimension2);
        }
        this.f3678r = getShortMonths();
        scrollTextView2.i(new B1.b(this, i, 7), this.f3676j, 12, i6, 11, true);
        ScrollTextView scrollTextView3 = (ScrollTextView) findViewById(R.id.mc_scroll3);
        this.g = scrollTextView3;
        if (dimension != 0.0f && dimension2 != 0.0f) {
            scrollTextView3.l(scrollTextView3.i, scrollTextView3.h, (int) dimension, (int) dimension2);
        }
        i();
        l();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Calendar calendar2 = Calendar.getInstance();
            this.n = calendar2;
            calendar2.setTime(simpleDateFormat.parse(this.l + "-01-01"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            Calendar calendar3 = Calendar.getInstance();
            this.o = calendar3;
            calendar3.setTime(simpleDateFormat.parse(this.m + "-12-31"));
        } catch (ParseException e6) {
            e6.printStackTrace();
        }
        j(this.f3678r);
        boolean zH = h();
        this.f3675a.setVisibility(zH ? 0 : 8);
        this.b.setVisibility(zH ? 0 : 8);
        this.c.setVisibility(zH ? 0 : 8);
        TextView textView4 = (TextView) findViewById(R.id.mc_scroll1_text);
        this.b = textView4;
        if (textView4 != null) {
            textView4.setText(R.string.mc_date_time_month);
        }
        TextView textView5 = (TextView) findViewById(R.id.mc_scroll2_text);
        this.f3675a = textView5;
        if (textView5 != null) {
            textView5.setText(R.string.mc_date_time_day);
        }
        TextView textView6 = (TextView) findViewById(R.id.mc_scroll3_text);
        this.c = textView6;
        if (textView6 != null) {
            textView6.setText(R.string.mc_date_time_year);
        }
        if (!isEnabled()) {
            setEnabled(false);
        }
        this.f3666G = context.getResources().getDimensionPixelSize(R.dimen.mc_custom_time_picker_line_width_padding);
        Paint paint = new Paint();
        this.f3667L = paint;
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(V4.s.f1375s);
        int i10 = typedArrayObtainStyledAttributes2.getInt(11, context.getResources().getColor(R.color.mc_custom_date_picker_selected_gregorian_color));
        typedArrayObtainStyledAttributes2.recycle();
        paint.setColor(i10);
        paint.setAntiAlias(z10);
        paint.setStrokeWidth(context.getResources().getDimensionPixelSize(R.dimen.mc_custom_time_picker_line_stroke_width));
        this.f3668M = false;
        setWillNotDraw(false);
        this.f3670O = getResources().getStringArray(R.array.mc_custom_time_picker_lunar_month);
        this.f3671P = getResources().getStringArray(R.array.mc_custom_time_picker_lunar_day);
        String str = String.format(Locale.getDefault(), TimeModel.NUMBER_FORMAT, 0);
        this.f3672Q = new String[100];
        for (int i11 = 0; i11 < 100; i11++) {
            this.f3672Q[i11] = String.format(Locale.getDefault(), TimeModel.NUMBER_FORMAT, Integer.valueOf(i11));
            if (i11 <= 9) {
                String[] strArr = this.f3672Q;
                StringBuilder sbV = androidx.compose.foundation.b.v(str);
                sbV.append(this.f3672Q[i11]);
                strArr[i11] = sbV.toString();
            }
        }
        this.d.setText(getResources().getString(R.string.mc_time_picker_leap));
        this.d.setVisibility(8);
        if (Build.DEVICE.equals("mx4pro")) {
            this.g.d(new C1108m());
            int i12 = 0;
            this.f.d(new C1109n(i12));
            this.e.d(new C1110o(this, i12));
        }
        AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
        if (accessibilityManager != null) {
            this.f3669N = accessibilityManager.isEnabled();
        }
    }

    private Calendar getCurrentCalendar() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(5, 1);
        calendar.set(1, this.k);
        calendar.set(2, this.f3676j);
        return calendar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getMonthDays() {
        if (!this.h) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(5, 1);
            calendar.set(1, this.k);
            calendar.set(2, this.f3676j);
            return calendar.getActualMaximum(5);
        }
        int i = this.f3676j;
        int iC = AbstractC0303c.c(this.k);
        boolean z10 = false;
        if (iC != 0) {
            z10 = iC == i;
        }
        if (iC == 0 || (iC != 0 && this.f3676j < iC)) {
            i++;
        }
        return AbstractC0303c.b(this.k, i, z10);
    }

    private String[] getShortMonths() {
        int iCeil;
        Locale locale = Locale.getDefault();
        if (!locale.equals(this.u) || this.f3681v == null) {
            synchronized (this.f3680t) {
                try {
                    if (!locale.equals(this.u)) {
                        this.f3681v = new String[12];
                        for (int i = 0; i < 12; i++) {
                            this.f3681v[i] = DateUtils.getMonthString(i, 20);
                        }
                        if (this.f3681v[0].startsWith("1")) {
                            int i6 = 0;
                            while (true) {
                                String[] strArr = this.f3681v;
                                if (i6 >= strArr.length) {
                                    break;
                                }
                                int i10 = i6 + 1;
                                strArr[i6] = String.valueOf(i10);
                                if (i6 < 9) {
                                    this.f3681v[i6] = "0" + this.f3681v[i6];
                                }
                                i6 = i10;
                            }
                        }
                        this.u = locale;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        ScrollTextView scrollTextView = this.f;
        if (scrollTextView != null && scrollTextView.getWidth() > 0 && this.f3681v != null) {
            int i11 = 0;
            while (true) {
                String[] strArr2 = this.f3681v;
                if (i11 >= strArr2.length) {
                    break;
                }
                ScrollTextView scrollTextView2 = this.f;
                String str = strArr2[i11];
                Paint paint = scrollTextView2.f3754a;
                if (str != null && str.length() > 0) {
                    int length = str.length();
                    paint.setTextSize(scrollTextView2.i);
                    paint.getTextWidths(str, new float[length]);
                    iCeil = 0;
                    for (int i12 = 0; i12 < length; i12++) {
                        iCeil += (int) Math.ceil(r7[i12]);
                    }
                } else {
                    iCeil = 0;
                }
                if (iCeil > this.f.getWidth()) {
                    this.f3681v = new String[]{"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
                    break;
                }
                i11++;
            }
        }
        return this.f3681v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getYearMonths() {
        return (!this.h || AbstractC0303c.c(this.k) == 0) ? 12 : 13;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0072 A[PHI: r1 r2
      0x0072: PHI (r1v9 int) = (r1v3 int), (r1v4 int), (r1v10 int) binds: [B:64:0x014a, B:55:0x0115, B:23:0x0070] A[DONT_GENERATE, DONT_INLINE]
      0x0072: PHI (r2v17 int) = (r2v6 int), (r2v10 int), (r2v20 int) binds: [B:64:0x014a, B:55:0x0115, B:23:0x0070] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x017a A[PHI: r0 r1 r2
      0x017a: PHI (r0v11 int) = (r0v4 int), (r0v4 int), (r0v4 int), (r0v4 int), (r0v4 int), (r0v5 int), (r0v4 int), (r0v10 int), (r0v4 int) binds: [B:39:0x00c0, B:41:0x00ca, B:43:0x00d2, B:45:0x00da, B:67:0x0154, B:72:0x0178, B:31:0x0090, B:36:0x00b4, B:17:0x0045] A[DONT_GENERATE, DONT_INLINE]
      0x017a: PHI (r1v6 int) = (r1v1 int), (r1v1 int), (r1v1 int), (r1v1 int), (r1v1 int), (r1v2 int), (r1v1 int), (r1v5 int), (r1v1 int) binds: [B:39:0x00c0, B:41:0x00ca, B:43:0x00d2, B:45:0x00da, B:67:0x0154, B:72:0x0178, B:31:0x0090, B:36:0x00b4, B:17:0x0045] A[DONT_GENERATE, DONT_INLINE]
      0x017a: PHI (r2v14 int) = (r2v1 int), (r2v1 int), (r2v1 int), (r2v1 int), (r2v1 int), (r2v2 int), (r2v1 int), (r2v12 int), (r2v1 int) binds: [B:39:0x00c0, B:41:0x00ca, B:43:0x00d2, B:45:0x00da, B:67:0x0154, B:72:0x0178, B:31:0x0090, B:36:0x00b4, B:17:0x0045] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void setDayRange(int r10) {
        /*
            Method dump skipped, instructions count: 396
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.common.widget.DatePicker.setDayRange(int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLeapUnitVisibility(int i) {
        int iC;
        boolean z10 = this.h;
        TextView textView = this.d;
        if (!z10 || !h() || ((iC = AbstractC0303c.c(this.k)) != 0 ? i >= 13 : i >= 12) || iC == 0 || i <= iC - 1 || i != iC) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMonthRange(int i) {
        int actualMaximum;
        int actualMaximum2;
        boolean z10;
        Calendar calendar = this.n;
        if (calendar == null || this.o == null || this.p == i) {
            return;
        }
        this.p = i;
        this.f3677q = -1;
        boolean z11 = true;
        if (calendar.get(1) > i || this.o.get(1) < i) {
            return;
        }
        int i6 = this.f3676j - this.n.get(2) < 0 ? 0 : this.f3676j - this.n.get(2);
        int iC = AbstractC0303c.c(i);
        int i10 = this.n.get(1);
        ScrollTextView scrollTextView = this.f;
        if (i10 == i && this.o.get(1) == i) {
            actualMaximum = (this.o.get(2) - this.n.get(2)) + 1;
        } else {
            if (this.n.get(1) != i) {
                if (this.o.get(1) == i) {
                    int i11 = this.o.get(2);
                    i6 = this.f3676j;
                    if (i11 - i6 < 0) {
                        i6 = 0;
                    }
                    int i12 = this.o.get(2);
                    int i13 = i12 + 1;
                    actualMaximum = (!this.h || iC <= 0 || iC >= i13) ? i13 : i12 + 2;
                    z10 = false;
                    actualMaximum2 = actualMaximum - 1;
                } else {
                    if (scrollTextView.o) {
                        return;
                    }
                    i6 = this.f3676j;
                    actualMaximum = this.n.getActualMaximum(2) + 1;
                    actualMaximum2 = this.n.getActualMaximum(2);
                    z10 = true;
                }
                if ((!this.h || actualMaximum != this.n.getActualMaximum(2) + 1) && ((!this.h || iC <= 0 || actualMaximum != this.n.getActualMaximum(2) + 2) && (!this.h || iC != 0 || actualMaximum != this.n.getActualMaximum(2) + 1))) {
                }
                scrollTextView.setCyclic(z11);
                scrollTextView.g(actualMaximum, i6, actualMaximum2);
            }
            actualMaximum = (this.n.getActualMaximum(2) + 1) - this.n.get(2);
            if (this.h && iC > 0 && iC < actualMaximum) {
                actualMaximum++;
            }
        }
        z10 = false;
        actualMaximum2 = actualMaximum;
        z11 = !this.h ? z10 : z10;
        scrollTextView.setCyclic(z11);
        scrollTextView.g(actualMaximum, i6, actualMaximum2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchRestoreInstanceState(SparseArray sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    public final String f(int i) {
        int iC = AbstractC0303c.c(this.k);
        if (iC == 0) {
            if (i >= 12) {
                return null;
            }
        } else if (i >= 13) {
            return null;
        }
        String[] strArr = this.f3670O;
        return (iC == 0 || i <= iC + (-1)) ? strArr[i] : i == iC ? strArr[i - 1] : strArr[i - 1];
    }

    public final String g(int i) {
        if (i == 1) {
            return String.valueOf(this.k);
        }
        if (i == 2) {
            int i6 = this.f3676j;
            if (this.h) {
                return f(i6);
            }
            if (this.f3678r == null) {
                this.f3678r = getShortMonths();
            }
            String[] strArr = this.f3678r;
            return i6 < strArr.length ? strArr[i6] : "";
        }
        if (i != 3) {
            return "";
        }
        int i10 = this.i;
        int i11 = i10 - 1;
        if (!this.h) {
            return String.valueOf(i10);
        }
        String[] strArr2 = this.f3671P;
        if (i11 > strArr2.length - 1) {
            return null;
        }
        return strArr2[i11];
    }

    public int getDayOfMonth() {
        return this.i;
    }

    public TextView getDayUnit() {
        return this.f3675a;
    }

    public int getMonth() {
        return this.f3676j;
    }

    public int getYear() {
        return this.k;
    }

    public final boolean h() {
        return getResources().getConfiguration().locale.getLanguage().endsWith("zh");
    }

    public final void i() {
        boolean z10 = this.h;
        ScrollTextView scrollTextView = this.e;
        ScrollTextView scrollTextView2 = this.f;
        ArrayList arrayList = this.E;
        int i = this.f3664D;
        if (z10 && h()) {
            float f = this.f3662B;
            ArrayList arrayList2 = this.f3663C;
            scrollTextView2.n(f, arrayList2);
            scrollTextView.n(f, arrayList2);
        } else {
            float f7 = i;
            scrollTextView2.n(f7, arrayList);
            scrollTextView.n(f7, arrayList);
        }
        this.g.n(i, arrayList);
    }

    public final void j(String[] strArr) {
        int i;
        boolean z10;
        DateFormat dateFormat = strArr[0].startsWith("1") ? android.text.format.DateFormat.getDateFormat(getContext()) : android.text.format.DateFormat.getMediumDateFormat(getContext());
        if (dateFormat instanceof SimpleDateFormat) {
            this.f3679s = ((SimpleDateFormat) dateFormat).toPattern();
        } else {
            this.f3679s = new String(android.text.format.DateFormat.getDateFormatOrder(getContext()));
        }
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.mc_column1Layout);
        FrameLayout frameLayout2 = (FrameLayout) findViewById(R.id.mc_column2Layout);
        FrameLayout frameLayout3 = (FrameLayout) findViewById(R.id.mc_column3Layout);
        ImageView imageView = (ImageView) findViewById(R.id.mc_divider_bar1);
        ImageView imageView2 = (ImageView) findViewById(R.id.mc_divider_bar2);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.mc_column_parent);
        linearLayout.removeAllViews();
        if (this.f3679s.contentEquals("dd\u200f/MM\u200f/y") || this.f3679s.contentEquals("d בMMM y")) {
            this.f3679s = "yy/M/d";
        }
        if (this.f3673R) {
            this.f3679s = "d/M/yy";
        }
        int i6 = 0;
        boolean z11 = false;
        boolean z12 = false;
        boolean z13 = false;
        boolean z14 = false;
        boolean z15 = false;
        boolean z16 = false;
        while (i6 < this.f3679s.length()) {
            char cCharAt = this.f3679s.charAt(i6);
            if (cCharAt == '\'') {
                z13 = !z13;
            }
            if (z13) {
                i = i6;
            } else {
                i = i6;
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
            i6 = i + 1;
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
        if (!h()) {
            FrameLayout frameLayout4 = (FrameLayout) findViewById(R.id.mc_column2Layout);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) frameLayout4.getLayoutParams();
            layoutParams.setMarginEnd(0);
            frameLayout4.setLayoutParams(layoutParams);
        }
        this.g.post(new A6.l(this, 21));
    }

    public final void k() {
        String strReplace;
        if (this.f3669N) {
            View viewFindViewById = findViewById(R.id.mc_column3Layout);
            View viewFindViewById2 = findViewById(R.id.mc_column1Layout);
            View viewFindViewById3 = findViewById(R.id.mc_column2Layout);
            if (viewFindViewById3 == null || viewFindViewById3.getVisibility() != 8) {
                strReplace = (g(1) + ((Object) this.c.getText()) + g(2) + ((Object) this.b.getText()) + g(3) + ((Object) this.f3675a.getText())).replace(" ", "").replace("廿十", "二十").replace("廿", "二十");
            } else {
                strReplace = (g(1) + ((Object) this.c.getText()) + g(2) + ((Object) this.b.getText())).replace(" ", "").replace("廿十", "二十").replace("廿", "二十");
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

    public final void l() {
        B1.b bVar = new B1.b(this, 1, 7);
        int i = this.k;
        int i6 = this.l;
        int i10 = this.m - i6;
        int i11 = this.f3682w;
        this.g.i(bVar, i - i6, i10 + 1, i11, i10, false);
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f3668M) {
            int width = getWidth();
            int width2 = this.f3665F.getWidth() - (this.f3666G * 2);
            int i = (width - width2) / 2;
            float f = i;
            float f7 = 0;
            float f9 = i + width2;
            Paint paint = this.f3667L;
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
        this.k = savedState.getYear();
        this.f3676j = savedState.getMonth();
        this.i = savedState.getDay();
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.k, this.f3676j, this.i, null);
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z10) {
        super.onWindowFocusChanged(z10);
        if (z10) {
            String[] shortMonths = getShortMonths();
            DateFormat dateFormat = shortMonths[0].startsWith("1") ? android.text.format.DateFormat.getDateFormat(getContext()) : android.text.format.DateFormat.getMediumDateFormat(getContext());
            String pattern = dateFormat instanceof SimpleDateFormat ? ((SimpleDateFormat) dateFormat).toPattern() : new String(android.text.format.DateFormat.getDateFormatOrder(getContext()));
            this.f3678r = shortMonths;
            if (this.f3679s.equals(pattern)) {
                return;
            }
            j(this.f3678r);
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z10) {
        super.setEnabled(z10);
        this.e.setEnabled(z10);
        this.f.setEnabled(z10);
        this.g.setEnabled(z10);
    }

    public void setIsDrawFading(boolean z10) {
        this.g.setIsDrawFading(z10);
        this.f.setIsDrawFading(z10);
        this.e.setIsDrawFading(z10);
    }

    public void setIsDrawLine(boolean z10) {
        this.f3668M = z10;
    }

    public void setLunar(boolean z10) {
        int i;
        boolean z11;
        int[] iArrD;
        int i6;
        if (this.h == z10) {
            return;
        }
        this.h = z10;
        int[] iArr = {this.k, this.f3676j + 1, this.i, 0};
        int i10 = iArr[0];
        int iC = AbstractC0303c.c(i10);
        int iC2 = AbstractC0303c.c(iArr[0] - 1);
        if (this.h) {
            iArrD = AbstractC0303c.e(iArr[0], iArr[1], iArr[2]);
            int i11 = iArrD[0];
            if ((i10 != i11 && iC2 != 0 && (iArrD[3] == 1 || iArrD[1] > iC2)) || (i10 == i11 && iC != 0 && (iArrD[3] == 1 || iArrD[1] > iC))) {
                iArrD[1] = iArrD[1] + 1;
            }
            this.f3675a.setAlpha(0.0f);
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
                this.f3675a.setAlpha(1.0f);
                iArrD = AbstractC0303c.d(iArr[0], i, iArr[2], z11);
            }
            z11 = false;
            this.f3675a.setAlpha(1.0f);
            iArrD = AbstractC0303c.d(iArr[0], i, iArr[2], z11);
        }
        i();
        int i13 = iArrD[0];
        int i14 = iArrD[1] - 1;
        if (i14 < 0) {
            i14 = 12;
        }
        int i15 = iArrD[2];
        int i16 = this.l;
        if (i13 >= i16) {
            i16 = i13;
        }
        this.k = i16;
        int i17 = this.m;
        if (i13 > i17) {
            i13 = i17;
        }
        this.k = i13;
        this.f3676j = i14;
        this.i = i15;
        this.f3678r = null;
        this.f3678r = getShortMonths();
        ScrollTextView scrollTextView = this.g;
        J j5 = scrollTextView.f3755j;
        if (j5 != null) {
            j5.d.forceFinished(true);
        }
        ScrollTextView scrollTextView2 = this.f;
        J j6 = scrollTextView2.f3755j;
        if (j6 != null) {
            j6.d.forceFinished(true);
        }
        ScrollTextView scrollTextView3 = this.e;
        J j10 = scrollTextView3.f3755j;
        if (j10 != null) {
            j10.d.forceFinished(true);
        }
        if (this.f3683x != getYearMonths()) {
            int yearMonths = getYearMonths();
            this.f3683x = yearMonths;
            scrollTextView2.f(yearMonths);
        }
        if (this.y != getMonthDays()) {
            this.y = getMonthDays();
            scrollTextView3.f(getMonthDays());
        }
        scrollTextView.h(this.k - this.l, true);
        this.f3676j = i14;
        scrollTextView2.h(i14, true);
        scrollTextView3.h(this.i - 1, true);
        setLeapUnitVisibility(this.f3676j);
    }

    public void setMaxDate(long j5) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j5);
        this.o = calendar;
        this.m = calendar.get(1);
        l();
        this.p = -1;
        setMonthRange(this.k);
        this.f3677q = -1;
        setDayRange(this.f3676j);
    }

    public void setMinDate(long j5) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j5);
        this.n = calendar;
        this.l = calendar.get(1);
        l();
        this.p = -1;
        setMonthRange(this.k);
        this.f3677q = -1;
        setDayRange(this.f3676j);
    }

    public void setShowDayColumn(boolean z10) {
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.mc_column2Layout);
        if (frameLayout != null) {
            frameLayout.setVisibility(z10 ? 0 : 8);
            k();
            this.e.setVisibility(z10 ? 0 : 8);
        }
    }
}
