package stepos.support.v7.widget;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.D;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.appcompat.widget.a0;
import androidx.core.view.H;
import androidx.core.view.S;
import androidx.core.view.T;
import b1.C0555c;
import g.C0728a;
import java.util.ArrayList;
import stepos.support.v7.app.a;

/* loaded from: classes.dex */
public class v extends HorizontalScrollView implements AdapterView.OnItemSelectedListener {

    /* renamed from: D, reason: collision with root package name */
    private static final Interpolator f22187D = androidx.core.view.animation.a.a(0.17f, 0.17f, 0.2f, 1.0f);

    /* renamed from: E, reason: collision with root package name */
    private static final Interpolator f22188E = androidx.core.view.animation.a.a(0.33f, 0.0f, 0.83f, 0.83f);

    /* renamed from: F, reason: collision with root package name */
    private static final Interpolator f22189F = androidx.core.view.animation.a.a(0.17f, 0.17f, 0.2f, 1.0f);

    /* renamed from: G, reason: collision with root package name */
    private static final Interpolator f22190G = new DecelerateInterpolator();

    /* renamed from: A, reason: collision with root package name */
    private boolean f22191A;

    /* renamed from: B, reason: collision with root package name */
    private boolean f22192B;

    /* renamed from: C, reason: collision with root package name */
    private boolean f22193C;

    /* renamed from: a, reason: collision with root package name */
    Runnable f22194a;

    /* renamed from: b, reason: collision with root package name */
    private f f22195b;

    /* renamed from: c, reason: collision with root package name */
    private d f22196c;

    /* renamed from: d, reason: collision with root package name */
    private Spinner f22197d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f22198e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f22199f;

    /* renamed from: g, reason: collision with root package name */
    int f22200g;

    /* renamed from: h, reason: collision with root package name */
    private int f22201h;

    /* renamed from: i, reason: collision with root package name */
    private int f22202i;

    /* renamed from: j, reason: collision with root package name */
    protected S f22203j;

    /* renamed from: k, reason: collision with root package name */
    protected final h f22204k;

    /* renamed from: l, reason: collision with root package name */
    private int f22205l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f22206m;

    /* renamed from: n, reason: collision with root package name */
    private int f22207n;

    /* renamed from: o, reason: collision with root package name */
    private int f22208o;

    /* renamed from: p, reason: collision with root package name */
    private int f22209p;

    /* renamed from: q, reason: collision with root package name */
    private int f22210q;

    /* renamed from: r, reason: collision with root package name */
    private int f22211r;

    /* renamed from: s, reason: collision with root package name */
    private int f22212s;

    /* renamed from: t, reason: collision with root package name */
    private int f22213t;

    /* renamed from: u, reason: collision with root package name */
    private boolean f22214u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f22215v;

    /* renamed from: w, reason: collision with root package name */
    private int f22216w;

    /* renamed from: x, reason: collision with root package name */
    private int f22217x;

    /* renamed from: y, reason: collision with root package name */
    private int f22218y;

    /* renamed from: z, reason: collision with root package name */
    private int f22219z;

    class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Drawable f22220a;

