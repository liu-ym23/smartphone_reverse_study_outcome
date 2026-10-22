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
import com.stepos.common.R$color;
import com.stepos.common.R$dimen;
import com.stepos.common.R$id;
import com.stepos.common.R$layout;
import com.stepos.common.R$string;
import com.stepos.common.R$styleable;
import com.stepos.common.widget.ScrollTextView;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

/* loaded from: classes3.dex */
public class TimePicker extends FrameLayout {
    private static final int ITEM_COUNT_DEFAULT = 5;
    private static final int ITEM_COUNT_SMALL = 3;
    private static final String TAG = "TimePicker";
    private ScrollTextView mAmPmPicker;
    private String mAmText;
    private int mCurrentHour;
    private int mCurrentMinute;
    private ScrollTextView mHourPicker;
    String[] mHourTexts;
    private TextView mHourUnit;
    private Boolean mIs24HourView;
    private boolean mIsAccessibilityEnable;
    private boolean mIsAm;
    private boolean mIsDrawLine;
    private int mLineOneHeight;
    private Paint mLinePaint;
    private int mLineTwoHeight;
    String[] mMinTexts;
    private ScrollTextView mMinutePicker;
    private TextView mMinuteUnit;
    private b mOnTimeChangedListener;
    private int mOneScreenCount;
    private LinearLayout mPickerHolder;
    private String mPmText;
    private int mWidthPadding;

    public interface b {
    }

    public class c implements ScrollTextView.e {
        static final int SET_AMPM = 3;
        static final int SET_HOUR = 1;
        static final int SET_MIN = 2;
        int mType;

        public c(int i10) {
            this.mType = i10;
        }

        @Override // com.stepos.common.widget.ScrollTextView.e
        public String a(int i10) {
            int i11 = this.mType;
            if (i11 == 1) {
                if (TimePicker.this.l()) {
                    return TimePicker.this.mHourTexts[i10];
                }
                if (i10 == 0) {
                    i10 = 12;
                }
                return TimePicker.this.mHourTexts[i10];
            }
            if (i11 == 2) {
                return TimePicker.this.mMinTexts[i10];
            }
            if (i11 != 3) {
                return null;
            }
            if (i10 == 0) {
                return TimePicker.this.mAmText;
            }
            if (i10 == 1) {
                return TimePicker.this.mPmText;
            }
            return null;
        }

        @Override // com.stepos.common.widget.ScrollTextView.e
        public void b(View view, int i10, int i11) {
            int i12 = this.mType;
            if (i12 == 1) {
                TimePicker.this.mCurrentHour = i11;
            } else if (i12 == 2) {
                TimePicker.this.mCurrentMinute = i11;
            } else {
                if (i12 != 3) {
                    return;
                }
                TimePicker.this.mIsAm = i11 == 0;
            }
            TimePicker.d(TimePicker.this);
            TimePicker.this.n(this.mType);
        }
    }

    public TimePicker(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public static /* synthetic */ b d(TimePicker timePicker) {
        timePicker.getClass();
        return null;
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (!this.mIsAccessibilityEnable || accessibilityEvent.getEventType() != 32) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        String str = "";
        if (!this.mIs24HourView.booleanValue()) {
            str = "" + h(3);
        }
        accessibilityEvent.getText().add(str + h(1) + ((Object) this.mHourUnit.getText()) + h(2) + ((Object) this.mMinuteUnit.getText()));
        return false;
    }

    public int getCurrentHour() {
        if (!this.mIs24HourView.booleanValue() && !this.mIsAm) {
            return this.mCurrentHour + 12;
        }
        return this.mCurrentHour;
    }

    public Integer getCurrentMinute() {
        return Integer.valueOf(this.mCurrentMinute);
    }

    public final String h(int i10) {
        if (i10 != 1) {
            if (i10 == 2) {
                return String.valueOf(this.mCurrentMinute);
            }
            if (i10 != 3) {
                return "";
            }
            boolean z10 = this.mIsAm;
            return z10 ? this.mAmText : z10 ^ true ? this.mPmText : "";
        }
        int i11 = this.mCurrentHour;
        if (l()) {
            return String.valueOf(i11);
        }
        if (i11 == 0) {
            i11 = 12;
        }
        return String.valueOf(i11);
    }

    public final void i() throws Resources.NotFoundException {
        if (getChildCount() > 0) {
            removeAllViews();
        }
        if (this.mIs24HourView.booleanValue()) {
            k();
        } else {
            j();
        }
        int color = getContext().getResources().getColor(R$color.mc_picker_selected_color);
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(getContext().getResources().getColor(R$color.mc_picker_unselected_color_one)));
        arrayList.add(Integer.valueOf(getContext().getResources().getColor(R$color.mc_picker_unselected_color_two)));
        this.mHourPicker.c0(color, arrayList);
        this.mMinutePicker.c0(color, arrayList);
        ScrollTextView scrollTextView = this.mAmPmPicker;
        if (scrollTextView != null) {
            scrollTextView.c0(color, arrayList);
        }
        this.mHourUnit.setTextColor(color);
        this.mMinuteUnit.setTextColor(color);
        if (isEnabled()) {
            return;
        }
        setEnabled(false);
    }

