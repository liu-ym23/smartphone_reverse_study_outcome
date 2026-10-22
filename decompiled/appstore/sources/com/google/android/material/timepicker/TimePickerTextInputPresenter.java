package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.core.content.ContextCompat;
import c.a;
import com.google.android.material.R;
import com.google.android.material.button.MaterialButtonToggleGroup;
import java.lang.reflect.Field;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
class TimePickerTextInputPresenter implements TimePickerView.OnSelectionChange, TimePickerPresenter {
    private final TimePickerTextInputKeyController controller;
    private final EditText hourEditText;
    private final ChipTextInputComboView hourTextInput;
    private final TextWatcher hourTextWatcher;
    private final EditText minuteEditText;
    private final ChipTextInputComboView minuteTextInput;
    private final TextWatcher minuteTextWatcher;
    private final TimeModel time;
    private final LinearLayout timePickerView;
    private MaterialButtonToggleGroup toggle;

    public TimePickerTextInputPresenter(LinearLayout r10, TimeModel r11) {
        this.minuteTextWatcher = new AnonymousClass1(this);
        this.hourTextWatcher = new AnonymousClass2(this);
        this.timePickerView = r10;
        this.time = r11;
        Resources r12 = r10.getResources();
        ChipTextInputComboView r13 = (ChipTextInputComboView) r10.findViewById(R.id.material_minute_text_input);
        this.minuteTextInput = r13;
        ChipTextInputComboView r14 = (ChipTextInputComboView) r10.findViewById(R.id.material_hour_text_input);
        this.hourTextInput = r14;
        int r15 = R.id.material_label;
        TextView r16 = (TextView) r13.findViewById(r15);
        TextView r17 = (TextView) r14.findViewById(r15);
        r16.setText(r12.getString(R.string.material_timepicker_minute));
        r17.setText(r12.getString(R.string.material_timepicker_hour));
        int r18 = R.id.selection_type;
        r13.setTag(r18, 12);
        r14.setTag(r18, 10);
        if (r11.format != 0) goto L5;
        setupPeriodToggle();
    L5:
        View.OnClickListener r19 = new AnonymousClass3(this);
        r14.setOnClickListener(r19);
        r13.setOnClickListener(r19);
        r14.addInputFilter(r11.getHourInputValidator());
        r13.addInputFilter(r11.getMinuteInputValidator());
        this.hourEditText = r14.getTextInput().getEditText();
        this.minuteEditText = r13.getTextInput().getEditText();
        this.controller = new TimePickerTextInputKeyController(r14, r13, r11);
        r14.setChipDelegate(new ClickActionDelegate(r10.getContext(), R.string.material_hour_selection));
        r13.setChipDelegate(new ClickActionDelegate(r10.getContext(), R.string.material_minute_selection));
        initialize();
    }

    public static /* synthetic */ TimeModel access$000(TimePickerTextInputPresenter r10) {
        return r10.time;
    }

    private void addTextWatchers() {
        this.hourEditText.addTextChangedListener(this.hourTextWatcher);
        this.minuteEditText.addTextChangedListener(this.minuteTextWatcher);
    }

    private void removeTextWatchers() {
        this.hourEditText.removeTextChangedListener(this.hourTextWatcher);
        this.minuteEditText.removeTextChangedListener(this.minuteTextWatcher);
    }

    private static void setCursorDrawableColor(EditText r10, @ColorInt int r11) {
        Context r12 = r10.getContext();     // Catch: Throwable -> L5
        Field r13 = TextView.class.getDeclaredField("mCursorDrawableRes");     // Catch: Throwable -> L5
        r13.setAccessible(true);     // Catch: Throwable -> L5
        int r14 = r13.getInt(r10);     // Catch: Throwable -> L5
        Field r15 = TextView.class.getDeclaredField("mEditor");     // Catch: Throwable -> L5
        r15.setAccessible(true);     // Catch: Throwable -> L5
        Object r16 = r15.get(r10);     // Catch: Throwable -> L5
        Field r17 = r16.getClass().getDeclaredField("mCursorDrawable");     // Catch: Throwable -> L5
        r17.setAccessible(true);     // Catch: Throwable -> L5
        Drawable r18 = a.b(r12, r14);     // Catch: Throwable -> L5
        r18.setColorFilter(r11, PorterDuff.Mode.SRC_IN);     // Catch: Throwable -> L5
        r17.set(r16, new Drawable[]{r18, r18});     // Catch: Throwable -> L5
        return;
    }

