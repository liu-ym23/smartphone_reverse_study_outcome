package com.obric.oui.tab;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ArgbEvaluator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.g0;
import androidx.core.content.ContextCompat;
import androidx.core.util.Pools$Pool;
import androidx.core.util.Pools$SynchronizedPool;
import androidx.core.view.ViewCompat;
import androidx.core.view.k;
import androidx.core.widget.TextViewCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.google.common.primitives.Ints;
import com.obric.common.oui.R$attr;
import com.obric.common.oui.R$color;
import com.obric.common.oui.R$dimen;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.common.oui.R$string;
import com.obric.common.oui.R$style;
import com.obric.common.oui.R$styleable;
import com.obric.oui.bouncelayout.OHorizontalScrollView;
import com.obric.oui.color.i0;
import com.obric.oui.common.style.OUIAlphaHelper;
import com.obric.oui.common.style.OUILayoutHelper;
import com.obric.oui.common.style.Shadow;
import com.obric.oui.common.style.ShadowAnimator;
import com.obric.oui.common.style.l;
import com.obric.oui.layout.OUILinearLayout;
import com.obric.oui.material.MaterialOwner;
import com.obric.oui.material.MaterialToken;
import com.obric.oui.material.OMaterialHelper;
import com.obric.oui.material.o;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlinx.coroutines.channels.Channel;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
@ViewPager.DecorView
public class OTabLayoutBase extends OHorizontalScrollView implements ValueAnimator.AnimatorUpdateListener, MaterialOwner {
    public static final Interpolator M0 = null;
    public static final Pools$Pool N0 = null;
    public static final int[] O0 = null;
    public int A;
    public final ValueAnimator A0;
    public final int B;
    public final PathInterpolator B0;
    public int C;
    public final float[] C0;
    public int D;
    public final d D0;
    public int E;
    public final d E0;
    public int F;
    public int F0;
    public boolean G;
    public boolean G0;
    public OnTabSelectedListener H;
    public OnTabClickListener H0;
    public final ArrayList I;
    public final Pools$Pool I0;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public OnTabSelectedListener f17102J;
    public int J0;
    public ValueAnimator K;
    public Typeface K0;
    public ViewPager L;
    public Typeface L0;
    public PagerAdapter M;
    public DataSetObserver N;
    public i O;
    public c P;
    public boolean Q;
    public float R;
    public float S;
    public boolean T;
    public int U;
    public int V;
    public Drawable W;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f17103a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public float f17104a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public h f17105b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public float f17106b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public h f17107c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public float f17108c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f17109d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public final Paint f17110d0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public WeakReference f17111e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public final Paint f17112e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f17113f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public final Paint f17114f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final g f17115g;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public final RectF f17116g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f17117h;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public final RectF f17118h0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f17119i;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public final RectF f17120i0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f17121j;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public final RectF f17122j0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f17123k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public int f17124k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f17125l;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public boolean f17126l0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f17127m;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public boolean f17128m0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f17129n;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public int f17130n0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f17131o;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public int f17132o0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f17133p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public boolean f17134p0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f17135q;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public String f17136q0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f17137r;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public com.obric.oui.material.b[] f17138r0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public ColorStateList f17139s;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public String f17140s0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f17141t;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public com.obric.oui.material.b[] f17142t0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public float f17143u;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public List f17144u0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public float f17145v;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public boolean f17146v0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f17147w;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public final Rect f17148w0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f17149x;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public final Rect f17150x0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f17151y;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public final Paint f17152y0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f17153z;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public final nd.a f17154z0;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface Mode {
    }

    public interface OnTabClickListener {
        void onTabClick(h r10);
    }

    public interface OnTabSelectedListener {
        void onTabReselected(h r10);

        void onTabSelected(h r10);

        void onTabUnselected(h r10);
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface TabGravity {
    }

    public class TabView extends OUILinearLayout implements MaterialOwner {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public h f17155h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public TextView f17156i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public ImageView f17157j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public View f17158k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public TextView f17159l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public ImageView f17160m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f17161n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public boolean f17162o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public com.obric.oui.material.b[] f17163p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public com.obric.oui.material.b[] f17164q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public com.obric.oui.material.b[] f17165r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public boolean f17166s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public jb.d f17167t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public jb.d f17168u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public final /* synthetic */ OTabLayoutBase f17169v;

        public TabView(OTabLayoutBase r10, Context r11, boolean r12, com.obric.oui.material.b[] r13, com.obric.oui.material.b[] r14) {
            this.f17169v = r10;
            super(r11);
            this.f17161n = 1;
            this.f17166s = true;
            this.f17162o = r12;
            p(r13, r14);
            if (OTabLayoutBase.f(r10) == null) goto L5;
            setOverridePressColor(ContextCompat.b(r11, R$color.oui_basic_fill_element_2));
            refreshColors("OTabLayoutBase");
        L5:
            int r15 = r10.f17147w;
            if (r15 == 0) goto L8;
            ViewCompat.t0(this, c.a.b(r11, r15));
        L8:
            setEnableShadowWidthRadius(true);
            if (OTabLayoutBase.f(r10) == null) goto L11;
            boolean r16 = true;
        L12:
            setChangeAlphaWhenPress(r16);
            setChangeAlphaWhenDisable(false);
            setChangeAlphaWhenSelected(false);
            ViewCompat.D0(this, r10.f17127m, r10.f17129n, r10.f17131o, r10.f17133p);
            setMinimumWidth(r10.f17125l);
            setGravity(17);
            setOrientation(1);
            setClickable(true);
            ViewCompat.E0(this, k.b(getContext(), 1002));
            if (this.f17162o == false) goto L16;
            o(isSelected());
            return;
        L16:
            return;
        L11:
            r16 = false;
            goto L12
        }

        public static /* synthetic */ void b(TabView r10, float r11) {
            r10.m(r11);
        }

        @Override // com.obric.oui.material.MaterialOwner
        public void applyContentMaterial(boolean r10) {
            boolean r11 = false;
            if (this.f17166s == false) goto L10;
            if (this.f17162o == false) goto L8;
            if (r10 == false) goto L8;
            r11 = true;
        L8:
            OMaterialHelper.a(this, r11);
            return;
        L10:
            if (this.f17162o == false) goto L13;
            if (r10 == false) goto L13;
            r11 = true;
        L13:
            OMaterialHelper.c(this, r11);
        }

        public final void c() {
            if (this.f17163p != null) goto L5;
            return;
        L5:
            int r10 = (int) tc.f.h(99.0f, getContext());
            setShadowCornerRadius(r10);
            setRadius(r10);
            if (OTabLayoutBase.f(this.f17169v) == null) goto L8;
            ((OUIAlphaHelper) getAlphaHelper()).r(r10);
        L8:
            boolean r11 = this.f17166s;
            if (r11 == false) goto L11;
            int r12 = 2;
        L13:
            if (r11 == false) goto L15;
            o.i(this, this.f17163p, false, r12, null);
        L17:
            if (f() == true) goto L19;
            e();
        L19:
            GradientDrawable r13 = new GradientDrawable();
            r13.setShape(0);
            r13.setCornerRadius(tc.f.h(99.0f, getContext()));
            r13.setColor(0);
            setBackground(r13);
            setOutlineProvider(ViewOutlineProvider.BACKGROUND);
            return;
        L15:
            o.k(this, this.f17163p, false, null);
            goto L17
        L11:
            r12 = 3;
            goto L13
        }

        public final float d(Layout r10, int r11, float r12) {
            return r10.getLineWidth(r11) * (r12 / r10.getPaint().getTextSize());
        }

        @Override // com.obric.oui.layout.OUILinearLayout, android.view.ViewGroup, android.view.View
        public boolean dispatchTouchEvent(MotionEvent r10) {
            boolean r11 = super.dispatchTouchEvent(r10);
            int r12 = r10.getActionMasked();
            if (r12 != 0) goto L5;
            g(true, getCurrentShadows());
        L15:
            return r11;
        L5:
            if (r12 != 1) goto L7;
            g(false, getCurrentShadows());
            goto L15
        L7:
            if (r12 != 3) goto L15;
            if (this.f17162o == false) goto L12;
            j();
            goto L15
        L12:
            g(false, getCurrentShadows());
            goto L15
        }

        public final void e() {
            Shadow r10 = Shadow.f13061i;
            setShadow(r10.a(), r10.a());
        }

        public final boolean f() {
            com.obric.oui.material.b[] r10 = this.f17163p;
            if (r10 != null) goto L5;
            return false;
        L5:
            if (r10.length == 0) goto L19;
            int r11 = OMaterialHelper.q(getContext());
            int r12 = Math.max(0, Math.min(this.f17163p.length - 1, r11 - 1));
            com.obric.oui.material.b r13 = this.f17163p[r12];
            if (r13 != null) goto L10;
            return false;
        L10:
            if (r13.i() != null) goto L12;
            return false;
        L12:
            if (r13.i().length > 0) goto L14;
            return false;
        L14:
            return true;
        L19:
            return false;
        }

        public final void g(boolean r10, List r11) {
            if (isEnabled() == true) goto L5;
            return;
        L5:
            if (OTabLayoutBase.f(this.f17169v) == null) goto L22;
            jb.d r12 = this.f17167t;
            if (r12 == null) goto L10;
            r12.b(false);
        L10:
            jb.d r13 = this.f17168u;
            if (r13 == null) goto L13;
            r13.b(false);
        L13:
            if (r10 == false) goto L15;
            List<Shadow> r14 = getCurrentShadows();
            this.f17167t = ShadowAnimator.c(this, getScaleX(), 0.98f, r14, OTabLayoutBase.f(this.f17169v));
            return;
        L15:
            if (r11 != null) goto L18;
            r11 = getCurrentShadows();
        L18:
            this.f17168u = ShadowAnimator.c(this, getScaleX(), 1.0f, OTabLayoutBase.f(this.f17169v), r11);
            return;
        }

        public int getContentWidth() {
            TextView r10 = this.f17156i;
            boolean r11 = true;
            if (r10 != null) goto L5;
        L7:
            boolean r12 = false;
            int r13 = 0;
            int r14 = 0;
        L8:
            ImageView r15 = this.f17157j;
            if (r15 != null) goto L11;
        L19:
            r11 = r12;
        L20:
            View r16 = this.f17158k;
            if (r16 == null) goto L32;
            if (r16.getVisibility() != 0) goto L32;
            int r17 = this.f17158k.getLeft();
            if (r11 == false) goto L27;
            r17 = Math.min(r13, r17);
        L27:
            r13 = r17;
            int r18 = this.f17158k.getRight();
            if (r11 == false) goto L30;
            r18 = Math.max(r14, r18);
        L30:
            r14 = r18;
        L32:
            return r14 - r13;
        L11:
            if (r15.getVisibility() != 0) goto L19;
            if (r12 == false) goto L14;
            r13 = Math.min(r13, this.f17157j.getLeft());
        L15:
            if (r12 == false) goto L18;
            int r19 = Math.max(r14, this.f17157j.getRight());
        L17:
            r14 = r19;
            goto L20
        L18:
            r19 = this.f17157j.getRight();
            goto L17
        L14:
            r13 = this.f17157j.getLeft();
            goto L15
        L5:
            if (r10.getVisibility() != 0) goto L7;
            int r20 = this.f17156i.getLeft();
            r14 = this.f17156i.getRight();
            r13 = r20;
            r12 = true;
            goto L8
        }

        public h getTab() {
            return this.f17155h;
        }

        public TextView getTextView() {
            return this.f17156i;
        }

        public void h() {
            setTab(null);
            setSelected(false);
        }

        public final void i() {
            if (this.f17169v.f17147w == 0) goto L5;
            ViewCompat.t0(this, c.a.b(getContext(), this.f17169v.f17147w));
        L6:
            setOutlineProvider(null);
            return;
        L5:
            setBackground(null);
            goto L6
        }

        public final void j() {
            jb.d r10 = this.f17167t;
            if (r10 == null) goto L5;
            r10.b(false);
        L5:
            jb.d r11 = this.f17168u;
            if (r11 == null) goto L8;
            r11.b(false);
        L8:
            setScaleX(1.0f);
            setScaleY(1.0f);
            o(isSelected());
        }

        public void k(h r10, boolean r11) {
            if (r10 == this.f17155h) goto L8;
            this.f17155h = r10;
            if (r11 == false) goto L9;
            l();
            return;
        L9:
            return;
        }

