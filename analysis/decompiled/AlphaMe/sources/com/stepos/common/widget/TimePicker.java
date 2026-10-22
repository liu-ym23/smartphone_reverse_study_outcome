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
import androidx.appcompat.app.C0186l;
import com.stepos.alphame.R;
import i2.AbstractC0620a;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

/* loaded from: classes.dex */
public class TimePicker extends FrameLayout {

    /* renamed from: t, reason: collision with root package name */
    public static final /* synthetic */ int f11866t = 0;

    /* renamed from: a, reason: collision with root package name */
    public int f11867a;

    /* renamed from: b, reason: collision with root package name */
    public int f11868b;

    /* renamed from: c, reason: collision with root package name */
    public Boolean f11869c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f11870d;

    /* renamed from: e, reason: collision with root package name */
    public ScrollTextView f11871e;

    /* renamed from: f, reason: collision with root package name */
    public ScrollTextView f11872f;

    /* renamed from: g, reason: collision with root package name */
    public ScrollTextView f11873g;

    /* renamed from: h, reason: collision with root package name */
    public final String f11874h;

    /* renamed from: i, reason: collision with root package name */
    public final String f11875i;

    /* renamed from: j, reason: collision with root package name */
    public TextView f11876j;

    /* renamed from: k, reason: collision with root package name */
    public TextView f11877k;

    /* renamed from: l, reason: collision with root package name */
    public final LinearLayout f11878l;

    /* renamed from: m, reason: collision with root package name */
    public final int f11879m;

    /* renamed from: n, reason: collision with root package name */
    public final Paint f11880n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f11881o;

    /* renamed from: p, reason: collision with root package name */
    public final boolean f11882p;

    /* renamed from: q, reason: collision with root package name */
    public int f11883q;

    /* renamed from: r, reason: collision with root package name */
    public final String[] f11884r;

    /* renamed from: s, reason: collision with root package name */
    public final String[] f11885s;

    public TimePicker(Context context, AttributeSet attributeSet) throws Resources.NotFoundException {
        int i4;
        super(context, attributeSet, 0);
        this.f11867a = 0;
        this.f11868b = 0;
        this.f11869c = Boolean.FALSE;
        this.f11870d = true;
        this.f11882p = false;
        this.f11883q = 5;
        String str = String.format(Locale.getDefault(), "%d", 0);
        this.f11884r = new String[100];
        for (int i5 = 0; i5 < 100; i5++) {
            this.f11884r[i5] = String.format(Locale.getDefault(), "%d", Integer.valueOf(i5));
            if (i5 <= 9) {
                String[] strArr = this.f11884r;
                StringBuilder sbS = B0.g.s(str);
                sbS.append(this.f11884r[i5]);
                strArr[i5] = sbS.toString();
            }
        }
        this.f11885s = new String[100];
        for (int i6 = 0; i6 < 100; i6++) {
            this.f11885s[i6] = String.format(Locale.getDefault(), "%d", Integer.valueOf(i6));
            if (i6 <= 9) {
                String[] strArr2 = this.f11885s;
                StringBuilder sbS2 = B0.g.s(str);
                sbS2.append(this.f11885s[i6]);
                strArr2[i6] = sbS2.toString();
            }
        }
        Calendar calendar = Calendar.getInstance();
        try {
            this.f11867a = calendar.get(11);
            this.f11868b = calendar.get(12);
            this.f11869c = Boolean.valueOf(DateFormat.is24HourFormat(context));
        } catch (Exception unused) {
            this.f11867a = 12;
            this.f11868b = 30;
            this.f11869c = Boolean.TRUE;
        }
        if (!this.f11869c.booleanValue() && (i4 = this.f11867a) >= 12) {
            this.f11867a = i4 - 12;
            this.f11870d = false;
        }
        String[] amPmStrings = new DateFormatSymbols().getAmPmStrings();
        this.f11874h = amPmStrings[0];
        this.f11875i = amPmStrings[1];
        b();
        this.f11879m = context.getResources().getDimensionPixelSize(R.dimen.mc_custom_time_picker_line_width_padding);
        Paint paint = new Paint();
        this.f11880n = paint;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(AbstractC0620a.f13037s);
        int i7 = typedArrayObtainStyledAttributes.getInt(11, context.getResources().getColor(R.color.mc_custom_date_picker_selected_gregorian_color));
        typedArrayObtainStyledAttributes.recycle();
        paint.setColor(i7);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(context.getResources().getDimensionPixelSize(R.dimen.mc_custom_time_picker_line_stroke_width));
        this.f11881o = false;
        setWillNotDraw(false);
        this.f11878l = (LinearLayout) findViewById(R.id.mc_column_parent);
        AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
        if (accessibilityManager != null) {
            this.f11882p = accessibilityManager.isEnabled();
        }
        c();
    }

