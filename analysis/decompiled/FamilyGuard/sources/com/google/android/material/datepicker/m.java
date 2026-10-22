package com.google.android.material.datepicker;

import a1.C0409b;
import a1.C0411d;
import a1.C0412e;
import a1.C0413f;
import a1.C0415h;
import a1.C0416i;
import a1.C0417j;
import a1.C0418k;
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
import androidx.core.view.H;
import androidx.core.view.InterfaceC0479y;
import androidx.core.view.Y;
import androidx.fragment.app.DialogInterfaceOnCancelListenerC0510e;
import androidx.fragment.app.G;
import com.google.android.material.datepicker.a;
import com.google.android.material.internal.CheckableImageButton;
import h.C0744a;
import java.util.Iterator;
import java.util.LinkedHashSet;
import k1.ViewOnTouchListenerC0796a;
import q1.C0980b;
import t1.C1115h;

/* loaded from: classes.dex */
public class m<S> extends DialogInterfaceOnCancelListenerC0510e {

    /* renamed from: Z0, reason: collision with root package name */
    static final Object f12723Z0 = "CONFIRM_BUTTON_TAG";

    /* renamed from: a1, reason: collision with root package name */
    static final Object f12724a1 = "CANCEL_BUTTON_TAG";

    /* renamed from: b1, reason: collision with root package name */
    static final Object f12725b1 = "TOGGLE_BUTTON_TAG";

    /* renamed from: A0, reason: collision with root package name */
    private d<S> f12726A0;

    /* renamed from: B0, reason: collision with root package name */
    private t<S> f12727B0;

    /* renamed from: C0, reason: collision with root package name */
    private com.google.android.material.datepicker.a f12728C0;

    /* renamed from: D0, reason: collision with root package name */
    private g f12729D0;

    /* renamed from: E0, reason: collision with root package name */
    private i<S> f12730E0;

    /* renamed from: F0, reason: collision with root package name */
    private int f12731F0;

    /* renamed from: G0, reason: collision with root package name */
    private CharSequence f12732G0;

    /* renamed from: H0, reason: collision with root package name */
    private boolean f12733H0;

    /* renamed from: I0, reason: collision with root package name */
    private int f12734I0;

    /* renamed from: J0, reason: collision with root package name */
    private int f12735J0;

    /* renamed from: K0, reason: collision with root package name */
    private CharSequence f12736K0;

    /* renamed from: L0, reason: collision with root package name */
    private int f12737L0;

    /* renamed from: M0, reason: collision with root package name */
    private CharSequence f12738M0;

    /* renamed from: N0, reason: collision with root package name */
    private int f12739N0;

    /* renamed from: O0, reason: collision with root package name */
    private CharSequence f12740O0;

    /* renamed from: P0, reason: collision with root package name */
    private int f12741P0;

    /* renamed from: Q0, reason: collision with root package name */
    private CharSequence f12742Q0;

    /* renamed from: R0, reason: collision with root package name */
    private TextView f12743R0;

    /* renamed from: S0, reason: collision with root package name */
    private TextView f12744S0;

    /* renamed from: T0, reason: collision with root package name */
    private CheckableImageButton f12745T0;

    /* renamed from: U0, reason: collision with root package name */
    private C1115h f12746U0;

    /* renamed from: V0, reason: collision with root package name */
    private Button f12747V0;

    /* renamed from: W0, reason: collision with root package name */
    private boolean f12748W0;

    /* renamed from: X0, reason: collision with root package name */
    private CharSequence f12749X0;

    /* renamed from: Y0, reason: collision with root package name */
    private CharSequence f12750Y0;

    /* renamed from: v0, reason: collision with root package name */
    private final LinkedHashSet<n<? super S>> f12751v0 = new LinkedHashSet<>();

    /* renamed from: w0, reason: collision with root package name */
    private final LinkedHashSet<View.OnClickListener> f12752w0 = new LinkedHashSet<>();

    /* renamed from: x0, reason: collision with root package name */
    private final LinkedHashSet<DialogInterface.OnCancelListener> f12753x0 = new LinkedHashSet<>();

    /* renamed from: y0, reason: collision with root package name */
    private final LinkedHashSet<DialogInterface.OnDismissListener> f12754y0 = new LinkedHashSet<>();

    /* renamed from: z0, reason: collision with root package name */
    private int f12755z0;

    class a implements InterfaceC0479y {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f12756a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f12757b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f12758c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f12759d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f12760e;

        a(int i5, View view, int i6, int i7, int i8) {
            this.f12756a = i5;
            this.f12757b = view;
            this.f12758c = i6;
            this.f12759d = i7;
            this.f12760e = i8;
        }

