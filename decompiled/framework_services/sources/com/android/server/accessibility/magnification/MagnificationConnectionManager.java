package com.android.server.accessibility.magnification;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.Region;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import android.os.UserHandle;
import android.util.MathUtils;
import android.util.Slog;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.view.MotionEvent;
import android.view.accessibility.IMagnificationConnection;
import android.view.accessibility.IMagnificationConnectionCallback;
import android.view.accessibility.MagnificationAnimationCallback;
import com.android.internal.accessibility.util.AccessibilityStatsLogUtils;
import com.android.server.LocalServices;
import com.android.server.accessibility.AccessibilityTraceManager;
import com.android.server.pm.UserManagerInternal;
import com.android.server.statusbar.StatusBarManagerInternal;
import com.android.server.wm.WindowManagerInternal;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;

/* JADX INFO: loaded from: classes.dex */
public class MagnificationConnectionManager implements PanningScalingHandler.MagnificationDelegate, WindowManagerInternal.AccessibilityControllerInternal.UiChangesForAccessibilityCallbacks {
    private static final int CONNECTED = 1;
    private static final int CONNECTING = 0;
    private static final boolean DBG = false;
    private static final int DISCONNECTED = 3;
    private static final int DISCONNECTING = 2;
    private static final String TAG = "MagnificationConnectionManager";
    private static final int WAIT_CONNECTION_TIMEOUT_MILLIS = 0;
    public static final int WINDOW_POSITION_AT_CENTER = 0;
    public static final int WINDOW_POSITION_AT_TOP_LEFT = 1;
    private final Callback mCallback;
    private ConnectionCallback mConnectionCallback;
    private int mConnectionState;
    MagnificationConnectionWrapper mConnectionWrapper;
    private final Context mContext;
    private final SparseBooleanArray mIsImeVisibleArray;
    private final SparseArray<Float> mLastActivatedScale;
    private final Object mLock;
    private boolean mMagnificationFollowTypingEnabled;
    private boolean mReceiverRegistered;
    private final MagnificationScaleProvider mScaleProvider;
    protected final BroadcastReceiver mScreenStateReceiver;
    private final AccessibilityTraceManager mTrace;
    private final UserManagerInternal mUserManagerInternal;
    private SparseArray<WindowMagnifier> mWindowMagnifiers;

    public interface Callback {
        void onAccessibilityActionPerformed(int r1);

        void onChangeMagnificationMode(int r1, int r2);

        void onPerformScaleAction(int r1, float r2, boolean r3);

        void onSourceBoundsChanged(int r1, Rect r2);

        void onWindowMagnificationActivationState(int r1, boolean r2);
    }

    private class ConnectionCallback extends IMagnificationConnectionCallback.Stub implements IBinder.DeathRecipient {
        private boolean mExpiredDeathRecipient;
        final /* synthetic */ MagnificationConnectionManager this$0;

        /* JADX INFO: renamed from: -$$Nest$fputmExpiredDeathRecipient, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m841$$Nest$fputmExpiredDeathRecipient(ConnectionCallback r0, boolean r1) {
            r0.mExpiredDeathRecipient = r1;
        }

        /* synthetic */ ConnectionCallback(MagnificationConnectionManager r1, MagnificationConnectionManagerIA r2) {
            this(r1);
        }

        private ConnectionCallback(MagnificationConnectionManager r1) {
            this.this$0 = r1;
            this.mExpiredDeathRecipient = false;
        }

        public void onWindowMagnifierBoundsChanged(int displayId, Rect bounds) {
            if (MagnificationConnectionManager.m831$$Nest$fgetmTrace(this.this$0).isA11yTracingEnabledForTypes(256) == false) goto L5;
            MagnificationConnectionManager.m831$$Nest$fgetmTrace(this.this$0).logTrace("MagnificationConnectionManagerConnectionCallback.onWindowMagnifierBoundsChanged", 256, "displayId=" + displayId + ";bounds=" + bounds);
        L5:
            Object r0 = MagnificationConnectionManager.m830$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            WindowMagnifier magnifier = (WindowMagnifier) MagnificationConnectionManager.m832$$Nest$fgetmWindowMagnifiers(this.this$0).get(displayId);     // Catch: Throwable -> L10
            if (magnifier != null) goto L12;
            magnifier = MagnificationConnectionManager.m834$$Nest$mcreateWindowMagnifier(this.this$0, displayId);     // Catch: Throwable -> L10
        L12:
            magnifier.setMagnifierLocation(bounds);     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            throw th;
        }

        public void onChangeMagnificationMode(int displayId, int magnificationMode) throws RemoteException {
            if (MagnificationConnectionManager.m831$$Nest$fgetmTrace(this.this$0).isA11yTracingEnabledForTypes(256) == false) goto L5;
            MagnificationConnectionManager.m831$$Nest$fgetmTrace(this.this$0).logTrace("MagnificationConnectionManagerConnectionCallback.onChangeMagnificationMode", 256, "displayId=" + displayId + ";mode=" + magnificationMode);
        L5:
            MagnificationConnectionManager.m829$$Nest$fgetmCallback(this.this$0).onChangeMagnificationMode(displayId, magnificationMode);
        }

