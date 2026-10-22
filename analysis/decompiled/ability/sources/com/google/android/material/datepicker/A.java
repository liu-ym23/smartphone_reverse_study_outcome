package com.google.android.material.datepicker;

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
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentTransaction;
import c3.AbstractC0872b;
import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.internal.CheckableImageButton;
import com.stepos.ability.R;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* loaded from: classes3.dex */
public class A<S> extends DialogFragment {

    /* renamed from: A, reason: collision with root package name */
    public Button f2395A;

    /* renamed from: B, reason: collision with root package name */
    public boolean f2396B;

    /* renamed from: C, reason: collision with root package name */
    public CharSequence f2397C;

    /* renamed from: D, reason: collision with root package name */
    public CharSequence f2398D;

    /* renamed from: a, reason: collision with root package name */
    public final LinkedHashSet f2399a = new LinkedHashSet();
    public final LinkedHashSet b = new LinkedHashSet();
    public final LinkedHashSet c = new LinkedHashSet();
    public final LinkedHashSet d = new LinkedHashSet();
    public int e;
    public DateSelector f;
    public I g;
    public CalendarConstraints h;
    public DayViewDecorator i;

    /* renamed from: j, reason: collision with root package name */
    public MaterialCalendar f2400j;
    public int k;
    public CharSequence l;
    public boolean m;
    public int n;
    public int o;
    public CharSequence p;

    /* renamed from: q, reason: collision with root package name */
    public int f2401q;

    /* renamed from: r, reason: collision with root package name */
    public CharSequence f2402r;

    /* renamed from: s, reason: collision with root package name */
    public int f2403s;

    /* renamed from: t, reason: collision with root package name */
    public CharSequence f2404t;
    public int u;

    /* renamed from: v, reason: collision with root package name */
    public CharSequence f2405v;

    /* renamed from: w, reason: collision with root package name */
    public TextView f2406w;

    /* renamed from: x, reason: collision with root package name */
    public TextView f2407x;
    public CheckableImageButton y;

    /* renamed from: z, reason: collision with root package name */
    public e3.k f2408z;

