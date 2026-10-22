package com.google.android.material.textfield;

import K.C0073e;
import K.S;
import Z2.I;
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
import android.graphics.PorterDuffColorFilter;
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
import android.text.StaticLayout;
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
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.widget.AbstractC0220p0;
import androidx.appcompat.widget.C0200f0;
import androidx.appcompat.widget.N0;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.internal.CheckableImageButton;
import com.stepos.alphame.utils.Property;
import e.EnumC0546d;
import f1.AbstractC0557a;
import h.RunnableC0583a;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Locale;
import m1.AbstractC0769a;
import n1.AbstractC0775a;
import o0.C0801g;
import s.AbstractC0831a;
import w1.C0970a;
import w1.C0973d;
import y1.C0987a;
import y1.InterfaceC0990d;

/* loaded from: classes.dex */
public class TextInputLayout extends LinearLayout implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: N0, reason: collision with root package name */
    public static final int[][] f10916N0 = {new int[]{R.attr.state_pressed}, new int[0]};

    /* renamed from: A, reason: collision with root package name */
    public ColorStateList f10917A;

    /* renamed from: A0, reason: collision with root package name */
    public int f10918A0;

    /* renamed from: B, reason: collision with root package name */
    public ColorStateList f10919B;

    /* renamed from: B0, reason: collision with root package name */
    public int f10920B0;

    /* renamed from: C, reason: collision with root package name */
    public ColorStateList f10921C;

    /* renamed from: C0, reason: collision with root package name */
    public int f10922C0;

    /* renamed from: D, reason: collision with root package name */
    public boolean f10923D;

    /* renamed from: D0, reason: collision with root package name */
    public int f10924D0;

    /* renamed from: E, reason: collision with root package name */
    public CharSequence f10925E;

    /* renamed from: E0, reason: collision with root package name */
    public int f10926E0;

    /* renamed from: F, reason: collision with root package name */
    public boolean f10927F;

    /* renamed from: F0, reason: collision with root package name */
    public boolean f10928F0;

    /* renamed from: G, reason: collision with root package name */
    public y1.j f10929G;

    /* renamed from: G0, reason: collision with root package name */
    public final com.google.android.material.internal.b f10930G0;

    /* renamed from: H, reason: collision with root package name */
    public y1.j f10931H;

    /* renamed from: H0, reason: collision with root package name */
    public boolean f10932H0;

    /* renamed from: I, reason: collision with root package name */
    public StateListDrawable f10933I;

    /* renamed from: I0, reason: collision with root package name */
    public boolean f10934I0;

    /* renamed from: J, reason: collision with root package name */
    public boolean f10935J;

    /* renamed from: J0, reason: collision with root package name */
    public ValueAnimator f10936J0;

    /* renamed from: K, reason: collision with root package name */
    public y1.j f10937K;

    /* renamed from: K0, reason: collision with root package name */
    public boolean f10938K0;

    /* renamed from: L, reason: collision with root package name */
    public y1.j f10939L;

    /* renamed from: L0, reason: collision with root package name */
    public boolean f10940L0;

    /* renamed from: M, reason: collision with root package name */
    public y1.n f10941M;

    /* renamed from: M0, reason: collision with root package name */
    public boolean f10942M0;

    /* renamed from: N, reason: collision with root package name */
    public boolean f10943N;

    /* renamed from: O, reason: collision with root package name */
    public final int f10944O;

    /* renamed from: P, reason: collision with root package name */
    public int f10945P;

    /* renamed from: Q, reason: collision with root package name */
    public int f10946Q;

    /* renamed from: R, reason: collision with root package name */
    public int f10947R;

    /* renamed from: S, reason: collision with root package name */
    public int f10948S;
    public int T;

    /* renamed from: U, reason: collision with root package name */
    public int f10949U;

    /* renamed from: V, reason: collision with root package name */
    public int f10950V;

    /* renamed from: W, reason: collision with root package name */
    public final Rect f10951W;

    /* renamed from: a, reason: collision with root package name */
    public final FrameLayout f10952a;

    /* renamed from: b, reason: collision with root package name */
    public final w f10953b;

    /* renamed from: c, reason: collision with root package name */
    public final n f10954c;

    /* renamed from: d, reason: collision with root package name */
    public final int f10955d;

    /* renamed from: e, reason: collision with root package name */
    public EditText f10956e;

    /* renamed from: f, reason: collision with root package name */
    public CharSequence f10957f;

    /* renamed from: g, reason: collision with root package name */
    public int f10958g;

    /* renamed from: h, reason: collision with root package name */
    public int f10959h;

    /* renamed from: i, reason: collision with root package name */
    public int f10960i;

    /* renamed from: j, reason: collision with root package name */
    public int f10961j;

    /* renamed from: k, reason: collision with root package name */
    public final r f10962k;

    /* renamed from: k0, reason: collision with root package name */
    public final Rect f10963k0;

    /* renamed from: l, reason: collision with root package name */
    public boolean f10964l;

    /* renamed from: l0, reason: collision with root package name */
    public final RectF f10965l0;

    /* renamed from: m, reason: collision with root package name */
    public int f10966m;

    /* renamed from: m0, reason: collision with root package name */
    public Typeface f10967m0;

    /* renamed from: n, reason: collision with root package name */
    public boolean f10968n;

    /* renamed from: n0, reason: collision with root package name */
    public ColorDrawable f10969n0;

    /* renamed from: o, reason: collision with root package name */
    public z f10970o;

    /* renamed from: o0, reason: collision with root package name */
    public int f10971o0;

    /* renamed from: p, reason: collision with root package name */
    public C0200f0 f10972p;

    /* renamed from: p0, reason: collision with root package name */
    public final LinkedHashSet f10973p0;

    /* renamed from: q, reason: collision with root package name */
    public int f10974q;

    /* renamed from: q0, reason: collision with root package name */
    public ColorDrawable f10975q0;

    /* renamed from: r, reason: collision with root package name */
    public int f10976r;

    /* renamed from: r0, reason: collision with root package name */
    public int f10977r0;

    /* renamed from: s, reason: collision with root package name */
    public CharSequence f10978s;

    /* renamed from: s0, reason: collision with root package name */
    public Drawable f10979s0;

    /* renamed from: t, reason: collision with root package name */
    public boolean f10980t;

    /* renamed from: t0, reason: collision with root package name */
    public ColorStateList f10981t0;

    /* renamed from: u, reason: collision with root package name */
    public C0200f0 f10982u;

    /* renamed from: u0, reason: collision with root package name */
    public ColorStateList f10983u0;

    /* renamed from: v, reason: collision with root package name */
    public ColorStateList f10984v;

    /* renamed from: v0, reason: collision with root package name */
    public int f10985v0;

    /* renamed from: w, reason: collision with root package name */
    public int f10986w;

    /* renamed from: w0, reason: collision with root package name */
    public int f10987w0;

    /* renamed from: x, reason: collision with root package name */
    public C0801g f10988x;

    /* renamed from: x0, reason: collision with root package name */
    public int f10989x0;

    /* renamed from: y, reason: collision with root package name */
    public C0801g f10990y;

    /* renamed from: y0, reason: collision with root package name */
    public ColorStateList f10991y0;

    /* renamed from: z, reason: collision with root package name */
    public ColorStateList f10992z;

    /* renamed from: z0, reason: collision with root package name */
    public int f10993z0;

    @Retention(RetentionPolicy.SOURCE)
    public @interface BoxBackgroundMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({EnumC0546d.f12493b})
    public @interface EndIconMode {
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new A();

        /* renamed from: a, reason: collision with root package name */
        public CharSequence f10994a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f10995b;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f10994a = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f10995b = parcel.readInt() == 1;
        }

        public final String toString() {
            return "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + ((Object) this.f10994a) + "}";
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i4) {
            super.writeToParcel(parcel, i4);
            TextUtils.writeToParcel(this.f10994a, parcel, i4);
            parcel.writeInt(this.f10995b ? 1 : 0);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v19 */
    /* JADX WARN: Type inference failed for: r4v20, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r4v33 */
    public TextInputLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) throws Resources.NotFoundException {
        ?? r4;
        super(C1.a.b(context, attributeSet, com.stepos.alphame.R.attr.textInputStyle, com.stepos.alphame.R.style.Widget_Design_TextInputLayout), attributeSet, com.stepos.alphame.R.attr.textInputStyle);
        this.f10958g = -1;
        this.f10959h = -1;
        this.f10960i = -1;
        this.f10961j = -1;
        this.f10962k = new r(this);
        this.f10970o = new C0073e(8);
        this.f10951W = new Rect();
        this.f10963k0 = new Rect();
        this.f10965l0 = new RectF();
        this.f10973p0 = new LinkedHashSet();
        com.google.android.material.internal.b bVar = new com.google.android.material.internal.b(this);
        this.f10930G0 = bVar;
        this.f10942M0 = false;
        Context context2 = getContext();
        setOrientation(1);
        setWillNotDraw(false);
        setAddStatesFromChildren(true);
        FrameLayout frameLayout = new FrameLayout(context2);
        this.f10952a = frameLayout;
        frameLayout.setAddStatesFromChildren(true);
        LinearInterpolator linearInterpolator = AbstractC0775a.f13650a;
        bVar.f10786R = linearInterpolator;
        bVar.j(false);
        bVar.f10785Q = linearInterpolator;
        bVar.j(false);
        if (bVar.f10806g != 8388659) {
            bVar.f10806g = 8388659;
            bVar.j(false);
        }
        int[] iArr = AbstractC0769a.f13533H;
        com.google.android.material.internal.l.a(context2, attributeSet, com.stepos.alphame.R.attr.textInputStyle, com.stepos.alphame.R.style.Widget_Design_TextInputLayout);
        com.google.android.material.internal.l.b(context2, attributeSet, iArr, com.stepos.alphame.R.attr.textInputStyle, com.stepos.alphame.R.style.Widget_Design_TextInputLayout, 22, 20, 40, 45, 50);
        android.support.v4.media.session.c cVar = new android.support.v4.media.session.c(context2, context2.obtainStyledAttributes(attributeSet, iArr, com.stepos.alphame.R.attr.textInputStyle, com.stepos.alphame.R.style.Widget_Design_TextInputLayout));
        w wVar = new w(this, cVar);
        this.f10953b = wVar;
        this.f10923D = cVar.g(48, true);
        setHint(cVar.u(4));
        this.f10934I0 = cVar.g(47, true);
        this.f10932H0 = cVar.g(42, true);
        if (cVar.v(6)) {
            setMinEms(cVar.p(6, -1));
        } else if (cVar.v(3)) {
            setMinWidth(cVar.j(3, -1));
        }
        if (cVar.v(5)) {
            setMaxEms(cVar.p(5, -1));
        } else if (cVar.v(2)) {
            setMaxWidth(cVar.j(2, -1));
        }
        this.f10941M = y1.n.b(context2, attributeSet, com.stepos.alphame.R.attr.textInputStyle, com.stepos.alphame.R.style.Widget_Design_TextInputLayout).a();
        this.f10944O = context2.getResources().getDimensionPixelOffset(com.stepos.alphame.R.dimen.mtrl_textinput_box_label_cutout_padding);
        this.f10946Q = cVar.i(9, 0);
        this.f10955d = getResources().getDimensionPixelSize(com.stepos.alphame.R.dimen.m3_multiline_hint_filled_text_extra_space);
        this.f10948S = cVar.j(16, context2.getResources().getDimensionPixelSize(com.stepos.alphame.R.dimen.mtrl_textinput_box_stroke_width_default));
        this.T = cVar.j(17, context2.getResources().getDimensionPixelSize(com.stepos.alphame.R.dimen.mtrl_textinput_box_stroke_width_focused));
        this.f10947R = this.f10948S;
        float dimension = ((TypedArray) cVar.f2365c).getDimension(13, -1.0f);
        float dimension2 = ((TypedArray) cVar.f2365c).getDimension(12, -1.0f);
        float dimension3 = ((TypedArray) cVar.f2365c).getDimension(10, -1.0f);
        float dimension4 = ((TypedArray) cVar.f2365c).getDimension(11, -1.0f);
        y1.m mVarF = this.f10941M.f();
        if (dimension >= Property.DEFAULT_FLOAT_VALUE) {
            mVarF.f16264e = new C0987a(dimension);
        }
        if (dimension2 >= Property.DEFAULT_FLOAT_VALUE) {
            mVarF.f16265f = new C0987a(dimension2);
        }
        if (dimension3 >= Property.DEFAULT_FLOAT_VALUE) {
            mVarF.f16266g = new C0987a(dimension3);
        }
        if (dimension4 >= Property.DEFAULT_FLOAT_VALUE) {
            mVarF.f16267h = new C0987a(dimension4);
        }
        this.f10941M = mVarF.a();
        ColorStateList colorStateListZ = B0.f.z(context2, cVar, 7);
        if (colorStateListZ != null) {
            int defaultColor = colorStateListZ.getDefaultColor();
            this.f10993z0 = defaultColor;
            this.f10950V = defaultColor;
            if (colorStateListZ.isStateful()) {
                this.f10918A0 = colorStateListZ.getColorForState(new int[]{-16842910}, -1);
                this.f10920B0 = colorStateListZ.getColorForState(new int[]{R.attr.state_focused, R.attr.state_enabled}, -1);
                this.f10922C0 = colorStateListZ.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, -1);
            } else {
                this.f10920B0 = this.f10993z0;
                ColorStateList colorStateListX = B0.f.x(com.stepos.alphame.R.color.mtrl_filled_background_color, context2);
                this.f10918A0 = colorStateListX.getColorForState(new int[]{-16842910}, -1);
                this.f10922C0 = colorStateListX.getColorForState(new int[]{R.attr.state_hovered}, -1);
            }
        } else {
            this.f10950V = 0;
            this.f10993z0 = 0;
            this.f10918A0 = 0;
            this.f10920B0 = 0;
            this.f10922C0 = 0;
        }
        if (cVar.v(1)) {
            ColorStateList colorStateListH = cVar.h(1);
            this.f10983u0 = colorStateListH;
            this.f10981t0 = colorStateListH;
        }
        ColorStateList colorStateListZ2 = B0.f.z(context2, cVar, 14);
        this.f10989x0 = ((TypedArray) cVar.f2365c).getColor(14, 0);
        this.f10985v0 = androidx.core.content.b.a(context2, com.stepos.alphame.R.color.mtrl_textinput_default_box_stroke_color);
        this.f10924D0 = androidx.core.content.b.a(context2, com.stepos.alphame.R.color.mtrl_textinput_disabled_color);
        this.f10987w0 = androidx.core.content.b.a(context2, com.stepos.alphame.R.color.mtrl_textinput_hovered_box_stroke_color);
        if (colorStateListZ2 != null) {
            setBoxStrokeColorStateList(colorStateListZ2);
        }
        if (cVar.v(15)) {
            setBoxStrokeErrorColor(B0.f.z(context2, cVar, 15));
        }
        if (cVar.r(50, -1) != -1) {
            r4 = 0;
            setHintTextAppearance(cVar.r(50, 0));
        } else {
            r4 = 0;
        }
        this.f10919B = cVar.h(24);
        this.f10921C = cVar.h(25);
        int iR = cVar.r(40, r4);
        CharSequence charSequenceU = cVar.u(35);
        int iP = cVar.p(34, 1);
        boolean zG = cVar.g(36, r4);
        int iR2 = cVar.r(45, r4);
        boolean zG2 = cVar.g(44, r4);
        CharSequence charSequenceU2 = cVar.u(43);
        int iR3 = cVar.r(58, r4);
        CharSequence charSequenceU3 = cVar.u(57);
        boolean zG3 = cVar.g(18, r4);
        setCounterMaxLength(cVar.p(19, -1));
        this.f10976r = cVar.r(22, 0);
        this.f10974q = cVar.r(20, 0);
        setBoxBackgroundMode(cVar.p(8, 0));
        setErrorContentDescription(charSequenceU);
        setErrorAccessibilityLiveRegion(iP);
        setCounterOverflowTextAppearance(this.f10974q);
        setHelperTextTextAppearance(iR2);
        setErrorTextAppearance(iR);
        setCounterTextAppearance(this.f10976r);
        setPlaceholderText(charSequenceU3);
        setPlaceholderTextAppearance(iR3);
        if (cVar.v(41)) {
            setErrorTextColor(cVar.h(41));
        }
        if (cVar.v(46)) {
            setHelperTextColor(cVar.h(46));
        }
        if (cVar.v(51)) {
            setHintTextColor(cVar.h(51));
        }
        if (cVar.v(23)) {
            setCounterTextColor(cVar.h(23));
        }
        if (cVar.v(21)) {
            setCounterOverflowTextColor(cVar.h(21));
        }
        if (cVar.v(59)) {
            setPlaceholderTextColor(cVar.h(59));
        }
        n nVar = new n(this, cVar);
        this.f10954c = nVar;
        boolean zG4 = cVar.g(0, true);
        setHintMaxLines(cVar.p(49, 1));
        cVar.A();
        setImportantForAccessibility(2);
        setImportantForAutofill(1);
        frameLayout.addView(wVar);
        frameLayout.addView(nVar);
        addView(frameLayout);
        setEnabled(zG4);
        setHelperTextEnabled(zG2);
        setErrorEnabled(zG);
        setCounterEnabled(zG3);
        setHelperText(charSequenceU2);
    }

    @Nullable
    private Drawable getEditTextBoxBackground() {
        EditText editText = this.f10956e;
        if (!(editText instanceof AutoCompleteTextView) || com.airbnb.lottie.h.u(editText)) {
            return this.f10929G;
        }
        int iX = AbstractC0557a.x(com.stepos.alphame.R.attr.colorControlHighlight, this.f10956e);
        int i4 = this.f10945P;
        int[][] iArr = f10916N0;
        if (i4 != 2) {
            if (i4 != 1) {
                return null;
            }
            y1.j jVar = this.f10929G;
            int i5 = this.f10950V;
            return new RippleDrawable(new ColorStateList(iArr, new int[]{AbstractC0557a.L(0.1f, iX, i5), i5}), jVar, jVar);
        }
        Context context = getContext();
        y1.j jVar2 = this.f10929G;
        TypedValue typedValueY = AbstractC0557a.Y(context, "TextInputLayout", com.stepos.alphame.R.attr.colorSurface);
        int i6 = typedValueY.resourceId;
        int iA = i6 != 0 ? androidx.core.content.b.a(context, i6) : typedValueY.data;
        y1.j jVar3 = new y1.j(jVar2.f16234b.f16203a);
        int iL = AbstractC0557a.L(0.1f, iX, iA);
        jVar3.o(new ColorStateList(iArr, new int[]{iL, 0}));
        jVar3.setTint(iA);
        ColorStateList colorStateList = new ColorStateList(iArr, new int[]{iL, iA});
        y1.j jVar4 = new y1.j(jVar2.f16234b.f16203a);
        jVar4.setTint(-1);
        return new LayerDrawable(new Drawable[]{new RippleDrawable(colorStateList, jVar3, jVar4), jVar2});
    }

    private Drawable getOrCreateFilledDropDownMenuBackground() {
        if (this.f10933I == null) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            this.f10933I = stateListDrawable;
            stateListDrawable.addState(new int[]{R.attr.state_above_anchor}, getOrCreateOutlinedDropDownMenuBackground());
            this.f10933I.addState(new int[0], h(false));
        }
        return this.f10933I;
    }

    private Drawable getOrCreateOutlinedDropDownMenuBackground() {
        if (this.f10931H == null) {
            this.f10931H = h(true);
        }
        return this.f10931H;
    }

    public static void m(ViewGroup viewGroup, boolean z4) {
        int childCount = viewGroup.getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = viewGroup.getChildAt(i4);
            childAt.setEnabled(z4);
            if (childAt instanceof ViewGroup) {
                m((ViewGroup) childAt, z4);
            }
        }
    }

    private void setEditText(EditText editText) throws Resources.NotFoundException {
        if (this.f10956e != null) {
            throw new IllegalArgumentException("We already have an EditText, can only have one");
        }
        if (getEndIconMode() != 3 && !(editText instanceof TextInputEditText)) {
            Log.i("TextInputLayout", "EditText added is not a TextInputEditText. Please switch to using that class instead.");
        }
        this.f10956e = editText;
        int i4 = this.f10958g;
        if (i4 != -1) {
            setMinEms(i4);
        } else {
            setMinWidth(this.f10960i);
        }
        int i5 = this.f10959h;
        if (i5 != -1) {
            setMaxEms(i5);
        } else {
            setMaxWidth(this.f10961j);
        }
        this.f10935J = false;
        k();
        setTextInputAccessibilityDelegate(new y(this));
        Typeface typeface = this.f10956e.getTypeface();
        com.google.android.material.internal.b bVar = this.f10930G0;
        bVar.n(typeface);
        float textSize = this.f10956e.getTextSize();
        if (bVar.f10808h != textSize) {
            bVar.f10808h = textSize;
            bVar.j(false);
        }
        float letterSpacing = this.f10956e.getLetterSpacing();
        if (bVar.f10791X != letterSpacing) {
            bVar.f10791X = letterSpacing;
            bVar.j(false);
        }
        int gravity = this.f10956e.getGravity();
        int i6 = (gravity & (-113)) | 48;
        if (bVar.f10806g != i6) {
            bVar.f10806g = i6;
            bVar.j(false);
        }
        if (bVar.f10804f != gravity) {
            bVar.f10804f = gravity;
            bVar.j(false);
        }
        this.f10926E0 = editText.getMinimumHeight();
        this.f10956e.addTextChangedListener(new x(this, editText));
        if (this.f10981t0 == null) {
            this.f10981t0 = this.f10956e.getHintTextColors();
        }
        if (this.f10923D) {
            if (TextUtils.isEmpty(this.f10925E)) {
                CharSequence hint = this.f10956e.getHint();
                this.f10957f = hint;
                setHint(hint);
                this.f10956e.setHint((CharSequence) null);
            }
            this.f10927F = true;
        }
        r();
        if (this.f10972p != null) {
            p(this.f10956e.getText());
        }
        t();
        this.f10962k.b();
        this.f10953b.bringToFront();
        n nVar = this.f10954c;
        nVar.bringToFront();
        Iterator it = this.f10973p0.iterator();
        while (it.hasNext()) {
            ((m) it.next()).a(this);
        }
        nVar.m();
        if (!isEnabled()) {
            editText.setEnabled(false);
        }
        w(false, true);
    }

    private void setHintInternal(CharSequence charSequence) {
        if (TextUtils.equals(charSequence, this.f10925E)) {
            return;
        }
        this.f10925E = charSequence;
        com.google.android.material.internal.b bVar = this.f10930G0;
        if (charSequence == null || !TextUtils.equals(bVar.f10770B, charSequence)) {
            bVar.f10770B = charSequence;
            bVar.f10771C = null;
            bVar.j(false);
        }
        if (this.f10928F0) {
            return;
        }
        l();
    }

    private void setPlaceholderTextEnabled(boolean z4) {
        if (this.f10980t == z4) {
            return;
        }
        if (z4) {
            C0200f0 c0200f0 = this.f10982u;
            if (c0200f0 != null) {
                this.f10952a.addView(c0200f0);
                this.f10982u.setVisibility(0);
            }
        } else {
            C0200f0 c0200f02 = this.f10982u;
            if (c0200f02 != null) {
                c0200f02.setVisibility(8);
            }
            this.f10982u = null;
        }
        this.f10980t = z4;
    }

    public final void a() {
        if (this.f10956e != null) {
            if (this.f10945P != 1) {
                return;
            }
            if (!(getHintMaxLines() == 1)) {
                EditText editText = this.f10956e;
                editText.setPaddingRelative(editText.getPaddingStart(), (int) (this.f10930G0.f() + this.f10955d), this.f10956e.getPaddingEnd(), getResources().getDimensionPixelSize(com.stepos.alphame.R.dimen.material_filled_edittext_font_1_3_padding_bottom));
            } else if (getContext().getResources().getConfiguration().fontScale >= 2.0f) {
                EditText editText2 = this.f10956e;
                editText2.setPaddingRelative(editText2.getPaddingStart(), getResources().getDimensionPixelSize(com.stepos.alphame.R.dimen.material_filled_edittext_font_2_0_padding_top), this.f10956e.getPaddingEnd(), getResources().getDimensionPixelSize(com.stepos.alphame.R.dimen.material_filled_edittext_font_2_0_padding_bottom));
            } else if (B0.f.Q(getContext())) {
                EditText editText3 = this.f10956e;
                editText3.setPaddingRelative(editText3.getPaddingStart(), getResources().getDimensionPixelSize(com.stepos.alphame.R.dimen.material_filled_edittext_font_1_3_padding_top), this.f10956e.getPaddingEnd(), getResources().getDimensionPixelSize(com.stepos.alphame.R.dimen.material_filled_edittext_font_1_3_padding_bottom));
            }
        }
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i4, ViewGroup.LayoutParams layoutParams) throws Resources.NotFoundException {
        if (!(view instanceof EditText)) {
            super.addView(view, i4, layoutParams);
            return;
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams);
        layoutParams2.gravity = (layoutParams2.gravity & (-113)) | 16;
        FrameLayout frameLayout = this.f10952a;
        frameLayout.addView(view, layoutParams2);
        frameLayout.setLayoutParams(layoutParams);
        v();
        setEditText((EditText) view);
    }

    public final void b(float f4) {
        int i4 = 2;
        com.google.android.material.internal.b bVar = this.f10930G0;
        if (bVar.f10796b == f4) {
            return;
        }
        if (this.f10936J0 == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.f10936J0 = valueAnimator;
            valueAnimator.setInterpolator(com.stepos.statsrpk.c.M(getContext(), com.stepos.alphame.R.attr.motionEasingEmphasizedInterpolator, AbstractC0775a.f13651b));
            this.f10936J0.setDuration(com.stepos.statsrpk.c.L(getContext(), com.stepos.alphame.R.attr.motionDurationMedium4, 167));
            this.f10936J0.addUpdateListener(new com.airbnb.lottie.q(i4, this));
        }
        this.f10936J0.setFloatValues(bVar.f10796b, f4);
        this.f10936J0.start();
    }

    public final void c() {
        int i4;
        int i5;
        y1.j jVar = this.f10929G;
        if (jVar == null) {
            return;
        }
        y1.n nVar = jVar.f16234b.f16203a;
        y1.n nVar2 = this.f10941M;
        if (nVar != nVar2) {
            jVar.setShapeAppearanceModel(nVar2);
        }
        if (this.f10945P == 2 && (i4 = this.f10947R) > -1 && (i5 = this.f10949U) != 0) {
            y1.j jVar2 = this.f10929G;
            jVar2.f16234b.f16214l = i4;
            jVar2.invalidateSelf();
            ColorStateList colorStateListValueOf = ColorStateList.valueOf(i5);
            y1.h hVar = jVar2.f16234b;
            if (hVar.f16207e != colorStateListValueOf) {
                hVar.f16207e = colorStateListValueOf;
                jVar2.onStateChange(jVar2.getState());
            }
        }
        int iB = this.f10950V;
        if (this.f10945P == 1) {
            Integer numY = AbstractC0557a.y(com.stepos.alphame.R.attr.colorSurface, getContext());
            iB = D.a.b(this.f10950V, numY != null ? numY.intValue() : 0);
        }
        this.f10950V = iB;
        this.f10929G.o(ColorStateList.valueOf(iB));
        y1.j jVar3 = this.f10937K;
        if (jVar3 != null && this.f10939L != null) {
            if (this.f10947R > -1 && this.f10949U != 0) {
                jVar3.o(this.f10956e.isFocused() ? ColorStateList.valueOf(this.f10985v0) : ColorStateList.valueOf(this.f10949U));
                this.f10939L.o(ColorStateList.valueOf(this.f10949U));
            }
            invalidate();
        }
        u();
    }

    public final Rect d(Rect rect) {
        if (this.f10956e == null) {
            throw new IllegalStateException();
        }
        boolean z4 = getLayoutDirection() == 1;
        int i4 = rect.bottom;
        Rect rect2 = this.f10963k0;
        rect2.bottom = i4;
        int i5 = this.f10945P;
        if (i5 == 1) {
            rect2.left = i(rect.left, z4);
            rect2.top = rect.top + this.f10946Q;
            rect2.right = j(rect.right, z4);
            return rect2;
        }
        if (i5 != 2) {
            rect2.left = i(rect.left, z4);
            rect2.top = getPaddingTop();
            rect2.right = j(rect.right, z4);
            return rect2;
        }
        rect2.left = this.f10956e.getPaddingLeft() + rect.left;
        rect2.top = rect.top - e();
        rect2.right = rect.right - this.f10956e.getPaddingRight();
        return rect2;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchProvideAutofillStructure(ViewStructure viewStructure, int i4) {
        EditText editText = this.f10956e;
        if (editText == null) {
            super.dispatchProvideAutofillStructure(viewStructure, i4);
            return;
        }
        if (this.f10957f != null) {
            boolean z4 = this.f10927F;
            this.f10927F = false;
            CharSequence hint = editText.getHint();
            this.f10956e.setHint(this.f10957f);
            try {
                super.dispatchProvideAutofillStructure(viewStructure, i4);
                return;
            } finally {
                this.f10956e.setHint(hint);
                this.f10927F = z4;
            }
        }
        viewStructure.setAutofillId(getAutofillId());
        onProvideAutofillStructure(viewStructure, i4);
        onProvideAutofillVirtualStructure(viewStructure, i4);
        FrameLayout frameLayout = this.f10952a;
        viewStructure.setChildCount(frameLayout.getChildCount());
        for (int i5 = 0; i5 < frameLayout.getChildCount(); i5++) {
            View childAt = frameLayout.getChildAt(i5);
            ViewStructure viewStructureNewChild = viewStructure.newChild(i5);
            childAt.dispatchProvideAutofillStructure(viewStructureNewChild, i4);
            if (childAt == this.f10956e) {
                viewStructureNewChild.setHint(getHint());
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchRestoreInstanceState(SparseArray sparseArray) {
        this.f10940L0 = true;
        super.dispatchRestoreInstanceState(sparseArray);
        this.f10940L0 = false;
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        y1.j jVar;
        super.draw(canvas);
        boolean z4 = this.f10923D;
        com.google.android.material.internal.b bVar = this.f10930G0;
        if (z4) {
            bVar.getClass();
            int iSave = canvas.save();
            if (bVar.f10771C != null) {
                RectF rectF = bVar.f10802e;
                if (rectF.width() > Property.DEFAULT_FLOAT_VALUE && rectF.height() > Property.DEFAULT_FLOAT_VALUE) {
                    TextPaint textPaint = bVar.f10783O;
                    textPaint.setTextSize(bVar.f10775G);
                    float f4 = bVar.f10821q;
                    float f5 = bVar.f10822r;
                    float f6 = bVar.f10774F;
                    if (f6 != 1.0f) {
                        canvas.scale(f6, f6, f4, f5);
                    }
                    if ((bVar.f10803e0 > 1 || bVar.f10805f0 > 1) && !bVar.f10772D && bVar.o()) {
                        float lineStart = bVar.f10821q - bVar.f10793Z.getLineStart(0);
                        int alpha = textPaint.getAlpha();
                        canvas.translate(lineStart, f5);
                        float f7 = alpha;
                        textPaint.setAlpha((int) (bVar.f10799c0 * f7));
                        float f8 = bVar.f10776H;
                        float f9 = bVar.f10777I;
                        float f10 = bVar.f10778J;
                        int i4 = bVar.f10779K;
                        textPaint.setShadowLayer(f8, f9, f10, D.a.d(i4, (Color.alpha(i4) * textPaint.getAlpha()) / 255));
                        bVar.f10793Z.draw(canvas);
                        textPaint.setAlpha((int) (bVar.f10797b0 * f7));
                        float f11 = bVar.f10776H;
                        float f12 = bVar.f10777I;
                        float f13 = bVar.f10778J;
                        int i5 = bVar.f10779K;
                        textPaint.setShadowLayer(f11, f12, f13, D.a.d(i5, (Color.alpha(i5) * textPaint.getAlpha()) / 255));
                        int lineBaseline = bVar.f10793Z.getLineBaseline(0);
                        CharSequence charSequence = bVar.f10801d0;
                        float f14 = lineBaseline;
                        canvas.drawText(charSequence, 0, charSequence.length(), Property.DEFAULT_FLOAT_VALUE, f14, textPaint);
                        textPaint.setShadowLayer(bVar.f10776H, bVar.f10777I, bVar.f10778J, bVar.f10779K);
                        String strTrim = bVar.f10801d0.toString().trim();
                        if (strTrim.endsWith("…")) {
                            strTrim = strTrim.substring(0, strTrim.length() - 1);
                        }
                        String str = strTrim;
                        textPaint.setAlpha(alpha);
                        canvas.drawText(str, 0, Math.min(bVar.f10793Z.getLineEnd(0), str.length()), Property.DEFAULT_FLOAT_VALUE, f14, (Paint) textPaint);
                    } else {
                        canvas.translate(f4, f5);
                        bVar.f10793Z.draw(canvas);
                    }
                    canvas.restoreToCount(iSave);
                }
            }
        }
        if (this.f10939L == null || (jVar = this.f10937K) == null) {
            return;
        }
        jVar.draw(canvas);
        if (this.f10956e.isFocused()) {
            Rect bounds = this.f10939L.getBounds();
            Rect bounds2 = this.f10937K.getBounds();
            float f15 = bVar.f10796b;
            int iCenterX = bounds2.centerX();
            bounds.left = AbstractC0775a.c(f15, iCenterX, bounds2.left);
            bounds.right = AbstractC0775a.c(f15, iCenterX, bounds2.right);
            this.f10939L.draw(canvas);
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
            boolean r0 = r4.f10938K0
            if (r0 == 0) goto L5
            return
        L5:
            r0 = 1
            r4.f10938K0 = r0
            super.drawableStateChanged()
            int[] r1 = r4.getDrawableState()
            r2 = 0
            com.google.android.material.internal.b r3 = r4.f10930G0
            if (r3 == 0) goto L2f
            r3.f10781M = r1
            android.content.res.ColorStateList r1 = r3.f10814k
            if (r1 == 0) goto L20
            boolean r1 = r1.isStateful()
            if (r1 != 0) goto L2a
        L20:
            android.content.res.ColorStateList r1 = r3.f10812j
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
            android.widget.EditText r3 = r4.f10956e
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
            r4.f10938K0 = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.drawableStateChanged():void");
    }

    public final int e() {
        if (!this.f10923D) {
            return 0;
        }
        int i4 = this.f10945P;
        com.google.android.material.internal.b bVar = this.f10930G0;
        if (i4 == 0) {
            return (int) bVar.f();
        }
        if (i4 != 2) {
            return 0;
        }
        if (getHintMaxLines() == 1) {
            return (int) (bVar.f() / 2.0f);
        }
        float f4 = bVar.f();
        TextPaint textPaint = bVar.f10784P;
        textPaint.setTextSize(bVar.f10810i);
        textPaint.setTypeface(bVar.f10823s);
        textPaint.setLetterSpacing(bVar.f10790W);
        return Math.max(0, (int) (f4 - ((-textPaint.ascent()) / 2.0f)));
    }

    public final C0801g f() {
        C0801g c0801g = new C0801g();
        c0801g.f13712B = 3;
        c0801g.f13745c = com.stepos.statsrpk.c.L(getContext(), com.stepos.alphame.R.attr.motionDurationShort2, 87);
        c0801g.f13746d = com.stepos.statsrpk.c.M(getContext(), com.stepos.alphame.R.attr.motionEasingLinearInterpolator, AbstractC0775a.f13650a);
        return c0801g;
    }

    public final boolean g() {
        return this.f10923D && !TextUtils.isEmpty(this.f10925E) && (this.f10929G instanceof g);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public int getBaseline() {
        EditText editText = this.f10956e;
        if (editText == null) {
            return super.getBaseline();
        }
        return e() + getPaddingTop() + editText.getBaseline();
    }

    @NonNull
    public y1.j getBoxBackground() {
        int i4 = this.f10945P;
        if (i4 == 1 || i4 == 2) {
            return this.f10929G;
        }
        throw new IllegalStateException();
    }

    public int getBoxBackgroundColor() {
        return this.f10950V;
    }

    public int getBoxBackgroundMode() {
        return this.f10945P;
    }

    public int getBoxCollapsedPaddingTop() {
        return this.f10946Q;
    }

    public float getBoxCornerRadiusBottomEnd() {
        int layoutDirection = getLayoutDirection();
        RectF rectF = this.f10965l0;
        return layoutDirection == 1 ? this.f10941M.f16279h.a(rectF) : this.f10941M.f16278g.a(rectF);
    }

    public float getBoxCornerRadiusBottomStart() {
        int layoutDirection = getLayoutDirection();
        RectF rectF = this.f10965l0;
        return layoutDirection == 1 ? this.f10941M.f16278g.a(rectF) : this.f10941M.f16279h.a(rectF);
    }

    public float getBoxCornerRadiusTopEnd() {
        int layoutDirection = getLayoutDirection();
        RectF rectF = this.f10965l0;
        return layoutDirection == 1 ? this.f10941M.f16276e.a(rectF) : this.f10941M.f16277f.a(rectF);
    }

    public float getBoxCornerRadiusTopStart() {
        int layoutDirection = getLayoutDirection();
        RectF rectF = this.f10965l0;
        return layoutDirection == 1 ? this.f10941M.f16277f.a(rectF) : this.f10941M.f16276e.a(rectF);
    }

    public int getBoxStrokeColor() {
        return this.f10989x0;
    }

    @Nullable
    public ColorStateList getBoxStrokeErrorColor() {
        return this.f10991y0;
    }

    public int getBoxStrokeWidth() {
        return this.f10948S;
    }

    public int getBoxStrokeWidthFocused() {
        return this.T;
    }

    public int getCounterMaxLength() {
        return this.f10966m;
    }

    @Nullable
    public CharSequence getCounterOverflowDescription() {
        C0200f0 c0200f0;
        if (this.f10964l && this.f10968n && (c0200f0 = this.f10972p) != null) {
            return c0200f0.getContentDescription();
        }
        return null;
    }

    @Nullable
    public ColorStateList getCounterOverflowTextColor() {
        return this.f10917A;
    }

    @Nullable
    public ColorStateList getCounterTextColor() {
        return this.f10992z;
    }

    @Nullable
    @RequiresApi(29)
    public ColorStateList getCursorColor() {
        return this.f10919B;
    }

    @Nullable
    @RequiresApi(29)
    public ColorStateList getCursorErrorColor() {
        return this.f10921C;
    }

    @Nullable
    public ColorStateList getDefaultHintTextColor() {
        return this.f10981t0;
    }

    @Nullable
    public EditText getEditText() {
        return this.f10956e;
    }

    @Nullable
    public CharSequence getEndIconContentDescription() {
        return this.f10954c.f11041g.getContentDescription();
    }

    @Nullable
    public Drawable getEndIconDrawable() {
        return this.f10954c.f11041g.getDrawable();
    }

    public int getEndIconMinSize() {
        return this.f10954c.f11047m;
    }

    public int getEndIconMode() {
        return this.f10954c.f11043i;
    }

    @NonNull
    public ImageView.ScaleType getEndIconScaleType() {
        return this.f10954c.f11048n;
    }

    @NonNull
    public CheckableImageButton getEndIconView() {
        return this.f10954c.f11041g;
    }

    @Nullable
    public CharSequence getError() {
        r rVar = this.f10962k;
        if (rVar.f11085q) {
            return rVar.f11084p;
        }
        return null;
    }

    public int getErrorAccessibilityLiveRegion() {
        return this.f10962k.f11088t;
    }

    @Nullable
    public CharSequence getErrorContentDescription() {
        return this.f10962k.f11087s;
    }

    @ColorInt
    public int getErrorCurrentTextColors() {
        C0200f0 c0200f0 = this.f10962k.f11086r;
        if (c0200f0 != null) {
            return c0200f0.getCurrentTextColor();
        }
        return -1;
    }

    @Nullable
    public Drawable getErrorIconDrawable() {
        return this.f10954c.f11037c.getDrawable();
    }

    @Nullable
    public CharSequence getHelperText() {
        r rVar = this.f10962k;
        if (rVar.f11092x) {
            return rVar.f11091w;
        }
        return null;
    }

    @ColorInt
    public int getHelperTextCurrentTextColor() {
        C0200f0 c0200f0 = this.f10962k.f11093y;
        if (c0200f0 != null) {
            return c0200f0.getCurrentTextColor();
        }
        return -1;
    }

    @Nullable
    public CharSequence getHint() {
        if (this.f10923D) {
            return this.f10925E;
        }
        return null;
    }

    @VisibleForTesting
    public final float getHintCollapsedTextHeight() {
        return this.f10930G0.f();
    }

    @VisibleForTesting
    public final int getHintCurrentCollapsedTextColor() {
        com.google.android.material.internal.b bVar = this.f10930G0;
        return bVar.g(bVar.f10814k);
    }

    public int getHintMaxLines() {
        return this.f10930G0.f10803e0;
    }

    @Nullable
    public ColorStateList getHintTextColor() {
        return this.f10983u0;
    }

    @NonNull
    public z getLengthCounter() {
        return this.f10970o;
    }

    public int getMaxEms() {
        return this.f10959h;
    }

    @Px
    public int getMaxWidth() {
        return this.f10961j;
    }

    public int getMinEms() {
        return this.f10958g;
    }

    @Px
    public int getMinWidth() {
        return this.f10960i;
    }

    @Nullable
    @Deprecated
    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.f10954c.f11041g.getContentDescription();
    }

    @Nullable
    @Deprecated
    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.f10954c.f11041g.getDrawable();
    }

    @Nullable
    public CharSequence getPlaceholderText() {
        if (this.f10980t) {
            return this.f10978s;
        }
        return null;
    }

    @StyleRes
    public int getPlaceholderTextAppearance() {
        return this.f10986w;
    }

    @Nullable
    public ColorStateList getPlaceholderTextColor() {
        return this.f10984v;
    }

    @Nullable
    public CharSequence getPrefixText() {
        return this.f10953b.f11112c;
    }

    @Nullable
    public ColorStateList getPrefixTextColor() {
        return this.f10953b.f11111b.getTextColors();
    }

    @NonNull
    public TextView getPrefixTextView() {
        return this.f10953b.f11111b;
    }

    @NonNull
    public y1.n getShapeAppearanceModel() {
        return this.f10941M;
    }

    @Nullable
    public CharSequence getStartIconContentDescription() {
        return this.f10953b.f11113d.getContentDescription();
    }

    @Nullable
    public Drawable getStartIconDrawable() {
        return this.f10953b.f11113d.getDrawable();
    }

    public int getStartIconMinSize() {
        return this.f10953b.f11116g;
    }

    @NonNull
    public ImageView.ScaleType getStartIconScaleType() {
        return this.f10953b.f11117h;
    }

    @Nullable
    public CharSequence getSuffixText() {
        return this.f10954c.f11050p;
    }

    @Nullable
    public ColorStateList getSuffixTextColor() {
        return this.f10954c.f11051q.getTextColors();
    }

    @NonNull
    public TextView getSuffixTextView() {
        return this.f10954c.f11051q;
    }

    @Nullable
    public Typeface getTypeface() {
        return this.f10967m0;
    }

    public final y1.j h(boolean z4) throws Resources.NotFoundException {
        float dimensionPixelOffset = getResources().getDimensionPixelOffset(com.stepos.alphame.R.dimen.mtrl_shape_corner_size_small_component);
        float f4 = z4 ? dimensionPixelOffset : Property.DEFAULT_FLOAT_VALUE;
        EditText editText = this.f10956e;
        float popupElevation = editText instanceof u ? ((u) editText).getPopupElevation() : getResources().getDimensionPixelOffset(com.stepos.alphame.R.dimen.m3_comp_outlined_autocomplete_menu_container_elevation);
        int dimensionPixelOffset2 = getResources().getDimensionPixelOffset(com.stepos.alphame.R.dimen.mtrl_exposed_dropdown_menu_popup_vertical_padding);
        y1.l lVar = new y1.l();
        y1.l lVar2 = new y1.l();
        y1.l lVar3 = new y1.l();
        y1.l lVar4 = new y1.l();
        y1.f fVarN = B0.f.n();
        y1.f fVarN2 = B0.f.n();
        y1.f fVarN3 = B0.f.n();
        y1.f fVarN4 = B0.f.n();
        C0987a c0987a = new C0987a(f4);
        C0987a c0987a2 = new C0987a(f4);
        C0987a c0987a3 = new C0987a(dimensionPixelOffset);
        C0987a c0987a4 = new C0987a(dimensionPixelOffset);
        y1.n nVar = new y1.n();
        nVar.f16272a = lVar;
        nVar.f16273b = lVar2;
        nVar.f16274c = lVar3;
        nVar.f16275d = lVar4;
        nVar.f16276e = c0987a;
        nVar.f16277f = c0987a2;
        nVar.f16278g = c0987a4;
        nVar.f16279h = c0987a3;
        nVar.f16280i = fVarN;
        nVar.f16281j = fVarN2;
        nVar.f16282k = fVarN3;
        nVar.f16283l = fVarN4;
        EditText editText2 = this.f10956e;
        ColorStateList dropDownBackgroundTintList = editText2 instanceof u ? ((u) editText2).getDropDownBackgroundTintList() : null;
        Context context = getContext();
        if (dropDownBackgroundTintList == null) {
            Paint paint = y1.j.f16226F;
            TypedValue typedValueY = AbstractC0557a.Y(context, y1.j.class.getSimpleName(), com.stepos.alphame.R.attr.colorSurface);
            int i4 = typedValueY.resourceId;
            dropDownBackgroundTintList = ColorStateList.valueOf(i4 != 0 ? androidx.core.content.b.a(context, i4) : typedValueY.data);
        }
        y1.j jVar = new y1.j();
        jVar.l(context);
        jVar.o(dropDownBackgroundTintList);
        jVar.n(popupElevation);
        jVar.setShapeAppearanceModel(nVar);
        y1.h hVar = jVar.f16234b;
        if (hVar.f16211i == null) {
            hVar.f16211i = new Rect();
        }
        jVar.f16234b.f16211i.set(0, dimensionPixelOffset2, 0, dimensionPixelOffset2);
        jVar.invalidateSelf();
        return jVar;
    }

    public final int i(int i4, boolean z4) {
        return ((z4 || getPrefixText() == null) ? (!z4 || getSuffixText() == null) ? this.f10956e.getCompoundPaddingLeft() : this.f10954c.c() : this.f10953b.a()) + i4;
    }

    public final int j(int i4, boolean z4) {
        return i4 - ((z4 || getSuffixText() == null) ? (!z4 || getPrefixText() == null) ? this.f10956e.getCompoundPaddingRight() : this.f10953b.a() : this.f10954c.c());
    }

    public final void k() throws Resources.NotFoundException {
        int i4 = this.f10945P;
        if (i4 == 0) {
            this.f10929G = null;
            this.f10937K = null;
            this.f10939L = null;
        } else if (i4 == 1) {
            this.f10929G = new y1.j(this.f10941M);
            this.f10937K = new y1.j();
            this.f10939L = new y1.j();
        } else {
            if (i4 != 2) {
                throw new IllegalArgumentException(AbstractC0831a.d(new StringBuilder(), this.f10945P, " is illegal; only @BoxBackgroundMode constants are supported."));
            }
            if (!this.f10923D || (this.f10929G instanceof g)) {
                this.f10929G = new y1.j(this.f10941M);
            } else {
                y1.n nVar = this.f10941M;
                int i5 = g.f11013I;
                if (nVar == null) {
                    nVar = new y1.n();
                }
                f fVar = new f(nVar, new RectF());
                g gVar = new g(fVar);
                gVar.f11014H = fVar;
                this.f10929G = gVar;
            }
            this.f10937K = null;
            this.f10939L = null;
        }
        u();
        z();
        if (this.f10945P == 1) {
            if (getContext().getResources().getConfiguration().fontScale >= 2.0f) {
                this.f10946Q = getResources().getDimensionPixelSize(com.stepos.alphame.R.dimen.material_font_2_0_box_collapsed_padding_top);
            } else if (B0.f.Q(getContext())) {
                this.f10946Q = getResources().getDimensionPixelSize(com.stepos.alphame.R.dimen.material_font_1_3_box_collapsed_padding_top);
            }
        }
        a();
        if (this.f10945P != 0) {
            v();
        }
        EditText editText = this.f10956e;
        if (editText instanceof AutoCompleteTextView) {
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) editText;
            if (autoCompleteTextView.getDropDownBackground() == null) {
                int i6 = this.f10945P;
                if (i6 == 2) {
                    autoCompleteTextView.setDropDownBackgroundDrawable(getOrCreateOutlinedDropDownMenuBackground());
                } else if (i6 == 1) {
                    autoCompleteTextView.setDropDownBackgroundDrawable(getOrCreateFilledDropDownMenuBackground());
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00cb  */
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

    public final void n(TextView textView, int i4) {
        try {
            textView.setTextAppearance(i4);
            if (textView.getTextColors().getDefaultColor() != -65281) {
                return;
            }
        } catch (Exception unused) {
        }
        textView.setTextAppearance(com.stepos.alphame.R.style.TextAppearance_AppCompat_Caption);
        textView.setTextColor(androidx.core.content.b.a(getContext(), com.stepos.alphame.R.color.design_error));
    }

    public final boolean o() {
        r rVar = this.f10962k;
        return (rVar.f11083o != 1 || rVar.f11086r == null || TextUtils.isEmpty(rVar.f11084p)) ? false : true;
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f10930G0.i(configuration);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        int iMax;
        n nVar = this.f10954c;
        nVar.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        boolean z4 = false;
        this.f10942M0 = false;
        if (this.f10956e != null && this.f10956e.getMeasuredHeight() < (iMax = Math.max(nVar.getMeasuredHeight(), this.f10953b.getMeasuredHeight()))) {
            this.f10956e.setMinimumHeight(iMax);
            z4 = true;
        }
        boolean zS = s();
        if (z4 || zS) {
            this.f10956e.post(new androidx.activity.d(16, this));
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z4, int i4, int i5, int i6, int i7) {
        float fDescent;
        int i8;
        int compoundPaddingTop;
        super.onLayout(z4, i4, i5, i6, i7);
        EditText editText = this.f10956e;
        if (editText != null) {
            Rect rect = this.f10951W;
            com.google.android.material.internal.c.a(this, editText, rect);
            y1.j jVar = this.f10937K;
            if (jVar != null) {
                int i9 = rect.bottom;
                jVar.setBounds(rect.left, i9 - this.f10948S, rect.right, i9);
            }
            y1.j jVar2 = this.f10939L;
            if (jVar2 != null) {
                int i10 = rect.bottom;
                jVar2.setBounds(rect.left, i10 - this.T, rect.right, i10);
            }
            if (this.f10923D) {
                float textSize = this.f10956e.getTextSize();
                com.google.android.material.internal.b bVar = this.f10930G0;
                if (bVar.f10808h != textSize) {
                    bVar.f10808h = textSize;
                    bVar.j(false);
                }
                int gravity = this.f10956e.getGravity();
                int i11 = (gravity & (-113)) | 48;
                if (bVar.f10806g != i11) {
                    bVar.f10806g = i11;
                    bVar.j(false);
                }
                if (bVar.f10804f != gravity) {
                    bVar.f10804f = gravity;
                    bVar.j(false);
                }
                Rect rectD = d(rect);
                int i12 = rectD.left;
                int i13 = rectD.top;
                int i14 = rectD.right;
                int i15 = rectD.bottom;
                Rect rect2 = bVar.f10800d;
                if (rect2.left != i12 || rect2.top != i13 || rect2.right != i14 || rect2.bottom != i15) {
                    rect2.set(i12, i13, i14, i15);
                    bVar.f10782N = true;
                }
                if (this.f10956e == null) {
                    throw new IllegalStateException();
                }
                int hintMaxLines = getHintMaxLines();
                TextPaint textPaint = bVar.f10784P;
                if (hintMaxLines == 1) {
                    textPaint.setTextSize(bVar.f10808h);
                    textPaint.setTypeface(bVar.f10826v);
                    textPaint.setLetterSpacing(bVar.f10791X);
                    fDescent = -textPaint.ascent();
                } else {
                    textPaint.setTextSize(bVar.f10808h);
                    textPaint.setTypeface(bVar.f10826v);
                    textPaint.setLetterSpacing(bVar.f10791X);
                    fDescent = bVar.f10816l * (textPaint.descent() + (-textPaint.ascent()));
                }
                int compoundPaddingLeft = this.f10956e.getCompoundPaddingLeft() + rect.left;
                Rect rect3 = this.f10963k0;
                rect3.left = compoundPaddingLeft;
                if (this.f10945P == 1 && this.f10956e.getMinLines() <= 1) {
                    compoundPaddingTop = (int) (rect.centerY() - (fDescent / 2.0f));
                } else {
                    if (this.f10945P != 0 || getHintMaxLines() == 1) {
                        i8 = 0;
                    } else {
                        textPaint.setTextSize(bVar.f10808h);
                        textPaint.setTypeface(bVar.f10826v);
                        textPaint.setLetterSpacing(bVar.f10791X);
                        i8 = (int) ((-textPaint.ascent()) / 2.0f);
                    }
                    compoundPaddingTop = (this.f10956e.getCompoundPaddingTop() + rect.top) - i8;
                }
                rect3.top = compoundPaddingTop;
                rect3.right = rect.right - this.f10956e.getCompoundPaddingRight();
                int compoundPaddingBottom = (this.f10945P != 1 || this.f10956e.getMinLines() > 1) ? rect.bottom - this.f10956e.getCompoundPaddingBottom() : (int) (rect3.top + fDescent);
                rect3.bottom = compoundPaddingBottom;
                int i16 = rect3.left;
                int i17 = rect3.top;
                int i18 = rect3.right;
                Rect rect4 = bVar.f10798c;
                if (!(rect4.left == i16 && rect4.top == i17 && rect4.right == i18 && rect4.bottom == compoundPaddingBottom) || true != bVar.f10815k0) {
                    rect4.set(i16, i17, i18, compoundPaddingBottom);
                    bVar.f10782N = true;
                    bVar.f10815k0 = true;
                }
                bVar.j(false);
                if (!g() || this.f10928F0) {
                    return;
                }
                l();
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i4, int i5) {
        float f4;
        EditText editText;
        super.onMeasure(i4, i5);
        boolean z4 = this.f10942M0;
        n nVar = this.f10954c;
        if (!z4) {
            nVar.getViewTreeObserver().addOnGlobalLayoutListener(this);
            this.f10942M0 = true;
        }
        if (this.f10982u != null && (editText = this.f10956e) != null) {
            this.f10982u.setGravity(editText.getGravity());
            this.f10982u.setPadding(this.f10956e.getCompoundPaddingLeft(), this.f10956e.getCompoundPaddingTop(), this.f10956e.getCompoundPaddingRight(), this.f10956e.getCompoundPaddingBottom());
        }
        nVar.m();
        if (getHintMaxLines() == 1) {
            return;
        }
        int measuredWidth = (this.f10956e.getMeasuredWidth() - this.f10956e.getCompoundPaddingLeft()) - this.f10956e.getCompoundPaddingRight();
        com.google.android.material.internal.b bVar = this.f10930G0;
        TextPaint textPaint = bVar.f10784P;
        textPaint.setTextSize(bVar.f10810i);
        textPaint.setTypeface(bVar.f10823s);
        textPaint.setLetterSpacing(bVar.f10790W);
        float f5 = measuredWidth;
        bVar.f10811i0 = bVar.e(bVar.f10805f0, textPaint, bVar.f10770B, (bVar.f10810i / bVar.f10808h) * f5, bVar.f10772D).getHeight();
        textPaint.setTextSize(bVar.f10808h);
        textPaint.setTypeface(bVar.f10826v);
        textPaint.setLetterSpacing(bVar.f10791X);
        bVar.f10813j0 = bVar.e(bVar.f10803e0, textPaint, bVar.f10770B, f5, bVar.f10772D).getHeight();
        EditText editText2 = this.f10956e;
        Rect rect = this.f10951W;
        com.google.android.material.internal.c.a(this, editText2, rect);
        Rect rectD = d(rect);
        int i6 = rectD.left;
        int i7 = rectD.top;
        int i8 = rectD.right;
        int i9 = rectD.bottom;
        Rect rect2 = bVar.f10800d;
        if (rect2.left != i6 || rect2.top != i7 || rect2.right != i8 || rect2.bottom != i9) {
            rect2.set(i6, i7, i8, i9);
            bVar.f10782N = true;
        }
        v();
        a();
        if (this.f10956e == null) {
            return;
        }
        int i10 = bVar.f10813j0;
        if (i10 != -1) {
            f4 = i10;
        } else {
            TextPaint textPaint2 = bVar.f10784P;
            textPaint2.setTextSize(bVar.f10808h);
            textPaint2.setTypeface(bVar.f10826v);
            textPaint2.setLetterSpacing(bVar.f10791X);
            f4 = -textPaint2.ascent();
        }
        CharSequence charSequence = this.f10978s;
        float height = Property.DEFAULT_FLOAT_VALUE;
        if (charSequence != null) {
            TextPaint textPaint3 = new TextPaint(129);
            textPaint3.set(this.f10982u.getPaint());
            textPaint3.setTextSize(this.f10982u.getTextSize());
            textPaint3.setTypeface(this.f10982u.getTypeface());
            textPaint3.setLetterSpacing(this.f10982u.getLetterSpacing());
            com.google.android.material.internal.h hVar = new com.google.android.material.internal.h(this.f10978s, textPaint3, measuredWidth);
            hVar.f10850k = getLayoutDirection() == 1;
            hVar.f10849j = true;
            float lineSpacingExtra = this.f10982u.getLineSpacingExtra();
            float lineSpacingMultiplier = this.f10982u.getLineSpacingMultiplier();
            hVar.f10846g = lineSpacingExtra;
            hVar.f10847h = lineSpacingMultiplier;
            hVar.f10852m = new androidx.core.app.f(this);
            StaticLayout staticLayoutA = hVar.a();
            if (this.f10945P == 1) {
                height = bVar.f() + this.f10946Q + this.f10955d;
            }
            height += staticLayoutA.getHeight();
        }
        float fMax = Math.max(f4, height);
        if (this.f10956e.getMeasuredHeight() < fMax) {
            this.f10956e.setMinimumHeight(Math.round(fMax));
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
        setError(savedState.f10994a);
        if (savedState.f10995b) {
            post(new RunnableC0583a(14, this));
        }
        requestLayout();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onRtlPropertiesChanged(int i4) {
        super.onRtlPropertiesChanged(i4);
        boolean z4 = i4 == 1;
        if (z4 != this.f10943N) {
            InterfaceC0990d interfaceC0990d = this.f10941M.f16276e;
            RectF rectF = this.f10965l0;
            float fA = interfaceC0990d.a(rectF);
            float fA2 = this.f10941M.f16277f.a(rectF);
            float fA3 = this.f10941M.f16279h.a(rectF);
            float fA4 = this.f10941M.f16278g.a(rectF);
            y1.n nVar = this.f10941M;
            B0.f fVar = nVar.f16272a;
            B0.f fVar2 = nVar.f16273b;
            B0.f fVar3 = nVar.f16275d;
            B0.f fVar4 = nVar.f16274c;
            y1.f fVarN = B0.f.n();
            y1.f fVarN2 = B0.f.n();
            y1.f fVarN3 = B0.f.n();
            y1.f fVarN4 = B0.f.n();
            y1.m.b(fVar2);
            y1.m.b(fVar);
            y1.m.b(fVar4);
            y1.m.b(fVar3);
            C0987a c0987a = new C0987a(fA2);
            C0987a c0987a2 = new C0987a(fA);
            C0987a c0987a3 = new C0987a(fA4);
            C0987a c0987a4 = new C0987a(fA3);
            y1.n nVar2 = new y1.n();
            nVar2.f16272a = fVar2;
            nVar2.f16273b = fVar;
            nVar2.f16274c = fVar3;
            nVar2.f16275d = fVar4;
            nVar2.f16276e = c0987a;
            nVar2.f16277f = c0987a2;
            nVar2.f16278g = c0987a4;
            nVar2.f16279h = c0987a3;
            nVar2.f16280i = fVarN;
            nVar2.f16281j = fVarN2;
            nVar2.f16282k = fVarN3;
            nVar2.f16283l = fVarN4;
            this.f10943N = z4;
            setShapeAppearanceModel(nVar2);
        }
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (o()) {
            savedState.f10994a = getError();
        }
        n nVar = this.f10954c;
        savedState.f10995b = nVar.f11043i != 0 && nVar.f11041g.f10751d;
        return savedState;
    }

    public final void p(Editable editable) throws Resources.NotFoundException {
        ((C0073e) this.f10970o).getClass();
        int length = editable != null ? editable.length() : 0;
        boolean z4 = this.f10968n;
        int i4 = this.f10966m;
        String string = null;
        if (i4 == -1) {
            this.f10972p.setText(String.valueOf(length));
            this.f10972p.setContentDescription(null);
            this.f10968n = false;
        } else {
            this.f10968n = length > i4;
            Context context = getContext();
            this.f10972p.setContentDescription(context.getString(this.f10968n ? com.stepos.alphame.R.string.character_counter_overflowed_content_description : com.stepos.alphame.R.string.character_counter_content_description, Integer.valueOf(length), Integer.valueOf(this.f10966m)));
            if (z4 != this.f10968n) {
                q();
            }
            String str = I.b.f812d;
            I.b bVar = TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1 ? I.b.f815g : I.b.f814f;
            C0200f0 c0200f0 = this.f10972p;
            String string2 = getContext().getString(com.stepos.alphame.R.string.character_counter_pattern, Integer.valueOf(length), Integer.valueOf(this.f10966m));
            if (string2 == null) {
                bVar.getClass();
            } else {
                string = bVar.c(string2, bVar.f818c).toString();
            }
            c0200f0.setText(string);
        }
        if (this.f10956e == null || z4 == this.f10968n) {
            return;
        }
        w(false, false);
        z();
        t();
    }

    public final void q() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        C0200f0 c0200f0 = this.f10972p;
        if (c0200f0 != null) {
            n(c0200f0, this.f10968n ? this.f10974q : this.f10976r);
            if (!this.f10968n && (colorStateList2 = this.f10992z) != null) {
                this.f10972p.setTextColor(colorStateList2);
            }
            if (!this.f10968n || (colorStateList = this.f10917A) == null) {
                return;
            }
            this.f10972p.setTextColor(colorStateList);
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
            android.content.res.ColorStateList r0 = r4.f10919B
            if (r0 == 0) goto L5
            goto L26
        L5:
            android.content.Context r0 = r4.getContext()
            r1 = 2130968918(0x7f040156, float:1.7546503E38)
            android.util.TypedValue r1 = f1.AbstractC0557a.V(r1, r0)
            r2 = 0
            if (r1 != 0) goto L15
        L13:
            r0 = r2
            goto L26
        L15:
            int r3 = r1.resourceId
            if (r3 == 0) goto L1e
            android.content.res.ColorStateList r0 = B0.f.x(r3, r0)
            goto L26
        L1e:
            int r0 = r1.data
            if (r0 == 0) goto L13
            android.content.res.ColorStateList r0 = android.content.res.ColorStateList.valueOf(r0)
        L26:
            android.widget.EditText r1 = r4.f10956e
            if (r1 == 0) goto L51
            android.graphics.drawable.Drawable r1 = r1.getTextCursorDrawable()
            if (r1 != 0) goto L31
            goto L51
        L31:
            android.widget.EditText r1 = r4.f10956e
            android.graphics.drawable.Drawable r1 = r1.getTextCursorDrawable()
            android.graphics.drawable.Drawable r1 = r1.mutate()
            boolean r2 = r4.o()
            if (r2 != 0) goto L49
            androidx.appcompat.widget.f0 r2 = r4.f10972p
            if (r2 == 0) goto L4e
            boolean r2 = r4.f10968n
            if (r2 == 0) goto L4e
        L49:
            android.content.res.ColorStateList r4 = r4.f10921C
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
            Method dump skipped, instructions count: 307
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.s():boolean");
    }

    public void setBoxBackgroundColor(@ColorInt int i4) {
        if (this.f10950V != i4) {
            this.f10950V = i4;
            this.f10993z0 = i4;
            this.f10920B0 = i4;
            this.f10922C0 = i4;
            c();
        }
    }

    public void setBoxBackgroundColorResource(@ColorRes int i4) {
        setBoxBackgroundColor(androidx.core.content.b.a(getContext(), i4));
    }

    public void setBoxBackgroundColorStateList(@NonNull ColorStateList colorStateList) {
        int defaultColor = colorStateList.getDefaultColor();
        this.f10993z0 = defaultColor;
        this.f10950V = defaultColor;
        this.f10918A0 = colorStateList.getColorForState(new int[]{-16842910}, -1);
        this.f10920B0 = colorStateList.getColorForState(new int[]{R.attr.state_focused, R.attr.state_enabled}, -1);
        this.f10922C0 = colorStateList.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, -1);
        c();
    }

    public void setBoxBackgroundMode(int i4) throws Resources.NotFoundException {
        if (i4 == this.f10945P) {
            return;
        }
        this.f10945P = i4;
        if (this.f10956e != null) {
            k();
        }
    }

    public void setBoxCollapsedPaddingTop(int i4) {
        this.f10946Q = i4;
    }

    public void setBoxCornerFamily(int i4) {
        y1.m mVarF = this.f10941M.f();
        InterfaceC0990d interfaceC0990d = this.f10941M.f16276e;
        B0.f fVarM = B0.f.m(i4);
        mVarF.f16260a = fVarM;
        y1.m.b(fVarM);
        mVarF.f16264e = interfaceC0990d;
        InterfaceC0990d interfaceC0990d2 = this.f10941M.f16277f;
        B0.f fVarM2 = B0.f.m(i4);
        mVarF.f16261b = fVarM2;
        y1.m.b(fVarM2);
        mVarF.f16265f = interfaceC0990d2;
        InterfaceC0990d interfaceC0990d3 = this.f10941M.f16279h;
        B0.f fVarM3 = B0.f.m(i4);
        mVarF.f16263d = fVarM3;
        y1.m.b(fVarM3);
        mVarF.f16267h = interfaceC0990d3;
        InterfaceC0990d interfaceC0990d4 = this.f10941M.f16278g;
        B0.f fVarM4 = B0.f.m(i4);
        mVarF.f16262c = fVarM4;
        y1.m.b(fVarM4);
        mVarF.f16266g = interfaceC0990d4;
        this.f10941M = mVarF.a();
        c();
    }

    public void setBoxStrokeColor(@ColorInt int i4) throws Resources.NotFoundException {
        if (this.f10989x0 != i4) {
            this.f10989x0 = i4;
            z();
        }
    }

    public void setBoxStrokeColorStateList(@NonNull ColorStateList colorStateList) throws Resources.NotFoundException {
        if (colorStateList.isStateful()) {
            this.f10985v0 = colorStateList.getDefaultColor();
            this.f10924D0 = colorStateList.getColorForState(new int[]{-16842910}, -1);
            this.f10987w0 = colorStateList.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, -1);
            this.f10989x0 = colorStateList.getColorForState(new int[]{R.attr.state_focused, R.attr.state_enabled}, -1);
        } else if (this.f10989x0 != colorStateList.getDefaultColor()) {
            this.f10989x0 = colorStateList.getDefaultColor();
        }
        z();
    }

    public void setBoxStrokeErrorColor(@Nullable ColorStateList colorStateList) throws Resources.NotFoundException {
        if (this.f10991y0 != colorStateList) {
            this.f10991y0 = colorStateList;
            z();
        }
    }

    public void setBoxStrokeWidth(int i4) throws Resources.NotFoundException {
        this.f10948S = i4;
        z();
    }

    public void setBoxStrokeWidthFocused(int i4) throws Resources.NotFoundException {
        this.T = i4;
        z();
    }

    public void setBoxStrokeWidthFocusedResource(@DimenRes int i4) throws Resources.NotFoundException {
        setBoxStrokeWidthFocused(getResources().getDimensionPixelSize(i4));
    }

    public void setBoxStrokeWidthResource(@DimenRes int i4) throws Resources.NotFoundException {
        setBoxStrokeWidth(getResources().getDimensionPixelSize(i4));
    }

    public void setCounterEnabled(boolean z4) throws Resources.NotFoundException {
        if (this.f10964l != z4) {
            r rVar = this.f10962k;
            if (z4) {
                C0200f0 c0200f0 = new C0200f0(getContext(), null);
                this.f10972p = c0200f0;
                c0200f0.setId(com.stepos.alphame.R.id.textinput_counter);
                Typeface typeface = this.f10967m0;
                if (typeface != null) {
                    this.f10972p.setTypeface(typeface);
                }
                this.f10972p.setMaxLines(1);
                rVar.a(this.f10972p, 2);
                ((ViewGroup.MarginLayoutParams) this.f10972p.getLayoutParams()).setMarginStart(getResources().getDimensionPixelOffset(com.stepos.alphame.R.dimen.mtrl_textinput_counter_margin_start));
                q();
                if (this.f10972p != null) {
                    EditText editText = this.f10956e;
                    p(editText != null ? editText.getText() : null);
                }
            } else {
                rVar.g(this.f10972p, 2);
                this.f10972p = null;
            }
            this.f10964l = z4;
        }
    }

    public void setCounterMaxLength(int i4) throws Resources.NotFoundException {
        if (this.f10966m != i4) {
            if (i4 > 0) {
                this.f10966m = i4;
            } else {
                this.f10966m = -1;
            }
            if (!this.f10964l || this.f10972p == null) {
                return;
            }
            EditText editText = this.f10956e;
            p(editText == null ? null : editText.getText());
        }
    }

    public void setCounterOverflowTextAppearance(int i4) {
        if (this.f10974q != i4) {
            this.f10974q = i4;
            q();
        }
    }

    public void setCounterOverflowTextColor(@Nullable ColorStateList colorStateList) {
        if (this.f10917A != colorStateList) {
            this.f10917A = colorStateList;
            q();
        }
    }

    public void setCounterTextAppearance(int i4) {
        if (this.f10976r != i4) {
            this.f10976r = i4;
            q();
        }
    }

    public void setCounterTextColor(@Nullable ColorStateList colorStateList) {
        if (this.f10992z != colorStateList) {
            this.f10992z = colorStateList;
            q();
        }
    }

    @RequiresApi(29)
    public void setCursorColor(@Nullable ColorStateList colorStateList) throws Resources.NotFoundException {
        if (this.f10919B != colorStateList) {
            this.f10919B = colorStateList;
            r();
        }
    }

    @RequiresApi(29)
    public void setCursorErrorColor(@Nullable ColorStateList colorStateList) throws Resources.NotFoundException {
        if (this.f10921C != colorStateList) {
            this.f10921C = colorStateList;
            if (o() || (this.f10972p != null && this.f10968n)) {
                r();
            }
        }
    }

    public void setDefaultHintTextColor(@Nullable ColorStateList colorStateList) {
        this.f10981t0 = colorStateList;
        this.f10983u0 = colorStateList;
        if (this.f10956e != null) {
            w(false, false);
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z4) {
        m(this, z4);
        super.setEnabled(z4);
    }

    public void setEndIconActivated(boolean z4) {
        this.f10954c.f11041g.setActivated(z4);
    }

    public void setEndIconCheckable(boolean z4) {
        this.f10954c.f11041g.setCheckable(z4);
    }

    public void setEndIconContentDescription(@StringRes int i4) {
        n nVar = this.f10954c;
        CharSequence text = i4 != 0 ? nVar.getResources().getText(i4) : null;
        CheckableImageButton checkableImageButton = nVar.f11041g;
        if (checkableImageButton.getContentDescription() != text) {
            checkableImageButton.setContentDescription(text);
        }
    }

    public void setEndIconDrawable(@DrawableRes int i4) {
        n nVar = this.f10954c;
        Drawable drawableO = i4 != 0 ? I.o(nVar.getContext(), i4) : null;
        CheckableImageButton checkableImageButton = nVar.f11041g;
        checkableImageButton.setImageDrawable(drawableO);
        if (drawableO != null) {
            ColorStateList colorStateList = nVar.f11045k;
            PorterDuff.Mode mode = nVar.f11046l;
            TextInputLayout textInputLayout = nVar.f11035a;
            com.stepos.statsrpk.c.e(textInputLayout, checkableImageButton, colorStateList, mode);
            com.stepos.statsrpk.c.I(textInputLayout, checkableImageButton, nVar.f11045k);
        }
    }

    public void setEndIconMinSize(@IntRange(from = 0) int i4) {
        n nVar = this.f10954c;
        if (i4 < 0) {
            nVar.getClass();
            throw new IllegalArgumentException("endIconSize cannot be less than 0");
        }
        if (i4 != nVar.f11047m) {
            nVar.f11047m = i4;
            CheckableImageButton checkableImageButton = nVar.f11041g;
            checkableImageButton.setMinimumWidth(i4);
            checkableImageButton.setMinimumHeight(i4);
            CheckableImageButton checkableImageButton2 = nVar.f11037c;
            checkableImageButton2.setMinimumWidth(i4);
            checkableImageButton2.setMinimumHeight(i4);
        }
    }

    public void setEndIconMode(int i4) {
        this.f10954c.g(i4);
    }

    public void setEndIconOnClickListener(@Nullable View.OnClickListener onClickListener) {
        n nVar = this.f10954c;
        View.OnLongClickListener onLongClickListener = nVar.f11049o;
        CheckableImageButton checkableImageButton = nVar.f11041g;
        checkableImageButton.setOnClickListener(onClickListener);
        com.stepos.statsrpk.c.N(checkableImageButton, onLongClickListener);
    }

    public void setEndIconOnLongClickListener(@Nullable View.OnLongClickListener onLongClickListener) {
        n nVar = this.f10954c;
        nVar.f11049o = onLongClickListener;
        CheckableImageButton checkableImageButton = nVar.f11041g;
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        com.stepos.statsrpk.c.N(checkableImageButton, onLongClickListener);
    }

    public void setEndIconScaleType(@NonNull ImageView.ScaleType scaleType) {
        n nVar = this.f10954c;
        nVar.f11048n = scaleType;
        nVar.f11041g.setScaleType(scaleType);
        nVar.f11037c.setScaleType(scaleType);
    }

    public void setEndIconTintList(@Nullable ColorStateList colorStateList) {
        n nVar = this.f10954c;
        if (nVar.f11045k != colorStateList) {
            nVar.f11045k = colorStateList;
            com.stepos.statsrpk.c.e(nVar.f11035a, nVar.f11041g, colorStateList, nVar.f11046l);
        }
    }

    public void setEndIconTintMode(@Nullable PorterDuff.Mode mode) {
        n nVar = this.f10954c;
        if (nVar.f11046l != mode) {
            nVar.f11046l = mode;
            com.stepos.statsrpk.c.e(nVar.f11035a, nVar.f11041g, nVar.f11045k, mode);
        }
    }

    public void setEndIconVisible(boolean z4) {
        this.f10954c.h(z4);
    }

    public void setError(@Nullable CharSequence charSequence) {
        r rVar = this.f10962k;
        if (!rVar.f11085q) {
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
        rVar.f11084p = charSequence;
        rVar.f11086r.setText(charSequence);
        int i4 = rVar.f11082n;
        if (i4 != 1) {
            rVar.f11083o = 1;
        }
        rVar.i(i4, rVar.f11083o, rVar.h(rVar.f11086r, charSequence));
    }

    public void setErrorAccessibilityLiveRegion(int i4) {
        r rVar = this.f10962k;
        rVar.f11088t = i4;
        C0200f0 c0200f0 = rVar.f11086r;
        if (c0200f0 != null) {
            c0200f0.setAccessibilityLiveRegion(i4);
        }
    }

    public void setErrorContentDescription(@Nullable CharSequence charSequence) {
        r rVar = this.f10962k;
        rVar.f11087s = charSequence;
        C0200f0 c0200f0 = rVar.f11086r;
        if (c0200f0 != null) {
            c0200f0.setContentDescription(charSequence);
        }
    }

    public void setErrorEnabled(boolean z4) throws Resources.NotFoundException {
        r rVar = this.f10962k;
        if (rVar.f11085q == z4) {
            return;
        }
        rVar.c();
        TextInputLayout textInputLayout = rVar.f11076h;
        if (z4) {
            C0200f0 c0200f0 = new C0200f0(rVar.f11075g, null);
            rVar.f11086r = c0200f0;
            c0200f0.setId(com.stepos.alphame.R.id.textinput_error);
            rVar.f11086r.setTextAlignment(5);
            Typeface typeface = rVar.f11068B;
            if (typeface != null) {
                rVar.f11086r.setTypeface(typeface);
            }
            int i4 = rVar.f11089u;
            rVar.f11089u = i4;
            C0200f0 c0200f02 = rVar.f11086r;
            if (c0200f02 != null) {
                textInputLayout.n(c0200f02, i4);
            }
            ColorStateList colorStateList = rVar.f11090v;
            rVar.f11090v = colorStateList;
            C0200f0 c0200f03 = rVar.f11086r;
            if (c0200f03 != null && colorStateList != null) {
                c0200f03.setTextColor(colorStateList);
            }
            CharSequence charSequence = rVar.f11087s;
            rVar.f11087s = charSequence;
            C0200f0 c0200f04 = rVar.f11086r;
            if (c0200f04 != null) {
                c0200f04.setContentDescription(charSequence);
            }
            int i5 = rVar.f11088t;
            rVar.f11088t = i5;
            C0200f0 c0200f05 = rVar.f11086r;
            if (c0200f05 != null) {
                c0200f05.setAccessibilityLiveRegion(i5);
            }
            rVar.f11086r.setVisibility(4);
            rVar.a(rVar.f11086r, 0);
        } else {
            rVar.f();
            rVar.g(rVar.f11086r, 0);
            rVar.f11086r = null;
            textInputLayout.t();
            textInputLayout.z();
        }
        rVar.f11085q = z4;
    }

    public void setErrorIconDrawable(@DrawableRes int i4) {
        n nVar = this.f10954c;
        nVar.i(i4 != 0 ? I.o(nVar.getContext(), i4) : null);
        com.stepos.statsrpk.c.I(nVar.f11035a, nVar.f11037c, nVar.f11038d);
    }

    public void setErrorIconOnClickListener(@Nullable View.OnClickListener onClickListener) {
        n nVar = this.f10954c;
        CheckableImageButton checkableImageButton = nVar.f11037c;
        View.OnLongClickListener onLongClickListener = nVar.f11040f;
        checkableImageButton.setOnClickListener(onClickListener);
        com.stepos.statsrpk.c.N(checkableImageButton, onLongClickListener);
    }

    public void setErrorIconOnLongClickListener(@Nullable View.OnLongClickListener onLongClickListener) {
        n nVar = this.f10954c;
        nVar.f11040f = onLongClickListener;
        CheckableImageButton checkableImageButton = nVar.f11037c;
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        com.stepos.statsrpk.c.N(checkableImageButton, onLongClickListener);
    }

    public void setErrorIconTintList(@Nullable ColorStateList colorStateList) {
        n nVar = this.f10954c;
        if (nVar.f11038d != colorStateList) {
            nVar.f11038d = colorStateList;
            com.stepos.statsrpk.c.e(nVar.f11035a, nVar.f11037c, colorStateList, nVar.f11039e);
        }
    }

    public void setErrorIconTintMode(@Nullable PorterDuff.Mode mode) {
        n nVar = this.f10954c;
        if (nVar.f11039e != mode) {
            nVar.f11039e = mode;
            com.stepos.statsrpk.c.e(nVar.f11035a, nVar.f11037c, nVar.f11038d, mode);
        }
    }

    public void setErrorTextAppearance(@StyleRes int i4) {
        r rVar = this.f10962k;
        rVar.f11089u = i4;
        C0200f0 c0200f0 = rVar.f11086r;
        if (c0200f0 != null) {
            rVar.f11076h.n(c0200f0, i4);
        }
    }

    public void setErrorTextColor(@Nullable ColorStateList colorStateList) {
        r rVar = this.f10962k;
        rVar.f11090v = colorStateList;
        C0200f0 c0200f0 = rVar.f11086r;
        if (c0200f0 == null || colorStateList == null) {
            return;
        }
        c0200f0.setTextColor(colorStateList);
    }

    public void setExpandedHintEnabled(boolean z4) {
        if (this.f10932H0 != z4) {
            this.f10932H0 = z4;
            w(false, false);
        }
    }

    public void setHelperText(@Nullable CharSequence charSequence) throws Resources.NotFoundException {
        boolean zIsEmpty = TextUtils.isEmpty(charSequence);
        r rVar = this.f10962k;
        if (zIsEmpty) {
            if (rVar.f11092x) {
                setHelperTextEnabled(false);
                return;
            }
            return;
        }
        if (!rVar.f11092x) {
            setHelperTextEnabled(true);
        }
        rVar.c();
        rVar.f11091w = charSequence;
        rVar.f11093y.setText(charSequence);
        int i4 = rVar.f11082n;
        if (i4 != 2) {
            rVar.f11083o = 2;
        }
        rVar.i(i4, rVar.f11083o, rVar.h(rVar.f11093y, charSequence));
    }

    public void setHelperTextColor(@Nullable ColorStateList colorStateList) {
        r rVar = this.f10962k;
        rVar.f11067A = colorStateList;
        C0200f0 c0200f0 = rVar.f11093y;
        if (c0200f0 == null || colorStateList == null) {
            return;
        }
        c0200f0.setTextColor(colorStateList);
    }

    public void setHelperTextEnabled(boolean z4) throws Resources.NotFoundException {
        r rVar = this.f10962k;
        if (rVar.f11092x == z4) {
            return;
        }
        rVar.c();
        if (z4) {
            C0200f0 c0200f0 = new C0200f0(rVar.f11075g, null);
            rVar.f11093y = c0200f0;
            c0200f0.setId(com.stepos.alphame.R.id.textinput_helper_text);
            rVar.f11093y.setTextAlignment(5);
            Typeface typeface = rVar.f11068B;
            if (typeface != null) {
                rVar.f11093y.setTypeface(typeface);
            }
            rVar.f11093y.setVisibility(4);
            rVar.f11093y.setAccessibilityLiveRegion(1);
            int i4 = rVar.f11094z;
            rVar.f11094z = i4;
            C0200f0 c0200f02 = rVar.f11093y;
            if (c0200f02 != null) {
                c0200f02.setTextAppearance(i4);
            }
            ColorStateList colorStateList = rVar.f11067A;
            rVar.f11067A = colorStateList;
            C0200f0 c0200f03 = rVar.f11093y;
            if (c0200f03 != null && colorStateList != null) {
                c0200f03.setTextColor(colorStateList);
            }
            rVar.a(rVar.f11093y, 1);
            rVar.f11093y.setAccessibilityDelegate(new q(rVar));
        } else {
            rVar.c();
            int i5 = rVar.f11082n;
            if (i5 == 2) {
                rVar.f11083o = 0;
            }
            rVar.i(i5, rVar.f11083o, rVar.h(rVar.f11093y, ""));
            rVar.g(rVar.f11093y, 1);
            rVar.f11093y = null;
            TextInputLayout textInputLayout = rVar.f11076h;
            textInputLayout.t();
            textInputLayout.z();
        }
        rVar.f11092x = z4;
    }

    public void setHelperTextTextAppearance(@StyleRes int i4) {
        r rVar = this.f10962k;
        rVar.f11094z = i4;
        C0200f0 c0200f0 = rVar.f11093y;
        if (c0200f0 != null) {
            c0200f0.setTextAppearance(i4);
        }
    }

    public void setHint(@Nullable CharSequence charSequence) {
        if (this.f10923D) {
            setHintInternal(charSequence);
            sendAccessibilityEvent(2048);
        }
    }

    public void setHintAnimationEnabled(boolean z4) {
        this.f10934I0 = z4;
    }

    public void setHintEnabled(boolean z4) {
        if (z4 != this.f10923D) {
            this.f10923D = z4;
            if (z4) {
                CharSequence hint = this.f10956e.getHint();
                if (!TextUtils.isEmpty(hint)) {
                    if (TextUtils.isEmpty(this.f10925E)) {
                        setHint(hint);
                    }
                    this.f10956e.setHint((CharSequence) null);
                }
                this.f10927F = true;
            } else {
                this.f10927F = false;
                if (!TextUtils.isEmpty(this.f10925E) && TextUtils.isEmpty(this.f10956e.getHint())) {
                    this.f10956e.setHint(this.f10925E);
                }
                setHintInternal(null);
            }
            if (this.f10956e != null) {
                v();
            }
        }
    }

    public void setHintMaxLines(int i4) {
        com.google.android.material.internal.b bVar = this.f10930G0;
        if (i4 != bVar.f10805f0) {
            bVar.f10805f0 = i4;
            bVar.j(false);
        }
        if (i4 != bVar.f10803e0) {
            bVar.f10803e0 = i4;
            bVar.j(false);
        }
        requestLayout();
    }

    public void setHintTextAppearance(@StyleRes int i4) {
        com.google.android.material.internal.b bVar = this.f10930G0;
        View view = bVar.f10794a;
        C0973d c0973d = new C0973d(view.getContext(), i4);
        ColorStateList colorStateList = c0973d.f15823k;
        if (colorStateList != null) {
            bVar.f10814k = colorStateList;
        }
        float f4 = c0973d.f15824l;
        if (f4 != Property.DEFAULT_FLOAT_VALUE) {
            bVar.f10810i = f4;
        }
        ColorStateList colorStateList2 = c0973d.f15813a;
        if (colorStateList2 != null) {
            bVar.f10789V = colorStateList2;
        }
        bVar.T = c0973d.f15818f;
        bVar.f10788U = c0973d.f15819g;
        bVar.f10787S = c0973d.f15820h;
        bVar.f10790W = c0973d.f15822j;
        C0970a c0970a = bVar.f10830z;
        if (c0970a != null) {
            c0970a.f15806k = true;
        }
        com.google.android.gms.common.api.internal.p pVar = new com.google.android.gms.common.api.internal.p(8, bVar);
        c0973d.a();
        bVar.f10830z = new C0970a(pVar, c0973d.f15828p);
        c0973d.b(view.getContext(), bVar.f10830z);
        bVar.j(false);
        this.f10983u0 = bVar.f10814k;
        if (this.f10956e != null) {
            w(false, false);
            v();
        }
    }

    public void setHintTextColor(@Nullable ColorStateList colorStateList) {
        if (this.f10983u0 != colorStateList) {
            if (this.f10981t0 == null) {
                com.google.android.material.internal.b bVar = this.f10930G0;
                if (bVar.f10814k != colorStateList) {
                    bVar.f10814k = colorStateList;
                    bVar.j(false);
                }
            }
            this.f10983u0 = colorStateList;
            if (this.f10956e != null) {
                w(false, false);
            }
        }
    }

    public void setLengthCounter(@NonNull z zVar) {
        this.f10970o = zVar;
    }

    public void setMaxEms(int i4) {
        this.f10959h = i4;
        EditText editText = this.f10956e;
        if (editText == null || i4 == -1) {
            return;
        }
        editText.setMaxEms(i4);
    }

    public void setMaxWidth(@Px int i4) {
        this.f10961j = i4;
        EditText editText = this.f10956e;
        if (editText == null || i4 == -1) {
            return;
        }
        editText.setMaxWidth(i4);
    }

    public void setMaxWidthResource(@DimenRes int i4) {
        setMaxWidth(getContext().getResources().getDimensionPixelSize(i4));
    }

    public void setMinEms(int i4) {
        this.f10958g = i4;
        EditText editText = this.f10956e;
        if (editText == null || i4 == -1) {
            return;
        }
        editText.setMinEms(i4);
    }

    public void setMinWidth(@Px int i4) {
        this.f10960i = i4;
        EditText editText = this.f10956e;
        if (editText == null || i4 == -1) {
            return;
        }
        editText.setMinWidth(i4);
    }

    public void setMinWidthResource(@DimenRes int i4) {
        setMinWidth(getContext().getResources().getDimensionPixelSize(i4));
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(@StringRes int i4) {
        n nVar = this.f10954c;
        nVar.f11041g.setContentDescription(i4 != 0 ? nVar.getResources().getText(i4) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(@DrawableRes int i4) {
        n nVar = this.f10954c;
        nVar.f11041g.setImageDrawable(i4 != 0 ? I.o(nVar.getContext(), i4) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleEnabled(boolean z4) {
        n nVar = this.f10954c;
        if (z4 && nVar.f11043i != 1) {
            nVar.g(1);
        } else if (z4) {
            nVar.getClass();
        } else {
            nVar.g(0);
        }
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintList(@Nullable ColorStateList colorStateList) {
        n nVar = this.f10954c;
        nVar.f11045k = colorStateList;
        com.stepos.statsrpk.c.e(nVar.f11035a, nVar.f11041g, colorStateList, nVar.f11046l);
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintMode(@Nullable PorterDuff.Mode mode) {
        n nVar = this.f10954c;
        nVar.f11046l = mode;
        com.stepos.statsrpk.c.e(nVar.f11035a, nVar.f11041g, nVar.f11045k, mode);
    }

    public void setPlaceholderText(@Nullable CharSequence charSequence) {
        if (this.f10982u == null) {
            C0200f0 c0200f0 = new C0200f0(getContext(), null);
            this.f10982u = c0200f0;
            c0200f0.setId(com.stepos.alphame.R.id.textinput_placeholder);
            this.f10982u.setImportantForAccessibility(1);
            this.f10982u.setAccessibilityLiveRegion(1);
            C0801g c0801gF = f();
            this.f10988x = c0801gF;
            c0801gF.f13744b = 67L;
            this.f10990y = f();
            setPlaceholderTextAppearance(this.f10986w);
            setPlaceholderTextColor(this.f10984v);
            S.h(this.f10982u, new r0.d(4, this));
        }
        if (TextUtils.isEmpty(charSequence)) {
            setPlaceholderTextEnabled(false);
        } else {
            if (!this.f10980t) {
                setPlaceholderTextEnabled(true);
            }
            this.f10978s = charSequence;
        }
        EditText editText = this.f10956e;
        x(editText != null ? editText.getText() : null);
    }

    public void setPlaceholderTextAppearance(@StyleRes int i4) {
        this.f10986w = i4;
        C0200f0 c0200f0 = this.f10982u;
        if (c0200f0 != null) {
            c0200f0.setTextAppearance(i4);
        }
    }

    public void setPlaceholderTextColor(@Nullable ColorStateList colorStateList) {
        if (this.f10984v != colorStateList) {
            this.f10984v = colorStateList;
            C0200f0 c0200f0 = this.f10982u;
            if (c0200f0 == null || colorStateList == null) {
                return;
            }
            c0200f0.setTextColor(colorStateList);
        }
    }

    public void setPrefixText(@Nullable CharSequence charSequence) {
        w wVar = this.f10953b;
        wVar.getClass();
        wVar.f11112c = TextUtils.isEmpty(charSequence) ? null : charSequence;
        wVar.f11111b.setText(charSequence);
        wVar.e();
    }

    public void setPrefixTextAppearance(@StyleRes int i4) {
        this.f10953b.f11111b.setTextAppearance(i4);
    }

    public void setPrefixTextColor(@NonNull ColorStateList colorStateList) {
        this.f10953b.f11111b.setTextColor(colorStateList);
    }

    public void setShapeAppearanceModel(@NonNull y1.n nVar) {
        y1.j jVar = this.f10929G;
        if (jVar == null || jVar.f16234b.f16203a == nVar) {
            return;
        }
        this.f10941M = nVar;
        c();
    }

    public void setStartIconCheckable(boolean z4) {
        this.f10953b.f11113d.setCheckable(z4);
    }

    public void setStartIconContentDescription(@Nullable CharSequence charSequence) {
        CheckableImageButton checkableImageButton = this.f10953b.f11113d;
        if (checkableImageButton.getContentDescription() != charSequence) {
            checkableImageButton.setContentDescription(charSequence);
        }
    }

    public void setStartIconDrawable(@DrawableRes int i4) {
        setStartIconDrawable(i4 != 0 ? I.o(getContext(), i4) : null);
    }

    public void setStartIconMinSize(@IntRange(from = 0) int i4) {
        w wVar = this.f10953b;
        if (i4 < 0) {
            wVar.getClass();
            throw new IllegalArgumentException("startIconSize cannot be less than 0");
        }
        if (i4 != wVar.f11116g) {
            wVar.f11116g = i4;
            CheckableImageButton checkableImageButton = wVar.f11113d;
            checkableImageButton.setMinimumWidth(i4);
            checkableImageButton.setMinimumHeight(i4);
        }
    }

    public void setStartIconOnClickListener(@Nullable View.OnClickListener onClickListener) {
        w wVar = this.f10953b;
        View.OnLongClickListener onLongClickListener = wVar.f11118i;
        CheckableImageButton checkableImageButton = wVar.f11113d;
        checkableImageButton.setOnClickListener(onClickListener);
        com.stepos.statsrpk.c.N(checkableImageButton, onLongClickListener);
    }

    public void setStartIconOnLongClickListener(@Nullable View.OnLongClickListener onLongClickListener) {
        w wVar = this.f10953b;
        wVar.f11118i = onLongClickListener;
        CheckableImageButton checkableImageButton = wVar.f11113d;
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        com.stepos.statsrpk.c.N(checkableImageButton, onLongClickListener);
    }

    public void setStartIconScaleType(@NonNull ImageView.ScaleType scaleType) {
        w wVar = this.f10953b;
        wVar.f11117h = scaleType;
        wVar.f11113d.setScaleType(scaleType);
    }

    public void setStartIconTintList(@Nullable ColorStateList colorStateList) {
        w wVar = this.f10953b;
        if (wVar.f11114e != colorStateList) {
            wVar.f11114e = colorStateList;
            com.stepos.statsrpk.c.e(wVar.f11110a, wVar.f11113d, colorStateList, wVar.f11115f);
        }
    }

    public void setStartIconTintMode(@Nullable PorterDuff.Mode mode) {
        w wVar = this.f10953b;
        if (wVar.f11115f != mode) {
            wVar.f11115f = mode;
            com.stepos.statsrpk.c.e(wVar.f11110a, wVar.f11113d, wVar.f11114e, mode);
        }
    }

    public void setStartIconVisible(boolean z4) {
        this.f10953b.c(z4);
    }

    public void setSuffixText(@Nullable CharSequence charSequence) {
        n nVar = this.f10954c;
        nVar.getClass();
        nVar.f11050p = TextUtils.isEmpty(charSequence) ? null : charSequence;
        nVar.f11051q.setText(charSequence);
        nVar.n();
    }

    public void setSuffixTextAppearance(@StyleRes int i4) {
        this.f10954c.f11051q.setTextAppearance(i4);
    }

    public void setSuffixTextColor(@NonNull ColorStateList colorStateList) {
        this.f10954c.f11051q.setTextColor(colorStateList);
    }

    public void setTextInputAccessibilityDelegate(@Nullable y yVar) {
        EditText editText = this.f10956e;
        if (editText != null) {
            S.h(editText, yVar);
        }
    }

    public void setTypeface(@Nullable Typeface typeface) {
        if (typeface != this.f10967m0) {
            this.f10967m0 = typeface;
            this.f10930G0.n(typeface);
            r rVar = this.f10962k;
            if (typeface != rVar.f11068B) {
                rVar.f11068B = typeface;
                C0200f0 c0200f0 = rVar.f11086r;
                if (c0200f0 != null) {
                    c0200f0.setTypeface(typeface);
                }
                C0200f0 c0200f02 = rVar.f11093y;
                if (c0200f02 != null) {
                    c0200f02.setTypeface(typeface);
                }
            }
            C0200f0 c0200f03 = this.f10972p;
            if (c0200f03 != null) {
                c0200f03.setTypeface(typeface);
            }
        }
    }

    public final void t() {
        Drawable background;
        C0200f0 c0200f0;
        PorterDuffColorFilter porterDuffColorFilterG;
        PorterDuffColorFilter porterDuffColorFilterG2;
        EditText editText = this.f10956e;
        if (editText == null || this.f10945P != 0 || (background = editText.getBackground()) == null) {
            return;
        }
        Rect rect = AbstractC0220p0.f3149a;
        Drawable drawableMutate = background.mutate();
        if (o()) {
            int errorCurrentTextColors = getErrorCurrentTextColors();
            PorterDuff.Mode mode = PorterDuff.Mode.SRC_IN;
            PorterDuff.Mode mode2 = androidx.appcompat.widget.A.f2721b;
            synchronized (androidx.appcompat.widget.A.class) {
                porterDuffColorFilterG2 = N0.g(errorCurrentTextColors, mode);
            }
            drawableMutate.setColorFilter(porterDuffColorFilterG2);
            return;
        }
        if (!this.f10968n || (c0200f0 = this.f10972p) == null) {
            drawableMutate.clearColorFilter();
            this.f10956e.refreshDrawableState();
            return;
        }
        int currentTextColor = c0200f0.getCurrentTextColor();
        PorterDuff.Mode mode3 = PorterDuff.Mode.SRC_IN;
        PorterDuff.Mode mode4 = androidx.appcompat.widget.A.f2721b;
        synchronized (androidx.appcompat.widget.A.class) {
            porterDuffColorFilterG = N0.g(currentTextColor, mode3);
        }
        drawableMutate.setColorFilter(porterDuffColorFilterG);
    }

    public final void u() {
        EditText editText = this.f10956e;
        if (editText == null || this.f10929G == null) {
            return;
        }
        if ((this.f10935J || editText.getBackground() == null) && this.f10945P != 0) {
            this.f10956e.setBackground(getEditTextBoxBackground());
            this.f10935J = true;
        }
    }

    public final void v() {
        if (this.f10945P != 1) {
            FrameLayout frameLayout = this.f10952a;
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) frameLayout.getLayoutParams();
            int iE = e();
            if (iE != layoutParams.topMargin) {
                layoutParams.topMargin = iE;
                frameLayout.requestLayout();
            }
        }
    }

    public final void w(boolean z4, boolean z5) {
        ColorStateList colorStateList;
        C0200f0 c0200f0;
        boolean zIsEnabled = isEnabled();
        EditText editText = this.f10956e;
        boolean z6 = (editText == null || TextUtils.isEmpty(editText.getText())) ? false : true;
        EditText editText2 = this.f10956e;
        boolean z7 = editText2 != null && editText2.hasFocus();
        ColorStateList colorStateList2 = this.f10981t0;
        com.google.android.material.internal.b bVar = this.f10930G0;
        if (colorStateList2 != null) {
            bVar.k(colorStateList2);
        }
        if (!zIsEnabled) {
            ColorStateList colorStateList3 = this.f10981t0;
            bVar.k(ColorStateList.valueOf(colorStateList3 != null ? colorStateList3.getColorForState(new int[]{-16842910}, this.f10924D0) : this.f10924D0));
        } else if (o()) {
            C0200f0 c0200f02 = this.f10962k.f11086r;
            bVar.k(c0200f02 != null ? c0200f02.getTextColors() : null);
        } else if (this.f10968n && (c0200f0 = this.f10972p) != null) {
            bVar.k(c0200f0.getTextColors());
        } else if (z7 && (colorStateList = this.f10983u0) != null && bVar.f10814k != colorStateList) {
            bVar.f10814k = colorStateList;
            bVar.j(false);
        }
        n nVar = this.f10954c;
        w wVar = this.f10953b;
        if (z6 || !this.f10932H0 || (isEnabled() && z7)) {
            if (z5 || this.f10928F0) {
                ValueAnimator valueAnimator = this.f10936J0;
                if (valueAnimator != null && valueAnimator.isRunning()) {
                    this.f10936J0.cancel();
                }
                if (z4 && this.f10934I0) {
                    b(1.0f);
                } else {
                    bVar.m(1.0f);
                }
                this.f10928F0 = false;
                if (g()) {
                    l();
                }
                EditText editText3 = this.f10956e;
                x(editText3 != null ? editText3.getText() : null);
                wVar.f11119j = false;
                wVar.e();
                nVar.f11052r = false;
                nVar.n();
                return;
            }
            return;
        }
        if (z5 || !this.f10928F0) {
            ValueAnimator valueAnimator2 = this.f10936J0;
            if (valueAnimator2 != null && valueAnimator2.isRunning()) {
                this.f10936J0.cancel();
            }
            if (z4 && this.f10934I0) {
                b(Property.DEFAULT_FLOAT_VALUE);
            } else {
                bVar.m(Property.DEFAULT_FLOAT_VALUE);
            }
            if (g() && (!((g) this.f10929G).f11014H.f11012w.isEmpty()) && g()) {
                ((g) this.f10929G).v(Property.DEFAULT_FLOAT_VALUE, Property.DEFAULT_FLOAT_VALUE, Property.DEFAULT_FLOAT_VALUE, Property.DEFAULT_FLOAT_VALUE);
            }
            this.f10928F0 = true;
            C0200f0 c0200f03 = this.f10982u;
            if (c0200f03 != null && this.f10980t) {
                c0200f03.setText((CharSequence) null);
                o0.w.a(this.f10952a, this.f10990y);
                this.f10982u.setVisibility(4);
            }
            wVar.f11119j = true;
            wVar.e();
            nVar.f11052r = true;
            nVar.n();
        }
    }

    public final void x(Editable editable) {
        ((C0073e) this.f10970o).getClass();
        FrameLayout frameLayout = this.f10952a;
        if ((editable != null && editable.length() != 0) || this.f10928F0) {
            C0200f0 c0200f0 = this.f10982u;
            if (c0200f0 == null || !this.f10980t) {
                return;
            }
            c0200f0.setText((CharSequence) null);
            o0.w.a(frameLayout, this.f10990y);
            this.f10982u.setVisibility(4);
            return;
        }
        if (this.f10982u == null || !this.f10980t || TextUtils.isEmpty(this.f10978s)) {
            return;
        }
        this.f10982u.setText(this.f10978s);
        o0.w.a(frameLayout, this.f10988x);
        this.f10982u.setVisibility(0);
        this.f10982u.bringToFront();
    }

    public final void y(boolean z4, boolean z5) {
        int defaultColor = this.f10991y0.getDefaultColor();
        int colorForState = this.f10991y0.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, defaultColor);
        int colorForState2 = this.f10991y0.getColorForState(new int[]{R.attr.state_activated, R.attr.state_enabled}, defaultColor);
        if (z4) {
            this.f10949U = colorForState2;
        } else if (z5) {
            this.f10949U = colorForState;
        } else {
            this.f10949U = defaultColor;
        }
    }

    public final void z() throws Resources.NotFoundException {
        C0200f0 c0200f0;
        EditText editText;
        EditText editText2;
        if (this.f10929G == null || this.f10945P == 0) {
            return;
        }
        boolean z4 = false;
        boolean z5 = isFocused() || ((editText2 = this.f10956e) != null && editText2.hasFocus());
        if (isHovered() || ((editText = this.f10956e) != null && editText.isHovered())) {
            z4 = true;
        }
        if (!isEnabled()) {
            this.f10949U = this.f10924D0;
        } else if (o()) {
            if (this.f10991y0 != null) {
                y(z5, z4);
            } else {
                this.f10949U = getErrorCurrentTextColors();
            }
        } else if (!this.f10968n || (c0200f0 = this.f10972p) == null) {
            if (z5) {
                this.f10949U = this.f10989x0;
            } else if (z4) {
                this.f10949U = this.f10987w0;
            } else {
                this.f10949U = this.f10985v0;
            }
        } else if (this.f10991y0 != null) {
            y(z5, z4);
        } else {
            this.f10949U = c0200f0.getCurrentTextColor();
        }
        r();
        n nVar = this.f10954c;
        nVar.l();
        CheckableImageButton checkableImageButton = nVar.f11037c;
        ColorStateList colorStateList = nVar.f11038d;
        TextInputLayout textInputLayout = nVar.f11035a;
        com.stepos.statsrpk.c.I(textInputLayout, checkableImageButton, colorStateList);
        ColorStateList colorStateList2 = nVar.f11045k;
        CheckableImageButton checkableImageButton2 = nVar.f11041g;
        com.stepos.statsrpk.c.I(textInputLayout, checkableImageButton2, colorStateList2);
        if (nVar.b() instanceof k) {
            if (!textInputLayout.o() || checkableImageButton2.getDrawable() == null) {
                com.stepos.statsrpk.c.e(textInputLayout, checkableImageButton2, nVar.f11045k, nVar.f11046l);
            } else {
                Drawable drawableMutate = checkableImageButton2.getDrawable().mutate();
                drawableMutate.setTint(textInputLayout.getErrorCurrentTextColors());
                checkableImageButton2.setImageDrawable(drawableMutate);
            }
        }
        w wVar = this.f10953b;
        com.stepos.statsrpk.c.I(wVar.f11110a, wVar.f11113d, wVar.f11114e);
        if (this.f10945P == 2) {
            int i4 = this.f10947R;
            if (z5 && isEnabled()) {
                this.f10947R = this.T;
            } else {
                this.f10947R = this.f10948S;
            }
            if (this.f10947R != i4 && g() && !this.f10928F0) {
                if (g()) {
                    ((g) this.f10929G).v(Property.DEFAULT_FLOAT_VALUE, Property.DEFAULT_FLOAT_VALUE, Property.DEFAULT_FLOAT_VALUE, Property.DEFAULT_FLOAT_VALUE);
                }
                l();
            }
        }
        if (this.f10945P == 1) {
            if (!isEnabled()) {
                this.f10950V = this.f10918A0;
            } else if (z4 && !z5) {
                this.f10950V = this.f10922C0;
            } else if (z5) {
                this.f10950V = this.f10920B0;
            } else {
                this.f10950V = this.f10993z0;
            }
        }
        c();
    }

    public void setStartIconDrawable(@Nullable Drawable drawable) {
        this.f10953b.b(drawable);
    }

    public void setHint(@StringRes int i4) {
        setHint(i4 != 0 ? getResources().getText(i4) : null);
    }

    public void setStartIconContentDescription(@StringRes int i4) {
        setStartIconContentDescription(i4 != 0 ? getResources().getText(i4) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(@Nullable CharSequence charSequence) {
        this.f10954c.f11041g.setContentDescription(charSequence);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(@Nullable Drawable drawable) {
        this.f10954c.f11041g.setImageDrawable(drawable);
    }

    public void setErrorIconDrawable(@Nullable Drawable drawable) {
        this.f10954c.i(drawable);
    }

    public void setEndIconContentDescription(@Nullable CharSequence charSequence) {
        CheckableImageButton checkableImageButton = this.f10954c.f11041g;
        if (checkableImageButton.getContentDescription() != charSequence) {
            checkableImageButton.setContentDescription(charSequence);
        }
    }

    public void setEndIconDrawable(@Nullable Drawable drawable) {
        n nVar = this.f10954c;
        CheckableImageButton checkableImageButton = nVar.f11041g;
        checkableImageButton.setImageDrawable(drawable);
        if (drawable != null) {
            ColorStateList colorStateList = nVar.f11045k;
            PorterDuff.Mode mode = nVar.f11046l;
            TextInputLayout textInputLayout = nVar.f11035a;
            com.stepos.statsrpk.c.e(textInputLayout, checkableImageButton, colorStateList, mode);
            com.stepos.statsrpk.c.I(textInputLayout, checkableImageButton, nVar.f11045k);
        }
    }
}
