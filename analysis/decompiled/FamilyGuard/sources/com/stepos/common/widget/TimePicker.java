package com.stepos.common.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.format.DateFormat;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.stepos.common.widget.ScrollTextView;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import org.libpag.BuildConfig;

/* loaded from: classes.dex */
public class TimePicker extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    private int f14352a;

    /* renamed from: b, reason: collision with root package name */
    private int f14353b;

    /* renamed from: c, reason: collision with root package name */
    private Boolean f14354c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f14355d;

    /* renamed from: e, reason: collision with root package name */
    private ScrollTextView f14356e;

    /* renamed from: f, reason: collision with root package name */
    private ScrollTextView f14357f;

    /* renamed from: g, reason: collision with root package name */
    private ScrollTextView f14358g;

    /* renamed from: h, reason: collision with root package name */
    private String f14359h;

    /* renamed from: i, reason: collision with root package name */
    private String f14360i;

    /* renamed from: j, reason: collision with root package name */
    private TextView f14361j;

    /* renamed from: k, reason: collision with root package name */
    private TextView f14362k;

    /* renamed from: l, reason: collision with root package name */
    private b f14363l;

    /* renamed from: m, reason: collision with root package name */
    private LinearLayout f14364m;

    /* renamed from: n, reason: collision with root package name */
    private int f14365n;

    /* renamed from: o, reason: collision with root package name */
    private int f14366o;

    /* renamed from: p, reason: collision with root package name */
    private int f14367p;

    /* renamed from: q, reason: collision with root package name */
    private Paint f14368q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f14369r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f14370s;

    /* renamed from: t, reason: collision with root package name */
    private int f14371t;

    /* renamed from: u, reason: collision with root package name */
    String[] f14372u;

    /* renamed from: v, reason: collision with root package name */
    String[] f14373v;

    public interface b {
        void a(TimePicker timePicker, int i5, int i6);
    }

    private class d implements ScrollTextView.e {

        /* renamed from: a, reason: collision with root package name */
        int f14376a;

        d(int i5) {
            this.f14376a = i5;
        }

        @Override // com.stepos.common.widget.ScrollTextView.e
        public void a(View view, int i5, int i6) {
            int i7 = this.f14376a;
            if (i7 == 1) {
                TimePicker.this.f14352a = i6;
            } else if (i7 == 2) {
                TimePicker.this.f14353b = i6;
            } else {
                if (i7 != 3) {
                    return;
                }
                TimePicker.this.f14355d = i6 == 0;
            }
            if (TimePicker.this.f14363l != null) {
                b bVar = TimePicker.this.f14363l;
                TimePicker timePicker = TimePicker.this;
                bVar.a(timePicker, timePicker.getCurrentHour(), TimePicker.this.getCurrentMinute().intValue());
            }
            TimePicker.this.n(this.f14376a);
        }

        @Override // com.stepos.common.widget.ScrollTextView.e
        public String b(int i5) {
            int i6 = this.f14376a;
            if (i6 == 1) {
                if (TimePicker.this.l()) {
                    return TimePicker.this.f14372u[i5];
                }
                if (i5 == 0) {
                    i5 = 12;
                }
                return TimePicker.this.f14372u[i5];
            }
            if (i6 == 2) {
                return TimePicker.this.f14373v[i5];
            }
            if (i6 != 3) {
                return null;
            }
            if (i5 == 0) {
                return TimePicker.this.f14359h;
            }
            if (i5 == 1) {
                return TimePicker.this.f14360i;
            }
            return null;
        }
    }

    public TimePicker(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private String h(int i5) {
        if (i5 != 1) {
            if (i5 == 2) {
                return String.valueOf(this.f14353b);
            }
            if (i5 != 3) {
                return BuildConfig.FLAVOR;
            }
            boolean z5 = this.f14355d;
            return z5 ? this.f14359h : z5 ^ true ? this.f14360i : BuildConfig.FLAVOR;
        }
        int i6 = this.f14352a;
        if (l()) {
            return String.valueOf(i6);
        }
        if (i6 == 0) {
            i6 = 12;
        }
        return String.valueOf(i6);
    }

    private void i() throws Resources.NotFoundException {
        if (getChildCount() > 0) {
            removeAllViews();
        }
        if (this.f14354c.booleanValue()) {
            k();
        } else {
            j();
        }
        int color = getContext().getResources().getColor(H1.e.f2094p);
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(getContext().getResources().getColor(H1.e.f2096r)));
        arrayList.add(Integer.valueOf(getContext().getResources().getColor(H1.e.f2097s)));
        this.f14356e.c0(color, arrayList);
        this.f14357f.c0(color, arrayList);
        ScrollTextView scrollTextView = this.f14358g;
        if (scrollTextView != null) {
            scrollTextView.c0(color, arrayList);
        }
        this.f14361j.setTextColor(color);
        this.f14362k.setTextColor(color);
        if (isEnabled()) {
            return;
        }
        setEnabled(false);
    }

    private void j() {
        if (this.f14354c.booleanValue()) {
            return;
        }
        View.inflate(getContext(), H1.i.f2316g, this);
        TextView textView = (TextView) findViewById(H1.h.f2224N);
        this.f14361j = textView;
        if (textView != null) {
            textView.setText(H1.k.f2349g);
        }
        TextView textView2 = (TextView) findViewById(H1.h.f2226P);
        this.f14362k = textView2;
        if (textView2 != null) {
            textView2.setText(H1.k.f2350h);
        }
        ScrollTextView scrollTextView = (ScrollTextView) findViewById(H1.h.f2223M);
        this.f14356e = scrollTextView;
        scrollTextView.Z(new d(1), -1.0f, this.f14352a, 12, this.f14371t, 0, 11, true);
        ScrollTextView scrollTextView2 = (ScrollTextView) findViewById(H1.h.f2225O);
        this.f14357f = scrollTextView2;
        scrollTextView2.Z(new d(2), -1.0f, this.f14353b, 60, this.f14371t, 0, 59, true);
        ScrollTextView scrollTextView3 = (ScrollTextView) findViewById(H1.h.f2227Q);
        this.f14358g = scrollTextView3;
        scrollTextView3.Z(new d(3), -1.0f, !this.f14355d ? 1 : 0, 2, this.f14371t, 0, 1, false);
        ArrayList arrayList = new ArrayList();
        arrayList.add(Float.valueOf(getContext().getResources().getDimension(H1.f.f2109E)));
        arrayList.add(Float.valueOf(getContext().getResources().getDimension(H1.f.f2110F)));
        float fMin = Math.min(getContext().getResources().getDimensionPixelOffset(H1.f.f2115K), getContext().getResources().getDimensionPixelOffset(H1.f.f2116L));
        this.f14356e.g0(fMin, arrayList);
        this.f14357f.g0(fMin, arrayList);
        this.f14358g.f0(getContext().getResources().getDimension(H1.f.f2117M), getContext().getResources().getDimension(H1.f.f2112H));
    }

    private void k() {
        if (this.f14354c.booleanValue()) {
            View.inflate(getContext(), H1.i.f2317h, this);
            TextView textView = (TextView) findViewById(H1.h.f2224N);
            this.f14361j = textView;
            if (textView != null) {
                textView.setText(H1.k.f2349g);
            }
            TextView textView2 = (TextView) findViewById(H1.h.f2226P);
            this.f14362k = textView2;
            if (textView2 != null) {
                textView2.setText(H1.k.f2350h);
            }
            ScrollTextView scrollTextView = (ScrollTextView) findViewById(H1.h.f2223M);
            this.f14356e = scrollTextView;
            scrollTextView.Z(new d(1), -1.0f, this.f14352a, 24, this.f14371t, 0, 23, true);
            ScrollTextView scrollTextView2 = (ScrollTextView) findViewById(H1.h.f2225O);
            this.f14357f = scrollTextView2;
            scrollTextView2.Z(new d(2), -1.0f, this.f14353b, 60, this.f14371t, 0, 59, true);
            this.f14358g = null;
            ArrayList arrayList = new ArrayList();
            arrayList.add(Float.valueOf(getContext().getResources().getDimension(H1.f.f2109E)));
            arrayList.add(Float.valueOf(getContext().getResources().getDimension(H1.f.f2110F)));
            float fMin = Math.min(getContext().getResources().getDimensionPixelOffset(H1.f.f2115K), getContext().getResources().getDimensionPixelOffset(H1.f.f2116L));
            this.f14356e.g0(fMin, arrayList);
            this.f14357f.g0(fMin, arrayList);
        }
    }

    private void m() {
        int height = (int) ((getHeight() - (this.f14361j.getLineHeight() - this.f14361j.getTextSize())) / 2.0f);
        TextView textView = this.f14361j;
        textView.setPadding(textView.getPaddingLeft(), height, this.f14361j.getPaddingRight(), this.f14361j.getPaddingBottom());
        TextView textView2 = this.f14362k;
        textView2.setPadding(textView2.getPaddingLeft(), height, this.f14362k.getPaddingRight(), this.f14362k.getPaddingBottom());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(int i5) {
        View viewFindViewById;
        if (this.f14370s) {
            o();
            if (i5 == 3) {
                View viewFindViewById2 = findViewById(H1.h.f2214D);
                if (viewFindViewById2 != null) {
                    viewFindViewById2.sendAccessibilityEvent(4);
                    return;
                }
                return;
            }
            if (i5 == 1) {
                View viewFindViewById3 = findViewById(H1.h.f2212B);
                if (viewFindViewById3 != null) {
                    viewFindViewById3.sendAccessibilityEvent(4);
                    return;
                }
                return;
            }
            if (i5 != 2 || (viewFindViewById = findViewById(H1.h.f2213C)) == null) {
                return;
            }
            viewFindViewById.sendAccessibilityEvent(4);
        }
    }

    private void o() {
        if (this.f14370s) {
            View viewFindViewById = findViewById(H1.h.f2214D);
            View viewFindViewById2 = findViewById(H1.h.f2213C);
            View viewFindViewById3 = findViewById(H1.h.f2212B);
            boolean zBooleanValue = this.f14354c.booleanValue();
            String str = BuildConfig.FLAVOR;
            if (!zBooleanValue) {
                str = BuildConfig.FLAVOR + h(3);
            }
            String str2 = str + h(1) + ((Object) this.f14361j.getText()) + h(2) + ((Object) this.f14362k.getText());
            if (viewFindViewById != null) {
                viewFindViewById.setFocusable(true);
                viewFindViewById.setContentDescription("上下滚动设置上下午，当前时间是" + str2);
            }
            if (viewFindViewById3 != null) {
                viewFindViewById3.setFocusable(true);
                viewFindViewById3.setContentDescription("上下滚动设置时，当前时间是" + str2);
            }
            if (viewFindViewById2 != null) {
                viewFindViewById2.setFocusable(true);
                viewFindViewById2.setContentDescription("上下滚动设置分，当前时间是" + str2);
            }
        }
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (!this.f14370s || accessibilityEvent.getEventType() != 32) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        boolean zBooleanValue = this.f14354c.booleanValue();
        String str = BuildConfig.FLAVOR;
        if (!zBooleanValue) {
            str = BuildConfig.FLAVOR + h(3);
        }
        accessibilityEvent.getText().add(str + h(1) + ((Object) this.f14361j.getText()) + h(2) + ((Object) this.f14362k.getText()));
        return false;
    }

    public int getCurrentHour() {
        if (!this.f14354c.booleanValue() && !this.f14355d) {
            return this.f14352a + 12;
        }
        return this.f14352a;
    }

    public Integer getCurrentMinute() {
        return Integer.valueOf(this.f14353b);
    }

    public boolean l() {
        return this.f14354c.booleanValue();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f14369r) {
            int width = getWidth();
            int width2 = this.f14364m.getWidth() - (this.f14367p * 2);
            int i5 = (width - width2) / 2;
            float f5 = i5;
            int i6 = this.f14365n;
            float f6 = i5 + width2;
            canvas.drawLine(f5, i6, f6, i6, this.f14368q);
            int i7 = this.f14366o;
            canvas.drawLine(f5, i7, f6, i7, this.f14368q);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(TimePicker.class.getName());
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z5, int i5, int i6, int i7, int i8) {
        super.onLayout(z5, i5, i6, i7, i8);
        if (getVisibility() == 0) {
            if (getHeight() < (this.f14356e.getItemHeight() * (this.f14371t - 1)) + this.f14356e.getSelectedItemHeight()) {
                this.f14371t = 3;
                this.f14356e.setVisibleItems(3);
                this.f14357f.setVisibleItems(3);
            } else {
                this.f14371t = 5;
                this.f14356e.setVisibleItems(5);
                this.f14357f.setVisibleItems(5);
            }
            m();
        }
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) throws Resources.NotFoundException {
        c cVar = (c) parcelable;
        super.onRestoreInstanceState(cVar.getSuperState());
        q(cVar.f14374a, cVar.f14375b, this.f14354c.booleanValue());
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        return new c(super.onSaveInstanceState(), getCurrentHour(), this.f14353b);
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z5) {
        super.onWindowFocusChanged(z5);
    }

    public void p(int i5, int i6) {
        this.f14365n = i5;
        this.f14366o = i6;
    }

    public void q(int i5, int i6, boolean z5) throws Resources.NotFoundException {
        boolean z6;
        boolean z7;
        boolean z8 = false;
        if (!z5) {
            this.f14355d = true;
            if (this.f14352a != i5) {
                this.f14352a = i5;
                z6 = true;
            } else {
                z6 = false;
            }
            int i7 = this.f14352a;
            z7 = z6;
            if (i7 >= 12) {
                this.f14352a = i7 - 12;
                this.f14355d = false;
                z7 = z6;
            }
        } else if (this.f14352a != i5) {
            this.f14352a = i5;
            z7 = true;
        } else {
            z7 = false;
        }
        if (this.f14353b != i6) {
            this.f14353b = i6;
            z8 = true;
        }
        if (z5 != this.f14354c.booleanValue()) {
            this.f14354c = Boolean.valueOf(z5);
            i();
        }
        if (z7) {
            this.f14356e.V(this.f14352a);
        }
        if (z8) {
            this.f14357f.V(this.f14353b);
        }
        ScrollTextView scrollTextView = this.f14358g;
        if (scrollTextView != null) {
            scrollTextView.V(!this.f14355d ? 1 : 0);
        }
    }

    public void setCurrentHour(Integer num) throws Resources.NotFoundException {
        if (num == null || num.intValue() == getCurrentHour()) {
            return;
        }
        q(num.intValue(), this.f14353b, this.f14354c.booleanValue());
    }

    public void setCurrentMinute(Integer num) throws Resources.NotFoundException {
        q(getCurrentHour(), num.intValue(), this.f14354c.booleanValue());
    }

    @Override // android.view.View
    public void setEnabled(boolean z5) {
        super.setEnabled(z5);
        this.f14357f.setEnabled(z5);
        this.f14356e.setEnabled(z5);
        ScrollTextView scrollTextView = this.f14358g;
        if (scrollTextView != null) {
            scrollTextView.setEnabled(z5);
        }
    }

    public void setIs24HourView(Boolean bool) throws Resources.NotFoundException {
        q(getCurrentHour(), this.f14353b, bool.booleanValue());
    }

    public void setIsDrawLine(boolean z5) {
        this.f14369r = z5;
    }

    public void setOnTimeChangedListener(b bVar) {
        this.f14363l = bVar;
    }

    private static class c extends View.BaseSavedState {
        public static final Parcelable.Creator<c> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        private final int f14374a;

        /* renamed from: b, reason: collision with root package name */
        private final int f14375b;

        class a implements Parcelable.Creator<c> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public c createFromParcel(Parcel parcel) {
                return new c(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public c[] newArray(int i5) {
                return new c[i5];
            }
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i5) {
            super.writeToParcel(parcel, i5);
            parcel.writeInt(this.f14374a);
            parcel.writeInt(this.f14375b);
        }

        private c(Parcelable parcelable, int i5, int i6) {
            super(parcelable);
            this.f14374a = i5;
            this.f14375b = i6;
        }

        private c(Parcel parcel) {
            super(parcel);
            this.f14374a = parcel.readInt();
            this.f14375b = parcel.readInt();
        }
    }

    public TimePicker(Context context, AttributeSet attributeSet, int i5) throws Resources.NotFoundException {
        int i6;
        super(context, attributeSet, i5);
        this.f14352a = 0;
        this.f14353b = 0;
        this.f14354c = Boolean.FALSE;
        this.f14355d = true;
        this.f14370s = false;
        this.f14371t = 5;
        String str = String.format(Locale.getDefault(), "%d", 0);
        this.f14372u = new String[100];
        for (int i7 = 0; i7 < 100; i7++) {
            this.f14372u[i7] = String.format(Locale.getDefault(), "%d", Integer.valueOf(i7));
            if (i7 <= 9) {
                this.f14372u[i7] = str + this.f14372u[i7];
            }
        }
        this.f14373v = new String[100];
        for (int i8 = 0; i8 < 100; i8++) {
            this.f14373v[i8] = String.format(Locale.getDefault(), "%d", Integer.valueOf(i8));
            if (i8 <= 9) {
                this.f14373v[i8] = str + this.f14373v[i8];
            }
        }
        Calendar calendar = Calendar.getInstance();
        try {
            this.f14352a = calendar.get(11);
            this.f14353b = calendar.get(12);
            this.f14354c = Boolean.valueOf(DateFormat.is24HourFormat(context));
        } catch (Exception unused) {
            this.f14352a = 12;
            this.f14353b = 30;
            this.f14354c = Boolean.TRUE;
        }
        if (!this.f14354c.booleanValue() && (i6 = this.f14352a) >= 12) {
            this.f14352a = i6 - 12;
            this.f14355d = false;
        }
        String[] amPmStrings = new DateFormatSymbols().getAmPmStrings();
        this.f14359h = amPmStrings[0];
        this.f14360i = amPmStrings[1];
        i();
        this.f14365n = 0;
        this.f14366o = 0;
        this.f14367p = context.getResources().getDimensionPixelSize(H1.f.f2147i);
        this.f14368q = new Paint();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(H1.m.p6);
        int i9 = typedArrayObtainStyledAttributes.getInt(H1.m.q6, context.getResources().getColor(H1.e.f2093o));
        typedArrayObtainStyledAttributes.recycle();
        this.f14368q.setColor(i9);
        this.f14368q.setAntiAlias(true);
        this.f14368q.setStrokeWidth(context.getResources().getDimensionPixelSize(H1.f.f2143g));
        this.f14369r = false;
        setWillNotDraw(false);
        this.f14364m = (LinearLayout) findViewById(H1.h.f2218H);
        AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
        if (accessibilityManager != null) {
            this.f14370s = accessibilityManager.isEnabled();
        }
        o();
    }
}
