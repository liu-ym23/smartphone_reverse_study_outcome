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
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.A;
import androidx.core.view.N;
import androidx.core.view.a0;
import androidx.fragment.app.DialogInterfaceOnCancelListenerC1374l;
import androidx.fragment.app.K;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$drawable;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.internal.CheckableImageButton;
import f.C4027a;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* loaded from: classes2.dex */
public class m<S> extends DialogInterfaceOnCancelListenerC1374l {

    /* renamed from: E, reason: collision with root package name */
    public static final Object f20796E = "CONFIRM_BUTTON_TAG";

    /* renamed from: F, reason: collision with root package name */
    public static final Object f20797F = "CANCEL_BUTTON_TAG";

    /* renamed from: G, reason: collision with root package name */
    public static final Object f20798G = "TOGGLE_BUTTON_TAG";

    /* renamed from: A, reason: collision with root package name */
    public Button f20799A;

    /* renamed from: B, reason: collision with root package name */
    public boolean f20800B;

    /* renamed from: C, reason: collision with root package name */
    public CharSequence f20801C;

    /* renamed from: D, reason: collision with root package name */
    public CharSequence f20802D;

    /* renamed from: a, reason: collision with root package name */
    public final LinkedHashSet<n<? super S>> f20803a = new LinkedHashSet<>();

    /* renamed from: b, reason: collision with root package name */
    public final LinkedHashSet<View.OnClickListener> f20804b = new LinkedHashSet<>();

    /* renamed from: c, reason: collision with root package name */
    public final LinkedHashSet<DialogInterface.OnCancelListener> f20805c = new LinkedHashSet<>();

    /* renamed from: d, reason: collision with root package name */
    public final LinkedHashSet<DialogInterface.OnDismissListener> f20806d = new LinkedHashSet<>();

    /* renamed from: e, reason: collision with root package name */
    public int f20807e;

    /* renamed from: f, reason: collision with root package name */
    public DateSelector<S> f20808f;

    /* renamed from: g, reason: collision with root package name */
    public s<S> f20809g;

    /* renamed from: h, reason: collision with root package name */
    public CalendarConstraints f20810h;

    /* renamed from: i, reason: collision with root package name */
    public DayViewDecorator f20811i;

    /* renamed from: j, reason: collision with root package name */
    public MaterialCalendar<S> f20812j;

    /* renamed from: k, reason: collision with root package name */
    public int f20813k;

    /* renamed from: l, reason: collision with root package name */
    public CharSequence f20814l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f20815m;

    /* renamed from: n, reason: collision with root package name */
    public int f20816n;

    /* renamed from: o, reason: collision with root package name */
    public int f20817o;

    /* renamed from: p, reason: collision with root package name */
    public CharSequence f20818p;

    /* renamed from: q, reason: collision with root package name */
    public int f20819q;

    /* renamed from: r, reason: collision with root package name */
    public CharSequence f20820r;

    /* renamed from: s, reason: collision with root package name */
    public int f20821s;

    /* renamed from: t, reason: collision with root package name */
    public CharSequence f20822t;

    /* renamed from: u, reason: collision with root package name */
    public int f20823u;

    /* renamed from: v, reason: collision with root package name */
    public CharSequence f20824v;

    /* renamed from: w, reason: collision with root package name */
    public TextView f20825w;

    /* renamed from: x, reason: collision with root package name */
    public TextView f20826x;

    /* renamed from: y, reason: collision with root package name */
    public CheckableImageButton f20827y;

    /* renamed from: z, reason: collision with root package name */
    public Z2.h f20828z;

    public class a implements A {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f20829a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f20830b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f20831c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f20832d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ int f20833e;

        public a(int i10, View view, int i11, int i12, int i13) {
            this.f20829a = i10;
            this.f20830b = view;
            this.f20831c = i11;
            this.f20832d = i12;
            this.f20833e = i13;
        }

        @Override // androidx.core.view.A
        public a0 a(View view, a0 a0Var) {
            t0.e eVarF = a0Var.f(a0.o.g());
            if (this.f20829a >= 0) {
                this.f20830b.getLayoutParams().height = this.f20829a + eVarF.f41978b;
                View view2 = this.f20830b;
                view2.setLayoutParams(view2.getLayoutParams());
            }
            View view3 = this.f20830b;
            view3.setPadding(this.f20831c + eVarF.f41977a, this.f20832d + eVarF.f41978b, this.f20833e + eVarF.f41979c, view3.getPaddingBottom());
            return a0Var;
        }
    }

    public class b extends r<S> {
        public b() {
        }

