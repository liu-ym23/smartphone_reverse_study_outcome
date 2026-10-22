package t3;

import E.f;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.view.H;
import androidx.recyclerview.widget.RecyclerView;
import com.stepos.widget.list.StepOSListItem;
import h.C0744a;
import kotlin.ranges.l;

/* loaded from: classes.dex */
public final class j extends FrameLayout {

    /* renamed from: I, reason: collision with root package name */
    public static final a f22657I = new a(null);

    /* renamed from: A, reason: collision with root package name */
    private ViewParent f22658A;

    /* renamed from: B, reason: collision with root package name */
    private boolean f22659B;

    /* renamed from: C, reason: collision with root package name */
    private boolean f22660C;

    /* renamed from: D, reason: collision with root package name */
    private Boolean f22661D;

    /* renamed from: E, reason: collision with root package name */
    private View f22662E;

    /* renamed from: F, reason: collision with root package name */
    private int f22663F;

    /* renamed from: G, reason: collision with root package name */
    private boolean f22664G;

    /* renamed from: H, reason: collision with root package name */
    private int f22665H;

    /* renamed from: a, reason: collision with root package name */
    private boolean f22666a;

    /* renamed from: b, reason: collision with root package name */
    private View f22667b;

    /* renamed from: c, reason: collision with root package name */
    private final View[] f22668c;

    /* renamed from: d, reason: collision with root package name */
    private final ImageView[] f22669d;

    /* renamed from: e, reason: collision with root package name */
    private final int f22670e;

    /* renamed from: f, reason: collision with root package name */
    private final int f22671f;

    /* renamed from: g, reason: collision with root package name */
    private final float f22672g;

    /* renamed from: h, reason: collision with root package name */
    private final Path f22673h;

    /* renamed from: i, reason: collision with root package name */
    private final ViewConfiguration f22674i;

    /* renamed from: j, reason: collision with root package name */
    private final long f22675j;

    /* renamed from: k, reason: collision with root package name */
    private ValueAnimator f22676k;

    /* renamed from: l, reason: collision with root package name */
    private int f22677l;

    /* renamed from: m, reason: collision with root package name */
    private float f22678m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f22679n;

    /* renamed from: o, reason: collision with root package name */
    private d[] f22680o;

    /* renamed from: p, reason: collision with root package name */
    private VelocityTracker f22681p;

    /* renamed from: q, reason: collision with root package name */
    private float f22682q;

    /* renamed from: r, reason: collision with root package name */
    private float f22683r;

    /* renamed from: s, reason: collision with root package name */
    private float f22684s;

    /* renamed from: t, reason: collision with root package name */
    private float f22685t;

    /* renamed from: u, reason: collision with root package name */
    private boolean f22686u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f22687v;

    /* renamed from: w, reason: collision with root package name */
    private boolean f22688w;

    /* renamed from: x, reason: collision with root package name */
    private boolean f22689x;

    /* renamed from: y, reason: collision with root package name */
    private boolean f22690y;

    /* renamed from: z, reason: collision with root package name */
    private boolean f22691z;

    public static final class a {
        public /* synthetic */ a(j4.g gVar) {
            this();
        }

        private a() {
        }
    }

    public interface b {
    }

    public interface c {
    }

    public static abstract class d {
    }

    public static final class e extends androidx.customview.view.a {

        /* renamed from: a, reason: collision with root package name */
        private boolean f22693a;

        /* renamed from: b, reason: collision with root package name */
        public static final b f22692b = new b(null);
        public static final Parcelable.ClassLoaderCreator<e> CREATOR = new a();

        public static final class a implements Parcelable.ClassLoaderCreator<e> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public e createFromParcel(Parcel parcel) {
                j4.k.g(parcel, "source");
                return new e(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public e createFromParcel(Parcel parcel, ClassLoader classLoader) {
                j4.k.g(parcel, "source");
                return new e(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public e[] newArray(int i5) {
                return new e[i5];
            }
        }

        public static final class b {
            public /* synthetic */ b(j4.g gVar) {
                this();
            }

            private b() {
            }
        }

        public e(Parcelable parcelable) {
            super(parcelable == null ? androidx.customview.view.a.EMPTY_STATE : parcelable);
        }

        public final boolean a() {
            return this.f22693a;
        }

        public final void c(boolean z5) {
            this.f22693a = z5;
        }

        @Override // androidx.customview.view.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i5) {
            j4.k.g(parcel, "out");
            super.writeToParcel(parcel, i5);
            parcel.writeInt(this.f22693a ? 1 : 0);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            j4.k.g(parcel, "source");
            this.f22693a = parcel.readInt() != 0;
        }
    }