        public void onSourceBoundsChanged(int displayId, Rect sourceBounds) {
            if (MagnificationConnectionManager.m831$$Nest$fgetmTrace(this.this$0).isA11yTracingEnabledForTypes(256) == false) goto L5;
            MagnificationConnectionManager.m831$$Nest$fgetmTrace(this.this$0).logTrace("MagnificationConnectionManagerConnectionCallback.onSourceBoundsChanged", 256, "displayId=" + displayId + ";source=" + sourceBounds);
        L5:
            Object r0 = MagnificationConnectionManager.m830$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            WindowMagnifier magnifier = (WindowMagnifier) MagnificationConnectionManager.m832$$Nest$fgetmWindowMagnifiers(this.this$0).get(displayId);     // Catch: Throwable -> L10
            if (magnifier != null) goto L12;
            magnifier = MagnificationConnectionManager.m834$$Nest$mcreateWindowMagnifier(this.this$0, displayId);     // Catch: Throwable -> L10
        L12:
            magnifier.onSourceBoundsChanged(sourceBounds);     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            MagnificationConnectionManager.m829$$Nest$fgetmCallback(this.this$0).onSourceBoundsChanged(displayId, sourceBounds);
            return;
        L10:
            th = move-exception;
            throw th;
        }

        public void onPerformScaleAction(int displayId, float scale, boolean updatePersistence) {
            if (MagnificationConnectionManager.m831$$Nest$fgetmTrace(this.this$0).isA11yTracingEnabledForTypes(256) == false) goto L5;
            MagnificationConnectionManager.m831$$Nest$fgetmTrace(this.this$0).logTrace("MagnificationConnectionManagerConnectionCallback.onPerformScaleAction", 256, "displayId=" + displayId + ";scale=" + scale + ";updatePersistence=" + updatePersistence);
        L5:
            MagnificationConnectionManager.m829$$Nest$fgetmCallback(this.this$0).onPerformScaleAction(displayId, scale, updatePersistence);
        }

        public void onAccessibilityActionPerformed(int displayId) {
            if (MagnificationConnectionManager.m831$$Nest$fgetmTrace(this.this$0).isA11yTracingEnabledForTypes(256) == false) goto L5;
            MagnificationConnectionManager.m831$$Nest$fgetmTrace(this.this$0).logTrace("MagnificationConnectionManagerConnectionCallback.onAccessibilityActionPerformed", 256, "displayId=" + displayId);
        L5:
            MagnificationConnectionManager.m829$$Nest$fgetmCallback(this.this$0).onAccessibilityActionPerformed(displayId);
        }