        @Override // androidx.core.view.InterfaceC0479y
        public Y a(View view, Y y5) {
            androidx.core.graphics.b bVarF = y5.f(Y.l.f());
            if (this.f12756a >= 0) {
                this.f12757b.getLayoutParams().height = this.f12756a + bVarF.f9643b;
                View view2 = this.f12757b;
                view2.setLayoutParams(view2.getLayoutParams());
            }
            View view3 = this.f12757b;
            view3.setPadding(this.f12758c + bVarF.f9642a, this.f12759d + bVarF.f9643b, this.f12760e + bVarF.f9644c, view3.getPaddingBottom());
            return y5;
        }
    }

    class b extends s<S> {
        b() {
        }

        @Override // com.google.android.material.datepicker.s
        public void a(S s5) {
            m mVar = m.this;
            mVar.C2(mVar.q2());
            m.this.f12747V0.setEnabled(m.this.n2().t());
        }
    }

    static boolean A2(Context context, int i5) throws Resources.NotFoundException {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(C0980b.f(context, C0409b.f6730q, i.class.getCanonicalName()), new int[]{i5});
        boolean z5 = typedArrayObtainStyledAttributes.getBoolean(0, false);
        typedArrayObtainStyledAttributes.recycle();
        return z5;
    }

    private void B2() {
        int iT2 = t2(A1());
        o oVarO2 = i.o2(n2(), iT2, this.f12728C0, this.f12729D0);
        this.f12730E0 = oVarO2;
        if (this.f12734I0 == 1) {
            oVarO2 = o.W1(n2(), iT2, this.f12728C0);
        }
        this.f12727B0 = oVarO2;
        D2();
        C2(q2());
        G gM = v().m();
        gM.s(C0413f.f6861x, this.f12727B0);
        gM.k();
        this.f12727B0.U1(new b());
    }

    private void D2() {
        this.f12743R0.setText((this.f12734I0 == 1 && w2()) ? this.f12750Y0 : this.f12749X0);
    }

    private void E2(CheckableImageButton checkableImageButton) {
        this.f12745T0.setContentDescription(this.f12734I0 == 1 ? checkableImageButton.getContext().getString(C0416i.f6902r) : checkableImageButton.getContext().getString(C0416i.f6904t));
    }

    public static /* synthetic */ void i2(m mVar, View view) {
        mVar.f12747V0.setEnabled(mVar.n2().t());
        mVar.f12745T0.toggle();
        mVar.f12734I0 = mVar.f12734I0 == 1 ? 0 : 1;
        mVar.E2(mVar.f12745T0);
        mVar.B2();
    }

