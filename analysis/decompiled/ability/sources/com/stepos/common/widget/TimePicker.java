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
import com.google.android.material.timepicker.TimeModel;
import com.stepos.ability.R;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

/* loaded from: classes3.dex */
public class TimePicker extends FrameLayout {

    /* renamed from: t, reason: collision with root package name */
    public static final /* synthetic */ int f3793t = 0;

    /* renamed from: a, reason: collision with root package name */
    public int f3794a;
    public int b;
    public Boolean c;
    public boolean d;
    public ScrollTextView e;
    public ScrollTextView f;
    public ScrollTextView g;
    public final String h;
    public final String i;

    /* renamed from: j, reason: collision with root package name */
    public TextView f3795j;
    public TextView k;
    public final LinearLayout l;
    public final int m;
    public final Paint n;
    public boolean o;
    public final boolean p;

    /* renamed from: q, reason: collision with root package name */
    public int f3796q;

    /* renamed from: r, reason: collision with root package name */
    public final String[] f3797r;

    /* renamed from: s, reason: collision with root package name */
    public final String[] f3798s;

    public TimePicker(Context context, AttributeSet attributeSet) throws Resources.NotFoundException {
        int i;
        super(context, attributeSet, 0);
        this.f3794a = 0;
        this.b = 0;
        this.c = Boolean.FALSE;
        this.d = true;
        this.p = false;
        this.f3796q = 5;
        String str = String.format(Locale.getDefault(), TimeModel.NUMBER_FORMAT, 0);
        this.f3797r = new String[100];
        for (int i6 = 0; i6 < 100; i6++) {
            this.f3797r[i6] = String.format(Locale.getDefault(), TimeModel.NUMBER_FORMAT, Integer.valueOf(i6));
            if (i6 <= 9) {
                String[] strArr = this.f3797r;
                StringBuilder sbV = androidx.compose.foundation.b.v(str);
                sbV.append(this.f3797r[i6]);
                strArr[i6] = sbV.toString();
            }
        }
        this.f3798s = new String[100];
        for (int i10 = 0; i10 < 100; i10++) {
            this.f3798s[i10] = String.format(Locale.getDefault(), TimeModel.NUMBER_FORMAT, Integer.valueOf(i10));
            if (i10 <= 9) {
                String[] strArr2 = this.f3798s;
                StringBuilder sbV2 = androidx.compose.foundation.b.v(str);
                sbV2.append(this.f3798s[i10]);
                strArr2[i10] = sbV2.toString();
            }
        }
        Calendar calendar = Calendar.getInstance();
        try {
            this.f3794a = calendar.get(11);
            this.b = calendar.get(12);
            this.c = Boolean.valueOf(DateFormat.is24HourFormat(context));
        } catch (Exception unused) {
            this.f3794a = 12;
            this.b = 30;
            this.c = Boolean.TRUE;
        }
        if (!this.c.booleanValue() && (i = this.f3794a) >= 12) {
            this.f3794a = i - 12;
            this.d = false;
        }
        String[] amPmStrings = new DateFormatSymbols().getAmPmStrings();
        this.h = amPmStrings[0];
        this.i = amPmStrings[1];
        b();
        this.m = context.getResources().getDimensionPixelSize(R.dimen.mc_custom_time_picker_line_width_padding);
        Paint paint = new Paint();
        this.n = paint;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(V4.s.f1375s);
        int i11 = typedArrayObtainStyledAttributes.getInt(11, context.getResources().getColor(R.color.mc_custom_date_picker_selected_gregorian_color));
        typedArrayObtainStyledAttributes.recycle();
        paint.setColor(i11);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(context.getResources().getDimensionPixelSize(R.dimen.mc_custom_time_picker_line_stroke_width));
        this.o = false;
        setWillNotDraw(false);
        this.l = (LinearLayout) findViewById(R.id.mc_column_parent);
        AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
        if (accessibilityManager != null) {
            this.p = accessibilityManager.isEnabled();
        }
        c();
    }

    public final String a(int i) {
        if (i != 1) {
            if (i == 2) {
                return String.valueOf(this.b);
            }
            if (i != 3) {
                return "";
            }
            boolean z10 = this.d;
            return z10 ? this.h : z10 ^ true ? this.i : "";
        }
        int i6 = this.f3794a;
        if (this.c.booleanValue()) {
            return String.valueOf(i6);
        }
        if (i6 == 0) {
            i6 = 12;
        }
        return String.valueOf(i6);
    }

