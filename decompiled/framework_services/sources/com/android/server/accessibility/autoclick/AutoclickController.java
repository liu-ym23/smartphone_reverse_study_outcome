package com.android.server.accessibility.autoclick;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import android.provider.Settings;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import com.android.server.accessibility.AccessibilityTraceManager;
import com.android.server.accessibility.BaseEventStreamTransformation;
import com.android.server.usb.descriptors.UsbACInterface;

/* JADX INFO: loaded from: classes.dex */
public class AutoclickController extends BaseEventStreamTransformation {
    private static final String LOG_TAG = null;
    private static final float SCROLL_AMOUNT = 1.0f;
    final AutoclickTypePanel.ClickPanelControllerInterface clickPanelController;
    private int mActiveClickType;
    AutoclickIndicatorScheduler mAutoclickIndicatorScheduler;
    AutoclickIndicatorView mAutoclickIndicatorView;
    AutoclickScrollPanel mAutoclickScrollPanel;
    AutoclickSettingsObserver mAutoclickSettingsObserver;
    AutoclickTypePanel mAutoclickTypePanel;
    ClickScheduler mClickScheduler;
    private final Context mContext;
    private int mHoveredDirection;
    float mLastCursorX;
    float mLastCursorY;
    final AutoclickScrollPanel.ScrollPanelControllerInterface mScrollPanelController;
    private final AccessibilityTraceManager mTrace;
    private final int mUserId;
    private WindowManager mWindowManager;

    private final class AutoclickIndicatorScheduler implements Runnable {
        private final Handler mHandler;
        private boolean mIndicatorCallbackActive;
        private long mScheduledShowIndicatorTime;
        final /* synthetic */ AutoclickController this$0;

        public AutoclickIndicatorScheduler(AutoclickController r1, Handler handler) {
            this.this$0 = r1;
            this.mIndicatorCallbackActive = false;
            this.mHandler = handler;
        }

        @Override // java.lang.Runnable
        public void run() {
            long now = SystemClock.uptimeMillis();
            if (now >= this.mScheduledShowIndicatorTime) goto L6;
            this.mHandler.postDelayed(this, this.mScheduledShowIndicatorTime - now);
            return;
        L6:
            this.this$0.mAutoclickIndicatorView.redrawIndicator();
            this.mIndicatorCallbackActive = false;
        }

        public void update() {
            long scheduledShowIndicatorTime = SystemClock.uptimeMillis() + 150;
            if (this.mIndicatorCallbackActive == false) goto L9;
            if (scheduledShowIndicatorTime <= this.mScheduledShowIndicatorTime) goto L9;
            this.mScheduledShowIndicatorTime = scheduledShowIndicatorTime;
            return;
        L9:
            if (this.mIndicatorCallbackActive == false) goto L11;
            this.mHandler.removeCallbacks(this);
        L11:
            this.mIndicatorCallbackActive = true;
            this.mScheduledShowIndicatorTime = scheduledShowIndicatorTime;
            this.mHandler.postDelayed(this, 150);
        }

        public void cancel() {
            if (this.mIndicatorCallbackActive == true) goto L5;
            return;
        L5:
            this.mIndicatorCallbackActive = false;
            this.mScheduledShowIndicatorTime = -1;
            this.mHandler.removeCallbacks(this);
        }

        public void updateCursorAreaSize(int size) {
            this.this$0.mAutoclickIndicatorView.setRadius(size);
        }
    }

    private static final class AutoclickSettingsObserver extends ContentObserver {
        private final Uri mAutoclickCursorAreaSizeSettingUri;
        private final Uri mAutoclickDelaySettingUri;
        private final Uri mAutoclickIgnoreMinorCursorMovementSettingUri;
        private AutoclickIndicatorScheduler mAutoclickIndicatorScheduler;
        private final Uri mAutoclickRevertToLeftClickSettingUri;
        private ClickScheduler mClickScheduler;
        private ContentResolver mContentResolver;
        private final int mUserId;

        public AutoclickSettingsObserver(int userId, Handler handler) {
            super(handler);
            this.mAutoclickDelaySettingUri = Settings.Secure.getUriFor("accessibility_autoclick_delay");
            this.mAutoclickCursorAreaSizeSettingUri = Settings.Secure.getUriFor("accessibility_autoclick_cursor_area_size");
            this.mAutoclickIgnoreMinorCursorMovementSettingUri = Settings.Secure.getUriFor("accessibility_autoclick_ignore_minor_cursor_movement");
            this.mAutoclickRevertToLeftClickSettingUri = Settings.Secure.getUriFor("accessibility_autoclick_revert_to_left_click");
            this.mUserId = userId;
        }

