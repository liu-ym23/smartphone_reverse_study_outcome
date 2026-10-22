package com.google.android.material.textfield;

import D7.N;
import a.AbstractC0291a;
import android.R;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
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
import android.os.Parcel;
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
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.DrawableUtils;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.text.BidiFormatter;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import androidx.customview.view.AbsSavedState;
import androidx.transition.Fade;
import androidx.transition.TransitionManager;
import c3.AbstractC0872b;
import c3.AbstractC0873c;
import c3.C0871a;
import c3.C0876f;
import ca.AbstractC0897f;
import com.google.android.material.datepicker.C0914q;
import com.google.android.material.internal.CheckableImageButton;
import com.stepos.policy.sdk.config.PolicySdkConstants;
import e3.C1412a;
import e3.C1417f;
import e3.C1419h;
import e3.InterfaceC1415d;
import g1.AbstractC1451a;
import java.util.Iterator;
import java.util.LinkedHashSet;
import v0.C2054a;

/* loaded from: classes3.dex */
public class TextInputLayout extends LinearLayout implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: H0, reason: collision with root package name */
    public static final int[][] f2602H0 = {new int[]{R.attr.state_pressed}, new int[0]};

    /* renamed from: A, reason: collision with root package name */
    public ColorStateList f2603A;

    /* renamed from: A0, reason: collision with root package name */
    public final com.google.android.material.internal.c f2604A0;

    /* renamed from: B, reason: collision with root package name */
    public ColorStateList f2605B;

    /* renamed from: B0, reason: collision with root package name */
    public boolean f2606B0;

    /* renamed from: C, reason: collision with root package name */
    public ColorStateList f2607C;

    /* renamed from: C0, reason: collision with root package name */
    public boolean f2608C0;

    /* renamed from: D, reason: collision with root package name */
    public boolean f2609D;

    /* renamed from: D0, reason: collision with root package name */
    public ValueAnimator f2610D0;
    public CharSequence E;

    /* renamed from: E0, reason: collision with root package name */
    public boolean f2611E0;

    /* renamed from: F, reason: collision with root package name */
    public boolean f2612F;

    /* renamed from: F0, reason: collision with root package name */
    public boolean f2613F0;

    /* renamed from: G, reason: collision with root package name */
    public e3.k f2614G;

    /* renamed from: G0, reason: collision with root package name */
    public boolean f2615G0;

    /* renamed from: L, reason: collision with root package name */
    public e3.k f2616L;

    /* renamed from: M, reason: collision with root package name */
    public StateListDrawable f2617M;

    /* renamed from: N, reason: collision with root package name */
    public boolean f2618N;

    /* renamed from: O, reason: collision with root package name */
    public e3.k f2619O;

    /* renamed from: P, reason: collision with root package name */
    public e3.k f2620P;

    /* renamed from: Q, reason: collision with root package name */
    public e3.p f2621Q;

    /* renamed from: R, reason: collision with root package name */
    public boolean f2622R;

    /* renamed from: S, reason: collision with root package name */
    public final int f2623S;

    /* renamed from: T, reason: collision with root package name */
    public int f2624T;

    /* renamed from: U, reason: collision with root package name */
    public int f2625U;

    /* renamed from: V, reason: collision with root package name */
    public int f2626V;

    /* renamed from: W, reason: collision with root package name */
    public int f2627W;

    /* renamed from: a, reason: collision with root package name */
    public final FrameLayout f2628a;

    /* renamed from: a0, reason: collision with root package name */
    public int f2629a0;
    public final u b;
    public int b0;
    public final m c;

    /* renamed from: c0, reason: collision with root package name */
    public int f2630c0;
    public final int d;

    /* renamed from: d0, reason: collision with root package name */
    public final Rect f2631d0;
    public EditText e;

    /* renamed from: e0, reason: collision with root package name */
    public final Rect f2632e0;
    public CharSequence f;

    /* renamed from: f0, reason: collision with root package name */
    public final RectF f2633f0;
    public int g;

    /* renamed from: g0, reason: collision with root package name */
    public Typeface f2634g0;
    public int h;

    /* renamed from: h0, reason: collision with root package name */
    public ColorDrawable f2635h0;
    public int i;

    /* renamed from: i0, reason: collision with root package name */
    public int f2636i0;

    /* renamed from: j, reason: collision with root package name */
    public int f2637j;

    /* renamed from: j0, reason: collision with root package name */
    public final LinkedHashSet f2638j0;
    public final q k;

    /* renamed from: k0, reason: collision with root package name */
    public ColorDrawable f2639k0;
    public boolean l;

    /* renamed from: l0, reason: collision with root package name */
    public int f2640l0;
    public int m;

    /* renamed from: m0, reason: collision with root package name */
    public Drawable f2641m0;
    public boolean n;

    /* renamed from: n0, reason: collision with root package name */
    public ColorStateList f2642n0;
    public x o;

    /* renamed from: o0, reason: collision with root package name */
    public ColorStateList f2643o0;
    public AppCompatTextView p;

    /* renamed from: p0, reason: collision with root package name */
    public int f2644p0;

    /* renamed from: q, reason: collision with root package name */
    public int f2645q;

    /* renamed from: q0, reason: collision with root package name */
    public int f2646q0;

    /* renamed from: r, reason: collision with root package name */
    public int f2647r;

    /* renamed from: r0, reason: collision with root package name */
    public int f2648r0;

    /* renamed from: s, reason: collision with root package name */
    public CharSequence f2649s;
    public ColorStateList s0;

    /* renamed from: t, reason: collision with root package name */
    public boolean f2650t;
    public int t0;
    public AppCompatTextView u;

    /* renamed from: u0, reason: collision with root package name */
    public int f2651u0;

    /* renamed from: v, reason: collision with root package name */
    public ColorStateList f2652v;

    /* renamed from: v0, reason: collision with root package name */
    public int f2653v0;

    /* renamed from: w, reason: collision with root package name */
    public int f2654w;

    /* renamed from: w0, reason: collision with root package name */
    public int f2655w0;

    /* renamed from: x, reason: collision with root package name */
    public Fade f2656x;

    /* renamed from: x0, reason: collision with root package name */
    public int f2657x0;
    public Fade y;

    /* renamed from: y0, reason: collision with root package name */
    public int f2658y0;

    /* renamed from: z, reason: collision with root package name */
    public ColorStateList f2659z;

    /* renamed from: z0, reason: collision with root package name */
    public boolean f2660z0;

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new y();

        @Nullable
        CharSequence error;
        boolean isEndIconChecked;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @NonNull
        public String toString() {
            return "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + ((Object) this.error) + "}";
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            TextUtils.writeToParcel(this.error, parcel, i);
            parcel.writeInt(this.isEndIconChecked ? 1 : 0);
        }

        public SavedState(@NonNull Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.error = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.isEndIconChecked = parcel.readInt() == 1;
        }
    }

    public TextInputLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(i3.a.a(context, attributeSet, com.stepos.ability.R.attr.textInputStyle, com.stepos.ability.R.style.Widget_Design_TextInputLayout), attributeSet, com.stepos.ability.R.attr.textInputStyle);
        this.g = -1;
        this.h = -1;
        this.i = -1;
        this.f2637j = -1;
        this.k = new q(this);
        this.o = new com.bumptech.glide.load.resource.bitmap.b(1);
        this.f2631d0 = new Rect();
        this.f2632e0 = new Rect();
        this.f2633f0 = new RectF();
        this.f2638j0 = new LinkedHashSet();
        com.google.android.material.internal.c cVar = new com.google.android.material.internal.c(this);
        this.f2604A0 = cVar;
        this.f2615G0 = false;
        Context context2 = getContext();
        setOrientation(1);
        setWillNotDraw(false);
        setAddStatesFromChildren(true);
        FrameLayout frameLayout = new FrameLayout(context2);
        this.f2628a = frameLayout;
        frameLayout.setAddStatesFromChildren(true);
        LinearInterpolator linearInterpolator = Q2.a.f1097a;
        cVar.f2468R = linearInterpolator;
        cVar.j(false);
        cVar.f2467Q = linearInterpolator;
        cVar.j(false);
        if (cVar.g != 8388659) {
            cVar.g = 8388659;
            cVar.j(false);
        }
        com.google.android.material.internal.k.a(context2, attributeSet, com.stepos.ability.R.attr.textInputStyle, com.stepos.ability.R.style.Widget_Design_TextInputLayout);
        int[] iArr = P2.a.f1071K;
        com.google.android.material.internal.k.b(context2, attributeSet, iArr, com.stepos.ability.R.attr.textInputStyle, com.stepos.ability.R.style.Widget_Design_TextInputLayout, 22, 20, 40, 45, 50);
        TintTypedArray tintTypedArrayObtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context2, attributeSet, iArr, com.stepos.ability.R.attr.textInputStyle, com.stepos.ability.R.style.Widget_Design_TextInputLayout);
        u uVar = new u(this, tintTypedArrayObtainStyledAttributes);
        this.b = uVar;
        this.f2609D = tintTypedArrayObtainStyledAttributes.getBoolean(48, true);
        setHint(tintTypedArrayObtainStyledAttributes.getText(4));
        this.f2608C0 = tintTypedArrayObtainStyledAttributes.getBoolean(47, true);
        this.f2606B0 = tintTypedArrayObtainStyledAttributes.getBoolean(42, true);
        if (tintTypedArrayObtainStyledAttributes.hasValue(6)) {
            setMinEms(tintTypedArrayObtainStyledAttributes.getInt(6, -1));
        } else if (tintTypedArrayObtainStyledAttributes.hasValue(3)) {
            setMinWidth(tintTypedArrayObtainStyledAttributes.getDimensionPixelSize(3, -1));
        }
        if (tintTypedArrayObtainStyledAttributes.hasValue(5)) {
            setMaxEms(tintTypedArrayObtainStyledAttributes.getInt(5, -1));
        } else if (tintTypedArrayObtainStyledAttributes.hasValue(2)) {
            setMaxWidth(tintTypedArrayObtainStyledAttributes.getDimensionPixelSize(2, -1));
        }
        this.f2621Q = e3.p.b(context2, attributeSet, com.stepos.ability.R.attr.textInputStyle, com.stepos.ability.R.style.Widget_Design_TextInputLayout).a();
        this.f2623S = context2.getResources().getDimensionPixelOffset(com.stepos.ability.R.dimen.mtrl_textinput_box_label_cutout_padding);
        this.f2625U = tintTypedArrayObtainStyledAttributes.getDimensionPixelOffset(9, 0);
        this.d = getResources().getDimensionPixelSize(com.stepos.ability.R.dimen.m3_multiline_hint_filled_text_extra_space);
        this.f2627W = tintTypedArrayObtainStyledAttributes.getDimensionPixelSize(16, context2.getResources().getDimensionPixelSize(com.stepos.ability.R.dimen.mtrl_textinput_box_stroke_width_default));
        this.f2629a0 = tintTypedArrayObtainStyledAttributes.getDimensionPixelSize(17, context2.getResources().getDimensionPixelSize(com.stepos.ability.R.dimen.mtrl_textinput_box_stroke_width_focused));
        this.f2626V = this.f2627W;
        float dimension = tintTypedArrayObtainStyledAttributes.getDimension(13, -1.0f);
        float dimension2 = tintTypedArrayObtainStyledAttributes.getDimension(12, -1.0f);
        float dimension3 = tintTypedArrayObtainStyledAttributes.getDimension(10, -1.0f);
        float dimension4 = tintTypedArrayObtainStyledAttributes.getDimension(11, -1.0f);
        e3.o oVarF = this.f2621Q.f();
        if (dimension >= 0.0f) {
            oVarF.e = new C1412a(dimension);
        }
        if (dimension2 >= 0.0f) {
            oVarF.f = new C1412a(dimension2);
        }
        if (dimension3 >= 0.0f) {
            oVarF.g = new C1412a(dimension3);
        }
        if (dimension4 >= 0.0f) {
            oVarF.h = new C1412a(dimension4);
        }
        this.f2621Q = oVarF.a();
        ColorStateList colorStateListB = AbstractC0873c.b(context2, tintTypedArrayObtainStyledAttributes, 7);
        if (colorStateListB != null) {
            int defaultColor = colorStateListB.getDefaultColor();
            this.t0 = defaultColor;
            this.f2630c0 = defaultColor;
            if (colorStateListB.isStateful()) {
                this.f2651u0 = colorStateListB.getColorForState(new int[]{-16842910}, -1);
                this.f2653v0 = colorStateListB.getColorForState(new int[]{R.attr.state_focused, R.attr.state_enabled}, -1);
                this.f2655w0 = colorStateListB.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, -1);
            } else {
                this.f2653v0 = this.t0;
                ColorStateList colorStateList = AppCompatResources.getColorStateList(context2, com.stepos.ability.R.color.mtrl_filled_background_color);
                this.f2651u0 = colorStateList.getColorForState(new int[]{-16842910}, -1);
                this.f2655w0 = colorStateList.getColorForState(new int[]{R.attr.state_hovered}, -1);
            }
        } else {
            this.f2630c0 = 0;
            this.t0 = 0;
            this.f2651u0 = 0;
            this.f2653v0 = 0;
            this.f2655w0 = 0;
        }
        if (tintTypedArrayObtainStyledAttributes.hasValue(1)) {
            ColorStateList colorStateList2 = tintTypedArrayObtainStyledAttributes.getColorStateList(1);
            this.f2643o0 = colorStateList2;
            this.f2642n0 = colorStateList2;
        }
        ColorStateList colorStateListB2 = AbstractC0873c.b(context2, tintTypedArrayObtainStyledAttributes, 14);
        this.f2648r0 = tintTypedArrayObtainStyledAttributes.getColor(14, 0);
        this.f2644p0 = ContextCompat.getColor(context2, com.stepos.ability.R.color.mtrl_textinput_default_box_stroke_color);
        this.f2657x0 = ContextCompat.getColor(context2, com.stepos.ability.R.color.mtrl_textinput_disabled_color);
        this.f2646q0 = ContextCompat.getColor(context2, com.stepos.ability.R.color.mtrl_textinput_hovered_box_stroke_color);
        if (colorStateListB2 != null) {
            setBoxStrokeColorStateList(colorStateListB2);
        }
        if (tintTypedArrayObtainStyledAttributes.hasValue(15)) {
            setBoxStrokeErrorColor(AbstractC0873c.b(context2, tintTypedArrayObtainStyledAttributes, 15));
        }
        if (tintTypedArrayObtainStyledAttributes.getResourceId(50, -1) != -1) {
            setHintTextAppearance(tintTypedArrayObtainStyledAttributes.getResourceId(50, 0));
        }
        this.f2605B = tintTypedArrayObtainStyledAttributes.getColorStateList(24);
        this.f2607C = tintTypedArrayObtainStyledAttributes.getColorStateList(25);
        int resourceId = tintTypedArrayObtainStyledAttributes.getResourceId(40, 0);
        CharSequence text = tintTypedArrayObtainStyledAttributes.getText(35);
        int i = tintTypedArrayObtainStyledAttributes.getInt(34, 1);
        boolean z10 = tintTypedArrayObtainStyledAttributes.getBoolean(36, false);
        int resourceId2 = tintTypedArrayObtainStyledAttributes.getResourceId(45, 0);
        boolean z11 = tintTypedArrayObtainStyledAttributes.getBoolean(44, false);
        CharSequence text2 = tintTypedArrayObtainStyledAttributes.getText(43);
        int resourceId3 = tintTypedArrayObtainStyledAttributes.getResourceId(58, 0);
        CharSequence text3 = tintTypedArrayObtainStyledAttributes.getText(57);
        boolean z12 = tintTypedArrayObtainStyledAttributes.getBoolean(18, false);
        setCounterMaxLength(tintTypedArrayObtainStyledAttributes.getInt(19, -1));
        this.f2647r = tintTypedArrayObtainStyledAttributes.getResourceId(22, 0);
        this.f2645q = tintTypedArrayObtainStyledAttributes.getResourceId(20, 0);
        setBoxBackgroundMode(tintTypedArrayObtainStyledAttributes.getInt(8, 0));
        setErrorContentDescription(text);
        setErrorAccessibilityLiveRegion(i);
        setCounterOverflowTextAppearance(this.f2645q);
        setHelperTextTextAppearance(resourceId2);
        setErrorTextAppearance(resourceId);
        setCounterTextAppearance(this.f2647r);
        setPlaceholderText(text3);
        setPlaceholderTextAppearance(resourceId3);
        if (tintTypedArrayObtainStyledAttributes.hasValue(41)) {
            setErrorTextColor(tintTypedArrayObtainStyledAttributes.getColorStateList(41));
        }
        if (tintTypedArrayObtainStyledAttributes.hasValue(46)) {
            setHelperTextColor(tintTypedArrayObtainStyledAttributes.getColorStateList(46));
        }
        if (tintTypedArrayObtainStyledAttributes.hasValue(51)) {
            setHintTextColor(tintTypedArrayObtainStyledAttributes.getColorStateList(51));
        }
        if (tintTypedArrayObtainStyledAttributes.hasValue(23)) {
            setCounterTextColor(tintTypedArrayObtainStyledAttributes.getColorStateList(23));
        }
        if (tintTypedArrayObtainStyledAttributes.hasValue(21)) {
            setCounterOverflowTextColor(tintTypedArrayObtainStyledAttributes.getColorStateList(21));
        }
        if (tintTypedArrayObtainStyledAttributes.hasValue(59)) {
            setPlaceholderTextColor(tintTypedArrayObtainStyledAttributes.getColorStateList(59));
        }
        m mVar = new m(this, tintTypedArrayObtainStyledAttributes);
        this.c = mVar;
        boolean z13 = tintTypedArrayObtainStyledAttributes.getBoolean(0, true);
        setHintMaxLines(tintTypedArrayObtainStyledAttributes.getInt(49, 1));
        tintTypedArrayObtainStyledAttributes.recycle();
        setImportantForAccessibility(2);
        setImportantForAutofill(1);
        frameLayout.addView(uVar);
        frameLayout.addView(mVar);
        addView(frameLayout);
        setEnabled(z13);
        setHelperTextEnabled(z11);
        setErrorEnabled(z10);
        setCounterEnabled(z12);
        setHelperText(text2);
    }

    @Nullable
    private Drawable getEditTextBoxBackground() {
        EditText editText = this.e;
        if (!(editText instanceof AutoCompleteTextView) || AbstractC0291a.w(editText)) {
            return this.f2614G;
        }
        int iA = W2.a.a(androidx.appcompat.R.attr.colorControlHighlight, this.e);
        int i = this.f2624T;
        int[][] iArr = f2602H0;
        if (i != 2) {
            if (i != 1) {
                return null;
            }
            e3.k kVar = this.f2614G;
            int i6 = this.f2630c0;
            return new RippleDrawable(new ColorStateList(iArr, new int[]{W2.a.c(0.1f, iA, i6), i6}), kVar, kVar);
        }
        Context context = getContext();
        e3.k kVar2 = this.f2614G;
        TypedValue typedValueD = AbstractC0872b.d(context, "TextInputLayout", com.stepos.ability.R.attr.colorSurface);
        int i10 = typedValueD.resourceId;
        int color = i10 != 0 ? ContextCompat.getColor(context, i10) : typedValueD.data;
        e3.k kVar3 = new e3.k(kVar2.b.f4345a);
        int iC = W2.a.c(0.1f, iA, color);
        kVar3.q(new ColorStateList(iArr, new int[]{iC, 0}));
        kVar3.setTint(color);
        ColorStateList colorStateList = new ColorStateList(iArr, new int[]{iC, color});
        e3.k kVar4 = new e3.k(kVar2.b.f4345a);
        kVar4.setTint(-1);
        return new LayerDrawable(new Drawable[]{new RippleDrawable(colorStateList, kVar3, kVar4), kVar2});
    }

    private Drawable getOrCreateFilledDropDownMenuBackground() {
        if (this.f2617M == null) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            this.f2617M = stateListDrawable;
            stateListDrawable.addState(new int[]{R.attr.state_above_anchor}, getOrCreateOutlinedDropDownMenuBackground());
            this.f2617M.addState(new int[0], h(false));
        }
        return this.f2617M;
    }

    private Drawable getOrCreateOutlinedDropDownMenuBackground() {
        if (this.f2616L == null) {
            this.f2616L = h(true);
        }
        return this.f2616L;
    }

    public static void m(ViewGroup viewGroup, boolean z10) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            childAt.setEnabled(z10);
            if (childAt instanceof ViewGroup) {
                m((ViewGroup) childAt, z10);
            }
        }
    }

    private void setEditText(EditText editText) {
        if (this.e != null) {
            throw new IllegalArgumentException("We already have an EditText, can only have one");
        }
        if (getEndIconMode() != 3 && !(editText instanceof TextInputEditText)) {
            Log.i("TextInputLayout", "EditText added is not a TextInputEditText. Please switch to using that class instead.");
        }
        this.e = editText;
        int i = this.g;
        if (i != -1) {
            setMinEms(i);
        } else {
            setMinWidth(this.i);
        }
        int i6 = this.h;
        if (i6 != -1) {
            setMaxEms(i6);
        } else {
            setMaxWidth(this.f2637j);
        }
        this.f2618N = false;
        k();
        setTextInputAccessibilityDelegate(new w(this));
        Typeface typeface = this.e.getTypeface();
        com.google.android.material.internal.c cVar = this.f2604A0;
        cVar.n(typeface);
        float textSize = this.e.getTextSize();
        if (cVar.h != textSize) {
            cVar.h = textSize;
            cVar.j(false);
        }
        float letterSpacing = this.e.getLetterSpacing();
        if (cVar.f2474X != letterSpacing) {
            cVar.f2474X = letterSpacing;
            cVar.j(false);
        }
        int gravity = this.e.getGravity();
        int i10 = (gravity & (-113)) | 48;
        if (cVar.g != i10) {
            cVar.g = i10;
            cVar.j(false);
        }
        if (cVar.f != gravity) {
            cVar.f = gravity;
            cVar.j(false);
        }
        this.f2658y0 = editText.getMinimumHeight();
        this.e.addTextChangedListener(new v(this, editText));
        if (this.f2642n0 == null) {
            this.f2642n0 = this.e.getHintTextColors();
        }
        if (this.f2609D) {
            if (TextUtils.isEmpty(this.E)) {
                CharSequence hint = this.e.getHint();
                this.f = hint;
                setHint(hint);
                this.e.setHint((CharSequence) null);
            }
            this.f2612F = true;
        }
        r();
        if (this.p != null) {
            p(this.e.getText());
        }
        t();
        this.k.b();
        this.b.bringToFront();
        m mVar = this.c;
        mVar.bringToFront();
        Iterator it = this.f2638j0.iterator();
        while (it.hasNext()) {
            ((l) it.next()).a(this);
        }
        mVar.m();
        if (!isEnabled()) {
            editText.setEnabled(false);
        }
        w(false, true);
    }

    private void setHintInternal(CharSequence charSequence) {
        if (TextUtils.equals(charSequence, this.E)) {
            return;
        }
        this.E = charSequence;
        com.google.android.material.internal.c cVar = this.f2604A0;
        if (charSequence == null || !TextUtils.equals(cVar.f2453B, charSequence)) {
            cVar.f2453B = charSequence;
            cVar.f2454C = null;
            cVar.j(false);
        }
        if (this.f2660z0) {
            return;
        }
        l();
    }

    private void setPlaceholderTextEnabled(boolean z10) {
        if (this.f2650t == z10) {
            return;
        }
        if (z10) {
            AppCompatTextView appCompatTextView = this.u;
            if (appCompatTextView != null) {
                this.f2628a.addView(appCompatTextView);
                this.u.setVisibility(0);
            }
        } else {
            AppCompatTextView appCompatTextView2 = this.u;
            if (appCompatTextView2 != null) {
                appCompatTextView2.setVisibility(8);
            }
            this.u = null;
        }
        this.f2650t = z10;
    }

    public final void a() {
        if (this.e == null || this.f2624T != 1) {
            return;
        }
        if (getHintMaxLines() != 1) {
            EditText editText = this.e;
            editText.setPaddingRelative(editText.getPaddingStart(), (int) (this.f2604A0.f() + this.d), this.e.getPaddingEnd(), getResources().getDimensionPixelSize(com.stepos.ability.R.dimen.material_filled_edittext_font_1_3_padding_bottom));
        } else if (getContext().getResources().getConfiguration().fontScale >= 2.0f) {
            EditText editText2 = this.e;
            editText2.setPaddingRelative(editText2.getPaddingStart(), getResources().getDimensionPixelSize(com.stepos.ability.R.dimen.material_filled_edittext_font_2_0_padding_top), this.e.getPaddingEnd(), getResources().getDimensionPixelSize(com.stepos.ability.R.dimen.material_filled_edittext_font_2_0_padding_bottom));
        } else if (AbstractC0873c.d(getContext())) {
            EditText editText3 = this.e;
            editText3.setPaddingRelative(editText3.getPaddingStart(), getResources().getDimensionPixelSize(com.stepos.ability.R.dimen.material_filled_edittext_font_1_3_padding_top), this.e.getPaddingEnd(), getResources().getDimensionPixelSize(com.stepos.ability.R.dimen.material_filled_edittext_font_1_3_padding_bottom));
        }
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof EditText)) {
            super.addView(view, i, layoutParams);
            return;
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams);
        layoutParams2.gravity = (layoutParams2.gravity & (-113)) | 16;
        FrameLayout frameLayout = this.f2628a;
        frameLayout.addView(view, layoutParams2);
        frameLayout.setLayoutParams(layoutParams);
        v();
        setEditText((EditText) view);
    }

    public final void b(float f) {
        com.google.android.material.internal.c cVar = this.f2604A0;
        if (cVar.b == f) {
            return;
        }
        if (this.f2610D0 == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.f2610D0 = valueAnimator;
            valueAnimator.setInterpolator(N.O(getContext(), com.stepos.ability.R.attr.motionEasingEmphasizedInterpolator, Q2.a.b));
            this.f2610D0.setDuration(N.N(getContext(), com.stepos.ability.R.attr.motionDurationMedium4, 167));
            this.f2610D0.addUpdateListener(new J4.c(this, 3));
        }
        this.f2610D0.setFloatValues(cVar.b, f);
        this.f2610D0.start();
    }

    public final void c() {
        int i;
        int i6;
        e3.k kVar = this.f2614G;
        if (kVar == null) {
            return;
        }
        e3.p pVar = kVar.b.f4345a;
        e3.p pVar2 = this.f2621Q;
        if (pVar != pVar2) {
            kVar.setShapeAppearanceModel(pVar2);
        }
        if (this.f2624T == 2 && (i = this.f2626V) > -1 && (i6 = this.b0) != 0) {
            e3.k kVar2 = this.f2614G;
            kVar2.b.k = i;
            kVar2.invalidateSelf();
            kVar2.v(ColorStateList.valueOf(i6));
        }
        int iCompositeColors = this.f2630c0;
        if (this.f2624T == 1) {
            Integer numB = W2.a.b(com.stepos.ability.R.attr.colorSurface, getContext());
            iCompositeColors = ColorUtils.compositeColors(this.f2630c0, numB != null ? numB.intValue() : 0);
        }
        this.f2630c0 = iCompositeColors;
        this.f2614G.q(ColorStateList.valueOf(iCompositeColors));
        e3.k kVar3 = this.f2619O;
        if (kVar3 != null && this.f2620P != null) {
            if (this.f2626V > -1 && this.b0 != 0) {
                kVar3.q(this.e.isFocused() ? ColorStateList.valueOf(this.f2644p0) : ColorStateList.valueOf(this.b0));
                this.f2620P.q(ColorStateList.valueOf(this.b0));
            }
            invalidate();
        }
        u();
    }

    public final Rect d(Rect rect) {
        if (this.e == null) {
            throw new IllegalStateException();
        }
        boolean z10 = getLayoutDirection() == 1;
        int i = rect.bottom;
        Rect rect2 = this.f2632e0;
        rect2.bottom = i;
        int i6 = this.f2624T;
        if (i6 == 1) {
            rect2.left = i(rect.left, z10);
            rect2.top = rect.top + this.f2625U;
            rect2.right = j(rect.right, z10);
            return rect2;
        }
        if (i6 != 2) {
            rect2.left = i(rect.left, z10);
            rect2.top = getPaddingTop();
            rect2.right = j(rect.right, z10);
            return rect2;
        }
        rect2.left = this.e.getPaddingLeft() + rect.left;
        rect2.top = rect.top - e();
        rect2.right = rect.right - this.e.getPaddingRight();
        return rect2;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchProvideAutofillStructure(ViewStructure viewStructure, int i) {
        EditText editText = this.e;
        if (editText == null) {
            super.dispatchProvideAutofillStructure(viewStructure, i);
            return;
        }
        if (this.f != null) {
            boolean z10 = this.f2612F;
            this.f2612F = false;
            CharSequence hint = editText.getHint();
            this.e.setHint(this.f);
            try {
                super.dispatchProvideAutofillStructure(viewStructure, i);
                return;
            } finally {
                this.e.setHint(hint);
                this.f2612F = z10;
            }
        }
        viewStructure.setAutofillId(getAutofillId());
        onProvideAutofillStructure(viewStructure, i);
        onProvideAutofillVirtualStructure(viewStructure, i);
        FrameLayout frameLayout = this.f2628a;
        viewStructure.setChildCount(frameLayout.getChildCount());
        for (int i6 = 0; i6 < frameLayout.getChildCount(); i6++) {
            View childAt = frameLayout.getChildAt(i6);
            ViewStructure viewStructureNewChild = viewStructure.newChild(i6);
            childAt.dispatchProvideAutofillStructure(viewStructureNewChild, i);
            if (childAt == this.e) {
                viewStructureNewChild.setHint(getHint());
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchRestoreInstanceState(SparseArray sparseArray) {
        this.f2613F0 = true;
        super.dispatchRestoreInstanceState(sparseArray);
        this.f2613F0 = false;
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        e3.k kVar;
        super.draw(canvas);
        boolean z10 = this.f2609D;
        com.google.android.material.internal.c cVar = this.f2604A0;
        if (z10) {
            TextPaint textPaint = cVar.f2465O;
            RectF rectF = cVar.e;
            int iSave = canvas.save();
            if (cVar.f2454C != null && rectF.width() > 0.0f && rectF.height() > 0.0f) {
                textPaint.setTextSize(cVar.f2457G);
                float f = cVar.f2489q;
                float f7 = cVar.f2490r;
                float f9 = cVar.f2456F;
                if (f9 != 1.0f) {
                    canvas.scale(f9, f9, f, f7);
                }
                if ((cVar.f2481e0 > 1 || cVar.f2482f0 > 1) && !cVar.f2455D && cVar.o()) {
                    float lineStart = cVar.f2489q - cVar.f2476Z.getLineStart(0);
                    int alpha = textPaint.getAlpha();
                    canvas.translate(lineStart, f7);
                    float f10 = alpha;
                    textPaint.setAlpha((int) (cVar.f2479c0 * f10));
                    float f11 = cVar.f2458H;
                    float f12 = cVar.f2459I;
                    float f13 = cVar.f2460J;
                    int i = cVar.f2461K;
                    textPaint.setShadowLayer(f11, f12, f13, ColorUtils.setAlphaComponent(i, (Color.alpha(i) * textPaint.getAlpha()) / 255));
                    cVar.f2476Z.draw(canvas);
                    textPaint.setAlpha((int) (cVar.b0 * f10));
                    float f14 = cVar.f2458H;
                    float f15 = cVar.f2459I;
                    float f16 = cVar.f2460J;
                    int i6 = cVar.f2461K;
                    textPaint.setShadowLayer(f14, f15, f16, ColorUtils.setAlphaComponent(i6, (Color.alpha(i6) * textPaint.getAlpha()) / 255));
                    int lineBaseline = cVar.f2476Z.getLineBaseline(0);
                    CharSequence charSequence = cVar.f2480d0;
                    float f17 = lineBaseline;
                    canvas.drawText(charSequence, 0, charSequence.length(), 0.0f, f17, textPaint);
                    textPaint.setShadowLayer(cVar.f2458H, cVar.f2459I, cVar.f2460J, cVar.f2461K);
                    String strTrim = cVar.f2480d0.toString().trim();
                    if (strTrim.endsWith("…")) {
                        strTrim = strTrim.substring(0, strTrim.length() - 1);
                    }
                    String str = strTrim;
                    textPaint.setAlpha(alpha);
                    canvas.drawText(str, 0, Math.min(cVar.f2476Z.getLineEnd(0), str.length()), 0.0f, f17, (Paint) textPaint);
                    canvas = canvas;
                } else {
                    canvas.translate(f, f7);
                    cVar.f2476Z.draw(canvas);
                }
                canvas.restoreToCount(iSave);
            }
        }
        if (this.f2620P == null || (kVar = this.f2619O) == null) {
            return;
        }
        kVar.draw(canvas);
        if (this.e.isFocused()) {
            Rect bounds = this.f2620P.getBounds();
            Rect bounds2 = this.f2619O.getBounds();
            float f18 = cVar.b;
            int iCenterX = bounds2.centerX();
            bounds.left = Q2.a.c(iCenterX, bounds2.left, f18);
            bounds.right = Q2.a.c(iCenterX, bounds2.right, f18);
            this.f2620P.draw(canvas);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002f  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void drawableStateChanged() {
        /*
            r4 = this;
            boolean r0 = r4.f2611E0
            if (r0 == 0) goto L5
            return
        L5:
            r0 = 1
            r4.f2611E0 = r0
            super.drawableStateChanged()
            int[] r1 = r4.getDrawableState()
            r2 = 0
            com.google.android.material.internal.c r3 = r4.f2604A0
            if (r3 == 0) goto L2f
            r3.f2463M = r1
            android.content.res.ColorStateList r1 = r3.k
            if (r1 == 0) goto L20
            boolean r1 = r1.isStateful()
            if (r1 != 0) goto L2a
        L20:
            android.content.res.ColorStateList r1 = r3.f2486j
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
            android.widget.EditText r3 = r4.e
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
            r4.f2611E0 = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.drawableStateChanged():void");
    }

    public final int e() {
        if (this.f2609D) {
            int i = this.f2624T;
            com.google.android.material.internal.c cVar = this.f2604A0;
            if (i == 0) {
                return (int) cVar.f();
            }
            if (i == 2) {
                if (getHintMaxLines() == 1) {
                    return (int) (cVar.f() / 2.0f);
                }
                float f = cVar.f();
                TextPaint textPaint = cVar.f2466P;
                textPaint.setTextSize(cVar.i);
                textPaint.setTypeface(cVar.f2491s);
                textPaint.setLetterSpacing(cVar.f2473W);
                return Math.max(0, (int) (f - ((-textPaint.ascent()) / 2.0f)));
            }
        }
        return 0;
    }

    public final Fade f() {
        Fade fade = new Fade();
        fade.setDuration(N.N(getContext(), com.stepos.ability.R.attr.motionDurationShort2, 87));
        fade.setInterpolator(N.O(getContext(), com.stepos.ability.R.attr.motionEasingLinearInterpolator, Q2.a.f1097a));
        return fade;
    }

    public final boolean g() {
        return this.f2609D && !TextUtils.isEmpty(this.E) && (this.f2614G instanceof f);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public int getBaseline() {
        EditText editText = this.e;
        if (editText == null) {
            return super.getBaseline();
        }
        return e() + getPaddingTop() + editText.getBaseline();
    }

    @NonNull
    public e3.k getBoxBackground() {
        int i = this.f2624T;
        if (i == 1 || i == 2) {
            return this.f2614G;
        }
        throw new IllegalStateException();
    }

    public int getBoxBackgroundColor() {
        return this.f2630c0;
    }

    public int getBoxBackgroundMode() {
        return this.f2624T;
    }

    public int getBoxCollapsedPaddingTop() {
        return this.f2625U;
    }

    public float getBoxCornerRadiusBottomEnd() {
        int layoutDirection = getLayoutDirection();
        RectF rectF = this.f2633f0;
        return layoutDirection == 1 ? this.f2621Q.h.a(rectF) : this.f2621Q.g.a(rectF);
    }

    public float getBoxCornerRadiusBottomStart() {
        int layoutDirection = getLayoutDirection();
        RectF rectF = this.f2633f0;
        return layoutDirection == 1 ? this.f2621Q.g.a(rectF) : this.f2621Q.h.a(rectF);
    }

    public float getBoxCornerRadiusTopEnd() {
        int layoutDirection = getLayoutDirection();
        RectF rectF = this.f2633f0;
        return layoutDirection == 1 ? this.f2621Q.e.a(rectF) : this.f2621Q.f.a(rectF);
    }

    public float getBoxCornerRadiusTopStart() {
        int layoutDirection = getLayoutDirection();
        RectF rectF = this.f2633f0;
        return layoutDirection == 1 ? this.f2621Q.f.a(rectF) : this.f2621Q.e.a(rectF);
    }

    public int getBoxStrokeColor() {
        return this.f2648r0;
    }

    @Nullable
    public ColorStateList getBoxStrokeErrorColor() {
        return this.s0;
    }

    public int getBoxStrokeWidth() {
        return this.f2627W;
    }

    public int getBoxStrokeWidthFocused() {
        return this.f2629a0;
    }

    public int getCounterMaxLength() {
        return this.m;
    }

    @Nullable
    public CharSequence getCounterOverflowDescription() {
        AppCompatTextView appCompatTextView;
        if (this.l && this.n && (appCompatTextView = this.p) != null) {
            return appCompatTextView.getContentDescription();
        }
        return null;
    }

    @Nullable
    public ColorStateList getCounterOverflowTextColor() {
        return this.f2603A;
    }

    @Nullable
    public ColorStateList getCounterTextColor() {
        return this.f2659z;
    }

    @Nullable
    @RequiresApi(29)
    public ColorStateList getCursorColor() {
        return this.f2605B;
    }

    @Nullable
    @RequiresApi(29)
    public ColorStateList getCursorErrorColor() {
        return this.f2607C;
    }

    @Nullable
    public ColorStateList getDefaultHintTextColor() {
        return this.f2642n0;
    }

    @Nullable
    public EditText getEditText() {
        return this.e;
    }

    @Nullable
    public CharSequence getEndIconContentDescription() {
        return this.c.g.getContentDescription();
    }

    @Nullable
    public Drawable getEndIconDrawable() {
        return this.c.g.getDrawable();
    }

    public int getEndIconMinSize() {
        return this.c.m;
    }

    public int getEndIconMode() {
        return this.c.i;
    }

    @NonNull
    public ImageView.ScaleType getEndIconScaleType() {
        return this.c.n;
    }

    @NonNull
    public CheckableImageButton getEndIconView() {
        return this.c.g;
    }

    @Nullable
    public CharSequence getError() {
        q qVar = this.k;
        if (qVar.f2689q) {
            return qVar.p;
        }
        return null;
    }

    public int getErrorAccessibilityLiveRegion() {
        return this.k.f2692t;
    }

    @Nullable
    public CharSequence getErrorContentDescription() {
        return this.k.f2691s;
    }

    @ColorInt
    public int getErrorCurrentTextColors() {
        AppCompatTextView appCompatTextView = this.k.f2690r;
        if (appCompatTextView != null) {
            return appCompatTextView.getCurrentTextColor();
        }
        return -1;
    }

    @Nullable
    public Drawable getErrorIconDrawable() {
        return this.c.c.getDrawable();
    }

    @Nullable
    public CharSequence getHelperText() {
        q qVar = this.k;
        if (qVar.f2695x) {
            return qVar.f2694w;
        }
        return null;
    }

    @ColorInt
    public int getHelperTextCurrentTextColor() {
        AppCompatTextView appCompatTextView = this.k.y;
        if (appCompatTextView != null) {
            return appCompatTextView.getCurrentTextColor();
        }
        return -1;
    }

    @Nullable
    public CharSequence getHint() {
        if (this.f2609D) {
            return this.E;
        }
        return null;
    }

    @VisibleForTesting
    public final float getHintCollapsedTextHeight() {
        return this.f2604A0.f();
    }

    @VisibleForTesting
    public final int getHintCurrentCollapsedTextColor() {
        com.google.android.material.internal.c cVar = this.f2604A0;
        return cVar.g(cVar.k);
    }

    public int getHintMaxLines() {
        return this.f2604A0.f2481e0;
    }

    @Nullable
    public ColorStateList getHintTextColor() {
        return this.f2643o0;
    }

    @NonNull
    public x getLengthCounter() {
        return this.o;
    }

    public int getMaxEms() {
        return this.h;
    }

    @Px
    public int getMaxWidth() {
        return this.f2637j;
    }

    public int getMinEms() {
        return this.g;
    }

    @Px
    public int getMinWidth() {
        return this.i;
    }

    @Nullable
    @Deprecated
    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.c.g.getContentDescription();
    }

    @Nullable
    @Deprecated
    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.c.g.getDrawable();
    }

    @Nullable
    public CharSequence getPlaceholderText() {
        if (this.f2650t) {
            return this.f2649s;
        }
        return null;
    }

    @StyleRes
    public int getPlaceholderTextAppearance() {
        return this.f2654w;
    }

    @Nullable
    public ColorStateList getPlaceholderTextColor() {
        return this.f2652v;
    }

    @Nullable
    public CharSequence getPrefixText() {
        return this.b.c;
    }

    @Nullable
    public ColorStateList getPrefixTextColor() {
        return this.b.b.getTextColors();
    }

    @NonNull
    public TextView getPrefixTextView() {
        return this.b.b;
    }

    @NonNull
    public e3.p getShapeAppearanceModel() {
        return this.f2621Q;
    }

    @Nullable
    public CharSequence getStartIconContentDescription() {
        return this.b.d.getContentDescription();
    }

    @Nullable
    public Drawable getStartIconDrawable() {
        return this.b.d.getDrawable();
    }

    public int getStartIconMinSize() {
        return this.b.g;
    }

    @NonNull
    public ImageView.ScaleType getStartIconScaleType() {
        return this.b.h;
    }

    @Nullable
    public CharSequence getSuffixText() {
        return this.c.p;
    }

    @Nullable
    public ColorStateList getSuffixTextColor() {
        return this.c.f2677q.getTextColors();
    }

    @NonNull
    public TextView getSuffixTextView() {
        return this.c.f2677q;
    }

    @Nullable
    public Typeface getTypeface() {
        return this.f2634g0;
    }

    public final e3.k h(boolean z10) throws Resources.NotFoundException {
        float dimensionPixelOffset = getResources().getDimensionPixelOffset(com.stepos.ability.R.dimen.mtrl_shape_corner_size_small_component);
        float f = z10 ? dimensionPixelOffset : 0.0f;
        EditText editText = this.e;
        float popupElevation = editText instanceof MaterialAutoCompleteTextView ? ((MaterialAutoCompleteTextView) editText).getPopupElevation() : getResources().getDimensionPixelOffset(com.stepos.ability.R.dimen.m3_comp_outlined_autocomplete_menu_container_elevation);
        int dimensionPixelOffset2 = getResources().getDimensionPixelOffset(com.stepos.ability.R.dimen.mtrl_exposed_dropdown_menu_popup_vertical_padding);
        e3.n nVar = new e3.n();
        e3.n nVar2 = new e3.n();
        e3.n nVar3 = new e3.n();
        e3.n nVar4 = new e3.n();
        int i = 0;
        C1417f c1417f = new C1417f(i);
        C1417f c1417f2 = new C1417f(i);
        C1417f c1417f3 = new C1417f(i);
        C1417f c1417f4 = new C1417f(i);
        C1412a c1412a = new C1412a(f);
        C1412a c1412a2 = new C1412a(f);
        C1412a c1412a3 = new C1412a(dimensionPixelOffset);
        C1412a c1412a4 = new C1412a(dimensionPixelOffset);
        e3.p pVar = new e3.p();
        pVar.f4369a = nVar;
        pVar.b = nVar2;
        pVar.c = nVar3;
        pVar.d = nVar4;
        pVar.e = c1412a;
        pVar.f = c1412a2;
        pVar.g = c1412a4;
        pVar.h = c1412a3;
        pVar.i = c1417f;
        pVar.f4370j = c1417f2;
        pVar.k = c1417f3;
        pVar.l = c1417f4;
        EditText editText2 = this.e;
        ColorStateList dropDownBackgroundTintList = editText2 instanceof MaterialAutoCompleteTextView ? ((MaterialAutoCompleteTextView) editText2).getDropDownBackgroundTintList() : null;
        Context context = getContext();
        if (dropDownBackgroundTintList == null) {
            Paint paint = e3.k.f4350F;
            TypedValue typedValueD = AbstractC0872b.d(context, e3.k.class.getSimpleName(), com.stepos.ability.R.attr.colorSurface);
            int i6 = typedValueD.resourceId;
            dropDownBackgroundTintList = ColorStateList.valueOf(i6 != 0 ? ContextCompat.getColor(context, i6) : typedValueD.data);
        }
        e3.k kVar = new e3.k();
        kVar.m(context);
        kVar.q(dropDownBackgroundTintList);
        kVar.p(popupElevation);
        kVar.setShapeAppearanceModel(pVar);
        C1419h c1419h = kVar.b;
        if (c1419h.h == null) {
            c1419h.h = new Rect();
        }
        kVar.b.h.set(0, dimensionPixelOffset2, 0, dimensionPixelOffset2);
        kVar.invalidateSelf();
        return kVar;
    }

    public final int i(int i, boolean z10) {
        return ((z10 || getPrefixText() == null) ? (!z10 || getSuffixText() == null) ? this.e.getCompoundPaddingLeft() : this.c.c() : this.b.a()) + i;
    }

    public final int j(int i, boolean z10) {
        return i - ((z10 || getSuffixText() == null) ? (!z10 || getPrefixText() == null) ? this.e.getCompoundPaddingRight() : this.b.a() : this.c.c());
    }

    public final void k() {
        int i = this.f2624T;
        if (i == 0) {
            this.f2614G = null;
            this.f2619O = null;
            this.f2620P = null;
        } else if (i == 1) {
            this.f2614G = new e3.k(this.f2621Q);
            this.f2619O = new e3.k();
            this.f2620P = new e3.k();
        } else {
            if (i != 2) {
                throw new IllegalArgumentException(androidx.appfunctions.metadata.a.o(new StringBuilder(), " is illegal; only @BoxBackgroundMode constants are supported.", this.f2624T));
            }
            if (!this.f2609D || (this.f2614G instanceof f)) {
                this.f2614G = new e3.k(this.f2621Q);
            } else {
                e3.p pVar = this.f2621Q;
                int i6 = f.f2665M;
                if (pVar == null) {
                    pVar = new e3.p();
                }
                e eVar = new e(pVar, new RectF());
                f fVar = new f(eVar);
                fVar.f2666L = eVar;
                this.f2614G = fVar;
            }
            this.f2619O = null;
            this.f2620P = null;
        }
        u();
        z();
        if (this.f2624T == 1) {
            if (getContext().getResources().getConfiguration().fontScale >= 2.0f) {
                this.f2625U = getResources().getDimensionPixelSize(com.stepos.ability.R.dimen.material_font_2_0_box_collapsed_padding_top);
            } else if (AbstractC0873c.d(getContext())) {
                this.f2625U = getResources().getDimensionPixelSize(com.stepos.ability.R.dimen.material_font_1_3_box_collapsed_padding_top);
            }
        }
        a();
        if (this.f2624T != 0) {
            v();
        }
        EditText editText = this.e;
        if (editText instanceof AutoCompleteTextView) {
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) editText;
            if (autoCompleteTextView.getDropDownBackground() == null) {
                int i10 = this.f2624T;
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

    public final void n(AppCompatTextView appCompatTextView, int i) {
        try {
            TextViewCompat.setTextAppearance(appCompatTextView, i);
            if (appCompatTextView.getTextColors().getDefaultColor() != -65281) {
                return;
            }
        } catch (Exception unused) {
        }
        TextViewCompat.setTextAppearance(appCompatTextView, androidx.appcompat.R.style.TextAppearance_AppCompat_Caption);
        appCompatTextView.setTextColor(ContextCompat.getColor(getContext(), com.stepos.ability.R.color.design_error));
    }

    public final boolean o() {
        q qVar = this.k;
        return (qVar.o != 1 || qVar.f2690r == null || TextUtils.isEmpty(qVar.p)) ? false : true;
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f2604A0.i(configuration);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        int iMax;
        m mVar = this.c;
        mVar.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        boolean z10 = false;
        this.f2615G0 = false;
        if (this.e != null && this.e.getMeasuredHeight() < (iMax = Math.max(mVar.getMeasuredHeight(), this.b.getMeasuredHeight()))) {
            this.e.setMinimumHeight(iMax);
            z10 = true;
        }
        boolean zS = s();
        if (z10 || zS) {
            this.e.post(new D6.b(this, 21));
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z10, int i, int i6, int i10, int i11) {
        float fDescent;
        int i12;
        int compoundPaddingTop;
        super.onLayout(z10, i, i6, i10, i11);
        EditText editText = this.e;
        if (editText != null) {
            ThreadLocal threadLocal = com.google.android.material.internal.d.f2497a;
            int width = editText.getWidth();
            int height = editText.getHeight();
            Rect rect = this.f2631d0;
            rect.set(0, 0, width, height);
            com.google.android.material.internal.d.b(this, editText, rect);
            e3.k kVar = this.f2619O;
            if (kVar != null) {
                int i13 = rect.bottom;
                kVar.setBounds(rect.left, i13 - this.f2627W, rect.right, i13);
            }
            e3.k kVar2 = this.f2620P;
            if (kVar2 != null) {
                int i14 = rect.bottom;
                kVar2.setBounds(rect.left, i14 - this.f2629a0, rect.right, i14);
            }
            if (this.f2609D) {
                float textSize = this.e.getTextSize();
                com.google.android.material.internal.c cVar = this.f2604A0;
                float f = cVar.h;
                TextPaint textPaint = cVar.f2466P;
                if (f != textSize) {
                    cVar.h = textSize;
                    cVar.j(false);
                }
                int gravity = this.e.getGravity();
                int i15 = (gravity & (-113)) | 48;
                if (cVar.g != i15) {
                    cVar.g = i15;
                    cVar.j(false);
                }
                if (cVar.f != gravity) {
                    cVar.f = gravity;
                    cVar.j(false);
                }
                Rect rectD = d(rect);
                int i16 = rectD.left;
                int i17 = rectD.top;
                int i18 = rectD.right;
                int i19 = rectD.bottom;
                Rect rect2 = cVar.d;
                if (rect2.left != i16 || rect2.top != i17 || rect2.right != i18 || rect2.bottom != i19) {
                    rect2.set(i16, i17, i18, i19);
                    cVar.f2464N = true;
                }
                if (this.e == null) {
                    throw new IllegalStateException();
                }
                if (getHintMaxLines() == 1) {
                    textPaint.setTextSize(cVar.h);
                    textPaint.setTypeface(cVar.f2493v);
                    textPaint.setLetterSpacing(cVar.f2474X);
                    fDescent = -textPaint.ascent();
                } else {
                    textPaint.setTextSize(cVar.h);
                    textPaint.setTypeface(cVar.f2493v);
                    textPaint.setLetterSpacing(cVar.f2474X);
                    fDescent = cVar.l * (textPaint.descent() + (-textPaint.ascent()));
                }
                int compoundPaddingLeft = this.e.getCompoundPaddingLeft() + rect.left;
                Rect rect3 = this.f2632e0;
                rect3.left = compoundPaddingLeft;
                if (this.f2624T != 1 || this.e.getMinLines() > 1) {
                    if (this.f2624T != 0 || getHintMaxLines() == 1) {
                        i12 = 0;
                    } else {
                        textPaint.setTextSize(cVar.h);
                        textPaint.setTypeface(cVar.f2493v);
                        textPaint.setLetterSpacing(cVar.f2474X);
                        i12 = (int) ((-textPaint.ascent()) / 2.0f);
                    }
                    compoundPaddingTop = (this.e.getCompoundPaddingTop() + rect.top) - i12;
                } else {
                    compoundPaddingTop = (int) (rect.centerY() - (fDescent / 2.0f));
                }
                rect3.top = compoundPaddingTop;
                rect3.right = rect.right - this.e.getCompoundPaddingRight();
                int compoundPaddingBottom = (this.f2624T != 1 || this.e.getMinLines() > 1) ? rect.bottom - this.e.getCompoundPaddingBottom() : (int) (rect3.top + fDescent);
                rect3.bottom = compoundPaddingBottom;
                int i20 = rect3.left;
                int i21 = rect3.top;
                int i22 = rect3.right;
                Rect rect4 = cVar.c;
                if (rect4.left != i20 || rect4.top != i21 || rect4.right != i22 || rect4.bottom != compoundPaddingBottom || true != cVar.f2488k0) {
                    rect4.set(i20, i21, i22, compoundPaddingBottom);
                    cVar.f2464N = true;
                    cVar.f2488k0 = true;
                }
                cVar.j(false);
                if (!g() || this.f2660z0) {
                    return;
                }
                l();
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i, int i6) {
        float f;
        EditText editText;
        super.onMeasure(i, i6);
        boolean z10 = this.f2615G0;
        m mVar = this.c;
        if (!z10) {
            mVar.getViewTreeObserver().addOnGlobalLayoutListener(this);
            this.f2615G0 = true;
        }
        if (this.u != null && (editText = this.e) != null) {
            this.u.setGravity(editText.getGravity());
            this.u.setPadding(this.e.getCompoundPaddingLeft(), this.e.getCompoundPaddingTop(), this.e.getCompoundPaddingRight(), this.e.getCompoundPaddingBottom());
        }
        mVar.m();
        if (getHintMaxLines() == 1) {
            return;
        }
        int measuredWidth = (this.e.getMeasuredWidth() - this.e.getCompoundPaddingLeft()) - this.e.getCompoundPaddingRight();
        com.google.android.material.internal.c cVar = this.f2604A0;
        TextPaint textPaint = cVar.f2466P;
        textPaint.setTextSize(cVar.i);
        textPaint.setTypeface(cVar.f2491s);
        textPaint.setLetterSpacing(cVar.f2473W);
        float f7 = measuredWidth;
        cVar.f2485i0 = cVar.e(cVar.f2482f0, textPaint, cVar.f2453B, (cVar.i / cVar.h) * f7, cVar.f2455D).getHeight();
        textPaint.setTextSize(cVar.h);
        textPaint.setTypeface(cVar.f2493v);
        textPaint.setLetterSpacing(cVar.f2474X);
        cVar.f2487j0 = cVar.e(cVar.f2481e0, textPaint, cVar.f2453B, f7, cVar.f2455D).getHeight();
        EditText editText2 = this.e;
        ThreadLocal threadLocal = com.google.android.material.internal.d.f2497a;
        int width = editText2.getWidth();
        int height = editText2.getHeight();
        Rect rect = this.f2631d0;
        rect.set(0, 0, width, height);
        com.google.android.material.internal.d.b(this, editText2, rect);
        Rect rectD = d(rect);
        int i10 = rectD.left;
        int i11 = rectD.top;
        int i12 = rectD.right;
        int i13 = rectD.bottom;
        Rect rect2 = cVar.d;
        if (rect2.left != i10 || rect2.top != i11 || rect2.right != i12 || rect2.bottom != i13) {
            rect2.set(i10, i11, i12, i13);
            cVar.f2464N = true;
        }
        v();
        a();
        if (this.e == null) {
            return;
        }
        int i14 = cVar.f2487j0;
        if (i14 != -1) {
            f = i14;
        } else {
            TextPaint textPaint2 = cVar.f2466P;
            textPaint2.setTextSize(cVar.h);
            textPaint2.setTypeface(cVar.f2493v);
            textPaint2.setLetterSpacing(cVar.f2474X);
            f = -textPaint2.ascent();
        }
        if (this.f2649s != null) {
            TextPaint textPaint3 = new TextPaint(129);
            textPaint3.set(this.u.getPaint());
            textPaint3.setTextSize(this.u.getTextSize());
            textPaint3.setTypeface(this.u.getTypeface());
            textPaint3.setLetterSpacing(this.u.getLetterSpacing());
            com.google.android.material.internal.g gVar = new com.google.android.material.internal.g(this.f2649s, textPaint3, measuredWidth);
            gVar.k = getLayoutDirection() == 1;
            gVar.f2500j = true;
            float lineSpacingExtra = this.u.getLineSpacingExtra();
            float lineSpacingMultiplier = this.u.getLineSpacingMultiplier();
            gVar.g = lineSpacingExtra;
            gVar.h = lineSpacingMultiplier;
            gVar.m = new B5.a(this, 15);
            f = (this.f2624T == 1 ? cVar.f() + this.f2625U + this.d : 0.0f) + gVar.a().getHeight();
        }
        float fMax = Math.max(f, f);
        if (this.e.getMeasuredHeight() < fMax) {
            this.e.setMinimumHeight(Math.round(fMax));
        }
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setError(savedState.error);
        if (savedState.isEndIconChecked) {
            post(new A6.l(this, 19));
        }
        requestLayout();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onRtlPropertiesChanged(int i) {
        super.onRtlPropertiesChanged(i);
        boolean z10 = i == 1;
        if (z10 != this.f2622R) {
            InterfaceC1415d interfaceC1415d = this.f2621Q.e;
            RectF rectF = this.f2633f0;
            float fA = interfaceC1415d.a(rectF);
            float fA2 = this.f2621Q.f.a(rectF);
            float fA3 = this.f2621Q.h.a(rectF);
            float fA4 = this.f2621Q.g.a(rectF);
            e3.p pVar = this.f2621Q;
            com.stepos.statsrpk.d dVar = pVar.f4369a;
            com.stepos.statsrpk.d dVar2 = pVar.b;
            com.stepos.statsrpk.d dVar3 = pVar.d;
            com.stepos.statsrpk.d dVar4 = pVar.c;
            C1417f c1417f = new C1417f(0);
            C1417f c1417f2 = new C1417f(0);
            C1417f c1417f3 = new C1417f(0);
            C1417f c1417f4 = new C1417f(0);
            e3.o.b(dVar2);
            e3.o.b(dVar);
            e3.o.b(dVar4);
            e3.o.b(dVar3);
            C1412a c1412a = new C1412a(fA2);
            C1412a c1412a2 = new C1412a(fA);
            C1412a c1412a3 = new C1412a(fA4);
            C1412a c1412a4 = new C1412a(fA3);
            e3.p pVar2 = new e3.p();
            pVar2.f4369a = dVar2;
            pVar2.b = dVar;
            pVar2.c = dVar3;
            pVar2.d = dVar4;
            pVar2.e = c1412a;
            pVar2.f = c1412a2;
            pVar2.g = c1412a4;
            pVar2.h = c1412a3;
            pVar2.i = c1417f;
            pVar2.f4370j = c1417f2;
            pVar2.k = c1417f3;
            pVar2.l = c1417f4;
            this.f2622R = z10;
            setShapeAppearanceModel(pVar2);
        }
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (o()) {
            savedState.error = getError();
        }
        m mVar = this.c;
        savedState.isEndIconChecked = mVar.i != 0 && mVar.g.f2445a;
        return savedState;
    }

    public final void p(Editable editable) {
        ((com.bumptech.glide.load.resource.bitmap.b) this.o).getClass();
        int length = editable != null ? editable.length() : 0;
        boolean z10 = this.n;
        int i = this.m;
        if (i == -1) {
            this.p.setText(String.valueOf(length));
            this.p.setContentDescription(null);
            this.n = false;
        } else {
            this.n = length > i;
            Context context = getContext();
            this.p.setContentDescription(context.getString(this.n ? com.stepos.ability.R.string.character_counter_overflowed_content_description : com.stepos.ability.R.string.character_counter_content_description, Integer.valueOf(length), Integer.valueOf(this.m)));
            if (z10 != this.n) {
                q();
            }
            this.p.setText(BidiFormatter.getInstance().unicodeWrap(getContext().getString(com.stepos.ability.R.string.character_counter_pattern, Integer.valueOf(length), Integer.valueOf(this.m))));
        }
        if (this.e == null || z10 == this.n) {
            return;
        }
        w(false, false);
        z();
        t();
    }

    public final void q() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        AppCompatTextView appCompatTextView = this.p;
        if (appCompatTextView != null) {
            n(appCompatTextView, this.n ? this.f2645q : this.f2647r);
            if (!this.n && (colorStateList2 = this.f2659z) != null) {
                this.p.setTextColor(colorStateList2);
            }
            if (!this.n || (colorStateList = this.f2603A) == null) {
                return;
            }
            this.p.setTextColor(colorStateList);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0012  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void r() {
        /*
            r4 = this;
            android.content.res.ColorStateList r0 = r4.f2605B
            if (r0 == 0) goto L5
            goto L25
        L5:
            android.content.Context r0 = r4.getContext()
            int r1 = androidx.appcompat.R.attr.colorControlActivated
            android.util.TypedValue r1 = c3.AbstractC0872b.a(r1, r0)
            r2 = 0
            if (r1 != 0) goto L14
        L12:
            r0 = r2
            goto L25
        L14:
            int r3 = r1.resourceId
            if (r3 == 0) goto L1d
            android.content.res.ColorStateList r0 = androidx.core.content.ContextCompat.getColorStateList(r0, r3)
            goto L25
        L1d:
            int r0 = r1.data
            if (r0 == 0) goto L12
            android.content.res.ColorStateList r0 = android.content.res.ColorStateList.valueOf(r0)
        L25:
            android.widget.EditText r1 = r4.e
            if (r1 == 0) goto L54
            android.graphics.drawable.Drawable r1 = r1.getTextCursorDrawable()
            if (r1 != 0) goto L30
            goto L54
        L30:
            android.widget.EditText r1 = r4.e
            android.graphics.drawable.Drawable r1 = r1.getTextCursorDrawable()
            android.graphics.drawable.Drawable r1 = androidx.core.graphics.drawable.DrawableCompat.wrap(r1)
            android.graphics.drawable.Drawable r1 = r1.mutate()
            boolean r2 = r4.o()
            if (r2 != 0) goto L4c
            androidx.appcompat.widget.AppCompatTextView r2 = r4.p
            if (r2 == 0) goto L51
            boolean r2 = r4.n
            if (r2 == 0) goto L51
        L4c:
            android.content.res.ColorStateList r4 = r4.f2607C
            if (r4 == 0) goto L51
            r0 = r4
        L51:
            r1.setTintList(r0)
        L54:
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

    public void setBoxBackgroundColor(@ColorInt int i) {
        if (this.f2630c0 != i) {
            this.f2630c0 = i;
            this.t0 = i;
            this.f2653v0 = i;
            this.f2655w0 = i;
            c();
        }
    }

    public void setBoxBackgroundColorResource(@ColorRes int i) {
        setBoxBackgroundColor(ContextCompat.getColor(getContext(), i));
    }

    public void setBoxBackgroundColorStateList(@NonNull ColorStateList colorStateList) {
        int defaultColor = colorStateList.getDefaultColor();
        this.t0 = defaultColor;
        this.f2630c0 = defaultColor;
        this.f2651u0 = colorStateList.getColorForState(new int[]{-16842910}, -1);
        this.f2653v0 = colorStateList.getColorForState(new int[]{R.attr.state_focused, R.attr.state_enabled}, -1);
        this.f2655w0 = colorStateList.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, -1);
        c();
    }

    public void setBoxBackgroundMode(int i) {
        if (i == this.f2624T) {
            return;
        }
        this.f2624T = i;
        if (this.e != null) {
            k();
        }
    }

    public void setBoxCollapsedPaddingTop(int i) {
        this.f2625U = i;
    }

    public void setBoxCornerFamily(int i) {
        e3.o oVarF = this.f2621Q.f();
        InterfaceC1415d interfaceC1415d = this.f2621Q.e;
        com.stepos.statsrpk.d dVarX = AbstractC1451a.x(i);
        oVarF.f4367a = dVarX;
        e3.o.b(dVarX);
        oVarF.e = interfaceC1415d;
        InterfaceC1415d interfaceC1415d2 = this.f2621Q.f;
        com.stepos.statsrpk.d dVarX2 = AbstractC1451a.x(i);
        oVarF.b = dVarX2;
        e3.o.b(dVarX2);
        oVarF.f = interfaceC1415d2;
        InterfaceC1415d interfaceC1415d3 = this.f2621Q.h;
        com.stepos.statsrpk.d dVarX3 = AbstractC1451a.x(i);
        oVarF.d = dVarX3;
        e3.o.b(dVarX3);
        oVarF.h = interfaceC1415d3;
        InterfaceC1415d interfaceC1415d4 = this.f2621Q.g;
        com.stepos.statsrpk.d dVarX4 = AbstractC1451a.x(i);
        oVarF.c = dVarX4;
        e3.o.b(dVarX4);
        oVarF.g = interfaceC1415d4;
        this.f2621Q = oVarF.a();
        c();
    }

    public void setBoxStrokeColor(@ColorInt int i) {
        if (this.f2648r0 != i) {
            this.f2648r0 = i;
            z();
        }
    }

    public void setBoxStrokeColorStateList(@NonNull ColorStateList colorStateList) {
        if (colorStateList.isStateful()) {
            this.f2644p0 = colorStateList.getDefaultColor();
            this.f2657x0 = colorStateList.getColorForState(new int[]{-16842910}, -1);
            this.f2646q0 = colorStateList.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, -1);
            this.f2648r0 = colorStateList.getColorForState(new int[]{R.attr.state_focused, R.attr.state_enabled}, -1);
        } else if (this.f2648r0 != colorStateList.getDefaultColor()) {
            this.f2648r0 = colorStateList.getDefaultColor();
        }
        z();
    }

    public void setBoxStrokeErrorColor(@Nullable ColorStateList colorStateList) {
        if (this.s0 != colorStateList) {
            this.s0 = colorStateList;
            z();
        }
    }

    public void setBoxStrokeWidth(int i) {
        this.f2627W = i;
        z();
    }

    public void setBoxStrokeWidthFocused(int i) {
        this.f2629a0 = i;
        z();
    }

    public void setBoxStrokeWidthFocusedResource(@DimenRes int i) {
        setBoxStrokeWidthFocused(getResources().getDimensionPixelSize(i));
    }

    public void setBoxStrokeWidthResource(@DimenRes int i) {
        setBoxStrokeWidth(getResources().getDimensionPixelSize(i));
    }

    public void setCounterEnabled(boolean z10) {
        if (this.l != z10) {
            q qVar = this.k;
            if (z10) {
                AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
                this.p = appCompatTextView;
                appCompatTextView.setId(com.stepos.ability.R.id.textinput_counter);
                Typeface typeface = this.f2634g0;
                if (typeface != null) {
                    this.p.setTypeface(typeface);
                }
                this.p.setMaxLines(1);
                qVar.a(this.p, 2);
                ((ViewGroup.MarginLayoutParams) this.p.getLayoutParams()).setMarginStart(getResources().getDimensionPixelOffset(com.stepos.ability.R.dimen.mtrl_textinput_counter_margin_start));
                q();
                if (this.p != null) {
                    EditText editText = this.e;
                    p(editText != null ? editText.getText() : null);
                }
            } else {
                qVar.g(this.p, 2);
                this.p = null;
            }
            this.l = z10;
        }
    }

    public void setCounterMaxLength(int i) {
        if (this.m != i) {
            if (i > 0) {
                this.m = i;
            } else {
                this.m = -1;
            }
            if (!this.l || this.p == null) {
                return;
            }
            EditText editText = this.e;
            p(editText == null ? null : editText.getText());
        }
    }

    public void setCounterOverflowTextAppearance(int i) {
        if (this.f2645q != i) {
            this.f2645q = i;
            q();
        }
    }

    public void setCounterOverflowTextColor(@Nullable ColorStateList colorStateList) {
        if (this.f2603A != colorStateList) {
            this.f2603A = colorStateList;
            q();
        }
    }

    public void setCounterTextAppearance(int i) {
        if (this.f2647r != i) {
            this.f2647r = i;
            q();
        }
    }

    public void setCounterTextColor(@Nullable ColorStateList colorStateList) {
        if (this.f2659z != colorStateList) {
            this.f2659z = colorStateList;
            q();
        }
    }

    @RequiresApi(29)
    public void setCursorColor(@Nullable ColorStateList colorStateList) {
        if (this.f2605B != colorStateList) {
            this.f2605B = colorStateList;
            r();
        }
    }

    @RequiresApi(29)
    public void setCursorErrorColor(@Nullable ColorStateList colorStateList) {
        if (this.f2607C != colorStateList) {
            this.f2607C = colorStateList;
            if (o() || (this.p != null && this.n)) {
                r();
            }
        }
    }

    public void setDefaultHintTextColor(@Nullable ColorStateList colorStateList) {
        this.f2642n0 = colorStateList;
        this.f2643o0 = colorStateList;
        if (this.e != null) {
            w(false, false);
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z10) {
        m(this, z10);
        super.setEnabled(z10);
    }

    public void setEndIconActivated(boolean z10) {
        this.c.g.setActivated(z10);
    }

    public void setEndIconCheckable(boolean z10) {
        this.c.g.setCheckable(z10);
    }

    public void setEndIconContentDescription(@StringRes int i) {
        m mVar = this.c;
        CharSequence text = i != 0 ? mVar.getResources().getText(i) : null;
        CheckableImageButton checkableImageButton = mVar.g;
        if (checkableImageButton.getContentDescription() != text) {
            checkableImageButton.setContentDescription(text);
        }
    }

    public void setEndIconDrawable(@DrawableRes int i) {
        m mVar = this.c;
        Drawable drawable = i != 0 ? AppCompatResources.getDrawable(mVar.getContext(), i) : null;
        TextInputLayout textInputLayout = mVar.f2675a;
        CheckableImageButton checkableImageButton = mVar.g;
        checkableImageButton.setImageDrawable(drawable);
        if (drawable != null) {
            AbstractC0897f.m(textInputLayout, checkableImageButton, mVar.k, mVar.l);
            AbstractC0897f.I(textInputLayout, checkableImageButton, mVar.k);
        }
    }

    public void setEndIconMinSize(@IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT) int i) {
        m mVar = this.c;
        if (i < 0) {
            mVar.getClass();
            throw new IllegalArgumentException("endIconSize cannot be less than 0");
        }
        if (i != mVar.m) {
            mVar.m = i;
            CheckableImageButton checkableImageButton = mVar.g;
            checkableImageButton.setMinimumWidth(i);
            checkableImageButton.setMinimumHeight(i);
            CheckableImageButton checkableImageButton2 = mVar.c;
            checkableImageButton2.setMinimumWidth(i);
            checkableImageButton2.setMinimumHeight(i);
        }
    }

    public void setEndIconMode(int i) {
        this.c.g(i);
    }

    public void setEndIconOnClickListener(@Nullable View.OnClickListener onClickListener) {
        m mVar = this.c;
        CheckableImageButton checkableImageButton = mVar.g;
        View.OnLongClickListener onLongClickListener = mVar.o;
        checkableImageButton.setOnClickListener(onClickListener);
        AbstractC0897f.J(checkableImageButton, onLongClickListener);
    }

    public void setEndIconOnLongClickListener(@Nullable View.OnLongClickListener onLongClickListener) {
        m mVar = this.c;
        mVar.o = onLongClickListener;
        CheckableImageButton checkableImageButton = mVar.g;
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        AbstractC0897f.J(checkableImageButton, onLongClickListener);
    }

    public void setEndIconScaleType(@NonNull ImageView.ScaleType scaleType) {
        m mVar = this.c;
        mVar.n = scaleType;
        mVar.g.setScaleType(scaleType);
        mVar.c.setScaleType(scaleType);
    }

    public void setEndIconTintList(@Nullable ColorStateList colorStateList) {
        m mVar = this.c;
        if (mVar.k != colorStateList) {
            mVar.k = colorStateList;
            AbstractC0897f.m(mVar.f2675a, mVar.g, colorStateList, mVar.l);
        }
    }

    public void setEndIconTintMode(@Nullable PorterDuff.Mode mode) {
        m mVar = this.c;
        if (mVar.l != mode) {
            mVar.l = mode;
            AbstractC0897f.m(mVar.f2675a, mVar.g, mVar.k, mode);
        }
    }

    public void setEndIconVisible(boolean z10) {
        this.c.h(z10);
    }

    public void setError(@Nullable CharSequence charSequence) {
        q qVar = this.k;
        if (!qVar.f2689q) {
            if (TextUtils.isEmpty(charSequence)) {
                return;
            } else {
                setErrorEnabled(true);
            }
        }
        if (TextUtils.isEmpty(charSequence)) {
            qVar.f();
            return;
        }
        qVar.c();
        qVar.p = charSequence;
        qVar.f2690r.setText(charSequence);
        int i = qVar.n;
        if (i != 1) {
            qVar.o = 1;
        }
        qVar.i(i, qVar.o, qVar.h(qVar.f2690r, charSequence));
    }

    public void setErrorAccessibilityLiveRegion(int i) {
        q qVar = this.k;
        qVar.f2692t = i;
        AppCompatTextView appCompatTextView = qVar.f2690r;
        if (appCompatTextView != null) {
            appCompatTextView.setAccessibilityLiveRegion(i);
        }
    }

    public void setErrorContentDescription(@Nullable CharSequence charSequence) {
        q qVar = this.k;
        qVar.f2691s = charSequence;
        AppCompatTextView appCompatTextView = qVar.f2690r;
        if (appCompatTextView != null) {
            appCompatTextView.setContentDescription(charSequence);
        }
    }

    public void setErrorEnabled(boolean z10) {
        q qVar = this.k;
        TextInputLayout textInputLayout = qVar.h;
        if (qVar.f2689q == z10) {
            return;
        }
        qVar.c();
        if (z10) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(qVar.g);
            qVar.f2690r = appCompatTextView;
            appCompatTextView.setId(com.stepos.ability.R.id.textinput_error);
            qVar.f2690r.setTextAlignment(5);
            Typeface typeface = qVar.f2686B;
            if (typeface != null) {
                qVar.f2690r.setTypeface(typeface);
            }
            int i = qVar.u;
            qVar.u = i;
            AppCompatTextView appCompatTextView2 = qVar.f2690r;
            if (appCompatTextView2 != null) {
                qVar.h.n(appCompatTextView2, i);
            }
            ColorStateList colorStateList = qVar.f2693v;
            qVar.f2693v = colorStateList;
            AppCompatTextView appCompatTextView3 = qVar.f2690r;
            if (appCompatTextView3 != null && colorStateList != null) {
                appCompatTextView3.setTextColor(colorStateList);
            }
            CharSequence charSequence = qVar.f2691s;
            qVar.f2691s = charSequence;
            AppCompatTextView appCompatTextView4 = qVar.f2690r;
            if (appCompatTextView4 != null) {
                appCompatTextView4.setContentDescription(charSequence);
            }
            int i6 = qVar.f2692t;
            qVar.f2692t = i6;
            AppCompatTextView appCompatTextView5 = qVar.f2690r;
            if (appCompatTextView5 != null) {
                appCompatTextView5.setAccessibilityLiveRegion(i6);
            }
            qVar.f2690r.setVisibility(4);
            qVar.a(qVar.f2690r, 0);
        } else {
            qVar.f();
            qVar.g(qVar.f2690r, 0);
            qVar.f2690r = null;
            textInputLayout.t();
            textInputLayout.z();
        }
        qVar.f2689q = z10;
    }

    public void setErrorIconDrawable(@DrawableRes int i) {
        m mVar = this.c;
        mVar.i(i != 0 ? AppCompatResources.getDrawable(mVar.getContext(), i) : null);
        AbstractC0897f.I(mVar.f2675a, mVar.c, mVar.d);
    }

    public void setErrorIconOnClickListener(@Nullable View.OnClickListener onClickListener) {
        m mVar = this.c;
        CheckableImageButton checkableImageButton = mVar.c;
        View.OnLongClickListener onLongClickListener = mVar.f;
        checkableImageButton.setOnClickListener(onClickListener);
        AbstractC0897f.J(checkableImageButton, onLongClickListener);
    }

    public void setErrorIconOnLongClickListener(@Nullable View.OnLongClickListener onLongClickListener) {
        m mVar = this.c;
        mVar.f = onLongClickListener;
        CheckableImageButton checkableImageButton = mVar.c;
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        AbstractC0897f.J(checkableImageButton, onLongClickListener);
    }

    public void setErrorIconTintList(@Nullable ColorStateList colorStateList) {
        m mVar = this.c;
        if (mVar.d != colorStateList) {
            mVar.d = colorStateList;
            AbstractC0897f.m(mVar.f2675a, mVar.c, colorStateList, mVar.e);
        }
    }

    public void setErrorIconTintMode(@Nullable PorterDuff.Mode mode) {
        m mVar = this.c;
        if (mVar.e != mode) {
            mVar.e = mode;
            AbstractC0897f.m(mVar.f2675a, mVar.c, mVar.d, mode);
        }
    }

    public void setErrorTextAppearance(@StyleRes int i) {
        q qVar = this.k;
        qVar.u = i;
        AppCompatTextView appCompatTextView = qVar.f2690r;
        if (appCompatTextView != null) {
            qVar.h.n(appCompatTextView, i);
        }
    }

    public void setErrorTextColor(@Nullable ColorStateList colorStateList) {
        q qVar = this.k;
        qVar.f2693v = colorStateList;
        AppCompatTextView appCompatTextView = qVar.f2690r;
        if (appCompatTextView == null || colorStateList == null) {
            return;
        }
        appCompatTextView.setTextColor(colorStateList);
    }

    public void setExpandedHintEnabled(boolean z10) {
        if (this.f2606B0 != z10) {
            this.f2606B0 = z10;
            w(false, false);
        }
    }

    public void setHelperText(@Nullable CharSequence charSequence) {
        boolean zIsEmpty = TextUtils.isEmpty(charSequence);
        q qVar = this.k;
        if (zIsEmpty) {
            if (qVar.f2695x) {
                setHelperTextEnabled(false);
                return;
            }
            return;
        }
        if (!qVar.f2695x) {
            setHelperTextEnabled(true);
        }
        qVar.c();
        qVar.f2694w = charSequence;
        qVar.y.setText(charSequence);
        int i = qVar.n;
        if (i != 2) {
            qVar.o = 2;
        }
        qVar.i(i, qVar.o, qVar.h(qVar.y, charSequence));
    }

    public void setHelperTextColor(@Nullable ColorStateList colorStateList) {
        q qVar = this.k;
        qVar.f2685A = colorStateList;
        AppCompatTextView appCompatTextView = qVar.y;
        if (appCompatTextView == null || colorStateList == null) {
            return;
        }
        appCompatTextView.setTextColor(colorStateList);
    }

    public void setHelperTextEnabled(boolean z10) {
        q qVar = this.k;
        TextInputLayout textInputLayout = qVar.h;
        if (qVar.f2695x == z10) {
            return;
        }
        qVar.c();
        if (z10) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(qVar.g);
            qVar.y = appCompatTextView;
            appCompatTextView.setId(com.stepos.ability.R.id.textinput_helper_text);
            qVar.y.setTextAlignment(5);
            Typeface typeface = qVar.f2686B;
            if (typeface != null) {
                qVar.y.setTypeface(typeface);
            }
            qVar.y.setVisibility(4);
            qVar.y.setAccessibilityLiveRegion(1);
            int i = qVar.f2696z;
            qVar.f2696z = i;
            AppCompatTextView appCompatTextView2 = qVar.y;
            if (appCompatTextView2 != null) {
                TextViewCompat.setTextAppearance(appCompatTextView2, i);
            }
            ColorStateList colorStateList = qVar.f2685A;
            qVar.f2685A = colorStateList;
            AppCompatTextView appCompatTextView3 = qVar.y;
            if (appCompatTextView3 != null && colorStateList != null) {
                appCompatTextView3.setTextColor(colorStateList);
            }
            qVar.a(qVar.y, 1);
            qVar.y.setAccessibilityDelegate(new p(qVar));
        } else {
            qVar.c();
            int i6 = qVar.n;
            if (i6 == 2) {
                qVar.o = 0;
            }
            qVar.i(i6, qVar.o, qVar.h(qVar.y, ""));
            qVar.g(qVar.y, 1);
            qVar.y = null;
            textInputLayout.t();
            textInputLayout.z();
        }
        qVar.f2695x = z10;
    }

    public void setHelperTextTextAppearance(@StyleRes int i) {
        q qVar = this.k;
        qVar.f2696z = i;
        AppCompatTextView appCompatTextView = qVar.y;
        if (appCompatTextView != null) {
            TextViewCompat.setTextAppearance(appCompatTextView, i);
        }
    }

    public void setHint(@Nullable CharSequence charSequence) {
        if (this.f2609D) {
            setHintInternal(charSequence);
            sendAccessibilityEvent(2048);
        }
    }

    public void setHintAnimationEnabled(boolean z10) {
        this.f2608C0 = z10;
    }

    public void setHintEnabled(boolean z10) {
        if (z10 != this.f2609D) {
            this.f2609D = z10;
            if (z10) {
                CharSequence hint = this.e.getHint();
                if (!TextUtils.isEmpty(hint)) {
                    if (TextUtils.isEmpty(this.E)) {
                        setHint(hint);
                    }
                    this.e.setHint((CharSequence) null);
                }
                this.f2612F = true;
            } else {
                this.f2612F = false;
                if (!TextUtils.isEmpty(this.E) && TextUtils.isEmpty(this.e.getHint())) {
                    this.e.setHint(this.E);
                }
                setHintInternal(null);
            }
            if (this.e != null) {
                v();
            }
        }
    }

    public void setHintMaxLines(int i) {
        com.google.android.material.internal.c cVar = this.f2604A0;
        if (i != cVar.f2482f0) {
            cVar.f2482f0 = i;
            cVar.j(false);
        }
        if (i != cVar.f2481e0) {
            cVar.f2481e0 = i;
            cVar.j(false);
        }
        requestLayout();
    }

    public void setHintTextAppearance(@StyleRes int i) {
        com.google.android.material.internal.c cVar = this.f2604A0;
        TextInputLayout textInputLayout = cVar.f2477a;
        C0876f c0876f = new C0876f(textInputLayout.getContext(), i);
        ColorStateList colorStateList = c0876f.k;
        if (colorStateList != null) {
            cVar.k = colorStateList;
        }
        float f = c0876f.l;
        if (f != 0.0f) {
            cVar.i = f;
        }
        ColorStateList colorStateList2 = c0876f.f2087a;
        if (colorStateList2 != null) {
            cVar.f2472V = colorStateList2;
        }
        cVar.f2470T = c0876f.f;
        cVar.f2471U = c0876f.g;
        cVar.f2469S = c0876f.h;
        cVar.f2473W = c0876f.f2088j;
        C0871a c0871a = cVar.f2496z;
        if (c0871a != null) {
            c0871a.c = true;
        }
        C2054a c2054a = new C2054a(cVar);
        c0876f.a();
        cVar.f2496z = new C0871a(c2054a, c0876f.p);
        c0876f.b(textInputLayout.getContext(), cVar.f2496z);
        cVar.j(false);
        this.f2643o0 = cVar.k;
        if (this.e != null) {
            w(false, false);
            v();
        }
    }

    public void setHintTextColor(@Nullable ColorStateList colorStateList) {
        if (this.f2643o0 != colorStateList) {
            if (this.f2642n0 == null) {
                com.google.android.material.internal.c cVar = this.f2604A0;
                if (cVar.k != colorStateList) {
                    cVar.k = colorStateList;
                    cVar.j(false);
                }
            }
            this.f2643o0 = colorStateList;
            if (this.e != null) {
                w(false, false);
            }
        }
    }

    public void setLengthCounter(@NonNull x xVar) {
        this.o = xVar;
    }

    public void setMaxEms(int i) {
        this.h = i;
        EditText editText = this.e;
        if (editText == null || i == -1) {
            return;
        }
        editText.setMaxEms(i);
    }

    public void setMaxWidth(@Px int i) {
        this.f2637j = i;
        EditText editText = this.e;
        if (editText == null || i == -1) {
            return;
        }
        editText.setMaxWidth(i);
    }

    public void setMaxWidthResource(@DimenRes int i) {
        setMaxWidth(getContext().getResources().getDimensionPixelSize(i));
    }

    public void setMinEms(int i) {
        this.g = i;
        EditText editText = this.e;
        if (editText == null || i == -1) {
            return;
        }
        editText.setMinEms(i);
    }

    public void setMinWidth(@Px int i) {
        this.i = i;
        EditText editText = this.e;
        if (editText == null || i == -1) {
            return;
        }
        editText.setMinWidth(i);
    }

    public void setMinWidthResource(@DimenRes int i) {
        setMinWidth(getContext().getResources().getDimensionPixelSize(i));
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(@StringRes int i) {
        m mVar = this.c;
        mVar.g.setContentDescription(i != 0 ? mVar.getResources().getText(i) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(@DrawableRes int i) {
        m mVar = this.c;
        mVar.g.setImageDrawable(i != 0 ? AppCompatResources.getDrawable(mVar.getContext(), i) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleEnabled(boolean z10) {
        m mVar = this.c;
        if (z10 && mVar.i != 1) {
            mVar.g(1);
        } else if (z10) {
            mVar.getClass();
        } else {
            mVar.g(0);
        }
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintList(@Nullable ColorStateList colorStateList) {
        m mVar = this.c;
        mVar.k = colorStateList;
        AbstractC0897f.m(mVar.f2675a, mVar.g, colorStateList, mVar.l);
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintMode(@Nullable PorterDuff.Mode mode) {
        m mVar = this.c;
        mVar.l = mode;
        AbstractC0897f.m(mVar.f2675a, mVar.g, mVar.k, mode);
    }

    public void setPlaceholderText(@Nullable CharSequence charSequence) {
        if (this.u == null) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
            this.u = appCompatTextView;
            appCompatTextView.setId(com.stepos.ability.R.id.textinput_placeholder);
            this.u.setImportantForAccessibility(1);
            this.u.setAccessibilityLiveRegion(1);
            Fade fadeF = f();
            this.f2656x = fadeF;
            fadeF.setStartDelay(67L);
            this.y = f();
            setPlaceholderTextAppearance(this.f2654w);
            setPlaceholderTextColor(this.f2652v);
            ViewCompat.setAccessibilityDelegate(this.u, new C0914q(3));
        }
        if (TextUtils.isEmpty(charSequence)) {
            setPlaceholderTextEnabled(false);
        } else {
            if (!this.f2650t) {
                setPlaceholderTextEnabled(true);
            }
            this.f2649s = charSequence;
        }
        EditText editText = this.e;
        x(editText == null ? null : editText.getText());
    }

    public void setPlaceholderTextAppearance(@StyleRes int i) {
        this.f2654w = i;
        AppCompatTextView appCompatTextView = this.u;
        if (appCompatTextView != null) {
            TextViewCompat.setTextAppearance(appCompatTextView, i);
        }
    }

    public void setPlaceholderTextColor(@Nullable ColorStateList colorStateList) {
        if (this.f2652v != colorStateList) {
            this.f2652v = colorStateList;
            AppCompatTextView appCompatTextView = this.u;
            if (appCompatTextView == null || colorStateList == null) {
                return;
            }
            appCompatTextView.setTextColor(colorStateList);
        }
    }

    public void setPrefixText(@Nullable CharSequence charSequence) {
        u uVar = this.b;
        uVar.getClass();
        uVar.c = TextUtils.isEmpty(charSequence) ? null : charSequence;
        uVar.b.setText(charSequence);
        uVar.e();
    }

    public void setPrefixTextAppearance(@StyleRes int i) {
        TextViewCompat.setTextAppearance(this.b.b, i);
    }

    public void setPrefixTextColor(@NonNull ColorStateList colorStateList) {
        this.b.b.setTextColor(colorStateList);
    }

    public void setShapeAppearanceModel(@NonNull e3.p pVar) {
        e3.k kVar = this.f2614G;
        if (kVar == null || kVar.b.f4345a == pVar) {
            return;
        }
        this.f2621Q = pVar;
        c();
    }

    public void setStartIconCheckable(boolean z10) {
        this.b.d.setCheckable(z10);
    }

    public void setStartIconContentDescription(@StringRes int i) {
        setStartIconContentDescription(i != 0 ? getResources().getText(i) : null);
    }

    public void setStartIconDrawable(@DrawableRes int i) {
        setStartIconDrawable(i != 0 ? AppCompatResources.getDrawable(getContext(), i) : null);
    }

    public void setStartIconMinSize(@IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT) int i) {
        u uVar = this.b;
        if (i < 0) {
            uVar.getClass();
            throw new IllegalArgumentException("startIconSize cannot be less than 0");
        }
        if (i != uVar.g) {
            uVar.g = i;
            CheckableImageButton checkableImageButton = uVar.d;
            checkableImageButton.setMinimumWidth(i);
            checkableImageButton.setMinimumHeight(i);
        }
    }

    public void setStartIconOnClickListener(@Nullable View.OnClickListener onClickListener) {
        u uVar = this.b;
        CheckableImageButton checkableImageButton = uVar.d;
        View.OnLongClickListener onLongClickListener = uVar.i;
        checkableImageButton.setOnClickListener(onClickListener);
        AbstractC0897f.J(checkableImageButton, onLongClickListener);
    }

    public void setStartIconOnLongClickListener(@Nullable View.OnLongClickListener onLongClickListener) {
        u uVar = this.b;
        uVar.i = onLongClickListener;
        CheckableImageButton checkableImageButton = uVar.d;
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        AbstractC0897f.J(checkableImageButton, onLongClickListener);
    }

    public void setStartIconScaleType(@NonNull ImageView.ScaleType scaleType) {
        u uVar = this.b;
        uVar.h = scaleType;
        uVar.d.setScaleType(scaleType);
    }

    public void setStartIconTintList(@Nullable ColorStateList colorStateList) {
        u uVar = this.b;
        if (uVar.e != colorStateList) {
            uVar.e = colorStateList;
            AbstractC0897f.m(uVar.f2699a, uVar.d, colorStateList, uVar.f);
        }
    }

    public void setStartIconTintMode(@Nullable PorterDuff.Mode mode) {
        u uVar = this.b;
        if (uVar.f != mode) {
            uVar.f = mode;
            AbstractC0897f.m(uVar.f2699a, uVar.d, uVar.e, mode);
        }
    }

    public void setStartIconVisible(boolean z10) {
        this.b.c(z10);
    }

    public void setSuffixText(@Nullable CharSequence charSequence) {
        m mVar = this.c;
        mVar.getClass();
        mVar.p = TextUtils.isEmpty(charSequence) ? null : charSequence;
        mVar.f2677q.setText(charSequence);
        mVar.n();
    }

    public void setSuffixTextAppearance(@StyleRes int i) {
        TextViewCompat.setTextAppearance(this.c.f2677q, i);
    }

    public void setSuffixTextColor(@NonNull ColorStateList colorStateList) {
        this.c.f2677q.setTextColor(colorStateList);
    }

    public void setTextInputAccessibilityDelegate(@Nullable w wVar) {
        EditText editText = this.e;
        if (editText != null) {
            ViewCompat.setAccessibilityDelegate(editText, wVar);
        }
    }

    public void setTypeface(@Nullable Typeface typeface) {
        if (typeface != this.f2634g0) {
            this.f2634g0 = typeface;
            this.f2604A0.n(typeface);
            q qVar = this.k;
            if (typeface != qVar.f2686B) {
                qVar.f2686B = typeface;
                AppCompatTextView appCompatTextView = qVar.f2690r;
                if (appCompatTextView != null) {
                    appCompatTextView.setTypeface(typeface);
                }
                AppCompatTextView appCompatTextView2 = qVar.y;
                if (appCompatTextView2 != null) {
                    appCompatTextView2.setTypeface(typeface);
                }
            }
            AppCompatTextView appCompatTextView3 = this.p;
            if (appCompatTextView3 != null) {
                appCompatTextView3.setTypeface(typeface);
            }
        }
    }

    public final void t() {
        Drawable background;
        AppCompatTextView appCompatTextView;
        EditText editText = this.e;
        if (editText == null || this.f2624T != 0 || (background = editText.getBackground()) == null) {
            return;
        }
        if (DrawableUtils.canSafelyMutateDrawable(background)) {
            background = background.mutate();
        }
        if (o()) {
            background.setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(getErrorCurrentTextColors(), PorterDuff.Mode.SRC_IN));
        } else if (this.n && (appCompatTextView = this.p) != null) {
            background.setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(appCompatTextView.getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
        } else {
            DrawableCompat.clearColorFilter(background);
            this.e.refreshDrawableState();
        }
    }

    public final void u() {
        EditText editText = this.e;
        if (editText == null || this.f2614G == null) {
            return;
        }
        if ((this.f2618N || editText.getBackground() == null) && this.f2624T != 0) {
            this.e.setBackground(getEditTextBoxBackground());
            this.f2618N = true;
        }
    }

    public final void v() {
        if (this.f2624T != 1) {
            FrameLayout frameLayout = this.f2628a;
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) frameLayout.getLayoutParams();
            int iE = e();
            if (iE != layoutParams.topMargin) {
                layoutParams.topMargin = iE;
                frameLayout.requestLayout();
            }
        }
    }

    public final void w(boolean z10, boolean z11) {
        ColorStateList colorStateList;
        AppCompatTextView appCompatTextView;
        boolean zIsEnabled = isEnabled();
        EditText editText = this.e;
        boolean z12 = (editText == null || TextUtils.isEmpty(editText.getText())) ? false : true;
        EditText editText2 = this.e;
        boolean z13 = editText2 != null && editText2.hasFocus();
        ColorStateList colorStateList2 = this.f2642n0;
        com.google.android.material.internal.c cVar = this.f2604A0;
        if (colorStateList2 != null) {
            cVar.k(colorStateList2);
        }
        if (!zIsEnabled) {
            ColorStateList colorStateList3 = this.f2642n0;
            cVar.k(ColorStateList.valueOf(colorStateList3 != null ? colorStateList3.getColorForState(new int[]{-16842910}, this.f2657x0) : this.f2657x0));
        } else if (o()) {
            AppCompatTextView appCompatTextView2 = this.k.f2690r;
            cVar.k(appCompatTextView2 != null ? appCompatTextView2.getTextColors() : null);
        } else if (this.n && (appCompatTextView = this.p) != null) {
            cVar.k(appCompatTextView.getTextColors());
        } else if (z13 && (colorStateList = this.f2643o0) != null && cVar.k != colorStateList) {
            cVar.k = colorStateList;
            cVar.j(false);
        }
        m mVar = this.c;
        u uVar = this.b;
        if (z12 || !this.f2606B0 || (isEnabled() && z13)) {
            if (z11 || this.f2660z0) {
                ValueAnimator valueAnimator = this.f2610D0;
                if (valueAnimator != null && valueAnimator.isRunning()) {
                    this.f2610D0.cancel();
                }
                if (z10 && this.f2608C0) {
                    b(1.0f);
                } else {
                    cVar.m(1.0f);
                }
                this.f2660z0 = false;
                if (g()) {
                    l();
                }
                EditText editText3 = this.e;
                x(editText3 != null ? editText3.getText() : null);
                uVar.f2700j = false;
                uVar.e();
                mVar.f2678r = false;
                mVar.n();
                return;
            }
            return;
        }
        if (z11 || !this.f2660z0) {
            ValueAnimator valueAnimator2 = this.f2610D0;
            if (valueAnimator2 != null && valueAnimator2.isRunning()) {
                this.f2610D0.cancel();
            }
            if (z10 && this.f2608C0) {
                b(0.0f);
            } else {
                cVar.m(0.0f);
            }
            if (g() && !((f) this.f2614G).f2666L.f2664s.isEmpty() && g()) {
                ((f) this.f2614G).A(0.0f, 0.0f, 0.0f, 0.0f);
            }
            this.f2660z0 = true;
            AppCompatTextView appCompatTextView3 = this.u;
            if (appCompatTextView3 != null && this.f2650t) {
                appCompatTextView3.setText((CharSequence) null);
                TransitionManager.beginDelayedTransition(this.f2628a, this.y);
                this.u.setVisibility(4);
            }
            uVar.f2700j = true;
            uVar.e();
            mVar.f2678r = true;
            mVar.n();
        }
    }

    public final void x(Editable editable) {
        ((com.bumptech.glide.load.resource.bitmap.b) this.o).getClass();
        int length = editable != null ? editable.length() : 0;
        FrameLayout frameLayout = this.f2628a;
        if (length != 0 || this.f2660z0) {
            AppCompatTextView appCompatTextView = this.u;
            if (appCompatTextView == null || !this.f2650t) {
                return;
            }
            appCompatTextView.setText((CharSequence) null);
            TransitionManager.beginDelayedTransition(frameLayout, this.y);
            this.u.setVisibility(4);
            return;
        }
        if (this.u == null || !this.f2650t || TextUtils.isEmpty(this.f2649s)) {
            return;
        }
        this.u.setText(this.f2649s);
        TransitionManager.beginDelayedTransition(frameLayout, this.f2656x);
        this.u.setVisibility(0);
        this.u.bringToFront();
    }

    public final void y(boolean z10, boolean z11) {
        int defaultColor = this.s0.getDefaultColor();
        int colorForState = this.s0.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, defaultColor);
        int colorForState2 = this.s0.getColorForState(new int[]{R.attr.state_activated, R.attr.state_enabled}, defaultColor);
        if (z10) {
            this.b0 = colorForState2;
        } else if (z11) {
            this.b0 = colorForState;
        } else {
            this.b0 = defaultColor;
        }
    }

    public final void z() {
        AppCompatTextView appCompatTextView;
        EditText editText;
        EditText editText2;
        if (this.f2614G == null || this.f2624T == 0) {
            return;
        }
        boolean z10 = false;
        boolean z11 = isFocused() || ((editText2 = this.e) != null && editText2.hasFocus());
        if (isHovered() || ((editText = this.e) != null && editText.isHovered())) {
            z10 = true;
        }
        if (!isEnabled()) {
            this.b0 = this.f2657x0;
        } else if (o()) {
            if (this.s0 != null) {
                y(z11, z10);
            } else {
                this.b0 = getErrorCurrentTextColors();
            }
        } else if (!this.n || (appCompatTextView = this.p) == null) {
            if (z11) {
                this.b0 = this.f2648r0;
            } else if (z10) {
                this.b0 = this.f2646q0;
            } else {
                this.b0 = this.f2644p0;
            }
        } else if (this.s0 != null) {
            y(z11, z10);
        } else {
            this.b0 = appCompatTextView.getCurrentTextColor();
        }
        r();
        m mVar = this.c;
        TextInputLayout textInputLayout = mVar.f2675a;
        CheckableImageButton checkableImageButton = mVar.g;
        TextInputLayout textInputLayout2 = mVar.f2675a;
        mVar.l();
        AbstractC0897f.I(textInputLayout2, mVar.c, mVar.d);
        AbstractC0897f.I(textInputLayout2, checkableImageButton, mVar.k);
        if (mVar.b() instanceof j) {
            if (!textInputLayout.o() || checkableImageButton.getDrawable() == null) {
                AbstractC0897f.m(textInputLayout, checkableImageButton, mVar.k, mVar.l);
            } else {
                Drawable drawableMutate = DrawableCompat.wrap(checkableImageButton.getDrawable()).mutate();
                drawableMutate.setTint(textInputLayout.getErrorCurrentTextColors());
                checkableImageButton.setImageDrawable(drawableMutate);
            }
        }
        u uVar = this.b;
        AbstractC0897f.I(uVar.f2699a, uVar.d, uVar.e);
        if (this.f2624T == 2) {
            int i = this.f2626V;
            if (z11 && isEnabled()) {
                this.f2626V = this.f2629a0;
            } else {
                this.f2626V = this.f2627W;
            }
            if (this.f2626V != i && g() && !this.f2660z0) {
                if (g()) {
                    ((f) this.f2614G).A(0.0f, 0.0f, 0.0f, 0.0f);
                }
                l();
            }
        }
        if (this.f2624T == 1) {
            if (!isEnabled()) {
                this.f2630c0 = this.f2651u0;
            } else if (z10 && !z11) {
                this.f2630c0 = this.f2655w0;
            } else if (z11) {
                this.f2630c0 = this.f2653v0;
            } else {
                this.f2630c0 = this.t0;
            }
        }
        c();
    }

    public void setStartIconContentDescription(@Nullable CharSequence charSequence) {
        CheckableImageButton checkableImageButton = this.b.d;
        if (checkableImageButton.getContentDescription() != charSequence) {
            checkableImageButton.setContentDescription(charSequence);
        }
    }

    public void setStartIconDrawable(@Nullable Drawable drawable) {
        this.b.b(drawable);
    }

    public void setHint(@StringRes int i) {
        setHint(i != 0 ? getResources().getText(i) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(@Nullable CharSequence charSequence) {
        this.c.g.setContentDescription(charSequence);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(@Nullable Drawable drawable) {
        this.c.g.setImageDrawable(drawable);
    }

    public void setErrorIconDrawable(@Nullable Drawable drawable) {
        this.c.i(drawable);
    }

    public void setEndIconContentDescription(@Nullable CharSequence charSequence) {
        CheckableImageButton checkableImageButton = this.c.g;
        if (checkableImageButton.getContentDescription() != charSequence) {
            checkableImageButton.setContentDescription(charSequence);
        }
    }

    public void setEndIconDrawable(@Nullable Drawable drawable) {
        m mVar = this.c;
        TextInputLayout textInputLayout = mVar.f2675a;
        CheckableImageButton checkableImageButton = mVar.g;
        checkableImageButton.setImageDrawable(drawable);
        if (drawable != null) {
            AbstractC0897f.m(textInputLayout, checkableImageButton, mVar.k, mVar.l);
            AbstractC0897f.I(textInputLayout, checkableImageButton, mVar.k);
        }
    }
}
