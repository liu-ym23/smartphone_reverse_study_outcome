package com.android.server.location.contexthub;

import android.hardware.location.NanoAppMessage;
import android.util.Log;
import java.util.Collection;
import java.util.Iterator;
import java.util.Optional;

/* JADX INFO: loaded from: classes2.dex */
public class ContextHubEventLogger {
    public static final int NUM_EVENTS_TO_STORE = 20;
    private static final String TAG = "ContextHubEventLogger";
    private static ContextHubEventLogger sInstance;
    private final ConcurrentLinkedEvictingDeque<ContextHubRestartEvent> mContextHubRestartEventQueue;
    private final ConcurrentLinkedEvictingDeque<NanoappMessageEvent> mMessageFromNanoappQueue;
    private final ConcurrentLinkedEvictingDeque<NanoappMessageEvent> mMessageToNanoappQueue;
    private final ConcurrentLinkedEvictingDeque<NanoappLoadEvent> mNanoappLoadEventQueue;
    private final ConcurrentLinkedEvictingDeque<NanoappUnloadEvent> mNanoappUnloadEventQueue;

    public static class ContextHubEventBase {
        public final int contextHubId;
        public final long timeStampInMs;

        public ContextHubEventBase(long mTimeStampInMs, int mContextHubId) {
            this.timeStampInMs = mTimeStampInMs;
            this.contextHubId = mContextHubId;
        }
    }

    public static class ContextHubRestartEvent extends ContextHubEventBase {
        public ContextHubRestartEvent(long mTimeStampInMs, int mContextHubId) {
            super(mTimeStampInMs, mContextHubId);
        }

        public String toString() {
            return ContextHubServiceUtil.formatDateFromTimestamp(this.timeStampInMs) + ": ContextHubRestartEvent[hubId = " + this.contextHubId + ']';
        }
    }

    public static class NanoappEventBase extends ContextHubEventBase {
        public final long nanoappId;
        public final boolean success;

        public NanoappEventBase(long mTimeStampInMs, int mContextHubId, long mNanoappId, boolean mSuccess) {
            super(mTimeStampInMs, mContextHubId);
            this.nanoappId = mNanoappId;
            this.success = mSuccess;
        }
    }

    public static class NanoappLoadEvent extends NanoappEventBase {
        public final long nanoappSize;
        public final int nanoappVersion;

        public NanoappLoadEvent(long mTimeStampInMs, int mContextHubId, long mNanoappId, int mNanoappVersion, long mNanoappSize, boolean mSuccess) {
            super(mTimeStampInMs, mContextHubId, mNanoappId, mSuccess);
            this.nanoappVersion = mNanoappVersion;
            this.nanoappSize = mNanoappSize;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(ContextHubServiceUtil.formatDateFromTimestamp(this.timeStampInMs));
            sb.append(": NanoappLoadEvent[hubId = ");
            sb.append(this.contextHubId);
            sb.append(", appId = 0x");
            sb.append(Long.toHexString(this.nanoappId));
            sb.append(", appVersion = ");
            sb.append(this.nanoappVersion);
            sb.append(", appSize = ");
            sb.append(this.nanoappSize);
            sb.append(" bytes, success = ");
            if (this.success == false) goto L5;
            String r1 = "true";
        L6:
            sb.append(r1);
            sb.append(']');
            return sb.toString();
        L5:
            r1 = "false";
            goto L6
        }
    }

    public static class NanoappMessageEvent extends NanoappEventBase {
        public Optional<Byte> errorCode;
        public final NanoAppMessage message;

        public NanoappMessageEvent(long mTimeStampInMs, int mContextHubId, NanoAppMessage mMessage, boolean mSuccess) {
            super(mTimeStampInMs, mContextHubId, 0, mSuccess);
            this.message = mMessage;
            this.errorCode = Optional.empty();
        }

        public void setErrorCode(byte errorCode) {
            this.errorCode = Optional.of(Byte.valueOf(errorCode));
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(ContextHubServiceUtil.formatDateFromTimestamp(this.timeStampInMs));
            sb.append(": NanoappMessageEvent[hubId = ");
            sb.append(this.contextHubId);
            sb.append(", ");
            sb.append(this.message.toString());
            sb.append(", success = ");
            if (this.success == false) goto L5;
            String r1 = "true";
        L6:
            sb.append(r1);
            sb.append(", errorCode = ");
            if (this.errorCode.isPresent() == false) goto L9;
            Object r2 = this.errorCode.get();
        L10:
            sb.append(r2);
            sb.append(']');
            return sb.toString();
        L9:
            r2 = "null";
            goto L10
        L5:
            r1 = "false";
            goto L6
        }
    }