    public final void b() throws Resources.NotFoundException {
        if (getChildCount() > 0) {
            removeAllViews();
        }
        int i = 2;
        int i6 = 1;
        if (this.c.booleanValue()) {
            if (this.c.booleanValue()) {
                View.inflate(getContext(), R.layout.mc_time_picker_column_24, this);
                TextView textView = (TextView) findViewById(R.id.mc_scroll1_text);
                this.f3795j = textView;
                if (textView != null) {
                    textView.setText(R.string.mc_date_time_hour);
                }
                TextView textView2 = (TextView) findViewById(R.id.mc_scroll2_text);
                this.k = textView2;
                if (textView2 != null) {
                    textView2.setText(R.string.mc_date_time_min);
                }
                ScrollTextView scrollTextView = (ScrollTextView) findViewById(R.id.mc_scroll1);
                this.e = scrollTextView;
                scrollTextView.i(new B1.b(this, i6, 9), this.f3794a, 24, this.f3796q, 23, true);
                ScrollTextView scrollTextView2 = (ScrollTextView) findViewById(R.id.mc_scroll2);
                this.f = scrollTextView2;
                scrollTextView2.i(new B1.b(this, i, 9), this.b, 60, this.f3796q, 59, true);
                this.g = null;
                ArrayList arrayList = new ArrayList();
                arrayList.add(Float.valueOf(getContext().getResources().getDimension(R.dimen.mc_picker_normal_number_size_one)));
                arrayList.add(Float.valueOf(getContext().getResources().getDimension(R.dimen.mc_picker_normal_number_size_two)));
                float fMin = Math.min(getContext().getResources().getDimensionPixelOffset(R.dimen.mc_picker_selected_number_max_size), getContext().getResources().getDimensionPixelOffset(R.dimen.mc_picker_selected_number_size));
                this.e.n(fMin, arrayList);
                this.f.n(fMin, arrayList);
            }
        } else if (!this.c.booleanValue()) {
            View.inflate(getContext(), R.layout.mc_time_picker_column_12, this);
            TextView textView3 = (TextView) findViewById(R.id.mc_scroll1_text);
            this.f3795j = textView3;
            if (textView3 != null) {
                textView3.setText(R.string.mc_date_time_hour);
            }
            TextView textView4 = (TextView) findViewById(R.id.mc_scroll2_text);
            this.k = textView4;
            if (textView4 != null) {
                textView4.setText(R.string.mc_date_time_min);
            }
            ScrollTextView scrollTextView3 = (ScrollTextView) findViewById(R.id.mc_scroll1);
            this.e = scrollTextView3;
            scrollTextView3.i(new B1.b(this, i6, 9), this.f3794a, 12, this.f3796q, 11, true);
            ScrollTextView scrollTextView4 = (ScrollTextView) findViewById(R.id.mc_scroll2);
            this.f = scrollTextView4;
            scrollTextView4.i(new B1.b(this, i, 9), this.b, 60, this.f3796q, 59, true);
            ScrollTextView scrollTextView5 = (ScrollTextView) findViewById(R.id.mc_scroll3);
            this.g = scrollTextView5;
            scrollTextView5.i(new B1.b(this, 3, 9), !this.d ? 1 : 0, 2, this.f3796q, 1, false);
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(Float.valueOf(getContext().getResources().getDimension(R.dimen.mc_picker_normal_number_size_one)));
            arrayList2.add(Float.valueOf(getContext().getResources().getDimension(R.dimen.mc_picker_normal_number_size_two)));
            float fMin2 = Math.min(getContext().getResources().getDimensionPixelOffset(R.dimen.mc_picker_selected_number_max_size), getContext().getResources().getDimensionPixelOffset(R.dimen.mc_picker_selected_number_size));
            this.e.n(fMin2, arrayList2);
            this.f.n(fMin2, arrayList2);
            ScrollTextView scrollTextView6 = this.g;
            scrollTextView6.l(getContext().getResources().getDimension(R.dimen.mc_picker_selected_word_size), getContext().getResources().getDimension(R.dimen.mc_picker_normal_word_size_two), scrollTextView6.d, scrollTextView6.e);
        }
        int color = getContext().getResources().getColor(R.color.mc_picker_selected_color);
        ArrayList arrayList3 = new ArrayList();
        arrayList3.add(Integer.valueOf(getContext().getResources().getColor(R.color.mc_picker_unselected_color_one)));
        arrayList3.add(Integer.valueOf(getContext().getResources().getColor(R.color.mc_picker_unselected_color_two)));
        this.e.k(color, arrayList3);
        this.f.k(color, arrayList3);
        ScrollTextView scrollTextView7 = this.g;
        if (scrollTextView7 != null) {
            scrollTextView7.k(color, arrayList3);
        }
        this.f3795j.setTextColor(color);
        this.k.setTextColor(color);
        if (isEnabled()) {
            return;
        }
        setEnabled(false);
    }

