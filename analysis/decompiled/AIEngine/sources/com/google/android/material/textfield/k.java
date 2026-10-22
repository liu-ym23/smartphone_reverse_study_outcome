package com.google.android.material.textfield;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.Editable;
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
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.x0;
import androidx.datastore.preferences.protobuf.b1;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;
import com.stepos.aiengine.R;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@SuppressLint({"ViewConstructor"})
/* loaded from: classes.dex */
public final class k extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    public final TextInputLayout f5259a;

    /* renamed from: b, reason: collision with root package name */
    public final FrameLayout f5260b;

    /* renamed from: c, reason: collision with root package name */
    public final CheckableImageButton f5261c;

    /* renamed from: d, reason: collision with root package name */
    public ColorStateList f5262d;

    /* renamed from: e, reason: collision with root package name */
    public PorterDuff.Mode f5263e;
    public View.OnLongClickListener h;

    /* renamed from: j, reason: collision with root package name */
    public final CheckableImageButton f5264j;

    /* renamed from: k, reason: collision with root package name */
    public final d f5265k;

    /* renamed from: l, reason: collision with root package name */
    public int f5266l;

    /* renamed from: m, reason: collision with root package name */
    public final LinkedHashSet<TextInputLayout.h> f5267m;

    /* renamed from: n, reason: collision with root package name */
    public ColorStateList f5268n;

    /* renamed from: o, reason: collision with root package name */
    public PorterDuff.Mode f5269o;

    /* renamed from: p, reason: collision with root package name */
    public int f5270p;

    /* renamed from: q, reason: collision with root package name */
    public ImageView.ScaleType f5271q;
    public View.OnLongClickListener r;

    /* renamed from: s, reason: collision with root package name */
    public CharSequence f5272s;

    /* renamed from: t, reason: collision with root package name */
    public final AppCompatTextView f5273t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f5274u;

    /* renamed from: v, reason: collision with root package name */
    public EditText f5275v;

    /* renamed from: w, reason: collision with root package name */
    public final AccessibilityManager f5276w;

    /* renamed from: x, reason: collision with root package name */
    public AccessibilityManager.TouchExplorationStateChangeListener f5277x;

    /* renamed from: y, reason: collision with root package name */
    public final a f5278y;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a extends com.google.android.material.internal.h {
        public a() {
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable editable) {
            k.this.b().a();
        }

        @Override // com.google.android.material.internal.h, android.text.TextWatcher
        public final void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            k.this.b().b();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class b implements TextInputLayout.g {
        public b() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.g
        public final void a(TextInputLayout textInputLayout) {
            k kVar = k.this;
            a aVar = kVar.f5278y;
            if (kVar.f5275v == textInputLayout.getEditText()) {
                return;
            }
            EditText editText = kVar.f5275v;
            if (editText != null) {
                editText.removeTextChangedListener(aVar);
                if (kVar.f5275v.getOnFocusChangeListener() == kVar.b().e()) {
                    kVar.f5275v.setOnFocusChangeListener(null);
                }
            }
            EditText editText2 = textInputLayout.getEditText();
            kVar.f5275v = editText2;
            if (editText2 != null) {
                editText2.addTextChangedListener(aVar);
            }
            kVar.b().l(kVar.f5275v);
            kVar.j(kVar.b());
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class c implements View.OnAttachStateChangeListener {
        public c() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View view) {
            k kVar = k.this;
            AccessibilityManager accessibilityManager = kVar.f5276w;
            if (kVar.f5277x == null || accessibilityManager == null || !kVar.isAttachedToWindow()) {
                return;
            }
            accessibilityManager.addTouchExplorationStateChangeListener(kVar.f5277x);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View view) {
            AccessibilityManager accessibilityManager;
            k kVar = k.this;
            AccessibilityManager.TouchExplorationStateChangeListener touchExplorationStateChangeListener = kVar.f5277x;
            if (touchExplorationStateChangeListener == null || (accessibilityManager = kVar.f5276w) == null) {
                return;
            }
            accessibilityManager.removeTouchExplorationStateChangeListener(touchExplorationStateChangeListener);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public final SparseArray<l> f5282a = new SparseArray<>();

        /* renamed from: b, reason: collision with root package name */
        public final k f5283b;

        /* renamed from: c, reason: collision with root package name */
        public final int f5284c;

        /* renamed from: d, reason: collision with root package name */
        public final int f5285d;

        public d(k kVar, x0 x0Var) {
            this.f5283b = kVar;
            TypedArray typedArray = x0Var.f948b;
            this.f5284c = typedArray.getResourceId(28, 0);
            this.f5285d = typedArray.getResourceId(53, 0);
        }
    }

    public k(TextInputLayout textInputLayout, x0 x0Var) {
        CharSequence text;
        super(textInputLayout.getContext());
        this.f5266l = 0;
        this.f5267m = new LinkedHashSet<>();
        this.f5278y = new a();
        b bVar = new b();
        this.f5276w = (AccessibilityManager) getContext().getSystemService("accessibility");
        this.f5259a = textInputLayout;
        setVisibility(8);
        setOrientation(0);
        setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 8388613));
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.f5260b = frameLayout;
        frameLayout.setVisibility(8);
        frameLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(getContext());
        CheckableImageButton checkableImageButtonA = a(this, layoutInflaterFrom, R.id.text_input_error_icon);
        this.f5261c = checkableImageButtonA;
        CheckableImageButton checkableImageButtonA2 = a(frameLayout, layoutInflaterFrom, R.id.text_input_end_icon);
        this.f5264j = checkableImageButtonA2;
        this.f5265k = new d(this, x0Var);
        AppCompatTextView appCompatTextView = new AppCompatTextView(getContext(), null);
        this.f5273t = appCompatTextView;
        TypedArray typedArray = x0Var.f948b;
        if (typedArray.hasValue(38)) {
            this.f5262d = w4.c.b(getContext(), x0Var, 38);
        }
        if (typedArray.hasValue(39)) {
            this.f5263e = com.google.android.material.internal.m.b(typedArray.getInt(39, -1), null);
        }
        if (typedArray.hasValue(37)) {
            i(x0Var.b(37));
        }
        checkableImageButtonA.setContentDescription(getResources().getText(R.string.error_icon_content_description));
        checkableImageButtonA.setImportantForAccessibility(2);
        checkableImageButtonA.setClickable(false);
        checkableImageButtonA.setPressable(false);
        checkableImageButtonA.setCheckable(false);
        checkableImageButtonA.setFocusable(false);
        if (!typedArray.hasValue(54)) {
            if (typedArray.hasValue(32)) {
                this.f5268n = w4.c.b(getContext(), x0Var, 32);
            }
            if (typedArray.hasValue(33)) {
                this.f5269o = com.google.android.material.internal.m.b(typedArray.getInt(33, -1), null);
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
                this.f5268n = w4.c.b(getContext(), x0Var, 55);
            }
            if (typedArray.hasValue(56)) {
                this.f5269o = com.google.android.material.internal.m.b(typedArray.getInt(56, -1), null);
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
        if (dimensionPixelSize != this.f5270p) {
            this.f5270p = dimensionPixelSize;
            checkableImageButtonA2.setMinimumWidth(dimensionPixelSize);
            checkableImageButtonA2.setMinimumHeight(dimensionPixelSize);
            checkableImageButtonA.setMinimumWidth(dimensionPixelSize);
            checkableImageButtonA.setMinimumHeight(dimensionPixelSize);
        }
        if (typedArray.hasValue(31)) {
            ImageView.ScaleType scaleTypeB = m.b(typedArray.getInt(31, -1));
            this.f5271q = scaleTypeB;
            checkableImageButtonA2.setScaleType(scaleTypeB);
            checkableImageButtonA.setScaleType(scaleTypeB);
        }
        appCompatTextView.setVisibility(8);
        appCompatTextView.setId(R.id.textinput_suffix_text);
        appCompatTextView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2, 80.0f));
        appCompatTextView.setAccessibilityLiveRegion(1);
        appCompatTextView.setTextAppearance(typedArray.getResourceId(73, 0));
        if (typedArray.hasValue(74)) {
            appCompatTextView.setTextColor(x0Var.a(74));
        }
        CharSequence text3 = typedArray.getText(72);
        this.f5272s = TextUtils.isEmpty(text3) ? null : text3;
        appCompatTextView.setText(text3);
        n();
        frameLayout.addView(checkableImageButtonA2);
        addView(appCompatTextView);
        addView(frameLayout);
        addView(checkableImageButtonA);
        textInputLayout.f5194i0.add(bVar);
        if (textInputLayout.f5189e != null) {
            bVar.a(textInputLayout);
        }
        addOnAttachStateChangeListener(new c());
    }

    public final CheckableImageButton a(ViewGroup viewGroup, LayoutInflater layoutInflater, int i10) {
        CheckableImageButton checkableImageButton = (CheckableImageButton) layoutInflater.inflate(R.layout.design_text_input_end_icon, viewGroup, false);
        checkableImageButton.setId(i10);
        if (w4.c.d(getContext())) {
            ((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams()).setMarginStart(0);
        }
        return checkableImageButton;
    }

    public final l b() {
        l dVar;
        int i10 = this.f5266l;
        d dVar2 = this.f5265k;
        SparseArray<l> sparseArray = dVar2.f5282a;
        l lVar = sparseArray.get(i10);
        if (lVar != null) {
            return lVar;
        }
        k kVar = dVar2.f5283b;
        if (i10 == -1) {
            dVar = new com.google.android.material.textfield.d(kVar);
        } else if (i10 == 0) {
            dVar = new r(kVar);
        } else if (i10 == 1) {
            dVar = new s(kVar, dVar2.f5285d);
        } else if (i10 == 2) {
            dVar = new com.google.android.material.textfield.c(kVar);
        } else {
            if (i10 != 3) {
                throw new IllegalArgumentException(ai.onnxruntime.providers.a.a(i10, "Invalid end icon mode: "));
            }
            dVar = new j(kVar);
        }
        sparseArray.append(i10, dVar);
        return dVar;
    }

    public final int c() {
        int marginStart;
        if (d() || e()) {
            CheckableImageButton checkableImageButton = this.f5264j;
            marginStart = ((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams()).getMarginStart() + checkableImageButton.getMeasuredWidth();
        } else {
            marginStart = 0;
        }
        return this.f5273t.getPaddingEnd() + getPaddingEnd() + marginStart;
    }

    public final boolean d() {
        return this.f5260b.getVisibility() == 0 && this.f5264j.getVisibility() == 0;
    }

    public final boolean e() {
        return this.f5261c.getVisibility() == 0;
    }

    public final void f(boolean z) {
        boolean z3;
        boolean zIsActivated;
        boolean z10;
        l lVarB = b();
        boolean zJ = lVarB.j();
        CheckableImageButton checkableImageButton = this.f5264j;
        boolean z11 = true;
        if (!zJ || (z10 = checkableImageButton.f5035d) == lVarB.k()) {
            z3 = false;
        } else {
            checkableImageButton.setChecked(!z10);
            z3 = true;
        }
        if (!(lVarB instanceof j) || (zIsActivated = checkableImageButton.isActivated()) == ((j) lVarB).f5253l) {
            z11 = z3;
        } else {
            checkableImageButton.setActivated(!zIsActivated);
        }
        if (z || z11) {
            m.c(this.f5259a, checkableImageButton, this.f5268n);
        }
    }

    public final void g(int i10) {
        if (this.f5266l == i10) {
            return;
        }
        l lVarB = b();
        AccessibilityManager.TouchExplorationStateChangeListener touchExplorationStateChangeListener = this.f5277x;
        AccessibilityManager accessibilityManager = this.f5276w;
        if (touchExplorationStateChangeListener != null && accessibilityManager != null) {
            accessibilityManager.removeTouchExplorationStateChangeListener(touchExplorationStateChangeListener);
        }
        this.f5277x = null;
        lVarB.r();
        this.f5266l = i10;
        Iterator<TextInputLayout.h> it = this.f5267m.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
        h(i10 != 0);
        l lVarB2 = b();
        int iD = this.f5265k.f5284c;
        if (iD == 0) {
            iD = lVarB2.d();
        }
        Drawable drawableL = iD != 0 ? b1.L(iD, getContext()) : null;
        CheckableImageButton checkableImageButton = this.f5264j;
        checkableImageButton.setImageDrawable(drawableL);
        TextInputLayout textInputLayout = this.f5259a;
        if (drawableL != null) {
            m.a(textInputLayout, checkableImageButton, this.f5268n, this.f5269o);
            m.c(textInputLayout, checkableImageButton, this.f5268n);
        }
        int iC = lVarB2.c();
        CharSequence text = iC != 0 ? getResources().getText(iC) : null;
        if (checkableImageButton.getContentDescription() != text) {
            checkableImageButton.setContentDescription(text);
        }
        checkableImageButton.setCheckable(lVarB2.j());
        if (!lVarB2.i(textInputLayout.getBoxBackgroundMode())) {
            throw new IllegalStateException("The current box background mode " + textInputLayout.getBoxBackgroundMode() + " is not supported by the end icon mode " + i10);
        }
        lVarB2.q();
        AccessibilityManager.TouchExplorationStateChangeListener touchExplorationStateChangeListenerH = lVarB2.h();
        this.f5277x = touchExplorationStateChangeListenerH;
        if (touchExplorationStateChangeListenerH != null && accessibilityManager != null && isAttachedToWindow()) {
            accessibilityManager.addTouchExplorationStateChangeListener(this.f5277x);
        }
        View.OnClickListener onClickListenerF = lVarB2.f();
        View.OnLongClickListener onLongClickListener = this.r;
        checkableImageButton.setOnClickListener(onClickListenerF);
        m.d(checkableImageButton, onLongClickListener);
        EditText editText = this.f5275v;
        if (editText != null) {
            lVarB2.l(editText);
            j(lVarB2);
        }
        m.a(textInputLayout, checkableImageButton, this.f5268n, this.f5269o);
        f(true);
    }

    public final void h(boolean z) {
        if (d() != z) {
            this.f5264j.setVisibility(z ? 0 : 8);
            k();
            m();
            this.f5259a.s();
        }
    }

    public final void i(Drawable drawable) {
        CheckableImageButton checkableImageButton = this.f5261c;
        checkableImageButton.setImageDrawable(drawable);
        l();
        m.a(this.f5259a, checkableImageButton, this.f5262d, this.f5263e);
    }

    public final void j(l lVar) {
        if (this.f5275v == null) {
            return;
        }
        if (lVar.e() != null) {
            this.f5275v.setOnFocusChangeListener(lVar.e());
        }
        if (lVar.g() != null) {
            this.f5264j.setOnFocusChangeListener(lVar.g());
        }
    }

    public final void k() {
        this.f5260b.setVisibility((this.f5264j.getVisibility() != 0 || e()) ? 8 : 0);
        setVisibility((d() || e() || !((this.f5272s == null || this.f5274u) ? 8 : false)) ? 0 : 8);
    }

    public final void l() {
        CheckableImageButton checkableImageButton = this.f5261c;
        Drawable drawable = checkableImageButton.getDrawable();
        TextInputLayout textInputLayout = this.f5259a;
        checkableImageButton.setVisibility((drawable != null && textInputLayout.f5203n.f5305q && textInputLayout.o()) ? 0 : 8);
        k();
        m();
        if (this.f5266l != 0) {
            return;
        }
        textInputLayout.s();
    }

    public final void m() {
        TextInputLayout textInputLayout = this.f5259a;
        if (textInputLayout.f5189e == null) {
            return;
        }
        this.f5273t.setPaddingRelative(getContext().getResources().getDimensionPixelSize(R.dimen.material_input_text_to_prefix_suffix_padding), textInputLayout.f5189e.getPaddingTop(), (d() || e()) ? 0 : textInputLayout.f5189e.getPaddingEnd(), textInputLayout.f5189e.getPaddingBottom());
    }

    public final void n() {
        AppCompatTextView appCompatTextView = this.f5273t;
        int visibility = appCompatTextView.getVisibility();
        int i10 = (this.f5272s == null || this.f5274u) ? 8 : 0;
        if (visibility != i10) {
            b().o(i10 == 0);
        }
        k();
        appCompatTextView.setVisibility(i10);
        this.f5259a.s();
    }
}
