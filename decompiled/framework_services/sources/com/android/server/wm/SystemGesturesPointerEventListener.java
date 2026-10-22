package com.android.server.wm;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.Region;
import android.hardware.display.DisplayManagerGlobal;
import android.os.Handler;
import android.os.SystemClock;
import android.pico.utils.Features;
import android.util.Slog;
import android.view.Display;
import android.view.DisplayCutout;
import android.view.DisplayInfo;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.WindowManagerPolicyConstants;
import android.widget.OverScroller;
import com.android.server.SysOptBridge;
import com.android.server.redmagic.GameKeysPatch;
import com.android.server.resmng.IBoostTouchUpController;
import com.android.server.usb.descriptors.UsbACInterface;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes3.dex */
class SystemGesturesPointerEventListener implements WindowManagerPolicyConstants.PointerEventListener {
    private static final boolean DEBUG = false;
    private static final int MAX_FLING_TIME_MILLIS = 5000;
    private static final int MAX_TRACKED_POINTERS = 32;
    private static final int SWIPE_FROM_BOTTOM = 2;
    private static final int SWIPE_FROM_ISLAND = 5;
    private static final int SWIPE_FROM_LEFT = 4;
    private static final int SWIPE_FROM_RIGHT = 3;
    private static final int SWIPE_FROM_TOP = 1;
    private static final int SWIPE_NONE = 0;
    private static final long SWIPE_TIMEOUT_MS = 500;
    private static final String TAG = "SystemGestures";
    private static final int TRACKPAD_SWIPE_FROM_BOTTOM = 2;
    private static final int TRACKPAD_SWIPE_FROM_LEFT = 4;
    private static final int TRACKPAD_SWIPE_FROM_RIGHT = 3;
    private static final int TRACKPAD_SWIPE_FROM_TOP = 1;
    private static final int TRACKPAD_SWIPE_NONE = 0;
    private static final int UNTRACKED_POINTER = -1;
    private final Callbacks mCallbacks;
    private final Context mContext;
    private boolean mDebugFireable;
    private int mDisplayCutoutTouchableRegionSize;
    private final int[] mDownPointerId;
    private int mDownPointers;
    private final long[] mDownTime;
    private final float[] mDownX;
    private final float[] mDownY;
    private GestureDetector mGestureDetector;
    private final Handler mHandler;
    private boolean mInMutiTouch;
    private long mLastFlingTime;
    private boolean mMouseHoveringAtBottom;
    private boolean mMouseHoveringAtLeft;
    private boolean mMouseHoveringAtRight;
    private boolean mMouseHoveringAtTop;
    private boolean mScrollFired;
    private int mSwipeDistanceThreshold;
    private boolean mSwipeFireable;
    private final Rect mSwipeStartThreshold;
    int screenHeight;
    int screenWidth;

    interface Callbacks {
        void onDebug();

        void onDown();

        void onFling(int r1);

        void onHorizontalFling(int r1);

        void onMouseHoverAtBottom();

        void onMouseHoverAtLeft();

        void onMouseHoverAtRight();

        void onMouseHoverAtTop();

        void onMouseLeaveFromBottom();

        void onMouseLeaveFromLeft();

        void onMouseLeaveFromRight();

        void onMouseLeaveFromTop();

        void onScroll(boolean r1);

        void onSwipeFromBottom();

        void onSwipeFromLeft();

        void onSwipeFromRight();

        void onSwipeFromTop();

        void onUpOrCancel();

        void onVerticalFling(int r1);

        default boolean onSwipeFromIsland() {
            return false;
        }
    }

    private final class FlingGestureDetector extends GestureDetector.SimpleOnGestureListener {
        private OverScroller mOverscroller;
        final /* synthetic */ SystemGesturesPointerEventListener this$0;