    public static final class f extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f22694a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ j f22695b;

        f(int i5, j jVar) {
            this.f22694a = i5;
            this.f22695b = jVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            j4.k.g(animator, "animation");
            if (this.f22694a == this.f22695b.f22677l) {
                this.f22695b.f22676k = null;
            }
            ((ValueAnimator) animator).removeAllUpdateListeners();
            animator.removeAllListeners();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x006a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void D(boolean r9, boolean r10) {
        /*
            r8 = this;
            r8.j()
            int r0 = r8.f22677l
            boolean r1 = r8.f22679n
            r2 = 1
            r3 = 0
            if (r1 == r9) goto Ld
            r1 = r2
            goto Le
        Ld:
            r1 = r3
        Le:
            r8.f22679n = r9
            r4 = 1065353216(0x3f800000, float:1.0)
            r5 = 0
            if (r9 == 0) goto L17
            r9 = r4
            goto L18
        L17:
            r9 = r5
        L18:
            r6 = 0
            if (r1 == 0) goto L24
            t3.j$d[] r1 = r8.f22680o
            int r7 = r1.length
            if (r7 > 0) goto L21
            goto L24
        L21:
            r8 = r1[r3]
            throw r6
        L24:
            r1 = 2
            if (r10 == 0) goto L6a
            boolean r10 = r8.isLaidOut()
            if (r10 == 0) goto L6a
            boolean r10 = android.animation.ValueAnimator.areAnimatorsEnabled()
            if (r10 == 0) goto L6a
            float r10 = r8.f22678m
            int r7 = (r10 > r9 ? 1 : (r10 == r9 ? 0 : -1))
            if (r7 != 0) goto L3a
            goto L6a
        L3a:
            float[] r1 = new float[r1]
            r1[r3] = r10
            r1[r2] = r9
            android.animation.ValueAnimator r9 = android.animation.ValueAnimator.ofFloat(r1)
            long r1 = r8.f22675j
            r9.setDuration(r1)
            android.view.animation.PathInterpolator r10 = new android.view.animation.PathInterpolator
            r1 = 1045220557(0x3e4ccccd, float:0.2)
            r10.<init>(r1, r5, r5, r4)
            r9.setInterpolator(r10)
            t3.i r10 = new t3.i
            r10.<init>()
            r9.addUpdateListener(r10)
            t3.j$f r10 = new t3.j$f
            r10.<init>(r0, r8)
            r9.addListener(r10)
            r8.f22676k = r9
            r9.start()
            goto L6d
        L6a:
            i(r8, r9, r3, r1, r6)
        L6d:
            r8.F()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: t3.j.D(boolean, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(int i5, j jVar, ValueAnimator valueAnimator) {
        j4.k.g(valueAnimator, "it");
        if (i5 == jVar.f22677l) {
            Object animatedValue = valueAnimator.getAnimatedValue();
            j4.k.e(animatedValue, "null cannot be cast to non-null type kotlin.Float");
            i(jVar, ((Float) animatedValue).floatValue(), false, 2, null);
        }
    }

    private final void F() {
        boolean z5 = isEnabled() && this.f22664G && this.f22665H > 0 && this.f22678m == 1.0f && !this.f22687v && this.f22667b != null;
        getAction().setEnabled(z5);
        int length = this.f22668c.length;
        for (int i5 = 0; i5 < length; i5++) {
            View view = this.f22668c[i5];
            boolean z6 = z5 && t(i5);
            view.setEnabled(z6);
            view.setClickable(z6);
            view.setFocusable(z6);
            if (!z6) {
                view.clearFocus();
            }
        }
        getAction().setImportantForAccessibility(z5 ? 1 : 4);
        if (!z5 && this.f22660C) {
            getAction().clearFocus();
        }
        this.f22660C = z5;
        Boolean boolValueOf = (isEnabled() && this.f22664G && this.f22665H > 0) ? Boolean.valueOf(this.f22679n) : null;
        if (this.f22662E == this.f22667b && j4.k.b(this.f22661D, boolValueOf)) {
            return;
        }
        View view2 = this.f22662E;
        if (view2 != null) {
            l(view2);
        }
        View view3 = this.f22667b;
        this.f22662E = view3;
        this.f22661D = boolValueOf;
        if (view3 == null || boolValueOf == null) {
            return;
        }
        String string = getContext().getString(boolValueOf.booleanValue() ? l3.k.f18474f : l3.k.f18477i);
        j4.k.f(string, "getString(...)");
        this.f22663F = H.b(view3, string, new E.f() { // from class: t3.h
            @Override // E.f
            public final boolean a(View view4, f.a aVar) {
                return j.G(this.f22654a, view4, aVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean G(j jVar, View view, f.a aVar) {
        j4.k.g(view, "<unused var>");
        if (!jVar.isEnabled() || !jVar.f22664G || jVar.f22665H <= 0) {
            return false;
        }
        if (jVar.u()) {
            n(jVar, false, 1, null);
        } else {
            x(jVar, false, 1, null);
        }
        return true;
    }

    private final void H() {
        int length = this.f22668c.length;
        int i5 = 0;
        int i6 = 0;
        while (true) {
            int i7 = 8;
            if (i6 >= length) {
                break;
            }
            View view = this.f22668c[i6];
            if (t(i6)) {
                i7 = 0;
            }
            view.setVisibility(i7);
            i6++;
        }
        View action = getAction();
        if (this.f22665H == 0) {
            i5 = 8;
        } else if (this.f22678m == 0.0f) {
            i5 = 4;
        }
        action.setVisibility(i5);
        F();
    }

    private final void c() {
        p();
        D(false, false);
    }

    private final void f() {
        ViewParent parent = getParent();
        if (parent == null || this.f22658A == parent) {
            return;
        }
        z();
        this.f22658A = parent;
        parent.requestDisallowInterceptTouchEvent(true);
    }

    private final void g(MotionEvent motionEvent) {
        i(this, l.g(this.f22684s + ((getOpeningSign() * ((motionEvent.getX() - this.f22682q) - this.f22685t)) / getRevealWidth()), 0.0f, 1.0f), false, 2, null);
    }

    private final View getAction() {
        throw null;
    }

    private final float getOpeningSign() {
        return getLayoutDirection() == 1 ? 1.0f : -1.0f;
    }

    private final float getRevealWidth() {
        return k.f22696a.c(this.f22665H, this.f22670e, this.f22671f);
    }

    private final void h(float f5, boolean z5) {
        boolean z6 = this.f22678m == f5;
        this.f22678m = f5;
        View view = this.f22667b;
        if (view != null) {
            view.setTranslationX(getOpeningSign() * getRevealWidth() * f5);
        }
        StepOSListItem contentListItem$StepOSWidget_release = getContentListItem$StepOSWidget_release();
        if (contentListItem$StepOSWidget_release != null) {
            contentListItem$StepOSWidget_release.setSwipeAppearanceActive$StepOSWidget_release(f5 > 0.0f);
        }
        getAction().setVisibility(this.f22665H == 0 ? 8 : f5 == 0.0f ? 4 : 0);
        F();
        invalidate();
        if (z6 || !z5) {
            return;
        }
        d[] dVarArr = this.f22680o;
        if (dVarArr.length <= 0) {
            return;
        }
        d dVar = dVarArr[0];
        throw null;
    }

    static /* synthetic */ void i(j jVar, float f5, boolean z5, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            z5 = true;
        }
        jVar.h(f5, z5);
    }

    private final void j() {
        this.f22677l++;
        ValueAnimator valueAnimator = this.f22676k;
        if (valueAnimator != null) {
            valueAnimator.removeAllUpdateListeners();
        }
        ValueAnimator valueAnimator2 = this.f22676k;
        if (valueAnimator2 != null) {
            valueAnimator2.removeAllListeners();
        }
        ValueAnimator valueAnimator3 = this.f22676k;
        if (valueAnimator3 != null) {
            valueAnimator3.cancel();
        }
        this.f22676k = null;
    }

    private final int k(int i5) {
        if (i5 >= 0 && i5 < 3) {
            return i5;
        }
        throw new IllegalArgumentException(("actionId must be ACTION_PRIMARY, ACTION_SECONDARY or ACTION_DELETE but was " + i5).toString());
    }

    private final void l(View view) {
        int i5;
        if (view != this.f22662E || (i5 = this.f22663F) == -1) {
            return;
        }
        H.d0(view, i5);
        this.f22663F = -1;
    }

    public static /* synthetic */ void n(j jVar, boolean z5, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            z5 = true;
        }
        jVar.m(z5);
    }

