package A6;

import D7.q;
import D7.v;
import D7.w;
import H4.o;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Message;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.WindowMetrics;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import androidx.core.widget.TextViewCompat;
import com.stepos.ability.R;
import com.stepos.motionkit.fx.material.GlassEffect;
import com.stepos.widget.button.StepOSButton;
import com.stepos.widget.dialog.StepOSAlertDialogLayout;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import w6.AbstractC2104a;

/* loaded from: classes3.dex */
public final class f {

    /* renamed from: A, reason: collision with root package name */
    public CharSequence f114A;

    /* renamed from: B, reason: collision with root package name */
    public Message f115B;

    /* renamed from: C, reason: collision with root package name */
    public int f116C;

    /* renamed from: D, reason: collision with root package name */
    public int f117D;

    /* renamed from: I, reason: collision with root package name */
    public int f121I;

    /* renamed from: K, reason: collision with root package name */
    public final GlassEffect f123K;

    /* renamed from: L, reason: collision with root package name */
    public final int f124L;

    /* renamed from: M, reason: collision with root package name */
    public final int f125M;

    /* renamed from: N, reason: collision with root package name */
    public final int f126N;

    /* renamed from: O, reason: collision with root package name */
    public final int f127O;

    /* renamed from: P, reason: collision with root package name */
    public final int f128P;

    /* renamed from: Q, reason: collision with root package name */
    public final int f129Q;

    /* renamed from: R, reason: collision with root package name */
    public final int f130R;

    /* renamed from: S, reason: collision with root package name */
    public final int f131S;

    /* renamed from: T, reason: collision with root package name */
    public final int f132T;

    /* renamed from: U, reason: collision with root package name */
    public final int f133U;

    /* renamed from: V, reason: collision with root package name */
    public final c f134V;

    /* renamed from: a, reason: collision with root package name */
    public final Context f136a;
    public final g b;
    public final Window c;
    public final int d;
    public final boolean e;
    public final boolean f;
    public final int g;
    public final int h;
    public final int i;

    /* renamed from: j, reason: collision with root package name */
    public final int f137j;
    public CharSequence k;
    public CharSequence l;
    public boolean m;
    public boolean n;
    public View o;
    public TextView p;

    /* renamed from: q, reason: collision with root package name */
    public TextView f138q;

    /* renamed from: r, reason: collision with root package name */
    public NestedScrollView f139r;

    /* renamed from: t, reason: collision with root package name */
    public StepOSButton f141t;
    public CharSequence u;

    /* renamed from: v, reason: collision with root package name */
    public Message f142v;

    /* renamed from: w, reason: collision with root package name */
    public StepOSButton f143w;

    /* renamed from: x, reason: collision with root package name */
    public CharSequence f144x;
    public Message y;

    /* renamed from: z, reason: collision with root package name */
    public StepOSButton f145z;

    /* renamed from: s, reason: collision with root package name */
    public final int f140s = -1;
    public int E = 1;

    /* renamed from: F, reason: collision with root package name */
    public boolean f118F = true;

    /* renamed from: G, reason: collision with root package name */
    public int f119G = 2;

    /* renamed from: H, reason: collision with root package name */
    public int f120H = 2;

    /* renamed from: J, reason: collision with root package name */
    public boolean f122J = true;

    /* renamed from: W, reason: collision with root package name */
    public final b f135W = new b(this, 0);

