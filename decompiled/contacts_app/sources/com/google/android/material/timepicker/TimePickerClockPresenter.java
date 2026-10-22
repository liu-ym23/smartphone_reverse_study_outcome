package com.google.android.material.timepicker;

import android.content.Context;
import android.view.accessibility.AccessibilityManager;
import androidx.core.content.ContextCompat;
import com.bytedance.apm.constant.CommonServiceName;
import com.google.android.material.R;
import com.obric.contactsdk.loader.ContractKt;

/* JADX INFO: loaded from: classes2.dex */
class TimePickerClockPresenter implements ClockHandView.OnRotateListener, TimePickerView.OnSelectionChange, TimePickerView.OnPeriodChangeListener, ClockHandView.OnActionUpListener, TimePickerPresenter {
    private static final int DEGREES_PER_HOUR = 30;
    private static final int DEGREES_PER_MINUTE = 6;
    private static final String[] HOUR_CLOCK_24_VALUES = null;
    private static final String[] HOUR_CLOCK_VALUES = null;
    private static final String[] MINUTE_CLOCK_VALUES = null;
    private boolean broadcasting;
    private float hourRotation;
    private float minuteRotation;
    private final TimeModel time;
    private final TimePickerView timePickerView;

    static /* synthetic */ TimeModel access$000(TimePickerClockPresenter r0) {
        return r0.time;
    }

    static {
        HOUR_CLOCK_VALUES = new String[]{ContractKt.RELATION_FAMILY, "1", "2", "3", "4", "5", ContractKt.RELATION_FRIEND, "7", "8", "9", ContractKt.RELATION_PARTNER, CommonServiceName.CRONET_ERROR_CODE_CANCEL};
        HOUR_CLOCK_24_VALUES = new String[]{"00", "1", "2", "3", "4", "5", ContractKt.RELATION_FRIEND, "7", "8", "9", ContractKt.RELATION_PARTNER, CommonServiceName.CRONET_ERROR_CODE_CANCEL, ContractKt.RELATION_FAMILY, "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"};
        MINUTE_CLOCK_VALUES = new String[]{"00", "5", ContractKt.RELATION_PARTNER, "15", "20", "25", "30", "35", "40", "45", "50", "55"};
    }

    public TimePickerClockPresenter(TimePickerView r2, TimeModel r3) {
        this.broadcasting = false;
        this.timePickerView = r2;
        this.time = r3;
        initialize();
    }

    @Override // com.google.android.material.timepicker.TimePickerPresenter
    public void initialize() {
        if (this.time.format != 0) goto L5;
        this.timePickerView.showToggle();
    L5:
        this.timePickerView.addOnRotateListener(this);
        this.timePickerView.setOnSelectionChangeListener(this);
        this.timePickerView.setOnPeriodChangeListener(this);
        this.timePickerView.setOnActionUpListener(this);
        updateValues();
        invalidate();
    }

    @Override // com.google.android.material.timepicker.TimePickerPresenter
    public void invalidate() {
        this.hourRotation = getHourRotation();
        this.minuteRotation = this.time.minute * 6;
        setSelection(this.time.selection, false);
        updateTime();
    }

    @Override // com.google.android.material.timepicker.TimePickerPresenter
    public void show() {
        this.timePickerView.setVisibility(0);
    }

    @Override // com.google.android.material.timepicker.TimePickerPresenter
    public void hide() {
        this.timePickerView.setVisibility(8);
    }

    private String[] getHourClockValues() {
        if (this.time.format != 1) goto L6;
        return HOUR_CLOCK_24_VALUES;
    L6:
        return HOUR_CLOCK_VALUES;
    }

    @Override // com.google.android.material.timepicker.ClockHandView.OnRotateListener
    public void onRotate(float r5, boolean r6) {
        if (this.broadcasting == false) goto L5;
        return;
    L5:
        int r0 = this.time.hour;
        int r1 = this.time.minute;
        int r7 = Math.round(r5);
        if (this.time.selection != 12) goto L8;
        this.time.setMinute((r7 + 3) / 6);
        this.minuteRotation = (float) Math.floor(this.time.minute * 6);
    L14:
        if (r6 == true) goto L17;
        updateTime();
        performHapticFeedback(r0, r1);
        return;
    L17:
        return;
    L8:
        int r8 = (r7 + 15) / 30;
        if (this.time.format != 1) goto L13;
        r8 = r8 % 12;
        if (this.timePickerView.getCurrentLevel() != 2) goto L13;
        r8 = r8 + 12;
    L13:
        this.time.setHour(r8);
        this.hourRotation = getHourRotation();
        goto L14
    }