        a(Drawable drawable) {
            this.f22220a = drawable;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f22220a.setTint(((Integer) valueAnimator.getAnimatedValue()).intValue());
        }
    }

    class b implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Drawable f22222a;

        b(Drawable drawable) {
            this.f22222a = drawable;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f22222a.setTint(((Integer) valueAnimator.getAnimatedValue()).intValue());
        }
    }

    class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f22224a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f22225b;

        c(View view, int i5) {
            this.f22224a = view;
            this.f22225b = i5;
        }

        @Override // java.lang.Runnable
        public void run() {
            v.this.smoothScrollTo(this.f22224a.getLeft() - ((v.this.getWidth() - this.f22224a.getWidth()) / 2), 0);
            v.this.f22196c.E(this.f22225b, 400);
            v.this.f22194a = null;
        }
    }

    private class d extends LinearLayoutCompat {

        /* renamed from: A, reason: collision with root package name */
        private int f22227A;

        /* renamed from: B, reason: collision with root package name */
        private int f22228B;

        /* renamed from: C, reason: collision with root package name */
        private int f22229C;

        /* renamed from: D, reason: collision with root package name */
        private int f22230D;

        /* renamed from: E, reason: collision with root package name */
        private int f22231E;

        /* renamed from: F, reason: collision with root package name */
        private int f22232F;

        /* renamed from: G, reason: collision with root package name */
        private int f22233G;

        /* renamed from: p, reason: collision with root package name */
        private int f22235p;

        /* renamed from: q, reason: collision with root package name */
        private boolean f22236q;

        /* renamed from: r, reason: collision with root package name */
        private boolean f22237r;

        /* renamed from: s, reason: collision with root package name */
        private int f22238s;

        /* renamed from: t, reason: collision with root package name */
        private final Paint f22239t;

        /* renamed from: u, reason: collision with root package name */
        private int f22240u;

        /* renamed from: v, reason: collision with root package name */
        private float f22241v;

        /* renamed from: w, reason: collision with root package name */
        private int f22242w;

        /* renamed from: x, reason: collision with root package name */
        private int f22243x;

        /* renamed from: y, reason: collision with root package name */
        private ValueAnimator f22244y;

        /* renamed from: z, reason: collision with root package name */
        private Drawable f22245z;

        class a implements ValueAnimator.AnimatorUpdateListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f22246a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ int f22247b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ int f22248c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f22249d;

            a(int i5, int i6, int i7, int i8) {
                this.f22246a = i5;
                this.f22247b = i6;
                this.f22248c = i7;
                this.f22249d = i8;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                d.this.L(valueAnimator.getAnimatedFraction(), this.f22246a, this.f22247b, this.f22248c, this.f22249d);
            }
        }

        class b extends AnimatorListenerAdapter {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f22251a;

            b(int i5) {
                this.f22251a = i5;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                d.this.f22240u = this.f22251a;
                d.this.f22241v = 0.0f;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.f22240u = this.f22251a;
                d.this.f22241v = 0.0f;
            }
        }

        public d(Context context, AttributeSet attributeSet, int i5) {
            super(context, attributeSet, i5);
            this.f22240u = -1;
            this.f22242w = -1;
            this.f22243x = -1;
            setWillNotDraw(false);
            Paint paint = new Paint();
            this.f22239t = paint;
            a0 a0VarV = a0.v(context, attributeSet, X4.l.f6362u3, i5, 0);
            int iB = a0VarV.b(X4.l.f6380x3, getResources().getColor(X4.c.f5857c));
            this.f22238s = iB;
            paint.setColor(iB);
            this.f22235p = a0VarV.f(X4.l.f6081A3, getResources().getDimensionPixelSize(X4.d.f5902g));
            this.f22236q = a0VarV.a(X4.l.f6368v3, true);
            this.f22237r = a0VarV.a(X4.l.f6374w3, false);
            this.f22245z = a0VarV.g(X4.l.f6386y3);
            this.f22229C = a0VarV.f(X4.l.f6099D3, getResources().getDimensionPixelSize(X4.d.f5906i));
            this.f22228B = a0VarV.f(X4.l.f6105E3, getResources().getDimensionPixelSize(X4.d.f5908j));
            if (v.this.f22192B) {
                this.f22227A = this.f22229C;
            } else {
                this.f22227A = this.f22228B;
            }
            this.f22233G = a0VarV.f(X4.l.f6392z3, getResources().getDimensionPixelSize(X4.d.f5917q));
            this.f22230D = a0VarV.f(X4.l.f6087B3, getResources().getDimensionPixelSize(X4.d.f5904h));
            this.f22231E = a0VarV.f(X4.l.f6093C3, getResources().getDimensionPixelSize(X4.d.f5901f0));
            a0VarV.x();
            this.f22232F = getResources().getDimensionPixelSize(X4.d.f5900f);
            setMotionEventSplittingEnabled(false);
            Y4.a aVar = new Y4.a();
            aVar.a(33);
            setDividerDrawable(aVar);
        }

        private int I(View view) {
            return this.f22227A;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void L(float f5, int i5, int i6, int i7, int i8) {
            float f6;
            Interpolator interpolator;
            float fMax = Math.max(Math.min(f5, 1.0f), 0.0f);
            if (fMax < 0.325f) {
                f6 = fMax / 0.325f;
                interpolator = v.f22188E;
            } else {
                f6 = (1.0f - fMax) / 0.675f;
                interpolator = v.f22189F;
            }
            int interpolation = this.f22227A + ((int) (interpolator.getInterpolation(f6) * this.f22232F));
            if (i5 < i7) {
                i6 = stepos.support.v7.widget.e.b(i6, i8, v.f22187D.getInterpolation(fMax));
                i5 = i6 - interpolation;
            } else if (i5 > i7) {
                i5 = stepos.support.v7.widget.e.b(i5, i7, v.f22187D.getInterpolation(fMax));
                i6 = i5 + interpolation;
            }
            M(i5, i6);
        }

        private void M(int i5, int i6) {
            if (i5 == this.f22242w && i6 == this.f22243x) {
                return;
            }
            this.f22242w = i5;
            this.f22243x = i6;
            H.a0(this);
        }

        private void O() {
            d dVar;
            int i5;
            int i6;
            View childAt = getChildAt(this.f22240u);
            if (childAt == null || childAt.getWidth() <= 0) {
                dVar = this;
                i5 = -1;
                i6 = -1;
            } else {
                int left = (childAt.getLeft() + childAt.getRight()) / 2;
                int i7 = this.f22227A;
                i5 = left - (i7 / 2);
                i6 = left + (i7 / 2);
                if (this.f22241v > 0.0f && this.f22240u < getChildCount() - 1) {
                    View childAt2 = getChildAt(this.f22240u + 1);
                    int left2 = (childAt2.getLeft() + childAt2.getRight()) / 2;
                    int I5 = I(childAt2) / 2;
                    L(this.f22241v, i5, i6, left2 - I5, left2 + I5);
                    return;
                }
                dVar = this;
            }
            dVar.M(i5, i6);
        }

        void E(int i5, int i6) {
            H.x(this);
            View childAt = getChildAt(i5);
            if (childAt == null) {
                return;
            }
            int left = (childAt.getLeft() + childAt.getRight()) / 2;
            int I5 = I(childAt) / 2;
            int i7 = left - I5;
            int i8 = left + I5;
            int i9 = this.f22242w;
            int i10 = this.f22243x;
            if ((i9 == i7 && i10 == i8) || i9 < 0 || i10 < 0) {
                this.f22240u = i5;
                this.f22241v = 0.0f;
                return;
            }
            if (i6 <= 0) {
                L(1.0f, i9, i10, i7, i8);
                return;
            }
            ValueAnimator valueAnimator = this.f22244y;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.f22244y.cancel();
            }
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.f22244y = valueAnimatorOfFloat;
            valueAnimatorOfFloat.setDuration(i6);
            this.f22244y.setInterpolator(null);
            this.f22244y.addUpdateListener(new a(i9, i10, i7, i8));
            this.f22244y.addListener(new b(i5));
            this.f22244y.start();
        }

        public void F() {
            ValueAnimator valueAnimator = this.f22244y;
            if (valueAnimator == null || !valueAnimator.isRunning()) {
                return;
            }
            this.f22244y.cancel();
        }

        public int G() {
            g gVar = (g) getChildAt(0);
            if (gVar == null) {
                return 0;
            }
            return gVar.getBottom() - (gVar.getMeasuredHeight() - gVar.D());
        }

        int H() {
            View childAt = getChildAt(0);
            return getPaddingStart() + (childAt != null ? childAt.getPaddingStart() : 0);
        }

        void J(boolean z5) {
            if (z5) {
                this.f22227A = this.f22229C;
            } else {
                this.f22227A = this.f22228B;
            }
        }

        void K(Drawable drawable) {
            if (this.f22245z != drawable) {
                this.f22245z = drawable;
                invalidate();
            }
        }

        void N(int i5, float f5) {
            if (v.F(getAnimation())) {
                return;
            }
            F();
            this.f22240u = i5;
            this.f22241v = f5;
            O();
        }

        @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
        protected void onDraw(Canvas canvas) {
            int i5 = this.f22242w;
            if (i5 < 0 || this.f22243x <= i5) {
                return;
            }
            if (((v.this.f22192B || !this.f22236q) && !(v.this.f22192B && this.f22237r)) || v.this.N()) {
                return;
            }
            int height = (getHeight() - this.f22235p) - (v.this.f22192B ? this.f22231E : this.f22230D);
            int iG = G();
            if (height < iG) {
                height = iG;
            }
            if (this.f22235p + height > getHeight()) {
                height = getHeight() - this.f22235p;
            }
            Drawable drawable = this.f22245z;
            if (drawable == null) {
                canvas.drawRect(this.f22242w, height, this.f22243x, height + this.f22235p, this.f22239t);
            } else {
                drawable.setBounds(this.f22242w, height, this.f22243x, this.f22235p + height);
                this.f22245z.draw(canvas);
            }
        }

        @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z5, int i5, int i6, int i7, int i8) {
            super.onLayout(z5, i5, i6, i7, i8);
            if (v.F(getAnimation())) {
                return;
            }
            O();
        }

        @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
        protected void onMeasure(int i5, int i6) {
            super.onMeasure(i5, i6);
            if (View.MeasureSpec.getMode(i5) == 1073741824 && v.this.f22205l == 1) {
                int childCount = getChildCount();
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                int iMax = 0;
                for (int i7 = 0; i7 < childCount; i7++) {
                    View childAt = getChildAt(i7);
                    childAt.measure(iMakeMeasureSpec, i6);
                    iMax = Math.max(iMax, childAt.getMeasuredWidth());
                }
                if (iMax <= 0) {
                    return;
                }
                if (iMax * childCount <= getMeasuredWidth() - (v.this.E(16) * 2)) {
                    for (int i8 = 0; i8 < childCount; i8++) {
                        LinearLayoutCompat.a aVar = (LinearLayoutCompat.a) getChildAt(i8).getLayoutParams();
                        ((LinearLayout.LayoutParams) aVar).width = iMax;
                        ((LinearLayout.LayoutParams) aVar).weight = 0.0f;
                    }
                }
                super.onMeasure(i5, i6);
            }
        }
    }

    private class e extends BaseAdapter {
        private e() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return v.this.f22196c.getChildCount();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i5) {
            return ((g) v.this.f22196c.getChildAt(i5)).E();
        }

        @Override // android.widget.Adapter
        public long getItemId(int i5) {
            return i5;
        }

        @Override // android.widget.Adapter
        public View getView(int i5, View view, ViewGroup viewGroup) {
            if (view == null) {
                return v.this.D((a.i) getItem(i5), true);
            }
            ((g) view).C((a.i) getItem(i5));
            return view;
        }

        /* synthetic */ e(v vVar, a aVar) {
            this();
        }
    }

    private class f implements View.OnClickListener {
        private f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ((g) view).E().m(true);
            int childCount = v.this.f22196c.getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = v.this.f22196c.getChildAt(i5);
                childAt.setSelected(childAt == view);
            }
        }

        /* synthetic */ f(v vVar, a aVar) {
            this();
        }
    }

    private class g extends LinearLayoutCompat implements View.OnLongClickListener {

        /* renamed from: p, reason: collision with root package name */
        private final int[] f22255p;

        /* renamed from: q, reason: collision with root package name */
        private a.i f22256q;

        /* renamed from: r, reason: collision with root package name */
        private TextView f22257r;

        /* renamed from: s, reason: collision with root package name */
        private ImageView f22258s;

        /* renamed from: t, reason: collision with root package name */
        private View f22259t;

        public g(Context context, a.i iVar, boolean z5) {
            super(context, null, v.this.f22192B ? X4.a.f5849y : C0728a.f16828e);
            int[] iArr = {R.attr.background};
            this.f22255p = iArr;
            this.f22256q = iVar;
            a0 a0VarV = a0.v(context, null, iArr, v.this.f22192B ? X4.a.f5849y : C0728a.f16828e, 0);
            a0VarV.s(0);
            a0VarV.x();
            if (z5) {
                setGravity(8388627);
            }
            F();
            if (v.this.N()) {
                this.f22257r.setTextSize(2, 13.0f);
            }
        }

        public void C(a.i iVar) {
            this.f22256q = iVar;
            F();
        }

        public int D() {
            View view = this.f22259t;
            if ((view instanceof k) && view.getVisibility() == 0) {
                return ((k) this.f22259t).a();
            }
            View view2 = this.f22259t;
            if (view2 != null && view2.getVisibility() == 0) {
                return this.f22259t.getBottom();
            }
            TextView textView = this.f22257r;
            if (textView != null && textView.getVisibility() == 0) {
                return this.f22257r.getBottom();
            }
            ImageView imageView = this.f22258s;
            return (imageView == null || imageView.getVisibility() != 0) ? getBottom() : this.f22258s.getBottom();
        }

        public a.i E() {
            return this.f22256q;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void F() {
            a.i iVar = this.f22256q;
            View viewC = iVar.c();
            boolean z5 = false;
            if (viewC != 0) {
                ViewParent parent = viewC.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(viewC);
                    }
                    setClipChildren(false);
                    setClipToPadding(false);
                    addView(viewC);
                }
                this.f22259t = viewC;
                TextView textView = this.f22257r;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                ImageView imageView = this.f22258s;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.f22258s.setImageDrawable(null);
                }
                if (viewC instanceof k) {
                    this.f22257r = ((k) viewC).b();
                }
            } else {
                View view = this.f22259t;
                if (view != null) {
                    removeView(view);
                    this.f22259t = null;
                }
                Drawable drawableD = iVar.d();
                CharSequence charSequenceI = iVar.i();
                ColorStateList colorStateListJ = iVar.j();
                ColorStateList colorStateListA = iVar.a();
                if (drawableD != null) {
                    if (this.f22258s == null) {
                        ImageView imageView2 = new ImageView(getContext());
                        LinearLayoutCompat.a aVar = new LinearLayoutCompat.a(-2, -2);
                        ((LinearLayout.LayoutParams) aVar).gravity = 16;
                        imageView2.setLayoutParams(aVar);
                        addView(imageView2, 0);
                        this.f22258s = imageView2;
                    }
                    this.f22258s.setImageDrawable(drawableD);
                    this.f22258s.setVisibility(0);
                } else {
                    ImageView imageView3 = this.f22258s;
                    if (imageView3 != null) {
                        imageView3.setVisibility(8);
                        this.f22258s.setImageDrawable(null);
                    }
                }
                boolean zIsEmpty = TextUtils.isEmpty(charSequenceI);
                if (zIsEmpty) {
                    TextView textView2 = this.f22257r;
                    if (textView2 != null) {
                        textView2.setVisibility(8);
                        this.f22257r.setText((CharSequence) null);
                    }
                } else {
                    if (this.f22257r == null) {
                        int i5 = v.this.f22192B ? X4.a.f5850z : C0728a.f16829f;
                        if (v.this.f22193C) {
                            i5 = X4.a.f5842r;
                        }
                        D d6 = new D(getContext(), null, i5);
                        d6.setEllipsize(TextUtils.TruncateAt.END);
                        LinearLayoutCompat.a aVar2 = new LinearLayoutCompat.a(-2, -2);
                        boolean unused = v.this.f22192B;
                        ((LinearLayout.LayoutParams) aVar2).gravity = 16;
                        d6.setLayoutParams(aVar2);
                        addView(d6);
                        this.f22257r = d6;
                    }
                    this.f22257r.setText(charSequenceI);
                    if (colorStateListJ != null) {
                        v.this.f22219z = colorStateListJ.getColorForState(new int[0], -1);
                        v.this.f22218y = colorStateListJ.getColorForState(new int[]{R.attr.state_selected}, -16776961);
                        this.f22257r.setTextColor(colorStateListJ);
                    }
                    if (v.this.N() && colorStateListA != null) {
                        v.this.f22217x = colorStateListA.getColorForState(new int[0], -1);
                        v.this.f22216w = colorStateListA.getColorForState(new int[]{R.attr.state_selected}, -16776961);
                    }
                    this.f22257r.setVisibility(0);
                    this.f22257r.setEnabled(iVar.k());
                }
                ImageView imageView4 = this.f22258s;
                if (imageView4 != null) {
                    imageView4.setContentDescription(iVar.b());
                }
                if (!zIsEmpty || TextUtils.isEmpty(iVar.b())) {
                    setOnLongClickListener(null);
                    setLongClickable(false);
                } else {
                    setOnLongClickListener(this);
                }
            }
            setEnabled(iVar.k());
            int iG = iVar.g();
            int iF = iVar.f();
            boolean z6 = true;
            if (iG >= 0) {
                z5 = true;
            } else {
                iG = getPaddingLeft();
            }
            if (iF < 0) {
                iF = getPaddingRight();
                z6 = z5;
            }
            if (z6) {
                setPadding(iG, getPaddingTop(), iF, getPaddingBottom());
            }
            int iE = iVar.e();
            if (iE >= 0) {
                setMinimumWidth(iE);
            }
            TextView textView3 = this.f22257r;
            if (textView3 != null) {
                textView3.setEllipsize(TextUtils.TruncateAt.END);
            }
        }

        @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(a.i.class.getName());
        }

        @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(a.i.class.getName());
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            Context context = getContext();
            int width = getWidth();
            int height = getHeight();
            int i5 = context.getResources().getDisplayMetrics().widthPixels;
            Toast toastMakeText = Toast.makeText(context, this.f22256q.b(), 0);
            toastMakeText.setGravity(49, (iArr[0] + (width / 2)) - (i5 / 2), height);
            toastMakeText.show();
            return true;
        }

        @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
        public void onMeasure(int i5, int i6) {
            super.onMeasure(i5, i6);
            if (v.this.f22208o <= 0 || getMeasuredWidth() >= v.this.f22208o || v.this.f22191A) {
                return;
            }
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(v.this.f22208o, 1073741824), i6);
        }

        @Override // android.view.View
        public void setSelected(boolean z5) {
            boolean z6 = isSelected() != z5;
            super.setSelected(z5);
            if (z6 && z5) {
                sendAccessibilityEvent(4);
            }
            if (!v.this.N()) {
                if (z5) {
                    this.f22257r.setTextColor(v.this.f22218y);
                    return;
                } else {
                    this.f22257r.setTextColor(v.this.f22219z);
                    return;
                }
            }
            Drawable background = getBackground();
            if (z5) {
                this.f22257r.setTextColor(v.this.f22218y);
                background.setTint(v.this.f22216w);
            } else {
                this.f22257r.setTextColor(v.this.f22219z);
                background.setTint(v.this.f22217x);
            }
        }
    }

    protected class h implements T {

        /* renamed from: a, reason: collision with root package name */
        private boolean f22261a = false;

        /* renamed from: b, reason: collision with root package name */
        private int f22262b;

        protected h() {
        }

        @Override // androidx.core.view.T
        public void c(View view) {
            this.f22261a = true;
        }

        @Override // androidx.core.view.T
        public void d(View view) {
            if (this.f22261a) {
                return;
            }
            v vVar = v.this;
            vVar.f22203j = null;
            vVar.setVisibility(this.f22262b);
        }

        @Override // androidx.core.view.T
        public void e(View view) {
            v.this.setVisibility(0);
            this.f22261a = false;
        }
    }

    public v(Context context) {
        this(context, null);
    }

    private int A(int i5, float f5) {
        if (this.f22205l != 0) {
            return 0;
        }
        View childAt = this.f22196c.getChildAt(i5);
        int i6 = i5 + 1;
        float width = ((childAt != null ? childAt.getWidth() : 0) + ((i6 < this.f22196c.getChildCount() ? this.f22196c.getChildAt(i6) : null) != null ? r7.getWidth() : 0) + ((this.f22196c.getShowDividers() == 2 ? this.f22196c.getDividerDrawable().getIntrinsicWidth() : 0) * 2)) * f5 * 0.5f;
        if (H.x(this) == 1) {
            width = -width;
        }
        return (int) (((childAt.getLeft() + width) + (childAt.getWidth() * 0.5f)) - (getWidth() * 0.5f));
    }

    private Spinner B() {
        androidx.appcompat.widget.A a6 = new androidx.appcompat.widget.A(getContext(), null, C0728a.f16832i);
        a6.setLayoutParams(new LinearLayoutCompat.a(-2, -1));
        a6.setOnItemSelectedListener(this);
        return a6;
    }

    private d C() {
        d dVar = new d(getContext(), null, C0728a.f16827d);
        dVar.setClipChildren(false);
        dVar.setClipToPadding(false);
        dVar.setGravity(this.f22207n);
        dVar.setLayoutParams(new LinearLayoutCompat.a(-2, -1));
        return dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public g D(a.i iVar, boolean z5) {
        g gVar = new g(getContext(), iVar, z5);
        a aVar = null;
        if (z5) {
            gVar.setBackgroundDrawable(null);
            gVar.setLayoutParams(new AbsListView.LayoutParams(-1, this.f22201h));
        } else {
            gVar.setFocusable(true);
            if (this.f22195b == null) {
                this.f22195b = new f(this, aVar);
            }
            gVar.setOnClickListener(this.f22195b);
        }
        if (N()) {
            gVar.setBackground(getContext().getDrawable(X4.e.f5927a));
        }
        return gVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int E(int i5) {
        return Math.round(getResources().getDisplayMetrics().density * i5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean F(Animation animation) {
        return (animation == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private boolean G() {
        Spinner spinner = this.f22197d;
        return spinner != null && spinner.getParent() == this;
    }

    private void H() {
        if (G()) {
            return;
        }
        if (this.f22197d == null) {
            this.f22197d = B();
        }
        removeView(this.f22196c);
        addView(this.f22197d, new ViewGroup.LayoutParams(-2, -1));
        a aVar = null;
        if (this.f22197d.getAdapter() == null) {
            this.f22197d.setAdapter((SpinnerAdapter) new e(this, aVar));
        }
        Runnable runnable = this.f22194a;
        if (runnable != null) {
            removeCallbacks(runnable);
            this.f22194a = null;
        }
        this.f22197d.setSelection(this.f22202i);
    }

    private boolean I() {
        if (!G()) {
            return false;
        }
        removeView(this.f22197d);
        addView(this.f22196c, new ViewGroup.LayoutParams(-2, -1));
        setTabSelected(this.f22197d.getSelectedItemPosition());
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean N() {
        return this.f22215v && !this.f22192B;
    }

    private void setSelectedTabView(int i5) {
        int childCount = this.f22196c.getChildCount();
        int i6 = 0;
        while (i6 < childCount) {
            this.f22196c.getChildAt(i6).setSelected(i6 == i5);
            i6++;
        }
    }

    private void setTabsGravityInner(int i5) {
        d dVar = this.f22196c;
        if (dVar != null) {
            dVar.setGravity(i5);
        }
    }

    private void x(int i5, float f5) {
        if (f5 >= 0.0f) {
            if (i5 != this.f22196c.getChildCount() - 1 || f5 <= 0.0f) {
                g gVar = (g) this.f22196c.getChildAt(i5);
                g gVar2 = (g) this.f22196c.getChildAt(i5 + 1);
                if (gVar != null) {
                    gVar.getBackground().setTint(C0555c.b().evaluate(f5, Integer.valueOf(this.f22216w), Integer.valueOf(this.f22217x)).intValue());
                    gVar.f22257r.setTextColor(C0555c.b().evaluate(f5, Integer.valueOf(this.f22218y), Integer.valueOf(this.f22219z)).intValue());
                }
                if (gVar2 != null) {
                    float f6 = 1.0f - f5;
                    gVar2.getBackground().setTint(C0555c.b().evaluate(f6, Integer.valueOf(this.f22216w), Integer.valueOf(this.f22217x)).intValue());
                    gVar2.f22257r.setTextColor(C0555c.b().evaluate(f6, Integer.valueOf(this.f22218y), Integer.valueOf(this.f22219z)).intValue());
                }
            }
        }
    }

    private void y(boolean z5, View view) {
        ValueAnimator valueAnimatorOfObject;
        Drawable background = view.getBackground();
        if (z5) {
            valueAnimatorOfObject = ValueAnimator.ofObject(new C0555c(), Integer.valueOf(this.f22217x), Integer.valueOf(this.f22216w));
            valueAnimatorOfObject.setDuration(300L);
            valueAnimatorOfObject.addUpdateListener(new a(background));
        } else {
            valueAnimatorOfObject = ValueAnimator.ofObject(new C0555c(), Integer.valueOf(this.f22216w), Integer.valueOf(this.f22217x));
            valueAnimatorOfObject.setDuration(300L);
            valueAnimatorOfObject.addUpdateListener(new b(background));
        }
        valueAnimatorOfObject.start();
    }

    private void z(int i5, float f5) {
        if (f5 >= 0.0f) {
            if (i5 != this.f22196c.getChildCount() - 1 || f5 <= 0.0f) {
                g gVar = (g) this.f22196c.getChildAt(i5);
                g gVar2 = (g) this.f22196c.getChildAt(i5 + 1);
                if (gVar != null) {
                    gVar.f22257r.setTextColor(C0555c.b().evaluate(f5, Integer.valueOf(this.f22218y), Integer.valueOf(this.f22219z)).intValue());
                }
                if (gVar2 != null) {
                    gVar2.f22257r.setTextColor(C0555c.b().evaluate(1.0f - f5, Integer.valueOf(this.f22218y), Integer.valueOf(this.f22219z)).intValue());
                }
            }
        }
    }

    public void J(int i5, float f5, boolean z5) {
        if (!F(getAnimation()) && i5 >= 0 && i5 < this.f22196c.getChildCount()) {
            this.f22196c.N(i5, f5);
            smoothScrollTo(A(i5, f5), 0);
            if (z5 && !this.f22214u) {
                setSelectedTabView(Math.round(i5 + f5));
                if (N()) {
                    x(i5, f5);
                } else {
                    z(i5, f5);
                }
            }
            if (i5 != this.f22202i || f5 > 0.0f) {
                return;
            }
            this.f22214u = false;
        }
    }

    public void K(int i5, boolean z5) {
        this.f22202i = i5;
        int childCount = this.f22196c.getChildCount();
        int i6 = 0;
        while (i6 < childCount) {
            View childAt = this.f22196c.getChildAt(i6);
            boolean z6 = i6 == i5;
            if (z5 && z6 != childAt.isSelected() && N()) {
                y(z6, childAt);
            }
            childAt.setSelected(z6);
            if (z6) {
                if (z5) {
                    this.f22214u = true;
                    w(i5);
                } else {
                    this.f22214u = false;
                    this.f22196c.E(i5, 0);
                }
            }
            i6++;
        }
        Spinner spinner = this.f22197d;
        if (spinner == null || i5 < 0) {
            return;
        }
        spinner.setSelection(i5);
    }

    public void L(boolean z5) {
        if (this.f22192B != z5) {
            this.f22192B = z5;
            b5.a aVarB = b5.a.b(getContext());
            setContentHeight(this.f22192B ? aVarB.c() : aVarB.h());
            d dVar = this.f22196c;
            if (dVar != null) {
                dVar.J(this.f22192B);
            }
            d dVar2 = this.f22196c;
            if (dVar2 == null || dVar2.getChildCount() <= 0) {
                return;
            }
            int childCount = this.f22196c.getChildCount();
            ArrayList arrayList = new ArrayList();
            int i5 = this.f22202i;
            for (int i6 = 0; i6 < childCount; i6++) {
                g gVar = (g) this.f22196c.getChildAt(i6);
                if (gVar.isSelected()) {
                    i5 = i6;
                }
                arrayList.add(gVar.E());
            }
            this.f22196c.removeAllViews();
            int size = arrayList.size();
            int i7 = 0;
            while (i7 < size) {
                Object obj = arrayList.get(i7);
                i7++;
                a.i iVar = (a.i) obj;
                v(iVar, iVar.h() == i5);
            }
            setTabSelected(i5);
        }
    }

    public void M(int i5) {
        ((g) this.f22196c.getChildAt(i5)).F();
        Spinner spinner = this.f22197d;
        if (spinner != null) {
            ((e) spinner.getAdapter()).notifyDataSetChanged();
        }
        if (this.f22198e) {
            requestLayout();
        }
    }

    public float getContentBottom() {
        return this.f22196c.getBottom() - (this.f22196c.getMeasuredHeight() - this.f22196c.G());
    }

    public int getContentStart() {
        return getPaddingStart() + this.f22196c.H();
    }

    public int getTabStripWidth() {
        return this.f22196c.getMeasuredWidth();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Runnable runnable = this.f22194a;
        if (runnable != null) {
            post(runnable);
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        b5.a aVarB = b5.a.b(getContext());
        int iC = this.f22192B ? aVarB.c() : aVarB.h();
        if (N()) {
            setContentHeight((int) N1.i.a(55.0f, getContext()));
        } else {
            setContentHeight(iC);
        }
        this.f22200g = aVarB.g();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Runnable runnable = this.f22194a;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i5, long j5) {
        ((g) view).E().l();
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z5, int i5, int i6, int i7, int i8) {
        super.onLayout(z5, i5, i6, i7, i8);
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i5, int i6) {
        int mode = View.MeasureSpec.getMode(i5);
        boolean z5 = mode == 1073741824;
        setFillViewport(z5);
        setTabsGravity(this.f22207n);
        int childCount = this.f22196c.getChildCount();
        this.f22196c.setShowDividers(0);
        if (N()) {
            this.f22196c.setShowDividers(2);
            int i7 = 20;
            if (this.f22207n != 3) {
                if (childCount == 2) {
                    i7 = 47;
                } else if (childCount == 3) {
                    i7 = 25;
                }
            }
            for (int i8 = 0; i8 < childCount; i8++) {
                View childAt = this.f22196c.getChildAt(i8);
                if (N()) {
                    float f5 = i7;
                    childAt.setPadding((int) N1.i.a(f5, getContext()), 0, (int) N1.i.a(f5, getContext()), 0);
                }
            }
        }
        if (childCount > 1 && ((mode == 1073741824 || mode == Integer.MIN_VALUE) && !this.f22192B && !N())) {
            this.f22208o = 0;
            if (childCount > 2 && childCount < 5 && this.f22206m) {
                this.f22208o = View.MeasureSpec.getSize(i5) / childCount;
            } else if (childCount >= 5 && this.f22199f) {
                for (int i9 = 0; i9 < childCount; i9++) {
                    View childAt2 = this.f22196c.getChildAt(i9);
                    int i10 = this.f22210q;
                    childAt2.setPadding(i10, 0, i10, 0);
                }
                this.f22196c.setShowDividers(2);
            } else if (this.f22191A) {
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                int measuredWidth = 0;
                for (int i11 = 0; i11 < childCount; i11++) {
                    View childAt3 = this.f22196c.getChildAt(i11);
                    childAt3.measure(iMakeMeasureSpec, i6);
                    measuredWidth += childAt3.getMeasuredWidth();
                }
                int size = View.MeasureSpec.getSize(i5);
                for (int i12 = 0; i12 < childCount; i12++) {
                    LinearLayoutCompat.a aVar = (LinearLayoutCompat.a) this.f22196c.getChildAt(i12).getLayoutParams();
                    ((LinearLayout.LayoutParams) aVar).width = (int) ((r7.getMeasuredWidth() * size) / measuredWidth);
                    ((LinearLayout.LayoutParams) aVar).weight = 0.0f;
                }
            } else if (childCount == 2) {
                for (int i13 = 0; i13 < childCount; i13++) {
                    View childAt4 = this.f22196c.getChildAt(i13);
                    int i14 = this.f22209p;
                    childAt4.setPadding(i14, 0, i14, 0);
                }
            } else if (childCount == 3) {
                this.f22208o = this.f22211r;
                setTabsGravityInner(17);
            } else if (childCount == 4) {
                this.f22208o = this.f22212s;
            } else if (childCount == 5) {
                this.f22208o = this.f22213t;
                setTabsGravityInner(17);
            }
        }
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.f22201h, 1073741824);
        if (z5 || !this.f22198e) {
            I();
        } else {
            this.f22196c.measure(0, iMakeMeasureSpec2);
            if (this.f22196c.getMeasuredWidth() > View.MeasureSpec.getSize(i5)) {
                H();
            } else {
                I();
            }
        }
        getMeasuredWidth();
        super.onMeasure(i5, iMakeMeasureSpec2);
        getMeasuredWidth();
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public void setAdaptTabWidthNoScroll(boolean z5) {
        if (this.f22191A == z5) {
            return;
        }
        this.f22191A = z5;
        requestLayout();
    }

    public void setAllowCollapse(boolean z5) {
        this.f22198e = z5;
    }

    public void setCapsuleStyleEnable(boolean z5) throws Resources.NotFoundException {
        this.f22215v = z5;
        if (N()) {
            Y4.a aVar = new Y4.a();
            aVar.a((int) N1.i.a(16.0f, getContext()));
            this.f22196c.setDividerDrawable(aVar);
            int dimensionPixelSize = getResources().getDimensionPixelSize(X4.d.f5896d);
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(X4.d.f5898e);
            int dimensionPixelSize3 = getResources().getDimensionPixelSize(X4.d.f5894c);
            setContentHeight(dimensionPixelSize);
            d dVar = this.f22196c;
            dVar.setPadding(dVar.getPaddingLeft(), dimensionPixelSize2, this.f22196c.getPaddingRight(), dimensionPixelSize3);
            this.f22219z = getContext().getResources().getColor(H1.e.f2081c);
            this.f22218y = -1;
        }
    }

    public void setContentHeight(int i5) {
        this.f22201h = i5;
        requestLayout();
    }

    public void setEqualTabWidth(boolean z5) {
        this.f22206m = z5;
    }

    public void setIndicatorDrawable(Drawable drawable) {
        this.f22196c.K(drawable);
    }

    public void setIsAloneTabContainer(boolean z5) {
        this.f22193C = z5;
    }

    public void setNeedCollapse(boolean z5) {
        this.f22199f = z5;
    }

    public void setTabSelected(int i5) {
        K(i5, false);
    }

    public void setTabsGravity(int i5) {
        this.f22207n = i5;
        d dVar = this.f22196c;
        if (dVar != null) {
            dVar.setGravity(i5);
        }
    }

    public void v(a.i iVar, boolean z5) {
        g gVarD = D(iVar, false);
        this.f22196c.addView(gVarD, new LinearLayoutCompat.a(-2, -1));
        Spinner spinner = this.f22197d;
        if (spinner != null) {
            ((e) spinner.getAdapter()).notifyDataSetChanged();
        }
        if (z5) {
            gVarD.setSelected(true);
            d dVar = this.f22196c;
            dVar.N(dVar.getChildCount() - 1, 0.0f);
        } else {
            gVarD.setSelected(false);
        }
        if (this.f22198e) {
            requestLayout();
        }
    }

    public void w(int i5) {
        View childAt = this.f22196c.getChildAt(i5);
        Runnable runnable = this.f22194a;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
        c cVar = new c(childAt, i5);
        this.f22194a = cVar;
        post(cVar);
    }

    public v(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, X4.a.f5834j);
    }

    public v(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.f22204k = new h();
        this.f22205l = 0;
        this.f22206m = false;
        this.f22207n = 17;
        this.f22191A = false;
        this.f22193C = false;
        setOverScrollMode(2);
        setHorizontalFadingEdgeEnabled(true);
        setFadingEdgeLength(getResources().getDimensionPixelSize(X4.d.f5910k));
        b5.a aVarB = b5.a.b(context);
        setContentHeight(aVarB.h());
        this.f22200g = aVarB.g();
        a0 a0VarV = a0.v(context, attributeSet, X4.l.f6123H3, i5, 0);
        this.f22209p = a0VarV.f(X4.l.f6129I3, getResources().getDimensionPixelSize(X4.d.f5913m));
        this.f22210q = a0VarV.f(X4.l.f6165O3, getResources().getDimensionPixelSize(X4.d.f5918r));
        this.f22211r = a0VarV.f(X4.l.f6135J3, getResources().getDimensionPixelSize(X4.d.f5914n));
        this.f22212s = a0VarV.f(X4.l.f6141K3, getResources().getDimensionPixelSize(X4.d.f5915o));
        this.f22213t = a0VarV.f(X4.l.f6159N3, getResources().getDimensionPixelSize(X4.d.f5916p));
        a0VarV.x();
        this.f22196c = C();
        int iD = N1.i.d(X4.a.f5826b, context);
        iD = iD == 0 ? H1.e.f2084f : iD;
        this.f22216w = context.getResources().getColor(iD);
        this.f22218y = context.getResources().getColor(iD);
        int iD2 = N1.i.d(X4.a.f5827c, context);
        this.f22217x = context.getResources().getColor(iD2 == 0 ? H1.e.f2087i : iD2);
        int iD3 = N1.i.d(X4.a.f5825a, context);
        this.f22219z = context.getResources().getColor(iD3 == 0 ? H1.e.f2081c : iD3);
        addView(this.f22196c, new ViewGroup.LayoutParams(-2, -1));
    }
}
