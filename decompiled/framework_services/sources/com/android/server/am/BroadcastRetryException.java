package com.android.server.am;

/* JADX INFO: loaded from: classes.dex */
public class BroadcastRetryException extends BroadcastDeliveryFailedException {
    public BroadcastRetryException(String name) {
        super(name);
    }

    public BroadcastRetryException(Exception cause) {
        super(cause);
    }
}