        public void start(ContentResolver contentResolver, ClickScheduler clickScheduler, AutoclickIndicatorScheduler autoclickIndicatorScheduler) {
            if (this.mContentResolver != null) goto L15;
            if (this.mClickScheduler != null) goto L15;
            if (contentResolver == null) goto L13;
            if (clickScheduler == null) goto L11;
            this.mContentResolver = contentResolver;
            this.mClickScheduler = clickScheduler;
            this.mAutoclickIndicatorScheduler = autoclickIndicatorScheduler;
            this.mContentResolver.registerContentObserver(this.mAutoclickDelaySettingUri, false, this, this.mUserId);
            onChange(true, this.mAutoclickDelaySettingUri);
            return;
        L11:
            throw new NullPointerException("clickScheduler not set.");
        L13:
            throw new NullPointerException("contentResolver not set.");
        L15:
            throw new IllegalStateException("Observer already started.");
        }

        public void stop() {
            if (this.mContentResolver == null) goto L9;
            if (this.mClickScheduler == null) goto L9;
            this.mContentResolver.unregisterContentObserver(this);
            return;
        L9:
            throw new IllegalStateException("AutoclickSettingsObserver not started.");
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean selfChange, Uri uri) {
            if (this.mAutoclickDelaySettingUri.equals(uri) == false) goto L7;
            int delay = Settings.Secure.getIntForUser(this.mContentResolver, "accessibility_autoclick_delay", 600, this.mUserId);
            this.mClickScheduler.updateDelay(delay);
            return;
        }
    }

    final class ClickScheduler implements Runnable {
        private static final double DEFAULT_MOVEMENT_SLOP = 20.0d;
        private boolean mActive;
        private MotionEvent.PointerCoords mAnchorCoords;
        private int mDelay;
        private int mEventPolicyFlags;
        private Handler mHandler;
        private boolean mHoveredState;
        private boolean mIgnoreMinorCursorMovement;
        private MotionEvent mLastMotionEvent;
        private int mMetaState;
        private double mMovementSlop;
        private boolean mRevertToLeftClick;
        private long mScheduledClickTime;
        private MotionEvent.PointerCoords[] mTempPointerCoords;
        private MotionEvent.PointerProperties[] mTempPointerProperties;
        final /* synthetic */ AutoclickController this$0;

        /* JADX INFO: renamed from: -$$Nest$fgetmEventPolicyFlags, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m745$$Nest$fgetmEventPolicyFlags(ClickScheduler r0) {
            return r0.mEventPolicyFlags;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmLastMotionEvent, reason: not valid java name */
        static /* bridge */ /* synthetic */ MotionEvent m746$$Nest$fgetmLastMotionEvent(ClickScheduler r0) {
            return r0.mLastMotionEvent;
        }

        public ClickScheduler(AutoclickController this$0, Handler handler, int delay) {
            this.this$0 = this$0;
            this.mMovementSlop = 20.0d;
            this.mIgnoreMinorCursorMovement = false;
            this.mRevertToLeftClick = true;
            this.mHandler = handler;
            this.mLastMotionEvent = null;
            resetInternalState();
            this.mDelay = delay;
            this.mAnchorCoords = new MotionEvent.PointerCoords();
        }

        @Override // java.lang.Runnable
        public void run() {
            long now = SystemClock.uptimeMillis();
            if (now >= this.mScheduledClickTime) goto L6;
            this.mHandler.postDelayed(this, this.mScheduledClickTime - now);
            return;
        L6:
            sendClick();
            resetInternalState();
            resetSelectedClickTypeIfNecessary();
        }

        public void update(MotionEvent event, int policyFlags) {
            this.mMetaState = event.getMetaState();
            boolean moved = detectMovement(event);
            if (this.mLastMotionEvent == null) goto L7;
            if (moved == true) goto L7;
            boolean r1 = false;
        L8:
            cacheLastEvent(event, policyFlags, r1);
            if (moved == false) goto L12;
            rescheduleClick(this.mDelay);
            return;
        L12:
            return;
        L7:
            r1 = true;
            goto L8
        }

        public void cancel() {
            if (this.mActive == true) goto L5;
            return;
        L5:
            resetInternalState();
            this.mHandler.removeCallbacks(this);
        }