        FlingGestureDetector(SystemGesturesPointerEventListener r2) {
            this.this$0 = r2;
            this.mOverscroller = new OverScroller(SystemGesturesPointerEventListener.m10167$$Nest$fgetmContext(r2));
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent e) {
            if (this.mOverscroller.isFinished() == true) goto L5;
            this.mOverscroller.forceFinished(true);
        L5:
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent down, MotionEvent up, float velocityX, float velocityY) {
            this.mOverscroller.computeScrollOffset();
            long now = SystemClock.uptimeMillis();
            if (SystemGesturesPointerEventListener.m10168$$Nest$fgetmLastFlingTime(this.this$0) != 0) goto L5;
        L7:
            this.mOverscroller.fling(0, 0, (int) velocityX, (int) velocityY, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
            int duration = this.mOverscroller.getDuration();
            if (duration <= 5000) goto L11;
            duration = 5000;
        L11:
            if (Math.abs(velocityY) < Math.abs(velocityX)) goto L13;
            SystemGesturesPointerEventListener.m10166$$Nest$fgetmCallbacks(this.this$0).onVerticalFling(duration);
        L14:
            SystemGesturesPointerEventListener.m10170$$Nest$fputmLastFlingTime(this.this$0, now);
            SystemGesturesPointerEventListener.m10166$$Nest$fgetmCallbacks(this.this$0).onFling(duration);
            SysOptBridge.getFactory().getDynamicRefreshRateService().onFling(velocityX, velocityY, duration);
            return true;
        L13:
            SystemGesturesPointerEventListener.m10166$$Nest$fgetmCallbacks(this.this$0).onHorizontalFling(duration);
            goto L14
        L5:
            if (now <= (SystemGesturesPointerEventListener.m10168$$Nest$fgetmLastFlingTime(this.this$0) + 5000)) goto L7;
            this.mOverscroller.forceFinished(true);
            goto L7
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            if (SystemGesturesPointerEventListener.m10169$$Nest$fgetmScrollFired(this.this$0) == true) goto L5;
            SystemGesturesPointerEventListener.m10166$$Nest$fgetmCallbacks(this.this$0).onScroll(true);
            SystemGesturesPointerEventListener.m10171$$Nest$fputmScrollFired(this.this$0, true);
        L5:
            return true;
        }
    }

