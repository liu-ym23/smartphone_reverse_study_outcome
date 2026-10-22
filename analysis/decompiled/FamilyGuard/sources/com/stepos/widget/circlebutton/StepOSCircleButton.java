package com.stepos.widget.circlebutton;

import K2.A;
import K2.o;
import V3.v;
import W3.C0403n;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.widget.D;
import com.stepos.minor.Minor;
import com.stepos.widget.circlebutton.StepOSCircleButton;
import g4.C0743a;
import i4.InterfaceC0761a;
import i4.InterfaceC0772l;
import j4.g;
import j4.k;
import java.util.Set;
import kotlin.ranges.l;
import l3.C0844b;
import l3.C0846d;
import l3.C0847e;
import l3.f;
import l3.m;
import org.libpag.BuildConfig;
import r3.C1003H;
import r3.C1009e;
import r3.C1010f;
import r3.C1012h;
import r3.InterfaceC1005a;
import r3.j;
import s3.e;

/* loaded from: classes.dex */
public class StepOSCircleButton extends D {

    /* renamed from: M, reason: collision with root package name */
    private static final a f16088M = new a(null);

    /* renamed from: A, reason: collision with root package name */
    private Drawable f16089A;

    /* renamed from: B, reason: collision with root package name */
    private int f16090B;

    /* renamed from: C, reason: collision with root package name */
    private ColorStateList f16091C;

    /* renamed from: D, reason: collision with root package name */
    private int f16092D;

    /* renamed from: E, reason: collision with root package name */
    private ColorStateList f16093E;

    /* renamed from: F, reason: collision with root package name */
    private int f16094F;

    /* renamed from: G, reason: collision with root package name */
    private boolean f16095G;

    /* renamed from: H, reason: collision with root package name */
    private float f16096H;

    /* renamed from: I, reason: collision with root package name */
    private boolean f16097I;

    /* renamed from: J, reason: collision with root package name */
    private o f16098J;

    /* renamed from: K, reason: collision with root package name */
    private boolean f16099K;

    /* renamed from: L, reason: collision with root package name */
    private Drawable f16100L;

    /* renamed from: h, reason: collision with root package name */
    private j f16101h;

    /* renamed from: i, reason: collision with root package name */
    private final C1009e f16102i;

    /* renamed from: j, reason: collision with root package name */
    private b f16103j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f16104k;

    /* renamed from: l, reason: collision with root package name */
    private InterfaceC1005a f16105l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f16106m;

    /* renamed from: n, reason: collision with root package name */
    private CharSequence f16107n;

    /* renamed from: o, reason: collision with root package name */
    private int f16108o;

    /* renamed from: p, reason: collision with root package name */
    private int f16109p;

    /* renamed from: q, reason: collision with root package name */
    private Drawable f16110q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f16111r;

    /* renamed from: s, reason: collision with root package name */
    private final e f16112s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f16113t;

    /* renamed from: u, reason: collision with root package name */
    private final Runnable f16114u;

    /* renamed from: v, reason: collision with root package name */
    private final C1012h f16115v;

    /* renamed from: w, reason: collision with root package name */
    private CharSequence f16116w;

    /* renamed from: x, reason: collision with root package name */
    private int f16117x;

    /* renamed from: y, reason: collision with root package name */
    private int f16118y;

    /* renamed from: z, reason: collision with root package name */
    private float f16119z;

    private static final class a {
        public /* synthetic */ a(g gVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Context b(Context context, int i5) {
            return i5 == 0 ? context : new ContextThemeWrapper(context, i5);
        }

        private a() {
        }
    }

    private static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final int f16120a;

        /* renamed from: b, reason: collision with root package name */
        private final int f16121b;

        /* renamed from: c, reason: collision with root package name */
        private final float f16122c;

        /* renamed from: d, reason: collision with root package name */
        private final boolean f16123d;

        /* renamed from: e, reason: collision with root package name */
        private final o f16124e;

        /* renamed from: f, reason: collision with root package name */
        private final InterfaceC1005a f16125f;