        public void updateMetaState(int state) {
            this.mMetaState = state;
        }

        int getMetaStateForTesting() {
            return this.mMetaState;
        }

        boolean getIsActiveForTesting() {
            return this.mActive;
        }

        long getScheduledClickTimeForTesting() {
            return this.mScheduledClickTime;
        }

        public void updateDelay(int delay) {
            this.mDelay = delay;
        }

        int getDelayForTesting() {
            return this.mDelay;
        }

        boolean getRevertToLeftClickForTesting() {
            return this.mRevertToLeftClick;
        }

        private void rescheduleClick(int delay) {
            long clickTime = SystemClock.uptimeMillis() + ((long) delay);
            if (this.mActive == false) goto L9;
            if (clickTime <= this.mScheduledClickTime) goto L9;
            this.mScheduledClickTime = clickTime;
            return;
        L9:
            if (this.mActive == false) goto L11;
            this.mHandler.removeCallbacks(this);
        L11:
            this.mActive = true;
            this.mScheduledClickTime = clickTime;
            this.mHandler.postDelayed(this, delay);
        }

        private void cacheLastEvent(MotionEvent event, int policyFlags, boolean useAsAnchor) {
            if (this.mLastMotionEvent == null) goto L5;
            this.mLastMotionEvent.recycle();
        L5:
            this.mLastMotionEvent = MotionEvent.obtain(event);
            this.mEventPolicyFlags = policyFlags;
            this.mHoveredState = AutoclickController.m743$$Nest$misHovered(this.this$0);
            if (useAsAnchor == false) goto L9;
            int pointerIndex = this.mLastMotionEvent.getActionIndex();
            this.mLastMotionEvent.getPointerCoords(pointerIndex, this.mAnchorCoords);
            return;
        }

        private void resetInternalState() {
            this.mActive = false;
            if (this.mLastMotionEvent == null) goto L5;
            this.mLastMotionEvent.recycle();
            this.mLastMotionEvent = null;
        L5:
            this.mScheduledClickTime = -1;
        }

        private void resetSelectedClickTypeIfNecessary() {
            if (this.mRevertToLeftClick == true) goto L5;
            return;
        L5:
            if (AutoclickController.m737$$Nest$fgetmActiveClickType(this.this$0) == 0) goto L9;
            this.this$0.mAutoclickTypePanel.resetSelectedClickType();
            return;
        }

        private boolean detectMovement(MotionEvent event) {
            if (this.mLastMotionEvent != null) goto L5;
            return false;
        L5:
            int pointerIndex = event.getActionIndex();
            float deltaX = this.mAnchorCoords.x - event.getX(pointerIndex);
            float deltaY = this.mAnchorCoords.y - event.getY(pointerIndex);
            double delta = Math.hypot(deltaX, deltaY);
            if (delta <= 20.0d) goto L9;
            return true;
        L9:
            return false;
        }

        public void setIgnoreMinorCursorMovement(boolean ignoreMinorCursorMovement) {
            this.mIgnoreMinorCursorMovement = ignoreMinorCursorMovement;
        }

        public void setRevertToLeftClick(boolean revertToLeftClick) {
            this.mRevertToLeftClick = revertToLeftClick;
        }

        private void updateMovementSlop(double slop) {
            this.mMovementSlop = slop;
        }