    public static /* synthetic */ void $r8$lambda$ny76CjJQ3d_Eeus7bZqFDsxdevk(SystemGesturesPointerEventListener r0) {
        r0.lambda$systemReady$0();
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCallbacks, reason: not valid java name */
    static /* bridge */ /* synthetic */ Callbacks m10166$$Nest$fgetmCallbacks(SystemGesturesPointerEventListener r0) {
        return r0.mCallbacks;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context m10167$$Nest$fgetmContext(SystemGesturesPointerEventListener r0) {
        return r0.mContext;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLastFlingTime, reason: not valid java name */
    static /* bridge */ /* synthetic */ long m10168$$Nest$fgetmLastFlingTime(SystemGesturesPointerEventListener r2) {
        return r2.mLastFlingTime;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmScrollFired, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m10169$$Nest$fgetmScrollFired(SystemGesturesPointerEventListener r0) {
        return r0.mScrollFired;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmLastFlingTime, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m10170$$Nest$fputmLastFlingTime(SystemGesturesPointerEventListener r0, long r1) {
        r0.mLastFlingTime = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmScrollFired, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m10171$$Nest$fputmScrollFired(SystemGesturesPointerEventListener r0, boolean r1) {
        r0.mScrollFired = r1;
    }

    SystemGesturesPointerEventListener(Context context, Handler handler, Callbacks callbacks) {
        this.mSwipeStartThreshold = new Rect();
        this.mDownPointerId = new int[32];
        this.mDownX = new float[32];
        this.mDownY = new float[32];
        this.mDownTime = new long[32];
        this.mContext = (Context) checkNull("context", context);
        this.mHandler = handler;
        this.mCallbacks = (Callbacks) checkNull("callbacks", callbacks);
        onConfigurationChanged();
    }

    void onDisplayInfoChanged(DisplayInfo info) {
        this.screenWidth = info.logicalWidth;
        this.screenHeight = info.logicalHeight;
        onConfigurationChanged();
    }

    void onConfigurationChanged() {
        Resources r = this.mContext.getResources();
        int startThreshold = r.getDimensionPixelSize(17106453);
        this.mSwipeStartThreshold.set(startThreshold, startThreshold, startThreshold, startThreshold);
        this.mSwipeDistanceThreshold = r.getDimensionPixelSize(17106452);
        Display display = DisplayManagerGlobal.getInstance().getRealDisplay(0);
        if (display == null) goto L5;
        DisplayCutout displayCutout = display.getCutout();
    L6:
        if (displayCutout == null) goto L20;
        this.mDisplayCutoutTouchableRegionSize = r.getDimensionPixelSize(R.dimen.keyguard_lockscreen_status_line_font_size);
        Rect[] bounds = displayCutout.getBoundingRectsAll();
        if (bounds[0] == null) goto L11;
        Rect r6 = this.mSwipeStartThreshold;
        r6.left = Math.max(this.mSwipeStartThreshold.left, bounds[0].width() + this.mDisplayCutoutTouchableRegionSize);
    L11:
        if (bounds[1] == null) goto L14;
        Rect r7 = this.mSwipeStartThreshold;
        r7.top = Math.max(this.mSwipeStartThreshold.top, bounds[1].height() + this.mDisplayCutoutTouchableRegionSize);
    L14:
        if (bounds[2] == null) goto L17;
        Rect r8 = this.mSwipeStartThreshold;
        r8.right = Math.max(this.mSwipeStartThreshold.right, bounds[2].width() + this.mDisplayCutoutTouchableRegionSize);
    L17:
        if (bounds[3] == null) goto L21;
        Rect r9 = this.mSwipeStartThreshold;
        r9.bottom = Math.max(this.mSwipeStartThreshold.bottom, bounds[3].height() + this.mDisplayCutoutTouchableRegionSize);
        return;
    L21:
        return;
    L20:
        return;
    L5:
        displayCutout = null;
        goto L6
    }

    private static <T> T checkNull(String name, T arg) {
        if (arg == null) goto L5;
        return arg;
    L5:
        throw new IllegalArgumentException(name + " must not be null");
    }

    public void systemReady() {
        this.mHandler.post(new SystemGesturesPointerEventListener$$ExternalSyntheticLambda0(this));
    }

    private /* synthetic */ void lambda$systemReady$0() {
        int displayId = this.mContext.getDisplayId();
        DisplayInfo info = DisplayManagerGlobal.getInstance().getDisplayInfo(displayId);
        if (info != null) goto L6;
        Slog.w(TAG, "Cannot create GestureDetector, display removed:" + displayId);
        return;
    L6:
        final Context r3 = this.mContext;
        final FlingGestureDetector r4 = new FlingGestureDetector(this);
        final Handler r5 = this.mHandler;
        this.mGestureDetector = new AnonymousClass1(this, r3, r4, r5);
    }

    public void onPointerEvent(MotionEvent event) {
        if (this.mGestureDetector != null) goto L5;
    L7:
        boolean r2 = true;
        boolean r3 = false;
        switch(event.getActionMasked()) {
            case 0: goto L106;
            case 1: goto L123;
            case 2: goto L62;
            case 3: goto L102;
            case 4: goto L136;
            case 5: goto L53;
            case 6: goto L136;
            case 7: goto L11;
            default: goto L136;
        };
    L53:
        this.mInMutiTouch = true;
        captureDown(event, event.getActionIndex());
        if (this.mDebugFireable == true) goto L56;
        return;
    L56:
        if (event.getPointerCount() < 5) goto L59;
        r2 = false;
    L59:
        this.mDebugFireable = r2;
        if (this.mDebugFireable == true) goto L127;
        this.mCallbacks.onDebug();
        return;
    L127:
        return;
    L62:
        SysOptBridge.getFactory().getDynamicRefreshRateService().onMove();
        if (this.mSwipeFireable == false) goto L129;
        int trackpadSwipe = detectTrackpadThreeFingerSwipe(event);
        if (trackpadSwipe != 0) goto L67;
        boolean r4 = true;
    L68:
        this.mSwipeFireable = r4;
        if (this.mSwipeFireable == true) goto L78;
        if (trackpadSwipe != 1) goto L72;
        this.mCallbacks.onSwipeFromTop();
        return;
    L72:
        if (trackpadSwipe != 2) goto L74;
        this.mCallbacks.onSwipeFromBottom();
        return;
    L74:
        if (trackpadSwipe != 3) goto L76;
        this.mCallbacks.onSwipeFromRight();
        return;
    L76:
        if (trackpadSwipe != 4) goto L133;
        this.mCallbacks.onSwipeFromLeft();
        return;
    L133:
        return;
    L78:
        int swipe = detectSwipe(event);
        if (swipe != 0) goto L81;
        r3 = true;
    L81:
        this.mSwipeFireable = r3;
        if (swipe != 1) goto L84;
        this.mCallbacks.onSwipeFromTop();
    L90:
        if (swipe == 5) goto L92;
        return;
    L92:
        if (this.mCallbacks.onSwipeFromIsland() == true) goto L143;
        this.mCallbacks.onSwipeFromTop();
        return;
    L143:
        return;
    L84:
        if (swipe != 2) goto L86;
        this.mCallbacks.onSwipeFromBottom();
        goto L90
    L86:
        if (swipe != 3) goto L88;
        this.mCallbacks.onSwipeFromRight();
        goto L90
    L88:
        if (swipe != 4) goto L90;
        this.mCallbacks.onSwipeFromLeft();
        goto L90
    L67:
        r4 = false;
        goto L68
    L129:
        return;
    L102:
        this.mSwipeFireable = false;
        this.mDebugFireable = false;
        if (this.mScrollFired == false) goto L105;
        this.mCallbacks.onScroll(false);
    L105:
        this.mScrollFired = false;
        this.mCallbacks.onUpOrCancel();
        return;
    L106:
        this.mInMutiTouch = false;
        this.mSwipeFireable = true;
        this.mDebugFireable = true;
        if (this.mScrollFired == false) goto L109;
        this.mCallbacks.onScroll(false);
    L109:
        this.mScrollFired = false;
        this.mDownPointers = 0;
        captureDown(event, 0);
        if (this.mMouseHoveringAtLeft == false) goto L113;
        this.mMouseHoveringAtLeft = false;
        this.mCallbacks.onMouseLeaveFromLeft();
    L113:
        if (this.mMouseHoveringAtTop == false) goto L116;
        this.mMouseHoveringAtTop = false;
        this.mCallbacks.onMouseLeaveFromTop();
    L116:
        if (this.mMouseHoveringAtRight == false) goto L119;
        this.mMouseHoveringAtRight = false;
        this.mCallbacks.onMouseLeaveFromRight();
    L119:
        if (this.mMouseHoveringAtBottom == false) goto L121;
        this.mMouseHoveringAtBottom = false;
        this.mCallbacks.onMouseLeaveFromBottom();
    L121:
        this.mCallbacks.onDown();
        return;
    L123:
        IBoostTouchUpController controller = SysOptBridge.getFactory().getBoostTouchUpController();     // Catch: Throwable -> L99
        if (controller == null) goto L102;
        controller.onTouchUp();     // Catch: Throwable -> L99
        goto L102
    L136:
        return;
    L11:
        if (event.isFromSource(UsbACInterface.FORMAT_III_IEC1937_MPEG1_Layer1) == false) goto L125;
        float eventX = event.getX();
        float eventY = event.getY();
        if (this.mMouseHoveringAtLeft == true) goto L18;
        if (eventX != 0.0f) goto L18;
        this.mCallbacks.onMouseHoverAtLeft();
        this.mMouseHoveringAtLeft = true;
    L23:
        if (this.mMouseHoveringAtTop == true) goto L28;
        if (eventY != 0.0f) goto L28;
        this.mCallbacks.onMouseHoverAtTop();
        this.mMouseHoveringAtTop = true;
    L33:
        if (this.mMouseHoveringAtRight == true) goto L38;
        if (eventX < (this.screenWidth - 1)) goto L38;
        this.mCallbacks.onMouseHoverAtRight();
        this.mMouseHoveringAtRight = true;
    L43:
        if (this.mMouseHoveringAtBottom == true) goto L48;
        if (eventY < (this.screenHeight - 1)) goto L48;
        this.mCallbacks.onMouseHoverAtBottom();
        this.mMouseHoveringAtBottom = true;
        return;
    L48:
        if (this.mMouseHoveringAtBottom == true) goto L50;
        return;
    L50:
        if (eventY >= (this.screenHeight - 1)) goto L140;
        this.mCallbacks.onMouseLeaveFromBottom();
        this.mMouseHoveringAtBottom = false;
        return;
    L140:
        return;
    L38:
        if (this.mMouseHoveringAtRight == false) goto L43;
        if (eventX >= (this.screenWidth - 1)) goto L43;
        this.mCallbacks.onMouseLeaveFromRight();
        this.mMouseHoveringAtRight = false;
    L28:
        if (this.mMouseHoveringAtTop == false) goto L33;
        if (eventY <= 0.0f) goto L33;
        this.mCallbacks.onMouseLeaveFromTop();
        this.mMouseHoveringAtTop = false;
    L18:
        if (this.mMouseHoveringAtLeft == false) goto L23;
        if (eventX <= 0.0f) goto L23;
        this.mCallbacks.onMouseLeaveFromLeft();
        this.mMouseHoveringAtLeft = false;
        goto L23
    L125:
        return;
    L5:
        if (event.isTouchEvent() == false) goto L7;
        this.mGestureDetector.onTouchEvent(event);
        goto L7
    }

    private void captureDown(MotionEvent event, int pointerIndex) {
        int pointerId = event.getPointerId(pointerIndex);
        int i = findIndex(pointerId);
        if (i == (-1)) goto L6;
        this.mDownX[i] = event.getX(pointerIndex);
        this.mDownY[i] = event.getY(pointerIndex);
        this.mDownTime[i] = event.getEventTime();
        return;
    }

    protected boolean currentGestureStartedInRegion(Region r) {
        return r.contains((int) this.mDownX[0], (int) this.mDownY[0]);
    }

    private int findIndex(int pointerId) {
        int i = 0;
    L4:
        if (i >= this.mDownPointers) goto L9;
        if (this.mDownPointerId[i] == pointerId) goto L7;
        i = i + 1;
        goto L4
    L7:
        return i;
    L9:
        int i2 = this.mDownPointers;
        if (i2 == 32) goto L15;
        if (pointerId == (-1)) goto L15;
        int[] r0 = this.mDownPointerId;
        int r1 = this.mDownPointers;
        this.mDownPointers = r1 + 1;
        r0[r1] = pointerId;
        return this.mDownPointers - 1;
    L15:
        return -1;
    }

    private int detectTrackpadThreeFingerSwipe(MotionEvent move) {
        if (isTrackpadThreeFingerSwipe(move) == true) goto L5;
        return 0;
    L5:
        float dx = move.getX() - this.mDownX[0];
        float dy = move.getY() - this.mDownY[0];
        if (Math.abs(dx) >= Math.abs(dy)) goto L15;
        if (Math.abs(dy) > this.mSwipeDistanceThreshold) goto L10;
    L21:
        return 0;
    L10:
        if (dy <= 0.0f) goto L12;
        return 1;
    L12:
        return 2;
    L15:
        if (Math.abs(dx) <= this.mSwipeDistanceThreshold) goto L21;
        if (dx <= 0.0f) goto L19;
        return 4;
    L19:
        return 3;
    }

    private static boolean isTrackpadThreeFingerSwipe(MotionEvent event) {
        if (event.getClassification() == 4) goto L5;
    L7:
        return false;
    L5:
        if (event.getAxisValue(53) != 3.0f) goto L7;
        return true;
    }

    private int detectSwipe(MotionEvent move) {
        int historySize = move.getHistorySize();
        int pointerCount = move.getPointerCount();
        int p = 0;
    L3:
        if (p >= pointerCount) goto L16;
        int pointerId = move.getPointerId(p);
        int i = findIndex(pointerId);
        if (i == (-1)) goto L15;
        int h = 0;
    L7:
        if (h >= historySize) goto L12;
        long time = move.getHistoricalEventTime(h);
        float x = move.getHistoricalX(p, h);
        float y = move.getHistoricalY(p, h);
        int swipe = detectSwipe(i, time, x, y);
        if (swipe != 0) goto L10;
        h = h + 1;
        goto L7
    L10:
        return swipe;
    L12:
        int swipe2 = detectSwipe(i, move.getEventTime(), move.getX(p), move.getY(p));
        if (swipe2 == 0) goto L15;
        return swipe2;
    L15:
        p = p + 1;
        goto L3
    L16:
        return 0;
    }

    private int detectSwipe(int i, long time, float x, float y) {
        float fromX = this.mDownX[i];
        float fromY = this.mDownY[i];
        long elapsed = time - this.mDownTime[i];
        if (fromY > this.mSwipeStartThreshold.top) goto L20;
        if (y <= (this.mSwipeDistanceThreshold + fromY)) goto L20;
        if (Features.enableSystemGestureOptimization() == false) goto L17;
        if (this.screenWidth < this.screenHeight) goto L17;
        if (this.mInMutiTouch == true) goto L20;
        if (Math.abs(x - fromX) >= (this.mSwipeDistanceThreshold * 2)) goto L20;
        if (y <= ((this.mSwipeDistanceThreshold * 2) + fromY)) goto L20;
    L17:
        if (elapsed >= 500) goto L20;
        return 1;
    L20:
        if (fromY < (this.screenHeight - this.mSwipeStartThreshold.bottom)) goto L39;
        if (y >= (fromY - this.mSwipeDistanceThreshold)) goto L39;
        if (Features.enableSystemGestureOptimization() == false) goto L36;
        if (this.screenWidth < this.screenHeight) goto L36;
        if (Math.abs(x - fromX) >= (this.mSwipeDistanceThreshold * 2)) goto L39;
        if (y >= (fromY - (this.mSwipeDistanceThreshold * 2))) goto L39;
        if (fromX <= ((this.screenWidth * 1) / 4)) goto L39;
        if (fromX >= ((this.screenWidth * 3) / 4)) goto L39;
    L36:
        if (elapsed >= 500) goto L39;
        return 2;
    L39:
        if (fromX < (this.screenWidth - this.mSwipeStartThreshold.right)) goto L61;
        if (x >= (fromX - this.mSwipeDistanceThreshold)) goto L61;
        if (Features.enableSystemGestureOptimization() == false) goto L53;
        if (this.screenWidth < this.screenHeight) goto L53;
        if (this.mInMutiTouch == true) goto L61;
        if (Math.abs(y - fromY) >= (this.mSwipeDistanceThreshold * 2)) goto L61;
        if (x >= (fromX - (this.mSwipeDistanceThreshold * 2))) goto L61;
    L53:
        if (elapsed >= 500) goto L61;
        GameKeysPatch gameKeysPatch = GameKeysPatch.getInstance();
        if (gameKeysPatch != null) goto L57;
    L59:
        return 3;
    L57:
        if (gameKeysPatch.isSwipeNone(this.mContext, this.screenHeight, fromY) == false) goto L59;
        return 0;
    L61:
        if (fromX <= this.mSwipeStartThreshold.left) goto L63;
    L82:
        return 0;
    L63:
        if (x <= (this.mSwipeDistanceThreshold + fromX)) goto L82;
        if (Features.enableSystemGestureOptimization() == false) goto L75;
        if (this.screenWidth < this.screenHeight) goto L75;
        if (this.mInMutiTouch == true) goto L82;
        if (Math.abs(y - fromY) >= (this.mSwipeDistanceThreshold * 2)) goto L82;
        if (x <= ((this.mSwipeDistanceThreshold * 2) + fromX)) goto L82;
    L75:
        if (elapsed >= 500) goto L82;
        GameKeysPatch gameKeysPatch2 = GameKeysPatch.getInstance();
        if (gameKeysPatch2 != null) goto L79;
    L81:
        return 4;
    L79:
        if (gameKeysPatch2.isSwipeNone(this.mContext, this.screenHeight, fromY) == false) goto L81;
        return 0;
    }

    public void dump(PrintWriter pw, String prefix) {
        String inner = prefix + "  ";
        pw.println(prefix + TAG + ":");
        pw.print(inner);
        pw.print("mDisplayCutoutTouchableRegionSize=");
        pw.println(this.mDisplayCutoutTouchableRegionSize);
        pw.print(inner);
        pw.print("mSwipeStartThreshold=");
        pw.println(this.mSwipeStartThreshold);
        pw.print(inner);
        pw.print("mSwipeDistanceThreshold=");
        pw.println(this.mSwipeDistanceThreshold);
    }
}