    public final String a(int i4) {
        if (i4 != 1) {
            if (i4 == 2) {
                return String.valueOf(this.f11868b);
            }
            if (i4 != 3) {
                return "";
            }
            boolean z4 = !this.f11870d;
            return !z4 ? this.f11874h : z4 ? this.f11875i : "";
        }
        int i5 = this.f11867a;
        if (this.f11869c.booleanValue()) {
            return String.valueOf(i5);
        }
        if (i5 == 0) {
            i5 = 12;
        }
        return String.valueOf(i5);
    }

    public final void b() throws Resources.NotFoundException {
        if (getChildCount() > 0) {
            removeAllViews();
        }
        int i4 = 2;
        int i5 = 5;
        int i6 = 1;
        if (this.f11869c.booleanValue()) {
            if (this.f11869c.booleanValue()) {
                View.inflate(getContext(), R.layout.mc_time_picker_column_24, this);
                TextView textView = (TextView) findViewById(R.id.mc_scroll1_text);
                this.f11876j = textView;
                if (textView != null) {
                    textView.setText(R.string.mc_date_time_hour);
                }
                TextView textView2 = (TextView) findViewById(R.id.mc_scroll2_text);
                this.f11877k = textView2;
                if (textView2 != null) {
                    textView2.setText(R.string.mc_date_time_min);
                }
                ScrollTextView scrollTextView = (ScrollTextView) findViewById(R.id.mc_scroll1);
                this.f11871e = scrollTextView;
                scrollTextView.i(new C0186l(i6, i5, this), this.f11867a, 24, this.f11883q, 23, true);
                ScrollTextView scrollTextView2 = (ScrollTextView) findViewById(R.id.mc_scroll2);
                this.f11872f = scrollTextView2;
                scrollTextView2.i(new C0186l(i4, i5, this), this.f11868b, 60, this.f11883q, 59, true);
                this.f11873g = null;
                ArrayList arrayList = new ArrayList();
                arrayList.add(Float.valueOf(getContext().getResources().getDimension(R.dimen.mc_picker_normal_number_size_one)));
                arrayList.add(Float.valueOf(getContext().getResources().getDimension(R.dimen.mc_picker_normal_number_size_two)));
                float fMin = Math.min(getContext().getResources().getDimensionPixelOffset(R.dimen.mc_picker_selected_number_max_size), getContext().getResources().getDimensionPixelOffset(R.dimen.mc_picker_selected_number_size));
                this.f11871e.n(fMin, arrayList);
                this.f11872f.n(fMin, arrayList);
            }
        } else if (!this.f11869c.booleanValue()) {
            View.inflate(getContext(), R.layout.mc_time_picker_column_12, this);
            TextView textView3 = (TextView) findViewById(R.id.mc_scroll1_text);
            this.f11876j = textView3;
            if (textView3 != null) {
                textView3.setText(R.string.mc_date_time_hour);
            }
            TextView textView4 = (TextView) findViewById(R.id.mc_scroll2_text);
            this.f11877k = textView4;
            if (textView4 != null) {
                textView4.setText(R.string.mc_date_time_min);
            }
            ScrollTextView scrollTextView3 = (ScrollTextView) findViewById(R.id.mc_scroll1);
            this.f11871e = scrollTextView3;
            scrollTextView3.i(new C0186l(i6, i5, this), this.f11867a, 12, this.f11883q, 11, true);
            ScrollTextView scrollTextView4 = (ScrollTextView) findViewById(R.id.mc_scroll2);
            this.f11872f = scrollTextView4;
            scrollTextView4.i(new C0186l(i4, i5, this), this.f11868b, 60, this.f11883q, 59, true);
            ScrollTextView scrollTextView5 = (ScrollTextView) findViewById(R.id.mc_scroll3);
            this.f11873g = scrollTextView5;
            scrollTextView5.i(new C0186l(3, i5, this), !this.f11870d ? 1 : 0, 2, this.f11883q, 1, false);
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(Float.valueOf(getContext().getResources().getDimension(R.dimen.mc_picker_normal_number_size_one)));
            arrayList2.add(Float.valueOf(getContext().getResources().getDimension(R.dimen.mc_picker_normal_number_size_two)));
            float fMin2 = Math.min(getContext().getResources().getDimensionPixelOffset(R.dimen.mc_picker_selected_number_max_size), getContext().getResources().getDimensionPixelOffset(R.dimen.mc_picker_selected_number_size));
            this.f11871e.n(fMin2, arrayList2);
            this.f11872f.n(fMin2, arrayList2);
            ScrollTextView scrollTextView6 = this.f11873g;
            scrollTextView6.l(getContext().getResources().getDimension(R.dimen.mc_picker_selected_word_size), getContext().getResources().getDimension(R.dimen.mc_picker_normal_word_size_two), scrollTextView6.f11751d, scrollTextView6.f11752e);
        }
        int color = getContext().getResources().getColor(R.color.mc_picker_selected_color);
        ArrayList arrayList3 = new ArrayList();
        arrayList3.add(Integer.valueOf(getContext().getResources().getColor(R.color.mc_picker_unselected_color_one)));
        arrayList3.add(Integer.valueOf(getContext().getResources().getColor(R.color.mc_picker_unselected_color_two)));
        this.f11871e.k(color, arrayList3);
        this.f11872f.k(color, arrayList3);
        ScrollTextView scrollTextView7 = this.f11873g;
        if (scrollTextView7 != null) {
            scrollTextView7.k(color, arrayList3);
        }
        this.f11876j.setTextColor(color);
        this.f11877k.setTextColor(color);
        if (isEnabled()) {
            return;
        }
        setEnabled(false);
    }

