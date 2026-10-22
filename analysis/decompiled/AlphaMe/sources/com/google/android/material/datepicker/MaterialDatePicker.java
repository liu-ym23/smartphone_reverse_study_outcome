package com.google.android.material.datepicker;

import K.A0;
import K.S;
import K.h0;
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
import androidx.annotation.RestrictTo;
import androidx.fragment.app.C0279a;
import androidx.fragment.app.Y;
import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.internal.CheckableImageButton;
import com.stepos.alphame.R;
import d.C0527a;
import e.EnumC0546d;
import f1.AbstractC0557a;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.WeakHashMap;
import m1.AbstractC0769a;
import s1.ViewOnTouchListenerC0854a;

/* loaded from: classes.dex */
public class MaterialDatePicker<S> extends androidx.fragment.app.r {

    /* renamed from: A, reason: collision with root package name */
    public int f10628A;

    /* renamed from: B, reason: collision with root package name */
    public CharSequence f10629B;

    /* renamed from: C, reason: collision with root package name */
    public boolean f10630C;

    /* renamed from: D, reason: collision with root package name */
    public int f10631D;

    /* renamed from: E, reason: collision with root package name */
    public int f10632E;

    /* renamed from: F, reason: collision with root package name */
    public CharSequence f10633F;

    /* renamed from: G, reason: collision with root package name */
    public int f10634G;

    /* renamed from: H, reason: collision with root package name */
    public CharSequence f10635H;

    /* renamed from: I, reason: collision with root package name */
    public int f10636I;

    /* renamed from: J, reason: collision with root package name */
    public CharSequence f10637J;

    /* renamed from: K, reason: collision with root package name */
    public int f10638K;

    /* renamed from: L, reason: collision with root package name */
    public CharSequence f10639L;

    /* renamed from: M, reason: collision with root package name */
    public TextView f10640M;

    /* renamed from: N, reason: collision with root package name */
    public TextView f10641N;

    /* renamed from: O, reason: collision with root package name */
    public CheckableImageButton f10642O;

    /* renamed from: P, reason: collision with root package name */
    public y1.j f10643P;

    /* renamed from: Q, reason: collision with root package name */
    public Button f10644Q;

    /* renamed from: R, reason: collision with root package name */
    public boolean f10645R;

    /* renamed from: S, reason: collision with root package name */
    public CharSequence f10646S;
    public CharSequence T;

    /* renamed from: q, reason: collision with root package name */
    public final LinkedHashSet f10647q = new LinkedHashSet();

    /* renamed from: r, reason: collision with root package name */
    public final LinkedHashSet f10648r = new LinkedHashSet();

    /* renamed from: s, reason: collision with root package name */
    public final LinkedHashSet f10649s = new LinkedHashSet();

    /* renamed from: t, reason: collision with root package name */
    public final LinkedHashSet f10650t = new LinkedHashSet();

    /* renamed from: u, reason: collision with root package name */
    public int f10651u;

    /* renamed from: v, reason: collision with root package name */
    public DateSelector f10652v;

    /* renamed from: w, reason: collision with root package name */
    public D f10653w;

    /* renamed from: x, reason: collision with root package name */
    public CalendarConstraints f10654x;

    /* renamed from: y, reason: collision with root package name */
    public DayViewDecorator f10655y;

    /* renamed from: z, reason: collision with root package name */
    public s f10656z;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({EnumC0546d.f12493b})
    public @interface InputMode {
    }

