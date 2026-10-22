package com.android.server.accessibility.gestures;

import android.content.Context;
import android.graphics.Point;
import android.util.Slog;
import android.view.MotionEvent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import com.android.server.accessibility.AccessibilityManagerService;
import com.android.server.accessibility.EventStreamTransformation;

/* JADX INFO: loaded from: classes.dex */
class EventDispatcher {
    private static final int CLICK_LOCATION_ACCESSIBILITY_FOCUS = 1;
    private static final int CLICK_LOCATION_LAST_TOUCH_EXPLORED = 2;
    private static final int CLICK_LOCATION_NONE = 0;
    private static final String LOG_TAG = "EventDispatcher";
    private final AccessibilityManagerService mAms;
    private Context mContext;
    private int mLongPressingPointerDeltaX;
    private int mLongPressingPointerDeltaY;
    private int mLongPressingPointerId;
    private EventStreamTransformation mReceiver;
    private TouchState mState;
    private final Point mTempPoint;

    EventDispatcher(Context context, AccessibilityManagerService ams, EventStreamTransformation receiver, TouchState state) {
        this.mLongPressingPointerId = -1;
        this.mTempPoint = new Point();
        this.mContext = context;
        this.mAms = ams;
        this.mReceiver = receiver;
        this.mState = state;
    }

    public void setReceiver(EventStreamTransformation receiver) {
        this.mReceiver = receiver;
    }

    void sendMotionEvent(MotionEvent prototype, int action, MotionEvent rawEvent, int pointerIdBits, int policyFlags) {
        prototype.setAction(action);
        if (pointerIdBits != (-1)) goto L30;
        MotionEvent event = prototype;
    L6:
        if (action != 0) goto L8;
        long downTime = event.getEventTime();
    L9:
        MotionEvent.PointerProperties[] properties = new MotionEvent.PointerProperties[event.getPointerCount()];
        MotionEvent.PointerCoords[] coords = new MotionEvent.PointerCoords[event.getPointerCount()];
        int i = 0;
    L11:
        if (i >= event.getPointerCount()) goto L13;
        MotionEvent.PointerCoords c = new MotionEvent.PointerCoords();
        event.getPointerCoords(i, c);
        coords[i] = c;
        MotionEvent.PointerProperties p = new MotionEvent.PointerProperties();
        event.getPointerProperties(i, p);
        properties[i] = p;
        i = i + 1;
        goto L11
    L13:
        MotionEvent event2 = MotionEvent.obtain(downTime, event.getEventTime(), event.getAction(), event.getPointerCount(), properties, coords, event.getMetaState(), event.getButtonState(), event.getXPrecision(), event.getYPrecision(), rawEvent.getDeviceId(), event.getEdgeFlags(), rawEvent.getSource(), event.getDisplayId(), event.getFlags(), event.getClassification());
        if (this.mLongPressingPointerId < 0) goto L17;
        event2 = offsetEvent(event2, -this.mLongPressingPointerDeltaX, -this.mLongPressingPointerDeltaY);
    L17:
        if (TouchExplorer.DEBUG == false) goto L19;
        Slog.d(LOG_TAG, "Injecting event: " + event2 + ", policyFlags=0x" + Integer.toHexString(policyFlags));
    L19:
        int policyFlags2 = policyFlags | 1073741824;
        if (this.mReceiver == null) goto L22;
        this.mReceiver.onMotionEvent(event2, rawEvent, policyFlags2);
    L23:
        this.mState.onInjectedMotionEvent(event2);
        if (event2 == prototype) goto L33;
        event2.recycle();
        return;
    L33:
        return;
    L22:
        Slog.e(LOG_TAG, "Error sending event: no receiver specified.");
        goto L23
    L8:
        downTime = this.mState.getLastInjectedDownEventTime();
        goto L9
    L30:
        event = prototype.split(pointerIdBits);     // Catch: IllegalArgumentException -> L27
    L27:
        e = move-exception;
        Slog.e(LOG_TAG, "sendMotionEvent: Failed to split motion event: " + e);
    }

