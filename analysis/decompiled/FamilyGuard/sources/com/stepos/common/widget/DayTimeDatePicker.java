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
import com.stepos.common.widget.ScrollTextView;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.libpag.BuildConfig;

/* loaded from: classes.dex */
public class DayTimeDatePicker extends FrameLayout {

    /* renamed from: A, reason: collision with root package name */
    private LinearLayout f13922A;

    /* renamed from: B, reason: collision with root package name */
    private int f13923B;

    /* renamed from: C, reason: collision with root package name */
    private int f13924C;

    /* renamed from: D, reason: collision with root package name */
    private int f13925D;

    /* renamed from: E, reason: collision with root package name */
    private Paint f13926E;

    /* renamed from: F, reason: collision with root package name */
    private boolean f13927F;

    /* renamed from: G, reason: collision with root package name */
    private boolean f13928G;

    /* renamed from: H, reason: collision with root package name */
    String[] f13929H;

    /* renamed from: I, reason: collision with root package name */
    String[] f13930I;

    /* renamed from: J, reason: collision with root package name */
    String f13931J;

    /* renamed from: K, reason: collision with root package name */
    boolean f13932K;

    /* renamed from: L, reason: collision with root package name */
    private Typeface f13933L;

    /* renamed from: M, reason: collision with root package name */
    private Typeface f13934M;

    /* renamed from: Q, reason: collision with root package name */
    String[] f13935Q;

    /* renamed from: R, reason: collision with root package name */
    private String f13936R;

    /* renamed from: S, reason: collision with root package name */
    private String f13937S;

    /* renamed from: a, reason: collision with root package name */
    private TextView f13938a;

    /* renamed from: b, reason: collision with root package name */
    private TextView f13939b;

    /* renamed from: c, reason: collision with root package name */
    private TextView f13940c;

    /* renamed from: d, reason: collision with root package name */
    private ScrollTextView f13941d;

    /* renamed from: e, reason: collision with root package name */
    private ScrollTextView f13942e;

    /* renamed from: f, reason: collision with root package name */
    private ScrollTextView f13943f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f13944g;

    /* renamed from: h, reason: collision with root package name */
    private int f13945h;

    /* renamed from: i, reason: collision with root package name */
    private int f13946i;

    /* renamed from: j, reason: collision with root package name */
    private int f13947j;

    /* renamed from: k, reason: collision with root package name */
    private int f13948k;

    /* renamed from: l, reason: collision with root package name */
    private int f13949l;

    /* renamed from: m, reason: collision with root package name */
    private int f13950m;

    /* renamed from: n, reason: collision with root package name */
    private int f13951n;

    /* renamed from: o, reason: collision with root package name */
    private Calendar f13952o;

    /* renamed from: p, reason: collision with root package name */
    private Calendar f13953p;

    /* renamed from: q, reason: collision with root package name */
    String[] f13954q;

    /* renamed from: r, reason: collision with root package name */
    String[] f13955r;

    /* renamed from: s, reason: collision with root package name */
    private int f13956s;

    /* renamed from: t, reason: collision with root package name */
    private int f13957t;

    /* renamed from: u, reason: collision with root package name */
    private float f13958u;

    /* renamed from: v, reason: collision with root package name */
    private float f13959v;

    /* renamed from: w, reason: collision with root package name */
    private int f13960w;

    /* renamed from: x, reason: collision with root package name */
    private List<Float> f13961x;

    /* renamed from: y, reason: collision with root package name */
    private int f13962y;

    /* renamed from: z, reason: collision with root package name */
    private List<Float> f13963z;

    class a implements ScrollTextView.h {
        a() {
        }

        @Override // com.stepos.common.widget.ScrollTextView.h
        public void a(ScrollTextView scrollTextView) {
            scrollTextView.setIsDrawFading(true);
        }

        @Override // com.stepos.common.widget.ScrollTextView.h
        public void b(ScrollTextView scrollTextView) {
        }
    }

    class b implements ScrollTextView.h {
        b() {
        }

        @Override // com.stepos.common.widget.ScrollTextView.h
        public void a(ScrollTextView scrollTextView) {
            scrollTextView.setIsDrawFading(true);
        }

        @Override // com.stepos.common.widget.ScrollTextView.h
        public void b(ScrollTextView scrollTextView) {
        }
    }

    class c implements ScrollTextView.h {
        c() {
        }

        @Override // com.stepos.common.widget.ScrollTextView.h
        public void a(ScrollTextView scrollTextView) {
            DayTimeDatePicker.this.setIsDrawFading(true);
        }

