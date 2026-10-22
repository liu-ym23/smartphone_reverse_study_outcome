package com.google.android.material.textfield;

import a1.C0409b;
import a1.C0410c;
import a1.C0411d;
import a1.C0413f;
import a1.C0416i;
import a1.C0417j;
import a1.C0418k;
import android.R;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
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
import androidx.appcompat.widget.C0441k;
import androidx.appcompat.widget.D;
import androidx.appcompat.widget.I;
import androidx.appcompat.widget.a0;
import androidx.core.view.C0456a;
import androidx.core.view.H;
import androidx.recyclerview.widget.RecyclerView;
import androidx.transition.C0548c;
import b1.C0553a;
import com.google.android.material.internal.CheckableImageButton;
import g.C0728a;
import h.C0744a;
import j1.C0777a;
import java.util.Iterator;
import java.util.LinkedHashSet;
import org.libpag.BuildConfig;
import q1.C0981c;
import t1.C1115h;
import t1.l;
import x1.C1282a;

/* loaded from: classes.dex */
public class TextInputLayout extends LinearLayout implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: G0, reason: collision with root package name */
    private static final int f13214G0 = C0417j.f6917h;

    /* renamed from: H0, reason: collision with root package name */
    private static final int[][] f13215H0 = {new int[]{R.attr.state_pressed}, new int[0]};

    /* renamed from: A, reason: collision with root package name */
    private ColorStateList f13216A;

    /* renamed from: A0, reason: collision with root package name */
    private boolean f13217A0;

    /* renamed from: B, reason: collision with root package name */
    private ColorStateList f13218B;

    /* renamed from: B0, reason: collision with root package name */
    private boolean f13219B0;

    /* renamed from: C, reason: collision with root package name */
    private ColorStateList f13220C;

    /* renamed from: C0, reason: collision with root package name */
    private ValueAnimator f13221C0;

    /* renamed from: D, reason: collision with root package name */
    private boolean f13222D;

    /* renamed from: D0, reason: collision with root package name */
    private boolean f13223D0;

    /* renamed from: E, reason: collision with root package name */
    private CharSequence f13224E;

    /* renamed from: E0, reason: collision with root package name */
    private boolean f13225E0;

    /* renamed from: F, reason: collision with root package name */
    private boolean f13226F;

    /* renamed from: F0, reason: collision with root package name */
    private boolean f13227F0;

    /* renamed from: G, reason: collision with root package name */
    private C1115h f13228G;

    /* renamed from: H, reason: collision with root package name */
    private C1115h f13229H;

    /* renamed from: I, reason: collision with root package name */
    private StateListDrawable f13230I;

    /* renamed from: J, reason: collision with root package name */
    private boolean f13231J;

    /* renamed from: K, reason: collision with root package name */
    private C1115h f13232K;

    /* renamed from: L, reason: collision with root package name */
    private C1115h f13233L;

    /* renamed from: M, reason: collision with root package name */
    private t1.l f13234M;

    /* renamed from: Q, reason: collision with root package name */
    private boolean f13235Q;

    /* renamed from: R, reason: collision with root package name */
    private final int f13236R;

    /* renamed from: S, reason: collision with root package name */
    private int f13237S;

    /* renamed from: T, reason: collision with root package name */
    private int f13238T;

    /* renamed from: U, reason: collision with root package name */
    private int f13239U;

    /* renamed from: V, reason: collision with root package name */
    private int f13240V;

    /* renamed from: W, reason: collision with root package name */
    private int f13241W;

    /* renamed from: a, reason: collision with root package name */
    private final FrameLayout f13242a;

    /* renamed from: a0, reason: collision with root package name */
    private int f13243a0;

    /* renamed from: b, reason: collision with root package name */
    private final z f13244b;

    /* renamed from: b0, reason: collision with root package name */
    private int f13245b0;

    /* renamed from: c, reason: collision with root package name */
    private final r f13246c;

    /* renamed from: c0, reason: collision with root package name */
    private final Rect f13247c0;

    /* renamed from: d, reason: collision with root package name */
    private final int f13248d;

    /* renamed from: d0, reason: collision with root package name */
    private final Rect f13249d0;

    /* renamed from: e, reason: collision with root package name */
    EditText f13250e;

    /* renamed from: e0, reason: collision with root package name */
    private final RectF f13251e0;

    /* renamed from: f, reason: collision with root package name */
    private CharSequence f13252f;

    /* renamed from: f0, reason: collision with root package name */
    private Typeface f13253f0;

    /* renamed from: g, reason: collision with root package name */
    private int f13254g;

    /* renamed from: g0, reason: collision with root package name */
    private Drawable f13255g0;

    /* renamed from: h, reason: collision with root package name */
    private int f13256h;

    /* renamed from: h0, reason: collision with root package name */
    private int f13257h0;

    /* renamed from: i, reason: collision with root package name */
    private int f13258i;

    /* renamed from: i0, reason: collision with root package name */
    private final LinkedHashSet<g> f13259i0;

    /* renamed from: j, reason: collision with root package name */
    private int f13260j;

    /* renamed from: j0, reason: collision with root package name */
    private Drawable f13261j0;

    /* renamed from: k, reason: collision with root package name */
    private final u f13262k;

    /* renamed from: k0, reason: collision with root package name */
    private int f13263k0;

    /* renamed from: l, reason: collision with root package name */
    boolean f13264l;

    /* renamed from: l0, reason: collision with root package name */
    private Drawable f13265l0;

    /* renamed from: m, reason: collision with root package name */
    private int f13266m;

    /* renamed from: m0, reason: collision with root package name */
    private ColorStateList f13267m0;

    /* renamed from: n, reason: collision with root package name */
    private boolean f13268n;

    /* renamed from: n0, reason: collision with root package name */
    private ColorStateList f13269n0;

    /* renamed from: o, reason: collision with root package name */
    private f f13270o;

    /* renamed from: o0, reason: collision with root package name */
    private int f13271o0;

    /* renamed from: p, reason: collision with root package name */
    private TextView f13272p;

    /* renamed from: p0, reason: collision with root package name */
    private int f13273p0;

    /* renamed from: q, reason: collision with root package name */
    private int f13274q;

    /* renamed from: q0, reason: collision with root package name */
    private int f13275q0;

    /* renamed from: r, reason: collision with root package name */
    private int f13276r;

    /* renamed from: r0, reason: collision with root package name */
    private ColorStateList f13277r0;

    /* renamed from: s, reason: collision with root package name */
    private CharSequence f13278s;

    /* renamed from: s0, reason: collision with root package name */
    private int f13279s0;

    /* renamed from: t, reason: collision with root package name */
    private boolean f13280t;

    /* renamed from: t0, reason: collision with root package name */
    private int f13281t0;

    /* renamed from: u, reason: collision with root package name */
    private TextView f13282u;

    /* renamed from: u0, reason: collision with root package name */
    private int f13283u0;

    /* renamed from: v, reason: collision with root package name */
    private ColorStateList f13284v;

    /* renamed from: v0, reason: collision with root package name */
    private int f13285v0;

    /* renamed from: w, reason: collision with root package name */
    private int f13286w;

    /* renamed from: w0, reason: collision with root package name */
    private int f13287w0;

    /* renamed from: x, reason: collision with root package name */
    private C0548c f13288x;

    /* renamed from: x0, reason: collision with root package name */
    int f13289x0;

    /* renamed from: y, reason: collision with root package name */
    private C0548c f13290y;

    /* renamed from: y0, reason: collision with root package name */
    private boolean f13291y0;

    /* renamed from: z, reason: collision with root package name */
    private ColorStateList f13292z;

    /* renamed from: z0, reason: collision with root package name */
    final com.google.android.material.internal.a f13293z0;

    class a implements TextWatcher {

        /* renamed from: a, reason: collision with root package name */
        int f13294a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ EditText f13295b;

        a(EditText editText) {
            this.f13295b = editText;
            this.f13294a = editText.getLineCount();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TextInputLayout.this.w0(!r0.f13225E0);
            TextInputLayout textInputLayout = TextInputLayout.this;
            if (textInputLayout.f13264l) {
                textInputLayout.l0(editable);
            }
            if (TextInputLayout.this.f13280t) {
                TextInputLayout.this.A0(editable);
            }
            int lineCount = this.f13295b.getLineCount();
            int i5 = this.f13294a;
            if (lineCount != i5) {
                if (lineCount < i5) {
                    int minimumHeight = this.f13295b.getMinimumHeight();
                    int i6 = TextInputLayout.this.f13289x0;
                    if (minimumHeight != i6) {
                        this.f13295b.setMinimumHeight(i6);
                    }
                }
                this.f13294a = lineCount;
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i5, int i6, int i7) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i5, int i6, int i7) {
        }
    }

    class b extends C0456a {
        b() {
        }

        @Override // androidx.core.view.C0456a
        public void onInitializeAccessibilityNodeInfo(View view, E.c cVar) {
            super.onInitializeAccessibilityNodeInfo(view, cVar);
            cVar.C0(false);
        }
    }

    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TextInputLayout.this.f13246c.h();
        }
    }

    class d implements ValueAnimator.AnimatorUpdateListener {
        d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            TextInputLayout.this.f13293z0.j0(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    public static class e extends C0456a {

        /* renamed from: a, reason: collision with root package name */
        private final TextInputLayout f13300a;

        public e(TextInputLayout textInputLayout) {
            this.f13300a = textInputLayout;
        }

        @Override // androidx.core.view.C0456a
        public void onInitializeAccessibilityNodeInfo(View view, E.c cVar) {
            super.onInitializeAccessibilityNodeInfo(view, cVar);
            EditText editText = this.f13300a.getEditText();
            CharSequence text = editText != null ? editText.getText() : null;
            CharSequence hint = this.f13300a.getHint();
            CharSequence error = this.f13300a.getError();
            CharSequence placeholderText = this.f13300a.getPlaceholderText();
            int counterMaxLength = this.f13300a.getCounterMaxLength();
            CharSequence counterOverflowDescription = this.f13300a.getCounterOverflowDescription();
            boolean zIsEmpty = TextUtils.isEmpty(text);
            boolean zIsEmpty2 = TextUtils.isEmpty(hint);
            boolean zQ = this.f13300a.Q();
            boolean zIsEmpty3 = TextUtils.isEmpty(error);
            boolean z5 = (zIsEmpty3 && TextUtils.isEmpty(counterOverflowDescription)) ? false : true;
            String string = !zIsEmpty2 ? hint.toString() : BuildConfig.FLAVOR;
            this.f13300a.f13244b.A(cVar);
            if (!zIsEmpty) {
                cVar.A0(text);
            } else if (!TextUtils.isEmpty(string)) {
                cVar.A0(string);
                if (!zQ && placeholderText != null) {
                    cVar.A0(string + ", " + ((Object) placeholderText));
                }
            } else if (placeholderText != null) {
                cVar.A0(placeholderText);
            }
            if (!TextUtils.isEmpty(string)) {
                cVar.o0(string);
                cVar.x0(zIsEmpty);
            }
            if (text == null || text.length() != counterMaxLength) {
                counterMaxLength = -1;
            }
            cVar.q0(counterMaxLength);
            if (z5) {
                if (zIsEmpty3) {
                    error = counterOverflowDescription;
                }
                cVar.k0(error);
            }
            View viewT = this.f13300a.f13262k.t();
            if (viewT != null) {
                cVar.p0(viewT);
            }
            this.f13300a.f13246c.m().o(view, cVar);
        }

        @Override // androidx.core.view.C0456a
        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onPopulateAccessibilityEvent(view, accessibilityEvent);
            this.f13300a.f13246c.m().p(view, accessibilityEvent);
        }
    }

    public interface f {
        int a(Editable editable);
    }

    public interface g {
        void a(TextInputLayout textInputLayout);
    }

    public interface h {
        void a(TextInputLayout textInputLayout, int i5);
    }

    static class i extends androidx.customview.view.a {
        public static final Parcelable.Creator<i> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        CharSequence f13301a;

        /* renamed from: b, reason: collision with root package name */
        boolean f13302b;

        class a implements Parcelable.ClassLoaderCreator<i> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public i createFromParcel(Parcel parcel) {
                return new i(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public i createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new i(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public i[] newArray(int i5) {
                return new i[i5];
            }
        }

        i(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + ((Object) this.f13301a) + "}";
        }

        @Override // androidx.customview.view.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i5) {
            super.writeToParcel(parcel, i5);
            TextUtils.writeToParcel(this.f13301a, parcel, i5);
            parcel.writeInt(this.f13302b ? 1 : 0);
        }

        i(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f13301a = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f13302b = parcel.readInt() == 1;
        }
    }

    public TextInputLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0409b.f6712V);
    }

    private void A(boolean z5) {
        ValueAnimator valueAnimator = this.f13221C0;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f13221C0.cancel();
        }
        if (z5 && this.f13219B0) {
            m(1.0f);
        } else {
            this.f13293z0.j0(1.0f);
        }
        this.f13291y0 = false;
        if (C()) {
            W();
        }
        z0();
        this.f13244b.l(false);
        this.f13246c.H(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0(Editable editable) {
        if (this.f13270o.a(editable) != 0 || this.f13291y0) {
            M();
        } else {
            g0();
        }
    }

    private C0548c B() {
        C0548c c0548c = new C0548c();
        c0548c.c0(o1.e.f(getContext(), C0409b.f6691A, 87));
        c0548c.e0(o1.e.g(getContext(), C0409b.f6697G, C0553a.f11783a));
        return c0548c;
    }

    private void B0(boolean z5, boolean z6) {
        int defaultColor = this.f13277r0.getDefaultColor();
        int colorForState = this.f13277r0.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, defaultColor);
        int colorForState2 = this.f13277r0.getColorForState(new int[]{R.attr.state_activated, R.attr.state_enabled}, defaultColor);
        if (z5) {
            this.f13243a0 = colorForState2;
        } else if (z6) {
            this.f13243a0 = colorForState;
        } else {
            this.f13243a0 = defaultColor;
        }
    }

    private boolean C() {
        return this.f13222D && !TextUtils.isEmpty(this.f13224E) && (this.f13228G instanceof com.google.android.material.textfield.h);
    }

    private void D() {
        Iterator<g> it = this.f13259i0.iterator();
        while (it.hasNext()) {
            it.next().a(this);
        }
    }

    private void E(Canvas canvas) {
        C1115h c1115h;
        if (this.f13233L == null || (c1115h = this.f13232K) == null) {
            return;
        }
        c1115h.draw(canvas);
        if (this.f13250e.isFocused()) {
            Rect bounds = this.f13233L.getBounds();
            Rect bounds2 = this.f13232K.getBounds();
            float fB = this.f13293z0.B();
            int iCenterX = bounds2.centerX();
            bounds.left = C0553a.c(iCenterX, bounds2.left, fB);
            bounds.right = C0553a.c(iCenterX, bounds2.right, fB);
            this.f13233L.draw(canvas);
        }
    }

    private void F(Canvas canvas) {
        if (this.f13222D) {
            this.f13293z0.k(canvas);
        }
    }

    private void G(boolean z5) {
        ValueAnimator valueAnimator = this.f13221C0;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f13221C0.cancel();
        }
        if (z5 && this.f13219B0) {
            m(0.0f);
        } else {
            this.f13293z0.j0(0.0f);
        }
        if (C() && ((com.google.android.material.textfield.h) this.f13228G).z0()) {
            z();
        }
        this.f13291y0 = true;
        M();
        this.f13244b.l(true);
        this.f13246c.H(true);
    }

    private C1115h H(boolean z5) throws Resources.NotFoundException {
        float dimensionPixelOffset = getResources().getDimensionPixelOffset(C0411d.f6779d0);
        float f5 = z5 ? dimensionPixelOffset : 0.0f;
        EditText editText = this.f13250e;
        float popupElevation = editText instanceof v ? ((v) editText).getPopupElevation() : getResources().getDimensionPixelOffset(C0411d.f6799s);
        int dimensionPixelOffset2 = getResources().getDimensionPixelOffset(C0411d.f6775b0);
        t1.l lVarM = t1.l.a().C(f5).G(f5).u(dimensionPixelOffset).y(dimensionPixelOffset).m();
        EditText editText2 = this.f13250e;
        C1115h c1115hR = C1115h.r(getContext(), popupElevation, editText2 instanceof v ? ((v) editText2).getDropDownBackgroundTintList() : null);
        c1115hR.setShapeAppearanceModel(lVarM);
        c1115hR.j0(0, dimensionPixelOffset2, 0, dimensionPixelOffset2);
        return c1115hR;
    }

    private static Drawable I(C1115h c1115h, int i5, int i6, int[][] iArr) {
        return new RippleDrawable(new ColorStateList(iArr, new int[]{C0777a.j(i6, i5, 0.1f), i5}), c1115h, c1115h);
    }

    private int J(int i5, boolean z5) {
        return i5 + ((z5 || getPrefixText() == null) ? (!z5 || getSuffixText() == null) ? this.f13250e.getCompoundPaddingLeft() : this.f13246c.y() : this.f13244b.c());
    }

    private int K(int i5, boolean z5) {
        return i5 - ((z5 || getSuffixText() == null) ? (!z5 || getPrefixText() == null) ? this.f13250e.getCompoundPaddingRight() : this.f13244b.c() : this.f13246c.y());
    }

    private static Drawable L(Context context, C1115h c1115h, int i5, int[][] iArr) {
        int iC = C0777a.c(context, C0409b.f6720g, "TextInputLayout");
        C1115h c1115h2 = new C1115h(c1115h.I());
        int iJ = C0777a.j(i5, iC, 0.1f);
        c1115h2.g0(new ColorStateList(iArr, new int[]{iJ, 0}));
        c1115h2.setTint(iC);
        ColorStateList colorStateList = new ColorStateList(iArr, new int[]{iJ, iC});
        C1115h c1115h3 = new C1115h(c1115h.I());
        c1115h3.setTint(-1);
        return new LayerDrawable(new Drawable[]{new RippleDrawable(colorStateList, c1115h2, c1115h3), c1115h});
    }

    private void M() {
        TextView textView = this.f13282u;
        if (textView == null || !this.f13280t) {
            return;
        }
        textView.setText((CharSequence) null);
        androidx.transition.r.a(this.f13242a, this.f13290y);
        this.f13282u.setVisibility(4);
    }

    private boolean R() {
        return getHintMaxLines() == 1;
    }

    private boolean S() {
        if (d0()) {
            return true;
        }
        return this.f13272p != null && this.f13268n;
    }

    private boolean U() {
        return this.f13237S == 1 && this.f13250e.getMinLines() <= 1;
    }

    private void V() {
        q();
        s0();
        C0();
        h0();
        l();
        if (this.f13237S != 0) {
            v0();
        }
        b0();
    }

    private void W() {
        if (C()) {
            RectF rectF = this.f13251e0;
            this.f13293z0.o(rectF, this.f13250e.getWidth(), this.f13250e.getGravity());
            if (rectF.width() <= 0.0f || rectF.height() <= 0.0f) {
                return;
            }
            p(rectF);
            rectF.offset(-getPaddingLeft(), ((-getPaddingTop()) - (rectF.height() / 2.0f)) + this.f13239U);
            rectF.top = 0.0f;
            ((com.google.android.material.textfield.h) this.f13228G).C0(rectF);
        }
    }

    private void X() {
        if (!C() || this.f13291y0) {
            return;
        }
        z();
        W();
    }

    private static void Y(ViewGroup viewGroup, boolean z5) {
        int childCount = viewGroup.getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = viewGroup.getChildAt(i5);
            childAt.setEnabled(z5);
            if (childAt instanceof ViewGroup) {
                Y((ViewGroup) childAt, z5);
            }
        }
    }

    private void a0() {
        TextView textView = this.f13282u;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    private void b0() {
        EditText editText = this.f13250e;
        if (editText instanceof AutoCompleteTextView) {
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) editText;
            if (autoCompleteTextView.getDropDownBackground() == null) {
                int i5 = this.f13237S;
                if (i5 == 2) {
                    autoCompleteTextView.setDropDownBackgroundDrawable(getOrCreateOutlinedDropDownMenuBackground());
                } else if (i5 == 1) {
                    autoCompleteTextView.setDropDownBackgroundDrawable(getOrCreateFilledDropDownMenuBackground());
                }
            }
        }
    }

    public static /* synthetic */ int c(Editable editable) {
        if (editable != null) {
            return editable.length();
        }
        return 0;
    }

    private boolean e0() {
        return (this.f13246c.G() || ((this.f13246c.A() && N()) || this.f13246c.w() != null)) && this.f13246c.getMeasuredWidth() > 0;
    }

    private boolean f0() {
        return (getStartIconDrawable() != null || (getPrefixText() != null && getPrefixTextView().getVisibility() == 0)) && this.f13244b.getMeasuredWidth() > 0;
    }

    private void g0() {
        if (this.f13282u == null || !this.f13280t || TextUtils.isEmpty(this.f13278s)) {
            return;
        }
        this.f13282u.setText(this.f13278s);
        androidx.transition.r.a(this.f13242a, this.f13288x);
        this.f13282u.setVisibility(0);
        this.f13282u.bringToFront();
    }

    private Drawable getEditTextBoxBackground() {
        EditText editText = this.f13250e;
        if (!(editText instanceof AutoCompleteTextView) || q.a(editText)) {
            return this.f13228G;
        }
        int iD = C0777a.d(this.f13250e, C0728a.f16848y);
        int i5 = this.f13237S;
        if (i5 == 2) {
            return L(getContext(), this.f13228G, iD, f13215H0);
        }
        if (i5 == 1) {
            return I(this.f13228G, this.f13245b0, iD, f13215H0);
        }
        return null;
    }

    private Drawable getOrCreateFilledDropDownMenuBackground() {
        if (this.f13230I == null) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            this.f13230I = stateListDrawable;
            stateListDrawable.addState(new int[]{R.attr.state_above_anchor}, getOrCreateOutlinedDropDownMenuBackground());
            this.f13230I.addState(new int[0], H(false));
        }
        return this.f13230I;
    }

    private Drawable getOrCreateOutlinedDropDownMenuBackground() {
        if (this.f13229H == null) {
            this.f13229H = H(true);
        }
        return this.f13229H;
    }

    private void h0() {
        if (this.f13237S == 1) {
            if (C0981c.h(getContext())) {
                this.f13238T = getResources().getDimensionPixelSize(C0411d.f6753H);
            } else if (C0981c.g(getContext())) {
                this.f13238T = getResources().getDimensionPixelSize(C0411d.f6752G);
            }
        }
    }

    private void i0(Rect rect) {
        C1115h c1115h = this.f13232K;
        if (c1115h != null) {
            int i5 = rect.bottom;
            c1115h.setBounds(rect.left, i5 - this.f13240V, rect.right, i5);
        }
        C1115h c1115h2 = this.f13233L;
        if (c1115h2 != null) {
            int i6 = rect.bottom;
            c1115h2.setBounds(rect.left, i6 - this.f13241W, rect.right, i6);
        }
    }

    private void j0(int i5) {
        this.f13293z0.s0(i5);
        Rect rect = this.f13247c0;
        com.google.android.material.internal.c.a(this, this.f13250e, rect);
        this.f13293z0.S(s(rect));
        v0();
        l();
        t0(i5);
    }

    private void k() {
        TextView textView = this.f13282u;
        if (textView != null) {
            this.f13242a.addView(textView);
            this.f13282u.setVisibility(0);
        }
    }

    private void k0() {
        if (this.f13272p != null) {
            EditText editText = this.f13250e;
            l0(editText == null ? null : editText.getText());
        }
    }

    private void l() {
        if (this.f13250e == null || this.f13237S != 1) {
            return;
        }
        if (!R()) {
            EditText editText = this.f13250e;
            editText.setPaddingRelative(editText.getPaddingStart(), (int) (this.f13293z0.q() + this.f13248d), this.f13250e.getPaddingEnd(), getResources().getDimensionPixelSize(C0411d.f6748C));
        } else if (C0981c.h(getContext())) {
            EditText editText2 = this.f13250e;
            editText2.setPaddingRelative(editText2.getPaddingStart(), getResources().getDimensionPixelSize(C0411d.f6751F), this.f13250e.getPaddingEnd(), getResources().getDimensionPixelSize(C0411d.f6750E));
        } else if (C0981c.g(getContext())) {
            EditText editText3 = this.f13250e;
            editText3.setPaddingRelative(editText3.getPaddingStart(), getResources().getDimensionPixelSize(C0411d.f6749D), this.f13250e.getPaddingEnd(), getResources().getDimensionPixelSize(C0411d.f6748C));
        }
    }

    private static void m0(Context context, TextView textView, int i5, int i6, boolean z5) {
        textView.setContentDescription(context.getString(z5 ? C0416i.f6887c : C0416i.f6886b, Integer.valueOf(i5), Integer.valueOf(i6)));
    }

    private void n() {
        C1115h c1115h = this.f13228G;
        if (c1115h == null) {
            return;
        }
        t1.l lVarI = c1115h.I();
        t1.l lVar = this.f13234M;
        if (lVarI != lVar) {
            this.f13228G.setShapeAppearanceModel(lVar);
        }
        if (x()) {
            this.f13228G.m0(this.f13239U, this.f13243a0);
        }
        int iR = r();
        this.f13245b0 = iR;
        this.f13228G.g0(ColorStateList.valueOf(iR));
        o();
        s0();
    }

    private void n0() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        TextView textView = this.f13272p;
        if (textView != null) {
            c0(textView, this.f13268n ? this.f13274q : this.f13276r);
            if (!this.f13268n && (colorStateList2 = this.f13292z) != null) {
                this.f13272p.setTextColor(colorStateList2);
            }
            if (!this.f13268n || (colorStateList = this.f13216A) == null) {
                return;
            }
            this.f13272p.setTextColor(colorStateList);
        }
    }

    private void o() {
        if (this.f13232K == null || this.f13233L == null) {
            return;
        }
        if (y()) {
            this.f13232K.g0(this.f13250e.isFocused() ? ColorStateList.valueOf(this.f13271o0) : ColorStateList.valueOf(this.f13243a0));
            this.f13233L.g0(ColorStateList.valueOf(this.f13243a0));
        }
        invalidate();
    }

    private void o0() {
        ColorStateList colorStateList;
        ColorStateList colorStateListG = this.f13218B;
        if (colorStateListG == null) {
            colorStateListG = C0777a.g(getContext(), C0728a.f16847x);
        }
        EditText editText = this.f13250e;
        if (editText == null || editText.getTextCursorDrawable() == null) {
            return;
        }
        Drawable drawableMutate = androidx.core.graphics.drawable.a.r(this.f13250e.getTextCursorDrawable()).mutate();
        if (S() && (colorStateList = this.f13220C) != null) {
            colorStateListG = colorStateList;
        }
        drawableMutate.setTintList(colorStateListG);
    }

    private void p(RectF rectF) {
        float f5 = rectF.left;
        int i5 = this.f13236R;
        rectF.left = f5 - i5;
        rectF.right += i5;
    }

    private void q() {
        int i5 = this.f13237S;
        if (i5 == 0) {
            this.f13228G = null;
            this.f13232K = null;
            this.f13233L = null;
            return;
        }
        if (i5 == 1) {
            this.f13228G = new C1115h(this.f13234M);
            this.f13232K = new C1115h();
            this.f13233L = new C1115h();
        } else {
            if (i5 != 2) {
                throw new IllegalArgumentException(this.f13237S + " is illegal; only @BoxBackgroundMode constants are supported.");
            }
            if (!this.f13222D || (this.f13228G instanceof com.google.android.material.textfield.h)) {
                this.f13228G = new C1115h(this.f13234M);
            } else {
                this.f13228G = com.google.android.material.textfield.h.y0(this.f13234M);
            }
            this.f13232K = null;
            this.f13233L = null;
        }
    }

    private int r() {
        return this.f13237S == 1 ? C0777a.i(C0777a.e(this, C0409b.f6720g, 0), this.f13245b0) : this.f13245b0;
    }

    private void r0() {
        this.f13250e.setBackground(getEditTextBoxBackground());
    }

    private Rect s(Rect rect) {
        if (this.f13250e == null) {
            throw new IllegalStateException();
        }
        Rect rect2 = this.f13249d0;
        boolean zG = com.google.android.material.internal.r.g(this);
        rect2.bottom = rect.bottom;
        int i5 = this.f13237S;
        if (i5 == 1) {
            rect2.left = J(rect.left, zG);
            rect2.top = rect.top + this.f13238T;
            rect2.right = K(rect.right, zG);
            return rect2;
        }
        if (i5 != 2) {
            rect2.left = J(rect.left, zG);
            rect2.top = getPaddingTop();
            rect2.right = K(rect.right, zG);
            return rect2;
        }
        rect2.left = rect.left + this.f13250e.getPaddingLeft();
        rect2.top = rect.top - w();
        rect2.right = rect.right - this.f13250e.getPaddingRight();
        return rect2;
    }

    private void setEditText(EditText editText) {
        if (this.f13250e != null) {
            throw new IllegalArgumentException("We already have an EditText, can only have one");
        }
        if (getEndIconMode() != 3 && !(editText instanceof TextInputEditText)) {
            Log.i("TextInputLayout", "EditText added is not a TextInputEditText. Please switch to using that class instead.");
        }
        this.f13250e = editText;
        int i5 = this.f13254g;
        if (i5 != -1) {
            setMinEms(i5);
        } else {
            setMinWidth(this.f13258i);
        }
        int i6 = this.f13256h;
        if (i6 != -1) {
            setMaxEms(i6);
        } else {
            setMaxWidth(this.f13260j);
        }
        this.f13231J = false;
        V();
        setTextInputAccessibilityDelegate(new e(this));
        this.f13293z0.p0(this.f13250e.getTypeface());
        this.f13293z0.h0(this.f13250e.getTextSize());
        this.f13293z0.d0(this.f13250e.getLetterSpacing());
        int gravity = this.f13250e.getGravity();
        this.f13293z0.X((gravity & (-113)) | 48);
        this.f13293z0.g0(gravity);
        this.f13289x0 = editText.getMinimumHeight();
        this.f13250e.addTextChangedListener(new a(editText));
        if (this.f13267m0 == null) {
            this.f13267m0 = this.f13250e.getHintTextColors();
        }
        if (this.f13222D) {
            if (TextUtils.isEmpty(this.f13224E)) {
                CharSequence hint = this.f13250e.getHint();
                this.f13252f = hint;
                setHint(hint);
                this.f13250e.setHint((CharSequence) null);
            }
            this.f13226F = true;
        }
        o0();
        if (this.f13272p != null) {
            l0(this.f13250e.getText());
        }
        q0();
        this.f13262k.f();
        this.f13244b.bringToFront();
        this.f13246c.bringToFront();
        D();
        this.f13246c.x0();
        if (!isEnabled()) {
            editText.setEnabled(false);
        }
        x0(false, true);
    }

    private void setHintInternal(CharSequence charSequence) {
        if (TextUtils.equals(charSequence, this.f13224E)) {
            return;
        }
        this.f13224E = charSequence;
        this.f13293z0.n0(charSequence);
        if (this.f13291y0) {
            return;
        }
        W();
    }

    private void setPlaceholderTextEnabled(boolean z5) {
        if (this.f13280t == z5) {
            return;
        }
        if (z5) {
            k();
        } else {
            a0();
            this.f13282u = null;
        }
        this.f13280t = z5;
    }

    private int t(Rect rect, Rect rect2, float f5) {
        return U() ? (int) (rect2.top + f5) : rect.bottom - this.f13250e.getCompoundPaddingBottom();
    }

    private void t0(int i5) {
        if (this.f13250e == null) {
            return;
        }
        float fZ = this.f13293z0.z();
        if (this.f13278s != null) {
            TextPaint textPaint = new TextPaint(129);
            textPaint.set(this.f13282u.getPaint());
            textPaint.setTextSize(this.f13282u.getTextSize());
            textPaint.setTypeface(this.f13282u.getTypeface());
            textPaint.setLetterSpacing(this.f13282u.getLetterSpacing());
            fQ = (this.f13237S == 1 ? this.f13248d + this.f13293z0.q() + this.f13238T : 0.0f) + com.google.android.material.internal.k.b(this.f13278s, textPaint, i5).g(getLayoutDirection() == 1).f(true).h(this.f13282u.getLineSpacingExtra(), this.f13282u.getLineSpacingMultiplier()).j(new com.google.android.material.internal.l() { // from class: com.google.android.material.textfield.C
                @Override // com.google.android.material.internal.l
                public final void a(StaticLayout.Builder builder) {
                    builder.setBreakStrategy(this.f13211a.f13282u.getBreakStrategy());
                }
            }).a().getHeight();
        }
        float fMax = Math.max(fZ, fQ);
        if (this.f13250e.getMeasuredHeight() < fMax) {
            this.f13250e.setMinimumHeight(Math.round(fMax));
        }
    }

    private int u(Rect rect, float f5) {
        if (U()) {
            return (int) (rect.centerY() - (f5 / 2.0f));
        }
        return (rect.top + this.f13250e.getCompoundPaddingTop()) - ((this.f13237S != 0 || R()) ? 0 : (int) (this.f13293z0.A() / 2.0f));
    }

    private boolean u0() {
        int iMax;
        if (this.f13250e == null || this.f13250e.getMeasuredHeight() >= (iMax = Math.max(this.f13246c.getMeasuredHeight(), this.f13244b.getMeasuredHeight()))) {
            return false;
        }
        this.f13250e.setMinimumHeight(iMax);
        return true;
    }

    private Rect v(Rect rect) {
        if (this.f13250e == null) {
            throw new IllegalStateException();
        }
        Rect rect2 = this.f13249d0;
        float fA = R() ? this.f13293z0.A() : this.f13293z0.y() * this.f13293z0.w();
        rect2.left = rect.left + this.f13250e.getCompoundPaddingLeft();
        rect2.top = u(rect, fA);
        rect2.right = rect.right - this.f13250e.getCompoundPaddingRight();
        rect2.bottom = t(rect, rect2, fA);
        return rect2;
    }

    private void v0() {
        if (this.f13237S != 1) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f13242a.getLayoutParams();
            int iW = w();
            if (iW != layoutParams.topMargin) {
                layoutParams.topMargin = iW;
                this.f13242a.requestLayout();
            }
        }
    }

    private int w() {
        if (!this.f13222D) {
            return 0;
        }
        int i5 = this.f13237S;
        if (i5 == 0) {
            return (int) this.f13293z0.q();
        }
        if (i5 != 2) {
            return 0;
        }
        return R() ? (int) (this.f13293z0.q() / 2.0f) : Math.max(0, (int) (this.f13293z0.q() - (this.f13293z0.n() / 2.0f)));
    }

    private boolean x() {
        return this.f13237S == 2 && y();
    }

    private void x0(boolean z5, boolean z6) {
        ColorStateList colorStateList;
        TextView textView;
        boolean zIsEnabled = isEnabled();
        EditText editText = this.f13250e;
        boolean z7 = false;
        boolean z8 = (editText == null || TextUtils.isEmpty(editText.getText())) ? false : true;
        EditText editText2 = this.f13250e;
        if (editText2 != null && editText2.hasFocus()) {
            z7 = true;
        }
        ColorStateList colorStateList2 = this.f13267m0;
        if (colorStateList2 != null) {
            this.f13293z0.Q(colorStateList2);
        }
        if (!zIsEnabled) {
            ColorStateList colorStateList3 = this.f13267m0;
            this.f13293z0.Q(ColorStateList.valueOf(colorStateList3 != null ? colorStateList3.getColorForState(new int[]{-16842910}, this.f13287w0) : this.f13287w0));
        } else if (d0()) {
            this.f13293z0.Q(this.f13262k.r());
        } else if (this.f13268n && (textView = this.f13272p) != null) {
            this.f13293z0.Q(textView.getTextColors());
        } else if (z7 && (colorStateList = this.f13269n0) != null) {
            this.f13293z0.W(colorStateList);
        }
        if (z8 || !this.f13217A0 || (isEnabled() && z7)) {
            if (z6 || this.f13291y0) {
                A(z5);
                return;
            }
            return;
        }
        if (z6 || !this.f13291y0) {
            G(z5);
        }
    }

    private boolean y() {
        return this.f13239U > -1 && this.f13243a0 != 0;
    }

    private void y0() {
        EditText editText;
        if (this.f13282u == null || (editText = this.f13250e) == null) {
            return;
        }
        this.f13282u.setGravity(editText.getGravity());
        this.f13282u.setPadding(this.f13250e.getCompoundPaddingLeft(), this.f13250e.getCompoundPaddingTop(), this.f13250e.getCompoundPaddingRight(), this.f13250e.getCompoundPaddingBottom());
    }

    private void z() {
        if (C()) {
            ((com.google.android.material.textfield.h) this.f13228G).A0();
        }
    }

    private void z0() {
        EditText editText = this.f13250e;
        A0(editText == null ? null : editText.getText());
    }

    void C0() {
        TextView textView;
        EditText editText;
        EditText editText2;
        if (this.f13228G == null || this.f13237S == 0) {
            return;
        }
        boolean z5 = false;
        boolean z6 = isFocused() || ((editText2 = this.f13250e) != null && editText2.hasFocus());
        if (isHovered() || ((editText = this.f13250e) != null && editText.isHovered())) {
            z5 = true;
        }
        if (!isEnabled()) {
            this.f13243a0 = this.f13287w0;
        } else if (d0()) {
            if (this.f13277r0 != null) {
                B0(z6, z5);
            } else {
                this.f13243a0 = getErrorCurrentTextColors();
            }
        } else if (!this.f13268n || (textView = this.f13272p) == null) {
            if (z6) {
                this.f13243a0 = this.f13275q0;
            } else if (z5) {
                this.f13243a0 = this.f13273p0;
            } else {
                this.f13243a0 = this.f13271o0;
            }
        } else if (this.f13277r0 != null) {
            B0(z6, z5);
        } else {
            this.f13243a0 = textView.getCurrentTextColor();
        }
        o0();
        this.f13246c.I();
        Z();
        if (this.f13237S == 2) {
            int i5 = this.f13239U;
            if (z6 && isEnabled()) {
                this.f13239U = this.f13241W;
            } else {
                this.f13239U = this.f13240V;
            }
            if (this.f13239U != i5) {
                X();
            }
        }
        if (this.f13237S == 1) {
            if (!isEnabled()) {
                this.f13245b0 = this.f13281t0;
            } else if (z5 && !z6) {
                this.f13245b0 = this.f13285v0;
            } else if (z6) {
                this.f13245b0 = this.f13283u0;
            } else {
                this.f13245b0 = this.f13279s0;
            }
        }
        n();
    }

    public boolean N() {
        return this.f13246c.F();
    }

    public boolean O() {
        return this.f13262k.A();
    }

    public boolean P() {
        return this.f13262k.B();
    }

    final boolean Q() {
        return this.f13291y0;
    }

    public boolean T() {
        return this.f13226F;
    }

    public void Z() {
        this.f13244b.m();
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i5, ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof EditText)) {
            super.addView(view, i5, layoutParams);
            return;
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams);
        layoutParams2.gravity = (layoutParams2.gravity & (-113)) | 16;
        this.f13242a.addView(view, layoutParams2);
        this.f13242a.setLayoutParams(layoutParams);
        v0();
        setEditText((EditText) view);
    }

    void c0(TextView textView, int i5) {
        try {
            androidx.core.widget.i.m(textView, i5);
            if (textView.getTextColors().getDefaultColor() != -65281) {
                return;
            }
        } catch (Exception unused) {
        }
        androidx.core.widget.i.m(textView, g.i.f16976a);
        textView.setTextColor(androidx.core.content.a.c(getContext(), C0410c.f6740a));
    }

    boolean d0() {
        return this.f13262k.l();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchProvideAutofillStructure(ViewStructure viewStructure, int i5) {
        EditText editText = this.f13250e;
        if (editText == null) {
            super.dispatchProvideAutofillStructure(viewStructure, i5);
            return;
        }
        if (this.f13252f != null) {
            boolean z5 = this.f13226F;
            this.f13226F = false;
            CharSequence hint = editText.getHint();
            this.f13250e.setHint(this.f13252f);
            try {
                super.dispatchProvideAutofillStructure(viewStructure, i5);
                return;
            } finally {
                this.f13250e.setHint(hint);
                this.f13226F = z5;
            }
        }
        viewStructure.setAutofillId(getAutofillId());
        onProvideAutofillStructure(viewStructure, i5);
        onProvideAutofillVirtualStructure(viewStructure, i5);
        viewStructure.setChildCount(this.f13242a.getChildCount());
        for (int i6 = 0; i6 < this.f13242a.getChildCount(); i6++) {
            View childAt = this.f13242a.getChildAt(i6);
            ViewStructure viewStructureNewChild = viewStructure.newChild(i6);
            childAt.dispatchProvideAutofillStructure(viewStructureNewChild, i5);
            if (childAt == this.f13250e) {
                viewStructureNewChild.setHint(getHint());
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        this.f13225E0 = true;
        super.dispatchRestoreInstanceState(sparseArray);
        this.f13225E0 = false;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        F(canvas);
        E(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        if (this.f13223D0) {
            return;
        }
        this.f13223D0 = true;
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        com.google.android.material.internal.a aVar = this.f13293z0;
        boolean zM0 = aVar != null ? aVar.m0(drawableState) : false;
        if (this.f13250e != null) {
            w0(isLaidOut() && isEnabled());
        }
        q0();
        C0();
        if (zM0) {
            invalidate();
        }
        this.f13223D0 = false;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public int getBaseline() {
        EditText editText = this.f13250e;
        return editText != null ? editText.getBaseline() + getPaddingTop() + w() : super.getBaseline();
    }

    C1115h getBoxBackground() {
        int i5 = this.f13237S;
        if (i5 == 1 || i5 == 2) {
            return this.f13228G;
        }
        throw new IllegalStateException();
    }

    public int getBoxBackgroundColor() {
        return this.f13245b0;
    }

    public int getBoxBackgroundMode() {
        return this.f13237S;
    }

    public int getBoxCollapsedPaddingTop() {
        return this.f13238T;
    }

    public float getBoxCornerRadiusBottomEnd() {
        return com.google.android.material.internal.r.g(this) ? this.f13234M.j().a(this.f13251e0) : this.f13234M.l().a(this.f13251e0);
    }

    public float getBoxCornerRadiusBottomStart() {
        return com.google.android.material.internal.r.g(this) ? this.f13234M.l().a(this.f13251e0) : this.f13234M.j().a(this.f13251e0);
    }

    public float getBoxCornerRadiusTopEnd() {
        return com.google.android.material.internal.r.g(this) ? this.f13234M.r().a(this.f13251e0) : this.f13234M.t().a(this.f13251e0);
    }

    public float getBoxCornerRadiusTopStart() {
        return com.google.android.material.internal.r.g(this) ? this.f13234M.t().a(this.f13251e0) : this.f13234M.r().a(this.f13251e0);
    }

    public int getBoxStrokeColor() {
        return this.f13275q0;
    }

    public ColorStateList getBoxStrokeErrorColor() {
        return this.f13277r0;
    }

    public int getBoxStrokeWidth() {
        return this.f13240V;
    }

    public int getBoxStrokeWidthFocused() {
        return this.f13241W;
    }

    public int getCounterMaxLength() {
        return this.f13266m;
    }

    CharSequence getCounterOverflowDescription() {
        TextView textView;
        if (this.f13264l && this.f13268n && (textView = this.f13272p) != null) {
            return textView.getContentDescription();
        }
        return null;
    }

    public ColorStateList getCounterOverflowTextColor() {
        return this.f13216A;
    }

    public ColorStateList getCounterTextColor() {
        return this.f13292z;
    }

    public ColorStateList getCursorColor() {
        return this.f13218B;
    }

    public ColorStateList getCursorErrorColor() {
        return this.f13220C;
    }

    public ColorStateList getDefaultHintTextColor() {
        return this.f13267m0;
    }

    public EditText getEditText() {
        return this.f13250e;
    }

    public CharSequence getEndIconContentDescription() {
        return this.f13246c.l();
    }

    public Drawable getEndIconDrawable() {
        return this.f13246c.n();
    }

    public int getEndIconMinSize() {
        return this.f13246c.o();
    }

    public int getEndIconMode() {
        return this.f13246c.p();
    }

    public ImageView.ScaleType getEndIconScaleType() {
        return this.f13246c.q();
    }

    CheckableImageButton getEndIconView() {
        return this.f13246c.r();
    }

    public CharSequence getError() {
        if (this.f13262k.A()) {
            return this.f13262k.p();
        }
        return null;
    }

    public int getErrorAccessibilityLiveRegion() {
        return this.f13262k.n();
    }

    public CharSequence getErrorContentDescription() {
        return this.f13262k.o();
    }

    public int getErrorCurrentTextColors() {
        return this.f13262k.q();
    }

    public Drawable getErrorIconDrawable() {
        return this.f13246c.s();
    }

    public CharSequence getHelperText() {
        if (this.f13262k.B()) {
            return this.f13262k.s();
        }
        return null;
    }

    public int getHelperTextCurrentTextColor() {
        return this.f13262k.u();
    }

    public CharSequence getHint() {
        if (this.f13222D) {
            return this.f13224E;
        }
        return null;
    }

    final float getHintCollapsedTextHeight() {
        return this.f13293z0.q();
    }

    final int getHintCurrentCollapsedTextColor() {
        return this.f13293z0.t();
    }

    public int getHintMaxLines() {
        return this.f13293z0.x();
    }

    public ColorStateList getHintTextColor() {
        return this.f13269n0;
    }

    public f getLengthCounter() {
        return this.f13270o;
    }

    public int getMaxEms() {
        return this.f13256h;
    }

    public int getMaxWidth() {
        return this.f13260j;
    }

    public int getMinEms() {
        return this.f13254g;
    }

    public int getMinWidth() {
        return this.f13258i;
    }

    @Deprecated
    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.f13246c.u();
    }

    @Deprecated
    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.f13246c.v();
    }

    public CharSequence getPlaceholderText() {
        if (this.f13280t) {
            return this.f13278s;
        }
        return null;
    }

    public int getPlaceholderTextAppearance() {
        return this.f13286w;
    }

    public ColorStateList getPlaceholderTextColor() {
        return this.f13284v;
    }

    public CharSequence getPrefixText() {
        return this.f13244b.a();
    }

    public ColorStateList getPrefixTextColor() {
        return this.f13244b.b();
    }

    public TextView getPrefixTextView() {
        return this.f13244b.d();
    }

    public t1.l getShapeAppearanceModel() {
        return this.f13234M;
    }

    public CharSequence getStartIconContentDescription() {
        return this.f13244b.e();
    }

    public Drawable getStartIconDrawable() {
        return this.f13244b.f();
    }

    public int getStartIconMinSize() {
        return this.f13244b.g();
    }

    public ImageView.ScaleType getStartIconScaleType() {
        return this.f13244b.h();
    }

    public CharSequence getSuffixText() {
        return this.f13246c.w();
    }

    public ColorStateList getSuffixTextColor() {
        return this.f13246c.x();
    }

    public TextView getSuffixTextView() {
        return this.f13246c.z();
    }

    public Typeface getTypeface() {
        return this.f13253f0;
    }

    public void j(g gVar) {
        this.f13259i0.add(gVar);
        if (this.f13250e != null) {
            gVar.a(this);
        }
    }

    void l0(Editable editable) {
        int iA = this.f13270o.a(editable);
        boolean z5 = this.f13268n;
        int i5 = this.f13266m;
        if (i5 == -1) {
            this.f13272p.setText(String.valueOf(iA));
            this.f13272p.setContentDescription(null);
            this.f13268n = false;
        } else {
            this.f13268n = iA > i5;
            m0(getContext(), this.f13272p, iA, this.f13266m, this.f13268n);
            if (z5 != this.f13268n) {
                n0();
            }
            this.f13272p.setText(androidx.core.text.a.c().j(getContext().getString(C0416i.f6888d, Integer.valueOf(iA), Integer.valueOf(this.f13266m))));
        }
        if (this.f13250e == null || z5 == this.f13268n) {
            return;
        }
        w0(false);
        C0();
        q0();
    }

    void m(float f5) {
        if (this.f13293z0.B() == f5) {
            return;
        }
        if (this.f13221C0 == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.f13221C0 = valueAnimator;
            valueAnimator.setInterpolator(o1.e.g(getContext(), C0409b.f6696F, C0553a.f11784b));
            this.f13221C0.setDuration(o1.e.f(getContext(), C0409b.f6739z, 167));
            this.f13221C0.addUpdateListener(new d());
        }
        this.f13221C0.setFloatValues(this.f13293z0.B(), f5);
        this.f13221C0.start();
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f13293z0.L(configuration);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        this.f13246c.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        this.f13227F0 = false;
        boolean zU0 = u0();
        boolean zP0 = p0();
        if (zU0 || zP0) {
            this.f13250e.post(new Runnable() { // from class: com.google.android.material.textfield.A
                @Override // java.lang.Runnable
                public final void run() {
                    this.f13210a.f13250e.requestLayout();
                }
            });
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z5, int i5, int i6, int i7, int i8) {
        super.onLayout(z5, i5, i6, i7, i8);
        EditText editText = this.f13250e;
        if (editText != null) {
            Rect rect = this.f13247c0;
            com.google.android.material.internal.c.a(this, editText, rect);
            i0(rect);
            if (this.f13222D) {
                this.f13293z0.h0(this.f13250e.getTextSize());
                int gravity = this.f13250e.getGravity();
                this.f13293z0.X((gravity & (-113)) | 48);
                this.f13293z0.g0(gravity);
                this.f13293z0.S(s(rect));
                this.f13293z0.c0(v(rect));
                this.f13293z0.N();
                if (!C() || this.f13291y0) {
                    return;
                }
                W();
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i5, int i6) {
        super.onMeasure(i5, i6);
        if (!this.f13227F0) {
            this.f13246c.getViewTreeObserver().addOnGlobalLayoutListener(this);
            this.f13227F0 = true;
        }
        y0();
        this.f13246c.x0();
        if (R()) {
            return;
        }
        j0((this.f13250e.getMeasuredWidth() - this.f13250e.getCompoundPaddingLeft()) - this.f13250e.getCompoundPaddingRight());
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof i)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        i iVar = (i) parcelable;
        super.onRestoreInstanceState(iVar.getSuperState());
        setError(iVar.f13301a);
        if (iVar.f13302b) {
            post(new c());
        }
        requestLayout();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onRtlPropertiesChanged(int i5) {
        super.onRtlPropertiesChanged(i5);
        boolean z5 = i5 == 1;
        if (z5 != this.f13235Q) {
            float fA = this.f13234M.r().a(this.f13251e0);
            float fA2 = this.f13234M.t().a(this.f13251e0);
            t1.l lVarM = t1.l.a().B(this.f13234M.s()).F(this.f13234M.q()).t(this.f13234M.k()).x(this.f13234M.i()).C(fA2).G(fA).u(this.f13234M.l().a(this.f13251e0)).y(this.f13234M.j().a(this.f13251e0)).m();
            this.f13235Q = z5;
            setShapeAppearanceModel(lVarM);
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        i iVar = new i(super.onSaveInstanceState());
        if (d0()) {
            iVar.f13301a = getError();
        }
        iVar.f13302b = this.f13246c.E();
        return iVar;
    }

    boolean p0() {
        boolean z5;
        if (this.f13250e == null) {
            return false;
        }
        boolean z6 = true;
        if (f0()) {
            int measuredWidth = this.f13244b.getMeasuredWidth() - this.f13250e.getPaddingLeft();
            if (this.f13255g0 == null || this.f13257h0 != measuredWidth) {
                ColorDrawable colorDrawable = new ColorDrawable();
                this.f13255g0 = colorDrawable;
                this.f13257h0 = measuredWidth;
                colorDrawable.setBounds(0, 0, measuredWidth, 1);
            }
            Drawable[] compoundDrawablesRelative = this.f13250e.getCompoundDrawablesRelative();
            Drawable drawable = compoundDrawablesRelative[0];
            Drawable drawable2 = this.f13255g0;
            if (drawable != drawable2) {
                this.f13250e.setCompoundDrawablesRelative(drawable2, compoundDrawablesRelative[1], compoundDrawablesRelative[2], compoundDrawablesRelative[3]);
                z5 = true;
            }
            z5 = false;
        } else {
            if (this.f13255g0 != null) {
                Drawable[] compoundDrawablesRelative2 = this.f13250e.getCompoundDrawablesRelative();
                this.f13250e.setCompoundDrawablesRelative(null, compoundDrawablesRelative2[1], compoundDrawablesRelative2[2], compoundDrawablesRelative2[3]);
                this.f13255g0 = null;
                z5 = true;
            }
            z5 = false;
        }
        if (e0()) {
            int measuredWidth2 = this.f13246c.z().getMeasuredWidth() - this.f13250e.getPaddingRight();
            CheckableImageButton checkableImageButtonK = this.f13246c.k();
            if (checkableImageButtonK != null) {
                measuredWidth2 = measuredWidth2 + checkableImageButtonK.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) checkableImageButtonK.getLayoutParams()).getMarginStart();
            }
            Drawable[] compoundDrawablesRelative3 = this.f13250e.getCompoundDrawablesRelative();
            Drawable drawable3 = this.f13261j0;
            if (drawable3 != null && this.f13263k0 != measuredWidth2) {
                this.f13263k0 = measuredWidth2;
                drawable3.setBounds(0, 0, measuredWidth2, 1);
                this.f13250e.setCompoundDrawablesRelative(compoundDrawablesRelative3[0], compoundDrawablesRelative3[1], this.f13261j0, compoundDrawablesRelative3[3]);
                return true;
            }
            if (drawable3 == null) {
                ColorDrawable colorDrawable2 = new ColorDrawable();
                this.f13261j0 = colorDrawable2;
                this.f13263k0 = measuredWidth2;
                colorDrawable2.setBounds(0, 0, measuredWidth2, 1);
            }
            Drawable drawable4 = compoundDrawablesRelative3[2];
            Drawable drawable5 = this.f13261j0;
            if (drawable4 != drawable5) {
                this.f13265l0 = drawable4;
                this.f13250e.setCompoundDrawablesRelative(compoundDrawablesRelative3[0], compoundDrawablesRelative3[1], drawable5, compoundDrawablesRelative3[3]);
                return true;
            }
        } else if (this.f13261j0 != null) {
            Drawable[] compoundDrawablesRelative4 = this.f13250e.getCompoundDrawablesRelative();
            if (compoundDrawablesRelative4[2] == this.f13261j0) {
                this.f13250e.setCompoundDrawablesRelative(compoundDrawablesRelative4[0], compoundDrawablesRelative4[1], this.f13265l0, compoundDrawablesRelative4[3]);
            } else {
                z6 = z5;
            }
            this.f13261j0 = null;
            return z6;
        }
        return z5;
    }

    void q0() {
        Drawable background;
        TextView textView;
        EditText editText = this.f13250e;
        if (editText == null || this.f13237S != 0 || (background = editText.getBackground()) == null) {
            return;
        }
        if (I.a(background)) {
            background = background.mutate();
        }
        if (d0()) {
            background.setColorFilter(C0441k.e(getErrorCurrentTextColors(), PorterDuff.Mode.SRC_IN));
        } else if (this.f13268n && (textView = this.f13272p) != null) {
            background.setColorFilter(C0441k.e(textView.getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
        } else {
            androidx.core.graphics.drawable.a.c(background);
            this.f13250e.refreshDrawableState();
        }
    }

    void s0() {
        EditText editText = this.f13250e;
        if (editText == null || this.f13228G == null) {
            return;
        }
        if ((this.f13231J || editText.getBackground() == null) && this.f13237S != 0) {
            r0();
            this.f13231J = true;
        }
    }

    public void setBoxBackgroundColor(int i5) {
        if (this.f13245b0 != i5) {
            this.f13245b0 = i5;
            this.f13279s0 = i5;
            this.f13283u0 = i5;
            this.f13285v0 = i5;
            n();
        }
    }

    public void setBoxBackgroundColorResource(int i5) {
        setBoxBackgroundColor(androidx.core.content.a.c(getContext(), i5));
    }

    public void setBoxBackgroundColorStateList(ColorStateList colorStateList) {
        int defaultColor = colorStateList.getDefaultColor();
        this.f13279s0 = defaultColor;
        this.f13245b0 = defaultColor;
        this.f13281t0 = colorStateList.getColorForState(new int[]{-16842910}, -1);
        this.f13283u0 = colorStateList.getColorForState(new int[]{R.attr.state_focused, R.attr.state_enabled}, -1);
        this.f13285v0 = colorStateList.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, -1);
        n();
    }

    public void setBoxBackgroundMode(int i5) {
        if (i5 == this.f13237S) {
            return;
        }
        this.f13237S = i5;
        if (this.f13250e != null) {
            V();
        }
    }

    public void setBoxCollapsedPaddingTop(int i5) {
        this.f13238T = i5;
    }

    public void setBoxCornerFamily(int i5) {
        this.f13234M = this.f13234M.w().A(i5, this.f13234M.r()).E(i5, this.f13234M.t()).s(i5, this.f13234M.j()).w(i5, this.f13234M.l()).m();
        n();
    }

    public void setBoxStrokeColor(int i5) {
        if (this.f13275q0 != i5) {
            this.f13275q0 = i5;
            C0();
        }
    }

    public void setBoxStrokeColorStateList(ColorStateList colorStateList) {
        if (colorStateList.isStateful()) {
            this.f13271o0 = colorStateList.getDefaultColor();
            this.f13287w0 = colorStateList.getColorForState(new int[]{-16842910}, -1);
            this.f13273p0 = colorStateList.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, -1);
            this.f13275q0 = colorStateList.getColorForState(new int[]{R.attr.state_focused, R.attr.state_enabled}, -1);
        } else if (this.f13275q0 != colorStateList.getDefaultColor()) {
            this.f13275q0 = colorStateList.getDefaultColor();
        }
        C0();
    }

    public void setBoxStrokeErrorColor(ColorStateList colorStateList) {
        if (this.f13277r0 != colorStateList) {
            this.f13277r0 = colorStateList;
            C0();
        }
    }

    public void setBoxStrokeWidth(int i5) {
        this.f13240V = i5;
        C0();
    }

    public void setBoxStrokeWidthFocused(int i5) {
        this.f13241W = i5;
        C0();
    }

    public void setBoxStrokeWidthFocusedResource(int i5) {
        setBoxStrokeWidthFocused(getResources().getDimensionPixelSize(i5));
    }

    public void setBoxStrokeWidthResource(int i5) {
        setBoxStrokeWidth(getResources().getDimensionPixelSize(i5));
    }

    public void setCounterEnabled(boolean z5) {
        if (this.f13264l != z5) {
            if (z5) {
                D d6 = new D(getContext());
                this.f13272p = d6;
                d6.setId(C0413f.f6830M);
                Typeface typeface = this.f13253f0;
                if (typeface != null) {
                    this.f13272p.setTypeface(typeface);
                }
                this.f13272p.setMaxLines(1);
                this.f13262k.e(this.f13272p, 2);
                ((ViewGroup.MarginLayoutParams) this.f13272p.getLayoutParams()).setMarginStart(getResources().getDimensionPixelOffset(C0411d.f6789i0));
                n0();
                k0();
            } else {
                this.f13262k.C(this.f13272p, 2);
                this.f13272p = null;
            }
            this.f13264l = z5;
        }
    }

    public void setCounterMaxLength(int i5) {
        if (this.f13266m != i5) {
            if (i5 > 0) {
                this.f13266m = i5;
            } else {
                this.f13266m = -1;
            }
            if (this.f13264l) {
                k0();
            }
        }
    }

    public void setCounterOverflowTextAppearance(int i5) {
        if (this.f13274q != i5) {
            this.f13274q = i5;
            n0();
        }
    }

    public void setCounterOverflowTextColor(ColorStateList colorStateList) {
        if (this.f13216A != colorStateList) {
            this.f13216A = colorStateList;
            n0();
        }
    }

    public void setCounterTextAppearance(int i5) {
        if (this.f13276r != i5) {
            this.f13276r = i5;
            n0();
        }
    }

    public void setCounterTextColor(ColorStateList colorStateList) {
        if (this.f13292z != colorStateList) {
            this.f13292z = colorStateList;
            n0();
        }
    }

    public void setCursorColor(ColorStateList colorStateList) {
        if (this.f13218B != colorStateList) {
            this.f13218B = colorStateList;
            o0();
        }
    }

    public void setCursorErrorColor(ColorStateList colorStateList) {
        if (this.f13220C != colorStateList) {
            this.f13220C = colorStateList;
            if (S()) {
                o0();
            }
        }
    }

    public void setDefaultHintTextColor(ColorStateList colorStateList) {
        this.f13267m0 = colorStateList;
        this.f13269n0 = colorStateList;
        if (this.f13250e != null) {
            w0(false);
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z5) {
        Y(this, z5);
        super.setEnabled(z5);
    }

    public void setEndIconActivated(boolean z5) {
        this.f13246c.N(z5);
    }

    public void setEndIconCheckable(boolean z5) {
        this.f13246c.O(z5);
    }

    public void setEndIconContentDescription(int i5) {
        this.f13246c.P(i5);
    }

    public void setEndIconDrawable(int i5) {
        this.f13246c.R(i5);
    }

    public void setEndIconMinSize(int i5) {
        this.f13246c.T(i5);
    }

    public void setEndIconMode(int i5) {
        this.f13246c.U(i5);
    }

    public void setEndIconOnClickListener(View.OnClickListener onClickListener) {
        this.f13246c.V(onClickListener);
    }

    public void setEndIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f13246c.W(onLongClickListener);
    }

    public void setEndIconScaleType(ImageView.ScaleType scaleType) {
        this.f13246c.X(scaleType);
    }

    public void setEndIconTintList(ColorStateList colorStateList) {
        this.f13246c.Y(colorStateList);
    }

    public void setEndIconTintMode(PorterDuff.Mode mode) {
        this.f13246c.Z(mode);
    }

    public void setEndIconVisible(boolean z5) {
        this.f13246c.a0(z5);
    }

    public void setError(CharSequence charSequence) {
        if (!this.f13262k.A()) {
            if (TextUtils.isEmpty(charSequence)) {
                return;
            } else {
                setErrorEnabled(true);
            }
        }
        if (TextUtils.isEmpty(charSequence)) {
            this.f13262k.w();
        } else {
            this.f13262k.Q(charSequence);
        }
    }

    public void setErrorAccessibilityLiveRegion(int i5) {
        this.f13262k.E(i5);
    }

    public void setErrorContentDescription(CharSequence charSequence) {
        this.f13262k.F(charSequence);
    }

    public void setErrorEnabled(boolean z5) {
        this.f13262k.G(z5);
    }

    public void setErrorIconDrawable(int i5) {
        this.f13246c.b0(i5);
    }

    public void setErrorIconOnClickListener(View.OnClickListener onClickListener) {
        this.f13246c.d0(onClickListener);
    }

    public void setErrorIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f13246c.e0(onLongClickListener);
    }

    public void setErrorIconTintList(ColorStateList colorStateList) {
        this.f13246c.f0(colorStateList);
    }

    public void setErrorIconTintMode(PorterDuff.Mode mode) {
        this.f13246c.g0(mode);
    }

    public void setErrorTextAppearance(int i5) {
        this.f13262k.H(i5);
    }

    public void setErrorTextColor(ColorStateList colorStateList) {
        this.f13262k.I(colorStateList);
    }

    public void setExpandedHintEnabled(boolean z5) {
        if (this.f13217A0 != z5) {
            this.f13217A0 = z5;
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
            this.f13262k.R(charSequence);
        }
    }

    public void setHelperTextColor(ColorStateList colorStateList) {
        this.f13262k.L(colorStateList);
    }

    public void setHelperTextEnabled(boolean z5) {
        this.f13262k.K(z5);
    }

    public void setHelperTextTextAppearance(int i5) {
        this.f13262k.J(i5);
    }

    public void setHint(CharSequence charSequence) {
        if (this.f13222D) {
            setHintInternal(charSequence);
            sendAccessibilityEvent(RecyclerView.ItemAnimator.FLAG_MOVED);
        }
    }

    public void setHintAnimationEnabled(boolean z5) {
        this.f13219B0 = z5;
    }

    public void setHintEnabled(boolean z5) {
        if (z5 != this.f13222D) {
            this.f13222D = z5;
            if (z5) {
                CharSequence hint = this.f13250e.getHint();
                if (!TextUtils.isEmpty(hint)) {
                    if (TextUtils.isEmpty(this.f13224E)) {
                        setHint(hint);
                    }
                    this.f13250e.setHint((CharSequence) null);
                }
                this.f13226F = true;
            } else {
                this.f13226F = false;
                if (!TextUtils.isEmpty(this.f13224E) && TextUtils.isEmpty(this.f13250e.getHint())) {
                    this.f13250e.setHint(this.f13224E);
                }
                setHintInternal(null);
            }
            if (this.f13250e != null) {
                v0();
            }
        }
    }

    public void setHintMaxLines(int i5) {
        this.f13293z0.T(i5);
        this.f13293z0.e0(i5);
        requestLayout();
    }

    public void setHintTextAppearance(int i5) {
        this.f13293z0.U(i5);
        this.f13269n0 = this.f13293z0.p();
        if (this.f13250e != null) {
            w0(false);
            v0();
        }
    }

    public void setHintTextColor(ColorStateList colorStateList) {
        if (this.f13269n0 != colorStateList) {
            if (this.f13267m0 == null) {
                this.f13293z0.W(colorStateList);
            }
            this.f13269n0 = colorStateList;
            if (this.f13250e != null) {
                w0(false);
            }
        }
    }

    public void setLengthCounter(f fVar) {
        this.f13270o = fVar;
    }

    public void setMaxEms(int i5) {
        this.f13256h = i5;
        EditText editText = this.f13250e;
        if (editText == null || i5 == -1) {
            return;
        }
        editText.setMaxEms(i5);
    }

    public void setMaxWidth(int i5) {
        this.f13260j = i5;
        EditText editText = this.f13250e;
        if (editText == null || i5 == -1) {
            return;
        }
        editText.setMaxWidth(i5);
    }

    public void setMaxWidthResource(int i5) {
        setMaxWidth(getContext().getResources().getDimensionPixelSize(i5));
    }

    public void setMinEms(int i5) {
        this.f13254g = i5;
        EditText editText = this.f13250e;
        if (editText == null || i5 == -1) {
            return;
        }
        editText.setMinEms(i5);
    }

    public void setMinWidth(int i5) {
        this.f13258i = i5;
        EditText editText = this.f13250e;
        if (editText == null || i5 == -1) {
            return;
        }
        editText.setMinWidth(i5);
    }

    public void setMinWidthResource(int i5) {
        setMinWidth(getContext().getResources().getDimensionPixelSize(i5));
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(int i5) {
        this.f13246c.i0(i5);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(int i5) {
        this.f13246c.k0(i5);
    }

    @Deprecated
    public void setPasswordVisibilityToggleEnabled(boolean z5) {
        this.f13246c.m0(z5);
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintList(ColorStateList colorStateList) {
        this.f13246c.n0(colorStateList);
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintMode(PorterDuff.Mode mode) {
        this.f13246c.o0(mode);
    }

    public void setPlaceholderText(CharSequence charSequence) {
        if (this.f13282u == null) {
            D d6 = new D(getContext());
            this.f13282u = d6;
            d6.setId(C0413f.f6833P);
            this.f13282u.setImportantForAccessibility(1);
            this.f13282u.setAccessibilityLiveRegion(1);
            C0548c c0548cB = B();
            this.f13288x = c0548cB;
            c0548cB.h0(67L);
            this.f13290y = B();
            setPlaceholderTextAppearance(this.f13286w);
            setPlaceholderTextColor(this.f13284v);
            H.k0(this.f13282u, new b());
        }
        if (TextUtils.isEmpty(charSequence)) {
            setPlaceholderTextEnabled(false);
        } else {
            if (!this.f13280t) {
                setPlaceholderTextEnabled(true);
            }
            this.f13278s = charSequence;
        }
        z0();
    }

    public void setPlaceholderTextAppearance(int i5) {
        this.f13286w = i5;
        TextView textView = this.f13282u;
        if (textView != null) {
            androidx.core.widget.i.m(textView, i5);
        }
    }

    public void setPlaceholderTextColor(ColorStateList colorStateList) {
        if (this.f13284v != colorStateList) {
            this.f13284v = colorStateList;
            TextView textView = this.f13282u;
            if (textView == null || colorStateList == null) {
                return;
            }
            textView.setTextColor(colorStateList);
        }
    }

    public void setPrefixText(CharSequence charSequence) {
        this.f13244b.n(charSequence);
    }

    public void setPrefixTextAppearance(int i5) {
        this.f13244b.o(i5);
    }

    public void setPrefixTextColor(ColorStateList colorStateList) {
        this.f13244b.p(colorStateList);
    }

    public void setShapeAppearanceModel(t1.l lVar) {
        C1115h c1115h = this.f13228G;
        if (c1115h == null || c1115h.I() == lVar) {
            return;
        }
        this.f13234M = lVar;
        n();
    }

    public void setStartIconCheckable(boolean z5) {
        this.f13244b.q(z5);
    }

    public void setStartIconContentDescription(int i5) {
        setStartIconContentDescription(i5 != 0 ? getResources().getText(i5) : null);
    }

    public void setStartIconDrawable(int i5) {
        setStartIconDrawable(i5 != 0 ? C0744a.b(getContext(), i5) : null);
    }

    public void setStartIconMinSize(int i5) {
        this.f13244b.t(i5);
    }

    public void setStartIconOnClickListener(View.OnClickListener onClickListener) {
        this.f13244b.u(onClickListener);
    }

    public void setStartIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f13244b.v(onLongClickListener);
    }

    public void setStartIconScaleType(ImageView.ScaleType scaleType) {
        this.f13244b.w(scaleType);
    }

    public void setStartIconTintList(ColorStateList colorStateList) {
        this.f13244b.x(colorStateList);
    }

    public void setStartIconTintMode(PorterDuff.Mode mode) {
        this.f13244b.y(mode);
    }

    public void setStartIconVisible(boolean z5) {
        this.f13244b.z(z5);
    }

    public void setSuffixText(CharSequence charSequence) {
        this.f13246c.p0(charSequence);
    }

    public void setSuffixTextAppearance(int i5) {
        this.f13246c.q0(i5);
    }

    public void setSuffixTextColor(ColorStateList colorStateList) {
        this.f13246c.r0(colorStateList);
    }

    public void setTextInputAccessibilityDelegate(e eVar) {
        EditText editText = this.f13250e;
        if (editText != null) {
            H.k0(editText, eVar);
        }
    }

    public void setTypeface(Typeface typeface) {
        if (typeface != this.f13253f0) {
            this.f13253f0 = typeface;
            this.f13293z0.p0(typeface);
            this.f13262k.N(typeface);
            TextView textView = this.f13272p;
            if (textView != null) {
                textView.setTypeface(typeface);
            }
        }
    }

    void w0(boolean z5) {
        x0(z5, false);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public TextInputLayout(Context context, AttributeSet attributeSet, int i5) {
        int i6 = f13214G0;
        super(C1282a.d(context, attributeSet, i5, i6), attributeSet, i5);
        this.f13254g = -1;
        this.f13256h = -1;
        this.f13258i = -1;
        this.f13260j = -1;
        this.f13262k = new u(this);
        this.f13270o = new f() { // from class: com.google.android.material.textfield.B
            @Override // com.google.android.material.textfield.TextInputLayout.f
            public final int a(Editable editable) {
                return TextInputLayout.c(editable);
            }
        };
        this.f13247c0 = new Rect();
        this.f13249d0 = new Rect();
        this.f13251e0 = new RectF();
        this.f13259i0 = new LinkedHashSet<>();
        com.google.android.material.internal.a aVar = new com.google.android.material.internal.a(this);
        this.f13293z0 = aVar;
        this.f13227F0 = false;
        Context context2 = getContext();
        setOrientation(1);
        setWillNotDraw(false);
        setAddStatesFromChildren(true);
        FrameLayout frameLayout = new FrameLayout(context2);
        this.f13242a = frameLayout;
        frameLayout.setAddStatesFromChildren(true);
        TimeInterpolator timeInterpolator = C0553a.f11783a;
        aVar.o0(timeInterpolator);
        aVar.l0(timeInterpolator);
        aVar.X(8388659);
        int[] iArr = C0418k.f6994J4;
        int i7 = C0418k.g5;
        int i8 = C0418k.f7125e5;
        int i9 = C0418k.y5;
        int i10 = C0418k.D5;
        int i11 = C0418k.I5;
        a0 a0VarJ = com.google.android.material.internal.o.j(context2, attributeSet, iArr, i5, i6, i7, i8, i9, i10, i11);
        z zVar = new z(this, a0VarJ);
        this.f13244b = zVar;
        this.f13222D = a0VarJ.a(C0418k.G5, true);
        setHint(a0VarJ.p(C0418k.f7024O4));
        this.f13219B0 = a0VarJ.a(C0418k.F5, true);
        this.f13217A0 = a0VarJ.a(C0418k.A5, true);
        int i12 = C0418k.f7036Q4;
        if (a0VarJ.s(i12)) {
            setMinEms(a0VarJ.k(i12, -1));
        } else {
            int i13 = C0418k.f7018N4;
            if (a0VarJ.s(i13)) {
                setMinWidth(a0VarJ.f(i13, -1));
            }
        }
        int i14 = C0418k.f7030P4;
        if (a0VarJ.s(i14)) {
            setMaxEms(a0VarJ.k(i14, -1));
        } else {
            int i15 = C0418k.f7012M4;
            if (a0VarJ.s(i15)) {
                setMaxWidth(a0VarJ.f(i15, -1));
            }
        }
        this.f13234M = t1.l.e(context2, attributeSet, i5, i6).m();
        this.f13236R = context2.getResources().getDimensionPixelOffset(C0411d.f6783f0);
        this.f13238T = a0VarJ.e(C0418k.f7054T4, 0);
        this.f13248d = getResources().getDimensionPixelSize(C0411d.f6800t);
        this.f13240V = a0VarJ.f(C0418k.f7097a5, context2.getResources().getDimensionPixelSize(C0411d.f6785g0));
        this.f13241W = a0VarJ.f(C0418k.f7104b5, context2.getResources().getDimensionPixelSize(C0411d.f6787h0));
        this.f13239U = this.f13240V;
        float fD = a0VarJ.d(C0418k.f7078X4, -1.0f);
        float fD2 = a0VarJ.d(C0418k.f7072W4, -1.0f);
        float fD3 = a0VarJ.d(C0418k.f7060U4, -1.0f);
        float fD4 = a0VarJ.d(C0418k.f7066V4, -1.0f);
        l.b bVarW = this.f13234M.w();
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
        this.f13234M = bVarW.m();
        ColorStateList colorStateListB = C0981c.b(context2, a0VarJ, C0418k.f7042R4);
        if (colorStateListB != null) {
            int defaultColor = colorStateListB.getDefaultColor();
            this.f13279s0 = defaultColor;
            this.f13245b0 = defaultColor;
            if (colorStateListB.isStateful()) {
                this.f13281t0 = colorStateListB.getColorForState(new int[]{-16842910}, -1);
                this.f13283u0 = colorStateListB.getColorForState(new int[]{R.attr.state_focused, R.attr.state_enabled}, -1);
                this.f13285v0 = colorStateListB.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, -1);
            } else {
                this.f13283u0 = this.f13279s0;
                ColorStateList colorStateListA = C0744a.a(context2, C0410c.f6742c);
                this.f13281t0 = colorStateListA.getColorForState(new int[]{-16842910}, -1);
                this.f13285v0 = colorStateListA.getColorForState(new int[]{R.attr.state_hovered}, -1);
            }
        } else {
            this.f13245b0 = 0;
            this.f13279s0 = 0;
            this.f13281t0 = 0;
            this.f13283u0 = 0;
            this.f13285v0 = 0;
        }
        int i16 = C0418k.f7006L4;
        if (a0VarJ.s(i16)) {
            ColorStateList colorStateListC = a0VarJ.c(i16);
            this.f13269n0 = colorStateListC;
            this.f13267m0 = colorStateListC;
        }
        int i17 = C0418k.f7084Y4;
        ColorStateList colorStateListB2 = C0981c.b(context2, a0VarJ, i17);
        this.f13275q0 = a0VarJ.b(i17, 0);
        this.f13271o0 = androidx.core.content.a.c(context2, C0410c.f6743d);
        this.f13287w0 = androidx.core.content.a.c(context2, C0410c.f6744e);
        this.f13273p0 = androidx.core.content.a.c(context2, C0410c.f6745f);
        if (colorStateListB2 != null) {
            setBoxStrokeColorStateList(colorStateListB2);
        }
        int i18 = C0418k.f7090Z4;
        if (a0VarJ.s(i18)) {
            setBoxStrokeErrorColor(C0981c.b(context2, a0VarJ, i18));
        }
        if (a0VarJ.n(i11, -1) != -1) {
            setHintTextAppearance(a0VarJ.n(i11, 0));
        }
        this.f13218B = a0VarJ.c(C0418k.i5);
        this.f13220C = a0VarJ.c(C0418k.j5);
        int iN = a0VarJ.n(i9, 0);
        CharSequence charSequenceP = a0VarJ.p(C0418k.t5);
        int iK = a0VarJ.k(C0418k.s5, 1);
        boolean zA = a0VarJ.a(C0418k.u5, false);
        int iN2 = a0VarJ.n(i10, 0);
        boolean zA2 = a0VarJ.a(C0418k.C5, false);
        CharSequence charSequenceP2 = a0VarJ.p(C0418k.B5);
        int iN3 = a0VarJ.n(C0418k.Q5, 0);
        CharSequence charSequenceP3 = a0VarJ.p(C0418k.P5);
        boolean zA3 = a0VarJ.a(C0418k.f7111c5, false);
        setCounterMaxLength(a0VarJ.k(C0418k.f7118d5, -1));
        this.f13276r = a0VarJ.n(i7, 0);
        this.f13274q = a0VarJ.n(i8, 0);
        setBoxBackgroundMode(a0VarJ.k(C0418k.f7048S4, 0));
        setErrorContentDescription(charSequenceP);
        setErrorAccessibilityLiveRegion(iK);
        setCounterOverflowTextAppearance(this.f13274q);
        setHelperTextTextAppearance(iN2);
        setErrorTextAppearance(iN);
        setCounterTextAppearance(this.f13276r);
        setPlaceholderText(charSequenceP3);
        setPlaceholderTextAppearance(iN3);
        int i19 = C0418k.z5;
        if (a0VarJ.s(i19)) {
            setErrorTextColor(a0VarJ.c(i19));
        }
        int i20 = C0418k.E5;
        if (a0VarJ.s(i20)) {
            setHelperTextColor(a0VarJ.c(i20));
        }
        int i21 = C0418k.J5;
        if (a0VarJ.s(i21)) {
            setHintTextColor(a0VarJ.c(i21));
        }
        int i22 = C0418k.h5;
        if (a0VarJ.s(i22)) {
            setCounterTextColor(a0VarJ.c(i22));
        }
        int i23 = C0418k.f5;
        if (a0VarJ.s(i23)) {
            setCounterOverflowTextColor(a0VarJ.c(i23));
        }
        int i24 = C0418k.R5;
        if (a0VarJ.s(i24)) {
            setPlaceholderTextColor(a0VarJ.c(i24));
        }
        r rVar = new r(this, a0VarJ);
        this.f13246c = rVar;
        boolean zA4 = a0VarJ.a(C0418k.f7000K4, true);
        setHintMaxLines(a0VarJ.k(C0418k.H5, 1));
        a0VarJ.x();
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
        this.f13246c.Q(charSequence);
    }

    public void setEndIconDrawable(Drawable drawable) {
        this.f13246c.S(drawable);
    }

    public void setErrorIconDrawable(Drawable drawable) {
        this.f13246c.c0(drawable);
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(CharSequence charSequence) {
        this.f13246c.j0(charSequence);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(Drawable drawable) {
        this.f13246c.l0(drawable);
    }

    public void setStartIconContentDescription(CharSequence charSequence) {
        this.f13244b.r(charSequence);
    }

    public void setStartIconDrawable(Drawable drawable) {
        this.f13244b.s(drawable);
    }

    public void setHint(int i5) {
        setHint(i5 != 0 ? getResources().getText(i5) : null);
    }
}