        private void sendClick() {
            if (this.mLastMotionEvent != null) goto L5;
            return;
        L5:
            if (this.this$0.getNext() != null) goto L8;
            return;
        L8:
            if (this.this$0.mAutoclickScrollPanel == null) goto L16;
            if (this.this$0.mAutoclickScrollPanel.isVisible() == false) goto L16;
            if (AutoclickController.m738$$Nest$fgetmHoveredDirection(this.this$0) != 4) goto L16;
            this.this$0.exitScrollMode();
            return;
        L16:
            if (AutoclickController.m737$$Nest$fgetmActiveClickType(this.this$0) == 4) goto L18;
            int pointerIndex = this.mLastMotionEvent.getActionIndex();
            if (this.mTempPointerProperties != null) goto L29;
            this.mTempPointerProperties = new MotionEvent.PointerProperties[1];
            this.mTempPointerProperties[0] = new MotionEvent.PointerProperties();
        L29:
            this.mLastMotionEvent.getPointerProperties(pointerIndex, this.mTempPointerProperties[0]);
            if (this.mTempPointerCoords != null) goto L32;
            this.mTempPointerCoords = new MotionEvent.PointerCoords[1];
            this.mTempPointerCoords[0] = new MotionEvent.PointerCoords();
        L32:
            this.mLastMotionEvent.getPointerCoords(pointerIndex, this.mTempPointerCoords[0]);
            long now = SystemClock.uptimeMillis();
            int actionButton = 1;
            if (this.mHoveredState == false) goto L36;
            actionButton = 1;
        L42:
            sendMotionEvent(actionButton, now);
            return;
        L36:
            switch(AutoclickController.m737$$Nest$fgetmActiveClickType(this.this$0)) {
                case 0: goto L41;
                case 1: goto L40;
                case 2: goto L38;
                default: goto L42;
            };
        L38:
            long doubleTapMinimumTimeout = ViewConfiguration.getDoubleTapMinTime();
            sendMotionEvent(1, now);
            sendMotionEvent(1, now + doubleTapMinimumTimeout);
            return;
        L40:
            actionButton = 2;
            goto L42
        L41:
            actionButton = 1;
            goto L42
        L18:
            if (this.this$0.mAutoclickScrollPanel != null) goto L20;
            return;
        L20:
            if (this.this$0.mClickScheduler != null) goto L22;
        L24:
            this.this$0.mAutoclickScrollPanel.show();
            return;
        L22:
            if (this.this$0.mClickScheduler.mLastMotionEvent == null) goto L24;
            int pointerIndex2 = this.this$0.mClickScheduler.mLastMotionEvent.getActionIndex();
            this.this$0.mLastCursorX = this.this$0.mClickScheduler.mLastMotionEvent.getX(pointerIndex2);
            this.this$0.mLastCursorY = this.this$0.mClickScheduler.mLastMotionEvent.getY(pointerIndex2);
            goto L24
        }

        private void sendMotionEvent(int actionButton, long eventTime) {
            MotionEvent downEvent = MotionEvent.obtain(eventTime, eventTime, 0, 1, this.mTempPointerProperties, this.mTempPointerCoords, this.mMetaState, actionButton, 1.0f, 1.0f, this.mLastMotionEvent.getDeviceId(), 0, this.mLastMotionEvent.getSource(), this.mLastMotionEvent.getFlags());
            MotionEvent pressEvent = MotionEvent.obtain(downEvent);
            pressEvent.setAction(11);
            pressEvent.setActionButton(actionButton);
            MotionEvent releaseEvent = MotionEvent.obtain(downEvent);
            releaseEvent.setAction(12);
            releaseEvent.setActionButton(actionButton);
            releaseEvent.setButtonState(0);
            MotionEvent upEvent = MotionEvent.obtain(downEvent);
            upEvent.setAction(1);
            upEvent.setButtonState(0);
            AutoclickController.access$001(this.this$0, downEvent, downEvent, this.mEventPolicyFlags);
            downEvent.recycle();
            AutoclickController.access$101(this.this$0, pressEvent, pressEvent, this.mEventPolicyFlags);
            pressEvent.recycle();
            AutoclickController.access$201(this.this$0, releaseEvent, releaseEvent, this.mEventPolicyFlags);
            releaseEvent.recycle();
            AutoclickController.access$301(this.this$0, upEvent, upEvent, this.mEventPolicyFlags);
            upEvent.recycle();
        }