        public b(int i5, int i6, float f5, boolean z5, o oVar, InterfaceC1005a interfaceC1005a) {
            k.g(oVar, "effect");
            this.f16120a = i5;
            this.f16121b = i6;
            this.f16122c = f5;
            this.f16123d = z5;
            this.f16124e = oVar;
            this.f16125f = interfaceC1005a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f16120a == bVar.f16120a && this.f16121b == bVar.f16121b && Float.compare(this.f16122c, bVar.f16122c) == 0 && this.f16123d == bVar.f16123d && k.b(this.f16124e, bVar.f16124e) && k.b(this.f16125f, bVar.f16125f);
        }

        public int hashCode() {
            int iHashCode = ((((((((Integer.hashCode(this.f16120a) * 31) + Integer.hashCode(this.f16121b)) * 31) + Float.hashCode(this.f16122c)) * 31) + Boolean.hashCode(this.f16123d)) * 31) + this.f16124e.hashCode()) * 31;
            InterfaceC1005a interfaceC1005a = this.f16125f;
            return iHashCode + (interfaceC1005a == null ? 0 : interfaceC1005a.hashCode());
        }

        public String toString() {
            return "GlassRequest(width=" + this.f16120a + ", height=" + this.f16121b + ", radius=" + this.f16122c + ", crossWindow=" + this.f16123d + ", effect=" + this.f16124e + ", customizer=" + this.f16125f + ")";
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSCircleButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        k.g(context, "context");
    }

