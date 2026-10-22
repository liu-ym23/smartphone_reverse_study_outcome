package com.google.android.material.timepicker;

import android.view.accessibility.AccessibilityManager;
import androidx.core.content.ContextCompat;
import com.bytedance.apm.constant.CommonServiceName;
import com.bytedanceos.common.ad.common.AdConstant;
import com.bytedanceos.common.networkv2.params.NetValue;
import com.google.android.material.R;

/* JADX INFO: loaded from: classes3.dex */
class TimePickerClockPresenter implements ClockHandView.OnRotateListener, TimePickerView.OnSelectionChange, TimePickerView.OnPeriodChangeListener, ClockHandView.OnActionUpListener, TimePickerPresenter {
    private static final int DEGREES_PER_HOUR = 30;
    private static final int DEGREES_PER_MINUTE = 6;
    private static final String[] HOUR_CLOCK_24_VALUES = null;
    private static final String[] HOUR_CLOCK_VALUES = null;
    private static final String[] MINUTE_CLOCK_VALUES = null;
    private boolean broadcasting;
    private float hourRotation;
    private float minuteRotation;
    private TimeModel time;
    private TimePickerView timePickerView;

    static {
        HOUR_CLOCK_VALUES = new String[]{"12", "1", "2", "3", "4", "5", "6", NetValue.AppStatusType.DOWNLOAD_FAILURE_NEW, "8", NetValue.AppStatusType.REQUEST_DOWNLOAD, NetValue.AppStatusType.INSTALL_SUCCESS, CommonServiceName.CRONET_ERROR_CODE_CANCEL};
        HOUR_CLOCK_24_VALUES = new String[]{AdConstant.OperatorCode.CHINA_TELECOM, "2", "4", "6", "8", NetValue.AppStatusType.INSTALL_SUCCESS, "12", "14", "16", "18", "20", "22"};
        MINUTE_CLOCK_VALUES = new String[]{AdConstant.OperatorCode.CHINA_TELECOM, "5", NetValue.AppStatusType.INSTALL_SUCCESS, "15", "20", "25", "30", "35", "40", "45", "50", "55"};
    }

    public TimePickerClockPresenter(TimePickerView r10, TimeModel r11) {
        this.broadcasting = false;
        this.timePickerView = r10;
        this.time = r11;
        initialize();
    }

    private int getDegreesPerHour() {
        if (this.time.format != 1) goto L5;
        return 15;
    L5:
        return 30;
    }

    private String[] getHourClockValues() {
        if (this.time.format != 1) goto L6;
        return HOUR_CLOCK_24_VALUES;
    L6:
        return HOUR_CLOCK_VALUES;
    }

    private void performHapticFeedback(int r10, int r11) {
        TimeModel r12 = this.time;
        if (r12.minute == r11) goto L5;
    L6:
        this.timePickerView.performHapticFeedback(4);
        return;
    L5:
        if (r12.hour != r10) goto L6;
    }

    private void updateTime() {
        TimePickerView r10 = this.timePickerView;
        TimeModel r11 = this.time;
        r10.updateTime(r11.period, r11.getHourForDisplay(), this.time.minute);
    }

    private void updateValues() {
        updateValues(HOUR_CLOCK_VALUES, TimeModel.NUMBER_FORMAT);
        updateValues(HOUR_CLOCK_24_VALUES, TimeModel.NUMBER_FORMAT);
        updateValues(MINUTE_CLOCK_VALUES, TimeModel.ZERO_LEADING_NUMBER_FORMAT);
    }

    @Override // com.google.android.material.timepicker.TimePickerPresenter
    public void hide() {
        this.timePickerView.setVisibility(8);
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
        this.hourRotation = this.time.getHourForDisplay() * getDegreesPerHour();
        TimeModel r10 = this.time;
        this.minuteRotation = r10.minute * 6;
        setSelection(r10.selection, false);
        updateTime();
    }

