package com.bytedance.android.livesdk.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.OverScroller;
import androidx.core.content.ContextCompat;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewGroupCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdk.utils.t6;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes11.dex */
public class TTLiveResolverDrawerLayout extends ViewGroup implements NestedScrollingParent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f161308a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f161309b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f161310c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f161311d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f161312e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f161313f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f161314g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f161315h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f161316i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f161317j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f161318k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f161319l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f161320m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final float f161321n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final OverScroller f161322o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public VelocityTracker f161323p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Drawable f161324q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f161325r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f161326s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public float f161327t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f161328u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Rect f161329v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final a f161330w;

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f161331a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f161332b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f161333c;

        public LayoutParams() {
            super(-1, -2);
        }

        public LayoutParams(LayoutParams r100) {
            super(r100);
            this.f161331a = r100.f161331a;
            this.f161332b = r100.f161332b;
            this.f161333c = r100.f161333c;
        }

        public LayoutParams(ViewGroup.LayoutParams r100) {
            super(r100);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams r100) {
            super(r100);
        }

        public LayoutParams(Context r100, AttributeSet r101) {
            super(r100, r101);
            TypedArray r102 = r100.obtainStyledAttributes(r101, new int[]{R.attr.tt_rwl_layout_alwaysShow, R.attr.tt_rwl_layout_hasNestedScrollIndicator, R.attr.tt_rwl_layout_ignoreOffset});
            this.f161331a = r102.getBoolean(0, false);
            this.f161332b = r102.getBoolean(2, false);
            this.f161333c = r102.getBoolean(1, false);
            r102.recycle();
        }
    }

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f161334a;

        public class a implements Parcelable.Creator<SavedState> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final SavedState createFromParcel(Parcel r100) {
                return new SavedState(r100);
            }

            @Override // android.os.Parcelable.Creator
            public final SavedState[] newArray(int r100) {
                return new SavedState[r100];
            }
        }

        static {
            CREATOR = new a();
        }

        public SavedState(Parcel r100) {
            super(r100);
            if (r100.readInt() == 0) goto L5;
            boolean r101 = true;
        L6:
            this.f161334a = r101;
            return;
        L5:
            r101 = false;
            goto L6
        }

        public SavedState(Parcelable r100) {
            super(r100);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel r100, int r101) {
            super.writeToParcel(r100, r101);
            r100.writeInt(this.f161334a ? 1 : 0);
        }
    }

    public class a implements ViewTreeObserver.OnTouchModeChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TTLiveResolverDrawerLayout f161335a;

        public a(TTLiveResolverDrawerLayout r100) {
            this.f161335a = r100;
        }

        @Override // android.view.ViewTreeObserver.OnTouchModeChangeListener
        public final void onTouchModeChanged(boolean r100) {
            if (r100 == false) goto L4;
            return;
        L4:
            if (this.f161335a.hasFocus() == false) goto L10;
            TTLiveResolverDrawerLayout r101 = this.f161335a;
            if (r101.c(r101.getFocusedChild()) == false) goto L11;
            this.f161335a.g(0, 0.0f);
            return;
        L11:
            return;
        }
    }

    public interface b {
    }

    public final void f() {
        this.f161328u = -1;
        this.f161317j = false;
        this.f161318k = false;
        this.f161327t = 0.0f;
        this.f161326s = 0.0f;
        this.f161325r = 0.0f;
        VelocityTracker r100 = this.f161323p;
        if (r100 == null) goto L6;
        r100.clear();
        return;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final boolean onStartNestedScroll(View r100, View r101, int r102) {
        if ((r102 & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public void setOnDismissedListener(b r100) {
    }

    private int getMaxCollapsedHeight() {
        if (this.f161311d == false) goto L5;
        int r100 = this.f161310c;
    L7:
        return r100 + this.f161315h;
    L5:
        r100 = this.f161309b;
        goto L7
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        SavedState r100 = new SavedState(super.onSaveInstanceState());
        if (this.f161313f > 0) goto L5;
    L7:
        boolean r101 = false;
    L8:
        r100.f161334a = r101;
        return r100;
    L5:
        if (this.f161312e != 0.0f) goto L7;
        r101 = true;
        goto L8
    }

    @Override // android.view.View
    public final void computeScroll() {
        super.computeScroll();
        if (this.f161322o.computeScrollOffset() == false) goto L7;
        boolean r100 = !this.f161322o.isFinished();
        e((int) (this.f161322o.getCurrY() - this.f161312e));
        if (r100 == false) goto L9;
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    L9:
        return;
    L7:
        this.f161322o.isFinished();
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return super.getNestedScrollAxes();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnTouchModeChangeListener(this.f161330w);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnTouchModeChangeListener(this.f161330w);
        this.f161322o.abortAnimation();
        VelocityTracker r100 = this.f161323p;
        if (r100 == null) goto L6;
        r100.recycle();
        this.f161323p = null;
        return;
    }

    public TTLiveResolverDrawerLayout(Context r100) {
        this(r100, null);
    }

    public static int b(View r100) {
        int r101 = r100.getMeasuredHeight();
        if ((r100 instanceof AbsListView) == false) goto L12;
        AbsListView r102 = (AbsListView) r100;
        int r103 = r102.getPaddingBottom();
        int r104 = r102.getChildCount();
        int r105 = 0;
        int r106 = 0;
    L5:
        if (r105 >= r104) goto L10;
        int r107 = r102.getChildAt(r105).getBottom() + r103;
        if (r107 <= r106) goto L9;
        r106 = r107;
    L9:
        r105 = r105 + 1;
        goto L5
    L10:
        if (r106 >= r101) goto L12;
        r101 = r106;
    L12:
        LayoutParams r108 = (LayoutParams) r100.getLayoutParams();
        return (((ViewGroup.MarginLayoutParams) r108).topMargin + r101) + ((ViewGroup.MarginLayoutParams) r108).bottomMargin;
    }

    public final boolean c(View r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        this.f161329v.set(0, 0, r100.getWidth(), r100.getHeight());
        offsetDescendantRectToMyCoords(r100, this.f161329v);
        if (r100.getParent() == this) goto L11;
        ViewParent r101 = r100.getParent();
    L9:
        if (r101 == this) goto L11;
        r100 = r101;
        r101 = r100.getParent();
    L11:
        int r102 = getHeight() - getPaddingBottom();
        int r103 = getChildCount();
        int r104 = indexOfChild(r100) + 1;
    L12:
        if (r104 >= r103) goto L19;
        View r105 = getChildAt(r104);
        if (r105.getVisibility() == 8) goto L17;
        r102 = Math.min(r102, r105.getTop());
    L17:
        r104 = r104 + 1;
        goto L12
    L19:
        if (this.f161329v.bottom <= r102) goto L26;
        return true;
    L26:
        return false;
    }

    public final void d(MotionEvent r100) {
        int r101 = r100.getActionIndex();
        if (r100.getPointerId(r101) != this.f161328u) goto L9;
        if (r101 != 0) goto L6;
        int r102 = 1;
    L7:
        this.f161325r = r100.getX(r102);
        float r103 = r100.getY(r102);
        this.f161327t = r103;
        this.f161326s = r103;
        this.f161328u = r100.getPointerId(r102);
        return;
    L6:
        r102 = 0;
        goto L7
    }

    public final float e(int r100) {
        float r101 = Math.max(0.0f, Math.min(this.f161312e + r100, this.f161313f + this.f161314g));
        float r102 = this.f161312e;
        if (r101 == r102) goto L23;
        int r103 = (int) (r101 - r102);
        int r104 = getChildCount();
        boolean r105 = false;
        int r106 = 0;
    L5:
        if (r106 >= r104) goto L11;
        View r107 = getChildAt(r106);
        if (((LayoutParams) r107.getLayoutParams()).f161332b == true) goto L9;
        r107.offsetTopAndBottom(r103);
    L9:
        r106 = r106 + 1;
        goto L5
    L11:
        if (this.f161312e == 0.0f) goto L13;
        boolean r108 = true;
    L14:
        this.f161312e = r101;
        this.f161316i += r103;
        if (r101 == 0.0f) goto L17;
        r105 = true;
    L17:
        if (r108 != r105) goto L19;
    L21:
        ViewCompat.postInvalidateOnAnimation(this);
        return r103;
    L19:
        if (this.f161324q == null) goto L21;
        setWillNotDraw(!r105);
        goto L21
    L13:
        r108 = false;
        goto L14
    L23:
        return 0.0f;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r100) {
        if ((r100 instanceof LayoutParams) == false) goto L7;
        return new LayoutParams((LayoutParams) r100);
    L7:
        if ((r100 instanceof ViewGroup.MarginLayoutParams) == false) goto L11;
        return new LayoutParams((ViewGroup.MarginLayoutParams) r100);
    L11:
        return new LayoutParams(r100);
    }

    @Override // android.view.View
    public final void onDrawForeground(Canvas r100) {
        Drawable r101 = this.f161324q;
        if (r101 == null) goto L5;
        r101.draw(r100);
    L5:
        super.onDrawForeground(r100);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        int r101 = r100.getActionMasked();
        if (this.f161323p != null) goto L5;
        this.f161323p = VelocityTracker.obtain();
    L5:
        if (r101 != 0) goto L7;
        this.f161323p.clear();
    L7:
        this.f161323p.addMovement(r100);
        if (r101 == 0) goto L26;
        if (r101 != 1) goto L11;
    L25:
        f();
    L47:
        if (this.f161317j == false) goto L50;
        this.f161322o.abortAnimation();
    L50:
        if (this.f161317j == false) goto L52;
    L53:
        return true;
    L52:
        if (this.f161318k == true) goto L53;
        return false;
    L11:
        if (r101 != 2) goto L13;
        float r102 = r100.getX();
        float r103 = r100.getY();
        float r104 = r103 - this.f161326s;
        if (Math.abs(r104) <= this.f161320m) goto L47;
        if (a(this, r102, r103) == null) goto L47;
        if ((ViewGroupCompat.getNestedScrollAxes(this) & 2) != 0) goto L47;
        this.f161328u = r100.getPointerId(0);
        this.f161317j = true;
        float r105 = this.f161327t;
        float r106 = this.f161320m;
        this.f161327t = Math.max(r105 - r106, Math.min(r104 + r105, r105 + r106));
        goto L47
    L13:
        if (r101 == 3) goto L25;
        if (r101 != 6) goto L47;
        d(r100);
        goto L47
    L26:
        float r107 = r100.getX();
        float r108 = r100.getY();
        this.f161325r = r107;
        this.f161327t = r108;
        this.f161326s = r108;
        View r109 = a(this, r107, r108);
    L27:
        if (r109 == null) goto L35;
        r107 = r107 - r109.getX();
        r108 = r108 - r109.getY();
        if ((r109 instanceof AbsListView) == true) goto L30;
        if ((r109 instanceof ViewGroup) == true) goto L33;
        r109 = null;
        goto L27
    L33:
        r109 = a((ViewGroup) r109, r107, r108);
        goto L27
    L30:
        r109 = a((ViewGroup) r109, r107, r108);
    L35:
        if (r109 != null) goto L37;
    L39:
        boolean r110 = false;
    L40:
        if (r110 == true) goto L42;
    L44:
        boolean r111 = false;
    L45:
        this.f161318k = r111;
        goto L47
    L42:
        if (this.f161313f <= 0) goto L44;
        r111 = true;
        goto L45
    L37:
        if (c(r109) == false) goto L39;
        r110 = true;
        goto L40
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable r100) {
        SavedState r101 = (SavedState) r100;
        super.onRestoreInstanceState(r101.getSuperState());
        this.f161319l = r101.f161334a;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final void onStopNestedScroll(View r100) {
        super.onStopNestedScroll(r100);
        if (this.f161322o.isFinished() == false) goto L9;
        float r101 = this.f161312e;
        int r102 = this.f161313f;
        if (r101 >= (r102 / 2)) goto L7;
        r102 = 0;
    L7:
        g(r102, 0.0f);
        return;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        int r101 = r100.getActionMasked();
        if (this.f161323p != null) goto L5;
        this.f161323p = VelocityTracker.obtain();
    L5:
        this.f161323p.addMovement(r100);
        boolean r102 = true;
        int r103 = 0;
        if (r101 != 0) goto L8;
        float r104 = r100.getX();
        float r105 = r100.getY();
        this.f161325r = r104;
        this.f161327t = r105;
        this.f161326s = r105;
        this.f161328u = r100.getPointerId(0);
        if (a(this, this.f161325r, this.f161326s) == null) goto L72;
        boolean r106 = true;
    L74:
        if (this.f161313f <= 0) goto L76;
        boolean r107 = true;
    L77:
        if (r106 == false) goto L80;
        if (r107 == false) goto L80;
    L81:
        this.f161317j = r102;
        this.f161322o.abortAnimation();
        return r107;
    L80:
        r102 = false;
        goto L81
    L76:
        r107 = false;
        goto L77
    L72:
        r106 = false;
        goto L74
    L8:
        if (r101 != 1) goto L10;
        boolean r108 = this.f161317j;
        this.f161317j = false;
        if (r108 == true) goto L50;
        if (a(this, this.f161325r, this.f161326s) != null) goto L50;
        a(this, r100.getX(), r100.getY());
    L50:
        if (this.f161318k == true) goto L52;
    L57:
        this.f161323p.computeCurrentVelocity(1000);
        float r109 = this.f161323p.getYVelocity(this.f161328u);
        if (Math.abs(r109) > this.f161321n) goto L60;
        float r110 = this.f161312e;
        int r111 = this.f161313f;
        if (r110 >= (r111 / 2)) goto L67;
        r111 = 0;
    L67:
        g(r111, 0.0f);
    L68:
        f();
        return false;
    L60:
        if (r109 >= 0.0f) goto L62;
        int r112 = 0;
    L63:
        g(r112, r109);
        goto L68
    L62:
        r112 = this.f161313f;
        goto L63
    L52:
        if (Math.abs(r100.getX() - this.f161325r) >= this.f161320m) goto L57;
        if (Math.abs(r100.getY() - this.f161326s) >= this.f161320m) goto L57;
        g(0, 0.0f);
        return true;
    L10:
        if (r101 != 2) goto L12;
        int r113 = r100.findPointerIndex(this.f161328u);
        if (r113 >= 0) goto L32;
        this.f161328u = r100.getPointerId(0);
        this.f161325r = r100.getX();
        float r114 = r100.getY();
        this.f161327t = r114;
        this.f161326s = r114;
        r113 = 0;
    L32:
        float r115 = r100.getX(r113);
        float r116 = r100.getY(r113);
        if (this.f161317j == true) goto L39;
        float r117 = r116 - this.f161326s;
        if (Math.abs(r117) <= this.f161320m) goto L39;
        if (a(this, r115, r116) == null) goto L39;
        this.f161317j = true;
        float r118 = this.f161327t;
        float r119 = this.f161320m;
        this.f161327t = Math.max(r118 - r119, Math.min(r117 + r118, r118 + r119));
    L41:
        if (this.f161317j == false) goto L43;
        e((int) (r116 - this.f161327t));
    L43:
        this.f161327t = r116;
        return r102;
    L39:
        r102 = false;
        goto L41
    L12:
        if (r101 == 3) goto L21;
        if (r101 != 5) goto L16;
        int r120 = r100.getActionIndex();
        this.f161328u = r100.getPointerId(r120);
        this.f161325r = r100.getX(r120);
        float r121 = r100.getY(r120);
        this.f161327t = r121;
        this.f161326s = r121;
        return false;
    L16:
        if (r101 != 6) goto L87;
        d(r100);
        return false;
    L87:
        return false;
    L21:
        if (this.f161317j == false) goto L27;
        float r122 = this.f161312e;
        int r123 = this.f161313f;
        if (r122 < (r123 / 2)) goto L26;
        r103 = r123;
    L26:
        g(r103, 0.0f);
    L27:
        f();
        return true;
    }

    public void setCollapsed(boolean r100) {
        if (ViewCompat.isLaidOut(this) == true) goto L5;
        this.f161319l = r100;
        return;
    L5:
        if (r100 == false) goto L7;
        int r101 = this.f161313f;
    L8:
        g(r101, 0.0f);
        return;
    L7:
        r101 = 0;
        goto L8
    }

    public void setCollapsibleHeightReserved(int r100) {
        int r101 = this.f161315h;
        this.f161315h = r100;
        int r102 = r100 - r101;
        if (r102 != 0) goto L5;
    L7:
        int r103 = this.f161313f;
        this.f161313f = Math.max(r103, getMaxCollapsedHeight());
        if (this.f161317j == false) goto L10;
    L13:
        boolean r104 = true;
    L15:
        if (h(r103, !r104) == false) goto L17;
        return;
    L17:
        invalidate();
        return;
    L10:
        if (ViewGroupCompat.getNestedScrollAxes(this) == 2) goto L13;
        r104 = false;
        goto L15
    L5:
        if (this.f161317j == false) goto L7;
        this.f161327t -= r102;
        goto L7
    }

    public void setSmallCollapsed(boolean r100) {
        this.f161311d = r100;
        requestLayout();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet r100) {
        return new LayoutParams(getContext(), r100);
    }

    public TTLiveResolverDrawerLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public final void g(int r110, float r111) {
        this.f161322o.abortAnimation();
        int r100 = (int) this.f161312e;
        int r101 = r110 - r100;
        int r112 = getHeight();
        int r102 = r112 / 2;
        float r113 = r112;
        float r103 = r102;
        float r104 = r103 + (((float) Math.sin((float) (((double) (Math.min(1.0f, (Math.abs(r101) * 1.0f) / r113) - 0.5f)) * 0.4712389167638204d))) * r103);
        float r114 = Math.abs(r111);
        if (r114 <= 0.0f) goto L5;
        int r115 = Math.round(Math.abs(r104 / r114) * 1000.0f) * 4;
    L6:
        this.f161322o.startScroll(0, r100, 0, r101, Math.min(r115, 300));
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    L5:
        r115 = (int) (((Math.abs(r101) / r113) + 1.0f) * 100.0f);
        goto L6
    }

    public final boolean h(int r100, boolean r101) {
        boolean r102 = false;
        if (r100 != this.f161313f) goto L5;
        return false;
    L5:
        float r103 = 0.0f;
        if (ViewCompat.isLaidOut(this) == false) goto L26;
        float r104 = this.f161312e;
        if (r104 == 0.0f) goto L10;
        boolean r105 = true;
    L11:
        if (r101 == false) goto L17;
        int r106 = this.f161313f;
        if (r100 >= r106) goto L17;
        if (r104 != r100) goto L17;
        this.f161312e = r106;
    L19:
        if (this.f161312e == 0.0f) goto L21;
        r102 = true;
    L21:
        if (r105 != r102) goto L23;
    L30:
        return true;
    L23:
        if (this.f161324q == null) goto L30;
        setWillNotDraw(!r102);
    L17:
        this.f161312e = Math.min(r104, this.f161313f);
        goto L19
    L10:
        r105 = false;
        goto L11
    L26:
        if (this.f161319l == true) goto L29;
        r103 = this.f161313f;
    L29:
        this.f161312e = r103;
        goto L30
    }

    @Override // android.view.View
    public final void onMeasure(int r210, int r211) {
        int r100 = View.MeasureSpec.getSize(r210);
        int r101 = View.MeasureSpec.getSize(r211);
        int r102 = this.f161308a;
        if (r102 < 0) goto L5;
        int r103 = Math.min(r100, r102);
    L6:
        int r104 = View.MeasureSpec.makeMeasureSpec(r103, 1073741824);
        int r110 = View.MeasureSpec.makeMeasureSpec(r101, 1073741824);
        int r111 = getPaddingLeft() + getPaddingRight();
        int r105 = getPaddingTop() + getPaddingBottom();
        int r112 = getChildCount();
        int r113 = r105;
        int r114 = 0;
    L7:
        int r106 = 8;
        if (r114 >= r112) goto L15;
        View r115 = getChildAt(r114);
        if (((LayoutParams) r115.getLayoutParams()).f161331a == false) goto L14;
        if (r115.getVisibility() == 8) goto L14;
        measureChildWithMargins(r115, r104, r111, r110, r113);
        r113 = r113 + b(r115);
    L14:
        r114 = r114 + 1;
        goto L7
    L15:
        int r116 = r113;
        int r117 = 0;
    L16:
        if (r117 >= r112) goto L24;
        View r118 = getChildAt(r117);
        if (((LayoutParams) r118.getLayoutParams()).f161331a == true) goto L23;
        if (r118.getVisibility() == r106) goto L23;
        measureChildWithMargins(r118, r104, r111, r110, r116);
        r116 = r116 + b(r118);
    L23:
        r117 = r117 + 1;
        r106 = 8;
        goto L16
    L24:
        int r107 = this.f161313f;
        int r108 = Math.max(0, (r116 - r113) - getMaxCollapsedHeight());
        this.f161313f = r108;
        this.f161314g = r116 - r108;
        if (this.f161317j == false) goto L27;
    L30:
        boolean r109 = true;
    L31:
        h(r107, !r109);
        this.f161316i = Math.max(0, r101 - r116) + ((int) this.f161312e);
        setMeasuredDimension(r100, r101);
        return;
    L27:
        if (ViewGroupCompat.getNestedScrollAxes(this) == 2) goto L30;
        r109 = false;
        goto L31
    L5:
        r103 = r100;
        goto L6
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestChildFocus(View r100, View r101) {
        super.requestChildFocus(r100, r101);
        if (isInTouchMode() == false) goto L5;
        return;
    L5:
        if (c(r101) == false) goto L9;
        g(0, 0.0f);
        return;
    }

    public TTLiveResolverDrawerLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f161328u = -1;
        this.f161329v = new Rect();
        this.f161330w = new a(this);
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.tt_rwl_maxCollapsedHeight, R.attr.tt_rwl_maxCollapsedHeightSmall, R.attr.tt_rwl_maxWidth}, r102, 0);
        this.f161308a = -1;
        int r104 = (int) t6.a(r100, 352.0f);
        this.f161309b = r104;
        this.f161310c = r104;
        r103.recycle();
        this.f161324q = ContextCompat.getDrawable(getContext(), R.drawable.ttlive_commonui_resolver_drawer_scroll_indicator);
        this.f161322o = new OverScroller(r100, AnimationUtils.loadInterpolator(r100, android.R.interpolator.decelerate_quint));
        ViewConfiguration r105 = ViewConfiguration.get(r100);
        this.f161320m = r105.getScaledTouchSlop();
        this.f161321n = r105.getScaledMinimumFlingVelocity();
        ViewCompat.setImportantForAccessibility(this, 2);
    }

    public static View a(ViewGroup r100, float r101, float r102) {
        int r103 = r100.getChildCount() - 1;
    L3:
        if (r103 < 0) goto L17;
        View r104 = r100.getChildAt(r103);
        float r105 = r104.getX();
        float r106 = r104.getY();
        float r107 = r104.getWidth() + r105;
        float r108 = r104.getHeight() + r106;
        if (r101 >= r105) goto L7;
    L13:
        boolean r109 = false;
    L14:
        if (r109 == true) goto L15;
        r103 = r103 - 1;
        goto L3
    L15:
        return r104;
    L7:
        if (r102 < r106) goto L13;
        if (r101 >= r107) goto L13;
        if (r102 >= r108) goto L13;
        r109 = true;
        goto L14
    L17:
        return null;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final boolean onNestedPreFling(View r100, float r101, float r102) {
        if (r102 > this.f161321n) goto L5;
    L8:
        return false;
    L5:
        if (this.f161312e == 0.0f) goto L8;
        g(0, r102);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final void onNestedScrollAccepted(View r100, View r101, int r102) {
        super.onNestedScrollAccepted(r100, r101, r102);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final boolean onNestedFling(View r100, float r101, float r102, boolean r103) {
        if ((r100 instanceof RecyclerView) == false) goto L12;
        if (r103 == false) goto L12;
        if (r102 == 0.0f) goto L12;
        if (r102 >= 0.0f) goto L10;
        int r104 = -1;
    L11:
        r103 = ViewCompat.canScrollVertically(r100, r104);
        goto L12
    L10:
        r104 = 1;
    L12:
        int r105 = 0;
        if (r103 == false) goto L15;
    L22:
        return false;
    L15:
        if (Math.abs(r102) <= this.f161321n) goto L22;
        if (r102 > 0.0f) goto L20;
        r105 = this.f161313f;
    L20:
        g(r105, r102);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final void onNestedPreScroll(View r100, int r101, int r102, int[] r103) {
        if (r102 <= 0) goto L5;
        r103[1] = (int) (-e(-r102));
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r110, int r111, int r112, int r113) {
        int r101 = getWidth();
        int r114 = this.f161316i;
        int r115 = getPaddingLeft();
        int r102 = r101 - getPaddingRight();
        int r116 = getChildCount();
        boolean r103 = false;
        View r104 = null;
        int r105 = 0;
    L3:
        if (r105 >= r116) goto L16;
        View r106 = getChildAt(r105);
        LayoutParams r107 = (LayoutParams) r106.getLayoutParams();
        if (r107.f161333c == false) goto L8;
        r104 = r106;
    L8:
        if (r106.getVisibility() == 8) goto L14;
        int r117 = r114 + ((ViewGroup.MarginLayoutParams) r107).topMargin;
        if (r107.f161332b == false) goto L13;
        r117 = (int) (r117 - this.f161312e);
    L13:
        int r108 = r106.getMeasuredHeight() + r117;
        int r109 = r106.getMeasuredWidth();
        int r118 = (((r102 - r115) - r109) / 2) + r115;
        r106.layout(r118, r117, r109 + r118, r108);
        r114 = r108 + ((ViewGroup.MarginLayoutParams) r107).bottomMargin;
    L14:
        r105 = r105 + 1;
        goto L3
    L16:
        if (this.f161324q != null) goto L18;
        return;
    L18:
        if (r104 == null) goto L23;
        int r119 = r104.getLeft();
        int r120 = r104.getRight();
        int r121 = r104.getTop();
        this.f161324q.setBounds(r119, r121 - this.f161324q.getIntrinsicHeight(), r120, r121);
        if (this.f161312e <= 0.0f) goto L22;
        r103 = true;
    L22:
        setWillNotDraw(true ^ r103);
        return;
    L23:
        this.f161324q = null;
        setWillNotDraw(true);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final void onNestedScroll(View r100, int r101, int r102, int r103, int r104) {
        if (r104 >= 0) goto L5;
        e(-r104);
        return;
    }
}