    public final void j() {
        if (this.mIs24HourView.booleanValue()) {
            return;
        }
        View.inflate(getContext(), R$layout.mc_time_picker_column_12, this);
        TextView textView = (TextView) findViewById(R$id.mc_scroll1_text);
        this.mHourUnit = textView;
        if (textView != null) {
            textView.setText(R$string.mc_date_time_hour);
        }
        TextView textView2 = (TextView) findViewById(R$id.mc_scroll2_text);
        this.mMinuteUnit = textView2;
        if (textView2 != null) {
            textView2.setText(R$string.mc_date_time_min);
        }
        ScrollTextView scrollTextView = (ScrollTextView) findViewById(R$id.mc_scroll1);
        this.mHourPicker = scrollTextView;
        scrollTextView.Z(new c(1), -1.0f, this.mCurrentHour, 12, this.mOneScreenCount, 0, 11, true);
        ScrollTextView scrollTextView2 = (ScrollTextView) findViewById(R$id.mc_scroll2);
        this.mMinutePicker = scrollTextView2;
        scrollTextView2.Z(new c(2), -1.0f, this.mCurrentMinute, 60, this.mOneScreenCount, 0, 59, true);
        ScrollTextView scrollTextView3 = (ScrollTextView) findViewById(R$id.mc_scroll3);
        this.mAmPmPicker = scrollTextView3;
        scrollTextView3.Z(new c(3), -1.0f, !this.mIsAm ? 1 : 0, 2, this.mOneScreenCount, 0, 1, false);
        ArrayList arrayList = new ArrayList();
        arrayList.add(Float.valueOf(getContext().getResources().getDimension(R$dimen.mc_picker_normal_number_size_one)));
        arrayList.add(Float.valueOf(getContext().getResources().getDimension(R$dimen.mc_picker_normal_number_size_two)));
        float fMin = Math.min(getContext().getResources().getDimensionPixelOffset(R$dimen.mc_picker_selected_number_max_size), getContext().getResources().getDimensionPixelOffset(R$dimen.mc_picker_selected_number_size));
        this.mHourPicker.g0(fMin, arrayList);
        this.mMinutePicker.g0(fMin, arrayList);
        this.mAmPmPicker.f0(getContext().getResources().getDimension(R$dimen.mc_picker_selected_word_size), getContext().getResources().getDimension(R$dimen.mc_picker_normal_word_size_two));
    }

    public final void k() {
        if (this.mIs24HourView.booleanValue()) {
            View.inflate(getContext(), R$layout.mc_time_picker_column_24, this);
            TextView textView = (TextView) findViewById(R$id.mc_scroll1_text);
            this.mHourUnit = textView;
            if (textView != null) {
                textView.setText(R$string.mc_date_time_hour);
            }
            TextView textView2 = (TextView) findViewById(R$id.mc_scroll2_text);
            this.mMinuteUnit = textView2;
            if (textView2 != null) {
                textView2.setText(R$string.mc_date_time_min);
            }
            ScrollTextView scrollTextView = (ScrollTextView) findViewById(R$id.mc_scroll1);
            this.mHourPicker = scrollTextView;
            scrollTextView.Z(new c(1), -1.0f, this.mCurrentHour, 24, this.mOneScreenCount, 0, 23, true);
            ScrollTextView scrollTextView2 = (ScrollTextView) findViewById(R$id.mc_scroll2);
            this.mMinutePicker = scrollTextView2;
            scrollTextView2.Z(new c(2), -1.0f, this.mCurrentMinute, 60, this.mOneScreenCount, 0, 59, true);
            this.mAmPmPicker = null;
            ArrayList arrayList = new ArrayList();
            arrayList.add(Float.valueOf(getContext().getResources().getDimension(R$dimen.mc_picker_normal_number_size_one)));
            arrayList.add(Float.valueOf(getContext().getResources().getDimension(R$dimen.mc_picker_normal_number_size_two)));
            float fMin = Math.min(getContext().getResources().getDimensionPixelOffset(R$dimen.mc_picker_selected_number_max_size), getContext().getResources().getDimensionPixelOffset(R$dimen.mc_picker_selected_number_size));
            this.mHourPicker.g0(fMin, arrayList);
            this.mMinutePicker.g0(fMin, arrayList);
        }
    }