    public final void c() {
        if (this.f11882p) {
            View viewFindViewById = findViewById(R.id.mc_column3Layout);
            View viewFindViewById2 = findViewById(R.id.mc_column2Layout);
            View viewFindViewById3 = findViewById(R.id.mc_column1Layout);
            String str = "";
            if (!this.f11869c.booleanValue()) {
                str = "" + a(3);
            }
            StringBuilder sbS = B0.g.s(str);
            sbS.append(a(1));
            sbS.append((Object) this.f11876j.getText());
            sbS.append(a(2));
            sbS.append((Object) this.f11877k.getText());
            String string = sbS.toString();
            if (viewFindViewById != null) {
                viewFindViewById.setFocusable(true);
                viewFindViewById.setContentDescription("上下滚动设置上下午，当前时间是" + string);
            }
            if (viewFindViewById3 != null) {
                viewFindViewById3.setFocusable(true);
                viewFindViewById3.setContentDescription("上下滚动设置时，当前时间是" + string);
            }
            if (viewFindViewById2 != null) {
                viewFindViewById2.setFocusable(true);
                viewFindViewById2.setContentDescription("上下滚动设置分，当前时间是" + string);
            }
        }
    }

    public final void d(int i4, int i5, boolean z4) throws Resources.NotFoundException {
        boolean z5;
        boolean z6;
        boolean z7 = false;
        if (!z4) {
            this.f11870d = true;
            if (this.f11867a != i4) {
                this.f11867a = i4;
                z5 = true;
            } else {
                z5 = false;
            }
            int i6 = this.f11867a;
            z6 = z5;
            if (i6 >= 12) {
                this.f11867a = i6 - 12;
                this.f11870d = false;
                z6 = z5;
            }
        } else if (this.f11867a != i4) {
            this.f11867a = i4;
            z6 = true;
        } else {
            z6 = false;
        }
        if (this.f11868b != i5) {
            this.f11868b = i5;
            z7 = true;
        }
        if (z4 != this.f11869c.booleanValue()) {
            this.f11869c = Boolean.valueOf(z4);
            b();
        }
        if (z6) {
            ScrollTextView scrollTextView = this.f11871e;
            int i7 = this.f11867a;
            B b4 = scrollTextView.f11764q;
            scrollTextView.g(b4.f11445c, i7, b4.f11443a, b4.f11444b);
        }
        if (z7) {
            ScrollTextView scrollTextView2 = this.f11872f;
            int i8 = this.f11868b;
            B b5 = scrollTextView2.f11764q;
            scrollTextView2.g(b5.f11445c, i8, b5.f11443a, b5.f11444b);
        }
        ScrollTextView scrollTextView3 = this.f11873g;
        if (scrollTextView3 != null) {
            int i9 = !this.f11870d ? 1 : 0;
            B b6 = scrollTextView3.f11764q;
            scrollTextView3.g(b6.f11445c, i9, b6.f11443a, b6.f11444b);
        }
    }

