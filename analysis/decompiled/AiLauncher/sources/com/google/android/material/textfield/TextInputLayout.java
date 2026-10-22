package com.google.android.material.textfield;

import Z2.l;
import android.R;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Canvas;
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
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityEvent;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.C1295h;
import androidx.appcompat.widget.U;
import androidx.core.view.C1313a;
import androidx.core.view.N;
import androidx.customview.view.AbsSavedState;
import com.autonavi.aps.amapapi.config.Const;
import com.google.android.material.R$attr;
import com.google.android.material.R$color;
import com.google.android.material.R$dimen;
import com.google.android.material.R$id;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.StaticLayoutBuilderCompat;
import d3.C3953a;
import f.C4027a;
import java.util.Iterator;
import java.util.LinkedHashSet;
import p1.C5042c;
import u0.C5566a;
import z0.C6050a;

/* loaded from: classes2.dex */
public class TextInputLayout extends LinearLayout implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: L0, reason: collision with root package name */
    public static final int f21483L0 = R$style.Widget_Design_TextInputLayout;

    /* renamed from: M0, reason: collision with root package name */
    public static final int[][] f21484M0 = {new int[]{R.attr.state_pressed}, new int[0]};

    /* renamed from: A, reason: collision with root package name */
    public ColorStateList f21485A;

    /* renamed from: A0, reason: collision with root package name */
    public int f21486A0;

    /* renamed from: B, reason: collision with root package name */
    public ColorStateList f21487B;

    /* renamed from: B0, reason: collision with root package name */
    public int f21488B0;

    /* renamed from: C, reason: collision with root package name */
    public ColorStateList f21489C;

    /* renamed from: C0, reason: collision with root package name */
    public int f21490C0;

    /* renamed from: D, reason: collision with root package name */
    public boolean f21491D;

    /* renamed from: D0, reason: collision with root package name */
    public boolean f21492D0;

    /* renamed from: E, reason: collision with root package name */
    public CharSequence f21493E;

    /* renamed from: E0, reason: collision with root package name */
    public final com.google.android.material.internal.a f21494E0;

    /* renamed from: F, reason: collision with root package name */
    public boolean f21495F;

    /* renamed from: F0, reason: collision with root package name */
    public boolean f21496F0;

    /* renamed from: G, reason: collision with root package name */
    public Z2.h f21497G;

    /* renamed from: G0, reason: collision with root package name */
    public boolean f21498G0;

    /* renamed from: H, reason: collision with root package name */
    public Z2.h f21499H;

    /* renamed from: H0, reason: collision with root package name */
    public ValueAnimator f21500H0;

    /* renamed from: I, reason: collision with root package name */
    public StateListDrawable f21501I;

    /* renamed from: I0, reason: collision with root package name */
    public boolean f21502I0;

    /* renamed from: J, reason: collision with root package name */
    public boolean f21503J;

    /* renamed from: J0, reason: collision with root package name */
    public boolean f21504J0;

    /* renamed from: K, reason: collision with root package name */
    public Z2.h f21505K;

    /* renamed from: K0, reason: collision with root package name */
    public boolean f21506K0;

    /* renamed from: L, reason: collision with root package name */
    public Z2.h f21507L;

    /* renamed from: M, reason: collision with root package name */
    public Z2.l f21508M;

    /* renamed from: N, reason: collision with root package name */
    public boolean f21509N;

    /* renamed from: O, reason: collision with root package name */
    public final int f21510O;

    /* renamed from: P, reason: collision with root package name */
    public int f21511P;

    /* renamed from: Q, reason: collision with root package name */
    public int f21512Q;

    /* renamed from: R, reason: collision with root package name */
    public int f21513R;

    /* renamed from: S, reason: collision with root package name */
    public int f21514S;

    /* renamed from: T, reason: collision with root package name */
    public int f21515T;

    /* renamed from: U, reason: collision with root package name */
    public int f21516U;

    /* renamed from: V, reason: collision with root package name */
    public int f21517V;

    /* renamed from: W, reason: collision with root package name */
    public final Rect f21518W;

    /* renamed from: a, reason: collision with root package name */
    public final FrameLayout f21519a;

    /* renamed from: a0, reason: collision with root package name */
    public final Rect f21520a0;

    /* renamed from: b, reason: collision with root package name */
    public final z f21521b;

    /* renamed from: b0, reason: collision with root package name */
    public final RectF f21522b0;

    /* renamed from: c, reason: collision with root package name */
    public final r f21523c;

    /* renamed from: c0, reason: collision with root package name */
    public Typeface f21524c0;

    /* renamed from: d, reason: collision with root package name */
    public final int f21525d;

    /* renamed from: d0, reason: collision with root package name */
    public Drawable f21526d0;

    /* renamed from: e, reason: collision with root package name */
    public EditText f21527e;

    /* renamed from: e0, reason: collision with root package name */
    public int f21528e0;

    /* renamed from: f, reason: collision with root package name */
    public CharSequence f21529f;

    /* renamed from: f0, reason: collision with root package name */
    public final LinkedHashSet<g> f21530f0;

    /* renamed from: g, reason: collision with root package name */
    public int f21531g;

    /* renamed from: g0, reason: collision with root package name */
    public Drawable f21532g0;

    /* renamed from: h, reason: collision with root package name */
    public int f21533h;

    /* renamed from: h0, reason: collision with root package name */
    public int f21534h0;

    /* renamed from: i, reason: collision with root package name */
    public int f21535i;

    /* renamed from: i0, reason: collision with root package name */
    public Drawable f21536i0;

    /* renamed from: j, reason: collision with root package name */
    public int f21537j;

    /* renamed from: j0, reason: collision with root package name */
    public ColorStateList f21538j0;

    /* renamed from: k, reason: collision with root package name */
    public final u f21539k;

    /* renamed from: k0, reason: collision with root package name */
    public ColorStateList f21540k0;

    /* renamed from: l, reason: collision with root package name */
    public boolean f21541l;

    /* renamed from: m, reason: collision with root package name */
    public int f21542m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f21543n;

    /* renamed from: o, reason: collision with root package name */
    public f f21544o;

    /* renamed from: p, reason: collision with root package name */
    public TextView f21545p;

    /* renamed from: q, reason: collision with root package name */
    public int f21546q;

    /* renamed from: r, reason: collision with root package name */
    public int f21547r;

    /* renamed from: s, reason: collision with root package name */
    public CharSequence f21548s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f21549t;

    /* renamed from: t0, reason: collision with root package name */
    public int f21550t0;

    /* renamed from: u, reason: collision with root package name */
    public TextView f21551u;

    /* renamed from: u0, reason: collision with root package name */
    public int f21552u0;

    /* renamed from: v, reason: collision with root package name */
    public ColorStateList f21553v;

    /* renamed from: v0, reason: collision with root package name */
    public int f21554v0;

    /* renamed from: w, reason: collision with root package name */
    public int f21555w;

    /* renamed from: w0, reason: collision with root package name */
    public ColorStateList f21556w0;

    /* renamed from: x, reason: collision with root package name */
    public C5042c f21557x;

    /* renamed from: x0, reason: collision with root package name */
    public int f21558x0;

    /* renamed from: y, reason: collision with root package name */
    public C5042c f21559y;

    /* renamed from: y0, reason: collision with root package name */
    public int f21560y0;

    /* renamed from: z, reason: collision with root package name */
    public ColorStateList f21561z;

    /* renamed from: z0, reason: collision with root package name */
    public int f21562z0;

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        CharSequence error;
        boolean isEndIconChecked;

        public class a implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
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

    public class a implements TextWatcher {

        /* renamed from: a, reason: collision with root package name */
        public int f21563a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ EditText f21564b;

        public a(EditText editText) {
            this.f21564b = editText;
            this.f21563a = editText.getLineCount();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TextInputLayout.this.w0(!r0.f21504J0);
            TextInputLayout textInputLayout = TextInputLayout.this;
            if (textInputLayout.f21541l) {
                textInputLayout.l0(editable);
            }
            if (TextInputLayout.this.f21549t) {
                TextInputLayout.this.A0(editable);
            }
            int lineCount = this.f21564b.getLineCount();
            int i10 = this.f21563a;
            if (lineCount != i10) {
                if (lineCount < i10) {
                    int minimumHeight = this.f21564b.getMinimumHeight();
                    int i11 = TextInputLayout.this.f21490C0;
                    if (minimumHeight != i11) {
                        this.f21564b.setMinimumHeight(i11);
                    }
                }
                this.f21563a = lineCount;
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }
    }

    public class b extends C1313a {
        public b() {
        }

        @Override // androidx.core.view.C1313a
        public void onInitializeAccessibilityNodeInfo(View view, C0.c cVar) {
            super.onInitializeAccessibilityNodeInfo(view, cVar);
            cVar.Q0(false);
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TextInputLayout.this.f21523c.h();
        }
    }

    public class d implements ValueAnimator.AnimatorUpdateListener {
        public d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            TextInputLayout.this.f21494E0.j0(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    public static class e extends C1313a {

        /* renamed from: a, reason: collision with root package name */
        public final TextInputLayout f21569a;

        public e(TextInputLayout textInputLayout) {
            this.f21569a = textInputLayout;
        }

        @Override // androidx.core.view.C1313a
        public void onInitializeAccessibilityNodeInfo(View view, C0.c cVar) {
            super.onInitializeAccessibilityNodeInfo(view, cVar);
            EditText editText = this.f21569a.getEditText();
            CharSequence text = editText != null ? editText.getText() : null;
            CharSequence hint = this.f21569a.getHint();
            CharSequence error = this.f21569a.getError();
            CharSequence placeholderText = this.f21569a.getPlaceholderText();
            int counterMaxLength = this.f21569a.getCounterMaxLength();
            CharSequence counterOverflowDescription = this.f21569a.getCounterOverflowDescription();
            boolean zIsEmpty = TextUtils.isEmpty(text);
            boolean zIsEmpty2 = TextUtils.isEmpty(hint);
            boolean zQ = this.f21569a.Q();
            boolean zIsEmpty3 = TextUtils.isEmpty(error);
            boolean z10 = (zIsEmpty3 && TextUtils.isEmpty(counterOverflowDescription)) ? false : true;
            String string = !zIsEmpty2 ? hint.toString() : "";
            this.f21569a.f21521b.A(cVar);
            if (!zIsEmpty) {
                cVar.O0(text);
            } else if (!TextUtils.isEmpty(string)) {
                cVar.O0(string);
                if (!zQ && placeholderText != null) {
                    cVar.O0(string + ", " + ((Object) placeholderText));
                }
            } else if (placeholderText != null) {
                cVar.O0(placeholderText);
            }
            if (!TextUtils.isEmpty(string)) {
                cVar.z0(string);
                cVar.K0(zIsEmpty);
            }
            if (text == null || text.length() != counterMaxLength) {
                counterMaxLength = -1;
            }
            cVar.B0(counterMaxLength);
            if (z10) {
                if (zIsEmpty3) {
                    error = counterOverflowDescription;
                }
                cVar.u0(error);
            }
            View viewT = this.f21569a.f21539k.t();
            if (viewT != null) {
                cVar.A0(viewT);
            }
            this.f21569a.f21523c.m().o(view, cVar);
        }

        @Override // androidx.core.view.C1313a
        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onPopulateAccessibilityEvent(view, accessibilityEvent);
            this.f21569a.f21523c.m().p(view, accessibilityEvent);
        }
    }

    public interface f {
        int a(Editable editable);
    }

    public interface g {
        void a(TextInputLayout textInputLayout);
    }

    public interface h {
        void a(TextInputLayout textInputLayout, int i10);
    }

    public TextInputLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.textInputStyle);
    }

    public static Drawable I(Z2.h hVar, int i10, int i11, int[][] iArr) {
        return new RippleDrawable(new ColorStateList(iArr, new int[]{M2.a.j(i11, i10, 0.1f), i10}), hVar, hVar);
    }

    public static Drawable L(Context context, Z2.h hVar, int i10, int[][] iArr) {
        int iC = M2.a.c(context, R$attr.colorSurface, "TextInputLayout");
        Z2.h hVar2 = new Z2.h(hVar.I());
        int iJ = M2.a.j(i10, iC, 0.1f);
        hVar2.g0(new ColorStateList(iArr, new int[]{iJ, 0}));
        hVar2.setTint(iC);
        ColorStateList colorStateList = new ColorStateList(iArr, new int[]{iJ, iC});
        Z2.h hVar3 = new Z2.h(hVar.I());
        hVar3.setTint(-1);
        return new LayerDrawable(new Drawable[]{new RippleDrawable(colorStateList, hVar2, hVar3), hVar});
    }

    public static void Y(ViewGroup viewGroup, boolean z10) {
        int childCount = viewGroup.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = viewGroup.getChildAt(i10);
            childAt.setEnabled(z10);
            if (childAt instanceof ViewGroup) {
                Y((ViewGroup) childAt, z10);
            }
        }
    }

    public static /* synthetic */ int c(Editable editable) {
        if (editable != null) {
            return editable.length();
        }
        return 0;
    }

    private Drawable getEditTextBoxBackground() {
        EditText editText = this.f21527e;
        if (!(editText instanceof AutoCompleteTextView) || q.a(editText)) {
            return this.f21497G;
        }
        int iD = M2.a.d(this.f21527e, androidx.appcompat.R$attr.colorControlHighlight);
        int i10 = this.f21511P;
        if (i10 == 2) {
            return L(getContext(), this.f21497G, iD, f21484M0);
        }
        if (i10 == 1) {
            return I(this.f21497G, this.f21517V, iD, f21484M0);
        }
        return null;
    }

    private Drawable getOrCreateFilledDropDownMenuBackground() {
        if (this.f21501I == null) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            this.f21501I = stateListDrawable;
            stateListDrawable.addState(new int[]{R.attr.state_above_anchor}, getOrCreateOutlinedDropDownMenuBackground());
            this.f21501I.addState(new int[0], H(false));
        }
        return this.f21501I;
    }

    private Drawable getOrCreateOutlinedDropDownMenuBackground() {
        if (this.f21499H == null) {
            this.f21499H = H(true);
        }
        return this.f21499H;
    }

    public static void m0(Context context, TextView textView, int i10, int i11, boolean z10) {
        textView.setContentDescription(context.getString(z10 ? R$string.character_counter_overflowed_content_description : R$string.character_counter_content_description, Integer.valueOf(i10), Integer.valueOf(i11)));
    }

    private void setEditText(EditText editText) {
        if (this.f21527e != null) {
            throw new IllegalArgumentException("We already have an EditText, can only have one");
        }
        if (getEndIconMode() != 3 && !(editText instanceof TextInputEditText)) {
            Log.i("TextInputLayout", "EditText added is not a TextInputEditText. Please switch to using that class instead.");
        }
        this.f21527e = editText;
        int i10 = this.f21531g;
        if (i10 != -1) {
            setMinEms(i10);
        } else {
            setMinWidth(this.f21535i);
        }
        int i11 = this.f21533h;
        if (i11 != -1) {
            setMaxEms(i11);
        } else {
            setMaxWidth(this.f21537j);
        }
        this.f21503J = false;
        V();
        setTextInputAccessibilityDelegate(new e(this));
        this.f21494E0.p0(this.f21527e.getTypeface());
        this.f21494E0.h0(this.f21527e.getTextSize());
        this.f21494E0.d0(this.f21527e.getLetterSpacing());
        int gravity = this.f21527e.getGravity();
        this.f21494E0.X((gravity & Const.I_DEF_CGI_SIG) | 48);
        this.f21494E0.g0(gravity);
        this.f21490C0 = editText.getMinimumHeight();
        this.f21527e.addTextChangedListener(new a(editText));
        if (this.f21538j0 == null) {
            this.f21538j0 = this.f21527e.getHintTextColors();
        }
        if (this.f21491D) {
            if (TextUtils.isEmpty(this.f21493E)) {
                CharSequence hint = this.f21527e.getHint();
                this.f21529f = hint;
                setHint(hint);
                this.f21527e.setHint((CharSequence) null);
            }
            this.f21495F = true;
        }
        o0();
        if (this.f21545p != null) {
            l0(this.f21527e.getText());
        }
        q0();
        this.f21539k.f();
        this.f21521b.bringToFront();
        this.f21523c.bringToFront();
        D();
        this.f21523c.x0();
        if (!isEnabled()) {
            editText.setEnabled(false);
        }
        x0(false, true);
    }

    private void setHintInternal(CharSequence charSequence) {
        if (TextUtils.equals(charSequence, this.f21493E)) {
            return;
        }
        this.f21493E = charSequence;
        this.f21494E0.n0(charSequence);
        if (this.f21492D0) {
            return;
        }
        W();
    }

    private void setPlaceholderTextEnabled(boolean z10) {
        if (this.f21549t == z10) {
            return;
        }
        if (z10) {
            k();
        } else {
            a0();
            this.f21551u = null;
        }
        this.f21549t = z10;
    }

    public final void A(boolean z10) {
        ValueAnimator valueAnimator = this.f21500H0;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f21500H0.cancel();
        }
        if (z10 && this.f21498G0) {
            m(1.0f);
        } else {
            this.f21494E0.j0(1.0f);
        }
        this.f21492D0 = false;
        if (C()) {
            W();
        }
        z0();
        this.f21521b.l(false);
        this.f21523c.H(false);
    }

    public final void A0(Editable editable) {
        if (this.f21544o.a(editable) != 0 || this.f21492D0) {
            M();
        } else {
            g0();
        }
    }

    public final C5042c B() {
        C5042c c5042c = new C5042c();
        c5042c.m0(T2.h.f(getContext(), R$attr.motionDurationShort2, 87));
        c5042c.o0(T2.h.g(getContext(), R$attr.motionEasingLinearInterpolator, E2.a.f2339a));
        return c5042c;
    }

    public final void B0(boolean z10, boolean z11) {
        int defaultColor = this.f21556w0.getDefaultColor();
        int colorForState = this.f21556w0.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, defaultColor);
        int colorForState2 = this.f21556w0.getColorForState(new int[]{R.attr.state_activated, R.attr.state_enabled}, defaultColor);
        if (z10) {
            this.f21516U = colorForState2;
        } else if (z11) {
            this.f21516U = colorForState;
        } else {
            this.f21516U = defaultColor;
        }
    }

    public final boolean C() {
        return this.f21491D && !TextUtils.isEmpty(this.f21493E) && (this.f21497G instanceof com.google.android.material.textfield.h);
    }

    public void C0() {
        TextView textView;
        EditText editText;
        EditText editText2;
        if (this.f21497G == null || this.f21511P == 0) {
            return;
        }
        boolean z10 = false;
        boolean z11 = isFocused() || ((editText2 = this.f21527e) != null && editText2.hasFocus());
        if (isHovered() || ((editText = this.f21527e) != null && editText.isHovered())) {
            z10 = true;
        }
        if (!isEnabled()) {
            this.f21516U = this.f21488B0;
        } else if (d0()) {
            if (this.f21556w0 != null) {
                B0(z11, z10);
            } else {
                this.f21516U = getErrorCurrentTextColors();
            }
        } else if (!this.f21543n || (textView = this.f21545p) == null) {
            if (z11) {
                this.f21516U = this.f21554v0;
            } else if (z10) {
                this.f21516U = this.f21552u0;
            } else {
                this.f21516U = this.f21550t0;
            }
        } else if (this.f21556w0 != null) {
            B0(z11, z10);
        } else {
            this.f21516U = textView.getCurrentTextColor();
        }
        o0();
        this.f21523c.I();
        Z();
        if (this.f21511P == 2) {
            int i10 = this.f21513R;
            if (z11 && isEnabled()) {
                this.f21513R = this.f21515T;
            } else {
                this.f21513R = this.f21514S;
            }
            if (this.f21513R != i10) {
                X();
            }
        }
        if (this.f21511P == 1) {
            if (!isEnabled()) {
                this.f21517V = this.f21560y0;
            } else if (z10 && !z11) {
                this.f21517V = this.f21486A0;
            } else if (z11) {
                this.f21517V = this.f21562z0;
            } else {
                this.f21517V = this.f21558x0;
            }
        }
        n();
    }

    public final void D() {
        Iterator<g> it = this.f21530f0.iterator();
        while (it.hasNext()) {
            it.next().a(this);
        }
    }

    public final void E(Canvas canvas) {
        Z2.h hVar;
        if (this.f21507L == null || (hVar = this.f21505K) == null) {
            return;
        }
        hVar.draw(canvas);
        if (this.f21527e.isFocused()) {
            Rect bounds = this.f21507L.getBounds();
            Rect bounds2 = this.f21505K.getBounds();
            float fB = this.f21494E0.B();
            int iCenterX = bounds2.centerX();
            bounds.left = E2.a.c(iCenterX, bounds2.left, fB);
            bounds.right = E2.a.c(iCenterX, bounds2.right, fB);
            this.f21507L.draw(canvas);
        }
    }

    public final void F(Canvas canvas) {
        if (this.f21491D) {
            this.f21494E0.k(canvas);
        }
    }

    public final void G(boolean z10) {
        ValueAnimator valueAnimator = this.f21500H0;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f21500H0.cancel();
        }
        if (z10 && this.f21498G0) {
            m(0.0f);
        } else {
            this.f21494E0.j0(0.0f);
        }
        if (C() && ((com.google.android.material.textfield.h) this.f21497G).z0()) {
            z();
        }
        this.f21492D0 = true;
        M();
        this.f21521b.l(true);
        this.f21523c.H(true);
    }

    public final Z2.h H(boolean z10) throws Resources.NotFoundException {
        float dimensionPixelOffset = getResources().getDimensionPixelOffset(R$dimen.mtrl_shape_corner_size_small_component);
        float f10 = z10 ? dimensionPixelOffset : 0.0f;
        EditText editText = this.f21527e;
        float popupElevation = editText instanceof v ? ((v) editText).getPopupElevation() : getResources().getDimensionPixelOffset(R$dimen.m3_comp_outlined_autocomplete_menu_container_elevation);
        int dimensionPixelOffset2 = getResources().getDimensionPixelOffset(R$dimen.mtrl_exposed_dropdown_menu_popup_vertical_padding);
        Z2.l lVarM = Z2.l.a().C(f10).G(f10).u(dimensionPixelOffset).y(dimensionPixelOffset).m();
        EditText editText2 = this.f21527e;
        Z2.h hVarR = Z2.h.r(getContext(), popupElevation, editText2 instanceof v ? ((v) editText2).getDropDownBackgroundTintList() : null);
        hVarR.setShapeAppearanceModel(lVarM);
        hVarR.j0(0, dimensionPixelOffset2, 0, dimensionPixelOffset2);
        return hVarR;
    }

    public final int J(int i10, boolean z10) {
        return i10 + ((z10 || getPrefixText() == null) ? (!z10 || getSuffixText() == null) ? this.f21527e.getCompoundPaddingLeft() : this.f21523c.y() : this.f21521b.c());
    }

    public final int K(int i10, boolean z10) {
        return i10 - ((z10 || getSuffixText() == null) ? (!z10 || getPrefixText() == null) ? this.f21527e.getCompoundPaddingRight() : this.f21521b.c() : this.f21523c.y());
    }

    public final void M() {
        TextView textView = this.f21551u;
        if (textView == null || !this.f21549t) {
            return;
        }
        textView.setText((CharSequence) null);
        p1.r.a(this.f21519a, this.f21559y);
        this.f21551u.setVisibility(4);
    }

    public boolean N() {
        return this.f21523c.F();
    }

    public boolean O() {
        return this.f21539k.A();
    }

    public boolean P() {
        return this.f21539k.B();
    }

    public final boolean Q() {
        return this.f21492D0;
    }

    public final boolean R() {
        return getHintMaxLines() == 1;
    }

    public final boolean S() {
        if (d0()) {
            return true;
        }
        return this.f21545p != null && this.f21543n;
    }

    public boolean T() {
        return this.f21495F;
    }

    public final boolean U() {
        return this.f21511P == 1 && this.f21527e.getMinLines() <= 1;
    }

    public final void V() {
        q();
        s0();
        C0();
        h0();
        l();
        if (this.f21511P != 0) {
            v0();
        }
        b0();
    }

    public final void W() {
        if (C()) {
            RectF rectF = this.f21522b0;
            this.f21494E0.o(rectF, this.f21527e.getWidth(), this.f21527e.getGravity());
            if (rectF.width() <= 0.0f || rectF.height() <= 0.0f) {
                return;
            }
            p(rectF);
            rectF.offset(-getPaddingLeft(), ((-getPaddingTop()) - (rectF.height() / 2.0f)) + this.f21513R);
            rectF.top = 0.0f;
            ((com.google.android.material.textfield.h) this.f21497G).C0(rectF);
        }
    }

    public final void X() {
        if (!C() || this.f21492D0) {
            return;
        }
        z();
        W();
    }

    public void Z() {
        this.f21521b.m();
    }

    public final void a0() {
        TextView textView = this.f21551u;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof EditText)) {
            super.addView(view, i10, layoutParams);
            return;
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams);
        layoutParams2.gravity = (layoutParams2.gravity & Const.I_DEF_CGI_SIG) | 16;
        this.f21519a.addView(view, layoutParams2);
        this.f21519a.setLayoutParams(layoutParams);
        v0();
        setEditText((EditText) view);
    }

    public final void b0() {
        EditText editText = this.f21527e;
        if (editText instanceof AutoCompleteTextView) {
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) editText;
            if (autoCompleteTextView.getDropDownBackground() == null) {
                int i10 = this.f21511P;
                if (i10 == 2) {
                    autoCompleteTextView.setDropDownBackgroundDrawable(getOrCreateOutlinedDropDownMenuBackground());
                } else if (i10 == 1) {
                    autoCompleteTextView.setDropDownBackgroundDrawable(getOrCreateFilledDropDownMenuBackground());
                }
            }
        }
    }

    public void c0(TextView textView, int i10) {
        try {
            androidx.core.widget.i.m(textView, i10);
            if (textView.getTextColors().getDefaultColor() != -65281) {
                return;
            }
        } catch (Exception unused) {
        }
        androidx.core.widget.i.m(textView, androidx.appcompat.R$style.TextAppearance_AppCompat_Caption);
        textView.setTextColor(androidx.core.content.a.c(getContext(), R$color.design_error));
    }

    public boolean d0() {
        return this.f21539k.l();
    }

    @Override // android.view.ViewGroup, android.view.View
    @TargetApi(26)
    public void dispatchProvideAutofillStructure(ViewStructure viewStructure, int i10) {
        EditText editText = this.f21527e;
        if (editText == null) {
            super.dispatchProvideAutofillStructure(viewStructure, i10);
            return;
        }
        if (this.f21529f != null) {
            boolean z10 = this.f21495F;
            this.f21495F = false;
            CharSequence hint = editText.getHint();
            this.f21527e.setHint(this.f21529f);
            try {
                super.dispatchProvideAutofillStructure(viewStructure, i10);
                return;
            } finally {
                this.f21527e.setHint(hint);
                this.f21495F = z10;
            }
        }
        viewStructure.setAutofillId(getAutofillId());
        onProvideAutofillStructure(viewStructure, i10);
        onProvideAutofillVirtualStructure(viewStructure, i10);
        viewStructure.setChildCount(this.f21519a.getChildCount());
        for (int i11 = 0; i11 < this.f21519a.getChildCount(); i11++) {
            View childAt = this.f21519a.getChildAt(i11);
            ViewStructure viewStructureNewChild = viewStructure.newChild(i11);
            childAt.dispatchProvideAutofillStructure(viewStructureNewChild, i10);
            if (childAt == this.f21527e) {
                viewStructureNewChild.setHint(getHint());
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        this.f21504J0 = true;
        super.dispatchRestoreInstanceState(sparseArray);
        this.f21504J0 = false;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        F(canvas);
        E(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        if (this.f21502I0) {
            return;
        }
        this.f21502I0 = true;
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        com.google.android.material.internal.a aVar = this.f21494E0;
        boolean zM0 = aVar != null ? aVar.m0(drawableState) : false;
        if (this.f21527e != null) {
            w0(isLaidOut() && isEnabled());
        }
        q0();
        C0();
        if (zM0) {
            invalidate();
        }
        this.f21502I0 = false;
    }

    public final boolean e0() {
        return (this.f21523c.G() || ((this.f21523c.A() && N()) || this.f21523c.w() != null)) && this.f21523c.getMeasuredWidth() > 0;
    }

    public final boolean f0() {
        return (getStartIconDrawable() != null || (getPrefixText() != null && getPrefixTextView().getVisibility() == 0)) && this.f21521b.getMeasuredWidth() > 0;
    }

    public final void g0() {
        if (this.f21551u == null || !this.f21549t || TextUtils.isEmpty(this.f21548s)) {
            return;
        }
        this.f21551u.setText(this.f21548s);
        p1.r.a(this.f21519a, this.f21557x);
        this.f21551u.setVisibility(0);
        this.f21551u.bringToFront();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public int getBaseline() {
        EditText editText = this.f21527e;
        return editText != null ? editText.getBaseline() + getPaddingTop() + w() : super.getBaseline();
    }

    public Z2.h getBoxBackground() {
        int i10 = this.f21511P;
        if (i10 == 1 || i10 == 2) {
            return this.f21497G;
        }
        throw new IllegalStateException();
    }

    public int getBoxBackgroundColor() {
        return this.f21517V;
    }

    public int getBoxBackgroundMode() {
        return this.f21511P;
    }

    public int getBoxCollapsedPaddingTop() {
        return this.f21512Q;
    }

    public float getBoxCornerRadiusBottomEnd() {
        return com.google.android.material.internal.u.h(this) ? this.f21508M.j().a(this.f21522b0) : this.f21508M.l().a(this.f21522b0);
    }

    public float getBoxCornerRadiusBottomStart() {
        return com.google.android.material.internal.u.h(this) ? this.f21508M.l().a(this.f21522b0) : this.f21508M.j().a(this.f21522b0);
    }

    public float getBoxCornerRadiusTopEnd() {
        return com.google.android.material.internal.u.h(this) ? this.f21508M.r().a(this.f21522b0) : this.f21508M.t().a(this.f21522b0);
    }

    public float getBoxCornerRadiusTopStart() {
        return com.google.android.material.internal.u.h(this) ? this.f21508M.t().a(this.f21522b0) : this.f21508M.r().a(this.f21522b0);
    }

    public int getBoxStrokeColor() {
        return this.f21554v0;
    }

    public ColorStateList getBoxStrokeErrorColor() {
        return this.f21556w0;
    }

    public int getBoxStrokeWidth() {
        return this.f21514S;
    }

    public int getBoxStrokeWidthFocused() {
        return this.f21515T;
    }

    public int getCounterMaxLength() {
        return this.f21542m;
    }

    public CharSequence getCounterOverflowDescription() {
        TextView textView;
        if (this.f21541l && this.f21543n && (textView = this.f21545p) != null) {
            return textView.getContentDescription();
        }
        return null;
    }

    public ColorStateList getCounterOverflowTextColor() {
        return this.f21485A;
    }

    public ColorStateList getCounterTextColor() {
        return this.f21561z;
    }

    public ColorStateList getCursorColor() {
        return this.f21487B;
    }

    public ColorStateList getCursorErrorColor() {
        return this.f21489C;
    }

    public ColorStateList getDefaultHintTextColor() {
        return this.f21538j0;
    }

    public EditText getEditText() {
        return this.f21527e;
    }

    public CharSequence getEndIconContentDescription() {
        return this.f21523c.l();
    }

    public Drawable getEndIconDrawable() {
        return this.f21523c.n();
    }

    public int getEndIconMinSize() {
        return this.f21523c.o();
    }

    public int getEndIconMode() {
        return this.f21523c.p();
    }

    public ImageView.ScaleType getEndIconScaleType() {
        return this.f21523c.q();
    }

    public CheckableImageButton getEndIconView() {
        return this.f21523c.r();
    }

    public CharSequence getError() {
        if (this.f21539k.A()) {
            return this.f21539k.p();
        }
        return null;
    }

    public int getErrorAccessibilityLiveRegion() {
        return this.f21539k.n();
    }

    public CharSequence getErrorContentDescription() {
        return this.f21539k.o();
    }

    public int getErrorCurrentTextColors() {
        return this.f21539k.q();
    }

    public Drawable getErrorIconDrawable() {
        return this.f21523c.s();
    }

    public CharSequence getHelperText() {
        if (this.f21539k.B()) {
            return this.f21539k.s();
        }
        return null;
    }

    public int getHelperTextCurrentTextColor() {
        return this.f21539k.u();
    }

    public CharSequence getHint() {
        if (this.f21491D) {
            return this.f21493E;
        }
        return null;
    }

    public final float getHintCollapsedTextHeight() {
        return this.f21494E0.q();
    }

    public final int getHintCurrentCollapsedTextColor() {
        return this.f21494E0.t();
    }

    public int getHintMaxLines() {
        return this.f21494E0.x();
    }

    public ColorStateList getHintTextColor() {
        return this.f21540k0;
    }

    public f getLengthCounter() {
        return this.f21544o;
    }

    public int getMaxEms() {
        return this.f21533h;
    }

    public int getMaxWidth() {
        return this.f21537j;
    }

    public int getMinEms() {
        return this.f21531g;
    }

    public int getMinWidth() {
        return this.f21535i;
    }

    @Deprecated
    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.f21523c.u();
    }

    @Deprecated
    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.f21523c.v();
    }

    public CharSequence getPlaceholderText() {
        if (this.f21549t) {
            return this.f21548s;
        }
        return null;
    }

    public int getPlaceholderTextAppearance() {
        return this.f21555w;
    }

    public ColorStateList getPlaceholderTextColor() {
        return this.f21553v;
    }

    public CharSequence getPrefixText() {
        return this.f21521b.a();
    }

    public ColorStateList getPrefixTextColor() {
        return this.f21521b.b();
    }

    public TextView getPrefixTextView() {
        return this.f21521b.d();
    }

    public Z2.l getShapeAppearanceModel() {
        return this.f21508M;
    }

    public CharSequence getStartIconContentDescription() {
        return this.f21521b.e();
    }

    public Drawable getStartIconDrawable() {
        return this.f21521b.f();
    }

    public int getStartIconMinSize() {
        return this.f21521b.g();
    }

    public ImageView.ScaleType getStartIconScaleType() {
        return this.f21521b.h();
    }

    public CharSequence getSuffixText() {
        return this.f21523c.w();
    }

    public ColorStateList getSuffixTextColor() {
        return this.f21523c.x();
    }

    public TextView getSuffixTextView() {
        return this.f21523c.z();
    }

    public Typeface getTypeface() {
        return this.f21524c0;
    }

    public final void h0() {
        if (this.f21511P == 1) {
            if (W2.c.i(getContext())) {
                this.f21512Q = getResources().getDimensionPixelSize(R$dimen.material_font_2_0_box_collapsed_padding_top);
            } else if (W2.c.h(getContext())) {
                this.f21512Q = getResources().getDimensionPixelSize(R$dimen.material_font_1_3_box_collapsed_padding_top);
            }
        }
    }

    public final void i0(Rect rect) {
        Z2.h hVar = this.f21505K;
        if (hVar != null) {
            int i10 = rect.bottom;
            hVar.setBounds(rect.left, i10 - this.f21514S, rect.right, i10);
        }
        Z2.h hVar2 = this.f21507L;
        if (hVar2 != null) {
            int i11 = rect.bottom;
            hVar2.setBounds(rect.left, i11 - this.f21515T, rect.right, i11);
        }
    }

    public void j(g gVar) {
        this.f21530f0.add(gVar);
        if (this.f21527e != null) {
            gVar.a(this);
        }
    }

    public final void j0(int i10) throws StaticLayoutBuilderCompat.StaticLayoutBuilderCompatException {
        this.f21494E0.s0(i10);
        Rect rect = this.f21518W;
        com.google.android.material.internal.c.a(this, this.f21527e, rect);
        this.f21494E0.S(s(rect));
        v0();
        l();
        t0(i10);
    }

    public final void k() {
        TextView textView = this.f21551u;
        if (textView != null) {
            this.f21519a.addView(textView);
            this.f21551u.setVisibility(0);
        }
    }

    public final void k0() {
        if (this.f21545p != null) {
            EditText editText = this.f21527e;
            l0(editText == null ? null : editText.getText());
        }
    }

    public final void l() {
        if (this.f21527e == null || this.f21511P != 1) {
            return;
        }
        if (!R()) {
            EditText editText = this.f21527e;
            editText.setPaddingRelative(editText.getPaddingStart(), (int) (this.f21494E0.q() + this.f21525d), this.f21527e.getPaddingEnd(), getResources().getDimensionPixelSize(R$dimen.material_filled_edittext_font_1_3_padding_bottom));
        } else if (W2.c.i(getContext())) {
            EditText editText2 = this.f21527e;
            editText2.setPaddingRelative(editText2.getPaddingStart(), getResources().getDimensionPixelSize(R$dimen.material_filled_edittext_font_2_0_padding_top), this.f21527e.getPaddingEnd(), getResources().getDimensionPixelSize(R$dimen.material_filled_edittext_font_2_0_padding_bottom));
        } else if (W2.c.h(getContext())) {
            EditText editText3 = this.f21527e;
            editText3.setPaddingRelative(editText3.getPaddingStart(), getResources().getDimensionPixelSize(R$dimen.material_filled_edittext_font_1_3_padding_top), this.f21527e.getPaddingEnd(), getResources().getDimensionPixelSize(R$dimen.material_filled_edittext_font_1_3_padding_bottom));
        }
    }

    public void l0(Editable editable) {
        int iA = this.f21544o.a(editable);
        boolean z10 = this.f21543n;
        int i10 = this.f21542m;
        if (i10 == -1) {
            this.f21545p.setText(String.valueOf(iA));
            this.f21545p.setContentDescription(null);
            this.f21543n = false;
        } else {
            this.f21543n = iA > i10;
            m0(getContext(), this.f21545p, iA, this.f21542m, this.f21543n);
            if (z10 != this.f21543n) {
                n0();
            }
            this.f21545p.setText(C6050a.c().j(getContext().getString(R$string.character_counter_pattern, Integer.valueOf(iA), Integer.valueOf(this.f21542m))));
        }
        if (this.f21527e == null || z10 == this.f21543n) {
            return;
        }
        w0(false);
        C0();
        q0();
    }

    public void m(float f10) {
        if (this.f21494E0.B() == f10) {
            return;
        }
        if (this.f21500H0 == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.f21500H0 = valueAnimator;
            valueAnimator.setInterpolator(T2.h.g(getContext(), R$attr.motionEasingEmphasizedInterpolator, E2.a.f2340b));
            this.f21500H0.setDuration(T2.h.f(getContext(), R$attr.motionDurationMedium4, 167));
            this.f21500H0.addUpdateListener(new d());
        }
        this.f21500H0.setFloatValues(this.f21494E0.B(), f10);
        this.f21500H0.start();
    }

    public final void n() {
        Z2.h hVar = this.f21497G;
        if (hVar == null) {
            return;
        }
        Z2.l lVarI = hVar.I();
        Z2.l lVar = this.f21508M;
        if (lVarI != lVar) {
            this.f21497G.setShapeAppearanceModel(lVar);
        }
        if (x()) {
            this.f21497G.m0(this.f21513R, this.f21516U);
        }
        int iR = r();
        this.f21517V = iR;
        this.f21497G.g0(ColorStateList.valueOf(iR));
        o();
        s0();
    }

    public final void n0() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        TextView textView = this.f21545p;
        if (textView != null) {
            c0(textView, this.f21543n ? this.f21546q : this.f21547r);
            if (!this.f21543n && (colorStateList2 = this.f21561z) != null) {
                this.f21545p.setTextColor(colorStateList2);
            }
            if (!this.f21543n || (colorStateList = this.f21485A) == null) {
                return;
            }
            this.f21545p.setTextColor(colorStateList);
        }
    }

    public final void o() {
        if (this.f21505K == null || this.f21507L == null) {
            return;
        }
        if (y()) {
            this.f21505K.g0(this.f21527e.isFocused() ? ColorStateList.valueOf(this.f21550t0) : ColorStateList.valueOf(this.f21516U));
            this.f21507L.g0(ColorStateList.valueOf(this.f21516U));
        }
        invalidate();
    }

    public final void o0() {
        ColorStateList colorStateList;
        ColorStateList colorStateListG = this.f21487B;
        if (colorStateListG == null) {
            colorStateListG = M2.a.g(getContext(), androidx.appcompat.R$attr.colorControlActivated);
        }
        EditText editText = this.f21527e;
        if (editText == null || editText.getTextCursorDrawable() == null) {
            return;
        }
        Drawable drawableMutate = C5566a.r(this.f21527e.getTextCursorDrawable()).mutate();
        if (S() && (colorStateList = this.f21489C) != null) {
            colorStateListG = colorStateList;
        }
        drawableMutate.setTintList(colorStateListG);
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f21494E0.L(configuration);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        this.f21523c.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        this.f21506K0 = false;
        boolean zU0 = u0();
        boolean zP0 = p0();
        if (zU0 || zP0) {
            this.f21527e.post(new Runnable() { // from class: com.google.android.material.textfield.A
                @Override // java.lang.Runnable
                public final void run() {
                    this.f21479a.f21527e.requestLayout();
                }
            });
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        EditText editText = this.f21527e;
        if (editText != null) {
            Rect rect = this.f21518W;
            com.google.android.material.internal.c.a(this, editText, rect);
            i0(rect);
            if (this.f21491D) {
                this.f21494E0.h0(this.f21527e.getTextSize());
                int gravity = this.f21527e.getGravity();
                this.f21494E0.X((gravity & Const.I_DEF_CGI_SIG) | 48);
                this.f21494E0.g0(gravity);
                this.f21494E0.S(s(rect));
                this.f21494E0.c0(v(rect));
                this.f21494E0.N();
                if (!C() || this.f21492D0) {
                    return;
                }
                W();
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i10, int i11) throws StaticLayoutBuilderCompat.StaticLayoutBuilderCompatException {
        super.onMeasure(i10, i11);
        if (!this.f21506K0) {
            this.f21523c.getViewTreeObserver().addOnGlobalLayoutListener(this);
            this.f21506K0 = true;
        }
        y0();
        this.f21523c.x0();
        if (R()) {
            return;
        }
        j0((this.f21527e.getMeasuredWidth() - this.f21527e.getCompoundPaddingLeft()) - this.f21527e.getCompoundPaddingRight());
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
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
    public void onRtlPropertiesChanged(int i10) {
        super.onRtlPropertiesChanged(i10);
        boolean z10 = i10 == 1;
        if (z10 != this.f21509N) {
            float fA = this.f21508M.r().a(this.f21522b0);
            float fA2 = this.f21508M.t().a(this.f21522b0);
            Z2.l lVarM = Z2.l.a().B(this.f21508M.s()).F(this.f21508M.q()).t(this.f21508M.k()).x(this.f21508M.i()).C(fA2).G(fA).u(this.f21508M.l().a(this.f21522b0)).y(this.f21508M.j().a(this.f21522b0)).m();
            this.f21509N = z10;
            setShapeAppearanceModel(lVarM);
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (d0()) {
            savedState.error = getError();
        }
        savedState.isEndIconChecked = this.f21523c.E();
        return savedState;
    }

    public final void p(RectF rectF) {
        float f10 = rectF.left;
        int i10 = this.f21510O;
        rectF.left = f10 - i10;
        rectF.right += i10;
    }

    public boolean p0() {
        boolean z10;
        if (this.f21527e == null) {
            return false;
        }
        boolean z11 = true;
        if (f0()) {
            int measuredWidth = this.f21521b.getMeasuredWidth() - this.f21527e.getPaddingLeft();
            if (this.f21526d0 == null || this.f21528e0 != measuredWidth) {
                ColorDrawable colorDrawable = new ColorDrawable();
                this.f21526d0 = colorDrawable;
                this.f21528e0 = measuredWidth;
                colorDrawable.setBounds(0, 0, measuredWidth, 1);
            }
            Drawable[] compoundDrawablesRelative = this.f21527e.getCompoundDrawablesRelative();
            Drawable drawable = compoundDrawablesRelative[0];
            Drawable drawable2 = this.f21526d0;
            if (drawable != drawable2) {
                this.f21527e.setCompoundDrawablesRelative(drawable2, compoundDrawablesRelative[1], compoundDrawablesRelative[2], compoundDrawablesRelative[3]);
                z10 = true;
            }
            z10 = false;
        } else {
            if (this.f21526d0 != null) {
                Drawable[] compoundDrawablesRelative2 = this.f21527e.getCompoundDrawablesRelative();
                this.f21527e.setCompoundDrawablesRelative(null, compoundDrawablesRelative2[1], compoundDrawablesRelative2[2], compoundDrawablesRelative2[3]);
                this.f21526d0 = null;
                z10 = true;
            }
            z10 = false;
        }
        if (e0()) {
            int measuredWidth2 = this.f21523c.z().getMeasuredWidth() - this.f21527e.getPaddingRight();
            CheckableImageButton checkableImageButtonK = this.f21523c.k();
            if (checkableImageButtonK != null) {
                measuredWidth2 = measuredWidth2 + checkableImageButtonK.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) checkableImageButtonK.getLayoutParams()).getMarginStart();
            }
            Drawable[] compoundDrawablesRelative3 = this.f21527e.getCompoundDrawablesRelative();
            Drawable drawable3 = this.f21532g0;
            if (drawable3 != null && this.f21534h0 != measuredWidth2) {
                this.f21534h0 = measuredWidth2;
                drawable3.setBounds(0, 0, measuredWidth2, 1);
                this.f21527e.setCompoundDrawablesRelative(compoundDrawablesRelative3[0], compoundDrawablesRelative3[1], this.f21532g0, compoundDrawablesRelative3[3]);
                return true;
            }
            if (drawable3 == null) {
                ColorDrawable colorDrawable2 = new ColorDrawable();
                this.f21532g0 = colorDrawable2;
                this.f21534h0 = measuredWidth2;
                colorDrawable2.setBounds(0, 0, measuredWidth2, 1);
            }
            Drawable drawable4 = compoundDrawablesRelative3[2];
            Drawable drawable5 = this.f21532g0;
            if (drawable4 != drawable5) {
                this.f21536i0 = drawable4;
                this.f21527e.setCompoundDrawablesRelative(compoundDrawablesRelative3[0], compoundDrawablesRelative3[1], drawable5, compoundDrawablesRelative3[3]);
                return true;
            }
        } else if (this.f21532g0 != null) {
            Drawable[] compoundDrawablesRelative4 = this.f21527e.getCompoundDrawablesRelative();
            if (compoundDrawablesRelative4[2] == this.f21532g0) {
                this.f21527e.setCompoundDrawablesRelative(compoundDrawablesRelative4[0], compoundDrawablesRelative4[1], this.f21536i0, compoundDrawablesRelative4[3]);
            } else {
                z11 = z10;
            }
            this.f21532g0 = null;
            return z11;
        }
        return z10;
    }

    public final void q() {
        int i10 = this.f21511P;
        if (i10 == 0) {
            this.f21497G = null;
            this.f21505K = null;
            this.f21507L = null;
            return;
        }
        if (i10 == 1) {
            this.f21497G = new Z2.h(this.f21508M);
            this.f21505K = new Z2.h();
            this.f21507L = new Z2.h();
        } else {
            if (i10 != 2) {
                throw new IllegalArgumentException(this.f21511P + " is illegal; only @BoxBackgroundMode constants are supported.");
            }
            if (!this.f21491D || (this.f21497G instanceof com.google.android.material.textfield.h)) {
                this.f21497G = new Z2.h(this.f21508M);
            } else {
                this.f21497G = com.google.android.material.textfield.h.x0(this.f21508M);
            }
            this.f21505K = null;
            this.f21507L = null;
        }
    }

    public void q0() {
        Drawable background;
        TextView textView;
        EditText editText = this.f21527e;
        if (editText == null || this.f21511P != 0 || (background = editText.getBackground()) == null) {
            return;
        }
        if (androidx.appcompat.widget.B.a(background)) {
            background = background.mutate();
        }
        if (d0()) {
            background.setColorFilter(C1295h.e(getErrorCurrentTextColors(), PorterDuff.Mode.SRC_IN));
        } else if (this.f21543n && (textView = this.f21545p) != null) {
            background.setColorFilter(C1295h.e(textView.getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
        } else {
            C5566a.c(background);
            this.f21527e.refreshDrawableState();
        }
    }

    public final int r() {
        return this.f21511P == 1 ? M2.a.i(M2.a.e(this, R$attr.colorSurface, 0), this.f21517V) : this.f21517V;
    }

    public final void r0() {
        this.f21527e.setBackground(getEditTextBoxBackground());
    }

    public final Rect s(Rect rect) {
        if (this.f21527e == null) {
            throw new IllegalStateException();
        }
        Rect rect2 = this.f21520a0;
        boolean zH = com.google.android.material.internal.u.h(this);
        rect2.bottom = rect.bottom;
        int i10 = this.f21511P;
        if (i10 == 1) {
            rect2.left = J(rect.left, zH);
            rect2.top = rect.top + this.f21512Q;
            rect2.right = K(rect.right, zH);
            return rect2;
        }
        if (i10 != 2) {
            rect2.left = J(rect.left, zH);
            rect2.top = getPaddingTop();
            rect2.right = K(rect.right, zH);
            return rect2;
        }
        rect2.left = rect.left + this.f21527e.getPaddingLeft();
        rect2.top = rect.top - w();
        rect2.right = rect.right - this.f21527e.getPaddingRight();
        return rect2;
    }

    public void s0() {
        EditText editText = this.f21527e;
        if (editText == null || this.f21497G == null) {
            return;
        }
        if ((this.f21503J || editText.getBackground() == null) && this.f21511P != 0) {
            r0();
            this.f21503J = true;
        }
    }

    public void setBoxBackgroundColor(int i10) {
        if (this.f21517V != i10) {
            this.f21517V = i10;
            this.f21558x0 = i10;
            this.f21562z0 = i10;
            this.f21486A0 = i10;
            n();
        }
    }

    public void setBoxBackgroundColorResource(int i10) {
        setBoxBackgroundColor(androidx.core.content.a.c(getContext(), i10));
    }

    public void setBoxBackgroundColorStateList(ColorStateList colorStateList) {
        int defaultColor = colorStateList.getDefaultColor();
        this.f21558x0 = defaultColor;
        this.f21517V = defaultColor;
        this.f21560y0 = colorStateList.getColorForState(new int[]{-16842910}, -1);
        this.f21562z0 = colorStateList.getColorForState(new int[]{R.attr.state_focused, R.attr.state_enabled}, -1);
        this.f21486A0 = colorStateList.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, -1);
        n();
    }

    public void setBoxBackgroundMode(int i10) {
        if (i10 == this.f21511P) {
            return;
        }
        this.f21511P = i10;
        if (this.f21527e != null) {
            V();
        }
    }

    public void setBoxCollapsedPaddingTop(int i10) {
        this.f21512Q = i10;
    }

    public void setBoxCornerFamily(int i10) {
        this.f21508M = this.f21508M.w().A(i10, this.f21508M.r()).E(i10, this.f21508M.t()).s(i10, this.f21508M.j()).w(i10, this.f21508M.l()).m();
        n();
    }

    public void setBoxStrokeColor(int i10) {
        if (this.f21554v0 != i10) {
            this.f21554v0 = i10;
            C0();
        }
    }

    public void setBoxStrokeColorStateList(ColorStateList colorStateList) {
        if (colorStateList.isStateful()) {
            this.f21550t0 = colorStateList.getDefaultColor();
            this.f21488B0 = colorStateList.getColorForState(new int[]{-16842910}, -1);
            this.f21552u0 = colorStateList.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, -1);
            this.f21554v0 = colorStateList.getColorForState(new int[]{R.attr.state_focused, R.attr.state_enabled}, -1);
        } else if (this.f21554v0 != colorStateList.getDefaultColor()) {
            this.f21554v0 = colorStateList.getDefaultColor();
        }
        C0();
    }

    public void setBoxStrokeErrorColor(ColorStateList colorStateList) {
        if (this.f21556w0 != colorStateList) {
            this.f21556w0 = colorStateList;
            C0();
        }
    }

    public void setBoxStrokeWidth(int i10) {
        this.f21514S = i10;
        C0();
    }

    public void setBoxStrokeWidthFocused(int i10) {
        this.f21515T = i10;
        C0();
    }

    public void setBoxStrokeWidthFocusedResource(int i10) {
        setBoxStrokeWidthFocused(getResources().getDimensionPixelSize(i10));
    }

    public void setBoxStrokeWidthResource(int i10) {
        setBoxStrokeWidth(getResources().getDimensionPixelSize(i10));
    }

    public void setCounterEnabled(boolean z10) {
        if (this.f21541l != z10) {
            if (z10) {
                AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
                this.f21545p = appCompatTextView;
                appCompatTextView.setId(R$id.textinput_counter);
                Typeface typeface = this.f21524c0;
                if (typeface != null) {
                    this.f21545p.setTypeface(typeface);
                }
                this.f21545p.setMaxLines(1);
                this.f21539k.e(this.f21545p, 2);
                ((ViewGroup.MarginLayoutParams) this.f21545p.getLayoutParams()).setMarginStart(getResources().getDimensionPixelOffset(R$dimen.mtrl_textinput_counter_margin_start));
                n0();
                k0();
            } else {
                this.f21539k.C(this.f21545p, 2);
                this.f21545p = null;
            }
            this.f21541l = z10;
        }
    }

    public void setCounterMaxLength(int i10) {
        if (this.f21542m != i10) {
            if (i10 > 0) {
                this.f21542m = i10;
            } else {
                this.f21542m = -1;
            }
            if (this.f21541l) {
                k0();
            }
        }
    }

    public void setCounterOverflowTextAppearance(int i10) {
        if (this.f21546q != i10) {
            this.f21546q = i10;
            n0();
        }
    }

    public void setCounterOverflowTextColor(ColorStateList colorStateList) {
        if (this.f21485A != colorStateList) {
            this.f21485A = colorStateList;
            n0();
        }
    }

    public void setCounterTextAppearance(int i10) {
        if (this.f21547r != i10) {
            this.f21547r = i10;
            n0();
        }
    }

    public void setCounterTextColor(ColorStateList colorStateList) {
        if (this.f21561z != colorStateList) {
            this.f21561z = colorStateList;
            n0();
        }
    }

    public void setCursorColor(ColorStateList colorStateList) {
        if (this.f21487B != colorStateList) {
            this.f21487B = colorStateList;
            o0();
        }
    }

    public void setCursorErrorColor(ColorStateList colorStateList) {
        if (this.f21489C != colorStateList) {
            this.f21489C = colorStateList;
            if (S()) {
                o0();
            }
        }
    }

    public void setDefaultHintTextColor(ColorStateList colorStateList) {
        this.f21538j0 = colorStateList;
        this.f21540k0 = colorStateList;
        if (this.f21527e != null) {
            w0(false);
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z10) {
        Y(this, z10);
        super.setEnabled(z10);
    }

    public void setEndIconActivated(boolean z10) {
        this.f21523c.N(z10);
    }

    public void setEndIconCheckable(boolean z10) {
        this.f21523c.O(z10);
    }

    public void setEndIconContentDescription(int i10) {
        this.f21523c.P(i10);
    }

    public void setEndIconDrawable(int i10) {
        this.f21523c.R(i10);
    }

    public void setEndIconMinSize(int i10) {
        this.f21523c.T(i10);
    }

    public void setEndIconMode(int i10) {
        this.f21523c.U(i10);
    }

    public void setEndIconOnClickListener(View.OnClickListener onClickListener) {
        this.f21523c.V(onClickListener);
    }

    public void setEndIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f21523c.W(onLongClickListener);
    }

    public void setEndIconScaleType(ImageView.ScaleType scaleType) {
        this.f21523c.X(scaleType);
    }

    public void setEndIconTintList(ColorStateList colorStateList) {
        this.f21523c.Y(colorStateList);
    }

    public void setEndIconTintMode(PorterDuff.Mode mode) {
        this.f21523c.Z(mode);
    }

    public void setEndIconVisible(boolean z10) {
        this.f21523c.a0(z10);
    }

    public void setError(CharSequence charSequence) {
        if (!this.f21539k.A()) {
            if (TextUtils.isEmpty(charSequence)) {
                return;
            } else {
                setErrorEnabled(true);
            }
        }
        if (TextUtils.isEmpty(charSequence)) {
            this.f21539k.w();
        } else {
            this.f21539k.Q(charSequence);
        }
    }

    public void setErrorAccessibilityLiveRegion(int i10) {
        this.f21539k.E(i10);
    }

    public void setErrorContentDescription(CharSequence charSequence) {
        this.f21539k.F(charSequence);
    }

    public void setErrorEnabled(boolean z10) {
        this.f21539k.G(z10);
    }

    public void setErrorIconDrawable(int i10) {
        this.f21523c.b0(i10);
    }

    public void setErrorIconOnClickListener(View.OnClickListener onClickListener) {
        this.f21523c.d0(onClickListener);
    }

    public void setErrorIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f21523c.e0(onLongClickListener);
    }

    public void setErrorIconTintList(ColorStateList colorStateList) {
        this.f21523c.f0(colorStateList);
    }

    public void setErrorIconTintMode(PorterDuff.Mode mode) {
        this.f21523c.g0(mode);
    }

    public void setErrorTextAppearance(int i10) {
        this.f21539k.H(i10);
    }

    public void setErrorTextColor(ColorStateList colorStateList) {
        this.f21539k.I(colorStateList);
    }

    public void setExpandedHintEnabled(boolean z10) {
        if (this.f21496F0 != z10) {
            this.f21496F0 = z10;
            w0(false);
        }
    }

    public void setHelperText(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            if (P()) {
                setHelperTextEnabled(false);
            }
        } else {
            if (!P()) {
                setHelperTextEnabled(true);
            }
            this.f21539k.R(charSequence);
        }
    }

    public void setHelperTextColor(ColorStateList colorStateList) {
        this.f21539k.L(colorStateList);
    }

    public void setHelperTextEnabled(boolean z10) {
        this.f21539k.K(z10);
    }

    public void setHelperTextTextAppearance(int i10) {
        this.f21539k.J(i10);
    }

    public void setHint(CharSequence charSequence) {
        if (this.f21491D) {
            setHintInternal(charSequence);
            sendAccessibilityEvent(2048);
        }
    }

    public void setHintAnimationEnabled(boolean z10) {
        this.f21498G0 = z10;
    }

    public void setHintEnabled(boolean z10) {
        if (z10 != this.f21491D) {
            this.f21491D = z10;
            if (z10) {
                CharSequence hint = this.f21527e.getHint();
                if (!TextUtils.isEmpty(hint)) {
                    if (TextUtils.isEmpty(this.f21493E)) {
                        setHint(hint);
                    }
                    this.f21527e.setHint((CharSequence) null);
                }
                this.f21495F = true;
            } else {
                this.f21495F = false;
                if (!TextUtils.isEmpty(this.f21493E) && TextUtils.isEmpty(this.f21527e.getHint())) {
                    this.f21527e.setHint(this.f21493E);
                }
                setHintInternal(null);
            }
            if (this.f21527e != null) {
                v0();
            }
        }
    }

    public void setHintMaxLines(int i10) {
        this.f21494E0.T(i10);
        this.f21494E0.e0(i10);
        requestLayout();
    }

    public void setHintTextAppearance(int i10) {
        this.f21494E0.U(i10);
        this.f21540k0 = this.f21494E0.p();
        if (this.f21527e != null) {
            w0(false);
            v0();
        }
    }

    public void setHintTextColor(ColorStateList colorStateList) {
        if (this.f21540k0 != colorStateList) {
            if (this.f21538j0 == null) {
                this.f21494E0.W(colorStateList);
            }
            this.f21540k0 = colorStateList;
            if (this.f21527e != null) {
                w0(false);
            }
        }
    }

    public void setLengthCounter(f fVar) {
        this.f21544o = fVar;
    }

    public void setMaxEms(int i10) {
        this.f21533h = i10;
        EditText editText = this.f21527e;
        if (editText == null || i10 == -1) {
            return;
        }
        editText.setMaxEms(i10);
    }

    public void setMaxWidth(int i10) {
        this.f21537j = i10;
        EditText editText = this.f21527e;
        if (editText == null || i10 == -1) {
            return;
        }
        editText.setMaxWidth(i10);
    }

    public void setMaxWidthResource(int i10) {
        setMaxWidth(getContext().getResources().getDimensionPixelSize(i10));
    }

    public void setMinEms(int i10) {
        this.f21531g = i10;
        EditText editText = this.f21527e;
        if (editText == null || i10 == -1) {
            return;
        }
        editText.setMinEms(i10);
    }

    public void setMinWidth(int i10) {
        this.f21535i = i10;
        EditText editText = this.f21527e;
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
        this.f21523c.i0(i10);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(int i10) {
        this.f21523c.k0(i10);
    }

    @Deprecated
    public void setPasswordVisibilityToggleEnabled(boolean z10) {
        this.f21523c.m0(z10);
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintList(ColorStateList colorStateList) {
        this.f21523c.n0(colorStateList);
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintMode(PorterDuff.Mode mode) {
        this.f21523c.o0(mode);
    }

    public void setPlaceholderText(CharSequence charSequence) {
        if (this.f21551u == null) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
            this.f21551u = appCompatTextView;
            appCompatTextView.setId(R$id.textinput_placeholder);
            this.f21551u.setImportantForAccessibility(1);
            this.f21551u.setAccessibilityLiveRegion(1);
            C5042c c5042cB = B();
            this.f21557x = c5042cB;
            c5042cB.r0(67L);
            this.f21559y = B();
            setPlaceholderTextAppearance(this.f21555w);
            setPlaceholderTextColor(this.f21553v);
            N.i0(this.f21551u, new b());
        }
        if (TextUtils.isEmpty(charSequence)) {
            setPlaceholderTextEnabled(false);
        } else {
            if (!this.f21549t) {
                setPlaceholderTextEnabled(true);
            }
            this.f21548s = charSequence;
        }
        z0();
    }

    public void setPlaceholderTextAppearance(int i10) {
        this.f21555w = i10;
        TextView textView = this.f21551u;
        if (textView != null) {
            androidx.core.widget.i.m(textView, i10);
        }
    }

    public void setPlaceholderTextColor(ColorStateList colorStateList) {
        if (this.f21553v != colorStateList) {
            this.f21553v = colorStateList;
            TextView textView = this.f21551u;
            if (textView == null || colorStateList == null) {
                return;
            }
            textView.setTextColor(colorStateList);
        }
    }

    public void setPrefixText(CharSequence charSequence) {
        this.f21521b.n(charSequence);
    }

    public void setPrefixTextAppearance(int i10) {
        this.f21521b.o(i10);
    }

    public void setPrefixTextColor(ColorStateList colorStateList) {
        this.f21521b.p(colorStateList);
    }

    public void setShapeAppearanceModel(Z2.l lVar) {
        Z2.h hVar = this.f21497G;
        if (hVar == null || hVar.I() == lVar) {
            return;
        }
        this.f21508M = lVar;
        n();
    }

    public void setStartIconCheckable(boolean z10) {
        this.f21521b.q(z10);
    }

    public void setStartIconContentDescription(int i10) {
        setStartIconContentDescription(i10 != 0 ? getResources().getText(i10) : null);
    }

    public void setStartIconDrawable(int i10) {
        setStartIconDrawable(i10 != 0 ? C4027a.b(getContext(), i10) : null);
    }

    public void setStartIconMinSize(int i10) {
        this.f21521b.t(i10);
    }

    public void setStartIconOnClickListener(View.OnClickListener onClickListener) {
        this.f21521b.u(onClickListener);
    }

    public void setStartIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f21521b.v(onLongClickListener);
    }

    public void setStartIconScaleType(ImageView.ScaleType scaleType) {
        this.f21521b.w(scaleType);
    }

    public void setStartIconTintList(ColorStateList colorStateList) {
        this.f21521b.x(colorStateList);
    }

    public void setStartIconTintMode(PorterDuff.Mode mode) {
        this.f21521b.y(mode);
    }

    public void setStartIconVisible(boolean z10) {
        this.f21521b.z(z10);
    }

    public void setSuffixText(CharSequence charSequence) {
        this.f21523c.p0(charSequence);
    }

    public void setSuffixTextAppearance(int i10) {
        this.f21523c.q0(i10);
    }

    public void setSuffixTextColor(ColorStateList colorStateList) {
        this.f21523c.r0(colorStateList);
    }

    public void setTextInputAccessibilityDelegate(e eVar) {
        EditText editText = this.f21527e;
        if (editText != null) {
            N.i0(editText, eVar);
        }
    }

    public void setTypeface(Typeface typeface) {
        if (typeface != this.f21524c0) {
            this.f21524c0 = typeface;
            this.f21494E0.p0(typeface);
            this.f21539k.N(typeface);
            TextView textView = this.f21545p;
            if (textView != null) {
                textView.setTypeface(typeface);
            }
        }
    }

    public final int t(Rect rect, Rect rect2, float f10) {
        return U() ? (int) (rect2.top + f10) : rect.bottom - this.f21527e.getCompoundPaddingBottom();
    }

    public final void t0(int i10) throws StaticLayoutBuilderCompat.StaticLayoutBuilderCompatException {
        if (this.f21527e == null) {
            return;
        }
        float fZ = this.f21494E0.z();
        if (this.f21548s != null) {
            TextPaint textPaint = new TextPaint(129);
            textPaint.set(this.f21551u.getPaint());
            textPaint.setTextSize(this.f21551u.getTextSize());
            textPaint.setTypeface(this.f21551u.getTypeface());
            textPaint.setLetterSpacing(this.f21551u.getLetterSpacing());
            fQ = (this.f21511P == 1 ? this.f21525d + this.f21494E0.q() + this.f21512Q : 0.0f) + StaticLayoutBuilderCompat.b(this.f21548s, textPaint, i10).g(getLayoutDirection() == 1).f(true).h(this.f21551u.getLineSpacingExtra(), this.f21551u.getLineSpacingMultiplier()).j(new com.google.android.material.internal.o() { // from class: com.google.android.material.textfield.C
                @Override // com.google.android.material.internal.o
                public final void a(StaticLayout.Builder builder) {
                    builder.setBreakStrategy(this.f21480a.f21551u.getBreakStrategy());
                }
            }).a().getHeight();
        }
        float fMax = Math.max(fZ, fQ);
        if (this.f21527e.getMeasuredHeight() < fMax) {
            this.f21527e.setMinimumHeight(Math.round(fMax));
        }
    }

    public final int u(Rect rect, float f10) {
        if (U()) {
            return (int) (rect.centerY() - (f10 / 2.0f));
        }
        return (rect.top + this.f21527e.getCompoundPaddingTop()) - ((this.f21511P != 0 || R()) ? 0 : (int) (this.f21494E0.A() / 2.0f));
    }

    public final boolean u0() {
        int iMax;
        if (this.f21527e == null || this.f21527e.getMeasuredHeight() >= (iMax = Math.max(this.f21523c.getMeasuredHeight(), this.f21521b.getMeasuredHeight()))) {
            return false;
        }
        this.f21527e.setMinimumHeight(iMax);
        return true;
    }

    public final Rect v(Rect rect) {
        if (this.f21527e == null) {
            throw new IllegalStateException();
        }
        Rect rect2 = this.f21520a0;
        float fA = R() ? this.f21494E0.A() : this.f21494E0.y() * this.f21494E0.w();
        rect2.left = rect.left + this.f21527e.getCompoundPaddingLeft();
        rect2.top = u(rect, fA);
        rect2.right = rect.right - this.f21527e.getCompoundPaddingRight();
        rect2.bottom = t(rect, rect2, fA);
        return rect2;
    }

    public final void v0() {
        if (this.f21511P != 1) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f21519a.getLayoutParams();
            int iW = w();
            if (iW != layoutParams.topMargin) {
                layoutParams.topMargin = iW;
                this.f21519a.requestLayout();
            }
        }
    }

    public final int w() {
        if (!this.f21491D) {
            return 0;
        }
        int i10 = this.f21511P;
        if (i10 == 0) {
            return (int) this.f21494E0.q();
        }
        if (i10 != 2) {
            return 0;
        }
        return R() ? (int) (this.f21494E0.q() / 2.0f) : Math.max(0, (int) (this.f21494E0.q() - (this.f21494E0.n() / 2.0f)));
    }

    public void w0(boolean z10) {
        x0(z10, false);
    }

    public final boolean x() {
        return this.f21511P == 2 && y();
    }

    public final void x0(boolean z10, boolean z11) {
        ColorStateList colorStateList;
        TextView textView;
        boolean zIsEnabled = isEnabled();
        EditText editText = this.f21527e;
        boolean z12 = false;
        boolean z13 = (editText == null || TextUtils.isEmpty(editText.getText())) ? false : true;
        EditText editText2 = this.f21527e;
        if (editText2 != null && editText2.hasFocus()) {
            z12 = true;
        }
        ColorStateList colorStateList2 = this.f21538j0;
        if (colorStateList2 != null) {
            this.f21494E0.Q(colorStateList2);
        }
        if (!zIsEnabled) {
            ColorStateList colorStateList3 = this.f21538j0;
            this.f21494E0.Q(ColorStateList.valueOf(colorStateList3 != null ? colorStateList3.getColorForState(new int[]{-16842910}, this.f21488B0) : this.f21488B0));
        } else if (d0()) {
            this.f21494E0.Q(this.f21539k.r());
        } else if (this.f21543n && (textView = this.f21545p) != null) {
            this.f21494E0.Q(textView.getTextColors());
        } else if (z12 && (colorStateList = this.f21540k0) != null) {
            this.f21494E0.W(colorStateList);
        }
        if (z13 || !this.f21496F0 || (isEnabled() && z12)) {
            if (z11 || this.f21492D0) {
                A(z10);
                return;
            }
            return;
        }
        if (z11 || !this.f21492D0) {
            G(z10);
        }
    }

    public final boolean y() {
        return this.f21513R > -1 && this.f21516U != 0;
    }

    public final void y0() {
        EditText editText;
        if (this.f21551u == null || (editText = this.f21527e) == null) {
            return;
        }
        this.f21551u.setGravity(editText.getGravity());
        this.f21551u.setPadding(this.f21527e.getCompoundPaddingLeft(), this.f21527e.getCompoundPaddingTop(), this.f21527e.getCompoundPaddingRight(), this.f21527e.getCompoundPaddingBottom());
    }

    public final void z() {
        if (C()) {
            ((com.google.android.material.textfield.h) this.f21497G).A0();
        }
    }

    public final void z0() {
        EditText editText = this.f21527e;
        A0(editText == null ? null : editText.getText());
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public TextInputLayout(Context context, AttributeSet attributeSet, int i10) {
        int i11 = f21483L0;
        super(C3953a.d(context, attributeSet, i10, i11), attributeSet, i10);
        this.f21531g = -1;
        this.f21533h = -1;
        this.f21535i = -1;
        this.f21537j = -1;
        this.f21539k = new u(this);
        this.f21544o = new f() { // from class: com.google.android.material.textfield.B
            @Override // com.google.android.material.textfield.TextInputLayout.f
            public final int a(Editable editable) {
                return TextInputLayout.c(editable);
            }
        };
        this.f21518W = new Rect();
        this.f21520a0 = new Rect();
        this.f21522b0 = new RectF();
        this.f21530f0 = new LinkedHashSet<>();
        com.google.android.material.internal.a aVar = new com.google.android.material.internal.a(this);
        this.f21494E0 = aVar;
        this.f21506K0 = false;
        Context context2 = getContext();
        setOrientation(1);
        setWillNotDraw(false);
        setAddStatesFromChildren(true);
        FrameLayout frameLayout = new FrameLayout(context2);
        this.f21519a = frameLayout;
        frameLayout.setAddStatesFromChildren(true);
        TimeInterpolator timeInterpolator = E2.a.f2339a;
        aVar.o0(timeInterpolator);
        aVar.l0(timeInterpolator);
        aVar.X(8388659);
        int[] iArr = R$styleable.TextInputLayout;
        int i12 = R$styleable.TextInputLayout_counterTextAppearance;
        int i13 = R$styleable.TextInputLayout_counterOverflowTextAppearance;
        int i14 = R$styleable.TextInputLayout_errorTextAppearance;
        int i15 = R$styleable.TextInputLayout_helperTextTextAppearance;
        int i16 = R$styleable.TextInputLayout_hintTextAppearance;
        U uJ = com.google.android.material.internal.r.j(context2, attributeSet, iArr, i10, i11, i12, i13, i14, i15, i16);
        z zVar = new z(this, uJ);
        this.f21521b = zVar;
        this.f21491D = uJ.a(R$styleable.TextInputLayout_hintEnabled, true);
        setHint(uJ.p(R$styleable.TextInputLayout_android_hint));
        this.f21498G0 = uJ.a(R$styleable.TextInputLayout_hintAnimationEnabled, true);
        this.f21496F0 = uJ.a(R$styleable.TextInputLayout_expandedHintEnabled, true);
        int i17 = R$styleable.TextInputLayout_android_minEms;
        if (uJ.s(i17)) {
            setMinEms(uJ.k(i17, -1));
        } else {
            int i18 = R$styleable.TextInputLayout_android_minWidth;
            if (uJ.s(i18)) {
                setMinWidth(uJ.f(i18, -1));
            }
        }
        int i19 = R$styleable.TextInputLayout_android_maxEms;
        if (uJ.s(i19)) {
            setMaxEms(uJ.k(i19, -1));
        } else {
            int i20 = R$styleable.TextInputLayout_android_maxWidth;
            if (uJ.s(i20)) {
                setMaxWidth(uJ.f(i20, -1));
            }
        }
        this.f21508M = Z2.l.e(context2, attributeSet, i10, i11).m();
        this.f21510O = context2.getResources().getDimensionPixelOffset(R$dimen.mtrl_textinput_box_label_cutout_padding);
        this.f21512Q = uJ.e(R$styleable.TextInputLayout_boxCollapsedPaddingTop, 0);
        this.f21525d = getResources().getDimensionPixelSize(R$dimen.m3_multiline_hint_filled_text_extra_space);
        this.f21514S = uJ.f(R$styleable.TextInputLayout_boxStrokeWidth, context2.getResources().getDimensionPixelSize(R$dimen.mtrl_textinput_box_stroke_width_default));
        this.f21515T = uJ.f(R$styleable.TextInputLayout_boxStrokeWidthFocused, context2.getResources().getDimensionPixelSize(R$dimen.mtrl_textinput_box_stroke_width_focused));
        this.f21513R = this.f21514S;
        float fD = uJ.d(R$styleable.TextInputLayout_boxCornerRadiusTopStart, -1.0f);
        float fD2 = uJ.d(R$styleable.TextInputLayout_boxCornerRadiusTopEnd, -1.0f);
        float fD3 = uJ.d(R$styleable.TextInputLayout_boxCornerRadiusBottomEnd, -1.0f);
        float fD4 = uJ.d(R$styleable.TextInputLayout_boxCornerRadiusBottomStart, -1.0f);
        l.b bVarW = this.f21508M.w();
        if (fD >= 0.0f) {
            bVarW.C(fD);
        }
        if (fD2 >= 0.0f) {
            bVarW.G(fD2);
        }
        if (fD3 >= 0.0f) {
            bVarW.y(fD3);
        }
        if (fD4 >= 0.0f) {
            bVarW.u(fD4);
        }
        this.f21508M = bVarW.m();
        ColorStateList colorStateListB = W2.c.b(context2, uJ, R$styleable.TextInputLayout_boxBackgroundColor);
        if (colorStateListB != null) {
            int defaultColor = colorStateListB.getDefaultColor();
            this.f21558x0 = defaultColor;
            this.f21517V = defaultColor;
            if (colorStateListB.isStateful()) {
                this.f21560y0 = colorStateListB.getColorForState(new int[]{-16842910}, -1);
                this.f21562z0 = colorStateListB.getColorForState(new int[]{R.attr.state_focused, R.attr.state_enabled}, -1);
                this.f21486A0 = colorStateListB.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, -1);
            } else {
                this.f21562z0 = this.f21558x0;
                ColorStateList colorStateListA = C4027a.a(context2, R$color.mtrl_filled_background_color);
                this.f21560y0 = colorStateListA.getColorForState(new int[]{-16842910}, -1);
                this.f21486A0 = colorStateListA.getColorForState(new int[]{R.attr.state_hovered}, -1);
            }
        } else {
            this.f21517V = 0;
            this.f21558x0 = 0;
            this.f21560y0 = 0;
            this.f21562z0 = 0;
            this.f21486A0 = 0;
        }
        int i21 = R$styleable.TextInputLayout_android_textColorHint;
        if (uJ.s(i21)) {
            ColorStateList colorStateListC = uJ.c(i21);
            this.f21540k0 = colorStateListC;
            this.f21538j0 = colorStateListC;
        }
        int i22 = R$styleable.TextInputLayout_boxStrokeColor;
        ColorStateList colorStateListB2 = W2.c.b(context2, uJ, i22);
        this.f21554v0 = uJ.b(i22, 0);
        this.f21550t0 = androidx.core.content.a.c(context2, R$color.mtrl_textinput_default_box_stroke_color);
        this.f21488B0 = androidx.core.content.a.c(context2, R$color.mtrl_textinput_disabled_color);
        this.f21552u0 = androidx.core.content.a.c(context2, R$color.mtrl_textinput_hovered_box_stroke_color);
        if (colorStateListB2 != null) {
            setBoxStrokeColorStateList(colorStateListB2);
        }
        int i23 = R$styleable.TextInputLayout_boxStrokeErrorColor;
        if (uJ.s(i23)) {
            setBoxStrokeErrorColor(W2.c.b(context2, uJ, i23));
        }
        if (uJ.n(i16, -1) != -1) {
            setHintTextAppearance(uJ.n(i16, 0));
        }
        this.f21487B = uJ.c(R$styleable.TextInputLayout_cursorColor);
        this.f21489C = uJ.c(R$styleable.TextInputLayout_cursorErrorColor);
        int iN = uJ.n(i14, 0);
        CharSequence charSequenceP = uJ.p(R$styleable.TextInputLayout_errorContentDescription);
        int iK = uJ.k(R$styleable.TextInputLayout_errorAccessibilityLiveRegion, 1);
        boolean zA = uJ.a(R$styleable.TextInputLayout_errorEnabled, false);
        int iN2 = uJ.n(i15, 0);
        boolean zA2 = uJ.a(R$styleable.TextInputLayout_helperTextEnabled, false);
        CharSequence charSequenceP2 = uJ.p(R$styleable.TextInputLayout_helperText);
        int iN3 = uJ.n(R$styleable.TextInputLayout_placeholderTextAppearance, 0);
        CharSequence charSequenceP3 = uJ.p(R$styleable.TextInputLayout_placeholderText);
        boolean zA3 = uJ.a(R$styleable.TextInputLayout_counterEnabled, false);
        setCounterMaxLength(uJ.k(R$styleable.TextInputLayout_counterMaxLength, -1));
        this.f21547r = uJ.n(i12, 0);
        this.f21546q = uJ.n(i13, 0);
        setBoxBackgroundMode(uJ.k(R$styleable.TextInputLayout_boxBackgroundMode, 0));
        setErrorContentDescription(charSequenceP);
        setErrorAccessibilityLiveRegion(iK);
        setCounterOverflowTextAppearance(this.f21546q);
        setHelperTextTextAppearance(iN2);
        setErrorTextAppearance(iN);
        setCounterTextAppearance(this.f21547r);
        setPlaceholderText(charSequenceP3);
        setPlaceholderTextAppearance(iN3);
        int i24 = R$styleable.TextInputLayout_errorTextColor;
        if (uJ.s(i24)) {
            setErrorTextColor(uJ.c(i24));
        }
        int i25 = R$styleable.TextInputLayout_helperTextTextColor;
        if (uJ.s(i25)) {
            setHelperTextColor(uJ.c(i25));
        }
        int i26 = R$styleable.TextInputLayout_hintTextColor;
        if (uJ.s(i26)) {
            setHintTextColor(uJ.c(i26));
        }
        int i27 = R$styleable.TextInputLayout_counterTextColor;
        if (uJ.s(i27)) {
            setCounterTextColor(uJ.c(i27));
        }
        int i28 = R$styleable.TextInputLayout_counterOverflowTextColor;
        if (uJ.s(i28)) {
            setCounterOverflowTextColor(uJ.c(i28));
        }
        int i29 = R$styleable.TextInputLayout_placeholderTextColor;
        if (uJ.s(i29)) {
            setPlaceholderTextColor(uJ.c(i29));
        }
        r rVar = new r(this, uJ);
        this.f21523c = rVar;
        boolean zA4 = uJ.a(R$styleable.TextInputLayout_android_enabled, true);
        setHintMaxLines(uJ.k(R$styleable.TextInputLayout_hintMaxLines, 1));
        uJ.x();
        setImportantForAccessibility(2);
        setImportantForAutofill(1);
        frameLayout.addView(zVar);
        frameLayout.addView(rVar);
        addView(frameLayout);
        setEnabled(zA4);
        setHelperTextEnabled(zA2);
        setErrorEnabled(zA);
        setCounterEnabled(zA3);
        setHelperText(charSequenceP2);
    }

    public void setEndIconContentDescription(CharSequence charSequence) {
        this.f21523c.Q(charSequence);
    }

    public void setEndIconDrawable(Drawable drawable) {
        this.f21523c.S(drawable);
    }

    public void setErrorIconDrawable(Drawable drawable) {
        this.f21523c.c0(drawable);
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(CharSequence charSequence) {
        this.f21523c.j0(charSequence);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(Drawable drawable) {
        this.f21523c.l0(drawable);
    }

    public void setStartIconContentDescription(CharSequence charSequence) {
        this.f21521b.r(charSequence);
    }

    public void setStartIconDrawable(Drawable drawable) {
        this.f21521b.s(drawable);
    }

    public void setHint(int i10) {
        setHint(i10 != 0 ? getResources().getText(i10) : null);
    }
}
