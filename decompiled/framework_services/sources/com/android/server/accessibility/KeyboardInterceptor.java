package com.android.server.accessibility;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pools;
import android.util.Slog;
import android.view.KeyEvent;
import com.android.server.policy.WindowManagerPolicy;

/* JADX INFO: loaded from: classes.dex */
public class KeyboardInterceptor extends BaseEventStreamTransformation implements Handler.Callback {
    private static final String LOG_TAG = "KeyboardInterceptor";
    private static final int MESSAGE_PROCESS_QUEUED_EVENTS = 1;
    private final AccessibilityManagerService mAms;
    private KeyEventHolder mEventQueueEnd;
    private KeyEventHolder mEventQueueStart;
    private final Handler mHandler;
    private final WindowManagerPolicy mPolicy;

    private static class KeyEventHolder {
        private static final int MAX_POOL_SIZE = 32;
        private static final Pools.SimplePool<KeyEventHolder> sPool = null;
        public long dispatchTime;
        public KeyEvent event;
        public KeyEventHolder next;
        public int policyFlags;
        public KeyEventHolder previous;

        private KeyEventHolder() {
        }

        static {
            sPool = new Pools.SimplePool(32);
        }

        public static KeyEventHolder obtain(KeyEvent event, int policyFlags, long dispatchTime) {
            KeyEventHolder holder = (KeyEventHolder) sPool.acquire();
            if (holder != null) goto L5;
            holder = new KeyEventHolder();
        L5:
            holder.event = KeyEvent.obtain(event);
            holder.policyFlags = policyFlags;
            holder.dispatchTime = dispatchTime;
            return holder;
        }

        public void recycle() {
            this.event.recycle();
            this.event = null;
            this.policyFlags = 0;
            this.dispatchTime = 0;
            this.next = null;
            this.previous = null;
            sPool.release(this);
        }
    }

    public KeyboardInterceptor(AccessibilityManagerService service, WindowManagerPolicy policy) {
        this.mAms = service;
        this.mPolicy = policy;
        this.mHandler = new Handler(this);
    }

    public KeyboardInterceptor(AccessibilityManagerService service, WindowManagerPolicy policy, Handler handler) {
        this.mAms = service;
        this.mPolicy = policy;
        this.mHandler = handler;
    }

    @Override // com.android.server.accessibility.EventStreamTransformation
    public void onKeyEvent(KeyEvent event, int policyFlags) {
        if (this.mAms.getTraceManager().isA11yTracingEnabledForTypes(4096) == false) goto L5;
        this.mAms.getTraceManager().logTrace("KeyboardInterceptor.onKeyEvent", 4096, "event=" + event + ";policyFlags=" + policyFlags);
    L5:
        long eventDelay = getEventDelay(event, policyFlags);
        if (eventDelay >= 0) goto L9;
        return;
    L9:
        if (eventDelay <= 0) goto L11;
    L15:
        addEventToQueue(event, policyFlags, eventDelay);
        return;
    L11:
        if (this.mEventQueueStart != null) goto L15;
        this.mAms.notifyKeyEvent(event, policyFlags);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message msg) {
        if (msg.what == 1) goto L6;
        Slog.e(LOG_TAG, "Unexpected message type");
        return false;
    L6:
        processQueuedEvents();
        if (this.mEventQueueStart == null) goto L9;
        scheduleProcessQueuedEvents();
    L9:
        return true;
    }

    private void addEventToQueue(KeyEvent event, int policyFlags, long delay) {
        long dispatchTime = SystemClock.uptimeMillis() + delay;
        if (this.mEventQueueStart != null) goto L6;
        KeyEventHolder r2 = KeyEventHolder.obtain(event, policyFlags, dispatchTime);
        this.mEventQueueStart = r2;
        this.mEventQueueEnd = r2;
        scheduleProcessQueuedEvents();
        return;
    L6:
        KeyEventHolder holder = KeyEventHolder.obtain(event, policyFlags, dispatchTime);
        holder.next = this.mEventQueueStart;
        this.mEventQueueStart.previous = holder;
        this.mEventQueueStart = holder;
    }

    private void scheduleProcessQueuedEvents() {
        if (this.mHandler.sendEmptyMessageAtTime(1, this.mEventQueueEnd.dispatchTime) == true) goto L6;
        Slog.e(LOG_TAG, "Failed to schedule key event");
        return;
    }

    private void processQueuedEvents() {
        long currentTime = SystemClock.uptimeMillis();
    L4:
        if (this.mEventQueueEnd == null) goto L21;
        if (this.mEventQueueEnd.dispatchTime > currentTime) goto L29;
        long eventDelay = getEventDelay(this.mEventQueueEnd.event, this.mEventQueueEnd.policyFlags);
        if (eventDelay > 0) goto L9;
        if (eventDelay != 0) goto L14;
        this.mAms.notifyKeyEvent(this.mEventQueueEnd.event, this.mEventQueueEnd.policyFlags);
    L14:
        KeyEventHolder eventToBeRecycled = this.mEventQueueEnd;
        this.mEventQueueEnd = this.mEventQueueEnd.previous;
        if (this.mEventQueueEnd == null) goto L17;
        this.mEventQueueEnd.next = null;
    L17:
        eventToBeRecycled.recycle();
        if (this.mEventQueueEnd != null) goto L4;
        this.mEventQueueStart = null;
        goto L4
    L9:
        long r5 = currentTime + eventDelay;
        this.mEventQueueEnd.dispatchTime = r5;
        return;
    L29:
        return;
    }

    private long getEventDelay(KeyEvent event, int policyFlags) {
        int keyCode = event.getKeyCode();
        if (keyCode == 25) goto L10;
        if (keyCode == 24) goto L10;
        return 0;
    L10:
        return this.mPolicy.interceptKeyBeforeDispatching(null, event, policyFlags);
    }
}