    private final void o(MotionEvent motionEvent) {
        if (this.f22687v || this.f22688w || this.f22689x) {
            return;
        }
        float x5 = motionEvent.getX() - this.f22682q;
        float y5 = motionEvent.getY() - this.f22683r;
        if (Math.abs(y5) > this.f22674i.getScaledTouchSlop() && Math.abs(y5) >= Math.abs(x5)) {
            this.f22688w = true;
            return;
        }
        if (Math.abs(x5) <= this.f22674i.getScaledTouchSlop() || Math.abs(x5) <= Math.abs(y5)) {
            return;
        }
        if (this.f22678m != 0.0f || getOpeningSign() * x5 > 0.0f) {
            this.f22687v = true;
            this.f22685t = Math.signum(x5) * this.f22674i.getScaledTouchSlop();
            View view = this.f22667b;
            if (view != null) {
                view.setPressed(false);
            }
            for (View view2 : this.f22668c) {
                view2.setPressed(false);
            }
            f();
            F();
            d[] dVarArr = this.f22680o;
            if (dVarArr.length <= 0) {
                return;
            }
            d dVar = dVarArr[0];
            throw null;
        }
    }

    private final void p() {
        VelocityTracker velocityTracker = this.f22681p;
        if (velocityTracker != null) {
            velocityTracker.recycle();
        }
        this.f22681p = null;
        this.f22691z = false;
        this.f22687v = false;
        this.f22690y = false;
        z();
        F();
    }

