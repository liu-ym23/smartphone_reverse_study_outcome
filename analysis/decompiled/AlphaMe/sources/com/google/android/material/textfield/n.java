package com.google.android.material.textfield;

import Z2.I;
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
import androidx.appcompat.widget.C0200f0;
import androidx.room.AbstractC0351g;
import com.google.android.material.internal.CheckableImageButton;
import com.stepos.alphame.R;
import java.util.Iterator;
import java.util.LinkedHashSet;
import k.ViewOnAttachStateChangeListenerC0652f;
import t0.J;

/* loaded from: classes.dex */
public final class n extends LinearLayout {

    /* renamed from: w, reason: collision with root package name */
    public static final /* synthetic */ int f11034w = 0;

    /* renamed from: a, reason: collision with root package name */
    public final TextInputLayout f11035a;

    /* renamed from: b, reason: collision with root package name */
    public final FrameLayout f11036b;

    /* renamed from: c, reason: collision with root package name */
    public final CheckableImageButton f11037c;

    /* renamed from: d, reason: collision with root package name */
    public ColorStateList f11038d;

    /* renamed from: e, reason: collision with root package name */
    public PorterDuff.Mode f11039e;

    /* renamed from: f, reason: collision with root package name */
    public View.OnLongClickListener f11040f;

    /* renamed from: g, reason: collision with root package name */
    public final CheckableImageButton f11041g;

    /* renamed from: h, reason: collision with root package name */
    public final androidx.activity.result.i f11042h;

    /* renamed from: i, reason: collision with root package name */
    public int f11043i;

    /* renamed from: j, reason: collision with root package name */
    public final LinkedHashSet f11044j;

    /* renamed from: k, reason: collision with root package name */
    public ColorStateList f11045k;

    /* renamed from: l, reason: collision with root package name */
    public PorterDuff.Mode f11046l;

    /* renamed from: m, reason: collision with root package name */
    public int f11047m;

    /* renamed from: n, reason: collision with root package name */
    public ImageView.ScaleType f11048n;

    /* renamed from: o, reason: collision with root package name */
    public View.OnLongClickListener f11049o;

    /* renamed from: p, reason: collision with root package name */
    public CharSequence f11050p;

    /* renamed from: q, reason: collision with root package name */
    public final C0200f0 f11051q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f11052r;

    /* renamed from: s, reason: collision with root package name */
    public EditText f11053s;

    /* renamed from: t, reason: collision with root package name */
    public final AccessibilityManager f11054t;

    /* renamed from: u, reason: collision with root package name */
    public AccessibilityManager.TouchExplorationStateChangeListener f11055u;

    /* renamed from: v, reason: collision with root package name */
    public final l f11056v;