    private void setTime(TimeModel r10) {
        removeTextWatchers();
        Locale r11 = this.timePickerView.getResources().getConfiguration().locale;
        String r12 = String.format(r11, TimeModel.ZERO_LEADING_NUMBER_FORMAT, new Object[]{Integer.valueOf(r10.minute)});
        String r13 = String.format(r11, TimeModel.ZERO_LEADING_NUMBER_FORMAT, new Object[]{Integer.valueOf(r10.getHourForDisplay())});
        this.minuteTextInput.setText(r12);
        this.hourTextInput.setText(r13);
        addTextWatchers();
        updateSelection();
    }

    private void setupPeriodToggle() {
        MaterialButtonToggleGroup r10 = (MaterialButtonToggleGroup) this.timePickerView.findViewById(R.id.material_clock_period_toggle);
        this.toggle = r10;
        r10.addOnButtonCheckedListener(new AnonymousClass4(this));
        this.toggle.setVisibility(0);
        updateSelection();
    }

    private void updateSelection() {
        MaterialButtonToggleGroup r10 = this.toggle;
        if (r10 != null) goto L6;
        return;
    L6:
        if (this.time.period != 0) goto L8;
        int r11 = R.id.material_clock_period_am_button;
    L9:
        r10.check(r11);
        return;
    L8:
        r11 = R.id.material_clock_period_pm_button;
        goto L9
    }

    public void clearCheck() {
        this.minuteTextInput.setChecked(false);
        this.hourTextInput.setChecked(false);
    }

    @Override // com.google.android.material.timepicker.TimePickerPresenter
    public void hide() {
        View r10 = this.timePickerView.getFocusedChild();
        if (r10 != null) goto L6;
        this.timePickerView.setVisibility(8);
        return;
    L6:
        InputMethodManager r11 = (InputMethodManager) ContextCompat.h(this.timePickerView.getContext(), InputMethodManager.class);
        if (r11 == null) goto L9;
        r11.hideSoftInputFromWindow(r10.getWindowToken(), 0);
    L9:
        this.timePickerView.setVisibility(8);
    }

    @Override // com.google.android.material.timepicker.TimePickerPresenter
    public void initialize() {
        addTextWatchers();
        setTime(this.time);
        this.controller.bind();
    }

    @Override // com.google.android.material.timepicker.TimePickerPresenter
    public void invalidate() {
        setTime(this.time);
    }

    @Override // com.google.android.material.timepicker.TimePickerView.OnSelectionChange
    public void onSelectionChanged(int r10) {
        this.time.selection = r10;
        ChipTextInputComboView r11 = this.minuteTextInput;
        boolean r12 = false;
        if (r10 != 12) goto L5;
        boolean r13 = true;
    L6:
        r11.setChecked(r13);
        ChipTextInputComboView r14 = this.hourTextInput;
        if (r10 != 10) goto L9;
        r12 = true;
    L9:
        r14.setChecked(r12);
        updateSelection();
        return;
    L5:
        r13 = false;
        goto L6
    }

    public void resetChecked() {
        ChipTextInputComboView r10 = this.minuteTextInput;
        boolean r11 = false;
        if (this.time.selection != 12) goto L5;
        boolean r12 = true;
    L6:
        r10.setChecked(r12);
        ChipTextInputComboView r13 = this.hourTextInput;
        if (this.time.selection != 10) goto L9;
        r11 = true;
    L9:
        r13.setChecked(r11);
        return;
    L5:
        r12 = false;
        goto L6
    }

    @Override // com.google.android.material.timepicker.TimePickerPresenter
    public void show() {
        this.timePickerView.setVisibility(0);
    }
}
