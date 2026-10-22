package com.ttnet.org.chromium.base.metrics;

import com.ttnet.org.chromium.base.annotations.CalledByNative;

/* JADX INFO: loaded from: classes4.dex */
public interface RecordUserAction$UserActionCallback {
    @CalledByNative("UserActionCallback")
    void onActionRecorded(String r10);
}