    private final boolean s(float f5, float f6) {
        if (this.f22678m == 1.0f) {
            for (View view : this.f22668c) {
                if (view.getVisibility() == 0 && f5 >= getAction().getLeft() + r4.getLeft() && f5 < getAction().getLeft() + r4.getRight() && f6 >= getAction().getTop() + r4.getTop() && f6 < getAction().getTop() + r4.getBottom()) {
                    return true;
                }
            }
        }
        return false;
    }

    private final boolean t(int i5) {
        return k.f22696a.a(i5, this.f22665H);
    }

    public static /* synthetic */ void x(j jVar, boolean z5, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            z5 = true;
        }
        jVar.w(z5);
    }

    private final Drawable y(Drawable drawable) {
        Drawable.ConstantState constantState;
        Drawable drawableNewDrawable;
        if (drawable != null && (constantState = drawable.getConstantState()) != null && (drawableNewDrawable = constantState.newDrawable(getResources(), getContext().getTheme())) != null) {
            drawable = drawableNewDrawable;
        }
        if (drawable != null) {
            return drawable.mutate();
        }
        return null;
    }

    private final void z() {
        ViewParent viewParent = this.f22658A;
        if (viewParent == null) {
            return;
        }
        this.f22658A = null;
        viewParent.requestDisallowInterceptTouchEvent(false);
    }

