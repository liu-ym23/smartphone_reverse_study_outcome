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
import com.stepos.common.widget.ScrollTextView;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import org.libpag.BuildConfig;

/* loaded from: classes.dex */
public class DatePicker extends FrameLayout {

    /* renamed from: A, reason: collision with root package name */
    private int f13866A;

    /* renamed from: B, reason: collision with root package name */
    private float f13867B;

    /* renamed from: C, reason: collision with root package name */
    private float f13868C;

    /* renamed from: D, reason: collision with root package name */
    private int f13869D;

    /* renamed from: E, reason: collision with root package name */
    private List<Float> f13870E;

    /* renamed from: F, reason: collision with root package name */
    private int f13871F;

    /* renamed from: G, reason: collision with root package name */
    private List<Float> f13872G;

    /* renamed from: H, reason: collision with root package name */
    private LinearLayout f13873H;

    /* renamed from: I, reason: collision with root package name */
    private int f13874I;

    /* renamed from: J, reason: collision with root package name */
    private int f13875J;

    /* renamed from: K, reason: collision with root package name */
    private int f13876K;

    /* renamed from: L, reason: collision with root package name */
    private Paint f13877L;

    /* renamed from: M, reason: collision with root package name */
    private boolean f13878M;

    /* renamed from: Q, reason: collision with root package name */
    private boolean f13879Q;

    /* renamed from: R, reason: collision with root package name */
    String[] f13880R;

    /* renamed from: S, reason: collision with root package name */
    String[] f13881S;

    /* renamed from: T, reason: collision with root package name */
    String f13882T;

    /* renamed from: U, reason: collision with root package name */
    boolean f13883U;

    /* renamed from: V, reason: collision with root package name */
    String[] f13884V;

    /* renamed from: W, reason: collision with root package name */
    private boolean f13885W;

    /* renamed from: a, reason: collision with root package name */
    private TextView f13886a;

    /* renamed from: a0, reason: collision with root package name */
    private int f13887a0;

    /* renamed from: b, reason: collision with root package name */
    private TextView f13888b;

    /* renamed from: c, reason: collision with root package name */
    private TextView f13889c;

    /* renamed from: d, reason: collision with root package name */
    private TextView f13890d;

    /* renamed from: e, reason: collision with root package name */
    private ScrollTextView f13891e;

    /* renamed from: f, reason: collision with root package name */
    private ScrollTextView f13892f;

    /* renamed from: g, reason: collision with root package name */
    private ScrollTextView f13893g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f13894h;

    /* renamed from: i, reason: collision with root package name */
    private f f13895i;

    /* renamed from: j, reason: collision with root package name */
    private int f13896j;

    /* renamed from: k, reason: collision with root package name */
    private int f13897k;

    /* renamed from: l, reason: collision with root package name */
    private int f13898l;

    /* renamed from: m, reason: collision with root package name */
    private int f13899m;

    /* renamed from: n, reason: collision with root package name */
    private int f13900n;

    /* renamed from: o, reason: collision with root package name */
    private Calendar f13901o;

    /* renamed from: p, reason: collision with root package name */
    private Calendar f13902p;

    /* renamed from: q, reason: collision with root package name */
    private int f13903q;

    /* renamed from: r, reason: collision with root package name */
    private int f13904r;

    /* renamed from: s, reason: collision with root package name */
    private String[] f13905s;

    /* renamed from: t, reason: collision with root package name */
    String f13906t;

    /* renamed from: u, reason: collision with root package name */
    private Object f13907u;

    /* renamed from: v, reason: collision with root package name */
    private volatile Locale f13908v;

    /* renamed from: w, reason: collision with root package name */
    private String[] f13909w;

    /* renamed from: x, reason: collision with root package name */
    private int f13910x;

    /* renamed from: y, reason: collision with root package name */
    private int f13911y;

