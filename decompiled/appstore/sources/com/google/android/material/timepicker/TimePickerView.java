package com.google.android.material.timepicker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.view.ViewCompat;
import androidx.core.view.a;
import com.google.android.material.R;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.chip.Chip;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
class TimePickerView extends ConstraintLayout implements TimePickerControls {
    private final ClockFaceView clockFace;
    private final ClockHandView clockHandView;
    private final Chip hourView;
    private final Chip minuteView;
    private OnDoubleTapListener onDoubleTapListener;
    private OnPeriodChangeListener onPeriodChangeListener;
    private OnSelectionChange onSelectionChangeListener;
    private final View.OnClickListener selectionListener;
    private final MaterialButtonToggleGroup toggle;

    public interface OnDoubleTapListener {
        void onDoubleTap();
    }

    public interface OnPeriodChangeListener {
        void onPeriodChange(int r10);
    }

    public interface OnSelectionChange {
        void onSelectionChanged(int r10);
    }

    public TimePickerView(Context r10) {
        this(r10, null);
    }

    public static /* synthetic */ OnSelectionChange access$000(TimePickerView r10) {
        return r10.onSelectionChangeListener;
    }

    public static /* synthetic */ OnPeriodChangeListener access$100(TimePickerView r10) {
        return r10.onPeriodChangeListener;
    }

    public static /* synthetic */ OnDoubleTapListener access$200(TimePickerView r10) {
        return r10.onDoubleTapListener;
    }

    private void setUpDisplay() {
        Chip r10 = this.minuteView;
        int r11 = R.id.selection_type;
        r10.setTag(r11, 12);
        this.hourView.setTag(r11, 10);
        this.minuteView.setOnClickListener(this.selectionListener);
        this.hourView.setOnClickListener(this.selectionListener);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void setupDoubleTap() {
        final GestureDetector r10 = new GestureDetector(getContext(), new AnonymousClass3(this));
        View.OnTouchListener r11 = new AnonymousClass4(this, r10);
        this.minuteView.setOnTouchListener(r11);
        this.hourView.setOnTouchListener(r11);
    }

    private void updateToggleConstraints() {
        if (this.toggle.getVisibility() != 0) goto L10;
        ConstraintSet r10 = new ConstraintSet();
        r10.q(this);
        if (ViewCompat.A(this) != 0) goto L7;
        int r11 = 2;
    L8:
        r10.o(R.id.material_clock_display, r11);
        r10.i(this);
        return;
    L7:
        r11 = 1;
        goto L8
    }

    public void addOnRotateListener(ClockHandView.OnRotateListener r10) {
        this.clockHandView.addOnRotateListener(r10);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        updateToggleConstraints();
    }

    @Override // android.view.View
    public void onVisibilityChanged(@NonNull View r10, int r11) {
        super.onVisibilityChanged(r10, r11);
        if (r10 != this) goto L7;
        if (r11 != 0) goto L8;
        updateToggleConstraints();
        return;
    L8:
        return;
    }

    @Override // com.google.android.material.timepicker.TimePickerControls
    public void setActiveSelection(int r10) {
        Chip r11 = this.minuteView;
        boolean r12 = false;
        if (r10 != 12) goto L5;
        boolean r13 = true;
    L6:
        r11.setChecked(r13);
        Chip r14 = this.hourView;
        if (r10 != 10) goto L9;
        r12 = true;
    L9:
        r14.setChecked(r12);
        return;
    L5:
        r13 = false;
        goto L6
    }

    public void setAnimateOnTouchUp(boolean r10) {
        this.clockHandView.setAnimateOnTouchUp(r10);
    }

    @Override // com.google.android.material.timepicker.TimePickerControls
    public void setHandRotation(float r10) {
        this.clockHandView.setHandRotation(r10);
    }

    public void setHourClickDelegate(a r10) {
        ViewCompat.p0(this.minuteView, r10);
    }

    public void setMinuteHourDelegate(a r10) {
        ViewCompat.p0(this.hourView, r10);
    }

    public void setOnActionUpListener(ClockHandView.OnActionUpListener r10) {
        this.clockHandView.setOnActionUpListener(r10);
    }

    public void setOnDoubleTapListener(@Nullable OnDoubleTapListener r10) {
        this.onDoubleTapListener = r10;
    }

    public void setOnPeriodChangeListener(OnPeriodChangeListener r10) {
        this.onPeriodChangeListener = r10;
    }

    public void setOnSelectionChangeListener(OnSelectionChange r10) {
        this.onSelectionChangeListener = r10;
    }

    @Override // com.google.android.material.timepicker.TimePickerControls
    public void setValues(String[] r10, @StringRes int r11) {
        this.clockFace.setValues(r10, r11);
    }

    public void showToggle() {
        this.toggle.setVisibility(0);
    }

    @Override // com.google.android.material.timepicker.TimePickerControls
    @SuppressLint({"DefaultLocale"})
    public void updateTime(int r10, int r11, int r12) {
        if (r10 != 1) goto L5;
        int r13 = R.id.material_clock_period_pm_button;
    L6:
        this.toggle.check(r13);
        Locale r14 = getResources().getConfiguration().locale;
        String r15 = String.format(r14, TimeModel.ZERO_LEADING_NUMBER_FORMAT, new Object[]{Integer.valueOf(r12)});
        String r16 = String.format(r14, TimeModel.ZERO_LEADING_NUMBER_FORMAT, new Object[]{Integer.valueOf(r11)});
        this.minuteView.setText(r15);
        this.hourView.setText(r16);
        return;
    L5:
        r13 = R.id.material_clock_period_am_button;
        goto L6
    }

    public TimePickerView(Context r10, @Nullable AttributeSet r11) {
        this(r10, r11, 0);
    }

    public void setHandRotation(float r10, boolean r11) {
        this.clockHandView.setHandRotation(r10, r11);
    }

    public TimePickerView(Context r10, @Nullable AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.selectionListener = new AnonymousClass1(this);
        LayoutInflater.from(r10).inflate(R.layout.material_timepicker, this);
        this.clockFace = (ClockFaceView) findViewById(R.id.material_clock_face);
        MaterialButtonToggleGroup r13 = (MaterialButtonToggleGroup) findViewById(R.id.material_clock_period_toggle);
        this.toggle = r13;
        r13.addOnButtonCheckedListener(new AnonymousClass2(this));
        this.minuteView = (Chip) findViewById(R.id.material_minute_tv);
        this.hourView = (Chip) findViewById(R.id.material_hour_tv);
        this.clockHandView = (ClockHandView) findViewById(R.id.material_clock_hand);
        setupDoubleTap();
        setUpDisplay();
    }
}