        @Override // com.google.android.material.datepicker.r
        public void a() {
            m.this.f20799A.setEnabled(false);
        }

        @Override // com.google.android.material.datepicker.r
        public void b(S s10) {
            m mVar = m.this;
            mVar.I(mVar.w());
            m.this.f20799A.setEnabled(m.this.t().isSelectionComplete());
        }
    }

    public static boolean B(Context context) {
        return G(context, R.attr.windowFullscreen);
    }

    public static boolean D(Context context) {
        return G(context, R$attr.nestedScrollable);
    }

    public static boolean G(Context context, int i10) throws Resources.NotFoundException {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(W2.b.f(context, R$attr.materialCalendarStyle, MaterialCalendar.class.getCanonicalName()), new int[]{i10});
        boolean z10 = typedArrayObtainStyledAttributes.getBoolean(0, false);
        typedArrayObtainStyledAttributes.recycle();
        return z10;
    }

    public static /* synthetic */ void o(m mVar, View view) {
        mVar.f20799A.setEnabled(mVar.t().isSelectionComplete());
        mVar.f20827y.toggle();
        mVar.f20816n = mVar.f20816n == 1 ? 0 : 1;
        mVar.K(mVar.f20827y);
        mVar.H();
    }

    public static Drawable r(Context context) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_checked}, C4027a.b(context, R$drawable.material_ic_calendar_black_24dp));
        stateListDrawable.addState(new int[0], C4027a.b(context, R$drawable.material_ic_edit_black_24dp));
        return stateListDrawable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DateSelector<S> t() {
        if (this.f20808f == null) {
            this.f20808f = (DateSelector) getArguments().getParcelable("DATE_SELECTOR_KEY");
        }
        return this.f20808f;
    }

    public static CharSequence u(CharSequence charSequence) {
        if (charSequence == null) {
            return null;
        }
        String[] strArrSplit = TextUtils.split(String.valueOf(charSequence), "\n");
        return strArrSplit.length > 1 ? strArrSplit[0] : charSequence;
    }

    public static int x(Context context) throws Resources.NotFoundException {
        Resources resources = context.getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(R$dimen.mtrl_calendar_content_padding);
        int i10 = Month.current().daysInWeek;
        return (dimensionPixelOffset * 2) + (resources.getDimensionPixelSize(R$dimen.mtrl_calendar_day_width) * i10) + ((i10 - 1) * resources.getDimensionPixelOffset(R$dimen.mtrl_calendar_month_horizontal_padding));
    }

    public final void A(Context context) {
        this.f20827y.setTag(f20798G);
        this.f20827y.setImageDrawable(r(context));
        this.f20827y.setChecked(this.f20816n != 0);
        N.i0(this.f20827y, null);
        K(this.f20827y);
        this.f20827y.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.material.datepicker.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                m.o(this.f20795a, view);
            }
        });
    }

    public final boolean C() {
        return getResources().getConfiguration().orientation == 2;
    }

    public void E(View view) {
        Iterator<View.OnClickListener> it = this.f20804b.iterator();
        while (it.hasNext()) {
            it.next().onClick(view);
        }
        dismiss();
    }

    public void F(View view) {
        Iterator<n<? super S>> it = this.f20803a.iterator();
        while (it.hasNext()) {
            it.next().a(y());
        }
        dismiss();
    }

    public final void H() {
        int iZ = z(requireContext());
        o oVarI = MaterialCalendar.I(t(), iZ, this.f20810h, this.f20811i);
        this.f20812j = oVarI;
        if (this.f20816n == 1) {
            oVarI = o.q(t(), iZ, this.f20810h);
        }
        this.f20809g = oVarI;
        J();
        I(w());
        K kQ = getChildFragmentManager().q();
        kQ.p(R$id.mtrl_calendar_frame, this.f20809g);
        kQ.i();
        this.f20809g.o(new b());
    }

    public void I(String str) {
        this.f20826x.setContentDescription(v());
        this.f20826x.setText(str);
    }

    public final void J() {
        this.f20825w.setText((this.f20816n == 1 && C()) ? this.f20802D : this.f20801C);
    }

    public final void K(CheckableImageButton checkableImageButton) {
        this.f20827y.setContentDescription(this.f20816n == 1 ? checkableImageButton.getContext().getString(R$string.mtrl_picker_toggle_to_calendar_input_mode) : checkableImageButton.getContext().getString(R$string.mtrl_picker_toggle_to_text_input_mode));
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC1374l, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        Iterator<DialogInterface.OnCancelListener> it = this.f20805c.iterator();
        while (it.hasNext()) {
            it.next().onCancel(dialogInterface);
        }
        super.onCancel(dialogInterface);
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC1374l, androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) throws Resources.NotFoundException {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.f20807e = bundle.getInt("OVERRIDE_THEME_RES_ID");
        this.f20808f = (DateSelector) bundle.getParcelable("DATE_SELECTOR_KEY");
        this.f20810h = (CalendarConstraints) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.f20811i = (DayViewDecorator) bundle.getParcelable("DAY_VIEW_DECORATOR_KEY");
        this.f20813k = bundle.getInt("TITLE_TEXT_RES_ID_KEY");
        this.f20814l = bundle.getCharSequence("TITLE_TEXT_KEY");
        this.f20816n = bundle.getInt("INPUT_MODE_KEY");
        this.f20817o = bundle.getInt("POSITIVE_BUTTON_TEXT_RES_ID_KEY");
        this.f20818p = bundle.getCharSequence("POSITIVE_BUTTON_TEXT_KEY");
        this.f20819q = bundle.getInt("POSITIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY");
        this.f20820r = bundle.getCharSequence("POSITIVE_BUTTON_CONTENT_DESCRIPTION_KEY");
        this.f20821s = bundle.getInt("NEGATIVE_BUTTON_TEXT_RES_ID_KEY");
        this.f20822t = bundle.getCharSequence("NEGATIVE_BUTTON_TEXT_KEY");
        this.f20823u = bundle.getInt("NEGATIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY");
        this.f20824v = bundle.getCharSequence("NEGATIVE_BUTTON_CONTENT_DESCRIPTION_KEY");
        CharSequence text = this.f20814l;
        if (text == null) {
            text = requireContext().getResources().getText(this.f20813k);
        }
        this.f20801C = text;
        this.f20802D = u(text);
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC1374l
    public final Dialog onCreateDialog(Bundle bundle) {
        Dialog dialog = new Dialog(requireContext(), z(requireContext()));
        Context context = dialog.getContext();
        this.f20815m = B(context);
        int i10 = R$attr.materialCalendarStyle;
        int i11 = R$style.Widget_MaterialComponents_MaterialCalendar;
        this.f20828z = new Z2.h(context, null, i10, i11);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, R$styleable.MaterialCalendar, i10, i11);
        int color = typedArrayObtainStyledAttributes.getColor(R$styleable.MaterialCalendar_backgroundTint, 0);
        typedArrayObtainStyledAttributes.recycle();
        this.f20828z.U(context);
        this.f20828z.g0(ColorStateList.valueOf(color));
        this.f20828z.f0(dialog.getWindow().getDecorView().getElevation());
        return dialog;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(this.f20815m ? R$layout.mtrl_picker_fullscreen : R$layout.mtrl_picker_dialog, viewGroup);
        Context context = viewInflate.getContext();
        DayViewDecorator dayViewDecorator = this.f20811i;
        if (dayViewDecorator != null) {
            dayViewDecorator.initialize(context);
        }
        if (this.f20815m) {
            viewInflate.findViewById(R$id.mtrl_calendar_frame).setLayoutParams(new LinearLayout.LayoutParams(x(context), -2));
        } else {
            viewInflate.findViewById(R$id.mtrl_calendar_main_pane).setLayoutParams(new LinearLayout.LayoutParams(x(context), -1));
        }
        TextView textView = (TextView) viewInflate.findViewById(R$id.mtrl_picker_header_selection_text);
        this.f20826x = textView;
        textView.setAccessibilityLiveRegion(1);
        this.f20827y = (CheckableImageButton) viewInflate.findViewById(R$id.mtrl_picker_header_toggle);
        this.f20825w = (TextView) viewInflate.findViewById(R$id.mtrl_picker_title_text);
        A(context);
        this.f20799A = (Button) viewInflate.findViewById(R$id.confirm_button);
        if (t().isSelectionComplete()) {
            this.f20799A.setEnabled(true);
        } else {
            this.f20799A.setEnabled(false);
        }
        this.f20799A.setTag(f20796E);
        CharSequence charSequence = this.f20818p;
        if (charSequence != null) {
            this.f20799A.setText(charSequence);
        } else {
            int i10 = this.f20817o;
            if (i10 != 0) {
                this.f20799A.setText(i10);
            }
        }
        CharSequence charSequence2 = this.f20820r;
        if (charSequence2 != null) {
            this.f20799A.setContentDescription(charSequence2);
        } else if (this.f20819q != 0) {
            this.f20799A.setContentDescription(getContext().getResources().getText(this.f20819q));
        }
        this.f20799A.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.material.datepicker.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f20793a.F(view);
            }
        });
        Button button = (Button) viewInflate.findViewById(R$id.cancel_button);
        button.setTag(f20797F);
        CharSequence charSequence3 = this.f20822t;
        if (charSequence3 != null) {
            button.setText(charSequence3);
        } else {
            int i11 = this.f20821s;
            if (i11 != 0) {
                button.setText(i11);
            }
        }
        CharSequence charSequence4 = this.f20824v;
        if (charSequence4 != null) {
            button.setContentDescription(charSequence4);
        } else if (this.f20823u != 0) {
            button.setContentDescription(getContext().getResources().getText(this.f20823u));
        }
        button.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.material.datepicker.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f20794a.E(view);
            }
        });
        return viewInflate;
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC1374l, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        Iterator<DialogInterface.OnDismissListener> it = this.f20806d.iterator();
        while (it.hasNext()) {
            it.next().onDismiss(dialogInterface);
        }
        ViewGroup viewGroup = (ViewGroup) getView();
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        super.onDismiss(dialogInterface);
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC1374l, androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("OVERRIDE_THEME_RES_ID", this.f20807e);
        bundle.putParcelable("DATE_SELECTOR_KEY", this.f20808f);
        CalendarConstraints.b bVar = new CalendarConstraints.b(this.f20810h);
        MaterialCalendar<S> materialCalendar = this.f20812j;
        Month monthD = materialCalendar == null ? null : materialCalendar.D();
        if (monthD != null) {
            bVar.b(monthD.timeInMillis);
        }
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", bVar.a());
        bundle.putParcelable("DAY_VIEW_DECORATOR_KEY", this.f20811i);
        bundle.putInt("TITLE_TEXT_RES_ID_KEY", this.f20813k);
        bundle.putCharSequence("TITLE_TEXT_KEY", this.f20814l);
        bundle.putInt("INPUT_MODE_KEY", this.f20816n);
        bundle.putInt("POSITIVE_BUTTON_TEXT_RES_ID_KEY", this.f20817o);
        bundle.putCharSequence("POSITIVE_BUTTON_TEXT_KEY", this.f20818p);
        bundle.putInt("POSITIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY", this.f20819q);
        bundle.putCharSequence("POSITIVE_BUTTON_CONTENT_DESCRIPTION_KEY", this.f20820r);
        bundle.putInt("NEGATIVE_BUTTON_TEXT_RES_ID_KEY", this.f20821s);
        bundle.putCharSequence("NEGATIVE_BUTTON_TEXT_KEY", this.f20822t);
        bundle.putInt("NEGATIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY", this.f20823u);
        bundle.putCharSequence("NEGATIVE_BUTTON_CONTENT_DESCRIPTION_KEY", this.f20824v);
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC1374l, androidx.fragment.app.Fragment
    public void onStart() throws Resources.NotFoundException {
        super.onStart();
        Window window = requireDialog().getWindow();
        if (this.f20815m) {
            window.setLayout(-1, -1);
            window.setBackgroundDrawable(this.f20828z);
            s(window);
        } else {
            window.setLayout(-2, -2);
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(R$dimen.mtrl_calendar_dialog_background_inset);
            Rect rect = new Rect(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
            window.setBackgroundDrawable(new InsetDrawable((Drawable) this.f20828z, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset));
            window.getDecorView().setOnTouchListener(new N2.a(requireDialog(), rect));
        }
        H();
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC1374l, androidx.fragment.app.Fragment
    public void onStop() {
        this.f20809g.p();
        super.onStop();
    }

    public final void s(Window window) {
        if (this.f20800B) {
            return;
        }
        View viewFindViewById = requireView().findViewById(R$id.fullscreen_header);
        com.google.android.material.internal.d.a(window, true, com.google.android.material.internal.u.d(viewFindViewById), null);
        int paddingTop = viewFindViewById.getPaddingTop();
        N.u0(viewFindViewById, new a(viewFindViewById.getLayoutParams().height, viewFindViewById, viewFindViewById.getPaddingLeft(), paddingTop, viewFindViewById.getPaddingRight()));
        this.f20800B = true;
    }

    public final String v() {
        return t().getSelectionContentDescription(requireContext());
    }

    public String w() {
        return t().getSelectionDisplayString(getContext());
    }

    public final S y() {
        return t().getSelection();
    }

    public final int z(Context context) {
        int i10 = this.f20807e;
        return i10 != 0 ? i10 : t().getDefaultThemeResId(context);
    }
}