    public boolean l() {
        return this.mIs24HourView.booleanValue();
    }

    public final void m() {
        int height = (int) ((getHeight() - (this.mHourUnit.getLineHeight() - this.mHourUnit.getTextSize())) / 2.0f);
        TextView textView = this.mHourUnit;
        textView.setPadding(textView.getPaddingLeft(), height, this.mHourUnit.getPaddingRight(), this.mHourUnit.getPaddingBottom());
        TextView textView2 = this.mMinuteUnit;
        textView2.setPadding(textView2.getPaddingLeft(), height, this.mMinuteUnit.getPaddingRight(), this.mMinuteUnit.getPaddingBottom());
    }

    public final void n(int i10) {
        View viewFindViewById;
        if (this.mIsAccessibilityEnable) {
            o();
            if (i10 == 3) {
                View viewFindViewById2 = findViewById(R$id.mc_column3Layout);
                if (viewFindViewById2 != null) {
                    viewFindViewById2.sendAccessibilityEvent(4);
                    return;
                }
                return;
            }
            if (i10 == 1) {
                View viewFindViewById3 = findViewById(R$id.mc_column1Layout);
                if (viewFindViewById3 != null) {
                    viewFindViewById3.sendAccessibilityEvent(4);
                    return;
                }
                return;
            }
            if (i10 != 2 || (viewFindViewById = findViewById(R$id.mc_column2Layout)) == null) {
                return;
            }
            viewFindViewById.sendAccessibilityEvent(4);
        }
    }

    public final void o() {
        if (this.mIsAccessibilityEnable) {
            View viewFindViewById = findViewById(R$id.mc_column3Layout);
            View viewFindViewById2 = findViewById(R$id.mc_column2Layout);
            View viewFindViewById3 = findViewById(R$id.mc_column1Layout);
            String str = "";
            if (!this.mIs24HourView.booleanValue()) {
                str = "" + h(3);
            }
            String str2 = str + h(1) + ((Object) this.mHourUnit.getText()) + h(2) + ((Object) this.mMinuteUnit.getText());
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
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mIsDrawLine) {
            int width = getWidth();
            int width2 = this.mPickerHolder.getWidth() - (this.mWidthPadding * 2);
            int i10 = (width - width2) / 2;
            float f10 = i10;
            int i11 = this.mLineOneHeight;
            float f11 = i10 + width2;
            canvas.drawLine(f10, i11, f11, i11, this.mLinePaint);
            int i12 = this.mLineTwoHeight;
            canvas.drawLine(f10, i12, f11, i12, this.mLinePaint);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(TimePicker.class.getName());
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        if (getVisibility() == 0) {
            if (getHeight() < (this.mHourPicker.getItemHeight() * (this.mOneScreenCount - 1)) + this.mHourPicker.getSelectedItemHeight()) {
                this.mOneScreenCount = 3;
                this.mHourPicker.setVisibleItems(3);
                this.mMinutePicker.setVisibleItems(3);
            } else {
                this.mOneScreenCount = 5;
                this.mHourPicker.setVisibleItems(5);
                this.mMinutePicker.setVisibleItems(5);
            }
            m();
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) throws Resources.NotFoundException {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        p(savedState.mHour, savedState.mMinute, this.mIs24HourView.booleanValue());
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), getCurrentHour(), this.mCurrentMinute);
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z10) {
        super.onWindowFocusChanged(z10);
    }

    public void p(int i10, int i11, boolean z10) throws Resources.NotFoundException {
        boolean z11;
        boolean z12;
        boolean z13 = false;
        if (!z10) {
            this.mIsAm = true;
            if (this.mCurrentHour != i10) {
                this.mCurrentHour = i10;
                z11 = true;
            } else {
                z11 = false;
            }
            int i12 = this.mCurrentHour;
            z12 = z11;
            if (i12 >= 12) {
                this.mCurrentHour = i12 - 12;
                this.mIsAm = false;
                z12 = z11;
            }
        } else if (this.mCurrentHour != i10) {
            this.mCurrentHour = i10;
            z12 = true;
        } else {
            z12 = false;
        }
        if (this.mCurrentMinute != i11) {
            this.mCurrentMinute = i11;
            z13 = true;
        }
        if (z10 != this.mIs24HourView.booleanValue()) {
            this.mIs24HourView = Boolean.valueOf(z10);
            i();
        }
        if (z12) {
            this.mHourPicker.V(this.mCurrentHour);
        }
        if (z13) {
            this.mMinutePicker.V(this.mCurrentMinute);
        }
        ScrollTextView scrollTextView = this.mAmPmPicker;
        if (scrollTextView != null) {
            scrollTextView.V(!this.mIsAm ? 1 : 0);
        }
    }

