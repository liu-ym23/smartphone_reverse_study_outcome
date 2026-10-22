package com.google.android.material.bottomsheet;

import C0.c;
import C0.f;
import H0.c;
import Z2.l;
import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.RoundedCorner;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.N;
import androidx.customview.view.AbsSavedState;
import b.C1423c;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.u;
import io.requery.android.database.sqlite.SQLiteDatabase;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import w0.C5715a;

/* loaded from: classes2.dex */
public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.c<V> implements T2.b {
    private static final int CORNER_ANIMATION_DURATION = 500;
    static final int DEFAULT_SIGNIFICANT_VEL_THRESHOLD = 500;
    private static final int DEF_STYLE_RES = R$style.Widget_Design_BottomSheet_Modal;
    private static final float HIDE_FRICTION = 0.1f;
    private static final float HIDE_THRESHOLD = 0.5f;
    private static final int INVALID_POSITION = -1;
    private static final int NO_MAX_SIZE = -1;
    public static final int PEEK_HEIGHT_AUTO = -1;
    public static final int SAVE_ALL = -1;
    public static final int SAVE_FIT_TO_CONTENTS = 2;
    public static final int SAVE_HIDEABLE = 4;
    public static final int SAVE_NONE = 0;
    public static final int SAVE_PEEK_HEIGHT = 1;
    public static final int SAVE_SKIP_COLLAPSED = 8;
    public static final int STATE_COLLAPSED = 4;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_EXPANDED = 3;
    public static final int STATE_HALF_EXPANDED = 6;
    public static final int STATE_HIDDEN = 5;
    public static final int STATE_SETTLING = 2;
    private static final String TAG = "BottomSheetBehavior";
    static final int VIEW_INDEX_ACCESSIBILITY_DELEGATE_VIEW = 1;
    private static final int VIEW_INDEX_BOTTOM_SHEET = 0;
    WeakReference<View> accessibilityDelegateViewRef;
    int activePointerId;
    private ColorStateList backgroundTint;
    T2.e bottomContainerBackHelper;
    private final ArrayList<g> callbacks;
    private int childHeight;
    int collapsedOffset;
    private final c.AbstractC0044c dragCallback;
    WeakReference<View> dragHandleViewRef;
    private boolean draggable;
    private boolean draggableOnNestedScroll;
    private boolean draggableOnNestedScrollLastDragIgnored;
    float elevation;
    final SparseIntArray expandHalfwayActionIds;
    private boolean expandedCornersRemoved;
    int expandedOffset;
    private boolean fitToContents;
    int fitToContentsOffset;
    private int gestureInsetBottom;
    private boolean gestureInsetBottomIgnored;
    int halfExpandedOffset;
    float halfExpandedRatio;
    private float hideFriction;
    boolean hideable;
    private boolean ignoreEvents;
    private Map<View, Integer> importantForAccessibilityMap;
    private int initialY;
    private int insetBottom;
    private int insetTop;
    private ValueAnimator interpolatorAnimator;
    private int lastNestedScrollDy;
    int lastStableState;
    private boolean marginLeftSystemWindowInsets;
    private boolean marginRightSystemWindowInsets;
    private boolean marginTopSystemWindowInsets;
    private Z2.h materialShapeDrawable;
    private int maxHeight;
    private int maxWidth;
    private float maximumVelocity;
    private boolean nestedScrolled;
    WeakReference<View> nestedScrollingChildRef;
    private boolean paddingBottomSystemWindowInsets;
    private boolean paddingLeftSystemWindowInsets;
    private boolean paddingRightSystemWindowInsets;
    private boolean paddingTopSystemWindowInsets;
    int parentHeight;
    int parentWidth;
    private int peekHeight;
    private boolean peekHeightAuto;
    private int peekHeightGestureInsetBuffer;
    private int peekHeightMin;
    private int saveFlags;
    private l shapeAppearanceModelDefault;
    private boolean shouldRemoveExpandedCorners;
    private int significantVelocityThreshold;
    private boolean skipCollapsed;
    int state;
    private final BottomSheetBehavior<V>.h stateSettlingTracker;
    boolean touchingScrollingChild;
    private boolean updateImportantForAccessibilityOnSiblings;
    private VelocityTracker velocityTracker;
    H0.c viewDragHelper;
    WeakReference<V> viewRef;

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        boolean fitToContents;
        boolean hideable;
        int peekHeight;
        boolean skipCollapsed;
        final int state;

        public class a implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
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

        public SavedState(Parcel parcel) {
            this(parcel, (ClassLoader) null);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.state);
            parcel.writeInt(this.peekHeight);
            parcel.writeInt(this.fitToContents ? 1 : 0);
            parcel.writeInt(this.hideable ? 1 : 0);
            parcel.writeInt(this.skipCollapsed ? 1 : 0);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.state = parcel.readInt();
            this.peekHeight = parcel.readInt();
            this.fitToContents = parcel.readInt() == 1;
            this.hideable = parcel.readInt() == 1;
            this.skipCollapsed = parcel.readInt() == 1;
        }

        public SavedState(Parcelable parcelable, BottomSheetBehavior<?> bottomSheetBehavior) {
            super(parcelable);
            this.state = bottomSheetBehavior.state;
            this.peekHeight = ((BottomSheetBehavior) bottomSheetBehavior).peekHeight;
            this.fitToContents = ((BottomSheetBehavior) bottomSheetBehavior).fitToContents;
            this.hideable = bottomSheetBehavior.hideable;
            this.skipCollapsed = ((BottomSheetBehavior) bottomSheetBehavior).skipCollapsed;
        }

        @Deprecated
        public SavedState(Parcelable parcelable, int i10) {
            super(parcelable);
            this.state = i10;
        }
    }

    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f20422a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f20423b;

        public a(View view, int i10) {
            this.f20422a = view;
            this.f20423b = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            BottomSheetBehavior.this.F0(this.f20422a, this.f20423b, false);
        }
    }

    public class b extends AnimatorListenerAdapter {
        public b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BottomSheetBehavior.this.y0(5);
            WeakReference<V> weakReference = BottomSheetBehavior.this.viewRef;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            BottomSheetBehavior.this.viewRef.get().requestLayout();
        }
    }

    public class c implements ValueAnimator.AnimatorUpdateListener {
        public c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            if (BottomSheetBehavior.this.materialShapeDrawable != null) {
                BottomSheetBehavior.this.materialShapeDrawable.h0(fFloatValue);
            }
        }
    }

    public class d implements u.c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f20427a;

        public d(boolean z10) {
            this.f20427a = z10;
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x0080  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x00a3  */
        @Override // com.google.android.material.internal.u.c
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public androidx.core.view.a0 a(android.view.View r11, androidx.core.view.a0 r12, com.google.android.material.internal.u.d r13) {
            /*
                r10 = this;
                int r0 = androidx.core.view.a0.o.g()
                t0.e r0 = r12.f(r0)
                int r1 = androidx.core.view.a0.o.d()
                t0.e r1 = r12.f(r1)
                com.google.android.material.bottomsheet.BottomSheetBehavior r2 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r3 = r0.f41978b
                com.google.android.material.bottomsheet.BottomSheetBehavior.r(r2, r3)
                boolean r2 = com.google.android.material.internal.u.h(r11)
                int r3 = r11.getPaddingBottom()
                int r4 = r11.getPaddingLeft()
                int r5 = r11.getPaddingRight()
                com.google.android.material.bottomsheet.BottomSheetBehavior r6 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                boolean r6 = com.google.android.material.bottomsheet.BottomSheetBehavior.s(r6)
                if (r6 == 0) goto L41
                com.google.android.material.bottomsheet.BottomSheetBehavior r3 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r6 = r12.j()
                com.google.android.material.bottomsheet.BottomSheetBehavior.u(r3, r6)
                int r3 = r13.f21157d
                com.google.android.material.bottomsheet.BottomSheetBehavior r6 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r6 = com.google.android.material.bottomsheet.BottomSheetBehavior.t(r6)
                int r3 = r3 + r6
            L41:
                com.google.android.material.bottomsheet.BottomSheetBehavior r6 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                boolean r6 = com.google.android.material.bottomsheet.BottomSheetBehavior.v(r6)
                if (r6 == 0) goto L53
                if (r2 == 0) goto L4e
                int r4 = r13.f21156c
                goto L50
            L4e:
                int r4 = r13.f21154a
            L50:
                int r6 = r0.f41977a
                int r4 = r4 + r6
            L53:
                com.google.android.material.bottomsheet.BottomSheetBehavior r6 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                boolean r6 = com.google.android.material.bottomsheet.BottomSheetBehavior.w(r6)
                if (r6 == 0) goto L66
                if (r2 == 0) goto L60
                int r13 = r13.f21154a
                goto L62
            L60:
                int r13 = r13.f21156c
            L62:
                int r2 = r0.f41979c
                int r5 = r13 + r2
            L66:
                android.view.ViewGroup$LayoutParams r13 = r11.getLayoutParams()
                android.view.ViewGroup$MarginLayoutParams r13 = (android.view.ViewGroup.MarginLayoutParams) r13
                com.google.android.material.bottomsheet.BottomSheetBehavior r2 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                boolean r2 = com.google.android.material.bottomsheet.BottomSheetBehavior.x(r2)
                r6 = 0
                r7 = 1
                if (r2 == 0) goto L80
                int r2 = r13.leftMargin
                int r8 = r0.f41977a
                if (r2 == r8) goto L80
                r13.leftMargin = r8
                r2 = r7
                goto L81
            L80:
                r2 = r6
            L81:
                com.google.android.material.bottomsheet.BottomSheetBehavior r8 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                boolean r8 = com.google.android.material.bottomsheet.BottomSheetBehavior.y(r8)
                if (r8 == 0) goto L92
                int r8 = r13.rightMargin
                int r9 = r0.f41979c
                if (r8 == r9) goto L92
                r13.rightMargin = r9
                r2 = r7
            L92:
                com.google.android.material.bottomsheet.BottomSheetBehavior r8 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                boolean r8 = com.google.android.material.bottomsheet.BottomSheetBehavior.h(r8)
                if (r8 == 0) goto La3
                int r8 = r13.topMargin
                int r0 = r0.f41978b
                if (r8 == r0) goto La3
                r13.topMargin = r0
                goto La4
            La3:
                r7 = r2
            La4:
                if (r7 == 0) goto La9
                r11.setLayoutParams(r13)
            La9:
                int r13 = r11.getPaddingTop()
                r11.setPadding(r4, r13, r5, r3)
                boolean r11 = r10.f20427a
                if (r11 == 0) goto Lbb
                com.google.android.material.bottomsheet.BottomSheetBehavior r11 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r13 = r1.f41980d
                com.google.android.material.bottomsheet.BottomSheetBehavior.i(r11, r13)
            Lbb:
                com.google.android.material.bottomsheet.BottomSheetBehavior r11 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                boolean r11 = com.google.android.material.bottomsheet.BottomSheetBehavior.s(r11)
                if (r11 != 0) goto Lc9
                boolean r11 = r10.f20427a
                if (r11 == 0) goto Lc8
                goto Lc9
            Lc8:
                return r12
            Lc9:
                com.google.android.material.bottomsheet.BottomSheetBehavior r10 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                com.google.android.material.bottomsheet.BottomSheetBehavior.j(r10, r6)
                return r12
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.d.a(android.view.View, androidx.core.view.a0, com.google.android.material.internal.u$d):androidx.core.view.a0");
        }
    }

    public class e extends c.AbstractC0044c {

        /* renamed from: a, reason: collision with root package name */
        public long f20429a;

        public e() {
        }

        @Override // H0.c.AbstractC0044c
        public int a(View view, int i10, int i11) {
            return view.getLeft();
        }

        @Override // H0.c.AbstractC0044c
        public int b(View view, int i10, int i11) {
            return C5715a.b(i10, BottomSheetBehavior.this.Q(), e(view));
        }

        @Override // H0.c.AbstractC0044c
        public int e(View view) {
            return BottomSheetBehavior.this.H() ? BottomSheetBehavior.this.parentHeight : BottomSheetBehavior.this.collapsedOffset;
        }

        @Override // H0.c.AbstractC0044c
        public void j(int i10) {
            if (i10 == 1 && BottomSheetBehavior.this.draggable) {
                BottomSheetBehavior.this.y0(1);
            }
        }

        @Override // H0.c.AbstractC0044c
        public void k(View view, int i10, int i11, int i12, int i13) {
            BottomSheetBehavior.this.M(i11);
        }

        /* JADX WARN: Removed duplicated region for block: B:39:0x00ad  */
        /* JADX WARN: Removed duplicated region for block: B:6:0x0010  */
        @Override // H0.c.AbstractC0044c
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void l(android.view.View r8, float r9, float r10) {
            /*
                Method dump skipped, instructions count: 308
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.e.l(android.view.View, float, float):void");
        }

        @Override // H0.c.AbstractC0044c
        public boolean m(View view, int i10) {
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            int i11 = bottomSheetBehavior.state;
            if (i11 == 1 || bottomSheetBehavior.touchingScrollingChild) {
                return false;
            }
            if (i11 == 3 && bottomSheetBehavior.activePointerId == i10) {
                WeakReference<View> weakReference = bottomSheetBehavior.nestedScrollingChildRef;
                View view2 = weakReference != null ? weakReference.get() : null;
                if (view2 != null && view2.canScrollVertically(-1)) {
                    return false;
                }
            }
            this.f20429a = SystemClock.uptimeMillis();
            WeakReference<V> weakReference2 = BottomSheetBehavior.this.viewRef;
            return weakReference2 != null && weakReference2.get() == view;
        }

        public final boolean n(View view) {
            int top = view.getTop();
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            return top > (bottomSheetBehavior.parentHeight + bottomSheetBehavior.Q()) / 2;
        }
    }

    public class f implements C0.f {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f20431a;

        public f(int i10) {
            this.f20431a = i10;
        }

        @Override // C0.f
        public boolean a(View view, f.a aVar) {
            BottomSheetBehavior.this.x0(this.f20431a);
            return true;
        }
    }

    public static abstract class g {
        public void a(View view) {
        }

        public abstract void b(View view, float f10);

        public abstract void c(View view, int i10);
    }

    public BottomSheetBehavior() {
        this.saveFlags = 0;
        this.fitToContents = true;
        this.updateImportantForAccessibilityOnSiblings = false;
        this.maxWidth = -1;
        this.maxHeight = -1;
        this.stateSettlingTracker = new h(this, null);
        this.halfExpandedRatio = 0.5f;
        this.elevation = -1.0f;
        this.draggable = true;
        this.draggableOnNestedScroll = true;
        this.state = 4;
        this.lastStableState = 4;
        this.hideFriction = HIDE_FRICTION;
        this.callbacks = new ArrayList<>();
        this.initialY = -1;
        this.expandHalfwayActionIds = new SparseIntArray();
        this.dragCallback = new e();
    }

    public static <V extends View> BottomSheetBehavior<V> O(V v10) {
        ViewGroup.LayoutParams layoutParams = v10.getLayoutParams();
        if (!(layoutParams instanceof CoordinatorLayout.f)) {
            throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
        }
        CoordinatorLayout.c cVarF = ((CoordinatorLayout.f) layoutParams).f();
        if (cVarF instanceof BottomSheetBehavior) {
            return (BottomSheetBehavior) cVarF;
        }
        throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
    }

    private void g0() {
        this.activePointerId = -1;
        this.initialY = -1;
        VelocityTracker velocityTracker = this.velocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.velocityTracker = null;
        }
    }

    public void A(g gVar) {
        if (this.callbacks.contains(gVar)) {
            return;
        }
        this.callbacks.add(gVar);
    }

    public boolean A0(long j10, float f10) {
        return false;
    }

    public final void B() {
        int iF = F();
        if (this.fitToContents) {
            this.collapsedOffset = Math.max(this.parentHeight - iF, this.fitToContentsOffset);
        } else {
            this.collapsedOffset = this.parentHeight - iF;
        }
    }

    public final boolean B0() {
        if (this.viewDragHelper != null) {
            return this.draggable || this.state == 1;
        }
        return false;
    }

    public final float C(float f10, RoundedCorner roundedCorner) {
        if (roundedCorner != null) {
            float radius = roundedCorner.getRadius();
            if (radius > 0.0f && f10 > 0.0f) {
                return radius / f10;
            }
        }
        return 0.0f;
    }

    public boolean C0(View view, float f10) {
        if (this.skipCollapsed) {
            return true;
        }
        if (Z() && view.getTop() >= this.collapsedOffset) {
            return Math.abs((((float) view.getTop()) + (f10 * this.hideFriction)) - ((float) this.collapsedOffset)) / ((float) F()) > 0.5f;
        }
        return false;
    }

    public final void D() {
        this.halfExpandedOffset = (int) (this.parentHeight * (1.0f - this.halfExpandedRatio));
    }

    public boolean D0() {
        return false;
    }

    public final float E() {
        WeakReference<V> weakReference;
        WindowInsets rootWindowInsets;
        if (this.materialShapeDrawable == null || (weakReference = this.viewRef) == null || weakReference.get() == null) {
            return 0.0f;
        }
        V v10 = this.viewRef.get();
        if (!V() || (rootWindowInsets = v10.getRootWindowInsets()) == null) {
            return 0.0f;
        }
        return Math.max(C(this.materialShapeDrawable.N(), rootWindowInsets.getRoundedCorner(0)), C(this.materialShapeDrawable.O(), rootWindowInsets.getRoundedCorner(1)));
    }

    public boolean E0() {
        return true;
    }

    public final int F() {
        int iMin;
        int i10;
        int i11;
        if (this.peekHeightAuto) {
            iMin = Math.min(Math.max(this.peekHeightMin, this.parentHeight - ((this.parentWidth * 9) / 16)), this.childHeight);
            i10 = this.insetBottom;
        } else {
            if (!this.gestureInsetBottomIgnored && !this.paddingBottomSystemWindowInsets && (i11 = this.gestureInsetBottom) > 0) {
                return Math.max(this.peekHeight, i11 + this.peekHeightGestureInsetBuffer);
            }
            iMin = this.peekHeight;
            i10 = this.insetBottom;
        }
        return iMin + i10;
    }

    public final void F0(View view, int i10, boolean z10) {
        int iT = T(i10);
        H0.c cVar = this.viewDragHelper;
        if (cVar == null || (!z10 ? cVar.Q(view, view.getLeft(), iT) : cVar.O(view.getLeft(), iT))) {
            y0(i10);
            return;
        }
        y0(2);
        I0(i10, true);
        this.stateSettlingTracker.c(i10);
    }

    public final float G(int i10) {
        float f10;
        float fQ;
        int i11 = this.collapsedOffset;
        if (i10 > i11 || i11 == Q()) {
            int i12 = this.collapsedOffset;
            f10 = i12 - i10;
            fQ = this.parentHeight - i12;
        } else {
            int i13 = this.collapsedOffset;
            f10 = i13 - i10;
            fQ = i13 - Q();
        }
        return f10 / fQ;
    }

    public final void G0() {
        WeakReference<V> weakReference = this.viewRef;
        if (weakReference != null) {
            H0(weakReference.get(), 0);
        }
        WeakReference<View> weakReference2 = this.accessibilityDelegateViewRef;
        if (weakReference2 != null) {
            H0(weakReference2.get(), 1);
        }
    }

    public final boolean H() {
        return Y() && Z();
    }

    public final void H0(View view, int i10) {
        if (view == null) {
            return;
        }
        I(view, i10);
        if (!this.fitToContents && this.state != 6) {
            this.expandHalfwayActionIds.put(i10, z(view, R$string.bottomsheet_action_expand_halfway, 6));
        }
        if (this.hideable && Z() && this.state != 5) {
            f0(view, c.a.f1670y, 5);
        }
        int i11 = this.state;
        if (i11 == 3) {
            f0(view, c.a.f1669x, this.fitToContents ? 4 : 6);
            return;
        }
        if (i11 == 4) {
            f0(view, c.a.f1668w, this.fitToContents ? 3 : 6);
        } else {
            if (i11 != 6) {
                return;
            }
            f0(view, c.a.f1669x, 4);
            f0(view, c.a.f1668w, 3);
        }
    }

    public final void I(View view, int i10) {
        if (view == null) {
            return;
        }
        N.b0(view, 524288);
        N.b0(view, SQLiteDatabase.OPEN_PRIVATECACHE);
        N.b0(view, 1048576);
        int i11 = this.expandHalfwayActionIds.get(i10, -1);
        if (i11 != -1) {
            N.b0(view, i11);
            this.expandHalfwayActionIds.delete(i10);
        }
    }

    public final void I0(int i10, boolean z10) {
        boolean zW;
        ValueAnimator valueAnimator;
        if (i10 == 2 || this.expandedCornersRemoved == (zW = W()) || this.materialShapeDrawable == null) {
            return;
        }
        this.expandedCornersRemoved = zW;
        if (!z10 || (valueAnimator = this.interpolatorAnimator) == null) {
            ValueAnimator valueAnimator2 = this.interpolatorAnimator;
            if (valueAnimator2 != null && valueAnimator2.isRunning()) {
                this.interpolatorAnimator.cancel();
            }
            this.materialShapeDrawable.h0(this.expandedCornersRemoved ? E() : 1.0f);
            return;
        }
        if (valueAnimator.isRunning()) {
            this.interpolatorAnimator.reverse();
        } else {
            this.interpolatorAnimator.setFloatValues(this.materialShapeDrawable.C(), zW ? E() : 1.0f);
            this.interpolatorAnimator.start();
        }
    }

    public final C0.f J(int i10) {
        return new f(i10);
    }

    public final void J0(boolean z10) {
        Map<View, Integer> map;
        WeakReference<V> weakReference = this.viewRef;
        if (weakReference == null) {
            return;
        }
        ViewParent parent = weakReference.get().getParent();
        if (parent instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
            int childCount = coordinatorLayout.getChildCount();
            if (z10) {
                if (this.importantForAccessibilityMap != null) {
                    return;
                } else {
                    this.importantForAccessibilityMap = new HashMap(childCount);
                }
            }
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = coordinatorLayout.getChildAt(i10);
                if (childAt != this.viewRef.get()) {
                    if (z10) {
                        this.importantForAccessibilityMap.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                        if (this.updateImportantForAccessibilityOnSiblings) {
                            childAt.setImportantForAccessibility(4);
                        }
                    } else if (this.updateImportantForAccessibilityOnSiblings && (map = this.importantForAccessibilityMap) != null && map.containsKey(childAt)) {
                        childAt.setImportantForAccessibility(this.importantForAccessibilityMap.get(childAt).intValue());
                    }
                }
            }
            if (!z10) {
                this.importantForAccessibilityMap = null;
            } else if (this.updateImportantForAccessibilityOnSiblings) {
                this.viewRef.get().sendAccessibilityEvent(8);
            }
        }
    }

    public final void K(Context context) {
        if (this.shapeAppearanceModelDefault == null) {
            return;
        }
        Z2.h hVar = new Z2.h(this.shapeAppearanceModelDefault);
        this.materialShapeDrawable = hVar;
        hVar.U(context);
        ColorStateList colorStateList = this.backgroundTint;
        if (colorStateList != null) {
            this.materialShapeDrawable.g0(colorStateList);
            return;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.colorBackground, typedValue, true);
        this.materialShapeDrawable.setTint(typedValue.data);
    }

    public final void K0(boolean z10) {
        V v10;
        if (this.viewRef != null) {
            B();
            if (this.state != 4 || (v10 = this.viewRef.get()) == null) {
                return;
            }
            if (z10) {
                x0(4);
            } else {
                v10.requestLayout();
            }
        }
    }

    public final void L() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(E(), 1.0f);
        this.interpolatorAnimator = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(500L);
        this.interpolatorAnimator.addUpdateListener(new c());
    }

    public void M(int i10) {
        V v10 = this.viewRef.get();
        if (v10 == null || this.callbacks.isEmpty()) {
            return;
        }
        float fG = G(i10);
        for (int i11 = 0; i11 < this.callbacks.size(); i11++) {
            this.callbacks.get(i11).b(v10, fG);
        }
    }

    public View N(View view) {
        if (view.getVisibility() != 0) {
            return null;
        }
        if (view.isNestedScrollingEnabled()) {
            return view;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View viewN = N(viewGroup.getChildAt(i10));
                if (viewN != null) {
                    return viewN;
                }
            }
        }
        return null;
    }

    public final int P(int i10, int i11, int i12, int i13) {
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i10, i11, i13);
        if (i12 == -1) {
            return childMeasureSpec;
        }
        int mode = View.MeasureSpec.getMode(childMeasureSpec);
        int size = View.MeasureSpec.getSize(childMeasureSpec);
        if (mode == 1073741824) {
            return View.MeasureSpec.makeMeasureSpec(Math.min(size, i12), 1073741824);
        }
        if (size != 0) {
            i12 = Math.min(size, i12);
        }
        return View.MeasureSpec.makeMeasureSpec(i12, Integer.MIN_VALUE);
    }

    public int Q() {
        if (this.fitToContents) {
            return this.fitToContentsOffset;
        }
        return Math.max(this.expandedOffset, this.paddingTopSystemWindowInsets ? 0 : this.insetTop);
    }

    public Z2.h R() {
        return this.materialShapeDrawable;
    }

    public int S() {
        return this.state;
    }

    public final int T(int i10) {
        if (i10 == 3) {
            return Q();
        }
        if (i10 == 4) {
            return this.collapsedOffset;
        }
        if (i10 == 5) {
            return this.parentHeight;
        }
        if (i10 == 6) {
            return this.halfExpandedOffset;
        }
        throw new IllegalArgumentException("Invalid state to get top offset: " + i10);
    }

    public final float U() {
        VelocityTracker velocityTracker = this.velocityTracker;
        if (velocityTracker == null) {
            return 0.0f;
        }
        velocityTracker.computeCurrentVelocity(1000, this.maximumVelocity);
        return this.velocityTracker.getYVelocity(this.activePointerId);
    }

    public final boolean V() {
        WeakReference<V> weakReference = this.viewRef;
        if (weakReference != null && weakReference.get() != null) {
            int[] iArr = new int[2];
            this.viewRef.get().getLocationOnScreen(iArr);
            if (iArr[1] == 0) {
                return true;
            }
        }
        return false;
    }

    public final boolean W() {
        if (this.state == 3) {
            return this.shouldRemoveExpandedCorners || V();
        }
        return false;
    }

    public boolean X() {
        return this.gestureInsetBottomIgnored;
    }

    public boolean Y() {
        return this.hideable;
    }

    public boolean Z() {
        return true;
    }

    public final boolean a0(V v10) {
        ViewParent parent = v10.getParent();
        return parent != null && parent.isLayoutRequested() && v10.isAttachedToWindow();
    }

    @Override // T2.b
    public void b(C1423c c1423c) {
        T2.e eVar = this.bottomContainerBackHelper;
        if (eVar == null) {
            return;
        }
        eVar.j(c1423c);
    }

    public boolean b0() {
        return true;
    }

    public final boolean c0(CoordinatorLayout coordinatorLayout, int i10, int i11) {
        WeakReference<View> weakReference = this.dragHandleViewRef;
        View view = weakReference != null ? weakReference.get() : null;
        return view != null && coordinatorLayout.I(view, i10, i11);
    }

    @Override // T2.b
    public void d() {
        T2.e eVar = this.bottomContainerBackHelper;
        if (eVar == null) {
            return;
        }
        eVar.f();
    }

    public final boolean d0(CoordinatorLayout coordinatorLayout, int i10, int i11) {
        WeakReference<View> weakReference = this.nestedScrollingChildRef;
        View view = weakReference != null ? weakReference.get() : null;
        return view != null && coordinatorLayout.I(view, i10, i11);
    }

    @Override // T2.b
    public void e(C1423c c1423c) {
        T2.e eVar = this.bottomContainerBackHelper;
        if (eVar == null) {
            return;
        }
        eVar.l(c1423c);
    }

    public void e0(g gVar) {
        this.callbacks.remove(gVar);
    }

    @Override // T2.b
    public void f() {
        T2.e eVar = this.bottomContainerBackHelper;
        if (eVar == null) {
            return;
        }
        C1423c c1423cC = eVar.c();
        if (c1423cC == null) {
            x0(this.hideable ? 5 : 4);
        } else if (this.hideable) {
            this.bottomContainerBackHelper.h(c1423cC, new b());
        } else {
            this.bottomContainerBackHelper.i(c1423cC, null);
            x0(4);
        }
    }

    public final void f0(View view, c.a aVar, int i10) {
        N.d0(view, aVar, null, J(i10));
    }

    public final void h0(SavedState savedState) {
        int i10 = this.saveFlags;
        if (i10 == 0) {
            return;
        }
        if (i10 == -1 || (i10 & 1) == 1) {
            this.peekHeight = savedState.peekHeight;
        }
        if (i10 == -1 || (i10 & 2) == 2) {
            this.fitToContents = savedState.fitToContents;
        }
        if (i10 == -1 || (i10 & 4) == 4) {
            this.hideable = savedState.hideable;
        }
        if (i10 == -1 || (i10 & 8) == 8) {
            this.skipCollapsed = savedState.skipCollapsed;
        }
    }

    public final void i0(V v10, Runnable runnable) {
        if (a0(v10)) {
            v10.post(runnable);
        } else {
            runnable.run();
        }
    }

    public void j0(boolean z10) {
        this.draggable = z10;
    }

    public void k0(boolean z10) {
        this.draggableOnNestedScroll = z10;
    }

    public void l0(int i10) {
        if (i10 < 0) {
            throw new IllegalArgumentException("offset must be greater than or equal to 0");
        }
        this.expandedOffset = i10;
        I0(this.state, true);
    }

    public void m0(boolean z10) {
        if (this.fitToContents == z10) {
            return;
        }
        this.fitToContents = z10;
        if (this.viewRef != null) {
            B();
        }
        y0((this.fitToContents && this.state == 6) ? 3 : this.state);
        I0(this.state, true);
        G0();
    }

    public void n0(boolean z10) {
        this.gestureInsetBottomIgnored = z10;
    }

    public void o0(float f10) {
        if (f10 <= 0.0f || f10 >= 1.0f) {
            throw new IllegalArgumentException("ratio must be a float value between 0 and 1");
        }
        this.halfExpandedRatio = f10;
        if (this.viewRef != null) {
            D();
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void onAttachedToLayoutParams(CoordinatorLayout.f fVar) {
        super.onAttachedToLayoutParams(fVar);
        this.viewRef = null;
        this.viewDragHelper = null;
        this.bottomContainerBackHelper = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void onDetachedFromLayoutParams() {
        super.onDetachedFromLayoutParams();
        this.viewRef = null;
        this.viewDragHelper = null;
        this.bottomContainerBackHelper = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, V v10, MotionEvent motionEvent) {
        int i10;
        H0.c cVar;
        if (!v10.isShown() || !this.draggable) {
            this.ignoreEvents = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            g0();
        }
        if (this.velocityTracker == null) {
            this.velocityTracker = VelocityTracker.obtain();
        }
        this.velocityTracker.addMovement(motionEvent);
        if (actionMasked == 0) {
            int x10 = (int) motionEvent.getX();
            int y10 = (int) motionEvent.getY();
            this.initialY = y10;
            if (this.state != 2 && d0(coordinatorLayout, x10, y10)) {
                this.activePointerId = motionEvent.getPointerId(motionEvent.getActionIndex());
                if (!c0(coordinatorLayout, x10, this.initialY)) {
                    this.touchingScrollingChild = true;
                }
            }
            this.ignoreEvents = this.activePointerId == -1 && !coordinatorLayout.I(v10, x10, this.initialY);
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.touchingScrollingChild = false;
            this.activePointerId = -1;
            if (this.ignoreEvents) {
                this.ignoreEvents = false;
                return false;
            }
        }
        if (!this.ignoreEvents && (cVar = this.viewDragHelper) != null && cVar.P(motionEvent)) {
            return true;
        }
        WeakReference<View> weakReference = this.nestedScrollingChildRef;
        View view = weakReference != null ? weakReference.get() : null;
        return (actionMasked != 2 || view == null || this.ignoreEvents || this.state == 1 || coordinatorLayout.I(view, (int) motionEvent.getX(), (int) motionEvent.getY()) || this.viewDragHelper == null || (i10 = this.initialY) == -1 || Math.abs(((float) i10) - motionEvent.getY()) <= ((float) this.viewDragHelper.z())) ? false : true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, V v10, int i10) {
        if (coordinatorLayout.getFitsSystemWindows() && !v10.getFitsSystemWindows()) {
            v10.setFitsSystemWindows(true);
        }
        if (this.viewRef == null) {
            this.peekHeightMin = coordinatorLayout.getResources().getDimensionPixelSize(R$dimen.design_bottom_sheet_peek_height_min);
            z0(v10);
            N.E0(v10, new com.google.android.material.bottomsheet.c(v10));
            this.viewRef = new WeakReference<>(v10);
            this.bottomContainerBackHelper = new T2.e(v10);
            Z2.h hVar = this.materialShapeDrawable;
            if (hVar != null) {
                v10.setBackground(hVar);
                Z2.h hVar2 = this.materialShapeDrawable;
                float elevation = this.elevation;
                if (elevation == -1.0f) {
                    elevation = v10.getElevation();
                }
                hVar2.f0(elevation);
            } else {
                ColorStateList colorStateList = this.backgroundTint;
                if (colorStateList != null) {
                    N.n0(v10, colorStateList);
                }
            }
            G0();
            if (v10.getImportantForAccessibility() == 0) {
                v10.setImportantForAccessibility(1);
            }
        }
        if (this.viewDragHelper == null) {
            this.viewDragHelper = H0.c.o(coordinatorLayout, this.dragCallback);
        }
        int top = v10.getTop();
        coordinatorLayout.Q(v10, i10);
        this.parentWidth = coordinatorLayout.getWidth();
        this.parentHeight = coordinatorLayout.getHeight();
        int height = v10.getHeight();
        this.childHeight = height;
        int iMin = this.parentHeight;
        int i11 = iMin - height;
        int i12 = this.insetTop;
        if (i11 < i12) {
            if (this.paddingTopSystemWindowInsets) {
                int i13 = this.maxHeight;
                if (i13 != -1) {
                    iMin = Math.min(iMin, i13);
                }
                this.childHeight = iMin;
            } else {
                int iMin2 = iMin - i12;
                int i14 = this.maxHeight;
                if (i14 != -1) {
                    iMin2 = Math.min(iMin2, i14);
                }
                this.childHeight = iMin2;
            }
        }
        this.fitToContentsOffset = Math.max(0, this.parentHeight - this.childHeight);
        D();
        B();
        int i15 = this.state;
        if (i15 == 3) {
            N.T(v10, Q());
        } else if (i15 == 6) {
            N.T(v10, this.halfExpandedOffset);
        } else if (this.hideable && i15 == 5) {
            N.T(v10, this.parentHeight);
        } else if (i15 == 4) {
            N.T(v10, this.collapsedOffset);
        } else if (i15 == 1 || i15 == 2) {
            N.T(v10, top - v10.getTop());
        }
        I0(this.state, false);
        this.nestedScrollingChildRef = new WeakReference<>(N(v10));
        for (int i16 = 0; i16 < this.callbacks.size(); i16++) {
            this.callbacks.get(i16).a(v10);
        }
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean onMeasureChild(CoordinatorLayout coordinatorLayout, V v10, int i10, int i11, int i12, int i13) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) v10.getLayoutParams();
        v10.measure(P(i10, coordinatorLayout.getPaddingLeft() + coordinatorLayout.getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i11, this.maxWidth, marginLayoutParams.width), P(i12, coordinatorLayout.getPaddingTop() + coordinatorLayout.getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i13, this.maxHeight, marginLayoutParams.height));
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean onNestedPreFling(CoordinatorLayout coordinatorLayout, V v10, View view, float f10, float f11) {
        WeakReference<View> weakReference;
        return b0() && (weakReference = this.nestedScrollingChildRef) != null && view == weakReference.get() && (!(this.state == 3 || this.draggableOnNestedScrollLastDragIgnored) || super.onNestedPreFling(coordinatorLayout, v10, view, f10, f11));
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, V v10, View view, int i10, int i11, int[] iArr, int i12) {
        if (i12 == 1) {
            return;
        }
        WeakReference<View> weakReference = this.nestedScrollingChildRef;
        View view2 = weakReference != null ? weakReference.get() : null;
        if (!b0() || view == view2) {
            int top = v10.getTop();
            int i13 = top - i11;
            if (i11 > 0) {
                if (!this.nestedScrolled && !this.draggableOnNestedScroll && view == view2 && view.canScrollVertically(1)) {
                    this.draggableOnNestedScrollLastDragIgnored = true;
                    return;
                }
                if (i13 < Q()) {
                    int iQ = top - Q();
                    iArr[1] = iQ;
                    N.T(v10, -iQ);
                    y0(3);
                } else {
                    if (!this.draggable) {
                        return;
                    }
                    iArr[1] = i11;
                    N.T(v10, -i11);
                    y0(1);
                }
            } else if (i11 < 0) {
                boolean zCanScrollVertically = view.canScrollVertically(-1);
                if (!this.nestedScrolled && !this.draggableOnNestedScroll && view == view2 && zCanScrollVertically) {
                    this.draggableOnNestedScrollLastDragIgnored = true;
                    return;
                }
                if (!zCanScrollVertically) {
                    if (i13 > this.collapsedOffset && !H()) {
                        int i14 = top - this.collapsedOffset;
                        iArr[1] = i14;
                        N.T(v10, -i14);
                        y0(4);
                    } else {
                        if (!this.draggable) {
                            return;
                        }
                        iArr[1] = i11;
                        N.T(v10, -i11);
                        y0(1);
                    }
                }
            }
            M(v10.getTop());
            this.lastNestedScrollDy = i11;
            this.nestedScrolled = true;
            this.draggableOnNestedScrollLastDragIgnored = false;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, V v10, View view, int i10, int i11, int i12, int i13, int i14, int[] iArr) {
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void onRestoreInstanceState(CoordinatorLayout coordinatorLayout, V v10, Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(coordinatorLayout, v10, savedState.getSuperState());
        h0(savedState);
        int i10 = savedState.state;
        if (i10 == 1 || i10 == 2) {
            this.state = 4;
            this.lastStableState = 4;
        } else {
            this.state = i10;
            this.lastStableState = i10;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public Parcelable onSaveInstanceState(CoordinatorLayout coordinatorLayout, V v10) {
        return new SavedState(super.onSaveInstanceState(coordinatorLayout, v10), (BottomSheetBehavior<?>) this);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, V v10, View view, View view2, int i10, int i11) {
        this.lastNestedScrollDy = 0;
        this.nestedScrolled = false;
        return (i10 & 2) != 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00a9  */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onStopNestedScroll(androidx.coordinatorlayout.widget.CoordinatorLayout r3, V r4, android.view.View r5, int r6) {
        /*
            r2 = this;
            int r3 = r4.getTop()
            int r6 = r2.Q()
            r0 = 3
            if (r3 != r6) goto Lf
            r2.y0(r0)
            return
        Lf:
            boolean r3 = r2.b0()
            if (r3 == 0) goto L24
            java.lang.ref.WeakReference<android.view.View> r3 = r2.nestedScrollingChildRef
            if (r3 == 0) goto L23
            java.lang.Object r3 = r3.get()
            if (r5 != r3) goto L23
            boolean r3 = r2.nestedScrolled
            if (r3 != 0) goto L24
        L23:
            return
        L24:
            int r3 = r2.lastNestedScrollDy
            r5 = 6
            if (r3 <= 0) goto L39
            boolean r3 = r2.fitToContents
            if (r3 == 0) goto L2f
            goto Laa
        L2f:
            int r3 = r4.getTop()
            int r6 = r2.halfExpandedOffset
            if (r3 <= r6) goto Laa
            goto La9
        L39:
            boolean r3 = r2.hideable
            if (r3 == 0) goto L49
            float r3 = r2.U()
            boolean r3 = r2.C0(r4, r3)
            if (r3 == 0) goto L49
            r0 = 5
            goto Laa
        L49:
            int r3 = r2.lastNestedScrollDy
            r6 = 4
            if (r3 != 0) goto L8e
            int r3 = r4.getTop()
            boolean r1 = r2.fitToContents
            if (r1 == 0) goto L68
            int r5 = r2.fitToContentsOffset
            int r5 = r3 - r5
            int r5 = java.lang.Math.abs(r5)
            int r1 = r2.collapsedOffset
            int r3 = r3 - r1
            int r3 = java.lang.Math.abs(r3)
            if (r5 >= r3) goto L92
            goto Laa
        L68:
            int r1 = r2.halfExpandedOffset
            if (r3 >= r1) goto L7e
            int r1 = r2.collapsedOffset
            int r1 = r3 - r1
            int r1 = java.lang.Math.abs(r1)
            if (r3 >= r1) goto L77
            goto Laa
        L77:
            boolean r3 = r2.D0()
            if (r3 == 0) goto La9
            goto L92
        L7e:
            int r0 = r3 - r1
            int r0 = java.lang.Math.abs(r0)
            int r1 = r2.collapsedOffset
            int r3 = r3 - r1
            int r3 = java.lang.Math.abs(r3)
            if (r0 >= r3) goto L92
            goto La9
        L8e:
            boolean r3 = r2.fitToContents
            if (r3 == 0) goto L94
        L92:
            r0 = r6
            goto Laa
        L94:
            int r3 = r4.getTop()
            int r0 = r2.halfExpandedOffset
            int r0 = r3 - r0
            int r0 = java.lang.Math.abs(r0)
            int r1 = r2.collapsedOffset
            int r3 = r3 - r1
            int r3 = java.lang.Math.abs(r3)
            if (r0 >= r3) goto L92
        La9:
            r0 = r5
        Laa:
            r3 = 0
            r2.F0(r4, r0, r3)
            r2.nestedScrolled = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.onStopNestedScroll(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.View, int):void");
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, V v10, MotionEvent motionEvent) {
        if (!v10.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.state == 1 && actionMasked == 0) {
            return true;
        }
        if (B0()) {
            this.viewDragHelper.F(motionEvent);
        }
        if (actionMasked == 0) {
            g0();
        }
        if (this.velocityTracker == null) {
            this.velocityTracker = VelocityTracker.obtain();
        }
        this.velocityTracker.addMovement(motionEvent);
        if (B0() && actionMasked == 2 && !this.ignoreEvents && Math.abs(this.initialY - motionEvent.getY()) > this.viewDragHelper.z()) {
            this.viewDragHelper.b(v10, motionEvent.getPointerId(motionEvent.getActionIndex()));
        }
        return !this.ignoreEvents;
    }

    public void p0(boolean z10) {
        if (this.hideable != z10) {
            this.hideable = z10;
            if (!z10 && this.state == 5) {
                x0(4);
            }
            G0();
        }
    }

    public void q0(int i10) {
        this.maxHeight = i10;
    }

    public void r0(int i10) {
        this.maxWidth = i10;
    }

    public void s0(int i10) {
        t0(i10, false);
    }

    public final void t0(int i10, boolean z10) {
        if (i10 == -1) {
            if (this.peekHeightAuto) {
                return;
            } else {
                this.peekHeightAuto = true;
            }
        } else {
            if (!this.peekHeightAuto && this.peekHeight == i10) {
                return;
            }
            this.peekHeightAuto = false;
            this.peekHeight = Math.max(0, i10);
        }
        K0(z10);
    }

    public void u0(int i10) {
        this.saveFlags = i10;
    }

    public void v0(int i10) {
        this.significantVelocityThreshold = i10;
    }

    public void w0(boolean z10) {
        this.skipCollapsed = z10;
    }

    public void x0(int i10) {
        if (i10 == 1 || i10 == 2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("STATE_");
            sb2.append(i10 == 1 ? "DRAGGING" : "SETTLING");
            sb2.append(" should not be set externally.");
            throw new IllegalArgumentException(sb2.toString());
        }
        if (!this.hideable && i10 == 5) {
            Log.w(TAG, "Cannot set state: " + i10);
            return;
        }
        int i11 = (i10 == 6 && this.fitToContents && T(i10) <= this.fitToContentsOffset) ? 3 : i10;
        WeakReference<V> weakReference = this.viewRef;
        if (weakReference == null || weakReference.get() == null) {
            y0(i10);
        } else {
            V v10 = this.viewRef.get();
            i0(v10, new a(v10, i11));
        }
    }

    public void y0(int i10) {
        V v10;
        if (this.state == i10) {
            return;
        }
        this.state = i10;
        if (i10 == 4 || i10 == 3 || i10 == 6 || (this.hideable && i10 == 5)) {
            this.lastStableState = i10;
        }
        WeakReference<V> weakReference = this.viewRef;
        if (weakReference == null || (v10 = weakReference.get()) == null) {
            return;
        }
        if (i10 == 3) {
            J0(true);
        } else if (i10 == 6 || i10 == 5 || i10 == 4) {
            J0(false);
        }
        I0(i10, true);
        for (int i11 = 0; i11 < this.callbacks.size(); i11++) {
            this.callbacks.get(i11).c(v10, i10);
        }
        G0();
    }

    public final int z(View view, int i10, int i11) {
        return N.b(view, view.getResources().getString(i10), J(i11));
    }

    public final void z0(View view) {
        boolean z10 = (X() || this.peekHeightAuto) ? false : true;
        if (this.paddingBottomSystemWindowInsets || this.paddingLeftSystemWindowInsets || this.paddingRightSystemWindowInsets || this.marginLeftSystemWindowInsets || this.marginRightSystemWindowInsets || this.marginTopSystemWindowInsets || z10) {
            u.b(view, new d(z10));
        }
    }

    public class h {

        /* renamed from: a, reason: collision with root package name */
        public int f20433a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f20434b;

        /* renamed from: c, reason: collision with root package name */
        public final Runnable f20435c;

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                h.this.f20434b = false;
                H0.c cVar = BottomSheetBehavior.this.viewDragHelper;
                if (cVar != null && cVar.m(true)) {
                    h hVar = h.this;
                    hVar.c(hVar.f20433a);
                    return;
                }
                h hVar2 = h.this;
                BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                if (bottomSheetBehavior.state == 2) {
                    bottomSheetBehavior.y0(hVar2.f20433a);
                }
            }
        }

        public h() {
            this.f20435c = new a();
        }

        public void c(int i10) {
            WeakReference<V> weakReference = BottomSheetBehavior.this.viewRef;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            this.f20433a = i10;
            if (this.f20434b) {
                return;
            }
            BottomSheetBehavior.this.viewRef.get().postOnAnimation(this.f20435c);
            this.f20434b = true;
        }

        public /* synthetic */ h(BottomSheetBehavior bottomSheetBehavior, a aVar) {
            this();
        }
    }

    public BottomSheetBehavior(Context context, AttributeSet attributeSet) {
        int i10;
        super(context, attributeSet);
        this.saveFlags = 0;
        this.fitToContents = true;
        this.updateImportantForAccessibilityOnSiblings = false;
        this.maxWidth = -1;
        this.maxHeight = -1;
        this.stateSettlingTracker = new h(this, null);
        this.halfExpandedRatio = 0.5f;
        this.elevation = -1.0f;
        this.draggable = true;
        this.draggableOnNestedScroll = true;
        this.state = 4;
        this.lastStableState = 4;
        this.hideFriction = HIDE_FRICTION;
        this.callbacks = new ArrayList<>();
        this.initialY = -1;
        this.expandHalfwayActionIds = new SparseIntArray();
        this.dragCallback = new e();
        this.peekHeightGestureInsetBuffer = context.getResources().getDimensionPixelSize(R$dimen.mtrl_min_touch_target_size);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.BottomSheetBehavior_Layout);
        int i11 = R$styleable.BottomSheetBehavior_Layout_backgroundTint;
        if (typedArrayObtainStyledAttributes.hasValue(i11)) {
            this.backgroundTint = W2.c.a(context, typedArrayObtainStyledAttributes, i11);
        }
        if (typedArrayObtainStyledAttributes.hasValue(R$styleable.BottomSheetBehavior_Layout_shapeAppearance)) {
            this.shapeAppearanceModelDefault = l.e(context, attributeSet, R$attr.bottomSheetStyle, DEF_STYLE_RES).m();
        }
        K(context);
        L();
        this.elevation = typedArrayObtainStyledAttributes.getDimension(R$styleable.BottomSheetBehavior_Layout_android_elevation, -1.0f);
        int i12 = R$styleable.BottomSheetBehavior_Layout_android_maxWidth;
        if (typedArrayObtainStyledAttributes.hasValue(i12)) {
            r0(typedArrayObtainStyledAttributes.getDimensionPixelSize(i12, -1));
        }
        int i13 = R$styleable.BottomSheetBehavior_Layout_android_maxHeight;
        if (typedArrayObtainStyledAttributes.hasValue(i13)) {
            q0(typedArrayObtainStyledAttributes.getDimensionPixelSize(i13, -1));
        }
        int i14 = R$styleable.BottomSheetBehavior_Layout_behavior_peekHeight;
        TypedValue typedValuePeekValue = typedArrayObtainStyledAttributes.peekValue(i14);
        if (typedValuePeekValue != null && (i10 = typedValuePeekValue.data) == -1) {
            s0(i10);
        } else {
            s0(typedArrayObtainStyledAttributes.getDimensionPixelSize(i14, -1));
        }
        p0(typedArrayObtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_behavior_hideable, false));
        n0(typedArrayObtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_gestureInsetBottomIgnored, false));
        m0(typedArrayObtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_behavior_fitToContents, true));
        w0(typedArrayObtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_behavior_skipCollapsed, false));
        j0(typedArrayObtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_behavior_draggable, true));
        k0(typedArrayObtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_behavior_draggableOnNestedScroll, true));
        u0(typedArrayObtainStyledAttributes.getInt(R$styleable.BottomSheetBehavior_Layout_behavior_saveFlags, 0));
        o0(typedArrayObtainStyledAttributes.getFloat(R$styleable.BottomSheetBehavior_Layout_behavior_halfExpandedRatio, 0.5f));
        int i15 = R$styleable.BottomSheetBehavior_Layout_behavior_expandedOffset;
        TypedValue typedValuePeekValue2 = typedArrayObtainStyledAttributes.peekValue(i15);
        if (typedValuePeekValue2 != null && typedValuePeekValue2.type == 16) {
            l0(typedValuePeekValue2.data);
        } else {
            l0(typedArrayObtainStyledAttributes.getDimensionPixelOffset(i15, 0));
        }
        v0(typedArrayObtainStyledAttributes.getInt(R$styleable.BottomSheetBehavior_Layout_behavior_significantVelocityThreshold, 500));
        this.paddingBottomSystemWindowInsets = typedArrayObtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_paddingBottomSystemWindowInsets, false);
        this.paddingLeftSystemWindowInsets = typedArrayObtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_paddingLeftSystemWindowInsets, false);
        this.paddingRightSystemWindowInsets = typedArrayObtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_paddingRightSystemWindowInsets, false);
        this.paddingTopSystemWindowInsets = typedArrayObtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_paddingTopSystemWindowInsets, true);
        this.marginLeftSystemWindowInsets = typedArrayObtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_marginLeftSystemWindowInsets, false);
        this.marginRightSystemWindowInsets = typedArrayObtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_marginRightSystemWindowInsets, false);
        this.marginTopSystemWindowInsets = typedArrayObtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_marginTopSystemWindowInsets, false);
        this.shouldRemoveExpandedCorners = typedArrayObtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_shouldRemoveExpandedCorners, true);
        typedArrayObtainStyledAttributes.recycle();
        this.maximumVelocity = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }
}