    public static int c(Context context) throws Resources.NotFoundException {
        Resources resources = context.getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_content_padding);
        int i = Month.current().daysInWeek;
        return ((i - 1) * resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_month_horizontal_padding)) + (resources.getDimensionPixelSize(R.dimen.mtrl_calendar_day_width) * i) + (dimensionPixelOffset * 2);
    }

    public static boolean d(int i, Context context) throws Resources.NotFoundException {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(AbstractC0872b.d(context, MaterialCalendar.class.getCanonicalName(), R.attr.materialCalendarStyle).data, new int[]{i});
        boolean z10 = typedArrayObtainStyledAttributes.getBoolean(0, false);
        typedArrayObtainStyledAttributes.recycle();
        return z10;
    }

    public final DateSelector b() {
        if (this.f == null) {
            this.f = (DateSelector) getArguments().getParcelable("DATE_SELECTOR_KEY");
        }
        return this.f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v1, types: [androidx.fragment.app.Fragment, com.google.android.material.datepicker.B] */
    public final void e() {
        Context contextRequireContext = requireContext();
        int defaultThemeResId = this.e;
        if (defaultThemeResId == 0) {
            defaultThemeResId = b().getDefaultThemeResId(contextRequireContext);
        }
        DateSelector dateSelectorB = b();
        CalendarConstraints calendarConstraints = this.h;
        DayViewDecorator dayViewDecorator = this.i;
        MaterialCalendar materialCalendar = new MaterialCalendar();
        Bundle bundle = new Bundle();
        bundle.putInt("THEME_RES_ID_KEY", defaultThemeResId);
        bundle.putParcelable("GRID_SELECTOR_KEY", dateSelectorB);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", calendarConstraints);
        bundle.putParcelable("DAY_VIEW_DECORATOR_KEY", dayViewDecorator);
        bundle.putParcelable("CURRENT_MONTH_KEY", calendarConstraints.getOpenAt());
        materialCalendar.setArguments(bundle);
        this.f2400j = materialCalendar;
        if (this.n == 1) {
            DateSelector dateSelectorB2 = b();
            CalendarConstraints calendarConstraints2 = this.h;
            ?? b = new B();
            Bundle bundle2 = new Bundle();
            bundle2.putInt("THEME_RES_ID_KEY", defaultThemeResId);
            bundle2.putParcelable("DATE_SELECTOR_KEY", dateSelectorB2);
            bundle2.putParcelable("CALENDAR_CONSTRAINTS_KEY", calendarConstraints2);
            b.setArguments(bundle2);
            materialCalendar = b;
        }
        this.g = materialCalendar;
        this.f2406w.setText((this.n == 1 && getResources().getConfiguration().orientation == 2) ? this.f2398D : this.f2397C);
        String selectionDisplayString = b().getSelectionDisplayString(getContext());
        this.f2407x.setContentDescription(b().getSelectionContentDescription(requireContext()));
        this.f2407x.setText(selectionDisplayString);
        FragmentTransaction fragmentTransactionBeginTransaction = getChildFragmentManager().beginTransaction();
        fragmentTransactionBeginTransaction.replace(R.id.mtrl_calendar_frame, this.g);
        fragmentTransactionBeginTransaction.commitNow();
        this.g.b(new z(this, 0));
    }

    public final void f(CheckableImageButton checkableImageButton) {
        this.y.setContentDescription(this.n == 1 ? checkableImageButton.getContext().getString(R.string.mtrl_picker_toggle_to_calendar_input_mode) : checkableImageButton.getContext().getString(R.string.mtrl_picker_toggle_to_text_input_mode));
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            ((DialogInterface.OnCancelListener) it.next()).onCancel(dialogInterface);
        }
        super.onCancel(dialogInterface);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) throws Resources.NotFoundException {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.e = bundle.getInt("OVERRIDE_THEME_RES_ID");
        this.f = (DateSelector) bundle.getParcelable("DATE_SELECTOR_KEY");
        this.h = (CalendarConstraints) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.i = (DayViewDecorator) bundle.getParcelable("DAY_VIEW_DECORATOR_KEY");
        this.k = bundle.getInt("TITLE_TEXT_RES_ID_KEY");
        this.l = bundle.getCharSequence("TITLE_TEXT_KEY");
        this.n = bundle.getInt("INPUT_MODE_KEY");
        this.o = bundle.getInt("POSITIVE_BUTTON_TEXT_RES_ID_KEY");
        this.p = bundle.getCharSequence("POSITIVE_BUTTON_TEXT_KEY");
        this.f2401q = bundle.getInt("POSITIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY");
        this.f2402r = bundle.getCharSequence("POSITIVE_BUTTON_CONTENT_DESCRIPTION_KEY");
        this.f2403s = bundle.getInt("NEGATIVE_BUTTON_TEXT_RES_ID_KEY");
        this.f2404t = bundle.getCharSequence("NEGATIVE_BUTTON_TEXT_KEY");
        this.u = bundle.getInt("NEGATIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY");
        this.f2405v = bundle.getCharSequence("NEGATIVE_BUTTON_CONTENT_DESCRIPTION_KEY");
        CharSequence text = this.l;
        if (text == null) {
            text = requireContext().getResources().getText(this.k);
        }
        this.f2397C = text;
        if (text != null) {
            CharSequence[] charSequenceArrSplit = TextUtils.split(String.valueOf(text), "\n");
            if (charSequenceArrSplit.length > 1) {
                text = charSequenceArrSplit[0];
            }
        } else {
            text = null;
        }
        this.f2398D = text;
    }

    @Override // androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle bundle) {
        Context contextRequireContext = requireContext();
        Context contextRequireContext2 = requireContext();
        int defaultThemeResId = this.e;
        if (defaultThemeResId == 0) {
            defaultThemeResId = b().getDefaultThemeResId(contextRequireContext2);
        }
        Dialog dialog = new Dialog(contextRequireContext, defaultThemeResId);
        Context context = dialog.getContext();
        this.m = d(android.R.attr.windowFullscreen, context);
        this.f2408z = new e3.k(context, null, R.attr.materialCalendarStyle, R.style.Widget_MaterialComponents_MaterialCalendar);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, P2.a.f1076q, R.attr.materialCalendarStyle, R.style.Widget_MaterialComponents_MaterialCalendar);
        int color = typedArrayObtainStyledAttributes.getColor(1, 0);
        typedArrayObtainStyledAttributes.recycle();
        this.f2408z.m(context);
        this.f2408z.q(ColorStateList.valueOf(color));
        this.f2408z.p(dialog.getWindow().getDecorView().getElevation());
        return dialog;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(this.m ? R.layout.mtrl_picker_fullscreen : R.layout.mtrl_picker_dialog, viewGroup);
        Context context = viewInflate.getContext();
        DayViewDecorator dayViewDecorator = this.i;
        if (dayViewDecorator != null) {
            dayViewDecorator.initialize(context);
        }
        if (this.m) {
            viewInflate.findViewById(R.id.mtrl_calendar_frame).setLayoutParams(new LinearLayout.LayoutParams(c(context), -2));
        } else {
            viewInflate.findViewById(R.id.mtrl_calendar_main_pane).setLayoutParams(new LinearLayout.LayoutParams(c(context), -1));
        }
        TextView textView = (TextView) viewInflate.findViewById(R.id.mtrl_picker_header_selection_text);
        this.f2407x = textView;
        textView.setAccessibilityLiveRegion(1);
        this.y = (CheckableImageButton) viewInflate.findViewById(R.id.mtrl_picker_header_toggle);
        this.f2406w = (TextView) viewInflate.findViewById(R.id.mtrl_picker_title_text);
        this.y.setTag("TOGGLE_BUTTON_TAG");
        CheckableImageButton checkableImageButton = this.y;
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{android.R.attr.state_checked}, AppCompatResources.getDrawable(context, R.drawable.material_ic_calendar_black_24dp));
        stateListDrawable.addState(new int[0], AppCompatResources.getDrawable(context, R.drawable.material_ic_edit_black_24dp));
        checkableImageButton.setImageDrawable(stateListDrawable);
        this.y.setChecked(this.n != 0);
        ViewCompat.setAccessibilityDelegate(this.y, null);
        f(this.y);
        final int i = 2;
        this.y.setOnClickListener(new View.OnClickListener(this) { // from class: com.google.android.material.datepicker.x
            public final /* synthetic */ A b;

            {
                this.b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i) {
                    case 0:
                        A a3 = this.b;
                        Iterator it = a3.f2399a.iterator();
                        if (!it.hasNext()) {
                            a3.dismiss();
                            return;
                        } else {
                            if (it.next() != null) {
                                throw new ClassCastException();
                            }
                            a3.b().getSelection();
                            throw null;
                        }
                    case 1:
                        A a4 = this.b;
                        Iterator it2 = a4.b.iterator();
                        while (it2.hasNext()) {
                            ((View.OnClickListener) it2.next()).onClick(view);
                        }
                        a4.dismiss();
                        return;
                    default:
                        A a8 = this.b;
                        a8.f2395A.setEnabled(a8.b().isSelectionComplete());
                        a8.y.toggle();
                        a8.n = a8.n == 1 ? 0 : 1;
                        a8.f(a8.y);
                        a8.e();
                        return;
                }
            }
        });
        this.f2395A = (Button) viewInflate.findViewById(R.id.confirm_button);
        if (b().isSelectionComplete()) {
            this.f2395A.setEnabled(true);
        } else {
            this.f2395A.setEnabled(false);
        }
        this.f2395A.setTag("CONFIRM_BUTTON_TAG");
        CharSequence charSequence = this.p;
        if (charSequence != null) {
            this.f2395A.setText(charSequence);
        } else {
            int i6 = this.o;
            if (i6 != 0) {
                this.f2395A.setText(i6);
            }
        }
        CharSequence charSequence2 = this.f2402r;
        if (charSequence2 != null) {
            this.f2395A.setContentDescription(charSequence2);
        } else if (this.f2401q != 0) {
            this.f2395A.setContentDescription(getContext().getResources().getText(this.f2401q));
        }
        final int i10 = 0;
        this.f2395A.setOnClickListener(new View.OnClickListener(this) { // from class: com.google.android.material.datepicker.x
            public final /* synthetic */ A b;

            {
                this.b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i10) {
                    case 0:
                        A a3 = this.b;
                        Iterator it = a3.f2399a.iterator();
                        if (!it.hasNext()) {
                            a3.dismiss();
                            return;
                        } else {
                            if (it.next() != null) {
                                throw new ClassCastException();
                            }
                            a3.b().getSelection();
                            throw null;
                        }
                    case 1:
                        A a4 = this.b;
                        Iterator it2 = a4.b.iterator();
                        while (it2.hasNext()) {
                            ((View.OnClickListener) it2.next()).onClick(view);
                        }
                        a4.dismiss();
                        return;
                    default:
                        A a8 = this.b;
                        a8.f2395A.setEnabled(a8.b().isSelectionComplete());
                        a8.y.toggle();
                        a8.n = a8.n == 1 ? 0 : 1;
                        a8.f(a8.y);
                        a8.e();
                        return;
                }
            }
        });
        Button button = (Button) viewInflate.findViewById(R.id.cancel_button);
        button.setTag("CANCEL_BUTTON_TAG");
        CharSequence charSequence3 = this.f2404t;
        if (charSequence3 != null) {
            button.setText(charSequence3);
        } else {
            int i11 = this.f2403s;
            if (i11 != 0) {
                button.setText(i11);
            }
        }
        CharSequence charSequence4 = this.f2405v;
        if (charSequence4 != null) {
            button.setContentDescription(charSequence4);
        } else if (this.u != 0) {
            button.setContentDescription(getContext().getResources().getText(this.u));
        }
        final int i12 = 1;
        button.setOnClickListener(new View.OnClickListener(this) { // from class: com.google.android.material.datepicker.x
            public final /* synthetic */ A b;

            {
                this.b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i12) {
                    case 0:
                        A a3 = this.b;
                        Iterator it = a3.f2399a.iterator();
                        if (!it.hasNext()) {
                            a3.dismiss();
                            return;
                        } else {
                            if (it.next() != null) {
                                throw new ClassCastException();
                            }
                            a3.b().getSelection();
                            throw null;
                        }
                    case 1:
                        A a4 = this.b;
                        Iterator it2 = a4.b.iterator();
                        while (it2.hasNext()) {
                            ((View.OnClickListener) it2.next()).onClick(view);
                        }
                        a4.dismiss();
                        return;
                    default:
                        A a8 = this.b;
                        a8.f2395A.setEnabled(a8.b().isSelectionComplete());
                        a8.y.toggle();
                        a8.n = a8.n == 1 ? 0 : 1;
                        a8.f(a8.y);
                        a8.e();
                        return;
                }
            }
        });
        return viewInflate;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        Iterator it = this.d.iterator();
        while (it.hasNext()) {
            ((DialogInterface.OnDismissListener) it.next()).onDismiss(dialogInterface);
        }
        ViewGroup viewGroup = (ViewGroup) getView();
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        super.onDismiss(dialogInterface);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("OVERRIDE_THEME_RES_ID", this.e);
        bundle.putParcelable("DATE_SELECTOR_KEY", this.f);
        CalendarConstraints calendarConstraints = this.h;
        C0899b c0899b = new C0899b();
        int i = C0899b.c;
        int i6 = C0899b.c;
        c0899b.b = DateValidatorPointForward.from(Long.MIN_VALUE);
        long j5 = calendarConstraints.start.timeInMillis;
        long j6 = calendarConstraints.end.timeInMillis;
        c0899b.f2424a = Long.valueOf(calendarConstraints.openAt.timeInMillis);
        int i10 = calendarConstraints.firstDayOfWeek;
        CalendarConstraints.DateValidator dateValidator = calendarConstraints.validator;
        c0899b.b = dateValidator;
        MaterialCalendar materialCalendar = this.f2400j;
        Month month = materialCalendar == null ? null : materialCalendar.f;
        if (month != null) {
            c0899b.f2424a = Long.valueOf(month.timeInMillis);
        }
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable("DEEP_COPY_VALIDATOR_KEY", dateValidator);
        Month monthCreate = Month.create(j5);
        Month monthCreate2 = Month.create(j6);
        CalendarConstraints.DateValidator dateValidator2 = (CalendarConstraints.DateValidator) bundle2.getParcelable("DEEP_COPY_VALIDATOR_KEY");
        Long l = c0899b.f2424a;
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", new CalendarConstraints(monthCreate, monthCreate2, dateValidator2, l == null ? null : Month.create(l.longValue()), i10, null));
        bundle.putParcelable("DAY_VIEW_DECORATOR_KEY", this.i);
        bundle.putInt("TITLE_TEXT_RES_ID_KEY", this.k);
        bundle.putCharSequence("TITLE_TEXT_KEY", this.l);
        bundle.putInt("INPUT_MODE_KEY", this.n);
        bundle.putInt("POSITIVE_BUTTON_TEXT_RES_ID_KEY", this.o);
        bundle.putCharSequence("POSITIVE_BUTTON_TEXT_KEY", this.p);
        bundle.putInt("POSITIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY", this.f2401q);
        bundle.putCharSequence("POSITIVE_BUTTON_CONTENT_DESCRIPTION_KEY", this.f2402r);
        bundle.putInt("NEGATIVE_BUTTON_TEXT_RES_ID_KEY", this.f2403s);
        bundle.putCharSequence("NEGATIVE_BUTTON_TEXT_KEY", this.f2404t);
        bundle.putInt("NEGATIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY", this.u);
        bundle.putCharSequence("NEGATIVE_BUTTON_CONTENT_DESCRIPTION_KEY", this.f2405v);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStart() throws Resources.NotFoundException {
        super.onStart();
        Window window = requireDialog().getWindow();
        if (this.m) {
            window.setLayout(-1, -1);
            window.setBackgroundDrawable(this.f2408z);
            if (!this.f2396B) {
                View viewFindViewById = requireView().findViewById(R.id.fullscreen_header);
                ColorStateList colorStateListA = Y2.b.a(viewFindViewById.getBackground());
                Integer numValueOf = colorStateListA != null ? Integer.valueOf(colorStateListA.getDefaultColor()) : null;
                boolean z10 = false;
                boolean z11 = numValueOf == null || numValueOf.intValue() == 0;
                Integer numB = W2.a.b(android.R.attr.colorBackground, window.getContext());
                int iIntValue = numB != null ? numB.intValue() : ViewCompat.MEASURED_STATE_MASK;
                if (z11) {
                    numValueOf = Integer.valueOf(iIntValue);
                }
                WindowCompat.setDecorFitsSystemWindows(window, false);
                window.getContext();
                window.getContext();
                window.setStatusBarColor(0);
                window.setNavigationBarColor(0);
                int iIntValue2 = numValueOf.intValue();
                WindowCompat.getInsetsController(window, window.getDecorView()).setAppearanceLightStatusBars(iIntValue2 != 0 && ColorUtils.calculateLuminance(iIntValue2) > 0.5d);
                if (iIntValue != 0 && ColorUtils.calculateLuminance(iIntValue) > 0.5d) {
                    z10 = true;
                }
                WindowCompat.getInsetsController(window, window.getDecorView()).setAppearanceLightNavigationBars(z10);
                ViewCompat.setOnApplyWindowInsetsListener(viewFindViewById, new y(viewFindViewById, viewFindViewById.getLayoutParams().height, viewFindViewById.getPaddingLeft(), viewFindViewById.getPaddingTop(), viewFindViewById.getPaddingRight()));
                this.f2396B = true;
            }
        } else {
            window.setLayout(-2, -2);
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.mtrl_calendar_dialog_background_inset);
            Rect rect = new Rect(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
            window.setBackgroundDrawable(new InsetDrawable((Drawable) this.f2408z, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset));
            window.getDecorView().setOnTouchListener(new X2.a(requireDialog(), rect));
        }
        e();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStop() {
        this.g.f2414a.clear();
        super.onStop();
    }
}
