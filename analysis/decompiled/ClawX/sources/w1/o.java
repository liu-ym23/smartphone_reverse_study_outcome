package w1;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;
import com.stepos.stepclaw.R;
import g.g0;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class o extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    public final TextInputLayout f6118a;

    /* renamed from: b, reason: collision with root package name */
    public final FrameLayout f6119b;

    /* renamed from: c, reason: collision with root package name */
    public final CheckableImageButton f6120c;
    public ColorStateList d;

    /* renamed from: e, reason: collision with root package name */
    public PorterDuff.Mode f6121e;

    /* renamed from: f, reason: collision with root package name */
    public View.OnLongClickListener f6122f;

    /* renamed from: g, reason: collision with root package name */
    public final CheckableImageButton f6123g;

    /* renamed from: h, reason: collision with root package name */
    public final i1.d f6124h;

    /* renamed from: j, reason: collision with root package name */
    public int f6125j;

    /* renamed from: k, reason: collision with root package name */
    public final LinkedHashSet f6126k;

    /* renamed from: l, reason: collision with root package name */
    public ColorStateList f6127l;

    /* renamed from: m, reason: collision with root package name */
    public PorterDuff.Mode f6128m;

    /* renamed from: n, reason: collision with root package name */
    public int f6129n;

    /* renamed from: o, reason: collision with root package name */
    public ImageView.ScaleType f6130o;

    /* renamed from: p, reason: collision with root package name */
    public View.OnLongClickListener f6131p;

    /* renamed from: q, reason: collision with root package name */
    public CharSequence f6132q;

    /* renamed from: r, reason: collision with root package name */
    public final g0 f6133r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f6134s;

    /* renamed from: t, reason: collision with root package name */
    public EditText f6135t;

    /* renamed from: u, reason: collision with root package name */
    public final AccessibilityManager f6136u;

    /* renamed from: v, reason: collision with root package name */
    public AccessibilityManager.TouchExplorationStateChangeListener f6137v;

    /* renamed from: w, reason: collision with root package name */
    public final m f6138w;

    public o(TextInputLayout textInputLayout, a4.d dVar) {
        CharSequence text;
        super(textInputLayout.getContext());
        this.f6125j = 0;
        this.f6126k = new LinkedHashSet();
        this.f6138w = new m(this);
        n nVar = new n(this);
        this.f6136u = (AccessibilityManager) getContext().getSystemService("accessibility");
        this.f6118a = textInputLayout;
        setVisibility(8);
        setOrientation(0);
        setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 8388613));
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.f6119b = frameLayout;
        frameLayout.setVisibility(8);
        frameLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(getContext());
        CheckableImageButton checkableImageButtonA = a(this, layoutInflaterFrom, R.id.text_input_error_icon);
        this.f6120c = checkableImageButtonA;
        CheckableImageButton checkableImageButtonA2 = a(frameLayout, layoutInflaterFrom, R.id.text_input_end_icon);
        this.f6123g = checkableImageButtonA2;
        this.f6124h = new i1.d(this, dVar);
        g0 g0Var = new g0(getContext(), null);
        this.f6133r = g0Var;
        TypedArray typedArray = (TypedArray) dVar.f97c;
        if (typedArray.hasValue(38)) {
            this.d = k4.v.C(getContext(), dVar, 38);
        }
        if (typedArray.hasValue(39)) {
            this.f6121e = p1.k.f(typedArray.getInt(39, -1), null);
        }
        if (typedArray.hasValue(37)) {
            i(dVar.t(37));
        }
        checkableImageButtonA.setContentDescription(getResources().getText(R.string.error_icon_content_description));
        checkableImageButtonA.setImportantForAccessibility(2);
        checkableImageButtonA.setClickable(false);
        checkableImageButtonA.setPressable(false);
        checkableImageButtonA.setCheckable(false);
        checkableImageButtonA.setFocusable(false);
        if (!typedArray.hasValue(54)) {
            if (typedArray.hasValue(32)) {
                this.f6127l = k4.v.C(getContext(), dVar, 32);
            }
            if (typedArray.hasValue(33)) {
                this.f6128m = p1.k.f(typedArray.getInt(33, -1), null);
            }
        }
        if (typedArray.hasValue(30)) {
            g(typedArray.getInt(30, 0));
            if (typedArray.hasValue(27) && checkableImageButtonA2.getContentDescription() != (text = typedArray.getText(27))) {
                checkableImageButtonA2.setContentDescription(text);
            }
            checkableImageButtonA2.setCheckable(typedArray.getBoolean(26, true));
        } else if (typedArray.hasValue(54)) {
            if (typedArray.hasValue(55)) {
                this.f6127l = k4.v.C(getContext(), dVar, 55);
            }
            if (typedArray.hasValue(56)) {
                this.f6128m = p1.k.f(typedArray.getInt(56, -1), null);
            }
            g(typedArray.getBoolean(54, false) ? 1 : 0);
            CharSequence text2 = typedArray.getText(52);
            if (checkableImageButtonA2.getContentDescription() != text2) {
                checkableImageButtonA2.setContentDescription(text2);
            }
        }
        int dimensionPixelSize = typedArray.getDimensionPixelSize(29, getResources().getDimensionPixelSize(R.dimen.mtrl_min_touch_target_size));
        if (dimensionPixelSize < 0) {
            throw new IllegalArgumentException("endIconSize cannot be less than 0");
        }
        if (dimensionPixelSize != this.f6129n) {
            this.f6129n = dimensionPixelSize;
            checkableImageButtonA2.setMinimumWidth(dimensionPixelSize);
            checkableImageButtonA2.setMinimumHeight(dimensionPixelSize);
            checkableImageButtonA.setMinimumWidth(dimensionPixelSize);
            checkableImageButtonA.setMinimumHeight(dimensionPixelSize);
        }
        if (typedArray.hasValue(31)) {
            ImageView.ScaleType scaleTypeT = k4.v.t(typedArray.getInt(31, -1));
            this.f6130o = scaleTypeT;
            checkableImageButtonA2.setScaleType(scaleTypeT);
            checkableImageButtonA.setScaleType(scaleTypeT);
        }
        g0Var.setVisibility(8);
        g0Var.setId(R.id.textinput_suffix_text);
        g0Var.setLayoutParams(new LinearLayout.LayoutParams(-2, -2, 80.0f));
        g0Var.setAccessibilityLiveRegion(1);
        g0Var.setTextAppearance(typedArray.getResourceId(73, 0));
        if (typedArray.hasValue(74)) {
            g0Var.setTextColor(dVar.s(74));
        }
        CharSequence text3 = typedArray.getText(72);
        this.f6132q = TextUtils.isEmpty(text3) ? null : text3;
        g0Var.setText(text3);
        n();
        frameLayout.addView(checkableImageButtonA2);
        addView(g0Var);
        addView(frameLayout);
        addView(checkableImageButtonA);
        textInputLayout.f1364g0.add(nVar);
        if (textInputLayout.f1359e != null) {
            nVar.a(textInputLayout);
        }
        addOnAttachStateChangeListener(new f.d(4, this));
    }

    public final CheckableImageButton a(ViewGroup viewGroup, LayoutInflater layoutInflater, int i8) {
        CheckableImageButton checkableImageButton = (CheckableImageButton) layoutInflater.inflate(R.layout.design_text_input_end_icon, viewGroup, false);
        checkableImageButton.setId(i8);
        if (k4.v.W(getContext())) {
            ((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams()).setMarginStart(0);
        }
        return checkableImageButton;
    }

    public final p b() {
        p fVar;
        int i8 = this.f6125j;
        i1.d dVar = this.f6124h;
        SparseArray sparseArray = (SparseArray) dVar.f3136c;
        p pVar = (p) sparseArray.get(i8);
        if (pVar != null) {
            return pVar;
        }
        o oVar = (o) dVar.d;
        if (i8 == -1) {
            fVar = new f(oVar, 0);
        } else if (i8 == 0) {
            fVar = new f(oVar, 1);
        } else if (i8 == 1) {
            fVar = new s(oVar, dVar.f3135b);
        } else if (i8 == 2) {
            fVar = new e(oVar);
        } else {
            if (i8 != 3) {
                throw new IllegalArgumentException(a8.b.j(i8, "Invalid end icon mode: "));
            }
            fVar = new l(oVar);
        }
        sparseArray.append(i8, fVar);
        return fVar;
    }

    public final int c() {
        int marginStart;
        if (d() || e()) {
            CheckableImageButton checkableImageButton = this.f6123g;
            marginStart = ((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams()).getMarginStart() + checkableImageButton.getMeasuredWidth();
        } else {
            marginStart = 0;
        }
        return this.f6133r.getPaddingEnd() + getPaddingEnd() + marginStart;
    }

    public final boolean d() {
        return this.f6119b.getVisibility() == 0 && this.f6123g.getVisibility() == 0;
    }

    public final boolean e() {
        return this.f6120c.getVisibility() == 0;
    }

    public final void f(boolean z) {
        boolean z2;
        boolean zIsActivated;
        boolean z8;
        p pVarB = b();
        boolean zJ = pVarB.j();
        CheckableImageButton checkableImageButton = this.f6123g;
        boolean z9 = true;
        if (!zJ || (z8 = checkableImageButton.d) == pVarB.k()) {
            z2 = false;
        } else {
            checkableImageButton.setChecked(!z8);
            z2 = true;
        }
        if (!(pVarB instanceof l) || (zIsActivated = checkableImageButton.isActivated()) == ((l) pVarB).f6109l) {
            z9 = z2;
        } else {
            checkableImageButton.setActivated(!zIsActivated);
        }
        if (z || z9) {
            k4.v.f0(this.f6118a, checkableImageButton, this.f6127l);
        }
    }

    public final void g(int i8) {
        if (this.f6125j == i8) {
            return;
        }
        p pVarB = b();
        AccessibilityManager.TouchExplorationStateChangeListener touchExplorationStateChangeListener = this.f6137v;
        AccessibilityManager accessibilityManager = this.f6136u;
        if (touchExplorationStateChangeListener != null && accessibilityManager != null) {
            accessibilityManager.removeTouchExplorationStateChangeListener(touchExplorationStateChangeListener);
        }
        this.f6137v = null;
        pVarB.r();
        this.f6125j = i8;
        Iterator it = this.f6126k.iterator();
        if (it.hasNext()) {
            it.next().getClass();
            throw new ClassCastException();
        }
        h(i8 != 0);
        p pVarB2 = b();
        int iD = this.f6124h.f3134a;
        if (iD == 0) {
            iD = pVarB2.d();
        }
        Drawable drawableP = iD != 0 ? b8.h.p(getContext(), iD) : null;
        CheckableImageButton checkableImageButton = this.f6123g;
        checkableImageButton.setImageDrawable(drawableP);
        TextInputLayout textInputLayout = this.f6118a;
        if (drawableP != null) {
            k4.v.e(textInputLayout, checkableImageButton, this.f6127l, this.f6128m);
            k4.v.f0(textInputLayout, checkableImageButton, this.f6127l);
        }
        int iC = pVarB2.c();
        CharSequence text = iC != 0 ? getResources().getText(iC) : null;
        if (checkableImageButton.getContentDescription() != text) {
            checkableImageButton.setContentDescription(text);
        }
        checkableImageButton.setCheckable(pVarB2.j());
        if (!pVarB2.i(textInputLayout.getBoxBackgroundMode())) {
            throw new IllegalStateException("The current box background mode " + textInputLayout.getBoxBackgroundMode() + " is not supported by the end icon mode " + i8);
        }
        pVarB2.q();
        AccessibilityManager.TouchExplorationStateChangeListener touchExplorationStateChangeListenerH = pVarB2.h();
        this.f6137v = touchExplorationStateChangeListenerH;
        if (touchExplorationStateChangeListenerH != null && accessibilityManager != null && isAttachedToWindow()) {
            accessibilityManager.addTouchExplorationStateChangeListener(this.f6137v);
        }
        View.OnClickListener onClickListenerF = pVarB2.f();
        View.OnLongClickListener onLongClickListener = this.f6131p;
        checkableImageButton.setOnClickListener(onClickListenerF);
        k4.v.k0(checkableImageButton, onLongClickListener);
        EditText editText = this.f6135t;
        if (editText != null) {
            pVarB2.l(editText);
            j(pVarB2);
        }
        k4.v.e(textInputLayout, checkableImageButton, this.f6127l, this.f6128m);
        f(true);
    }

    public final void h(boolean z) {
        if (d() != z) {
            this.f6123g.setVisibility(z ? 0 : 8);
            k();
            m();
            this.f6118a.s();
        }
    }

    public final void i(Drawable drawable) {
        CheckableImageButton checkableImageButton = this.f6120c;
        checkableImageButton.setImageDrawable(drawable);
        l();
        k4.v.e(this.f6118a, checkableImageButton, this.d, this.f6121e);
    }

    public final void j(p pVar) {
        if (this.f6135t == null) {
            return;
        }
        if (pVar.e() != null) {
            this.f6135t.setOnFocusChangeListener(pVar.e());
        }
        if (pVar.g() != null) {
            this.f6123g.setOnFocusChangeListener(pVar.g());
        }
    }

    public final void k() {
        this.f6119b.setVisibility((this.f6123g.getVisibility() != 0 || e()) ? 8 : 0);
        setVisibility((d() || e() || !((this.f6132q == null || this.f6134s) ? 8 : false)) ? 0 : 8);
    }

    public final void l() {
        CheckableImageButton checkableImageButton = this.f6120c;
        Drawable drawable = checkableImageButton.getDrawable();
        TextInputLayout textInputLayout = this.f6118a;
        checkableImageButton.setVisibility((drawable != null && textInputLayout.f1371l.f6158q && textInputLayout.o()) ? 0 : 8);
        k();
        m();
        if (this.f6125j != 0) {
            return;
        }
        textInputLayout.s();
    }

    public final void m() {
        TextInputLayout textInputLayout = this.f6118a;
        if (textInputLayout.f1359e == null) {
            return;
        }
        this.f6133r.setPaddingRelative(getContext().getResources().getDimensionPixelSize(R.dimen.material_input_text_to_prefix_suffix_padding), textInputLayout.f1359e.getPaddingTop(), (d() || e()) ? 0 : textInputLayout.f1359e.getPaddingEnd(), textInputLayout.f1359e.getPaddingBottom());
    }

    public final void n() {
        g0 g0Var = this.f6133r;
        int visibility = g0Var.getVisibility();
        int i8 = (this.f6132q == null || this.f6134s) ? 8 : 0;
        if (visibility != i8) {
            b().o(i8 == 0);
        }
        k();
        g0Var.setVisibility(i8);
        this.f6118a.s();
    }
}