    private final CharSequence A() {
        if (K()) {
            return BuildConfig.FLAVOR;
        }
        CharSequence charSequence = this.f16107n;
        Drawable subDrawable = getSubDrawable();
        if (subDrawable != null) {
            y();
            return z(charSequence, subDrawable);
        }
        CharSequence subText = getSubText();
        if (subText == null || subText.length() == 0) {
            if (this.f16109p <= 0 || charSequence.length() == 0) {
                return charSequence;
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
            spannableStringBuilder.setSpan(new com.stepos.widget.circlebutton.a(this.f16109p), 0, charSequence.length(), 33);
            return spannableStringBuilder;
        }
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
        spannableStringBuilder2.append(charSequence);
        if (this.f16109p > 0 && charSequence.length() > 0) {
            spannableStringBuilder2.setSpan(new com.stepos.widget.circlebutton.a(this.f16109p), 0, charSequence.length(), 33);
        }
        spannableStringBuilder2.append('\n');
        int length = spannableStringBuilder2.length();
        spannableStringBuilder2.append(subText);
        int length2 = spannableStringBuilder2.length();
        spannableStringBuilder2.setSpan(new AbsoluteSizeSpan(getSubTextSize(), false), length, length2, 33);
        spannableStringBuilder2.setSpan(new ForegroundColorSpan(getSubTextColor()), length, length2, 33);
        int i5 = this.f16108o;
        if (i5 > 0) {
            spannableStringBuilder2.setSpan(new com.stepos.widget.circlebutton.a(i5), length, length2, 33);
        }
        if (getSubLetterSpacing() == 0.0f) {
            return spannableStringBuilder2;
        }
        spannableStringBuilder2.setSpan(new com.stepos.widget.circlebutton.b(getSubLetterSpacing()), length, length2, 33);
        return spannableStringBuilder2;
    }

    private final Drawable B() {
        Drawable drawableE = androidx.core.content.a.e(getContext(), f.f18397c);
        if (drawableE != null) {
            return drawableE.mutate();
        }
        return null;
    }

    private final InterfaceC1005a C() {
        return (getResources().getConfiguration().uiMode & 48) == 32 ? C1003H.f20004a.s(getResources().getDisplayMetrics().density) : C1003H.f20004a.A(getResources().getDisplayMetrics().density);
    }

    private final void D(Drawable drawable, Canvas canvas) {
        float iconSize = (getIconSize() > 0 ? getIconSize() : Math.min(getWidth(), getHeight())) / 2.0f;
        float width = getWidth() / 2.0f;
        float height = getHeight() / 2.0f;
        drawable.setBounds((int) (width - iconSize), (int) (height - iconSize), (int) (width + iconSize), (int) (height + iconSize));
        drawable.setState(getDrawableState());
        ColorStateList iconTintList = getIconTintList();
        if (iconTintList != null) {
            drawable.setTintList(iconTintList);
        }
        drawable.draw(canvas);
    }

    private final float E() {
        return getGlassCornerRadius() > 0.0f ? getGlassCornerRadius() : Math.min(getWidth(), getHeight()) / 2.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final v F(StepOSCircleButton stepOSCircleButton) {
        stepOSCircleButton.P();
        stepOSCircleButton.Q();
        return v.f5542a;
    }

    private final void G() {
        float fMin = Math.min(getWidth(), getHeight()) / 2.0f;
        s3.f.e(s3.f.f20267a, this, getRippleColor(), fMin, false, false, fMin, 8, null);
        if (L()) {
            this.f16112s.m();
        }
    }

    private final boolean H(int i5) throws Resources.NotFoundException {
        try {
            String resourceTypeName = getResources().getResourceTypeName(i5);
            if (k.b(resourceTypeName, "drawable")) {
                return true;
            }
            return k.b(resourceTypeName, "mipmap");
        } catch (Resources.NotFoundException unused) {
            return false;
        }
    }

    private final void M(TypedArray typedArray) {
        int i5 = m.f18731o1;
        if (typedArray.hasValue(i5)) {
            int resourceId = typedArray.getResourceId(i5, 0);
            if (resourceId == 0 || !H(resourceId)) {
                setSubText(typedArray.getText(i5));
            } else {
                setSubDrawable(androidx.core.content.a.e(getContext(), resourceId));
            }
        }
    }

    private final void N() {
        if (this.f16111r) {
            super.setText(A(), TextView.BufferType.SPANNABLE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O(StepOSCircleButton stepOSCircleButton) {
        stepOSCircleButton.f16104k = false;
        if (stepOSCircleButton.isAttachedToWindow()) {
            stepOSCircleButton.w();
        }
    }

    private final void P() {
        this.f16102i.m();
        this.f16103j = null;
        invalidate();
    }

    private final void Q() {
        if (J() && isAttachedToWindow() && !this.f16104k) {
            this.f16104k = true;
            post(this.f16114u);
        }
    }

    private final void w() {
        if (!J() || getWidth() <= 0 || getHeight() <= 0 || getVisibility() == 8) {
            P();
            return;
        }
        float fE = E();
        final InterfaceC1005a interfaceC1005a = this.f16105l;
        b bVar = new b(getWidth(), getHeight(), fE, I(), getGlassEffect(), interfaceC1005a);
        if (k.b(this.f16103j, bVar)) {
            return;
        }
        boolean zI = I();
        if (interfaceC1005a != null) {
            this.f16102i.h(zI ? 1 : 0, fE, new InterfaceC0772l() { // from class: n3.c
                @Override // i4.InterfaceC0772l
                public final Object invoke(Object obj) {
                    return StepOSCircleButton.x(interfaceC1005a, (A) obj);
                }
            });
        } else {
            this.f16102i.d(zI ? 1 : 0, fE, getGlassEffect());
        }
        this.f16103j = bVar;
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final A x(InterfaceC1005a interfaceC1005a, A a6) {
        k.g(a6, "it");
        return interfaceC1005a.a(a6);
    }

    private final void y() {
        Drawable subDrawable = getSubDrawable();
        if (subDrawable == null) {
            return;
        }
        int subDrawableSize = getSubDrawableSize() > 0 ? getSubDrawableSize() : this.f16108o;
        int intrinsicWidth = subDrawable.getIntrinsicWidth();
        int intrinsicHeight = subDrawable.getIntrinsicHeight();
        if (subDrawableSize > 0 && intrinsicWidth > 0 && intrinsicHeight > 0) {
            intrinsicWidth = l.b((int) ((subDrawableSize * intrinsicWidth) / intrinsicHeight), 1);
        } else if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            subDrawableSize = l.b(subDrawableSize, 1);
            intrinsicWidth = subDrawableSize;
        } else {
            subDrawableSize = intrinsicHeight;
        }
        subDrawable.setBounds(0, 0, intrinsicWidth, subDrawableSize);
        subDrawable.setTintList(getSubDrawableTintList());
        subDrawable.setState(getDrawableState());
    }

    private final CharSequence z(CharSequence charSequence, Drawable drawable) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (charSequence.length() > 0) {
            spannableStringBuilder.append(charSequence);
            int i5 = this.f16109p;
            if (i5 > 0) {
                spannableStringBuilder.setSpan(new com.stepos.widget.circlebutton.a(i5), 0, charSequence.length(), 33);
            }
            spannableStringBuilder.append('\n');
        }
        int length = spannableStringBuilder.length();
        spannableStringBuilder.append((char) 65532);
        int length2 = spannableStringBuilder.length();
        spannableStringBuilder.setSpan(new ImageSpan(drawable, 2), length, length2, 33);
        int iB = l.b(this.f16108o, drawable.getBounds().height());
        if (iB > 0) {
            spannableStringBuilder.setSpan(new com.stepos.widget.circlebutton.a(iB), length, length2, 33);
        }
        return spannableStringBuilder;
    }

    public boolean I() {
        return this.f16097I;
    }

    public boolean J() {
        return this.f16095G;
    }

    public boolean K() {
        return this.f16110q != null;
    }

    public boolean L() {
        return this.f16099K;
    }

    @Override // android.widget.TextView, android.view.View
    public void drawableHotspotChanged(float f5, float f6) {
        super.drawableHotspotChanged(f5, f6);
        j jVar = this.f16101h;
        if (jVar != null) {
            jVar.c(f5, f6);
        }
        Drawable foreground = getForeground();
        if (foreground != null) {
            foreground.setHotspot(f5, f6);
        }
    }

    @Override // androidx.appcompat.widget.D, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        j jVar = this.f16101h;
        boolean z5 = false;
        if (jVar != null && jVar.g()) {
            z5 = true;
        }
        Drawable subDrawable = getSubDrawable();
        if ((subDrawable == null || !subDrawable.setState(getDrawableState())) ? z5 : true) {
            invalidate();
        }
    }

    public Set<String> getGlassActiveIds() {
        return C0403n.X(this.f16102i.j());
    }

    public float getGlassCornerRadius() {
        return this.f16096H;
    }

    public o getGlassEffect() {
        return this.f16098J;
    }

    public int getIconSize() {
        return this.f16092D;
    }

    public ColorStateList getIconTintList() {
        return this.f16093E;
    }

    public Drawable getImageDrawable() {
        return this.f16110q;
    }

    public int getRippleColor() {
        return this.f16094F;
    }

    public Drawable getSubDrawable() {
        return this.f16089A;
    }

    public int getSubDrawableSize() {
        return this.f16090B;
    }

    public ColorStateList getSubDrawableTintList() {
        return this.f16091C;
    }

    public float getSubLetterSpacing() {
        return this.f16119z;
    }

    public CharSequence getSubText() {
        return this.f16116w;
    }

    public int getSubTextColor() {
        return this.f16118y;
    }

    public int getSubTextSize() {
        return this.f16117x;
    }

    public Drawable getSurfaceDrawable() {
        return this.f16100L;
    }

    @Override // android.widget.TextView, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        j jVar = this.f16101h;
        if (jVar != null) {
            jVar.d();
        }
        Drawable subDrawable = getSubDrawable();
        if (subDrawable != null) {
            subDrawable.jumpToCurrentState();
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable subDrawable = getSubDrawable();
        if (subDrawable != null) {
            subDrawable.setCallback(this);
        }
        if (L()) {
            this.f16112s.d();
        }
        Q();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        k.g(configuration, "newConfig");
        super.onConfigurationChanged(configuration);
        if (J() && this.f16106m) {
            this.f16105l = C();
        }
        this.f16115v.c(configuration);
    }

    @Override // androidx.appcompat.widget.D, android.view.View
    protected void onDetachedFromWindow() {
        removeCallbacks(this.f16114u);
        this.f16104k = false;
        this.f16115v.b();
        this.f16112s.o();
        P();
        Drawable subDrawable = getSubDrawable();
        if (subDrawable != null) {
            subDrawable.setCallback(null);
        }
        super.onDetachedFromWindow();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        j jVar;
        k.g(canvas, "canvas");
        if (!this.f16102i.l() && (jVar = this.f16101h) != null) {
            jVar.a(canvas);
        }
        super.onDraw(canvas);
        Drawable drawable = this.f16110q;
        if (drawable != null) {
            D(drawable, canvas);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        k.g(accessibilityNodeInfo, "info");
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(Button.class.getName());
    }

    @Override // android.widget.TextView, android.view.View
    public void onRtlPropertiesChanged(int i5) {
        super.onRtlPropertiesChanged(i5);
        j jVar = this.f16101h;
        if (jVar != null) {
            jVar.h(i5);
        }
        Drawable subDrawable = getSubDrawable();
        if (subDrawable != null) {
            subDrawable.setLayoutDirection(i5);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i5, int i6, int i7, int i8) {
        super.onSizeChanged(i5, i6, i7, i8);
        G();
        Q();
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        k.g(motionEvent, "event");
        if (this.f16111r && L() && isEnabled()) {
            this.f16112s.k(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.TextView, android.view.View
    public void setEnabled(boolean z5) {
        super.setEnabled(z5);
        if (!this.f16111r || z5) {
            return;
        }
        this.f16112s.o();
    }

    public void setGlassCornerRadius(float f5) {
        if (f5 < 0.0f) {
            throw new IllegalArgumentException(("glassCornerRadius must be >= 0 but was " + f5).toString());
        }
        if (this.f16096H == f5) {
            return;
        }
        this.f16096H = f5;
        P();
        Q();
    }

    public void setGlassCrossWindow(boolean z5) {
        if (this.f16097I == z5) {
            return;
        }
        this.f16097I = z5;
        P();
        Q();
    }

    public void setGlassEffect(o oVar) {
        k.g(oVar, "value");
        boolean z5 = this.f16105l != null;
        this.f16105l = null;
        this.f16106m = false;
        if (!k.b(this.f16098J, oVar) || z5) {
            this.f16098J = oVar;
            P();
            Q();
        }
    }

    public void setGlassEnabled(boolean z5) {
        if (this.f16095G == z5) {
            return;
        }
        this.f16095G = z5;
        if (z5) {
            Q();
        } else {
            P();
        }
    }

    public void setIconSize(int i5) {
        if (i5 < 0) {
            throw new IllegalArgumentException(("iconSize must be >= 0 but was " + i5).toString());
        }
        if (this.f16092D == i5) {
            return;
        }
        this.f16092D = i5;
        invalidate();
    }

    public final void setIconSizeRes(int i5) {
        setIconSize(getResources().getDimensionPixelSize(i5));
    }

    public final void setIconTint(int i5) {
        setIconTintList(ColorStateList.valueOf(i5));
    }

    public void setIconTintList(ColorStateList colorStateList) {
        this.f16093E = colorStateList;
        invalidate();
    }

    public final void setIconTintResource(int i5) {
        setIconTintList(androidx.core.content.a.d(getContext(), i5));
    }

    public final void setImageBitmap(Bitmap bitmap) {
        k.g(bitmap, "bitmap");
        setImageDrawable(new BitmapDrawable(getResources(), bitmap));
    }

    public final void setImageDrawable(Drawable drawable) {
        this.f16110q = drawable;
        N();
        invalidate();
    }

    public final void setImageIcon(Icon icon) {
        k.g(icon, Minor.COLUMN_ICON);
        setImageDrawable(icon.loadDrawable(getContext()));
    }

    public final void setImageResource(int i5) {
        setImageDrawable(androidx.core.content.a.e(getContext(), i5));
    }

    public void setPressScaleEnabled(boolean z5) {
        if (this.f16099K == z5) {
            return;
        }
        this.f16099K = z5;
        if (!z5) {
            this.f16112s.o();
        }
        G();
        if (z5 && isAttachedToWindow()) {
            this.f16112s.d();
        }
    }

    public void setRippleColor(int i5) {
        if (this.f16094F == i5) {
            return;
        }
        this.f16094F = i5;
        G();
    }

    public final void setSubBitmap(Bitmap bitmap) {
        k.g(bitmap, "bitmap");
        setSubDrawable(new BitmapDrawable(getResources(), bitmap));
    }

    public void setSubDrawable(Drawable drawable) {
        CharSequence subText;
        if (drawable == null) {
            Drawable drawable2 = this.f16089A;
            if (drawable2 == null) {
                return;
            }
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            this.f16089A = null;
            if (this.f16113t) {
                return;
            }
            N();
            return;
        }
        Drawable drawableMutate = drawable.mutate();
        k.f(drawableMutate, "mutate(...)");
        Drawable drawable3 = this.f16089A;
        if (drawable3 != null) {
            drawable3.setCallback(null);
        }
        drawableMutate.setCallback(this);
        this.f16089A = drawableMutate;
        y();
        if (!this.f16113t && (subText = getSubText()) != null && subText.length() != 0) {
            this.f16113t = true;
            try {
                setSubText((CharSequence) null);
            } finally {
                this.f16113t = false;
            }
        }
        if (this.f16113t) {
            return;
        }
        N();
    }

    public final void setSubDrawableResource(int i5) {
        Drawable drawableE = androidx.core.content.a.e(getContext(), i5);
        if (drawableE != null) {
            setSubDrawable(drawableE);
            return;
        }
        throw new Resources.NotFoundException("Drawable resource #" + i5 + " not found");
    }

    public void setSubDrawableSize(int i5) {
        if (i5 < 0) {
            throw new IllegalArgumentException(("subDrawableSize must be >= 0 but was " + i5).toString());
        }
        if (this.f16090B == i5) {
            return;
        }
        this.f16090B = i5;
        if (getSubDrawable() != null) {
            y();
            N();
        }
    }

    public final void setSubDrawableSizeRes(int i5) {
        setSubDrawableSize(getResources().getDimensionPixelSize(i5));
    }

    public final void setSubDrawableTint(int i5) {
        setSubDrawableTintList(ColorStateList.valueOf(i5));
    }

    public void setSubDrawableTintList(ColorStateList colorStateList) {
        if (k.b(this.f16091C, colorStateList)) {
            return;
        }
        this.f16091C = colorStateList;
        Drawable subDrawable = getSubDrawable();
        if (subDrawable != null) {
            subDrawable.setTintList(colorStateList);
        }
        if (getSubDrawable() != null) {
            invalidate();
        }
    }

    public final void setSubDrawableTintResource(int i5) {
        setSubDrawableTintList(androidx.core.content.a.d(getContext(), i5));
    }

    public final void setSubIcon(Icon icon) {
        k.g(icon, Minor.COLUMN_ICON);
        setSubDrawable(icon.loadDrawable(getContext()));
    }

    public void setSubLetterSpacing(float f5) {
        if (this.f16119z == f5) {
            return;
        }
        this.f16119z = f5;
        N();
    }

    public void setSubText(CharSequence charSequence) {
        boolean z5 = (this.f16113t || getSubDrawable() == null) ? false : true;
        if (!k.b(this.f16116w, charSequence) || z5) {
            this.f16116w = charSequence;
            if (z5) {
                this.f16113t = true;
                try {
                    setSubDrawable(null);
                } finally {
                    this.f16113t = false;
                }
            }
            if (this.f16113t) {
                return;
            }
            N();
        }
    }

    public void setSubTextColor(int i5) {
        if (this.f16118y == i5) {
            return;
        }
        this.f16118y = i5;
        N();
    }

    public void setSubTextSize(int i5) {
        if (i5 < 0) {
            throw new IllegalArgumentException(("subTextSize must be >= 0 but was " + i5).toString());
        }
        if (this.f16117x == i5) {
            return;
        }
        this.f16117x = i5;
        N();
    }

    public final void setSubTextSizeRes(int i5) {
        setSubTextSize(getResources().getDimensionPixelSize(i5));
    }

    public void setSurfaceDrawable(Drawable drawable) {
        this.f16100L = drawable;
        j jVar = this.f16101h;
        if (jVar != null) {
            jVar.f(drawable);
        }
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        if (!this.f16111r) {
            super.setText(charSequence, bufferType);
            return;
        }
        if (charSequence == null) {
            charSequence = BuildConfig.FLAVOR;
        }
        this.f16107n = charSequence;
        super.setText(A(), TextView.BufferType.SPANNABLE);
    }

    @Override // android.widget.TextView, android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        j jVar;
        k.g(drawable, "who");
        return drawable == getSubDrawable() || ((jVar = this.f16101h) != null && jVar.i(drawable)) || super.verifyDrawable(drawable);
    }

    public /* synthetic */ StepOSCircleButton(Context context, AttributeSet attributeSet, int i5, int i6, int i7, g gVar) {
        this(context, (i7 & 2) != 0 ? null : attributeSet, (i7 & 4) != 0 ? C0844b.f18283d : i5, (i7 & 8) != 0 ? l3.l.f18490m : i6);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepOSCircleButton(Context context, AttributeSet attributeSet, int i5, int i6) throws Exception {
        super(f16088M.b(context, i6), attributeSet, i5);
        k.g(context, "context");
        this.f16102i = new C1009e(this);
        this.f16105l = C();
        this.f16106m = true;
        CharSequence charSequence = BuildConfig.FLAVOR;
        this.f16107n = BuildConfig.FLAVOR;
        this.f16112s = new e(this);
        this.f16114u = new Runnable() { // from class: n3.a
            @Override // java.lang.Runnable
            public final void run() {
                StepOSCircleButton.O(this.f18936a);
            }
        };
        this.f16115v = new C1012h(this, new InterfaceC0761a() { // from class: n3.b
            @Override // i4.InterfaceC0761a
            public final Object invoke() {
                return StepOSCircleButton.F(this.f18937a);
            }
        });
        this.f16095G = true;
        this.f16098J = o.f3626h.i();
        this.f16099K = true;
        this.f16101h = new j(this);
        setClickable(true);
        setFocusable(true);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.f18683g1, i5, i6);
        try {
            setSubTextSize(typedArrayObtainStyledAttributes.getDimensionPixelSize(m.f18743q1, getResources().getDimensionPixelSize(C0847e.f18350c)));
            setSubTextColor(typedArrayObtainStyledAttributes.getColor(m.f18737p1, androidx.core.content.a.c(context, C0846d.f18302i)));
            setSubLetterSpacing(typedArrayObtainStyledAttributes.getFloat(m.f18725n1, 0.0f));
            setSubDrawableSize(typedArrayObtainStyledAttributes.getDimensionPixelSize(m.f18713l1, 0));
            setSubDrawableTintList(typedArrayObtainStyledAttributes.getColorStateList(m.f18719m1));
            this.f16108o = getResources().getDimensionPixelSize(C0847e.f18348b);
            this.f16109p = getResources().getDimensionPixelSize(C0847e.f18352d);
            setIconSize(typedArrayObtainStyledAttributes.getDimensionPixelSize(m.f18695i1, getResources().getDimensionPixelSize(C0847e.f18346a)));
            ColorStateList colorStateList = typedArrayObtainStyledAttributes.getColorStateList(m.f18701j1);
            setIconTintList(colorStateList == null ? androidx.core.content.a.d(context, C0846d.f18300g) : colorStateList);
            setRippleColor(typedArrayObtainStyledAttributes.getColor(m.f18707k1, androidx.core.content.a.c(context, C0846d.f18301h)));
            setGlassEnabled(typedArrayObtainStyledAttributes.getBoolean(m.f18761t1, true));
            setGlassCrossWindow(typedArrayObtainStyledAttributes.getBoolean(m.f18749r1, false));
            C1010f c1010f = C1010f.f20022a;
            k.d(typedArrayObtainStyledAttributes);
            o oVarB = c1010f.b(typedArrayObtainStyledAttributes, m.f18755s1);
            if (oVarB != null) {
                setGlassEffect(oVarB);
            }
            setPressScaleEnabled(typedArrayObtainStyledAttributes.getBoolean(m.f18767u1, true));
            int resourceId = typedArrayObtainStyledAttributes.getResourceId(m.f18689h1, 0);
            if (resourceId != 0) {
                setImageResource(resourceId);
            }
            M(typedArrayObtainStyledAttributes);
            v vVar = v.f5542a;
            C0743a.a(typedArrayObtainStyledAttributes, null);
            Drawable background = getBackground();
            setBackground(null);
            setSurfaceDrawable(background == null ? B() : background);
            G();
            CharSequence text = getText();
            this.f16107n = text != null ? text : charSequence;
            this.f16111r = true;
            N();
        } finally {
        }
    }

    public final void setSubText(int i5) {
        setSubText(getResources().getText(i5));
    }
}