        public final void l() {
            h r10 = this.f17155h;
            if (r10 == null) goto L5;
            View r11 = r10.b();
        L6:
            boolean r12 = true;
            if (r11 == null) goto L29;
            ViewParent r13 = r11.getParent();
            if (r13 == this) goto L13;
            if (r13 == null) goto L12;
            ((ViewGroup) r13).removeView(r11);
        L12:
            addView(r11);
        L13:
            this.f17158k = r11;
            TextView r14 = this.f17156i;
            if (r14 == null) goto L16;
            r14.setVisibility(8);
        L16:
            ImageView r15 = this.f17157j;
            if (r15 == null) goto L19;
            r15.setVisibility(8);
            this.f17157j.setImageDrawable(null);
        L19:
            TextView r16 = (TextView) r11.findViewById(R$id.title);
            this.f17159l = r16;
            if (r16 == null) goto L26;
            r16.setDuplicateParentStateEnabled(true);
            this.f17161n = TextViewCompat.d(this.f17159l);
            if (OTabLayoutBase.h(this.f17169v) != null) goto L26;
            if (this.f17156i == null) goto L26;
            OTabLayoutBase.i(this.f17169v, this.f17159l.getTypeface());
        L26:
            ImageView r17 = (ImageView) r11.findViewById(R.id.icon);
            this.f17160m = r17;
            if (r17 == null) goto L34;
            r17.setDuplicateParentStateEnabled(true);
        L34:
            if (this.f17158k == null) goto L36;
            TextView r18 = this.f17159l;
            if (r18 == null) goto L52;
        L53:
            q(r18, this.f17160m);
        L54:
            if (r10 != null) goto L56;
        L58:
            r12 = false;
        L59:
            setSelected(r12);
            if (isEnabled() == false) goto L62;
            float r19 = 1.0f;
        L63:
            m(r19);
            return;
        L62:
            r19 = OTabLayoutBase.m(this.f17169v);
            goto L63
        L56:
            if (r10.h() == false) goto L58;
        L52:
            if (this.f17160m == null) goto L54;
        L36:
            if (this.f17157j != null) goto L39;
            ImageView r20 = (ImageView) LayoutInflater.from(getContext()).inflate(R$layout.design_layout_tab_icon, this, false);
            addView(r20, 0);
            this.f17157j = r20;
            r20.setDuplicateParentStateEnabled(true);
        L39:
            if (this.f17156i != null) goto L45;
            TextView r21 = (TextView) LayoutInflater.from(getContext()).inflate(R$layout.design_layout_tab_text, this, false);
            addView(r21, new LinearLayout.LayoutParams(-1, -2));
            this.f17156i = r21;
            r21.setMaxLines(1);
            this.f17156i.setDuplicateParentStateEnabled(true);
            this.f17161n = TextViewCompat.d(this.f17156i);
            if (OTabLayoutBase.h(this.f17169v) != null) goto L45;
            TextView r22 = this.f17156i;
            if (r22 == null) goto L45;
            OTabLayoutBase.i(this.f17169v, r22.getTypeface());
        L45:
            this.f17156i.setAllCaps(false);
            ColorStateList r23 = this.f17169v.f17139s;
            if (r23 == null) goto L48;
            this.f17156i.setTextColor(r23);
        L48:
            q(this.f17156i, this.f17157j);
            goto L54
        L29:
            View r24 = this.f17158k;
            if (r24 == null) goto L32;
            removeView(r24);
            this.f17158k = null;
        L32:
            this.f17159l = null;
            this.f17160m = null;
            goto L34
        L5:
            r11 = null;
            goto L6
        }

        public final void m(float r10) {
            setChangeAlphaWhenDisable(false);
            setChangeAlphaWhenSelected(false);
            TextView r11 = this.f17156i;
            if (r11 == null) goto L5;
            r11.setAlpha(r10);
        L5:
            ImageView r12 = this.f17157j;
            if (r12 == null) goto L8;
            r12.setAlpha(r10);
        L8:
            TextView r13 = this.f17159l;
            if (r13 == null) goto L11;
            r13.setAlpha(r10);
        L11:
            ImageView r14 = this.f17160m;
            if (r14 == null) goto L14;
            r14.setAlpha(r10);
        L14:
            View r15 = this.f17158k;
            if (r15 == null) goto L18;
            r15.setAlpha(r10);
            return;
        }

        public void n(boolean r10) {
            this.f17162o = r10;
            if (r10 == false) goto L5;
            o(isSelected());
            return;
        L5:
            i();
            e();
            applyContentMaterial(false);
        }

        public final void o(boolean r10) {
            if (this.f17162o == true) goto L6;
            i();
            e();
            applyContentMaterial(false);
            return;
        L6:
            if (r10 == false) goto L10;
            com.obric.oui.material.b[] r11 = this.f17165r;
            if (r11 == null) goto L10;
        L11:
            this.f17163p = r11;
            if (r11 == null) goto L22;
            c();
            applyContentMaterial(true);
            if (r10 == true) goto L16;
            return;
        L16:
            if (OTabLayoutBase.f(this.f17169v) == null) goto L25;
            Shadow r12 = (Shadow) OTabLayoutBase.f(this.f17169v).get(0);
            if (OTabLayoutBase.f(this.f17169v).size() <= 1) goto L20;
            Shadow r13 = (Shadow) OTabLayoutBase.f(this.f17169v).get(1);
        L21:
            setShadow(r12, r13);
            return;
        L20:
            r13 = null;
            goto L21
        L25:
            return;
        L22:
            i();
            e();
            applyContentMaterial(false);
            return;
        L10:
            r11 = this.f17164q;
            goto L11
        }

        @Override // android.view.View
        public void onInitializeAccessibilityEvent(AccessibilityEvent r10) {
            super.onInitializeAccessibilityEvent(r10);
            r10.setClassName(ActionBar.a.class.getName());
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo r10) {
            super.onInitializeAccessibilityNodeInfo(r10);
            r10.setClassName(ActionBar.a.class.getName());
        }

        @Override // com.obric.oui.layout.OUILinearLayout, android.widget.LinearLayout, android.view.View
        public void onMeasure(int r11, int r12) {
            int r10 = View.MeasureSpec.getSize(r11);
            int r13 = View.MeasureSpec.getMode(r11);
            int r14 = this.f17169v.getTabMaxWidth();
            LinearLayout.LayoutParams r15 = (LinearLayout.LayoutParams) this.f17156i.getLayoutParams();
            if (r14 <= 0) goto L7;
            if (r13 == 0) goto L6;
            if (r10 <= r14) goto L7;
        L6:
            r11 = View.MeasureSpec.makeMeasureSpec(this.f17169v.f17149x, Integer.MIN_VALUE);
        L7:
            super.onMeasure(r11, r12);
            if (this.f17156i == null) goto L36;
            getResources();
            OTabLayoutBase r16 = this.f17169v;
            float r17 = r16.f17143u;
            int r18 = this.f17161n;
            int r19 = OTabLayoutBase.k(r16);
            int r20 = OTabLayoutBase.l(this.f17169v);
            ImageView r21 = this.f17157j;
            if (r21 == null) goto L15;
            if (r21.getVisibility() != 0) goto L15;
            r18 = 1;
        L15:
            if (this.f17156i != null) goto L17;
        L21:
            float r22 = this.f17156i.getTextSize();
            int r23 = this.f17156i.getLineCount();
            int r24 = TextViewCompat.d(this.f17156i);
            if (r17 != r22) goto L26;
            if (r24 < 0) goto L37;
            if (r18 != r24) goto L26;
            return;
        L37:
            return;
        L26:
            if (this.f17169v.E != 1) goto L34;
            if (r17 <= r22) goto L34;
            if (r23 != 1) goto L34;
            Layout r25 = this.f17156i.getLayout();
            if (r25 != null) goto L32;
            return;
        L32:
            if (d(r25, 0, r17) <= ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight())) goto L34;
            return;
        L34:
            this.f17156i.setTextSize(0, r17);
            this.f17156i.setMaxLines(r18);
            r15.topMargin = r19;
            r15.leftMargin = r20;
            r15.rightMargin = r20;
            this.f17156i.setLayoutParams(r15);
            super.onMeasure(r11, r12);
            return;
        L17:
            if (isSelected() == false) goto L21;
            float r26 = this.f17169v.f17145v;
            if (r26 <= 0.0f) goto L21;
            r17 = r26;
            r19 = 0;
            r20 = 0;
            goto L21
        }

        public void p(com.obric.oui.material.b[] r10, com.obric.oui.material.b[] r11) {
            this.f17164q = r10;
            this.f17165r = r11;
            this.f17163p = r10;
        }

        @Override // android.view.View
        public boolean performClick() {
            boolean r10 = super.performClick();
            if (this.f17155h == null) goto L12;
            if (r10 == true) goto L7;
            playSoundEffect(0);
        L7:
            if (OTabLayoutBase.g(this.f17169v) == null) goto L9;
            OTabLayoutBase.g(this.f17169v).onTabClick(this.f17155h);
        L10:
            dd.a.b(getContext(), 1);
            return true;
        L9:
            this.f17155h.j();
            goto L10
        L12:
            return r10;
        }

        public final void q(TextView r10, ImageView r11) {
            h r12 = this.f17155h;
            CharSequence r13 = null;
            if (r12 == null) goto L5;
            Drawable r14 = r12.c();
        L6:
            h r15 = this.f17155h;
            if (r15 == null) goto L9;
            CharSequence r16 = r15.f();
        L10:
            h r17 = this.f17155h;
            if (r17 == null) goto L13;
            CharSequence r18 = r17.a();
        L14:
            int r19 = 0;
            if (r11 == null) goto L20;
            if (r14 == null) goto L18;
            r11.setImageDrawable(r14);
            r11.setVisibility(0);
            setVisibility(0);
        L19:
            r11.setContentDescription(r18);
            goto L20
        L18:
            r11.setVisibility(8);
            r11.setImageDrawable(null);
        L20:
            boolean r20 = TextUtils.isEmpty(r16);
            if (r10 == null) goto L26;
            if (r20 == true) goto L24;
            r10.setText(r16);
            r10.setVisibility(0);
            setVisibility(0);
        L25:
            r10.setContentDescription(r18);
            goto L26
        L24:
            r10.setVisibility(8);
            r10.setText(null);
        L26:
            if (r11 == null) goto L35;
            ViewGroup.MarginLayoutParams r21 = (ViewGroup.MarginLayoutParams) r11.getLayoutParams();
            if (r20 == true) goto L33;
            if (r11.getVisibility() != 0) goto L33;
            r19 = this.f17169v.J(8);
        L33:
            if (r19 == r21.bottomMargin) goto L35;
            r21.bottomMargin = r19;
            r11.requestLayout();
        L35:
            if (r20 == false) goto L38;
            r13 = r18;
        L38:
            g0.a(this, r13);
            return;
        L13:
            r18 = null;
            goto L14
        L9:
            r16 = null;
            goto L10
        L5:
            r14 = null;
            goto L6
        }

        @Override // com.obric.oui.material.MaterialOwner, com.obric.oui.material.MaskMaterialOwner
        public void setBackdropTarget(@NotNull View r10) {
            if (this.f17162o == true) goto L5;
            return;
        L5:
            OMaterialHelper.I(this, r10);
        }

        @Override // com.obric.oui.layout.OUILinearLayout, android.view.View
        public void setEnabled(boolean r10) {
            super.setEnabled(r10);
            if (r10 == false) goto L5;
            float r11 = 1.0f;
        L6:
            m(r11);
            return;
        L5:
            r11 = OTabLayoutBase.m(this.f17169v);
            goto L6
        }

        @Override // com.obric.oui.layout.OUILinearLayout, android.view.View
        public void setSelected(boolean r10) {
            isSelected();
            super.setSelected(r10);
            o(r10);
            TextView r11 = this.f17156i;
            if (r11 == null) goto L15;
            if (r10 == false) goto L8;
            float r12 = this.f17169v.f17145v;
            if (r12 <= 0.0f) goto L8;
            r11.setTextSize(0, r12);
        L9:
            TextView r13 = this.f17156i;
            OTabLayoutBase r14 = this.f17169v;
            if (r10 == false) goto L12;
            Typeface r15 = OTabLayoutBase.j(r14, OTabLayoutBase.h(r14), 500);
        L13:
            r13.setTypeface(r15);
            return;
        L12:
            r15 = OTabLayoutBase.h(r14);
        L8:
            r11.setTextSize(0, this.f17169v.f17143u);
            goto L9
        }

        public void setTab(@Nullable h r10) {
            if (r10 == this.f17155h) goto L6;
            this.f17155h = r10;
            l();
            return;
        }

        @Override // com.obric.oui.material.MaterialOwner, com.obric.oui.material.MaskMaterialOwner
        public void updateBackdropSrcType(int r10) {
            if (this.f17162o == true) goto L5;
            return;
        L5:
            OMaterialHelper.F(this, r10);
        }

        @Override // com.obric.oui.material.MaterialOwner, com.obric.oui.material.MaskMaterialOwner
        public void updateBackdropTargetType(boolean r10) {
            if (this.f17162o == true) goto L6;
            return;
        L6:
            if (this.f17166s == r10) goto L12;
            this.f17166s = r10;
            if (r10 == false) goto L10;
            OMaterialHelper.F(this, 2);
            return;
        L10:
            OMaterialHelper.F(this, 3);
            return;
        }
    }

    public class a implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f17170a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ OTabLayoutBase f17171b;