    /* renamed from: z, reason: collision with root package name */
    private int f13912z;

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
            DatePicker.this.setIsDrawFading(true);
        }

        @Override // com.stepos.common.widget.ScrollTextView.h
        public void b(ScrollTextView scrollTextView) {
        }
    }

    class d implements Runnable {
        d() {
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
                r0.f13883U = r1
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.common.widget.DatePicker.d.run():void");
        }
    }

    private class e implements ScrollTextView.e {

        /* renamed from: a, reason: collision with root package name */
        int f13917a;

        e(int i5) {
            this.f13917a = i5;
        }

        @Override // com.stepos.common.widget.ScrollTextView.e
        public void a(View view, int i5, int i6) {
            int monthDays = DatePicker.this.getMonthDays();
            DatePicker.this.getYearMonths();
            int i7 = this.f13917a;
            if (i7 == 1) {
                int i8 = DatePicker.this.f13898l;
                DatePicker datePicker = DatePicker.this;
                datePicker.f13898l = i6 + datePicker.f13899m;
                if (DatePicker.this.f13901o != null && DatePicker.this.f13901o.get(1) == DatePicker.this.f13898l && DatePicker.this.f13897k < DatePicker.this.f13901o.get(2)) {
                    DatePicker datePicker2 = DatePicker.this;
                    datePicker2.f13897k = datePicker2.f13901o.get(2);
                }
                if (DatePicker.this.f13892f != null) {
                    int yearMonths = DatePicker.this.getYearMonths();
                    if (DatePicker.this.f13894h) {
                        int iD = N1.e.d(i8);
                        int iD2 = N1.e.d(DatePicker.this.f13898l);
                        DatePicker datePicker3 = DatePicker.this;
                        int iE = datePicker3.E(iD, iD2, datePicker3.f13887a0);
                        DatePicker.this.f13912z = yearMonths;
                        DatePicker.this.f13892f.U(yearMonths, iE);
                        DatePicker datePicker4 = DatePicker.this;
                        datePicker4.f13897k = datePicker4.f13892f.getCurrentItem();
                    } else {
                        DatePicker.this.f13912z = yearMonths;
                        DatePicker.this.f13892f.T(yearMonths);
                    }
                    int i9 = yearMonths - 1;
                    if (i9 < DatePicker.this.f13897k) {
                        DatePicker.this.f13896j = monthDays;
                        DatePicker.this.f13897k = i9;
                        DatePicker.this.f13892f.Y(DatePicker.this.f13897k, true);
                    }
                }
                if (monthDays != DatePicker.this.getMonthDays() && DatePicker.this.f13891e != null) {
                    int monthDays2 = DatePicker.this.getMonthDays();
                    DatePicker.this.f13866A = monthDays2;
                    DatePicker.this.f13891e.T(monthDays2);
                    if (monthDays2 < DatePicker.this.f13896j) {
                        DatePicker.this.f13896j = monthDays2;
                        DatePicker.this.f13891e.Y(DatePicker.this.f13896j - 1, true);
                    }
                }
            } else if (i7 == 2) {
                DatePicker.this.f13897k = i6;
                if (DatePicker.this.f13901o != null && DatePicker.this.f13901o.get(1) == DatePicker.this.f13898l) {
                    DatePicker datePicker5 = DatePicker.this;
                    DatePicker.x(datePicker5, datePicker5.f13901o.get(2));
                }
                if (monthDays != DatePicker.this.getMonthDays() && DatePicker.this.f13891e != null) {
                    int monthDays3 = DatePicker.this.getMonthDays();
                    DatePicker.this.f13866A = monthDays3;
                    DatePicker.this.f13891e.T(monthDays3);
                    if (monthDays3 < DatePicker.this.f13896j) {
                        DatePicker.this.f13896j = monthDays3;
                        DatePicker.this.f13891e.Y(DatePicker.this.f13896j - 1, true);
                    }
                }
            } else {
                if (i7 != 3) {
                    return;
                }
                if (DatePicker.this.f13891e.getVisibility() != 8) {
                    DatePicker.this.f13896j = i6 + 1;
                    if (DatePicker.this.f13901o != null && DatePicker.this.f13901o.get(1) == DatePicker.this.f13898l && DatePicker.this.f13901o.get(2) == DatePicker.this.f13897k) {
                        DatePicker datePicker6 = DatePicker.this;
                        datePicker6.f13896j = i6 + datePicker6.f13901o.get(5);
                    }
                }
            }
            DatePicker datePicker7 = DatePicker.this;
            datePicker7.setDayRange(datePicker7.f13897k);
            DatePicker datePicker8 = DatePicker.this;
            datePicker8.setMonthRange(datePicker8.f13898l);
            if (DatePicker.this.f13895i != null) {
                f fVar = DatePicker.this.f13895i;
                DatePicker datePicker9 = DatePicker.this;
                fVar.a(datePicker9, datePicker9.f13898l, DatePicker.this.f13897k, DatePicker.this.f13896j);
            }
            int i10 = this.f13917a;
            if (i10 == 1 || i10 == 2) {
                DatePicker datePicker10 = DatePicker.this;
                datePicker10.setLeapUnitVisibility(datePicker10.f13897k);
            }
            if (DatePicker.this.f13892f != null) {
                DatePicker datePicker11 = DatePicker.this;
                datePicker11.f13887a0 = datePicker11.f13892f.getCurrentItem();
            }
            DatePicker.this.O(this.f13917a);
        }

        @Override // com.stepos.common.widget.ScrollTextView.e
        public String b(int i5) {
            int i6 = this.f13917a;
            if (i6 == 1) {
                return String.format(Locale.getDefault(), "%d", Integer.valueOf(i5 + DatePicker.this.f13899m));
            }
            if (i6 == 2) {
                if (DatePicker.this.f13894h) {
                    return DatePicker.this.D(i5);
                }
                if (DatePicker.this.f13901o != null && DatePicker.this.f13901o.get(1) == DatePicker.this.f13898l) {
                    i5 += DatePicker.this.f13901o.get(2);
                }
                if (i5 < DatePicker.this.f13905s.length) {
                    return DatePicker.this.f13905s[i5];
                }
                return null;
            }
            if (i6 != 3) {
                return null;
            }
            if (DatePicker.this.f13894h) {
                return DatePicker.this.C(i5);
            }
            if (DatePicker.this.f13901o == null || DatePicker.this.f13901o.get(1) != DatePicker.this.f13898l || DatePicker.this.f13901o.get(2) != DatePicker.this.f13897k) {
                return DatePicker.this.f13884V[i5 + 1];
            }
            DatePicker datePicker = DatePicker.this;
            return datePicker.f13884V[i5 + datePicker.f13901o.get(5)];
        }
    }

    public interface f {
        void a(DatePicker datePicker, int i5, int i6, int i7);
    }

    private static class g extends View.BaseSavedState {
        public static final Parcelable.Creator<g> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        private final int f13919a;

        /* renamed from: b, reason: collision with root package name */
        private final int f13920b;

        /* renamed from: c, reason: collision with root package name */
        private final int f13921c;

        class a implements Parcelable.Creator<g> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public g createFromParcel(Parcel parcel) {
                return new g(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public g[] newArray(int i5) {
                return new g[i5];
            }
        }

        /* synthetic */ g(Parcel parcel, a aVar) {
            this(parcel);
        }

        public int a() {
            return this.f13921c;
        }

        public int c() {
            return this.f13920b;
        }

        public int f() {
            return this.f13919a;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i5) {
            super.writeToParcel(parcel, i5);
            parcel.writeInt(this.f13919a);
            parcel.writeInt(this.f13920b);
            parcel.writeInt(this.f13921c);
        }

        /* synthetic */ g(Parcelable parcelable, int i5, int i6, int i7, a aVar) {
            this(parcelable, i5, i6, i7);
        }

        private g(Parcelable parcelable, int i5, int i6, int i7) {
            super(parcelable);
            this.f13919a = i5;
            this.f13920b = i6;
            this.f13921c = i7;
        }

        private g(Parcel parcel) {
            super(parcel);
            this.f13919a = parcel.readInt();
            this.f13920b = parcel.readInt();
            this.f13921c = parcel.readInt();
        }
    }

    public DatePicker(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void B() {
        TextView textView = (TextView) findViewById(H1.h.f2224N);
        this.f13888b = textView;
        if (textView != null) {
            textView.setText(H1.k.f2351i);
        }
        TextView textView2 = (TextView) findViewById(H1.h.f2226P);
        this.f13886a = textView2;
        if (textView2 != null) {
            textView2.setText(H1.k.f2348f);
        }
        TextView textView3 = (TextView) findViewById(H1.h.f2228R);
        this.f13889c = textView3;
        if (textView3 != null) {
            textView3.setText(H1.k.f2352j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String D(int i5) {
        int iD = N1.e.d(this.f13898l);
        if (iD == 0) {
            if (i5 >= 12) {
                return null;
            }
        } else if (i5 >= 13) {
            return null;
        }
        return (iD == 0 || i5 <= iD + (-1)) ? this.f13880R[i5] : i5 == iD ? this.f13880R[i5 - 1] : this.f13880R[i5 - 1];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int E(int i5, int i6, int i7) {
        if (i5 > i6 && i6 == 0 && i7 >= i5) {
            return -1;
        }
        if (i5 < i6 && i5 == 0 && i7 >= i6) {
            return 1;
        }
        if (i5 >= i6 || i5 == 0 || i5 > i7 || i6 <= i7) {
            return (i5 <= i6 || i6 == 0 || i5 <= i7 || i6 > i7) ? 0 : 1;
        }
        return -1;
    }

    private String G(int i5) {
        if (i5 == 1) {
            return String.valueOf(this.f13898l);
        }
        if (i5 != 2) {
            if (i5 != 3) {
                return BuildConfig.FLAVOR;
            }
            int i6 = this.f13896j;
            return this.f13894h ? C(i6 - 1) : String.valueOf(i6);
        }
        int i7 = this.f13897k;
        if (this.f13894h) {
            return D(i7);
        }
        if (this.f13905s == null) {
            this.f13905s = getShortMonths();
        }
        String[] strArr = this.f13905s;
        return i7 < strArr.length ? strArr[i7] : BuildConfig.FLAVOR;
    }

    private boolean I(int i5) {
        if (!K()) {
            return false;
        }
        int iD = N1.e.d(this.f13898l);
        if (iD == 0) {
            if (i5 >= 12) {
                return false;
            }
        } else if (i5 >= 13) {
            return false;
        }
        return iD != 0 && i5 > iD + (-1) && i5 == iD;
    }

    private boolean K() {
        return getResources().getConfiguration().locale.getLanguage().endsWith("zh");
    }

    private void M() {
        if (this.f13894h && K()) {
            this.f13892f.g0(this.f13869D, this.f13870E);
            this.f13891e.g0(this.f13869D, this.f13870E);
        } else {
            this.f13892f.g0(this.f13871F, this.f13872G);
            this.f13891e.g0(this.f13871F, this.f13872G);
        }
        this.f13893g.g0(this.f13871F, this.f13872G);
    }

    private void N(String[] strArr) {
        int i5;
        boolean z5;
        DateFormat dateFormat = strArr[0].startsWith("1") ? android.text.format.DateFormat.getDateFormat(getContext()) : android.text.format.DateFormat.getMediumDateFormat(getContext());
        if (dateFormat instanceof SimpleDateFormat) {
            this.f13906t = ((SimpleDateFormat) dateFormat).toPattern();
        } else {
            this.f13906t = new String(android.text.format.DateFormat.getDateFormatOrder(getContext()));
        }
        FrameLayout frameLayout = (FrameLayout) findViewById(H1.h.f2212B);
        FrameLayout frameLayout2 = (FrameLayout) findViewById(H1.h.f2213C);
        FrameLayout frameLayout3 = (FrameLayout) findViewById(H1.h.f2214D);
        ImageView imageView = (ImageView) findViewById(H1.h.f2219I);
        ImageView imageView2 = (ImageView) findViewById(H1.h.f2220J);
        LinearLayout linearLayout = (LinearLayout) findViewById(H1.h.f2218H);
        linearLayout.removeAllViews();
        if (this.f13906t.contentEquals("dd\u200f/MM\u200f/y") || this.f13906t.contentEquals("d בMMM y")) {
            this.f13906t = "yy/M/d";
        }
        if (this.f13885W) {
            this.f13906t = "d/M/yy";
        }
        int i6 = 0;
        boolean z6 = false;
        boolean z7 = false;
        boolean z8 = false;
        boolean z9 = false;
        boolean z10 = false;
        boolean z11 = false;
        while (i6 < this.f13906t.length()) {
            char cCharAt = this.f13906t.charAt(i6);
            if (cCharAt == '\'') {
                z8 = !z8;
            }
            if (z8) {
                i5 = i6;
            } else {
                i5 = i6;
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
            i6 = i5 + 1;
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
        if (!K()) {
            FrameLayout frameLayout4 = (FrameLayout) findViewById(H1.h.f2213C);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) frameLayout4.getLayoutParams();
            layoutParams.setMarginEnd(0);
            frameLayout4.setLayoutParams(layoutParams);
        }
        this.f13893g.post(new d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O(int i5) {
        View viewFindViewById;
        if (this.f13879Q) {
            P();
            if (i5 == 1) {
                View viewFindViewById2 = findViewById(H1.h.f2214D);
                if (viewFindViewById2 != null) {
                    viewFindViewById2.sendAccessibilityEvent(4);
                    return;
                }
                return;
            }
            if (i5 == 2) {
                View viewFindViewById3 = findViewById(H1.h.f2212B);
                if (viewFindViewById3 != null) {
                    viewFindViewById3.sendAccessibilityEvent(4);
                    return;
                }
                return;
            }
            if (i5 != 3 || (viewFindViewById = findViewById(H1.h.f2213C)) == null) {
                return;
            }
            viewFindViewById.sendAccessibilityEvent(4);
        }
    }

    private void P() {
        String strReplace;
        if (this.f13879Q) {
            View viewFindViewById = findViewById(H1.h.f2214D);
            View viewFindViewById2 = findViewById(H1.h.f2212B);
            View viewFindViewById3 = findViewById(H1.h.f2213C);
            if (viewFindViewById3 == null || viewFindViewById3.getVisibility() != 8) {
                strReplace = (G(1) + ((Object) this.f13889c.getText()) + G(2) + ((Object) this.f13888b.getText()) + G(3) + ((Object) this.f13886a.getText())).replace(" ", BuildConfig.FLAVOR).replace("廿十", "二十").replace("廿", "二十");
            } else {
                strReplace = (G(1) + ((Object) this.f13889c.getText()) + G(2) + ((Object) this.f13888b.getText())).replace(" ", BuildConfig.FLAVOR).replace("廿十", "二十").replace("廿", "二十");
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

    private void U(int i5, int i6, int i7, boolean z5, boolean z6) {
        int i8 = this.f13899m;
        if (i5 >= i8) {
            i8 = i5;
        }
        this.f13898l = i8;
        int i9 = this.f13900n;
        if (i5 > i9) {
            i5 = i9;
        }
        this.f13898l = i5;
        this.f13897k = i6;
        this.f13896j = i7;
        this.f13905s = null;
        this.f13905s = getShortMonths();
        this.f13893g.h0();
        this.f13892f.h0();
        this.f13891e.h0();
        if (this.f13912z != getYearMonths()) {
            int yearMonths = getYearMonths();
            this.f13912z = yearMonths;
            this.f13892f.T(yearMonths);
        }
        if (this.f13866A != getMonthDays()) {
            this.f13866A = getMonthDays();
            this.f13891e.T(getMonthDays());
        }
        if (z5) {
            this.f13893g.Y(this.f13898l - this.f13899m, true);
            this.f13897k = i6;
            this.f13892f.Y(i6, true);
            this.f13891e.Y(this.f13896j - 1, true);
        } else {
            this.f13893g.V(this.f13898l - this.f13899m);
            this.f13897k = i6;
            this.f13892f.V(i6);
            this.f13891e.V(this.f13896j - 1);
        }
        if (z6) {
            N(this.f13905s);
        }
    }

    private void V() {
        ScrollTextView scrollTextView = this.f13893g;
        e eVar = new e(1);
        int i5 = this.f13898l;
        int i6 = this.f13899m;
        int i7 = this.f13900n;
        scrollTextView.Z(eVar, -1.0f, i5 - i6, (i7 - i6) + 1, this.f13910x, 0, i7 - i6, false);
    }

    private Calendar getCurrentCalendar() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(5, 1);
        calendar.set(1, this.f13898l);
        calendar.set(2, this.f13897k);
        return calendar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getMonthDays() {
        if (!this.f13894h) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(5, 1);
            calendar.set(1, this.f13898l);
            calendar.set(2, this.f13897k);
            return calendar.getActualMaximum(5);
        }
        int i5 = this.f13897k;
        int iD = N1.e.d(this.f13898l);
        boolean z5 = false;
        if (iD != 0) {
            z5 = iD == i5;
        }
        if (iD == 0 || (iD != 0 && this.f13897k < iD)) {
            i5++;
        }
        return N1.e.c(this.f13898l, i5, z5);
    }

    private String[] getShortMonths() {
        Locale locale = Locale.getDefault();
        int i5 = 0;
        if (!locale.equals(this.f13908v) || this.f13909w == null) {
            synchronized (this.f13907u) {
                try {
                    if (!locale.equals(this.f13908v)) {
                        this.f13909w = new String[12];
                        for (int i6 = 0; i6 < 12; i6++) {
                            this.f13909w[i6] = DateUtils.getMonthString(i6, 20);
                        }
                        if (this.f13909w[0].startsWith("1")) {
                            int i7 = 0;
                            while (true) {
                                String[] strArr = this.f13909w;
                                if (i7 >= strArr.length) {
                                    break;
                                }
                                int i8 = i7 + 1;
                                strArr[i7] = String.valueOf(i8);
                                if (i7 < 9) {
                                    this.f13909w[i7] = "0" + this.f13909w[i7];
                                }
                                i7 = i8;
                            }
                        }
                        this.f13908v = locale;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        ScrollTextView scrollTextView = this.f13892f;
        if (scrollTextView != null && scrollTextView.getWidth() > 0 && this.f13909w != null) {
            while (true) {
                String[] strArr2 = this.f13909w;
                if (i5 >= strArr2.length) {
                    break;
                }
                if (this.f13892f.M(strArr2[i5]) > this.f13892f.getWidth()) {
                    this.f13909w = new String[]{"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
                    break;
                }
                i5++;
            }
        }
        return this.f13909w;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getYearMonths() {
        return (!this.f13894h || N1.e.d(this.f13898l) == 0) ? 12 : 13;
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
    public void setLeapUnitVisibility(int i5) {
        if (J() && I(i5)) {
            this.f13890d.setVisibility(0);
        } else {
            this.f13890d.setVisibility(8);
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

    static /* synthetic */ int x(DatePicker datePicker, int i5) {
        int i6 = datePicker.f13897k + i5;
        datePicker.f13897k = i6;
        return i6;
    }

    public String C(int i5) {
        String[] strArr = this.f13881S;
        if (i5 > strArr.length - 1) {
            return null;
        }
        return strArr[i5];
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01e9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String F(boolean r17, int r18, int r19, int r20, boolean r21) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 612
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.common.widget.DatePicker.F(boolean, int, int, int, boolean):java.lang.String");
    }

    public void H(int i5, int i6, int i7, f fVar, boolean z5) {
        if (this.f13898l != i5 || this.f13897k != i6 || this.f13896j != i7) {
            T(i5, i6, i7, z5);
        }
        this.f13895i = fVar;
        P();
    }

    public boolean J() {
        return this.f13894h;
    }

    public void L() {
        V();
        this.f13903q = -1;
        setMonthRange(this.f13898l);
        this.f13904r = -1;
        setDayRange(this.f13897k);
    }

    public void Q(int i5, int i6) {
        this.f13874I = i5;
        this.f13875J = i6;
    }

    public void R(boolean z5, boolean z6) {
        int i5;
        boolean z7;
        int[] iArrE;
        int i6;
        if (this.f13894h == z5) {
            return;
        }
        this.f13894h = z5;
        int[] iArr = {this.f13898l, this.f13897k + 1, this.f13896j, 0};
        int i7 = iArr[0];
        int iD = N1.e.d(i7);
        int iD2 = N1.e.d(iArr[0] - 1);
        if (this.f13894h) {
            iArrE = N1.e.f(iArr[0], iArr[1], iArr[2]);
            int i8 = iArrE[0];
            if ((i7 != i8 && iD2 != 0 && (iArrE[3] == 1 || iArrE[1] > iD2)) || (i7 == i8 && iD != 0 && (iArrE[3] == 1 || iArrE[1] > iD))) {
                iArrE[1] = iArrE[1] + 1;
            }
            this.f13886a.setAlpha(0.0f);
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
                this.f13886a.setAlpha(1.0f);
                iArrE = N1.e.e(iArr[0], i5, iArr[2], z7);
            }
            z7 = false;
            this.f13886a.setAlpha(1.0f);
            iArrE = N1.e.e(iArr[0], i5, iArr[2], z7);
        }
        M();
        int i10 = iArrE[0];
        int i11 = iArrE[1];
        U(i10, i11 + (-1) < 0 ? 12 : i11 - 1, iArrE[2], z6, false);
        setLeapUnitVisibility(this.f13897k);
    }

    public void S(int i5, List<Integer> list, int i6) {
        this.f13891e.c0(i5, list);
        this.f13892f.c0(i5, list);
        this.f13893g.c0(i5, list);
        this.f13886a.setTextColor(i6);
        this.f13888b.setTextColor(i6);
        this.f13889c.setTextColor(i6);
    }

    public void T(int i5, int i6, int i7, boolean z5) {
        U(i5, i6, i7, z5, true);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    public int getDayOfMonth() {
        return this.f13896j;
    }

    public TextView getDayUnit() {
        return this.f13886a;
    }

    public int getMonth() {
        return this.f13897k;
    }

    public int getYear() {
        return this.f13898l;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f13878M) {
            int width = getWidth();
            int width2 = this.f13873H.getWidth() - (this.f13876K * 2);
            int i5 = (width - width2) / 2;
            float f5 = i5;
            int i6 = this.f13874I;
            float f6 = i5 + width2;
            canvas.drawLine(f5, i6, f6, i6, this.f13877L);
            int i7 = this.f13875J;
            canvas.drawLine(f5, i7, f6, i7, this.f13877L);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(DatePicker.class.getName());
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        g gVar = (g) parcelable;
        super.onRestoreInstanceState(gVar.getSuperState());
        this.f13898l = gVar.f();
        this.f13897k = gVar.c();
        this.f13896j = gVar.a();
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        return new g(super.onSaveInstanceState(), this.f13898l, this.f13897k, this.f13896j, null);
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z5) {
        super.onWindowFocusChanged(z5);
        if (z5) {
            String[] shortMonths = getShortMonths();
            DateFormat dateFormat = shortMonths[0].startsWith("1") ? android.text.format.DateFormat.getDateFormat(getContext()) : android.text.format.DateFormat.getMediumDateFormat(getContext());
            String pattern = dateFormat instanceof SimpleDateFormat ? ((SimpleDateFormat) dateFormat).toPattern() : new String(android.text.format.DateFormat.getDateFormatOrder(getContext()));
            this.f13905s = shortMonths;
            if (this.f13906t.equals(pattern)) {
                return;
            }
            N(this.f13905s);
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z5) {
        super.setEnabled(z5);
        this.f13891e.setEnabled(z5);
        this.f13892f.setEnabled(z5);
        this.f13893g.setEnabled(z5);
    }

    public void setIsDrawFading(boolean z5) {
        this.f13893g.setIsDrawFading(z5);
        this.f13892f.setIsDrawFading(z5);
        this.f13891e.setIsDrawFading(z5);
    }

    public void setIsDrawLine(boolean z5) {
        this.f13878M = z5;
    }

    public void setLunar(boolean z5) {
        R(z5, true);
    }

    public void setMaxDate(long j5) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j5);
        this.f13902p = calendar;
        this.f13900n = calendar.get(1);
        L();
    }

    public void setMinDate(long j5) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j5);
        this.f13901o = calendar;
        this.f13899m = calendar.get(1);
        L();
    }

    public void setShowDayColumn(boolean z5) {
        FrameLayout frameLayout = (FrameLayout) findViewById(H1.h.f2213C);
        if (frameLayout != null) {
            frameLayout.setVisibility(z5 ? 0 : 8);
            P();
            this.f13891e.setVisibility(z5 ? 0 : 8);
        }
    }

    public DatePicker(Context context, AttributeSet attributeSet, int i5) throws Resources.NotFoundException {
        super(context, attributeSet, i5);
        this.f13894h = false;
        this.f13907u = new Object();
        this.f13910x = 5;
        this.f13911y = H1.i.f2312c;
        this.f13879Q = false;
        this.f13883U = false;
        this.f13885W = false;
        this.f13887a0 = 0;
        this.f13885W = context.getResources().getConfiguration().getLayoutDirection() == 1;
        ArrayList arrayList = new ArrayList();
        this.f13870E = arrayList;
        arrayList.add(Float.valueOf(context.getResources().getDimension(H1.f.f2111G)));
        this.f13870E.add(Float.valueOf(context.getResources().getDimension(H1.f.f2112H)));
        this.f13869D = context.getResources().getDimensionPixelOffset(H1.f.f2117M);
        ArrayList arrayList2 = new ArrayList();
        this.f13872G = arrayList2;
        arrayList2.add(Float.valueOf(context.getResources().getDimension(H1.f.f2109E)));
        this.f13872G.add(Float.valueOf(context.getResources().getDimension(H1.f.f2110F)));
        this.f13871F = Math.min(getContext().getResources().getDimensionPixelOffset(H1.f.f2115K), getContext().getResources().getDimensionPixelOffset(H1.f.f2116L));
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, H1.m.f2398C0);
        this.f13899m = typedArrayObtainStyledAttributes.getInt(H1.m.f2428H0, 1900);
        this.f13900n = typedArrayObtainStyledAttributes.getInt(H1.m.f2404D0, 2099);
        this.f13911y = typedArrayObtainStyledAttributes.getResourceId(H1.m.f2410E0, this.f13911y);
        this.f13910x = typedArrayObtainStyledAttributes.getInt(H1.m.f2434I0, this.f13910x);
        this.f13868C = typedArrayObtainStyledAttributes.getDimension(H1.m.f2422G0, this.f13868C);
        this.f13867B = typedArrayObtainStyledAttributes.getDimension(H1.m.f2416F0, this.f13867B);
        typedArrayObtainStyledAttributes.recycle();
        View.inflate(getContext(), this.f13911y, this);
        this.f13890d = (TextView) findViewById(H1.h.f2221K);
        TextView textView = (TextView) findViewById(H1.h.f2224N);
        this.f13888b = textView;
        if (textView != null) {
            textView.setText(H1.k.f2351i);
        }
        TextView textView2 = (TextView) findViewById(H1.h.f2226P);
        this.f13886a = textView2;
        if (textView2 != null) {
            textView2.setText(H1.k.f2348f);
        }
        TextView textView3 = (TextView) findViewById(H1.h.f2228R);
        this.f13889c = textView3;
        if (textView3 != null) {
            textView3.setText(H1.k.f2352j);
        }
        Calendar calendar = Calendar.getInstance();
        this.f13898l = calendar.get(1);
        this.f13897k = calendar.get(2);
        this.f13896j = calendar.get(5);
        this.f13895i = null;
        int actualMaximum = calendar.getActualMaximum(5);
        this.f13873H = (LinearLayout) findViewById(H1.h.f2218H);
        ScrollTextView scrollTextView = (ScrollTextView) findViewById(H1.h.f2225O);
        this.f13891e = scrollTextView;
        if (this.f13868C != 0.0f) {
            if (this.f13867B != 0.0f) {
                scrollTextView.a0((int) r4, (int) r8);
            }
        }
        this.f13891e.Z(new e(3), -1.0f, this.f13896j - 1, actualMaximum, this.f13910x, 0, actualMaximum - 1, true);
        ScrollTextView scrollTextView2 = (ScrollTextView) findViewById(H1.h.f2223M);
        this.f13892f = scrollTextView2;
        if (this.f13868C != 0.0f) {
            if (this.f13867B != 0.0f) {
                scrollTextView2.a0((int) r4, (int) r8);
            }
        }
        this.f13905s = getShortMonths();
        this.f13892f.Z(new e(2), -1.0f, this.f13897k, 12, this.f13910x, 0, 11, true);
        ScrollTextView scrollTextView3 = (ScrollTextView) findViewById(H1.h.f2227Q);
        this.f13893g = scrollTextView3;
        if (this.f13868C != 0.0f) {
            if (this.f13867B != 0.0f) {
                scrollTextView3.a0((int) r4, (int) r6);
            }
        }
        M();
        V();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Calendar calendar2 = Calendar.getInstance();
            this.f13901o = calendar2;
            calendar2.setTime(simpleDateFormat.parse(this.f13899m + "-01-01"));
        } catch (ParseException e6) {
            e6.printStackTrace();
        }
        try {
            Calendar calendar3 = Calendar.getInstance();
            this.f13902p = calendar3;
            calendar3.setTime(simpleDateFormat.parse(this.f13900n + "-12-31"));
        } catch (ParseException e7) {
            e7.printStackTrace();
        }
        N(this.f13905s);
        boolean zK = K();
        this.f13886a.setVisibility(zK ? 0 : 8);
        this.f13888b.setVisibility(zK ? 0 : 8);
        this.f13889c.setVisibility(zK ? 0 : 8);
        B();
        if (!isEnabled()) {
            setEnabled(false);
        }
        this.f13874I = 0;
        this.f13875J = 0;
        this.f13876K = context.getResources().getDimensionPixelSize(H1.f.f2147i);
        this.f13877L = new Paint();
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(H1.m.p6);
        int i6 = typedArrayObtainStyledAttributes2.getInt(H1.m.q6, context.getResources().getColor(H1.e.f2093o));
        typedArrayObtainStyledAttributes2.recycle();
        this.f13877L.setColor(i6);
        this.f13877L.setAntiAlias(true);
        this.f13877L.setStrokeWidth(context.getResources().getDimensionPixelSize(H1.f.f2143g));
        this.f13878M = false;
        setWillNotDraw(false);
        this.f13880R = getResources().getStringArray(H1.b.f2051b);
        this.f13881S = getResources().getStringArray(H1.b.f2050a);
        String str = String.format(Locale.getDefault(), "%d", 0);
        this.f13884V = new String[100];
        for (int i7 = 0; i7 < 100; i7++) {
            this.f13884V[i7] = String.format(Locale.getDefault(), "%d", Integer.valueOf(i7));
            if (i7 <= 9) {
                this.f13884V[i7] = str + this.f13884V[i7];
            }
        }
        String string = getResources().getString(H1.k.f2341E);
        this.f13882T = string;
        this.f13890d.setText(string);
        this.f13890d.setVisibility(8);
        if (Build.DEVICE.equals("mx4pro")) {
            this.f13893g.v(new a());
            this.f13892f.v(new b());
            this.f13891e.v(new c());
        }
        AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
        if (accessibilityManager != null) {
            this.f13879Q = accessibilityManager.isEnabled();
        }
    }
}
