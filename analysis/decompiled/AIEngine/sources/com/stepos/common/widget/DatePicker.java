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
import com.stepos.aiengine.R;
import com.stepos.common.widget.ScrollTextView;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class DatePicker extends FrameLayout {
    public int A;
    public int B;
    public final float C;
    public final float D;
    public final int E;
    public final ArrayList F;
    public final int G;
    public final ArrayList H;
    public final LinearLayout I;
    public final int J;
    public final Paint K;
    public boolean L;
    public final boolean M;
    public final String[] N;
    public final String[] O;
    public final String[] P;
    public final boolean Q;
    public int R;

    /* renamed from: a, reason: collision with root package name */
    public final TextView f6833a;

    /* renamed from: b, reason: collision with root package name */
    public final TextView f6834b;

    /* renamed from: c, reason: collision with root package name */
    public final TextView f6835c;

    /* renamed from: d, reason: collision with root package name */
    public final TextView f6836d;

    /* renamed from: e, reason: collision with root package name */
    public final ScrollTextView f6837e;
    public final ScrollTextView h;

    /* renamed from: j, reason: collision with root package name */
    public final ScrollTextView f6838j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f6839k;

    /* renamed from: l, reason: collision with root package name */
    public int f6840l;

    /* renamed from: m, reason: collision with root package name */
    public int f6841m;

    /* renamed from: n, reason: collision with root package name */
    public int f6842n;

    /* renamed from: o, reason: collision with root package name */
    public int f6843o;

    /* renamed from: p, reason: collision with root package name */
    public int f6844p;

    /* renamed from: q, reason: collision with root package name */
    public Calendar f6845q;
    public Calendar r;

    /* renamed from: s, reason: collision with root package name */
    public int f6846s;

    /* renamed from: t, reason: collision with root package name */
    public int f6847t;

    /* renamed from: u, reason: collision with root package name */
    public String[] f6848u;

    /* renamed from: v, reason: collision with root package name */
    public String f6849v;

    /* renamed from: w, reason: collision with root package name */
    public final Object f6850w;

    /* renamed from: x, reason: collision with root package name */
    public volatile Locale f6851x;

    /* renamed from: y, reason: collision with root package name */
    public String[] f6852y;
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

        public /* synthetic */ SavedState(Parcel parcel, i iVar) {
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

        public /* synthetic */ SavedState(Parcelable parcelable, int i10, int i11, int i12, i iVar) {
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
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            DatePicker datePicker = DatePicker.this;
            ScrollTextView scrollTextView = datePicker.f6838j;
            if (scrollTextView != null) {
                scrollTextView.getLayoutDirection();
            }
            datePicker.getClass();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class b implements ScrollTextView.e {

        /* renamed from: a, reason: collision with root package name */
        public final int f6854a;

        public b(int i10) {
            this.f6854a = i10;
        }

        @Override // com.stepos.common.widget.ScrollTextView.e
        public final String a(int i10) {
            DatePicker datePicker = DatePicker.this;
            String[] strArr = datePicker.P;
            int i11 = this.f6854a;
            if (i11 == 1) {
                return String.format(Locale.getDefault(), TimeModel.NUMBER_FORMAT, Integer.valueOf(i10 + datePicker.f6843o));
            }
            if (i11 != 2) {
                if (i11 == 3) {
                    if (!datePicker.f6839k) {
                        Calendar calendar = datePicker.f6845q;
                        return (calendar != null && calendar.get(1) == datePicker.f6842n && datePicker.f6845q.get(2) == datePicker.f6841m) ? strArr[datePicker.f6845q.get(5) + i10] : strArr[i10 + 1];
                    }
                    String[] strArr2 = datePicker.O;
                    if (i10 > strArr2.length - 1) {
                        return null;
                    }
                    return strArr2[i10];
                }
            } else {
                if (datePicker.f6839k) {
                    return datePicker.f(i10);
                }
                Calendar calendar2 = datePicker.f6845q;
                if (calendar2 != null && calendar2.get(1) == datePicker.f6842n) {
                    i10 += datePicker.f6845q.get(2);
                }
                String[] strArr3 = datePicker.f6848u;
                if (i10 < strArr3.length) {
                    return strArr3[i10];
                }
            }
            return null;
        }

        /* JADX WARN: Removed duplicated region for block: B:50:0x00cf  */
        /* JADX WARN: Removed duplicated region for block: B:55:0x00d9  */
        @Override // com.stepos.common.widget.ScrollTextView.e
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void b(int r11) {
            /*
                Method dump skipped, instructions count: 363
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.common.widget.DatePicker.b.b(int):void");
        }
    }

    public DatePicker(Context context, AttributeSet attributeSet) throws Resources.NotFoundException {
        boolean z;
        super(context, attributeSet, 0);
        this.f6839k = false;
        this.f6850w = new Object();
        this.z = 5;
        this.M = false;
        this.Q = false;
        this.R = 0;
        this.Q = context.getResources().getConfiguration().getLayoutDirection() == 1;
        ArrayList arrayList = new ArrayList();
        this.F = arrayList;
        arrayList.add(Float.valueOf(context.getResources().getDimension(R.dimen.mc_picker_normal_word_size_one)));
        arrayList.add(Float.valueOf(context.getResources().getDimension(R.dimen.mc_picker_normal_word_size_two)));
        this.E = context.getResources().getDimensionPixelOffset(R.dimen.mc_picker_selected_word_size);
        ArrayList arrayList2 = new ArrayList();
        this.H = arrayList2;
        arrayList2.add(Float.valueOf(context.getResources().getDimension(R.dimen.mc_picker_normal_number_size_one)));
        arrayList2.add(Float.valueOf(context.getResources().getDimension(R.dimen.mc_picker_normal_number_size_two)));
        this.G = Math.min(getContext().getResources().getDimensionPixelOffset(R.dimen.mc_picker_selected_number_max_size), getContext().getResources().getDimensionPixelOffset(R.dimen.mc_picker_selected_number_size));
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g8.a.f9076b);
        this.f6843o = typedArrayObtainStyledAttributes.getInt(8, 1900);
        this.f6844p = typedArrayObtainStyledAttributes.getInt(1, 2099);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(2, R.layout.mc_date_picker);
        int i10 = typedArrayObtainStyledAttributes.getInt(9, 5);
        this.z = i10;
        float dimension = typedArrayObtainStyledAttributes.getDimension(6, this.D);
        this.D = dimension;
        float dimension2 = typedArrayObtainStyledAttributes.getDimension(5, this.C);
        this.C = dimension2;
        typedArrayObtainStyledAttributes.recycle();
        FrameLayout.inflate(getContext(), resourceId, this);
        this.f6836d = (TextView) findViewById(R.id.mc_leap);
        TextView textView = (TextView) findViewById(R.id.mc_scroll1_text);
        this.f6834b = textView;
        if (textView != null) {
            textView.setText(R.string.mc_date_time_month);
        }
        TextView textView2 = (TextView) findViewById(R.id.mc_scroll2_text);
        this.f6833a = textView2;
        if (textView2 != null) {
            textView2.setText(R.string.mc_date_time_day);
        }
        TextView textView3 = (TextView) findViewById(R.id.mc_scroll3_text);
        this.f6835c = textView3;
        if (textView3 != null) {
            textView3.setText(R.string.mc_date_time_year);
        }
        Calendar calendar = Calendar.getInstance();
        this.f6842n = calendar.get(1);
        this.f6841m = calendar.get(2);
        this.f6840l = calendar.get(5);
        int actualMaximum = calendar.getActualMaximum(5);
        this.I = (LinearLayout) findViewById(R.id.mc_column_parent);
        ScrollTextView scrollTextView = (ScrollTextView) findViewById(R.id.mc_scroll2);
        this.f6837e = scrollTextView;
        if (dimension == 0.0f || dimension2 == 0.0f) {
            z = true;
        } else {
            z = true;
            scrollTextView.l(scrollTextView.f6987l, scrollTextView.f6986k, (int) dimension, (int) dimension2);
        }
        scrollTextView.i(new b(3), this.f6840l - 1, actualMaximum, i10, actualMaximum - 1, true);
        ScrollTextView scrollTextView2 = (ScrollTextView) findViewById(R.id.mc_scroll1);
        this.h = scrollTextView2;
        if (dimension != 0.0f && dimension2 != 0.0f) {
            scrollTextView2.l(scrollTextView2.f6987l, scrollTextView2.f6986k, (int) dimension, (int) dimension2);
        }
        this.f6848u = getShortMonths();
        scrollTextView2.i(new b(2), this.f6841m, 12, i10, 11, true);
        ScrollTextView scrollTextView3 = (ScrollTextView) findViewById(R.id.mc_scroll3);
        this.f6838j = scrollTextView3;
        if (dimension != 0.0f && dimension2 != 0.0f) {
            scrollTextView3.l(scrollTextView3.f6987l, scrollTextView3.f6986k, (int) dimension, (int) dimension2);
        }
        i();
        l();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Calendar calendar2 = Calendar.getInstance();
            this.f6845q = calendar2;
            calendar2.setTime(simpleDateFormat.parse(this.f6843o + "-01-01"));
        } catch (ParseException e10) {
            e10.printStackTrace();
        }
        try {
            Calendar calendar3 = Calendar.getInstance();
            this.r = calendar3;
            calendar3.setTime(simpleDateFormat.parse(this.f6844p + "-12-31"));
        } catch (ParseException e11) {
            e11.printStackTrace();
        }
        j(this.f6848u);
        boolean zH = h();
        this.f6833a.setVisibility(zH ? 0 : 8);
        this.f6834b.setVisibility(zH ? 0 : 8);
        this.f6835c.setVisibility(zH ? 0 : 8);
        TextView textView4 = (TextView) findViewById(R.id.mc_scroll1_text);
        this.f6834b = textView4;
        if (textView4 != null) {
            textView4.setText(R.string.mc_date_time_month);
        }
        TextView textView5 = (TextView) findViewById(R.id.mc_scroll2_text);
        this.f6833a = textView5;
        if (textView5 != null) {
            textView5.setText(R.string.mc_date_time_day);
        }
        TextView textView6 = (TextView) findViewById(R.id.mc_scroll3_text);
        this.f6835c = textView6;
        if (textView6 != null) {
            textView6.setText(R.string.mc_date_time_year);
        }
        if (!isEnabled()) {
            setEnabled(false);
        }
        this.J = context.getResources().getDimensionPixelSize(R.dimen.mc_custom_time_picker_line_width_padding);
        Paint paint = new Paint();
        this.K = paint;
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(g8.a.f9091s);
        int i11 = typedArrayObtainStyledAttributes2.getInt(11, context.getResources().getColor(R.color.mc_custom_date_picker_selected_gregorian_color));
        typedArrayObtainStyledAttributes2.recycle();
        paint.setColor(i11);
        paint.setAntiAlias(z);
        paint.setStrokeWidth(context.getResources().getDimensionPixelSize(R.dimen.mc_custom_time_picker_line_stroke_width));
        this.L = false;
        setWillNotDraw(false);
        this.N = getResources().getStringArray(R.array.mc_custom_time_picker_lunar_month);
        this.O = getResources().getStringArray(R.array.mc_custom_time_picker_lunar_day);
        String str = String.format(Locale.getDefault(), TimeModel.NUMBER_FORMAT, 0);
        this.P = new String[100];
        for (int i12 = 0; i12 < 100; i12++) {
            this.P[i12] = String.format(Locale.getDefault(), TimeModel.NUMBER_FORMAT, Integer.valueOf(i12));
            if (i12 <= 9) {
                String[] strArr = this.P;
                StringBuilder sbB = v1.d.b(str);
                sbB.append(this.P[i12]);
                strArr[i12] = sbB.toString();
            }
        }
        this.f6836d.setText(getResources().getString(R.string.mc_time_picker_leap));
        this.f6836d.setVisibility(8);
        if (Build.DEVICE.equals("mx4pro")) {
            this.f6838j.d(new i());
            this.h.d(new j());
            this.f6837e.d(new k(this));
        }
        AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
        if (accessibilityManager != null) {
            this.M = accessibilityManager.isEnabled();
        }
    }

    private Calendar getCurrentCalendar() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(5, 1);
        calendar.set(1, this.f6842n);
        calendar.set(2, this.f6841m);
        return calendar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getMonthDays() {
        if (!this.f6839k) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(5, 1);
            calendar.set(1, this.f6842n);
            calendar.set(2, this.f6841m);
            return calendar.getActualMaximum(5);
        }
        int i10 = this.f6841m;
        int iC = l8.c.c(this.f6842n);
        boolean z = false;
        if (iC != 0) {
            z = iC == i10;
        }
        if (iC == 0 || (iC != 0 && this.f6841m < iC)) {
            i10++;
        }
        return l8.c.b(this.f6842n, i10, z);
    }

    private String[] getShortMonths() {
        int iCeil;
        Locale locale = Locale.getDefault();
        if (!locale.equals(this.f6851x) || this.f6852y == null) {
            synchronized (this.f6850w) {
                try {
                    if (!locale.equals(this.f6851x)) {
                        this.f6852y = new String[12];
                        for (int i10 = 0; i10 < 12; i10++) {
                            this.f6852y[i10] = DateUtils.getMonthString(i10, 20);
                        }
                        if (this.f6852y[0].startsWith("1")) {
                            int i11 = 0;
                            while (true) {
                                String[] strArr = this.f6852y;
                                if (i11 >= strArr.length) {
                                    break;
                                }
                                int i12 = i11 + 1;
                                strArr[i11] = String.valueOf(i12);
                                if (i11 < 9) {
                                    this.f6852y[i11] = "0" + this.f6852y[i11];
                                }
                                i11 = i12;
                            }
                        }
                        this.f6851x = locale;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        ScrollTextView scrollTextView = this.h;
        if (scrollTextView != null && scrollTextView.getWidth() > 0 && this.f6852y != null) {
            int i13 = 0;
            while (true) {
                String[] strArr2 = this.f6852y;
                if (i13 >= strArr2.length) {
                    break;
                }
                ScrollTextView scrollTextView2 = this.h;
                String str = strArr2[i13];
                Paint paint = scrollTextView2.f6980a;
                if (str != null && str.length() > 0) {
                    int length = str.length();
                    paint.setTextSize(scrollTextView2.f6987l);
                    paint.getTextWidths(str, new float[length]);
                    iCeil = 0;
                    for (int i14 = 0; i14 < length; i14++) {
                        iCeil += (int) Math.ceil(r7[i14]);
                    }
                } else {
                    iCeil = 0;
                }
                if (iCeil > this.h.getWidth()) {
                    this.f6852y = new String[]{"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
                    break;
                }
                i13++;
            }
        }
        return this.f6852y;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getYearMonths() {
        return (!this.f6839k || l8.c.c(this.f6842n) == 0) ? 12 : 13;
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
    public void setLeapUnitVisibility(int i10) {
        int iC;
        boolean z = this.f6839k;
        TextView textView = this.f6836d;
        if (!z || !h() || ((iC = l8.c.c(this.f6842n)) != 0 ? i10 >= 13 : i10 >= 12) || iC == 0 || i10 <= iC - 1 || i10 != iC) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMonthRange(int i10) {
        int actualMaximum;
        int actualMaximum2;
        boolean z;
        Calendar calendar = this.f6845q;
        if (calendar == null || this.r == null || this.f6846s == i10) {
            return;
        }
        this.f6846s = i10;
        this.f6847t = -1;
        boolean z3 = true;
        if (calendar.get(1) > i10 || this.r.get(1) < i10) {
            return;
        }
        int i11 = this.f6841m - this.f6845q.get(2) < 0 ? 0 : this.f6841m - this.f6845q.get(2);
        int iC = l8.c.c(i10);
        int i12 = this.f6845q.get(1);
        ScrollTextView scrollTextView = this.h;
        if (i12 == i10 && this.r.get(1) == i10) {
            actualMaximum = (this.r.get(2) - this.f6845q.get(2)) + 1;
        } else {
            if (this.f6845q.get(1) != i10) {
                if (this.r.get(1) == i10) {
                    int i13 = this.r.get(2);
                    i11 = this.f6841m;
                    if (i13 - i11 < 0) {
                        i11 = 0;
                    }
                    int i14 = this.r.get(2);
                    int i15 = i14 + 1;
                    actualMaximum = (!this.f6839k || iC <= 0 || iC >= i15) ? i15 : i14 + 2;
                    z = false;
                    actualMaximum2 = actualMaximum - 1;
                } else {
                    if (scrollTextView.r) {
                        return;
                    }
                    i11 = this.f6841m;
                    actualMaximum = this.f6845q.getActualMaximum(2) + 1;
                    actualMaximum2 = this.f6845q.getActualMaximum(2);
                    z = true;
                }
                if ((!this.f6839k || actualMaximum != this.f6845q.getActualMaximum(2) + 1) && ((!this.f6839k || iC <= 0 || actualMaximum != this.f6845q.getActualMaximum(2) + 2) && (!this.f6839k || iC != 0 || actualMaximum != this.f6845q.getActualMaximum(2) + 1))) {
                }
                scrollTextView.setCyclic(z3);
                scrollTextView.g(actualMaximum, i11, actualMaximum2);
            }
            actualMaximum = (this.f6845q.getActualMaximum(2) + 1) - this.f6845q.get(2);
            if (this.f6839k && iC > 0 && iC < actualMaximum) {
                actualMaximum++;
            }
        }
        z = false;
        actualMaximum2 = actualMaximum;
        z3 = !this.f6839k ? z : z;
        scrollTextView.setCyclic(z3);
        scrollTextView.g(actualMaximum, i11, actualMaximum2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    public final String f(int i10) {
        int iC = l8.c.c(this.f6842n);
        if (iC == 0) {
            if (i10 >= 12) {
                return null;
            }
        } else if (i10 >= 13) {
            return null;
        }
        String[] strArr = this.N;
        return (iC == 0 || i10 <= iC + (-1)) ? strArr[i10] : i10 == iC ? strArr[i10 - 1] : strArr[i10 - 1];
    }

    public final String g(int i10) {
        if (i10 == 1) {
            return String.valueOf(this.f6842n);
        }
        if (i10 == 2) {
            int i11 = this.f6841m;
            if (this.f6839k) {
                return f(i11);
            }
            if (this.f6848u == null) {
                this.f6848u = getShortMonths();
            }
            String[] strArr = this.f6848u;
            return i11 < strArr.length ? strArr[i11] : "";
        }
        if (i10 != 3) {
            return "";
        }
        int i12 = this.f6840l;
        int i13 = i12 - 1;
        if (!this.f6839k) {
            return String.valueOf(i12);
        }
        String[] strArr2 = this.O;
        if (i13 > strArr2.length - 1) {
            return null;
        }
        return strArr2[i13];
    }

    public int getDayOfMonth() {
        return this.f6840l;
    }

    public TextView getDayUnit() {
        return this.f6833a;
    }

    public int getMonth() {
        return this.f6841m;
    }

    public int getYear() {
        return this.f6842n;
    }

    public final boolean h() {
        return getResources().getConfiguration().locale.getLanguage().endsWith("zh");
    }

    public final void i() {
        boolean z = this.f6839k;
        ScrollTextView scrollTextView = this.f6837e;
        ScrollTextView scrollTextView2 = this.h;
        ArrayList arrayList = this.H;
        int i10 = this.G;
        if (z && h()) {
            float f8 = this.E;
            ArrayList arrayList2 = this.F;
            scrollTextView2.n(f8, arrayList2);
            scrollTextView.n(f8, arrayList2);
        } else {
            float f9 = i10;
            scrollTextView2.n(f9, arrayList);
            scrollTextView.n(f9, arrayList);
        }
        this.f6838j.n(i10, arrayList);
    }

    public final void j(String[] strArr) {
        int i10;
        boolean z;
        DateFormat dateFormat = strArr[0].startsWith("1") ? android.text.format.DateFormat.getDateFormat(getContext()) : android.text.format.DateFormat.getMediumDateFormat(getContext());
        if (dateFormat instanceof SimpleDateFormat) {
            this.f6849v = ((SimpleDateFormat) dateFormat).toPattern();
        } else {
            this.f6849v = new String(android.text.format.DateFormat.getDateFormatOrder(getContext()));
        }
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.mc_column1Layout);
        FrameLayout frameLayout2 = (FrameLayout) findViewById(R.id.mc_column2Layout);
        FrameLayout frameLayout3 = (FrameLayout) findViewById(R.id.mc_column3Layout);
        ImageView imageView = (ImageView) findViewById(R.id.mc_divider_bar1);
        ImageView imageView2 = (ImageView) findViewById(R.id.mc_divider_bar2);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.mc_column_parent);
        linearLayout.removeAllViews();
        if (this.f6849v.contentEquals("dd\u200f/MM\u200f/y") || this.f6849v.contentEquals("d בMMM y")) {
            this.f6849v = "yy/M/d";
        }
        if (this.Q) {
            this.f6849v = "d/M/yy";
        }
        int i11 = 0;
        boolean z3 = false;
        boolean z10 = false;
        boolean z11 = false;
        boolean z12 = false;
        boolean z13 = false;
        boolean z14 = false;
        while (i11 < this.f6849v.length()) {
            char cCharAt = this.f6849v.charAt(i11);
            if (cCharAt == '\'') {
                z11 = !z11;
            }
            if (z11) {
                i10 = i11;
            } else {
                i10 = i11;
                if (cCharAt == 'd' && !z10) {
                    linearLayout.addView(frameLayout2);
                    z = true;
                    z10 = true;
                } else if ((cCharAt == 'M' || cCharAt == 'L') && !z3) {
                    linearLayout.addView(frameLayout);
                    z = true;
                    z3 = true;
                } else if (cCharAt != 'y' || z12) {
                    z = false;
                } else {
                    linearLayout.addView(frameLayout3);
                    z = true;
                    z12 = true;
                }
                if (true == z) {
                    if (!z13) {
                        linearLayout.addView(imageView);
                        z13 = true;
                    } else if (!z14) {
                        linearLayout.addView(imageView2);
                        z14 = true;
                    }
                }
            }
            i11 = i10 + 1;
        }
        if (!z3) {
            linearLayout.addView(frameLayout);
        }
        if (!z10) {
            linearLayout.addView(frameLayout2);
        }
        if (!z12) {
            linearLayout.addView(frameLayout3);
        }
        if (!h()) {
            FrameLayout frameLayout4 = (FrameLayout) findViewById(R.id.mc_column2Layout);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) frameLayout4.getLayoutParams();
            layoutParams.setMarginEnd(0);
            frameLayout4.setLayoutParams(layoutParams);
        }
        this.f6838j.post(new a());
    }

    public final void k() {
        String strReplace;
        if (this.M) {
            View viewFindViewById = findViewById(R.id.mc_column3Layout);
            View viewFindViewById2 = findViewById(R.id.mc_column1Layout);
            View viewFindViewById3 = findViewById(R.id.mc_column2Layout);
            if (viewFindViewById3 == null || viewFindViewById3.getVisibility() != 8) {
                strReplace = (g(1) + ((Object) this.f6835c.getText()) + g(2) + ((Object) this.f6834b.getText()) + g(3) + ((Object) this.f6833a.getText())).replace(" ", "").replace("廿十", "二十").replace("廿", "二十");
            } else {
                strReplace = (g(1) + ((Object) this.f6835c.getText()) + g(2) + ((Object) this.f6834b.getText())).replace(" ", "").replace("廿十", "二十").replace("廿", "二十");
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

    public final void l() throws Resources.NotFoundException {
        b bVar = new b(1);
        int i10 = this.f6842n;
        int i11 = this.f6843o;
        int i12 = this.f6844p - i11;
        int i13 = this.z;
        this.f6838j.i(bVar, i10 - i11, i12 + 1, i13, i12, false);
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.L) {
            int width = getWidth();
            int width2 = this.I.getWidth() - (this.J * 2);
            int i10 = (width - width2) / 2;
            float f8 = i10;
            float f9 = 0;
            float f10 = i10 + width2;
            Paint paint = this.K;
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
        this.f6842n = savedState.getYear();
        this.f6841m = savedState.getMonth();
        this.f6840l = savedState.getDay();
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.f6842n, this.f6841m, this.f6840l, null);
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            String[] shortMonths = getShortMonths();
            DateFormat dateFormat = shortMonths[0].startsWith("1") ? android.text.format.DateFormat.getDateFormat(getContext()) : android.text.format.DateFormat.getMediumDateFormat(getContext());
            String pattern = dateFormat instanceof SimpleDateFormat ? ((SimpleDateFormat) dateFormat).toPattern() : new String(android.text.format.DateFormat.getDateFormatOrder(getContext()));
            this.f6848u = shortMonths;
            if (this.f6849v.equals(pattern)) {
                return;
            }
            j(this.f6848u);
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.f6837e.setEnabled(z);
        this.h.setEnabled(z);
        this.f6838j.setEnabled(z);
    }

    public void setIsDrawFading(boolean z) {
        this.f6838j.setIsDrawFading(z);
        this.h.setIsDrawFading(z);
        this.f6837e.setIsDrawFading(z);
    }

    public void setIsDrawLine(boolean z) {
        this.L = z;
    }

    public void setLunar(boolean z) {
        int i10;
        boolean z3;
        int[] iArrD;
        int i11;
        if (this.f6839k == z) {
            return;
        }
        this.f6839k = z;
        int[] iArr = {this.f6842n, this.f6841m + 1, this.f6840l, 0};
        int i12 = iArr[0];
        int iC = l8.c.c(i12);
        int iC2 = l8.c.c(iArr[0] - 1);
        if (this.f6839k) {
            iArrD = l8.c.e(iArr[0], iArr[1], iArr[2]);
            int i13 = iArrD[0];
            if ((i12 != i13 && iC2 != 0 && (iArrD[3] == 1 || iArrD[1] > iC2)) || (i12 == i13 && iC != 0 && (iArrD[3] == 1 || iArrD[1] > iC))) {
                iArrD[1] = iArrD[1] + 1;
            }
            this.f6833a.setAlpha(0.0f);
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
                this.f6833a.setAlpha(1.0f);
                iArrD = l8.c.d(iArr[0], i10, iArr[2], z3);
            }
            z3 = false;
            this.f6833a.setAlpha(1.0f);
            iArrD = l8.c.d(iArr[0], i10, iArr[2], z3);
        }
        i();
        int i15 = iArrD[0];
        int i16 = iArrD[1] - 1;
        if (i16 < 0) {
            i16 = 12;
        }
        int i17 = iArrD[2];
        int i18 = this.f6843o;
        if (i15 >= i18) {
            i18 = i15;
        }
        this.f6842n = i18;
        int i19 = this.f6844p;
        if (i15 > i19) {
            i15 = i19;
        }
        this.f6842n = i15;
        this.f6841m = i16;
        this.f6840l = i17;
        this.f6848u = null;
        this.f6848u = getShortMonths();
        ScrollTextView scrollTextView = this.f6838j;
        ScrollTextView.k kVar = scrollTextView.f6988m;
        if (kVar != null) {
            kVar.f7011d.forceFinished(true);
        }
        ScrollTextView scrollTextView2 = this.h;
        ScrollTextView.k kVar2 = scrollTextView2.f6988m;
        if (kVar2 != null) {
            kVar2.f7011d.forceFinished(true);
        }
        ScrollTextView scrollTextView3 = this.f6837e;
        ScrollTextView.k kVar3 = scrollTextView3.f6988m;
        if (kVar3 != null) {
            kVar3.f7011d.forceFinished(true);
        }
        if (this.A != getYearMonths()) {
            int yearMonths = getYearMonths();
            this.A = yearMonths;
            scrollTextView2.f(yearMonths);
        }
        if (this.B != getMonthDays()) {
            this.B = getMonthDays();
            scrollTextView3.f(getMonthDays());
        }
        scrollTextView.h(this.f6842n - this.f6843o, true);
        this.f6841m = i16;
        scrollTextView2.h(i16, true);
        scrollTextView3.h(this.f6840l - 1, true);
        setLeapUnitVisibility(this.f6841m);
    }

    public void setMaxDate(long j10) throws Resources.NotFoundException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j10);
        this.r = calendar;
        this.f6844p = calendar.get(1);
        l();
        this.f6846s = -1;
        setMonthRange(this.f6842n);
        this.f6847t = -1;
        setDayRange(this.f6841m);
    }

    public void setMinDate(long j10) throws Resources.NotFoundException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j10);
        this.f6845q = calendar;
        this.f6843o = calendar.get(1);
        l();
        this.f6846s = -1;
        setMonthRange(this.f6842n);
        this.f6847t = -1;
        setDayRange(this.f6841m);
    }

    public void setShowDayColumn(boolean z) {
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.mc_column2Layout);
        if (frameLayout != null) {
            frameLayout.setVisibility(z ? 0 : 8);
            k();
            this.f6837e.setVisibility(z ? 0 : 8);
        }
    }
}
