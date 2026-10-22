package com.google.android.material.datepicker;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.core.util.c;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentTransaction;
import c.a;
import com.google.android.material.dialog.InsetDialogOnTouchListener;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.shape.MaterialShapeDrawable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* JADX INFO: loaded from: classes3.dex */
public final class MaterialDatePicker<S> extends DialogFragment {
    private static final String CALENDAR_CONSTRAINTS_KEY = "CALENDAR_CONSTRAINTS_KEY";
    static final Object CANCEL_BUTTON_TAG = null;
    static final Object CONFIRM_BUTTON_TAG = null;
    private static final String DATE_SELECTOR_KEY = "DATE_SELECTOR_KEY";
    public static final int INPUT_MODE_CALENDAR = 0;
    private static final String INPUT_MODE_KEY = "INPUT_MODE_KEY";
    public static final int INPUT_MODE_TEXT = 1;
    private static final String OVERRIDE_THEME_RES_ID = "OVERRIDE_THEME_RES_ID";
    private static final String TITLE_TEXT_KEY = "TITLE_TEXT_KEY";
    private static final String TITLE_TEXT_RES_ID_KEY = "TITLE_TEXT_RES_ID_KEY";
    static final Object TOGGLE_BUTTON_TAG = null;

    @Nullable
    private MaterialShapeDrawable background;
    private MaterialCalendar<S> calendar;

    @Nullable
    private CalendarConstraints calendarConstraints;
    private Button confirmButton;

    @Nullable
    private DateSelector<S> dateSelector;
    private boolean fullscreen;
    private TextView headerSelectionText;
    private CheckableImageButton headerToggleButton;
    private int inputMode;
    private final LinkedHashSet<DialogInterface.OnCancelListener> onCancelListeners;
    private final LinkedHashSet<DialogInterface.OnDismissListener> onDismissListeners;
    private final LinkedHashSet<View.OnClickListener> onNegativeButtonClickListeners;
    private final LinkedHashSet<MaterialPickerOnPositiveButtonClickListener<? super S>> onPositiveButtonClickListeners;

    @StyleRes
    private int overrideThemeResId;
    private PickerFragment<S> pickerFragment;
    private CharSequence titleText;

    @StringRes
    private int titleTextResId;

    public static final class Builder<S> {
        CalendarConstraints calendarConstraints;
        final DateSelector<S> dateSelector;
        int inputMode;
        int overrideThemeResId;

        @Nullable
        S selection;
        CharSequence titleText;
        int titleTextResId;

        private Builder(DateSelector<S> r10) {
            this.overrideThemeResId = 0;
            this.titleTextResId = 0;
            this.titleText = null;
            this.selection = null;
            this.inputMode = 0;
            this.dateSelector = r10;
        }

        private Month createDefaultOpenAt() {
            long r10 = this.calendarConstraints.getStart().timeInMillis;
            long r11 = this.calendarConstraints.getEnd().timeInMillis;
            if (this.dateSelector.getSelectedDays().isEmpty() == true) goto L10;
            long r12 = this.dateSelector.getSelectedDays().iterator().next().longValue();
            if (r12 < r10) goto L10;
            if (r12 > r11) goto L10;
            return Month.create(r12);
        L10:
            long r13 = MaterialDatePicker.thisMonthInUtcMilliseconds();
            if (r10 > r13) goto L16;
            if (r13 > r11) goto L16;
            r10 = r13;
        L16:
            return Month.create(r10);
        }

        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static <S> Builder<S> customDatePicker(@NonNull DateSelector<S> r10) {
            return new Builder(r10);
        }

        @NonNull
        public static Builder<Long> datePicker() {
            return new Builder(new SingleDateSelector());
        }

        @NonNull
        public static Builder<c> dateRangePicker() {
            return new Builder(new RangeDateSelector());
        }

        @NonNull
        public MaterialDatePicker<S> build() {
            if (this.calendarConstraints != null) goto L6;
            this.calendarConstraints = new CalendarConstraints.Builder().build();
        L6:
            if (this.titleTextResId != 0) goto L8;
            this.titleTextResId = this.dateSelector.getDefaultTitleResId();
        L8:
            S r10 = this.selection;
            if (r10 == null) goto L12;
            this.dateSelector.setSelection(r10);
        L12:
            if (this.calendarConstraints.getOpenAt() != null) goto L15;
            this.calendarConstraints.setOpenAt(createDefaultOpenAt());
        L15:
            return MaterialDatePicker.newInstance(this);
        }

