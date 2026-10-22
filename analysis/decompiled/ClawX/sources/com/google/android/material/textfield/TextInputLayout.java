package com.google.android.material.textfield;

import a1.h;
import a1.s;
import a4.d;
import android.R;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.view.ViewTreeObserver;
import android.view.animation.LinearInterpolator;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.material.internal.CheckableImageButton;
import com.stepos.stepclaw.SecurePrefs;
import e0.a0;
import g.g0;
import g.n0;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Locale;
import k4.v;
import k4.z;
import p1.b;
import p1.c;
import p1.k;
import t1.f;
import t1.i;
import t1.j;
import t1.l;
import t1.m;
import t1.n;
import w1.g;
import w1.o;
import w1.q;
import w1.r;
import w1.t;
import w1.u;
import w1.w;
import w1.x;
import x1.a;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public class TextInputLayout extends LinearLayout implements ViewTreeObserver.OnGlobalLayoutListener {
    public static final int[][] E0 = {new int[]{R.attr.state_pressed}, new int[0]};
    public ColorStateList A;
    public ValueAnimator A0;
    public ColorStateList B;
    public boolean B0;
    public ColorStateList C;
    public boolean C0;
    public ColorStateList D;
    public boolean D0;
    public boolean E;
    public CharSequence F;
    public boolean G;
    public j H;
    public j I;
    public StateListDrawable J;
    public boolean K;
    public j L;
    public j M;
    public n N;
    public boolean O;
    public final int P;
    public int Q;
    public int R;
    public int S;
    public int T;
    public int U;
    public int V;
    public int W;

    /* renamed from: a, reason: collision with root package name */
    public final FrameLayout f1352a;

    /* renamed from: a0, reason: collision with root package name */
    public final Rect f1353a0;

    /* renamed from: b, reason: collision with root package name */
    public final t f1354b;

    /* renamed from: b0, reason: collision with root package name */
    public final Rect f1355b0;

    /* renamed from: c, reason: collision with root package name */
    public final o f1356c;

    /* renamed from: c0, reason: collision with root package name */
    public final RectF f1357c0;
    public final int d;

    /* renamed from: d0, reason: collision with root package name */
    public Typeface f1358d0;

    /* renamed from: e, reason: collision with root package name */
    public EditText f1359e;

    /* renamed from: e0, reason: collision with root package name */
    public ColorDrawable f1360e0;

    /* renamed from: f, reason: collision with root package name */
    public CharSequence f1361f;

    /* renamed from: f0, reason: collision with root package name */
    public int f1362f0;

    /* renamed from: g, reason: collision with root package name */
    public int f1363g;

    /* renamed from: g0, reason: collision with root package name */
    public final LinkedHashSet f1364g0;

    /* renamed from: h, reason: collision with root package name */
    public int f1365h;

    /* renamed from: h0, reason: collision with root package name */
    public ColorDrawable f1366h0;

    /* renamed from: i0, reason: collision with root package name */
    public int f1367i0;

    /* renamed from: j, reason: collision with root package name */
    public int f1368j;

    /* renamed from: j0, reason: collision with root package name */
    public Drawable f1369j0;

    /* renamed from: k, reason: collision with root package name */
    public int f1370k;
    public ColorStateList k0;

    /* renamed from: l, reason: collision with root package name */
    public final r f1371l;

    /* renamed from: l0, reason: collision with root package name */
    public ColorStateList f1372l0;

    /* renamed from: m, reason: collision with root package name */
    public boolean f1373m;

    /* renamed from: m0, reason: collision with root package name */
    public int f1374m0;

    /* renamed from: n, reason: collision with root package name */
    public int f1375n;

    /* renamed from: n0, reason: collision with root package name */
    public int f1376n0;

    /* renamed from: o, reason: collision with root package name */
    public boolean f1377o;

    /* renamed from: o0, reason: collision with root package name */
    public int f1378o0;

    /* renamed from: p, reason: collision with root package name */
    public w f1379p;

    /* renamed from: p0, reason: collision with root package name */
    public ColorStateList f1380p0;

    /* renamed from: q, reason: collision with root package name */
    public g0 f1381q;

    /* renamed from: q0, reason: collision with root package name */
    public int f1382q0;

    /* renamed from: r, reason: collision with root package name */
    public int f1383r;

    /* renamed from: r0, reason: collision with root package name */
    public int f1384r0;

    /* renamed from: s, reason: collision with root package name */
    public int f1385s;

    /* renamed from: s0, reason: collision with root package name */
    public int f1386s0;

    /* renamed from: t, reason: collision with root package name */
    public CharSequence f1387t;

    /* renamed from: t0, reason: collision with root package name */
    public int f1388t0;

    /* renamed from: u, reason: collision with root package name */
    public boolean f1389u;

    /* renamed from: u0, reason: collision with root package name */
    public int f1390u0;

    /* renamed from: v, reason: collision with root package name */
    public g0 f1391v;

    /* renamed from: v0, reason: collision with root package name */
    public int f1392v0;

    /* renamed from: w, reason: collision with root package name */
    public ColorStateList f1393w;

    /* renamed from: w0, reason: collision with root package name */
    public boolean f1394w0;

    /* renamed from: x, reason: collision with root package name */
    public int f1395x;

    /* renamed from: x0, reason: collision with root package name */
    public final b f1396x0;
    public h y;

    /* renamed from: y0, reason: collision with root package name */
    public boolean f1397y0;
    public h z;

    /* renamed from: z0, reason: collision with root package name */
    public boolean f1398z0;

    public TextInputLayout(Context context, AttributeSet attributeSet) throws Resources.NotFoundException {
        super(a.a(context, attributeSet, com.stepos.stepclaw.R.attr.textInputStyle, com.stepos.stepclaw.R.style.Widget_Design_TextInputLayout), attributeSet, com.stepos.stepclaw.R.attr.textInputStyle);
        this.f1363g = -1;
        this.f1365h = -1;
        this.f1368j = -1;
        this.f1370k = -1;
        this.f1371l = new r(this);
        this.f1379p = new a1.n(13);
        this.f1353a0 = new Rect();
        this.f1355b0 = new Rect();
        this.f1357c0 = new RectF();
        this.f1364g0 = new LinkedHashSet();
        b bVar = new b(this);
        this.f1396x0 = bVar;
        this.D0 = false;
        Context context2 = getContext();
        setOrientation(1);
        setWillNotDraw(false);
        setAddStatesFromChildren(true);
        FrameLayout frameLayout = new FrameLayout(context2);
        this.f1352a = frameLayout;
        frameLayout.setAddStatesFromChildren(true);
        LinearInterpolator linearInterpolator = e1.a.f2339a;
        bVar.R = linearInterpolator;
        bVar.j(false);
        bVar.Q = linearInterpolator;
        bVar.j(false);
        if (bVar.f4674g != 8388659) {
            bVar.f4674g = 8388659;
            bVar.j(false);
        }
        k.a(context2, attributeSet, com.stepos.stepclaw.R.attr.textInputStyle, com.stepos.stepclaw.R.style.Widget_Design_TextInputLayout);
        int[] iArr = d1.a.f1782x;
        k.b(context2, attributeSet, iArr, com.stepos.stepclaw.R.attr.textInputStyle, com.stepos.stepclaw.R.style.Widget_Design_TextInputLayout, 22, 20, 40, 45, 50);
        TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, iArr, com.stepos.stepclaw.R.attr.textInputStyle, com.stepos.stepclaw.R.style.Widget_Design_TextInputLayout);
        d dVar = new d(context2, typedArrayObtainStyledAttributes);
        t tVar = new t(this, dVar);
        this.f1354b = tVar;
        this.E = typedArrayObtainStyledAttributes.getBoolean(48, true);
        setHint(typedArrayObtainStyledAttributes.getText(4));
        this.f1398z0 = typedArrayObtainStyledAttributes.getBoolean(47, true);
        this.f1397y0 = typedArrayObtainStyledAttributes.getBoolean(42, true);
        if (typedArrayObtainStyledAttributes.hasValue(6)) {
            setMinEms(typedArrayObtainStyledAttributes.getInt(6, -1));
        } else if (typedArrayObtainStyledAttributes.hasValue(3)) {
            setMinWidth(typedArrayObtainStyledAttributes.getDimensionPixelSize(3, -1));
        }
        if (typedArrayObtainStyledAttributes.hasValue(5)) {
            setMaxEms(typedArrayObtainStyledAttributes.getInt(5, -1));
        } else if (typedArrayObtainStyledAttributes.hasValue(2)) {
            setMaxWidth(typedArrayObtainStyledAttributes.getDimensionPixelSize(2, -1));
        }
        this.N = n.b(context2, attributeSet, com.stepos.stepclaw.R.attr.textInputStyle, com.stepos.stepclaw.R.style.Widget_Design_TextInputLayout).a();
        this.P = context2.getResources().getDimensionPixelOffset(com.stepos.stepclaw.R.dimen.mtrl_textinput_box_label_cutout_padding);
        this.R = typedArrayObtainStyledAttributes.getDimensionPixelOffset(9, 0);
        this.d = getResources().getDimensionPixelSize(com.stepos.stepclaw.R.dimen.m3_multiline_hint_filled_text_extra_space);
        this.T = typedArrayObtainStyledAttributes.getDimensionPixelSize(16, context2.getResources().getDimensionPixelSize(com.stepos.stepclaw.R.dimen.mtrl_textinput_box_stroke_width_default));
        this.U = typedArrayObtainStyledAttributes.getDimensionPixelSize(17, context2.getResources().getDimensionPixelSize(com.stepos.stepclaw.R.dimen.mtrl_textinput_box_stroke_width_focused));
        this.S = this.T;
        float dimension = typedArrayObtainStyledAttributes.getDimension(13, -1.0f);
        float dimension2 = typedArrayObtainStyledAttributes.getDimension(12, -1.0f);
        float dimension3 = typedArrayObtainStyledAttributes.getDimension(10, -1.0f);
        float dimension4 = typedArrayObtainStyledAttributes.getDimension(11, -1.0f);
        m mVarF = this.N.f();
        if (dimension >= 0.0f) {
            mVarF.f5500e = new t1.a(dimension);
        }
        if (dimension2 >= 0.0f) {
            mVarF.f5501f = new t1.a(dimension2);
        }
        if (dimension3 >= 0.0f) {
            mVarF.f5502g = new t1.a(dimension3);
        }
        if (dimension4 >= 0.0f) {
            mVarF.f5503h = new t1.a(dimension4);
        }
        this.N = mVarF.a();
        ColorStateList colorStateListC = v.C(context2, dVar, 7);
        if (colorStateListC != null) {
            int defaultColor = colorStateListC.getDefaultColor();
            this.f1382q0 = defaultColor;
            this.W = defaultColor;
            if (colorStateListC.isStateful()) {
                this.f1384r0 = colorStateListC.getColorForState(new int[]{-16842910}, -1);
                this.f1386s0 = colorStateListC.getColorForState(new int[]{R.attr.state_focused, R.attr.state_enabled}, -1);
                this.f1388t0 = colorStateListC.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, -1);
            } else {
                this.f1386s0 = this.f1382q0;
                ColorStateList colorStateListT = z.t(context2, com.stepos.stepclaw.R.color.mtrl_filled_background_color);
                this.f1384r0 = colorStateListT.getColorForState(new int[]{-16842910}, -1);
                this.f1388t0 = colorStateListT.getColorForState(new int[]{R.attr.state_hovered}, -1);
            }
        } else {
            this.W = 0;
            this.f1382q0 = 0;
            this.f1384r0 = 0;
            this.f1386s0 = 0;
            this.f1388t0 = 0;
        }
        if (typedArrayObtainStyledAttributes.hasValue(1)) {
            ColorStateList colorStateListS = dVar.s(1);
            this.f1372l0 = colorStateListS;
            this.k0 = colorStateListS;
        }
        ColorStateList colorStateListC2 = v.C(context2, dVar, 14);
        this.f1378o0 = typedArrayObtainStyledAttributes.getColor(14, 0);
        this.f1374m0 = context2.getColor(com.stepos.stepclaw.R.color.mtrl_textinput_default_box_stroke_color);
        this.f1390u0 = context2.getColor(com.stepos.stepclaw.R.color.mtrl_textinput_disabled_color);
        this.f1376n0 = context2.getColor(com.stepos.stepclaw.R.color.mtrl_textinput_hovered_box_stroke_color);
        if (colorStateListC2 != null) {
            setBoxStrokeColorStateList(colorStateListC2);
        }
        if (typedArrayObtainStyledAttributes.hasValue(15)) {
            setBoxStrokeErrorColor(v.C(context2, dVar, 15));
        }
        if (typedArrayObtainStyledAttributes.getResourceId(50, -1) != -1) {
            setHintTextAppearance(typedArrayObtainStyledAttributes.getResourceId(50, 0));
        }
        this.C = dVar.s(24);
        this.D = dVar.s(25);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(40, 0);
        CharSequence text = typedArrayObtainStyledAttributes.getText(35);
        int i8 = typedArrayObtainStyledAttributes.getInt(34, 1);
        boolean z = typedArrayObtainStyledAttributes.getBoolean(36, false);
        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(45, 0);
        boolean z2 = typedArrayObtainStyledAttributes.getBoolean(44, false);
        CharSequence text2 = typedArrayObtainStyledAttributes.getText(43);
        int resourceId3 = typedArrayObtainStyledAttributes.getResourceId(58, 0);
        CharSequence text3 = typedArrayObtainStyledAttributes.getText(57);
        boolean z8 = typedArrayObtainStyledAttributes.getBoolean(18, false);
        setCounterMaxLength(typedArrayObtainStyledAttributes.getInt(19, -1));
        this.f1385s = typedArrayObtainStyledAttributes.getResourceId(22, 0);
        this.f1383r = typedArrayObtainStyledAttributes.getResourceId(20, 0);
        setBoxBackgroundMode(typedArrayObtainStyledAttributes.getInt(8, 0));
        setErrorContentDescription(text);
        setErrorAccessibilityLiveRegion(i8);
        setCounterOverflowTextAppearance(this.f1383r);
        setHelperTextTextAppearance(resourceId2);
        setErrorTextAppearance(resourceId);
        setCounterTextAppearance(this.f1385s);
        setPlaceholderText(text3);
        setPlaceholderTextAppearance(resourceId3);
        if (typedArrayObtainStyledAttributes.hasValue(41)) {
            setErrorTextColor(dVar.s(41));
        }
        if (typedArrayObtainStyledAttributes.hasValue(46)) {
            setHelperTextColor(dVar.s(46));
        }
        if (typedArrayObtainStyledAttributes.hasValue(51)) {
            setHintTextColor(dVar.s(51));
        }
        if (typedArrayObtainStyledAttributes.hasValue(23)) {
            setCounterTextColor(dVar.s(23));
        }
        if (typedArrayObtainStyledAttributes.hasValue(21)) {
            setCounterOverflowTextColor(dVar.s(21));
        }
        if (typedArrayObtainStyledAttributes.hasValue(59)) {
            setPlaceholderTextColor(dVar.s(59));
        }
        o oVar = new o(this, dVar);
        this.f1356c = oVar;
        boolean z9 = typedArrayObtainStyledAttributes.getBoolean(0, true);
        setHintMaxLines(typedArrayObtainStyledAttributes.getInt(49, 1));
        dVar.H();
        setImportantForAccessibility(2);
        setImportantForAutofill(1);
        frameLayout.addView(tVar);
        frameLayout.addView(oVar);
        addView(frameLayout);
        setEnabled(z9);
        setHelperTextEnabled(z2);
        setErrorEnabled(z);
        setCounterEnabled(z8);
        setHelperText(text2);
    }

    private Drawable getEditTextBoxBackground() {
        EditText editText = this.f1359e;
        if (!(editText instanceof AutoCompleteTextView) || editText.getInputType() != 0) {
            return this.H;
        }
        int iB = v.B(this.f1359e, com.stepos.stepclaw.R.attr.colorControlHighlight);
        int i8 = this.Q;
        int[][] iArr = E0;
        if (i8 != 2) {
            if (i8 != 1) {
                return null;
            }
            j jVar = this.H;
            int i9 = this.W;
            return new RippleDrawable(new ColorStateList(iArr, new int[]{v.a0(iB, i9, 0.1f), i9}), jVar, jVar);
        }
        Context context = getContext();
        j jVar2 = this.H;
        TypedValue typedValueE = z.E(context, com.stepos.stepclaw.R.attr.colorSurface, "TextInputLayout");
        int i10 = typedValueE.resourceId;
        int color = i10 != 0 ? context.getColor(i10) : typedValueE.data;
        j jVar3 = new j(jVar2.f5475b.f5457a);
        int iA0 = v.a0(iB, color, 0.1f);
        jVar3.m(new ColorStateList(iArr, new int[]{iA0, 0}));
        jVar3.setTint(color);
        ColorStateList colorStateList = new ColorStateList(iArr, new int[]{iA0, color});
        j jVar4 = new j(jVar2.f5475b.f5457a);
        jVar4.setTint(-1);
        return new LayerDrawable(new Drawable[]{new RippleDrawable(colorStateList, jVar3, jVar4), jVar2});
    }

    private Drawable getOrCreateFilledDropDownMenuBackground() {
        if (this.J == null) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            this.J = stateListDrawable;
            stateListDrawable.addState(new int[]{R.attr.state_above_anchor}, getOrCreateOutlinedDropDownMenuBackground());
            this.J.addState(new int[0], h(false));
        }
        return this.J;
    }

    private Drawable getOrCreateOutlinedDropDownMenuBackground() {
        if (this.I == null) {
            this.I = h(true);
        }
        return this.I;
    }

    public static void m(ViewGroup viewGroup, boolean z) {
        int childCount = viewGroup.getChildCount();
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = viewGroup.getChildAt(i8);
            childAt.setEnabled(z);
            if (childAt instanceof ViewGroup) {
                m((ViewGroup) childAt, z);
            }
        }
    }

    private void setEditText(EditText editText) throws Resources.NotFoundException {
        if (this.f1359e != null) {
            throw new IllegalArgumentException("We already have an EditText, can only have one");
        }
        if (getEndIconMode() != 3 && !(editText instanceof TextInputEditText)) {
            Log.i("TextInputLayout", "EditText added is not a TextInputEditText. Please switch to using that class instead.");
        }
        this.f1359e = editText;
        int i8 = this.f1363g;
        if (i8 != -1) {
            setMinEms(i8);
        } else {
            setMinWidth(this.f1368j);
        }
        int i9 = this.f1365h;
        if (i9 != -1) {
            setMaxEms(i9);
        } else {
            setMaxWidth(this.f1370k);
        }
        this.K = false;
        k();
        setTextInputAccessibilityDelegate(new w1.v(this));
        Typeface typeface = this.f1359e.getTypeface();
        b bVar = this.f1396x0;
        bVar.n(typeface);
        float textSize = this.f1359e.getTextSize();
        if (bVar.f4676h != textSize) {
            bVar.f4676h = textSize;
            bVar.j(false);
        }
        float letterSpacing = this.f1359e.getLetterSpacing();
        if (bVar.X != letterSpacing) {
            bVar.X = letterSpacing;
            bVar.j(false);
        }
        int gravity = this.f1359e.getGravity();
        int i10 = (gravity & (-113)) | 48;
        if (bVar.f4674g != i10) {
            bVar.f4674g = i10;
            bVar.j(false);
        }
        if (bVar.f4672f != gravity) {
            bVar.f4672f = gravity;
            bVar.j(false);
        }
        this.f1392v0 = editText.getMinimumHeight();
        this.f1359e.addTextChangedListener(new u(this, editText));
        if (this.k0 == null) {
            this.k0 = this.f1359e.getHintTextColors();
        }
        if (this.E) {
            if (TextUtils.isEmpty(this.F)) {
                CharSequence hint = this.f1359e.getHint();
                this.f1361f = hint;
                setHint(hint);
                this.f1359e.setHint((CharSequence) null);
            }
            this.G = true;
        }
        r();
        if (this.f1381q != null) {
            p(this.f1359e.getText());
        }
        t();
        this.f1371l.b();
        this.f1354b.bringToFront();
        o oVar = this.f1356c;
        oVar.bringToFront();
        Iterator it = this.f1364g0.iterator();
        while (it.hasNext()) {
            ((w1.n) it.next()).a(this);
        }
        oVar.m();
        if (!isEnabled()) {
            editText.setEnabled(false);
        }
        w(false, true);
    }

    private void setHintInternal(CharSequence charSequence) {
        if (TextUtils.equals(charSequence, this.F)) {
            return;
        }
        this.F = charSequence;
        b bVar = this.f1396x0;
        if (charSequence == null || !TextUtils.equals(bVar.B, charSequence)) {
            bVar.B = charSequence;
            bVar.C = null;
            bVar.j(false);
        }
        if (this.f1394w0) {
            return;
        }
        l();
    }

    private void setPlaceholderTextEnabled(boolean z) {
        if (this.f1389u == z) {
            return;
        }
        if (z) {
            g0 g0Var = this.f1391v;
            if (g0Var != null) {
                this.f1352a.addView(g0Var);
                this.f1391v.setVisibility(0);
            }
        } else {
            g0 g0Var2 = this.f1391v;
            if (g0Var2 != null) {
                g0Var2.setVisibility(8);
            }
            this.f1391v = null;
        }
        this.f1389u = z;
    }

    public final void a() {
        if (this.f1359e == null || this.Q != 1) {
            return;
        }
        if (getHintMaxLines() != 1) {
            EditText editText = this.f1359e;
            editText.setPaddingRelative(editText.getPaddingStart(), (int) (this.f1396x0.f() + this.d), this.f1359e.getPaddingEnd(), getResources().getDimensionPixelSize(com.stepos.stepclaw.R.dimen.material_filled_edittext_font_1_3_padding_bottom));
        } else if (getContext().getResources().getConfiguration().fontScale >= 2.0f) {
            EditText editText2 = this.f1359e;
            editText2.setPaddingRelative(editText2.getPaddingStart(), getResources().getDimensionPixelSize(com.stepos.stepclaw.R.dimen.material_filled_edittext_font_2_0_padding_top), this.f1359e.getPaddingEnd(), getResources().getDimensionPixelSize(com.stepos.stepclaw.R.dimen.material_filled_edittext_font_2_0_padding_bottom));
        } else if (v.W(getContext())) {
            EditText editText3 = this.f1359e;
            editText3.setPaddingRelative(editText3.getPaddingStart(), getResources().getDimensionPixelSize(com.stepos.stepclaw.R.dimen.material_filled_edittext_font_1_3_padding_top), this.f1359e.getPaddingEnd(), getResources().getDimensionPixelSize(com.stepos.stepclaw.R.dimen.material_filled_edittext_font_1_3_padding_bottom));
        }
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i8, ViewGroup.LayoutParams layoutParams) throws Resources.NotFoundException {
        if (!(view instanceof EditText)) {
            super.addView(view, i8, layoutParams);
            return;
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams);
        layoutParams2.gravity = (layoutParams2.gravity & (-113)) | 16;
        FrameLayout frameLayout = this.f1352a;
        frameLayout.addView(view, layoutParams2);
        frameLayout.setLayoutParams(layoutParams);
        v();
        setEditText((EditText) view);
    }

    public final void b(float f3) {
        b bVar = this.f1396x0;
        if (bVar.f4665b == f3) {
            return;
        }
        int i8 = 2;
        if (this.A0 == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.A0 = valueAnimator;
            valueAnimator.setInterpolator(v.h0(getContext(), com.stepos.stepclaw.R.attr.motionEasingEmphasizedInterpolator, e1.a.f2340b));
            this.A0.setDuration(v.g0(getContext(), com.stepos.stepclaw.R.attr.motionDurationMedium4, 167));
            this.A0.addUpdateListener(new i1.a(i8, this));
        }
        this.A0.setFloatValues(bVar.f4665b, f3);
        this.A0.start();
    }

    public final void c() {
        int i8;
        int i9;
        j jVar = this.H;
        if (jVar == null) {
            return;
        }
        n nVar = jVar.f5475b.f5457a;
        n nVar2 = this.N;
        if (nVar != nVar2) {
            jVar.setShapeAppearanceModel(nVar2);
        }
        if (this.Q == 2 && (i8 = this.S) > -1 && (i9 = this.V) != 0) {
            j jVar2 = this.H;
            jVar2.f5475b.f5466k = i8;
            jVar2.invalidateSelf();
            ColorStateList colorStateListValueOf = ColorStateList.valueOf(i9);
            t1.h hVar = jVar2.f5475b;
            if (hVar.f5460e != colorStateListValueOf) {
                hVar.f5460e = colorStateListValueOf;
                jVar2.onStateChange(jVar2.getState());
            }
        }
        int iB = this.W;
        if (this.Q == 1) {
            iB = x.a.b(this.W, v.A(getContext(), com.stepos.stepclaw.R.attr.colorSurface, 0));
        }
        this.W = iB;
        this.H.m(ColorStateList.valueOf(iB));
        j jVar3 = this.L;
        if (jVar3 != null && this.M != null) {
            if (this.S > -1 && this.V != 0) {
                jVar3.m(this.f1359e.isFocused() ? ColorStateList.valueOf(this.f1374m0) : ColorStateList.valueOf(this.V));
                this.M.m(ColorStateList.valueOf(this.V));
            }
            invalidate();
        }
        u();
    }

    public final Rect d(Rect rect) {
        if (this.f1359e == null) {
            throw new IllegalStateException();
        }
        boolean z = getLayoutDirection() == 1;
        int i8 = rect.bottom;
        Rect rect2 = this.f1355b0;
        rect2.bottom = i8;
        int i9 = this.Q;
        if (i9 == 1) {
            rect2.left = i(rect.left, z);
            rect2.top = rect.top + this.R;
            rect2.right = j(rect.right, z);
            return rect2;
        }
        if (i9 != 2) {
            rect2.left = i(rect.left, z);
            rect2.top = getPaddingTop();
            rect2.right = j(rect.right, z);
            return rect2;
        }
        rect2.left = this.f1359e.getPaddingLeft() + rect.left;
        rect2.top = rect.top - e();
        rect2.right = rect.right - this.f1359e.getPaddingRight();
        return rect2;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchProvideAutofillStructure(ViewStructure viewStructure, int i8) {
        EditText editText = this.f1359e;
        if (editText == null) {
            super.dispatchProvideAutofillStructure(viewStructure, i8);
            return;
        }
        if (this.f1361f != null) {
            boolean z = this.G;
            this.G = false;
            CharSequence hint = editText.getHint();
            this.f1359e.setHint(this.f1361f);
            try {
                super.dispatchProvideAutofillStructure(viewStructure, i8);
                return;
            } finally {
                this.f1359e.setHint(hint);
                this.G = z;
            }
        }
        viewStructure.setAutofillId(getAutofillId());
        onProvideAutofillStructure(viewStructure, i8);
        onProvideAutofillVirtualStructure(viewStructure, i8);
        FrameLayout frameLayout = this.f1352a;
        viewStructure.setChildCount(frameLayout.getChildCount());
        for (int i9 = 0; i9 < frameLayout.getChildCount(); i9++) {
            View childAt = frameLayout.getChildAt(i9);
            ViewStructure viewStructureNewChild = viewStructure.newChild(i9);
            childAt.dispatchProvideAutofillStructure(viewStructureNewChild, i8);
            if (childAt == this.f1359e) {
                viewStructureNewChild.setHint(getHint());
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchRestoreInstanceState(SparseArray sparseArray) {
        this.C0 = true;
        super.dispatchRestoreInstanceState(sparseArray);
        this.C0 = false;
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        j jVar;
        super.draw(canvas);
        boolean z = this.E;
        b bVar = this.f1396x0;
        if (z) {
            TextPaint textPaint = bVar.O;
            RectF rectF = bVar.f4670e;
            int iSave = canvas.save();
            if (bVar.C != null && rectF.width() > 0.0f && rectF.height() > 0.0f) {
                textPaint.setTextSize(bVar.G);
                float f3 = bVar.f4688q;
                float f7 = bVar.f4689r;
                float f9 = bVar.F;
                if (f9 != 1.0f) {
                    canvas.scale(f9, f9, f3, f7);
                }
                if ((bVar.f4671e0 > 1 || bVar.f4673f0 > 1) && !bVar.D && bVar.o()) {
                    float lineStart = bVar.f4688q - bVar.Z.getLineStart(0);
                    int alpha = textPaint.getAlpha();
                    canvas.translate(lineStart, f7);
                    float f10 = alpha;
                    textPaint.setAlpha((int) (bVar.f4668c0 * f10));
                    float f11 = bVar.H;
                    float f12 = bVar.I;
                    float f13 = bVar.J;
                    int i8 = bVar.K;
                    textPaint.setShadowLayer(f11, f12, f13, x.a.d(i8, (Color.alpha(i8) * textPaint.getAlpha()) / 255));
                    bVar.Z.draw(canvas);
                    textPaint.setAlpha((int) (bVar.f4666b0 * f10));
                    float f14 = bVar.H;
                    float f15 = bVar.I;
                    float f16 = bVar.J;
                    int i9 = bVar.K;
                    textPaint.setShadowLayer(f14, f15, f16, x.a.d(i9, (Color.alpha(i9) * textPaint.getAlpha()) / 255));
                    int lineBaseline = bVar.Z.getLineBaseline(0);
                    CharSequence charSequence = bVar.f4669d0;
                    float f17 = lineBaseline;
                    canvas.drawText(charSequence, 0, charSequence.length(), 0.0f, f17, textPaint);
                    textPaint.setShadowLayer(bVar.H, bVar.I, bVar.J, bVar.K);
                    String strTrim = bVar.f4669d0.toString().trim();
                    if (strTrim.endsWith("…")) {
                        strTrim = strTrim.substring(0, strTrim.length() - 1);
                    }
                    String str = strTrim;
                    textPaint.setAlpha(alpha);
                    canvas.drawText(str, 0, Math.min(bVar.Z.getLineEnd(0), str.length()), 0.0f, f17, (Paint) textPaint);
                    canvas = canvas;
                } else {
                    canvas.translate(f3, f7);
                    bVar.Z.draw(canvas);
                }
                canvas.restoreToCount(iSave);
            }
        }
        if (this.M == null || (jVar = this.L) == null) {
            return;
        }
        jVar.draw(canvas);
        if (this.f1359e.isFocused()) {
            Rect bounds = this.M.getBounds();
            Rect bounds2 = this.L.getBounds();
            float f18 = bVar.f4665b;
            int iCenterX = bounds2.centerX();
            bounds.left = e1.a.c(iCenterX, bounds2.left, f18);
            bounds.right = e1.a.c(iCenterX, bounds2.right, f18);
            this.M.draw(canvas);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002f  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void drawableStateChanged() throws android.content.res.Resources.NotFoundException {
        /*
            r4 = this;
            boolean r0 = r4.B0
            if (r0 == 0) goto L5
            return
        L5:
            r0 = 1
            r4.B0 = r0
            super.drawableStateChanged()
            int[] r1 = r4.getDrawableState()
            r2 = 0
            p1.b r3 = r4.f1396x0
            if (r3 == 0) goto L2f
            r3.M = r1
            android.content.res.ColorStateList r1 = r3.f4682k
            if (r1 == 0) goto L20
            boolean r1 = r1.isStateful()
            if (r1 != 0) goto L2a
        L20:
            android.content.res.ColorStateList r1 = r3.f4680j
            if (r1 == 0) goto L2f
            boolean r1 = r1.isStateful()
            if (r1 == 0) goto L2f
        L2a:
            r3.j(r2)
            r1 = r0
            goto L30
        L2f:
            r1 = r2
        L30:
            android.widget.EditText r3 = r4.f1359e
            if (r3 == 0) goto L45
            boolean r3 = r4.isLaidOut()
            if (r3 == 0) goto L41
            boolean r3 = r4.isEnabled()
            if (r3 == 0) goto L41
            goto L42
        L41:
            r0 = r2
        L42:
            r4.w(r0, r2)
        L45:
            r4.t()
            r4.z()
            if (r1 == 0) goto L50
            r4.invalidate()
        L50:
            r4.B0 = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.drawableStateChanged():void");
    }

    public final int e() {
        if (this.E) {
            int i8 = this.Q;
            b bVar = this.f1396x0;
            if (i8 == 0) {
                return (int) bVar.f();
            }
            if (i8 == 2) {
                if (getHintMaxLines() == 1) {
                    return (int) (bVar.f() / 2.0f);
                }
                float f3 = bVar.f();
                TextPaint textPaint = bVar.P;
                textPaint.setTextSize(bVar.f4678i);
                textPaint.setTypeface(bVar.f4690s);
                textPaint.setLetterSpacing(bVar.W);
                return Math.max(0, (int) (f3 - ((-textPaint.ascent()) / 2.0f)));
            }
        }
        return 0;
    }

    public final h f() {
        h hVar = new h();
        hVar.f43c = v.g0(getContext(), com.stepos.stepclaw.R.attr.motionDurationShort2, 87);
        hVar.d = v.h0(getContext(), com.stepos.stepclaw.R.attr.motionEasingLinearInterpolator, e1.a.f2339a);
        return hVar;
    }

    public final boolean g() {
        return this.E && !TextUtils.isEmpty(this.F) && (this.H instanceof w1.h);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public int getBaseline() {
        EditText editText = this.f1359e;
        if (editText == null) {
            return super.getBaseline();
        }
        return e() + getPaddingTop() + editText.getBaseline();
    }

    public j getBoxBackground() {
        int i8 = this.Q;
        if (i8 == 1 || i8 == 2) {
            return this.H;
        }
        throw new IllegalStateException();
    }

    public int getBoxBackgroundColor() {
        return this.W;
    }

    public int getBoxBackgroundMode() {
        return this.Q;
    }

    public int getBoxCollapsedPaddingTop() {
        return this.R;
    }

    public float getBoxCornerRadiusBottomEnd() {
        int layoutDirection = getLayoutDirection();
        RectF rectF = this.f1357c0;
        return layoutDirection == 1 ? this.N.f5514h.a(rectF) : this.N.f5513g.a(rectF);
    }

    public float getBoxCornerRadiusBottomStart() {
        int layoutDirection = getLayoutDirection();
        RectF rectF = this.f1357c0;
        return layoutDirection == 1 ? this.N.f5513g.a(rectF) : this.N.f5514h.a(rectF);
    }

    public float getBoxCornerRadiusTopEnd() {
        int layoutDirection = getLayoutDirection();
        RectF rectF = this.f1357c0;
        return layoutDirection == 1 ? this.N.f5511e.a(rectF) : this.N.f5512f.a(rectF);
    }

    public float getBoxCornerRadiusTopStart() {
        int layoutDirection = getLayoutDirection();
        RectF rectF = this.f1357c0;
        return layoutDirection == 1 ? this.N.f5512f.a(rectF) : this.N.f5511e.a(rectF);
    }

    public int getBoxStrokeColor() {
        return this.f1378o0;
    }

    public ColorStateList getBoxStrokeErrorColor() {
        return this.f1380p0;
    }

    public int getBoxStrokeWidth() {
        return this.T;
    }

    public int getBoxStrokeWidthFocused() {
        return this.U;
    }

    public int getCounterMaxLength() {
        return this.f1375n;
    }

    public CharSequence getCounterOverflowDescription() {
        g0 g0Var;
        if (this.f1373m && this.f1377o && (g0Var = this.f1381q) != null) {
            return g0Var.getContentDescription();
        }
        return null;
    }

    public ColorStateList getCounterOverflowTextColor() {
        return this.B;
    }

    public ColorStateList getCounterTextColor() {
        return this.A;
    }

    public ColorStateList getCursorColor() {
        return this.C;
    }

    public ColorStateList getCursorErrorColor() {
        return this.D;
    }

    public ColorStateList getDefaultHintTextColor() {
        return this.k0;
    }

    public EditText getEditText() {
        return this.f1359e;
    }

    public CharSequence getEndIconContentDescription() {
        return this.f1356c.f6123g.getContentDescription();
    }

    public Drawable getEndIconDrawable() {
        return this.f1356c.f6123g.getDrawable();
    }

    public int getEndIconMinSize() {
        return this.f1356c.f6129n;
    }

    public int getEndIconMode() {
        return this.f1356c.f6125j;
    }

    public ImageView.ScaleType getEndIconScaleType() {
        return this.f1356c.f6130o;
    }

    public CheckableImageButton getEndIconView() {
        return this.f1356c.f6123g;
    }

    public CharSequence getError() {
        r rVar = this.f1371l;
        if (rVar.f6158q) {
            return rVar.f6157p;
        }
        return null;
    }

    public int getErrorAccessibilityLiveRegion() {
        return this.f1371l.f6161t;
    }

    public CharSequence getErrorContentDescription() {
        return this.f1371l.f6160s;
    }

    public int getErrorCurrentTextColors() {
        g0 g0Var = this.f1371l.f6159r;
        if (g0Var != null) {
            return g0Var.getCurrentTextColor();
        }
        return -1;
    }

    public Drawable getErrorIconDrawable() {
        return this.f1356c.f6120c.getDrawable();
    }

    public CharSequence getHelperText() {
        r rVar = this.f1371l;
        if (rVar.f6165x) {
            return rVar.f6164w;
        }
        return null;
    }

    public int getHelperTextCurrentTextColor() {
        g0 g0Var = this.f1371l.y;
        if (g0Var != null) {
            return g0Var.getCurrentTextColor();
        }
        return -1;
    }

    public CharSequence getHint() {
        if (this.E) {
            return this.F;
        }
        return null;
    }

    public final float getHintCollapsedTextHeight() {
        return this.f1396x0.f();
    }

    public final int getHintCurrentCollapsedTextColor() {
        b bVar = this.f1396x0;
        return bVar.g(bVar.f4682k);
    }

    public int getHintMaxLines() {
        return this.f1396x0.f4671e0;
    }

    public ColorStateList getHintTextColor() {
        return this.f1372l0;
    }

    public w getLengthCounter() {
        return this.f1379p;
    }

    public int getMaxEms() {
        return this.f1365h;
    }

    public int getMaxWidth() {
        return this.f1370k;
    }

    public int getMinEms() {
        return this.f1363g;
    }

    public int getMinWidth() {
        return this.f1368j;
    }

    @Deprecated
    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.f1356c.f6123g.getContentDescription();
    }

    @Deprecated
    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.f1356c.f6123g.getDrawable();
    }

    public CharSequence getPlaceholderText() {
        if (this.f1389u) {
            return this.f1387t;
        }
        return null;
    }

    public int getPlaceholderTextAppearance() {
        return this.f1395x;
    }

    public ColorStateList getPlaceholderTextColor() {
        return this.f1393w;
    }

    public CharSequence getPrefixText() {
        return this.f1354b.f6171c;
    }

    public ColorStateList getPrefixTextColor() {
        return this.f1354b.f6170b.getTextColors();
    }

    public TextView getPrefixTextView() {
        return this.f1354b.f6170b;
    }

    public n getShapeAppearanceModel() {
        return this.N;
    }

    public CharSequence getStartIconContentDescription() {
        return this.f1354b.d.getContentDescription();
    }

    public Drawable getStartIconDrawable() {
        return this.f1354b.d.getDrawable();
    }

    public int getStartIconMinSize() {
        return this.f1354b.f6174g;
    }

    public ImageView.ScaleType getStartIconScaleType() {
        return this.f1354b.f6175h;
    }

    public CharSequence getSuffixText() {
        return this.f1356c.f6132q;
    }

    public ColorStateList getSuffixTextColor() {
        return this.f1356c.f6133r.getTextColors();
    }

    public TextView getSuffixTextView() {
        return this.f1356c.f6133r;
    }

    public Typeface getTypeface() {
        return this.f1358d0;
    }

    public final j h(boolean z) throws Resources.NotFoundException {
        float dimensionPixelOffset = getResources().getDimensionPixelOffset(com.stepos.stepclaw.R.dimen.mtrl_shape_corner_size_small_component);
        float f3 = z ? dimensionPixelOffset : 0.0f;
        float dimensionPixelOffset2 = getResources().getDimensionPixelOffset(com.stepos.stepclaw.R.dimen.m3_comp_outlined_autocomplete_menu_container_elevation);
        int dimensionPixelOffset3 = getResources().getDimensionPixelOffset(com.stepos.stepclaw.R.dimen.mtrl_exposed_dropdown_menu_popup_vertical_padding);
        l lVar = new l();
        l lVar2 = new l();
        l lVar3 = new l();
        l lVar4 = new l();
        int i8 = 0;
        f fVar = new f(i8);
        f fVar2 = new f(i8);
        f fVar3 = new f(i8);
        f fVar4 = new f(i8);
        t1.a aVar = new t1.a(f3);
        t1.a aVar2 = new t1.a(f3);
        t1.a aVar3 = new t1.a(dimensionPixelOffset);
        t1.a aVar4 = new t1.a(dimensionPixelOffset);
        n nVar = new n();
        nVar.f5508a = lVar;
        nVar.f5509b = lVar2;
        nVar.f5510c = lVar3;
        nVar.d = lVar4;
        nVar.f5511e = aVar;
        nVar.f5512f = aVar2;
        nVar.f5513g = aVar4;
        nVar.f5514h = aVar3;
        nVar.f5515i = fVar;
        nVar.f5516j = fVar2;
        nVar.f5517k = fVar3;
        nVar.f5518l = fVar4;
        Context context = getContext();
        i[] iVarArr = j.D;
        TypedValue typedValueE = z.E(context, com.stepos.stepclaw.R.attr.colorSurface, j.class.getSimpleName());
        int i9 = typedValueE.resourceId;
        ColorStateList colorStateListValueOf = ColorStateList.valueOf(i9 != 0 ? context.getColor(i9) : typedValueE.data);
        j jVar = new j();
        jVar.j(context);
        jVar.m(colorStateListValueOf);
        jVar.l(dimensionPixelOffset2);
        jVar.setShapeAppearanceModel(nVar);
        t1.h hVar = jVar.f5475b;
        if (hVar.f5463h == null) {
            hVar.f5463h = new Rect();
        }
        jVar.f5475b.f5463h.set(0, dimensionPixelOffset3, 0, dimensionPixelOffset3);
        jVar.invalidateSelf();
        return jVar;
    }

    public final int i(int i8, boolean z) {
        return ((z || getPrefixText() == null) ? (!z || getSuffixText() == null) ? this.f1359e.getCompoundPaddingLeft() : this.f1356c.c() : this.f1354b.a()) + i8;
    }

    public final int j(int i8, boolean z) {
        return i8 - ((z || getSuffixText() == null) ? (!z || getPrefixText() == null) ? this.f1359e.getCompoundPaddingRight() : this.f1354b.a() : this.f1356c.c());
    }

    public final void k() throws Resources.NotFoundException {
        int i8 = this.Q;
        if (i8 == 0) {
            this.H = null;
            this.L = null;
            this.M = null;
        } else if (i8 == 1) {
            this.H = new j(this.N);
            this.L = new j();
            this.M = new j();
        } else {
            if (i8 != 2) {
                throw new IllegalArgumentException(m0.f.e(new StringBuilder(), this.Q, " is illegal; only @BoxBackgroundMode constants are supported."));
            }
            if (!this.E || (this.H instanceof w1.h)) {
                this.H = new j(this.N);
            } else {
                n nVar = this.N;
                int i9 = w1.h.F;
                if (nVar == null) {
                    nVar = new n();
                }
                g gVar = new g(nVar, new RectF());
                w1.h hVar = new w1.h(gVar);
                hVar.E = gVar;
                this.H = hVar;
            }
            this.L = null;
            this.M = null;
        }
        u();
        z();
        if (this.Q == 1) {
            if (getContext().getResources().getConfiguration().fontScale >= 2.0f) {
                this.R = getResources().getDimensionPixelSize(com.stepos.stepclaw.R.dimen.material_font_2_0_box_collapsed_padding_top);
            } else if (v.W(getContext())) {
                this.R = getResources().getDimensionPixelSize(com.stepos.stepclaw.R.dimen.material_font_1_3_box_collapsed_padding_top);
            }
        }
        a();
        if (this.Q != 0) {
            v();
        }
        EditText editText = this.f1359e;
        if (editText instanceof AutoCompleteTextView) {
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) editText;
            if (autoCompleteTextView.getDropDownBackground() == null) {
                int i10 = this.Q;
                if (i10 == 2) {
                    autoCompleteTextView.setDropDownBackgroundDrawable(getOrCreateOutlinedDropDownMenuBackground());
                } else if (i10 == 1) {
                    autoCompleteTextView.setDropDownBackgroundDrawable(getOrCreateFilledDropDownMenuBackground());
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00cb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void l() {
        /*
            Method dump skipped, instructions count: 285
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.l():void");
    }

    public final void n(g0 g0Var, int i8) {
        try {
            g0Var.setTextAppearance(i8);
            if (g0Var.getTextColors().getDefaultColor() != -65281) {
                return;
            }
        } catch (Exception unused) {
        }
        g0Var.setTextAppearance(com.stepos.stepclaw.R.style.TextAppearance_AppCompat_Caption);
        g0Var.setTextColor(getContext().getColor(com.stepos.stepclaw.R.color.design_error));
    }

    public final boolean o() {
        r rVar = this.f1371l;
        return (rVar.f6156o != 1 || rVar.f6159r == null || TextUtils.isEmpty(rVar.f6157p)) ? false : true;
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f1396x0.i(configuration);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        int iMax;
        o oVar = this.f1356c;
        oVar.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        boolean z = false;
        this.D0 = false;
        if (this.f1359e != null && this.f1359e.getMeasuredHeight() < (iMax = Math.max(oVar.getMeasuredHeight(), this.f1354b.getMeasuredHeight()))) {
            this.f1359e.setMinimumHeight(iMax);
            z = true;
        }
        boolean zS = s();
        if (z || zS) {
            this.f1359e.post(new androidx.emoji2.text.t(10, this));
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i8, int i9, int i10, int i11) {
        float fDescent;
        int i12;
        int compoundPaddingTop;
        super.onLayout(z, i8, i9, i10, i11);
        EditText editText = this.f1359e;
        if (editText != null) {
            Rect rect = this.f1353a0;
            c.a(this, editText, rect);
            j jVar = this.L;
            if (jVar != null) {
                int i13 = rect.bottom;
                jVar.setBounds(rect.left, i13 - this.T, rect.right, i13);
            }
            j jVar2 = this.M;
            if (jVar2 != null) {
                int i14 = rect.bottom;
                jVar2.setBounds(rect.left, i14 - this.U, rect.right, i14);
            }
            if (this.E) {
                float textSize = this.f1359e.getTextSize();
                b bVar = this.f1396x0;
                float f3 = bVar.f4676h;
                TextPaint textPaint = bVar.P;
                if (f3 != textSize) {
                    bVar.f4676h = textSize;
                    bVar.j(false);
                }
                int gravity = this.f1359e.getGravity();
                int i15 = (gravity & (-113)) | 48;
                if (bVar.f4674g != i15) {
                    bVar.f4674g = i15;
                    bVar.j(false);
                }
                if (bVar.f4672f != gravity) {
                    bVar.f4672f = gravity;
                    bVar.j(false);
                }
                Rect rectD = d(rect);
                int i16 = rectD.left;
                int i17 = rectD.top;
                int i18 = rectD.right;
                int i19 = rectD.bottom;
                Rect rect2 = bVar.d;
                if (rect2.left != i16 || rect2.top != i17 || rect2.right != i18 || rect2.bottom != i19) {
                    rect2.set(i16, i17, i18, i19);
                    bVar.N = true;
                }
                if (this.f1359e == null) {
                    throw new IllegalStateException();
                }
                if (getHintMaxLines() == 1) {
                    textPaint.setTextSize(bVar.f4676h);
                    textPaint.setTypeface(bVar.f4693v);
                    textPaint.setLetterSpacing(bVar.X);
                    fDescent = -textPaint.ascent();
                } else {
                    textPaint.setTextSize(bVar.f4676h);
                    textPaint.setTypeface(bVar.f4693v);
                    textPaint.setLetterSpacing(bVar.X);
                    fDescent = bVar.f4683l * (textPaint.descent() + (-textPaint.ascent()));
                }
                int compoundPaddingLeft = this.f1359e.getCompoundPaddingLeft() + rect.left;
                Rect rect3 = this.f1355b0;
                rect3.left = compoundPaddingLeft;
                if (this.Q != 1 || this.f1359e.getMinLines() > 1) {
                    if (this.Q != 0 || getHintMaxLines() == 1) {
                        i12 = 0;
                    } else {
                        textPaint.setTextSize(bVar.f4676h);
                        textPaint.setTypeface(bVar.f4693v);
                        textPaint.setLetterSpacing(bVar.X);
                        i12 = (int) ((-textPaint.ascent()) / 2.0f);
                    }
                    compoundPaddingTop = (this.f1359e.getCompoundPaddingTop() + rect.top) - i12;
                } else {
                    compoundPaddingTop = (int) (rect.centerY() - (fDescent / 2.0f));
                }
                rect3.top = compoundPaddingTop;
                rect3.right = rect.right - this.f1359e.getCompoundPaddingRight();
                int compoundPaddingBottom = (this.Q != 1 || this.f1359e.getMinLines() > 1) ? rect.bottom - this.f1359e.getCompoundPaddingBottom() : (int) (rect3.top + fDescent);
                rect3.bottom = compoundPaddingBottom;
                int i20 = rect3.left;
                int i21 = rect3.top;
                int i22 = rect3.right;
                Rect rect4 = bVar.f4667c;
                if (rect4.left != i20 || rect4.top != i21 || rect4.right != i22 || rect4.bottom != compoundPaddingBottom || true != bVar.k0) {
                    rect4.set(i20, i21, i22, compoundPaddingBottom);
                    bVar.N = true;
                    bVar.k0 = true;
                }
                bVar.j(false);
                if (!g() || this.f1394w0) {
                    return;
                }
                l();
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i8, int i9) {
        float f3;
        EditText editText;
        super.onMeasure(i8, i9);
        boolean z = this.D0;
        o oVar = this.f1356c;
        if (!z) {
            oVar.getViewTreeObserver().addOnGlobalLayoutListener(this);
            this.D0 = true;
        }
        if (this.f1391v != null && (editText = this.f1359e) != null) {
            this.f1391v.setGravity(editText.getGravity());
            this.f1391v.setPadding(this.f1359e.getCompoundPaddingLeft(), this.f1359e.getCompoundPaddingTop(), this.f1359e.getCompoundPaddingRight(), this.f1359e.getCompoundPaddingBottom());
        }
        oVar.m();
        if (getHintMaxLines() == 1) {
            return;
        }
        int measuredWidth = (this.f1359e.getMeasuredWidth() - this.f1359e.getCompoundPaddingLeft()) - this.f1359e.getCompoundPaddingRight();
        b bVar = this.f1396x0;
        TextPaint textPaint = bVar.P;
        textPaint.setTextSize(bVar.f4678i);
        textPaint.setTypeface(bVar.f4690s);
        textPaint.setLetterSpacing(bVar.W);
        float f7 = measuredWidth;
        bVar.f4679i0 = bVar.e(bVar.f4673f0, textPaint, bVar.B, (bVar.f4678i / bVar.f4676h) * f7, bVar.D).getHeight();
        textPaint.setTextSize(bVar.f4676h);
        textPaint.setTypeface(bVar.f4693v);
        textPaint.setLetterSpacing(bVar.X);
        bVar.f4681j0 = bVar.e(bVar.f4671e0, textPaint, bVar.B, f7, bVar.D).getHeight();
        EditText editText2 = this.f1359e;
        Rect rect = this.f1353a0;
        c.a(this, editText2, rect);
        Rect rectD = d(rect);
        int i10 = rectD.left;
        int i11 = rectD.top;
        int i12 = rectD.right;
        int i13 = rectD.bottom;
        Rect rect2 = bVar.d;
        if (rect2.left != i10 || rect2.top != i11 || rect2.right != i12 || rect2.bottom != i13) {
            rect2.set(i10, i11, i12, i13);
            bVar.N = true;
        }
        v();
        a();
        if (this.f1359e == null) {
            return;
        }
        int i14 = bVar.f4681j0;
        if (i14 != -1) {
            f3 = i14;
        } else {
            TextPaint textPaint2 = bVar.P;
            textPaint2.setTextSize(bVar.f4676h);
            textPaint2.setTypeface(bVar.f4693v);
            textPaint2.setLetterSpacing(bVar.X);
            f3 = -textPaint2.ascent();
        }
        if (this.f1387t != null) {
            TextPaint textPaint3 = new TextPaint(129);
            textPaint3.set(this.f1391v.getPaint());
            textPaint3.setTextSize(this.f1391v.getTextSize());
            textPaint3.setTypeface(this.f1391v.getTypeface());
            textPaint3.setLetterSpacing(this.f1391v.getLetterSpacing());
            p1.g gVar = new p1.g(this.f1387t, textPaint3, measuredWidth);
            gVar.f4713k = getLayoutDirection() == 1;
            gVar.f4712j = true;
            float lineSpacingExtra = this.f1391v.getLineSpacingExtra();
            float lineSpacingMultiplier = this.f1391v.getLineSpacingMultiplier();
            gVar.f4709g = lineSpacingExtra;
            gVar.f4710h = lineSpacingMultiplier;
            gVar.f4715m = new j1.a(this);
            f = (this.Q == 1 ? bVar.f() + this.R + this.d : 0.0f) + gVar.a().getHeight();
        }
        float fMax = Math.max(f3, f);
        if (this.f1359e.getMeasuredHeight() < fMax) {
            this.f1359e.setMinimumHeight(Math.round(fMax));
        }
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) throws Resources.NotFoundException {
        if (!(parcelable instanceof x)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        x xVar = (x) parcelable;
        super.onRestoreInstanceState(xVar.f3000a);
        setError(xVar.f6181c);
        if (xVar.d) {
            post(new androidx.fragment.app.b(12, this));
        }
        requestLayout();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onRtlPropertiesChanged(int i8) {
        super.onRtlPropertiesChanged(i8);
        boolean z = i8 == 1;
        if (z != this.O) {
            t1.d dVar = this.N.f5511e;
            RectF rectF = this.f1357c0;
            float fA = dVar.a(rectF);
            float fA2 = this.N.f5512f.a(rectF);
            float fA3 = this.N.f5514h.a(rectF);
            float fA4 = this.N.f5513g.a(rectF);
            n nVar = this.N;
            v vVar = nVar.f5508a;
            v vVar2 = nVar.f5509b;
            v vVar3 = nVar.d;
            v vVar4 = nVar.f5510c;
            f fVar = new f(0);
            f fVar2 = new f(0);
            f fVar3 = new f(0);
            f fVar4 = new f(0);
            t1.a aVar = new t1.a(fA2);
            t1.a aVar2 = new t1.a(fA);
            t1.a aVar3 = new t1.a(fA4);
            t1.a aVar4 = new t1.a(fA3);
            n nVar2 = new n();
            nVar2.f5508a = vVar2;
            nVar2.f5509b = vVar;
            nVar2.f5510c = vVar3;
            nVar2.d = vVar4;
            nVar2.f5511e = aVar;
            nVar2.f5512f = aVar2;
            nVar2.f5513g = aVar4;
            nVar2.f5514h = aVar3;
            nVar2.f5515i = fVar;
            nVar2.f5516j = fVar2;
            nVar2.f5517k = fVar3;
            nVar2.f5518l = fVar4;
            this.O = z;
            setShapeAppearanceModel(nVar2);
        }
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        x xVar = new x(super.onSaveInstanceState());
        if (o()) {
            xVar.f6181c = getError();
        }
        o oVar = this.f1356c;
        xVar.d = oVar.f6125j != 0 && oVar.f6123g.d;
        return xVar;
    }

    public final void p(Editable editable) throws Resources.NotFoundException {
        ((a1.n) this.f1379p).getClass();
        int length = editable != null ? editable.length() : 0;
        boolean z = this.f1377o;
        int i8 = this.f1375n;
        if (i8 == -1) {
            this.f1381q.setText(String.valueOf(length));
            this.f1381q.setContentDescription(null);
            this.f1377o = false;
        } else {
            this.f1377o = length > i8;
            Context context = getContext();
            this.f1381q.setContentDescription(context.getString(this.f1377o ? com.stepos.stepclaw.R.string.character_counter_overflowed_content_description : com.stepos.stepclaw.R.string.character_counter_content_description, Integer.valueOf(length), Integer.valueOf(this.f1375n)));
            if (z != this.f1377o) {
                q();
            }
            String str = c0.b.f1038b;
            c0.b bVar = TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1 ? c0.b.f1040e : c0.b.d;
            g0 g0Var = this.f1381q;
            String string = getContext().getString(com.stepos.stepclaw.R.string.character_counter_pattern, Integer.valueOf(length), Integer.valueOf(this.f1375n));
            bVar.getClass();
            c0.f fVar = c0.g.f1048a;
            g0Var.setText(string != null ? bVar.c(string).toString() : null);
        }
        if (this.f1359e == null || z == this.f1377o) {
            return;
        }
        w(false, false);
        z();
        t();
    }

    public final void q() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        g0 g0Var = this.f1381q;
        if (g0Var != null) {
            n(g0Var, this.f1377o ? this.f1383r : this.f1385s);
            if (!this.f1377o && (colorStateList2 = this.A) != null) {
                this.f1381q.setTextColor(colorStateList2);
            }
            if (!this.f1377o || (colorStateList = this.B) == null) {
                return;
            }
            this.f1381q.setTextColor(colorStateList);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void r() throws android.content.res.Resources.NotFoundException {
        /*
            r4 = this;
            android.content.res.ColorStateList r0 = r4.C
            if (r0 == 0) goto L5
            goto L26
        L5:
            android.content.Context r0 = r4.getContext()
            r1 = 2130903298(0x7f030102, float:1.741341E38)
            android.util.TypedValue r1 = k4.z.D(r0, r1)
            r2 = 0
            if (r1 != 0) goto L15
        L13:
            r0 = r2
            goto L26
        L15:
            int r3 = r1.resourceId
            if (r3 == 0) goto L1e
            android.content.res.ColorStateList r0 = k4.z.t(r0, r3)
            goto L26
        L1e:
            int r0 = r1.data
            if (r0 == 0) goto L13
            android.content.res.ColorStateList r0 = android.content.res.ColorStateList.valueOf(r0)
        L26:
            android.widget.EditText r1 = r4.f1359e
            if (r1 == 0) goto L51
            android.graphics.drawable.Drawable r1 = r1.getTextCursorDrawable()
            if (r1 != 0) goto L31
            goto L51
        L31:
            android.widget.EditText r1 = r4.f1359e
            android.graphics.drawable.Drawable r1 = r1.getTextCursorDrawable()
            android.graphics.drawable.Drawable r1 = r1.mutate()
            boolean r2 = r4.o()
            if (r2 != 0) goto L49
            g.g0 r2 = r4.f1381q
            if (r2 == 0) goto L4e
            boolean r2 = r4.f1377o
            if (r2 == 0) goto L4e
        L49:
            android.content.res.ColorStateList r4 = r4.D
            if (r4 == 0) goto L4e
            r0 = r4
        L4e:
            r1.setTintList(r0)
        L51:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.r():void");
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x005f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean s() {
        /*
            Method dump skipped, instructions count: 304
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.s():boolean");
    }

    public void setBoxBackgroundColor(int i8) {
        if (this.W != i8) {
            this.W = i8;
            this.f1382q0 = i8;
            this.f1386s0 = i8;
            this.f1388t0 = i8;
            c();
        }
    }

    public void setBoxBackgroundColorResource(int i8) {
        setBoxBackgroundColor(getContext().getColor(i8));
    }

    public void setBoxBackgroundColorStateList(ColorStateList colorStateList) {
        int defaultColor = colorStateList.getDefaultColor();
        this.f1382q0 = defaultColor;
        this.W = defaultColor;
        this.f1384r0 = colorStateList.getColorForState(new int[]{-16842910}, -1);
        this.f1386s0 = colorStateList.getColorForState(new int[]{R.attr.state_focused, R.attr.state_enabled}, -1);
        this.f1388t0 = colorStateList.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, -1);
        c();
    }

    public void setBoxBackgroundMode(int i8) throws Resources.NotFoundException {
        if (i8 == this.Q) {
            return;
        }
        this.Q = i8;
        if (this.f1359e != null) {
            k();
        }
    }

    public void setBoxCollapsedPaddingTop(int i8) {
        this.R = i8;
    }

    public void setBoxCornerFamily(int i8) {
        m mVarF = this.N.f();
        t1.d dVar = this.N.f5511e;
        mVarF.f5497a = z.m(i8);
        mVarF.f5500e = dVar;
        t1.d dVar2 = this.N.f5512f;
        mVarF.f5498b = z.m(i8);
        mVarF.f5501f = dVar2;
        t1.d dVar3 = this.N.f5514h;
        mVarF.d = z.m(i8);
        mVarF.f5503h = dVar3;
        t1.d dVar4 = this.N.f5513g;
        mVarF.f5499c = z.m(i8);
        mVarF.f5502g = dVar4;
        this.N = mVarF.a();
        c();
    }

    public void setBoxStrokeColor(int i8) throws Resources.NotFoundException {
        if (this.f1378o0 != i8) {
            this.f1378o0 = i8;
            z();
        }
    }

    public void setBoxStrokeColorStateList(ColorStateList colorStateList) throws Resources.NotFoundException {
        if (colorStateList.isStateful()) {
            this.f1374m0 = colorStateList.getDefaultColor();
            this.f1390u0 = colorStateList.getColorForState(new int[]{-16842910}, -1);
            this.f1376n0 = colorStateList.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, -1);
            this.f1378o0 = colorStateList.getColorForState(new int[]{R.attr.state_focused, R.attr.state_enabled}, -1);
        } else if (this.f1378o0 != colorStateList.getDefaultColor()) {
            this.f1378o0 = colorStateList.getDefaultColor();
        }
        z();
    }

    public void setBoxStrokeErrorColor(ColorStateList colorStateList) throws Resources.NotFoundException {
        if (this.f1380p0 != colorStateList) {
            this.f1380p0 = colorStateList;
            z();
        }
    }

    public void setBoxStrokeWidth(int i8) throws Resources.NotFoundException {
        this.T = i8;
        z();
    }

    public void setBoxStrokeWidthFocused(int i8) throws Resources.NotFoundException {
        this.U = i8;
        z();
    }

    public void setBoxStrokeWidthFocusedResource(int i8) throws Resources.NotFoundException {
        setBoxStrokeWidthFocused(getResources().getDimensionPixelSize(i8));
    }

    public void setBoxStrokeWidthResource(int i8) throws Resources.NotFoundException {
        setBoxStrokeWidth(getResources().getDimensionPixelSize(i8));
    }

    public void setCounterEnabled(boolean z) throws Resources.NotFoundException {
        if (this.f1373m != z) {
            r rVar = this.f1371l;
            if (z) {
                g0 g0Var = new g0(getContext(), null);
                this.f1381q = g0Var;
                g0Var.setId(com.stepos.stepclaw.R.id.textinput_counter);
                Typeface typeface = this.f1358d0;
                if (typeface != null) {
                    this.f1381q.setTypeface(typeface);
                }
                this.f1381q.setMaxLines(1);
                rVar.a(this.f1381q, 2);
                ((ViewGroup.MarginLayoutParams) this.f1381q.getLayoutParams()).setMarginStart(getResources().getDimensionPixelOffset(com.stepos.stepclaw.R.dimen.mtrl_textinput_counter_margin_start));
                q();
                if (this.f1381q != null) {
                    EditText editText = this.f1359e;
                    p(editText != null ? editText.getText() : null);
                }
            } else {
                rVar.g(this.f1381q, 2);
                this.f1381q = null;
            }
            this.f1373m = z;
        }
    }

    public void setCounterMaxLength(int i8) throws Resources.NotFoundException {
        if (this.f1375n != i8) {
            if (i8 > 0) {
                this.f1375n = i8;
            } else {
                this.f1375n = -1;
            }
            if (!this.f1373m || this.f1381q == null) {
                return;
            }
            EditText editText = this.f1359e;
            p(editText == null ? null : editText.getText());
        }
    }

    public void setCounterOverflowTextAppearance(int i8) {
        if (this.f1383r != i8) {
            this.f1383r = i8;
            q();
        }
    }

    public void setCounterOverflowTextColor(ColorStateList colorStateList) {
        if (this.B != colorStateList) {
            this.B = colorStateList;
            q();
        }
    }

    public void setCounterTextAppearance(int i8) {
        if (this.f1385s != i8) {
            this.f1385s = i8;
            q();
        }
    }

    public void setCounterTextColor(ColorStateList colorStateList) {
        if (this.A != colorStateList) {
            this.A = colorStateList;
            q();
        }
    }

    public void setCursorColor(ColorStateList colorStateList) throws Resources.NotFoundException {
        if (this.C != colorStateList) {
            this.C = colorStateList;
            r();
        }
    }

    public void setCursorErrorColor(ColorStateList colorStateList) throws Resources.NotFoundException {
        if (this.D != colorStateList) {
            this.D = colorStateList;
            if (o() || (this.f1381q != null && this.f1377o)) {
                r();
            }
        }
    }

    public void setDefaultHintTextColor(ColorStateList colorStateList) {
        this.k0 = colorStateList;
        this.f1372l0 = colorStateList;
        if (this.f1359e != null) {
            w(false, false);
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        m(this, z);
        super.setEnabled(z);
    }

    public void setEndIconActivated(boolean z) {
        this.f1356c.f6123g.setActivated(z);
    }

    public void setEndIconCheckable(boolean z) {
        this.f1356c.f6123g.setCheckable(z);
    }

    public void setEndIconContentDescription(int i8) {
        o oVar = this.f1356c;
        CharSequence text = i8 != 0 ? oVar.getResources().getText(i8) : null;
        CheckableImageButton checkableImageButton = oVar.f6123g;
        if (checkableImageButton.getContentDescription() != text) {
            checkableImageButton.setContentDescription(text);
        }
    }

    public void setEndIconDrawable(int i8) {
        o oVar = this.f1356c;
        Drawable drawableP = i8 != 0 ? b8.h.p(oVar.getContext(), i8) : null;
        TextInputLayout textInputLayout = oVar.f6118a;
        CheckableImageButton checkableImageButton = oVar.f6123g;
        checkableImageButton.setImageDrawable(drawableP);
        if (drawableP != null) {
            v.e(textInputLayout, checkableImageButton, oVar.f6127l, oVar.f6128m);
            v.f0(textInputLayout, checkableImageButton, oVar.f6127l);
        }
    }

    public void setEndIconMinSize(int i8) {
        o oVar = this.f1356c;
        if (i8 < 0) {
            oVar.getClass();
            throw new IllegalArgumentException("endIconSize cannot be less than 0");
        }
        if (i8 != oVar.f6129n) {
            oVar.f6129n = i8;
            CheckableImageButton checkableImageButton = oVar.f6123g;
            checkableImageButton.setMinimumWidth(i8);
            checkableImageButton.setMinimumHeight(i8);
            CheckableImageButton checkableImageButton2 = oVar.f6120c;
            checkableImageButton2.setMinimumWidth(i8);
            checkableImageButton2.setMinimumHeight(i8);
        }
    }

    public void setEndIconMode(int i8) {
        this.f1356c.g(i8);
    }

    public void setEndIconOnClickListener(View.OnClickListener onClickListener) {
        o oVar = this.f1356c;
        CheckableImageButton checkableImageButton = oVar.f6123g;
        View.OnLongClickListener onLongClickListener = oVar.f6131p;
        checkableImageButton.setOnClickListener(onClickListener);
        v.k0(checkableImageButton, onLongClickListener);
    }

    public void setEndIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        o oVar = this.f1356c;
        oVar.f6131p = onLongClickListener;
        CheckableImageButton checkableImageButton = oVar.f6123g;
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        v.k0(checkableImageButton, onLongClickListener);
    }

    public void setEndIconScaleType(ImageView.ScaleType scaleType) {
        o oVar = this.f1356c;
        oVar.f6130o = scaleType;
        oVar.f6123g.setScaleType(scaleType);
        oVar.f6120c.setScaleType(scaleType);
    }

    public void setEndIconTintList(ColorStateList colorStateList) {
        o oVar = this.f1356c;
        if (oVar.f6127l != colorStateList) {
            oVar.f6127l = colorStateList;
            v.e(oVar.f6118a, oVar.f6123g, colorStateList, oVar.f6128m);
        }
    }

    public void setEndIconTintMode(PorterDuff.Mode mode) {
        o oVar = this.f1356c;
        if (oVar.f6128m != mode) {
            oVar.f6128m = mode;
            v.e(oVar.f6118a, oVar.f6123g, oVar.f6127l, mode);
        }
    }

    public void setEndIconVisible(boolean z) {
        this.f1356c.h(z);
    }

    public void setError(CharSequence charSequence) throws Resources.NotFoundException {
        r rVar = this.f1371l;
        if (!rVar.f6158q) {
            if (TextUtils.isEmpty(charSequence)) {
                return;
            } else {
                setErrorEnabled(true);
            }
        }
        if (TextUtils.isEmpty(charSequence)) {
            rVar.f();
            return;
        }
        rVar.c();
        rVar.f6157p = charSequence;
        rVar.f6159r.setText(charSequence);
        int i8 = rVar.f6155n;
        if (i8 != 1) {
            rVar.f6156o = 1;
        }
        rVar.i(i8, rVar.f6156o, rVar.h(rVar.f6159r, charSequence));
    }

    public void setErrorAccessibilityLiveRegion(int i8) {
        r rVar = this.f1371l;
        rVar.f6161t = i8;
        g0 g0Var = rVar.f6159r;
        if (g0Var != null) {
            g0Var.setAccessibilityLiveRegion(i8);
        }
    }

    public void setErrorContentDescription(CharSequence charSequence) {
        r rVar = this.f1371l;
        rVar.f6160s = charSequence;
        g0 g0Var = rVar.f6159r;
        if (g0Var != null) {
            g0Var.setContentDescription(charSequence);
        }
    }

    public void setErrorEnabled(boolean z) throws Resources.NotFoundException {
        r rVar = this.f1371l;
        TextInputLayout textInputLayout = rVar.f6149h;
        if (rVar.f6158q == z) {
            return;
        }
        rVar.c();
        if (z) {
            g0 g0Var = new g0(rVar.f6148g, null);
            rVar.f6159r = g0Var;
            g0Var.setId(com.stepos.stepclaw.R.id.textinput_error);
            rVar.f6159r.setTextAlignment(5);
            Typeface typeface = rVar.B;
            if (typeface != null) {
                rVar.f6159r.setTypeface(typeface);
            }
            int i8 = rVar.f6162u;
            rVar.f6162u = i8;
            g0 g0Var2 = rVar.f6159r;
            if (g0Var2 != null) {
                rVar.f6149h.n(g0Var2, i8);
            }
            ColorStateList colorStateList = rVar.f6163v;
            rVar.f6163v = colorStateList;
            g0 g0Var3 = rVar.f6159r;
            if (g0Var3 != null && colorStateList != null) {
                g0Var3.setTextColor(colorStateList);
            }
            CharSequence charSequence = rVar.f6160s;
            rVar.f6160s = charSequence;
            g0 g0Var4 = rVar.f6159r;
            if (g0Var4 != null) {
                g0Var4.setContentDescription(charSequence);
            }
            int i9 = rVar.f6161t;
            rVar.f6161t = i9;
            g0 g0Var5 = rVar.f6159r;
            if (g0Var5 != null) {
                g0Var5.setAccessibilityLiveRegion(i9);
            }
            rVar.f6159r.setVisibility(4);
            rVar.a(rVar.f6159r, 0);
        } else {
            rVar.f();
            rVar.g(rVar.f6159r, 0);
            rVar.f6159r = null;
            textInputLayout.t();
            textInputLayout.z();
        }
        rVar.f6158q = z;
    }

    public void setErrorIconDrawable(int i8) {
        o oVar = this.f1356c;
        oVar.i(i8 != 0 ? b8.h.p(oVar.getContext(), i8) : null);
        v.f0(oVar.f6118a, oVar.f6120c, oVar.d);
    }

    public void setErrorIconOnClickListener(View.OnClickListener onClickListener) {
        o oVar = this.f1356c;
        CheckableImageButton checkableImageButton = oVar.f6120c;
        View.OnLongClickListener onLongClickListener = oVar.f6122f;
        checkableImageButton.setOnClickListener(onClickListener);
        v.k0(checkableImageButton, onLongClickListener);
    }

    public void setErrorIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        o oVar = this.f1356c;
        oVar.f6122f = onLongClickListener;
        CheckableImageButton checkableImageButton = oVar.f6120c;
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        v.k0(checkableImageButton, onLongClickListener);
    }

    public void setErrorIconTintList(ColorStateList colorStateList) {
        o oVar = this.f1356c;
        if (oVar.d != colorStateList) {
            oVar.d = colorStateList;
            v.e(oVar.f6118a, oVar.f6120c, colorStateList, oVar.f6121e);
        }
    }

    public void setErrorIconTintMode(PorterDuff.Mode mode) {
        o oVar = this.f1356c;
        if (oVar.f6121e != mode) {
            oVar.f6121e = mode;
            v.e(oVar.f6118a, oVar.f6120c, oVar.d, mode);
        }
    }

    public void setErrorTextAppearance(int i8) {
        r rVar = this.f1371l;
        rVar.f6162u = i8;
        g0 g0Var = rVar.f6159r;
        if (g0Var != null) {
            rVar.f6149h.n(g0Var, i8);
        }
    }

    public void setErrorTextColor(ColorStateList colorStateList) {
        r rVar = this.f1371l;
        rVar.f6163v = colorStateList;
        g0 g0Var = rVar.f6159r;
        if (g0Var == null || colorStateList == null) {
            return;
        }
        g0Var.setTextColor(colorStateList);
    }

    public void setExpandedHintEnabled(boolean z) {
        if (this.f1397y0 != z) {
            this.f1397y0 = z;
            w(false, false);
        }
    }

    public void setHelperText(CharSequence charSequence) throws Resources.NotFoundException {
        boolean zIsEmpty = TextUtils.isEmpty(charSequence);
        r rVar = this.f1371l;
        if (zIsEmpty) {
            if (rVar.f6165x) {
                setHelperTextEnabled(false);
                return;
            }
            return;
        }
        if (!rVar.f6165x) {
            setHelperTextEnabled(true);
        }
        rVar.c();
        rVar.f6164w = charSequence;
        rVar.y.setText(charSequence);
        int i8 = rVar.f6155n;
        if (i8 != 2) {
            rVar.f6156o = 2;
        }
        rVar.i(i8, rVar.f6156o, rVar.h(rVar.y, charSequence));
    }

    public void setHelperTextColor(ColorStateList colorStateList) {
        r rVar = this.f1371l;
        rVar.A = colorStateList;
        g0 g0Var = rVar.y;
        if (g0Var == null || colorStateList == null) {
            return;
        }
        g0Var.setTextColor(colorStateList);
    }

    public void setHelperTextEnabled(boolean z) throws Resources.NotFoundException {
        r rVar = this.f1371l;
        TextInputLayout textInputLayout = rVar.f6149h;
        if (rVar.f6165x == z) {
            return;
        }
        rVar.c();
        if (z) {
            g0 g0Var = new g0(rVar.f6148g, null);
            rVar.y = g0Var;
            g0Var.setId(com.stepos.stepclaw.R.id.textinput_helper_text);
            rVar.y.setTextAlignment(5);
            Typeface typeface = rVar.B;
            if (typeface != null) {
                rVar.y.setTypeface(typeface);
            }
            rVar.y.setVisibility(4);
            rVar.y.setAccessibilityLiveRegion(1);
            int i8 = rVar.z;
            rVar.z = i8;
            g0 g0Var2 = rVar.y;
            if (g0Var2 != null) {
                g0Var2.setTextAppearance(i8);
            }
            ColorStateList colorStateList = rVar.A;
            rVar.A = colorStateList;
            g0 g0Var3 = rVar.y;
            if (g0Var3 != null && colorStateList != null) {
                g0Var3.setTextColor(colorStateList);
            }
            rVar.a(rVar.y, 1);
            rVar.y.setAccessibilityDelegate(new q(rVar));
        } else {
            rVar.c();
            int i9 = rVar.f6155n;
            if (i9 == 2) {
                rVar.f6156o = 0;
            }
            rVar.i(i9, rVar.f6156o, rVar.h(rVar.y, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID));
            rVar.g(rVar.y, 1);
            rVar.y = null;
            textInputLayout.t();
            textInputLayout.z();
        }
        rVar.f6165x = z;
    }

    public void setHelperTextTextAppearance(int i8) {
        r rVar = this.f1371l;
        rVar.z = i8;
        g0 g0Var = rVar.y;
        if (g0Var != null) {
            g0Var.setTextAppearance(i8);
        }
    }

    public void setHint(CharSequence charSequence) {
        if (this.E) {
            setHintInternal(charSequence);
            sendAccessibilityEvent(2048);
        }
    }

    public void setHintAnimationEnabled(boolean z) {
        this.f1398z0 = z;
    }

    public void setHintEnabled(boolean z) {
        if (z != this.E) {
            this.E = z;
            if (z) {
                CharSequence hint = this.f1359e.getHint();
                if (!TextUtils.isEmpty(hint)) {
                    if (TextUtils.isEmpty(this.F)) {
                        setHint(hint);
                    }
                    this.f1359e.setHint((CharSequence) null);
                }
                this.G = true;
            } else {
                this.G = false;
                if (!TextUtils.isEmpty(this.F) && TextUtils.isEmpty(this.f1359e.getHint())) {
                    this.f1359e.setHint(this.F);
                }
                setHintInternal(null);
            }
            if (this.f1359e != null) {
                v();
            }
        }
    }

    public void setHintMaxLines(int i8) {
        b bVar = this.f1396x0;
        if (i8 != bVar.f4673f0) {
            bVar.f4673f0 = i8;
            bVar.j(false);
        }
        if (i8 != bVar.f4671e0) {
            bVar.f4671e0 = i8;
            bVar.j(false);
        }
        requestLayout();
    }

    public void setHintTextAppearance(int i8) {
        b bVar = this.f1396x0;
        TextInputLayout textInputLayout = bVar.f4663a;
        r1.d dVar = new r1.d(textInputLayout.getContext(), i8);
        ColorStateList colorStateList = dVar.f5081k;
        if (colorStateList != null) {
            bVar.f4682k = colorStateList;
        }
        float f3 = dVar.f5082l;
        if (f3 != 0.0f) {
            bVar.f4678i = f3;
        }
        ColorStateList colorStateList2 = dVar.f5072a;
        if (colorStateList2 != null) {
            bVar.V = colorStateList2;
        }
        bVar.T = dVar.f5076f;
        bVar.U = dVar.f5077g;
        bVar.S = dVar.f5078h;
        bVar.W = dVar.f5080j;
        r1.a aVar = bVar.z;
        if (aVar != null) {
            aVar.d = true;
        }
        androidx.emoji2.text.m mVar = new androidx.emoji2.text.m(bVar);
        dVar.a();
        bVar.z = new r1.a(mVar, dVar.f5086p);
        dVar.b(textInputLayout.getContext(), bVar.z);
        bVar.j(false);
        this.f1372l0 = bVar.f4682k;
        if (this.f1359e != null) {
            w(false, false);
            v();
        }
    }

    public void setHintTextColor(ColorStateList colorStateList) {
        if (this.f1372l0 != colorStateList) {
            if (this.k0 == null) {
                b bVar = this.f1396x0;
                if (bVar.f4682k != colorStateList) {
                    bVar.f4682k = colorStateList;
                    bVar.j(false);
                }
            }
            this.f1372l0 = colorStateList;
            if (this.f1359e != null) {
                w(false, false);
            }
        }
    }

    public void setLengthCounter(w wVar) {
        this.f1379p = wVar;
    }

    public void setMaxEms(int i8) {
        this.f1365h = i8;
        EditText editText = this.f1359e;
        if (editText == null || i8 == -1) {
            return;
        }
        editText.setMaxEms(i8);
    }

    public void setMaxWidth(int i8) {
        this.f1370k = i8;
        EditText editText = this.f1359e;
        if (editText == null || i8 == -1) {
            return;
        }
        editText.setMaxWidth(i8);
    }

    public void setMaxWidthResource(int i8) {
        setMaxWidth(getContext().getResources().getDimensionPixelSize(i8));
    }

    public void setMinEms(int i8) {
        this.f1363g = i8;
        EditText editText = this.f1359e;
        if (editText == null || i8 == -1) {
            return;
        }
        editText.setMinEms(i8);
    }

    public void setMinWidth(int i8) {
        this.f1368j = i8;
        EditText editText = this.f1359e;
        if (editText == null || i8 == -1) {
            return;
        }
        editText.setMinWidth(i8);
    }

    public void setMinWidthResource(int i8) {
        setMinWidth(getContext().getResources().getDimensionPixelSize(i8));
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(int i8) {
        o oVar = this.f1356c;
        oVar.f6123g.setContentDescription(i8 != 0 ? oVar.getResources().getText(i8) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(int i8) {
        o oVar = this.f1356c;
        oVar.f6123g.setImageDrawable(i8 != 0 ? b8.h.p(oVar.getContext(), i8) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleEnabled(boolean z) {
        o oVar = this.f1356c;
        if (z && oVar.f6125j != 1) {
            oVar.g(1);
        } else if (z) {
            oVar.getClass();
        } else {
            oVar.g(0);
        }
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintList(ColorStateList colorStateList) {
        o oVar = this.f1356c;
        oVar.f6127l = colorStateList;
        v.e(oVar.f6118a, oVar.f6123g, colorStateList, oVar.f6128m);
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintMode(PorterDuff.Mode mode) {
        o oVar = this.f1356c;
        oVar.f6128m = mode;
        v.e(oVar.f6118a, oVar.f6123g, oVar.f6127l, mode);
    }

    public void setPlaceholderText(CharSequence charSequence) {
        if (this.f1391v == null) {
            g0 g0Var = new g0(getContext(), null);
            this.f1391v = g0Var;
            g0Var.setId(com.stepos.stepclaw.R.id.textinput_placeholder);
            this.f1391v.setImportantForAccessibility(1);
            this.f1391v.setAccessibilityLiveRegion(1);
            h hVarF = f();
            this.y = hVarF;
            hVarF.f42b = 67L;
            this.z = f();
            setPlaceholderTextAppearance(this.f1395x);
            setPlaceholderTextColor(this.f1393w);
            a0.e(this.f1391v, new com.google.android.material.datepicker.b(2));
        }
        if (TextUtils.isEmpty(charSequence)) {
            setPlaceholderTextEnabled(false);
        } else {
            if (!this.f1389u) {
                setPlaceholderTextEnabled(true);
            }
            this.f1387t = charSequence;
        }
        EditText editText = this.f1359e;
        x(editText != null ? editText.getText() : null);
    }

    public void setPlaceholderTextAppearance(int i8) {
        this.f1395x = i8;
        g0 g0Var = this.f1391v;
        if (g0Var != null) {
            g0Var.setTextAppearance(i8);
        }
    }

    public void setPlaceholderTextColor(ColorStateList colorStateList) {
        if (this.f1393w != colorStateList) {
            this.f1393w = colorStateList;
            g0 g0Var = this.f1391v;
            if (g0Var == null || colorStateList == null) {
                return;
            }
            g0Var.setTextColor(colorStateList);
        }
    }

    public void setPrefixText(CharSequence charSequence) {
        t tVar = this.f1354b;
        tVar.getClass();
        tVar.f6171c = TextUtils.isEmpty(charSequence) ? null : charSequence;
        tVar.f6170b.setText(charSequence);
        tVar.e();
    }

    public void setPrefixTextAppearance(int i8) {
        this.f1354b.f6170b.setTextAppearance(i8);
    }

    public void setPrefixTextColor(ColorStateList colorStateList) {
        this.f1354b.f6170b.setTextColor(colorStateList);
    }

    public void setShapeAppearanceModel(n nVar) {
        j jVar = this.H;
        if (jVar == null || jVar.f5475b.f5457a == nVar) {
            return;
        }
        this.N = nVar;
        c();
    }

    public void setStartIconCheckable(boolean z) {
        this.f1354b.d.setCheckable(z);
    }

    public void setStartIconContentDescription(int i8) {
        setStartIconContentDescription(i8 != 0 ? getResources().getText(i8) : null);
    }

    public void setStartIconDrawable(int i8) {
        setStartIconDrawable(i8 != 0 ? b8.h.p(getContext(), i8) : null);
    }

    public void setStartIconMinSize(int i8) {
        t tVar = this.f1354b;
        if (i8 < 0) {
            tVar.getClass();
            throw new IllegalArgumentException("startIconSize cannot be less than 0");
        }
        if (i8 != tVar.f6174g) {
            tVar.f6174g = i8;
            CheckableImageButton checkableImageButton = tVar.d;
            checkableImageButton.setMinimumWidth(i8);
            checkableImageButton.setMinimumHeight(i8);
        }
    }

    public void setStartIconOnClickListener(View.OnClickListener onClickListener) {
        t tVar = this.f1354b;
        CheckableImageButton checkableImageButton = tVar.d;
        View.OnLongClickListener onLongClickListener = tVar.f6176j;
        checkableImageButton.setOnClickListener(onClickListener);
        v.k0(checkableImageButton, onLongClickListener);
    }

    public void setStartIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        t tVar = this.f1354b;
        tVar.f6176j = onLongClickListener;
        CheckableImageButton checkableImageButton = tVar.d;
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        v.k0(checkableImageButton, onLongClickListener);
    }

    public void setStartIconScaleType(ImageView.ScaleType scaleType) {
        t tVar = this.f1354b;
        tVar.f6175h = scaleType;
        tVar.d.setScaleType(scaleType);
    }

    public void setStartIconTintList(ColorStateList colorStateList) {
        t tVar = this.f1354b;
        if (tVar.f6172e != colorStateList) {
            tVar.f6172e = colorStateList;
            v.e(tVar.f6169a, tVar.d, colorStateList, tVar.f6173f);
        }
    }

    public void setStartIconTintMode(PorterDuff.Mode mode) {
        t tVar = this.f1354b;
        if (tVar.f6173f != mode) {
            tVar.f6173f = mode;
            v.e(tVar.f6169a, tVar.d, tVar.f6172e, mode);
        }
    }

    public void setStartIconVisible(boolean z) {
        this.f1354b.c(z);
    }

    public void setSuffixText(CharSequence charSequence) {
        o oVar = this.f1356c;
        oVar.getClass();
        oVar.f6132q = TextUtils.isEmpty(charSequence) ? null : charSequence;
        oVar.f6133r.setText(charSequence);
        oVar.n();
    }

    public void setSuffixTextAppearance(int i8) {
        this.f1356c.f6133r.setTextAppearance(i8);
    }

    public void setSuffixTextColor(ColorStateList colorStateList) {
        this.f1356c.f6133r.setTextColor(colorStateList);
    }

    public void setTextInputAccessibilityDelegate(w1.v vVar) {
        EditText editText = this.f1359e;
        if (editText != null) {
            a0.e(editText, vVar);
        }
    }

    public void setTypeface(Typeface typeface) {
        if (typeface != this.f1358d0) {
            this.f1358d0 = typeface;
            this.f1396x0.n(typeface);
            r rVar = this.f1371l;
            if (typeface != rVar.B) {
                rVar.B = typeface;
                g0 g0Var = rVar.f6159r;
                if (g0Var != null) {
                    g0Var.setTypeface(typeface);
                }
                g0 g0Var2 = rVar.y;
                if (g0Var2 != null) {
                    g0Var2.setTypeface(typeface);
                }
            }
            g0 g0Var3 = this.f1381q;
            if (g0Var3 != null) {
                g0Var3.setTypeface(typeface);
            }
        }
    }

    public final void t() {
        Drawable background;
        g0 g0Var;
        EditText editText = this.f1359e;
        if (editText == null || this.Q != 0 || (background = editText.getBackground()) == null) {
            return;
        }
        int i8 = n0.f2786a;
        Drawable drawableMutate = background.mutate();
        if (o()) {
            drawableMutate.setColorFilter(g.r.b(getErrorCurrentTextColors(), PorterDuff.Mode.SRC_IN));
        } else if (this.f1377o && (g0Var = this.f1381q) != null) {
            drawableMutate.setColorFilter(g.r.b(g0Var.getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
        } else {
            drawableMutate.clearColorFilter();
            this.f1359e.refreshDrawableState();
        }
    }

    public final void u() {
        EditText editText = this.f1359e;
        if (editText == null || this.H == null) {
            return;
        }
        if ((this.K || editText.getBackground() == null) && this.Q != 0) {
            this.f1359e.setBackground(getEditTextBoxBackground());
            this.K = true;
        }
    }

    public final void v() {
        if (this.Q != 1) {
            FrameLayout frameLayout = this.f1352a;
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) frameLayout.getLayoutParams();
            int iE = e();
            if (iE != layoutParams.topMargin) {
                layoutParams.topMargin = iE;
                frameLayout.requestLayout();
            }
        }
    }

    public final void w(boolean z, boolean z2) {
        ColorStateList colorStateList;
        g0 g0Var;
        boolean zIsEnabled = isEnabled();
        EditText editText = this.f1359e;
        boolean z8 = (editText == null || TextUtils.isEmpty(editText.getText())) ? false : true;
        EditText editText2 = this.f1359e;
        boolean z9 = editText2 != null && editText2.hasFocus();
        ColorStateList colorStateList2 = this.k0;
        b bVar = this.f1396x0;
        if (colorStateList2 != null) {
            bVar.k(colorStateList2);
        }
        if (!zIsEnabled) {
            ColorStateList colorStateList3 = this.k0;
            bVar.k(ColorStateList.valueOf(colorStateList3 != null ? colorStateList3.getColorForState(new int[]{-16842910}, this.f1390u0) : this.f1390u0));
        } else if (o()) {
            g0 g0Var2 = this.f1371l.f6159r;
            bVar.k(g0Var2 != null ? g0Var2.getTextColors() : null);
        } else if (this.f1377o && (g0Var = this.f1381q) != null) {
            bVar.k(g0Var.getTextColors());
        } else if (z9 && (colorStateList = this.f1372l0) != null && bVar.f4682k != colorStateList) {
            bVar.f4682k = colorStateList;
            bVar.j(false);
        }
        o oVar = this.f1356c;
        t tVar = this.f1354b;
        if (z8 || !this.f1397y0 || (isEnabled() && z9)) {
            if (z2 || this.f1394w0) {
                ValueAnimator valueAnimator = this.A0;
                if (valueAnimator != null && valueAnimator.isRunning()) {
                    this.A0.cancel();
                }
                if (z && this.f1398z0) {
                    b(1.0f);
                } else {
                    bVar.m(1.0f);
                }
                this.f1394w0 = false;
                if (g()) {
                    l();
                }
                EditText editText3 = this.f1359e;
                x(editText3 != null ? editText3.getText() : null);
                tVar.f6177k = false;
                tVar.e();
                oVar.f6134s = false;
                oVar.n();
                return;
            }
            return;
        }
        if (z2 || !this.f1394w0) {
            ValueAnimator valueAnimator2 = this.A0;
            if (valueAnimator2 != null && valueAnimator2.isRunning()) {
                this.A0.cancel();
            }
            if (z && this.f1398z0) {
                b(0.0f);
            } else {
                bVar.m(0.0f);
            }
            if (g() && !((w1.h) this.H).E.f6098r.isEmpty() && g()) {
                ((w1.h) this.H).s(0.0f, 0.0f, 0.0f, 0.0f);
            }
            this.f1394w0 = true;
            g0 g0Var3 = this.f1391v;
            if (g0Var3 != null && this.f1389u) {
                g0Var3.setText((CharSequence) null);
                s.a(this.f1352a, this.z);
                this.f1391v.setVisibility(4);
            }
            tVar.f6177k = true;
            tVar.e();
            oVar.f6134s = true;
            oVar.n();
        }
    }

    public final void x(Editable editable) {
        ((a1.n) this.f1379p).getClass();
        int length = editable != null ? editable.length() : 0;
        FrameLayout frameLayout = this.f1352a;
        if (length != 0 || this.f1394w0) {
            g0 g0Var = this.f1391v;
            if (g0Var == null || !this.f1389u) {
                return;
            }
            g0Var.setText((CharSequence) null);
            s.a(frameLayout, this.z);
            this.f1391v.setVisibility(4);
            return;
        }
        if (this.f1391v == null || !this.f1389u || TextUtils.isEmpty(this.f1387t)) {
            return;
        }
        this.f1391v.setText(this.f1387t);
        s.a(frameLayout, this.y);
        this.f1391v.setVisibility(0);
        this.f1391v.bringToFront();
    }

    public final void y(boolean z, boolean z2) {
        int defaultColor = this.f1380p0.getDefaultColor();
        int colorForState = this.f1380p0.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, defaultColor);
        int colorForState2 = this.f1380p0.getColorForState(new int[]{R.attr.state_activated, R.attr.state_enabled}, defaultColor);
        if (z) {
            this.V = colorForState2;
        } else if (z2) {
            this.V = colorForState;
        } else {
            this.V = defaultColor;
        }
    }

    public final void z() throws Resources.NotFoundException {
        g0 g0Var;
        EditText editText;
        EditText editText2;
        if (this.H == null || this.Q == 0) {
            return;
        }
        boolean z = false;
        boolean z2 = isFocused() || ((editText2 = this.f1359e) != null && editText2.hasFocus());
        if (isHovered() || ((editText = this.f1359e) != null && editText.isHovered())) {
            z = true;
        }
        if (!isEnabled()) {
            this.V = this.f1390u0;
        } else if (o()) {
            if (this.f1380p0 != null) {
                y(z2, z);
            } else {
                this.V = getErrorCurrentTextColors();
            }
        } else if (!this.f1377o || (g0Var = this.f1381q) == null) {
            if (z2) {
                this.V = this.f1378o0;
            } else if (z) {
                this.V = this.f1376n0;
            } else {
                this.V = this.f1374m0;
            }
        } else if (this.f1380p0 != null) {
            y(z2, z);
        } else {
            this.V = g0Var.getCurrentTextColor();
        }
        r();
        o oVar = this.f1356c;
        TextInputLayout textInputLayout = oVar.f6118a;
        CheckableImageButton checkableImageButton = oVar.f6123g;
        TextInputLayout textInputLayout2 = oVar.f6118a;
        oVar.l();
        v.f0(textInputLayout2, oVar.f6120c, oVar.d);
        v.f0(textInputLayout2, checkableImageButton, oVar.f6127l);
        if (oVar.b() instanceof w1.l) {
            if (!textInputLayout.o() || checkableImageButton.getDrawable() == null) {
                v.e(textInputLayout, checkableImageButton, oVar.f6127l, oVar.f6128m);
            } else {
                Drawable drawableMutate = checkableImageButton.getDrawable().mutate();
                drawableMutate.setTint(textInputLayout.getErrorCurrentTextColors());
                checkableImageButton.setImageDrawable(drawableMutate);
            }
        }
        t tVar = this.f1354b;
        v.f0(tVar.f6169a, tVar.d, tVar.f6172e);
        if (this.Q == 2) {
            int i8 = this.S;
            if (z2 && isEnabled()) {
                this.S = this.U;
            } else {
                this.S = this.T;
            }
            if (this.S != i8 && g() && !this.f1394w0) {
                if (g()) {
                    ((w1.h) this.H).s(0.0f, 0.0f, 0.0f, 0.0f);
                }
                l();
            }
        }
        if (this.Q == 1) {
            if (!isEnabled()) {
                this.W = this.f1384r0;
            } else if (z && !z2) {
                this.W = this.f1388t0;
            } else if (z2) {
                this.W = this.f1386s0;
            } else {
                this.W = this.f1382q0;
            }
        }
        c();
    }

    public void setStartIconContentDescription(CharSequence charSequence) {
        CheckableImageButton checkableImageButton = this.f1354b.d;
        if (checkableImageButton.getContentDescription() != charSequence) {
            checkableImageButton.setContentDescription(charSequence);
        }
    }

    public void setStartIconDrawable(Drawable drawable) {
        this.f1354b.b(drawable);
    }

    public void setHint(int i8) {
        setHint(i8 != 0 ? getResources().getText(i8) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(CharSequence charSequence) {
        this.f1356c.f6123g.setContentDescription(charSequence);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(Drawable drawable) {
        this.f1356c.f6123g.setImageDrawable(drawable);
    }

    public void setErrorIconDrawable(Drawable drawable) {
        this.f1356c.i(drawable);
    }

    public void setEndIconContentDescription(CharSequence charSequence) {
        CheckableImageButton checkableImageButton = this.f1356c.f6123g;
        if (checkableImageButton.getContentDescription() != charSequence) {
            checkableImageButton.setContentDescription(charSequence);
        }
    }

    public void setEndIconDrawable(Drawable drawable) {
        o oVar = this.f1356c;
        TextInputLayout textInputLayout = oVar.f6118a;
        CheckableImageButton checkableImageButton = oVar.f6123g;
        checkableImageButton.setImageDrawable(drawable);
        if (drawable != null) {
            v.e(textInputLayout, checkableImageButton, oVar.f6127l, oVar.f6128m);
            v.f0(textInputLayout, checkableImageButton, oVar.f6127l);
        }
    }
}