    private void performHapticFeedback(int r2, int r3) {
        if (this.time.minute == r3) goto L5;
    L6:
        this.timePickerView.performHapticFeedback(4);
        return;
    L5:
        if (this.time.hour != r2) goto L6;
    }

    @Override // com.google.android.material.timepicker.TimePickerView.OnSelectionChange
    public void onSelectionChanged(int r2) {
        setSelection(r2, true);
    }

    @Override // com.google.android.material.timepicker.TimePickerView.OnPeriodChangeListener
    public void onPeriodChange(int r1) {
        this.time.setPeriod(r1);
    }

    void setSelection(int r5, boolean r6) {
        if (r5 != 12) goto L5;
        boolean r0 = true;
    L6:
        this.timePickerView.setAnimateOnTouchUp(r0);
        this.time.selection = r5;
        TimePickerView r1 = this.timePickerView;
        if (r0 == false) goto L9;
        String[] r2 = MINUTE_CLOCK_VALUES;
    L10:
        if (r0 == false) goto L12;
        int r3 = R.string.material_minute_suffix;
    L13:
        r1.setValues(r2, r3);
        updateCurrentLevel();
        TimePickerView r4 = this.timePickerView;
        if (r0 == false) goto L16;
        float r7 = this.minuteRotation;
    L17:
        r4.setHandRotation(r7, r6);
        this.timePickerView.setActiveSelection(r5);
        TimePickerView r8 = this.timePickerView;
        final Context r9 = this.timePickerView.getContext();
        final int r10 = R.string.material_hour_selection;
        r8.setMinuteHourDelegate(new AnonymousClass1(this, r9, r10));
        TimePickerView r11 = this.timePickerView;
        final Context r12 = this.timePickerView.getContext();
        final int r13 = R.string.material_minute_selection;
        r11.setHourClickDelegate(new AnonymousClass2(this, r12, r13));
        return;
    L16:
        r7 = this.hourRotation;
        goto L17
    L12:
        r3 = this.time.getHourContentDescriptionResId();
        goto L13
    L9:
        r2 = getHourClockValues();
        goto L10
    L5:
        r0 = false;
        goto L6
    }

    private void updateCurrentLevel() {
        int r2 = 1;
        if (this.time.selection == 10) goto L5;
    L9:
        this.timePickerView.setCurrentLevel(r2);
        return;
    L5:
        if (this.time.format != 1) goto L9;
        if (this.time.hour < 12) goto L9;
        r2 = 2;
        goto L9
    }

    @Override // com.google.android.material.timepicker.ClockHandView.OnActionUpListener
    public void onActionUp(float r7, boolean r8) {
        this.broadcasting = true;
        int r1 = this.time.minute;
        int r2 = this.time.hour;
        if (this.time.selection != 10) goto L12;
        this.timePickerView.setHandRotation(this.hourRotation, false);
        AccessibilityManager r9 = (AccessibilityManager) ContextCompat.getSystemService(this.timePickerView.getContext(), AccessibilityManager.class);
        if (r9 != null) goto L7;
    L9:
        boolean r10 = false;
    L10:
        if (r10 == true) goto L16;
        setSelection(12, true);
    L16:
        this.broadcasting = false;
        updateTime();
        performHapticFeedback(r2, r1);
        return;
    L7:
        if (r9.isTouchExplorationEnabled() == false) goto L9;
        r10 = true;
        goto L10
    L12:
        int r11 = Math.round(r7);
        if (r8 == true) goto L15;
        this.time.setMinute(((r11 + 15) / 30) * 5);
        this.minuteRotation = this.time.minute * 6;
    L15:
        this.timePickerView.setHandRotation(this.minuteRotation, r8);
        goto L16
    }

    private void updateTime() {
        this.timePickerView.updateTime(this.time.period, this.time.getHourForDisplay(), this.time.minute);
    }

    private void updateValues() {
        updateValues(HOUR_CLOCK_VALUES, TimeModel.NUMBER_FORMAT);
        updateValues(MINUTE_CLOCK_VALUES, TimeModel.ZERO_LEADING_NUMBER_FORMAT);
    }

    private void updateValues(String[] r4, String r5) {
        int r0 = 0;
    L4:
        if (r0 >= r4.length) goto L6;
        r4[r0] = TimeModel.formatText(this.timePickerView.getResources(), r4[r0], r5);
        r0 = r0 + 1;
        goto L4
    }

    private int getHourRotation() {
        return (this.time.getHourForDisplay() * 30) % 360;
    }
}
