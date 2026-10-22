package com.google.android.material.textfield;

import android.content.res.ColorStateList;
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
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.view.GravityCompat;
import androidx.core.widget.TextViewCompat;
import c3.AbstractC0873c;
import ca.AbstractC0897f;
import com.google.android.material.internal.CheckableImageButton;
import com.stepos.ability.R;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* loaded from: classes3.dex */
public final class m extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    public final TextInputLayout f2675a;
    public final FrameLayout b;
    public final CheckableImageButton c;
    public ColorStateList d;
    public PorterDuff.Mode e;
    public View.OnLongClickListener f;
    public final CheckableImageButton g;
    public final A0.d h;
    public int i;

    /* renamed from: j, reason: collision with root package name */
    public final LinkedHashSet f2676j;
    public ColorStateList k;
    public PorterDuff.Mode l;
    public int m;
    public ImageView.ScaleType n;
    public View.OnLongClickListener o;
    public CharSequence p;

    /* renamed from: q, reason: collision with root package name */
    public final AppCompatTextView f2677q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f2678r;

    /* renamed from: s, reason: collision with root package name */
    public EditText f2679s;

    /* renamed from: t, reason: collision with root package name */
    public final AccessibilityManager f2680t;
    public AccessibilityManager.TouchExplorationStateChangeListener u;

    /* renamed from: v, reason: collision with root package name */
    public final k f2681v;

    public m(TextInputLayout textInputLayout, TintTypedArray tintTypedArray) {
        CharSequence text;
        super(textInputLayout.getContext());
        this.i = 0;
        this.f2676j = new LinkedHashSet();
        this.f2681v = new k(this);
        l lVar = new l(this);
        this.f2680t = (AccessibilityManager) getContext().getSystemService("accessibility");
        this.f2675a = textInputLayout;
        setVisibility(8);
        setOrientation(0);
        setLayoutParams(new FrameLayout.LayoutParams(-2, -1, GravityCompat.END));
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.b = frameLayout;
        frameLayout.setVisibility(8);
        frameLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(getContext());
        CheckableImageButton checkableImageButtonA = a(this, layoutInflaterFrom, R.id.text_input_error_icon);
        this.c = checkableImageButtonA;
        CheckableImageButton checkableImageButtonA2 = a(frameLayout, layoutInflaterFrom, R.id.text_input_end_icon);
        this.g = checkableImageButtonA2;
        A0.d dVar = new A0.d();
        dVar.c = new SparseArray();
        dVar.d = this;
        dVar.f70a = tintTypedArray.getResourceId(28, 0);
        dVar.b = tintTypedArray.getResourceId(53, 0);
        this.h = dVar;
        AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
        this.f2677q = appCompatTextView;
        if (tintTypedArray.hasValue(38)) {
            this.d = AbstractC0873c.b(getContext(), tintTypedArray, 38);
        }
        if (tintTypedArray.hasValue(39)) {
            this.e = com.google.android.material.internal.o.b(tintTypedArray.getInt(39, -1), null);
        }
        if (tintTypedArray.hasValue(37)) {
            i(tintTypedArray.getDrawable(37));
        }
        checkableImageButtonA.setContentDescription(getResources().getText(R.string.error_icon_content_description));
        checkableImageButtonA.setImportantForAccessibility(2);
        checkableImageButtonA.setClickable(false);
        checkableImageButtonA.setPressable(false);
        checkableImageButtonA.setCheckable(false);
        checkableImageButtonA.setFocusable(false);
        if (!tintTypedArray.hasValue(54)) {
            if (tintTypedArray.hasValue(32)) {
                this.k = AbstractC0873c.b(getContext(), tintTypedArray, 32);
            }
            if (tintTypedArray.hasValue(33)) {
                this.l = com.google.android.material.internal.o.b(tintTypedArray.getInt(33, -1), null);
            }
        }
        if (tintTypedArray.hasValue(30)) {
            g(tintTypedArray.getInt(30, 0));
            if (tintTypedArray.hasValue(27) && checkableImageButtonA2.getContentDescription() != (text = tintTypedArray.getText(27))) {
                checkableImageButtonA2.setContentDescription(text);
            }
            checkableImageButtonA2.setCheckable(tintTypedArray.getBoolean(26, true));
        } else if (tintTypedArray.hasValue(54)) {
            if (tintTypedArray.hasValue(55)) {
                this.k = AbstractC0873c.b(getContext(), tintTypedArray, 55);
            }
            if (tintTypedArray.hasValue(56)) {
                this.l = com.google.android.material.internal.o.b(tintTypedArray.getInt(56, -1), null);
            }
            g(tintTypedArray.getBoolean(54, false) ? 1 : 0);
            CharSequence text2 = tintTypedArray.getText(52);
            if (checkableImageButtonA2.getContentDescription() != text2) {
                checkableImageButtonA2.setContentDescription(text2);
            }
        }
        int dimensionPixelSize = tintTypedArray.getDimensionPixelSize(29, getResources().getDimensionPixelSize(R.dimen.mtrl_min_touch_target_size));
        if (dimensionPixelSize < 0) {
            throw new IllegalArgumentException("endIconSize cannot be less than 0");
        }
        if (dimensionPixelSize != this.m) {
            this.m = dimensionPixelSize;
            checkableImageButtonA2.setMinimumWidth(dimensionPixelSize);
            checkableImageButtonA2.setMinimumHeight(dimensionPixelSize);
            checkableImageButtonA.setMinimumWidth(dimensionPixelSize);
            checkableImageButtonA.setMinimumHeight(dimensionPixelSize);
        }
        if (tintTypedArray.hasValue(31)) {
            ImageView.ScaleType scaleTypeT = AbstractC0897f.t(tintTypedArray.getInt(31, -1));
            this.n = scaleTypeT;
            checkableImageButtonA2.setScaleType(scaleTypeT);
            checkableImageButtonA.setScaleType(scaleTypeT);
        }
        appCompatTextView.setVisibility(8);
        appCompatTextView.setId(R.id.textinput_suffix_text);
        appCompatTextView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2, 80.0f));
        appCompatTextView.setAccessibilityLiveRegion(1);
        TextViewCompat.setTextAppearance(appCompatTextView, tintTypedArray.getResourceId(73, 0));
        if (tintTypedArray.hasValue(74)) {
            appCompatTextView.setTextColor(tintTypedArray.getColorStateList(74));
        }
        CharSequence text3 = tintTypedArray.getText(72);
        this.p = TextUtils.isEmpty(text3) ? null : text3;
        appCompatTextView.setText(text3);
        n();
        frameLayout.addView(checkableImageButtonA2);
        addView(appCompatTextView);
        addView(frameLayout);
        addView(checkableImageButtonA);
        textInputLayout.f2638j0.add(lVar);
        if (textInputLayout.e != null) {
            lVar.a(textInputLayout);
        }
        addOnAttachStateChangeListener(new D6.e(this, 5));
    }

    public final CheckableImageButton a(ViewGroup viewGroup, LayoutInflater layoutInflater, int i) {
        CheckableImageButton checkableImageButton = (CheckableImageButton) layoutInflater.inflate(R.layout.design_text_input_end_icon, viewGroup, false);
        checkableImageButton.setId(i);
        if (AbstractC0873c.d(getContext())) {
            ((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams()).setMarginStart(0);
        }
        return checkableImageButton;
    }

    public final n b() {
        n dVar;
        int i = this.i;
        A0.d dVar2 = this.h;
        SparseArray sparseArray = (SparseArray) dVar2.c;
        n nVar = (n) sparseArray.get(i);
        if (nVar != null) {
            return nVar;
        }
        m mVar = (m) dVar2.d;
        if (i == -1) {
            dVar = new d(mVar, 0);
        } else if (i == 0) {
            dVar = new d(mVar, 1);
        } else if (i == 1) {
            dVar = new t(mVar, dVar2.b);
        } else if (i == 2) {
            dVar = new c(mVar);
        } else {
            if (i != 3) {
                throw new IllegalArgumentException(B7.a.h(i, "Invalid end icon mode: "));
            }
            dVar = new j(mVar);
        }
        sparseArray.append(i, dVar);
        return dVar;
    }

    public final int c() {
        int marginStart;
        if (d() || e()) {
            CheckableImageButton checkableImageButton = this.g;
            marginStart = ((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams()).getMarginStart() + checkableImageButton.getMeasuredWidth();
        } else {
            marginStart = 0;
        }
        return this.f2677q.getPaddingEnd() + getPaddingEnd() + marginStart;
    }

    public final boolean d() {
        return this.b.getVisibility() == 0 && this.g.getVisibility() == 0;
    }

    public final boolean e() {
        return this.c.getVisibility() == 0;
    }

    public final void f(boolean z10) {
        boolean z11;
        boolean zIsActivated;
        boolean z12;
        n nVarB = b();
        boolean zK = nVarB.k();
        CheckableImageButton checkableImageButton = this.g;
        boolean z13 = true;
        if (!zK || (z12 = checkableImageButton.f2445a) == nVarB.l()) {
            z11 = false;
        } else {
            checkableImageButton.setChecked(!z12);
            z11 = true;
        }
        if (!(nVarB instanceof j) || (zIsActivated = checkableImageButton.isActivated()) == nVarB.j()) {
            z13 = z11;
        } else {
            checkableImageButton.setActivated(!zIsActivated);
        }
        if (z10 || z13) {
            AbstractC0897f.I(this.f2675a, checkableImageButton, this.k);
        }
    }

    public final void g(int i) {
        if (this.i == i) {
            return;
        }
        n nVarB = b();
        AccessibilityManager.TouchExplorationStateChangeListener touchExplorationStateChangeListener = this.u;
        AccessibilityManager accessibilityManager = this.f2680t;
        if (touchExplorationStateChangeListener != null && accessibilityManager != null) {
            accessibilityManager.removeTouchExplorationStateChangeListener(touchExplorationStateChangeListener);
        }
        this.u = null;
        nVarB.s();
        this.i = i;
        Iterator it = this.f2676j.iterator();
        if (it.hasNext()) {
            throw B7.a.f(it);
        }
        h(i != 0);
        n nVarB2 = b();
        int iD = this.h.f70a;
        if (iD == 0) {
            iD = nVarB2.d();
        }
        Drawable drawable = iD != 0 ? AppCompatResources.getDrawable(getContext(), iD) : null;
        CheckableImageButton checkableImageButton = this.g;
        checkableImageButton.setImageDrawable(drawable);
        TextInputLayout textInputLayout = this.f2675a;
        if (drawable != null) {
            AbstractC0897f.m(textInputLayout, checkableImageButton, this.k, this.l);
            AbstractC0897f.I(textInputLayout, checkableImageButton, this.k);
        }
        int iC = nVarB2.c();
        CharSequence text = iC != 0 ? getResources().getText(iC) : null;
        if (checkableImageButton.getContentDescription() != text) {
            checkableImageButton.setContentDescription(text);
        }
        checkableImageButton.setCheckable(nVarB2.k());
        if (!nVarB2.i(textInputLayout.getBoxBackgroundMode())) {
            throw new IllegalStateException("The current box background mode " + textInputLayout.getBoxBackgroundMode() + " is not supported by the end icon mode " + i);
        }
        nVarB2.r();
        AccessibilityManager.TouchExplorationStateChangeListener touchExplorationStateChangeListenerH = nVarB2.h();
        this.u = touchExplorationStateChangeListenerH;
        if (touchExplorationStateChangeListenerH != null && accessibilityManager != null && isAttachedToWindow()) {
            accessibilityManager.addTouchExplorationStateChangeListener(this.u);
        }
        View.OnClickListener onClickListenerF = nVarB2.f();
        View.OnLongClickListener onLongClickListener = this.o;
        checkableImageButton.setOnClickListener(onClickListenerF);
        AbstractC0897f.J(checkableImageButton, onLongClickListener);
        EditText editText = this.f2679s;
        if (editText != null) {
            nVarB2.m(editText);
            j(nVarB2);
        }
        AbstractC0897f.m(textInputLayout, checkableImageButton, this.k, this.l);
        f(true);
    }

    public final void h(boolean z10) {
        if (d() != z10) {
            this.g.setVisibility(z10 ? 0 : 8);
            k();
            m();
            this.f2675a.s();
        }
    }

    public final void i(Drawable drawable) {
        CheckableImageButton checkableImageButton = this.c;
        checkableImageButton.setImageDrawable(drawable);
        l();
        AbstractC0897f.m(this.f2675a, checkableImageButton, this.d, this.e);
    }

    public final void j(n nVar) {
        if (this.f2679s == null) {
            return;
        }
        if (nVar.e() != null) {
            this.f2679s.setOnFocusChangeListener(nVar.e());
        }
        if (nVar.g() != null) {
            this.g.setOnFocusChangeListener(nVar.g());
        }
    }

    public final void k() {
        this.b.setVisibility((this.g.getVisibility() != 0 || e()) ? 8 : 0);
        setVisibility((d() || e() || !((this.p == null || this.f2678r) ? 8 : false)) ? 0 : 8);
    }

    public final void l() {
        CheckableImageButton checkableImageButton = this.c;
        Drawable drawable = checkableImageButton.getDrawable();
        TextInputLayout textInputLayout = this.f2675a;
        checkableImageButton.setVisibility((drawable != null && textInputLayout.k.f2689q && textInputLayout.o()) ? 0 : 8);
        k();
        m();
        if (this.i != 0) {
            return;
        }
        textInputLayout.s();
    }

    public final void m() {
        TextInputLayout textInputLayout = this.f2675a;
        if (textInputLayout.e == null) {
            return;
        }
        this.f2677q.setPaddingRelative(getContext().getResources().getDimensionPixelSize(R.dimen.material_input_text_to_prefix_suffix_padding), textInputLayout.e.getPaddingTop(), (d() || e()) ? 0 : textInputLayout.e.getPaddingEnd(), textInputLayout.e.getPaddingBottom());
    }

    public final void n() {
        AppCompatTextView appCompatTextView = this.f2677q;
        int visibility = appCompatTextView.getVisibility();
        int i = (this.p == null || this.f2678r) ? 8 : 0;
        if (visibility != i) {
            b().p(i == 0);
        }
        k();
        appCompatTextView.setVisibility(i);
        this.f2675a.s();
    }
}
