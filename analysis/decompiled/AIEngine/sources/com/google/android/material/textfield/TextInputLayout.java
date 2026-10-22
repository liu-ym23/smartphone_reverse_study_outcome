package com.google.android.material.textfield;

import android.R;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
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
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.LinearInterpolator;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.f0;
import androidx.appcompat.widget.x0;
import androidx.appcompat.widget.z0;
import androidx.customview.view.AbsSavedState;
import androidx.datastore.preferences.protobuf.b1;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.StaticLayoutBuilderCompat;
import com.google.android.material.textfield.e;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Locale;
import t0.c;
import v0.e0;
import y4.g;
import y4.j;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class TextInputLayout extends LinearLayout implements ViewTreeObserver.OnGlobalLayoutListener {
    public static final int[][] G0 = {new int[]{R.attr.state_pressed}, new int[0]};
    public d2.c A;
    public boolean A0;
    public d2.c B;
    public boolean B0;
    public ColorStateList C;
    public ValueAnimator C0;
    public ColorStateList D;
    public boolean D0;
    public ColorStateList E;
    public boolean E0;
    public ColorStateList F;
    public boolean F0;
    public boolean G;
    public CharSequence H;
    public boolean I;
    public y4.g J;
    public y4.g K;
    public StateListDrawable L;
    public boolean M;
    public y4.g N;
    public y4.g O;
    public y4.j P;
    public boolean Q;
    public final int R;
    public int S;
    public int T;
    public int U;
    public int V;
    public int W;

    /* renamed from: a, reason: collision with root package name */
    public final FrameLayout f5183a;

    /* renamed from: a0, reason: collision with root package name */
    public int f5184a0;

    /* renamed from: b, reason: collision with root package name */
    public final t f5185b;
    public int b0;

    /* renamed from: c, reason: collision with root package name */
    public final k f5186c;
    public final Rect c0;

    /* renamed from: d, reason: collision with root package name */
    public final int f5187d;

    /* renamed from: d0, reason: collision with root package name */
    public final Rect f5188d0;

    /* renamed from: e, reason: collision with root package name */
    public EditText f5189e;

    /* renamed from: e0, reason: collision with root package name */
    public final RectF f5190e0;

    /* renamed from: f0, reason: collision with root package name */
    public Typeface f5191f0;

    /* renamed from: g0, reason: collision with root package name */
    public ColorDrawable f5192g0;
    public CharSequence h;

    /* renamed from: h0, reason: collision with root package name */
    public int f5193h0;

    /* renamed from: i0, reason: collision with root package name */
    public final LinkedHashSet<g> f5194i0;

    /* renamed from: j, reason: collision with root package name */
    public int f5195j;

    /* renamed from: j0, reason: collision with root package name */
    public ColorDrawable f5196j0;

    /* renamed from: k, reason: collision with root package name */
    public int f5197k;

    /* renamed from: k0, reason: collision with root package name */
    public int f5198k0;

    /* renamed from: l, reason: collision with root package name */
    public int f5199l;

    /* renamed from: l0, reason: collision with root package name */
    public Drawable f5200l0;

    /* renamed from: m, reason: collision with root package name */
    public int f5201m;

    /* renamed from: m0, reason: collision with root package name */
    public ColorStateList f5202m0;

    /* renamed from: n, reason: collision with root package name */
    public final n f5203n;

    /* renamed from: n0, reason: collision with root package name */
    public ColorStateList f5204n0;

    /* renamed from: o, reason: collision with root package name */
    public boolean f5205o;

    /* renamed from: o0, reason: collision with root package name */
    public int f5206o0;

    /* renamed from: p, reason: collision with root package name */
    public int f5207p;

    /* renamed from: p0, reason: collision with root package name */
    public int f5208p0;

    /* renamed from: q, reason: collision with root package name */
    public boolean f5209q;
    public int q0;
    public f r;

    /* renamed from: r0, reason: collision with root package name */
    public ColorStateList f5210r0;

    /* renamed from: s, reason: collision with root package name */
    public AppCompatTextView f5211s;

    /* renamed from: s0, reason: collision with root package name */
    public int f5212s0;

    /* renamed from: t, reason: collision with root package name */
    public int f5213t;

    /* renamed from: t0, reason: collision with root package name */
    public int f5214t0;

    /* renamed from: u, reason: collision with root package name */
    public int f5215u;

    /* renamed from: u0, reason: collision with root package name */
    public int f5216u0;

    /* renamed from: v, reason: collision with root package name */
    public CharSequence f5217v;

    /* renamed from: v0, reason: collision with root package name */
    public int f5218v0;

    /* renamed from: w, reason: collision with root package name */
    public boolean f5219w;

    /* renamed from: w0, reason: collision with root package name */
    public int f5220w0;

    /* renamed from: x, reason: collision with root package name */
    public AppCompatTextView f5221x;

    /* renamed from: x0, reason: collision with root package name */
    public int f5222x0;

    /* renamed from: y, reason: collision with root package name */
    public ColorStateList f5223y;

    /* renamed from: y0, reason: collision with root package name */
    public boolean f5224y0;
    public int z;
    public final com.google.android.material.internal.b z0;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        CharSequence error;
        boolean isEndIconChecked;

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public class a implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.ClassLoaderCreator
            public final SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public final Object[] newArray(int i10) {
                return new SavedState[i10];
            }

            @Override // android.os.Parcelable.Creator
            public final Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + ((Object) this.error) + "}";
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            TextUtils.writeToParcel(this.error, parcel, i10);
            parcel.writeInt(this.isEndIconChecked ? 1 : 0);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.error = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.isEndIconChecked = parcel.readInt() == 1;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class b extends v0.a {
        @Override // v0.a
        public final void onInitializeAccessibilityNodeInfo(View view, w0.b bVar) {
            super.onInitializeAccessibilityNodeInfo(view, bVar);
            bVar.f13532a.setVisibleToUser(false);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            CheckableImageButton checkableImageButton = TextInputLayout.this.f5186c.f5264j;
            checkableImageButton.performClick();
            checkableImageButton.jumpDrawablesToCurrentState();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class d implements ValueAnimator.AnimatorUpdateListener {
        public d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            TextInputLayout.this.z0.m(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class e extends v0.a {

        /* renamed from: a, reason: collision with root package name */
        public final TextInputLayout f5230a;

        public e(TextInputLayout textInputLayout) {
            this.f5230a = textInputLayout;
        }

        @Override // v0.a
        public final void onInitializeAccessibilityNodeInfo(View view, w0.b bVar) {
            super.onInitializeAccessibilityNodeInfo(view, bVar);
            TextInputLayout textInputLayout = this.f5230a;
            EditText editText = textInputLayout.getEditText();
            CharSequence text = editText != null ? editText.getText() : null;
            CharSequence hint = textInputLayout.getHint();
            CharSequence error = textInputLayout.getError();
            CharSequence placeholderText = textInputLayout.getPlaceholderText();
            int counterMaxLength = textInputLayout.getCounterMaxLength();
            CharSequence counterOverflowDescription = textInputLayout.getCounterOverflowDescription();
            boolean zIsEmpty = TextUtils.isEmpty(text);
            boolean zIsEmpty2 = TextUtils.isEmpty(hint);
            boolean z = textInputLayout.f5224y0;
            boolean zIsEmpty3 = TextUtils.isEmpty(error);
            boolean z3 = (zIsEmpty3 && TextUtils.isEmpty(counterOverflowDescription)) ? false : true;
            String string = !zIsEmpty2 ? hint.toString() : "";
            t tVar = textInputLayout.f5185b;
            AppCompatTextView appCompatTextView = tVar.f5334b;
            if (appCompatTextView.getVisibility() == 0) {
                bVar.f13532a.setLabelFor(appCompatTextView);
                bVar.f13532a.setTraversalAfter(appCompatTextView);
            } else {
                bVar.f13532a.setTraversalAfter(tVar.f5336d);
            }
            if (!zIsEmpty) {
                bVar.m(text);
            } else if (!TextUtils.isEmpty(string)) {
                bVar.m(string);
                if (!z && placeholderText != null) {
                    bVar.m(string + ", " + ((Object) placeholderText));
                }
            } else if (placeholderText != null) {
                bVar.m(placeholderText);
            }
            if (!TextUtils.isEmpty(string)) {
                bVar.f13532a.setHintText(string);
                bVar.f13532a.setShowingHintText(zIsEmpty);
            }
            if (text == null || text.length() != counterMaxLength) {
                counterMaxLength = -1;
            }
            AccessibilityNodeInfo accessibilityNodeInfo = bVar.f13532a;
            AccessibilityNodeInfo accessibilityNodeInfo2 = bVar.f13532a;
            accessibilityNodeInfo.setMaxTextLength(counterMaxLength);
            if (z3) {
                if (zIsEmpty3) {
                    error = counterOverflowDescription;
                }
                accessibilityNodeInfo2.setError(error);
            }
            AppCompatTextView appCompatTextView2 = textInputLayout.f5203n.f5312y;
            if (appCompatTextView2 != null) {
                accessibilityNodeInfo2.setLabelFor(appCompatTextView2);
            }
            textInputLayout.f5186c.b().m(bVar);
        }

        @Override // v0.a
        public final void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onPopulateAccessibilityEvent(view, accessibilityEvent);
            this.f5230a.f5186c.b().n(accessibilityEvent);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface f {
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface g {
        void a(TextInputLayout textInputLayout);
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface h {
        void a();
    }

    public TextInputLayout(Context context, AttributeSet attributeSet) throws Resources.NotFoundException {
        super(b5.a.a(context, attributeSet, com.stepos.aiengine.R.attr.textInputStyle, com.stepos.aiengine.R.style.Widget_Design_TextInputLayout), attributeSet, com.stepos.aiengine.R.attr.textInputStyle);
        this.f5195j = -1;
        this.f5197k = -1;
        this.f5199l = -1;
        this.f5201m = -1;
        this.f5203n = new n(this);
        this.r = new ai.onnxruntime.a(17);
        this.c0 = new Rect();
        this.f5188d0 = new Rect();
        this.f5190e0 = new RectF();
        this.f5194i0 = new LinkedHashSet<>();
        com.google.android.material.internal.b bVar = new com.google.android.material.internal.b(this);
        this.z0 = bVar;
        this.F0 = false;
        Context context2 = getContext();
        setOrientation(1);
        setWillNotDraw(false);
        setAddStatesFromChildren(true);
        FrameLayout frameLayout = new FrameLayout(context2);
        this.f5183a = frameLayout;
        frameLayout.setAddStatesFromChildren(true);
        LinearInterpolator linearInterpolator = l4.a.f10220a;
        bVar.R = linearInterpolator;
        bVar.j(false);
        bVar.Q = linearInterpolator;
        bVar.j(false);
        if (bVar.f5064g != 8388659) {
            bVar.f5064g = 8388659;
            bVar.j(false);
        }
        com.google.android.material.internal.i.a(context2, attributeSet, com.stepos.aiengine.R.attr.textInputStyle, com.stepos.aiengine.R.style.Widget_Design_TextInputLayout);
        int[] iArr = k4.a.I;
        com.google.android.material.internal.i.b(context2, attributeSet, iArr, com.stepos.aiengine.R.attr.textInputStyle, com.stepos.aiengine.R.style.Widget_Design_TextInputLayout, 22, 20, 40, 45, 50);
        TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, iArr, com.stepos.aiengine.R.attr.textInputStyle, com.stepos.aiengine.R.style.Widget_Design_TextInputLayout);
        x0 x0Var = new x0(context2, typedArrayObtainStyledAttributes);
        t tVar = new t(this, x0Var);
        this.f5185b = tVar;
        this.G = typedArrayObtainStyledAttributes.getBoolean(48, true);
        setHint(typedArrayObtainStyledAttributes.getText(4));
        this.B0 = typedArrayObtainStyledAttributes.getBoolean(47, true);
        this.A0 = typedArrayObtainStyledAttributes.getBoolean(42, true);
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
        this.P = y4.j.b(context2, attributeSet, com.stepos.aiengine.R.attr.textInputStyle, com.stepos.aiengine.R.style.Widget_Design_TextInputLayout).a();
        this.R = context2.getResources().getDimensionPixelOffset(com.stepos.aiengine.R.dimen.mtrl_textinput_box_label_cutout_padding);
        this.T = typedArrayObtainStyledAttributes.getDimensionPixelOffset(9, 0);
        this.f5187d = getResources().getDimensionPixelSize(com.stepos.aiengine.R.dimen.m3_multiline_hint_filled_text_extra_space);
        this.V = typedArrayObtainStyledAttributes.getDimensionPixelSize(16, context2.getResources().getDimensionPixelSize(com.stepos.aiengine.R.dimen.mtrl_textinput_box_stroke_width_default));
        this.W = typedArrayObtainStyledAttributes.getDimensionPixelSize(17, context2.getResources().getDimensionPixelSize(com.stepos.aiengine.R.dimen.mtrl_textinput_box_stroke_width_focused));
        this.U = this.V;
        float dimension = typedArrayObtainStyledAttributes.getDimension(13, -1.0f);
        float dimension2 = typedArrayObtainStyledAttributes.getDimension(12, -1.0f);
        float dimension3 = typedArrayObtainStyledAttributes.getDimension(10, -1.0f);
        float dimension4 = typedArrayObtainStyledAttributes.getDimension(11, -1.0f);
        j.a aVarF = this.P.f();
        if (dimension >= 0.0f) {
            aVarF.e(dimension);
        }
        if (dimension2 >= 0.0f) {
            aVarF.f(dimension2);
        }
        if (dimension3 >= 0.0f) {
            aVarF.d(dimension3);
        }
        if (dimension4 >= 0.0f) {
            aVarF.c(dimension4);
        }
        this.P = aVarF.a();
        ColorStateList colorStateListB = w4.c.b(context2, x0Var, 7);
        if (colorStateListB != null) {
            int defaultColor = colorStateListB.getDefaultColor();
            this.f5212s0 = defaultColor;
            this.b0 = defaultColor;
            if (colorStateListB.isStateful()) {
                this.f5214t0 = colorStateListB.getColorForState(new int[]{-16842910}, -1);
                this.f5216u0 = colorStateListB.getColorForState(new int[]{R.attr.state_focused, R.attr.state_enabled}, -1);
                this.f5218v0 = colorStateListB.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, -1);
            } else {
                this.f5216u0 = this.f5212s0;
                ColorStateList colorStateListB2 = androidx.core.content.a.b(com.stepos.aiengine.R.color.mtrl_filled_background_color, context2);
                this.f5214t0 = colorStateListB2.getColorForState(new int[]{-16842910}, -1);
                this.f5218v0 = colorStateListB2.getColorForState(new int[]{R.attr.state_hovered}, -1);
            }
        } else {
            this.b0 = 0;
            this.f5212s0 = 0;
            this.f5214t0 = 0;
            this.f5216u0 = 0;
            this.f5218v0 = 0;
        }
        if (typedArrayObtainStyledAttributes.hasValue(1)) {
            ColorStateList colorStateListA = x0Var.a(1);
            this.f5204n0 = colorStateListA;
            this.f5202m0 = colorStateListA;
        }
        ColorStateList colorStateListB3 = w4.c.b(context2, x0Var, 14);
        this.q0 = typedArrayObtainStyledAttributes.getColor(14, 0);
        this.f5206o0 = context2.getColor(com.stepos.aiengine.R.color.mtrl_textinput_default_box_stroke_color);
        this.f5220w0 = context2.getColor(com.stepos.aiengine.R.color.mtrl_textinput_disabled_color);
        this.f5208p0 = context2.getColor(com.stepos.aiengine.R.color.mtrl_textinput_hovered_box_stroke_color);
        if (colorStateListB3 != null) {
            setBoxStrokeColorStateList(colorStateListB3);
        }
        if (typedArrayObtainStyledAttributes.hasValue(15)) {
            setBoxStrokeErrorColor(w4.c.b(context2, x0Var, 15));
        }
        if (typedArrayObtainStyledAttributes.getResourceId(50, -1) != -1) {
            setHintTextAppearance(typedArrayObtainStyledAttributes.getResourceId(50, 0));
        }
        this.E = x0Var.a(24);
        this.F = x0Var.a(25);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(40, 0);
        CharSequence text = typedArrayObtainStyledAttributes.getText(35);
        int i10 = typedArrayObtainStyledAttributes.getInt(34, 1);
        boolean z = typedArrayObtainStyledAttributes.getBoolean(36, false);
        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(45, 0);
        boolean z3 = typedArrayObtainStyledAttributes.getBoolean(44, false);
        CharSequence text2 = typedArrayObtainStyledAttributes.getText(43);
        int resourceId3 = typedArrayObtainStyledAttributes.getResourceId(58, 0);
        CharSequence text3 = typedArrayObtainStyledAttributes.getText(57);
        boolean z10 = typedArrayObtainStyledAttributes.getBoolean(18, false);
        setCounterMaxLength(typedArrayObtainStyledAttributes.getInt(19, -1));
        this.f5215u = typedArrayObtainStyledAttributes.getResourceId(22, 0);
        this.f5213t = typedArrayObtainStyledAttributes.getResourceId(20, 0);
        setBoxBackgroundMode(typedArrayObtainStyledAttributes.getInt(8, 0));
        setErrorContentDescription(text);
        setErrorAccessibilityLiveRegion(i10);
        setCounterOverflowTextAppearance(this.f5213t);
        setHelperTextTextAppearance(resourceId2);
        setErrorTextAppearance(resourceId);
        setCounterTextAppearance(this.f5215u);
        setPlaceholderText(text3);
        setPlaceholderTextAppearance(resourceId3);
        if (typedArrayObtainStyledAttributes.hasValue(41)) {
            setErrorTextColor(x0Var.a(41));
        }
        if (typedArrayObtainStyledAttributes.hasValue(46)) {
            setHelperTextColor(x0Var.a(46));
        }
        if (typedArrayObtainStyledAttributes.hasValue(51)) {
            setHintTextColor(x0Var.a(51));
        }
        if (typedArrayObtainStyledAttributes.hasValue(23)) {
            setCounterTextColor(x0Var.a(23));
        }
        if (typedArrayObtainStyledAttributes.hasValue(21)) {
            setCounterOverflowTextColor(x0Var.a(21));
        }
        if (typedArrayObtainStyledAttributes.hasValue(59)) {
            setPlaceholderTextColor(x0Var.a(59));
        }
        k kVar = new k(this, x0Var);
        this.f5186c = kVar;
        boolean z11 = typedArrayObtainStyledAttributes.getBoolean(0, true);
        setHintMaxLines(typedArrayObtainStyledAttributes.getInt(49, 1));
        x0Var.f();
        setImportantForAccessibility(2);
        setImportantForAutofill(1);
        frameLayout.addView(tVar);
        frameLayout.addView(kVar);
        addView(frameLayout);
        setEnabled(z11);
        setHelperTextEnabled(z3);
        setErrorEnabled(z);
        setCounterEnabled(z10);
        setHelperText(text2);
    }

    private Drawable getEditTextBoxBackground() {
        EditText editText = this.f5189e;
        if (!(editText instanceof AutoCompleteTextView) || editText.getInputType() != 0) {
            return this.J;
        }
        int iS = jd.b.s(com.stepos.aiengine.R.attr.colorControlHighlight, this.f5189e);
        int i10 = this.S;
        int[][] iArr = G0;
        if (i10 != 2) {
            if (i10 != 1) {
                return null;
            }
            y4.g gVar = this.J;
            int i11 = this.b0;
            return new RippleDrawable(new ColorStateList(iArr, new int[]{jd.b.C(0.1f, iS, i11), i11}), gVar, gVar);
        }
        Context context = getContext();
        y4.g gVar2 = this.J;
        TypedValue typedValueC = w4.b.c(context, "TextInputLayout", com.stepos.aiengine.R.attr.colorSurface);
        int i12 = typedValueC.resourceId;
        int color = i12 != 0 ? context.getColor(i12) : typedValueC.data;
        y4.g gVar3 = new y4.g(gVar2.f14023b.f14044a);
        int iC = jd.b.C(0.1f, iS, color);
        gVar3.n(new ColorStateList(iArr, new int[]{iC, 0}));
        gVar3.setTint(color);
        ColorStateList colorStateList = new ColorStateList(iArr, new int[]{iC, color});
        y4.g gVar4 = new y4.g(gVar2.f14023b.f14044a);
        gVar4.setTint(-1);
        return new LayerDrawable(new Drawable[]{new RippleDrawable(colorStateList, gVar3, gVar4), gVar2});
    }

    private Drawable getOrCreateFilledDropDownMenuBackground() {
        if (this.L == null) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            this.L = stateListDrawable;
            stateListDrawable.addState(new int[]{R.attr.state_above_anchor}, getOrCreateOutlinedDropDownMenuBackground());
            this.L.addState(new int[0], h(false));
        }
        return this.L;
    }

    private Drawable getOrCreateOutlinedDropDownMenuBackground() {
        if (this.K == null) {
            this.K = h(true);
        }
        return this.K;
    }

    public static void m(ViewGroup viewGroup, boolean z) {
        int childCount = viewGroup.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = viewGroup.getChildAt(i10);
            childAt.setEnabled(z);
            if (childAt instanceof ViewGroup) {
                m((ViewGroup) childAt, z);
            }
        }
    }

    private void setEditText(EditText editText) throws Resources.NotFoundException {
        if (this.f5189e != null) {
            throw new IllegalArgumentException("We already have an EditText, can only have one");
        }
        if (getEndIconMode() != 3 && !(editText instanceof TextInputEditText)) {
            Log.i("TextInputLayout", "EditText added is not a TextInputEditText. Please switch to using that class instead.");
        }
        this.f5189e = editText;
        int i10 = this.f5195j;
        if (i10 != -1) {
            setMinEms(i10);
        } else {
            setMinWidth(this.f5199l);
        }
        int i11 = this.f5197k;
        if (i11 != -1) {
            setMaxEms(i11);
        } else {
            setMaxWidth(this.f5201m);
        }
        this.M = false;
        k();
        setTextInputAccessibilityDelegate(new e(this));
        Typeface typeface = this.f5189e.getTypeface();
        com.google.android.material.internal.b bVar = this.z0;
        bVar.n(typeface);
        float textSize = this.f5189e.getTextSize();
        if (bVar.h != textSize) {
            bVar.h = textSize;
            bVar.j(false);
        }
        float letterSpacing = this.f5189e.getLetterSpacing();
        if (bVar.X != letterSpacing) {
            bVar.X = letterSpacing;
            bVar.j(false);
        }
        int gravity = this.f5189e.getGravity();
        int i12 = (gravity & (-113)) | 48;
        if (bVar.f5064g != i12) {
            bVar.f5064g = i12;
            bVar.j(false);
        }
        if (bVar.f5062f != gravity) {
            bVar.f5062f = gravity;
            bVar.j(false);
        }
        this.f5222x0 = editText.getMinimumHeight();
        this.f5189e.addTextChangedListener(new a(editText));
        if (this.f5202m0 == null) {
            this.f5202m0 = this.f5189e.getHintTextColors();
        }
        if (this.G) {
            if (TextUtils.isEmpty(this.H)) {
                CharSequence hint = this.f5189e.getHint();
                this.h = hint;
                setHint(hint);
                this.f5189e.setHint((CharSequence) null);
            }
            this.I = true;
        }
        r();
        if (this.f5211s != null) {
            p(this.f5189e.getText());
        }
        t();
        this.f5203n.b();
        this.f5185b.bringToFront();
        k kVar = this.f5186c;
        kVar.bringToFront();
        Iterator<g> it = this.f5194i0.iterator();
        while (it.hasNext()) {
            it.next().a(this);
        }
        kVar.m();
        if (!isEnabled()) {
            editText.setEnabled(false);
        }
        w(false, true);
    }

    private void setHintInternal(CharSequence charSequence) {
        if (TextUtils.equals(charSequence, this.H)) {
            return;
        }
        this.H = charSequence;
        com.google.android.material.internal.b bVar = this.z0;
        if (charSequence == null || !TextUtils.equals(bVar.B, charSequence)) {
            bVar.B = charSequence;
            bVar.C = null;
            bVar.j(false);
        }
        if (this.f5224y0) {
            return;
        }
        l();
    }

    private void setPlaceholderTextEnabled(boolean z) {
        if (this.f5219w == z) {
            return;
        }
        if (z) {
            AppCompatTextView appCompatTextView = this.f5221x;
            if (appCompatTextView != null) {
                this.f5183a.addView(appCompatTextView);
                this.f5221x.setVisibility(0);
            }
        } else {
            AppCompatTextView appCompatTextView2 = this.f5221x;
            if (appCompatTextView2 != null) {
                appCompatTextView2.setVisibility(8);
            }
            this.f5221x = null;
        }
        this.f5219w = z;
    }

    public final void a() {
        if (this.f5189e == null || this.S != 1) {
            return;
        }
        if (getHintMaxLines() != 1) {
            EditText editText = this.f5189e;
            editText.setPaddingRelative(editText.getPaddingStart(), (int) (this.z0.f() + this.f5187d), this.f5189e.getPaddingEnd(), getResources().getDimensionPixelSize(com.stepos.aiengine.R.dimen.material_filled_edittext_font_1_3_padding_bottom));
        } else if (getContext().getResources().getConfiguration().fontScale >= 2.0f) {
            EditText editText2 = this.f5189e;
            editText2.setPaddingRelative(editText2.getPaddingStart(), getResources().getDimensionPixelSize(com.stepos.aiengine.R.dimen.material_filled_edittext_font_2_0_padding_top), this.f5189e.getPaddingEnd(), getResources().getDimensionPixelSize(com.stepos.aiengine.R.dimen.material_filled_edittext_font_2_0_padding_bottom));
        } else if (w4.c.d(getContext())) {
            EditText editText3 = this.f5189e;
            editText3.setPaddingRelative(editText3.getPaddingStart(), getResources().getDimensionPixelSize(com.stepos.aiengine.R.dimen.material_filled_edittext_font_1_3_padding_top), this.f5189e.getPaddingEnd(), getResources().getDimensionPixelSize(com.stepos.aiengine.R.dimen.material_filled_edittext_font_1_3_padding_bottom));
        }
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) throws Resources.NotFoundException {
        if (!(view instanceof EditText)) {
            super.addView(view, i10, layoutParams);
            return;
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams);
        layoutParams2.gravity = (layoutParams2.gravity & (-113)) | 16;
        FrameLayout frameLayout = this.f5183a;
        frameLayout.addView(view, layoutParams2);
        frameLayout.setLayoutParams(layoutParams);
        v();
        setEditText((EditText) view);
    }

    public final void b(float f8) {
        com.google.android.material.internal.b bVar = this.z0;
        if (bVar.f5056b == f8) {
            return;
        }
        if (this.C0 == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.C0 = valueAnimator;
            valueAnimator.setInterpolator(u4.j.d(getContext(), com.stepos.aiengine.R.attr.motionEasingEmphasizedInterpolator, l4.a.f10221b));
            this.C0.setDuration(u4.j.c(getContext(), com.stepos.aiengine.R.attr.motionDurationMedium4, 167));
            this.C0.addUpdateListener(new d());
        }
        this.C0.setFloatValues(bVar.f5056b, f8);
        this.C0.start();
    }

    public final void c() {
        int i10;
        int i11;
        y4.g gVar = this.J;
        if (gVar == null) {
            return;
        }
        y4.j jVar = gVar.f14023b.f14044a;
        y4.j jVar2 = this.P;
        if (jVar != jVar2) {
            gVar.setShapeAppearanceModel(jVar2);
        }
        if (this.S == 2 && (i10 = this.U) > -1 && (i11 = this.f5184a0) != 0) {
            y4.g gVar2 = this.J;
            gVar2.f14023b.f14053k = i10;
            gVar2.invalidateSelf();
            ColorStateList colorStateListValueOf = ColorStateList.valueOf(i11);
            g.c cVar = gVar2.f14023b;
            if (cVar.f14048e != colorStateListValueOf) {
                cVar.f14048e = colorStateListValueOf;
                gVar2.onStateChange(gVar2.getState());
            }
        }
        int iB = this.b0;
        if (this.S == 1) {
            Integer numT = jd.b.t(com.stepos.aiengine.R.attr.colorSurface, getContext());
            iB = n0.a.b(this.b0, numT != null ? numT.intValue() : 0);
        }
        this.b0 = iB;
        this.J.n(ColorStateList.valueOf(iB));
        y4.g gVar3 = this.N;
        if (gVar3 != null && this.O != null) {
            if (this.U > -1 && this.f5184a0 != 0) {
                gVar3.n(this.f5189e.isFocused() ? ColorStateList.valueOf(this.f5206o0) : ColorStateList.valueOf(this.f5184a0));
                this.O.n(ColorStateList.valueOf(this.f5184a0));
            }
            invalidate();
        }
        u();
    }

    public final Rect d(Rect rect) {
        if (this.f5189e == null) {
            throw new IllegalStateException();
        }
        boolean z = getLayoutDirection() == 1;
        int i10 = rect.bottom;
        Rect rect2 = this.f5188d0;
        rect2.bottom = i10;
        int i11 = this.S;
        if (i11 == 1) {
            rect2.left = i(rect.left, z);
            rect2.top = rect.top + this.T;
            rect2.right = j(rect.right, z);
            return rect2;
        }
        if (i11 != 2) {
            rect2.left = i(rect.left, z);
            rect2.top = getPaddingTop();
            rect2.right = j(rect.right, z);
            return rect2;
        }
        rect2.left = this.f5189e.getPaddingLeft() + rect.left;
        rect2.top = rect.top - e();
        rect2.right = rect.right - this.f5189e.getPaddingRight();
        return rect2;
    }

    @Override // android.view.ViewGroup, android.view.View
    @TargetApi(26)
    public final void dispatchProvideAutofillStructure(ViewStructure viewStructure, int i10) {
        EditText editText = this.f5189e;
        if (editText == null) {
            super.dispatchProvideAutofillStructure(viewStructure, i10);
            return;
        }
        if (this.h != null) {
            boolean z = this.I;
            this.I = false;
            CharSequence hint = editText.getHint();
            this.f5189e.setHint(this.h);
            try {
                super.dispatchProvideAutofillStructure(viewStructure, i10);
                return;
            } finally {
                this.f5189e.setHint(hint);
                this.I = z;
            }
        }
        viewStructure.setAutofillId(getAutofillId());
        onProvideAutofillStructure(viewStructure, i10);
        onProvideAutofillVirtualStructure(viewStructure, i10);
        FrameLayout frameLayout = this.f5183a;
        viewStructure.setChildCount(frameLayout.getChildCount());
        for (int i11 = 0; i11 < frameLayout.getChildCount(); i11++) {
            View childAt = frameLayout.getChildAt(i11);
            ViewStructure viewStructureNewChild = viewStructure.newChild(i11);
            childAt.dispatchProvideAutofillStructure(viewStructureNewChild, i10);
            if (childAt == this.f5189e) {
                viewStructureNewChild.setHint(getHint());
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        this.E0 = true;
        super.dispatchRestoreInstanceState(sparseArray);
        this.E0 = false;
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        y4.g gVar;
        Canvas canvas2 = canvas;
        super.draw(canvas);
        boolean z = this.G;
        com.google.android.material.internal.b bVar = this.z0;
        if (z) {
            TextPaint textPaint = bVar.O;
            RectF rectF = bVar.f5060e;
            int iSave = canvas2.save();
            if (bVar.C != null && rectF.width() > 0.0f && rectF.height() > 0.0f) {
                textPaint.setTextSize(bVar.G);
                float f8 = bVar.f5078q;
                float f9 = bVar.r;
                float f10 = bVar.F;
                if (f10 != 1.0f) {
                    canvas2.scale(f10, f10, f8, f9);
                }
                if ((bVar.f5061e0 > 1 || bVar.f5063f0 > 1) && !bVar.D && bVar.o()) {
                    float lineStart = bVar.f5078q - bVar.Z.getLineStart(0);
                    int alpha = textPaint.getAlpha();
                    canvas2.translate(lineStart, f9);
                    float f11 = alpha;
                    textPaint.setAlpha((int) (bVar.c0 * f11));
                    int i10 = Build.VERSION.SDK_INT;
                    if (i10 >= 31) {
                        float f12 = bVar.H;
                        float f13 = bVar.I;
                        float f14 = bVar.J;
                        int i11 = bVar.K;
                        textPaint.setShadowLayer(f12, f13, f14, n0.a.d(i11, (textPaint.getAlpha() * Color.alpha(i11)) / 255));
                    }
                    bVar.Z.draw(canvas2);
                    textPaint.setAlpha((int) (bVar.b0 * f11));
                    if (i10 >= 31) {
                        float f15 = bVar.H;
                        float f16 = bVar.I;
                        float f17 = bVar.J;
                        int i12 = bVar.K;
                        textPaint.setShadowLayer(f15, f16, f17, n0.a.d(i12, (Color.alpha(i12) * textPaint.getAlpha()) / 255));
                    }
                    int lineBaseline = bVar.Z.getLineBaseline(0);
                    CharSequence charSequence = bVar.f5059d0;
                    float f18 = lineBaseline;
                    canvas2.drawText(charSequence, 0, charSequence.length(), 0.0f, f18, textPaint);
                    if (i10 >= 31) {
                        textPaint.setShadowLayer(bVar.H, bVar.I, bVar.J, bVar.K);
                    }
                    String strTrim = bVar.f5059d0.toString().trim();
                    if (strTrim.endsWith("…")) {
                        strTrim = strTrim.substring(0, strTrim.length() - 1);
                    }
                    String str = strTrim;
                    textPaint.setAlpha(alpha);
                    canvas2 = canvas;
                    canvas2.drawText(str, 0, Math.min(bVar.Z.getLineEnd(0), str.length()), 0.0f, f18, (Paint) textPaint);
                } else {
                    canvas2.translate(f8, f9);
                    bVar.Z.draw(canvas2);
                }
                canvas2.restoreToCount(iSave);
            }
        }
        if (this.O == null || (gVar = this.N) == null) {
            return;
        }
        gVar.draw(canvas2);
        if (this.f5189e.isFocused()) {
            Rect bounds = this.O.getBounds();
            Rect bounds2 = this.N.getBounds();
            float f19 = bVar.f5056b;
            int iCenterX = bounds2.centerX();
            bounds.left = l4.a.c(f19, iCenterX, bounds2.left);
            bounds.right = l4.a.c(f19, iCenterX, bounds2.right);
            this.O.draw(canvas2);
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
            boolean r0 = r4.D0
            if (r0 == 0) goto L5
            return
        L5:
            r0 = 1
            r4.D0 = r0
            super.drawableStateChanged()
            int[] r1 = r4.getDrawableState()
            r2 = 0
            com.google.android.material.internal.b r3 = r4.z0
            if (r3 == 0) goto L2f
            r3.M = r1
            android.content.res.ColorStateList r1 = r3.f5071k
            if (r1 == 0) goto L20
            boolean r1 = r1.isStateful()
            if (r1 != 0) goto L2a
        L20:
            android.content.res.ColorStateList r1 = r3.f5069j
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
            android.widget.EditText r3 = r4.f5189e
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
            r4.D0 = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.drawableStateChanged():void");
    }

    public final int e() {
        if (this.G) {
            int i10 = this.S;
            com.google.android.material.internal.b bVar = this.z0;
            if (i10 == 0) {
                return (int) bVar.f();
            }
            if (i10 == 2) {
                if (getHintMaxLines() == 1) {
                    return (int) (bVar.f() / 2.0f);
                }
                float f8 = bVar.f();
                TextPaint textPaint = bVar.P;
                textPaint.setTextSize(bVar.f5067i);
                textPaint.setTypeface(bVar.f5079s);
                textPaint.setLetterSpacing(bVar.W);
                return Math.max(0, (int) (f8 - ((-textPaint.ascent()) / 2.0f)));
            }
        }
        return 0;
    }

    public final d2.c f() {
        d2.c cVar = new d2.c();
        cVar.f8284c = u4.j.c(getContext(), com.stepos.aiengine.R.attr.motionDurationShort2, 87);
        cVar.f8285d = u4.j.d(getContext(), com.stepos.aiengine.R.attr.motionEasingLinearInterpolator, l4.a.f10220a);
        return cVar;
    }

    public final boolean g() {
        return this.G && !TextUtils.isEmpty(this.H) && (this.J instanceof com.google.android.material.textfield.e);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public int getBaseline() {
        EditText editText = this.f5189e;
        if (editText == null) {
            return super.getBaseline();
        }
        return e() + getPaddingTop() + editText.getBaseline();
    }

    public y4.g getBoxBackground() {
        int i10 = this.S;
        if (i10 == 1 || i10 == 2) {
            return this.J;
        }
        throw new IllegalStateException();
    }

    public int getBoxBackgroundColor() {
        return this.b0;
    }

    public int getBoxBackgroundMode() {
        return this.S;
    }

    public int getBoxCollapsedPaddingTop() {
        return this.T;
    }

    public float getBoxCornerRadiusBottomEnd() {
        int layoutDirection = getLayoutDirection();
        RectF rectF = this.f5190e0;
        return layoutDirection == 1 ? this.P.h.a(rectF) : this.P.f14068g.a(rectF);
    }

    public float getBoxCornerRadiusBottomStart() {
        int layoutDirection = getLayoutDirection();
        RectF rectF = this.f5190e0;
        return layoutDirection == 1 ? this.P.f14068g.a(rectF) : this.P.h.a(rectF);
    }

    public float getBoxCornerRadiusTopEnd() {
        int layoutDirection = getLayoutDirection();
        RectF rectF = this.f5190e0;
        return layoutDirection == 1 ? this.P.f14066e.a(rectF) : this.P.f14067f.a(rectF);
    }

    public float getBoxCornerRadiusTopStart() {
        int layoutDirection = getLayoutDirection();
        RectF rectF = this.f5190e0;
        return layoutDirection == 1 ? this.P.f14067f.a(rectF) : this.P.f14066e.a(rectF);
    }

    public int getBoxStrokeColor() {
        return this.q0;
    }

    public ColorStateList getBoxStrokeErrorColor() {
        return this.f5210r0;
    }

    public int getBoxStrokeWidth() {
        return this.V;
    }

    public int getBoxStrokeWidthFocused() {
        return this.W;
    }

    public int getCounterMaxLength() {
        return this.f5207p;
    }

    public CharSequence getCounterOverflowDescription() {
        AppCompatTextView appCompatTextView;
        if (this.f5205o && this.f5209q && (appCompatTextView = this.f5211s) != null) {
            return appCompatTextView.getContentDescription();
        }
        return null;
    }

    public ColorStateList getCounterOverflowTextColor() {
        return this.D;
    }

    public ColorStateList getCounterTextColor() {
        return this.C;
    }

    public ColorStateList getCursorColor() {
        return this.E;
    }

    public ColorStateList getCursorErrorColor() {
        return this.F;
    }

    public ColorStateList getDefaultHintTextColor() {
        return this.f5202m0;
    }

    public EditText getEditText() {
        return this.f5189e;
    }

    public CharSequence getEndIconContentDescription() {
        return this.f5186c.f5264j.getContentDescription();
    }

    public Drawable getEndIconDrawable() {
        return this.f5186c.f5264j.getDrawable();
    }

    public int getEndIconMinSize() {
        return this.f5186c.f5270p;
    }

    public int getEndIconMode() {
        return this.f5186c.f5266l;
    }

    public ImageView.ScaleType getEndIconScaleType() {
        return this.f5186c.f5271q;
    }

    public CheckableImageButton getEndIconView() {
        return this.f5186c.f5264j;
    }

    public CharSequence getError() {
        n nVar = this.f5203n;
        if (nVar.f5305q) {
            return nVar.f5304p;
        }
        return null;
    }

    public int getErrorAccessibilityLiveRegion() {
        return this.f5203n.f5307t;
    }

    public CharSequence getErrorContentDescription() {
        return this.f5203n.f5306s;
    }

    public int getErrorCurrentTextColors() {
        AppCompatTextView appCompatTextView = this.f5203n.r;
        if (appCompatTextView != null) {
            return appCompatTextView.getCurrentTextColor();
        }
        return -1;
    }

    public Drawable getErrorIconDrawable() {
        return this.f5186c.f5261c.getDrawable();
    }

    public CharSequence getHelperText() {
        n nVar = this.f5203n;
        if (nVar.f5311x) {
            return nVar.f5310w;
        }
        return null;
    }

    public int getHelperTextCurrentTextColor() {
        AppCompatTextView appCompatTextView = this.f5203n.f5312y;
        if (appCompatTextView != null) {
            return appCompatTextView.getCurrentTextColor();
        }
        return -1;
    }

    public CharSequence getHint() {
        if (this.G) {
            return this.H;
        }
        return null;
    }

    public final float getHintCollapsedTextHeight() {
        return this.z0.f();
    }

    public final int getHintCurrentCollapsedTextColor() {
        com.google.android.material.internal.b bVar = this.z0;
        return bVar.g(bVar.f5071k);
    }

    public int getHintMaxLines() {
        return this.z0.f5061e0;
    }

    public ColorStateList getHintTextColor() {
        return this.f5204n0;
    }

    public f getLengthCounter() {
        return this.r;
    }

    public int getMaxEms() {
        return this.f5197k;
    }

    public int getMaxWidth() {
        return this.f5201m;
    }

    public int getMinEms() {
        return this.f5195j;
    }

    public int getMinWidth() {
        return this.f5199l;
    }

    @Deprecated
    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.f5186c.f5264j.getContentDescription();
    }

    @Deprecated
    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.f5186c.f5264j.getDrawable();
    }

    public CharSequence getPlaceholderText() {
        if (this.f5219w) {
            return this.f5217v;
        }
        return null;
    }

    public int getPlaceholderTextAppearance() {
        return this.z;
    }

    public ColorStateList getPlaceholderTextColor() {
        return this.f5223y;
    }

    public CharSequence getPrefixText() {
        return this.f5185b.f5335c;
    }

    public ColorStateList getPrefixTextColor() {
        return this.f5185b.f5334b.getTextColors();
    }

    public TextView getPrefixTextView() {
        return this.f5185b.f5334b;
    }

    public y4.j getShapeAppearanceModel() {
        return this.P;
    }

    public CharSequence getStartIconContentDescription() {
        return this.f5185b.f5336d.getContentDescription();
    }

    public Drawable getStartIconDrawable() {
        return this.f5185b.f5336d.getDrawable();
    }

    public int getStartIconMinSize() {
        return this.f5185b.f5338j;
    }

    public ImageView.ScaleType getStartIconScaleType() {
        return this.f5185b.f5339k;
    }

    public CharSequence getSuffixText() {
        return this.f5186c.f5272s;
    }

    public ColorStateList getSuffixTextColor() {
        return this.f5186c.f5273t.getTextColors();
    }

    public TextView getSuffixTextView() {
        return this.f5186c.f5273t;
    }

    public Typeface getTypeface() {
        return this.f5191f0;
    }

    public final y4.g h(boolean z) throws Resources.NotFoundException {
        float dimensionPixelOffset = getResources().getDimensionPixelOffset(com.stepos.aiengine.R.dimen.mtrl_shape_corner_size_small_component);
        float f8 = z ? dimensionPixelOffset : 0.0f;
        EditText editText = this.f5189e;
        float popupElevation = editText instanceof q ? ((q) editText).getPopupElevation() : getResources().getDimensionPixelOffset(com.stepos.aiengine.R.dimen.m3_comp_outlined_autocomplete_menu_container_elevation);
        int dimensionPixelOffset2 = getResources().getDimensionPixelOffset(com.stepos.aiengine.R.dimen.mtrl_exposed_dropdown_menu_popup_vertical_padding);
        y4.i iVar = new y4.i();
        y4.i iVar2 = new y4.i();
        y4.i iVar3 = new y4.i();
        y4.i iVar4 = new y4.i();
        y4.f fVar = new y4.f();
        y4.f fVar2 = new y4.f();
        y4.f fVar3 = new y4.f();
        y4.f fVar4 = new y4.f();
        y4.a aVar = new y4.a(f8);
        y4.a aVar2 = new y4.a(f8);
        y4.a aVar3 = new y4.a(dimensionPixelOffset);
        y4.a aVar4 = new y4.a(dimensionPixelOffset);
        y4.j jVar = new y4.j();
        jVar.f14062a = iVar;
        jVar.f14063b = iVar2;
        jVar.f14064c = iVar3;
        jVar.f14065d = iVar4;
        jVar.f14066e = aVar;
        jVar.f14067f = aVar2;
        jVar.f14068g = aVar4;
        jVar.h = aVar3;
        jVar.f14069i = fVar;
        jVar.f14070j = fVar2;
        jVar.f14071k = fVar3;
        jVar.f14072l = fVar4;
        EditText editText2 = this.f5189e;
        ColorStateList dropDownBackgroundTintList = editText2 instanceof q ? ((q) editText2).getDropDownBackgroundTintList() : null;
        Context context = getContext();
        if (dropDownBackgroundTintList == null) {
            g.e[] eVarArr = y4.g.G;
            TypedValue typedValueC = w4.b.c(context, y4.g.class.getSimpleName(), com.stepos.aiengine.R.attr.colorSurface);
            int i10 = typedValueC.resourceId;
            dropDownBackgroundTintList = ColorStateList.valueOf(i10 != 0 ? context.getColor(i10) : typedValueC.data);
        }
        y4.g gVar = new y4.g();
        gVar.k(context);
        gVar.n(dropDownBackgroundTintList);
        gVar.m(popupElevation);
        gVar.setShapeAppearanceModel(jVar);
        g.c cVar = gVar.f14023b;
        if (cVar.h == null) {
            cVar.h = new Rect();
        }
        gVar.f14023b.h.set(0, dimensionPixelOffset2, 0, dimensionPixelOffset2);
        gVar.invalidateSelf();
        return gVar;
    }

    public final int i(int i10, boolean z) {
        return ((z || getPrefixText() == null) ? (!z || getSuffixText() == null) ? this.f5189e.getCompoundPaddingLeft() : this.f5186c.c() : this.f5185b.a()) + i10;
    }

    public final int j(int i10, boolean z) {
        return i10 - ((z || getSuffixText() == null) ? (!z || getPrefixText() == null) ? this.f5189e.getCompoundPaddingRight() : this.f5185b.a() : this.f5186c.c());
    }

    public final void k() throws Resources.NotFoundException {
        int i10 = this.S;
        if (i10 == 0) {
            this.J = null;
            this.N = null;
            this.O = null;
        } else if (i10 == 1) {
            this.J = new y4.g(this.P);
            this.N = new y4.g();
            this.O = new y4.g();
        } else {
            if (i10 != 2) {
                throw new IllegalArgumentException(ai.onnxruntime.a.j(" is illegal; only @BoxBackgroundMode constants are supported.", this.S, new StringBuilder()));
            }
            if (!this.G || (this.J instanceof com.google.android.material.textfield.e)) {
                this.J = new y4.g(this.P);
            } else {
                y4.j jVar = this.P;
                int i11 = com.google.android.material.textfield.e.I;
                if (jVar == null) {
                    jVar = new y4.j();
                }
                e.a aVar = new e.a(jVar, new RectF());
                e.b bVar = new e.b(aVar);
                bVar.H = aVar;
                this.J = bVar;
            }
            this.N = null;
            this.O = null;
        }
        u();
        z();
        if (this.S == 1) {
            if (getContext().getResources().getConfiguration().fontScale >= 2.0f) {
                this.T = getResources().getDimensionPixelSize(com.stepos.aiengine.R.dimen.material_font_2_0_box_collapsed_padding_top);
            } else if (w4.c.d(getContext())) {
                this.T = getResources().getDimensionPixelSize(com.stepos.aiengine.R.dimen.material_font_1_3_box_collapsed_padding_top);
            }
        }
        a();
        if (this.S != 0) {
            v();
        }
        EditText editText = this.f5189e;
        if (editText instanceof AutoCompleteTextView) {
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) editText;
            if (autoCompleteTextView.getDropDownBackground() == null) {
                int i12 = this.S;
                if (i12 == 2) {
                    autoCompleteTextView.setDropDownBackgroundDrawable(getOrCreateOutlinedDropDownMenuBackground());
                } else if (i12 == 1) {
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

    public final void n(AppCompatTextView appCompatTextView, int i10) {
        try {
            appCompatTextView.setTextAppearance(i10);
            if (appCompatTextView.getTextColors().getDefaultColor() != -65281) {
                return;
            }
        } catch (Exception unused) {
        }
        appCompatTextView.setTextAppearance(com.stepos.aiengine.R.style.TextAppearance_AppCompat_Caption);
        appCompatTextView.setTextColor(getContext().getColor(com.stepos.aiengine.R.color.design_error));
    }

    public final boolean o() {
        n nVar = this.f5203n;
        return (nVar.f5303o != 1 || nVar.r == null || TextUtils.isEmpty(nVar.f5304p)) ? false : true;
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.z0.i(configuration);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        int iMax;
        k kVar = this.f5186c;
        kVar.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        boolean z = false;
        this.F0 = false;
        if (this.f5189e != null && this.f5189e.getMeasuredHeight() < (iMax = Math.max(kVar.getMeasuredHeight(), this.f5185b.getMeasuredHeight()))) {
            this.f5189e.setMinimumHeight(iMax);
            z = true;
        }
        boolean zS = s();
        if (z || zS) {
            this.f5189e.post(new z0(this, 10));
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i10, int i11, int i12, int i13) {
        float fDescent;
        int i14;
        int compoundPaddingTop;
        super.onLayout(z, i10, i11, i12, i13);
        EditText editText = this.f5189e;
        if (editText != null) {
            Rect rect = this.c0;
            com.google.android.material.internal.c.a(this, editText, rect);
            y4.g gVar = this.N;
            if (gVar != null) {
                int i15 = rect.bottom;
                gVar.setBounds(rect.left, i15 - this.V, rect.right, i15);
            }
            y4.g gVar2 = this.O;
            if (gVar2 != null) {
                int i16 = rect.bottom;
                gVar2.setBounds(rect.left, i16 - this.W, rect.right, i16);
            }
            if (this.G) {
                float textSize = this.f5189e.getTextSize();
                com.google.android.material.internal.b bVar = this.z0;
                float f8 = bVar.h;
                TextPaint textPaint = bVar.P;
                if (f8 != textSize) {
                    bVar.h = textSize;
                    bVar.j(false);
                }
                int gravity = this.f5189e.getGravity();
                int i17 = (gravity & (-113)) | 48;
                if (bVar.f5064g != i17) {
                    bVar.f5064g = i17;
                    bVar.j(false);
                }
                if (bVar.f5062f != gravity) {
                    bVar.f5062f = gravity;
                    bVar.j(false);
                }
                Rect rectD = d(rect);
                int i18 = rectD.left;
                int i19 = rectD.top;
                int i20 = rectD.right;
                int i21 = rectD.bottom;
                Rect rect2 = bVar.f5058d;
                if (rect2.left != i18 || rect2.top != i19 || rect2.right != i20 || rect2.bottom != i21) {
                    rect2.set(i18, i19, i20, i21);
                    bVar.N = true;
                }
                if (this.f5189e == null) {
                    throw new IllegalStateException();
                }
                if (getHintMaxLines() == 1) {
                    textPaint.setTextSize(bVar.h);
                    textPaint.setTypeface(bVar.f5082v);
                    textPaint.setLetterSpacing(bVar.X);
                    fDescent = -textPaint.ascent();
                } else {
                    textPaint.setTextSize(bVar.h);
                    textPaint.setTypeface(bVar.f5082v);
                    textPaint.setLetterSpacing(bVar.X);
                    fDescent = bVar.f5073l * (textPaint.descent() + (-textPaint.ascent()));
                }
                int compoundPaddingLeft = this.f5189e.getCompoundPaddingLeft() + rect.left;
                Rect rect3 = this.f5188d0;
                rect3.left = compoundPaddingLeft;
                if (this.S != 1 || this.f5189e.getMinLines() > 1) {
                    if (this.S != 0 || getHintMaxLines() == 1) {
                        i14 = 0;
                    } else {
                        textPaint.setTextSize(bVar.h);
                        textPaint.setTypeface(bVar.f5082v);
                        textPaint.setLetterSpacing(bVar.X);
                        i14 = (int) ((-textPaint.ascent()) / 2.0f);
                    }
                    compoundPaddingTop = (this.f5189e.getCompoundPaddingTop() + rect.top) - i14;
                } else {
                    compoundPaddingTop = (int) (rect.centerY() - (fDescent / 2.0f));
                }
                rect3.top = compoundPaddingTop;
                rect3.right = rect.right - this.f5189e.getCompoundPaddingRight();
                int compoundPaddingBottom = (this.S != 1 || this.f5189e.getMinLines() > 1) ? rect.bottom - this.f5189e.getCompoundPaddingBottom() : (int) (rect3.top + fDescent);
                rect3.bottom = compoundPaddingBottom;
                int i22 = rect3.left;
                int i23 = rect3.top;
                int i24 = rect3.right;
                Rect rect4 = bVar.f5057c;
                if (rect4.left != i22 || rect4.top != i23 || rect4.right != i24 || rect4.bottom != compoundPaddingBottom || true != bVar.f5072k0) {
                    rect4.set(i22, i23, i24, compoundPaddingBottom);
                    bVar.N = true;
                    bVar.f5072k0 = true;
                }
                bVar.j(false);
                if (!g() || this.f5224y0) {
                    return;
                }
                l();
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i10, int i11) {
        float f8;
        EditText editText;
        super.onMeasure(i10, i11);
        boolean z = this.F0;
        k kVar = this.f5186c;
        if (!z) {
            kVar.getViewTreeObserver().addOnGlobalLayoutListener(this);
            this.F0 = true;
        }
        if (this.f5221x != null && (editText = this.f5189e) != null) {
            this.f5221x.setGravity(editText.getGravity());
            this.f5221x.setPadding(this.f5189e.getCompoundPaddingLeft(), this.f5189e.getCompoundPaddingTop(), this.f5189e.getCompoundPaddingRight(), this.f5189e.getCompoundPaddingBottom());
        }
        kVar.m();
        if (getHintMaxLines() == 1) {
            return;
        }
        int measuredWidth = (this.f5189e.getMeasuredWidth() - this.f5189e.getCompoundPaddingLeft()) - this.f5189e.getCompoundPaddingRight();
        com.google.android.material.internal.b bVar = this.z0;
        TextPaint textPaint = bVar.P;
        textPaint.setTextSize(bVar.f5067i);
        textPaint.setTypeface(bVar.f5079s);
        textPaint.setLetterSpacing(bVar.W);
        float f9 = measuredWidth;
        bVar.f5068i0 = bVar.e(bVar.f5063f0, textPaint, bVar.B, (bVar.f5067i / bVar.h) * f9, bVar.D).getHeight();
        textPaint.setTextSize(bVar.h);
        textPaint.setTypeface(bVar.f5082v);
        textPaint.setLetterSpacing(bVar.X);
        bVar.f5070j0 = bVar.e(bVar.f5061e0, textPaint, bVar.B, f9, bVar.D).getHeight();
        EditText editText2 = this.f5189e;
        Rect rect = this.c0;
        com.google.android.material.internal.c.a(this, editText2, rect);
        Rect rectD = d(rect);
        int i12 = rectD.left;
        int i13 = rectD.top;
        int i14 = rectD.right;
        int i15 = rectD.bottom;
        Rect rect2 = bVar.f5058d;
        if (rect2.left != i12 || rect2.top != i13 || rect2.right != i14 || rect2.bottom != i15) {
            rect2.set(i12, i13, i14, i15);
            bVar.N = true;
        }
        v();
        a();
        if (this.f5189e == null) {
            return;
        }
        int i16 = bVar.f5070j0;
        if (i16 != -1) {
            f8 = i16;
        } else {
            TextPaint textPaint2 = bVar.P;
            textPaint2.setTextSize(bVar.h);
            textPaint2.setTypeface(bVar.f5082v);
            textPaint2.setLetterSpacing(bVar.X);
            f8 = -textPaint2.ascent();
        }
        if (this.f5217v != null) {
            TextPaint textPaint3 = new TextPaint(129);
            textPaint3.set(this.f5221x.getPaint());
            textPaint3.setTextSize(this.f5221x.getTextSize());
            textPaint3.setTypeface(this.f5221x.getTypeface());
            textPaint3.setLetterSpacing(this.f5221x.getLetterSpacing());
            StaticLayoutBuilderCompat staticLayoutBuilderCompat = new StaticLayoutBuilderCompat(this.f5217v, textPaint3, measuredWidth);
            staticLayoutBuilderCompat.f5049k = getLayoutDirection() == 1;
            staticLayoutBuilderCompat.f5048j = true;
            float lineSpacingExtra = this.f5221x.getLineSpacingExtra();
            float lineSpacingMultiplier = this.f5221x.getLineSpacingMultiplier();
            staticLayoutBuilderCompat.f5046g = lineSpacingExtra;
            staticLayoutBuilderCompat.h = lineSpacingMultiplier;
            staticLayoutBuilderCompat.f5051m = new com.google.android.material.button.a(this);
            f = (this.S == 1 ? bVar.f() + this.T + this.f5187d : 0.0f) + staticLayoutBuilderCompat.a().getHeight();
        }
        float fMax = Math.max(f8, f);
        if (this.f5189e.getMeasuredHeight() < fMax) {
            this.f5189e.setMinimumHeight(Math.round(fMax));
        }
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) throws Resources.NotFoundException {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setError(savedState.error);
        if (savedState.isEndIconChecked) {
            post(new c());
        }
        requestLayout();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onRtlPropertiesChanged(int i10) {
        super.onRtlPropertiesChanged(i10);
        boolean z = i10 == 1;
        if (z != this.Q) {
            y4.d dVar = this.P.f14066e;
            RectF rectF = this.f5190e0;
            float fA = dVar.a(rectF);
            float fA2 = this.P.f14067f.a(rectF);
            float fA3 = this.P.h.a(rectF);
            float fA4 = this.P.f14068g.a(rectF);
            y4.j jVar = this.P;
            xb.a aVar = jVar.f14062a;
            xb.a aVar2 = jVar.f14063b;
            xb.a aVar3 = jVar.f14065d;
            xb.a aVar4 = jVar.f14064c;
            new y4.i();
            new y4.i();
            new y4.i();
            new y4.i();
            y4.f fVar = new y4.f();
            y4.f fVar2 = new y4.f();
            y4.f fVar3 = new y4.f();
            y4.f fVar4 = new y4.f();
            y4.a aVar5 = new y4.a(fA2);
            y4.a aVar6 = new y4.a(fA);
            y4.a aVar7 = new y4.a(fA4);
            y4.a aVar8 = new y4.a(fA3);
            y4.j jVar2 = new y4.j();
            jVar2.f14062a = aVar2;
            jVar2.f14063b = aVar;
            jVar2.f14064c = aVar3;
            jVar2.f14065d = aVar4;
            jVar2.f14066e = aVar5;
            jVar2.f14067f = aVar6;
            jVar2.f14068g = aVar8;
            jVar2.h = aVar7;
            jVar2.f14069i = fVar;
            jVar2.f14070j = fVar2;
            jVar2.f14071k = fVar3;
            jVar2.f14072l = fVar4;
            this.Q = z;
            setShapeAppearanceModel(jVar2);
        }
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (o()) {
            savedState.error = getError();
        }
        k kVar = this.f5186c;
        savedState.isEndIconChecked = kVar.f5266l != 0 && kVar.f5264j.f5035d;
        return savedState;
    }

    public final void p(Editable editable) throws Resources.NotFoundException {
        ((ai.onnxruntime.a) this.r).getClass();
        int length = editable != null ? editable.length() : 0;
        boolean z = this.f5209q;
        int i10 = this.f5207p;
        if (i10 == -1) {
            this.f5211s.setText(String.valueOf(length));
            this.f5211s.setContentDescription(null);
            this.f5209q = false;
        } else {
            this.f5209q = length > i10;
            Context context = getContext();
            this.f5211s.setContentDescription(context.getString(this.f5209q ? com.stepos.aiengine.R.string.character_counter_overflowed_content_description : com.stepos.aiengine.R.string.character_counter_content_description, Integer.valueOf(length), Integer.valueOf(this.f5207p)));
            if (z != this.f5209q) {
                q();
            }
            String str = t0.a.f12898b;
            t0.a aVar = TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1 ? t0.a.f12901e : t0.a.f12900d;
            AppCompatTextView appCompatTextView = this.f5211s;
            String string = getContext().getString(com.stepos.aiengine.R.string.character_counter_pattern, Integer.valueOf(length), Integer.valueOf(this.f5207p));
            aVar.getClass();
            c.d dVar = t0.c.f12912a;
            appCompatTextView.setText(string != null ? aVar.c(string).toString() : null);
        }
        if (this.f5189e == null || z == this.f5209q) {
            return;
        }
        w(false, false);
        z();
        t();
    }

    public final void q() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        AppCompatTextView appCompatTextView = this.f5211s;
        if (appCompatTextView != null) {
            n(appCompatTextView, this.f5209q ? this.f5213t : this.f5215u);
            if (!this.f5209q && (colorStateList2 = this.C) != null) {
                this.f5211s.setTextColor(colorStateList2);
            }
            if (!this.f5209q || (colorStateList = this.D) == null) {
                return;
            }
            this.f5211s.setTextColor(colorStateList);
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
            android.content.res.ColorStateList r0 = r4.E
            if (r0 == 0) goto L5
            goto L26
        L5:
            android.content.Context r0 = r4.getContext()
            r1 = 2130968899(0x7f040143, float:1.7546465E38)
            android.util.TypedValue r1 = w4.b.a(r1, r0)
            r2 = 0
            if (r1 != 0) goto L15
        L13:
            r0 = r2
            goto L26
        L15:
            int r3 = r1.resourceId
            if (r3 == 0) goto L1e
            android.content.res.ColorStateList r0 = androidx.core.content.a.b(r3, r0)
            goto L26
        L1e:
            int r0 = r1.data
            if (r0 == 0) goto L13
            android.content.res.ColorStateList r0 = android.content.res.ColorStateList.valueOf(r0)
        L26:
            android.widget.EditText r1 = r4.f5189e
            if (r1 == 0) goto L51
            android.graphics.drawable.Drawable r1 = r1.getTextCursorDrawable()
            if (r1 != 0) goto L31
            goto L51
        L31:
            android.widget.EditText r1 = r4.f5189e
            android.graphics.drawable.Drawable r1 = r1.getTextCursorDrawable()
            android.graphics.drawable.Drawable r1 = r1.mutate()
            boolean r2 = r4.o()
            if (r2 != 0) goto L49
            androidx.appcompat.widget.AppCompatTextView r2 = r4.f5211s
            if (r2 == 0) goto L4e
            boolean r2 = r4.f5209q
            if (r2 == 0) goto L4e
        L49:
            android.content.res.ColorStateList r4 = r4.F
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

    public void setBoxBackgroundColor(int i10) {
        if (this.b0 != i10) {
            this.b0 = i10;
            this.f5212s0 = i10;
            this.f5216u0 = i10;
            this.f5218v0 = i10;
            c();
        }
    }

    public void setBoxBackgroundColorResource(int i10) {
        setBoxBackgroundColor(getContext().getColor(i10));
    }

    public void setBoxBackgroundColorStateList(ColorStateList colorStateList) {
        int defaultColor = colorStateList.getDefaultColor();
        this.f5212s0 = defaultColor;
        this.b0 = defaultColor;
        this.f5214t0 = colorStateList.getColorForState(new int[]{-16842910}, -1);
        this.f5216u0 = colorStateList.getColorForState(new int[]{R.attr.state_focused, R.attr.state_enabled}, -1);
        this.f5218v0 = colorStateList.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, -1);
        c();
    }

    public void setBoxBackgroundMode(int i10) throws Resources.NotFoundException {
        if (i10 == this.S) {
            return;
        }
        this.S = i10;
        if (this.f5189e != null) {
            k();
        }
    }

    public void setBoxCollapsedPaddingTop(int i10) {
        this.T = i10;
    }

    public void setBoxCornerFamily(int i10) {
        j.a aVarF = this.P.f();
        y4.d dVar = this.P.f14066e;
        aVarF.f14073a = xb.a.b(i10);
        aVarF.f14077e = dVar;
        y4.d dVar2 = this.P.f14067f;
        aVarF.f14074b = xb.a.b(i10);
        aVarF.f14078f = dVar2;
        y4.d dVar3 = this.P.h;
        aVarF.f14076d = xb.a.b(i10);
        aVarF.h = dVar3;
        y4.d dVar4 = this.P.f14068g;
        aVarF.f14075c = xb.a.b(i10);
        aVarF.f14079g = dVar4;
        this.P = aVarF.a();
        c();
    }

    public void setBoxStrokeColor(int i10) throws Resources.NotFoundException {
        if (this.q0 != i10) {
            this.q0 = i10;
            z();
        }
    }

    public void setBoxStrokeColorStateList(ColorStateList colorStateList) throws Resources.NotFoundException {
        if (colorStateList.isStateful()) {
            this.f5206o0 = colorStateList.getDefaultColor();
            this.f5220w0 = colorStateList.getColorForState(new int[]{-16842910}, -1);
            this.f5208p0 = colorStateList.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, -1);
            this.q0 = colorStateList.getColorForState(new int[]{R.attr.state_focused, R.attr.state_enabled}, -1);
        } else if (this.q0 != colorStateList.getDefaultColor()) {
            this.q0 = colorStateList.getDefaultColor();
        }
        z();
    }

    public void setBoxStrokeErrorColor(ColorStateList colorStateList) throws Resources.NotFoundException {
        if (this.f5210r0 != colorStateList) {
            this.f5210r0 = colorStateList;
            z();
        }
    }

    public void setBoxStrokeWidth(int i10) throws Resources.NotFoundException {
        this.V = i10;
        z();
    }

    public void setBoxStrokeWidthFocused(int i10) throws Resources.NotFoundException {
        this.W = i10;
        z();
    }

    public void setBoxStrokeWidthFocusedResource(int i10) throws Resources.NotFoundException {
        setBoxStrokeWidthFocused(getResources().getDimensionPixelSize(i10));
    }

    public void setBoxStrokeWidthResource(int i10) throws Resources.NotFoundException {
        setBoxStrokeWidth(getResources().getDimensionPixelSize(i10));
    }

    public void setCounterEnabled(boolean z) throws Resources.NotFoundException {
        if (this.f5205o != z) {
            n nVar = this.f5203n;
            if (z) {
                AppCompatTextView appCompatTextView = new AppCompatTextView(getContext(), null);
                this.f5211s = appCompatTextView;
                appCompatTextView.setId(com.stepos.aiengine.R.id.textinput_counter);
                Typeface typeface = this.f5191f0;
                if (typeface != null) {
                    this.f5211s.setTypeface(typeface);
                }
                this.f5211s.setMaxLines(1);
                nVar.a(this.f5211s, 2);
                ((ViewGroup.MarginLayoutParams) this.f5211s.getLayoutParams()).setMarginStart(getResources().getDimensionPixelOffset(com.stepos.aiengine.R.dimen.mtrl_textinput_counter_margin_start));
                q();
                if (this.f5211s != null) {
                    EditText editText = this.f5189e;
                    p(editText != null ? editText.getText() : null);
                }
            } else {
                nVar.g(this.f5211s, 2);
                this.f5211s = null;
            }
            this.f5205o = z;
        }
    }

    public void setCounterMaxLength(int i10) throws Resources.NotFoundException {
        if (this.f5207p != i10) {
            if (i10 > 0) {
                this.f5207p = i10;
            } else {
                this.f5207p = -1;
            }
            if (!this.f5205o || this.f5211s == null) {
                return;
            }
            EditText editText = this.f5189e;
            p(editText == null ? null : editText.getText());
        }
    }

    public void setCounterOverflowTextAppearance(int i10) {
        if (this.f5213t != i10) {
            this.f5213t = i10;
            q();
        }
    }

    public void setCounterOverflowTextColor(ColorStateList colorStateList) {
        if (this.D != colorStateList) {
            this.D = colorStateList;
            q();
        }
    }

    public void setCounterTextAppearance(int i10) {
        if (this.f5215u != i10) {
            this.f5215u = i10;
            q();
        }
    }

    public void setCounterTextColor(ColorStateList colorStateList) {
        if (this.C != colorStateList) {
            this.C = colorStateList;
            q();
        }
    }

    public void setCursorColor(ColorStateList colorStateList) throws Resources.NotFoundException {
        if (this.E != colorStateList) {
            this.E = colorStateList;
            r();
        }
    }

    public void setCursorErrorColor(ColorStateList colorStateList) throws Resources.NotFoundException {
        if (this.F != colorStateList) {
            this.F = colorStateList;
            if (o() || (this.f5211s != null && this.f5209q)) {
                r();
            }
        }
    }

    public void setDefaultHintTextColor(ColorStateList colorStateList) {
        this.f5202m0 = colorStateList;
        this.f5204n0 = colorStateList;
        if (this.f5189e != null) {
            w(false, false);
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        m(this, z);
        super.setEnabled(z);
    }

    public void setEndIconActivated(boolean z) {
        this.f5186c.f5264j.setActivated(z);
    }

    public void setEndIconCheckable(boolean z) {
        this.f5186c.f5264j.setCheckable(z);
    }

    public void setEndIconContentDescription(int i10) {
        k kVar = this.f5186c;
        CharSequence text = i10 != 0 ? kVar.getResources().getText(i10) : null;
        CheckableImageButton checkableImageButton = kVar.f5264j;
        if (checkableImageButton.getContentDescription() != text) {
            checkableImageButton.setContentDescription(text);
        }
    }

    public void setEndIconDrawable(int i10) {
        k kVar = this.f5186c;
        Drawable drawableL = i10 != 0 ? b1.L(i10, kVar.getContext()) : null;
        TextInputLayout textInputLayout = kVar.f5259a;
        CheckableImageButton checkableImageButton = kVar.f5264j;
        checkableImageButton.setImageDrawable(drawableL);
        if (drawableL != null) {
            m.a(textInputLayout, checkableImageButton, kVar.f5268n, kVar.f5269o);
            m.c(textInputLayout, checkableImageButton, kVar.f5268n);
        }
    }

    public void setEndIconMinSize(int i10) {
        k kVar = this.f5186c;
        if (i10 < 0) {
            kVar.getClass();
            throw new IllegalArgumentException("endIconSize cannot be less than 0");
        }
        if (i10 != kVar.f5270p) {
            kVar.f5270p = i10;
            CheckableImageButton checkableImageButton = kVar.f5264j;
            checkableImageButton.setMinimumWidth(i10);
            checkableImageButton.setMinimumHeight(i10);
            CheckableImageButton checkableImageButton2 = kVar.f5261c;
            checkableImageButton2.setMinimumWidth(i10);
            checkableImageButton2.setMinimumHeight(i10);
        }
    }

    public void setEndIconMode(int i10) {
        this.f5186c.g(i10);
    }

    public void setEndIconOnClickListener(View.OnClickListener onClickListener) {
        k kVar = this.f5186c;
        CheckableImageButton checkableImageButton = kVar.f5264j;
        View.OnLongClickListener onLongClickListener = kVar.r;
        checkableImageButton.setOnClickListener(onClickListener);
        m.d(checkableImageButton, onLongClickListener);
    }

    public void setEndIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        k kVar = this.f5186c;
        kVar.r = onLongClickListener;
        CheckableImageButton checkableImageButton = kVar.f5264j;
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        m.d(checkableImageButton, onLongClickListener);
    }

    public void setEndIconScaleType(ImageView.ScaleType scaleType) {
        k kVar = this.f5186c;
        kVar.f5271q = scaleType;
        kVar.f5264j.setScaleType(scaleType);
        kVar.f5261c.setScaleType(scaleType);
    }

    public void setEndIconTintList(ColorStateList colorStateList) {
        k kVar = this.f5186c;
        if (kVar.f5268n != colorStateList) {
            kVar.f5268n = colorStateList;
            m.a(kVar.f5259a, kVar.f5264j, colorStateList, kVar.f5269o);
        }
    }

    public void setEndIconTintMode(PorterDuff.Mode mode) {
        k kVar = this.f5186c;
        if (kVar.f5269o != mode) {
            kVar.f5269o = mode;
            m.a(kVar.f5259a, kVar.f5264j, kVar.f5268n, mode);
        }
    }

    public void setEndIconVisible(boolean z) {
        this.f5186c.h(z);
    }

    public void setError(CharSequence charSequence) throws Resources.NotFoundException {
        n nVar = this.f5203n;
        if (!nVar.f5305q) {
            if (TextUtils.isEmpty(charSequence)) {
                return;
            } else {
                setErrorEnabled(true);
            }
        }
        if (TextUtils.isEmpty(charSequence)) {
            nVar.f();
            return;
        }
        nVar.c();
        nVar.f5304p = charSequence;
        nVar.r.setText(charSequence);
        int i10 = nVar.f5302n;
        if (i10 != 1) {
            nVar.f5303o = 1;
        }
        nVar.i(i10, nVar.f5303o, nVar.h(nVar.r, charSequence));
    }

    public void setErrorAccessibilityLiveRegion(int i10) {
        n nVar = this.f5203n;
        nVar.f5307t = i10;
        AppCompatTextView appCompatTextView = nVar.r;
        if (appCompatTextView != null) {
            appCompatTextView.setAccessibilityLiveRegion(i10);
        }
    }

    public void setErrorContentDescription(CharSequence charSequence) {
        n nVar = this.f5203n;
        nVar.f5306s = charSequence;
        AppCompatTextView appCompatTextView = nVar.r;
        if (appCompatTextView != null) {
            appCompatTextView.setContentDescription(charSequence);
        }
    }

    public void setErrorEnabled(boolean z) throws Resources.NotFoundException {
        n nVar = this.f5203n;
        TextInputLayout textInputLayout = nVar.h;
        if (nVar.f5305q == z) {
            return;
        }
        nVar.c();
        if (z) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(nVar.f5296g, null);
            nVar.r = appCompatTextView;
            appCompatTextView.setId(com.stepos.aiengine.R.id.textinput_error);
            nVar.r.setTextAlignment(5);
            Typeface typeface = nVar.B;
            if (typeface != null) {
                nVar.r.setTypeface(typeface);
            }
            int i10 = nVar.f5308u;
            nVar.f5308u = i10;
            AppCompatTextView appCompatTextView2 = nVar.r;
            if (appCompatTextView2 != null) {
                nVar.h.n(appCompatTextView2, i10);
            }
            ColorStateList colorStateList = nVar.f5309v;
            nVar.f5309v = colorStateList;
            AppCompatTextView appCompatTextView3 = nVar.r;
            if (appCompatTextView3 != null && colorStateList != null) {
                appCompatTextView3.setTextColor(colorStateList);
            }
            CharSequence charSequence = nVar.f5306s;
            nVar.f5306s = charSequence;
            AppCompatTextView appCompatTextView4 = nVar.r;
            if (appCompatTextView4 != null) {
                appCompatTextView4.setContentDescription(charSequence);
            }
            int i11 = nVar.f5307t;
            nVar.f5307t = i11;
            AppCompatTextView appCompatTextView5 = nVar.r;
            if (appCompatTextView5 != null) {
                appCompatTextView5.setAccessibilityLiveRegion(i11);
            }
            nVar.r.setVisibility(4);
            nVar.a(nVar.r, 0);
        } else {
            nVar.f();
            nVar.g(nVar.r, 0);
            nVar.r = null;
            textInputLayout.t();
            textInputLayout.z();
        }
        nVar.f5305q = z;
    }

    public void setErrorIconDrawable(int i10) {
        k kVar = this.f5186c;
        kVar.i(i10 != 0 ? b1.L(i10, kVar.getContext()) : null);
        m.c(kVar.f5259a, kVar.f5261c, kVar.f5262d);
    }

    public void setErrorIconOnClickListener(View.OnClickListener onClickListener) {
        k kVar = this.f5186c;
        CheckableImageButton checkableImageButton = kVar.f5261c;
        View.OnLongClickListener onLongClickListener = kVar.h;
        checkableImageButton.setOnClickListener(onClickListener);
        m.d(checkableImageButton, onLongClickListener);
    }

    public void setErrorIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        k kVar = this.f5186c;
        kVar.h = onLongClickListener;
        CheckableImageButton checkableImageButton = kVar.f5261c;
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        m.d(checkableImageButton, onLongClickListener);
    }

    public void setErrorIconTintList(ColorStateList colorStateList) {
        k kVar = this.f5186c;
        if (kVar.f5262d != colorStateList) {
            kVar.f5262d = colorStateList;
            m.a(kVar.f5259a, kVar.f5261c, colorStateList, kVar.f5263e);
        }
    }

    public void setErrorIconTintMode(PorterDuff.Mode mode) {
        k kVar = this.f5186c;
        if (kVar.f5263e != mode) {
            kVar.f5263e = mode;
            m.a(kVar.f5259a, kVar.f5261c, kVar.f5262d, mode);
        }
    }

    public void setErrorTextAppearance(int i10) {
        n nVar = this.f5203n;
        nVar.f5308u = i10;
        AppCompatTextView appCompatTextView = nVar.r;
        if (appCompatTextView != null) {
            nVar.h.n(appCompatTextView, i10);
        }
    }

    public void setErrorTextColor(ColorStateList colorStateList) {
        n nVar = this.f5203n;
        nVar.f5309v = colorStateList;
        AppCompatTextView appCompatTextView = nVar.r;
        if (appCompatTextView == null || colorStateList == null) {
            return;
        }
        appCompatTextView.setTextColor(colorStateList);
    }

    public void setExpandedHintEnabled(boolean z) {
        if (this.A0 != z) {
            this.A0 = z;
            w(false, false);
        }
    }

    public void setHelperText(CharSequence charSequence) throws Resources.NotFoundException {
        boolean zIsEmpty = TextUtils.isEmpty(charSequence);
        n nVar = this.f5203n;
        if (zIsEmpty) {
            if (nVar.f5311x) {
                setHelperTextEnabled(false);
                return;
            }
            return;
        }
        if (!nVar.f5311x) {
            setHelperTextEnabled(true);
        }
        nVar.c();
        nVar.f5310w = charSequence;
        nVar.f5312y.setText(charSequence);
        int i10 = nVar.f5302n;
        if (i10 != 2) {
            nVar.f5303o = 2;
        }
        nVar.i(i10, nVar.f5303o, nVar.h(nVar.f5312y, charSequence));
    }

    public void setHelperTextColor(ColorStateList colorStateList) {
        n nVar = this.f5203n;
        nVar.A = colorStateList;
        AppCompatTextView appCompatTextView = nVar.f5312y;
        if (appCompatTextView == null || colorStateList == null) {
            return;
        }
        appCompatTextView.setTextColor(colorStateList);
    }

    public void setHelperTextEnabled(boolean z) throws Resources.NotFoundException {
        n nVar = this.f5203n;
        TextInputLayout textInputLayout = nVar.h;
        if (nVar.f5311x == z) {
            return;
        }
        nVar.c();
        if (z) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(nVar.f5296g, null);
            nVar.f5312y = appCompatTextView;
            appCompatTextView.setId(com.stepos.aiengine.R.id.textinput_helper_text);
            nVar.f5312y.setTextAlignment(5);
            Typeface typeface = nVar.B;
            if (typeface != null) {
                nVar.f5312y.setTypeface(typeface);
            }
            nVar.f5312y.setVisibility(4);
            nVar.f5312y.setAccessibilityLiveRegion(1);
            int i10 = nVar.z;
            nVar.z = i10;
            AppCompatTextView appCompatTextView2 = nVar.f5312y;
            if (appCompatTextView2 != null) {
                appCompatTextView2.setTextAppearance(i10);
            }
            ColorStateList colorStateList = nVar.A;
            nVar.A = colorStateList;
            AppCompatTextView appCompatTextView3 = nVar.f5312y;
            if (appCompatTextView3 != null && colorStateList != null) {
                appCompatTextView3.setTextColor(colorStateList);
            }
            nVar.a(nVar.f5312y, 1);
            nVar.f5312y.setAccessibilityDelegate(new o(nVar));
        } else {
            nVar.c();
            int i11 = nVar.f5302n;
            if (i11 == 2) {
                nVar.f5303o = 0;
            }
            nVar.i(i11, nVar.f5303o, nVar.h(nVar.f5312y, ""));
            nVar.g(nVar.f5312y, 1);
            nVar.f5312y = null;
            textInputLayout.t();
            textInputLayout.z();
        }
        nVar.f5311x = z;
    }

    public void setHelperTextTextAppearance(int i10) {
        n nVar = this.f5203n;
        nVar.z = i10;
        AppCompatTextView appCompatTextView = nVar.f5312y;
        if (appCompatTextView != null) {
            appCompatTextView.setTextAppearance(i10);
        }
    }

    public void setHint(CharSequence charSequence) {
        if (this.G) {
            setHintInternal(charSequence);
            sendAccessibilityEvent(2048);
        }
    }

    public void setHintAnimationEnabled(boolean z) {
        this.B0 = z;
    }

    public void setHintEnabled(boolean z) {
        if (z != this.G) {
            this.G = z;
            if (z) {
                CharSequence hint = this.f5189e.getHint();
                if (!TextUtils.isEmpty(hint)) {
                    if (TextUtils.isEmpty(this.H)) {
                        setHint(hint);
                    }
                    this.f5189e.setHint((CharSequence) null);
                }
                this.I = true;
            } else {
                this.I = false;
                if (!TextUtils.isEmpty(this.H) && TextUtils.isEmpty(this.f5189e.getHint())) {
                    this.f5189e.setHint(this.H);
                }
                setHintInternal(null);
            }
            if (this.f5189e != null) {
                v();
            }
        }
    }

    public void setHintMaxLines(int i10) {
        com.google.android.material.internal.b bVar = this.z0;
        if (i10 != bVar.f5063f0) {
            bVar.f5063f0 = i10;
            bVar.j(false);
        }
        if (i10 != bVar.f5061e0) {
            bVar.f5061e0 = i10;
            bVar.j(false);
        }
        requestLayout();
    }

    public void setHintTextAppearance(int i10) {
        com.google.android.material.internal.b bVar = this.z0;
        TextInputLayout textInputLayout = bVar.f5054a;
        w4.d dVar = new w4.d(textInputLayout.getContext(), i10);
        ColorStateList colorStateList = dVar.f13590k;
        if (colorStateList != null) {
            bVar.f5071k = colorStateList;
        }
        float f8 = dVar.f13591l;
        if (f8 != 0.0f) {
            bVar.f5067i = f8;
        }
        ColorStateList colorStateList2 = dVar.f13581a;
        if (colorStateList2 != null) {
            bVar.V = colorStateList2;
        }
        bVar.T = dVar.f13586f;
        bVar.U = dVar.f13587g;
        bVar.S = dVar.h;
        bVar.W = dVar.f13589j;
        w4.a aVar = bVar.z;
        if (aVar != null) {
            aVar.f13580d = true;
        }
        androidx.lifecycle.b bVar2 = new androidx.lifecycle.b(bVar, 2);
        dVar.a();
        bVar.z = new w4.a(bVar2, dVar.f13595p);
        dVar.b(textInputLayout.getContext(), bVar.z);
        bVar.j(false);
        this.f5204n0 = bVar.f5071k;
        if (this.f5189e != null) {
            w(false, false);
            v();
        }
    }

    public void setHintTextColor(ColorStateList colorStateList) {
        if (this.f5204n0 != colorStateList) {
            if (this.f5202m0 == null) {
                com.google.android.material.internal.b bVar = this.z0;
                if (bVar.f5071k != colorStateList) {
                    bVar.f5071k = colorStateList;
                    bVar.j(false);
                }
            }
            this.f5204n0 = colorStateList;
            if (this.f5189e != null) {
                w(false, false);
            }
        }
    }

    public void setLengthCounter(f fVar) {
        this.r = fVar;
    }

    public void setMaxEms(int i10) {
        this.f5197k = i10;
        EditText editText = this.f5189e;
        if (editText == null || i10 == -1) {
            return;
        }
        editText.setMaxEms(i10);
    }

    public void setMaxWidth(int i10) {
        this.f5201m = i10;
        EditText editText = this.f5189e;
        if (editText == null || i10 == -1) {
            return;
        }
        editText.setMaxWidth(i10);
    }

    public void setMaxWidthResource(int i10) {
        setMaxWidth(getContext().getResources().getDimensionPixelSize(i10));
    }

    public void setMinEms(int i10) {
        this.f5195j = i10;
        EditText editText = this.f5189e;
        if (editText == null || i10 == -1) {
            return;
        }
        editText.setMinEms(i10);
    }

    public void setMinWidth(int i10) {
        this.f5199l = i10;
        EditText editText = this.f5189e;
        if (editText == null || i10 == -1) {
            return;
        }
        editText.setMinWidth(i10);
    }

    public void setMinWidthResource(int i10) {
        setMinWidth(getContext().getResources().getDimensionPixelSize(i10));
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(int i10) {
        k kVar = this.f5186c;
        kVar.f5264j.setContentDescription(i10 != 0 ? kVar.getResources().getText(i10) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(int i10) {
        k kVar = this.f5186c;
        kVar.f5264j.setImageDrawable(i10 != 0 ? b1.L(i10, kVar.getContext()) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleEnabled(boolean z) {
        k kVar = this.f5186c;
        if (z && kVar.f5266l != 1) {
            kVar.g(1);
        } else if (z) {
            kVar.getClass();
        } else {
            kVar.g(0);
        }
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintList(ColorStateList colorStateList) {
        k kVar = this.f5186c;
        kVar.f5268n = colorStateList;
        m.a(kVar.f5259a, kVar.f5264j, colorStateList, kVar.f5269o);
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintMode(PorterDuff.Mode mode) {
        k kVar = this.f5186c;
        kVar.f5269o = mode;
        m.a(kVar.f5259a, kVar.f5264j, kVar.f5268n, mode);
    }

    public void setPlaceholderText(CharSequence charSequence) {
        if (this.f5221x == null) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(getContext(), null);
            this.f5221x = appCompatTextView;
            appCompatTextView.setId(com.stepos.aiengine.R.id.textinput_placeholder);
            this.f5221x.setImportantForAccessibility(1);
            this.f5221x.setAccessibilityLiveRegion(1);
            d2.c cVarF = f();
            this.A = cVarF;
            cVarF.f8283b = 67L;
            this.B = f();
            setPlaceholderTextAppearance(this.z);
            setPlaceholderTextColor(this.f5223y);
            e0.j(this.f5221x, new b());
        }
        if (TextUtils.isEmpty(charSequence)) {
            setPlaceholderTextEnabled(false);
        } else {
            if (!this.f5219w) {
                setPlaceholderTextEnabled(true);
            }
            this.f5217v = charSequence;
        }
        EditText editText = this.f5189e;
        x(editText != null ? editText.getText() : null);
    }

    public void setPlaceholderTextAppearance(int i10) {
        this.z = i10;
        AppCompatTextView appCompatTextView = this.f5221x;
        if (appCompatTextView != null) {
            appCompatTextView.setTextAppearance(i10);
        }
    }

    public void setPlaceholderTextColor(ColorStateList colorStateList) {
        if (this.f5223y != colorStateList) {
            this.f5223y = colorStateList;
            AppCompatTextView appCompatTextView = this.f5221x;
            if (appCompatTextView == null || colorStateList == null) {
                return;
            }
            appCompatTextView.setTextColor(colorStateList);
        }
    }

    public void setPrefixText(CharSequence charSequence) {
        t tVar = this.f5185b;
        tVar.getClass();
        tVar.f5335c = TextUtils.isEmpty(charSequence) ? null : charSequence;
        tVar.f5334b.setText(charSequence);
        tVar.e();
    }

    public void setPrefixTextAppearance(int i10) {
        this.f5185b.f5334b.setTextAppearance(i10);
    }

    public void setPrefixTextColor(ColorStateList colorStateList) {
        this.f5185b.f5334b.setTextColor(colorStateList);
    }

    public void setShapeAppearanceModel(y4.j jVar) {
        y4.g gVar = this.J;
        if (gVar == null || gVar.f14023b.f14044a == jVar) {
            return;
        }
        this.P = jVar;
        c();
    }

    public void setStartIconCheckable(boolean z) {
        this.f5185b.f5336d.setCheckable(z);
    }

    public void setStartIconContentDescription(int i10) {
        setStartIconContentDescription(i10 != 0 ? getResources().getText(i10) : null);
    }

    public void setStartIconDrawable(int i10) {
        setStartIconDrawable(i10 != 0 ? b1.L(i10, getContext()) : null);
    }

    public void setStartIconMinSize(int i10) {
        t tVar = this.f5185b;
        if (i10 < 0) {
            tVar.getClass();
            throw new IllegalArgumentException("startIconSize cannot be less than 0");
        }
        if (i10 != tVar.f5338j) {
            tVar.f5338j = i10;
            CheckableImageButton checkableImageButton = tVar.f5336d;
            checkableImageButton.setMinimumWidth(i10);
            checkableImageButton.setMinimumHeight(i10);
        }
    }

    public void setStartIconOnClickListener(View.OnClickListener onClickListener) {
        t tVar = this.f5185b;
        CheckableImageButton checkableImageButton = tVar.f5336d;
        View.OnLongClickListener onLongClickListener = tVar.f5340l;
        checkableImageButton.setOnClickListener(onClickListener);
        m.d(checkableImageButton, onLongClickListener);
    }

    public void setStartIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        t tVar = this.f5185b;
        tVar.f5340l = onLongClickListener;
        CheckableImageButton checkableImageButton = tVar.f5336d;
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        m.d(checkableImageButton, onLongClickListener);
    }

    public void setStartIconScaleType(ImageView.ScaleType scaleType) {
        t tVar = this.f5185b;
        tVar.f5339k = scaleType;
        tVar.f5336d.setScaleType(scaleType);
    }

    public void setStartIconTintList(ColorStateList colorStateList) {
        t tVar = this.f5185b;
        if (tVar.f5337e != colorStateList) {
            tVar.f5337e = colorStateList;
            m.a(tVar.f5333a, tVar.f5336d, colorStateList, tVar.h);
        }
    }

    public void setStartIconTintMode(PorterDuff.Mode mode) {
        t tVar = this.f5185b;
        if (tVar.h != mode) {
            tVar.h = mode;
            m.a(tVar.f5333a, tVar.f5336d, tVar.f5337e, mode);
        }
    }

    public void setStartIconVisible(boolean z) {
        this.f5185b.c(z);
    }

    public void setSuffixText(CharSequence charSequence) {
        k kVar = this.f5186c;
        kVar.getClass();
        kVar.f5272s = TextUtils.isEmpty(charSequence) ? null : charSequence;
        kVar.f5273t.setText(charSequence);
        kVar.n();
    }

    public void setSuffixTextAppearance(int i10) {
        this.f5186c.f5273t.setTextAppearance(i10);
    }

    public void setSuffixTextColor(ColorStateList colorStateList) {
        this.f5186c.f5273t.setTextColor(colorStateList);
    }

    public void setTextInputAccessibilityDelegate(e eVar) {
        EditText editText = this.f5189e;
        if (editText != null) {
            e0.j(editText, eVar);
        }
    }

    public void setTypeface(Typeface typeface) {
        if (typeface != this.f5191f0) {
            this.f5191f0 = typeface;
            this.z0.n(typeface);
            n nVar = this.f5203n;
            if (typeface != nVar.B) {
                nVar.B = typeface;
                AppCompatTextView appCompatTextView = nVar.r;
                if (appCompatTextView != null) {
                    appCompatTextView.setTypeface(typeface);
                }
                AppCompatTextView appCompatTextView2 = nVar.f5312y;
                if (appCompatTextView2 != null) {
                    appCompatTextView2.setTypeface(typeface);
                }
            }
            AppCompatTextView appCompatTextView3 = this.f5211s;
            if (appCompatTextView3 != null) {
                appCompatTextView3.setTypeface(typeface);
            }
        }
    }

    public final void t() {
        Drawable background;
        AppCompatTextView appCompatTextView;
        EditText editText = this.f5189e;
        if (editText == null || this.S != 0 || (background = editText.getBackground()) == null) {
            return;
        }
        int[] iArr = f0.f799a;
        Drawable drawableMutate = background.mutate();
        if (o()) {
            drawableMutate.setColorFilter(androidx.appcompat.widget.j.c(getErrorCurrentTextColors(), PorterDuff.Mode.SRC_IN));
        } else if (this.f5209q && (appCompatTextView = this.f5211s) != null) {
            drawableMutate.setColorFilter(androidx.appcompat.widget.j.c(appCompatTextView.getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
        } else {
            drawableMutate.clearColorFilter();
            this.f5189e.refreshDrawableState();
        }
    }

    public final void u() {
        EditText editText = this.f5189e;
        if (editText == null || this.J == null) {
            return;
        }
        if ((this.M || editText.getBackground() == null) && this.S != 0) {
            this.f5189e.setBackground(getEditTextBoxBackground());
            this.M = true;
        }
    }

    public final void v() {
        if (this.S != 1) {
            FrameLayout frameLayout = this.f5183a;
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) frameLayout.getLayoutParams();
            int iE = e();
            if (iE != layoutParams.topMargin) {
                layoutParams.topMargin = iE;
                frameLayout.requestLayout();
            }
        }
    }

    public final void w(boolean z, boolean z3) {
        ColorStateList colorStateList;
        AppCompatTextView appCompatTextView;
        boolean zIsEnabled = isEnabled();
        EditText editText = this.f5189e;
        boolean z10 = (editText == null || TextUtils.isEmpty(editText.getText())) ? false : true;
        EditText editText2 = this.f5189e;
        boolean z11 = editText2 != null && editText2.hasFocus();
        ColorStateList colorStateList2 = this.f5202m0;
        com.google.android.material.internal.b bVar = this.z0;
        if (colorStateList2 != null) {
            bVar.k(colorStateList2);
        }
        if (!zIsEnabled) {
            ColorStateList colorStateList3 = this.f5202m0;
            bVar.k(ColorStateList.valueOf(colorStateList3 != null ? colorStateList3.getColorForState(new int[]{-16842910}, this.f5220w0) : this.f5220w0));
        } else if (o()) {
            AppCompatTextView appCompatTextView2 = this.f5203n.r;
            bVar.k(appCompatTextView2 != null ? appCompatTextView2.getTextColors() : null);
        } else if (this.f5209q && (appCompatTextView = this.f5211s) != null) {
            bVar.k(appCompatTextView.getTextColors());
        } else if (z11 && (colorStateList = this.f5204n0) != null && bVar.f5071k != colorStateList) {
            bVar.f5071k = colorStateList;
            bVar.j(false);
        }
        k kVar = this.f5186c;
        t tVar = this.f5185b;
        if (z10 || !this.A0 || (isEnabled() && z11)) {
            if (z3 || this.f5224y0) {
                ValueAnimator valueAnimator = this.C0;
                if (valueAnimator != null && valueAnimator.isRunning()) {
                    this.C0.cancel();
                }
                if (z && this.B0) {
                    b(1.0f);
                } else {
                    bVar.m(1.0f);
                }
                this.f5224y0 = false;
                if (g()) {
                    l();
                }
                EditText editText3 = this.f5189e;
                x(editText3 != null ? editText3.getText() : null);
                tVar.f5341m = false;
                tVar.e();
                kVar.f5274u = false;
                kVar.n();
                return;
            }
            return;
        }
        if (z3 || !this.f5224y0) {
            ValueAnimator valueAnimator2 = this.C0;
            if (valueAnimator2 != null && valueAnimator2.isRunning()) {
                this.C0.cancel();
            }
            if (z && this.B0) {
                b(0.0f);
            } else {
                bVar.m(0.0f);
            }
            if (g() && !((com.google.android.material.textfield.e) this.J).H.r.isEmpty() && g()) {
                ((com.google.android.material.textfield.e) this.J).t(0.0f, 0.0f, 0.0f, 0.0f);
            }
            this.f5224y0 = true;
            AppCompatTextView appCompatTextView3 = this.f5221x;
            if (appCompatTextView3 != null && this.f5219w) {
                appCompatTextView3.setText((CharSequence) null);
                d2.m.a(this.f5183a, this.B);
                this.f5221x.setVisibility(4);
            }
            tVar.f5341m = true;
            tVar.e();
            kVar.f5274u = true;
            kVar.n();
        }
    }

    public final void x(Editable editable) {
        ((ai.onnxruntime.a) this.r).getClass();
        int length = editable != null ? editable.length() : 0;
        FrameLayout frameLayout = this.f5183a;
        if (length != 0 || this.f5224y0) {
            AppCompatTextView appCompatTextView = this.f5221x;
            if (appCompatTextView == null || !this.f5219w) {
                return;
            }
            appCompatTextView.setText((CharSequence) null);
            d2.m.a(frameLayout, this.B);
            this.f5221x.setVisibility(4);
            return;
        }
        if (this.f5221x == null || !this.f5219w || TextUtils.isEmpty(this.f5217v)) {
            return;
        }
        this.f5221x.setText(this.f5217v);
        d2.m.a(frameLayout, this.A);
        this.f5221x.setVisibility(0);
        this.f5221x.bringToFront();
    }

    public final void y(boolean z, boolean z3) {
        int defaultColor = this.f5210r0.getDefaultColor();
        int colorForState = this.f5210r0.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, defaultColor);
        int colorForState2 = this.f5210r0.getColorForState(new int[]{R.attr.state_activated, R.attr.state_enabled}, defaultColor);
        if (z) {
            this.f5184a0 = colorForState2;
        } else if (z3) {
            this.f5184a0 = colorForState;
        } else {
            this.f5184a0 = defaultColor;
        }
    }

    public final void z() throws Resources.NotFoundException {
        AppCompatTextView appCompatTextView;
        EditText editText;
        EditText editText2;
        if (this.J == null || this.S == 0) {
            return;
        }
        boolean z = false;
        boolean z3 = isFocused() || ((editText2 = this.f5189e) != null && editText2.hasFocus());
        if (isHovered() || ((editText = this.f5189e) != null && editText.isHovered())) {
            z = true;
        }
        if (!isEnabled()) {
            this.f5184a0 = this.f5220w0;
        } else if (o()) {
            if (this.f5210r0 != null) {
                y(z3, z);
            } else {
                this.f5184a0 = getErrorCurrentTextColors();
            }
        } else if (!this.f5209q || (appCompatTextView = this.f5211s) == null) {
            if (z3) {
                this.f5184a0 = this.q0;
            } else if (z) {
                this.f5184a0 = this.f5208p0;
            } else {
                this.f5184a0 = this.f5206o0;
            }
        } else if (this.f5210r0 != null) {
            y(z3, z);
        } else {
            this.f5184a0 = appCompatTextView.getCurrentTextColor();
        }
        r();
        k kVar = this.f5186c;
        TextInputLayout textInputLayout = kVar.f5259a;
        CheckableImageButton checkableImageButton = kVar.f5264j;
        TextInputLayout textInputLayout2 = kVar.f5259a;
        kVar.l();
        m.c(textInputLayout2, kVar.f5261c, kVar.f5262d);
        m.c(textInputLayout2, checkableImageButton, kVar.f5268n);
        if (kVar.b() instanceof j) {
            if (!textInputLayout.o() || checkableImageButton.getDrawable() == null) {
                m.a(textInputLayout, checkableImageButton, kVar.f5268n, kVar.f5269o);
            } else {
                Drawable drawableMutate = checkableImageButton.getDrawable().mutate();
                drawableMutate.setTint(textInputLayout.getErrorCurrentTextColors());
                checkableImageButton.setImageDrawable(drawableMutate);
            }
        }
        t tVar = this.f5185b;
        m.c(tVar.f5333a, tVar.f5336d, tVar.f5337e);
        if (this.S == 2) {
            int i10 = this.U;
            if (z3 && isEnabled()) {
                this.U = this.W;
            } else {
                this.U = this.V;
            }
            if (this.U != i10 && g() && !this.f5224y0) {
                if (g()) {
                    ((com.google.android.material.textfield.e) this.J).t(0.0f, 0.0f, 0.0f, 0.0f);
                }
                l();
            }
        }
        if (this.S == 1) {
            if (!isEnabled()) {
                this.b0 = this.f5214t0;
            } else if (z && !z3) {
                this.b0 = this.f5218v0;
            } else if (z3) {
                this.b0 = this.f5216u0;
            } else {
                this.b0 = this.f5212s0;
            }
        }
        c();
    }

    public void setStartIconContentDescription(CharSequence charSequence) {
        CheckableImageButton checkableImageButton = this.f5185b.f5336d;
        if (checkableImageButton.getContentDescription() != charSequence) {
            checkableImageButton.setContentDescription(charSequence);
        }
    }

    public void setStartIconDrawable(Drawable drawable) {
        this.f5185b.b(drawable);
    }

    public void setHint(int i10) {
        setHint(i10 != 0 ? getResources().getText(i10) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(CharSequence charSequence) {
        this.f5186c.f5264j.setContentDescription(charSequence);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(Drawable drawable) {
        this.f5186c.f5264j.setImageDrawable(drawable);
    }

    public void setErrorIconDrawable(Drawable drawable) {
        this.f5186c.i(drawable);
    }

    public void setEndIconContentDescription(CharSequence charSequence) {
        CheckableImageButton checkableImageButton = this.f5186c.f5264j;
        if (checkableImageButton.getContentDescription() != charSequence) {
            checkableImageButton.setContentDescription(charSequence);
        }
    }

    public void setEndIconDrawable(Drawable drawable) {
        k kVar = this.f5186c;
        TextInputLayout textInputLayout = kVar.f5259a;
        CheckableImageButton checkableImageButton = kVar.f5264j;
        checkableImageButton.setImageDrawable(drawable);
        if (drawable != null) {
            m.a(textInputLayout, checkableImageButton, kVar.f5268n, kVar.f5269o);
            m.c(textInputLayout, checkableImageButton, kVar.f5268n);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a implements TextWatcher {

        /* renamed from: a, reason: collision with root package name */
        public int f5225a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ EditText f5226b;

        public a(EditText editText) {
            this.f5226b = editText;
            this.f5225a = editText.getLineCount();
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable editable) throws Resources.NotFoundException {
            TextInputLayout textInputLayout = TextInputLayout.this;
            textInputLayout.w(!textInputLayout.E0, false);
            if (textInputLayout.f5205o) {
                textInputLayout.p(editable);
            }
            if (textInputLayout.f5219w) {
                textInputLayout.x(editable);
            }
            EditText editText = this.f5226b;
            int lineCount = editText.getLineCount();
            int i10 = this.f5225a;
            if (lineCount != i10) {
                if (lineCount < i10) {
                    int minimumHeight = editText.getMinimumHeight();
                    int i11 = textInputLayout.f5222x0;
                    if (minimumHeight != i11) {
                        editText.setMinimumHeight(i11);
                    }
                }
                this.f5225a = lineCount;
            }
        }

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }
    }
}