    private static Drawable l2(Context context) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_checked}, C0744a.b(context, C0412e.f6810d));
        stateListDrawable.addState(new int[0], C0744a.b(context, C0412e.f6811e));
        return stateListDrawable;
    }

    private void m2(Window window) {
        if (this.f12748W0) {
            return;
        }
        View viewFindViewById = B1().findViewById(C0413f.f6844g);
        com.google.android.material.internal.d.a(window, true, com.google.android.material.internal.r.d(viewFindViewById), null);
        int paddingTop = viewFindViewById.getPaddingTop();
        H.w0(viewFindViewById, new a(viewFindViewById.getLayoutParams().height, viewFindViewById, viewFindViewById.getPaddingLeft(), paddingTop, viewFindViewById.getPaddingRight()));
        this.f12748W0 = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public d<S> n2() {
        if (this.f12726A0 == null) {
            this.f12726A0 = (d) u().getParcelable("DATE_SELECTOR_KEY");
        }
        return this.f12726A0;
    }

    private static CharSequence o2(CharSequence charSequence) {
        if (charSequence == null) {
            return null;
        }
        String[] strArrSplit = TextUtils.split(String.valueOf(charSequence), "\n");
        return strArrSplit.length > 1 ? strArrSplit[0] : charSequence;
    }

    private String p2() {
        return n2().o(A1());
    }

    private static int r2(Context context) throws Resources.NotFoundException {
        Resources resources = context.getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(C0411d.f6762Q);
        int i5 = p.I().f12770d;
        return (dimensionPixelOffset * 2) + (resources.getDimensionPixelSize(C0411d.f6764S) * i5) + ((i5 - 1) * resources.getDimensionPixelOffset(C0411d.f6767V));
    }

    private int t2(Context context) {
        int i5 = this.f12755z0;
        return i5 != 0 ? i5 : n2().q(context);
    }

    private void u2(Context context) {
        this.f12745T0.setTag(f12725b1);
        this.f12745T0.setImageDrawable(l2(context));
        this.f12745T0.setChecked(this.f12734I0 != 0);
        H.k0(this.f12745T0, null);
        E2(this.f12745T0);
        this.f12745T0.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.material.datepicker.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                m.i2(this.f12722a, view);
            }
        });
    }

    static boolean v2(Context context) {
        return A2(context, R.attr.windowFullscreen);
    }

    private boolean w2() {
        return Q().getConfiguration().orientation == 2;
    }

    static boolean x2(Context context) {
        return A2(context, C0409b.f6700J);
    }

    void C2(String str) {
        this.f12744S0.setContentDescription(p2());
        this.f12744S0.setText(str);
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0510e, androidx.fragment.app.ComponentCallbacksC0511f
    public final void R0(Bundle bundle) {
        super.R0(bundle);
        bundle.putInt("OVERRIDE_THEME_RES_ID", this.f12755z0);
        bundle.putParcelable("DATE_SELECTOR_KEY", this.f12726A0);
        a.b bVar = new a.b(this.f12728C0);
        i<S> iVar = this.f12730E0;
        p pVarJ2 = iVar == null ? null : iVar.j2();
        if (pVarJ2 != null) {
            bVar.b(pVarJ2.f12772f);
        }
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", bVar.a());
        bundle.putParcelable("DAY_VIEW_DECORATOR_KEY", this.f12729D0);
        bundle.putInt("TITLE_TEXT_RES_ID_KEY", this.f12731F0);
        bundle.putCharSequence("TITLE_TEXT_KEY", this.f12732G0);
        bundle.putInt("INPUT_MODE_KEY", this.f12734I0);
        bundle.putInt("POSITIVE_BUTTON_TEXT_RES_ID_KEY", this.f12735J0);
        bundle.putCharSequence("POSITIVE_BUTTON_TEXT_KEY", this.f12736K0);
        bundle.putInt("POSITIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY", this.f12737L0);
        bundle.putCharSequence("POSITIVE_BUTTON_CONTENT_DESCRIPTION_KEY", this.f12738M0);
        bundle.putInt("NEGATIVE_BUTTON_TEXT_RES_ID_KEY", this.f12739N0);
        bundle.putCharSequence("NEGATIVE_BUTTON_TEXT_KEY", this.f12740O0);
        bundle.putInt("NEGATIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY", this.f12741P0);
        bundle.putCharSequence("NEGATIVE_BUTTON_CONTENT_DESCRIPTION_KEY", this.f12742Q0);
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0510e, androidx.fragment.app.ComponentCallbacksC0511f
    public void S0() throws Resources.NotFoundException {
        super.S0();
        Window window = f2().getWindow();
        if (this.f12733H0) {
            window.setLayout(-1, -1);
            window.setBackgroundDrawable(this.f12746U0);
            m2(window);
        } else {
            window.setLayout(-2, -2);
            int dimensionPixelOffset = Q().getDimensionPixelOffset(C0411d.f6766U);
            Rect rect = new Rect(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
            window.setBackgroundDrawable(new InsetDrawable((Drawable) this.f12746U0, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset));
            window.getDecorView().setOnTouchListener(new ViewOnTouchListenerC0796a(f2(), rect));
        }
        B2();
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0510e, androidx.fragment.app.ComponentCallbacksC0511f
    public void T0() {
        this.f12727B0.V1();
        super.T0();
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0510e
    public final Dialog b2(Bundle bundle) {
        Dialog dialog = new Dialog(A1(), t2(A1()));
        Context context = dialog.getContext();
        this.f12733H0 = v2(context);
        int i5 = C0409b.f6730q;
        int i6 = C0417j.f6931v;
        this.f12746U0 = new C1115h(context, null, i5, i6);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, C0418k.f7237x2, i5, i6);
        int color = typedArrayObtainStyledAttributes.getColor(C0418k.f7243y2, 0);
        typedArrayObtainStyledAttributes.recycle();
        this.f12746U0.U(context);
        this.f12746U0.g0(ColorStateList.valueOf(color));
        this.f12746U0.f0(dialog.getWindow().getDecorView().getElevation());
        return dialog;
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0510e, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        Iterator<DialogInterface.OnCancelListener> it = this.f12753x0.iterator();
        while (it.hasNext()) {
            it.next().onCancel(dialogInterface);
        }
        super.onCancel(dialogInterface);
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0510e, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        Iterator<DialogInterface.OnDismissListener> it = this.f12754y0.iterator();
        while (it.hasNext()) {
            it.next().onDismiss(dialogInterface);
        }
        ViewGroup viewGroup = (ViewGroup) a0();
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        super.onDismiss(dialogInterface);
    }

    public String q2() {
        return n2().b(w());
    }

    public final S s2() {
        return n2().w();
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0510e, androidx.fragment.app.ComponentCallbacksC0511f
    public final void v0(Bundle bundle) throws Resources.NotFoundException {
        super.v0(bundle);
        if (bundle == null) {
            bundle = u();
        }
        this.f12755z0 = bundle.getInt("OVERRIDE_THEME_RES_ID");
        this.f12726A0 = (d) bundle.getParcelable("DATE_SELECTOR_KEY");
        this.f12728C0 = (com.google.android.material.datepicker.a) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.f12729D0 = (g) bundle.getParcelable("DAY_VIEW_DECORATOR_KEY");
        this.f12731F0 = bundle.getInt("TITLE_TEXT_RES_ID_KEY");
        this.f12732G0 = bundle.getCharSequence("TITLE_TEXT_KEY");
        this.f12734I0 = bundle.getInt("INPUT_MODE_KEY");
        this.f12735J0 = bundle.getInt("POSITIVE_BUTTON_TEXT_RES_ID_KEY");
        this.f12736K0 = bundle.getCharSequence("POSITIVE_BUTTON_TEXT_KEY");
        this.f12737L0 = bundle.getInt("POSITIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY");
        this.f12738M0 = bundle.getCharSequence("POSITIVE_BUTTON_CONTENT_DESCRIPTION_KEY");
        this.f12739N0 = bundle.getInt("NEGATIVE_BUTTON_TEXT_RES_ID_KEY");
        this.f12740O0 = bundle.getCharSequence("NEGATIVE_BUTTON_TEXT_KEY");
        this.f12741P0 = bundle.getInt("NEGATIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY");
        this.f12742Q0 = bundle.getCharSequence("NEGATIVE_BUTTON_CONTENT_DESCRIPTION_KEY");
        CharSequence text = this.f12732G0;
        if (text == null) {
            text = A1().getResources().getText(this.f12731F0);
        }
        this.f12749X0 = text;
        this.f12750Y0 = o2(text);
    }

    public void y2(View view) {
        Iterator<View.OnClickListener> it = this.f12752w0.iterator();
        while (it.hasNext()) {
            it.next().onClick(view);
        }
        X1();
    }

    @Override // androidx.fragment.app.ComponentCallbacksC0511f
    public final View z0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(this.f12733H0 ? C0415h.f6884r : C0415h.f6883q, viewGroup);
        Context context = viewInflate.getContext();
        g gVar = this.f12729D0;
        if (gVar != null) {
            gVar.G(context);
        }
        if (this.f12733H0) {
            viewInflate.findViewById(C0413f.f6861x).setLayoutParams(new LinearLayout.LayoutParams(r2(context), -2));
        } else {
            viewInflate.findViewById(C0413f.f6862y).setLayoutParams(new LinearLayout.LayoutParams(r2(context), -1));
        }
        TextView textView = (TextView) viewInflate.findViewById(C0413f.f6821D);
        this.f12744S0 = textView;
        textView.setAccessibilityLiveRegion(1);
        this.f12745T0 = (CheckableImageButton) viewInflate.findViewById(C0413f.f6822E);
        this.f12743R0 = (TextView) viewInflate.findViewById(C0413f.f6823F);
        u2(context);
        this.f12747V0 = (Button) viewInflate.findViewById(C0413f.f6841d);
        if (n2().t()) {
            this.f12747V0.setEnabled(true);
        } else {
            this.f12747V0.setEnabled(false);
        }
        this.f12747V0.setTag(f12723Z0);
        CharSequence charSequence = this.f12736K0;
        if (charSequence != null) {
            this.f12747V0.setText(charSequence);
        } else {
            int i5 = this.f12735J0;
            if (i5 != 0) {
                this.f12747V0.setText(i5);
            }
        }
        CharSequence charSequence2 = this.f12738M0;
        if (charSequence2 != null) {
            this.f12747V0.setContentDescription(charSequence2);
        } else if (this.f12737L0 != 0) {
            this.f12747V0.setContentDescription(w().getResources().getText(this.f12737L0));
        }
        this.f12747V0.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.material.datepicker.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f12720a.z2(view);
            }
        });
        Button button = (Button) viewInflate.findViewById(C0413f.f6838a);
        button.setTag(f12724a1);
        CharSequence charSequence3 = this.f12740O0;
        if (charSequence3 != null) {
            button.setText(charSequence3);
        } else {
            int i6 = this.f12739N0;
            if (i6 != 0) {
                button.setText(i6);
            }
        }
        CharSequence charSequence4 = this.f12742Q0;
        if (charSequence4 != null) {
            button.setContentDescription(charSequence4);
        } else if (this.f12741P0 != 0) {
            button.setContentDescription(w().getResources().getText(this.f12741P0));
        }
        button.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.material.datepicker.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f12721a.y2(view);
            }
        });
        return viewInflate;
    }

    public void z2(View view) {
        Iterator<n<? super S>> it = this.f12751v0.iterator();
        while (it.hasNext()) {
            it.next().a(s2());
        }
        X1();
    }
}