        public String toString() {
            return "ClickScheduler: { active=" + this.mActive + ", delay=" + this.mDelay + ", scheduledClickTime=" + this.mScheduledClickTime + ", anchor={x:" + this.mAnchorCoords.x + ", y:" + this.mAnchorCoords.y + "}, metastate=" + this.mMetaState + ", policyFlags=" + this.mEventPolicyFlags + ", lastMotionEvent=" + this.mLastMotionEvent + " }";
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmActiveClickType, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m737$$Nest$fgetmActiveClickType(AutoclickController r0) {
        return r0.mActiveClickType;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHoveredDirection, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m738$$Nest$fgetmHoveredDirection(AutoclickController r0) {
        return r0.mHoveredDirection;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmActiveClickType, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m739$$Nest$fputmActiveClickType(AutoclickController r0, int r1) {
        r0.mActiveClickType = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmHoveredDirection, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m740$$Nest$fputmHoveredDirection(AutoclickController r0, int r1) {
        r0.mHoveredDirection = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$mcancelPendingClick, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m741$$Nest$mcancelPendingClick(AutoclickController r0) {
        r0.cancelPendingClick();
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleScroll, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m742$$Nest$mhandleScroll(AutoclickController r0, int r1) {
        r0.handleScroll(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$misHovered, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m743$$Nest$misHovered(AutoclickController r0) {
        return r0.isHovered();
    }

    /* JADX INFO: renamed from: -$$Nest$misPaused, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m744$$Nest$misPaused(AutoclickController r0) {
        return r0.isPaused();
    }

    static /* synthetic */ void access$001(AutoclickController x0, MotionEvent x1, MotionEvent x2, int x3) {
        super.onMotionEvent(x1, x2, x3);
    }

    static /* synthetic */ void access$101(AutoclickController x0, MotionEvent x1, MotionEvent x2, int x3) {
        super.onMotionEvent(x1, x2, x3);
    }

    static /* synthetic */ void access$201(AutoclickController x0, MotionEvent x1, MotionEvent x2, int x3) {
        super.onMotionEvent(x1, x2, x3);
    }

    static /* synthetic */ void access$301(AutoclickController x0, MotionEvent x1, MotionEvent x2, int x3) {
        super.onMotionEvent(x1, x2, x3);
    }

    static {
        LOG_TAG = AutoclickController.class.getSimpleName();
    }

    public AutoclickController(Context context, int userId, AccessibilityTraceManager trace) {
        this.mActiveClickType = 0;
        this.mHoveredDirection = 5;
        this.clickPanelController = new AnonymousClass1(this);
        this.mScrollPanelController = new AnonymousClass2(this);
        this.mTrace = trace;
        this.mContext = context;
        this.mUserId = userId;
    }

    @Override // com.android.server.accessibility.EventStreamTransformation
    public void onMotionEvent(MotionEvent event, MotionEvent rawEvent, int policyFlags) {
        if (this.mTrace.isA11yTracingEnabledForTypes(4096) == false) goto L6;
        this.mTrace.logTrace(LOG_TAG + ".onMotionEvent", 4096, "event=" + event + ";rawEvent=" + rawEvent + ";policyFlags=" + policyFlags);
    L6:
        if (event.isFromSource(UsbACInterface.FORMAT_III_IEC1937_MPEG1_Layer1) == true) goto L8;
        cancelPendingClick();
    L14:
        super.onMotionEvent(event, rawEvent, policyFlags);
        return;
    L8:
        if (this.mClickScheduler != null) goto L11;
        Handler handler = new Handler(this.mContext.getMainLooper());
        this.mClickScheduler = new ClickScheduler(this, handler, 600);
        this.mAutoclickSettingsObserver = new AutoclickSettingsObserver(this.mUserId, handler);
        this.mAutoclickSettingsObserver.start(this.mContext.getContentResolver(), this.mClickScheduler, this.mAutoclickIndicatorScheduler);
    L11:
        if (isPaused() == true) goto L14;
        handleMouseMotion(event, policyFlags);
        goto L14
    }

    private void initiateAutoclickIndicator(Handler handler) {
        this.mAutoclickIndicatorScheduler = new AutoclickIndicatorScheduler(this, handler);
        this.mAutoclickIndicatorView = new AutoclickIndicatorView(this.mContext);
        this.mWindowManager = (WindowManager) this.mContext.getSystemService(WindowManager.class);
        this.mAutoclickTypePanel = new AutoclickTypePanel(this.mContext, this.mWindowManager, this.mUserId, this.clickPanelController);
        this.mAutoclickScrollPanel = new AutoclickScrollPanel(this.mContext, this.mWindowManager, this.mScrollPanelController);
        this.mAutoclickTypePanel.show();
        this.mWindowManager.addView(this.mAutoclickIndicatorView, this.mAutoclickIndicatorView.getLayoutParams());
    }

    @Override // com.android.server.accessibility.EventStreamTransformation
    public void onKeyEvent(KeyEvent event, int policyFlags) {
        if (this.mTrace.isA11yTracingEnabledForTypes(4096) == false) goto L6;
        this.mTrace.logTrace(LOG_TAG + ".onKeyEvent", 4096, "event=" + event + ";policyFlags=" + policyFlags);
    L6:
        if (this.mClickScheduler != null) goto L8;
    L11:
        super.onKeyEvent(event, policyFlags);
        return;
    L8:
        if (KeyEvent.isModifierKey(event.getKeyCode()) == false) goto L10;
        this.mClickScheduler.updateMetaState(event.getMetaState());
        goto L11
    L10:
        cancelPendingClick();
        goto L11
    }

    @Override // com.android.server.accessibility.EventStreamTransformation
    public void clearEvents(int inputSource) {
        if (inputSource != 8194) goto L6;
        cancelPendingClick();
    L6:
        if (this.mAutoclickScrollPanel == null) goto L8;
        this.mAutoclickScrollPanel.hide();
    L8:
        super.clearEvents(inputSource);
    }

    @Override // com.android.server.accessibility.EventStreamTransformation
    public void onDestroy() {
        if (this.mAutoclickSettingsObserver == null) goto L6;
        this.mAutoclickSettingsObserver.stop();
        this.mAutoclickSettingsObserver = null;
    L6:
        if (this.mClickScheduler == null) goto L9;
        this.mClickScheduler.cancel();
        this.mClickScheduler = null;
    L9:
        if (this.mAutoclickIndicatorScheduler == null) goto L12;
        this.mAutoclickIndicatorScheduler.cancel();
        this.mAutoclickIndicatorScheduler = null;
        this.mWindowManager.removeView(this.mAutoclickIndicatorView);
        this.mAutoclickTypePanel.hide();
    L12:
        if (this.mAutoclickScrollPanel == null) goto L15;
        this.mAutoclickScrollPanel.hide();
        this.mAutoclickScrollPanel = null;
        return;
    }

    private void handleMouseMotion(MotionEvent event, int policyFlags) {
        switch(event.getActionMasked()) {
            case 7: goto L7;
            case 8: goto L4;
            case 9: goto L13;
            case 10: goto L13;
            default: goto L4;
        };
    L4:
        cancelPendingClick();
        return;
    L13:
        return;
    L7:
        if (event.getPointerCount() != 1) goto L9;
        this.mClickScheduler.update(event, policyFlags);
        return;
    L9:
        cancelPendingClick();
    }

    private boolean isPaused() {
        return false;
    }

    private boolean isHovered() {
        return false;
    }

    private void cancelPendingClick() {
        if (this.mClickScheduler == null) goto L6;
        this.mClickScheduler.cancel();
    L6:
        if (this.mAutoclickIndicatorScheduler == null) goto L9;
        this.mAutoclickIndicatorScheduler.cancel();
        return;
    }

    private void handleScroll(int direction) {
        long now = SystemClock.uptimeMillis();
        int r5 = 0;
        MotionEvent.PointerProperties[] pointerProps = {new MotionEvent.PointerProperties()};
        pointerProps[0].id = 0;
        pointerProps[0].toolType = 3;
        MotionEvent.PointerCoords[] pointerCoords = {new MotionEvent.PointerCoords()};
        pointerCoords[0].x = this.mLastCursorX;
        pointerCoords[0].y = this.mLastCursorY;
        switch(direction) {
            case 0: goto L8;
            case 1: goto L7;
            case 2: goto L6;
            case 3: goto L5;
            default: goto L4;
        };
    L4:
        return;
    L5:
        pointerCoords[0].setAxisValue(10, -1.0f);
    L10:
        if (this.mClickScheduler != null) goto L12;
    L14:
        int deviceId = r5;
        MotionEvent scrollEvent = MotionEvent.obtain(now, now, 8, 1, pointerProps, pointerCoords, 0, 0, 1.0f, 1.0f, deviceId, 0, UsbACInterface.FORMAT_III_IEC1937_MPEG1_Layer1, 0);
        super.onMotionEvent(scrollEvent, scrollEvent, ClickScheduler.m745$$Nest$fgetmEventPolicyFlags(this.mClickScheduler));
        scrollEvent.recycle();
        return;
    L12:
        if (ClickScheduler.m746$$Nest$fgetmLastMotionEvent(this.mClickScheduler) == null) goto L14;
        r5 = ClickScheduler.m746$$Nest$fgetmLastMotionEvent(this.mClickScheduler).getDeviceId();
        goto L14
    L6:
        pointerCoords[0].setAxisValue(10, 1.0f);
        goto L10
    L7:
        pointerCoords[0].setAxisValue(9, -1.0f);
        goto L10
    L8:
        pointerCoords[0].setAxisValue(9, 1.0f);
        goto L10
    }

    public void exitScrollMode() {
        if (this.mAutoclickScrollPanel == null) goto L6;
        this.mAutoclickScrollPanel.hide();
        return;
    }

    void onChangeForTesting(boolean selfChange, Uri uri) {
        this.mAutoclickSettingsObserver.onChange(selfChange, uri);
    }
}