    public final void c() {
        if (this.p) {
            View viewFindViewById = findViewById(R.id.mc_column3Layout);
            View viewFindViewById2 = findViewById(R.id.mc_column2Layout);
            View viewFindViewById3 = findViewById(R.id.mc_column1Layout);
            String str = "";
            if (!this.c.booleanValue()) {
                str = "" + a(3);
            }
            StringBuilder sbV = androidx.compose.foundation.b.v(str);
            sbV.append(a(1));
            sbV.append((Object) this.f3795j.getText());
            sbV.append(a(2));
            sbV.append((Object) this.k.getText());
            String string = sbV.toString();
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

    public final void d(int i, int i6, boolean z10) throws Resources.NotFoundException {
        boolean z11;
        boolean z12;
        boolean z13 = false;
        if (!z10) {
            this.d = true;
            if (this.f3794a != i) {
                this.f3794a = i;
                z11 = true;
            } else {
                z11 = false;
            }
            int i10 = this.f3794a;
            z12 = z11;
            if (i10 >= 12) {
                this.f3794a = i10 - 12;
                this.d = false;
                z12 = z11;
            }
        } else if (this.f3794a != i) {
            this.f3794a = i;
            z12 = true;
        } else {
            z12 = false;
        }
        if (this.b != i6) {
            this.b = i6;
            z13 = true;
        }
        if (z10 != this.c.booleanValue()) {
            this.c = Boolean.valueOf(z10);
            b();
        }
        if (z12) {
            ScrollTextView scrollTextView = this.e;
            int i11 = this.f3794a;
            F f = scrollTextView.f3756q;
            scrollTextView.g(f.b, i11, f.f3709a);
        }
        if (z13) {
            ScrollTextView scrollTextView2 = this.f;
            int i12 = this.b;
            F f7 = scrollTextView2.f3756q;
            scrollTextView2.g(f7.b, i12, f7.f3709a);
        }
        ScrollTextView scrollTextView3 = this.g;
        if (scrollTextView3 != null) {
            int i13 = !this.d ? 1 : 0;
            F f9 = scrollTextView3.f3756q;
            scrollTextView3.g(f9.b, i13, f9.f3709a);
        }
    }

    @Override // android.view.View
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (!this.p || accessibilityEvent.getEventType() != 32) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        String str = "";
        if (!this.c.booleanValue()) {
            str = "" + a(3);
        }
        StringBuilder sbV = androidx.compose.foundation.b.v(str);
        sbV.append(a(1));
        sbV.append((Object) this.f3795j.getText());
        sbV.append(a(2));
        sbV.append((Object) this.k.getText());
        accessibilityEvent.getText().add(sbV.toString());
        return false;
    }

    public int getCurrentHour() {
        if (!this.c.booleanValue() && !this.d) {
            return this.f3794a + 12;
        }
        return this.f3794a;
    }

    public Integer getCurrentMinute() {
        return Integer.valueOf(this.b);
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.o) {
            int width = getWidth();
            int width2 = this.l.getWidth() - (this.m * 2);
            int i = (width - width2) / 2;
            float f = i;
            float f7 = 0;
            float f9 = i + width2;
            Paint paint = this.n;
            canvas.drawLine(f, f7, f9, f7, paint);
            canvas.drawLine(f, f7, f9, f7, paint);
        }
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(TimePicker.class.getName());
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z10, int i, int i6, int i10, int i11) {
        super.onLayout(z10, i, i6, i10, i11);
        if (getVisibility() == 0) {
            if (getHeight() < this.e.getSelectedItemHeight() + ((this.f3796q - 1) * this.e.getItemHeight())) {
                this.f3796q = 3;
                this.e.setVisibleItems(3);
                this.f.setVisibleItems(3);
            } else {
                this.f3796q = 5;
                this.e.setVisibleItems(5);
                this.f.setVisibleItems(5);
            }
            int height = (int) ((getHeight() - (this.f3795j.getLineHeight() - this.f3795j.getTextSize())) / 2.0f);
            TextView textView = this.f3795j;
            textView.setPadding(textView.getPaddingLeft(), height, this.f3795j.getPaddingRight(), this.f3795j.getPaddingBottom());
            TextView textView2 = this.k;
            textView2.setPadding(textView2.getPaddingLeft(), height, this.k.getPaddingRight(), this.k.getPaddingBottom());
        }
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) throws Resources.NotFoundException {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        d(savedState.mHour, savedState.mMinute, this.c.booleanValue());
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), getCurrentHour(), this.b);
    }

    public void setCurrentHour(Integer num) throws Resources.NotFoundException {
        if (num == null || num.intValue() == getCurrentHour()) {
            return;
        }
        d(num.intValue(), this.b, this.c.booleanValue());
    }

    public void setCurrentMinute(Integer num) throws Resources.NotFoundException {
        d(getCurrentHour(), num.intValue(), this.c.booleanValue());
    }

    @Override // android.view.View
    public void setEnabled(boolean z10) {
        super.setEnabled(z10);
        this.f.setEnabled(z10);
        this.e.setEnabled(z10);
        ScrollTextView scrollTextView = this.g;
        if (scrollTextView != null) {
            scrollTextView.setEnabled(z10);
        }
    }

    public void setIs24HourView(Boolean bool) throws Resources.NotFoundException {
        d(getCurrentHour(), this.b, bool.booleanValue());
    }

    public void setIsDrawLine(boolean z10) {
        this.o = z10;
    }

    public void setOnTimeChangedListener(S s5) {
    }

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new T();
        private final int mHour;
        private final int mMinute;

        public int getHour() {
            return this.mHour;
        }

        public int getMinute() {
            return this.mMinute;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.mHour);
            parcel.writeInt(this.mMinute);
        }

        private SavedState(Parcelable parcelable, int i, int i6) {
            super(parcelable);
            this.mHour = i;
            this.mMinute = i6;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.mHour = parcel.readInt();
            this.mMinute = parcel.readInt();
        }
    }
}