        @NonNull
        public Builder<S> setCalendarConstraints(CalendarConstraints r10) {
            this.calendarConstraints = r10;
            return this;
        }

        @NonNull
        public Builder<S> setInputMode(int r10) {
            this.inputMode = r10;
            return this;
        }

        @NonNull
        public Builder<S> setSelection(S r10) {
            this.selection = r10;
            return this;
        }

        @NonNull
        public Builder<S> setTheme(@StyleRes int r10) {
            this.overrideThemeResId = r10;
            return this;
        }

        @NonNull
        public Builder<S> setTitleText(@StringRes int r10) {
            this.titleTextResId = r10;
            this.titleText = null;
            return this;
        }

        @NonNull
        public Builder<S> setTitleText(@Nullable CharSequence r10) {
            this.titleText = r10;
            this.titleTextResId = 0;
            return this;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface InputMode {
    }

    static {
        CONFIRM_BUTTON_TAG = "CONFIRM_BUTTON_TAG";
        CANCEL_BUTTON_TAG = "CANCEL_BUTTON_TAG";
        TOGGLE_BUTTON_TAG = "TOGGLE_BUTTON_TAG";
    }

    public MaterialDatePicker() {
        this.onPositiveButtonClickListeners = new LinkedHashSet();
        this.onNegativeButtonClickListeners = new LinkedHashSet();
        this.onCancelListeners = new LinkedHashSet();
        this.onDismissListeners = new LinkedHashSet();
    }

    public static /* synthetic */ LinkedHashSet access$000(MaterialDatePicker r10) {
        return r10.onPositiveButtonClickListeners;
    }

    public static /* synthetic */ LinkedHashSet access$100(MaterialDatePicker r10) {
        return r10.onNegativeButtonClickListeners;
    }

    public static /* synthetic */ void access$200(MaterialDatePicker r10) {
        r10.updateHeader();
    }

    public static /* synthetic */ DateSelector access$300(MaterialDatePicker r10) {
        return r10.dateSelector;
    }

    public static /* synthetic */ Button access$400(MaterialDatePicker r10) {
        return r10.confirmButton;
    }

    public static /* synthetic */ CheckableImageButton access$500(MaterialDatePicker r10) {
        return r10.headerToggleButton;
    }

    public static /* synthetic */ void access$600(MaterialDatePicker r10, CheckableImageButton r11) {
        r10.updateToggleContentDescription(r11);
    }

    public static /* synthetic */ void access$700(MaterialDatePicker r10) {
        r10.startPickerFragment();
    }

    @NonNull
    private static Drawable createHeaderToggleDrawable(Context r10) {
        StateListDrawable r11 = new StateListDrawable();
        r11.addState(new int[]{R.attr.state_checked}, a.b(r10, com.google.android.material.R.drawable.material_ic_calendar_black_24dp));
        r11.addState(new int[0], a.b(r10, com.google.android.material.R.drawable.material_ic_edit_black_24dp));
        return r11;
    }

    private static int getDialogPickerHeight(@NonNull Context r10) {
        Resources r11 = r10.getResources();
        int r12 = (r11.getDimensionPixelSize(com.google.android.material.R.dimen.mtrl_calendar_navigation_height) + r11.getDimensionPixelOffset(com.google.android.material.R.dimen.mtrl_calendar_navigation_top_padding)) + r11.getDimensionPixelOffset(com.google.android.material.R.dimen.mtrl_calendar_navigation_bottom_padding);
        int r13 = r11.getDimensionPixelSize(com.google.android.material.R.dimen.mtrl_calendar_days_of_week_height);
        int r14 = MonthAdapter.MAXIMUM_WEEKS;
        return ((r12 + r13) + ((r11.getDimensionPixelSize(com.google.android.material.R.dimen.mtrl_calendar_day_height) * r14) + ((r14 - 1) * r11.getDimensionPixelOffset(com.google.android.material.R.dimen.mtrl_calendar_month_vertical_padding)))) + r11.getDimensionPixelOffset(com.google.android.material.R.dimen.mtrl_calendar_bottom_padding);
    }

    private static int getPaddedPickerWidth(@NonNull Context r10) {
        Resources r11 = r10.getResources();
        int r12 = r11.getDimensionPixelOffset(com.google.android.material.R.dimen.mtrl_calendar_content_padding);
        int r13 = Month.current().daysInWeek;
        return ((r12 * 2) + (r11.getDimensionPixelSize(com.google.android.material.R.dimen.mtrl_calendar_day_width) * r13)) + ((r13 - 1) * r11.getDimensionPixelOffset(com.google.android.material.R.dimen.mtrl_calendar_month_horizontal_padding));
    }

    private int getThemeResId(Context r10) {
        int r11 = this.overrideThemeResId;
        if (r11 == 0) goto L6;
        return r11;
    L6:
        return this.dateSelector.getDefaultThemeResId(r10);
    }

    private void initHeaderToggle(Context r10) {
        this.headerToggleButton.setTag(TOGGLE_BUTTON_TAG);
        this.headerToggleButton.setImageDrawable(createHeaderToggleDrawable(r10));
        CheckableImageButton r11 = this.headerToggleButton;
        if (this.inputMode == 0) goto L5;
        boolean r12 = true;
    L6:
        r11.setChecked(r12);
        ViewCompat.p0(this.headerToggleButton, null);
        updateToggleContentDescription(this.headerToggleButton);
        this.headerToggleButton.setOnClickListener(new AnonymousClass4(this));
        return;
    L5:
        r12 = false;
        goto L6
    }

    public static boolean isFullscreen(@NonNull Context r10) {
        return readMaterialCalendarStyleBoolean(r10, R.attr.windowFullscreen);
    }

    public static boolean isNestedScrollable(@NonNull Context r10) {
        return readMaterialCalendarStyleBoolean(r10, com.google.android.material.R.attr.nestedScrollable);
    }

    @NonNull
    public static <S> MaterialDatePicker<S> newInstance(@NonNull Builder<S> r10) {
        MaterialDatePicker<S> r11 = new MaterialDatePicker();
        Bundle r12 = new Bundle();
        r12.putInt(OVERRIDE_THEME_RES_ID, r10.overrideThemeResId);
        r12.putParcelable(DATE_SELECTOR_KEY, r10.dateSelector);
        r12.putParcelable(CALENDAR_CONSTRAINTS_KEY, r10.calendarConstraints);
        r12.putInt(TITLE_TEXT_RES_ID_KEY, r10.titleTextResId);
        r12.putCharSequence(TITLE_TEXT_KEY, r10.titleText);
        r12.putInt(INPUT_MODE_KEY, r10.inputMode);
        r11.setArguments(r12);
        return r11;
    }

    public static boolean readMaterialCalendarStyleBoolean(@NonNull Context r10, int r11) {
        TypedArray r12 = r10.obtainStyledAttributes(MaterialAttributes.resolveOrThrow(r10, com.google.android.material.R.attr.materialCalendarStyle, MaterialCalendar.class.getCanonicalName()), new int[]{r11});
        boolean r13 = r12.getBoolean(0, false);
        r12.recycle();
        return r13;
    }

    private void startPickerFragment() {
        int r10 = getThemeResId(requireContext());
        this.calendar = MaterialCalendar.newInstance(this.dateSelector, r10, this.calendarConstraints);
        if (this.headerToggleButton.isChecked() == false) goto L5;
        PickerFragment<S> r11 = MaterialTextInputPicker.newInstance(this.dateSelector, r10, this.calendarConstraints);
    L6:
        this.pickerFragment = r11;
        updateHeader();
        FragmentTransaction r12 = getChildFragmentManager().o();
        r12.u(com.google.android.material.R.id.mtrl_calendar_frame, this.pickerFragment);
        r12.l();
        this.pickerFragment.addOnSelectionChangedListener(new AnonymousClass3(this));
        return;
    L5:
        r11 = this.calendar;
        goto L6
    }

    public static long thisMonthInUtcMilliseconds() {
        return Month.current().timeInMillis;
    }

    public static long todayInUtcMilliseconds() {
        return UtcDates.getTodayCalendar().getTimeInMillis();
    }

    private void updateHeader() {
        String r10 = getHeaderText();
        this.headerSelectionText.setContentDescription(String.format(getString(com.google.android.material.R.string.mtrl_picker_announce_current_selection), new Object[]{r10}));
        this.headerSelectionText.setText(r10);
    }

    private void updateToggleContentDescription(@NonNull CheckableImageButton r10) {
        if (this.headerToggleButton.isChecked() == false) goto L5;
        String r11 = r10.getContext().getString(com.google.android.material.R.string.mtrl_picker_toggle_to_calendar_input_mode);
    L6:
        this.headerToggleButton.setContentDescription(r11);
        return;
    L5:
        r11 = r10.getContext().getString(com.google.android.material.R.string.mtrl_picker_toggle_to_text_input_mode);
        goto L6
    }

    public boolean addOnCancelListener(DialogInterface.OnCancelListener r10) {
        return this.onCancelListeners.add(r10);
    }

    public boolean addOnDismissListener(DialogInterface.OnDismissListener r10) {
        return this.onDismissListeners.add(r10);
    }

    public boolean addOnNegativeButtonClickListener(View.OnClickListener r10) {
        return this.onNegativeButtonClickListeners.add(r10);
    }

    public boolean addOnPositiveButtonClickListener(MaterialPickerOnPositiveButtonClickListener<? super S> r10) {
        return this.onPositiveButtonClickListeners.add(r10);
    }

    public void clearOnCancelListeners() {
        this.onCancelListeners.clear();
    }

    public void clearOnDismissListeners() {
        this.onDismissListeners.clear();
    }

    public void clearOnNegativeButtonClickListeners() {
        this.onNegativeButtonClickListeners.clear();
    }

    public void clearOnPositiveButtonClickListeners() {
        this.onPositiveButtonClickListeners.clear();
    }

    public String getHeaderText() {
        return this.dateSelector.getSelectionDisplayString(getContext());
    }

    @Nullable
    public final S getSelection() {
        return this.dateSelector.getSelection();
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public final void onCancel(@NonNull DialogInterface r10) {
        Iterator<DialogInterface.OnCancelListener> r11 = this.onCancelListeners.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r11.next().onCancel(r10);
        goto L4
    L6:
        super.onCancel(r10);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(@Nullable Bundle r10) {
        super.onCreate(r10);
        if (r10 != null) goto L5;
        r10 = getArguments();
    L5:
        this.overrideThemeResId = r10.getInt(OVERRIDE_THEME_RES_ID);
        this.dateSelector = (DateSelector) r10.getParcelable(DATE_SELECTOR_KEY);
        this.calendarConstraints = (CalendarConstraints) r10.getParcelable(CALENDAR_CONSTRAINTS_KEY);
        this.titleTextResId = r10.getInt(TITLE_TEXT_RES_ID_KEY);
        this.titleText = r10.getCharSequence(TITLE_TEXT_KEY);
        this.inputMode = r10.getInt(INPUT_MODE_KEY);
    }

    @Override // androidx.fragment.app.DialogFragment
    @NonNull
    public final Dialog onCreateDialog(@Nullable Bundle r10) {
        Dialog r11 = new Dialog(requireContext(), getThemeResId(requireContext()));
        Context r12 = r11.getContext();
        this.fullscreen = isFullscreen(r12);
        int r13 = MaterialAttributes.resolveOrThrow(r12, com.google.android.material.R.attr.colorSurface, MaterialDatePicker.class.getCanonicalName());
        MaterialShapeDrawable r14 = new MaterialShapeDrawable(r12, null, com.google.android.material.R.attr.materialCalendarStyle, com.google.android.material.R.style.Widget_MaterialComponents_MaterialCalendar);
        this.background = r14;
        r14.initializeElevationOverlay(r12);
        this.background.setFillColor(ColorStateList.valueOf(r13));
        this.background.setElevation(ViewCompat.v(r11.getWindow().getDecorView()));
        return r11;
    }

    @Override // androidx.fragment.app.Fragment
    @NonNull
    public final View onCreateView(@NonNull LayoutInflater r10, @Nullable ViewGroup r11, @Nullable Bundle r12) {
        if (this.fullscreen == false) goto L5;
        int r13 = com.google.android.material.R.layout.mtrl_picker_fullscreen;
    L6:
        View r14 = r10.inflate(r13, r11);
        Context r15 = r14.getContext();
        if (this.fullscreen == false) goto L9;
        r14.findViewById(com.google.android.material.R.id.mtrl_calendar_frame).setLayoutParams(new LinearLayout.LayoutParams(getPaddedPickerWidth(r15), -2));
    L10:
        TextView r16 = (TextView) r14.findViewById(com.google.android.material.R.id.mtrl_picker_header_selection_text);
        this.headerSelectionText = r16;
        ViewCompat.r0(r16, 1);
        this.headerToggleButton = (CheckableImageButton) r14.findViewById(com.google.android.material.R.id.mtrl_picker_header_toggle);
        TextView r17 = (TextView) r14.findViewById(com.google.android.material.R.id.mtrl_picker_title_text);
        CharSequence r18 = this.titleText;
        if (r18 == null) goto L13;
        r17.setText(r18);
    L14:
        initHeaderToggle(r15);
        this.confirmButton = (Button) r14.findViewById(com.google.android.material.R.id.confirm_button);
        if (this.dateSelector.isSelectionComplete() == false) goto L17;
        this.confirmButton.setEnabled(true);
    L18:
        this.confirmButton.setTag(CONFIRM_BUTTON_TAG);
        this.confirmButton.setOnClickListener(new AnonymousClass1(this));
        Button r19 = (Button) r14.findViewById(com.google.android.material.R.id.cancel_button);
        r19.setTag(CANCEL_BUTTON_TAG);
        r19.setOnClickListener(new AnonymousClass2(this));
        return r14;
    L17:
        this.confirmButton.setEnabled(false);
        goto L18
    L13:
        r17.setText(this.titleTextResId);
        goto L14
    L9:
        View r20 = r14.findViewById(com.google.android.material.R.id.mtrl_calendar_main_pane);
        View r21 = r14.findViewById(com.google.android.material.R.id.mtrl_calendar_frame);
        r20.setLayoutParams(new LinearLayout.LayoutParams(getPaddedPickerWidth(r15), -1));
        r21.setMinimumHeight(getDialogPickerHeight(requireContext()));
        goto L10
    L5:
        r13 = com.google.android.material.R.layout.mtrl_picker_dialog;
        goto L6
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(@NonNull DialogInterface r10) {
        Iterator<DialogInterface.OnDismissListener> r11 = this.onDismissListeners.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r11.next().onDismiss(r10);
        goto L4
    L6:
        ViewGroup r12 = (ViewGroup) getView();
        if (r12 == null) goto L9;
        r12.removeAllViews();
    L9:
        super.onDismiss(r10);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onSaveInstanceState(@NonNull Bundle r10) {
        super.onSaveInstanceState(r10);
        r10.putInt(OVERRIDE_THEME_RES_ID, this.overrideThemeResId);
        r10.putParcelable(DATE_SELECTOR_KEY, this.dateSelector);
        CalendarConstraints.Builder r11 = new CalendarConstraints.Builder(this.calendarConstraints);
        if (this.calendar.getCurrentMonth() == null) goto L5;
        r11.setOpenAt(this.calendar.getCurrentMonth().timeInMillis);
    L5:
        r10.putParcelable(CALENDAR_CONSTRAINTS_KEY, r11.build());
        r10.putInt(TITLE_TEXT_RES_ID_KEY, this.titleTextResId);
        r10.putCharSequence(TITLE_TEXT_KEY, this.titleText);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Window r10 = requireDialog().getWindow();
        if (this.fullscreen == false) goto L5;
        r10.setLayout(-1, -1);
        r10.setBackgroundDrawable(this.background);
    L6:
        startPickerFragment();
        return;
    L5:
        r10.setLayout(-2, -2);
        int r11 = getResources().getDimensionPixelOffset(com.google.android.material.R.dimen.mtrl_calendar_dialog_background_inset);
        Rect r12 = new Rect(r11, r11, r11, r11);
        r10.setBackgroundDrawable(new InsetDrawable(this.background, r11, r11, r11, r11));
        r10.getDecorView().setOnTouchListener(new InsetDialogOnTouchListener(requireDialog(), r12));
        goto L6
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStop() {
        this.pickerFragment.clearOnSelectionChangedListeners();
        super.onStop();
    }

    public boolean removeOnCancelListener(DialogInterface.OnCancelListener r10) {
        return this.onCancelListeners.remove(r10);
    }

    public boolean removeOnDismissListener(DialogInterface.OnDismissListener r10) {
        return this.onDismissListeners.remove(r10);
    }

    public boolean removeOnNegativeButtonClickListener(View.OnClickListener r10) {
        return this.onNegativeButtonClickListeners.remove(r10);
    }

    public boolean removeOnPositiveButtonClickListener(MaterialPickerOnPositiveButtonClickListener<? super S> r10) {
        return this.onPositiveButtonClickListeners.remove(r10);
    }
}
