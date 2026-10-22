package com.android.server.location.contexthub;

import android.hardware.location.NanoAppMessage;
import android.util.Log;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes2.dex */
public class ContextHubTestModeManager {
    private static final int DROP_MESSAGE_TO_CONTEXT_HUB_EVENT = 1;
    private static final int DROP_MESSAGE_TO_HOST_EVENT = 0;
    private static final int DUPLICATE_MESSAGE_TO_CONTEXT_HUB_EVENT = 3;
    private static final int DUPLICATE_MESSAGE_TO_HOST_EVENT = 2;
    private static final int NUMBER_OF_EVENTS = 4;
    private static final int NUM_MESSAGES_TO_DUPLICATE = 3;
    private static final String TAG = "ContextHubTestModeManager";
    private final AtomicLong mCounter;

    public ContextHubTestModeManager() {
        this.mCounter = new AtomicLong(0);
    }

    public boolean handleNanoappMessage(Runnable handleMessage, NanoAppMessage message) {
        if (message.isReliable() == true) goto L5;
        return false;
    L5:
        long counterValue = this.mCounter.getAndIncrement();
        if ((counterValue % 4) != 2) goto L14;
        Log.i(TAG, "[TEST MODE] Duplicating message to host (3 sends) with message sequence number: " + message.getMessageSequenceNumber());
        int i = 0;
    L9:
        if (i >= 3) goto L12;
        handleMessage.run();
        i = i + 1;
        goto L9
    L12:
        return true;
    L14:
        if ((counterValue % 4) != 0) goto L17;
        Log.i(TAG, "[TEST MODE] Dropping message to host with message sequence number: " + message.getMessageSequenceNumber());
        return true;
    L17:
        return false;
    }

    public boolean sendMessageToContextHub(Callable<Integer> sendMessage, NanoAppMessage message) {
        if (message.isReliable() == true) goto L5;
        return false;
    L5:
        long counterValue = this.mCounter.getAndIncrement();
        if ((counterValue % 4) != 3) goto L22;
        Log.i(TAG, "[TEST MODE] Duplicating message to the Context Hub (3 sends) with message sequence number: " + message.getMessageSequenceNumber());
        int i = 0;
    L9:
        if (i >= 3) goto L20;
        int result = sendMessage.call().intValue();     // Catch: Exception -> L14
        if (result == 0) goto L18;
        Log.e(TAG, "sendMessage returned an error: " + result);     // Catch: Exception -> L14
    L18:
        i = i + 1;
    L14:
        e = move-exception;
        Log.e(TAG, "Exception in sendMessageToContextHub: " + e.getMessage());
        goto L18
    L20:
        return true;
    L22:
        if ((counterValue % 4) != 1) goto L25;
        Log.i(TAG, "[TEST MODE] Dropping message to the Context Hub with message sequence number: " + message.getMessageSequenceNumber());
        return true;
    L25:
        return false;
    }
}