    public f(Context context, g gVar, Window window) throws Resources.NotFoundException {
        this.f136a = context;
        this.b = gVar;
        this.c = window;
        this.f134V = new c(gVar);
        Resources resources = context.getResources();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, AbstractC2104a.f6852a, R.attr.steposAlertDialogStyle, R.style.StepOSWidget_AlertDialog);
        kotlin.jvm.internal.k.e(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
        try {
            this.d = typedArrayObtainStyledAttributes.getResourceId(8, R.layout.stepos_dialog_alert);
            typedArrayObtainStyledAttributes.getResourceId(10, R.layout.stepos_dialog_select_list);
            typedArrayObtainStyledAttributes.getResourceId(9, R.layout.stepos_dialog_select_item);
            typedArrayObtainStyledAttributes.getResourceId(15, R.layout.stepos_dialog_select_item_single);
            typedArrayObtainStyledAttributes.getResourceId(11, R.layout.stepos_dialog_select_item_multi);
            typedArrayObtainStyledAttributes.getResourceId(2, R.layout.stepos_dialog_select_item_center);
            typedArrayObtainStyledAttributes.getResourceId(12, R.layout.stepos_dialog_select_recycler);
            typedArrayObtainStyledAttributes.getResourceId(13, R.layout.stepos_dialog_multi_line_item);
            typedArrayObtainStyledAttributes.getResourceId(14, R.layout.stepos_dialog_multi_line_item_single);
            typedArrayObtainStyledAttributes.getDimensionPixelSize(1, resources.getDimensionPixelSize(R.dimen.stepos_dialog_button_icon_size));
            this.e = typedArrayObtainStyledAttributes.getBoolean(0, false);
            this.f = typedArrayObtainStyledAttributes.getBoolean(3, false);
            this.g = typedArrayObtainStyledAttributes.getDimensionPixelSize(7, 0);
            this.h = typedArrayObtainStyledAttributes.getDimensionPixelSize(6, 0);
            this.i = typedArrayObtainStyledAttributes.getDimensionPixelSize(5, 0);
            this.f137j = typedArrayObtainStyledAttributes.getDimensionPixelSize(4, 0);
            GlassEffect glassEffectA = D6.g.a(typedArrayObtainStyledAttributes, 16);
            if (!kotlin.jvm.internal.k.b(this.f123K, glassEffectA)) {
                this.f123K = glassEffectA;
                StepOSAlertDialogLayout stepOSAlertDialogLayout = (StepOSAlertDialogLayout) window.findViewById(R.id.stepos_dialog_parent_panel);
                if (stepOSAlertDialogLayout != null) {
                    stepOSAlertDialogLayout.setGlassEffect(glassEffectA);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
            int dimensionPixelOffset = resources.getDimensionPixelOffset(R.dimen.stepos_dialog_margin_screen);
            this.f125M = resources.getDimensionPixelOffset(R.dimen.stepos_dialog_margin_screen_bottom);
            this.f126N = resources.getDimensionPixelOffset(R.dimen.stepos_dialog_padding_horizontal);
            this.f127O = resources.getDimensionPixelOffset(R.dimen.stepos_dialog_padding_top);
            this.f128P = resources.getDimensionPixelOffset(R.dimen.stepos_dialog_padding_bottom);
            this.f129Q = resources.getDimensionPixelOffset(R.dimen.stepos_dialog_section_gap);
            this.f130R = resources.getDimensionPixelOffset(R.dimen.stepos_dialog_space_message_custom);
            this.f131S = resources.getDimensionPixelOffset(R.dimen.stepos_dialog_button_spacing);
            this.f132T = resources.getDimensionPixelOffset(R.dimen.stepos_dialog_button_padding_horizontal);
            this.f133U = resources.getDimensionPixelOffset(R.dimen.stepos_dialog_button_height);
            resources.getDimensionPixelOffset(R.dimen.stepos_dialog_list_item_spacing);
            resources.getDimensionPixelOffset(R.dimen.stepos_dialog_list_choice_padding);
            int iWidth = ((WindowManager) context.getSystemService(WindowManager.class)).getCurrentWindowMetrics().getBounds().width() - (dimensionPixelOffset * 2);
            this.f124L = iWidth >= 1 ? iWidth : 1;
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    public static void c(View view) {
        NestedScrollView nestedScrollView = view instanceof NestedScrollView ? (NestedScrollView) view : null;
        if (nestedScrollView == null) {
            return;
        }
        nestedScrollView.setVerticalScrollBarEnabled(false);
        nestedScrollView.setHorizontalScrollBarEnabled(false);
    }

    public static ViewGroup g(View view, View view2) {
        if (view == null) {
            if (view2 instanceof ViewStub) {
                view2 = ((ViewStub) view2).inflate();
            }
            if (view2 instanceof ViewGroup) {
                return (ViewGroup) view2;
            }
        } else {
            ViewParent parent = view2 != null ? view2.getParent() : null;
            ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (viewGroup != null) {
                viewGroup.removeView(view2);
            }
            if (view instanceof ViewStub) {
                view = ((ViewStub) view).inflate();
            }
            if (view instanceof ViewGroup) {
                return (ViewGroup) view;
            }
        }
        return null;
    }

    public final void a() {
        Window window = this.c;
        WindowManager.LayoutParams attributes = window.getAttributes();
        boolean z10 = (attributes.gravity & 112) == 80;
        View view = this.o;
        boolean z11 = view != null && o.s(view);
        if (z10) {
            attributes.setFitInsetsTypes(WindowInsets.Type.statusBars() | WindowInsets.Type.captionBar() | WindowInsets.Type.displayCutout() | (z11 ? WindowInsets.Type.ime() : 0));
            attributes.setFitInsetsIgnoringVisibility(false);
        }
        attributes.softInputMode = (z10 ? 16 : 48) | ((this.f118F && z11) ? 5 : 3);
        window.setAttributes(attributes);
        StepOSAlertDialogLayout stepOSAlertDialogLayout = (StepOSAlertDialogLayout) window.findViewById(R.id.stepos_dialog_parent_panel);
        if (stepOSAlertDialogLayout != null) {
            stepOSAlertDialogLayout.setBottomWindowMargin$StepOSWidget_release(z10 ? this.f125M : 0);
            stepOSAlertDialogLayout.setFitInputMethod$StepOSWidget_release(z10 && z11);
            stepOSAlertDialogLayout.requestLayout();
        }
    }

    public final int b() {
        WindowMetrics currentWindowMetrics;
        Context context = this.f136a;
        kotlin.jvm.internal.k.f(context, "context");
        WindowManager windowManager = (WindowManager) context.getSystemService(WindowManager.class);
        return (int) ((((windowManager == null || (currentWindowMetrics = windowManager.getCurrentWindowMetrics()) == null) ? null : currentWindowMetrics.getBounds()) != null ? r0.height() : context.getResources().getDisplayMetrics().heightPixels) * 0.6d);
    }

    public final void d() {
        if (this.f141t == null) {
            return;
        }
        i((ViewGroup) this.c.findViewById(R.id.stepos_dialog_button_panel));
        f();
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x014a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void e() {
        /*
            Method dump skipped, instructions count: 501
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: A6.f.e():void");
    }

    public final void f() {
        View viewFindViewById = this.c.findViewById(R.id.stepos_dialog_parent_panel);
        if (viewFindViewById == null) {
            return;
        }
        View viewFindViewById2 = viewFindViewById.findViewById(R.id.stepos_dialog_middle_panel);
        View viewFindViewById3 = viewFindViewById.findViewById(R.id.stepos_dialog_content_panel);
        View viewFindViewById4 = viewFindViewById.findViewById(R.id.stepos_dialog_custom_panel);
        if (viewFindViewById2 != null) {
            viewFindViewById2.setVisibility(((viewFindViewById3 == null || viewFindViewById3.getVisibility() != 0) && (viewFindViewById4 == null || viewFindViewById4.getVisibility() != 0)) ? 8 : 0);
        }
        j(viewFindViewById, viewFindViewById.findViewById(R.id.stepos_dialog_top_panel), viewFindViewById2, viewFindViewById3, viewFindViewById4, viewFindViewById.findViewById(R.id.stepos_dialog_button_panel));
    }

    public final void h(int i, CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        Message messageObtainMessage = onClickListener != null ? this.f134V.obtainMessage(i, onClickListener) : null;
        if (i == -3) {
            this.f114A = charSequence;
            this.f115B = messageObtainMessage;
        } else if (i == -2) {
            this.f144x = charSequence;
            this.y = messageObtainMessage;
        } else {
            if (i != -1) {
                throw new IllegalArgumentException(B7.a.h(i, "whichButton must be one of DialogInterface.BUTTON_POSITIVE / BUTTON_NEGATIVE / BUTTON_NEUTRAL but was "));
            }
            this.u = charSequence;
            this.f142v = messageObtainMessage;
        }
        d();
    }

    public final void i(ViewGroup viewGroup) {
        int i;
        int iMax;
        boolean z10;
        CharSequence transformation;
        if (viewGroup == null) {
            return;
        }
        StepOSButton stepOSButton = (StepOSButton) viewGroup.findViewById(R.id.stepos_dialog_button_positive);
        this.f141t = stepOSButton;
        b bVar = this.f135W;
        stepOSButton.setOnClickListener(bVar);
        int i6 = 1;
        if (TextUtils.isEmpty(this.u)) {
            stepOSButton.setVisibility(8);
            i = 0;
        } else {
            stepOSButton.setText(this.u);
            TextViewCompat.setCompoundDrawablesRelative(stepOSButton, null, null, null, null);
            stepOSButton.setVisibility(0);
            i = 1;
        }
        StepOSButton stepOSButton2 = (StepOSButton) viewGroup.findViewById(R.id.stepos_dialog_button_negative);
        this.f143w = stepOSButton2;
        stepOSButton2.setOnClickListener(bVar);
        if (TextUtils.isEmpty(this.f144x)) {
            stepOSButton2.setVisibility(8);
        } else {
            stepOSButton2.setText(this.f144x);
            TextViewCompat.setCompoundDrawablesRelative(stepOSButton2, null, null, null, null);
            stepOSButton2.setVisibility(0);
            i |= 2;
        }
        StepOSButton stepOSButton3 = (StepOSButton) viewGroup.findViewById(R.id.stepos_dialog_button_neutral);
        this.f145z = stepOSButton3;
        stepOSButton3.setOnClickListener(bVar);
        if (TextUtils.isEmpty(this.f114A)) {
            stepOSButton3.setVisibility(8);
        } else {
            stepOSButton3.setText(this.f114A);
            TextViewCompat.setCompoundDrawablesRelative(stepOSButton3, null, null, null, null);
            stepOSButton3.setVisibility(0);
            i |= 4;
        }
        if (i == 0) {
            viewGroup.setVisibility(8);
            return;
        }
        viewGroup.setVisibility(0);
        ViewParent parent = stepOSButton3.getParent();
        ConstraintLayout constraintLayout = parent instanceof ConstraintLayout ? (ConstraintLayout) parent : null;
        if (constraintLayout == null) {
            return;
        }
        int i10 = this.f117D;
        int i11 = i10 != -3 ? i10 != -2 ? i10 != -1 ? 0 : 1 : 2 : 4;
        if (i11 == 0 || (i & i11) == 0) {
            i11 = (i & 1) != 0 ? 1 : (i & 4) != 0 ? 4 : (i & 2) != 0 ? 2 : 0;
        }
        int i12 = i & 7;
        int iBitCount = Integer.bitCount(i12);
        int iBitCount2 = Integer.bitCount(i12);
        int i13 = this.f124L - (this.f126N * 2);
        int i14 = this.f131S;
        if (iBitCount2 != 0) {
            i13 = (i13 - ((iBitCount2 - 1) * i14)) / iBitCount2;
        }
        int i15 = this.f132T;
        int i16 = i15 * 2;
        int i17 = i13 - i16;
        boolean z11 = false;
        List<Pair> listN = o.N(new Pair(this.f141t, this.u), new Pair(this.f143w, this.f144x), new Pair(this.f145z, this.f114A));
        char c = '\n';
        if ((listN instanceof Collection) && listN.isEmpty()) {
            z10 = false;
        } else {
            for (Pair pair : listN) {
                StepOSButton stepOSButton4 = (StepOSButton) pair.f4886a;
                CharSequence charSequence = (CharSequence) pair.b;
                if (stepOSButton4 != null && stepOSButton4.getVisibility() == 0) {
                    if (charSequence == null || charSequence.length() == 0) {
                        iMax = 0;
                    } else {
                        TransformationMethod transformationMethod = stepOSButton4.getTransformationMethod();
                        if (transformationMethod != null && (transformation = transformationMethod.getTransformation(charSequence, stepOSButton4)) != null) {
                            charSequence = transformation;
                        }
                        String string = charSequence.toString();
                        char[] cArr = new char[i6];
                        cArr[0] = c;
                        Iterator it = j9.m.E0(string, cArr).iterator();
                        iMax = 0;
                        while (it.hasNext()) {
                            iMax = Math.max(iMax, (int) stepOSButton4.getPaint().measureText((String) it.next()));
                        }
                    }
                    if (stepOSButton4.getCompoundPaddingEnd() + stepOSButton4.getCompoundPaddingStart() + iMax > i16 + i17) {
                        z10 = true;
                        break;
                    }
                }
                i6 = 1;
                c = '\n';
            }
            z10 = false;
        }
        int i18 = this.f121I;
        if (iBitCount < 0 || iBitCount >= 4) {
            throw new IllegalArgumentException(B7.a.h(iBitCount, "button count must be in 0..3 but was ").toString());
        }
        if (i18 < 0 || i18 >= 3) {
            throw new IllegalArgumentException("buttonLayout must be AUTO(0), HORIZONTAL(1) or VERTICAL(2)");
        }
        boolean z12 = iBitCount != 0 && (iBitCount == 1 || iBitCount == 3 || (i18 != 1 && (i18 == 2 || z10 || this.e)));
        List<StepOSButton> listN2 = o.N(stepOSButton, stepOSButton3, stepOSButton2);
        StepOSButton stepOSButton5 = stepOSButton.getVisibility() == 0 ? stepOSButton : null;
        if (stepOSButton3.getVisibility() != 0) {
            stepOSButton3 = null;
        }
        StepOSButton stepOSButton6 = stepOSButton2.getVisibility() == 0 ? stepOSButton2 : null;
        ArrayList arrayListJ0 = q.j0(new Object[]{stepOSButton6, stepOSButton3, stepOSButton5});
        if (z12 && (arrayListJ0.size() == 3 || stepOSButton5 == null)) {
            arrayListJ0 = q.j0(new Object[]{stepOSButton5, stepOSButton3, stepOSButton6});
        }
        ConstraintSet constraintSet = new ConstraintSet();
        for (StepOSButton stepOSButton7 : listN2) {
            boolean z13 = z11;
            constraintSet.constrainWidth(stepOSButton7.getId(), z13 ? 1 : 0);
            constraintSet.constrainHeight(stepOSButton7.getId(), this.f133U);
            constraintSet.setVisibility(stepOSButton7.getId(), stepOSButton7.getVisibility());
            stepOSButton7.setMinimumWidth(z13 ? 1 : 0);
            stepOSButton7.setMinimumHeight(z13 ? 1 : 0);
            stepOSButton7.setGravity(17);
            stepOSButton7.setPaddingRelative(i15, z13 ? 1 : 0, i15, z13 ? 1 : 0);
            boolean z14 = (stepOSButton7.equals(stepOSButton) ? 1 : stepOSButton7.equals(stepOSButton2) ? 2 : 4) == i11 ? true : z13 ? 1 : 0;
            stepOSButton7.setGlassEnabled(z13);
            Context context = this.f136a;
            stepOSButton7.setSurfaceDrawable(ContextCompat.getDrawable(context, R.drawable.stepos_bg_button_secondary));
            stepOSButton7.setTextColor(ContextCompat.getColorStateList(context, R.color.stepos_button_secondary_text_color));
            if (z14) {
                int i19 = this.E;
                if (i19 == 1) {
                    stepOSButton7.setSurfaceDrawable(ContextCompat.getDrawable(context, R.drawable.stepos_bg_button_blue));
                    stepOSButton7.setTextColor(ContextCompat.getColorStateList(context, R.color.stepos_button_blue_text_color));
                } else if (i19 == 2) {
                    stepOSButton7.setTextColor(ContextCompat.getColorStateList(context, R.color.stepos_button_secondary_destructive_text_color));
                }
            }
            z11 = false;
        }
        int i20 = 0;
        for (Object obj : arrayListJ0) {
            int i21 = i20 + 1;
            if (i20 < 0) {
                o.X();
                throw null;
            }
            StepOSButton stepOSButton8 = (StepOSButton) obj;
            StepOSButton stepOSButton9 = (StepOSButton) v.D0(i20 - 1, arrayListJ0);
            ConstraintSet constraintSet2 = constraintSet;
            constraintSet2.connect(stepOSButton8.getId(), 3, (!z12 || stepOSButton9 == null) ? 0 : stepOSButton9.getId(), (!z12 || stepOSButton9 == null) ? 3 : 4, (!z12 || stepOSButton9 == null) ? 0 : i14);
            if (z12) {
                constraintSet2.connect(stepOSButton8.getId(), 6, 0, 6);
                constraintSet2.connect(stepOSButton8.getId(), 7, 0, 7);
            }
            i20 = i21;
            constraintSet = constraintSet2;
        }
        ConstraintSet constraintSet3 = constraintSet;
        if (!z12) {
            ArrayList arrayList = new ArrayList(w.c0(arrayListJ0, 10));
            Iterator it2 = arrayListJ0.iterator();
            while (it2.hasNext()) {
                arrayList.add(Integer.valueOf(((StepOSButton) it2.next()).getId()));
            }
            int[] iArrE1 = v.e1(arrayList);
            int size = arrayListJ0.size();
            float[] fArr = new float[size];
            for (int i22 = 0; i22 < size; i22++) {
                fArr[i22] = 1.0f;
            }
            constraintSet3.createHorizontalChainRtl(0, 6, 0, 7, iArrE1, fArr, 0);
            Iterator it3 = v.w0(arrayListJ0, 1).iterator();
            while (it3.hasNext()) {
                constraintSet3.setMargin(((StepOSButton) it3.next()).getId(), 6, i14);
            }
        }
        constraintSet3.applyTo(constraintLayout);
    }

    public final void j(View view, View view2, View view3, View view4, View view5, View view6) {
        int i;
        int i6;
        int i10;
        int i11;
        int i12 = 0;
        boolean z10 = view2 != null && view2.getVisibility() == 0;
        boolean z11 = view3 != null && view3.getVisibility() == 0;
        boolean z12 = view6 != null && view6.getVisibility() == 0;
        boolean z13 = view4 != null && view4.getVisibility() == 0;
        boolean z14 = view5 != null && view5.getVisibility() == 0;
        if (this.f) {
            i = (z10 && (z11 || z12)) ? this.h : 0;
            i6 = (z11 && z12) ? this.i : 0;
            i10 = this.g;
            i11 = this.f137j;
        } else {
            int i13 = this.f129Q;
            i = (z10 && (z11 || z12)) ? i13 : 0;
            i6 = (z11 && z12) ? i13 : 0;
            i10 = this.f127O;
            i11 = this.f128P;
        }
        int i14 = this.f126N;
        view.setPaddingRelative(i14, i10, i14, i11);
        ViewGroup.LayoutParams layoutParams = view2 != null ? view2.getLayoutParams() : null;
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams != null && marginLayoutParams.bottomMargin != i) {
            marginLayoutParams.bottomMargin = i;
            view2.setLayoutParams(marginLayoutParams);
        }
        ViewGroup.LayoutParams layoutParams2 = view3 != null ? view3.getLayoutParams() : null;
        ViewGroup.MarginLayoutParams marginLayoutParams2 = layoutParams2 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams2 : null;
        if (marginLayoutParams2 != null && marginLayoutParams2.bottomMargin != i6) {
            marginLayoutParams2.bottomMargin = i6;
            view3.setLayoutParams(marginLayoutParams2);
        }
        if (z13 && z14) {
            i12 = this.f130R;
        }
        ViewGroup.LayoutParams layoutParams3 = view5 != null ? view5.getLayoutParams() : null;
        ViewGroup.MarginLayoutParams marginLayoutParams3 = layoutParams3 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams3 : null;
        if (marginLayoutParams3 == null || marginLayoutParams3.topMargin == i12) {
            return;
        }
        marginLayoutParams3.topMargin = i12;
        view5.setLayoutParams(marginLayoutParams3);
    }
}