        @Override // com.stepos.common.widget.ScrollTextView.h
        public void b(ScrollTextView scrollTextView) {
        }
    }

    private class d implements ScrollTextView.e {

        /* renamed from: a, reason: collision with root package name */
        int f13967a;

        d(int i5) {
            this.f13967a = i5;
        }

        @Override // com.stepos.common.widget.ScrollTextView.e
        public void a(View view, int i5, int i6) {
            int i7 = this.f13967a;
            if (i7 == 4) {
                DayTimeDatePicker.this.f13948k = i6;
            } else if (i7 == 5) {
                DayTimeDatePicker.this.f13949l = i6;
            } else {
                if (i7 != 6) {
                    return;
                }
                if (DayTimeDatePicker.this.f13952o != null && DayTimeDatePicker.this.f13952o.get(1) == DayTimeDatePicker.this.f13947j && DayTimeDatePicker.this.f13952o.get(2) == DayTimeDatePicker.this.f13946i) {
                    DayTimeDatePicker dayTimeDatePicker = DayTimeDatePicker.this;
                    dayTimeDatePicker.f13945h = dayTimeDatePicker.f13952o.get(5) + i6;
                }
                int iB = DayTimeDatePicker.this.B(i6);
                DayTimeDatePicker dayTimeDatePicker2 = DayTimeDatePicker.this;
                dayTimeDatePicker2.f13945h = dayTimeDatePicker2.x(i6);
                DayTimeDatePicker.this.f13946i = iB;
                int i8 = DayTimeDatePicker.this.f13946i;
                DayTimeDatePicker dayTimeDatePicker3 = DayTimeDatePicker.this;
                if (i8 > dayTimeDatePicker3.D(dayTimeDatePicker3.f13947j) - 1) {
                    DayTimeDatePicker dayTimeDatePicker4 = DayTimeDatePicker.this;
                    DayTimeDatePicker.v(dayTimeDatePicker4, dayTimeDatePicker4.D(dayTimeDatePicker4.f13947j));
                    DayTimeDatePicker.e(DayTimeDatePicker.this, 1);
                } else if (DayTimeDatePicker.this.f13946i < 0) {
                    DayTimeDatePicker dayTimeDatePicker5 = DayTimeDatePicker.this;
                    DayTimeDatePicker.u(dayTimeDatePicker5, dayTimeDatePicker5.D(dayTimeDatePicker5.f13947j - 1));
                    DayTimeDatePicker.f(DayTimeDatePicker.this, 1);
                }
                DayTimeDatePicker.this.I();
            }
            DayTimeDatePicker.j(DayTimeDatePicker.this);
            DayTimeDatePicker.this.J(this.f13967a);
        }