    public static class NanoappUnloadEvent extends NanoappEventBase {
        public NanoappUnloadEvent(long mTimeStampInMs, int mContextHubId, long mNanoappId, boolean mSuccess) {
            super(mTimeStampInMs, mContextHubId, mNanoappId, mSuccess);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(ContextHubServiceUtil.formatDateFromTimestamp(this.timeStampInMs));
            sb.append(": NanoappUnloadEvent[hubId = ");
            sb.append(this.contextHubId);
            sb.append(", appId = 0x");
            sb.append(Long.toHexString(this.nanoappId));
            sb.append(", success = ");
            if (this.success == false) goto L5;
            String r1 = "true";
        L6:
            sb.append(r1);
            sb.append(']');
            return sb.toString();
        L5:
            r1 = "false";
            goto L6
        }
    }

    static {
        sInstance = null;
    }

    private ContextHubEventLogger() {
        this.mNanoappLoadEventQueue = new ConcurrentLinkedEvictingDeque(20);
        this.mNanoappUnloadEventQueue = new ConcurrentLinkedEvictingDeque(20);
        this.mMessageFromNanoappQueue = new ConcurrentLinkedEvictingDeque(20);
        this.mMessageToNanoappQueue = new ConcurrentLinkedEvictingDeque(20);
        this.mContextHubRestartEventQueue = new ConcurrentLinkedEvictingDeque(20);
    }

    public static synchronized ContextHubEventLogger getInstance() {
        monitor-enter(ContextHubEventLogger.class);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (sInstance != null) goto L9;
        sInstance = new ContextHubEventLogger();     // Catch: Throwable -> L7
    L9:
        ContextHubEventLogger r1 = sInstance;     // Catch: Throwable -> L7
        monitor-exit(ContextHubEventLogger.class);
        return r1;
    }

