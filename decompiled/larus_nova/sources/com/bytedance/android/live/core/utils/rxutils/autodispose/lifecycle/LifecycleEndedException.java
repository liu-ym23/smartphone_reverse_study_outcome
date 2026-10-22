package com.bytedance.android.live.core.utils.rxutils.autodispose.lifecycle;

import com.bytedance.android.live.core.utils.rxutils.autodispose.OutsideScopeException;

/* JADX INFO: loaded from: classes45.dex */
public class LifecycleEndedException extends OutsideScopeException {
    public LifecycleEndedException() {
        this("Lifecycle has ended!");
    }

    public LifecycleEndedException(String r100) {
        super(r100);
    }
}
