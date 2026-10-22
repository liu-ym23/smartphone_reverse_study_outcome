package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import com.google.android.material.R;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.internal.ViewUtils;
import java.lang.reflect.Field;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
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

    static /* synthetic */ TimeModel access$000(TimePickerTextInputPresenter r0) {
        return r0.time;
    }

    public TimePickerTextInputPresenter(LinearLayout r7, final TimeModel r8) {
        this.minuteTextWatcher = new AnonymousClass1(this);
        this.hourTextWatcher = new AnonymousClass2(this);
        this.timePickerView = r7;
        this.time = r8;
        Resources r0 = r7.getResources();
        ChipTextInputComboView r1 = (ChipTextInputComboView) r7.findViewById(R.id.material_minute_text_input);
        this.minuteTextInput = r1;
        ChipTextInputComboView r2 = (ChipTextInputComboView) r7.findViewById(R.id.material_hour_text_input);
        this.hourTextInput = r2;
        TextView r3 = (TextView) r1.findViewById(R.id.material_label);
        TextView r4 = (TextView) r2.findViewById(R.id.material_label);
        r3.setText(r0.getString(R.string.material_timepicker_minute));
        r4.setText(r0.getString(R.string.material_timepicker_hour));
        r1.setTag(R.id.selection_type, 12);
        r2.setTag(R.id.selection_type, 10);
        if (r8.format != 0) goto L5;
        setupPeriodToggle();
    L5:
        View.OnClickListener r5 = new AnonymousClass3(this);
        r2.setOnClickListener(r5);
        r1.setOnClickListener(r5);
        r2.addInputFilter(r8.getHourInputValidator());
        r1.addInputFilter(r8.getMinuteInputValidator());
        this.hourEditText = r2.getTextInput().getEditText();
        this.minuteEditText = r1.getTextInput().getEditText();
        this.controller = new TimePickerTextInputKeyController(r2, r1, r8);
        final Context r6 = r7.getContext();
        final int r9 = R.string.material_hour_selection;
        r2.setChipDelegate(new AnonymousClass4(this, r6, r9, r8));
        final Context r10 = r7.getContext();
        final int r11 = R.string.material_minute_selection;
        r1.setChipDelegate(new AnonymousClass5(this, r10, r11, r8));
        initialize();
    }

    @Override // com.google.android.material.timepicker.TimePickerPresenter
    public void initialize() {
        addTextWatchers();
        setTime(this.time);
        this.controller.bind();
    }

    private void addTextWatchers() {
        this.hourEditText.addTextChangedListener(this.hourTextWatcher);
        this.minuteEditText.addTextChangedListener(this.minuteTextWatcher);
    }

    private void removeTextWatchers() {
        this.hourEditText.removeTextChangedListener(this.hourTextWatcher);
        this.minuteEditText.removeTextChangedListener(this.minuteTextWatcher);
    }

    private void setTime(TimeModel r6) {
        removeTextWatchers();
        Locale r0 = this.timePickerView.getResources().getConfiguration().locale;
        String r2 = String.format(r0, TimeModel.ZERO_LEADING_NUMBER_FORMAT, new Object[]{Integer.valueOf(r6.minute)});
        String r7 = String.format(r0, TimeModel.ZERO_LEADING_NUMBER_FORMAT, new Object[]{Integer.valueOf(r6.getHourForDisplay())});
        this.minuteTextInput.setText(r2);
        this.hourTextInput.setText(r7);
        addTextWatchers();
        updateSelection();
    }

    private void setupPeriodToggle() {
        MaterialButtonToggleGroup r0 = (MaterialButtonToggleGroup) this.timePickerView.findViewById(R.id.material_clock_period_toggle);
        this.toggle = r0;
        r0.addOnButtonCheckedListener(new TimePickerTextInputPresenter$$ExternalSyntheticLambda0(this));
        this.toggle.setVisibility(0);
        updateSelection();
    }

    /* JADX INFO: renamed from: lambda$setupPeriodToggle$0$com-google-android-material-timepicker-TimePickerTextInputPresenter, reason: not valid java name */
    /* synthetic */ void m286xf2085e95(MaterialButtonToggleGroup r1, int r2, boolean r3) {
        if (r3 == true) goto L5;
        return;
    L5:
        if (r2 != R.id.material_clock_period_pm_button) goto L7;
        int r4 = 1;
    L8:
        this.time.setPeriod(r4);
        return;
    L7:
        r4 = 0;
        goto L8
    }

    private void updateSelection() {
        MaterialButtonToggleGroup r0 = this.toggle;
        if (r0 != null) goto L6;
        return;
    L6:
        if (this.time.period != 0) goto L8;
        int r1 = R.id.material_clock_period_am_button;
    L9:
        r0.check(r1);
        return;
    L8:
        r1 = R.id.material_clock_period_pm_button;
        goto L9
    }

    @Override // com.google.android.material.timepicker.TimePickerView.OnSelectionChange
    public void onSelectionChanged(int r5) {
        this.time.selection = r5;
        ChipTextInputComboView r0 = this.minuteTextInput;
        boolean r2 = true;
        if (r5 != 12) goto L5;
        boolean r1 = true;
    L6:
        r0.setChecked(r1);
        ChipTextInputComboView r3 = this.hourTextInput;
        if (r5 == 10) goto L10;
        r2 = false;
    L10:
        r3.setChecked(r2);
        updateSelection();
        return;
    L5:
        r1 = false;
        goto L6
    }

    @Override // com.google.android.material.timepicker.TimePickerPresenter
    public void show() {
        this.timePickerView.setVisibility(0);
        onSelectionChanged(this.time.selection);
    }

    @Override // com.google.android.material.timepicker.TimePickerPresenter
    public void hide() {
        View r0 = this.timePickerView.getFocusedChild();
        if (r0 == null) goto L5;
        ViewUtils.hideKeyboard(r0);
    L5:
        this.timePickerView.setVisibility(8);
    }

    @Override // com.google.android.material.timepicker.TimePickerPresenter
    public void invalidate() {
        setTime(this.time);
    }

    private static void setCursorDrawableColor(EditText r5, int r6) {
        Context r0 = r5.getContext();     // Catch: Throwable -> L4
        Field r1 = TextView.class.getDeclaredField("mCursorDrawableRes");     // Catch: Throwable -> L4
        r1.setAccessible(true);     // Catch: Throwable -> L4
        int r2 = r1.getInt(r5);     // Catch: Throwable -> L4
        Field r3 = TextView.class.getDeclaredField("mEditor");     // Catch: Throwable -> L4
        r3.setAccessible(true);     // Catch: Throwable -> L4
        Object r7 = r3.get(r5);     // Catch: Throwable -> L4
        Field r4 = r7.getClass().getDeclaredField("mCursorDrawable");     // Catch: Throwable -> L4
        r4.setAccessible(true);     // Catch: Throwable -> L4
        Drawable r8 = AppCompatResources.getDrawable(r0, r2);     // Catch: Throwable -> L4
        r8.setColorFilter(r6, PorterDuff.Mode.SRC_IN);     // Catch: Throwable -> L4
        r4.set(r7, new Drawable[]{r8, r8});     // Catch: Throwable -> L4
        return;
    }

    public void resetChecked() {
        ChipTextInputComboView r0 = this.minuteTextInput;
        boolean r3 = true;
        if (this.time.selection != 12) goto L5;
        boolean r1 = true;
    L6:
        r0.setChecked(r1);
        ChipTextInputComboView r2 = this.hourTextInput;
        if (this.time.selection == 10) goto L10;
        r3 = false;
    L10:
        r2.setChecked(r3);
        return;
    L5:
        r1 = false;
        goto L6
    }

    public void clearCheck() {
        this.minuteTextInput.setChecked(false);
        this.hourTextInput.setChecked(false);
    }
}