    public synchronized void clear() {
        monitor-enter(this);
        int r3 = 0;
        Collection<?>[] r1 = {this.mNanoappLoadEventQueue, this.mNanoappUnloadEventQueue, this.mMessageFromNanoappQueue, this.mMessageToNanoappQueue, this.mContextHubRestartEventQueue};     // Catch: Throwable -> L8
    L5:
        if (r3 >= 5) goto L10;
        Collection<?> deque = r1[r3];     // Catch: Throwable -> L8
        deque.clear();     // Catch: Throwable -> L8
        r3 = r3 + 1;
        goto L5
    L10:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public synchronized void logNanoappLoad(int contextHubId, long nanoappId, int nanoappVersion, long nanoappSize, boolean success) {
        monitor-enter(this);
        long timeStampInMs = System.currentTimeMillis();     // Catch: Throwable -> L7
        NanoappLoadEvent event = new NanoappLoadEvent(timeStampInMs, contextHubId, nanoappId, nanoappVersion, nanoappSize, success);     // Catch: Throwable -> L7
        boolean status = this.mNanoappLoadEventQueue.add(event);     // Catch: Throwable -> L7
        if (status == true) goto L9;
        Log.e(TAG, "Unable to add nanoapp load event to queue: " + event);     // Catch: Throwable -> L7
    L9:
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public synchronized void logNanoappUnload(int contextHubId, long nanoappId, boolean success) {
        monitor-enter(this);
        long timeStampInMs = System.currentTimeMillis();     // Catch: Throwable -> L7
        NanoappUnloadEvent event = new NanoappUnloadEvent(timeStampInMs, contextHubId, nanoappId, success);     // Catch: Throwable -> L7
        boolean status = this.mNanoappUnloadEventQueue.add(event);     // Catch: Throwable -> L7
        if (status == true) goto L9;
        Log.e(TAG, "Unable to add nanoapp unload event to queue: " + event);     // Catch: Throwable -> L7
    L9:
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public synchronized void logMessageFromNanoapp(int contextHubId, NanoAppMessage message, boolean success) {
        monitor-enter(this);
        if (message != null) goto L16;
        monitor-exit(this);
        return;
    L16:
        long timeStampInMs = System.currentTimeMillis();     // Catch: Throwable -> L10
        NanoappMessageEvent event = new NanoappMessageEvent(timeStampInMs, contextHubId, message, success);     // Catch: Throwable -> L10
        boolean status = this.mMessageFromNanoappQueue.add(event);     // Catch: Throwable -> L10
        if (status == true) goto L12;
        Log.e(TAG, "Unable to add message from nanoapp event to queue: " + event);     // Catch: Throwable -> L10
    L12:
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public synchronized void logMessageToNanoapp(int contextHubId, NanoAppMessage message, boolean success) {
        monitor-enter(this);
        if (message != null) goto L16;
        monitor-exit(this);
        return;
    L16:
        long timeStampInMs = System.currentTimeMillis();     // Catch: Throwable -> L10
        NanoappMessageEvent event = new NanoappMessageEvent(timeStampInMs, contextHubId, message, success);     // Catch: Throwable -> L10
        boolean status = this.mMessageToNanoappQueue.add(event);     // Catch: Throwable -> L10
        if (status == true) goto L12;
        Log.e(TAG, "Unable to add message to nanoapp event to queue: " + event);     // Catch: Throwable -> L10
    L12:
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public synchronized void logReliableMessageToNanoappStatus(int messageSequenceNumber, byte errorCode) {
        monitor-enter(this);
        Iterator<NanoappMessageEvent> r0 = this.mMessageToNanoappQueue.iterator();     // Catch: Throwable -> L12
    L5:
        if (r0.hasNext() == false) goto L15;
        NanoappMessageEvent event = r0.next();     // Catch: Throwable -> L12
        if (event.message.isReliable() == false) goto L5;
        if (event.message.getMessageSequenceNumber() != messageSequenceNumber) goto L5;
        event.setErrorCode(errorCode);     // Catch: Throwable -> L12
    L15:
        monitor-exit(this);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public synchronized void logContextHubRestart(int contextHubId) {
        monitor-enter(this);
        long timeStampInMs = System.currentTimeMillis();     // Catch: Throwable -> L7
        ContextHubRestartEvent event = new ContextHubRestartEvent(timeStampInMs, contextHubId);     // Catch: Throwable -> L7
        boolean status = this.mContextHubRestartEventQueue.add(event);     // Catch: Throwable -> L7
        if (status == true) goto L9;
        Log.e(TAG, "Unable to add Context Hub restart event to queue: " + event);     // Catch: Throwable -> L7
    L9:
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nanoapp Loads:");
        sb.append(System.lineSeparator());
        Iterator<NanoappLoadEvent> r1 = this.mNanoappLoadEventQueue.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        NanoappLoadEvent event = r1.next();
        sb.append(event);
        sb.append(System.lineSeparator());
        goto L4
    L6:
        sb.append(System.lineSeparator());
        sb.append("Nanoapp Unloads:");
        sb.append(System.lineSeparator());
        Iterator<NanoappUnloadEvent> r2 = this.mNanoappUnloadEventQueue.iterator();
    L8:
        if (r2.hasNext() == false) goto L10;
        NanoappUnloadEvent event2 = r2.next();
        sb.append(event2);
        sb.append(System.lineSeparator());
        goto L8
    L10:
        sb.append(System.lineSeparator());
        sb.append("Messages from Nanoapps:");
        sb.append(System.lineSeparator());
        Iterator<NanoappMessageEvent> r3 = this.mMessageFromNanoappQueue.iterator();
    L12:
        if (r3.hasNext() == false) goto L14;
        NanoappMessageEvent event3 = r3.next();
        sb.append(event3);
        sb.append(System.lineSeparator());
        goto L12
    L14:
        sb.append(System.lineSeparator());
        sb.append("Messages to Nanoapps:");
        sb.append(System.lineSeparator());
        Iterator<NanoappMessageEvent> r4 = this.mMessageToNanoappQueue.iterator();
    L16:
        if (r4.hasNext() == false) goto L18;
        NanoappMessageEvent event4 = r4.next();
        sb.append(event4);
        sb.append(System.lineSeparator());
        goto L16
    L18:
        sb.append(System.lineSeparator());
        sb.append("Context Hub Restarts:");
        sb.append(System.lineSeparator());
        Iterator<ContextHubRestartEvent> r5 = this.mContextHubRestartEventQueue.iterator();
    L20:
        if (r5.hasNext() == false) goto L23;
        ContextHubRestartEvent event5 = r5.next();
        sb.append(event5);
        sb.append(System.lineSeparator());
        goto L20
    L23:
        return sb.toString();
    }
}
