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
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsetsController;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.datastore.preferences.protobuf.b1;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.internal.CheckableImageButton;
import com.stepos.core.ability.speech.PcmDumpBudget;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.WeakHashMap;
import v0.e0;
import v0.h0;
import v0.k0;
import v0.m0;
import v0.n0;
import v0.o0;
import v0.w;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class MaterialDatePicker<S> extends DialogFragment {
    private static final String CALENDAR_CONSTRAINTS_KEY = "CALENDAR_CONSTRAINTS_KEY";
    private static final String DATE_SELECTOR_KEY = "DATE_SELECTOR_KEY";
    private static final String DAY_VIEW_DECORATOR_KEY = "DAY_VIEW_DECORATOR_KEY";
    public static final int INPUT_MODE_CALENDAR = 0;
    private static final String INPUT_MODE_KEY = "INPUT_MODE_KEY";
    public static final int INPUT_MODE_TEXT = 1;
    private static final String NEGATIVE_BUTTON_CONTENT_DESCRIPTION_KEY = "NEGATIVE_BUTTON_CONTENT_DESCRIPTION_KEY";
    private static final String NEGATIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY = "NEGATIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY";
    private static final String NEGATIVE_BUTTON_TEXT_KEY = "NEGATIVE_BUTTON_TEXT_KEY";
    private static final String NEGATIVE_BUTTON_TEXT_RES_ID_KEY = "NEGATIVE_BUTTON_TEXT_RES_ID_KEY";
    private static final String OVERRIDE_THEME_RES_ID = "OVERRIDE_THEME_RES_ID";
    private static final String POSITIVE_BUTTON_CONTENT_DESCRIPTION_KEY = "POSITIVE_BUTTON_CONTENT_DESCRIPTION_KEY";
    private static final String POSITIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY = "POSITIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY";
    private static final String POSITIVE_BUTTON_TEXT_KEY = "POSITIVE_BUTTON_TEXT_KEY";
    private static final String POSITIVE_BUTTON_TEXT_RES_ID_KEY = "POSITIVE_BUTTON_TEXT_RES_ID_KEY";
    private static final String TITLE_TEXT_KEY = "TITLE_TEXT_KEY";
    private static final String TITLE_TEXT_RES_ID_KEY = "TITLE_TEXT_RES_ID_KEY";
    private y4.g background;
    private MaterialCalendar<S> calendar;
    private CalendarConstraints calendarConstraints;
    private Button confirmButton;
    private DateSelector<S> dateSelector;
    private DayViewDecorator dayViewDecorator;
    private boolean edgeToEdgeEnabled;
    private CharSequence fullTitleText;
    private boolean fullscreen;
    private TextView headerSelectionText;
    private TextView headerTitleTextView;
    private CheckableImageButton headerToggleButton;
    private int inputMode;
    private CharSequence negativeButtonContentDescription;
    private int negativeButtonContentDescriptionResId;
    private CharSequence negativeButtonText;
    private int negativeButtonTextResId;
    private int overrideThemeResId;
    private PickerFragment<S> pickerFragment;
    private CharSequence positiveButtonContentDescription;
    private int positiveButtonContentDescriptionResId;
    private CharSequence positiveButtonText;
    private int positiveButtonTextResId;
    private CharSequence singleLineTitleText;
    private CharSequence titleText;
    private int titleTextResId;
    static final Object CONFIRM_BUTTON_TAG = "CONFIRM_BUTTON_TAG";
    static final Object CANCEL_BUTTON_TAG = "CANCEL_BUTTON_TAG";
    static final Object TOGGLE_BUTTON_TAG = "TOGGLE_BUTTON_TAG";
    private final LinkedHashSet<l<? super S>> onPositiveButtonClickListeners = new LinkedHashSet<>();
    private final LinkedHashSet<View.OnClickListener> onNegativeButtonClickListeners = new LinkedHashSet<>();
    private final LinkedHashSet<DialogInterface.OnCancelListener> onCancelListeners = new LinkedHashSet<>();
    private final LinkedHashSet<DialogInterface.OnDismissListener> onDismissListeners = new LinkedHashSet<>();

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a implements v0.r {

        /* renamed from: g, reason: collision with root package name */
        public final /* synthetic */ int f4922g;
        public final /* synthetic */ View h;

        /* renamed from: i, reason: collision with root package name */
        public final /* synthetic */ int f4923i;

        /* renamed from: j, reason: collision with root package name */
        public final /* synthetic */ int f4924j;

        /* renamed from: k, reason: collision with root package name */
        public final /* synthetic */ int f4925k;

        public a(View view, int i10, int i11, int i12, int i13) {
            this.f4922g = i10;
            this.h = view;
            this.f4923i = i11;
            this.f4924j = i12;
            this.f4925k = i13;
        }

        @Override // v0.r
        public final m0 g(View view, m0 m0Var) {
            n0.b bVarG = m0Var.f13309a.g(519);
            View view2 = this.h;
            int i10 = this.f4922g;
            if (i10 >= 0) {
                view2.getLayoutParams().height = i10 + bVarG.f10589b;
                view2.setLayoutParams(view2.getLayoutParams());
            }
            view2.setPadding(this.f4923i + bVarG.f10588a, this.f4924j + bVarG.f10589b, this.f4925k + bVarG.f10590c, view2.getPaddingBottom());
            return m0Var;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class b extends p<S> {
        public b() {
        }

        @Override // com.google.android.material.datepicker.p
        public final void a() {
            MaterialDatePicker.this.confirmButton.setEnabled(false);
        }

        @Override // com.google.android.material.datepicker.p
        public final void b(S s8) {
            MaterialDatePicker materialDatePicker = MaterialDatePicker.this;
            materialDatePicker.updateHeader(materialDatePicker.getHeaderText());
            materialDatePicker.confirmButton.setEnabled(materialDatePicker.getDateSelector().isSelectionComplete());
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class c<S> {
    }

    private static Drawable createHeaderToggleDrawable(Context context) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_checked}, b1.L(com.stepos.aiengine.R.drawable.material_ic_calendar_black_24dp, context));
        stateListDrawable.addState(new int[0], b1.L(com.stepos.aiengine.R.drawable.material_ic_edit_black_24dp, context));
        return stateListDrawable;
    }

    private void enableEdgeToEdgeIfNeeded(Window window) {
        if (this.edgeToEdgeEnabled) {
            return;
        }
        View viewFindViewById = requireView().findViewById(com.stepos.aiengine.R.id.fullscreen_header);
        ColorStateList colorStateListA = r4.a.a(viewFindViewById.getBackground());
        Integer numValueOf = colorStateListA != null ? Integer.valueOf(colorStateListA.getDefaultColor()) : null;
        boolean z = numValueOf == null || numValueOf.intValue() == 0;
        Integer numT = jd.b.t(R.attr.colorBackground, window.getContext());
        int iIntValue = numT != null ? numT.intValue() : -16777216;
        if (z) {
            numValueOf = Integer.valueOf(iIntValue);
        }
        k0.a(window, false);
        window.getContext();
        window.getContext();
        window.setStatusBarColor(0);
        window.setNavigationBarColor(0);
        boolean z3 = jd.b.z(0) || jd.b.z(numValueOf.intValue());
        w wVar = new w(window.getDecorView());
        n0 o0Var = Build.VERSION.SDK_INT >= 35 ? new o0(window, wVar) : new n0(window, wVar);
        WindowInsetsController windowInsetsController = o0Var.f13330a;
        Window window2 = o0Var.f13331b;
        if (z3) {
            if (window2 != null) {
                View decorView = window2.getDecorView();
                decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | PcmDumpBudget.HARD_MAX_DIR_MB);
            }
            windowInsetsController.setSystemBarsAppearance(8, 8);
        } else {
            if (window2 != null) {
                View decorView2 = window2.getDecorView();
                decorView2.setSystemUiVisibility(decorView2.getSystemUiVisibility() & (-8193));
            }
            windowInsetsController.setSystemBarsAppearance(0, 8);
        }
        boolean z10 = jd.b.z(0) || jd.b.z(iIntValue);
        w wVar2 = new w(window.getDecorView());
        n0 o0Var2 = Build.VERSION.SDK_INT >= 35 ? new o0(window, wVar2) : new n0(window, wVar2);
        WindowInsetsController windowInsetsController2 = o0Var2.f13330a;
        Window window3 = o0Var2.f13331b;
        if (z10) {
            if (window3 != null) {
                View decorView3 = window3.getDecorView();
                decorView3.setSystemUiVisibility(decorView3.getSystemUiVisibility() | 16);
            }
            windowInsetsController2.setSystemBarsAppearance(16, 16);
        } else {
            if (window3 != null) {
                View decorView4 = window3.getDecorView();
                decorView4.setSystemUiVisibility(decorView4.getSystemUiVisibility() & (-17));
            }
            windowInsetsController2.setSystemBarsAppearance(0, 16);
        }
        a aVar = new a(viewFindViewById, viewFindViewById.getLayoutParams().height, viewFindViewById.getPaddingLeft(), viewFindViewById.getPaddingTop(), viewFindViewById.getPaddingRight());
        WeakHashMap<View, h0> weakHashMap = e0.f13274a;
        e0.d.k(viewFindViewById, aVar);
        this.edgeToEdgeEnabled = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DateSelector<S> getDateSelector() {
        if (this.dateSelector == null) {
            this.dateSelector = (DateSelector) getArguments().getParcelable(DATE_SELECTOR_KEY);
        }
        return this.dateSelector;
    }

    private static CharSequence getFirstLineBySeparator(CharSequence charSequence) {
        if (charSequence == null) {
            return null;
        }
        String[] strArrSplit = TextUtils.split(String.valueOf(charSequence), "\n");
        return strArrSplit.length > 1 ? strArrSplit[0] : charSequence;
    }

    private String getHeaderContentDescription() {
        return getDateSelector().getSelectionContentDescription(requireContext());
    }

    private static int getPaddedPickerWidth(Context context) throws Resources.NotFoundException {
        Resources resources = context.getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(com.stepos.aiengine.R.dimen.mtrl_calendar_content_padding);
        int i10 = Month.current().daysInWeek;
        return ((i10 - 1) * resources.getDimensionPixelOffset(com.stepos.aiengine.R.dimen.mtrl_calendar_month_horizontal_padding)) + (resources.getDimensionPixelSize(com.stepos.aiengine.R.dimen.mtrl_calendar_day_width) * i10) + (dimensionPixelOffset * 2);
    }

    private int getThemeResId(Context context) {
        int i10 = this.overrideThemeResId;
        return i10 != 0 ? i10 : getDateSelector().getDefaultThemeResId(context);
    }

    private void initHeaderToggle(Context context) {
        this.headerToggleButton.setTag(TOGGLE_BUTTON_TAG);
        this.headerToggleButton.setImageDrawable(createHeaderToggleDrawable(context));
        this.headerToggleButton.setChecked(this.inputMode != 0);
        e0.j(this.headerToggleButton, null);
        updateToggleContentDescription(this.headerToggleButton);
        this.headerToggleButton.setOnClickListener(new j(this, 0));
    }

    public static boolean isFullscreen(Context context) {
        return readMaterialCalendarStyleBoolean(context, R.attr.windowFullscreen);
    }

    private boolean isLandscape() {
        return getResources().getConfiguration().orientation == 2;
    }

    public static boolean isNestedScrollable(Context context) {
        return readMaterialCalendarStyleBoolean(context, com.stepos.aiengine.R.attr.nestedScrollable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initHeaderToggle$0(View view) {
        this.confirmButton.setEnabled(getDateSelector().isSelectionComplete());
        this.headerToggleButton.toggle();
        this.inputMode = this.inputMode == 1 ? 0 : 1;
        updateToggleContentDescription(this.headerToggleButton);
        startPickerFragment();
    }

    public static <S> MaterialDatePicker<S> newInstance(c<S> cVar) {
        new MaterialDatePicker();
        new Bundle();
        throw null;
    }

    public static boolean readMaterialCalendarStyleBoolean(Context context, int i10) throws Resources.NotFoundException {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(w4.b.c(context, MaterialCalendar.class.getCanonicalName(), com.stepos.aiengine.R.attr.materialCalendarStyle).data, new int[]{i10});
        boolean z = typedArrayObtainStyledAttributes.getBoolean(0, false);
        typedArrayObtainStyledAttributes.recycle();
        return z;
    }

    private void startPickerFragment() {
        int themeResId = getThemeResId(requireContext());
        MaterialTextInputPicker materialTextInputPickerNewInstance = MaterialCalendar.newInstance(getDateSelector(), themeResId, this.calendarConstraints, this.dayViewDecorator);
        this.calendar = materialTextInputPickerNewInstance;
        if (this.inputMode == 1) {
            materialTextInputPickerNewInstance = MaterialTextInputPicker.newInstance(getDateSelector(), themeResId, this.calendarConstraints);
        }
        this.pickerFragment = materialTextInputPickerNewInstance;
        updateTitle();
        updateHeader(getHeaderText());
        FragmentManager childFragmentManager = getChildFragmentManager();
        childFragmentManager.getClass();
        androidx.fragment.app.a aVar = new androidx.fragment.app.a(childFragmentManager);
        aVar.e(this.pickerFragment, com.stepos.aiengine.R.id.mtrl_calendar_frame);
        if (aVar.f2101g) {
            throw new IllegalStateException("This transaction is already being added to the back stack");
        }
        aVar.h = false;
        aVar.f2075q.y(aVar, false);
        this.pickerFragment.addOnSelectionChangedListener(new b());
    }

    public static long thisMonthInUtcMilliseconds() {
        return Month.current().timeInMillis;
    }

    public static long todayInUtcMilliseconds() {
        return s.f().getTimeInMillis();
    }

    private void updateTitle() {
        this.headerTitleTextView.setText((this.inputMode == 1 && isLandscape()) ? this.singleLineTitleText : this.fullTitleText);
    }

    private void updateToggleContentDescription(CheckableImageButton checkableImageButton) {
        this.headerToggleButton.setContentDescription(this.inputMode == 1 ? checkableImageButton.getContext().getString(com.stepos.aiengine.R.string.mtrl_picker_toggle_to_calendar_input_mode) : checkableImageButton.getContext().getString(com.stepos.aiengine.R.string.mtrl_picker_toggle_to_text_input_mode));
    }

    public boolean addOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
        return this.onCancelListeners.add(onCancelListener);
    }

    public boolean addOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        return this.onDismissListeners.add(onDismissListener);
    }

    public boolean addOnNegativeButtonClickListener(View.OnClickListener onClickListener) {
        return this.onNegativeButtonClickListeners.add(onClickListener);
    }

    public boolean addOnPositiveButtonClickListener(l<? super S> lVar) {
        return this.onPositiveButtonClickListeners.add(lVar);
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
        return getDateSelector().getSelectionDisplayString(getContext());
    }

    public int getInputMode() {
        return this.inputMode;
    }

    public final S getSelection() {
        return getDateSelector().getSelection();
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        Iterator<DialogInterface.OnCancelListener> it = this.onCancelListeners.iterator();
        while (it.hasNext()) {
            it.next().onCancel(dialogInterface);
        }
        super.onCancel(dialogInterface);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) throws Resources.NotFoundException {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.overrideThemeResId = bundle.getInt(OVERRIDE_THEME_RES_ID);
        this.dateSelector = (DateSelector) bundle.getParcelable(DATE_SELECTOR_KEY);
        this.calendarConstraints = (CalendarConstraints) bundle.getParcelable(CALENDAR_CONSTRAINTS_KEY);
        this.dayViewDecorator = (DayViewDecorator) bundle.getParcelable(DAY_VIEW_DECORATOR_KEY);
        this.titleTextResId = bundle.getInt(TITLE_TEXT_RES_ID_KEY);
        this.titleText = bundle.getCharSequence(TITLE_TEXT_KEY);
        this.inputMode = bundle.getInt(INPUT_MODE_KEY);
        this.positiveButtonTextResId = bundle.getInt(POSITIVE_BUTTON_TEXT_RES_ID_KEY);
        this.positiveButtonText = bundle.getCharSequence(POSITIVE_BUTTON_TEXT_KEY);
        this.positiveButtonContentDescriptionResId = bundle.getInt(POSITIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY);
        this.positiveButtonContentDescription = bundle.getCharSequence(POSITIVE_BUTTON_CONTENT_DESCRIPTION_KEY);
        this.negativeButtonTextResId = bundle.getInt(NEGATIVE_BUTTON_TEXT_RES_ID_KEY);
        this.negativeButtonText = bundle.getCharSequence(NEGATIVE_BUTTON_TEXT_KEY);
        this.negativeButtonContentDescriptionResId = bundle.getInt(NEGATIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY);
        this.negativeButtonContentDescription = bundle.getCharSequence(NEGATIVE_BUTTON_CONTENT_DESCRIPTION_KEY);
        CharSequence text = this.titleText;
        if (text == null) {
            text = requireContext().getResources().getText(this.titleTextResId);
        }
        this.fullTitleText = text;
        this.singleLineTitleText = getFirstLineBySeparator(text);
    }

    @Override // androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle bundle) {
        Dialog dialog = new Dialog(requireContext(), getThemeResId(requireContext()));
        Context context = dialog.getContext();
        this.fullscreen = isFullscreen(context);
        this.background = new y4.g(context, null, com.stepos.aiengine.R.attr.materialCalendarStyle, com.stepos.aiengine.R.style.Widget_MaterialComponents_MaterialCalendar);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, k4.a.f9912q, com.stepos.aiengine.R.attr.materialCalendarStyle, com.stepos.aiengine.R.style.Widget_MaterialComponents_MaterialCalendar);
        int color = typedArrayObtainStyledAttributes.getColor(1, 0);
        typedArrayObtainStyledAttributes.recycle();
        this.background.k(context);
        this.background.n(ColorStateList.valueOf(color));
        this.background.m(dialog.getWindow().getDecorView().getElevation());
        return dialog;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(this.fullscreen ? com.stepos.aiengine.R.layout.mtrl_picker_fullscreen : com.stepos.aiengine.R.layout.mtrl_picker_dialog, viewGroup);
        Context context = viewInflate.getContext();
        DayViewDecorator dayViewDecorator = this.dayViewDecorator;
        if (dayViewDecorator != null) {
            dayViewDecorator.initialize(context);
        }
        if (this.fullscreen) {
            viewInflate.findViewById(com.stepos.aiengine.R.id.mtrl_calendar_frame).setLayoutParams(new LinearLayout.LayoutParams(getPaddedPickerWidth(context), -2));
        } else {
            viewInflate.findViewById(com.stepos.aiengine.R.id.mtrl_calendar_main_pane).setLayoutParams(new LinearLayout.LayoutParams(getPaddedPickerWidth(context), -1));
        }
        TextView textView = (TextView) viewInflate.findViewById(com.stepos.aiengine.R.id.mtrl_picker_header_selection_text);
        this.headerSelectionText = textView;
        textView.setAccessibilityLiveRegion(1);
        this.headerToggleButton = (CheckableImageButton) viewInflate.findViewById(com.stepos.aiengine.R.id.mtrl_picker_header_toggle);
        this.headerTitleTextView = (TextView) viewInflate.findViewById(com.stepos.aiengine.R.id.mtrl_picker_title_text);
        initHeaderToggle(context);
        this.confirmButton = (Button) viewInflate.findViewById(com.stepos.aiengine.R.id.confirm_button);
        if (getDateSelector().isSelectionComplete()) {
            this.confirmButton.setEnabled(true);
        } else {
            this.confirmButton.setEnabled(false);
        }
        this.confirmButton.setTag(CONFIRM_BUTTON_TAG);
        CharSequence charSequence = this.positiveButtonText;
        if (charSequence != null) {
            this.confirmButton.setText(charSequence);
        } else {
            int i10 = this.positiveButtonTextResId;
            if (i10 != 0) {
                this.confirmButton.setText(i10);
            }
        }
        CharSequence charSequence2 = this.positiveButtonContentDescription;
        if (charSequence2 != null) {
            this.confirmButton.setContentDescription(charSequence2);
        } else if (this.positiveButtonContentDescriptionResId != 0) {
            this.confirmButton.setContentDescription(getContext().getResources().getText(this.positiveButtonContentDescriptionResId));
        }
        this.confirmButton.setOnClickListener(new k(this, 0));
        Button button = (Button) viewInflate.findViewById(com.stepos.aiengine.R.id.cancel_button);
        button.setTag(CANCEL_BUTTON_TAG);
        CharSequence charSequence3 = this.negativeButtonText;
        if (charSequence3 != null) {
            button.setText(charSequence3);
        } else {
            int i11 = this.negativeButtonTextResId;
            if (i11 != 0) {
                button.setText(i11);
            }
        }
        CharSequence charSequence4 = this.negativeButtonContentDescription;
        if (charSequence4 != null) {
            button.setContentDescription(charSequence4);
        } else if (this.negativeButtonContentDescriptionResId != 0) {
            button.setContentDescription(getContext().getResources().getText(this.negativeButtonContentDescriptionResId));
        }
        button.setOnClickListener(new j(this, 1));
        return viewInflate;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        Iterator<DialogInterface.OnDismissListener> it = this.onDismissListeners.iterator();
        while (it.hasNext()) {
            it.next().onDismiss(dialogInterface);
        }
        ViewGroup viewGroup = (ViewGroup) getView();
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        super.onDismiss(dialogInterface);
    }

    public void onNegativeButtonClick(View view) {
        Iterator<View.OnClickListener> it = this.onNegativeButtonClickListeners.iterator();
        while (it.hasNext()) {
            it.next().onClick(view);
        }
        dismiss();
    }

    public void onPositiveButtonClick(View view) {
        Iterator<l<? super S>> it = this.onPositiveButtonClickListeners.iterator();
        while (it.hasNext()) {
            l<? super S> next = it.next();
            getSelection();
            next.a();
        }
        dismiss();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt(OVERRIDE_THEME_RES_ID, this.overrideThemeResId);
        bundle.putParcelable(DATE_SELECTOR_KEY, this.dateSelector);
        CalendarConstraints calendarConstraints = this.calendarConstraints;
        CalendarConstraints.b bVar = new CalendarConstraints.b();
        int i10 = CalendarConstraints.b.f4898c;
        int i11 = CalendarConstraints.b.f4898c;
        bVar.f4900b = DateValidatorPointForward.from(Long.MIN_VALUE);
        long j10 = calendarConstraints.start.timeInMillis;
        long j11 = calendarConstraints.end.timeInMillis;
        bVar.f4899a = Long.valueOf(calendarConstraints.openAt.timeInMillis);
        int i12 = calendarConstraints.firstDayOfWeek;
        CalendarConstraints.DateValidator dateValidator = calendarConstraints.validator;
        bVar.f4900b = dateValidator;
        MaterialCalendar<S> materialCalendar = this.calendar;
        Month currentMonth = materialCalendar == null ? null : materialCalendar.getCurrentMonth();
        if (currentMonth != null) {
            bVar.f4899a = Long.valueOf(currentMonth.timeInMillis);
        }
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable("DEEP_COPY_VALIDATOR_KEY", dateValidator);
        Month monthCreate = Month.create(j10);
        Month monthCreate2 = Month.create(j11);
        CalendarConstraints.DateValidator dateValidator2 = (CalendarConstraints.DateValidator) bundle2.getParcelable("DEEP_COPY_VALIDATOR_KEY");
        Long l10 = bVar.f4899a;
        bundle.putParcelable(CALENDAR_CONSTRAINTS_KEY, new CalendarConstraints(monthCreate, monthCreate2, dateValidator2, l10 == null ? null : Month.create(l10.longValue()), i12, null));
        bundle.putParcelable(DAY_VIEW_DECORATOR_KEY, this.dayViewDecorator);
        bundle.putInt(TITLE_TEXT_RES_ID_KEY, this.titleTextResId);
        bundle.putCharSequence(TITLE_TEXT_KEY, this.titleText);
        bundle.putInt(INPUT_MODE_KEY, this.inputMode);
        bundle.putInt(POSITIVE_BUTTON_TEXT_RES_ID_KEY, this.positiveButtonTextResId);
        bundle.putCharSequence(POSITIVE_BUTTON_TEXT_KEY, this.positiveButtonText);
        bundle.putInt(POSITIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY, this.positiveButtonContentDescriptionResId);
        bundle.putCharSequence(POSITIVE_BUTTON_CONTENT_DESCRIPTION_KEY, this.positiveButtonContentDescription);
        bundle.putInt(NEGATIVE_BUTTON_TEXT_RES_ID_KEY, this.negativeButtonTextResId);
        bundle.putCharSequence(NEGATIVE_BUTTON_TEXT_KEY, this.negativeButtonText);
        bundle.putInt(NEGATIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY, this.negativeButtonContentDescriptionResId);
        bundle.putCharSequence(NEGATIVE_BUTTON_CONTENT_DESCRIPTION_KEY, this.negativeButtonContentDescription);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() throws Resources.NotFoundException {
        super.onStart();
        Window window = requireDialog().getWindow();
        if (this.fullscreen) {
            window.setLayout(-1, -1);
            window.setBackgroundDrawable(this.background);
            enableEdgeToEdgeIfNeeded(window);
        } else {
            window.setLayout(-2, -2);
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(com.stepos.aiengine.R.dimen.mtrl_calendar_dialog_background_inset);
            Rect rect = new Rect(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
            window.setBackgroundDrawable(new InsetDrawable((Drawable) this.background, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset));
            window.getDecorView().setOnTouchListener(new q4.a(requireDialog(), rect));
        }
        startPickerFragment();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStop() {
        this.pickerFragment.clearOnSelectionChangedListeners();
        super.onStop();
    }

    public boolean removeOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
        return this.onCancelListeners.remove(onCancelListener);
    }

    public boolean removeOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        return this.onDismissListeners.remove(onDismissListener);
    }

    public boolean removeOnNegativeButtonClickListener(View.OnClickListener onClickListener) {
        return this.onNegativeButtonClickListeners.remove(onClickListener);
    }

    public boolean removeOnPositiveButtonClickListener(l<? super S> lVar) {
        return this.onPositiveButtonClickListeners.remove(lVar);
    }

    public void updateHeader(String str) {
        this.headerSelectionText.setContentDescription(getHeaderContentDescription());
        this.headerSelectionText.setText(str);
    }
}