        public void onMove(int displayId) {
            if (MagnificationConnectionManager.m831$$Nest$fgetmTrace(this.this$0).isA11yTracingEnabledForTypes(256) == false) goto L5;
            MagnificationConnectionManager.m831$$Nest$fgetmTrace(this.this$0).logTrace("MagnificationConnectionManagerConnectionCallback.onMove", 256, "displayId=" + displayId);
        L5:
            this.this$0.setTrackingTypingFocusEnabled(displayId, false);
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            Object r0 = MagnificationConnectionManager.m830$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            Slog.w(MagnificationConnectionManager.TAG, "binderDied DeathRecipient :" + this.mExpiredDeathRecipient);     // Catch: Throwable -> L8
            if (this.mExpiredDeathRecipient == false) goto L10;
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L10:
            this.this$0.mConnectionWrapper.unlinkToDeath(this);     // Catch: Throwable -> L8
            this.this$0.mConnectionWrapper = null;     // Catch: Throwable -> L8
            MagnificationConnectionManager.m833$$Nest$fputmConnectionCallback(this.this$0, null);     // Catch: Throwable -> L8
            MagnificationConnectionManager.m839$$Nest$msetConnectionState(this.this$0, 3);     // Catch: Throwable -> L8
            MagnificationConnectionManager.m838$$Nest$mresetWindowMagnifiers(this.this$0);     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            throw th;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    private @interface ConnectionState {
    }

    private static class WindowMagnifier {
        private static final AtomicLongFieldUpdater<WindowMagnifier> SUM_TIME_UPDATER = null;
        private final Rect mBounds;
        private final int mDisplayId;
        private boolean mEnabled;
        private int mIdOfLastServiceToControl;
        private final MagnificationConnectionManager mMagnificationConnectionManager;
        private final PointF mMagnificationFrameOffsetRatio;
        private float mScale;
        private final Rect mSourceBounds;
        private boolean mTrackingTypingFocusEnabled;
        private volatile long mTrackingTypingFocusStartTime;
        private volatile long mTrackingTypingFocusSumTime;

        /* JADX INFO: renamed from: -$$Nest$fgetmEnabled, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m842$$Nest$fgetmEnabled(WindowMagnifier r0) {
            return r0.mEnabled;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmIdOfLastServiceToControl, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m843$$Nest$fgetmIdOfLastServiceToControl(WindowMagnifier r0) {
            return r0.mIdOfLastServiceToControl;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmSourceBounds, reason: not valid java name */
        static /* bridge */ /* synthetic */ Rect m844$$Nest$fgetmSourceBounds(WindowMagnifier r0) {
            return r0.mSourceBounds;
        }

        static {
            SUM_TIME_UPDATER = AtomicLongFieldUpdater.newUpdater(WindowMagnifier.class, "mTrackingTypingFocusSumTime");
        }

        WindowMagnifier(int displayId, MagnificationConnectionManager magnificationConnectionManager) {
            this.mScale = 1.0f;
            this.mBounds = new Rect();
            this.mSourceBounds = new Rect();
            this.mIdOfLastServiceToControl = -1;
            this.mMagnificationFrameOffsetRatio = new PointF(0.0f, 0.0f);
            this.mTrackingTypingFocusEnabled = true;
            this.mTrackingTypingFocusStartTime = 0;
            this.mTrackingTypingFocusSumTime = 0;
            this.mDisplayId = displayId;
            this.mMagnificationConnectionManager = magnificationConnectionManager;
        }

        boolean enableWindowMagnificationInternal(float scale, float centerX, float centerY, MagnificationAnimationCallback animationCallback, int windowPosition, int id) {
            if (Float.isNaN(scale) == false) goto L5;
            scale = getScale();
        L5:
            float normScale = MagnificationScaleProvider.constrainScale(scale);
            setMagnificationFrameOffsetRatioByWindowPosition(windowPosition);
            if (MagnificationConnectionManager.m836$$Nest$menableWindowMagnificationInternal(this.mMagnificationConnectionManager, this.mDisplayId, normScale, centerX, centerY, this.mMagnificationFrameOffsetRatio.x, this.mMagnificationFrameOffsetRatio.y, animationCallback) == false) goto L9;
            this.mScale = normScale;
            this.mEnabled = true;
            this.mIdOfLastServiceToControl = id;
            return true;
        L9:
            return false;
        }

        void setMagnificationFrameOffsetRatioByWindowPosition(int windowPosition) {
            switch(windowPosition) {
                case 0: goto L5;
                case 1: goto L4;
                default: goto L8;
            };
        L4:
            this.mMagnificationFrameOffsetRatio.set(-1.0f, -1.0f);
            return;
        L5:
            this.mMagnificationFrameOffsetRatio.set(0.0f, 0.0f);
            return;
        }

        boolean disableWindowMagnificationInternal(MagnificationAnimationCallback animationResultCallback) {
            if (this.mEnabled == true) goto L6;
            return false;
        L6:
            if (MagnificationConnectionManager.m835$$Nest$mdisableWindowMagnificationInternal(this.mMagnificationConnectionManager, this.mDisplayId, animationResultCallback) == false) goto L9;
            this.mEnabled = false;
            this.mIdOfLastServiceToControl = -1;
            this.mTrackingTypingFocusEnabled = false;
            pauseTrackingTypingFocusRecord();
            return true;
        L9:
            return false;
        }

        void setScale(float scale) {
            if (this.mEnabled == true) goto L5;
            return;
        L5:
            float normScale = MagnificationScaleProvider.constrainScale(scale);
            if (Float.compare(this.mScale, normScale) != 0) goto L8;
            return;
        L8:
            if (MagnificationConnectionManager.m840$$Nest$msetScaleForWindowMagnificationInternal(this.mMagnificationConnectionManager, this.mDisplayId, scale) == false) goto L12;
            this.mScale = normScale;
            return;
        }

        float getScale() {
            return this.mScale;
        }

        void setMagnifierLocation(Rect rect) {
            this.mBounds.set(rect);
        }

        int getIdOfLastServiceToControl() {
            return this.mIdOfLastServiceToControl;
        }

        int pointersInWindow(MotionEvent motionEvent) {
            int count = 0;
            int pointerCount = motionEvent.getPointerCount();
            int i = 0;
        L3:
            if (i >= pointerCount) goto L9;
            float x = motionEvent.getX(i);
            float y = motionEvent.getY(i);
            if (this.mBounds.contains((int) x, (int) y) == false) goto L7;
            count = count + 1;
        L7:
            i = i + 1;
            goto L3
        L9:
            return count;
        }

        boolean isPositionInSourceBounds(float x, float y) {
            return this.mSourceBounds.contains((int) x, (int) y);
        }

        void setTrackingTypingFocusEnabled(boolean trackingTypingFocusEnabled) {
            if (this.mMagnificationConnectionManager.isWindowMagnifierEnabled(this.mDisplayId) == false) goto L9;
            if (this.mMagnificationConnectionManager.isImeVisible(this.mDisplayId) == false) goto L9;
            if (trackingTypingFocusEnabled == false) goto L9;
            startTrackingTypingFocusRecord();
        L9:
            if (this.mTrackingTypingFocusEnabled == false) goto L12;
            if (trackingTypingFocusEnabled == true) goto L12;
            stopAndLogTrackingTypingFocusRecordIfNeeded();
        L12:
            this.mTrackingTypingFocusEnabled = trackingTypingFocusEnabled;
        }

        boolean isTrackingTypingFocusEnabled() {
            return this.mTrackingTypingFocusEnabled;
        }

        void startTrackingTypingFocusRecord() {
            if (this.mTrackingTypingFocusStartTime != 0) goto L6;
            this.mTrackingTypingFocusStartTime = SystemClock.uptimeMillis();
            return;
        }

        void pauseTrackingTypingFocusRecord() {
            if (this.mTrackingTypingFocusStartTime == 0) goto L6;
            long elapsed = SystemClock.uptimeMillis() - this.mTrackingTypingFocusStartTime;
            SUM_TIME_UPDATER.addAndGet(this, elapsed);
            this.mTrackingTypingFocusStartTime = 0;
            return;
        }

        void stopAndLogTrackingTypingFocusRecordIfNeeded() {
            if (this.mTrackingTypingFocusStartTime != 0) goto L7;
            if (this.mTrackingTypingFocusSumTime != 0) goto L7;
            return;
        L7:
            if (this.mTrackingTypingFocusStartTime == 0) goto L9;
            long elapsed = SystemClock.uptimeMillis() - this.mTrackingTypingFocusStartTime;
        L10:
            long duration = this.mTrackingTypingFocusSumTime + elapsed;
            this.mMagnificationConnectionManager.logTrackingTypingFocus(duration);
            this.mTrackingTypingFocusStartTime = 0;
            this.mTrackingTypingFocusSumTime = 0;
            return;
        L9:
            elapsed = 0;
            goto L10
        }

        boolean isEnabled() {
            return this.mEnabled;
        }

        void move(float offsetX, float offsetY) {
            MagnificationConnectionManager.m837$$Nest$mmoveWindowMagnifierInternal(this.mMagnificationConnectionManager, this.mDisplayId, offsetX, offsetY);
        }

        void reset() {
            this.mEnabled = false;
            this.mIdOfLastServiceToControl = -1;
            this.mSourceBounds.setEmpty();
        }

        public void onSourceBoundsChanged(Rect sourceBounds) {
            this.mSourceBounds.set(sourceBounds);
        }

        float getCenterX() {
            return this.mSourceBounds.exactCenterX();
        }

        float getCenterY() {
            return this.mSourceBounds.exactCenterY();
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface WindowPosition {
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCallback, reason: not valid java name */
    static /* bridge */ /* synthetic */ Callback m829$$Nest$fgetmCallback(MagnificationConnectionManager r0) {
        return r0.mCallback;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m830$$Nest$fgetmLock(MagnificationConnectionManager r0) {
        return r0.mLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmTrace, reason: not valid java name */
    static /* bridge */ /* synthetic */ AccessibilityTraceManager m831$$Nest$fgetmTrace(MagnificationConnectionManager r0) {
        return r0.mTrace;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmWindowMagnifiers, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseArray m832$$Nest$fgetmWindowMagnifiers(MagnificationConnectionManager r0) {
        return r0.mWindowMagnifiers;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmConnectionCallback, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m833$$Nest$fputmConnectionCallback(MagnificationConnectionManager r0, ConnectionCallback r1) {
        r0.mConnectionCallback = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$mcreateWindowMagnifier, reason: not valid java name */
    static /* bridge */ /* synthetic */ WindowMagnifier m834$$Nest$mcreateWindowMagnifier(MagnificationConnectionManager r0, int r1) {
        return r0.createWindowMagnifier(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mdisableWindowMagnificationInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m835$$Nest$mdisableWindowMagnificationInternal(MagnificationConnectionManager r0, int r1, MagnificationAnimationCallback r2) {
        return r0.disableWindowMagnificationInternal(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$menableWindowMagnificationInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m836$$Nest$menableWindowMagnificationInternal(MagnificationConnectionManager r0, int r1, float r2, float r3, float r4, float r5, float r6, MagnificationAnimationCallback r7) {
        return r0.enableWindowMagnificationInternal(r1, r2, r3, r4, r5, r6, r7);
    }

    /* JADX INFO: renamed from: -$$Nest$mmoveWindowMagnifierInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m837$$Nest$mmoveWindowMagnifierInternal(MagnificationConnectionManager r0, int r1, float r2, float r3) {
        return r0.moveWindowMagnifierInternal(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mresetWindowMagnifiers, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m838$$Nest$mresetWindowMagnifiers(MagnificationConnectionManager r0) {
        r0.resetWindowMagnifiers();
    }

    /* JADX INFO: renamed from: -$$Nest$msetConnectionState, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m839$$Nest$msetConnectionState(MagnificationConnectionManager r0, int r1) {
        r0.setConnectionState(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$msetScaleForWindowMagnificationInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m840$$Nest$msetScaleForWindowMagnificationInternal(MagnificationConnectionManager r0, int r1, float r2) {
        return r0.setScaleForWindowMagnificationInternal(r1, r2);
    }

    private static String connectionStateToString(int state) {
        switch(state) {
            case 0: goto L11;
            case 1: goto L9;
            case 2: goto L7;
            case 3: goto L5;
            default: goto L4;
        };
    L5:
        return "DISCONNECTED";
    L7:
        return "DISCONNECTING";
    L9:
        return "CONNECTED";
    L11:
        return "CONNECTING";
    L4:
        return "UNKNOWN:" + state;
    }

    static {
        WAIT_CONNECTION_TIMEOUT_MILLIS = Build.HW_TIMEOUT_MULTIPLIER * 200;
    }

    public MagnificationConnectionManager(Context context, Object lock, Callback callback, AccessibilityTraceManager trace, MagnificationScaleProvider scaleProvider) {
        this.mConnectionState = 3;
        this.mWindowMagnifiers = new SparseArray();
        this.mMagnificationFollowTypingEnabled = true;
        this.mIsImeVisibleArray = new SparseBooleanArray();
        this.mLastActivatedScale = new SparseArray();
        this.mReceiverRegistered = false;
        this.mScreenStateReceiver = new AnonymousClass1(this);
        this.mContext = context;
        this.mLock = lock;
        this.mCallback = callback;
        this.mTrace = trace;
        this.mScaleProvider = scaleProvider;
        this.mUserManagerInternal = (UserManagerInternal) LocalServices.getService(UserManagerInternal.class);
    }

    public void setConnection(IMagnificationConnection connection) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        MagnificationConnectionManagerIA r4 = null;
        if (this.mConnectionWrapper == null) goto L14;
        this.mConnectionWrapper.setConnectionCallback(null);     // Catch: Throwable -> L9
        if (this.mConnectionCallback == null) goto L11;
        ConnectionCallback.m841$$Nest$fputmExpiredDeathRecipient(this.mConnectionCallback, true);     // Catch: Throwable -> L9
    L11:
        this.mConnectionWrapper.unlinkToDeath(this.mConnectionCallback);     // Catch: Throwable -> L9
        this.mConnectionWrapper = null;     // Catch: Throwable -> L9
        if (this.mConnectionState == 0) goto L14;
        setConnectionState(3);     // Catch: Throwable -> L9
    L14:
        if (connection == null) goto L33;
        this.mConnectionWrapper = new MagnificationConnectionWrapper(connection, this.mTrace);     // Catch: Throwable -> L9
    L33:
        if (this.mConnectionWrapper != null) goto L36;
    L29:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L36:
        this.mConnectionCallback = new ConnectionCallback(this, r4);     // Catch: Throwable -> L22 RemoteException -> L24
        this.mConnectionWrapper.linkToDeath(this.mConnectionCallback);     // Catch: Throwable -> L22 RemoteException -> L24
        this.mConnectionWrapper.setConnectionCallback(this.mConnectionCallback);     // Catch: Throwable -> L22 RemoteException -> L24
        setConnectionState(1);     // Catch: Throwable -> L22 RemoteException -> L24
        Object r1 = this.mLock;     // Catch: Throwable -> L9
    L20:
        r1.notify();     // Catch: Throwable -> L9
    L24:
        e = move-exception;
        Slog.e(TAG, "setConnection failed", e);     // Catch: Throwable -> L22
        this.mConnectionWrapper = null;     // Catch: Throwable -> L22
        setConnectionState(3);     // Catch: Throwable -> L22
        r1 = this.mLock;     // Catch: Throwable -> L9
    L22:
        th = move-exception;
        this.mLock.notify();     // Catch: Throwable -> L9
        throw th;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    public boolean isConnected() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.mConnectionWrapper == null) goto L7;
        boolean r1 = true;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r1;
    L7:
        r1 = false;
        goto L8
    }

    public boolean requestConnection(boolean connect) {
        int callingUserId = UserHandle.getCallingUserId();
        if (this.mUserManagerInternal.isVisibleBackgroundFullUser(callingUserId) == true) goto L48;
        if (this.mTrace.isA11yTracingEnabledForTypes(128) == false) goto L7;
        this.mTrace.logTrace("MagnificationConnectionManager.requestMagnificationConnection", 128, "connect=" + connect);
    L7:
        Object r1 = this.mLock;
        monitor-enter(r1);
        int r3 = 0;
        if (connect == false) goto L19;
    L16:
        th = move-exception;
        throw th;
    L12:
        if (this.mConnectionState != 1) goto L14;
    L24:
        Slog.w(TAG, "requestConnection duplicated request: connect=" + connect + ", mConnectionState=" + connectionStateToString(this.mConnectionState));     // Catch: Throwable -> L16
        monitor-exit(r1);     // Catch: Throwable -> L16
        return false;
    L14:
        if (this.mConnectionState == 0) goto L24;
    L19:
        if (connect == false) goto L21;
    L27:
        if (connect == false) goto L32;
        IntentFilter intentFilter = new IntentFilter("android.intent.action.SCREEN_OFF");     // Catch: Throwable -> L16
        if (this.mReceiverRegistered == true) goto L35;
        this.mContext.registerReceiver(this.mScreenStateReceiver, intentFilter);     // Catch: Throwable -> L16
        this.mReceiverRegistered = true;     // Catch: Throwable -> L16
    L35:
        monitor-exit(r1);     // Catch: Throwable -> L16
        if (requestConnectionInternal(connect) == false) goto L43;
        if (connect == true) goto L41;
        r3 = 2;
    L41:
        setConnectionState(r3);
        return true;
    L43:
        setConnectionState(3);
        return false;
    L32:
        disableAllWindowMagnifiers();     // Catch: Throwable -> L16
        if (this.mReceiverRegistered == false) goto L35;
        this.mContext.unregisterReceiver(this.mScreenStateReceiver);     // Catch: Throwable -> L16
        this.mReceiverRegistered = false;     // Catch: Throwable -> L16
        goto L35
    L21:
        if (this.mConnectionState == 3) goto L24;
        if (this.mConnectionState != 2) goto L27;
    L48:
        throw new SecurityException("Visible background user(u" + callingUserId + " is not permitted to request magnification connection.");
    }

    private boolean requestConnectionInternal(boolean connect) {
        long identity = Binder.clearCallingIdentity();
        StatusBarManagerInternal service = (StatusBarManagerInternal) LocalServices.getService(StatusBarManagerInternal.class);     // Catch: Throwable -> L8
        if (service == null) goto L10;
        boolean r3 = service.requestMagnificationConnection(connect);     // Catch: Throwable -> L8
        Binder.restoreCallingIdentity(identity);
        return r3;
    L10:
        Binder.restoreCallingIdentity(identity);
        return false;
    L8:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }

    public String getConnectionState() {
        return connectionStateToString(this.mConnectionState);
    }

    private void setConnectionState(int state) {
        this.mConnectionState = state;
    }

    void disableAllWindowMagnifiers() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int i = 0;
    L15:
    L8:
        th = move-exception;
        throw th;
    L6:
        if (i >= this.mWindowMagnifiers.size()) goto L10;
        WindowMagnifier magnifier = this.mWindowMagnifiers.valueAt(i);     // Catch: Throwable -> L8
        magnifier.disableWindowMagnificationInternal(null);     // Catch: Throwable -> L8
        i = i + 1;     // Catch: Throwable -> L8
        goto L15
    L10:
        this.mWindowMagnifiers.clear();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
    }

    public void resetAllIfNeeded(int connectionId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int i = 0;
    L22:
    L14:
        th = move-exception;
        throw th;
    L6:
        if (i >= this.mWindowMagnifiers.size()) goto L18;
        WindowMagnifier magnifier = this.mWindowMagnifiers.valueAt(i);     // Catch: Throwable -> L14
        if (magnifier == null) goto L16;
        if (WindowMagnifier.m842$$Nest$fgetmEnabled(magnifier) == false) goto L16;
        if (connectionId != magnifier.getIdOfLastServiceToControl()) goto L16;
        magnifier.disableWindowMagnificationInternal(null);     // Catch: Throwable -> L14
    L16:
        i = i + 1;     // Catch: Throwable -> L14
        goto L22
    L18:
        monitor-exit(r0);     // Catch: Throwable -> L14
    }

    private void resetWindowMagnifiers() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int i = 0;
    L15:
    L8:
        th = move-exception;
        throw th;
    L6:
        if (i >= this.mWindowMagnifiers.size()) goto L11;
        WindowMagnifier magnifier = this.mWindowMagnifiers.valueAt(i);     // Catch: Throwable -> L8
        magnifier.reset();     // Catch: Throwable -> L8
        i = i + 1;     // Catch: Throwable -> L8
        goto L15
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L8
    }

    @Override // com.android.server.wm.WindowManagerInternal.AccessibilityControllerInternal.UiChangesForAccessibilityCallbacks
    public void onRectangleOnScreenRequested(int displayId, int left, int top, int right, int bottom) {
        if (this.mMagnificationFollowTypingEnabled == true) goto L5;
        return;
    L5:
        float toCenterX = (left + right) / 2.0f;
        float toCenterY = (top + bottom) / 2.0f;
        Object r1 = this.mLock;
        monitor-enter(r1);
    L14:
        th = move-exception;
        throw th;
    L8:
        if (this.mIsImeVisibleArray.get(displayId, false) == true) goto L10;
    L16:
        monitor-exit(r1);     // Catch: Throwable -> L14
        return;
    L10:
        if (isPositionInSourceBounds(displayId, toCenterX, toCenterY) == true) goto L16;
        if (isTrackingTypingFocusEnabled(displayId) == false) goto L16;
        moveWindowMagnifierToPositionInternal(displayId, toCenterX, toCenterY, MagnificationAnimationCallback.STUB_ANIMATION_CALLBACK);     // Catch: Throwable -> L14
        goto L16
    }

    void setMagnificationFollowTypingEnabled(boolean enabled) {
        this.mMagnificationFollowTypingEnabled = enabled;
    }

    boolean isMagnificationFollowTypingEnabled() {
        return this.mMagnificationFollowTypingEnabled;
    }

    public int getIdOfLastServiceToMagnify(int displayId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        WindowMagnifier magnifier = this.mWindowMagnifiers.get(displayId);     // Catch: Throwable -> L9
        if (magnifier == null) goto L12;
        int r2 = WindowMagnifier.m843$$Nest$fgetmIdOfLastServiceToControl(magnifier);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return -1;
    L9:
        th = move-exception;
        throw th;
    }

    void setTrackingTypingFocusEnabled(int displayId, boolean trackingTypingFocusEnabled) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        WindowMagnifier magnifier = this.mWindowMagnifiers.get(displayId);     // Catch: Throwable -> L8
        if (magnifier != null) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        magnifier.setTrackingTypingFocusEnabled(trackingTypingFocusEnabled);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private void enableAllTrackingTypingFocus() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int i = 0;
    L15:
    L8:
        th = move-exception;
        throw th;
    L6:
        if (i >= this.mWindowMagnifiers.size()) goto L11;
        WindowMagnifier magnifier = this.mWindowMagnifiers.valueAt(i);     // Catch: Throwable -> L8
        magnifier.setTrackingTypingFocusEnabled(true);     // Catch: Throwable -> L8
        i = i + 1;     // Catch: Throwable -> L8
        goto L15
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L8
    }

    private void pauseTrackingTypingFocusRecord(int displayId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        WindowMagnifier magnifier = this.mWindowMagnifiers.get(displayId);     // Catch: Throwable -> L8
        if (magnifier != null) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L8
        magnifier.pauseTrackingTypingFocusRecord();
        return;
    L8:
        th = move-exception;
        throw th;
    }

    void onImeWindowVisibilityChanged(int displayId, boolean shown) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mIsImeVisibleArray.put(displayId, shown);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        if (shown == false) goto L8;
        enableAllTrackingTypingFocus();
        return;
    L8:
        pauseTrackingTypingFocusRecord(displayId);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    boolean isImeVisible(int displayId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r1 = this.mIsImeVisibleArray.get(displayId);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    void logTrackingTypingFocus(long duration) {
        AccessibilityStatsLogUtils.logMagnificationFollowTypingFocusSession(duration);
    }

    @Override // com.android.server.accessibility.magnification.PanningScalingHandler.MagnificationDelegate
    public boolean processScroll(int displayId, float distanceX, float distanceY) {
        moveWindowMagnification(displayId, -distanceX, -distanceY);
        setTrackingTypingFocusEnabled(displayId, false);
        return true;
    }

    @Override // com.android.server.accessibility.magnification.PanningScalingHandler.MagnificationDelegate
    public void setScale(int displayId, float scale) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        WindowMagnifier magnifier = this.mWindowMagnifiers.get(displayId);     // Catch: Throwable -> L8
        if (magnifier != null) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        magnifier.setScale(scale);     // Catch: Throwable -> L8
        this.mLastActivatedScale.put(displayId, Float.valueOf(scale));     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public boolean enableWindowMagnification(int displayId, float scale, float centerX, float centerY) {
        return enableWindowMagnification(displayId, scale, centerX, centerY, MagnificationAnimationCallback.STUB_ANIMATION_CALLBACK, 0);
    }

    public boolean enableWindowMagnification(int displayId, float scale, float centerX, float centerY, MagnificationAnimationCallback animationCallback, int id) {
        return enableWindowMagnification(displayId, scale, centerX, centerY, animationCallback, 0, id);
    }

    public boolean enableWindowMagnification(int displayId, float scale, float centerX, float centerY, int windowPosition) {
        return enableWindowMagnification(displayId, scale, centerX, centerY, MagnificationAnimationCallback.STUB_ANIMATION_CALLBACK, windowPosition, 0);
    }

    public boolean enableWindowMagnification(int displayId, float scale, float centerX, float centerY, MagnificationAnimationCallback animationCallback, int windowPosition, int id) {
        Object r1 = this.mLock;
        monitor-enter(r1);
        WindowMagnifier magnifier = this.mWindowMagnifiers.get(displayId);     // Catch: Throwable -> L7
        if (magnifier != null) goto L9;
        WindowMagnifier magnifier2 = createWindowMagnifier(displayId);     // Catch: Throwable -> L7
    L10:
        boolean previousEnabled = WindowMagnifier.m842$$Nest$fgetmEnabled(magnifier2);     // Catch: Throwable -> L7
        boolean enabled = magnifier2.enableWindowMagnificationInternal(scale, centerX, centerY, animationCallback, windowPosition, id);     // Catch: Throwable -> L7
        if (enabled == false) goto L13;
        this.mLastActivatedScale.put(displayId, Float.valueOf(getScale(displayId)));     // Catch: Throwable -> L7
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L7
        if (enabled == false) goto L18;
        setTrackingTypingFocusEnabled(displayId, true);
        if (previousEnabled == true) goto L18;
        this.mCallback.onWindowMagnificationActivationState(displayId, true);
    L18:
        return enabled;
    L9:
        magnifier2 = magnifier;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean disableWindowMagnification(int displayId, boolean clear) {
        return disableWindowMagnification(displayId, clear, MagnificationAnimationCallback.STUB_ANIMATION_CALLBACK);
    }

    public boolean disableWindowMagnification(int displayId, boolean clear, MagnificationAnimationCallback animationCallback) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        WindowMagnifier magnifier = this.mWindowMagnifiers.get(displayId);     // Catch: Throwable -> L8
        if (magnifier != null) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return false;
    L10:
        boolean disabled = magnifier.disableWindowMagnificationInternal(animationCallback);     // Catch: Throwable -> L8
        if (clear == false) goto L13;
        this.mWindowMagnifiers.delete(displayId);     // Catch: Throwable -> L8
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L8
        if (disabled == false) goto L16;
        this.mCallback.onWindowMagnificationActivationState(displayId, false);
    L16:
        return disabled;
    L8:
        th = move-exception;
        throw th;
    }

    public boolean onFullscreenMagnificationActivationChanged(int displayId, boolean activated) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (waitConnectionWithTimeoutIfNeeded() == true) goto L12;
        Slog.w(TAG, "onFullscreenMagnificationActivationChanged mConnectionWrapper is null. mConnectionState=" + connectionStateToString(this.mConnectionState));     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return false;
    L12:
        boolean r1 = this.mConnectionWrapper.onFullscreenMagnificationActivationChanged(displayId, activated);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r1;
    }

    int pointersInWindow(int displayId, MotionEvent motionEvent) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        WindowMagnifier magnifier = this.mWindowMagnifiers.get(displayId);     // Catch: Throwable -> L9
        if (magnifier != null) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L9
        return 0;
    L11:
        int r2 = magnifier.pointersInWindow(motionEvent);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L9:
        th = move-exception;
        throw th;
    }

    boolean isPositionInSourceBounds(int displayId, float x, float y) {
        WindowMagnifier magnifier = this.mWindowMagnifiers.get(displayId);
        if (magnifier != null) goto L7;
        return false;
    L7:
        return magnifier.isPositionInSourceBounds(x, y);
    }

    public boolean isWindowMagnifierEnabled(int displayId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        WindowMagnifier magnifier = this.mWindowMagnifiers.get(displayId);     // Catch: Throwable -> L9
        if (magnifier != null) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L9
        return false;
    L11:
        boolean r2 = magnifier.isEnabled();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L9:
        th = move-exception;
        throw th;
    }

    float getPersistedScale(int displayId) {
        return MathUtils.constrain(this.mScaleProvider.getScale(displayId), 1.3f, MagnificationScaleProvider.MAX_SCALE);
    }

    void persistScale(int displayId) {
        float scale = getScale(displayId);
        if (scale >= 1.3f) goto L5;
        return;
    L5:
        this.mScaleProvider.putScale(scale, displayId);
    }

    @Override // com.android.server.accessibility.magnification.PanningScalingHandler.MagnificationDelegate
    public float getScale(int displayId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        WindowMagnifier magnifier = this.mWindowMagnifiers.get(displayId);     // Catch: Throwable -> L12
        if (magnifier == null) goto L14;
        if (WindowMagnifier.m842$$Nest$fgetmEnabled(magnifier) == false) goto L14;
        float r2 = magnifier.getScale();     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r2;
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return 1.0f;
    L12:
        th = move-exception;
        throw th;
    }

    protected float getLastActivatedScale(int displayId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mLastActivatedScale.contains(displayId) == true) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L9
        return -1.0f;
    L11:
        float r1 = this.mLastActivatedScale.get(displayId).floatValue();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r1;
    }

    void moveWindowMagnification(int displayId, float offsetX, float offsetY) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        WindowMagnifier magnifier = this.mWindowMagnifiers.get(displayId);     // Catch: Throwable -> L8
        if (magnifier != null) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        magnifier.move(offsetX, offsetY);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public boolean showMagnificationButton(int displayId, int magnificationMode) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mConnectionWrapper != null) goto L7;
    L11:
        boolean r1 = false;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r1;
    L7:
        if (this.mConnectionWrapper.showMagnificationButton(displayId, magnificationMode) == false) goto L11;
        r1 = true;
        goto L12
    }

    public boolean removeMagnificationButton(int displayId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mConnectionWrapper != null) goto L7;
    L11:
        boolean r1 = false;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r1;
    L7:
        if (this.mConnectionWrapper.removeMagnificationButton(displayId) == false) goto L11;
        r1 = true;
        goto L12
    }

    public boolean removeMagnificationSettingsPanel(int displayId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mConnectionWrapper != null) goto L7;
    L11:
        boolean r1 = false;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r1;
    L7:
        if (this.mConnectionWrapper.removeMagnificationSettingsPanel(displayId) == false) goto L11;
        r1 = true;
        goto L12
    }

    public boolean onUserMagnificationScaleChanged(int userId, int displayId, float scale) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mConnectionWrapper != null) goto L7;
    L11:
        boolean r1 = false;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r1;
    L7:
        if (this.mConnectionWrapper.onUserMagnificationScaleChanged(userId, displayId, scale) == false) goto L11;
        r1 = true;
        goto L12
    }

    public float getCenterX(int displayId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        WindowMagnifier magnifier = this.mWindowMagnifiers.get(displayId);     // Catch: Throwable -> L12
        if (magnifier == null) goto L14;
        if (WindowMagnifier.m842$$Nest$fgetmEnabled(magnifier) == false) goto L14;
        float r2 = magnifier.getCenterX();     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r2;
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return Float.NaN;
    L12:
        th = move-exception;
        throw th;
    }

    public float getCenterY(int displayId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        WindowMagnifier magnifier = this.mWindowMagnifiers.get(displayId);     // Catch: Throwable -> L12
        if (magnifier == null) goto L14;
        if (WindowMagnifier.m842$$Nest$fgetmEnabled(magnifier) == false) goto L14;
        float r2 = magnifier.getCenterY();     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r2;
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return Float.NaN;
    L12:
        th = move-exception;
        throw th;
    }

    boolean isTrackingTypingFocusEnabled(int displayId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        WindowMagnifier magnifier = this.mWindowMagnifiers.get(displayId);     // Catch: Throwable -> L9
        if (magnifier != null) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L9
        return false;
    L11:
        boolean r2 = magnifier.isTrackingTypingFocusEnabled();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L9:
        th = move-exception;
        throw th;
    }

    public void getMagnificationSourceBounds(int displayId, Region outRegion) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        WindowMagnifier magnifier = this.mWindowMagnifiers.get(displayId);     // Catch: Throwable -> L10
        if (magnifier == null) goto L12;
        if (WindowMagnifier.m842$$Nest$fgetmEnabled(magnifier) == false) goto L12;
        outRegion.set(WindowMagnifier.m844$$Nest$fgetmSourceBounds(magnifier));     // Catch: Throwable -> L10
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L12:
        outRegion.setEmpty();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    private WindowMagnifier createWindowMagnifier(int displayId) {
        WindowMagnifier magnifier = new WindowMagnifier(displayId, this);
        this.mWindowMagnifiers.put(displayId, magnifier);
        return magnifier;
    }

    public void onDisplayRemoved(int displayId) {
        disableWindowMagnification(displayId, true);
    }

    private boolean enableWindowMagnificationInternal(int displayId, float scale, float centerX, float centerY, float magnificationFrameOffsetRatioX, float magnificationFrameOffsetRatioY, MagnificationAnimationCallback animationCallback) {
        if (waitConnectionWithTimeoutIfNeeded() == true) goto L7;
        Slog.w(TAG, "enableWindowMagnificationInternal mConnectionWrapper is null. mConnectionState=" + connectionStateToString(this.mConnectionState));
        return false;
    L7:
        return this.mConnectionWrapper.enableWindowMagnification(displayId, scale, centerX, centerY, magnificationFrameOffsetRatioX, magnificationFrameOffsetRatioY, animationCallback);
    }

    private boolean setScaleForWindowMagnificationInternal(int displayId, float scale) {
        if (this.mConnectionWrapper != null) goto L5;
    L7:
        return false;
    L5:
        if (this.mConnectionWrapper.setScaleForWindowMagnification(displayId, scale) == false) goto L7;
        return true;
    }

    private boolean disableWindowMagnificationInternal(int displayId, MagnificationAnimationCallback animationCallback) {
        if (this.mConnectionWrapper != null) goto L7;
        Slog.w(TAG, "mConnectionWrapper is null");
        return false;
    L7:
        return this.mConnectionWrapper.disableWindowMagnification(displayId, animationCallback);
    }

    private boolean moveWindowMagnifierInternal(int displayId, float offsetX, float offsetY) {
        if (this.mConnectionWrapper != null) goto L5;
    L7:
        return false;
    L5:
        if (this.mConnectionWrapper.moveWindowMagnifier(displayId, offsetX, offsetY) == false) goto L7;
        return true;
    }

    private boolean moveWindowMagnifierToPositionInternal(int displayId, float positionX, float positionY, MagnificationAnimationCallback animationCallback) {
        if (this.mConnectionWrapper != null) goto L5;
    L7:
        return false;
    L5:
        if (this.mConnectionWrapper.moveWindowMagnifierToPosition(displayId, positionX, positionY, animationCallback) == false) goto L7;
        return true;
    }

    boolean waitConnectionWithTimeoutIfNeeded() {
        long endMillis = SystemClock.uptimeMillis() + ((long) WAIT_CONNECTION_TIMEOUT_MILLIS);
    L4:
        if (this.mConnectionState != 0) goto L12;
        if (SystemClock.uptimeMillis() >= endMillis) goto L12;
        this.mLock.wait(endMillis - SystemClock.uptimeMillis());     // Catch: InterruptedException -> L9
    L12:
        return isConnected();
    }
}
