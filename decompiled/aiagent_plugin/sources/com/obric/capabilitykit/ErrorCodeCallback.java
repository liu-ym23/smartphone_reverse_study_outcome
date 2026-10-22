package com.obric.capabilitykit;

import com.obric.capabilitykit.common.IErrorCodeCallback;
import com.obric.capabilitykit.logger.Logger;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ErrorCodeCallback extends IErrorCodeCallback.Stub {
    public ErrorCodeCallback() {
    }

    @Override // com.obric.capabilitykit.common.IErrorCodeCallback
    public void onResult(int r3, String r4) {
        Logger.INSTANCE.i(AtomicCapabilitySdk.TAG, "AtomicCapabilitySdk onResult " + r3 + " resultMessage " + r4);
    }
}
