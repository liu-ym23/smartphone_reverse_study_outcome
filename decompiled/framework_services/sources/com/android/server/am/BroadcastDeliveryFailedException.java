package com.android.server.am;

import android.util.AndroidException;

/* JADX INFO: loaded from: classes.dex */
public class BroadcastDeliveryFailedException extends AndroidException {
    public BroadcastDeliveryFailedException(String name) {
        super(name);
    }

    public BroadcastDeliveryFailedException(Exception cause) {
        super(cause);
    }
}
