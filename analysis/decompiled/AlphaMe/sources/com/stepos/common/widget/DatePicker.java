package com.stepos.common.widget;

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
import androidx.appcompat.app.C0186l;
import com.stepos.alphame.R;
import com.stepos.alphame.awareness.AwarenessDataItem;
import com.stepos.alphame.utils.Property;
import h.RunnableC0583a;
import i2.AbstractC0620a;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

/* loaded from: classes.dex */
public class DatePicker extends FrameLayout {

    /* renamed from: A, reason: collision with root package name */
    public final float f11520A;

    /* renamed from: B, reason: collision with root package name */
    public final int f11521B;

    /* renamed from: C, reason: collision with root package name */
    public final ArrayList f11522C;

    /* renamed from: D, reason: collision with root package name */
    public final int f11523D;

    /* renamed from: E, reason: collision with root package name */
    public final ArrayList f11524E;

    /* renamed from: F, reason: collision with root package name */
    public final LinearLayout f11525F;

    /* renamed from: G, reason: collision with root package name */
    public final int f11526G;

    /* renamed from: H, reason: collision with root package name */
    public final Paint f11527H;

    /* renamed from: I, reason: collision with root package name */
    public boolean f11528I;

    /* renamed from: J, reason: collision with root package name */
    public final boolean f11529J;

    /* renamed from: K, reason: collision with root package name */
    public final String[] f11530K;

    /* renamed from: L, reason: collision with root package name */
    public final String[] f11531L;

    /* renamed from: M, reason: collision with root package name */
    public final String[] f11532M;

    /* renamed from: N, reason: collision with root package name */
    public final boolean f11533N;

    /* renamed from: O, reason: collision with root package name */
    public int f11534O;

    /* renamed from: a, reason: collision with root package name */
    public final TextView f11535a;

    /* renamed from: b, reason: collision with root package name */
    public final TextView f11536b;

    /* renamed from: c, reason: collision with root package name */
    public final TextView f11537c;

    /* renamed from: d, reason: collision with root package name */
    public final TextView f11538d;

    /* renamed from: e, reason: collision with root package name */
    public final ScrollTextView f11539e;

    /* renamed from: f, reason: collision with root package name */
    public final ScrollTextView f11540f;

    /* renamed from: g, reason: collision with root package name */
    public final ScrollTextView f11541g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f11542h;

    /* renamed from: i, reason: collision with root package name */
    public int f11543i;

    /* renamed from: j, reason: collision with root package name */
    public int f11544j;

    /* renamed from: k, reason: collision with root package name */
    public int f11545k;

    /* renamed from: l, reason: collision with root package name */
    public int f11546l;

    /* renamed from: m, reason: collision with root package name */
    public int f11547m;

    /* renamed from: n, reason: collision with root package name */
    public Calendar f11548n;

    /* renamed from: o, reason: collision with root package name */
    public Calendar f11549o;

    /* renamed from: p, reason: collision with root package name */
    public int f11550p;

    /* renamed from: q, reason: collision with root package name */
    public int f11551q;

    /* renamed from: r, reason: collision with root package name */
    public String[] f11552r;

    /* renamed from: s, reason: collision with root package name */
    public String f11553s;

    /* renamed from: t, reason: collision with root package name */
    public final Object f11554t;

    /* renamed from: u, reason: collision with root package name */
    public volatile Locale f11555u;

    /* renamed from: v, reason: collision with root package name */
    public String[] f11556v;

    /* renamed from: w, reason: collision with root package name */
    public final int f11557w;

    /* renamed from: x, reason: collision with root package name */
    public int f11558x;

    /* renamed from: y, reason: collision with root package name */
    public int f11559y;

    /* renamed from: z, reason: collision with root package name */
    public final float f11560z;