    @Override // android.view.View
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (!this.f11882p || accessibilityEvent.getEventType() != 32) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        String str = "";
        if (!this.f11869c.booleanValue()) {
            str = "" + a(3);
        }
        StringBuilder sbS = B0.g.s(str);
        sbS.append(a(1));
        sbS.append((Object) this.f11876j.getText());
        sbS.append(a(2));
        sbS.append((Object) this.f11877k.getText());
        accessibilityEvent.getText().add(sbS.toString());
        return false;
    }

    public int getCurrentHour() {
        if (!this.f11869c.booleanValue() && !this.f11870d) {
            return this.f11867a + 12;
        }
        return this.f11867a;
    }

    public Integer getCurrentMinute() {
        return Integer.valueOf(this.f11868b);
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f11881o) {
            int width = getWidth();
            int width2 = this.f11878l.getWidth() - (this.f11879m * 2);
            int i4 = (width - width2) / 2;
            float f4 = i4;
            float f5 = 0;
            float f6 = i4 + width2;
            Paint paint = this.f11880n;
            canvas.drawLine(f4, f5, f6, f5, paint);
            canvas.drawLine(f4, f5, f6, f5, paint);
        }
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(TimePicker.class.getName());
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z4, int i4, int i5, int i6, int i7) {
        super.onLayout(z4, i4, i5, i6, i7);
        if (getVisibility() == 0) {
            if (getHeight() < this.f11871e.getSelectedItemHeight() + ((this.f11883q - 1) * this.f11871e.getItemHeight())) {
                this.f11883q = 3;
                this.f11871e.setVisibleItems(3);
                this.f11872f.setVisibleItems(3);
            } else {
                this.f11883q = 5;
                this.f11871e.setVisibleItems(5);
                this.f11872f.setVisibleItems(5);
            }
            int height = (int) ((getHeight() - (this.f11876j.getLineHeight() - this.f11876j.getTextSize())) / 2.0f);
            TextView textView = this.f11876j;
            textView.setPadding(textView.getPaddingLeft(), height, this.f11876j.getPaddingRight(), this.f11876j.getPaddingBottom());
            TextView textView2 = this.f11877k;
            textView2.setPadding(textView2.getPaddingLeft(), height, this.f11877k.getPaddingRight(), this.f11877k.getPaddingBottom());
        }
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) throws Resources.NotFoundException {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        d(savedState.f11886a, savedState.f11887b, this.f11869c.booleanValue());
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), getCurrentHour(), this.f11868b);
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z4) {
        super.onWindowFocusChanged(z4);
    }

    public void setCurrentHour(Integer num) throws Resources.NotFoundException {
        if (num == null || num.intValue() == getCurrentHour()) {
            return;
        }
        d(num.intValue(), this.f11868b, this.f11869c.booleanValue());
    }

    public void setCurrentMinute(Integer num) throws Resources.NotFoundException {
        d(getCurrentHour(), num.intValue(), this.f11869c.booleanValue());
    }

    @Override // android.view.View
    public void setEnabled(boolean z4) {
        super.setEnabled(z4);
        this.f11872f.setEnabled(z4);
        this.f11871e.setEnabled(z4);
        ScrollTextView scrollTextView = this.f11873g;
        if (scrollTextView != null) {
            scrollTextView.setEnabled(z4);
        }
    }

    public void setIs24HourView(Boolean bool) throws Resources.NotFoundException {
        d(getCurrentHour(), this.f11868b, bool.booleanValue());
    }

    public void setIsDrawLine(boolean z4) {
        this.f11881o = z4;
    }

    public void setOnTimeChangedListener(M m4) {
    }

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new N();

        /* renamed from: a, reason: collision with root package name */
        public final int f11886a;

        /* renamed from: b, reason: collision with root package name */
        public final int f11887b;

        public SavedState(Parcelable parcelable, int i4, int i5) {
            super(parcelable);
            this.f11886a = i4;
            this.f11887b = i5;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i4) {
            super.writeToParcel(parcel, i4);
            parcel.writeInt(this.f11886a);
            parcel.writeInt(this.f11887b);
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f11886a = parcel.readInt();
            this.f11887b = parcel.readInt();
        }
    }
}
