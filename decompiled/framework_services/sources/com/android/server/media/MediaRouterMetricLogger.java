package com.android.server.media;

import android.util.Log;
import android.util.Slog;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
final class MediaRouterMetricLogger {
    private static final boolean DEBUG = false;
    private static final int REQUEST_INFO_CACHE_CAPACITY = 100;
    private static final String TAG = "MediaRouterMetricLogger";
    private final RequestInfoCache mRequestInfoCache;

    static class RequestInfo {
        public final int mEventType;
        public final long mUniqueRequestId;

        RequestInfo(long uniqueRequestId, int eventType) {
            this.mUniqueRequestId = uniqueRequestId;
            this.mEventType = eventType;
        }

        public void dump(PrintWriter pw, String prefix) {
            pw.println(prefix + "RequestInfo");
            String indent = prefix + "  ";
            pw.println(indent + "mUniqueRequestId=" + this.mUniqueRequestId);
            pw.println(indent + "mEventType=" + this.mEventType);
        }
    }

    class RequestInfoCache extends LinkedHashMap<Long, RequestInfo> {
        public final int capacity;
        final /* synthetic */ MediaRouterMetricLogger this$0;

        public RequestInfoCache(MediaRouterMetricLogger this$0, int capacity) {
            this.this$0 = this$0;
            super(capacity, 1.0f, true);
            this.capacity = capacity;
        }

        @Override // java.util.LinkedHashMap
        protected boolean removeEldestEntry(Map.Entry<Long, RequestInfo> eldest) {
            if (size() <= this.capacity) goto L5;
            boolean shouldRemove = true;
        L6:
            if (shouldRemove == false) goto L8;
            Slog.d(MediaRouterMetricLogger.TAG, "Evicted request info: " + eldest.getValue());
            this.this$0.logOperationTriggered(eldest.getValue().mEventType, 0);
        L8:
            return shouldRemove;
        L5:
            shouldRemove = false;
            goto L6
        }
    }

    static {
        DEBUG = Log.isLoggable(TAG, 3);
    }

    public MediaRouterMetricLogger() {
        this.mRequestInfoCache = new RequestInfoCache(this, 100);
    }

    public void addRequestInfo(long uniqueRequestId, int eventType) {
        RequestInfo requestInfo = new RequestInfo(uniqueRequestId, eventType);
        this.mRequestInfoCache.put(Long.valueOf(requestInfo.mUniqueRequestId), requestInfo);
    }

    public void removeRequestInfo(long uniqueRequestId) {
        this.mRequestInfoCache.remove(Long.valueOf(uniqueRequestId));
    }

    public void logOperationFailure(int eventType, int result) {
        logMediaRouterEvent(eventType, result);
    }

    public void logOperationTriggered(int eventType, int result) {
        logMediaRouterEvent(eventType, result);
    }

    public void logRequestResult(long uniqueRequestId, int result) {
        RequestInfo requestInfo = this.mRequestInfoCache.get(Long.valueOf(uniqueRequestId));
        if (requestInfo != null) goto L6;
        Slog.w(TAG, "logRequestResult: No RequestInfo found for uniqueRequestId=" + uniqueRequestId);
        return;
    L6:
        int eventType = requestInfo.mEventType;
        logMediaRouterEvent(eventType, result);
        removeRequestInfo(uniqueRequestId);
    }

    public void updateScanningState(boolean isScanning) {
        if (isScanning == true) goto L4;
        logScanningStopped();
        return;
    L4:
        logScanningStarted();
    }

    private void logScanningStarted() {
        logMediaRouterEvent(7, 0);
    }

    private void logScanningStopped() {
        logMediaRouterEvent(8, 0);
    }

    public static int convertResultFromReason(int reason) {
        switch(reason) {
            case 0: goto L17;
            case 1: goto L15;
            case 2: goto L13;
            case 3: goto L11;
            case 4: goto L9;
            case 5: goto L7;
            case 6: goto L5;
            default: goto L3;
        };
    L3:
        return 0;
    L5:
        return 8;
    L7:
        return 7;
    L9:
        return 6;
    L11:
        return 5;
    L13:
        return 4;
    L15:
        return 3;
    L17:
        return 2;
    }

    public int getRequestCacheSize() {
        return this.mRequestInfoCache.size();
    }

    private void logMediaRouterEvent(int eventType, int result) {
        MediaRouterStatsLog.write(1017, eventType, result);
        if (DEBUG == false) goto L6;
        Slog.d(TAG, "logMediaRouterEvent: " + eventType + " " + result);
        return;
    }
}