    public final StepOSListItem A() {
        int childAdapterPosition;
        StepOSListItem contentListItem$StepOSWidget_release;
        ViewParent parent = getParent();
        RecyclerView recyclerView = parent instanceof RecyclerView ? (RecyclerView) parent : null;
        if (recyclerView == null || (childAdapterPosition = recyclerView.getChildAdapterPosition(this)) <= 0) {
            return null;
        }
        RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition = recyclerView.findViewHolderForAdapterPosition(childAdapterPosition - 1);
        View view = viewHolderFindViewHolderForAdapterPosition != null ? viewHolderFindViewHolderForAdapterPosition.itemView : null;
        j jVar = view instanceof j ? (j) view : null;
        if (jVar != null && (contentListItem$StepOSWidget_release = jVar.getContentListItem$StepOSWidget_release()) != null) {
            return contentListItem$StepOSWidget_release;
        }
        if (view instanceof StepOSListItem) {
            return (StepOSListItem) view;
        }
        return null;
    }

    public final void B(int i5, CharSequence charSequence) {
        k(i5);
        int i6 = i5 != 0 ? i5 != 1 ? l3.k.f18473e : l3.k.f18476h : l3.k.f18475g;
        View view = this.f22668c[i5];
        if (charSequence == null) {
            charSequence = getContext().getText(i6);
            j4.k.f(charSequence, "getText(...)");
        }
        view.setContentDescription(charSequence);
    }

    public final void C(int i5, Drawable drawable) {
        this.f22669d[k(i5)].setImageDrawable(y(drawable));
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i5, ViewGroup.LayoutParams layoutParams) {
        j4.k.g(view, "child");
        j4.k.g(layoutParams, "params");
        boolean z5 = this.f22666a;
        if (!z5 && this.f22667b != null) {
            throw new IllegalStateException("StepOSSwipeActionLayout supports exactly one content child");
        }
        if (!z5) {
            i5 = -1;
        }
        super.addView(view, i5, layoutParams);
        if (this.f22666a) {
            return;
        }
        this.f22667b = view;
        h(this.f22678m, false);
        F();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        j4.k.g(motionEvent, "event");
        if (motionEvent.getActionMasked() == 0 && isEnabled() && this.f22664G && this.f22665H > 0) {
            VelocityTracker velocityTracker = this.f22681p;
            if (velocityTracker != null) {
                velocityTracker.recycle();
            }
            this.f22681p = VelocityTracker.obtain();
            this.f22682q = motionEvent.getX();
            this.f22683r = motionEvent.getY();
            float f5 = this.f22678m;
            this.f22684s = f5;
            this.f22686u = this.f22679n;
            this.f22687v = false;
            this.f22688w = false;
            this.f22689x = false;
            this.f22691z = true;
            this.f22690y = f5 > 0.0f && !s(motionEvent.getX(), motionEvent.getY());
            j();
        }
        VelocityTracker velocityTracker2 = this.f22681p;
        if (velocityTracker2 != null) {
            velocityTracker2.addMovement(motionEvent);
        }
        if (this.f22691z && motionEvent.getActionMasked() == 5) {
            this.f22689x = true;
            this.f22687v = false;
            D(this.f22686u, true);
            z();
        }
        boolean zDispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (motionEvent.getActionMasked() != 1 && motionEvent.getActionMasked() != 3) {
            return zDispatchTouchEvent;
        }
        if (this.f22691z && motionEvent.getActionMasked() == 3) {
            D(this.f22686u, true);
        } else if (this.f22691z && this.f22676k == null) {
            float f6 = this.f22678m;
            boolean z5 = this.f22679n;
            if (f6 != (z5 ? 1.0f : 0.0f)) {
                D(z5, true);
            }
        }
        p();
        return zDispatchTouchEvent;
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j5) {
        j4.k.g(canvas, "canvas");
        j4.k.g(view, "child");
        if (view != this.f22667b || this.f22678m <= 0.0f) {
            if (view != getAction()) {
                return super.drawChild(canvas, view, j5);
            }
            int iSave = canvas.save();
            float paddingLeft = getOpeningSign() > 0.0f ? getPaddingLeft() : getWidth() - getPaddingRight();
            if (getOpeningSign() > 0.0f) {
                canvas.clipRect(paddingLeft, 0.0f, (getRevealWidth() * this.f22678m) + paddingLeft, getHeight());
            } else {
                canvas.clipRect(paddingLeft - (getRevealWidth() * this.f22678m), 0.0f, paddingLeft, getHeight());
            }
            boolean zDrawChild = super.drawChild(canvas, view, j5);
            canvas.restoreToCount(iSave);
            return zDrawChild;
        }
        int iSave2 = canvas.save();
        this.f22673h.rewind();
        float left = view.getLeft() + view.getTranslationX();
        float top = view.getTop() + view.getTranslationY();
        float f5 = this.f22672g;
        this.f22673h.addRoundRect(left, top, left + view.getWidth(), top + view.getHeight(), f5, f5, Path.Direction.CW);
        canvas.clipPath(this.f22673h);
        boolean zDrawChild2 = super.drawChild(canvas, view, j5);
        canvas.restoreToCount(iSave2);
        return zDrawChild2;
    }

