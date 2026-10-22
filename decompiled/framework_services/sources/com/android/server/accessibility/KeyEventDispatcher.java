package com.android.server.accessibility;

import android.os.Binder;
import android.os.Handler;
import android.os.Message;
import android.os.PowerManager;
import android.util.ArrayMap;
import android.util.Pools;
import android.util.Slog;
import android.view.InputEventConsistencyVerifier;
import android.view.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class KeyEventDispatcher implements Handler.Callback {
    private static final boolean DEBUG = false;
    private static final String LOG_TAG = "KeyEventDispatcher";
    private static final int MAX_POOL_SIZE = 10;
    public static final int MSG_ON_KEY_EVENT_TIMEOUT = 1;
    private static final long ON_KEY_EVENT_TIMEOUT_MILLIS = 500;
    private final Handler mHandlerToSendKeyEventsToInputFilter;
    private Handler mKeyEventTimeoutHandler;
    private final Object mLock;
    private final int mMessageTypeForSendKeyEvent;
    private final Pools.Pool<PendingKeyEvent> mPendingEventPool;
    private final Map<KeyEventFilter, ArrayList<PendingKeyEvent>> mPendingEventsMap;
    private final PowerManager mPowerManager;
    private final InputEventConsistencyVerifier mSentEventsVerifier;

    public interface KeyEventFilter {
        boolean onKeyEvent(KeyEvent r1, int r2);
    }

    private static final class PendingKeyEvent {
        KeyEvent event;
        boolean handled;
        int policyFlags;
        int referenceCount;

        /* synthetic */ PendingKeyEvent(KeyEventDispatcherIA r1) {
            this();
        }

        private PendingKeyEvent() {
        }
    }

    public KeyEventDispatcher(Handler handlerToSendKeyEventsToInputFilter, int messageTypeForSendKeyEvent, Object lock, PowerManager powerManager) {
        this.mPendingEventPool = new Pools.SimplePool(10);
        this.mPendingEventsMap = new ArrayMap();
        if (InputEventConsistencyVerifier.isInstrumentationEnabled() == false) goto L5;
        this.mSentEventsVerifier = new InputEventConsistencyVerifier(this, 0, KeyEventDispatcher.class.getSimpleName());
    L6:
        this.mHandlerToSendKeyEventsToInputFilter = handlerToSendKeyEventsToInputFilter;
        this.mMessageTypeForSendKeyEvent = messageTypeForSendKeyEvent;
        this.mKeyEventTimeoutHandler = new Handler(handlerToSendKeyEventsToInputFilter.getLooper(), this);
        this.mLock = lock;
        this.mPowerManager = powerManager;
        return;
    L5:
        this.mSentEventsVerifier = null;
        goto L6
    }

    public KeyEventDispatcher(Handler handlerToSendKeyEventsToInputFilter, int messageTypeForSendKeyEvent, Object lock, PowerManager powerManager, Handler timeoutHandler) {
        this(handlerToSendKeyEventsToInputFilter, messageTypeForSendKeyEvent, lock, powerManager);
        this.mKeyEventTimeoutHandler = timeoutHandler;
    }

    public boolean notifyKeyEventLocked(KeyEvent event, int policyFlags, List<? extends KeyEventFilter> keyEventFilters) {
        PendingKeyEvent pendingKeyEvent = null;
        KeyEvent localClone = KeyEvent.obtain(event);
        int i = 0;
    L4:
        if (i >= keyEventFilters.size()) goto L15;
        KeyEventFilter keyEventFilter = keyEventFilters.get(i);
        if (keyEventFilter.onKeyEvent(localClone, localClone.getSequenceNumber()) == false) goto L13;
        if (pendingKeyEvent != null) goto L9;
        pendingKeyEvent = obtainPendingEventLocked(localClone, policyFlags);
    L9:
        ArrayList<PendingKeyEvent> pendingEventList = this.mPendingEventsMap.get(keyEventFilter);
        if (pendingEventList != null) goto L12;
        pendingEventList = new ArrayList();
        this.mPendingEventsMap.put(keyEventFilter, pendingEventList);
    L12:
        pendingEventList.add(pendingKeyEvent);
        pendingKeyEvent.referenceCount++;
    L13:
        i = i + 1;
        goto L4
    L15:
        if (pendingKeyEvent != null) goto L18;
        localClone.recycle();
        return false;
    L18:
        Message message = this.mKeyEventTimeoutHandler.obtainMessage(1, pendingKeyEvent);
        this.mKeyEventTimeoutHandler.sendMessageDelayed(message, 500);
        return true;
    }

    public void setOnKeyEventResult(KeyEventFilter keyEventFilter, boolean handled, int sequence) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        PendingKeyEvent pendingEvent = removeEventFromListLocked(this.mPendingEventsMap.get(keyEventFilter), sequence);     // Catch: Throwable -> L12
        if (pendingEvent == null) goto L18;
        if (handled == true) goto L8;
    L17:
        removeReferenceToPendingEventLocked(pendingEvent);     // Catch: Throwable -> L12
        goto L18
    L8:
        if (pendingEvent.handled == true) goto L17;
        pendingEvent.handled = handled;     // Catch: Throwable -> L12
        long identity = Binder.clearCallingIdentity();     // Catch: Throwable -> L12
        this.mPowerManager.userActivity(pendingEvent.event.getEventTime(), 3, 0);     // Catch: Throwable -> L14
        Binder.restoreCallingIdentity(identity);     // Catch: Throwable -> L12
        goto L17
    L14:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);     // Catch: Throwable -> L12
        throw th;     // Catch: Throwable -> L12
    L18:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public void flush(KeyEventFilter keyEventFilter) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        List<PendingKeyEvent> pendingEvents = this.mPendingEventsMap.get(keyEventFilter);     // Catch: Throwable -> L10
        if (pendingEvents == null) goto L13;
        int i = 0;
    L8:
        if (i >= pendingEvents.size()) goto L12;
        PendingKeyEvent pendingEvent = pendingEvents.get(i);     // Catch: Throwable -> L10
        removeReferenceToPendingEventLocked(pendingEvent);     // Catch: Throwable -> L10
        i = i + 1;     // Catch: Throwable -> L10
        goto L8
    L12:
        this.mPendingEventsMap.remove(keyEventFilter);     // Catch: Throwable -> L10
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what == 1) goto L6;
        Slog.w(LOG_TAG, "Unknown message: " + message.what);
        return false;
    L6:
        PendingKeyEvent pendingKeyEvent = (PendingKeyEvent) message.obj;
        Object r2 = this.mLock;
        monitor-enter(r2);
        Iterator<ArrayList<PendingKeyEvent>> r3 = this.mPendingEventsMap.values().iterator();     // Catch: Throwable -> L16
    L10:
        if (r3.hasNext() == false) goto L19;
        ArrayList<PendingKeyEvent> listForService = r3.next();     // Catch: Throwable -> L16
        if (listForService.remove(pendingKeyEvent) == false) goto L10;
        if (removeReferenceToPendingEventLocked(pendingKeyEvent) == false) goto L10;
    L19:
        monitor-exit(r2);     // Catch: Throwable -> L16
        return true;
    L16:
        th = move-exception;
        throw th;
    }

    private PendingKeyEvent obtainPendingEventLocked(KeyEvent event, int policyFlags) {
        PendingKeyEvent pendingEvent = (PendingKeyEvent) this.mPendingEventPool.acquire();
        if (pendingEvent != null) goto L5;
        pendingEvent = new PendingKeyEvent(null);
    L5:
        pendingEvent.event = event;
        pendingEvent.policyFlags = policyFlags;
        pendingEvent.referenceCount = 0;
        pendingEvent.handled = false;
        return pendingEvent;
    }

    private static PendingKeyEvent removeEventFromListLocked(List<PendingKeyEvent> listOfEvents, int sequence) {
        int i = 0;
    L4:
        if (i >= listOfEvents.size()) goto L10;
        PendingKeyEvent pendingKeyEvent = listOfEvents.get(i);
        if (pendingKeyEvent.event.getSequenceNumber() == sequence) goto L7;
        i = i + 1;
        goto L4
    L7:
        listOfEvents.remove(pendingKeyEvent);
        return pendingKeyEvent;
    L10:
        return null;
    }

    private boolean removeReferenceToPendingEventLocked(PendingKeyEvent pendingEvent) {
        int r0 = pendingEvent.referenceCount - 1;
        pendingEvent.referenceCount = r0;
        if (r0 <= 0) goto L5;
        return false;
    L5:
        this.mKeyEventTimeoutHandler.removeMessages(1, pendingEvent);
        if (pendingEvent.handled == false) goto L8;
        pendingEvent.event.recycle();
    L12:
        this.mPendingEventPool.release(pendingEvent);
        return true;
    L8:
        if (this.mSentEventsVerifier == null) goto L10;
        this.mSentEventsVerifier.onKeyEvent(pendingEvent.event, 0);
    L10:
        int policyFlags = pendingEvent.policyFlags | 1073741824;
        this.mHandlerToSendKeyEventsToInputFilter.obtainMessage(this.mMessageTypeForSendKeyEvent, policyFlags, 0, pendingEvent.event).sendToTarget();
        goto L12
    }
}