    public void setCurrentHour(Integer num) throws Resources.NotFoundException {
        if (num == null || num.intValue() == getCurrentHour()) {
            return;
        }
        p(num.intValue(), this.mCurrentMinute, this.mIs24HourView.booleanValue());
    }

    public void setCurrentMinute(Integer num) throws Resources.NotFoundException {
        p(getCurrentHour(), num.intValue(), this.mIs24HourView.booleanValue());
    }

    @Override // android.view.View
    public void setEnabled(boolean z10) {
        super.setEnabled(z10);
        this.mMinutePicker.setEnabled(z10);
        this.mHourPicker.setEnabled(z10);
        ScrollTextView scrollTextView = this.mAmPmPicker;
        if (scrollTextView != null) {
            scrollTextView.setEnabled(z10);
        }
    }

    public void setIs24HourView(Boolean bool) throws Resources.NotFoundException {
        p(getCurrentHour(), this.mCurrentMinute, bool.booleanValue());
    }

    public void setIsDrawLine(boolean z10) {
        this.mIsDrawLine = z10;
    }

    public void setOnTimeChangedListener(b bVar) {
    }

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        private final int mHour;
        private final int mMinute;

        public class a implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i10) {
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

    public TimePicker(Context context, AttributeSet attributeSet, int i10) throws Resources.NotFoundException {
        int i11;
        super(context, attributeSet, i10);
        this.mCurrentHour = 0;
        this.mCurrentMinute = 0;
        this.mIs24HourView = Boolean.FALSE;
        this.mIsAm = true;
        this.mIsAccessibilityEnable = false;
        this.mOneScreenCount = 5;
        String str = String.format(Locale.getDefault(), TimeModel.NUMBER_FORMAT, 0);
        this.mHourTexts = new String[100];
        for (int i12 = 0; i12 < 100; i12++) {
            this.mHourTexts[i12] = String.format(Locale.getDefault(), TimeModel.NUMBER_FORMAT, Integer.valueOf(i12));
            if (i12 <= 9) {
                this.mHourTexts[i12] = str + this.mHourTexts[i12];
            }
        }
        this.mMinTexts = new String[100];
        for (int i13 = 0; i13 < 100; i13++) {
            this.mMinTexts[i13] = String.format(Locale.getDefault(), TimeModel.NUMBER_FORMAT, Integer.valueOf(i13));
            if (i13 <= 9) {
                this.mMinTexts[i13] = str + this.mMinTexts[i13];
            }
        }
        Calendar calendar = Calendar.getInstance();
        try {
            this.mCurrentHour = calendar.get(11);
            this.mCurrentMinute = calendar.get(12);
            this.mIs24HourView = Boolean.valueOf(DateFormat.is24HourFormat(context));
        } catch (Exception unused) {
            this.mCurrentHour = 12;
            this.mCurrentMinute = 30;
            this.mIs24HourView = Boolean.TRUE;
        }
        if (!this.mIs24HourView.booleanValue() && (i11 = this.mCurrentHour) >= 12) {
            this.mCurrentHour = i11 - 12;
            this.mIsAm = false;
        }
        String[] amPmStrings = new DateFormatSymbols().getAmPmStrings();
        this.mAmText = amPmStrings[0];
        this.mPmText = amPmStrings[1];
        i();
        this.mLineOneHeight = 0;
        this.mLineTwoHeight = 0;
        this.mWidthPadding = context.getResources().getDimensionPixelSize(R$dimen.mc_custom_time_picker_line_width_padding);
        this.mLinePaint = new Paint();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(R$styleable.StepOSTheme);
        int i14 = typedArrayObtainStyledAttributes.getInt(R$styleable.StepOSTheme_steposThemeColor, context.getResources().getColor(R$color.mc_custom_date_picker_selected_gregorian_color));
        typedArrayObtainStyledAttributes.recycle();
        this.mLinePaint.setColor(i14);
        this.mLinePaint.setAntiAlias(true);
        this.mLinePaint.setStrokeWidth(context.getResources().getDimensionPixelSize(R$dimen.mc_custom_time_picker_line_stroke_width));
        this.mIsDrawLine = false;
        setWillNotDraw(false);
        this.mPickerHolder = (LinearLayout) findViewById(R$id.mc_column_parent);
        AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
        if (accessibilityManager != null) {
            this.mIsAccessibilityEnable = accessibilityManager.isEnabled();
        }
        o();
    }
}