    public final StepOSListItem getContentListItem$StepOSWidget_release() {
        View view = this.f22667b;
        if (view instanceof StepOSListItem) {
            return (StepOSListItem) view;
        }
        return null;
    }

    public final int getSwipeActionCount() {
        return this.f22665H;
    }

    public final Drawable getSwipeDeleteBackground() {
        throw null;
    }

    public final CharSequence getSwipeDeleteContentDescription() {
        return q(2);
    }

    public final Drawable getSwipeDeleteIcon() {
        throw null;
    }

    public final ColorStateList getSwipeDeleteIconTint() {
        throw null;
    }

    public final CharSequence getSwipePrimaryContentDescription() {
        return q(0);
    }

    public final Drawable getSwipePrimaryIcon() {
        return r(0);
    }

    public final CharSequence getSwipeSecondaryContentDescription() {
        return q(1);
    }

    public final Drawable getSwipeSecondaryIcon() {
        return r(1);
    }

    public final void m(boolean z5) {
        p();
        D(false, z5);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        F();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.f22680o = new d[0];
        c();
        View view = this.f22662E;
        if (view != null) {
            l(view);
        }
        this.f22662E = null;
        this.f22661D = null;
        super.onDetachedFromWindow();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        j4.k.g(motionEvent, "event");
        if (!this.f22691z || !isEnabled() || !this.f22664G) {
            return false;
        }
        if (this.f22689x) {
            return true;
        }
        if (motionEvent.getActionMasked() == 2) {
            o(motionEvent);
            if (this.f22687v) {
                g(motionEvent);
            }
        }
        return this.f22687v || this.f22690y;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z5, int i5, int i6, int i7, int i8) {
        super.onLayout(z5, i5, i6, i7, i8);
        View view = this.f22667b;
        if (view != null) {
            view.setTranslationX(getOpeningSign() * getRevealWidth() * this.f22678m);
        }
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof e)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        e eVar = (e) parcelable;
        super.onRestoreInstanceState(eVar.getSuperState());
        j();
        boolean z5 = eVar.a() && isEnabled() && this.f22664G && this.f22665H > 0;
        this.f22679n = z5;
        h(z5 ? 1.0f : 0.0f, false);
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i5) {
        super.onRtlPropertiesChanged(i5);
        if (this.f22659B) {
            p();
            D(this.f22679n, false);
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        e eVar = new e(super.onSaveInstanceState());
        eVar.c(this.f22679n);
        return eVar;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        j4.k.g(motionEvent, "event");
        if (!this.f22691z) {
            return super.onTouchEvent(motionEvent);
        }
        if (!this.f22689x) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    o(motionEvent);
                    if (this.f22687v) {
                        g(motionEvent);
                    }
                }
            } else if (this.f22687v) {
                VelocityTracker velocityTracker = this.f22681p;
                if (velocityTracker != null) {
                    velocityTracker.computeCurrentVelocity(1000, this.f22674i.getScaledMaximumFlingVelocity());
                }
                VelocityTracker velocityTracker2 = this.f22681p;
                float xVelocity = (velocityTracker2 != null ? velocityTracker2.getXVelocity() : 0.0f) * getOpeningSign();
                VelocityTracker velocityTracker3 = this.f22681p;
                boolean zB = k.f22696a.b(this.f22678m, xVelocity, Math.abs(velocityTracker3 != null ? velocityTracker3.getYVelocity() : 0.0f), this.f22674i.getScaledMinimumFlingVelocity());
                this.f22687v = false;
                D(zB, true);
            } else if (this.f22690y && !this.f22688w) {
                performClick();
            }
        }
        return true;
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        j4.k.g(view, "child");
        super.onViewRemoved(view);
        if (view != this.f22667b) {
            return;
        }
        StepOSListItem contentListItem$StepOSWidget_release = getContentListItem$StepOSWidget_release();
        if (contentListItem$StepOSWidget_release != null) {
            contentListItem$StepOSWidget_release.setSwipeAppearanceActive$StepOSWidget_release(false);
        }
        view.setTranslationX(0.0f);
        l(view);
        this.f22667b = null;
        c();
    }

    @Override // android.view.View
    public boolean performClick() {
        super.performClick();
        n(this, false, 1, null);
        return true;
    }

    public final CharSequence q(int i5) {
        return this.f22668c[k(i5)].getContentDescription();
    }

    public final Drawable r(int i5) {
        return this.f22669d[k(i5)].getDrawable();
    }

    @Override // android.view.View
    public void setEnabled(boolean z5) {
        super.setEnabled(z5);
        if (this.f22659B) {
            if (!z5) {
                c();
            }
            F();
        }
    }

    public final void setOnActionClickListener(b bVar) {
    }

    public final void setOnDeleteClickListener(c cVar) {
    }

    public final void setSwipeActionCount(int i5) {
        if (i5 < 0 || i5 >= 4) {
            throw new IllegalArgumentException(("swipeActionCount must be in 0..3 but was " + i5).toString());
        }
        if (this.f22665H == i5) {
            return;
        }
        this.f22665H = i5;
        c();
        H();
        requestLayout();
    }

    public final void setSwipeDeleteBackground(Drawable drawable) {
        throw null;
    }

    public final void setSwipeDeleteBackgroundResource(int i5) {
        setSwipeDeleteBackground(i5 == 0 ? null : C0744a.b(getContext(), i5));
    }

    public final void setSwipeDeleteContentDescription(CharSequence charSequence) {
        B(2, charSequence);
    }

    public final void setSwipeDeleteContentDescriptionResource(int i5) {
        setSwipeDeleteContentDescription(i5 == 0 ? null : getContext().getText(i5));
    }

    public final void setSwipeDeleteIcon(Drawable drawable) {
        throw null;
    }

    public final void setSwipeDeleteIconResource(int i5) {
        setSwipeDeleteIcon(i5 == 0 ? null : C0744a.b(getContext(), i5));
    }

    public final void setSwipeDeleteIconTint(ColorStateList colorStateList) {
        throw null;
    }

    public final void setSwipeDeleteIconTintResource(int i5) {
        setSwipeDeleteIconTint(i5 == 0 ? null : C0744a.a(getContext(), i5));
    }

    public final void setSwipeEnabled(boolean z5) {
        if (this.f22664G == z5) {
            return;
        }
        this.f22664G = z5;
        if (!z5) {
            c();
        }
        F();
    }

    public final void setSwipePrimaryContentDescription(CharSequence charSequence) {
        B(0, charSequence);
    }

    public final void setSwipePrimaryIcon(Drawable drawable) {
        C(0, drawable);
    }

    public final void setSwipeSecondaryContentDescription(CharSequence charSequence) {
        B(1, charSequence);
    }

    public final void setSwipeSecondaryIcon(Drawable drawable) {
        C(1, drawable);
    }

    public final boolean u() {
        return this.f22679n;
    }

    public final void v() {
        ViewParent parent = getParent();
        RecyclerView recyclerView = parent instanceof RecyclerView ? (RecyclerView) parent : null;
        if (recyclerView != null) {
            recyclerView.invalidate();
        }
    }

    public final void w(boolean z5) {
        if (!isEnabled() || !this.f22664G) {
            throw new IllegalStateException("Enable the view and steposSwipeEnabled before open()");
        }
        if (this.f22665H <= 0) {
            throw new IllegalStateException("Set swipeActionCount to 1, 2 or 3 before open()");
        }
        if (this.f22667b == null) {
            throw new IllegalStateException("Add exactly one content child before open()");
        }
        p();
        D(true, z5);
    }
}