    @Override // com.google.android.material.timepicker.ClockHandView.OnActionUpListener
    public void onActionUp(float r10, boolean r11) {
        this.broadcasting = true;
        TimeModel r12 = this.time;
        int r13 = r12.minute;
        int r14 = r12.hour;
        if (r12.selection != 10) goto L7;
        this.timePickerView.setHandRotation(this.hourRotation, false);
        if (((AccessibilityManager) ContextCompat.h(this.timePickerView.getContext(), AccessibilityManager.class)).isTouchExplorationEnabled() == true) goto L11;
        setSelection(12, true);
    L11:
        this.broadcasting = false;
        updateTime();
        performHapticFeedback(r14, r13);
        return;
    L7:
        int r15 = Math.round(r10);
        if (r11 == true) goto L10;
        this.time.setMinute(((r15 + 15) / 30) * 5);
        this.minuteRotation = this.time.minute * 6;
    L10:
        this.timePickerView.setHandRotation(this.minuteRotation, r11);
        goto L11
    }

    @Override // com.google.android.material.timepicker.TimePickerView.OnPeriodChangeListener
    public void onPeriodChange(int r10) {
        this.time.setPeriod(r10);
    }

    @Override // com.google.android.material.timepicker.ClockHandView.OnRotateListener
    public void onRotate(float r10, boolean r11) {
        if (this.broadcasting == false) goto L5;
        return;
    L5:
        TimeModel r12 = this.time;
        int r13 = r12.hour;
        int r14 = r12.minute;
        int r15 = Math.round(r10);
        TimeModel r16 = this.time;
        if (r16.selection != 12) goto L8;
        r16.setMinute((r15 + 3) / 6);
        this.minuteRotation = (float) Math.floor(this.time.minute * 6);
    L9:
        if (r11 == true) goto L12;
        updateTime();
        performHapticFeedback(r13, r14);
        return;
    L12:
        return;
    L8:
        this.time.setHour((r15 + (getDegreesPerHour() / 2)) / getDegreesPerHour());
        this.hourRotation = this.time.getHourForDisplay() * getDegreesPerHour();
        goto L9
    }

    @Override // com.google.android.material.timepicker.TimePickerView.OnSelectionChange
    public void onSelectionChanged(int r10) {
        setSelection(r10, true);
    }

    public void setSelection(int r10, boolean r11) {
        if (r10 != 12) goto L5;
        boolean r12 = true;
    L6:
        this.timePickerView.setAnimateOnTouchUp(r12);
        this.time.selection = r10;
        TimePickerView r13 = this.timePickerView;
        if (r12 == false) goto L9;
        String[] r14 = MINUTE_CLOCK_VALUES;
    L10:
        if (r12 == false) goto L12;
        int r15 = R.string.material_minute_suffix;
    L13:
        r13.setValues(r14, r15);
        TimePickerView r16 = this.timePickerView;
        if (r12 == false) goto L16;
        float r17 = this.minuteRotation;
    L17:
        r16.setHandRotation(r17, r11);
        this.timePickerView.setActiveSelection(r10);
        this.timePickerView.setMinuteHourDelegate(new ClickActionDelegate(this.timePickerView.getContext(), R.string.material_hour_selection));
        this.timePickerView.setHourClickDelegate(new ClickActionDelegate(this.timePickerView.getContext(), R.string.material_minute_selection));
        return;
    L16:
        r17 = this.hourRotation;
        goto L17
    L12:
        r15 = R.string.material_hour_suffix;
        goto L13
    L9:
        r14 = getHourClockValues();
        goto L10
    L5:
        r12 = false;
        goto L6
    }

    @Override // com.google.android.material.timepicker.TimePickerPresenter
    public void show() {
        this.timePickerView.setVisibility(0);
    }

    private void updateValues(String[] r10, String r11) {
        int r12 = 0;
    L4:
        if (r12 >= r10.length) goto L6;
        r10[r12] = TimeModel.formatText(this.timePickerView.getResources(), r10[r12], r11);
        r12 = r12 + 1;
        goto L4
    }
}