    void sendAccessibilityEvent(int type) {
        AccessibilityManager accessibilityManager = AccessibilityManager.getInstance(this.mContext);
        if (accessibilityManager.isEnabled() == false) goto L7;
        AccessibilityEvent event = AccessibilityEvent.obtain(type);
        event.setWindowId(this.mAms.getActiveWindowId());
        accessibilityManager.sendAccessibilityEvent(event);
        if (TouchExplorer.DEBUG == false) goto L7;
        Slog.d(LOG_TAG, "Sending accessibility event" + AccessibilityEvent.eventTypeToString(type));
    L7:
        this.mState.onInjectedAccessibilityEvent(type);
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("=========================");
        builder.append("\nDown pointers #");
        builder.append(Integer.bitCount(this.mState.getInjectedPointersDown()));
        builder.append(" [ ");
        int i = 0;
    L4:
        if (i >= 32) goto L9;
        if (this.mState.isInjectedPointerDown(i) == false) goto L8;
        builder.append(i);
        builder.append(" ");
    L8:
        i = i + 1;
        goto L4
    L9:
        builder.append("]");
        builder.append("\n=========================");
        return builder.toString();
    }

    private MotionEvent offsetEvent(MotionEvent event, int offsetX, int offsetY) {
        if (offsetX != 0) goto L6;
        if (offsetY != 0) goto L6;
        return event;
    L6:
        int remappedIndex = event.findPointerIndex(this.mLongPressingPointerId);
        int pointerCount = event.getPointerCount();
        MotionEvent.PointerProperties[] props = MotionEvent.PointerProperties.createArray(pointerCount);
        MotionEvent.PointerCoords[] coords = MotionEvent.PointerCoords.createArray(pointerCount);
        int i = 0;
    L7:
        if (i >= pointerCount) goto L13;
        event.getPointerProperties(i, props[i]);
        event.getPointerCoords(i, coords[i]);
        if (i != remappedIndex) goto L11;
        coords[i].x += offsetX;
        coords[i].y += offsetY;
    L11:
        i = i + 1;
        goto L7
    L13:
        return MotionEvent.obtain(event.getDownTime(), event.getEventTime(), event.getAction(), event.getPointerCount(), props, coords, event.getMetaState(), event.getButtonState(), 1.0f, 1.0f, event.getDeviceId(), event.getEdgeFlags(), event.getSource(), event.getDisplayId(), event.getFlags());
    }

    private int computeInjectionAction(int actionMasked, int pointerIndex) {
        switch(actionMasked) {
            case 0: goto L10;
            case 5: goto L10;
            case 6: goto L5;
            default: goto L3;
        };
    L3:
        return actionMasked;
    L5:
        if (this.mState.getInjectedPointerDownCount() != 1) goto L8;
        return 1;
    L8:
        return (pointerIndex << 8) | 6;
    L10:
        if (this.mState.getInjectedPointerDownCount() != 0) goto L14;
        return 0;
    L14:
        return (pointerIndex << 8) | 5;
    }

    void sendDownForAllNotInjectedPointers(MotionEvent prototype, int policyFlags) {
        int pointerIdBits = 0;
        int pointerCount = prototype.getPointerCount();
        int i = 0;
    L3:
        if (i >= pointerCount) goto L10;
        int pointerId = prototype.getPointerId(i);
        if (this.mState.isInjectedPointerDown(pointerId) == true) goto L7;
        int pointerIdBits2 = pointerIdBits | (1 << pointerId);
        int action = computeInjectionAction(0, i);
        MotionEvent prototype2 = prototype;
        int policyFlags2 = policyFlags;
        sendMotionEvent(prototype2, action, this.mState.getLastReceivedRawEvent(), pointerIdBits2, policyFlags2);
        pointerIdBits = pointerIdBits2;
    L8:
        i = i + 1;
        prototype = prototype2;
        policyFlags = policyFlags2;
        goto L3
    L7:
        prototype2 = prototype;
        policyFlags2 = policyFlags;
        goto L8
    }

