package com.obric.oui.swipeaction;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.GestureDetectorCompat;
import androidx.core.view.ViewCompat;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import d.l.n;

/* JADX INFO: compiled from: OSwipeActionLayout.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class OSwipeActionLayout extends FrameLayout {
    private static final int CLOSE_POSITION = 0;
    public static final a Companion = null;
    private static final int DEFAULT_AUTO_OPEN_SPEED = 1000;
    public static final int HORIZONTAL = 3;
    public static final int LEFT = 1;
    private static final int NO_POSITION = -1;
    public static final int RIGHT = 2;
    private b actionsListener;
    private final double autoOpenSpeed;
    private boolean continuousSwipe;
    private int curDraggingState;
    private int direction;
    private boolean disallowIntercept;
    private boolean dragAfterOpened;
    private androidx.customview.widget.c dragHelper;
    private final androidx.customview.widget.c.a dragHelperCallback;
    private View draggedView;
    private final int draggedViewId;
    private int draggingViewLeft;
    private boolean freeDrag;
    private GestureDetectorCompat gestureDetector;
    private final GestureDetector.OnGestureListener gestureDetectorCallBack;
    private int horizontalWidth;
    private int leftFullOpenPending;
    private final int leftItemFirstExpendWidth;
    private boolean leftOpen;
    private View leftView;
    private View leftViewBg;
    private final int leftViewBgId;
    private final int leftViewId;
    private int leftViewPadding;
    private int previousUnprocessedPixel;
    private int rightFullOpenPending;
    private final int rightItemFirstExpendWidth;
    private boolean rightOpen;
    private View rightView;
    private View rightViewBg;
    private final int rightViewBgId;
    private final int rightViewId;
    private int rightViewPadding;
    private boolean swipeEnabled;

    /* JADX INFO: compiled from: OSwipeActionLayout.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: OSwipeActionLayout.kt */
    public interface b {
        void a();

        void a(int r1, boolean r2);

        void b();
    }

    /* JADX INFO: compiled from: OSwipeActionLayout.kt */
    public static final class c extends androidx.customview.widget.c.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OSwipeActionLayout f36260a;

        c(OSwipeActionLayout r1) {
            this.f36260a = r1;
        }

        @Override // androidx.customview.widget.c.a
        public void a(int r3) {
            if (r3 != OSwipeActionLayout.access$getCurDraggingState$p(this.f36260a)) goto L6;
            return;
        L6:
            if (OSwipeActionLayout.access$isIdleAfterMoving(this.f36260a, r3) == false) goto L9;
            OSwipeActionLayout.access$updateState(this.f36260a);
        L26:
            OSwipeActionLayout.access$setCurDraggingState$p(this.f36260a, r3);
            return;
        L9:
            if (r3 != 1) goto L26;
            b r0 = this.f36260a.getActionsListener();
            if (r0 == null) goto L15;
            r0.a();
        L15:
            if (OSwipeActionLayout.access$getRightOpen$p(this.f36260a) == true) goto L21;
            View r1 = OSwipeActionLayout.access$getRightView$p(this.f36260a);
            if (r1 == null) goto L21;
            View r2 = OSwipeActionLayout.access$getRightView$p(this.f36260a);
            o.a(r2);
            r1.offsetLeftAndRight((r2.getWidth() / 2) * (-1));
        L21:
            if (OSwipeActionLayout.access$getLeftOpen$p(this.f36260a) == true) goto L26;
            View r4 = OSwipeActionLayout.access$getLeftView$p(this.f36260a);
            if (r4 == null) goto L26;
            View r5 = OSwipeActionLayout.access$getLeftView$p(this.f36260a);
            o.a(r5);
            r4.offsetLeftAndRight(r5.getWidth() / 2);
            goto L26
        }

        @Override // androidx.customview.widget.c.a
        public void a(View r1, int r2, int r3, int r4, int r5) {
            o.e(r1, "changedView");
            OSwipeActionLayout.access$setDraggingViewLeft$p(this.f36260a, r2);
            int r6 = r4 % 2;
            if (r6 != 0) goto L5;
        L8:
            int r7 = this.f36260a.getDirection();
            if (r7 == 1) goto L26;
            if (r7 != 2) goto L12;
            View r8 = OSwipeActionLayout.access$getLeftViewBg$p(this.f36260a);
            o.a(r8);
            View r9 = OSwipeActionLayout.access$getDraggedView$p(this.f36260a);
            o.a(r9);
            r8.setRight(r9.getLeft());
            View r0 = OSwipeActionLayout.access$getLeftView$p(this.f36260a);
            if (r0 == null) goto L35;
            r0.offsetLeftAndRight(r4 / 2);
            return;
        L35:
            return;
        L12:
            if (r7 != 3) goto L33;
            View r10 = OSwipeActionLayout.access$getLeftView$p(this.f36260a);
            if (r10 == null) goto L18;
            r10.offsetLeftAndRight(r4);
        L18:
            View r11 = OSwipeActionLayout.access$getRightView$p(this.f36260a);
            if (r11 == null) goto L34;
            r11.offsetLeftAndRight(r4);
            return;
        L34:
            return;
        L33:
            return;
        L26:
            View r12 = OSwipeActionLayout.access$getRightViewBg$p(this.f36260a);
            o.a(r12);
            View r13 = OSwipeActionLayout.access$getDraggedView$p(this.f36260a);
            o.a(r13);
            r12.setLeft(r13.getRight());
            View r14 = OSwipeActionLayout.access$getRightView$p(this.f36260a);
            if (r14 == null) goto L36;
            r14.offsetLeftAndRight(r4 / 2);
            return;
        L36:
            return;
        L5:
            if (OSwipeActionLayout.access$getPreviousUnprocessedPixel$p(this.f36260a) == 0) goto L7;
            r4 = r4 + OSwipeActionLayout.access$getPreviousUnprocessedPixel$p(this.f36260a);
            OSwipeActionLayout.access$setPreviousUnprocessedPixel$p(this.f36260a, 0);
            goto L8
        L7:
            OSwipeActionLayout.access$setPreviousUnprocessedPixel$p(this.f36260a, r6);
            goto L8
        }

        @Override // androidx.customview.widget.c.a
        public int a(View r2) {
            o.e(r2, "child");
            return OSwipeActionLayout.access$getHorizontalWidth$p(this.f36260a);
        }

        @Override // androidx.customview.widget.c.a
        public boolean b(View r1, int r2) {
            o.e(r1, "view");
            View r0 = OSwipeActionLayout.access$getDraggedView$p(this.f36260a);
            if (r0 != null) goto L6;
            return false;
        L6:
            if (r1.getId() != r0.getId()) goto L9;
            return true;
        L9:
            return false;
        }

        @Override // androidx.customview.widget.c.a
        public int a(View r3, int r4, int r5) {
            o.e(r3, "child");
            if (this.f36260a.getSwipeEnabled() == true) goto L5;
            return 0;
        L5:
            int r6 = this.f36260a.getDirection();
            if (r6 == 1) goto L15;
            if (r6 == 2) goto L17;
            if (r6 == 3) goto L16;
            return 0;
        L16:
            return OSwipeActionLayout.access$clampHorizontalViewPosition(this.f36260a, r4, r5);
        L17:
            return OSwipeActionLayout.access$clampRightViewPosition(this.f36260a, r4);
        L15:
            return OSwipeActionLayout.access$clampLeftViewPosition(this.f36260a, r4);
        }

        @Override // androidx.customview.widget.c.a
        public void a(View r1, float r2, float r3) {
            o.e(r1, "releasedChild");
            if (this.f36260a.getDirection() != 1) goto L6;
            int r4 = OSwipeActionLayout.access$getFinalXLeftDirection(this.f36260a, r2);
        L14:
            androidx.customview.widget.c r5 = OSwipeActionLayout.access$getDragHelper$p(this.f36260a);
            o.a(r5);
            View r6 = OSwipeActionLayout.access$getDraggedView$p(this.f36260a);
            o.a(r6);
            if (r5.a(r4, r6.getTop()) == false) goto L18;
            ViewCompat.f((View) ZeusTransformUtils.preCheckCast(this.f36260a, View.class, "com.obric.aiagent.plugin"));
            return;
        L18:
            return;
        L6:
            if (this.f36260a.getDirection() != 2) goto L9;
            r4 = OSwipeActionLayout.access$getFinalXRightDirection(this.f36260a, r2);
            goto L14
        L9:
            if (this.f36260a.getDirection() != 3) goto L13;
            r4 = OSwipeActionLayout.access$getFinalXHorizontalDirection(this.f36260a, r2);
            if (r4 != (-1)) goto L14;
            r4 = OSwipeActionLayout.access$getPreviousPosition(this.f36260a);
            goto L14
        L13:
            r4 = 0;
            goto L14
        }
    }

    static {
        Companion = new a(null);
    }

    public OSwipeActionLayout(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public OSwipeActionLayout(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    /* JADX INFO: renamed from: lambda$B3NJW7oNhCUgX-OLtjkyN7tYlEQ, reason: not valid java name */
    public static /* synthetic */ void m1191lambda$B3NJW7oNhCUgXOLtjkyN7tYlEQ(OSwipeActionLayout r0) {
        m1192setupPost$lambda2(r0);
    }

    public static final /* synthetic */ int access$clampHorizontalViewPosition(OSwipeActionLayout r0, int r1, int r2) {
        return r0.clampHorizontalViewPosition(r1, r2);
    }

    public static final /* synthetic */ int access$clampLeftViewPosition(OSwipeActionLayout r0, int r1) {
        return r0.clampLeftViewPosition(r1);
    }

    public static final /* synthetic */ int access$clampRightViewPosition(OSwipeActionLayout r0, int r1) {
        return r0.clampRightViewPosition(r1);
    }

    public static final /* synthetic */ int access$getCurDraggingState$p(OSwipeActionLayout r0) {
        return r0.curDraggingState;
    }

    public static final /* synthetic */ androidx.customview.widget.c access$getDragHelper$p(OSwipeActionLayout r0) {
        return r0.dragHelper;
    }

    public static final /* synthetic */ View access$getDraggedView$p(OSwipeActionLayout r0) {
        return r0.draggedView;
    }

    public static final /* synthetic */ int access$getFinalXHorizontalDirection(OSwipeActionLayout r0, float r1) {
        return r0.getFinalXHorizontalDirection(r1);
    }

    public static final /* synthetic */ int access$getFinalXLeftDirection(OSwipeActionLayout r0, float r1) {
        return r0.getFinalXLeftDirection(r1);
    }

    public static final /* synthetic */ int access$getFinalXRightDirection(OSwipeActionLayout r0, float r1) {
        return r0.getFinalXRightDirection(r1);
    }

    public static final /* synthetic */ int access$getHorizontalWidth$p(OSwipeActionLayout r0) {
        return r0.horizontalWidth;
    }

    public static final /* synthetic */ boolean access$getLeftOpen$p(OSwipeActionLayout r0) {
        return r0.leftOpen;
    }

    public static final /* synthetic */ View access$getLeftView$p(OSwipeActionLayout r0) {
        return r0.leftView;
    }

    public static final /* synthetic */ View access$getLeftViewBg$p(OSwipeActionLayout r0) {
        return r0.leftViewBg;
    }

    public static final /* synthetic */ int access$getPreviousPosition(OSwipeActionLayout r0) {
        return r0.getPreviousPosition();
    }

    public static final /* synthetic */ int access$getPreviousUnprocessedPixel$p(OSwipeActionLayout r0) {
        return r0.previousUnprocessedPixel;
    }

    public static final /* synthetic */ boolean access$getRightOpen$p(OSwipeActionLayout r0) {
        return r0.rightOpen;
    }

    public static final /* synthetic */ View access$getRightView$p(OSwipeActionLayout r0) {
        return r0.rightView;
    }

    public static final /* synthetic */ View access$getRightViewBg$p(OSwipeActionLayout r0) {
        return r0.rightViewBg;
    }

    public static final /* synthetic */ boolean access$isIdleAfterMoving(OSwipeActionLayout r0, int r1) {
        return r0.isIdleAfterMoving(r1);
    }

    public static final /* synthetic */ void access$setCurDraggingState$p(OSwipeActionLayout r0, int r1) {
        r0.curDraggingState = r1;
    }

    public static final /* synthetic */ void access$setDraggingViewLeft$p(OSwipeActionLayout r0, int r1) {
        r0.draggingViewLeft = r1;
    }

    public static final /* synthetic */ void access$setPreviousUnprocessedPixel$p(OSwipeActionLayout r0, int r1) {
        r0.previousUnprocessedPixel = r1;
    }

    public static final /* synthetic */ void access$updateState(OSwipeActionLayout r0) {
        r0.updateState();
    }

    public /* synthetic */ OSwipeActionLayout(Context r2, AttributeSet r3, int r4, int r5, h r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
        if ((r5 & 2) == 0) goto L6;
        r8 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        this(r7, r8, r4);
    }

    public OSwipeActionLayout(Context r5, AttributeSet r6, int r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r9 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r6, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r8, "context");
        super(r8, r9, r7);
        this.direction = 1;
        this.disallowIntercept = true;
        TypedArray r10 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).obtainStyledAttributes(r9, R.styleable.OSwipeActionLayout);
        o.c(r10, "getContext().obtainStyle…eable.OSwipeActionLayout)");
        this.direction = 1;
        this.swipeEnabled = r10.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OSwipeActionLayout_oui_sal_swipeEnabled, "styleable", "OSwipeActionLayout_oui_sal_swipeEnabled"), true);
        this.continuousSwipe = r10.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OSwipeActionLayout_oui_sal_continuousSwipe, "styleable", "OSwipeActionLayout_oui_sal_continuousSwipe"), true);
        this.autoOpenSpeed = r10.getInt(ZeusTransformUtils.mapRes(R.styleable.OSwipeActionLayout_oui_sal_autoMovingSensitivity, "styleable", "OSwipeActionLayout_oui_sal_autoMovingSensitivity"), 1000);
        this.dragAfterOpened = r10.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OSwipeActionLayout_oui_sal_dragAfterOpened, "styleable", "OSwipeActionLayout_oui_sal_dragAfterOpened"), false);
        this.freeDrag = r10.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OSwipeActionLayout_oui_sal_freeDrag, "styleable", "OSwipeActionLayout_oui_sal_freeDrag"), true);
        this.rightViewId = r10.getResourceId(ZeusTransformUtils.mapRes(R.styleable.OSwipeActionLayout_oui_sal_rightItem, "styleable", "OSwipeActionLayout_oui_sal_rightItem"), 0);
        this.rightViewBgId = r10.getResourceId(ZeusTransformUtils.mapRes(R.styleable.OSwipeActionLayout_oui_sal_rightItem_bg, "styleable", "OSwipeActionLayout_oui_sal_rightItem_bg"), 0);
        this.rightItemFirstExpendWidth = (int) r10.getDimension(ZeusTransformUtils.mapRes(R.styleable.OSwipeActionLayout_oui_sal_rightItem_first_expand_width, "styleable", "OSwipeActionLayout_oui_sal_rightItem_first_expand_width"), 0.0f);
        this.rightFullOpenPending = (int) r10.getDimension(ZeusTransformUtils.mapRes(R.styleable.OSwipeActionLayout_oui_sal_rightItem_full_open_pending, "styleable", "OSwipeActionLayout_oui_sal_rightItem_full_open_pending"), 0.0f);
        this.leftViewId = r10.getResourceId(ZeusTransformUtils.mapRes(R.styleable.OSwipeActionLayout_oui_sal_leftItem, "styleable", "OSwipeActionLayout_oui_sal_leftItem"), 0);
        this.leftViewBgId = r10.getResourceId(ZeusTransformUtils.mapRes(R.styleable.OSwipeActionLayout_oui_sal_leftItem_bg, "styleable", "OSwipeActionLayout_oui_sal_leftItem_bg"), 0);
        this.leftItemFirstExpendWidth = (int) r10.getDimension(ZeusTransformUtils.mapRes(R.styleable.OSwipeActionLayout_oui_sal_leftItem_first_expand_width, "styleable", "OSwipeActionLayout_oui_sal_leftItem_first_expand_width"), 0.0f);
        this.leftFullOpenPending = (int) r10.getDimension(ZeusTransformUtils.mapRes(R.styleable.OSwipeActionLayout_oui_sal_leftItem_full_open_pending, "styleable", "OSwipeActionLayout_oui_sal_leftItem_full_open_pending"), 0.0f);
        this.draggedViewId = r10.getResourceId(ZeusTransformUtils.mapRes(R.styleable.OSwipeActionLayout_oui_sal_draggedItem, "styleable", "OSwipeActionLayout_oui_sal_draggedItem"), 0);
        setRightViewPadding((int) r10.getDimension(ZeusTransformUtils.mapRes(R.styleable.OSwipeActionLayout_oui_sal_rightViewPadding, "styleable", "OSwipeActionLayout_oui_sal_rightViewPadding"), 0.0f));
        this.leftViewPadding = (int) r10.getDimension(ZeusTransformUtils.mapRes(R.styleable.OSwipeActionLayout_oui_sal_leftViewPadding, "styleable", "OSwipeActionLayout_oui_sal_leftViewPadding"), 0.0f);
        parametersAdjustment();
        r10.recycle();
        this.gestureDetectorCallBack = (GestureDetector.OnGestureListener) ZeusTransformUtils.preCheckCast(new OSwipeActionLayout$gestureDetectorCallBack$1(this), GestureDetector.OnGestureListener.class, "com.obric.aiagent.plugin");
        this.dragHelperCallback = (androidx.customview.widget.c.a) ZeusTransformUtils.preCheckCast(new c(this), androidx.customview.widget.c.a.class, "com.obric.aiagent.plugin");
    }

    public final int getDirection() {
        return this.direction;
    }

    public final void setDirection(int r1) {
        this.direction = r1;
    }

    public final boolean getSwipeEnabled() {
        return this.swipeEnabled;
    }

    public final void setSwipeEnabled(boolean r1) {
        this.swipeEnabled = r1;
    }

    public final boolean getContinuousSwipe() {
        return this.continuousSwipe;
    }

    public final void setContinuousSwipe(boolean r1) {
        this.continuousSwipe = r1;
    }

    private final void setRightViewPadding(int r1) {
        this.rightViewPadding = r1;
        parametersAdjustment();
    }

    public final b getActionsListener() {
        return this.actionsListener;
    }

    public final void setActionsListener(b r3) {
        this.actionsListener = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin");
    }

    private final boolean isMoving() {
        int r2 = this.curDraggingState;
        if (r2 != 1) goto L5;
        return true;
    L5:
        if (r2 == 2) goto L10;
        return false;
    L10:
        return true;
    }

    private final boolean isClosed() {
        if (this.draggingViewLeft != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // android.view.View
    public void onSizeChanged(int r1, int r2, int r3, int r4) {
        this.horizontalWidth = r1;
        super.onSizeChanged(r1, r2, r3, r4);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r6) {
        o.e(r6, "event");
        if (this.disallowIntercept == false) goto L12;
        if (isViewGroup(this.draggedView) == false) goto L12;
        View r0 = getNeededTouchView(r6, (ViewGroup) ZeusTransformUtils.preCheckCast(this.draggedView, ViewGroup.class, "com.obric.aiagent.plugin"));
        Point r2 = new Point((int) r6.getX(), (int) r6.getY());
        if (r0 == null) goto L12;
        if (isViewTouchTarget(r0, r2) == false) goto L12;
        return false;
    L12:
        if (isSwipeViewTarget(r6) == false) goto L17;
        androidx.customview.widget.c r5 = this.dragHelper;
        o.a(r5);
        if (r5.a(r6) == false) goto L18;
        return true;
    L18:
        return false;
    L17:
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean r1) {
        super.requestDisallowInterceptTouchEvent(r1);
        this.disallowIntercept = r1;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        int r0 = this.draggedViewId;
        if (r0 == 0) goto L5;
        this.draggedView = findViewById(r0);
    L5:
        int r1 = this.leftViewId;
        if (r1 == 0) goto L8;
        this.leftView = findViewById(r1);
    L8:
        int r2 = this.rightViewId;
        if (r2 == 0) goto L11;
        this.rightView = findViewById(r2);
    L11:
        int r3 = this.rightViewBgId;
        if (r3 == 0) goto L14;
        this.rightViewBg = findViewById(r3);
    L14:
        int r4 = this.leftViewBgId;
        if (r4 == 0) goto L18;
        this.leftViewBg = findViewById(r4);
    L18:
        if (this.draggedView == null) goto L61;
        int r5 = this.direction;
        if (r5 != 1) goto L27;
        if (this.rightView != null) goto L27;
        throw new RuntimeException("'oui_sal_rightItem' must be specified");
    L27:
        if (r5 == 2) goto L29;
    L33:
        if (r5 == 1) goto L35;
    L41:
        if (r5 != 2) goto L50;
        if (this.continuousSwipe == true) goto L50;
        if (this.leftView != null) goto L50;
        throw new RuntimeException("Must be specified 'oui_sal_leftItem'  or flag oui_sal_continuousSwipe = true");
    L50:
        if (r5 == 3) goto L52;
    L58:
        this.dragHelper = androidx.customview.widget.c.a((ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.aiagent.plugin"), 1.0f, this.dragHelperCallback);
        this.gestureDetector = new GestureDetectorCompat((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), this.gestureDetectorCallBack);
        setupPost();
        super.onFinishInflate();
        return;
    L52:
        if (this.rightView == null) goto L57;
        if (this.leftView != null) goto L58;
    L57:
        throw new RuntimeException("'oui_sal_leftItem' and 'oui_sal_rightItem' must be specified");
    L35:
        if (this.continuousSwipe == true) goto L41;
        if (this.rightView != null) goto L41;
        throw new RuntimeException("Must be specified 'oui_sal_rightItem' or flag oui_sal_continuousSwipe = true");
    L29:
        if (this.leftView != null) goto L33;
        throw new RuntimeException("'oui_sal_leftItem' must be specified");
    L61:
        throw new RuntimeException("'oui_sal_draggedItem' must be specified");
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r2) {
        o.e(r2, "event");
        if (isSwipeViewTarget(r2) == false) goto L5;
    L8:
        GestureDetectorCompat r0 = this.gestureDetector;
        o.a(r0);
        r0.a(r2);
        androidx.customview.widget.c r1 = this.dragHelper;
        o.a(r1);
        r1.b(r2);
        return true;
    L5:
        if (isMoving() == true) goto L8;
        return super.onTouchEvent(r2);
    }

    @Override // android.view.View
    public void computeScroll() {
        androidx.customview.widget.c r0 = this.dragHelper;
        o.a(r0);
        if (r0.a(true) == false) goto L6;
        ViewCompat.f((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"));
        return;
    }

    public final void close() {
        moveTo(0);
    }

    private final void updateState() {
        if (isClosed() == false) goto L18;
        this.leftOpen = false;
        this.rightOpen = false;
        b r0 = this.actionsListener;
        if (r0 == null) goto L8;
        r0.b();
    L8:
        View r1 = this.rightView;
        if (r1 == null) goto L12;
        r1.layout(0, r1.getTop(), r1.getWidth(), r1.getBottom());
    L12:
        View r2 = this.leftView;
        if (r2 == null) goto L16;
        r2.layout(0, r2.getTop(), r2.getWidth(), r2.getBottom());
    L16:
        this.previousUnprocessedPixel = 0;
        return;
    L18:
        if (getLeftOpenFinished() == false) goto L20;
    L30:
        this.leftOpen = true;
        this.rightOpen = false;
        b r3 = this.actionsListener;
        if (r3 == null) goto L39;
        r3.a(2, getLeftOpenFinished());
        return;
    L39:
        return;
    L20:
        if (getLeftViewOpened() == true) goto L30;
        if (getRightOpenFinished() == false) goto L25;
    L26:
        this.leftOpen = false;
        this.rightOpen = true;
        b r4 = this.actionsListener;
        if (r4 == null) goto L38;
        r4.a(1, getRightOpenFinished());
        return;
    L38:
        return;
    L25:
        if (getRightViewOpened() == true) goto L26;
    }

    private final int clampLeftViewPosition(int r3) {
        if (this.continuousSwipe == false) goto L17;
        if (getRightViewEmpty() == false) goto L17;
        if (this.freeDrag == false) goto L12;
        int r2 = this.horizontalWidth;
        if (r3 <= r2) goto L40;
        return 0;
    L40:
        return n.c(r3, -r2);
    L12:
        if (r3 <= 0) goto L15;
        return 0;
    L15:
        return n.c(r3, -this.horizontalWidth);
    L17:
        if (this.dragAfterOpened == false) goto L30;
        if (this.freeDrag == false) goto L25;
        int r0 = this.horizontalWidth;
        if (r3 <= r0) goto L24;
        return 0;
    L24:
        return n.c(r3, this.leftViewPadding - r0);
    L25:
        if (r3 <= 0) goto L28;
        return 0;
    L28:
        return n.c(r3, this.leftViewPadding - this.horizontalWidth);
    L30:
        if (this.freeDrag == true) goto L32;
        if (r3 <= 0) goto L39;
        return 0;
    L39:
        return n.c(r3, -getRViewWidth());
    L32:
        if (r3 <= this.horizontalWidth) goto L35;
        return 0;
    L35:
        return n.c(r3, -getRViewWidth());
    }

    private final int clampRightViewPosition(int r3) {
        if (this.continuousSwipe == false) goto L17;
        if (getRightViewEmpty() == false) goto L17;
        if (this.freeDrag == false) goto L12;
        int r2 = this.horizontalWidth;
        if (r3 >= (-r2)) goto L41;
        return -r2;
    L41:
        return n.d(r3, r2);
    L12:
        if (r3 >= 0) goto L15;
        return 0;
    L15:
        return n.d(r3, this.horizontalWidth);
    L17:
        if (this.dragAfterOpened == false) goto L30;
        if (this.freeDrag == false) goto L25;
        int r0 = this.horizontalWidth;
        if (r3 >= (-r0)) goto L24;
        return -r0;
    L24:
        return n.d(r3, r0 - this.rightViewPadding);
    L25:
        if (r3 >= 0) goto L28;
        return 0;
    L28:
        return n.d(r3, this.horizontalWidth - this.rightViewPadding);
    L30:
        if (this.freeDrag == false) goto L36;
        int r1 = this.horizontalWidth;
        if (r3 >= (-r1)) goto L35;
        return -r1;
    L35:
        return n.d(r3, getLViewWidth());
    L36:
        if (r3 >= 0) goto L39;
        return 0;
    L39:
        return n.d(r3, getLViewWidth());
    }

    private final int clampHorizontalViewPosition(int r4, int r5) {
        boolean r0 = this.freeDrag;
        if (r0 == false) goto L5;
    L9:
        if (r0 == false) goto L11;
    L15:
        boolean r6 = this.dragAfterOpened;
        if (r6 == true) goto L20;
        if (r4 <= 0) goto L20;
        return n.d(r4, getLViewWidth());
    L20:
        if (r6 == true) goto L24;
        if (r4 >= 0) goto L24;
        return n.c(r4, -getRViewWidth());
    L24:
        if (r4 >= 0) goto L27;
        return n.c(r4, this.leftViewPadding - this.horizontalWidth);
    L27:
        return n.d(r4, this.horizontalWidth - this.rightViewPadding);
    L11:
        if (this.rightOpen == false) goto L15;
        if (r5 <= 0) goto L15;
        return n.d(r4, 0);
    L5:
        if (this.leftOpen == false) goto L9;
        if (r5 >= 0) goto L9;
        return n.c(r4, 0);
    }

    private final int getPreviousPosition() {
        if (this.leftOpen == false) goto L6;
        return getLViewWidth();
    L6:
        if (this.rightOpen == true) goto L11;
        return 0;
    L11:
        return -getRViewWidth();
    }

    private final int getFinalXLeftDirection(float r7) {
        if (this.continuousSwipe == true) goto L5;
    L18:
        double r2 = r7;
        double r4 = this.autoOpenSpeed;
        boolean r0 = true;
        if (r2 <= r4) goto L22;
    L20:
        r0 = false;
    L32:
        if (r0 == true) goto L34;
        return 0;
    L34:
        return -getRViewWidth();
    L22:
        if (r2 < (-r4)) goto L32;
        int r8 = this.draggingViewLeft;
        if (r8 < 0) goto L27;
    L29:
        int r9 = this.draggingViewLeft;
        if (r9 >= 0) goto L20;
        Math.abs(r9);
        int r1 = getRViewWidth() / 2;
        goto L20
    L27:
        if (Math.abs(r8) <= (getRViewWidth() / 2)) goto L29;
    L5:
        if (getRightViewEmpty() == false) goto L15;
        int r3 = this.draggingViewLeft;
        if (r3 >= 0) goto L11;
        if (Math.abs(r3) <= (this.horizontalWidth / 2)) goto L11;
    L13:
        return (-this.horizontalWidth) + this.rightFullOpenPending;
    L11:
        if (r7 < (-this.autoOpenSpeed)) goto L13;
        return 0;
    L15:
        if (isContinuousSwipeToLeft(r7) == false) goto L18;
        return (-this.horizontalWidth) + this.rightFullOpenPending;
    }

    private final int getFinalXRightDirection(float r7) {
        if (this.continuousSwipe == true) goto L5;
    L18:
        double r2 = r7;
        double r4 = this.autoOpenSpeed;
        boolean r0 = true;
        if (r2 <= r4) goto L22;
    L32:
        if (r0 == true) goto L34;
        return 0;
    L34:
        return getLViewWidth();
    L22:
        if (r2 >= (-r4)) goto L24;
    L23:
        r0 = false;
        goto L32
    L24:
        int r8 = this.draggingViewLeft;
        if (r8 > 0) goto L27;
    L29:
        int r9 = this.draggingViewLeft;
        if (r9 <= 0) goto L23;
        Math.abs(r9);
        int r1 = getLViewWidth() / 2;
        goto L23
    L27:
        if (Math.abs(r8) <= (getLViewWidth() / 2)) goto L29;
    L5:
        if (getRightViewEmpty() == false) goto L15;
        int r3 = this.draggingViewLeft;
        if (r3 <= 0) goto L11;
        if (Math.abs(r3) <= (this.horizontalWidth / 2)) goto L11;
    L13:
        return this.horizontalWidth - this.leftFullOpenPending;
    L11:
        if (r7 > this.autoOpenSpeed) goto L13;
        return 0;
    L15:
        if (isContinuousSwipeToRight(r7) == false) goto L18;
        return this.horizontalWidth - this.leftFullOpenPending;
    }

    private final int getFinalXHorizontalDirection(float r2) {
        if (isSwipeToOpenLeft(r2) == false) goto L7;
        return getLViewWidth();
    L7:
        if (isSwipeToOpenRight(r2) == false) goto L11;
        return -getRViewWidth();
    L11:
        if (isSwipeToClose(r2) == false) goto L14;
        return 0;
    L14:
        return -1;
    }

    private final boolean isContinuousSwipeToRight(float r5) {
        if (r5 > this.autoOpenSpeed) goto L5;
    L6:
        int r6 = this.draggingViewLeft;
        if (r6 > 0) goto L9;
    L11:
        return false;
    L9:
        if (Math.abs(r6) <= (this.horizontalWidth / 2)) goto L11;
    L10:
        return true;
    L5:
        if (Math.abs(this.draggingViewLeft) > getLViewWidth()) goto L10;
        goto L6
    }

    private final boolean isContinuousSwipeToLeft(float r5) {
        if (r5 < (-this.autoOpenSpeed)) goto L5;
    L6:
        int r6 = this.draggingViewLeft;
        if (r6 < 0) goto L9;
    L11:
        return false;
    L9:
        if (Math.abs(r6) <= (this.horizontalWidth / 2)) goto L11;
    L10:
        return true;
    L5:
        if (Math.abs(this.draggingViewLeft) > getRViewWidth()) goto L10;
        goto L6
    }

    private final boolean isSwipeToOpenRight(float r7) {
        if (r7 <= 0.0f) goto L5;
        return false;
    L5:
        int r0 = this.draggingViewLeft;
        if (r0 < 0) goto L8;
    L9:
        if (r0 < 0) goto L11;
        return false;
    L11:
        if (Math.abs(r0) <= (getRViewWidth() / 2)) goto L15;
    L12:
        return true;
    L15:
        return false;
    L8:
        if (r7 < (-this.autoOpenSpeed)) goto L12;
        goto L9
    }

    private final boolean isSwipeToOpenLeft(float r7) {
        if (r7 >= 0.0f) goto L5;
        return false;
    L5:
        int r0 = this.draggingViewLeft;
        if (r0 > 0) goto L8;
    L9:
        if (r0 > 0) goto L11;
        return false;
    L11:
        if (Math.abs(r0) <= (getLViewWidth() / 2)) goto L15;
    L12:
        return true;
    L15:
        return false;
    L8:
        if (r7 > this.autoOpenSpeed) goto L12;
        goto L9
    }

    private final boolean isSwipeToClose(float r6) {
        int r0 = this.draggingViewLeft;
        if (r0 >= 0) goto L5;
    L6:
        if (r0 <= 0) goto L8;
    L9:
        if (r0 >= 0) goto L11;
    L12:
        int r7 = this.draggingViewLeft;
        if (r7 <= 0) goto L15;
    L17:
        return false;
    L15:
        if (Math.abs(r7) >= (getRViewWidth() / 2)) goto L17;
    L16:
        return true;
    L11:
        if (Math.abs(r0) < (getLViewWidth() / 2)) goto L16;
    L8:
        if (r6 > this.autoOpenSpeed) goto L16;
    L5:
        if (r6 < (-this.autoOpenSpeed)) goto L16;
        goto L6
    }

    private final void setupPost() {
        post(new $$Lambda$OSwipeActionLayout$B3NJW7oNhCUgXOLtjkyN7tYlEQ(this));
    }

    /* JADX INFO: renamed from: setupPost$lambda-2, reason: not valid java name */
    private static final void m1192setupPost$lambda2(OSwipeActionLayout r2) {
        o.e(r2, "this$0");
        int r0 = r2.direction;
        if (r0 != 1) goto L5;
        View r1 = r2.rightView;
        o.a(r1);
        r1.setX(r2.horizontalWidth);
        return;
    L5:
        if (r0 != 2) goto L7;
        View r3 = r2.leftView;
        o.a(r3);
        View r4 = r2.leftView;
        o.a(r4);
        r3.setX(-r4.getWidth());
        return;
    L7:
        if (r0 != 3) goto L15;
        View r5 = r2.rightView;
        o.a(r5);
        r5.setX(r2.horizontalWidth);
        View r6 = r2.leftView;
        o.a(r6);
        View r7 = r2.leftView;
        o.a(r7);
        r6.setX(-r7.getWidth());
        return;
    }

    private final boolean isViewTouchTarget(View r2, Point r3) {
        if (r3.y >= r2.getTop()) goto L5;
    L11:
        return false;
    L5:
        if (r3.y >= r2.getBottom()) goto L11;
        if (r3.x < r2.getLeft()) goto L11;
        if (r3.y >= r2.getRight()) goto L11;
        return true;
    }

    private final View getNeededTouchView(MotionEvent r6, ViewGroup r7) {
        o.a(r7);
        if (r7.onInterceptTouchEvent(r6) == true) goto L5;
        int r0 = r7.getChildCount();
        int r2 = 0;
    L7:
        if (r2 >= r0) goto L13;
        int r3 = r2 + 1;
        View r4 = r7.getChildAt(r2);
        o.c(r4, "rootView.getChildAt(i)");
        if (isViewGroup(r4) == true) goto L12;
        r2 = r3;
        goto L7
    L12:
        return getNeededTouchView(r6, (ViewGroup) ZeusTransformUtils.preCheckCast(r4, ViewGroup.class, "com.obric.aiagent.plugin"));
    L13:
        return null;
    L5:
        return (View) ZeusTransformUtils.preCheckCast(r7, View.class, "com.obric.aiagent.plugin");
    }

    private final boolean isViewGroup(View r1) {
        return ZeusTransformUtils.instanceOf(r1, ViewGroup.class);
    }

    private final boolean isSwipeViewTarget(MotionEvent r4) {
        int[] r0 = new int[2];
        View r1 = this.draggedView;
        o.a(r1);
        r1.getLocationOnScreen(r0);
        int r2 = r0[1];
        View r3 = this.draggedView;
        o.a(r3);
        int r5 = r2 + r3.getMeasuredHeight();
        int r6 = r0[1];
        int r7 = (int) r4.getRawY();
        if ((r6 + 1) > r7) goto L7;
        if (r7 >= r5) goto L7;
        return true;
    L7:
        return false;
    }

    private final boolean isIdleAfterMoving(int r3) {
        int r2 = this.curDraggingState;
        if (r2 != 1) goto L5;
    L6:
        if (r3 == 0) goto L10;
    L8:
        return false;
    L10:
        return true;
    L5:
        if (r2 != 2) goto L8;
        goto L6
    }

    private final boolean getRightViewOpened() {
        if (this.rightView != null) goto L5;
    L7:
        return false;
    L5:
        if (this.draggingViewLeft != (-getRViewWidth())) goto L7;
        return true;
    }

    private final boolean getLeftViewOpened() {
        if (this.leftView != null) goto L5;
    L7:
        return false;
    L5:
        if (this.draggingViewLeft != getLViewWidth()) goto L7;
        return true;
    }

    private final boolean getRightOpenFinished() {
        if (this.draggingViewLeft != ((-this.horizontalWidth) + this.rightFullOpenPending)) goto L5;
        return true;
    L5:
        return false;
    }

    private final boolean getLeftOpenFinished() {
        if (this.draggingViewLeft != (this.horizontalWidth - this.leftFullOpenPending)) goto L5;
        return true;
    L5:
        return false;
    }

    private final int getLViewWidth() {
        return this.leftItemFirstExpendWidth;
    }

    private final int getRViewWidth() {
        return this.rightItemFirstExpendWidth;
    }

    private final boolean getRightViewEmpty() {
        if (this.rightView != null) goto L5;
        return true;
    L5:
        return false;
    }

    private final void parametersAdjustment() {
        if (this.continuousSwipe == false) goto L8;
        if (this.direction == 3) goto L8;
        this.dragAfterOpened = true;
    L8:
        if (this.direction != 3) goto L11;
        setRightViewPadding(0);
        this.leftViewPadding = 0;
        return;
    }

    private final void moveTo(int r4) {
        androidx.customview.widget.c r0 = this.dragHelper;
        o.a(r0);
        View r1 = this.draggedView;
        o.a(r1);
        View r2 = this.draggedView;
        o.a(r2);
        r0.a(r1, r4, r2.getTop());
        ViewCompat.f((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"));
    }
}