        @Override // com.stepos.common.widget.ScrollTextView.e
        public String b(int i5) {
            int i6 = this.f13967a;
            if (i6 == 4) {
                return DayTimeDatePicker.this.f13954q[i5];
            }
            if (i6 == 5) {
                return DayTimeDatePicker.this.f13955r[i5];
            }
            if (i6 != 6) {
                return null;
            }
            if (DayTimeDatePicker.this.f13944g) {
                int i7 = DayTimeDatePicker.this.f13947j;
                int iB = DayTimeDatePicker.this.B(i5);
                if (iB > DayTimeDatePicker.this.D(i7) - 1) {
                    iB -= DayTimeDatePicker.this.D(i7);
                    i7++;
                } else if (iB < 0) {
                    iB += DayTimeDatePicker.this.D(i7 - 1);
                    i7--;
                }
                DayTimeDatePicker dayTimeDatePicker = DayTimeDatePicker.this;
                String strZ = dayTimeDatePicker.z(i7, iB + 1, dayTimeDatePicker.f13929H);
                int iX = DayTimeDatePicker.this.x(i5);
                StringBuilder sb = new StringBuilder();
                sb.append(strZ);
                sb.append(DayTimeDatePicker.this.G() ? DayTimeDatePicker.this.f13936R : " ");
                sb.append(DayTimeDatePicker.this.y(iX - 1));
                return sb.toString();
            }
            int iB2 = DayTimeDatePicker.this.B(i5);
            DayTimeDatePicker dayTimeDatePicker2 = DayTimeDatePicker.this;
            if (iB2 > dayTimeDatePicker2.D(dayTimeDatePicker2.f13947j) - 1) {
                DayTimeDatePicker dayTimeDatePicker3 = DayTimeDatePicker.this;
                iB2 -= dayTimeDatePicker3.D(dayTimeDatePicker3.f13947j);
            } else if (iB2 < 0) {
                DayTimeDatePicker dayTimeDatePicker4 = DayTimeDatePicker.this;
                iB2 += dayTimeDatePicker4.D(dayTimeDatePicker4.f13947j);
            }
            if (!DayTimeDatePicker.this.G()) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(DayTimeDatePicker.this.f13929H[iB2]);
                sb2.append(" ");
                DayTimeDatePicker dayTimeDatePicker5 = DayTimeDatePicker.this;
                sb2.append(dayTimeDatePicker5.f13935Q[dayTimeDatePicker5.x(i5)]);
                return sb2.toString();
            }
            int i8 = iB2 + 1;
            if (DayTimeDatePicker.this.f13952o != null && DayTimeDatePicker.this.f13952o.get(1) == DayTimeDatePicker.this.f13947j && DayTimeDatePicker.this.f13952o.get(2) == DayTimeDatePicker.this.f13946i) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(i8);
                sb3.append(DayTimeDatePicker.this.f13936R);
                DayTimeDatePicker dayTimeDatePicker6 = DayTimeDatePicker.this;
                sb3.append(dayTimeDatePicker6.f13935Q[(dayTimeDatePicker6.x(i5) - 1) + DayTimeDatePicker.this.f13952o.get(5)]);
                sb3.append(DayTimeDatePicker.this.f13937S);
                return sb3.toString();
            }
            StringBuilder sb4 = new StringBuilder();
            sb4.append(i8);
            sb4.append(DayTimeDatePicker.this.f13936R);
            DayTimeDatePicker dayTimeDatePicker7 = DayTimeDatePicker.this;
            sb4.append(dayTimeDatePicker7.f13935Q[dayTimeDatePicker7.x(i5)]);
            sb4.append(DayTimeDatePicker.this.f13937S);
            return sb4.toString();
        }
    }

    public interface e {
    }

    private static class f extends View.BaseSavedState {
        public static final Parcelable.Creator<f> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        private final int f13969a;

        /* renamed from: b, reason: collision with root package name */
        private final int f13970b;

        /* renamed from: c, reason: collision with root package name */
        private final int f13971c;

        class a implements Parcelable.Creator<f> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public f createFromParcel(Parcel parcel) {
                return new f(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public f[] newArray(int i5) {
                return new f[i5];
            }
        }

        /* synthetic */ f(Parcel parcel, a aVar) {
            this(parcel);
        }

        public int a() {
            return this.f13971c;
        }

        public int c() {
            return this.f13970b;
        }

        public int f() {
            return this.f13969a;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i5) {
            super.writeToParcel(parcel, i5);
            parcel.writeInt(this.f13969a);
            parcel.writeInt(this.f13970b);
            parcel.writeInt(this.f13971c);
        }

        /* synthetic */ f(Parcelable parcelable, int i5, int i6, int i7, a aVar) {
            this(parcelable, i5, i6, i7);
        }

        private f(Parcelable parcelable, int i5, int i6, int i7) {
            super(parcelable);
            this.f13969a = i5;
            this.f13970b = i6;
            this.f13971c = i7;
        }

        private f(Parcel parcel) {
            super(parcel);
            this.f13969a = parcel.readInt();
            this.f13970b = parcel.readInt();
            this.f13971c = parcel.readInt();
        }
    }

    public DayTimeDatePicker(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private int A(int i5, int i6) {
        Calendar calendar = this.f13952o;
        boolean z5 = false;
        if (calendar != null && this.f13953p != null && ((calendar.get(1) == i5 && this.f13952o.get(2) > i6) || this.f13952o.get(1) > i5 || ((this.f13953p.get(1) == i5 && this.f13953p.get(2) < i6) || this.f13953p.get(1) < i5))) {
            return 0;
        }
        Calendar calendar2 = this.f13952o;
        if (calendar2 != null && calendar2.get(1) == i5 && this.f13952o.get(2) == i6) {
            return this.f13952o.getActualMaximum(5) - this.f13952o.get(5);
        }
        Calendar calendar3 = this.f13953p;
        if (calendar3 != null && calendar3.get(1) == i5 && this.f13953p.get(2) == i6) {
            if (!this.f13944g || this.f13953p.get(5) <= 30) {
                return this.f13953p.get(5);
            }
            return 30;
        }
        if (!this.f13944g) {
            Calendar calendar4 = Calendar.getInstance();
            calendar4.set(5, 1);
            calendar4.set(1, i5);
            calendar4.set(2, i6);
            return calendar4.getActualMaximum(5);
        }
        int iD = N1.e.d(i5);
        if (iD != 0 && iD == i6) {
            z5 = true;
        }
        if (iD == 0 || (iD != 0 && i6 < iD)) {
            i6++;
        }
        return N1.e.c(i5, i6, z5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int B(int i5) {
        int twoMonthBeforeMonthDays = getTwoMonthBeforeMonthDays();
        int oneMonthBeforeMonthDays = getOneMonthBeforeMonthDays() + twoMonthBeforeMonthDays;
        int iA = A(this.f13947j, this.f13946i) + oneMonthBeforeMonthDays;
        int oneMonthAfterMonthDays = getOneMonthAfterMonthDays() + iA;
        int twoMonthAfterMonthDays = getTwoMonthAfterMonthDays() + oneMonthAfterMonthDays;
        if (i5 < twoMonthBeforeMonthDays) {
            return this.f13946i - 2;
        }
        if (i5 >= twoMonthBeforeMonthDays && i5 < oneMonthBeforeMonthDays) {
            return this.f13946i - 1;
        }
        if (i5 >= oneMonthBeforeMonthDays && i5 < iA) {
            return this.f13946i;
        }
        if (i5 >= iA && i5 < oneMonthAfterMonthDays) {
            return this.f13946i + 1;
        }
        if (i5 < oneMonthAfterMonthDays || i5 >= twoMonthAfterMonthDays) {
            return 0;
        }
        return this.f13946i + 2;
    }

    private String C(int i5) {
        return i5 != 4 ? i5 != 5 ? BuildConfig.FLAVOR : String.valueOf(this.f13949l) : String.valueOf(this.f13948k);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int D(int i5) {
        return (!this.f13944g || N1.e.d(i5) == 0) ? 12 : 13;
    }

    private boolean E(int i5) {
        if (!G()) {
            return false;
        }
        int iD = N1.e.d(this.f13947j);
        if (iD == 0) {
            if (i5 >= 12) {
                return false;
            }
        } else if (i5 >= 13) {
            return false;
        }
        return iD != 0 && i5 > iD + (-1) && i5 == iD;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean G() {
        return getResources().getConfiguration().locale.getLanguage().endsWith("zh");
    }

    private void H() {
        if (this.f13944g && G()) {
            this.f13943f.g0(this.f13960w, this.f13961x);
            this.f13943f.setTypeface(this.f13933L);
        } else {
            this.f13943f.g0(this.f13962y, this.f13963z);
            this.f13943f.setTypeface(this.f13934M);
        }
        this.f13941d.g0(this.f13962y, this.f13963z);
        this.f13941d.setTypeface(this.f13934M);
        this.f13942e.g0(this.f13962y, this.f13963z);
        this.f13942e.setTypeface(this.f13934M);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I() {
        int monthDaysCount = getMonthDaysCount();
        this.f13943f.Z(new d(6), -1.0f, getDaysPosition() - 1, monthDaysCount, this.f13956s, 0, monthDaysCount - 1, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J(int i5) {
        View viewFindViewById;
        if (this.f13928G) {
            K();
            if (i5 == 5) {
                View viewFindViewById2 = findViewById(H1.h.f2217G);
                if (viewFindViewById2 != null) {
                    viewFindViewById2.sendAccessibilityEvent(4);
                    return;
                }
                return;
            }
            if (i5 == 4) {
                View viewFindViewById3 = findViewById(H1.h.f2216F);
                if (viewFindViewById3 != null) {
                    viewFindViewById3.sendAccessibilityEvent(4);
                    return;
                }
                return;
            }
            if (i5 != 6 || (viewFindViewById = findViewById(H1.h.f2215E)) == null) {
                return;
            }
            viewFindViewById.sendAccessibilityEvent(4);
        }
    }

    private void K() {
        if (this.f13928G) {
            View viewFindViewById = findViewById(H1.h.f2217G);
            View viewFindViewById2 = findViewById(H1.h.f2215E);
            View viewFindViewById3 = findViewById(H1.h.f2216F);
            String strReplace = (C(6) + C(4) + ((Object) this.f13939b.getText()) + C(5) + ((Object) this.f13938a.getText())).replace(" ", BuildConfig.FLAVOR).replace("廿十", "二十").replace("廿", "二十");
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

    private void N(int i5, int i6, int i7, int i8, int i9, boolean z5) {
        int i10 = this.f13950m;
        if (i5 >= i10) {
            i10 = i5;
        }
        this.f13947j = i10;
        int i11 = this.f13951n;
        if (i5 > i11) {
            i5 = i11;
        }
        this.f13947j = i5;
        if (i6 > 11) {
            i6 = 11;
        }
        this.f13946i = i6;
        this.f13945h = i7;
        this.f13948k = i8;
        this.f13949l = i9;
        this.f13941d.Y(i8, z5);
        this.f13942e.Y(this.f13949l, z5);
        if (this.f13957t != getMonthDaysCount()) {
            int monthDaysCount = getMonthDaysCount();
            this.f13957t = monthDaysCount;
            this.f13943f.T(monthDaysCount);
        }
        this.f13943f.Y(getDaysPosition() - 1, z5);
    }

    static /* synthetic */ int e(DayTimeDatePicker dayTimeDatePicker, int i5) {
        int i6 = dayTimeDatePicker.f13947j + i5;
        dayTimeDatePicker.f13947j = i6;
        return i6;
    }

    static /* synthetic */ int f(DayTimeDatePicker dayTimeDatePicker, int i5) {
        int i6 = dayTimeDatePicker.f13947j - i5;
        dayTimeDatePicker.f13947j = i6;
        return i6;
    }

    private Calendar getCurrentCalendar() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(5, 1);
        calendar.set(1, this.f13947j);
        calendar.set(2, this.f13946i);
        return calendar;
    }

    private int getDaysPosition() {
        return getTwoMonthBeforeMonthDays() + getOneMonthBeforeMonthDays() + this.f13945h;
    }

    private int getMonthDays() {
        if (!this.f13944g) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(5, 1);
            calendar.set(1, this.f13947j);
            calendar.set(2, this.f13946i);
            return calendar.getActualMaximum(5);
        }
        int i5 = this.f13946i;
        int iD = N1.e.d(this.f13947j);
        boolean z5 = false;
        if (iD != 0) {
            z5 = iD == i5;
        }
        if (iD == 0 || (iD != 0 && this.f13946i < iD)) {
            i5++;
        }
        return N1.e.c(this.f13947j, i5, z5);
    }

    private int getMonthDaysCount() {
        return getTwoMonthBeforeMonthDays() + getOneMonthBeforeMonthDays() + A(this.f13947j, this.f13946i) + getOneMonthAfterMonthDays() + getTwoMonthAfterMonthDays();
    }

    private int getOneMonthAfterMonthDays() {
        if (this.f13946i <= D(this.f13947j) - 2) {
            return A(this.f13947j, this.f13946i + 1);
        }
        int i5 = this.f13947j;
        return A(i5 + 1, (this.f13946i + 1) - D(i5));
    }

    private int getOneMonthBeforeMonthDays() {
        int i5 = this.f13946i;
        if (i5 >= 1) {
            return A(this.f13947j, i5 - 1);
        }
        int i6 = this.f13947j;
        return A(i6 - 1, (i5 - 1) + D(i6 - 1));
    }

    private int getTwoMonthAfterMonthDays() {
        if (this.f13946i <= D(this.f13947j) - 3) {
            return A(this.f13947j, this.f13946i + 2);
        }
        int i5 = this.f13947j;
        return A(i5 + 1, (this.f13946i + 2) - D(i5));
    }

    private int getTwoMonthBeforeMonthDays() {
        int i5 = this.f13946i;
        if (i5 >= 2) {
            return A(this.f13947j, i5 - 2);
        }
        int i6 = this.f13947j;
        return A(i6 - 1, (i5 - 2) + D(i6 - 1));
    }

    static /* synthetic */ e j(DayTimeDatePicker dayTimeDatePicker) {
        dayTimeDatePicker.getClass();
        return null;
    }

    private void setDayRange(int i5) {
    }

    private void setLeapUnitVisibility(int i5) {
        if (F() && E(i5)) {
            this.f13940c.setVisibility(0);
        } else {
            this.f13940c.setVisibility(8);
        }
    }

    private void setMonthRange(int i5) {
    }

    static /* synthetic */ int u(DayTimeDatePicker dayTimeDatePicker, int i5) {
        int i6 = dayTimeDatePicker.f13946i + i5;
        dayTimeDatePicker.f13946i = i6;
        return i6;
    }

    static /* synthetic */ int v(DayTimeDatePicker dayTimeDatePicker, int i5) {
        int i6 = dayTimeDatePicker.f13946i - i5;
        dayTimeDatePicker.f13946i = i6;
        return i6;
    }

    private void w() {
        TextView textView = (TextView) findViewById(H1.h.f2231U);
        this.f13939b = textView;
        if (textView != null) {
            textView.setText(H1.k.f2349g);
        }
        TextView textView2 = (TextView) findViewById(H1.h.f2233W);
        this.f13938a = textView2;
        if (textView2 != null) {
            textView2.setText(H1.k.f2350h);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int x(int i5) {
        int i6;
        int twoMonthBeforeMonthDays = getTwoMonthBeforeMonthDays();
        int oneMonthBeforeMonthDays = getOneMonthBeforeMonthDays() + twoMonthBeforeMonthDays;
        int iA = A(this.f13947j, this.f13946i) + oneMonthBeforeMonthDays;
        int oneMonthAfterMonthDays = getOneMonthAfterMonthDays() + iA;
        int twoMonthAfterMonthDays = getTwoMonthAfterMonthDays() + oneMonthAfterMonthDays;
        if (i5 < twoMonthBeforeMonthDays) {
            return i5 + 1;
        }
        if (i5 >= twoMonthBeforeMonthDays && i5 < oneMonthBeforeMonthDays) {
            i6 = i5 - twoMonthBeforeMonthDays;
        } else if (i5 >= oneMonthBeforeMonthDays && i5 < iA) {
            i6 = i5 - oneMonthBeforeMonthDays;
        } else if (i5 >= iA && i5 < oneMonthAfterMonthDays) {
            i6 = i5 - iA;
        } else {
            if (i5 < oneMonthAfterMonthDays || i5 >= twoMonthAfterMonthDays) {
                return 1;
            }
            i6 = i5 - oneMonthAfterMonthDays;
        }
        return i6 + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String z(int i5, int i6, String[] strArr) {
        int iD = N1.e.d(i5);
        if (iD != 0 && i6 > iD) {
            return strArr[i6 - 2];
        }
        if (i6 - 1 >= strArr.length) {
            i6 = strArr.length - 1;
        }
        return strArr[i6 - 1];
    }

    public boolean F() {
        return this.f13944g;
    }

    public void L(boolean z5, boolean z6) {
        int i5;
        boolean z7;
        int[] iArrE;
        int i6;
        this.f13944g = z5;
        int[] iArr = {this.f13947j, this.f13946i + 1, this.f13945h, 0};
        int i7 = iArr[0];
        int iD = N1.e.d(i7);
        int iD2 = N1.e.d(iArr[0] - 1);
        if (this.f13944g) {
            iArrE = N1.e.f(iArr[0], iArr[1], iArr[2]);
            int i8 = iArrE[0];
            if ((i7 != i8 && iD2 != 0 && (iArrE[3] == 1 || iArrE[1] > iD2)) || (i7 == i8 && iD != 0 && (iArrE[3] == 1 || iArrE[1] > iD))) {
                iArrE[1] = iArrE[1] + 1;
            }
        } else {
            if (iD == 0 || iD >= (i6 = iArr[1])) {
                i5 = iArr[1];
            } else {
                int i9 = iD + 1;
                if (i9 == i6) {
                    i5 = i6 - 1;
                    z7 = true;
                } else if (i9 < i6) {
                    i5 = i6 - 1;
                } else {
                    i5 = 0;
                    z7 = false;
                }
                iArrE = N1.e.e(iArr[0], i5, iArr[2], z7);
            }
            z7 = false;
            iArrE = N1.e.e(iArr[0], i5, iArr[2], z7);
        }
        H();
        int i10 = iArrE[0];
        int i11 = iArrE[1];
        N(i10, i11 + (-1) < 0 ? 12 : i11 - 1, iArrE[2], this.f13948k, this.f13949l, z6);
        setLeapUnitVisibility(this.f13946i);
    }

    public void M(int i5, int i6, int i7, int i8, int i9) {
        N(i5, i6, i7, i8, i9, false);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    public int getCurrentHour() {
        return this.f13948k;
    }

    public Integer getCurrentMinute() {
        return Integer.valueOf(this.f13949l);
    }

    public int getDayOfMonth() {
        return this.f13945h;
    }

    public TextView getMinUnit() {
        return this.f13938a;
    }

    public int getMonth() {
        return this.f13946i;
    }

    public int getYear() {
        return this.f13947j;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f13927F) {
            int width = getWidth();
            int width2 = this.f13922A.getWidth() - (this.f13925D * 2);
            int i5 = (width - width2) / 2;
            float f5 = i5;
            int i6 = this.f13923B;
            float f6 = i5 + width2;
            canvas.drawLine(f5, i6, f6, i6, this.f13926E);
            int i7 = this.f13924C;
            canvas.drawLine(f5, i7, f6, i7, this.f13926E);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(DatePicker.class.getName());
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        f fVar = (f) parcelable;
        super.onRestoreInstanceState(fVar.getSuperState());
        this.f13947j = fVar.f();
        this.f13946i = fVar.c();
        this.f13945h = fVar.a();
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        return new f(super.onSaveInstanceState(), this.f13947j, this.f13946i, this.f13945h, null);
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z5) {
        super.onWindowFocusChanged(z5);
    }

    public void setCurrentHour(Integer num) {
        if (num == null || num.intValue() == getCurrentHour()) {
            return;
        }
        M(this.f13947j, this.f13946i, this.f13945h, num.intValue(), this.f13949l);
    }

    public void setCurrentMinute(Integer num) {
        M(this.f13947j, this.f13946i, this.f13945h, getCurrentHour(), num.intValue());
    }

    @Override // android.view.View
    public void setEnabled(boolean z5) {
        super.setEnabled(z5);
        this.f13943f.setEnabled(z5);
        this.f13941d.setEnabled(z5);
        this.f13942e.setEnabled(z5);
    }

    public void setIsDrawFading(boolean z5) {
        this.f13942e.setIsDrawFading(z5);
        this.f13941d.setIsDrawFading(z5);
        this.f13943f.setIsDrawFading(z5);
    }

    public void setIsDrawLine(boolean z5) {
        this.f13927F = z5;
    }

    public void setLunar(boolean z5) {
        L(z5, true);
    }

    public void setOnTimeChangedListener(e eVar) {
    }

    public String y(int i5) {
        String[] strArr = this.f13930I;
        if (i5 > strArr.length - 1) {
            return null;
        }
        return strArr[i5];
    }

    public DayTimeDatePicker(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.f13944g = false;
        this.f13956s = 5;
        this.f13928G = false;
        this.f13932K = false;
        this.f13933L = Typeface.create("sans-serif-medium", 0);
        this.f13934M = Typeface.create("DINPro-medium", 0);
        ArrayList arrayList = new ArrayList();
        this.f13961x = arrayList;
        arrayList.add(Float.valueOf(context.getResources().getDimension(H1.f.f2111G)));
        this.f13961x.add(Float.valueOf(context.getResources().getDimension(H1.f.f2112H)));
        this.f13960w = context.getResources().getDimensionPixelOffset(H1.f.f2117M);
        ArrayList arrayList2 = new ArrayList();
        this.f13963z = arrayList2;
        arrayList2.add(Float.valueOf(context.getResources().getDimension(H1.f.f2109E)));
        this.f13963z.add(Float.valueOf(context.getResources().getDimension(H1.f.f2110F)));
        this.f13962y = Math.min(getContext().getResources().getDimensionPixelOffset(H1.f.f2115K), getContext().getResources().getDimensionPixelOffset(H1.f.f2116L));
        this.f13950m = 1900;
        this.f13951n = 2099;
        this.f13954q = new String[100];
        for (int i6 = 0; i6 < 100; i6++) {
            this.f13954q[i6] = String.valueOf(i6);
            if (i6 <= 9) {
                this.f13954q[i6] = "0" + this.f13954q[i6];
            }
        }
        this.f13931J = getResources().getString(H1.k.f2341E);
        this.f13936R = getResources().getString(H1.k.f2351i);
        this.f13937S = getResources().getString(H1.k.f2348f);
        this.f13955r = new String[100];
        for (int i7 = 0; i7 < 100; i7++) {
            this.f13955r[i7] = String.valueOf(i7);
            if (i7 <= 9) {
                this.f13955r[i7] = "0" + this.f13955r[i7];
            }
        }
        View.inflate(getContext(), H1.i.f2313d, this);
        TextView textView = (TextView) findViewById(H1.h.f2234X);
        this.f13940c = textView;
        if (textView != null) {
            textView.setText(this.f13931J);
            this.f13940c.setVisibility(8);
        }
        TextView textView2 = (TextView) findViewById(H1.h.f2231U);
        this.f13939b = textView2;
        if (textView2 != null) {
            textView2.setText(H1.k.f2349g);
        }
        TextView textView3 = (TextView) findViewById(H1.h.f2233W);
        this.f13938a = textView3;
        if (textView3 != null) {
            textView3.setText(H1.k.f2350h);
        }
        Calendar calendar = Calendar.getInstance();
        this.f13947j = calendar.get(1);
        this.f13946i = calendar.get(2);
        this.f13945h = calendar.get(5);
        this.f13922A = (LinearLayout) findViewById(H1.h.f2218H);
        ScrollTextView scrollTextView = (ScrollTextView) findViewById(H1.h.f2229S);
        this.f13943f = scrollTextView;
        scrollTextView.setTypeface(this.f13933L);
        if (this.f13959v != 0.0f) {
            if (this.f13958u != 0.0f) {
                this.f13943f.a0((int) r5, (int) r10);
            }
        }
        I();
        ScrollTextView scrollTextView2 = (ScrollTextView) findViewById(H1.h.f2230T);
        this.f13941d = scrollTextView2;
        scrollTextView2.setTypeface(this.f13934M);
        if (this.f13959v != 0.0f) {
            if (this.f13958u != 0.0f) {
                this.f13941d.a0((int) r5, (int) r10);
            }
        }
        this.f13941d.Z(new d(4), -1.0f, this.f13948k, 24, this.f13956s, 0, 23, true);
        ScrollTextView scrollTextView3 = (ScrollTextView) findViewById(H1.h.f2232V);
        this.f13942e = scrollTextView3;
        if (this.f13959v != 0.0f) {
            if (this.f13958u != 0.0f) {
                scrollTextView3.a0((int) r10, (int) r11);
            }
        }
        this.f13942e.Z(new d(5), -1.0f, this.f13949l, 60, this.f13956s, 0, 59, true);
        H();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Calendar calendar2 = Calendar.getInstance();
            this.f13952o = calendar2;
            calendar2.setTime(simpleDateFormat.parse(this.f13950m + "-01-01"));
        } catch (ParseException e6) {
            e6.printStackTrace();
        }
        try {
            Calendar calendar3 = Calendar.getInstance();
            this.f13953p = calendar3;
            calendar3.setTime(simpleDateFormat.parse(this.f13951n + "-12-31"));
        } catch (ParseException e7) {
            e7.printStackTrace();
        }
        w();
        int paddingTop = this.f13939b.getPaddingTop();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        displayMetrics.setToDefaults();
        float f5 = displayMetrics.scaledDensity;
        float f6 = getResources().getDisplayMetrics().scaledDensity;
        float textSize = ((this.f13939b.getTextSize() / f6) * (f6 - f5)) / 1.3f;
        TextView textView4 = this.f13939b;
        int i8 = (int) (paddingTop - textSize);
        textView4.setPadding(textView4.getPaddingLeft(), i8, this.f13939b.getPaddingRight(), this.f13939b.getPaddingBottom());
        TextView textView5 = this.f13938a;
        textView5.setPadding(textView5.getPaddingLeft(), i8, this.f13938a.getPaddingRight(), this.f13938a.getPaddingBottom());
        if (!isEnabled()) {
            setEnabled(false);
        }
        this.f13923B = 0;
        this.f13924C = 0;
        this.f13925D = context.getResources().getDimensionPixelSize(H1.f.f2147i);
        this.f13926E = new Paint();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(H1.m.p6);
        int i9 = typedArrayObtainStyledAttributes.getInt(H1.m.q6, context.getResources().getColor(H1.e.f2093o));
        typedArrayObtainStyledAttributes.recycle();
        this.f13926E.setColor(i9);
        this.f13926E.setAntiAlias(true);
        this.f13926E.setStrokeWidth(context.getResources().getDimensionPixelSize(H1.f.f2143g));
        this.f13927F = false;
        setWillNotDraw(false);
        this.f13929H = getResources().getStringArray(H1.b.f2051b);
        this.f13930I = getResources().getStringArray(H1.b.f2050a);
        this.f13935Q = new String[100];
        for (int i10 = 0; i10 < 100; i10++) {
            this.f13935Q[i10] = String.valueOf(i10);
            if (G()) {
                this.f13935Q[i10] = String.valueOf(i10);
            }
            if (i10 <= 9) {
                this.f13935Q[i10] = "0" + this.f13935Q[i10];
            }
        }
        if (Build.DEVICE.equals("mx4pro")) {
            this.f13942e.v(new a());
            this.f13941d.v(new b());
            this.f13943f.v(new c());
        }
        AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
        if (accessibilityManager != null) {
            this.f13928G = accessibilityManager.isEnabled();
        }
    }
}