    void sendDownForAllNotInjectedPointersWithOriginalDown(MotionEvent prototype, int policyFlags) {
        int pointerIdBits = 0;
        int pointerCount = prototype.getPointerCount();
        MotionEvent event = computeInjectionDownEvent(prototype);
        int i = 0;
    L3:
        if (i >= pointerCount) goto L10;
        int pointerId = prototype.getPointerId(i);
        if (this.mState.isInjectedPointerDown(pointerId) == true) goto L7;
        int pointerIdBits2 = pointerIdBits | (1 << pointerId);
        int action = computeInjectionAction(0, i);
        int policyFlags2 = policyFlags;
        sendMotionEvent(event, action, this.mState.getLastReceivedRawEvent(), pointerIdBits2, policyFlags2);
        pointerIdBits = pointerIdBits2;
    L8:
        i = i + 1;
        policyFlags = policyFlags2;
        goto L3
    L7:
        policyFlags2 = policyFlags;
        goto L8
    }

    private MotionEvent computeInjectionDownEvent(MotionEvent prototype) {
        int pointerCount = prototype.getPointerCount();
        if (pointerCount == this.mState.getReceivedPointerTracker().getReceivedPointerDownCount()) goto L6;
        Slog.w(LOG_TAG, "The pointer count doesn't match the received count.");
        return MotionEvent.obtain(prototype);
    L6:
        MotionEvent.PointerCoords[] coords = new MotionEvent.PointerCoords[pointerCount];
        MotionEvent.PointerProperties[] properties = new MotionEvent.PointerProperties[pointerCount];
        int i = 0;
    L7:
        if (i >= pointerCount) goto L9;
        int pointerId = prototype.getPointerId(i);
        float x = this.mState.getReceivedPointerTracker().getReceivedPointerDownX(pointerId);
        float y = this.mState.getReceivedPointerTracker().getReceivedPointerDownY(pointerId);
        coords[i] = new MotionEvent.PointerCoords();
        coords[i].x = x;
        coords[i].y = y;
        properties[i] = new MotionEvent.PointerProperties();
        properties[i].id = pointerId;
        properties[i].toolType = 1;
        i = i + 1;
        goto L7
    L9:
        MotionEvent event = MotionEvent.obtain(prototype.getDownTime(), prototype.getDownTime(), prototype.getAction(), pointerCount, properties, coords, prototype.getMetaState(), prototype.getButtonState(), prototype.getXPrecision(), prototype.getYPrecision(), prototype.getDeviceId(), prototype.getEdgeFlags(), prototype.getSource(), prototype.getFlags());
        return event;
    }

    void sendUpForInjectedDownPointers(MotionEvent prototype, int policyFlags) {
        int pointerIdBits = prototype.getPointerIdBits();
        int pointerCount = prototype.getPointerCount();
        int i = 0;
        int pointerIdBits2 = pointerIdBits;
    L3:
        if (i >= pointerCount) goto L10;
        int pointerId = prototype.getPointerId(i);
        if (this.mState.isInjectedPointerDown(pointerId) == true) goto L7;
        MotionEvent prototype2 = prototype;
        int policyFlags2 = policyFlags;
    L8:
        i = i + 1;
        prototype = prototype2;
        policyFlags = policyFlags2;
        goto L3
    L7:
        int action = computeInjectionAction(6, i);
        prototype2 = prototype;
        policyFlags2 = policyFlags;
        sendMotionEvent(prototype2, action, this.mState.getLastReceivedRawEvent(), pointerIdBits2, policyFlags2);
        pointerIdBits2 = (~(1 << pointerId)) & pointerIdBits2;
        goto L8
    }

