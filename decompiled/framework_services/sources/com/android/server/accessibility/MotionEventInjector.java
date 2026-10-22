package com.android.server.accessibility;

import android.accessibilityservice.GestureDescription;
import android.accessibilityservice.IAccessibilityServiceClient;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.IntArray;
import android.util.Slog;
import android.util.SparseIntArray;
import android.view.MotionEvent;
import com.android.internal.os.SomeArgs;
import com.android.server.usb.descriptors.UsbACInterface;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MotionEventInjector extends BaseEventStreamTransformation implements Handler.Callback {
    private static final int EVENT_BUTTON_STATE = 0;
    private static final int EVENT_EDGE_FLAGS = 0;
    private static final int EVENT_FLAGS = 0;
    private static final int EVENT_META_STATE = 0;
    private static final int EVENT_SOURCE = 4098;
    private static final float EVENT_X_PRECISION = 1.0f;
    private static final float EVENT_Y_PRECISION = 1.0f;
    private static final String LOG_TAG = "MotionEventInjector";
    private static final int MESSAGE_INJECT_EVENTS = 2;
    private static final int MESSAGE_SEND_MOTION_EVENT = 1;
    private static MotionEvent.PointerCoords[] sPointerCoords;
    private static MotionEvent.PointerProperties[] sPointerProps;
    private long mDownTime;
    private final Handler mHandler;
    private boolean mIsDestroyed;
    private long mLastScheduledEventTime;
    private GestureDescription.TouchPoint[] mLastTouchPoints;
    private int mNumLastTouchPoints;
    private boolean mOpenTouchGestureInProgress;
    private IntArray mSequencesInProgress;
    private IAccessibilityServiceClient mServiceInterfaceForCurrentGesture;
    private SparseIntArray mStrokeIdToPointerId;
    private final AccessibilityTraceManager mTrace;

    public MotionEventInjector(Looper looper, AccessibilityTraceManager trace) {
        this.mOpenTouchGestureInProgress = false;
        this.mSequencesInProgress = new IntArray(5);
        this.mIsDestroyed = false;
        this.mStrokeIdToPointerId = new SparseIntArray(5);
        this.mHandler = new Handler(looper, this);
        this.mTrace = trace;
    }

    public MotionEventInjector(Handler handler, AccessibilityTraceManager trace) {
        this.mOpenTouchGestureInProgress = false;
        this.mSequencesInProgress = new IntArray(5);
        this.mIsDestroyed = false;
        this.mStrokeIdToPointerId = new SparseIntArray(5);
        this.mHandler = handler;
        this.mTrace = trace;
    }

    public void injectEvents(List<GestureDescription.GestureStep> r5, IAccessibilityServiceClient r6, int r7, int r8, boolean r9) {
        SomeArgs r0 = SomeArgs.obtain();
        r0.arg1 = r5;
        r0.arg2 = r6;
        r0.argi1 = r7;
        r0.argi2 = r8;
        r0.argi3 = r9 ? 1 : 0;
        this.mHandler.sendMessage(this.mHandler.obtainMessage(2, r0));
    }

    @Override // com.android.server.accessibility.EventStreamTransformation
    public void onMotionEvent(MotionEvent event, MotionEvent rawEvent, int policyFlags) {
        if (this.mTrace.isA11yTracingEnabledForTypes(12288) == false) goto L6;
        this.mTrace.logTrace("MotionEventInjector.onMotionEvent", 12288, "event=" + event + ";rawEvent=" + rawEvent + ";policyFlags=" + policyFlags);
    L6:
        if (event.isFromSource(UsbACInterface.FORMAT_III_IEC1937_MPEG1_Layer1) == true) goto L8;
    L12:
        super.onMotionEvent(event, rawEvent, policyFlags);
        return;
    L8:
        if (event.getActionMasked() != 7) goto L12;
        if (this.mOpenTouchGestureInProgress == false) goto L12;
    }

    @Override // com.android.server.accessibility.EventStreamTransformation
    public void clearEvents(int inputSource) {
        if (this.mHandler.hasMessages(1) == false) goto L5;
        return;
    L5:
        if (inputSource != 4098) goto L9;
        this.mOpenTouchGestureInProgress = false;
        return;
    }

    @Override // com.android.server.accessibility.EventStreamTransformation
    public void onDestroy() {
        cancelAnyPendingInjectedEvents();
        this.mIsDestroyed = true;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what != 2) goto L11;
        SomeArgs args = (SomeArgs) message.obj;
        List<GestureDescription.GestureStep> r5 = (List) args.arg1;
        IAccessibilityServiceClient r6 = (IAccessibilityServiceClient) args.arg2;
        int r7 = args.argi1;
        int r8 = args.argi2;
        if (args.argi3 != 1) goto L7;
        boolean r9 = true;
    L8:
        injectEventsMainThread(r5, r6, r7, r8, r9);
        args.recycle();
        return true;
    L7:
        r9 = false;
        goto L8
    L11:
        if (message.what == 1) goto L14;
        Slog.e(LOG_TAG, "Unknown message: " + message.what);
        return false;
    L14:
        MotionEvent motionEvent = (MotionEvent) message.obj;
        int policyFlags = 1073872896;
        if (message.arg2 != 1) goto L17;
        boolean fromAccessibilityTool = true;
    L18:
        if (fromAccessibilityTool == false) goto L20;
        policyFlags = 1073872896 | 524288;
    L20:
        sendMotionEventToNext(motionEvent, motionEvent, policyFlags);
        if (message.arg1 == 0) goto L23;
        boolean isEndOfSequence = true;
    L24:
        if (isEndOfSequence == false) goto L26;
        notifyService(this.mServiceInterfaceForCurrentGesture, this.mSequencesInProgress.get(0), true);
        this.mSequencesInProgress.remove(0);
    L26:
        return true;
    L23:
        isEndOfSequence = false;
        goto L24
    L17:
        fromAccessibilityTool = false;
        goto L18
    }

    private void injectEventsMainThread(List<GestureDescription.GestureStep> r19, IAccessibilityServiceClient r20, int r21, int r22, boolean r23) {
        int r4 = 0;
        if (this.mIsDestroyed == false) goto L10;
        r20.onPerformGestureResult(r21, false);     // Catch: RemoteException -> L6
        return;
    L6:
        e = move-exception;
        Slog.e(LOG_TAG, "Error sending status with mIsDestroyed to " + r20, e);
        return;
    L10:
        if (getNext() != null) goto L13;
        notifyService(r20, r21, false);
        return;
    L13:
        boolean r0 = newGestureTriesToContinueOldOne(r19);
        if (r0 == true) goto L16;
    L21:
        if (r0 == true) goto L23;
        cancelAnyPendingInjectedEvents();
    L23:
        this.mServiceInterfaceForCurrentGesture = r20;
        long r5 = SystemClock.uptimeMillis();
        if (this.mSequencesInProgress.size() != 0) goto L26;
        long r7 = r5;
    L27:
        List<MotionEvent> r8 = getMotionEventsFromGestureSteps(r19, r7);
        if (r8.isEmpty() == false) goto L31;
        notifyService(r20, r21, false);
        return;
    L31:
        this.mSequencesInProgress.add(r21);
        int r9 = 0;
    L33:
        if (r9 >= r8.size()) goto L40;
        MotionEvent r10 = r8.get(r9);
        r10.setDisplayId(r22);
        if (r9 != (r8.size() - 1)) goto L37;
        int r12 = 1;
    L38:
        Message r13 = this.mHandler.obtainMessage(1, r12, r23 ? 1 : 0, r10);
        long r16 = r5;
        this.mLastScheduledEventTime = r10.getEventTime();
        this.mHandler.sendMessageDelayed(r13, Math.max(0, r10.getEventTime() - r16));
        r9 = r9 + 1;
        r5 = r16;
        r4 = 0;
        goto L33
    L37:
        r12 = r4;
        goto L38
    L40:
        return;
    L26:
        r7 = this.mLastScheduledEventTime;
        goto L27
    L16:
        if (r20 == this.mServiceInterfaceForCurrentGesture) goto L18;
    L19:
        cancelAnyPendingInjectedEvents();
        notifyService(r20, r21, false);
        return;
    L18:
        if (prepareToContinueOldGesture(r19) == true) goto L21;
        goto L19
    }

    private boolean newGestureTriesToContinueOldOne(List<GestureDescription.GestureStep> gestureSteps) {
        if (gestureSteps.isEmpty() == false) goto L5;
        return false;
    L5:
        GestureDescription.GestureStep firstStep = gestureSteps.get(0);
        int i = 0;
    L7:
        if (i >= firstStep.numTouchPoints) goto L14;
        if (firstStep.touchPoints[i].mIsStartOfPath == false) goto L10;
        i = i + 1;
        goto L7
    L10:
        return true;
    L14:
        return false;
    }

    private boolean prepareToContinueOldGesture(List<GestureDescription.GestureStep> gestureSteps) {
        if (gestureSteps.isEmpty() == false) goto L5;
    L44:
        return false;
    L5:
        if (this.mLastTouchPoints == null) goto L44;
        if (this.mNumLastTouchPoints == 0) goto L44;
        GestureDescription.GestureStep firstStep = gestureSteps.get(0);
        int numContinuedStrokes = 0;
        int i = 0;
    L11:
        if (i >= firstStep.numTouchPoints) goto L33;
        GestureDescription.TouchPoint touchPoint = firstStep.touchPoints[i];
        if (touchPoint.mIsStartOfPath == true) goto L32;
        int continuedPointerId = this.mStrokeIdToPointerId.get(touchPoint.mContinuedStrokeId, -1);
        if (continuedPointerId == (-1)) goto L16;
        this.mStrokeIdToPointerId.put(touchPoint.mStrokeId, continuedPointerId);
        int lastPointIndex = findPointByStrokeId(this.mLastTouchPoints, this.mNumLastTouchPoints, touchPoint.mContinuedStrokeId);
        if (lastPointIndex < 0) goto L20;
        if (this.mLastTouchPoints[lastPointIndex].mIsEndOfPath == true) goto L30;
        if (this.mLastTouchPoints[lastPointIndex].mX != touchPoint.mX) goto L30;
        if (this.mLastTouchPoints[lastPointIndex].mY != touchPoint.mY) goto L30;
        this.mLastTouchPoints[lastPointIndex].mStrokeId = touchPoint.mStrokeId;
    L30:
        Slog.w(LOG_TAG, "Can't continue gesture due to points mismatch between " + this.mLastTouchPoints[lastPointIndex] + " and " + touchPoint);
        return false;
    L20:
        Slog.w(LOG_TAG, "Can't continue gesture due continued gesture id of " + touchPoint + " not matching any previous strokes in " + Arrays.asList(this.mLastTouchPoints));
        return false;
    L16:
        Slog.w(LOG_TAG, "Can't continue gesture due to unknown continued stroke id in " + touchPoint);
        return false;
    L32:
        numContinuedStrokes = numContinuedStrokes + 1;
        i = i + 1;
        goto L11
    L33:
        int i2 = 0;
    L35:
        if (i2 >= this.mNumLastTouchPoints) goto L41;
        if (this.mLastTouchPoints[i2].mIsEndOfPath == true) goto L39;
        numContinuedStrokes = numContinuedStrokes - 1;
    L39:
        i2 = i2 + 1;
        goto L35
    L41:
        if (numContinuedStrokes != 0) goto L56;
        return true;
    L56:
        return false;
    }

    private void sendMotionEventToNext(MotionEvent event, MotionEvent rawEvent, int policyFlags) {
        if (getNext() == null) goto L15;
        super.onMotionEvent(event, rawEvent, policyFlags);
        if (event.getSource() == 4098) goto L7;
        return;
    L7:
        if (event.getActionMasked() != 0) goto L10;
        this.mOpenTouchGestureInProgress = true;
    L10:
        if (event.getActionMasked() != 1) goto L12;
    L13:
        this.mOpenTouchGestureInProgress = false;
        return;
    L12:
        if (event.getActionMasked() == 3) goto L13;
        return;
    }

    private void cancelInjectedGestureInProgress() {
        if (getNext() == null) goto L8;
        if (this.mOpenTouchGestureInProgress == false) goto L8;
        long now = SystemClock.uptimeMillis();
        MotionEvent cancelEvent = obtainMotionEvent(now, now, 3, getLastTouchPoints(), 1);
        int policyFlags = 1073872896 | 524288;
        sendMotionEventToNext(cancelEvent, cancelEvent, policyFlags);
        this.mOpenTouchGestureInProgress = false;
        return;
    }

    private void cancelAnyPendingInjectedEvents() {
        if (this.mHandler.hasMessages(1) == false) goto L9;
        this.mHandler.removeMessages(1);
        cancelInjectedGestureInProgress();
        int i = this.mSequencesInProgress.size() - 1;
    L5:
        if (i < 0) goto L11;
        notifyService(this.mServiceInterfaceForCurrentGesture, this.mSequencesInProgress.get(i), false);
        this.mSequencesInProgress.remove(i);
        i = i - 1;
    L11:
        this.mNumLastTouchPoints = 0;
        this.mStrokeIdToPointerId.clear();
        return;
    L9:
        if (this.mNumLastTouchPoints == 0) goto L11;
        cancelInjectedGestureInProgress();
        goto L11
    }

    private void notifyService(IAccessibilityServiceClient service, int sequence, boolean success) {
        service.onPerformGestureResult(sequence, success);     // Catch: RemoteException -> L4
        return;
    L4:
        re = move-exception;
        Slog.e(LOG_TAG, "Error sending motion event injection status to " + this.mServiceInterfaceForCurrentGesture, re);
    }

    private List<MotionEvent> getMotionEventsFromGestureSteps(List<GestureDescription.GestureStep> steps, long startTime) {
        List<MotionEvent> motionEvents = new ArrayList();
        GestureDescription.TouchPoint[] lastTouchPoints = getLastTouchPoints();
        int i = 0;
    L4:
        if (i >= steps.size()) goto L11;
        GestureDescription.GestureStep step = steps.get(i);
        int currentTouchPointSize = step.numTouchPoints;
        if (currentTouchPointSize > lastTouchPoints.length) goto L7;
        appendMoveEventIfNeeded(motionEvents, step.touchPoints, currentTouchPointSize, step.timeSinceGestureStart + startTime);
        appendUpEvents(motionEvents, step.touchPoints, currentTouchPointSize, step.timeSinceGestureStart + startTime);
        appendDownEvents(motionEvents, step.touchPoints, currentTouchPointSize, step.timeSinceGestureStart + startTime);
        i = i + 1;
        goto L4
    L7:
        this.mNumLastTouchPoints = 0;
        motionEvents.clear();
        return motionEvents;
    L11:
        return motionEvents;
    }

    private GestureDescription.TouchPoint[] getLastTouchPoints() {
        if (this.mLastTouchPoints != null) goto L8;
        int capacity = GestureDescription.getMaxStrokeCount();
        this.mLastTouchPoints = new GestureDescription.TouchPoint[capacity];
        int i = 0;
    L5:
        if (i >= capacity) goto L8;
        this.mLastTouchPoints[i] = new GestureDescription.TouchPoint();
        i = i + 1;
    L8:
        return this.mLastTouchPoints;
    }

    private void appendMoveEventIfNeeded(List<MotionEvent> motionEvents, GestureDescription.TouchPoint[] currentTouchPoints, int currentTouchPointsSize, long currentTime) {
        boolean moveFound = false;
        GestureDescription.TouchPoint[] lastTouchPoints = getLastTouchPoints();
        int i = 0;
    L3:
        if (i >= currentTouchPointsSize) goto L16;
        int lastPointsIndex = findPointByStrokeId(lastTouchPoints, this.mNumLastTouchPoints, currentTouchPoints[i].mStrokeId);
        if (lastPointsIndex < 0) goto L14;
        if (lastTouchPoints[lastPointsIndex].mX == currentTouchPoints[i].mX) goto L9;
    L12:
        boolean r3 = true;
    L13:
        moveFound = moveFound | r3;
        lastTouchPoints[lastPointsIndex].copyFrom(currentTouchPoints[i]);
        goto L14
    L9:
        if (lastTouchPoints[lastPointsIndex].mY != currentTouchPoints[i].mY) goto L12;
        r3 = false;
    L14:
        i = i + 1;
        goto L3
    L16:
        if (moveFound == false) goto L19;
        motionEvents.add(obtainMotionEvent(this.mDownTime, currentTime, 2, lastTouchPoints, this.mNumLastTouchPoints));
        return;
    }

    private void appendUpEvents(List<MotionEvent> motionEvents, GestureDescription.TouchPoint[] currentTouchPoints, int currentTouchPointsSize, long currentTime) {
        GestureDescription.TouchPoint[] lastTouchPoints = getLastTouchPoints();
        int i = 0;
    L3:
        if (i >= currentTouchPointsSize) goto L22;
        if (currentTouchPoints[i].mIsEndOfPath == false) goto L20;
        int indexOfUpEvent = findPointByStrokeId(lastTouchPoints, this.mNumLastTouchPoints, currentTouchPoints[i].mStrokeId);
        if (indexOfUpEvent < 0) goto L20;
        if (this.mNumLastTouchPoints != 1) goto L12;
        int action = 1;
    L13:
        motionEvents.add(obtainMotionEvent(this.mDownTime, currentTime, action | (indexOfUpEvent << 8), lastTouchPoints, this.mNumLastTouchPoints));
        int j = indexOfUpEvent;
    L15:
        if (j >= (this.mNumLastTouchPoints - 1)) goto L17;
        lastTouchPoints[j].copyFrom(this.mLastTouchPoints[j + 1]);
        j = j + 1;
        goto L15
    L17:
        int j2 = this.mNumLastTouchPoints;
        this.mNumLastTouchPoints = j2 - 1;
        if (this.mNumLastTouchPoints != 0) goto L20;
        this.mStrokeIdToPointerId.clear();
        goto L20
    L12:
        action = 6;
    L20:
        i = i + 1;
        goto L3
    }

    private void appendDownEvents(List<MotionEvent> motionEvents, GestureDescription.TouchPoint[] currentTouchPoints, int currentTouchPointsSize, long currentTime) {
        GestureDescription.TouchPoint[] lastTouchPoints = getLastTouchPoints();
        int i = 0;
    L3:
        if (i >= currentTouchPointsSize) goto L17;
        if (currentTouchPoints[i].mIsStartOfPath == false) goto L14;
        int r0 = this.mNumLastTouchPoints;
        this.mNumLastTouchPoints = r0 + 1;
        lastTouchPoints[r0].copyFrom(currentTouchPoints[i]);
        if (this.mNumLastTouchPoints != 1) goto L9;
        int action = 0;
    L11:
        if (action != 0) goto L13;
        this.mDownTime = currentTime;
    L13:
        long currentTime2 = currentTime;
        motionEvents.add(obtainMotionEvent(this.mDownTime, currentTime2, action | (i << 8), lastTouchPoints, this.mNumLastTouchPoints));
    L15:
        i = i + 1;
        currentTime = currentTime2;
        goto L3
    L9:
        action = 5;
        goto L11
    L14:
        currentTime2 = currentTime;
        goto L15
    }

    private MotionEvent obtainMotionEvent(long downTime, long eventTime, int action, GestureDescription.TouchPoint[] touchPoints, int touchPointsSize) {
        if (sPointerCoords != null) goto L5;
    L6:
        sPointerCoords = new MotionEvent.PointerCoords[touchPointsSize];
        int i = 0;
    L7:
        if (i >= touchPointsSize) goto L10;
        sPointerCoords[i] = new MotionEvent.PointerCoords();
        i = i + 1;
    L10:
        if (sPointerProps != null) goto L12;
    L13:
        sPointerProps = new MotionEvent.PointerProperties[touchPointsSize];
        int i2 = 0;
    L14:
        if (i2 >= touchPointsSize) goto L16;
        sPointerProps[i2] = new MotionEvent.PointerProperties();
        i2 = i2 + 1;
    L16:
        int i3 = 0;
    L17:
        if (i3 >= touchPointsSize) goto L23;
        int pointerId = this.mStrokeIdToPointerId.get(touchPoints[i3].mStrokeId, -1);
        if (pointerId != (-1)) goto L21;
        pointerId = getUnusedPointerId();
        this.mStrokeIdToPointerId.put(touchPoints[i3].mStrokeId, pointerId);
    L21:
        sPointerProps[i3].id = pointerId;
        sPointerProps[i3].toolType = 0;
        sPointerCoords[i3].clear();
        sPointerCoords[i3].pressure = 1.0f;
        sPointerCoords[i3].size = 1.0f;
        MotionEvent.PointerCoords r3 = sPointerCoords[i3];
        r3.x = touchPoints[i3].mX;
        MotionEvent.PointerCoords r4 = sPointerCoords[i3];
        r4.y = touchPoints[i3].mY;
        i3 = i3 + 1;
        goto L17
    L23:
        return MotionEvent.obtain(downTime, eventTime, action, touchPointsSize, sPointerProps, sPointerCoords, 0, 0, 1.0f, 1.0f, -1, 0, 4098, 0);
    L12:
        if (sPointerProps.length >= touchPointsSize) goto L16;
    L5:
        if (sPointerCoords.length >= touchPointsSize) goto L10;
        goto L6
    }

    private static int findPointByStrokeId(GestureDescription.TouchPoint[] touchPoints, int touchPointsSize, int strokeId) {
        int i = 0;
    L3:
        if (i >= touchPointsSize) goto L8;
        if (touchPoints[i].mStrokeId == strokeId) goto L6;
        i = i + 1;
        goto L3
    L6:
        return i;
    L8:
        return -1;
    }

    private int getUnusedPointerId() {
        int pointerId = 0;
    L4:
        if (this.mStrokeIdToPointerId.indexOfValue(pointerId) < 0) goto L8;
        pointerId = pointerId + 1;
        if (pointerId < 10) goto L4;
        return 10;
    L8:
        return pointerId;
    }
}