    public DatePicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f11542h = false;
        this.f11554t = new Object();
        this.f11557w = 5;
        this.f11529J = false;
        this.f11533N = false;
        this.f11534O = 0;
        this.f11533N = context.getResources().getConfiguration().getLayoutDirection() == 1;
        ArrayList arrayList = new ArrayList();
        this.f11522C = arrayList;
        arrayList.add(Float.valueOf(context.getResources().getDimension(R.dimen.mc_picker_normal_word_size_one)));
        arrayList.add(Float.valueOf(context.getResources().getDimension(R.dimen.mc_picker_normal_word_size_two)));
        this.f11521B = context.getResources().getDimensionPixelOffset(R.dimen.mc_picker_selected_word_size);
        ArrayList arrayList2 = new ArrayList();
        this.f11524E = arrayList2;
        arrayList2.add(Float.valueOf(context.getResources().getDimension(R.dimen.mc_picker_normal_number_size_one)));
        arrayList2.add(Float.valueOf(context.getResources().getDimension(R.dimen.mc_picker_normal_number_size_two)));
        this.f11523D = Math.min(getContext().getResources().getDimensionPixelOffset(R.dimen.mc_picker_selected_number_max_size), getContext().getResources().getDimensionPixelOffset(R.dimen.mc_picker_selected_number_size));
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0620a.f13020b);
        this.f11546l = typedArrayObtainStyledAttributes.getInt(8, 1900);
        this.f11547m = typedArrayObtainStyledAttributes.getInt(1, 2099);
        int i4 = 2;
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(2, R.layout.mc_date_picker);
        int i5 = typedArrayObtainStyledAttributes.getInt(9, 5);
        this.f11557w = i5;
        float dimension = typedArrayObtainStyledAttributes.getDimension(6, this.f11520A);
        this.f11520A = dimension;
        float dimension2 = typedArrayObtainStyledAttributes.getDimension(5, this.f11560z);
        this.f11560z = dimension2;
        typedArrayObtainStyledAttributes.recycle();
        View.inflate(getContext(), resourceId, this);
        this.f11538d = (TextView) findViewById(R.id.mc_leap);
        TextView textView = (TextView) findViewById(R.id.mc_scroll1_text);
        this.f11536b = textView;
        if (textView != null) {
            textView.setText(R.string.mc_date_time_month);
        }
        TextView textView2 = (TextView) findViewById(R.id.mc_scroll2_text);
        this.f11535a = textView2;
        if (textView2 != null) {
            textView2.setText(R.string.mc_date_time_day);
        }
        TextView textView3 = (TextView) findViewById(R.id.mc_scroll3_text);
        this.f11537c = textView3;
        if (textView3 != null) {
            textView3.setText(R.string.mc_date_time_year);
        }
        Calendar calendar = Calendar.getInstance();
        this.f11545k = calendar.get(1);
        this.f11544j = calendar.get(2);
        this.f11543i = calendar.get(5);
        int actualMaximum = calendar.getActualMaximum(5);
        this.f11525F = (LinearLayout) findViewById(R.id.mc_column_parent);
        ScrollTextView scrollTextView = (ScrollTextView) findViewById(R.id.mc_scroll2);
        this.f11539e = scrollTextView;
        if (dimension != Property.DEFAULT_FLOAT_VALUE && dimension2 != Property.DEFAULT_FLOAT_VALUE) {
            scrollTextView.l(scrollTextView.f11756i, scrollTextView.f11755h, (int) dimension, (int) dimension2);
        }
        int i6 = 3;
        scrollTextView.i(new C0186l(i6, i6, this), this.f11543i - 1, actualMaximum, i5, actualMaximum - 1, true);
        ScrollTextView scrollTextView2 = (ScrollTextView) findViewById(R.id.mc_scroll1);
        this.f11540f = scrollTextView2;
        if (dimension != Property.DEFAULT_FLOAT_VALUE && dimension2 != Property.DEFAULT_FLOAT_VALUE) {
            scrollTextView2.l(scrollTextView2.f11756i, scrollTextView2.f11755h, (int) dimension, (int) dimension2);
        }
        this.f11552r = getShortMonths();
        scrollTextView2.i(new C0186l(i4, i6, this), this.f11544j, 12, i5, 11, true);
        ScrollTextView scrollTextView3 = (ScrollTextView) findViewById(R.id.mc_scroll3);
        this.f11541g = scrollTextView3;
        if (dimension != Property.DEFAULT_FLOAT_VALUE && dimension2 != Property.DEFAULT_FLOAT_VALUE) {
            scrollTextView3.l(scrollTextView3.f11756i, scrollTextView3.f11755h, (int) dimension, (int) dimension2);
        }
        i();
        l();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Calendar calendar2 = Calendar.getInstance();
            this.f11548n = calendar2;
            calendar2.setTime(simpleDateFormat.parse(this.f11546l + "-01-01"));
        } catch (ParseException e4) {
            e4.printStackTrace();
        }
        try {
            Calendar calendar3 = Calendar.getInstance();
            this.f11549o = calendar3;
            calendar3.setTime(simpleDateFormat.parse(this.f11547m + "-12-31"));
        } catch (ParseException e5) {
            e5.printStackTrace();
        }
        j(this.f11552r);
        boolean zH = h();
        this.f11535a.setVisibility(zH ? 0 : 8);
        this.f11536b.setVisibility(zH ? 0 : 8);
        this.f11537c.setVisibility(zH ? 0 : 8);
        TextView textView4 = (TextView) findViewById(R.id.mc_scroll1_text);
        this.f11536b = textView4;
        if (textView4 != null) {
            textView4.setText(R.string.mc_date_time_month);
        }
        TextView textView5 = (TextView) findViewById(R.id.mc_scroll2_text);
        this.f11535a = textView5;
        if (textView5 != null) {
            textView5.setText(R.string.mc_date_time_day);
        }
        TextView textView6 = (TextView) findViewById(R.id.mc_scroll3_text);
        this.f11537c = textView6;
        if (textView6 != null) {
            textView6.setText(R.string.mc_date_time_year);
        }
        if (!isEnabled()) {
            setEnabled(false);
        }
        this.f11526G = context.getResources().getDimensionPixelSize(R.dimen.mc_custom_time_picker_line_width_padding);
        Paint paint = new Paint();
        this.f11527H = paint;
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(AbstractC0620a.f13037s);
        int i7 = typedArrayObtainStyledAttributes2.getInt(11, context.getResources().getColor(R.color.mc_custom_date_picker_selected_gregorian_color));
        typedArrayObtainStyledAttributes2.recycle();
        paint.setColor(i7);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(context.getResources().getDimensionPixelSize(R.dimen.mc_custom_time_picker_line_stroke_width));
        this.f11528I = false;
        setWillNotDraw(false);
        this.f11530K = getResources().getStringArray(R.array.mc_custom_time_picker_lunar_month);
        this.f11531L = getResources().getStringArray(R.array.mc_custom_time_picker_lunar_day);
        String str = String.format(Locale.getDefault(), "%d", 0);
        this.f11532M = new String[100];
        for (int i8 = 0; i8 < 100; i8++) {
            this.f11532M[i8] = String.format(Locale.getDefault(), "%d", Integer.valueOf(i8));
            if (i8 <= 9) {
                String[] strArr = this.f11532M;
                StringBuilder sbS = B0.g.s(str);
                sbS.append(this.f11532M[i8]);
                strArr[i8] = sbS.toString();
            }
        }
        this.f11538d.setText(getResources().getString(R.string.mc_time_picker_leap));
        this.f11538d.setVisibility(8);
        if (Build.DEVICE.equals("mx4pro")) {
            this.f11541g.d(new C0494j(this, 0));
            this.f11540f.d(new C0494j(this, 1));
            this.f11539e.d(new C0494j(this, i4));
        }
        AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
        if (accessibilityManager != null) {
            this.f11529J = accessibilityManager.isEnabled();
        }
    }

    private Calendar getCurrentCalendar() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(5, 1);
        calendar.set(1, this.f11545k);
        calendar.set(2, this.f11544j);
        return calendar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getMonthDays() {
        if (!this.f11542h) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(5, 1);
            calendar.set(1, this.f11545k);
            calendar.set(2, this.f11544j);
            return calendar.getActualMaximum(5);
        }
        int i4 = this.f11544j;
        int iC = m2.d.c(this.f11545k);
        boolean z4 = false;
        if (iC != 0) {
            z4 = iC == i4;
        }
        if (iC == 0 || (iC != 0 && this.f11544j < iC)) {
            i4++;
        }
        return m2.d.b(this.f11545k, i4, z4);
    }

    private String[] getShortMonths() {
        int iCeil;
        Locale locale = Locale.getDefault();
        if (!locale.equals(this.f11555u) || this.f11556v == null) {
            synchronized (this.f11554t) {
                try {
                    if (!locale.equals(this.f11555u)) {
                        this.f11556v = new String[12];
                        for (int i4 = 0; i4 < 12; i4++) {
                            this.f11556v[i4] = DateUtils.getMonthString(i4, 20);
                        }
                        if (this.f11556v[0].startsWith("1")) {
                            int i5 = 0;
                            while (true) {
                                String[] strArr = this.f11556v;
                                if (i5 >= strArr.length) {
                                    break;
                                }
                                int i6 = i5 + 1;
                                strArr[i5] = String.valueOf(i6);
                                if (i5 < 9) {
                                    this.f11556v[i5] = "0" + this.f11556v[i5];
                                }
                                i5 = i6;
                            }
                        }
                        this.f11555u = locale;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        ScrollTextView scrollTextView = this.f11540f;
        if (scrollTextView != null && scrollTextView.getWidth() > 0 && this.f11556v != null) {
            int i7 = 0;
            while (true) {
                String[] strArr2 = this.f11556v;
                if (i7 >= strArr2.length) {
                    break;
                }
                ScrollTextView scrollTextView2 = this.f11540f;
                String str = strArr2[i7];
                scrollTextView2.getClass();
                if (str != null && str.length() > 0) {
                    int length = str.length();
                    Paint paint = scrollTextView2.f11748a;
                    paint.setTextSize(scrollTextView2.f11756i);
                    paint.getTextWidths(str, new float[length]);
                    iCeil = 0;
                    for (int i8 = 0; i8 < length; i8++) {
                        iCeil += (int) Math.ceil(r6[i8]);
                    }
                } else {
                    iCeil = 0;
                }
                if (iCeil > this.f11540f.getWidth()) {
                    this.f11556v = new String[]{"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
                    break;
                }
                i7++;
            }
        }
        return this.f11556v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getYearMonths() {
        return (!this.f11542h || m2.d.c(this.f11545k) == 0) ? 12 : 13;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0071 A[PHI: r1 r2
      0x0071: PHI (r1v11 int) = (r1v3 int), (r1v4 int), (r1v12 int) binds: [B:66:0x014e, B:57:0x0119, B:23:0x006f] A[DONT_GENERATE, DONT_INLINE]
      0x0071: PHI (r2v19 int) = (r2v6 int), (r2v10 int), (r2v22 int) binds: [B:66:0x014e, B:57:0x0119, B:23:0x006f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0073 A[PHI: r1 r2
      0x0073: PHI (r1v8 int) = (r1v3 int), (r1v4 int), (r1v12 int) binds: [B:66:0x014e, B:57:0x0119, B:23:0x006f] A[DONT_GENERATE, DONT_INLINE]
      0x0073: PHI (r2v16 int) = (r2v6 int), (r2v10 int), (r2v22 int) binds: [B:66:0x014e, B:57:0x0119, B:23:0x006f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00b9 A[PHI: r0 r1 r2
      0x00b9: PHI (r0v10 int) = (r0v5 int), (r0v11 int) binds: [B:74:0x017c, B:37:0x00b5] A[DONT_GENERATE, DONT_INLINE]
      0x00b9: PHI (r1v5 int) = (r1v2 int), (r1v6 int) binds: [B:74:0x017c, B:37:0x00b5] A[DONT_GENERATE, DONT_INLINE]
      0x00b9: PHI (r2v12 int) = (r2v2 int), (r2v13 int) binds: [B:74:0x017c, B:37:0x00b5] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void setDayRange(int r10) {
        /*
            Method dump skipped, instructions count: 400
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.common.widget.DatePicker.setDayRange(int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLeapUnitVisibility(int i4) {
        int iC;
        boolean z4 = this.f11542h;
        TextView textView = this.f11538d;
        if (!z4 || !h() || ((iC = m2.d.c(this.f11545k)) != 0 ? i4 >= 13 : i4 >= 12) || iC == 0 || i4 <= iC - 1 || i4 != iC) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00d0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void setMonthRange(int r10) {
        /*
            Method dump skipped, instructions count: 247
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.common.widget.DatePicker.setMonthRange(int):void");
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchRestoreInstanceState(SparseArray sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    public final String f(int i4) {
        int iC = m2.d.c(this.f11545k);
        if (iC == 0) {
            if (i4 >= 12) {
                return null;
            }
        } else if (i4 >= 13) {
            return null;
        }
        String[] strArr = this.f11530K;
        return (iC == 0 || i4 <= iC + (-1)) ? strArr[i4] : i4 == iC ? strArr[i4 - 1] : strArr[i4 - 1];
    }

    public final String g(int i4) {
        if (i4 == 1) {
            return String.valueOf(this.f11545k);
        }
        if (i4 == 2) {
            int i5 = this.f11544j;
            if (this.f11542h) {
                return f(i5);
            }
            if (this.f11552r == null) {
                this.f11552r = getShortMonths();
            }
            String[] strArr = this.f11552r;
            return i5 < strArr.length ? strArr[i5] : "";
        }
        if (i4 != 3) {
            return "";
        }
        int i6 = this.f11543i;
        int i7 = i6 - 1;
        if (!this.f11542h) {
            return String.valueOf(i6);
        }
        String[] strArr2 = this.f11531L;
        if (i7 > strArr2.length - 1) {
            return null;
        }
        return strArr2[i7];
    }

    public int getDayOfMonth() {
        return this.f11543i;
    }

    public TextView getDayUnit() {
        return this.f11535a;
    }

    public int getMonth() {
        return this.f11544j;
    }

    public int getYear() {
        return this.f11545k;
    }

    public final boolean h() {
        return getResources().getConfiguration().locale.getLanguage().endsWith("zh");
    }

    public final void i() {
        boolean z4 = this.f11542h;
        ScrollTextView scrollTextView = this.f11539e;
        ScrollTextView scrollTextView2 = this.f11540f;
        ArrayList arrayList = this.f11524E;
        int i4 = this.f11523D;
        if (z4 && h()) {
            float f4 = this.f11521B;
            ArrayList arrayList2 = this.f11522C;
            scrollTextView2.n(f4, arrayList2);
            scrollTextView.n(f4, arrayList2);
        } else {
            float f5 = i4;
            scrollTextView2.n(f5, arrayList);
            scrollTextView.n(f5, arrayList);
        }
        this.f11541g.n(i4, arrayList);
    }

    public final void j(String[] strArr) {
        boolean z4;
        boolean z5;
        DateFormat dateFormat = strArr[0].startsWith("1") ? android.text.format.DateFormat.getDateFormat(getContext()) : android.text.format.DateFormat.getMediumDateFormat(getContext());
        if (dateFormat instanceof SimpleDateFormat) {
            this.f11553s = ((SimpleDateFormat) dateFormat).toPattern();
        } else {
            this.f11553s = new String(android.text.format.DateFormat.getDateFormatOrder(getContext()));
        }
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.mc_column1Layout);
        FrameLayout frameLayout2 = (FrameLayout) findViewById(R.id.mc_column2Layout);
        FrameLayout frameLayout3 = (FrameLayout) findViewById(R.id.mc_column3Layout);
        ImageView imageView = (ImageView) findViewById(R.id.mc_divider_bar1);
        ImageView imageView2 = (ImageView) findViewById(R.id.mc_divider_bar2);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.mc_column_parent);
        linearLayout.removeAllViews();
        if (this.f11553s.contentEquals("dd\u200f/MM\u200f/y") || this.f11553s.contentEquals("d בMMM y")) {
            this.f11553s = "yy/M/d";
        }
        if (this.f11533N) {
            this.f11553s = "d/M/yy";
        }
        int i4 = 0;
        boolean z6 = false;
        boolean z7 = false;
        boolean z8 = false;
        boolean z9 = false;
        boolean z10 = false;
        boolean z11 = false;
        while (i4 < this.f11553s.length()) {
            char cCharAt = this.f11553s.charAt(i4);
            if (cCharAt == '\'') {
                z8 = !z8;
            }
            if (z8) {
                z4 = z8;
            } else {
                z4 = z8;
                if (cCharAt == 'd' && !z7) {
                    linearLayout.addView(frameLayout2);
                    z5 = true;
                    z7 = true;
                } else if ((cCharAt == 'M' || cCharAt == 'L') && !z6) {
                    linearLayout.addView(frameLayout);
                    z5 = true;
                    z6 = true;
                } else if (cCharAt != 'y' || z9) {
                    z5 = false;
                } else {
                    linearLayout.addView(frameLayout3);
                    z5 = true;
                    z9 = true;
                }
                if (true == z5) {
                    if (!z10) {
                        linearLayout.addView(imageView);
                        z10 = true;
                    } else if (!z11) {
                        linearLayout.addView(imageView2);
                        z11 = true;
                    }
                }
            }
            i4++;
            z8 = z4;
        }
        if (!z6) {
            linearLayout.addView(frameLayout);
        }
        if (!z7) {
            linearLayout.addView(frameLayout2);
        }
        if (!z9) {
            linearLayout.addView(frameLayout3);
        }
        if (!h()) {
            FrameLayout frameLayout4 = (FrameLayout) findViewById(R.id.mc_column2Layout);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) frameLayout4.getLayoutParams();
            layoutParams.setMarginEnd(0);
            frameLayout4.setLayoutParams(layoutParams);
        }
        this.f11541g.post(new RunnableC0583a(19, this));
    }

    public final void k() {
        String strReplace;
        if (this.f11529J) {
            View viewFindViewById = findViewById(R.id.mc_column3Layout);
            View viewFindViewById2 = findViewById(R.id.mc_column1Layout);
            View viewFindViewById3 = findViewById(R.id.mc_column2Layout);
            if (viewFindViewById3 == null || viewFindViewById3.getVisibility() != 8) {
                strReplace = (g(1) + ((Object) this.f11537c.getText()) + g(2) + ((Object) this.f11536b.getText()) + g(3) + ((Object) this.f11535a.getText())).replace(AwarenessDataItem.PERMISSION_SPLITTER, "").replace("廿十", "二十").replace("廿", "二十");
            } else {
                strReplace = (g(1) + ((Object) this.f11537c.getText()) + g(2) + ((Object) this.f11536b.getText())).replace(AwarenessDataItem.PERMISSION_SPLITTER, "").replace("廿十", "二十").replace("廿", "二十");
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
        C0186l c0186l = new C0186l(1, 3, this);
        int i4 = this.f11545k;
        int i5 = this.f11546l;
        int i6 = i4 - i5;
        int i7 = this.f11547m - i5;
        this.f11541g.i(c0186l, i6, i7 + 1, this.f11557w, i7, false);
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f11528I) {
            int width = getWidth();
            int width2 = this.f11525F.getWidth() - (this.f11526G * 2);
            int i4 = (width - width2) / 2;
            float f4 = i4;
            float f5 = 0;
            float f6 = i4 + width2;
            Paint paint = this.f11527H;
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
        this.f11545k = savedState.f11561a;
        this.f11544j = savedState.f11562b;
        this.f11543i = savedState.f11563c;
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.f11545k, this.f11544j, this.f11543i);
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z4) {
        super.onWindowFocusChanged(z4);
        if (z4) {
            String[] shortMonths = getShortMonths();
            DateFormat dateFormat = shortMonths[0].startsWith("1") ? android.text.format.DateFormat.getDateFormat(getContext()) : android.text.format.DateFormat.getMediumDateFormat(getContext());
            String pattern = dateFormat instanceof SimpleDateFormat ? ((SimpleDateFormat) dateFormat).toPattern() : new String(android.text.format.DateFormat.getDateFormatOrder(getContext()));
            this.f11552r = shortMonths;
            if (this.f11553s.equals(pattern)) {
                return;
            }
            j(this.f11552r);
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z4) {
        super.setEnabled(z4);
        this.f11539e.setEnabled(z4);
        this.f11540f.setEnabled(z4);
        this.f11541g.setEnabled(z4);
    }

    public void setIsDrawFading(boolean z4) {
        this.f11541g.setIsDrawFading(z4);
        this.f11540f.setIsDrawFading(z4);
        this.f11539e.setIsDrawFading(z4);
    }

    public void setIsDrawLine(boolean z4) {
        this.f11528I = z4;
    }

    public void setLunar(boolean z4) {
        int i4;
        boolean z5;
        int[] iArrD;
        int i5;
        if (this.f11542h == z4) {
            return;
        }
        this.f11542h = z4;
        int[] iArr = {this.f11545k, this.f11544j + 1, this.f11543i, 0};
        int i6 = iArr[0];
        int iC = m2.d.c(i6);
        int iC2 = m2.d.c(iArr[0] - 1);
        if (this.f11542h) {
            iArrD = m2.d.e(iArr[0], iArr[1], iArr[2]);
            int i7 = iArrD[0];
            if ((i6 != i7 && iC2 != 0 && (iArrD[3] == 1 || iArrD[1] > iC2)) || (i6 == i7 && iC != 0 && (iArrD[3] == 1 || iArrD[1] > iC))) {
                iArrD[1] = iArrD[1] + 1;
            }
            this.f11535a.setAlpha(Property.DEFAULT_FLOAT_VALUE);
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
                this.f11535a.setAlpha(1.0f);
                iArrD = m2.d.d(iArr[0], i4, iArr[2], z5);
            }
            z5 = false;
            this.f11535a.setAlpha(1.0f);
            iArrD = m2.d.d(iArr[0], i4, iArr[2], z5);
        }
        i();
        int i9 = iArrD[0];
        int i10 = iArrD[1] - 1;
        if (i10 < 0) {
            i10 = 12;
        }
        int i11 = iArrD[2];
        int i12 = this.f11546l;
        if (i9 >= i12) {
            i12 = i9;
        }
        this.f11545k = i12;
        int i13 = this.f11547m;
        if (i9 > i13) {
            i9 = i13;
        }
        this.f11545k = i9;
        this.f11544j = i10;
        this.f11543i = i11;
        this.f11552r = null;
        this.f11552r = getShortMonths();
        ScrollTextView scrollTextView = this.f11541g;
        D d4 = scrollTextView.f11757j;
        if (d4 != null) {
            d4.f11514d.forceFinished(true);
        }
        ScrollTextView scrollTextView2 = this.f11540f;
        D d5 = scrollTextView2.f11757j;
        if (d5 != null) {
            d5.f11514d.forceFinished(true);
        }
        ScrollTextView scrollTextView3 = this.f11539e;
        D d6 = scrollTextView3.f11757j;
        if (d6 != null) {
            d6.f11514d.forceFinished(true);
        }
        if (this.f11558x != getYearMonths()) {
            int yearMonths = getYearMonths();
            this.f11558x = yearMonths;
            scrollTextView2.f(yearMonths);
        }
        if (this.f11559y != getMonthDays()) {
            this.f11559y = getMonthDays();
            scrollTextView3.f(getMonthDays());
        }
        scrollTextView.h(this.f11545k - this.f11546l, true);
        this.f11544j = i10;
        scrollTextView2.h(i10, true);
        scrollTextView3.h(this.f11543i - 1, true);
        setLeapUnitVisibility(this.f11544j);
    }

    public void setMaxDate(long j4) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j4);
        this.f11549o = calendar;
        this.f11547m = calendar.get(1);
        l();
        this.f11550p = -1;
        setMonthRange(this.f11545k);
        this.f11551q = -1;
        setDayRange(this.f11544j);
    }

    public void setMinDate(long j4) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j4);
        this.f11548n = calendar;
        this.f11546l = calendar.get(1);
        l();
        this.f11550p = -1;
        setMonthRange(this.f11545k);
        this.f11551q = -1;
        setDayRange(this.f11544j);
    }

    public void setShowDayColumn(boolean z4) {
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.mc_column2Layout);
        if (frameLayout != null) {
            frameLayout.setVisibility(z4 ? 0 : 8);
            k();
            this.f11539e.setVisibility(z4 ? 0 : 8);
        }
    }

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new C0495k();

        /* renamed from: a, reason: collision with root package name */
        public final int f11561a;

        /* renamed from: b, reason: collision with root package name */
        public final int f11562b;

        /* renamed from: c, reason: collision with root package name */
        public final int f11563c;

        public SavedState(Parcelable parcelable, int i4, int i5, int i6) {
            super(parcelable);
            this.f11561a = i4;
            this.f11562b = i5;
            this.f11563c = i6;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i4) {
            super.writeToParcel(parcel, i4);
            parcel.writeInt(this.f11561a);
            parcel.writeInt(this.f11562b);
            parcel.writeInt(this.f11563c);
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f11561a = parcel.readInt();
            this.f11562b = parcel.readInt();
            this.f11563c = parcel.readInt();
        }
    }
}