    public n(TextInputLayout textInputLayout, android.support.v4.media.session.c cVar) {
        CharSequence charSequenceU;
        super(textInputLayout.getContext());
        this.f11043i = 0;
        this.f11044j = new LinkedHashSet();
        this.f11056v = new l(this);
        m mVar = new m(this);
        this.f11054t = (AccessibilityManager) getContext().getSystemService("accessibility");
        this.f11035a = textInputLayout;
        setVisibility(8);
        setOrientation(0);
        setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 8388613));
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.f11036b = frameLayout;
        frameLayout.setVisibility(8);
        frameLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(getContext());
        CheckableImageButton checkableImageButtonA = a(this, layoutInflaterFrom, R.id.text_input_error_icon);
        this.f11037c = checkableImageButtonA;
        CheckableImageButton checkableImageButtonA2 = a(frameLayout, layoutInflaterFrom, R.id.text_input_end_icon);
        this.f11041g = checkableImageButtonA2;
        androidx.activity.result.i iVar = new androidx.activity.result.i();
        iVar.f2437c = new SparseArray();
        iVar.f2438d = this;
        iVar.f2435a = cVar.r(28, 0);
        iVar.f2436b = cVar.r(53, 0);
        this.f11042h = iVar;
        C0200f0 c0200f0 = new C0200f0(getContext(), null);
        this.f11051q = c0200f0;
        if (cVar.v(38)) {
            this.f11038d = B0.f.z(getContext(), cVar, 38);
        }
        if (cVar.v(39)) {
            this.f11039e = J.D(cVar.p(39, -1), null);
        }
        if (cVar.v(37)) {
            i(cVar.l(37));
        }
        checkableImageButtonA.setContentDescription(getResources().getText(R.string.error_icon_content_description));
        checkableImageButtonA.setImportantForAccessibility(2);
        checkableImageButtonA.setClickable(false);
        checkableImageButtonA.setPressable(false);
        checkableImageButtonA.setCheckable(false);
        checkableImageButtonA.setFocusable(false);
        if (!cVar.v(54)) {
            if (cVar.v(32)) {
                this.f11045k = B0.f.z(getContext(), cVar, 32);
            }
            if (cVar.v(33)) {
                this.f11046l = J.D(cVar.p(33, -1), null);
            }
        }
        if (cVar.v(30)) {
            g(cVar.p(30, 0));
            if (cVar.v(27) && checkableImageButtonA2.getContentDescription() != (charSequenceU = cVar.u(27))) {
                checkableImageButtonA2.setContentDescription(charSequenceU);
            }
            checkableImageButtonA2.setCheckable(cVar.g(26, true));
        } else if (cVar.v(54)) {
            if (cVar.v(55)) {
                this.f11045k = B0.f.z(getContext(), cVar, 55);
            }
            if (cVar.v(56)) {
                this.f11046l = J.D(cVar.p(56, -1), null);
            }
            g(cVar.g(54, false) ? 1 : 0);
            CharSequence charSequenceU2 = cVar.u(52);
            if (checkableImageButtonA2.getContentDescription() != charSequenceU2) {
                checkableImageButtonA2.setContentDescription(charSequenceU2);
            }
        }
        int iJ = cVar.j(29, getResources().getDimensionPixelSize(R.dimen.mtrl_min_touch_target_size));
        if (iJ < 0) {
            throw new IllegalArgumentException("endIconSize cannot be less than 0");
        }
        if (iJ != this.f11047m) {
            this.f11047m = iJ;
            checkableImageButtonA2.setMinimumWidth(iJ);
            checkableImageButtonA2.setMinimumHeight(iJ);
            checkableImageButtonA.setMinimumWidth(iJ);
            checkableImageButtonA.setMinimumHeight(iJ);
        }
        if (cVar.v(31)) {
            ImageView.ScaleType scaleTypeQ = com.stepos.statsrpk.c.q(cVar.p(31, -1));
            this.f11048n = scaleTypeQ;
            checkableImageButtonA2.setScaleType(scaleTypeQ);
            checkableImageButtonA.setScaleType(scaleTypeQ);
        }
        c0200f0.setVisibility(8);
        c0200f0.setId(R.id.textinput_suffix_text);
        c0200f0.setLayoutParams(new LinearLayout.LayoutParams(-2, -2, 80.0f));
        c0200f0.setAccessibilityLiveRegion(1);
        c0200f0.setTextAppearance(cVar.r(73, 0));
        if (cVar.v(74)) {
            c0200f0.setTextColor(cVar.h(74));
        }
        CharSequence charSequenceU3 = cVar.u(72);
        this.f11050p = TextUtils.isEmpty(charSequenceU3) ? null : charSequenceU3;
        c0200f0.setText(charSequenceU3);
        n();
        frameLayout.addView(checkableImageButtonA2);
        addView(c0200f0);
        addView(frameLayout);
        addView(checkableImageButtonA);
        textInputLayout.f10973p0.add(mVar);
        if (textInputLayout.f10956e != null) {
            mVar.a(textInputLayout);
        }
        addOnAttachStateChangeListener(new ViewOnAttachStateChangeListenerC0652f(4, this));
    }

    public final CheckableImageButton a(ViewGroup viewGroup, LayoutInflater layoutInflater, int i4) {
        CheckableImageButton checkableImageButton = (CheckableImageButton) layoutInflater.inflate(R.layout.design_text_input_end_icon, viewGroup, false);
        checkableImageButton.setId(i4);
        if (B0.f.Q(getContext())) {
            ((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams()).setMarginStart(0);
        }
        return checkableImageButton;
    }

    public final o b() {
        int i4 = this.f11043i;
        androidx.activity.result.i iVar = this.f11042h;
        SparseArray sparseArray = (SparseArray) iVar.f2437c;
        o eVar = (o) sparseArray.get(i4);
        if (eVar == null) {
            if (i4 != -1) {
                int i5 = 1;
                if (i4 == 0) {
                    eVar = new e((n) iVar.f2438d, i5);
                } else if (i4 == 1) {
                    eVar = new v((n) iVar.f2438d, iVar.f2436b);
                } else if (i4 == 2) {
                    eVar = new d((n) iVar.f2438d);
                } else {
                    if (i4 != 3) {
                        throw new IllegalArgumentException(AbstractC0351g.m("Invalid end icon mode: ", i4));
                    }
                    eVar = new k((n) iVar.f2438d);
                }
            } else {
                eVar = new e((n) iVar.f2438d, 0);
            }
            sparseArray.append(i4, eVar);
        }
        return eVar;
    }

    public final int c() {
        int marginStart;
        if (d() || e()) {
            CheckableImageButton checkableImageButton = this.f11041g;
            marginStart = ((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams()).getMarginStart() + checkableImageButton.getMeasuredWidth();
        } else {
            marginStart = 0;
        }
        return this.f11051q.getPaddingEnd() + getPaddingEnd() + marginStart;
    }

    public final boolean d() {
        return this.f11036b.getVisibility() == 0 && this.f11041g.getVisibility() == 0;
    }

    public final boolean e() {
        return this.f11037c.getVisibility() == 0;
    }

    public final void f(boolean z4) {
        boolean z5;
        boolean zIsActivated;
        boolean z6;
        o oVarB = b();
        boolean zK = oVarB.k();
        CheckableImageButton checkableImageButton = this.f11041g;
        boolean z7 = true;
        if (!zK || (z6 = checkableImageButton.f10751d) == oVarB.l()) {
            z5 = false;
        } else {
            checkableImageButton.setChecked(!z6);
            z5 = true;
        }
        if (!(oVarB instanceof k) || (zIsActivated = checkableImageButton.isActivated()) == oVarB.j()) {
            z7 = z5;
        } else {
            checkableImageButton.setActivated(!zIsActivated);
        }
        if (z4 || z7) {
            com.stepos.statsrpk.c.I(this.f11035a, checkableImageButton, this.f11045k);
        }
    }

    public final void g(int i4) {
        if (this.f11043i == i4) {
            return;
        }
        o oVarB = b();
        AccessibilityManager.TouchExplorationStateChangeListener touchExplorationStateChangeListener = this.f11055u;
        AccessibilityManager accessibilityManager = this.f11054t;
        if (touchExplorationStateChangeListener != null && accessibilityManager != null) {
            accessibilityManager.removeTouchExplorationStateChangeListener(touchExplorationStateChangeListener);
        }
        this.f11055u = null;
        oVarB.s();
        this.f11043i = i4;
        Iterator it = this.f11044j.iterator();
        if (it.hasNext()) {
            B0.g.y(it.next());
            throw null;
        }
        h(i4 != 0);
        o oVarB2 = b();
        int iD = this.f11042h.f2435a;
        if (iD == 0) {
            iD = oVarB2.d();
        }
        Drawable drawableO = iD != 0 ? I.o(getContext(), iD) : null;
        CheckableImageButton checkableImageButton = this.f11041g;
        checkableImageButton.setImageDrawable(drawableO);
        TextInputLayout textInputLayout = this.f11035a;
        if (drawableO != null) {
            com.stepos.statsrpk.c.e(textInputLayout, checkableImageButton, this.f11045k, this.f11046l);
            com.stepos.statsrpk.c.I(textInputLayout, checkableImageButton, this.f11045k);
        }
        int iC = oVarB2.c();
        CharSequence text = iC != 0 ? getResources().getText(iC) : null;
        if (checkableImageButton.getContentDescription() != text) {
            checkableImageButton.setContentDescription(text);
        }
        checkableImageButton.setCheckable(oVarB2.k());
        if (!oVarB2.i(textInputLayout.getBoxBackgroundMode())) {
            throw new IllegalStateException("The current box background mode " + textInputLayout.getBoxBackgroundMode() + " is not supported by the end icon mode " + i4);
        }
        oVarB2.r();
        AccessibilityManager.TouchExplorationStateChangeListener touchExplorationStateChangeListenerH = oVarB2.h();
        this.f11055u = touchExplorationStateChangeListenerH;
        if (touchExplorationStateChangeListenerH != null && accessibilityManager != null && isAttachedToWindow()) {
            accessibilityManager.addTouchExplorationStateChangeListener(this.f11055u);
        }
        View.OnClickListener onClickListenerF = oVarB2.f();
        View.OnLongClickListener onLongClickListener = this.f11049o;
        checkableImageButton.setOnClickListener(onClickListenerF);
        com.stepos.statsrpk.c.N(checkableImageButton, onLongClickListener);
        EditText editText = this.f11053s;
        if (editText != null) {
            oVarB2.m(editText);
            j(oVarB2);
        }
        com.stepos.statsrpk.c.e(textInputLayout, checkableImageButton, this.f11045k, this.f11046l);
        f(true);
    }

    public final void h(boolean z4) {
        if (d() != z4) {
            this.f11041g.setVisibility(z4 ? 0 : 8);
            k();
            m();
            this.f11035a.s();
        }
    }

    public final void i(Drawable drawable) {
        CheckableImageButton checkableImageButton = this.f11037c;
        checkableImageButton.setImageDrawable(drawable);
        l();
        com.stepos.statsrpk.c.e(this.f11035a, checkableImageButton, this.f11038d, this.f11039e);
    }

    public final void j(o oVar) {
        if (this.f11053s == null) {
            return;
        }
        if (oVar.e() != null) {
            this.f11053s.setOnFocusChangeListener(oVar.e());
        }
        if (oVar.g() != null) {
            this.f11041g.setOnFocusChangeListener(oVar.g());
        }
    }

    public final void k() {
        this.f11036b.setVisibility((this.f11041g.getVisibility() != 0 || e()) ? 8 : 0);
        setVisibility((d() || e() || !((this.f11050p == null || this.f11052r) ? 8 : false)) ? 0 : 8);
    }

    public final void l() {
        CheckableImageButton checkableImageButton = this.f11037c;
        Drawable drawable = checkableImageButton.getDrawable();
        TextInputLayout textInputLayout = this.f11035a;
        checkableImageButton.setVisibility((drawable != null && textInputLayout.f10962k.f11085q && textInputLayout.o()) ? 0 : 8);
        k();
        m();
        if (this.f11043i != 0) {
            return;
        }
        textInputLayout.s();
    }

    public final void m() {
        TextInputLayout textInputLayout = this.f11035a;
        if (textInputLayout.f10956e == null) {
            return;
        }
        this.f11051q.setPaddingRelative(getContext().getResources().getDimensionPixelSize(R.dimen.material_input_text_to_prefix_suffix_padding), textInputLayout.f10956e.getPaddingTop(), (d() || e()) ? 0 : textInputLayout.f10956e.getPaddingEnd(), textInputLayout.f10956e.getPaddingBottom());
    }

    public final void n() {
        C0200f0 c0200f0 = this.f11051q;
        int visibility = c0200f0.getVisibility();
        int i4 = (this.f11050p == null || this.f11052r) ? 8 : 0;
        if (visibility != i4) {
            b().p(i4 == 0);
        }
        k();
        c0200f0.setVisibility(i4);
        this.f11035a.s();
    }
}