    public boolean longPressWithTouchEvents(MotionEvent event, int policyFlags) {
        Point clickLocation = this.mTempPoint;
        int result = computeClickLocation(clickLocation);
        if (result != 0) goto L5;
        return false;
    L5:
        if (event == null) goto L8;
        int pointerIndex = event.getActionIndex();
        int pointerId = event.getPointerId(pointerIndex);
        this.mLongPressingPointerId = pointerId;
        this.mLongPressingPointerDeltaX = ((int) event.getX(pointerIndex)) - clickLocation.x;
        this.mLongPressingPointerDeltaY = ((int) event.getY(pointerIndex)) - clickLocation.y;
        sendDownForAllNotInjectedPointers(event, policyFlags);
        return true;
    L8:
        return false;
    }

    void clear() {
        this.mLongPressingPointerId = -1;
        this.mLongPressingPointerDeltaX = 0;
        this.mLongPressingPointerDeltaY = 0;
    }

    public void clickWithTouchEvents(MotionEvent event, MotionEvent rawEvent, int policyFlags) {
        int pointerIndex = event.getActionIndex();
        event.getPointerId(pointerIndex);
        Point clickLocation = this.mTempPoint;
        int result = computeClickLocation(clickLocation);
        if (result != 0) goto L6;
        Slog.e(LOG_TAG, "Unable to compute click location.");
        return;
    L6:
        boolean targetAccessibilityFocus = true;
        MotionEvent.PointerProperties[] properties = {new MotionEvent.PointerProperties()};
        event.getPointerProperties(pointerIndex, properties[0]);
        MotionEvent.PointerCoords[] coords = {new MotionEvent.PointerCoords()};
        coords[0].x = clickLocation.x;
        coords[0].y = clickLocation.y;
        MotionEvent clickEvent = MotionEvent.obtain(event.getDownTime(), event.getEventTime(), 0, 1, properties, coords, 0, 0, 1.0f, 1.0f, event.getDeviceId(), 0, event.getSource(), event.getDisplayId(), event.getFlags());
        if (result == 1) goto L10;
        targetAccessibilityFocus = false;
    L10:
        sendActionDownAndUp(clickEvent, rawEvent, policyFlags, targetAccessibilityFocus);
        clickEvent.recycle();
    }

    private int computeClickLocation(Point outLocation) {
        if (this.mState.getLastInjectedHoverEventForClick() == null) goto L14;
        int lastExplorePointerIndex = this.mState.getLastInjectedHoverEventForClick().getActionIndex();
        outLocation.x = (int) this.mState.getLastInjectedHoverEventForClick().getX(lastExplorePointerIndex);
        outLocation.y = (int) this.mState.getLastInjectedHoverEventForClick().getY(lastExplorePointerIndex);
        if (this.mAms.accessibilityFocusOnlyInActiveWindow() == false) goto L9;
        if (this.mState.getLastTouchedWindowId() != this.mAms.getActiveWindowId()) goto L14;
    L9:
        if (this.mAms.getAccessibilityFocusClickPointInScreen(outLocation) == false) goto L11;
        return 1;
    L11:
        return 2;
    L14:
        if (this.mAms.getAccessibilityFocusClickPointInScreen(outLocation) == false) goto L16;
        return 1;
    L16:
        return 0;
    }

    private void sendActionDownAndUp(MotionEvent prototype, MotionEvent rawEvent, int policyFlags, boolean targetAccessibilityFocus) {
        int pointerId = prototype.getPointerId(prototype.getActionIndex());
        int pointerIdBits = 1 << pointerId;
        prototype.setTargetAccessibilityFocus(targetAccessibilityFocus);
        sendMotionEvent(prototype, 0, rawEvent, pointerIdBits, policyFlags);
        prototype.setTargetAccessibilityFocus(targetAccessibilityFocus);
        sendMotionEvent(prototype, 1, rawEvent, pointerIdBits, policyFlags);
    }
}