        public a(OTabLayoutBase r10, int r11) {
            this.f17171b = r10;
            this.f17170a = r11;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View r10, MotionEvent r11) {
            int r12 = r11.getAction();
            if (r12 != 0) goto L5;
            OTabLayoutBase.a(this.f17171b, this.f17170a);
            this.f17171b.postInvalidate();
            return false;
        L5:
            if (r12 != 1) goto L7;
        L9:
            OTabLayoutBase.a(this.f17171b, -1);
            this.f17171b.postInvalidate();
            return false;
        L7:
            if (r12 == 3) goto L9;
            return false;
        }
    }

    public class b implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OTabLayoutBase f17172a;

        public b(OTabLayoutBase r10) {
            this.f17172a = r10;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator r10) {
            this.f17172a.scrollTo(((Integer) r10.getAnimatedValue()).intValue(), 0);
        }
    }

    public class c implements ViewPager.OnAdapterChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f17173a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ OTabLayoutBase f17174b;

        public c(OTabLayoutBase r10) {
            this.f17174b = r10;
        }

        public void a(boolean r10) {
            this.f17173a = r10;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnAdapterChangeListener
        public void onAdapterChanged(ViewPager r10, PagerAdapter r11, PagerAdapter r12) {
            OTabLayoutBase r13 = this.f17174b;
            if (r13.L != r10) goto L6;
            r13.a0(r12, this.f17173a);
            return;
        }
    }

    public class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f17175a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f17176b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ OTabLayoutBase f17177c;

        public d(OTabLayoutBase r10) {
            this.f17177c = r10;
            this.f17175a = 0.0f;
            this.f17176b = 0.0f;
        }

        public String toString() {
            return "(left = " + this.f17175a + ", right = " + this.f17176b + ")";
        }
    }

    public class e extends DataSetObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OTabLayoutBase f17178a;

        public e(OTabLayoutBase r10) {
            this.f17178a = r10;
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            this.f17178a.U();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            this.f17178a.U();
        }
    }

    public class f implements TypeEvaluator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OTabLayoutBase f17179a;

        public f(OTabLayoutBase r10) {
            this.f17179a = r10;
        }

        public d a(float r10, d r11, d r12) {
            float r13 = r11.f17175a;
            float r14 = r13 + ((r12.f17175a - r13) * r10);
            float r15 = r11.f17176b;
            float r16 = r15 + (r10 * (r12.f17176b - r15));
            d r17 = new d(this.f17179a);
            r17.f17175a = r14;
            r17.f17176b = r16;
            return r17;
        }

        @Override // android.animation.TypeEvaluator
        public /* bridge */ /* synthetic */ Object evaluate(float r10, Object r11, Object r12) {
            return a(r10, (d) r11, (d) r12);
        }
    }

    public class g extends OUILinearLayout {
        public final float A;
        public boolean B;
        public final /* synthetic */ OTabLayoutBase C;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f17180h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final Paint f17181i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f17182j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public float f17183k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f17184l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f17185m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f17186n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public ValueAnimator f17187o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f17188p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f17189q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public float f17190r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public float f17191s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public boolean f17192t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public int f17193u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public boolean f17194v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public boolean f17195w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public boolean f17196x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public Paint f17197y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public Paint f17198z;

        public class a implements ValueAnimator.AnimatorUpdateListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f17199a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ int f17200b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ int f17201c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ int f17202d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final /* synthetic */ g f17203e;

            public a(g r10, int r11, int r12, int r13, int r14) {
                this.f17203e = r10;
                this.f17199a = r11;
                this.f17200b = r12;
                this.f17201c = r13;
                this.f17202d = r14;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator r10) {
                float r11 = r10.getAnimatedFraction();
                g r12 = this.f17203e;
                r12.h(r12.g(this.f17199a, this.f17200b, r11), this.f17203e.g(this.f17201c, this.f17202d, r11));
            }
        }

        public class b extends AnimatorListenerAdapter {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f17204a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ g f17205b;

            public b(g r10, int r11) {
                this.f17205b = r10;
                this.f17204a = r11;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator r10) {
                g r11 = this.f17205b;
                r11.f17182j = this.f17204a;
                r11.f17183k = 0.0f;
            }
        }

        public g(OTabLayoutBase r10, Context r11) {
            this.C = r10;
            super(r11);
            this.f17182j = -1;
            this.f17184l = -1;
            this.f17185m = -1;
            this.f17186n = -1;
            this.f17188p = r10.J(27);
            this.f17189q = Channel.UNLIMITED;
            setChangeAlphaWhenPress(false);
            setClipChildren(false);
            setClipToPadding(false);
            setWillNotDraw(false);
            this.f17181i = new Paint();
            this.A = r10.K(0.6f);
            setChangeAlphaWhenDisable(false);
        }

        public static /* synthetic */ float b(g r10, float r11) {
            r10.f17190r = r11;
            return r11;
        }

        public static /* synthetic */ float c(g r10, float r11) {
            r10.f17191s = r11;
            return r11;
        }

        public void d(int r10, int r11) {
            ValueAnimator r12 = this.f17187o;
            if (r12 == null) goto L8;
            if (r12.isRunning() == false) goto L8;
            this.f17187o.cancel();
        L8:
            if (ViewCompat.A(this) != 1) goto L10;
            boolean r13 = true;
        L11:
            View r14 = getChildAt(r10);
            if (r14 != null) goto L15;
            q();
            return;
        L15:
            int r15 = r14.getLeft();
            int r16 = r14.getRight();
            if (Math.abs(r10 - this.f17182j) > 1) goto L18;
            int r17 = this.f17185m;
            int r18 = this.f17186n;
        L26:
            if (r17 != r15) goto L28;
            if (r18 != r16) goto L28;
            return;
        L28:
            ValueAnimator r19 = new ValueAnimator();
            this.f17187o = r19;
            r19.setInterpolator(OTabLayoutBase.b());
            r19.setDuration(r11);
            r19.setFloatValues(new float[]{0.0f, 1.0f});
            r19.addUpdateListener(new a(this, r17, r15, r18, r16));
            r19.addListener(new b(this, r10));
            r19.start();
            return;
        L18:
            int r20 = this.C.J(24);
            if (r10 >= this.f17182j) goto L24;
            if (r13 == false) goto L23;
        L21:
            r17 = r15 - r20;
        L22:
            r18 = r17;
        L23:
            r17 = r20 + r16;
            goto L22
        L24:
            if (r13 == false) goto L21;
        L10:
            r13 = false;
            goto L11
        }

        @Override // com.obric.oui.layout.OUILinearLayout, android.view.View
        public void draw(Canvas r18) {
            super.draw(r18);
            if (this.f17194v == false) goto L6;
            r18.drawLine(getLeft(), getBottom() - this.C.K(0.6f), getRight() * 2, getBottom(), this.f17197y);
        L6:
            if (this.f17195w == false) goto L8;
            r18.drawLine(getLeft(), this.A + getTop(), getRight() * 2, this.A + getTop(), this.f17198z);
        L8:
            int r10 = this.f17185m;
            if (r10 >= 0) goto L11;
            return;
        L11:
            if (this.f17186n > r10) goto L13;
            return;
        L13:
            if (this.f17196x == false) goto L35;
            View r11 = getChildAt(this.C.getSelectedTabPosition());
            if (r11 == null) goto L26;
            View r12 = r11.findViewById(R$id.layout_tab_indicator);
            if (r12 == null) goto L26;
            if (this.C.L != null) goto L21;
        L22:
            int r13 = this.f17185m;
            float r14 = r13 + (((this.f17186n - r13) - r12.getWidth()) / 2);
            this.f17190r = r14;
            this.f17191s = r14 + r12.getWidth();
        L23:
            Path r15 = new Path();
            r15.addRoundRect(new RectF(((this.f17190r + this.f17191s) / 2.0f) - this.C.J(3), (getHeight() - getPaddingBottom()) - this.C.J(4), ((this.f17190r + this.f17191s) / 2.0f) + this.C.J(3), getHeight() - getPaddingBottom()), new float[]{this.C.J(3), this.C.J(3), this.C.J(3), this.C.J(3), this.C.J(1), this.C.J(1), this.C.J(1), this.C.J(1)}, Path.Direction.CCW);
            r18.drawPath(r15, this.f17181i);
            return;
        L21:
            if (this.f17192t == true) goto L23;
        L26:
            if (this.B == false) goto L28;
        L30:
            float r16 = this.f17185m;
            float r17 = this.f17186n;
        L31:
            Path r19 = new Path();
            float r20 = (r16 + r17) / 2.0f;
            r19.addRoundRect(new RectF(r20 - this.C.J(3), (getHeight() - getPaddingBottom()) - this.C.J(4), r20 + this.C.J(3), getHeight() - getPaddingBottom()), new float[]{this.C.J(3), this.C.J(3), this.C.J(3), this.C.J(3), this.C.J(1), this.C.J(1), this.C.J(1), this.C.J(1)}, Path.Direction.CCW);
            r18.drawPath(r19, this.f17181i);
            return;
        L28:
            if ((r11 instanceof TabView) == false) goto L30;
            float r21 = (this.f17185m + this.f17186n) * 0.5f;
            TabView r22 = (TabView) r11;
            r16 = r21 - (r22.getContentWidth() * 0.5f);
            r17 = r21 + (r22.getContentWidth() * 0.5f);
            goto L31
        }

        public boolean e() {
            int r10 = getChildCount();
            int r11 = 0;
        L3:
            if (r11 >= r10) goto L9;
            if (getChildAt(r11).getWidth() <= 0) goto L6;
            r11 = r11 + 1;
            goto L3
        L6:
            return true;
        L9:
            return false;
        }

        public float f() {
            return this.f17182j + this.f17183k;
        }

        public int g(int r10, int r11, float r12) {
            return r10 + Math.round(r12 * (r11 - r10));
        }

        public void h(int r10, int r11) {
            if (r10 == this.f17185m) goto L5;
        L6:
            this.f17185m = r10;
            this.f17186n = r11;
            ViewCompat.g0(this);
            return;
        L5:
            if (r11 != this.f17186n) goto L6;
        }

        public void i(int r10, float r11) {
            ValueAnimator r12 = this.f17187o;
            if (r12 != null) goto L5;
        L7:
            this.f17182j = r10;
            this.f17183k = r11;
            q();
            return;
        L5:
            if (r12.isRunning() == false) goto L7;
            this.f17187o.cancel();
            goto L7
        }

        public void j(int r10) {
            if (this.f17181i.getColor() == r10) goto L6;
            this.f17181i.setColor(r10);
            ViewCompat.g0(this);
            return;
        }

        public void k(boolean r10) {
            if (this.B == r10) goto L6;
            this.B = r10;
            ViewCompat.g0(this);
            return;
        }

        public void l(int r10) {
            if (this.f17180h == r10) goto L6;
            this.f17180h = r10;
            ViewCompat.g0(this);
            return;
        }

        public void m(int r10) {
            this.f17193u = r10;
        }

        public void n(boolean r10) {
            this.f17194v = r10;
            if (r10 == false) goto L6;
            Paint r11 = new Paint();
            this.f17197y = r11;
            r11.setColor(ContextCompat.b(getContext(), R$color.oui_line_2));
            this.f17197y.setStyle(Paint.Style.FILL);
            return;
        }

        public void o(boolean r10) {
            this.f17196x = r10;
        }

        @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
        public void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
            super.onLayout(r10, r11, r12, r13, r14);
            ValueAnimator r15 = this.f17187o;
            if (r15 != null) goto L5;
        L7:
            q();
            return;
        L5:
            if (r15.isRunning() == false) goto L7;
            this.f17187o.cancel();
            d(this.f17182j, Math.round((1.0f - this.f17187o.getAnimatedFraction()) * this.f17187o.getDuration()));
        }

        @Override // com.obric.oui.layout.OUILinearLayout, android.widget.LinearLayout, android.view.View
        public void onMeasure(int r11, int r12) {
            super.onMeasure(r11, r12);
            int r10 = getChildCount();
            int r13 = 0;
            boolean r14 = true;
            if (View.MeasureSpec.getMode(r11) == 1073741824) goto L25;
            OTabLayoutBase r15 = this.C;
            if (r15.E == 1) goto L7;
            return;
        L7:
            if (r15.D != 1) goto L116;
            int r16 = 0;
            int r17 = 0;
        L9:
            if (r16 >= r10) goto L14;
            View r18 = getChildAt(r16);
            if (r18.getVisibility() != 0) goto L13;
            r17 = Math.max(r17, r18.getMeasuredWidth());
            this.f17189q = Math.min(this.f17189q, r18.getMeasuredWidth());
        L13:
            r16 = r16 + 1;
            goto L9
        L14:
            int r19 = Math.min(this.C.f17151y, r17);
            boolean r20 = false;
        L15:
            if (r13 >= r10) goto L22;
            LinearLayout.LayoutParams r21 = (LinearLayout.LayoutParams) getChildAt(r13).getLayoutParams();
            if (r21.width == r19) goto L19;
        L20:
            r21.width = r19;
            r21.weight = 0.0f;
            r20 = true;
        L21:
            r13 = r13 + 1;
            goto L15
        L19:
            if (r21.weight == 0.0f) goto L21;
        L22:
            if (r20 == false) goto L117;
            super.onMeasure(r11, r12);
            return;
        L117:
            return;
        L116:
            return;
        L25:
            Drawable r22 = getDividerDrawable();
            if (r22 == null) goto L28;
            int r23 = r22.getIntrinsicWidth();
        L29:
            int r24 = 0;
            int r25 = 0;
        L30:
            if (r24 >= r10) goto L35;
            View r26 = getChildAt(r24);
            if (r26.getVisibility() != 0) goto L34;
            r25 = Math.max(r25, r26.getMeasuredWidth());
            this.f17189q = Math.min(this.f17189q, r26.getMeasuredWidth());
        L34:
            r24 = r24 + 1;
            goto L30
        L35:
            int r27 = (getPaddingLeft() + getPaddingRight()) + (r23 * (r10 - 1));
            OTabLayoutBase r28 = this.C;
            int r29 = r28.E;
            if (r29 == 1) goto L38;
        L55:
            if (r29 == 0) goto L57;
            return;
        L57:
            if (r28.G == true) goto L59;
            return;
        L59:
            if (OTabLayoutBase.n(r28) == getResources().getConfiguration().orientation) goto L61;
            return;
        L61:
            if (r25 > 0) goto L63;
            return;
        L63:
            int r30 = 0;
            int r31 = 0;
        L65:
            if (r30 >= r10) goto L70;
            View r32 = getChildAt(r30);
            if (r32.getVisibility() == 8) goto L69;
            r31 = r31 + r32.getMeasuredWidth();
        L69:
            r30 = r30 + 1;
            goto L65
        L70:
            if (r31 > 0) goto L72;
            return;
        L72:
            int r33 = getMeasuredWidth() - r27;
            if (r31 < r33) goto L75;
        L91:
            if (r13 == 0) goto L122;
            super.onMeasure(r11, r12);
            return;
        L122:
            return;
        L75:
            if ((r25 * r10) >= r33) goto L85;
            int r34 = 0;
            int r35 = 0;
        L77:
            if (r34 >= r10) goto L84;
            LinearLayout.LayoutParams r36 = (LinearLayout.LayoutParams) getChildAt(r34).getLayoutParams();
            if (r36.width == 0) goto L81;
        L82:
            r36.width = 0;
            r36.weight = 1.0f;
            r35 = 1;
        L83:
            r34 = r34 + 1;
            goto L77
        L81:
            if (r36.weight == 1.0f) goto L83;
        L84:
            r13 = r35;
            goto L91
        L85:
            int r37 = (r33 - r31) / (r10 * 2);
            r35 = 0;
        L86:
            if (r13 >= r10) goto L84;
            if (getChildAt(r13).getVisibility() == 8) goto L90;
            LinearLayout.LayoutParams r38 = (LinearLayout.LayoutParams) getChildAt(r13).getLayoutParams();
            r38.leftMargin = r37;
            r38.rightMargin = r37;
            r35 = 1;
        L90:
            r13 = r13 + 1;
            goto L86
        L38:
            if (r28.D != 1) goto L55;
            if (r25 > 0) goto L42;
            return;
        L42:
            if ((r25 * r10) > (getMeasuredWidth() - r27)) goto L52;
            boolean r39 = false;
        L44:
            if (r13 >= r10) goto L51;
            LinearLayout.LayoutParams r40 = (LinearLayout.LayoutParams) getChildAt(r13).getLayoutParams();
            if (r40.width == r25) goto L48;
        L49:
            r40.width = r25;
            r40.weight = 0.0f;
            r39 = true;
        L50:
            r13 = r13 + 1;
            goto L44
        L48:
            if (r40.weight == 0.0f) goto L50;
        L51:
            r14 = r39;
        L53:
            if (r14 == false) goto L118;
            super.onMeasure(r11, r12);
            return;
        L118:
            return;
        L52:
            OTabLayoutBase r41 = this.C;
            r41.D = 0;
            r41.k0(false);
            goto L53
        L28:
            r23 = 0;
            goto L29
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onRtlPropertiesChanged(int r10) {
            super.onRtlPropertiesChanged(r10);
        }

        public void p(boolean r10) {
            this.f17195w = r10;
            if (r10 == false) goto L6;
            Paint r11 = new Paint();
            this.f17198z = r11;
            r11.setColor(ContextCompat.b(getContext(), R$color.oui_line_2));
            this.f17198z.setStyle(Paint.Style.FILL);
            this.f17198z.setStrokeWidth(this.A);
            return;
        }

        public final void q() {
            View r10 = getChildAt(this.f17182j);
            if (r10 != null) goto L5;
        L11:
            int r11 = -1;
            int r12 = -1;
        L12:
            h(r11, r12);
            return;
        L5:
            if (r10.getWidth() <= 0) goto L11;
            r11 = r10.getLeft();
            r12 = r10.getRight();
            if (this.f17183k <= 0.0f) goto L12;
            if (this.f17182j >= (getChildCount() - 1)) goto L12;
            View r13 = getChildAt(this.f17182j + 1);
            float r14 = this.f17183k * r13.getLeft();
            float r15 = this.f17183k;
            r11 = (int) (r14 + ((1.0f - r15) * r11));
            r12 = (int) ((r15 * r13.getRight()) + ((1.0f - this.f17183k) * r12));
            goto L12
        }

        @Override // com.obric.oui.layout.OUILinearLayout, android.view.View
        public void setEnabled(boolean r10) {
            super.setEnabled(r10);
            int r11 = getChildCount();
            int r12 = 0;
        L3:
            if (r12 >= r11) goto L5;
            this.C.Q(r12).setEnabled(r10);
            r12 = r12 + 1;
            goto L3
        }
    }

    public static final class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f17206a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Drawable f17207b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public CharSequence f17208c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public CharSequence f17209d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f17210e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public View f17211f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public OTabLayoutBase f17212g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public TabView f17213h;

        public h() {
            this.f17210e = -1;
        }

        public CharSequence a() {
            return this.f17209d;
        }

        public View b() {
            return this.f17211f;
        }

        public Drawable c() {
            return this.f17207b;
        }

        public int d() {
            return this.f17210e;
        }

        public Object e() {
            return this.f17206a;
        }

        public CharSequence f() {
            return this.f17208c;
        }

        public TabView g() {
            return this.f17213h;
        }

        public boolean h() {
            OTabLayoutBase r10 = this.f17212g;
            if (r10 == null) goto L10;
            if (r10.getSelectedTabPosition() != this.f17210e) goto L7;
            return true;
        L7:
            return false;
        L10:
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        public void i() {
            this.f17212g = null;
            this.f17213h = null;
            this.f17206a = null;
            this.f17207b = null;
            this.f17208c = null;
            this.f17209d = null;
            this.f17210e = -1;
            this.f17211f = null;
        }

        public void j() {
            OTabLayoutBase r10 = this.f17212g;
            if (r10 == null) goto L7;
            r10.Y(this);
            return;
        L7:
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        public void k(View r10) {
            this.f17213h.setBackdropTarget(r10);
        }

        public h l(CharSequence r10) {
            this.f17209d = r10;
            v();
            return this;
        }

        public h m(int r10) {
            return n(LayoutInflater.from(this.f17213h.getContext()).inflate(r10, this.f17213h, false));
        }

        public h n(View r10) {
            this.f17211f = r10;
            v();
            return this;
        }

        public h o(Drawable r10) {
            this.f17207b = r10;
            v();
            return this;
        }

        public void p(int r10) {
            this.f17210e = r10;
        }

        public h q(Object r10) {
            this.f17206a = r10;
            return this;
        }

        public h r(CharSequence r10) {
            this.f17208c = r10;
            v();
            return this;
        }

        public void s(int r10) {
            this.f17213h.updateBackdropSrcType(r10);
        }

        public void t(boolean r10) {
            this.f17213h.updateBackdropTargetType(r10);
        }

        public void u(boolean r10) {
            this.f17213h.applyContentMaterial(r10);
        }

        public void v() {
            TabView r10 = this.f17213h;
            if (r10 == null) goto L6;
            r10.l();
            return;
        }
    }

    public static class i implements ViewPager.OnPageChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference f17214a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f17215b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f17216c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f17217d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f17218e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public ArgbEvaluator f17219f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public AccelerateInterpolator f17220g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public DecelerateInterpolator f17221h;

        public i(OTabLayoutBase r10) {
            this.f17219f = new ArgbEvaluator();
            this.f17220g = new AccelerateInterpolator();
            this.f17221h = new DecelerateInterpolator(1.6f);
            this.f17214a = new WeakReference(r10);
            this.f17218e = r10.getTabTextColors().getColorForState(OTabLayoutBase.c(), 0);
            this.f17217d = r10.getTabTextColors().getDefaultColor();
        }

        public final void a(ImageView r10, TextView r11, int r12) {
            if (r10 == null) goto L7;
            if (r11 == null) goto L8;
            r11.setTextColor(r12);
            r10.setImageAlpha(Color.alpha(r12));
            return;
        L8:
            return;
        }

        public void b() {
            this.f17215b = 0;
            this.f17216c = 0;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int r10) {
            this.f17215b = this.f17216c;
            this.f17216c = r10;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int r11, float r12, int r13) {
            OTabLayoutBase r14 = (OTabLayoutBase) this.f17214a.get();
            if (r14 == null) goto L34;
            int r10 = this.f17216c;
            if (r10 == 2) goto L7;
        L10:
            boolean r15 = true;
        L11:
            if (r10 == 2) goto L13;
        L16:
            boolean r16 = true;
        L17:
            r14.c0(r11, r12, r15, r16);
            if (this.f17216c == 2) goto L20;
        L22:
            OTabLayoutBase.d(r14).f17192t = true;
            View r17 = OTabLayoutBase.d(r14).getChildAt(OTabLayoutBase.d(r14).f17182j);
            View r18 = OTabLayoutBase.d(r14).getChildAt(OTabLayoutBase.d(r14).f17182j + 1);
            if (r17 == null) goto L30;
            if (r18 == null) goto L30;
            int r19 = R$id.layout_tab_indicator;
            View r20 = r17.findViewById(r19);
            View r21 = r18.findViewById(r19);
            if (r20 == null) goto L32;
            if (r21 == null) goto L32;
            float r110 = r17.getLeft() + ((r17.getWidth() - r20.getWidth()) / 2);
            float r22 = r20.getWidth() + r110;
            float r23 = r18.getLeft() + ((r18.getWidth() - r21.getWidth()) / 2);
            float r24 = r21.getWidth() + r23;
            int r25 = R$id.tab_item_img;
            ImageView r26 = (ImageView) r20.findViewById(r25);
            int r27 = R$id.tab_item_text;
            TextView r28 = (TextView) r20.findViewById(r27);
            ImageView r29 = (ImageView) r21.findViewById(r25);
            TextView r30 = (TextView) r21.findViewById(r27);
            a(r26, r28, ((Integer) this.f17219f.evaluate(r12, Integer.valueOf(this.f17218e), Integer.valueOf(this.f17217d))).intValue());
            a(r29, r30, ((Integer) this.f17219f.evaluate(r12, Integer.valueOf(this.f17217d), Integer.valueOf(this.f17218e))).intValue());
            g.b(OTabLayoutBase.d(r14), r110 + ((r23 - r110) * this.f17220g.getInterpolation(r12)));
            g.c(OTabLayoutBase.d(r14), r22 + ((r24 - r22) * this.f17220g.getInterpolation(r12)));
        L32:
            ViewCompat.g0(OTabLayoutBase.d(r14));
            return;
        L30:
            if (OTabLayoutBase.e(r14) == false) goto L32;
            OTabLayoutBase.d(r14).f17192t = false;
            goto L32
        L20:
            if (this.f17215b != 0) goto L22;
            OTabLayoutBase.d(r14).f17192t = false;
            goto L32
        L13:
            if (this.f17215b != 0) goto L16;
            r16 = false;
            goto L17
        L7:
            if (this.f17215b == 1) goto L10;
            r15 = false;
            goto L11
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int r10) {
            OTabLayoutBase r11 = (OTabLayoutBase) this.f17214a.get();
            if (r11 != null) goto L5;
            return;
        L5:
            if (r11.getSelectedTabPosition() != r10) goto L7;
            return;
        L7:
            if (r10 >= r11.getTabCount()) goto L21;
            int r12 = this.f17216c;
            if (r12 != 0) goto L11;
        L16:
            boolean r13 = true;
        L17:
            r11.Z(r11.P(r10), r13);
            return;
        L11:
            if (r12 == 2) goto L13;
        L15:
            r13 = false;
            goto L17
        L13:
            if (this.f17215b != 0) goto L15;
        }
    }

    public static class j implements OnTabSelectedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ViewPager f17222a;

        public j(ViewPager r10) {
            this.f17222a = r10;
        }

        @Override // com.obric.oui.tab.OTabLayoutBase.OnTabSelectedListener
        public void onTabReselected(h r10) {
        }

        @Override // com.obric.oui.tab.OTabLayoutBase.OnTabSelectedListener
        public void onTabSelected(h r10) {
            this.f17222a.setCurrentItem(r10.d());
        }

        @Override // com.obric.oui.tab.OTabLayoutBase.OnTabSelectedListener
        public void onTabUnselected(h r10) {
        }
    }

    static {
        M0 = new x.b();
        N0 = new Pools$SynchronizedPool(16);
        O0 = new int[]{R$attr.colorPrimary};
    }

    public OTabLayoutBase(Context r10) {
        this(r10, null);
    }

    public static ColorStateList C(int r10, int r11) {
        return new ColorStateList(new int[][]{HorizontalScrollView.SELECTED_STATE_SET, HorizontalScrollView.EMPTY_STATE_SET}, new int[]{r11, r10});
    }

    public static ColorStateList E(int r10, int r11, int r12) {
        return new ColorStateList(new int[][]{new int[]{R.attr.state_pressed, R.attr.state_selected}, new int[]{R.attr.state_pressed}, HorizontalScrollView.SELECTED_STATE_SET, HorizontalScrollView.EMPTY_STATE_SET}, new int[]{androidx.core.graphics.d.g(r12, r11), androidx.core.graphics.d.g(r12, r10), r11, r10});
    }

    private boolean S() {
        int r10 = this.f17139s.getDefaultColor();
        if (r10 != 0) goto L7;
        return R();
    L7:
        return !i0.c(r10);
    }

    public static /* synthetic */ int a(OTabLayoutBase r10, int r11) {
        r10.F0 = r11;
        return r11;
    }

    public static /* synthetic */ Interpolator b() {
        return M0;
    }

    public static /* synthetic */ int[] c() {
        return HorizontalScrollView.SELECTED_STATE_SET;
    }

    public static /* synthetic */ g d(OTabLayoutBase r10) {
        return r10.f17115g;
    }

    public static /* synthetic */ boolean e(OTabLayoutBase r10) {
        return r10.T;
    }

    public static /* synthetic */ List f(OTabLayoutBase r10) {
        return r10.f17144u0;
    }

    public static /* synthetic */ OnTabClickListener g(OTabLayoutBase r10) {
        return r10.H0;
    }

    private int getDefaultHeight() {
        int r10 = this.f17103a.size();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L14;
        h r12 = (h) this.f17103a.get(r11);
        if (r12 == null) goto L13;
        if (r12.c() == null) goto L11;
        if (TextUtils.isEmpty(r12.f()) == true) goto L11;
        return 56;
    L11:
        if (r12.b() == null) goto L13;
        return 56;
    L13:
        r11 = r11 + 1;
        goto L3
    L14:
        return 56;
    }

    private float getScrollPosition() {
        return this.f17115g.f();
    }

    private int getTabMinWidth() {
        int r10 = this.f17153z;
        if (r10 == (-1)) goto L6;
        return r10;
    L6:
        if (this.E == 0) goto L10;
        return 0;
    L10:
        return this.B;
    }

    private int getTabScrollRange() {
        return Math.max(0, ((this.f17115g.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    public static /* synthetic */ Typeface h(OTabLayoutBase r10) {
        return r10.K0;
    }

    public static /* synthetic */ Typeface i(OTabLayoutBase r10, Typeface r11) {
        r10.K0 = r11;
        return r11;
    }

    public static /* synthetic */ Typeface j(OTabLayoutBase r10, Typeface r11, int r12) {
        return r10.O(r11, r12);
    }

    public static /* synthetic */ int k(OTabLayoutBase r10) {
        return r10.f17123k;
    }

    public static /* synthetic */ int l(OTabLayoutBase r10) {
        return r10.f17121j;
    }

    public static /* synthetic */ float m(OTabLayoutBase r10) {
        return r10.f17117h;
    }

    public static /* synthetic */ int n(OTabLayoutBase r10) {
        return r10.J0;
    }

    private void setSelectedTabView(int r10) {
        int r11 = this.f17115g.getChildCount();
        if (r10 >= r11) goto L11;
        int r12 = 0;
    L5:
        if (r12 >= r11) goto L15;
        View r13 = this.f17115g.getChildAt(r12);
        if (r12 != r10) goto L9;
        boolean r14 = true;
    L10:
        r13.setSelected(r14);
        r12 = r12 + 1;
        goto L5
    L9:
        r14 = false;
        goto L10
    L15:
        return;
    }

    private void x() {
        View r10 = Q(getSelectedTabPosition());
        if (r10 == null) goto L6;
        Rect r11 = this.f17148w0;
        r11.left = r10.getLeft();
        Rect r12 = this.f17148w0;
        r12.right = r10.getRight();
        return;
    }

    public final float A(float r10) {
        return Math.max(0.0f, Math.min(1.0f, r10));
    }

    public final void B(h r10, int r11) {
        r10.p(r11);
        this.f17103a.add(r11, r10);
        int r12 = this.f17103a.size();
    L3:
        r11 = r11 + 1;
        if (r11 >= r12) goto L6;
        ((h) this.f17103a.get(r11)).p(r11);
        goto L3
    }

    public final LinearLayout.LayoutParams D() {
        LinearLayout.LayoutParams r10 = new LinearLayout.LayoutParams(-2, -1);
        j0(r10);
        return r10;
    }

    public final TabView F() {
        Pools$Pool r10 = this.I0;
        if (r10 == null) goto L5;
        TabView r11 = (TabView) r10.acquire();
    L6:
        if (r11 != null) goto L17;
        r11 = new TabView(this, getContext(), this.f17134p0, this.f17138r0, this.f17142t0);
        WeakReference r12 = this.f17111e;
        if (r12 != null) goto L10;
    L12:
        Drawable r13 = this.W;
        if (r13 == null) goto L19;
        if (this.f17134p0 == true) goto L19;
        r11.setBackground(r13.mutate());
        r11.setOutlineProvider(ViewOutlineProvider.BACKGROUND);
    L19:
        if (isEnabled() == false) goto L21;
        float r14 = 1.0f;
    L22:
        TabView.b(r11, r14);
        r11.setFocusable(true);
        return r11;
    L21:
        r14 = this.f17117h;
        goto L22
    L10:
        if (r12.get() == null) goto L12;
        r11.setBackdropTarget((View) this.f17111e.get());
        goto L12
    L17:
        r11.n(this.f17134p0);
        r11.p(this.f17138r0, this.f17142t0);
        goto L19
    L5:
        r11 = null;
        goto L6
    }

    public final void G(h r10) {
        int r11 = this.I.size() - 1;
    L3:
        if (r11 < 0) goto L5;
        ((OnTabSelectedListener) this.I.get(r11)).onTabReselected(r10);
        r11 = r11 - 1;
        goto L3
    }

    public final void H(h r10) {
        int r11 = this.I.size() - 1;
    L3:
        if (r11 < 0) goto L5;
        ((OnTabSelectedListener) this.I.get(r11)).onTabSelected(r10);
        r11 = r11 - 1;
        goto L3
    }

    public final void I(h r10) {
        int r11 = this.I.size() - 1;
    L3:
        if (r11 < 0) goto L5;
        ((OnTabSelectedListener) this.I.get(r11)).onTabUnselected(r10);
        r11 = r11 - 1;
        goto L3
    }

    public int J(int r10) {
        return (int) ((getResources().getDisplayMetrics().density * r10) + 0.5f);
    }

    public float K(float r10) {
        return (getResources().getDisplayMetrics().density * r10) + 0.5f;
    }

    public final void L(Canvas r12, float r13) {
        int r10 = getHeight();
        int r11 = getPaddingLeft();
        int r14 = getPaddingTop();
        int r15 = getPaddingBottom();
        if (this.f17104a0 >= 0.0f) goto L5;
        this.f17104a0 = r10 - (this.f17106b0 * 2.0f);
    L5:
        float r16 = this.f17108c0;
        if (r16 >= 0.0f) goto L8;
    L9:
        this.f17108c0 = this.f17104a0;
    L10:
        float r17 = this.f17108c0 + (this.f17106b0 / 2.0f);
        float r18 = getWidth() + r13;
        if (this.f17109d == true) goto L16;
        int r19 = this.f17124k0;
        if (r19 == 0) goto L16;
        this.f17110d0.setColor(r19);
        this.f17116g0.set(r13, r14, r18, r10 - r15);
        r12.drawRoundRect(this.f17116g0, r17, r17, this.f17110d0);
    L16:
        if (this.f17114f0.getColor() == 0) goto L18;
        this.f17116g0.set(r13, r14, r18, r10 - r15);
        r12.drawRoundRect(this.f17116g0, r17, r17, this.f17114f0);
    L18:
        int r20 = 0;
        if (this.f17126l0 == true) goto L21;
        x();
    L24:
        int r21 = this.U;
        if (r21 == 0) goto L28;
        this.f17152y0.setColor(r21);
        Rect r22 = this.f17148w0;
        float r23 = (r22.left + r11) + r13;
        float r24 = this.f17106b0;
        l.h(r12, r23, r24, (r22.right + r11) + r13, r24 + this.f17104a0, this.f17108c0, this.f17152y0);
    L28:
        if (this.V != 0) goto L30;
        return;
    L30:
        if (this.f17124k0 == 0) goto L32;
        return;
    L32:
        if (r20 >= getTabCount()) goto L42;
        if (r20 == getSelectedTabPosition()) goto L36;
        View r25 = Q(r20);
        this.f17152y0.setColor(this.V);
        l.h(r12, (r25.getLeft() + r11) + r13, this.f17106b0, (r25.getRight() + r11) + r13, this.f17106b0 + this.f17104a0, this.f17108c0, this.f17152y0);
    L36:
        r20 = r20 + 1;
        goto L32
    L42:
        return;
    L21:
        if (this.f17146v0 == false) goto L24;
        this.f17146v0 = false;
        x();
        goto L24
    L8:
        if (r16 <= (this.f17104a0 / 2.0f)) goto L10;
        goto L9
    }

    public final void M(Canvas r10) {
        if (isInEditMode() == false) goto L5;
    L7:
        super.dispatchDraw(r10);
        return;
    L5:
        if (getTabCount() <= 0) goto L7;
        L(r10, getBounceTranslation());
        goto L7
    }

    public final void N() {
        if (this.K != null) goto L6;
        ValueAnimator r10 = new ValueAnimator();
        this.K = r10;
        r10.setInterpolator(M0);
        this.K.setDuration(200);
        this.K.addUpdateListener(new b(this));
        return;
    }

    public final Typeface O(Typeface r10, int r11) {
        if (this.L0 != null) goto L6;
        this.L0 = Typeface.create(r10, r11, false);
    L6:
        return this.L0;
    }

    public h P(int r10) {
        if (r10 >= 0) goto L4;
    L7:
        return null;
    L4:
        if (r10 >= getTabCount()) goto L7;
        return (h) this.f17103a.get(r10);
    }

    public View Q(int r10) {
        return this.f17115g.getChildAt(r10);
    }

    public final boolean R() {
        if ((getResources().getConfiguration().uiMode & 48) != 32) goto L5;
        return true;
    L5:
        return false;
    }

    public h T(int r10) {
        h r11 = (h) N0.acquire();
        if (r11 != null) goto L5;
        r11 = new h();
    L5:
        r11.f17212g = this;
        TabView r12 = F();
        r11.f17213h = r12;
        if (r10 <= 0) goto L8;
        r12.k(r11, false);
        r11.m(r10);
    L9:
        return r11;
    L8:
        r12.setTab(r11);
        goto L9
    }

    public void U() {
        V();
        PagerAdapter r10 = this.M;
        if (r10 == null) goto L17;
        int r11 = r10.getCount();
        int r12 = 0;
    L5:
        if (r12 >= r11) goto L7;
        q(T(this.F).r(this.M.getPageTitle(r12)), false);
        r12 = r12 + 1;
        goto L5
    L7:
        ViewPager r13 = this.L;
        if (r13 == null) goto L18;
        if (r11 <= 0) goto L19;
        int r14 = r13.getCurrentItem();
        if (r14 != getSelectedTabPosition()) goto L13;
        return;
    L13:
        if (r14 >= getTabCount()) goto L21;
        Y(P(r14));
        return;
    L21:
        return;
    L19:
        return;
    L18:
        return;
    }

    public void V() {
        int r10 = this.f17115g.getChildCount() - 1;
    L3:
        if (r10 < 0) goto L5;
        W(r10);
        r10 = r10 - 1;
        goto L3
    L5:
        Iterator r11 = this.f17103a.iterator();
    L7:
        if (r11.hasNext() == false) goto L9;
        h r12 = (h) r11.next();
        r11.remove();
        r12.i();
        N0.release(r12);
        goto L7
    L9:
        this.f17105b = null;
    }

    public final void W(int r10) {
        TabView r11 = (TabView) this.f17115g.getChildAt(r10);
        this.f17115g.removeViewAt(r10);
        if (r11 == null) goto L5;
        r11.h();
        this.I0.release(r11);
    L5:
        requestLayout();
    }

    public void X(int r10) {
        if (r10 < this.f17103a.size()) goto L5;
        return;
    L5:
        if (this.f17103a.isEmpty() == true) goto L13;
        h r11 = (h) this.f17103a.get(r10);
        if (r11 == null) goto L12;
        Y(r11);
        return;
    L12:
        return;
    }

    public void Y(h r10) {
        Z(r10, true);
    }

    public void Z(h r10, boolean r11) {
        h r12 = this.f17105b;
        if (r12 != r10) goto L7;
        if (r12 == null) goto L30;
        G(r10);
        v(r10.d());
        return;
    L30:
        return;
    L7:
        if (r10 == null) goto L9;
        int r13 = r10.d();
    L10:
        if (r11 == false) goto L19;
        if (r12 != null) goto L13;
    L14:
        if (r13 == (-1)) goto L16;
        b0(r13, 0.0f, true);
    L17:
        if (r13 == (-1)) goto L19;
        setSelectedTabView(r13);
    L16:
        v(r13);
        goto L17
    L13:
        if (r12.d() != (-1)) goto L16;
    L19:
        if (r12 == null) goto L21;
        I(r12);
    L21:
        h r14 = this.f17105b;
        if (r14 != null) goto L24;
        r14 = r10;
    L24:
        this.f17107c = r14;
        this.f17105b = r10;
        if (this.f17126l0 == false) goto L27;
        y();
    L27:
        if (r10 == null) goto L32;
        H(r10);
        return;
    L32:
        return;
    L9:
        r13 = -1;
        goto L10
    }

    public void a0(PagerAdapter r10, boolean r11) {
        PagerAdapter r12 = this.M;
        if (r12 == null) goto L7;
        DataSetObserver r13 = this.N;
        if (r13 == null) goto L7;
        r12.unregisterDataSetObserver(r13);
    L7:
        this.M = r10;
        if (r11 == false) goto L14;
        if (r10 == null) goto L14;
        if (this.N != null) goto L13;
        this.N = new e(this);
    L13:
        r10.registerDataSetObserver(this.N);
    L14:
        U();
    }

    public void addOnTabSelectedListener(@NonNull OnTabSelectedListener r10) {
        if (this.I.contains(r10) == true) goto L6;
        this.I.add(r10);
        return;
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View r10) {
        u(r10);
    }

    @Override // com.obric.oui.material.MaterialOwner
    public void applyContentMaterial(boolean r10) {
        if (this.f17134p0 == false) goto L7;
        int r11 = this.f17103a.size();
        int r12 = 0;
    L5:
        if (r12 >= r11) goto L9;
        ((h) this.f17103a.get(r12)).u(r10);
        r12 = r12 + 1;
        goto L5
    L9:
        return;
    }

    public void b0(int r10, float r11, boolean r12) {
        c0(r10, r11, r12, true);
    }

    public void c0(int r10, float r11, boolean r12, boolean r13) {
        int r14 = Math.round(r10 + r11);
        if (r14 >= 0) goto L5;
        return;
    L5:
        if (r14 >= this.f17115g.getChildCount()) goto L20;
        if (r13 == false) goto L9;
        this.f17115g.i(r10, r11);
    L9:
        ValueAnimator r15 = this.K;
        if (r15 != null) goto L12;
    L14:
        scrollTo(z(r10, r11), 0);
        if (r12 == false) goto L19;
        setSelectedTabView(r14);
        return;
    L19:
        return;
    L12:
        if (r15.isRunning() == false) goto L14;
        this.K.cancel();
        goto L14
    }

    public void d0(int r10, int r11) {
        this.f17121j = J(r10);
        if (this.f17145v <= J(20)) goto L6;
        this.f17123k = J(r11);
        return;
    }

    @Override // com.obric.oui.bouncelayout.OHorizontalScrollView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas r14) {
        float r10 = getBounceTranslation();
        float r11 = tc.f.h(0.5f, getContext());
        boolean r12 = false;
        if (r10 >= (-r11)) goto L5;
        boolean r13 = true;
    L7:
        if (r10 <= r11) goto L9;
        boolean r15 = true;
    L11:
        if (canScrollHorizontally(-1) == true) goto L15;
        if (r13 == true) goto L15;
        boolean r16 = false;
    L17:
        if (canScrollHorizontally(1) == true) goto L19;
        if (r15 == true) goto L19;
    L21:
        if (this.f17154z0.g(getWidth(), getHeight(), r16, r12) == false) goto L32;
        float r17 = getScrollX();
        float r18 = getTabStripLeftPadding();
        float r19 = getTabStripRightPadding();
        nd.b.a(this.f17115g, r17, getWidth(), getHeight(), r16, r12, this.f17120i0, this.f17122j0);
        RectF r20 = this.f17120i0;
        int r21 = r14.saveLayer(r20.left, r20.top, r20.right, r20.bottom, null);
        M(r14);
        nd.a r22 = this.f17154z0;
        RectF r110 = this.f17122j0;
        float r23 = r110.left;
        if (r16 == true) goto L26;
        r18 = 0.0f;
    L26:
        float r24 = r18 + r23;
        float r25 = r110.top;
        float r26 = r110.right;
        if (r12 == true) goto L30;
        r19 = 0.0f;
    L30:
        r22.a(r14, r24, r25, r26 - r19, r110.bottom, r16, r12);
        r14.restoreToCount(r21);
        return;
    L32:
        M(r14);
        return;
    L19:
        r12 = true;
    L15:
        r16 = true;
        goto L17
    L9:
        r15 = false;
        goto L11
    L5:
        r13 = false;
        goto L7
    }

    public void e0(int r10, int r11, int r12, int r13) {
        this.f17115g.setPadding(r10, r11, r12, r13);
    }

    public void f0(ViewPager r10, boolean r11) {
        g0(r10, r11, false);
    }

    public final void g0(ViewPager r10, boolean r11, boolean r12) {
        ViewPager r13 = this.L;
        if (r13 == null) goto L10;
        i r14 = this.O;
        if (r14 == null) goto L7;
        r13.removeOnPageChangeListener(r14);
    L7:
        c r15 = this.P;
        if (r15 == null) goto L10;
        this.L.removeOnAdapterChangeListener(r15);
    L10:
        OnTabSelectedListener r16 = this.f17102J;
        if (r16 == null) goto L13;
        removeOnTabSelectedListener(r16);
        this.f17102J = null;
    L13:
        if (r10 == null) goto L24;
        this.L = r10;
        if (this.O != null) goto L17;
        this.O = new i(this);
    L17:
        this.O.b();
        r10.addOnPageChangeListener(this.O);
        j r17 = new j(r10);
        this.f17102J = r17;
        addOnTabSelectedListener(r17);
        PagerAdapter r18 = r10.getAdapter();
        if (r18 == null) goto L21;
        a0(r18, r11);
    L21:
        if (this.P != null) goto L23;
        this.P = new c(this);
    L23:
        this.P.a(r11);
        r10.addOnAdapterChangeListener(this.P);
        b0(r10.getCurrentItem(), 0.0f, true);
    L25:
        this.Q = r12;
        return;
    L24:
        this.L = null;
        a0(null, false);
        goto L25
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet r10) {
        return generateLayoutParams(r10);
    }

    public float getEdgeFadeLength() {
        return this.f17154z0.c();
    }

    public float getIndicatorCornerRadius() {
        return this.f17108c0;
    }

    public int getSelectedTabPosition() {
        h r10 = this.f17105b;
        if (r10 != null) goto L7;
        return -1;
    L7:
        return r10.d();
    }

    public ViewGroup getTabContainer() {
        return this.f17115g;
    }

    public int getTabCount() {
        return this.f17103a.size();
    }

    public float getTabDisabledAlpha() {
        return this.f17117h;
    }

    public int getTabGravity() {
        return this.D;
    }

    public int getTabMaxWidth() {
        return this.f17149x;
    }

    public int getTabMode() {
        return this.E;
    }

    public int getTabStripLeftPadding() {
        return this.f17115g.getPaddingLeft();
    }

    public int getTabStripRightPadding() {
        return this.f17115g.getPaddingRight();
    }

    @Nullable
    public ColorStateList getTabTextColors() {
        return this.f17139s;
    }

    public final void h0() {
        int r10 = this.f17103a.size();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L5;
        ((h) this.f17103a.get(r11)).v();
        r11 = r11 + 1;
        goto L3
    }

    public final void i0() {
        if (this.f17126l0 == false) goto L5;
        this.f17115g.setShadowStyle(this.f17113f);
        this.f17115g.setShadowCornerRadius((int) this.f17108c0);
        return;
    L5:
        this.f17115g.setShadowStyle(R$style.OUIShadow_None);
    }

    public final void j0(LinearLayout.LayoutParams r10) {
        if (this.E == 1) goto L5;
    L7:
        r10.width = -2;
        r10.weight = 0.0f;
    L8:
        int r11 = this.f17119i;
        if (r11 == 0) goto L12;
        r10.leftMargin = r11;
        r10.rightMargin = r11;
        return;
    L12:
        return;
    L5:
        if (this.D != 0) goto L7;
        r10.width = 0;
        r10.weight = 1.0f;
        goto L8
    }

    public void k0(boolean r10) {
        int r11 = 0;
    L4:
        if (r11 >= this.f17115g.getChildCount()) goto L9;
        View r12 = this.f17115g.getChildAt(r11);
        j0((LinearLayout.LayoutParams) r12.getLayoutParams());
        if (r10 == false) goto L8;
        r12.requestLayout();
    L8:
        r11 = r11 + 1;
        goto L4
    }

    public void o(h r10) {
        q(r10, this.f17103a.isEmpty());
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator r10) {
        d r11 = (d) r10.getAnimatedValue();
        Rect r12 = this.f17148w0;
        r12.left = (int) r11.f17175a;
        r12.right = (int) r11.f17176b;
        invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.L != null) goto L8;
        ViewParent r10 = getParent();
        if ((r10 instanceof ViewPager) == false) goto L9;
        g0((ViewPager) r10, true, true);
        return;
    L9:
        return;
    }

    @Override // com.obric.oui.bouncelayout.OHorizontalScrollView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.Q == false) goto L6;
        setupWithViewPager(null);
        this.Q = false;
        return;
    }

    @Override // android.view.View
    public void onDraw(Canvas r10) {
        super.onDraw(r10);
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int r10, int r11) {
        int r12 = (J(getDefaultHeight()) + getPaddingTop()) + getPaddingBottom();
        int r13 = getMinimumHeight();
        if (r13 <= 0) goto L5;
        r12 = r13;
    L5:
        int r14 = View.MeasureSpec.getMode(r11);
        if (r14 == Integer.MIN_VALUE) goto L10;
        if (r14 == 0) goto L9;
        int r15 = View.MeasureSpec.makeMeasureSpec(Math.max(r12, View.MeasureSpec.getSize(r11)), Ints.MAX_POWER_OF_TWO);
    L11:
        int r16 = View.MeasureSpec.getSize(r10);
        if (View.MeasureSpec.getMode(r10) == 0) goto L18;
        int r17 = this.A;
        if (r17 > 0) goto L17;
        r17 = r16 - J(56);
    L17:
        this.f17149x = r17;
    L18:
        super.onMeasure(r10, r15);
        if (getChildCount() != 1) goto L31;
        View r18 = getChildAt(0);
        int r19 = this.E;
        if (r19 == 0) goto L28;
        if (r19 == 1) goto L25;
        return;
    L25:
        if (r18.getMeasuredWidth() == getMeasuredWidth()) goto L32;
    L29:
        int r20 = HorizontalScrollView.getChildMeasureSpec(r15, getPaddingTop() + getPaddingBottom(), r18.getLayoutParams().height);
        r18.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), Ints.MAX_POWER_OF_TWO), r20);
        return;
    L32:
        return;
    L28:
        if (r18.getMeasuredWidth() < getMeasuredWidth()) goto L29;
        return;
    L31:
        return;
    L9:
        r15 = View.MeasureSpec.makeMeasureSpec(r12, Ints.MAX_POWER_OF_TWO);
        goto L11
    L10:
        r15 = View.MeasureSpec.makeMeasureSpec(Math.min(r12, View.MeasureSpec.getSize(r11)), Ints.MAX_POWER_OF_TWO);
        goto L11
    }

    public void p(h r10, int r11, boolean r12) {
        if (r10.f17212g != this) goto L9;
        B(r10, r11);
        t(r10);
        r10.g().setOnTouchListener(new a(this, r11));
        if (r12 == false) goto L10;
        r10.j();
        return;
    L10:
        return;
    L9:
        throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
    }

    public void q(h r10, boolean r11) {
        p(r10, this.f17103a.size(), r11);
    }

    public final void r(OBottomTabItem r10) {
        OBottomTabItemCustomView r11 = new OBottomTabItemCustomView(getContext());
        h r12 = T(0);
        if (r10.getText() == null) goto L6;
        r11.getTitle().setText(r10.getText());
        r12.r(r10.getText());
    L6:
        if (r10.getIcon() == null) goto L8;
        r11.getIcon().setImageDrawable(r10.getIcon());
    L8:
        r11.setTextColor(this.f17139s);
        r11.setSelectedBgColor(Integer.valueOf(ContextCompat.b(getContext(), R$color.oui_accent_bg_light)));
        r12.n(r11);
        o(r12);
    }

    public void removeOnTabSelectedListener(@NonNull OnTabSelectedListener r10) {
        this.I.remove(r10);
    }

    public final void s(OTabItem r10) {
        h r11 = T(0);
        CharSequence r12 = r10.f17099a;
        if (r12 == null) goto L5;
        r11.r(r12);
    L5:
        Drawable r13 = r10.f17100b;
        if (r13 == null) goto L8;
        r11.o(r13);
    L8:
        int r14 = r10.f17101c;
        if (r14 == 0) goto L12;
        r11.m(r14);
    L12:
        if (TextUtils.isEmpty(r10.getContentDescription()) == true) goto L14;
        r11.l(r10.getContentDescription());
    L14:
        o(r11);
    }

    public void setAutoFillWhenScrollable(boolean r10) {
        this.G = r10;
    }

    @Override // com.obric.oui.material.MaterialOwner, com.obric.oui.material.MaskMaterialOwner
    public void setBackdropTarget(@Nullable View r10) {
        if (r10 != null) goto L4;
        this.f17111e = new WeakReference(this);
    L5:
        View r11 = (View) this.f17111e.get();
        if (r11 == null) goto L15;
        if (r10 != null) goto L9;
        OMaterialHelper.I(this, null);
    L11:
        if (this.f17134p0 == false) goto L17;
        int r12 = this.f17103a.size();
        int r13 = 0;
    L13:
        if (r13 >= r12) goto L18;
        ((h) this.f17103a.get(r13)).k(r11);
        r13 = r13 + 1;
        goto L13
    L18:
        return;
    L17:
        return;
    L9:
        OMaterialHelper.I(this, r11);
        goto L11
    L15:
        return;
    L4:
        this.f17111e = new WeakReference(r10);
        goto L5
    }

    public void setContentInsetStart(int r10) {
        this.C = r10;
    }

    public void setCustomTabViewResId(int r10) {
        this.F = r10;
    }

    public void setEdgeFadeEnabled(boolean r10) {
        if (this.f17154z0.e(r10) == false) goto L6;
        invalidate();
        return;
    }

    public void setEdgeFadeLength(float r10) {
        if (this.f17154z0.f(r10) == false) goto L6;
        invalidate();
        return;
    }

    @Override // android.view.View
    public void setEnabled(boolean r10) {
        super.setEnabled(r10);
        this.f17115g.setEnabled(r10);
    }

    public void setIndicatorAnimEnable(boolean r10) {
        this.f17126l0 = r10;
        invalidate();
    }

    public void setIndicatorBounceEnable(boolean r10) {
        this.f17128m0 = r10;
    }

    public void setIndicatorCornerRadius(float r10) {
        this.f17108c0 = r10;
        invalidate();
    }

    public void setOnTabClickListener(OnTabClickListener r10) {
        this.H0 = r10;
    }

    @Deprecated
    public void setOnTabSelectedListener(@Nullable OnTabSelectedListener r10) {
        OnTabSelectedListener r11 = this.H;
        if (r11 == null) goto L5;
        removeOnTabSelectedListener(r11);
    L5:
        this.H = r10;
        if (r10 == null) goto L9;
        addOnTabSelectedListener(r10);
        return;
    }

    public void setScrollAnimatorListener(Animator.AnimatorListener r10) {
        N();
        this.K.addListener(r10);
    }

    public void setSelectedTabHorizontalPadding(int r10) {
        this.f17115g.m(r10);
    }

    public void setSelectedTabIndicatorColor(@ColorInt int r10) {
        this.f17115g.j(r10);
    }

    public void setSelectedTabIndicatorHeight(int r10) {
        this.f17115g.l(r10);
    }

    public void setShowSelectedIndicator(Boolean r10) {
        this.f17115g.o(r10.booleanValue());
    }

    public void setShowTopLine(Boolean r10) {
        this.f17115g.p(r10.booleanValue());
    }

    public void setTabBackgroundResId(int r10) {
        this.f17147w = r10;
    }

    public void setTabDisabledAlpha(float r10) {
        this.f17117h = A(r10);
    }

    public void setTabGravity(int r10) {
        if (this.D == r10) goto L6;
        this.D = r10;
        w();
        return;
    }

    public void setTabMargin(int r10) {
        this.f17119i = J(r10);
        int r11 = 0;
    L4:
        if (r11 >= getTabCount()) goto L6;
        View r12 = this.f17115g.getChildAt(r11);
        ViewGroup.MarginLayoutParams r13 = (ViewGroup.MarginLayoutParams) r12.getLayoutParams();
        r13.leftMargin = J(r10);
        r13.rightMargin = J(r10);
        r12.setLayoutParams(r13);
        r11 = r11 + 1;
        goto L4
    }

    public void setTabMaxWidth(int r10) {
        this.A = r10;
        this.f17151y = r10;
    }

    public void setTabMinWidth(int r10) {
        this.f17153z = r10;
    }

    public void setTabMode(int r10) {
        if (r10 == this.E) goto L6;
        this.E = r10;
        w();
        return;
    }

    public void setTabPaddingBottom(int r10) {
        this.f17133p = r10;
    }

    public void setTabPaddingEnd(int r10) {
        this.f17131o = r10;
    }

    public void setTabPaddingStart(int r10) {
        this.f17127m = r10;
    }

    public void setTabPaddingTop(int r10) {
        this.f17129n = r10;
    }

    @Deprecated
    public void setTabTextAppearance(int r10) {
        this.f17137r = r10;
    }

    public void setTabTextColors(@Nullable ColorStateList r10) {
        if (this.f17139s == r10) goto L6;
        this.f17139s = r10;
        h0();
        return;
    }

    public void setTabTextSize(float r10) {
        if (this.f17143u == r10) goto L6;
        this.f17143u = r10;
        h0();
        return;
    }

    @Deprecated
    public void setTabsFromPagerAdapter(@Nullable PagerAdapter r10) {
        a0(r10, false);
    }

    public void setupWithViewPager(@Nullable ViewPager r10) {
        f0(r10, true);
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        if (getTabScrollRange() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final void t(h r10) {
        TabView r11 = r10.f17213h;
        this.f17115g.addView(r11, r10.d(), D());
    }

    public final void u(View r10) {
        if ((r10 instanceof OTabItem) == false) goto L6;
        s((OTabItem) r10);
        return;
    L6:
        if ((r10 instanceof g) == false) goto L11;
        if (indexOfChild(r10) != (-1)) goto L15;
        super.addView(r10, 0, new FrameLayout.LayoutParams(-2, -1));
        return;
    L15:
        return;
    L11:
        if ((r10 instanceof OBottomTabItem) == false) goto L17;
        r((OBottomTabItem) r10);
        return;
    }

    @Override // com.obric.oui.material.MaterialOwner, com.obric.oui.material.MaskMaterialOwner
    public void updateBackdropSrcType(int r10) {
        if (this.f17134p0 == false) goto L7;
        int r11 = this.f17103a.size();
        int r12 = 0;
    L5:
        if (r12 >= r11) goto L9;
        ((h) this.f17103a.get(r12)).s(r10);
        r12 = r12 + 1;
        goto L5
    L9:
        return;
    }

    @Override // com.obric.oui.material.MaterialOwner, com.obric.oui.material.MaskMaterialOwner
    public void updateBackdropTargetType(boolean r10) {
        if (this.f17134p0 == false) goto L7;
        int r11 = this.f17103a.size();
        int r12 = 0;
    L5:
        if (r12 >= r11) goto L9;
        ((h) this.f17103a.get(r12)).t(r10);
        r12 = r12 + 1;
        goto L5
    L9:
        return;
    }

    public final void v(int r10) {
        if (r10 != (-1)) goto L6;
        return;
    L6:
        if (getWindowToken() != null) goto L8;
    L17:
        b0(r10, 0.0f, true);
        return;
    L8:
        if (ViewCompat.T(this) == false) goto L17;
        if (this.f17115g.e() == true) goto L17;
        int r11 = getScrollX();
        int r12 = z(r10, 0.0f);
        if (r11 == r12) goto L15;
        N();
        this.K.setIntValues(new int[]{r11, r12});
        this.K.start();
    L15:
        this.f17115g.d(r10, 200);
    }

    public final void w() {
        int r10 = this.E;
        if (r10 == 0) goto L7;
        if (r10 != 1) goto L8;
        this.f17115g.setGravity(1);
        setOverScrollMode(2);
    L8:
        k0(true);
        return;
    L7:
        this.f17115g.setGravity(8388611);
        setOverScrollMode(0);
        goto L8
    }

    public final void y() {
        View r10 = Q(getSelectedTabPosition());
        if (r10 != null) goto L5;
        return;
    L5:
        this.D0.f17175a = r10.getLeft();
        this.D0.f17176b = r10.getRight();
        TabView r11 = this.f17107c.g();
        this.E0.f17175a = r11.getLeft();
        this.E0.f17176b = r11.getRight();
        d r12 = this.E0;
        float r13 = r12.f17175a;
        d r14 = this.D0;
        if (r13 == r14.f17175a) goto L8;
    L10:
        this.A0.setObjectValues(new Object[]{r12, r14});
        if (this.f17128m0 == false) goto L13;
        this.A0.setInterpolator(this.B0);
    L13:
        this.A0.setDuration(350);
        this.A0.start();
        return;
    L8:
        if (r12.f17176b != r14.f17176b) goto L10;
        invalidate();
    }

    public final int z(int r10, float r11) {
        int r12 = 0;
        if (this.E != 0) goto L21;
        View r13 = this.f17115g.getChildAt(r10);
        int r14 = r10 + 1;
        if (r14 >= this.f17115g.getChildCount()) goto L7;
        View r15 = this.f17115g.getChildAt(r14);
    L8:
        if (r13 == null) goto L10;
        int r16 = r13.getWidth();
    L11:
        if (r15 == null) goto L13;
        int r17 = r15.getWidth();
    L14:
        if (r13 == null) goto L16;
        r12 = r13.getLeft();
    L16:
        int r18 = (r12 + (r16 / 2)) - (getWidth() / 2);
        int r19 = (int) ((((r16 + r17) + (this.f17119i * 4)) * 0.5f) * r11);
        if (ViewCompat.A(this) != 0) goto L20;
        return r18 + r19;
    L20:
        return r18 - r19;
    L13:
        r17 = 0;
        goto L14
    L10:
        r16 = 0;
        goto L11
    L7:
        r15 = null;
        goto L8
    L21:
        return 0;
    }

    public OTabLayoutBase(Context r10, AttributeSet r11) {
        this(r10, r11, 0);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View r10, int r11) {
        u(r10);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet r10) {
        return generateDefaultLayoutParams();
    }

    public OTabLayoutBase(Context r13, AttributeSet r14, int r15) {
        super(r13, r14, r15);
        this.f17103a = new ArrayList();
        this.f17111e = null;
        this.f17117h = 0.3f;
        this.f17121j = 0;
        this.f17123k = 0;
        this.f17135q = 0;
        this.f17141t = 0;
        this.f17149x = Channel.UNLIMITED;
        this.f17151y = Channel.UNLIMITED;
        this.I = new ArrayList();
        this.T = false;
        this.V = 0;
        this.W = null;
        this.f17104a0 = 0.0f;
        this.f17106b0 = 0.0f;
        this.f17108c0 = 0.0f;
        this.f17110d0 = new Paint(1);
        this.f17112e0 = new Paint(1);
        this.f17114f0 = new Paint(1);
        this.f17116g0 = new RectF();
        this.f17118h0 = new RectF();
        this.f17120i0 = new RectF();
        this.f17122j0 = new RectF();
        this.f17126l0 = true;
        this.f17128m0 = false;
        this.f17134p0 = false;
        this.f17136q0 = null;
        this.f17138r0 = null;
        this.f17140s0 = null;
        this.f17142t0 = null;
        this.f17144u0 = null;
        this.f17146v0 = true;
        this.f17148w0 = new Rect();
        this.f17150x0 = new Rect();
        this.f17152y0 = new Paint();
        this.f17154z0 = new nd.a();
        this.B0 = new PathInterpolator(0.34f, 0.69f, 0.1f, 1.0f);
        this.C0 = new float[8];
        this.D0 = new d(this);
        this.E0 = new d(this);
        this.F0 = -1;
        this.G0 = false;
        this.I0 = new androidx.core.util.d(12);
        this.K0 = null;
        this.L0 = null;
        this.G0 = td.h.g(r13.getResources().getConfiguration().fontScale);
        if (OMaterialHelper.u(r13) == true) goto L5;
    L7:
        boolean r10 = false;
    L8:
        this.f17109d = r10;
        setHorizontalScrollBarEnabled(false);
        g r11 = new g(this, r13);
        this.f17115g = r11;
        r11.setDuplicateParentStateEnabled(true);
        setClipChildren(false);
        setClipToPadding(false);
        super.addView(r11, 0, new FrameLayout.LayoutParams(-2, -1));
        TypedArray r12 = r13.obtainStyledAttributes(r14, R$styleable.TabLayout, r15, R$style.OTabText);
        r11.l(r12.getDimensionPixelSize(R$styleable.TabLayout_tabIndicatorHeight, 0));
        r11.j(r12.getColor(R$styleable.TabLayout_tabIndicatorColor, ContextCompat.b(getContext(), R$color.oui_accent_7)));
        int r16 = R$styleable.TabLayout_tabMinWidth;
        this.f17125l = r12.getDimensionPixelSize(r16, J(56));
        int r17 = r12.getDimensionPixelSize(R$styleable.TabLayout_tabPadding, 0);
        this.f17127m = r17;
        this.f17129n = r17;
        this.f17131o = r17;
        this.f17133p = r17;
        this.f17127m = r12.getDimensionPixelSize(R$styleable.TabLayout_tabPaddingStart, r17);
        this.f17129n = r12.getDimensionPixelSize(R$styleable.TabLayout_tabPaddingTop, this.f17129n);
        this.f17131o = r12.getDimensionPixelSize(R$styleable.TabLayout_tabPaddingEnd, this.f17131o);
        this.f17133p = r12.getDimensionPixelSize(R$styleable.TabLayout_tabPaddingBottom, this.f17133p);
        int r18 = r12.getResourceId(R$styleable.TabLayout_tabTextAppearance, R$style.TextAppearance_Design_Tab);
        this.f17137r = r18;
        int r19 = this.f17127m;
        if (r19 > 0) goto L11;
    L13:
        int r20 = this.f17131o;
        if (r20 > 0) goto L16;
    L18:
        TypedArray r21 = r13.obtainStyledAttributes(r18, R$styleable.TextAppearance);
        this.f17143u = r21.getDimensionPixelSize(R$styleable.TextAppearance_android_textSize, 0);     // Catch: Throwable -> L96
        this.f17139s = r21.getColorStateList(R$styleable.TextAppearance_android_textColor);     // Catch: Throwable -> L96
        r21.recycle();
        int r22 = R$styleable.TabLayout_tabTextColor;
        if (r12.hasValue(r22) == false) goto L23;
        this.f17139s = r12.getColorStateList(r22);
    L23:
        int r23 = R$styleable.TabLayout_tabSelectedTextColor;
        boolean r24 = r12.hasValue(r23);
        if (r24 == false) goto L26;
        int r25 = r12.getColor(r23, 0);
    L27:
        this.f17153z = r12.getDimensionPixelSize(r16, -1);
        int r26 = r12.getDimensionPixelSize(R$styleable.TabLayout_tabMaxWidth, -1);
        this.A = r26;
        if (r26 <= 0) goto L30;
        this.f17151y = r26;
    L30:
        this.f17147w = r12.getResourceId(R$styleable.TabLayout_tabBackground, 0);
        this.C = r12.getDimensionPixelSize(R$styleable.TabLayout_tabContentStart, 0);
        this.E = r12.getInt(R$styleable.TabLayout_tabMode, 1);
        this.D = r12.getInt(R$styleable.TabLayout_tabGravity, 1);
        TypedArray r110 = r13.obtainStyledAttributes(r14, new int[]{R.attr.minHeight}, r15, 0);
        int r27 = r110.getDimensionPixelSize(0, 0);
        if (r27 <= 0) goto L33;
        setMinimumHeight(r27);
    L33:
        r110.recycle();
        TypedArray r111 = r13.obtainStyledAttributes(r14, R$styleable.OTabLayoutSupple);
        r11.k(r111.getBoolean(R$styleable.OTabLayoutSupple_oui_tabIndicatorFullWidth, true));     // Catch: Throwable -> L37
        r11.n(r111.getBoolean(R$styleable.OTabLayoutSupple_oui_showBottomLine, false));     // Catch: Throwable -> L37
        r11.p(r111.getBoolean(R$styleable.OTabLayoutSupple_oui_showTopLine, false));     // Catch: Throwable -> L37
        r11.o(r111.getBoolean(R$styleable.OTabLayoutSupple_oui_showSelectedIndicator, true));     // Catch: Throwable -> L37
        this.f17145v = r111.getDimensionPixelSize(R$styleable.OTabLayoutSupple_oui_tabSelectedTextSize, 0);     // Catch: Throwable -> L37
        this.f17143u = r111.getDimensionPixelSize(R$styleable.OTabLayoutSupple_oui_tabTextSize, (int) this.f17143u);     // Catch: Throwable -> L37
        this.f17113f = r111.getResourceId(R$styleable.OTabLayoutSupple_oui_widgetShadow, R$style.OUIShadow_Oui_Shadow_Regular);     // Catch: Throwable -> L37
        if (this.f17109d == false) goto L39;
        this.f17109d = r111.getBoolean(R$styleable.OTabLayoutSupple_oui_widgetEnableMaterial, true);     // Catch: Throwable -> L37
    L39:
        int r28 = r111.getInt(R$styleable.OTabLayoutSupple_oui_tab_spec, -1);     // Catch: Throwable -> L37
        if (r28 == 0) goto L45;
        if (r28 == 1) goto L45;
        if (r28 == 2) goto L44;
        e0(J(16), J(4), J(16), J(12));     // Catch: Throwable -> L37
    L46:
        String r29 = r111.getString(R$styleable.OTabLayoutSupple_oui_widgetMaterial);     // Catch: Throwable -> L37
        if (r29 != null) goto L49;
        r29 = r13.getString(R$string.oui_material_bg_floating);     // Catch: Throwable -> L37
    L49:
        r111.recycle();
        this.B = getResources().getDimensionPixelSize(R$dimen.design_tab_scrollable_min_width);
        this.R = tc.f.h(1.5f, r13);
        this.S = tc.f.h(1.5f, r13);
        this.J0 = getResources().getConfiguration().orientation;
        r12.recycle();
        TypedArray r112 = r13.obtainStyledAttributes(r14, R$styleable.OTabLayout);
        Drawable r113 = r112.getDrawable(R$styleable.OTabLayout_tab_divider);     // Catch: Throwable -> L53
        if (r113 == null) goto L55;
        r11.setDividerDrawable(r113);     // Catch: Throwable -> L53
        r11.setShowDividers(2);     // Catch: Throwable -> L53
    L55:
        this.U = r112.getColor(R$styleable.OTabLayout_indicator_color, 0);     // Catch: Throwable -> L53
        this.V = r112.getColor(R$styleable.OTabLayout_indicator_unselected_color, 0);     // Catch: Throwable -> L53
        this.W = r112.getDrawable(R$styleable.OTabLayout_indicator_background);     // Catch: Throwable -> L53
        this.f17104a0 = r112.getDimension(R$styleable.OTabLayout_indicator_height, -1.0f);     // Catch: Throwable -> L53
        this.f17108c0 = r112.getDimension(R$styleable.OTabLayout_indicator_corner_radius, -1.0f);     // Catch: Throwable -> L53
        Drawable r114 = this.W;     // Catch: Throwable -> L53
        if ((r114 instanceof GradientDrawable) == false) goto L58;
        ((GradientDrawable) r114).setCornerRadius(this.f17108c0);     // Catch: Throwable -> L53
    L58:
        this.f17106b0 = r112.getDimension(R$styleable.OTabLayout_indicator_spacing, J(4));     // Catch: Throwable -> L53
        this.f17124k0 = r112.getColor(R$styleable.OTabLayout_bar_color, 0);     // Catch: Throwable -> L53
        if (this.f17124k0 != 0) goto L61;
        e0(0, 0, 0, 0);     // Catch: Throwable -> L53
    L61:
        this.f17126l0 = r112.getBoolean(R$styleable.OTabLayout_indicator_anim_enable, false);     // Catch: Throwable -> L53
        this.f17128m0 = r112.getBoolean(R$styleable.OTabLayout_indicator_bounce_enable, true);     // Catch: Throwable -> L53
        this.f17154z0.e(r112.getBoolean(R$styleable.OTabLayout_tab_edgeFadeEnabled, false));     // Catch: Throwable -> L53
        this.f17154z0.f(r112.getDimension(R$styleable.OTabLayout_tab_edgeFadeLength, K(20.0f)));     // Catch: Throwable -> L53
        this.f17117h = A(r112.getFloat(R$styleable.OTabLayout_oui_alpha_disabled, this.f17117h));     // Catch: Throwable -> L53
        this.f17130n0 = r112.getResourceId(R$styleable.OTabLayout_tab_textSelectedStyle, 0);     // Catch: Throwable -> L53
        this.f17132o0 = r112.getResourceId(R$styleable.OTabLayout_tab_textStyle, 0);     // Catch: Throwable -> L53
        this.f17141t = r112.getColor(R$styleable.OTabLayout_tab_textPressedColor, 0);     // Catch: Throwable -> L53
        this.f17134p0 = r112.getBoolean(R$styleable.OTabLayout_tab_enableMaterial, false);     // Catch: Throwable -> L53
        if (this.f17134p0 == false) goto L69;
        this.f17136q0 = r112.getString(R$styleable.OTabLayout_tab_material);     // Catch: Throwable -> L53
        this.f17140s0 = r112.getString(R$styleable.OTabLayout_tab_material_selected);     // Catch: Throwable -> L53
        if (TextUtils.isEmpty(this.f17136q0) == false) goto L66;
        this.f17136q0 = r13.getString(R$string.oui_material_bg_floating);     // Catch: Throwable -> L53
    L66:
        this.f17138r0 = MaterialToken.parseSet(this.f17136q0, !S());     // Catch: Throwable -> L53
        if (TextUtils.isEmpty(this.f17140s0) == true) goto L69;
        this.f17142t0 = MaterialToken.parseSet(this.f17140s0, !S());     // Catch: Throwable -> L53
    L69:
        int r115 = r112.getResourceId(R$styleable.OTabLayout_shadow_pressed, 0);     // Catch: Throwable -> L53
        if (r115 == 0) goto L72;
        List r116 = OUILayoutHelper.x(r13, r115);     // Catch: Throwable -> L53
        ArrayList r30 = new ArrayList(2);     // Catch: Throwable -> L53
        this.f17144u0 = r30;     // Catch: Throwable -> L53
        r30.add((Shadow) r116.get(0));     // Catch: Throwable -> L53
        this.f17144u0.add((Shadow) r116.get(1));     // Catch: Throwable -> L53
    L72:
        r112.recycle();
        if (r24 == true) goto L75;
    L78:
        ValueAnimator r117 = ValueAnimator.ofObject(new f(this), new Object[]{this.E0, this.D0});
        this.A0 = r117;
        r117.addUpdateListener(this);
        this.f17110d0.setStyle(Paint.Style.FILL);
        this.f17114f0.setStyle(Paint.Style.STROKE);
        this.f17114f0.setColor(0);
        float r118 = this.f17108c0 + (this.f17106b0 / 2.0f);
        if (this.f17109d == false) goto L90;
        this.f17111e = new WeakReference(this);
        com.obric.oui.material.b[] r119 = MaterialToken.parseSet(r29, !S());
        if (r119 == null) goto L90;
        OMaterialHelper.P(this, 2, r119);
        GradientDrawable r31 = new GradientDrawable();
        r31.setShape(0);
        r31.setCornerRadius(r118);
        r31.setColor(0);
        setBackground(r31);
        setOutlineProvider(ViewOutlineProvider.BACKGROUND);
        Drawable r120 = this.W;
        if ((r120 instanceof GradientDrawable) == false) goto L86;
        ((GradientDrawable) r120).setColor(0);
    L86:
        if (OMaterialHelper.q(r13) != 1) goto L90;
        com.obric.oui.material.b r121 = r119[0];
        if (r121.j() == null) goto L90;
        this.f17114f0.setColor(r121.j().b());
        this.f17114f0.setStrokeWidth(J((int) r121.j().c()));
    L90:
        i0();
        w();
        return;
    L75:
        if (this.f17141t == 0) goto L77;
        this.f17139s = E(this.f17139s.getDefaultColor(), r25, this.f17141t);
        goto L78
    L77:
        this.f17139s = C(this.f17139s.getDefaultColor(), r25);
    L53:
        th = move-exception;
        r112.recycle();
        throw th;
    L44:
        e0(J(12), J(6), J(12), J(6));     // Catch: Throwable -> L37
    L45:
        int r32 = J(4);     // Catch: Throwable -> L37
        e0(r32, r32, r32, r32);     // Catch: Throwable -> L37
        this.f17135q = J(4);     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        r111.recycle();
        throw th;
    L26:
        r25 = 0;
    L96:
        th = move-exception;
        r21.recycle();
        throw th;
    L16:
        if (this.G0 == false) goto L18;
        this.f17131o = (r20 * 2) / 3;
        goto L18
    L11:
        if (this.G0 == false) goto L13;
        this.f17127m = (r19 * 2) / 3;
        goto L13
    L5:
        if (OMaterialHelper.w() == false) goto L7;
        r10 = true;
        goto L8
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup, android.view.ViewManager
    public void addView(View r10, ViewGroup.LayoutParams r11) {
        u(r10);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View r10, int r11, ViewGroup.LayoutParams r12) {
        u(r10);
    }

    public void setTabMode(String r10) {
        r10.hashCode();
        if (r10.equals("scrollable") == true) goto L11;
        if (r10.equals("fixed") == true) goto L8;
        return;
    L8:
        if (this.E == 1) goto L14;
        this.E = 1;
        w();
        return;
    L14:
        return;
    L11:
        if (this.E == 0) goto L16;
        this.E = 0;
        w();
        return;
    }
}
