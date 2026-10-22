package com.google.android.material.timepicker;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.fragment.app.DialogFragment;
import com.bytedance.apm.constant.SlardarConfigConsts;
import com.google.android.material.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.shape.MaterialShapeDrawable;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public final class MaterialTimePicker extends DialogFragment {
    public static final int INPUT_MODE_CLOCK = 0;
    static final String INPUT_MODE_EXTRA = "TIME_PICKER_INPUT_MODE";
    public static final int INPUT_MODE_KEYBOARD = 1;
    static final String OVERRIDE_THEME_RES_ID = "TIME_PICKER_OVERRIDE_THEME_RES_ID";
    static final String TIME_MODEL_EXTRA = "TIME_PICKER_TIME_MODEL";
    static final String TITLE_RES_EXTRA = "TIME_PICKER_TITLE_RES";
    static final String TITLE_TEXT_EXTRA = "TIME_PICKER_TITLE_TEXT";

    @Nullable
    private TimePickerPresenter activePresenter;
    private final Set<DialogInterface.OnCancelListener> cancelListeners;

    @DrawableRes
    private int clockIcon;
    private final Set<DialogInterface.OnDismissListener> dismissListeners;
    private int inputMode;

    @DrawableRes
    private int keyboardIcon;
    private MaterialButton modeButton;
    private final Set<View.OnClickListener> negativeButtonListeners;
    private int overrideThemeResId;
    private final Set<View.OnClickListener> positiveButtonListeners;
    private ViewStub textInputStub;
    private TimeModel time;

    @Nullable
    private TimePickerClockPresenter timePickerClockPresenter;

    @Nullable
    private TimePickerTextInputPresenter timePickerTextInputPresenter;
    private TimePickerView timePickerView;
    private int titleResId;
    private String titleText;

    public static final class Builder {
        private int inputMode;
        private int overrideThemeResId;
        private TimeModel time;
        private CharSequence titleText;
        private int titleTextResId;

        public Builder() {
            this.time = new TimeModel();
            this.titleTextResId = 0;
            this.overrideThemeResId = 0;
        }

        public static /* synthetic */ TimeModel access$000(Builder r10) {
            return r10.time;
        }

        public static /* synthetic */ int access$100(Builder r10) {
            return r10.inputMode;
        }

        public static /* synthetic */ int access$200(Builder r10) {
            return r10.titleTextResId;
        }

        public static /* synthetic */ int access$300(Builder r10) {
            return r10.overrideThemeResId;
        }

        public static /* synthetic */ CharSequence access$400(Builder r10) {
            return r10.titleText;
        }

        @NonNull
        public MaterialTimePicker build() {
            return MaterialTimePicker.access$1100(this);
        }

        @NonNull
        public Builder setHour(@IntRange(from = 0, to = 23) int r10) {
            this.time.setHourOfDay(r10);
            return this;
        }

        @NonNull
        public Builder setInputMode(int r10) {
            this.inputMode = r10;
            return this;
        }

        @NonNull
        public Builder setMinute(@IntRange(from = 0, to = SlardarConfigConsts.CPU_COLLECT_INTERVAL) int r10) {
            this.time.setMinute(r10);
            return this;
        }

        @NonNull
        public Builder setTheme(@StyleRes int r10) {
            this.overrideThemeResId = r10;
            return this;
        }

        @NonNull
        public Builder setTimeFormat(int r10) {
            TimeModel r11 = this.time;
            int r12 = r11.hour;
            int r13 = r11.minute;
            TimeModel r14 = new TimeModel(r10);
            this.time = r14;
            r14.setMinute(r13);
            this.time.setHourOfDay(r12);
            return this;
        }

        @NonNull
        public Builder setTitleText(@StringRes int r10) {
            this.titleTextResId = r10;
            return this;
        }

        @NonNull
        public Builder setTitleText(@Nullable CharSequence r10) {
            this.titleText = r10;
            return this;
        }
    }

    public MaterialTimePicker() {
        this.positiveButtonListeners = new LinkedHashSet();
        this.negativeButtonListeners = new LinkedHashSet();
        this.cancelListeners = new LinkedHashSet();
        this.dismissListeners = new LinkedHashSet();
        this.titleResId = 0;
        this.inputMode = 0;
        this.overrideThemeResId = 0;
    }

    public static /* synthetic */ Set access$1000(MaterialTimePicker r10) {
        return r10.negativeButtonListeners;
    }

    public static /* synthetic */ MaterialTimePicker access$1100(Builder r10) {
        return newInstance(r10);
    }

    public static /* synthetic */ int access$500(MaterialTimePicker r10) {
        return r10.inputMode;
    }

    public static /* synthetic */ int access$502(MaterialTimePicker r10, int r11) {
        r10.inputMode = r11;
        return r11;
    }

    public static /* synthetic */ MaterialButton access$600(MaterialTimePicker r10) {
        return r10.modeButton;
    }

    public static /* synthetic */ void access$700(MaterialTimePicker r10, MaterialButton r11) {
        r10.updateInputMode(r11);
    }

    public static /* synthetic */ TimePickerTextInputPresenter access$800(MaterialTimePicker r10) {
        return r10.timePickerTextInputPresenter;
    }

    public static /* synthetic */ Set access$900(MaterialTimePicker r10) {
        return r10.positiveButtonListeners;
    }

    private Pair<Integer, Integer> dataForMode(int r10) {
        if (r10 == 0) goto L10;
        if (r10 != 1) goto L8;
        return new Pair(Integer.valueOf(this.clockIcon), Integer.valueOf(R.string.material_timepicker_clock_mode_description));
    L8:
        throw new IllegalArgumentException("no icon for mode: " + r10);
    L10:
        return new Pair(Integer.valueOf(this.keyboardIcon), Integer.valueOf(R.string.material_timepicker_text_input_mode_description));
    }

    private int getThemeResId() {
        int r10 = this.overrideThemeResId;
        if (r10 == 0) goto L5;
        return r10;
    L5:
        TypedValue r11 = MaterialAttributes.resolve(requireContext(), R.attr.materialTimePickerTheme);
        if (r11 != null) goto L9;
        return 0;
    L9:
        return r11.data;
    }

    private TimePickerPresenter initializeOrRetrieveActivePresenterForMode(int r10) {
        if (r10 != 0) goto L9;
        TimePickerClockPresenter r11 = this.timePickerClockPresenter;
        if (r11 != null) goto L6;
        r11 = new TimePickerClockPresenter(this.timePickerView, this.time);
    L6:
        this.timePickerClockPresenter = r11;
        return r11;
    L9:
        if (this.timePickerTextInputPresenter != null) goto L11;
        this.timePickerTextInputPresenter = new TimePickerTextInputPresenter((LinearLayout) this.textInputStub.inflate(), this.time);
    L11:
        this.timePickerTextInputPresenter.clearCheck();
        return this.timePickerTextInputPresenter;
    }

    @NonNull
    private static MaterialTimePicker newInstance(@NonNull Builder r10) {
        MaterialTimePicker r11 = new MaterialTimePicker();
        Bundle r12 = new Bundle();
        r12.putParcelable(TIME_MODEL_EXTRA, Builder.access$000(r10));
        r12.putInt(INPUT_MODE_EXTRA, Builder.access$100(r10));
        r12.putInt(TITLE_RES_EXTRA, Builder.access$200(r10));
        r12.putInt(OVERRIDE_THEME_RES_ID, Builder.access$300(r10));
        if (Builder.access$400(r10) == null) goto L5;
        r12.putString(TITLE_TEXT_EXTRA, Builder.access$400(r10).toString());
    L5:
        r11.setArguments(r12);
        return r11;
    }

    private void restoreState(@Nullable Bundle r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        TimeModel r11 = (TimeModel) r10.getParcelable(TIME_MODEL_EXTRA);
        this.time = r11;
        if (r11 != null) goto L7;
        this.time = new TimeModel();
    L7:
        this.inputMode = r10.getInt(INPUT_MODE_EXTRA, 0);
        this.titleResId = r10.getInt(TITLE_RES_EXTRA, 0);
        this.titleText = r10.getString(TITLE_TEXT_EXTRA);
        this.overrideThemeResId = r10.getInt(OVERRIDE_THEME_RES_ID, 0);
    }

    private void updateInputMode(MaterialButton r10) {
        TimePickerPresenter r11 = this.activePresenter;
        if (r11 == null) goto L5;
        r11.hide();
    L5:
        TimePickerPresenter r12 = initializeOrRetrieveActivePresenterForMode(this.inputMode);
        this.activePresenter = r12;
        r12.show();
        this.activePresenter.invalidate();
        Pair<Integer, Integer> r13 = dataForMode(this.inputMode);
        r10.setIconResource(((Integer) r13.first).intValue());
        r10.setContentDescription(getResources().getString(((Integer) r13.second).intValue()));
    }

    public boolean addOnCancelListener(@NonNull DialogInterface.OnCancelListener r10) {
        return this.cancelListeners.add(r10);
    }

    public boolean addOnDismissListener(@NonNull DialogInterface.OnDismissListener r10) {
        return this.dismissListeners.add(r10);
    }

    public boolean addOnNegativeButtonClickListener(@NonNull View.OnClickListener r10) {
        return this.negativeButtonListeners.add(r10);
    }

    public boolean addOnPositiveButtonClickListener(@NonNull View.OnClickListener r10) {
        return this.positiveButtonListeners.add(r10);
    }

    public void clearOnCancelListeners() {
        this.cancelListeners.clear();
    }

    public void clearOnDismissListeners() {
        this.dismissListeners.clear();
    }

    public void clearOnNegativeButtonClickListeners() {
        this.negativeButtonListeners.clear();
    }

    public void clearOnPositiveButtonClickListeners() {
        this.positiveButtonListeners.clear();
    }

    @IntRange(from = 0, to = 23)
    public int getHour() {
        return this.time.hour % 24;
    }

    public int getInputMode() {
        return this.inputMode;
    }

    @IntRange(from = 0, to = SlardarConfigConsts.CPU_COLLECT_INTERVAL)
    public int getMinute() {
        return this.time.minute;
    }

    @Nullable
    public TimePickerClockPresenter getTimePickerClockPresenter() {
        return this.timePickerClockPresenter;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public final void onCancel(@NonNull DialogInterface r10) {
        Iterator<DialogInterface.OnCancelListener> r11 = this.cancelListeners.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r11.next().onCancel(r10);
        goto L4
    L6:
        super.onCancel(r10);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle r10) {
        super.onCreate(r10);
        if (r10 != null) goto L5;
        r10 = getArguments();
    L5:
        restoreState(r10);
    }

    @Override // androidx.fragment.app.DialogFragment
    @NonNull
    public final Dialog onCreateDialog(@Nullable Bundle r10) {
        Dialog r11 = new Dialog(requireContext(), getThemeResId());
        Context r12 = r11.getContext();
        int r13 = MaterialAttributes.resolveOrThrow(r12, R.attr.colorSurface, MaterialTimePicker.class.getCanonicalName());
        int r14 = R.attr.materialTimePickerStyle;
        int r15 = R.style.Widget_MaterialComponents_TimePicker;
        MaterialShapeDrawable r16 = new MaterialShapeDrawable(r12, null, r14, r15);
        TypedArray r17 = r12.obtainStyledAttributes(null, R.styleable.MaterialTimePicker, r14, r15);
        this.clockIcon = r17.getResourceId(R.styleable.MaterialTimePicker_clockIcon, 0);
        this.keyboardIcon = r17.getResourceId(R.styleable.MaterialTimePicker_keyboardIcon, 0);
        r17.recycle();
        r16.initializeElevationOverlay(r12);
        r16.setFillColor(ColorStateList.valueOf(r13));
        Window r18 = r11.getWindow();
        r18.setBackgroundDrawable(r16);
        r18.requestFeature(1);
        r18.setLayout(-2, -2);
        return r11;
    }

    @Override // androidx.fragment.app.Fragment
    @NonNull
    public final View onCreateView(@NonNull LayoutInflater r10, @Nullable ViewGroup r11, @Nullable Bundle r12) {
        ViewGroup r13 = (ViewGroup) r10.inflate(R.layout.material_timepicker_dialog, r11);
        TimePickerView r14 = (TimePickerView) r13.findViewById(R.id.material_timepicker_view);
        this.timePickerView = r14;
        r14.setOnDoubleTapListener(new AnonymousClass1(this));
        this.textInputStub = (ViewStub) r13.findViewById(R.id.material_textinput_timepicker);
        this.modeButton = (MaterialButton) r13.findViewById(R.id.material_timepicker_mode_button);
        TextView r15 = (TextView) r13.findViewById(R.id.header_title);
        if (TextUtils.isEmpty(this.titleText) == true) goto L5;
        r15.setText(this.titleText);
    L5:
        int r16 = this.titleResId;
        if (r16 == 0) goto L8;
        r15.setText(r16);
    L8:
        updateInputMode(this.modeButton);
        ((Button) r13.findViewById(R.id.material_timepicker_ok_button)).setOnClickListener(new AnonymousClass2(this));
        ((Button) r13.findViewById(R.id.material_timepicker_cancel_button)).setOnClickListener(new AnonymousClass3(this));
        this.modeButton.setOnClickListener(new AnonymousClass4(this));
        return r13;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(@NonNull DialogInterface r10) {
        Iterator<DialogInterface.OnDismissListener> r11 = this.dismissListeners.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r11.next().onDismiss(r10);
        goto L4
    L6:
        super.onDismiss(r10);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle r10) {
        super.onSaveInstanceState(r10);
        r10.putParcelable(TIME_MODEL_EXTRA, this.time);
        r10.putInt(INPUT_MODE_EXTRA, this.inputMode);
        r10.putInt(TITLE_RES_EXTRA, this.titleResId);
        r10.putString(TITLE_TEXT_EXTRA, this.titleText);
        r10.putInt(OVERRIDE_THEME_RES_ID, this.overrideThemeResId);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        this.activePresenter = null;
        this.timePickerClockPresenter = null;
        this.timePickerTextInputPresenter = null;
        this.timePickerView = null;
    }

    public boolean removeOnCancelListener(@NonNull DialogInterface.OnCancelListener r10) {
        return this.cancelListeners.remove(r10);
    }

    public boolean removeOnDismissListener(@NonNull DialogInterface.OnDismissListener r10) {
        return this.dismissListeners.remove(r10);
    }

    public boolean removeOnNegativeButtonClickListener(@NonNull View.OnClickListener r10) {
        return this.negativeButtonListeners.remove(r10);
    }

    public boolean removeOnPositiveButtonClickListener(@NonNull View.OnClickListener r10) {
        return this.positiveButtonListeners.remove(r10);
    }
}
