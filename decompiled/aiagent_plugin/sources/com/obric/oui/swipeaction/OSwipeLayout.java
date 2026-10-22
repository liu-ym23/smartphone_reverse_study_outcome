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
import androidx.core.view.ViewCompat;
import com.obric.aiagent.plugin.R;
import com.obric.oui.layout.OUIFrameLayout;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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
    private static final b DefaultDragEdge = null;

    @Deprecated
    public static final int EMPTY_LAYOUT = -1;
    View.OnClickListener clickListener;
    public boolean findAncestorNodeMode;
    private GestureDetector gestureDetector;
    private Rect hitBottomRect;
    private Rect hitSurfaceRect;
    View.OnLongClickListener longClickListener;
    private boolean mClickToClose;
    private b mCurrentDragEdge;
    private a mDoubleClickListener;
    private int mDragDistance;
    private LinkedHashMap<b, View> mDragEdges;
    private androidx.customview.widget.c mDragHelper;
    private androidx.customview.widget.c.a mDragHelperCallback;
    private float[] mEdgeSwipesOffset;
    private int mEventCounter;
    private boolean mIsBeingDragged;
    private boolean mIsDownOutSurfaceView;
    private boolean mIsQuickDeleteTriggered;
    private float mLinearLeft;
    private List<c> mOnLayoutListeners;
    protected int mOverrideDragDistance;
    private boolean mQuickDeleteEnabled;
    private e mQuickDeleteListener;
    protected float mQuickDeleteMax;
    protected float mQuickDeleteThreshold;
    private Map<View, ArrayList<d>> mRevealListeners;
    private Map<View, Boolean> mShowEntirely;
    private f mShowMode;
    private List<h> mSwipeDeniers;
    private boolean mSwipeEnabled;
    private List<i> mSwipeListeners;
    private boolean[] mSwipesEnabled;
    private int mTouchSlop;
    private Map<View, Rect> mViewBoundCache;
    private float mWillOpenPercentAfterClose;
    private float mWillOpenPercentAfterOpen;
    private float sX;
    private float sY;

    /* JADX INFO: renamed from: com.obric.oui.swipeaction.OSwipeLayout$4, reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f36263a = null;

        static {
            int[] r0 = new int[b.values().length];
            f36263a = r0;
            r0[b.f36265b.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            f36263a[b.f36267d.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            f36263a[b.f36264a.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            f36263a[b.f36266c.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
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
            a r7 = OSwipeLayout.access$1500(this.this$0);
            OSwipeLayout r5 = this.this$0;
            if (r0 != r2) goto L19;
            boolean r1 = true;
        L20:
            r7.a(r5, r1);
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

    public interface a {
        void a(OSwipeLayout r1, boolean r2);
    }

    public static final enum b extends Enum<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f36264a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f36265b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final b f36266c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final b f36267d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final /* synthetic */ b[] f36268e = null;

        private b(String r1, int r2) {
            super(r1, r2);
        }

        public static b valueOf(String r2) {
            return (b) ZeusTransformUtils.preCheckCast(Enum.valueOf(b.class, r2), b.class, "com.obric.aiagent.plugin");
        }

        public static b[] values() {
            return (b[]) ZeusTransformUtils.preCheckCast(f36268e.clone(), b[].class, "com.obric.aiagent.plugin");
        }

        static {
            b r0 = new b("Left", 0);
            f36264a = r0;
            b r1 = new b("Top", 1);
            f36265b = r1;
            b r3 = new b("Right", 2);
            f36266c = r3;
            b r5 = new b("Bottom", 3);
            f36267d = r5;
            f36268e = new b[]{r0, r1, r3, r5};
        }
    }

    public interface c {
        void a(OSwipeLayout r1);
    }

    public interface d {
        void a(View r1, b r2, float r3, int r4);
    }

    public interface e {
        void a();

        void a(boolean r1);
    }

    public static final enum f extends Enum<f> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f36269a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final f f36270b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final /* synthetic */ f[] f36271c = null;

        private f(String r1, int r2) {
            super(r1, r2);
        }

        public static f valueOf(String r2) {
            return (f) ZeusTransformUtils.preCheckCast(Enum.valueOf(f.class, r2), f.class, "com.obric.aiagent.plugin");
        }

        public static f[] values() {
            return (f[]) ZeusTransformUtils.preCheckCast(f36271c.clone(), f[].class, "com.obric.aiagent.plugin");
        }

        static {
            f r0 = new f("LayDown", 0);
            f36269a = r0;
            f r1 = new f("PullOut", 1);
            f36270b = r1;
            f36271c = new f[]{r0, r1};
        }
    }

    public static final enum g extends Enum<g> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final g f36272a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g f36273b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final g f36274c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final /* synthetic */ g[] f36275d = null;

        private g(String r1, int r2) {
            super(r1, r2);
        }

        public static g valueOf(String r2) {
            return (g) ZeusTransformUtils.preCheckCast(Enum.valueOf(g.class, r2), g.class, "com.obric.aiagent.plugin");
        }

        public static g[] values() {
            return (g[]) ZeusTransformUtils.preCheckCast(f36275d.clone(), g[].class, "com.obric.aiagent.plugin");
        }

        static {
            g r0 = new g("Middle", 0);
            f36272a = r0;
            g r1 = new g("Open", 1);
            f36273b = r1;
            g r3 = new g("Close", 2);
            f36274c = r3;
            f36275d = new g[]{r0, r1, r3};
        }
    }

    public interface h {
        boolean a(MotionEvent r1);
    }

    public interface i {
        void a(OSwipeLayout r1);

        void a(OSwipeLayout r1, float r2, float r3);

        void a(OSwipeLayout r1, int r2, int r3);

        void b(OSwipeLayout r1);

        void c(OSwipeLayout r1);

        void d(OSwipeLayout r1);
    }

    static /* synthetic */ b access$000(OSwipeLayout r0) {
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

    static /* synthetic */ a access$1500(OSwipeLayout r0) {
        return r0.mDoubleClickListener;
    }

    static /* synthetic */ boolean access$200(OSwipeLayout r0) {
        return r0.mQuickDeleteEnabled;
    }

    static /* synthetic */ androidx.customview.widget.c access$300(OSwipeLayout r0) {
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

    static /* synthetic */ f access$500(OSwipeLayout r0) {
        return r0.mShowMode;
    }

    static /* synthetic */ e access$600(OSwipeLayout r0) {
        return r0.mQuickDeleteListener;
    }

    static /* synthetic */ boolean access$702(OSwipeLayout r0, boolean r1) {
        r0.mIsQuickDeleteTriggered = r1;
        return r1;
    }

    static /* synthetic */ List access$800(OSwipeLayout r0) {
        return r0.mSwipeListeners;
    }

    static /* synthetic */ Rect access$900(OSwipeLayout r0, b r1) {
        return r0.computeBottomLayDown(r1);
    }

    static {
        DefaultDragEdge = b.f36266c;
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

    public void setQuickDeleteListener(e r3) {
        this.mQuickDeleteListener = (e) ZeusTransformUtils.wrapperContextForParams(r3, e.class, "com.obric.aiagent.plugin");
    }

    public void removeQuickDeleteListeners() {
        Iterator<i> r0 = this.mSwipeListeners.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        i r1 = (i) ZeusTransformUtils.preCheckCast(r0.next(), i.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r1, com.obric.oui.swipeaction.a.class) == false) goto L4;
        this.mSwipeListeners.remove(r1);
        goto L4
    L8:
        this.mQuickDeleteListener = null;
    }

    public void setOverrideDragDistance(int r1) {
        this.mOverrideDragDistance = r1;
    }

    public OSwipeLayout(Context r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), null);
    }

    public OSwipeLayout(Context r3, AttributeSet r4) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin"), 0);
    }

    public OSwipeLayout(Context r9, AttributeSet r10, int r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r13 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin");
        super(r12, r13, r11);
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
        this.gestureDetector = new GestureDetector((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), new SwipeDetector(this));
        this.mDragHelper = androidx.customview.widget.c.a(this, this.mDragHelperCallback);
        this.mTouchSlop = ViewConfiguration.get(r12).getScaledTouchSlop();
        TypedArray r14 = r12.obtainStyledAttributes(r13, R.styleable.OSwipeLayout);
        int r15 = r14.getInt(ZeusTransformUtils.mapRes(R.styleable.OSwipeLayout_oui_drag_edge, "styleable", "OSwipeLayout_oui_drag_edge"), 2);
        this.mEdgeSwipesOffset[b.f36264a.ordinal()] = r14.getDimension(ZeusTransformUtils.mapRes(R.styleable.OSwipeLayout_oui_leftEdgeSwipeOffset, "styleable", "OSwipeLayout_oui_leftEdgeSwipeOffset"), 0.0f);
        this.mEdgeSwipesOffset[b.f36266c.ordinal()] = r14.getDimension(ZeusTransformUtils.mapRes(R.styleable.OSwipeLayout_oui_rightEdgeSwipeOffset, "styleable", "OSwipeLayout_oui_rightEdgeSwipeOffset"), 0.0f);
        this.mEdgeSwipesOffset[b.f36265b.ordinal()] = r14.getDimension(ZeusTransformUtils.mapRes(R.styleable.OSwipeLayout_oui_topEdgeSwipeOffset, "styleable", "OSwipeLayout_oui_topEdgeSwipeOffset"), 0.0f);
        this.mEdgeSwipesOffset[b.f36267d.ordinal()] = r14.getDimension(ZeusTransformUtils.mapRes(R.styleable.OSwipeLayout_oui_bottomEdgeSwipeOffset, "styleable", "OSwipeLayout_oui_bottomEdgeSwipeOffset"), 0.0f);
        setClickToClose(r14.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OSwipeLayout_oui_clickToClose, "styleable", "OSwipeLayout_oui_clickToClose"), this.mClickToClose));
        if ((r15 & 1) != 1) goto L6;
        this.mDragEdges.put(b.f36264a, null);
    L6:
        if ((r15 & 4) != 4) goto L9;
        this.mDragEdges.put(b.f36265b, null);
    L9:
        if ((r15 & 2) != 2) goto L12;
        this.mDragEdges.put(b.f36266c, null);
    L12:
        if ((r15 & 8) != 8) goto L14;
        this.mDragEdges.put(b.f36267d, null);
    L14:
        int r16 = r14.getInt(ZeusTransformUtils.mapRes(R.styleable.OSwipeLayout_oui_show_mode, "styleable", "OSwipeLayout_oui_show_mode"), f.f36270b.ordinal());
        this.mShowMode = f.values()[r16];
        r14.recycle();
    }

    public void addSwipeListener(i r3) {
        i r4 = (i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.aiagent.plugin");
        this.mSwipeListeners.add(r4);
    }

    public void removeSwipeListener(i r3) {
        i r4 = (i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.aiagent.plugin");
        this.mSwipeListeners.remove(r4);
    }

    public void removeAllSwipeListener() {
        this.mSwipeListeners.clear();
    }

    public void addSwipeDenier(h r3) {
        h r4 = (h) ZeusTransformUtils.wrapperContextForParams(r3, h.class, "com.obric.aiagent.plugin");
        this.mSwipeDeniers.add(r4);
    }

    public void removeSwipeDenier(h r3) {
        h r4 = (h) ZeusTransformUtils.wrapperContextForParams(r3, h.class, "com.obric.aiagent.plugin");
        this.mSwipeDeniers.remove(r4);
    }

    public void removeAllSwipeDeniers() {
        this.mSwipeDeniers.clear();
    }

    public void addRevealListener(int r4, d r5) {
        d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
        View r7 = findViewById(r4);
        if (r7 == null) goto L13;
        if (this.mShowEntirely.containsKey(r7) == true) goto L8;
        this.mShowEntirely.put(r7, false);
    L8:
        if (this.mRevealListeners.get(r7) != null) goto L10;
        this.mRevealListeners.put(r7, new ArrayList());
    L10:
        ((ArrayList) ZeusTransformUtils.preCheckCast(this.mRevealListeners.get(r7), ArrayList.class, "com.obric.aiagent.plugin")).add(r6);
        return;
    L13:
        throw new IllegalArgumentException("Child does not belong to SwipeListener.");
    }

    public void addRevealListener(int[] r4, d r5) {
        d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
        int r0 = r4.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        addRevealListener(r4[r1], r6);
        r1 = r1 + 1;
        goto L3
    }

    public void removeRevealListener(int r3, d r4) {
        d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
        View r6 = findViewById(r3);
        if (r6 != null) goto L5;
        return;
    L5:
        this.mShowEntirely.remove(r6);
        if (this.mRevealListeners.containsKey(r6) == false) goto L9;
        ((ArrayList) ZeusTransformUtils.preCheckCast(this.mRevealListeners.get(r6), ArrayList.class, "com.obric.aiagent.plugin")).remove(r5);
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
        if (getOpenStatus() != g.f36274c) goto L6;
        this.mViewBoundCache.remove(r0);
        this.mViewBoundCache.remove(r1);
        return;
    L6:
        int r4 = 0;
        View[] r3 = {r1, r0};
    L7:
        if (r4 >= 2) goto L12;
        View r2 = r3[r4];
        Rect r5 = (Rect) ZeusTransformUtils.preCheckCast(this.mViewBoundCache.get(r2), Rect.class, "com.obric.aiagent.plugin");
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

    public boolean isViewTotallyFirstShowed(View r7, Rect r8, b r9, int r10, int r11, int r12, int r13) {
        if (((Boolean) ZeusTransformUtils.preCheckCast(this.mShowEntirely.get(r7), Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == false) goto L5;
        return false;
    L5:
        int r14 = r8.left;
        int r1 = r8.right;
        int r2 = r8.top;
        int r15 = r8.bottom;
        if (getShowMode() != f.f36269a) goto L21;
        if (r9 != b.f36266c) goto L11;
        if (r12 > r14) goto L11;
    L41:
        return true;
    L11:
        if (r9 != b.f36264a) goto L14;
        if (r10 >= r1) goto L41;
    L14:
        if (r9 != b.f36265b) goto L17;
        if (r11 >= r15) goto L41;
    L17:
        if (r9 != b.f36267d) goto L39;
        if (r13 <= r2) goto L41;
        return false;
    L39:
        return false;
    L21:
        if (getShowMode() == f.f36270b) goto L23;
        return false;
    L23:
        if (r9 != b.f36266c) goto L27;
        if (r1 <= getWidth()) goto L41;
    L27:
        if (r9 != b.f36264a) goto L31;
        if (r14 >= getPaddingLeft()) goto L41;
    L31:
        if (r9 != b.f36265b) goto L35;
        if (r2 >= getPaddingTop()) goto L41;
    L35:
        if (r9 == b.f36267d) goto L37;
        return false;
    L37:
        if (r15 <= getHeight()) goto L41;
        return false;
    }

    public boolean isViewShowing(View r9, Rect r10, b r11, int r12, int r13, int r14, int r15) {
        int r16 = r10.left;
        int r0 = r10.right;
        int r1 = r10.top;
        int r17 = r10.bottom;
        if (getShowMode() != f.f36269a) goto L23;
        int r8 = AnonymousClass4.f36263a[r11.ordinal()];
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
        if (getShowMode() != f.f36270b) goto L59;
        int r18 = AnonymousClass4.f36263a[r11.ordinal()];
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

    public Rect getRelativePosition(View r5) {
        Rect r0 = new Rect(r5.getLeft(), r5.getTop(), 0, 0);
        View r1 = r5;
    L4:
        if (r1.getParent() == null) goto L11;
        if (r1 == getRootView()) goto L11;
        r1 = (View) ZeusTransformUtils.preCheckCast(r1.getParent(), View.class, "com.obric.aiagent.plugin");
        if (r1 == this) goto L11;
        r0.left += r1.getLeft();
        r0.top += r1.getTop();
    L11:
        r0.right = r0.left + r5.getMeasuredWidth();
        r0.bottom = r0.top + r5.getMeasuredHeight();
        return r0;
    }

    public void dispatchSwipeEvent(int r4, int r5, int r6, int r7) {
        b r0 = getDragEdge();
        boolean r2 = false;
        if (r0 != b.f36264a) goto L7;
        if (r6 < 0) goto L19;
    L18:
        r2 = true;
    L19:
        dispatchSwipeEvent(r4, r5, r2);
        return;
    L7:
        if (r0 != b.f36266c) goto L11;
        if (r6 <= 0) goto L18;
    L11:
        if (r0 != b.f36265b) goto L15;
        if (r7 >= 0) goto L18;
    L15:
        if (r0 != b.f36267d) goto L18;
        if (r7 <= 0) goto L18;
        goto L18
    }

    public void dispatchSwipeEvent(int r7, int r8, boolean r9) {
        safeBottomView();
        g r0 = getOpenStatus();
        if (this.mSwipeListeners.isEmpty() == true) goto L37;
        this.mEventCounter++;
        Iterator<i> r1 = this.mSwipeListeners.iterator();
    L6:
        if (r1.hasNext() == false) goto L14;
        i r3 = (i) ZeusTransformUtils.preCheckCast(r1.next(), i.class, "com.obric.aiagent.plugin");
        if (this.mEventCounter != 1) goto L12;
        if (r9 == false) goto L11;
        r3.a(this);
        goto L12
    L11:
        r3.c(this);
    L12:
        r3.a(this, r7 - getPaddingLeft(), r8 - getPaddingTop());
        goto L6
    L14:
        if (r0 != g.f36274c) goto L21;
        Iterator<i> r10 = this.mSwipeListeners.iterator();
    L17:
        if (r10.hasNext() == false) goto L19;
        ((i) ZeusTransformUtils.preCheckCast(r10.next(), i.class, "com.obric.aiagent.plugin")).d(this);
        goto L17
    L19:
        this.mEventCounter = 0;
    L21:
        if (r0 != g.f36273b) goto L38;
        View r11 = getCurrentBottomView();
        if (r11 == null) goto L25;
        r11.setEnabled(true);
    L25:
        Iterator<i> r12 = this.mSwipeListeners.iterator();
    L27:
        if (r12.hasNext() == false) goto L29;
        ((i) ZeusTransformUtils.preCheckCast(r12.next(), i.class, "com.obric.aiagent.plugin")).b(this);
        goto L27
    L29:
        this.mEventCounter = 0;
        return;
    L38:
        return;
    }

    private void safeBottomView() {
        g r0 = getOpenStatus();
        List<View> r1 = getBottomViews();
        if (r0 != g.f36274c) goto L12;
        Iterator<View> r3 = r1.iterator();
    L6:
        if (r3.hasNext() == false) goto L27;
        View r2 = (View) ZeusTransformUtils.preCheckCast(r3.next(), View.class, "com.obric.aiagent.plugin");
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

    public void dispatchRevealEvent(int r17, int r18, int r19, int r20) {
        if (this.mRevealListeners.isEmpty() == false) goto L5;
        return;
    L5:
        Iterator<Map.Entry<View, ArrayList<d>>> r9 = this.mRevealListeners.entrySet().iterator();
    L7:
        if (r9.hasNext() == false) goto L53;
        Map.Entry r11 = (Map.Entry) ZeusTransformUtils.preCheckCast(r9.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        View r12 = (View) ZeusTransformUtils.preCheckCast(r11.getKey(), View.class, "com.obric.aiagent.plugin");
        Rect r13 = getRelativePosition(r12);
        if (isViewShowing(r12, r13, this.mCurrentDragEdge, r17, r18, r19, r20) == false) goto L42;
        int r1 = 0;
        this.mShowEntirely.put(r12, false);
        float r0 = 0.0f;
        if (getShowMode() != f.f36269a) goto L23;
        int r2 = AnonymousClass4.f36263a[this.mCurrentDragEdge.ordinal()];
        if (r2 == 1) goto L21;
        if (r2 == 2) goto L20;
        if (r2 == 3) goto L19;
        if (r2 != 4) goto L35;
        r1 = r13.right - r19;
        float r3 = r1;
        int r4 = r12.getWidth();
    L34:
        r0 = r3 / r4;
    L35:
        Iterator r5 = ((ArrayList) ZeusTransformUtils.preCheckCast(r11.getValue(), ArrayList.class, "com.obric.aiagent.plugin")).iterator();
    L37:
        if (r5.hasNext() == false) goto L42;
        ((d) ZeusTransformUtils.preCheckCast(r5.next(), d.class, "com.obric.aiagent.plugin")).a(r12, this.mCurrentDragEdge, Math.abs(r0), r1);
        if (Math.abs(r0) != 1.0f) goto L37;
        this.mShowEntirely.put(r12, true);
        goto L37
    L19:
        r1 = r13.left - r17;
        r3 = r1;
        r4 = r12.getWidth();
        goto L34
    L20:
        r1 = r13.bottom - r20;
        r3 = r1;
        r4 = r12.getHeight();
        goto L34
    L21:
        r1 = r13.top - r18;
        r3 = r1;
        r4 = r12.getHeight();
        goto L34
    L23:
        if (getShowMode() != f.f36270b) goto L35;
        int r6 = AnonymousClass4.f36263a[this.mCurrentDragEdge.ordinal()];
        if (r6 == 1) goto L33;
        if (r6 == 2) goto L32;
        if (r6 == 3) goto L31;
        if (r6 != 4) goto L35;
        r1 = r13.left - getWidth();
        r3 = r1;
        r4 = r12.getWidth();
        goto L34
    L31:
        r1 = r13.right - getPaddingLeft();
        r3 = r1;
        r4 = r12.getWidth();
        goto L34
    L32:
        r1 = r13.top - getHeight();
        r3 = r1;
        r4 = r12.getHeight();
        goto L34
    L33:
        r1 = r13.bottom - getPaddingTop();
        r3 = r1;
        r4 = r12.getHeight();
    L42:
        if (isViewTotallyFirstShowed(r12, r13, this.mCurrentDragEdge, r17, r18, r19, r20) == false) goto L7;
        this.mShowEntirely.put(r12, true);
        Iterator r7 = ((ArrayList) ZeusTransformUtils.preCheckCast(r11.getValue(), ArrayList.class, "com.obric.aiagent.plugin")).iterator();
    L45:
        if (r7.hasNext() == false) goto L7;
        d r8 = (d) ZeusTransformUtils.preCheckCast(r7.next(), d.class, "com.obric.aiagent.plugin");
        if (this.mCurrentDragEdge == b.f36264a) goto L52;
        if (this.mCurrentDragEdge == b.f36266c) goto L52;
        r8.a(r12, this.mCurrentDragEdge, 1.0f, r12.getHeight());
    L52:
        r8.a(r12, this.mCurrentDragEdge, 1.0f, r12.getWidth());
        goto L45
    }

    @Override // android.view.View
    public void computeScroll() {
        super.computeScroll();
        if (this.mDragHelper.a(true) == false) goto L6;
        ViewCompat.f(this);
        return;
    }

    public void addOnLayoutListener(c r3) {
        c r4 = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.aiagent.plugin");
        if (this.mOnLayoutListeners != null) goto L5;
        this.mOnLayoutListeners = new ArrayList();
    L5:
        this.mOnLayoutListeners.add(r4);
    }

    public void removeOnLayoutListener(c r3) {
        c r4 = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.aiagent.plugin");
        List<c> r2 = this.mOnLayoutListeners;
        if (r2 == null) goto L6;
        r2.remove(r4);
        return;
    }

    public void clearDragEdge() {
        this.mDragEdges.clear();
    }

    public void setDrag(b r1, int r2) {
        clearDragEdge();
        addDrag(r1, r2);
    }

    public void setDrag(b r1, View r2) {
        clearDragEdge();
        addDrag(r1, r2);
    }

    public void addDrag(b r2, int r3) {
        addDrag(r2, findViewById(r3), null);
    }

    public void addDrag(b r2, View r3) {
        addDrag(r2, r3, null);
    }

    public void addDrag(b r4, View r5, ViewGroup.LayoutParams r6) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r6 != null) goto L7;
        r6 = generateDefaultLayoutParams();
    L7:
        if (checkLayoutParams(r6) == true) goto L9;
        r6 = generateLayoutParams(r6);
    L9:
        int r0 = -1;
        int r7 = AnonymousClass4.f36263a[r4.ordinal()];
        if (r7 != 1) goto L12;
        r0 = 48;
    L22:
        if (ZeusTransformUtils.instanceOf(r6, FrameLayout.LayoutParams.class) == false) goto L24;
        ((FrameLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r6, FrameLayout.LayoutParams.class, "com.obric.aiagent.plugin")).gravity = r0;
    L24:
        addView(r5, 0, r6);
        return;
    L12:
        if (r7 == 2) goto L19;
        if (r7 != 3) goto L15;
        r0 = 3;
        goto L22
    L15:
        if (r7 != 4) goto L22;
        r0 = 5;
        goto L22
    L19:
        r0 = 80;
        goto L22
    }

    @Override // android.view.ViewGroup
    public void addView(View r5, int r6, ViewGroup.LayoutParams r7) {
        if (r5 != null) goto L5;
        return;
    L5:
        int r1 = 0;
        r1 = ((Integer) ZeusTransformUtils.preCheckCast(r7.getClass().getField("gravity").get(r7), Integer.class, "com.obric.aiagent.plugin")).intValue();     // Catch: Exception -> L8
    L10:
        if (r1 <= 0) goto L23;
        int r0 = androidx.core.view.d.a(r1, ViewCompat.i(this));
        if ((r0 & 3) != 3) goto L15;
        this.mDragEdges.put(b.f36264a, r5);
    L15:
        if ((r0 & 5) != 5) goto L18;
        this.mDragEdges.put(b.f36266c, r5);
    L18:
        if ((r0 & 48) != 48) goto L21;
        this.mDragEdges.put(b.f36265b, r5);
    L21:
        if ((r0 & 80) != 80) goto L30;
        this.mDragEdges.put(b.f36267d, r5);
    L30:
        if (r5.getParent() != this) goto L32;
        return;
    L32:
        super.addView(r5, r6, r7);
        return;
    L23:
        Iterator<Map.Entry<b, View>> r2 = this.mDragEdges.entrySet().iterator();
    L25:
        if (r2.hasNext() == false) goto L30;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r2.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        if (r3.getValue() != null) goto L25;
        this.mDragEdges.put((b) ZeusTransformUtils.preCheckCast(r3.getKey(), b.class, "com.obric.aiagent.plugin"), r5);
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L10
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        updateBottomViews();
        if (this.mOnLayoutListeners == null) goto L8;
        int r6 = 0;
    L6:
        if (r6 >= this.mOnLayoutListeners.size()) goto L10;
        ((c) ZeusTransformUtils.preCheckCast(this.mOnLayoutListeners.get(r6), c.class, "com.obric.aiagent.plugin")).a(this);
        r6 = r6 + 1;
        goto L6
    L10:
        return;
    }

    void layoutPullOut() {
        View r0 = getSurfaceView();
        Rect r1 = (Rect) ZeusTransformUtils.preCheckCast(this.mViewBoundCache.get(r0), Rect.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L5;
    L9:
        if (r0 == null) goto L11;
        r0.layout(r1.left, r1.top, r1.right, r1.bottom);
        bringChildToFront(r0);
    L11:
        View r2 = getCurrentBottomView();
        Rect r3 = (Rect) ZeusTransformUtils.preCheckCast(this.mViewBoundCache.get(r2), Rect.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L14;
        r3 = computeBottomLayoutAreaViaSurface(f.f36270b, r1);
    L14:
        if (r2 == null) goto L17;
        r2.layout(r3.left, r3.top, r3.right, r3.bottom);
        return;
    L17:
        return;
    L5:
        if (getOpenStatus() == g.f36274c) goto L7;
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
        Rect r1 = (Rect) ZeusTransformUtils.preCheckCast(this.mViewBoundCache.get(r0), Rect.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L5;
        r1 = computeSurfaceLayoutArea(false);
    L5:
        if (r0 == null) goto L7;
        r0.layout(r1.left, r1.top, r1.right, r1.bottom);
        bringChildToFront(r0);
    L7:
        View r2 = getCurrentBottomView();
        Rect r3 = (Rect) ZeusTransformUtils.preCheckCast(this.mViewBoundCache.get(r2), Rect.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L10;
        r3 = computeBottomLayoutAreaViaSurface(f.f36269a, r1);
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
        if (getOpenStatus() != g.f36272a) goto L11;
        this.mIsBeingDragged = true;
        return;
    L11:
        g r0 = getOpenStatus();
        float r1 = r10.getRawX() - this.sX;
        float r11 = r10.getRawY() - this.sY;
        float r3 = (float) Math.toDegrees(Math.atan(Math.abs(r11 / r1)));
        if (getOpenStatus() == g.f36274c) goto L14;
    L38:
        boolean r7 = false;
        if (this.mCurrentDragEdge == b.f36266c) goto L41;
    L67:
        boolean r4 = false;
    L69:
        if (this.mCurrentDragEdge != b.f36264a) goto L91;
        if (r0 != g.f36273b) goto L75;
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
        if (r0 == g.f36272a) goto L85;
        r5 = false;
    L75:
        if (r0 == g.f36274c) goto L77;
    L79:
        r2 = false;
        goto L80
    L77:
        if (r1 <= this.mTouchSlop) goto L79;
    L91:
        if (this.mCurrentDragEdge != b.f36265b) goto L113;
        if (r0 != g.f36273b) goto L97;
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
        if (r0 == g.f36272a) goto L107;
        r8 = false;
    L97:
        if (r0 == g.f36274c) goto L99;
    L101:
        r6 = false;
        goto L102
    L99:
        if (r11 <= this.mTouchSlop) goto L101;
    L113:
        if (this.mCurrentDragEdge == b.f36267d) goto L115;
    L132:
        this.mIsBeingDragged = !r4;
        return;
    L115:
        if (r0 != g.f36273b) goto L119;
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
        if (r0 != g.f36272a) goto L129;
    L119:
        if (r0 == g.f36274c) goto L121;
    L123:
        r12 = false;
        goto L124
    L121:
        if (r11 >= (-this.mTouchSlop)) goto L123;
    L41:
        if (r0 != g.f36273b) goto L45;
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
        if (r0 == g.f36272a) goto L62;
        r13 = false;
        goto L64
    L53:
        if (r0 != g.f36273b) goto L57;
        if (r1 >= (-this.mTouchSlop)) goto L57;
        r9 = true;
    L45:
        if (r0 == g.f36274c) goto L47;
    L49:
        r9 = false;
        goto L51
    L47:
        if (r1 >= (-this.mTouchSlop)) goto L49;
    L14:
        if (r3 >= 45.0f) goto L27;
        if (r1 <= 0.0f) goto L21;
        if (isLeftSwipeEnabled() == false) goto L21;
        b r14 = b.f36264a;
    L36:
        setCurrentDragEdge(r14);
    L21:
        if (r1 < 0.0f) goto L23;
        return;
    L23:
        if (isRightSwipeEnabled() == false) goto L134;
        r14 = b.f36266c;
        goto L36
    L134:
        return;
    L27:
        if (r11 <= 0.0f) goto L32;
        if (isTopSwipeEnabled() == false) goto L32;
        r14 = b.f36265b;
    L32:
        if (r11 < 0.0f) goto L34;
        return;
    L34:
        if (isBottomSwipeEnabled() == false) goto L135;
        r14 = b.f36267d;
        goto L36
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r7) {
        if (isSwipeEnabled() == true) goto L6;
        return false;
    L6:
        if (this.mClickToClose == true) goto L8;
    L12:
        Iterator<h> r0 = this.mSwipeDeniers.iterator();
    L14:
        if (r0.hasNext() == false) goto L20;
        h r3 = (h) ZeusTransformUtils.preCheckCast(r0.next(), h.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L14;
        if (r3.a(r7) == false) goto L14;
        return false;
    L20:
        int r1 = r7.getAction();
        if (r1 == 0) goto L40;
        if (r1 != 1) goto L24;
    L39:
        this.mIsDownOutSurfaceView = false;
        this.mIsBeingDragged = false;
        this.mDragHelper.b(r7);
    L49:
        return this.mIsBeingDragged;
    L24:
        if (r1 != 2) goto L26;
        boolean r2 = this.mIsBeingDragged;
        checkCanDrag(r7);
        if (this.mIsBeingDragged == true) goto L31;
    L35:
        if (r2 == true) goto L49;
        if (this.mIsBeingDragged == false) goto L49;
        return false;
    L31:
        if (this.mIsDownOutSurfaceView == true) goto L35;
        ViewParent r8 = getParent();
        if (r8 == null) goto L35;
        r8.requestDisallowInterceptTouchEvent(true);
        goto L35
    L26:
        if (r1 == 3) goto L39;
        this.mDragHelper.b(r7);
        goto L49
    L40:
        this.mDragHelper.b(r7);
        this.mIsDownOutSurfaceView = false;
        this.mIsBeingDragged = false;
        this.sX = r7.getRawX();
        this.sY = r7.getRawY();
        if (getOpenStatus() != g.f36272a) goto L44;
        this.mIsBeingDragged = true;
    L44:
        if (this.mQuickDeleteEnabled == false) goto L49;
        if (isDownOnSurface(r7) == true) goto L49;
        this.mIsDownOutSurfaceView = true;
        goto L49
    L8:
        if (getOpenStatus() != g.f36273b) goto L12;
        if (isTouchOnSurface(r7) == false) goto L12;
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
        this.mDragHelper.b(r5);
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
        this.mDragHelper.b(r5);
        goto L22
    L12:
        if (r0 == 3) goto L19;
        this.mDragHelper.b(r5);
        goto L22
    L20:
        this.mDragHelper.b(r5);
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
        View r0 = (View) ZeusTransformUtils.preCheckCast(this.mDragEdges.get(b.f36264a), View.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
    L11:
        return false;
    L5:
        if (r0.getParent() != this) goto L11;
        if (r0 == getSurfaceView()) goto L11;
        if (this.mSwipesEnabled[b.f36264a.ordinal()] == false) goto L11;
        return true;
    }

    public void setLeftSwipeEnabled(boolean r2) {
        this.mSwipesEnabled[b.f36264a.ordinal()] = r2;
    }

    public boolean isRightSwipeEnabled() {
        View r0 = (View) ZeusTransformUtils.preCheckCast(this.mDragEdges.get(b.f36266c), View.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
    L11:
        return false;
    L5:
        if (r0.getParent() != this) goto L11;
        if (r0 == getSurfaceView()) goto L11;
        if (this.mSwipesEnabled[b.f36266c.ordinal()] == false) goto L11;
        return true;
    }

    public void setRightSwipeEnabled(boolean r2) {
        this.mSwipesEnabled[b.f36266c.ordinal()] = r2;
    }

    public boolean isTopSwipeEnabled() {
        View r0 = (View) ZeusTransformUtils.preCheckCast(this.mDragEdges.get(b.f36265b), View.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
    L11:
        return false;
    L5:
        if (r0.getParent() != this) goto L11;
        if (r0 == getSurfaceView()) goto L11;
        if (this.mSwipesEnabled[b.f36265b.ordinal()] == false) goto L11;
        return true;
    }

    public void setTopSwipeEnabled(boolean r2) {
        this.mSwipesEnabled[b.f36265b.ordinal()] = r2;
    }

    public boolean isBottomSwipeEnabled() {
        View r0 = (View) ZeusTransformUtils.preCheckCast(this.mDragEdges.get(b.f36267d), View.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
    L11:
        return false;
    L5:
        if (r0.getParent() != this) goto L11;
        if (r0 == getSurfaceView()) goto L11;
        if (this.mSwipesEnabled[b.f36267d.ordinal()] == false) goto L11;
        return true;
    }

    public void setBottomSwipeEnabled(boolean r2) {
        this.mSwipesEnabled[b.f36267d.ordinal()] = r2;
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
        if (ZeusTransformUtils.instanceOf(r0, AdapterView.class) == true) goto L9;
        r0 = r0.getParent();
    L9:
        if (ZeusTransformUtils.instanceOf(r0, AdapterView.class) == true) goto L11;
        return null;
    L11:
        return (AdapterView) ZeusTransformUtils.preCheckCast(r0, AdapterView.class, "com.obric.aiagent.plugin");
    }

    private void performAdapterViewItemClick() {
        if (getOpenStatus() == g.f36274c) goto L5;
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

    private int getPositionForViewInDescendant(ViewGroup r6, View r7) {
        int r0 = r6.getChildCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L13;
        View r2 = r6.getChildAt(r1);
        if (r2 == r7) goto L6;
        if (ZeusTransformUtils.instanceOf(r2, ViewGroup.class) == false) goto L12;
        if (containsView((ViewGroup) ZeusTransformUtils.preCheckCast(r2, ViewGroup.class, "com.obric.aiagent.plugin"), r7) == false) goto L12;
        return r1;
    L12:
        r1 = r1 + 1;
        goto L3
    L6:
        return r1;
    L13:
        return -1;
    }

    private boolean containsView(ViewGroup r8, View r9) {
        int r0 = r8.getChildCount();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L13;
        View r3 = r8.getChildAt(r2);
        if (r3 == r9) goto L6;
        if (ZeusTransformUtils.instanceOf(r3, ViewGroup.class) == false) goto L12;
        if (containsView((ViewGroup) ZeusTransformUtils.preCheckCast(r3, ViewGroup.class, "com.obric.aiagent.plugin"), r9) == false) goto L12;
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
        if (getOpenStatus() == g.f36274c) goto L5;
        return false;
    L5:
        AdapterView r0 = getAdapterView();
        if (r0 == null) goto L26;
        AdapterView<?> r1 = (AdapterView) ZeusTransformUtils.preCheckCast(r0, AdapterView.class, "com.obric.aiagent.plugin");
        int r2 = r1.getPositionForView(this);
        if (r2 == (-1)) goto L10;
    L12:
        int r7 = r2;
        if (r7 != (-1)) goto L15;
        return false;
    L15:
        long r8 = r1.getItemIdAtPosition(r7);
        Method r3 = AbsListView.class.getDeclaredMethod("performLongPress", new Class[]{View.class, Integer.TYPE, Long.TYPE});     // Catch: Exception -> L18
        r3.setAccessible(true);     // Catch: Exception -> L18
        return ((Boolean) ZeusTransformUtils.preCheckCast(r3.invoke(r1, new Object[]{this, Integer.valueOf(r7), Long.valueOf(r8)}), Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
    L18:
        e = move-exception;
        e.printStackTrace();
        if (r1.getOnItemLongClickListener() == null) goto L22;
        boolean r13 = r1.getOnItemLongClickListener().onItemLongClick(r1, this, r7, r8);
    L23:
        if (r13 == false) goto L29;
        r1.performHapticFeedback(0);
        return r13;
    L29:
        return r13;
    L22:
        r13 = false;
        goto L23
    L10:
        if (findAncestorNode() == false) goto L12;
        r2 = getPositionForViewInDescendant(r1, this);
        goto L12
    L26:
        return false;
    }

    public boolean findAncestorNode() {
        return this.findAncestorNodeMode;
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
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
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        androidx.customview.widget.c r0 = this.mDragHelper;
        if (r0 == null) goto L6;
        r0.h();
    L6:
        if (getOpenStatus() == g.f36274c) goto L9;
        close(false);
        return;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener r3) {
        View.OnClickListener r4 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r3, View.OnClickListener.class, "com.obric.aiagent.plugin");
        super.setOnClickListener(r4);
        this.clickListener = r4;
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener r3) {
        View.OnLongClickListener r4 = (View.OnLongClickListener) ZeusTransformUtils.wrapperContextForParams(r3, View.OnLongClickListener.class, "com.obric.aiagent.plugin");
        super.setOnLongClickListener(r4);
        this.longClickListener = r4;
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

    public void setShowMode(f r1) {
        this.mShowMode = r1;
        requestLayout();
    }

    public b getDragEdge() {
        return this.mCurrentDragEdge;
    }

    public int getDragDistance() {
        return this.mDragDistance;
    }

    public f getShowMode() {
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
        return (View) ZeusTransformUtils.preCheckCast(r0.get(this.mCurrentDragEdge.ordinal()), View.class, "com.obric.aiagent.plugin");
    }

    public List<View> getBottomViews() {
        ArrayList r0 = new ArrayList();
        b[] r1 = b.values();
        int r2 = r1.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L5;
        b r4 = r1[r3];
        r0.add((View) ZeusTransformUtils.preCheckCast(this.mDragEdges.get(r4), View.class, "com.obric.aiagent.plugin"));
        r3 = r3 + 1;
        goto L3
    L5:
        return r0;
    }

    public g getOpenStatus() {
        View r0 = getSurfaceView();
        if (r0 == null) goto L5;
        int r1 = r0.getLeft();
        int r2 = r0.getTop();
        if (r1 != getPaddingLeft()) goto L13;
        if (r2 != getPaddingTop()) goto L13;
        return g.f36274c;
    L13:
        if (r1 == (getPaddingLeft() - this.mDragDistance)) goto L24;
        if (r1 == (getPaddingLeft() + this.mDragDistance)) goto L24;
        if (r2 == (getPaddingTop() - this.mDragDistance)) goto L24;
        if (r2 == (getPaddingTop() + this.mDragDistance)) goto L24;
        return g.f36272a;
    L24:
        return g.f36273b;
    L5:
        return g.f36274c;
    }

    public boolean getIsBeingDragged() {
        return this.mIsBeingDragged;
    }

    public boolean hasIsQuickDeleteTriggered() {
        return this.mIsQuickDeleteTriggered;
    }

    public void processHandRelease(float r5, float r6, boolean r7) {
        float r0 = this.mDragHelper.a();
        View r1 = getSurfaceView();
        b r2 = this.mCurrentDragEdge;
        if (r2 == null) goto L63;
        if (r1 != null) goto L7;
        return;
    L7:
        if (this.mQuickDeleteEnabled == true) goto L9;
    L11:
        if (r7 == false) goto L13;
        float r8 = this.mWillOpenPercentAfterClose;
    L15:
        if (r2 != b.f36264a) goto L27;
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
        if (r2 != b.f36266c) goto L39;
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
        if (r2 != b.f36265b) goto L51;
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
        if (r2 == b.f36267d) goto L53;
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
        androidx.customview.widget.c r2 = this.mDragHelper;
        if (r2 == null) goto L8;
        r2.h();
    L8:
        Rect r3 = computeSurfaceLayoutArea(true);
        if (r9 == false) goto L11;
        this.mDragHelper.a(r0, r3.left, r3.top);
    L30:
        invalidate();
        return;
    L11:
        int r11 = r3.left - r0.getLeft();
        int r4 = r3.top - r0.getTop();
        r0.layout(r3.left, r3.top, r3.right, r3.bottom);
        Rect r5 = (Rect) ZeusTransformUtils.preCheckCast(this.mViewBoundCache.get(r0), Rect.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L14;
        r5 = new Rect();
        this.mViewBoundCache.put(r0, r5);
    L14:
        r5.set(r3);
        if (getShowMode() != f.f36270b) goto L20;
        Rect r6 = computeBottomLayoutAreaViaSurface(f.f36270b, r3);
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
        if (getShowMode() != f.f36269a) goto L27;
        Rect r7 = computeBottomLayoutAreaViaSurface(f.f36269a, r3);
        if (r1 == null) goto L27;
        Rect r8 = (Rect) ZeusTransformUtils.preCheckCast(this.mViewBoundCache.get(r1), Rect.class, "com.obric.aiagent.plugin");
        if (r8 != null) goto L26;
        r8 = new Rect();
        this.mViewBoundCache.put(r1, r8);
    L26:
        r8.set(r7);
        r1.layout(r7.left, r7.top, r7.right, r7.bottom);
        goto L27
    }

    public void open(b r1) {
        setCurrentDragEdge(r1);
        open(true, true);
    }

    public void open(boolean r1, b r2) {
        setCurrentDragEdge(r2);
        open(r1, true);
    }

    public void open(boolean r1, boolean r2, b r3) {
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
        androidx.customview.widget.c r1 = this.mDragHelper;
        if (r1 == null) goto L8;
        r1.h();
    L8:
        if (r8 == false) goto L10;
        this.mDragHelper.a(getSurfaceView(), getPaddingLeft(), getPaddingTop());
    L17:
        invalidate();
        return;
    L10:
        Rect r10 = computeSurfaceLayoutArea(false);
        this.mViewBoundCache.remove(r0);
        if (((Rect) ZeusTransformUtils.preCheckCast(this.mViewBoundCache.get(getCurrentBottomView()), Rect.class, "com.obric.aiagent.plugin")) == null) goto L13;
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
        if (getOpenStatus() != g.f36273b) goto L6;
        close(r3);
        return;
    L6:
        if (getOpenStatus() != g.f36274c) goto L10;
        open(r3);
        return;
    }

    private Rect computeSurfaceLayoutArea(boolean r4) {
        int r0 = getPaddingLeft();
        int r1 = getPaddingTop();
        if (r4 == false) goto L15;
        if (this.mCurrentDragEdge != b.f36264a) goto L8;
        int r5 = getPaddingLeft();
        r0 = this.mDragDistance + r5;
        goto L15
    L8:
        if (this.mCurrentDragEdge != b.f36266c) goto L11;
        r0 = getPaddingLeft() - this.mDragDistance;
        goto L15
    L11:
        if (this.mCurrentDragEdge != b.f36265b) goto L13;
        int r6 = getPaddingTop();
        r1 = this.mDragDistance + r6;
        goto L15
    L13:
        r1 = getPaddingTop() - this.mDragDistance;
    L15:
        return new Rect(r0, r1, getMeasuredWidth() + r0, getMeasuredHeight() + r1);
    }

    private Rect computeBottomLayoutAreaViaSurface(f r7, Rect r8) {
        View r0 = getCurrentBottomView();
        int r1 = r8.left;
        int r2 = r8.top;
        int r3 = r8.right;
        int r4 = r8.bottom;
        if (r7 != f.f36270b) goto L29;
        if (this.mCurrentDragEdge != b.f36264a) goto L8;
        r1 = r8.left - this.mDragDistance;
    L14:
        int r5 = 0;
        if (this.mCurrentDragEdge != b.f36264a) goto L17;
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
        if (this.mCurrentDragEdge == b.f36266c) goto L23;
        if (r0 == null) goto L22;
        r5 = r0.getMeasuredHeight();
    L22:
        r4 = r5 + r2;
        r3 = r8.right;
        goto L41
    L8:
        if (this.mCurrentDragEdge != b.f36266c) goto L11;
        r1 = r8.right;
        goto L14
    L11:
        if (this.mCurrentDragEdge != b.f36265b) goto L13;
        r2 = r8.top - this.mDragDistance;
        goto L14
    L13:
        r2 = r8.bottom;
        goto L14
    L29:
        if (r7 != f.f36269a) goto L41;
        if (this.mCurrentDragEdge != b.f36264a) goto L34;
        r3 = r1 + this.mDragDistance;
        goto L41
    L34:
        if (this.mCurrentDragEdge != b.f36266c) goto L37;
        r1 = r3 - this.mDragDistance;
        goto L41
    L37:
        if (this.mCurrentDragEdge != b.f36265b) goto L39;
        r4 = r2 + this.mDragDistance;
        goto L41
    L39:
        r2 = r4 - this.mDragDistance;
        goto L41
    }

    private Rect computeBottomLayDown(b r4) {
        int r0 = getPaddingLeft();
        int r1 = getPaddingTop();
        if (r4 != b.f36266c) goto L6;
        r0 = getMeasuredWidth() - this.mDragDistance;
    L9:
        if (r4 != b.f36264a) goto L11;
    L14:
        int r5 = this.mDragDistance + r0;
        int r3 = getMeasuredHeight();
    L16:
        return new Rect(r0, r1, r5, r3 + r1);
    L11:
        if (r4 == b.f36266c) goto L14;
        r5 = getMeasuredWidth() + r0;
        r3 = this.mDragDistance;
        goto L16
    L6:
        if (r4 != b.f36267d) goto L9;
        r1 = getMeasuredHeight() - this.mDragDistance;
        goto L9
    }

    public void setOnDoubleClickListener(a r3) {
        this.mDoubleClickListener = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.aiagent.plugin");
    }

    private int dp2px(float r3) {
        return (int) ((r3 * ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin").getDisplayMetrics().density) + 0.5f);
    }

    @Deprecated
    public void setDragEdge(b r4) {
        clearDragEdge();
        if (getChildCount() < 2) goto L5;
        this.mDragEdges.put(r4, getChildAt(getChildCount() - 2));
    L5:
        setCurrentDragEdge(r4);
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View r5) {
        Iterator r0 = new HashMap(this.mDragEdges).entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r0.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        if (r1.getValue() != r5) goto L4;
        this.mDragEdges.remove(r1.getKey());
        goto L4
    }

    public Map<b, View> getDragEdgeMap() {
        return this.mDragEdges;
    }

    @Deprecated
    public List<b> getDragEdges() {
        return new ArrayList(this.mDragEdges.keySet());
    }

    @Deprecated
    public void setDragEdges(List<b> r8) {
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.aiagent.plugin");
        clearDragEdge();
        int r0 = Math.min(r9.size(), getChildCount() - 1);
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L6;
        this.mDragEdges.put((b) ZeusTransformUtils.preCheckCast(r9.get(r3), b.class, "com.obric.aiagent.plugin"), getChildAt(r3));
        r3 = r3 + 1;
        goto L3
    L6:
        if (r9.size() != 0) goto L8;
    L11:
        setCurrentDragEdge(DefaultDragEdge);
        return;
    L8:
        if (r9.contains(DefaultDragEdge) == true) goto L11;
        setCurrentDragEdge((b) ZeusTransformUtils.preCheckCast(r9.get(0), b.class, "com.obric.aiagent.plugin"));
    }

    @Deprecated
    public void setDragEdges(b... r1) {
        clearDragEdge();
        setDragEdges(Arrays.asList(r1));
    }

    @Deprecated
    public void setBottomViewIds(int r2, int r3, int r4, int r5) {
        addDrag(b.f36264a, findViewById(r2));
        addDrag(b.f36266c, findViewById(r3));
        addDrag(b.f36265b, findViewById(r4));
        addDrag(b.f36267d, findViewById(r5));
    }

    private float getCurrentOffset() {
        b r0 = this.mCurrentDragEdge;
        if (r0 != null) goto L7;
        return 0.0f;
    L7:
        return this.mEdgeSwipesOffset[r0.ordinal()];
    }

    private void setCurrentDragEdge(b r1) {
        this.mCurrentDragEdge = r1;
        updateBottomViews();
    }

    private void updateBottomViews() {
        View r0 = getCurrentBottomView();
        if (r0 == null) goto L12;
        if (this.mCurrentDragEdge != b.f36264a) goto L7;
    L10:
        this.mDragDistance = r0.getMeasuredWidth() - dp2px(getCurrentOffset());
        goto L12
    L7:
        if (this.mCurrentDragEdge == b.f36266c) goto L10;
        this.mDragDistance = r0.getMeasuredHeight() - dp2px(getCurrentOffset());
    L12:
        if (this.mShowMode != f.f36270b) goto L15;
        layoutPullOut();
    L17:
        safeBottomView();
        return;
    L15:
        if (this.mShowMode != f.f36269a) goto L17;
        layoutLayDown();
        goto L17
    }
}