    public static int j(Context context) throws Resources.NotFoundException {
        Resources resources = context.getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_content_padding);
        Month month = new Month(J.f());
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.mtrl_calendar_day_width);
        int dimensionPixelOffset2 = resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_month_horizontal_padding);
        int i4 = month.f10660d;
        return ((i4 - 1) * dimensionPixelOffset2) + (dimensionPixelSize * i4) + (dimensionPixelOffset * 2);
    }

    public static boolean k(int i4, Context context) throws Resources.NotFoundException {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(AbstractC0557a.Y(context, s.class.getCanonicalName(), R.attr.materialCalendarStyle).data, new int[]{i4});
        boolean z4 = typedArrayObtainStyledAttributes.getBoolean(0, false);
        typedArrayObtainStyledAttributes.recycle();
        return z4;
    }

    @Override // androidx.fragment.app.r
    public final Dialog h() {
        Context contextRequireContext = requireContext();
        Context contextRequireContext2 = requireContext();
        int iD = this.f10651u;
        if (iD == 0) {
            iD = i().d(contextRequireContext2);
        }
        Dialog dialog = new Dialog(contextRequireContext, iD);
        Context context = dialog.getContext();
        this.f10630C = k(android.R.attr.windowFullscreen, context);
        this.f10643P = new y1.j(context, null, R.attr.materialCalendarStyle, R.style.Widget_MaterialComponents_MaterialCalendar);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, AbstractC0769a.f13551q, R.attr.materialCalendarStyle, R.style.Widget_MaterialComponents_MaterialCalendar);
        int color = typedArrayObtainStyledAttributes.getColor(1, 0);
        typedArrayObtainStyledAttributes.recycle();
        this.f10643P.l(context);
        this.f10643P.o(ColorStateList.valueOf(color));
        this.f10643P.n(dialog.getWindow().getDecorView().getElevation());
        return dialog;
    }

    public final DateSelector i() {
        if (this.f10652v == null) {
            this.f10652v = (DateSelector) getArguments().getParcelable("DATE_SELECTOR_KEY");
        }
        return this.f10652v;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v1, types: [androidx.fragment.app.D, com.google.android.material.datepicker.w] */
    public final void l() {
        Context contextRequireContext = requireContext();
        int iD = this.f10651u;
        if (iD == 0) {
            iD = i().d(contextRequireContext);
        }
        DateSelector dateSelectorI = i();
        CalendarConstraints calendarConstraints = this.f10654x;
        DayViewDecorator dayViewDecorator = this.f10655y;
        s sVar = new s();
        Bundle bundle = new Bundle();
        bundle.putInt("THEME_RES_ID_KEY", iD);
        bundle.putParcelable("GRID_SELECTOR_KEY", dateSelectorI);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", calendarConstraints);
        bundle.putParcelable("DAY_VIEW_DECORATOR_KEY", dayViewDecorator);
        bundle.putParcelable("CURRENT_MONTH_KEY", calendarConstraints.f10602d);
        sVar.setArguments(bundle);
        this.f10656z = sVar;
        if (this.f10631D == 1) {
            DateSelector dateSelectorI2 = i();
            CalendarConstraints calendarConstraints2 = this.f10654x;
            ?? wVar = new w();
            Bundle bundle2 = new Bundle();
            bundle2.putInt("THEME_RES_ID_KEY", iD);
            bundle2.putParcelable("DATE_SELECTOR_KEY", dateSelectorI2);
            bundle2.putParcelable("CALENDAR_CONSTRAINTS_KEY", calendarConstraints2);
            wVar.setArguments(bundle2);
            sVar = wVar;
        }
        this.f10653w = sVar;
        this.f10640M.setText((this.f10631D == 1 && getResources().getConfiguration().orientation == 2) ? this.T : this.f10646S);
        String strB = i().b(getContext());
        this.f10641N.setContentDescription(i().a(requireContext()));
        this.f10641N.setText(strB);
        Y childFragmentManager = getChildFragmentManager();
        childFragmentManager.getClass();
        C0279a c0279a = new C0279a(childFragmentManager);
        c0279a.g(this.f10653w, R.id.mtrl_calendar_frame);
        if (c0279a.f3694g) {
            throw new IllegalStateException("This transaction is already being added to the back stack");
        }
        c0279a.f3695h = false;
        c0279a.f3704q.y(c0279a, false);
        this.f10653w.g(new v(this, 0));
    }

    public final void m(CheckableImageButton checkableImageButton) {
        this.f10642O.setContentDescription(this.f10631D == 1 ? checkableImageButton.getContext().getString(R.string.mtrl_picker_toggle_to_calendar_input_mode) : checkableImageButton.getContext().getString(R.string.mtrl_picker_toggle_to_text_input_mode));
    }

    @Override // androidx.fragment.app.r, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        Iterator it = this.f10649s.iterator();
        while (it.hasNext()) {
            ((DialogInterface.OnCancelListener) it.next()).onCancel(dialogInterface);
        }
    }

    @Override // androidx.fragment.app.r, androidx.fragment.app.D
    public final void onCreate(Bundle bundle) throws Resources.NotFoundException {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.f10651u = bundle.getInt("OVERRIDE_THEME_RES_ID");
        this.f10652v = (DateSelector) bundle.getParcelable("DATE_SELECTOR_KEY");
        this.f10654x = (CalendarConstraints) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.f10655y = (DayViewDecorator) bundle.getParcelable("DAY_VIEW_DECORATOR_KEY");
        this.f10628A = bundle.getInt("TITLE_TEXT_RES_ID_KEY");
        this.f10629B = bundle.getCharSequence("TITLE_TEXT_KEY");
        this.f10631D = bundle.getInt("INPUT_MODE_KEY");
        this.f10632E = bundle.getInt("POSITIVE_BUTTON_TEXT_RES_ID_KEY");
        this.f10633F = bundle.getCharSequence("POSITIVE_BUTTON_TEXT_KEY");
        this.f10634G = bundle.getInt("POSITIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY");
        this.f10635H = bundle.getCharSequence("POSITIVE_BUTTON_CONTENT_DESCRIPTION_KEY");
        this.f10636I = bundle.getInt("NEGATIVE_BUTTON_TEXT_RES_ID_KEY");
        this.f10637J = bundle.getCharSequence("NEGATIVE_BUTTON_TEXT_KEY");
        this.f10638K = bundle.getInt("NEGATIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY");
        this.f10639L = bundle.getCharSequence("NEGATIVE_BUTTON_CONTENT_DESCRIPTION_KEY");
        CharSequence text = this.f10629B;
        if (text == null) {
            text = requireContext().getResources().getText(this.f10628A);
        }
        this.f10646S = text;
        if (text != null) {
            CharSequence[] charSequenceArrSplit = TextUtils.split(String.valueOf(text), "\n");
            if (charSequenceArrSplit.length > 1) {
                text = charSequenceArrSplit[0];
            }
        } else {
            text = null;
        }
        this.T = text;
    }

    @Override // androidx.fragment.app.D
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(this.f10630C ? R.layout.mtrl_picker_fullscreen : R.layout.mtrl_picker_dialog, viewGroup);
        Context context = viewInflate.getContext();
        DayViewDecorator dayViewDecorator = this.f10655y;
        if (dayViewDecorator != null) {
            dayViewDecorator.getClass();
        }
        if (this.f10630C) {
            viewInflate.findViewById(R.id.mtrl_calendar_frame).setLayoutParams(new LinearLayout.LayoutParams(j(context), -2));
        } else {
            viewInflate.findViewById(R.id.mtrl_calendar_main_pane).setLayoutParams(new LinearLayout.LayoutParams(j(context), -1));
        }
        TextView textView = (TextView) viewInflate.findViewById(R.id.mtrl_picker_header_selection_text);
        this.f10641N = textView;
        final int i4 = 1;
        textView.setAccessibilityLiveRegion(1);
        this.f10642O = (CheckableImageButton) viewInflate.findViewById(R.id.mtrl_picker_header_toggle);
        this.f10640M = (TextView) viewInflate.findViewById(R.id.mtrl_picker_title_text);
        this.f10642O.setTag("TOGGLE_BUTTON_TAG");
        CheckableImageButton checkableImageButton = this.f10642O;
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{android.R.attr.state_checked}, Z2.I.o(context, R.drawable.material_ic_calendar_black_24dp));
        final int i5 = 0;
        stateListDrawable.addState(new int[0], Z2.I.o(context, R.drawable.material_ic_edit_black_24dp));
        checkableImageButton.setImageDrawable(stateListDrawable);
        this.f10642O.setChecked(this.f10631D != 0);
        S.h(this.f10642O, null);
        m(this.f10642O);
        final int i6 = 2;
        this.f10642O.setOnClickListener(new View.OnClickListener(this) { // from class: com.google.android.material.datepicker.t

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ MaterialDatePicker f10721b;

            {
                this.f10721b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i7 = i6;
                MaterialDatePicker materialDatePicker = this.f10721b;
                switch (i7) {
                    case 0:
                        Iterator it = materialDatePicker.f10647q.iterator();
                        if (!it.hasNext()) {
                            materialDatePicker.g(false, false);
                            return;
                        } else {
                            B0.g.y(it.next());
                            materialDatePicker.i().getClass();
                            throw null;
                        }
                    case 1:
                        Iterator it2 = materialDatePicker.f10648r.iterator();
                        while (it2.hasNext()) {
                            ((View.OnClickListener) it2.next()).onClick(view);
                        }
                        materialDatePicker.g(false, false);
                        return;
                    default:
                        materialDatePicker.f10644Q.setEnabled(materialDatePicker.i().m());
                        materialDatePicker.f10642O.toggle();
                        materialDatePicker.f10631D = materialDatePicker.f10631D != 1 ? 1 : 0;
                        materialDatePicker.m(materialDatePicker.f10642O);
                        materialDatePicker.l();
                        return;
                }
            }
        });
        this.f10644Q = (Button) viewInflate.findViewById(R.id.confirm_button);
        if (i().m()) {
            this.f10644Q.setEnabled(true);
        } else {
            this.f10644Q.setEnabled(false);
        }
        this.f10644Q.setTag("CONFIRM_BUTTON_TAG");
        CharSequence charSequence = this.f10633F;
        if (charSequence != null) {
            this.f10644Q.setText(charSequence);
        } else {
            int i7 = this.f10632E;
            if (i7 != 0) {
                this.f10644Q.setText(i7);
            }
        }
        CharSequence charSequence2 = this.f10635H;
        if (charSequence2 != null) {
            this.f10644Q.setContentDescription(charSequence2);
        } else if (this.f10634G != 0) {
            this.f10644Q.setContentDescription(getContext().getResources().getText(this.f10634G));
        }
        this.f10644Q.setOnClickListener(new View.OnClickListener(this) { // from class: com.google.android.material.datepicker.t

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ MaterialDatePicker f10721b;

            {
                this.f10721b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i72 = i5;
                MaterialDatePicker materialDatePicker = this.f10721b;
                switch (i72) {
                    case 0:
                        Iterator it = materialDatePicker.f10647q.iterator();
                        if (!it.hasNext()) {
                            materialDatePicker.g(false, false);
                            return;
                        } else {
                            B0.g.y(it.next());
                            materialDatePicker.i().getClass();
                            throw null;
                        }
                    case 1:
                        Iterator it2 = materialDatePicker.f10648r.iterator();
                        while (it2.hasNext()) {
                            ((View.OnClickListener) it2.next()).onClick(view);
                        }
                        materialDatePicker.g(false, false);
                        return;
                    default:
                        materialDatePicker.f10644Q.setEnabled(materialDatePicker.i().m());
                        materialDatePicker.f10642O.toggle();
                        materialDatePicker.f10631D = materialDatePicker.f10631D != 1 ? 1 : 0;
                        materialDatePicker.m(materialDatePicker.f10642O);
                        materialDatePicker.l();
                        return;
                }
            }
        });
        Button button = (Button) viewInflate.findViewById(R.id.cancel_button);
        button.setTag("CANCEL_BUTTON_TAG");
        CharSequence charSequence3 = this.f10637J;
        if (charSequence3 != null) {
            button.setText(charSequence3);
        } else {
            int i8 = this.f10636I;
            if (i8 != 0) {
                button.setText(i8);
            }
        }
        CharSequence charSequence4 = this.f10639L;
        if (charSequence4 != null) {
            button.setContentDescription(charSequence4);
        } else if (this.f10638K != 0) {
            button.setContentDescription(getContext().getResources().getText(this.f10638K));
        }
        button.setOnClickListener(new View.OnClickListener(this) { // from class: com.google.android.material.datepicker.t

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ MaterialDatePicker f10721b;

            {
                this.f10721b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i72 = i4;
                MaterialDatePicker materialDatePicker = this.f10721b;
                switch (i72) {
                    case 0:
                        Iterator it = materialDatePicker.f10647q.iterator();
                        if (!it.hasNext()) {
                            materialDatePicker.g(false, false);
                            return;
                        } else {
                            B0.g.y(it.next());
                            materialDatePicker.i().getClass();
                            throw null;
                        }
                    case 1:
                        Iterator it2 = materialDatePicker.f10648r.iterator();
                        while (it2.hasNext()) {
                            ((View.OnClickListener) it2.next()).onClick(view);
                        }
                        materialDatePicker.g(false, false);
                        return;
                    default:
                        materialDatePicker.f10644Q.setEnabled(materialDatePicker.i().m());
                        materialDatePicker.f10642O.toggle();
                        materialDatePicker.f10631D = materialDatePicker.f10631D != 1 ? 1 : 0;
                        materialDatePicker.m(materialDatePicker.f10642O);
                        materialDatePicker.l();
                        return;
                }
            }
        });
        return viewInflate;
    }

    @Override // androidx.fragment.app.r, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        Iterator it = this.f10650t.iterator();
        while (it.hasNext()) {
            ((DialogInterface.OnDismissListener) it.next()).onDismiss(dialogInterface);
        }
        ViewGroup viewGroup = (ViewGroup) getView();
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        super.onDismiss(dialogInterface);
    }

    @Override // androidx.fragment.app.r, androidx.fragment.app.D
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("OVERRIDE_THEME_RES_ID", this.f10651u);
        bundle.putParcelable("DATE_SELECTOR_KEY", this.f10652v);
        CalendarConstraints calendarConstraints = this.f10654x;
        C0423b c0423b = new C0423b();
        int i4 = C0423b.f10670c;
        int i5 = C0423b.f10670c;
        long j4 = calendarConstraints.f10599a.f10662f;
        long j5 = calendarConstraints.f10600b.f10662f;
        c0423b.f10671a = Long.valueOf(calendarConstraints.f10602d.f10662f);
        CalendarConstraints.DateValidator dateValidator = calendarConstraints.f10601c;
        c0423b.f10672b = dateValidator;
        s sVar = this.f10656z;
        Month month = sVar == null ? null : sVar.f10709f;
        if (month != null) {
            c0423b.f10671a = Long.valueOf(month.f10662f);
        }
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable("DEEP_COPY_VALIDATOR_KEY", dateValidator);
        Month monthF = Month.f(j4);
        Month monthF2 = Month.f(j5);
        CalendarConstraints.DateValidator dateValidator2 = (CalendarConstraints.DateValidator) bundle2.getParcelable("DEEP_COPY_VALIDATOR_KEY");
        Long l4 = c0423b.f10671a;
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", new CalendarConstraints(monthF, monthF2, dateValidator2, l4 != null ? Month.f(l4.longValue()) : null, calendarConstraints.f10603e));
        bundle.putParcelable("DAY_VIEW_DECORATOR_KEY", this.f10655y);
        bundle.putInt("TITLE_TEXT_RES_ID_KEY", this.f10628A);
        bundle.putCharSequence("TITLE_TEXT_KEY", this.f10629B);
        bundle.putInt("INPUT_MODE_KEY", this.f10631D);
        bundle.putInt("POSITIVE_BUTTON_TEXT_RES_ID_KEY", this.f10632E);
        bundle.putCharSequence("POSITIVE_BUTTON_TEXT_KEY", this.f10633F);
        bundle.putInt("POSITIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY", this.f10634G);
        bundle.putCharSequence("POSITIVE_BUTTON_CONTENT_DESCRIPTION_KEY", this.f10635H);
        bundle.putInt("NEGATIVE_BUTTON_TEXT_RES_ID_KEY", this.f10636I);
        bundle.putCharSequence("NEGATIVE_BUTTON_TEXT_KEY", this.f10637J);
        bundle.putInt("NEGATIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY", this.f10638K);
        bundle.putCharSequence("NEGATIVE_BUTTON_CONTENT_DESCRIPTION_KEY", this.f10639L);
    }

    @Override // androidx.fragment.app.r, androidx.fragment.app.D
    public final void onStart() throws Resources.NotFoundException {
        super.onStart();
        Dialog dialog = this.f3820l;
        if (dialog == null) {
            throw new IllegalStateException("DialogFragment " + this + " does not have a Dialog.");
        }
        Window window = dialog.getWindow();
        if (this.f10630C) {
            window.setLayout(-1, -1);
            window.setBackgroundDrawable(this.f10643P);
            if (!this.f10645R) {
                View viewFindViewById = requireView().findViewById(R.id.fullscreen_header);
                ColorStateList colorStateListW = t0.J.w(viewFindViewById.getBackground());
                Integer numValueOf = colorStateListW != null ? Integer.valueOf(colorStateListW.getDefaultColor()) : null;
                boolean z4 = numValueOf == null || numValueOf.intValue() == 0;
                Integer numY = AbstractC0557a.y(android.R.attr.colorBackground, window.getContext());
                int iIntValue = numY != null ? numY.intValue() : -16777216;
                if (z4) {
                    numValueOf = Integer.valueOf(iIntValue);
                }
                h0.a(window, false);
                window.getContext();
                window.getContext();
                window.setStatusBarColor(0);
                window.setNavigationBarColor(0);
                boolean z5 = AbstractC0557a.H(0) || AbstractC0557a.H(numValueOf.intValue());
                A0 a02 = new A0(window.getInsetsController(), new C0527a(window.getDecorView()));
                a02.f923e = window;
                a02.s(z5);
                boolean z6 = AbstractC0557a.H(0) || AbstractC0557a.H(iIntValue);
                A0 a03 = new A0(window.getInsetsController(), new C0527a(window.getDecorView()));
                a03.f923e = window;
                a03.r(z6);
                u uVar = new u(viewFindViewById.getLayoutParams().height, viewFindViewById, viewFindViewById.getPaddingLeft(), viewFindViewById.getPaddingTop(), viewFindViewById.getPaddingRight());
                WeakHashMap weakHashMap = S.f939a;
                K.J.u(viewFindViewById, uVar);
                this.f10645R = true;
            }
        } else {
            window.setLayout(-2, -2);
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.mtrl_calendar_dialog_background_inset);
            Rect rect = new Rect(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
            window.setBackgroundDrawable(new InsetDrawable((Drawable) this.f10643P, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset));
            View decorView = window.getDecorView();
            Dialog dialog2 = this.f3820l;
            if (dialog2 == null) {
                throw new IllegalStateException("DialogFragment " + this + " does not have a Dialog.");
            }
            decorView.setOnTouchListener(new ViewOnTouchListenerC0854a(dialog2, rect));
        }
        l();
    }

    @Override // androidx.fragment.app.r, androidx.fragment.app.D
    public final void onStop() {
        this.f10653w.f10610a.clear();
        super.onStop();
    }
}
