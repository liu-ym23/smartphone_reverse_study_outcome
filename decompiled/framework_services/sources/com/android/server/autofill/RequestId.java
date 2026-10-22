package com.android.server.autofill;

import android.util.Slog;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class RequestId {
    static final int MAGIC_NUMBER = 5000;
    static final int MAX_PRIMARY_REQUEST_ID = 32766;
    static final int MAX_REQUEST_ID = 32767;
    static final int MAX_SECONDARY_REQUEST_ID = 32767;
    static final int MAX_START_ID = 1000;
    static final int MIN_PRIMARY_REQUEST_ID = 2;
    static final int MIN_REQUEST_ID = 2;
    static final int MIN_SECONDARY_REQUEST_ID = 3;
    private static final String TAG = "RequestId";
    private AtomicInteger sIdCounter;

    RequestId(int startId) {
        if (startId < 2) goto L12;
        if (startId > 32767) goto L12;
        if (Helper.sDebug == false) goto L9;
        Slog.d(TAG, "RequestId(int): startId= " + startId);
    L9:
        this.sIdCounter = new AtomicInteger(startId);
        return;
    L12:
        throw new IllegalArgumentException("startId must be between 2 and 32767");
    }

    int getRequestId() {
        return this.sIdCounter.get();
    }

    public RequestId() {
        Random random = new Random();
        int startId = random.nextInt(1001 - 2) + 2;
        if (Helper.sDebug == false) goto L5;
        Slog.d(TAG, "RequestId(): startId= " + startId);
    L5:
        this.sIdCounter = new AtomicInteger(startId);
    }

    public static int getLastRequestIdIndex(List<Integer> requestIds) {
        if (requestIds.size() != 1) goto L6;
        return 0;
    L6:
        boolean wrapHasHappened = false;
        int latestRequestIdIndex = -1;
        int i = 0;
    L8:
        if (i >= (requestIds.size() - 1)) goto L13;
        if ((requestIds.get(i + 1).intValue() - requestIds.get(i).intValue()) > 5000) goto L11;
        i = i + 1;
        goto L8
    L11:
        wrapHasHappened = true;
        latestRequestIdIndex = i;
    L13:
        if (wrapHasHappened == true) goto L16;
        latestRequestIdIndex = requestIds.size() - 1;
    L16:
        if (Helper.sDebug == false) goto L18;
        Slog.d(TAG, "getLastRequestIdIndex(): latestRequestIdIndex = " + latestRequestIdIndex);
    L18:
        return latestRequestIdIndex;
    }

    public int nextId(boolean isSecondary) {
    L2:
        int requestId = this.sIdCounter.incrementAndGet() % 32768;
        if (requestId >= 2) goto L5;
        requestId = 2;
    L5:
        this.sIdCounter.set(requestId);
        if (isSecondaryProvider(requestId) != isSecondary) goto L2;
        if (Helper.sDebug == false) goto L10;
        Slog.d(TAG, "nextId(): requestId = " + requestId);
    L10:
        return requestId;
    }

    public static boolean isSecondaryProvider(int requestId) {
        if ((requestId % 2) == 1) goto L7;
        return false;
    L7:
        return true;
    }
}
