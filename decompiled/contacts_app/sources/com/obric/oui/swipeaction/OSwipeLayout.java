package com.obric.oui.swipeaction;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.customview.widget.ViewDragHelper;
import com.obric.common.oui.R;
import com.obric.oui.layout.OUIFrameLayout;
import com.ss.android.http.legacy.protocol.HTTP;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class OSwipeLayout extends OUIFrameLayout {
    private static final int DRAG_BOTTOM = 8;
    private static final int DRAG_LEFT = 1;
    private static final int DRAG_RIGHT = 2;
    private static final int DRAG_TOP = 4;
    private static final DragEdge DefaultDragEdge = null;

    @Deprecated
    public static final int EMPTY_LAYOUT = -1;
    View.OnClickListener clickListener;
    public boolean findAncestorNodeMode;
    private GestureDetector gestureDetector;
    private Rect hitBottomRect;
    private Rect hitSurfaceRect;
    View.OnLongClickListener longClickListener;
    private boolean mClickToClose;
    private DragEdge mCurrentDragEdge;
    private DoubleClickListener mDoubleClickListener;
    private int mDragDistance;
    private LinkedHashMap<DragEdge, View> mDragEdges;
    private ViewDragHelper mDragHelper;
    private ViewDragHelper.Callback mDragHelperCallback;
    private float[] mEdgeSwipesOffset;
    private int mEventCounter;
    private boolean mIsBeingDragged;
    private boolean mIsDownOutSurfaceView;
    private boolean mIsQuickDeleteTriggered;
    private float mLinearLeft;
    private List<OnLayout> mOnLayoutListeners;
    protected int mOverrideDragDistance;
    private boolean mQuickDeleteEnabled;
    private QuickDeleteListener mQuickDeleteListener;
    protected float mQuickDeleteMax;
    protected float mQuickDeleteThreshold;
    private Map<View, ArrayList<OnRevealListener>> mRevealListeners;
    private Map<View, Boolean> mShowEntirely;
    private ShowMode mShowMode;
    private List<SwipeDenier> mSwipeDeniers;
    private boolean mSwipeEnabled;
    private List<SwipeListener> mSwipeListeners;
    private boolean[] mSwipesEnabled;
    private int mTouchSlop;
    private Map<View, Rect> mViewBoundCache;
    private float mWillOpenPercentAfterClose;
    private float mWillOpenPercentAfterOpen;
    private float sX;
    private float sY;

    /* JADX INFO: renamed from: com.obric.oui.swipeaction.OSwipeLayout$4, reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$com$obric$oui$swipeaction$OSwipeLayout$DragEdge = null;

        static {
            int[] r0 = new int[DragEdge.values().length];
            $SwitchMap$com$obric$oui$swipeaction$OSwipeLayout$DragEdge = r0;
            r0[DragEdge.Top.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$obric$oui$swipeaction$OSwipeLayout$DragEdge[DragEdge.Bottom.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$com$obric$oui$swipeaction$OSwipeLayout$DragEdge[DragEdge.Left.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$com$obric$oui$swipeaction$OSwipeLayout$DragEdge[DragEdge.Right.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    public interface DoubleClickListener {
        void onDoubleClick(OSwipeLayout r1, boolean r2);
    }

    public static final enum DragEdge extends Enum<DragEdge> {
        private static final /* synthetic */ DragEdge[] $VALUES = null;
        public static final DragEdge Bottom = null;
        public static final DragEdge Left = null;
        public static final DragEdge Right = null;
        public static final DragEdge Top = null;

        private DragEdge(String r1, int r2) {
            super(r1, r2);
        }

        public static DragEdge valueOf(String r1) {
            return (DragEdge) Enum.valueOf(DragEdge.class, r1);
        }

        public static DragEdge[] values() {
            return (DragEdge[]) $VALUES.clone();
        }

        static {
            DragEdge r0 = new DragEdge("Left", 0);
            Left = r0;
            DragEdge r1 = new DragEdge("Top", 1);
            Top = r1;
            DragEdge r3 = new DragEdge("Right", 2);
            Right = r3;
            DragEdge r5 = new DragEdge("Bottom", 3);
            Bottom = r5;
            $VALUES = new DragEdge[]{r0, r1, r3, r5};
        }
    }

    public interface OnLayout {
        void onLayout(OSwipeLayout r1);
    }

    public interface OnRevealListener {
        void onReveal(View r1, DragEdge r2, float r3, int r4);
    }

    public interface QuickDeleteListener {
        void onQuickDeleteAction();

        void onQuickDeleteStateChanged(boolean r1);
    }

    public static final enum ShowMode extends Enum<ShowMode> {
        private static final /* synthetic */ ShowMode[] $VALUES = null;
        public static final ShowMode LayDown = null;
        public static final ShowMode PullOut = null;

        private ShowMode(String r1, int r2) {
            super(r1, r2);
        }

        public static ShowMode valueOf(String r1) {
            return (ShowMode) Enum.valueOf(ShowMode.class, r1);
        }

        public static ShowMode[] values() {
            return (ShowMode[]) $VALUES.clone();
        }

        static {
            ShowMode r0 = new ShowMode("LayDown", 0);
            LayDown = r0;
            ShowMode r1 = new ShowMode("PullOut", 1);
            PullOut = r1;
            $VALUES = new ShowMode[]{r0, r1};
        }
    }

    public static final enum Status extends Enum<Status> {
        private static final /* synthetic */ Status[] $VALUES = null;
        public static final Status Close = null;
        public static final Status Middle = null;
        public static final Status Open = null;

        private Status(String r1, int r2) {
            super(r1, r2);
        }

        public static Status valueOf(String r1) {
            return (Status) Enum.valueOf(Status.class, r1);
        }

        public static Status[] values() {
            return (Status[]) $VALUES.clone();
        }

        static {
            Status r0 = new Status("Middle", 0);
            Middle = r0;
            Status r1 = new Status("Open", 1);
            Open = r1;
            Status r3 = new Status(HTTP.CONN_CLOSE, 2);
            Close = r3;
            $VALUES = new Status[]{r0, r1, r3};
        }
    }

    public interface SwipeDenier {
        boolean shouldDenySwipe(MotionEvent r1);
    }

    class SwipeDetector extends GestureDetector.SimpleOnGestureListener {
        final /* synthetic */ OSwipeLayout this$0;

        SwipeDetector(OSwipeLayout r1) {
            this.this$0 = r1;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent r2) {
            if (OSwipeLayout.access$1300(this.this$0) == false) goto L8;
            if (OSwipeLayout.access$1400(this.this$0, r2) == false) goto L8;
            this.this$0.close();
        L8:
            return super.onSingleTapUp(r2);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent r6) {
            if (OSwipeLayout.access$1500(this.this$0) == null) goto L21;
            View r0 = this.this$0.getCurrentBottomView();
            View r2 = this.this$0.getSurfaceView();
            if (r0 != null) goto L7;
        L15:
            r0 = r2;
        L16:
            DoubleClickListener r7 = OSwipeLayout.access$1500(this.this$0);
            OSwipeLayout r5 = this.this$0;
            if (r0 != r2) goto L19;
            boolean r1 = true;
        L20:
            r7.onDoubleClick(r5, r1);
            goto L21
        L19:
            r1 = false;
            goto L20
        L7:
            if (r6.getX() <= r0.getLeft()) goto L15;
            if (r6.getX() >= r0.getRight()) goto L15;
            if (r6.getY() <= r0.getTop()) goto L15;
            if (r6.getY() >= r0.getBottom()) goto L15;
        L21:
            return true;
        }
    }

    public interface SwipeListener {
        void onClose(OSwipeLayout r1);

        void onHandRelease(OSwipeLayout r1, float r2, float r3);

        void onOpen(OSwipeLayout r1);

        void onStartClose(OSwipeLayout r1);

        void onStartOpen(OSwipeLayout r1);

        void onUpdate(OSwipeLayout r1, int r2, int r3);
    }

    static /* synthetic */ DragEdge access$000(OSwipeLayout r0) {
        return r0.mCurrentDragEdge;
    }

    static /* synthetic */ int access$100(OSwipeLayout r0) {
        return r0.mDragDistance;
    }

    static /* synthetic */ void access$1000(OSwipeLayout r0) {
        r0.captureChildrenBound();
    }

    static /* synthetic */ void access$1100(OSwipeLayout r0) {
        r0.performAdapterViewItemClick();
    }

    static /* synthetic */ boolean access$1200(OSwipeLayout r0) {
        return r0.performAdapterViewItemLongClick();
    }

    static /* synthetic */ boolean access$1300(OSwipeLayout r0) {
        return r0.mClickToClose;
    }

    static /* synthetic */ boolean access$1400(OSwipeLayout r0, MotionEvent r1) {
        return r0.isTouchOnSurface(r1);
    }

    static /* synthetic */ DoubleClickListener access$1500(OSwipeLayout r0) {
        return r0.mDoubleClickListener;
    }

    static /* synthetic */ boolean access$200(OSwipeLayout r0) {
        return r0.mQuickDeleteEnabled;
    }

    static /* synthetic */ ViewDragHelper access$300(OSwipeLayout r0) {
        return r0.mDragHelper;
    }

    static /* synthetic */ float access$400(OSwipeLayout r0) {
        return r0.mLinearLeft;
    }

    static /* synthetic */ float access$402(OSwipeLayout r0, float r1) {
        r0.mLinearLeft = r1;
        return r1;
    }

    static /* synthetic */ float access$416(OSwipeLayout r1, float r2) {
        float r0 = r1.mLinearLeft + r2;
        r1.mLinearLeft = r0;
        return r0;
    }

    static /* synthetic */ ShowMode access$500(OSwipeLayout r0) {
        return r0.mShowMode;
    }

    static /* synthetic */ QuickDeleteListener access$600(OSwipeLayout r0) {
        return r0.mQuickDeleteListener;
    }

    static /* synthetic */ boolean access$702(OSwipeLayout r0, boolean r1) {
        r0.mIsQuickDeleteTriggered = r1;
        return r1;
    }

    static /* synthetic */ List access$800(OSwipeLayout r0) {
        return r0.mSwipeListeners;
    }

    static /* synthetic */ Rect access$900(OSwipeLayout r0, DragEdge r1) {
        return r0.computeBottomLayDown(r1);
    }

    static {
        DefaultDragEdge = DragEdge.Right;
    }

    public void setQuickDeleteEnabled(boolean r1) {
        this.mQuickDeleteEnabled = r1;
    }

    public void setQuickDeleteThreshold(float r1) {
        this.mQuickDeleteThreshold = r1;
    }

    public void setQuickDeleteMax(float r1) {
        this.mQuickDeleteMax = r1;
    }

    public void setQuickDeleteListener(QuickDeleteListener r1) {
        this.mQuickDeleteListener = r1;
    }

    public void removeQuickDeleteListeners() {
        Iterator<SwipeListener> r0 = this.mSwipeListeners.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        SwipeListener r1 = r0.next();
        if ((r1 instanceof OSwipeQuickDeleteHelper) == false) goto L4;
        this.mSwipeListeners.remove(r1);
        goto L4
    L8:
        this.mQuickDeleteListener = null;
    }

    public void setOverrideDragDistance(int r1) {
        this.mOverrideDragDistance = r1;
    }

    public OSwipeLayout(Context r2) {
        this(r2, null);
    }

    public OSwipeLayout(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public OSwipeLayout(Context r7, AttributeSet r8, int r9) {
        super(r7, r8, r9);
        this.mCurrentDragEdge = DefaultDragEdge;
        this.mDragDistance = 0;
        this.mDragEdges = new LinkedHashMap();
        this.mEdgeSwipesOffset = new float[4];
        this.mSwipeListeners = new ArrayList();
        this.mSwipeDeniers = new ArrayList();
        this.mRevealListeners = new HashMap();
        this.mShowEntirely = new HashMap();
        this.mViewBoundCache = new HashMap();
        this.mSwipeEnabled = true;
        this.mSwipesEnabled = new boolean[]{true, true, true, true};
        this.mClickToClose = false;
        this.mWillOpenPercentAfterOpen = 0.75f;
        this.mWillOpenPercentAfterClose = 0.25f;
        this.mQuickDeleteEnabled = false;
        this.mQuickDeleteThreshold = 1.5f;
        this.mQuickDeleteMax = 2.0f;
        this.mOverrideDragDistance = -1;
        this.mIsQuickDeleteTriggered = false;
        this.mDragHelperCallback = new AnonymousClass1(this);
        this.mEventCounter = 0;
        this.sX = -1.0f;
        this.sY = -1.0f;
        this.findAncestorNodeMode = false;
        this.gestureDetector = new GestureDetector(getContext(), new SwipeDetector(this));
        this.mDragHelper = ViewDragHelper.create(this, this.mDragHelperCallback);
        this.mTouchSlop = ViewConfiguration.get(r7).getScaledTouchSlop();
        TypedArray r10 = r7.obtainStyledAttributes(r8, R.styleable.OSwipeLayout);
        int r11 = r10.getInt(R.styleable.OSwipeLayout_oui_drag_edge, 2);
        this.mEdgeSwipesOffset[DragEdge.Left.ordinal()] = r10.getDimension(R.styleable.OSwipeLayout_oui_leftEdgeSwipeOffset, 0.0f);
        this.mEdgeSwipesOffset[DragEdge.Right.ordinal()] = r10.getDimension(R.styleable.OSwipeLayout_oui_rightEdgeSwipeOffset, 0.0f);
        this.mEdgeSwipesOffset[DragEdge.Top.ordinal()] = r10.getDimension(R.styleable.OSwipeLayout_oui_topEdgeSwipeOffset, 0.0f);
        this.mEdgeSwipesOffset[DragEdge.Bottom.ordinal()] = r10.getDimension(R.styleable.OSwipeLayout_oui_bottomEdgeSwipeOffset, 0.0f);
        setClickToClose(r10.getBoolean(R.styleable.OSwipeLayout_oui_clickToClose, this.mClickToClose));
        if ((r11 & 1) != 1) goto L6;
        this.mDragEdges.put(DragEdge.Left, null);
    L6:
        if ((r11 & 4) != 4) goto L9;
        this.mDragEdges.put(DragEdge.Top, null);
    L9:
        if ((r11 & 2) != 2) goto L12;
        this.mDragEdges.put(DragEdge.Right, null);
    L12:
        if ((r11 & 8) != 8) goto L14;
        this.mDragEdges.put(DragEdge.Bottom, null);
    L14:
        int r12 = r10.getInt(R.styleable.OSwipeLayout_oui_show_mode, ShowMode.PullOut.ordinal());
        this.mShowMode = ShowMode.values()[r12];
        r10.recycle();
    }

    public void addSwipeListener(SwipeListener r1) {
        this.mSwipeListeners.add(r1);
    }

    public void removeSwipeListener(SwipeListener r1) {
        this.mSwipeListeners.remove(r1);
    }

    public void removeAllSwipeListener() {
        this.mSwipeListeners.clear();
    }

    public void addSwipeDenier(SwipeDenier r1) {
        this.mSwipeDeniers.add(r1);
    }

    public void removeSwipeDenier(SwipeDenier r1) {
        this.mSwipeDeniers.remove(r1);
    }

    public void removeAllSwipeDeniers() {
        this.mSwipeDeniers.clear();
    }

    public void addRevealListener(int r3, OnRevealListener r4) {
        View r5 = findViewById(r3);
        if (r5 == null) goto L13;
        if (this.mShowEntirely.containsKey(r5) == true) goto L8;
        this.mShowEntirely.put(r5, false);
    L8:
        if (this.mRevealListeners.get(r5) != null) goto L10;
        this.mRevealListeners.put(r5, new ArrayList());
    L10:
        this.mRevealListeners.get(r5).add(r4);
        return;
    L13:
        throw new IllegalArgumentException("Child does not belong to SwipeListener.");
    }

    public void addRevealListener(int[] r4, OnRevealListener r5) {
        int r0 = r4.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        addRevealListener(r4[r1], r5);
        r1 = r1 + 1;
        goto L3
    }

    public void removeRevealListener(int r2, OnRevealListener r3) {
        View r4 = findViewById(r2);
        if (r4 != null) goto L5;
        return;
    L5:
        this.mShowEntirely.remove(r4);
        if (this.mRevealListeners.containsKey(r4) == false) goto L9;
        this.mRevealListeners.get(r4).remove(r3);
        return;
    }

    public void removeAllRevealListeners(int r2) {
        View r3 = findViewById(r2);
        if (r3 == null) goto L6;
        this.mRevealListeners.remove(r3);
        this.mShowEntirely.remove(r3);
        return;
    }

    private void captureChildrenBound() {
        View r0 = getCurrentBottomView();
        View r1 = getSurfaceView();
        if (getOpenStatus() != Status.Close) goto L6;
        this.mViewBoundCache.remove(r0);
        this.mViewBoundCache.remove(r1);
        return;
    L6:
        int r4 = 0;
        View[] r3 = {r1, r0};
    L7:
        if (r4 >= 2) goto L12;
        View r2 = r3[r4];
        Rect r5 = this.mViewBoundCache.get(r2);
        if (r5 != null) goto L11;
        r5 = new Rect();
        this.mViewBoundCache.put(r2, r5);
    L11:
        r5.left = r2.getLeft();
        r5.top = r2.getTop();
        r5.right = r2.getRight();
        r5.bottom = r2.getBottom();
        r4 = r4 + 1;
        goto L7
    }

    protected boolean isViewTotallyFirstShowed(View r7, Rect r8, DragEdge r9, int r10, int r11, int r12, int r13) {
        if (this.mShowEntirely.get(r7).booleanValue() == false) goto L5;
        return false;
    L5:
        int r14 = r8.left;
        int r1 = r8.right;
        int r2 = r8.top;
        int r15 = r8.bottom;
        if (getShowMode() != ShowMode.LayDown) goto L21;
        if (r9 != DragEdge.Right) goto L11;
        if (r12 > r14) goto L11;
    L41:
        return true;
    L11:
        if (r9 != DragEdge.Left) goto L14;
        if (r10 >= r1) goto L41;
    L14:
        if (r9 != DragEdge.Top) goto L17;
        if (r11 >= r15) goto L41;
    L17:
        if (r9 != DragEdge.Bottom) goto L39;
        if (r13 <= r2) goto L41;
        return false;
    L39:
        return false;
    L21:
        if (getShowMode() == ShowMode.PullOut) goto L23;
        return false;
    L23:
        if (r9 != DragEdge.Right) goto L27;
        if (r1 <= getWidth()) goto L41;
    L27:
        if (r9 != DragEdge.Left) goto L31;
        if (r14 >= getPaddingLeft()) goto L41;
    L31:
        if (r9 != DragEdge.Top) goto L35;
        if (r2 >= getPaddingTop()) goto L41;
    L35:
        if (r9 == DragEdge.Bottom) goto L37;
        return false;
    L37:
        if (r15 <= getHeight()) goto L41;
        return false;
    }

    protected boolean isViewShowing(View r9, Rect r10, DragEdge r11, int r12, int r13, int r14, int r15) {
        int r16 = r10.left;
        int r0 = r10.right;
        int r1 = r10.top;
        int r17 = r10.bottom;
        if (getShowMode() != ShowMode.LayDown) goto L23;
        int r8 = AnonymousClass4.$SwitchMap$com$obric$oui$swipeaction$OSwipeLayout$DragEdge[r11.ordinal()];
        if (r8 == 1) goto L19;
        if (r8 == 2) goto L16;
        if (r8 == 3) goto L13;
        if (r8 != 4) goto L68;
        if (r14 <= r16) goto L50;
        if (r14 > r0) goto L52;
        return true;
    L52:
        return false;
    L50:
        return false;
    L68:
        return false;
    L13:
        if (r12 >= r0) goto L53;
        if (r12 < r16) goto L54;
        return true;
    L54:
        return false;
    L53:
        return false;
    L16:
        if (r15 <= r1) goto L55;
        if (r15 > r17) goto L56;
        return true;
    L56:
        return false;
    L55:
        return false;
    L19:
        if (r13 < r1) goto L57;
        if (r13 >= r17) goto L58;
        return true;
    L58:
        return false;
    L57:
        return false;
    L23:
        if (getShowMode() != ShowMode.PullOut) goto L59;
        int r18 = AnonymousClass4.$SwitchMap$com$obric$oui$swipeaction$OSwipeLayout$DragEdge[r11.ordinal()];
        if (r18 == 1) goto L46;
        if (r18 == 2) goto L41;
        if (r18 == 3) goto L36;
        if (r18 == 4) goto L31;
        return false;
    L31:
        if (r16 <= getWidth()) goto L33;
        return false;
    L33:
        if (r0 <= getWidth()) goto L61;
        return true;
    L61:
        return false;
    L36:
        if (r0 >= getPaddingLeft()) goto L38;
        return false;
    L38:
        if (r16 >= getPaddingLeft()) goto L63;
        return true;
    L63:
        return false;
    L41:
        if (r1 < getHeight()) goto L43;
        return false;
    L43:
        if (r1 < getPaddingTop()) goto L65;
        return true;
    L65:
        return false;
    L46:
        if (r1 < getPaddingTop()) goto L48;
        return false;
    L48:
        if (r17 < getPaddingTop()) goto L67;
        return true;
    L67:
        return false;
    L59:
        return false;
    }

    protected Rect getRelativePosition(View r5) {
        Rect r0 = new Rect(r5.getLeft(), r5.getTop(), 0, 0);
        View r1 = r5;
    L4:
        if (r1.getParent() == null) goto L11;
        if (r1 == getRootView()) goto L11;
        r1 = (View) r1.getParent();
        if (r1 == this) goto L11;
        r0.left += r1.getLeft();
        r0.top += r1.getTop();
    L11:
        r0.right = r0.left + r5.getMeasuredWidth();
        r0.bottom = r0.top + r5.getMeasuredHeight();
        return r0;
    }

    protected void dispatchSwipeEvent(int r4, int r5, int r6, int r7) {
        DragEdge r0 = getDragEdge();
        boolean r2 = false;
        if (r0 != DragEdge.Left) goto L7;
        if (r6 < 0) goto L19;
    L18:
        r2 = true;
    L19:
        dispatchSwipeEvent(r4, r5, r2);
        return;
    L7:
        if (r0 != DragEdge.Right) goto L11;
        if (r6 <= 0) goto L18;
    L11:
        if (r0 != DragEdge.Top) goto L15;
        if (r7 >= 0) goto L18;
    L15:
        if (r0 != DragEdge.Bottom) goto L18;
        if (r7 <= 0) goto L18;
        goto L18
    }

    protected void dispatchSwipeEvent(int r7, int r8, boolean r9) {
        safeBottomView();
        Status r0 = getOpenStatus();
        if (this.mSwipeListeners.isEmpty() == true) goto L37;
        this.mEventCounter++;
        Iterator<SwipeListener> r1 = this.mSwipeListeners.iterator();
    L6:
        if (r1.hasNext() == false) goto L14;
        SwipeListener r3 = r1.next();
        if (this.mEventCounter != 1) goto L12;
        if (r9 == false) goto L11;
        r3.onStartOpen(this);
        goto L12
    L11:
        r3.onStartClose(this);
    L12:
        r3.onUpdate(this, r7 - getPaddingLeft(), r8 - getPaddingTop());
        goto L6
    L14:
        if (r0 != Status.Close) goto L21;
        Iterator<SwipeListener> r10 = this.mSwipeListeners.iterator();
    L17:
        if (r10.hasNext() == false) goto L19;
        r10.next().onClose(this);
        goto L17
    L19:
        this.mEventCounter = 0;
    L21:
        if (r0 != Status.Open) goto L38;
        View r11 = getCurrentBottomView();
        if (r11 == null) goto L25;
        r11.setEnabled(true);
    L25:
        Iterator<SwipeListener> r12 = this.mSwipeListeners.iterator();
    L27:
        if (r12.hasNext() == false) goto L29;
        r12.next().onOpen(this);
        goto L27
    L29:
        this.mEventCounter = 0;
        return;
    L38:
        return;
    }

    private void safeBottomView() {
        Status r0 = getOpenStatus();
        List<View> r1 = getBottomViews();
        if (r0 != Status.Close) goto L12;
        Iterator<View> r3 = r1.iterator();
    L6:
        if (r3.hasNext() == false) goto L27;
        View r2 = r3.next();
        if (r2 == null) goto L6;
        if (r2.getVisibility() == 4) goto L6;
        r2.setVisibility(4);
        goto L6
    L27:
        return;
    L12:
        View r4 = getCurrentBottomView();
        if (r4 != null) goto L15;
        return;
    L15:
        if (r4.getVisibility() == 0) goto L26;
        r4.setVisibility(0);
        return;
    }

    protected void dispatchRevealEvent(int r16, int r17, int r18, int r19) {
        if (this.mRevealListeners.isEmpty() == false) goto L5;
        return;
    L5:
        Iterator<Map.Entry<View, ArrayList<OnRevealListener>>> r9 = this.mRevealListeners.entrySet().iterator();
    L7:
        if (r9.hasNext() == false) goto L53;
        Map.Entry<View, ArrayList<OnRevealListener>> r10 = r9.next();
        View r11 = r10.getKey();
        Rect r12 = getRelativePosition(r11);
        if (isViewShowing(r11, r12, this.mCurrentDragEdge, r16, r17, r18, r19) == false) goto L42;
        int r1 = 0;
        this.mShowEntirely.put(r11, false);
        float r6 = 0.0f;
        if (getShowMode() != ShowMode.LayDown) goto L23;
        int r0 = AnonymousClass4.$SwitchMap$com$obric$oui$swipeaction$OSwipeLayout$DragEdge[this.mCurrentDragEdge.ordinal()];
        if (r0 == 1) goto L21;
        if (r0 == 2) goto L20;
        if (r0 == 3) goto L19;
        if (r0 != 4) goto L35;
        r1 = r12.right - r18;
        float r2 = r1;
        int r3 = r11.getWidth();
    L34:
        r6 = r2 / r3;
    L35:
        Iterator<OnRevealListener> r4 = r10.getValue().iterator();
    L37:
        if (r4.hasNext() == false) goto L42;
        r4.next().onReveal(r11, this.mCurrentDragEdge, Math.abs(r6), r1);
        if (Math.abs(r6) != 1.0f) goto L37;
        this.mShowEntirely.put(r11, true);
        goto L37
    L19:
        r1 = r12.left - r16;
        r2 = r1;
        r3 = r11.getWidth();
        goto L34
    L20:
        r1 = r12.bottom - r19;
        r2 = r1;
        r3 = r11.getHeight();
        goto L34
    L21:
        r1 = r12.top - r17;
        r2 = r1;
        r3 = r11.getHeight();
        goto L34
    L23:
        if (getShowMode() != ShowMode.PullOut) goto L35;
        int r5 = AnonymousClass4.$SwitchMap$com$obric$oui$swipeaction$OSwipeLayout$DragEdge[this.mCurrentDragEdge.ordinal()];
        if (r5 == 1) goto L33;
        if (r5 == 2) goto L32;
        if (r5 == 3) goto L31;
        if (r5 != 4) goto L35;
        r1 = r12.left - getWidth();
        r2 = r1;
        r3 = r11.getWidth();
        goto L34
    L31:
        r1 = r12.right - getPaddingLeft();
        r2 = r1;
        r3 = r11.getWidth();
        goto L34
    L32:
        r1 = r12.top - getHeight();
        r2 = r1;
        r3 = r11.getHeight();
        goto L34
    L33:
        r1 = r12.bottom - getPaddingTop();
        r2 = r1;
        r3 = r11.getHeight();
    L42:
        if (isViewTotallyFirstShowed(r11, r12, this.mCurrentDragEdge, r16, r17, r18, r19) == false) goto L7;
        this.mShowEntirely.put(r11, true);
        Iterator<OnRevealListener> r7 = r10.getValue().iterator();
    L45:
        if (r7.hasNext() == false) goto L7;
        OnRevealListener r8 = r7.next();
        if (this.mCurrentDragEdge == DragEdge.Left) goto L52;
        if (this.mCurrentDragEdge == DragEdge.Right) goto L52;
        r8.onReveal(r11, this.mCurrentDragEdge, 1.0f, r11.getHeight());
    L52:
        r8.onReveal(r11, this.mCurrentDragEdge, 1.0f, r11.getWidth());
        goto L45
    }

    @Override // android.view.View
    public void computeScroll() {
        super.computeScroll();
        if (this.mDragHelper.continueSettling(true) == false) goto L6;
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    }

    public void addOnLayoutListener(OnLayout r2) {
        if (this.mOnLayoutListeners != null) goto L5;
        this.mOnLayoutListeners = new ArrayList();
    L5:
        this.mOnLayoutListeners.add(r2);
    }

    public void removeOnLayoutListener(OnLayout r1) {
        List<OnLayout> r0 = this.mOnLayoutListeners;
        if (r0 == null) goto L6;
        r0.remove(r1);
        return;
    }

    public void clearDragEdge() {
        this.mDragEdges.clear();
    }

    public void setDrag(DragEdge r1, int r2) {
        clearDragEdge();
        addDrag(r1, r2);
    }

    public void setDrag(DragEdge r1, View r2) {
        clearDragEdge();
        addDrag(r1, r2);
    }

    public void addDrag(DragEdge r2, int r3) {
        addDrag(r2, findViewById(r3), null);
    }

    public void addDrag(DragEdge r2, View r3) {
        addDrag(r2, r3, null);
    }

    public void addDrag(DragEdge r2, View r3, ViewGroup.LayoutParams r4) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (r4 != null) goto L7;
        r4 = generateDefaultLayoutParams();
    L7:
        if (checkLayoutParams(r4) == true) goto L9;
        r4 = generateLayoutParams(r4);
    L9:
        int r5 = AnonymousClass4.$SwitchMap$com$obric$oui$swipeaction$OSwipeLayout$DragEdge[r2.ordinal()];
        if (r5 != 1) goto L12;
        int r0 = 48;
    L22:
        if ((r4 instanceof FrameLayout.LayoutParams) == false) goto L24;
        ((FrameLayout.LayoutParams) r4).gravity = r0;
    L24:
        addView(r3, 0, r4);
        return;
    L12:
        if (r5 == 2) goto L19;
        r0 = 3;
        if (r5 == 3) goto L22;
        if (r5 == 4) goto L18;
        r0 = -1;
        goto L22
    L18:
        r0 = 5;
        goto L22
    L19:
        r0 = 80;
        goto L22
    }

    @Override // android.view.ViewGroup
    public void addView(View r4, int r5, ViewGroup.LayoutParams r6) {
        if (r4 != null) goto L32;
        return;
    L32:
        int r0 = ((Integer) r6.getClass().getField("gravity").get(r6)).intValue();     // Catch: Exception -> L6
    L8:
        if (r0 <= 0) goto L21;
        int r1 = GravityCompat.getAbsoluteGravity(r0, ViewCompat.getLayoutDirection(this));
        if ((r1 & 3) != 3) goto L13;
        this.mDragEdges.put(DragEdge.Left, r4);
    L13:
        if ((r1 & 5) != 5) goto L16;
        this.mDragEdges.put(DragEdge.Right, r4);
    L16:
        if ((r1 & 48) != 48) goto L19;
        this.mDragEdges.put(DragEdge.Top, r4);
    L19:
        if ((r1 & 80) != 80) goto L28;
        this.mDragEdges.put(DragEdge.Bottom, r4);
    L28:
        if (r4.getParent() != this) goto L30;
        return;
    L30:
        super.addView(r4, r5, r6);
        return;
    L21:
        Iterator<Map.Entry<DragEdge, View>> r2 = this.mDragEdges.entrySet().iterator();
    L23:
        if (r2.hasNext() == false) goto L28;
        Map.Entry<DragEdge, View> r3 = r2.next();
        if (r3.getValue() != null) goto L23;
        this.mDragEdges.put(r3.getKey(), r4);
    L6:
        e = move-exception;
        e.printStackTrace();
        r0 = 0;
        goto L8
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        updateBottomViews();
        if (this.mOnLayoutListeners == null) goto L8;
        int r6 = 0;
    L6:
        if (r6 >= this.mOnLayoutListeners.size()) goto L10;
        this.mOnLayoutListeners.get(r6).onLayout(this);
        r6 = r6 + 1;
        goto L6
    L10:
        return;
    }

    void layoutPullOut() {
        View r0 = getSurfaceView();
        Rect r1 = this.mViewBoundCache.get(r0);
        if (r1 == null) goto L5;
    L9:
        if (r0 == null) goto L11;
        r0.layout(r1.left, r1.top, r1.right, r1.bottom);
        bringChildToFront(r0);
    L11:
        View r2 = getCurrentBottomView();
        Rect r3 = this.mViewBoundCache.get(r2);
        if (r3 != null) goto L14;
        r3 = computeBottomLayoutAreaViaSurface(ShowMode.PullOut, r1);
    L14:
        if (r2 == null) goto L17;
        r2.layout(r3.left, r3.top, r3.right, r3.bottom);
        return;
    L17:
        return;
    L5:
        if (getOpenStatus() == Status.Close) goto L7;
        boolean r4 = true;
    L8:
        r1 = computeSurfaceLayoutArea(r4);
        goto L9
    L7:
        r4 = false;
        goto L8
    }

    void layoutLayDown() {
        View r0 = getSurfaceView();
        Rect r1 = this.mViewBoundCache.get(r0);
        if (r1 != null) goto L5;
        r1 = computeSurfaceLayoutArea(false);
    L5:
        if (r0 == null) goto L7;
        r0.layout(r1.left, r1.top, r1.right, r1.bottom);
        bringChildToFront(r0);
    L7:
        View r2 = getCurrentBottomView();
        Rect r3 = this.mViewBoundCache.get(r2);
        if (r3 != null) goto L10;
        r3 = computeBottomLayoutAreaViaSurface(ShowMode.LayDown, r1);
    L10:
        if (r2 == null) goto L13;
        r2.layout(r3.left, r3.top, r3.right, r3.bottom);
        return;
    }

    private void checkCanDrag(MotionEvent r10) {
        if (this.mIsBeingDragged == false) goto L8;
        if (this.mIsDownOutSurfaceView == true) goto L8;
        return;
    L8:
        if (getOpenStatus() != Status.Middle) goto L11;
        this.mIsBeingDragged = true;
        return;
    L11:
        Status r0 = getOpenStatus();
        float r1 = r10.getRawX() - this.sX;
        float r11 = r10.getRawY() - this.sY;
        float r3 = (float) Math.toDegrees(Math.atan(Math.abs(r11 / r1)));
        if (getOpenStatus() == Status.Close) goto L14;
    L38:
        boolean r7 = false;
        if (this.mCurrentDragEdge == DragEdge.Right) goto L41;
    L67:
        boolean r4 = false;
    L69:
        if (this.mCurrentDragEdge != DragEdge.Left) goto L91;
        if (r0 != Status.Open) goto L75;
        if (r1 >= (-this.mTouchSlop)) goto L75;
    L78:
        boolean r2 = true;
    L80:
        if (r2 == false) goto L82;
    L85:
        boolean r5 = true;
    L87:
        if (r3 > 30.0f) goto L89;
        if (r5 == true) goto L91;
    L89:
        r4 = true;
        goto L91
    L82:
        if (r0 == Status.Middle) goto L85;
        r5 = false;
    L75:
        if (r0 == Status.Close) goto L77;
    L79:
        r2 = false;
        goto L80
    L77:
        if (r1 <= this.mTouchSlop) goto L79;
    L91:
        if (this.mCurrentDragEdge != DragEdge.Top) goto L113;
        if (r0 != Status.Open) goto L97;
        if (r11 >= (-this.mTouchSlop)) goto L97;
    L100:
        boolean r6 = true;
    L102:
        if (r6 == false) goto L104;
    L107:
        boolean r8 = true;
    L109:
        if (r3 < 60.0f) goto L111;
        if (r8 == true) goto L113;
    L111:
        r4 = true;
        goto L113
    L104:
        if (r0 == Status.Middle) goto L107;
        r8 = false;
    L97:
        if (r0 == Status.Close) goto L99;
    L101:
        r6 = false;
        goto L102
    L99:
        if (r11 <= this.mTouchSlop) goto L101;
    L113:
        if (this.mCurrentDragEdge == DragEdge.Bottom) goto L115;
    L132:
        this.mIsBeingDragged = !r4;
        return;
    L115:
        if (r0 != Status.Open) goto L119;
        if (r11 <= this.mTouchSlop) goto L119;
    L122:
        boolean r12 = true;
    L124:
        if (r12 == false) goto L126;
    L127:
        r7 = true;
    L129:
        if (r3 < 60.0f) goto L131;
        if (r7 == true) goto L132;
    L131:
        r4 = true;
        goto L132
    L126:
        if (r0 != Status.Middle) goto L129;
    L119:
        if (r0 == Status.Close) goto L121;
    L123:
        r12 = false;
        goto L124
    L121:
        if (r11 >= (-this.mTouchSlop)) goto L123;
    L41:
        if (r0 != Status.Open) goto L45;
        if (r1 <= this.mTouchSlop) goto L45;
    L48:
        boolean r9 = true;
    L51:
        if (this.mQuickDeleteEnabled == true) goto L53;
    L57:
        if (r9 == false) goto L59;
    L62:
        boolean r13 = true;
    L64:
        if (r3 > 30.0f) goto L66;
        if (r13 == true) goto L67;
    L66:
        r4 = true;
        goto L69
    L59:
        if (r0 == Status.Middle) goto L62;
        r13 = false;
        goto L64
    L53:
        if (r0 != Status.Open) goto L57;
        if (r1 >= (-this.mTouchSlop)) goto L57;
        r9 = true;
    L45:
        if (r0 == Status.Close) goto L47;
    L49:
        r9 = false;
        goto L51
    L47:
        if (r1 >= (-this.mTouchSlop)) goto L49;
    L14:
        if (r3 >= 45.0f) goto L27;
        if (r1 <= 0.0f) goto L21;
        if (isLeftSwipeEnabled() == false) goto L21;
        DragEdge r14 = DragEdge.Left;
    L36:
        setCurrentDragEdge(r14);
    L21:
        if (r1 < 0.0f) goto L23;
        return;
    L23:
        if (isRightSwipeEnabled() == false) goto L134;
        r14 = DragEdge.Right;
        goto L36
    L134:
        return;
    L27:
        if (r11 <= 0.0f) goto L32;
        if (isTopSwipeEnabled() == false) goto L32;
        r14 = DragEdge.Top;
    L32:
        if (r11 < 0.0f) goto L34;
        return;
    L34:
        if (isBottomSwipeEnabled() == false) goto L135;
        r14 = DragEdge.Bottom;
        goto L36
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r5) {
        if (isSwipeEnabled() == true) goto L6;
        return false;
    L6:
        if (this.mClickToClose == true) goto L8;
    L12:
        Iterator<SwipeDenier> r0 = this.mSwipeDeniers.iterator();
    L14:
        if (r0.hasNext() == false) goto L20;
        SwipeDenier r3 = r0.next();
        if (r3 == null) goto L14;
        if (r3.shouldDenySwipe(r5) == false) goto L14;
        return false;
    L20:
        int r1 = r5.getAction();
        if (r1 == 0) goto L40;
        if (r1 != 1) goto L24;
    L39:
        this.mIsDownOutSurfaceView = false;
        this.mIsBeingDragged = false;
        this.mDragHelper.processTouchEvent(r5);
    L49:
        return this.mIsBeingDragged;
    L24:
        if (r1 != 2) goto L26;
        boolean r2 = this.mIsBeingDragged;
        checkCanDrag(r5);
        if (this.mIsBeingDragged == true) goto L31;
    L35:
        if (r2 == true) goto L49;
        if (this.mIsBeingDragged == false) goto L49;
        return false;
    L31:
        if (this.mIsDownOutSurfaceView == true) goto L35;
        ViewParent r6 = getParent();
        if (r6 == null) goto L35;
        r6.requestDisallowInterceptTouchEvent(true);
        goto L35
    L26:
        if (r1 == 3) goto L39;
        this.mDragHelper.processTouchEvent(r5);
        goto L49
    L40:
        this.mDragHelper.processTouchEvent(r5);
        this.mIsDownOutSurfaceView = false;
        this.mIsBeingDragged = false;
        this.sX = r5.getRawX();
        this.sY = r5.getRawY();
        if (getOpenStatus() != Status.Middle) goto L44;
        this.mIsBeingDragged = true;
    L44:
        if (this.mQuickDeleteEnabled == false) goto L49;
        if (isDownOnSurface(r5) == true) goto L49;
        this.mIsDownOutSurfaceView = true;
        goto L49
    L8:
        if (getOpenStatus() != Status.Open) goto L12;
        if (isTouchOnSurface(r5) == false) goto L12;
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r5) {
        if (isSwipeEnabled() == false) goto L5;
        int r0 = r5.getActionMasked();
        this.gestureDetector.onTouchEvent(r5);
        if (r0 == 0) goto L20;
        if (r0 != 1) goto L10;
    L19:
        this.mIsBeingDragged = false;
        this.mDragHelper.processTouchEvent(r5);
    L22:
        if (super.onTouchEvent(r5) == true) goto L27;
        if (this.mIsBeingDragged == true) goto L27;
        if (r0 == 0) goto L27;
        return false;
    L27:
        return true;
    L10:
        if (r0 != 2) goto L12;
        checkCanDrag(r5);
        if (this.mIsBeingDragged == false) goto L22;
        if (this.mIsDownOutSurfaceView == true) goto L22;
        getParent().requestDisallowInterceptTouchEvent(true);
        this.mDragHelper.processTouchEvent(r5);
        goto L22
    L12:
        if (r0 == 3) goto L19;
        this.mDragHelper.processTouchEvent(r5);
        goto L22
    L20:
        this.mDragHelper.processTouchEvent(r5);
        this.sX = r5.getRawX();
        this.sY = r5.getRawY();
        goto L22
    L5:
        return super.onTouchEvent(r5);
    }

    public boolean isClickToClose() {
        return this.mClickToClose;
    }

    public void setClickToClose(boolean r1) {
        this.mClickToClose = r1;
    }

    public void setSwipeEnabled(boolean r1) {
        this.mSwipeEnabled = r1;
    }

    public boolean isSwipeEnabled() {
        return this.mSwipeEnabled;
    }

    public boolean isLeftSwipeEnabled() {
        View r0 = this.mDragEdges.get(DragEdge.Left);
        if (r0 != null) goto L5;
    L11:
        return false;
    L5:
        if (r0.getParent() != this) goto L11;
        if (r0 == getSurfaceView()) goto L11;
        if (this.mSwipesEnabled[DragEdge.Left.ordinal()] == false) goto L11;
        return true;
    }

    public void setLeftSwipeEnabled(boolean r2) {
        this.mSwipesEnabled[DragEdge.Left.ordinal()] = r2;
    }

    public boolean isRightSwipeEnabled() {
        View r0 = this.mDragEdges.get(DragEdge.Right);
        if (r0 != null) goto L5;
    L11:
        return false;
    L5:
        if (r0.getParent() != this) goto L11;
        if (r0 == getSurfaceView()) goto L11;
        if (this.mSwipesEnabled[DragEdge.Right.ordinal()] == false) goto L11;
        return true;
    }

    public void setRightSwipeEnabled(boolean r2) {
        this.mSwipesEnabled[DragEdge.Right.ordinal()] = r2;
    }

    public boolean isTopSwipeEnabled() {
        View r0 = this.mDragEdges.get(DragEdge.Top);
        if (r0 != null) goto L5;
    L11:
        return false;
    L5:
        if (r0.getParent() != this) goto L11;
        if (r0 == getSurfaceView()) goto L11;
        if (this.mSwipesEnabled[DragEdge.Top.ordinal()] == false) goto L11;
        return true;
    }

    public void setTopSwipeEnabled(boolean r2) {
        this.mSwipesEnabled[DragEdge.Top.ordinal()] = r2;
    }

    public boolean isBottomSwipeEnabled() {
        View r0 = this.mDragEdges.get(DragEdge.Bottom);
        if (r0 != null) goto L5;
    L11:
        return false;
    L5:
        if (r0.getParent() != this) goto L11;
        if (r0 == getSurfaceView()) goto L11;
        if (this.mSwipesEnabled[DragEdge.Bottom.ordinal()] == false) goto L11;
        return true;
    }

    public void setBottomSwipeEnabled(boolean r2) {
        this.mSwipesEnabled[DragEdge.Bottom.ordinal()] = r2;
    }

    public float getWillOpenPercentAfterOpen() {
        return this.mWillOpenPercentAfterOpen;
    }

    public void setWillOpenPercentAfterOpen(float r1) {
        this.mWillOpenPercentAfterOpen = r1;
    }

    public float getWillOpenPercentAfterClose() {
        return this.mWillOpenPercentAfterClose;
    }

    public void setWillOpenPercentAfterClose(float r1) {
        this.mWillOpenPercentAfterClose = r1;
    }

    private boolean insideAdapterView() {
        if (getAdapterView() == null) goto L5;
        return true;
    L5:
        return false;
    }

    private AdapterView getAdapterView() {
        ViewParent r0 = getParent();
        if (findAncestorNode() == false) goto L9;
    L4:
        if (r0 == null) goto L9;
        if ((r0 instanceof AdapterView) == true) goto L9;
        r0 = r0.getParent();
    L9:
        if ((r0 instanceof AdapterView) == true) goto L11;
        return null;
    L11:
        return (AdapterView) r0;
    }

    private void performAdapterViewItemClick() {
        if (getOpenStatus() == Status.Close) goto L5;
        return;
    L5:
        AdapterView r0 = getAdapterView();
        if (r0 == null) goto L15;
        int r1 = r0.getPositionForView(this);
        if (r1 == (-1)) goto L10;
    L12:
        if (r1 == (-1)) goto L16;
        r0.performItemClick(r0.getChildAt(r1 - r0.getFirstVisiblePosition()), r1, r0.getAdapter().getItemId(r1));
        return;
    L16:
        return;
    L10:
        if (findAncestorNode() == false) goto L12;
        r1 = getPositionForViewInDescendant(r0, this);
        goto L12
    }

    private int getPositionForViewInDescendant(ViewGroup r5, View r6) {
        int r0 = r5.getChildCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L13;
        View r2 = r5.getChildAt(r1);
        if (r2 == r6) goto L6;
        if ((r2 instanceof ViewGroup) == false) goto L12;
        if (containsView((ViewGroup) r2, r6) == false) goto L12;
        return r1;
    L12:
        r1 = r1 + 1;
        goto L3
    L6:
        return r1;
    L13:
        return -1;
    }

    private boolean containsView(ViewGroup r7, View r8) {
        int r0 = r7.getChildCount();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L13;
        View r3 = r7.getChildAt(r2);
        if (r3 == r8) goto L6;
        if ((r3 instanceof ViewGroup) == false) goto L12;
        if (containsView((ViewGroup) r3, r8) == false) goto L12;
        return true;
    L12:
        r2 = r2 + 1;
        goto L3
    L6:
        return true;
    L13:
        return false;
    }

    private boolean performAdapterViewItemLongClick() {
        if (getOpenStatus() == Status.Close) goto L5;
        return false;
    L5:
        AdapterView<?> r0 = getAdapterView();
        if (r0 == null) goto L26;
        int r1 = r0.getPositionForView(this);
        if (r1 == (-1)) goto L10;
    L12:
        int r6 = r1;
        if (r6 != (-1)) goto L15;
        return false;
    L15:
        long r7 = r0.getItemIdAtPosition(r6);
        Method r2 = AbsListView.class.getDeclaredMethod("performLongPress", new Class[]{View.class, Integer.TYPE, Long.TYPE});     // Catch: Exception -> L18
        r2.setAccessible(true);     // Catch: Exception -> L18
        return ((Boolean) r2.invoke(r0, new Object[]{this, Integer.valueOf(r6), Long.valueOf(r7)})).booleanValue();
    L18:
        e = move-exception;
        e.printStackTrace();
        if (r0.getOnItemLongClickListener() == null) goto L22;
        boolean r12 = r0.getOnItemLongClickListener().onItemLongClick(r0, this, r6, r7);
    L23:
        if (r12 == false) goto L29;
        r0.performHapticFeedback(0);
        return r12;
    L29:
        return r12;
    L22:
        r12 = false;
        goto L23
    L10:
        if (findAncestorNode() == false) goto L12;
        r1 = getPositionForViewInDescendant(r0, this);
        goto L12
    L26:
        return false;
    }

    public boolean findAncestorNode() {
        return this.findAncestorNodeMode;
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (insideAdapterView() == true) goto L5;
        return;
    L5:
        if (this.clickListener != null) goto L8;
        setOnClickListener(new AnonymousClass2(this));
    L8:
        if (this.longClickListener != null) goto L12;
        setOnLongClickListener(new AnonymousClass3(this));
        return;
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ViewDragHelper r0 = this.mDragHelper;
        if (r0 == null) goto L6;
        r0.abort();
    L6:
        if (getOpenStatus() == Status.Close) goto L9;
        close(false);
        return;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener r1) {
        super.setOnClickListener(r1);
        this.clickListener = r1;
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener r1) {
        super.setOnLongClickListener(r1);
        this.longClickListener = r1;
    }

    private boolean isTouchOnSurface(MotionEvent r3) {
        View r0 = getSurfaceView();
        if (r0 != null) goto L7;
        return false;
    L7:
        if (this.hitSurfaceRect != null) goto L9;
        this.hitSurfaceRect = new Rect();
    L9:
        r0.getHitRect(this.hitSurfaceRect);
        return this.hitSurfaceRect.contains((int) r3.getX(), (int) r3.getY());
    }

    private boolean isDownOnSurface(MotionEvent r4) {
        View r3 = getSurfaceView();
        if (r3 != null) goto L5;
        return false;
    L5:
        int r1 = (int) r4.getX();
        int r5 = (int) r4.getY();
        if (r1 >= r3.getLeft()) goto L8;
        return false;
    L8:
        if (r1 <= r3.getRight()) goto L10;
        return false;
    L10:
        if (r5 >= r3.getTop()) goto L12;
        return false;
    L12:
        if (r5 > r3.getBottom()) goto L18;
        return true;
    L18:
        return false;
    }

    public void setDragDistance(int r1) {
        if (r1 >= 0) goto L4;
        r1 = 0;
    L4:
        this.mDragDistance = dp2px(r1);
        requestLayout();
    }

    public void setShowMode(ShowMode r1) {
        this.mShowMode = r1;
        requestLayout();
    }

    public DragEdge getDragEdge() {
        return this.mCurrentDragEdge;
    }

    public int getDragDistance() {
        return this.mDragDistance;
    }

    public ShowMode getShowMode() {
        return this.mShowMode;
    }

    public View getSurfaceView() {
        if (getChildCount() != 0) goto L7;
        return null;
    L7:
        return getChildAt(getChildCount() - 1);
    }

    public View getCurrentBottomView() {
        List<View> r0 = getBottomViews();
        if (this.mCurrentDragEdge.ordinal() < r0.size()) goto L5;
        return null;
    L5:
        return r0.get(this.mCurrentDragEdge.ordinal());
    }

    public List<View> getBottomViews() {
        ArrayList r0 = new ArrayList();
        DragEdge[] r1 = DragEdge.values();
        int r2 = r1.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L5;
        DragEdge r4 = r1[r3];
        r0.add(this.mDragEdges.get(r4));
        r3 = r3 + 1;
        goto L3
    L5:
        return r0;
    }

    public Status getOpenStatus() {
        View r0 = getSurfaceView();
        if (r0 == null) goto L5;
        int r1 = r0.getLeft();
        int r2 = r0.getTop();
        if (r1 != getPaddingLeft()) goto L13;
        if (r2 != getPaddingTop()) goto L13;
        return Status.Close;
    L13:
        if (r1 == (getPaddingLeft() - this.mDragDistance)) goto L24;
        if (r1 == (getPaddingLeft() + this.mDragDistance)) goto L24;
        if (r2 == (getPaddingTop() - this.mDragDistance)) goto L24;
        if (r2 == (getPaddingTop() + this.mDragDistance)) goto L24;
        return Status.Middle;
    L24:
        return Status.Open;
    L5:
        return Status.Close;
    }

    public boolean getIsBeingDragged() {
        return this.mIsBeingDragged;
    }

    protected void processHandRelease(float r5, float r6, boolean r7) {
        float r0 = this.mDragHelper.getMinVelocity();
        View r1 = getSurfaceView();
        DragEdge r2 = this.mCurrentDragEdge;
        if (r2 == null) goto L63;
        if (r1 != null) goto L7;
        return;
    L7:
        if (this.mQuickDeleteEnabled == true) goto L9;
    L11:
        if (r7 == false) goto L13;
        float r8 = this.mWillOpenPercentAfterClose;
    L15:
        if (r2 != DragEdge.Left) goto L27;
        if (r5 <= r0) goto L20;
        open();
        return;
    L20:
        if (r5 >= (-r0)) goto L23;
        close();
        return;
    L23:
        if (((getSurfaceView().getLeft() * 1.0f) / this.mDragDistance) <= r8) goto L25;
        open();
        return;
    L25:
        close();
        return;
    L27:
        if (r2 != DragEdge.Right) goto L39;
        if (r5 <= r0) goto L32;
        close();
        return;
    L32:
        if (r5 >= (-r0)) goto L35;
        open();
        return;
    L35:
        if ((((-getSurfaceView().getLeft()) * 1.0f) / this.mDragDistance) <= r8) goto L37;
        open();
        return;
    L37:
        close();
        return;
    L39:
        if (r2 != DragEdge.Top) goto L51;
        if (r6 <= r0) goto L44;
        open();
        return;
    L44:
        if (r6 >= (-r0)) goto L47;
        close();
        return;
    L47:
        if (((getSurfaceView().getTop() * 1.0f) / this.mDragDistance) <= r8) goto L49;
        open();
        return;
    L49:
        close();
        return;
    L51:
        if (r2 == DragEdge.Bottom) goto L53;
        return;
    L53:
        if (r6 <= r0) goto L56;
        close();
        return;
    L56:
        if (r6 >= (-r0)) goto L59;
        open();
        return;
    L59:
        if ((((-getSurfaceView().getTop()) * 1.0f) / this.mDragDistance) <= r8) goto L61;
        open();
        return;
    L61:
        close();
        return;
    L13:
        r8 = this.mWillOpenPercentAfterOpen;
        goto L15
    L9:
        if (this.mIsQuickDeleteTriggered == false) goto L11;
        return;
    }

    public void open() {
        open(true, true);
    }

    public void open(boolean r2) {
        open(r2, true);
    }

    public void open(boolean r9, boolean r10) {
        View r0 = getSurfaceView();
        View r1 = getCurrentBottomView();
        if (r0 != null) goto L5;
        return;
    L5:
        ViewDragHelper r2 = this.mDragHelper;
        if (r2 == null) goto L8;
        r2.abort();
    L8:
        Rect r3 = computeSurfaceLayoutArea(true);
        if (r9 == false) goto L11;
        this.mDragHelper.smoothSlideViewTo(r0, r3.left, r3.top);
    L30:
        invalidate();
        return;
    L11:
        int r11 = r3.left - r0.getLeft();
        int r4 = r3.top - r0.getTop();
        r0.layout(r3.left, r3.top, r3.right, r3.bottom);
        Rect r5 = this.mViewBoundCache.get(r0);
        if (r5 != null) goto L14;
        r5 = new Rect();
        this.mViewBoundCache.put(r0, r5);
    L14:
        r5.set(r3);
        if (getShowMode() != ShowMode.PullOut) goto L20;
        Rect r6 = computeBottomLayoutAreaViaSurface(ShowMode.PullOut, r3);
        if (r1 == null) goto L27;
        r1.layout(r6.left, r6.top, r6.right, r6.bottom);
    L27:
        if (r10 == false) goto L29;
        dispatchRevealEvent(r3.left, r3.top, r3.right, r3.bottom);
        dispatchSwipeEvent(r3.left, r3.top, r11, r4);
        goto L30
    L29:
        safeBottomView();
        goto L30
    L20:
        if (getShowMode() != ShowMode.LayDown) goto L27;
        Rect r7 = computeBottomLayoutAreaViaSurface(ShowMode.LayDown, r3);
        if (r1 == null) goto L27;
        Rect r8 = this.mViewBoundCache.get(r1);
        if (r8 != null) goto L26;
        r8 = new Rect();
        this.mViewBoundCache.put(r1, r8);
    L26:
        r8.set(r7);
        r1.layout(r7.left, r7.top, r7.right, r7.bottom);
        goto L27
    }

    public void open(DragEdge r1) {
        setCurrentDragEdge(r1);
        open(true, true);
    }

    public void open(boolean r1, DragEdge r2) {
        setCurrentDragEdge(r2);
        open(r1, true);
    }

    public void open(boolean r1, boolean r2, DragEdge r3) {
        setCurrentDragEdge(r3);
        open(r1, r2);
    }

    public void close() {
        close(true, true);
    }

    public void close(boolean r2) {
        close(r2, true);
    }

    public void close(boolean r8, boolean r9) {
        View r0 = getSurfaceView();
        if (r0 != null) goto L5;
        return;
    L5:
        ViewDragHelper r1 = this.mDragHelper;
        if (r1 == null) goto L8;
        r1.abort();
    L8:
        if (r8 == false) goto L10;
        this.mDragHelper.smoothSlideViewTo(getSurfaceView(), getPaddingLeft(), getPaddingTop());
    L17:
        invalidate();
        return;
    L10:
        Rect r10 = computeSurfaceLayoutArea(false);
        this.mViewBoundCache.remove(r0);
        if (this.mViewBoundCache.get(getCurrentBottomView()) == null) goto L13;
        this.mViewBoundCache.remove(getCurrentBottomView());
    L13:
        int r2 = r10.left - r0.getLeft();
        int r3 = r10.top - r0.getTop();
        r0.layout(r10.left, r10.top, r10.right, r10.bottom);
        if (r9 == false) goto L16;
        dispatchRevealEvent(r10.left, r10.top, r10.right, r10.bottom);
        dispatchSwipeEvent(r10.left, r10.top, r2, r3);
        goto L17
    L16:
        safeBottomView();
        goto L17
    }

    public void toggle() {
        toggle(true);
    }

    public void toggle(boolean r3) {
        if (getOpenStatus() != Status.Open) goto L6;
        close(r3);
        return;
    L6:
        if (getOpenStatus() != Status.Close) goto L10;
        open(r3);
        return;
    }

    private Rect computeSurfaceLayoutArea(boolean r4) {
        int r0 = getPaddingLeft();
        int r1 = getPaddingTop();
        if (r4 == false) goto L15;
        if (this.mCurrentDragEdge != DragEdge.Left) goto L8;
        int r5 = getPaddingLeft();
        r0 = this.mDragDistance + r5;
        goto L15
    L8:
        if (this.mCurrentDragEdge != DragEdge.Right) goto L11;
        r0 = getPaddingLeft() - this.mDragDistance;
        goto L15
    L11:
        if (this.mCurrentDragEdge != DragEdge.Top) goto L13;
        int r6 = getPaddingTop();
        r1 = this.mDragDistance + r6;
        goto L15
    L13:
        r1 = getPaddingTop() - this.mDragDistance;
    L15:
        return new Rect(r0, r1, getMeasuredWidth() + r0, getMeasuredHeight() + r1);
    }

    private Rect computeBottomLayoutAreaViaSurface(ShowMode r7, Rect r8) {
        View r0 = getCurrentBottomView();
        int r1 = r8.left;
        int r2 = r8.top;
        int r3 = r8.right;
        int r4 = r8.bottom;
        if (r7 != ShowMode.PullOut) goto L29;
        if (this.mCurrentDragEdge != DragEdge.Left) goto L8;
        r1 = r8.left - this.mDragDistance;
    L14:
        int r5 = 0;
        if (this.mCurrentDragEdge != DragEdge.Left) goto L17;
    L23:
        int r6 = r8.bottom;
        if (r0 == null) goto L27;
        r5 = r0.getMeasuredWidth();
    L27:
        r3 = r1 + r5;
        r4 = r6;
    L41:
        return new Rect(r1, r2, r3, r4);
    L17:
        if (this.mCurrentDragEdge == DragEdge.Right) goto L23;
        if (r0 == null) goto L22;
        r5 = r0.getMeasuredHeight();
    L22:
        r4 = r5 + r2;
        r3 = r8.right;
        goto L41
    L8:
        if (this.mCurrentDragEdge != DragEdge.Right) goto L11;
        r1 = r8.right;
        goto L14
    L11:
        if (this.mCurrentDragEdge != DragEdge.Top) goto L13;
        r2 = r8.top - this.mDragDistance;
        goto L14
    L13:
        r2 = r8.bottom;
        goto L14
    L29:
        if (r7 != ShowMode.LayDown) goto L41;
        if (this.mCurrentDragEdge != DragEdge.Left) goto L34;
        r3 = r1 + this.mDragDistance;
        goto L41
    L34:
        if (this.mCurrentDragEdge != DragEdge.Right) goto L37;
        r1 = r3 - this.mDragDistance;
        goto L41
    L37:
        if (this.mCurrentDragEdge != DragEdge.Top) goto L39;
        r4 = r2 + this.mDragDistance;
        goto L41
    L39:
        r2 = r4 - this.mDragDistance;
        goto L41
    }

    private Rect computeBottomLayDown(DragEdge r4) {
        int r0 = getPaddingLeft();
        int r1 = getPaddingTop();
        if (r4 != DragEdge.Right) goto L6;
        r0 = getMeasuredWidth() - this.mDragDistance;
    L9:
        if (r4 != DragEdge.Left) goto L11;
    L14:
        int r5 = this.mDragDistance + r0;
        int r3 = getMeasuredHeight();
    L16:
        return new Rect(r0, r1, r5, r3 + r1);
    L11:
        if (r4 == DragEdge.Right) goto L14;
        r5 = getMeasuredWidth() + r0;
        r3 = this.mDragDistance;
        goto L16
    L6:
        if (r4 != DragEdge.Bottom) goto L9;
        r1 = getMeasuredHeight() - this.mDragDistance;
        goto L9
    }

    public void setOnDoubleClickListener(DoubleClickListener r1) {
        this.mDoubleClickListener = r1;
    }

    private int dp2px(float r1) {
        return (int) ((r1 * getContext().getResources().getDisplayMetrics().density) + 0.5f);
    }

    @Deprecated
    public void setDragEdge(DragEdge r4) {
        clearDragEdge();
        if (getChildCount() < 2) goto L5;
        this.mDragEdges.put(r4, getChildAt(getChildCount() - 2));
    L5:
        setCurrentDragEdge(r4);
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View r4) {
        Iterator r0 = new HashMap(this.mDragEdges).entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Map.Entry r1 = (Map.Entry) r0.next();
        if (r1.getValue() != r4) goto L4;
        this.mDragEdges.remove(r1.getKey());
        goto L4
    }

    public Map<DragEdge, View> getDragEdgeMap() {
        return this.mDragEdges;
    }

    @Deprecated
    public List<DragEdge> getDragEdges() {
        return new ArrayList(this.mDragEdges.keySet());
    }

    @Deprecated
    public void setDragEdges(List<DragEdge> r7) {
        clearDragEdge();
        int r0 = Math.min(r7.size(), getChildCount() - 1);
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L6;
        this.mDragEdges.put(r7.get(r2), getChildAt(r2));
        r2 = r2 + 1;
        goto L3
    L6:
        if (r7.size() != 0) goto L8;
    L11:
        setCurrentDragEdge(DefaultDragEdge);
        return;
    L8:
        if (r7.contains(DefaultDragEdge) == true) goto L11;
        setCurrentDragEdge(r7.get(0));
    }

    @Deprecated
    public void setDragEdges(DragEdge... r1) {
        clearDragEdge();
        setDragEdges(Arrays.asList(r1));
    }

    @Deprecated
    public void setBottomViewIds(int r2, int r3, int r4, int r5) {
        addDrag(DragEdge.Left, findViewById(r2));
        addDrag(DragEdge.Right, findViewById(r3));
        addDrag(DragEdge.Top, findViewById(r4));
        addDrag(DragEdge.Bottom, findViewById(r5));
    }

    private float getCurrentOffset() {
        DragEdge r0 = this.mCurrentDragEdge;
        if (r0 != null) goto L7;
        return 0.0f;
    L7:
        return this.mEdgeSwipesOffset[r0.ordinal()];
    }

    private void setCurrentDragEdge(DragEdge r1) {
        this.mCurrentDragEdge = r1;
        updateBottomViews();
    }

    private void updateBottomViews() {
        View r0 = getCurrentBottomView();
        if (r0 == null) goto L12;
        if (this.mCurrentDragEdge != DragEdge.Left) goto L7;
    L10:
        this.mDragDistance = r0.getMeasuredWidth() - dp2px(getCurrentOffset());
        goto L12
    L7:
        if (this.mCurrentDragEdge == DragEdge.Right) goto L10;
        this.mDragDistance = r0.getMeasuredHeight() - dp2px(getCurrentOffset());
    L12:
        if (this.mShowMode != ShowMode.PullOut) goto L15;
        layoutPullOut();
    L17:
        safeBottomView();
        return;
    L15:
        if (this.mShowMode != ShowMode.LayDown) goto L17;
        layoutLayDown();
        goto L17
    }
}
