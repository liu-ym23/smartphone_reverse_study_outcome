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
import com.stepos.aiengine.R;
import com.stepos.common.widget.ScrollTextView;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class TimePicker extends FrameLayout {

    /* renamed from: w, reason: collision with root package name */
    public static final /* synthetic */ int f7122w = 0;

    /* renamed from: a, reason: collision with root package name */
    public int f7123a;

    /* renamed from: b, reason: collision with root package name */
    public int f7124b;

    /* renamed from: c, reason: collision with root package name */
    public Boolean f7125c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f7126d;

    /* renamed from: e, reason: collision with root package name */
    public ScrollTextView f7127e;
    public ScrollTextView h;

    /* renamed from: j, reason: collision with root package name */
    public ScrollTextView f7128j;

    /* renamed from: k, reason: collision with root package name */
    public final String f7129k;

    /* renamed from: l, reason: collision with root package name */
    public final String f7130l;

    /* renamed from: m, reason: collision with root package name */
    public TextView f7131m;

    /* renamed from: n, reason: collision with root package name */
    public TextView f7132n;

    /* renamed from: o, reason: collision with root package name */
    public final LinearLayout f7133o;

    /* renamed from: p, reason: collision with root package name */
    public final int f7134p;

    /* renamed from: q, reason: collision with root package name */
    public final Paint f7135q;
    public boolean r;

    /* renamed from: s, reason: collision with root package name */
    public final boolean f7136s;

    /* renamed from: t, reason: collision with root package name */
    public int f7137t;

    /* renamed from: u, reason: collision with root package name */
    public final String[] f7138u;

    /* renamed from: v, reason: collision with root package name */
    public final String[] f7139v;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface b {
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class c implements ScrollTextView.e {

        /* renamed from: a, reason: collision with root package name */
        public final int f7140a;

        public c(int i10) {
            this.f7140a = i10;
        }

        @Override // com.stepos.common.widget.ScrollTextView.e
        public final String a(int i10) {
            TimePicker timePicker = TimePicker.this;
            String[] strArr = timePicker.f7138u;
            int i11 = this.f7140a;
            if (i11 == 1) {
                if (timePicker.f7125c.booleanValue()) {
                    return strArr[i10];
                }
                if (i10 == 0) {
                    i10 = 12;
                }
                return strArr[i10];
            }
            if (i11 == 2) {
                return timePicker.f7139v[i10];
            }
            if (i11 != 3) {
                return null;
            }
            if (i10 == 0) {
                return timePicker.f7129k;
            }
            if (i10 == 1) {
                return timePicker.f7130l;
            }
            return null;
        }

        @Override // com.stepos.common.widget.ScrollTextView.e
        public final void b(int i10) {
            View viewFindViewById;
            TimePicker timePicker = TimePicker.this;
            int i11 = this.f7140a;
            if (i11 == 1) {
                timePicker.f7123a = i10;
            } else if (i11 == 2) {
                timePicker.f7124b = i10;
            } else if (i11 != 3) {
                return;
            } else {
                timePicker.f7126d = i10 == 0;
            }
            int i12 = TimePicker.f7122w;
            if (timePicker.f7136s) {
                timePicker.c();
                if (i11 == 3) {
                    View viewFindViewById2 = timePicker.findViewById(R.id.mc_column3Layout);
                    if (viewFindViewById2 != null) {
                        viewFindViewById2.sendAccessibilityEvent(4);
                        return;
                    }
                    return;
                }
                if (i11 == 1) {
                    View viewFindViewById3 = timePicker.findViewById(R.id.mc_column1Layout);
                    if (viewFindViewById3 != null) {
                        viewFindViewById3.sendAccessibilityEvent(4);
                        return;
                    }
                    return;
                }
                if (i11 != 2 || (viewFindViewById = timePicker.findViewById(R.id.mc_column2Layout)) == null) {
                    return;
                }
                viewFindViewById.sendAccessibilityEvent(4);
            }
        }
    }

    public TimePicker(Context context, AttributeSet attributeSet) throws Resources.NotFoundException {
        int i10;
        super(context, attributeSet, 0);
        this.f7123a = 0;
        this.f7124b = 0;
        this.f7125c = Boolean.FALSE;
        this.f7126d = true;
        this.f7136s = false;
        this.f7137t = 5;
        String str = String.format(Locale.getDefault(), TimeModel.NUMBER_FORMAT, 0);
        this.f7138u = new String[100];
        for (int i11 = 0; i11 < 100; i11++) {
            this.f7138u[i11] = String.format(Locale.getDefault(), TimeModel.NUMBER_FORMAT, Integer.valueOf(i11));
            if (i11 <= 9) {
                String[] strArr = this.f7138u;
                StringBuilder sbB = v1.d.b(str);
                sbB.append(this.f7138u[i11]);
                strArr[i11] = sbB.toString();
            }
        }
        this.f7139v = new String[100];
        for (int i12 = 0; i12 < 100; i12++) {
            this.f7139v[i12] = String.format(Locale.getDefault(), TimeModel.NUMBER_FORMAT, Integer.valueOf(i12));
            if (i12 <= 9) {
                String[] strArr2 = this.f7139v;
                StringBuilder sbB2 = v1.d.b(str);
                sbB2.append(this.f7139v[i12]);
                strArr2[i12] = sbB2.toString();
            }
        }
        Calendar calendar = Calendar.getInstance();
        try {
            this.f7123a = calendar.get(11);
            this.f7124b = calendar.get(12);
            this.f7125c = Boolean.valueOf(DateFormat.is24HourFormat(context));
        } catch (Exception unused) {
            this.f7123a = 12;
            this.f7124b = 30;
            this.f7125c = Boolean.TRUE;
        }
        if (!this.f7125c.booleanValue() && (i10 = this.f7123a) >= 12) {
            this.f7123a = i10 - 12;
            this.f7126d = false;
        }
        String[] amPmStrings = new DateFormatSymbols().getAmPmStrings();
        this.f7129k = amPmStrings[0];
        this.f7130l = amPmStrings[1];
        b();
        this.f7134p = context.getResources().getDimensionPixelSize(R.dimen.mc_custom_time_picker_line_width_padding);
        Paint paint = new Paint();
        this.f7135q = paint;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(g8.a.f9091s);
        int i13 = typedArrayObtainStyledAttributes.getInt(11, context.getResources().getColor(R.color.mc_custom_date_picker_selected_gregorian_color));
        typedArrayObtainStyledAttributes.recycle();
        paint.setColor(i13);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(context.getResources().getDimensionPixelSize(R.dimen.mc_custom_time_picker_line_stroke_width));
        this.r = false;
        setWillNotDraw(false);
        this.f7133o = (LinearLayout) findViewById(R.id.mc_column_parent);
        AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
        if (accessibilityManager != null) {
            this.f7136s = accessibilityManager.isEnabled();
        }
        c();
    }

    public final String a(int i10) {
        if (i10 != 1) {
            if (i10 == 2) {
                return String.valueOf(this.f7124b);
            }
            if (i10 != 3) {
                return "";
            }
            boolean z = this.f7126d;
            return z ? this.f7129k : z ^ true ? this.f7130l : "";
        }
        int i11 = this.f7123a;
        if (this.f7125c.booleanValue()) {
            return String.valueOf(i11);
        }
        if (i11 == 0) {
            i11 = 12;
        }
        return String.valueOf(i11);
    }

    public final void b() throws Resources.NotFoundException {
        if (getChildCount() > 0) {
            removeAllViews();
        }
        if (this.f7125c.booleanValue()) {
            if (this.f7125c.booleanValue()) {
                FrameLayout.inflate(getContext(), R.layout.mc_time_picker_column_24, this);
                TextView textView = (TextView) findViewById(R.id.mc_scroll1_text);
                this.f7131m = textView;
                if (textView != null) {
                    textView.setText(R.string.mc_date_time_hour);
                }
                TextView textView2 = (TextView) findViewById(R.id.mc_scroll2_text);
                this.f7132n = textView2;
                if (textView2 != null) {
                    textView2.setText(R.string.mc_date_time_min);
                }
                ScrollTextView scrollTextView = (ScrollTextView) findViewById(R.id.mc_scroll1);
                this.f7127e = scrollTextView;
                scrollTextView.i(new c(1), this.f7123a, 24, this.f7137t, 23, true);
                ScrollTextView scrollTextView2 = (ScrollTextView) findViewById(R.id.mc_scroll2);
                this.h = scrollTextView2;
                scrollTextView2.i(new c(2), this.f7124b, 60, this.f7137t, 59, true);
                this.f7128j = null;
                ArrayList arrayList = new ArrayList();
                arrayList.add(Float.valueOf(getContext().getResources().getDimension(R.dimen.mc_picker_normal_number_size_one)));
                arrayList.add(Float.valueOf(getContext().getResources().getDimension(R.dimen.mc_picker_normal_number_size_two)));
                float fMin = Math.min(getContext().getResources().getDimensionPixelOffset(R.dimen.mc_picker_selected_number_max_size), getContext().getResources().getDimensionPixelOffset(R.dimen.mc_picker_selected_number_size));
                this.f7127e.n(fMin, arrayList);
                this.h.n(fMin, arrayList);
            }
        } else if (!this.f7125c.booleanValue()) {
            FrameLayout.inflate(getContext(), R.layout.mc_time_picker_column_12, this);
            TextView textView3 = (TextView) findViewById(R.id.mc_scroll1_text);
            this.f7131m = textView3;
            if (textView3 != null) {
                textView3.setText(R.string.mc_date_time_hour);
            }
            TextView textView4 = (TextView) findViewById(R.id.mc_scroll2_text);
            this.f7132n = textView4;
            if (textView4 != null) {
                textView4.setText(R.string.mc_date_time_min);
            }
            ScrollTextView scrollTextView3 = (ScrollTextView) findViewById(R.id.mc_scroll1);
            this.f7127e = scrollTextView3;
            scrollTextView3.i(new c(1), this.f7123a, 12, this.f7137t, 11, true);
            ScrollTextView scrollTextView4 = (ScrollTextView) findViewById(R.id.mc_scroll2);
            this.h = scrollTextView4;
            scrollTextView4.i(new c(2), this.f7124b, 60, this.f7137t, 59, true);
            ScrollTextView scrollTextView5 = (ScrollTextView) findViewById(R.id.mc_scroll3);
            this.f7128j = scrollTextView5;
            scrollTextView5.i(new c(3), !this.f7126d ? 1 : 0, 2, this.f7137t, 1, false);
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(Float.valueOf(getContext().getResources().getDimension(R.dimen.mc_picker_normal_number_size_one)));
            arrayList2.add(Float.valueOf(getContext().getResources().getDimension(R.dimen.mc_picker_normal_number_size_two)));
            float fMin2 = Math.min(getContext().getResources().getDimensionPixelOffset(R.dimen.mc_picker_selected_number_max_size), getContext().getResources().getDimensionPixelOffset(R.dimen.mc_picker_selected_number_size));
            this.f7127e.n(fMin2, arrayList2);
            this.h.n(fMin2, arrayList2);
            ScrollTextView scrollTextView6 = this.f7128j;
            scrollTextView6.l(getContext().getResources().getDimension(R.dimen.mc_picker_selected_word_size), getContext().getResources().getDimension(R.dimen.mc_picker_normal_word_size_two), scrollTextView6.f6983d, scrollTextView6.f6984e);
        }
        int color = getContext().getResources().getColor(R.color.mc_picker_selected_color);
        ArrayList arrayList3 = new ArrayList();
        arrayList3.add(Integer.valueOf(getContext().getResources().getColor(R.color.mc_picker_unselected_color_one)));
        arrayList3.add(Integer.valueOf(getContext().getResources().getColor(R.color.mc_picker_unselected_color_two)));
        this.f7127e.k(color, arrayList3);
        this.h.k(color, arrayList3);
        ScrollTextView scrollTextView7 = this.f7128j;
        if (scrollTextView7 != null) {
            scrollTextView7.k(color, arrayList3);
        }
        this.f7131m.setTextColor(color);
        this.f7132n.setTextColor(color);
        if (isEnabled()) {
            return;
        }
        setEnabled(false);
    }

    public final void c() {
        if (this.f7136s) {
            View viewFindViewById = findViewById(R.id.mc_column3Layout);
            View viewFindViewById2 = findViewById(R.id.mc_column2Layout);
            View viewFindViewById3 = findViewById(R.id.mc_column1Layout);
            String str = "";
            if (!this.f7125c.booleanValue()) {
                str = "" + a(3);
            }
            StringBuilder sbB = v1.d.b(str);
            sbB.append(a(1));
            sbB.append((Object) this.f7131m.getText());
            sbB.append(a(2));
            sbB.append((Object) this.f7132n.getText());
            String string = sbB.toString();
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

    public final void d(int i10, int i11, boolean z) throws Resources.NotFoundException {
        boolean z3;
        boolean z10;
        boolean z11 = false;
        if (!z) {
            this.f7126d = true;
            if (this.f7123a != i10) {
                this.f7123a = i10;
                z3 = true;
            } else {
                z3 = false;
            }
            int i12 = this.f7123a;
            z10 = z3;
            if (i12 >= 12) {
                this.f7123a = i12 - 12;
                this.f7126d = false;
                z10 = z3;
            }
        } else if (this.f7123a != i10) {
            this.f7123a = i10;
            z10 = true;
        } else {
            z10 = false;
        }
        if (this.f7124b != i11) {
            this.f7124b = i11;
            z11 = true;
        }
        if (z != this.f7125c.booleanValue()) {
            this.f7125c = Boolean.valueOf(z);
            b();
        }
        if (z10) {
            ScrollTextView scrollTextView = this.f7127e;
            int i13 = this.f7123a;
            ScrollTextView.j jVar = scrollTextView.f6994t;
            scrollTextView.g(jVar.f7006b, i13, jVar.f7005a);
        }
        if (z11) {
            ScrollTextView scrollTextView2 = this.h;
            int i14 = this.f7124b;
            ScrollTextView.j jVar2 = scrollTextView2.f6994t;
            scrollTextView2.g(jVar2.f7006b, i14, jVar2.f7005a);
        }
        ScrollTextView scrollTextView3 = this.f7128j;
        if (scrollTextView3 != null) {
            int i15 = !this.f7126d ? 1 : 0;
            ScrollTextView.j jVar3 = scrollTextView3.f6994t;
            scrollTextView3.g(jVar3.f7006b, i15, jVar3.f7005a);
        }
    }

    @Override // android.view.View
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (!this.f7136s || accessibilityEvent.getEventType() != 32) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        String str = "";
        if (!this.f7125c.booleanValue()) {
            str = "" + a(3);
        }
        StringBuilder sbB = v1.d.b(str);
        sbB.append(a(1));
        sbB.append((Object) this.f7131m.getText());
        sbB.append(a(2));
        sbB.append((Object) this.f7132n.getText());
        accessibilityEvent.getText().add(sbB.toString());
        return false;
    }

    public int getCurrentHour() {
        return this.f7125c.booleanValue() ? this.f7123a : this.f7126d ? this.f7123a : this.f7123a + 12;
    }

    public Integer getCurrentMinute() {
        return Integer.valueOf(this.f7124b);
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.r) {
            int width = getWidth();
            int width2 = this.f7133o.getWidth() - (this.f7134p * 2);
            int i10 = (width - width2) / 2;
            float f8 = i10;
            float f9 = 0;
            float f10 = i10 + width2;
            Paint paint = this.f7135q;
            canvas.drawLine(f8, f9, f10, f9, paint);
            canvas.drawLine(f8, f9, f10, f9, paint);
        }
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(TimePicker.class.getName());
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i10, int i11, int i12, int i13) {
        super.onLayout(z, i10, i11, i12, i13);
        if (getVisibility() == 0) {
            if (getHeight() < this.f7127e.getSelectedItemHeight() + ((this.f7137t - 1) * this.f7127e.getItemHeight())) {
                this.f7137t = 3;
                this.f7127e.setVisibleItems(3);
                this.h.setVisibleItems(3);
            } else {
                this.f7137t = 5;
                this.f7127e.setVisibleItems(5);
                this.h.setVisibleItems(5);
            }
            int height = (int) ((getHeight() - (this.f7131m.getLineHeight() - this.f7131m.getTextSize())) / 2.0f);
            TextView textView = this.f7131m;
            textView.setPadding(textView.getPaddingLeft(), height, this.f7131m.getPaddingRight(), this.f7131m.getPaddingBottom());
            TextView textView2 = this.f7132n;
            textView2.setPadding(textView2.getPaddingLeft(), height, this.f7132n.getPaddingRight(), this.f7132n.getPaddingBottom());
        }
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) throws Resources.NotFoundException {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        d(savedState.mHour, savedState.mMinute, this.f7125c.booleanValue());
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), getCurrentHour(), this.f7124b);
    }

    public void setCurrentHour(Integer num) throws Resources.NotFoundException {
        if (num == null || num.intValue() == getCurrentHour()) {
            return;
        }
        d(num.intValue(), this.f7124b, this.f7125c.booleanValue());
    }

    public void setCurrentMinute(Integer num) throws Resources.NotFoundException {
        d(getCurrentHour(), num.intValue(), this.f7125c.booleanValue());
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.h.setEnabled(z);
        this.f7127e.setEnabled(z);
        ScrollTextView scrollTextView = this.f7128j;
        if (scrollTextView != null) {
            scrollTextView.setEnabled(z);
        }
    }

    public void setIs24HourView(Boolean bool) throws Resources.NotFoundException {
        d(getCurrentHour(), this.f7124b, bool.booleanValue());
    }

    public void setIsDrawLine(boolean z) {
        this.r = z;
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        private final int mHour;
        private final int mMinute;

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public class a implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            public final SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        public int getHour() {
            return this.mHour;
        }

        public int getMinute() {
            return this.mMinute;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.mHour);
            parcel.writeInt(this.mMinute);
        }

        private SavedState(Parcelable parcelable, int i10, int i11) {
            super(parcelable);
            this.mHour = i10;
            this.mMinute = i11;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.mHour = parcel.readInt();
            this.mMinute = parcel.readInt();
        }
    }

    public void setOnTimeChangedListener(b bVar) {
    }
}
